package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b
{
  public com.tencent.soter.a.d.a HfW;
  String WhN;
  c ahyh;
  public f ahyi;
  public int ahyj;
  String ahyk;
  String ahyl;
  String ahym;
  String ahyn;
  boolean ahyo;
  public com.tencent.soter.a.d.b ahyp;
  com.tencent.soter.a.a.a ahyq;
  com.tencent.soter.a.a.b ahyr;
  Context mContext;
  public int mScene;
  
  public final String toString()
  {
    AppMethodBeat.i(29);
    String str = "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.WhN + '\'' + ", mIWrapGetChallengeStr=" + this.ahyh + ", mIWrapUploadSignature=" + this.ahyi + ", mContext=" + this.mContext + ", mBiometricType=" + this.ahyj + '}';
    AppMethodBeat.o(29);
    return str;
  }
  
  public static final class a
  {
    public b ahys;
    
    public a()
    {
      AppMethodBeat.i(28);
      this.ahys = new b((byte)0);
      AppMethodBeat.o(28);
    }
    
    public final a a(com.tencent.soter.a.a.a parama)
    {
      this.ahys.ahyq = parama;
      return this;
    }
    
    public final a a(com.tencent.soter.a.a.b paramb)
    {
      this.ahys.ahyr = paramb;
      return this;
    }
    
    public final a aHk(int paramInt)
    {
      this.ahys.mScene = paramInt;
      return this;
    }
    
    public final a aHl(int paramInt)
    {
      this.ahys.ahyj = paramInt;
      return this;
    }
    
    public final a bFL(String paramString)
    {
      this.ahys.WhN = paramString;
      return this;
    }
    
    public final a bFM(String paramString)
    {
      this.ahys.ahyk = paramString;
      return this;
    }
    
    public final a bFN(String paramString)
    {
      this.ahys.ahyl = paramString;
      return this;
    }
    
    public final a bFO(String paramString)
    {
      this.ahys.ahym = paramString;
      return this;
    }
    
    public final a bFP(String paramString)
    {
      this.ahys.ahyn = paramString;
      return this;
    }
    
    public final a jYz()
    {
      this.ahys.ahyo = true;
      return this;
    }
    
    public final a os(Context paramContext)
    {
      this.ahys.mContext = paramContext;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.a.g.b
 * JD-Core Version:    0.7.0.1
 */