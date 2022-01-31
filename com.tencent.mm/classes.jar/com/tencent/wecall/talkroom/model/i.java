package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;

public final class i
{
  public int BCl;
  public int BCm;
  public int BCn;
  public int BCo;
  public int BCp;
  public int BCq;
  public int BCr;
  public int BCs;
  public int BCt;
  public int mHeight;
  public int mNetType;
  public int mWidth;
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(128000);
    this.BCl = paramInt1;
    this.mWidth = paramInt2;
    this.mHeight = paramInt3;
    this.BCm = paramInt4;
    this.BCn = paramInt5;
    this.BCo = paramInt6;
    this.BCp = paramInt7;
    this.mNetType = paramInt8;
    this.BCq = paramInt9;
    this.BCr = paramInt10;
    this.BCs = paramInt11;
    this.BCt = paramInt12;
    c.d("VoiceEngineConf", new Object[] { "mDisableVideo: ", Integer.valueOf(paramInt1), " mWidth: ", Integer.valueOf(paramInt2), " mHeight: ", Integer.valueOf(paramInt3), " mInFPS: ", Integer.valueOf(paramInt4), " mOutFmt: ", Integer.valueOf(paramInt5), " mOSType: ", Integer.valueOf(paramInt6), " mNetKbps: ", Integer.valueOf(paramInt7), " mNetType: ", Integer.valueOf(paramInt8), " mMTUSize: ", Integer.valueOf(paramInt9), " mCPUFlag: ", Integer.valueOf(paramInt10), " mDispRate: ", Integer.valueOf(paramInt11), " mVCodecType: ", Integer.valueOf(paramInt12) });
    AppMethodBeat.o(128000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.i
 * JD-Core Version:    0.7.0.1
 */