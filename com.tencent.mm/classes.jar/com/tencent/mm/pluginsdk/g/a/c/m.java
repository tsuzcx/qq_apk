package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  public final String aZn;
  public final long bad;
  public final String filePath;
  final String groupId;
  public final int httpStatusCode;
  public final int status;
  private final String url;
  public final String vMK;
  public final Exception vOv;
  
  public m(e parame, long paramLong, String paramString)
  {
    this(parame.avS(), parame.dlZ(), parame.getURL(), parame.getFilePath(), paramLong, paramString, 2, null, -1);
    AppMethodBeat.i(79588);
    AppMethodBeat.o(79588);
  }
  
  public m(e parame, Exception paramException, int paramInt)
  {
    this(parame, paramException, -1, paramInt);
  }
  
  public m(e parame, Exception paramException, int paramInt1, int paramInt2)
  {
    this(parame.avS(), parame.dlZ(), parame.getURL(), parame.getFilePath(), -1L, null, paramInt2, paramException, paramInt1);
    AppMethodBeat.i(79589);
    AppMethodBeat.o(79589);
  }
  
  public m(l paraml, long paramLong)
  {
    this(paraml.avS(), paraml.vMK, paraml.url, paraml.getFilePath(), paramLong, null, 2, null, -1);
    AppMethodBeat.i(79587);
    AppMethodBeat.o(79587);
  }
  
  private m(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt1, Exception paramException, int paramInt2)
  {
    this.groupId = paramString1;
    this.vMK = paramString2;
    this.url = paramString3;
    this.filePath = paramString4;
    this.bad = paramLong;
    this.aZn = paramString5;
    this.status = paramInt1;
    this.vOv = paramException;
    this.httpStatusCode = paramInt2;
  }
  
  public m(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, Exception paramException)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, 3, paramException, -1);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(79590);
    String str = "NetworkResponse{urlKey='" + this.vMK + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.bad + ", contentType='" + this.aZn + '\'' + ", status=" + this.status + ", e=" + this.vOv + '}';
    AppMethodBeat.o(79590);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.m
 * JD-Core Version:    0.7.0.1
 */