package com.tencent.youtu.ytagreflectlivecheck.requester;

public abstract interface RGBConfigRequester
{
  public abstract void request(RGBConfigRequestCallBack paramRGBConfigRequestCallBack);
  
  public static abstract interface RGBConfigRequestCallBack
  {
    public abstract void onFailed(int paramInt);
    
    public abstract void onSuccess(String paramString, int paramInt);
  }
  
  public static class RGBConfigRequestCallBackType
  {
    public static int RGB_FullResponse = 0;
    public static int RGB_OnlyRgbConfig = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester
 * JD-Core Version:    0.7.0.1
 */