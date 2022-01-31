package com.tencent.mm.storage;

public final class az
{
  public static final az uBC = new az("timeline");
  public static final az uBD = new az("album_friend");
  public static final az uBE = new az("album_self");
  public static final az uBF = new az("album_stranger");
  public static final az uBG = new az("profile_friend");
  public static final az uBH = new az("profile_stranger");
  public static final az uBI = new az("comment");
  public static final az uBJ = new az("comment_detail");
  public static final az uBK = new az("other");
  public static final az uBL = new az("snssight");
  public static final az uBM = new az("fts");
  public String tag = "";
  public int time = 0;
  
  public az(String paramString)
  {
    this.tag = paramString;
  }
  
  public static az a(az paramaz, int paramInt)
  {
    paramaz = new az(paramaz.tag);
    paramaz.time = paramInt;
    return paramaz;
  }
  
  public static az cuY()
  {
    return new az("timeline");
  }
  
  public static az cuZ()
  {
    return new az("album_friend");
  }
  
  public static az cva()
  {
    return new az("album_self");
  }
  
  public static az cvb()
  {
    return new az("album_stranger");
  }
  
  public static az cvc()
  {
    return new az("comment_detail");
  }
  
  public static az cvd()
  {
    return new az("snssight");
  }
  
  public final az Fp(int paramInt)
  {
    this.time = paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof az)) {
      return ((az)paramObject).tag.equals(this.tag);
    }
    return super.equals(paramObject);
  }
  
  public final String toString()
  {
    return this.tag + "@" + this.time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.az
 * JD-Core Version:    0.7.0.1
 */