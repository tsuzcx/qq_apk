package com.tencent.mm.pluginsdk.ui.preference;

import android.content.ClipboardManager;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class NormalUserHeaderPreference$5$2
  implements n.d
{
  NormalUserHeaderPreference$5$2(NormalUserHeaderPreference.5 param5, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(28076);
    if (paramInt == 0)
    {
      NormalUserHeaderPreference.e(this.wbB.wbA).setText(this.efI);
      h.bN(NormalUserHeaderPreference.b(this.wbB.wbA), NormalUserHeaderPreference.b(this.wbB.wbA).getString(2131296896));
    }
    AppMethodBeat.o(28076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.5.2
 * JD-Core Version:    0.7.0.1
 */