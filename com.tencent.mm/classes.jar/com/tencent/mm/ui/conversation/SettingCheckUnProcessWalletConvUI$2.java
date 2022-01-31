package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingCheckUnProcessWalletConvUI$2
  implements View.OnTouchListener
{
  SettingCheckUnProcessWalletConvUI$2(SettingCheckUnProcessWalletConvUI paramSettingCheckUnProcessWalletConvUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34611);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34611);
      return false;
      this.AlZ.hideVKB();
      SettingCheckUnProcessWalletConvUI.a(this.AlZ)[0] = ((int)paramMotionEvent.getRawX());
      SettingCheckUnProcessWalletConvUI.a(this.AlZ)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.2
 * JD-Core Version:    0.7.0.1
 */