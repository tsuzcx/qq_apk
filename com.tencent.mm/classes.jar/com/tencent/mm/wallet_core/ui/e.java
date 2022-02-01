package com.tencent.mm.wallet_core.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.ui.al;

public final class e
  extends o
{
  private a LWH;
  
  public e(a parama)
  {
    super(2, null);
    this.LWH = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190254);
    if (this.LWH != null) {
      this.LWH.aRM();
    }
    AppMethodBeat.o(190254);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(190255);
    super.updateDrawState(paramTextPaint);
    al.a(paramTextPaint, 0.8F);
    AppMethodBeat.o(190255);
  }
  
  public static abstract interface a
  {
    public abstract void aRM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */