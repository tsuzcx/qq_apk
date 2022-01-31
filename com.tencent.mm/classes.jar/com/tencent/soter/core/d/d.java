package com.tencent.soter.core.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterExportResult;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.soterserver.SoterSignResult;
import com.tencent.soter.soterserver.a;
import java.security.Signature;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class d
  extends b
  implements com.tencent.soter.core.c.b
{
  protected a BmI;
  private e BmJ;
  private f BmK;
  private IBinder.DeathRecipient BmL;
  private ServiceConnection BmM;
  private boolean connected;
  private final Object lock;
  private Context mContext;
  
  public d()
  {
    AppMethodBeat.i(73072);
    this.connected = false;
    this.lock = new Object();
    this.BmK = new f();
    this.BmL = new d.1(this);
    this.BmM = new d.2(this);
    AppMethodBeat.o(73072);
  }
  
  private void dVp()
  {
    AppMethodBeat.i(73074);
    if (!this.connected)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindServiceIfNeeded try to bind", new Object[0]);
      if (this.BmJ != null) {
        this.BmJ.cyp();
      }
      bfU();
    }
    AppMethodBeat.o(73074);
  }
  
  private boolean dVq()
  {
    AppMethodBeat.i(156551);
    if (this.BmI == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      if (this.BmJ != null) {
        this.BmJ.cyp();
      }
      AppMethodBeat.o(156551);
      return true;
    }
    AppMethodBeat.o(156551);
    return false;
  }
  
  public final void a(e parame)
  {
    this.BmJ = parame;
  }
  
  public final com.tencent.soter.core.c.f awJ(String paramString)
  {
    AppMethodBeat.i(73082);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAuthKey in", new Object[0]);
    if (!dVc())
    {
      paramString = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(73082);
      return paramString;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      paramString = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(73082);
      return paramString;
    }
    dVp();
    if (dVq())
    {
      paramString = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(73082);
      return paramString;
    }
    try
    {
      if (this.BmI.bR(Process.myUid(), paramString) == 0)
      {
        paramString = new com.tencent.soter.core.c.f(0);
        AppMethodBeat.o(73082);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString, "soter: generateAuthKey fail: ");
      paramString = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(73082);
    }
    return paramString;
  }
  
  public final boolean awK(String paramString)
  {
    AppMethodBeat.i(73086);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAuthKey in", new Object[0]);
    if (!dVc())
    {
      AppMethodBeat.o(73086);
      return false;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(73086);
      return false;
    }
    dVp();
    if (dVq())
    {
      AppMethodBeat.o(73086);
      return false;
    }
    try
    {
      boolean bool = this.BmI.bU(Process.myUid(), paramString);
      AppMethodBeat.o(73086);
      return bool;
    }
    catch (RemoteException paramString)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString, "soter: hasAuthKey fail: ");
      AppMethodBeat.o(73086);
    }
    return false;
  }
  
  public final boolean awL(String paramString)
  {
    AppMethodBeat.i(73084);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAuthKeyValid in", new Object[0]);
    if ((awK(paramString)) && (awM(paramString) != null))
    {
      AppMethodBeat.o(73084);
      return true;
    }
    AppMethodBeat.o(73084);
    return false;
  }
  
  public final i awM(String paramString)
  {
    AppMethodBeat.i(73085);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAuthKeyModel in", new Object[0]);
    if (!dVc())
    {
      AppMethodBeat.o(73085);
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(73085);
      return null;
    }
    dVp();
    if (dVq())
    {
      AppMethodBeat.o(73085);
      return null;
    }
    try
    {
      paramString = this.BmI.bT(Process.myUid(), paramString).BmP;
      if ((paramString != null) && (paramString.length > 0))
      {
        paramString = cs(paramString);
        AppMethodBeat.o(73085);
        return paramString;
      }
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: key can not be retrieved", new Object[0]);
      AppMethodBeat.o(73085);
      return null;
    }
    catch (RemoteException paramString)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString, "soter: getAuthKeyModel fail: ");
      AppMethodBeat.o(73085);
    }
    return null;
  }
  
  public final Signature awN(String paramString)
  {
    return null;
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(73075);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.soter.soterserver.ISoterService");
    localIntent.setPackage("com.tencent.soter.soterserver");
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: bindService context is null ", new Object[0]);
      AppMethodBeat.o(73075);
      return;
    }
    if (this.BmJ != null) {
      this.BmJ.cym();
    }
    this.mContext.bindService(localIntent, this.BmM, 1);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindService binding is start ", new Object[0]);
    AppMethodBeat.o(73075);
  }
  
  public final com.tencent.soter.core.c.f cu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73083);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAuthKey in", new Object[0]);
    if (!dVc())
    {
      paramString = new com.tencent.soter.core.c.f(6);
      AppMethodBeat.o(73083);
      return paramString;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      paramString = new com.tencent.soter.core.c.f(6);
      AppMethodBeat.o(73083);
      return paramString;
    }
    dVp();
    if (dVq())
    {
      paramString = new com.tencent.soter.core.c.f(6);
      AppMethodBeat.o(73083);
      return paramString;
    }
    try
    {
      if (this.BmI.bS(Process.myUid(), paramString) == 0)
      {
        if (paramBoolean)
        {
          if (this.BmI.Sm(Process.myUid()) == 0)
          {
            paramString = new com.tencent.soter.core.c.f(0);
            AppMethodBeat.o(73083);
            return paramString;
          }
          paramString = new com.tencent.soter.core.c.f(5);
          AppMethodBeat.o(73083);
          return paramString;
        }
        paramString = new com.tencent.soter.core.c.f(0);
        AppMethodBeat.o(73083);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString, "soter: removeAuthKey fail: ");
      paramString = new com.tencent.soter.core.c.f(6);
      AppMethodBeat.o(73083);
    }
    return paramString;
  }
  
  public final boolean dVa()
  {
    return this.connected;
  }
  
  public final void dVb()
  {
    AppMethodBeat.i(156550);
    bfU();
    AppMethodBeat.o(156550);
  }
  
  public final boolean dVc()
  {
    AppMethodBeat.i(73076);
    if (h.dVn())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: the device has already triggered OOM. mark as not support", new Object[0]);
      AppMethodBeat.o(73076);
      return false;
    }
    AppMethodBeat.o(73076);
    return true;
  }
  
  public final com.tencent.soter.core.c.f dVd()
  {
    AppMethodBeat.i(73077);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAppSecureKey in", new Object[0]);
    com.tencent.soter.core.c.f localf1;
    if (!dVc())
    {
      localf1 = new com.tencent.soter.core.c.f(4);
      AppMethodBeat.o(73077);
      return localf1;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      localf1 = new com.tencent.soter.core.c.f(4);
      AppMethodBeat.o(73077);
      return localf1;
    }
    dVp();
    if (dVq())
    {
      localf1 = new com.tencent.soter.core.c.f(4);
      AppMethodBeat.o(73077);
      return localf1;
    }
    try
    {
      if (this.BmI.Sj(Process.myUid()) == 0)
      {
        localf1 = new com.tencent.soter.core.c.f(0);
        AppMethodBeat.o(73077);
        return localf1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: generateAppSecureKey fail: ");
      com.tencent.soter.core.c.f localf2 = new com.tencent.soter.core.c.f(4);
      AppMethodBeat.o(73077);
      return localf2;
    }
  }
  
  public final com.tencent.soter.core.c.f dVe()
  {
    AppMethodBeat.i(73078);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAppGlobalSecureKey in", new Object[0]);
    com.tencent.soter.core.c.f localf1;
    if (!dVc())
    {
      localf1 = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(73078);
      return localf1;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      localf1 = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(73078);
      return localf1;
    }
    dVp();
    if (dVq())
    {
      localf1 = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(73078);
      return localf1;
    }
    try
    {
      if (this.BmI.Sm(Process.myUid()) == 0)
      {
        localf1 = new com.tencent.soter.core.c.f(0);
        AppMethodBeat.o(73078);
        return localf1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: removeAppGlobalSecureKey fail: ");
      com.tencent.soter.core.c.f localf2 = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(73078);
      return localf2;
    }
  }
  
  public final boolean dVf()
  {
    AppMethodBeat.i(73079);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAppGlobalSecureKey in", new Object[0]);
    if (!dVc())
    {
      AppMethodBeat.o(73079);
      return false;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(73079);
      return false;
    }
    dVp();
    if (dVq())
    {
      AppMethodBeat.o(73079);
      return false;
    }
    try
    {
      boolean bool = this.BmI.Sl(Process.myUid());
      AppMethodBeat.o(73079);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: hasAppGlobalSecureKey fail: ");
      AppMethodBeat.o(73079);
    }
    return false;
  }
  
  public final boolean dVg()
  {
    AppMethodBeat.i(73080);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAppGlobalSecureKeyValid in", new Object[0]);
    if ((dVf()) && (dVh() != null))
    {
      AppMethodBeat.o(73080);
      return true;
    }
    AppMethodBeat.o(73080);
    return false;
  }
  
  public final i dVh()
  {
    AppMethodBeat.i(73081);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAppGlobalSecureKeyModel in", new Object[0]);
    if (!dVc())
    {
      AppMethodBeat.o(73081);
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(73081);
      return null;
    }
    dVp();
    if (dVq())
    {
      AppMethodBeat.o(73081);
      return null;
    }
    try
    {
      Object localObject = this.BmI.Sk(Process.myUid()).BmP;
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = cs((byte[])localObject);
        AppMethodBeat.o(73081);
        return localObject;
      }
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: soter: key can not be retrieved", new Object[0]);
      AppMethodBeat.o(73081);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: getAppGlobalSecureKeyModel fail: ");
      AppMethodBeat.o(73081);
    }
    return null;
  }
  
  public final SoterSessionResult iS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73087);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSigh in", new Object[0]);
    if (!dVc())
    {
      AppMethodBeat.o(73087);
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(73087);
      return null;
    }
    dVp();
    if (dVq())
    {
      AppMethodBeat.o(73087);
      return null;
    }
    try
    {
      paramString1 = this.BmI.M(Process.myUid(), paramString1, paramString2);
      AppMethodBeat.o(73087);
      return paramString1;
    }
    catch (RemoteException paramString1)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString1, "soter: initSigh fail: ");
      AppMethodBeat.o(73087);
    }
    return null;
  }
  
  public final boolean jm(Context paramContext)
  {
    AppMethodBeat.i(73073);
    this.mContext = paramContext;
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter in", new Object[0]);
    paramContext = this.BmK;
    d.3 local3 = new d.3(this);
    if (paramContext.vJT == null) {
      paramContext.vJT = new CountDownLatch(1);
    }
    f.d(local3);
    if (paramContext.vJT != null) {}
    try
    {
      paramContext.vJT.await(3000L, TimeUnit.MILLISECONDS);
      if (this.connected)
      {
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter finish", new Object[0]);
        AppMethodBeat.o(73073);
        return true;
      }
    }
    catch (InterruptedException paramContext)
    {
      for (;;)
      {
        paramContext.getMessage();
      }
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: initSoter error", new Object[0]);
      AppMethodBeat.o(73073);
    }
    return false;
  }
  
  public final byte[] oY(long paramLong)
  {
    AppMethodBeat.i(73088);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: finishSign in", new Object[0]);
    if (!dVc())
    {
      AppMethodBeat.o(73088);
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(73088);
      return null;
    }
    dVp();
    if (dVq())
    {
      AppMethodBeat.o(73088);
      return null;
    }
    byte[] arrayOfByte2 = new byte[0];
    byte[] arrayOfByte1 = arrayOfByte2;
    Object localObject;
    try
    {
      SoterSignResult localSoterSignResult = this.BmI.pa(paramLong);
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = localSoterSignResult.BmP;
      arrayOfByte1 = arrayOfByte2;
      localObject = arrayOfByte2;
      if (localSoterSignResult.bpE != 0)
      {
        arrayOfByte1 = arrayOfByte2;
        localObject = new Exception("finishSign error");
        arrayOfByte1 = arrayOfByte2;
        AppMethodBeat.o(73088);
        arrayOfByte1 = arrayOfByte2;
        throw ((Throwable)localObject);
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: finishSign fail: ");
      localObject = arrayOfByte1;
      AppMethodBeat.o(73088);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.d.d
 * JD-Core Version:    0.7.0.1
 */