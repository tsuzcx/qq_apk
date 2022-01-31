package com.tencent.mm.plugin.multi;

import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.wecall.talkroom.model.i;
import java.util.concurrent.atomic.AtomicInteger;

public class talk
{
  public static int VOICE_FRAME_DURATION;
  public static int VOICE_SAMPLERATE = 8000;
  public byte[] field_capInfo = null;
  public int field_localImgHeight = 0;
  public int field_localImgWidth = 0;
  public int field_remoteImgChannel = 0;
  public int field_remoteImgHeight = 0;
  public int field_remoteImgLength = 0;
  public int field_remoteImgWidth = 0;
  
  static
  {
    VOICE_FRAME_DURATION = 20;
    try
    {
      if ((com.tencent.pb.common.a.a.wFa) && (com.tencent.pb.common.a.a.wFr))
      {
        com.tencent.pb.common.c.a.o("stlport_shared", d.pZI);
        com.tencent.pb.common.c.a.o("wechatxlog", d.pZI);
        com.tencent.pb.common.c.a.o("voipMain", d.pZI);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      c.x("loadLibrary: ", new Object[] { localThrowable });
    }
  }
  
  public native int GetAudioData(byte[] paramArrayOfByte, int paramInt, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2);
  
  public native int GetVoiceActivity(int paramInt);
  
  public native int IsSilenceFrame();
  
  public native void OnMembersChanged(int[] paramArrayOfInt);
  
  public native int Open(talk.a parama, i parami, int paramInt1, int paramInt2, int paramInt3, long paramLong, int[] paramArrayOfInt1, short[] paramArrayOfShort1, int paramInt4, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt5, int[] paramArrayOfInt3, short[] paramArrayOfShort2, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte2, int[] paramArrayOfInt4, int paramInt9);
  
  public native int SendAudio(byte[] paramArrayOfByte, short paramShort, int paramInt);
  
  public native int SendVideo(byte[] paramArrayOfByte, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void SetAVEncryptType(int paramInt1, int paramInt2);
  
  public native int SetCurrentMicId(int paramInt);
  
  public native int close();
  
  public native int getChannelBytes(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2);
  
  public native int getSampleRate(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2);
  
  public native int init(int paramInt1, int paramInt2, String paramString);
  
  public native int onNetworkChange(int paramInt);
  
  public native int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int setMVSvrCfg(int[] paramArrayOfInt, int paramInt);
  
  public final int um(int paramInt)
  {
    return setAppCmd(paramInt, new byte[] { 5 }, 1);
  }
  
  public native int uninit();
  
  public native int videoDecode(int[] paramArrayOfInt);
  
  public native int videoTrans(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multi.talk
 * JD-Core Version:    0.7.0.1
 */