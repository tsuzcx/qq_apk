package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fr.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cd;
import java.util.HashMap;
import java.util.Map;

public final class a$a
  extends com.tencent.mm.sdk.b.c<fr>
  implements f
{
  private int cug;
  private int cuh;
  private String czp;
  private boolean eBr;
  private boolean hlw;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.a sVT;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.c sVU;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.b sVV;
  private com.tencent.mm.modelvoice.b sVW;
  private com.tencent.mm.modelvoice.r sVX;
  private volatile boolean sVY;
  boolean sVZ;
  private ap sWa;
  private fr sWb;
  private int sWc;
  private Map<String, String> sWd;
  private int sWe;
  private boolean sWf;
  private long sWg;
  private long sWh;
  private String toUser;
  
  public a$a()
  {
    AppMethodBeat.i(25162);
    this.sVY = false;
    this.sVZ = false;
    this.sWf = true;
    this.sWg = 0L;
    this.eBr = false;
    this.sWd = new HashMap();
    this.__eventId = fr.class.getName().hashCode();
    AppMethodBeat.o(25162);
  }
  
  private void a(String paramString, a.a.a parama)
  {
    AppMethodBeat.i(25166);
    ab.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[] { parama });
    if (this.sWa != null) {
      this.sWa.stopTimer();
    }
    aw.Rc().b(546, this);
    aw.Rc().b(547, this);
    aw.Rc().b(548, this);
    if (this.sWb != null)
    {
      if (bo.isNullOrNil(paramString)) {
        break label289;
      }
      this.sWd.put(this.sWb.ctT.fileName, paramString);
      if (((a.sVM == null) || (bo.isNullOrNil(a.sVM.field_content))) && (this.sWb.ctT.from == 1)) {
        o.amt().a(adO(paramString));
      }
      this.sWb.ctU.aLC = true;
      this.sWb.ctU.content = paramString;
      if (parama != a.a.a.sWq) {
        break label334;
      }
    }
    for (this.sWb.ctU.state = 1;; this.sWb.ctU.state = 2) {
      label289:
      label334:
      do
      {
        ab.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[] { paramString });
        if (this.sWb.ctT.ctX != null) {
          this.sWb.ctT.ctX.run();
        }
        b(paramString, parama);
        this.sVT = null;
        this.sVU = null;
        this.sVV = null;
        this.sWb = null;
        this.hlw = false;
        this.sVZ = false;
        this.sVY = false;
        this.sWc = 20;
        a.sVM = null;
        cGz();
        AppMethodBeat.o(25166);
        return;
        if (parama != a.a.a.sWo) {
          break;
        }
        ab.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[] { this.sWb.ctT.ctV });
        this.sWb.ctU.state = 2;
        break;
      } while ((parama != a.a.a.sWs) && (parama != a.a.a.sWt));
    }
  }
  
  private boolean a(fr paramfr)
  {
    AppMethodBeat.i(25163);
    if (!(paramfr instanceof fr))
    {
      ab.f("MicroMsg.SubCoreSubapp", "mismatched event");
      AppMethodBeat.o(25163);
      return false;
    }
    if (paramfr.ctT.ctW == 2)
    {
      a(a.a.a.sWq);
      this.sWd.clear();
      ab.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
      AppMethodBeat.o(25163);
      return true;
    }
    if (paramfr.ctT.ctW == 1)
    {
      a(a.a.a.sWq);
      ab.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
      AppMethodBeat.o(25163);
      return true;
    }
    if (paramfr.ctT.ctW == 3)
    {
      a(a.a.a.sWr);
      ab.i("MicroMsg.SubCoreSubapp", "alvinluo Have cancel translate voice action by user.");
      AppMethodBeat.o(25163);
      return true;
    }
    if (paramfr.ctT.ctW != 0)
    {
      ab.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", new Object[] { Integer.valueOf(this.sWb.ctT.ctW) });
      AppMethodBeat.o(25163);
      return false;
    }
    if (this.hlw)
    {
      ab.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
      AppMethodBeat.o(25163);
      return false;
    }
    if (o.ams() == null)
    {
      ab.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + bo.dtY());
      AppMethodBeat.o(25163);
      return false;
    }
    this.sWb = paramfr;
    String str1 = this.sWb.ctT.ctV;
    String str2 = this.sWb.ctT.fileName;
    if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)))
    {
      ab.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", new Object[] { str1, str2 });
      a(a.a.a.sWs);
      AppMethodBeat.o(25163);
      return false;
    }
    cGz();
    Object localObject = (String)this.sWd.get(str2);
    if (!bo.isNullOrNil((String)localObject))
    {
      ab.i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", new Object[] { str1, str2 });
      a((String)localObject, a.a.a.sWo);
      AppMethodBeat.o(25163);
      return true;
    }
    localObject = o.amt().asI(str2);
    a.sVM = (cc)localObject;
    if ((localObject != null) && (!bo.isNullOrNil(a.sVM.field_content)))
    {
      ab.i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", new Object[] { str1, str2 });
      a(a.sVM.field_content, a.a.a.sWo);
      AppMethodBeat.o(25163);
      return true;
    }
    ab.i("MicroMsg.SubCoreSubapp", "alvinluo transform test voice scene: %d", new Object[] { Integer.valueOf(paramfr.ctT.scene) });
    this.sVX = o.ams().vW(str2);
    for (;;)
    {
      try
      {
        if (this.sVX == null)
        {
          ab.i("MicroMsg.SubCoreSubapp", "alvinluo the VoiceInfo do not exist. (localId : %s, fileName : %s)", new Object[] { str1, str2 });
          this.sVX = new com.tencent.mm.modelvoice.r();
          this.sVX.fileName = str2;
          this.sVX.createTime = (System.currentTimeMillis() / 1000L);
          this.sVX.clientId = str2;
          this.sVX.fXv = (System.currentTimeMillis() / 1000L);
          this.sVX.status = 1;
          if (paramfr.ctT.scene == 8)
          {
            this.sVX.fXy = -1;
            int i = q.vh(str2);
            ab.i("MicroMsg.SubCoreSubapp", "size : %d", new Object[] { Integer.valueOf(i) });
            this.sVX.fsd = i;
          }
        }
        else
        {
          if (this.sVX.fXy >= 0) {
            break label801;
          }
          ab.i("MicroMsg.SubCoreSubapp", "alvinluo voiceInfo msgLocalId < 0");
          this.sWe = this.sWb.ctT.scene;
          ab.d("MicroMsg.SubCoreSubapp", "alvinluo VoiceTransformText fromUser: %s, toUser: %s, scene: %d", new Object[] { this.czp, this.toUser, Integer.valueOf(this.sWe) });
          this.sVW = s.vK(this.sVX.fileName);
          this.hlw = true;
          this.sWc = 20;
          a(a.a.a.sWk);
          AppMethodBeat.o(25163);
          return true;
        }
        this.sVX.fXy = Integer.valueOf(str1).intValue();
        continue;
        paramfr = ((j)g.E(j.class)).bPQ().kB(this.sVX.fXy);
      }
      catch (Exception paramfr)
      {
        ab.printErrStackTrace("MicroMsg.SubCoreSubapp", paramfr, "alvinluo set voiceInfo exception", new Object[0]);
        a(a.a.a.sWs);
        AppMethodBeat.o(25163);
        return true;
      }
      label801:
      if (paramfr.field_isSend == 1)
      {
        this.czp = com.tencent.mm.model.r.Zn();
        if ((this.sWb.ctT.scene == 4) || (this.sWb.ctT.scene == 5))
        {
          paramfr = ((com.tencent.mm.api.h)g.E(com.tencent.mm.api.h.class)).aG(paramfr.field_bizChatId);
          if (paramfr != null) {
            this.toUser = paramfr.field_bizChatServId;
          } else {
            this.toUser = "";
          }
        }
        else
        {
          this.toUser = paramfr.field_talker;
        }
      }
      else if (paramfr.field_isSend == 0)
      {
        this.toUser = com.tencent.mm.model.r.Zn();
        if ((this.sWb.ctT.scene == 4) || (this.sWb.ctT.scene == 5))
        {
          paramfr = ((com.tencent.mm.api.h)g.E(com.tencent.mm.api.h.class)).aG(paramfr.field_bizChatId);
          if (paramfr != null) {
            this.czp = paramfr.field_bizChatServId;
          } else {
            this.czp = "";
          }
        }
        else
        {
          this.czp = paramfr.field_talker;
        }
      }
    }
  }
  
  private cc adO(String paramString)
  {
    AppMethodBeat.i(25168);
    ab.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[] { this.sWb.ctT.ctV, this.sWb.ctT.fileName });
    cc localcc = new cc();
    localcc.field_msgId = Long.valueOf(this.sWb.ctT.ctV).longValue();
    localcc.asH(this.sWb.ctT.fileName);
    localcc.field_content = paramString;
    AppMethodBeat.o(25168);
    return localcc;
  }
  
  private void b(String paramString, a.a.a parama)
  {
    AppMethodBeat.i(25167);
    if (!this.eBr)
    {
      AppMethodBeat.o(25167);
      return;
    }
    if (this.sVX == null)
    {
      AppMethodBeat.o(25167);
      return;
    }
    int i;
    int j;
    if (paramString != null)
    {
      i = paramString.length();
      if (parama != a.a.a.sWo) {
        break label173;
      }
      if (bo.isNullOrNil(paramString)) {
        break label155;
      }
      j = 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[] { this.sVX.clientId, Integer.valueOf(i), Integer.valueOf(this.cug), Integer.valueOf(this.cuh), Integer.valueOf(j) });
      if (j != 0) {
        com.tencent.mm.plugin.subapp.d.b.d(this.sVX.clientId, i, this.cug, this.cuh, j);
      }
      AppMethodBeat.o(25167);
      return;
      i = 0;
      break;
      label155:
      this.cug = 0;
      this.cuh = 0;
      i = 0;
      j = 3;
      continue;
      label173:
      this.cug = 0;
      this.cuh = 0;
      if (parama == a.a.a.sWq)
      {
        j = 5;
        i = 0;
      }
      else if (parama == a.a.a.sWt)
      {
        i = 0;
        j = 3;
      }
      else if (parama == a.a.a.sWs)
      {
        j = 4;
        i = 0;
      }
      else if (parama == a.a.a.sWu)
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
  
  private void cGA()
  {
    AppMethodBeat.i(25165);
    if (this.sWf)
    {
      this.sWf = false;
      this.sWg = System.currentTimeMillis();
      this.cug = ((int)(this.sWg - this.sWh));
    }
    AppMethodBeat.o(25165);
  }
  
  private void cGz()
  {
    this.sWf = true;
    this.sWg = 0L;
    this.sWh = 0L;
    this.cug = 0;
    this.cuh = 0;
    this.eBr = false;
  }
  
  final void a(a.a.a parama)
  {
    AppMethodBeat.i(25164);
    switch (a.2.sVS[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25164);
      return;
      ab.i("MicroMsg.SubCoreSubapp", "net check");
      if (this.sVX.cFn > 0L) {
        ab.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[] { Long.valueOf(this.sVX.cFn) });
      }
      for (this.sVT = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.sVX.clientId, this.sVX.fsd, this.sVW.getFormat(), this.sVX.cFn, this.sVX.fileName, this.sWe, this.czp, this.toUser);; this.sVT = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.sVX.clientId, this.sVX.fsd, this.sVX.fileName, this.sWe, this.czp, this.toUser))
      {
        aw.Rc().a(this.sVT, 0);
        aw.Rc().a(this.sVT.getType(), this);
        this.sWh = System.currentTimeMillis();
        AppMethodBeat.o(25164);
        return;
        ab.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[] { Long.valueOf(this.sVX.cFn) });
      }
      ab.i("MicroMsg.SubCoreSubapp", "net upload");
      if (this.sVT == null)
      {
        ab.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
        AppMethodBeat.o(25164);
        return;
      }
      this.sVU = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.sVX.clientId, this.sVT.tai, this.sVW.getFormat(), this.sVX.fileName, this.sWe, this.czp, this.toUser);
      aw.Rc().a(this.sVU, 0);
      aw.Rc().a(this.sVU.getType(), this);
      AppMethodBeat.o(25164);
      return;
      ab.i("MicroMsg.SubCoreSubapp", "net upload more");
      if (this.sVU == null)
      {
        ab.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
        AppMethodBeat.o(25164);
        return;
      }
      this.sVU = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.sVU);
      aw.Rc().a(this.sVU, 0);
      aw.Rc().a(this.sVU.getType(), this);
      AppMethodBeat.o(25164);
      return;
      if (this.sVY)
      {
        ab.i("MicroMsg.SubCoreSubapp", "pulling so pass");
        AppMethodBeat.o(25164);
        return;
      }
      ab.i("MicroMsg.SubCoreSubapp", "net get");
      if (this.sVT == null)
      {
        ab.w("MicroMsg.SubCoreSubapp", "request get must after check!");
        AppMethodBeat.o(25164);
        return;
      }
      this.sVY = true;
      this.sVV = new com.tencent.mm.plugin.subapp.ui.voicetranstext.b(this.sVX.clientId);
      aw.Rc().a(this.sVV, 0);
      aw.Rc().a(this.sVV.getType(), this);
      AppMethodBeat.o(25164);
      return;
      this.sVZ = true;
      AppMethodBeat.o(25164);
      return;
      aw.Rc().a(this.sVT);
      aw.Rc().a(this.sVU);
      aw.Rc().a(this.sVV);
      this.eBr = true;
      a(null, a.a.a.sWq);
      AppMethodBeat.o(25164);
      return;
      this.eBr = true;
      a(null, parama);
      AppMethodBeat.o(25164);
      return;
      this.eBr = true;
      a(null, parama);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramString = null;
    Object localObject = null;
    AppMethodBeat.i(25169);
    ab.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramm.getType())
    {
    default: 
      AppMethodBeat.o(25169);
      return;
    case 546: 
      if (this.sVT.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.taf)
      {
        ab.i("MicroMsg.SubCoreSubapp", "check result: done");
        a(a.a.a.sWo);
        cGA();
        this.cuh = 0;
        this.eBr = true;
        paramString = localObject;
        if (this.sVT.cHd()) {
          paramString = this.sVT.tah.xZS;
        }
        a(paramString, a.a.a.sWo);
        AppMethodBeat.o(25169);
        return;
      }
      if (this.sVT.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.tae)
      {
        if (this.sVT.tah != null) {
          bo.isNullOrNil(this.sVT.tah.xZS);
        }
        ab.i("MicroMsg.SubCoreSubapp", "check result: processing");
        a(a.a.a.sWn);
        AppMethodBeat.o(25169);
        return;
      }
      if (this.sVT.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.tad)
      {
        ab.i("MicroMsg.SubCoreSubapp", "check result: not exist");
        a(a.a.a.sWl);
        AppMethodBeat.o(25169);
        return;
      }
      if (this.sVT.taj != null)
      {
        AppMethodBeat.o(25169);
        return;
      }
      break;
    case 547: 
      if (this.sVU.cHf())
      {
        ab.i("MicroMsg.SubCoreSubapp", "succeed upload");
        a(a.a.a.sWn);
        AppMethodBeat.o(25169);
        return;
      }
      ab.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.sVU.tai.pIy), Integer.valueOf(this.sVU.tai.pIz) });
      a(a.a.a.sWm);
      AppMethodBeat.o(25169);
      return;
    case 548: 
      paramInt1 = this.sVV.tal;
      ab.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[] { Integer.valueOf(paramInt1) });
      this.sVY = false;
      cGA();
      if ((!this.sVV.isComplete()) && (this.sVV.cHd()))
      {
        ab.i("MicroMsg.SubCoreSubapp", "refreshResult result");
        paramm = this.sVV.tah.xZS;
        if (this.sWb != null)
        {
          this.sWb.ctU.aLC = false;
          this.sWb.ctU.content = paramm;
          ab.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[] { Boolean.valueOf(bo.isNullOrNil(paramm)) });
          if (this.sWb.ctT.ctX != null) {
            this.sWb.ctT.ctX.run();
          }
        }
      }
      while (this.sVV.isComplete())
      {
        ab.i("MicroMsg.SubCoreSubapp", "succeed get");
        if (this.sVV.cHd()) {
          paramString = this.sVV.tah.xZS;
        }
        a(a.a.a.sWo);
        this.cuh = ((int)(System.currentTimeMillis() - this.sWg));
        this.eBr = true;
        a(paramString, a.a.a.sWo);
        AppMethodBeat.o(25169);
        return;
        if (!this.sVV.cHd()) {
          ab.d("MicroMsg.SubCoreSubapp", "result not valid");
        }
      }
      ab.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[] { Integer.valueOf(paramInt1) });
      if (!this.sVZ)
      {
        paramInt2 = this.sWc - 1;
        this.sWc = paramInt2;
        if (paramInt2 < 0)
        {
          ab.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[] { Integer.valueOf(20) });
          a(a.a.a.sWt);
          AppMethodBeat.o(25169);
          return;
        }
        if (this.sWa == null) {
          this.sWa = new ap(new a.a.1(this, paramInt1), false);
        }
        paramString = this.sWa;
        long l = paramInt1 * 1000;
        paramString.ag(l, l);
      }
      AppMethodBeat.o(25169);
      return;
      if (paramInt1 == 2)
      {
        a(a.a.a.sWu);
        AppMethodBeat.o(25169);
        return;
      }
      a(a.a.a.sWt);
    }
    AppMethodBeat.o(25169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */