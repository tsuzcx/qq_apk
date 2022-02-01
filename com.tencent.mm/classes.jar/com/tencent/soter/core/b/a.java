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
  
  public static a ig(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.ioI())
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
  
  public abstract AlgorithmParameterSpec ioQ();
  
  public abstract a ioR();
  
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
    
    public final AlgorithmParameterSpec ioQ()
    {
      return null;
    }
    
    public final a ioR()
    {
      return null;
    }
  }
  
  @TargetApi(23)
  static final class b
    extends a
  {
    private KeyGenParameterSpec.Builder ZrU;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(88633);
      this.ZrU = null;
      this.ZrU = new KeyGenParameterSpec.Builder(paramString, paramInt);
      AppMethodBeat.o(88633);
    }
    
    @SuppressLint({"WrongConstant"})
    public final a ac(String... paramVarArgs)
    {
      AppMethodBeat.i(88635);
      this.ZrU.setDigests(paramVarArgs);
      AppMethodBeat.o(88635);
      return this;
    }
    
    @SuppressLint({"WrongConstant"})
    public final a ad(String... paramVarArgs)
    {
      AppMethodBeat.i(88636);
      this.ZrU.setSignaturePaddings(paramVarArgs);
      AppMethodBeat.o(88636);
      return this;
    }
    
    public final AlgorithmParameterSpec ioQ()
    {
      AppMethodBeat.i(88634);
      KeyGenParameterSpec localKeyGenParameterSpec = this.ZrU.build();
      AppMethodBeat.o(88634);
      return localKeyGenParameterSpec;
    }
    
    public final a ioR()
    {
      AppMethodBeat.i(88637);
      this.ZrU.setUserAuthenticationRequired(true);
      AppMethodBeat.o(88637);
      return this;
    }
  }
  
  static final class c
    extends a
  {
    private final String ZrV;
    private int ZrW;
    private int ZrX;
    private AlgorithmParameterSpec ZrY;
    private X500Principal ZrZ;
    private BigInteger Zsa;
    private Date Zsb;
    private Date Zsc;
    private Date Zsd;
    private Date Zse;
    private Date Zsf;
    private String[] Zsg;
    private String[] Zsh;
    private String[] Zsi;
    private String[] Zsj;
    private boolean Zsk;
    private boolean Zsl;
    private int Zsm;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(88638);
      this.ZrX = -1;
      this.Zsk = true;
      this.Zsm = -1;
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
      this.ZrV = paramString;
      this.ZrW = paramInt;
      AppMethodBeat.o(88638);
    }
    
    public final a ac(String... paramVarArgs)
    {
      AppMethodBeat.i(88639);
      this.Zsg = ae(paramVarArgs);
      AppMethodBeat.o(88639);
      return this;
    }
    
    public final a ad(String... paramVarArgs)
    {
      AppMethodBeat.i(88640);
      this.Zsi = ae(paramVarArgs);
      AppMethodBeat.o(88640);
      return this;
    }
    
    public final AlgorithmParameterSpec ioQ()
    {
      AppMethodBeat.i(88641);
      AlgorithmParameterSpec localAlgorithmParameterSpec = (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.ZrV, Integer.valueOf(this.ZrX), this.ZrY, this.ZrZ, this.Zsa, this.Zsb, this.Zsc, this.Zsd, this.Zse, this.Zsf, Integer.valueOf(this.ZrW), this.Zsg, this.Zsh, this.Zsi, this.Zsj, Boolean.valueOf(this.Zsk), Boolean.valueOf(this.Zsl), Integer.valueOf(this.Zsm) });
      AppMethodBeat.o(88641);
      return localAlgorithmParameterSpec;
    }
    
    public final a ioR()
    {
      this.Zsl = true;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */