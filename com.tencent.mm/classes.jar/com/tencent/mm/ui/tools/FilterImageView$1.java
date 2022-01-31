package com.tencent.mm.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FilterImageView$1
  implements AdapterView.OnItemClickListener
{
  FilterImageView$1(FilterImageView paramFilterImageView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107627);
    paramAdapterView = FilterImageView.a(this.ArR);
    paramAdapterView.lxQ = paramInt;
    paramAdapterView.notifyDataSetChanged();
    try
    {
      FilterImageView.a(this.ArR, FilterImageView.ArQ[paramInt].Asb);
      FilterImageView.a(this.ArR, FilterImageView.ArQ[paramInt].ArY, FilterImageView.ArQ[paramInt].ArZ, FilterImageView.ArQ[paramInt].Asa);
      AppMethodBeat.o(107627);
      return;
    }
    catch (Exception paramAdapterView)
    {
      ab.e("MicroMsg.FilterView", paramAdapterView.toString());
      ab.printErrStackTrace("MicroMsg.FilterView", paramAdapterView, "", new Object[0]);
      AppMethodBeat.o(107627);
      return;
    }
    catch (OutOfMemoryError paramAdapterView)
    {
      ab.e("MicroMsg.FilterView", paramAdapterView.toString());
      ab.printErrStackTrace("MicroMsg.FilterView", paramAdapterView, "", new Object[0]);
      AppMethodBeat.o(107627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.FilterImageView.1
 * JD-Core Version:    0.7.0.1
 */