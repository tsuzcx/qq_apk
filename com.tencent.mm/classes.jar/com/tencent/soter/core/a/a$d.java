package com.tencent.soter.core.a;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class a$d
{
  final Cipher mCipher;
  final Mac mMac;
  final Signature mSignature;
  
  public a$d(Signature paramSignature)
  {
    this.mSignature = paramSignature;
    this.mCipher = null;
    this.mMac = null;
  }
  
  public a$d(Cipher paramCipher)
  {
    this.mCipher = paramCipher;
    this.mSignature = null;
    this.mMac = null;
  }
  
  public a$d(Mac paramMac)
  {
    this.mMac = paramMac;
    this.mCipher = null;
    this.mSignature = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.core.a.a.d
 * JD-Core Version:    0.7.0.1
 */