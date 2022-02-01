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
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.a;

public class d
{
  public String UJN;
  private h Wgu;
  public String appId;
  private Context context;
  private com.tencent.mm.ui.widget.a.e nBc;
  public WxaExposedParams qXo;
  public boolean rFe;
  public int scene;
  public String username;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(33802);
    this.qXo = new WxaExposedParams.a().bLN();
    this.appId = "";
    this.UJN = "";
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
      localObject = ((q)com.tencent.mm.kernel.h.ae(q.class)).aeW(this.username);
      if (localObject != null) {
        this.appId = ((WxaAttributes)localObject).field_appId;
      }
    }
    Object localObject = this.appId;
    AppMethodBeat.o(33804);
    return localObject;
  }
  
  private void mj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33805);
    if (Util.isNullOrNil(getAppId()))
    {
      AppMethodBeat.o(33805);
      return;
    }
    Log.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[] { Integer.valueOf(13918), this.appId, Integer.valueOf(paramInt1), this.UJN, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.h.IzE.a(13918, new Object[] { getAppId(), Integer.valueOf(paramInt1), this.UJN, Integer.valueOf(paramInt2), Long.valueOf(Util.nowSecond()) });
    AppMethodBeat.o(33805);
  }
  
  public final void CR(int paramInt)
  {
    AppMethodBeat.i(33803);
    this.nBc = new com.tencent.mm.ui.widget.a.e(this.context, 1, true);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33803);
      return;
    case 1: 
      this.Wgu = new a();
      if (this.Wgu == null) {
        Log.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
      }
      break;
    }
    for (;;)
    {
      this.nBc.ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(209664);
          if (d.e(d.this) == null)
          {
            Log.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(209664);
            return;
          }
          d.e(d.this).onCreateMMMenu(paramAnonymouso);
          AppMethodBeat.o(209664);
        }
      };
      this.nBc.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(210693);
          if (d.e(d.this) == null)
          {
            Log.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
            AppMethodBeat.o(210693);
            return;
          }
          d.e(d.this).onMMMenuItemSelected(paramAnonymousMenuItem, paramAnonymousInt);
          AppMethodBeat.o(210693);
        }
      };
      this.nBc.YmE = new e.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(249731);
          d.a(d.this).bYF();
          AppMethodBeat.o(249731);
        }
      };
      this.nBc.eik();
      AppMethodBeat.o(33803);
      return;
      this.Wgu = new b();
      break;
      this.Wgu = new f();
      break;
      this.Wgu = new g();
      break;
      this.Wgu = new d();
      break;
      this.Wgu = new e();
      break;
      View localView = this.Wgu.hJn();
      if (localView != null) {
        this.nBc.Z(localView, false);
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
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(33785);
      super.onCreateMMMenu(paramo);
      paramo.d(2, d.b(d.this).getString(R.l.eox));
      paramo.d(8, d.b(d.this).getString(R.l.eov));
      paramo.d(7, d.d(d.this));
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
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(33787);
      super.onCreateMMMenu(paramo);
      paramo.d(3, d.b(d.this).getString(R.l.eoz));
      paramo.d(8, d.b(d.this).getString(R.l.eov));
      paramo.d(7, d.d(d.this));
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
    
    public View hJn()
    {
      return null;
    }
    
    public void onCreateMMMenu(o paramo) {}
    
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
          d.a(d.this).bYF();
        }
        AppMethodBeat.o(33791);
        return;
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33789);
            d.this.CR(3);
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
            d.this.CR(4);
            AppMethodBeat.o(33790);
          }
        }, 100L);
        paramInt = i;
        continue;
        d.a(d.this).bYF();
        paramInt = i;
        continue;
        paramInt = i;
        if (!Util.isNullOrNil(d.this.username))
        {
          e.l(d.b(d.this), d.this.username, true);
          if (d.this.rFe)
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
              if (d.this.rFe)
              {
                d.a(d.this, 1);
                paramInt = i;
              }
              else
              {
                d.a(d.this, d.this.scene, 2);
                paramInt = i;
                continue;
                d.a(d.this, d.b(d.this), d.this.qXo);
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
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(33792);
      super.onCreateMMMenu(paramo);
      paramo.d(2, d.b(d.this).getString(R.l.eox));
      paramo.d(8, d.b(d.this).getString(R.l.eov));
      paramo.d(7, d.d(d.this));
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
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(33794);
      super.onCreateMMMenu(paramo);
      paramo.d(3, d.b(d.this).getString(R.l.eoz));
      paramo.d(8, d.b(d.this).getString(R.l.eov));
      paramo.d(7, d.d(d.this));
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
    
    public final View hJn()
    {
      AppMethodBeat.i(33796);
      View localView = ad.kS(d.b(d.this)).inflate(R.i.eci, null);
      ((TextView)localView.findViewById(R.h.drs)).setText(d.b(d.this).getString(R.l.eow));
      AppMethodBeat.o(33796);
      return localView;
    }
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(33797);
      super.onCreateMMMenu(paramo);
      paramo.d(5, d.b(d.this).getString(R.l.eoq));
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
    
    public final View hJn()
    {
      AppMethodBeat.i(33799);
      View localView = ad.kS(d.b(d.this)).inflate(R.i.eci, null);
      ((TextView)localView.findViewById(R.h.drs)).setText(d.b(d.this).getString(R.l.eoy));
      AppMethodBeat.o(33799);
      return localView;
    }
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(33800);
      super.onCreateMMMenu(paramo);
      paramo.d(6, d.b(d.this).getString(R.l.eor));
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
    public abstract View hJn();
    
    public abstract void onCreateMMMenu(o paramo);
    
    public abstract void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.d
 * JD-Core Version:    0.7.0.1
 */