package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StandardMethodCodec;

public class MouseCursorChannel
{
  private static final String TAG = "MouseCursorChannel";
  public final MethodChannel channel;
  private MouseCursorMethodHandler mouseCursorMethodHandler;
  private final MethodChannel.MethodCallHandler parsingMethodCallHandler;
  
  public MouseCursorChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(190194);
    this.parsingMethodCallHandler = new MethodChannel.MethodCallHandler()
    {
      /* Error */
      public void onMethodCall(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	io/flutter/embedding/engine/systemchannels/MouseCursorChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/MouseCursorChannel;
        //   9: invokestatic 33	io/flutter/embedding/engine/systemchannels/MouseCursorChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/MouseCursorChannel;)Lio/flutter/embedding/engine/systemchannels/MouseCursorChannel$MouseCursorMethodHandler;
        //   12: ifnonnull +9 -> 21
        //   15: ldc 23
        //   17: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   20: return
        //   21: aload_1
        //   22: getfield 42	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
        //   25: astore 5
        //   27: ldc 44
        //   29: new 46	java/lang/StringBuilder
        //   32: dup
        //   33: ldc 48
        //   35: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   38: aload 5
        //   40: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   43: ldc 57
        //   45: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   48: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   51: invokestatic 67	io/flutter/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   54: iconst_m1
        //   55: istore_3
        //   56: aload 5
        //   58: invokevirtual 73	java/lang/String:hashCode	()I
        //   61: istore 4
        //   63: iload 4
        //   65: tableswitch	default:+19 -> 84, -1307105544:+45->110
        //   85: tableswitch	default:+19 -> 104, 0:+40->125
        //   105: fload 184
        //   107: nop
        //   108: fload_2
        //   109: return
        //   110: aload 5
        //   112: ldc 75
        //   114: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   117: ifeq -33 -> 84
        //   120: iconst_0
        //   121: istore_3
        //   122: goto -38 -> 84
        //   125: aload_1
        //   126: getfield 83	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
        //   129: checkcast 85	java/util/HashMap
        //   132: ldc 87
        //   134: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   137: checkcast 69	java/lang/String
        //   140: astore_1
        //   141: aload_0
        //   142: getfield 14	io/flutter/embedding/engine/systemchannels/MouseCursorChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/MouseCursorChannel;
        //   145: invokestatic 33	io/flutter/embedding/engine/systemchannels/MouseCursorChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/MouseCursorChannel;)Lio/flutter/embedding/engine/systemchannels/MouseCursorChannel$MouseCursorMethodHandler;
        //   148: aload_1
        //   149: invokeinterface 95 2 0
        //   154: aload_2
        //   155: getstatic 101	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   158: invokeinterface 107 2 0
        //   163: goto -59 -> 104
        //   166: astore_1
        //   167: aload_2
        //   168: ldc 109
        //   170: new 46	java/lang/StringBuilder
        //   173: dup
        //   174: ldc 111
        //   176: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   179: aload_1
        //   180: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   183: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   186: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   189: aconst_null
        //   190: invokeinterface 117 4 0
        //   195: ldc 23
        //   197: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   200: return
        //   201: astore_1
        //   202: aload_2
        //   203: ldc 109
        //   205: new 46	java/lang/StringBuilder
        //   208: dup
        //   209: ldc 119
        //   211: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   214: aload_1
        //   215: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   218: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   221: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   224: aconst_null
        //   225: invokeinterface 117 4 0
        //   230: ldc 23
        //   232: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   235: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	236	0	this	1
        //   0	236	1	paramAnonymousMethodCall	MethodCall
        //   0	236	2	paramAnonymousResult	MethodChannel.Result
        //   55	67	3	i	int
        //   61	3	4	j	int
        //   25	86	5	str	String
        // Exception table:
        //   from	to	target	type
        //   56	63	166	java/lang/Exception
        //   110	120	166	java/lang/Exception
        //   125	141	166	java/lang/Exception
        //   154	163	166	java/lang/Exception
        //   202	235	166	java/lang/Exception
        //   141	154	201	java/lang/Exception
      }
    };
    this.channel = new MethodChannel(paramDartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingMethodCallHandler);
    AppMethodBeat.o(190194);
  }
  
  public void setMethodHandler(MouseCursorMethodHandler paramMouseCursorMethodHandler)
  {
    this.mouseCursorMethodHandler = paramMouseCursorMethodHandler;
  }
  
  public void synthesizeMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(190220);
    this.parsingMethodCallHandler.onMethodCall(paramMethodCall, paramResult);
    AppMethodBeat.o(190220);
  }
  
  public static abstract interface MouseCursorMethodHandler
  {
    public abstract void activateSystemCursor(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.MouseCursorChannel
 * JD-Core Version:    0.7.0.1
 */