package com.tencent.worddetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WordDetectNative
{
  private static final String TAG = "WordDetectNative";
  private int handleId = -1;
  
  static
  {
    AppMethodBeat.i(108298);
    System.loadLibrary("wechatWordDetectMod");
    AppMethodBeat.o(108298);
  }
  
  private native int GetDetailResult(WordDetectNative.WordDetectDetailResult paramWordDetectDetailResult, int paramInt);
  
  private native int GetResult(int paramInt);
  
  private static native String GetVersion();
  
  private native int Init(WordDetectNative.ConfigParam paramConfigParam);
  
  private native int Release(int paramInt);
  
  private native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static String getVersion()
  {
    AppMethodBeat.i(108292);
    String str = GetVersion();
    AppMethodBeat.o(108292);
    return str;
  }
  
  public int getDetailResult(WordDetectNative.WordDetectDetailResult paramWordDetectDetailResult)
  {
    AppMethodBeat.i(108297);
    int i = GetDetailResult(paramWordDetectDetailResult, this.handleId);
    AppMethodBeat.o(108297);
    return i;
  }
  
  public int getResult()
  {
    AppMethodBeat.i(108296);
    int i = GetResult(this.handleId);
    AppMethodBeat.o(108296);
    return i;
  }
  
  public int init(WordDetectNative.ConfigParam paramConfigParam)
  {
    AppMethodBeat.i(108293);
    if (this.handleId < 0) {
      this.handleId = Init(paramConfigParam);
    }
    if (this.handleId < 0)
    {
      AppMethodBeat.o(108293);
      return -1;
    }
    AppMethodBeat.o(108293);
    return 0;
  }
  
  public int release()
  {
    AppMethodBeat.i(108295);
    int i = Release(this.handleId);
    this.handleId = -1;
    AppMethodBeat.o(108295);
    return i;
  }
  
  public int scanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(108294);
    paramInt1 = ScanImage(paramArrayOfByte, paramInt1, paramInt2, paramInt3, this.handleId);
    AppMethodBeat.o(108294);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.worddetect.WordDetectNative
 * JD-Core Version:    0.7.0.1
 */