package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(78527);
    ac.i("MicroMsg.JsApiChooseImage", "invoke");
    Object localObject3 = parama.bWS.bVY;
    Object localObject1 = ((JSONObject)localObject3).optJSONArray("sourceType");
    int k;
    int i;
    int j;
    if (localObject1 != null)
    {
      ac.i("MicroMsg.JsApiChooseImage", "sourceType = " + ((JSONArray)localObject1).toString());
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
        ac.i("MicroMsg.JsApiChooseImage", "real scene = %d", new Object[] { Integer.valueOf(j) });
        if ((j == 2) || (j == 3))
        {
          boolean bool = b.a((Activity)((f)parama.bWR).mContext, "android.permission.CAMERA", 113, "", "");
          ac.d("MicroMsg.JsApiChooseImage", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            parama.a("android_permission_denied", null);
            AppMethodBeat.o(78527);
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
          ac.i("MicroMsg.JsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), localObject1 });
          ((MMActivity)((f)parama.bWR).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
            {
              AppMethodBeat.i(78526);
              boolean bool;
              HashMap localHashMap;
              if (paramAnonymousInt1 == (i.this.hashCode() & 0xFFFF))
              {
                if (paramAnonymousIntent != null) {
                  break label137;
                }
                bool = false;
                ac.i("MicroMsg.JsApiChooseImage", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", new Object[] { Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
                localHashMap = new HashMap();
                if (bool) {
                  localHashMap.put("memoryWarning", Boolean.TRUE);
                }
                switch (paramAnonymousInt2)
                {
                default: 
                  parama.c("fail", localHashMap);
                }
              }
              for (;;)
              {
                label111:
                ((MMActivity)((f)parama.bWR).mContext).mmSetOnActivityResultCallback(null);
                AppMethodBeat.o(78526);
                return;
                label137:
                bool = paramAnonymousIntent.getBooleanExtra("key_pick_local_media_show_memory_warning", false);
                break;
                if (paramAnonymousIntent != null) {}
                for (String str = paramAnonymousIntent.getStringExtra("key_pick_local_pic_callback_local_ids"); !bs.isNullOrNil(str); str = null)
                {
                  ac.i("MicroMsg.JsApiChooseImage", "localIds = %s", new Object[] { str });
                  localHashMap.put("localIds", str);
                  paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_pick_local_pic_source_type");
                  if (paramAnonymousIntent != null) {
                    localHashMap.put("sourceType", paramAnonymousIntent);
                  }
                  parama.c("", localHashMap);
                  break label111;
                }
                parama.c("cancel", localHashMap);
              }
            }
          });
          d.a(((f)parama.bWR).mContext, "webview", ".ui.tools.OpenFileChooserUI", (Intent)localObject2, hashCode() & 0xFFFF, false);
          AppMethodBeat.o(78527);
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
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "chooseImage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.i
 * JD-Core Version:    0.7.0.1
 */