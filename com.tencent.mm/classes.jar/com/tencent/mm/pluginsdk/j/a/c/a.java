package com.tencent.mm.pluginsdk.j.a.c;

public abstract class a
{
  public final int FhH;
  public final String Fhz;
  public final String FiQ;
  private final String FiR;
  private final String FiS;
  private final String filePath;
  private volatile int ilG;
  private final long irN;
  private final String md5;
  public final int networkType;
  public final int priority;
  protected volatile int status = 0;
  private final String url;
  
  protected a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    this.url = paramString1;
    this.Fhz = paramString2;
    this.FiQ = paramString3;
    this.networkType = paramInt1;
    this.FhH = paramInt2;
    this.ilG = this.FhH;
    this.filePath = paramString4;
    this.irN = paramLong;
    this.FiR = paramString6;
    this.FiS = paramString7;
    this.md5 = paramString5;
    this.priority = paramInt3;
  }
  
  protected int aNv(String paramString)
  {
    return 0;
  }
  
  public s fez()
  {
    s locals = new s();
    locals.field_url = this.url;
    locals.field_urlKey = this.Fhz;
    locals.field_fileVersion = this.FiQ;
    locals.field_networkType = this.networkType;
    locals.field_maxRetryTimes = this.FhH;
    locals.field_retryTimes = this.ilG;
    locals.field_filePath = this.filePath;
    locals.field_status = this.status;
    locals.field_expireTime = this.irN;
    locals.field_groupId1 = this.FiR;
    locals.field_groupId2 = this.FiS;
    locals.field_md5 = this.md5;
    locals.field_priority = this.priority;
    return locals;
  }
  
  public String toString()
  {
    return "BaseResDownloadRequest | urlKey='" + this.Fhz + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.irN + ", fileVersion=" + this.FiQ + ", maxRetryTimes=" + this.FhH + ", md5='" + this.md5 + '\'' + ", groupId1='" + this.FiR + '\'' + ", groupId2='" + this.FiS + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.ilG + ", status=" + this.status + ", priority=" + this.priority;
  }
  
  public static abstract class a<T extends a>
  {
    protected int FhH;
    protected String Fhz;
    protected long irN;
    protected String md5;
    protected int networkType;
    protected int priority;
    protected final String url;
    
    public a(String paramString)
    {
      this.url = paramString;
    }
    
    public final a<T> Dc(long paramLong)
    {
      this.irN = paramLong;
      return this;
    }
    
    public final a<T> Zl(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public final a<T> Zm(int paramInt)
    {
      this.FhH = paramInt;
      return this;
    }
    
    public final a<T> Zn(int paramInt)
    {
      this.priority = paramInt;
      return this;
    }
    
    public final a<T> aNy(String paramString)
    {
      this.Fhz = paramString;
      return this;
    }
    
    public final a<T> aNz(String paramString)
    {
      this.md5 = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.a
 * JD-Core Version:    0.7.0.1
 */