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
  private SparseArray<View> JrC;
  
  public a(Context paramContext, ListView paramListView, SharedPreferences paramSharedPreferences)
  {
    super(paramContext, paramListView, paramSharedPreferences);
    AppMethodBeat.i(142508);
    this.JrC = new SparseArray();
    AppMethodBeat.o(142508);
  }
  
  public final View a(int paramInt, ListView paramListView)
  {
    AppMethodBeat.i(142510);
    if ((paramInt > paramListView.getLastVisiblePosition()) || (paramInt < paramListView.getFirstVisiblePosition()))
    {
      AppMethodBeat.o(142510);
      return null;
    }
    paramListView = (View)this.JrC.get(paramInt);
    AppMethodBeat.o(142510);
    return paramListView;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142509);
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    this.JrC.put(paramInt, paramView);
    AppMethodBeat.o(142509);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.a
 * JD-Core Version:    0.7.0.1
 */