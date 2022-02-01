package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Looper;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.g.9;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.HashMap;
import java.util.Map;

public class bp
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    int i = 0;
    AppMethodBeat.i(78638);
    Log.i("MicroMsg.JsApiShowSmileyPanel", "invokeInOwn");
    Object localObject = (g)paramb.crg;
    if (((g)localObject).PPz != null) {
      if (Thread.currentThread().getId() != ((g)localObject).mHandler.getLooper().getThread().getId()) {
        break label111;
      }
    }
    label111:
    for (i = ((g)localObject).PPz.hcf(); i > 0; i = ((Integer)new g.9((g)localObject, Integer.valueOf(0)).exec(((g)localObject).mHandler)).intValue())
    {
      localObject = new HashMap();
      ((Map)localObject).put("height", Integer.valueOf(a.H(((g)paramb.crg).mContext, i)));
      paramb.d("", (Map)localObject);
      AppMethodBeat.o(78638);
      return;
    }
    paramb.a("fail", null);
    AppMethodBeat.o(78638);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showSmileyPanel";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bp
 * JD-Core Version:    0.7.0.1
 */