package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

public class ContactQZoneWebView
  extends WebViewUI
{
  private String puE = "";
  private boolean uZZ = false;
  private String vaa = "";
  
  final void ahZ(String paramString)
  {
    AppMethodBeat.i(7352);
    if (this.uZZ)
    {
      AppMethodBeat.o(7352);
      return;
    }
    this.uZZ = true;
    Object localObject = paramString.substring(19);
    ab.d("MicroMsg.ContactQZoneWebView", "get url :".concat(String.valueOf(localObject)));
    paramString = new Intent();
    paramString.putExtra("nowUrl", (String)localObject);
    paramString.putExtra("tweetid", bo.nullAsNil(getIntent().getStringExtra("tweetid")));
    paramString.putExtra("htmlData", this.vaa);
    paramString.putExtra("type", getIntent().getIntExtra("type", 0));
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 4);
    ((Bundle)localObject).putString("stat_url", dek());
    paramString.putExtra("_stat_obj", (Bundle)localObject);
    startActivity(paramString);
    a.gmO.q(paramString, this);
    AppMethodBeat.o(7352);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7350);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131306014));
    this.pOd.setWebViewClient(new ContactQZoneWebView.1(this));
    this.pOd.loadUrl(this.cJr);
    ab.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.cJr);
    AppMethodBeat.o(7350);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7351);
    super.onResume();
    this.uZZ = false;
    AppMethodBeat.o(7351);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.ContactQZoneWebView
 * JD-Core Version:    0.7.0.1
 */