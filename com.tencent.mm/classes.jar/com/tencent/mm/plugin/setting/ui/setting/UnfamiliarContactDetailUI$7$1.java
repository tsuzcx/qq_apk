package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.e;
import java.util.LinkedList;

final class UnfamiliarContactDetailUI$7$1
  implements DialogInterface.OnClickListener
{
  UnfamiliarContactDetailUI$7$1(UnfamiliarContactDetailUI.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (UnfamiliarContactDetailUI.h(this.nXa.nWX) != null)
    {
      g.DQ();
      g.DO().dJT.a(681, UnfamiliarContactDetailUI.h(this.nXa.nWX));
      paramDialogInterface = UnfamiliarContactDetailUI.h(this.nXa.nWX);
      paramDialogInterface.index = 0;
      paramDialogInterface.mdx = 0;
      paramDialogInterface.nXo = 0;
      paramDialogInterface.nXp.clear();
      paramDialogInterface.nXq.clear();
      e.remove(paramDialogInterface);
      if (paramDialogInterface.nXm != null) {
        paramDialogInterface.nXm.bzB();
      }
      e.post(paramDialogInterface, "delete_contact_task");
    }
    UnfamiliarContactDetailUI.b(this.nXa.nWX, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.7.1
 * JD-Core Version:    0.7.0.1
 */