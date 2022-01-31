package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.io.File;

final class ComposeUI$16
  implements DialogInterface.OnClickListener
{
  ComposeUI$16(ComposeUI paramComposeUI, int paramInt, File paramFile, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68194);
    if (ComposeUI.E(this.pLX).cer() + this.etV > 52428800)
    {
      h.a(this.pLX, 2131302153, 2131297087, null);
      AppMethodBeat.o(68194);
      return;
    }
    EditText localEditText;
    if (ComposeUI.j(this.pLX).getText().toString().trim().length() == 0)
    {
      paramDialogInterface = this.val$file.getName().trim();
      paramInt = paramDialogInterface.lastIndexOf(".");
      localEditText = ComposeUI.j(this.pLX);
      if (paramInt <= 0) {
        break label151;
      }
    }
    for (;;)
    {
      localEditText.setText(paramDialogInterface.substring(0, paramInt));
      ab.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(ComposeUI.a(this.pLX)) });
      ComposeUI.E(this.pLX).fO(this.val$path, null);
      AppMethodBeat.o(68194);
      return;
      label151:
      paramInt = paramDialogInterface.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.16
 * JD-Core Version:    0.7.0.1
 */