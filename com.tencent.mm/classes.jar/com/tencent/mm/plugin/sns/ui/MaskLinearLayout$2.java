package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class MaskLinearLayout$2
  implements View.OnTouchListener
{
  MaskLinearLayout$2(MaskLinearLayout paramMaskLinearLayout) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    y.e("test", "touch: " + paramMotionEvent.getAction());
    if (!MaskLinearLayout.b(this.oQF)) {}
    label179:
    for (;;)
    {
      return false;
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        if (MaskLinearLayout.e(this.oQF) == null) {
          break label179;
        }
        paramView = MaskLinearLayout.e(this.oQF).iterator();
        while (paramView.hasNext())
        {
          MaskImageView localMaskImageView = (MaskImageView)paramView.next();
          localMaskImageView.d(localMaskImageView, paramMotionEvent);
        }
        paramView.setPressed(true);
        MaskLinearLayout.a(this.oQF);
        paramView.invalidate();
        MaskLinearLayout.d(this.oQF).removeCallbacks(MaskLinearLayout.c(this.oQF));
        continue;
        MaskLinearLayout.d(this.oQF).post(MaskLinearLayout.c(this.oQF));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */