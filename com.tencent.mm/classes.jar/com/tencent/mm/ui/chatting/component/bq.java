package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.translate.b.d;
import com.tencent.mm.plugin.translate.b.d.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.event.MvvmEventCenter.Companion;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.anim.content.AnimSizeRelativeLayout;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.bd;
import com.tencent.mm.ui.chatting.component.api.bd.a;
import com.tencent.mm.ui.chatting.component.api.bd.b;
import com.tencent.mm.ui.chatting.component.api.bd.c;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.util.b.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=bd.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent;", "()V", "callback", "Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$IOnTranslateResCallback;", "chooseLanFooterView", "Landroid/view/View;", "getChooseLanFooterView", "()Landroid/view/View;", "chooseLanFooterView$delegate", "Lkotlin/Lazy;", "chooseLanHalfDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "getChooseLanHalfDialog", "()Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "chooseLanHalfDialog$delegate", "chooseLanItemDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/component/LangItemData;", "Lkotlin/collections/ArrayList;", "getChooseLanItemDatas", "()Ljava/util/ArrayList;", "chooseLanItemDatas$delegate", "chooseLanRecycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getChooseLanRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "chooseLanRecycleView$delegate", "controllerView", "Lcom/tencent/mm/ui/chatting/component/TranslateControllerView;", "value", "Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$BarStatus;", "curStatus", "setCurStatus", "(Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$BarStatus;)V", "exposureCounter", "Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$ExposureCounter;", "keyboardHeight", "", "lastOriginText", "", "lastTransResult", "maxExposureCount", "msgListener", "com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$msgListener$1", "Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$msgListener$1;", "needInteruptChatFooterDown", "", "onChattingEndCallback", "Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$IOnChattingEndCallback;", "onStatusChangeListeners", "", "Lkotlin/Function2;", "", "previewTextView", "kotlin.jvm.PlatformType", "getPreviewTextView", "previewTextView$delegate", "resultTv", "Lcom/tencent/mm/ui/chatting/component/LoadableTextView;", "root", "Lcom/tencent/mm/ui/anim/content/AnimSizeRelativeLayout;", "showTipsCallback", "Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$TipNeedShowCallback;", "tasksInKeyboardHided", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "toSendEdt", "getToSendEdt", "toSendEdt$delegate", "transResultObserver", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "Lcom/tencent/mm/plugin/translate/event/TransResult;", "transTask", "transTaskPoster", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBtn", "Landroid/view/ViewGroup;", "checkNeedAutoCloseTrans", "checkNeedShowTipsAsync", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "createChooseLanHalfDialog", "createChooseLanRecyclerView", "createOriginLanItemData", "getCurLanCgiType", "getCurLanId", "getCurLanName", "getPrefix", "getSizeAnimController", "Lcom/tencent/mm/ui/anim/content/SizeAnimController;", "getTransMMKVName", "hideLanSwitchButtonSheet", "initControllerView", "initResultTv", "initRootView", "initUseLayout", "isEnSentence", "text", "isEnWord", "word", "isSystemLanCN", "isTranslating", "notifyStatusChange", "oldStatus", "newValue", "onChattingEnterAnimEnd", "onChattingExitAnimEnd", "onChattingInit", "onChattingResume", "onClickCloseTrans", "onClickUseTranslate", "onComponentInstall", "context", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onComponentUnInstall", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onConfirmChooseLan", "lanId", "onEdtContentChange", "onEdtContentSend", "onKeyboardHeightChange", "height", "onTranslateSuccess", "res", "realDoTransCgi", "registerStatusObserver", "onChange", "requestShowLanSwitchButtonSheet", "requestStartPreviewUI", "originText", "reset", "setCurLanId", "setDefaultLan", "setIOnChattingEndCallback", "setIfTipNeedShowCallback", "setOnTranslateResCallback", "setTranslating", "enable", "startPreviewUI", "switchLan", "itemId", "tryHideRoot", "tryHideWithoutDataChange", "tryShowRoot", "tryShowWithoutDataChange", "updateOriginText", "updateOriginTextInternal", "BarStatus", "Companion", "ExposureCounter", "IOnTranslateViewController", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bq
  extends a
  implements bd
{
  private static final Map<Integer, Integer> aeyL;
  private static final Map<Integer, String> aeyM;
  public static final bq.b aeyl;
  private String aeyA;
  private LinkedList<Runnable> aeyB;
  private boolean aeyC;
  private final MMHandler aeyD;
  private final Runnable aeyE;
  private final c aeyF;
  private final IMvvmObserver<com.tencent.mm.plugin.translate.a.b> aeyG;
  private final kotlin.j aeyH;
  private final kotlin.j aeyI;
  private final n aeyJ;
  private final int aeyK;
  private bd.b aeym;
  private bd.c aeyn;
  private bd.a aeyo;
  private AnimSizeRelativeLayout aeyp;
  private ViewGroup aeyq;
  private TranslateControllerView aeyr;
  private LoadableTextView aeys;
  private final kotlin.j aeyt;
  private final kotlin.j aeyu;
  private final kotlin.j aeyv;
  private final kotlin.j aeyw;
  private bq.a aeyx;
  private final List<m<bq.a, bq.a, ah>> aeyy;
  private String aeyz;
  private int sNb;
  
  static
  {
    AppMethodBeat.i(256528);
    aeyl = new bq.b((byte)0);
    aeyL = ak.e(new r[] { new r(Integer.valueOf(0), Integer.valueOf(R.l.gzT)), new r(Integer.valueOf(1), Integer.valueOf(R.l.gzU)), new r(Integer.valueOf(2), Integer.valueOf(R.l.gzP)), new r(Integer.valueOf(3), Integer.valueOf(R.l.gzQ)), new r(Integer.valueOf(4), Integer.valueOf(R.l.gzR)) });
    aeyM = ak.e(new r[] { new r(Integer.valueOf(0), "zh_CN"), new r(Integer.valueOf(1), "zh_TW"), new r(Integer.valueOf(2), "en"), new r(Integer.valueOf(3), "ja"), new r(Integer.valueOf(4), "ko") });
    AppMethodBeat.o(256528);
  }
  
  public bq()
  {
    AppMethodBeat.i(256364);
    this.aeyt = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.aeyu = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.aeyv = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.aeyw = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.aeyx = bq.a.aeyN;
    this.aeyy = ((List)new ArrayList());
    this.aeyz = "";
    this.aeyA = "";
    this.aeyB = new LinkedList();
    this.aeyD = new MMHandler(Looper.getMainLooper());
    this.aeyE = new bq..ExternalSyntheticLambda7(this);
    this.aeyF = new c();
    this.aeyG = new bq..ExternalSyntheticLambda3(this);
    this.aeyH = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.aeyI = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.aeyJ = new n(this);
    this.aeyK = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpS, 5);
    AppMethodBeat.o(256364);
  }
  
  private static final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, bq parambq)
  {
    AppMethodBeat.i(256468);
    s.u(parami, "$storage");
    s.u(parambq, "this$0");
    parami = parami.ka(parambq.hlc.getTalkerUserName(), 3);
    if (parami.size() < 3)
    {
      AppMethodBeat.o(256468);
      return;
    }
    s.s(parami, "storage.getLastMsg(mChat…          }\n            }");
    parami = ((Iterable)parami).iterator();
    while (parami.hasNext())
    {
      Object localObject = (cc)parami.next();
      if ((((fi)localObject).field_isSend == 1) && (((cc)localObject).iYl()))
      {
        localObject = ((fi)localObject).field_content;
        s.s(localObject, "it.content");
        if (bAY((String)localObject)) {
          break;
        }
      }
      else
      {
        AppMethodBeat.o(256468);
        return;
      }
    }
    com.tencent.threadpool.h.ahAA.bk(new bq..ExternalSyntheticLambda6(parambq));
    AppMethodBeat.o(256468);
  }
  
  private final void a(bq.a parama)
  {
    AppMethodBeat.i(256384);
    bq.a locala = this.aeyx;
    Log.i("MicroMsg.TranslateWhileWriteComponent", "notifyStatusChange() called with: oldStatus = " + locala + ", newValue = " + parama);
    Iterator localIterator = ((Iterable)this.aeyy).iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).invoke(locala, parama);
    }
    this.aeyx = parama;
    AppMethodBeat.o(256384);
  }
  
  private static final void a(bq parambq)
  {
    AppMethodBeat.i(256428);
    s.u(parambq, "this$0");
    Object localObject = parambq.aeyA;
    if (((CharSequence)localObject).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)parambq.juf()).length() != 0) {
          break label69;
        }
      }
    }
    label69:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label74;
      }
      AppMethodBeat.o(256428);
      return;
      i = 0;
      break;
    }
    label74:
    Log.i("TAG", "updateOriginTextInternal() called with: text = " + (String)localObject + " lastTransResult = " + parambq.aeyz + " lastOriginText = " + parambq.aeyA);
    parambq.bAZ((String)localObject);
    localObject = parambq.aeys;
    parambq = (bq)localObject;
    if (localObject == null)
    {
      s.bIx("resultTv");
      parambq = null;
    }
    parambq.setLoading(true);
    AppMethodBeat.o(256428);
  }
  
  private static final void a(bq parambq, View paramView)
  {
    AppMethodBeat.i(256435);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambq, "this$0");
    parambq.juc();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256435);
  }
  
  private static final void a(bq parambq, com.tencent.mm.plugin.translate.a.b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(256430);
    s.u(parambq, "this$0");
    s.u(paramb, "$it");
    String str = paramb.TSI;
    if (parambq.aeyx != bq.a.aeyN)
    {
      LoadableTextView localLoadableTextView = parambq.aeys;
      paramb = localLoadableTextView;
      if (localLoadableTextView == null)
      {
        s.bIx("resultTv");
        paramb = null;
      }
      paramb.setLoading(false);
      localLoadableTextView = parambq.aeys;
      paramb = localLoadableTextView;
      if (localLoadableTextView == null)
      {
        s.bIx("resultTv");
        paramb = null;
      }
      paramb.aCh(parambq.juo().getWidth());
      int i;
      if (!s.p(str, parambq.aeyA))
      {
        if (((CharSequence)str).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label181;
          }
        }
      }
      else
      {
        paramb = parambq.aeys;
        if (paramb != null) {
          break label178;
        }
        s.bIx("resultTv");
        paramb = localObject1;
      }
      label178:
      for (;;)
      {
        paramb.setText((CharSequence)"");
        parambq.a(bq.a.aeyN);
        AppMethodBeat.o(256430);
        return;
        i = 0;
        break;
      }
      label181:
      paramb = parambq.aeys;
      if (paramb != null) {
        break label222;
      }
      s.bIx("resultTv");
      paramb = localObject2;
    }
    label222:
    for (;;)
    {
      paramb.setOriginText((CharSequence)str);
      parambq.a(bq.a.aeyP);
      AppMethodBeat.o(256430);
      return;
    }
  }
  
  private final void aCo(int paramInt)
  {
    AppMethodBeat.i(256399);
    MultiProcessMMKV.getMMKV(jug()).putInt(this.hlc.getTalkerUserName(), paramInt);
    AppMethodBeat.o(256399);
  }
  
  private final void aCp(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(256416);
    int i = jue();
    aCo(paramInt);
    Object localObject1 = jtZ().getAdapter();
    if (localObject1 != null) {
      ((RecyclerView.a)localObject1).bZE.notifyChanged();
    }
    TranslateControllerView localTranslateControllerView = this.aeyr;
    localObject1 = localTranslateControllerView;
    if (localTranslateControllerView == null)
    {
      s.bIx("controllerView");
      localObject1 = null;
    }
    ((TranslateControllerView)localObject1).setLanguageText(jud());
    if ((i != paramInt) && (paramInt != -1))
    {
      if (((CharSequence)this.aeyA).length() <= 0) {
        break label144;
      }
      paramInt = 1;
      if (paramInt != 0)
      {
        localObject1 = this.aeys;
        if (localObject1 != null) {
          break label149;
        }
        s.bIx("resultTv");
        localObject1 = localObject2;
      }
    }
    label144:
    label149:
    for (;;)
    {
      ((LoadableTextView)localObject1).setLoading(true);
      a(bq.a.aeyO);
      bAZ(this.aeyA);
      AppMethodBeat.o(256416);
      return;
      paramInt = 0;
      break;
    }
  }
  
  private static final void b(bq parambq)
  {
    AppMethodBeat.i(256445);
    s.u(parambq, "this$0");
    parambq.aeyC = false;
    ((x)parambq.hlc.cm(x.class)).jsd().setIgnoreScroll(Boolean.FALSE);
    AppMethodBeat.o(256445);
  }
  
  private static final void b(bq parambq, View paramView)
  {
    AppMethodBeat.i(256440);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambq, "this$0");
    paramView = parambq.jtZ().getAdapter();
    if (paramView != null) {
      paramView.bZE.notifyChanged();
    }
    if (parambq.sNb > 0)
    {
      ((x)parambq.hlc.cm(x.class)).jsd().hideVKB();
      parambq.aeyB.add(new bq..ExternalSyntheticLambda5(parambq));
    }
    for (;;)
    {
      paramView = com.tencent.mm.plugin.translate.b.c.TSK;
      parambq = parambq.hlc.getTalkerUserName();
      s.s(parambq, "mChattingContext.talkerUserName");
      com.tencent.mm.plugin.translate.b.c.beM(parambq);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256440);
      return;
      parambq.jub().dDn();
    }
  }
  
  private static final void b(bq parambq, com.tencent.mm.plugin.translate.a.b paramb)
  {
    AppMethodBeat.i(256432);
    s.u(parambq, "this$0");
    s.u(paramb, "it");
    com.tencent.threadpool.h.ahAA.bk(new bq..ExternalSyntheticLambda9(parambq, paramb));
    AppMethodBeat.o(256432);
  }
  
  private static boolean bAY(String paramString)
  {
    AppMethodBeat.i(256420);
    paramString = ((Iterable)kotlin.n.n.a((CharSequence)kotlin.n.n.m(kotlin.n.n.m(paramString, "\n", " ", false), "\r", " ", false), new String[] { " " })).iterator();
    int i = 0;
    label139:
    label281:
    while (paramString.hasNext())
    {
      Object localObject = (String)paramString.next();
      char[] arrayOfChar = "-/:'()$&@\",.?!'：；（）¥，。、？！“”‘’".toCharArray();
      s.s(arrayOfChar, "(this as java.lang.String).toCharArray()");
      localObject = (CharSequence)localObject;
      int k = 0;
      int m = 0;
      if (k < ((CharSequence)localObject).length())
      {
        char c = ((CharSequence)localObject).charAt(k);
        label157:
        int n;
        if ('a' <= c) {
          if (c <= 'z')
          {
            j = 1;
            if (j == 0)
            {
              if ('A' > c) {
                break label195;
              }
              if (c > 'Z') {
                break label190;
              }
              j = 1;
              if (j == 0) {
                break label200;
              }
            }
            n = m + 1;
          }
        }
        label190:
        label195:
        label200:
        do
        {
          do
          {
            k += 1;
            m = n;
            break;
            j = 0;
            break label139;
            j = 0;
            break label139;
            j = 0;
            break label157;
            j = 0;
            break label157;
            n = m;
          } while (kotlin.a.k.contains(arrayOfChar, c));
          if ('0' > c) {
            break label265;
          }
          if (c > '9') {
            break label260;
          }
          j = 1;
          n = m;
        } while (j != 0);
      }
      label235:
      for (int j = 0;; j = 1)
      {
        if (j == 0) {
          break label281;
        }
        j = i + 1;
        i = j;
        if (j < 2) {
          break label281;
        }
        AppMethodBeat.o(256420);
        return true;
        j = 0;
        break;
        j = 0;
        break;
        if (m < 2) {
          break label235;
        }
      }
    }
    label260:
    label265:
    AppMethodBeat.o(256420);
    return false;
  }
  
  private final void bAZ(String paramString)
  {
    AppMethodBeat.i(256423);
    if (this.hlc.juF())
    {
      localObject1 = d.TSM;
      localObject1 = d.a.hPv();
      localObject2 = d.TSM;
      i = d.a.hPw();
      localObject2 = juf();
      str = this.hlc.getTalkerUserName();
      s.s(str, "mChattingContext.talkerUserName");
      ((d)localObject1).i(i, (String)localObject2, str, getPrefix(), paramString);
      AppMethodBeat.o(256423);
      return;
    }
    Object localObject1 = d.TSM;
    localObject1 = d.a.hPv();
    Object localObject2 = d.TSM;
    int i = d.a.hPw();
    localObject2 = juf();
    String str = this.hlc.getTalkerUserName();
    s.s(str, "mChattingContext.talkerUserName");
    ((d)localObject1).h(i, (String)localObject2, str, getPrefix(), paramString);
    AppMethodBeat.o(256423);
  }
  
  private static final void c(bq parambq)
  {
    AppMethodBeat.i(256449);
    s.u(parambq, "this$0");
    parambq.jub().dDn();
    AppMethodBeat.o(256449);
  }
  
  private static final void c(bq parambq, View paramView)
  {
    AppMethodBeat.i(256454);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambq, "this$0");
    parambq.jun();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256454);
  }
  
  private static final void d(bq parambq)
  {
    AppMethodBeat.i(256460);
    s.u(parambq, "this$0");
    if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adhV, false))
    {
      AppMethodBeat.o(256460);
      return;
    }
    parambq = parambq.aeyn;
    if (parambq != null) {
      parambq.callback();
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhV, Boolean.TRUE);
    AppMethodBeat.o(256460);
  }
  
  private final String getPrefix()
  {
    AppMethodBeat.i(256392);
    if (this.aeyA.length() < this.aeyz.length())
    {
      AppMethodBeat.o(256392);
      return "";
    }
    if (!kotlin.n.n.a((CharSequence)this.aeyA, (CharSequence)this.aeyz, false))
    {
      AppMethodBeat.o(256392);
      return "";
    }
    String str = this.aeyz;
    AppMethodBeat.o(256392);
    return str;
  }
  
  private final WxRecyclerView jtZ()
  {
    AppMethodBeat.i(256369);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.aeyt.getValue();
    AppMethodBeat.o(256369);
    return localWxRecyclerView;
  }
  
  private final View jua()
  {
    AppMethodBeat.i(256373);
    Object localObject = this.aeyu.getValue();
    s.s(localObject, "<get-chooseLanFooterView>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(256373);
    return localObject;
  }
  
  private final com.tencent.mm.ui.widget.a.j jub()
  {
    AppMethodBeat.i(256377);
    com.tencent.mm.ui.widget.a.j localj = (com.tencent.mm.ui.widget.a.j)this.aeyv.getValue();
    AppMethodBeat.o(256377);
    return localj;
  }
  
  private final void juc()
  {
    Object localObject2 = null;
    AppMethodBeat.i(256388);
    Object localObject1 = com.tencent.mm.plugin.translate.b.c.TSK;
    Object localObject4 = this.hlc.getTalkerUserName();
    s.s(localObject4, "mChattingContext.talkerUserName");
    int i = this.aeyA.length();
    Object localObject3 = this.aeys;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("resultTv");
      localObject1 = null;
    }
    com.tencent.mm.plugin.translate.b.c.o((String)localObject4, i, ((LoadableTextView)localObject1).getText().toString().length(), juf());
    localObject4 = this.aeym;
    if (localObject4 != null)
    {
      localObject3 = this.aeys;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("resultTv");
        localObject1 = null;
      }
      localObject1 = ((LoadableTextView)localObject1).getText().toString();
      this.aeyz = ((String)localObject1);
      localObject3 = ah.aiuX;
      ((bd.b)localObject4).aal((String)localObject1);
    }
    this.aeyF.bBc("useTrans");
    a(bq.a.aeyN);
    localObject1 = this.aeys;
    if (localObject1 == null)
    {
      s.bIx("resultTv");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((LoadableTextView)localObject1).setOriginText((CharSequence)"");
      AppMethodBeat.o(256388);
      return;
    }
  }
  
  private final String jud()
  {
    AppMethodBeat.i(256395);
    for (;;)
    {
      try
      {
        if (jue() == -1)
        {
          AppMethodBeat.o(256395);
          return "";
        }
        localObject1 = this.hlc.aezO.getContext();
        localInteger = (Integer)aeyL.get(Integer.valueOf(jue()));
        if (localInteger != null) {
          continue;
        }
        i = 0;
        localObject1 = ((Activity)localObject1).getString(i);
        s.s(localObject1, "{\n            if (getCur…rLanId()] ?: 0)\n        }");
      }
      finally
      {
        Object localObject1;
        Integer localInteger;
        int i;
        String str = "";
        continue;
      }
      AppMethodBeat.o(256395);
      return localObject1;
      i = localInteger.intValue();
    }
  }
  
  private final int jue()
  {
    AppMethodBeat.i(256397);
    if (MultiProcessMMKV.getMMKV(jug()).containsKey(this.hlc.getTalkerUserName()))
    {
      int i = MultiProcessMMKV.getMMKV(jug()).getInt(this.hlc.getTalkerUserName(), -1);
      AppMethodBeat.o(256397);
      return i;
    }
    MultiProcessMMKV.getMMKV(jug()).putInt(this.hlc.getTalkerUserName(), -1);
    AppMethodBeat.o(256397);
    return -1;
  }
  
  private final String juf()
  {
    AppMethodBeat.i(256402);
    String str = (String)aeyM.get(Integer.valueOf(jue()));
    if (str == null)
    {
      AppMethodBeat.o(256402);
      return "";
    }
    AppMethodBeat.o(256402);
    return str;
  }
  
  private static String jug()
  {
    AppMethodBeat.i(256404);
    com.tencent.mm.kernel.h.baC();
    String str = s.X(com.tencent.mm.kernel.b.aZs(), "TransInWriting");
    AppMethodBeat.o(256404);
    return str;
  }
  
  private final void juh()
  {
    AppMethodBeat.i(256407);
    Log.i("MicroMsg.TranslateWhileWriteComponent", "tryShowRoot(): Translate While Write try show root");
    com.tencent.mm.plugin.translate.b.c localc = com.tencent.mm.plugin.translate.b.c.TSK;
    com.tencent.mm.plugin.translate.b.c.hPs();
    if (jue() == -1) {
      jui();
    }
    if (((CharSequence)this.aeyA).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        a(bq.a.aeyN);
      }
      jum();
      AppMethodBeat.o(256407);
      return;
    }
  }
  
  private final void jui()
  {
    AppMethodBeat.i(256410);
    if (juj())
    {
      aCp(2);
      AppMethodBeat.o(256410);
      return;
    }
    aCp(0);
    AppMethodBeat.o(256410);
  }
  
  private static boolean juj()
  {
    AppMethodBeat.i(256411);
    if ((s.p(WeChatBrands.AppInfo.lang, "CN")) || (s.p(WeChatBrands.AppInfo.lang, "HK")) || (s.p(WeChatBrands.AppInfo.lang, "TW")))
    {
      AppMethodBeat.o(256411);
      return true;
    }
    AppMethodBeat.o(256411);
    return false;
  }
  
  private final void juk()
  {
    AppMethodBeat.i(256413);
    Log.d("MicroMsg.TranslateWhileWriteComponent", "tryHideRoot() called");
    a(bq.a.aeyN);
    jul();
    AppMethodBeat.o(256413);
  }
  
  private final void jun()
  {
    AppMethodBeat.i(256415);
    jub().cyW();
    aCp(-1);
    Object localObject = com.tencent.mm.plugin.translate.b.c.TSK;
    localObject = this.hlc.getTalkerUserName();
    s.s(localObject, "mChattingContext.talkerUserName");
    com.tencent.mm.plugin.translate.b.c.beN((String)localObject);
    juk();
    AppMethodBeat.o(256415);
  }
  
  private final View juo()
  {
    AppMethodBeat.i(256426);
    View localView = (View)this.aeyI.getValue();
    AppMethodBeat.o(256426);
    return localView;
  }
  
  private final void u(m<? super bq.a, ? super bq.a, ah> paramm)
  {
    AppMethodBeat.i(256387);
    this.aeyy.add(paramm);
    AppMethodBeat.o(256387);
  }
  
  public final void Md(boolean paramBoolean)
  {
    AppMethodBeat.i(256628);
    Log.i("MicroMsg.TranslateWhileWriteComponent", s.X("setTranslating() called with: enable = ", Boolean.valueOf(paramBoolean)));
    int i;
    if (paramBoolean) {
      if (((CharSequence)this.aeyA).length() == 0)
      {
        i = 1;
        if (i != 0) {
          a(bq.a.aeyN);
        }
        juh();
      }
    }
    for (;;)
    {
      this.aeyF.bBc("useTrans");
      AppMethodBeat.o(256628);
      return;
      i = 0;
      break;
      aCp(-1);
      juk();
    }
  }
  
  public final void a(bd.a parama)
  {
    this.aeyo = parama;
  }
  
  public final void a(bd.b paramb)
  {
    AppMethodBeat.i(256603);
    s.u(paramb, "callback");
    this.aeym = paramb;
    AppMethodBeat.o(256603);
  }
  
  public final void a(bd.c paramc)
  {
    AppMethodBeat.i(256605);
    s.u(paramc, "callback");
    this.aeyn = paramc;
    AppMethodBeat.o(256605);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(256583);
    super.a(parama);
    parama = (com.tencent.mm.plugin.translate.a.a)MvvmEventCenter.Companion.getEvent(com.tencent.mm.plugin.translate.a.a.class);
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.h.baC().mBP;
    s.s(locala, "account().accountModelOwner");
    parama.observe((q)locala, this.aeyG);
    AppMethodBeat.o(256583);
  }
  
  public final void aCq(int paramInt)
  {
    AppMethodBeat.i(256608);
    this.sNb = paramInt;
    if (paramInt == 0)
    {
      if (!((Collection)this.aeyB).isEmpty()) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label59;
        }
        ((Runnable)this.aeyB.removeLast()).run();
        break;
      }
    }
    label59:
    AppMethodBeat.o(256608);
  }
  
  public final void bAW(String paramString)
  {
    AppMethodBeat.i(256610);
    s.u(paramString, "text");
    int i;
    if (!s.p(paramString, this.aeyA))
    {
      if (((CharSequence)paramString).length() != 0) {
        break label99;
      }
      i = 1;
      if (i == 0) {
        break label107;
      }
      a(bq.a.aeyN);
      this.aeyD.removeCallbacks(this.aeyE);
      LoadableTextView localLoadableTextView = this.aeys;
      if (localLoadableTextView != null) {
        break label104;
      }
      s.bIx("resultTv");
      localLoadableTextView = null;
      label77:
      localLoadableTextView.setOriginText((CharSequence)"");
    }
    for (;;)
    {
      this.aeyA = paramString;
      AppMethodBeat.o(256610);
      return;
      label99:
      i = 0;
      break;
      label104:
      break label77;
      label107:
      if ((!s.p(paramString, this.aeyz)) && (jue() != -1))
      {
        a(bq.a.aeyO);
        this.aeyD.removeCallbacks(this.aeyE);
        this.aeyD.postDelayed(this.aeyE, 300L);
      }
    }
  }
  
  public final void bAX(String paramString)
  {
    AppMethodBeat.i(256614);
    s.u(paramString, "text");
    if (jsr())
    {
      Object localObject = com.tencent.mm.plugin.translate.b.c.TSK;
      localObject = this.hlc.getTalkerUserName();
      s.s(localObject, "mChattingContext.talkerUserName");
      com.tencent.mm.plugin.translate.b.c.p((String)localObject, paramString.length(), this.aeyz.length(), juf());
      this.aeyz = "";
    }
    AppMethodBeat.o(256614);
  }
  
  public final com.tencent.mm.ui.anim.content.c getSizeAnimController()
  {
    AppMethodBeat.i(256579);
    AnimSizeRelativeLayout localAnimSizeRelativeLayout = this.aeyp;
    Object localObject = localAnimSizeRelativeLayout;
    if (localAnimSizeRelativeLayout == null)
    {
      s.bIx("root");
      localObject = null;
    }
    localObject = ((AnimSizeRelativeLayout)localObject).getSizeAnimController();
    AppMethodBeat.o(256579);
    return localObject;
  }
  
  public final void jjf()
  {
    Object localObject2 = null;
    AppMethodBeat.i(256578);
    this.aeyy.clear();
    Log.i("MicroMsg.TranslateWhileWriteComponent", "initRootView(): Translate While Write init root view");
    Object localObject1 = this.hlc.findViewById(R.h.fxW);
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.anim.content.AnimSizeRelativeLayout");
      AppMethodBeat.o(256578);
      throw ((Throwable)localObject1);
    }
    this.aeyp = ((AnimSizeRelativeLayout)localObject1);
    if (jsr()) {
      juh();
    }
    for (;;)
    {
      localObject1 = this.hlc.findViewById(R.h.fxT);
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.component.TranslateControllerView");
      AppMethodBeat.o(256578);
      throw ((Throwable)localObject1);
      juk();
    }
    this.aeyr = ((TranslateControllerView)localObject1);
    Object localObject3 = this.aeyr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("controllerView");
      localObject1 = null;
    }
    ((TranslateControllerView)localObject1).setOnClickListener(new bq..ExternalSyntheticLambda2(this));
    localObject3 = this.aeyr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("controllerView");
      localObject1 = null;
    }
    ((TranslateControllerView)localObject1).setLanguageText(jud());
    u((m)new j(this));
    localObject1 = this.hlc.findViewById(R.h.fxV);
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.component.LoadableTextView");
      AppMethodBeat.o(256578);
      throw ((Throwable)localObject1);
    }
    this.aeys = ((LoadableTextView)localObject1);
    localObject3 = this.aeys;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("resultTv");
      localObject1 = null;
    }
    ((LoadableTextView)localObject1).setVisibility(8);
    localObject1 = this.aeys;
    if (localObject1 == null)
    {
      s.bIx("resultTv");
      localObject1 = null;
    }
    for (;;)
    {
      ((LoadableTextView)localObject1).setOnDoubleClickListener((m)new k(this));
      u((m)new l(this));
      localObject1 = com.tencent.mm.util.i.agtt;
      int i = com.tencent.mm.util.i.a(b.a.agqI, 1);
      if (i > 1)
      {
        localObject3 = this.aeys;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("resultTv");
          localObject1 = null;
        }
        ((LoadableTextView)localObject1).setSingleLine(false);
        localObject3 = this.aeys;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("resultTv");
          localObject1 = null;
        }
        ((LoadableTextView)localObject1).setMaxLines(i);
      }
      localObject1 = this.hlc.findViewById(R.h.fxX);
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(256578);
      throw ((Throwable)localObject1);
    }
    this.aeyq = ((ViewGroup)localObject1);
    localObject3 = this.aeyq;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("useBtn");
      localObject1 = null;
    }
    final TextView localTextView = (TextView)((ViewGroup)localObject1).findViewById(R.h.fxZ);
    localObject3 = this.aeyq;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("useBtn");
      localObject1 = null;
    }
    final WeImageView localWeImageView = (WeImageView)((ViewGroup)localObject1).findViewById(R.h.fxY);
    localObject3 = this.aeyq;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("useBtn");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setVisibility(8);
    localObject1 = this.aeyq;
    if (localObject1 == null)
    {
      s.bIx("useBtn");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ViewGroup)localObject1).setOnClickListener(new bq..ExternalSyntheticLambda0(this));
      u((m)new m(this, localTextView, localWeImageView));
      AppMethodBeat.o(256578);
      return;
    }
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(256632);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a((i.a)this.aeyJ, Looper.getMainLooper());
    AppMethodBeat.o(256632);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(256593);
    super.jji();
    AnimSizeRelativeLayout localAnimSizeRelativeLayout2 = this.aeyp;
    AnimSizeRelativeLayout localAnimSizeRelativeLayout1 = localAnimSizeRelativeLayout2;
    if (localAnimSizeRelativeLayout2 == null)
    {
      s.bIx("root");
      localAnimSizeRelativeLayout1 = null;
    }
    localAnimSizeRelativeLayout1.postDelayed(new bq..ExternalSyntheticLambda8(this), 500L);
    AppMethodBeat.o(256593);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256636);
    if (this.aeyF.bBd("useTrans") >= this.aeyK) {
      aCp(-1);
    }
    bd.a locala = this.aeyo;
    if (locala != null) {
      locala.callback();
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a((i.a)this.aeyJ);
    AppMethodBeat.o(256636);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(256586);
    super.jqF();
    ((com.tencent.mm.plugin.translate.a.a)MvvmEventCenter.Companion.getEvent(com.tencent.mm.plugin.translate.a.a.class)).removeObserver(this.aeyG);
    AppMethodBeat.o(256586);
  }
  
  public final boolean jsr()
  {
    AppMethodBeat.i(256619);
    if (jue() != -1)
    {
      AppMethodBeat.o(256619);
      return true;
    }
    AppMethodBeat.o(256619);
    return false;
  }
  
  public final void jul()
  {
    AppMethodBeat.i(256596);
    AnimSizeRelativeLayout localAnimSizeRelativeLayout2 = this.aeyp;
    AnimSizeRelativeLayout localAnimSizeRelativeLayout1 = localAnimSizeRelativeLayout2;
    if (localAnimSizeRelativeLayout2 == null)
    {
      s.bIx("root");
      localAnimSizeRelativeLayout1 = null;
    }
    localAnimSizeRelativeLayout1.getSizeAnimController().jlD();
    AppMethodBeat.o(256596);
  }
  
  public final void jum()
  {
    AppMethodBeat.i(256600);
    if (jue() == -1)
    {
      AppMethodBeat.o(256600);
      return;
    }
    AnimSizeRelativeLayout localAnimSizeRelativeLayout2 = this.aeyp;
    AnimSizeRelativeLayout localAnimSizeRelativeLayout1 = localAnimSizeRelativeLayout2;
    if (localAnimSizeRelativeLayout2 == null)
    {
      s.bIx("root");
      localAnimSizeRelativeLayout1 = null;
    }
    localAnimSizeRelativeLayout1.getSizeAnimController().jlE();
    AppMethodBeat.o(256600);
  }
  
  public final boolean jup()
  {
    AppMethodBeat.i(256623);
    Log.i("MicroMsg.TranslateWhileWriteComponent", "needInteruptChatFooterDown:" + this.aeyC + ' ');
    boolean bool = this.aeyC;
    AppMethodBeat.o(256623);
    return bool;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(256638);
    super.onConfigurationChanged(paramConfiguration);
    LoadableTextView localLoadableTextView = this.aeys;
    paramConfiguration = localLoadableTextView;
    if (localLoadableTextView == null)
    {
      s.bIx("resultTv");
      paramConfiguration = null;
    }
    paramConfiguration.aCh(juo().getWidth());
    AppMethodBeat.o(256638);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$ExposureCounter;", "", "(Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent;)V", "createInnerKey", "", "key", "exposure", "", "getCount", "", "resetExposure", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
  {
    public c()
    {
      AppMethodBeat.i(255877);
      AppMethodBeat.o(255877);
    }
    
    private final String bBe(String paramString)
    {
      AppMethodBeat.i(255881);
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      paramString = com.tencent.mm.kernel.b.getUin() + '_' + this.aeyR.hlc.getTalkerUserName() + '_' + paramString;
      AppMethodBeat.o(255881);
      return paramString;
    }
    
    public final void bBb(String paramString)
    {
      AppMethodBeat.i(255884);
      s.u(paramString, "key");
      MultiProcessMMKV.getMMKV(bq.juq()).putInt(bBe(paramString), bBd(paramString) + 1);
      AppMethodBeat.o(255884);
    }
    
    public final void bBc(String paramString)
    {
      AppMethodBeat.i(255888);
      s.u(paramString, "key");
      MultiProcessMMKV.getMMKV(bq.juq()).putInt(bBe(paramString), 0);
      AppMethodBeat.o(255888);
    }
    
    public final int bBd(String paramString)
    {
      AppMethodBeat.i(255891);
      s.u(paramString, "key");
      int i = MultiProcessMMKV.getMMKV(bq.juq()).getInt(bBe(paramString), 0);
      AppMethodBeat.o(255891);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$IOnTranslateViewController;", "", "isTranslating", "", "onEdtContentChange", "", "text", "", "setTranslateEnable", "enable", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void LY(boolean paramBoolean);
    
    public abstract boolean jsr();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(bq parambq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<com.tencent.mm.ui.widget.a.j>
  {
    f(bq parambq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/component/LangItemData;", "Lkotlin/collections/ArrayList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ArrayList<an>>
  {
    g(bq parambq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    h(bq parambq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$createChooseLanRecyclerView$1$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/ui/chatting/component/LangItemData;", "type", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements g
  {
    i(bq parambq) {}
    
    public final com.tencent.mm.view.recyclerview.f<an> yF(int paramInt)
    {
      AppMethodBeat.i(255964);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this.aeyR);
      AppMethodBeat.o(255964);
      return localf;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$createChooseLanRecyclerView$1$1$getItemConvert$1", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/ui/chatting/component/LangItemData;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends com.tencent.mm.view.recyclerview.f<an>
    {
      a(bq parambq) {}
      
      private static final void a(bq parambq, an paraman, View paramView)
      {
        AppMethodBeat.i(256150);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(parambq);
        localb.cH(paraman);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$createChooseLanRecyclerView$1$1$getItemConvert$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(parambq, "this$0");
        s.u(paraman, "$item");
        bq.a(parambq, paraman.aeuB);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$createChooseLanRecyclerView$1$1$getItemConvert$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256150);
      }
      
      public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
      {
        AppMethodBeat.i(256168);
        s.u(paramRecyclerView, "recyclerView");
        s.u(paramj, "holder");
        AppMethodBeat.o(256168);
      }
      
      public final int getLayoutId()
      {
        return R.i.gfb;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "oldStatus", "Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$BarStatus;", "newStatus"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements m<bq.a, bq.a, ah>
  {
    j(bq parambq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements m<View, MotionEvent, Boolean>
  {
    k(bq parambq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "oldStatus", "Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$BarStatus;", "newStatus"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements m<bq.a, bq.a, ah>
  {
    l(bq parambq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "oldStatus", "Lcom/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$BarStatus;", "newStatus"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements m<bq.a, bq.a, ah>
  {
    m(bq parambq, TextView paramTextView, WeImageView paramWeImageView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/TranslateWhileWriteComponent$msgListener$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$IOnMsgChange;", "onNotifyChange", "", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "info", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements i.a
  {
    n(bq parambq) {}
    
    public final void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
    {
      AppMethodBeat.i(255951);
      s.u(parami, "storage");
      s.u(paramc, "info");
      paramc = paramc.mZo;
      s.s(paramc, "info.msgList");
      Object localObject1 = (Iterable)paramc;
      paramc = this.aeyR;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (cc)((Iterator)localObject1).next();
        if ((((fi)localObject2).field_isSend == 1) && (((cc)localObject2).iYl()))
        {
          localObject2 = ((fi)localObject2).field_content;
          s.s(localObject2, "it.content");
          if ((bq.bBa((String)localObject2)) && (bq.jus())) {
            bq.a(paramc, parami);
          }
        }
      }
      AppMethodBeat.o(255951);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<View>
  {
    o(bq parambq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<View>
  {
    p(bq parambq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bq
 * JD-Core Version:    0.7.0.1
 */