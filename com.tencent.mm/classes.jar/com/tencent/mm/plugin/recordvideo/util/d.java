package com.tencent.mm.plugin.recordvideo.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/MediaDebugInfo;", "", "()V", "mediaNum", "", "getMediaNum", "()I", "setMediaNum", "(I)V", "useCpuCrop", "", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Obm;
  private static boolean Obn;
  private static int Obo;
  private static boolean nFT;
  
  static
  {
    AppMethodBeat.i(76177);
    Obm = new d();
    AppMethodBeat.o(76177);
  }
  
  public static void BC(boolean paramBoolean)
  {
    nFT = paramBoolean;
  }
  
  public static void BD(boolean paramBoolean)
  {
    Obn = paramBoolean;
  }
  
  public static void ahc(int paramInt)
  {
    Obo = paramInt;
  }
  
  public static boolean bsq()
  {
    return nFT;
  }
  
  public static boolean gLd()
  {
    return Obn;
  }
  
  public static int gLe()
  {
    return Obo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.d
 * JD-Core Version:    0.7.0.1
 */