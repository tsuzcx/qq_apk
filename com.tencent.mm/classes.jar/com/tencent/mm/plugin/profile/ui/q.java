package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;

final class q
  implements HelperHeaderPreference.a
{
  private final Context context;
  
  public q(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(HelperHeaderPreference paramHelperHeaderPreference)
  {
    AppMethodBeat.i(27227);
    paramHelperHeaderPreference.Ay(true);
    AppMethodBeat.o(27227);
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(27226);
    String str = this.context.getString(R.l.gBq);
    AppMethodBeat.o(27226);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.q
 * JD-Core Version:    0.7.0.1
 */