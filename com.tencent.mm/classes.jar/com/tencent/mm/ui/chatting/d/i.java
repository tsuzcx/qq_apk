package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.j;
import com.tencent.mm.plugin.finder.extension.reddot.e;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.report.b.a;
import com.tencent.mm.plugin.finder.report.b.d;
import com.tencent.mm.plugin.finder.report.b.d.a;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.s;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.h.class)
class i
  extends a
  implements com.tencent.mm.ui.chatting.d.b.h
{
  private k.a JHD;
  
  i()
  {
    AppMethodBeat.i(193987);
    this.JHD = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(193985);
        if (paramAnonymousm.dln.equals(i.this.cWM.BYG.field_username)) {
          i.a(i.this);
        }
        AppMethodBeat.o(193985);
      }
    };
    AppMethodBeat.o(193987);
  }
  
  private void fDm()
  {
    AppMethodBeat.i(193993);
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().aiw(this.cWM.BYG.field_username);
    ChatFooter localChatFooter;
    if ((((s)this.cWM.bh(s.class)).fDC() != null) && (am.ail(this.cWM.BYG.field_username)))
    {
      localChatFooter = ((s)this.cWM.bh(s.class)).fDC();
      if (((j)localObject).field_disableSendMsg == 1) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      localChatFooter.setFooterStatus(bool);
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj(this.cWM.fFr());
      bool = am.aSU(this.cWM.fFr());
      ((s)this.cWM.bh(s.class)).fDC().a(this.cWM.fFr(), Boolean.valueOf(bool), this.cWM.JOR.getContext().getString(2131766841, new Object[] { ((am)localObject).adu() }));
      AppMethodBeat.o(193993);
      return;
    }
  }
  
  public final boolean aSU(String paramString)
  {
    AppMethodBeat.i(193989);
    boolean bool = am.aSU(paramString);
    AppMethodBeat.o(193989);
    return bool;
  }
  
  public final boolean aWc(String paramString)
  {
    AppMethodBeat.i(193990);
    boolean bool = am.aST(paramString);
    AppMethodBeat.o(193990);
    return bool;
  }
  
  public final boolean fDl()
  {
    AppMethodBeat.i(193988);
    boolean bool = am.ail(this.cWM.getTalkerUserName());
    AppMethodBeat.o(193988);
    return bool;
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(193992);
    super.fwt();
    if (!fDl())
    {
      AppMethodBeat.o(193992);
      return;
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().add(this.JHD);
    AppMethodBeat.o(193992);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(193991);
    super.fwu();
    if (!fDl())
    {
      AppMethodBeat.o(193991);
      return;
    }
    fDm();
    ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).aie(this.cWM.getTalkerUserName());
    if (!bt.isNullOrNil(this.cWM.getTalkerUserName())) {
      com.tencent.e.h.LTJ.aS(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193986);
          List localList = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().dlX();
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            bu localbu = (bu)localIterator.next();
            localbu.setStatus(5);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(localbu.field_msgId, localbu);
          }
          ad.i("MicroMsg.ChattingBypComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), i.this.cWM.fCR(), i.this.cWM.getTalkerUserName() });
          AppMethodBeat.o(193986);
        }
      });
    }
    Object localObject2 = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(this.cWM.getTalkerUserName());
    Object localObject1 = b.snk;
    localObject1 = b.cDn();
    long l;
    if (am.aSU((String)localObject2))
    {
      l = 2L;
      String str = this.cWM.getTalkerUserName();
      d.g.b.p.h(localObject2, "talkUserName");
      d.g.b.p.h(str, "chatName");
      ((b.d)localObject1).snt = l;
      ((b.d)localObject1).snv = ((String)localObject2);
      ((b.d)localObject1).snz = str;
      ((b.d)localObject1).snn = cf.aCM();
      ((b.d)localObject1).snx = String.valueOf(((b.d)localObject1).snn);
      localObject2 = b.snk;
      if (!b.cDk().ssx) {
        break label272;
      }
      localObject2 = b.snk;
      ((b.d)localObject1).snw = b.cDk().ssy.snm;
    }
    for (;;)
    {
      ad.i(((b.d)localObject1).TAG, "onEnterChat:talkUserNameL" + ((b.d)localObject1).snv + ", chatNameL" + ((b.d)localObject1).snz + "， accountTypeL" + ((b.d)localObject1).snt);
      AppMethodBeat.o(193991);
      return;
      l = 1L;
      break;
      label272:
      localObject2 = b.snk;
      if (b.cDj().ssx)
      {
        localObject2 = b.snk;
        ((b.d)localObject1).snw = b.cDj().ssy.snm;
      }
    }
  }
  
  public final void fwy()
  {
    AppMethodBeat.i(193994);
    super.fwy();
    if (!fDl())
    {
      AppMethodBeat.o(193994);
      return;
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().ais(this.cWM.getTalkerUserName());
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().remove(this.JHD);
    Object localObject3;
    Object localObject2;
    if (am.aSU(((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().aiw(this.cWM.BYG.field_username).field_talker))
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getRedDotManager().rRV.czE();
      localObject3 = this.cWM.getTalkerUserName();
      localObject2 = ((c)com.tencent.mm.kernel.g.ab(c.class)).cnc();
      if ((this.cWM == null) || (this.cWM.JOR.getContext() == null)) {
        break label574;
      }
    }
    label574:
    for (int i = this.cWM.JOR.getContext().getIntent().getIntExtra("key_comment_scene", 0);; i = 0)
    {
      Object localObject1 = FinderReporterUIC.tcM;
      String str = FinderReporterUIC.a.Gz(i + 100);
      localObject1 = b.snk;
      b.d locald = b.cDn();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      long l = i;
      d.g.b.p.h(localObject1, "talker");
      localObject3 = new af();
      ((af)localObject3).dVf = l;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        ((af)localObject3).dQt = ((af)localObject3).t("sessionid", (String)localObject2, true);
        if (str == null) {}
        for (localObject2 = "";; localObject2 = str)
        {
          ((af)localObject3).dVi = ((af)localObject3).t("clicktabcontextid", (String)localObject2, true);
          ((af)localObject3).dVg = locald.snt;
          ((af)localObject3).dVh = ((af)localObject3).t("talkerUsername", locald.snv, true);
          ((af)localObject3).dVk = ((af)localObject3).t("chatSessionid", locald.snx, true);
          ((af)localObject3).dVj = ((af)localObject3).t("chatListSessionid", locald.snw, true);
          ((af)localObject3).dVl = (cf.aCM() - locald.snn);
          ((af)localObject3).dVm = ((af)localObject3).t("chatName", locald.snz, true);
          ((af)localObject3).dVn = locald.snA;
          ((af)localObject3).dVq = locald.snD;
          l = locald.snn;
          d.g.b.p.h(localObject1, "talker");
          d.g.b.p.h(localObject3, "chatEnterStruct");
          locald.snu.post((Runnable)new b.d.a(locald, (String)localObject1, l, (af)localObject3));
          locald.snt = 0L;
          locald.snv = "";
          locald.snw = "";
          locald.snx = "";
          locald.sny = 0L;
          locald.snz = "";
          locald.snA = 0L;
          locald.snB = 0L;
          locald.snC = 0L;
          locald.snD = 0L;
          locald.snn = 0L;
          AppMethodBeat.o(193994);
          return;
          ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getRedDotManager().rRV.czD();
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.i
 * JD-Core Version:    0.7.0.1
 */