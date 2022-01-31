package com.tencent.mm.pluginsdk.ui.preference;

import android.content.ClipboardManager;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class NormalUserHeaderPreference$5$2
  implements n.d
{
  NormalUserHeaderPreference$5$2(NormalUserHeaderPreference.5 param5, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramInt == 0)
    {
      NormalUserHeaderPreference.e(this.sja.siZ).setText(this.dol);
      h.bB(NormalUserHeaderPreference.a(this.sja.siZ), NormalUserHeaderPreference.a(this.sja.siZ).getString(R.l.app_copy_ok));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.5.2
 * JD-Core Version:    0.7.0.1
 */