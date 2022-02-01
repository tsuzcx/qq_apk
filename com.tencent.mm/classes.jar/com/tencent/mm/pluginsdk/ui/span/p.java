package com.tencent.mm.pluginsdk.ui.span;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;

public class p
  extends o
{
  private a FAv;
  private Object tag;
  
  public p() {}
  
  public p(Object paramObject, a parama)
  {
    super(2, null);
    this.FAv = parama;
    this.tag = paramObject;
  }
  
  public p(Object paramObject, a parama, int paramInt)
  {
    super(2, null);
    AppMethodBeat.i(100607);
    this.FAv = parama;
    this.tag = paramObject;
    setColorConfig(paramInt);
    AppMethodBeat.o(100607);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(100608);
    if (this.FAv != null) {
      this.FAv.b(paramView, this.tag);
    }
    AppMethodBeat.o(100608);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(100609);
    super.updateDrawState(paramTextPaint);
    al.a(paramTextPaint, 0.8F);
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