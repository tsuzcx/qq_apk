package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.storage.ad;

final class NormalUserHeaderPreference$2
  implements View.OnClickListener
{
  NormalUserHeaderPreference$2(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    paramView = NormalUserHeaderPreference.b(this.siZ).field_username;
    f localf = new f(NormalUserHeaderPreference.a(this.siZ), paramView);
    if (ad.hd(paramView)) {
      ad.aaZ(paramView);
    }
    localf.cmi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.2
 * JD-Core Version:    0.7.0.1
 */