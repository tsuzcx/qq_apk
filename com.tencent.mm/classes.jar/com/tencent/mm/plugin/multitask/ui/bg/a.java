package com.tencent.mm.plugin.multitask.ui.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "Companion", "plugin-multitask_release"})
public final class a
{
  public static final a AdE;
  public static final a AdF;
  public static final a AdG;
  public final int gRQ;
  public final int gRR;
  public final int gRS;
  public final int gRT;
  public final int gRU;
  
  static
  {
    AppMethodBeat.i(200780);
    AdG = new a((byte)0);
    AdE = new a(-12105913, -13948117, -12105913, -14935012, -11316397);
    AdF = new a(-11975584, -13948609, -11975584, -15263959, -11120530);
    AppMethodBeat.o(200780);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.gRQ = paramInt1;
    this.gRR = paramInt2;
    this.gRS = paramInt3;
    this.gRT = paramInt4;
    this.gRU = paramInt5;
  }
  
  public static final a erA()
  {
    AppMethodBeat.i(200781);
    a locala = a.erA();
    AppMethodBeat.o(200781);
    return locala;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig$Companion;", "", "()V", "DARK_MODE_PARTICLE_COLOR_CONFIG", "Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "LIGHT_MODE_PARTICLE_COLOR_CONFIG", "getCurrentThemeConfig", "plugin-multitask_release"})
  public static final class a
  {
    public static a erA()
    {
      AppMethodBeat.i(200779);
      if (ao.isDarkMode())
      {
        locala = a.AdE;
        AppMethodBeat.o(200779);
        return locala;
      }
      a locala = a.AdF;
      AppMethodBeat.o(200779);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.bg.a
 * JD-Core Version:    0.7.0.1
 */