package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "forceUpdateOnNextLayout", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollCallback", "", "offset", "getScrollCallback", "setScrollCallback", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutCompleted", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "updateScroll", "updateSelectedChild", "force", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GalleryLayoutManager
  extends LinearLayoutManager
{
  public static final GalleryLayoutManager.a SvY;
  private static final String TAG;
  private boolean DNS;
  public m<? super Integer, ? super View, ah> SvZ;
  public m<? super Integer, ? super Float, ah> Swa;
  private int dyP;
  public int dyx;
  public boolean mmg;
  
  static
  {
    AppMethodBeat.i(119935);
    SvY = new GalleryLayoutManager.a((byte)0);
    TAG = "MicroMsg.GalleryLayoutManager";
    AppMethodBeat.o(119935);
  }
  
  public GalleryLayoutManager(Context paramContext)
  {
    this(paramContext, 1, (byte)0);
    AppMethodBeat.i(119934);
    AppMethodBeat.o(119934);
  }
  
  private GalleryLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt, false);
    AppMethodBeat.i(119932);
    this.dyx = -1;
    this.mmg = true;
    AppMethodBeat.o(119932);
  }
  
  public GalleryLayoutManager(Context paramContext, int paramInt, byte paramByte)
  {
    this(paramContext, paramInt);
    AppMethodBeat.i(119933);
    AppMethodBeat.o(119933);
  }
  
  private final int hzM()
  {
    int i = 0;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(119926);
    if (getChildCount() == 1)
    {
      i = k;
      AppMethodBeat.o(119926);
      return i;
    }
    int m;
    if (super.canScrollHorizontally())
    {
      k = getWidth() / 2;
      m = getChildCount();
      if (m <= 0) {
        break label188;
      }
    }
    for (;;)
    {
      j = i + 1;
      View localView = getChildAt(i);
      s.checkNotNull(localView);
      int n = localView.getLeft();
      localView = getChildAt(i);
      s.checkNotNull(localView);
      if ((n + localView.getRight()) / 2 == k) {
        break;
      }
      if (j >= m)
      {
        i = -1;
        break;
        k = getHeight() / 2;
        m = getChildCount();
        if (m > 0) {}
        for (i = j;; i = j)
        {
          j = i + 1;
          localView = getChildAt(i);
          s.checkNotNull(localView);
          n = localView.getTop();
          localView = getChildAt(i);
          s.checkNotNull(localView);
          if ((n + localView.getBottom()) / 2 == k) {
            break;
          }
          if (j >= m)
          {
            label188:
            i = -1;
            break;
          }
        }
      }
      i = j;
    }
  }
  
  public final void ES(boolean paramBoolean)
  {
    AppMethodBeat.i(119925);
    int i = hzM();
    if (i >= 0)
    {
      View localView = getChildAt(i);
      s.checkNotNull(localView);
      s.s(localView, "getChildAt(selectedChildIndex)!!");
      i = getPosition(localView);
      if ((i != this.dyx) || (paramBoolean))
      {
        this.dyx = i;
        m localm = this.SvZ;
        if (localm != null) {
          localm.invoke(Integer.valueOf(this.dyx), localView);
        }
      }
    }
    AppMethodBeat.o(119925);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(119919);
    if ((this.mmg) && (super.canScrollHorizontally()))
    {
      AppMethodBeat.o(119919);
      return true;
    }
    AppMethodBeat.o(119919);
    return false;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(119920);
    if ((this.mmg) && (getItemCount() > 1) && (super.canScrollVertically()))
    {
      AppMethodBeat.o(119920);
      return true;
    }
    AppMethodBeat.o(119920);
    return false;
  }
  
  public final void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(367256);
    s.u(paramRecyclerView, "recyclerView");
    super.onItemsAdded(paramRecyclerView, paramInt1, paramInt2);
    if ((this.dyx >= paramInt1) && (this.dyx < paramInt1 + paramInt2)) {
      this.DNS = true;
    }
    AppMethodBeat.o(367256);
  }
  
  public final void onItemsChanged(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(367254);
    s.u(paramRecyclerView, "recyclerView");
    Log.i(TAG, "LogStory: onItemsChanged");
    this.DNS = true;
    AppMethodBeat.o(367254);
  }
  
  public final void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(367260);
    s.u(paramRecyclerView, "recyclerView");
    Log.i(TAG, "LogStory: onItemsRemoved " + paramInt1 + ", " + paramInt2);
    super.onItemsRemoved(paramRecyclerView, paramInt1, paramInt2);
    if ((this.dyx >= paramInt1) && (this.dyx < paramInt1 + paramInt2)) {
      this.DNS = true;
    }
    AppMethodBeat.o(367260);
  }
  
  public final void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(367262);
    s.u(paramRecyclerView, "recyclerView");
    Log.i(TAG, "LogStory: onItemsUpdated " + paramInt1 + ", " + paramInt2);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    if ((this.dyx >= paramInt1) && (this.dyx < paramInt1 + paramInt2)) {
      this.DNS = true;
    }
    AppMethodBeat.o(367262);
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(367240);
    Log.i(TAG, "LogStory: onLayoutCompleted");
    super.onLayoutCompleted(params);
    ES(this.DNS);
    this.DNS = false;
    AppMethodBeat.o(367240);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(119922);
    Log.i(TAG, s.X("LogStory: onScrollStateChanged ", Integer.valueOf(paramInt)));
    super.onScrollStateChanged(paramInt);
    this.dyP = paramInt;
    if (this.dyP == 0) {
      ES(false);
    }
    AppMethodBeat.o(119922);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(367246);
    s.u(paramn, "recycler");
    s.u(params, "state");
    int j = super.scrollHorizontallyBy(paramInt, paramn, params);
    int i;
    if (paramInt + 1 <= j) {
      if (j < 0)
      {
        i = 1;
        if ((i != 0) && (this.dyP == 1))
        {
          paramn = getChildAt(0);
          if (paramn != null) {
            break label153;
          }
          paramn = null;
          label70:
          if (!(paramn instanceof RecyclerView)) {
            break label161;
          }
        }
      }
    }
    label153:
    label161:
    for (paramn = (RecyclerView)paramn;; paramn = null)
    {
      Log.i(TAG, "horizontal Drag to end, " + paramInt + ' ' + j + ", " + paramn);
      if (paramn != null) {
        paramn.JO();
      }
      AppMethodBeat.o(367246);
      return j;
      i = 0;
      break;
      i = 0;
      break;
      paramn = paramn.getParent();
      break label70;
    }
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(119931);
    Log.i(TAG, "LogStory: scrollToPosition " + paramInt + ' ' + Util.getStack());
    super.scrollToPosition(paramInt);
    m localm = this.Swa;
    if (localm != null) {
      localm.invoke(Integer.valueOf(paramInt), Float.valueOf(0.0F));
    }
    AppMethodBeat.o(119931);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(367251);
    s.u(paramn, "recycler");
    s.u(params, "state");
    int j = super.scrollVerticallyBy(paramInt, paramn, params);
    Log.i(TAG, "LogStory: vertical " + paramInt + ' ' + j);
    int i;
    label103:
    label115:
    float f;
    if (paramInt + 1 <= j) {
      if (j < 0)
      {
        i = 1;
        if ((i != 0) && (this.dyP == 1))
        {
          paramn = getChildAt(0);
          if (paramn != null) {
            break label245;
          }
          paramn = null;
          if (!(paramn instanceof RecyclerView)) {
            break label253;
          }
          paramn = (RecyclerView)paramn;
          Log.i(TAG, "vertical Drag to end, " + paramInt + ' ' + j + ", " + paramn);
          if (paramn != null) {
            paramn.JO();
          }
        }
        if (getChildCount() != 0)
        {
          if (getChildCount() != 1) {
            break label258;
          }
          paramn = getChildAt(0);
          s.checkNotNull(paramn);
          paramInt = getPosition(paramn);
          f = 0.0F;
        }
      }
    }
    for (;;)
    {
      paramn = this.Swa;
      if (paramn != null) {
        paramn.invoke(Integer.valueOf(paramInt), Float.valueOf(f));
      }
      AppMethodBeat.o(367251);
      return j;
      i = 0;
      break;
      i = 0;
      break;
      label245:
      paramn = paramn.getParent();
      break label103;
      label253:
      paramn = null;
      break label115;
      label258:
      paramn = getChildAt(0);
      s.checkNotNull(paramn);
      s.s(paramn, "getChildAt(0)!!");
      paramInt = getPosition(paramn);
      int k;
      if (canScrollVertically())
      {
        i = getDecoratedTop(paramn);
        k = getDecoratedMeasuredHeight(paramn);
        f = -i / k;
      }
      else
      {
        i = getDecoratedLeft(paramn);
        k = getDecoratedMeasuredWidth(paramn);
        f = -i / k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager
 * JD-Core Version:    0.7.0.1
 */