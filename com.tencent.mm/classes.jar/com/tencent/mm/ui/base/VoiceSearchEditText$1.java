package com.tencent.mm.ui.base;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class VoiceSearchEditText$1
  implements View.OnTouchListener
{
  VoiceSearchEditText$1(VoiceSearchEditText paramVoiceSearchEditText) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107088);
    paramView = this.zqj;
    if (paramView.getCompoundDrawables()[2] == null)
    {
      AppMethodBeat.o(107088);
      return false;
    }
    if (paramMotionEvent.getAction() != 1)
    {
      AppMethodBeat.o(107088);
      return true;
    }
    VoiceSearchEditText.a(this.zqj, true);
    if ((VoiceSearchEditText.a(this.zqj)) && (VoiceSearchEditText.b(this.zqj)) && (paramView.getText().toString().equals(""))) {
      if (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.zqj.zqc.getIntrinsicWidth() - a.fromDPToPix(VoiceSearchEditText.c(paramView), 25))
      {
        if (VoiceSearchEditText.d(this.zqj) != null)
        {
          ab.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
          if ((this.zqj.getContext() instanceof MMActivity)) {
            ((MMActivity)this.zqj.getContext()).hideVKB(paramView);
          }
          VoiceSearchEditText.d(this.zqj).onClick(this.zqj);
          AppMethodBeat.o(107088);
          return true;
        }
      }
      else
      {
        paramView.requestFocus();
        if ((this.zqj.getContext() instanceof Activity)) {
          MMActivity.showVKB((Activity)this.zqj.getContext());
        }
        if (VoiceSearchEditText.d(this.zqj) != null) {
          VoiceSearchEditText.d(this.zqj).onClick(null);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107088);
      return false;
      if (paramView.getText().toString().length() > 0)
      {
        if (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.zqj.zqe.getIntrinsicWidth() - a.fromDPToPix(VoiceSearchEditText.c(paramView), 25))
        {
          paramView.setText("");
          if (VoiceSearchEditText.e(this.zqj) != null) {
            VoiceSearchEditText.e(this.zqj);
          }
          VoiceSearchEditText.f(this.zqj);
        }
        else if (!paramView.isFocused())
        {
          paramView.requestFocus();
          if ((this.zqj.getContext() instanceof Activity)) {
            MMActivity.showVKB((Activity)this.zqj.getContext());
          }
        }
      }
      else if (VoiceSearchEditText.d(this.zqj) != null) {
        VoiceSearchEditText.d(this.zqj).onClick(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText.1
 * JD-Core Version:    0.7.0.1
 */