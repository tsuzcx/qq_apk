package com.tencent.soter.core.d;

import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.e;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;

public final class a
  extends c
{
  public a(String paramString)
  {
    super(paramString);
  }
  
  public final Signature afU(String paramString)
  {
    d.d("Monday", "CertSoterCore initAuthKeySignature", new Object[0]);
    if (g.bl(paramString))
    {
      d.e("Soter.CertSoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
      return null;
    }
    Signature localSignature = Signature.getInstance("SHA256withRSA/PSS");
    KeyStore localKeyStore = KeyStore.getInstance(this.wPj);
    localKeyStore.load(null);
    paramString = localKeyStore.getKey(paramString, null);
    if (paramString != null)
    {
      localSignature.initSign((PrivateKey)paramString);
      return localSignature;
    }
    d.e("Soter.CertSoterCore", "soter: entry not exists", new Object[0]);
    return null;
  }
  
  public final f cPi()
  {
    d.i("Soter.CertSoterCore", "soter: start generate ask", new Object[0]);
    if (cPh()) {
      try
      {
        Object localObject = KeyPairGenerator.getInstance("RSA", this.wPj);
        ((KeyPairGenerator)localObject).initialize(com.tencent.soter.core.b.a.dU(e.cPq().wOT + ".addcounter.auto_signed_when_get_pubkey_attk", 16).N(new String[] { "SHA-256" }).O(new String[] { "PSS" }).cPo());
        long l = System.nanoTime();
        ((KeyPairGenerator)localObject).generateKeyPair();
        d.i("Soter.CertSoterCore", "soter: generate successfully. cost: %d ms", new Object[] { Long.valueOf(g.in(l)) });
        localObject = new f(0);
        return localObject;
      }
      catch (Exception localException)
      {
        d.e("Soter.CertSoterCore", "soter: generateAppGlobalSecureKey " + localException.toString(), new Object[0]);
        d.a("Soter.CertSoterCore", localException, "soter: generateAppGlobalSecureKey error");
        return new f(4, localException.toString());
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.CertSoterCore", localOutOfMemoryError, "soter: out of memory when generate ASK!! maybe no attk inside");
        h.cPr();
      }
    }
    for (;;)
    {
      return new f(2);
      d.e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
    }
  }
  
  public final i cPm()
  {
    d.i("Soter.CertSoterCore", "soter: start get app global secure key pub", new Object[0]);
    if (cPh()) {}
    for (;;)
    {
      try
      {
        Object localObject = KeyStore.getInstance(this.wPj);
        ((KeyStore)localObject).load(null);
        try
        {
          localObject = ((KeyStore)localObject).getCertificateChain(e.cPq().wOT);
          if (localObject != null) {
            return new i((Certificate[])localObject);
          }
          d.e("Soter.CertSoterCore", "soter: key can not be retrieved", new Object[0]);
          return null;
        }
        catch (ClassCastException localClassCastException)
        {
          d.e("Soter.CertSoterCore", "soter: cast error: " + localClassCastException.toString(), new Object[0]);
          return null;
        }
        d.e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
      }
      catch (Exception localException)
      {
        d.a("Soter.CertSoterCore", localException, "soter: error when get ask");
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.CertSoterCore", localOutOfMemoryError, "soter: out of memory when getting ask!! maybe no attk inside");
        h.cPr();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.d.a
 * JD-Core Version:    0.7.0.1
 */