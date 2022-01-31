package com.tencent.mm.plugin.sns.ui;

import android.widget.Gallery;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.e.b;

final class SnsBrowseUI$4
  implements e.b
{
  SnsBrowseUI$4(SnsBrowseUI paramSnsBrowseUI) {}
  
  public final void onAnimationEnd()
  {
    SnsBrowseUI.e(this.oVL).post(new SnsBrowseUI.4.2(this));
  }
  
  public final void onAnimationStart()
  {
    SnsInfoFlip localSnsInfoFlip = this.oVL.oVy;
    if (localSnsInfoFlip.oYO != null) {
      localSnsInfoFlip.oYO.setVisibility(8);
    }
    SnsBrowseUI.e(this.oVL).postDelayed(new Runnable()
    {
      public final void run()
      {
        Object localObject = SnsBrowseUI.4.this.oVL.oVy;
        if (((SnsInfoFlip)localObject).oYB != null)
        {
          localObject = ((SnsInfoFlip)localObject).oYB.getSelectedView();
          if ((localObject instanceof MultiTouchImageView)) {
            ((MultiTouchImageView)localObject).cAy();
          }
        }
      }
    }, 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI.4
 * JD-Core Version:    0.7.0.1
 */