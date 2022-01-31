package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;

final class h$1
  implements ContactListExpandPreference.a
{
  h$1(h paramh) {}
  
  public final void JR() {}
  
  public final void iw(int paramInt) {}
  
  public final void ix(int paramInt)
  {
    AppMethodBeat.i(23532);
    if (this.pAg.pAf.Ma(paramInt))
    {
      String str = this.pAg.pAf.Mb(paramInt);
      if (bo.isNullOrNil(str))
      {
        AppMethodBeat.o(23532);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.setClass(this.pAg.context, ContactInfoUI.class);
      localIntent.putExtra("Contact_User", str);
      localIntent.putExtra("Contact_RoomNickname", this.pAg.efi.nE(str));
      this.pAg.context.startActivity(localIntent);
    }
    AppMethodBeat.o(23532);
  }
  
  public final void iy(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.h.1
 * JD-Core Version:    0.7.0.1
 */