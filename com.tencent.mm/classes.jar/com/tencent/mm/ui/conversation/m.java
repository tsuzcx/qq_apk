package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.db;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ac.b.a;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.conversation.banner.e;
import com.tencent.mm.ui.conversation.banner.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/FolderHelper;", "Lcom/tencent/mm/model/IOnUserStatusChange;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$IOnMsgChange;", "()V", "ANIMATION_COLLAPSE_DURATION", "", "ANIMATION_EXPAND_DURATION", "LISTVIEW_CONTENT_BUTTOM_HEIGHT", "", "LISTVIEW_CONTENT_HEIGHT", "LISTVIEW_CONTENT_START_HEIGHT", "LIST_FOLD_ITEM_HEIGHT", "LIST_ITEM_HEIGHT", "SCROLL_DURATION", "TOOLBAR_HEIGHT", "adapter", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter;", "banner", "Lcom/tencent/mm/pluginsdk/ui/banner/BaseBanner;", "buttomBannerContainer", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "convBoxEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConvBoxEvent;", "conversationLV", "Lcom/tencent/mm/ui/conversation/ConversationListView;", "foldBtnTipsView", "Landroid/widget/TextView;", "foldBtnView", "Landroid/view/View;", "foldLimitNum", "foldLimitRate", "", "foldShowMode", "foldTargetHeight", "inCollapseAnim", "", "isCollapseAnimDone", "isCollapseStatus", "()Z", "isExpandStatus", "isTabResume", "lastClickTime", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastTotalCount", "mFoldViewAnimator", "Lcom/tencent/mm/ui/conversation/fold/animation/FoldViewAnimator;", "mFoldedCount", "mFoldedTempCount", "mFoldedUpdateMaxCount", "mFromClick", "mInited", "oneScreenCount", "animateViewIfNecessary", "", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "viewHolder", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter$ViewHolder;", "conv", "Lcom/tencent/mm/storage/Conversation;", "calcAndUpdateFoldFlag", "forceMarkFold", "forceMarkUnFold", "calcFoldFlag", "calcParams", "height", "calcNavigation", "checkConvIfHide", "checkConvIfShow", "username", "", "isInterestMsg", "checkFoldBannerScrollShow", "checkFoldBannerVisible", "visible", "needUpdateCount", "checkFoldItemAndBannerStatus", "isCollapse", "topFoldItemCount", "checkIfDelFoldItem", "Lkotlin/Pair;", "checkIfShowFoldBanner", "checkIfShowFoldItem", "forceShowBanner", "concatAnimators", "", "Landroid/animation/Animator;", "childAnimators", "animators", "alphaAnimator", "([Landroid/animation/Animator;[Landroid/animation/Animator;Landroid/animation/Animator;)[Landroid/animation/Animator;", "configParams", "correctFoldItemStatus", "dealFoldFlag", "dealMsg", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isNewMsg", "dealPatMsg", "msgInfo", "talker", "delFoldItemConversation", "findConversation", "findConversationExist", "findFoldBtnViewHolder", "foldModeSw", "getAllConvs", "", "getAllPlaceTopConvs", "", "getExpandAnimators", "(Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter$ViewHolder;Lcom/tencent/mm/storage/Conversation;)[Landroid/animation/Animator;", "getFoldedCount", "getFoldedTempCount", "getTargetHeight", "getTotalConversationsWithFold", "handleTranslationY", "transY", "forceTrans", "ifShow", "topSize", "inAnimation", "initAnimator", "initBanner", "insertFoldItemConversation", "isExpandAnim", "isNewPatMsg", "onCustomConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitView", "onNotifyChange", "msgstg", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "event", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onNotifyUserStatusChange", "onPreInit", "onSizeChanged", "w", "h", "oldw", "oldh", "onTabDestroy", "onTabPause", "onTabResume", "performAllCollapse", "foldBtnViewHolder", "performAllExpand", "performFoldItemClick", "performFoldItemToTop", "performItemCollapse", "action", "Lcom/tencent/mm/ui/conversation/FolderHelper$FoldCustomAction;", "startFooterHeight", "extraFooterHeight", "postPerformFoldItemToTop", "resetAllFoldConvUser", "findFoldFlags", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setFoldFlags", "parentRef", "setFoldFlag", "smoothScrollFoldBtnToTop", "delay", "totalFoldedCount", "updateAllFoldFlag", "isExpand", "updateFoldFlag", "updateFoldFlagAndRef", "foldFlag", "updateFoldStatus", "topFoldCount", "updateFolder", "Companion", "FoldCustomAction", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class m
  implements com.tencent.mm.model.bd, i.a, MStorageEx.IOnStorageChange
{
  public static final m.a afpo;
  boolean aflZ;
  k afnq;
  TextView afoS;
  int afos;
  int afot;
  private int afpA;
  boolean afpB;
  int afpC;
  int afpD;
  private int afpE;
  boolean afpF;
  private boolean afpG;
  com.tencent.mm.ui.conversation.fold.a.b afpH;
  final IListener<db> afpI;
  private int afpJ;
  private float afpK;
  private int afpL;
  int afpM;
  ConversationListView afpp;
  LinearLayout afpq;
  View afpr;
  private int afps;
  private int afpt;
  private int afpu;
  int afpv;
  private final long afpw;
  private final long afpx;
  private final long afpy;
  int afpz;
  Context context;
  com.tencent.mm.pluginsdk.ui.a.b hAo;
  private long lastClickTime;
  private boolean mInited;
  
  static
  {
    AppMethodBeat.i(257134);
    afpo = new m.a((byte)0);
    AppMethodBeat.o(257134);
  }
  
  public m()
  {
    AppMethodBeat.i(256899);
    this.afpw = 300L;
    this.afpx = 250L;
    this.afpy = 100L;
    this.afpA = -1;
    this.afpE = 50;
    this.afpI = ((IListener)new FolderHelper.convBoxEventListener.1(this, com.tencent.mm.app.f.hfK));
    this.afpJ = -1;
    this.afpK = -1.0F;
    this.afpL = -1;
    this.afpM = -1;
    AppMethodBeat.o(256899);
  }
  
  private final boolean MJ(boolean paramBoolean)
  {
    AppMethodBeat.i(256974);
    if (bCf("message_fold") != null) {}
    for (boolean bool2 = true; (!paramBoolean) && (bool2); bool2 = false)
    {
      AppMethodBeat.o(256974);
      return false;
    }
    Object localObject1 = this.afnq;
    int i;
    boolean bool1;
    if (localObject1 == null)
    {
      i = 0;
      if ((bool2) && (!paramBoolean)) {
        break label342;
      }
      bool1 = true;
      label67:
      if (bool1) {
        break label348;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    }
    for (;;)
    {
      localObject1 = new StringBuilder("checkIfShowFoldItem, ifShow:").append(bool1).append(", existFoldItem:").append(bool2).append(", topSize:").append(i).append(", forceShowBanner:").append(paramBoolean).append(", isCollapse:");
      Object localObject2 = com.tencent.mm.storage.b.a.admS;
      Log.i("MicroMsg.FolderHelper", com.tencent.mm.storage.b.a.jdN());
      AppMethodBeat.o(256974);
      return bool1;
      localObject1 = ((k)localObject1).jhT();
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      localObject1 = ((HashMap)localObject1).values();
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label326:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        bb localbb = (bb)localObject3;
        if (by.adkm.contains(Integer.valueOf(localbb.adis)))
        {
          bh.bCz();
          if ((!com.tencent.mm.model.c.bzG().k(localbb)) || (au.bwB(localbb.field_username))) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label326;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      i = ((List)localObject1).size();
      break;
      label342:
      bool1 = false;
      break label67;
      label348:
      localObject1 = com.tencent.mm.storage.b.a.admS;
      if (com.tencent.mm.storage.b.a.jdN()) {
        localObject1 = com.tencent.mm.plugin.ac.b.MnM;
      }
      for (int j = ((com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class)).gsG();; j = 0)
      {
        i += j;
        if ((!bool1) || (!aDE(i))) {
          break label405;
        }
        bool1 = true;
        break;
      }
      label405:
      bool1 = false;
    }
  }
  
  private final void MK(boolean paramBoolean)
  {
    AppMethodBeat.i(256988);
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.afnq;
    if (localObject1 != null)
    {
      localObject1 = ((k)localObject1).jhT();
      if (localObject1 != null)
      {
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        if (localIterator.hasNext())
        {
          bb localbb = (bb)((Map.Entry)localIterator.next()).getValue();
          bh.bCz();
          int i;
          label133:
          label155:
          label178:
          label200:
          StringBuilder localStringBuilder;
          if (com.tencent.mm.model.c.bzG().k(localbb))
          {
            v(localbb);
            if ((localbb != null) && (localbb.adis == 4))
            {
              i = 1;
              if (i == 0)
              {
                if ((localbb == null) || (localbb.adis != 132)) {
                  break label267;
                }
                i = 1;
                if (i == 0) {}
              }
              else
              {
                ((ArrayList)localObject2).add(localbb.field_username);
              }
              if (localbb != null) {
                break label272;
              }
              localObject1 = null;
              if (s.p(localObject1, "message_fold")) {
                localArrayList.add(localbb.field_username);
              }
              localStringBuilder = new StringBuilder("updateAllFoldFlag, username:");
              if (localbb != null) {
                break label292;
              }
              localObject1 = null;
              label220:
              localStringBuilder = localStringBuilder.append(localObject1).append(", foldFlag: ");
              if (localbb != null) {
                break label302;
              }
            }
          }
          label267:
          label272:
          label292:
          label302:
          for (localObject1 = null;; localObject1 = Integer.valueOf(localbb.adis))
          {
            Log.d("MicroMsg.FolderHelper", localObject1);
            break;
            i = 0;
            break label133;
            i = 0;
            break label155;
            localObject1 = localbb.field_parentRef;
            break label178;
            a(localbb, 0, null);
            break label200;
            localObject1 = localbb.field_username;
            break label220;
          }
        }
      }
    }
    if (!paramBoolean)
    {
      localObject1 = this.afpH;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.conversation.fold.a.b)localObject1).reset();
      }
      localObject1 = this.afpp;
      if (localObject1 != null) {
        ((ConversationListView)localObject1).MI(false);
      }
      this.afpC = ((ArrayList)localObject2).size();
      this.afpD = 0;
      this.afpG = false;
      this.afpF = true;
      localObject1 = com.tencent.mm.plugin.ac.b.MnM;
      ((com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class)).C((List)localObject2, "message_fold");
      AppMethodBeat.o(256988);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = com.tencent.mm.plugin.ac.b.MnM;
    localObject1 = ((com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class)).gsH();
    this.afpC = ((List)localObject1).size();
    this.afpD = this.afpC;
    localObject2 = com.tencent.mm.plugin.ac.b.MnM;
    ((com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class)).C((List)localObject1, "");
    Log.d("MicroMsg.FolderHelper", "perform expand cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(256988);
  }
  
  private final void ML(boolean paramBoolean)
  {
    AppMethodBeat.i(257015);
    ConversationListView localConversationListView = this.afpp;
    int i;
    Object localObject1;
    int k;
    boolean bool1;
    label49:
    boolean bool2;
    Object localObject2;
    int i1;
    if (localConversationListView != null)
    {
      i = -1;
      localObject1 = this.afnq;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label139;
        }
        int n = localObject1.length;
        k = 0;
        bool1 = false;
        j = i;
        bool2 = bool1;
        if (k >= n) {
          break label144;
        }
        localObject2 = localObject1[k];
        i1 = localObject2.size();
        if (i1 <= 0) {
          break label134;
        }
      }
    }
    int m;
    label134:
    label139:
    label144:
    label224:
    for (int j = 0;; j = m)
    {
      m = j + 1;
      if (s.p(localObject2.get(j), "message_fold")) {
        bool1 = true;
      }
      for (;;)
      {
        k += 1;
        i = j;
        break label49;
        localObject1 = ((k)localObject1).jhS();
        break;
        if (m < i1) {
          break label224;
        }
        j = i;
      }
      bool2 = false;
      j = i;
      i = ((Number)new r(Boolean.valueOf(bool2), Integer.valueOf(j)).bsD).intValue();
      if (i >= 0)
      {
        if (paramBoolean)
        {
          localConversationListView.smoothScrollToPositionFromTop(i + localConversationListView.getHeaderViewsCount(), 0, (int)this.afpy);
          AppMethodBeat.o(257015);
          return;
        }
        localConversationListView.smoothScrollToPositionFromTop(i + localConversationListView.getHeaderViewsCount(), 0, 0);
      }
      AppMethodBeat.o(257015);
      return;
    }
  }
  
  private final int MM(boolean paramBoolean)
  {
    AppMethodBeat.i(257036);
    if (!paramBoolean)
    {
      i = this.afpC;
      AppMethodBeat.o(257036);
      return i;
    }
    b.a locala = com.tencent.mm.plugin.ac.b.MnM;
    int i = ((com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class)).gsG();
    AppMethodBeat.o(257036);
    return i;
  }
  
  private static final void a(float paramFloat, m paramm, ViewGroup.LayoutParams paramLayoutParams, k.f paramf, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(257043);
    s.u(paramm, "this$0");
    s.u(paramLayoutParams, "$mViewLayoutParams");
    s.u(paramf, "$viewHolder");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramm = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(257043);
      throw paramm;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramLayoutParams.height = ((int)((paramm.afos - paramFloat) * f + paramFloat));
    paramf.contentView.setAlpha(f);
    paramf.afoQ.setLayoutParams(paramLayoutParams);
    paramf.afoO = paramLayoutParams.height;
    paramf.afoQ.requestLayout();
    AppMethodBeat.o(257043);
  }
  
  private static final void a(int paramInt1, ViewGroup.LayoutParams paramLayoutParams, k.f paramf, int paramInt2, float paramFloat1, m paramm, float paramFloat2)
  {
    AppMethodBeat.i(257041);
    s.u(paramf, "$viewHolder");
    s.u(paramm, "this$0");
    paramLayoutParams.height = ((int)(paramInt1 + (0 - paramInt1) * paramFloat2));
    paramf.contentView.setAlpha(1.0F - paramFloat2);
    paramf.afoQ.setLayoutParams(paramLayoutParams);
    paramf.afoO = paramLayoutParams.height;
    paramf.afoQ.requestLayout();
    paramFloat2 = paramInt2 + (paramFloat1 - paramInt2) * paramFloat2;
    paramLayoutParams = paramm.afpp;
    boolean bool;
    int i;
    int j;
    if (paramLayoutParams != null)
    {
      paramf = (LinearLayout.LayoutParams)paramLayoutParams.afnL.getLayoutParams();
      if (paramFloat2 >= 0.0F) {
        break label372;
      }
      bool = true;
      i = paramf.height;
      Log.d("MicroMsg.ConversationListView", "[updateEmptyFooter] isRealFull:" + bool + " old height:" + i + " extraHeight:" + paramFloat2);
      paramm = paramLayoutParams.getRootView().findViewById(R.h.fMt);
      if (paramm != null) {
        Log.d("MicroMsg.ConversationListView", "[updateEmptyFooter] tabView Height: %d", new Object[] { Integer.valueOf(paramm.getHeight()) });
      }
      j = (int)paramLayoutParams.getResources().getDimension(R.f.NormalListHeight);
      if (paramm == null) {
        break label378;
      }
      paramInt1 = paramm.getHeight();
      label231:
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = paramLayoutParams.afnz;
      }
      Log.d("MicroMsg.ConversationListView", "[updateEmptyFooter] tabHeight: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (!bool) {
        break label383;
      }
      paramf.height = paramInt2;
      paramFloat1 = paramFloat2;
    }
    for (;;)
    {
      if (i != paramf.height)
      {
        Log.d("MicroMsg.ConversationListView", "[updateEmptyFooter] isHeaderOpen: %b", new Object[] { Boolean.valueOf(paramLayoutParams.glK()) });
        if (((!bool) || (Math.abs(paramFloat1) <= paramInt2 + j)) && (!paramLayoutParams.glK()))
        {
          Log.d("MicroMsg.ConversationListView", "[updateEmptyFooter] setSelection");
          if (paramLayoutParams.afnv != null) {
            paramLayoutParams.afnv.Fi(true);
          }
        }
        paramLayoutParams.afnL.requestLayout();
      }
      AppMethodBeat.o(257041);
      return;
      label372:
      bool = false;
      break;
      label378:
      paramInt1 = 0;
      break label231;
      label383:
      paramFloat1 = paramFloat2;
      if (paramFloat2 < paramInt2) {
        paramFloat1 = paramInt2;
      }
      paramf.height = ((int)paramFloat1);
    }
  }
  
  private final void a(final i.c paramc, final cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(256926);
    bh.bCz();
    if (com.tencent.mm.model.c.bzG().bxW(paramc.talker))
    {
      if (dO(paramcc))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramcc));
        Log.i("MicroMsg.FolderHelper", "dealMsg, isSend: " + paramcc.field_isSend + ", status: " + paramcc.field_status + ", talker: " + paramcc.field_talker + ", isNewMsg: " + paramBoolean);
        AppMethodBeat.o(256926);
        return;
      }
      if ((paramcc.field_isSend == 0) && (paramcc.jbQ()))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramcc, paramc));
        AppMethodBeat.o(256926);
        return;
      }
      if ((paramBoolean) && (paramcc.field_isSend == 0) && (!paramcc.jbQ())) {
        eq(paramcc.field_talker, false);
      }
    }
    AppMethodBeat.o(256926);
  }
  
  private static void a(bb parambb, int paramInt, String paramString)
  {
    AppMethodBeat.i(257031);
    if (parambb != null) {
      parambb.adis = paramInt;
    }
    if (parambb != null) {
      parambb.BH(paramString);
    }
    AppMethodBeat.o(257031);
  }
  
  private static final void a(k.f paramf, ViewGroup.LayoutParams paramLayoutParams, b paramb)
  {
    AppMethodBeat.i(257042);
    s.u(paramf, "$viewHolder");
    paramf.contentView.setAlpha(0.0F);
    paramf.afoO = 0;
    paramf.afoQ.setLayoutParams(paramLayoutParams);
    paramf.afoQ.setVisibility(8);
    paramf.afoQ.requestLayout();
    if (paramb != null) {
      paramb.jAB();
    }
    AppMethodBeat.o(257042);
  }
  
  private static final void a(m paramm)
  {
    AppMethodBeat.i(257039);
    s.u(paramm, "this$0");
    Object localObject = paramm.bCg("message_fold");
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        paramm.ML(true);
      }
      AppMethodBeat.o(257039);
      return;
      if ((((k.f)localObject).afoQ.getTop() > paramm.afpv) || (((k.f)localObject).afoQ.getTop() <= paramm.afpu)) {
        paramm.ML(false);
      }
    }
  }
  
  private static final void a(m paramm, com.tencent.mm.pluginsdk.ui.a.b paramb, View paramView)
  {
    AppMethodBeat.i(257038);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/FolderHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    s.u(paramb, "$baseBanner");
    long l = System.currentTimeMillis();
    if (l - paramm.lastClickTime < 1000L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/conversation/FolderHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257038);
      return;
    }
    paramm.lastClickTime = l;
    if (paramb.cMa())
    {
      Log.i("MicroMsg.FolderHelper", "fold banner clicked !");
      paramm.jAu();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/conversation/FolderHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(257038);
  }
  
  private final boolean a(k.f paramf, b paramb, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(257011);
    Object localObject = this.afnq;
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (((bb)localObject).adis != 132)) {
        break label148;
      }
    }
    label148:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label154;
      }
      localObject = paramf.afoQ.getLayoutParams();
      i = paramf.afoQ.getMeasuredHeight();
      com.tencent.mm.ui.anim.a.a.kY(paramf.afoQ).zE(this.afpx).aY(new m..ExternalSyntheticLambda3(paramf)).a(new m..ExternalSyntheticLambda2(i, (ViewGroup.LayoutParams)localObject, paramf, paramInt, paramFloat, this)).aX(new m..ExternalSyntheticLambda4(paramf, (ViewGroup.LayoutParams)localObject, paramb)).start();
      AppMethodBeat.o(257011);
      return true;
      localObject = (bb)((k)localObject).azn(paramf.position);
      break;
    }
    label154:
    Log.d("MicroMsg.FolderHelper", "expand anim skip, username: %s", new Object[] { paramf.username });
    paramb.jAB();
    AppMethodBeat.o(257011);
    return false;
  }
  
  static Animator[] a(Animator[] paramArrayOfAnimator)
  {
    Animator[] arrayOfAnimator = new Animator[paramArrayOfAnimator.length + 0 + 0];
    int k = paramArrayOfAnimator.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Animator localAnimator = paramArrayOfAnimator[j];
      j += 1;
      arrayOfAnimator[i] = localAnimator;
      i += 1;
    }
    return arrayOfAnimator;
  }
  
  private final boolean aDE(int paramInt)
  {
    AppMethodBeat.i(256977);
    if ((jAn()) && (paramInt <= jAp()) && (this.afos * paramInt >= this.afpt * jAo()))
    {
      AppMethodBeat.o(256977);
      return true;
    }
    AppMethodBeat.o(256977);
    return false;
  }
  
  private final void av(boolean paramBoolean, int paramInt)
  {
    int j = 131072;
    AppMethodBeat.i(256992);
    Object localObject = bCg("message_fold");
    if (localObject != null)
    {
      if (paramBoolean)
      {
        i = 131072;
        a(i, (View)((k.f)localObject).afoR, ((k.f)localObject).afoS, paramInt);
      }
    }
    else
    {
      localObject = this.afpq;
      if ((localObject == null) || (((LinearLayout)localObject).getVisibility() != 0)) {
        break label124;
      }
      i = 1;
      label73:
      if (i != 0) {
        if (!paramBoolean) {
          break label129;
        }
      }
    }
    label129:
    for (int i = j;; i = 262144)
    {
      a(i, this.afpr, this.afoS, paramInt);
      if (!jAz()) {
        this.afpC = paramInt;
      }
      AppMethodBeat.o(256992);
      return;
      i = 262144;
      break;
      label124:
      i = 0;
      break label73;
    }
  }
  
  private final int b(bb parambb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(257025);
    if (parambb == null)
    {
      Log.e("MicroMsg.FolderHelper", "calcFoldFlag conversation failed");
      AppMethodBeat.o(257025);
      return 0;
    }
    if ((!this.mInited) && (bh.baz()))
    {
      this.mInited = true;
      jAr();
    }
    if (au.bwB(parambb.field_username))
    {
      parambb = com.tencent.mm.storage.b.a.admS;
      if (com.tencent.mm.storage.b.a.jdN())
      {
        AppMethodBeat.o(257025);
        return 131072;
      }
      AppMethodBeat.o(257025);
      return 262144;
    }
    bh.bCz();
    if (com.tencent.mm.model.c.bzG().m(parambb))
    {
      if ((parambb.field_unReadCount > 0) || (parambb.field_unReadMuteCount > 0) || (parambb.rx(1048576)) || (w(parambb)) || (parambb.rx(536870912)))
      {
        AppMethodBeat.o(257025);
        return 1;
      }
      if (parambb.adis == 10)
      {
        AppMethodBeat.o(257025);
        return 10;
      }
      parambb = com.tencent.mm.storage.b.a.admS;
      if (com.tencent.mm.storage.b.a.jdO())
      {
        AppMethodBeat.o(257025);
        return 2;
      }
      AppMethodBeat.o(257025);
      return 4;
    }
    AppMethodBeat.o(257025);
    return 0;
  }
  
  private static final void b(k.f paramf)
  {
    AppMethodBeat.i(257040);
    s.u(paramf, "$viewHolder");
    paramf.contentView.setAlpha(1.0F);
    paramf.afoQ.setVisibility(0);
    AppMethodBeat.o(257040);
  }
  
  private final k.f bCg(String paramString)
  {
    AppMethodBeat.i(257035);
    ConversationListView localConversationListView = this.afpp;
    int i;
    int k;
    if (localConversationListView != null)
    {
      i = 0;
      k = localConversationListView.getChildCount();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      Object localObject = localConversationListView.getChildAt(i);
      if (localObject == null) {
        localObject = null;
      }
      while ((localObject != null) && ((((View)localObject).getTag() instanceof k.f)))
      {
        localObject = ((View)localObject).getTag();
        if (localObject == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.conversation.ConversationWithCacheAdapter.ViewHolder");
          AppMethodBeat.o(257035);
          throw paramString;
          localObject = ((View)localObject).findViewById(R.h.fDD);
        }
        else
        {
          localObject = (k.f)localObject;
          if (s.p(((k.f)localObject).username, paramString))
          {
            AppMethodBeat.o(257035);
            return localObject;
          }
        }
      }
      if (j >= k)
      {
        AppMethodBeat.o(257035);
        return null;
      }
      i = j;
    }
  }
  
  private final void cP(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(256907);
    int i = paramInt;
    if (paramBoolean) {}
    try
    {
      i = paramInt - bf.bk(this.context);
      paramInt = bf.getStatusBarHeight(this.context);
      int j = bf.fs(this.context);
      int k = com.tencent.mm.cd.a.br(this.context, R.f.DefaultTabbarHeight);
      this.afpt = (i - j - k);
      this.afpv = (i - k);
      this.afpu = (paramInt + j);
      this.afpz = (this.afpt / this.afos);
      Log.i("MicroMsg.FolderHelper", s.X("configParams, height: ", Integer.valueOf(i)));
      AppMethodBeat.o(256907);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FolderHelper", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(256907);
    }
  }
  
  private static boolean dO(cc paramcc)
  {
    AppMethodBeat.i(256931);
    if ((paramcc.field_isSend != 0) || (paramcc.jbQ()) || ((!paramcc.jbE()) && (!paramcc.jbA()) && (!paramcc.jbL()) && ((com.tencent.mm.bd.d.oXN == null) || (!com.tencent.mm.bd.d.oXN.Py(paramcc.field_talker))) && (paramcc.getType() != 268445456)))
    {
      if ((paramcc.field_isSend != 1) || (paramcc.field_status != 3)) {
        break label132;
      }
      if (!au.bws(paramcc.field_talker))
      {
        paramcc = paramcc.field_talker;
        bh.bCz();
        if (!paramcc.equals(com.tencent.mm.model.c.ban().d(2, ""))) {
          break label132;
        }
      }
    }
    AppMethodBeat.o(256931);
    return true;
    label132:
    AppMethodBeat.o(256931);
    return false;
  }
  
  private static void eq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(256938);
    bh.bCz();
    bb localbb = com.tencent.mm.model.c.bzG().bxM(paramString);
    if (localbb == null) {}
    for (paramString = null;; paramString = localbb.field_parentRef)
    {
      if (s.p(paramString, "message_fold"))
      {
        if (paramBoolean) {
          localbb.rv(536870912);
        }
        paramString = com.tencent.mm.plugin.ac.b.MnM;
        paramString = (com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class);
        String str = localbb.field_username;
        s.s(str, "conv.username");
        paramString.au(str, "", localbb.field_attrflag);
      }
      AppMethodBeat.o(256938);
      return;
    }
  }
  
  private final boolean jAn()
  {
    AppMethodBeat.i(256911);
    if (this.afpJ == -1) {
      this.afpJ = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwE, 1);
    }
    if (this.afpJ == 1)
    {
      AppMethodBeat.o(256911);
      return true;
    }
    AppMethodBeat.o(256911);
    return false;
  }
  
  private final int jAp()
  {
    AppMethodBeat.i(256918);
    if (this.afpL == -1) {
      this.afpL = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwH, 2147483647);
    }
    int i = this.afpL;
    AppMethodBeat.o(256918);
    return i;
  }
  
  private final void jAr()
  {
    Object localObject2 = null;
    AppMethodBeat.i(256964);
    bh.bCz();
    bb localbb = com.tencent.mm.model.c.bzG().bxM("message_fold");
    if (localbb != null) {}
    for (int i = 1;; i = 0)
    {
      localObject1 = com.tencent.mm.storage.b.a.admS;
      if ((com.tencent.mm.storage.b.a.jdP()) || (i == 0)) {
        break;
      }
      i = h.baE().ban().getInt(at.a.adhO, 262144);
      localObject1 = com.tencent.mm.storage.b.a.admS;
      com.tencent.mm.storage.b.a.azk(i);
      Log.i("MicroMsg.FolderHelper", s.X("last fold conv is exist!, lastState: ", Integer.valueOf(i)));
      AppMethodBeat.o(256964);
      return;
    }
    if (i == 0)
    {
      localObject1 = com.tencent.mm.storage.b.a.admS;
      com.tencent.mm.storage.b.a.azk(65536);
      cQ(8, true);
      Log.i("MicroMsg.FolderHelper", "last fold conv is not exist!, reset state");
      AppMethodBeat.o(256964);
      return;
    }
    bh.bCz();
    boolean bool = com.tencent.mm.model.c.bzG().k(localbb);
    if (bool)
    {
      if (localbb != null) {
        break label268;
      }
      localObject1 = null;
      if (!s.p(localObject1, "message_fold")) {}
    }
    else
    {
      localbb.BH(null);
      localbb.gR(0L);
      localbb.gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, 2, 0L));
      bh.bCz();
      com.tencent.mm.model.c.bzG().c(localbb, localbb.field_username);
    }
    StringBuilder localStringBuilder = new StringBuilder("correct status, conv existDB : true, parentRef: ");
    if (localbb == null) {}
    for (Object localObject1 = localObject2;; localObject1 = localbb.field_parentRef)
    {
      Log.i("MicroMsg.FolderHelper", localObject1 + ", isPlacedTop: " + bool);
      AppMethodBeat.o(256964);
      return;
      label268:
      localObject1 = localbb.field_parentRef;
      break;
    }
  }
  
  private final void jAv()
  {
    AppMethodBeat.i(257002);
    long l = 0L;
    Object localObject1 = this.afnq;
    Object localObject2;
    int i;
    int j;
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((k)localObject1).jhT();
      if (localObject1 != null)
      {
        localObject2 = ((Map)localObject1).entrySet().iterator();
        i = 0;
        j = 0;
        while (((Iterator)localObject2).hasNext())
        {
          bb localbb = (bb)((Map.Entry)((Iterator)localObject2).next()).getValue();
          switch (b(localbb, false, false))
          {
          default: 
            k = j;
            if (au.bwB(localbb.field_username))
            {
              a(localbb, 131072, null);
              i = 1;
              j = k;
            }
            break;
          case 2: 
          case 66: 
            if (bCg(localbb.field_username) == null) {}
            for (localObject1 = null;; localObject1 = ah.aiuX)
            {
              if (localObject1 == null) {
                a(localbb, 4, "message_fold");
              }
              k = j + 1;
              break;
              a(localbb, 132, null);
            }
            bh.bCz();
            j = k;
            if (com.tencent.mm.model.c.bzG().k(localbb))
            {
              l += 1L;
              j = k;
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        cQ(8, true);
        Log.i("MicroMsg.FolderHelper", "performAllCollapse, fold item not exit!");
        AppMethodBeat.o(257002);
        return;
      }
      localObject1 = com.tencent.mm.storage.b.a.admS;
      com.tencent.mm.storage.b.a.azk(131072);
      av(true, j);
      this.afpB = false;
      this.afpF = false;
      this.afpG = true;
      localObject1 = this.afpp;
      float f;
      label319:
      final int m;
      label333:
      int n;
      int i1;
      if (localObject1 == null)
      {
        f = 0.0F;
        localObject1 = this.afpp;
        if (localObject1 != null) {
          break label530;
        }
        k = 0;
        localObject1 = this.afpp;
        if (localObject1 != null) {
          break label540;
        }
        m = 0;
        localObject2 = (b)new h(new ah.d(), m, this);
        if (m <= 0) {
          break label679;
        }
        n = 0;
        i = 0;
        i1 = n + 1;
        localObject1 = this.afpp;
        if (localObject1 != null) {
          break label550;
        }
        localObject1 = null;
        label385:
        if (localObject1 != null) {
          break label562;
        }
        localObject1 = null;
      }
      for (;;)
      {
        if ((localObject1 != null) && ((((View)localObject1).getTag() instanceof k.f)))
        {
          localObject1 = ((View)localObject1).getTag();
          if (localObject1 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.conversation.ConversationWithCacheAdapter.ViewHolder");
            AppMethodBeat.o(257002);
            throw ((Throwable)localObject1);
            localObject2 = this.afpp;
            if (localObject2 == null)
            {
              i = 0;
              label455:
              localObject2 = this.afpp;
              if (localObject2 != null) {
                break label510;
              }
              k = 0;
              label469:
              localObject2 = this.afnq;
              if (localObject2 != null) {
                break label520;
              }
            }
            label520:
            for (m = 0;; m = ((k)localObject2).getCount())
            {
              f = ((ConversationListView)localObject1).X(m + (k + i), j, true);
              break;
              i = ((ConversationListView)localObject2).getHeaderViewsCount();
              break label455;
              label510:
              k = ((ConversationListView)localObject2).getFooterViewsCount();
              break label469;
            }
            label530:
            k = ((ConversationListView)localObject1).getEmptyFooterHeight();
            break label319;
            label540:
            m = ((ConversationListView)localObject1).getCount();
            break label333;
            label550:
            localObject1 = ((ConversationListView)localObject1).getChildAt(n);
            break label385;
            label562:
            localObject1 = ((View)localObject1).findViewById(R.h.fDD);
            continue;
          }
          a((k.f)localObject1, (b)localObject2, k, f);
          i = 1;
          label592:
          if (i1 < m) {
            break label672;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          ((b)localObject2).jAC();
        }
        localObject1 = com.tencent.mm.ui.conversation.fold.b.a.afuo;
        com.tencent.mm.ui.conversation.fold.b.a.bJ(l, 1L);
        Log.i("MicroMsg.FolderHelper", "[perform collapse] topFoldCount: " + j + ", allTopCount: " + l);
        AppMethodBeat.o(257002);
        return;
        ((b)localObject2).jAB();
        break label592;
        label672:
        n = i1;
        break;
        label679:
        i = 0;
      }
      i = 0;
      l = 0L;
      j = 0;
    }
  }
  
  private final void jAw()
  {
    AppMethodBeat.i(257006);
    long l1 = 0L;
    Object localObject = this.afnq;
    if (localObject != null)
    {
      localObject = ((k)localObject).jhT();
      if (localObject != null)
      {
        localObject = ((Map)localObject).entrySet().iterator();
        int i = 0;
        for (;;)
        {
          j = i;
          l2 = l1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          bb localbb = (bb)((Map.Entry)((Iterator)localObject).next()).getValue();
          if (au.bwB(localbb.field_username))
          {
            a(localbb, 262144, null);
            i = 1;
          }
          else
          {
            bh.bCz();
            if (com.tencent.mm.model.c.bzG().k(localbb)) {
              l1 += 1L;
            }
          }
        }
      }
    }
    int j = 0;
    long l2 = l1;
    if (j == 0)
    {
      cQ(8, true);
      Log.i("MicroMsg.FolderHelper", "performAllExpand, fold item not exit!");
      AppMethodBeat.o(257006);
      return;
    }
    localObject = com.tencent.mm.storage.b.a.admS;
    com.tencent.mm.storage.b.a.azk(262144);
    this.afpB = true;
    MK(true);
    l1 = this.afpC + l2;
    av(false, this.afpC);
    localObject = com.tencent.mm.ui.conversation.fold.b.a.afuo;
    com.tencent.mm.ui.conversation.fold.b.a.bJ(l1, 2L);
    Log.i("MicroMsg.FolderHelper", "[perform expand], allPlaceTopCount: " + l1 + ", foldedItemCounts:" + this.afpC);
    AppMethodBeat.o(257006);
  }
  
  private final boolean jAz()
  {
    Iterator localIterator = null;
    AppMethodBeat.i(257033);
    Object localObject1 = this.afnq;
    if (localObject1 == null) {
      localObject1 = localIterator;
    }
    while ((localObject1 != null) || (this.afpG))
    {
      AppMethodBeat.o(257033);
      return true;
      Object localObject2 = ((k)localObject1).jhT();
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localObject2 = ((HashMap)localObject2).values();
        localObject1 = localIterator;
        if (localObject2 != null)
        {
          localIterator = ((Iterable)localObject2).iterator();
          label76:
          int i;
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            localObject2 = (bb)localObject1;
            if ((((bb)localObject2).adis == 66) || (((bb)localObject2).adis == 132))
            {
              i = 1;
              label121:
              if (i == 0) {
                break label136;
              }
            }
          }
          for (;;)
          {
            localObject1 = (bb)localObject1;
            break;
            i = 0;
            break label121;
            label136:
            break label76;
            localObject1 = null;
          }
        }
      }
    }
    AppMethodBeat.o(257033);
    return false;
  }
  
  static boolean jdO()
  {
    AppMethodBeat.i(369654);
    com.tencent.mm.storage.b.a locala = com.tencent.mm.storage.b.a.admS;
    boolean bool = com.tencent.mm.storage.b.a.jdO();
    AppMethodBeat.o(369654);
    return bool;
  }
  
  public static List<bb> k(k paramk)
  {
    AppMethodBeat.i(257037);
    List localList = (List)new ArrayList();
    paramk = paramk.jhT();
    if (paramk != null)
    {
      paramk = ((Map)paramk).entrySet().iterator();
      while (paramk.hasNext()) {
        localList.add((bb)((Map.Entry)paramk.next()).getValue());
      }
    }
    AppMethodBeat.o(257037);
    return localList;
  }
  
  public static void u(bb parambb)
  {
    AppMethodBeat.i(256947);
    s.u(parambb, "conv");
    Object localObject = (CharSequence)parambb.field_parentRef;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {
      i = 1;
    }
    while ((i != 0) && (!au.bwB(parambb.field_username)))
    {
      parambb.rw(536870912);
      localObject = com.tencent.mm.storage.b.a.admS;
      String str;
      if (com.tencent.mm.storage.b.a.jdN())
      {
        parambb.BH("message_fold");
        localObject = com.tencent.mm.plugin.ac.b.MnM;
        localObject = (com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class);
        str = parambb.field_username;
        s.s(str, "conv.username");
        ((com.tencent.mm.plugin.ac.b.a)localObject).au(str, "message_fold", parambb.field_attrflag);
        AppMethodBeat.o(256947);
        return;
        i = 0;
      }
      else
      {
        localObject = com.tencent.mm.plugin.ac.b.MnM;
        localObject = (com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class);
        str = parambb.field_username;
        s.s(str, "conv.username");
        ((com.tencent.mm.plugin.ac.b.a)localObject).au(str, parambb.field_parentRef, parambb.field_attrflag);
      }
    }
    AppMethodBeat.o(256947);
  }
  
  private final void v(bb parambb)
  {
    AppMethodBeat.i(257021);
    if (parambb != null) {
      parambb.adis = b(parambb, false, false);
    }
    Object localObject;
    if (parambb == null)
    {
      localObject = "";
      if (parambb != null) {
        break label87;
      }
    }
    label87:
    for (int i = 0;; i = parambb.adis)
    {
      Log.d("MicroMsg.FolderHelper", "calcAndUpdateFoldFlag username:%s, foldFlag:%d", new Object[] { localObject, Integer.valueOf(i) });
      AppMethodBeat.o(257021);
      return;
      String str = parambb.field_username;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
    }
  }
  
  private boolean w(bb parambb)
  {
    AppMethodBeat.i(257027);
    s.u(parambb, "conv");
    int i;
    if (parambb.field_isSend == 0)
    {
      if ((this.afnq == null) || (k.aip(parambb.field_msgType) != 889192497)) {
        break label178;
      }
      i = 1;
      if (i != 0) {}
    }
    else
    {
      if ((this.afnq == null) || (k.aip(parambb.field_msgType) != 922746929)) {
        break label183;
      }
      i = 1;
      label68:
      if (i == 0) {
        break label302;
      }
    }
    ebd localebd = new ebd();
    Integer localInteger;
    if (this.afnq == null)
    {
      localInteger = null;
      label90:
      parambb = parambb.field_content;
      if (localInteger != null) {
        break label203;
      }
      label100:
      if (localInteger != null) {
        break label240;
      }
      parambb = localebd;
    }
    for (;;)
    {
      try
      {
        if (parambb.Ksg.size() <= 0) {
          break label302;
        }
        parambb = (ebe)parambb.Ksg.getLast();
        if (s.p(parambb.hQQ, z.bAM())) {
          break label302;
        }
        i = parambb.abgL;
        Log.i("MicroMsg.ConversationWithCacheAdapter", "isNewPatMsg: %d", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          break label307;
        }
        AppMethodBeat.o(257027);
        return true;
      }
      catch (Exception parambb)
      {
        label178:
        label183:
        label203:
        label240:
        Log.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", (Throwable)parambb, "", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label68;
      localInteger = Integer.valueOf(k.aip(parambb.field_msgType));
      break label90;
      if (localInteger.intValue() != 889192497) {
        break label100;
      }
      parambb = ((com.tencent.mm.plugin.patmsg.a.b)h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).aRl(parambb);
      s.s(parambb, "service(IPatMsgExtension…rseMsgContent(msgContent)");
      continue;
      if (localInteger.intValue() == 922746929)
      {
        parambb = k.b.Hf(parambb);
        if (parambb != null)
        {
          parambb = ((com.tencent.mm.plugin.patmsg.a.a)parambb.aK(com.tencent.mm.plugin.patmsg.a.a.class)).MHl;
          s.s(parambb, "content.piece(AppMsgCont…class.java).patMsgContent");
          continue;
          label302:
          i = 1;
          continue;
          label307:
          AppMethodBeat.o(257027);
          return false;
        }
      }
      parambb = localebd;
    }
  }
  
  final void a(int paramInt1, View paramView, TextView paramTextView, int paramInt2)
  {
    Resources localResources2 = null;
    Resources localResources1 = null;
    AppMethodBeat.i(257257);
    if (paramInt1 == 131072)
    {
      if (paramView != null) {
        paramView.setRotation(0.0F);
      }
      if (paramTextView != null)
      {
        if (paramTextView != null) {
          break label60;
        }
        paramView = localResources1;
      }
      for (;;)
      {
        paramTextView.setText((CharSequence)paramView);
        this.afpC = paramInt2;
        AppMethodBeat.o(257257);
        return;
        label60:
        localResources2 = paramTextView.getResources();
        paramView = localResources1;
        if (localResources2 != null) {
          paramView = localResources2.getString(R.l.gxk, new Object[] { Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramView != null) {
      paramView.setRotation(180.0F);
    }
    if (paramTextView != null)
    {
      if (paramTextView != null) {
        break label135;
      }
      paramView = localResources2;
    }
    for (;;)
    {
      paramTextView.setText((CharSequence)paramView);
      AppMethodBeat.o(257257);
      return;
      label135:
      localResources1 = paramTextView.getResources();
      paramView = localResources2;
      if (localResources1 != null) {
        paramView = localResources1.getString(R.l.gxl);
      }
    }
  }
  
  public final void a(Context paramContext, ConversationListView paramConversationListView, k paramk, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(257188);
    s.u(paramContext, "context");
    this.context = paramContext;
    this.afpp = paramConversationListView;
    this.afnq = paramk;
    this.afpq = paramLinearLayout;
    this.afos = ((int)(paramContext.getResources().getDimension(R.f.NormalListHeight) + 0.5F));
    this.afot = ((int)(paramContext.getResources().getDimension(R.f.ListFoldHeight) + 0.5F));
    this.afps = ((int)(com.tencent.mm.cd.a.bs(paramContext, R.f.DefaultTabbarHeight) * com.tencent.mm.cd.a.jO(paramContext)));
    if (this.afpM == -1) {
      this.afpM = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwG, 0);
    }
    this.afpM = this.afpM;
    cP(aw.bf(paramContext).y, true);
    paramContext = e.a(this.context, e.a.aftc, null);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.banner.BaseBanner");
      AppMethodBeat.o(257188);
      throw paramContext;
    }
    this.hAo = ((com.tencent.mm.pluginsdk.ui.a.b)paramContext);
    paramContext = this.hAo;
    if (paramContext != null)
    {
      paramConversationListView = this.afpq;
      if (paramConversationListView != null) {
        paramConversationListView.addView(paramContext.getView());
      }
      paramConversationListView = this.afpq;
      if (paramConversationListView != null) {
        paramConversationListView.setOnClickListener(new m..ExternalSyntheticLambda1(this, paramContext));
      }
      paramContext = this.hAo;
      if (paramContext != null) {
        break label429;
      }
      paramContext = null;
      this.afpr = paramContext;
      paramContext = this.hAo;
      if (paramContext != null) {
        break label454;
      }
      paramContext = null;
      label258:
      this.afoS = paramContext;
      paramContext = this.afpp;
      if (paramContext != null) {
        paramContext.setFoldBanner((View)this.afpq);
      }
      paramContext = this.afpp;
      if (paramContext != null) {
        paramContext.setFoldHelper(this);
      }
      paramContext = this.afpq;
      if (paramContext != null) {
        break label482;
      }
      paramContext = null;
      label308:
      if (!(paramContext instanceof ViewGroup.MarginLayoutParams)) {
        break label490;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      label320:
      if (paramContext != null) {
        paramContext.bottomMargin = this.afps;
      }
      paramConversationListView = this.afpq;
      if (paramConversationListView != null) {
        paramConversationListView.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
    }
    paramContext = this.afpp;
    if (paramContext == null)
    {
      paramContext = null;
      label360:
      if (paramContext != null) {
        break label510;
      }
    }
    label429:
    label454:
    label482:
    label490:
    label510:
    for (paramContext = null;; paramContext = new com.tencent.mm.ui.conversation.fold.a.b((com.tencent.mm.ui.conversation.fold.a.c)paramContext))
    {
      this.afpH = paramContext;
      bh.bCz();
      com.tencent.mm.model.c.a((com.tencent.mm.model.bd)this);
      bh.bCz();
      com.tencent.mm.model.c.bzD().a((i.a)this, null);
      bh.bCz();
      com.tencent.mm.model.c.bzG().add((MStorageEx.IOnStorageChange)this);
      this.afpI.alive();
      AppMethodBeat.o(257188);
      return;
      paramContext = paramContext.getView();
      if (paramContext == null)
      {
        paramContext = null;
        break;
      }
      paramContext = paramContext.findViewById(R.h.fVJ);
      break;
      paramContext = paramContext.getView();
      if (paramContext == null)
      {
        paramContext = null;
        break label258;
      }
      paramContext = (TextView)paramContext.findViewById(R.h.fIM);
      break label258;
      paramContext = paramContext.getLayoutParams();
      break label308;
      paramContext = null;
      break label320;
      paramContext = new com.tencent.mm.ui.conversation.fold.a.a((AbsListView)paramContext);
      break label360;
    }
  }
  
  final Animator[] a(final k.f paramf, bb parambb)
  {
    AppMethodBeat.i(257265);
    final ViewGroup.LayoutParams localLayoutParams = paramf.afoQ.getLayoutParams();
    if (localLayoutParams == null)
    {
      AppMethodBeat.o(257265);
      return new Animator[0];
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    s.s(localValueAnimator, "ofFloat(0f, 1.0f)");
    localValueAnimator.addListener((Animator.AnimatorListener)new f(parambb, this, paramf, localLayoutParams));
    localValueAnimator.addUpdateListener(new m..ExternalSyntheticLambda0(0.0F, this, localLayoutParams, paramf));
    paramf = (Animator)localValueAnimator;
    AppMethodBeat.o(257265);
    return new Animator[] { paramf };
  }
  
  public final bb bCf(String paramString)
  {
    AppMethodBeat.i(257272);
    k localk = this.afnq;
    if (localk == null)
    {
      AppMethodBeat.o(257272);
      return null;
    }
    paramString = (bb)localk.gG(paramString);
    AppMethodBeat.o(257272);
    return paramString;
  }
  
  public final void cO(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(257199);
    cP(paramInt, paramBoolean);
    jAq();
    AppMethodBeat.o(257199);
  }
  
  final void cQ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(257239);
    Object localObject = this.afpq;
    boolean bool;
    label72:
    TextView localTextView;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() == paramInt))
    {
      i = 1;
      if (i == 0)
      {
        localObject = this.afpq;
        if (localObject != null) {
          ((LinearLayout)localObject).setVisibility(paramInt);
        }
      }
      if (paramInt == 0)
      {
        localObject = com.tencent.mm.storage.b.a.admS;
        bool = com.tencent.mm.storage.b.a.jdN();
        if (!bool) {
          break label117;
        }
        paramInt = 131072;
        localObject = this.afpr;
        localTextView = this.afoS;
        if (!paramBoolean) {
          break label124;
        }
      }
    }
    label117:
    label124:
    for (int i = MM(bool);; i = this.afpC)
    {
      a(paramInt, (View)localObject, localTextView, i);
      AppMethodBeat.o(257239);
      return;
      i = 0;
      break;
      paramInt = 262144;
      break label72;
    }
  }
  
  final float jAo()
  {
    AppMethodBeat.i(257204);
    if (this.afpK < 0.0F) {
      this.afpK = (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwF, 100) / 100.0F);
    }
    float f = this.afpK;
    AppMethodBeat.o(257204);
    return f;
  }
  
  public final void jAq()
  {
    AppMethodBeat.i(257212);
    if ((this.context == null) || (!bh.baz()) || (this.afpq == null) || (this.afpp == null) || (this.afnq == null))
    {
      Log.e("MicroMsg.FolderHelper", "acc is not ready!");
      AppMethodBeat.o(257212);
      return;
    }
    com.tencent.mm.ae.d.a(100L, (kotlin.g.a.a)new i(this));
    AppMethodBeat.o(257212);
  }
  
  public final void jAs()
  {
    AppMethodBeat.i(257248);
    if (!jAn())
    {
      AppMethodBeat.o(257248);
      return;
    }
    bh.bCz();
    if (com.tencent.mm.model.c.bzG().bxM("message_fold") == null)
    {
      Object localObject2 = new bb();
      ((bb)localObject2).adis = 262144;
      ((bb)localObject2).setUsername("message_fold");
      Object localObject1 = this.context;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((Context)localObject1).getString(R.l.gxl))
      {
        ((bb)localObject2).setContent((String)localObject1);
        ((bb)localObject2).gR(0L);
        ((bb)localObject2).gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((bb)localObject2, 2, 0L));
        bh.bCz();
        if (com.tencent.mm.model.c.bzG().h((bb)localObject2) == -1L) {
          break label274;
        }
        localObject1 = com.tencent.mm.storage.b.a.admS;
        com.tencent.mm.storage.b.a.azk(262144);
        localObject1 = new ArrayList();
        localObject2 = this.afnq;
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((k)localObject2).jhT();
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bb localbb = (bb)((Map.Entry)((Iterator)localObject2).next()).getValue();
          v(localbb);
          if ((localbb.adis == 2) || (localbb.adis == 66)) {
            ((ArrayList)localObject1).add(localbb.field_username);
          }
        }
      }
      localObject2 = com.tencent.mm.plugin.ac.b.MnM;
      ((com.tencent.mm.plugin.ac.b.a)b.a.q(com.tencent.mm.plugin.ac.b.a.class)).C((List)localObject1, "message_fold");
      Log.i("MicroMsg.FolderHelper", "insert fold item suc");
      AppMethodBeat.o(257248);
      return;
      label274:
      Log.e("MicroMsg.FolderHelper", "insert fold item failed, ignore it");
      AppMethodBeat.o(257248);
      return;
    }
    Log.i("MicroMsg.FolderHelper", "fold item exist");
    AppMethodBeat.o(257248);
  }
  
  public final void jAt()
  {
    AppMethodBeat.i(257253);
    this.afpF = false;
    this.afpG = false;
    ConversationListView localConversationListView = this.afpp;
    m..ExternalSyntheticLambda5 localExternalSyntheticLambda5;
    if (localConversationListView != null)
    {
      localExternalSyntheticLambda5 = new m..ExternalSyntheticLambda5(this);
      if (this.afpC <= this.afpE) {
        break label65;
      }
    }
    label65:
    for (long l = 100L;; l = 0L)
    {
      localConversationListView.postDelayed(localExternalSyntheticLambda5, l);
      AppMethodBeat.o(257253);
      return;
    }
  }
  
  public final void jAu()
  {
    AppMethodBeat.i(257260);
    Object localObject = com.tencent.mm.storage.b.a.admS;
    if (com.tencent.mm.storage.b.a.jdO())
    {
      if (bCg("message_fold") == null) {}
      for (localObject = null; localObject == null; localObject = ah.aiuX)
      {
        jAv();
        AppMethodBeat.o(257260);
        return;
        jAv();
      }
      AppMethodBeat.o(257260);
      return;
    }
    localObject = com.tencent.mm.storage.b.a.admS;
    if (com.tencent.mm.storage.b.a.jdN())
    {
      jAw();
      AppMethodBeat.o(257260);
      return;
    }
    cQ(8, true);
    Log.e("MicroMsg.FolderHelper", "fold item no exist or no need collapse or expand !");
    AppMethodBeat.o(257260);
  }
  
  public final List<bb> jAx()
  {
    AppMethodBeat.i(257269);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.afnq;
    if (localObject2 != null)
    {
      localObject2 = ((k)localObject2).jhT();
      if (localObject2 != null)
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bb localbb = (bb)((Map.Entry)((Iterator)localObject2).next()).getValue();
          bh.bCz();
          if ((com.tencent.mm.model.c.bzG().k(localbb)) && (!au.bwB(localbb.field_username))) {
            ((ArrayList)localObject1).add(localbb);
          }
        }
      }
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(257269);
    return localObject1;
  }
  
  public final boolean jAy()
  {
    Iterator localIterator = null;
    AppMethodBeat.i(257274);
    Object localObject1 = this.afnq;
    if (localObject1 == null) {
      localObject1 = localIterator;
    }
    while (localObject1 != null)
    {
      AppMethodBeat.o(257274);
      return true;
      Object localObject2 = ((k)localObject1).jhT();
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localObject2 = ((HashMap)localObject2).values();
        localObject1 = localIterator;
        if (localObject2 != null)
        {
          localIterator = ((Iterable)localObject2).iterator();
          label69:
          int i;
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (((bb)localObject1).adis == 66)
            {
              i = 1;
              label99:
              if (i == 0) {
                break label114;
              }
            }
          }
          for (;;)
          {
            localObject1 = (bb)localObject1;
            break;
            i = 0;
            break label99;
            label114:
            break label69;
            localObject1 = null;
          }
        }
      }
    }
    AppMethodBeat.o(257274);
    return false;
  }
  
  public final void jhq()
  {
    AppMethodBeat.i(257195);
    Log.i("MicroMsg.FolderHelper", "onTabPause");
    if (!this.aflZ)
    {
      AppMethodBeat.o(257195);
      return;
    }
    this.aflZ = false;
    com.tencent.mm.pluginsdk.ui.a.b localb = this.hAo;
    if (localb != null) {
      localb.release();
    }
    if (bh.baz())
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().remove((MStorageEx.IOnStorageChange)this);
    }
    AppMethodBeat.o(257195);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(257227);
    s.u(paramMStorageEx, "stg");
    s.u(paramObject, "obj");
    if (bh.baz())
    {
      bh.bCz();
      if (paramMStorageEx == com.tencent.mm.model.c.ban())
      {
        paramInt = Util.nullAsInt(paramObject, 0);
        if (8193 == paramInt) {
          jAq();
        }
        if (42 != paramInt) {
          break label176;
        }
        jAq();
        AppMethodBeat.o(257227);
        return;
      }
    }
    if ((paramMStorageEx instanceof by))
    {
      paramMStorageEx = (String)paramObject;
      if (paramInt == 5)
      {
        if (au.bwB(paramMStorageEx)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this));
        }
        while (v.Iv(paramMStorageEx)) {
          if (((n)h.ax(n.class)).cJv() == 0)
          {
            bh.bCz();
            com.tencent.mm.model.c.bzG().bxK("conversationboxservice");
            AppMethodBeat.o(257227);
            return;
            jAq();
          }
          else
          {
            ((n)h.ax(n.class)).cJu();
          }
        }
      }
    }
    label176:
    AppMethodBeat.o(257227);
  }
  
  public void onNotifyChange(i parami, i.c paramc)
  {
    int i = 0;
    AppMethodBeat.i(257218);
    int k;
    int j;
    if (paramc != null) {
      if (s.p(paramc.KRm, "insert"))
      {
        k = paramc.mZo.size() - 1;
        if (k >= 0)
        {
          do
          {
            j = i + 1;
            parami = (cc)paramc.mZo.get(i);
            if (parami != null) {
              a(paramc, parami, true);
            }
            i = j;
          } while (j <= k);
          AppMethodBeat.o(257218);
        }
      }
      else if (s.p(paramc.KRm, "update"))
      {
        k = paramc.mZo.size() - 1;
        if (k < 0) {}
      }
    }
    for (i = 0;; i = j)
    {
      j = i + 1;
      parami = (cc)paramc.mZo.get(i);
      if (parami != null) {
        a(paramc, parami, false);
      }
      if (j > k)
      {
        AppMethodBeat.o(257218);
        return;
      }
    }
  }
  
  public void onNotifyUserStatusChange()
  {
    AppMethodBeat.i(257232);
    jAq();
    AppMethodBeat.o(257232);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/FolderHelper$FoldCustomAction;", "", "onCancelAnimation", "", "onEndAnimation", "viewHolder", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter$ViewHolder;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static abstract interface b
  {
    public abstract void jAB();
    
    public abstract void jAC();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(m paramm, cc paramcc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(m paramm, cc paramcc, i.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/conversation/FolderHelper$getExpandAnimators$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Animator.AnimatorListener
  {
    f(bb parambb, m paramm, k.f paramf, ViewGroup.LayoutParams paramLayoutParams) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(256613);
      paramAnimator = this.afpP;
      if (paramAnimator != null) {
        paramAnimator.adis = 2;
      }
      if (m.k(jdField_this) > 0)
      {
        paramAnimator = jdField_this;
        m.c(paramAnimator, m.k(paramAnimator) - 1);
      }
      paramAnimator = m.h(jdField_this);
      if (paramAnimator != null) {
        paramAnimator.MI(false);
      }
      AppMethodBeat.o(256613);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(256609);
      paramAnimator = this.afpP;
      if (paramAnimator != null) {
        paramAnimator.adis = 2;
      }
      m localm = jdField_this;
      paramAnimator = this.afpP;
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = paramAnimator.field_username)
      {
        paramAnimator = localm.bCf(paramAnimator);
        if (paramAnimator != null) {
          paramAnimator.adis = 2;
        }
        paramf.contentView.setAlpha(1.0F);
        paramf.afoQ.setLayoutParams(localLayoutParams);
        paramf.afoO = m.j(jdField_this);
        paramf.afoQ.requestLayout();
        if (m.k(jdField_this) > 0)
        {
          paramAnimator = jdField_this;
          m.c(paramAnimator, m.k(paramAnimator) - 1);
        }
        paramAnimator = m.h(jdField_this);
        if (paramAnimator != null) {
          paramAnimator.MI(false);
        }
        AppMethodBeat.o(256609);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(256617);
      paramAnimator = this.afpP;
      if (paramAnimator != null) {
        paramAnimator.adis = 66;
      }
      paramf.contentView.setAlpha(0.0F);
      paramf.afoQ.setVisibility(0);
      AppMethodBeat.o(256617);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/conversation/FolderHelper$performAllCollapse$action$1", "Lcom/tencent/mm/ui/conversation/FolderHelper$FoldCustomAction;", "onCancelAnimation", "", "onEndAnimation", "viewHolder", "Lcom/tencent/mm/ui/conversation/ConversationWithCacheAdapter$ViewHolder;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements m.b
  {
    h(ah.d paramd, int paramInt, m paramm) {}
    
    public final void jAB()
    {
      AppMethodBeat.i(256581);
      if (this.afpS.aixb == m - 1) {
        m.i(jdField_this);
      }
      int i = this.afpS.aixb;
      this.afpS.aixb = (i + 1);
      AppMethodBeat.o(256581);
    }
    
    public final void jAC()
    {
      AppMethodBeat.i(256584);
      m.i(jdField_this);
      AppMethodBeat.o(256584);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */