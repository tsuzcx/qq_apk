package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.bv.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.qqpinyin.voicerecoapi.c.a;
import java.util.LinkedList;

public final class p
  implements f
{
  public static final String uHK;
  public boolean cMU;
  public LinkedList<Integer> hmy;
  public com.tencent.mm.plugin.wear.model.d.c uHL;
  public com.tencent.qqpinyin.voicerecoapi.c uHM;
  public d uHN;
  private int uHO;
  public int uHP;
  public int uHQ;
  
  static
  {
    AppMethodBeat.i(26425);
    uHK = ac.eQv + "tmp_wearvoicetotext.spx";
    AppMethodBeat.o(26425);
  }
  
  public p()
  {
    AppMethodBeat.i(26421);
    this.cMU = false;
    this.uHO = 0;
    this.hmy = new LinkedList();
    AppMethodBeat.o(26421);
  }
  
  public final void a(int paramInt, cya paramcya)
  {
    AppMethodBeat.i(26424);
    if (paramcya.wrr == null)
    {
      ab.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
      AppMethodBeat.o(26424);
      return;
    }
    Object localObject = paramcya.wrr.toByteArray();
    this.uHO += this.uHN.a(new g.a((byte[])localObject, paramcya.wyT), 0, false);
    ab.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", new Object[] { Integer.valueOf(this.uHO) });
    short[] arrayOfShort = new short[paramcya.wyT / 2];
    int i = 0;
    while (i < paramcya.wyT / 2)
    {
      arrayOfShort[i] = ((short)(localObject[(i * 2)] & 0xFF | localObject[(i * 2 + 1)] << 8));
      i += 1;
    }
    localObject = new c.a();
    this.uHM.a(arrayOfShort, paramcya.wyT / 2, (c.a)localObject);
    ab.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + ((c.a)localObject).BhO);
    if (((c.a)localObject).BhO == 2) {
      this.uHQ = 1;
    }
    for (;;)
    {
      if (this.uHQ != 0)
      {
        if (this.uHQ < 0)
        {
          if (this.hmy.size() > 10) {
            this.hmy.removeLast();
          }
          this.hmy.addFirst(Integer.valueOf(paramInt));
        }
        if (this.uHQ == 1)
        {
          paramcya = new cyb();
          paramcya.xlH = this.uHL.talker;
          paramcya.wxW = "";
          paramcya.wld = this.uHQ;
          paramcya.yfj = true;
          a.cYy().uGI.a(new p.a(this, this.uHL.cnU, paramcya));
          this.uHQ = 0;
        }
      }
      if ((!this.cMU) && (this.uHO > 3300))
      {
        this.cMU = true;
        aw.Rc().a(this.uHL, 0);
      }
      AppMethodBeat.o(26424);
      return;
      if (((c.a)localObject).BhO == 3) {
        this.uHQ = 2;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26423);
    if ((paramm instanceof com.tencent.mm.plugin.wear.model.d.c))
    {
      paramString = (com.tencent.mm.plugin.wear.model.d.c)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        aw.Rc().b(349, this);
        paramm = new cyb();
        paramm.xlH = paramString.talker;
        paramm.wxW = "";
        paramm.wld = -1;
        paramm.yfj = false;
        a.cYy().uGI.a(new p.a(this, paramString.cnU, paramm));
        AppMethodBeat.o(26423);
        return;
      }
      if (paramString.uHB)
      {
        aw.Rc().b(349, this);
        paramm = new cyb();
        paramm.xlH = paramString.talker;
        if (bo.isNullOrNil(paramString.uHA)) {
          break label219;
        }
        ab.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", new Object[] { paramString.uHA });
        paramm.wxW = paramString.uHA;
        paramm.wld = 0;
      }
    }
    for (paramm.yfj = true;; paramm.yfj = false)
    {
      a.cYy().uGI.a(new p.a(this, paramString.cnU, paramm));
      AppMethodBeat.o(26423);
      return;
      label219:
      paramm.wxW = "";
      paramm.wld = -1;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(26422);
    ab.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", new Object[] { Integer.valueOf(this.uHP) });
    if (this.uHN != null)
    {
      this.uHN.Fb();
      this.uHN = null;
      ab.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
    }
    if (this.uHM != null)
    {
      this.uHM.stop();
      this.uHM = null;
      ab.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
    }
    if (this.uHL != null)
    {
      this.uHL.fZu = true;
      aw.Rc().b(349, this);
      aw.Rc().a(this.uHL);
      this.uHL = null;
    }
    this.uHQ = 0;
    this.cMU = false;
    this.uHO = 0;
    this.uHP = -1;
    this.hmy.clear();
    AppMethodBeat.o(26422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.p
 * JD-Core Version:    0.7.0.1
 */