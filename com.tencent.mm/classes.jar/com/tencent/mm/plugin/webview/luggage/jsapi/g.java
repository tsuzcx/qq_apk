package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6287);
    ab.i("MicroMsg.JsApiChooseImage", "invoke");
    Object localObject3 = parama.byF.bxK;
    Object localObject1 = ((JSONObject)localObject3).optJSONArray("sourceType");
    int k;
    int i;
    int j;
    if (localObject1 != null)
    {
      ab.i("MicroMsg.JsApiChooseImage", "sourceType = " + ((JSONArray)localObject1).toString());
      k = 0;
      i = 0;
      if (k < ((JSONArray)localObject1).length())
      {
        if (((JSONArray)localObject1).optString(k).equals("album")) {
          j = i | 0x1;
        }
        for (;;)
        {
          k += 1;
          i = j;
          break;
          j = i;
          if (((JSONArray)localObject1).optString(k).equals("camera")) {
            j = i | 0x2;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {}
      for (j = 3;; j = i)
      {
        ab.i("MicroMsg.JsApiChooseImage", "real scene = %d", new Object[] { Integer.valueOf(j) });
        if ((j == 2) || (j == 3))
        {
          boolean bool = b.a((Activity)((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext, "android.permission.CAMERA", 113, "", "");
          ab.d("MicroMsg.JsApiChooseImage", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            parama.a("android_permission_denied", null);
            AppMethodBeat.o(6287);
            return;
          }
        }
        k = ((JSONObject)localObject3).optInt("count", 0);
        localObject1 = Boolean.FALSE;
        Object localObject2 = Boolean.FALSE;
        JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("sizeType");
        localObject3 = localObject2;
        Object localObject4 = localObject1;
        if (localJSONArray != null)
        {
          i = 0;
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (i < localJSONArray.length())
          {
            if (localJSONArray.optString(i).equals("original")) {
              localObject3 = Boolean.TRUE;
            }
            for (;;)
            {
              i += 1;
              localObject1 = localObject3;
              break;
              localObject3 = localObject1;
              if (localJSONArray.optString(i).equals("compressed"))
              {
                localObject2 = Boolean.TRUE;
                localObject3 = localObject1;
              }
            }
          }
        }
        if ((localObject4.booleanValue()) && (!((Boolean)localObject3).booleanValue()))
        {
          i = 7;
          localObject1 = Boolean.TRUE;
        }
        for (;;)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_pick_local_pic_capture", j);
          ((Intent)localObject2).putExtra("key_pick_local_pic_count", k);
          ((Intent)localObject2).putExtra("key_pick_local_pic_query_source_type", i);
          ((Intent)localObject2).putExtra("key_pick_local_pic_send_raw", (Serializable)localObject1);
          ((Intent)localObject2).putExtra("query_media_type", 1);
          ab.i("MicroMsg.JsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), localObject1 });
          ((MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext).mmSetOnActivityResultCallback(new g.1(this, parama));
          d.a(((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext, "webview", ".ui.tools.OpenFileChooserUI", (Intent)localObject2, hashCode() & 0xFFFF, false);
          AppMethodBeat.o(6287);
          return;
          if ((!localObject4.booleanValue()) && (((Boolean)localObject3).booleanValue()))
          {
            i = 7;
            localObject1 = Boolean.FALSE;
          }
          else
          {
            i = 8;
            localObject1 = Boolean.FALSE;
          }
        }
      }
      i = 0;
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "chooseImage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.g
 * JD-Core Version:    0.7.0.1
 */