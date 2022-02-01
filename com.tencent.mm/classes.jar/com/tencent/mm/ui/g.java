package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;

public final class g
{
  public static void c(final Context paramContext, final Runnable paramRunnable)
  {
    AppMethodBeat.i(232469);
    if (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Ool, true))
    {
      k localk = new k(paramContext);
      localk.bmc(paramContext.getString(2131762833)).bmd(paramContext.getString(2131762832)).g(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(232467);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/DismissConversationHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.ARD.bMo();
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ool, Boolean.FALSE);
          g.d(paramContext, paramRunnable);
          a.a(this, "com/tencent/mm/ui/DismissConversationHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(232467);
        }
      });
      localk.dGm();
      AppMethodBeat.o(232469);
      return;
    }
    d(paramContext, paramRunnable);
    AppMethodBeat.o(232469);
  }
  
  static void d(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(232470);
    h.a(paramContext, paramContext.getString(2131762830), "", paramContext.getString(2131762831), paramContext.getString(2131755761), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(232468);
        this.OAp.run();
        AppMethodBeat.o(232468);
      }
    }, null, 2131099922);
    AppMethodBeat.o(232470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.g
 * JD-Core Version:    0.7.0.1
 */