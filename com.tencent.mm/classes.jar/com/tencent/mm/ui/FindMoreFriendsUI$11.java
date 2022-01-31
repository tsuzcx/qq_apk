package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class FindMoreFriendsUI$11
  implements DialogInterface.OnClickListener
{
  FindMoreFriendsUI$11(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29221);
    if (FindMoreFriendsUI.t(this.yWI) != null)
    {
      aw.aaz();
      paramDialogInterface = c.Ru();
      if (FindMoreFriendsUI.t(this.yWI).isChecked()) {
        break label94;
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.set(4104, Boolean.valueOf(bool));
      paramDialogInterface = (LauncherUI)this.yWI.getContext();
      if (paramDialogInterface != null) {
        paramDialogInterface.yYT.getMainTabUI().atp("tab_find_friend");
      }
      a.fF(this.yWI.getContext());
      AppMethodBeat.o(29221);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.11
 * JD-Core Version:    0.7.0.1
 */