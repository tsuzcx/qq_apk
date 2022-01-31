package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMVisiblePasswordEditText
  extends EditText
{
  public String jqH;
  final Drawable znO;
  final Drawable znP;
  private boolean znQ;
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106955);
    this.jqH = "";
    this.znO = getResources().getDrawable(2131231598);
    this.znP = getResources().getDrawable(2131231599);
    this.znQ = false;
    dDP();
    AppMethodBeat.o(106955);
  }
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106956);
    this.jqH = "";
    this.znO = getResources().getDrawable(2131231598);
    this.znP = getResources().getDrawable(2131231599);
    this.znQ = false;
    dDP();
    AppMethodBeat.o(106956);
  }
  
  private void dDP()
  {
    AppMethodBeat.i(106957);
    this.znO.setBounds(0, 0, this.znO.getIntrinsicWidth(), this.znO.getIntrinsicHeight());
    this.znP.setBounds(0, 0, this.znP.getIntrinsicWidth(), this.znP.getIntrinsicHeight());
    ab.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[] { Integer.valueOf(this.znO.getIntrinsicWidth()), Integer.valueOf(this.znO.getIntrinsicHeight()) });
    dEw();
    setHeight(this.znO.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131427811) * 5);
    setOnTouchListener(new MMVisiblePasswordEditText.1(this));
    AppMethodBeat.o(106957);
  }
  
  private void dEw()
  {
    AppMethodBeat.i(106958);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (this.znQ)
    {
      setInputType(1);
      dEx();
    }
    for (;;)
    {
      setSelection(i, j);
      AppMethodBeat.o(106958);
      return;
      setInputType(129);
      dEy();
    }
  }
  
  private void dEx()
  {
    AppMethodBeat.i(106959);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.znP, getCompoundDrawables()[3]);
    AppMethodBeat.o(106959);
  }
  
  private void dEy()
  {
    AppMethodBeat.i(106960);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.znO, getCompoundDrawables()[3]);
    AppMethodBeat.o(106960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText
 * JD-Core Version:    0.7.0.1
 */