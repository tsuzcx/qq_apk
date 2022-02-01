package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import java.util.LinkedList;

final class UnfamiliarContactDetailUI$7
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$7(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74577);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.ui.base.h.a(this.Dfg.getContext(), true, this.Dfg.getContext().getString(2131766909), this.Dfg.getContext().getString(2131757869), this.Dfg.getContext().getString(2131755778), this.Dfg.getContext().getString(2131755761), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74576);
        if (UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.7.this.Dfg) != null)
        {
          g.aAi();
          g.aAg().hqi.a(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.7.this.Dfg));
          paramAnonymousDialogInterface = UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.7.this.Dfg);
          paramAnonymousDialogInterface.index = 0;
          paramAnonymousDialogInterface.zqp = 0;
          paramAnonymousDialogInterface.Dfw = 0;
          paramAnonymousDialogInterface.Dfx.clear();
          paramAnonymousDialogInterface.Dfy.clear();
          paramAnonymousDialogInterface.cancel();
          if (paramAnonymousDialogInterface.Dfu != null) {
            paramAnonymousDialogInterface.Dfu.eTK();
          }
          com.tencent.f.h.RTc.aX(paramAnonymousDialogInterface);
        }
        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.7.this.Dfg, false);
        AppMethodBeat.o(74576);
      }
    }, null, 2131099922, 0);
    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(74577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.7
 * JD-Core Version:    0.7.0.1
 */