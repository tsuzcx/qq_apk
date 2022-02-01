package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;

final class a$3
  extends Preference
{
  a$3(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(199332);
    super.onBindView(paramView);
    if (this.Jtu != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199331);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          a.3.this.Jtu.dAh();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199331);
        }
      });
    }
    AppMethodBeat.o(199332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a.3
 * JD-Core Version:    0.7.0.1
 */