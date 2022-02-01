package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;

public class v2engine
{
  public native int Close();
  
  public native int GetAudioData(PByteArray paramPByteArray, int paramInt, PInt paramPInt1, PInt paramPInt2);
  
  public native int GetStatis(PByteArray paramPByteArray, String paramString);
  
  public native int IsSilenceFrame();
  
  public native int Open(ILiveConEngineCallback_AIDL paramILiveConEngineCallback_AIDL, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, byte[] paramArrayOfByte, int paramInt5);
  
  public native int Send(byte[] paramArrayOfByte, short paramShort);
  
  public native int SetCurrentMicId(int paramInt);
  
  public native int initLive(int paramInt, String paramString);
  
  public native int uninitLive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.v2engine
 * JD-Core Version:    0.7.0.1
 */