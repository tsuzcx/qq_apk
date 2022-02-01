package com.tencent.trtc;

public class TRTCCloudDef$TRTCParams
{
  public String businessInfo = "";
  public String privateMapKey = "";
  public int role = 20;
  public int roomId = 0;
  public int sdkAppId = 0;
  public String streamId;
  public String userDefineRecordId;
  public String userId = "";
  public String userSig = "";
  
  public TRTCCloudDef$TRTCParams() {}
  
  public TRTCCloudDef$TRTCParams(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.sdkAppId = paramInt1;
    this.userId = paramString1;
    this.userSig = paramString2;
    this.roomId = paramInt2;
    this.privateMapKey = paramString3;
    this.businessInfo = paramString4;
  }
  
  public TRTCCloudDef$TRTCParams(TRTCParams paramTRTCParams)
  {
    this.sdkAppId = paramTRTCParams.sdkAppId;
    this.userSig = paramTRTCParams.userSig;
    this.userId = paramTRTCParams.userId;
    this.roomId = paramTRTCParams.roomId;
    this.role = paramTRTCParams.role;
    this.streamId = paramTRTCParams.streamId;
    this.userDefineRecordId = paramTRTCParams.userDefineRecordId;
    this.privateMapKey = paramTRTCParams.privateMapKey;
    this.businessInfo = paramTRTCParams.businessInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCParams
 * JD-Core Version:    0.7.0.1
 */