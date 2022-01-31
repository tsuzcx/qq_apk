package com.tencent.mm.plugin.profile.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NormalProfileHeaderPreference$a$1
  implements View.OnTouchListener
{
  NormalProfileHeaderPreference$a$1(NormalProfileHeaderPreference.a parama, NormalProfileHeaderPreference paramNormalProfileHeaderPreference) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153564);
    this.pBH.pBf.pBc = ((int)paramMotionEvent.getRawX());
    this.pBH.pBf.pBd = ((int)paramMotionEvent.getRawY());
    paramView.setTag(2131820681, new int[] { this.pBH.pBf.pBc, this.pBH.pBf.pBd });
    AppMethodBeat.o(153564);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.a.1
 * JD-Core Version:    0.7.0.1
 */