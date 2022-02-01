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
import com.tencent.mm.f.b.a.jq;
import com.tencent.mm.f.b.a.kc;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.a.d;
import com.tencent.mm.plugin.patmsg.d.f;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.util.g;

public final class a
{
  private static final int GKJ;
  com.tencent.mm.plugin.patmsg.a.c GKK;
  d GKL;
  View.OnClickListener GKM;
  private com.tencent.mm.plugin.patmsg.b.c GKi;
  private MMHandler knk;
  
  static
  {
    AppMethodBeat.i(186740);
    GKJ = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYa, ViewConfiguration.getDoubleTapTimeout());
    AppMethodBeat.o(186740);
  }
  
  public a()
  {
    AppMethodBeat.i(186716);
    this.GKM = new a.1(this);
    this.knk = new MMHandler(Looper.getMainLooper())
    {
      private long lastClickTime = 0L;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool2 = false;
        AppMethodBeat.i(186609);
        Log.i("MicroMsg.PatHandler", "click msg %d", new Object[] { Integer.valueOf(paramAnonymousMessage.what) });
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(186609);
          return;
          long l = System.currentTimeMillis();
          if ((this.lastClickTime > 0L) && (l - this.lastClickTime < a.GKJ))
          {
            Log.i("MicroMsg.PatHandler", "double click");
            removeMessages(291);
            sendMessage(a.a(a.this).obtainMessage(292, paramAnonymousMessage.obj));
          }
          for (;;)
          {
            this.lastClickTime = l;
            AppMethodBeat.o(186609);
            return;
            sendMessageDelayed(a.a(a.this).obtainMessage(291, paramAnonymousMessage.obj), a.GKJ);
          }
          if ((a.b(a.this) != null) && (a.b(a.this).getOnClickListener() != null))
          {
            Log.i("MicroMsg.PatHandler", "single click");
            a.b(a.this).getOnClickListener().onClick((View)paramAnonymousMessage.obj);
          }
          this.lastClickTime = 0L;
          AppMethodBeat.o(186609);
          return;
          boolean bool1 = bool2;
          if (a.b(a.this) != null)
          {
            bool1 = bool2;
            if (a.b(a.this).getDoubleClickListener() != null) {
              bool1 = a.b(a.this).getDoubleClickListener().fH((View)paramAnonymousMessage.obj);
            }
          }
          if ((!bool1) && (a.b(a.this) != null)) {
            a.c(a.this);
          }
          this.lastClickTime = 0L;
          AppMethodBeat.o(186609);
          return;
          a.d(a.this).fmW();
        }
      }
    };
    AppMethodBeat.o(186716);
  }
  
  private boolean aaY(int paramInt)
  {
    AppMethodBeat.i(186721);
    if ((((PluginPatMsg)h.ag(PluginPatMsg.class)).isRevokePatMsgEnable()) && (h.aHG().aHp().getBoolean(ar.a.VDy, true)))
    {
      if ((paramInt == 5) && (h.aHG().aHp().getBoolean(ar.a.VDv, true))) {}
      for (String str = MMApplicationContext.getResources().getString(d.f.revoke_pat_avatar_tip);; str = MMApplicationContext.getResources().getString(d.f.revoke_send_pat_msg))
      {
        jx(str, MMApplicationContext.getResources().getString(d.f.revoke_send_pat_msg_hint, new Object[] { Integer.valueOf(2) }));
        h.aHG().aHp().set(ar.a.VDy, Boolean.FALSE);
        if (paramInt == 5) {
          h.aHG().aHp().set(ar.a.VDv, Boolean.FALSE);
        }
        AppMethodBeat.o(186721);
        return true;
      }
    }
    if ((paramInt == 5) && (h.aHG().aHp().getBoolean(ar.a.VDv, true)))
    {
      jx(MMApplicationContext.getResources().getString(d.f.profile_pat_avatar_tip), MMApplicationContext.getResources().getString(d.f.profile_pat_avatar_hint));
      h.aHG().aHp().set(ar.a.VDv, Boolean.FALSE);
      AppMethodBeat.o(186721);
      return true;
    }
    AppMethodBeat.o(186721);
    return false;
  }
  
  private void jx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186725);
    final l locall = new l(((View)this.GKK).getContext());
    locall.byC(paramString1).byD(paramString2).h(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186555);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        locall.bYF();
        a.e(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186555);
      }
    });
    locall.eik();
    AppMethodBeat.o(186725);
  }
  
  public final void fmX()
  {
    AppMethodBeat.i(186718);
    Log.d("MicroMsg.PatHandler", "onDetachPatMsgView");
    this.knk.removeMessages(292);
    this.GKi = null;
    AppMethodBeat.o(186718);
  }
  
  public final void fmY()
  {
    AppMethodBeat.i(186720);
    Log.d("MicroMsg.PatHandler", "onDetachPatTipView");
    this.knk.removeMessages(293);
    AppMethodBeat.o(186720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.a
 * JD-Core Version:    0.7.0.1
 */