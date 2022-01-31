package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;

final class s
  implements HelperHeaderPreference.a
{
  private Context context;
  
  public s(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(HelperHeaderPreference paramHelperHeaderPreference)
  {
    AppMethodBeat.i(23648);
    if ((r.Zy() & 0x1000000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHelperHeaderPreference.kf(bool);
      AppMethodBeat.o(23648);
      return;
    }
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(23647);
    String str = this.context.getString(2131298655);
    AppMethodBeat.o(23647);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.s
 * JD-Core Version:    0.7.0.1
 */