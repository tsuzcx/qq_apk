package com.tencent.soter.core.biometric;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class BiometricManagerCompat$CryptoObject
{
  private final Cipher mCipher;
  private final Mac mMac;
  private final Signature mSignature;
  
  public BiometricManagerCompat$CryptoObject(Signature paramSignature)
  {
    this.mSignature = paramSignature;
    this.mCipher = null;
    this.mMac = null;
  }
  
  public BiometricManagerCompat$CryptoObject(Cipher paramCipher)
  {
    this.mCipher = paramCipher;
    this.mSignature = null;
    this.mMac = null;
  }
  
  public BiometricManagerCompat$CryptoObject(Mac paramMac)
  {
    this.mMac = paramMac;
    this.mCipher = null;
    this.mSignature = null;
  }
  
  public Cipher getCipher()
  {
    return this.mCipher;
  }
  
  public Mac getMac()
  {
    return this.mMac;
  }
  
  public Signature getSignature()
  {
    return this.mSignature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.CryptoObject
 * JD-Core Version:    0.7.0.1
 */