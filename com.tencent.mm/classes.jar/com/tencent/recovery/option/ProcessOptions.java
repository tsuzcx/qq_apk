package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions
{
  private Express express;
  private int timeout;
  
  public Express getExpress()
  {
    return this.express;
  }
  
  public int getTimeout()
  {
    return this.timeout;
  }
  
  public static final class Builder
  {
    private Express express;
    private int timeout;
    
    public final ProcessOptions build()
    {
      ProcessOptions localProcessOptions = new ProcessOptions();
      ProcessOptions.access$002(localProcessOptions, this.timeout);
      ProcessOptions.access$102(localProcessOptions, this.express);
      return localProcessOptions;
    }
    
    public final Builder setExpress(Express paramExpress)
    {
      this.express = paramExpress;
      return this;
    }
    
    public final Builder setTimeout(int paramInt)
    {
      this.timeout = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.option.ProcessOptions
 * JD-Core Version:    0.7.0.1
 */