package com.tencent.mm.pluginsdk.g.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l
  implements f.b
{
  private final String filePath;
  private final String groupId;
  protected volatile int iZk = 15000;
  private final String method;
  final int networkType;
  final int priority;
  public final String url;
  public final String vMK;
  final int vMT;
  private final String vOd;
  protected final Map<String, String> vOs = new HashMap();
  protected volatile int vOt = 20000;
  protected volatile int vOu = 15000;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.vMK = paramString1;
    this.filePath = paramString2;
    this.vOd = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.vMT = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String avS()
  {
    return this.groupId;
  }
  
  public final String dlZ()
  {
    return this.vMK;
  }
  
  public boolean dmh()
  {
    return false;
  }
  
  public final int dmv()
  {
    return this.vOu;
  }
  
  public final int getConnectTimeout()
  {
    return this.iZk;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public final int getReadTimeout()
  {
    return this.vOt;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.vOs.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.vOs);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.iZk = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.vOt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.l
 * JD-Core Version:    0.7.0.1
 */