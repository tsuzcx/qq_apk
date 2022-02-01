package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class VoiceEngineConf
{
  public int aicg;
  public int aich;
  public int aici;
  public int aicj;
  public int aick;
  public int aicl;
  public int aicm;
  public int aicn;
  public int aico;
  public int mHeight;
  public int mNetType;
  public int mWidth;
  
  public VoiceEngineConf(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(62551);
    this.aicg = paramInt1;
    this.mWidth = paramInt2;
    this.mHeight = paramInt3;
    this.aich = paramInt4;
    this.aici = paramInt5;
    this.aicj = paramInt6;
    this.aick = paramInt7;
    this.mNetType = paramInt8;
    this.aicl = paramInt9;
    this.aicm = paramInt10;
    this.aicn = paramInt11;
    this.aico = paramInt12;
    b.d("VoiceEngineConf", new Object[] { "mDisableVideo: ", Integer.valueOf(paramInt1), " mWidth: ", Integer.valueOf(paramInt2), " mHeight: ", Integer.valueOf(paramInt3), " mInFPS: ", Integer.valueOf(paramInt4), " mOutFmt: ", Integer.valueOf(paramInt5), " mOSType: ", Integer.valueOf(paramInt6), " mNetKbps: ", Integer.valueOf(paramInt7), " mNetType: ", Integer.valueOf(paramInt8), " mMTUSize: ", Integer.valueOf(paramInt9), " mCPUFlag: ", Integer.valueOf(paramInt10), " mDispRate: ", Integer.valueOf(paramInt11), " mVCodecType: ", Integer.valueOf(paramInt12) });
    AppMethodBeat.o(62551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.VoiceEngineConf
 * JD-Core Version:    0.7.0.1
 */