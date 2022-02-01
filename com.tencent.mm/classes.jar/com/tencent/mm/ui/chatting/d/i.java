package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.byp.b.a.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.j;
import com.tencent.mm.plugin.finder.extension.reddot.e;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.report.b.a;
import com.tencent.mm.plugin.finder.report.b.d;
import com.tencent.mm.plugin.finder.report.b.d.a;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.s;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.h.class)
class i
  extends a
  implements com.tencent.mm.ui.chatting.d.b.h
{
  private k.a Kcu;
  
  i()
  {
    AppMethodBeat.i(187295);
    this.Kcu = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(187293);
        if (paramAnonymousm.dmp.equals(i.this.cXJ.Cqh.field_username)) {
          i.a(i.this);
        }
        AppMethodBeat.o(187293);
      }
    };
    AppMethodBeat.o(187295);
  }
  
  private void fHp()
  {
    AppMethodBeat.i(187301);
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().ajt(this.cXJ.Cqh.field_username);
    ChatFooter localChatFooter;
    if ((((s)this.cXJ.bh(s.class)).fHF() != null) && (an.aji(this.cXJ.Cqh.field_username)))
    {
      localChatFooter = ((s)this.cXJ.bh(s.class)).fHF();
      if (((j)localObject).field_disableSendMsg == 1) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      localChatFooter.setFooterStatus(bool);
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK(this.cXJ.fJy());
      bool = an.aUu(this.cXJ.fJy());
      ((s)this.cXJ.bh(s.class)).fHF().a(this.cXJ.fJy(), Boolean.valueOf(bool), this.cXJ.Kkd.getContext().getString(2131766841, new Object[] { ((an)localObject).adF() }));
      AppMethodBeat.o(187301);
      return;
    }
  }
  
  public final boolean aUu(String paramString)
  {
    AppMethodBeat.i(187297);
    boolean bool = an.aUu(paramString);
    AppMethodBeat.o(187297);
    return bool;
  }
  
  public final boolean aXD(String paramString)
  {
    AppMethodBeat.i(187298);
    boolean bool = an.aUt(paramString);
    AppMethodBeat.o(187298);
    return bool;
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(187300);
    super.fAt();
    if (!fHo())
    {
      AppMethodBeat.o(187300);
      return;
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().add(this.Kcu);
    AppMethodBeat.o(187300);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(187299);
    super.fAu();
    if (!fHo())
    {
      AppMethodBeat.o(187299);
      return;
    }
    fHp();
    ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).ajb(this.cXJ.getTalkerUserName());
    if (!bu.isNullOrNil(this.cXJ.getTalkerUserName())) {
      com.tencent.e.h.MqF.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187294);
          List localList = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().eB(Collections.singletonList("findermessage006"));
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            bv localbv = (bv)localIterator.next();
            a.a locala = com.tencent.mm.plugin.byp.b.a.oBL;
            if (!com.tencent.mm.plugin.byp.b.a.bUi().contains(Long.valueOf(localbv.field_msgId)))
            {
              localbv.setStatus(5);
              ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(localbv.field_msgId, localbv);
            }
          }
          ae.i("MicroMsg.ChattingBypComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), i.this.cXJ.fGT(), i.this.cXJ.getTalkerUserName() });
          AppMethodBeat.o(187294);
        }
      });
    }
    Object localObject2 = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(this.cXJ.getTalkerUserName());
    Object localObject1 = b.sxb;
    localObject1 = b.cFf();
    long l;
    if (an.aUu((String)localObject2))
    {
      l = 2L;
      String str = this.cXJ.getTalkerUserName();
      d.g.b.p.h(localObject2, "talkUserName");
      d.g.b.p.h(str, "chatName");
      ((b.d)localObject1).sxk = l;
      ((b.d)localObject1).sxm = ((String)localObject2);
      ((b.d)localObject1).sxq = str;
      ((b.d)localObject1).sxe = ch.aDc();
      ((b.d)localObject1).sxo = String.valueOf(((b.d)localObject1).sxe);
      localObject2 = b.sxb;
      if (!b.cFc().sCH) {
        break label272;
      }
      localObject2 = b.sxb;
      ((b.d)localObject1).sxn = b.cFc().sCI.sxd;
    }
    for (;;)
    {
      ae.i(((b.d)localObject1).TAG, "onEnterChat:talkUserNameL" + ((b.d)localObject1).sxm + ", chatNameL" + ((b.d)localObject1).sxq + "， accountTypeL" + ((b.d)localObject1).sxk);
      AppMethodBeat.o(187299);
      return;
      l = 1L;
      break;
      label272:
      localObject2 = b.sxb;
      if (b.cFb().sCH)
      {
        localObject2 = b.sxb;
        ((b.d)localObject1).sxn = b.cFb().sCI.sxd;
      }
    }
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(187302);
    super.fAy();
    if (!fHo())
    {
      AppMethodBeat.o(187302);
      return;
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().ajp(this.cXJ.getTalkerUserName());
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().remove(this.Kcu);
    Object localObject3;
    Object localObject2;
    if (an.aUu(((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().ajt(this.cXJ.Cqh.field_username).field_talker))
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getRedDotManager().sax.cBi();
      localObject3 = this.cXJ.getTalkerUserName();
      localObject2 = ((c)com.tencent.mm.kernel.g.ab(c.class)).cos();
      if ((this.cXJ == null) || (this.cXJ.Kkd.getContext() == null)) {
        break label574;
      }
    }
    label574:
    for (int i = this.cXJ.Kkd.getContext().getIntent().getIntExtra("key_comment_scene", 0);; i = 0)
    {
      Object localObject1 = FinderReporterUIC.tnG;
      String str = FinderReporterUIC.a.GW(i + 100);
      localObject1 = b.sxb;
      b.d locald = b.cFf();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      long l = i;
      d.g.b.p.h(localObject1, "talker");
      localObject3 = new af();
      ((af)localObject3).dWv = l;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        ((af)localObject3).dRJ = ((af)localObject3).t("sessionid", (String)localObject2, true);
        if (str == null) {}
        for (localObject2 = "";; localObject2 = str)
        {
          ((af)localObject3).dWy = ((af)localObject3).t("clicktabcontextid", (String)localObject2, true);
          ((af)localObject3).dWw = locald.sxk;
          ((af)localObject3).dWx = ((af)localObject3).t("talkerUsername", locald.sxm, true);
          ((af)localObject3).dWA = ((af)localObject3).t("chatSessionid", locald.sxo, true);
          ((af)localObject3).dWz = ((af)localObject3).t("chatListSessionid", locald.sxn, true);
          ((af)localObject3).dWB = (ch.aDc() - locald.sxe);
          ((af)localObject3).dWC = ((af)localObject3).t("chatName", locald.sxq, true);
          ((af)localObject3).dWD = locald.sxr;
          ((af)localObject3).dWG = locald.sxu;
          l = locald.sxe;
          d.g.b.p.h(localObject1, "talker");
          d.g.b.p.h(localObject3, "chatEnterStruct");
          locald.sxl.post((Runnable)new b.d.a(locald, (String)localObject1, l, (af)localObject3));
          locald.sxk = 0L;
          locald.sxm = "";
          locald.sxn = "";
          locald.sxo = "";
          locald.sxp = 0L;
          locald.sxq = "";
          locald.sxr = 0L;
          locald.sxs = 0L;
          locald.sxt = 0L;
          locald.sxu = 0L;
          locald.sxe = 0L;
          AppMethodBeat.o(187302);
          return;
          ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getRedDotManager().sax.cBh();
          break;
        }
      }
    }
  }
  
  public final boolean fHo()
  {
    AppMethodBeat.i(187296);
    boolean bool = an.aji(this.cXJ.getTalkerUserName());
    AppMethodBeat.o(187296);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.i
 * JD-Core Version:    0.7.0.1
 */