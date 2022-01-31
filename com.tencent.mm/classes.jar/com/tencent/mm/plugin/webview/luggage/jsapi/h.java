package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.tools.l;
import java.util.HashMap;
import org.json.JSONObject;

public class h
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  private MMActivity hwZ;
  private MMActivity.a hwo;
  private a<com.tencent.mm.plugin.webview.luggage.e>.a uTt;
  
  public h()
  {
    AppMethodBeat.i(6292);
    this.hwo = new h.4(this);
    AppMethodBeat.o(6292);
  }
  
  private void az(Intent paramIntent)
  {
    AppMethodBeat.i(6295);
    ab.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
    paramIntent.putExtra("key_pick_local_pic_capture", 4096);
    this.hwZ.mmSetOnActivityResultCallback(this.hwo);
    d.a(this.hwZ, "webview", ".ui.tools.OpenFileChooserUI", paramIntent, 0xFFFF & hashCode(), false);
    AppMethodBeat.o(6295);
  }
  
  private void b(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(6294);
    ab.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
    if (paramString.equals("front")) {}
    for (int i = 16;; i = 256)
    {
      paramIntent.putExtra("key_pick_local_pic_capture", i);
      this.hwZ.mmSetOnActivityResultCallback(this.hwo);
      d.a(this.hwZ, "webview", ".ui.tools.OpenFileChooserUI", paramIntent, 0xFFFF & hashCode(), false);
      AppMethodBeat.o(6294);
      return;
    }
  }
  
  private void b(String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(6296);
    if (this.uTt != null) {
      this.uTt.c(paramString, paramHashMap);
    }
    this.uTt = null;
    this.hwZ = null;
    AppMethodBeat.o(6296);
  }
  
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6293);
    ab.i("MicroMsg.JsApiChooseMedia", "invoke");
    this.hwZ = ((MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext);
    this.uTt = parama;
    if (this.hwZ == null)
    {
      b("fail", null);
      AppMethodBeat.o(6293);
      return;
    }
    Object localObject = parama.byF.bxK;
    boolean bool1 = b.a(this.hwZ, "android.permission.CAMERA", 119, "", "");
    ab.i("MicroMsg.JsApiChooseMedia", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool1) });
    boolean bool2 = b.a(this.hwZ, "android.permission.RECORD_AUDIO", 120, "", "");
    ab.i("MicroMsg.JsApiChooseMedia", " checkPermission checkMicroPhone[%b]", new Object[] { Boolean.valueOf(bool2) });
    if ((!bool2) || (!bool1))
    {
      b("no_user_permission", null);
      AppMethodBeat.o(6293);
      return;
    }
    parama = bo.nullAsNil(((JSONObject)localObject).optString("sourceType"));
    String str2 = ((JSONObject)localObject).optString("mediaType", "");
    int j = Math.min(((JSONObject)localObject).optInt("maxDuration", 10), 10);
    String str1 = ((JSONObject)localObject).optString("camera", "");
    int i = ((JSONObject)localObject).optInt("count", 1);
    String str3 = ((JSONObject)localObject).optString("sizeType", "");
    ab.i("MicroMsg.JsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { parama, str2, Integer.valueOf(j), str1, Integer.valueOf(i), str3 });
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_pick_local_pic_count", i);
    i = j;
    if (j <= 0) {
      i = 10;
    }
    ((Intent)localObject).putExtra("key_pick_local_media_duration", i);
    ((Intent)localObject).putExtra("query_media_type", 3);
    ((Intent)localObject).putExtra("key_pick_local_media_video_type", 2);
    ((Intent)localObject).putExtra("key_pick_local_media_sight_type", str2);
    if ((str3.contains("original") ^ str3.contains("compressed")))
    {
      i = 7;
      ((Intent)localObject).putExtra("key_pick_local_pic_query_source_type", i);
      if (!str3.contains("compressed")) {
        break label489;
      }
      bool1 = true;
      label381:
      ((Intent)localObject).putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(bool1));
      if (!bo.isNullOrNil(parama)) {
        break label556;
      }
      parama = "album|camera";
    }
    label556:
    for (;;)
    {
      if ((parama.contains("album")) && (parama.contains("camera")))
      {
        parama = new l(this.hwZ);
        parama.b(null, new View.OnCreateContextMenuListener()new h.2
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(6288);
            paramAnonymousContextMenu.add(0, 1, 0, h.a(h.this).getString(2131296938));
            paramAnonymousContextMenu.add(0, 2, 1, h.a(h.this).getString(2131296945));
            AppMethodBeat.o(6288);
          }
        }, new h.2(this, str1, (Intent)localObject));
        parama.setOnCancelListener(new h.3(this));
        parama.cwt();
        AppMethodBeat.o(6293);
        return;
        i = 8;
        break;
        label489:
        bool1 = false;
        break label381;
      }
      if (parama.contains("album"))
      {
        az((Intent)localObject);
        AppMethodBeat.o(6293);
        return;
      }
      if (parama.contains("camera"))
      {
        b(str1, (Intent)localObject);
        AppMethodBeat.o(6293);
        return;
      }
      b("sourceType_error", null);
      AppMethodBeat.o(6293);
      return;
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "chooseMedia";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.h
 * JD-Core Version:    0.7.0.1
 */