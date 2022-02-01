package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/util/MediaDebugInfo;", "", "()V", "mediaNum", "", "getMediaNum", "()I", "setMediaNum", "(I)V", "useCpuCrop", "", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "plugin-recordvideo_release"})
public final class a
{
  private static boolean hpe;
  private static boolean xRf;
  private static int xRg;
  public static final a xRh;
  
  static
  {
    AppMethodBeat.i(76177);
    xRh = new a();
    AppMethodBeat.o(76177);
  }
  
  public static void NV(int paramInt)
  {
    xRg = paramInt;
  }
  
  public static boolean dIp()
  {
    return hpe;
  }
  
  public static boolean dIq()
  {
    return xRf;
  }
  
  public static int dIr()
  {
    return xRg;
  }
  
  public static void qh(boolean paramBoolean)
  {
    hpe = paramBoolean;
  }
  
  public static void qi(boolean paramBoolean)
  {
    xRf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.a
 * JD-Core Version:    0.7.0.1
 */