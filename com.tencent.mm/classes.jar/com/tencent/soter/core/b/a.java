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
  public static String[] ab(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      return (String[])paramArrayOfString.clone();
    }
    return paramArrayOfString;
  }
  
  public static a gv(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.fDh())
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return new b(paramString, paramInt);
      }
      return new c(paramString, paramInt);
    }
    d.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
    return new a();
  }
  
  public abstract a Z(String... paramVarArgs);
  
  public abstract a aa(String... paramVarArgs);
  
  public abstract AlgorithmParameterSpec fDo();
  
  public abstract a fDp();
  
  static final class a
    extends a
  {
    public final a Z(String... paramVarArgs)
    {
      return null;
    }
    
    public final a aa(String... paramVarArgs)
    {
      return null;
    }
    
    public final AlgorithmParameterSpec fDo()
    {
      return null;
    }
    
    public final a fDp()
    {
      return null;
    }
  }
  
  @TargetApi(23)
  static final class b
    extends a
  {
    private KeyGenParameterSpec.Builder JVZ;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(88633);
      this.JVZ = null;
      this.JVZ = new KeyGenParameterSpec.Builder(paramString, paramInt);
      AppMethodBeat.o(88633);
    }
    
    @SuppressLint({"WrongConstant"})
    public final a Z(String... paramVarArgs)
    {
      AppMethodBeat.i(88635);
      this.JVZ.setDigests(paramVarArgs);
      AppMethodBeat.o(88635);
      return this;
    }
    
    @SuppressLint({"WrongConstant"})
    public final a aa(String... paramVarArgs)
    {
      AppMethodBeat.i(88636);
      this.JVZ.setSignaturePaddings(paramVarArgs);
      AppMethodBeat.o(88636);
      return this;
    }
    
    public final AlgorithmParameterSpec fDo()
    {
      AppMethodBeat.i(88634);
      KeyGenParameterSpec localKeyGenParameterSpec = this.JVZ.build();
      AppMethodBeat.o(88634);
      return localKeyGenParameterSpec;
    }
    
    public final a fDp()
    {
      AppMethodBeat.i(88637);
      this.JVZ.setUserAuthenticationRequired(true);
      AppMethodBeat.o(88637);
      return this;
    }
  }
  
  static final class c
    extends a
  {
    private final String JWa;
    private int JWb;
    private int JWc;
    private AlgorithmParameterSpec JWd;
    private X500Principal JWe;
    private BigInteger JWf;
    private Date JWg;
    private Date JWh;
    private Date JWi;
    private Date JWj;
    private Date JWk;
    private String[] JWl;
    private String[] JWm;
    private String[] JWn;
    private String[] JWo;
    private boolean JWp;
    private boolean JWq;
    private int JWr;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(88638);
      this.JWc = -1;
      this.JWp = true;
      this.JWr = -1;
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
      this.JWa = paramString;
      this.JWb = paramInt;
      AppMethodBeat.o(88638);
    }
    
    public final a Z(String... paramVarArgs)
    {
      AppMethodBeat.i(88639);
      this.JWl = ab(paramVarArgs);
      AppMethodBeat.o(88639);
      return this;
    }
    
    public final a aa(String... paramVarArgs)
    {
      AppMethodBeat.i(88640);
      this.JWn = ab(paramVarArgs);
      AppMethodBeat.o(88640);
      return this;
    }
    
    public final AlgorithmParameterSpec fDo()
    {
      AppMethodBeat.i(88641);
      AlgorithmParameterSpec localAlgorithmParameterSpec = (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.JWa, Integer.valueOf(this.JWc), this.JWd, this.JWe, this.JWf, this.JWg, this.JWh, this.JWi, this.JWj, this.JWk, Integer.valueOf(this.JWb), this.JWl, this.JWm, this.JWn, this.JWo, Boolean.valueOf(this.JWp), Boolean.valueOf(this.JWq), Integer.valueOf(this.JWr) });
      AppMethodBeat.o(88641);
      return localAlgorithmParameterSpec;
    }
    
    public final a fDp()
    {
      this.JWq = true;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */