package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bj
{
  public static final bj ILN;
  public static final bj ILO;
  public static final bj ILP;
  public static final bj ILQ;
  public static final bj ILR;
  public static final bj ILS;
  public static final bj ILT;
  public static final bj ILU;
  public static final bj ILV;
  public static final bj ILW;
  public static final bj ILX;
  public static final bj ILY;
  public static final bj ILZ;
  public int hbR = 0;
  public String tag = "";
  
  static
  {
    AppMethodBeat.i(133298);
    ILN = new bj("timeline");
    ILO = new bj("album_friend");
    ILP = new bj("album_self");
    ILQ = new bj("album_stranger");
    ILR = new bj("profile_friend");
    ILS = new bj("profile_stranger");
    ILT = new bj("comment");
    ILU = new bj("comment_detail");
    ILV = new bj("other");
    ILW = new bj("snssight");
    ILX = new bj("fts");
    ILY = new bj("storysight");
    ILZ = new bj("storyalbum");
    AppMethodBeat.o(133298);
  }
  
  public bj(String paramString)
  {
    this.tag = paramString;
  }
  
  public static bj a(bj parambj, int paramInt)
  {
    AppMethodBeat.i(133295);
    parambj = new bj(parambj.tag);
    parambj.hbR = paramInt;
    AppMethodBeat.o(133295);
    return parambj;
  }
  
  public static bj frn()
  {
    AppMethodBeat.i(133288);
    bj localbj = new bj("timeline");
    AppMethodBeat.o(133288);
    return localbj;
  }
  
  public static bj fro()
  {
    AppMethodBeat.i(133289);
    bj localbj = new bj("album_friend");
    AppMethodBeat.o(133289);
    return localbj;
  }
  
  public static bj frp()
  {
    AppMethodBeat.i(133290);
    bj localbj = new bj("album_self");
    AppMethodBeat.o(133290);
    return localbj;
  }
  
  public static bj frq()
  {
    AppMethodBeat.i(133291);
    bj localbj = new bj("album_stranger");
    AppMethodBeat.o(133291);
    return localbj;
  }
  
  public static bj frr()
  {
    AppMethodBeat.i(133292);
    bj localbj = new bj("comment_detail");
    AppMethodBeat.o(133292);
    return localbj;
  }
  
  public static bj frs()
  {
    AppMethodBeat.i(133293);
    bj localbj = new bj("snssight");
    AppMethodBeat.o(133293);
    return localbj;
  }
  
  public static bj frt()
  {
    AppMethodBeat.i(133294);
    bj localbj = new bj("storysight");
    AppMethodBeat.o(133294);
    return localbj;
  }
  
  public final bj aaU(int paramInt)
  {
    this.hbR = paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(133296);
    if ((paramObject instanceof bj))
    {
      bool = ((bj)paramObject).tag.equals(this.tag);
      AppMethodBeat.o(133296);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(133296);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133297);
    String str = this.tag + "@" + this.hbR;
    AppMethodBeat.o(133297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bj
 * JD-Core Version:    0.7.0.1
 */