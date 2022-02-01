package com.tencent.mm.pluginsdk.res.downloader.model;

public abstract class a
{
  public final String XUX;
  public final int XVf;
  public final String XWr;
  private final String XWs;
  private final String XWt;
  private final String filePath;
  private final String md5;
  public final int networkType;
  private volatile int oQk;
  private final long ofU;
  public final int priority;
  protected volatile int status = 0;
  private final String url;
  
  protected a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.XUX = paramString2;
    this.XWr = paramString3;
    this.networkType = paramInt1;
    this.XVf = paramInt2;
    this.oQk = this.XVf;
    this.filePath = paramString4;
    this.ofU = paramLong;
    this.XWs = paramString6;
    this.XWt = paramString7;
    this.md5 = paramString5;
    this.priority = paramInt3;
  }
  
  protected int bqh(String paramString)
  {
    return 0;
  }
  
  public r iJo()
  {
    r localr = new r();
    localr.field_url = this.url;
    localr.field_urlKey = this.XUX;
    localr.field_fileVersion = this.XWr;
    localr.field_networkType = this.networkType;
    localr.field_maxRetryTimes = this.XVf;
    localr.field_retryTimes = this.oQk;
    localr.field_filePath = this.filePath;
    localr.field_status = this.status;
    localr.field_expireTime = this.ofU;
    localr.field_groupId1 = this.XWs;
    localr.field_groupId2 = this.XWt;
    localr.field_md5 = this.md5;
    localr.field_priority = this.priority;
    return localr;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.XUX + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.ofU + ", fileVersion=" + this.XWr + ", maxRetryTimes=" + this.XVf + ", md5='" + this.md5 + '\'' + ", groupId1='" + this.XWs + '\'' + ", groupId2='" + this.XWt + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.oQk + ", status=" + this.status + ", priority=" + this.priority;
  }
  
  public static abstract class a<T extends a>
  {
    protected String XUX;
    protected int XVf;
    protected String md5;
    protected int networkType;
    protected long ofU;
    protected int priority;
    protected final String url;
    
    public a(String paramString)
    {
      this.url = paramString;
    }
    
    public final a<T> awb(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public final a<T> awc(int paramInt)
    {
      this.XVf = paramInt;
      return this;
    }
    
    public final a<T> awd(int paramInt)
    {
      this.priority = paramInt;
      return this;
    }
    
    public final a<T> bqk(String paramString)
    {
      this.XUX = paramString;
      return this;
    }
    
    public final a<T> bql(String paramString)
    {
      this.md5 = paramString;
      return this;
    }
    
    public final a<T> yl(long paramLong)
    {
      this.ofU = paramLong;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.a
 * JD-Core Version:    0.7.0.1
 */