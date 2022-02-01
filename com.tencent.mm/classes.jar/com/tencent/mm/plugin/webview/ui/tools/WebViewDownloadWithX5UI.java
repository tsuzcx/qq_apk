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
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@com.tencent.mm.ui.base.a(2)
public class WebViewDownloadWithX5UI
  extends MMActivity
{
  private Button JfK;
  private final com.tencent.mm.plugin.webview.modeltools.a JfY;
  private Context mContext;
  
  public WebViewDownloadWithX5UI()
  {
    AppMethodBeat.i(79828);
    this.JfY = new com.tencent.mm.plugin.webview.modeltools.a();
    AppMethodBeat.o(79828);
  }
  
  public int getLayoutId()
  {
    return 2131497068;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79831);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.JfY.d(this, paramInt1, paramInt2, paramIntent))
    {
      if (-1 == paramInt2) {
        finish();
      }
      AppMethodBeat.o(79831);
      return;
    }
    AppMethodBeat.o(79831);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79829);
    super.onCreate(paramBundle);
    this.mContext = this;
    setMMTitle(getString(2131768557));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(79823);
        WebViewDownloadWithX5UI.this.finish();
        AppMethodBeat.o(79823);
        return true;
      }
    });
    overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
    this.JfK = ((Button)findViewById(2131299772));
    paramBundle = (ImageView)findViewById(2131299787);
    TextView localTextView = (TextView)findViewById(2131299789);
    String str1 = getIntent().getStringExtra("task_url");
    String str2 = getIntent().getStringExtra("title");
    final long l = getIntent().getLongExtra("task_size", 0L);
    final String str3 = getIntent().getStringExtra("page_url");
    String str4 = getIntent().getStringExtra("thumb_url");
    Log.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", new Object[] { str1, Long.valueOf(l), str4 });
    Object localObject;
    if (l > 0L)
    {
      localObject = Util.getSizeMB(l);
      this.JfK.setText(getString(2131768548, new Object[] { localObject }));
    }
    if (g.aAc())
    {
      localObject = q.bcV();
      c.a locala = new c.a();
      locala.jbq = 2131691774;
      locala.jbf = true;
      ((com.tencent.mm.av.a.a)localObject).a(str4, paramBundle, locala.bdv());
      localTextView.setVisibility(0);
      if (Util.isNullOrNil(str2)) {
        break label353;
      }
      localTextView.setText(str2);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { "", Integer.valueOf(1), str3, str1, Integer.valueOf(1) });
      this.JfK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79826);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!NetStatusUtil.isNetworkConnected(WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this)))
          {
            Toast.makeText(WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this), WebViewDownloadWithX5UI.this.getString(2131761199), 0).show();
            Log.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79826);
            return;
          }
          if (!g.aAh().isSDCardAvailable())
          {
            Toast.makeText(WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this), WebViewDownloadWithX5UI.this.getString(2131761203), 0).show();
            Log.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79826);
            return;
          }
          if ((l > 0L) && (!com.tencent.mm.compatible.util.e.yV(l)))
          {
            Toast.makeText(WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this), WebViewDownloadWithX5UI.this.getString(2131761200), 0).show();
            Log.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + l);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79826);
            return;
          }
          if (NetStatusUtil.isWifi(WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this))) {
            WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this, str3, this.xxn);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79826);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { "", Integer.valueOf(4), this.xxn, str3, Integer.valueOf(1) });
            com.tencent.mm.ui.base.h.a(WebViewDownloadWithX5UI.this, WebViewDownloadWithX5UI.this.getString(2131768552), WebViewDownloadWithX5UI.this.getString(2131768553), WebViewDownloadWithX5UI.this.getString(2131768547), WebViewDownloadWithX5UI.this.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(79824);
                com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { "", Integer.valueOf(5), WebViewDownloadWithX5UI.2.this.xxn, WebViewDownloadWithX5UI.2.this.val$url, Integer.valueOf(1) });
                WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this, WebViewDownloadWithX5UI.2.this.val$url, WebViewDownloadWithX5UI.2.this.xxn);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(79824);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(79825);
                com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { "", Integer.valueOf(6), WebViewDownloadWithX5UI.2.this.xxn, WebViewDownloadWithX5UI.2.this.val$url, Integer.valueOf(1) });
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(79825);
              }
            }, 2131101414);
          }
        }
      });
      AppMethodBeat.o(79829);
      return;
      paramBundle.setImageResource(2131691774);
      break;
      label353:
      localTextView.setText(getString(2131768556));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79830);
    super.onDestroy();
    AppMethodBeat.o(79830);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(79832);
    if (Util.isEqual(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      r.l(MMApplicationContext.getContext(), paramIntent.getData());
      AppMethodBeat.o(79832);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(79832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI
 * JD-Core Version:    0.7.0.1
 */