package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class OpenFileChooserUI$8$4
  implements Runnable
{
  OpenFileChooserUI$8$4(OpenFileChooserUI.8 param8, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(175760);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_pick_local_media_callback_type", 1);
    localIntent.putExtra("key_pick_local_media_local_id", this.xCb);
    localIntent.putExtra("key_pick_local_media_thumb_local_id", this.JeE);
    Log.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", new Object[] { this.JeE });
    this.JeB.JeA.setResult(-1, localIntent);
    this.JeB.JeA.finish();
    AppMethodBeat.o(175760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.8.4
 * JD-Core Version:    0.7.0.1
 */