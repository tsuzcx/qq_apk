package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e.a;

public final class d
{
  h OMV;
  public String OMW;
  public String appId;
  Context context;
  com.tencent.mm.ui.widget.a.e kHi;
  public WxaExposedParams nVO;
  public boolean oDm;
  public int scene;
  public String username;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(33802);
    this.nVO = new WxaExposedParams.a().bAv();
    this.appId = "";
    this.OMW = "";
    this.context = paramContext;
    AppMethodBeat.o(33802);
  }
  
  final String getAppId()
  {
    AppMethodBeat.i(33804);
    if (Util.isNullOrNil(this.username))
    {
      AppMethodBeat.o(33804);
      return null;
    }
    if (Util.isNullOrNil(this.appId))
    {
      localObject = ((q)g.af(q.class)).Xk(this.username);
      if (localObject != null) {
        this.appId = ((WxaAttributes)localObject).field_appId;
      }
    }
    Object localObject = this.appId;
    AppMethodBeat.o(33804);
    return localObject;
  }
  
  final void kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33805);
    if (Util.isNullOrNil(getAppId()))
    {
      AppMethodBeat.o(33805);
      return;
    }
    Log.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.OMW, Integer.valueOf(paramInt2) });
    h.CyF.a(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.OMW, Integer.valueOf(paramInt2), Long.valueOf(Util.nowSecond()) });
    AppMethodBeat.o(33805);
  }
  
  public final void show(int paramInt)
  {
    AppMethodBeat.i(33803);
    this.kHi = new com.tencent.mm.ui.widget.a.e(this.context, 1, true);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33803);
      return;
    case 1: 
      this.OMV = new a();
      if (this.OMV == null) {
        Log.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.kHi.HLX = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(232754);
          if (d.this.OMV == null)
          {
            Log.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(232754);
            return;
          }
          d.this.OMV.onCreateMMMenu(paramAnonymousm);
          AppMethodBeat.o(232754);
        }
      };
      this.kHi.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(232753);
          if (d.this.OMV == null)
          {
            Log.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(232753);
            return;
          }
          d.this.OMV.onMMMenuItemSelected(paramAnonymousMenuItem, paramAnonymousInt);
          AppMethodBeat.o(232753);
        }
      };
      this.kHi.QNO = new e.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(232752);
          d.this.kHi.bMo();
          AppMethodBeat.o(232752);
        }
      };
      this.kHi.dGm();
      AppMethodBeat.o(33803);
      return;
      this.OMV = new b();
      break;
      this.OMV = new f();
      break;
      this.OMV = new g();
      break;
      this.OMV = new d();
      break;
      this.OMV = new e();
      break;
      View localView = this.OMV.gKl();
      if (localView != null) {
        this.kHi.V(localView, false);
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
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(33785);
      super.onCreateMMMenu(paramm);
      paramm.d(2, d.this.context.getString(2131755698));
      paramm.d(8, d.this.context.getString(2131755696));
      paramm.d(7, d.a(d.this));
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
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(33787);
      super.onCreateMMMenu(paramm);
      paramm.d(3, d.this.context.getString(2131755700));
      paramm.d(8, d.this.context.getString(2131755696));
      paramm.d(7, d.a(d.this));
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
    
    public View gKl()
    {
      return null;
    }
    
    public void onCreateMMMenu(m paramm) {}
    
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
          d.this.kHi.bMo();
        }
        AppMethodBeat.o(33791);
        return;
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
        d.this.kHi.bMo();
        paramInt = 1;
        continue;
        if (!Util.isNullOrNil(d.this.username))
        {
          e.l(d.this.context, d.this.username, true);
          if (d.this.oDm)
          {
            d.a(d.this, 6);
            paramInt = 1;
            continue;
          }
          d.this.kR(d.this.scene, 4);
          paramInt = 1;
          continue;
          if (!Util.isNullOrNil(d.this.username))
          {
            e.l(d.this.context, d.this.username, false);
            if (d.this.oDm)
            {
              d.a(d.this, 1);
              paramInt = 1;
              continue;
            }
            d.this.kR(d.this.scene, 2);
            paramInt = 1;
            continue;
            paramMenuItem = d.this;
            Object localObject1 = d.this.context;
            Object localObject2 = d.this.nVO;
            if (localObject2 == null)
            {
              Log.e("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams is null");
              paramInt = 1;
              continue;
            }
            Log.i("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams : %s", new Object[] { ((WxaExposedParams)localObject2).toString() });
            if (!Util.isNullOrNil(((WxaExposedParams)localObject2).username))
            {
              localObject3 = new Intent();
              ((Intent)localObject3).putExtra("key_username", ((WxaExposedParams)localObject2).username);
              ((Intent)localObject3).putExtra("key_from_scene", 4);
              ((Intent)localObject3).putExtra("key_scene_exposed_params", (Parcelable)localObject2);
              c.b((Context)localObject1, "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject3);
              paramMenuItem.kR(paramMenuItem.scene, 1);
            }
            paramInt = 1;
            continue;
            localObject1 = d.this;
            localObject2 = new Intent();
            Object localObject3 = ((d)localObject1).nVO.appId;
            String str = ((d)localObject1).nVO.pageId;
            if ((((d)localObject1).nVO.appId != null) && (((d)localObject1).nVO.appId.equals(((d)localObject1).getAppId()))) {}
            for (paramMenuItem = "";; paramMenuItem = ((d)localObject1).getAppId())
            {
              WxaExposedParams.a locala = new WxaExposedParams.a();
              locala.appId = ((String)localObject3);
              locala.from = 10;
              locala.pageId = str;
              locala.lhq = paramMenuItem;
              paramMenuItem = w.a(locala.bAv());
              Log.v("MicroMsg.AppBrandServiceActionSheet", "KRawUrl ".concat(String.valueOf(paramMenuItem)));
              ((Intent)localObject2).putExtra("rawUrl", paramMenuItem);
              ((Intent)localObject2).putExtra("forceHideShare", true);
              c.b(((d)localObject1).context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
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
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(33792);
      super.onCreateMMMenu(paramm);
      paramm.d(2, d.this.context.getString(2131755698));
      paramm.d(8, d.this.context.getString(2131755696));
      paramm.d(7, d.a(d.this));
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
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(33794);
      super.onCreateMMMenu(paramm);
      paramm.d(3, d.this.context.getString(2131755700));
      paramm.d(8, d.this.context.getString(2131755696));
      paramm.d(7, d.a(d.this));
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
    
    public final View gKl()
    {
      AppMethodBeat.i(33796);
      View localView = aa.jQ(d.this.context).inflate(2131493478, null);
      ((TextView)localView.findViewById(2131297004)).setText(d.this.context.getString(2131755697));
      AppMethodBeat.o(33796);
      return localView;
    }
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(33797);
      super.onCreateMMMenu(paramm);
      paramm.d(5, d.this.context.getString(2131755552));
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
    
    public final View gKl()
    {
      AppMethodBeat.i(33799);
      View localView = aa.jQ(d.this.context).inflate(2131493478, null);
      ((TextView)localView.findViewById(2131297004)).setText(d.this.context.getString(2131755699));
      AppMethodBeat.o(33799);
      return localView;
    }
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(33800);
      super.onCreateMMMenu(paramm);
      paramm.d(6, d.this.context.getString(2131755554));
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
    public abstract View gKl();
    
    public abstract void onCreateMMMenu(m paramm);
    
    public abstract void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.d
 * JD-Core Version:    0.7.0.1
 */