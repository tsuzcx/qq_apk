package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.b.d;
import java.io.UnsupportedEncodingException;

public final class a
{
  public String appId;
  Context context;
  public WxaExposedParams iOe;
  d iwc;
  public boolean jvs;
  public int scene;
  public String username;
  a.h zgi;
  public String zgj;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(29945);
    this.iOe = new WxaExposedParams.a().ayJ();
    this.appId = "";
    this.zgj = "";
    this.context = paramContext;
    AppMethodBeat.o(29945);
  }
  
  public static String aH(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(29949);
    try
    {
      paramString1 = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[] { q.encode(bo.nullAsNil(paramString1), "UTF-8"), q.encode(bo.nullAsNil(paramString2), "UTF-8"), Integer.valueOf(10), q.encode(bo.nullAsNil(paramString3), "UTF-8") });
      AppMethodBeat.o(29949);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      ab.e("MicroMsg.AppBrandServiceActionSheet", "buildExposeUrl encode fail, invalid arguments");
      AppMethodBeat.o(29949);
    }
    return "";
  }
  
  final String getAppId()
  {
    AppMethodBeat.i(29947);
    if (bo.isNullOrNil(this.username))
    {
      AppMethodBeat.o(29947);
      return null;
    }
    if (bo.isNullOrNil(this.appId))
    {
      localObject = ((i)g.E(i.class)).Ae(this.username);
      if (localObject != null) {
        this.appId = ((WxaAttributes)localObject).field_appId;
      }
    }
    Object localObject = this.appId;
    AppMethodBeat.o(29947);
    return localObject;
  }
  
  final void ht(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29948);
    if (bo.isNullOrNil(getAppId()))
    {
      AppMethodBeat.o(29948);
      return;
    }
    ab.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.zgj, Integer.valueOf(paramInt2) });
    h.qsU.e(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.zgj, Integer.valueOf(paramInt2), Long.valueOf(bo.aox()) });
    AppMethodBeat.o(29948);
  }
  
  public final void show(int paramInt)
  {
    AppMethodBeat.i(29946);
    this.iwc = new d(this.context, 1, true);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(29946);
      return;
    case 1: 
      this.zgi = new a();
      if (this.zgi == null) {
        ab.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.iwc.sao = new a.2(this);
      this.iwc.sap = new a.1(this);
      this.iwc.crd();
      AppMethodBeat.o(29946);
      return;
      this.zgi = new b();
      break;
      this.zgi = new a.f(this);
      break;
      this.zgi = new a.g(this);
      break;
      this.zgi = new d();
      break;
      this.zgi = new a.e(this);
      break;
      View localView = this.zgi.dDv();
      if (localView != null) {
        this.iwc.G(localView, false);
      }
    }
  }
  
  public final class a
    extends a.c
  {
    public a()
    {
      super();
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(29928);
      super.onCreateMMMenu(paraml);
      paraml.e(2, a.this.context.getString(2131296851));
      paraml.e(8, a.this.context.getString(2131296849));
      paraml.e(7, a.a(a.this));
      AppMethodBeat.o(29928);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(29929);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(29929);
    }
  }
  
  public final class b
    extends a.c
  {
    public b()
    {
      super();
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(29930);
      super.onCreateMMMenu(paraml);
      paraml.e(3, a.this.context.getString(2131296853));
      paraml.e(8, a.this.context.getString(2131296849));
      paraml.e(7, a.a(a.this));
      AppMethodBeat.o(29930);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(29931);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(29931);
    }
  }
  
  public final class d
    extends a.c
  {
    public d()
    {
      super();
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(29935);
      super.onCreateMMMenu(paraml);
      paraml.e(2, a.this.context.getString(2131296851));
      paraml.e(8, a.this.context.getString(2131296849));
      paraml.e(7, a.a(a.this));
      AppMethodBeat.o(29935);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(29936);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(29936);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */