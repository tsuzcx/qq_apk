package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bk
{
  public static final bk JgA;
  public static final bk JgB;
  public static final bk JgC;
  public static final bk JgD;
  public static final bk JgE;
  public static final bk JgF;
  public static final bk JgG;
  public static final bk Jgu;
  public static final bk Jgv;
  public static final bk Jgw;
  public static final bk Jgx;
  public static final bk Jgy;
  public static final bk Jgz;
  public int heF = 0;
  public String tag = "";
  
  static
  {
    AppMethodBeat.i(133298);
    Jgu = new bk("timeline");
    Jgv = new bk("album_friend");
    Jgw = new bk("album_self");
    Jgx = new bk("album_stranger");
    Jgy = new bk("profile_friend");
    Jgz = new bk("profile_stranger");
    JgA = new bk("comment");
    JgB = new bk("comment_detail");
    JgC = new bk("other");
    JgD = new bk("snssight");
    JgE = new bk("fts");
    JgF = new bk("storysight");
    JgG = new bk("storyalbum");
    AppMethodBeat.o(133298);
  }
  
  public bk(String paramString)
  {
    this.tag = paramString;
  }
  
  public static bk a(bk parambk, int paramInt)
  {
    AppMethodBeat.i(133295);
    parambk = new bk(parambk.tag);
    parambk.heF = paramInt;
    AppMethodBeat.o(133295);
    return parambk;
  }
  
  public static bk fvn()
  {
    AppMethodBeat.i(133288);
    bk localbk = new bk("timeline");
    AppMethodBeat.o(133288);
    return localbk;
  }
  
  public static bk fvo()
  {
    AppMethodBeat.i(133289);
    bk localbk = new bk("album_friend");
    AppMethodBeat.o(133289);
    return localbk;
  }
  
  public static bk fvp()
  {
    AppMethodBeat.i(133290);
    bk localbk = new bk("album_self");
    AppMethodBeat.o(133290);
    return localbk;
  }
  
  public static bk fvq()
  {
    AppMethodBeat.i(133291);
    bk localbk = new bk("album_stranger");
    AppMethodBeat.o(133291);
    return localbk;
  }
  
  public static bk fvr()
  {
    AppMethodBeat.i(133292);
    bk localbk = new bk("comment_detail");
    AppMethodBeat.o(133292);
    return localbk;
  }
  
  public static bk fvs()
  {
    AppMethodBeat.i(133293);
    bk localbk = new bk("snssight");
    AppMethodBeat.o(133293);
    return localbk;
  }
  
  public static bk fvt()
  {
    AppMethodBeat.i(133294);
    bk localbk = new bk("storysight");
    AppMethodBeat.o(133294);
    return localbk;
  }
  
  public final bk abC(int paramInt)
  {
    this.heF = paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(133296);
    if ((paramObject instanceof bk))
    {
      bool = ((bk)paramObject).tag.equals(this.tag);
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
    String str = this.tag + "@" + this.heF;
    AppMethodBeat.o(133297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bk
 * JD-Core Version:    0.7.0.1
 */