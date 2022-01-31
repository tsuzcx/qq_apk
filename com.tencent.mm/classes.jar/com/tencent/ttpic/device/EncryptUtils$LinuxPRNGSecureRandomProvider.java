package com.tencent.ttpic.device;

import java.security.Provider;

class EncryptUtils$LinuxPRNGSecureRandomProvider
  extends Provider
{
  public EncryptUtils$LinuxPRNGSecureRandomProvider()
  {
    super("LinuxPRNG", 1.0D, "A Linux-specific random number provider that uses /dev/urandom");
    put("SecureRandom.SHA1PRNG", EncryptUtils.LinuxPRNGSecureRandom.class.getName());
    put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.device.EncryptUtils.LinuxPRNGSecureRandomProvider
 * JD-Core Version:    0.7.0.1
 */