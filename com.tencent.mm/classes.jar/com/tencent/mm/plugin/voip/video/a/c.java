package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

public class c
{
  public static boolean Hla;
  
  static
  {
    AppMethodBeat.i(115716);
    Hla = false;
    fLC();
    AppMethodBeat.o(115716);
  }
  
  public static void fLC()
  {
    AppMethodBeat.i(115715);
    System.currentTimeMillis();
    if (!Hla) {
      try
      {
        c.class.getClassLoader();
        j.Ed("image_filter_common");
        c.class.getClassLoader();
        j.Ed("image_filter_gpu");
        c.class.getClassLoader();
        j.Ed("format_convert");
        c.class.getClassLoader();
        j.Ed("YTCommon");
        c.class.getClassLoader();
        j.Ed("YTFaceTrackPro");
        c.class.getClassLoader();
        j.Ed("algo_youtu_jni");
        c.class.getClassLoader();
        j.Ed("pitu_tools");
        Hla = true;
        AppMethodBeat.o(115715);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        Hla = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        Hla = false;
        AppMethodBeat.o(115715);
        return;
      }
      catch (Exception localException)
      {
        Hla = false;
      }
    }
    AppMethodBeat.o(115715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.c
 * JD-Core Version:    0.7.0.1
 */