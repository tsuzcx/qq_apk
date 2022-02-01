package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bp
{
  public static final bp Oql;
  public static final bp Oqm;
  public static final bp Oqn;
  public static final bp Oqo;
  public static final bp Oqp;
  public static final bp Oqq;
  public static final bp Oqr;
  public static final bp Oqs;
  public static final bp Oqt;
  public static final bp Oqu;
  public static final bp Oqv;
  public static final bp Oqw;
  public static final bp Oqx;
  public int hXs = 0;
  public String tag = "";
  
  static
  {
    AppMethodBeat.i(133298);
    Oql = new bp("timeline");
    Oqm = new bp("album_friend");
    Oqn = new bp("album_self");
    Oqo = new bp("album_stranger");
    Oqp = new bp("profile_friend");
    Oqq = new bp("profile_stranger");
    Oqr = new bp("comment");
    Oqs = new bp("comment_detail");
    Oqt = new bp("other");
    Oqu = new bp("snssight");
    Oqv = new bp("fts");
    Oqw = new bp("storysight");
    Oqx = new bp("storyalbum");
    AppMethodBeat.o(133298);
  }
  
  public bp(String paramString)
  {
    this.tag = paramString;
  }
  
  public static bp a(bp parambp, int paramInt)
  {
    AppMethodBeat.i(133295);
    parambp = new bp(parambp.tag);
    parambp.hXs = paramInt;
    AppMethodBeat.o(133295);
    return parambp;
  }
  
  public static bp gCU()
  {
    AppMethodBeat.i(133288);
    bp localbp = new bp("timeline");
    AppMethodBeat.o(133288);
    return localbp;
  }
  
  public static bp gCV()
  {
    AppMethodBeat.i(133289);
    bp localbp = new bp("album_friend");
    AppMethodBeat.o(133289);
    return localbp;
  }
  
  public static bp gCW()
  {
    AppMethodBeat.i(133290);
    bp localbp = new bp("album_self");
    AppMethodBeat.o(133290);
    return localbp;
  }
  
  public static bp gCX()
  {
    AppMethodBeat.i(133291);
    bp localbp = new bp("album_stranger");
    AppMethodBeat.o(133291);
    return localbp;
  }
  
  public static bp gCY()
  {
    AppMethodBeat.i(133292);
    bp localbp = new bp("comment_detail");
    AppMethodBeat.o(133292);
    return localbp;
  }
  
  public static bp gCZ()
  {
    AppMethodBeat.i(133293);
    bp localbp = new bp("snssight");
    AppMethodBeat.o(133293);
    return localbp;
  }
  
  public static bp gDa()
  {
    AppMethodBeat.i(133294);
    bp localbp = new bp("storysight");
    AppMethodBeat.o(133294);
    return localbp;
  }
  
  public final bp akk(int paramInt)
  {
    this.hXs = paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(133296);
    if ((paramObject instanceof bp))
    {
      bool = ((bp)paramObject).tag.equals(this.tag);
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
    String str = this.tag + "@" + this.hXs;
    AppMethodBeat.o(133297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bp
 * JD-Core Version:    0.7.0.1
 */