package com.tencent.mm.ui.chatting.monitor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.b;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.c;
import com.tencent.mm.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/monitor/ChatFeedMonitor;", "", "()V", "TAG", "", "chatFooterHeight", "", "listeners", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "Lkotlin/collections/ArrayList;", "mActionBarHeight", "mChatFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "Lkotlin/collections/HashMap;", "mFirstPostion", "mScreenHeight", "mScreenRealHeight", "mStatusBarHeight", "mVisibleItemCount", "virtualKeyHeight", "_getHellFeed", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "feedView", "Landroid/view/View;", "position", "listView", "Landroid/widget/AbsListView;", "firstPos", "_getLiveFeedUIParams", "view", "getY", "init", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initActionBarHeight", "Landroid/app/Activity;", "initScreenHeight", "initStatusBarHeight", "monitor", "adapter", "Landroid/widget/BaseAdapter;", "firstPostion", "visibleItemCount", "onFeedAppear", "feed", "onFeedDisappear", "registerListener", "listener", "resetCache", "unregisterListener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ChatFeedMonitor
{
  public static final ChatFeedMonitor INSTANCE;
  private static final String TAG = "HABBYGE-MALI.ChatFeedMonitor";
  private static int chatFooterHeight;
  private static final ArrayList<com.tencent.mm.plugin.expt.hellhound.ext.f.a> listeners;
  private static int mActionBarHeight;
  private static final HashMap<String, com.tencent.mm.plugin.expt.hellhound.ext.a.c> mChatFeedCache;
  private static int mFirstPostion;
  private static int mScreenHeight;
  private static int mScreenRealHeight;
  private static int mStatusBarHeight;
  private static int mVisibleItemCount;
  private static int virtualKeyHeight;
  
  static
  {
    AppMethodBeat.i(253828);
    INSTANCE = new ChatFeedMonitor();
    listeners = new ArrayList();
    mChatFeedCache = new HashMap();
    mFirstPostion = -1;
    mVisibleItemCount = -1;
    AppMethodBeat.o(253828);
  }
  
  private final com.tencent.mm.vending.j.c<com.tencent.mm.plugin.expt.hellhound.ext.a.c, Boolean> _getHellFeed(View paramView, int paramInt1, AbsListView paramAbsListView, int paramInt2)
  {
    AppMethodBeat.i(253785);
    if ((ListAdapter)paramAbsListView.getAdapter() == null)
    {
      AppMethodBeat.o(253785);
      return null;
    }
    int j = paramInt2 + paramInt1;
    if (j >= ((ListAdapter)paramAbsListView.getAdapter()).getCount())
    {
      AppMethodBeat.o(253785);
      return null;
    }
    Object localObject9 = ((ListAdapter)paramAbsListView.getAdapter()).getItem(j);
    if (localObject9 == null)
    {
      AppMethodBeat.o(253785);
      return null;
    }
    if (!(localObject9 instanceof cc))
    {
      AppMethodBeat.o(253785);
      return null;
    }
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(253785);
      return null;
    }
    if (!(paramView.getTag() instanceof ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder))
    {
      AppMethodBeat.o(253785);
      return null;
    }
    Object localObject1 = paramView.getTag();
    if (localObject1 == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder");
      AppMethodBeat.o(253785);
      throw paramView;
    }
    Object localObject6 = ((ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)localObject1).chattingItem;
    if (localObject6 == null)
    {
      AppMethodBeat.o(253785);
      return null;
    }
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    localObject1 = null;
    paramInt2 = -1;
    Object localObject7;
    int i;
    if (((localObject6 instanceof ChatingItemAppMsgFinderLiveFeed.c)) || ((localObject6 instanceof ChatingItemAppMsgFinderLiveFeed.b)))
    {
      localObject6 = ((cc)localObject9).field_content;
      if (localObject6 != null)
      {
        localObject8 = k.b.aP((String)localObject6, ((cc)localObject9).field_reserved);
        if (localObject8 == null) {
          break label809;
        }
        localObject1 = (com.tencent.mm.plugin.findersdk.a.b)((k.b)localObject8).aK(com.tencent.mm.plugin.findersdk.a.b.class);
        if (localObject1 == null)
        {
          AppMethodBeat.o(253785);
          return null;
        }
      }
      else
      {
        AppMethodBeat.o(253785);
        return null;
      }
      localObject1 = ((com.tencent.mm.plugin.findersdk.a.b)localObject1).HbV;
      String str2 = ((bmr)localObject1).feedId;
      String str1 = ((bmr)localObject1).liveId;
      localObject7 = ((bmr)localObject1).username;
      localObject6 = ((bmr)localObject1).nickName;
      i = ((bmr)localObject1).liveStatus;
      Object localObject8 = ((k.b)localObject8).hQQ;
      paramInt2 = i;
      localObject1 = localObject8;
      localObject2 = localObject6;
      localObject3 = localObject7;
      localObject4 = str1;
      localObject5 = str2;
      if (!Util.isNullOrNil((String)localObject8)) {
        break label809;
      }
      paramInt2 = i;
      localObject1 = localObject8;
      localObject2 = localObject6;
      localObject3 = localObject7;
      localObject4 = str1;
      localObject5 = str2;
      if (((cc)localObject9).field_isSend != 1) {
        break label809;
      }
      h.baC();
      localObject1 = com.tencent.mm.kernel.b.getUserName();
      localObject5 = str2;
      localObject4 = str1;
      localObject3 = localObject7;
      localObject2 = localObject6;
    }
    for (;;)
    {
      paramView = _getLiveFeedUIParams(paramView);
      localObject6 = (Integer)paramView.get(0);
      localObject7 = (Integer)paramView.get(1);
      paramView = new com.tencent.mm.plugin.expt.hellhound.ext.a.c();
      paramView.msgId = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((cc)localObject9).field_msgId);
      paramView.zDL = ((String)localObject1);
      paramView.zDG = new fed();
      paramView.zDG.feedId = localObject5;
      paramView.liveId = localObject4;
      paramView.liveStatus = i;
      paramView.zDG.userName = localObject3;
      paramView.zDG.nickName = localObject2;
      if (TextUtils.isEmpty((CharSequence)paramView.zDG.feedId)) {
        paramView.zDG.feedId = String.valueOf(paramAbsListView.getItemIdAtPosition(j));
      }
      paramAbsListView = paramView.zDG;
      s.s(localObject6, "y");
      paramAbsListView.y = ((Integer)localObject6).intValue();
      paramAbsListView = paramView.zDG;
      s.s(localObject7, "height");
      paramAbsListView.height = ((Integer)localObject7).intValue();
      paramView.zDG.pvg = mScreenRealHeight;
      paramView.zDG.virtualKeyHeight = (mScreenRealHeight - mScreenHeight);
      paramView.zDG.vpn = mStatusBarHeight;
      paramAbsListView = paramView.zDG;
      int m;
      int n;
      boolean bool;
      if (mActionBarHeight <= 0)
      {
        paramInt2 = 144;
        paramAbsListView.BqU = paramInt2;
        paramView.position = j;
        paramView.zDH = paramInt1;
        paramView.chatFooterHeight = chatFooterHeight;
        paramInt1 = paramView.zDG.vpn;
        paramInt2 = paramView.zDG.BqU;
        i = paramView.zDG.pvg;
        j = paramView.zDG.virtualKeyHeight;
        int k = paramView.chatFooterHeight;
        m = paramView.zDG.y;
        n = paramView.zDG.height;
        if (paramView.zDG.y < i - j - k) {
          break label785;
        }
        bool = false;
      }
      for (;;)
      {
        paramView = com.tencent.mm.vending.j.a.U(paramView, Boolean.valueOf(bool));
        AppMethodBeat.o(253785);
        return paramView;
        AppMethodBeat.o(253785);
        return null;
        paramInt2 = mActionBarHeight;
        break;
        label785:
        if (m + n <= paramInt1 + paramInt2) {
          bool = false;
        } else {
          bool = true;
        }
      }
      label809:
      i = paramInt2;
    }
  }
  
  private final com.tencent.mm.vending.j.c<Integer, Integer> _getLiveFeedUIParams(View paramView)
  {
    AppMethodBeat.i(253790);
    int i = getY(paramView);
    float f = paramView.getY();
    int k = d.e(paramView.getContext(), 6.0F);
    int j = Math.max(i, (int)f) + k;
    i = j;
    if (paramView.getHeight() > 721) {
      i = j + 107;
    }
    paramView = com.tencent.mm.vending.j.a.U(Integer.valueOf(i), Integer.valueOf(721 - k * 2));
    s.s(paramView, "make(y, height)");
    AppMethodBeat.o(253790);
    return paramView;
  }
  
  private final int getY(View paramView)
  {
    AppMethodBeat.i(253793);
    int i = 0;
    int[] arrayOfInt = new int[2];
    while (i < 2)
    {
      arrayOfInt[i] = -1;
      i += 1;
    }
    paramView.getLocationOnScreen(arrayOfInt);
    i = arrayOfInt[1];
    AppMethodBeat.o(253793);
    return i;
  }
  
  private final void init(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(253802);
    initStatusBarHeight((Activity)paramAppCompatActivity);
    initActionBarHeight((Activity)paramAppCompatActivity);
    initScreenHeight((Activity)paramAppCompatActivity);
    Log.i("HABBYGE-MALI.ChatFeedMonitor", "init: mScreenRealHeight=" + mScreenRealHeight + ", mScreenHeight=" + mScreenHeight + ", mStatusBarHeight=" + mStatusBarHeight + ", mActionBarHeight=" + mActionBarHeight + ", chatFooterHeight=" + chatFooterHeight + ", virtualKeyHeight=" + virtualKeyHeight);
    AppMethodBeat.o(253802);
  }
  
  private final void initActionBarHeight(Activity paramActivity)
  {
    AppMethodBeat.i(253808);
    if (paramActivity == null)
    {
      AppMethodBeat.o(253808);
      return;
    }
    for (;;)
    {
      try
      {
        if (!(paramActivity instanceof AppCompatActivity)) {
          continue;
        }
        paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
        if (paramActivity == null)
        {
          paramActivity = null;
          break label92;
          mActionBarHeight = i;
          AppMethodBeat.o(253808);
        }
        else
        {
          paramActivity = paramActivity.getCustomView();
        }
      }
      catch (Exception paramActivity)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ChatFeedMonitor", (Throwable)paramActivity, "initBarHeight", new Object[0]);
        AppMethodBeat.o(253808);
        return;
      }
      int i = paramActivity.getHeight();
      continue;
      label92:
      if (paramActivity == null) {
        i = -1;
      }
    }
  }
  
  private final void initScreenHeight(Activity paramActivity)
  {
    Object localObject3 = null;
    AppMethodBeat.i(253815);
    if (paramActivity == null)
    {
      AppMethodBeat.o(253815);
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = MMApplicationContext.getContext().getSystemService("window");
        if (!(localObject1 instanceof WindowManager)) {
          continue;
        }
        localObject1 = (WindowManager)localObject1;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2 = paramActivity.getWindowManager();
        if (localObject2 != null) {
          continue;
        }
        localObject2 = null;
        continue;
        localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
        continue;
        Point localPoint1 = new Point();
        if (Build.VERSION.SDK_INT < 13) {
          continue;
        }
        ((Display)localObject2).getSize(localPoint1);
        Point localPoint2 = new Point();
        if (Build.VERSION.SDK_INT < 17) {
          continue;
        }
        ((Display)localObject2).getRealSize(localPoint2);
        mScreenHeight = localPoint1.y;
        i = localPoint2.y;
        mScreenRealHeight = i;
        i -= mScreenHeight;
        if (i <= 0) {
          break;
        }
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(253815);
        return;
        localObject1 = null;
        continue;
        localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      }
      else
      {
        virtualKeyHeight = i;
        paramActivity = paramActivity.getResources();
        if (paramActivity != null) {
          break label219;
        }
        paramActivity = localObject3;
        label189:
        if (paramActivity != null) {
          break label233;
        }
      }
    }
    label219:
    label233:
    for (int i = d.e(MMApplicationContext.getContext(), 56.0F);; i = paramActivity.intValue())
    {
      chatFooterHeight = i;
      AppMethodBeat.o(253815);
      return;
      i = 0;
      break;
      paramActivity = Integer.valueOf(paramActivity.getDimensionPixelSize(R.f.Edge_7A));
      break label189;
    }
  }
  
  private final void initStatusBarHeight(Activity paramActivity)
  {
    AppMethodBeat.i(253804);
    if (paramActivity == null)
    {
      AppMethodBeat.o(253804);
      return;
    }
    paramActivity = paramActivity.getResources();
    int i = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    mStatusBarHeight = i;
    if (i <= 0) {
      mStatusBarHeight = paramActivity.getDimensionPixelSize(b.b.expt_sns_statusbar_height);
    }
    AppMethodBeat.o(253804);
  }
  
  public static final void monitor(AbsListView paramAbsListView, BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253775);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(253775);
      return;
    }
    if (paramBaseAdapter == null)
    {
      AppMethodBeat.o(253775);
      return;
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (mScreenHeight <= 0)
    {
      localObject2 = INSTANCE;
      localObject1 = paramAbsListView.getContext();
      if ((localObject1 instanceof AppCompatActivity))
      {
        localObject1 = (AppCompatActivity)localObject1;
        ((ChatFeedMonitor)localObject2).init((AppCompatActivity)localObject1);
      }
    }
    else
    {
      if ((paramInt1 >= 0) && (paramInt2 > 0))
      {
        mFirstPostion = paramInt1;
        mVisibleItemCount = paramInt2;
      }
      i = mVisibleItemCount;
      if (i <= 0) {}
    }
    label256:
    label308:
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1 + 1;
      localObject1 = paramAbsListView.getChildAt(paramInt1);
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = INSTANCE._getHellFeed((View)localObject1, paramInt1, paramAbsListView, mFirstPostion);
        if (localObject3 != null)
        {
          localObject2 = (com.tencent.mm.plugin.expt.hellhound.ext.a.c)((com.tencent.mm.vending.j.b)localObject3).get(0);
          localObject3 = (Boolean)((com.tencent.mm.vending.j.c)localObject3).get(1);
          s.s(localObject3, "isShow");
          if (!((Boolean)localObject3).booleanValue()) {
            break label256;
          }
          if (!mChatFeedCache.containsKey(((com.tencent.mm.plugin.expt.hellhound.ext.a.c)localObject2).msgId))
          {
            localObject3 = (Map)mChatFeedCache;
            String str = ((com.tencent.mm.plugin.expt.hellhound.ext.a.c)localObject2).msgId;
            s.s(str, "chatFeed.msgId");
            s.s(localObject2, "chatFeed");
            ((Map)localObject3).put(str, localObject2);
            INSTANCE.onFeedAppear(paramBaseAdapter, (com.tencent.mm.plugin.expt.hellhound.ext.a.c)localObject2, (View)localObject1);
          }
        }
      }
      for (;;)
      {
        if (paramInt2 < i) {
          break label308;
        }
        AppMethodBeat.o(253775);
        return;
        localObject1 = null;
        break;
        if (mChatFeedCache.containsKey(((com.tencent.mm.plugin.expt.hellhound.ext.a.c)localObject2).msgId))
        {
          mChatFeedCache.remove(((com.tencent.mm.plugin.expt.hellhound.ext.a.c)localObject2).msgId);
          localObject3 = INSTANCE;
          s.s(localObject2, "chatFeed");
          ((ChatFeedMonitor)localObject3).onFeedDisappear(paramBaseAdapter, (com.tencent.mm.plugin.expt.hellhound.ext.a.c)localObject2, (View)localObject1);
        }
      }
    }
  }
  
  private final void onFeedAppear(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.ext.a.c paramc, View paramView)
  {
    AppMethodBeat.i(253796);
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.expt.hellhound.ext.f.a)localIterator.next()).a(paramBaseAdapter, paramc, paramView);
    }
    AppMethodBeat.o(253796);
  }
  
  private final void onFeedDisappear(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.ext.a.c paramc, View paramView)
  {
    AppMethodBeat.i(253799);
    paramBaseAdapter = listeners.iterator();
    while (paramBaseAdapter.hasNext()) {
      paramBaseAdapter.next();
    }
    AppMethodBeat.o(253799);
  }
  
  public static final void registerListener(com.tencent.mm.plugin.expt.hellhound.ext.f.a parama)
  {
    AppMethodBeat.i(253819);
    if (parama == null)
    {
      AppMethodBeat.o(253819);
      return;
    }
    if (!listeners.contains(parama)) {
      listeners.add(parama);
    }
    AppMethodBeat.o(253819);
  }
  
  private final void resetCache()
  {
    AppMethodBeat.i(253824);
    mFirstPostion = -1;
    mVisibleItemCount = -1;
    mChatFeedCache.clear();
    AppMethodBeat.o(253824);
  }
  
  public static final void unregisterListener(com.tencent.mm.plugin.expt.hellhound.ext.f.a parama)
  {
    AppMethodBeat.i(253822);
    INSTANCE.resetCache();
    if (parama == null)
    {
      AppMethodBeat.o(253822);
      return;
    }
    listeners.remove(parama);
    AppMethodBeat.o(253822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.monitor.ChatFeedMonitor
 * JD-Core Version:    0.7.0.1
 */