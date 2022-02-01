package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bp
{
  public static final bp VGh;
  public static final bp VGi;
  public static final bp VGj;
  public static final bp VGk;
  public static final bp VGl;
  public static final bp VGm;
  public static final bp VGn;
  public static final bp VGo;
  public static final bp VGp;
  public static final bp VGq;
  public static final bp VGr;
  public static final bp VGs;
  public static final bp VGt;
  public String tag = "";
  public int time = 0;
  
  static
  {
    AppMethodBeat.i(133298);
    VGh = new bp("timeline");
    VGi = new bp("album_friend");
    VGj = new bp("album_self");
    VGk = new bp("album_stranger");
    VGl = new bp("profile_friend");
    VGm = new bp("profile_stranger");
    VGn = new bp("comment");
    VGo = new bp("comment_detail");
    VGp = new bp("other");
    VGq = new bp("snssight");
    VGr = new bp("fts");
    VGs = new bp("storysight");
    VGt = new bp("storyalbum");
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
    parambp.time = paramInt;
    AppMethodBeat.o(133295);
    return parambp;
  }
  
  public static bp hzh()
  {
    AppMethodBeat.i(133288);
    bp localbp = new bp("timeline");
    AppMethodBeat.o(133288);
    return localbp;
  }
  
  public static bp hzi()
  {
    AppMethodBeat.i(133289);
    bp localbp = new bp("album_friend");
    AppMethodBeat.o(133289);
    return localbp;
  }
  
  public static bp hzj()
  {
    AppMethodBeat.i(133290);
    bp localbp = new bp("album_self");
    AppMethodBeat.o(133290);
    return localbp;
  }
  
  public static bp hzk()
  {
    AppMethodBeat.i(133291);
    bp localbp = new bp("album_stranger");
    AppMethodBeat.o(133291);
    return localbp;
  }
  
  public static bp hzl()
  {
    AppMethodBeat.i(133292);
    bp localbp = new bp("comment_detail");
    AppMethodBeat.o(133292);
    return localbp;
  }
  
  public static bp hzm()
  {
    AppMethodBeat.i(133293);
    bp localbp = new bp("snssight");
    AppMethodBeat.o(133293);
    return localbp;
  }
  
  public static bp hzn()
  {
    AppMethodBeat.i(133294);
    bp localbp = new bp("storysight");
    AppMethodBeat.o(133294);
    return localbp;
  }
  
  public final bp asH(int paramInt)
  {
    this.time = paramInt;
    return this;
  }
  
  public boolean equals(Object paramObject)
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
  
  public String toString()
  {
    AppMethodBeat.i(133297);
    String str = this.tag + "@" + this.time;
    AppMethodBeat.o(133297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bp
 * JD-Core Version:    0.7.0.1
 */