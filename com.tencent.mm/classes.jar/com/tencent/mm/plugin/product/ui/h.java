package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.d;
import java.util.List;

public final class h
  extends BaseAdapter
  implements Filterable
{
  private Context mContext;
  private List<String> puo;
  private List<String> pwe;
  Filter pwf;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(44085);
    this.pwe = null;
    this.puo = null;
    this.pwf = new h.1(this);
    this.mContext = paramContext;
    this.pwe = a.caT().caV().puo;
    AppMethodBeat.o(44085);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(44087);
    String str = (String)this.puo.get(paramInt);
    AppMethodBeat.o(44087);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44086);
    if (this.puo != null)
    {
      int i = this.puo.size();
      AppMethodBeat.o(44086);
      return i;
    }
    AppMethodBeat.o(44086);
    return 0;
  }
  
  public final Filter getFilter()
  {
    return this.pwf;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44088);
    View localView;
    if (paramView == null)
    {
      paramView = new h.a(this);
      localView = LayoutInflater.from(this.mContext).inflate(17367043, null);
      paramView.pvK = ((TextView)localView.findViewById(16908308));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.pvK.setText(getItem(paramInt));
      AppMethodBeat.o(44088);
      return localView;
      paramViewGroup = (h.a)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.h
 * JD-Core Version:    0.7.0.1
 */