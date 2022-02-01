package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.u;
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
  public static final int tRM;
  public static final int tSa;
  public static final int tSc;
  public Intent intent;
  public BaseSmallView zrN;
  private a zrO;
  private av zrP;
  public boolean zrQ = false;
  
  static
  {
    AppMethodBeat.i(184086);
    tRM = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8);
    tSc = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 96);
    tSa = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 76);
    AppMethodBeat.o(184086);
  }
  
  private void a(final Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184079);
    ad.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.zrN != null) {
      pE(false);
    }
    Context localContext;
    if (this.zrN == null)
    {
      if (!paramBoolean1) {
        break label167;
      }
      if (e.dWu())
      {
        localContext = aj.getContext();
        com.tencent.mm.plugin.voip.c.dRQ();
        this.zrN = new com.tencent.mm.plugin.voip.widget.a(localContext, u.rF(false));
        this.zrQ = false;
      }
    }
    else
    {
      if (this.zrP != null) {
        this.zrP.stopTimer();
      }
      this.zrN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184069);
          paramAnonymousView.setOnClickListener(null);
          paramIntent.addFlags(268435456);
          paramAnonymousView = aj.getContext();
          Object localObject = paramIntent;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          d.a(d.this, new av(new av.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(184067);
              ad.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
              d.this.pE(false);
              if (d.a(d.this) != null) {
                d.a(d.this).stopTimer();
              }
              AppMethodBeat.o(184067);
              return true;
            }
          }, false));
          d.a(d.this).av(2000L, 2000L);
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184068);
              d.this.pE(false);
              AppMethodBeat.o(184068);
            }
          }, 200L);
          AppMethodBeat.o(184069);
        }
      });
      if (!paramBoolean1) {
        break label184;
      }
      a.a.zfu.a(4, paramBoolean2, this.zrN);
    }
    for (;;)
    {
      this.zrO.a(paramIntent, this.zrN);
      AppMethodBeat.o(184079);
      return;
      localContext = aj.getContext();
      com.tencent.mm.plugin.voip.c.dRQ();
      this.zrN = new com.tencent.mm.plugin.voip.widget.c(localContext, u.rF(false));
      break;
      label167:
      this.zrN = new f(aj.getContext());
      break;
      label184:
      a.a.zfu.a(8, paramBoolean2, this.zrN);
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
    this.zrO = parama;
    if (!b.bZ(aj.getContext()))
    {
      ad.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = aj.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131764858), new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184065);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          if (parama.cGN()) {
            d.a(d.this, paramIntent, paramBoolean1, paramBoolean2);
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
      }, com.tencent.mm.br.a.Ye());
      AppMethodBeat.o(184078);
      return;
    }
    a(paramIntent, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(184078);
  }
  
  public final void atk(String paramString)
  {
    AppMethodBeat.i(192143);
    if (this.zrN != null) {
      this.zrN.atk(paramString);
    }
    AppMethodBeat.o(192143);
  }
  
  public final void atl(String paramString)
  {
    AppMethodBeat.i(184081);
    if (this.zrN != null) {
      this.zrN.atl(paramString);
    }
    AppMethodBeat.o(184081);
  }
  
  public final void dWd()
  {
    AppMethodBeat.i(184082);
    if (this.zrN != null)
    {
      this.zrQ = true;
      h.Iye.aNW("showIcon");
      h.Iye.aN(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184071);
          if (d.b(d.this) != null)
          {
            d.b(d.this).dWm();
            h.Iye.p(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(184070);
                d.this.pE(true);
                AppMethodBeat.o(184070);
              }
            }, 2000L);
          }
          AppMethodBeat.o(184071);
        }
      });
      AppMethodBeat.o(184082);
      return;
    }
    pE(true);
    AppMethodBeat.o(184082);
  }
  
  public final void pE(boolean paramBoolean)
  {
    AppMethodBeat.i(184084);
    ad.i("MicroMsg.VoipVoiceMiniManager", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.zrN });
    if (this.zrN != null)
    {
      if (paramBoolean) {
        a.a.zfu.a(this.zrN);
      }
      if (this.zrN != null)
      {
        this.zrN.setOnClickListener(null);
        this.zrN = null;
        AppMethodBeat.o(184084);
      }
    }
    else if (paramBoolean)
    {
      a.a.zfu.bzt();
    }
    AppMethodBeat.o(184084);
  }
  
  public final void sa(int paramInt)
  {
    AppMethodBeat.i(184080);
    if (this.zrN != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.zrN.atk(str);
    }
    AppMethodBeat.o(184080);
  }
  
  public final void setVoicePlayDevice(final int paramInt)
  {
    AppMethodBeat.i(184083);
    if ((this.zrN != null) && (!this.zrQ))
    {
      h.Iye.aNW("showIcon");
      h.Iye.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184075);
          h.Iye.aN(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184074);
              if ((d.b(d.this) != null) && (!d.c(d.this))) {
                d.b(d.this).setVoicePlayDevice(d.5.this.zrX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d
 * JD-Core Version:    0.7.0.1
 */