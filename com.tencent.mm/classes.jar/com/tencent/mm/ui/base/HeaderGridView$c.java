package com.tencent.mm.ui.base;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public final class HeaderGridView$c
  implements Filterable, WrapperListAdapter
{
  private final ListAdapter NK;
  public final DataSetObservable mDataSetObservable = new DataSetObservable();
  int mNumColumns = 1;
  ArrayList<HeaderGridView.a> uSY;
  boolean uTb;
  private final boolean uTc;
  
  public HeaderGridView$c(ArrayList<HeaderGridView.a> paramArrayList, ListAdapter paramListAdapter)
  {
    this.NK = paramListAdapter;
    this.uTc = (paramListAdapter instanceof Filterable);
    if (paramArrayList == null) {
      throw new IllegalArgumentException("headerViewInfos cannot be null");
    }
    this.uSY = paramArrayList;
    this.uTb = ah(this.uSY);
  }
  
  private static boolean ah(ArrayList<HeaderGridView.a> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!((HeaderGridView.a)paramArrayList.next()).isSelectable) {
          return false;
        }
      }
    }
    return true;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return (this.NK == null) || ((this.uTb) && (this.NK.areAllItemsEnabled()));
  }
  
  public final int getCount()
  {
    if (this.NK != null) {
      return this.uSY.size() * this.mNumColumns + this.NK.getCount();
    }
    return this.uSY.size() * this.mNumColumns;
  }
  
  public final Filter getFilter()
  {
    if (this.uTc) {
      return ((Filterable)this.NK).getFilter();
    }
    return null;
  }
  
  public final Object getItem(int paramInt)
  {
    Object localObject2 = null;
    int i = this.uSY.size() * this.mNumColumns;
    Object localObject1;
    if (paramInt < i)
    {
      localObject1 = localObject2;
      if (paramInt % this.mNumColumns == 0) {
        localObject1 = ((HeaderGridView.a)this.uSY.get(paramInt / this.mNumColumns)).data;
      }
    }
    do
    {
      do
      {
        return localObject1;
        paramInt -= i;
        localObject1 = localObject2;
      } while (this.NK == null);
      localObject1 = localObject2;
    } while (paramInt >= this.NK.getCount());
    return this.NK.getItem(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    int i = this.uSY.size() * this.mNumColumns;
    if ((this.NK != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < this.NK.getCount()) {
        return this.NK.getItemId(paramInt);
      }
    }
    return -1L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    int i = this.uSY.size() * this.mNumColumns;
    if ((paramInt < i) && (paramInt % this.mNumColumns != 0))
    {
      if (this.NK != null) {
        return this.NK.getViewTypeCount();
      }
      return 1;
    }
    if ((this.NK != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < this.NK.getCount()) {
        return this.NK.getItemViewType(paramInt);
      }
    }
    return -2;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = this.uSY.size() * this.mNumColumns;
    if (paramInt < i)
    {
      ViewGroup localViewGroup = ((HeaderGridView.a)this.uSY.get(paramInt / this.mNumColumns)).uSZ;
      if (paramInt % this.mNumColumns == 0) {
        return localViewGroup;
      }
      localView = paramView;
      if (paramView == null) {
        localView = new View(paramViewGroup.getContext());
      }
      localView.setVisibility(4);
      localView.setMinimumHeight(localViewGroup.getHeight());
      return localView;
    }
    paramInt -= i;
    if ((this.NK != null) && (paramInt < this.NK.getCount())) {
      return this.NK.getView(paramInt, paramView, paramViewGroup);
    }
    View localView = paramView;
    if (paramView == null) {
      localView = new View(paramViewGroup.getContext());
    }
    localView.setVisibility(4);
    return localView;
  }
  
  public final int getViewTypeCount()
  {
    if (this.NK != null) {
      return this.NK.getViewTypeCount() + 1;
    }
    return 2;
  }
  
  public final ListAdapter getWrappedAdapter()
  {
    return this.NK;
  }
  
  public final boolean hasStableIds()
  {
    if (this.NK != null) {
      return this.NK.hasStableIds();
    }
    return false;
  }
  
  public final boolean isEmpty()
  {
    return ((this.NK == null) || (this.NK.isEmpty())) && (this.uSY.size() == 0);
  }
  
  public final boolean isEnabled(int paramInt)
  {
    int i = this.uSY.size() * this.mNumColumns;
    if (paramInt < i) {
      return (paramInt % this.mNumColumns == 0) && (((HeaderGridView.a)this.uSY.get(paramInt / this.mNumColumns)).isSelectable);
    }
    paramInt -= i;
    if ((this.NK != null) && (paramInt < this.NK.getCount())) {
      return this.NK.isEnabled(paramInt);
    }
    return false;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.registerObserver(paramDataSetObserver);
    if (this.NK != null) {
      this.NK.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
    if (this.NK != null) {
      this.NK.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.HeaderGridView.c
 * JD-Core Version:    0.7.0.1
 */