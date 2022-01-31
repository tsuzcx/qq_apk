package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

final class UnfamiliarContactDetailUI$6
  implements UnfamiliarContactDetailUI.g
{
  UnfamiliarContactDetailUI$6(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void bzB()
  {
    UnfamiliarContactDetailUI.c(this.nWX, true);
  }
  
  public final void dK(int paramInt1, int paramInt2)
  {
    UnfamiliarContactDetailUI.f.nXv += paramInt1;
    UnfamiliarContactDetailUI.c(this.nWX, false);
    UnfamiliarContactDetailUI.g(this.nWX).setText(this.nWX.getString(a.i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.f(this.nWX).size() + ")");
    if (UnfamiliarContactDetailUI.e(this.nWX) != null) {
      UnfamiliarContactDetailUI.e(this.nWX).agL.notifyChanged();
    }
    if (paramInt2 < paramInt1)
    {
      y.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      h.b(this.nWX.mController.uMN, this.nWX.getString(a.i.unfamiliar_contact_delete_err, new Object[] { Integer.valueOf(paramInt1 - paramInt2) }), "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.6
 * JD-Core Version:    0.7.0.1
 */