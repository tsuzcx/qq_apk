package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ai;

final class a$6
  implements View.OnClickListener
{
  a$6(a parama) {}
  
  public final void onClick(View paramView)
  {
    this.mpw.bkc();
    if ((!this.mpw.mpo) && (this.mpw.mpf <= this.mpw.mgW.duration))
    {
      paramView = this.mpw;
      this.mpw.mph = -1;
      paramView.mpg = -1;
      this.mpw.mlx.bkl();
      this.mpw.mpd = this.mpw.mlx.mqW;
      this.mpw.mpe = false;
    }
    if ((!this.mpw.mpo) && (this.mpw.mpv) && (this.mpw.mpn != null)) {
      ai.d(new a.6.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a.6
 * JD-Core Version:    0.7.0.1
 */