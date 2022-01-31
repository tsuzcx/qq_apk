package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class SnsNotifyBanner$2
  implements View.OnClickListener
{
  SnsNotifyBanner$2(SnsNotifyBanner paramSnsNotifyBanner) {}
  
  public final void onClick(View paramView)
  {
    if (SnsNotifyBanner.a(this.pbi) == null) {
      return;
    }
    if (this.pbi.pbg > 0) {
      this.pbi.pbg = 0;
    }
    this.pbi.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotifyBanner.2
 * JD-Core Version:    0.7.0.1
 */