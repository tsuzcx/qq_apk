package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class az
{
  public static final az yNM;
  public static final az yNN;
  public static final az yNO;
  public static final az yNP;
  public static final az yNQ;
  public static final az yNR;
  public static final az yNS;
  public static final az yNT;
  public static final az yNU;
  public static final az yNV;
  public static final az yNW;
  public static final az yNX;
  public static final az yNY;
  public int oLs = 0;
  public String tag = "";
  
  static
  {
    AppMethodBeat.i(59006);
    yNM = new az("timeline");
    yNN = new az("album_friend");
    yNO = new az("album_self");
    yNP = new az("album_stranger");
    yNQ = new az("profile_friend");
    yNR = new az("profile_stranger");
    yNS = new az("comment");
    yNT = new az("comment_detail");
    yNU = new az("other");
    yNV = new az("snssight");
    yNW = new az("fts");
    yNX = new az("storysight");
    yNY = new az("storyalbum");
    AppMethodBeat.o(59006);
  }
  
  public az(String paramString)
  {
    this.tag = paramString;
  }
  
  public static az a(az paramaz, int paramInt)
  {
    AppMethodBeat.i(59003);
    paramaz = new az(paramaz.tag);
    paramaz.oLs = paramInt;
    AppMethodBeat.o(59003);
    return paramaz;
  }
  
  public static az dxB()
  {
    AppMethodBeat.i(58996);
    az localaz = new az("timeline");
    AppMethodBeat.o(58996);
    return localaz;
  }
  
  public static az dxC()
  {
    AppMethodBeat.i(58997);
    az localaz = new az("album_friend");
    AppMethodBeat.o(58997);
    return localaz;
  }
  
  public static az dxD()
  {
    AppMethodBeat.i(58998);
    az localaz = new az("album_self");
    AppMethodBeat.o(58998);
    return localaz;
  }
  
  public static az dxE()
  {
    AppMethodBeat.i(58999);
    az localaz = new az("album_stranger");
    AppMethodBeat.o(58999);
    return localaz;
  }
  
  public static az dxF()
  {
    AppMethodBeat.i(59000);
    az localaz = new az("comment_detail");
    AppMethodBeat.o(59000);
    return localaz;
  }
  
  public static az dxG()
  {
    AppMethodBeat.i(59001);
    az localaz = new az("snssight");
    AppMethodBeat.o(59001);
    return localaz;
  }
  
  public static az dxH()
  {
    AppMethodBeat.i(59002);
    az localaz = new az("storysight");
    AppMethodBeat.o(59002);
    return localaz;
  }
  
  public final az Nv(int paramInt)
  {
    this.oLs = paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59004);
    if ((paramObject instanceof az))
    {
      bool = ((az)paramObject).tag.equals(this.tag);
      AppMethodBeat.o(59004);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(59004);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59005);
    String str = this.tag + "@" + this.oLs;
    AppMethodBeat.o(59005);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.az
 * JD-Core Version:    0.7.0.1
 */