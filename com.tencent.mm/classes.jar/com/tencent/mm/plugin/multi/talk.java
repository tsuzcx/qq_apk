package com.tencent.mm.plugin.multi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.i;
import java.util.concurrent.atomic.AtomicInteger;

public class talk
{
  public static int VOICE_FRAME_DURATION;
  public static int VOICE_SAMPLERATE;
  public static int tOi;
  public byte[] field_capInfo = null;
  public int field_localImgHeight = 0;
  public int field_localImgWidth = 0;
  public int field_remoteImgChannel = 0;
  public int field_remoteImgHeight = 0;
  public int field_remoteImgLength = 0;
  public int field_remoteImgWidth = 0;
  
  static
  {
    AppMethodBeat.i(62794);
    VOICE_SAMPLERATE = 8000;
    VOICE_FRAME_DURATION = 20;
    tOi = 9;
    try
    {
      if ((a.Ijx) && (a.IjO))
      {
        System.loadLibrary("stlport_shared");
        System.loadLibrary("wechatxlog");
        System.loadLibrary("voipMain");
      }
      AppMethodBeat.o(62794);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.w("loadLibrary: ", new Object[] { localThrowable });
      AppMethodBeat.o(62794);
    }
  }
  
  public native int GetAudioData(byte[] paramArrayOfByte, int paramInt, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2);
  
  public native int GetVoiceActivity(int paramInt);
  
  public native int IsSilenceFrame();
  
  public native void OnMembersChanged(int[] paramArrayOfInt);
  
  public native int Open(a parama, i parami, int paramInt1, int paramInt2, int paramInt3, long paramLong, String[] paramArrayOfString1, short[] paramArrayOfShort1, int paramInt4, int[] paramArrayOfInt1, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt5, String[] paramArrayOfString2, short[] paramArrayOfShort2, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte2, int[] paramArrayOfInt2, int paramInt9, int paramInt10);
  
  public native int Redirect(String[] paramArrayOfString1, short[] paramArrayOfShort1, String[] paramArrayOfString2, short[] paramArrayOfShort2, int paramInt);
  
  public native int SendAudio(byte[] paramArrayOfByte, short paramShort, int paramInt);
  
  public native int SendVideo(byte[] paramArrayOfByte, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void SetAVEncryptType(int paramInt1, int paramInt2);
  
  public native int SetCurrentMicId(int paramInt);
  
  public native int close();
  
  public native int getChannelBytes(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2);
  
  public native int getSampleRate(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2);
  
  public native int init(int paramInt1, int paramInt2, String paramString);
  
  public native int onNetworkChange(int paramInt);
  
  public final int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(62793);
    paramInt = setAppCmd(paramInt, new byte[] { 5 }, 1);
    AppMethodBeat.o(62793);
    return paramInt;
  }
  
  public native int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int setMVSvrCfg(int[] paramArrayOfInt, int paramInt);
  
  public native int uninit();
  
  public native int videoDecode(int[] paramArrayOfInt);
  
  public native int videoTrans(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
  
  public static abstract interface a
  {
    public abstract void keep_OnError(int paramInt);
    
    public abstract void keep_OnNotify(int paramInt);
    
    public abstract void keep_OnOpenSuccess();
    
    public abstract void keep_OnReportChannel(String paramString);
    
    public abstract void keep_OnReportEngineRecv(String paramString, int paramInt);
    
    public abstract void keep_OnReportEngineSend(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multi.talk
 * JD-Core Version:    0.7.0.1
 */