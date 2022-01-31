package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.KeyEvent;

final class MMAppMgr$4
  implements DialogInterface.OnCancelListener
{
  MMAppMgr$4(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.eRW.onKeyDown(4, new KeyEvent(0, 4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.4
 * JD-Core Version:    0.7.0.1
 */