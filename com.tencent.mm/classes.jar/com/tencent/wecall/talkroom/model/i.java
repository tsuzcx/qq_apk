package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public final class i
{
  public int MKO;
  public int MKP;
  public int MKQ;
  public int MKR;
  public int MKS;
  public int MKT;
  public int MKU;
  public int MKV;
  public int MKW;
  public int mHeight;
  public int mNetType;
  public int mWidth;
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(62551);
    this.MKO = paramInt1;
    this.mWidth = paramInt2;
    this.mHeight = paramInt3;
    this.MKP = paramInt4;
    this.MKQ = paramInt5;
    this.MKR = paramInt6;
    this.MKS = paramInt7;
    this.mNetType = paramInt8;
    this.MKT = paramInt9;
    this.MKU = paramInt10;
    this.MKV = paramInt11;
    this.MKW = paramInt12;
    b.d("VoiceEngineConf", new Object[] { "mDisableVideo: ", Integer.valueOf(paramInt1), " mWidth: ", Integer.valueOf(paramInt2), " mHeight: ", Integer.valueOf(paramInt3), " mInFPS: ", Integer.valueOf(paramInt4), " mOutFmt: ", Integer.valueOf(paramInt5), " mOSType: ", Integer.valueOf(paramInt6), " mNetKbps: ", Integer.valueOf(paramInt7), " mNetType: ", Integer.valueOf(paramInt8), " mMTUSize: ", Integer.valueOf(paramInt9), " mCPUFlag: ", Integer.valueOf(paramInt10), " mDispRate: ", Integer.valueOf(paramInt11), " mVCodecType: ", Integer.valueOf(paramInt12) });
    AppMethodBeat.o(62551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.i
 * JD-Core Version:    0.7.0.1
 */