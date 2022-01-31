package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.h.a.ar;
import com.tencent.mm.h.a.ar.a;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class k$4$1
  implements Runnable
{
  k$4$1(k.4 param4, ar paramar) {}
  
  public final void run()
  {
    String str1 = this.mXD.bGQ.bGR;
    this.mXE.mXC.bMV.getIntent().putExtra("inviteer", str1);
    String str2 = this.mXE.mXC.gV(this.mXD.bGQ.bGR);
    y.i("MicroMsg.ContactWidgetNormal", "[ChatroomMemberInviteerUpdatedEvent callback] inviteer:%s inviteerDisplayName:%s", new Object[] { str1, str2 });
    if (bk.bl(str2))
    {
      am.a.dVy.a(str1, "", new k.4.1.1(this, str1));
      return;
    }
    this.mXE.mXC.eo(str1, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.4.1
 * JD-Core Version:    0.7.0.1
 */