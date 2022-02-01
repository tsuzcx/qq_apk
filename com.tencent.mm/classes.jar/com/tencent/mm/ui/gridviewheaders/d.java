package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends BaseAdapter
  implements b
{
  private ListAdapter afvR;
  private DataSetObserver bxk;
  
  public d(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142841);
    this.bxk = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142839);
        d.this.notifyDataSetChanged();
        AppMethodBeat.o(142839);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(142840);
        d.this.notifyDataSetInvalidated();
        AppMethodBeat.o(142840);
      }
    };
    this.afvR = paramListAdapter;
    paramListAdapter.registerDataSetObserver(this.bxk);
    AppMethodBeat.o(142841);
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final int aDO(int paramInt)
  {
    return 0;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(142842);
    int i = this.afvR.getCount();
    AppMethodBeat.o(142842);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(142843);
    Object localObject = this.afvR.getItem(paramInt);
    AppMethodBeat.o(142843);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(142844);
    long l = this.afvR.getItemId(paramInt);
    AppMethodBeat.o(142844);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142845);
    paramView = this.afvR.getView(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(142845);
    return paramView;
  }
  
  public final int jBx()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.d
 * JD-Core Version:    0.7.0.1
 */