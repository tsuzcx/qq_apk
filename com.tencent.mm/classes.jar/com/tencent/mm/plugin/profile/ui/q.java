package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R.l;

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
    if ((com.tencent.mm.model.q.Gu() & 0x8000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHelperHeaderPreference.ig(bool);
      return;
    }
  }
  
  public final CharSequence getHint()
  {
    return this.context.getString(R.l.contact_info_feedsapp_tip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.q
 * JD-Core Version:    0.7.0.1
 */