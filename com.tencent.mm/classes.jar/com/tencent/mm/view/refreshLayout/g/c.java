package com.tencent.mm.view.refreshLayout.g;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.view.refreshLayout.b.g;
import com.tencent.mm.view.refreshLayout.f.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/widget/RefreshBoundaryDecider;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IScrollBoundaryDecider;", "()V", "boundary", "mActionEvent", "Landroid/graphics/PointF;", "mEnableLoadMoreWhenContentNotFull", "", "canLoadMore", "content", "Landroid/view/View;", "targetView", "touch", "contentFull", "canRefresh", "isTransformedTouchPointInView", "group", "child", "x", "", "y", "outLocalPoint", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements g
{
  public PointF agRr;
  public g agRs;
  public boolean agRt = true;
  
  private final boolean a(View paramView, PointF paramPointF)
  {
    AppMethodBeat.i(235122);
    if (paramView == null)
    {
      AppMethodBeat.o(235122);
      return false;
    }
    if ((paramView.canScrollVertically(-1)) && (paramView.getVisibility() == 0))
    {
      AppMethodBeat.o(235122);
      return false;
    }
    int i;
    PointF localPointF;
    if (((paramView instanceof ViewGroup)) && (paramPointF != null))
    {
      i = ((ViewGroup)paramView).getChildCount();
      localPointF = new PointF();
      if (i <= 0) {}
    }
    for (;;)
    {
      int j = i - 1;
      View localView = ((ViewGroup)paramView).getChildAt(i - 1);
      s.s(localView, "child");
      if (a(paramView, localView, paramPointF.x, paramPointF.y, localPointF))
      {
        paramView = localView.getTag(a.g.wx_rl_tag);
        if ((s.p("fixed", paramView)) || (s.p("fixed-bottom", paramView)))
        {
          AppMethodBeat.o(235122);
          return false;
        }
        paramPointF.offset(localPointF.x, localPointF.y);
        boolean bool = a(localView, paramPointF);
        paramPointF.offset(-localPointF.x, -localPointF.y);
        AppMethodBeat.o(235122);
        return bool;
      }
      if (j <= 0)
      {
        AppMethodBeat.o(235122);
        return true;
      }
      i = j;
    }
  }
  
  private final boolean a(View paramView, PointF paramPointF, boolean paramBoolean)
  {
    AppMethodBeat.i(235131);
    if (paramView == null)
    {
      AppMethodBeat.o(235131);
      return false;
    }
    if ((paramView.canScrollVertically(1)) && (paramView.getVisibility() == 0))
    {
      AppMethodBeat.o(235131);
      return false;
    }
    Object localObject;
    int i;
    if (((paramView instanceof ViewGroup)) && (paramPointF != null))
    {
      localObject = a.agRg;
      if (!a.mF(paramView))
      {
        i = ((ViewGroup)paramView).getChildCount();
        localObject = new PointF();
        if (i <= 0) {}
      }
    }
    for (;;)
    {
      int j = i - 1;
      View localView = ((ViewGroup)paramView).getChildAt(i - 1);
      s.s(localView, "child");
      if (a(paramView, localView, paramPointF.x, paramPointF.y, (PointF)localObject))
      {
        paramView = localView.getTag(a.g.wx_rl_tag);
        if ((s.p("fixed", paramView)) || (s.p("fixed-top", paramView)))
        {
          AppMethodBeat.o(235131);
          return false;
        }
        paramPointF.offset(((PointF)localObject).x, ((PointF)localObject).y);
        paramBoolean = a(localView, paramPointF, paramBoolean);
        paramPointF.offset(-((PointF)localObject).x, -((PointF)localObject).y);
        AppMethodBeat.o(235131);
        return paramBoolean;
      }
      if (j <= 0)
      {
        if ((paramBoolean) || (paramView.canScrollVertically(-1)))
        {
          AppMethodBeat.o(235131);
          return true;
        }
        AppMethodBeat.o(235131);
        return false;
      }
      i = j;
    }
  }
  
  public static boolean a(View paramView1, View paramView2, float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    AppMethodBeat.i(235116);
    s.u(paramView1, "group");
    s.u(paramView2, "child");
    if (paramView2.getVisibility() != 0)
    {
      AppMethodBeat.o(235116);
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[0] = (arrayOfFloat[0] + paramView1.getScrollX() - paramView2.getLeft());
    arrayOfFloat[1] = (arrayOfFloat[1] + paramView1.getScrollY() - paramView2.getTop());
    if ((arrayOfFloat[0] >= 0.0F) && (arrayOfFloat[1] >= 0.0F) && (arrayOfFloat[0] < paramView2.getWidth()) && (arrayOfFloat[1] < paramView2.getHeight())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        paramPointF.set(arrayOfFloat[0] - paramFloat1, arrayOfFloat[1] - paramFloat2);
      }
      AppMethodBeat.o(235116);
      return bool;
    }
  }
  
  public final boolean mD(View paramView)
  {
    AppMethodBeat.i(235138);
    Object localObject = this.agRs;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Boolean.valueOf(((g)localObject).mD(paramView)))
    {
      bool = a(paramView, this.agRr);
      AppMethodBeat.o(235138);
      return bool;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(235138);
    return bool;
  }
  
  public final boolean mE(View paramView)
  {
    AppMethodBeat.i(235143);
    Object localObject = this.agRs;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Boolean.valueOf(((g)localObject).mE(paramView)))
    {
      bool = a(paramView, this.agRr, this.agRt);
      AppMethodBeat.o(235143);
      return bool;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(235143);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.g.c
 * JD-Core Version:    0.7.0.1
 */