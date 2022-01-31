package com.tencent.mm.plugin.sns.ui;

import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsSightPlayerUI$9$2
  implements Runnable
{
  SnsSightPlayerUI$9$2(SnsSightPlayerUI.9 param9) {}
  
  public final void run()
  {
    if (SnsSightPlayerUI.k(this.pdo.pdk).getVisibility() != 0)
    {
      SnsSightPlayerUI.k(this.pdo.pdk).setVisibility(0);
      SnsSightPlayerUI.k(this.pdo.pdk).startAnimation(AnimationUtils.loadAnimation(this.pdo.pdk.mController.uMN, i.a.fast_faded_in));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9.2
 * JD-Core Version:    0.7.0.1
 */