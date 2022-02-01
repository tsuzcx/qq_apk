package com.tencent.mm.pluginsdk.j.a.c;

public abstract class a
{
  public final int JYA;
  public final String JYs;
  public final String JZK;
  private final String JZL;
  private final String JZM;
  private final String filePath;
  private volatile int jgF;
  private final long jmW;
  private final String md5;
  public final int networkType;
  public final int priority;
  protected volatile int status = 0;
  private final String url;
  
  protected a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.JYs = paramString2;
    this.JZK = paramString3;
    this.networkType = paramInt1;
    this.JYA = paramInt2;
    this.jgF = this.JYA;
    this.filePath = paramString4;
    this.jmW = paramLong;
    this.JZL = paramString6;
    this.JZM = paramString7;
    this.md5 = paramString5;
    this.priority = paramInt3;
  }
  
  protected int bdX(String paramString)
  {
    return 0;
  }
  
  public s gnJ()
  {
    s locals = new s();
    locals.field_url = this.url;
    locals.field_urlKey = this.JYs;
    locals.field_fileVersion = this.JZK;
    locals.field_networkType = this.networkType;
    locals.field_maxRetryTimes = this.JYA;
    locals.field_retryTimes = this.jgF;
    locals.field_filePath = this.filePath;
    locals.field_status = this.status;
    locals.field_expireTime = this.jmW;
    locals.field_groupId1 = this.JZL;
    locals.field_groupId2 = this.JZM;
    locals.field_md5 = this.md5;
    locals.field_priority = this.priority;
    return locals;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.JYs + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.jmW + ", fileVersion=" + this.JZK + ", maxRetryTimes=" + this.JYA + ", md5='" + this.md5 + '\'' + ", groupId1='" + this.JZL + '\'' + ", groupId2='" + this.JZM + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.jgF + ", status=" + this.status + ", priority=" + this.priority;
  }
  
  public static abstract class a<T extends a>
  {
    protected int JYA;
    protected String JYs;
    protected long jmW;
    protected String md5;
    protected int networkType;
    protected int priority;
    protected final String url;
    
    public a(String paramString)
    {
      this.url = paramString;
    }
    
    public final a<T> Ms(long paramLong)
    {
      this.jmW = paramLong;
      return this;
    }
    
    public final a<T> ahX(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public final a<T> ahY(int paramInt)
    {
      this.JYA = paramInt;
      return this;
    }
    
    public final a<T> ahZ(int paramInt)
    {
      this.priority = paramInt;
      return this;
    }
    
    public final a<T> bea(String paramString)
    {
      this.JYs = paramString;
      return this;
    }
    
    public final a<T> beb(String paramString)
    {
      this.md5 = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.a
 * JD-Core Version:    0.7.0.1
 */