package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78527);
    Log.i("MicroMsg.JsApiChooseImage", "invoke");
    Object localObject3 = paramb.crh.cqn;
    Object localObject1 = ((JSONObject)localObject3).optJSONArray("sourceType");
    int k;
    int i;
    int j;
    if (localObject1 != null)
    {
      Log.i("MicroMsg.JsApiChooseImage", "sourceType = " + ((JSONArray)localObject1).toString());
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
        Log.i("MicroMsg.JsApiChooseImage", "real scene = %d", new Object[] { Integer.valueOf(j) });
        if ((j == 2) || (j == 3))
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)((g)paramb.crg).mContext, "android.permission.CAMERA", 113, "", "");
          Log.d("MicroMsg.JsApiChooseImage", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            paramb.a("android_permission_denied", null);
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
          Log.i("MicroMsg.JsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), localObject1 });
          ((MMActivity)((g)paramb.crg).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
                Log.i("MicroMsg.JsApiChooseImage", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", new Object[] { Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
                localHashMap = new HashMap();
                if (bool) {
                  localHashMap.put("memoryWarning", Boolean.TRUE);
                }
                switch (paramAnonymousInt2)
                {
                default: 
                  paramb.d("fail", localHashMap);
                }
              }
              for (;;)
              {
                label111:
                ((MMActivity)((g)paramb.crg).mContext).mmSetOnActivityResultCallback(null);
                AppMethodBeat.o(78526);
                return;
                label137:
                bool = paramAnonymousIntent.getBooleanExtra("key_pick_local_media_show_memory_warning", false);
                break;
                if (paramAnonymousIntent != null) {}
                for (String str = paramAnonymousIntent.getStringExtra("key_pick_local_pic_callback_local_ids"); !Util.isNullOrNil(str); str = null)
                {
                  Log.i("MicroMsg.JsApiChooseImage", "localIds = %s", new Object[] { str });
                  localHashMap.put("localIds", str);
                  paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_pick_local_pic_source_type");
                  if (paramAnonymousIntent != null) {
                    localHashMap.put("sourceType", paramAnonymousIntent);
                  }
                  paramb.d("", localHashMap);
                  break label111;
                }
                paramb.d("cancel", localHashMap);
              }
            }
          });
          c.a(((g)paramb.crg).mContext, "webview", ".ui.tools.OpenFileChooserUI", (Intent)localObject2, hashCode() & 0xFFFF, false);
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
  
  public final int cDj()
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