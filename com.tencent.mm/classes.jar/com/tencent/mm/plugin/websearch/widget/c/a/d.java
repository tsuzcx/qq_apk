package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.websearch.widget.c.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  implements a
{
  public final boolean RE(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  public final boolean RF(String paramString)
  {
    if (!RE(paramString)) {
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("useJs", true);
    com.tencent.mm.br.d.b(ae.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    return true;
  }
  
  public final boolean gQ(long paramLong)
  {
    return c.z(paramLong, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.d
 * JD-Core Version:    0.7.0.1
 */