package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class g
  extends h
{
  public g(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37062);
    WebView localWebView;
    Object localObject;
    String str1;
    if ((ac)crb() != null)
    {
      localWebView = (WebView)getView();
      localObject = (ac)crb();
      if ((TextUtils.isEmpty(((ac)localObject).url)) || (TextUtils.isEmpty(crc().cFe))) {
        break label182;
      }
      String str2 = AdLandingPagesProxy.getInstance().getUin();
      str1 = ae.m(((ac)localObject).url, new String[] { "uxinfo=" + crc().cFe, "uin=".concat(String.valueOf(str2)) });
      if (((ac)localObject).subType != 1) {
        break label190;
      }
      localObject = AdLandingPagesProxy.getInstance().getAdVoteInfo(((ac)localObject).url, crc().cFe, str2);
      if (bo.isNullOrNil((String)localObject)) {
        break label190;
      }
      str1 = str1 + "&" + (String)localObject;
    }
    label182:
    label190:
    for (;;)
    {
      localWebView.loadUrl(str1);
      AppMethodBeat.o(37062);
      return;
      str1 = ((ac)localObject).url;
    }
  }
  
  protected final void cqQ()
  {
    AppMethodBeat.i(37063);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.rve.paddingLeft, (int)this.rve.paddingTop, (int)this.rve.paddingRight, (int)this.rve.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37063);
  }
  
  protected final View cqR()
  {
    AppMethodBeat.i(37064);
    MMWebView localMMWebView = f.a.vsl.dz(this.context);
    localMMWebView.getSettings().dYu();
    localMMWebView.getSettings().dYy();
    localMMWebView.getSettings().dYx();
    localMMWebView.setWebViewClient(c.a.vsk.a(localMMWebView, false, new g.1(this)));
    AppMethodBeat.o(37064);
    return localMMWebView;
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37065);
    super.cqz();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.contentView = null;
    AppMethodBeat.o(37065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g
 * JD-Core Version:    0.7.0.1
 */