package org.xwalk.core;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Iterator;

class XWalkDialogManager$1
  implements DialogInterface.OnShowListener
{
  XWalkDialogManager$1(XWalkDialogManager paramXWalkDialogManager, ArrayList paramArrayList, AlertDialog paramAlertDialog) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.val$actions.iterator();
    while (paramDialogInterface.hasNext())
    {
      XWalkDialogManager.ButtonAction localButtonAction = (XWalkDialogManager.ButtonAction)paramDialogInterface.next();
      Button localButton = this.val$dialog.getButton(localButtonAction.mWhich);
      if (localButton == null)
      {
        if (localButtonAction.mMandatory) {
          throw new RuntimeException("Button " + localButtonAction.mWhich + " is mandatory");
        }
      }
      else if (localButtonAction.mClickAction != null) {
        localButton.setOnClickListener(new XWalkDialogManager.1.1(this, localButtonAction.mClickAction));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.xwalk.core.XWalkDialogManager.1
 * JD-Core Version:    0.7.0.1
 */