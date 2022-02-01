package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/util/MediaDebugInfo;", "", "()V", "mediaNum", "", "getMediaNum", "()I", "setMediaNum", "(I)V", "useCpuCrop", "", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "plugin-recordvideo_release"})
public final class a
{
  private static boolean gWY;
  public static final a wDA;
  private static boolean wDy;
  private static int wDz;
  
  static
  {
    AppMethodBeat.i(76177);
    wDA = new a();
    AppMethodBeat.o(76177);
  }
  
  public static void Mt(int paramInt)
  {
    wDz = paramInt;
  }
  
  public static boolean dwX()
  {
    return gWY;
  }
  
  public static boolean dwY()
  {
    return wDy;
  }
  
  public static int dwZ()
  {
    return wDz;
  }
  
  public static void pI(boolean paramBoolean)
  {
    gWY = paramBoolean;
  }
  
  public static void pJ(boolean paramBoolean)
  {
    wDy = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.a
 * JD-Core Version:    0.7.0.1
 */