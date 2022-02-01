package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

public class c
{
  public static boolean ObP;
  
  static
  {
    AppMethodBeat.i(115716);
    ObP = false;
    gEc();
    AppMethodBeat.o(115716);
  }
  
  public static void gEc()
  {
    AppMethodBeat.i(115715);
    System.currentTimeMillis();
    if (!ObP) {
      try
      {
        c.class.getClassLoader();
        j.KW("image_filter_common");
        c.class.getClassLoader();
        j.KW("image_filter_gpu");
        c.class.getClassLoader();
        j.KW("format_convert");
        c.class.getClassLoader();
        j.KW("YTCommon");
        c.class.getClassLoader();
        j.KW("YTFaceTrackPro");
        c.class.getClassLoader();
        j.KW("algo_youtu_jni");
        c.class.getClassLoader();
        j.KW("pitu_tools");
        ObP = true;
        AppMethodBeat.o(115715);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        ObP = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        ObP = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (Exception localException)
      {
        ObP = false;
      }
    }
    AppMethodBeat.o(115715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.c
 * JD-Core Version:    0.7.0.1
 */