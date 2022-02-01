package com.tencent.mm.pluginsdk.res.downloader.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public final String XUX;
  public final Exception XWJ;
  public final Bundle bundle;
  public final long contentLength;
  public final String contentType;
  public final String filePath;
  final String groupId;
  public final int httpStatusCode;
  public final int status;
  public final String url;
  
  public l(e parame, long paramLong, String paramString)
  {
    this(parame.aVp(), parame.iJd(), parame.cgR(), parame.getFilePath(), paramLong, paramString, 2, null, -1);
    AppMethodBeat.i(152032);
    AppMethodBeat.o(152032);
  }
  
  public l(e parame, Exception paramException, int paramInt)
  {
    this(parame, paramException, -1, paramInt);
  }
  
  public l(e parame, Exception paramException, int paramInt1, int paramInt2)
  {
    this(parame.aVp(), parame.iJd(), parame.cgR(), parame.getFilePath(), -1L, null, paramInt2, paramException, paramInt1);
    AppMethodBeat.i(152033);
    AppMethodBeat.o(152033);
  }
  
  public l(k paramk, long paramLong)
  {
    this(paramk.aVp(), paramk.XUX, paramk.url, paramk.getFilePath(), paramLong, null, 2, null, -1);
    AppMethodBeat.i(152031);
    AppMethodBeat.o(152031);
  }
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt, Exception paramException)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, paramInt, paramException, -1);
  }
  
  private l(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt1, Exception paramException, int paramInt2)
  {
    AppMethodBeat.i(152030);
    this.bundle = new Bundle();
    this.groupId = paramString1;
    this.XUX = paramString2;
    this.url = paramString3;
    this.filePath = paramString4;
    this.contentLength = paramLong;
    this.contentType = paramString5;
    this.status = paramInt1;
    this.XWJ = paramException;
    this.httpStatusCode = paramInt2;
    AppMethodBeat.o(152030);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152034);
    String str = "NetworkResponse{urlKey='" + this.XUX + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.contentLength + ", contentType='" + this.contentType + '\'' + ", status=" + this.status + ", e=" + this.XWJ + '}';
    AppMethodBeat.o(152034);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.l
 * JD-Core Version:    0.7.0.1
 */