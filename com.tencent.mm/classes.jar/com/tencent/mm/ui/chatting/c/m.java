package com.tencent.mm.ui.chatting.c;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.app.n.a;
import com.tencent.mm.booter.z;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.a.f.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.c.b.ao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.k.class)
public class m
  extends a
  implements com.tencent.mm.ui.chatting.c.b.k
{
  private static String HTF = "100134";
  private boolean HSN;
  private int HTA;
  private HashSet<Long> HTB;
  private HashSet<Long> HTC;
  private int HTD;
  private boolean HTE;
  private f.c HTG;
  private long HTH;
  private boolean HTI;
  private String HTJ;
  private long HTK;
  private int HTL;
  private HashSet<Long> HTz;
  private long nnD;
  
  public m()
  {
    AppMethodBeat.i(35241);
    this.HTz = new HashSet();
    this.HTB = new HashSet();
    this.HTC = new HashSet();
    this.HTD = 0;
    this.HTE = false;
    this.HTG = new f.c()
    {
      public final void a(Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(196470);
        paramAnonymousMap = new cv();
        paramAnonymousMap.kR(m.this.cLy.HZI);
        paramAnonymousMap.kS(m.this.cLy.getTalkerUserName());
        paramAnonymousMap.dRm = 1L;
        paramAnonymousMap.dRn = 1L;
        paramAnonymousMap.dRr = 1L;
        paramAnonymousMap.aHZ();
        AppMethodBeat.o(196470);
      }
      
      public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle) {}
    };
    this.HTH = 0L;
    this.HTI = false;
    this.HTJ = null;
    this.nnD = 0L;
    this.HTK = 0L;
    this.HTL = 0;
    this.HSN = false;
    AppMethodBeat.o(35241);
  }
  
  private void fmX()
  {
    AppMethodBeat.i(35245);
    z.fns.rx(this.cLy.getTalkerUserName());
    com.tencent.mm.modelstat.b.hUE.report();
    bb localbb = new bb();
    localbb.daJ.daK = false;
    com.tencent.mm.sdk.b.a.GpY.l(localbb);
    ((com.tencent.mm.plugin.messenger.a.f)g.ab(com.tencent.mm.plugin.messenger.a.f.class)).b("tmpl_type_succeed_contact", this.HTG);
    AppMethodBeat.o(35245);
  }
  
  private void fmY()
  {
    int i = 0;
    AppMethodBeat.i(35246);
    com.tencent.mm.plugin.report.service.h localh;
    if (this.HTI)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.HTH;
      this.HTH = 0L;
      this.HTI = false;
      localh = com.tencent.mm.plugin.report.service.h.wUl;
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
    this.HTJ = null;
    if (u.axw() == null)
    {
      ac.e("MicroMsg.ChattingUI.ChattingReportComponent", "getUsernameFromUserInfo is null!");
      AppMethodBeat.o(35251);
      return;
    }
    if ((!u.axw().equals(this.cLy.getTalkerUserName())) && (this.cLy.foP()))
    {
      this.HTJ = this.cLy.getTalkerUserName();
      this.nnD = (bi.ayX() / 1000L * 1000L);
      this.HTL = 0;
      final String str = this.HTJ;
      com.tencent.mm.model.az.agU().az(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(35239);
          if (!bs.isNullOrNil(str))
          {
            m.a(m.this, com.tencent.mm.model.x.aD(str, w.hmN));
            ac.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { str, Integer.valueOf(m.a(m.this)), bs.Al(m.b(m.this)), Long.valueOf(m.b(m.this)) });
            boolean bool1 = bool2;
            if (m.this.cLy.foP())
            {
              bool1 = bool2;
              if (m.this.cLy.AzG.exT == 0) {
                bool1 = true;
              }
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).aT(str, bool1);
          }
          AppMethodBeat.o(35239);
        }
      });
    }
    fmY();
    AppMethodBeat.o(35251);
  }
  
  public final void aaW(int paramInt)
  {
    this.HTA = paramInt;
  }
  
  public final void bC(final bo parambo)
  {
    AppMethodBeat.i(35242);
    if (!this.HTz.contains(Long.valueOf(parambo.field_msgSvrId)))
    {
      this.HTz.add(Long.valueOf(parambo.field_msgSvrId));
      com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "ChattingUI.adVideoExposeReport";
        }
        
        public final void run()
        {
          AppMethodBeat.i(35234);
          ((j)g.ab(j.class)).aA(parambo);
          bo localbo = parambo;
          boolean bool1 = this.HTM;
          Object localObject2 = new PString();
          Object localObject1 = new PString();
          boolean bool2;
          com.tencent.mm.modelsns.f localf;
          if (com.tencent.mm.ui.chatting.a.a(localbo, (PString)localObject2, (PString)localObject1))
          {
            Object localObject3 = ((PString)localObject2).value;
            String str = ((PString)localObject1).value;
            localObject2 = localbo.field_talker;
            bool2 = w.wo((String)localObject2);
            if (localbo.field_isSend != 1) {
              break label530;
            }
            localObject1 = u.axw();
            localf = new com.tencent.mm.modelsns.f();
            localf.n("20source_publishid", (String)localObject3 + ",");
            localf.n("21uxinfo", str + ",");
            localf.n("22clienttime", bs.eWj() + ",");
            localObject3 = new StringBuilder();
            if (localbo.getType() != 62) {
              break label554;
            }
            i = 1;
            label216:
            localf.n("23source_type", i + ",");
            localObject3 = new StringBuilder();
            if (!bool2) {
              break label559;
            }
            i = 4;
            label252:
            localf.n("24scene", i + ",");
            localf.n("25scene_chatname", (String)localObject2 + ",");
            localf.n("26scene_username", (String)localObject1 + ",");
            localf.n("27curr_publishid", ",");
            localf.n("28curr_msgid", localbo.field_msgSvrId + ",");
            localf.n("29curr_favid", "0,");
            localObject1 = new StringBuilder();
            if (!bool1) {
              break label564;
            }
            i = 1;
            label390:
            localf.n("30isdownload", i + ",");
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
          for (int i = q.wb((String)localObject2);; i = 0)
          {
            localf.n("31chatroom_membercount", i + ",");
            ((j)g.ab(j.class)).b(((j)g.ab(j.class)).U(localbo), localf);
            ac.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + localf.PS());
            com.tencent.mm.plugin.report.service.h.wUl.f(12989, new Object[] { localf });
            AppMethodBeat.o(35234);
            return;
            if (bool2)
            {
              localObject1 = bi.yl(localbo.field_content);
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
  
  public final void bD(final bo parambo)
  {
    AppMethodBeat.i(35243);
    if (this.HTB.contains(Long.valueOf(parambo.field_msgSvrId)))
    {
      AppMethodBeat.o(35243);
      return;
    }
    this.HTB.add(Long.valueOf(parambo.field_msgSvrId));
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.expExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35235);
        com.tencent.mm.modelstat.a.a(parambo, a.a.hUA);
        AppMethodBeat.o(35235);
      }
    });
    AppMethodBeat.o(35243);
  }
  
  public final void bE(final bo parambo)
  {
    AppMethodBeat.i(35244);
    if (!this.HTE)
    {
      this.HTE = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aAp().tJ(HTF);
      if (localc.isValid()) {
        this.HTD = ae.getInt((String)localc.eYV().get("needUploadData"), 0);
      }
    }
    if (this.HTD == 0)
    {
      AppMethodBeat.o(35244);
      return;
    }
    if (this.HTC.contains(Long.valueOf(parambo.field_msgSvrId)))
    {
      AppMethodBeat.o(35244);
      return;
    }
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.appExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35236);
        m.a(m.this, parambo);
        AppMethodBeat.o(35236);
      }
    });
    AppMethodBeat.o(35244);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35248);
    if (bs.isNullOrNil(this.cLy.getTalkerUserName())) {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(110L, 0L, 1L, true);
    }
    AppMethodBeat.o(35248);
  }
  
  public final void fgh()
  {
    int k = 0;
    AppMethodBeat.i(35249);
    this.HTH = System.currentTimeMillis();
    this.HTI = true;
    if ((this.cLy.AzG == null) || (this.cLy.getTalkerUserName() == null) || (u.axw() == null))
    {
      this.HSN = true;
      report();
      AppMethodBeat.o(35249);
      return;
    }
    com.tencent.mm.modelstat.b.hUE.eb(this.cLy.getTalkerUserName());
    Object localObject;
    if (!u.axw().equals(this.cLy.getTalkerUserName()))
    {
      localObject = new bb();
      ((bb)localObject).daJ.daK = true;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    ah.flN().aaM(1);
    boolean bool = ((ao)this.cLy.bf(ao.class)).Nw();
    final int j;
    final int i;
    if ("notification_messages".equals(this.cLy.getTalkerUserName()))
    {
      j = 1;
      i = 8;
      label167:
      if (!this.cLy.foO()) {
        break label451;
      }
      i = k;
    }
    for (;;)
    {
      if (i != 0) {
        com.tencent.e.h.JZN.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35237);
            if (i == 2) {}
            for (int i = q.wb(m.this.cLy.getTalkerUserName());; i = 0)
            {
              com.tencent.mm.model.az.ayM();
              Object localObject = com.tencent.mm.model.c.awG().aNI(m.this.cLy.getTalkerUserName());
              if (localObject == null) {}
              for (int j = 0;; j = ((com.tencent.mm.g.c.az)localObject).field_unReadCount)
              {
                localObject = z.fns;
                String str = m.this.cLy.getTalkerUserName();
                int k = i;
                int m = j;
                if (((z)localObject).fnC == null) {
                  ((z)localObject).fnC = u.axw();
                }
                if (!((z)localObject).fnC.equals(str))
                {
                  if (((z)localObject).fnw != null)
                  {
                    ac.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((z)localObject).fnw.fnJ });
                    ((z)localObject).rx(((z)localObject).fnw.fnJ);
                  }
                  if (((z)localObject).fnt.YF(6) == 0) {
                    ((z)localObject).fnt.setLong(4, bs.aNx());
                  }
                  com.tencent.mm.sdk.b.a.GpY.b(((z)localObject).fnu);
                  com.tencent.mm.sdk.b.a.GpY.b(((z)localObject).fnv);
                  ((z)localObject).appForegroundListener.alive();
                  ((z)localObject).fnw = new z.a((z)localObject);
                  ((z)localObject).fnw.fnN = ((z)localObject).fnx;
                  ((z)localObject).fnx = 0;
                  ((z)localObject).fnw.fnJ = str;
                  ((z)localObject).fnA = bs.Gn();
                  ((z)localObject).fnw.type = k;
                  ((z)localObject).fnw.fnK = m;
                  ((z)localObject).fnw.cYG = j;
                  ((z)localObject).fnw.fnL = i;
                  ((z)localObject).fnw.enterTime = bs.aNx();
                  ac.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
                }
                AppMethodBeat.o(35237);
                return;
              }
            }
          }
        }, "MicroMsg.ChattingUI.ChattingReportComponent");
      }
      ((com.tencent.mm.plugin.messenger.a.f)g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("tmpl_type_succeed_contact", this.HTG);
      break;
      if (w.wH(this.cLy.getTalkerUserName()))
      {
        localObject = (com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
        if (((com.tencent.mm.ui.chatting.c.b.d)localObject).fmo())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            if (!((com.tencent.mm.ui.chatting.c.b.d)localObject).fmp()) {
              break label315;
            }
            ((com.tencent.mm.ui.chatting.c.b.d)localObject).fmm().aDl().size();
            m = 5;
            j = i;
            i = m;
            break;
          }
          label315:
          m = 4;
          j = i;
          i = m;
          break label167;
        }
        if (com.tencent.mm.al.f.AQ(this.cLy.getTalkerUserName()))
        {
          if (bool) {}
          for (j = 0;; j = 1)
          {
            i = 3;
            break;
          }
        }
        if (com.tencent.mm.al.f.AR(this.cLy.getTalkerUserName()))
        {
          j = 1;
          i = 0;
          break label167;
        }
        if (com.tencent.mm.al.f.AM(this.cLy.getTalkerUserName()))
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
        if (this.cLy.foP())
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
      label451:
      localObject = w.hmW;
      int m = localObject.length;
      k = 0;
      while (k < m)
      {
        if (localObject[k].equals(this.cLy.getTalkerUserName())) {
          i = 0;
        }
        k += 1;
      }
    }
  }
  
  public final void fgi() {}
  
  public final void fgj()
  {
    AppMethodBeat.i(35250);
    ah.flN().aaM(2);
    if (!this.HSN) {
      report();
    }
    this.HSN = false;
    AppMethodBeat.o(35250);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35252);
    ah.flN().aaM(3);
    if ((!TextUtils.isEmpty(this.HTJ)) && (this.cLy.foP()))
    {
      this.HTK = bi.ayX();
      final String str = this.HTJ;
      this.HTJ = "";
      final int k = ((com.tencent.mm.ui.chatting.c.b.x)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.x.class)).fnS();
      if (k == 2) {
        ((com.tencent.mm.ui.chatting.c.b.x)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.x.class)).fnR();
      }
      int j = 0;
      final int i = j;
      if (this.cLy.foP())
      {
        i = j;
        if (this.cLy.AzG.exT == 0) {
          i = 1;
        }
      }
      com.tencent.mm.model.az.agU().az(new Runnable()
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
          if (!bs.isNullOrNil(str))
          {
            n = q.wb(str);
            com.tencent.mm.model.az.ayM();
            localObject1 = com.tencent.mm.model.c.awD().G(str, m.b(m.this), m.c(m.this));
            if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
              break label490;
            }
            localObject2 = new bo();
            m = 0;
            k = 0;
            do
            {
              ((bo)localObject2).convertFrom((Cursor)localObject1);
              if (((dy)localObject2).field_isSend != 1) {
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
            ac.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s", new Object[] { str, Long.valueOf(m.c(m.this) - m.b(m.this)), Integer.valueOf(n), Integer.valueOf(m.a(m.this) + i), Integer.valueOf(j), Integer.valueOf(m.a(m.this)), Integer.valueOf(k), Integer.valueOf(i), m.this.cLy.aVg() });
            com.tencent.mm.plugin.report.service.h.wUl.f(12077, new Object[] { str, Long.valueOf(m.c(m.this) - m.b(m.this)), Integer.valueOf(n), Integer.valueOf(i + m.a(m.this)), Integer.valueOf(j), Integer.valueOf(m.a(m.this)), Integer.valueOf(k), Integer.valueOf(i), m.this.cLy.aVg(), Integer.valueOf(m.d(m.this)) });
            localObject1 = v.wk(str);
            localObject2 = (com.tencent.mm.plugin.expt.roomexpt.d)g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class);
            String str = str;
            long l1 = m.c(m.this);
            long l2 = m.b(m.this);
            i = m.a(m.this);
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
  
  public final void fgl()
  {
    AppMethodBeat.i(35253);
    fmX();
    boolean bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcm().akT(this.cLy.getTalkerUserName());
    Object localObject = com.tencent.mm.ui.chatting.k.a.Igd;
    boolean bool2 = this.cLy.foQ();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.Ige[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.Ige[0]));
      }
      if (localObject.Ige[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.Ige[1]));
      }
      if (localObject.Ige[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.Ige[2]));
      }
      if (localObject.Ige[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.Ige[3]));
      }
      if (localObject.Ige[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.Ige[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      e.wTc.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.k.b.Igg;
      ac.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).Igh), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).Igi), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).BUx), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).Igj) });
      e.wTc.idkeyStat(403L, 60L, ((com.tencent.mm.ui.chatting.k.b)localObject).mCount, true);
      e.wTc.idkeyStat(403L, 61L, ((com.tencent.mm.ui.chatting.k.b)localObject).Igh, true);
      e.wTc.idkeyStat(403L, 62L, ((com.tencent.mm.ui.chatting.k.b)localObject).Igi, true);
      e.wTc.idkeyStat(403L, 63L, ((com.tencent.mm.ui.chatting.k.b)localObject).BUx, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.k.b)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.k.b)localObject).Igj));
      e.wTc.b(localArrayList, true);
      ah.flN().aaM(4);
      AppMethodBeat.o(35253);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.Ige[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.Ige[0]));
        }
        if (localObject.Ige[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.Ige[1]));
        }
        if (localObject.Ige[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.Ige[2]));
        }
        if (localObject.Ige[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.Ige[3]));
        }
        if (localObject.Ige[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.Ige[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.Ige[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.Ige[0]));
        }
        if (localObject.Ige[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.Ige[1]));
        }
        if (localObject.Ige[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.Ige[2]));
        }
        if (localObject.Ige[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.Ige[3]));
        }
        if (localObject.Ige[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.Ige[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35254);
    super.fmj();
    fmX();
    AppMethodBeat.o(35254);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35247);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2) {
      com.tencent.mm.cj.d.feq().fW(ChattingUI.class.getName() + ".Listview", 4);
    }
    AppMethodBeat.o(35247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.m
 * JD-Core Version:    0.7.0.1
 */