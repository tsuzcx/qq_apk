package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ae.d;
import com.tencent.mm.emoji.a.a.a;
import com.tencent.mm.emoji.a.b.a;
import com.tencent.mm.emoji.a.b.b;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.emoji.a.e.b;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.emoji.a.f.a;
import com.tencent.mm.kernel.h;
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
import com.tencent.mm.ui.n.a.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.chatting.d.a.a(hRc=r.class)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/component/EmojiEggComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IEmojiEggComponent;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$IOnMsgChange;", "()V", "TAG", "", "animFilter", "Lkotlin/Function1;", "Lcom/tencent/mm/storage/MsgInfo;", "", "checkKeywordTask", "Ljava/lang/Runnable;", "dynamicController", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController;", "eggMgr", "Lcom/tencent/mm/ui/chatting/EggMgr;", "eggMsgFilter", "isChatEnter", "isPaused", "onScrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "patFilter", "patMsgMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "uncheckMsg", "unreadPatMsg", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "checkEggKeyword", "", "msgInfoList", "", "isUnread", "checkKeyword", "text", "checkUnreadMsg", "getChattingViewProvider", "getMagicEmojiHolder", "Landroid/widget/FrameLayout;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBounceOffsetChanged", "offset", "onChatContentScroll", "translateY", "", "finished", "onChattingEnterAnimEnd", "onChattingExitAnimStart", "onChattingPause", "onChattingResume", "onComponentUnInstall", "onNotifyChange", "msgStorage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "recordPatMsg", "msg", "showIndex", "isAllRead", "release", "updateView", "app_release"})
public final class v
  extends a
  implements i.a, r
{
  private final String TAG;
  private final aa WJA;
  private final e WJB;
  private final HashMap<Long, Integer> WJC;
  private ca WJD;
  private final kotlin.g.a.b<ca, Boolean> WJE;
  private final kotlin.g.a.b<ca, Boolean> WJF;
  private final kotlin.g.a.b<ca, Boolean> WJG;
  private Runnable WJH;
  private final ViewTreeObserver.OnScrollChangedListener WJI;
  private final com.tencent.mm.emoji.a.a WJJ;
  private boolean WJy;
  private ca WJz;
  private boolean isPaused;
  
  public v()
  {
    AppMethodBeat.i(291110);
    this.TAG = "MicroMsg.EmojiEggComponent";
    this.WJA = new aa();
    this.WJB = new e();
    this.WJC = new HashMap();
    this.WJE = ((kotlin.g.a.b)new d(this));
    this.WJF = ((kotlin.g.a.b)new a(this));
    this.WJG = ((kotlin.g.a.b)new i(this));
    this.WJH = ((Runnable)c.WJN);
    this.WJI = ((ViewTreeObserver.OnScrollChangedListener)new h(this));
    this.WJJ = ((com.tencent.mm.emoji.a.a)new k(this));
    AppMethodBeat.o(291110);
  }
  
  private final void B(final List<? extends ca> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(291103);
    this.WJH = ((Runnable)new b(this, paramBoolean, paramList));
    d.B(this.WJH);
    AppMethodBeat.o(291103);
  }
  
  private void ki(List<? extends ca> paramList)
  {
    AppMethodBeat.i(291107);
    p.k(paramList, "msgInfoList");
    B(paramList, false);
    AppMethodBeat.o(291107);
  }
  
  private final void release()
  {
    AppMethodBeat.i(291102);
    d.C(this.WJH);
    this.WJH = ((Runnable)v.j.WJQ);
    Object localObject = this.fgR;
    p.j(localObject, "mChattingContext");
    localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).hRm();
    p.j(localObject, "mChattingContext.pullDownViewCallback");
    localObject = ((af)localObject).hNn();
    p.j(localObject, "mChattingContext.pullDow…Callback.chattingListView");
    ((MMChattingListView)localObject).getViewTreeObserver().removeOnScrollChangedListener(this.WJI);
    this.WJA.onPause();
    this.WJA.hNs();
    aa.onDestroy();
    this.WJB.onStop();
    localObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).eSe().a((i.a)this);
    this.WJC.clear();
    this.WJD = null;
    AppMethodBeat.o(291102);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(291104);
    this.WJB.a(this.WJJ);
    AppMethodBeat.o(291104);
  }
  
  public final void a(ca paramca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(291108);
    p.k(paramca, "msg");
    Log.d(this.TAG, "recordPatMsg: " + paramca.apG() + ", " + paramInt + ", " + paramBoolean + ", " + this.WJy);
    if ((paramBoolean) || (this.WJy))
    {
      this.WJC.put(Long.valueOf(paramca.apG()), Integer.valueOf(paramInt));
      AppMethodBeat.o(291108);
      return;
    }
    this.WJC.put(Long.valueOf(paramca.apG()), Integer.valueOf(paramInt - 1));
    ca localca = this.WJD;
    if (localca != null) {}
    for (long l = localca.apG();; l = 0L)
    {
      if (paramca.apG() > l) {
        this.WJD = paramca;
      }
      AppMethodBeat.o(291108);
      return;
    }
  }
  
  public final void alg(int paramInt)
  {
    AppMethodBeat.i(293373);
    if (paramInt != 0) {
      updateView();
    }
    AppMethodBeat.o(293373);
  }
  
  public final void bzj(String paramString)
  {
    AppMethodBeat.i(291106);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291106);
      return;
    }
    localObject = new ca();
    ((ca)localObject).setContent(paramString);
    ((ca)localObject).pJ(1);
    ki(j.listOf(localObject));
    AppMethodBeat.o(291106);
  }
  
  public final void hGW()
  {
    long l2 = 0L;
    AppMethodBeat.i(291096);
    super.hGW();
    Object localObject1 = this.fgR;
    p.j(localObject1, "mChattingContext");
    localObject1 = ((com.tencent.mm.ui.chatting.e.a)localObject1).hRm();
    p.j(localObject1, "mChattingContext.pullDownViewCallback");
    localObject1 = ((af)localObject1).hNn();
    p.j(localObject1, "mChattingContext.pullDow…Callback.chattingListView");
    ((MMChattingListView)localObject1).getViewTreeObserver().addOnScrollChangedListener(this.WJI);
    localObject1 = this.WJA;
    Object localObject2 = this.fgR;
    p.j(localObject2, "mChattingContext");
    boolean bool = ((com.tencent.mm.ui.chatting.e.a)localObject2).hRi();
    localObject2 = this.fgR;
    p.j(localObject2, "mChattingContext");
    ((aa)localObject1).V(bool, ((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName());
    this.WJA.onResume();
    localObject1 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).eSe().a((i.a)this, null);
    localObject1 = this.fgR.bC(ae.class);
    p.j(localObject1, "mChattingContext.compone…BoxComponent::class.java)");
    Object localObject3 = ((ae)localObject1).hQi();
    p.j(localObject3, "unreadList");
    Iterator localIterator = ((Iterable)localObject3).iterator();
    if (!localIterator.hasNext()) {
      localObject1 = null;
    }
    label247:
    int i;
    label320:
    do
    {
      localObject1 = (ca)localObject1;
      if (localObject1 == null) {
        break;
      }
      l1 = ((ca)localObject1).apG();
      localObject1 = this.WJD;
      if (localObject1 != null) {
        l2 = ((ca)localObject1).apG();
      }
      if (l1 < l2) {
        break label544;
      }
      Log.i(this.TAG, "checkUnreadMsg: " + Integer.valueOf(((List)localObject3).size()));
      if (!((Collection)localObject3).isEmpty()) {
        break label539;
      }
      i = 1;
      if (i == 0) {
        B((List)localObject3, true);
      }
      this.WJD = null;
      localObject1 = this.fgR;
      p.j(localObject1, "mChattingContext");
      localObject1 = (FrameLayout)((com.tencent.mm.ui.chatting.e.a)localObject1).getContext().findViewById(R.h.dxp);
      this.WJB.jFQ = ((FrameLayout)localObject1);
      localObject1 = this.WJB;
      localObject2 = this.fgR;
      p.j(localObject2, "mChattingContext");
      ((e)localObject1).jGo = ((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName();
      this.WJB.jGp = ((e.b)new e(this));
      this.WJy = true;
      AppMethodBeat.o(291096);
      return;
      localObject1 = localIterator.next();
    } while (!localIterator.hasNext());
    localObject2 = (ca)localObject1;
    p.j(localObject2, "it");
    long l1 = ((ca)localObject2).apG();
    label476:
    localObject2 = localIterator.next();
    ca localca = (ca)localObject2;
    p.j(localca, "it");
    long l3 = localca.apG();
    if (l1 < l3)
    {
      l1 = l3;
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        break;
        l1 = 0L;
        break label247;
        label539:
        i = 0;
        break label320;
        label544:
        localObject2 = this.TAG;
        localObject3 = new StringBuilder("checkUnreadMsg: pat msg ");
        localObject1 = this.WJD;
        if (localObject1 != null) {}
        for (localObject1 = Long.valueOf(((ca)localObject1).apG());; localObject1 = null)
        {
          Log.i((String)localObject2, localObject1);
          localObject3 = this.WJD;
          if (localObject3 == null) {
            break;
          }
          localObject1 = this.fgR.bC(k.class);
          p.j(localObject1, "mChattingContext.compone…terComponent::class.java)");
          localObject1 = ((k)localObject1).hNB();
          if (((SparseArray)localObject1).size() <= 0) {
            break;
          }
          localObject1 = (ca)((SparseArray)localObject1).get(((SparseArray)localObject1).size() - 1);
          if ((localObject1 == null) || (((ca)localObject1).apG() != ((ca)localObject3).apG())) {
            break;
          }
          localObject2 = (Integer)this.WJC.get(Long.valueOf(((ca)localObject3).apG()));
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Integer.valueOf(0);
          }
          p.j(localObject1, "patMsgMap.get(it.msgId) ?: 0");
          i = ((Integer)localObject1).intValue();
          int j = this.WJB.a((ca)localObject3, i);
          if (j < i) {
            break;
          }
          this.WJC.put(Long.valueOf(((ca)localObject3).apG()), Integer.valueOf(j));
          break;
        }
      }
      break label476;
    }
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(291093);
    super.hGX();
    if (this.WJB.jFQ == null)
    {
      localObject = this.WJB;
      com.tencent.mm.ui.chatting.e.a locala = this.fgR;
      p.j(locala, "mChattingContext");
      ((e)localObject).jFQ = ((FrameLayout)locala.getContext().findViewById(R.h.dxp));
    }
    this.isPaused = false;
    Object localObject = this.WJz;
    if (localObject != null) {
      B(j.listOf(localObject), true);
    }
    this.WJz = null;
    AppMethodBeat.o(291093);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(291095);
    this.isPaused = true;
    super.hGY();
    this.WJA.onPause();
    this.WJA.hNs();
    this.WJB.onStop();
    AppMethodBeat.o(291095);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(291097);
    this.WJy = false;
    super.hGZ();
    release();
    AppMethodBeat.o(291097);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(291099);
    super.hNZ();
    release();
    AppMethodBeat.o(291099);
  }
  
  public final com.tencent.mm.emoji.a.a hPh()
  {
    return this.WJJ;
  }
  
  public final void hmt()
  {
    AppMethodBeat.i(291105);
    updateView();
    AppMethodBeat.o(291105);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(291100);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(291100);
  }
  
  public final void onNotifyChange(i parami, i.c paramc)
  {
    AppMethodBeat.i(291109);
    p.k(parami, "msgStorage");
    p.k(paramc, "notifyInfo");
    Object localObject1;
    Object localObject2;
    if (this.isPaused)
    {
      if (Util.isEqual("insert", paramc.EVM))
      {
        parami = paramc.kvM;
        p.j(parami, "notifyInfo.msgList");
        localObject1 = (Iterable)parami;
        parami = this.WJF;
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
        this.WJz = ((ca)parami);
        AppMethodBeat.o(291109);
        return;
        parami = ((Iterator)localObject1).next();
      } while (!((Iterator)localObject1).hasNext());
      paramc = (ca)parami;
      p.j(paramc, "it");
      long l1 = paramc.apG();
      label211:
      paramc = ((Iterator)localObject1).next();
      localObject2 = (ca)paramc;
      p.j(localObject2, "it");
      long l2 = ((ca)localObject2).apG();
      if (l1 >= l2) {
        break label650;
      }
      l1 = l2;
      parami = paramc;
    }
    label650:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        break;
        Object localObject3;
        if (Util.isEqual("insert", paramc.EVM))
        {
          parami = paramc.kvM;
          p.j(parami, "notifyInfo.msgList");
          localObject2 = (Iterable)parami;
          parami = this.WJF;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (((Boolean)parami.invoke(localObject3)).booleanValue()) {
              ((Collection)localObject1).add(localObject3);
            }
          }
          ki((List)localObject1);
        }
        for (;;)
        {
          parami = paramc.kvM;
          p.j(parami, "notifyInfo.msgList");
          localObject1 = (Iterable)parami;
          parami = this.WJG;
          paramc = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (((Boolean)parami.invoke(localObject2)).booleanValue()) {
              paramc.add(localObject2);
            }
          }
          if (Util.isEqual("update", paramc.EVM))
          {
            parami = paramc.kvM;
            p.j(parami, "notifyInfo.msgList");
            localObject1 = (Iterable)parami;
            parami = (Collection)new ArrayList();
            localObject1 = ((Iterable)localObject1).iterator();
            label599:
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              localObject3 = (ca)localObject2;
              p.j(localObject3, "it");
              if ((((ca)localObject3).hzT() == 4) || (((ca)localObject3).getType() == 10000)) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label599;
                }
                parami.add(localObject2);
                break;
              }
            }
            d.uiThread((kotlin.g.a.a)new f(this, (List)parami));
          }
        }
        d.uiThread((kotlin.g.a.a)new g(this, (List)paramc));
        AppMethodBeat.o(291109);
        return;
      }
      break label211;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/storage/MsgInfo;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<ca, Boolean>
  {
    a(v paramv)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(v paramv, boolean paramBoolean, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(285662);
      Object localObject1;
      if (!paramBoolean)
      {
        localObject1 = ((Iterable)paramList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ca)((Iterator)localObject1).next();
          v.c(this.WJK).r((ca)localObject2);
        }
      }
      Object localObject3 = ((Iterable)paramList).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        localObject1 = null;
      }
      Collection localCollection;
      do
      {
        localObject1 = (ca)localObject1;
        if (localObject1 != null) {
          v.c(this.WJK).r((ca)localObject1);
        }
        v.c(this.WJK).a(v.d(this.WJK));
        localObject1 = v.e(this.WJK);
        localObject2 = this.WJK.fgR;
        p.j(localObject2, "mChattingContext");
        localObject2 = ((com.tencent.mm.ui.chatting.e.a)localObject2).getContext();
        Object localObject4 = (Iterable)paramList;
        localObject3 = v.f(this.WJK);
        localCollection = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (((Boolean)((kotlin.g.a.b)localObject3).invoke(localObject5)).booleanValue()) {
            localCollection.add(localObject5);
          }
        }
        localObject1 = ((Iterator)localObject3).next();
      } while (!((Iterator)localObject3).hasNext());
      long l1 = ((ca)localObject1).apG();
      label285:
      Object localObject2 = ((Iterator)localObject3).next();
      long l2 = ((ca)localObject2).apG();
      if (l1 < l2)
      {
        l1 = l2;
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext())
        {
          break;
          ((aa)localObject1).a((Activity)localObject2, (List)localCollection);
          AppMethodBeat.o(285662);
          return;
        }
        break label285;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c WJN;
    
    static
    {
      AppMethodBeat.i(279924);
      WJN = new c();
      AppMethodBeat.o(279924);
    }
    
    public final void run() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/storage/MsgInfo;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<ca, Boolean>
  {
    d(v paramv)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/component/EmojiEggComponent$onChattingEnterAnimEnd$1", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "onEnd", "", "onPlayScreenEffect", "msgId", "", "animKey", "", "config", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "onScreenEffect", "onStart", "app_release"})
  public static final class e
    implements e.b
  {
    public final void a(long paramLong, String paramString, b.a parama)
    {
      Object localObject2 = null;
      AppMethodBeat.i(274817);
      p.k(paramString, "animKey");
      p.k(parama, "config");
      String str = v.a(this.WJK);
      StringBuilder localStringBuilder = new StringBuilder("onPlayScreenEffect: msg:").append(paramLong).append(", ");
      Object localObject1 = parama.jFN;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((b.b)localObject1).fJe);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(", ");
        b.b localb = parama.jFN;
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = Integer.valueOf(localb.version);
        }
        Log.i(str, localObject1 + ", " + paramString + ' ' + parama.key);
        paramString = new c(this.WJK.fgR, v.b(this.WJK), paramLong, System.currentTimeMillis(), paramString, parama.key);
        com.tencent.mm.ui.n.a.b.XJa.a(paramString);
        AppMethodBeat.o(274817);
        return;
      }
    }
    
    public final void a(String paramString, b.a parama)
    {
      Object localObject = null;
      AppMethodBeat.i(274815);
      p.k(paramString, "animKey");
      p.k(parama, "config");
      String str = v.a(this.WJK);
      StringBuilder localStringBuilder = new StringBuilder("onScreenEffect: msg:");
      paramString = parama.jFN;
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.fJe);; paramString = null)
      {
        localStringBuilder = localStringBuilder.append(paramString).append(", ");
        parama = parama.jFN;
        paramString = localObject;
        if (parama != null) {
          paramString = Integer.valueOf(parama.version);
        }
        Log.i(str, paramString);
        com.tencent.mm.ui.n.a.b.XJa.a(v.b(this.WJK), new WeakReference(this.WJK.fgR));
        AppMethodBeat.o(274815);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(v paramv, List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(v paramv, List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onScrollChanged"})
  static final class h
    implements ViewTreeObserver.OnScrollChangedListener
  {
    h(v paramv) {}
    
    public final void onScrollChanged()
    {
      AppMethodBeat.i(275105);
      v.h(this.WJK);
      AppMethodBeat.o(275105);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/storage/MsgInfo;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<ca, Boolean>
  {
    i(v paramv)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/component/EmojiEggComponent$viewProvider$1", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "getItemEmojiRect", "Landroid/graphics/RectF;", "msgId", "", "animKey", "", "getItemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "itemView", "Landroid/view/View;", "getMsgAnimKey", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getParentView", "getViewByMsgId", "app_release"})
  public static final class k
    implements com.tencent.mm.emoji.a.a
  {
    public final View Fl(long paramLong)
    {
      AppMethodBeat.i(286633);
      View localView = ((k)this.WJK.fgR.bC(k.class)).Fl(paramLong);
      AppMethodBeat.o(286633);
      return localView;
    }
    
    public final RectF a(long paramLong, String paramString)
    {
      AppMethodBeat.i(286638);
      p.k(paramString, "animKey");
      RectF localRectF = new RectF();
      Object localObject = Fl(paramLong);
      if (localObject != null)
      {
        localObject = c((View)localObject, paramString);
        if (localObject == null) {
          break label123;
        }
        paramString = ((MMNeat7extView)localObject).getLayout();
        if (paramString == null) {
          break label128;
        }
        paramString = a.a.a((MMNeat7extView)localObject);
        int[] arrayOfInt = new int[2];
        ((MMNeat7extView)localObject).getLocationInWindow(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        localRectF.set(paramString);
        localRectF.offset(((MMNeat7extView)localObject).getPaddingLeft() + i, ((MMNeat7extView)localObject).getPaddingTop() + j);
      }
      for (;;)
      {
        AppMethodBeat.o(286638);
        return localRectF;
        label123:
        paramString = null;
        break;
        label128:
        Log.i(v.a(this.WJK), "updateView: no layout");
      }
    }
    
    public final MMNeat7extView c(View paramView, String paramString)
    {
      AppMethodBeat.i(286634);
      p.k(paramView, "itemView");
      p.k(paramString, "animKey");
      if (kotlin.n.n.a((CharSequence)paramString, (CharSequence)"_", false))
      {
        paramView = (ViewGroup)paramView.findViewById(R.h.dQW);
        int i = Integer.parseInt((String)kotlin.n.n.a((CharSequence)paramString, new String[] { "_" }).get(1));
        p.j(paramView, "container");
        if (paramView.getChildCount() > 0)
        {
          paramString = paramView.getChildAt(i);
          paramView = paramString;
          if (!(paramString instanceof MMNeat7extView)) {
            paramView = null;
          }
          paramView = (MMNeat7extView)paramView;
          AppMethodBeat.o(286634);
          return paramView;
        }
      }
      else
      {
        paramView = (MMNeat7extView)paramView.findViewById(R.h.chatting_content_itv);
        AppMethodBeat.o(286634);
        return paramView;
      }
      AppMethodBeat.o(286634);
      return null;
    }
    
    public final List<String> q(ca paramca)
    {
      AppMethodBeat.i(286637);
      p.k(paramca, "msg");
      LinkedList localLinkedList = new LinkedList();
      if (((Boolean)v.i(this.WJK).invoke(paramca)).booleanValue())
      {
        Object localObject1 = f.jGv;
        Object localObject2 = (Iterable)f.a.t(paramca);
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          ((Iterator)localObject2).next();
          if (i < 0) {
            j.iBO();
          }
          ((Collection)localObject1).add(paramca.apG() + '_' + i);
          i += 1;
        }
        localLinkedList.addAll((Collection)localObject1);
      }
      for (;;)
      {
        paramca = (List)localLinkedList;
        AppMethodBeat.o(286637);
        return paramca;
        if (((Boolean)v.j(this.WJK).invoke(paramca)).booleanValue()) {
          localLinkedList.add(String.valueOf(paramca.apG()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.v
 * JD-Core Version:    0.7.0.1
 */