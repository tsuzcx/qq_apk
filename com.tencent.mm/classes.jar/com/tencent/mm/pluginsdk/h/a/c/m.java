package com.tencent.mm.pluginsdk.h.a.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  public final String BRL;
  public final Exception BTv;
  public final long aLn;
  public final Bundle bundle;
  public final String bxn;
  public final String filePath;
  final String groupId;
  public final int httpStatusCode;
  public final int status;
  public final String url;
  
  public m(e parame, long paramLong, String paramString)
  {
    this(parame.asy(), parame.ewl(), parame.getURL(), parame.getFilePath(), paramLong, paramString, 2, null, -1);
    AppMethodBeat.i(152032);
    AppMethodBeat.o(152032);
  }
  
  public m(e parame, Exception paramException, int paramInt)
  {
    this(parame, paramException, -1, paramInt);
  }
  
  public m(e parame, Exception paramException, int paramInt1, int paramInt2)
  {
    this(parame.asy(), parame.ewl(), parame.getURL(), parame.getFilePath(), -1L, null, paramInt2, paramException, paramInt1);
    AppMethodBeat.i(152033);
    AppMethodBeat.o(152033);
  }
  
  public m(l paraml, long paramLong)
  {
    this(paraml.asy(), paraml.BRL, paraml.url, paraml.getFilePath(), paramLong, null, 2, null, -1);
    AppMethodBeat.i(152031);
    AppMethodBeat.o(152031);
  }
  
  public m(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt, Exception paramException)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, paramInt, paramException, -1);
  }
  
  private m(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt1, Exception paramException, int paramInt2)
  {
    AppMethodBeat.i(152030);
    this.bundle = new Bundle();
    this.groupId = paramString1;
    this.BRL = paramString2;
    this.url = paramString3;
    this.filePath = paramString4;
    this.aLn = paramLong;
    this.bxn = paramString5;
    this.status = paramInt1;
    this.BTv = paramException;
    this.httpStatusCode = paramInt2;
    AppMethodBeat.o(152030);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152034);
    String str = "NetworkResponse{urlKey='" + this.BRL + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.aLn + ", contentType='" + this.bxn + '\'' + ", status=" + this.status + ", e=" + this.BTv + '}';
    AppMethodBeat.o(152034);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.m
 * JD-Core Version:    0.7.0.1
 */