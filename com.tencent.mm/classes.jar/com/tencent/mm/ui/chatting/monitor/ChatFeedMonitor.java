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
import androidx.annotation.Keep;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.a;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.b;
import com.tencent.mm.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/monitor/ChatFeedMonitor;", "", "()V", "TAG", "", "chatFooterHeight", "", "listeners", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "Lkotlin/collections/ArrayList;", "mActionBarHeight", "mChatFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "Lkotlin/collections/HashMap;", "mFirstPostion", "mScreenHeight", "mScreenRealHeight", "mStatusBarHeight", "mVisibleItemCount", "virtualKeyHeight", "_getHellFeed", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "feedView", "Landroid/view/View;", "position", "listView", "Landroid/widget/AbsListView;", "firstPos", "_getLiveFeedUIParams", "view", "getY", "init", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initActionBarHeight", "Landroid/app/Activity;", "initScreenHeight", "initStatusBarHeight", "monitor", "adapter", "Landroid/widget/BaseAdapter;", "firstPostion", "visibleItemCount", "onFeedAppear", "feed", "onFeedDisappear", "registerListener", "listener", "resetCache", "unregisterListener", "app_release"})
@Keep
public final class ChatFeedMonitor
{
  public static final ChatFeedMonitor INSTANCE;
  private static final String TAG = "HABBYGE-MALI.ChatFeedMonitor";
  private static int chatFooterHeight;
  private static final ArrayList<com.tencent.mm.plugin.expt.hellhound.a.g.a> listeners;
  private static int mActionBarHeight;
  private static final HashMap<String, com.tencent.mm.plugin.expt.hellhound.a.a.c> mChatFeedCache;
  private static int mFirstPostion;
  private static int mScreenHeight;
  private static int mScreenRealHeight;
  private static int mStatusBarHeight;
  private static int mVisibleItemCount;
  private static int virtualKeyHeight;
  
  static
  {
    AppMethodBeat.i(284356);
    INSTANCE = new ChatFeedMonitor();
    listeners = new ArrayList();
    mChatFeedCache = new HashMap();
    mFirstPostion = -1;
    mVisibleItemCount = -1;
    AppMethodBeat.o(284356);
  }
  
  private final com.tencent.mm.vending.j.c<com.tencent.mm.plugin.expt.hellhound.a.a.c, Boolean> _getHellFeed(View paramView, int paramInt1, AbsListView paramAbsListView, int paramInt2)
  {
    AppMethodBeat.i(284341);
    if ((ListAdapter)paramAbsListView.getAdapter() == null)
    {
      AppMethodBeat.o(284341);
      return null;
    }
    int i = paramInt2 + paramInt1;
    Object localObject1 = (ListAdapter)paramAbsListView.getAdapter();
    p.j(localObject1, "listView.adapter");
    if (i >= ((ListAdapter)localObject1).getCount())
    {
      AppMethodBeat.o(284341);
      return null;
    }
    Object localObject2 = ((ListAdapter)paramAbsListView.getAdapter()).getItem(i);
    if (localObject2 == null)
    {
      AppMethodBeat.o(284341);
      return null;
    }
    if (!(localObject2 instanceof ca))
    {
      AppMethodBeat.o(284341);
      return null;
    }
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(284341);
      return null;
    }
    if (!(paramView.getTag() instanceof ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder))
    {
      AppMethodBeat.o(284341);
      return null;
    }
    localObject1 = paramView.getTag();
    if (localObject1 == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder");
      AppMethodBeat.o(284341);
      throw paramView;
    }
    Object localObject3 = ((ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)localObject1).chattingItem;
    if (localObject3 == null)
    {
      AppMethodBeat.o(284341);
      return null;
    }
    String str3 = null;
    String str2 = null;
    String str1 = null;
    localObject1 = null;
    if (((localObject3 instanceof ChatingItemAppMsgFinderLiveFeed.b)) || ((localObject3 instanceof ChatingItemAppMsgFinderLiveFeed.a)))
    {
      localObject3 = ((ca)localObject2).getContent();
      if (localObject3 != null)
      {
        localObject3 = k.b.aG((String)localObject3, ((ca)localObject2).apL());
        if (localObject3 == null) {
          break label603;
        }
        localObject1 = (com.tencent.mm.plugin.findersdk.a.b)((k.b)localObject3).ar(com.tencent.mm.plugin.findersdk.a.b.class);
        if (localObject1 == null)
        {
          AppMethodBeat.o(284341);
          return null;
        }
      }
      else
      {
        AppMethodBeat.o(284341);
        return null;
      }
      localObject3 = ((com.tencent.mm.plugin.findersdk.a.b)localObject1).Bvb;
      str3 = ((bcp)localObject3).feedId;
      str2 = ((bcp)localObject3).kwM;
      str1 = ((bcp)localObject3).username;
      localObject1 = ((bcp)localObject3).nickName;
    }
    label603:
    for (paramInt2 = ((bcp)localObject3).liveStatus;; paramInt2 = -1)
    {
      paramView = _getLiveFeedUIParams(paramView);
      localObject3 = (Integer)paramView.ieT();
      Integer localInteger = (Integer)paramView.ieU();
      paramView = new com.tencent.mm.plugin.expt.hellhound.a.a.c();
      paramView.msgId = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((ca)localObject2).apG());
      paramView.whE = new ejv();
      paramView.whE.feedId = str3;
      paramView.kwM = str2;
      paramView.liveStatus = paramInt2;
      paramView.whE.userName = str1;
      paramView.whE.nickName = ((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)paramView.whE.feedId)) {
        paramView.whE.feedId = String.valueOf(paramAbsListView.getItemIdAtPosition(i));
      }
      paramAbsListView = paramView.whE;
      p.j(localObject3, "y");
      paramAbsListView.y = ((Integer)localObject3).intValue();
      paramAbsListView = paramView.whE;
      p.j(localInteger, "height");
      paramAbsListView.height = localInteger.intValue();
      paramView.whE.pEk = mScreenRealHeight;
      paramView.whE.virtualKeyHeight = (mScreenRealHeight - mScreenHeight);
      paramView.whE.INC = mStatusBarHeight;
      paramAbsListView = paramView.whE;
      if (mActionBarHeight <= 0) {}
      for (paramInt2 = 144;; paramInt2 = mActionBarHeight)
      {
        paramAbsListView.xRu = paramInt2;
        paramView.position = i;
        paramView.whF = paramInt1;
        paramView.chatFooterHeight = chatFooterHeight;
        paramView = com.tencent.mm.vending.j.a.J(paramView, Boolean.valueOf(paramView.dds()));
        AppMethodBeat.o(284341);
        return paramView;
        AppMethodBeat.o(284341);
        return null;
      }
    }
  }
  
  private final com.tencent.mm.vending.j.c<Integer, Integer> _getLiveFeedUIParams(View paramView)
  {
    AppMethodBeat.i(284342);
    int i = getY(paramView);
    float f = paramView.getY();
    int k = d.e(paramView.getContext(), 6.0F);
    int j = Math.max(i, (int)f) + k;
    i = j;
    if (paramView.getHeight() > 721) {
      i = j + 107;
    }
    paramView = com.tencent.mm.vending.j.a.J(Integer.valueOf(i), Integer.valueOf(721 - k * 2));
    p.j(paramView, "Tuple.make(y, height)");
    AppMethodBeat.o(284342);
    return paramView;
  }
  
  private final int getY(View paramView)
  {
    AppMethodBeat.i(284343);
    int[] arrayOfInt = new int[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfInt[i] = -1;
      i += 1;
    }
    paramView.getLocationOnScreen(arrayOfInt);
    i = arrayOfInt[1];
    AppMethodBeat.o(284343);
    return i;
  }
  
  private final void init(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(284346);
    initStatusBarHeight((Activity)paramAppCompatActivity);
    initActionBarHeight((Activity)paramAppCompatActivity);
    initScreenHeight((Activity)paramAppCompatActivity);
    Log.i("HABBYGE-MALI.ChatFeedMonitor", "init: mScreenRealHeight=" + mScreenRealHeight + ", mScreenHeight=" + mScreenHeight + ", mStatusBarHeight=" + mStatusBarHeight + ", mActionBarHeight=" + mActionBarHeight + ", chatFooterHeight=" + chatFooterHeight + ", virtualKeyHeight=" + virtualKeyHeight);
    AppMethodBeat.o(284346);
  }
  
  private final void initActionBarHeight(Activity paramActivity)
  {
    AppMethodBeat.i(284350);
    if (paramActivity == null)
    {
      AppMethodBeat.o(284350);
      return;
    }
    try
    {
      if ((paramActivity instanceof AppCompatActivity))
      {
        paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
        if (paramActivity != null)
        {
          paramActivity = paramActivity.getCustomView();
          if (paramActivity == null) {
            break label66;
          }
        }
        label66:
        for (int i = paramActivity.getHeight();; i = -1)
        {
          mActionBarHeight = i;
          AppMethodBeat.o(284350);
          return;
          paramActivity = null;
          break;
        }
      }
      return;
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("HABBYGE-MALI.ChatFeedMonitor", (Throwable)paramActivity, "initBarHeight", new Object[0]);
      AppMethodBeat.o(284350);
    }
  }
  
  private final void initScreenHeight(Activity paramActivity)
  {
    Point localPoint = null;
    AppMethodBeat.i(284351);
    if (paramActivity == null)
    {
      AppMethodBeat.o(284351);
      return;
    }
    for (;;)
    {
      try
      {
        localObject3 = MMApplicationContext.getContext().getSystemService("window");
        localObject1 = localObject3;
        if (!(localObject3 instanceof WindowManager)) {
          localObject1 = null;
        }
        localObject1 = (WindowManager)localObject1;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3 = paramActivity.getWindowManager();
        Object localObject2 = localPoint;
        if (localObject3 == null) {
          continue;
        }
        localObject2 = ((WindowManager)localObject3).getDefaultDisplay();
        continue;
        localPoint = new Point();
        if (Build.VERSION.SDK_INT < 13) {
          continue;
        }
        ((Display)localObject2).getSize(localPoint);
        localObject3 = new Point();
        if (Build.VERSION.SDK_INT < 17) {
          continue;
        }
        ((Display)localObject2).getRealSize((Point)localObject3);
        mScreenHeight = localPoint.y;
        i = ((Point)localObject3).y;
        mScreenRealHeight = i;
        i -= mScreenHeight;
        if (i <= 0) {
          break;
        }
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(284351);
        return;
        localObject1 = null;
      }
      else
      {
        virtualKeyHeight = i;
        paramActivity = paramActivity.getResources();
        if (paramActivity == null) {
          break label213;
        }
      }
    }
    label213:
    for (int i = paramActivity.getDimensionPixelSize(R.f.Edge_7A);; i = d.e(MMApplicationContext.getContext(), 56.0F))
    {
      chatFooterHeight = i;
      AppMethodBeat.o(284351);
      return;
      i = 0;
      break;
    }
  }
  
  private final void initStatusBarHeight(Activity paramActivity)
  {
    AppMethodBeat.i(284348);
    if (paramActivity == null)
    {
      AppMethodBeat.o(284348);
      return;
    }
    paramActivity = paramActivity.getResources();
    int i = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    mStatusBarHeight = i;
    if (i <= 0) {
      mStatusBarHeight = paramActivity.getDimensionPixelSize(b.b.expt_sns_statusbar_height);
    }
    AppMethodBeat.o(284348);
  }
  
  @Keep
  public static final void monitor(AbsListView paramAbsListView, BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284340);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(284340);
      return;
    }
    if (paramBaseAdapter == null)
    {
      AppMethodBeat.o(284340);
      return;
    }
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if (mScreenHeight <= 0)
    {
      localObject3 = INSTANCE;
      localObject2 = paramAbsListView.getContext();
      localObject1 = localObject2;
      if (!(localObject2 instanceof AppCompatActivity)) {
        localObject1 = null;
      }
      ((ChatFeedMonitor)localObject3).init((AppCompatActivity)localObject1);
    }
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      mFirstPostion = paramInt1;
      mVisibleItemCount = paramInt2;
    }
    paramInt2 = mVisibleItemCount;
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      localObject1 = paramAbsListView.getChildAt(paramInt1);
      if (localObject1 == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        localObject3 = INSTANCE._getHellFeed((View)localObject1, paramInt1, paramAbsListView, mFirstPostion);
        if (localObject3 != null)
        {
          localObject2 = (com.tencent.mm.plugin.expt.hellhound.a.a.c)((com.tencent.mm.vending.j.c)localObject3).ieT();
          localObject3 = (Boolean)((com.tencent.mm.vending.j.c)localObject3).ieU();
          p.j(localObject3, "isShow");
          if (((Boolean)localObject3).booleanValue())
          {
            if (!mChatFeedCache.containsKey(((com.tencent.mm.plugin.expt.hellhound.a.a.c)localObject2).msgId))
            {
              localObject3 = (Map)mChatFeedCache;
              String str = ((com.tencent.mm.plugin.expt.hellhound.a.a.c)localObject2).msgId;
              p.j(str, "chatFeed.msgId");
              p.j(localObject2, "chatFeed");
              ((Map)localObject3).put(str, localObject2);
              INSTANCE.onFeedAppear(paramBaseAdapter, (com.tencent.mm.plugin.expt.hellhound.a.a.c)localObject2, (View)localObject1);
            }
          }
          else if (mChatFeedCache.containsKey(((com.tencent.mm.plugin.expt.hellhound.a.a.c)localObject2).msgId))
          {
            mChatFeedCache.remove(((com.tencent.mm.plugin.expt.hellhound.a.a.c)localObject2).msgId);
            localObject3 = INSTANCE;
            p.j(localObject2, "chatFeed");
            ((ChatFeedMonitor)localObject3).onFeedDisappear(paramBaseAdapter, (com.tencent.mm.plugin.expt.hellhound.a.a.c)localObject2, (View)localObject1);
          }
        }
      }
    }
    AppMethodBeat.o(284340);
  }
  
  private final void onFeedAppear(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.a.a.c paramc, View paramView)
  {
    AppMethodBeat.i(284344);
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.expt.hellhound.a.g.a)localIterator.next()).a(paramBaseAdapter, paramc, paramView);
    }
    AppMethodBeat.o(284344);
  }
  
  private final void onFeedDisappear(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.a.a.c paramc, View paramView)
  {
    AppMethodBeat.i(284345);
    paramBaseAdapter = listeners.iterator();
    while (paramBaseAdapter.hasNext()) {
      paramBaseAdapter.next();
    }
    AppMethodBeat.o(284345);
  }
  
  @Keep
  public static final void registerListener(com.tencent.mm.plugin.expt.hellhound.a.g.a parama)
  {
    AppMethodBeat.i(284352);
    if (parama == null)
    {
      AppMethodBeat.o(284352);
      return;
    }
    if (!listeners.contains(parama)) {
      listeners.add(parama);
    }
    AppMethodBeat.o(284352);
  }
  
  private final void resetCache()
  {
    AppMethodBeat.i(284355);
    mFirstPostion = -1;
    mVisibleItemCount = -1;
    mChatFeedCache.clear();
    AppMethodBeat.o(284355);
  }
  
  @Keep
  public static final void unregisterListener(com.tencent.mm.plugin.expt.hellhound.a.g.a parama)
  {
    AppMethodBeat.i(284354);
    INSTANCE.resetCache();
    if (parama == null)
    {
      AppMethodBeat.o(284354);
      return;
    }
    listeners.remove(parama);
    AppMethodBeat.o(284354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.monitor.ChatFeedMonitor
 * JD-Core Version:    0.7.0.1
 */