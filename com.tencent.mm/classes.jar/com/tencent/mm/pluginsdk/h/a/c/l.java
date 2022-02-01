package com.tencent.mm.pluginsdk.h.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l
  implements f.b
{
  public final String Dkb;
  final int Dkk;
  protected final Map<String, String> DlI = new HashMap();
  protected volatile int DlJ = 20000;
  protected volatile int DlK = 15000;
  private final String Dlt;
  private final String filePath;
  private final String groupId;
  private final String method;
  protected volatile int mpZ = 15000;
  final int networkType;
  final int priority;
  public final String url;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.Dkb = paramString1;
    this.filePath = paramString2;
    this.Dlt = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.Dkk = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String azp()
  {
    return this.groupId;
  }
  
  public final String eLF()
  {
    return this.Dkb;
  }
  
  public boolean eLN()
  {
    return false;
  }
  
  public final int eMb()
  {
    return this.DlK;
  }
  
  public final int getConnectTimeout()
  {
    return this.mpZ;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public final int getReadTimeout()
  {
    return this.DlJ;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.DlI.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.DlI);
  }
  
  public final String getURL()
  {
    return this.url;
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.mpZ = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.DlJ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.l
 * JD-Core Version:    0.7.0.1
 */