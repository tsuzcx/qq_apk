package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions
{
  public int dEk;
  private Express wLe;
  
  public static final class Builder
  {
    private int dEk;
    public Express wLe;
    
    public final Builder cOE()
    {
      this.dEk = 10000;
      return this;
    }
    
    public final ProcessOptions cOF()
    {
      ProcessOptions localProcessOptions = new ProcessOptions();
      ProcessOptions.a(localProcessOptions, this.dEk);
      ProcessOptions.a(localProcessOptions, this.wLe);
      return localProcessOptions;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.option.ProcessOptions
 * JD-Core Version:    0.7.0.1
 */