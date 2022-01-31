package com.tencent.mm.plugin.multitalk.a;

import android.content.Intent;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.ui.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;

final class f$14
  implements Runnable
{
  f$14(f paramf) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    if (this.mtZ.mtH != null) {}
    for (String str = this.mtZ.mtH.wJN;; str = "")
    {
      localIntent.putExtra("enterMainUiWxGroupId", str);
      localIntent.setClass(ae.getContext(), MultiTalkMainUI.class);
      localIntent.putExtra("enterMainUiSource", 1);
      b.bPy().a(localIntent, new f.14.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f.14
 * JD-Core Version:    0.7.0.1
 */