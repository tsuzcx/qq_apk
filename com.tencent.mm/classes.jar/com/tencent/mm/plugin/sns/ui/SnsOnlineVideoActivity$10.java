package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class SnsOnlineVideoActivity$10
  implements MenuItem.OnMenuItemClickListener
{
  SnsOnlineVideoActivity$10(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(39156);
    h.a(this.rUf, 2131304031, 2131297087, new SnsOnlineVideoActivity.10.1(this), new SnsOnlineVideoActivity.10.2(this));
    AppMethodBeat.o(39156);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.10
 * JD-Core Version:    0.7.0.1
 */