package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class NearbyFriendsIntroUI$1$1
  implements DialogInterface.OnClickListener
{
  NearbyFriendsIntroUI$1$1(NearbyFriendsIntroUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(55434);
    g.RL().Ru().set(4103, Boolean.TRUE);
    paramDialogInterface = g.RL().Ru();
    boolean bool;
    if (!NearbyFriendsIntroUI.c(this.pcU.pcT).isChecked())
    {
      bool = true;
      paramDialogInterface.set(4104, Boolean.valueOf(bool));
      paramDialogInterface = bp.abb();
      if (paramDialogInterface != null) {
        break label111;
      }
      this.pcU.pcT.startActivity(new Intent(this.pcU.pcT, NearbyPersonalInfoUI.class));
    }
    for (;;)
    {
      this.pcU.pcT.finish();
      AppMethodBeat.o(55434);
      return;
      bool = false;
      break;
      label111:
      String str = bo.nullAsNil(paramDialogInterface.getProvince());
      bo.nullAsNil(paramDialogInterface.getCity());
      paramInt = bo.a(Integer.valueOf(paramDialogInterface.dqC), 0);
      if ((str.equals("")) || (paramInt == 0)) {
        this.pcU.pcT.startActivity(new Intent(this.pcU.pcT, NearbyPersonalInfoUI.class));
      } else {
        this.pcU.pcT.startActivity(new Intent(this.pcU.pcT, NearbyFriendsUI.class));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.1.1
 * JD-Core Version:    0.7.0.1
 */