package com.tencent.mm.ui.widget.pulldown;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.f;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/WeUIBounceViewV2;", "Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBackgroundContainer", "Landroid/widget/FrameLayout;", "mBackgroundView", "Landroid/view/View;", "mContentContainer", "mContentView", "mEnd2StartBg", "Landroid/graphics/drawable/Drawable;", "getMEnd2StartBg", "()Landroid/graphics/drawable/Drawable;", "setMEnd2StartBg", "(Landroid/graphics/drawable/Drawable;)V", "mEnd2StartBgByNavigationBar", "getMEnd2StartBgByNavigationBar", "setMEnd2StartBgByNavigationBar", "mPullDownEnableFlag", "", "mStart2EndBg", "getMStart2EndBg", "setMStart2EndBg", "mStart2EndBgByActionBar", "getMStart2EndBgByActionBar", "setMStart2EndBgByActionBar", "checkInterceptScroll", "", "deltaY", "enableEnd2Start", "", "enable", "enableStart2End", "getOffset", "child", "getView", "initBounce", "isBounceEnabled", "onStartNestedScroll", "target", "axes", "type", "setAtEndCallback", "callback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "setBg", "drawable", "setBgColor", "color", "setBounceEnabled", "enabled", "setEnd2StartBg", "setEnd2StartBgColor", "setEnd2StartBgColorByNavigationBar", "setOffset", "offset", "setStart2EndBg", "setStart2EndBgColor", "setStart2EndBgColorByActionBar", "setView", "bgView", "contentView", "weui-native-android-lib_release"})
public class WeUIBounceViewV2
  extends NestedBounceView
  implements e
{
  private int YtP;
  private Drawable YtQ;
  private Drawable YtR;
  private Drawable YtS;
  private Drawable YtT;
  private View mContentView;
  private FrameLayout qoa;
  private View qtw;
  private FrameLayout qtx;
  
  public WeUIBounceViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251351);
    this.YtP = 3;
    this.YtS = ((Drawable)new ColorDrawable(0));
    this.YtT = ((Drawable)new ColorDrawable(0));
    AppMethodBeat.o(251351);
  }
  
  public final void HO(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = this.YtP | 0x1;; i = this.YtP & 0xFFFFFFFE)
    {
      this.YtP = i;
      return;
    }
  }
  
  public final void K(View paramView, int paramInt)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(251347);
    if (paramInt < 0) {
      if ((this.YtP & 0x2) != 0) {
        break label236;
      }
    }
    for (;;)
    {
      View localView = this.qtw;
      Drawable localDrawable;
      if (localView != null)
      {
        localDrawable = this.YtR;
        paramView = localDrawable;
        if (localDrawable == null) {
          paramView = this.YtT;
        }
        localView.setBackground(paramView);
      }
      for (;;)
      {
        paramView = i.YtH;
        if (i.idO()) {
          new StringBuilder("[setOffset] offset:").append(paramInt).append(" offsetFinal:").append(i).append(" flag:").append(this.YtP);
        }
        paramView = i.YtH;
        i.idP().K((View)this.qoa, i);
        paramView = getMBounceOffsetChangedListeners().iterator();
        for (;;)
        {
          if (paramView.hasNext())
          {
            ((e.a)paramView.next()).alg(i);
            continue;
            break;
            if (paramInt <= 0) {
              break label231;
            }
            if ((this.YtP & 0x1) != 0) {
              break label226;
            }
          }
        }
        label226:
        for (i = j;; i = paramInt)
        {
          localView = this.qtw;
          if (localView != null)
          {
            localDrawable = this.YtQ;
            paramView = localDrawable;
            if (localDrawable == null) {
              paramView = this.YtS;
            }
            localView.setBackground(paramView);
            break;
          }
          break;
          AppMethodBeat.o(251347);
          return;
        }
        label231:
        i = paramInt;
      }
      label236:
      i = paramInt;
    }
  }
  
  public final void a(a parama, View paramView)
  {
    AppMethodBeat.i(251339);
    if (paramView != null)
    {
      p.k(paramView, "$this$setAtEndCallback");
      paramView.setTag(a.f.weui_at_end_callback, parama);
      AppMethodBeat.o(251339);
      return;
    }
    AppMethodBeat.o(251339);
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251345);
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    if (!getMIsEnabled())
    {
      paramView1 = i.YtH;
      if (i.idO()) {
        new StringBuilder("[onStartNestedScroll] mIsEnabled:").append(getMIsEnabled());
      }
      AppMethodBeat.o(251345);
      return false;
    }
    boolean bool = super.a(paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(251345);
    return bool;
  }
  
  protected final boolean ayS(int paramInt)
  {
    if ((paramInt > 0) && ((this.YtP & 0x1) != 0)) {}
    while ((paramInt < 0) && ((this.YtP & 0x2) != 0)) {
      return true;
    }
    return false;
  }
  
  public final int cm(View paramView)
  {
    AppMethodBeat.i(251349);
    paramView = i.YtH;
    int i = i.idP().cm((View)this.qoa);
    AppMethodBeat.o(251349);
    return i;
  }
  
  public final Drawable getMEnd2StartBg()
  {
    return this.YtR;
  }
  
  public final Drawable getMEnd2StartBgByNavigationBar()
  {
    return this.YtT;
  }
  
  public final Drawable getMStart2EndBg()
  {
    return this.YtQ;
  }
  
  public final Drawable getMStart2EndBgByActionBar()
  {
    return this.YtS;
  }
  
  public int getOffset()
  {
    AppMethodBeat.i(293019);
    int i = cm(null);
    AppMethodBeat.o(293019);
    return i;
  }
  
  public View getView()
  {
    return (View)this;
  }
  
  public final void h(View paramView1, View paramView2)
  {
    AppMethodBeat.i(251318);
    this.qtw = paramView1;
    this.qtx = new FrameLayout(getContext());
    FrameLayout localFrameLayout = this.qtx;
    if (localFrameLayout != null) {
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    localFrameLayout = this.qtx;
    if (localFrameLayout != null) {
      localFrameLayout.addView(paramView1);
    }
    this.mContentView = paramView2;
    this.qoa = new FrameLayout(getContext());
    paramView1 = this.qoa;
    if (paramView1 != null) {
      paramView1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    int i;
    if (paramView2 != null)
    {
      paramView1 = paramView2.getLayoutParams();
      if (paramView1 == null) {
        break label262;
      }
      i = paramView1.width;
      if (paramView1 == null) {
        break label267;
      }
    }
    label262:
    label267:
    for (int j = paramView1.height;; j = -1)
    {
      paramView1 = new FrameLayout.LayoutParams(i, j);
      localFrameLayout = this.qoa;
      if (localFrameLayout != null) {
        localFrameLayout.addView(paramView2, (ViewGroup.LayoutParams)paramView1);
      }
      paramView1 = new NestedScrollView(getContext());
      paramView1.setOverScrollMode(2);
      paramView1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramView1.addView((View)new LinearLayout(getContext()), new ViewGroup.LayoutParams(-1, -1));
      addView((View)paramView1);
      addView((View)this.qtx);
      addView((View)this.qoa);
      AppMethodBeat.o(251318);
      return;
      i = -1;
      break;
    }
  }
  
  public final void idC()
  {
    AppMethodBeat.i(251337);
    Object localObject2 = this.mContentView;
    if ((localObject2 instanceof ViewGroup))
    {
      Object localObject1 = new LinkedList();
      ((LinkedList)localObject1).add(localObject2);
      while (!((LinkedList)localObject1).isEmpty())
      {
        localObject2 = ((LinkedList)localObject1).pollFirst();
        p.j(localObject2, "queue.pollFirst()");
        localObject2 = (View)localObject2;
        if ((localObject2 instanceof AbsListView))
        {
          ((AbsListView)localObject2).setNestedScrollingEnabled(true);
          ((AbsListView)localObject2).setOverScrollMode(2);
        }
        else if ((localObject2 instanceof RecyclerView))
        {
          ((RecyclerView)localObject2).setNestedScrollingEnabled(true);
          ((RecyclerView)localObject2).setOverScrollMode(2);
        }
        else if ((localObject2 instanceof ScrollView))
        {
          ((ScrollView)localObject2).setNestedScrollingEnabled(true);
          ((ScrollView)localObject2).setOverScrollMode(2);
          if (getMCompatScrollViewChild() == null) {
            setMCompatScrollViewChild((ScrollView)localObject2);
          }
        }
        else if ((localObject2 instanceof ViewGroup))
        {
          int i = 0;
          int j = ((ViewGroup)localObject2).getChildCount();
          while (i < j)
          {
            if ((((ViewGroup)localObject2).getChildAt(i) instanceof ViewGroup))
            {
              View localView = ((ViewGroup)localObject2).getChildAt(i);
              if (localView == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(251337);
                throw ((Throwable)localObject1);
              }
              ((LinkedList)localObject1).addLast((ViewGroup)localView);
            }
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(251337);
  }
  
  public void setBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(251335);
    p.k(paramDrawable, "drawable");
    setStart2EndBg(paramDrawable);
    setEnd2StartBg(paramDrawable);
    AppMethodBeat.o(251335);
  }
  
  public void setBgColor(int paramInt)
  {
    AppMethodBeat.i(251327);
    setStart2EndBgColor(paramInt);
    setEnd2StartBgColor(paramInt);
    AppMethodBeat.o(251327);
  }
  
  public void setBounceEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(251319);
    setMIsEnabled(paramBoolean);
    AppMethodBeat.o(251319);
  }
  
  public void setEnd2StartBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(251329);
    p.k(paramDrawable, "drawable");
    this.YtR = paramDrawable;
    AppMethodBeat.o(251329);
  }
  
  public void setEnd2StartBgColor(int paramInt)
  {
    AppMethodBeat.i(251325);
    this.YtR = ((Drawable)new ColorDrawable(paramInt));
    AppMethodBeat.o(251325);
  }
  
  public void setEnd2StartBgColorByNavigationBar(int paramInt)
  {
    AppMethodBeat.i(251332);
    this.YtT = ((Drawable)new ColorDrawable(paramInt));
    AppMethodBeat.o(251332);
  }
  
  public final void setMEnd2StartBg(Drawable paramDrawable)
  {
    this.YtR = paramDrawable;
  }
  
  public final void setMEnd2StartBgByNavigationBar(Drawable paramDrawable)
  {
    AppMethodBeat.i(251316);
    p.k(paramDrawable, "<set-?>");
    this.YtT = paramDrawable;
    AppMethodBeat.o(251316);
  }
  
  public final void setMStart2EndBg(Drawable paramDrawable)
  {
    this.YtQ = paramDrawable;
  }
  
  public final void setMStart2EndBgByActionBar(Drawable paramDrawable)
  {
    AppMethodBeat.i(251314);
    p.k(paramDrawable, "<set-?>");
    this.YtS = paramDrawable;
    AppMethodBeat.o(251314);
  }
  
  public void setStart2EndBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(251328);
    p.k(paramDrawable, "drawable");
    this.YtQ = paramDrawable;
    AppMethodBeat.o(251328);
  }
  
  public void setStart2EndBgColor(int paramInt)
  {
    AppMethodBeat.i(251323);
    this.YtQ = ((Drawable)new ColorDrawable(paramInt));
    AppMethodBeat.o(251323);
  }
  
  public void setStart2EndBgColorByActionBar(int paramInt)
  {
    AppMethodBeat.i(251331);
    this.YtS = ((Drawable)new ColorDrawable(paramInt));
    AppMethodBeat.o(251331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.WeUIBounceViewV2
 * JD-Core Version:    0.7.0.1
 */