package com.tenpay.android.wechat;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TenpaySecureEditText$EditState
{
  static
  {
    AppMethodBeat.i(49466);
    DEFAULT = new EditState("DEFAULT", 0);
    PASSWORD = new EditState("PASSWORD", 1);
    BANKCARD = new EditState("BANKCARD", 2);
    BANKCARD_WITH_TAILNUM = new EditState("BANKCARD_WITH_TAILNUM", 3);
    VALID_THRU = new EditState("VALID_THRU", 4);
    MONEY_AMOUNT = new EditState("MONEY_AMOUNT", 5);
    CVV_PAYMENT = new EditState("CVV_PAYMENT", 6);
    CVV_4_PAYMENT = new EditState("CVV_4_PAYMENT", 7);
    SECURITY_ANSWER = new EditState("SECURITY_ANSWER", 8);
    IDCARD_TAIL = new EditState("IDCARD_TAIL", 9);
    $VALUES = new EditState[] { DEFAULT, PASSWORD, BANKCARD, BANKCARD_WITH_TAILNUM, VALID_THRU, MONEY_AMOUNT, CVV_PAYMENT, CVV_4_PAYMENT, SECURITY_ANSWER, IDCARD_TAIL };
    AppMethodBeat.o(49466);
  }
  
  private TenpaySecureEditText$EditState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpaySecureEditText.EditState
 * JD-Core Version:    0.7.0.1
 */