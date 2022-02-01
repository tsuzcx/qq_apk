package com.tencent.mm.pluginsdk.ui.span;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;

public class MMTextAppearanceSpan
  extends TextAppearanceSpan
{
  public int fontStyle = 0;
  
  public MMTextAppearanceSpan(int paramInt, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    super(null, 0, paramInt, paramColorStateList1, paramColorStateList2);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(152328);
    super.updateDrawState(paramTextPaint);
    switch (this.fontStyle)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152328);
      return;
      aj.a(paramTextPaint, 0.1F);
      AppMethodBeat.o(152328);
      return;
      aj.a(paramTextPaint, 0.8F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.MMTextAppearanceSpan
 * JD-Core Version:    0.7.0.1
 */