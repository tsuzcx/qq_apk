package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class v2conference
{
  private static final String TAG = "WXMM.Conference";
  private byte _hellAccFlag_;
  public int[] audioChannels;
  public int[] audioFrameLen;
  public int[] audioSampleRate;
  public int defaultHeight;
  public int defaultWidth;
  public int field_HWEncH;
  public int field_HWEncW;
  public int field_localImgHeight;
  public int field_localImgWidth;
  public int field_remoteImgFormat;
  public int field_remoteImgHeight;
  public int field_remoteImgLength;
  public int field_remoteImgMember;
  public int field_remoteImgWidth;
  public int field_remoteScreenImgFormat;
  public int field_remoteScreenImgHeight;
  public int field_remoteScreenImgLength;
  public int field_remoteScreenImgMember;
  public int field_remoteScreenImgWidth;
  private IConfCallBack mUiConfCallback;
  public int maxMemberSize;
  public int[] memberVadlist;
  public byte[] remoteImgBuffer;
  
  static
  {
    AppMethodBeat.i(40774);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("c++_shared");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxmm/v2conference", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxmm/v2conference", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("ilink_xlog");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxmm/v2conference", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxmm/v2conference", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("ilink_network");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxmm/v2conference", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxmm/v2conference", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("confService");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/wxmm/v2conference", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/wxmm/v2conference", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(40774);
  }
  
  public v2conference()
  {
    AppMethodBeat.i(40766);
    this.mUiConfCallback = null;
    this.defaultWidth = 640;
    this.defaultHeight = 480;
    this.maxMemberSize = 100;
    this.remoteImgBuffer = null;
    this.field_remoteImgLength = 0;
    this.field_remoteImgHeight = 0;
    this.field_remoteImgWidth = 0;
    this.field_remoteImgMember = -1;
    this.field_remoteImgFormat = 0;
    this.field_remoteScreenImgLength = 0;
    this.field_remoteScreenImgHeight = 0;
    this.field_remoteScreenImgWidth = 0;
    this.field_remoteScreenImgMember = -1;
    this.field_remoteScreenImgFormat = 0;
    this.field_HWEncW = 0;
    this.field_HWEncH = 0;
    this.field_localImgWidth = 0;
    this.field_localImgHeight = 0;
    this.memberVadlist = null;
    this.audioSampleRate = new int[] { 8000 };
    this.audioFrameLen = new int[] { 20 };
    this.audioChannels = new int[] { 1 };
    AppMethodBeat.o(40766);
  }
  
  private native int GetVideoData(byte[] paramArrayOfByte, int paramInt);
  
  public native int Accept(int paramInt);
  
  public native int Ack();
  
  public native int Add(byte[] paramArrayOfByte, int paramInt);
  
  public byte[] CallbackFromConferenceSDK(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40767);
    if (this.mUiConfCallback != null)
    {
      paramArrayOfByte = this.mUiConfCallback.callBackFromConf(paramInt1, paramInt2, paramArrayOfByte);
      AppMethodBeat.o(40767);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(40767);
    return null;
  }
  
  public void CallbackWriteLogFromSDK(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(40768);
    if (this.mUiConfCallback != null) {
      this.mUiConfCallback.callbackWriteLog(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3);
    }
    AppMethodBeat.o(40768);
  }
  
  public native int ExitRoom(int paramInt);
  
  public native int GetAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public int GetAudioDeviceFmt(AudDataFmt paramAudDataFmt)
  {
    AppMethodBeat.i(40770);
    int i = GetAudioFormat(this.audioSampleRate, this.audioFrameLen, this.audioChannels);
    paramAudDataFmt.nChannesl = this.audioChannels[0];
    paramAudDataFmt.nFramelen = this.audioFrameLen[0];
    paramAudDataFmt.nSamplerate = this.audioSampleRate[0];
    AppMethodBeat.o(40770);
    return i;
  }
  
  public native int GetAudioFormat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  public native int GetConfRecordAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public int GetDecodeVideoData(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(210461);
    if (1 == GetVideoData(paramArrayOfByte, paramInt))
    {
      AppMethodBeat.o(210461);
      return 1;
    }
    AppMethodBeat.o(210461);
    return 0;
  }
  
  public int GetMembersVadStatus(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(40773);
    if ((paramArrayOfInt == null) || (this.memberVadlist == null))
    {
      AppMethodBeat.o(40773);
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
        AppMethodBeat.o(40773);
        return i;
      }
    }
    AppMethodBeat.o(40773);
    return i;
  }
  
  public native int GetVADStatus(int[] paramArrayOfInt);
  
  public native int GetVoiceActivity(int paramInt);
  
  public native int Hangup(int paramInt);
  
  public native int Init(byte[] paramArrayOfByte, int paramInt);
  
  public int InitSDK(byte[] paramArrayOfByte, int paramInt, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(40771);
    this.mUiConfCallback = paramIConfCallBack;
    this.remoteImgBuffer = new byte[this.defaultWidth * this.defaultHeight * 3 / 2];
    this.memberVadlist = new int[this.maxMemberSize];
    paramInt = Init(paramArrayOfByte, paramInt);
    AppMethodBeat.o(40771);
    return paramInt;
  }
  
  public native int Invite(byte[] paramArrayOfByte, int paramInt);
  
  public native int JoinRoom(byte[] paramArrayOfByte, int paramInt);
  
  public native int OnNetworkChange(int paramInt, byte[] paramArrayOfByte);
  
  public native int PutExternalplayAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int RecvNotify(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int SendAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int SendCmdMsg(byte[] paramArrayOfByte, int paramInt);
  
  public native int SendVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int SetAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public void SetUICallback(IConfCallBack paramIConfCallBack)
  {
    this.mUiConfCallback = paramIConfCallBack;
  }
  
  public native int StartPublish(byte[] paramArrayOfByte, int paramInt);
  
  public native int StopPublish();
  
  public native int SubscribeVideo(byte[] paramArrayOfByte, int paramInt);
  
  public native int SwitchAV(int paramInt1, int paramInt2, int paramInt3);
  
  public native int SwitchAudio(int paramInt);
  
  public native int SwitchVideo(int paramInt);
  
  public native int UnInit();
  
  public int UninitSDK()
  {
    AppMethodBeat.i(40772);
    this.mUiConfCallback = null;
    this.memberVadlist = null;
    UnInit();
    AppMethodBeat.o(40772);
    return 0;
  }
  
  public native int UpdateAuthKey(byte[] paramArrayOfByte, int paramInt);
  
  public native int imgClip(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public native int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6);
  
  public native int videoTrans(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.wxmm.v2conference
 * JD-Core Version:    0.7.0.1
 */