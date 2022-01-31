package com.tencent.wxmm;

public class v2conference
{
  private static final String TAG = "WXMM.Conference";
  public int[] audioChannels = { 1 };
  public int[] audioFrameLen = { 20 };
  public int[] audioSampleRate = { 8000 };
  public int defaultHeight = 480;
  public int defaultWidth = 640;
  public int field_remoteImgHeight = 0;
  public int field_remoteImgLength = 0;
  public int field_remoteImgMember = -1;
  public int field_remoteImgWidth = 0;
  private IConfCallBack mUiConfCallback = null;
  public int maxMemberSize = 100;
  public int[] memberVadlist = null;
  public byte[] remoteImgBuffer = null;
  
  static
  {
    System.loadLibrary("c++_shared");
    System.loadLibrary("marsbridgexlog");
    System.loadLibrary("marsbridgenetwork");
    System.loadLibrary("confService");
  }
  
  private native int GetVideoData(byte[] paramArrayOfByte);
  
  public byte[] CallbackFromConferenceSDK(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.mUiConfCallback != null) {
      return this.mUiConfCallback.callBackFromConf(paramInt1, paramInt2, paramArrayOfByte);
    }
    return null;
  }
  
  public void CallbackWriteLogFromSDK(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    if (this.mUiConfCallback != null) {
      this.mUiConfCallback.callbackWriteLog(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3);
    }
  }
  
  public native int ExitRoom(int paramInt);
  
  public native int GetAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public int GetAudioDeviceFmt(AudDataFmt paramAudDataFmt)
  {
    int i = GetAudioFormat(this.audioSampleRate, this.audioFrameLen, this.audioChannels);
    paramAudDataFmt.nChannesl = this.audioChannels[0];
    paramAudDataFmt.nFramelen = this.audioFrameLen[0];
    paramAudDataFmt.nSamplerate = this.audioSampleRate[0];
    return i;
  }
  
  public native int GetAudioFormat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  public int GetDecodeVideoData(byte[] paramArrayOfByte)
  {
    paramArrayOfByte[3] = 0;
    paramArrayOfByte[1] = 0;
    paramArrayOfByte[2] = 0;
    paramArrayOfByte[0] = 2;
    if (1 == GetVideoData(paramArrayOfByte)) {
      return 1;
    }
    return 0;
  }
  
  public int GetMembersVadStatus(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (this.memberVadlist == null)) {
      return -1;
    }
    int i = GetVADStatus(this.memberVadlist);
    if (i > 0)
    {
      int j = paramArrayOfInt.length;
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        System.arraycopy(this.memberVadlist, 0, paramArrayOfInt, 0, i);
        return i;
      }
    }
    return i;
  }
  
  public native int GetVADStatus(int[] paramArrayOfInt);
  
  public native int GetVoiceActivity(int paramInt);
  
  public native int Init(byte[] paramArrayOfByte, int paramInt);
  
  public int InitSDK(byte[] paramArrayOfByte, int paramInt, IConfCallBack paramIConfCallBack)
  {
    this.mUiConfCallback = paramIConfCallBack;
    this.remoteImgBuffer = new byte[this.defaultWidth * this.defaultHeight * 3 / 2];
    this.memberVadlist = new int[this.maxMemberSize];
    return Init(paramArrayOfByte, paramInt);
  }
  
  public native int JoinRoom(long paramLong, int paramInt);
  
  public native int OnNetworkChange(int paramInt);
  
  public native int PutExternalplayAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int SendAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int SendVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int SetAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public void SetUICallback(IConfCallBack paramIConfCallBack)
  {
    this.mUiConfCallback = paramIConfCallBack;
  }
  
  public native int UnInit();
  
  public int UninitSDK()
  {
    this.mUiConfCallback = null;
    this.memberVadlist = null;
    UnInit();
    return 0;
  }
  
  public native int UpdateAuthKey(byte[] paramArrayOfByte, int paramInt);
  
  public native int videoTrans(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wxmm.v2conference
 * JD-Core Version:    0.7.0.1
 */