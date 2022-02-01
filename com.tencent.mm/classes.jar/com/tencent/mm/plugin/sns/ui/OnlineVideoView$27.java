package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;

final class OnlineVideoView$27
  implements Runnable
{
  OnlineVideoView$27(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(292837);
    Object localObject = f.aYg(OnlineVideoView.P(this.KHP));
    if ((localObject == null) || (((b)localObject).height == 0) || (((b)localObject).width == 0))
    {
      AppMethodBeat.o(292837);
      return;
    }
    int i = SightVideoJNI.getMp4RotateVFS(OnlineVideoView.P(this.KHP));
    if ((i == 90) || (i == 270)) {
      i = ((b)localObject).width;
    }
    int k;
    for (int j = ((b)localObject).height;; j = ((b)localObject).width)
    {
      localObject = a.HLt;
      float f = a.fvZ() * 1.0F / j;
      i = (int)(i * f);
      localObject = a.HLt;
      k = a.getDisplayHeight();
      j = (k - i) / 2;
      if (j > 0) {
        break;
      }
      OnlineVideoView.c(this.KHP, k);
      AppMethodBeat.o(292837);
      return;
      i = ((b)localObject).height;
    }
    if (j < this.KHP.getBottomSafeHeight())
    {
      i = this.KHP.getBottomSafeHeight() - j;
      if (i <= j) {
        break label320;
      }
      i = j;
    }
    label320:
    for (;;)
    {
      OnlineVideoView.d(this.KHP, i);
      localObject = (RelativeLayout.LayoutParams)((View)this.KHP.txH).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i + j);
      OnlineVideoView.c(this.KHP, k - (i + j));
      final RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)OnlineVideoView.C(this.KHP).getLayoutParams();
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = (i + j);
      localLayoutParams.topMargin = (j - i);
      h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293214);
          ((View)OnlineVideoView.27.this.KHP.txH).setLayoutParams(this.Ogi);
          OnlineVideoView.C(OnlineVideoView.27.this.KHP).setLayoutParams(localLayoutParams);
          OnlineVideoView.C(OnlineVideoView.27.this.KHP).setScaleType(ImageView.ScaleType.CENTER_CROP);
          AppMethodBeat.o(293214);
        }
      });
      AppMethodBeat.o(292837);
      return;
      OnlineVideoView.c(this.KHP, k - j);
      AppMethodBeat.o(292837);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.27
 * JD-Core Version:    0.7.0.1
 */