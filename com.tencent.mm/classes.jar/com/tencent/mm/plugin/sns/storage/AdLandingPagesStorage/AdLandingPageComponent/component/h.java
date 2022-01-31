package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;

public final class h
  extends a
{
  public h(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  public final void bES()
  {
    super.bES();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.contentView = null;
  }
  
  protected final void bFj()
  {
    WebView localWebView;
    Object localObject;
    String str1;
    if ((x)bFe() != null)
    {
      localWebView = (WebView)getView();
      localObject = (x)bFe();
      if ((TextUtils.isEmpty(((x)localObject).url)) || (TextUtils.isEmpty(((x)localObject).ovV))) {
        break label170;
      }
      String str2 = AdLandingPagesProxy.getInstance().getUin();
      str1 = ad.k(((x)localObject).url, new String[] { "uxinfo=" + ((x)localObject).ovV, "uin=" + str2 });
      if (((x)localObject).brC != 1) {
        break label178;
      }
      localObject = AdLandingPagesProxy.getInstance().getAdVoteInfo(((x)localObject).url, ((x)localObject).ovV, str2);
      if (bk.bl((String)localObject)) {
        break label178;
      }
      str1 = str1 + "&" + (String)localObject;
    }
    label170:
    label178:
    for (;;)
    {
      localWebView.loadUrl(str1);
      return;
      str1 = ((x)localObject).url;
    }
  }
  
  protected final View bFk()
  {
    MMWebView localMMWebView = f.a.rBZ.cO(this.context);
    localMMWebView.getSettings().cSp();
    localMMWebView.getSettings().cSt();
    localMMWebView.getSettings().cSs();
    localMMWebView.setWebViewClient(c.a.rBY.a(localMMWebView, false, new d()
    {
      public final boolean b(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return false;
        }
        x localx = (x)h.this.bFe();
        paramAnonymousInt = paramAnonymousBundle.getInt("sns_landing_pages_ad_vote_index");
        AdLandingPagesProxy.getInstance().saveAdVoteInfo(localx.url, localx.ovV, localx.uin, paramAnonymousInt, 0);
        return false;
      }
    }));
    return localMMWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h
 * JD-Core Version:    0.7.0.1
 */