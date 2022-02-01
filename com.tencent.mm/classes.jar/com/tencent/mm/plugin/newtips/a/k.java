package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.dnz;

public enum k
{
  public final int value;
  public final String wIB;
  
  static
  {
    AppMethodBeat.i(127257);
    wIu = new k("MMNEWTIPS_SHOWTYPE_NONE", 0, "无红点", 10000);
    wIv = new k("MMNEWTIPS_SHOWTYPE_REDPOINT", 1, "普通红点", 0);
    wIw = new k("MMNEWTIPS_SHOWTYPE_NEW", 2, "New 红点", 1);
    wIx = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE", 3, "带 TITLE 红点", 2);
    wIy = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_ICON", 4, "带 ICON 红点", 3);
    wIz = new k("MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON", 5, "同时带 TITLE 和 ICON 红点", 4);
    wIA = new k("MMNEWTIPS_SHOWTYPE_COUNTER", 6, "计数红点", 5);
    wIC = new k[] { wIu, wIv, wIw, wIx, wIy, wIz, wIA };
    AppMethodBeat.o(127257);
  }
  
  private k(String paramString, int paramInt)
  {
    this.wIB = paramString;
    this.value = paramInt;
  }
  
  public static k Mx(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return wIv;
    case 0: 
      return wIv;
    case 1: 
      return wIw;
    case 2: 
      return wIx;
    case 3: 
      return wIy;
    case 4: 
      return wIz;
    case 5: 
      return wIA;
    }
    return wIu;
  }
  
  public static dnz a(k paramk, c paramc)
  {
    AppMethodBeat.i(127255);
    dnz localdnz = new dnz();
    switch (1.wIo[paramk.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127255);
      return localdnz;
      localdnz.title = paramc.field_title;
      continue;
      localdnz.url = paramc.field_icon_url;
      continue;
      localdnz.url = paramc.field_icon_url;
      localdnz.title = paramc.field_title;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(127256);
    String str = "NewTipsShowType{commet='" + this.wIB + '\'' + ", value=" + this.value + '}';
    AppMethodBeat.o(127256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.k
 * JD-Core Version:    0.7.0.1
 */