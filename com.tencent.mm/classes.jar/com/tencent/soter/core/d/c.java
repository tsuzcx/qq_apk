package com.tencent.soter.core.d;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.soter.core.b.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.e;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;

public class c
  extends b
  implements com.tencent.soter.core.c.b
{
  private static boolean wOq = false;
  protected String wPj = "SoterKeyStore";
  
  public c(String paramString)
  {
    this.wPj = paramString;
  }
  
  @SuppressLint({"PrivateApi"})
  public static void setUp()
  {
    try
    {
      Method localMethod = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod("install", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      d.i("Soter.SoterCoreBeforeTreble", "soter: no SoterProvider found", new Object[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      d.i("Soter.SoterCoreBeforeTreble", "soter: function not found", new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      d.i("Soter.SoterCoreBeforeTreble", "soter: cannot access", new Object[0]);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      d.i("Soter.SoterCoreBeforeTreble", "soter: InvocationTargetException", new Object[0]);
      return;
    }
    finally
    {
      wOq = true;
    }
  }
  
  public final f afO(String paramString)
  {
    if (g.bl(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      return new f(1, "no authKeyName");
    }
    if (cPh()) {
      try
      {
        if (!cPk())
        {
          paramString = new f(3, "app secure key not exist");
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: generate auth key failed: " + paramString.toString(), new Object[0]);
        return new f(5, paramString.toString());
        KeyStore.getInstance(this.wPj).load(null);
        KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA", this.wPj);
        try
        {
          localKeyPairGenerator.initialize(a.dU(paramString + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", new Object[] { e.cPq().wOT }), 4).N(new String[] { "SHA-256" }).cPp().O(new String[] { "PSS" }).cPo());
          long l = System.nanoTime();
          localKeyPairGenerator.generateKeyPair();
          d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully, cost: %d ms", new Object[] { Long.valueOf(g.in(l)) });
          paramString = new f(0);
          return paramString;
        }
        catch (Exception paramString)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cause exception. maybe reflection exception: " + paramString.toString(), new Object[0]);
          paramString = new f(5, paramString.toString());
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when generate AuthKey!! maybe no attk inside");
        h.cPr();
      }
    }
    for (;;)
    {
      return new f(2);
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    }
  }
  
  public final boolean afP(String paramString)
  {
    if (g.bl(paramString)) {
      d.e("Soter.SoterCoreBeforeTreble", "soter: authkey name not correct", new Object[0]);
    }
    for (;;)
    {
      return false;
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(this.wPj);
        localKeyStore.load(null);
        paramString = localKeyStore.getCertificate(paramString);
        if (paramString != null) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + paramString.toString(), new Object[0]);
      }
    }
    return false;
  }
  
  public final boolean afQ(String paramString)
  {
    d.i("Soter.SoterCoreBeforeTreble", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[] { paramString, Boolean.valueOf(true) }), new Object[0]);
    if (g.bl(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: checking key valid: authkey name not correct", new Object[0]);
      return false;
    }
    try
    {
      afU(paramString);
      d.i("Soter.SoterCoreBeforeTreble", "soter: key valid", new Object[0]);
      return true;
    }
    catch (UnrecoverableEntryException localUnrecoverableEntryException)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid.", new Object[0]);
      bR(paramString, false);
      return false;
    }
    catch (Exception paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: occurs other exceptions: %s", new Object[] { paramString.toString() });
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: occurs other exceptions");
      return false;
    }
    catch (OutOfMemoryError paramString)
    {
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
      h.cPr();
      return false;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      label70:
      break label70;
    }
  }
  
  public final i afR(String paramString)
  {
    if (g.bl(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      return null;
    }
    if (cPh()) {
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(this.wPj);
        localKeyStore.load(null);
        try
        {
          paramString = localKeyStore.getKey(paramString, "from_soter_ui".toCharArray());
          if (paramString != null) {
            return bS(paramString.getEncoded());
          }
          d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
          return null;
        }
        catch (ClassCastException paramString)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + paramString.toString(), new Object[0]);
          return null;
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter " + this.wPj, new Object[0]);
      }
      catch (Exception paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: error in get auth key model");
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
        h.cPr();
        return null;
      }
    }
    return null;
  }
  
  public final Signature afS(String paramString)
  {
    if (g.bl(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      return null;
    }
    if (cPh()) {}
    try
    {
      paramString = afU(paramString);
      return paramString;
    }
    catch (UnrecoverableEntryException paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid. Advice remove the key", new Object[0]);
      return null;
    }
    catch (Exception paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: exception when getSignatureResult: " + paramString.toString(), new Object[0]);
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: exception when getSignatureResult");
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
      h.cPr();
      return null;
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter" + this.wPj, new Object[0]);
      return null;
    }
    catch (InvalidKeyException paramString)
    {
      label36:
      break label36;
    }
  }
  
  public Signature afU(String paramString)
  {
    if (g.bl(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      return null;
    }
    Signature localSignature = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
    KeyStore localKeyStore = KeyStore.getInstance(this.wPj);
    localKeyStore.load(null);
    paramString = (KeyStore.PrivateKeyEntry)localKeyStore.getEntry(paramString, null);
    if (paramString != null)
    {
      localSignature.initSign(paramString.getPrivateKey());
      return localSignature;
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: entry not exists", new Object[0]);
    return null;
  }
  
  public final f bR(String paramString, boolean paramBoolean)
  {
    if (g.bl(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      return new f(1, "no authKeyName");
    }
    d.i("Soter.SoterCoreBeforeTreble", "soter: start remove key: " + paramString, new Object[0]);
    if (cPh()) {
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(this.wPj);
        localKeyStore.load(null);
        localKeyStore.deleteEntry(paramString);
        if (paramBoolean)
        {
          d.i("Soter.SoterCoreBeforeTreble", "soter: auto delete ask", new Object[0]);
          if (cPk()) {
            cPj();
          }
        }
        paramString = new f(0);
        return paramString;
      }
      catch (Exception paramString)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: removeAuthKey " + paramString.toString(), new Object[0]);
        return new f(6, paramString.toString());
      }
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    return new f(2);
  }
  
  public final boolean cPh()
  {
    if (!wOq) {
      setUp();
    }
    if (h.cPs())
    {
      d.w("Soter.SoterCoreBeforeTreble", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
      return false;
    }
    Provider[] arrayOfProvider = Security.getProviders();
    if (arrayOfProvider == null)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: no provider supported", new Object[0]);
      return false;
    }
    int j = arrayOfProvider.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfProvider[i].getName();
      if ((str != null) && (str.startsWith("SoterKeyStore")))
      {
        d.i("Soter.SoterCoreBeforeTreble", "soter: found soter provider", new Object[0]);
        return true;
      }
      i += 1;
    }
    d.i("Soter.SoterCoreBeforeTreble", "soter: soter provider not found", new Object[0]);
    return false;
  }
  
  public f cPi()
  {
    d.i("Soter.SoterCoreBeforeTreble", "soter: start generate ask", new Object[0]);
    if (cPh()) {
      try
      {
        KeyStore.getInstance(this.wPj).load(null);
        Object localObject = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
        ((KeyPairGenerator)localObject).initialize(a.dU(e.cPq().wOT + ".addcounter.auto_signed_when_get_pubkey_attk", 4).N(new String[] { "SHA-256" }).O(new String[] { "PSS" }).cPo());
        long l = System.nanoTime();
        ((KeyPairGenerator)localObject).generateKeyPair();
        d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully. cost: %d ms", new Object[] { Long.valueOf(g.in(l)) });
        localObject = new f(0);
        return localObject;
      }
      catch (Exception localException)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: generateAppGlobalSecureKey " + localException.toString(), new Object[0]);
        d.a("Soter.SoterCoreBeforeTreble", localException, "soter: generateAppGlobalSecureKey error");
        return new f(4, localException.toString());
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.SoterCoreBeforeTreble", localOutOfMemoryError, "soter: out of memory when generate ASK!! maybe no attk inside");
        h.cPr();
      }
    }
    for (;;)
    {
      return new f(2);
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    }
  }
  
  public final f cPj()
  {
    d.i("Soter.SoterCoreBeforeTreble", "soter: start remove app global secure key", new Object[0]);
    if (cPh()) {
      try
      {
        Object localObject = KeyStore.getInstance(this.wPj);
        ((KeyStore)localObject).load(null);
        ((KeyStore)localObject).deleteEntry(e.cPq().wOT);
        localObject = new f(0);
        return localObject;
      }
      catch (Exception localException)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: removeAppGlobalSecureKey " + localException.toString(), new Object[0]);
        return new f(5, localException.toString());
      }
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    return new f(2);
  }
  
  public final boolean cPk()
  {
    boolean bool = false;
    try
    {
      Object localObject = KeyStore.getInstance(this.wPj);
      ((KeyStore)localObject).load(null);
      localObject = ((KeyStore)localObject).getCertificate(e.cPq().wOT);
      if (localObject != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + localException.toString(), new Object[0]);
    }
    return false;
  }
  
  public final boolean cPl()
  {
    return (cPk()) && (cPm() != null);
  }
  
  public i cPm()
  {
    d.i("Soter.SoterCoreBeforeTreble", "soter: start get app global secure key pub", new Object[0]);
    if (cPh()) {
      try
      {
        Object localObject = KeyStore.getInstance(this.wPj);
        ((KeyStore)localObject).load(null);
        try
        {
          localObject = ((KeyStore)localObject).getKey(e.cPq().wOT, "from_soter_ui".toCharArray());
          if (localObject != null) {
            return bS(((Key)localObject).getEncoded());
          }
          d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
          return null;
        }
        catch (ClassCastException localClassCastException)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + localClassCastException.toString(), new Object[0]);
          return null;
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
      }
      catch (Exception localException)
      {
        d.a("Soter.SoterCoreBeforeTreble", localException, "soter: error when get ask");
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.SoterCoreBeforeTreble", localOutOfMemoryError, "soter: out of memory when getting ask!! maybe no attk inside");
        h.cPr();
        return null;
      }
    }
    return null;
  }
  
  public final SoterSessionResult gM(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final boolean hL(Context paramContext)
  {
    setUp();
    return true;
  }
  
  public final byte[] im(long paramLong)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.core.d.c
 * JD-Core Version:    0.7.0.1
 */