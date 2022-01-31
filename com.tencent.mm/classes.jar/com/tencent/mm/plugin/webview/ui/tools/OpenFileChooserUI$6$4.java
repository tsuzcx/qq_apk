package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class OpenFileChooserUI$6$4
  implements Runnable
{
  OpenFileChooserUI$6$4(OpenFileChooserUI.6 param6, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(7452);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_pick_local_media_callback_type", 1);
    localIntent.putExtra("key_pick_local_media_local_id", this.nlv);
    localIntent.putExtra("key_pick_local_media_thumb_local_id", this.vbk);
    ab.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", new Object[] { this.vbk });
    this.vbh.vbg.setResult(-1, localIntent);
    this.vbh.vbg.finish();
    AppMethodBeat.o(7452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6.4
 * JD-Core Version:    0.7.0.1
 */