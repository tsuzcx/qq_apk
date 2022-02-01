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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@i
public class WebViewDownloadUI
  extends MMActivity
{
  private boolean Cqx;
  private Button CwS;
  private TextView CwT;
  private a CwU;
  private String CwV;
  private TextView CwW;
  private int CwX;
  private m CwY;
  private int fromScene;
  private long jYC;
  private TextView lLe;
  private Context mContext;
  private int oIR;
  
  public WebViewDownloadUI()
  {
    AppMethodBeat.i(79818);
    this.CwY = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79810);
        ac.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766085), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79810);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79809);
        ac.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766088), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79809);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(79813);
        ac.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79813);
      }
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(79812);
        ac.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(79812);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(79811);
        ac.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79811);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(79808);
        ac.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(79808);
      }
      
      public final void qN(long paramAnonymousLong) {}
      
      public final void qO(long paramAnonymousLong) {}
    };
    AppMethodBeat.o(79818);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(79821);
    ac.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[] { this.CwU, parama });
    this.CwU = parama;
    switch (5.Cxd[this.CwU.ordinal()])
    {
    default: 
      AppMethodBeat.o(79821);
      return;
    case 1: 
      this.CwS.setVisibility(0);
      this.lLe.setVisibility(8);
      this.CwT.setVisibility(8);
    }
    do
    {
      this.CwW.setVisibility(8);
      break;
      this.CwS.setVisibility(8);
      this.CwT.setVisibility(0);
      this.lLe.setVisibility(0);
    } while (bs.isNullOrNil(this.CwV));
    this.CwW.setVisibility(0);
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
    overridePendingTransition(MMFragmentActivity.a.mnC, MMFragmentActivity.a.mnD);
    this.CwS = ((Button)findViewById(2131299211));
    this.CwT = ((TextView)findViewById(2131299197));
    TextView localTextView = (TextView)findViewById(2131299225);
    this.CwW = ((TextView)findViewById(2131299220));
    ImageView localImageView = (ImageView)findViewById(2131299223);
    this.lLe = ((TextView)findViewById(2131299224));
    a(a.Cxe);
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
    this.CwX = getIntent().getIntExtra("page_scene", 0);
    this.fromScene = getIntent().getIntExtra("from_scene", 0);
    com.tencent.mm.plugin.report.service.h.wUl.f(14217, new Object[] { str6, Integer.valueOf(1), str9, str2, Integer.valueOf(this.fromScene) });
    this.oIR = bs.getInt(paramBundle, 1);
    paramBundle = (Bundle)localObject;
    if (bs.isNullOrNil((String)localObject)) {
      paramBundle = bs.nullAsNil(str1);
    }
    if (!bs.isNullOrNil(paramBundle))
    {
      localTextView.setText(paramBundle);
      localTextView.setVisibility(0);
    }
    if (l > 0L)
    {
      this.CwV = bs.An(l);
      this.CwW.setText(this.CwV);
      this.CwS.setText(getString(2131766082, new Object[] { this.CwV }));
    }
    paramBundle = o.aFB();
    localObject = new c.a();
    ((c.a)localObject).hKI = 2131691436;
    ((c.a)localObject).hKx = true;
    paramBundle.a(str8, localImageView, ((c.a)localObject).aFT());
    this.CwS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79806);
        ac.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[] { WebViewDownloadUI.a(WebViewDownloadUI.this) });
        switch (WebViewDownloadUI.5.Cxd[WebViewDownloadUI.a(WebViewDownloadUI.this).ordinal()])
        {
        default: 
          ac.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
          AppMethodBeat.o(79806);
          return;
        }
        if (!ax.isNetworkConnected(WebViewDownloadUI.b(WebViewDownloadUI.this)))
        {
          Toast.makeText(WebViewDownloadUI.b(WebViewDownloadUI.this), WebViewDownloadUI.this.getString(2131759864), 0).show();
          ac.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
          AppMethodBeat.o(79806);
          return;
        }
        if (ax.isWifi(WebViewDownloadUI.b(WebViewDownloadUI.this)))
        {
          WebViewDownloadUI.a(WebViewDownloadUI.this, str2, str4, str5, str6, str3, str9, str1, str7, i);
          AppMethodBeat.o(79806);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(14217, new Object[] { str6, Integer.valueOf(4), str9, str2, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
        com.tencent.mm.ui.base.h.a(WebViewDownloadUI.this, WebViewDownloadUI.this.getString(2131766086), WebViewDownloadUI.this.getString(2131766087), WebViewDownloadUI.this.getString(2131766081), WebViewDownloadUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(79804);
            com.tencent.mm.plugin.report.service.h.wUl.f(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(5), WebViewDownloadUI.2.this.Cnl, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
            WebViewDownloadUI.a(WebViewDownloadUI.this, WebViewDownloadUI.2.this.val$url, WebViewDownloadUI.2.this.laP, WebViewDownloadUI.2.this.jXY, WebViewDownloadUI.2.this.val$appId, WebViewDownloadUI.2.this.Cxa, WebViewDownloadUI.2.this.Cnl, WebViewDownloadUI.2.this.jYm, WebViewDownloadUI.2.this.cro, WebViewDownloadUI.2.this.Cxb);
            paramAnonymous2DialogInterface.dismiss();
            AppMethodBeat.o(79804);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(79805);
            com.tencent.mm.plugin.report.service.h.wUl.f(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(6), WebViewDownloadUI.2.this.Cnl, WebViewDownloadUI.2.this.val$url, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
            paramAnonymous2DialogInterface.dismiss();
            AppMethodBeat.o(79805);
          }
        }, 2131101171);
        AppMethodBeat.o(79806);
      }
    });
    this.CwT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79807);
        ac.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[] { Long.valueOf(WebViewDownloadUI.d(WebViewDownloadUI.this)), WebViewDownloadUI.a(WebViewDownloadUI.this) });
        com.tencent.mm.plugin.report.service.h.wUl.f(14217, new Object[] { str6, Integer.valueOf(3), str9, str2, Integer.valueOf(WebViewDownloadUI.c(WebViewDownloadUI.this)) });
        if (WebViewDownloadUI.d(WebViewDownloadUI.this) <= 0L) {
          ac.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
        }
        int i;
        do
        {
          Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766083), 1).show();
          AppMethodBeat.o(79807);
          return;
          i = f.bXJ().rS(WebViewDownloadUI.d(WebViewDownloadUI.this));
          ac.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[] { Integer.valueOf(i) });
        } while (i <= 0);
        Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(2131766084), 1).show();
        WebViewDownloadUI.this.finish();
        AppMethodBeat.o(79807);
      }
    });
    f.bXJ();
    c.a(this.CwY);
    AppMethodBeat.o(79819);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79820);
    super.onDestroy();
    ac.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[] { Boolean.valueOf(this.Cqx) });
    if (!this.Cqx)
    {
      com.tencent.mm.g.a.h localh = new com.tencent.mm.g.a.h();
      localh.cYs.cYt = true;
      localh.cYs.scene = this.CwX;
      com.tencent.mm.sdk.b.a.GpY.l(localh);
      this.Cqx = true;
    }
    f.bXJ();
    c.b(this.CwY);
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
      Cxe = new a("TO_DOWNLOAD", 0);
      Cxf = new a("DOWNLOADING", 1);
      Cxg = new a[] { Cxe, Cxf };
      AppMethodBeat.o(79817);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI
 * JD-Core Version:    0.7.0.1
 */