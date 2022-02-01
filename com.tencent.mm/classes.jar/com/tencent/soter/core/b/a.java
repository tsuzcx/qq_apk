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
  public static String[] ad(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      return (String[])paramArrayOfString.clone();
    }
    return paramArrayOfString;
  }
  
  public static a gT(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.fUz())
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return new b(paramString, paramInt);
      }
      return new c(paramString, paramInt);
    }
    d.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
    return new a();
  }
  
  public abstract a ab(String... paramVarArgs);
  
  public abstract a ac(String... paramVarArgs);
  
  public abstract AlgorithmParameterSpec fUG();
  
  public abstract a fUH();
  
  static final class a
    extends a
  {
    public final a ab(String... paramVarArgs)
    {
      return null;
    }
    
    public final a ac(String... paramVarArgs)
    {
      return null;
    }
    
    public final AlgorithmParameterSpec fUG()
    {
      return null;
    }
    
    public final a fUH()
    {
      return null;
    }
  }
  
  @TargetApi(23)
  static final class b
    extends a
  {
    private KeyGenParameterSpec.Builder LPU;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(88633);
      this.LPU = null;
      this.LPU = new KeyGenParameterSpec.Builder(paramString, paramInt);
      AppMethodBeat.o(88633);
    }
    
    @SuppressLint({"WrongConstant"})
    public final a ab(String... paramVarArgs)
    {
      AppMethodBeat.i(88635);
      this.LPU.setDigests(paramVarArgs);
      AppMethodBeat.o(88635);
      return this;
    }
    
    @SuppressLint({"WrongConstant"})
    public final a ac(String... paramVarArgs)
    {
      AppMethodBeat.i(88636);
      this.LPU.setSignaturePaddings(paramVarArgs);
      AppMethodBeat.o(88636);
      return this;
    }
    
    public final AlgorithmParameterSpec fUG()
    {
      AppMethodBeat.i(88634);
      KeyGenParameterSpec localKeyGenParameterSpec = this.LPU.build();
      AppMethodBeat.o(88634);
      return localKeyGenParameterSpec;
    }
    
    public final a fUH()
    {
      AppMethodBeat.i(88637);
      this.LPU.setUserAuthenticationRequired(true);
      AppMethodBeat.o(88637);
      return this;
    }
  }
  
  static final class c
    extends a
  {
    private final String LPV;
    private int LPW;
    private int LPX;
    private AlgorithmParameterSpec LPY;
    private X500Principal LPZ;
    private BigInteger LQa;
    private Date LQb;
    private Date LQc;
    private Date LQd;
    private Date LQe;
    private Date LQf;
    private String[] LQg;
    private String[] LQh;
    private String[] LQi;
    private String[] LQj;
    private boolean LQk;
    private boolean LQl;
    private int LQm;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(88638);
      this.LPX = -1;
      this.LQk = true;
      this.LQm = -1;
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
      this.LPV = paramString;
      this.LPW = paramInt;
      AppMethodBeat.o(88638);
    }
    
    public final a ab(String... paramVarArgs)
    {
      AppMethodBeat.i(88639);
      this.LQg = ad(paramVarArgs);
      AppMethodBeat.o(88639);
      return this;
    }
    
    public final a ac(String... paramVarArgs)
    {
      AppMethodBeat.i(88640);
      this.LQi = ad(paramVarArgs);
      AppMethodBeat.o(88640);
      return this;
    }
    
    public final AlgorithmParameterSpec fUG()
    {
      AppMethodBeat.i(88641);
      AlgorithmParameterSpec localAlgorithmParameterSpec = (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.LPV, Integer.valueOf(this.LPX), this.LPY, this.LPZ, this.LQa, this.LQb, this.LQc, this.LQd, this.LQe, this.LQf, Integer.valueOf(this.LPW), this.LQg, this.LQh, this.LQi, this.LQj, Boolean.valueOf(this.LQk), Boolean.valueOf(this.LQl), Integer.valueOf(this.LQm) });
      AppMethodBeat.o(88641);
      return localAlgorithmParameterSpec;
    }
    
    public final a fUH()
    {
      this.LQl = true;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */