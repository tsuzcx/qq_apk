package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class NewTaskUI$4
  implements DialogInterface.OnCancelListener
{
  NewTaskUI$4(NewTaskUI paramNewTaskUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (NewTaskUI.wdY != null)
    {
      NewTaskUI.wdY = null;
      this.wea.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI.4
 * JD-Core Version:    0.7.0.1
 */