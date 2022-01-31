package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class AbstractVideoView$7
  implements View.OnClickListener
{
  AbstractVideoView$7(AbstractVideoView paramAbstractVideoView) {}
  
  public final void onClick(View paramView)
  {
    y.i(this.rYV.TAG, "%s seek bar play button on click ", new Object[] { this.rYV.ayL() });
    paramView = this.rYV;
    if (paramView.iuC != null)
    {
      if (paramView.isPlaying()) {
        paramView.pause();
      }
    }
    else {
      return;
    }
    if (bk.bl(paramView.iuC.getVideoPath()))
    {
      paramView.start();
      return;
    }
    paramView.play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.7
 * JD-Core Version:    0.7.0.1
 */