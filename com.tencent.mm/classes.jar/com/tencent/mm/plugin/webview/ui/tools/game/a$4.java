package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mm.R.e;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class a$4
  extends m
{
  a$4(a parama) {}
  
  public final void N(Bundle paramBundle)
  {
    y.i("MicroMsg.GameFloatWebView", "closeWindow");
    try
    {
      this.rwe.MY.removeView(this.rwe.dYF);
      this.rwe.onDestroy();
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  public final Bundle f(final int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = " + paramInt);
    Bundle localBundle = new Bundle();
    boolean bool;
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
    case 101: 
    case 18: 
    case 99: 
    case 5001: 
    case 5002: 
    case 5003: 
    case 5004: 
    case 5005: 
    case 5006: 
    case 5007: 
    case 37: 
    case 79: 
    case 43: 
    case 6001: 
    case 53: 
    case 90001: 
    case 90002: 
    case 84: 
    case 54: 
      do
      {
        do
        {
          return localBundle;
          paramBundle.setClassLoader(GameWebViewUI.class.getClassLoader());
          com.tencent.mm.br.d.b(this.rwe.mContext, paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", d.bYM));
          return localBundle;
          localBundle.putString("KPublisherId", d.bYM);
          localBundle.putInt("getA8KeyScene", this.rwe.cT(d.rwF, d.cfb));
          return localBundle;
          paramInt = d.cfb;
          localBundle.putInt("geta8key_scene", paramInt);
          y.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramInt) });
          return localBundle;
          if (this.rwe.rsT.isSDCardAvailable())
          {
            long l = az.crH();
            y.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[] { Long.valueOf(l) });
            if (l < 524288000L)
            {
              y.e("MicroMsg.GameFloatWebView", "available size not enough");
              paramInt = FactoryProxyManager.getPlayManager().init(this.rwe.mContext, null);
            }
          }
          for (;;)
          {
            localBundle.putInt("webview_video_proxy_init", paramInt);
            return localBundle;
            paramBundle = new File(com.tencent.mm.plugin.webview.a.qYp);
            bool = true;
            if (!paramBundle.exists())
            {
              bool = paramBundle.mkdirs();
              y.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { paramBundle.getAbsolutePath(), Boolean.valueOf(bool) });
            }
            if (!bool) {
              break;
            }
            paramInt = FactoryProxyManager.getPlayManager().init(this.rwe.mContext, com.tencent.mm.plugin.webview.a.qYp);
            FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
            continue;
            y.i("MicroMsg.GameFloatWebView", "sdcard not available");
            paramInt = FactoryProxyManager.getPlayManager().init(this.rwe.mContext, null);
          }
          localObject1 = paramBundle.getString("webview_video_proxy_cdn_urls");
          localObject2 = paramBundle.getString("webview_video_proxy_fileId");
          paramInt = paramBundle.getInt("webview_video_proxy_file_size");
          i = paramBundle.getInt("webview_video_proxy_file_duration");
          int j = paramBundle.getInt("webview_video_proxy_file_type");
          int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramInt, i);
          paramBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
          y.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramBundle });
          localBundle.putInt("webview_video_proxy_play_data_id", k);
          localBundle.putString("webview_video_proxy_local_url", paramBundle);
          return localBundle;
          paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
          y.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramInt) });
        } while (paramInt <= 0);
        FactoryProxyManager.getPlayManager().stopPlay(paramInt);
        return localBundle;
        paramInt = paramBundle.getInt("webview_video_proxy_play_state");
        FactoryProxyManager.getPlayManager().setPlayerState(paramInt);
        return localBundle;
        paramInt = paramBundle.getInt("webview_video_proxy_net_state");
        FactoryProxyManager.getPlayManager().setNetWorkState(paramInt);
        return localBundle;
        paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
        int i = paramBundle.getInt("webview_video_proxy_play_remain_time");
        FactoryProxyManager.getPlayManager().setRemainTime(paramInt, i);
        return localBundle;
        paramInt = paramBundle.getInt("webview_video_proxy_play_data_id");
        i = paramBundle.getInt("webview_video_proxy_preload_duration");
        y.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramInt, i));
        return localBundle;
        localObject1 = paramBundle.getString("show_kb_placeholder");
        paramInt = paramBundle.getInt("show_kb_max_length");
        this.rwe.rvX.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            a.4.this.rwe.rvX.cS(this.rqg, paramInt);
          }
        });
        return localBundle;
        this.rwe.rvX.runOnUiThread(new a.4.2(this, localBundle));
        return localBundle;
        localObject1 = paramBundle.getString("set_page_title_text");
        paramInt = e.bb(paramBundle.getString("set_page_title_color"), this.rwe.rvX.getResources().getColor(R.e.action_bar_tittle_color));
        this.rwe.rvX.runOnUiThread(new a.4.3(this, (String)localObject1, paramInt));
        return localBundle;
        bool = paramBundle.getBoolean("clear_webview_cache_clear_cookie", false);
        y.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
        paramBundle = new Intent();
        paramBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        paramBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
        com.tencent.mm.cl.b.av(paramBundle);
        return localBundle;
        this.rwe.rvX.runOnUiThread(new a.4.4(this, paramBundle));
        return localBundle;
        paramBundle = getCurrentUrl();
        localObject1 = com.tencent.xweb.b.cSe().getCookie(paramBundle);
        y.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramBundle, localObject1 });
        localBundle.putString("cookie", (String)localObject1);
        return localBundle;
        localObject1 = paramBundle.getString("traceid");
        paramBundle = paramBundle.getString("username");
        h.rnm.fA((String)localObject1, paramBundle);
        return localBundle;
        paramBundle = this.rwe.rvX.mController.getMMTitle();
        localObject1 = getCurrentUrl();
        localBundle.putString("webview_current_url", (String)localObject1);
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.toString();; paramBundle = "")
        {
          localBundle.putString("webview_current_title", paramBundle);
          localBundle.putString("webview_current_desc", (String)localObject1);
          return localBundle;
        }
        bool = paramBundle.getBoolean("add_shortcut_status");
      } while (this.rwe.rvZ == null);
      this.rwe.rvZ.lt(bool);
      return localBundle;
    case 87: 
      bool = this.rwe.rwb.rCq;
      paramBundle = this.rwe.rwb.kMT;
      localObject1 = this.rwe.rwb.rCs;
      if (bool)
      {
        localBundle.putString("result", "not_return");
        return localBundle;
      }
      localBundle.putString("full_url", bk.pm(paramBundle));
      if ((localObject1 != null) && (((Map)localObject1).size() != 0))
      {
        localBundle.putInt("set_cookie", 1);
        com.tencent.xweb.c.il(ae.getContext());
        localObject2 = com.tencent.xweb.b.cSe();
        Iterator localIterator = ((Map)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((com.tencent.xweb.b)localObject2).setCookie(bk.pm(paramBundle), str + "=" + (String)((Map)localObject1).get(str));
        }
        com.tencent.xweb.c.cSg();
        com.tencent.xweb.c.sync();
        y.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ((com.tencent.xweb.b)localObject2).getCookie(bk.pm(paramBundle)) });
        return localBundle;
      }
      localBundle.putInt("set_cookie", 0);
      return localBundle;
    }
    this.rwe.kMB.rwj.ae(paramBundle);
    y.i("MicroMsg.GameFloatWebView", "set game float page time data");
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.4
 * JD-Core Version:    0.7.0.1
 */