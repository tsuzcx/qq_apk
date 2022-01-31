package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bc;
import java.io.File;
import java.io.IOException;

final class j$5
  implements DialogInterface.OnClickListener
{
  j$5(j paramj, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7646);
    try
    {
      paramDialogInterface = this.vcO.ddt().getDir("expose", 0);
      paramDialogInterface.mkdirs();
      paramDialogInterface = paramDialogInterface.getAbsolutePath() + "/screenshot.jpg";
      com.tencent.mm.sdk.platformtools.d.a(bc.au(this.vcO.ddt()), 75, Bitmap.CompressFormat.JPEG, paramDialogInterface, true);
      this.val$intent.putExtra("k_webview_img", paramDialogInterface);
      com.tencent.mm.bq.d.b(this.vcO.ddt(), "webview", ".ui.tools.WebViewUI", this.val$intent);
      AppMethodBeat.o(7646);
      return;
    }
    catch (IOException paramDialogInterface)
    {
      ab.e("MicroMsg.WebViewMenuHelper", "[oneliang]save screen shot to file error, ex = " + paramDialogInterface.getMessage());
      AppMethodBeat.o(7646);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.5
 * JD-Core Version:    0.7.0.1
 */