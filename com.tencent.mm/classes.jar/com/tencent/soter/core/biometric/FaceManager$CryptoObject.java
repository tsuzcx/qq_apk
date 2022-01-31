package com.tencent.soter.core.biometric;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FaceManager$CryptoObject
{
  private final Object mCrypto;
  
  public FaceManager$CryptoObject(Signature paramSignature)
  {
    this.mCrypto = paramSignature;
  }
  
  public FaceManager$CryptoObject(Cipher paramCipher)
  {
    this.mCrypto = paramCipher;
  }
  
  public FaceManager$CryptoObject(Mac paramMac)
  {
    this.mCrypto = paramMac;
  }
  
  public final Cipher getCipher()
  {
    if ((this.mCrypto instanceof Cipher)) {
      return (Cipher)this.mCrypto;
    }
    return null;
  }
  
  public final Mac getMac()
  {
    if ((this.mCrypto instanceof Mac)) {
      return (Mac)this.mCrypto;
    }
    return null;
  }
  
  public final Signature getSignature()
  {
    if ((this.mCrypto instanceof Signature)) {
      return (Signature)this.mCrypto;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FaceManager.CryptoObject
 * JD-Core Version:    0.7.0.1
 */