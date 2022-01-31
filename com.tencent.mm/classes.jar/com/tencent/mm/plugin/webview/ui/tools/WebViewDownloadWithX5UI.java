package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@com.tencent.mm.ui.base.a(2)
public class WebViewDownloadWithX5UI
  extends MMActivity
{
  private Context mContext;
  private final com.tencent.mm.plugin.webview.modeltools.a rmM = new com.tencent.mm.plugin.webview.modeltools.a();
  private Button rmx;
  
  protected final int getLayoutId()
  {
    return R.i.webview_download_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((com.tencent.mm.plugin.webview.modeltools.a.c(this, paramInt1, paramInt2, paramIntent)) && (-1 == paramInt2)) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = this;
    setMMTitle(getString(R.l.webview_download_ui_title));
    setBackBtn(new WebViewDownloadWithX5UI.1(this));
    overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
    this.rmx = ((Button)findViewById(R.h.download_op_btn));
    paramBundle = (ImageView)findViewById(R.h.download_thumb);
    TextView localTextView = (TextView)findViewById(R.h.download_title);
    String str1 = getIntent().getStringExtra("task_url");
    String str2 = getIntent().getStringExtra("title");
    long l = getIntent().getLongExtra("task_size", 0L);
    String str3 = getIntent().getStringExtra("page_url");
    String str4 = getIntent().getStringExtra("thumb_url");
    y.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", new Object[] { str1, Long.valueOf(l), str4 });
    Object localObject;
    if (l > 0L)
    {
      localObject = bk.ht(l);
      this.rmx.setText(getString(R.l.webview_download_ui_btn_state_to_download_size, new Object[] { localObject }));
    }
    if (au.DK())
    {
      localObject = o.ON();
      c.a locala = new c.a();
      locala.eru = R.k.webview_download_thumb_unknown;
      locala.erf = true;
      ((com.tencent.mm.as.a.a)localObject).a(str4, paramBundle, locala.OV());
      localTextView.setVisibility(0);
      if (bk.bl(str2)) {
        break label345;
      }
      localTextView.setText(str2);
    }
    for (;;)
    {
      h.nFQ.f(14217, new Object[] { "", Integer.valueOf(1), str3, str1, Integer.valueOf(1) });
      this.rmx.setOnClickListener(new WebViewDownloadWithX5UI.2(this, l, str1, str3));
      return;
      paramBundle.setImageResource(R.k.webview_download_thumb_unknown);
      break;
      label345:
      localTextView.setText(getString(R.l.webview_download_ui_downloading_unknown_title));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI
 * JD-Core Version:    0.7.0.1
 */