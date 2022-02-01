package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.ehv;

public enum k
{
  public final String ADM;
  public final int value;
  
  static
  {
    AppMethodBeat.i(127257);
    ADF = new k("MMNEWTIPS_SHOWTYPE_NONE", 0, "无红点", 10000);
    ADG = new k("MMNEWTIPS_SHOWTYPE_REDPOINT", 1, "普通红点", 0);
    ADH = new k("MMNEWTIPS_SHOWTYPE_NEW", 2, "New 红点", 1);
    ADI = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE", 3, "带 TITLE 红点", 2);
    ADJ = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_ICON", 4, "带 ICON 红点", 3);
    ADK = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON", 5, "同时带 TITLE 和 ICON 红点", 4);
    ADL = new k("MMNEWTIPS_SHOWTYPE_COUNTER", 6, "计数红点", 5);
    ADN = new k[] { ADF, ADG, ADH, ADI, ADJ, ADK, ADL };
    AppMethodBeat.o(127257);
  }
  
  private k(String paramString, int paramInt)
  {
    this.ADM = paramString;
    this.value = paramInt;
  }
  
  public static k TE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ADG;
    case 0: 
      return ADG;
    case 1: 
      return ADH;
    case 2: 
      return ADI;
    case 3: 
      return ADJ;
    case 4: 
      return ADK;
    case 5: 
      return ADL;
    }
    return ADF;
  }
  
  public static ehv a(k paramk, c paramc)
  {
    AppMethodBeat.i(127255);
    ehv localehv = new ehv();
    switch (1.ADy[paramk.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127255);
      return localehv;
      localehv.title = paramc.field_title;
      continue;
      localehv.url = paramc.field_icon_url;
      continue;
      localehv.url = paramc.field_icon_url;
      localehv.title = paramc.field_title;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(127256);
    String str = "NewTipsShowType{commet='" + this.ADM + '\'' + ", value=" + this.value + '}';
    AppMethodBeat.o(127256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.k
 * JD-Core Version:    0.7.0.1
 */