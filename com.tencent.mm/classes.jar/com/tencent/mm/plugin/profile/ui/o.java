package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R.l;

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
    paramHelperHeaderPreference.ig(true);
  }
  
  public final CharSequence getHint()
  {
    return this.context.getString(R.l.contact_info_fmessage_switch_tip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.o
 * JD-Core Version:    0.7.0.1
 */