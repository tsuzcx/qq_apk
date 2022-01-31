package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class as$f$7
  implements View.OnLongClickListener
{
  as$f$7(as.f paramf) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return true;
    }
    y.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
    this.pcE.pcD = ((as.f.a)paramView.getTag());
    int i = this.pcE.pcD.onc;
    int j = this.pcE.pcD.position;
    this.pcE.dZ(i, j);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as.f.7
 * JD-Core Version:    0.7.0.1
 */