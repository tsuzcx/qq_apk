package com.tenpay.bankcard;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TenpaySegmentEditText$EditState
{
  static
  {
    AppMethodBeat.i(49523);
    DEFAULT = new EditState("DEFAULT", 0);
    BANKCARD = new EditState("BANKCARD", 1);
    BANKCARD_WITH_TAILNUM = new EditState("BANKCARD_WITH_TAILNUM", 2);
    $VALUES = new EditState[] { DEFAULT, BANKCARD, BANKCARD_WITH_TAILNUM };
    AppMethodBeat.o(49523);
  }
  
  private TenpaySegmentEditText$EditState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.bankcard.TenpaySegmentEditText.EditState
 * JD-Core Version:    0.7.0.1
 */