package com.tencent.mm.pluginsdk.res.downloader.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class k
  implements f.b
{
  public final String XUX;
  final int XVf;
  protected final Map<String, String> XWH = new HashMap();
  protected volatile int XWI = 15000;
  private final String XWr;
  protected volatile int connectTimeout = 15000;
  private final String filePath;
  private final String groupId;
  private final String method;
  final int networkType;
  final int priority;
  protected volatile int readTimeout = 20000;
  public final String url;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.XUX = paramString1;
    this.filePath = paramString2;
    this.XWr = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.XVf = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String aVp()
  {
    return this.groupId;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.XWH.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.XWH);
  }
  
  public final int iJC()
  {
    return this.connectTimeout;
  }
  
  public final int iJD()
  {
    return this.readTimeout;
  }
  
  public final int iJE()
  {
    return this.XWI;
  }
  
  public final String iJd()
  {
    return this.XUX;
  }
  
  public boolean iJn()
  {
    return false;
  }
  
  public final void xx(int paramInt)
  {
    this.connectTimeout = paramInt;
  }
  
  public final void xy(int paramInt)
  {
    this.readTimeout = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.k
 * JD-Core Version:    0.7.0.1
 */