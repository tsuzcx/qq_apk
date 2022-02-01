package com.tencent.mm.plugin.patmsg.ui;

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
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.a.d;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public final class a
{
  private static final int wVF;
  private aq gKO;
  com.tencent.mm.plugin.patmsg.a.c wVG;
  d wVH;
  View.OnClickListener wVI;
  private com.tencent.mm.plugin.patmsg.b.c wVb;
  
  static
  {
    AppMethodBeat.i(220381);
    wVF = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPN, ViewConfiguration.getDoubleTapTimeout());
    AppMethodBeat.o(220381);
  }
  
  public a()
  {
    AppMethodBeat.i(220375);
    this.wVI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220368);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        a.a(a.this).sendMessageAtFrontOfQueue(a.a(a.this).obtainMessage(290, paramAnonymousView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220368);
      }
    };
    this.gKO = new aq(Looper.getMainLooper())
    {
      private long ndi = 0L;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool2 = false;
        AppMethodBeat.i(220369);
        ae.d("MicroMsg.PatHandler", "click msg %d", new Object[] { Integer.valueOf(paramAnonymousMessage.what) });
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(220369);
          return;
          long l = System.currentTimeMillis();
          if ((this.ndi > 0L) && (l - this.ndi < a.wVF))
          {
            ae.d("MicroMsg.PatHandler", "double click");
            removeMessages(291);
            sendMessage(a.a(a.this).obtainMessage(292, paramAnonymousMessage.obj));
          }
          for (;;)
          {
            this.ndi = l;
            AppMethodBeat.o(220369);
            return;
            sendMessageDelayed(a.a(a.this).obtainMessage(291, paramAnonymousMessage.obj), a.wVF);
          }
          if ((a.b(a.this) != null) && (a.b(a.this).getOnClickListener() != null)) {
            a.b(a.this).getOnClickListener().onClick((View)paramAnonymousMessage.obj);
          }
          this.ndi = 0L;
          AppMethodBeat.o(220369);
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
          this.ndi = 0L;
          AppMethodBeat.o(220369);
          return;
          a.d(a.this).dBE();
        }
      }
    };
    AppMethodBeat.o(220375);
  }
  
  private boolean Nd(int paramInt)
  {
    AppMethodBeat.i(220378);
    if ((((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).isRevokePatMsgEnable()) && (com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.Jex, true)))
    {
      if ((paramInt == 5) && (com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.Jeu, true))) {}
      for (String str = ak.getResources().getString(2131767131);; str = ak.getResources().getString(2131767134))
      {
        iB(str, ak.getResources().getString(2131767135, new Object[] { Integer.valueOf(2) }));
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jex, Boolean.FALSE);
        if (paramInt == 5) {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jeu, Boolean.FALSE);
        }
        AppMethodBeat.o(220378);
        return true;
      }
    }
    if ((paramInt == 5) && (com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.Jeu, true)))
    {
      iB(ak.getResources().getString(2131766950), ak.getResources().getString(2131766949));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jeu, Boolean.FALSE);
      AppMethodBeat.o(220378);
      return true;
    }
    AppMethodBeat.o(220378);
    return false;
  }
  
  private void iB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220379);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(((View)this.wVG).getContext());
    localg.agc(2131496483);
    TextView localTextView = (TextView)localg.kFh.findViewById(2131308405);
    ((TextView)localg.kFh.findViewById(2131308406)).setText(paramString1);
    localTextView.setText(paramString2);
    ((Button)localg.kFh.findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220370);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        localg.bqD();
        a.e(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220370);
      }
    });
    localg.cPF();
    AppMethodBeat.o(220379);
  }
  
  public final void dBF()
  {
    AppMethodBeat.i(220376);
    ae.d("MicroMsg.PatHandler", "onDetachPatMsgView");
    this.gKO.removeMessages(292);
    this.wVb = null;
    AppMethodBeat.o(220376);
  }
  
  public final void dBG()
  {
    AppMethodBeat.i(220377);
    ae.d("MicroMsg.PatHandler", "onDetachPatTipView");
    this.gKO.removeMessages(293);
    AppMethodBeat.o(220377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.a
 * JD-Core Version:    0.7.0.1
 */