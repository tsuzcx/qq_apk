package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.fng;

public enum k
{
  public final String MsQ;
  public final int value;
  
  static
  {
    AppMethodBeat.i(127257);
    MsJ = new k("MMNEWTIPS_SHOWTYPE_NONE", 0, "无红点", 10000);
    MsK = new k("MMNEWTIPS_SHOWTYPE_REDPOINT", 1, "普通红点", 0);
    MsL = new k("MMNEWTIPS_SHOWTYPE_NEW", 2, "New 红点", 1);
    MsM = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE", 3, "带 TITLE 红点", 2);
    MsN = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_ICON", 4, "带 ICON 红点", 3);
    MsO = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON", 5, "同时带 TITLE 和 ICON 红点", 4);
    MsP = new k("MMNEWTIPS_SHOWTYPE_COUNTER", 6, "计数红点", 5);
    MsR = new k[] { MsJ, MsK, MsL, MsM, MsN, MsO, MsP };
    AppMethodBeat.o(127257);
  }
  
  private k(String paramString, int paramInt)
  {
    this.MsQ = paramString;
    this.value = paramInt;
  }
  
  public static fng a(k paramk, c paramc)
  {
    AppMethodBeat.i(127255);
    fng localfng = new fng();
    switch (1.MsD[paramk.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127255);
      return localfng;
      localfng.title = paramc.field_title;
      continue;
      localfng.url = paramc.field_icon_url;
      continue;
      localfng.url = paramc.field_icon_url;
      localfng.title = paramc.field_title;
    }
  }
  
  public static k aeK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return MsK;
    case 0: 
      return MsK;
    case 1: 
      return MsL;
    case 2: 
      return MsM;
    case 3: 
      return MsN;
    case 4: 
      return MsO;
    case 5: 
      return MsP;
    }
    return MsJ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(127256);
    String str = "NewTipsShowType{commet='" + this.MsQ + '\'' + ", value=" + this.value + '}';
    AppMethodBeat.o(127256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.k
 * JD-Core Version:    0.7.0.1
 */