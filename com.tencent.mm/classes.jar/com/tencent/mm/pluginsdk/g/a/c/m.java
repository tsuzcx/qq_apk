package com.tencent.mm.pluginsdk.g.a.c;

public final class m
{
  public final String aRN;
  public final long ceJ;
  public final String filePath;
  final String groupId;
  public final int httpStatusCode;
  public final String rVT;
  public final Exception rXE;
  public final int status;
  private final String url;
  
  public m(e parame, long paramLong, String paramString)
  {
    this(parame.acb(), parame.cls(), parame.getURL(), parame.bjl(), paramLong, paramString, 2, null, -1);
  }
  
  public m(e parame, Exception paramException, int paramInt)
  {
    this(parame, paramException, -1, paramInt);
  }
  
  public m(e parame, Exception paramException, int paramInt1, int paramInt2)
  {
    this(parame.acb(), parame.cls(), parame.getURL(), parame.bjl(), -1L, null, paramInt2, paramException, paramInt1);
  }
  
  public m(l paraml, long paramLong)
  {
    this(paraml.acb(), paraml.rVT, paraml.url, paraml.bjl(), paramLong, null, 2, null, -1);
  }
  
  private m(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt1, Exception paramException, int paramInt2)
  {
    this.groupId = paramString1;
    this.rVT = paramString2;
    this.url = paramString3;
    this.filePath = paramString4;
    this.ceJ = paramLong;
    this.aRN = paramString5;
    this.status = paramInt1;
    this.rXE = paramException;
    this.httpStatusCode = paramInt2;
  }
  
  public m(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, Exception paramException)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, 3, paramException, -1);
  }
  
  public final String toString()
  {
    return "NetworkResponse{urlKey='" + this.rVT + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.ceJ + ", contentType='" + this.aRN + '\'' + ", status=" + this.status + ", e=" + this.rXE + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.m
 * JD-Core Version:    0.7.0.1
 */