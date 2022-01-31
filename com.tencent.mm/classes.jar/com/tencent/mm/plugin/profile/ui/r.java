package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r
  implements HelperHeaderPreference.a
{
  private Context context;
  
  public r(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(HelperHeaderPreference paramHelperHeaderPreference)
  {
    AppMethodBeat.i(23618);
    if ((com.tencent.mm.model.r.Zy() & 0x8000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHelperHeaderPreference.kf(bool);
      AppMethodBeat.o(23618);
      return;
    }
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(23617);
    String str = this.context.getString(2131298615);
    AppMethodBeat.o(23617);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.r
 * JD-Core Version:    0.7.0.1
 */