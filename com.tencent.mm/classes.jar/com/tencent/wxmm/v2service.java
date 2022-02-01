package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class v2service
{
  private static final String TAG = "WXMM.Voip";
  public byte[] callbackOutData = null;
  public int defaultHeight = 544;
  public int defaultWidth = 704;
  public int field_remoteImgHeight = 0;
  public int field_remoteImgLength = 0;
  public int field_remoteImgWidth = 0;
  public int field_remoteScreenImgHeight = 0;
  public int field_remoteScreenImgLength = 0;
  public int field_remoteScreenImgWidth = 0;
  private IVoipCallBack mUiCallBack = null;
  public byte[] remoteImgBuffer = null;
  
  static
  {
    AppMethodBeat.i(40806);
    System.loadLibrary("c++_shared");
    System.loadLibrary("marsbridgexlog");
    System.loadLibrary("marsbridgenetwork");
    System.loadLibrary("voipService");
    AppMethodBeat.o(40806);
  }
  
  private native int Init(byte[] paramArrayOfByte, int paramInt);
  
  private native int UnInit();
  
  public native int Accept(int paramInt);
  
  public native int Ack();
  
  public byte[] ByteArrayCallbackFromVoipSDK(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40805);
    if (this.mUiCallBack != null)
    {
      paramArrayOfByte = this.mUiCallBack.callBackFromVoip2(paramInt1, paramInt2, paramArrayOfByte);
      AppMethodBeat.o(40805);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(40805);
    return null;
  }
  
  public native int Hangup(int paramInt);
  
  public int InitSDK(byte[] paramArrayOfByte, int paramInt, IVoipCallBack paramIVoipCallBack)
  {
    AppMethodBeat.i(40802);
    this.mUiCallBack = paramIVoipCallBack;
    this.remoteImgBuffer = new byte[this.defaultWidth * this.defaultHeight * 3 / 2];
    int i = Init(paramArrayOfByte, paramInt);
    v2helper.Logd("WXMM.Voip", "protocal init ret :" + i + " " + paramInt);
    AppMethodBeat.o(40802);
    return i;
  }
  
  public int IntCallbackFromVoipSDK(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40804);
    if (this.mUiCallBack != null) {
      this.mUiCallBack.callBackFromVoip1(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(40804);
    return 0;
  }
  
  public native int Invite(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public native int OnNetworkChange(int paramInt);
  
  public native int RecvNotify(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int SwitchAVCmd(int paramInt);
  
  public int UninitSDK()
  {
    AppMethodBeat.i(40803);
    this.mUiCallBack = null;
    UnInit();
    AppMethodBeat.o(40803);
    return 0;
  }
  
  public native int UpdateAuthKey(byte[] paramArrayOfByte, int paramInt);
  
  public native int playCallback(byte[] paramArrayOfByte, int paramInt);
  
  public native int recordCallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(40801);
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      v2helper.Logd("WXMM.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
    }
    AppMethodBeat.o(40801);
    return paramInt;
  }
  
  public native int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int videoDecode(byte[] paramArrayOfByte);
  
  public native int videoEncodeToSend(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wxmm.v2service
 * JD-Core Version:    0.7.0.1
 */