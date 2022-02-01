package com.tencent.mm.pluginsdk.h.a.c;

public abstract class a
{
  public final String Dkb;
  public final int Dkk;
  public final String Dlt;
  private final String Dlu;
  private final String Dlv;
  private final String filePath;
  private volatile int hPz;
  private final long hVx;
  private final String md5;
  public final int networkType;
  public final int priority;
  protected volatile int status = 0;
  private final String url;
  
  protected a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.Dkb = paramString2;
    this.Dlt = paramString3;
    this.networkType = paramInt1;
    this.Dkk = paramInt2;
    this.hPz = this.Dkk;
    this.filePath = paramString4;
    this.hVx = paramLong;
    this.Dlu = paramString6;
    this.Dlv = paramString7;
    this.md5 = paramString5;
    this.priority = paramInt3;
  }
  
  protected int aGz(String paramString)
  {
    return 0;
  }
  
  public s eLO()
  {
    s locals = new s();
    locals.field_url = this.url;
    locals.field_urlKey = this.Dkb;
    locals.field_fileVersion = this.Dlt;
    locals.field_networkType = this.networkType;
    locals.field_maxRetryTimes = this.Dkk;
    locals.field_retryTimes = this.hPz;
    locals.field_filePath = this.filePath;
    locals.field_status = this.status;
    locals.field_expireTime = this.hVx;
    locals.field_groupId1 = this.Dlu;
    locals.field_groupId2 = this.Dlv;
    locals.field_md5 = this.md5;
    locals.field_priority = this.priority;
    return locals;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.Dkb + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.hVx + ", fileVersion=" + this.Dlt + ", maxRetryTimes=" + this.Dkk + ", md5='" + this.md5 + '\'' + ", groupId1='" + this.Dlu + '\'' + ", groupId2='" + this.Dlv + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.hPz + ", status=" + this.status + ", priority=" + this.priority;
  }
  
  public static abstract class a<T extends a>
  {
    protected String Dkb;
    protected int Dkk;
    protected long hVx;
    protected String md5;
    protected int networkType;
    protected int priority;
    protected final String url;
    
    public a(String paramString)
    {
      this.url = paramString;
    }
    
    public final a<T> WJ(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public final a<T> WK(int paramInt)
    {
      this.Dkk = paramInt;
      return this;
    }
    
    public final a<T> WL(int paramInt)
    {
      this.priority = paramInt;
      return this;
    }
    
    public final a<T> aGC(String paramString)
    {
      this.Dkb = paramString;
      return this;
    }
    
    public final a<T> aGD(String paramString)
    {
      this.md5 = paramString;
      return this;
    }
    
    public final a<T> zQ(long paramLong)
    {
      this.hVx = paramLong;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.a
 * JD-Core Version:    0.7.0.1
 */