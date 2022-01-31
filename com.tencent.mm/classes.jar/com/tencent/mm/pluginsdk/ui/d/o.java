package com.tencent.mm.pluginsdk.ui.d;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.af;

public class o
  extends n
{
  private Object tag;
  private o.a wcK;
  
  public o() {}
  
  public o(Object paramObject, o.a parama)
  {
    super(2, null);
    this.wcK = parama;
    this.tag = paramObject;
  }
  
  public o(Object paramObject, o.a parama, int paramInt)
  {
    super(2, null);
    AppMethodBeat.i(40543);
    this.wcK = parama;
    this.tag = paramObject;
    setColorConfig(paramInt);
    AppMethodBeat.o(40543);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(40544);
    if (this.wcK != null) {
      this.wcK.a(paramView, this.tag);
    }
    AppMethodBeat.o(40544);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(40545);
    super.updateDrawState(paramTextPaint);
    af.a(paramTextPaint, 0.8F);
    AppMethodBeat.o(40545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.o
 * JD-Core Version:    0.7.0.1
 */