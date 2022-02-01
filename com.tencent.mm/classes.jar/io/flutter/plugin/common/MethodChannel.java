package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public class MethodChannel
{
  private static final String TAG = "MethodChannel#";
  private final MethodCodec codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public MethodChannel(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    this(paramBinaryMessenger, paramString, StandardMethodCodec.INSTANCE);
  }
  
  public MethodChannel(BinaryMessenger paramBinaryMessenger, String paramString, MethodCodec paramMethodCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMethodCodec;
  }
  
  public void invokeMethod(String paramString, Object paramObject)
  {
    AppMethodBeat.i(189867);
    invokeMethod(paramString, paramObject, null);
    AppMethodBeat.o(189867);
  }
  
  public void invokeMethod(String paramString, Object paramObject, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(9837);
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    paramObject = this.codec.encodeMethodCall(new MethodCall(paramString, paramObject));
    if (paramResult == null) {}
    for (paramString = null;; paramString = new IncomingResultHandler(paramResult))
    {
      localBinaryMessenger.send(str, paramObject, paramString);
      AppMethodBeat.o(9837);
      return;
    }
  }
  
  public void resizeChannelBuffer(int paramInt)
  {
    AppMethodBeat.i(189893);
    BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, paramInt);
    AppMethodBeat.o(189893);
  }
  
  public void setMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    AppMethodBeat.i(9838);
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramMethodCallHandler == null) {}
    for (paramMethodCallHandler = null;; paramMethodCallHandler = new IncomingMethodCallHandler(paramMethodCallHandler))
    {
      localBinaryMessenger.setMessageHandler(str, paramMethodCallHandler);
      AppMethodBeat.o(9838);
      return;
    }
  }
  
  final class IncomingMethodCallHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final MethodChannel.MethodCallHandler handler;
    
    IncomingMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
    {
      this.handler = paramMethodCallHandler;
    }
    
    private String getStackTrace(Exception paramException)
    {
      AppMethodBeat.i(189802);
      StringWriter localStringWriter = new StringWriter();
      paramException.printStackTrace(new PrintWriter(localStringWriter));
      paramException = localStringWriter.toString();
      AppMethodBeat.o(189802);
      return paramException;
    }
    
    public final void onMessage(ByteBuffer paramByteBuffer, final BinaryMessenger.BinaryReply paramBinaryReply)
    {
      AppMethodBeat.i(9867);
      paramByteBuffer = MethodChannel.this.codec.decodeMethodCall(paramByteBuffer);
      try
      {
        this.handler.onMethodCall(paramByteBuffer, new MethodChannel.Result()
        {
          public void error(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(9840);
            paramBinaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelope(paramAnonymousString1, paramAnonymousString2, paramAnonymousObject));
            AppMethodBeat.o(9840);
          }
          
          public void notImplemented()
          {
            AppMethodBeat.i(9841);
            paramBinaryReply.reply(null);
            AppMethodBeat.o(9841);
          }
          
          public void success(Object paramAnonymousObject)
          {
            AppMethodBeat.i(9839);
            paramBinaryReply.reply(MethodChannel.this.codec.encodeSuccessEnvelope(paramAnonymousObject));
            AppMethodBeat.o(9839);
          }
        });
        AppMethodBeat.o(9867);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        Log.e("MethodChannel#" + MethodChannel.this.name, "Failed to handle method call", paramByteBuffer);
        paramBinaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelopeWithStacktrace("error", paramByteBuffer.getMessage(), null, getStackTrace(paramByteBuffer)));
        AppMethodBeat.o(9867);
      }
    }
  }
  
  final class IncomingResultHandler
    implements BinaryMessenger.BinaryReply
  {
    private final MethodChannel.Result callback;
    
    IncomingResultHandler(MethodChannel.Result paramResult)
    {
      this.callback = paramResult;
    }
    
    /* Error */
    public final void reply(ByteBuffer paramByteBuffer)
    {
      // Byte code:
      //   0: sipush 9866
      //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_1
      //   7: ifnonnull +19 -> 26
      //   10: aload_0
      //   11: getfield 22	io/flutter/plugin/common/MethodChannel$IncomingResultHandler:callback	Lio/flutter/plugin/common/MethodChannel$Result;
      //   14: invokeinterface 40 1 0
      //   19: sipush 9866
      //   22: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: return
      //   26: aload_0
      //   27: getfield 22	io/flutter/plugin/common/MethodChannel$IncomingResultHandler:callback	Lio/flutter/plugin/common/MethodChannel$Result;
      //   30: aload_0
      //   31: getfield 17	io/flutter/plugin/common/MethodChannel$IncomingResultHandler:this$0	Lio/flutter/plugin/common/MethodChannel;
      //   34: invokestatic 47	io/flutter/plugin/common/MethodChannel:access$000	(Lio/flutter/plugin/common/MethodChannel;)Lio/flutter/plugin/common/MethodCodec;
      //   37: aload_1
      //   38: invokeinterface 53 2 0
      //   43: invokeinterface 57 2 0
      //   48: sipush 9866
      //   51: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: return
      //   55: astore_1
      //   56: new 59	java/lang/StringBuilder
      //   59: dup
      //   60: ldc 61
      //   62: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   65: aload_0
      //   66: getfield 17	io/flutter/plugin/common/MethodChannel$IncomingResultHandler:this$0	Lio/flutter/plugin/common/MethodChannel;
      //   69: invokestatic 68	io/flutter/plugin/common/MethodChannel:access$100	(Lio/flutter/plugin/common/MethodChannel;)Ljava/lang/String;
      //   72: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   78: ldc 78
      //   80: aload_1
      //   81: invokestatic 84	io/flutter/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   84: sipush 9866
      //   87: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   90: return
      //   91: astore_1
      //   92: aload_0
      //   93: getfield 22	io/flutter/plugin/common/MethodChannel$IncomingResultHandler:callback	Lio/flutter/plugin/common/MethodChannel$Result;
      //   96: aload_1
      //   97: getfield 88	io/flutter/plugin/common/FlutterException:code	Ljava/lang/String;
      //   100: aload_1
      //   101: invokevirtual 91	io/flutter/plugin/common/FlutterException:getMessage	()Ljava/lang/String;
      //   104: aload_1
      //   105: getfield 95	io/flutter/plugin/common/FlutterException:details	Ljava/lang/Object;
      //   108: invokeinterface 99 4 0
      //   113: sipush 9866
      //   116: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   119: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	IncomingResultHandler
      //   0	120	1	paramByteBuffer	ByteBuffer
      // Exception table:
      //   from	to	target	type
      //   10	25	55	java/lang/RuntimeException
      //   26	48	55	java/lang/RuntimeException
      //   48	54	55	java/lang/RuntimeException
      //   92	113	55	java/lang/RuntimeException
      //   26	48	91	io/flutter/plugin/common/FlutterException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel
 * JD-Core Version:    0.7.0.1
 */