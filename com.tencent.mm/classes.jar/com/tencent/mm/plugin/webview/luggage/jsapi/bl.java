package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Looper;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.f.8;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.Map;

public class bl
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(com.tencent.luggage.d.a<f>.a parama)
  {
    int i = 0;
    AppMethodBeat.i(78638);
    ad.i("MicroMsg.JsApiShowSmileyPanel", "invokeInOwn");
    Object localObject = (f)parama.bZU;
    if (((f)localObject).ASZ != null) {
      if (Thread.currentThread().getId() != ((f)localObject).mHandler.getLooper().getThread().getId()) {
        break label111;
      }
    }
    label111:
    for (i = ((f)localObject).ASZ.ers(); i > 0; i = ((Integer)new f.8((f)localObject, Integer.valueOf(0)).b(((f)localObject).mHandler)).intValue())
    {
      localObject = new HashMap();
      ((Map)localObject).put("height", Integer.valueOf(com.tencent.mm.cd.a.ar(((f)parama.bZU).mContext, i)));
      parama.c("", (Map)localObject);
      AppMethodBeat.o(78638);
      return;
    }
    parama.a("fail", null);
    AppMethodBeat.o(78638);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showSmileyPanel";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bl
 * JD-Core Version:    0.7.0.1
 */