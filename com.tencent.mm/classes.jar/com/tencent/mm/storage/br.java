package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class br
{
  public static final br adjV;
  public static final br adjW;
  public static final br adjX;
  public static final br adjY;
  public static final br adjZ;
  public static final br adka;
  public static final br adkb;
  public static final br adkc;
  public static final br adkd;
  public static final br adke;
  public static final br adkf;
  public static final br adkg;
  public static final br adkh;
  public String tag = "";
  public int time = 0;
  
  static
  {
    AppMethodBeat.i(133298);
    adjV = new br("timeline");
    adjW = new br("album_friend");
    adjX = new br("album_self");
    adjY = new br("album_stranger");
    adjZ = new br("profile_friend");
    adka = new br("profile_stranger");
    adkb = new br("comment");
    adkc = new br("comment_detail");
    adkd = new br("other");
    adke = new br("snssight");
    adkf = new br("fts");
    adkg = new br("storysight");
    adkh = new br("storyalbum");
    AppMethodBeat.o(133298);
  }
  
  public br(String paramString)
  {
    this.tag = paramString;
  }
  
  public static br a(br parambr, int paramInt)
  {
    AppMethodBeat.i(133295);
    parambr = new br(parambr.tag);
    parambr.time = paramInt;
    AppMethodBeat.o(133295);
    return parambr;
  }
  
  public static br jbh()
  {
    AppMethodBeat.i(133288);
    br localbr = new br("timeline");
    AppMethodBeat.o(133288);
    return localbr;
  }
  
  public static br jbi()
  {
    AppMethodBeat.i(133289);
    br localbr = new br("album_friend");
    AppMethodBeat.o(133289);
    return localbr;
  }
  
  public static br jbj()
  {
    AppMethodBeat.i(133290);
    br localbr = new br("album_self");
    AppMethodBeat.o(133290);
    return localbr;
  }
  
  public static br jbk()
  {
    AppMethodBeat.i(133291);
    br localbr = new br("album_stranger");
    AppMethodBeat.o(133291);
    return localbr;
  }
  
  public static br jbl()
  {
    AppMethodBeat.i(133292);
    br localbr = new br("comment_detail");
    AppMethodBeat.o(133292);
    return localbr;
  }
  
  public static br jbm()
  {
    AppMethodBeat.i(133293);
    br localbr = new br("snssight");
    AppMethodBeat.o(133293);
    return localbr;
  }
  
  public static br jbn()
  {
    AppMethodBeat.i(133294);
    br localbr = new br("storysight");
    AppMethodBeat.o(133294);
    return localbr;
  }
  
  public final br ayX(int paramInt)
  {
    this.time = paramInt;
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(133296);
    if ((paramObject instanceof br))
    {
      bool = ((br)paramObject).tag.equals(this.tag);
      AppMethodBeat.o(133296);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(133296);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133297);
    String str = this.tag + "@" + this.time;
    AppMethodBeat.o(133297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.br
 * JD-Core Version:    0.7.0.1
 */