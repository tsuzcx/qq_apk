package com.tencent.mm.plugin.patmsg.ui;

import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.a.d;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;

public final class a
{
  private static final int ARy;
  private com.tencent.mm.plugin.patmsg.b.c AQX;
  d ARA;
  View.OnClickListener ARB;
  com.tencent.mm.plugin.patmsg.a.c ARz;
  private MMHandler hAk;
  
  static
  {
    AppMethodBeat.i(207003);
    ARy = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smY, ViewConfiguration.getDoubleTapTimeout());
    AppMethodBeat.o(207003);
  }
  
  public a()
  {
    AppMethodBeat.i(206997);
    this.ARB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(206990);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        a.a(a.this).sendMessageAtFrontOfQueue(a.a(a.this).obtainMessage(290, paramAnonymousView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206990);
      }
    };
    this.hAk = new MMHandler(Looper.getMainLooper())
    {
      private long lastClickTime = 0L;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool2 = false;
        AppMethodBeat.i(206991);
        Log.i("MicroMsg.PatHandler", "click msg %d", new Object[] { Integer.valueOf(paramAnonymousMessage.what) });
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(206991);
          return;
          long l = System.currentTimeMillis();
          if ((this.lastClickTime > 0L) && (l - this.lastClickTime < a.ARy))
          {
            Log.i("MicroMsg.PatHandler", "double click");
            removeMessages(291);
            sendMessage(a.a(a.this).obtainMessage(292, paramAnonymousMessage.obj));
          }
          for (;;)
          {
            this.lastClickTime = l;
            AppMethodBeat.o(206991);
            return;
            sendMessageDelayed(a.a(a.this).obtainMessage(291, paramAnonymousMessage.obj), a.ARy);
          }
          if ((a.b(a.this) != null) && (a.b(a.this).getOnClickListener() != null))
          {
            Log.i("MicroMsg.PatHandler", "single click");
            a.b(a.this).getOnClickListener().onClick((View)paramAnonymousMessage.obj);
          }
          this.lastClickTime = 0L;
          AppMethodBeat.o(206991);
          return;
          boolean bool1 = bool2;
          if (a.b(a.this) != null)
          {
            bool1 = bool2;
            if (a.b(a.this).getDoubleClickListener() != null) {
              bool1 = a.b(a.this).getDoubleClickListener().eF((View)paramAnonymousMessage.obj);
            }
          }
          if ((!bool1) && (a.b(a.this) != null)) {
            a.c(a.this);
          }
          this.lastClickTime = 0L;
          AppMethodBeat.o(206991);
          return;
          a.d(a.this).eBp();
        }
      }
    };
    AppMethodBeat.o(206997);
  }
  
  private boolean Un(int paramInt)
  {
    AppMethodBeat.i(207000);
    if ((((PluginPatMsg)g.ah(PluginPatMsg.class)).isRevokePatMsgEnable()) && (g.aAh().azQ().getBoolean(ar.a.Oof, true)))
    {
      if ((paramInt == 5) && (g.aAh().azQ().getBoolean(ar.a.Ooc, true))) {}
      for (String str = MMApplicationContext.getResources().getString(2131764639);; str = MMApplicationContext.getResources().getString(2131764645))
      {
        jm(str, MMApplicationContext.getResources().getString(2131764646, new Object[] { Integer.valueOf(2) }));
        g.aAh().azQ().set(ar.a.Oof, Boolean.FALSE);
        if (paramInt == 5) {
          g.aAh().azQ().set(ar.a.Ooc, Boolean.FALSE);
        }
        AppMethodBeat.o(207000);
        return true;
      }
    }
    if ((paramInt == 5) && (g.aAh().azQ().getBoolean(ar.a.Ooc, true)))
    {
      jm(MMApplicationContext.getResources().getString(2131764042), MMApplicationContext.getResources().getString(2131764041));
      g.aAh().azQ().set(ar.a.Ooc, Boolean.FALSE);
      AppMethodBeat.o(207000);
      return true;
    }
    AppMethodBeat.o(207000);
    return false;
  }
  
  private void jm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207001);
    final k localk = new k(((View)this.ARz).getContext());
    localk.bmc(paramString1).bmd(paramString2).g(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(206992);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        localk.bMo();
        a.e(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206992);
      }
    });
    localk.dGm();
    AppMethodBeat.o(207001);
  }
  
  public final void eBq()
  {
    AppMethodBeat.i(206998);
    Log.d("MicroMsg.PatHandler", "onDetachPatMsgView");
    this.hAk.removeMessages(292);
    this.AQX = null;
    AppMethodBeat.o(206998);
  }
  
  public final void eBr()
  {
    AppMethodBeat.i(206999);
    Log.d("MicroMsg.PatHandler", "onDetachPatTipView");
    this.hAk.removeMessages(293);
    AppMethodBeat.o(206999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.a
 * JD-Core Version:    0.7.0.1
 */