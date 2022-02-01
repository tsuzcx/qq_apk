package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.b.a.fa;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
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
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(gRF=m.class)
public class o
  extends a
  implements m
{
  private static String Pow = "100134";
  private boolean Pnm;
  private String PoA;
  private long PoB;
  private int PoC;
  private int PoD;
  private int PoE;
  private HashSet<Long> Poq;
  private int Por;
  private HashSet<Long> Pos;
  private HashSet<Long> Pot;
  private int Pou;
  private boolean Pov;
  private e.c Pox;
  private long Poy;
  private boolean Poz;
  private long enterTime;
  private long peJ;
  
  public o()
  {
    AppMethodBeat.i(35241);
    this.Poq = new HashSet();
    this.Pos = new HashSet();
    this.Pot = new HashSet();
    this.Pou = 0;
    this.Pov = false;
    this.Pox = new o.5(this);
    this.Poy = 0L;
    this.Poz = false;
    this.PoA = null;
    this.peJ = 0L;
    this.PoB = 0L;
    this.PoC = 0;
    this.PoD = 0;
    this.Pnm = false;
    AppMethodBeat.o(35241);
  }
  
  private void gPE()
  {
    AppMethodBeat.i(35245);
    com.tencent.mm.booter.z.gmQ.CU(this.dom.getTalkerUserName());
    com.tencent.mm.modelstat.b.jmd.report();
    Object localObject1 = new com.tencent.mm.g.a.bg();
    ((com.tencent.mm.g.a.bg)localObject1).dEu.dEv = false;
    EventCenter.instance.publish((IEvent)localObject1);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).b("tmpl_type_succeed_contact", this.Pox);
    Object localObject2 = this.dom.getTalkerUserName();
    if (this.enterTime != 0L)
    {
      localObject1 = new fa();
      if (this.dom.Pwc.getIntExtra("chat_from_scene", 0) != 5) {
        break label224;
      }
      ((fa)localObject1).etp = 1L;
      ((fa)localObject1).emL = ((fa)localObject1).x("ChatName", (String)localObject2, true);
      ((fa)localObject1).eEP = this.enterTime;
      ((fa)localObject1).eEQ = System.currentTimeMillis();
      ((fa)localObject1).eER = this.PoE;
      ((fa)localObject1).eES = ac.JT((String)localObject2);
      com.tencent.mm.model.bg.aVF();
      localObject2 = com.tencent.mm.model.c.aST().bjY((String)localObject2);
      if (localObject2 != null)
      {
        if (!"hidden_conv_parent".equalsIgnoreCase(((bb)localObject2).field_parentRef)) {
          break label234;
        }
        ((fa)localObject1).eET = 1L;
      }
    }
    for (;;)
    {
      ((fa)localObject1).bfK();
      this.enterTime = 0L;
      AppMethodBeat.o(35245);
      return;
      label224:
      ((fa)localObject1).etp = 2L;
      break;
      label234:
      if (((bb)localObject2).field_conversationTime > this.enterTime)
      {
        if (Util.isNullOrNil(((bb)localObject2).field_digestUser)) {}
        for (long l = 2L;; l = 3L)
        {
          ((fa)localObject1).eET = l;
          break;
        }
      }
      if ((!Util.isNullOrNil(((bb)localObject2).field_editingMsg)) || (((bb)localObject2).field_editingQuoteMsgId != 0L)) {
        ((fa)localObject1).eET = 4L;
      }
    }
  }
  
  private void gPF()
  {
    int i = 0;
    AppMethodBeat.i(35246);
    com.tencent.mm.plugin.report.service.h localh;
    if (this.Poz)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.Poy;
      this.Poy = 0L;
      this.Poz = false;
      localh = com.tencent.mm.plugin.report.service.h.CyF;
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
    this.PoA = null;
    if (com.tencent.mm.model.z.aTY() == null)
    {
      Log.e("MicroMsg.ChattingUI.ChattingReportComponent", "getUsernameFromUserInfo is null!");
      AppMethodBeat.o(35251);
      return;
    }
    if ((!com.tencent.mm.model.z.aTY().equals(this.dom.getTalkerUserName())) && (this.dom.gRL()))
    {
      this.PoA = this.dom.getTalkerUserName();
      this.peJ = (bp.aVP() / 1000L * 1000L);
      this.PoC = 0;
      final String str = this.PoA;
      com.tencent.mm.model.bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          boolean bool2 = false;
          AppMethodBeat.i(35239);
          if (!Util.isNullOrNil(str))
          {
            o.a(o.this, ac.aI(str, com.tencent.mm.model.ab.iCF));
            Log.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { str, Integer.valueOf(o.a(o.this)), Util.unixTimeMsToTime(o.b(o.this)), Long.valueOf(o.b(o.this)) });
            boolean bool1 = bool2;
            if (o.this.dom.gRL())
            {
              bool1 = bool2;
              if (o.this.dom.GUe.fuH == 0) {
                bool1 = true;
              }
            }
            ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.roomexpt.d.class)).aZ(str, bool1);
          }
          AppMethodBeat.o(35239);
        }
      });
    }
    gPF();
    AppMethodBeat.o(35251);
  }
  
  public final void amA(int paramInt)
  {
    this.Por = paramInt;
  }
  
  public final void bX(ca paramca)
  {
    AppMethodBeat.i(35242);
    if (!this.Poq.contains(Long.valueOf(paramca.field_msgSvrId)))
    {
      this.Poq.add(Long.valueOf(paramca.field_msgSvrId));
      com.tencent.f.h.RTc.aX(new o.1(this, paramca));
    }
    AppMethodBeat.o(35242);
  }
  
  public final void bY(final ca paramca)
  {
    AppMethodBeat.i(35243);
    if (this.Pos.contains(Long.valueOf(paramca.field_msgSvrId)))
    {
      AppMethodBeat.o(35243);
      return;
    }
    this.Pos.add(Long.valueOf(paramca.field_msgSvrId));
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.expExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35235);
        com.tencent.mm.modelstat.a.a(paramca, a.a.jlZ);
        AppMethodBeat.o(35235);
      }
    });
    AppMethodBeat.o(35243);
  }
  
  public final void bZ(final ca paramca)
  {
    AppMethodBeat.i(35244);
    if (!this.Pov)
    {
      this.Pov = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu(Pow);
      if (localc.isValid()) {
        this.Pou = af.getInt((String)localc.gzz().get("needUploadData"), 0);
      }
    }
    if (this.Pou == 0)
    {
      AppMethodBeat.o(35244);
      return;
    }
    if (this.Pot.contains(Long.valueOf(paramca.field_msgSvrId)))
    {
      AppMethodBeat.o(35244);
      return;
    }
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "ChattingUI.appExposeReport";
      }
      
      public final void run()
      {
        AppMethodBeat.i(35236);
        o.a(o.this, paramca);
        AppMethodBeat.o(35236);
      }
    });
    AppMethodBeat.o(35244);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35250);
    ai.gOk().amq(2);
    if (!this.Pnm) {
      report();
    }
    this.Pnm = false;
    AppMethodBeat.o(35250);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35252);
    ai.gOk().amq(3);
    final String str;
    final int j;
    if ((!TextUtils.isEmpty(this.PoA)) && (this.dom.gRL()))
    {
      this.PoB = bp.aVP();
      str = this.PoA;
      this.PoA = "";
      j = ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).gQE();
      if (j == 2) {
        ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).gQD();
      }
      if ((!this.dom.gRL()) || (this.dom.GUe.fuH != 0)) {
        break label233;
      }
    }
    label233:
    for (final int i = 1;; i = 0)
    {
      if (5 == this.dom.Pwc.getIntExtra("chat_from_scene", 0)) {
        Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "from_scene_gobal_search");
      }
      for (this.PoD = 2;; this.PoD = this.dom.Pwc.getIntExtra("chat_from_scene_for_group_chats", 0))
      {
        final int k = this.PoD;
        Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "enterSceneForGroupChats : " + this.PoD);
        this.PoD = 0;
        com.tencent.mm.model.bg.aAk().postToWorker(new Runnable()
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
              n = v.Ie(str);
              com.tencent.mm.model.bg.aVF();
              localObject1 = com.tencent.mm.model.c.aSQ().I(str, o.b(o.this), o.c(o.this));
              if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst())) {
                break label512;
              }
              localObject2 = new ca();
              m = 0;
              k = 0;
              do
              {
                ((ca)localObject2).convertFrom((Cursor)localObject1);
                if (((eo)localObject2).field_isSend != 1) {
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
              Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s ,enterSceneForGroupChatsState:%d", new Object[] { str, Long.valueOf(o.c(o.this) - o.b(o.this)), Integer.valueOf(n), Integer.valueOf(o.a(o.this) + i), Integer.valueOf(j), Integer.valueOf(o.a(o.this)), Integer.valueOf(j), Integer.valueOf(i), o.this.dom.bul(), Integer.valueOf(k) });
              com.tencent.mm.plugin.report.service.h.CyF.a(12077, new Object[] { str, Long.valueOf(o.c(o.this) - o.b(o.this)), Integer.valueOf(n), Integer.valueOf(i + o.a(o.this)), Integer.valueOf(j), Integer.valueOf(o.a(o.this)), Integer.valueOf(j), Integer.valueOf(i), o.this.dom.bul(), Integer.valueOf(o.d(o.this)), Integer.valueOf(k) });
              localObject1 = aa.getDisplayName(str);
              localObject2 = (com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.roomexpt.d.class);
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
  
  public final void gIk()
  {
    AppMethodBeat.i(35248);
    if (Util.isNullOrNil(this.dom.getTalkerUserName())) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(110L, 0L, 1L, true);
    }
    String str = this.dom.getTalkerUserName();
    this.enterTime = 0L;
    if (!Util.isNullOrNil(str))
    {
      com.tencent.mm.model.bg.aVF();
      az localaz = com.tencent.mm.model.c.aST().bjY(str);
      if ((localaz != null) && ("hidden_conv_parent".equalsIgnoreCase(localaz.field_parentRef)))
      {
        this.enterTime = System.currentTimeMillis();
        this.PoE = ac.JT(str);
      }
    }
    AppMethodBeat.o(35248);
  }
  
  public final void gIl()
  {
    int m = 0;
    AppMethodBeat.i(35249);
    this.Poy = System.currentTimeMillis();
    this.Poz = true;
    if ((this.dom.GUe == null) || (this.dom.getTalkerUserName() == null) || (com.tencent.mm.model.z.aTY() == null))
    {
      this.Pnm = true;
      report();
      AppMethodBeat.o(35249);
      return;
    }
    com.tencent.mm.modelstat.b.jmd.fP(this.dom.getTalkerUserName());
    Object localObject;
    if (!com.tencent.mm.model.z.aTY().equals(this.dom.getTalkerUserName()))
    {
      localObject = new com.tencent.mm.g.a.bg();
      ((com.tencent.mm.g.a.bg)localObject).dEu.dEv = true;
      EventCenter.instance.publish((IEvent)localObject);
    }
    ai.gOk().amq(1);
    boolean bool = ((aw)this.dom.bh(aw.class)).Zx();
    final int j;
    final int i;
    if ("notification_messages".equals(this.dom.getTalkerUserName()))
    {
      j = 1;
      i = 8;
      label168:
      if (!this.dom.gRK()) {
        break label505;
      }
      i = m;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((((com.tencent.mm.ui.chatting.d.b.h)this.dom.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu()) || (((com.tencent.mm.ui.chatting.d.b.i)this.dom.bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw())) {
          break;
        }
        com.tencent.f.h.RTc.b(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35237);
            if (i == 2) {}
            for (int i = v.Ie(o.this.dom.getTalkerUserName());; i = 0)
            {
              com.tencent.mm.model.bg.aVF();
              Object localObject = com.tencent.mm.model.c.aST().bjY(o.this.dom.getTalkerUserName());
              if (localObject == null) {}
              for (int j = 0;; j = ((bb)localObject).field_unReadCount)
              {
                localObject = com.tencent.mm.booter.z.gmQ;
                String str = o.this.dom.getTalkerUserName();
                int k = i;
                int m = j;
                if (((com.tencent.mm.booter.z)localObject).gna == null) {
                  ((com.tencent.mm.booter.z)localObject).gna = com.tencent.mm.model.z.aTY();
                }
                if (!((com.tencent.mm.booter.z)localObject).gna.equals(str))
                {
                  if (((com.tencent.mm.booter.z)localObject).gmU != null)
                  {
                    Log.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((com.tencent.mm.booter.z)localObject).gmU.gnh });
                    ((com.tencent.mm.booter.z)localObject).CU(((com.tencent.mm.booter.z)localObject).gmU.gnh);
                  }
                  if (((com.tencent.mm.booter.z)localObject).gmR.ake(6) == 0) {
                    ((com.tencent.mm.booter.z)localObject).gmR.setLong(4, Util.nowSecond());
                  }
                  EventCenter.instance.add(((com.tencent.mm.booter.z)localObject).gmS);
                  EventCenter.instance.add(((com.tencent.mm.booter.z)localObject).gmT);
                  ((com.tencent.mm.booter.z)localObject).appForegroundListener.alive();
                  ((com.tencent.mm.booter.z)localObject).gmU = new z.a((com.tencent.mm.booter.z)localObject);
                  ((com.tencent.mm.booter.z)localObject).gmU.gnl = ((com.tencent.mm.booter.z)localObject).gmV;
                  ((com.tencent.mm.booter.z)localObject).gmV = 0;
                  ((com.tencent.mm.booter.z)localObject).gmU.gnh = str;
                  ((com.tencent.mm.booter.z)localObject).gmY = Util.currentTicks();
                  ((com.tencent.mm.booter.z)localObject).gmU.type = k;
                  ((com.tencent.mm.booter.z)localObject).gmU.gni = m;
                  ((com.tencent.mm.booter.z)localObject).gmU.dCm = j;
                  ((com.tencent.mm.booter.z)localObject).gmU.gnj = i;
                  ((com.tencent.mm.booter.z)localObject).gmU.enterTime = Util.nowSecond();
                  Log.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
                }
                AppMethodBeat.o(35237);
                return;
              }
            }
          }
        }, "MicroMsg.ChattingUI.ChattingReportComponent");
      }
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("tmpl_type_succeed_contact", this.Pox);
      break;
      if (com.tencent.mm.model.ab.IT(this.dom.getTalkerUserName()))
      {
        localObject = (com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
        if (((com.tencent.mm.ui.chatting.d.b.d)localObject).gOP())
        {
          if (bool) {}
          for (i = 0;; i = 1)
          {
            if (!((com.tencent.mm.ui.chatting.d.b.d)localObject).gOQ()) {
              break label357;
            }
            ((com.tencent.mm.ui.chatting.d.b.d)localObject).gON().bax().size();
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
        if (com.tencent.mm.al.g.Nf(this.dom.getTalkerUserName()))
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
        if (com.tencent.mm.al.g.Ng(this.dom.getTalkerUserName()))
        {
          j = 1;
          i = 0;
          break label168;
        }
        if (com.tencent.mm.al.g.Nb(this.dom.getTalkerUserName()))
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
        if (this.dom.gRL())
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
      localObject = com.tencent.mm.model.ab.iCO;
      m = localObject.length;
      int k = 0;
      while (k < m)
      {
        if (localObject[k].equals(this.dom.getTalkerUserName())) {
          i = 0;
        }
        k += 1;
      }
    }
  }
  
  public final void gIm() {}
  
  public final void gIn()
  {
    AppMethodBeat.i(35253);
    gPE();
    boolean bool1 = ((l)com.tencent.mm.kernel.g.af(l.class)).eit().aEf(this.dom.getTalkerUserName());
    Object localObject = com.tencent.mm.ui.chatting.l.b.PEW;
    boolean bool2 = this.dom.gRM();
    ArrayList localArrayList = new ArrayList();
    if ((bool2) && (!bool1))
    {
      if (localObject.PEX[0] > 0) {
        localArrayList.add(new IDKey(890, 0, localObject.PEX[0]));
      }
      if (localObject.PEX[1] > 0) {
        localArrayList.add(new IDKey(890, 1, localObject.PEX[1]));
      }
      if (localObject.PEX[2] > 0) {
        localArrayList.add(new IDKey(890, 2, localObject.PEX[2]));
      }
      if (localObject.PEX[3] > 0) {
        localArrayList.add(new IDKey(890, 3, localObject.PEX[3]));
      }
      if (localObject.PEX[4] > 0) {
        localArrayList.add(new IDKey(890, 4, localObject.PEX[4]));
      }
      localArrayList.add(new IDKey(890, 19, 1));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.Cxv.b(localArrayList, true);
      localObject = com.tencent.mm.ui.chatting.l.c.PEZ;
      Log.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(((com.tencent.mm.ui.chatting.l.c)localObject).mCount), Integer.valueOf(((com.tencent.mm.ui.chatting.l.c)localObject).PFa), Integer.valueOf(((com.tencent.mm.ui.chatting.l.c)localObject).PFb), Integer.valueOf(((com.tencent.mm.ui.chatting.l.c)localObject).IvL), Integer.valueOf(((com.tencent.mm.ui.chatting.l.c)localObject).mSuccessCount), Integer.valueOf(((com.tencent.mm.ui.chatting.l.c)localObject).PFc) });
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(403L, 60L, ((com.tencent.mm.ui.chatting.l.c)localObject).mCount, true);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(403L, 61L, ((com.tencent.mm.ui.chatting.l.c)localObject).PFa, true);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(403L, 62L, ((com.tencent.mm.ui.chatting.l.c)localObject).PFb, true);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(403L, 63L, ((com.tencent.mm.ui.chatting.l.c)localObject).IvL, true);
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(403, 64, ((com.tencent.mm.ui.chatting.l.c)localObject).mSuccessCount));
      localArrayList.add(new IDKey(403, 65, ((com.tencent.mm.ui.chatting.l.c)localObject).PFc));
      com.tencent.mm.plugin.report.e.Cxv.b(localArrayList, true);
      ai.gOk().amq(4);
      AppMethodBeat.o(35253);
      return;
      if ((bool2) && (bool1))
      {
        if (localObject.PEX[0] > 0) {
          localArrayList.add(new IDKey(890, 40, localObject.PEX[0]));
        }
        if (localObject.PEX[1] > 0) {
          localArrayList.add(new IDKey(890, 41, localObject.PEX[1]));
        }
        if (localObject.PEX[2] > 0) {
          localArrayList.add(new IDKey(890, 42, localObject.PEX[2]));
        }
        if (localObject.PEX[3] > 0) {
          localArrayList.add(new IDKey(890, 43, localObject.PEX[3]));
        }
        if (localObject.PEX[4] > 0) {
          localArrayList.add(new IDKey(890, 44, localObject.PEX[4]));
        }
        localArrayList.add(new IDKey(890, 59, 1));
      }
      else
      {
        if (localObject.PEX[0] > 0) {
          localArrayList.add(new IDKey(890, 20, localObject.PEX[0]));
        }
        if (localObject.PEX[1] > 0) {
          localArrayList.add(new IDKey(890, 21, localObject.PEX[1]));
        }
        if (localObject.PEX[2] > 0) {
          localArrayList.add(new IDKey(890, 22, localObject.PEX[2]));
        }
        if (localObject.PEX[3] > 0) {
          localArrayList.add(new IDKey(890, 23, localObject.PEX[3]));
        }
        if (localObject.PEX[4] > 0) {
          localArrayList.add(new IDKey(890, 24, localObject.PEX[4]));
        }
        localArrayList.add(new IDKey(890, 39, 1));
      }
    }
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35254);
    super.gOK();
    gPE();
    AppMethodBeat.o(35254);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35247);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2) {
      com.tencent.mm.ci.d.gGm().gV(ChattingUI.class.getName() + ".Listview", 4);
    }
    AppMethodBeat.o(35247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.o
 * JD-Core Version:    0.7.0.1
 */