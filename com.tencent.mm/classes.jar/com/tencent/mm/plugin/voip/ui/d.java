package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.plugin.voip.b.g;
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
  private a Fzp;
  boolean Fzq = false;
  MTimerHandler Fzr;
  public VoipViewFragment NVO;
  private Intent intent;
  
  public final void AS(int paramInt)
  {
    AppMethodBeat.i(184080);
    if (this.NVO != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.NVO.aQN(str);
    }
    AppMethodBeat.o(184080);
  }
  
  public final void Be(final boolean paramBoolean)
  {
    AppMethodBeat.i(234236);
    if ((this.NVO != null) && (!this.Fzq))
    {
      com.tencent.e.h.ZvG.bDh("showIcon");
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184077);
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184076);
              if ((d.this.NVO != null) && (!d.this.Fzq))
              {
                Object localObject = d.this.NVO;
                boolean bool = d.6.this.val$show;
                localObject = ((VoipViewFragment)localObject).getCurrentView();
                if (localObject != null)
                {
                  ((BaseSmallView)localObject).Be(bool);
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
    AppMethodBeat.o(234236);
  }
  
  public final void a(final Intent paramIntent, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(234226);
    if (parama == null)
    {
      Log.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
      AppMethodBeat.o(234226);
      return;
    }
    this.intent = paramIntent;
    this.Fzp = parama;
    if (!com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = MMApplicationContext.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(b.g.voip_float_permission_alert_content), new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184065);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          if (parama.eIT()) {
            d.this.a(paramIntent, paramBoolean, this.NJc);
          }
          AppMethodBeat.o(184065);
        }
        
        public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184066);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(184066);
        }
        
        public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(185955);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(185955);
        }
      }, com.tencent.mm.bx.a.awc());
      AppMethodBeat.o(234226);
      return;
    }
    a(paramIntent, paramBoolean, false);
    AppMethodBeat.o(234226);
  }
  
  final void a(final Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184079);
    Log.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.NVO != null)
    {
      this.Fzp.a(paramIntent, this.NVO.aV(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
    }
    this.NVO = new VoipViewFragment(MMApplicationContext.getContext());
    this.Fzq = false;
    if (this.Fzr != null) {
      this.Fzr.stopTimer();
    }
    this.NVO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(184069);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = a.a.NJe;
        paramAnonymousView.rYE.rYs.opType = 3;
        ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).m(paramAnonymousView.rYE);
        paramIntent.addFlags(268435456);
        paramAnonymousView = MMApplicationContext.getContext();
        localObject = paramIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        d.this.Fzr = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(184067);
            Log.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
            d.this.ic(false);
            if (d.this.Fzr != null) {
              d.this.Fzr.stopTimer();
            }
            AppMethodBeat.o(184067);
            return true;
          }
        }, false);
        d.this.Fzr.startTimer(2000L);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(184068);
            d.this.ic(false);
            AppMethodBeat.o(184068);
          }
        }, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(184069);
      }
    });
    if (paramBoolean1) {
      a.a.NJe.a(4, paramBoolean2, this.NVO);
    }
    for (;;)
    {
      this.Fzp.a(paramIntent, this.NVO.aV(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
      a.a.NJe.a(8, paramBoolean2, this.NVO);
    }
  }
  
  public final void aQM(String paramString)
  {
    AppMethodBeat.i(184081);
    if (this.NVO != null) {
      this.NVO.aQM(paramString);
    }
    AppMethodBeat.o(184081);
  }
  
  public final void aQN(String paramString)
  {
    AppMethodBeat.i(234228);
    if (this.NVO != null) {
      this.NVO.aQN(paramString);
    }
    AppMethodBeat.o(234228);
  }
  
  public final BaseSmallView aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(234239);
    if (this.NVO != null)
    {
      BaseSmallView localBaseSmallView = this.NVO.aV(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(234239);
      return localBaseSmallView;
    }
    AppMethodBeat.o(234239);
    return null;
  }
  
  public final void eXH()
  {
    AppMethodBeat.i(234232);
    if ((this.NVO != null) && (!this.Fzq))
    {
      com.tencent.e.h.ZvG.bDh("showIcon");
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184073);
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184072);
              if ((d.this.NVO != null) && (!d.this.Fzq))
              {
                BaseSmallView localBaseSmallView = d.this.NVO.getCurrentView();
                if (localBaseSmallView != null)
                {
                  localBaseSmallView.eXH();
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
    AppMethodBeat.o(234232);
  }
  
  public final void eYE()
  {
    AppMethodBeat.i(184082);
    if (this.NVO != null)
    {
      this.Fzq = true;
      com.tencent.e.h.ZvG.bDh("showIcon");
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184071);
          BaseSmallView localBaseSmallView;
          if (d.this.NVO != null)
          {
            localBaseSmallView = d.this.NVO.getCurrentView();
            if (localBaseSmallView == null) {
              break label65;
            }
          }
          label65:
          for (boolean bool = localBaseSmallView.eYB();; bool = false)
          {
            if (bool) {
              com.tencent.e.h.ZvG.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184070);
                  d.this.ic(true);
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
    ic(true);
    AppMethodBeat.o(184082);
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(184084);
    Log.i("MicroMsg.VoipVoiceMiniManager", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.NVO });
    if (this.NVO != null)
    {
      if (paramBoolean) {
        a.a.NJe.b(this.NVO);
      }
      if (this.NVO != null)
      {
        this.NVO.setOnClickListener(null);
        this.NVO = null;
        AppMethodBeat.o(184084);
      }
    }
    else if (paramBoolean)
    {
      a.a.NJe.cvE();
    }
    AppMethodBeat.o(184084);
  }
  
  public final void setVoicePlayDevice(final int paramInt)
  {
    AppMethodBeat.i(184083);
    if ((this.NVO != null) && (!this.Fzq))
    {
      com.tencent.e.h.ZvG.bDh("showIcon");
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184075);
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184074);
              if ((d.this.NVO != null) && (!d.this.Fzq)) {
                d.this.NVO.setVoicePlayDevice(d.5.this.NVV);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d
 * JD-Core Version:    0.7.0.1
 */