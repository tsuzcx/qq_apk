package com.tencent.mm.ui.base;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class VoiceSearchEditText$1
  implements View.OnTouchListener
{
  VoiceSearchEditText$1(VoiceSearchEditText paramVoiceSearchEditText) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.vbN;
    if (paramView.getCompoundDrawables()[2] == null) {
      return false;
    }
    if (paramMotionEvent.getAction() != 1) {
      return true;
    }
    VoiceSearchEditText.a(this.vbN, true);
    if ((VoiceSearchEditText.a(this.vbN)) && (VoiceSearchEditText.b(this.vbN)) && (paramView.getText().toString().equals(""))) {
      if (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.vbN.vbG.getIntrinsicWidth() - a.fromDPToPix(VoiceSearchEditText.c(paramView), 25))
      {
        if (VoiceSearchEditText.d(this.vbN) != null)
        {
          y.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
          if ((this.vbN.getContext() instanceof MMActivity)) {
            ((MMActivity)this.vbN.getContext()).hideVKB(paramView);
          }
          VoiceSearchEditText.d(this.vbN).onClick(this.vbN);
          return true;
        }
      }
      else
      {
        paramView.requestFocus();
        if ((this.vbN.getContext() instanceof Activity)) {
          MMActivity.showVKB((Activity)this.vbN.getContext());
        }
        if (VoiceSearchEditText.d(this.vbN) != null) {
          VoiceSearchEditText.d(this.vbN).onClick(null);
        }
      }
    }
    for (;;)
    {
      return false;
      if (paramView.getText().toString().length() > 0)
      {
        if (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.vbN.vbI.getIntrinsicWidth() - a.fromDPToPix(VoiceSearchEditText.c(paramView), 25))
        {
          paramView.setText("");
          VoiceSearchEditText.e(this.vbN);
        }
        else if (!paramView.isFocused())
        {
          paramView.requestFocus();
          if ((this.vbN.getContext() instanceof Activity)) {
            MMActivity.showVKB((Activity)this.vbN.getContext());
          }
        }
      }
      else if (VoiceSearchEditText.d(this.vbN) != null) {
        VoiceSearchEditText.d(this.vbN).onClick(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText.1
 * JD-Core Version:    0.7.0.1
 */