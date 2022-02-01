package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ah$a
{
  public final String MsQ;
  public final int value;
  
  static
  {
    AppMethodBeat.i(70449);
    VJK = new a("GuideType_FQF_SWITCH", 0, "切换分付", 1);
    VJL = new a("GuideType_FQF_SWITCH_OPEN", 1, "分付开通条", 2);
    VJM = new a[] { VJK, VJL };
    AppMethodBeat.o(70449);
  }
  
  private ah$a(String paramString, int paramInt)
  {
    this.MsQ = paramString;
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ah.a
 * JD-Core Version:    0.7.0.1
 */