package com.tencent.mm.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class FilterImageView$1
  implements AdapterView.OnItemClickListener
{
  FilterImageView$1(FilterImageView paramFilterImageView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = FilterImageView.a(this.vZE);
    paramAdapterView.lJz = paramInt;
    paramAdapterView.notifyDataSetChanged();
    try
    {
      FilterImageView.a(this.vZE, FilterImageView.vZD[paramInt].vZO);
      FilterImageView.a(this.vZE, FilterImageView.vZD[paramInt].vZL, FilterImageView.vZD[paramInt].vZM, FilterImageView.vZD[paramInt].vZN);
      return;
    }
    catch (Exception paramAdapterView)
    {
      y.e("MicroMsg.FilterView", paramAdapterView.toString());
      y.printErrStackTrace("MicroMsg.FilterView", paramAdapterView, "", new Object[0]);
      return;
    }
    catch (OutOfMemoryError paramAdapterView)
    {
      y.e("MicroMsg.FilterView", paramAdapterView.toString());
      y.printErrStackTrace("MicroMsg.FilterView", paramAdapterView, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView.1
 * JD-Core Version:    0.7.0.1
 */