package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.app.n.a;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(fFo=m.class)
public class o
  extends a
  implements m
{
  private static String JId = "100134";
  private boolean JGZ;
  private HashSet<Long> JHX;
  private int JHY;
  private HashSet<Long> JHZ;
  private HashSet<Long> JIa;
  private int JIb;
  private boolean JIc;
  private e.c JIe;
  private long JIf;
  private boolean JIg;
  private String JIh;
  private long JIi;
  private int JIj;
  private long nOq;
  
  public o()
  {
    AppMethodBeat.i(35241);
    this.JHX = new HashSet();
    this.JHZ = new HashSet();
    this.JIa = new HashSet();
    this.JIb = 0;
    this.JIc = false;
    this.JIe = new e.c()
    {
      public final void a(Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(194015);
        paramAnonymousMap = new do();
        paramAnonymousMap.mU(o.this.cWM.JOW);
        paramAnonymousMap.mV(o.this.cWM.getTalkerUserName());
        paramAnonymousMap.egJ = 1L;
        paramAnonymousMap.egK = 1L;
        paramAnonymousMap.egO = 1L;
        paramAnonymousMap.aLk();
        AppMethodBeat.o(194015);
      }
      
      public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle) {}
    };
    this.JIf = 0L;
    this.JIg = false;
    this.JIh = null;
    this.nOq = 0L;
    this.JIi = 0L;
    this.JIj = 0;
    this.JGZ = false;
    AppMethodBeat.o(35241);
  }
  
  private void fDv()
  {
    AppMethodBeat.i(35245);
    com.tencent.mm.booter.z.fFA.uj(this.cWM.getTalkerUserName());
    com.tencent.mm.modelstat.b.inZ.report();
    be localbe = new be();
    localbe.dmd.dme = false;
    com.tencent.mm.sdk.b.a.IbL.l(localbe);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).b("tmpl_type_succeed_contact", this.JIe);
    AppMethodBeat.o(35245);
  }
  
  private void fDw()
  {
    int i = 0;
    AppMethodBeat.i(35246);
    com.tencent.mm.plugin.report.service.g localg;
    if (this.JIg)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.JIf;
      this.JIf = 0L;
      this.JIg = false;
      localg = com.tencent.mm.plugin.report.service.g.yhR;
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
      localg.idkeyStat(109L, i, 1L, true);
      AppMethodBeat.o(35246);
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
  
  private void report()
  {
    AppMethodBeat.i(35251);
    this.JIh = null;
    if (u.aAm() == null)
    {
      ad.e("MicroMsg.ChattingUI.ChattingReportComponent", "getUsernameFromUserInfo is null!");
      AppMethodBeat.o(35251);
      return;
    }
    if ((!u.aAm().equals(this.cWM.getTalkerUserName())) && (this.cWM.fFu()))
    {
      this.JIh = this.cWM.getTalkerUserName();
      this.nOq = (bj.aCb() / 1000L * 1000L);
      this.JIj = 0;
      final String str = this.JIh;
      com.tencent.mm.model.ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(35239);
          if (!bt.isNullOrNil(str))
          {
            o.a(o.this, x.aF(str, w.hFd));
            ad.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { str, Integer.valueOf(o.a(o.this)), bt.Db(o.b(o.this)), Long.valueOf(o.b(o.this)) });
            boolean bool1 = bool2;
            if (o.this.cWM.fFu())
            {
              bool1 = bool2;
              if (o.this.cWM.BYG.ePs == 0) {
                bool1 = true;
              }
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).aV(str, bool1);
          }
          AppMethodBeat.o(35239);
        }
      });
    }
    fDw();
    AppMethodBeat.o(35251);
  }
  
  public final void adi(int paramInt)
  {
    this.JHY = paramInt;
  }
  
  public final void bI(final bu parambu)
  {
    AppMethodBeat.i(35242);
    if (!this.JHX.contains(Long.valueOf(parambu.field_msgSvrId)))
    {
      this.JHX.add(Long.valueOf(parambu.field_msgSvrId));
      com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "ChattingUI.adVideoExposeReport";
        }
        
        public final void run()
        {
          AppMethodBeat.i(35234);
          ((j)com.tencent.mm.kernel.g.ab(j.class)).aD(parambu);
          bu localbu = parambu;
          boolean bool1 = this.JIk;
          Object localObject2 = new PString();
          Object localObject1 = new PString();
          boolean bool2;
          com.tencent.mm.modelsns.g localg;
          if (com.tencent.mm.ui.chatting.a.a(localbu, (PString)localObject2, (PString)localObject1))
          {
            Object localObject3 = ((PString)localObject2).value;
            String str = ((PString)localObject1).value;
            localObject2 = localbu.field_talker;
            bool2 = w.zj((String)localObject2);
            if (localbu.field_isSend != 1) {
              break label530;
            }
            localObject1 = u.aAm();
            localg = new com.tencent.mm.modelsns.g();
            localg.m("20source_publishid", (String)localObject3 + ",");
            localg.m("21uxinfo", str + ",");
            localg.m("22clienttime", bt.flT() + ",");
            localObject3 = new StringBuilder();
            if (localbu.getType() != 62) {
              break label554;
            }
            i = 1;
            label216:
            localg.m("23source_type", i + ",");
            localObject3 = new StringBuilder();
            if (!bool2) {
              break label559;
            }
            i = 4;
            label252:
            localg.m("24scene", i + ",");
            localg.m("25scene_chatname", (String)localObject2 + ",");
            localg.m("26scene_username", (String)localObject1 + ",");
            localg.m("27curr_publishid", ",");
            localg.m("28curr_msgid", localbu.field_msgSvrId + ",");
            localg.m("29curr_favid", "0,");
            localObject1 = new StringBuilder();
            if (!bool1) {
              break label564;
            }
            i = 1;
            label390:
            localg.m("30isdownload", i + ",");
            localObject1 = new StringBuilder();
            if (!bool2) {
              break label569;
            }
          }
          label530:
          label554:
          label559:
          label564:
          label569:
          for (int i = q.yS((String)localObject2);; i = 0)
          {
            localg.m("31chatroom_membercount", i + ",");
            ((j)com.tencent.mm.kernel.g.ab(j.class)).b(((j)com.tencent.mm.kernel.g.ab(j.class)).X(localbu), localg);
            ad.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + localg.RE());
            com.tencent.mm.plugin.report.service.g.yhR.f(12989, new Object[] { localg });
            AppMethodBeat.o(35234);
            return;
            if (bool2)
            {
              localObject1 = bj.Bk(localbu.field_content);
              break;
            }
            localObject1 = localObject2;
            break;
            i = 2;
            break label216;
            i = 3;
            break label252;
            i = 0;
            break label390;
          }
        }
      });
    }
    AppMethodBeat.o(35242);
  }
  
  public final void bJ(final bu parambu)
  {
    AppMethodBeat.i(35243);
    if (this.JHZ.contains(Long.valueOf(parambu.field_msgSvrId)))
    {
      AppMethodBeat.o(35243);
      return;
    }
    this.JHZ.add(Long.valueOf(parambu.field_msgSvrId));
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.expExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35235);
        com.tencent.mm.modelstat.a.a(parambu, a.a.inV);
        AppMethodBeat.o(35235);
      }
    });
    AppMethodBeat.o(35243);
  }
  
  public final void bK(final bu parambu)
  {
    AppMethodBeat.i(35244);
    if (!this.JIc)
    {
      this.JIc = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz(JId);
      if (localc.isValid()) {
        this.JIb = af.getInt((String)localc.foF().get("needUploadData"), 0);
      }
    }
    if (this.JIb == 0)
    {
      AppMethodBeat.o(35244);
      return;
    }
    if (this.JIa.contains(Long.valueOf(parambu.field_msgSvrId)))
    {
      AppMethodBeat.o(35244);
      return;
    }
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.appExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35236);
        o.a(o.this, parambu);
        AppMethodBeat.o(35236);
      }
    });
    AppMethodBeat.o(35244);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35254);
    super.fCC();
    fDv();
    AppMethodBeat.o(35254);
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35248);
    if (bt.isNullOrNil(this.cWM.getTalkerUserName())) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(110L, 0L, 1L, true);
    }
    AppMethodBeat.o(35248);
  }
  
  public final void fwt()
  {
    int m = 0;
    AppMethodBeat.i(35249);
    this.JIf = System.currentTimeMillis();
    this.JIg = true;
    if ((this.cWM.BYG == null) || (this.cWM.getTalkerUserName() == null) || (u.aAm() == null))
    {
      this.JGZ = true;
      report();
      AppMethodBeat.o(35249);
      return;
    }
    com.tencent.mm.modelstat.b.inZ.eW(this.cWM.getTalkerUserName());
    Object localObject;
    if (!u.aAm().equals(this.cWM.getTalkerUserName()))
    {
      localObject = new be();
      ((be)localObject).dmd.dme = true;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    com.tencent.mm.ui.chatting.ah.fCe().acX(1);
    boolean bool = ((as)this.cWM.bh(as.class)).Pf();
    final int j;
    final int i;
    if ("notification_messages".equals(this.cWM.getTalkerUserName()))
    {
      j = 1;
      i = 8;
      label168:
      if (!this.cWM.fFt()) {
        break label484;
      }
      i = m;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (((com.tencent.mm.ui.chatting.d.b.h)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.h.class)).fDl()) {
          break;
        }
        com.tencent.e.h.LTJ.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35237);
            if (i == 2) {}
            for (int i = q.yS(o.this.cWM.getTalkerUserName());; i = 0)
            {
              com.tencent.mm.model.ba.aBQ();
              Object localObject = com.tencent.mm.model.c.azv().aTz(o.this.cWM.getTalkerUserName());
              if (localObject == null) {}
              for (int j = 0;; j = ((com.tencent.mm.g.c.ba)localObject).field_unReadCount)
              {
                localObject = com.tencent.mm.booter.z.fFA;
                String str = o.this.cWM.getTalkerUserName();
                int k = i;
                int m = j;
                if (((com.tencent.mm.booter.z)localObject).fFK == null) {
                  ((com.tencent.mm.booter.z)localObject).fFK = u.aAm();
                }
                if (!((com.tencent.mm.booter.z)localObject).fFK.equals(str))
                {
                  if (((com.tencent.mm.booter.z)localObject).fFE != null)
                  {
                    ad.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((com.tencent.mm.booter.z)localObject).fFE.fFR });
                    ((com.tencent.mm.booter.z)localObject).uj(((com.tencent.mm.booter.z)localObject).fFE.fFR);
                  }
                  if (((com.tencent.mm.booter.z)localObject).fFB.aaO(6) == 0) {
                    ((com.tencent.mm.booter.z)localObject).fFB.setLong(4, bt.aQJ());
                  }
                  com.tencent.mm.sdk.b.a.IbL.b(((com.tencent.mm.booter.z)localObject).fFC);
                  com.tencent.mm.sdk.b.a.IbL.b(((com.tencent.mm.booter.z)localObject).fFD);
                  ((com.tencent.mm.booter.z)localObject).appForegroundListener.alive();
                  ((com.tencent.mm.booter.z)localObject).fFE = new z.a((com.tencent.mm.booter.z)localObject);
                  ((com.tencent.mm.booter.z)localObject).fFE.fFV = ((com.tencent.mm.booter.z)localObject).fFF;
                  ((com.tencent.mm.booter.z)localObject).fFF = 0;
                  ((com.tencent.mm.booter.z)localObject).fFE.fFR = str;
                  ((com.tencent.mm.booter.z)localObject).fFI = bt.HI();
                  ((com.tencent.mm.booter.z)localObject).fFE.type = k;
                  ((com.tencent.mm.booter.z)localObject).fFE.fFS = m;
                  ((com.tencent.mm.booter.z)localObject).fFE.djY = j;
                  ((com.tencent.mm.booter.z)localObject).fFE.fFT = i;
                  ((com.tencent.mm.booter.z)localObject).fFE.enterTime = bt.aQJ();
                  ad.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
                }
                AppMethodBeat.o(35237);
                return;
              }
            }
          }
        }, "MicroMsg.ChattingUI.ChattingReportComponent");
      }
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("tmpl_type_succeed_contact", this.JIe);
      break;
      if (w.zE(this.cWM.getTalkerUserName()))
      {
        localObject = (com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
        if (((com.tencent.mm.ui.chatting.d.b.d)localObject).fCH())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            if (!((com.tencent.mm.ui.chatting.d.b.d)localObject).fCI()) {
              break label336;
            }
            ((com.tencent.mm.ui.chatting.d.b.d)localObject).fCF().aGo().size();
            k = 5;
            j = i;
            i = k;
            break;
          }
          label336:
          k = 4;
          j = i;
          i = k;
          break label168;
        }
        if (com.tencent.mm.am.g.DP(this.cWM.getTalkerUserName()))
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            k = 3;
            j = i;
            i = k;
            break;
          }
        }
        if (com.tencent.mm.am.g.DQ(this.cWM.getTalkerUserName()))
        {
          j = 1;
          i = 0;
          break label168;
        }
        if (com.tencent.mm.am.g.DL(this.cWM.getTalkerUserName()))
        {
          j = 6;
          i = 0;
        }
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        j = 7;
        i = 0;
        continue;
        if (this.cWM.fFu())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            k = 2;
            j = i;
            i = k;
            break;
          }
        }
        if (bool)
        {
          i = 0;
          j = 1;
        }
        else
        {
          i = 1;
          j = 1;
        }
      }
      label484:
      localObject = w.hFm;
      m = localObject.length;
      int k = 0;
      while (k < m)
      {
        if (localObject[k].equals(this.cWM.getTalkerUserName())) {
          i = 0;
        }
        k += 1;
      }
    }
  }
  
  public final void fwu() {}
  
  public final void fwv()
  {
    AppMethodBeat.i(35250);
    com.tencent.mm.ui.chatting.ah.fCe().acX(2);
    if (!this.JGZ) {
      report();
    }
    this.JGZ = false;
    AppMethodBeat.o(35250);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35252);
    com.tencent.mm.ui.chatting.ah.fCe().acX(3);
    if ((!TextUtils.isEmpty(this.JIh)) && (this.cWM.fFu()))
    {
      this.JIi = bj.aCb();
      final String str = this.JIh;
      this.JIh = "";
      final int k = ((com.tencent.mm.ui.chatting.d.b.z)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.z.class)).fEp();
      if (k == 2) {
        ((com.tencent.mm.ui.chatting.d.b.z)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.z.class)).fEo();
      }
      int j = 0;
      final int i = j;
      if (this.cWM.fFu())
      {
        i = j;
        if (this.cWM.BYG.ePs == 0) {
          i = 1;
        }
      }
      com.tencent.mm.model.ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          boolean bool = false;
          AppMethodBeat.i(35240);
          int n;
          Object localObject1;
          Object localObject2;
          int m;
          int k;
          int j;
          int i;
          if (!bt.isNullOrNil(str))
          {
            n = q.yS(str);
            com.tencent.mm.model.ba.aBQ();
            localObject1 = com.tencent.mm.model.c.azs().H(str, o.b(o.this), o.c(o.this));
            if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
              break label490;
            }
            localObject2 = new bu();
            m = 0;
            k = 0;
            do
            {
              ((bu)localObject2).convertFrom((Cursor)localObject1);
              if (((ei)localObject2).field_isSend != 1) {
                break;
              }
              j = k + 1;
              i = m;
              m = i;
              k = j;
            } while (((Cursor)localObject1).moveToNext());
          }
          for (;;)
          {
            if (localObject1 != null) {
              ((Cursor)localObject1).close();
            }
            ad.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s", new Object[] { str, Long.valueOf(o.c(o.this) - o.b(o.this)), Integer.valueOf(n), Integer.valueOf(o.a(o.this) + i), Integer.valueOf(j), Integer.valueOf(o.a(o.this)), Integer.valueOf(k), Integer.valueOf(i), o.this.cWM.aYA() });
            com.tencent.mm.plugin.report.service.g.yhR.f(12077, new Object[] { str, Long.valueOf(o.c(o.this) - o.b(o.this)), Integer.valueOf(n), Integer.valueOf(i + o.a(o.this)), Integer.valueOf(j), Integer.valueOf(o.a(o.this)), Integer.valueOf(k), Integer.valueOf(i), o.this.cWM.aYA(), Integer.valueOf(o.d(o.this)) });
            localObject1 = v.zf(str);
            localObject2 = (com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class);
            String str = str;
            long l1 = o.c(o.this);
            long l2 = o.b(o.this);
            i = o.a(o.this);
            if (i == 1) {
              bool = true;
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)localObject2).a(str, (String)localObject1, l1 - l2, i, j, bool);
            AppMethodBeat.o(35240);
            return;
            i = m + 1;
            j = k;
            break;
            label490:
            i = 0;
            j = 0;
          }
        }
      });
    }
    AppMethodBeat.o(35252);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35253);
    fDv();
    boolean bool1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlF().apF(this.cWM.getTalkerUserName());
    Object localObject = com.tencent.mm.ui.chatting.l.a.JWq;
    boolean bool2 = this.cWM.fFv();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.JWr[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.JWr[0]));
      }
      if (localObject.JWr[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.JWr[1]));
      }
      if (localObject.JWr[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.JWr[2]));
      }
      if (localObject.JWr[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.JWr[3]));
      }
      if (localObject.JWr[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.JWr[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.ygI.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.l.b.JWt;
      ad.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).JWu), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).JWv), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).DuR), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).JWw) });
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(403L, 60L, ((com.tencent.mm.ui.chatting.l.b)localObject).mCount, true);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(403L, 61L, ((com.tencent.mm.ui.chatting.l.b)localObject).JWu, true);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(403L, 62L, ((com.tencent.mm.ui.chatting.l.b)localObject).JWv, true);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(403L, 63L, ((com.tencent.mm.ui.chatting.l.b)localObject).DuR, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.l.b)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.l.b)localObject).JWw));
      com.tencent.mm.plugin.report.e.ygI.b(localArrayList, true);
      com.tencent.mm.ui.chatting.ah.fCe().acX(4);
      AppMethodBeat.o(35253);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.JWr[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.JWr[0]));
        }
        if (localObject.JWr[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.JWr[1]));
        }
        if (localObject.JWr[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.JWr[2]));
        }
        if (localObject.JWr[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.JWr[3]));
        }
        if (localObject.JWr[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.JWr[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.JWr[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.JWr[0]));
        }
        if (localObject.JWr[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.JWr[1]));
        }
        if (localObject.JWr[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.JWr[2]));
        }
        if (localObject.JWr[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.JWr[3]));
        }
        if (localObject.JWr[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.JWr[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35247);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2) {
      com.tencent.mm.cj.d.fux().gt(ChattingUI.class.getName() + ".Listview", 4);
    }
    AppMethodBeat.o(35247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.o
 * JD-Core Version:    0.7.0.1
 */