package com.tencent.mm.pluginsdk.g.a.c;

public abstract class a
{
  public final String bIW;
  private final long eCv;
  private volatile int ewv;
  private final String filePath;
  public final int networkType;
  public final int priority;
  public final String rVT;
  public final int rWd;
  public final String rXl;
  private final String rXm;
  private final String rXn;
  protected volatile int status = 0;
  public final String url;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.rVT = paramString2;
    this.rXl = paramString3;
    this.networkType = paramInt1;
    this.rWd = paramInt2;
    this.ewv = this.rWd;
    this.filePath = paramString4;
    this.eCv = paramLong;
    this.rXm = paramString6;
    this.rXn = paramString7;
    this.bIW = paramString5;
    this.priority = paramInt3;
  }
  
  public int Wf(String paramString)
  {
    return 0;
  }
  
  public s clx()
  {
    s locals = new s();
    locals.field_url = this.url;
    locals.field_urlKey = this.rVT;
    locals.field_fileVersion = this.rXl;
    locals.field_networkType = this.networkType;
    locals.field_maxRetryTimes = this.rWd;
    locals.field_retryTimes = this.ewv;
    locals.field_filePath = this.filePath;
    locals.field_status = this.status;
    locals.field_expireTime = this.eCv;
    locals.field_groupId1 = this.rXm;
    locals.field_groupId2 = this.rXn;
    locals.field_md5 = this.bIW;
    locals.field_priority = this.priority;
    return locals;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.rVT + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.eCv + ", fileVersion=" + this.rXl + ", maxRetryTimes=" + this.rWd + ", md5='" + this.bIW + '\'' + ", groupId1='" + this.rXm + '\'' + ", groupId2='" + this.rXn + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.ewv + ", status=" + this.status + ", priority=" + this.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.a
 * JD-Core Version:    0.7.0.1
 */