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
  private ListAdapter KBf;
  private DataSetObserver Tf;
  
  public d(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142841);
    this.Tf = new DataSetObserver()
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
    this.KBf = paramListAdapter;
    paramListAdapter.registerDataSetObserver(this.Tf);
    AppMethodBeat.o(142841);
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final int aeI(int paramInt)
  {
    return 0;
  }
  
  public final int fJH()
  {
    return 0;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(142842);
    int i = this.KBf.getCount();
    AppMethodBeat.o(142842);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(142843);
    Object localObject = this.KBf.getItem(paramInt);
    AppMethodBeat.o(142843);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(142844);
    long l = this.KBf.getItemId(paramInt);
    AppMethodBeat.o(142844);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142845);
    paramView = this.KBf.getView(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(142845);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.d
 * JD-Core Version:    0.7.0.1
 */