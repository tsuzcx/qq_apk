package com.tencent.soter.core.d;

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
  private static boolean ahxt = false;
  protected String ahxu = "SoterKeyStore";
  
  public c(String paramString)
  {
    this.ahxu = paramString;
  }
  
  public static void fXr()
  {
    AppMethodBeat.i(88681);
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
      ahxt = true;
      AppMethodBeat.o(88681);
    }
  }
  
  public final byte[] Bc(long paramLong)
  {
    return new byte[0];
  }
  
  public final f bFE(String paramString)
  {
    AppMethodBeat.i(88689);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      paramString = new f(1, "no authKeyName");
      AppMethodBeat.o(88689);
      return paramString;
    }
    if (jXV()) {
      try
      {
        if (!jXY())
        {
          paramString = new f(3, "app secure key not exist");
          AppMethodBeat.o(88689);
          return paramString;
        }
        KeyStore.getInstance(this.ahxu).load(null);
        KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA", this.ahxu);
        try
        {
          localKeyPairGenerator.initialize(a.js(paramString + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", new Object[] { e.jYf().ahxe }), 4).ae(new String[] { "SHA-256" }).jYe().af(new String[] { "PSS" }).jYd());
          long l = System.nanoTime();
          localKeyPairGenerator.generateKeyPair();
          d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully, cost: %d ms", new Object[] { Long.valueOf(g.Bd(l)) });
          h.reset();
          paramString = new f(0);
          AppMethodBeat.o(88689);
          return paramString;
        }
        catch (Exception paramString)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cause exception. maybe reflection exception: " + paramString.toString(), new Object[0]);
          paramString = new f(6, paramString.toString());
          AppMethodBeat.o(88689);
          return paramString;
        }
        paramString = new f(2);
      }
      catch (Exception paramString)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: generate auth key failed: " + paramString.toString(), new Object[0]);
        paramString = new f(6, paramString.toString());
        AppMethodBeat.o(88689);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when generate AuthKey!! maybe no attk inside");
        h.jYg();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(88689);
      return paramString;
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    }
  }
  
  public final boolean bFF(String paramString)
  {
    AppMethodBeat.i(88691);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: authkey name not correct", new Object[0]);
      AppMethodBeat.o(88691);
      return false;
    }
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(this.ahxu);
      localKeyStore.load(null);
      if (localKeyStore.getCertificate(paramString) != null)
      {
        AppMethodBeat.o(88691);
        return true;
      }
      AppMethodBeat.o(88691);
      return false;
    }
    catch (Exception paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + paramString.toString(), new Object[0]);
      AppMethodBeat.o(88691);
    }
    return false;
  }
  
  public final boolean bFG(String paramString)
  {
    AppMethodBeat.i(88692);
    d.i("Soter.SoterCoreBeforeTreble", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[] { paramString, Boolean.TRUE }), new Object[0]);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: checking key valid: authkey name not correct", new Object[0]);
      AppMethodBeat.o(88692);
      return false;
    }
    try
    {
      bFK(paramString);
      d.i("Soter.SoterCoreBeforeTreble", "soter: key valid", new Object[0]);
      h.reset();
      AppMethodBeat.o(88692);
      return true;
    }
    catch (UnrecoverableEntryException localUnrecoverableEntryException)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid.", new Object[0]);
      eF(paramString, false);
      AppMethodBeat.o(88692);
      return false;
    }
    catch (Exception paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: occurs other exceptions: %s", new Object[] { paramString.toString() });
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: occurs other exceptions");
      AppMethodBeat.o(88692);
      return false;
    }
    catch (OutOfMemoryError paramString)
    {
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
      h.jYg();
      AppMethodBeat.o(88692);
      return false;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      label92:
      break label92;
    }
  }
  
  public final i bFH(String paramString)
  {
    AppMethodBeat.i(88693);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      AppMethodBeat.o(88693);
      return null;
    }
    if (jXV()) {}
    for (;;)
    {
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(this.ahxu);
        localKeyStore.load(null);
        try
        {
          paramString = localKeyStore.getKey(paramString, "from_soter_ui".toCharArray());
          h.reset();
          if (paramString != null)
          {
            paramString = dy(paramString.getEncoded());
            AppMethodBeat.o(88693);
            return paramString;
          }
          d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
          AppMethodBeat.o(88693);
          return null;
        }
        catch (ClassCastException paramString)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + paramString.toString(), new Object[0]);
          AppMethodBeat.o(88693);
          return null;
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter " + this.ahxu, new Object[0]);
      }
      catch (Exception paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: error in get auth key model");
        AppMethodBeat.o(88693);
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
        h.jYg();
      }
    }
  }
  
  public final Signature bFI(String paramString)
  {
    AppMethodBeat.i(88694);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      AppMethodBeat.o(88694);
      return null;
    }
    if (jXV()) {}
    try
    {
      h.reset();
      paramString = bFK(paramString);
      AppMethodBeat.o(88694);
      return paramString;
    }
    catch (UnrecoverableEntryException paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid. Advice remove the key", new Object[0]);
      AppMethodBeat.o(88694);
      return null;
    }
    catch (Exception paramString)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: exception when getSignatureResult: " + paramString.toString(), new Object[0]);
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: exception when getSignatureResult");
      AppMethodBeat.o(88694);
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      d.a("Soter.SoterCoreBeforeTreble", paramString, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
      h.jYg();
      AppMethodBeat.o(88694);
      return null;
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter" + this.ahxu, new Object[0]);
      AppMethodBeat.o(88694);
      return null;
    }
    catch (InvalidKeyException paramString)
    {
      label57:
      break label57;
    }
  }
  
  public Signature bFK(String paramString)
  {
    AppMethodBeat.i(88695);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      AppMethodBeat.o(88695);
      return null;
    }
    Signature localSignature = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
    KeyStore localKeyStore = KeyStore.getInstance(this.ahxu);
    localKeyStore.load(null);
    paramString = (KeyStore.PrivateKeyEntry)localKeyStore.getEntry(paramString, null);
    if (paramString != null)
    {
      localSignature.initSign(paramString.getPrivateKey());
      AppMethodBeat.o(88695);
      return localSignature;
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: entry not exists", new Object[0]);
    AppMethodBeat.o(88695);
    return null;
  }
  
  public final f eF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(88690);
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
      paramString = new f(1, "no authKeyName");
      AppMethodBeat.o(88690);
      return paramString;
    }
    d.i("Soter.SoterCoreBeforeTreble", "soter: start remove key: ".concat(String.valueOf(paramString)), new Object[0]);
    if (jXV()) {
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(this.ahxu);
        localKeyStore.load(null);
        localKeyStore.deleteEntry(paramString);
        if (paramBoolean)
        {
          d.i("Soter.SoterCoreBeforeTreble", "soter: auto delete ask", new Object[0]);
          if (jXY()) {
            jXX();
          }
        }
        paramString = new f(0);
        AppMethodBeat.o(88690);
        return paramString;
      }
      catch (Exception paramString)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: removeAuthKey " + paramString.toString(), new Object[0]);
        paramString = new f(7, paramString.toString());
        AppMethodBeat.o(88690);
        return paramString;
      }
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    paramString = new f(2);
    AppMethodBeat.o(88690);
    return paramString;
  }
  
  public final boolean jXV()
  {
    AppMethodBeat.i(88683);
    if (!ahxt) {
      fXr();
    }
    if (h.jYh())
    {
      d.w("Soter.SoterCoreBeforeTreble", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
      AppMethodBeat.o(88683);
      return false;
    }
    Provider[] arrayOfProvider = Security.getProviders();
    if (arrayOfProvider == null)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: no provider supported", new Object[0]);
      AppMethodBeat.o(88683);
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
        AppMethodBeat.o(88683);
        return true;
      }
      i += 1;
    }
    d.i("Soter.SoterCoreBeforeTreble", "soter: soter provider not found", new Object[0]);
    AppMethodBeat.o(88683);
    return false;
  }
  
  public f jXW()
  {
    AppMethodBeat.i(88684);
    d.i("Soter.SoterCoreBeforeTreble", "soter: start generate ask", new Object[0]);
    if (jXV()) {
      try
      {
        KeyStore.getInstance(this.ahxu).load(null);
        Object localObject = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
        ((KeyPairGenerator)localObject).initialize(a.js(e.jYf().ahxe + ".addcounter.auto_signed_when_get_pubkey_attk", 4).ae(new String[] { "SHA-256" }).af(new String[] { "PSS" }).jYd());
        long l = System.nanoTime();
        ((KeyPairGenerator)localObject).generateKeyPair();
        d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully. cost: %d ms", new Object[] { Long.valueOf(g.Bd(l)) });
        h.reset();
        localObject = new f(0);
        AppMethodBeat.o(88684);
        return localObject;
      }
      catch (Exception localException)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: generateAppGlobalSecureKey " + localException.toString(), new Object[0]);
        d.a("Soter.SoterCoreBeforeTreble", localException, "soter: generateAppGlobalSecureKey error");
        f localf1 = new f(4, localException.toString());
        AppMethodBeat.o(88684);
        return localf1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.SoterCoreBeforeTreble", localOutOfMemoryError, "soter: out of memory when generate ASK!! maybe no attk inside");
        h.jYg();
      }
    }
    for (;;)
    {
      f localf2 = new f(2);
      AppMethodBeat.o(88684);
      return localf2;
      d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    }
  }
  
  public final f jXX()
  {
    AppMethodBeat.i(88685);
    d.i("Soter.SoterCoreBeforeTreble", "soter: start remove app global secure key", new Object[0]);
    if (jXV()) {
      try
      {
        Object localObject = KeyStore.getInstance(this.ahxu);
        ((KeyStore)localObject).load(null);
        ((KeyStore)localObject).deleteEntry(e.jYf().ahxe);
        localObject = new f(0);
        AppMethodBeat.o(88685);
        return localObject;
      }
      catch (Exception localException)
      {
        d.e("Soter.SoterCoreBeforeTreble", "soter: removeAppGlobalSecureKey " + localException.toString(), new Object[0]);
        localf = new f(5, localException.toString());
        AppMethodBeat.o(88685);
        return localf;
      }
    }
    d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
    f localf = new f(2);
    AppMethodBeat.o(88685);
    return localf;
  }
  
  public final boolean jXY()
  {
    AppMethodBeat.i(88686);
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(this.ahxu);
      localKeyStore.load(null);
      if (localKeyStore.getCertificate(e.jYf().ahxe) != null)
      {
        AppMethodBeat.o(88686);
        return true;
      }
      AppMethodBeat.o(88686);
      return false;
    }
    catch (Exception localException)
    {
      d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + localException.toString(), new Object[0]);
      AppMethodBeat.o(88686);
    }
    return false;
  }
  
  public final boolean jXZ()
  {
    AppMethodBeat.i(88687);
    if ((jXY()) && (jYa() != null))
    {
      AppMethodBeat.o(88687);
      return true;
    }
    AppMethodBeat.o(88687);
    return false;
  }
  
  public i jYa()
  {
    AppMethodBeat.i(88688);
    d.i("Soter.SoterCoreBeforeTreble", "soter: start get app global secure key pub", new Object[0]);
    if (jXV()) {}
    for (;;)
    {
      try
      {
        Object localObject = KeyStore.getInstance(this.ahxu);
        ((KeyStore)localObject).load(null);
        try
        {
          localObject = ((KeyStore)localObject).getKey(e.jYf().ahxe, "from_soter_ui".toCharArray());
          if (localObject != null)
          {
            h.reset();
            localObject = dy(((Key)localObject).getEncoded());
            AppMethodBeat.o(88688);
            return localObject;
          }
          d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
          AppMethodBeat.o(88688);
          return null;
        }
        catch (ClassCastException localClassCastException)
        {
          d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + localClassCastException.toString(), new Object[0]);
          AppMethodBeat.o(88688);
          return null;
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
      }
      catch (Exception localException)
      {
        d.a("Soter.SoterCoreBeforeTreble", localException, "soter: error when get ask");
        AppMethodBeat.o(88688);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        d.a("Soter.SoterCoreBeforeTreble", localOutOfMemoryError, "soter: out of memory when getting ask!! maybe no attk inside");
        h.jYg();
      }
    }
  }
  
  public final boolean or(Context paramContext)
  {
    AppMethodBeat.i(88682);
    fXr();
    AppMethodBeat.o(88682);
    return true;
  }
  
  public final SoterSessionResult qC(String paramString1, String paramString2)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.core.d.c
 * JD-Core Version:    0.7.0.1
 */