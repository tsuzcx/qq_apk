package com.tencent.trtc;

public class TRTCCloudDef$TRTCParams
{
  public String businessInfo = "";
  public String privateMapKey = "";
  public int role = 20;
  public int roomId = 0;
  public int sdkAppId = 0;
  public String strRoomId = "";
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
    this.strRoomId = "";
    this.privateMapKey = paramString3;
    this.businessInfo = paramString4;
  }
  
  public TRTCCloudDef$TRTCParams(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.sdkAppId = paramInt;
    this.userId = paramString1;
    this.userSig = paramString2;
    this.strRoomId = paramString3;
    this.privateMapKey = paramString4;
    this.businessInfo = paramString5;
  }
  
  public TRTCCloudDef$TRTCParams(TRTCParams paramTRTCParams)
  {
    this.sdkAppId = paramTRTCParams.sdkAppId;
    this.userId = paramTRTCParams.userId;
    this.userSig = paramTRTCParams.userSig;
    this.roomId = paramTRTCParams.roomId;
    this.strRoomId = paramTRTCParams.strRoomId;
    this.role = paramTRTCParams.role;
    this.streamId = paramTRTCParams.streamId;
    this.userDefineRecordId = paramTRTCParams.userDefineRecordId;
    this.privateMapKey = paramTRTCParams.privateMapKey;
    this.businessInfo = paramTRTCParams.businessInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCParams
 * JD-Core Version:    0.7.0.1
 */