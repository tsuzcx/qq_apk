package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.j;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aw;
import java.io.IOException;
import java.util.Map;

@com.tencent.mm.kernel.k
public class WebViewDownloadUI
  extends MMActivity
{
  private boolean WLY;
  private Button WUI;
  private Button WUJ;
  private a WUK;
  private String WUL;
  private int WUM;
  private m WUN;
  private String errMsg;
  private int fromScene;
  private int iiN;
  private Context mContext;
  private String packageName;
  private long rzd;
  private TextView tHK;
  private int xnM;
  
  public WebViewDownloadUI()
  {
    AppMethodBeat.i(79818);
    this.WUN = new m()
    {
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79809);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(c.i.webview_download_ui_downloaded_suc), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79809);
      }
      
      public final void c(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79810);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(c.i.webview_download_ui_download_failed), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79810);
      }
      
      public final void jF(long paramAnonymousLong)
      {
        AppMethodBeat.i(79811);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79811);
      }
      
      public final void jG(long paramAnonymousLong)
      {
        AppMethodBeat.i(79812);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(79812);
      }
      
      public final void jH(long paramAnonymousLong) {}
      
      public final void v(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(79808);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79808);
      }
      
      public final void w(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(79813);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79813);
      }
    };
    AppMethodBeat.o(79818);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(79821);
    Log.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[] { this.WUK, parama });
    this.WUK = parama;
    switch (5.WUS[this.WUK.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79821);
      return;
      this.WUI.setVisibility(0);
      this.tHK.setVisibility(8);
      this.WUJ.setVisibility(8);
      AppMethodBeat.o(79821);
      return;
      this.WUI.setVisibility(8);
      this.WUJ.setVisibility(0);
      this.tHK.setVisibility(0);
    }
  }
  
  public int getLayoutId()
  {
    return c.g.webview_download_ui_new;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79819);
    super.onCreate(paramBundle);
    this.mContext = this;
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(79803);
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79803);
        return true;
      }
    });
    setActionbarColor(getResources().getColor(c.c.white));
    overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
    this.WUI = ((Button)findViewById(c.f.download_op_btn));
    this.WUJ = ((Button)findViewById(c.f.download_cancel_btn));
    Object localObject1 = (TextView)findViewById(c.f.download_name);
    TextView localTextView1 = (TextView)findViewById(c.f.download_version);
    TextView localTextView2 = (TextView)findViewById(c.f.download_developer);
    ImageView localImageView = (ImageView)findViewById(c.f.download_thumb);
    this.tHK = ((TextView)findViewById(c.f.download_tips));
    a(a.WUT);
    final String str3 = getIntent().getStringExtra("task_name");
    final String str4 = getIntent().getStringExtra("task_url");
    final String str5 = getIntent().getStringExtra("alternative_url");
    long l = getIntent().getLongExtra("task_size", 0L);
    final String str6 = getIntent().getStringExtra("file_md5");
    final String str7 = getIntent().getStringExtra("extInfo");
    paramBundle = getIntent().getStringExtra("fileType");
    final String str8 = getIntent().getStringExtra("appid");
    this.packageName = getIntent().getStringExtra("package_name");
    String str9 = getIntent().getStringExtra("thumb_url");
    String str2 = getIntent().getStringExtra("title");
    final String str10 = getIntent().getStringExtra("page_url");
    final int j = getIntent().getIntExtra("task_scene", 0);
    this.WUM = getIntent().getIntExtra("page_scene", 0);
    this.fromScene = getIntent().getIntExtra("from_scene", 0);
    this.iiN = getIntent().getIntExtra("task_download_type", 0);
    Log.i("MicroMsg.WebViewDownloadUI", "onCreate: md5=%s, url=%s, extInfo=%s, fileType=%s, appId=%s, packageName=%s, taskSize=%d, thumbUrl=%s, pageScene=%s", new Object[] { str6, str4, str7, paramBundle, str8, this.packageName, Long.valueOf(l), str9, Integer.valueOf(this.WUM) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str8, Integer.valueOf(1), str10, str4, Integer.valueOf(this.fromScene) });
    this.xnM = Util.getInt(paramBundle, 1);
    String str1;
    String str11;
    String str12;
    if (Util.isNullOrNil(str2))
    {
      paramBundle = Util.nullAsNil(str3);
      if (!Util.isNullOrNil(paramBundle))
      {
        aw.a(((TextView)localObject1).getPaint(), 0.8F);
        ((TextView)localObject1).setText(paramBundle);
        ((TextView)localObject1).setVisibility(0);
      }
      str1 = getIntent().getStringExtra("app_developer");
      paramBundle = getIntent().getStringExtra("app_version");
      str11 = getIntent().getStringExtra("app_privacy_url");
      str12 = getIntent().getStringExtra("app_permission_url");
      if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(paramBundle)) && (!Util.isNullOrNil(this.packageName))) {
        break label1716;
      }
    }
    for (;;)
    {
      try
      {
        localMap = XmlParser.parseXml(Util.convertStreamToString(getAssets().open("app_info_arrays.xml")), "apps", null);
        k = Util.getInt((String)localMap.get(".apps.$count"), 0);
        i = 0;
        if (i < k)
        {
          localObject2 = new StringBuilder(".apps.app");
          if (i > 0)
          {
            localObject1 = Integer.valueOf(i);
            str13 = localObject1;
            localObject1 = (String)localMap.get(str13 + ".$name");
            localObject2 = (String)localMap.get(str13 + ".$package");
            String str14 = (String)localMap.get(str13 + ".$task");
            if ((!((String)localObject1).equalsIgnoreCase(str2)) && (!((String)localObject1).equalsIgnoreCase(str3)) && (!((String)localObject2).equalsIgnoreCase(this.packageName)) && (!str14.equalsIgnoreCase(str3))) {
              continue;
            }
            if (!Util.isNullOrNil(paramBundle)) {
              continue;
            }
            localObject1 = (String)localMap.get(str13 + ".$version");
          }
        }
      }
      catch (IOException paramBundle)
      {
        try
        {
          Map localMap;
          String str13;
          if (Util.isNullOrNil(str1)) {
            paramBundle = (String)localMap.get(str13 + ".$developer");
          }
        }
        catch (IOException paramBundle)
        {
          try
          {
            Object localObject2;
            if (Util.isNullOrNil(this.packageName))
            {
              this.packageName = ((String)localObject2);
              Log.i("MicroMsg.WebViewDownloadUI", "title:%s taskName:%s, package:%s, version:%s, developer:%s, permissionUrl:%s, privacyAgreementUrl:%s", new Object[] { str2, str3, this.packageName, localObject1, paramBundle, str12, str11 });
              i = 1;
              if (Util.isNullOrNil((String)localObject1)) {
                continue;
              }
              localTextView1.setText(getString(c.i.webview_download_ui_app_version, new Object[] { localObject1 }));
              localTextView1.setVisibility(0);
              if (Util.isNullOrNil(paramBundle)) {
                continue;
              }
              localTextView2.setText(getString(c.i.webview_download_ui_app_developer, new Object[] { paramBundle }));
              localTextView2.setVisibility(0);
              if ((Util.isNullOrNil(this.packageName)) && ((Util.isNullOrNil(str12)) || (Util.isNullOrNil(str11)))) {
                continue;
              }
              if ((Util.isNullOrNil(str12)) || (Util.isNullOrNil(str11))) {
                continue;
              }
              paramBundle = String.format("<a href='" + str12 + "'>%s</a>  |  <a href='" + str11 + "'>%s</a>", new Object[] { getString(c.i.webview_download_ui_app_permission_detail), getString(c.i.webview_download_ui_app_privacy_detail) });
              localObject1 = (TextView)findViewById(c.f.app_info_extra);
              ((TextView)localObject1).setText(paramBundle);
              p.t((TextView)localObject1, 1);
              ((TextView)localObject1).setVisibility(0);
              if (i != 0) {
                continue;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str8, Integer.valueOf(7), str10, str4, Integer.valueOf(this.fromScene) });
              if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yNt, 1) != 1) {
                continue;
              }
              i = 1;
              this.errMsg = "Missing required parameters: developer, app_version, privacy_agreement_url or permission_url.";
              if (i == 0) {
                continue;
              }
              Log.w("MicroMsg.WebViewDownloadUI", "Finish without all elements");
              Toast.makeText(this, getString(c.i.webview_download_ui_not_missing_element, new Object[] { this.errMsg }), 1).show();
              finish();
              AppMethodBeat.o(79819);
              return;
              paramBundle = str2;
              break;
              localObject1 = "";
              continue;
              i += 1;
              continue;
            }
            continue;
            int i = 0;
            continue;
            i = 0;
            continue;
            paramBundle = String.format("<a href='" + "https://dldir1.qq.com/weixin/android/wechat_webview_download_appinfo_new.html?fun=%s&package=%s" + "'>%s</a>  |  <a href='" + "https://dldir1.qq.com/weixin/android/wechat_webview_download_appinfo_new.html?fun=%s&package=%s" + "'>%s</a>", new Object[] { "permission", this.packageName, getString(c.i.webview_download_ui_app_permission_detail), "privacy", this.packageName, getString(c.i.webview_download_ui_app_privacy_detail) });
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            if (l > 0L)
            {
              this.WUL = Util.getSizeMB(l);
              this.WUI.setText(getString(c.i.webview_download_ui_btn_state_to_download_size, new Object[] { this.WUL }));
            }
            i = getResources().getDimensionPixelSize(c.d.Edge_3_5_A);
            int k = getResources().getDimensionPixelSize(c.d.Edge_18A);
            int m = getIntent().getIntExtra("icon_res_id", c.h.webview_download_thumb_unknown);
            paramBundle = r.bKe();
            localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKB = m;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKo = true;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKJ = true;
            localObject1 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).eG(k, k);
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKA = true;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).nrc = true;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKI = i;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKp = true;
            paramBundle.a(str9, localImageView, ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx());
            this.WUI.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79806);
                b localb = new b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                Log.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[] { WebViewDownloadUI.a(WebViewDownloadUI.this) });
                switch (WebViewDownloadUI.5.WUS[WebViewDownloadUI.a(WebViewDownloadUI.this).ordinal()])
                {
                default: 
                  Log.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(79806);
                  return;
                  if (!NetStatusUtil.isNetworkConnected(WebViewDownloadUI.b(WebViewDownloadUI.this)))
                  {
                    Toast.makeText(WebViewDownloadUI.b(WebViewDownloadUI.this), WebViewDownloadUI.this.getString(c.i.game_download_network_unavailable), 0).show();
                    Log.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79806);
                    return;
                  }
                  if (NetStatusUtil.isWifi(WebViewDownloadUI.b(WebViewDownloadUI.this)))
                  {
                    WebViewDownloadUI.a(WebViewDownloadUI.this, str4, str6, str7, str8, str5, str10, str3, WebViewDownloadUI.c(WebViewDownloadUI.this), j);
                  }
                  else
                  {
                    com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str8, Integer.valueOf(4), str10, str4, Integer.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)) });
                    com.tencent.mm.ui.base.k.a(WebViewDownloadUI.this, WebViewDownloadUI.this.getString(c.i.webview_download_ui_download_not_in_wifi_tips), WebViewDownloadUI.this.getString(c.i.webview_download_ui_download_not_in_wifi_title), WebViewDownloadUI.this.getString(c.i.webview_download_ui_btn_state_to_download), WebViewDownloadUI.this.getString(c.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(79804);
                        com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { WebViewDownloadUI.2.this.etl, Integer.valueOf(5), WebViewDownloadUI.2.this.Ivm, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)) });
                        WebViewDownloadUI.a(WebViewDownloadUI.this, WebViewDownloadUI.2.this.val$url, WebViewDownloadUI.2.this.oJE, WebViewDownloadUI.2.this.ryy, WebViewDownloadUI.2.this.etl, WebViewDownloadUI.2.this.WUP, WebViewDownloadUI.2.this.Ivm, WebViewDownloadUI.2.this.ryN, WebViewDownloadUI.c(WebViewDownloadUI.this), WebViewDownloadUI.2.this.WUQ);
                        paramAnonymous2DialogInterface.dismiss();
                        AppMethodBeat.o(79804);
                      }
                    }, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(79805);
                        com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { WebViewDownloadUI.2.this.etl, Integer.valueOf(6), WebViewDownloadUI.2.this.Ivm, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)) });
                        paramAnonymous2DialogInterface.dismiss();
                        AppMethodBeat.o(79805);
                      }
                    }, c.c.wechat_green);
                  }
                }
              }
            });
            this.WUJ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79807);
                b localb = new b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                Log.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[] { Long.valueOf(WebViewDownloadUI.e(WebViewDownloadUI.this)), WebViewDownloadUI.a(WebViewDownloadUI.this) });
                com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str8, Integer.valueOf(3), str10, str4, Integer.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)) });
                if (WebViewDownloadUI.e(WebViewDownloadUI.this) <= 0L)
                {
                  Log.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
                  Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(c.i.webview_download_ui_cancel_failed), 1).show();
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(79807);
                  return;
                  int i = f.duv().kR(WebViewDownloadUI.e(WebViewDownloadUI.this));
                  Log.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[] { Integer.valueOf(i) });
                  if (i <= 0) {
                    break;
                  }
                  Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(c.i.webview_download_ui_canceled), 1).show();
                  WebViewDownloadUI.this.finish();
                }
              }
            });
            f.duv();
            com.tencent.mm.plugin.downloader.model.c.a(this.WUN);
            AppMethodBeat.o(79819);
            return;
            localIOException1 = localIOException1;
            localBundle = paramBundle;
            paramBundle = str1;
            continue;
            paramBundle = paramBundle;
            paramBundle = str1;
            continue;
          }
          catch (IOException localIOException2)
          {
            continue;
          }
          paramBundle = localIOException2;
          continue;
        }
        localBundle = paramBundle;
        continue;
        localBundle = paramBundle;
        paramBundle = localIOException2;
        continue;
      }
      label1716:
      Bundle localBundle = paramBundle;
      paramBundle = localIOException2;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79820);
    super.onDestroy();
    Log.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[] { Boolean.valueOf(this.WLY) });
    if (!this.WLY)
    {
      j localj = new j();
      localj.hyT.hyU = true;
      localj.hyT.scene = this.WUM;
      localj.hyT.errMsg = this.errMsg;
      localj.publish();
      this.WLY = true;
    }
    f.duv();
    com.tencent.mm.plugin.downloader.model.c.b(this.WUN);
    AppMethodBeat.o(79820);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(79817);
      WUT = new a("TO_DOWNLOAD", 0);
      WUU = new a("DOWNLOADING", 1);
      WUV = new a[] { WUT, WUU };
      AppMethodBeat.o(79817);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI
 * JD-Core Version:    0.7.0.1
 */