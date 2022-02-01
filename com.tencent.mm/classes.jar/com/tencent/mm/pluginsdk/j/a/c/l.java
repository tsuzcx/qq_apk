package com.tencent.mm.pluginsdk.j.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l
  implements f.b
{
  final int JYA;
  public final String JYs;
  private final String JZK;
  protected final Map<String, String> JZZ = new HashMap();
  protected volatile int Kaa = 15000;
  protected volatile int connectTimeout = 15000;
  private final String filePath;
  private final String groupId;
  private final String method;
  final int networkType;
  final int priority;
  protected volatile int readTimeout = 20000;
  public final String url;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.JYs = paramString1;
    this.filePath = paramString2;
    this.JZK = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.JYA = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String avy()
  {
    return this.groupId;
  }
  
  public final int getConnectTimeout()
  {
    return this.connectTimeout;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public final int getReadTimeout()
  {
    return this.readTimeout;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.JZZ.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.JZZ);
  }
  
  public final String getURL()
  {
    return this.url;
  }
  
  public final String gnA()
  {
    return this.JYs;
  }
  
  public boolean gnI()
  {
    return false;
  }
  
  public final int gnW()
  {
    return this.Kaa;
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.connectTimeout = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.readTimeout = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.l
 * JD-Core Version:    0.7.0.1
 */