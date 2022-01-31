package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.v.a;
import com.tencent.mm.sdk.platformtools.ab;

final class e$3
  implements AdapterView.OnItemClickListener
{
  e$3(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(40323);
    if (this.skN.skE != null)
    {
      if (paramView.getTag() == null)
      {
        AppMethodBeat.o(40323);
        return;
      }
      paramInt = ((Integer)paramView.getTag()).intValue();
      ab.i("DynamicGrid", "click ".concat(String.valueOf(paramInt)));
      if (paramInt == 2147483647)
      {
        AppMethodBeat.o(40323);
        return;
      }
      this.skN.skE.ED(paramInt);
    }
    AppMethodBeat.o(40323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.3
 * JD-Core Version:    0.7.0.1
 */