package com.tencent.soter.core.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterExportResult;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.soterserver.SoterSignResult;
import com.tencent.soter.soterserver.a;
import com.tencent.soter.soterserver.a.a;
import java.security.Signature;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class d
  extends b
  implements com.tencent.soter.core.c.b
{
  private boolean connected = false;
  private final Object lock = new Object();
  private Context mContext;
  protected a wPk;
  private e wPl = new e();
  private IBinder.DeathRecipient wPm = new d.1(this);
  private ServiceConnection wPn = new ServiceConnection()
  {
    public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: onServiceConnected", new Object[0]);
      synchronized (d.b(d.this))
      {
        d.a(d.this, true);
        d.b(d.this).notifyAll();
      }
      try
      {
        paramAnonymousIBinder.linkToDeath(d.a(d.this), 0);
        d.this.wPk = a.a.N(paramAnonymousIBinder);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: Binding is done - Service connected", new Object[0]);
        d.c(d.this).countDown();
        return;
        paramAnonymousIBinder = finally;
        throw paramAnonymousIBinder;
      }
      catch (RemoteException ???)
      {
        for (;;)
        {
          com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: Binding deathRecipient is error - RemoteException" + ???.toString(), new Object[0]);
        }
      }
    }
    
    public final void onServiceDisconnected(ComponentName arg1)
    {
      synchronized (d.b(d.this))
      {
        d.a(d.this, false);
        d.b(d.this).notifyAll();
        d.this.wPk = null;
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: unBinding is done - Service disconnected", new Object[0]);
        d.c(d.this).countDown();
        d.this.aDx();
        return;
      }
    }
  };
  
  public final void aDx()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.soter.soterserver.ISoterService");
    localIntent.setPackage("com.tencent.soter.soterserver");
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: bindService context is null ", new Object[0]);
      return;
    }
    this.mContext.bindService(localIntent, this.wPn, 1);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindService binding is start ", new Object[0]);
  }
  
  public final f afO(String paramString)
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAuthKey in", new Object[0]);
    if (!cPh()) {
      return new f(5);
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return new f(5);
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return new f(5);
    }
    int i = Process.myUid();
    try
    {
      if (this.wPk.bl(i, paramString) == 0)
      {
        paramString = new f(0);
        return paramString;
      }
    }
    catch (RemoteException paramString) {}
    return new f(5);
  }
  
  public final boolean afP(String paramString)
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAuthKey in", new Object[0]);
    int i = Process.myUid();
    if (!cPh()) {
      return false;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return false;
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return false;
    }
    try
    {
      boolean bool = this.wPk.bo(i, paramString);
      return bool;
    }
    catch (RemoteException paramString) {}
    return false;
  }
  
  public final boolean afQ(String paramString)
  {
    boolean bool2 = false;
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAuthKeyValid in", new Object[0]);
    boolean bool1 = bool2;
    if (afP(paramString))
    {
      bool1 = bool2;
      if (afR(paramString) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final i afR(String paramString)
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAuthKeyModel in", new Object[0]);
    if (!cPh()) {
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return null;
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return null;
    }
    int i = Process.myUid();
    try
    {
      paramString = this.wPk.bn(i, paramString).wPq;
      if ((paramString != null) && (paramString.length > 0)) {
        return bS(paramString);
      }
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: key can not be retrieved", new Object[0]);
      return null;
    }
    catch (RemoteException paramString) {}
    return null;
  }
  
  public final Signature afS(String paramString)
  {
    return null;
  }
  
  public final f bR(String paramString, boolean paramBoolean)
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAuthKey in", new Object[0]);
    if (!cPh()) {
      return new f(6);
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return new f(6);
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return new f(6);
    }
    int i = Process.myUid();
    try
    {
      if (this.wPk.bm(i, paramString) == 0)
      {
        paramString = new f(0);
        return paramString;
      }
    }
    catch (RemoteException paramString) {}
    return new f(6);
  }
  
  public final boolean cPh()
  {
    if (h.cPs())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: the device has already triggered OOM. mark as not support", new Object[0]);
      return false;
    }
    return true;
  }
  
  public final f cPi()
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAppSecureKey in", new Object[0]);
    if (!cPh()) {
      return new f(4);
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return new f(4);
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return new f(4);
    }
    int i = Process.myUid();
    try
    {
      if (this.wPk.Jn(i) == 0)
      {
        f localf = new f(0);
        return localf;
      }
    }
    catch (RemoteException localRemoteException) {}
    return new f(4);
  }
  
  public final f cPj()
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAppGlobalSecureKey in", new Object[0]);
    if (!cPh()) {
      return new f(5);
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return new f(5);
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return new f(5);
    }
    int i = Process.myUid();
    try
    {
      if (this.wPk.Jq(i) == 0)
      {
        f localf = new f(0);
        return localf;
      }
    }
    catch (RemoteException localRemoteException) {}
    return new f(5);
  }
  
  public final boolean cPk()
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAppGlobalSecureKey in", new Object[0]);
    if (!cPh()) {
      return false;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return false;
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return false;
    }
    int i = Process.myUid();
    try
    {
      boolean bool = this.wPk.Jp(i);
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
  
  public final boolean cPl()
  {
    boolean bool2 = false;
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAppGlobalSecureKeyValid in", new Object[0]);
    boolean bool1 = bool2;
    if (cPk())
    {
      bool1 = bool2;
      if (cPm() != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final i cPm()
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAppGlobalSecureKeyModel in", new Object[0]);
    if (!cPh()) {
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return null;
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return null;
    }
    int i = Process.myUid();
    try
    {
      byte[] arrayOfByte = this.wPk.Jo(i).wPq;
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        return bS(arrayOfByte);
      }
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: soter: key can not be retrieved", new Object[0]);
      return null;
    }
    catch (RemoteException localRemoteException) {}
    return null;
  }
  
  public final void cPu()
  {
    if (!this.connected)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindServiceIfNeeded try to bind", new Object[0]);
      aDx();
    }
  }
  
  public final SoterSessionResult gM(String paramString1, String paramString2)
  {
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSigh in", new Object[0]);
    if (!cPh()) {
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      return null;
    }
    cPu();
    if (this.wPk == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      return null;
    }
    int i = Process.myUid();
    try
    {
      paramString1 = this.wPk.E(i, paramString1, paramString2);
      return paramString1;
    }
    catch (RemoteException paramString1) {}
    return null;
  }
  
  public final boolean hL(Context paramContext)
  {
    this.mContext = paramContext;
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter in", new Object[0]);
    paramContext = this.wPl;
    d.3 local3 = new d.3(this);
    if (paramContext.rSV == null) {
      paramContext.rSV = new CountDownLatch(1);
    }
    e.d(local3);
    if (paramContext.rSV != null) {}
    try
    {
      paramContext.rSV.await(3000L, TimeUnit.MILLISECONDS);
      if (this.connected)
      {
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter finish", new Object[0]);
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
    }
    return false;
  }
  
  public final byte[] im(long paramLong)
  {
    Object localObject2 = null;
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: finishSign in", new Object[0]);
    if (!cPh()) {}
    Object localObject1;
    for (;;)
    {
      return localObject2;
      if (this.mContext == null)
      {
        com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
        return null;
      }
      cPu();
      if (this.wPk == null)
      {
        com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
        return null;
      }
      localObject2 = new byte[0];
      localObject1 = localObject2;
      try
      {
        SoterSignResult localSoterSignResult = this.wPk.io(paramLong);
        localObject1 = localObject2;
        byte[] arrayOfByte = localSoterSignResult.wPq;
        localObject2 = arrayOfByte;
        localObject1 = arrayOfByte;
        if (localSoterSignResult.aYY != 0)
        {
          localObject1 = arrayOfByte;
          throw new Exception("finishSign error");
        }
      }
      catch (RemoteException localRemoteException) {}
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.d.d
 * JD-Core Version:    0.7.0.1
 */