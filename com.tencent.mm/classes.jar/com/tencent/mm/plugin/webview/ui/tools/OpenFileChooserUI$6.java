package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class OpenFileChooserUI$6
  implements Runnable
{
  OpenFileChooserUI$6(OpenFileChooserUI paramOpenFileChooserUI, Intent paramIntent, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(79652);
    Object localObject2 = this.val$data.getStringArrayListExtra("CropImage_OutputPath_List");
    boolean bool1 = this.val$data.getBooleanExtra("isTakePhoto", false);
    boolean bool2 = this.val$data.getBooleanExtra("CropImage_Compress_Img", true);
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = WebViewJSSDKFileItem.aVX(str1);
      String str2 = localWebViewJSSDKFileItem.diQ;
      localWebViewJSSDKFileItem.jay = bool2;
      g.emF().a(localWebViewJSSDKFileItem);
      ad.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[] { str1, str2 });
      ((ArrayList)localObject1).add(str2);
    }
    localObject1 = aw.az((ArrayList)localObject1);
    ad.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[] { localObject1 });
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("key_pick_local_pic_callback_local_ids", (String)localObject1);
    if (bool1) {}
    for (localObject1 = "camera";; localObject1 = "album")
    {
      ((Intent)localObject2).putExtra("key_pick_local_pic_source_type", (String)localObject1);
      ((Intent)localObject2).putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.a(this.Bdy));
      this.Bdy.setResult(this.val$resultCode, (Intent)localObject2);
      this.Bdy.finish();
      AppMethodBeat.o(79652);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6
 * JD-Core Version:    0.7.0.1
 */