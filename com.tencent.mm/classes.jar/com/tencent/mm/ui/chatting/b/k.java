package com.tencent.mm.ui.chatting.b;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.booter.z;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.h.a.at;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.b.a.a(cFA=i.class)
public class k
  extends a
  implements i
{
  private static String vpD = "100134";
  private long hSH = 0L;
  private boolean voZ = false;
  private HashSet<Long> vpA = new HashSet();
  private int vpB = 0;
  private boolean vpC = false;
  private e.c vpE = new k.4(this);
  private long vpF = 0L;
  private boolean vpG = false;
  private String vpH = null;
  private long vpI = 0L;
  private int vpJ = 0;
  private HashSet<Long> vpy = new HashSet();
  private HashSet<Long> vpz = new HashSet();
  
  private void cEk()
  {
    int i = 0;
    h localh;
    if (this.vpG)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.vpF;
      this.vpF = 0L;
      this.vpG = false;
      localh = h.nFQ;
      if (i >= 8) {
        break label134;
      }
      if (l1 - l2 >= new long[] { 0L, 200L, 400L, 600L, 800L, 1000L, 1500L, 2000L }[i]) {
        break label115;
      }
    }
    label134:
    for (;;)
    {
      localh.a(109L, i, 1L, true);
      return;
      label115:
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
  
  private void wn()
  {
    this.vpH = null;
    if ((!q.Gj().equals(this.byx.getTalkerUserName())) && (this.byx.cFD()))
    {
      this.vpH = this.byx.getTalkerUserName();
      this.hSH = (bd.HM() / 1000L * 1000L);
      this.vpJ = 0;
      final String str = this.vpH;
      au.DS().O(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          if (!bk.bl(str))
          {
            k.a(k.this, t.Q(str, s.dUT));
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { str, Integer.valueOf(k.a(k.this)), bk.hr(k.b(k.this)), Long.valueOf(k.b(k.this)) });
            boolean bool1 = bool2;
            if (k.this.byx.cFD())
            {
              bool1 = bool2;
              if (k.this.byx.pSb.cCy == 0) {
                bool1 = true;
              }
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.expt.roomexpt.d.class)).ax(str, bool1);
          }
        }
      });
    }
    com.tencent.mm.modelstat.d.b(3, "ChattingUI" + this.byx.vtz.getIdentityString(), hashCode());
    cEk();
  }
  
  public final void aU(bi parambi)
  {
    if (!this.vpy.contains(Long.valueOf(parambi.field_msgSvrId)))
    {
      this.vpy.add(Long.valueOf(parambi.field_msgSvrId));
      com.tencent.mm.sdk.f.e.post(new k.1(this, parambi), "ChattingUI.adVideoExposeReport");
    }
  }
  
  public final void aV(bi parambi)
  {
    if (this.vpz.contains(Long.valueOf(parambi.field_msgSvrId))) {
      return;
    }
    this.vpz.add(Long.valueOf(parambi.field_msgSvrId));
    com.tencent.mm.sdk.f.e.post(new k.2(this, parambi), "ChattingUI.expExposeReport");
  }
  
  public final void aW(bi parambi)
  {
    if (!this.vpC)
    {
      this.vpC = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ(vpD);
      if (localc.isValid()) {
        this.vpB = ah.getInt((String)localc.ctr().get("needUploadData"), 0);
      }
    }
    if (this.vpB == 0) {}
    while (this.vpA.contains(Long.valueOf(parambi.field_msgSvrId))) {
      return;
    }
    com.tencent.mm.sdk.f.e.post(new k.3(this, parambi), "ChattingUI.appExposeReport");
  }
  
  public final void cyM()
  {
    if (bk.bl(this.byx.getTalkerUserName())) {
      h.nFQ.a(110L, 0L, 1L, true);
    }
  }
  
  public final void cyN()
  {
    this.vpF = System.currentTimeMillis();
    this.vpG = true;
    if ((this.byx.pSb == null) || (this.byx.getTalkerUserName() == null))
    {
      this.voZ = true;
      wn();
      return;
    }
    com.tencent.mm.modelstat.b.eBD.cd(this.byx.getTalkerUserName());
    Object localObject;
    if (!q.Gj().equals(this.byx.getTalkerUserName()))
    {
      localObject = new at();
      ((at)localObject).bGY.bGZ = true;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
    boolean bool = ((com.tencent.mm.ui.chatting.b.b.ai)this.byx.ac(com.tencent.mm.ui.chatting.b.b.ai.class)).Bj();
    int j;
    int k;
    int i;
    if ("notification_messages".equals(this.byx.getTalkerUserName()))
    {
      j = 1;
      k = 0;
      i = 8;
      label142:
      if (!this.byx.cFC()) {
        break label736;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        au.Hx();
        localObject = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
        if (localObject != null) {
          break label785;
        }
      }
      label785:
      for (int m = 0;; m = ((as)localObject).field_unReadCount)
      {
        localObject = z.diw;
        String str = this.byx.getTalkerUserName();
        if (((z)localObject).diG == null) {
          ((z)localObject).diG = q.Gj();
        }
        if (!((z)localObject).diG.equals(str))
        {
          if (((z)localObject).diA != null)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((z)localObject).diA.diN });
            ((z)localObject).et(((z)localObject).diA.diN);
          }
          if (((z)localObject).dix.Fl(6) == 0) {
            ((z)localObject).dix.setLong(4, ah.UX());
          }
          com.tencent.mm.sdk.b.a.udP.b(((z)localObject).diy);
          com.tencent.mm.sdk.b.a.udP.b(((z)localObject).diz);
          ((z)localObject).diA = new z.a((z)localObject);
          ((z)localObject).diA.diS = ((z)localObject).diB;
          ((z)localObject).diB = 0;
          ((z)localObject).diA.diN = str;
          ((z)localObject).diE = ah.UZ();
          ((z)localObject).diA.type = i;
          ((z)localObject).diA.diO = j;
          ((z)localObject).diA.bFo = m;
          ((z)localObject).diA.diP = k;
          ((z)localObject).diA.diQ = ah.UX();
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(k) });
        }
        ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("tmpl_type_succeed_contact", this.vpE);
        break;
        if (s.hl(this.byx.getTalkerUserName()))
        {
          localObject = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
          if (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDG())
          {
            if (bool) {}
            for (i = 0;; i = 1)
            {
              if (!((com.tencent.mm.ui.chatting.b.b.c)localObject).cDH()) {
                break label581;
              }
              k = ((com.tencent.mm.ui.chatting.b.b.c)localObject).cDE().MN().size();
              m = 5;
              j = i;
              i = m;
              break;
            }
            label581:
            k = 0;
            m = 4;
            j = i;
            i = m;
            break label142;
          }
          if (com.tencent.mm.ai.f.lb(this.byx.getTalkerUserName()))
          {
            if (bool) {}
            for (j = 0;; j = 1)
            {
              k = 0;
              i = 3;
              break;
            }
          }
          if (com.tencent.mm.ai.f.lc(this.byx.getTalkerUserName()))
          {
            j = 1;
            k = 0;
            i = 0;
            break label142;
          }
          if (com.tencent.mm.ai.f.kY(this.byx.getTalkerUserName()))
          {
            i = 6;
            j = 0;
          }
        }
        for (;;)
        {
          k = 0;
          break;
          i = 7;
          j = 0;
          continue;
          if (this.byx.cFD())
          {
            k = m.gM(this.byx.getTalkerUserName());
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
        label736:
        localObject = s.dVc;
        int n = localObject.length;
        m = 0;
        while (m < n)
        {
          if (localObject[m].equals(this.byx.getTalkerUserName())) {
            i = 0;
          }
          m += 1;
        }
      }
    }
  }
  
  public final void cyO() {}
  
  public final void cyP()
  {
    if (!this.voZ) {
      wn();
    }
    this.voZ = false;
  }
  
  public final void cyQ()
  {
    if ((!TextUtils.isEmpty(this.vpH)) && (this.byx.cFD()))
    {
      this.vpI = bd.HM();
      final String str = this.vpH;
      this.vpH = "";
      final int k = ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).cEU();
      if (k == 2) {
        ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).cET();
      }
      int j = 0;
      final int i = j;
      if (this.byx.cFD())
      {
        i = j;
        if (this.byx.pSb.cCy == 0) {
          i = 1;
        }
      }
      au.DS().O(new Runnable()
      {
        public final void run()
        {
          boolean bool = false;
          int n;
          Object localObject1;
          Object localObject2;
          int m;
          int k;
          int j;
          int i;
          if (!bk.bl(str))
          {
            n = m.gM(str);
            au.Hx();
            localObject1 = com.tencent.mm.model.c.Fy().v(str, k.b(k.this), k.c(k.this));
            if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
              break label438;
            }
            localObject2 = new bi();
            m = 0;
            k = 0;
            do
            {
              ((bi)localObject2).d((Cursor)localObject1);
              if (((cs)localObject2).field_isSend != 1) {
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
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d", new Object[] { str, Long.valueOf(k.c(k.this) - k.b(k.this)), Integer.valueOf(n), Integer.valueOf(k.a(k.this) + i), Integer.valueOf(j), Integer.valueOf(k.a(k.this)), Integer.valueOf(k), Integer.valueOf(i) });
            h.nFQ.f(12077, new Object[] { str, Long.valueOf(k.c(k.this) - k.b(k.this)), Integer.valueOf(n), Integer.valueOf(i + k.a(k.this)), Integer.valueOf(j), Integer.valueOf(k.a(k.this)), Integer.valueOf(k), Integer.valueOf(i) });
            localObject1 = com.tencent.mm.model.r.gV(str);
            localObject2 = (com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.expt.roomexpt.d.class);
            String str = str;
            long l1 = k.c(k.this);
            long l2 = k.b(k.this);
            i = k.a(k.this);
            if (i == 1) {
              bool = true;
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)localObject2).a(str, (String)localObject1, l1 - l2, i, j, bool);
            return;
            i = m + 1;
            j = k;
            break;
            label438:
            i = 0;
            j = 0;
          }
        }
      });
    }
  }
  
  public final void cyR()
  {
    z.diw.et(this.byx.getTalkerUserName());
    com.tencent.mm.modelstat.b.eBD.wn();
    Object localObject = new at();
    ((at)localObject).bGY.bGZ = false;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).b("tmpl_type_succeed_contact", this.vpE);
    boolean bool1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().Hk(this.byx.getTalkerUserName());
    localObject = com.tencent.mm.ui.chatting.i.a.vzl;
    boolean bool2 = this.byx.cFE();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.vzm[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.vzm[0]));
      }
      if (localObject.vzm[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.vzm[1]));
      }
      if (localObject.vzm[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.vzm[2]));
      }
      if (localObject.vzm[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.vzm[3]));
      }
      if (localObject.vzm[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.vzm[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.f.nEG.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.i.b.vzo;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.byx.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.i.b)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.i.b)localObject).vzp), Integer.valueOf(((com.tencent.mm.ui.chatting.i.b)localObject).vzq), Integer.valueOf(((com.tencent.mm.ui.chatting.i.b)localObject).qPO), Integer.valueOf(((com.tencent.mm.ui.chatting.i.b)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.i.b)localObject).vzr) });
      com.tencent.mm.plugin.report.f.nEG.a(403L, 60L, ((com.tencent.mm.ui.chatting.i.b)localObject).mCount, true);
      com.tencent.mm.plugin.report.f.nEG.a(403L, 61L, ((com.tencent.mm.ui.chatting.i.b)localObject).vzp, true);
      com.tencent.mm.plugin.report.f.nEG.a(403L, 62L, ((com.tencent.mm.ui.chatting.i.b)localObject).vzq, true);
      com.tencent.mm.plugin.report.f.nEG.a(403L, 63L, ((com.tencent.mm.ui.chatting.i.b)localObject).qPO, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.i.b)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.i.b)localObject).vzr));
      com.tencent.mm.plugin.report.f.nEG.b(localArrayList, true);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.vzm[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.vzm[0]));
        }
        if (localObject.vzm[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.vzm[1]));
        }
        if (localObject.vzm[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.vzm[2]));
        }
        if (localObject.vzm[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.vzm[3]));
        }
        if (localObject.vzm[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.vzm[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.vzm[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.vzm[0]));
        }
        if (localObject.vzm[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.vzm[1]));
        }
        if (localObject.vzm[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.vzm[2]));
        }
        if (localObject.vzm[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.vzm[3]));
        }
        if (localObject.vzm[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.vzm[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2) {
      com.tencent.mm.ch.d.cxA().dA(ChattingUI.class.getName() + ".Listview", 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.k
 * JD-Core Version:    0.7.0.1
 */