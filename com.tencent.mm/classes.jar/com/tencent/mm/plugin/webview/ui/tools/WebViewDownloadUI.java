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
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@i
public class WebViewDownloadUI
  extends MMActivity
{
  private boolean AYk;
  private Button BeG;
  private TextView BeH;
  private a BeI;
  private String BeJ;
  private TextView BeK;
  private int BeL;
  private m BeM;
  private int fromScene;
  private long jyh;
  private TextView lln;
  private Context mContext;
  private int ofq;
  
  public WebViewDownloadUI()
  {
    AppMethodBeat.i(79818);
    this.BeM = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79810);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766085), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79810);
      }
      
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
        AppMethodBeat.i(79813);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79813);
      }
      
      public final void mZ(long paramAnonymousLong) {}
      
      public final void na(long paramAnonymousLong) {}
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(79812);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(79812);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(79811);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79811);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(79808);
        ad.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79808);
      }
    };
    AppMethodBeat.o(79818);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(79821);
    ad.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[] { this.BeI, parama });
    this.BeI = parama;
    switch (5.BeR[this.BeI.ordinal()])
    {
    default: 
      AppMethodBeat.o(79821);
      return;
    case 1: 
      this.BeG.setVisibility(0);
      this.lln.setVisibility(8);
      this.BeH.setVisibility(8);
    }
    do
    {
      this.BeK.setVisibility(8);
      break;
      this.BeG.setVisibility(8);
      this.BeH.setVisibility(0);
      this.lln.setVisibility(0);
    } while (bt.isNullOrNil(this.BeJ));
    this.BeK.setVisibility(0);
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
    overridePendingTransition(MMFragmentActivity.a.lLF, MMFragmentActivity.a.lLG);
    this.BeG = ((Button)findViewById(2131299211));
    this.BeH = ((TextView)findViewById(2131299197));
    TextView localTextView = (TextView)findViewById(2131299225);
    this.BeK = ((TextView)findViewById(2131299220));
    ImageView localImageView = (ImageView)findViewById(2131299223);
    this.lln = ((TextView)findViewById(2131299224));
    a(a.BeS);
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
    this.BeL = getIntent().getIntExtra("page_scene", 0);
    this.fromScene = getIntent().getIntExtra("from_scene", 0);
    com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { str6, Integer.valueOf(1), str9, str2, Integer.valueOf(this.fromScene) });
    this.ofq = bt.getInt(paramBundle, 1);
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
      this.BeJ = bt.vK(l);
      this.BeK.setText(this.BeJ);
      this.BeG.setText(getString(2131766082, new Object[] { this.BeJ }));
    }
    paramBundle = o.ayJ();
    localObject = new c.a();
    ((c.a)localObject).hkf = 2131691436;
    ((c.a)localObject).hjU = true;
    paramBundle.a(str8, localImageView, ((c.a)localObject).azc());
    this.BeG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79806);
        ad.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[] { WebViewDownloadUI.a(WebViewDownloadUI.this) });
        switch (WebViewDownloadUI.5.BeR[WebViewDownloadUI.a(WebViewDownloadUI.this).ordinal()])
        {
        default: 
          ad.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
          AppMethodBeat.o(79806);
          return;
        }
        if (!ay.isNetworkConnected(WebViewDownloadUI.b(WebViewDownloadUI.this)))
        {
          Toast.makeText(WebViewDownloadUI.b(WebViewDownloadUI.this), WebViewDownloadUI.this.getString(2131759864), 0).show();
          ad.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
          AppMethodBeat.o(79806);
          return;
        }
        if (ay.isWifi(WebViewDownloadUI.b(WebViewDownloadUI.this)))
        {
          WebViewDownloadUI.a(WebViewDownloadUI.this, str2, str4, str5, str6, str3, str9, str1, str7, i);
          AppMethodBeat.o(79806);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { str6, Integer.valueOf(4), str9, str2, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
        com.tencent.mm.ui.base.h.a(WebViewDownloadUI.this, WebViewDownloadUI.this.getString(2131766086), WebViewDownloadUI.this.getString(2131766087), WebViewDownloadUI.this.getString(2131766081), WebViewDownloadUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(79804);
            com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(5), WebViewDownloadUI.2.this.AUY, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
            WebViewDownloadUI.a(WebViewDownloadUI.this, WebViewDownloadUI.2.this.val$url, WebViewDownloadUI.2.this.kzy, WebViewDownloadUI.2.this.jxC, WebViewDownloadUI.2.this.val$appId, WebViewDownloadUI.2.this.BeO, WebViewDownloadUI.2.this.AUY, WebViewDownloadUI.2.this.jxQ, WebViewDownloadUI.2.this.cug, WebViewDownloadUI.2.this.BeP);
            paramAnonymous2DialogInterface.dismiss();
            AppMethodBeat.o(79804);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(79805);
            com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(6), WebViewDownloadUI.2.this.AUY, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
            paramAnonymous2DialogInterface.dismiss();
            AppMethodBeat.o(79805);
          }
        }, 2131101171);
        AppMethodBeat.o(79806);
      }
    });
    this.BeH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79807);
        ad.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[] { Long.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)), WebViewDownloadUI.a(WebViewDownloadUI.this) });
        com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { str6, Integer.valueOf(3), str9, str2, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
        if (WebViewDownloadUI.d(WebViewDownloadUI.this) <= 0L) {
          ad.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
        }
        int i;
        do
        {
          Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766083), 1).show();
          AppMethodBeat.o(79807);
          return;
          i = f.bQt().og(WebViewDownloadUI.d(WebViewDownloadUI.this));
          ad.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[] { Integer.valueOf(i) });
        } while (i <= 0);
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766084), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79807);
      }
    });
    f.bQt();
    c.a(this.BeM);
    AppMethodBeat.o(79819);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79820);
    super.onDestroy();
    ad.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[] { Boolean.valueOf(this.AYk) });
    if (!this.AYk)
    {
      com.tencent.mm.g.a.h localh = new com.tencent.mm.g.a.h();
      localh.daW.daX = true;
      localh.daW.scene = this.BeL;
      com.tencent.mm.sdk.b.a.ESL.l(localh);
      this.AYk = true;
    }
    f.bQt();
    c.b(this.BeM);
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
      BeS = new a("TO_DOWNLOAD", 0);
      BeT = new a("DOWNLOADING", 1);
      BeU = new a[] { BeS, BeT };
      AppMethodBeat.o(79817);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI
 * JD-Core Version:    0.7.0.1
 */