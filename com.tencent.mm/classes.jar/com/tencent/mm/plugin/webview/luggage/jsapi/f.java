package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends bo<com.tencent.mm.plugin.webview.luggage.f>
{
  public final void a(Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78523);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("card_list");
      localObject = ((JSONObject)localObject).optString("tempalate_id");
      Intent localIntent = new Intent();
      localIntent.putExtra("card_list", paramString);
      localIntent.putExtra("key_template_id", (String)localObject);
      localIntent.putExtra("key_from_scene", 7);
      ((MMActivity)paramContext).mmSetOnActivityResultCallback(new MMActivity.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78522);
          if (paramAnonymousInt1 == (f.this.hashCode() & 0xFFFF))
          {
            if (paramAnonymousInt2 == -1)
            {
              parama.f(null, null);
              AppMethodBeat.o(78522);
              return;
            }
            parama.f("fail", null);
          }
          AppMethodBeat.o(78522);
        }
      });
      d.a(paramContext, "card", ".ui.CardViewEntranceUI", localIntent, 0xFFFF & hashCode(), false);
      AppMethodBeat.o(78523);
      return;
    }
    catch (JSONException paramContext)
    {
      ac.e("MicroMsg.JsApiBatchViewCard", "paras data error: " + paramContext.getMessage());
      parama.f("fail", null);
      AppMethodBeat.o(78523);
    }
  }
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.f>.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "batchViewCard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.f
 * JD-Core Version:    0.7.0.1
 */