package com.tencent.mm.pluginsdk.ui.span;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;

public final class p$b
  extends t
{
  private boolean Abi = true;
  private int Abj = 0;
  private p.b.a YoH;
  private boolean bold = true;
  private String text = "";
  private int textColor = 0;
  
  public p$b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, p.b.a parama)
  {
    super(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.Abj = paramInt2;
    this.bold = paramBoolean;
    this.text = paramString;
    this.YoH = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245199);
    if ((this.Abi) && (this.YoH != null)) {
      this.YoH.onClick(this.text);
    }
    AppMethodBeat.o(245199);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245194);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.Abj = paramInt2;
    AppMethodBeat.o(245194);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(245197);
    super.updateDrawState(paramTextPaint);
    if (this.bold) {
      aw.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(245197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.p.b
 * JD-Core Version:    0.7.0.1
 */