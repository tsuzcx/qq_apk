package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.bf;

final class NormalProfileHeaderPreference$2
  implements ViewTreeObserver.OnPreDrawListener
{
  NormalProfileHeaderPreference$2(NormalProfileHeaderPreference paramNormalProfileHeaderPreference, NormalProfileHeaderPreference.a parama) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(305468);
    this.MYr.MYS.getViewTreeObserver().removeOnPreDrawListener(this);
    int[] arrayOfInt = new int[2];
    this.MYr.MYS.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int m = bf.getStatusBarHeight(this.MYq.mContext);
    int j = a.bs(this.MYq.mContext, R.f.flV);
    int i;
    if (NormalProfileHeaderPreference.a(this.MYq))
    {
      i = a.bs(this.MYq.mContext, R.f.flT);
      if ((k != 0) || (NormalProfileHeaderPreference.a(this.MYq))) {
        break label278;
      }
      j = i + m;
    }
    for (;;)
    {
      Log.i("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s, paddingTopToSet:%s,curPaddingTop:%s", new Object[] { Integer.valueOf(NormalProfileHeaderPreference.b(this.MYq)), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(this.MYr.MYS.getPaddingTop()) });
      if (j == this.MYr.MYS.getPaddingTop()) {
        break label310;
      }
      this.MYr.MYS.setPadding(this.MYr.MYS.getPaddingLeft(), j, this.MYr.MYS.getPaddingRight(), this.MYr.MYS.getPaddingBottom());
      AppMethodBeat.o(305468);
      return false;
      i = j;
      if (m <= 0) {
        break;
      }
      i = j;
      if (NormalProfileHeaderPreference.b(this.MYq) <= 0) {
        break;
      }
      i = NormalProfileHeaderPreference.b(this.MYq) + a.bs(this.MYq.mContext, R.f.Edge_2A);
      break;
      label278:
      j = i;
      if (NormalProfileHeaderPreference.c(this.MYq))
      {
        j = i;
        if (NormalProfileHeaderPreference.d(this.MYq)) {
          j = i + m;
        }
      }
    }
    label310:
    AppMethodBeat.o(305468);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.2
 * JD-Core Version:    0.7.0.1
 */