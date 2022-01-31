package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
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

public final class h
  extends d
  implements a
{
  private int fzn = -1;
  String qRa = null;
  String wPD = null;
  private c wQm = null;
  f wQn = null;
  private WeakReference<Context> wQo = null;
  com.tencent.soter.a.d.a wQp = null;
  com.tencent.soter.a.d.b wQq = null;
  j wQr = null;
  private h.a wQs = null;
  boolean wQt;
  boolean wQu;
  boolean wQv;
  
  public h(b paramb)
  {
    if ((Build.VERSION.SDK_INT < 23) && (Build.MANUFACTURER.equalsIgnoreCase("vivo")))
    {
      bool1 = true;
      this.wQt = bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        break label121;
      }
    }
    label121:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wQu = bool1;
      this.wQv = false;
      if (paramb != null) {
        break label126;
      }
      throw new IllegalArgumentException("param is null!");
      bool1 = false;
      break;
    }
    label126:
    this.fzn = paramb.fzn;
    this.wQm = paramb.wPQ;
    this.wQn = paramb.wPR;
    this.wQo = new WeakReference(paramb.mContext);
    this.wQq = paramb.wPT;
    this.wQp = paramb.klx;
    this.qRa = paramb.qRa;
  }
  
  @SuppressLint({"NewApi"})
  final void a(Signature paramSignature)
  {
    if (this.wPH)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
      return;
    }
    Object localObject = (Context)this.wQo.get();
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
      b(new com.tencent.soter.a.b.a(17));
      return;
    }
    for (;;)
    {
      try
      {
        com.tencent.soter.core.c.d.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
        localObject = com.tencent.soter.core.a.a.hK((Context)localObject);
        a.d locald = new a.d(paramSignature);
        if (this.wQp != null)
        {
          paramSignature = this.wQp.wuX;
          ((com.tencent.soter.core.a.a)localObject).a(locald, paramSignature, this.wQs);
          return;
        }
      }
      catch (Exception paramSignature)
      {
        localObject = paramSignature.getMessage();
        com.tencent.soter.core.c.d.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", new Object[] { localObject });
        com.tencent.soter.core.c.d.a("Soter.TaskAuthentication", paramSignature, "soter: caused exception when authenticating");
        b(new com.tencent.soter.a.b.a(20, String.format("start authentication failed due to %s", new Object[] { localObject })));
        return;
      }
      paramSignature = null;
    }
  }
  
  public final void cPE()
  {
    com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
    if (this.wQs != null) {
      this.wQs.onAuthenticationCancelled();
    }
  }
  
  @SuppressLint({"DefaultLocale", "NewApi"})
  final boolean cPF()
  {
    if (!com.tencent.soter.a.c.a.cPy().isInit())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
      b(new com.tencent.soter.a.b.a(14));
      return true;
    }
    if (!com.tencent.soter.a.c.a.cPy().cPw())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
      b(new com.tencent.soter.a.b.a(2));
      return true;
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.wPD = ((String)com.tencent.soter.a.c.a.cPy().cPA().get(this.fzn, ""));
      if (!com.tencent.soter.core.c.g.bl(this.wPD)) {
        break;
      }
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      b(new com.tencent.soter.a.b.a(15, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.fzn) })));
      return true;
    }
    if (!com.tencent.soter.core.a.afP(this.wPD))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", new Object[] { this.wPD });
      b(new com.tencent.soter.a.b.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[] { Integer.valueOf(this.fzn) })));
      return true;
    }
    if ((this.wQm == null) && (com.tencent.soter.core.c.g.bl(this.qRa)))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
      b(new com.tencent.soter.a.b.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
      return true;
    }
    Context localContext = (Context)this.wQo.get();
    if (localContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
      b(new com.tencent.soter.a.b.a(17));
      return true;
    }
    if (!com.tencent.soter.core.a.a.hK(localContext).hasEnrolledFingerprints())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
      b(new com.tencent.soter.a.b.a(18));
      return true;
    }
    if (com.tencent.soter.core.a.hJ(localContext))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
      b(new com.tencent.soter.a.b.a(25, "Too many failed times"));
      return true;
    }
    if (this.wQp == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
      this.wQp = new com.tencent.soter.a.d.a();
      return false;
    }
    if (this.wQn == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
    }
    return false;
  }
  
  final void cPG()
  {
    if (this.wQp != null) {
      this.wQp.ol(true);
    }
  }
  
  final void cPL()
  {
    if (com.tencent.soter.core.a.cPf() == 1)
    {
      localObject = com.tencent.soter.core.a.gM(this.wPD, this.qRa);
      if (localObject == null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
        b(new com.tencent.soter.a.b.a(13));
        return;
      }
      if (((SoterSessionResult)localObject).aYY != 0)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
        b(new com.tencent.soter.a.b.a(13));
        return;
      }
      com.tencent.soter.core.c.d.d("Soter.TaskAuthentication", "soter: session is %d", new Object[] { Long.valueOf(((SoterSessionResult)localObject).wPs) });
      this.wQs = new h.a(this, null, (byte)0);
      this.wQs.wPs = ((SoterSessionResult)localObject).wPs;
      a(null);
      g.cPK().d(new h.2(this));
      return;
    }
    Object localObject = com.tencent.soter.core.a.afS(this.wPD);
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
      b(new com.tencent.soter.a.b.a(13));
      return;
    }
    this.wQs = new h.a(this, (Signature)localObject, (byte)0);
    a((Signature)localObject);
    g.cPK().d(new h.3(this));
  }
  
  final void cPM()
  {
    if (this.wQr == null)
    {
      b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
      return;
    }
    this.wQn.bj(new f.a(this.wQr.signature, this.wQr.wPi, this.wQr.wPh));
    this.wQn.a(new h.4(this));
    this.wQn.execute();
  }
  
  final void execute()
  {
    if (com.tencent.soter.core.c.g.bl(this.qRa))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
      this.wQm.bj(new c.a());
      this.wQm.a(new h.1(this));
      this.wQm.execute();
      return;
    }
    com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
    cPL();
  }
  
  public final boolean isCancelled()
  {
    return this.wQv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.h
 * JD-Core Version:    0.7.0.1
 */