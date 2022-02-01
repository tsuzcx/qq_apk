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
  
  public static a gr(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.fmR())
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
  
  public abstract AlgorithmParameterSpec fmY();
  
  public abstract a fmZ();
  
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
    
    public final AlgorithmParameterSpec fmY()
    {
      return null;
    }
    
    public final a fmZ()
    {
      return null;
    }
  }
  
  @TargetApi(23)
  static final class b
    extends a
  {
    private KeyGenParameterSpec.Builder Iuq;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(88633);
      this.Iuq = null;
      this.Iuq = new KeyGenParameterSpec.Builder(paramString, paramInt);
      AppMethodBeat.o(88633);
    }
    
    @SuppressLint({"WrongConstant"})
    public final a Z(String... paramVarArgs)
    {
      AppMethodBeat.i(88635);
      this.Iuq.setDigests(paramVarArgs);
      AppMethodBeat.o(88635);
      return this;
    }
    
    @SuppressLint({"WrongConstant"})
    public final a aa(String... paramVarArgs)
    {
      AppMethodBeat.i(88636);
      this.Iuq.setSignaturePaddings(paramVarArgs);
      AppMethodBeat.o(88636);
      return this;
    }
    
    public final AlgorithmParameterSpec fmY()
    {
      AppMethodBeat.i(88634);
      KeyGenParameterSpec localKeyGenParameterSpec = this.Iuq.build();
      AppMethodBeat.o(88634);
      return localKeyGenParameterSpec;
    }
    
    public final a fmZ()
    {
      AppMethodBeat.i(88637);
      this.Iuq.setUserAuthenticationRequired(true);
      AppMethodBeat.o(88637);
      return this;
    }
  }
  
  static final class c
    extends a
  {
    private Date IuA;
    private Date IuB;
    private String[] IuC;
    private String[] IuD;
    private String[] IuE;
    private String[] IuF;
    private boolean IuG;
    private boolean IuH;
    private int IuI;
    private final String Iur;
    private int Ius;
    private int Iut;
    private AlgorithmParameterSpec Iuu;
    private X500Principal Iuv;
    private BigInteger Iuw;
    private Date Iux;
    private Date Iuy;
    private Date Iuz;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(88638);
      this.Iut = -1;
      this.IuG = true;
      this.IuI = -1;
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
      this.Iur = paramString;
      this.Ius = paramInt;
      AppMethodBeat.o(88638);
    }
    
    public final a Z(String... paramVarArgs)
    {
      AppMethodBeat.i(88639);
      this.IuC = ab(paramVarArgs);
      AppMethodBeat.o(88639);
      return this;
    }
    
    public final a aa(String... paramVarArgs)
    {
      AppMethodBeat.i(88640);
      this.IuE = ab(paramVarArgs);
      AppMethodBeat.o(88640);
      return this;
    }
    
    public final AlgorithmParameterSpec fmY()
    {
      AppMethodBeat.i(88641);
      AlgorithmParameterSpec localAlgorithmParameterSpec = (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.Iur, Integer.valueOf(this.Iut), this.Iuu, this.Iuv, this.Iuw, this.Iux, this.Iuy, this.Iuz, this.IuA, this.IuB, Integer.valueOf(this.Ius), this.IuC, this.IuD, this.IuE, this.IuF, Boolean.valueOf(this.IuG), Boolean.valueOf(this.IuH), Integer.valueOf(this.IuI) });
      AppMethodBeat.o(88641);
      return localAlgorithmParameterSpec;
    }
    
    public final a fmZ()
    {
      this.IuH = true;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */