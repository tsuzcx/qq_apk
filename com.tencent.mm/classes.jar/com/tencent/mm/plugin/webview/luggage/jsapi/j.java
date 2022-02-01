package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.a<Lcom.tencent.mm.plugin.webview.luggage.f;>.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import org.json.JSONObject;

public class j
  extends bo<f>
{
  private a<f>.a Cnw;
  private MMActivity activity;
  private MMActivity.a jVj;
  
  public j()
  {
    AppMethodBeat.i(78532);
    this.jVj = new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78531);
        if (paramAnonymousInt1 == (j.this.hashCode() & 0xFFFF)) {
          switch (paramAnonymousInt2)
          {
          }
        }
        Object localObject1;
        for (;;)
        {
          j.a(j.this, "fail");
          AppMethodBeat.o(78531);
          return;
          j.a(j.this, "cancel");
          AppMethodBeat.o(78531);
          return;
          if (paramAnonymousIntent == null)
          {
            ac.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
            j.a(j.this, "fail");
            AppMethodBeat.o(78531);
            return;
          }
          paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_pick_local_media_callback_type", 0);
          if (paramAnonymousInt1 != 1) {
            break;
          }
          localObject1 = paramAnonymousIntent.getStringExtra("key_pick_local_media_local_id");
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_pick_local_media_thumb_local_id");
          ac.i("MicroMsg.JsApiChooseMedia", "video localId:%s", new Object[] { localObject1 });
          ac.i("MicroMsg.JsApiChooseMedia", "video thumbLocalId:%s", new Object[] { paramAnonymousIntent });
          if (bs.isNullOrNil((String)localObject1))
          {
            ac.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
            j.a(j.this, "fail");
            AppMethodBeat.o(78531);
            return;
          }
          Object localObject2 = com.tencent.mm.plugin.webview.luggage.c.b.aBI((String)localObject1);
          if ((localObject2 != null) && ((localObject2 instanceof WebViewJSSDKVideoItem)))
          {
            localObject2 = (WebViewJSSDKVideoItem)localObject2;
            paramAnonymousIntent = aw.b((String)localObject1, paramAnonymousIntent, ((WebViewJSSDKVideoItem)localObject2).duration, ((WebViewJSSDKVideoItem)localObject2).height, ((WebViewJSSDKVideoItem)localObject2).width, ((WebViewJSSDKVideoItem)localObject2).size);
            ac.i("MicroMsg.JsApiChooseMedia", "after parse to json data : %s", new Object[] { paramAnonymousIntent });
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("type", Integer.valueOf(1));
            ((HashMap)localObject1).put("localIds", paramAnonymousIntent);
            j.a(j.this, (HashMap)localObject1);
            AppMethodBeat.o(78531);
            return;
          }
          ac.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
        }
        if (paramAnonymousInt1 == 2)
        {
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_pick_local_media_local_ids");
          ac.i("MicroMsg.JsApiChooseMedia", "chooseMedia localIds:%s", new Object[] { paramAnonymousIntent });
          if (bs.isNullOrNil(paramAnonymousIntent))
          {
            ac.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
            j.a(j.this, "fail");
            AppMethodBeat.o(78531);
            return;
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("type", Integer.valueOf(2));
          ((HashMap)localObject1).put("localIds", paramAnonymousIntent);
          j.a(j.this, (HashMap)localObject1);
          AppMethodBeat.o(78531);
          return;
        }
        ac.e("MicroMsg.JsApiChooseMedia", "type:%d is error", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        j.a(j.this, "fail");
        AppMethodBeat.o(78531);
      }
    };
    AppMethodBeat.o(78532);
  }
  
  private void aT(Intent paramIntent)
  {
    AppMethodBeat.i(78535);
    ac.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
    paramIntent.putExtra("key_pick_local_pic_capture", 4096);
    this.activity.mmSetOnActivityResultCallback(this.jVj);
    d.a(this.activity, "webview", ".ui.tools.OpenFileChooserUI", paramIntent, 0xFFFF & hashCode(), false);
    AppMethodBeat.o(78535);
  }
  
  private void d(String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(78536);
    if (this.Cnw != null) {
      this.Cnw.c(paramString, paramHashMap);
    }
    this.Cnw = null;
    this.activity = null;
    AppMethodBeat.o(78536);
  }
  
  private void e(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(78534);
    ac.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
    if (paramString.equals("front")) {}
    for (int i = 16;; i = 256)
    {
      paramIntent.putExtra("key_pick_local_pic_capture", i);
      this.activity.mmSetOnActivityResultCallback(this.jVj);
      d.a(this.activity, "webview", ".ui.tools.OpenFileChooserUI", paramIntent, 0xFFFF & hashCode(), false);
      AppMethodBeat.o(78534);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78533);
    ac.i("MicroMsg.JsApiChooseMedia", "invoke");
    this.activity = ((MMActivity)((f)parama.bWR).mContext);
    this.Cnw = parama;
    if (this.activity == null)
    {
      d("fail", null);
      AppMethodBeat.o(78533);
      return;
    }
    Object localObject = parama.bWS.bVY;
    boolean bool1 = com.tencent.mm.pluginsdk.permission.b.a(this.activity, "android.permission.CAMERA", 119, "", "");
    ac.i("MicroMsg.JsApiChooseMedia", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool1) });
    boolean bool2 = com.tencent.mm.pluginsdk.permission.b.a(this.activity, "android.permission.RECORD_AUDIO", 120, "", "");
    ac.i("MicroMsg.JsApiChooseMedia", " checkPermission checkMicroPhone[%b]", new Object[] { Boolean.valueOf(bool2) });
    if ((!bool2) || (!bool1))
    {
      d("no_user_permission", null);
      AppMethodBeat.o(78533);
      return;
    }
    String str1 = bs.nullAsNil(((JSONObject)localObject).optString("sourceType"));
    parama = ((JSONObject)localObject).optString("mediaType", "");
    int j = Math.min(((JSONObject)localObject).optInt("maxDuration", 10), 10);
    final String str2 = ((JSONObject)localObject).optString("camera", "");
    int i = ((JSONObject)localObject).optInt("count", 1);
    String str3 = ((JSONObject)localObject).optString("sizeType", "");
    ac.i("MicroMsg.JsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { str1, parama, Integer.valueOf(j), str2, Integer.valueOf(i), str3 });
    final Intent localIntent = new Intent();
    localIntent.putExtra("key_pick_local_pic_count", i);
    i = j;
    if (j <= 0) {
      i = 10;
    }
    localIntent.putExtra("key_pick_local_media_duration", i);
    localIntent.putExtra("query_media_type", 3);
    localIntent.putExtra("key_pick_local_media_video_type", 2);
    localIntent.putExtra("key_pick_local_media_sight_type", parama);
    if ((str3.contains("original") ^ str3.contains("compressed")))
    {
      i = 7;
      localIntent.putExtra("key_pick_local_pic_query_source_type", i);
      if (!str3.contains("compressed")) {
        break label509;
      }
      bool1 = false;
      label377:
      localObject = Boolean.valueOf(bool1);
      parama = (a<f>.a)localObject;
      if (!str3.contains("original"))
      {
        parama = (a<f>.a)localObject;
        if (!str3.contains("compressed")) {
          parama = Boolean.FALSE;
        }
      }
      localIntent.putExtra("key_pick_local_pic_send_raw", parama);
      if (!bs.isNullOrNil(str1)) {
        break label574;
      }
    }
    label574:
    for (parama = "album|camera";; parama = str1)
    {
      if ((parama.contains("album")) && (parama.contains("camera")))
      {
        new l(this.activity).a(null, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(78528);
            paramAnonymousContextMenu.add(0, 1, 0, j.a(j.this).getString(2131755747));
            paramAnonymousContextMenu.add(0, 2, 1, j.a(j.this).getString(2131755754));
            AppMethodBeat.o(78528);
          }
        }, new n.d()new e.b
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(78529);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(78529);
              return;
              j.a(j.this, str2, localIntent);
              AppMethodBeat.o(78529);
              return;
              j.a(j.this, localIntent);
            }
          }
        }, new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(78530);
            j.a(j.this, "cancel");
            AppMethodBeat.o(78530);
          }
        });
        AppMethodBeat.o(78533);
        return;
        i = 8;
        break;
        label509:
        bool1 = true;
        break label377;
      }
      if (parama.contains("album"))
      {
        aT(localIntent);
        AppMethodBeat.o(78533);
        return;
      }
      if (parama.contains("camera"))
      {
        e(str2, localIntent);
        AppMethodBeat.o(78533);
        return;
      }
      d("sourceType_error", null);
      AppMethodBeat.o(78533);
      return;
    }
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "chooseMedia";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.j
 * JD-Core Version:    0.7.0.1
 */