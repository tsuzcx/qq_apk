package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/util/MediaDebugInfo;", "", "()V", "mediaNum", "", "getMediaNum", "()I", "setMediaNum", "(I)V", "useCpuCrop", "", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "plugin-recordvideo_release"})
public final class a
{
  private static boolean hrS;
  private static boolean ygY;
  private static int ygZ;
  public static final a yha;
  
  static
  {
    AppMethodBeat.i(76177);
    yha = new a();
    AppMethodBeat.o(76177);
  }
  
  public static void OB(int paramInt)
  {
    ygZ = paramInt;
  }
  
  public static boolean dLG()
  {
    return hrS;
  }
  
  public static boolean dLH()
  {
    return ygY;
  }
  
  public static int dLI()
  {
    return ygZ;
  }
  
  public static void qo(boolean paramBoolean)
  {
    hrS = paramBoolean;
  }
  
  public static void qp(boolean paramBoolean)
  {
    ygY = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.a
 * JD-Core Version:    0.7.0.1
 */