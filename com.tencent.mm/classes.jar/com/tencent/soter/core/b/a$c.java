package com.tencent.soter.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

final class a$c
  extends a
{
  private final String BlW;
  private int BlX;
  private int BlY;
  private AlgorithmParameterSpec BlZ;
  private X500Principal Bma;
  private BigInteger Bmb;
  private Date Bmc;
  private Date Bmd;
  private Date Bme;
  private Date Bmf;
  private Date Bmg;
  private String[] Bmh;
  private String[] Bmi;
  private String[] Bmj;
  private String[] Bmk;
  private boolean Bml;
  private boolean Bmm;
  private int Bmn;
  
  public a$c(String paramString, int paramInt)
  {
    AppMethodBeat.i(73011);
    this.BlY = -1;
    this.Bml = true;
    this.Bmn = -1;
    if (paramString == null)
    {
      paramString = new NullPointerException("keystoreAlias == null");
      AppMethodBeat.o(73011);
      throw paramString;
    }
    if (paramString.isEmpty())
    {
      paramString = new IllegalArgumentException("keystoreAlias must not be empty");
      AppMethodBeat.o(73011);
      throw paramString;
    }
    this.BlW = paramString;
    this.BlX = paramInt;
    AppMethodBeat.o(73011);
  }
  
  public final a W(String... paramVarArgs)
  {
    AppMethodBeat.i(73012);
    this.Bmh = Y(paramVarArgs);
    AppMethodBeat.o(73012);
    return this;
  }
  
  public final a X(String... paramVarArgs)
  {
    AppMethodBeat.i(73013);
    this.Bmj = Y(paramVarArgs);
    AppMethodBeat.o(73013);
    return this;
  }
  
  public final AlgorithmParameterSpec dVj()
  {
    AppMethodBeat.i(73014);
    AlgorithmParameterSpec localAlgorithmParameterSpec = (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.BlW, Integer.valueOf(this.BlY), this.BlZ, this.Bma, this.Bmb, this.Bmc, this.Bmd, this.Bme, this.Bmf, this.Bmg, Integer.valueOf(this.BlX), this.Bmh, this.Bmi, this.Bmj, this.Bmk, Boolean.valueOf(this.Bml), Boolean.valueOf(this.Bmm), Integer.valueOf(this.Bmn) });
    AppMethodBeat.o(73014);
    return localAlgorithmParameterSpec;
  }
  
  public final a dVk()
  {
    this.Bmm = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */