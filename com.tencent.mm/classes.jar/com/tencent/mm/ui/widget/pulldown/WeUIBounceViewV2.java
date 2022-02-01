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
import com.tencent.mm.ck.a.f;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/WeUIBounceViewV2;", "Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBackgroundContainer", "Landroid/widget/FrameLayout;", "mBackgroundView", "Landroid/view/View;", "mContentContainer", "mContentView", "getMContentView", "()Landroid/view/View;", "setMContentView", "(Landroid/view/View;)V", "mEnd2StartBg", "Landroid/graphics/drawable/Drawable;", "getMEnd2StartBg", "()Landroid/graphics/drawable/Drawable;", "setMEnd2StartBg", "(Landroid/graphics/drawable/Drawable;)V", "mEnd2StartBgByNavigationBar", "getMEnd2StartBgByNavigationBar", "setMEnd2StartBgByNavigationBar", "mStart2EndBg", "getMStart2EndBg", "setMStart2EndBg", "mStart2EndBgByActionBar", "getMStart2EndBgByActionBar", "setMStart2EndBgByActionBar", "getOffset", "", "child", "getView", "initBounce", "", "isBounceEnabled", "", "onStartNestedScroll", "target", "axes", "type", "setAtEndCallback", "callback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "setBg", "drawable", "setBgColor", "color", "setBounceEnabled", "enabled", "setEnd2StartBg", "setEnd2StartBgColor", "setEnd2StartBgColorByNavigationBar", "setOffset", "offset", "setStart2EndBg", "setStart2EndBgColor", "setStart2EndBgColorByActionBar", "setView", "contentView", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WeUIBounceViewV2
  extends NestedBounceView
  implements f
{
  private Drawable agmi;
  private Drawable agmj;
  private Drawable agmk;
  private Drawable agml;
  private View mContentView;
  private FrameLayout tsH;
  private View tyc;
  
  public WeUIBounceViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251966);
    this.agmk = ((Drawable)new ColorDrawable(0));
    this.agml = ((Drawable)new ColorDrawable(0));
    AppMethodBeat.o(251966);
  }
  
  public void P(View paramView, int paramInt)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(252076);
    if (paramInt < 0) {
      if ((getMPullDownEnableFlag() & 0x2) != 0) {
        break label242;
      }
    }
    for (;;)
    {
      View localView = this.tyc;
      j = i;
      Drawable localDrawable;
      if (localView != null)
      {
        localDrawable = this.agmj;
        paramView = localDrawable;
        if (localDrawable == null) {
          paramView = this.agml;
        }
        localView.setBackground(paramView);
      }
      for (;;)
      {
        paramView = j.aglL;
        if (j.jIW()) {
          new StringBuilder("[setOffset] offset:").append(paramInt).append(" offsetFinal:").append(i).append(" flag:").append(getMPullDownEnableFlag());
        }
        paramView = j.aglL;
        j.jIX().P((View)this.tsH, i);
        paramView = getMBounceOffsetChangedListeners().iterator();
        while (paramView.hasNext())
        {
          ((f.a)paramView.next()).Wm(i);
          continue;
          if (paramInt <= 0) {
            break label237;
          }
          if ((getMPullDownEnableFlag() & 0x1) != 0) {
            break label232;
          }
        }
        label232:
        for (i = j;; i = paramInt)
        {
          localView = this.tyc;
          j = i;
          if (localView != null)
          {
            localDrawable = this.agmi;
            paramView = localDrawable;
            if (localDrawable == null) {
              paramView = this.agmk;
            }
            localView.setBackground(paramView);
            j = i;
          }
          i = j;
          break;
          AppMethodBeat.o(252076);
          return;
        }
        label237:
        i = paramInt;
      }
      label242:
      i = paramInt;
    }
  }
  
  public final void a(a parama, View paramView)
  {
    AppMethodBeat.i(252061);
    if (paramView != null)
    {
      s.u(paramView, "<this>");
      paramView.setTag(a.f.weui_at_end_callback, parama);
    }
    AppMethodBeat.o(252061);
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252071);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    if (!getMIsEnabled())
    {
      paramView1 = j.aglL;
      if (j.jIW()) {
        s.X("[onStartNestedScroll] mIsEnabled:", Boolean.valueOf(getMIsEnabled()));
      }
      AppMethodBeat.o(252071);
      return false;
    }
    boolean bool = super.a(paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(252071);
    return bool;
  }
  
  public final int cI(View paramView)
  {
    AppMethodBeat.i(252079);
    paramView = j.aglL;
    int i = j.jIX().cI((View)this.tsH);
    AppMethodBeat.o(252079);
    return i;
  }
  
  protected final View getMContentView()
  {
    return this.mContentView;
  }
  
  public final Drawable getMEnd2StartBg()
  {
    return this.agmj;
  }
  
  public final Drawable getMEnd2StartBgByNavigationBar()
  {
    return this.agml;
  }
  
  public final Drawable getMStart2EndBg()
  {
    return this.agmi;
  }
  
  public final Drawable getMStart2EndBgByActionBar()
  {
    return this.agmk;
  }
  
  public int getOffset()
  {
    AppMethodBeat.i(252066);
    int i = cI(null);
    AppMethodBeat.o(252066);
    return i;
  }
  
  public View getView()
  {
    return (View)this;
  }
  
  public final void jIK()
  {
    AppMethodBeat.i(252057);
    Object localObject2 = this.mContentView;
    if ((localObject2 instanceof ViewGroup))
    {
      Object localObject1 = new LinkedList();
      ((LinkedList)localObject1).add(localObject2);
      while (!((LinkedList)localObject1).isEmpty())
      {
        localObject2 = ((LinkedList)localObject1).pollFirst();
        s.s(localObject2, "queue.pollFirst()");
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
          int k = ((ViewGroup)localObject2).getChildCount();
          if (k > 0) {
            for (;;)
            {
              int j = i + 1;
              if ((((ViewGroup)localObject2).getChildAt(i) instanceof ViewGroup))
              {
                View localView = ((ViewGroup)localObject2).getChildAt(i);
                if (localView == null)
                {
                  localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                  AppMethodBeat.o(252057);
                  throw ((Throwable)localObject1);
                }
                ((LinkedList)localObject1).addLast((ViewGroup)localView);
              }
              if (j >= k) {
                break;
              }
              i = j;
            }
          }
        }
      }
    }
    AppMethodBeat.o(252057);
  }
  
  public void setBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(252050);
    s.u(paramDrawable, "drawable");
    setStart2EndBg(paramDrawable);
    setEnd2StartBg(paramDrawable);
    AppMethodBeat.o(252050);
  }
  
  public void setBgColor(int paramInt)
  {
    AppMethodBeat.i(252027);
    setStart2EndBgColor(paramInt);
    setEnd2StartBgColor(paramInt);
    AppMethodBeat.o(252027);
  }
  
  public void setBounceEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(252017);
    setMIsEnabled(paramBoolean);
    AppMethodBeat.o(252017);
  }
  
  public void setEnd2StartBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(252036);
    s.u(paramDrawable, "drawable");
    this.agmj = paramDrawable;
    AppMethodBeat.o(252036);
  }
  
  public void setEnd2StartBgColor(int paramInt)
  {
    AppMethodBeat.i(252021);
    this.agmj = ((Drawable)new ColorDrawable(paramInt));
    AppMethodBeat.o(252021);
  }
  
  public void setEnd2StartBgColorByNavigationBar(int paramInt)
  {
    AppMethodBeat.i(252045);
    this.agml = ((Drawable)new ColorDrawable(paramInt));
    AppMethodBeat.o(252045);
  }
  
  protected final void setMContentView(View paramView)
  {
    this.mContentView = paramView;
  }
  
  public final void setMEnd2StartBg(Drawable paramDrawable)
  {
    this.agmj = paramDrawable;
  }
  
  public final void setMEnd2StartBgByNavigationBar(Drawable paramDrawable)
  {
    AppMethodBeat.i(252007);
    s.u(paramDrawable, "<set-?>");
    this.agml = paramDrawable;
    AppMethodBeat.o(252007);
  }
  
  public final void setMStart2EndBg(Drawable paramDrawable)
  {
    this.agmi = paramDrawable;
  }
  
  public final void setMStart2EndBgByActionBar(Drawable paramDrawable)
  {
    AppMethodBeat.i(252002);
    s.u(paramDrawable, "<set-?>");
    this.agmk = paramDrawable;
    AppMethodBeat.o(252002);
  }
  
  public void setStart2EndBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(252032);
    s.u(paramDrawable, "drawable");
    this.agmi = paramDrawable;
    AppMethodBeat.o(252032);
  }
  
  public void setStart2EndBgColor(int paramInt)
  {
    AppMethodBeat.i(252020);
    this.agmi = ((Drawable)new ColorDrawable(paramInt));
    AppMethodBeat.o(252020);
  }
  
  public void setStart2EndBgColorByActionBar(int paramInt)
  {
    AppMethodBeat.i(252041);
    this.agmk = ((Drawable)new ColorDrawable(paramInt));
    AppMethodBeat.o(252041);
  }
  
  public void setView(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(252014);
    this.mContentView = paramView;
    this.tsH = new FrameLayout(getContext());
    Object localObject1 = this.tsH;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    Object localObject2;
    int i;
    if (paramView != null)
    {
      localObject2 = paramView.getLayoutParams();
      if (localObject2 != null) {
        break label232;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label245;
      }
      i = 1;
      label78:
      if (i == 0) {
        break label263;
      }
      i = -1;
      label84:
      if (localObject2 != null) {
        break label272;
      }
      localObject1 = null;
      label92:
      if (localObject1 != null) {
        break label285;
      }
      label97:
      if (j == 0) {
        break label298;
      }
    }
    label263:
    label272:
    label285:
    label298:
    for (j = -1;; j = ((ViewGroup.LayoutParams)localObject2).height)
    {
      localObject1 = new FrameLayout.LayoutParams(i, j);
      localObject2 = this.tsH;
      if (localObject2 != null) {
        ((FrameLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      }
      paramView = new NestedScrollView(getContext());
      paramView.setOverScrollMode(2);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramView.addView((View)new LinearLayout(getContext()), new ViewGroup.LayoutParams(-1, -1));
      paramView.setImportantForAccessibility(2);
      this.tyc = ((View)paramView);
      addView((View)paramView);
      addView((View)this.tsH);
      AppMethodBeat.o(252014);
      return;
      label232:
      localObject1 = Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width);
      break;
      label245:
      if (((Integer)localObject1).intValue() == 0)
      {
        i = 1;
        break label78;
      }
      i = 0;
      break label78;
      i = ((ViewGroup.LayoutParams)localObject2).width;
      break label84;
      localObject1 = Integer.valueOf(((ViewGroup.LayoutParams)localObject2).height);
      break label92;
      if (((Integer)localObject1).intValue() == 0) {
        break label97;
      }
      j = 0;
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.WeUIBounceViewV2
 * JD-Core Version:    0.7.0.1
 */