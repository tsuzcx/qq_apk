package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.List;

final class MaskLinearLayout$2
  implements View.OnTouchListener
{
  MaskLinearLayout$2(MaskLinearLayout paramMaskLinearLayout) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38315);
    ab.e("test", "touch: " + paramMotionEvent.getAction());
    if (!MaskLinearLayout.b(this.rIr))
    {
      AppMethodBeat.o(38315);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while (MaskLinearLayout.e(this.rIr) != null)
    {
      paramView = MaskLinearLayout.e(this.rIr).iterator();
      while (paramView.hasNext())
      {
        MaskImageView localMaskImageView = (MaskImageView)paramView.next();
        localMaskImageView.d(localMaskImageView, paramMotionEvent);
      }
      paramView.setPressed(true);
      MaskLinearLayout.a(this.rIr);
      paramView.invalidate();
      MaskLinearLayout.d(this.rIr).removeCallbacks(MaskLinearLayout.c(this.rIr));
      continue;
      MaskLinearLayout.d(this.rIr).post(MaskLinearLayout.c(this.rIr));
    }
    AppMethodBeat.o(38315);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */