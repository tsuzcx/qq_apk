package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;

public final class MMProtocalJni
{
  public static native byte[] aesDecrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int aesDecryptFile(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  public static native byte[] aesEncrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int computerKeyWithAllStr(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PByteArray paramPByteArray, int paramInt2);
  
  public static native byte[] decodeSecureNotifyData(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte2);
  
  public static native void genClientCheckKVRes(int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, PByteArray paramPByteArray);
  
  public static native int genSignature(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int generateECKey(int paramInt, PByteArray paramPByteArray1, PByteArray paramPByteArray2);
  
  public static native boolean mergeSyncKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PByteArray paramPByteArray);
  
  public static native boolean pack(byte[] paramArrayOfByte1, PByteArray paramPByteArray, byte[] paramArrayOfByte2, int paramInt1, byte[] paramArrayOfByte3, String paramString, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt5, int paramInt6, int paramInt7);
  
  public static native boolean packDoubleHybrid(PByteArray paramPByteArray, byte[] paramArrayOfByte1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5);
  
  public static native boolean packHybrid(PByteArray paramPByteArray, byte[] paramArrayOfByte1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5);
  
  public static native boolean packHybridEcdh(PByteArray paramPByteArray, byte[] paramArrayOfByte1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6);
  
  public static native boolean rsaPublicEncrypt(byte[] paramArrayOfByte1, PByteArray paramPByteArray, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public static native boolean rsaPublicEncryptPemkey(byte[] paramArrayOfByte1, PByteArray paramPByteArray, byte[] paramArrayOfByte2);
  
  public static native boolean setClientPackVersion(int paramInt);
  
  public static native void setIsLite(boolean paramBoolean);
  
  public static native boolean setProtocalJniLogLevel(int paramInt);
  
  public static native boolean unpack(PByteArray paramPByteArray1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PByteArray paramPByteArray2, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4);
  
  public static native boolean verifySyncKey(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.MMProtocalJni
 * JD-Core Version:    0.7.0.1
 */