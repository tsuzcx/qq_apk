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
  private Context mContext;
  AdapterView.OnItemClickListener xdZ;
  List<n> xeg;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n Nk(int paramInt)
  {
    AppMethodBeat.i(67037);
    n localn = (n)this.xeg.get(paramInt);
    AppMethodBeat.o(67037);
    return localn;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67036);
    if (this.xeg != null)
    {
      int i = this.xeg.size();
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
    n localn = Nk(paramInt);
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new a();
      localView = View.inflate(this.mContext, 2131495130, null);
      paramView.xea = ((TextView)localView.findViewById(2131302112));
      paramView.xeb = ((MaxGridView)localView.findViewById(2131302111));
      paramView.xeh = new l(this.mContext);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.xea.setText(localn.name);
      paramViewGroup.xeb.setOnItemClickListener(this.xdZ);
      paramViewGroup.xeh.xej = localn.xcf;
      paramViewGroup.xeh.notifyDataSetChanged();
      paramViewGroup.xeb.setAdapter(paramViewGroup.xeh);
      AppMethodBeat.o(67038);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  final class a
  {
    public TextView xea = null;
    public MaxGridView xeb = null;
    public l xeh = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.k
 * JD-Core Version:    0.7.0.1
 */