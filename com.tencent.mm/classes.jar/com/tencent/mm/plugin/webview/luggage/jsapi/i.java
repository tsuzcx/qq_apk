package com.tencent.mm.plugin.webview.luggage.jsapi;

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
import org.json.JSONObject;

public class i
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public static void a(a<com.tencent.mm.plugin.webview.luggage.e>.a parama, int paramInt)
  {
    AppMethodBeat.i(6303);
    MMActivity localMMActivity = (MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext;
    if (localMMActivity == null)
    {
      ab.e("MicroMsg.JsApiChooseVideo", "activity is null");
      AppMethodBeat.o(6303);
      return;
    }
    Object localObject = parama.byF.bxK;
    String str1 = ((JSONObject)localObject).optString("sourceType", "");
    String str2 = ((JSONObject)localObject).optString("camera", "");
    ab.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", new Object[] { str1, str2, Integer.valueOf(paramInt) });
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
          AppMethodBeat.o(6303);
          return;
        }
        if (str2.equals("front")) {
          i = j | 0x10;
        }
      }
      else
      {
        if (i != 0) {
          break label596;
        }
        i = 4352;
      }
      label596:
      for (;;)
      {
        if ((i == 16) || (i == 256) || (i == 4352))
        {
          if (paramInt == 1)
          {
            bool = b.a(localMMActivity, "android.permission.CAMERA", 117, "", "");
            ab.d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool) });
            if (!bool)
            {
              AppMethodBeat.o(6303);
              return;
              i = j | 0x100;
              break;
            }
            bool = b.a(localMMActivity, "android.permission.RECORD_AUDIO", 118, "", "");
            ab.d("MicroMsg.JsApiChooseVideo", " checkPermission checkMicroPhone[%b]", new Object[] { Boolean.valueOf(bool) });
            if (bool) {
              break label350;
            }
            AppMethodBeat.o(6303);
            return;
          }
          boolean bool = b.a(localMMActivity, "android.permission.CAMERA", 115, "", "");
          ab.d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            AppMethodBeat.o(6303);
            return;
          }
        }
        label350:
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
            ab.i("MicroMsg.JsApiChooseVideo", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(j), Integer.valueOf(k) });
            localObject = new Intent();
            ((Intent)localObject).putExtra("key_pick_local_pic_capture", i);
            ((Intent)localObject).putExtra("key_pick_local_pic_count", 1);
            ((Intent)localObject).putExtra("key_pick_local_pic_query_source_type", 7);
            ((Intent)localObject).putExtra("key_pick_local_media_quality", j);
            ((Intent)localObject).putExtra("key_pick_local_media_duration", k);
            ((Intent)localObject).putExtra("query_media_type", 2);
            ((Intent)localObject).putExtra("key_pick_local_media_video_type", paramInt);
            ab.i("MicroMsg.JsApiChooseVideo", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(7) });
            localMMActivity.mmSetOnActivityResultCallback(new i.1(parama, localMMActivity));
            if (paramInt == 1)
            {
              d.a(localMMActivity, "webview", ".ui.tools.OpenFileChooserUI", (Intent)localObject, 45, false);
              AppMethodBeat.o(6303);
              return;
            }
            d.a(localMMActivity, "webview", ".ui.tools.OpenFileChooserUI", (Intent)localObject, 32, false);
            AppMethodBeat.o(6303);
            return;
          }
        }
      }
    }
  }
  
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6302);
    ab.i("MicroMsg.JsApiChooseVideo", "invokeInOwn");
    a(parama, 0);
    AppMethodBeat.o(6302);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "chooseVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.i
 * JD-Core Version:    0.7.0.1
 */