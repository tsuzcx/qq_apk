package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.u;

final class h$1
  implements ContactListExpandPreference.a
{
  h$1(h paramh) {}
  
  public final void gh(int paramInt) {}
  
  public final void gi(int paramInt)
  {
    String str;
    if (this.mXk.mXj.Ec(paramInt))
    {
      str = this.mXk.mXj.Ed(paramInt);
      if (!bk.bl(str)) {}
    }
    else
    {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.mXk.context, ContactInfoUI.class);
    localIntent.putExtra("Contact_User", str);
    localIntent.putExtra("Contact_RoomNickname", this.mXk.dnL.gV(str));
    this.mXk.context.startActivity(localIntent);
  }
  
  public final void gj(int paramInt) {}
  
  public final void xy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.h.1
 * JD-Core Version:    0.7.0.1
 */