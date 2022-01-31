package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class SettingCheckUnProcessWalletConvUI$2
  implements View.OnTouchListener
{
  SettingCheckUnProcessWalletConvUI$2(SettingCheckUnProcessWalletConvUI paramSettingCheckUnProcessWalletConvUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    }
    this.vUd.XM();
    SettingCheckUnProcessWalletConvUI.a(this.vUd)[0] = ((int)paramMotionEvent.getRawX());
    SettingCheckUnProcessWalletConvUI.a(this.vUd)[1] = ((int)paramMotionEvent.getRawY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.2
 * JD-Core Version:    0.7.0.1
 */