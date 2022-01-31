package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.d;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.sdk.platformtools.bk;

class i$d
  implements d
{
  public final void a(Context paramContext, Bundle paramBundle, b paramb)
  {
    String str1 = paramBundle.getString("result");
    if (bk.bl(str1)) {
      return;
    }
    String str2 = paramBundle.getString("url");
    int i = paramBundle.getInt("codeType");
    int j = paramBundle.getInt("codeVersion");
    paramBundle = new Intent();
    paramBundle.setClass(paramContext, WebviewScanImageActivity.class);
    paramBundle.setFlags(603979776);
    paramBundle.putExtra("key_string_for_scan", str1);
    paramBundle.putExtra("key_string_for_url", str2);
    paramBundle.putExtra("key_codetype_for_scan", i);
    paramBundle.putExtra("key_codeversion_for_scan", j);
    paramContext.startActivity(paramBundle);
    paramb.g(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.d
 * JD-Core Version:    0.7.0.1
 */