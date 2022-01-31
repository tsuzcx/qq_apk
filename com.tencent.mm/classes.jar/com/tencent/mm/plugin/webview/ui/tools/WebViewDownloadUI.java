package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

public class WebViewDownloadUI
  extends MMActivity
{
  private long ghp;
  private k hXU = new WebViewDownloadUI.4(this);
  private TextView iKV;
  private int iPx;
  private Context mContext;
  private boolean rfN;
  private String rmA;
  private TextView rmB;
  private int rmC;
  private Button rmx;
  private TextView rmy;
  private WebViewDownloadUI.a rmz;
  
  private void a(WebViewDownloadUI.a parama)
  {
    y.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[] { this.rmz, parama });
    this.rmz = parama;
    switch (WebViewDownloadUI.5.rmI[this.rmz.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.rmx.setVisibility(0);
      this.iKV.setVisibility(8);
      this.rmy.setVisibility(8);
    }
    do
    {
      this.rmB.setVisibility(8);
      return;
      this.rmx.setVisibility(8);
      this.rmy.setVisibility(0);
      this.iKV.setVisibility(0);
    } while (bk.bl(this.rmA));
    this.rmB.setVisibility(0);
  }
  
  protected final int getLayoutId()
  {
    return R.i.webview_download_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = this;
    setMMTitle(getString(R.l.webview_download_ui_title));
    setBackBtn(new WebViewDownloadUI.1(this));
    overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
    this.rmx = ((Button)findViewById(R.h.download_op_btn));
    this.rmy = ((TextView)findViewById(R.h.download_cancel_btn));
    TextView localTextView = (TextView)findViewById(R.h.download_title);
    this.rmB = ((TextView)findViewById(R.h.download_size));
    ImageView localImageView = (ImageView)findViewById(R.h.download_thumb);
    this.iKV = ((TextView)findViewById(R.h.download_tips));
    a(WebViewDownloadUI.a.rmJ);
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
    this.rmC = getIntent().getIntExtra("page_scene", 0);
    com.tencent.mm.plugin.report.service.h.nFQ.f(14217, new Object[] { str6, Integer.valueOf(1), str9, str2, Integer.valueOf(0) });
    this.iPx = bk.getInt(paramBundle, 1);
    paramBundle = (Bundle)localObject;
    if (bk.bl((String)localObject)) {
      paramBundle = bk.pm(str1);
    }
    if (!bk.bl(paramBundle))
    {
      localTextView.setText(paramBundle);
      localTextView.setVisibility(0);
    }
    if (l > 0L)
    {
      this.rmA = bk.ht(l);
      this.rmB.setText(this.rmA);
      this.rmx.setText(getString(R.l.webview_download_ui_btn_state_to_download_size, new Object[] { this.rmA }));
    }
    paramBundle = o.ON();
    localObject = new c.a();
    ((c.a)localObject).eru = R.k.webview_download_thumb_unknown;
    ((c.a)localObject).erf = true;
    paramBundle.a(str8, localImageView, ((c.a)localObject).OV());
    this.rmx.setOnClickListener(new WebViewDownloadUI.2(this, str2, str4, str5, str6, str3, str9, str1, str7));
    this.rmy.setOnClickListener(new WebViewDownloadUI.3(this, str6, str9, str2));
    d.aFP();
    b.a(this.hXU);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[] { Boolean.valueOf(this.rfN) });
    if (!this.rfN)
    {
      com.tencent.mm.h.a.h localh = new com.tencent.mm.h.a.h();
      localh.bEZ.bFa = true;
      localh.bEZ.scene = this.rmC;
      com.tencent.mm.sdk.b.a.udP.m(localh);
      this.rfN = true;
    }
    d.aFP();
    b.b(this.hXU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI
 * JD-Core Version:    0.7.0.1
 */