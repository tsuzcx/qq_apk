package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoIPEncoderInfo;", "", "()V", "ENCODER_DEFAULT", "", "ENCODER_HW", "ENCODER_SOFT", "encodeH", "encodeW", "encoderType", "useGpuCrop", "", "getUseGpuCrop", "()Z", "setUseGpuCrop", "(Z)V", "clear", "", "setType", "isSoft", "setWH", "w", "h", "plugin-voip_release"})
public final class d
{
  public static int CCK;
  public static int CCL;
  public static int CCM;
  public static final d CCN;
  private static boolean CzL;
  
  static
  {
    AppMethodBeat.i(210382);
    CCN = new d();
    h localh = h.CCW;
    CzL = h.eDp();
    AppMethodBeat.o(210382);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(210381);
    CCM = 0;
    CCK = 0;
    CCL = 0;
    h localh = h.CCW;
    CzL = h.eDp();
    AppMethodBeat.o(210381);
  }
  
  public static void dQ(int paramInt1, int paramInt2)
  {
    if (!CzL) {}
    while (paramInt1 == 1280) {
      return;
    }
    CCK = paramInt1;
    CCL = paramInt2;
  }
  
  public static boolean eDe()
  {
    return CzL;
  }
  
  public static void tH(boolean paramBoolean)
  {
    if (!CzL) {
      return;
    }
    if (paramBoolean)
    {
      CCM = 1;
      return;
    }
    CCM = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.d
 * JD-Core Version:    0.7.0.1
 */