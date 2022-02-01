package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.z;

final class t
  implements HelperHeaderPreference.a
{
  private Context context;
  
  public t(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(HelperHeaderPreference paramHelperHeaderPreference)
  {
    AppMethodBeat.i(27261);
    if ((z.bBf() & 0x1000000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHelperHeaderPreference.Ay(bool);
      AppMethodBeat.o(27261);
      return;
    }
  }
  
  public final CharSequence getHint()
  {
    AppMethodBeat.i(27260);
    String str = this.context.getString(R.l.contact_info_linkedin_tip);
    AppMethodBeat.o(27260);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.t
 * JD-Core Version:    0.7.0.1
 */