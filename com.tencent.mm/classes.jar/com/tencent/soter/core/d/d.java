package com.tencent.soter.core.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static boolean TfT;
  protected static a ZsM;
  private static boolean ZsN;
  private static f ZsO;
  private static int fAF;
  private static final Object lock;
  public static int uid;
  private e ZrN;
  private int ZsH;
  private int ZsI;
  private long ZsJ;
  private boolean ZsK;
  private Handler ZsL;
  private ServiceConnection ZsP;
  private IBinder.DeathRecipient chE;
  private Context mContext;
  private boolean uTW;
  
  static
  {
    AppMethodBeat.i(88725);
    fAF = 0;
    TfT = false;
    ZsN = false;
    lock = new Object();
    ZsO = new f();
    uid = 0;
    AppMethodBeat.o(88725);
  }
  
  public d()
  {
    AppMethodBeat.i(88703);
    this.uTW = true;
    this.ZsH = 0;
    this.ZsI = 0;
    this.ZsJ = 0L;
    this.ZsK = false;
    this.ZsL = new Handler(Looper.getMainLooper());
    this.chE = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(88696);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: binder died", new Object[0]);
        if (d.ZsM == null)
        {
          AppMethodBeat.o(88696);
          return;
        }
        d.ZsM.asBinder().unlinkToDeath(d.a(d.this), 0);
        d.ZsM = null;
        if (d.b(d.this) != null) {
          d.b(d.this).gaw();
        }
        synchronized (d.brj())
        {
          d.access$302(0);
          d.this.cZe();
          d.c(d.this);
          AppMethodBeat.o(88696);
          return;
        }
      }
    };
    this.ZsP = new ServiceConnection()
    {
      public final void onBindingDied(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(88699);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: binding died", new Object[0]);
        d.access$302(0);
        d.ZsM = null;
        d.d(d.this);
        d.this.cZe();
        d.c(d.this);
        AppMethodBeat.o(88699);
      }
      
      public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(88697);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: onServiceConnected", new Object[0]);
        synchronized (d.brj())
        {
          d.access$302(2);
          d.d(d.this);
        }
        try
        {
          paramAnonymousIBinder.linkToDeath(d.a(d.this), 0);
          d.ZsM = a.a.U(paramAnonymousIBinder);
          if (d.b(d.this) != null) {
            d.b(d.this).cZf();
          }
          com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: Binding is done - Service connected", new Object[0]);
          d.ioZ().Sz();
          AppMethodBeat.o(88697);
          return;
          paramAnonymousIBinder = finally;
          AppMethodBeat.o(88697);
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
        AppMethodBeat.i(88698);
        synchronized (d.brj())
        {
          d.access$302(0);
          d.ZsM = null;
          d.d(d.this);
          if (d.b(d.this) != null) {
            d.b(d.this).gav();
          }
          com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: unBinding is done - Service disconnected", new Object[0]);
          d.c(d.this);
          d.ioZ().Sz();
          AppMethodBeat.o(88698);
          return;
        }
      }
    };
    AppMethodBeat.o(88703);
  }
  
  private static long WR(long paramLong)
  {
    long l3 = 0L;
    long l2;
    if (paramLong < 0L) {
      l2 = -1L;
    }
    for (;;)
    {
      return l2;
      l2 = l3;
      if (paramLong != 0L)
      {
        if ((paramLong == 1L) || (paramLong == 2L)) {
          return 1L;
        }
        int i = 3;
        long l1 = 1L;
        long l4 = 1L;
        l2 = l3;
        while (i <= paramLong)
        {
          l2 = l4 + l1;
          i += 1;
          l4 = l1;
          l1 = l2;
          l3 = l2;
          l2 = l1;
          l1 = l3;
        }
      }
    }
  }
  
  private void ioX()
  {
    AppMethodBeat.i(88708);
    final long l = WR(this.ZsI + 3);
    this.ZsL.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88702);
        if ((!d.e(d.this)) || (!d.hCN()))
        {
          AppMethodBeat.o(88702);
          return;
        }
        d.f(d.this);
        if (d.fAF != 2)
        {
          com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindservice no response: %s", new Object[] { Long.valueOf(l) });
          d.this.cMw();
        }
        AppMethodBeat.o(88702);
      }
    }, l * 1000L);
    AppMethodBeat.o(88708);
  }
  
  private boolean ioY()
  {
    AppMethodBeat.i(88711);
    if (ZsM == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      if (this.ZrN != null) {
        this.ZrN.gax();
      }
      AppMethodBeat.o(88711);
      return true;
    }
    AppMethodBeat.o(88711);
    return false;
  }
  
  public static boolean isInitializing()
  {
    return TfT;
  }
  
  public final byte[] WP(long paramLong)
  {
    AppMethodBeat.i(88723);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: finishSign in", new Object[0]);
    if (!ioI())
    {
      AppMethodBeat.o(88723);
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(88723);
      return null;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      AppMethodBeat.o(88723);
      return null;
    }
    byte[] arrayOfByte2 = new byte[0];
    byte[] arrayOfByte1 = arrayOfByte2;
    Object localObject;
    try
    {
      SoterSignResult localSoterSignResult = ZsM.WS(paramLong);
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = localSoterSignResult.ZsS;
      arrayOfByte1 = arrayOfByte2;
      localObject = arrayOfByte2;
      if (localSoterSignResult.resultCode != 0)
      {
        arrayOfByte1 = arrayOfByte2;
        localObject = new Exception("finishSign error");
        arrayOfByte1 = arrayOfByte2;
        AppMethodBeat.o(88723);
        arrayOfByte1 = arrayOfByte2;
        throw ((Throwable)localObject);
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: finishSign fail: ");
      localObject = arrayOfByte1;
      AppMethodBeat.o(88723);
    }
    return localObject;
  }
  
  public final void a(e parame)
  {
    this.ZrN = parame;
  }
  
  public final com.tencent.soter.core.c.f bCZ(String paramString)
  {
    AppMethodBeat.i(88717);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAuthKey in", new Object[0]);
    if (!ioI())
    {
      paramString = new com.tencent.soter.core.c.f(6);
      AppMethodBeat.o(88717);
      return paramString;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      paramString = new com.tencent.soter.core.c.f(6);
      AppMethodBeat.o(88717);
      return paramString;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      paramString = new com.tencent.soter.core.c.f(6);
      AppMethodBeat.o(88717);
      return paramString;
    }
    try
    {
      if (ZsM.dt(uid, paramString) == 0)
      {
        paramString = new com.tencent.soter.core.c.f(0);
        AppMethodBeat.o(88717);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString, "soter: generateAuthKey fail: ");
      paramString = new com.tencent.soter.core.c.f(6);
      AppMethodBeat.o(88717);
    }
    return paramString;
  }
  
  public final boolean bDa(String paramString)
  {
    AppMethodBeat.i(88721);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAuthKey in", new Object[0]);
    if (!ioI())
    {
      AppMethodBeat.o(88721);
      return false;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(88721);
      return false;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      AppMethodBeat.o(88721);
      return false;
    }
    try
    {
      boolean bool = ZsM.dw(uid, paramString);
      AppMethodBeat.o(88721);
      return bool;
    }
    catch (RemoteException paramString)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString, "soter: hasAuthKey fail: ");
      AppMethodBeat.o(88721);
    }
    return false;
  }
  
  public final boolean bDb(String paramString)
  {
    AppMethodBeat.i(88719);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAuthKeyValid in", new Object[0]);
    if ((bDa(paramString)) && (bDc(paramString) != null))
    {
      AppMethodBeat.o(88719);
      return true;
    }
    AppMethodBeat.o(88719);
    return false;
  }
  
  public final i bDc(String paramString)
  {
    AppMethodBeat.i(88720);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAuthKeyModel in", new Object[0]);
    if (!ioI())
    {
      AppMethodBeat.o(88720);
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(88720);
      return null;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      AppMethodBeat.o(88720);
      return null;
    }
    try
    {
      paramString = ZsM.dv(uid, paramString).ZsS;
      if ((paramString != null) && (paramString.length > 0))
      {
        paramString = dw(paramString);
        AppMethodBeat.o(88720);
        return paramString;
      }
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: key can not be retrieved", new Object[0]);
      AppMethodBeat.o(88720);
      return null;
    }
    catch (RemoteException paramString)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString, "soter: getAuthKeyModel fail: ");
      AppMethodBeat.o(88720);
    }
    return null;
  }
  
  public final Signature bDd(String paramString)
  {
    return null;
  }
  
  public final void cMw()
  {
    AppMethodBeat.i(88707);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.soter.soterserver.ISoterService");
    localIntent.setPackage("com.tencent.soter.soterserver");
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: bindService context is null ", new Object[0]);
      AppMethodBeat.o(88707);
      return;
    }
    fAF = 1;
    if (this.ZrN != null) {
      this.ZrN.gau();
    }
    this.ZsJ = SystemClock.elapsedRealtime();
    this.ZsK = this.mContext.bindService(localIntent, this.ZsP, 1);
    ioX();
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindService binding is start ", new Object[0]);
    AppMethodBeat.o(88707);
  }
  
  public final void cZe()
  {
    AppMethodBeat.i(88709);
    if (this.ZsK) {
      try
      {
        this.mContext.unbindService(this.ZsP);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localException, "");
        return;
      }
      finally
      {
        this.ZsK = false;
        AppMethodBeat.o(88709);
      }
    }
    AppMethodBeat.o(88709);
  }
  
  public final com.tencent.soter.core.c.f dQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(88718);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAuthKey in", new Object[0]);
    if (!ioI())
    {
      paramString = new com.tencent.soter.core.c.f(7);
      AppMethodBeat.o(88718);
      return paramString;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      paramString = new com.tencent.soter.core.c.f(7);
      AppMethodBeat.o(88718);
      return paramString;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      paramString = new com.tencent.soter.core.c.f(7);
      AppMethodBeat.o(88718);
      return paramString;
    }
    try
    {
      if (ZsM.du(uid, paramString) == 0)
      {
        if (paramBoolean)
        {
          if (ZsM.aAw(uid) == 0)
          {
            paramString = new com.tencent.soter.core.c.f(0);
            AppMethodBeat.o(88718);
            return paramString;
          }
          paramString = new com.tencent.soter.core.c.f(5);
          AppMethodBeat.o(88718);
          return paramString;
        }
        paramString = new com.tencent.soter.core.c.f(0);
        AppMethodBeat.o(88718);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString, "soter: removeAuthKey fail: ");
      paramString = new com.tencent.soter.core.c.f(7);
      AppMethodBeat.o(88718);
    }
    return paramString;
  }
  
  public final boolean ioG()
  {
    return fAF == 2;
  }
  
  public final void ioH()
  {
    AppMethodBeat.i(88705);
    this.ZsH = 0;
    ioW();
    AppMethodBeat.o(88705);
  }
  
  public final boolean ioI()
  {
    AppMethodBeat.i(88710);
    if (h.ioU())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: the device has already triggered OOM. mark as not support", new Object[0]);
      AppMethodBeat.o(88710);
      return false;
    }
    AppMethodBeat.o(88710);
    return true;
  }
  
  public final com.tencent.soter.core.c.f ioJ()
  {
    AppMethodBeat.i(88712);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAppSecureKey in", new Object[0]);
    com.tencent.soter.core.c.f localf1;
    if (!ioI())
    {
      localf1 = new com.tencent.soter.core.c.f(4);
      AppMethodBeat.o(88712);
      return localf1;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      localf1 = new com.tencent.soter.core.c.f(4);
      AppMethodBeat.o(88712);
      return localf1;
    }
    ioW();
    if (ioY())
    {
      localf1 = new com.tencent.soter.core.c.f(4);
      AppMethodBeat.o(88712);
      return localf1;
    }
    try
    {
      if (ZsM.aAt(uid) == 0)
      {
        localf1 = new com.tencent.soter.core.c.f(0);
        AppMethodBeat.o(88712);
        return localf1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: generateAppSecureKey fail: ");
      com.tencent.soter.core.c.f localf2 = new com.tencent.soter.core.c.f(4);
      AppMethodBeat.o(88712);
      return localf2;
    }
  }
  
  public final com.tencent.soter.core.c.f ioK()
  {
    AppMethodBeat.i(88713);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAppGlobalSecureKey in", new Object[0]);
    com.tencent.soter.core.c.f localf1;
    if (!ioI())
    {
      localf1 = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(88713);
      return localf1;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      localf1 = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(88713);
      return localf1;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      localf1 = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(88713);
      return localf1;
    }
    try
    {
      if (ZsM.aAw(uid) == 0)
      {
        localf1 = new com.tencent.soter.core.c.f(0);
        AppMethodBeat.o(88713);
        return localf1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: removeAppGlobalSecureKey fail: ");
      com.tencent.soter.core.c.f localf2 = new com.tencent.soter.core.c.f(5);
      AppMethodBeat.o(88713);
      return localf2;
    }
  }
  
  public final boolean ioL()
  {
    AppMethodBeat.i(88714);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAppGlobalSecureKey in", new Object[0]);
    if (!ioI())
    {
      AppMethodBeat.o(88714);
      return false;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(88714);
      return false;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      AppMethodBeat.o(88714);
      return false;
    }
    try
    {
      boolean bool = ZsM.aAv(uid);
      AppMethodBeat.o(88714);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: hasAppGlobalSecureKey fail: ");
      AppMethodBeat.o(88714);
    }
    return false;
  }
  
  public final boolean ioM()
  {
    AppMethodBeat.i(88715);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAppGlobalSecureKeyValid in", new Object[0]);
    if ((ioL()) && (ioN() != null))
    {
      AppMethodBeat.o(88715);
      return true;
    }
    AppMethodBeat.o(88715);
    return false;
  }
  
  public final i ioN()
  {
    AppMethodBeat.i(88716);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAppGlobalSecureKeyModel in", new Object[0]);
    if (!ioI())
    {
      AppMethodBeat.o(88716);
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(88716);
      return null;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      AppMethodBeat.o(88716);
      return null;
    }
    try
    {
      Object localObject = ZsM.aAu(uid).ZsS;
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = dw((byte[])localObject);
        AppMethodBeat.o(88716);
        return localObject;
      }
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: soter: key can not be retrieved", new Object[0]);
      AppMethodBeat.o(88716);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", localRemoteException, "soter: getAppGlobalSecureKeyModel fail: ");
      AppMethodBeat.o(88716);
    }
    return null;
  }
  
  public final void ioW()
  {
    AppMethodBeat.i(88706);
    if ((fAF != 2) || (ZsM == null) || (!ZsM.asBinder().isBinderAlive()) || (!ZsM.asBinder().pingBinder()))
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindServiceIfNeeded try to bind", new Object[0]);
      cMw();
      AppMethodBeat.o(88706);
      return;
    }
    com.tencent.soter.core.c.d.d("Soter.SoterCoreTreble", "no need rebind", new Object[0]);
    AppMethodBeat.o(88706);
  }
  
  public final boolean me(Context paramContext)
  {
    AppMethodBeat.i(88704);
    this.mContext = paramContext;
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter in", new Object[0]);
    TfT = true;
    paramContext = ZsO;
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88701);
        d.this.ioW();
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter binding", new Object[0]);
        AppMethodBeat.o(88701);
      }
    };
    com.tencent.soter.core.c.d.i("Soter.SyncJob", "doAsSyncJob", new Object[0]);
    paramContext.QSv = new CountDownLatch(1);
    local4.run();
    if (paramContext.QSv != null) {}
    try
    {
      paramContext.QSv.await(3000L, TimeUnit.MILLISECONDS);
      TfT = false;
      if (fAF == 2)
      {
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter finish", new Object[0]);
        ZsN = true;
        AppMethodBeat.o(88704);
        return true;
      }
    }
    catch (InterruptedException paramContext)
    {
      for (;;)
      {
        com.tencent.soter.core.c.d.a("Soter.SyncJob", paramContext, "");
      }
      fAF = 0;
      com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: initSoter error", new Object[0]);
      AppMethodBeat.o(88704);
    }
    return false;
  }
  
  public final SoterSessionResult oE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88722);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSigh in", new Object[0]);
    if (!ioI())
    {
      AppMethodBeat.o(88722);
      return null;
    }
    if (this.mContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
      AppMethodBeat.o(88722);
      return null;
    }
    ioW();
    if (ioY())
    {
      com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
      AppMethodBeat.o(88722);
      return null;
    }
    try
    {
      paramString1 = ZsM.af(uid, paramString1, paramString2);
      AppMethodBeat.o(88722);
      return paramString1;
    }
    catch (RemoteException paramString1)
    {
      com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", paramString1, "soter: initSigh fail: ");
      AppMethodBeat.o(88722);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.core.d.d
 * JD-Core Version:    0.7.0.1
 */