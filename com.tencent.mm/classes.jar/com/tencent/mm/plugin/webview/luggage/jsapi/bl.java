package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Looper;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.f.8;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bn;
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
    ac.i("MicroMsg.JsApiShowSmileyPanel", "invokeInOwn");
    Object localObject = (f)parama.bWR;
    if (((f)localObject).Clm != null) {
      if (Thread.currentThread().getId() != ((f)localObject).mHandler.getLooper().getThread().getId()) {
        break label111;
      }
    }
    label111:
    for (i = ((f)localObject).Clm.eGM(); i > 0; i = ((Integer)new f.8((f)localObject, Integer.valueOf(0)).b(((f)localObject).mHandler)).intValue())
    {
      localObject = new HashMap();
      ((Map)localObject).put("height", Integer.valueOf(com.tencent.mm.cc.a.ax(((f)parama.bWR).mContext, i)));
      parama.c("", (Map)localObject);
      AppMethodBeat.o(78638);
      return;
    }
    parama.a("fail", null);
    AppMethodBeat.o(78638);
  }
  
  public final int bYk()
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