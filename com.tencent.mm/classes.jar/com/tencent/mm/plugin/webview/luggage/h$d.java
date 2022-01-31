package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.ipc.a;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.sdk.platformtools.bo;

class h$d
  implements c
{
  public final void a(Context paramContext, Bundle paramBundle, a parama)
  {
    AppMethodBeat.i(6140);
    String str1 = paramBundle.getString("result");
    if (bo.isNullOrNil(str1))
    {
      AppMethodBeat.o(6140);
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
    parama.o(null);
    AppMethodBeat.o(6140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.d
 * JD-Core Version:    0.7.0.1
 */