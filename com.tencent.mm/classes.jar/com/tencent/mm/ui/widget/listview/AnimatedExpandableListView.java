package com.tencent.mm.ui.widget.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AnimatedExpandableListView
  extends ExpandableListView
{
  private static final String TAG;
  private AnimatedExpandableListView.a AHC;
  
  static
  {
    AppMethodBeat.i(112723);
    TAG = AnimatedExpandableListView.a.class.getSimpleName();
    AppMethodBeat.o(112723);
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
  
  @SuppressLint({"NewApi"})
  public final boolean Ro(int paramInt)
  {
    AppMethodBeat.i(112720);
    int i = getFlatListPosition(getPackedPositionForGroup(paramInt));
    if (i != -1)
    {
      i -= getFirstVisiblePosition();
      if ((i < getChildCount()) && (getChildAt(i).getBottom() >= getBottom()))
      {
        this.AHC.Rr(paramInt);
        bool = expandGroup(paramInt);
        AppMethodBeat.o(112720);
        return bool;
      }
    }
    AnimatedExpandableListView.a.a(this.AHC, paramInt);
    boolean bool = expandGroup(paramInt);
    AppMethodBeat.o(112720);
    return bool;
  }
  
  public final boolean Rp(int paramInt)
  {
    AppMethodBeat.i(112721);
    int i = getFlatListPosition(getPackedPositionForGroup(paramInt));
    if (i != -1)
    {
      i -= getFirstVisiblePosition();
      if ((i >= 0) && (i < getChildCount()))
      {
        if (getChildAt(i).getBottom() >= getBottom())
        {
          bool = collapseGroup(paramInt);
          AppMethodBeat.o(112721);
          return bool;
        }
      }
      else
      {
        bool = collapseGroup(paramInt);
        AppMethodBeat.o(112721);
        return bool;
      }
    }
    long l = getExpandableListPosition(getFirstVisiblePosition());
    i = getPackedPositionChild(l);
    int j = getPackedPositionGroup(l);
    if ((i == -1) || (j != paramInt)) {
      i = 0;
    }
    AnimatedExpandableListView.a.a(this.AHC, paramInt, i);
    this.AHC.notifyDataSetChanged();
    boolean bool = isGroupExpanded(paramInt);
    AppMethodBeat.o(112721);
    return bool;
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    AppMethodBeat.i(112719);
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof AnimatedExpandableListView.a))
    {
      this.AHC = ((AnimatedExpandableListView.a)paramExpandableListAdapter);
      AnimatedExpandableListView.a.a(this.AHC, this);
      AppMethodBeat.o(112719);
      return;
    }
    paramExpandableListAdapter = new ClassCastException(paramExpandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
    AppMethodBeat.o(112719);
    throw paramExpandableListAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView
 * JD-Core Version:    0.7.0.1
 */