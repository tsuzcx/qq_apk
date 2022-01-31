package com.tencent.soter.core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  public final Signature awP(String paramString)
  {
    AppMethodBeat.i(73052);
    d.d("Monday", "CertSoterCore initAuthKeySignature", new Object[0]);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.CertSoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
      AppMethodBeat.o(73052);
      return null;
    }
    Signature localSignature = Signature.getInstance("SHA256withRSA/PSS");
    KeyStore localKeyStore = KeyStore.getInstance(this.BmH);
    localKeyStore.load(null);
    paramString = localKeyStore.getKey(paramString, null);
    if (paramString != null)
    {
      localSignature.initSign((PrivateKey)paramString);
      AppMethodBeat.o(73052);
      return localSignature;
    }
    d.e("Soter.CertSoterCore", "soter: entry not exists", new Object[0]);
    AppMethodBeat.o(73052);
    return null;
  }
  
  public final f dVd()
  {
    AppMethodBeat.i(73050);
    d.i("Soter.CertSoterCore", "soter: start generate ask", new Object[0]);
    if (dVc()) {
      try
      {
        Object localObject = KeyPairGenerator.getInstance("RSA", this.BmH);
        ((KeyPairGenerator)localObject).initialize(com.tencent.soter.core.b.a.fe(e.dVl().Bmr + ".addcounter.auto_signed_when_get_pubkey_attk", 16).W(new String[] { "SHA-256" }).X(new String[] { "PSS" }).dVj());
        long l = System.nanoTime();
        ((KeyPairGenerator)localObject).generateKeyPair();
        d.i("Soter.CertSoterCore", "soter: generate successfully. cost: %d ms", new Object[] { Long.valueOf(g.oZ(l)) });
        localObject = new f(0);
        AppMethodBeat.o(73050);
        return localObject;
      }
      catch (Exception localException)
      {
        d.e("Soter.CertSoterCore", "soter: generateAppGlobalSecureKey " + localException.toString(), new Object[0]);
        d.a("Soter.CertSoterCore", localException, "soter: generateAppGlobalSecureKey error");
        f localf1 = new f(4, localException.toString());
        AppMethodBeat.o(73050);
        return localf1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.CertSoterCore", localOutOfMemoryError, "soter: out of memory when generate ASK!! maybe no attk inside");
        h.dVm();
      }
    }
    for (;;)
    {
      f localf2 = new f(2);
      AppMethodBeat.o(73050);
      return localf2;
      d.e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
    }
  }
  
  public final i dVh()
  {
    AppMethodBeat.i(73051);
    d.i("Soter.CertSoterCore", "soter: start get app global secure key pub", new Object[0]);
    if (dVc()) {}
    for (;;)
    {
      try
      {
        Object localObject = KeyStore.getInstance(this.BmH);
        ((KeyStore)localObject).load(null);
        try
        {
          localObject = ((KeyStore)localObject).getCertificateChain(e.dVl().Bmr);
          if (localObject != null)
          {
            localObject = new i((Certificate[])localObject);
            AppMethodBeat.o(73051);
            return localObject;
          }
          d.e("Soter.CertSoterCore", "soter: key can not be retrieved", new Object[0]);
          AppMethodBeat.o(73051);
          return null;
        }
        catch (ClassCastException localClassCastException)
        {
          d.e("Soter.CertSoterCore", "soter: cast error: " + localClassCastException.toString(), new Object[0]);
          AppMethodBeat.o(73051);
          return null;
        }
        d.e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
      }
      catch (Exception localException)
      {
        d.a("Soter.CertSoterCore", localException, "soter: error when get ask");
        AppMethodBeat.o(73051);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.CertSoterCore", localOutOfMemoryError, "soter: out of memory when getting ask!! maybe no attk inside");
        h.dVm();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.d.a
 * JD-Core Version:    0.7.0.1
 */