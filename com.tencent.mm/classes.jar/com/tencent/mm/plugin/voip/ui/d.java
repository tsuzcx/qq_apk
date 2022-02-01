package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class d
{
  public VoipViewFragment HeX;
  private Intent intent;
  private a zTN;
  boolean zTO = false;
  MTimerHandler zTP;
  
  public final void a(final Intent paramIntent, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(235778);
    if (parama == null)
    {
      Log.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
      AppMethodBeat.o(235778);
      return;
    }
    this.intent = paramIntent;
    this.zTN = parama;
    if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = MMApplicationContext.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131767297), new RequestFloatWindowPermissionDialog.a()
      {
        public final void onResultAllow(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184065);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          if (parama.dZV()) {
            d.this.a(paramIntent, paramBoolean, this.GSR);
          }
          AppMethodBeat.o(184065);
        }
        
        public final void onResultCancel(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(185955);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(185955);
        }
        
        public final void onResultRefuse(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184066);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(184066);
        }
      }, com.tencent.mm.bq.a.apJ());
      AppMethodBeat.o(235778);
      return;
    }
    a(paramIntent, paramBoolean, false);
    AppMethodBeat.o(235778);
  }
  
  final void a(final Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184079);
    Log.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.HeX != null)
    {
      this.zTN.a(paramIntent, this.HeX.aJ(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
    }
    this.HeX = new VoipViewFragment(MMApplicationContext.getContext());
    this.zTO = false;
    if (this.zTP != null) {
      this.zTP.stopTimer();
    }
    this.HeX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(184069);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView.setOnClickListener(null);
        paramAnonymousView = a.a.GST;
        paramAnonymousView.oWE.oWs.opType = 3;
        ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).m(paramAnonymousView.oWE);
        paramIntent.addFlags(268435456);
        paramAnonymousView = MMApplicationContext.getContext();
        localObject = paramIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        d.this.zTP = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(184067);
            Log.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
            d.this.rX(false);
            if (d.this.zTP != null) {
              d.this.zTP.stopTimer();
            }
            AppMethodBeat.o(184067);
            return true;
          }
        }, false);
        d.this.zTP.startTimer(2000L);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(184068);
            d.this.rX(false);
            AppMethodBeat.o(184068);
          }
        }, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(184069);
      }
    });
    if (paramBoolean1) {
      a.a.GST.a(4, paramBoolean2, this.HeX);
    }
    for (;;)
    {
      this.zTN.a(paramIntent, this.HeX.aJ(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
      a.a.GST.a(8, paramBoolean2, this.HeX);
    }
  }
  
  public final void aGx(String paramString)
  {
    AppMethodBeat.i(184081);
    if (this.HeX != null) {
      this.HeX.aGx(paramString);
    }
    AppMethodBeat.o(184081);
  }
  
  public final void aGy(String paramString)
  {
    AppMethodBeat.i(235779);
    if (this.HeX != null) {
      this.HeX.aGy(paramString);
    }
    AppMethodBeat.o(235779);
  }
  
  public final BaseSmallView aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235782);
    if (this.HeX != null)
    {
      BaseSmallView localBaseSmallView = this.HeX.aJ(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(235782);
      return localBaseSmallView;
    }
    AppMethodBeat.o(235782);
    return null;
  }
  
  public final void enR()
  {
    AppMethodBeat.i(235780);
    if ((this.HeX != null) && (!this.zTO))
    {
      h.RTc.bqo("showIcon");
      h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184073);
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184072);
              if ((d.this.HeX != null) && (!d.this.zTO))
              {
                BaseSmallView localBaseSmallView = d.this.HeX.getCurrentView();
                if (localBaseSmallView != null)
                {
                  localBaseSmallView.enR();
                  AppMethodBeat.o(184072);
                  return;
                }
              }
              AppMethodBeat.o(184072);
            }
          });
          AppMethodBeat.o(184073);
        }
      }, "showIcon");
    }
    AppMethodBeat.o(235780);
  }
  
  public final void eoN()
  {
    AppMethodBeat.i(184082);
    if (this.HeX != null)
    {
      this.zTO = true;
      h.RTc.bqo("showIcon");
      h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184071);
          BaseSmallView localBaseSmallView;
          if (d.this.HeX != null)
          {
            localBaseSmallView = d.this.HeX.getCurrentView();
            if (localBaseSmallView == null) {
              break label65;
            }
          }
          label65:
          for (boolean bool = localBaseSmallView.eoK();; bool = false)
          {
            if (bool) {
              h.RTc.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184070);
                  d.this.rX(true);
                  AppMethodBeat.o(184070);
                }
              }, 2000L);
            }
            AppMethodBeat.o(184071);
            return;
          }
        }
      });
      AppMethodBeat.o(184082);
      return;
    }
    rX(true);
    AppMethodBeat.o(184082);
  }
  
  public final void rX(boolean paramBoolean)
  {
    AppMethodBeat.i(184084);
    Log.i("MicroMsg.VoipVoiceMiniManager", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.HeX });
    if (this.HeX != null)
    {
      if (paramBoolean) {
        a.a.GST.b(this.HeX);
      }
      if (this.HeX != null)
      {
        this.HeX.setOnClickListener(null);
        this.HeX = null;
        AppMethodBeat.o(184084);
      }
    }
    else if (paramBoolean)
    {
      a.a.GST.cir();
    }
    AppMethodBeat.o(184084);
  }
  
  public final void setVoicePlayDevice(final int paramInt)
  {
    AppMethodBeat.i(184083);
    if ((this.HeX != null) && (!this.zTO))
    {
      h.RTc.bqo("showIcon");
      h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184075);
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184074);
              if ((d.this.HeX != null) && (!d.this.zTO)) {
                d.this.HeX.setVoicePlayDevice(d.5.this.Hfe);
              }
              AppMethodBeat.o(184074);
            }
          });
          AppMethodBeat.o(184075);
        }
      }, "showIcon");
    }
    AppMethodBeat.o(184083);
  }
  
  public final void xm(final boolean paramBoolean)
  {
    AppMethodBeat.i(235781);
    if ((this.HeX != null) && (!this.zTO))
    {
      h.RTc.bqo("showIcon");
      h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184077);
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184076);
              if ((d.this.HeX != null) && (!d.this.zTO))
              {
                Object localObject = d.this.HeX;
                boolean bool = d.6.this.xyj;
                localObject = ((VoipViewFragment)localObject).getCurrentView();
                if (localObject != null)
                {
                  ((BaseSmallView)localObject).xm(bool);
                  AppMethodBeat.o(184076);
                  return;
                }
              }
              AppMethodBeat.o(184076);
            }
          });
          AppMethodBeat.o(184077);
        }
      }, "showIcon");
    }
    AppMethodBeat.o(235781);
  }
  
  public final void xv(int paramInt)
  {
    AppMethodBeat.i(184080);
    if (this.HeX != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.HeX.aGy(str);
    }
    AppMethodBeat.o(184080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d
 * JD-Core Version:    0.7.0.1
 */