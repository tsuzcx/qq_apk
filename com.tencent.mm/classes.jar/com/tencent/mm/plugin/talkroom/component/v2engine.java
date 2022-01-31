package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;

public class v2engine
{
  private static f dVG;
  
  public static f Hy()
  {
    if (dVG == null) {
      dVG = new f(ae.getContext());
    }
    return dVG;
  }
  
  public native int Close();
  
  public native int GetAudioData(PByteArray paramPByteArray, int paramInt, PInt paramPInt1, PInt paramPInt2);
  
  public native int GetStatis(PByteArray paramPByteArray, String paramString);
  
  public native int IsSilenceFrame();
  
  public native int Open(b paramb, int paramInt1, int paramInt2, int paramInt3, long paramLong, int[] paramArrayOfInt, short[] paramArrayOfShort, int paramInt4);
  
  public native int Send(byte[] paramArrayOfByte, short paramShort);
  
  public native int SetCurrentMicId(int paramInt);
  
  public native int initLive(int paramInt, String paramString);
  
  public native int uninitLive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.v2engine
 * JD-Core Version:    0.7.0.1
 */