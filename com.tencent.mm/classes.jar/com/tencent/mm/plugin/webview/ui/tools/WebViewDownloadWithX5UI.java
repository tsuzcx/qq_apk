package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@com.tencent.mm.ui.base.a(2)
public class WebViewDownloadWithX5UI
  extends MMActivity
{
  private Context mContext;
  private Button vce;
  private final com.tencent.mm.plugin.webview.modeltools.a vct;
  
  public WebViewDownloadWithX5UI()
  {
    AppMethodBeat.i(7617);
    this.vct = new com.tencent.mm.plugin.webview.modeltools.a();
    AppMethodBeat.o(7617);
  }
  
  public int getLayoutId()
  {
    return 2130971301;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(7620);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.webview.modeltools.a.d(this, paramInt1, paramInt2, paramIntent))
    {
      if (-1 == paramInt2) {
        finish();
      }
      AppMethodBeat.o(7620);
      return;
    }
    AppMethodBeat.o(7620);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7618);
    super.onCreate(paramBundle);
    this.mContext = this;
    setMMTitle(getString(2131305857));
    setBackBtn(new WebViewDownloadWithX5UI.1(this));
    overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    this.vce = ((Button)findViewById(2131829534));
    paramBundle = (ImageView)findViewById(2131829531);
    TextView localTextView = (TextView)findViewById(2131829532);
    String str1 = getIntent().getStringExtra("task_url");
    String str2 = getIntent().getStringExtra("title");
    long l = getIntent().getLongExtra("task_size", 0L);
    String str3 = getIntent().getStringExtra("page_url");
    String str4 = getIntent().getStringExtra("thumb_url");
    ab.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", new Object[] { str1, Long.valueOf(l), str4 });
    Object localObject;
    if (l > 0L)
    {
      localObject = bo.nV(l);
      this.vce.setText(getString(2131305848, new Object[] { localObject }));
    }
    if (g.RG())
    {
      localObject = o.ahG();
      c.a locala = new c.a();
      locala.eNY = 2131232229;
      locala.eNM = true;
      ((com.tencent.mm.at.a.a)localObject).a(str4, paramBundle, locala.ahY());
      localTextView.setVisibility(0);
      if (bo.isNullOrNil(str2)) {
        break label353;
      }
      localTextView.setText(str2);
    }
    for (;;)
    {
      h.qsU.e(14217, new Object[] { "", Integer.valueOf(1), str3, str1, Integer.valueOf(1) });
      this.vce.setOnClickListener(new WebViewDownloadWithX5UI.2(this, l, str1, str3));
      AppMethodBeat.o(7618);
      return;
      paramBundle.setImageResource(2131232229);
      break;
      label353:
      localTextView.setText(getString(2131305856));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7619);
    super.onDestroy();
    AppMethodBeat.o(7619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(7621);
    if (bo.isEqual(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      q.a(ah.getContext(), paramIntent.getData(), null);
      AppMethodBeat.o(7621);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(7621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI
 * JD-Core Version:    0.7.0.1
 */