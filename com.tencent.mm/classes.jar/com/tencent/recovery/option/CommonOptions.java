package com.tencent.recovery.option;

public class CommonOptions
{
  public String clientVersion;
  public String dCX;
  public String wKU;
  public String wKY;
  public String wKZ;
  private boolean wLa;
  public long wLb;
  public long wLc;
  
  public static final class Builder
  {
    public String clientVersion;
    public String dCX;
    public String wKU;
    public String wKY;
    public String wKZ;
    public boolean wLa;
    public long wLb;
    public long wLc;
    
    public final CommonOptions cOD()
    {
      CommonOptions localCommonOptions = new CommonOptions((byte)0);
      CommonOptions.a(localCommonOptions, this.wKY);
      CommonOptions.b(localCommonOptions, this.wKZ);
      CommonOptions.c(localCommonOptions, this.clientVersion);
      CommonOptions.d(localCommonOptions, this.wKU);
      CommonOptions.e(localCommonOptions, this.dCX);
      CommonOptions.a(localCommonOptions, this.wLa);
      CommonOptions.a(localCommonOptions, this.wLb);
      CommonOptions.b(localCommonOptions, this.wLc);
      return localCommonOptions;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.option.CommonOptions
 * JD-Core Version:    0.7.0.1
 */