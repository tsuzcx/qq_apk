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
  AdapterView.OnItemClickListener vHe;
  List<n> vHl;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n Lb(int paramInt)
  {
    AppMethodBeat.i(67037);
    n localn = (n)this.vHl.get(paramInt);
    AppMethodBeat.o(67037);
    return localn;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67036);
    if (this.vHl != null)
    {
      int i = this.vHl.size();
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
    n localn = Lb(paramInt);
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new a();
      localView = View.inflate(this.mContext, 2131495130, null);
      paramView.vHf = ((TextView)localView.findViewById(2131302112));
      paramView.vHg = ((MaxGridView)localView.findViewById(2131302111));
      paramView.vHm = new l(this.mContext);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.vHf.setText(localn.name);
      paramViewGroup.vHg.setOnItemClickListener(this.vHe);
      paramViewGroup.vHm.vHo = localn.vFl;
      paramViewGroup.vHm.notifyDataSetChanged();
      paramViewGroup.vHg.setAdapter(paramViewGroup.vHm);
      AppMethodBeat.o(67038);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  final class a
  {
    public TextView vHf = null;
    public MaxGridView vHg = null;
    public l vHm = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.k
 * JD-Core Version:    0.7.0.1
 */