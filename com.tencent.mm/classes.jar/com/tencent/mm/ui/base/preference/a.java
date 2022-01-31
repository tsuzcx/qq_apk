package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends h
{
  private SparseArray<View> zqw;
  
  public a(Context paramContext, ListView paramListView, SharedPreferences paramSharedPreferences)
  {
    super(paramContext, paramListView, paramSharedPreferences);
    AppMethodBeat.i(107131);
    this.zqw = new SparseArray();
    AppMethodBeat.o(107131);
  }
  
  public final View a(int paramInt, ListView paramListView)
  {
    AppMethodBeat.i(107133);
    if ((paramInt > paramListView.getLastVisiblePosition()) || (paramInt < paramListView.getFirstVisiblePosition()))
    {
      AppMethodBeat.o(107133);
      return null;
    }
    paramListView = (View)this.zqw.get(paramInt);
    AppMethodBeat.o(107133);
    return paramListView;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107132);
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    this.zqw.put(paramInt, paramView);
    AppMethodBeat.o(107132);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.a
 * JD-Core Version:    0.7.0.1
 */