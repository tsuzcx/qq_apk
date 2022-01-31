package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class as$f$4
  implements View.OnClickListener
{
  as$f$4(as.f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    y.d("MicroMsg.SnsphotoAdapter", "sign click");
    this.pcE.pcD = ((as.f.a)paramView.getTag());
    int i = this.pcE.pcD.onc;
    int j = this.pcE.pcD.position;
    this.pcE.dY(i, j + 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as.f.4
 * JD-Core Version:    0.7.0.1
 */