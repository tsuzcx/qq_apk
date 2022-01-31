package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.ui.base.h;

final class u$1
  implements am.a
{
  u$1(u paramu) {}
  
  public final boolean tC()
  {
    u localu = this.sdw;
    Context localContext = this.sdw.context;
    this.sdw.context.getString(R.l.app_tip);
    localu.ksE = h.b(localContext, this.sdw.context.getString(R.l.app_waiting), true, new u.1.1(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.u.1
 * JD-Core Version:    0.7.0.1
 */