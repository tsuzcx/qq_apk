package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.preference.Preference;

final class HelperHeaderPreference$1
  implements ViewTreeObserver.OnPreDrawListener
{
  HelperHeaderPreference$1(HelperHeaderPreference paramHelperHeaderPreference, View paramView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(156596);
    this.val$rootView.getViewTreeObserver().removeOnPreDrawListener(this);
    int[] arrayOfInt = new int[2];
    this.val$rootView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = a.fromDPToPix(this.waU.mContext, 60);
    int m = am.getStatusBarHeight(this.waU.mContext);
    int n = am.di(this.waU.mContext);
    ab.i("MicroMsg.HelperHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
    int i = j;
    if (m > 0)
    {
      i = j;
      if (n > 0) {
        i = a.ap(this.waU.mContext, 2131427587) + n;
      }
    }
    j = i;
    if (k == 0) {
      j = i + m;
    }
    this.val$rootView.setPadding(this.val$rootView.getPaddingLeft(), j, this.val$rootView.getPaddingRight(), this.val$rootView.getPaddingBottom());
    AppMethodBeat.o(156596);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */