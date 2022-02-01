package com.tencent.mm.wallet_core.ui.noscale;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static void hL(View paramView)
  {
    AppMethodBeat.i(214350);
    if (com.tencent.mm.cc.a.gvi() != 1.0F) {
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214349);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$view.getLayoutParams();
          if (localMarginLayoutParams != null)
          {
            float f = com.tencent.mm.cc.a.gvi();
            if (localMarginLayoutParams.height > 0) {
              localMarginLayoutParams.height = ((int)(localMarginLayoutParams.height / f));
            }
            if (localMarginLayoutParams.width > 0) {
              localMarginLayoutParams.width = ((int)(localMarginLayoutParams.width / f));
            }
            localMarginLayoutParams.topMargin = ((int)(localMarginLayoutParams.topMargin / f));
            localMarginLayoutParams.bottomMargin = ((int)(localMarginLayoutParams.bottomMargin / f));
            localMarginLayoutParams.leftMargin = ((int)(localMarginLayoutParams.leftMargin / f));
            localMarginLayoutParams.rightMargin = ((int)(localMarginLayoutParams.rightMargin / f));
            this.val$view.setLayoutParams(localMarginLayoutParams);
          }
          AppMethodBeat.o(214349);
        }
      });
    }
    AppMethodBeat.o(214350);
  }
  
  public static int hif()
  {
    AppMethodBeat.i(214351);
    int j = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    int i = j;
    if (com.tencent.mm.cc.a.gvi() != 1.0F) {
      i = (int)(j / com.tencent.mm.cc.a.gvi());
    }
    AppMethodBeat.o(214351);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.noscale.a
 * JD-Core Version:    0.7.0.1
 */