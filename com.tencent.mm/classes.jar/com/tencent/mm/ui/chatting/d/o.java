package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(fJv=m.class)
public class o
  extends a
  implements m
{
  private static String KcZ = "100134";
  private boolean KbQ;
  private HashSet<Long> KcT;
  private int KcU;
  private HashSet<Long> KcV;
  private HashSet<Long> KcW;
  private int KcX;
  private boolean KcY;
  private e.c Kda;
  private long Kdb;
  private boolean Kdc;
  private String Kdd;
  private long Kde;
  private int Kdf;
  private long nTW;
  
  public o()
  {
    AppMethodBeat.i(35241);
    this.KcT = new HashSet();
    this.KcV = new HashSet();
    this.KcW = new HashSet();
    this.KcX = 0;
    this.KcY = false;
    this.Kda = new o.5(this);
    this.Kdb = 0L;
    this.Kdc = false;
    this.Kdd = null;
    this.nTW = 0L;
    this.Kde = 0L;
    this.Kdf = 0;
    this.KbQ = false;
    AppMethodBeat.o(35241);
  }
  
  private void fHy()
  {
    AppMethodBeat.i(35245);
    com.tencent.mm.booter.z.fHE.uE(this.cXJ.getTalkerUserName());
    com.tencent.mm.modelstat.b.iqT.report();
    be localbe = new be();
    localbe.dnf.dng = false;
    com.tencent.mm.sdk.b.a.IvT.l(localbe);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).b("tmpl_type_succeed_contact", this.Kda);
    AppMethodBeat.o(35245);
  }
  
  private void fHz()
  {
    int i = 0;
    AppMethodBeat.i(35246);
    com.tencent.mm.plugin.report.service.g localg;
    if (this.Kdc)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.Kdb;
      this.Kdb = 0L;
      this.Kdc = false;
      localg = com.tencent.mm.plugin.report.service.g.yxI;
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
    this.Kdd = null;
    if (v.aAC() == null)
    {
      ae.e("MicroMsg.ChattingUI.ChattingReportComponent", "getUsernameFromUserInfo is null!");
      AppMethodBeat.o(35251);
      return;
    }
    if ((!v.aAC().equals(this.cXJ.getTalkerUserName())) && (this.cXJ.fJB()))
    {
      this.Kdd = this.cXJ.getTalkerUserName();
      this.nTW = (bl.aCr() / 1000L * 1000L);
      this.Kdf = 0;
      final String str = this.Kdd;
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(35239);
          if (!bu.isNullOrNil(str))
          {
            o.a(o.this, y.aG(str, x.hHV));
            ae.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { str, Integer.valueOf(o.a(o.this)), bu.Dz(o.b(o.this)), Long.valueOf(o.b(o.this)) });
            boolean bool1 = bool2;
            if (o.this.cXJ.fJB())
            {
              bool1 = bool2;
              if (o.this.cXJ.Cqh.eRd == 0) {
                bool1 = true;
              }
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).aX(str, bool1);
          }
          AppMethodBeat.o(35239);
        }
      });
    }
    fHz();
    AppMethodBeat.o(35251);
  }
  
  public final void adP(int paramInt)
  {
    this.KcU = paramInt;
  }
  
  public final void bH(final bv parambv)
  {
    AppMethodBeat.i(35242);
    if (!this.KcT.contains(Long.valueOf(parambv.field_msgSvrId)))
    {
      this.KcT.add(Long.valueOf(parambv.field_msgSvrId));
      com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "ChattingUI.adVideoExposeReport";
        }
        
        public final void run()
        {
          AppMethodBeat.i(35234);
          ((j)com.tencent.mm.kernel.g.ab(j.class)).aC(parambv);
          bv localbv = parambv;
          boolean bool1 = this.Kdg;
          Object localObject2 = new PString();
          Object localObject1 = new PString();
          boolean bool2;
          com.tencent.mm.modelsns.g localg;
          if (com.tencent.mm.ui.chatting.a.a(localbv, (PString)localObject2, (PString)localObject1))
          {
            Object localObject3 = ((PString)localObject2).value;
            String str = ((PString)localObject1).value;
            localObject2 = localbv.field_talker;
            bool2 = x.zT((String)localObject2);
            if (localbv.field_isSend != 1) {
              break label530;
            }
            localObject1 = v.aAC();
            localg = new com.tencent.mm.modelsns.g();
            localg.m("20source_publishid", (String)localObject3 + ",");
            localg.m("21uxinfo", str + ",");
            localg.m("22clienttime", bu.fpO() + ",");
            localObject3 = new StringBuilder();
            if (localbv.getType() != 62) {
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
            localg.m("28curr_msgid", localbv.field_msgSvrId + ",");
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
          for (int i = r.zC((String)localObject2);; i = 0)
          {
            localg.m("31chatroom_membercount", i + ",");
            ((j)com.tencent.mm.kernel.g.ab(j.class)).b(((j)com.tencent.mm.kernel.g.ab(j.class)).W(localbv), localg);
            ae.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + localg.RD());
            com.tencent.mm.plugin.report.service.g.yxI.f(12989, new Object[] { localg });
            AppMethodBeat.o(35234);
            return;
            if (bool2)
            {
              localObject1 = bl.BM(localbv.field_content);
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
  
  public final void bI(final bv parambv)
  {
    AppMethodBeat.i(35243);
    if (this.KcV.contains(Long.valueOf(parambv.field_msgSvrId)))
    {
      AppMethodBeat.o(35243);
      return;
    }
    this.KcV.add(Long.valueOf(parambv.field_msgSvrId));
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.expExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35235);
        com.tencent.mm.modelstat.a.a(parambv, a.a.iqP);
        AppMethodBeat.o(35235);
      }
    });
    AppMethodBeat.o(35243);
  }
  
  public final void bJ(final bv parambv)
  {
    AppMethodBeat.i(35244);
    if (!this.KcY)
    {
      this.KcY = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi(KcZ);
      if (localc.isValid()) {
        this.KcX = af.getInt((String)localc.fsy().get("needUploadData"), 0);
      }
    }
    if (this.KcX == 0)
    {
      AppMethodBeat.o(35244);
      return;
    }
    if (this.KcW.contains(Long.valueOf(parambv.field_msgSvrId)))
    {
      AppMethodBeat.o(35244);
      return;
    }
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.appExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35236);
        o.a(o.this, parambv);
        AppMethodBeat.o(35236);
      }
    });
    AppMethodBeat.o(35244);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35248);
    if (bu.isNullOrNil(this.cXJ.getTalkerUserName())) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(110L, 0L, 1L, true);
    }
    AppMethodBeat.o(35248);
  }
  
  public final void fAt()
  {
    int m = 0;
    AppMethodBeat.i(35249);
    this.Kdb = System.currentTimeMillis();
    this.Kdc = true;
    if ((this.cXJ.Cqh == null) || (this.cXJ.getTalkerUserName() == null) || (v.aAC() == null))
    {
      this.KbQ = true;
      report();
      AppMethodBeat.o(35249);
      return;
    }
    com.tencent.mm.modelstat.b.iqT.fb(this.cXJ.getTalkerUserName());
    Object localObject;
    if (!v.aAC().equals(this.cXJ.getTalkerUserName()))
    {
      localObject = new be();
      ((be)localObject).dnf.dng = true;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    com.tencent.mm.ui.chatting.ai.fGg().adF(1);
    boolean bool = ((at)this.cXJ.bh(at.class)).Pd();
    final int j;
    final int i;
    if ("notification_messages".equals(this.cXJ.getTalkerUserName()))
    {
      j = 1;
      i = 8;
      label168:
      if (!this.cXJ.fJA()) {
        break label505;
      }
      i = m;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((((com.tencent.mm.ui.chatting.d.b.h)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.h.class)).fHo()) || (((com.tencent.mm.ui.chatting.d.b.i)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fHq())) {
          break;
        }
        com.tencent.e.h.MqF.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35237);
            if (i == 2) {}
            for (int i = r.zC(o.this.cXJ.getTalkerUserName());; i = 0)
            {
              bc.aCg();
              Object localObject = com.tencent.mm.model.c.azL().aVa(o.this.cXJ.getTalkerUserName());
              if (localObject == null) {}
              for (int j = 0;; j = ((ba)localObject).field_unReadCount)
              {
                localObject = com.tencent.mm.booter.z.fHE;
                String str = o.this.cXJ.getTalkerUserName();
                int k = i;
                int m = j;
                if (((com.tencent.mm.booter.z)localObject).fHO == null) {
                  ((com.tencent.mm.booter.z)localObject).fHO = v.aAC();
                }
                if (!((com.tencent.mm.booter.z)localObject).fHO.equals(str))
                {
                  if (((com.tencent.mm.booter.z)localObject).fHI != null)
                  {
                    ae.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((com.tencent.mm.booter.z)localObject).fHI.fHV });
                    ((com.tencent.mm.booter.z)localObject).uE(((com.tencent.mm.booter.z)localObject).fHI.fHV);
                  }
                  if (((com.tencent.mm.booter.z)localObject).fHF.abw(6) == 0) {
                    ((com.tencent.mm.booter.z)localObject).fHF.setLong(4, bu.aRi());
                  }
                  com.tencent.mm.sdk.b.a.IvT.b(((com.tencent.mm.booter.z)localObject).fHG);
                  com.tencent.mm.sdk.b.a.IvT.b(((com.tencent.mm.booter.z)localObject).fHH);
                  ((com.tencent.mm.booter.z)localObject).appForegroundListener.alive();
                  ((com.tencent.mm.booter.z)localObject).fHI = new z.a((com.tencent.mm.booter.z)localObject);
                  ((com.tencent.mm.booter.z)localObject).fHI.fHZ = ((com.tencent.mm.booter.z)localObject).fHJ;
                  ((com.tencent.mm.booter.z)localObject).fHJ = 0;
                  ((com.tencent.mm.booter.z)localObject).fHI.fHV = str;
                  ((com.tencent.mm.booter.z)localObject).fHM = bu.HQ();
                  ((com.tencent.mm.booter.z)localObject).fHI.type = k;
                  ((com.tencent.mm.booter.z)localObject).fHI.fHW = m;
                  ((com.tencent.mm.booter.z)localObject).fHI.dla = j;
                  ((com.tencent.mm.booter.z)localObject).fHI.fHX = i;
                  ((com.tencent.mm.booter.z)localObject).fHI.enterTime = bu.aRi();
                  ae.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
                }
                AppMethodBeat.o(35237);
                return;
              }
            }
          }
        }, "MicroMsg.ChattingUI.ChattingReportComponent");
      }
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("tmpl_type_succeed_contact", this.Kda);
      break;
      if (x.Ao(this.cXJ.getTalkerUserName()))
      {
        localObject = (com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
        if (((com.tencent.mm.ui.chatting.d.b.d)localObject).fGJ())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            if (!((com.tencent.mm.ui.chatting.d.b.d)localObject).fGK()) {
              break label357;
            }
            ((com.tencent.mm.ui.chatting.d.b.d)localObject).fGH().aGE().size();
            k = 5;
            j = i;
            i = k;
            break;
          }
          label357:
          k = 4;
          j = i;
          i = k;
          break label168;
        }
        if (com.tencent.mm.al.g.Er(this.cXJ.getTalkerUserName()))
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
        if (com.tencent.mm.al.g.Es(this.cXJ.getTalkerUserName()))
        {
          j = 1;
          i = 0;
          break label168;
        }
        if (com.tencent.mm.al.g.En(this.cXJ.getTalkerUserName()))
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
        if (this.cXJ.fJB())
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
      label505:
      localObject = x.hIe;
      m = localObject.length;
      int k = 0;
      while (k < m)
      {
        if (localObject[k].equals(this.cXJ.getTalkerUserName())) {
          i = 0;
        }
        k += 1;
      }
    }
  }
  
  public final void fAu() {}
  
  public final void fAv()
  {
    AppMethodBeat.i(35250);
    com.tencent.mm.ui.chatting.ai.fGg().adF(2);
    if (!this.KbQ) {
      report();
    }
    this.KbQ = false;
    AppMethodBeat.o(35250);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35252);
    com.tencent.mm.ui.chatting.ai.fGg().adF(3);
    if ((!TextUtils.isEmpty(this.Kdd)) && (this.cXJ.fJB()))
    {
      this.Kde = bl.aCr();
      final String str = this.Kdd;
      this.Kdd = "";
      final int k = ((com.tencent.mm.ui.chatting.d.b.z)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.z.class)).fIt();
      if (k == 2) {
        ((com.tencent.mm.ui.chatting.d.b.z)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.z.class)).fIs();
      }
      int j = 0;
      final int i = j;
      if (this.cXJ.fJB())
      {
        i = j;
        if (this.cXJ.Cqh.eRd == 0) {
          i = 1;
        }
      }
      bc.ajU().aw(new Runnable()
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
          if (!bu.isNullOrNil(str))
          {
            n = r.zC(str);
            bc.aCg();
            localObject1 = com.tencent.mm.model.c.azI().H(str, o.b(o.this), o.c(o.this));
            if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
              break label490;
            }
            localObject2 = new bv();
            m = 0;
            k = 0;
            do
            {
              ((bv)localObject2).convertFrom((Cursor)localObject1);
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
            ae.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s", new Object[] { str, Long.valueOf(o.c(o.this) - o.b(o.this)), Integer.valueOf(n), Integer.valueOf(o.a(o.this) + i), Integer.valueOf(j), Integer.valueOf(o.a(o.this)), Integer.valueOf(k), Integer.valueOf(i), o.this.cXJ.aYW() });
            com.tencent.mm.plugin.report.service.g.yxI.f(12077, new Object[] { str, Long.valueOf(o.c(o.this) - o.b(o.this)), Integer.valueOf(n), Integer.valueOf(i + o.a(o.this)), Integer.valueOf(j), Integer.valueOf(o.a(o.this)), Integer.valueOf(k), Integer.valueOf(i), o.this.cXJ.aYW(), Integer.valueOf(o.d(o.this)) });
            localObject1 = w.zP(str);
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
  
  public final void fAx()
  {
    AppMethodBeat.i(35253);
    fHy();
    boolean bool1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doE().aqK(this.cXJ.getTalkerUserName());
    Object localObject = com.tencent.mm.ui.chatting.l.a.KsH;
    boolean bool2 = this.cXJ.fJC();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.KsI[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.KsI[0]));
      }
      if (localObject.KsI[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.KsI[1]));
      }
      if (localObject.KsI[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.KsI[2]));
      }
      if (localObject.KsI[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.KsI[3]));
      }
      if (localObject.KsI[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.KsI[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.ywz.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.l.b.KsK;
      ae.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).KsL), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).KsM), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).DMw), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.l.b)localObject).KsN) });
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(403L, 60L, ((com.tencent.mm.ui.chatting.l.b)localObject).mCount, true);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(403L, 61L, ((com.tencent.mm.ui.chatting.l.b)localObject).KsL, true);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(403L, 62L, ((com.tencent.mm.ui.chatting.l.b)localObject).KsM, true);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(403L, 63L, ((com.tencent.mm.ui.chatting.l.b)localObject).DMw, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.l.b)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.l.b)localObject).KsN));
      com.tencent.mm.plugin.report.e.ywz.b(localArrayList, true);
      com.tencent.mm.ui.chatting.ai.fGg().adF(4);
      AppMethodBeat.o(35253);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.KsI[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.KsI[0]));
        }
        if (localObject.KsI[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.KsI[1]));
        }
        if (localObject.KsI[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.KsI[2]));
        }
        if (localObject.KsI[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.KsI[3]));
        }
        if (localObject.KsI[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.KsI[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.KsI[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.KsI[0]));
        }
        if (localObject.KsI[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.KsI[1]));
        }
        if (localObject.KsI[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.KsI[2]));
        }
        if (localObject.KsI[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.KsI[3]));
        }
        if (localObject.KsI[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.KsI[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35254);
    super.fGE();
    fHy();
    AppMethodBeat.o(35254);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35247);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2) {
      com.tencent.mm.ci.d.fyy().gC(ChattingUI.class.getName() + ".Listview", 4);
    }
    AppMethodBeat.o(35247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.o
 * JD-Core Version:    0.7.0.1
 */