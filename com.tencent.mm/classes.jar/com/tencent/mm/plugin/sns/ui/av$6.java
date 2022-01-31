package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import java.util.HashMap;

final class av$6
  implements View.OnClickListener
{
  av$6(av paramav) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39408);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(39408);
      return;
    }
    paramView = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(39408);
      return;
    }
    if ((this.rXd.rFT.containsKey(paramView.crk)) && (((Integer)this.rXd.rFT.get(paramView.crk)).equals(Integer.valueOf(1))))
    {
      this.rXd.rFT.put(paramView.crk, Integer.valueOf(2));
      this.rXd.rWO.notifyDataSetChanged();
      AppMethodBeat.o(39408);
      return;
    }
    this.rXd.rFT.put(paramView.crk, Integer.valueOf(1));
    if (paramView.ngZ.getTop() < 0)
    {
      this.rXd.rks.b(paramView.ngZ, paramView.position, paramView.ngZ.getTop(), paramView.sgQ.getSpreadHeight());
      AppMethodBeat.o(39408);
      return;
    }
    this.rXd.rWO.notifyDataSetChanged();
    AppMethodBeat.o(39408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av.6
 * JD-Core Version:    0.7.0.1
 */