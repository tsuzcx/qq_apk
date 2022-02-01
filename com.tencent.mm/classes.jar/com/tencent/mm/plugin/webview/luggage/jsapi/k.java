package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class k
  extends bo<f>
{
  public static void a(a<f>.a parama, int paramInt)
  {
    AppMethodBeat.i(78543);
    final MMActivity localMMActivity = (MMActivity)((f)parama.bWR).mContext;
    if (localMMActivity == null)
    {
      ac.e("MicroMsg.JsApiChooseVideo", "activity is null");
      AppMethodBeat.o(78543);
      return;
    }
    Object localObject = parama.bWS.bVY;
    String str1 = ((JSONObject)localObject).optString("sourceType", "");
    String str2 = ((JSONObject)localObject).optString("camera", "");
    ac.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", new Object[] { str1, str2, Integer.valueOf(paramInt) });
    int k = ((JSONObject)localObject).optInt("maxDuration", 60);
    if (str1.contains("album")) {}
    for (int j = 4096;; j = 0)
    {
      int i = j;
      if (str1.contains("camera"))
      {
        if (k <= 0)
        {
          parama.a("fail", null);
          AppMethodBeat.o(78543);
          return;
        }
        if (str2.equals("front")) {
          i = j | 0x10;
        }
      }
      else
      {
        if (i != 0) {
          break label588;
        }
        i = 4352;
      }
      label588:
      for (;;)
      {
        if ((i == 16) || (i == 256) || (i == 4352))
        {
          if (paramInt == 1)
          {
            bool = com.tencent.mm.pluginsdk.permission.b.a(localMMActivity, "android.permission.CAMERA", 117, "", "");
            ac.d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool) });
            if (!bool)
            {
              AppMethodBeat.o(78543);
              return;
              i = j | 0x100;
              break;
            }
            bool = com.tencent.mm.pluginsdk.permission.b.a(localMMActivity, "android.permission.RECORD_AUDIO", 118, "", "");
            ac.d("MicroMsg.JsApiChooseVideo", " checkPermission checkMicroPhone[%b]", new Object[] { Boolean.valueOf(bool) });
            if (bool) {
              break label344;
            }
            AppMethodBeat.o(78543);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(localMMActivity, "android.permission.CAMERA", 115, "", "");
          ac.d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            AppMethodBeat.o(78543);
            return;
          }
        }
        label344:
        j = ((JSONObject)localObject).optInt("quality", 1);
        if ((j != 0) && (j != 1)) {
          j = 1;
        }
        for (;;)
        {
          if (k > 60) {
            k = 60;
          }
          for (;;)
          {
            ac.i("MicroMsg.JsApiChooseVideo", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(j), Integer.valueOf(k) });
            localObject = new Intent();
            ((Intent)localObject).putExtra("key_pick_local_pic_capture", i);
            ((Intent)localObject).putExtra("key_pick_local_pic_count", 1);
            ((Intent)localObject).putExtra("key_pick_local_pic_query_source_type", 7);
            ((Intent)localObject).putExtra("key_pick_local_media_quality", j);
            ((Intent)localObject).putExtra("key_pick_local_media_duration", k);
            ((Intent)localObject).putExtra("query_media_type", 2);
            ((Intent)localObject).putExtra("key_pick_local_media_video_type", paramInt);
            ac.i("MicroMsg.JsApiChooseVideo", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(7) });
            localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
            {
              public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
              {
                AppMethodBeat.i(78541);
                Object localObject1;
                Object localObject2;
                if (paramAnonymousInt1 == 45)
                {
                  switch (paramAnonymousInt2)
                  {
                  default: 
                    this.sXa.a("fail", null);
                  }
                  for (;;)
                  {
                    localMMActivity.mmSetOnActivityResultCallback(null);
                    AppMethodBeat.o(78541);
                    return;
                    this.sXa.a("cancel", null);
                    continue;
                    localObject1 = paramAnonymousIntent.getStringExtra("key_pick_local_media_local_id");
                    paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_pick_local_media_thumb_local_id");
                    ac.i("MicroMsg.JsApiChooseVideo", "localId:%s", new Object[] { localObject1 });
                    ac.i("MicroMsg.JsApiChooseVideo", "thumbLocalId:%s", new Object[] { paramAnonymousIntent });
                    if (bs.isNullOrNil((String)localObject1)) {
                      break;
                    }
                    localObject2 = com.tencent.mm.plugin.webview.luggage.c.b.aBI((String)localObject1);
                    if ((localObject2 != null) && ((localObject2 instanceof WebViewJSSDKVideoItem)))
                    {
                      localObject2 = (WebViewJSSDKVideoItem)localObject2;
                      HashMap localHashMap = new HashMap();
                      localHashMap.put("localId", localObject1);
                      localHashMap.put("duration", Integer.valueOf(((WebViewJSSDKVideoItem)localObject2).duration));
                      localHashMap.put("height", Integer.valueOf(((WebViewJSSDKVideoItem)localObject2).height));
                      localHashMap.put("size", Integer.valueOf(((WebViewJSSDKVideoItem)localObject2).size));
                      localHashMap.put("width", Integer.valueOf(((WebViewJSSDKVideoItem)localObject2).width));
                      localHashMap.put("thumbLocalId", paramAnonymousIntent);
                      this.sXa.c("", localHashMap);
                    }
                    else
                    {
                      this.sXa.a("fail", null);
                    }
                  }
                }
                if (paramAnonymousInt1 == 32) {
                  switch (paramAnonymousInt2)
                  {
                  default: 
                    this.sXa.a("fail", null);
                  }
                }
                for (;;)
                {
                  localMMActivity.mmSetOnActivityResultCallback(null);
                  AppMethodBeat.o(78541);
                  return;
                  this.sXa.a("cancel", null);
                  continue;
                  paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_pick_local_media_local_id");
                  if (bs.isNullOrNil(paramAnonymousIntent)) {
                    break;
                  }
                  localObject1 = com.tencent.mm.plugin.webview.luggage.c.b.aBI(paramAnonymousIntent);
                  if ((localObject1 != null) && ((localObject1 instanceof WebViewJSSDKVideoItem)))
                  {
                    localObject1 = (WebViewJSSDKVideoItem)localObject1;
                    localObject2 = new HashMap();
                    ((HashMap)localObject2).put("localId", paramAnonymousIntent);
                    ((HashMap)localObject2).put("duration", Integer.valueOf(((WebViewJSSDKVideoItem)localObject1).duration));
                    ((HashMap)localObject2).put("height", Integer.valueOf(((WebViewJSSDKVideoItem)localObject1).height));
                    ((HashMap)localObject2).put("size", Integer.valueOf(((WebViewJSSDKVideoItem)localObject1).size));
                    ((HashMap)localObject2).put("width", Integer.valueOf(((WebViewJSSDKVideoItem)localObject1).width));
                    this.sXa.c("", (Map)localObject2);
                  }
                  else
                  {
                    this.sXa.a("fail", null);
                  }
                }
              }
            });
            if (paramInt == 1)
            {
              d.a(localMMActivity, "webview", ".ui.tools.OpenFileChooserUI", (Intent)localObject, 45, false);
              AppMethodBeat.o(78543);
              return;
            }
            d.a(localMMActivity, "webview", ".ui.tools.OpenFileChooserUI", (Intent)localObject, 32, false);
            AppMethodBeat.o(78543);
            return;
          }
        }
      }
    }
  }
  
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78542);
    ac.i("MicroMsg.JsApiChooseVideo", "invokeInOwn");
    a(parama, 0);
    AppMethodBeat.o(78542);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "chooseVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.k
 * JD-Core Version:    0.7.0.1
 */