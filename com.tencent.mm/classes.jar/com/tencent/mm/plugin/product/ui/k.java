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
  AdapterView.OnItemClickListener pwD;
  List<n> pwK;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n Bq(int paramInt)
  {
    AppMethodBeat.i(44130);
    n localn = (n)this.pwK.get(paramInt);
    AppMethodBeat.o(44130);
    return localn;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44129);
    if (this.pwK != null)
    {
      int i = this.pwK.size();
      AppMethodBeat.o(44129);
      return i;
    }
    AppMethodBeat.o(44129);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44131);
    n localn = Bq(paramInt);
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new k.a(this);
      localView = View.inflate(this.mContext, 2130970457, null);
      paramView.pwE = ((TextView)localView.findViewById(2131826813));
      paramView.pwF = ((MaxGridView)localView.findViewById(2131826814));
      paramView.pwL = new l(this.mContext);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.pwE.setText(localn.name);
      paramViewGroup.pwF.setOnItemClickListener(this.pwD);
      paramViewGroup.pwL.pwN = localn.puH;
      paramViewGroup.pwL.notifyDataSetChanged();
      paramViewGroup.pwF.setAdapter(paramViewGroup.pwL);
      AppMethodBeat.o(44131);
      return localView;
      paramViewGroup = (k.a)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.k
 * JD-Core Version:    0.7.0.1
 */