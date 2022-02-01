package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

public class c
{
  public static boolean CGW;
  
  static
  {
    AppMethodBeat.i(115716);
    CGW = false;
    eEx();
    AppMethodBeat.o(115716);
  }
  
  public static void eEx()
  {
    AppMethodBeat.i(115715);
    System.currentTimeMillis();
    if (!CGW) {
      try
      {
        c.class.getClassLoader();
        j.vN("image_filter_common");
        c.class.getClassLoader();
        j.vN("image_filter_gpu");
        c.class.getClassLoader();
        j.vN("format_convert");
        c.class.getClassLoader();
        j.vN("YTCommon");
        c.class.getClassLoader();
        j.vN("YTFaceTrackPro");
        c.class.getClassLoader();
        j.vN("algo_youtu_jni");
        c.class.getClassLoader();
        j.vN("pitu_tools");
        CGW = true;
        AppMethodBeat.o(115715);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        CGW = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        CGW = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (Exception localException)
      {
        CGW = false;
      }
    }
    AppMethodBeat.o(115715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.c
 * JD-Core Version:    0.7.0.1
 */