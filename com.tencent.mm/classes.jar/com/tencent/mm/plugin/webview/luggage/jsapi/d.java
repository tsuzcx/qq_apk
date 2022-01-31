package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6283);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("card_list");
      localObject = ((JSONObject)localObject).optString("tempalate_id");
      Intent localIntent = new Intent();
      localIntent.putExtra("card_list", paramString);
      localIntent.putExtra("key_template_id", (String)localObject);
      localIntent.putExtra("key_from_scene", 7);
      ((MMActivity)paramContext).mmSetOnActivityResultCallback(new d.1(this, parama));
      com.tencent.mm.bq.d.a(paramContext, "card", ".ui.CardViewEntranceUI", localIntent, 0xFFFF & hashCode(), false);
      AppMethodBeat.o(6283);
      return;
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiBatchViewCard", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(6283);
    }
  }
  
  public final void b(a<e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "batchViewCard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.d
 * JD-Core Version:    0.7.0.1
 */