package com.tencent.mm.pluginsdk.h.a.c;

public abstract class a
{
  public final String BRL;
  public final int BRU;
  public final String BTd;
  private final String BTe;
  private final String BTf;
  private final String filePath;
  private volatile int hoX;
  private final long huV;
  private final String md5;
  public final int networkType;
  public final int priority;
  protected volatile int status = 0;
  private final String url;
  
  protected a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.BRL = paramString2;
    this.BTd = paramString3;
    this.networkType = paramInt1;
    this.BRU = paramInt2;
    this.hoX = this.BRU;
    this.filePath = paramString4;
    this.huV = paramLong;
    this.BTe = paramString6;
    this.BTf = paramString7;
    this.md5 = paramString5;
    this.priority = paramInt3;
  }
  
  protected int aBh(String paramString)
  {
    return 0;
  }
  
  public s ewu()
  {
    s locals = new s();
    locals.field_url = this.url;
    locals.field_urlKey = this.BRL;
    locals.field_fileVersion = this.BTd;
    locals.field_networkType = this.networkType;
    locals.field_maxRetryTimes = this.BRU;
    locals.field_retryTimes = this.hoX;
    locals.field_filePath = this.filePath;
    locals.field_status = this.status;
    locals.field_expireTime = this.huV;
    locals.field_groupId1 = this.BTe;
    locals.field_groupId2 = this.BTf;
    locals.field_md5 = this.md5;
    locals.field_priority = this.priority;
    return locals;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.BRL + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.huV + ", fileVersion=" + this.BTd + ", maxRetryTimes=" + this.BRU + ", md5='" + this.md5 + '\'' + ", groupId1='" + this.BTe + '\'' + ", groupId2='" + this.BTf + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.hoX + ", status=" + this.status + ", priority=" + this.priority;
  }
  
  public static abstract class a<T extends a>
  {
    protected String BRL;
    protected int BRU;
    protected long huV;
    protected String md5;
    protected int networkType;
    protected int priority;
    protected final String url;
    
    public a(String paramString)
    {
      this.url = paramString;
    }
    
    public final a<T> UA(int paramInt)
    {
      this.BRU = paramInt;
      return this;
    }
    
    public final a<T> UB(int paramInt)
    {
      this.priority = paramInt;
      return this;
    }
    
    public final a<T> Uz(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public final a<T> aBk(String paramString)
    {
      this.BRL = paramString;
      return this;
    }
    
    public final a<T> aBl(String paramString)
    {
      this.md5 = paramString;
      return this;
    }
    
    public final a<T> vn(long paramLong)
    {
      this.huV = paramLong;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.a
 * JD-Core Version:    0.7.0.1
 */