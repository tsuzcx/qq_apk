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
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.z;
import java.io.UnsupportedEncodingException;

public final class d
{
  h JCd;
  public String JCe;
  public String appId;
  Context context;
  com.tencent.mm.ui.widget.a.e jFy;
  public WxaExposedParams mIR;
  public boolean ntl;
  public int scene;
  public String username;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(33802);
    this.mIR = new WxaExposedParams.a().bfb();
    this.appId = "";
    this.JCe = "";
    this.context = paramContext;
    AppMethodBeat.o(33802);
  }
  
  public static String bj(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(33806);
    try
    {
      paramString1 = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[] { q.encode(bu.nullAsNil(paramString1), "UTF-8"), q.encode(bu.nullAsNil(paramString2), "UTF-8"), Integer.valueOf(10), q.encode(bu.nullAsNil(paramString3), "UTF-8") });
      AppMethodBeat.o(33806);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      ae.e("MicroMsg.AppBrandServiceActionSheet", "buildExposeUrl encode fail, invalid arguments");
      AppMethodBeat.o(33806);
    }
    return "";
  }
  
  final String getAppId()
  {
    AppMethodBeat.i(33804);
    if (bu.isNullOrNil(this.username))
    {
      AppMethodBeat.o(33804);
      return null;
    }
    if (bu.isNullOrNil(this.appId))
    {
      localObject = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(this.username);
      if (localObject != null) {
        this.appId = ((WxaAttributes)localObject).field_appId;
      }
    }
    Object localObject = this.appId;
    AppMethodBeat.o(33804);
    return localObject;
  }
  
  final void jI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33805);
    if (bu.isNullOrNil(getAppId()))
    {
      AppMethodBeat.o(33805);
      return;
    }
    ae.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.JCe, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.g.yxI.f(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.JCe, Integer.valueOf(paramInt2), Long.valueOf(bu.aRi()) });
    AppMethodBeat.o(33805);
  }
  
  public final void show(int paramInt)
  {
    AppMethodBeat.i(33803);
    this.jFy = new com.tencent.mm.ui.widget.a.e(this.context, 1, true);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33803);
      return;
    case 1: 
      this.JCd = new a();
      if (this.JCd == null) {
        ae.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.jFy.LfS = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(187070);
          if (d.this.JCd == null)
          {
            ae.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(187070);
            return;
          }
          d.this.JCd.onCreateMMMenu(paramAnonymousl);
          AppMethodBeat.o(187070);
        }
      };
      this.jFy.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(187069);
          if (d.this.JCd == null)
          {
            ae.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(187069);
            return;
          }
          d.this.JCd.onMMMenuItemSelected(paramAnonymousMenuItem, paramAnonymousInt);
          AppMethodBeat.o(187069);
        }
      };
      this.jFy.LsV = new e.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(187068);
          d.this.jFy.bqD();
          AppMethodBeat.o(187068);
        }
      };
      this.jFy.cPF();
      AppMethodBeat.o(33803);
      return;
      this.JCd = new b();
      break;
      this.JCd = new f();
      break;
      this.JCd = new g();
      break;
      this.JCd = new d();
      break;
      this.JCd = new e();
      break;
      View localView = this.JCd.fCn();
      if (localView != null) {
        this.jFy.P(localView, false);
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
      paraml.d(2, d.this.context.getString(2131755651));
      paraml.d(8, d.this.context.getString(2131755649));
      paraml.d(7, d.a(d.this));
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
      paraml.d(3, d.this.context.getString(2131755653));
      paraml.d(8, d.this.context.getString(2131755649));
      paraml.d(7, d.a(d.this));
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
    
    public View fCn()
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
          d.this.jFy.bqD();
        }
        AppMethodBeat.o(33791);
        return;
        ar.o(new Runnable()
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
        ar.o(new Runnable()
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
        d.this.jFy.bqD();
        paramInt = 1;
        continue;
        if (!bu.isNullOrNil(d.this.username))
        {
          e.l(d.this.context, d.this.username, true);
          if (d.this.ntl)
          {
            d.a(d.this, 6);
            paramInt = 1;
            continue;
          }
          d.this.jI(d.this.scene, 4);
          paramInt = 1;
          continue;
          if (!bu.isNullOrNil(d.this.username))
          {
            e.l(d.this.context, d.this.username, false);
            if (d.this.ntl)
            {
              d.a(d.this, 1);
              paramInt = 1;
              continue;
            }
            d.this.jI(d.this.scene, 2);
            paramInt = 1;
            continue;
            paramMenuItem = d.this;
            Object localObject1 = d.this.context;
            Object localObject2 = d.this.mIR;
            if (localObject2 == null)
            {
              ae.e("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams is null");
              paramInt = 1;
              continue;
            }
            ae.i("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams : %s", new Object[] { ((WxaExposedParams)localObject2).toString() });
            if (!bu.isNullOrNil(((WxaExposedParams)localObject2).username))
            {
              localObject3 = new Intent();
              ((Intent)localObject3).putExtra("key_username", ((WxaExposedParams)localObject2).username);
              ((Intent)localObject3).putExtra("key_from_scene", 4);
              ((Intent)localObject3).putExtra("key_scene_exposed_params", (Parcelable)localObject2);
              com.tencent.mm.br.d.b((Context)localObject1, "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject3);
              paramMenuItem.jI(paramMenuItem.scene, 1);
            }
            paramInt = 1;
            continue;
            localObject1 = d.this;
            localObject2 = new Intent();
            Object localObject3 = ((d)localObject1).mIR.appId;
            String str = ((d)localObject1).mIR.pageId;
            if ((((d)localObject1).mIR.appId != null) && (((d)localObject1).mIR.appId.equals(((d)localObject1).getAppId()))) {}
            for (paramMenuItem = "";; paramMenuItem = ((d)localObject1).getAppId())
            {
              paramMenuItem = d.bj((String)localObject3, str, paramMenuItem);
              ae.v("MicroMsg.AppBrandServiceActionSheet", "KRawUrl ".concat(String.valueOf(paramMenuItem)));
              ((Intent)localObject2).putExtra("rawUrl", paramMenuItem);
              ((Intent)localObject2).putExtra("forceHideShare", true);
              com.tencent.mm.br.d.b(((d)localObject1).context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
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
      paraml.d(2, d.this.context.getString(2131755651));
      paraml.d(8, d.this.context.getString(2131755649));
      paraml.d(7, d.a(d.this));
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
      paraml.d(3, d.this.context.getString(2131755653));
      paraml.d(8, d.this.context.getString(2131755649));
      paraml.d(7, d.a(d.this));
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
    
    public final View fCn()
    {
      AppMethodBeat.i(33796);
      View localView = z.jV(d.this.context).inflate(2131493384, null);
      ((TextView)localView.findViewById(2131296902)).setText(d.this.context.getString(2131755650));
      AppMethodBeat.o(33796);
      return localView;
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33797);
      super.onCreateMMMenu(paraml);
      paraml.d(5, d.this.context.getString(2131755514));
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
    
    public final View fCn()
    {
      AppMethodBeat.i(33799);
      View localView = z.jV(d.this.context).inflate(2131493384, null);
      ((TextView)localView.findViewById(2131296902)).setText(d.this.context.getString(2131755652));
      AppMethodBeat.o(33799);
      return localView;
    }
    
    public final void onCreateMMMenu(l paraml)
    {
      AppMethodBeat.i(33800);
      super.onCreateMMMenu(paraml);
      paraml.d(6, d.this.context.getString(2131755516));
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
    public abstract View fCn();
    
    public abstract void onCreateMMMenu(l paraml);
    
    public abstract void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.d
 * JD-Core Version:    0.7.0.1
 */