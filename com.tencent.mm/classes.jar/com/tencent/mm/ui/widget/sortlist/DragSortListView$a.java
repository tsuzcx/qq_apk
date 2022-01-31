package com.tencent.mm.ui.widget.sortlist;

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
  ListAdapter xw;
  
  private DragSortListView$a(DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(113030);
    this.xw = paramListAdapter;
    this.xw.registerDataSetObserver(new DragSortListView.a.1(this, paramDragSortListView));
    AppMethodBeat.o(113030);
  }
  
  public final boolean areAllItemsEnabled()
  {
    AppMethodBeat.i(113034);
    boolean bool = this.xw.areAllItemsEnabled();
    AppMethodBeat.o(113034);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113033);
    int i = this.xw.getCount();
    AppMethodBeat.o(113033);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(113032);
    Object localObject = this.xw.getItem(paramInt);
    AppMethodBeat.o(113032);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(113031);
    long l = this.xw.getItemId(paramInt);
    AppMethodBeat.o(113031);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113036);
    paramInt = this.xw.getItemViewType(paramInt);
    AppMethodBeat.o(113036);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113040);
    if ((paramView != null) && ((paramView instanceof b)))
    {
      paramViewGroup = (b)paramView;
      View localView1 = paramViewGroup.getChildAt(0);
      View localView2 = this.xw.getView(paramInt, localView1, this.AMh);
      paramView = paramViewGroup;
      if (localView2 != localView1)
      {
        if (localView1 != null) {
          paramViewGroup.removeViewAt(0);
        }
        paramViewGroup.addView(localView2);
        paramView = paramViewGroup;
      }
      paramViewGroup = this.AMh;
      DragSortListView.a(paramViewGroup, paramViewGroup.getHeaderViewsCount() + paramInt, paramView);
      AppMethodBeat.o(113040);
      return paramView;
    }
    paramViewGroup = this.xw.getView(paramInt, null, this.AMh);
    if ((paramViewGroup instanceof Checkable)) {}
    for (paramView = new c(this.AMh.getContext());; paramView = new b(this.AMh.getContext()))
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.addView(paramViewGroup);
      break;
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(113037);
    int i = this.xw.getViewTypeCount();
    AppMethodBeat.o(113037);
    return i;
  }
  
  public final boolean hasStableIds()
  {
    AppMethodBeat.i(113038);
    boolean bool = this.xw.hasStableIds();
    AppMethodBeat.o(113038);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(113039);
    boolean bool = this.xw.isEmpty();
    AppMethodBeat.o(113039);
    return bool;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(113035);
    boolean bool = this.xw.isEnabled(paramInt);
    AppMethodBeat.o(113035);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.a
 * JD-Core Version:    0.7.0.1
 */