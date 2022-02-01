package com.tencent.mm.wallet_core.c;

import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public final class l$7
  implements Runnable
{
  public l$7(View paramView1, double paramDouble, int paramInt, WalletTextView paramWalletTextView, View paramView2, View paramView3, TextView paramTextView) {}
  
  public final void run()
  {
    AppMethodBeat.i(163881);
    int k = this.RtB.getWidth();
    long l = Double.valueOf(this.RtC).longValue();
    int j = 0;
    int i = 0;
    while (l != 0L)
    {
      j = (int)(l % 10L);
      l /= 10L;
      i += 1;
    }
    if (i >= this.RtD)
    {
      if (j == 1) {}
      for (float f1 = this.RtE.getPaint().measureText("1");; f1 = this.RtE.getPaint().measureText("2"))
      {
        float f2 = this.RtF.getLeft() + this.RtE.getLeft();
        j = (int)(f1 / 2.0F + f2 - k / 2);
        if (j == 0) {
          break;
        }
        this.RtG.setVisibility(0);
        Object localObject = ag.aR(MMApplicationContext.getContext(), i);
        this.RtH.setText((CharSequence)localObject);
        localObject = (RelativeLayout.LayoutParams)this.RtB.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
        this.RtB.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(163881);
        return;
      }
      this.RtG.setVisibility(8);
      AppMethodBeat.o(163881);
      return;
    }
    this.RtG.setVisibility(8);
    AppMethodBeat.o(163881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l.7
 * JD-Core Version:    0.7.0.1
 */