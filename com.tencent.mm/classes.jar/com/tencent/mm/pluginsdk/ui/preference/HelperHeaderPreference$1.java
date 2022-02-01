package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.preference.Preference;

final class HelperHeaderPreference$1
  implements ViewTreeObserver.OnPreDrawListener
{
  HelperHeaderPreference$1(HelperHeaderPreference paramHelperHeaderPreference, View paramView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(152253);
    this.val$rootView.getViewTreeObserver().removeOnPreDrawListener(this);
    int[] arrayOfInt = new int[2];
    this.val$rootView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = a.fromDPToPix(this.Rqk.mContext, 60);
    int m = ax.getStatusBarHeight(this.Rqk.mContext);
    int n = ax.ew(this.Rqk.mContext);
    Log.i("MicroMsg.HelperHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
    int i = j;
    if (m > 0)
    {
      i = j;
      if (n > 0) {
        i = a.aZ(this.Rqk.mContext, c.c.Edge_2A) + n;
      }
    }
    j = i;
    if (k == 0) {
      j = i + m;
    }
    if (j != this.val$rootView.getPaddingTop())
    {
      this.val$rootView.setPadding(this.val$rootView.getPaddingLeft(), j, this.val$rootView.getPaddingRight(), this.val$rootView.getPaddingBottom());
      AppMethodBeat.o(152253);
      return false;
    }
    AppMethodBeat.o(152253);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */