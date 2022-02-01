package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/MediaDebugInfo;", "", "()V", "mediaNum", "", "getMediaNum", "()I", "setMediaNum", "(I)V", "useCpuCrop", "", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "plugin-recordvideo_release"})
public final class c
{
  private static boolean IeO;
  private static int IeP;
  public static final c IeQ;
  private static boolean laO;
  
  static
  {
    AppMethodBeat.i(76177);
    IeQ = new c();
    AppMethodBeat.o(76177);
  }
  
  public static boolean aXG()
  {
    return laO;
  }
  
  public static void acK(int paramInt)
  {
    IeP = paramInt;
  }
  
  public static boolean fzr()
  {
    return IeO;
  }
  
  public static int fzs()
  {
    return IeP;
  }
  
  public static void xb(boolean paramBoolean)
  {
    laO = paramBoolean;
  }
  
  public static void xc(boolean paramBoolean)
  {
    IeO = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.c
 * JD-Core Version:    0.7.0.1
 */