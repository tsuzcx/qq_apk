package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/util/MediaDebugInfo;", "", "()V", "mediaNum", "", "getMediaNum", "()I", "setMediaNum", "(I)V", "useCpuCrop", "", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "plugin-recordvideo_release"})
public final class b
{
  private static boolean ChW;
  private static int ChX;
  public static final b ChY;
  private static boolean ilO;
  
  static
  {
    AppMethodBeat.i(76177);
    ChY = new b();
    AppMethodBeat.o(76177);
  }
  
  public static void VW(int paramInt)
  {
    ChX = paramInt;
  }
  
  public static boolean eME()
  {
    return ilO;
  }
  
  public static boolean eMF()
  {
    return ChW;
  }
  
  public static int eMG()
  {
    return ChX;
  }
  
  public static void tF(boolean paramBoolean)
  {
    ilO = paramBoolean;
  }
  
  public static void tG(boolean paramBoolean)
  {
    ChW = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b
 * JD-Core Version:    0.7.0.1
 */