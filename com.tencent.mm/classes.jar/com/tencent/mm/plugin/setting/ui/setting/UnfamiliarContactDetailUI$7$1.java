package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import java.util.LinkedList;

final class UnfamiliarContactDetailUI$7$1
  implements DialogInterface.OnClickListener
{
  UnfamiliarContactDetailUI$7$1(UnfamiliarContactDetailUI.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127640);
    if (UnfamiliarContactDetailUI.h(this.qLl.qLi) != null)
    {
      g.RM();
      g.RK().eHt.a(681, UnfamiliarContactDetailUI.h(this.qLl.qLi));
      paramDialogInterface = UnfamiliarContactDetailUI.h(this.qLl.qLi);
      paramDialogInterface.index = 0;
      paramDialogInterface.oDT = 0;
      paramDialogInterface.qLy = 0;
      paramDialogInterface.qLz.clear();
      paramDialogInterface.qLA.clear();
      d.ysm.remove(paramDialogInterface);
      if (paramDialogInterface.qLw != null) {
        paramDialogInterface.qLw.ckL();
      }
      d.post(paramDialogInterface, "delete_contact_task");
    }
    UnfamiliarContactDetailUI.b(this.qLl.qLi, false);
    AppMethodBeat.o(127640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.7.1
 * JD-Core Version:    0.7.0.1
 */