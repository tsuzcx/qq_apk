package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

public class d
{
  public static boolean loadLibSuccessed;
  
  static
  {
    AppMethodBeat.i(5135);
    loadLibSuccessed = false;
    checkLibraryInit();
    AppMethodBeat.o(5135);
  }
  
  public static void checkLibraryInit()
  {
    AppMethodBeat.i(5134);
    System.currentTimeMillis();
    if (!loadLibSuccessed) {
      try
      {
        k.a("image_filter_common", d.class.getClassLoader());
        k.a("image_filter_gpu", d.class.getClassLoader());
        k.a("format_convert", d.class.getClassLoader());
        k.a("YTCommon", d.class.getClassLoader());
        k.a("YTFaceTrackPro", d.class.getClassLoader());
        k.a("algo_youtu_jni", d.class.getClassLoader());
        k.a("pitu_tools", d.class.getClassLoader());
        loadLibSuccessed = true;
        AppMethodBeat.o(5134);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        loadLibSuccessed = false;
        AppMethodBeat.o(5134);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        loadLibSuccessed = false;
        AppMethodBeat.o(5134);
        return;
      }
      catch (Exception localException)
      {
        loadLibSuccessed = false;
      }
    }
    AppMethodBeat.o(5134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.d
 * JD-Core Version:    0.7.0.1
 */