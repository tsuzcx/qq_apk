package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.mc;
import com.tencent.mm.autogen.mmdata.rpt.mt;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.d;
import com.tencent.mm.plugin.patmsg.d.b;
import com.tencent.mm.plugin.patmsg.d.f;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.util.g;

public final class a
{
  private static final int MHD;
  private com.tencent.mm.plugin.patmsg.b.c MGX;
  com.tencent.mm.plugin.patmsg.a.c MHE;
  d MHF;
  View.OnClickListener MHG;
  private MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(266446);
    MHD = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zqQ, ViewConfiguration.getDoubleTapTimeout());
    AppMethodBeat.o(266446);
  }
  
  public a()
  {
    AppMethodBeat.i(266383);
    this.MHG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(266410);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.a(a.this).sendMessageAtFrontOfQueue(a.a(a.this).obtainMessage(290, paramAnonymousView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(266410);
      }
    };
    this.mRi = new MMHandler(Looper.getMainLooper())
    {
      private long lastClickTime = 0L;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool2 = false;
        AppMethodBeat.i(266420);
        Log.i("MicroMsg.PatHandler", "click msg %d", new Object[] { Integer.valueOf(paramAnonymousMessage.what) });
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(266420);
          return;
          long l = System.currentTimeMillis();
          if ((this.lastClickTime > 0L) && (l - this.lastClickTime < a.MHD))
          {
            Log.i("MicroMsg.PatHandler", "double click");
            removeMessages(291);
            sendMessage(a.a(a.this).obtainMessage(292, paramAnonymousMessage.obj));
          }
          for (;;)
          {
            this.lastClickTime = l;
            AppMethodBeat.o(266420);
            return;
            sendMessageDelayed(a.a(a.this).obtainMessage(291, paramAnonymousMessage.obj), a.MHD);
          }
          if ((a.b(a.this) != null) && (a.b(a.this).getOnClickListener() != null))
          {
            Log.i("MicroMsg.PatHandler", "single click");
            a.b(a.this).getOnClickListener().onClick((View)paramAnonymousMessage.obj);
          }
          this.lastClickTime = 0L;
          AppMethodBeat.o(266420);
          return;
          boolean bool1 = bool2;
          if (a.b(a.this) != null)
          {
            bool1 = bool2;
            if (a.b(a.this).getDoubleClickListener() != null) {
              bool1 = a.b(a.this).getDoubleClickListener().iA((View)paramAnonymousMessage.obj);
            }
          }
          if ((!bool1) && (a.b(a.this) != null)) {
            a.c(a.this);
          }
          this.lastClickTime = 0L;
          AppMethodBeat.o(266420);
          return;
          a.d(a.this).gxK();
        }
      }
    };
    AppMethodBeat.o(266383);
  }
  
  private boolean afr(int paramInt)
  {
    AppMethodBeat.i(266397);
    if ((((PluginPatMsg)h.az(PluginPatMsg.class)).isRevokePatMsgEnable()) && (h.baE().ban().getBoolean(at.a.adgv, true)))
    {
      if ((paramInt == 5) && (h.baE().ban().getBoolean(at.a.adgs, true))) {}
      for (String str = MMApplicationContext.getResources().getString(d.f.revoke_pat_avatar_tip);; str = MMApplicationContext.getResources().getString(d.f.revoke_send_pat_msg))
      {
        kR(str, MMApplicationContext.getResources().getString(d.f.revoke_send_pat_msg_hint, new Object[] { Integer.valueOf(2) }));
        h.baE().ban().set(at.a.adgv, Boolean.FALSE);
        if (paramInt == 5) {
          h.baE().ban().set(at.a.adgs, Boolean.FALSE);
        }
        AppMethodBeat.o(266397);
        return true;
      }
    }
    if ((paramInt == 5) && (h.baE().ban().getBoolean(at.a.adgs, true)))
    {
      kR(MMApplicationContext.getResources().getString(d.f.profile_pat_avatar_tip), MMApplicationContext.getResources().getString(d.f.profile_pat_avatar_hint));
      h.baE().ban().set(at.a.adgs, Boolean.FALSE);
      AppMethodBeat.o(266397);
      return true;
    }
    AppMethodBeat.o(266397);
    return false;
  }
  
  private void kR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266404);
    final o localo = new o(((View)this.MHE).getContext());
    localo.bAc(paramString1).bAd(paramString2).i(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(266418);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        localo.cyW();
        a.e(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(266418);
      }
    });
    localo.dDn();
    AppMethodBeat.o(266404);
  }
  
  public final void gxL()
  {
    AppMethodBeat.i(266449);
    Log.d("MicroMsg.PatHandler", "onDetachPatMsgView");
    this.mRi.removeMessages(292);
    this.MGX = null;
    AppMethodBeat.o(266449);
  }
  
  public final void gxM()
  {
    AppMethodBeat.i(266452);
    Log.d("MicroMsg.PatHandler", "onDetachPatTipView");
    this.mRi.removeMessages(293);
    AppMethodBeat.o(266452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.a
 * JD-Core Version:    0.7.0.1
 */