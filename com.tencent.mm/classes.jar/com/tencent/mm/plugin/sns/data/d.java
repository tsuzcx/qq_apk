package com.tencent.mm.plugin.sns.data;

public final class d
{
  public String hHB;
  public boolean isAd = false;
  public int oTP;
  public int scene;
  public String userName;
  
  public d(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    this.isAd = paramBoolean;
    this.userName = paramString1;
    this.hHB = paramString2;
    this.scene = paramInt;
    this.oTP = -1;
  }
  
  public d(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.isAd = paramBoolean;
    this.userName = paramString1;
    this.hHB = paramString2;
    this.scene = paramInt1;
    this.oTP = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.d
 * JD-Core Version:    0.7.0.1
 */