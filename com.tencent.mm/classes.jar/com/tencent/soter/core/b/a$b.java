package com.tencent.soter.core.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.security.spec.AlgorithmParameterSpec;

@TargetApi(23)
final class a$b
  extends a
{
  private KeyGenParameterSpec.Builder wOx = null;
  
  public a$b(String paramString, int paramInt)
  {
    this.wOx = new KeyGenParameterSpec.Builder(paramString, paramInt);
  }
  
  @SuppressLint({"WrongConstant"})
  public final a N(String... paramVarArgs)
  {
    this.wOx.setDigests(paramVarArgs);
    return this;
  }
  
  @SuppressLint({"WrongConstant"})
  public final a O(String... paramVarArgs)
  {
    this.wOx.setSignaturePaddings(paramVarArgs);
    return this;
  }
  
  public final AlgorithmParameterSpec cPo()
  {
    return this.wOx.build();
  }
  
  public final a cPp()
  {
    this.wOx.setUserAuthenticationRequired(true);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */