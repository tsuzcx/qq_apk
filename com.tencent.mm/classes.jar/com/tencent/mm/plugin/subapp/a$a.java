package com.tencent.mm.plugin.subapp;

import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.fo;
import com.tencent.mm.h.a.fo.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.cbr;
import com.tencent.mm.protocal.c.cdx;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cd;
import java.util.HashMap;
import java.util.Map;

public final class a$a
  extends com.tencent.mm.sdk.b.c<fo>
  implements f
{
  private int bMM;
  private int bMN;
  private String bRO;
  private boolean dDQ = false;
  private boolean fRV;
  private fo puA;
  private int puB;
  private Map<String, String> puC = new HashMap();
  private int puD;
  private boolean puE = true;
  private long puF = 0L;
  private long puG;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.a pus;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.c put;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.b puu;
  private com.tencent.mm.modelvoice.b puv;
  private com.tencent.mm.modelvoice.p puw;
  private volatile boolean pux = false;
  boolean puy = false;
  private am puz;
  private String toUser;
  
  public a$a()
  {
    this.udX = fo.class.getName().hashCode();
  }
  
  private void a(String paramString, a.a.a parama)
  {
    y.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[] { parama });
    if (this.puz != null) {
      this.puz.stopTimer();
    }
    au.Dk().b(546, this);
    au.Dk().b(547, this);
    au.Dk().b(548, this);
    if (this.puA != null)
    {
      if (bk.bl(paramString)) {
        break label482;
      }
      this.puC.put(this.puA.bMz.fileName, paramString);
      if (((a.pum == null) || (bk.bl(a.pum.field_content))) && (this.puA.bMz.from == 1))
      {
        cd localcd = com.tencent.mm.modelvoice.m.Th();
        y.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[] { this.puA.bMz.bMB, this.puA.bMz.fileName });
        cc localcc = new cc();
        localcc.field_msgId = Long.valueOf(this.puA.bMz.bMB).longValue();
        localcc.acv(this.puA.bMz.fileName);
        localcc.field_content = paramString;
        localcd.a(localcc);
      }
      this.puA.bMA.aES = true;
      this.puA.bMA.content = paramString;
      if (parama != a.a.a.puP) {
        break label528;
      }
      this.puA.bMA.state = 1;
      label267:
      y.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[] { paramString });
      if (this.puA.bMz.bMD != null) {
        this.puA.bMz.bMD.run();
      }
    }
    int i;
    label333:
    int j;
    if ((this.dDQ) && (this.puw != null))
    {
      if (paramString == null) {
        break label556;
      }
      i = paramString.length();
      if (parama != a.a.a.puN) {
        break label579;
      }
      if (bk.bl(paramString)) {
        break label561;
      }
      j = 1;
    }
    for (;;)
    {
      y.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[] { this.puw.clientId, Integer.valueOf(i), Integer.valueOf(this.bMM), Integer.valueOf(this.bMN), Integer.valueOf(j) });
      if (j != 0) {
        com.tencent.mm.plugin.subapp.d.b.b(this.puw.clientId, i, this.bMM, this.bMN, j);
      }
      this.pus = null;
      this.put = null;
      this.puu = null;
      this.puA = null;
      this.fRV = false;
      this.puy = false;
      this.pux = false;
      this.puB = 20;
      a.pum = null;
      bLA();
      return;
      label482:
      if (parama != a.a.a.puN) {
        break;
      }
      y.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[] { this.puA.bMz.bMB });
      this.puA.bMA.state = 2;
      break;
      label528:
      if ((parama != a.a.a.puR) && (parama != a.a.a.puS)) {
        break label267;
      }
      this.puA.bMA.state = 2;
      break label267;
      label556:
      i = 0;
      break label333;
      label561:
      this.bMM = 0;
      this.bMN = 0;
      i = 0;
      j = 3;
      continue;
      label579:
      this.bMM = 0;
      this.bMN = 0;
      if (parama == a.a.a.puP)
      {
        j = 5;
        i = 0;
      }
      else if (parama == a.a.a.puS)
      {
        i = 0;
        j = 3;
      }
      else if (parama == a.a.a.puR)
      {
        j = 4;
        i = 0;
      }
      else if (parama == a.a.a.puT)
      {
        i = 0;
        j = 2;
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  private boolean a(fo paramfo)
  {
    if (!(paramfo instanceof fo))
    {
      y.f("MicroMsg.SubCoreSubapp", "mismatched event");
      return false;
    }
    if (paramfo.bMz.bMC == 2)
    {
      a(a.a.a.puP);
      this.puC.clear();
      y.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
      return true;
    }
    if (paramfo.bMz.bMC == 1)
    {
      a(a.a.a.puP);
      y.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
      return true;
    }
    if (paramfo.bMz.bMC == 3)
    {
      a(a.a.a.puQ);
      y.i("MicroMsg.SubCoreSubapp", "alvinluo Have cancel translate voice action by user.");
      return true;
    }
    if (paramfo.bMz.bMC != 0)
    {
      y.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", new Object[] { Integer.valueOf(this.puA.bMz.bMC) });
      return false;
    }
    if (this.fRV)
    {
      y.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
      return false;
    }
    if (com.tencent.mm.modelvoice.m.Tg() == null)
    {
      y.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + bk.csb());
      return false;
    }
    this.puA = paramfo;
    String str1 = this.puA.bMz.bMB;
    String str2 = this.puA.bMz.fileName;
    if ((bk.bl(str1)) || (bk.bl(str2)))
    {
      y.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", new Object[] { str1, str2 });
      a(a.a.a.puR);
      return false;
    }
    bLA();
    Object localObject = (String)this.puC.get(str2);
    if (!bk.bl((String)localObject))
    {
      y.i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", new Object[] { str1, str2 });
      a((String)localObject, a.a.a.puN);
      return true;
    }
    localObject = com.tencent.mm.modelvoice.m.Th().acw(str2);
    a.pum = (cc)localObject;
    if ((localObject != null) && (!bk.bl(a.pum.field_content)))
    {
      y.i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", new Object[] { str1, str2 });
      a(a.pum.field_content, a.a.a.puN);
      return true;
    }
    y.i("MicroMsg.SubCoreSubapp", "alvinluo transform test voice scene: %d", new Object[] { Integer.valueOf(paramfo.bMz.scene) });
    this.puw = com.tencent.mm.modelvoice.m.Tg().oJ(str2);
    for (;;)
    {
      try
      {
        if (this.puw == null)
        {
          y.i("MicroMsg.SubCoreSubapp", "alvinluo the VoiceInfo do not exist. (localId : %s, fileName : %s)", new Object[] { str1, str2 });
          this.puw = new com.tencent.mm.modelvoice.p();
          this.puw.fileName = str2;
          this.puw.createTime = (System.currentTimeMillis() / 1000L);
          this.puw.clientId = str2;
          this.puw.eHF = (System.currentTimeMillis() / 1000L);
          this.puw.status = 1;
          if (paramfo.bMz.scene == 8)
          {
            this.puw.eHI = -1;
            int i = o.nU(str2);
            y.i("MicroMsg.SubCoreSubapp", "size : %d", new Object[] { Integer.valueOf(i) });
            this.puw.ebK = i;
          }
        }
        else
        {
          if (this.puw.eHI >= 0) {
            break label725;
          }
          y.i("MicroMsg.SubCoreSubapp", "alvinluo voiceInfo msgLocalId < 0");
          this.puD = this.puA.bMz.scene;
          y.d("MicroMsg.SubCoreSubapp", "alvinluo VoiceTransformText fromUser: %s, toUser: %s, scene: %d", new Object[] { this.bRO, this.toUser, Integer.valueOf(this.puD) });
          this.puv = com.tencent.mm.modelvoice.q.ox(this.puw.fileName);
          this.fRV = true;
          this.puB = 20;
          a(a.a.a.puJ);
          return true;
        }
        this.puw.eHI = Integer.valueOf(str1).intValue();
        continue;
        paramfo = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.puw.eHI);
      }
      catch (Exception paramfo)
      {
        y.printErrStackTrace("MicroMsg.SubCoreSubapp", paramfo, "alvinluo set voiceInfo exception", new Object[0]);
        a(a.a.a.puR);
        return true;
      }
      label725:
      if (paramfo.field_isSend == 1)
      {
        this.bRO = com.tencent.mm.model.q.Gj();
        if ((this.puA.bMz.scene == 4) || (this.puA.bMz.scene == 5))
        {
          paramfo = ((com.tencent.mm.api.g)com.tencent.mm.kernel.g.r(com.tencent.mm.api.g.class)).aj(paramfo.field_bizChatId);
          if (paramfo != null) {
            this.toUser = paramfo.field_bizChatServId;
          } else {
            this.toUser = "";
          }
        }
        else
        {
          this.toUser = paramfo.field_talker;
        }
      }
      else if (paramfo.field_isSend == 0)
      {
        this.toUser = com.tencent.mm.model.q.Gj();
        if ((this.puA.bMz.scene == 4) || (this.puA.bMz.scene == 5))
        {
          paramfo = ((com.tencent.mm.api.g)com.tencent.mm.kernel.g.r(com.tencent.mm.api.g.class)).aj(paramfo.field_bizChatId);
          if (paramfo != null) {
            this.bRO = paramfo.field_bizChatServId;
          } else {
            this.bRO = "";
          }
        }
        else
        {
          this.bRO = paramfo.field_talker;
        }
      }
    }
  }
  
  private void bLA()
  {
    this.puE = true;
    this.puF = 0L;
    this.puG = 0L;
    this.bMM = 0;
    this.bMN = 0;
    this.dDQ = false;
  }
  
  private void bLB()
  {
    if (this.puE)
    {
      this.puE = false;
      this.puF = System.currentTimeMillis();
      this.bMM = ((int)(this.puF - this.puG));
    }
  }
  
  final void a(a.a.a parama)
  {
    switch (a.1.pur[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      y.i("MicroMsg.SubCoreSubapp", "net check");
      if (this.puw.bXr > 0L) {
        y.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[] { Long.valueOf(this.puw.bXr) });
      }
      for (this.pus = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.puw.clientId, this.puw.ebK, this.puv.getFormat(), this.puw.bXr, this.puw.fileName, this.puD, this.bRO, this.toUser);; this.pus = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.puw.clientId, this.puw.ebK, this.puw.fileName, this.puD, this.bRO, this.toUser))
      {
        au.Dk().a(this.pus, 0);
        au.Dk().a(this.pus.getType(), this);
        this.puG = System.currentTimeMillis();
        return;
        y.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[] { Long.valueOf(this.puw.bXr) });
      }
    case 2: 
      y.i("MicroMsg.SubCoreSubapp", "net upload");
      if (this.pus == null)
      {
        y.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
        return;
      }
      this.put = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.puw.clientId, this.pus.pyu, this.puv.getFormat(), this.puw.fileName, this.puD, this.bRO, this.toUser);
      au.Dk().a(this.put, 0);
      au.Dk().a(this.put.getType(), this);
      return;
    case 3: 
      y.i("MicroMsg.SubCoreSubapp", "net upload more");
      if (this.put == null)
      {
        y.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
        return;
      }
      this.put = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.put);
      au.Dk().a(this.put, 0);
      au.Dk().a(this.put.getType(), this);
      return;
    case 4: 
      if (this.pux)
      {
        y.i("MicroMsg.SubCoreSubapp", "pulling so pass");
        return;
      }
      y.i("MicroMsg.SubCoreSubapp", "net get");
      if (this.pus == null)
      {
        y.w("MicroMsg.SubCoreSubapp", "request get must after check!");
        return;
      }
      this.pux = true;
      this.puu = new com.tencent.mm.plugin.subapp.ui.voicetranstext.b(this.puw.clientId);
      au.Dk().a(this.puu, 0);
      au.Dk().a(this.puu.getType(), this);
      return;
    case 5: 
      this.puy = true;
      return;
    case 6: 
      au.Dk().c(this.pus);
      au.Dk().c(this.put);
      au.Dk().c(this.puu);
      this.dDQ = true;
      a(null, a.a.a.puP);
      return;
    case 7: 
    case 8: 
      this.dDQ = true;
      a(null, parama);
      return;
    }
    this.dDQ = true;
    a(null, parama);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    paramString = null;
    Object localObject = null;
    y.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      }
      do
      {
        do
        {
          return;
          if (this.pus.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.pys)
          {
            y.i("MicroMsg.SubCoreSubapp", "check result: done");
            a(a.a.a.puN);
            bLB();
            this.bMN = 0;
            this.dDQ = true;
            paramString = localObject;
            if (this.pus.bMf()) {
              paramString = this.pus.pyt.tSA;
            }
            a(paramString, a.a.a.puN);
            return;
          }
          if (this.pus.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.pyr)
          {
            if (this.pus.pyt != null) {
              bk.bl(this.pus.pyt.tSA);
            }
            y.i("MicroMsg.SubCoreSubapp", "check result: processing");
            a(a.a.a.puM);
            return;
          }
          if (this.pus.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.pyq)
          {
            y.i("MicroMsg.SubCoreSubapp", "check result: not exist");
            a(a.a.a.puK);
            return;
          }
        } while (this.pus.pyv == null);
        paramInt1 = this.pus.pyv.tCw;
        return;
        if (this.put.bMh())
        {
          y.i("MicroMsg.SubCoreSubapp", "succeed upload");
          a(a.a.a.puM);
          return;
        }
        y.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.put.pyu.ndg), Integer.valueOf(this.put.pyu.ndh) });
        a(a.a.a.puL);
        return;
        paramInt1 = this.puu.pyx;
        y.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[] { Integer.valueOf(paramInt1) });
        this.pux = false;
        bLB();
        if ((!this.puu.isComplete()) && (this.puu.bMf()))
        {
          y.i("MicroMsg.SubCoreSubapp", "refreshResult result");
          paramm = this.puu.pyt.tSA;
          if (this.puA != null)
          {
            this.puA.bMA.aES = false;
            this.puA.bMA.content = paramm;
            y.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[] { Boolean.valueOf(bk.bl(paramm)) });
            if (this.puA.bMz.bMD != null) {
              this.puA.bMz.bMD.run();
            }
          }
        }
        while (this.puu.isComplete())
        {
          y.i("MicroMsg.SubCoreSubapp", "succeed get");
          if (this.puu.bMf()) {
            paramString = this.puu.pyt.tSA;
          }
          a(a.a.a.puN);
          this.bMN = ((int)(System.currentTimeMillis() - this.puF));
          this.dDQ = true;
          a(paramString, a.a.a.puN);
          return;
          if (!this.puu.bMf()) {
            y.d("MicroMsg.SubCoreSubapp", "result not valid");
          }
        }
        y.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[] { Integer.valueOf(paramInt1) });
      } while (this.puy);
      paramInt2 = this.puB - 1;
      this.puB = paramInt2;
      if (paramInt2 < 0)
      {
        y.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[] { Integer.valueOf(20) });
        a(a.a.a.puS);
        return;
      }
      if (this.puz == null) {
        this.puz = new am(new a.a.1(this, paramInt1), false);
      }
      paramString = this.puz;
      long l = paramInt1 * 1000;
      paramString.S(l, l);
      return;
    }
    if (paramInt1 == 2)
    {
      a(a.a.a.puT);
      return;
    }
    a(a.a.a.puS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */