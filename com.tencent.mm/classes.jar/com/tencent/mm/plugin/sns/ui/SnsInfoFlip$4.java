package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class SnsInfoFlip$4
  implements AdapterView.OnItemSelectedListener
{
  SnsInfoFlip$4(SnsInfoFlip paramSnsInfoFlip) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38970);
    if (SnsInfoFlip.d(this.rRB) != null)
    {
      if ((SnsInfoFlip.e(this.rRB)) && (SnsInfoFlip.d(this.rRB).getCount() > 1))
      {
        SnsInfoFlip.f(this.rRB).setVisibility(0);
        SnsInfoFlip.f(this.rRB).setPage(paramInt);
      }
      paramAdapterView = ((b)SnsInfoFlip.d(this.rRB).getItem(paramInt)).cIc;
      String str = ((b)SnsInfoFlip.d(this.rRB).getItem(paramInt)).rlJ;
      SnsInfoFlip.a(this.rRB, paramAdapterView, paramInt, str);
      if ((paramView instanceof MultiTouchImageView)) {
        ((MultiTouchImageView)paramView).dDJ();
      }
      if (((SnsInfoFlip.g(this.rRB) instanceof MMGestureGallery)) && ((SnsInfoFlip.h(this.rRB) instanceof SnsBrowseUI))) {
        ((SnsBrowseUI)SnsInfoFlip.h(this.rRB)).cuS();
      }
    }
    AppMethodBeat.o(38970);
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.4
 * JD-Core Version:    0.7.0.1
 */