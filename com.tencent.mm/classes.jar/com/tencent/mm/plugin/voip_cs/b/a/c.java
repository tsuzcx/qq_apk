package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  private c.a iED = new c.1(this);
  public com.tencent.mm.f.b.c iEq = new com.tencent.mm.f.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
  private com.tencent.mm.plugin.voip.model.a mtt = new c.2(this);
  public com.tencent.mm.plugin.voip.model.b pQB;
  
  public c()
  {
    this.iEq.ey(20);
    this.iEq.aY(true);
    this.iEq.up();
    this.iEq.t(1, false);
    this.iEq.aX(true);
    this.iEq.bCP = this.iED;
    this.pQB = new com.tencent.mm.plugin.voip.model.b();
    this.pQB.z(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    this.pQB.t(ae.getContext(), false);
    this.pQB.pNy = this.mtt;
  }
  
  private boolean jQ(boolean paramBoolean)
  {
    if (this.pQB != null) {
      return this.pQB.jQ(paramBoolean);
    }
    return false;
  }
  
  public final void kj(boolean paramBoolean)
  {
    y.b("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: " + paramBoolean, new Object[0]);
    y.d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + f.yi().yr());
    if (f.yi().yn()) {
      paramBoolean = false;
    }
    if (q.dye.duN)
    {
      q.dye.dump();
      if (q.dye.duO > 0) {
        jQ(paramBoolean);
      }
    }
    if ((q.dye.dvq >= 0) || (q.dye.dvr >= 0)) {
      jQ(paramBoolean);
    }
    com.tencent.mm.plugin.voip_cs.b.b.a locala;
    if (this.pQB != null)
    {
      i = this.pQB.bPH();
      f.yi().b(paramBoolean, i, false);
      locala = com.tencent.mm.plugin.voip_cs.b.c.bSO();
      if (!paramBoolean) {
        break label186;
      }
    }
    label186:
    for (int i = locala.qeL.um(401);; i = locala.qeL.um(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:" + i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.c
 * JD-Core Version:    0.7.0.1
 */