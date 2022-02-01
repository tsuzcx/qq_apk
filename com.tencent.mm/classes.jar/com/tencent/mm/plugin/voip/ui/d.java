package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public final class d
{
  public VoipViewFragment CBe;
  private a CBf;
  aw CBg;
  boolean CBh = false;
  public Intent intent;
  
  final void a(final Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184079);
    ae.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.CBe != null)
    {
      this.CBf.a(paramIntent, this.CBe.ax(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
    }
    this.CBe = new VoipViewFragment(ak.getContext());
    this.CBh = false;
    if (this.CBg != null) {
      this.CBg.stopTimer();
    }
    this.CBe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(184069);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView.setOnClickListener(null);
        paramIntent.addFlags(268435456);
        paramAnonymousView = ak.getContext();
        localObject = paramIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        d.this.CBg = new aw(new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(184067);
            ae.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
            d.this.rm(false);
            if (d.this.CBg != null) {
              d.this.CBg.stopTimer();
            }
            AppMethodBeat.o(184067);
            return true;
          }
        }, false);
        d.this.CBg.ay(2000L, 2000L);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(184068);
            d.this.rm(false);
            AppMethodBeat.o(184068);
          }
        }, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(184069);
      }
    });
    if (paramBoolean1) {
      a.a.CoX.a(4, paramBoolean2, this.CBe);
    }
    for (;;)
    {
      this.CBf.a(paramIntent, this.CBe.ax(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
      a.a.CoX.a(8, paramBoolean2, this.CBe);
    }
  }
  
  public final void a(final Intent paramIntent, final boolean paramBoolean1, final boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(184078);
    if (parama == null)
    {
      ae.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
      AppMethodBeat.o(184078);
      return;
    }
    this.intent = paramIntent;
    this.CBf = parama;
    if (!com.tencent.mm.compatible.d.b.cc(ak.getContext()))
    {
      ae.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = ak.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131764858), new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184065);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          if (parama.dgb()) {
            d.this.a(paramIntent, paramBoolean1, paramBoolean2);
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
      }, com.tencent.mm.bq.a.abK());
      AppMethodBeat.o(184078);
      return;
    }
    a(paramIntent, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(184078);
  }
  
  public final void aFc(String paramString)
  {
    AppMethodBeat.i(210189);
    if (this.CBe != null) {
      this.CBe.aFc(paramString);
    }
    AppMethodBeat.o(210189);
  }
  
  public final void aFd(String paramString)
  {
    AppMethodBeat.i(184081);
    if (this.CBe != null) {
      this.CBe.aFd(paramString);
    }
    AppMethodBeat.o(184081);
  }
  
  public final BaseSmallView ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210192);
    if (this.CBe != null)
    {
      BaseSmallView localBaseSmallView = this.CBe.ax(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(210192);
      return localBaseSmallView;
    }
    AppMethodBeat.o(210192);
    return null;
  }
  
  public final void dtu()
  {
    AppMethodBeat.i(210190);
    if ((this.CBe != null) && (!this.CBh))
    {
      h.MqF.bbc("showIcon");
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184073);
          h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184072);
              if ((d.this.CBe != null) && (!d.this.CBh))
              {
                BaseSmallView localBaseSmallView = d.this.CBe.getCurrentView();
                if (localBaseSmallView != null)
                {
                  localBaseSmallView.dtu();
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
    AppMethodBeat.o(210190);
  }
  
  public final void eCH()
  {
    AppMethodBeat.i(184082);
    if (this.CBe != null)
    {
      this.CBh = true;
      h.MqF.bbc("showIcon");
      h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184071);
          BaseSmallView localBaseSmallView;
          if (d.this.CBe != null)
          {
            localBaseSmallView = d.this.CBe.getCurrentView();
            if (localBaseSmallView == null) {
              break label65;
            }
          }
          label65:
          for (boolean bool = localBaseSmallView.eCQ();; bool = false)
          {
            if (bool) {
              h.MqF.q(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184070);
                  d.this.rm(true);
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
    rm(true);
    AppMethodBeat.o(184082);
  }
  
  public final void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(184084);
    ae.i("MicroMsg.VoipVoiceMiniManager", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.CBe });
    if (this.CBe != null)
    {
      if (paramBoolean) {
        a.a.CoX.d(this.CBe);
      }
      if (this.CBe != null)
      {
        this.CBe.setOnClickListener(null);
        this.CBe = null;
        AppMethodBeat.o(184084);
      }
    }
    else if (paramBoolean)
    {
      a.a.CoX.bLx();
    }
    AppMethodBeat.o(184084);
  }
  
  public final void setVoicePlayDevice(final int paramInt)
  {
    AppMethodBeat.i(184083);
    if ((this.CBe != null) && (!this.CBh))
    {
      h.MqF.bbc("showIcon");
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184075);
          h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184074);
              if ((d.this.CBe != null) && (!d.this.CBh)) {
                d.this.CBe.setVoicePlayDevice(d.5.this.CBo);
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
  
  public final void tC(final boolean paramBoolean)
  {
    AppMethodBeat.i(210191);
    if ((this.CBe != null) && (!this.CBh))
    {
      h.MqF.bbc("showIcon");
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184077);
          h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184076);
              if ((d.this.CBe != null) && (!d.this.CBh))
              {
                Object localObject = d.this.CBe;
                boolean bool = d.6.this.ufX;
                localObject = ((VoipViewFragment)localObject).getCurrentView();
                if (localObject != null)
                {
                  ((BaseSmallView)localObject).tC(bool);
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
    AppMethodBeat.o(210191);
  }
  
  public final void tx(int paramInt)
  {
    AppMethodBeat.i(184080);
    if (this.CBe != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.CBe.aFc(str);
    }
    AppMethodBeat.o(184080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d
 * JD-Core Version:    0.7.0.1
 */