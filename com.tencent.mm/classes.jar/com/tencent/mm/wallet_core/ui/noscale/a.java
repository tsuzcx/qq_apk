package com.tencent.mm.wallet_core.ui.noscale;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static int azO(int paramInt)
  {
    AppMethodBeat.i(271422);
    int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), paramInt);
    paramInt = i;
    if (com.tencent.mm.cj.a.hrd() != 1.0F) {
      paramInt = (int)(i / com.tencent.mm.cj.a.hrd());
    }
    AppMethodBeat.o(271422);
    return paramInt;
  }
  
  public static void jg(View paramView)
  {
    AppMethodBeat.i(271421);
    if (com.tencent.mm.cj.a.hrd() != 1.0F) {
      paramView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(270848);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$view.getLayoutParams();
          if (localMarginLayoutParams != null)
          {
            float f = com.tencent.mm.cj.a.hrd();
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
          AppMethodBeat.o(270848);
        }
      });
    }
    AppMethodBeat.o(271421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.noscale.a
 * JD-Core Version:    0.7.0.1
 */