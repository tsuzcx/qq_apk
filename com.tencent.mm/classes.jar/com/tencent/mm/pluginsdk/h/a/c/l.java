package com.tencent.mm.pluginsdk.h.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l
  implements f.b
{
  public final String BRL;
  final int BRU;
  private final String BTd;
  protected final Map<String, String> BTs = new HashMap();
  protected volatile int BTt = 20000;
  protected volatile int BTu = 15000;
  private final String filePath;
  private final String groupId;
  protected volatile int lNZ = 15000;
  private final String method;
  final int networkType;
  final int priority;
  public final String url;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.BRL = paramString1;
    this.filePath = paramString2;
    this.BTd = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.BRU = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String asy()
  {
    return this.groupId;
  }
  
  public final int ewH()
  {
    return this.BTu;
  }
  
  public final String ewl()
  {
    return this.BRL;
  }
  
  public boolean ewt()
  {
    return false;
  }
  
  public final int getConnectTimeout()
  {
    return this.lNZ;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public final int getReadTimeout()
  {
    return this.BTt;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.BTs.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.BTs);
  }
  
  public final String getURL()
  {
    return this.url;
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.lNZ = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.BTt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.l
 * JD-Core Version:    0.7.0.1
 */