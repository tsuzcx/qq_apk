package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalProfileHeaderPreference$1
  implements ViewTreeObserver.OnPreDrawListener
{
  NormalProfileHeaderPreference$1(NormalProfileHeaderPreference paramNormalProfileHeaderPreference, NormalProfileHeaderPreference.a parama) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(156690);
    this.pBe.pBE.getViewTreeObserver().removeOnPreDrawListener(this);
    int[] arrayOfInt = new int[2];
    this.pBe.pBE.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int m = am.getStatusBarHeight(this.pBf.mContext);
    int j = a.ap(this.pBf.mContext, 2131428636);
    ab.i("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(NormalProfileHeaderPreference.a(this.pBf)), Integer.valueOf(m), Integer.valueOf(k) });
    int i;
    if (NormalProfileHeaderPreference.b(this.pBf)) {
      i = a.ap(this.pBf.mContext, 2131428634);
    }
    for (;;)
    {
      j = i;
      if (k == 0)
      {
        j = i;
        if (!NormalProfileHeaderPreference.b(this.pBf)) {
          j = i + m;
        }
      }
      this.pBe.pBE.setPadding(this.pBe.pBE.getPaddingLeft(), j, this.pBe.pBE.getPaddingRight(), this.pBe.pBE.getPaddingBottom());
      AppMethodBeat.o(156690);
      return false;
      i = j;
      if (m > 0)
      {
        i = j;
        if (NormalProfileHeaderPreference.a(this.pBf) > 0) {
          i = NormalProfileHeaderPreference.a(this.pBf) + a.ap(this.pBf.mContext, 2131427587);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */