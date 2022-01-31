package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.xweb.b;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class a$4
  extends com.tencent.mm.plugin.webview.ui.tools.widget.m
{
  a$4(a parama) {}
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(8654);
    ab.i("MicroMsg.GameFloatWebView", "closeWindow");
    try
    {
      this.vmw.MO.removeView(this.vmw.foJ);
      this.vmw.onDestroy();
      AppMethodBeat.o(8654);
      return;
    }
    catch (Exception paramBundle)
    {
      AppMethodBeat.o(8654);
    }
  }
  
  public final Bundle i(final int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(8655);
    ab.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = ".concat(String.valueOf(paramInt)));
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(8655);
      return localBundle;
      paramBundle.setClassLoader(GameWebViewUI.class.getClassLoader());
      com.tencent.mm.bq.d.b(this.vmw.mContext, paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", h.cGT));
      continue;
      localBundle.putString("KPublisherId", h.cGT);
      localBundle.putInt("getA8KeyScene", this.vmw.dT(h.vny, h.cNH));
      continue;
      paramInt = h.cNH;
      localBundle.putInt("geta8key_scene", paramInt);
      ab.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
      continue;
      if (this.vmw.viZ.isSDCardAvailable())
      {
        long l = bd.dtH();
        ab.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[] { Long.valueOf(l) });
        if (l < 524288000L)
        {
          ab.e("MicroMsg.GameFloatWebView", "available size not enough");
          label419:
          paramInt = FactoryProxyManager.getPlayManager().init(this.vmw.mContext, null);
        }
      }
      boolean bool;
      for (;;)
      {
        localBundle.putInt("webview_video_proxy_init", paramInt);
        break;
        paramBundle = new File(com.tencent.mm.plugin.webview.a.uNC);
        bool = true;
        if (!paramBundle.exists())
        {
          bool = paramBundle.mkdirs();
          ab.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { paramBundle.getAbsolutePath(), Boolean.valueOf(bool) });
        }
        if (!bool) {
          break label419;
        }
        paramInt = FactoryProxyManager.getPlayManager().init(this.vmw.mContext, com.tencent.mm.plugin.webview.a.uNC);
        FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
        continue;
        ab.i("MicroMsg.GameFloatWebView", "sdcard not available");
        paramInt = FactoryProxyManager.getPlayManager().init(this.vmw.mContext, null);
      }
      Object localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
      Object localObject2 = paramBundle.getString("webview_video_proxy_fileId");
      paramInt = paramBundle.getInt("webview_video_proxy_file_size");
      int i = paramBundle.getInt("webview_video_proxy_file_duration");
      int j = paramBundle.getInt("webview_video_proxy_file_type");
      int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramInt, i);
      paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
      ab.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
      localBundle.putInt("webview_video_proxy_play_data_id", k);
      localBundle.putString("webview_video_proxy_local_url", paramBundle);
      continue;
      paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
      ab.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt > 0)
      {
        FactoryProxyManager.getPlayManager().stopPlay(paramInt);
        continue;
        paramInt = paramBundle.getInt("webview_video_proxy_play_state");
        FactoryProxyManager.getPlayManager().setPlayerState(paramInt);
        continue;
        paramInt = paramBundle.getInt("webview_video_proxy_net_state");
        FactoryProxyManager.getPlayManager().setNetWorkState(paramInt);
        continue;
        paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
        i = paramBundle.getInt("webview_video_proxy_play_remain_time");
        FactoryProxyManager.getPlayManager().setRemainTime(paramInt, i);
        continue;
        paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
        i = paramBundle.getInt("webview_video_proxy_preload_duration");
        ab.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
        continue;
        localObject1 = paramBundle.getString("show_kb_placeholder");
        paramInt = paramBundle.getInt("show_kb_max_length");
        this.vmw.vmn.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8650);
            a.4.this.vmw.vmn.dS(this.vdR, paramInt);
            AppMethodBeat.o(8650);
          }
        });
        continue;
        this.vmw.vmn.runOnUiThread(new a.4.2(this, localBundle));
        continue;
        localObject1 = paramBundle.getString("set_page_title_text");
        paramInt = g.by(paramBundle.getString("set_page_title_color"), this.vmw.vmn.getResources().getColor(2131689642));
        this.vmw.vmn.runOnUiThread(new a.4.3(this, (String)localObject1, paramInt));
        continue;
        bool = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
        ab.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
        paramBundle = new Intent();
        paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
        com.tencent.mm.cn.d.aX(paramBundle);
        continue;
        this.vmw.vmn.runOnUiThread(new a.4.4(this, paramBundle));
        continue;
        paramBundle = getCurrentUrl();
        localObject1 = b.dYg().getCookie(paramBundle);
        ab.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramBundle, localObject1 });
        localBundle.putString("cookie", (String)localObject1);
        localBundle.putFloat("density", com.tencent.mm.cb.a.getDensity(this.vmw.vmn));
        continue;
        localObject1 = paramBundle.getString("traceid");
        paramBundle = paramBundle.getString("username");
        com.tencent.mm.plugin.webview.ui.tools.m.vdm.hx((String)localObject1, paramBundle);
        continue;
        paramBundle = this.vmw.vmn.getMMTitle();
        localObject1 = getCurrentUrl();
        localBundle.putString("webview_current_url", (String)localObject1);
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.toString();; paramBundle = "")
        {
          localBundle.putString("webview_current_title", paramBundle);
          localBundle.putString("webview_current_desc", (String)localObject1);
          break;
        }
        bool = paramBundle.getBoolean("add_shortcut_status");
        if (this.vmw.vmp != null)
        {
          this.vmw.vmp.oD(bool);
          continue;
          bool = this.vmw.vmr.dfY();
          paramBundle = this.vmw.vmr.dfZ();
          localObject1 = this.vmw.vmr.dga();
          if (bool)
          {
            localBundle.putString("result", "not_return");
          }
          else
          {
            localBundle.putString("full_url", bo.nullAsNil(paramBundle));
            if ((localObject1 != null) && (((Map)localObject1).size() != 0))
            {
              localBundle.putInt("set_cookie", 1);
              com.tencent.xweb.c.jQ(ah.getContext());
              localObject2 = b.dYg();
              Iterator localIterator = ((Map)localObject1).keySet().iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                ((b)localObject2).setCookie(bo.nullAsNil(paramBundle), str + "=" + (String)((Map)localObject1).get(str));
              }
              com.tencent.xweb.c.dYi();
              com.tencent.xweb.c.sync();
              ab.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ((b)localObject2).getCookie(bo.nullAsNil(paramBundle)) });
            }
            else
            {
              localBundle.putInt("set_cookie", 0);
              continue;
              this.vmw.nkG.vmB.ax(paramBundle);
              ab.i("MicroMsg.GameFloatWebView", "set game float page time data");
              continue;
              this.vmw.nkv.ezW = 1;
              this.vmw.nkK.vnc = System.currentTimeMillis();
              continue;
              this.vmw.nkK.vnd = System.currentTimeMillis();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.4
 * JD-Core Version:    0.7.0.1
 */