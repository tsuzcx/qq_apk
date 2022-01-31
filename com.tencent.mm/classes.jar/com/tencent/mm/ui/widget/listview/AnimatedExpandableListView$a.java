package com.tencent.mm.ui.widget.listview;

import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import java.util.List;

public abstract class AnimatedExpandableListView$a
  extends BaseExpandableListAdapter
{
  private SparseArray<AnimatedExpandableListView.d> AHD = new SparseArray();
  private AnimatedExpandableListView AHE;
  
  private AnimatedExpandableListView.d Rq(int paramInt)
  {
    AnimatedExpandableListView.d locald2 = (AnimatedExpandableListView.d)this.AHD.get(paramInt);
    AnimatedExpandableListView.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new AnimatedExpandableListView.d((byte)0);
      this.AHD.put(paramInt, locald1);
    }
    return locald1;
  }
  
  public abstract int ET(int paramInt);
  
  public final void Rr(int paramInt)
  {
    Rq(paramInt).AHQ = -1;
  }
  
  public abstract View d(int paramInt1, int paramInt2, View paramView);
  
  public final int getChildType(int paramInt1, int paramInt2)
  {
    if (Rq(paramInt1).nhm) {
      return 0;
    }
    return 1;
  }
  
  public final int getChildTypeCount()
  {
    return 2;
  }
  
  public final View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    AnimatedExpandableListView.d locald = Rq(paramInt1);
    if (locald.nhm)
    {
      if ((paramView instanceof AnimatedExpandableListView.b)) {
        break label457;
      }
      paramView = new AnimatedExpandableListView.b(paramViewGroup.getContext(), (byte)0);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
    }
    label457:
    for (;;)
    {
      if (paramInt2 < locald.AHP) {
        paramView.getLayoutParams().height = 0;
      }
      ExpandableListView localExpandableListView;
      AnimatedExpandableListView.b localb;
      int i;
      label243:
      do
      {
        return paramView;
        localExpandableListView = (ExpandableListView)paramViewGroup;
        localb = (AnimatedExpandableListView.b)paramView;
        localb.AHJ.clear();
        AnimatedExpandableListView.b.a(localb, localExpandableListView.getDivider(), paramViewGroup.getMeasuredWidth(), localExpandableListView.getDividerHeight());
        int k = View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824);
        int m = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = 0;
        int n = paramViewGroup.getHeight();
        int i1 = ET(paramInt1);
        int j = locald.AHP;
        for (;;)
        {
          i = paramInt2;
          if (j >= i1) {
            break label243;
          }
          paramViewGroup = d(paramInt1, j, null);
          paramViewGroup.measure(k, m);
          paramInt2 += paramViewGroup.getMeasuredHeight();
          if (paramInt2 >= n) {
            break;
          }
          localb.fw(paramViewGroup);
          j += 1;
        }
        localb.fw(paramViewGroup);
        i = paramInt2 + (i1 - j - 1) * (paramInt2 / (j + 1));
        paramViewGroup = localb.getTag();
        if (paramViewGroup == null) {}
        for (paramInt2 = 0; (locald.AHO) && (paramInt2 != 1); paramInt2 = ((Integer)paramViewGroup).intValue())
        {
          paramViewGroup = new AnimatedExpandableListView.c(localb, 0, i, locald, (byte)0);
          paramViewGroup.setDuration(AnimatedExpandableListView.a(this.AHE));
          paramViewGroup.setAnimationListener(new AnimatedExpandableListView.a.1(this, paramInt1, localb));
          localb.startAnimation(paramViewGroup);
          localb.setTag(Integer.valueOf(1));
          return paramView;
        }
      } while ((locald.AHO) || (paramInt2 == 2));
      if (locald.AHQ == -1) {
        locald.AHQ = i;
      }
      paramViewGroup = new AnimatedExpandableListView.c(localb, locald.AHQ, 0, locald, (byte)0);
      paramViewGroup.setDuration(AnimatedExpandableListView.a(this.AHE));
      paramViewGroup.setAnimationListener(new AnimatedExpandableListView.a.2(this, paramInt1, localExpandableListView, locald, localb));
      localb.startAnimation(paramViewGroup);
      localb.setTag(Integer.valueOf(2));
      return paramView;
      return d(paramInt1, paramInt2, paramView);
    }
  }
  
  public final int getChildrenCount(int paramInt)
  {
    AnimatedExpandableListView.d locald = Rq(paramInt);
    if (locald.nhm) {
      return locald.AHP + 1;
    }
    return ET(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a
 * JD-Core Version:    0.7.0.1
 */