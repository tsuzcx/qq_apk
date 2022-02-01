package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p
  implements HelperHeaderPreference.a
{
  private final Context context;
  
  public p(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(HelperHeaderPreference paramHelperHeaderPreference)
  {
    AppMethodBeat.i(27227);
    paramHelperHeaderPreference.sK(true);
    AppMethodBeat.o(27227);
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(27226);
    String str = this.context.getString(2131757910);
    AppMethodBeat.o(27226);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.p
 * JD-Core Version:    0.7.0.1
 */