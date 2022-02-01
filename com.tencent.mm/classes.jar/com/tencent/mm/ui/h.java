package com.tencent.mm.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.l;

public final class h
{
  public static void c(final Context paramContext, final Runnable paramRunnable)
  {
    AppMethodBeat.i(197414);
    if (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VDE, true))
    {
      l locall = new l(paramContext);
      locall.byC(paramContext.getString(R.l.main_conversation_dismiss_intro_title)).byD(paramContext.getString(R.l.main_conversation_dismiss_intro_tips)).h(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255746);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/ui/DismissConversationHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.GKO.bYF();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDE, Boolean.FALSE);
          h.d(paramContext, paramRunnable);
          a.a(this, "com/tencent/mm/ui/DismissConversationHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255746);
        }
      });
      locall.eik();
      AppMethodBeat.o(197414);
      return;
    }
    d(paramContext, paramRunnable);
    AppMethodBeat.o(197414);
  }
  
  static void d(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(197417);
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.main_conversation_dismiss_confirm), "", paramContext.getString(R.l.main_conversation_dismiss_confirm_ok), paramContext.getString(R.l.app_cancel), new h.2(paramRunnable, paramContext), null, R.e.alert_btn_color_warn);
    AppMethodBeat.o(197417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */