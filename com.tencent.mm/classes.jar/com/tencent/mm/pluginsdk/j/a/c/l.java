package com.tencent.mm.pluginsdk.j.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l
  implements f.b
{
  public final String EPe;
  final int EPm;
  protected final Map<String, String> EQK = new HashMap();
  protected volatile int EQL = 20000;
  protected volatile int EQM = 15000;
  private final String EQv;
  private final String filePath;
  private final String groupId;
  protected volatile int mQE = 15000;
  private final String method;
  final int networkType;
  final int priority;
  public final String url;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.EPe = paramString1;
    this.filePath = paramString2;
    this.EQv = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.EPm = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String afw()
  {
    return this.groupId;
  }
  
  public final String faC()
  {
    return this.EPe;
  }
  
  public boolean faK()
  {
    return false;
  }
  
  public final int faY()
  {
    return this.EQM;
  }
  
  public final int getConnectTimeout()
  {
    return this.mQE;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public final int getReadTimeout()
  {
    return this.EQL;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.EQK.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.EQK);
  }
  
  public final String getURL()
  {
    return this.url;
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.mQE = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.EQL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.l
 * JD-Core Version:    0.7.0.1
 */