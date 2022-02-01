package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@i
public class WebViewDownloadUI
  extends MMActivity
{
  private boolean DTZ;
  private Button EaA;
  private TextView EaB;
  private a EaC;
  private String EaD;
  private TextView EaE;
  private int EaF;
  private m EaG;
  private int fromScene;
  private long ksY;
  private Context mContext;
  private TextView mkS;
  private int pmx;
  
  public WebViewDownloadUI()
  {
    AppMethodBeat.i(79818);
    this.EaG = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79810);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766085), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79810);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79809);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766088), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79809);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(79808);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79808);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(79813);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79813);
      }
      
      public final void sL(long paramAnonymousLong)
      {
        AppMethodBeat.i(79811);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79811);
      }
      
      public final void sM(long paramAnonymousLong)
      {
        AppMethodBeat.i(79812);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(79812);
      }
      
      public final void sN(long paramAnonymousLong) {}
    };
    AppMethodBeat.o(79818);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(79821);
    ad.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[] { this.EaC, parama });
    this.EaC = parama;
    switch (5.EaL[this.EaC.ordinal()])
    {
    default: 
      AppMethodBeat.o(79821);
      return;
    case 1: 
      this.EaA.setVisibility(0);
      this.mkS.setVisibility(8);
      this.EaB.setVisibility(8);
    }
    do
    {
      this.EaE.setVisibility(8);
      break;
      this.EaA.setVisibility(8);
      this.EaB.setVisibility(0);
      this.mkS.setVisibility(0);
    } while (bt.isNullOrNil(this.EaD));
    this.EaE.setVisibility(0);
    AppMethodBeat.o(79821);
  }
  
  public int getLayoutId()
  {
    return 2131496083;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79819);
    super.onCreate(paramBundle);
    this.mContext = this;
    setMMTitle(getString(2131766091));
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
    overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
    this.EaA = ((Button)findViewById(2131299211));
    this.EaB = ((TextView)findViewById(2131299197));
    TextView localTextView = (TextView)findViewById(2131299225);
    this.EaE = ((TextView)findViewById(2131299220));
    ImageView localImageView = (ImageView)findViewById(2131299223);
    this.mkS = ((TextView)findViewById(2131299224));
    a(a.EaM);
    final String str1 = getIntent().getStringExtra("task_name");
    final String str2 = getIntent().getStringExtra("task_url");
    final String str3 = getIntent().getStringExtra("alternative_url");
    long l = getIntent().getLongExtra("task_size", 0L);
    final String str4 = getIntent().getStringExtra("file_md5");
    final String str5 = getIntent().getStringExtra("extInfo");
    paramBundle = getIntent().getStringExtra("fileType");
    final String str6 = getIntent().getStringExtra("appid");
    final String str7 = getIntent().getStringExtra("package_name");
    String str8 = getIntent().getStringExtra("thumb_url");
    Object localObject = getIntent().getStringExtra("title");
    final String str9 = getIntent().getStringExtra("page_url");
    final int i = getIntent().getIntExtra("task_scene", 0);
    this.EaF = getIntent().getIntExtra("page_scene", 0);
    this.fromScene = getIntent().getIntExtra("from_scene", 0);
    g.yhR.f(14217, new Object[] { str6, Integer.valueOf(1), str9, str2, Integer.valueOf(this.fromScene) });
    this.pmx = bt.getInt(paramBundle, 1);
    paramBundle = (Bundle)localObject;
    if (bt.isNullOrNil((String)localObject)) {
      paramBundle = bt.nullAsNil(str1);
    }
    if (!bt.isNullOrNil(paramBundle))
    {
      localTextView.setText(paramBundle);
      localTextView.setVisibility(0);
    }
    if (l > 0L)
    {
      this.EaD = bt.Dd(l);
      this.EaE.setText(this.EaD);
      this.EaA.setText(getString(2131766082, new Object[] { this.EaD }));
    }
    paramBundle = q.aIJ();
    localObject = new c.a();
    ((c.a)localObject).idD = 2131691436;
    ((c.a)localObject).idr = true;
    paramBundle.a(str8, localImageView, ((c.a)localObject).aJc());
    this.EaA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79806);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[] { WebViewDownloadUI.a(WebViewDownloadUI.this) });
        switch (WebViewDownloadUI.5.EaL[WebViewDownloadUI.a(WebViewDownloadUI.this).ordinal()])
        {
        default: 
          ad.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79806);
          return;
          if (!ay.isNetworkConnected(WebViewDownloadUI.b(WebViewDownloadUI.this)))
          {
            Toast.makeText(WebViewDownloadUI.b(WebViewDownloadUI.this), WebViewDownloadUI.this.getString(2131759864), 0).show();
            ad.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79806);
            return;
          }
          if (ay.isWifi(WebViewDownloadUI.b(WebViewDownloadUI.this)))
          {
            WebViewDownloadUI.a(WebViewDownloadUI.this, str2, str4, str5, str6, str3, str9, str1, str7, i);
          }
          else
          {
            g.yhR.f(14217, new Object[] { str6, Integer.valueOf(4), str9, str2, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
            com.tencent.mm.ui.base.h.a(WebViewDownloadUI.this, WebViewDownloadUI.this.getString(2131766086), WebViewDownloadUI.this.getString(2131766087), WebViewDownloadUI.this.getString(2131766081), WebViewDownloadUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(79804);
                g.yhR.f(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(5), WebViewDownloadUI.2.this.tUk, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
                WebViewDownloadUI.a(WebViewDownloadUI.this, WebViewDownloadUI.2.this.val$url, WebViewDownloadUI.2.this.lxP, WebViewDownloadUI.2.this.ksu, WebViewDownloadUI.2.this.val$appId, WebViewDownloadUI.2.this.EaI, WebViewDownloadUI.2.this.tUk, WebViewDownloadUI.2.this.ksI, WebViewDownloadUI.2.this.cCk, WebViewDownloadUI.2.this.EaJ);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(79804);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(79805);
                g.yhR.f(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(6), WebViewDownloadUI.2.this.tUk, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(79805);
              }
            }, 2131101171);
          }
        }
      }
    });
    this.EaB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79807);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[] { Long.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)), WebViewDownloadUI.a(WebViewDownloadUI.this) });
        g.yhR.f(14217, new Object[] { str6, Integer.valueOf(3), str9, str2, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
        if (WebViewDownloadUI.d(WebViewDownloadUI.this) <= 0L)
        {
          ad.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
          Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766083), 1).show();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79807);
          return;
          int i = f.ccl().tR(WebViewDownloadUI.d(WebViewDownloadUI.this));
          ad.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            break;
          }
          Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766084), 1).show();
          WebViewDownloadUI.this.finish();
        }
      }
    });
    f.ccl();
    c.a(this.EaG);
    AppMethodBeat.o(79819);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79820);
    super.onDestroy();
    ad.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[] { Boolean.valueOf(this.DTZ) });
    if (!this.DTZ)
    {
      com.tencent.mm.g.a.h localh = new com.tencent.mm.g.a.h();
      localh.djK.djL = true;
      localh.djK.scene = this.EaF;
      com.tencent.mm.sdk.b.a.IbL.l(localh);
      this.DTZ = true;
    }
    f.ccl();
    c.b(this.EaG);
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
      EaM = new a("TO_DOWNLOAD", 0);
      EaN = new a("DOWNLOADING", 1);
      EaO = new a[] { EaM, EaN };
      AppMethodBeat.o(79817);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI
 * JD-Core Version:    0.7.0.1
 */