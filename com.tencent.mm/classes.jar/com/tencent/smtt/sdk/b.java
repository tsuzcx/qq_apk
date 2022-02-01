package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.b.c;

class b
  implements com.tencent.smtt.export.external.interfaces.DownloadListener
{
  private byte _hellAccFlag_;
  private DownloadListener a;
  private WebView b;
  
  public b(WebView paramWebView, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    this.a = paramDownloadListener;
    this.b = paramWebView;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(55134);
    onDownloadStart(paramString1, null, null, paramString2, paramString3, paramString4, paramLong, null, null);
    AppMethodBeat.o(55134);
  }
  
  public void onDownloadStart(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    AppMethodBeat.i(55133);
    if (this.a == null)
    {
      if (QbSdk.canOpenMimeFileType(this.b.getContext(), paramString5))
      {
        paramString2 = new Intent("com.tencent.QQBrowser.action.sdk.document");
        paramString2.setFlags(268435456);
        paramString2.putExtra("key_reader_sdk_url", paramString1);
        paramString2.putExtra("key_reader_sdk_type", 1);
        paramString2.setData(Uri.parse(paramString1));
        paramString1 = this.b.getContext();
        paramString2 = new com.tencent.mm.hellhoundlib.b.a().ba(paramString2);
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.aeD(), "com/tencent/smtt/sdk/b", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString1.startActivity((Intent)paramString2.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/smtt/sdk/b", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(55133);
        return;
      }
      paramString2 = this.b.getContext().getApplicationInfo();
      if ((paramString2 == null) || (!"com.tencent.mm".equals(paramString2.packageName))) {
        c.a(this.b.getContext(), paramString1, null, null);
      }
      AppMethodBeat.o(55133);
      return;
    }
    this.a.onDownloadStart(paramString1, paramString3, paramString4, paramString5, paramLong);
    AppMethodBeat.o(55133);
  }
  
  public void onDownloadVideo(String paramString, long paramLong, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b
 * JD-Core Version:    0.7.0.1
 */