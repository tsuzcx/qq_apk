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
  private ListAdapter Apj;
  private DataSetObserver Jv;
  
  public d(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(107407);
    this.Jv = new d.1(this);
    this.Apj = paramListAdapter;
    paramListAdapter.registerDataSetObserver(this.Jv);
    AppMethodBeat.o(107407);
  }
  
  public final int QG(int paramInt)
  {
    return 0;
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final int dNk()
  {
    return 0;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(107408);
    int i = this.Apj.getCount();
    AppMethodBeat.o(107408);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(107409);
    Object localObject = this.Apj.getItem(paramInt);
    AppMethodBeat.o(107409);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(107410);
    long l = this.Apj.getItemId(paramInt);
    AppMethodBeat.o(107410);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107411);
    paramView = this.Apj.getView(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(107411);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.d
 * JD-Core Version:    0.7.0.1
 */