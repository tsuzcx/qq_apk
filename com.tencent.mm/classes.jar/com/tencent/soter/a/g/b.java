package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b
{
  String DNG;
  c Mor;
  public f Mos;
  public int Mot;
  public com.tencent.soter.a.d.b Mou;
  com.tencent.soter.a.a.a Mov;
  com.tencent.soter.a.a.b Mow;
  Context mContext;
  public int mScene;
  public com.tencent.soter.a.d.a trR;
  
  public final String toString()
  {
    AppMethodBeat.i(29);
    String str = "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.DNG + '\'' + ", mIWrapGetChallengeStr=" + this.Mor + ", mIWrapUploadSignature=" + this.Mos + ", mContext=" + this.mContext + ", mBiometricType=" + this.Mot + '}';
    AppMethodBeat.o(29);
    return str;
  }
  
  public static final class a
  {
    public b Mox;
    
    public a()
    {
      AppMethodBeat.i(28);
      this.Mox = new b((byte)0);
      AppMethodBeat.o(28);
    }
    
    public final a a(com.tencent.soter.a.a.a parama)
    {
      this.Mox.Mov = parama;
      return this;
    }
    
    public final a a(com.tencent.soter.a.a.b paramb)
    {
      this.Mox.Mow = paramb;
      return this;
    }
    
    public final a ahy(int paramInt)
    {
      this.Mox.mScene = paramInt;
      return this;
    }
    
    public final a ahz(int paramInt)
    {
      this.Mox.Mot = paramInt;
      return this;
    }
    
    public final a bbb(String paramString)
    {
      this.Mox.DNG = paramString;
      return this;
    }
    
    public final a lm(Context paramContext)
    {
      this.Mox.mContext = paramContext;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.b
 * JD-Core Version:    0.7.0.1
 */