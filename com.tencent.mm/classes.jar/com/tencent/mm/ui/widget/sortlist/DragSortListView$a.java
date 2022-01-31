package com.tencent.mm.ui.widget.sortlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;

final class DragSortListView$a
  extends BaseAdapter
{
  ListAdapter NK;
  
  private DragSortListView$a(DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    this.NK = paramListAdapter;
    this.NK.registerDataSetObserver(new DragSortListView.a.1(this, paramDragSortListView));
  }
  
  public final boolean areAllItemsEnabled()
  {
    return this.NK.areAllItemsEnabled();
  }
  
  public final int getCount()
  {
    return this.NK.getCount();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.NK.getItem(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return this.NK.getItemId(paramInt);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return this.NK.getItemViewType(paramInt);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView instanceof b)))
    {
      paramViewGroup = (b)paramView;
      View localView1 = paramViewGroup.getChildAt(0);
      View localView2 = this.NK.getView(paramInt, localView1, this.wrD);
      paramView = paramViewGroup;
      if (localView2 != localView1)
      {
        if (localView1 != null) {
          paramViewGroup.removeViewAt(0);
        }
        paramViewGroup.addView(localView2);
        paramView = paramViewGroup;
      }
      DragSortListView.a(this.wrD, this.wrD.getHeaderViewsCount() + paramInt, paramView);
      return paramView;
    }
    paramViewGroup = this.NK.getView(paramInt, null, this.wrD);
    if ((paramViewGroup instanceof Checkable)) {}
    for (paramView = new c(this.wrD.getContext());; paramView = new b(this.wrD.getContext()))
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.addView(paramViewGroup);
      break;
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.NK.getViewTypeCount();
  }
  
  public final boolean hasStableIds()
  {
    return this.NK.hasStableIds();
  }
  
  public final boolean isEmpty()
  {
    return this.NK.isEmpty();
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return this.NK.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.a
 * JD-Core Version:    0.7.0.1
 */