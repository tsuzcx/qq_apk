package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;

final class f$14
  implements Runnable
{
  f$14(f paramf, Notification paramNotification) {}
  
  public final void run()
  {
    AppMethodBeat.i(53954);
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    if (f.f(this.oTN) != null) {}
    for (String str = f.f(this.oTN).Bhn;; str = "")
    {
      localIntent.putExtra("enterMainUiWxGroupId", str);
      localIntent.setClass(ah.getContext(), MultiTalkMainUI.class);
      localIntent.putExtra("notification", this.oTR);
      localIntent.putExtra("enterMainUiSource", 1);
      b.cLD().a(localIntent, new f.14.1(this));
      f.g(this.oTN);
      AppMethodBeat.o(53954);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f.14
 * JD-Core Version:    0.7.0.1
 */