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
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public final class d
{
  public static final int vaH;
  public static final int vaJ;
  public static final int vat;
  private au AKA;
  public boolean AKB = false;
  public BaseSmallView AKy;
  private a AKz;
  public Intent intent;
  
  static
  {
    AppMethodBeat.i(184086);
    vat = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
    vaJ = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 96);
    vaH = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 76);
    AppMethodBeat.o(184086);
  }
  
  private void a(final Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184079);
    ac.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.AKy != null) {
      qD(false);
    }
    Context localContext;
    if (this.AKy == null)
    {
      if (!paramBoolean1) {
        break label167;
      }
      if (com.tencent.mm.plugin.voip.b.f.elM())
      {
        localContext = ai.getContext();
        com.tencent.mm.plugin.voip.c.ehb();
        this.AKy = new com.tencent.mm.plugin.voip.widget.a(localContext, u.sG(false));
        this.AKB = false;
      }
    }
    else
    {
      if (this.AKA != null) {
        this.AKA.stopTimer();
      }
      this.AKy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184069);
          paramAnonymousView.setOnClickListener(null);
          paramIntent.addFlags(268435456);
          paramAnonymousView = ai.getContext();
          Object localObject = paramIntent;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          d.a(d.this, new au(new au.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(184067);
              ac.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
              d.this.qD(false);
              if (d.a(d.this) != null) {
                d.a(d.this).stopTimer();
              }
              AppMethodBeat.o(184067);
              return true;
            }
          }, false));
          d.a(d.this).au(2000L, 2000L);
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184068);
              d.this.qD(false);
              AppMethodBeat.o(184068);
            }
          }, 200L);
          AppMethodBeat.o(184069);
        }
      });
      if (!paramBoolean1) {
        break label184;
      }
      a.a.Ayb.a(4, paramBoolean2, this.AKy);
    }
    for (;;)
    {
      this.AKz.a(paramIntent, this.AKy);
      AppMethodBeat.o(184079);
      return;
      localContext = ai.getContext();
      com.tencent.mm.plugin.voip.c.ehb();
      this.AKy = new com.tencent.mm.plugin.voip.widget.c(localContext, u.sG(false));
      break;
      label167:
      this.AKy = new f(ai.getContext());
      break;
      label184:
      a.a.Ayb.a(8, paramBoolean2, this.AKy);
    }
  }
  
  public final void a(final Intent paramIntent, final boolean paramBoolean1, final boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(184078);
    if (parama == null)
    {
      ac.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
      AppMethodBeat.o(184078);
      return;
    }
    this.intent = paramIntent;
    this.AKz = parama;
    if (!b.cc(ai.getContext()))
    {
      ac.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = ai.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131764858), new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184065);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          if (parama.cTY()) {
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
      }, com.tencent.mm.bq.a.Zb());
      AppMethodBeat.o(184078);
      return;
    }
    a(paramIntent, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(184078);
  }
  
  public final void ayB(String paramString)
  {
    AppMethodBeat.i(208471);
    if (this.AKy != null) {
      this.AKy.ayB(paramString);
    }
    AppMethodBeat.o(208471);
  }
  
  public final void ayC(String paramString)
  {
    AppMethodBeat.i(184081);
    if (this.AKy != null) {
      this.AKy.ayC(paramString);
    }
    AppMethodBeat.o(184081);
  }
  
  public final void elp()
  {
    AppMethodBeat.i(184082);
    if (this.AKy != null)
    {
      this.AKB = true;
      h.JZN.aTz("showIcon");
      h.JZN.aQ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184071);
          if (d.b(d.this) != null)
          {
            d.b(d.this).ely();
            h.JZN.p(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(184070);
                d.this.qD(true);
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
    qD(true);
    AppMethodBeat.o(184082);
  }
  
  public final void qD(boolean paramBoolean)
  {
    AppMethodBeat.i(184084);
    ac.i("MicroMsg.VoipVoiceMiniManager", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.AKy });
    if (this.AKy != null)
    {
      if (paramBoolean) {
        a.a.Ayb.a(this.AKy);
      }
      if (this.AKy != null)
      {
        this.AKy.setOnClickListener(null);
        this.AKy = null;
        AppMethodBeat.o(184084);
      }
    }
    else if (paramBoolean)
    {
      a.a.Ayb.bGp();
    }
    AppMethodBeat.o(184084);
  }
  
  public final void sQ(int paramInt)
  {
    AppMethodBeat.i(184080);
    if (this.AKy != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.AKy.ayB(str);
    }
    AppMethodBeat.o(184080);
  }
  
  public final void setVoicePlayDevice(final int paramInt)
  {
    AppMethodBeat.i(184083);
    if ((this.AKy != null) && (!this.AKB))
    {
      h.JZN.aTz("showIcon");
      h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184075);
          h.JZN.aQ(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184074);
              if ((d.b(d.this) != null) && (!d.c(d.this))) {
                d.b(d.this).setVoicePlayDevice(d.5.this.AKI);
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