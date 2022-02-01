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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class d
{
  public VoipViewFragment CjA;
  private a CjB;
  av CjC;
  boolean CjD = false;
  public Intent intent;
  
  final void a(final Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184079);
    ad.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.CjA != null)
    {
      this.CjB.a(paramIntent, this.CjA.ay(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
    }
    this.CjA = new VoipViewFragment(aj.getContext());
    this.CjD = false;
    if (this.CjC != null) {
      this.CjC.stopTimer();
    }
    this.CjA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(184069);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView.setOnClickListener(null);
        paramIntent.addFlags(268435456);
        paramAnonymousView = aj.getContext();
        localObject = paramIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        d.this.CjC = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(184067);
            ad.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
            d.this.rf(false);
            if (d.this.CjC != null) {
              d.this.CjC.stopTimer();
            }
            AppMethodBeat.o(184067);
            return true;
          }
        }, false);
        d.this.CjC.az(2000L, 2000L);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(184068);
            d.this.rf(false);
            AppMethodBeat.o(184068);
          }
        }, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(184069);
      }
    });
    if (paramBoolean1) {
      a.a.BXw.a(4, paramBoolean2, this.CjA);
    }
    for (;;)
    {
      this.CjB.a(paramIntent, this.CjA.ay(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
      a.a.BXw.a(8, paramBoolean2, this.CjA);
    }
  }
  
  public final void a(final Intent paramIntent, final boolean paramBoolean1, final boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(184078);
    if (parama == null)
    {
      ad.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
      AppMethodBeat.o(184078);
      return;
    }
    this.intent = paramIntent;
    this.CjB = parama;
    if (!com.tencent.mm.compatible.d.b.ca(aj.getContext()))
    {
      ad.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = aj.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131764858), new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184065);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          if (parama.ddj()) {
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
      }, com.tencent.mm.br.a.abB());
      AppMethodBeat.o(184078);
      return;
    }
    a(paramIntent, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(184078);
  }
  
  public final void aDJ(String paramString)
  {
    AppMethodBeat.i(216510);
    if (this.CjA != null) {
      this.CjA.aDJ(paramString);
    }
    AppMethodBeat.o(216510);
  }
  
  public final void aDK(String paramString)
  {
    AppMethodBeat.i(184081);
    if (this.CjA != null) {
      this.CjA.aDK(paramString);
    }
    AppMethodBeat.o(184081);
  }
  
  public final BaseSmallView ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216513);
    if (this.CjA != null)
    {
      BaseSmallView localBaseSmallView = this.CjA.ay(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(216513);
      return localBaseSmallView;
    }
    AppMethodBeat.o(216513);
    return null;
  }
  
  public final void dqh()
  {
    AppMethodBeat.i(216511);
    if ((this.CjA != null) && (!this.CjD))
    {
      h.LTJ.aZz("showIcon");
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184073);
          h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184072);
              if ((d.this.CjA != null) && (!d.this.CjD))
              {
                BaseSmallView localBaseSmallView = d.this.CjA.getCurrentView();
                if (localBaseSmallView != null)
                {
                  localBaseSmallView.dqh();
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
    AppMethodBeat.o(216511);
  }
  
  public final void eyZ()
  {
    AppMethodBeat.i(184082);
    if (this.CjA != null)
    {
      this.CjD = true;
      h.LTJ.aZz("showIcon");
      h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184071);
          BaseSmallView localBaseSmallView;
          if (d.this.CjA != null)
          {
            localBaseSmallView = d.this.CjA.getCurrentView();
            if (localBaseSmallView == null) {
              break label65;
            }
          }
          label65:
          for (boolean bool = localBaseSmallView.ezi();; bool = false)
          {
            if (bool) {
              h.LTJ.q(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184070);
                  d.this.rf(true);
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
    rf(true);
    AppMethodBeat.o(184082);
  }
  
  public final void rf(boolean paramBoolean)
  {
    AppMethodBeat.i(184084);
    ad.i("MicroMsg.VoipVoiceMiniManager", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.CjA });
    if (this.CjA != null)
    {
      if (paramBoolean) {
        a.a.BXw.d(this.CjA);
      }
      if (this.CjA != null)
      {
        this.CjA.setOnClickListener(null);
        this.CjA = null;
        AppMethodBeat.o(184084);
      }
    }
    else if (paramBoolean)
    {
      a.a.BXw.bKA();
    }
    AppMethodBeat.o(184084);
  }
  
  public final void setVoicePlayDevice(final int paramInt)
  {
    AppMethodBeat.i(184083);
    if ((this.CjA != null) && (!this.CjD))
    {
      h.LTJ.aZz("showIcon");
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184075);
          h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184074);
              if ((d.this.CjA != null) && (!d.this.CjD)) {
                d.this.CjA.setVoicePlayDevice(d.5.this.CjK);
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
  
  public final void tt(int paramInt)
  {
    AppMethodBeat.i(184080);
    if (this.CjA != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.CjA.aDJ(str);
    }
    AppMethodBeat.o(184080);
  }
  
  public final void tv(final boolean paramBoolean)
  {
    AppMethodBeat.i(216512);
    if ((this.CjA != null) && (!this.CjD))
    {
      h.LTJ.aZz("showIcon");
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184077);
          h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184076);
              if ((d.this.CjA != null) && (!d.this.CjD))
              {
                Object localObject = d.this.CjA;
                boolean bool = d.6.this.tVb;
                localObject = ((VoipViewFragment)localObject).getCurrentView();
                if (localObject != null)
                {
                  ((BaseSmallView)localObject).tv(bool);
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
    AppMethodBeat.o(216512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d
 * JD-Core Version:    0.7.0.1
 */