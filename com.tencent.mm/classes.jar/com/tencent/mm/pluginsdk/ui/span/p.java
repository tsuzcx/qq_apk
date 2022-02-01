package com.tencent.mm.pluginsdk.ui.span;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;

public class p
  extends o
{
  private a DCR;
  private Object tag;
  
  public p() {}
  
  public p(Object paramObject, a parama)
  {
    super(2, null);
    this.DCR = parama;
    this.tag = paramObject;
  }
  
  public p(Object paramObject, a parama, int paramInt)
  {
    super(2, null);
    AppMethodBeat.i(100607);
    this.DCR = parama;
    this.tag = paramObject;
    setColorConfig(paramInt);
    AppMethodBeat.o(100607);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(100608);
    if (this.DCR != null) {
      this.DCR.b(paramView, this.tag);
    }
    AppMethodBeat.o(100608);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(100609);
    super.updateDrawState(paramTextPaint);
    aj.a(paramTextPaint, 0.8F);
    AppMethodBeat.o(100609);
  }
  
  public static abstract interface a
  {
    public abstract void b(View paramView, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.p
 * JD-Core Version:    0.7.0.1
 */