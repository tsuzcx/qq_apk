package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

public class c
{
  public static boolean Cps;
  
  static
  {
    AppMethodBeat.i(115716);
    Cps = false;
    eAP();
    AppMethodBeat.o(115716);
  }
  
  public static void eAP()
  {
    AppMethodBeat.i(115715);
    System.currentTimeMillis();
    if (!Cps) {
      try
      {
        c.class.getClassLoader();
        j.vr("image_filter_common");
        c.class.getClassLoader();
        j.vr("image_filter_gpu");
        c.class.getClassLoader();
        j.vr("format_convert");
        c.class.getClassLoader();
        j.vr("YTCommon");
        c.class.getClassLoader();
        j.vr("YTFaceTrackPro");
        c.class.getClassLoader();
        j.vr("algo_youtu_jni");
        c.class.getClassLoader();
        j.vr("pitu_tools");
        Cps = true;
        AppMethodBeat.o(115715);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        Cps = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        Cps = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (Exception localException)
      {
        Cps = false;
      }
    }
    AppMethodBeat.o(115715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.c
 * JD-Core Version:    0.7.0.1
 */