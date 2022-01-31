package com.tencent.mm.ui.chatting.c;

import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.booter.y;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.j.class)
public class k
  extends a
  implements com.tencent.mm.ui.chatting.c.b.j
{
  private static String zFg = "100134";
  private long jMt;
  private boolean zEB;
  private HashSet<Long> zFa;
  private int zFb;
  private HashSet<Long> zFc;
  private HashSet<Long> zFd;
  private int zFe;
  private boolean zFf;
  private e.c zFh;
  private long zFi;
  private boolean zFj;
  private String zFk;
  private long zFl;
  private int zFm;
  
  public k()
  {
    AppMethodBeat.i(31351);
    this.zFa = new HashSet();
    this.zFc = new HashSet();
    this.zFd = new HashSet();
    this.zFe = 0;
    this.zFf = false;
    this.zFh = new k.5(this);
    this.zFi = 0L;
    this.zFj = false;
    this.zFk = null;
    this.jMt = 0L;
    this.zFl = 0L;
    this.zFm = 0;
    this.zEB = false;
    AppMethodBeat.o(31351);
  }
  
  private void IE()
  {
    AppMethodBeat.i(31361);
    this.zFk = null;
    if ((!r.Zn().equals(this.caz.getTalkerUserName())) && (this.caz.dJF()))
    {
      this.zFk = this.caz.getTalkerUserName();
      this.jMt = (bf.aaM() / 1000L * 1000L);
      this.zFm = 0;
      String str = this.zFk;
      com.tencent.mm.model.aw.RO().ac(new k.6(this, str));
    }
    dIa();
    AppMethodBeat.o(31361);
  }
  
  private void dHZ()
  {
    AppMethodBeat.i(31355);
    y.dZP.kA(this.caz.getTalkerUserName());
    com.tencent.mm.ui.chatting.ah.dGU().Pw(4);
    com.tencent.mm.modelstat.b.fRu.IE();
    com.tencent.mm.g.a.aw localaw = new com.tencent.mm.g.a.aw();
    localaw.con.coo = false;
    com.tencent.mm.sdk.b.a.ymk.l(localaw);
    ((com.tencent.mm.plugin.messenger.a.e)g.E(com.tencent.mm.plugin.messenger.a.e.class)).b("tmpl_type_succeed_contact", this.zFh);
    AppMethodBeat.o(31355);
  }
  
  private void dIa()
  {
    int i = 0;
    AppMethodBeat.i(31356);
    h localh;
    if (this.zFj)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.zFi;
      this.zFi = 0L;
      this.zFj = false;
      localh = h.qsU;
      if (i >= 8) {
        break label146;
      }
      if (l1 - l2 >= new long[] { 0L, 200L, 400L, 600L, 800L, 1000L, 1500L, 2000L }[i]) {
        break label127;
      }
    }
    label146:
    for (;;)
    {
      localh.idkeyStat(109L, i, 1L, true);
      AppMethodBeat.o(31356);
      return;
      label127:
      if (i == 7)
      {
        i = 8;
      }
      else
      {
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public final void PE(int paramInt)
  {
    this.zFb = paramInt;
  }
  
  public final void bf(bi parambi)
  {
    AppMethodBeat.i(31352);
    if (!this.zFa.contains(Long.valueOf(parambi.field_msgSvrId)))
    {
      this.zFa.add(Long.valueOf(parambi.field_msgSvrId));
      com.tencent.mm.sdk.g.d.post(new k.1(this, parambi), "ChattingUI.adVideoExposeReport");
    }
    AppMethodBeat.o(31352);
  }
  
  public final void bg(bi parambi)
  {
    AppMethodBeat.i(31353);
    if (this.zFc.contains(Long.valueOf(parambi.field_msgSvrId)))
    {
      AppMethodBeat.o(31353);
      return;
    }
    this.zFc.add(Long.valueOf(parambi.field_msgSvrId));
    com.tencent.mm.sdk.g.d.post(new k.2(this, parambi), "ChattingUI.expExposeReport");
    AppMethodBeat.o(31353);
  }
  
  public final void bh(bi parambi)
  {
    AppMethodBeat.i(31354);
    if (!this.zFf)
    {
      this.zFf = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me(zFg);
      if (localc.isValid()) {
        this.zFe = com.tencent.mm.platformtools.ah.getInt((String)localc.dvN().get("needUploadData"), 0);
      }
    }
    if (this.zFe == 0)
    {
      AppMethodBeat.o(31354);
      return;
    }
    if (this.zFd.contains(Long.valueOf(parambi.field_msgSvrId)))
    {
      AppMethodBeat.o(31354);
      return;
    }
    com.tencent.mm.sdk.g.d.post(new k.3(this, parambi), "ChattingUI.appExposeReport");
    AppMethodBeat.o(31354);
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31358);
    if (bo.isNullOrNil(this.caz.getTalkerUserName())) {
      h.qsU.idkeyStat(110L, 0L, 1L, true);
    }
    AppMethodBeat.o(31358);
  }
  
  public final void dBZ()
  {
    int k = 0;
    AppMethodBeat.i(31359);
    this.zFi = System.currentTimeMillis();
    this.zFj = true;
    if ((this.caz.txj == null) || (this.caz.getTalkerUserName() == null))
    {
      this.zEB = true;
      IE();
      AppMethodBeat.o(31359);
      return;
    }
    com.tencent.mm.modelstat.b.fRu.jdMethod_do(this.caz.getTalkerUserName());
    Object localObject;
    if (!r.Zn().equals(this.caz.getTalkerUserName()))
    {
      localObject = new com.tencent.mm.g.a.aw();
      ((com.tencent.mm.g.a.aw)localObject).con.coo = true;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    com.tencent.mm.ui.chatting.ah.dGU().Pw(1);
    boolean bool = ((aj)this.caz.ay(aj.class)).DP();
    int j;
    int i;
    if ("notification_messages".equals(this.caz.getTalkerUserName()))
    {
      j = 1;
      i = 8;
      label161:
      if (!this.caz.dJE()) {
        break label444;
      }
      i = k;
    }
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.sdk.g.d.ysm.b(new k.4(this, i, j), "MicroMsg.ChattingUI.ChattingReportComponent");
      }
      ((com.tencent.mm.plugin.messenger.a.e)g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("tmpl_type_succeed_contact", this.zFh);
      break;
      if (t.nU(this.caz.getTalkerUserName()))
      {
        localObject = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
        if (((com.tencent.mm.ui.chatting.c.b.d)localObject).dHv())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            if (!((com.tencent.mm.ui.chatting.c.b.d)localObject).dHw()) {
              break label308;
            }
            ((com.tencent.mm.ui.chatting.c.b.d)localObject).dHt().afx().size();
            m = 5;
            j = i;
            i = m;
            break;
          }
          label308:
          m = 4;
          j = i;
          i = m;
          break label161;
        }
        if (f.rW(this.caz.getTalkerUserName()))
        {
          if (bool) {}
          for (j = 0;; j = 1)
          {
            i = 3;
            break;
          }
        }
        if (f.rX(this.caz.getTalkerUserName()))
        {
          j = 1;
          i = 0;
          break label161;
        }
        if (f.rT(this.caz.getTalkerUserName()))
        {
          i = 6;
          j = 0;
        }
      }
      for (;;)
      {
        break;
        i = 7;
        j = 0;
        continue;
        if (this.caz.dJF())
        {
          if (bool) {}
          for (j = 0;; j = 1)
          {
            i = 2;
            break;
          }
        }
        if (bool)
        {
          j = 0;
          i = 1;
        }
        else
        {
          j = 1;
          i = 1;
        }
      }
      label444:
      localObject = t.fll;
      int m = localObject.length;
      k = 0;
      while (k < m)
      {
        if (localObject[k].equals(this.caz.getTalkerUserName())) {
          i = 0;
        }
        k += 1;
      }
    }
  }
  
  public final void dCa() {}
  
  public final void dCb()
  {
    AppMethodBeat.i(31360);
    com.tencent.mm.ui.chatting.ah.dGU().Pw(2);
    if (!this.zEB) {
      IE();
    }
    this.zEB = false;
    AppMethodBeat.o(31360);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31362);
    com.tencent.mm.ui.chatting.ah.dGU().Pw(3);
    if ((!TextUtils.isEmpty(this.zFk)) && (this.caz.dJF()))
    {
      this.zFl = bf.aaM();
      String str = this.zFk;
      this.zFk = "";
      int k = ((s)this.caz.ay(s.class)).dIL();
      if (k == 2) {
        ((s)this.caz.ay(s.class)).dIK();
      }
      int j = 0;
      int i = j;
      if (this.caz.dJF())
      {
        i = j;
        if (this.caz.txj.dqK == 0) {
          i = 1;
        }
      }
      com.tencent.mm.model.aw.RO().ac(new k.7(this, str, k, i));
    }
    AppMethodBeat.o(31362);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31363);
    dHZ();
    boolean bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL().SW(this.caz.getTalkerUserName());
    Object localObject = com.tencent.mm.ui.chatting.j.a.zPI;
    boolean bool2 = this.caz.dJG();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.zPJ[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.zPJ[0]));
      }
      if (localObject.zPJ[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.zPJ[1]));
      }
      if (localObject.zPJ[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.zPJ[2]));
      }
      if (localObject.zPJ[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.zPJ[3]));
      }
      if (localObject.zPJ[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.zPJ[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.qrI.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.j.b.zPL;
      ab.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.caz.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.j.b)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.j.b)localObject).zPM), Integer.valueOf(((com.tencent.mm.ui.chatting.j.b)localObject).zPN), Integer.valueOf(((com.tencent.mm.ui.chatting.j.b)localObject).uEW), Integer.valueOf(((com.tencent.mm.ui.chatting.j.b)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.j.b)localObject).zPO) });
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(403L, 60L, ((com.tencent.mm.ui.chatting.j.b)localObject).mCount, true);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(403L, 61L, ((com.tencent.mm.ui.chatting.j.b)localObject).zPM, true);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(403L, 62L, ((com.tencent.mm.ui.chatting.j.b)localObject).zPN, true);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(403L, 63L, ((com.tencent.mm.ui.chatting.j.b)localObject).uEW, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.j.b)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.j.b)localObject).zPO));
      com.tencent.mm.plugin.report.e.qrI.b(localArrayList, true);
      AppMethodBeat.o(31363);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.zPJ[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.zPJ[0]));
        }
        if (localObject.zPJ[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.zPJ[1]));
        }
        if (localObject.zPJ[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.zPJ[2]));
        }
        if (localObject.zPJ[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.zPJ[3]));
        }
        if (localObject.zPJ[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.zPJ[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.zPJ[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.zPJ[0]));
        }
        if (localObject.zPJ[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.zPJ[1]));
        }
        if (localObject.zPJ[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.zPJ[2]));
        }
        if (localObject.zPJ[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.zPJ[3]));
        }
        if (localObject.zPJ[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.zPJ[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31364);
    super.dHq();
    dHZ();
    AppMethodBeat.o(31364);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(31357);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2) {
      com.tencent.mm.ci.d.dAt().eJ(ChattingUI.class.getName() + ".Listview", 4);
    }
    AppMethodBeat.o(31357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.k
 * JD-Core Version:    0.7.0.1
 */