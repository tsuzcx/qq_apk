package com.tencent.mm.pluginsdk.ui.span;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public class q
  extends p
{
  private a KrB;
  private Object tag;
  
  public q() {}
  
  public q(Object paramObject, a parama)
  {
    super(2, null);
    this.KrB = parama;
    this.tag = paramObject;
  }
  
  public q(Object paramObject, a parama, int paramInt)
  {
    super(2, null);
    AppMethodBeat.i(100607);
    this.KrB = parama;
    this.tag = paramObject;
    setColorConfig(paramInt);
    AppMethodBeat.o(100607);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(100608);
    if (this.KrB != null) {
      this.KrB.b(paramView, this.tag);
    }
    AppMethodBeat.o(100608);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(100609);
    super.updateDrawState(paramTextPaint);
    ao.a(paramTextPaint, 0.8F);
    AppMethodBeat.o(100609);
  }
  
  public static abstract interface a
  {
    public abstract void b(View paramView, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.q
 * JD-Core Version:    0.7.0.1
 */