package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.a.d;
import java.io.UnsupportedEncodingException;

public final class a
{
  public String appId = "";
  Context context;
  d gSO;
  public boolean hCQ;
  public WxaExposedParams hdB = new WxaExposedParams.a().aes();
  public int scene;
  a.h uRH;
  public String uRI = "";
  public String username;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static String aq(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[] { q.encode(bk.pm(paramString1), "UTF-8"), q.encode(bk.pm(paramString2), "UTF-8"), Integer.valueOf(10), q.encode(bk.pm(paramString3), "UTF-8") });
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      y.e("MicroMsg.AppBrandSerivceActionSheet", "buildExposeUrl encode fail, invalid arguments");
    }
    return "";
  }
  
  final void fn(int paramInt1, int paramInt2)
  {
    if (bk.bl(getAppId())) {
      return;
    }
    y.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.uRI, Integer.valueOf(paramInt2) });
    h.nFQ.f(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.uRI, Integer.valueOf(paramInt2), Long.valueOf(bk.UX()) });
  }
  
  final String getAppId()
  {
    if (bk.bl(this.username)) {
      return null;
    }
    if (bk.bl(this.appId))
    {
      WxaAttributes localWxaAttributes = ((c)g.r(c.class)).so(this.username);
      if (localWxaAttributes != null) {
        this.appId = localWxaAttributes.field_appId;
      }
    }
    return this.appId;
  }
  
  public final void show(int paramInt)
  {
    this.gSO = new d(this.context, 1, true);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.uRH = new a.a(this);
      if (this.uRH == null) {
        y.e("MicroMsg.AppBrandSerivceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.gSO.phH = new a.2(this);
      this.gSO.phI = new a.1(this);
      this.gSO.cfU();
      return;
      this.uRH = new a.b(this);
      break;
      this.uRH = new a.f(this);
      break;
      this.uRH = new a.g(this);
      break;
      this.uRH = new d();
      break;
      this.uRH = new a.e(this);
      break;
      View localView = this.uRH.cAl();
      if (localView != null) {
        this.gSO.ej(localView);
      }
    }
  }
  
  public final class d
    extends a.c
  {
    public d()
    {
      super();
    }
    
    public final void a(l paraml)
    {
      super.a(paraml);
      paraml.e(2, a.this.context.getString(R.l.app_brand_service_menu_receive_msg));
      paraml.e(8, a.this.context.getString(R.l.app_brand_service_menu_expose));
      paraml.e(7, a.a(a.this));
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */