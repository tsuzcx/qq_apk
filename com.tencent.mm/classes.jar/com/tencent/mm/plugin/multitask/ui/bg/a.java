package com.tencent.mm.plugin.multitask.ui.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "Companion", "plugin-multitask_release"})
public final class a
{
  public static final a FKh;
  public static final a FKi;
  public static final a FKj;
  final int jCm;
  final int jCn;
  final int jCo;
  public final int jCp;
  public final int jCq;
  
  static
  {
    AppMethodBeat.i(247833);
    FKj = new a((byte)0);
    FKh = new a(-12105913, -13948117, -12105913, -14935012, -11316397);
    FKi = new a(-11975584, -13948609, -11975584, -15263959, -11120530);
    AppMethodBeat.o(247833);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jCm = paramInt1;
    this.jCn = paramInt2;
    this.jCo = paramInt3;
    this.jCp = paramInt4;
    this.jCq = paramInt5;
  }
  
  public static final a fbG()
  {
    AppMethodBeat.i(247835);
    a locala = a.fbG();
    AppMethodBeat.o(247835);
    return locala;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig$Companion;", "", "()V", "DARK_MODE_PARTICLE_COLOR_CONFIG", "Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "LIGHT_MODE_PARTICLE_COLOR_CONFIG", "TAG", "", "getCurrentThemeConfig", "plugin-multitask_release"})
  public static final class a
  {
    public static a fbG()
    {
      AppMethodBeat.i(249091);
      Log.i("MicroMsg.MultiTaskViewBgParticleColorConfig", "getColorConfig " + ar.isDarkMode());
      if (ar.isDarkMode())
      {
        locala = a.FKh;
        AppMethodBeat.o(249091);
        return locala;
      }
      a locala = a.FKi;
      AppMethodBeat.o(249091);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.bg.a
 * JD-Core Version:    0.7.0.1
 */