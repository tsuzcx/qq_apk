package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.g;
import com.tencent.mm.app.o.a;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.f.a.bl;
import com.tencent.mm.f.b.a.gq;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.d;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.d.b.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(hRc=m.class)
public class p
  extends a
  implements m
{
  private static String WIJ = "100134";
  private boolean WHy;
  private HashSet<Long> WID;
  private int WIE;
  private HashSet<Long> WIF;
  private HashSet<Long> WIG;
  private int WIH;
  private boolean WII;
  private e.d WIK;
  private long WIL;
  private boolean WIM;
  private String WIN;
  private long WIO;
  private int WIP;
  private int WIQ;
  private int WIR;
  private long enterTime;
  private long sgN;
  
  public p()
  {
    AppMethodBeat.i(35241);
    this.WID = new HashSet();
    this.WIF = new HashSet();
    this.WIG = new HashSet();
    this.WIH = 0;
    this.WII = false;
    this.WIK = new p.5(this);
    this.WIL = 0L;
    this.WIM = false;
    this.WIN = null;
    this.sgN = 0L;
    this.WIO = 0L;
    this.WIP = 0;
    this.WIQ = 0;
    this.WHy = false;
    AppMethodBeat.o(35241);
  }
  
  private void hOW()
  {
    AppMethodBeat.i(35245);
    com.tencent.mm.booter.z.iQZ.JK(this.fgR.getTalkerUserName());
    com.tencent.mm.modelstat.b.mcf.report();
    Object localObject1 = new bl();
    ((bl)localObject1).fxi.fxj = false;
    EventCenter.instance.publish((IEvent)localObject1);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).b("tmpl_type_succeed_contact", this.WIK);
    Object localObject2 = this.fgR.getTalkerUserName();
    if (this.enterTime != 0L)
    {
      localObject1 = new gq();
      if (this.fgR.WQv.getIntExtra("chat_from_scene", 0) != 5) {
        break label224;
      }
      ((gq)localObject1).gpu = 1L;
      ((gq)localObject1).ggg = ((gq)localObject1).z("ChatName", (String)localObject2, true);
      ((gq)localObject1).gDb = this.enterTime;
      ((gq)localObject1).gDc = System.currentTimeMillis();
      ((gq)localObject1).gDd = this.WIR;
      ((gq)localObject1).gDe = ac.Rl((String)localObject2);
      bh.beI();
      localObject2 = com.tencent.mm.model.c.bbR().bwx((String)localObject2);
      if (localObject2 != null)
      {
        if (!"hidden_conv_parent".equalsIgnoreCase(((bb)localObject2).field_parentRef)) {
          break label234;
        }
        ((gq)localObject1).gDf = 1L;
      }
    }
    for (;;)
    {
      ((gq)localObject1).bpa();
      this.enterTime = 0L;
      AppMethodBeat.o(35245);
      return;
      label224:
      ((gq)localObject1).gpu = 2L;
      break;
      label234:
      if (((bb)localObject2).field_conversationTime > this.enterTime)
      {
        if (Util.isNullOrNil(((bb)localObject2).field_digestUser)) {}
        for (long l = 2L;; l = 3L)
        {
          ((gq)localObject1).gDf = l;
          break;
        }
      }
      if ((!Util.isNullOrNil(((bb)localObject2).field_editingMsg)) || (((bb)localObject2).field_editingQuoteMsgId != 0L)) {
        ((gq)localObject1).gDf = 4L;
      }
    }
  }
  
  private void hOX()
  {
    int i = 0;
    AppMethodBeat.i(35246);
    com.tencent.mm.plugin.report.service.h localh;
    if (this.WIM)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.WIL;
      this.WIL = 0L;
      this.WIM = false;
      localh = com.tencent.mm.plugin.report.service.h.IzE;
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
    this.WIN = null;
    if (com.tencent.mm.model.z.bcZ() == null)
    {
      Log.e("MicroMsg.ChattingUI.ChattingReportComponent", "getUsernameFromUserInfo is null!");
      AppMethodBeat.o(35251);
      return;
    }
    if ((!com.tencent.mm.model.z.bcZ().equals(this.fgR.getTalkerUserName())) && (this.fgR.hRh()))
    {
      this.WIN = this.fgR.getTalkerUserName();
      this.sgN = (bq.beS() / 1000L * 1000L);
      this.WIP = 0;
      final String str = this.WIN;
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(35239);
          if (!Util.isNullOrNil(str))
          {
            p.a(p.this, ac.aM(str, com.tencent.mm.model.ab.lsA));
            Log.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { str, Integer.valueOf(p.a(p.this)), Util.unixTimeMsToTime(p.b(p.this)), Long.valueOf(p.b(p.this)) });
            boolean bool1 = bool2;
            if (p.this.fgR.hRh())
            {
              bool1 = bool2;
              if (p.this.fgR.NKq.hDj == 0) {
                bool1 = true;
              }
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.roomexpt.d.class)).bc(str, bool1);
          }
          AppMethodBeat.o(35239);
        }
      });
    }
    hOX();
    AppMethodBeat.o(35251);
  }
  
  public final void avB(int paramInt)
  {
    this.WIE = paramInt;
  }
  
  public final void cr(final ca paramca)
  {
    AppMethodBeat.i(35242);
    if (!this.WID.contains(Long.valueOf(paramca.field_msgSvrId)))
    {
      this.WID.add(Long.valueOf(paramca.field_msgSvrId));
      com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "ChattingUI.adVideoExposeReport";
        }
        
        public final void run()
        {
          AppMethodBeat.i(35234);
          ((k)com.tencent.mm.kernel.h.ae(k.class)).bc(paramca);
          ca localca = paramca;
          boolean bool1 = this.WIS;
          Object localObject2 = new PString();
          Object localObject1 = new PString();
          boolean bool2;
          com.tencent.mm.modelsns.n localn;
          if (com.tencent.mm.ui.chatting.a.a(localca, (PString)localObject2, (PString)localObject1))
          {
            Object localObject3 = ((PString)localObject2).value;
            String str = ((PString)localObject1).value;
            localObject2 = localca.field_talker;
            bool2 = com.tencent.mm.model.ab.PO((String)localObject2);
            if (localca.field_isSend != 1) {
              break label530;
            }
            localObject1 = com.tencent.mm.model.z.bcZ();
            localn = new com.tencent.mm.modelsns.n();
            localn.m("20source_publishid", (String)localObject3 + ",");
            localn.m("21uxinfo", str + ",");
            localn.m("22clienttime", Util.nowMilliSecond() + ",");
            localObject3 = new StringBuilder();
            if (localca.getType() != 62) {
              break label554;
            }
            i = 1;
            label216:
            localn.m("23source_type", i + ",");
            localObject3 = new StringBuilder();
            if (!bool2) {
              break label559;
            }
            i = 4;
            label252:
            localn.m("24scene", i + ",");
            localn.m("25scene_chatname", (String)localObject2 + ",");
            localn.m("26scene_username", (String)localObject1 + ",");
            localn.m("27curr_publishid", ",");
            localn.m("28curr_msgid", localca.field_msgSvrId + ",");
            localn.m("29curr_favid", "0,");
            localObject1 = new StringBuilder();
            if (!bool1) {
              break label564;
            }
            i = 1;
            label390:
            localn.m("30isdownload", i + ",");
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
          for (int i = v.Pu((String)localObject2);; i = 0)
          {
            localn.m("31chatroom_membercount", i + ",");
            ((k)com.tencent.mm.kernel.h.ae(k.class)).b(((k)com.tencent.mm.kernel.h.ae(k.class)).ao(localca), localn);
            Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + localn.agI());
            com.tencent.mm.plugin.report.service.h.IzE.a(12989, new Object[] { localn });
            AppMethodBeat.o(35234);
            return;
            if (bool2)
            {
              localObject1 = bq.RL(localca.field_content);
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
  
  public final void cs(final ca paramca)
  {
    AppMethodBeat.i(35243);
    if (this.WIF.contains(Long.valueOf(paramca.field_msgSvrId)))
    {
      AppMethodBeat.o(35243);
      return;
    }
    this.WIF.add(Long.valueOf(paramca.field_msgSvrId));
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.expExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35235);
        com.tencent.mm.modelstat.a.a(paramca, a.a.mca);
        AppMethodBeat.o(35235);
      }
    });
    AppMethodBeat.o(35243);
  }
  
  public final void ct(final ca paramca)
  {
    AppMethodBeat.i(35244);
    if (!this.WII)
    {
      this.WII = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.bgB().Mu(WIJ);
      if (localc.isValid()) {
        this.WIH = ae.df((String)localc.hvz().get("needUploadData"));
      }
    }
    if (this.WIH == 0)
    {
      AppMethodBeat.o(35244);
      return;
    }
    if (this.WIG.contains(Long.valueOf(paramca.field_msgSvrId)))
    {
      AppMethodBeat.o(35244);
      return;
    }
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.appExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35236);
        p.a(p.this, paramca);
        AppMethodBeat.o(35236);
      }
    });
    AppMethodBeat.o(35244);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35248);
    if (Util.isNullOrNil(this.fgR.getTalkerUserName())) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(110L, 0L, 1L, true);
    }
    String str = this.fgR.getTalkerUserName();
    this.enterTime = 0L;
    if (!Util.isNullOrNil(str))
    {
      bh.beI();
      az localaz = com.tencent.mm.model.c.bbR().bwx(str);
      if ((localaz != null) && ("hidden_conv_parent".equalsIgnoreCase(localaz.field_parentRef)))
      {
        this.enterTime = System.currentTimeMillis();
        this.WIR = ac.Rl(str);
      }
    }
    AppMethodBeat.o(35248);
  }
  
  public final void hGV()
  {
    int m = 0;
    AppMethodBeat.i(35249);
    this.WIL = System.currentTimeMillis();
    this.WIM = true;
    if ((this.fgR.NKq == null) || (this.fgR.getTalkerUserName() == null) || (com.tencent.mm.model.z.bcZ() == null))
    {
      this.WHy = true;
      report();
      AppMethodBeat.o(35249);
      return;
    }
    com.tencent.mm.modelstat.b.mcf.gz(this.fgR.getTalkerUserName());
    Object localObject;
    if (!com.tencent.mm.model.z.bcZ().equals(this.fgR.getTalkerUserName()))
    {
      localObject = new bl();
      ((bl)localObject).fxi.fxj = true;
      EventCenter.instance.publish((IEvent)localObject);
    }
    ai.hNu().avq(1);
    label147:
    boolean bool;
    final int j;
    final int i;
    if (com.tencent.mm.model.ab.Lj(this.fgR.getTalkerUserName()))
    {
      com.tencent.mm.plugin.finder.report.f.zUP.Pf(2);
      bool = ((com.tencent.mm.ui.chatting.d.b.ax)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).aeg();
      if (!"notification_messages".equals(this.fgR.getTalkerUserName())) {
        break label302;
      }
      j = 1;
      i = 8;
      label188:
      if (!this.fgR.hRg()) {
        break label535;
      }
      i = m;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((((com.tencent.mm.ui.chatting.d.b.h)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK()) || (((com.tencent.mm.ui.chatting.d.b.i)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP())) {
          break;
        }
        com.tencent.e.h.ZvG.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35237);
            if (i == 2) {}
            for (int i = v.Pu(p.this.fgR.getTalkerUserName());; i = 0)
            {
              bh.beI();
              Object localObject = com.tencent.mm.model.c.bbR().bwx(p.this.fgR.getTalkerUserName());
              if (localObject == null) {}
              for (int j = 0;; j = ((bb)localObject).field_unReadCount)
              {
                localObject = com.tencent.mm.booter.z.iQZ;
                String str = p.this.fgR.getTalkerUserName();
                int k = i;
                int m = j;
                if (((com.tencent.mm.booter.z)localObject).iRj == null) {
                  ((com.tencent.mm.booter.z)localObject).iRj = com.tencent.mm.model.z.bcZ();
                }
                if (!((com.tencent.mm.booter.z)localObject).iRj.equals(str))
                {
                  if (((com.tencent.mm.booter.z)localObject).iRd != null)
                  {
                    Log.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((com.tencent.mm.booter.z)localObject).iRd.iRq });
                    ((com.tencent.mm.booter.z)localObject).JK(((com.tencent.mm.booter.z)localObject).iRd.iRq);
                  }
                  if (((com.tencent.mm.booter.z)localObject).iRa.asB(6) == 0) {
                    ((com.tencent.mm.booter.z)localObject).iRa.setLong(4, Util.nowSecond());
                  }
                  EventCenter.instance.add(((com.tencent.mm.booter.z)localObject).iRb);
                  EventCenter.instance.add(((com.tencent.mm.booter.z)localObject).iRc);
                  ((com.tencent.mm.booter.z)localObject).appForegroundListener.alive();
                  ((com.tencent.mm.booter.z)localObject).iRd = new z.a((com.tencent.mm.booter.z)localObject);
                  ((com.tencent.mm.booter.z)localObject).iRd.iRu = ((com.tencent.mm.booter.z)localObject).iRe;
                  ((com.tencent.mm.booter.z)localObject).iRe = 0;
                  ((com.tencent.mm.booter.z)localObject).iRd.iRq = str;
                  ((com.tencent.mm.booter.z)localObject).iRh = Util.currentTicks();
                  ((com.tencent.mm.booter.z)localObject).iRd.type = k;
                  ((com.tencent.mm.booter.z)localObject).iRd.iRr = m;
                  ((com.tencent.mm.booter.z)localObject).iRd.fuP = j;
                  ((com.tencent.mm.booter.z)localObject).iRd.iRs = i;
                  ((com.tencent.mm.booter.z)localObject).iRd.enterTime = Util.nowSecond();
                  Log.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
                }
                AppMethodBeat.o(35237);
                return;
              }
            }
          }
        }, "MicroMsg.ChattingUI.ChattingReportComponent");
      }
      ((e)com.tencent.mm.kernel.h.ae(e.class)).a("tmpl_type_succeed_contact", this.WIK);
      break;
      com.tencent.mm.plugin.finder.report.f.zUP.Pf(1);
      break label147;
      label302:
      if (com.tencent.mm.model.ab.Qm(this.fgR.getTalkerUserName()))
      {
        localObject = (com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
        if (((com.tencent.mm.ui.chatting.d.b.d)localObject).hOe())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            if (!((com.tencent.mm.ui.chatting.d.b.d)localObject).hOf()) {
              break label387;
            }
            ((com.tencent.mm.ui.chatting.d.b.d)localObject).hOc().bjL().size();
            k = 5;
            j = i;
            i = k;
            break;
          }
          k = 4;
          j = i;
          i = k;
          break label188;
        }
        if (g.UB(this.fgR.getTalkerUserName()))
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
        if (g.UC(this.fgR.getTalkerUserName()))
        {
          j = 1;
          i = 0;
          break label188;
        }
        if (g.Ux(this.fgR.getTalkerUserName()))
        {
          j = 6;
          i = 0;
        }
      }
      for (;;)
      {
        label387:
        k = j;
        j = i;
        i = k;
        break;
        j = 7;
        i = 0;
        continue;
        if (this.fgR.hRh())
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
      label535:
      localObject = com.tencent.mm.model.ab.lsO;
      m = localObject.length;
      int k = 0;
      while (k < m)
      {
        if (localObject[k].equals(this.fgR.getTalkerUserName())) {
          i = 0;
        }
        k += 1;
      }
    }
  }
  
  public final void hGW() {}
  
  public final void hGX()
  {
    AppMethodBeat.i(35250);
    ai.hNu().avq(2);
    if (!this.WHy) {
      report();
    }
    this.WHy = false;
    AppMethodBeat.o(35250);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35252);
    ai.hNu().avq(3);
    final String str;
    final int j;
    if ((!TextUtils.isEmpty(this.WIN)) && (this.fgR.hRh()))
    {
      this.WIO = bq.beS();
      str = this.WIN;
      this.WIN = "";
      j = ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).hQb();
      if (j == 2) {
        ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).hQa();
      }
      if ((!this.fgR.hRh()) || (this.fgR.NKq.hDj != 0)) {
        break label233;
      }
    }
    label233:
    for (final int i = 1;; i = 0)
    {
      if (5 == this.fgR.WQv.getIntExtra("chat_from_scene", 0)) {
        Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "from_scene_gobal_search");
      }
      for (this.WIQ = 2;; this.WIQ = this.fgR.WQv.getIntExtra("chat_from_scene_for_group_chats", 0))
      {
        final int k = this.WIQ;
        Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "enterSceneForGroupChats : " + this.WIQ);
        this.WIQ = 0;
        bh.aHJ().postToWorker(new Runnable()
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
            if (!Util.isNullOrNil(str))
            {
              n = v.Pu(str);
              bh.beI();
              localObject1 = com.tencent.mm.model.c.bbO().H(str, p.b(p.this), p.c(p.this));
              if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
                break label512;
              }
              localObject2 = new ca();
              m = 0;
              k = 0;
              do
              {
                ((ca)localObject2).convertFrom((Cursor)localObject1);
                if (((et)localObject2).field_isSend != 1) {
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
              Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s ,enterSceneForGroupChatsState:%d", new Object[] { str, Long.valueOf(p.c(p.this) - p.b(p.this)), Integer.valueOf(n), Integer.valueOf(p.a(p.this) + i), Integer.valueOf(j), Integer.valueOf(p.a(p.this)), Integer.valueOf(j), Integer.valueOf(i), p.this.fgR.bFl(), Integer.valueOf(k) });
              com.tencent.mm.plugin.report.service.h.IzE.a(12077, new Object[] { str, Long.valueOf(p.c(p.this) - p.b(p.this)), Integer.valueOf(n), Integer.valueOf(i + p.a(p.this)), Integer.valueOf(j), Integer.valueOf(p.a(p.this)), Integer.valueOf(j), Integer.valueOf(i), p.this.fgR.bFl(), Integer.valueOf(p.d(p.this)), Integer.valueOf(k) });
              localObject1 = aa.PJ(str);
              localObject2 = (com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.roomexpt.d.class);
              String str = str;
              long l1 = p.c(p.this);
              long l2 = p.b(p.this);
              i = p.a(p.this);
              if (i == 1) {
                bool = true;
              }
              ((com.tencent.mm.plugin.expt.roomexpt.d)localObject2).a(str, (String)localObject1, l1 - l2, i, j, bool);
              AppMethodBeat.o(35240);
              return;
              i = m + 1;
              j = k;
              break;
              label512:
              i = 0;
              j = 0;
            }
          }
        });
        AppMethodBeat.o(35252);
        return;
      }
    }
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35253);
    hOW();
    boolean bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eRZ().aOp(this.fgR.getTalkerUserName());
    Object localObject = com.tencent.mm.ui.chatting.m.b.WZI;
    boolean bool2 = this.fgR.hRi();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.WZJ[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.WZJ[0]));
      }
      if (localObject.WZJ[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.WZJ[1]));
      }
      if (localObject.WZJ[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.WZJ[2]));
      }
      if (localObject.WZJ[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.WZJ[3]));
      }
      if (localObject.WZJ[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.WZJ[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.f.Iyx.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.m.c.WZL;
      Log.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.m.c)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.m.c)localObject).WZM), Integer.valueOf(((com.tencent.mm.ui.chatting.m.c)localObject).WZN), Integer.valueOf(((com.tencent.mm.ui.chatting.m.c)localObject).PpQ), Integer.valueOf(((com.tencent.mm.ui.chatting.m.c)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.m.c)localObject).WZO) });
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(403L, 60L, ((com.tencent.mm.ui.chatting.m.c)localObject).mCount, true);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(403L, 61L, ((com.tencent.mm.ui.chatting.m.c)localObject).WZM, true);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(403L, 62L, ((com.tencent.mm.ui.chatting.m.c)localObject).WZN, true);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(403L, 63L, ((com.tencent.mm.ui.chatting.m.c)localObject).PpQ, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.m.c)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.m.c)localObject).WZO));
      com.tencent.mm.plugin.report.f.Iyx.b(localArrayList, true);
      ai.hNu().avq(4);
      AppMethodBeat.o(35253);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.WZJ[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.WZJ[0]));
        }
        if (localObject.WZJ[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.WZJ[1]));
        }
        if (localObject.WZJ[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.WZJ[2]));
        }
        if (localObject.WZJ[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.WZJ[3]));
        }
        if (localObject.WZJ[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.WZJ[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.WZJ[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.WZJ[0]));
        }
        if (localObject.WZJ[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.WZJ[1]));
        }
        if (localObject.WZJ[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.WZJ[2]));
        }
        if (localObject.WZJ[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.WZJ[3]));
        }
        if (localObject.WZJ[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.WZJ[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35254);
    super.hNZ();
    hOW();
    AppMethodBeat.o(35254);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35247);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    AppMethodBeat.o(35247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.p
 * JD-Core Version:    0.7.0.1
 */