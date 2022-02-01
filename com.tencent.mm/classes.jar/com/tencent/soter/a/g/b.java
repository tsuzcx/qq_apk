package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b
{
  String Dwb;
  c LRu;
  public f LRv;
  public int LRw;
  public com.tencent.soter.a.d.b LRx;
  com.tencent.soter.a.a.a LRy;
  com.tencent.soter.a.a.b LRz;
  Context mContext;
  public int mScene;
  public com.tencent.soter.a.d.a tgY;
  
  public final String toString()
  {
    AppMethodBeat.i(29);
    String str = "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.Dwb + '\'' + ", mIWrapGetChallengeStr=" + this.LRu + ", mIWrapUploadSignature=" + this.LRv + ", mContext=" + this.mContext + ", mBiometricType=" + this.LRw + '}';
    AppMethodBeat.o(29);
    return str;
  }
  
  public static final class a
  {
    public b LRA;
    
    public a()
    {
      AppMethodBeat.i(28);
      this.LRA = new b((byte)0);
      AppMethodBeat.o(28);
    }
    
    public final a a(com.tencent.soter.a.a.a parama)
    {
      this.LRA.LRy = parama;
      return this;
    }
    
    public final a a(com.tencent.soter.a.a.b paramb)
    {
      this.LRA.LRz = paramb;
      return this;
    }
    
    public final a aZy(String paramString)
    {
      this.LRA.Dwb = paramString;
      return this;
    }
    
    public final a agP(int paramInt)
    {
      this.LRA.mScene = paramInt;
      return this;
    }
    
    public final a agQ(int paramInt)
    {
      this.LRA.LRw = paramInt;
      return this;
    }
    
    public final a lg(Context paramContext)
    {
      this.LRA.mContext = paramContext;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.b
 * JD-Core Version:    0.7.0.1
 */