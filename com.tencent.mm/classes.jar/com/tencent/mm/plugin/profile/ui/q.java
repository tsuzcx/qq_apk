package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;

final class q
  implements HelperHeaderPreference.a
{
  private Context context;
  
  public q(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(HelperHeaderPreference paramHelperHeaderPreference)
  {
    AppMethodBeat.i(27231);
    if ((u.aAy() & 0x8000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHelperHeaderPreference.pt(bool);
      AppMethodBeat.o(27231);
      return;
    }
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(27230);
    String str = this.context.getString(2131757675);
    AppMethodBeat.o(27230);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.q
 * JD-Core Version:    0.7.0.1
 */