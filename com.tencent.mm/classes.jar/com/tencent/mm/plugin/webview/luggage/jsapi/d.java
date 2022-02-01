package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(175740);
    String str1 = parama.bZV.bZb.optString("card_list");
    String str2 = ((f)parama.bZU).mParams.getString("srcUsername");
    String str3 = ((f)parama.bZU).getUrl();
    String str4 = parama.bZV.bZb.optString("consumedCardId");
    ((f)parama.bZU).mParams.getString("KTemplateId");
    ad.i("MicroMsg.JsApiBatchAddCard", "doBatchAddCard consumedCardId %s", new Object[] { str4 });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_in_card_list", str1);
    localIntent.putExtra("key_from_scene", 7);
    localIntent.putExtra("src_username", str2);
    localIntent.putExtra("js_url", str3);
    localIntent.putExtra("key_consumed_card_id", str4);
    ((MMActivity)((f)parama.bZU).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(175739);
        HashMap localHashMap;
        if (paramAnonymousInt1 == (d.this.hashCode() & 0xFFFF))
        {
          localHashMap = new HashMap();
          if (paramAnonymousIntent != null) {
            localHashMap.put("card_list", bt.by(paramAnonymousIntent.getStringExtra("card_list"), ""));
          }
          if (paramAnonymousInt2 == -1)
          {
            parama.c("", localHashMap);
            AppMethodBeat.o(175739);
            return;
          }
          if (paramAnonymousIntent == null) {
            break label126;
          }
        }
        label126:
        for (paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("result_code", 2);; paramAnonymousInt1 = 2)
        {
          if (paramAnonymousInt1 == 2)
          {
            parama.c("fail", localHashMap);
            AppMethodBeat.o(175739);
            return;
          }
          parama.c("cancel", localHashMap);
          AppMethodBeat.o(175739);
          return;
        }
      }
    });
    com.tencent.mm.bs.d.a(((f)parama.bZU).mContext, "card", ".ui.CardAddEntranceUI", localIntent, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(175740);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "batchAddCard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.d
 * JD-Core Version:    0.7.0.1
 */