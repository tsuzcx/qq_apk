package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class as$f$5
  implements View.OnClickListener
{
  as$f$5(as.f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    y.d("MicroMsg.SnsphotoAdapter", "sign click");
    this.pcE.pcD = ((as.f.a)paramView.getTag());
    int i = this.pcE.pcD.onc;
    this.pcE.yM(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as.f.5
 * JD-Core Version:    0.7.0.1
 */