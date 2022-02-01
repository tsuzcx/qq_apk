package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.o;

public final class h
{
  public static void c(final Context paramContext, final Runnable paramRunnable)
  {
    AppMethodBeat.i(249348);
    if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgB, true))
    {
      o localo = new o(paramContext);
      localo.bAc(paramContext.getString(R.l.main_conversation_dismiss_intro_title)).bAd(paramContext.getString(R.l.main_conversation_dismiss_intro_tips)).i(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(249441);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/DismissConversationHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          h.this.cyW();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adgB, Boolean.FALSE);
          h.d(paramContext, paramRunnable);
          a.a(this, "com/tencent/mm/ui/DismissConversationHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249441);
        }
      });
      localo.dDn();
      AppMethodBeat.o(249348);
      return;
    }
    d(paramContext, paramRunnable);
    AppMethodBeat.o(249348);
  }
  
  static void d(final Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(249352);
    k.a(paramContext, paramContext.getString(R.l.main_conversation_dismiss_confirm), "", paramContext.getString(R.l.main_conversation_dismiss_confirm_ok), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(249437);
        h.this.run();
        if (aw.jkS())
        {
          paramAnonymousDialogInterface = new Intent();
          c.g(paramContext, ".ui.EmptyActivity", paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(249437);
      }
    }, null, R.e.alert_btn_color_warn);
    AppMethodBeat.o(249352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */