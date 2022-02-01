package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.a;

public class d
{
  private h adNq;
  public String appId;
  private Context context;
  private f qAo;
  public int scene;
  public boolean uQq;
  public WxaExposedParams ucN;
  public String username;
  public String xIc;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(33802);
    this.ucN = new WxaExposedParams.a().cll();
    this.appId = "";
    this.xIc = "";
    this.context = paramContext;
    AppMethodBeat.o(33802);
  }
  
  private String getAppId()
  {
    AppMethodBeat.i(33804);
    if (Util.isNullOrNil(this.username))
    {
      AppMethodBeat.o(33804);
      return null;
    }
    if (Util.isNullOrNil(this.appId))
    {
      localObject = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(this.username);
      if (localObject != null) {
        this.appId = ((WxaAttributes)localObject).field_appId;
      }
    }
    Object localObject = this.appId;
    AppMethodBeat.o(33804);
    return localObject;
  }
  
  private void oc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33805);
    if (Util.isNullOrNil(getAppId()))
    {
      AppMethodBeat.o(33805);
      return;
    }
    Log.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.xIc, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.h.OAn.b(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.xIc, Integer.valueOf(paramInt2), Long.valueOf(Util.nowSecond()) });
    AppMethodBeat.o(33805);
  }
  
  public final void Dk(int paramInt)
  {
    AppMethodBeat.i(33803);
    this.qAo = new f(this.context, 1, true);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33803);
      return;
    case 1: 
      this.adNq = new a();
      if (this.adNq == null) {
        Log.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.qAo.Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(249680);
          if (d.e(d.this) == null)
          {
            Log.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(249680);
            return;
          }
          d.e(d.this).onCreateMMMenu(paramAnonymouss);
          AppMethodBeat.o(249680);
        }
      };
      this.qAo.GAC = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(249676);
          if (d.e(d.this) == null)
          {
            Log.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(249676);
            return;
          }
          d.e(d.this).onMMMenuItemSelected(paramAnonymousMenuItem, paramAnonymousInt);
          AppMethodBeat.o(249676);
        }
      };
      this.qAo.ages = new f.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(249677);
          d.a(d.this).cyW();
          AppMethodBeat.o(249677);
        }
      };
      this.qAo.dDn();
      AppMethodBeat.o(33803);
      return;
      this.adNq = new b();
      break;
      this.adNq = new f();
      break;
      this.adNq = new g();
      break;
      this.adNq = new d();
      break;
      this.adNq = new e();
      break;
      View localView = this.adNq.jlQ();
      if (localView != null) {
        this.qAo.af(localView, false);
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
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(33785);
      super.onCreateMMMenu(params);
      params.c(2, d.b(d.this).getString(R.l.grw));
      params.c(8, d.b(d.this).getString(R.l.gru));
      params.c(7, d.d(d.this));
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
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(33787);
      super.onCreateMMMenu(params);
      params.c(3, d.b(d.this).getString(R.l.gry));
      params.c(8, d.b(d.this).getString(R.l.gru));
      params.c(7, d.d(d.this));
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
    
    public View jlQ()
    {
      return null;
    }
    
    public void onCreateMMMenu(com.tencent.mm.ui.base.s params) {}
    
    public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(33791);
      switch (paramMenuItem.getItemId())
      {
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt != 0) {
          d.a(d.this).cyW();
        }
        AppMethodBeat.o(33791);
        return;
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33789);
            d.this.Dk(3);
            AppMethodBeat.o(33789);
          }
        }, 100L);
        paramInt = i;
        continue;
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33790);
            d.this.Dk(4);
            AppMethodBeat.o(33790);
          }
        }, 100L);
        paramInt = i;
        continue;
        d.a(d.this).cyW();
        paramInt = i;
        continue;
        paramInt = i;
        if (!Util.isNullOrNil(d.this.username))
        {
          e.l(d.b(d.this), d.this.username, true);
          if (d.this.uQq)
          {
            d.a(d.this, 6);
            paramInt = i;
          }
          else
          {
            d.a(d.this, d.this.scene, 4);
            paramInt = i;
            continue;
            paramInt = i;
            if (!Util.isNullOrNil(d.this.username))
            {
              e.l(d.b(d.this), d.this.username, false);
              if (d.this.uQq)
              {
                d.a(d.this, 1);
                paramInt = i;
              }
              else
              {
                d.a(d.this, d.this.scene, 2);
                paramInt = i;
                continue;
                d.a(d.this, d.b(d.this), d.this.ucN);
                paramInt = i;
                continue;
                d.c(d.this);
                paramInt = i;
              }
            }
          }
        }
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
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(33792);
      super.onCreateMMMenu(params);
      params.c(2, d.b(d.this).getString(R.l.grw));
      params.c(8, d.b(d.this).getString(R.l.gru));
      params.c(7, d.d(d.this));
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
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(33794);
      super.onCreateMMMenu(params);
      params.c(3, d.b(d.this).getString(R.l.gry));
      params.c(8, d.b(d.this).getString(R.l.gru));
      params.c(7, d.d(d.this));
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
    
    public final View jlQ()
    {
      AppMethodBeat.i(33796);
      View localView = af.mU(d.b(d.this)).inflate(R.i.geP, null);
      ((TextView)localView.findViewById(R.h.frK)).setText(d.b(d.this).getString(R.l.grv));
      AppMethodBeat.o(33796);
      return localView;
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(33797);
      super.onCreateMMMenu(params);
      params.c(5, d.b(d.this).getString(R.l.gro));
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
    
    public final View jlQ()
    {
      AppMethodBeat.i(33799);
      View localView = af.mU(d.b(d.this)).inflate(R.i.geP, null);
      ((TextView)localView.findViewById(R.h.frK)).setText(d.b(d.this).getString(R.l.grx));
      AppMethodBeat.o(33799);
      return localView;
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(33800);
      super.onCreateMMMenu(params);
      params.c(6, d.b(d.this).getString(R.l.grp));
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
    public abstract View jlQ();
    
    public abstract void onCreateMMMenu(com.tencent.mm.ui.base.s params);
    
    public abstract void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.d
 * JD-Core Version:    0.7.0.1
 */