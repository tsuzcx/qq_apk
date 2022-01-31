package com.tencent.mm.pluginsdk.g.a.c;

public abstract class a
{
  private final String cqq;
  private volatile int fMl;
  private final long fSm;
  private final String filePath;
  public final int networkType;
  public final int priority;
  protected volatile int status = 0;
  private final String url;
  public final String vMK;
  public final int vMT;
  public final String vOd;
  private final String vOe;
  private final String vOf;
  
  protected a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.vMK = paramString2;
    this.vOd = paramString3;
    this.networkType = paramInt1;
    this.vMT = paramInt2;
    this.fMl = this.vMT;
    this.filePath = paramString4;
    this.fSm = paramLong;
    this.vOe = paramString6;
    this.vOf = paramString7;
    this.cqq = paramString5;
    this.priority = paramInt3;
  }
  
  protected int alG(String paramString)
  {
    return 0;
  }
  
  public s dmi()
  {
    s locals = new s();
    locals.field_url = this.url;
    locals.field_urlKey = this.vMK;
    locals.field_fileVersion = this.vOd;
    locals.field_networkType = this.networkType;
    locals.field_maxRetryTimes = this.vMT;
    locals.field_retryTimes = this.fMl;
    locals.field_filePath = this.filePath;
    locals.field_status = this.status;
    locals.field_expireTime = this.fSm;
    locals.field_groupId1 = this.vOe;
    locals.field_groupId2 = this.vOf;
    locals.field_md5 = this.cqq;
    locals.field_priority = this.priority;
    return locals;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.vMK + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.fSm + ", fileVersion=" + this.vOd + ", maxRetryTimes=" + this.vMT + ", md5='" + this.cqq + '\'' + ", groupId1='" + this.vOe + '\'' + ", groupId2='" + this.vOf + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.fMl + ", status=" + this.status + ", priority=" + this.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.a
 * JD-Core Version:    0.7.0.1
 */