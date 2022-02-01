package com.tencent.mm.pluginsdk.j.a.c;

public abstract class a
{
  public final String EPe;
  public final int EPm;
  public final String EQv;
  private final String EQw;
  private final String EQx;
  private final String filePath;
  private volatile int iiN;
  private final long ioS;
  private final String md5;
  public final int networkType;
  public final int priority;
  protected volatile int status = 0;
  private final String url;
  
  protected a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.EPe = paramString2;
    this.EQv = paramString3;
    this.networkType = paramInt1;
    this.EPm = paramInt2;
    this.iiN = this.EPm;
    this.filePath = paramString4;
    this.ioS = paramLong;
    this.EQw = paramString6;
    this.EQx = paramString7;
    this.md5 = paramString5;
    this.priority = paramInt3;
  }
  
  protected int aLZ(String paramString)
  {
    return 0;
  }
  
  public s faL()
  {
    s locals = new s();
    locals.field_url = this.url;
    locals.field_urlKey = this.EPe;
    locals.field_fileVersion = this.EQv;
    locals.field_networkType = this.networkType;
    locals.field_maxRetryTimes = this.EPm;
    locals.field_retryTimes = this.iiN;
    locals.field_filePath = this.filePath;
    locals.field_status = this.status;
    locals.field_expireTime = this.ioS;
    locals.field_groupId1 = this.EQw;
    locals.field_groupId2 = this.EQx;
    locals.field_md5 = this.md5;
    locals.field_priority = this.priority;
    return locals;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.EPe + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.ioS + ", fileVersion=" + this.EQv + ", maxRetryTimes=" + this.EPm + ", md5='" + this.md5 + '\'' + ", groupId1='" + this.EQw + '\'' + ", groupId2='" + this.EQx + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.iiN + ", status=" + this.status + ", priority=" + this.priority;
  }
  
  public static abstract class a<T extends a>
  {
    protected String EPe;
    protected int EPm;
    protected long ioS;
    protected String md5;
    protected int networkType;
    protected int priority;
    protected final String url;
    
    public a(String paramString)
    {
      this.url = paramString;
    }
    
    public final a<T> CE(long paramLong)
    {
      this.ioS = paramLong;
      return this;
    }
    
    public final a<T> YF(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public final a<T> YG(int paramInt)
    {
      this.EPm = paramInt;
      return this;
    }
    
    public final a<T> YH(int paramInt)
    {
      this.priority = paramInt;
      return this;
    }
    
    public final a<T> aMc(String paramString)
    {
      this.EPe = paramString;
      return this;
    }
    
    public final a<T> aMd(String paramString)
    {
      this.md5 = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.a
 * JD-Core Version:    0.7.0.1
 */