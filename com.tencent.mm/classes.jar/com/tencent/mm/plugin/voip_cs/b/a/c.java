package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
{
  public com.tencent.mm.audio.b.c kJB;
  private c.a kJP;
  private com.tencent.mm.plugin.voip.model.b oTe;
  public com.tencent.mm.plugin.voip.model.c tvF;
  
  public c()
  {
    AppMethodBeat.i(135363);
    this.kJP = new c.1(this);
    this.oTe = new c.2(this);
    this.kJB = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    this.kJB.gA(20);
    this.kJB.bA(true);
    this.kJB.EB();
    this.kJB.t(1, false);
    this.kJB.bz(true);
    this.kJB.cjD = this.kJP;
    this.tvF = new com.tencent.mm.plugin.voip.model.c();
    this.tvF.F(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    this.tvF.x(ah.getContext(), false);
    this.tvF.ttu = this.oTe;
    AppMethodBeat.o(135363);
  }
  
  private boolean mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(135364);
    if (this.tvF != null)
    {
      paramBoolean = this.tvF.mJ(paramBoolean);
      AppMethodBeat.o(135364);
      return paramBoolean;
    }
    AppMethodBeat.o(135364);
    return false;
  }
  
  public final int cLL()
  {
    AppMethodBeat.i(135366);
    if (this.tvF != null)
    {
      int i = this.tvF.cLL();
      AppMethodBeat.o(135366);
      return i;
    }
    AppMethodBeat.o(135366);
    return 0;
  }
  
  public final void mR(boolean paramBoolean)
  {
    AppMethodBeat.i(135365);
    ab.a("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: ".concat(String.valueOf(paramBoolean)), new Object[0]);
    ab.d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + g.KC().KL());
    if (g.KC().KH()) {
      paramBoolean = false;
    }
    if (ac.erv.emD)
    {
      ac.erv.dump();
      if (ac.erv.emE > 0) {
        mJ(paramBoolean);
      }
    }
    if ((ac.erv.enh >= 0) || (ac.erv.eni >= 0)) {
      mJ(paramBoolean);
    }
    com.tencent.mm.plugin.voip_cs.b.b.a locala;
    if (this.tvF != null)
    {
      i = this.tvF.cLL();
      g.KC().b(paramBoolean, i, false);
      locala = com.tencent.mm.plugin.voip_cs.b.c.cQm();
      if (!paramBoolean) {
        break label182;
      }
    }
    label182:
    for (int i = locala.tLy.setAppCmd(401);; i = locala.tLy.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(135365);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.c
 * JD-Core Version:    0.7.0.1
 */