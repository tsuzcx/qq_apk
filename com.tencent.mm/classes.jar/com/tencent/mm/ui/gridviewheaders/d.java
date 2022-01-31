package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public final class d
  extends BaseAdapter
  implements b
{
  private DataSetObserver JP = new d.1(this);
  private ListAdapter vXb;
  
  public d(ListAdapter paramListAdapter)
  {
    this.vXb = paramListAdapter;
    paramListAdapter.registerDataSetObserver(this.JP);
  }
  
  public final int HU(int paramInt)
  {
    return 0;
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final int cIA()
  {
    return 0;
  }
  
  public final int getCount()
  {
    return this.vXb.getCount();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.vXb.getItem(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return this.vXb.getItemId(paramInt);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.vXb.getView(paramInt, paramView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.d
 * JD-Core Version:    0.7.0.1
 */