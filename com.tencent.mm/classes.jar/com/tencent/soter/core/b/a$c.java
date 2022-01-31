package com.tencent.soter.core.b;

import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

final class a$c
  extends a
{
  private int wOA = -1;
  private AlgorithmParameterSpec wOB;
  private X500Principal wOC;
  private BigInteger wOD;
  private Date wOE;
  private Date wOF;
  private Date wOG;
  private Date wOH;
  private Date wOI;
  private String[] wOJ;
  private String[] wOK;
  private String[] wOL;
  private String[] wOM;
  private boolean wON = true;
  private boolean wOO;
  private int wOP = -1;
  private final String wOy;
  private int wOz;
  
  public a$c(String paramString, int paramInt)
  {
    if (paramString == null) {
      throw new NullPointerException("keystoreAlias == null");
    }
    if (paramString.isEmpty()) {
      throw new IllegalArgumentException("keystoreAlias must not be empty");
    }
    this.wOy = paramString;
    this.wOz = paramInt;
  }
  
  public final a N(String... paramVarArgs)
  {
    this.wOJ = P(paramVarArgs);
    return this;
  }
  
  public final a O(String... paramVarArgs)
  {
    this.wOL = P(paramVarArgs);
    return this;
  }
  
  public final AlgorithmParameterSpec cPo()
  {
    return (AlgorithmParameterSpec)Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[] { String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { this.wOy, Integer.valueOf(this.wOA), this.wOB, this.wOC, this.wOD, this.wOE, this.wOF, this.wOG, this.wOH, this.wOI, Integer.valueOf(this.wOz), this.wOJ, this.wOK, this.wOL, this.wOM, Boolean.valueOf(this.wON), Boolean.valueOf(this.wOO), Integer.valueOf(this.wOP) });
  }
  
  public final a cPp()
  {
    this.wOO = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */