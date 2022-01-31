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
import com.tencent.soter.core.a.a.d;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.security.Signature;
import junit.framework.Assert;

@Deprecated
public final class h
  extends d
  implements a
{
  private c BnM;
  f BnN;
  private WeakReference<Context> BnO;
  com.tencent.soter.a.d.a BnP;
  com.tencent.soter.a.d.b BnQ;
  j BnR;
  private h.a BnS;
  boolean BnT;
  boolean BnU;
  boolean BnV;
  String Bnd;
  private int mScene;
  String uGi;
  
  public h(b paramb)
  {
    AppMethodBeat.i(10513);
    this.mScene = -1;
    this.Bnd = null;
    this.uGi = null;
    this.BnM = null;
    this.BnN = null;
    this.BnO = null;
    this.BnP = null;
    this.BnQ = null;
    this.BnR = null;
    this.BnS = null;
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
      AppMethodBeat.o(10513);
      throw paramb;
      bool1 = false;
      break;
    }
    label140:
    this.mScene = paramb.mScene;
    this.BnM = paramb.Bnq;
    this.BnN = paramb.Bnr;
    this.BnO = new WeakReference(paramb.mContext);
    this.BnQ = paramb.Bnt;
    this.BnP = paramb.mGl;
    this.uGi = paramb.uGi;
    AppMethodBeat.o(10513);
  }
  
  @SuppressLint({"NewApi"})
  final void a(Signature paramSignature)
  {
    AppMethodBeat.i(10518);
    if (this.Bnh)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
      AppMethodBeat.o(10518);
      return;
    }
    Object localObject = (Context)this.BnO.get();
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
      b(new com.tencent.soter.a.b.a(17));
      AppMethodBeat.o(10518);
      return;
    }
    try
    {
      com.tencent.soter.core.c.d.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
      localObject = com.tencent.soter.core.a.a.jl((Context)localObject);
      a.d locald = new a.d(paramSignature);
      if (this.BnP != null) {}
      for (paramSignature = this.BnP.APY;; paramSignature = null)
      {
        ((com.tencent.soter.core.a.a)localObject).a(locald, paramSignature, this.BnS);
        AppMethodBeat.o(10518);
        return;
      }
      return;
    }
    catch (Exception paramSignature)
    {
      localObject = paramSignature.getMessage();
      com.tencent.soter.core.c.d.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", new Object[] { localObject });
      com.tencent.soter.core.c.d.a("Soter.TaskAuthentication", paramSignature, "soter: caused exception when authenticating");
      b(new com.tencent.soter.a.b.a(20, String.format("start authentication failed due to %s", new Object[] { localObject })));
      AppMethodBeat.o(10518);
    }
  }
  
  public final void dVA()
  {
    AppMethodBeat.i(10520);
    com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
    if (this.BnS != null) {
      this.BnS.onAuthenticationCancelled();
    }
    AppMethodBeat.o(10520);
  }
  
  @SuppressLint({"DefaultLocale", "NewApi"})
  final boolean dVB()
  {
    AppMethodBeat.i(10514);
    if (!com.tencent.soter.a.c.a.dVu().isInit())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
      b(new com.tencent.soter.a.b.a(14));
      AppMethodBeat.o(10514);
      return true;
    }
    if (!com.tencent.soter.a.c.a.dVu().dVs())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
      b(new com.tencent.soter.a.b.a(2));
      AppMethodBeat.o(10514);
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
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      b(new com.tencent.soter.a.b.a(15, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(10514);
      return true;
    }
    if (!com.tencent.soter.core.a.awK(this.Bnd))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", new Object[] { this.Bnd });
      b(new com.tencent.soter.a.b.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(10514);
      return true;
    }
    if ((this.BnM == null) && (com.tencent.soter.core.c.g.isNullOrNil(this.uGi)))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
      b(new com.tencent.soter.a.b.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
      AppMethodBeat.o(10514);
      return true;
    }
    Context localContext = (Context)this.BnO.get();
    if (localContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
      b(new com.tencent.soter.a.b.a(17));
      AppMethodBeat.o(10514);
      return true;
    }
    if (!com.tencent.soter.core.a.a.jl(localContext).hasEnrolledFingerprints())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
      b(new com.tencent.soter.a.b.a(18));
      AppMethodBeat.o(10514);
      return true;
    }
    if (com.tencent.soter.core.a.jk(localContext))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
      b(new com.tencent.soter.a.b.a(25, "Too many failed times"));
      AppMethodBeat.o(10514);
      return true;
    }
    if (this.BnP == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
      this.BnP = new com.tencent.soter.a.d.a();
      AppMethodBeat.o(10514);
      return false;
    }
    if (this.BnN == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
    }
    AppMethodBeat.o(10514);
    return false;
  }
  
  final void dVC()
  {
    AppMethodBeat.i(10515);
    if (this.BnP != null) {
      this.BnP.rX(true);
    }
    AppMethodBeat.o(10515);
  }
  
  final void dVH()
  {
    AppMethodBeat.i(10517);
    if (com.tencent.soter.core.a.dUY() == 1)
    {
      localObject = com.tencent.soter.core.a.iS(this.Bnd, this.uGi);
      if (localObject == null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
        b(new com.tencent.soter.a.b.a(13));
        AppMethodBeat.o(10517);
        return;
      }
      if (((SoterSessionResult)localObject).bpE != 0)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
        b(new com.tencent.soter.a.b.a(13));
        AppMethodBeat.o(10517);
        return;
      }
      com.tencent.soter.core.c.d.d("Soter.TaskAuthentication", "soter: session is %d", new Object[] { Long.valueOf(((SoterSessionResult)localObject).BmR) });
      this.BnS = new h.a(this, null, (byte)0);
      this.BnS.BmR = ((SoterSessionResult)localObject).BmR;
      a(null);
      g.dVG().d(new h.2(this));
      AppMethodBeat.o(10517);
      return;
    }
    Object localObject = com.tencent.soter.core.a.awN(this.Bnd);
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
      b(new com.tencent.soter.a.b.a(13));
      AppMethodBeat.o(10517);
      return;
    }
    this.BnS = new h.a(this, (Signature)localObject, (byte)0);
    a((Signature)localObject);
    g.dVG().d(new h.3(this));
    AppMethodBeat.o(10517);
  }
  
  final void dVI()
  {
    AppMethodBeat.i(10519);
    if (this.BnR == null)
    {
      b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
      AppMethodBeat.o(10519);
      return;
    }
    this.BnN.bK(new f.a(this.BnR.signature, this.BnR.BmG, this.BnR.BmF));
    this.BnN.a(new h.4(this));
    this.BnN.execute();
    AppMethodBeat.o(10519);
  }
  
  final void execute()
  {
    AppMethodBeat.i(10516);
    if (com.tencent.soter.core.c.g.isNullOrNil(this.uGi))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
      this.BnM.bK(new c.a());
      this.BnM.a(new h.1(this));
      this.BnM.execute();
      AppMethodBeat.o(10516);
      return;
    }
    com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
    dVH();
    AppMethodBeat.o(10516);
  }
  
  public final boolean isCancelled()
  {
    return this.BnV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.a.g.h
 * JD-Core Version:    0.7.0.1
 */