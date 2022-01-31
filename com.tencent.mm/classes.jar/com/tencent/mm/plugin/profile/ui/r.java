package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.model.q;

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
    if ((q.Gu() & 0x1000000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHelperHeaderPreference.ig(bool);
      return;
    }
  }
  
  public final CharSequence getHint()
  {
    return this.context.getString(R.l.contact_info_linkedin_tip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.r
 * JD-Core Version:    0.7.0.1
 */