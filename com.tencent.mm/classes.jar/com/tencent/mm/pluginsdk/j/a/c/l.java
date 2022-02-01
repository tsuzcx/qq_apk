package com.tencent.mm.pluginsdk.j.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l
  implements f.b
{
  final int FhH;
  public final String Fhz;
  private final String FiQ;
  protected final Map<String, String> Fjf = new HashMap();
  protected volatile int Fjg = 20000;
  protected volatile int Fjh = 15000;
  private final String filePath;
  private final String groupId;
  protected volatile int mVO = 15000;
  private final String method;
  final int networkType;
  final int priority;
  public final String url;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.Fhz = paramString1;
    this.filePath = paramString2;
    this.FiQ = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.FhH = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
  }
  
  public String afK()
  {
    return this.groupId;
  }
  
  public final int feM()
  {
    return this.Fjh;
  }
  
  public final String feq()
  {
    return this.Fhz;
  }
  
  public boolean fey()
  {
    return false;
  }
  
  public final int getConnectTimeout()
  {
    return this.mVO;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public final int getReadTimeout()
  {
    return this.Fjg;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    if (this.Fjf.size() == 0) {
      return null;
    }
    return Collections.unmodifiableMap(this.Fjf);
  }
  
  public final String getURL()
  {
    return this.url;
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.mVO = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.Fjg = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.l
 * JD-Core Version:    0.7.0.1
 */