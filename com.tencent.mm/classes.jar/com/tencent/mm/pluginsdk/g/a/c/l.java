package com.tencent.mm.pluginsdk.g.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l
  implements f.b
{
  private final String filePath;
  private final String groupId;
  protected volatile int hmL = 15000;
  private final String method;
  final int networkType;
  final int priority;
  public final String rVT;
  final int rWd;
  protected final Map<String, String> rXB = new HashMap();
  protected volatile int rXC = 20000;
  protected volatile int rXD = 15000;
  private final String rXl;
  public final String url;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.rVT = paramString1;
    this.filePath = paramString2;
    this.rXl = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.rWd = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String acb()
  {
    return this.groupId;
  }
  
  public String bjl()
  {
    return this.filePath;
  }
  
  public final int clH()
  {
    return this.rXD;
  }
  
  public final String cls()
  {
    return this.rVT;
  }
  
  public boolean clw()
  {
    return false;
  }
  
  public final int getConnectTimeout()
  {
    return this.hmL;
  }
  
  public final int getReadTimeout()
  {
    return this.rXC;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.rXB.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.rXB);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.hmL = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.rXC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.l
 * JD-Core Version:    0.7.0.1
 */