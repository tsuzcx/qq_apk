package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.storage.aq;

final class FindMoreFriendsUI$28
  implements DialogInterface.OnClickListener
{
  FindMoreFriendsUI$28(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(250247);
    if (FindMoreFriendsUI.s(this.adyF) != null)
    {
      bh.bCz();
      paramDialogInterface = c.ban();
      if (FindMoreFriendsUI.s(this.adyF).isChecked()) {
        break label119;
      }
    }
    label119:
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.B(4104, Boolean.valueOf(bool));
      paramDialogInterface = (LauncherUI)this.adyF.getContext();
      if (paramDialogInterface != null) {
        paramDialogInterface.adBG.getMainTabUI().bzP("tab_find_friend");
      }
      paramDialogInterface = new Intent();
      ((cn)h.az(cn.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.jCp(), paramDialogInterface);
      com.tencent.mm.bp.a.aM(this.adyF.getContext(), paramDialogInterface);
      AppMethodBeat.o(250247);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.28
 * JD-Core Version:    0.7.0.1
 */