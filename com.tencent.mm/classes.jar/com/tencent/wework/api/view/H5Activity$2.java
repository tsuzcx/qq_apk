package com.tencent.wework.api.view;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class H5Activity$2
  implements DownloadListener
{
  H5Activity$2(H5Activity paramH5Activity) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(199019);
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1 = this.Sxy;
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramString2);
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.axQ(), "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)paramString2.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(199019);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(199019);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.view.H5Activity.2
 * JD-Core Version:    0.7.0.1
 */