package com.tencent.mm.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static ConcurrentHashMap<String, b> ytN;
  private static Vector<Intent> ytO;
  private static Vector<Intent> ytP;
  private static ConcurrentHashMap<Integer, String> ytQ;
  private static ConcurrentHashMap<Integer, IBinder> ytR;
  private static ConcurrentHashMap<Integer, IBinder.DeathRecipient> ytS;
  
  static
  {
    AppMethodBeat.i(115294);
    ytN = new ConcurrentHashMap();
    ytO = new Vector();
    ytP = new Vector();
    ytQ = new ConcurrentHashMap();
    ytR = new ConcurrentHashMap();
    ytS = new ConcurrentHashMap();
    AppMethodBeat.o(115294);
  }
  
  public static void a(final Intent paramIntent1, final String paramString, final boolean paramBoolean, final Intent paramIntent2)
  {
    AppMethodBeat.i(115287);
    for (;;)
    {
      if (paramIntent1 == null)
      {
        ab.i("MicroMsg.MMServiceHelper", "startService Intent == null");
        AppMethodBeat.o(115287);
        return;
      }
      String str = paramIntent1.getComponent().getClassName();
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = null processName = %s", new Object[] { paramString });
        AppMethodBeat.o(115287);
        return;
      }
      ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
      e.qrI.idkeyStat(963L, 0L, 1L, false);
      paramIntent1.putExtra("class_name", str);
      Object localObject = (b)ytN.get(paramString);
      if (localObject == null)
      {
        e.qrI.idkeyStat(963L, 1L, 1L, false);
        ytO.add(paramIntent1);
        localObject = ah.getContext();
        h((Context)localObject, paramString, paramIntent2);
        try
        {
          ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
          {
            public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
            {
              AppMethodBeat.i(115273);
              ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.ytT, paramString });
              e.qrI.idkeyStat(963L, 2L, 1L, false);
              if (paramAnonymousIBinder == null)
              {
                ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.ytT, paramString });
                AppMethodBeat.o(115273);
                return;
              }
              if (!c.aBO().contains(paramIntent1))
              {
                AppMethodBeat.o(115273);
                return;
              }
              try
              {
                paramAnonymousComponentName = b.a.M(paramAnonymousIBinder);
                paramAnonymousComponentName.aG(paramIntent1);
                c.duT().put(paramString, paramAnonymousComponentName);
                return;
              }
              catch (Exception paramAnonymousComponentName)
              {
                e.qrI.idkeyStat(963L, 3L, 1L, false);
                ab.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { this.ytT, paramString, paramAnonymousComponentName.getMessage(), bo.dtY() });
                if (paramBoolean)
                {
                  e.qrI.idkeyStat(963L, 5L, 1L, false);
                  c.a(paramIntent1, paramString, false, paramIntent2);
                }
                return;
              }
              finally
              {
                c.aBO().remove(paramIntent1);
                AppMethodBeat.o(115273);
              }
            }
            
            public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
            {
              AppMethodBeat.i(115274);
              ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.ytT, paramString });
              e.qrI.idkeyStat(963L, 4L, 1L, false);
              c.duT().remove(paramString);
              AppMethodBeat.o(115274);
            }
          }, 1)) });
          AppMethodBeat.o(115287);
          return;
        }
        catch (Exception paramIntent1)
        {
          ab.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
          AppMethodBeat.o(115287);
          return;
        }
      }
      e.qrI.idkeyStat(963L, 6L, 1L, false);
      try
      {
        ab.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, startService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        ((b)localObject).aG(paramIntent1);
        AppMethodBeat.o(115287);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bo.dtY() });
        ytN.remove(paramString);
        if (paramBoolean)
        {
          e.qrI.idkeyStat(963L, 5L, 1L, false);
          paramBoolean = false;
        }
        else
        {
          AppMethodBeat.o(115287);
        }
      }
    }
  }
  
  public static void a(final ServiceConnection paramServiceConnection, final String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(115290);
    for (;;)
    {
      if (paramServiceConnection == null)
      {
        ab.i("MicroMsg.MMServiceHelper", "unbindService ServiceConnection == null");
        AppMethodBeat.o(115290);
        return;
      }
      String str = (String)ytQ.remove(Integer.valueOf(paramServiceConnection.hashCode()));
      Object localObject1 = (IBinder)ytR.remove(Integer.valueOf(paramServiceConnection.hashCode()));
      Object localObject2 = (IBinder.DeathRecipient)ytS.remove(Integer.valueOf(paramServiceConnection.hashCode()));
      if (localObject1 != null) {
        ((IBinder)localObject1).unlinkToDeath((IBinder.DeathRecipient)localObject2, 0);
      }
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.MMServiceHelper", "unbindService() processName = %s", new Object[] { paramString });
        AppMethodBeat.o(115290);
        return;
      }
      ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s processName = %s", new Object[] { str, paramString });
      e.qrI.idkeyStat(963L, 46L, 1L, false);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("class_name", str);
      ((Intent)localObject1).putExtra("service_connection", paramServiceConnection.hashCode());
      localObject2 = (b)ytN.get(paramString);
      if (localObject2 == null)
      {
        e.qrI.idkeyStat(963L, 47L, 1L, false);
        localObject2 = ah.getContext();
        h((Context)localObject2, paramString, paramIntent);
        try
        {
          ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject2).bindService(paramIntent, new ServiceConnection()
          {
            public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
            {
              AppMethodBeat.i(115283);
              ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.yuc, paramString });
              e.qrI.idkeyStat(963L, 48L, 1L, false);
              if (paramAnonymousIBinder == null)
              {
                ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.yuc, paramString });
                AppMethodBeat.o(115283);
                return;
              }
              try
              {
                paramAnonymousComponentName = b.a.M(paramAnonymousIBinder);
                paramAnonymousComponentName.aM(this.val$intent);
                c.duT().put(paramString, paramAnonymousComponentName);
                AppMethodBeat.o(115283);
                return;
              }
              catch (Exception paramAnonymousComponentName)
              {
                e.qrI.idkeyStat(963L, 49L, 1L, false);
                ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.yuc, paramString, paramAnonymousComponentName.getMessage(), bo.dtY() });
                if (paramBoolean)
                {
                  e.qrI.idkeyStat(963L, 51L, 1L, false);
                  c.a(paramServiceConnection, paramString, false, paramIntent);
                }
                AppMethodBeat.o(115283);
              }
            }
            
            public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
            {
              AppMethodBeat.i(115284);
              ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.yuc, paramString });
              e.qrI.idkeyStat(963L, 50L, 1L, false);
              c.duT().remove(paramString);
              AppMethodBeat.o(115284);
            }
          }, 1)) });
          AppMethodBeat.o(115290);
          return;
        }
        catch (Exception paramServiceConnection)
        {
          ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramServiceConnection.getMessage() });
          AppMethodBeat.o(115290);
          return;
        }
      }
      e.qrI.idkeyStat(963L, 52L, 1L, false);
      try
      {
        ab.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, unbindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        ((b)localObject2).aM((Intent)localObject1);
        AppMethodBeat.o(115290);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bo.dtY() });
        ytN.remove(paramString);
        if (paramBoolean)
        {
          e.qrI.idkeyStat(963L, 51L, 1L, false);
          paramBoolean = false;
        }
        else
        {
          AppMethodBeat.o(115290);
        }
      }
    }
  }
  
  public static boolean a(final Intent paramIntent1, final ServiceConnection paramServiceConnection, final int paramInt, final String paramString, final boolean paramBoolean, Intent paramIntent2)
  {
    AppMethodBeat.i(115289);
    if (paramIntent1 == null)
    {
      ab.i("MicroMsg.MMServiceHelper", "bindService Intent == null");
      AppMethodBeat.o(115289);
      return false;
    }
    final String str = paramIntent1.getComponent().getClassName();
    if (bo.isNullOrNil(str))
    {
      ab.i("MicroMsg.MMServiceHelper", "bindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(115289);
      return false;
    }
    ab.i("MicroMsg.MMServiceHelper", "bindService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
    e.qrI.idkeyStat(963L, 31L, 1L, false);
    Object localObject = (b)ytN.get(paramString);
    paramIntent1.putExtra("class_name", str);
    paramIntent1.putExtra("service_connection", paramServiceConnection.hashCode());
    ytQ.put(Integer.valueOf(paramServiceConnection.hashCode()), str);
    if (localObject == null)
    {
      e.qrI.idkeyStat(963L, 32L, 1L, false);
      ytP.add(paramIntent1);
      localObject = ah.getContext();
      h((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        paramBoolean = ((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(115279);
            ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.ytX.getComponent().getClassName(), str, paramString });
            e.qrI.idkeyStat(963L, 33L, 1L, false);
            if (!c.duU().contains(paramIntent1))
            {
              AppMethodBeat.o(115279);
              return;
            }
            if (paramAnonymousIBinder == null)
            {
              ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.ytX.getComponent().getClassName(), str, paramString });
              AppMethodBeat.o(115279);
              return;
            }
            try
            {
              paramAnonymousComponentName = b.a.M(paramAnonymousIBinder);
              paramAnonymousComponentName.a(paramIntent1, new a.a()
              {
                public final void L(IBinder paramAnonymous2IBinder)
                {
                  AppMethodBeat.i(115278);
                  if (paramAnonymous2IBinder == null)
                  {
                    ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected() service == null", new Object[] { c.3.this.ytX.getComponent().getClassName(), c.3.this.ytT, c.3.this.ytU });
                    AppMethodBeat.o(115278);
                    return;
                  }
                  ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.3.this.ytX.getComponent().getClassName(), c.3.this.ytT, c.3.this.ytU });
                  c.3.this.ytY.onServiceConnected(new ComponentName(ah.getContext(), c.3.this.ytT), paramAnonymous2IBinder);
                  c.duV().put(Integer.valueOf(c.3.this.ytY.hashCode()), paramAnonymous2IBinder);
                  IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
                  {
                    public final void binderDied()
                    {
                      AppMethodBeat.i(115277);
                      ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.3.this.ytX.getComponent().getClassName(), c.3.this.ytT, c.3.this.ytU });
                      c.3.this.ytY.onServiceDisconnected(new ComponentName(ah.getContext(), c.3.this.ytT));
                      AppMethodBeat.o(115277);
                    }
                  };
                  c.ytS.put(Integer.valueOf(c.3.this.ytY.hashCode()), local1);
                  paramAnonymous2IBinder.linkToDeath(local1, 0);
                  AppMethodBeat.o(115278);
                }
              });
              c.duT().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              ab.i("MicroMsg.MMServiceHelper", "bindService()  ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.ytX.getComponent().getClassName(), str, paramString, paramAnonymousComponentName.getMessage(), bo.dtY() });
              e.qrI.idkeyStat(963L, 34L, 1L, false);
              if (paramBoolean)
              {
                e.qrI.idkeyStat(963L, 36L, 1L, false);
                c.a(paramIntent1, paramServiceConnection, paramInt, paramString, false, this.ytX);
              }
              return;
            }
            finally
            {
              c.duU().remove(paramIntent1);
              AppMethodBeat.o(115279);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(115280);
            ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.ytX.getComponent().getClassName(), str, paramString });
            e.qrI.idkeyStat(963L, 35L, 1L, false);
            c.duT().remove(paramString);
            AppMethodBeat.o(115280);
          }
        }, 1);
        ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(115289);
        return true;
      }
      catch (Exception paramIntent1)
      {
        ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s Context.bindService() Exception = %s", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, paramIntent1.getMessage() });
        continue;
      }
      e.qrI.idkeyStat(963L, 37L, 1L, false);
      try
      {
        ab.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, bindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        ((b)localObject).a(paramIntent1, new a.a()
        {
          public final void L(IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(115282);
            ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { this.ytX.getComponent().getClassName(), str, paramString });
            if (paramAnonymousIBinder == null)
            {
              AppMethodBeat.o(115282);
              return;
            }
            paramServiceConnection.onServiceConnected(new ComponentName(ah.getContext(), str), paramAnonymousIBinder);
            c.duV().put(Integer.valueOf(paramServiceConnection.hashCode()), paramAnonymousIBinder);
            paramAnonymousIBinder.linkToDeath(new IBinder.DeathRecipient()
            {
              public final void binderDied()
              {
                AppMethodBeat.i(115281);
                ab.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.4.this.ytX.getComponent().getClassName(), c.4.this.ytT, c.4.this.ytU });
                c.4.this.ytY.onServiceDisconnected(new ComponentName(ah.getContext(), c.4.this.ytT));
                AppMethodBeat.o(115281);
              }
            }, 0);
            AppMethodBeat.o(115282);
          }
        });
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.MMServiceHelper", "bindService ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bo.dtY() });
        ytN.remove(paramString);
      }
      if (paramBoolean)
      {
        e.qrI.idkeyStat(963L, 36L, 1L, false);
        a(paramIntent1, paramServiceConnection, paramInt, paramString, false, paramIntent2);
      }
    }
  }
  
  private static boolean aqy(String paramString)
  {
    AppMethodBeat.i(115293);
    if (!bo.isEqual(paramString, "mm"))
    {
      AppMethodBeat.o(115293);
      return false;
    }
    if (d.fv(26))
    {
      int i = ah.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0);
      ab.i("MicroMsg.MMServiceHelper", "ifTarget26StartServiceHuawei() huaweiEnable : %s", new Object[] { Integer.valueOf(i) });
      if (bo.hl(i, 0))
      {
        AppMethodBeat.o(115293);
        return false;
      }
      AppMethodBeat.o(115293);
      return true;
    }
    AppMethodBeat.o(115293);
    return true;
  }
  
  public static void b(final Intent paramIntent1, final String paramString, final boolean paramBoolean, final Intent paramIntent2)
  {
    AppMethodBeat.i(115288);
    for (;;)
    {
      if (paramIntent1 == null)
      {
        ab.i("MicroMsg.MMServiceHelper", "stopService Intent == null");
        AppMethodBeat.o(115288);
        return;
      }
      String str = paramIntent1.getComponent().getClassName();
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = null processName = %s", new Object[] { paramString });
        AppMethodBeat.o(115288);
        return;
      }
      ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
      e.qrI.idkeyStat(963L, 16L, 1L, false);
      Object localObject = (b)ytN.get(paramString);
      paramIntent1.putExtra("class_name", str);
      if (localObject == null)
      {
        e.qrI.idkeyStat(963L, 17L, 1L, false);
        localObject = ah.getContext();
        h((Context)localObject, paramString, paramIntent2);
        try
        {
          ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
          {
            public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
            {
              AppMethodBeat.i(115275);
              ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.ytT, paramString });
              e.qrI.idkeyStat(963L, 18L, 1L, false);
              if (paramAnonymousIBinder == null)
              {
                ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.ytT, paramString });
                AppMethodBeat.o(115275);
                return;
              }
              try
              {
                paramAnonymousComponentName = b.a.M(paramAnonymousIBinder);
                paramAnonymousComponentName.aH(paramIntent1);
                c.duT().put(paramString, paramAnonymousComponentName);
                AppMethodBeat.o(115275);
                return;
              }
              catch (Exception paramAnonymousComponentName)
              {
                ab.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.ytT, paramString, paramAnonymousComponentName.getMessage(), bo.dtY() });
                e.qrI.idkeyStat(963L, 19L, 1L, false);
                if (paramBoolean)
                {
                  e.qrI.idkeyStat(963L, 21L, 1L, false);
                  c.b(paramIntent1, paramString, false, paramIntent2);
                }
                AppMethodBeat.o(115275);
              }
            }
            
            public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
            {
              AppMethodBeat.i(115276);
              ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.ytT, paramString });
              e.qrI.idkeyStat(963L, 20L, 1L, false);
              c.duT().remove(paramString);
              AppMethodBeat.o(115276);
            }
          }, 1)) });
          AppMethodBeat.o(115288);
          return;
        }
        catch (Exception paramIntent1)
        {
          ab.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
          AppMethodBeat.o(115288);
          return;
        }
      }
      e.qrI.idkeyStat(963L, 22L, 1L, false);
      try
      {
        ab.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, stopService() ClassName = %s ProcessName = %s stack[%s]", new Object[] { str, paramString, bo.dtY() });
        ((b)localObject).aH(paramIntent1);
        AppMethodBeat.o(115288);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s exception = %s", new Object[] { str, paramString, localException.getMessage() });
        ytN.remove(paramString);
        if (paramBoolean)
        {
          e.qrI.idkeyStat(963L, 21L, 1L, false);
          paramBoolean = false;
        }
        else
        {
          AppMethodBeat.o(115288);
        }
      }
    }
  }
  
  public static void b(String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(115291);
    Context localContext = ah.getContext();
    h(localContext, paramString, paramIntent);
    ab.i("MicroMsg.MMServiceHelper", "startProcessService() processName = %s", new Object[] { paramString });
    localContext.bindService(paramIntent, new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(115285);
        ab.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected()", new Object[] { this.ytU });
        if (paramAnonymousIBinder == null)
        {
          ab.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected() service == null", new Object[] { this.ytU });
          AppMethodBeat.o(115285);
          return;
        }
        paramAnonymousComponentName = b.a.M(paramAnonymousIBinder);
        c.duT().put(this.ytU, paramAnonymousComponentName);
        AppMethodBeat.o(115285);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(115286);
        ab.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceDisconnected()", new Object[] { this.ytU });
        e.qrI.idkeyStat(963L, 4L, 1L, false);
        c.duT().remove(this.ytU);
        if (paramBoolean) {
          c.b(this.ytU, false, paramIntent);
        }
        AppMethodBeat.o(115286);
      }
    }, 1);
    AppMethodBeat.o(115291);
  }
  
  private static void h(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(115292);
    if (aqy(paramString)) {
      try
      {
        paramContext.startService(paramIntent);
        AppMethodBeat.o(115292);
        return;
      }
      catch (Exception paramContext)
      {
        ab.i("MicroMsg.MMServiceHelper", "startProcessService() Exception:%s %s", new Object[] { paramContext.getClass().toString(), paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(115292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.c
 * JD-Core Version:    0.7.0.1
 */