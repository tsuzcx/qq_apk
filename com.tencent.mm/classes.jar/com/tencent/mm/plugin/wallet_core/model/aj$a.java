package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum aj$a
{
  public final String GwQ;
  public final int value;
  
  static
  {
    AppMethodBeat.i(70449);
    OTE = new a("GuideType_FQF_SWITCH", 0, "切换分付", 1);
    OTF = new a("GuideType_FQF_SWITCH_OPEN", 1, "分付开通条", 2);
    OTG = new a[] { OTE, OTF };
    AppMethodBeat.o(70449);
  }
  
  private aj$a(String paramString, int paramInt)
  {
    this.GwQ = paramString;
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aj.a
 * JD-Core Version:    0.7.0.1
 */