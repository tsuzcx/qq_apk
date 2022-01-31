package com.tencent.mm.pluginsdk.ui.tools;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;

final class n$1$1
  implements Runnable
{
  n$1$1(n.1 param1, View paramView) {}
  
  public final void run()
  {
    int j = this.hdG.getResources().getDisplayMetrics().heightPixels - this.hdG.getHeight() >>> 1;
    int i = (int)(j / 1.618D - (this.sns.snr.getHeight() >>> 1));
    if (i >= 0)
    {
      if (n.access$000() < 0) {
        n.access$002(BackwardSupportUtil.b.b(this.hdG.getContext(), 20.0F));
      }
      if (this.sns.snr.getHeight() + i + n.access$000() <= j) {
        break label189;
      }
      i -= this.sns.snr.getHeight() + i + n.access$000() - j;
    }
    label189:
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.sns.snr.getLayoutParams();
      if ((i > 0) && (i != localLayoutParams.bottomMargin))
      {
        y.i("VideoSightHelper", "setting tip marginBottom " + i);
        localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
        this.sns.snr.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.n.1.1
 * JD-Core Version:    0.7.0.1
 */