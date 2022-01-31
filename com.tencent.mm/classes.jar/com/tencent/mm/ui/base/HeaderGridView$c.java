package com.tencent.mm.ui.base;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class HeaderGridView$c
  implements Filterable, WrapperListAdapter
{
  public final DataSetObservable mDataSetObservable;
  int mNumColumns;
  private final ListAdapter xw;
  boolean zhB;
  private final boolean zhC;
  ArrayList<HeaderGridView.a> zhy;
  
  public HeaderGridView$c(ArrayList<HeaderGridView.a> paramArrayList, ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(106288);
    this.mDataSetObservable = new DataSetObservable();
    this.mNumColumns = 1;
    this.xw = paramListAdapter;
    this.zhC = (paramListAdapter instanceof Filterable);
    if (paramArrayList == null)
    {
      paramArrayList = new IllegalArgumentException("headerViewInfos cannot be null");
      AppMethodBeat.o(106288);
      throw paramArrayList;
    }
    this.zhy = paramArrayList;
    this.zhB = aq(this.zhy);
    AppMethodBeat.o(106288);
  }
  
  private static boolean aq(ArrayList<HeaderGridView.a> paramArrayList)
  {
    AppMethodBeat.i(106290);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!((HeaderGridView.a)paramArrayList.next()).isSelectable)
        {
          AppMethodBeat.o(106290);
          return false;
        }
      }
    }
    AppMethodBeat.o(106290);
    return true;
  }
  
  public final boolean areAllItemsEnabled()
  {
    AppMethodBeat.i(106292);
    if (this.xw != null)
    {
      if ((this.zhB) && (this.xw.areAllItemsEnabled()))
      {
        AppMethodBeat.o(106292);
        return true;
      }
      AppMethodBeat.o(106292);
      return false;
    }
    AppMethodBeat.o(106292);
    return true;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(106291);
    if (this.xw != null)
    {
      i = this.zhy.size();
      j = this.mNumColumns;
      int k = this.xw.getCount();
      AppMethodBeat.o(106291);
      return i * j + k;
    }
    int i = this.zhy.size();
    int j = this.mNumColumns;
    AppMethodBeat.o(106291);
    return i * j;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(106302);
    if (this.zhC)
    {
      Filter localFilter = ((Filterable)this.xw).getFilter();
      AppMethodBeat.o(106302);
      return localFilter;
    }
    AppMethodBeat.o(106302);
    return null;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(106294);
    int i = this.zhy.size() * this.mNumColumns;
    Object localObject;
    if (paramInt < i)
    {
      if (paramInt % this.mNumColumns == 0)
      {
        localObject = ((HeaderGridView.a)this.zhy.get(paramInt / this.mNumColumns)).data;
        AppMethodBeat.o(106294);
        return localObject;
      }
      AppMethodBeat.o(106294);
      return null;
    }
    paramInt -= i;
    if ((this.xw != null) && (paramInt < this.xw.getCount()))
    {
      localObject = this.xw.getItem(paramInt);
      AppMethodBeat.o(106294);
      return localObject;
    }
    AppMethodBeat.o(106294);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(106295);
    int i = this.zhy.size() * this.mNumColumns;
    if ((this.xw != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < this.xw.getCount())
      {
        long l = this.xw.getItemId(paramInt);
        AppMethodBeat.o(106295);
        return l;
      }
    }
    AppMethodBeat.o(106295);
    return -1L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106298);
    int i = this.zhy.size() * this.mNumColumns;
    if ((paramInt < i) && (paramInt % this.mNumColumns != 0))
    {
      if (this.xw != null)
      {
        paramInt = this.xw.getViewTypeCount();
        AppMethodBeat.o(106298);
        return paramInt;
      }
      AppMethodBeat.o(106298);
      return 1;
    }
    if ((this.xw != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < this.xw.getCount())
      {
        paramInt = this.xw.getItemViewType(paramInt);
        AppMethodBeat.o(106298);
        return paramInt;
      }
    }
    AppMethodBeat.o(106298);
    return -2;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(106297);
    int i = this.zhy.size() * this.mNumColumns;
    if (paramInt < i)
    {
      ViewGroup localViewGroup = ((HeaderGridView.a)this.zhy.get(paramInt / this.mNumColumns)).zhz;
      if (paramInt % this.mNumColumns == 0)
      {
        AppMethodBeat.o(106297);
        return localViewGroup;
      }
      localView = paramView;
      if (paramView == null) {
        localView = new View(paramViewGroup.getContext());
      }
      localView.setVisibility(4);
      localView.setMinimumHeight(localViewGroup.getHeight());
      AppMethodBeat.o(106297);
      return localView;
    }
    paramInt -= i;
    if ((this.xw != null) && (paramInt < this.xw.getCount()))
    {
      paramView = this.xw.getView(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(106297);
      return paramView;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = new View(paramViewGroup.getContext());
    }
    localView.setVisibility(4);
    AppMethodBeat.o(106297);
    return localView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(106299);
    if (this.xw != null)
    {
      int i = this.xw.getViewTypeCount();
      AppMethodBeat.o(106299);
      return i + 1;
    }
    AppMethodBeat.o(106299);
    return 2;
  }
  
  public final ListAdapter getWrappedAdapter()
  {
    return this.xw;
  }
  
  public final boolean hasStableIds()
  {
    AppMethodBeat.i(106296);
    if (this.xw != null)
    {
      boolean bool = this.xw.hasStableIds();
      AppMethodBeat.o(106296);
      return bool;
    }
    AppMethodBeat.o(106296);
    return false;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(106289);
    if (((this.xw == null) || (this.xw.isEmpty())) && (this.zhy.size() == 0))
    {
      AppMethodBeat.o(106289);
      return true;
    }
    AppMethodBeat.o(106289);
    return false;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(106293);
    int i = this.zhy.size() * this.mNumColumns;
    if (paramInt < i)
    {
      if ((paramInt % this.mNumColumns == 0) && (((HeaderGridView.a)this.zhy.get(paramInt / this.mNumColumns)).isSelectable))
      {
        AppMethodBeat.o(106293);
        return true;
      }
      AppMethodBeat.o(106293);
      return false;
    }
    paramInt -= i;
    if ((this.xw != null) && (paramInt < this.xw.getCount()))
    {
      boolean bool = this.xw.isEnabled(paramInt);
      AppMethodBeat.o(106293);
      return bool;
    }
    AppMethodBeat.o(106293);
    return false;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(106300);
    this.mDataSetObservable.registerObserver(paramDataSetObserver);
    if (this.xw != null) {
      this.xw.registerDataSetObserver(paramDataSetObserver);
    }
    AppMethodBeat.o(106300);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(106301);
    this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
    if (this.xw != null) {
      this.xw.unregisterDataSetObserver(paramDataSetObserver);
    }
    AppMethodBeat.o(106301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.HeaderGridView.c
 * JD-Core Version:    0.7.0.1
 */