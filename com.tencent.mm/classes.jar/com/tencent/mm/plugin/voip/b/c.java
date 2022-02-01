package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoIPEncoderInfo;", "", "()V", "ENCODER_DEFAULT", "", "ENCODER_HW", "ENCODER_SOFT", "encodeH", "encodeW", "encoderType", "useGpuCrop", "", "getUseGpuCrop", "()Z", "setUseGpuCrop", "(Z)V", "clear", "", "setType", "isSoft", "setWH", "w", "h", "plugin-voip_release"})
public final class c
{
  private static boolean HdC;
  public static int HgN;
  public static int HgO;
  public static int HgP;
  public static final c HgQ;
  
  static
  {
    AppMethodBeat.i(236034);
    HgQ = new c();
    g localg = g.HgZ;
    HdC = g.fKj();
    AppMethodBeat.o(236034);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(236033);
    HgP = 0;
    HgN = 0;
    HgO = 0;
    g localg = g.HgZ;
    HdC = g.fKj();
    AppMethodBeat.o(236033);
  }
  
  public static void ec(int paramInt1, int paramInt2)
  {
    HgN = paramInt1;
    HgO = paramInt2;
  }
  
  public static void xr(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      HgP = 1;
      return;
    }
    HgP = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.c
 * JD-Core Version:    0.7.0.1
 */