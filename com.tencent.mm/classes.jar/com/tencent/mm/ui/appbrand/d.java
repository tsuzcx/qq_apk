package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.z;
import java.io.UnsupportedEncodingException;

public final class d
{
  h Jhs;
  public String Jht;
  public String appId;
  Context context;
  com.tencent.mm.ui.widget.a.e jCA;
  public WxaExposedParams mDM;
  public boolean nob;
  public int scene;
  public String username;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(33802);
    this.mDM = new WxaExposedParams.a().bet();
    this.appId = "";
    this.Jht = "";
    this.context = paramContext;
    AppMethodBeat.o(33802);
  }
  
  public static String bi(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(33806);
    try
    {
      paramString1 = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[] { q.encode(bt.nullAsNil(paramString1), "UTF-8"), q.encode(bt.nullAsNil(paramString2), "UTF-8"), Integer.valueOf(10), q.encode(bt.nullAsNil(paramString3), "UTF-8") });
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
      localObject = ((n)com.tencent.mm.kernel.g.ab(n.class)).Nt(this.username);
      if (localObject != null) {
        this.appId = ((WxaAttributes)localObject).field_appId;
      }
    }
    Object localObject = this.appId;
    AppMethodBeat.o(33804);
    return localObject;
  }
  
  final void jE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33805);
    if (bt.isNullOrNil(getAppId()))
    {
      AppMethodBeat.o(33805);
      return;
    }
    ad.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.Jht, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.g.yhR.f(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.Jht, Integer.valueOf(paramInt2), Long.valueOf(bt.aQJ()) });
    AppMethodBeat.o(33805);
  }
  
  public final void show(int paramInt)
  {
    AppMethodBeat.i(33803);
    this.jCA = new com.tencent.mm.ui.widget.a.e(this.context, 1, true);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33803);
      return;
    case 1: 
      this.Jhs = new a();
      if (this.Jhs == null) {
        ad.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.jCA.KJy = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(193779);
          if (d.this.Jhs == null)
          {
            ad.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(193779);
            return;
          }
          d.this.Jhs.onCreateMMMenu(paramAnonymousl);
          AppMethodBeat.o(193779);
        }
      };
      this.jCA.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(193778);
          if (d.this.Jhs == null)
          {
            ad.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(193778);
            return;
          }
          d.this.Jhs.onMMMenuItemSelected(paramAnonymousMenuItem, paramAnonymousInt);
          AppMethodBeat.o(193778);
        }
      };
      this.jCA.KWx = new e.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(193777);
          d.this.jCA.bpT();
          AppMethodBeat.o(193777);
        }
      };
      this.jCA.cMW();
      AppMethodBeat.o(33803);
      return;
      this.Jhs = new b();
      break;
      this.Jhs = new f();
      break;
      this.Jhs = new g();
      break;
      this.Jhs = new d();
      break;
      this.Jhs = new e();
      break;
      View localView = this.Jhs.fyl();
      if (localView != null) {
        this.jCA.K(localView, false);
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
    
    public View fyl()
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
          d.this.jCA.bpT();
        }
        AppMethodBeat.o(33791);
        return;
        aq.o(new Runnable()
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
        aq.o(new Runnable()
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
        d.this.jCA.bpT();
        paramInt = 1;
        continue;
        if (!bt.isNullOrNil(d.this.username))
        {
          e.k(d.this.context, d.this.username, true);
          if (d.this.nob)
          {
            d.a(d.this, 6);
            paramInt = 1;
            continue;
          }
          d.this.jE(d.this.scene, 4);
          paramInt = 1;
          continue;
          if (!bt.isNullOrNil(d.this.username))
          {
            e.k(d.this.context, d.this.username, false);
            if (d.this.nob)
            {
              d.a(d.this, 1);
              paramInt = 1;
              continue;
            }
            d.this.jE(d.this.scene, 2);
            paramInt = 1;
            continue;
            paramMenuItem = d.this;
            Object localObject1 = d.this.context;
            Object localObject2 = d.this.mDM;
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
              paramMenuItem.jE(paramMenuItem.scene, 1);
            }
            paramInt = 1;
            continue;
            localObject1 = d.this;
            localObject2 = new Intent();
            Object localObject3 = ((d)localObject1).mDM.appId;
            String str = ((d)localObject1).mDM.pageId;
            if ((((d)localObject1).mDM.appId != null) && (((d)localObject1).mDM.appId.equals(((d)localObject1).getAppId()))) {}
            for (paramMenuItem = "";; paramMenuItem = ((d)localObject1).getAppId())
            {
              paramMenuItem = d.bi((String)localObject3, str, paramMenuItem);
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
    
    public final View fyl()
    {
      AppMethodBeat.i(33796);
      View localView = z.jO(d.this.context).inflate(2131493384, null);
      ((TextView)localView.findViewById(2131296902)).setText(d.this.context.getString(2131755650));
      AppMethodBeat.o(33796);
      return localView;
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33797);
      super.onCreateMMMenu(paraml);
      paraml.c(5, d.this.context.getString(2131755514));
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
    
    public final View fyl()
    {
      AppMethodBeat.i(33799);
      View localView = z.jO(d.this.context).inflate(2131493384, null);
      ((TextView)localView.findViewById(2131296902)).setText(d.this.context.getString(2131755652));
      AppMethodBeat.o(33799);
      return localView;
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33800);
      super.onCreateMMMenu(paraml);
      paraml.c(6, d.this.context.getString(2131755516));
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
    public abstract View fyl();
    
    public abstract void onCreateMMMenu(l paraml);
    
    public abstract void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.d
 * JD-Core Version:    0.7.0.1
 */