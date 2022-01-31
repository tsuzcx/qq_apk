package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o
  implements HelperHeaderPreference.a
{
  private final Context context;
  
  public o(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(HelperHeaderPreference paramHelperHeaderPreference)
  {
    AppMethodBeat.i(23612);
    paramHelperHeaderPreference.kf(true);
    AppMethodBeat.o(23612);
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(23611);
    String str = this.context.getString(2131298619);
    AppMethodBeat.o(23611);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.o
 * JD-Core Version:    0.7.0.1
 */