package com.tencent.mm.plugin.recharge.ui;

import android.text.method.NumberKeyListener;

final class MallEditText$2
  extends NumberKeyListener
{
  MallEditText$2(MallEditText paramMallEditText) {}
  
  protected final char[] getAcceptedChars()
  {
    return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 32 };
  }
  
  public final int getInputType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.2
 * JD-Core Version:    0.7.0.1
 */