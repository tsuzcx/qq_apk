package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.h;

final class a$1
  implements ap.a
{
  a$1(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(23796);
    if (!this.pDb.cup.isFinishing())
    {
      a locala = this.pDb;
      Activity localActivity = this.pDb.cup;
      this.pDb.cup.getString(2131297087);
      locala.mOt = h.b(localActivity, this.pDb.cup.getString(2131297112), true, new a.1.1(this));
    }
    AppMethodBeat.o(23796);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a.1
 * JD-Core Version:    0.7.0.1
 */