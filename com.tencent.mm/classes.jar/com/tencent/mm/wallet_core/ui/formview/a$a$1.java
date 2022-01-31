package com.tencent.mm.wallet_core.ui.formview;

import android.text.method.NumberKeyListener;

final class a$a$1
  extends NumberKeyListener
{
  a$a$1(a.a parama) {}
  
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
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.a.1
 * JD-Core Version:    0.7.0.1
 */