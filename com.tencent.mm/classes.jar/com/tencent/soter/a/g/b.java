package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b
{
  String IwV;
  c RQP;
  public f RQQ;
  public int RQR;
  public com.tencent.soter.a.d.b RQS;
  com.tencent.soter.a.a.a RQT;
  com.tencent.soter.a.a.b RQU;
  Context mContext;
  public int mScene;
  public com.tencent.soter.a.d.a wFx;
  
  public final String toString()
  {
    AppMethodBeat.i(29);
    String str = "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.IwV + '\'' + ", mIWrapGetChallengeStr=" + this.RQP + ", mIWrapUploadSignature=" + this.RQQ + ", mContext=" + this.mContext + ", mBiometricType=" + this.RQR + '}';
    AppMethodBeat.o(29);
    return str;
  }
  
  public static final class a
  {
    public b RQV;
    
    public a()
    {
      AppMethodBeat.i(28);
      this.RQV = new b((byte)0);
      AppMethodBeat.o(28);
    }
    
    public final a a(com.tencent.soter.a.a.a parama)
    {
      this.RQV.RQT = parama;
      return this;
    }
    
    public final a a(com.tencent.soter.a.a.b paramb)
    {
      this.RQV.RQU = paramb;
      return this;
    }
    
    public final a aqL(int paramInt)
    {
      this.RQV.mScene = paramInt;
      return this;
    }
    
    public final a aqM(int paramInt)
    {
      this.RQV.RQR = paramInt;
      return this;
    }
    
    public final a bqn(String paramString)
    {
      this.RQV.IwV = paramString;
      return this;
    }
    
    public final a lh(Context paramContext)
    {
      this.RQV.mContext = paramContext;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.b
 * JD-Core Version:    0.7.0.1
 */