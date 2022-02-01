package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bf
{
  public static final bf GYA;
  public static final bf GYB;
  public static final bf GYC;
  public static final bf GYD;
  public static final bf GYE;
  public static final bf GYF;
  public static final bf GYG;
  public static final bf GYH;
  public static final bf GYI;
  public static final bf GYJ;
  public static final bf GYK;
  public static final bf GYL;
  public static final bf GYz;
  public int gIh = 0;
  public String tag = "";
  
  static
  {
    AppMethodBeat.i(133298);
    GYz = new bf("timeline");
    GYA = new bf("album_friend");
    GYB = new bf("album_self");
    GYC = new bf("album_stranger");
    GYD = new bf("profile_friend");
    GYE = new bf("profile_stranger");
    GYF = new bf("comment");
    GYG = new bf("comment_detail");
    GYH = new bf("other");
    GYI = new bf("snssight");
    GYJ = new bf("fts");
    GYK = new bf("storysight");
    GYL = new bf("storyalbum");
    AppMethodBeat.o(133298);
  }
  
  public bf(String paramString)
  {
    this.tag = paramString;
  }
  
  public static bf a(bf parambf, int paramInt)
  {
    AppMethodBeat.i(133295);
    parambf = new bf(parambf.tag);
    parambf.gIh = paramInt;
    AppMethodBeat.o(133295);
    return parambf;
  }
  
  public static bf fbk()
  {
    AppMethodBeat.i(133288);
    bf localbf = new bf("timeline");
    AppMethodBeat.o(133288);
    return localbf;
  }
  
  public static bf fbl()
  {
    AppMethodBeat.i(133289);
    bf localbf = new bf("album_friend");
    AppMethodBeat.o(133289);
    return localbf;
  }
  
  public static bf fbm()
  {
    AppMethodBeat.i(133290);
    bf localbf = new bf("album_self");
    AppMethodBeat.o(133290);
    return localbf;
  }
  
  public static bf fbn()
  {
    AppMethodBeat.i(133291);
    bf localbf = new bf("album_stranger");
    AppMethodBeat.o(133291);
    return localbf;
  }
  
  public static bf fbo()
  {
    AppMethodBeat.i(133292);
    bf localbf = new bf("comment_detail");
    AppMethodBeat.o(133292);
    return localbf;
  }
  
  public static bf fbp()
  {
    AppMethodBeat.i(133293);
    bf localbf = new bf("snssight");
    AppMethodBeat.o(133293);
    return localbf;
  }
  
  public static bf fbq()
  {
    AppMethodBeat.i(133294);
    bf localbf = new bf("storysight");
    AppMethodBeat.o(133294);
    return localbf;
  }
  
  public final bf YL(int paramInt)
  {
    this.gIh = paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(133296);
    if ((paramObject instanceof bf))
    {
      bool = ((bf)paramObject).tag.equals(this.tag);
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
    String str = this.tag + "@" + this.gIh;
    AppMethodBeat.o(133297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bf
 * JD-Core Version:    0.7.0.1
 */