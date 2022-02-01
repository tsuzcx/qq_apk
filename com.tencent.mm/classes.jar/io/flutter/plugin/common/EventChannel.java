package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class EventChannel
{
  private static final String TAG = "EventChannel#";
  private final MethodCodec codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public EventChannel(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    this(paramBinaryMessenger, paramString, StandardMethodCodec.INSTANCE);
  }
  
  public EventChannel(BinaryMessenger paramBinaryMessenger, String paramString, MethodCodec paramMethodCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMethodCodec;
  }
  
  public final void setStreamHandler(StreamHandler paramStreamHandler)
  {
    AppMethodBeat.i(9835);
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramStreamHandler == null) {}
    for (paramStreamHandler = null;; paramStreamHandler = new IncomingStreamRequestHandler(paramStreamHandler))
    {
      localBinaryMessenger.setMessageHandler(str, paramStreamHandler);
      AppMethodBeat.o(9835);
      return;
    }
  }
  
  public static abstract interface EventSink
  {
    public abstract void endOfStream();
    
    public abstract void error(String paramString1, String paramString2, Object paramObject);
    
    public abstract void success(Object paramObject);
  }
  
  final class IncomingStreamRequestHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final AtomicReference<EventChannel.EventSink> activeSink;
    private final EventChannel.StreamHandler handler;
    
    IncomingStreamRequestHandler(EventChannel.StreamHandler paramStreamHandler)
    {
      AppMethodBeat.i(9843);
      this.activeSink = new AtomicReference(null);
      this.handler = paramStreamHandler;
      AppMethodBeat.o(9843);
    }
    
    private void onCancel(Object paramObject, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      AppMethodBeat.i(189810);
      if ((EventChannel.EventSink)this.activeSink.getAndSet(null) != null) {
        try
        {
          this.handler.onCancel(paramObject);
          paramBinaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope(null));
          AppMethodBeat.o(189810);
          return;
        }
        catch (RuntimeException paramObject)
        {
          Log.e("EventChannel#" + EventChannel.this.name, "Failed to close event stream", paramObject);
          paramBinaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", paramObject.getMessage(), null));
          AppMethodBeat.o(189810);
          return;
        }
      }
      paramBinaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", "No active stream to cancel", null));
      AppMethodBeat.o(189810);
    }
    
    private void onListen(Object paramObject, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      AppMethodBeat.i(189804);
      EventSinkImplementation localEventSinkImplementation = new EventSinkImplementation(null);
      if ((EventChannel.EventSink)this.activeSink.getAndSet(localEventSinkImplementation) != null) {}
      try
      {
        this.handler.onCancel(null);
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          try
          {
            this.handler.onListen(paramObject, localEventSinkImplementation);
            paramBinaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope(null));
            AppMethodBeat.o(189804);
            return;
          }
          catch (RuntimeException paramObject)
          {
            this.activeSink.set(null);
            Log.e("EventChannel#" + EventChannel.this.name, "Failed to open event stream", paramObject);
            paramBinaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", paramObject.getMessage(), null));
            AppMethodBeat.o(189804);
          }
          localRuntimeException = localRuntimeException;
          Log.e("EventChannel#" + EventChannel.this.name, "Failed to close existing event stream", localRuntimeException);
        }
      }
    }
    
    public final void onMessage(ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      AppMethodBeat.i(9844);
      paramByteBuffer = EventChannel.this.codec.decodeMethodCall(paramByteBuffer);
      if (paramByteBuffer.method.equals("listen"))
      {
        onListen(paramByteBuffer.arguments, paramBinaryReply);
        AppMethodBeat.o(9844);
        return;
      }
      if (paramByteBuffer.method.equals("cancel"))
      {
        onCancel(paramByteBuffer.arguments, paramBinaryReply);
        AppMethodBeat.o(9844);
        return;
      }
      paramBinaryReply.reply(null);
      AppMethodBeat.o(9844);
    }
    
    final class EventSinkImplementation
      implements EventChannel.EventSink
    {
      final AtomicBoolean hasEnded;
      
      private EventSinkImplementation()
      {
        AppMethodBeat.i(9831);
        this.hasEnded = new AtomicBoolean(false);
        AppMethodBeat.o(9831);
      }
      
      public final void endOfStream()
      {
        AppMethodBeat.i(9834);
        if ((this.hasEnded.getAndSet(true)) || (EventChannel.IncomingStreamRequestHandler.this.activeSink.get() != this))
        {
          AppMethodBeat.o(9834);
          return;
        }
        EventChannel.this.messenger.send(EventChannel.this.name, null);
        AppMethodBeat.o(9834);
      }
      
      public final void error(String paramString1, String paramString2, Object paramObject)
      {
        AppMethodBeat.i(9833);
        if ((this.hasEnded.get()) || (EventChannel.IncomingStreamRequestHandler.this.activeSink.get() != this))
        {
          AppMethodBeat.o(9833);
          return;
        }
        EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeErrorEnvelope(paramString1, paramString2, paramObject));
        AppMethodBeat.o(9833);
      }
      
      public final void success(Object paramObject)
      {
        AppMethodBeat.i(9832);
        if ((this.hasEnded.get()) || (EventChannel.IncomingStreamRequestHandler.this.activeSink.get() != this))
        {
          AppMethodBeat.o(9832);
          return;
        }
        EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeSuccessEnvelope(paramObject));
        AppMethodBeat.o(9832);
      }
    }
  }
  
  public static abstract interface StreamHandler
  {
    public abstract void onCancel(Object paramObject);
    
    public abstract void onListen(Object paramObject, EventChannel.EventSink paramEventSink);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.common.EventChannel
 * JD-Core Version:    0.7.0.1
 */