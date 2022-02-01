package io.flutter.embedding.engine.dart;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class DartMessenger
  implements PlatformMessageHandler, BinaryMessenger
{
  private static final String TAG = "DartMessenger";
  private final FlutterJNI flutterJNI;
  private final Map<String, BinaryMessenger.BinaryMessageHandler> messageHandlers;
  private int nextReplyId;
  private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;
  
  DartMessenger(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10206);
    this.nextReplyId = 1;
    this.flutterJNI = paramFlutterJNI;
    this.messageHandlers = new HashMap();
    this.pendingReplies = new HashMap();
    AppMethodBeat.o(10206);
  }
  
  private static void handleError(Error paramError)
  {
    AppMethodBeat.i(190030);
    Thread localThread = Thread.currentThread();
    if (localThread.getUncaughtExceptionHandler() == null)
    {
      AppMethodBeat.o(190030);
      throw paramError;
    }
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramError);
    AppMethodBeat.o(190030);
  }
  
  public int getPendingChannelResponseCount()
  {
    AppMethodBeat.i(190069);
    int i = this.pendingReplies.size();
    AppMethodBeat.o(190069);
    return i;
  }
  
  public void handleMessageFromDart(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10210);
    Log.v("DartMessenger", "Received message from Dart over channel '" + paramString + "'");
    BinaryMessenger.BinaryMessageHandler localBinaryMessageHandler = (BinaryMessenger.BinaryMessageHandler)this.messageHandlers.get(paramString);
    if (localBinaryMessageHandler != null) {
      try
      {
        Log.v("DartMessenger", "Deferring to registered handler to process message.");
        if (paramArrayOfByte == null) {}
        for (paramString = null;; paramString = ByteBuffer.wrap(paramArrayOfByte))
        {
          localBinaryMessageHandler.onMessage(paramString, new Reply(this.flutterJNI, paramInt));
          AppMethodBeat.o(10210);
          return;
        }
        Log.v("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
      }
      catch (Exception paramString)
      {
        Log.e("DartMessenger", "Uncaught exception in binary message listener", paramString);
        this.flutterJNI.invokePlatformMessageEmptyResponseCallback(paramInt);
        AppMethodBeat.o(10210);
        return;
      }
      catch (Error paramString)
      {
        handleError(paramString);
        AppMethodBeat.o(10210);
        return;
      }
    }
    this.flutterJNI.invokePlatformMessageEmptyResponseCallback(paramInt);
    AppMethodBeat.o(10210);
  }
  
  public void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10211);
    Log.v("DartMessenger", "Received message reply from Dart.");
    BinaryMessenger.BinaryReply localBinaryReply = (BinaryMessenger.BinaryReply)this.pendingReplies.remove(Integer.valueOf(paramInt));
    if (localBinaryReply != null) {
      try
      {
        Log.v("DartMessenger", "Invoking registered callback for reply from Dart.");
        if (paramArrayOfByte == null) {}
        for (paramArrayOfByte = null;; paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte))
        {
          localBinaryReply.reply(paramArrayOfByte);
          AppMethodBeat.o(10211);
          return;
        }
        AppMethodBeat.o(10211);
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("DartMessenger", "Uncaught exception in binary message reply handler", paramArrayOfByte);
        AppMethodBeat.o(10211);
        return;
      }
      catch (Error paramArrayOfByte)
      {
        handleError(paramArrayOfByte);
      }
    }
  }
  
  public void send(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10208);
    Log.v("DartMessenger", "Sending message over channel '" + paramString + "'");
    send(paramString, paramByteBuffer, null);
    AppMethodBeat.o(10208);
  }
  
  public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    AppMethodBeat.i(10209);
    Log.v("DartMessenger", "Sending message with callback over channel '" + paramString + "'");
    int i = 0;
    if (paramBinaryReply != null)
    {
      i = this.nextReplyId;
      this.nextReplyId = (i + 1);
      this.pendingReplies.put(Integer.valueOf(i), paramBinaryReply);
    }
    if (paramByteBuffer == null)
    {
      this.flutterJNI.dispatchEmptyPlatformMessage(paramString, i);
      AppMethodBeat.o(10209);
      return;
    }
    this.flutterJNI.dispatchPlatformMessage(paramString, paramByteBuffer, paramByteBuffer.position(), i);
    AppMethodBeat.o(10209);
  }
  
  public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    AppMethodBeat.i(10207);
    if (paramBinaryMessageHandler == null)
    {
      Log.v("DartMessenger", "Removing handler for channel '" + paramString + "'");
      this.messageHandlers.remove(paramString);
      AppMethodBeat.o(10207);
      return;
    }
    Log.v("DartMessenger", "Setting handler for channel '" + paramString + "'");
    this.messageHandlers.put(paramString, paramBinaryMessageHandler);
    AppMethodBeat.o(10207);
  }
  
  static class Reply
    implements BinaryMessenger.BinaryReply
  {
    private final AtomicBoolean done;
    private final FlutterJNI flutterJNI;
    private final int replyId;
    
    Reply(FlutterJNI paramFlutterJNI, int paramInt)
    {
      AppMethodBeat.i(10215);
      this.done = new AtomicBoolean(false);
      this.flutterJNI = paramFlutterJNI;
      this.replyId = paramInt;
      AppMethodBeat.o(10215);
    }
    
    public void reply(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(10216);
      if (this.done.getAndSet(true))
      {
        paramByteBuffer = new IllegalStateException("Reply already submitted");
        AppMethodBeat.o(10216);
        throw paramByteBuffer;
      }
      if (paramByteBuffer == null)
      {
        this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
        AppMethodBeat.o(10216);
        return;
      }
      this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, paramByteBuffer, paramByteBuffer.position());
      AppMethodBeat.o(10216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartMessenger
 * JD-Core Version:    0.7.0.1
 */