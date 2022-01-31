package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.sdk.platformtools.u;

final class SnsUserUI$15
  implements Runnable
{
  SnsUserUI$15(SnsUserUI paramSnsUserUI) {}
  
  public final void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = (u.V(this.pjB) + this.pjB.getResources().getDimensionPixelSize(i.d.ActionBarHeight));
    SnsUserUI.k(this.pjB).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.15
 * JD-Core Version:    0.7.0.1
 */