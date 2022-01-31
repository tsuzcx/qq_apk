package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions
{
  private Express BiD;
  public int eBM;
  
  public static final class Builder
  {
    public Express BiD;
    private int eBM;
    
    public final Builder dUt()
    {
      this.eBM = 10000;
      return this;
    }
    
    public final ProcessOptions dUu()
    {
      ProcessOptions localProcessOptions = new ProcessOptions();
      ProcessOptions.a(localProcessOptions, this.eBM);
      ProcessOptions.a(localProcessOptions, this.BiD);
      return localProcessOptions;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.option.ProcessOptions
 * JD-Core Version:    0.7.0.1
 */