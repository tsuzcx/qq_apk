package com.tencent.recovery.option;

public class CommonOptions
{
  private String clientVersion;
  private String configUrl;
  private boolean debugMode;
  private long handleRetryInterval;
  private String recoveryHandleService;
  private String recoveryUploadService;
  private long uploadInterval;
  private String uuid;
  
  public String getClientVersion()
  {
    return this.clientVersion;
  }
  
  public String getConfigUrl()
  {
    return this.configUrl;
  }
  
  public long getHandleRetryInterval()
  {
    return this.handleRetryInterval;
  }
  
  public String getRecoveryHandleService()
  {
    return this.recoveryHandleService;
  }
  
  public String getRecoveryUploadService()
  {
    return this.recoveryUploadService;
  }
  
  public String getUUID()
  {
    return this.uuid;
  }
  
  public long getUploadInterval()
  {
    return this.uploadInterval;
  }
  
  public boolean isDebugMode()
  {
    return this.debugMode;
  }
  
  public static final class Builder
  {
    private String clientVersion;
    private String configUrl;
    private boolean debugMode;
    private long handleRetryInterval;
    private String recoveryHandleService;
    private String recoveryUploadService;
    private long uploadInterval;
    private String uuid;
    
    public final CommonOptions build()
    {
      CommonOptions localCommonOptions = new CommonOptions(null);
      CommonOptions.access$102(localCommonOptions, this.recoveryHandleService);
      CommonOptions.access$202(localCommonOptions, this.recoveryUploadService);
      CommonOptions.access$302(localCommonOptions, this.clientVersion);
      CommonOptions.access$402(localCommonOptions, this.configUrl);
      CommonOptions.access$502(localCommonOptions, this.uuid);
      CommonOptions.access$602(localCommonOptions, this.debugMode);
      CommonOptions.access$702(localCommonOptions, this.uploadInterval);
      CommonOptions.access$802(localCommonOptions, this.handleRetryInterval);
      return localCommonOptions;
    }
    
    public final void setClientVersion(String paramString)
    {
      this.clientVersion = paramString;
    }
    
    public final void setConfigUrl(String paramString)
    {
      this.configUrl = paramString;
    }
    
    public final void setDebugMode(boolean paramBoolean)
    {
      this.debugMode = paramBoolean;
    }
    
    public final void setHandleRetryInterval(long paramLong)
    {
      this.handleRetryInterval = paramLong;
    }
    
    public final void setRecoveryHandleService(String paramString)
    {
      this.recoveryHandleService = paramString;
    }
    
    public final void setRecoveryUploadService(String paramString)
    {
      this.recoveryUploadService = paramString;
    }
    
    public final void setUUID(String paramString)
    {
      this.uuid = paramString;
    }
    
    public final void setUploadInterval(long paramLong)
    {
      this.uploadInterval = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.option.CommonOptions
 * JD-Core Version:    0.7.0.1
 */