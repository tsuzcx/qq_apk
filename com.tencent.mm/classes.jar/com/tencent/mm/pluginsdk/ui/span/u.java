package com.tencent.mm.pluginsdk.ui.span;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;

public class u
  extends t
{
  private a Ypc;
  public Boolean Ypd;
  private Object tag;
  
  public u()
  {
    this.Ypd = Boolean.TRUE;
  }
  
  public u(Object paramObject, a parama)
  {
    super(2, null);
    this.Ypd = Boolean.TRUE;
    this.Ypc = parama;
    this.tag = paramObject;
  }
  
  public u(Object paramObject, a parama, byte paramByte)
  {
    super(2, null);
    AppMethodBeat.i(245193);
    this.Ypd = Boolean.TRUE;
    this.Ypc = parama;
    this.tag = paramObject;
    setColorConfig(2);
    AppMethodBeat.o(245193);
  }
  
  public u(Object paramObject, a parama, int paramInt)
  {
    super(2, null);
    AppMethodBeat.i(100607);
    this.Ypd = Boolean.TRUE;
    this.Ypc = parama;
    this.tag = paramObject;
    setColorConfig(paramInt);
    AppMethodBeat.o(100607);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(100608);
    if (this.Ypc != null) {
      this.Ypc.onClick(paramView, this.tag);
    }
    AppMethodBeat.o(100608);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(100609);
    super.updateDrawState(paramTextPaint);
    if (this.Ypd.booleanValue()) {
      aw.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(100609);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.u
 * JD-Core Version:    0.7.0.1
 */