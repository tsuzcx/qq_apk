package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b
{
  public com.tencent.soter.a.d.a Byu;
  String Pra;
  c Ztt;
  public f Ztu;
  public int Ztv;
  public com.tencent.soter.a.d.b Ztw;
  com.tencent.soter.a.a.a Ztx;
  com.tencent.soter.a.a.b Zty;
  Context mContext;
  public int mScene;
  
  public final String toString()
  {
    AppMethodBeat.i(29);
    String str = "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.Pra + '\'' + ", mIWrapGetChallengeStr=" + this.Ztt + ", mIWrapUploadSignature=" + this.Ztu + ", mContext=" + this.mContext + ", mBiometricType=" + this.Ztv + '}';
    AppMethodBeat.o(29);
    return str;
  }
  
  public static final class a
  {
    public b Ztz;
    
    public a()
    {
      AppMethodBeat.i(28);
      this.Ztz = new b((byte)0);
      AppMethodBeat.o(28);
    }
    
    public final a a(com.tencent.soter.a.a.a parama)
    {
      this.Ztz.Ztx = parama;
      return this;
    }
    
    public final a a(com.tencent.soter.a.a.b paramb)
    {
      this.Ztz.Zty = paramb;
      return this;
    }
    
    public final a aAy(int paramInt)
    {
      this.Ztz.mScene = paramInt;
      return this;
    }
    
    public final a aAz(int paramInt)
    {
      this.Ztz.Ztv = paramInt;
      return this;
    }
    
    public final a bDg(String paramString)
    {
      this.Ztz.Pra = paramString;
      return this;
    }
    
    public final a mf(Context paramContext)
    {
      this.Ztz.mContext = paramContext;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.b
 * JD-Core Version:    0.7.0.1
 */