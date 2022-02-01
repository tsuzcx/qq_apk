package com.tencent.mm.videocomposition.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "", "()V", "autoReport", "", "getAutoReport", "()Z", "setAutoReport", "(Z)V", "createCost", "", "getCreateCost", "()J", "setCreateCost", "(J)V", "createStartTicks", "effectType", "", "getEffectType", "()I", "setEffectType", "(I)V", "inputError", "getInputError", "setInputError", "outputError", "getOutputError", "setOutputError", "renderCost", "getRenderCost", "renderCostSum", "renderCount", "getRenderCount", "setRenderCount", "renderStartTicks", "scene", "getScene", "setScene", "sizeError", "getSizeError", "setSizeError", "createEnd", "", "createStart", "destroy", "renderEnd", "renderStart", "Companion", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class f
{
  static b<? super f, ah> agEM;
  public static final f.a agEN;
  boolean agEF = true;
  long agEG;
  public long agEH;
  long agEI;
  public boolean agEJ;
  public boolean agEK;
  public boolean agEL;
  long nDw;
  int nDx;
  public int oQw = 1;
  public int scene;
  
  static
  {
    AppMethodBeat.i(233651);
    agEN = new f.a((byte)0);
    AppMethodBeat.o(233651);
  }
  
  public final long bpQ()
  {
    if (this.nDx <= 0) {
      return 0L;
    }
    return this.nDw / this.nDx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.f
 * JD-Core Version:    0.7.0.1
 */