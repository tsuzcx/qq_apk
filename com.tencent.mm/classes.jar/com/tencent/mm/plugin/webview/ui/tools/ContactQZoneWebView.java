package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

public class ContactQZoneWebView
  extends WebViewUI
{
  private String mSy = "";
  private boolean rkD = false;
  private String rkE = "";
  
  final void SX(String paramString)
  {
    if (this.rkD) {
      return;
    }
    this.rkD = true;
    Object localObject = paramString.substring(19);
    y.d("MicroMsg.ContactQZoneWebView", "get url :" + (String)localObject);
    paramString = new Intent();
    paramString.putExtra("nowUrl", (String)localObject);
    paramString.putExtra("tweetid", bk.pm(getIntent().getStringExtra("tweetid")));
    paramString.putExtra("htmlData", this.rkE);
    paramString.putExtra("type", getIntent().getIntExtra("type", 0));
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 4);
    ((Bundle)localObject).putString("stat_url", cdR());
    paramString.putExtra("_stat_obj", (Bundle)localObject);
    startActivity(paramString);
    a.eUR.r(paramString, this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(getString(R.l.contact_info_qq_view_qzone));
    this.niQ.setWebViewClient(new ContactQZoneWebView.1(this));
    this.niQ.loadUrl(this.caS);
    y.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.caS);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.rkD = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.ContactQZoneWebView
 * JD-Core Version:    0.7.0.1
 */