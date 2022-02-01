package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.f.b.a.bw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.byp.b.a.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.FinderConvChooseTipsView;
import com.tencent.mm.plugin.finder.conv.l;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.report.d.a;
import com.tencent.mm.plugin.finder.report.d.d;
import com.tencent.mm.plugin.finder.report.d.d.a;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.findersdk.a.o;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.h.class)
class i
  extends a
  implements com.tencent.mm.ui.chatting.d.b.h
{
  private com.tencent.mm.ui.blur.f KPB;
  private MStorage.IOnStorageChange WIc;
  private final MStorage.IOnStorageChange WId;
  
  i()
  {
    AppMethodBeat.i(273844);
    this.WIc = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(272488);
        if (paramAnonymousMStorageEventData.event.equals(i.this.fgR.NKq.field_username)) {
          i.a(i.this);
        }
        AppMethodBeat.o(272488);
      }
    };
    this.WId = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(281999);
        Log.i("MicroMsg.ChattingBypComponent", "onNotifyChange ".concat(String.valueOf(paramAnonymousString)));
        if ((paramAnonymousMStorageEventData.event.equals("FinderContact")) || (paramAnonymousMStorageEventData.event.equals("FinderMsgContactStorage")))
        {
          bh.beI();
          paramAnonymousString = com.tencent.mm.model.c.bbL().RG(i.this.fgR.getTalkerUserName());
          if ((paramAnonymousString != null) && ((int)paramAnonymousString.jxt != 0))
          {
            if (Util.isNullOrNil(paramAnonymousString.field_nickname)) {
              paramAnonymousString.setNickname(i.this.fgR.NKq.field_nickname);
            }
            i.this.fgR.aC(paramAnonymousString);
            ((aa)i.this.fgR.bC(aa.class)).hOL();
            ((aa)i.this.fgR.bC(aa.class)).Gm(true);
            i.this.fgR.cAe();
            i.this.hOL();
            i.a(i.this);
          }
        }
        AppMethodBeat.o(281999);
      }
    };
    this.KPB = null;
    AppMethodBeat.o(273844);
  }
  
  private void hOM()
  {
    AppMethodBeat.i(273852);
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage().aEN(this.fgR.NKq.field_username);
    ChatFooter localChatFooter = ((u)this.fgR.bC(u.class)).hPj();
    if ((localChatFooter != null) && (as.aEF(this.fgR.NKq.field_username)))
    {
      if (((l)localObject).field_disableSendMsg != 1) {}
      as localas;
      Boolean localBoolean;
      for (boolean bool = true;; bool = false)
      {
        localChatFooter.setFooterStatus(bool);
        localObject = this.fgR.getSelfUserName();
        localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg((String)localObject);
        localBoolean = Boolean.valueOf(as.bvP(this.fgR.getSelfUserName()));
        if (!localBoolean.booleanValue()) {
          break;
        }
        if (localas == null) {
          break label314;
        }
        localChatFooter.a(this.fgR.getSelfUserName(), localBoolean, this.fgR.WQv.getContext().getString(R.l.eFg, new Object[] { localas.ayr() }));
        AppMethodBeat.o(273852);
        return;
      }
      if (((m)com.tencent.mm.kernel.h.ae(m.class)).aEs((String)localObject) == null)
      {
        if (localas != null) {
          localChatFooter.a(this.fgR.getSelfUserName(), localBoolean, this.fgR.WQv.getContext().getString(R.l.eFg, new Object[] { localas.ayr() }));
        }
        AppMethodBeat.o(273852);
        return;
      }
      bool = as.bvP((String)localObject);
      if (localas != null) {
        localChatFooter.a(this.fgR.getSelfUserName(), Boolean.valueOf(bool), this.fgR.WQv.getContext().getString(R.l.eFg, new Object[] { localas.ayr() }));
      }
    }
    label314:
    AppMethodBeat.o(273852);
  }
  
  public final boolean bvP(String paramString)
  {
    AppMethodBeat.i(273846);
    boolean bool = as.bvP(paramString);
    AppMethodBeat.o(273846);
    return bool;
  }
  
  public final boolean bzi(String paramString)
  {
    AppMethodBeat.i(273847);
    boolean bool = as.bvN(paramString);
    AppMethodBeat.o(273847);
    return bool;
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(273850);
    super.hGV();
    if (!hOK())
    {
      AppMethodBeat.o(273850);
      return;
    }
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage().add(this.WIc);
    ((m)com.tencent.mm.kernel.h.ae(m.class)).m(this.WId);
    hOL();
    AppMethodBeat.o(273850);
  }
  
  public final void hGW()
  {
    int m = 1;
    AppMethodBeat.i(273848);
    super.hGW();
    if (!hOK())
    {
      AppMethodBeat.o(273848);
      return;
    }
    boolean bool = this.fgR.WQv.getBooleanExtra("key_finder_need_choose_id", false).booleanValue();
    Object localObject1 = this.fgR.WQv.getStringExtra("Chat_User");
    com.tencent.mm.kernel.h.aHH();
    int i;
    int j;
    label106:
    int k;
    label148:
    Object localObject2;
    long l;
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aOW((String)localObject1) == 0)
    {
      i = 1;
      if ((z.bdh().isEmpty()) && (z.bdi().isEmpty())) {
        break label479;
      }
      j = 1;
      if (!bool) {
        break label484;
      }
      k = m;
      if (i == 0)
      {
        k = m;
        if (j == 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.dXF().aSr()).booleanValue()) {
            break label484;
          }
          k = m;
        }
      }
      if (k != 0) {
        this.fgR.dI(new FinderConvChooseTipsView(this.fgR.WQv.getContext()));
      }
      hOM();
      ((com.tencent.mm.plugin.findersdk.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.n.class)).aEy(this.fgR.getTalkerUserName());
      if (!Util.isNullOrNil(this.fgR.getTalkerUserName())) {
        com.tencent.e.h.ZvG.bf(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(278587);
            List localList = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().fY(Collections.singletonList("findermessage006"));
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              ca localca = (ca)localIterator.next();
              a.a locala = com.tencent.mm.plugin.byp.b.a.sWz;
              if (!com.tencent.mm.plugin.byp.b.a.cFf().contains(Long.valueOf(localca.field_msgId)))
              {
                localca.setStatus(5);
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(localca.field_msgId, localca);
              }
            }
            Log.i("MicroMsg.ChattingBypComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), i.this.fgR.hOp(), i.this.fgR.getTalkerUserName() });
            AppMethodBeat.o(278587);
          }
        });
      }
      localObject2 = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aED(this.fgR.getTalkerUserName());
      if (as.bvP(this.fgR.getSelfUserName())) {
        ((o)com.tencent.mm.kernel.h.ae(o.class)).aEC(this.fgR.getTalkerUserName());
      }
      localObject1 = com.tencent.mm.plugin.finder.report.d.zUg;
      localObject1 = com.tencent.mm.plugin.finder.report.d.dPg();
      if (!as.bvP((String)localObject2)) {
        break label489;
      }
      l = 2L;
      label311:
      String str = this.fgR.getTalkerUserName();
      p.k(localObject2, "talkUserName");
      p.k(str, "chatName");
      ((d.d)localObject1).zUo = l;
      ((d.d)localObject1).zUq = ((String)localObject2);
      ((d.d)localObject1).zUu = str;
      ((d.d)localObject1).wzm = cm.bfE();
      ((d.d)localObject1).zUs = String.valueOf(((d.d)localObject1).wzm);
      localObject2 = com.tencent.mm.plugin.finder.report.d.zUg;
      if (!com.tencent.mm.plugin.finder.report.d.dPd().zZF) {
        break label495;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.d.zUg;
      ((d.d)localObject1).zUr = com.tencent.mm.plugin.finder.report.d.dPd().zZG.zUi;
    }
    for (;;)
    {
      Log.i(((d.d)localObject1).TAG, "onEnterChat:talkUserNameL" + ((d.d)localObject1).zUq + ", chatNameL" + ((d.d)localObject1).zUu + "， accountTypeL" + ((d.d)localObject1).zUo);
      AppMethodBeat.o(273848);
      return;
      i = 0;
      break;
      label479:
      j = 0;
      break label106;
      label484:
      k = 0;
      break label148;
      label489:
      l = 1L;
      break label311;
      label495:
      localObject2 = com.tencent.mm.plugin.finder.report.d.zUg;
      if (com.tencent.mm.plugin.finder.report.d.dPc().zZF)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.d.zUg;
        ((d.d)localObject1).zUr = com.tencent.mm.plugin.finder.report.d.dPc().zZG.zUi;
      }
    }
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(273853);
    super.hHa();
    if (!hOK())
    {
      AppMethodBeat.o(273853);
      return;
    }
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage().aEI(this.fgR.getTalkerUserName());
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage().remove(this.WIc);
    ((m)com.tencent.mm.kernel.h.ae(m.class)).l(this.WId);
    Object localObject3;
    Object localObject2;
    if (as.bvP(((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage().aEN(this.fgR.NKq.field_username).field_talker))
    {
      ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager().xsM.dqt();
      if (this.KPB != null) {
        this.KPB.destroy();
      }
      localObject3 = this.fgR.getTalkerUserName();
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      if ((this.fgR == null) || (this.fgR.WQv.getContext() == null)) {
        break label606;
      }
    }
    label606:
    for (int i = this.fgR.WQv.getContext().getIntent().getIntExtra("key_comment_scene", 0);; i = 0)
    {
      Object localObject1 = aj.Bnu;
      String str = aj.a.Sa(i + 100);
      localObject1 = com.tencent.mm.plugin.finder.report.d.zUg;
      d.d locald = com.tencent.mm.plugin.finder.report.d.dPg();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      long l = i;
      p.k(localObject1, "talker");
      localObject3 = new bw();
      ((bw)localObject3).gog = l;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        ((bw)localObject3).ggA = ((bw)localObject3).z("sessionid", (String)localObject2, true);
        if (str == null) {}
        for (localObject2 = "";; localObject2 = str)
        {
          ((bw)localObject3).goj = ((bw)localObject3).z("clicktabcontextid", (String)localObject2, true);
          ((bw)localObject3).goh = locald.zUo;
          ((bw)localObject3).goi = ((bw)localObject3).z("talkerUsername", locald.zUq, true);
          ((bw)localObject3).gol = ((bw)localObject3).z("chatSessionid", locald.zUs, true);
          ((bw)localObject3).gok = ((bw)localObject3).z("chatListSessionid", locald.zUr, true);
          ((bw)localObject3).gom = (cm.bfE() - locald.wzm);
          ((bw)localObject3).gon = ((bw)localObject3).z("chatName", locald.zUu, true);
          ((bw)localObject3).goo = locald.zUv;
          ((bw)localObject3).gos = locald.zUy;
          l = locald.wzm;
          p.k(localObject1, "talker");
          p.k(localObject3, "chatEnterStruct");
          locald.zUp.post((Runnable)new d.d.a(locald, (String)localObject1, l, (bw)localObject3));
          locald.zUo = 0L;
          locald.zUq = "";
          locald.zUr = "";
          locald.zUs = "";
          locald.zUt = 0L;
          locald.zUu = "";
          locald.zUv = 0L;
          locald.zUw = 0L;
          locald.zUx = 0L;
          locald.zUy = 0L;
          locald.wzm = 0L;
          AppMethodBeat.o(273853);
          return;
          ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager().xsM.dqs();
          break;
        }
      }
    }
  }
  
  public final boolean hOK()
  {
    AppMethodBeat.i(273845);
    boolean bool = as.aEF(this.fgR.getTalkerUserName());
    AppMethodBeat.o(273845);
    return bool;
  }
  
  public final void hOL()
  {
    AppMethodBeat.i(273851);
    String str = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aED(this.fgR.getTalkerUserName());
    Object localObject1 = "";
    Object localObject2;
    if (as.bvP(str))
    {
      Object localObject3 = ((m)com.tencent.mm.kernel.h.ae(m.class)).aEs(str);
      if (localObject3 != null)
      {
        localObject2 = ((ai)localObject3).ays();
        long l = ((ai)localObject3).dnr();
        localObject1 = localObject2;
        if (l > 0L)
        {
          localObject3 = this.fgR.WQv.getContext().getResources().getString(R.l.eFh, new Object[] { Long.valueOf(l) });
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            ((aa)this.fgR.bC(aa.class)).setMMSubTitle((String)localObject3);
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 != null) {
        break label243;
      }
      ((aa)this.fgR.bC(aa.class)).setMMTitle("");
    }
    for (;;)
    {
      ((aa)this.fgR.bC(aa.class)).bzm(str);
      AppMethodBeat.o(273851);
      return;
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(str);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((as)localObject2).ayr();
      break;
      label243:
      ((aa)this.fgR.bC(aa.class)).setMMTitle((CharSequence)localObject1);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(273854);
    if ((paramInt1 == 1010) && (paramIntent != null) && (paramIntent.getBooleanExtra("KEY_HAS_CHANGE_ROLE", false)))
    {
      this.fgR.WQv.getContext().finish();
      this.fgR.WQv.getContext().overridePendingTransition(R.a.anim_not_change, R.a.sight_slide_bottom_out);
    }
    AppMethodBeat.o(273854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.i
 * JD-Core Version:    0.7.0.1
 */