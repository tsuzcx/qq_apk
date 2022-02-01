package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class AnimatedExpandableListView
  extends ExpandableListView
{
  private static final String TAG;
  private a agij;
  
  static
  {
    AppMethodBeat.i(159432);
    TAG = a.class.getSimpleName();
    AppMethodBeat.o(159432);
  }
  
  public AnimatedExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimatedExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getAnimationDuration()
  {
    return 150;
  }
  
  public final boolean aFi(int paramInt)
  {
    AppMethodBeat.i(159429);
    int i = getFlatListPosition(getPackedPositionForGroup(paramInt));
    if (i != -1)
    {
      i -= getFirstVisiblePosition();
      if ((i < getChildCount()) && (getChildAt(i).getBottom() >= getBottom()))
      {
        this.agij.aFl(paramInt);
        bool = expandGroup(paramInt);
        AppMethodBeat.o(159429);
        return bool;
      }
    }
    a.a(this.agij, paramInt);
    boolean bool = expandGroup(paramInt);
    AppMethodBeat.o(159429);
    return bool;
  }
  
  public final boolean aFj(int paramInt)
  {
    AppMethodBeat.i(159430);
    int i = getFlatListPosition(getPackedPositionForGroup(paramInt));
    if (i != -1)
    {
      i -= getFirstVisiblePosition();
      if ((i >= 0) && (i < getChildCount()))
      {
        if (getChildAt(i).getBottom() >= getBottom())
        {
          bool = collapseGroup(paramInt);
          AppMethodBeat.o(159430);
          return bool;
        }
      }
      else
      {
        bool = collapseGroup(paramInt);
        AppMethodBeat.o(159430);
        return bool;
      }
    }
    long l = getExpandableListPosition(getFirstVisiblePosition());
    i = getPackedPositionChild(l);
    int j = getPackedPositionGroup(l);
    if ((i == -1) || (j != paramInt)) {
      i = 0;
    }
    a.a(this.agij, paramInt, i);
    this.agij.notifyDataSetChanged();
    boolean bool = isGroupExpanded(paramInt);
    AppMethodBeat.o(159430);
    return bool;
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    AppMethodBeat.i(159428);
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof a))
    {
      this.agij = ((a)paramExpandableListAdapter);
      a.a(this.agij, this);
      AppMethodBeat.o(159428);
      return;
    }
    paramExpandableListAdapter = new ClassCastException(paramExpandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
    AppMethodBeat.o(159428);
    throw paramExpandableListAdapter;
  }
  
  public static abstract class a
    extends BaseExpandableListAdapter
  {
    private SparseArray<AnimatedExpandableListView.d> agik = new SparseArray();
    private AnimatedExpandableListView agil;
    
    private AnimatedExpandableListView.d aFk(int paramInt)
    {
      AnimatedExpandableListView.d locald2 = (AnimatedExpandableListView.d)this.agik.get(paramInt);
      AnimatedExpandableListView.d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new AnimatedExpandableListView.d((byte)0);
        this.agik.put(paramInt, locald1);
      }
      return locald1;
    }
    
    public final void aFl(int paramInt)
    {
      aFk(paramInt).agiw = -1;
    }
    
    public abstract int amf(int paramInt);
    
    public abstract View d(int paramInt1, int paramInt2, View paramView);
    
    public final int getChildType(int paramInt1, int paramInt2)
    {
      if (aFk(paramInt1).animating) {
        return 0;
      }
      return 1;
    }
    
    public final int getChildTypeCount()
    {
      return 2;
    }
    
    public final View getChildView(final int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      final AnimatedExpandableListView.d locald = aFk(paramInt1);
      if (locald.animating)
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
        if (paramInt2 < locald.agiv) {
          paramView.getLayoutParams().height = 0;
        }
        final ExpandableListView localExpandableListView;
        final AnimatedExpandableListView.b localb;
        int i;
        label243:
        do
        {
          return paramView;
          localExpandableListView = (ExpandableListView)paramViewGroup;
          localb = (AnimatedExpandableListView.b)paramView;
          localb.FaY.clear();
          AnimatedExpandableListView.b.a(localb, localExpandableListView.getDivider(), paramViewGroup.getMeasuredWidth(), localExpandableListView.getDividerHeight());
          int k = View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824);
          int m = View.MeasureSpec.makeMeasureSpec(0, 0);
          paramInt2 = 0;
          int n = paramViewGroup.getHeight();
          int i1 = amf(paramInt1);
          int j = locald.agiv;
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
            localb.ml(paramViewGroup);
            j += 1;
          }
          localb.ml(paramViewGroup);
          i = paramInt2 + (i1 - j - 1) * (paramInt2 / (j + 1));
          paramViewGroup = localb.getTag();
          if (paramViewGroup == null) {}
          for (paramInt2 = 0; (locald.agiu) && (paramInt2 != 1); paramInt2 = ((Integer)paramViewGroup).intValue())
          {
            paramViewGroup = new AnimatedExpandableListView.c(localb, 0, i, locald, (byte)0);
            paramViewGroup.setDuration(AnimatedExpandableListView.a(this.agil));
            paramViewGroup.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                AppMethodBeat.i(159418);
                AnimatedExpandableListView.a.b(AnimatedExpandableListView.a.this, paramInt1);
                AnimatedExpandableListView.a.this.notifyDataSetChanged();
                localb.setTag(Integer.valueOf(0));
                AppMethodBeat.o(159418);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
              
              public final void onAnimationStart(Animation paramAnonymousAnimation) {}
            });
            localb.startAnimation(paramViewGroup);
            localb.setTag(Integer.valueOf(1));
            return paramView;
          }
        } while ((locald.agiu) || (paramInt2 == 2));
        if (locald.agiw == -1) {
          locald.agiw = i;
        }
        paramViewGroup = new AnimatedExpandableListView.c(localb, locald.agiw, 0, locald, (byte)0);
        paramViewGroup.setDuration(AnimatedExpandableListView.a(this.agil));
        paramViewGroup.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(159419);
            AnimatedExpandableListView.a.b(AnimatedExpandableListView.a.this, paramInt1);
            localExpandableListView.collapseGroup(paramInt1);
            AnimatedExpandableListView.a.this.notifyDataSetChanged();
            locald.agiw = -1;
            localb.setTag(Integer.valueOf(0));
            AppMethodBeat.o(159419);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        localb.startAnimation(paramViewGroup);
        localb.setTag(Integer.valueOf(2));
        return paramView;
        return d(paramInt1, paramInt2, paramView);
      }
    }
    
    public final int getChildrenCount(int paramInt)
    {
      AnimatedExpandableListView.d locald = aFk(paramInt);
      if (locald.animating) {
        return locald.agiv + 1;
      }
      return amf(paramInt);
    }
  }
  
  static final class c
    extends Animation
  {
    private int agir;
    private int agis;
    private AnimatedExpandableListView.d agit;
    private View view;
    
    private c(View paramView, int paramInt1, int paramInt2, AnimatedExpandableListView.d paramd)
    {
      AppMethodBeat.i(159426);
      this.agir = paramInt1;
      this.agis = (paramInt2 - paramInt1);
      this.view = paramView;
      this.agit = paramd;
      this.view.getLayoutParams().height = paramInt1;
      this.view.requestLayout();
      AppMethodBeat.o(159426);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(159427);
      super.applyTransformation(paramFloat, paramTransformation);
      if (paramFloat < 1.0F)
      {
        i = this.agir + (int)(this.agis * paramFloat);
        this.view.getLayoutParams().height = i;
        this.agit.agiw = i;
        this.view.requestLayout();
        AppMethodBeat.o(159427);
        return;
      }
      int i = this.agir + this.agis;
      this.view.getLayoutParams().height = i;
      this.agit.agiw = i;
      this.view.requestLayout();
      AppMethodBeat.o(159427);
    }
  }
  
  static final class d
  {
    boolean agiu = false;
    int agiv;
    int agiw = -1;
    boolean animating = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView
 * JD-Core Version:    0.7.0.1
 */