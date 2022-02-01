package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TRTCCloudDef$TRTCMixUser
{
  public int height;
  public boolean pureAudio;
  public String roomId;
  public int streamType;
  public String userId;
  public int width;
  public int x;
  public int y;
  public int zOrder;
  
  public TRTCCloudDef$TRTCMixUser()
  {
    this.userId = "";
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
    this.zOrder = 0;
    this.streamType = 0;
  }
  
  public TRTCCloudDef$TRTCMixUser(TRTCMixUser paramTRTCMixUser)
  {
    this.userId = paramTRTCMixUser.userId;
    this.roomId = paramTRTCMixUser.roomId;
    this.x = paramTRTCMixUser.x;
    this.y = paramTRTCMixUser.y;
    this.width = paramTRTCMixUser.width;
    this.height = paramTRTCMixUser.height;
    this.zOrder = paramTRTCMixUser.zOrder;
    this.streamType = paramTRTCMixUser.streamType;
    this.pureAudio = paramTRTCMixUser.pureAudio;
  }
  
  public TRTCCloudDef$TRTCMixUser(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.userId = paramString;
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.zOrder = paramInt5;
    this.streamType = 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(222699);
    String str = "userId=" + this.userId + ", roomId=" + this.roomId + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", zOrder=" + this.zOrder + ", streamType=" + this.streamType + ", pureAudio=" + this.pureAudio;
    AppMethodBeat.o(222699);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCMixUser
 * JD-Core Version:    0.7.0.1
 */