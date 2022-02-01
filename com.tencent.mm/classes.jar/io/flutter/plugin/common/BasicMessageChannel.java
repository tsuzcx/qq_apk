package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

public final class BasicMessageChannel<T>
{
  public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
  private static final String TAG = "BasicMessageChannel#";
  private final MessageCodec<T> codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public BasicMessageChannel(BinaryMessenger paramBinaryMessenger, String paramString, MessageCodec<T> paramMessageCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMessageCodec;
  }
  
  static void resizeChannelBuffer(BinaryMessenger paramBinaryMessenger, String paramString, int paramInt)
  {
    AppMethodBeat.i(189808);
    Charset localCharset = Charset.forName("UTF-8");
    paramBinaryMessenger.send("dev.flutter/channel-buffers", ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", new Object[] { paramString, Integer.valueOf(paramInt) }).getBytes(localCharset)));
    AppMethodBeat.o(189808);
  }
  
  public final void resizeChannelBuffer(int paramInt)
  {
    AppMethodBeat.i(189845);
    resizeChannelBuffer(this.messenger, this.name, paramInt);
    AppMethodBeat.o(189845);
  }
  
  public final void send(T paramT)
  {
    AppMethodBeat.i(189822);
    send(paramT, null);
    AppMethodBeat.o(189822);
  }
  
  public final void send(T paramT, Reply<T> paramReply)
  {
    Object localObject = null;
    AppMethodBeat.i(189830);
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    ByteBuffer localByteBuffer = this.codec.encodeMessage(paramT);
    if (paramReply == null) {}
    for (paramT = localObject;; paramT = new IncomingReplyHandler(paramReply, null))
    {
      localBinaryMessenger.send(str, localByteBuffer, paramT);
      AppMethodBeat.o(189830);
      return;
    }
  }
  
  public final void setMessageHandler(MessageHandler<T> paramMessageHandler)
  {
    Object localObject = null;
    AppMethodBeat.i(189837);
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramMessageHandler == null) {}
    for (paramMessageHandler = localObject;; paramMessageHandler = new IncomingMessageHandler(paramMessageHandler, null))
    {
      localBinaryMessenger.setMessageHandler(str, paramMessageHandler);
      AppMethodBeat.o(189837);
      return;
    }
  }
  
  final class IncomingMessageHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final BasicMessageChannel.MessageHandler<T> handler;
    
    private IncomingMessageHandler()
    {
      Object localObject;
      this.handler = localObject;
    }
    
    public final void onMessage(ByteBuffer paramByteBuffer, final BinaryMessenger.BinaryReply paramBinaryReply)
    {
      AppMethodBeat.i(9830);
      try
      {
        this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(paramByteBuffer), new BasicMessageChannel.Reply()
        {
          public void reply(T paramAnonymousT)
          {
            AppMethodBeat.i(189784);
            paramBinaryReply.reply(BasicMessageChannel.this.codec.encodeMessage(paramAnonymousT));
            AppMethodBeat.o(189784);
          }
        });
        AppMethodBeat.o(9830);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        Log.e("BasicMessageChannel#" + BasicMessageChannel.this.name, "Failed to handle message", paramByteBuffer);
        paramBinaryReply.reply(null);
        AppMethodBeat.o(9830);
      }
    }
  }
  
  final class IncomingReplyHandler
    implements BinaryMessenger.BinaryReply
  {
    private final BasicMessageChannel.Reply<T> callback;
    
    private IncomingReplyHandler()
    {
      Object localObject;
      this.callback = localObject;
    }
    
    public final void reply(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(189844);
      try
      {
        this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(paramByteBuffer));
        AppMethodBeat.o(189844);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        Log.e("BasicMessageChannel#" + BasicMessageChannel.this.name, "Failed to handle message reply", paramByteBuffer);
        AppMethodBeat.o(189844);
      }
    }
  }
  
  public static abstract interface MessageHandler<T>
  {
    public abstract void onMessage(T paramT, BasicMessageChannel.Reply<T> paramReply);
  }
  
  public static abstract interface Reply<T>
  {
    public abstract void reply(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.common.BasicMessageChannel
 * JD-Core Version:    0.7.0.1
 */