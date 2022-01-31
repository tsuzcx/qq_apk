package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class a$1
  implements Runnable
{
  a$1(a parama, Map paramMap, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, int paramInt2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(91330);
    if (!aa.Je(0))
    {
      ab.e("StartWebSearchService", "fts h5 template not avail");
      AppMethodBeat.o(91330);
      return;
    }
    Object localObject1 = "";
    int i = -1;
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "";
    if (this.uIm != null)
    {
      localObject2 = (String)this.uIm.get("sugId");
      if (!this.uIm.containsKey("parentSearchID")) {
        break label546;
      }
      localObject1 = (String)this.uIm.get("parentSearchID");
    }
    try
    {
      localJSONObject.put("parentSearchID", localObject1);
      localObject3 = (String)this.uIm.get("sugId");
      i = bo.apV((String)this.uIm.get("sceneActionType"));
      localObject2 = localObject1;
      localObject1 = localObject3;
      ab.i("StartWebSearchService", "startWebSearch parentSearchID=%s", new Object[] { localObject2 });
      String str = String.valueOf(System.currentTimeMillis());
      localObject3 = aa.IZ(this.fwD);
      aa.a(str, this.hpi, (String)localObject3, this.Cr, this.fwD, (String)localObject1, i, (String)localObject2);
      localObject1 = new lq();
      ((lq)localObject1).cBH.scene = 0;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
      localObject1 = aa.a(this.fwD, this.uIn, 0, Uri.encode(localJSONObject.toString()), "", this.hpi, this.Cr, "", (String)localObject3, "", str);
      if (this.uIm != null) {
        ((Map)localObject1).putAll(this.uIm);
      }
    }
    catch (JSONException localJSONException)
    {
      try
      {
        Object localObject3;
        ((Map)localObject1).put("query", q.encode(this.Cr, "UTF-8"));
        ((Map)localObject1).put("sessionId", this.hpi);
        localObject1 = aa.F((Map)localObject1);
        localObject2 = aa.cZp();
        ((Intent)localObject2).putExtra("ftsType", this.bHS);
        ((Intent)localObject2).putExtra("title", this.cbK);
        ((Intent)localObject2).putExtra("ftsbizscene", this.fwD);
        ((Intent)localObject2).putExtra("ftsQuery", this.Cr);
        if ((!TextUtils.isEmpty(this.Cr)) || (this.uIo))
        {
          bool = true;
          ((Intent)localObject2).putExtra("ftsInitToSearch", bool);
          ((Intent)localObject2).putExtra("sessionId", this.hpi);
          ((Intent)localObject2).putExtra("subSessionId", (String)localObject3);
          ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
          ((Intent)localObject2).putExtra("key_preload_biz", a.cYR());
          ((Intent)localObject2).putExtra("key_weapp_url", a.agl(this.hpi));
          if (this.uIp) {
            ((Intent)localObject2).putExtra("status_bar_style", "black");
          }
          if (this.uIq != 2147483647) {
            ((Intent)localObject2).putExtra("customize_status_bar_color", this.uIq);
          }
          ((Intent)localObject2).putExtra("key_load_js_without_delay", true);
          if (this.fwD == 56) {
            ((Intent)localObject2).putExtra("ftsneedkeyboard", true);
          }
          d.b(this.val$context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", (Intent)localObject2);
          a.cYS();
          AppMethodBeat.o(91330);
          return;
          label546:
          localObject3 = new StringBuilder();
          if (this.uIm.containsKey("clickType")) {}
          for (localObject1 = (String)this.uIm.get("clickType") + ":";; localObject1 = "0:")
          {
            localObject1 = (String)localObject1 + (String)localObject2 + ":" + this.Cr + ":";
            break;
          }
          localJSONException = localJSONException;
          ab.a("StartWebSearchService", "", new Object[] { localJSONException });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ((Map)localObject1).put("query", this.Cr);
          continue;
          boolean bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.1
 * JD-Core Version:    0.7.0.1
 */