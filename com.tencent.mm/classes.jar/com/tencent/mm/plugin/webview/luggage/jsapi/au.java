package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Looper;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e.10;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public class au
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(com.tencent.luggage.e.a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    int i = 0;
    y.i("MicroMsg.JsApiShowSmileyPanel", "invokeInOwn");
    Object localObject = (com.tencent.mm.plugin.webview.luggage.e)parama.big;
    if (((com.tencent.mm.plugin.webview.luggage.e)localObject).rbG != null) {
      if (Thread.currentThread().getId() != ((com.tencent.mm.plugin.webview.luggage.e)localObject).mHandler.getLooper().getThread().getId()) {
        break label101;
      }
    }
    label101:
    for (i = ((com.tencent.mm.plugin.webview.luggage.e)localObject).rbG.cgU(); i > 0; i = ((Integer)new e.10((com.tencent.mm.plugin.webview.luggage.e)localObject, Integer.valueOf(0)).b(((com.tencent.mm.plugin.webview.luggage.e)localObject).mHandler)).intValue())
    {
      localObject = new HashMap();
      ((Map)localObject).put("height", Integer.valueOf(com.tencent.mm.cb.a.ad(((com.tencent.mm.plugin.webview.luggage.e)parama.big).mContext, i)));
      parama.c("", (Map)localObject);
      return;
    }
    parama.a("fail", null);
  }
  
  public final String name()
  {
    return "showSmileyPanel";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.au
 * JD-Core Version:    0.7.0.1
 */