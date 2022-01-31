package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.support.constraint.ConstraintLayout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.preference.Preference;

final class NewBizInfoHeaderPreference$2
  implements ViewTreeObserver.OnPreDrawListener
{
  NewBizInfoHeaderPreference$2(NewBizInfoHeaderPreference paramNewBizInfoHeaderPreference) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(156695);
    NewBizInfoHeaderPreference.d(this.pDE).getViewTreeObserver().removeOnPreDrawListener(this);
    int[] arrayOfInt = new int[2];
    NewBizInfoHeaderPreference.d(this.pDE).getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = a.ap(this.pDE.mContext, 2131428636);
    int m = am.getStatusBarHeight(this.pDE.mContext);
    int n = am.di(this.pDE.mContext);
    ab.i("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
    int i = j;
    if (m > 0)
    {
      i = j;
      if (n > 0) {
        i = a.ap(this.pDE.mContext, 2131427587) + n;
      }
    }
    j = i;
    if (k == 0) {
      j = i + m;
    }
    NewBizInfoHeaderPreference.d(this.pDE).setPadding(NewBizInfoHeaderPreference.d(this.pDE).getPaddingLeft(), j, NewBizInfoHeaderPreference.d(this.pDE).getPaddingRight(), NewBizInfoHeaderPreference.d(this.pDE).getPaddingBottom());
    AppMethodBeat.o(156695);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference.2
 * JD-Core Version:    0.7.0.1
 */