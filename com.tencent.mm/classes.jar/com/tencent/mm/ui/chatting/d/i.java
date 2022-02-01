package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.byp.b.a.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.d.a;
import com.tencent.mm.plugin.finder.report.d.d;
import com.tencent.mm.plugin.finder.report.d.d.a;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.h.class)
class i
  extends a
  implements com.tencent.mm.ui.chatting.d.b.h
{
  private com.tencent.mm.ui.blur.f EBK;
  private MStorage.IOnStorageChange PnQ;
  private final MStorage.IOnStorageChange PnR;
  
  i()
  {
    AppMethodBeat.i(233055);
    this.PnQ = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(233052);
        if (paramAnonymousMStorageEventData.event.equals(i.this.dom.GUe.field_username)) {
          i.a(i.this);
        }
        AppMethodBeat.o(233052);
      }
    };
    this.PnR = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(233053);
        Log.i("MicroMsg.ChattingBypComponent", "onNotifyChange ".concat(String.valueOf(paramAnonymousString)));
        com.tencent.mm.model.bg.aVF();
        paramAnonymousString = com.tencent.mm.model.c.aSN().Kn(i.this.dom.getTalkerUserName());
        if ((paramAnonymousString != null) && ((int)paramAnonymousString.gMZ != 0))
        {
          if (Util.isNullOrNil(paramAnonymousString.field_nickname)) {
            paramAnonymousString.setNickname(i.this.dom.GUe.field_nickname);
          }
          i.this.dom.aw(paramAnonymousString);
          ((com.tencent.mm.ui.chatting.d.b.aa)i.this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gPx();
          ((com.tencent.mm.ui.chatting.d.b.aa)i.this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).BR(true);
          i.this.dom.cmy();
        }
        AppMethodBeat.o(233053);
      }
    };
    this.EBK = null;
    AppMethodBeat.o(233055);
  }
  
  private void gPv()
  {
    AppMethodBeat.i(233061);
    Object localObject = ((PluginFinder)g.ah(PluginFinder.class)).getSessionInfoStorage().avz(this.dom.GUe.field_username);
    ChatFooter localChatFooter;
    if ((((u)this.dom.bh(u.class)).gPO() != null) && (as.avl(this.dom.GUe.field_username)))
    {
      localChatFooter = ((u)this.dom.bh(u.class)).gPO();
      if (((k)localObject).field_disableSendMsg == 1) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      localChatFooter.setFooterStatus(bool);
      localObject = ((l)g.af(l.class)).aSN().bjJ(this.dom.gRI());
      bool = as.bjt(this.dom.gRI());
      ((u)this.dom.bh(u.class)).gPO().a(this.dom.gRI(), Boolean.valueOf(bool), this.dom.Pwc.getContext().getString(2131760448, new Object[] { ((as)localObject).arI() }));
      AppMethodBeat.o(233061);
      return;
    }
  }
  
  public final boolean bjt(String paramString)
  {
    AppMethodBeat.i(233057);
    boolean bool = as.bjt(paramString);
    AppMethodBeat.o(233057);
    return bool;
  }
  
  public final boolean bmH(String paramString)
  {
    AppMethodBeat.i(233058);
    boolean bool = as.bjs(paramString);
    AppMethodBeat.o(233058);
    return bool;
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(233060);
    super.gIl();
    if (!gPu())
    {
      AppMethodBeat.o(233060);
      return;
    }
    ((PluginFinder)g.ah(PluginFinder.class)).getSessionInfoStorage().add(this.PnQ);
    ((m)g.af(m.class)).m(this.PnR);
    AppMethodBeat.o(233060);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(233059);
    super.gIm();
    if (!gPu())
    {
      AppMethodBeat.o(233059);
      return;
    }
    gPv();
    ((n)g.af(n.class)).ave(this.dom.getTalkerUserName());
    if (!Util.isNullOrNil(this.dom.getTalkerUserName())) {
      com.tencent.f.h.RTc.aY(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233054);
          List localList = ((l)g.af(l.class)).eiy().fw(Collections.singletonList("findermessage006"));
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            ca localca = (ca)localIterator.next();
            a.a locala = com.tencent.mm.plugin.byp.b.a.pPx;
            if (!com.tencent.mm.plugin.byp.b.a.crV().contains(Long.valueOf(localca.field_msgId)))
            {
              localca.setStatus(5);
              ((l)g.af(l.class)).eiy().a(localca.field_msgId, localca);
            }
          }
          Log.i("MicroMsg.ChattingBypComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), i.this.dom.gOZ(), i.this.dom.getTalkerUserName() });
          AppMethodBeat.o(233054);
        }
      });
    }
    Object localObject2 = ((com.tencent.mm.plugin.i.a.aa)g.af(com.tencent.mm.plugin.i.a.aa.class)).avi(this.dom.getTalkerUserName());
    Object localObject1 = d.vdp;
    localObject1 = d.dnJ();
    long l;
    if (as.bjt((String)localObject2))
    {
      l = 2L;
      String str = this.dom.getTalkerUserName();
      p.h(localObject2, "talkUserName");
      p.h(str, "chatName");
      ((d.d)localObject1).vdx = l;
      ((d.d)localObject1).vdz = ((String)localObject2);
      ((d.d)localObject1).vdD = str;
      ((d.d)localObject1).sTp = cl.aWA();
      ((d.d)localObject1).vdB = String.valueOf(((d.d)localObject1).sTp);
      localObject2 = d.vdp;
      if (!d.dnG().viM) {
        break label272;
      }
      localObject2 = d.vdp;
      ((d.d)localObject1).vdA = d.dnG().viN.vdr;
    }
    for (;;)
    {
      Log.i(((d.d)localObject1).TAG, "onEnterChat:talkUserNameL" + ((d.d)localObject1).vdz + ", chatNameL" + ((d.d)localObject1).vdD + "， accountTypeL" + ((d.d)localObject1).vdx);
      AppMethodBeat.o(233059);
      return;
      l = 1L;
      break;
      label272:
      localObject2 = d.vdp;
      if (d.dnF().viM)
      {
        localObject2 = d.vdp;
        ((d.d)localObject1).vdA = d.dnF().viN.vdr;
      }
    }
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(233062);
    super.gIo();
    if (!gPu())
    {
      AppMethodBeat.o(233062);
      return;
    }
    ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().avs(this.dom.getTalkerUserName());
    ((PluginFinder)g.ah(PluginFinder.class)).getSessionInfoStorage().remove(this.PnQ);
    ((m)g.af(m.class)).l(this.PnR);
    Object localObject3;
    Object localObject2;
    if (as.bjt(((PluginFinder)g.ah(PluginFinder.class)).getSessionInfoStorage().avz(this.dom.GUe.field_username).field_talker))
    {
      ((PluginFinder)g.ah(PluginFinder.class)).getRedDotManager().tJB.dat();
      if (this.EBK != null) {
        this.EBK.destroy();
      }
      localObject3 = this.dom.getTalkerUserName();
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      if ((this.dom == null) || (this.dom.Pwc.getContext() == null)) {
        break label605;
      }
    }
    label605:
    for (int i = this.dom.Pwc.getContext().getIntent().getIntExtra("key_comment_scene", 0);; i = 0)
    {
      Object localObject1 = FinderReporterUIC.wzC;
      String str = FinderReporterUIC.a.MG(i + 100);
      localObject1 = d.vdp;
      d.d locald = d.dnJ();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      long l = i;
      p.h(localObject1, "talker");
      localObject3 = new com.tencent.mm.g.b.a.bg();
      ((com.tencent.mm.g.b.a.bg)localObject3).esa = l;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        ((com.tencent.mm.g.b.a.bg)localObject3).els = ((com.tencent.mm.g.b.a.bg)localObject3).x("sessionid", (String)localObject2, true);
        if (str == null) {}
        for (localObject2 = "";; localObject2 = str)
        {
          ((com.tencent.mm.g.b.a.bg)localObject3).esd = ((com.tencent.mm.g.b.a.bg)localObject3).x("clicktabcontextid", (String)localObject2, true);
          ((com.tencent.mm.g.b.a.bg)localObject3).esb = locald.vdx;
          ((com.tencent.mm.g.b.a.bg)localObject3).esc = ((com.tencent.mm.g.b.a.bg)localObject3).x("talkerUsername", locald.vdz, true);
          ((com.tencent.mm.g.b.a.bg)localObject3).esf = ((com.tencent.mm.g.b.a.bg)localObject3).x("chatSessionid", locald.vdB, true);
          ((com.tencent.mm.g.b.a.bg)localObject3).ese = ((com.tencent.mm.g.b.a.bg)localObject3).x("chatListSessionid", locald.vdA, true);
          ((com.tencent.mm.g.b.a.bg)localObject3).esg = (cl.aWA() - locald.sTp);
          ((com.tencent.mm.g.b.a.bg)localObject3).esh = ((com.tencent.mm.g.b.a.bg)localObject3).x("chatName", locald.vdD, true);
          ((com.tencent.mm.g.b.a.bg)localObject3).esi = locald.vdE;
          ((com.tencent.mm.g.b.a.bg)localObject3).esl = locald.vdH;
          l = locald.sTp;
          p.h(localObject1, "talker");
          p.h(localObject3, "chatEnterStruct");
          locald.vdy.post((Runnable)new d.d.a(locald, (String)localObject1, l, (com.tencent.mm.g.b.a.bg)localObject3));
          locald.vdx = 0L;
          locald.vdz = "";
          locald.vdA = "";
          locald.vdB = "";
          locald.vdC = 0L;
          locald.vdD = "";
          locald.vdE = 0L;
          locald.vdF = 0L;
          locald.vdG = 0L;
          locald.vdH = 0L;
          locald.sTp = 0L;
          AppMethodBeat.o(233062);
          return;
          ((PluginFinder)g.ah(PluginFinder.class)).getRedDotManager().tJB.das();
          break;
        }
      }
    }
  }
  
  public final boolean gPu()
  {
    AppMethodBeat.i(233056);
    boolean bool = as.avl(this.dom.getTalkerUserName());
    AppMethodBeat.o(233056);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.i
 * JD-Core Version:    0.7.0.1
 */