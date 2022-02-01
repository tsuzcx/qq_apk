package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.n;
import java.util.List;

public final class k
  extends BaseAdapter
{
  AdapterView.OnItemClickListener BbB;
  List<n> BbI;
  private Context mContext;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n Ux(int paramInt)
  {
    AppMethodBeat.i(67037);
    n localn = (n)this.BbI.get(paramInt);
    AppMethodBeat.o(67037);
    return localn;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67036);
    if (this.BbI != null)
    {
      int i = this.BbI.size();
      AppMethodBeat.o(67036);
      return i;
    }
    AppMethodBeat.o(67036);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67038);
    n localn = Ux(paramInt);
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new a();
      localView = View.inflate(this.mContext, 2131495973, null);
      paramView.BbC = ((TextView)localView.findViewById(2131304451));
      paramView.BbD = ((MaxGridView)localView.findViewById(2131304450));
      paramView.BbJ = new l(this.mContext);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.BbC.setText(localn.name);
      paramViewGroup.BbD.setOnItemClickListener(this.BbB);
      paramViewGroup.BbJ.BbL = localn.AZH;
      paramViewGroup.BbJ.notifyDataSetChanged();
      paramViewGroup.BbD.setAdapter(paramViewGroup.BbJ);
      AppMethodBeat.o(67038);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  final class a
  {
    public TextView BbC = null;
    public MaxGridView BbD = null;
    public l BbJ = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.k
 * JD-Core Version:    0.7.0.1
 */