package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.h;

final class MMSuperAlert$1
  implements Runnable
{
  MMSuperAlert$1(MMSuperAlert paramMMSuperAlert, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public final void run()
  {
    String str1;
    if (this.pWt == 0)
    {
      str1 = "";
      if (this.pWu != 0) {
        break label66;
      }
    }
    label66:
    for (String str2 = "";; str2 = this.pWw.getString(this.pWu))
    {
      h.a(this.pWw, str1, str2, this.pWv, new DialogInterface.OnClickListener()new MMSuperAlert.1.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          MMSuperAlert.1.this.pWw.finish();
        }
      }, new MMSuperAlert.1.2(this));
      return;
      str1 = this.pWw.getString(this.pWt);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMSuperAlert.1
 * JD-Core Version:    0.7.0.1
 */