package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class v2conference
{
  private static final String TAG = "WXMM.Conference";
  public int[] audioChannels;
  public int[] audioFrameLen;
  public int[] audioSampleRate;
  public int defaultHeight;
  public int defaultWidth;
  public int field_HWEncH;
  public int field_HWEncW;
  public int field_remoteImgHeight;
  public int field_remoteImgLength;
  public int field_remoteImgMember;
  public int field_remoteImgWidth;
  private IConfCallBack mUiConfCallback;
  public int maxMemberSize;
  public int[] memberVadlist;
  public byte[] remoteImgBuffer;
  
  static
  {
    AppMethodBeat.i(35396);
    System.loadLibrary("c++_shared");
    System.loadLibrary("marsbridgexlog");
    System.loadLibrary("marsbridgenetwork");
    System.loadLibrary("confService");
    AppMethodBeat.o(35396);
  }
  
  public v2conference()
  {
    AppMethodBeat.i(35388);
    this.mUiConfCallback = null;
    this.defaultWidth = 640;
    this.defaultHeight = 480;
    this.maxMemberSize = 100;
    this.remoteImgBuffer = null;
    this.field_remoteImgLength = 0;
    this.field_remoteImgHeight = 0;
    this.field_remoteImgWidth = 0;
    this.field_remoteImgMember = -1;
    this.field_HWEncW = 0;
    this.field_HWEncH = 0;
    this.memberVadlist = null;
    this.audioSampleRate = new int[] { 8000 };
    this.audioFrameLen = new int[] { 20 };
    this.audioChannels = new int[] { 1 };
    AppMethodBeat.o(35388);
  }
  
  private native int GetVideoData(byte[] paramArrayOfByte);
  
  public byte[] CallbackFromConferenceSDK(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(35389);
    if (this.mUiConfCallback != null)
    {
      paramArrayOfByte = this.mUiConfCallback.callBackFromConf(paramInt1, paramInt2, paramArrayOfByte);
      AppMethodBeat.o(35389);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(35389);
    return null;
  }
  
  public void CallbackWriteLogFromSDK(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(35390);
    if (this.mUiConfCallback != null) {
      this.mUiConfCallback.callbackWriteLog(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3);
    }
    AppMethodBeat.o(35390);
  }
  
  public native int ExitRoom(int paramInt);
  
  public native int GetAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public int GetAudioDeviceFmt(AudDataFmt paramAudDataFmt)
  {
    AppMethodBeat.i(35392);
    int i = GetAudioFormat(this.audioSampleRate, this.audioFrameLen, this.audioChannels);
    paramAudDataFmt.nChannesl = this.audioChannels[0];
    paramAudDataFmt.nFramelen = this.audioFrameLen[0];
    paramAudDataFmt.nSamplerate = this.audioSampleRate[0];
    AppMethodBeat.o(35392);
    return i;
  }
  
  public native int GetAudioFormat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  public int GetDecodeVideoData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(35391);
    if (1 == GetVideoData(paramArrayOfByte))
    {
      AppMethodBeat.o(35391);
      return 1;
    }
    AppMethodBeat.o(35391);
    return 0;
  }
  
  public int GetMembersVadStatus(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(35395);
    if ((paramArrayOfInt == null) || (this.memberVadlist == null))
    {
      AppMethodBeat.o(35395);
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
        AppMethodBeat.o(35395);
        return i;
      }
    }
    AppMethodBeat.o(35395);
    return i;
  }
  
  public native int GetVADStatus(int[] paramArrayOfInt);
  
  public native int GetVoiceActivity(int paramInt);
  
  public native int Init(byte[] paramArrayOfByte, int paramInt);
  
  public int InitSDK(byte[] paramArrayOfByte, int paramInt, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(35393);
    this.mUiConfCallback = paramIConfCallBack;
    this.remoteImgBuffer = new byte[this.defaultWidth * this.defaultHeight * 3 / 2];
    this.memberVadlist = new int[this.maxMemberSize];
    paramInt = Init(paramArrayOfByte, paramInt);
    AppMethodBeat.o(35393);
    return paramInt;
  }
  
  public native int JoinRoom(long paramLong, int paramInt1, int paramInt2);
  
  public native int OnNetworkChange(int paramInt);
  
  public native int PutExternalplayAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int SendAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int SendVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int SetAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public void SetUICallback(IConfCallBack paramIConfCallBack)
  {
    this.mUiConfCallback = paramIConfCallBack;
  }
  
  public native int UnInit();
  
  public int UninitSDK()
  {
    AppMethodBeat.i(35394);
    this.mUiConfCallback = null;
    this.memberVadlist = null;
    UnInit();
    AppMethodBeat.o(35394);
    return 0;
  }
  
  public native int UpdateAuthKey(byte[] paramArrayOfByte, int paramInt);
  
  public native int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2);
  
  public native int videoTrans(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wxmm.v2conference
 * JD-Core Version:    0.7.0.1
 */