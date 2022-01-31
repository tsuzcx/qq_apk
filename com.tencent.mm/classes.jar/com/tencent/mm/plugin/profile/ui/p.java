package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.model.q;

final class p
  implements HelperHeaderPreference.a
{
  private Context context;
  
  public p(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(HelperHeaderPreference paramHelperHeaderPreference)
  {
    if ((q.Gu() & 0x2000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHelperHeaderPreference.ig(bool);
      return;
    }
  }
  
  public final CharSequence getHint()
  {
    return this.context.getString(R.l.contact_info_facebookapp_tip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.p
 * JD-Core Version:    0.7.0.1
 */