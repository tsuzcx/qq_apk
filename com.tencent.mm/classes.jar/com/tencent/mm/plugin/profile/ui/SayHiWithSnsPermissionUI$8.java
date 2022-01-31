package com.tencent.mm.plugin.profile.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class SayHiWithSnsPermissionUI$8
  implements View.OnTouchListener
{
  SayHiWithSnsPermissionUI$8(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153573);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(153573);
      return false;
      this.pCR.pCQ[0] = true;
      b.pgQ.fD("ce_ver_usr", "<VerifyUsr>");
      continue;
      b.pgQ.a("ce_ver_usr", paramMotionEvent);
      b.pgQ.Wa("ce_ver_usr");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.8
 * JD-Core Version:    0.7.0.1
 */