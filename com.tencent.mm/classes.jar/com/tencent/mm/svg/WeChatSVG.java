package com.tencent.mm.svg;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.svg.b.b;

public class WeChatSVG
{
  static
  {
    AppMethodBeat.i(148690);
    if (b.jev())
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("wechatsvg");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/svg/WeChatSVG", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/svg/WeChatSVG", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      nativeInit();
    }
    AppMethodBeat.o(148690);
  }
  
  public static native float[] getViewPort(long paramLong);
  
  private static native void nativeInit();
  
  public static native long parse(String paramString);
  
  public static native void release(long paramLong);
  
  public static native int render(long paramLong, Canvas paramCanvas);
  
  public static native int renderViewPort(long paramLong, Canvas paramCanvas, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.svg.WeChatSVG
 * JD-Core Version:    0.7.0.1
 */