package com.tencent.youtu.ytagreflectlivecheck.requester;

public abstract interface RGBConfigRequester
{
  public abstract void request(RGBConfigRequestCallBack paramRGBConfigRequestCallBack);
  
  public static abstract interface RGBConfigRequestCallBack
  {
    public abstract void onFailed(int paramInt);
    
    public abstract void onSuccess(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester
 * JD-Core Version:    0.7.0.1
 */