package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.dcb;

public enum k
{
  public final String ueB;
  public final int value;
  
  static
  {
    AppMethodBeat.i(127257);
    ueu = new k("MMNEWTIPS_SHOWTYPE_NONE", 0, "无红点", 10000);
    uev = new k("MMNEWTIPS_SHOWTYPE_REDPOINT", 1, "普通红点", 0);
    uew = new k("MMNEWTIPS_SHOWTYPE_NEW", 2, "New 红点", 1);
    uex = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE", 3, "带 TITLE 红点", 2);
    uey = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_ICON", 4, "带 ICON 红点", 3);
    uez = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON", 5, "同时带 TITLE 和 ICON 红点", 4);
    ueA = new k("MMNEWTIPS_SHOWTYPE_COUNTER", 6, "计数红点", 5);
    ueC = new k[] { ueu, uev, uew, uex, uey, uez, ueA };
    AppMethodBeat.o(127257);
  }
  
  private k(String paramString, int paramInt)
  {
    this.ueB = paramString;
    this.value = paramInt;
  }
  
  public static k Ir(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return uev;
    case 0: 
      return uev;
    case 1: 
      return uew;
    case 2: 
      return uex;
    case 3: 
      return uey;
    case 4: 
      return uez;
    case 5: 
      return ueA;
    }
    return ueu;
  }
  
  public static dcb a(k paramk, c paramc)
  {
    AppMethodBeat.i(127255);
    dcb localdcb = new dcb();
    switch (1.uep[paramk.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127255);
      return localdcb;
      localdcb.title = paramc.field_title;
      continue;
      localdcb.url = paramc.field_icon_url;
      continue;
      localdcb.url = paramc.field_icon_url;
      localdcb.title = paramc.field_title;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(127256);
    String str = "NewTipsShowType{commet='" + this.ueB + '\'' + ", value=" + this.value + '}';
    AppMethodBeat.o(127256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.k
 * JD-Core Version:    0.7.0.1
 */