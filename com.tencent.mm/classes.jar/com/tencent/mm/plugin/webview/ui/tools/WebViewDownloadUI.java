package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetManager;
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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.io.IOException;
import java.util.Map;

@com.tencent.mm.kernel.i
public class WebViewDownloadUI
  extends MMActivity
{
  private boolean IYZ;
  private Button JfK;
  private Button JfL;
  private a JfM;
  private String JfN;
  private int JfO;
  private m JfP;
  private int eik;
  private int fromScene;
  private long lAs;
  private Context mContext;
  private TextView nAB;
  private String packageName;
  private int qIG;
  
  public WebViewDownloadUI()
  {
    AppMethodBeat.i(79818);
    this.JfP = new m()
    {
      public final void Bd(long paramAnonymousLong)
      {
        AppMethodBeat.i(79811);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79811);
      }
      
      public final void Be(long paramAnonymousLong)
      {
        AppMethodBeat.i(79812);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(79812);
      }
      
      public final void Bf(long paramAnonymousLong) {}
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79810);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131768551), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79810);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79809);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131768554), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79809);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(79808);
        Log.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79808);
      }
      
      public final void l(long paramAnonymousLong, String paramAnonymousString)
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
    Log.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[] { this.JfM, parama });
    this.JfM = parama;
    switch (5.JfU[this.JfM.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79821);
      return;
      this.JfK.setVisibility(0);
      this.nAB.setVisibility(8);
      this.JfL.setVisibility(8);
      AppMethodBeat.o(79821);
      return;
      this.JfK.setVisibility(8);
      this.JfL.setVisibility(0);
      this.nAB.setVisibility(0);
    }
  }
  
  public int getLayoutId()
  {
    return 2131497069;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79819);
    super.onCreate(paramBundle);
    this.mContext = this;
    setMMTitle(getString(2131768557));
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
    overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
    this.JfK = ((Button)findViewById(2131299772));
    this.JfL = ((Button)findViewById(2131299753));
    Object localObject = (TextView)findViewById(2131299771);
    TextView localTextView1 = (TextView)findViewById(2131299791);
    TextView localTextView2 = (TextView)findViewById(2131299759);
    ImageView localImageView = (ImageView)findViewById(2131299787);
    this.nAB = ((TextView)findViewById(2131299788));
    a(a.JfV);
    final String str2 = getIntent().getStringExtra("task_name");
    final String str3 = getIntent().getStringExtra("task_url");
    final String str4 = getIntent().getStringExtra("alternative_url");
    long l = getIntent().getLongExtra("task_size", 0L);
    final String str5 = getIntent().getStringExtra("file_md5");
    final String str6 = getIntent().getStringExtra("extInfo");
    paramBundle = getIntent().getStringExtra("fileType");
    final String str7 = getIntent().getStringExtra("appid");
    this.packageName = getIntent().getStringExtra("package_name");
    String str8 = getIntent().getStringExtra("thumb_url");
    String str1 = getIntent().getStringExtra("title");
    final String str9 = getIntent().getStringExtra("page_url");
    final int j = getIntent().getIntExtra("task_scene", 0);
    this.JfO = getIntent().getIntExtra("page_scene", 0);
    this.fromScene = getIntent().getIntExtra("from_scene", 0);
    this.eik = getIntent().getIntExtra("task_download_type", 0);
    Log.i("MicroMsg.WebViewDownloadUI", "onCreate: md5=%s, url=%s, extInfo=%s, fileType=%s, appId=%s, packageName=%s, taskSize=%d, thumbUrl=%s, pageScene=%s", new Object[] { str5, str3, str6, paramBundle, str7, this.packageName, Long.valueOf(l), str8, Integer.valueOf(this.JfO) });
    com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str7, Integer.valueOf(1), str9, str3, Integer.valueOf(this.fromScene) });
    this.qIG = Util.getInt(paramBundle, 1);
    if (Util.isNullOrNil(str1)) {
      paramBundle = Util.nullAsNil(str2);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramBundle))
      {
        ((TextView)localObject).setText(paramBundle);
        ((TextView)localObject).setVisibility(0);
      }
      try
      {
        localMap = XmlParser.parseXml(Util.convertStreamToString(getAssets().open("app_info_arrays.xml")), "apps", null);
        int k = Util.getInt((String)localMap.get(".apps.$count"), 0);
        i = 0;
        label549:
        if (i < k)
        {
          localObject = new StringBuilder(".apps.app");
          if (i > 0)
          {
            paramBundle = Integer.valueOf(i);
            label576:
            paramBundle = paramBundle;
            localObject = (String)localMap.get(paramBundle + ".$name");
            str10 = (String)localMap.get(paramBundle + ".$package");
            String str11 = (String)localMap.get(paramBundle + ".$task");
            if ((!((String)localObject).equalsIgnoreCase(str1)) && (!((String)localObject).equalsIgnoreCase(str2)) && (!str10.equalsIgnoreCase(this.packageName)) && (!str11.equalsIgnoreCase(str2))) {
              break label1195;
            }
            localObject = (String)localMap.get(paramBundle + ".$version");
          }
        }
      }
      catch (IOException paramBundle)
      {
        try
        {
          Map localMap;
          paramBundle = (String)localMap.get(paramBundle + ".$developer");
        }
        catch (IOException paramBundle)
        {
          try
          {
            int i;
            String str10;
            this.packageName = str10;
            for (;;)
            {
              label793:
              Log.i("MicroMsg.WebViewDownloadUI", "title:%s taskName:%s, package:%s, version:%s, developer:%s", new Object[] { str1, str2, this.packageName, localObject, paramBundle });
              if (!Util.isNullOrNil((String)localObject))
              {
                localTextView1.setText(getString(2131768543, new Object[] { localObject }));
                localTextView1.setVisibility(0);
              }
              if (!Util.isNullOrNil(paramBundle))
              {
                localTextView2.setText(getString(2131768540, new Object[] { paramBundle }));
                localTextView2.setVisibility(0);
              }
              if (!Util.isNullOrNil(this.packageName))
              {
                paramBundle = String.format("<a href='" + "https://dldir1.qq.com/weixin/android/wechat_webview_download_appinfo_new.html?fun=%s&package=%s" + "'>%s</a> | <a href='" + "https://dldir1.qq.com/weixin/android/wechat_webview_download_appinfo_new.html?fun=%s&package=%s" + "'>%s</a>", new Object[] { "permission", this.packageName, getString(2131768541), "privacy", this.packageName, getString(2131768542) });
                localObject = (TextView)findViewById(2131296947);
                ((TextView)localObject).setText(paramBundle);
                l.p((TextView)localObject, 1);
                ((TextView)localObject).setVisibility(0);
              }
              if (l > 0L)
              {
                this.JfN = Util.getSizeMB(l);
                this.JfK.setText(getString(2131768548, new Object[] { this.JfN }));
              }
              paramBundle = q.bcV();
              localObject = new c.a();
              ((c.a)localObject).jbq = 2131691774;
              ((c.a)localObject).jbf = true;
              paramBundle.a(str8, localImageView, ((c.a)localObject).bdv());
              this.JfK.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(79806);
                  b localb = new b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[] { WebViewDownloadUI.a(WebViewDownloadUI.this) });
                  switch (WebViewDownloadUI.5.JfU[WebViewDownloadUI.a(WebViewDownloadUI.this).ordinal()])
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
                      Toast.makeText(WebViewDownloadUI.b(WebViewDownloadUI.this), WebViewDownloadUI.this.getString(2131761199), 0).show();
                      Log.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(79806);
                      return;
                    }
                    if (NetStatusUtil.isWifi(WebViewDownloadUI.b(WebViewDownloadUI.this)))
                    {
                      WebViewDownloadUI.a(WebViewDownloadUI.this, str3, str5, str6, str7, str4, str9, str2, WebViewDownloadUI.c(WebViewDownloadUI.this), j);
                    }
                    else
                    {
                      com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str7, Integer.valueOf(4), str9, str3, Integer.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)) });
                      com.tencent.mm.ui.base.h.a(WebViewDownloadUI.this, WebViewDownloadUI.this.getString(2131768552), WebViewDownloadUI.this.getString(2131768553), WebViewDownloadUI.this.getString(2131768547), WebViewDownloadUI.this.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(79804);
                          com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(5), WebViewDownloadUI.2.this.xxn, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)) });
                          WebViewDownloadUI.a(WebViewDownloadUI.this, WebViewDownloadUI.2.this.val$url, WebViewDownloadUI.2.this.lhI, WebViewDownloadUI.2.this.lzO, WebViewDownloadUI.2.this.val$appId, WebViewDownloadUI.2.this.JfR, WebViewDownloadUI.2.this.xxn, WebViewDownloadUI.2.this.lAc, WebViewDownloadUI.c(WebViewDownloadUI.this), WebViewDownloadUI.2.this.JfS);
                          paramAnonymous2DialogInterface.dismiss();
                          AppMethodBeat.o(79804);
                        }
                      }, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          AppMethodBeat.i(79805);
                          com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(6), WebViewDownloadUI.2.this.xxn, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)) });
                          paramAnonymous2DialogInterface.dismiss();
                          AppMethodBeat.o(79805);
                        }
                      }, 2131101414);
                    }
                  }
                }
              });
              this.JfL.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(79807);
                  b localb = new b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[] { Long.valueOf(WebViewDownloadUI.e(WebViewDownloadUI.this)), WebViewDownloadUI.a(WebViewDownloadUI.this) });
                  com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str7, Integer.valueOf(3), str9, str3, Integer.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)) });
                  if (WebViewDownloadUI.e(WebViewDownloadUI.this) <= 0L)
                  {
                    Log.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
                    Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131768549), 1).show();
                  }
                  for (;;)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79807);
                    return;
                    int i = f.cBv().Cn(WebViewDownloadUI.e(WebViewDownloadUI.this));
                    Log.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[] { Integer.valueOf(i) });
                    if (i <= 0) {
                      break;
                    }
                    Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131768550), 1).show();
                    WebViewDownloadUI.this.finish();
                  }
                }
              });
              f.cBv();
              c.a(this.JfP);
              AppMethodBeat.o(79819);
              return;
              paramBundle = str1;
              break;
              paramBundle = "";
              break label576;
              label1195:
              i += 1;
              break label549;
              paramBundle = null;
              localObject = null;
              continue;
              paramBundle = paramBundle;
              paramBundle = null;
              localObject = null;
              continue;
              paramBundle = paramBundle;
              paramBundle = null;
            }
          }
          catch (IOException localIOException)
          {
            break label793;
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79820);
    super.onDestroy();
    Log.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[] { Boolean.valueOf(this.IYZ) });
    if (!this.IYZ)
    {
      com.tencent.mm.g.a.i locali = new com.tencent.mm.g.a.i();
      locali.dBY.dBZ = true;
      locali.dBY.scene = this.JfO;
      EventCenter.instance.publish(locali);
      this.IYZ = true;
    }
    f.cBv();
    c.b(this.JfP);
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
      JfV = new a("TO_DOWNLOAD", 0);
      JfW = new a("DOWNLOADING", 1);
      JfX = new a[] { JfV, JfW };
      AppMethodBeat.o(79817);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI
 * JD-Core Version:    0.7.0.1
 */