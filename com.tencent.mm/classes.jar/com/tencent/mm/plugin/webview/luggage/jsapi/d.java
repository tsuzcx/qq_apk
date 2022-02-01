package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(175740);
    String str1 = paramb.eiZ.eif.optString("card_list");
    String str2 = ((g)paramb.eiY).ejT.getString("srcUsername");
    String str3 = ((g)paramb.eiY).getUrl();
    String str4 = paramb.eiZ.eif.optString("consumedCardId");
    ((g)paramb.eiY).ejT.getString("KTemplateId");
    Log.i("MicroMsg.JsApiBatchAddCard", "doBatchAddCard consumedCardId %s", new Object[] { str4 });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_in_card_list", str1);
    localIntent.putExtra("key_from_scene", 7);
    localIntent.putExtra("src_username", str2);
    localIntent.putExtra("js_url", str3);
    localIntent.putExtra("key_consumed_card_id", str4);
    ((MMActivity)((g)paramb.eiY).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(175739);
        HashMap localHashMap;
        if (paramAnonymousInt1 == (d.this.hashCode() & 0xFFFF))
        {
          localHashMap = new HashMap();
          if (paramAnonymousIntent != null) {
            localHashMap.put("card_list", Util.nullAs(paramAnonymousIntent.getStringExtra("card_list"), ""));
          }
          if (paramAnonymousInt2 == -1)
          {
            paramb.d("", localHashMap);
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
            paramb.d("fail", localHashMap);
            AppMethodBeat.o(175739);
            return;
          }
          paramb.d("cancel", localHashMap);
          AppMethodBeat.o(175739);
          return;
        }
      }
    });
    c.a(((g)paramb.eiY).mContext, "card", ".ui.CardAddEntranceUI", localIntent, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(175740);
  }
  
  public final int dgI()
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