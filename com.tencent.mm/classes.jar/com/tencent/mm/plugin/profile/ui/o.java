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
    AppMethodBeat.i(27227);
    paramHelperHeaderPreference.pB(true);
    AppMethodBeat.o(27227);
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(27226);
    String str = this.context.getString(2131757679);
    AppMethodBeat.o(27226);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.o
 * JD-Core Version:    0.7.0.1
 */