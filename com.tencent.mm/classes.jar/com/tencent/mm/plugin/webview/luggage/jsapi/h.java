package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.tools.j;
import org.json.JSONObject;

public class h
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  private MMActivity.a geo = new h.4(this);
  private MMActivity gfb;
  private com.tencent.luggage.e.a<com.tencent.mm.plugin.webview.luggage.e>.a rdy;
  
  private void a(String paramString, Intent paramIntent)
  {
    y.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
    if (paramString.equals("front")) {}
    for (int i = 16;; i = 256)
    {
      paramIntent.putExtra("key_pick_local_pic_capture", i);
      this.gfb.gJb = this.geo;
      d.a(this.gfb, "webview", ".ui.tools.OpenFileChooserUI", paramIntent, 0xFFFF & hashCode(), false);
      return;
    }
  }
  
  private void ad(Intent paramIntent)
  {
    y.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
    paramIntent.putExtra("key_pick_local_pic_capture", 4096);
    this.gfb.gJb = this.geo;
    d.a(this.gfb, "webview", ".ui.tools.OpenFileChooserUI", paramIntent, 0xFFFF & hashCode(), false);
  }
  
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(com.tencent.luggage.e.a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    y.i("MicroMsg.JsApiChooseMedia", "invoke");
    this.gfb = ((MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.big).mContext);
    if (this.gfb == null)
    {
      parama.a("fail", null);
      return;
    }
    this.rdy = parama;
    Object localObject2 = parama.bih.bhk;
    boolean bool1 = com.tencent.mm.pluginsdk.permission.a.a(this.gfb, "android.permission.CAMERA", 119, "", "");
    y.i("MicroMsg.JsApiChooseMedia", " checkPermission checkcamera[%b]", new Object[] { Boolean.valueOf(bool1) });
    boolean bool2 = com.tencent.mm.pluginsdk.permission.a.a(this.gfb, "android.permission.RECORD_AUDIO", 120, "", "");
    y.i("MicroMsg.JsApiChooseMedia", " checkPermission checkMicroPhone[%b]", new Object[] { Boolean.valueOf(bool2) });
    if ((!bool2) || (!bool1))
    {
      parama.a("no_user_permission", null);
      return;
    }
    Object localObject1 = bk.pm(((JSONObject)localObject2).optString("sourceType"));
    String str2 = ((JSONObject)localObject2).optString("mediaType", "");
    int j = Math.min(((JSONObject)localObject2).optInt("maxDuration", 10), 10);
    String str1 = ((JSONObject)localObject2).optString("camera", "");
    int i = ((JSONObject)localObject2).optInt("count", 1);
    String str3 = ((JSONObject)localObject2).optString("sizeType", "");
    y.i("MicroMsg.JsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { localObject1, str2, Integer.valueOf(j), str1, Integer.valueOf(i), str3 });
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("key_pick_local_pic_count", i);
    i = j;
    if (j <= 0) {
      i = 10;
    }
    ((Intent)localObject2).putExtra("key_pick_local_media_duration", i);
    ((Intent)localObject2).putExtra("query_media_type", 3);
    ((Intent)localObject2).putExtra("key_pick_local_media_video_type", 2);
    ((Intent)localObject2).putExtra("key_pick_local_media_sight_type", str2);
    if ((str3.contains("original") ^ str3.contains("compressed")))
    {
      i = 7;
      ((Intent)localObject2).putExtra("key_pick_local_pic_query_source_type", i);
      if (!str3.contains("compressed")) {
        break label476;
      }
      bool1 = true;
      label365:
      ((Intent)localObject2).putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(bool1));
      if (!bk.bl((String)localObject1)) {
        break label527;
      }
      localObject1 = "album|camera";
    }
    label527:
    for (;;)
    {
      if ((((String)localObject1).contains("album")) && (((String)localObject1).contains("camera")))
      {
        localObject1 = new j(this.gfb);
        ((j)localObject1).b(null, new View.OnCreateContextMenuListener()new h.2
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            paramAnonymousContextMenu.add(0, 1, 0, h.a(h.this).getString(R.l.app_field_mmsight));
            paramAnonymousContextMenu.add(0, 2, 1, h.a(h.this).getString(R.l.app_field_select_new_pic));
          }
        }, new h.2(this, str1, (Intent)localObject2));
        ((j)localObject1).d(new h.3(this, parama));
        ((j)localObject1).bJQ();
        return;
        i = 8;
        break;
        label476:
        bool1 = false;
        break label365;
      }
      if (((String)localObject1).contains("album"))
      {
        ad((Intent)localObject2);
        return;
      }
      if (((String)localObject1).contains("camera"))
      {
        a(str1, (Intent)localObject2);
        return;
      }
      parama.a("ourceType_error", null);
      return;
    }
  }
  
  public final String name()
  {
    return "chooseMedia";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.h
 * JD-Core Version:    0.7.0.1
 */