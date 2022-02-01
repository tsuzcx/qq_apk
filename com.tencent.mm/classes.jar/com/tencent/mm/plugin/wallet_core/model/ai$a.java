package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ai$a
{
  public final String ADM;
  public final int value;
  
  static
  {
    AppMethodBeat.i(70449);
    Ibs = new a("GuideType_FQF_SWITCH", 0, "切换分付", 1);
    Ibt = new a("GuideType_FQF_SWITCH_OPEN", 1, "分付开通条", 2);
    Ibu = new a[] { Ibs, Ibt };
    AppMethodBeat.o(70449);
  }
  
  private ai$a(String paramString, int paramInt)
  {
    this.ADM = paramString;
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ai.a
 * JD-Core Version:    0.7.0.1
 */