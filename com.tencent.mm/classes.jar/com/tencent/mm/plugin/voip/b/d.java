package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoIPEncoderInfo;", "", "()V", "ENCODER_DEFAULT", "", "ENCODER_HW", "ENCODER_SOFT", "encodeH", "encodeW", "encoderType", "useGpuCrop", "", "getUseGpuCrop", "()Z", "setUseGpuCrop", "(Z)V", "clear", "", "setType", "isSoft", "setWH", "w", "h", "plugin-voip_release"})
public final class d
{
  public static int Clf;
  public static int Clg;
  public static int Clh;
  private static boolean Cli;
  public static final d Clj;
  
  static
  {
    AppMethodBeat.i(215961);
    Clj = new d();
    h localh = h.Cls;
    Cli = h.ezH();
    AppMethodBeat.o(215961);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(215960);
    Clh = 0;
    Clf = 0;
    Clg = 0;
    h localh = h.Cls;
    Cli = h.ezH();
    AppMethodBeat.o(215960);
  }
  
  public static void dQ(int paramInt1, int paramInt2)
  {
    if (!Cli) {}
    while (paramInt1 == 1280) {
      return;
    }
    Clf = paramInt1;
    Clg = paramInt2;
  }
  
  public static boolean ezw()
  {
    return Cli;
  }
  
  public static void tA(boolean paramBoolean)
  {
    if (!Cli) {
      return;
    }
    if (paramBoolean)
    {
      Clh = 1;
      return;
    }
    Clh = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.d
 * JD-Core Version:    0.7.0.1
 */