package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.c.b.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

final class p$8
  implements AppPanel.a
{
  com.tencent.mm.ui.widget.b.d pxp = null;
  
  p$8(p paramp) {}
  
  public final void bPA()
  {
    AppMethodBeat.i(156133);
    if (p.k(this.zyT))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("enter_scene", 1);
      localIntent.putExtra("chatroom_name", this.zyT.getTalkerUserName());
      com.tencent.mm.bq.d.b(p.e(this.zyT).zJz.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
    }
    AppMethodBeat.o(156133);
  }
  
  public final void bPB()
  {
    AppMethodBeat.i(156134);
    com.tencent.mm.plugin.report.service.h.qsU.e(14523, new Object[] { Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClass(p.e(this.zyT).zJz.getContext(), NewFileExplorerUI.class);
    localIntent.putExtra("TO_USER", p.l(this.zyT));
    p.e(this.zyT).a(localIntent, 227, new p.8.5(this));
    AppMethodBeat.o(156134);
  }
  
  public final void bPo()
  {
    AppMethodBeat.i(156118);
    if (com.tencent.mm.r.a.bM(p.e(this.zyT).zJz.getContext()))
    {
      AppMethodBeat.o(156118);
      return;
    }
    uw localuw = new uw();
    com.tencent.mm.sdk.b.a.ymk.l(localuw);
    if ((this.zyT.getTalkerUserName() != null) && (!this.zyT.getTalkerUserName().equals(localuw.cLo.talker)) && ((localuw.cLo.cLq) || (localuw.cLo.cLr)))
    {
      if (localuw.cLo.cLp) {}
      for (int i = 2131297846;; i = 2131297847)
      {
        Toast.makeText(p.e(this.zyT).zJz.getContext(), i, 0).show();
        ab.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
        AppMethodBeat.o(156118);
        return;
      }
    }
    boolean bool;
    if (1 == com.tencent.mm.m.g.Nq().getInt("EnableVoiceVoipFromPlugin", 0))
    {
      if ((!ad.arf(p.e(this.zyT).txj.field_username)) && (!t.nK(p.e(this.zyT).txj.field_username))) {
        break label354;
      }
      if ((((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).wk(p.e(this.zyT).txj.field_openImAppid) & 0x2000) == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      this.pxp = new com.tencent.mm.ui.widget.b.d(p.e(this.zyT).zJz.getContext(), 1, false);
      this.pxp.sao = new p.8.1(this, bool);
      this.pxp.sap = new p.8.2(this);
      this.pxp.crd();
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
        AppMethodBeat.o(156118);
        return;
        bool = false;
        break;
        this.zyT.dGx();
      }
      label354:
      bool = false;
    }
  }
  
  public final void bPp()
  {
    AppMethodBeat.i(156119);
    if (com.tencent.mm.r.a.bM(p.e(this.zyT).zJz.getContext()))
    {
      AppMethodBeat.o(156119);
      return;
    }
    uw localuw = new uw();
    com.tencent.mm.sdk.b.a.ymk.l(localuw);
    if ((!this.zyT.getTalkerUserName().equals(localuw.cLo.talker)) && ((localuw.cLo.cLq) || (localuw.cLo.cLr)))
    {
      if (localuw.cLo.cLp) {}
      for (int i = 2131297846;; i = 2131297847)
      {
        Toast.makeText(p.e(this.zyT).zJz.getContext(), i, 0).show();
        ab.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
        AppMethodBeat.o(156119);
        return;
      }
    }
    this.zyT.dGw();
    AppMethodBeat.o(156119);
  }
  
  public final void bPq()
  {
    AppMethodBeat.i(156120);
    if ((!com.tencent.mm.r.a.bO(p.e(this.zyT).zJz.getContext())) && (!com.tencent.mm.r.a.bM(p.e(this.zyT).zJz.getContext())))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(this.zyT).zJz.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
      ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), p.e(this.zyT).zJz.getContext() });
      if (!bool)
      {
        AppMethodBeat.o(156120);
        return;
      }
      this.zyT.dGy();
    }
    AppMethodBeat.o(156120);
  }
  
  public final void bPr()
  {
    AppMethodBeat.i(156121);
    ((u)p.e(this.zyT).ay(u.class)).dIQ();
    AppMethodBeat.o(156121);
  }
  
  public final void bPs()
  {
    AppMethodBeat.i(156122);
    ((com.tencent.mm.ui.chatting.c.b.e)p.e(this.zyT).ay(com.tencent.mm.ui.chatting.c.b.e.class)).dHM();
    AppMethodBeat.o(156122);
  }
  
  public final void bPt()
  {
    AppMethodBeat.i(156125);
    com.tencent.mm.bq.d.b(p.e(this.zyT).zJz.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
    AppMethodBeat.o(156125);
  }
  
  public final void bPu()
  {
    AppMethodBeat.i(156126);
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("3");
    if (com.tencent.mm.aj.f.lg(p.j(this.zyT).field_username))
    {
      localArrayList.add("4");
      localArrayList.add("7");
      localArrayList.add("9");
      localArrayList.add("10");
      localArrayList.add("11");
      localArrayList.add("12");
      localArrayList.add("13");
      localArrayList.add("15");
      localArrayList.add("16");
      localArrayList.add("17");
      localArrayList.add("18");
    }
    localIntent.putExtra("key_to_user", p.j(this.zyT).field_username);
    localIntent.putExtra("key_fav_item_id", TextUtils.join(",", localArrayList));
    com.tencent.mm.plugin.fav.a.b.b(p.e(this.zyT).zJz.getContext(), ".ui.FavSelectUI", localIntent);
    com.tencent.mm.plugin.report.service.h.qsU.e(14103, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(156126);
  }
  
  public final void bPv()
  {
    AppMethodBeat.i(156127);
    Intent localIntent = new Intent();
    localIntent.putExtra("service_app_talker_user", this.zyT.getTalkerUserName());
    com.tencent.mm.bq.d.a(p.e(this.zyT).zJz, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
    AppMethodBeat.o(156127);
  }
  
  public final void bPw()
  {
    AppMethodBeat.i(156128);
    Intent localIntent = new Intent();
    localIntent.putExtra("download_entrance_scene", 17);
    localIntent.putExtra("preceding_scence", 13);
    com.tencent.mm.bq.d.b(p.e(this.zyT).zJz.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
    com.tencent.mm.plugin.report.service.h.qsU.e(12065, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(156128);
  }
  
  public final void bPx()
  {
    AppMethodBeat.i(156130);
    com.tencent.mm.plugin.report.service.h.qsU.e(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
    if (p.k(this.zyT))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
      localObject1 = new Intent();
      i = com.tencent.mm.model.n.nv(this.zyT.getTalkerUserName());
      ((Intent)localObject1).putExtra("key_way", 1);
      ((Intent)localObject1).putExtra("key_chatroom_num", i);
      ((Intent)localObject1).putExtra("key_type", 1);
      ((Intent)localObject1).putExtra("key_from", 1);
      ((Intent)localObject1).putExtra("key_username", this.zyT.getTalkerUserName());
      ((Intent)localObject1).putExtra("pay_channel", 14);
      com.tencent.mm.bq.d.b(p.e(this.zyT).zJz.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", (Intent)localObject1);
      AppMethodBeat.o(156130);
      return;
    }
    aw.aaz();
    Object localObject1 = (Integer)c.Ru().get(ac.a.yyl, Integer.valueOf(0));
    aw.aaz();
    Object localObject2 = (Integer)c.Ru().get(ac.a.yym, Integer.valueOf(0));
    if ((((Integer)localObject1).intValue() == 1) || (((Integer)localObject2).intValue() == 1)) {
      if (r.Zu() != 0) {
        break label446;
      }
    }
    label446:
    for (int i = 1; i == 0; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_way", 0);
      ((Intent)localObject1).putExtra("key_type", 0);
      ((Intent)localObject1).putExtra("key_from", 1);
      ((Intent)localObject1).putExtra("key_username", this.zyT.getTalkerUserName());
      ((Intent)localObject1).putExtra("pay_channel", 11);
      com.tencent.mm.bq.d.b(p.e(this.zyT).zJz.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", (Intent)localObject1);
      AppMethodBeat.o(156130);
      return;
    }
    localObject1 = new com.tencent.mm.g.b.a.n();
    ((com.tencent.mm.g.b.a.n)localObject1).cRI = 13L;
    ((com.tencent.mm.g.b.a.n)localObject1).ake();
    localObject1 = p.e(this.zyT).zJz.getMMResources().getString(2131298255);
    localObject2 = p.e(this.zyT).zJz.getMMResources().getString(2131298254);
    Activity localActivity = p.e(this.zyT).zJz.getContext();
    p.8.4 local4 = new p.8.4(this);
    com.tencent.mm.ui.base.h.a(localActivity, null, new String[] { localObject1, localObject2 }, null, local4);
    AppMethodBeat.o(156130);
  }
  
  public final void bPy()
  {
    AppMethodBeat.i(156131);
    aw.aaz();
    c.Ru().set(81, Boolean.FALSE);
    if (!at.isNetworkConnected(p.e(this.zyT).zJz.getContext()))
    {
      com.tencent.mm.bg.e.a(p.e(this.zyT).zJz.getContext(), 2131304713, null);
      AppMethodBeat.o(156131);
      return;
    }
    this.zyT.dGv();
    AppMethodBeat.o(156131);
  }
  
  public final void bPz()
  {
    AppMethodBeat.i(156132);
    Intent localIntent = new Intent();
    localIntent.putExtra("enterprise_scene", 4);
    localIntent.putExtra("enterprise_biz_name", this.zyT.getTalkerUserName());
    localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)p.e(this.zyT).ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHI());
    com.tencent.mm.bq.d.b(p.e(this.zyT).zJz.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
    AppMethodBeat.o(156132);
  }
  
  public final void d(com.tencent.mm.pluginsdk.model.app.f paramf)
  {
    AppMethodBeat.i(156124);
    ((com.tencent.mm.ui.chatting.c.b.b)p.e(this.zyT).ay(com.tencent.mm.ui.chatting.c.b.b.class)).s(paramf);
    AppMethodBeat.o(156124);
  }
  
  public final void yQ(int paramInt)
  {
    AppMethodBeat.i(156123);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(156123);
      return;
      Object localObject = p.e(this.zyT).zJz.getContext().getSharedPreferences(ah.dsP(), 0).getString("gallery", "1");
      com.tencent.mm.plugin.report.service.g.Cx(19);
      if (((String)localObject).equalsIgnoreCase("0")) {
        com.tencent.mm.pluginsdk.ui.tools.n.g(p.e(this.zyT).zJz);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        al.p(new p.8.3(this), 1000L);
        AppMethodBeat.o(156123);
        return;
        localObject = p.e(this.zyT).dJD();
        String str = p.e(this.zyT).getTalkerUserName();
        if ((p.i(this.zyT)) && (p.zyH)) {
          com.tencent.mm.pluginsdk.ui.tools.n.b(p.e(this.zyT).zJz, 3, (String)localObject, str);
        } else if (ad.na(str)) {
          com.tencent.mm.pluginsdk.ui.tools.n.a(p.e(this.zyT).zJz, 12, (String)localObject, str);
        } else {
          com.tencent.mm.pluginsdk.ui.tools.n.a(p.e(this.zyT).zJz, 3, (String)localObject, str);
        }
      }
      localObject = new File(com.tencent.mm.compatible.util.e.esr);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir()))
      {
        Toast.makeText(p.e(this.zyT).zJz.getContext(), p.e(this.zyT).zJz.getMMResources().getString(2131298329), 1).show();
        AppMethodBeat.o(156123);
        return;
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(this.zyT).zJz.getContext(), "android.permission.CAMERA", 20, "", "");
      ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), p.e(this.zyT).zJz.getContext() });
      if (!bool)
      {
        AppMethodBeat.o(156123);
        return;
      }
      this.zyT.dGz();
    }
  }
  
  public final void yR(int paramInt)
  {
    AppMethodBeat.i(156129);
    if ((!com.tencent.mm.r.a.bN(p.e(this.zyT).zJz.getContext())) && (!com.tencent.mm.r.a.bO(p.e(this.zyT).zJz.getContext())) && (!com.tencent.mm.r.a.bM(p.e(this.zyT).zJz.getContext()))) {
      this.zyT.Pq(paramInt);
    }
    AppMethodBeat.o(156129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.8
 * JD-Core Version:    0.7.0.1
 */