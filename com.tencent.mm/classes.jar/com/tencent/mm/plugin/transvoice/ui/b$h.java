package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.support.design.widget.MMBottomSheetBehavior;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "isKeyboardShow", "", "keyboardHeight", "", "onInputPanelChange"})
final class b$h
  implements TransVoicePanelLayout.a
{
  b$h(b paramb) {}
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(155234);
    b.a(this.tqJ, paramBoolean);
    ab.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (paramBoolean)
    {
      b.a(this.tqJ, b.b.tqE);
      localObject = b.c(this.tqJ);
      if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState())) {
        b.a(this.tqJ, b.c.tqH);
      }
      localObject = b.e(this.tqJ);
      if (localObject != null) {
        ((MMEditText)localObject).setCursorVisible(true);
      }
      b.b(this.tqJ, true);
      b.c(this.tqJ, false);
      b.d(this.tqJ, false);
      localObject = b.f(this.tqJ);
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130838345);
      }
      b.e(this.tqJ, true);
    }
    for (;;)
    {
      if ((b.h(this.tqJ) != paramInt) && (paramInt != 0))
      {
        b.a(this.tqJ, paramInt);
        j.z(this.tqJ.getContext(), paramInt);
        b.i(this.tqJ);
      }
      AppMethodBeat.o(155234);
      return;
      localObject = b.c(this.tqJ);
      if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState()) && (b.b.tqD != b.b(this.tqJ))) {
        b.a(this.tqJ, b.c.tqG);
      }
      localObject = b.b(this.tqJ);
      switch (c.bLo[localObject.ordinal()])
      {
      case 1: 
      default: 
        break;
      case 2: 
        b.a(this.tqJ, b.b.tqC);
        if (b.c.tqH != b.d(this.tqJ))
        {
          b.b(this.tqJ, false);
          b.c(this.tqJ, true);
          localObject = b.g(this.tqJ);
          if (localObject != null) {
            ((FrameLayout)localObject).setVisibility(8);
          }
          localObject = b.e(this.tqJ);
          if (localObject != null) {
            ((MMEditText)localObject).setCursorVisible(false);
          }
          b.e(this.tqJ, false);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.h
 * JD-Core Version:    0.7.0.1
 */