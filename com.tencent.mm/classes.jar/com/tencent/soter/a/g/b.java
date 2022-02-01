package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b
{
  String ADm;
  c IvQ;
  public f IvR;
  public int IvS;
  public com.tencent.soter.a.d.b IvT;
  com.tencent.soter.a.a.a IvU;
  com.tencent.soter.a.a.b IvV;
  Context mContext;
  public int mScene;
  public com.tencent.soter.a.d.a rcc;
  
  public final String toString()
  {
    AppMethodBeat.i(29);
    String str = "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.ADm + '\'' + ", mIWrapGetChallengeStr=" + this.IvQ + ", mIWrapUploadSignature=" + this.IvR + ", mContext=" + this.mContext + ", mBiometricType=" + this.IvS + '}';
    AppMethodBeat.o(29);
    return str;
  }
  
  public static final class a
  {
    public b IvW;
    
    public a()
    {
      AppMethodBeat.i(28);
      this.IvW = new b((byte)0);
      AppMethodBeat.o(28);
    }
    
    public final a a(com.tencent.soter.a.a.a parama)
    {
      this.IvW.IvU = parama;
      return this;
    }
    
    public final a a(com.tencent.soter.a.a.b paramb)
    {
      this.IvW.IvV = paramb;
      return this;
    }
    
    public final a aNV(String paramString)
    {
      this.IvW.ADm = paramString;
      return this;
    }
    
    public final a abW(int paramInt)
    {
      this.IvW.mScene = paramInt;
      return this;
    }
    
    public final a abX(int paramInt)
    {
      this.IvW.IvS = paramInt;
      return this;
    }
    
    public final a kH(Context paramContext)
    {
      this.IvW.mContext = paramContext;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.b
 * JD-Core Version:    0.7.0.1
 */