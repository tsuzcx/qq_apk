package com.tencent.mm.ui;

import com.tencent.mm.h.a.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.t;

final class LauncherUI$3
  implements Runnable
{
  LauncherUI$3(LauncherUI paramLauncherUI) {}
  
  public final void run()
  {
    au.hold();
    w localw = new w();
    a.udP.m(localw);
    if (t.a(this.uLc.getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
      LauncherUI.b(this.uLc);
    }
    g.DQ().gi("switch account ,delay logout");
    LauncherUI.a(this.uLc, this.uLc);
    au.unhold();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI.3
 * JD-Core Version:    0.7.0.1
 */