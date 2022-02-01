package com.tencent.mm.ui.widget.sortlist;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DragSortListView$a
  extends BaseAdapter
{
  ListAdapter GE;
  
  private DragSortListView$a(final DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159760);
    this.GE = paramListAdapter;
    this.GE.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(159758);
        DragSortListView.a.this.notifyDataSetChanged();
        AppMethodBeat.o(159758);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(159759);
        DragSortListView.a.this.notifyDataSetInvalidated();
        AppMethodBeat.o(159759);
      }
    });
    AppMethodBeat.o(159760);
  }
  
  public final boolean areAllItemsEnabled()
  {
    AppMethodBeat.i(159764);
    boolean bool = this.GE.areAllItemsEnabled();
    AppMethodBeat.o(159764);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(159763);
    int i = this.GE.getCount();
    AppMethodBeat.o(159763);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(159762);
    Object localObject = this.GE.getItem(paramInt);
    AppMethodBeat.o(159762);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(159761);
    long l = this.GE.getItemId(paramInt);
    AppMethodBeat.o(159761);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(159766);
    paramInt = this.GE.getItemViewType(paramInt);
    AppMethodBeat.o(159766);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(159770);
    if ((paramView != null) && ((paramView instanceof b)))
    {
      paramViewGroup = (b)paramView;
      View localView1 = paramViewGroup.getChildAt(0);
      View localView2 = this.GE.getView(paramInt, localView1, this.LBr);
      paramView = paramViewGroup;
      if (localView2 != localView1)
      {
        if (localView1 != null) {
          paramViewGroup.removeViewAt(0);
        }
        paramViewGroup.addView(localView2);
        paramView = paramViewGroup;
      }
      paramViewGroup = this.LBr;
      DragSortListView.a(paramViewGroup, paramViewGroup.getHeaderViewsCount() + paramInt, paramView);
      AppMethodBeat.o(159770);
      return paramView;
    }
    paramViewGroup = this.GE.getView(paramInt, null, this.LBr);
    if ((paramViewGroup instanceof Checkable)) {}
    for (paramView = new c(this.LBr.getContext());; paramView = new b(this.LBr.getContext()))
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.addView(paramViewGroup);
      break;
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(159767);
    int i = this.GE.getViewTypeCount();
    AppMethodBeat.o(159767);
    return i;
  }
  
  public final boolean hasStableIds()
  {
    AppMethodBeat.i(159768);
    boolean bool = this.GE.hasStableIds();
    AppMethodBeat.o(159768);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(159769);
    boolean bool = this.GE.isEmpty();
    AppMethodBeat.o(159769);
    return bool;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(159765);
    boolean bool = this.GE.isEnabled(paramInt);
    AppMethodBeat.o(159765);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.a
 * JD-Core Version:    0.7.0.1
 */