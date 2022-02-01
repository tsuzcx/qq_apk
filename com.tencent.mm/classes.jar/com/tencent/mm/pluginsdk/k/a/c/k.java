package com.tencent.mm.pluginsdk.k.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class k
  implements f.b
{
  public final String QYU;
  final int QZc;
  protected final Map<String, String> RaC = new HashMap();
  protected volatile int RaD = 15000;
  private final String Ran;
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
    this.QYU = paramString1;
    this.filePath = paramString2;
    this.Ran = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.QZc = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String aCt()
  {
    return this.groupId;
  }
  
  public final String btD()
  {
    return this.url;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.RaC.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.RaC);
  }
  
  public final int hiD()
  {
    return this.connectTimeout;
  }
  
  public final int hiE()
  {
    return this.readTimeout;
  }
  
  public final int hiF()
  {
    return this.RaD;
  }
  
  public final String hig()
  {
    return this.QYU;
  }
  
  public boolean hio()
  {
    return false;
  }
  
  public final void xA(int paramInt)
  {
    this.readTimeout = paramInt;
  }
  
  public final void xz(int paramInt)
  {
    this.connectTimeout = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.k
 * JD-Core Version:    0.7.0.1
 */