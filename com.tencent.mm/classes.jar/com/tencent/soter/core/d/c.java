package com.tencent.soter.core.d;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static boolean BlO = false;
  protected String BmH = "SoterKeyStore";
  
  public c(String paramString)
  {
    this.BmH = paramString;
  }
  
  @SuppressLint({"PrivateApi"})
  public static void bNv()
  {
    AppMethodBeat.i(73053);
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
      BlO = true;
      AppMethodBeat.o(73053);
    }
  }
  
  public final f awJ(String paramString)
  {
    AppMethodBeat.i(73061);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      paramString = new f(1, "no authKeyName");
      AppMethodBeat.o(73061);
      return paramString;
    }
    if (dVc()) {
      try
      {
        if (!dVf())
        {
          paramString = new f(3, "app secure key not exist");
          AppMethodBeat.o(73061);
          return paramString;
        }
        KeyStore.getInstance(this.BmH).load(null);
        KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA", this.BmH);
        try
        {
          localKeyPairGenerator.initialize(a.fe(paramString + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", new Object[] { e.dVl().Bmr }), 4).W(new String[] { "SHA-256" }).dVk().X(new String[] { "PSS" }).dVj());
          long l = System.nanoTime();
          localKeyPairGenerator.generateKeyPair();
          d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully, cost: %d ms", new Object[] { Long.valueOf(g.oZ(l)) });
          paramString = new f(0);
          AppMethodBeat.o(73061);
          return paramString;
        }
        catch (Exception paramString)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cause exception. maybe reflection exception: " + paramString.toString(), new Object[0]);
          paramString = new f(5, paramString.toString());
          AppMethodBeat.o(73061);
          return paramString;
        }
        paramString = new f(2);
      }
      catch (Exception paramString)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: generate auth key failed: " + paramString.toString(), new Object[0]);
        paramString = new f(5, paramString.toString());
        AppMethodBeat.o(73061);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when generate AuthKey!! maybe no attk inside");
        h.dVm();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(73061);
      return paramString;
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    }
  }
  
  public final boolean awK(String paramString)
  {
    AppMethodBeat.i(73063);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: authkey name not correct", new Object[0]);
      AppMethodBeat.o(73063);
      return false;
    }
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(this.BmH);
      localKeyStore.load(null);
      if (localKeyStore.getCertificate(paramString) != null)
      {
        AppMethodBeat.o(73063);
        return true;
      }
      AppMethodBeat.o(73063);
      return false;
    }
    catch (Exception paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + paramString.toString(), new Object[0]);
      AppMethodBeat.o(73063);
    }
    return false;
  }
  
  public final boolean awL(String paramString)
  {
    AppMethodBeat.i(73064);
    d.i("Soter.SoterCoreBeforeTreble", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[] { paramString, Boolean.TRUE }), new Object[0]);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: checking key valid: authkey name not correct", new Object[0]);
      AppMethodBeat.o(73064);
      return false;
    }
    try
    {
      awP(paramString);
      d.i("Soter.SoterCoreBeforeTreble", "soter: key valid", new Object[0]);
      AppMethodBeat.o(73064);
      return true;
    }
    catch (UnrecoverableEntryException localUnrecoverableEntryException)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid.", new Object[0]);
      cu(paramString, false);
      AppMethodBeat.o(73064);
      return false;
    }
    catch (Exception paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: occurs other exceptions: %s", new Object[] { paramString.toString() });
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: occurs other exceptions");
      AppMethodBeat.o(73064);
      return false;
    }
    catch (OutOfMemoryError paramString)
    {
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
      h.dVm();
      AppMethodBeat.o(73064);
      return false;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      label86:
      break label86;
    }
  }
  
  public final i awM(String paramString)
  {
    AppMethodBeat.i(73065);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      AppMethodBeat.o(73065);
      return null;
    }
    if (dVc()) {}
    for (;;)
    {
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(this.BmH);
        localKeyStore.load(null);
        try
        {
          paramString = localKeyStore.getKey(paramString, "from_soter_ui".toCharArray());
          if (paramString != null)
          {
            paramString = cs(paramString.getEncoded());
            AppMethodBeat.o(73065);
            return paramString;
          }
          d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
          AppMethodBeat.o(73065);
          return null;
        }
        catch (ClassCastException paramString)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + paramString.toString(), new Object[0]);
          AppMethodBeat.o(73065);
          return null;
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter " + this.BmH, new Object[0]);
      }
      catch (Exception paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: error in get auth key model");
        AppMethodBeat.o(73065);
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
        h.dVm();
      }
    }
  }
  
  public final Signature awN(String paramString)
  {
    AppMethodBeat.i(73066);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      AppMethodBeat.o(73066);
      return null;
    }
    if (dVc()) {}
    try
    {
      paramString = awP(paramString);
      AppMethodBeat.o(73066);
      return paramString;
    }
    catch (UnrecoverableEntryException paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid. Advice remove the key", new Object[0]);
      AppMethodBeat.o(73066);
      return null;
    }
    catch (Exception paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: exception when getSignatureResult: " + paramString.toString(), new Object[0]);
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: exception when getSignatureResult");
      AppMethodBeat.o(73066);
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
      h.dVm();
      AppMethodBeat.o(73066);
      return null;
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter" + this.BmH, new Object[0]);
      AppMethodBeat.o(73066);
      return null;
    }
    catch (InvalidKeyException paramString)
    {
      label54:
      break label54;
    }
  }
  
  public Signature awP(String paramString)
  {
    AppMethodBeat.i(73067);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      AppMethodBeat.o(73067);
      return null;
    }
    Signature localSignature = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
    KeyStore localKeyStore = KeyStore.getInstance(this.BmH);
    localKeyStore.load(null);
    paramString = (KeyStore.PrivateKeyEntry)localKeyStore.getEntry(paramString, null);
    if (paramString != null)
    {
      localSignature.initSign(paramString.getPrivateKey());
      AppMethodBeat.o(73067);
      return localSignature;
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: entry not exists", new Object[0]);
    AppMethodBeat.o(73067);
    return null;
  }
  
  public final f cu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73062);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      paramString = new f(1, "no authKeyName");
      AppMethodBeat.o(73062);
      return paramString;
    }
    d.i("Soter.SoterCoreBeforeTreble", "soter: start remove key: ".concat(String.valueOf(paramString)), new Object[0]);
    if (dVc()) {
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(this.BmH);
        localKeyStore.load(null);
        localKeyStore.deleteEntry(paramString);
        if (paramBoolean)
        {
          d.i("Soter.SoterCoreBeforeTreble", "soter: auto delete ask", new Object[0]);
          if (dVf()) {
            dVe();
          }
        }
        paramString = new f(0);
        AppMethodBeat.o(73062);
        return paramString;
      }
      catch (Exception paramString)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: removeAuthKey " + paramString.toString(), new Object[0]);
        paramString = new f(6, paramString.toString());
        AppMethodBeat.o(73062);
        return paramString;
      }
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    paramString = new f(2);
    AppMethodBeat.o(73062);
    return paramString;
  }
  
  public final boolean dVc()
  {
    AppMethodBeat.i(73055);
    if (!BlO) {
      bNv();
    }
    if (h.dVn())
    {
      d.w("Soter.SoterCoreBeforeTreble", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
      AppMethodBeat.o(73055);
      return false;
    }
    Provider[] arrayOfProvider = Security.getProviders();
    if (arrayOfProvider == null)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: no provider supported", new Object[0]);
      AppMethodBeat.o(73055);
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
        AppMethodBeat.o(73055);
        return true;
      }
      i += 1;
    }
    d.i("Soter.SoterCoreBeforeTreble", "soter: soter provider not found", new Object[0]);
    AppMethodBeat.o(73055);
    return false;
  }
  
  public f dVd()
  {
    AppMethodBeat.i(73056);
    d.i("Soter.SoterCoreBeforeTreble", "soter: start generate ask", new Object[0]);
    if (dVc()) {
      try
      {
        KeyStore.getInstance(this.BmH).load(null);
        Object localObject = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
        ((KeyPairGenerator)localObject).initialize(a.fe(e.dVl().Bmr + ".addcounter.auto_signed_when_get_pubkey_attk", 4).W(new String[] { "SHA-256" }).X(new String[] { "PSS" }).dVj());
        long l = System.nanoTime();
        ((KeyPairGenerator)localObject).generateKeyPair();
        d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully. cost: %d ms", new Object[] { Long.valueOf(g.oZ(l)) });
        localObject = new f(0);
        AppMethodBeat.o(73056);
        return localObject;
      }
      catch (Exception localException)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: generateAppGlobalSecureKey " + localException.toString(), new Object[0]);
        d.a("Soter.SoterCoreBeforeTreble", localException, "soter: generateAppGlobalSecureKey error");
        f localf1 = new f(4, localException.toString());
        AppMethodBeat.o(73056);
        return localf1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.SoterCoreBeforeTreble", localOutOfMemoryError, "soter: out of memory when generate ASK!! maybe no attk inside");
        h.dVm();
      }
    }
    for (;;)
    {
      f localf2 = new f(2);
      AppMethodBeat.o(73056);
      return localf2;
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    }
  }
  
  public final f dVe()
  {
    AppMethodBeat.i(73057);
    d.i("Soter.SoterCoreBeforeTreble", "soter: start remove app global secure key", new Object[0]);
    if (dVc()) {
      try
      {
        Object localObject = KeyStore.getInstance(this.BmH);
        ((KeyStore)localObject).load(null);
        ((KeyStore)localObject).deleteEntry(e.dVl().Bmr);
        localObject = new f(0);
        AppMethodBeat.o(73057);
        return localObject;
      }
      catch (Exception localException)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: removeAppGlobalSecureKey " + localException.toString(), new Object[0]);
        localf = new f(5, localException.toString());
        AppMethodBeat.o(73057);
        return localf;
      }
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    f localf = new f(2);
    AppMethodBeat.o(73057);
    return localf;
  }
  
  public final boolean dVf()
  {
    AppMethodBeat.i(73058);
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(this.BmH);
      localKeyStore.load(null);
      if (localKeyStore.getCertificate(e.dVl().Bmr) != null)
      {
        AppMethodBeat.o(73058);
        return true;
      }
      AppMethodBeat.o(73058);
      return false;
    }
    catch (Exception localException)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + localException.toString(), new Object[0]);
      AppMethodBeat.o(73058);
    }
    return false;
  }
  
  public final boolean dVg()
  {
    AppMethodBeat.i(73059);
    if ((dVf()) && (dVh() != null))
    {
      AppMethodBeat.o(73059);
      return true;
    }
    AppMethodBeat.o(73059);
    return false;
  }
  
  public i dVh()
  {
    AppMethodBeat.i(73060);
    d.i("Soter.SoterCoreBeforeTreble", "soter: start get app global secure key pub", new Object[0]);
    if (dVc()) {}
    for (;;)
    {
      try
      {
        Object localObject = KeyStore.getInstance(this.BmH);
        ((KeyStore)localObject).load(null);
        try
        {
          localObject = ((KeyStore)localObject).getKey(e.dVl().Bmr, "from_soter_ui".toCharArray());
          if (localObject != null)
          {
            localObject = cs(((Key)localObject).getEncoded());
            AppMethodBeat.o(73060);
            return localObject;
          }
          d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
          AppMethodBeat.o(73060);
          return null;
        }
        catch (ClassCastException localClassCastException)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + localClassCastException.toString(), new Object[0]);
          AppMethodBeat.o(73060);
          return null;
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
      }
      catch (Exception localException)
      {
        d.a("Soter.SoterCoreBeforeTreble", localException, "soter: error when get ask");
        AppMethodBeat.o(73060);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.SoterCoreBeforeTreble", localOutOfMemoryError, "soter: out of memory when getting ask!! maybe no attk inside");
        h.dVm();
      }
    }
  }
  
  public final SoterSessionResult iS(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final boolean jm(Context paramContext)
  {
    AppMethodBeat.i(73054);
    bNv();
    AppMethodBeat.o(73054);
    return true;
  }
  
  public final byte[] oY(long paramLong)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.d.c
 * JD-Core Version:    0.7.0.1
 */