package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c;

final class NearbyFriendsIntroUI$1
  implements View.OnClickListener
{
  NearbyFriendsIntroUI$1(NearbyFriendsIntroUI paramNearbyFriendsIntroUI) {}
  
  public final void onClick(View paramView)
  {
    if (NearbyFriendsIntroUI.a(this.mCZ) == null)
    {
      NearbyFriendsIntroUI.a(this.mCZ, h.a(this.mCZ.mController.uMN, this.mCZ.getString(b.h.app_tip), NearbyFriendsIntroUI.b(this.mCZ), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          boolean bool = true;
          g.DP().Dz().o(4103, Boolean.valueOf(true));
          paramAnonymousDialogInterface = g.DP().Dz();
          if (!NearbyFriendsIntroUI.c(NearbyFriendsIntroUI.1.this.mCZ).isChecked())
          {
            paramAnonymousDialogInterface.o(4104, Boolean.valueOf(bool));
            paramAnonymousDialogInterface = bn.Ie();
            if (paramAnonymousDialogInterface != null) {
              break label102;
            }
            NearbyFriendsIntroUI.1.this.mCZ.startActivity(new Intent(NearbyFriendsIntroUI.1.this.mCZ, NearbyPersonalInfoUI.class));
          }
          for (;;)
          {
            NearbyFriendsIntroUI.1.this.mCZ.finish();
            return;
            bool = false;
            break;
            label102:
            String str = bk.pm(paramAnonymousDialogInterface.getProvince());
            bk.pm(paramAnonymousDialogInterface.getCity());
            paramAnonymousInt = bk.a(Integer.valueOf(paramAnonymousDialogInterface.sex), 0);
            if ((str.equals("")) || (paramAnonymousInt == 0)) {
              NearbyFriendsIntroUI.1.this.mCZ.startActivity(new Intent(NearbyFriendsIntroUI.1.this.mCZ, NearbyPersonalInfoUI.class));
            } else {
              NearbyFriendsIntroUI.1.this.mCZ.startActivity(new Intent(NearbyFriendsIntroUI.1.this.mCZ, NearbyFriendsUI.class));
            }
          }
        }
      }, null));
      return;
    }
    NearbyFriendsIntroUI.a(this.mCZ).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.1
 * JD-Core Version:    0.7.0.1
 */