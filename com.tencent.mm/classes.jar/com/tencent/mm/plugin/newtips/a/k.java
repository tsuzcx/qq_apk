package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.dnc;

public enum k
{
  public final int value;
  public final String wsR;
  
  static
  {
    AppMethodBeat.i(127257);
    wsK = new k("MMNEWTIPS_SHOWTYPE_NONE", 0, "无红点", 10000);
    wsL = new k("MMNEWTIPS_SHOWTYPE_REDPOINT", 1, "普通红点", 0);
    wsM = new k("MMNEWTIPS_SHOWTYPE_NEW", 2, "New 红点", 1);
    wsN = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE", 3, "带 TITLE 红点", 2);
    wsO = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_ICON", 4, "带 ICON 红点", 3);
    wsP = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON", 5, "同时带 TITLE 和 ICON 红点", 4);
    wsQ = new k("MMNEWTIPS_SHOWTYPE_COUNTER", 6, "计数红点", 5);
    wsS = new k[] { wsK, wsL, wsM, wsN, wsO, wsP, wsQ };
    AppMethodBeat.o(127257);
  }
  
  private k(String paramString, int paramInt)
  {
    this.wsR = paramString;
    this.value = paramInt;
  }
  
  public static k LS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return wsL;
    case 0: 
      return wsL;
    case 1: 
      return wsM;
    case 2: 
      return wsN;
    case 3: 
      return wsO;
    case 4: 
      return wsP;
    case 5: 
      return wsQ;
    }
    return wsK;
  }
  
  public static dnc a(k paramk, c paramc)
  {
    AppMethodBeat.i(127255);
    dnc localdnc = new dnc();
    switch (1.wsF[paramk.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127255);
      return localdnc;
      localdnc.title = paramc.field_title;
      continue;
      localdnc.url = paramc.field_icon_url;
      continue;
      localdnc.url = paramc.field_icon_url;
      localdnc.title = paramc.field_title;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(127256);
    String str = "NewTipsShowType{commet='" + this.wsR + '\'' + ", value=" + this.value + '}';
    AppMethodBeat.o(127256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.k
 * JD-Core Version:    0.7.0.1
 */