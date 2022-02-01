package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

public class c
{
  public static boolean AQa;
  
  static
  {
    AppMethodBeat.i(115716);
    AQa = false;
    emR();
    AppMethodBeat.o(115716);
  }
  
  public static void emR()
  {
    AppMethodBeat.i(115715);
    System.currentTimeMillis();
    if (!AQa) {
      try
      {
        c.class.getClassLoader();
        j.sC("image_filter_common");
        c.class.getClassLoader();
        j.sC("image_filter_gpu");
        c.class.getClassLoader();
        j.sC("format_convert");
        c.class.getClassLoader();
        j.sC("YTCommon");
        c.class.getClassLoader();
        j.sC("YTFaceTrackPro");
        c.class.getClassLoader();
        j.sC("algo_youtu_jni");
        c.class.getClassLoader();
        j.sC("pitu_tools");
        AQa = true;
        AppMethodBeat.o(115715);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        AQa = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        AQa = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (Exception localException)
      {
        AQa = false;
      }
    }
    AppMethodBeat.o(115715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.c
 * JD-Core Version:    0.7.0.1
 */