package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/util/MediaDebugInfo;", "", "()V", "mediaNum", "", "getMediaNum", "()I", "setMediaNum", "(I)V", "useCpuCrop", "", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "plugin-recordvideo_release"})
public final class a
{
  private static boolean gwB;
  public static final a vtA;
  private static boolean vty;
  private static int vtz;
  
  static
  {
    AppMethodBeat.i(76177);
    vtA = new a();
    AppMethodBeat.o(76177);
  }
  
  public static void Ku(int paramInt)
  {
    vtz = paramInt;
  }
  
  public static boolean dja()
  {
    return gwB;
  }
  
  public static boolean djb()
  {
    return vty;
  }
  
  public static int djc()
  {
    return vtz;
  }
  
  public static void oK(boolean paramBoolean)
  {
    gwB = paramBoolean;
  }
  
  public static void oL(boolean paramBoolean)
  {
    vty = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.a
 * JD-Core Version:    0.7.0.1
 */