package com.tencent.mm.ui.widget.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class AnimatedExpandableListView
  extends ExpandableListView
{
  private static final String TAG = AnimatedExpandableListView.a.class.getSimpleName();
  private AnimatedExpandableListView.a wnJ;
  
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
  
  @SuppressLint({"NewApi"})
  public final boolean Iw(int paramInt)
  {
    int i = getFlatListPosition(getPackedPositionForGroup(paramInt));
    if (i != -1)
    {
      i -= getFirstVisiblePosition();
      if ((i < getChildCount()) && (getChildAt(i).getBottom() >= getBottom()))
      {
        this.wnJ.Iy(paramInt).wnX = -1;
        return expandGroup(paramInt);
      }
    }
    AnimatedExpandableListView.a.a(this.wnJ, paramInt);
    return expandGroup(paramInt);
  }
  
  public final boolean Ix(int paramInt)
  {
    int i = getFlatListPosition(getPackedPositionForGroup(paramInt));
    if (i != -1)
    {
      i -= getFirstVisiblePosition();
      if ((i >= 0) && (i < getChildCount()))
      {
        if (getChildAt(i).getBottom() >= getBottom()) {
          return collapseGroup(paramInt);
        }
      }
      else {
        return collapseGroup(paramInt);
      }
    }
    long l = getExpandableListPosition(getFirstVisiblePosition());
    i = getPackedPositionChild(l);
    int j = getPackedPositionGroup(l);
    if ((i == -1) || (j != paramInt)) {
      i = 0;
    }
    AnimatedExpandableListView.a.a(this.wnJ, paramInt, i);
    this.wnJ.notifyDataSetChanged();
    return isGroupExpanded(paramInt);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof AnimatedExpandableListView.a))
    {
      this.wnJ = ((AnimatedExpandableListView.a)paramExpandableListAdapter);
      AnimatedExpandableListView.a.a(this.wnJ, this);
      return;
    }
    throw new ClassCastException(paramExpandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView
 * JD-Core Version:    0.7.0.1
 */