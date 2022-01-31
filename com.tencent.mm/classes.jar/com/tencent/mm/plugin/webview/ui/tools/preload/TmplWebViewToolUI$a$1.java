package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.brandservice.a.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class TmplWebViewToolUI$a$1
  implements a.b
{
  TmplWebViewToolUI$a$1(TmplWebViewToolUI.a parama, c paramc) {}
  
  public final void a(boolean paramBoolean, a parama)
  {
    boolean bool;
    Object localObject;
    if (parama != null)
    {
      bool = true;
      y.i("MicroMsg.WebviewUIForTmpl", "isSuccess:%b, bizAppMsgContext:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((!paramBoolean) || (parama == null)) {
        break label165;
      }
      localObject = parama.field_forceUrl;
      if (parama.field_content == null) {
        break label160;
      }
    }
    label160:
    for (int i = parama.field_content.length();; i = 0)
    {
      y.d("MicroMsg.WebviewUIForTmpl", "[processData] invoke callback forceUrl:%s data.size:%d", new Object[] { localObject, Integer.valueOf(i) });
      y.v("MicroMsg.WebviewUIForTmpl", "[processData] invoke callback data %s", new Object[] { parama.field_content });
      localObject = new Bundle();
      ((Bundle)localObject).putString("forceUrl", parama.field_forceUrl);
      ((Bundle)localObject).putString("data", parama.field_content);
      ((Bundle)localObject).putBoolean("isSuccess", true);
      this.dGE.U(localObject);
      return;
      bool = false;
      break;
    }
    label165:
    parama = new Bundle();
    parama.putBoolean("isSuccess", false);
    this.dGE.U(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.TmplWebViewToolUI.a.1
 * JD-Core Version:    0.7.0.1
 */