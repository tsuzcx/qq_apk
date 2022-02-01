package com.tencent.soter.core.b;

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
  public static String[] ag(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      return (String[])paramArrayOfString.clone();
    }
    return paramArrayOfString;
  }
  
  public static a js(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.jXV())
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return new b(paramString, paramInt);
      }
      return new c(paramString, paramInt);
    }
    d.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
    return new a();
  }
  
  public abstract a ae(String... paramVarArgs);
  
  public abstract a af(String... paramVarArgs);
  
  public abstract AlgorithmParameterSpec jYd();
  
  public abstract a jYe();
  
  static final class a
    extends a
  {
    public final a ae(String... paramVarArgs)
    {
      return null;
    }
    
    public final a af(String... paramVarArgs)
    {
      return null;
    }
    
    public final AlgorithmParameterSpec jYd()
    {
      return null;
    }
    
    public final a jYe()
    {
      return null;
    }
  }
  
  static final class b
    extends a
  {
    private KeyGenParameterSpec.Builder ahwI;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(88633);
      this.ahwI = null;
      this.ahwI = new KeyGenParameterSpec.Builder(paramString, paramInt);
      AppMethodBeat.o(88633);
    }
    
    public final a ae(String... paramVarArgs)
    {
      AppMethodBeat.i(88635);
      this.ahwI.setDigests(paramVarArgs);
      AppMethodBeat.o(88635);
      return this;
    }
    
    public final a af(String... paramVarArgs)
    {
      AppMethodBeat.i(88636);
      this.ahwI.setSignaturePaddings(paramVarArgs);
      AppMethodBeat.o(88636);
      return this;
    }
    
    public final AlgorithmParameterSpec jYd()
    {
      AppMethodBeat.i(88634);
      KeyGenParameterSpec localKeyGenParameterSpec = this.ahwI.build();
      AppMethodBeat.o(88634);
      return localKeyGenParameterSpec;
    }
    
    public final a jYe()
    {
      AppMethodBeat.i(88637);
      this.ahwI.setUserAuthenticationRequired(true);
      AppMethodBeat.o(88637);
      return this;
    }
  }
  
  static final class c
    extends a
  {
    private final String ahwJ;
    private int ahwK;
    private int ahwL;
    private AlgorithmParameterSpec ahwM;
    private X500Principal ahwN;
    private BigInteger ahwO;
    private Date ahwP;
    private Date ahwQ;
    private Date ahwR;
    private Date ahwS;
    private Date ahwT;
    private String[] ahwU;
    private String[] ahwV;
    private String[] ahwW;
    private String[] ahwX;
    private boolean ahwY;
    private boolean ahwZ;
    private int ahxa;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(88638);
      this.ahwL = -1;
      this.ahwY = true;
      this.ahxa = -1;
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
      this.ahwJ = paramString;
      this.ahwK = paramInt;
      AppMethodBeat.o(88638);
    }
    
    public final a ae(String... paramVarArgs)
    {
      AppMethodBeat.i(88639);
      this.ahwU = ag(paramVarArgs);
      AppMethodBeat.o(88639);
      return this;
    }
    
    public final a af(String... paramVarArgs)
    {
      AppMethodBeat.i(88640);
      this.ahwW = ag(paramVarArgs);
      AppMethodBeat.o(88640);
      return this;
    }
    
    public final AlgorithmParameterSpec jYd()
    {
      AppMethodBeat.i(88641);
      AlgorithmParameterSpec localAlgorithmParameterSpec = (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.ahwJ, Integer.valueOf(this.ahwL), this.ahwM, this.ahwN, this.ahwO, this.ahwP, this.ahwQ, this.ahwR, this.ahwS, this.ahwT, Integer.valueOf(this.ahwK), this.ahwU, this.ahwV, this.ahwW, this.ahwX, Boolean.valueOf(this.ahwY), Boolean.valueOf(this.ahwZ), Integer.valueOf(this.ahxa) });
      AppMethodBeat.o(88641);
      return localAlgorithmParameterSpec;
    }
    
    public final a jYe()
    {
      this.ahwZ = true;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */