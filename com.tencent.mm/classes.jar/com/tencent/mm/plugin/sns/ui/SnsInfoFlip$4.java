package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class SnsInfoFlip$4
  implements AdapterView.OnItemSelectedListener
{
  SnsInfoFlip$4(SnsInfoFlip paramSnsInfoFlip) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (SnsInfoFlip.d(this.oZi) != null)
    {
      if ((SnsInfoFlip.e(this.oZi)) && (SnsInfoFlip.d(this.oZi).getCount() > 1))
      {
        SnsInfoFlip.f(this.oZi).setVisibility(0);
        SnsInfoFlip.f(this.oZi).setPage(paramInt);
      }
      paramAdapterView = ((b)SnsInfoFlip.d(this.oZi).getItem(paramInt)).bZK;
      String str = ((b)SnsInfoFlip.d(this.oZi).getItem(paramInt)).owP;
      SnsInfoFlip.a(this.oZi, paramAdapterView, paramInt, str);
      if ((paramView instanceof MultiTouchImageView)) {
        ((MultiTouchImageView)paramView).cAy();
      }
      if (((SnsInfoFlip.g(this.oZi) instanceof MMGestureGallery)) && ((SnsInfoFlip.h(this.oZi) instanceof SnsBrowseUI))) {
        ((SnsBrowseUI)SnsInfoFlip.h(this.oZi)).bIx();
      }
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.4
 * JD-Core Version:    0.7.0.1
 */