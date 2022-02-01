package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bc
{
  public static final bc FzA;
  public static final bc FzB;
  public static final bc FzC;
  public static final bc FzD;
  public static final bc FzE;
  public static final bc FzF;
  public static final bc FzG;
  public static final bc FzH;
  public static final bc FzI;
  public static final bc FzJ;
  public static final bc Fzx;
  public static final bc Fzy;
  public static final bc Fzz;
  public int tGD = 0;
  public String tag = "";
  
  static
  {
    AppMethodBeat.i(133298);
    Fzx = new bc("timeline");
    Fzy = new bc("album_friend");
    Fzz = new bc("album_self");
    FzA = new bc("album_stranger");
    FzB = new bc("profile_friend");
    FzC = new bc("profile_stranger");
    FzD = new bc("comment");
    FzE = new bc("comment_detail");
    FzF = new bc("other");
    FzG = new bc("snssight");
    FzH = new bc("fts");
    FzI = new bc("storysight");
    FzJ = new bc("storyalbum");
    AppMethodBeat.o(133298);
  }
  
  public bc(String paramString)
  {
    this.tag = paramString;
  }
  
  public static bc a(bc parambc, int paramInt)
  {
    AppMethodBeat.i(133295);
    parambc = new bc(parambc.tag);
    parambc.tGD = paramInt;
    AppMethodBeat.o(133295);
    return parambc;
  }
  
  public static bc eLG()
  {
    AppMethodBeat.i(133288);
    bc localbc = new bc("timeline");
    AppMethodBeat.o(133288);
    return localbc;
  }
  
  public static bc eLH()
  {
    AppMethodBeat.i(133289);
    bc localbc = new bc("album_friend");
    AppMethodBeat.o(133289);
    return localbc;
  }
  
  public static bc eLI()
  {
    AppMethodBeat.i(133290);
    bc localbc = new bc("album_self");
    AppMethodBeat.o(133290);
    return localbc;
  }
  
  public static bc eLJ()
  {
    AppMethodBeat.i(133291);
    bc localbc = new bc("album_stranger");
    AppMethodBeat.o(133291);
    return localbc;
  }
  
  public static bc eLK()
  {
    AppMethodBeat.i(133292);
    bc localbc = new bc("comment_detail");
    AppMethodBeat.o(133292);
    return localbc;
  }
  
  public static bc eLL()
  {
    AppMethodBeat.i(133293);
    bc localbc = new bc("snssight");
    AppMethodBeat.o(133293);
    return localbc;
  }
  
  public static bc eLM()
  {
    AppMethodBeat.i(133294);
    bc localbc = new bc("storysight");
    AppMethodBeat.o(133294);
    return localbc;
  }
  
  public final bc WB(int paramInt)
  {
    this.tGD = paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(133296);
    if ((paramObject instanceof bc))
    {
      bool = ((bc)paramObject).tag.equals(this.tag);
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
    String str = this.tag + "@" + this.tGD;
    AppMethodBeat.o(133297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bc
 * JD-Core Version:    0.7.0.1
 */