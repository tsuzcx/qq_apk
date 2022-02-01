package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.a.b.b;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.emoji.a.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.aa;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.l.a.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@com.tencent.mm.ui.chatting.d.a.a(gRF=r.class)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/component/EmojiEggComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IEmojiEggComponent;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$IOnMsgChange;", "()V", "TAG", "", "checkKeywordTask", "Ljava/lang/Runnable;", "dynamicController", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController;", "eggMgr", "Lcom/tencent/mm/ui/chatting/EggMgr;", "eggMsgFilter", "Lkotlin/Function1;", "Lcom/tencent/mm/storage/MsgInfo;", "", "isChatEnter", "isPaused", "onScrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "uncheckMsg", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "checkEggKeyword", "", "msgInfoList", "", "isUnread", "checkKeyword", "text", "checkUnreadMsg", "getMagicEmojiHolder", "Landroid/widget/FrameLayout;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onChatContentScroll", "translateY", "", "finished", "onChattingEnterAnimEnd", "onChattingExitAnimStart", "onChattingPause", "onChattingResume", "onComponentUnInstall", "onNotifyChange", "msgStorage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "release", "updateView", "app_release"})
public final class u
  extends a
  implements i.a, r
{
  private boolean Ppi;
  private ca Ppj;
  private final aa Ppk;
  private final e Ppl;
  private final kotlin.g.a.b<ca, Boolean> Ppm;
  private Runnable Ppn;
  private final ViewTreeObserver.OnScrollChangedListener Ppo;
  private final com.tencent.mm.emoji.a.a Ppp;
  private final String TAG;
  private boolean isPaused;
  
  public u()
  {
    AppMethodBeat.i(231210);
    this.TAG = "MicroMsg.EmojiEggComponent";
    this.Ppk = new aa();
    this.Ppl = new e();
    this.Ppm = ((kotlin.g.a.b)new c(this));
    this.Ppn = ((Runnable)u.b.Ppt);
    this.Ppo = ((ViewTreeObserver.OnScrollChangedListener)new f(this));
    this.Ppp = ((com.tencent.mm.emoji.a.a)new h(this));
    AppMethodBeat.o(231210);
  }
  
  private void jq(List<? extends ca> paramList)
  {
    AppMethodBeat.i(231208);
    p.h(paramList, "msgInfoList");
    z(paramList, false);
    AppMethodBeat.o(231208);
  }
  
  private final void release()
  {
    AppMethodBeat.i(231203);
    d.C(this.Ppn);
    this.Ppn = ((Runnable)u.g.Ppv);
    Object localObject = this.dom;
    p.g(localObject, "mChattingContext");
    localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).gRQ();
    p.g(localObject, "mChattingContext.pullDownViewCallback");
    localObject = ((af)localObject).gOd();
    p.g(localObject, "mChattingContext.pullDow…Callback.chattingListView");
    ((MMChattingListView)localObject).getViewTreeObserver().removeOnScrollChangedListener(this.Ppo);
    this.Ppk.onPause();
    this.Ppk.gOi();
    this.Ppl.onStop();
    localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).eiy().a((i.a)this);
    AppMethodBeat.o(231203);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(231205);
    this.Ppl.a(this.Ppp);
    AppMethodBeat.o(231205);
  }
  
  private final void z(final List<? extends ca> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(231204);
    this.Ppn = ((Runnable)new a(this, paramBoolean, paramList));
    d.B(this.Ppn);
    AppMethodBeat.o(231204);
  }
  
  public final void a(i parami, i.c paramc)
  {
    AppMethodBeat.i(231209);
    p.h(parami, "msgStorage");
    p.h(paramc, "notifyInfo");
    Object localObject1;
    Object localObject2;
    if (this.isPaused)
    {
      if (Util.isEqual("insert", paramc.zqn))
      {
        parami = paramc.hIs;
        p.g(parami, "notifyInfo.msgList");
        localObject1 = (Iterable)parami;
        parami = this.Ppm;
        paramc = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (((Boolean)parami.invoke(localObject2)).booleanValue()) {
            paramc.add(localObject2);
          }
        }
        localObject1 = ((Iterable)paramc).iterator();
        if (((Iterator)localObject1).hasNext()) {
          break label172;
        }
        parami = null;
      }
      label172:
      do
      {
        this.Ppj = ((ca)parami);
        AppMethodBeat.o(231209);
        return;
        parami = ((Iterator)localObject1).next();
      } while (!((Iterator)localObject1).hasNext());
      paramc = (ca)parami;
      p.g(paramc, "it");
      long l1 = paramc.ajL();
      label211:
      paramc = ((Iterator)localObject1).next();
      localObject2 = (ca)paramc;
      p.g(localObject2, "it");
      long l2 = ((ca)localObject2).ajL();
      if (l1 >= l2) {
        break label537;
      }
      l1 = l2;
      parami = paramc;
    }
    label537:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        break;
        if (Util.isEqual("insert", paramc.zqn))
        {
          parami = paramc.hIs;
          p.g(parami, "notifyInfo.msgList");
          localObject1 = (Iterable)parami;
          parami = this.Ppm;
          paramc = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (((Boolean)parami.invoke(localObject2)).booleanValue()) {
              paramc.add(localObject2);
            }
          }
          jq((List)paramc);
          AppMethodBeat.o(231209);
          return;
        }
        if (Util.isEqual("update", paramc.zqn))
        {
          parami = paramc.hIs;
          p.g(parami, "notifyInfo.msgList");
          paramc = (Iterable)parami;
          parami = (Collection)new ArrayList();
          paramc = paramc.iterator();
          label507:
          while (paramc.hasNext())
          {
            localObject1 = paramc.next();
            localObject2 = (ca)localObject1;
            p.g(localObject2, "it");
            if ((((ca)localObject2).gDG() == 4) || (((ca)localObject2).getType() == 10000)) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label507;
              }
              parami.add(localObject1);
              break;
            }
          }
          d.h((kotlin.g.a.a)new e(this, (List)parami));
        }
        AppMethodBeat.o(231209);
        return;
      }
      break label211;
    }
  }
  
  public final void bmJ(String paramString)
  {
    AppMethodBeat.i(231207);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(231207);
      return;
    }
    localObject = new ca();
    ((ca)localObject).setContent(paramString);
    ((ca)localObject).nv(1);
    jq(j.listOf(localObject));
    AppMethodBeat.o(231207);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(231197);
    super.cFx();
    if (this.Ppl.gUY == null)
    {
      localObject = this.Ppl;
      com.tencent.mm.ui.chatting.e.a locala = this.dom;
      p.g(locala, "mChattingContext");
      ((e)localObject).gUY = ((FrameLayout)locala.getContext().findViewById(2131298428));
    }
    this.isPaused = false;
    Object localObject = this.Ppj;
    if (localObject != null) {
      z(j.listOf(localObject), true);
    }
    this.Ppj = null;
    AppMethodBeat.o(231197);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(231198);
    this.isPaused = true;
    super.cFy();
    this.Ppk.onPause();
    this.Ppk.gOi();
    this.Ppl.onStop();
    AppMethodBeat.o(231198);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(231199);
    super.gIm();
    Object localObject1 = this.dom;
    p.g(localObject1, "mChattingContext");
    localObject1 = ((com.tencent.mm.ui.chatting.e.a)localObject1).gRQ();
    p.g(localObject1, "mChattingContext.pullDownViewCallback");
    localObject1 = ((af)localObject1).gOd();
    p.g(localObject1, "mChattingContext.pullDow…Callback.chattingListView");
    ((MMChattingListView)localObject1).getViewTreeObserver().addOnScrollChangedListener(this.Ppo);
    localObject1 = this.Ppk;
    Object localObject2 = this.dom;
    p.g(localObject2, "mChattingContext");
    boolean bool = ((com.tencent.mm.ui.chatting.e.a)localObject2).gRM();
    localObject2 = this.dom;
    p.g(localObject2, "mChattingContext");
    ((aa)localObject1).P(bool, ((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName());
    this.Ppk.onResume();
    localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).eiy().a((i.a)this, null);
    localObject1 = this.dom.bh(ae.class);
    p.g(localObject1, "mChattingContext.compone…BoxComponent::class.java)");
    localObject2 = ((ae)localObject1).gQL();
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkUnreadMsg: ");
    if (localObject2 != null)
    {
      localObject1 = Integer.valueOf(((List)localObject2).size());
      Log.i(str, localObject1);
      localObject1 = (Collection)localObject2;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label360;
      }
    }
    label360:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        z((List)localObject2, true);
      }
      if (this.Ppl.gUY == null)
      {
        localObject1 = this.Ppl;
        localObject2 = this.dom;
        p.g(localObject2, "mChattingContext");
        ((e)localObject1).gUY = ((FrameLayout)((com.tencent.mm.ui.chatting.e.a)localObject2).getContext().findViewById(2131298428));
      }
      localObject1 = this.Ppl;
      localObject2 = this.dom;
      p.g(localObject2, "mChattingContext");
      ((e)localObject1).gVs = ((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName();
      this.Ppl.gVt = ((e.b)new d(this));
      this.Ppi = true;
      AppMethodBeat.o(231199);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(231200);
    this.Ppi = false;
    super.gIn();
    release();
    AppMethodBeat.o(231200);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(231201);
    super.gOK();
    release();
    AppMethodBeat.o(231201);
  }
  
  public final void gru()
  {
    AppMethodBeat.i(231206);
    updateView();
    AppMethodBeat.o(231206);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(231202);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(231202);
      return;
      aa.amp(paramInt1);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(u paramu, boolean paramBoolean, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(231187);
      Object localObject1;
      Object localObject2;
      if (!paramBoolean)
      {
        localObject1 = ((Iterable)paramList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ca)((Iterator)localObject1).next();
          u.c(this.Ppq).q((ca)localObject2);
        }
      }
      Iterator localIterator = ((Iterable)paramList).iterator();
      if (!localIterator.hasNext()) {
        localObject1 = null;
      }
      label257:
      for (;;)
      {
        localObject1 = (ca)localObject1;
        if (localObject1 != null) {
          u.c(this.Ppq).q((ca)localObject1);
        }
        u.c(this.Ppq).a(u.d(this.Ppq));
        localObject1 = u.e(this.Ppq);
        localObject2 = this.Ppq.dom;
        p.g(localObject2, "mChattingContext");
        ((aa)localObject1).a(((com.tencent.mm.ui.chatting.e.a)localObject2).getContext(), paramList);
        AppMethodBeat.o(231187);
        return;
        localObject1 = localIterator.next();
        if (localIterator.hasNext())
        {
          long l1 = ((ca)localObject1).ajL();
          localObject2 = localIterator.next();
          long l2 = ((ca)localObject2).ajL();
          if (l1 < l2)
          {
            l1 = l2;
            localObject1 = localObject2;
          }
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label257;
            }
            break;
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/storage/MsgInfo;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<ca, Boolean>
  {
    c(u paramu)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/component/EmojiEggComponent$onChattingEnterAnimEnd$1", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "onEnd", "", "onPlayScreenEffect", "msgId", "", "effect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "onScreenEffect", "onStart", "app_release"})
  public static final class d
    implements e.b
  {
    public final void a(long paramLong, b.b paramb)
    {
      AppMethodBeat.i(231191);
      p.h(paramb, "effect");
      Log.i(u.a(this.Ppq), "onPlayScreenEffect: msg:" + paramLong + ", " + paramb.delay + ", " + paramb.effectId);
      paramb = new c(this.Ppq.dom, u.b(this.Ppq), paramLong, System.currentTimeMillis());
      com.tencent.mm.ui.l.a.b.Qlr.c(paramb);
      AppMethodBeat.o(231191);
    }
    
    public final void a(b.b paramb)
    {
      AppMethodBeat.i(231190);
      p.h(paramb, "effect");
      Log.i(u.a(this.Ppq), "onScreenEffect: msg:" + paramb.delay + ", " + paramb.effectId);
      com.tencent.mm.ui.l.a.b.Qlr.f(u.b(this.Ppq));
      AppMethodBeat.o(231190);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(u paramu, List paramList)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onScrollChanged"})
  static final class f
    implements ViewTreeObserver.OnScrollChangedListener
  {
    f(u paramu) {}
    
    public final void onScrollChanged()
    {
      AppMethodBeat.i(231193);
      u.f(this.Ppq);
      AppMethodBeat.o(231193);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/component/EmojiEggComponent$viewProvider$1", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "getItemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "itemView", "Landroid/view/View;", "getParentView", "getViewByMsgId", "msgId", "", "app_release"})
  public static final class h
    implements com.tencent.mm.emoji.a.a
  {
    public final MMNeat7extView ck(View paramView)
    {
      AppMethodBeat.i(231196);
      p.h(paramView, "itemView");
      paramView = (MMNeat7extView)paramView.findViewById(2131298416);
      AppMethodBeat.o(231196);
      return paramView;
    }
    
    public final View zh(long paramLong)
    {
      AppMethodBeat.i(231195);
      View localView = ((k)this.Ppq.dom.bh(k.class)).zh(paramLong);
      AppMethodBeat.o(231195);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.u
 * JD-Core Version:    0.7.0.1
 */