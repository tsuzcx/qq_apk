package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.a.d;

class b
  implements com.tencent.smtt.export.external.interfaces.DownloadListener
{
  private DownloadListener a;
  private WebView b;
  
  public b(WebView paramWebView, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    this.a = paramDownloadListener;
    this.b = paramWebView;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(63901);
    onDownloadStart(paramString1, null, null, paramString2, paramString3, paramString4, paramLong, null, null);
    AppMethodBeat.o(63901);
  }
  
  public void onDownloadStart(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    AppMethodBeat.i(63900);
    if (this.a == null)
    {
      if (QbSdk.canOpenMimeFileType(this.b.getContext(), paramString5))
      {
        paramString2 = new Intent("com.tencent.QQBrowser.action.sdk.document");
        paramString2.setFlags(268435456);
        paramString2.putExtra("key_reader_sdk_url", paramString1);
        paramString2.putExtra("key_reader_sdk_type", 1);
        paramString2.setData(Uri.parse(paramString1));
        this.b.getContext().startActivity(paramString2);
        AppMethodBeat.o(63900);
        return;
      }
      paramString2 = this.b.getContext().getApplicationInfo();
      if ((paramString2 == null) || (!"com.tencent.mm".equals(paramString2.packageName))) {
        d.a(this.b.getContext(), paramString1, null, null);
      }
      AppMethodBeat.o(63900);
      return;
    }
    this.a.onDownloadStart(paramString1, paramString3, paramString4, paramString5, paramLong);
    AppMethodBeat.o(63900);
  }
  
  public void onDownloadVideo(String paramString, long paramLong, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.b
 * JD-Core Version:    0.7.0.1
 */