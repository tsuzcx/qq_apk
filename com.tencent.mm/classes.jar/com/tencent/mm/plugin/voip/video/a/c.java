package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

public class c
{
  public static boolean UPL;
  
  static
  {
    AppMethodBeat.i(115716);
    UPL = false;
    icQ();
    AppMethodBeat.o(115716);
  }
  
  public static void icQ()
  {
    AppMethodBeat.i(115715);
    System.currentTimeMillis();
    if (!UPL) {
      try
      {
        c.class.getClassLoader();
        k.DA("image_filter_common");
        c.class.getClassLoader();
        k.DA("image_filter_gpu");
        c.class.getClassLoader();
        k.DA("format_convert");
        c.class.getClassLoader();
        k.DA("YTCommon");
        c.class.getClassLoader();
        k.DA("YTFaceTrackPro");
        c.class.getClassLoader();
        k.DA("algo_youtu_jni");
        c.class.getClassLoader();
        k.DA("pitu_tools");
        UPL = true;
        AppMethodBeat.o(115715);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        UPL = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        UPL = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (Exception localException)
      {
        UPL = false;
      }
    }
    AppMethodBeat.o(115715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.c
 * JD-Core Version:    0.7.0.1
 */