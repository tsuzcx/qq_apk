package com.tencent.soter.core.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.spec.AlgorithmParameterSpec;

@TargetApi(23)
final class a$b
  extends a
{
  private KeyGenParameterSpec.Builder BlV;
  
  public a$b(String paramString, int paramInt)
  {
    AppMethodBeat.i(73006);
    this.BlV = null;
    this.BlV = new KeyGenParameterSpec.Builder(paramString, paramInt);
    AppMethodBeat.o(73006);
  }
  
  @SuppressLint({"WrongConstant"})
  public final a W(String... paramVarArgs)
  {
    AppMethodBeat.i(73008);
    this.BlV.setDigests(paramVarArgs);
    AppMethodBeat.o(73008);
    return this;
  }
  
  @SuppressLint({"WrongConstant"})
  public final a X(String... paramVarArgs)
  {
    AppMethodBeat.i(73009);
    this.BlV.setSignaturePaddings(paramVarArgs);
    AppMethodBeat.o(73009);
    return this;
  }
  
  public final AlgorithmParameterSpec dVj()
  {
    AppMethodBeat.i(73007);
    KeyGenParameterSpec localKeyGenParameterSpec = this.BlV.build();
    AppMethodBeat.o(73007);
    return localKeyGenParameterSpec;
  }
  
  public final a dVk()
  {
    AppMethodBeat.i(73010);
    this.BlV.setUserAuthenticationRequired(true);
    AppMethodBeat.o(73010);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */