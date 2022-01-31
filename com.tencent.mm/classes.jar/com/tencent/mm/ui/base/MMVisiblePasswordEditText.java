package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.sdk.platformtools.y;

public class MMVisiblePasswordEditText
  extends EditText
{
  public String hyx = "";
  final Drawable uZx = getResources().getDrawable(a.j.login_showpassword_icon);
  final Drawable uZy = getResources().getDrawable(a.j.login_showpassword_icon_activa);
  private boolean uZz = false;
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cAE();
  }
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cAE();
  }
  
  private void cAE()
  {
    this.uZx.setBounds(0, 0, this.uZx.getIntrinsicWidth(), this.uZx.getIntrinsicHeight());
    this.uZy.setBounds(0, 0, this.uZy.getIntrinsicWidth(), this.uZy.getIntrinsicHeight());
    y.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[] { Integer.valueOf(this.uZx.getIntrinsicWidth()), Integer.valueOf(this.uZx.getIntrinsicHeight()) });
    cBj();
    setHeight(this.uZx.getIntrinsicHeight() + getResources().getDimensionPixelSize(a.e.OneDPPadding) * 5);
    setOnTouchListener(new MMVisiblePasswordEditText.1(this));
  }
  
  private void cBj()
  {
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (this.uZz)
    {
      setInputType(1);
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.uZy, getCompoundDrawables()[3]);
    }
    for (;;)
    {
      setSelection(i, j);
      return;
      setInputType(129);
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.uZx, getCompoundDrawables()[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText
 * JD-Core Version:    0.7.0.1
 */