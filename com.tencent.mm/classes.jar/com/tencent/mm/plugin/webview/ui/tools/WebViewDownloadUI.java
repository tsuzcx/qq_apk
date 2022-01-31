package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

public class WebViewDownloadUI
  extends MMActivity
{
  private long hyK;
  private TextView kRB;
  private int kYE;
  private Context mContext;
  private boolean uWa;
  private Button vce;
  private TextView vcf;
  private a vcg;
  private String vch;
  private TextView vci;
  private int vcj;
  private m vck;
  
  public WebViewDownloadUI()
  {
    AppMethodBeat.i(7607);
    this.vck = new WebViewDownloadUI.4(this);
    AppMethodBeat.o(7607);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(7610);
    ab.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[] { this.vcg, parama });
    this.vcg = parama;
    switch (WebViewDownloadUI.5.vcp[this.vcg.ordinal()])
    {
    default: 
      AppMethodBeat.o(7610);
      return;
    case 1: 
      this.vce.setVisibility(0);
      this.kRB.setVisibility(8);
      this.vcf.setVisibility(8);
    }
    do
    {
      this.vci.setVisibility(8);
      break;
      this.vce.setVisibility(8);
      this.vcf.setVisibility(0);
      this.kRB.setVisibility(0);
    } while (bo.isNullOrNil(this.vch));
    this.vci.setVisibility(0);
    AppMethodBeat.o(7610);
  }
  
  public int getLayoutId()
  {
    return 2130971301;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7608);
    super.onCreate(paramBundle);
    this.mContext = this;
    setMMTitle(getString(2131305857));
    setBackBtn(new WebViewDownloadUI.1(this));
    overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    this.vce = ((Button)findViewById(2131829534));
    this.vcf = ((TextView)findViewById(2131829536));
    TextView localTextView = (TextView)findViewById(2131829532);
    this.vci = ((TextView)findViewById(2131829533));
    ImageView localImageView = (ImageView)findViewById(2131829531);
    this.kRB = ((TextView)findViewById(2131829535));
    a(a.vcq);
    String str1 = getIntent().getStringExtra("task_name");
    String str2 = getIntent().getStringExtra("task_url");
    String str3 = getIntent().getStringExtra("alternative_url");
    long l = getIntent().getLongExtra("task_size", 0L);
    String str4 = getIntent().getStringExtra("file_md5");
    String str5 = getIntent().getStringExtra("extInfo");
    paramBundle = getIntent().getStringExtra("fileType");
    String str6 = getIntent().getStringExtra("appid");
    String str7 = getIntent().getStringExtra("package_name");
    String str8 = getIntent().getStringExtra("thumb_url");
    Object localObject = getIntent().getStringExtra("title");
    String str9 = getIntent().getStringExtra("page_url");
    int i = getIntent().getIntExtra("task_scene", 0);
    this.vcj = getIntent().getIntExtra("page_scene", 0);
    com.tencent.mm.plugin.report.service.h.qsU.e(14217, new Object[] { str6, Integer.valueOf(1), str9, str2, Integer.valueOf(0) });
    this.kYE = bo.getInt(paramBundle, 1);
    paramBundle = (Bundle)localObject;
    if (bo.isNullOrNil((String)localObject)) {
      paramBundle = bo.nullAsNil(str1);
    }
    if (!bo.isNullOrNil(paramBundle))
    {
      localTextView.setText(paramBundle);
      localTextView.setVisibility(0);
    }
    if (l > 0L)
    {
      this.vch = bo.nV(l);
      this.vci.setText(this.vch);
      this.vce.setText(getString(2131305848, new Object[] { this.vch }));
    }
    paramBundle = o.ahG();
    localObject = new c.a();
    ((c.a)localObject).eNY = 2131232229;
    ((c.a)localObject).eNM = true;
    paramBundle.a(str8, localImageView, ((c.a)localObject).ahY());
    this.vce.setOnClickListener(new WebViewDownloadUI.2(this, str2, str4, str5, str6, str3, str9, str1, str7, i));
    this.vcf.setOnClickListener(new WebViewDownloadUI.3(this, str6, str9, str2));
    f.bjl();
    c.a(this.vck);
    AppMethodBeat.o(7608);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7609);
    super.onDestroy();
    ab.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[] { Boolean.valueOf(this.uWa) });
    if (!this.uWa)
    {
      com.tencent.mm.g.a.h localh = new com.tencent.mm.g.a.h();
      localh.cmk.cml = true;
      localh.cmk.scene = this.vcj;
      com.tencent.mm.sdk.b.a.ymk.l(localh);
      this.uWa = true;
    }
    f.bjl();
    c.b(this.vck);
    AppMethodBeat.o(7609);
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
      AppMethodBeat.i(7606);
      vcq = new a("TO_DOWNLOAD", 0);
      vcr = new a("DOWNLOADING", 1);
      vcs = new a[] { vcq, vcr };
      AppMethodBeat.o(7606);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI
 * JD-Core Version:    0.7.0.1
 */