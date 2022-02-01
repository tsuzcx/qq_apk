package com.tencent.mm.plugin.multitask.ui.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a LFw;
  public static final a LFx;
  public static final a LFy;
  final int mbZ;
  final int mca;
  final int mcb;
  public final int mcd;
  public final int mce;
  
  static
  {
    AppMethodBeat.i(304185);
    LFw = new a((byte)0);
    LFx = new a(-12105913, -13948117, -12105913, -14935012, -11316397);
    LFy = new a(-11975584, -13948609, -11975584, -15263959, -11120530);
    AppMethodBeat.o(304185);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mbZ = paramInt1;
    this.mca = paramInt2;
    this.mcb = paramInt3;
    this.mcd = paramInt4;
    this.mce = paramInt5;
  }
  
  public static final a gkK()
  {
    AppMethodBeat.i(304177);
    a locala = a.gkK();
    AppMethodBeat.o(304177);
    return locala;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig$Companion;", "", "()V", "DARK_MODE_PARTICLE_COLOR_CONFIG", "Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "LIGHT_MODE_PARTICLE_COLOR_CONFIG", "TAG", "", "getCurrentThemeConfig", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a gkK()
    {
      AppMethodBeat.i(304174);
      Log.i("MicroMsg.MultiTaskViewBgParticleColorConfig", s.X("getColorConfig ", Boolean.valueOf(aw.isDarkMode())));
      if (aw.isDarkMode())
      {
        locala = a.LFx;
        AppMethodBeat.o(304174);
        return locala;
      }
      a locala = a.LFy;
      AppMethodBeat.o(304174);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.bg.a
 * JD-Core Version:    0.7.0.1
 */