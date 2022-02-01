package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.emoji.a.a.a;
import com.tencent.mm.emoji.a.b.a;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.emoji.a.e.b;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.emoji.a.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.magicemoji.a.c;
import com.tencent.mm.plugin.emoji.magicemoji.view.MEHolderView;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.u.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/EmojiEggComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IEmojiEggComponent;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$IOnMsgChange;", "()V", "TAG", "", "animFilter", "Lkotlin/Function1;", "Lcom/tencent/mm/storage/MsgInfo;", "", "checkKeywordTask", "Ljava/lang/Runnable;", "dynamicController", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController;", "eggMgr", "Lcom/tencent/mm/ui/chatting/EggMgr;", "eggMsgFilter", "isChatEnter", "isPaused", "magicEmojiChattingMgr", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "getMagicEmojiChattingMgr", "()Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "magicEmojiChattingMgr$delegate", "Lkotlin/Lazy;", "magicEmojiHolder", "Lcom/tencent/mm/plugin/emoji/magicemoji/view/MEHolderView;", "kotlin.jvm.PlatformType", "getMagicEmojiHolder", "()Lcom/tencent/mm/plugin/emoji/magicemoji/view/MEHolderView;", "magicEmojiHolder$delegate", "onScrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "patFilter", "patMsgMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "uncheckMsg", "unreadPatMsg", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "checkEggKeyword", "", "msgInfoList", "", "isUnread", "checkKeyword", "text", "checkUnreadMsg", "getChattingViewProvider", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBounceOffsetChanged", "offset", "onChatContentScroll", "translateY", "", "finished", "onChattingEnterAnimEnd", "onChattingExitAnimStart", "onChattingPause", "onChattingResume", "onComponentUnInstall", "onNotifyChange", "msgStorage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "recordPatMsg", "msg", "showIndex", "isAllRead", "release", "updateView", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends a
  implements i.a, com.tencent.mm.ui.chatting.component.api.u
{
  private final String TAG;
  private boolean aerF;
  private cc aerG;
  private final ac aerH;
  private final e aerI;
  private final HashMap<Long, Integer> aerJ;
  private cc aerK;
  private final kotlin.g.a.b<cc, Boolean> aerL;
  private final kotlin.g.a.b<cc, Boolean> aerM;
  private final kotlin.g.a.b<cc, Boolean> aerN;
  private Runnable aerO;
  private final ViewTreeObserver.OnScrollChangedListener aerP;
  private final j aerQ;
  private final j aerR;
  private final com.tencent.mm.emoji.a.a aerS;
  private boolean isPaused;
  
  public y()
  {
    AppMethodBeat.i(256038);
    this.TAG = "MicroMsg.EmojiEggComponent";
    this.aerH = new ac();
    this.aerI = new e();
    this.aerJ = new HashMap();
    this.aerL = ((kotlin.g.a.b)new b(this));
    this.aerM = ((kotlin.g.a.b)new a(this));
    this.aerN = ((kotlin.g.a.b)new h(this));
    this.aerO = y..ExternalSyntheticLambda3.INSTANCE;
    this.aerP = new y..ExternalSyntheticLambda0(this);
    this.aerQ = k.cm((kotlin.g.a.a)new d(this));
    this.aerR = k.cm((kotlin.g.a.a)new c(this));
    this.aerS = ((com.tencent.mm.emoji.a.a)new i(this));
    AppMethodBeat.o(256038);
  }
  
  private final void Q(List<? extends cc> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(256052);
    this.aerO = new y..ExternalSyntheticLambda1(paramBoolean, paramList, this);
    com.tencent.mm.ae.d.G(this.aerO);
    AppMethodBeat.o(256052);
  }
  
  private static final void a(y paramy)
  {
    AppMethodBeat.i(256066);
    s.u(paramy, "this$0");
    paramy.updateView();
    AppMethodBeat.o(256066);
  }
  
  private static final void a(boolean paramBoolean, List paramList, y paramy)
  {
    AppMethodBeat.i(256072);
    s.u(paramList, "$msgInfoList");
    s.u(paramy, "this$0");
    Object localObject1;
    if (!paramBoolean)
    {
      localObject1 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cc)((Iterator)localObject1).next();
        paramy.aerI.r((cc)localObject2);
      }
    }
    Object localObject3 = ((Iterable)paramList).iterator();
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = null;
    }
    do
    {
      localObject1 = (cc)localObject1;
      if (localObject1 != null) {
        paramy.aerI.r((cc)localObject1);
      }
      paramy.aerI.a(paramy.aerS);
      localObject1 = paramy.aerH;
      localObject2 = paramy.jrY();
      if (((ac)localObject1).aekA != localObject2)
      {
        if (((ac)localObject1).aekA != null) {
          ((ac)localObject1).aekA.afwI = null;
        }
        ((ac)localObject1).aekA = ((com.tencent.mm.ui.n.a.b)localObject2);
        if (((ac)localObject1).aekA != null) {
          ((ac)localObject1).aekA.afwI = ((ac)localObject1).aekE;
        }
      }
      localObject1 = paramy.aerH;
      localObject2 = paramy.hlc.aezO.getContext();
      localObject3 = (Iterable)paramList;
      paramList = paramy.aerL;
      paramy = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (((Boolean)paramList.invoke(localObject4)).booleanValue()) {
          paramy.add(localObject4);
        }
      }
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    long l1 = ((cc)localObject1).field_msgId;
    label321:
    Object localObject2 = ((Iterator)localObject3).next();
    long l2 = ((cc)localObject2).field_msgId;
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
        ((ac)localObject1).a((Activity)localObject2, (List)paramy);
        AppMethodBeat.o(256072);
        return;
      }
      break label321;
    }
  }
  
  private final com.tencent.mm.ui.n.a.b jrY()
  {
    AppMethodBeat.i(256042);
    com.tencent.mm.ui.n.a.b localb = (com.tencent.mm.ui.n.a.b)this.aerR.getValue();
    AppMethodBeat.o(256042);
    return localb;
  }
  
  private static final void jsa() {}
  
  private static final void jsb() {}
  
  private void ny(List<? extends cc> paramList)
  {
    AppMethodBeat.i(256061);
    s.u(paramList, "msgInfoList");
    Q(paramList, false);
    AppMethodBeat.o(256061);
  }
  
  private final void release()
  {
    AppMethodBeat.i(256048);
    com.tencent.mm.ae.d.H(this.aerO);
    this.aerO = y..ExternalSyntheticLambda2.INSTANCE;
    this.hlc.aezQ.jpR().getViewTreeObserver().removeOnScrollChangedListener(this.aerP);
    this.aerH.jpX();
    this.aerH.onDestroy();
    this.aerI.onStop();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a((i.a)this);
    this.aerJ.clear();
    this.aerK = null;
    AppMethodBeat.o(256048);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(256056);
    this.aerI.a(this.aerS);
    Object localObject = this.aerH;
    com.tencent.mm.emoji.a.a locala = this.aerS;
    if (((ac)localObject).aekA != null)
    {
      localObject = ((ac)localObject).aekA;
      s.u(locala, "viewProvider");
      for (;;)
      {
        if (!((Collection)((com.tencent.mm.ui.n.a.b)localObject).afwK).isEmpty()) {}
        com.tencent.mm.ui.n.a.b.b localb;
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label177;
          }
          localb = (com.tencent.mm.ui.n.a.b.b)p.oK((List)((com.tencent.mm.ui.n.a.b)localObject).afwK);
          long l = localb.afwO.xHX;
          if ((l == 0L) || (locala.ht(l) != null)) {
            break;
          }
          Log.w("MicroMsg.MEChattingMgr", s.X("[MEChattingMgr]: onChattingViewUpdate: view not found for msgId = ", Long.valueOf(l)));
          AppMethodBeat.o(256056);
          return;
        }
        ((com.tencent.mm.ui.n.a.b)localObject).b(((com.tencent.mm.ui.n.a.b)localObject).afwJ, localb.sdN, localb.afwO);
        ((com.tencent.mm.ui.n.a.b)localObject).afwK.remove(0);
      }
    }
    label177:
    AppMethodBeat.o(256056);
  }
  
  public final void Wm(int paramInt)
  {
    AppMethodBeat.i(256163);
    if (paramInt != 0) {
      updateView();
    }
    AppMethodBeat.o(256163);
  }
  
  public final void a(cc paramcc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(256173);
    s.u(paramcc, "msg");
    Log.d(this.TAG, "recordPatMsg: " + paramcc.field_msgId + ", " + paramInt + ", " + paramBoolean + ", " + this.aerF);
    if ((paramBoolean) || (this.aerF))
    {
      this.aerJ.put(Long.valueOf(paramcc.field_msgId), Integer.valueOf(paramInt));
      AppMethodBeat.o(256173);
      return;
    }
    this.aerJ.put(Long.valueOf(paramcc.field_msgId), Integer.valueOf(paramInt - 1));
    cc localcc = this.aerK;
    if (localcc == null) {}
    for (long l = 0L;; l = localcc.field_msgId)
    {
      if (paramcc.field_msgId > l) {
        this.aerK = paramcc;
      }
      AppMethodBeat.o(256173);
      return;
    }
  }
  
  public final void bAN(String paramString)
  {
    AppMethodBeat.i(256166);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(256166);
      return;
    }
    localObject = new cc();
    ((cc)localObject).setContent(paramString);
    ((cc)localObject).pI(1);
    ny(p.listOf(localObject));
    AppMethodBeat.o(256166);
  }
  
  public final void iNk()
  {
    AppMethodBeat.i(256157);
    updateView();
    AppMethodBeat.o(256157);
  }
  
  public final void jjh()
  {
    long l2 = 0L;
    int i = 0;
    AppMethodBeat.i(256139);
    super.jjh();
    this.hlc.aezQ.jpR().getViewTreeObserver().addOnScrollChangedListener(this.aerP);
    Object localObject1 = this.aerH;
    boolean bool = this.hlc.juG();
    Object localObject2 = this.hlc.getTalkerUserName();
    ((ac)localObject1).hZc = bool;
    ((ac)localObject1).name = ((String)localObject2);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a((i.a)this, null);
    Object localObject3 = ((com.tencent.mm.ui.chatting.component.api.ah)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ah.class)).jth();
    long l1;
    label137:
    label158:
    label214:
    Iterator localIterator;
    if (localObject3 == null)
    {
      l1 = 0L;
      localObject1 = this.aerK;
      if (localObject1 == null)
      {
        if (l1 < l2) {
          break label446;
        }
        localObject2 = this.TAG;
        if (localObject3 != null) {
          break label431;
        }
        localObject1 = null;
        Log.i((String)localObject2, s.X("checkUnreadMsg: ", localObject1));
        localObject1 = (Collection)localObject3;
        if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
          i = 1;
        }
        if (i == 0)
        {
          s.s(localObject3, "unreadList");
          Q((List)localObject3, true);
        }
        this.aerK = null;
        localObject1 = (FrameLayout)this.hlc.aezO.getContext().findViewById(R.h.fxK);
        this.aerI.mfE = ((FrameLayout)localObject1);
        this.aerI.mfW = this.hlc.getTalkerUserName();
        this.aerI.mfX = ((e.b)new e(this));
        this.aerF = true;
        AppMethodBeat.o(256139);
      }
    }
    else
    {
      localIterator = ((Iterable)localObject3).iterator();
      if (!localIterator.hasNext()) {
        localObject1 = null;
      }
      label318:
      do
      {
        localObject1 = (cc)localObject1;
        if (localObject1 != null) {
          break label412;
        }
        l1 = 0L;
        break;
        localObject1 = localIterator.next();
      } while (!localIterator.hasNext());
      l1 = ((cc)localObject1).field_msgId;
      label366:
      localObject2 = localIterator.next();
      long l3 = ((cc)localObject2).field_msgId;
      if (l1 >= l3) {
        break label664;
      }
      l1 = l3;
      localObject1 = localObject2;
    }
    label656:
    label659:
    label664:
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        break label318;
        label412:
        l1 = ((fi)localObject1).field_msgId;
        break;
        l2 = ((fi)localObject1).field_msgId;
        break label137;
        label431:
        localObject1 = Integer.valueOf(((List)localObject3).size());
        break label158;
        label446:
        localObject2 = this.TAG;
        localObject1 = this.aerK;
        if (localObject1 == null)
        {
          localObject1 = null;
          label466:
          Log.i((String)localObject2, s.X("checkUnreadMsg: pat msg ", localObject1));
          localObject3 = this.aerK;
          if (localObject3 == null) {
            break label214;
          }
          localObject1 = ((m)this.hlc.cm(m.class)).jqi();
          if (((SparseArray)localObject1).size() <= 0) {
            break label214;
          }
          localObject1 = (cc)((SparseArray)localObject1).get(((SparseArray)localObject1).size() - 1);
          if ((localObject1 == null) || (((fi)localObject1).field_msgId != ((fi)localObject3).field_msgId)) {
            break label656;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label659;
          }
          localObject2 = (Integer)this.aerJ.get(Long.valueOf(((fi)localObject3).field_msgId));
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Integer.valueOf(0);
          }
          i = ((Number)localObject1).intValue();
          int j = this.aerI.a((cc)localObject3, i);
          if (j < i) {
            break;
          }
          this.aerJ.put(Long.valueOf(((fi)localObject3).field_msgId), Integer.valueOf(j));
          break;
          localObject1 = Long.valueOf(((fi)localObject1).field_msgId);
          break label466;
        }
        break label214;
      }
      break label366;
    }
  }
  
  public final void jji()
  {
    AppMethodBeat.i(256122);
    super.jji();
    if (this.aerI.mfE == null) {
      this.aerI.mfE = ((FrameLayout)this.hlc.aezO.getContext().findViewById(R.h.fxK));
    }
    this.isPaused = false;
    Object localObject = this.aerG;
    if (localObject != null) {
      Q(p.listOf(localObject), true);
    }
    this.aerG = null;
    localObject = jrY();
    ((com.tencent.mm.plugin.emoji.magicemoji.a.b)h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class)).a((c)localObject);
    AppMethodBeat.o(256122);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(256130);
    this.isPaused = true;
    super.jjj();
    this.aerH.jpX();
    this.aerI.onStop();
    com.tencent.mm.ui.n.a.b localb = jrY();
    localb.a(localb.afwJ, 1);
    ((com.tencent.mm.plugin.emoji.magicemoji.a.b)h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class)).b((c)localb);
    Iterator localIterator = ((Iterable)localb.afwH.values()).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.n.b.a)localIterator.next()).stopAll();
    }
    localb.afwG.stop();
    ((com.tencent.mm.plugin.emoji.magicemoji.a.b)h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class)).dyq();
    AppMethodBeat.o(256130);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(256140);
    this.aerF = false;
    super.jjk();
    release();
    AppMethodBeat.o(256140);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(256144);
    super.jqF();
    release();
    AppMethodBeat.o(256144);
  }
  
  public final com.tencent.mm.emoji.a.a jrZ()
  {
    return this.aerS;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256149);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(256149);
  }
  
  public final void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(256186);
    s.u(parami, "msgStorage");
    s.u(paramc, "notifyInfo");
    Object localObject1;
    Object localObject2;
    if (this.isPaused)
    {
      if (Util.isEqual("insert", paramc.KRm))
      {
        parami = paramc.mZo;
        s.s(parami, "notifyInfo.msgList");
        localObject1 = (Iterable)parami;
        parami = this.aerM;
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
        this.aerG = ((cc)parami);
        AppMethodBeat.o(256186);
        return;
        parami = ((Iterator)localObject1).next();
      } while (!((Iterator)localObject1).hasNext());
      long l1 = ((cc)parami).field_msgId;
      label202:
      paramc = ((Iterator)localObject1).next();
      long l2 = ((cc)paramc).field_msgId;
      if (l1 >= l2) {
        break label623;
      }
      l1 = l2;
      parami = paramc;
    }
    label572:
    label623:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        break;
        Object localObject3;
        if (Util.isEqual("insert", paramc.KRm))
        {
          parami = paramc.mZo;
          s.s(parami, "notifyInfo.msgList");
          localObject2 = (Iterable)parami;
          parami = this.aerM;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (((Boolean)parami.invoke(localObject3)).booleanValue()) {
              ((Collection)localObject1).add(localObject3);
            }
          }
          ny((List)localObject1);
        }
        for (;;)
        {
          parami = paramc.mZo;
          s.s(parami, "notifyInfo.msgList");
          localObject1 = (Iterable)parami;
          parami = this.aerN;
          paramc = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (((Boolean)parami.invoke(localObject2)).booleanValue()) {
              paramc.add(localObject2);
            }
          }
          if (Util.isEqual("update", paramc.KRm))
          {
            parami = paramc.mZo;
            s.s(parami, "notifyInfo.msgList");
            localObject1 = (Iterable)parami;
            parami = (Collection)new ArrayList();
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              localObject3 = (cc)localObject2;
              if (((((fi)localObject3).jUq & 0x4) == 4) || (((cc)localObject3).getType() == 10000)) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label572;
                }
                parami.add(localObject2);
                break;
              }
            }
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f((List)parami, this));
          }
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g((List)paramc, this));
        AppMethodBeat.o(256186);
        return;
      }
      break label202;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/storage/MsgInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<cc, Boolean>
  {
    a(y paramy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/storage/MsgInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<cc, Boolean>
  {
    b(y paramy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.ui.n.a.b>
  {
    c(y paramy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/emoji/magicemoji/view/MEHolderView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MEHolderView>
  {
    d(y paramy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/EmojiEggComponent$onChattingEnterAnimEnd$1", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "onEnd", "", "onPlayScreenEffect", "msgId", "", "animKey", "", "config", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "onScreenEffect", "onStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements e.b
  {
    e(y paramy) {}
    
    public final void a(long paramLong, String paramString, b.a parama)
    {
      AppMethodBeat.i(256016);
      s.u(paramString, "animKey");
      s.u(parama, "config");
      String str = y.b(this.aerT);
      Object localObject2 = new StringBuilder("onPlayScreenEffect: msg:").append(paramLong).append(", ");
      Object localObject1 = parama.mfA;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", ");
        localObject1 = parama.mfA;
        if (localObject1 != null) {
          break label157;
        }
      }
      label157:
      for (localObject1 = null;; localObject1 = Integer.valueOf(((com.tencent.mm.emoji.a.b.b)localObject1).version))
      {
        Log.i(str, localObject1 + ", " + paramString + ' ' + parama.key);
        if (!y.c(this.aerT)) {
          break label170;
        }
        AppMethodBeat.o(256016);
        return;
        localObject1 = Integer.valueOf(((com.tencent.mm.emoji.a.b.b)localObject1).UZ);
        break;
      }
      label170:
      localObject1 = y.d(this.aerT);
      str = parama.key;
      s.u(paramString, "emojiId");
      s.u(str, "emojiKey");
      long l = System.currentTimeMillis();
      parama = ((com.tencent.mm.ui.n.a.b)localObject1).adCQ.cez();
      paramString = com.tencent.mm.ui.n.b.i.a(paramLong, paramString, str, true, ((com.tencent.mm.ui.n.a.b)localObject1).adCQ, (View)((com.tencent.mm.ui.n.a.b)localObject1).afwG);
      if (paramString == null) {}
      for (paramString = null;; paramString = new com.tencent.mm.ui.n.b.b(paramLong, l, parama, paramString))
      {
        if (paramString != null)
        {
          parama = (com.tencent.mm.plugin.emoji.magicemoji.a.b)h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class);
          localObject1 = new HashMap(16);
          ((Map)localObject1).put("msgId", Long.valueOf(paramString.msgId));
          ((Map)localObject1).put("scene", Integer.valueOf(1));
          ((Map)localObject1).put("msgMeta", paramString.afwQ.jBH());
          ((Map)localObject1).put("sentTime", Long.valueOf(paramString.afwP));
          str = paramString.hQR;
          localObject2 = paramString.afwQ.hHa;
          paramLong = paramString.afwP;
          paramString = new HashMap(2);
          paramString.put("sessionID", str);
          paramString.put("toChatName", localObject2);
          paramString.put("messageTimestamp", Long.valueOf(paramLong));
          ((Map)localObject1).put("reportInfo", paramString);
          com.tencent.luggage.l.d.k((Map)localObject1);
          paramString = new com.tencent.mm.ad.i((Map)localObject1).toString();
          s.s(paramString, "event.toJSONObjectString()");
          parama.be(4096, paramString);
        }
        AppMethodBeat.o(256016);
        return;
      }
    }
    
    public final void a(String paramString, b.a parama)
    {
      Object localObject = null;
      AppMethodBeat.i(256003);
      s.u(paramString, "animKey");
      s.u(parama, "config");
      String str = y.b(this.aerT);
      StringBuilder localStringBuilder = new StringBuilder("onScreenEffect: msg:");
      paramString = parama.mfA;
      if (paramString == null)
      {
        paramString = null;
        localStringBuilder = localStringBuilder.append(paramString).append(", ");
        paramString = parama.mfA;
        if (paramString != null) {
          break label115;
        }
      }
      label115:
      for (paramString = localObject;; paramString = Integer.valueOf(paramString.version))
      {
        Log.i(str, paramString);
        if (!y.c(this.aerT)) {
          break label126;
        }
        AppMethodBeat.o(256003);
        return;
        paramString = Integer.valueOf(paramString.UZ);
        break;
      }
      label126:
      y.d(this.aerT).prepare();
      AppMethodBeat.o(256003);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(List<? extends cc> paramList, y paramy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    g(List<? extends cc> paramList, y paramy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/storage/MsgInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.b<cc, Boolean>
  {
    h(y paramy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/EmojiEggComponent$viewProvider$1", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "getItemEmojiRect", "Landroid/graphics/RectF;", "msgId", "", "animKey", "", "getItemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "itemView", "Landroid/view/View;", "getMsgAnimKey", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getParentView", "getViewByMsgId", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements com.tencent.mm.emoji.a.a
  {
    i(y paramy) {}
    
    public final RectF b(long paramLong, String paramString)
    {
      AppMethodBeat.i(255993);
      s.u(paramString, "animKey");
      RectF localRectF = new RectF();
      Object localObject = ht(paramLong);
      if (localObject != null)
      {
        localObject = c((View)localObject, paramString);
        if (localObject != null) {
          break label119;
        }
        paramString = null;
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
        AppMethodBeat.o(255993);
        return localRectF;
        label119:
        paramString = ((MMNeat7extView)localObject).getLayout();
        break;
        label128:
        Log.i(y.b(this.aerT), "updateView: no layout");
      }
    }
    
    public final MMNeat7extView c(View paramView, String paramString)
    {
      AppMethodBeat.i(255978);
      s.u(paramView, "itemView");
      s.u(paramString, "animKey");
      if (kotlin.n.n.a((CharSequence)paramString, (CharSequence)"_", false))
      {
        paramView = (ViewGroup)paramView.findViewById(R.h.fTc);
        int i = Integer.parseInt((String)kotlin.n.n.a((CharSequence)paramString, new String[] { "_" }).get(1));
        if (paramView.getChildCount() > 0)
        {
          paramView = paramView.getChildAt(i);
          if ((paramView instanceof MMNeat7extView))
          {
            paramView = (MMNeat7extView)paramView;
            AppMethodBeat.o(255978);
            return paramView;
          }
          AppMethodBeat.o(255978);
          return null;
        }
      }
      else
      {
        paramView = (MMNeat7extView)paramView.findViewById(R.h.fxy);
        AppMethodBeat.o(255978);
        return paramView;
      }
      AppMethodBeat.o(255978);
      return null;
    }
    
    public final View ht(long paramLong)
    {
      AppMethodBeat.i(255974);
      View localView = ((m)this.aerT.hlc.cm(m.class)).ht(paramLong);
      AppMethodBeat.o(255974);
      return localView;
    }
    
    public final List<String> q(cc paramcc)
    {
      AppMethodBeat.i(255983);
      s.u(paramcc, "msg");
      LinkedList localLinkedList = new LinkedList();
      if (((Boolean)y.i(this.aerT).invoke(paramcc)).booleanValue())
      {
        Object localObject1 = f.mfZ;
        Object localObject2 = (Iterable)f.a.t(paramcc);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          ((Iterator)localObject2).next();
          if (i < 0) {
            p.kkW();
          }
          ((Collection)localObject1).add(paramcc.field_msgId + '_' + i);
          i += 1;
        }
        localLinkedList.addAll((Collection)localObject1);
      }
      for (;;)
      {
        paramcc = (List)localLinkedList;
        AppMethodBeat.o(255983);
        return paramcc;
        if (((Boolean)y.j(this.aerT).invoke(paramcc)).booleanValue()) {
          localLinkedList.add(String.valueOf(paramcc.field_msgId));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.y
 * JD-Core Version:    0.7.0.1
 */