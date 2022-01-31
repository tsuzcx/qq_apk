package com.tencent.mm.plugin.recharge.ui.form;

import android.text.method.NumberKeyListener;

final class MallFormView$4
  extends NumberKeyListener
{
  MallFormView$4(MallFormView paramMallFormView) {}
  
  protected final char[] getAcceptedChars()
  {
    return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 120, 88 };
  }
  
  public final int getInputType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView.4
 * JD-Core Version:    0.7.0.1
 */