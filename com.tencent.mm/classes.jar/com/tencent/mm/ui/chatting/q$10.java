package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.tc;
import com.tencent.mm.h.a.tc.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.b.b.t;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

final class q$10
  implements AppPanel.a
{
  com.tencent.mm.ui.widget.a.d mYD = null;
  
  q$10(q paramq) {}
  
  public final void b(com.tencent.mm.pluginsdk.model.app.f paramf)
  {
    ((com.tencent.mm.ui.chatting.b.b.a)q.e(this.vjS).ac(com.tencent.mm.ui.chatting.b.b.a.class)).n(paramf);
  }
  
  public final void bhm()
  {
    if (com.tencent.mm.r.a.bi(q.e(this.vjS).vtz.getContext())) {
      return;
    }
    tc localtc = new tc();
    com.tencent.mm.sdk.b.a.udP.m(localtc);
    if ((!this.vjS.getTalkerUserName().equals(localtc.ccF.talker)) && ((localtc.ccF.ccH) || (localtc.ccF.ccI)))
    {
      if (localtc.ccF.ccG) {}
      for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
      {
        Toast.makeText(q.e(this.vjS).vtz.getContext(), i, 0).show();
        y.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
        return;
      }
    }
    boolean bool;
    if (1 == com.tencent.mm.m.g.AA().getInt("EnableVoiceVoipFromPlugin", 0))
    {
      if ((!ad.aaU(q.e(this.vjS).pSb.field_username)) && (!s.hb(q.e(this.vjS).pSb.field_username))) {
        break label326;
      }
      if ((((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).oS(q.e(this.vjS).pSb.field_openImAppid) & 0x2000) == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      this.mYD = new com.tencent.mm.ui.widget.a.d(q.e(this.vjS).vtz.getContext(), 1, false);
      this.mYD.phH = new q.10.1(this, bool);
      this.mYD.phI = new q.10.2(this);
      this.mYD.cfU();
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
        return;
        bool = false;
        break;
        this.vjS.cCK();
      }
      label326:
      bool = false;
    }
  }
  
  public final void bhn()
  {
    if (com.tencent.mm.r.a.bi(q.e(this.vjS).vtz.getContext())) {
      return;
    }
    tc localtc = new tc();
    com.tencent.mm.sdk.b.a.udP.m(localtc);
    if ((!this.vjS.getTalkerUserName().equals(localtc.ccF.talker)) && ((localtc.ccF.ccH) || (localtc.ccF.ccI)))
    {
      if (localtc.ccF.ccG) {}
      for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
      {
        Toast.makeText(q.e(this.vjS).vtz.getContext(), i, 0).show();
        y.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
        return;
      }
    }
    this.vjS.cCJ();
  }
  
  public final void bho()
  {
    if ((!com.tencent.mm.r.a.bk(q.e(this.vjS).vtz.getContext())) && (!com.tencent.mm.r.a.bi(q.e(this.vjS).vtz.getContext())))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a(q.e(this.vjS).vtz.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
      y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), q.e(this.vjS).vtz.getContext() });
      if (bool) {}
    }
    else
    {
      return;
    }
    this.vjS.cCL();
  }
  
  public final void bhp()
  {
    ((t)q.e(this.vjS).ac(t.class)).cEY();
  }
  
  public final void bhq()
  {
    ((com.tencent.mm.ui.chatting.b.b.d)q.e(this.vjS).ac(com.tencent.mm.ui.chatting.b.b.d.class)).cDW();
  }
  
  public final void bhr()
  {
    com.tencent.mm.br.d.b(q.e(this.vjS).vtz.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
  }
  
  public final void bhs()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("3");
    if (com.tencent.mm.ai.f.eW(q.n(this.vjS).field_username))
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
    localIntent.putExtra("key_to_user", q.n(this.vjS).field_username);
    localIntent.putExtra("key_fav_item_id", TextUtils.join(",", localArrayList));
    com.tencent.mm.plugin.fav.a.b.a(q.e(this.vjS).vtz.getContext(), ".ui.FavSelectUI", localIntent);
    com.tencent.mm.plugin.report.service.h.nFQ.f(14103, new Object[] { Integer.valueOf(1) });
  }
  
  public final void bht()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("service_app_talker_user", this.vjS.getTalkerUserName());
    com.tencent.mm.br.d.a(q.e(this.vjS).vtz, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
  }
  
  public final void bhu()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("download_entrance_scene", 17);
    localIntent.putExtra("preceding_scence", 13);
    com.tencent.mm.br.d.b(q.e(this.vjS).vtz.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
    com.tencent.mm.plugin.report.service.h.nFQ.f(12065, new Object[] { Integer.valueOf(4) });
  }
  
  public final void bhv()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.plugin.report.service.h.nFQ.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
    if (q.o(this.vjS))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
      localObject1 = new Intent();
      i = m.gM(this.vjS.getTalkerUserName());
      ((Intent)localObject1).putExtra("key_way", 1);
      ((Intent)localObject1).putExtra("key_chatroom_num", i);
      ((Intent)localObject1).putExtra("key_type", 1);
      ((Intent)localObject1).putExtra("key_from", 1);
      ((Intent)localObject1).putExtra("key_username", this.vjS.getTalkerUserName());
      ((Intent)localObject1).putExtra("pay_channel", 14);
      com.tencent.mm.br.d.b(q.e(this.vjS).vtz.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", (Intent)localObject1);
      return;
    }
    au.Hx();
    Object localObject1 = (Integer)com.tencent.mm.model.c.Dz().get(ac.a.uos, Integer.valueOf(0));
    au.Hx();
    Object localObject2 = (Integer)com.tencent.mm.model.c.Dz().get(ac.a.uot, Integer.valueOf(0));
    if ((((Integer)localObject1).intValue() == 1) || (((Integer)localObject2).intValue() == 1)) {
      if (com.tencent.mm.model.q.Gq() != 0) {
        break label428;
      }
    }
    label428:
    for (int i = 1; i == 0; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_way", 0);
      ((Intent)localObject1).putExtra("key_type", 0);
      ((Intent)localObject1).putExtra("key_from", 1);
      ((Intent)localObject1).putExtra("key_username", this.vjS.getTalkerUserName());
      ((Intent)localObject1).putExtra("pay_channel", 11);
      com.tencent.mm.br.d.b(q.e(this.vjS).vtz.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", (Intent)localObject1);
      return;
    }
    localObject1 = q.e(this.vjS).vtz.getMMResources().getString(R.l.chatting_lucky_money_new_year);
    localObject2 = q.e(this.vjS).vtz.getMMResources().getString(R.l.chatting_lucky_money_short_title);
    Activity localActivity = q.e(this.vjS).vtz.getContext();
    q.10.4 local4 = new q.10.4(this);
    com.tencent.mm.ui.base.h.a(localActivity, null, new String[] { localObject1, localObject2 }, null, local4);
  }
  
  public final void bhw()
  {
    au.Hx();
    com.tencent.mm.model.c.Dz().o(81, Boolean.valueOf(false));
    if (!aq.isNetworkConnected(q.e(this.vjS).vtz.getContext()))
    {
      com.tencent.mm.bf.e.a(q.e(this.vjS).vtz.getContext(), R.l.voip_net_unavailable, null);
      return;
    }
    this.vjS.cCI();
  }
  
  public final void bhx()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("enterprise_scene", 4);
    localIntent.putExtra("enterprise_biz_name", this.vjS.getTalkerUserName());
    localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.b.b.c)q.e(this.vjS).ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDS());
    com.tencent.mm.br.d.b(q.e(this.vjS).vtz.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
  }
  
  public final void bhy()
  {
    if (q.o(this.vjS))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("enter_scene", 1);
      localIntent.putExtra("chatroom_name", this.vjS.getTalkerUserName());
      com.tencent.mm.br.d.b(q.e(this.vjS).vtz.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
    }
  }
  
  public final void bhz()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(14523, new Object[] { Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClass(q.e(this.vjS).vtz.getContext(), NewFileExplorerUI.class);
    localIntent.putExtra("TO_USER", q.p(this.vjS));
    q.e(this.vjS).a(localIntent, 227, new q.10.5(this));
  }
  
  public final void tA(int paramInt)
  {
    switch (paramInt)
    {
    }
    boolean bool;
    do
    {
      return;
      Object localObject = q.e(this.vjS).vtz.getContext().getSharedPreferences(ae.cqR(), 0).getString("gallery", "1");
      com.tencent.mm.plugin.report.service.g.wI(19);
      if (((String)localObject).equalsIgnoreCase("0")) {
        l.r(q.e(this.vjS).vtz);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        ai.l(new q.10.3(this), 1000L);
        return;
        localObject = q.e(this.vjS).cFB();
        String str = q.e(this.vjS).getTalkerUserName();
        if ((q.m(this.vjS)) && (q.vjI)) {
          l.b(q.e(this.vjS).vtz, 3, (String)localObject, str);
        } else if (ad.gr(str)) {
          l.a(q.e(this.vjS).vtz, 12, (String)localObject, str);
        } else {
          l.a(q.e(this.vjS).vtz, 3, (String)localObject, str);
        }
      }
      localObject = new File(com.tencent.mm.compatible.util.e.dzD);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir()))
      {
        Toast.makeText(q.e(this.vjS).vtz.getContext(), q.e(this.vjS).vtz.getMMResources().getString(R.l.chatting_toast_sdk_fail), 1).show();
        return;
      }
      bool = com.tencent.mm.pluginsdk.permission.a.a(q.e(this.vjS).vtz.getContext(), "android.permission.CAMERA", 20, "", "");
      y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), q.e(this.vjS).vtz.getContext() });
    } while (!bool);
    this.vjS.cCM();
  }
  
  public final void tB(int paramInt)
  {
    if ((!com.tencent.mm.r.a.bj(q.e(this.vjS).vtz.getContext())) && (!com.tencent.mm.r.a.bk(q.e(this.vjS).vtz.getContext())) && (!com.tencent.mm.r.a.bi(q.e(this.vjS).vtz.getContext()))) {
      this.vjS.GP(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.10
 * JD-Core Version:    0.7.0.1
 */