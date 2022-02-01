package com.tencent.mm.ui.chatting.c;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.app.n.a;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.a;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.a.f.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sns.c.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.c.b.ao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.k.class)
public class m
  extends a
  implements com.tencent.mm.ui.chatting.c.b.k
{
  private static String GtM = "100134";
  private boolean GsV;
  private HashSet<Long> GtG;
  private int GtH;
  private HashSet<Long> GtI;
  private HashSet<Long> GtJ;
  private int GtK;
  private boolean GtL;
  private f.c GtN;
  private long GtO;
  private boolean GtP;
  private String GtQ;
  private long GtR;
  private int GtS;
  private long mLu;
  
  public m()
  {
    AppMethodBeat.i(35241);
    this.GtG = new HashSet();
    this.GtI = new HashSet();
    this.GtJ = new HashSet();
    this.GtK = 0;
    this.GtL = false;
    this.GtN = new f.c()
    {
      public final void a(Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(191515);
        paramAnonymousMap = new com.tencent.mm.g.b.a.bi();
        paramAnonymousMap.ib(m.this.cOd.GzM);
        paramAnonymousMap.ic(m.this.cOd.getTalkerUserName());
        paramAnonymousMap.dPx = 1L;
        paramAnonymousMap.dPy = 1L;
        paramAnonymousMap.dPC = 1L;
        paramAnonymousMap.aBj();
        AppMethodBeat.o(191515);
      }
      
      public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle) {}
    };
    this.GtO = 0L;
    this.GtP = false;
    this.GtQ = null;
    this.mLu = 0L;
    this.GtR = 0L;
    this.GtS = 0;
    this.GsV = false;
    AppMethodBeat.o(35241);
  }
  
  private void eXl()
  {
    AppMethodBeat.i(35245);
    y.fjY.or(this.cOd.getTalkerUserName());
    com.tencent.mm.modelstat.b.huc.report();
    ba localba = new ba();
    localba.ddl.ddm = false;
    com.tencent.mm.sdk.b.a.ESL.l(localba);
    ((com.tencent.mm.plugin.messenger.a.f)g.ab(com.tencent.mm.plugin.messenger.a.f.class)).b("tmpl_type_succeed_contact", this.GtN);
    AppMethodBeat.o(35245);
  }
  
  private void eXm()
  {
    int i = 0;
    AppMethodBeat.i(35246);
    com.tencent.mm.plugin.report.service.h localh;
    if (this.GtP)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.GtO;
      this.GtO = 0L;
      this.GtP = false;
      localh = com.tencent.mm.plugin.report.service.h.vKh;
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
    this.GtQ = null;
    if (u.aqG() == null)
    {
      ad.e("MicroMsg.ChattingUI.ChattingReportComponent", "getUsernameFromUserInfo is null!");
      AppMethodBeat.o(35251);
      return;
    }
    if ((!u.aqG().equals(this.cOd.getTalkerUserName())) && (this.cOd.eZa()))
    {
      this.GtQ = this.cOd.getTalkerUserName();
      this.mLu = (com.tencent.mm.model.bi.asg() / 1000L * 1000L);
      this.GtS = 0;
      final String str = this.GtQ;
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(35239);
          if (!bt.isNullOrNil(str))
          {
            m.a(m.this, com.tencent.mm.model.x.av(str, w.gMn));
            ad.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { str, Integer.valueOf(m.a(m.this)), bt.vI(m.b(m.this)), Long.valueOf(m.b(m.this)) });
            boolean bool1 = bool2;
            if (m.this.cOd.eZa())
            {
              bool1 = bool2;
              if (m.this.cOd.zgX.evx == 0) {
                bool1 = true;
              }
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).aS(str, bool1);
          }
          AppMethodBeat.o(35239);
        }
      });
    }
    eXm();
    AppMethodBeat.o(35251);
  }
  
  public final void YL(int paramInt)
  {
    this.GtH = paramInt;
  }
  
  public final void bA(final bl parambl)
  {
    AppMethodBeat.i(35242);
    if (!this.GtG.contains(Long.valueOf(parambl.field_msgSvrId)))
    {
      this.GtG.add(Long.valueOf(parambl.field_msgSvrId));
      com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "ChattingUI.adVideoExposeReport";
        }
        
        public final void run()
        {
          AppMethodBeat.i(35234);
          ((j)g.ab(j.class)).ay(parambl);
          bl localbl = parambl;
          boolean bool1 = this.GtT;
          Object localObject2 = new PString();
          Object localObject1 = new PString();
          boolean bool2;
          com.tencent.mm.modelsns.f localf;
          if (com.tencent.mm.ui.chatting.a.a(localbl, (PString)localObject2, (PString)localObject1))
          {
            Object localObject3 = ((PString)localObject2).value;
            String str = ((PString)localObject1).value;
            localObject2 = localbl.field_talker;
            bool2 = w.sl((String)localObject2);
            if (localbl.field_isSend != 1) {
              break label530;
            }
            localObject1 = u.aqG();
            localf = new com.tencent.mm.modelsns.f();
            localf.o("20source_publishid", (String)localObject3 + ",");
            localf.o("21uxinfo", str + ",");
            localf.o("22clienttime", bt.eGO() + ",");
            localObject3 = new StringBuilder();
            if (localbl.getType() != 62) {
              break label554;
            }
            i = 1;
            label216:
            localf.o("23source_type", i + ",");
            localObject3 = new StringBuilder();
            if (!bool2) {
              break label559;
            }
            i = 4;
            label252:
            localf.o("24scene", i + ",");
            localf.o("25scene_chatname", (String)localObject2 + ",");
            localf.o("26scene_username", (String)localObject1 + ",");
            localf.o("27curr_publishid", ",");
            localf.o("28curr_msgid", localbl.field_msgSvrId + ",");
            localf.o("29curr_favid", "0,");
            localObject1 = new StringBuilder();
            if (!bool1) {
              break label564;
            }
            i = 1;
            label390:
            localf.o("30isdownload", i + ",");
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
          for (int i = q.rY((String)localObject2);; i = 0)
          {
            localf.o("31chatroom_membercount", i + ",");
            ((j)g.ab(j.class)).b(((j)g.ab(j.class)).U(localbl), localf);
            ad.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + localf.PW());
            com.tencent.mm.plugin.report.service.h.vKh.f(12989, new Object[] { localf });
            AppMethodBeat.o(35234);
            return;
            if (bool2)
            {
              localObject1 = com.tencent.mm.model.bi.uf(localbl.field_content);
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
  
  public final void bB(final bl parambl)
  {
    AppMethodBeat.i(35243);
    if (this.GtI.contains(Long.valueOf(parambl.field_msgSvrId)))
    {
      AppMethodBeat.o(35243);
      return;
    }
    this.GtI.add(Long.valueOf(parambl.field_msgSvrId));
    com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.expExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35235);
        com.tencent.mm.modelstat.a.a(parambl, a.a.htY);
        AppMethodBeat.o(35235);
      }
    });
    AppMethodBeat.o(35243);
  }
  
  public final void bC(final bl parambl)
  {
    AppMethodBeat.i(35244);
    if (!this.GtL)
    {
      this.GtL = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu(GtM);
      if (localc.isValid()) {
        this.GtK = ae.getInt((String)localc.eJy().get("needUploadData"), 0);
      }
    }
    if (this.GtK == 0)
    {
      AppMethodBeat.o(35244);
      return;
    }
    if (this.GtJ.contains(Long.valueOf(parambl.field_msgSvrId)))
    {
      AppMethodBeat.o(35244);
      return;
    }
    com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.appExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35236);
        m.a(m.this, parambl);
        AppMethodBeat.o(35236);
      }
    });
    AppMethodBeat.o(35244);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35248);
    if (bt.isNullOrNil(this.cOd.getTalkerUserName())) {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(110L, 0L, 1L, true);
    }
    AppMethodBeat.o(35248);
  }
  
  public final void eQB()
  {
    int k = 0;
    AppMethodBeat.i(35249);
    this.GtO = System.currentTimeMillis();
    this.GtP = true;
    if ((this.cOd.zgX == null) || (this.cOd.getTalkerUserName() == null) || (u.aqG() == null))
    {
      this.GsV = true;
      report();
      AppMethodBeat.o(35249);
      return;
    }
    com.tencent.mm.modelstat.b.huc.em(this.cOd.getTalkerUserName());
    Object localObject;
    if (!u.aqG().equals(this.cOd.getTalkerUserName()))
    {
      localObject = new ba();
      ((ba)localObject).ddl.ddm = true;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    ah.eWb().YB(1);
    boolean bool = ((ao)this.cOd.be(ao.class)).Ny();
    final int j;
    final int i;
    if ("notification_messages".equals(this.cOd.getTalkerUserName()))
    {
      j = 1;
      i = 8;
      label167:
      if (!this.cOd.eYZ()) {
        break label451;
      }
      i = k;
    }
    for (;;)
    {
      if (i != 0) {
        com.tencent.e.h.Iye.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35237);
            if (i == 2) {}
            for (int i = q.rY(m.this.cOd.getTalkerUserName());; i = 0)
            {
              az.arV();
              Object localObject = com.tencent.mm.model.c.apR().aIn(m.this.cOd.getTalkerUserName());
              if (localObject == null) {}
              for (int j = 0;; j = ((ay)localObject).field_unReadCount)
              {
                localObject = y.fjY;
                String str = m.this.cOd.getTalkerUserName();
                int k = i;
                int m = j;
                if (((y)localObject).fki == null) {
                  ((y)localObject).fki = u.aqG();
                }
                if (!((y)localObject).fki.equals(str))
                {
                  if (((y)localObject).fkc != null)
                  {
                    ad.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((y)localObject).fkc.fkp });
                    ((y)localObject).or(((y)localObject).fkc.fkp);
                  }
                  if (((y)localObject).fjZ.Wv(6) == 0) {
                    ((y)localObject).fjZ.setLong(4, bt.aGK());
                  }
                  com.tencent.mm.sdk.b.a.ESL.b(((y)localObject).fka);
                  com.tencent.mm.sdk.b.a.ESL.b(((y)localObject).fkb);
                  ((y)localObject).appForegroundListener.alive();
                  ((y)localObject).fkc = new y.a((y)localObject);
                  ((y)localObject).fkc.fkt = ((y)localObject).fkd;
                  ((y)localObject).fkd = 0;
                  ((y)localObject).fkc.fkp = str;
                  ((y)localObject).fkg = bt.GC();
                  ((y)localObject).fkc.type = k;
                  ((y)localObject).fkc.fkq = m;
                  ((y)localObject).fkc.dbk = j;
                  ((y)localObject).fkc.fkr = i;
                  ((y)localObject).fkc.enterTime = bt.aGK();
                  ad.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
                }
                AppMethodBeat.o(35237);
                return;
              }
            }
          }
        }, "MicroMsg.ChattingUI.ChattingReportComponent");
      }
      ((com.tencent.mm.plugin.messenger.a.f)g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("tmpl_type_succeed_contact", this.GtN);
      break;
      if (w.sE(this.cOd.getTalkerUserName()))
      {
        localObject = (com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
        if (((com.tencent.mm.ui.chatting.c.b.d)localObject).eWC())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            if (!((com.tencent.mm.ui.chatting.c.b.d)localObject).eWD()) {
              break label315;
            }
            ((com.tencent.mm.ui.chatting.c.b.d)localObject).eWA().awt().size();
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
        if (com.tencent.mm.am.f.wK(this.cOd.getTalkerUserName()))
        {
          if (bool) {}
          for (j = 0;; j = 1)
          {
            i = 3;
            break;
          }
        }
        if (com.tencent.mm.am.f.wL(this.cOd.getTalkerUserName()))
        {
          j = 1;
          i = 0;
          break label167;
        }
        if (com.tencent.mm.am.f.wG(this.cOd.getTalkerUserName()))
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
        if (this.cOd.eZa())
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
      localObject = w.gMw;
      int m = localObject.length;
      k = 0;
      while (k < m)
      {
        if (localObject[k].equals(this.cOd.getTalkerUserName())) {
          i = 0;
        }
        k += 1;
      }
    }
  }
  
  public final void eQC() {}
  
  public final void eQD()
  {
    AppMethodBeat.i(35250);
    ah.eWb().YB(2);
    if (!this.GsV) {
      report();
    }
    this.GsV = false;
    AppMethodBeat.o(35250);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35252);
    ah.eWb().YB(3);
    if ((!TextUtils.isEmpty(this.GtQ)) && (this.cOd.eZa()))
    {
      this.GtR = com.tencent.mm.model.bi.asg();
      final String str = this.GtQ;
      this.GtQ = "";
      final int k = ((com.tencent.mm.ui.chatting.c.b.x)this.cOd.be(com.tencent.mm.ui.chatting.c.b.x.class)).eYg();
      if (k == 2) {
        ((com.tencent.mm.ui.chatting.c.b.x)this.cOd.be(com.tencent.mm.ui.chatting.c.b.x.class)).eYf();
      }
      int j = 0;
      final int i = j;
      if (this.cOd.eZa())
      {
        i = j;
        if (this.cOd.zgX.evx == 0) {
          i = 1;
        }
      }
      az.afE().ax(new Runnable()
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
            n = q.rY(str);
            az.arV();
            localObject1 = com.tencent.mm.model.c.apO().I(str, m.b(m.this), m.c(m.this));
            if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
              break label490;
            }
            localObject2 = new bl();
            m = 0;
            k = 0;
            do
            {
              ((bl)localObject2).convertFrom((Cursor)localObject1);
              if (((du)localObject2).field_isSend != 1) {
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
            ad.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s", new Object[] { str, Long.valueOf(m.c(m.this) - m.b(m.this)), Integer.valueOf(n), Integer.valueOf(m.a(m.this) + i), Integer.valueOf(j), Integer.valueOf(m.a(m.this)), Integer.valueOf(k), Integer.valueOf(i), m.this.cOd.eYW() });
            com.tencent.mm.plugin.report.service.h.vKh.f(12077, new Object[] { str, Long.valueOf(m.c(m.this) - m.b(m.this)), Integer.valueOf(n), Integer.valueOf(i + m.a(m.this)), Integer.valueOf(j), Integer.valueOf(m.a(m.this)), Integer.valueOf(k), Integer.valueOf(i), m.this.cOd.eYW(), Integer.valueOf(m.d(m.this)) });
            localObject1 = v.sh(str);
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
  
  public final void eQF()
  {
    AppMethodBeat.i(35253);
    eXl();
    boolean bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD().afZ(this.cOd.getTalkerUserName());
    Object localObject = com.tencent.mm.ui.chatting.k.a.GGh;
    boolean bool2 = this.cOd.eZb();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.GGi[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.GGi[0]));
      }
      if (localObject.GGi[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.GGi[1]));
      }
      if (localObject.GGi[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.GGi[2]));
      }
      if (localObject.GGi[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.GGi[3]));
      }
      if (localObject.GGi[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.GGi[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      e.vIY.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.k.b.GGk;
      ad.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.cOd.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).GGl), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).GGm), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).ACc), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.k.b)localObject).GGn) });
      e.vIY.idkeyStat(403L, 60L, ((com.tencent.mm.ui.chatting.k.b)localObject).mCount, true);
      e.vIY.idkeyStat(403L, 61L, ((com.tencent.mm.ui.chatting.k.b)localObject).GGl, true);
      e.vIY.idkeyStat(403L, 62L, ((com.tencent.mm.ui.chatting.k.b)localObject).GGm, true);
      e.vIY.idkeyStat(403L, 63L, ((com.tencent.mm.ui.chatting.k.b)localObject).ACc, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.k.b)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.k.b)localObject).GGn));
      e.vIY.b(localArrayList, true);
      ah.eWb().YB(4);
      AppMethodBeat.o(35253);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.GGi[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.GGi[0]));
        }
        if (localObject.GGi[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.GGi[1]));
        }
        if (localObject.GGi[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.GGi[2]));
        }
        if (localObject.GGi[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.GGi[3]));
        }
        if (localObject.GGi[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.GGi[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.GGi[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.GGi[0]));
        }
        if (localObject.GGi[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.GGi[1]));
        }
        if (localObject.GGi[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.GGi[2]));
        }
        if (localObject.GGi[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.GGi[3]));
        }
        if (localObject.GGi[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.GGi[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35254);
    super.eWx();
    eXl();
    AppMethodBeat.o(35254);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35247);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2) {
      com.tencent.mm.ck.d.eOM().fS(ChattingUI.class.getName() + ".Listview", 4);
    }
    AppMethodBeat.o(35247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.m
 * JD-Core Version:    0.7.0.1
 */