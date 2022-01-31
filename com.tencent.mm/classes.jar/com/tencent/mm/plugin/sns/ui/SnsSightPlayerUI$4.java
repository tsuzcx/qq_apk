package com.tencent.mm.plugin.sns.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.tools.e.b;

final class SnsSightPlayerUI$4
  implements e.b
{
  SnsSightPlayerUI$4(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onAnimationEnd()
  {
    new ah().post(new SnsSightPlayerUI.4.1(this));
  }
  
  public final void onAnimationStart()
  {
    if (SnsSightPlayerUI.q(this.pdk) != null) {
      SnsSightPlayerUI.q(this.pdk).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.4
 * JD-Core Version:    0.7.0.1
 */