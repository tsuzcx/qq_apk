package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.b<Lcom.tencent.mm.plugin.webview.luggage.g;>.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.HashMap;
import org.json.JSONObject;

public class j
  extends bw<g>
{
  private com.tencent.luggage.d.b<g>.a WIy;
  private MMActivity activity;
  private MMActivity.a rvb;
  
  public j()
  {
    AppMethodBeat.i(78532);
    this.rvb = new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
            Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
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
          Log.i("MicroMsg.JsApiChooseMedia", "video localId:%s", new Object[] { localObject1 });
          Log.i("MicroMsg.JsApiChooseMedia", "video thumbLocalId:%s", new Object[] { paramAnonymousIntent });
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
            j.a(j.this, "fail");
            AppMethodBeat.o(78531);
            return;
          }
          Object localObject2 = com.tencent.mm.plugin.webview.luggage.c.c.bkh((String)localObject1);
          if ((localObject2 != null) && ((localObject2 instanceof WebViewJSSDKVideoItem)))
          {
            localObject2 = (WebViewJSSDKVideoItem)localObject2;
            paramAnonymousIntent = az.c((String)localObject1, paramAnonymousIntent, ((WebViewJSSDKVideoItem)localObject2).duration, ((WebViewJSSDKVideoItem)localObject2).height, ((WebViewJSSDKVideoItem)localObject2).width, ((WebViewJSSDKVideoItem)localObject2).size);
            Log.i("MicroMsg.JsApiChooseMedia", "after parse to json data : %s", new Object[] { paramAnonymousIntent });
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("type", Integer.valueOf(1));
            ((HashMap)localObject1).put("localIds", paramAnonymousIntent);
            j.a(j.this, (HashMap)localObject1);
            AppMethodBeat.o(78531);
            return;
          }
          Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
        }
        if (paramAnonymousInt1 == 2)
        {
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_pick_local_media_local_ids");
          Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia localIds:%s", new Object[] { paramAnonymousIntent });
          if (Util.isNullOrNil(paramAnonymousIntent))
          {
            Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
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
        Log.e("MicroMsg.JsApiChooseMedia", "type:%d is error", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        j.a(j.this, "fail");
        AppMethodBeat.o(78531);
      }
    };
    AppMethodBeat.o(78532);
  }
  
  private void bL(Intent paramIntent)
  {
    AppMethodBeat.i(78535);
    Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
    paramIntent.putExtra("key_pick_local_pic_capture", 4096);
    this.activity.mmSetOnActivityResultCallback(this.rvb);
    com.tencent.mm.br.c.a(this.activity, "webview", ".ui.tools.OpenFileChooserUI", paramIntent, 0xFFFF & hashCode(), false);
    AppMethodBeat.o(78535);
  }
  
  private void e(String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(78536);
    if (this.WIy != null) {
      this.WIy.d(paramString, paramHashMap);
    }
    this.WIy = null;
    this.activity = null;
    AppMethodBeat.o(78536);
  }
  
  private void g(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(78534);
    Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.activity, "android.permission.CAMERA", 119, "");
    Log.i("MicroMsg.JsApiChooseMedia", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      e("no_user_permission", null);
      AppMethodBeat.o(78534);
      return;
    }
    if (paramString.equals("front")) {}
    for (int i = 16;; i = 256)
    {
      paramIntent.putExtra("key_pick_local_pic_capture", i);
      this.activity.mmSetOnActivityResultCallback(this.rvb);
      com.tencent.mm.br.c.a(this.activity, "webview", ".ui.tools.OpenFileChooserUI", paramIntent, 0xFFFF & hashCode(), false);
      AppMethodBeat.o(78534);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78533);
    Log.i("MicroMsg.JsApiChooseMedia", "invoke");
    this.activity = ((MMActivity)((g)paramb.eiY).mContext);
    this.WIy = paramb;
    if (this.activity == null)
    {
      e("fail", null);
      AppMethodBeat.o(78533);
      return;
    }
    Object localObject = paramb.eiZ.eif;
    String str1 = Util.nullAsNil(((JSONObject)localObject).optString("sourceType"));
    paramb = ((JSONObject)localObject).optString("mediaType", "");
    int j = Math.min(((JSONObject)localObject).optInt("maxDuration", 10), 10);
    final String str2 = ((JSONObject)localObject).optString("camera", "");
    int i = ((JSONObject)localObject).optInt("count", 1);
    String str3 = ((JSONObject)localObject).optString("sizeType", "");
    Log.i("MicroMsg.JsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { str1, paramb, Integer.valueOf(j), str2, Integer.valueOf(i), str3 });
    final Intent localIntent = new Intent();
    localIntent.putExtra("key_pick_local_pic_count", i);
    i = j;
    if (j <= 0) {
      i = 10;
    }
    localIntent.putExtra("key_pick_local_media_duration", i);
    localIntent.putExtra("query_media_type", 3);
    localIntent.putExtra("key_pick_local_media_video_type", 2);
    localIntent.putExtra("key_pick_local_media_sight_type", paramb);
    boolean bool;
    if ((str3.contains("original") ^ str3.contains("compressed")))
    {
      i = 7;
      localIntent.putExtra("key_pick_local_pic_query_source_type", i);
      if (!str3.contains("compressed")) {
        break label414;
      }
      bool = false;
      label282:
      localObject = Boolean.valueOf(bool);
      paramb = (com.tencent.luggage.d.b<g>.a)localObject;
      if (!str3.contains("original"))
      {
        paramb = (com.tencent.luggage.d.b<g>.a)localObject;
        if (!str3.contains("compressed")) {
          paramb = Boolean.FALSE;
        }
      }
      localIntent.putExtra("key_pick_local_pic_send_raw", paramb);
      if (!Util.isNullOrNil(str1)) {
        break label479;
      }
    }
    label414:
    label479:
    for (paramb = "album|camera";; paramb = str1)
    {
      if ((paramb.contains("album")) && (paramb.contains("camera")))
      {
        new l(this.activity).a(null, new View.OnCreateContextMenuListener()new u.i
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(78528);
            paramAnonymousContextMenu.add(0, 1, 0, j.a(j.this).getString(c.i.app_field_mmsight));
            paramAnonymousContextMenu.add(0, 2, 1, j.a(j.this).getString(c.i.app_field_select_new_pic));
            AppMethodBeat.o(78528);
          }
        }, new u.i()new f.b
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
        }, new f.b()
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
        bool = true;
        break label282;
      }
      if (paramb.contains("album"))
      {
        bL(localIntent);
        AppMethodBeat.o(78533);
        return;
      }
      if (paramb.contains("camera"))
      {
        g(str2, localIntent);
        AppMethodBeat.o(78533);
        return;
      }
      e("sourceType_error", null);
      AppMethodBeat.o(78533);
      return;
    }
  }
  
  public final int dgI()
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