package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.y;
import java.io.OutputStream;
import org.json.JSONObject;

public final class i
  extends k
{
  g wZQ = null;
  
  public i(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
  }
  
  public final void apu(String paramString)
  {
    AppMethodBeat.i(176278);
    final String str;
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "handleJSAPI, params=".concat(String.valueOf(paramString)));
      paramString = new JSONObject(paramString);
      str = paramString.optString("funcName");
      if ("opUpdateContentHeight".equals(str))
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176275);
            if ((i.this.contentView != null) && (this.wZS >= 0)) {
              try
              {
                ViewGroup.LayoutParams localLayoutParams = i.this.contentView.getLayoutParams();
                int i = (int)com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.wZS, 1, 750, 1);
                com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "adJuestHeight, curH=" + localLayoutParams.height + ", newH=" + this.wZS + ", newPx=" + i);
                if (localLayoutParams.height != i)
                {
                  ((ai)i.this.dwh()).wWH = i;
                  i.this.dwf();
                }
                AppMethodBeat.o(176275);
                return;
              }
              catch (Exception localException)
              {
                com.tencent.mm.sdk.platformtools.ad.e("AdLandingNewH5Comp", "adJuestHeight exp=" + localException.toString());
              }
            }
            AppMethodBeat.o(176275);
          }
        });
        AppMethodBeat.o(176278);
        return;
      }
      if ("opStartQRScan".equals(str))
      {
        paramString.getString("scanUrl");
        AppMethodBeat.o(176278);
        return;
      }
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingNewH5Comp", "handleJSAPI, exp=" + paramString.toString());
      AppMethodBeat.o(176278);
      return;
    }
    if ("opEndQRScan".equals(str)) {
      str = paramString.getString("scanUrl");
    }
    Object localObject;
    for (;;)
    {
      try
      {
        if (this.wZQ == null)
        {
          localObject = new Bundle();
          paramString = (ai)dwh();
          if (paramString == null) {
            break label281;
          }
          paramString = paramString.wWr;
          ((Bundle)localObject).putString("qrExtInfo", paramString);
          this.wZQ = new g(this.context, dwi(), 2, (Bundle)localObject);
        }
        paramString = h.iU("adId", str);
        if ((TextUtils.isEmpty(paramString)) || (!com.tencent.mm.vfs.i.eK(paramString))) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "local file exists, imageUrl=".concat(String.valueOf(str)));
        this.wZQ.iw(paramString, str);
        AppMethodBeat.o(176278);
        return;
      }
      catch (Throwable paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingNewH5Comp", "handleQR, exp=" + paramString.toString());
      }
      AppMethodBeat.o(176278);
      return;
      label281:
      paramString = "";
    }
    paramString = com.tencent.mm.sdk.platformtools.f.fy(this.contentView);
    if (paramString != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "shoot webView succ");
      localObject = h.iU("adId", str + "_shoot");
      OutputStream localOutputStream = com.tencent.mm.vfs.i.ai(new e((String)localObject));
      boolean bool = paramString.compress(Bitmap.CompressFormat.JPEG, 100, localOutputStream);
      localOutputStream.flush();
      localOutputStream.close();
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "shoot save succ");
        this.wZQ.iw((String)localObject, str);
      }
    }
    h.a(str, ((ai)dwh()).wWF, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
    {
      public final void apm(String paramAnonymousString)
      {
        AppMethodBeat.i(176277);
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "onDownloaded, imageUrl=" + str);
        AppMethodBeat.o(176277);
      }
      
      public final void dsA()
      {
        AppMethodBeat.i(176276);
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + str);
        AppMethodBeat.o(176276);
      }
      
      public final void duP() {}
    });
    AppMethodBeat.o(176278);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96462);
    WebView localWebView;
    Object localObject;
    String str1;
    if ((ai)dwh() != null)
    {
      localWebView = (WebView)getView();
      localObject = (ai)dwh();
      if (TextUtils.isEmpty(((ai)localObject).url)) {
        break label192;
      }
      str1 = "uxinfo=" + dwi().dvK;
      String str2 = AdLandingPagesProxy.getInstance().getUin();
      String str3 = "uin=".concat(String.valueOf(str2));
      str1 = al.n(((ai)localObject).url, new String[] { str1, str3 });
      if (((ai)localObject).subType != 1) {
        break label200;
      }
      localObject = AdLandingPagesProxy.getInstance().getAdVoteInfo(((ai)localObject).url, dwi().dvK, str2);
      if (bt.isNullOrNil((String)localObject)) {
        break label200;
      }
      str1 = str1 + "&" + (String)localObject;
    }
    label192:
    label200:
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "final url=".concat(String.valueOf(str1)));
      for (;;)
      {
        localWebView.loadUrl(str1);
        AppMethodBeat.o(96462);
        return;
        str1 = ((ai)localObject).url;
      }
    }
  }
  
  protected final View dvQ()
  {
    AppMethodBeat.i(96464);
    MMWebView localMMWebView = com.tencent.mm.plugin.webview.ui.tools.widget.f.a.Bud.eg(this.context);
    localMMWebView.getSettings().frd();
    localMMWebView.getSettings().frh();
    localMMWebView.getSettings().frg();
    localMMWebView.setWebViewClient(c.a.Buc.a(localMMWebView, false, new com.tencent.mm.plugin.webview.ui.tools.widget.d()
    {
      public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(96461);
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "callback, actionCode=".concat(String.valueOf(paramAnonymousInt)));
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(96461);
          return false;
          Object localObject = (ai)i.this.dwh();
          paramAnonymousInt = paramAnonymousBundle.getInt("sns_landing_pages_ad_vote_index");
          paramAnonymousBundle = paramAnonymousBundle.getString("sns_landing_pages_ad_vote_result");
          AdLandingPagesProxy.getInstance().saveAdVoteInfo(((ai)localObject).url, i.this.dwi().dvK, i.this.dwi().uin, paramAnonymousInt, 0, paramAnonymousBundle);
          continue;
          for (;;)
          {
            try
            {
              localObject = new Intent();
              String str = al.n(paramAnonymousBundle.getString("sns_landing_pages_ad_jumpurl"), new String[] { "traceid=" + i.this.dwi().iYE, "aid=" + i.this.dwi().wSi });
              paramAnonymousBundle = i.this.dwi().wXl;
              if (!TextUtils.isEmpty(paramAnonymousBundle)) {
                break label347;
              }
              paramAnonymousBundle = i.this.dwi().dvK;
              com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "use orig_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
              str = q.iy(str, paramAnonymousBundle);
              q.g((Intent)localObject, paramAnonymousBundle);
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("useJs", true);
              ((Intent)localObject).putExtra("type", -255);
              ((Intent)localObject).putExtra("geta8key_scene", 2);
              com.tencent.mm.bs.d.b(i.this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "jumpUrl, finalUrl=".concat(String.valueOf(str)));
            }
            catch (Exception paramAnonymousBundle)
            {
              com.tencent.mm.sdk.platformtools.ad.e("AdLandingNewH5Comp", "OptJump exp=" + paramAnonymousBundle.toString());
            }
            break;
            label347:
            com.tencent.mm.sdk.platformtools.ad.i("AdLandingNewH5Comp", "use updated_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
          }
          paramAnonymousBundle = paramAnonymousBundle.getString("sns_landing_pages_h5_params");
          i.this.apu(paramAnonymousBundle);
        }
      }
    }));
    AppMethodBeat.o(96464);
    return localMMWebView;
  }
  
  protected final void dvT()
  {
    AppMethodBeat.i(96463);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.xab.paddingLeft, (int)this.xab.paddingTop, (int)this.xab.paddingRight, (int)this.xab.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96463);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96465);
    super.dvy();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.contentView = null;
    AppMethodBeat.o(96465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */