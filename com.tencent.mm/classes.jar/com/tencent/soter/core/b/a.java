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
  
  public static a hc(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.fYY())
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
  
  public abstract AlgorithmParameterSpec fZf();
  
  public abstract a fZg();
  
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
    
    public final AlgorithmParameterSpec fZf()
    {
      return null;
    }
    
    public final a fZg()
    {
      return null;
    }
  }
  
  @TargetApi(23)
  static final class b
    extends a
  {
    private KeyGenParameterSpec.Builder MmR;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(88633);
      this.MmR = null;
      this.MmR = new KeyGenParameterSpec.Builder(paramString, paramInt);
      AppMethodBeat.o(88633);
    }
    
    @SuppressLint({"WrongConstant"})
    public final a ab(String... paramVarArgs)
    {
      AppMethodBeat.i(88635);
      this.MmR.setDigests(paramVarArgs);
      AppMethodBeat.o(88635);
      return this;
    }
    
    @SuppressLint({"WrongConstant"})
    public final a ac(String... paramVarArgs)
    {
      AppMethodBeat.i(88636);
      this.MmR.setSignaturePaddings(paramVarArgs);
      AppMethodBeat.o(88636);
      return this;
    }
    
    public final AlgorithmParameterSpec fZf()
    {
      AppMethodBeat.i(88634);
      KeyGenParameterSpec localKeyGenParameterSpec = this.MmR.build();
      AppMethodBeat.o(88634);
      return localKeyGenParameterSpec;
    }
    
    public final a fZg()
    {
      AppMethodBeat.i(88637);
      this.MmR.setUserAuthenticationRequired(true);
      AppMethodBeat.o(88637);
      return this;
    }
  }
  
  static final class c
    extends a
  {
    private final String MmS;
    private int MmT;
    private int MmU;
    private AlgorithmParameterSpec MmV;
    private X500Principal MmW;
    private BigInteger MmX;
    private Date MmY;
    private Date MmZ;
    private Date Mna;
    private Date Mnb;
    private Date Mnc;
    private String[] Mnd;
    private String[] Mne;
    private String[] Mnf;
    private String[] Mng;
    private boolean Mnh;
    private boolean Mni;
    private int Mnj;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(88638);
      this.MmU = -1;
      this.Mnh = true;
      this.Mnj = -1;
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
      this.MmS = paramString;
      this.MmT = paramInt;
      AppMethodBeat.o(88638);
    }
    
    public final a ab(String... paramVarArgs)
    {
      AppMethodBeat.i(88639);
      this.Mnd = ad(paramVarArgs);
      AppMethodBeat.o(88639);
      return this;
    }
    
    public final a ac(String... paramVarArgs)
    {
      AppMethodBeat.i(88640);
      this.Mnf = ad(paramVarArgs);
      AppMethodBeat.o(88640);
      return this;
    }
    
    public final AlgorithmParameterSpec fZf()
    {
      AppMethodBeat.i(88641);
      AlgorithmParameterSpec localAlgorithmParameterSpec = (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.MmS, Integer.valueOf(this.MmU), this.MmV, this.MmW, this.MmX, this.MmY, this.MmZ, this.Mna, this.Mnb, this.Mnc, Integer.valueOf(this.MmT), this.Mnd, this.Mne, this.Mnf, this.Mng, Boolean.valueOf(this.Mnh), Boolean.valueOf(this.Mni), Integer.valueOf(this.Mnj) });
      AppMethodBeat.o(88641);
      return localAlgorithmParameterSpec;
    }
    
    public final a fZg()
    {
      this.Mni = true;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */