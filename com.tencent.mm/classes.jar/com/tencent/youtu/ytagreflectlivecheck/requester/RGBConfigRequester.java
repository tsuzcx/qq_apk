package com.tencent.youtu.ytagreflectlivecheck.requester;

public abstract interface RGBConfigRequester
{
  public abstract RGBConfigRequester.YTColorSeqReq getColorSeqReq();
  
  public abstract void request(String paramString, RGBConfigRequester.RGBConfigRequestCallBack paramRGBConfigRequestCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester
 * JD-Core Version:    0.7.0.1
 */