package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.io.File;

final class ComposeUI$16
  implements DialogInterface.OnClickListener
{
  ComposeUI$16(ComposeUI paramComposeUI, int paramInt, File paramFile, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ComposeUI.E(this.ngJ).buf() + this.dAt > 52428800)
    {
      h.a(this.ngJ, b.j.plugin_qqmail_upload_attach_size_exceed, b.j.app_tip, null);
      return;
    }
    EditText localEditText;
    if (ComposeUI.j(this.ngJ).getText().toString().trim().length() == 0)
    {
      paramDialogInterface = this.val$file.getName().trim();
      paramInt = paramDialogInterface.lastIndexOf(".");
      localEditText = ComposeUI.j(this.ngJ);
      if (paramInt <= 0) {
        break label138;
      }
    }
    for (;;)
    {
      localEditText.setText(paramDialogInterface.substring(0, paramInt));
      y.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(ComposeUI.a(this.ngJ)) });
      ComposeUI.E(this.ngJ).eq(this.dlh, null);
      return;
      label138:
      paramInt = paramDialogInterface.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.16
 * JD-Core Version:    0.7.0.1
 */