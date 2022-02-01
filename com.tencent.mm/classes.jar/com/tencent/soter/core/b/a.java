package com.tencent.soter.core.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public abstract class a
{
  public static String[] ae(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      return (String[])paramArrayOfString.clone();
    }
    return paramArrayOfString;
  }
  
  public static a hw(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.hlj())
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return new b(paramString, paramInt);
      }
      return new c(paramString, paramInt);
    }
    d.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
    return new a();
  }
  
  public abstract a ac(String... paramVarArgs);
  
  public abstract a ad(String... paramVarArgs);
  
  public abstract AlgorithmParameterSpec hlq();
  
  public abstract a hlr();
  
  static final class a
    extends a
  {
    public final a ac(String... paramVarArgs)
    {
      return null;
    }
    
    public final a ad(String... paramVarArgs)
    {
      return null;
    }
    
    public final AlgorithmParameterSpec hlq()
    {
      return null;
    }
    
    public final a hlr()
    {
      return null;
    }
  }
  
  @TargetApi(23)
  static final class b
    extends a
  {
    private KeyGenParameterSpec.Builder RPp;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(88633);
      this.RPp = null;
      this.RPp = new KeyGenParameterSpec.Builder(paramString, paramInt);
      AppMethodBeat.o(88633);
    }
    
    @SuppressLint({"WrongConstant"})
    public final a ac(String... paramVarArgs)
    {
      AppMethodBeat.i(88635);
      this.RPp.setDigests(paramVarArgs);
      AppMethodBeat.o(88635);
      return this;
    }
    
    @SuppressLint({"WrongConstant"})
    public final a ad(String... paramVarArgs)
    {
      AppMethodBeat.i(88636);
      this.RPp.setSignaturePaddings(paramVarArgs);
      AppMethodBeat.o(88636);
      return this;
    }
    
    public final AlgorithmParameterSpec hlq()
    {
      AppMethodBeat.i(88634);
      KeyGenParameterSpec localKeyGenParameterSpec = this.RPp.build();
      AppMethodBeat.o(88634);
      return localKeyGenParameterSpec;
    }
    
    public final a hlr()
    {
      AppMethodBeat.i(88637);
      this.RPp.setUserAuthenticationRequired(true);
      AppMethodBeat.o(88637);
      return this;
    }
  }
  
  static final class c
    extends a
  {
    private Date RPA;
    private String[] RPB;
    private String[] RPC;
    private String[] RPD;
    private String[] RPE;
    private boolean RPF;
    private boolean RPG;
    private int RPH;
    private final String RPq;
    private int RPr;
    private int RPs;
    private AlgorithmParameterSpec RPt;
    private X500Principal RPu;
    private BigInteger RPv;
    private Date RPw;
    private Date RPx;
    private Date RPy;
    private Date RPz;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(88638);
      this.RPs = -1;
      this.RPF = true;
      this.RPH = -1;
      if (paramString == null)
      {
        paramString = new NullPointerException("keystoreAlias == null");
        AppMethodBeat.o(88638);
        throw paramString;
      }
      if (paramString.isEmpty())
      {
        paramString = new IllegalArgumentException("keystoreAlias must not be empty");
        AppMethodBeat.o(88638);
        throw paramString;
      }
      this.RPq = paramString;
      this.RPr = paramInt;
      AppMethodBeat.o(88638);
    }
    
    public final a ac(String... paramVarArgs)
    {
      AppMethodBeat.i(88639);
      this.RPB = ae(paramVarArgs);
      AppMethodBeat.o(88639);
      return this;
    }
    
    public final a ad(String... paramVarArgs)
    {
      AppMethodBeat.i(88640);
      this.RPD = ae(paramVarArgs);
      AppMethodBeat.o(88640);
      return this;
    }
    
    public final AlgorithmParameterSpec hlq()
    {
      AppMethodBeat.i(88641);
      AlgorithmParameterSpec localAlgorithmParameterSpec = (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.RPq, Integer.valueOf(this.RPs), this.RPt, this.RPu, this.RPv, this.RPw, this.RPx, this.RPy, this.RPz, this.RPA, Integer.valueOf(this.RPr), this.RPB, this.RPC, this.RPD, this.RPE, Boolean.valueOf(this.RPF), Boolean.valueOf(this.RPG), Integer.valueOf(this.RPH) });
      AppMethodBeat.o(88641);
      return localAlgorithmParameterSpec;
    }
    
    public final a hlr()
    {
      this.RPG = true;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */