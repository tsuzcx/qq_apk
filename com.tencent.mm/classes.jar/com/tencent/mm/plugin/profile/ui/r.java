package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;

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
    AppMethodBeat.i(27231);
    if ((z.aUl() & 0x8000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHelperHeaderPreference.sK(bool);
      AppMethodBeat.o(27231);
      return;
    }
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(27230);
    String str = this.context.getString(2131757903);
    AppMethodBeat.o(27230);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.r
 * JD-Core Version:    0.7.0.1
 */