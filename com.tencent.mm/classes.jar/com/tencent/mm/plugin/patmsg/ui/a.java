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
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.a.d;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public final class a
{
  private static final int wFT;
  private ap gIf;
  com.tencent.mm.plugin.patmsg.a.c wFU;
  d wFV;
  View.OnClickListener wFW;
  private com.tencent.mm.plugin.patmsg.b.c wFq;
  
  static
  {
    AppMethodBeat.i(215748);
    wFT = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIg, ViewConfiguration.getDoubleTapTimeout());
    AppMethodBeat.o(215748);
  }
  
  public a()
  {
    AppMethodBeat.i(215741);
    this.wFW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215734);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        a.a(a.this).sendMessageAtFrontOfQueue(a.a(a.this).obtainMessage(290, paramAnonymousView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215734);
      }
    };
    this.gIf = new ap(Looper.getMainLooper())
    {
      private long mYb = 0L;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool2 = false;
        AppMethodBeat.i(215735);
        ad.d("MicroMsg.PatHandler", "click msg %d", new Object[] { Integer.valueOf(paramAnonymousMessage.what) });
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(215735);
          return;
          long l = System.currentTimeMillis();
          if ((this.mYb > 0L) && (l - this.mYb < a.wFT))
          {
            ad.d("MicroMsg.PatHandler", "double click");
            removeMessages(291);
            sendMessage(a.a(a.this).obtainMessage(292, paramAnonymousMessage.obj));
          }
          for (;;)
          {
            this.mYb = l;
            AppMethodBeat.o(215735);
            return;
            sendMessageDelayed(a.a(a.this).obtainMessage(291, paramAnonymousMessage.obj), a.wFT);
          }
          if ((a.b(a.this) != null) && (a.b(a.this).getOnClickListener() != null)) {
            a.b(a.this).getOnClickListener().onClick((View)paramAnonymousMessage.obj);
          }
          this.mYb = 0L;
          AppMethodBeat.o(215735);
          return;
          boolean bool1 = bool2;
          if (a.b(a.this) != null)
          {
            bool1 = bool2;
            if (a.b(a.this).getDoubleClickListener() != null) {
              bool1 = a.b(a.this).getDoubleClickListener().ex((View)paramAnonymousMessage.obj);
            }
          }
          if ((!bool1) && (a.b(a.this) != null)) {
            a.c(a.this);
          }
          this.mYb = 0L;
          AppMethodBeat.o(215735);
          return;
          a.d(a.this).dyo();
        }
      }
    };
    AppMethodBeat.o(215741);
  }
  
  private boolean amh(int paramInt)
  {
    AppMethodBeat.i(221257);
    if ((((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).isRevokePatMsgEnable()) && (com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IJQ, true)))
    {
      if ((paramInt == 5) && (com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IJO, true))) {}
      for (String str = aj.getResources().getString(2131767131);; str = aj.getResources().getString(2131767134))
      {
        iv(str, aj.getResources().getString(2131767135, new Object[] { Integer.valueOf(2) }));
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJQ, Boolean.FALSE);
        if (paramInt == 5) {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJO, Boolean.FALSE);
        }
        AppMethodBeat.o(221257);
        return true;
      }
    }
    if ((paramInt == 5) && (com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IJO, true)))
    {
      iv(aj.getResources().getString(2131766950), aj.getResources().getString(2131766949));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJO, Boolean.FALSE);
      AppMethodBeat.o(221257);
      return true;
    }
    AppMethodBeat.o(221257);
    return false;
  }
  
  private void iv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215744);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(((View)this.wFU).getContext());
    localg.aft(2131496483);
    TextView localTextView = (TextView)localg.kBS.findViewById(2131308405);
    ((TextView)localg.kBS.findViewById(2131308406)).setText(paramString1);
    localTextView.setText(paramString2);
    ((Button)localg.kBS.findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215736);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        localg.bpT();
        a.e(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215736);
      }
    });
    localg.cMW();
    AppMethodBeat.o(215744);
  }
  
  public final void dyp()
  {
    AppMethodBeat.i(215742);
    ad.d("MicroMsg.PatHandler", "onDetachPatMsgView");
    this.gIf.removeMessages(292);
    this.wFq = null;
    AppMethodBeat.o(215742);
  }
  
  public final void dyq()
  {
    AppMethodBeat.i(215743);
    ad.d("MicroMsg.PatHandler", "onDetachPatTipView");
    this.gIf.removeMessages(293);
    AppMethodBeat.o(215743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.a
 * JD-Core Version:    0.7.0.1
 */