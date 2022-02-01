package com.tencent.mm.ui.chatting.component;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.bu;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.il;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.messenger.a.e.d;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.gnx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.component.api.ae;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.chatting.component.api.k;
import com.tencent.mm.ui.chatting.component.api.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=o.class)
public class r
  extends a
  implements o
{
  private static String aeqP = "100134";
  private int aciP;
  private boolean aepE;
  private HashSet<Long> aeqJ;
  private int aeqK;
  private HashSet<Long> aeqL;
  private HashSet<Long> aeqM;
  private int aeqN;
  private boolean aeqO;
  private e.d aeqQ;
  private long aeqR;
  private boolean aeqS;
  private String aeqT;
  private long aeqU;
  private int aeqV;
  private int aeqW;
  private int aeqX;
  private long enterTime;
  private long vsH;
  
  public r()
  {
    AppMethodBeat.i(35241);
    this.aeqJ = new HashSet();
    this.aeqL = new HashSet();
    this.aeqM = new HashSet();
    this.aeqN = 0;
    this.aeqO = false;
    this.aeqQ = new r.5(this);
    this.aeqR = 0L;
    this.aeqS = false;
    this.aeqT = null;
    this.vsH = 0L;
    this.aeqU = 0L;
    this.aeqV = 0;
    this.aeqW = 0;
    this.aciP = 0;
    this.aepE = false;
    AppMethodBeat.o(35241);
  }
  
  private void jrM()
  {
    AppMethodBeat.i(35245);
    com.tencent.mm.booter.z.lsV.Cq(this.hlc.getTalkerUserName());
    com.tencent.mm.modelstat.b.oUZ.report();
    Object localObject1 = new bu();
    ((bu)localObject1).hBN.hBO = false;
    ((bu)localObject1).publish();
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.e.class)).b("tmpl_type_succeed_contact", this.aeqQ);
    Object localObject2 = this.hlc.getTalkerUserName();
    if (this.enterTime != 0L)
    {
      localObject1 = new il();
      if (this.hlc.aezO.getIntExtra("chat_from_scene", 0) != 5) {
        break label221;
      }
      ((il)localObject1).izg = 1L;
      ((il)localObject1).imN = ((il)localObject1).F("ChatName", (String)localObject2, true);
      ((il)localObject1).iow = this.enterTime;
      ((il)localObject1).ioz = System.currentTimeMillis();
      ((il)localObject1).iQd = this.aeqX;
      ((il)localObject1).iQe = ac.Jj((String)localObject2);
      bh.bCz();
      localObject2 = com.tencent.mm.model.c.bzG().bxM((String)localObject2);
      if (localObject2 != null)
      {
        if (!"hidden_conv_parent".equalsIgnoreCase(((bd)localObject2).field_parentRef)) {
          break label231;
        }
        ((il)localObject1).iQf = 1L;
      }
    }
    for (;;)
    {
      ((il)localObject1).bMH();
      this.enterTime = 0L;
      AppMethodBeat.o(35245);
      return;
      label221:
      ((il)localObject1).izg = 2L;
      break;
      label231:
      if (((bd)localObject2).field_conversationTime > this.enterTime)
      {
        if (Util.isNullOrNil(((bd)localObject2).field_digestUser)) {}
        for (long l = 2L;; l = 3L)
        {
          ((il)localObject1).iQf = l;
          break;
        }
      }
      if ((!Util.isNullOrNil(((bd)localObject2).field_editingMsg)) || (((bd)localObject2).field_editingQuoteMsgId != 0L)) {
        ((il)localObject1).iQf = 4L;
      }
    }
  }
  
  private void jrN()
  {
    int i = 0;
    AppMethodBeat.i(35246);
    com.tencent.mm.plugin.report.service.h localh;
    if (this.aeqS)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.aeqR;
      this.aeqR = 0L;
      this.aeqS = false;
      localh = com.tencent.mm.plugin.report.service.h.OAn;
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
    this.aeqT = null;
    if (com.tencent.mm.model.z.bAM() == null)
    {
      Log.e("MicroMsg.ChattingUI.ChattingReportComponent", "getUsernameFromUserInfo is null!");
      AppMethodBeat.o(35251);
      return;
    }
    if ((!com.tencent.mm.model.z.bAM().equals(this.hlc.getTalkerUserName())) && (this.hlc.juF()))
    {
      this.aeqT = this.hlc.getTalkerUserName();
      this.vsH = (br.bCJ() / 1000L * 1000L);
      this.aeqV = 0;
      final String str = this.aeqT;
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(35239);
          if (!Util.isNullOrNil(str))
          {
            r.a(r.this, ac.b(str, com.tencent.mm.model.ab.ojY));
            Log.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { str, Integer.valueOf(r.a(r.this)), Util.unixTimeMsToTime(r.b(r.this)), Long.valueOf(r.b(r.this)) });
            boolean bool1 = bool2;
            if (r.this.hlc.juF())
            {
              bool1 = bool2;
              if (r.this.hlc.Uxa.kaf == 0) {
                bool1 = true;
              }
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.roomexpt.d.class)).bo(str, bool1);
          }
          AppMethodBeat.o(35239);
        }
      });
    }
    jrN();
    AppMethodBeat.o(35251);
  }
  
  public final void aCd(int paramInt)
  {
    this.aeqK = paramInt;
  }
  
  public final void cN(final cc paramcc)
  {
    AppMethodBeat.i(35242);
    if (!this.aeqJ.contains(Long.valueOf(paramcc.field_msgSvrId)))
    {
      this.aeqJ.add(Long.valueOf(paramcc.field_msgSvrId));
      com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
      {
        public final String getKey()
        {
          return "ChattingUI.adVideoExposeReport";
        }
        
        public final void run()
        {
          AppMethodBeat.i(35234);
          ((com.tencent.mm.plugin.sns.c.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.l.class)).bt(paramcc);
          cc localcc = paramcc;
          boolean bool1 = this.aeqY;
          Object localObject2 = new PString();
          Object localObject1 = new PString();
          boolean bool2;
          com.tencent.mm.modelsns.n localn;
          if (com.tencent.mm.ui.chatting.a.a(localcc, (PString)localObject2, (PString)localObject1))
          {
            Object localObject3 = ((PString)localObject2).value;
            String str = ((PString)localObject1).value;
            localObject2 = localcc.field_talker;
            bool2 = au.bwE((String)localObject2);
            if (localcc.field_isSend != 1) {
              break label530;
            }
            localObject1 = com.tencent.mm.model.z.bAM();
            localn = new com.tencent.mm.modelsns.n();
            localn.s("20source_publishid", (String)localObject3 + ",");
            localn.s("21uxinfo", str + ",");
            localn.s("22clienttime", Util.nowMilliSecond() + ",");
            localObject3 = new StringBuilder();
            if (localcc.getType() != 62) {
              break label554;
            }
            i = 1;
            label216:
            localn.s("23source_type", i + ",");
            localObject3 = new StringBuilder();
            if (!bool2) {
              break label559;
            }
            i = 4;
            label252:
            localn.s("24scene", i + ",");
            localn.s("25scene_chatname", (String)localObject2 + ",");
            localn.s("26scene_username", (String)localObject1 + ",");
            localn.s("27curr_publishid", ",");
            localn.s("28curr_msgid", localcc.field_msgSvrId + ",");
            localn.s("29curr_favid", "0,");
            localObject1 = new StringBuilder();
            if (!bool1) {
              break label564;
            }
            i = 1;
            label390:
            localn.s("30isdownload", i + ",");
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
          for (int i = v.getMembersCountByChatRoomName((String)localObject2);; i = 0)
          {
            localn.s("31chatroom_membercount", i + ",");
            ((com.tencent.mm.plugin.sns.c.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.l.class)).b(((com.tencent.mm.plugin.sns.c.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.l.class)).at(localcc), localn);
            Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + localn.aIF());
            com.tencent.mm.plugin.report.service.h.OAn.b(12989, new Object[] { localn });
            AppMethodBeat.o(35234);
            return;
            if (bool2)
            {
              localObject1 = br.JJ(localcc.field_content);
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
  
  public final void cO(final cc paramcc)
  {
    AppMethodBeat.i(35243);
    if (this.aeqL.contains(Long.valueOf(paramcc.field_msgSvrId)))
    {
      AppMethodBeat.o(35243);
      return;
    }
    this.aeqL.add(Long.valueOf(paramcc.field_msgSvrId));
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.expExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35235);
        com.tencent.mm.modelstat.a.a(paramcc, a.a.oUV);
        AppMethodBeat.o(35235);
      }
    });
    AppMethodBeat.o(35243);
  }
  
  public final void cP(final cc paramcc)
  {
    AppMethodBeat.i(35244);
    if (!this.aeqO)
    {
      this.aeqO = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.newabtest.d.bEt().Fd(aeqP);
      if ((localc != null) && (localc.isValid())) {
        this.aeqN = com.tencent.mm.platformtools.ab.ew((String)localc.iWZ().get("needUploadData"));
      }
    }
    if (this.aeqN == 0)
    {
      AppMethodBeat.o(35244);
      return;
    }
    if (this.aeqM.contains(Long.valueOf(paramcc.field_msgSvrId)))
    {
      AppMethodBeat.o(35244);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.appExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35236);
        r.a(r.this, paramcc);
        AppMethodBeat.o(35236);
      }
    });
    AppMethodBeat.o(35244);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35248);
    if (Util.isNullOrNil(this.hlc.getTalkerUserName())) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(110L, 0L, 1L, true);
    }
    String str = this.hlc.getTalkerUserName();
    this.enterTime = 0L;
    if (!Util.isNullOrNil(str))
    {
      bh.bCz();
      bb localbb = com.tencent.mm.model.c.bzG().bxM(str);
      if ((localbb != null) && ("hidden_conv_parent".equalsIgnoreCase(localbb.field_parentRef)))
      {
        this.enterTime = System.currentTimeMillis();
        this.aeqX = ac.Jj(str);
      }
    }
    AppMethodBeat.o(35248);
  }
  
  public final void jjg()
  {
    int m = 0;
    AppMethodBeat.i(35249);
    this.aeqR = System.currentTimeMillis();
    this.aeqS = true;
    if ((this.hlc.Uxa == null) || (this.hlc.getTalkerUserName() == null) || (com.tencent.mm.model.z.bAM() == null))
    {
      this.aepE = true;
      report();
      AppMethodBeat.o(35249);
      return;
    }
    com.tencent.mm.modelstat.b.oUZ.hZ(this.hlc.getTalkerUserName());
    Object localObject;
    if (!com.tencent.mm.model.z.bAM().equals(this.hlc.getTalkerUserName()))
    {
      localObject = new bu();
      ((bu)localObject).hBN.hBO = true;
      ((bu)localObject).publish();
    }
    al.jqa().aBS(1);
    label144:
    boolean bool;
    final int j;
    final int i;
    if (au.bwE(this.hlc.getTalkerUserName()))
    {
      com.tencent.mm.plugin.finder.report.l.Fpv.Sh(2);
      bool = ((bf)this.hlc.cm(bf.class)).aGe();
      if (!"notification_messages".equals(this.hlc.getTalkerUserName())) {
        break label320;
      }
      j = 1;
      i = 8;
      label185:
      if (!this.hlc.juE()) {
        break label553;
      }
      i = m;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((((com.tencent.mm.ui.chatting.component.api.i)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA()) || (((k)this.hlc.cm(k.class)).jrF()) || (((com.tencent.mm.ui.chatting.component.api.r)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.r.class)).jrT())) {
          break;
        }
        com.tencent.threadpool.h.ahAA.g(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35237);
            if (i == 2) {}
            for (int i = v.getMembersCountByChatRoomName(r.this.hlc.getTalkerUserName());; i = 0)
            {
              bh.bCz();
              Object localObject = com.tencent.mm.model.c.bzG().bxM(r.this.hlc.getTalkerUserName());
              if (localObject == null) {}
              for (int j = 0;; j = ((bd)localObject).field_unReadCount)
              {
                localObject = com.tencent.mm.booter.z.lsV;
                String str = r.this.hlc.getTalkerUserName();
                int k = i;
                int m = j;
                if (((com.tencent.mm.booter.z)localObject).ltf == null) {
                  ((com.tencent.mm.booter.z)localObject).ltf = com.tencent.mm.model.z.bAM();
                }
                if (!((com.tencent.mm.booter.z)localObject).ltf.equals(str))
                {
                  if (((com.tencent.mm.booter.z)localObject).lsZ != null)
                  {
                    Log.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((com.tencent.mm.booter.z)localObject).lsZ.ltm });
                    ((com.tencent.mm.booter.z)localObject).Cq(((com.tencent.mm.booter.z)localObject).lsZ.ltm);
                  }
                  if (((com.tencent.mm.booter.z)localObject).lsW.ayQ(6) == 0) {
                    ((com.tencent.mm.booter.z)localObject).lsW.setLong(4, Util.nowSecond());
                  }
                  ((com.tencent.mm.booter.z)localObject).lsX.alive();
                  ((com.tencent.mm.booter.z)localObject).lsY.alive();
                  ((com.tencent.mm.booter.z)localObject).appForegroundListener.alive();
                  ((com.tencent.mm.booter.z)localObject).lsZ = new z.a((com.tencent.mm.booter.z)localObject);
                  ((com.tencent.mm.booter.z)localObject).lsZ.ltq = ((com.tencent.mm.booter.z)localObject).lta;
                  ((com.tencent.mm.booter.z)localObject).lta = 0;
                  ((com.tencent.mm.booter.z)localObject).lsZ.ltm = str;
                  ((com.tencent.mm.booter.z)localObject).ltd = Util.currentTicks();
                  ((com.tencent.mm.booter.z)localObject).lsZ.type = k;
                  ((com.tencent.mm.booter.z)localObject).lsZ.ltn = m;
                  ((com.tencent.mm.booter.z)localObject).lsZ.hzj = j;
                  ((com.tencent.mm.booter.z)localObject).lsZ.lto = i;
                  ((com.tencent.mm.booter.z)localObject).lsZ.enterTime = Util.nowSecond();
                  Log.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
                }
                AppMethodBeat.o(35237);
                return;
              }
            }
          }
        }, "MicroMsg.ChattingUI.ChattingReportComponent");
      }
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.e.class)).a("tmpl_type_succeed_contact", this.aeqQ);
      break;
      com.tencent.mm.plugin.finder.report.l.Fpv.Sh(1);
      break label144;
      label320:
      if (com.tencent.mm.model.ab.IS(this.hlc.getTalkerUserName()))
      {
        localObject = (com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class);
        if (((com.tencent.mm.ui.chatting.component.api.e)localObject).jqV())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            if (!((com.tencent.mm.ui.chatting.component.api.e)localObject).jqW()) {
              break label405;
            }
            ((com.tencent.mm.ui.chatting.component.api.e)localObject).jqT().bHw().size();
            k = 5;
            j = i;
            i = k;
            break;
          }
          k = 4;
          j = i;
          i = k;
          break label185;
        }
        if (com.tencent.mm.an.g.MA(this.hlc.getTalkerUserName()))
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
        if (com.tencent.mm.an.g.MB(this.hlc.getTalkerUserName()))
        {
          j = 1;
          i = 0;
          break label185;
        }
        if (com.tencent.mm.an.g.Mw(this.hlc.getTalkerUserName()))
        {
          j = 6;
          i = 0;
        }
      }
      for (;;)
      {
        label405:
        k = j;
        j = i;
        i = k;
        break;
        j = 7;
        i = 0;
        continue;
        if (this.hlc.juF())
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
      label553:
      localObject = com.tencent.mm.model.ab.oko;
      m = localObject.length;
      int k = 0;
      while (k < m)
      {
        if (localObject[k].equals(this.hlc.getTalkerUserName())) {
          i = 0;
        }
        k += 1;
      }
    }
  }
  
  public final void jjh() {}
  
  public final void jji()
  {
    AppMethodBeat.i(35250);
    al.jqa().aBS(2);
    gnx localgnx = (gnx)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(13, "report_" + this.hlc.getTalkerUserName());
    if (localgnx != null) {
      this.aciP = localgnx.aciP;
    }
    if (!this.aepE) {
      report();
    }
    this.aepE = false;
    AppMethodBeat.o(35250);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35252);
    al.jqa().aBS(3);
    final String str;
    final int j;
    if ((!TextUtils.isEmpty(this.aeqT)) && (this.hlc.juF()))
    {
      this.aeqU = br.bCJ();
      str = this.aeqT;
      this.aeqT = "";
      j = ((ae)this.hlc.cm(ae.class)).jsZ();
      if (j == 2) {
        ((ae)this.hlc.cm(ae.class)).jsY();
      }
      if ((!this.hlc.juF()) || (this.hlc.Uxa.kaf != 0)) {
        break label233;
      }
    }
    label233:
    for (final int i = 1;; i = 0)
    {
      if (5 == this.hlc.aezO.getIntExtra("chat_from_scene", 0)) {
        Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "from_scene_gobal_search");
      }
      for (this.aeqW = 2;; this.aeqW = this.hlc.aezO.getIntExtra("chat_from_scene_for_group_chats", 0))
      {
        final int k = this.aeqW;
        Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "enterSceneForGroupChats : " + this.aeqW);
        this.aeqW = 0;
        bh.baH().postToWorker(new Runnable()
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
              n = v.getMembersCountByChatRoomName(str);
              bh.bCz();
              localObject1 = com.tencent.mm.model.c.bzD().M(str, r.b(r.this), r.c(r.this));
              if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
                break label613;
              }
              localObject2 = new cc();
              m = 0;
              k = 0;
              do
              {
                ((cc)localObject2).convertFrom((Cursor)localObject1);
                if (((fi)localObject2).field_isSend != 1) {
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
              Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s ,enterSceneForGroupChatsState:%d， msgRedType：%s", new Object[] { str, Long.valueOf(r.c(r.this) - r.b(r.this)), Integer.valueOf(n), Integer.valueOf(r.a(r.this) + i), Integer.valueOf(j), Integer.valueOf(r.a(r.this)), Integer.valueOf(j), Integer.valueOf(i), r.this.hlc.cez(), Integer.valueOf(k), Integer.valueOf(r.d(r.this)) });
              localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
              localObject2 = str;
              long l1 = r.c(r.this);
              long l2 = r.b(r.this);
              m = r.a(r.this);
              int i1 = r.a(r.this);
              int i2 = j;
              int i3 = i;
              String str = r.this.hlc.cez();
              int i4 = r.e(r.this);
              int i5 = k;
              int i6 = r.d(r.this);
              if (v.Iv(str)) {}
              for (k = 1;; k = 0)
              {
                ((com.tencent.mm.plugin.report.service.h)localObject1).b(12077, new Object[] { localObject2, Long.valueOf(l1 - l2), Integer.valueOf(n), Integer.valueOf(i + m), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(k) });
                localObject1 = aa.getDisplayName(str);
                localObject2 = (com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.roomexpt.d.class);
                str = str;
                l1 = r.c(r.this);
                l2 = r.b(r.this);
                i = r.a(r.this);
                if (i == 1) {
                  bool = true;
                }
                ((com.tencent.mm.plugin.expt.roomexpt.d)localObject2).a(str, (String)localObject1, l1 - l2, i, j, bool);
                AppMethodBeat.o(35240);
                return;
                i = m + 1;
                j = k;
                break;
              }
              label613:
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
  
  public final void jjk()
  {
    AppMethodBeat.i(35253);
    jrM();
    boolean bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaU().aLo(this.hlc.getTalkerUserName());
    Object localObject = com.tencent.mm.ui.chatting.i.b.aeJi;
    boolean bool2 = this.hlc.juG();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.aeJj[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.aeJj[0]));
      }
      if (localObject.aeJj[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.aeJj[1]));
      }
      if (localObject.aeJj[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.aeJj[2]));
      }
      if (localObject.aeJj[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.aeJj[3]));
      }
      if (localObject.aeJj[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.aeJj[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      f.Ozc.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.i.c.aeJl;
      Log.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.i.c)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.i.c)localObject).aeJm), Integer.valueOf(((com.tencent.mm.ui.chatting.i.c)localObject).aeJn), Integer.valueOf(((com.tencent.mm.ui.chatting.i.c)localObject).WgD), Integer.valueOf(((com.tencent.mm.ui.chatting.i.c)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.i.c)localObject).aeJo) });
      f.Ozc.idkeyStat(403L, 60L, ((com.tencent.mm.ui.chatting.i.c)localObject).mCount, true);
      f.Ozc.idkeyStat(403L, 61L, ((com.tencent.mm.ui.chatting.i.c)localObject).aeJm, true);
      f.Ozc.idkeyStat(403L, 62L, ((com.tencent.mm.ui.chatting.i.c)localObject).aeJn, true);
      f.Ozc.idkeyStat(403L, 63L, ((com.tencent.mm.ui.chatting.i.c)localObject).WgD, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.i.c)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.i.c)localObject).aeJo));
      f.Ozc.b(localArrayList, true);
      al.jqa().aBS(4);
      AppMethodBeat.o(35253);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.aeJj[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.aeJj[0]));
        }
        if (localObject.aeJj[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.aeJj[1]));
        }
        if (localObject.aeJj[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.aeJj[2]));
        }
        if (localObject.aeJj[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.aeJj[3]));
        }
        if (localObject.aeJj[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.aeJj[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.aeJj[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.aeJj[0]));
        }
        if (localObject.aeJj[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.aeJj[1]));
        }
        if (localObject.aeJj[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.aeJj[2]));
        }
        if (localObject.aeJj[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.aeJj[3]));
        }
        if (localObject.aeJj[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.aeJj[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35254);
    super.jqF();
    jrM();
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
 * Qualified Name:     com.tencent.mm.ui.chatting.component.r
 * JD-Core Version:    0.7.0.1
 */