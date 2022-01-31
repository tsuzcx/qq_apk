package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.bv.b;
import com.tencent.mm.f.b.g.a;
import com.tencent.mm.f.c.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.c.ckn;
import com.tencent.mm.protocal.c.cko;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import com.tencent.qqpinyin.voicerecoapi.c.a;
import java.util.LinkedList;

public final class p
  implements f
{
  public static final String qSD = ac.dOP + "tmp_wearvoicetotext.spx";
  public boolean ceg = false;
  public LinkedList<Integer> fSX = new LinkedList();
  public com.tencent.mm.plugin.wear.model.d.c qSE;
  public com.tencent.qqpinyin.voicerecoapi.c qSF;
  public d qSG;
  private int qSH = 0;
  public int qSI;
  public int qSJ;
  
  public final void a(int paramInt, ckn paramckn)
  {
    if (paramckn.sxO == null)
    {
      y.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
      return;
    }
    Object localObject = paramckn.sxO.toByteArray();
    this.qSH += this.qSG.a(new g.a((byte[])localObject, paramckn.sRd), 0, false);
    y.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", new Object[] { Integer.valueOf(this.qSH) });
    short[] arrayOfShort = new short[paramckn.sRd / 2];
    int i = 0;
    while (i < paramckn.sRd / 2)
    {
      arrayOfShort[i] = ((short)(localObject[(i * 2)] & 0xFF | localObject[(i * 2 + 1)] << 8));
      i += 1;
    }
    localObject = new c.a();
    this.qSF.a(arrayOfShort, paramckn.sRd / 2, (c.a)localObject);
    y.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + ((c.a)localObject).wKn);
    if (((c.a)localObject).wKn == 2) {
      this.qSJ = 1;
    }
    for (;;)
    {
      if (this.qSJ != 0)
      {
        if (this.qSJ < 0)
        {
          if (this.fSX.size() > 10) {
            this.fSX.removeLast();
          }
          this.fSX.addFirst(Integer.valueOf(paramInt));
        }
        if (this.qSJ == 1)
        {
          paramckn = new cko();
          paramckn.tXp = this.qSE.talker;
          paramckn.sRA = "";
          paramckn.ssy = this.qSJ;
          paramckn.tXT = true;
          a.bYL().qRA.a(new p.a(this, this.qSE.igH, paramckn));
          this.qSJ = 0;
        }
      }
      if ((this.ceg) || (this.qSH <= 3300)) {
        break;
      }
      this.ceg = true;
      au.Dk().a(this.qSE, 0);
      return;
      if (((c.a)localObject).wKn == 3) {
        this.qSJ = 2;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wear.model.d.c))
    {
      paramString = (com.tencent.mm.plugin.wear.model.d.c)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label93;
      }
      au.Dk().b(349, this);
      paramm = new cko();
      paramm.tXp = paramString.talker;
      paramm.sRA = "";
      paramm.ssy = -1;
      paramm.tXT = false;
      a.bYL().qRA.a(new p.a(this, paramString.igH, paramm));
    }
    label93:
    while (!paramString.qSu) {
      return;
    }
    au.Dk().b(349, this);
    paramm = new cko();
    paramm.tXp = paramString.talker;
    if (!bk.bl(paramString.qSt))
    {
      y.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", new Object[] { paramString.qSt });
      paramm.sRA = paramString.qSt;
      paramm.ssy = 0;
    }
    for (paramm.tXT = true;; paramm.tXT = false)
    {
      a.bYL().qRA.a(new p.a(this, paramString.igH, paramm));
      return;
      paramm.sRA = "";
      paramm.ssy = -1;
    }
  }
  
  public final void reset()
  {
    y.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", new Object[] { Integer.valueOf(this.qSI) });
    if (this.qSG != null)
    {
      this.qSG.uE();
      this.qSG = null;
      y.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
    }
    if (this.qSF != null)
    {
      this.qSF.stop();
      this.qSF = null;
      y.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
    }
    if (this.qSE != null)
    {
      this.qSE.eJS = true;
      au.Dk().b(349, this);
      au.Dk().c(this.qSE);
      this.qSE = null;
    }
    this.qSJ = 0;
    this.ceg = false;
    this.qSH = 0;
    this.qSI = -1;
    this.fSX.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.p
 * JD-Core Version:    0.7.0.1
 */