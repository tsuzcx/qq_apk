package com.tencent.youtu.ytagreflectlivecheck.requester;

import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;

public abstract interface UploadVideoRequesterV2
{
  public abstract void request(ReflectLiveReq paramReflectLiveReq, UploadVideoResponse paramUploadVideoResponse);
  
  public static abstract interface UploadVideoResponse
  {
    public abstract void onFailed(int paramInt, String paramString);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2
 * JD-Core Version:    0.7.0.1
 */