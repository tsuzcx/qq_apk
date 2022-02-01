package com.tencent.worddetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WordDetectNative
{
  private static final String TAG = "WordDetectNative";
  private int handleId = -1;
  
  static
  {
    AppMethodBeat.i(40076);
    System.loadLibrary("wechatWordDetectMod");
    AppMethodBeat.o(40076);
  }
  
  private native int GetDetailResult(WordDetectDetailResult paramWordDetectDetailResult, int paramInt);
  
  private native int GetResult(int paramInt);
  
  private static native String GetVersion();
  
  private native int Init(ConfigParam paramConfigParam);
  
  private native int Release(int paramInt);
  
  private native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static String getVersion()
  {
    AppMethodBeat.i(40070);
    String str = GetVersion();
    AppMethodBeat.o(40070);
    return str;
  }
  
  public int getDetailResult(WordDetectDetailResult paramWordDetectDetailResult)
  {
    AppMethodBeat.i(40075);
    int i = GetDetailResult(paramWordDetectDetailResult, this.handleId);
    AppMethodBeat.o(40075);
    return i;
  }
  
  public int getResult()
  {
    AppMethodBeat.i(40074);
    int i = GetResult(this.handleId);
    AppMethodBeat.o(40074);
    return i;
  }
  
  public int init(ConfigParam paramConfigParam)
  {
    AppMethodBeat.i(40071);
    if (this.handleId < 0)
    {
      int i = Init(paramConfigParam);
      if (i < 0)
      {
        AppMethodBeat.o(40071);
        return i;
      }
      this.handleId = i;
    }
    AppMethodBeat.o(40071);
    return 0;
  }
  
  public int release()
  {
    AppMethodBeat.i(40073);
    if (this.handleId >= 0)
    {
      int i = Release(this.handleId);
      this.handleId = -1;
      AppMethodBeat.o(40073);
      return i;
    }
    AppMethodBeat.o(40073);
    return 0;
  }
  
  public int scanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(40072);
    paramInt1 = ScanImage(paramArrayOfByte, paramInt1, paramInt2, paramInt3, this.handleId);
    AppMethodBeat.o(40072);
    return paramInt1;
  }
  
  public static class ConfigParam
  {
    public String detect_model_bin;
    public String detect_model_param;
  }
  
  public static class WordDetectDetailResult
  {
    public int height;
    public float[] rate_lang;
    public byte[] rawData;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.worddetect.WordDetectNative
 * JD-Core Version:    0.7.0.1
 */