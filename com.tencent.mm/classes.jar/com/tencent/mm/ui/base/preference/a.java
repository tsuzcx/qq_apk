package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public final class a
  extends h
{
  private SparseArray<View> vbV = new SparseArray();
  
  public a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    super(paramContext, paramSharedPreferences);
  }
  
  public final View a(int paramInt, ListView paramListView)
  {
    if ((paramInt > paramListView.getLastVisiblePosition()) || (paramInt < paramListView.getFirstVisiblePosition())) {
      return null;
    }
    return (View)this.vbV.get(paramInt);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    this.vbV.put(paramInt, paramView);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.a
 * JD-Core Version:    0.7.0.1
 */