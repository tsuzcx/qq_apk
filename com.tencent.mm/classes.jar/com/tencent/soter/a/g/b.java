package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b
{
  String BVH;
  public f JXA;
  public int JXB;
  public com.tencent.soter.a.d.b JXC;
  com.tencent.soter.a.a.a JXD;
  com.tencent.soter.a.a.b JXE;
  c JXz;
  Context mContext;
  public int mScene;
  public com.tencent.soter.a.d.a skw;
  
  public final String toString()
  {
    AppMethodBeat.i(29);
    String str = "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.BVH + '\'' + ", mIWrapGetChallengeStr=" + this.JXz + ", mIWrapUploadSignature=" + this.JXA + ", mContext=" + this.mContext + ", mBiometricType=" + this.JXB + '}';
    AppMethodBeat.o(29);
    return str;
  }
  
  public static final class a
  {
    public b JXF;
    
    public a()
    {
      AppMethodBeat.i(28);
      this.JXF = new b((byte)0);
      AppMethodBeat.o(28);
    }
    
    public final a a(com.tencent.soter.a.a.a parama)
    {
      this.JXF.JXD = parama;
      return this;
    }
    
    public final a a(com.tencent.soter.a.a.b paramb)
    {
      this.JXF.JXE = paramb;
      return this;
    }
    
    public final a aTy(String paramString)
    {
      this.JXF.BVH = paramString;
      return this;
    }
    
    public final a aep(int paramInt)
    {
      this.JXF.mScene = paramInt;
      return this;
    }
    
    public final a aeq(int paramInt)
    {
      this.JXF.JXB = paramInt;
      return this;
    }
    
    public final a kT(Context paramContext)
    {
      this.JXF.mContext = paramContext;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.b
 * JD-Core Version:    0.7.0.1
 */