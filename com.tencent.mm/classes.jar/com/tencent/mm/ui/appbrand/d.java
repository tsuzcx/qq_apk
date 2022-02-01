package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.y;
import java.io.UnsupportedEncodingException;

public final class d
{
  h FTN;
  public String FTO;
  public String appId;
  Context context;
  com.tencent.mm.ui.widget.a.e iIO;
  public WxaExposedParams lBG;
  public boolean mlE;
  public int scene;
  public String username;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(33802);
    this.lBG = new WxaExposedParams.a().aTV();
    this.appId = "";
    this.FTO = "";
    this.context = paramContext;
    AppMethodBeat.o(33802);
  }
  
  public static String aW(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(33806);
    try
    {
      paramString1 = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[] { p.encode(bt.nullAsNil(paramString1), "UTF-8"), p.encode(bt.nullAsNil(paramString2), "UTF-8"), Integer.valueOf(10), p.encode(bt.nullAsNil(paramString3), "UTF-8") });
      AppMethodBeat.o(33806);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      ad.e("MicroMsg.AppBrandServiceActionSheet", "buildExposeUrl encode fail, invalid arguments");
      AppMethodBeat.o(33806);
    }
    return "";
  }
  
  final String getAppId()
  {
    AppMethodBeat.i(33804);
    if (bt.isNullOrNil(this.username))
    {
      AppMethodBeat.o(33804);
      return null;
    }
    if (bt.isNullOrNil(this.appId))
    {
      localObject = ((m)g.ab(m.class)).FW(this.username);
      if (localObject != null) {
        this.appId = ((WxaAttributes)localObject).field_appId;
      }
    }
    Object localObject = this.appId;
    AppMethodBeat.o(33804);
    return localObject;
  }
  
  final void jf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33805);
    if (bt.isNullOrNil(getAppId()))
    {
      AppMethodBeat.o(33805);
      return;
    }
    ad.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.FTO, Integer.valueOf(paramInt2) });
    h.vKh.f(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.FTO, Integer.valueOf(paramInt2), Long.valueOf(bt.aGK()) });
    AppMethodBeat.o(33805);
  }
  
  public final void show(int paramInt)
  {
    AppMethodBeat.i(33803);
    this.iIO = new com.tencent.mm.ui.widget.a.e(this.context, 1, true);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33803);
      return;
    case 1: 
      this.FTN = new a();
      if (this.FTN == null) {
        ad.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.iIO.HrX = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(33784);
          if (d.this.FTN == null)
          {
            ad.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(33784);
            return;
          }
          d.this.FTN.onCreateMMMenu(paramAnonymousl);
          AppMethodBeat.o(33784);
        }
      };
      this.iIO.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(33783);
          if (d.this.FTN == null)
          {
            ad.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(33783);
            return;
          }
          d.this.FTN.onMMMenuItemSelected(paramAnonymousMenuItem, paramAnonymousInt);
          AppMethodBeat.o(33783);
        }
      };
      this.iIO.csG();
      AppMethodBeat.o(33803);
      return;
      this.FTN = new b();
      break;
      this.FTN = new f();
      break;
      this.FTN = new g();
      break;
      this.FTN = new d();
      break;
      this.FTN = new e();
      break;
      View localView = this.FTN.eSl();
      if (localView != null) {
        this.iIO.J(localView, false);
      }
    }
  }
  
  public final class a
    extends d.c
  {
    public a()
    {
      super();
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33785);
      super.onCreateMMMenu(paraml);
      paraml.c(2, d.this.context.getString(2131755651));
      paraml.c(8, d.this.context.getString(2131755649));
      paraml.c(7, d.a(d.this));
      AppMethodBeat.o(33785);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(33786);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(33786);
    }
  }
  
  public final class b
    extends d.c
  {
    public b()
    {
      super();
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33787);
      super.onCreateMMMenu(paraml);
      paraml.c(3, d.this.context.getString(2131755653));
      paraml.c(8, d.this.context.getString(2131755649));
      paraml.c(7, d.a(d.this));
      AppMethodBeat.o(33787);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(33788);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(33788);
    }
  }
  
  public class c
    implements d.h
  {
    public c() {}
    
    public View eSl()
    {
      return null;
    }
    
    public void onCreateMMMenu(l paraml) {}
    
    public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      paramInt = 0;
      AppMethodBeat.i(33791);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        if (paramInt != 0) {
          d.this.iIO.bfo();
        }
        AppMethodBeat.o(33791);
        return;
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33789);
            d.this.show(3);
            AppMethodBeat.o(33789);
          }
        }, 100L);
        paramInt = 1;
        continue;
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33790);
            d.this.show(4);
            AppMethodBeat.o(33790);
          }
        }, 100L);
        paramInt = 1;
        continue;
        d.this.iIO.bfo();
        paramInt = 1;
        continue;
        if (!bt.isNullOrNil(d.this.username))
        {
          e.l(d.this.context, d.this.username, true);
          if (d.this.mlE)
          {
            d.a(d.this, 6);
            paramInt = 1;
            continue;
          }
          d.this.jf(d.this.scene, 4);
          paramInt = 1;
          continue;
          if (!bt.isNullOrNil(d.this.username))
          {
            e.l(d.this.context, d.this.username, false);
            if (d.this.mlE)
            {
              d.a(d.this, 1);
              paramInt = 1;
              continue;
            }
            d.this.jf(d.this.scene, 2);
            paramInt = 1;
            continue;
            paramMenuItem = d.this;
            Object localObject1 = d.this.context;
            Object localObject2 = d.this.lBG;
            if (localObject2 == null)
            {
              ad.e("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams is null");
              paramInt = 1;
              continue;
            }
            ad.i("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams : %s", new Object[] { ((WxaExposedParams)localObject2).toString() });
            if (!bt.isNullOrNil(((WxaExposedParams)localObject2).username))
            {
              localObject3 = new Intent();
              ((Intent)localObject3).putExtra("key_username", ((WxaExposedParams)localObject2).username);
              ((Intent)localObject3).putExtra("key_from_scene", 4);
              ((Intent)localObject3).putExtra("key_scene_exposed_params", (Parcelable)localObject2);
              com.tencent.mm.bs.d.b((Context)localObject1, "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject3);
              paramMenuItem.jf(paramMenuItem.scene, 1);
            }
            paramInt = 1;
            continue;
            localObject1 = d.this;
            localObject2 = new Intent();
            Object localObject3 = ((d)localObject1).lBG.appId;
            String str = ((d)localObject1).lBG.pageId;
            if ((((d)localObject1).lBG.appId != null) && (((d)localObject1).lBG.appId.equals(((d)localObject1).getAppId()))) {}
            for (paramMenuItem = "";; paramMenuItem = ((d)localObject1).getAppId())
            {
              paramMenuItem = d.aW((String)localObject3, str, paramMenuItem);
              ad.v("MicroMsg.AppBrandServiceActionSheet", "KRawUrl ".concat(String.valueOf(paramMenuItem)));
              ((Intent)localObject2).putExtra("rawUrl", paramMenuItem);
              ((Intent)localObject2).putExtra("forceHideShare", true);
              com.tencent.mm.bs.d.b(((d)localObject1).context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
              paramInt = 1;
              break;
            }
          }
        }
        paramInt = 1;
      }
    }
  }
  
  public final class d
    extends d.c
  {
    public d()
    {
      super();
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33792);
      super.onCreateMMMenu(paraml);
      paraml.c(2, d.this.context.getString(2131755651));
      paraml.c(8, d.this.context.getString(2131755649));
      paraml.c(7, d.a(d.this));
      AppMethodBeat.o(33792);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(33793);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(33793);
    }
  }
  
  public final class e
    extends d.c
  {
    public e()
    {
      super();
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33794);
      super.onCreateMMMenu(paraml);
      paraml.c(3, d.this.context.getString(2131755653));
      paraml.c(8, d.this.context.getString(2131755649));
      paraml.c(7, d.a(d.this));
      AppMethodBeat.o(33794);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(33795);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(33795);
    }
  }
  
  public final class f
    extends d.c
  {
    public f()
    {
      super();
    }
    
    public final View eSl()
    {
      AppMethodBeat.i(33796);
      View localView = y.js(d.this.context).inflate(2131493384, null);
      ((TextView)localView.findViewById(2131296902)).setText(d.this.context.getString(2131755650));
      AppMethodBeat.o(33796);
      return localView;
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33797);
      super.onCreateMMMenu(paraml);
      paraml.c(5, d.this.context.getString(2131755514));
      paraml.c(4, d.this.context.getString(2131755648));
      AppMethodBeat.o(33797);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(33798);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(33798);
    }
  }
  
  public final class g
    extends d.c
  {
    public g()
    {
      super();
    }
    
    public final View eSl()
    {
      AppMethodBeat.i(33799);
      View localView = y.js(d.this.context).inflate(2131493384, null);
      ((TextView)localView.findViewById(2131296902)).setText(d.this.context.getString(2131755652));
      AppMethodBeat.o(33799);
      return localView;
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33800);
      super.onCreateMMMenu(paraml);
      paraml.c(6, d.this.context.getString(2131755516));
      paraml.c(4, d.this.context.getString(2131755648));
      AppMethodBeat.o(33800);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(33801);
      super.onMMMenuItemSelected(paramMenuItem, paramInt);
      AppMethodBeat.o(33801);
    }
  }
  
  public static abstract interface h
  {
    public abstract View eSl();
    
    public abstract void onCreateMMMenu(l paraml);
    
    public abstract void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.d
 * JD-Core Version:    0.7.0.1
 */