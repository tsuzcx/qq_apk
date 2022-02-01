package com.tencent.mm.pluginsdk.k.a.c;

public abstract class a
{
  public final String QYU;
  public final int QZc;
  public final String Ran;
  private final String Rao;
  private final String Rap;
  private final String filePath;
  private volatile int lXi;
  private final long mcX;
  private final String md5;
  public final int networkType;
  public final int priority;
  protected volatile int status = 0;
  private final String url;
  
  protected a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.QYU = paramString2;
    this.Ran = paramString3;
    this.networkType = paramInt1;
    this.QZc = paramInt2;
    this.lXi = this.QZc;
    this.filePath = paramString4;
    this.mcX = paramLong;
    this.Rao = paramString6;
    this.Rap = paramString7;
    this.md5 = paramString5;
    this.priority = paramInt3;
  }
  
  protected int bqt(String paramString)
  {
    return 0;
  }
  
  public r hip()
  {
    r localr = new r();
    localr.field_url = this.url;
    localr.field_urlKey = this.QYU;
    localr.field_fileVersion = this.Ran;
    localr.field_networkType = this.networkType;
    localr.field_maxRetryTimes = this.QZc;
    localr.field_retryTimes = this.lXi;
    localr.field_filePath = this.filePath;
    localr.field_status = this.status;
    localr.field_expireTime = this.mcX;
    localr.field_groupId1 = this.Rao;
    localr.field_groupId2 = this.Rap;
    localr.field_md5 = this.md5;
    localr.field_priority = this.priority;
    return localr;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.QYU + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.mcX + ", fileVersion=" + this.Ran + ", maxRetryTimes=" + this.QZc + ", md5='" + this.md5 + '\'' + ", groupId1='" + this.Rao + '\'' + ", groupId2='" + this.Rap + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.lXi + ", status=" + this.status + ", priority=" + this.priority;
  }
  
  public static abstract class a<T extends a>
  {
    protected String QYU;
    protected int QZc;
    protected long mcX;
    protected String md5;
    protected int networkType;
    protected int priority;
    protected final String url;
    
    public a(String paramString)
    {
      this.url = paramString;
    }
    
    public final a<T> TV(long paramLong)
    {
      this.mcX = paramLong;
      return this;
    }
    
    public final a<T> apX(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public final a<T> apY(int paramInt)
    {
      this.QZc = paramInt;
      return this;
    }
    
    public final a<T> apZ(int paramInt)
    {
      this.priority = paramInt;
      return this;
    }
    
    public final a<T> bqw(String paramString)
    {
      this.QYU = paramString;
      return this;
    }
    
    public final a<T> bqx(String paramString)
    {
      this.md5 = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.a
 * JD-Core Version:    0.7.0.1
 */