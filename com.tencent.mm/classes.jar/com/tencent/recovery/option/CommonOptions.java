package com.tencent.recovery.option;

public class CommonOptions
{
  public long BiA;
  public long BiB;
  public String Biu;
  public String Bix;
  public String Biy;
  private boolean Biz;
  public String clientVersion;
  public String eAx;
  
  public static final class Builder
  {
    public long BiA;
    public long BiB;
    public String Biu;
    public String Bix;
    public String Biy;
    public boolean Biz;
    public String clientVersion;
    public String eAx;
    
    public final CommonOptions dUs()
    {
      CommonOptions localCommonOptions = new CommonOptions((byte)0);
      CommonOptions.a(localCommonOptions, this.Bix);
      CommonOptions.b(localCommonOptions, this.Biy);
      CommonOptions.c(localCommonOptions, this.clientVersion);
      CommonOptions.d(localCommonOptions, this.Biu);
      CommonOptions.e(localCommonOptions, this.eAx);
      CommonOptions.a(localCommonOptions, this.Biz);
      CommonOptions.a(localCommonOptions, this.BiA);
      CommonOptions.b(localCommonOptions, this.BiB);
      return localCommonOptions;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.option.CommonOptions
 * JD-Core Version:    0.7.0.1
 */