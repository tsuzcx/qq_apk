package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.c.a;
import com.tencent.soter.a.f.f;
import com.tencent.soter.a.f.f.a;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.biometric.BiometricManagerCompat.CryptoObject;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.security.Signature;
import junit.framework.Assert;

public final class i
  extends d
  implements a
{
  private c BnM;
  f BnN;
  private WeakReference<Context> BnO;
  j BnR;
  boolean BnT;
  boolean BnU;
  boolean BnV;
  String Bnd;
  int Bns;
  com.tencent.soter.a.a.a Bod;
  com.tencent.soter.a.a.b Boe;
  private i.a Bof;
  private int mScene;
  String uGi;
  
  public i(b paramb)
  {
    AppMethodBeat.i(10541);
    this.mScene = -1;
    this.Bnd = null;
    this.uGi = null;
    this.BnM = null;
    this.BnN = null;
    this.BnO = null;
    this.Bod = null;
    this.Boe = null;
    this.BnR = null;
    this.Bof = null;
    if ((Build.VERSION.SDK_INT < 23) && (Build.MANUFACTURER.equalsIgnoreCase("vivo")))
    {
      bool1 = true;
      this.BnT = bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        break label135;
      }
    }
    label135:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.BnU = bool1;
      this.BnV = false;
      if (paramb != null) {
        break label140;
      }
      paramb = new IllegalArgumentException("param is null!");
      AppMethodBeat.o(10541);
      throw paramb;
      bool1 = false;
      break;
    }
    label140:
    this.mScene = paramb.mScene;
    this.BnM = paramb.Bnq;
    this.BnN = paramb.Bnr;
    this.BnO = new WeakReference(paramb.mContext);
    this.Boe = paramb.Bnu;
    this.Bod = paramb.mGm;
    this.Bns = paramb.Bns;
    this.uGi = paramb.uGi;
    AppMethodBeat.o(10541);
  }
  
  @SuppressLint({"NewApi"})
  final void b(Signature paramSignature)
  {
    String str = null;
    AppMethodBeat.i(10546);
    if (this.Bnh)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: already finished. can not authenticate", new Object[0]);
      AppMethodBeat.o(10546);
      return;
    }
    Object localObject = (Context)this.BnO.get();
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
      b(new com.tencent.soter.a.b.a(17));
      AppMethodBeat.o(10546);
      return;
    }
    try
    {
      com.tencent.soter.core.c.d.v("Soter.TaskBiometricAuthentication", "soter: performing start", new Object[0]);
      localObject = BiometricManagerCompat.from((Context)localObject, Integer.valueOf(this.Bns));
      BiometricManagerCompat.CryptoObject localCryptoObject = new BiometricManagerCompat.CryptoObject(paramSignature);
      paramSignature = str;
      if (this.Bod != null) {
        paramSignature = this.Bod.APY;
      }
      ((BiometricManagerCompat)localObject).authenticate(localCryptoObject, 0, paramSignature, this.Bof, null);
      AppMethodBeat.o(10546);
      return;
    }
    catch (Exception paramSignature)
    {
      str = paramSignature.getMessage();
      com.tencent.soter.core.c.d.e("Soter.TaskBiometricAuthentication", "soter: caused exception when authenticating: %s", new Object[] { str });
      com.tencent.soter.core.c.d.a("Soter.TaskBiometricAuthentication", paramSignature, "soter: caused exception when authenticating");
      b(new com.tencent.soter.a.b.a(20, String.format("start authentication failed due to %s", new Object[] { str })));
      AppMethodBeat.o(10546);
    }
  }
  
  public final void dVA()
  {
    AppMethodBeat.i(10548);
    com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: called from cancellation signal", new Object[0]);
    if (this.Bof != null) {
      this.Bof.onAuthenticationCancelled();
    }
    AppMethodBeat.o(10548);
  }
  
  @SuppressLint({"DefaultLocale", "NewApi"})
  final boolean dVB()
  {
    AppMethodBeat.i(10542);
    if (!com.tencent.soter.a.c.a.dVu().isInit())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: not initialized yet", new Object[0]);
      b(new com.tencent.soter.a.b.a(14));
      AppMethodBeat.o(10542);
      return true;
    }
    if (!com.tencent.soter.a.c.a.dVu().dVs())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: not support soter", new Object[0]);
      b(new com.tencent.soter.a.b.a(2));
      AppMethodBeat.o(10542);
      return true;
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.Bnd = ((String)com.tencent.soter.a.c.a.dVu().dVw().get(this.mScene, ""));
      if (!com.tencent.soter.core.c.g.isNullOrNil(this.Bnd)) {
        break;
      }
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      b(new com.tencent.soter.a.b.a(15, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(10542);
      return true;
    }
    if (!com.tencent.soter.core.a.awK(this.Bnd))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: auth key %s not exists. need re-generate", new Object[] { this.Bnd });
      b(new com.tencent.soter.a.b.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(10542);
      return true;
    }
    if ((this.BnM == null) && (com.tencent.soter.core.c.g.isNullOrNil(this.uGi)))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: challenge wrapper is null!", new Object[0]);
      b(new com.tencent.soter.a.b.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
      AppMethodBeat.o(10542);
      return true;
    }
    Context localContext = (Context)this.BnO.get();
    if (localContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: context instance released in preExecute", new Object[0]);
      b(new com.tencent.soter.a.b.a(17));
      AppMethodBeat.o(10542);
      return true;
    }
    if (!BiometricManagerCompat.from(localContext, Integer.valueOf(this.Bns)).hasEnrolledBiometric())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: user has not enrolled any biometric in system.", new Object[0]);
      b(new com.tencent.soter.a.b.a(18));
      AppMethodBeat.o(10542);
      return true;
    }
    if (com.tencent.soter.core.a.aF(localContext, this.Bns))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: biometric sensor frozen", new Object[0]);
      b(new com.tencent.soter.a.b.a(25, "Too many failed times"));
      AppMethodBeat.o(10542);
      return true;
    }
    if (this.Bod == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
      this.Bod = new com.tencent.soter.a.a.a();
      AppMethodBeat.o(10542);
      return false;
    }
    if (this.BnN == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
    }
    AppMethodBeat.o(10542);
    return false;
  }
  
  final void dVC()
  {
    AppMethodBeat.i(10543);
    if (this.Bod != null) {
      this.Bod.rV(true);
    }
    AppMethodBeat.o(10543);
  }
  
  final void dVH()
  {
    AppMethodBeat.i(10545);
    if (com.tencent.soter.core.a.dUY() == 1)
    {
      localObject = com.tencent.soter.core.a.iS(this.Bnd, this.uGi);
      if (localObject == null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
        b(new com.tencent.soter.a.b.a(13));
        AppMethodBeat.o(10545);
        return;
      }
      if (((SoterSessionResult)localObject).bpE != 0)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
        b(new com.tencent.soter.a.b.a(13));
        AppMethodBeat.o(10545);
        return;
      }
      com.tencent.soter.core.c.d.d("Soter.TaskBiometricAuthentication", "soter: session is %d", new Object[] { Long.valueOf(((SoterSessionResult)localObject).BmR) });
      this.Bof = new i.a(this, null, (byte)0);
      i.a.a(this.Bof, ((SoterSessionResult)localObject).BmR);
      b(null);
      g.dVG().d(new i.2(this));
      AppMethodBeat.o(10545);
      return;
    }
    Object localObject = com.tencent.soter.core.a.awN(this.Bnd);
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign", new Object[0]);
      b(new com.tencent.soter.a.b.a(13));
      AppMethodBeat.o(10545);
      return;
    }
    this.Bof = new i.a(this, (Signature)localObject, (byte)0);
    b((Signature)localObject);
    g.dVG().d(new i.3(this));
    AppMethodBeat.o(10545);
  }
  
  final void dVI()
  {
    AppMethodBeat.i(10547);
    if (this.BnR == null)
    {
      b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
      AppMethodBeat.o(10547);
      return;
    }
    this.BnN.bK(new f.a(this.BnR.signature, this.BnR.BmG, this.BnR.BmF));
    this.BnN.a(new i.4(this));
    this.BnN.execute();
    AppMethodBeat.o(10547);
  }
  
  final void execute()
  {
    AppMethodBeat.i(10544);
    if (com.tencent.soter.core.c.g.isNullOrNil(this.uGi))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
      this.BnM.bK(new c.a());
      this.BnM.a(new i.1(this));
      this.BnM.execute();
      AppMethodBeat.o(10544);
      return;
    }
    com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
    dVH();
    AppMethodBeat.o(10544);
  }
  
  public final boolean isCancelled()
  {
    return this.BnV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.a.g.i
 * JD-Core Version:    0.7.0.1
 */