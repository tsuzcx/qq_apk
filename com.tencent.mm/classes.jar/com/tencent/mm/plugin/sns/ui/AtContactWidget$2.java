package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.c;

final class AtContactWidget$2
  implements Runnable
{
  AtContactWidget$2(AtContactWidget paramAtContactWidget) {}
  
  public final void run()
  {
    int i = (int)(c.cqp().density * 36.0F);
    if (i != 0)
    {
      i = (AtContactWidget.b(this.oNy).getWidth() - AtContactWidget.c(this.oNy).getWidth() - AtContactWidget.d(this.oNy).getWidth() - (int)(c.cqp().density * 32.0F)) / i;
      if ((i > 0) && (i < 5))
      {
        AtContactWidget.e(this.oNy).setLineNum(i);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)AtContactWidget.e(this.oNy).getLayoutParams();
        localLayoutParams.alignWithParent = true;
        AtContactWidget.e(this.oNy).setLayoutParams(localLayoutParams);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AtContactWidget.2
 * JD-Core Version:    0.7.0.1
 */