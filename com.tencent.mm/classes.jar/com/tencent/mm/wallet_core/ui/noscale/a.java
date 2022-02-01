package com.tencent.mm.wallet_core.ui.noscale;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static int aGE(int paramInt)
  {
    AppMethodBeat.i(242204);
    int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), paramInt);
    paramInt = i;
    if (c.iRs() != 1.0F) {
      paramInt = (int)(i / c.iRs());
    }
    AppMethodBeat.o(242204);
    return paramInt;
  }
  
  public static void mK(View paramView)
  {
    AppMethodBeat.i(242198);
    if (c.iRs() != 1.0F) {
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(242200);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)a.this.getLayoutParams();
          if (localMarginLayoutParams != null)
          {
            float f = c.iRs();
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
            a.this.setLayoutParams(localMarginLayoutParams);
          }
          AppMethodBeat.o(242200);
        }
      });
    }
    AppMethodBeat.o(242198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.noscale.a
 * JD-Core Version:    0.7.0.1
 */