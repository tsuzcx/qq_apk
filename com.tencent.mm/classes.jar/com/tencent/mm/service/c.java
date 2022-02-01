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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static ConcurrentHashMap<String, b> EZP;
  private static Vector<Intent> EZQ;
  private static Vector<Intent> EZR;
  private static ConcurrentHashMap<Integer, String> EZS;
  private static ConcurrentHashMap<Integer, IBinder> EZT;
  private static ConcurrentHashMap<Integer, IBinder.DeathRecipient> EZU;
  
  static
  {
    AppMethodBeat.i(125331);
    EZP = new ConcurrentHashMap();
    EZQ = new Vector();
    EZR = new Vector();
    EZS = new ConcurrentHashMap();
    EZT = new ConcurrentHashMap();
    EZU = new ConcurrentHashMap();
    AppMethodBeat.o(125331);
  }
  
  public static void a(final Intent paramIntent1, final String paramString, final boolean paramBoolean, final Intent paramIntent2)
  {
    AppMethodBeat.i(125324);
    if (paramIntent1 == null)
    {
      ad.i("MicroMsg.MMServiceHelper", "startService Intent == null");
      AppMethodBeat.o(125324);
      return;
    }
    String str = paramIntent1.getComponent().getClassName();
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.MMServiceHelper", "startService() ClassName = null processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125324);
      return;
    }
    paramIntent1.putExtra("class_name", str);
    Object localObject = (b)EZP.get(paramString);
    if (localObject == null)
    {
      EZQ.add(paramIntent1);
      localObject = aj.getContext();
      g((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125310);
            e.vIY.idkeyStat(963L, 2L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ad.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.EZV, paramString });
              AppMethodBeat.o(125310);
              return;
            }
            ad.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.EZV, paramString });
            if (!c.aYd().contains(paramIntent1))
            {
              AppMethodBeat.o(125310);
              return;
            }
            try
            {
              paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
              paramAnonymousComponentName.aY(paramIntent1);
              c.eHI().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                e.vIY.idkeyStat(963L, 5L, 1L, false);
                c.a(paramIntent1, paramString, false, paramIntent2);
              }
              e.vIY.idkeyStat(963L, 3L, 1L, false);
              ad.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { this.EZV, paramString, paramAnonymousComponentName.getMessage(), bt.eGN() });
              return;
            }
            finally
            {
              c.aYd().remove(paramIntent1);
              AppMethodBeat.o(125310);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125311);
            c.eHI().remove(paramString);
            ad.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.EZV, paramString });
            e.vIY.idkeyStat(963L, 4L, 1L, false);
            AppMethodBeat.o(125311);
          }
        }, 1)) });
        e.vIY.idkeyStat(963L, 1L, 1L, false);
        ad.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.vIY.idkeyStat(963L, 0L, 1L, false);
        AppMethodBeat.o(125324);
        return;
      }
      catch (Exception paramIntent1)
      {
        ad.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject).aY(paramIntent1);
        ad.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, startService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        e.vIY.idkeyStat(963L, 6L, 1L, false);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          EZP.remove(paramString);
          if (paramBoolean)
          {
            a(paramIntent1, paramString, false, paramIntent2);
            e.vIY.idkeyStat(963L, 5L, 1L, false);
          }
          ad.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bt.eGN() });
        }
      }
    }
  }
  
  public static void a(final ServiceConnection paramServiceConnection, final String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(125327);
    if (paramServiceConnection == null)
    {
      ad.i("MicroMsg.MMServiceHelper", "unbindService ServiceConnection == null");
      AppMethodBeat.o(125327);
      return;
    }
    String str = (String)EZS.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    Object localObject1 = (IBinder)EZT.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    Object localObject2 = (IBinder.DeathRecipient)EZU.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    if (localObject1 != null) {
      ((IBinder)localObject1).unlinkToDeath((IBinder.DeathRecipient)localObject2, 0);
    }
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.MMServiceHelper", "unbindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125327);
      return;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("class_name", str);
    ((Intent)localObject1).putExtra("service_connection", paramServiceConnection.hashCode());
    localObject2 = (b)EZP.get(paramString);
    if (localObject2 == null)
    {
      e.vIY.idkeyStat(963L, 47L, 1L, false);
      localObject2 = aj.getContext();
      g((Context)localObject2, paramString, paramIntent);
    }
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject2).bindService(paramIntent, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125320);
            e.vIY.idkeyStat(963L, 48L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ad.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.Fad, paramString });
              AppMethodBeat.o(125320);
              return;
            }
            ad.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.Fad, paramString });
            try
            {
              paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
              paramAnonymousComponentName.bf(this.val$intent);
              c.eHI().put(paramString, paramAnonymousComponentName);
              AppMethodBeat.o(125320);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.a(paramServiceConnection, paramString, false, paramIntent);
                e.vIY.idkeyStat(963L, 51L, 1L, false);
              }
              e.vIY.idkeyStat(963L, 49L, 1L, false);
              ad.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.Fad, paramString, paramAnonymousComponentName.getMessage(), bt.eGN() });
              AppMethodBeat.o(125320);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125321);
            ad.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.Fad, paramString });
            c.eHI().remove(paramString);
            e.vIY.idkeyStat(963L, 50L, 1L, false);
            AppMethodBeat.o(125321);
          }
        }, 1)) });
        ad.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s processName = %s", new Object[] { str, paramString });
        e.vIY.idkeyStat(963L, 46L, 1L, false);
        AppMethodBeat.o(125327);
        return;
      }
      catch (Exception paramServiceConnection)
      {
        ad.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramServiceConnection.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject2).bf((Intent)localObject1);
        e.vIY.idkeyStat(963L, 52L, 1L, false);
        ad.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, unbindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          EZP.remove(paramString);
          if (paramBoolean)
          {
            a(paramServiceConnection, paramString, false, paramIntent);
            e.vIY.idkeyStat(963L, 51L, 1L, false);
          }
          ad.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bt.eGN() });
        }
      }
    }
  }
  
  public static boolean a(final Intent paramIntent1, final ServiceConnection paramServiceConnection, final int paramInt, final String paramString, final boolean paramBoolean, Intent paramIntent2)
  {
    AppMethodBeat.i(125326);
    if (paramIntent1 == null)
    {
      ad.i("MicroMsg.MMServiceHelper", "bindService Intent == null");
      AppMethodBeat.o(125326);
      return false;
    }
    final String str = paramIntent1.getComponent().getClassName();
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.MMServiceHelper", "bindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125326);
      return false;
    }
    Object localObject = (b)EZP.get(paramString);
    paramIntent1.putExtra("class_name", str);
    paramIntent1.putExtra("service_connection", paramServiceConnection.hashCode());
    EZS.put(Integer.valueOf(paramServiceConnection.hashCode()), str);
    if (localObject == null)
    {
      e.vIY.idkeyStat(963L, 32L, 1L, false);
      EZR.add(paramIntent1);
      localObject = aj.getContext();
      g((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        paramBoolean = ((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125316);
            ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.EZY.getComponent().getClassName(), str, paramString });
            e.vIY.idkeyStat(963L, 33L, 1L, false);
            if (!c.eHJ().contains(paramIntent1))
            {
              AppMethodBeat.o(125316);
              return;
            }
            if (paramAnonymousIBinder == null)
            {
              ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.EZY.getComponent().getClassName(), str, paramString });
              AppMethodBeat.o(125316);
              return;
            }
            try
            {
              paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
              paramAnonymousComponentName.a(paramIntent1, new a.a()
              {
                public final void N(IBinder paramAnonymous2IBinder)
                {
                  AppMethodBeat.i(125315);
                  if (paramAnonymous2IBinder == null)
                  {
                    ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected() service == null", new Object[] { c.3.this.EZY.getComponent().getClassName(), c.3.this.EZV, c.3.this.kDM });
                    AppMethodBeat.o(125315);
                    return;
                  }
                  c.3.this.EZZ.onServiceConnected(new ComponentName(aj.getContext(), c.3.this.EZV), paramAnonymous2IBinder);
                  c.eHK().put(Integer.valueOf(c.3.this.EZZ.hashCode()), paramAnonymous2IBinder);
                  IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
                  {
                    public final void binderDied()
                    {
                      AppMethodBeat.i(125314);
                      c.3.this.EZZ.onServiceDisconnected(new ComponentName(aj.getContext(), c.3.this.EZV));
                      ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.3.this.EZY.getComponent().getClassName(), c.3.this.EZV, c.3.this.kDM });
                      AppMethodBeat.o(125314);
                    }
                  };
                  c.EZU.put(Integer.valueOf(c.3.this.EZZ.hashCode()), local1);
                  paramAnonymous2IBinder.linkToDeath(local1, 0);
                  ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.3.this.EZY.getComponent().getClassName(), c.3.this.EZV, c.3.this.kDM });
                  AppMethodBeat.o(125315);
                }
              });
              c.eHI().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.a(paramIntent1, paramServiceConnection, paramInt, paramString, false, this.EZY);
                e.vIY.idkeyStat(963L, 36L, 1L, false);
              }
              ad.i("MicroMsg.MMServiceHelper", "bindService()  ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.EZY.getComponent().getClassName(), str, paramString, paramAnonymousComponentName.getMessage(), bt.eGN() });
              e.vIY.idkeyStat(963L, 34L, 1L, false);
              return;
            }
            finally
            {
              c.eHJ().remove(paramIntent1);
              AppMethodBeat.o(125316);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125317);
            c.eHI().remove(paramString);
            ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.EZY.getComponent().getClassName(), str, paramString });
            e.vIY.idkeyStat(963L, 35L, 1L, false);
            AppMethodBeat.o(125317);
          }
        }, 1);
        ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, Boolean.valueOf(paramBoolean) });
        ad.i("MicroMsg.MMServiceHelper", "bindService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.vIY.idkeyStat(963L, 31L, 1L, false);
        AppMethodBeat.o(125326);
        return true;
      }
      catch (Exception paramIntent1)
      {
        ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s Context.bindService() Exception = %s", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, paramIntent1.getMessage() });
        continue;
      }
      e.vIY.idkeyStat(963L, 37L, 1L, false);
      try
      {
        ad.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, bindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        ((b)localObject).a(paramIntent1, new a.a()
        {
          public final void N(IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125319);
            ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { this.EZY.getComponent().getClassName(), str, paramString });
            if (paramAnonymousIBinder == null)
            {
              AppMethodBeat.o(125319);
              return;
            }
            paramServiceConnection.onServiceConnected(new ComponentName(aj.getContext(), str), paramAnonymousIBinder);
            c.eHK().put(Integer.valueOf(paramServiceConnection.hashCode()), paramAnonymousIBinder);
            paramAnonymousIBinder.linkToDeath(new IBinder.DeathRecipient()
            {
              public final void binderDied()
              {
                AppMethodBeat.i(125318);
                c.4.this.EZZ.onServiceDisconnected(new ComponentName(aj.getContext(), c.4.this.EZV));
                ad.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.4.this.EZY.getComponent().getClassName(), c.4.this.EZV, c.4.this.kDM });
                AppMethodBeat.o(125318);
              }
            }, 0);
            AppMethodBeat.o(125319);
          }
        });
      }
      catch (Exception localException)
      {
        EZP.remove(paramString);
        if (paramBoolean)
        {
          a(paramIntent1, paramServiceConnection, paramInt, paramString, false, paramIntent2);
          e.vIY.idkeyStat(963L, 36L, 1L, false);
        }
        ad.i("MicroMsg.MMServiceHelper", "bindService ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bt.eGN() });
      }
    }
  }
  
  private static boolean aGH(String paramString)
  {
    AppMethodBeat.i(125330);
    if (!bt.kU(paramString, "mm"))
    {
      AppMethodBeat.o(125330);
      return false;
    }
    if (d.lf(26))
    {
      int i = aj.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0);
      ad.i("MicroMsg.MMServiceHelper", "ifTarget26StartServiceHuawei() huaweiEnable : %s", new Object[] { Integer.valueOf(i) });
      if (bt.iY(i, 0))
      {
        AppMethodBeat.o(125330);
        return false;
      }
      AppMethodBeat.o(125330);
      return true;
    }
    AppMethodBeat.o(125330);
    return true;
  }
  
  public static void b(final Intent paramIntent1, final String paramString, final boolean paramBoolean, final Intent paramIntent2)
  {
    AppMethodBeat.i(125325);
    if (paramIntent1 == null)
    {
      ad.i("MicroMsg.MMServiceHelper", "stopService Intent == null");
      AppMethodBeat.o(125325);
      return;
    }
    String str = paramIntent1.getComponent().getClassName();
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.MMServiceHelper", "stopService() ClassName = null processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125325);
      return;
    }
    Object localObject = (b)EZP.get(paramString);
    paramIntent1.putExtra("class_name", str);
    if (localObject == null)
    {
      e.vIY.idkeyStat(963L, 17L, 1L, false);
      localObject = aj.getContext();
      g((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125312);
            e.vIY.idkeyStat(963L, 18L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ad.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.EZV, paramString });
              AppMethodBeat.o(125312);
              return;
            }
            ad.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.EZV, paramString });
            try
            {
              paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
              paramAnonymousComponentName.aZ(paramIntent1);
              c.eHI().put(paramString, paramAnonymousComponentName);
              AppMethodBeat.o(125312);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.b(paramIntent1, paramString, false, paramIntent2);
                e.vIY.idkeyStat(963L, 21L, 1L, false);
              }
              ad.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.EZV, paramString, paramAnonymousComponentName.getMessage(), bt.eGN() });
              e.vIY.idkeyStat(963L, 19L, 1L, false);
              AppMethodBeat.o(125312);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125313);
            c.eHI().remove(paramString);
            ad.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.EZV, paramString });
            e.vIY.idkeyStat(963L, 20L, 1L, false);
            AppMethodBeat.o(125313);
          }
        }, 1)) });
        ad.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.vIY.idkeyStat(963L, 16L, 1L, false);
        AppMethodBeat.o(125325);
        return;
      }
      catch (Exception paramIntent1)
      {
        ad.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject).aZ(paramIntent1);
        e.vIY.idkeyStat(963L, 22L, 1L, false);
        ad.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, stopService() ClassName = %s ProcessName = %s stack[%s]", new Object[] { str, paramString, bt.eGN() });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          EZP.remove(paramString);
          if (paramBoolean)
          {
            b(paramIntent1, paramString, false, paramIntent2);
            e.vIY.idkeyStat(963L, 21L, 1L, false);
          }
          ad.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s exception = %s", new Object[] { str, paramString, localException.getMessage() });
        }
      }
    }
  }
  
  public static void b(String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(125328);
    Context localContext = aj.getContext();
    g(localContext, paramString, paramIntent);
    localContext.bindService(paramIntent, new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(125322);
        if (paramAnonymousIBinder == null)
        {
          ad.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected() service == null", new Object[] { this.kDM });
          AppMethodBeat.o(125322);
          return;
        }
        paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
        c.eHI().put(this.kDM, paramAnonymousComponentName);
        ad.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected()", new Object[] { this.kDM });
        AppMethodBeat.o(125322);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(125323);
        c.eHI().remove(this.kDM);
        if (paramBoolean) {
          c.b(this.kDM, false, paramIntent);
        }
        ad.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceDisconnected()", new Object[] { this.kDM });
        e.vIY.idkeyStat(963L, 4L, 1L, false);
        AppMethodBeat.o(125323);
      }
    }, 1);
    ad.i("MicroMsg.MMServiceHelper", "startProcessService() processName = %s", new Object[] { paramString });
    AppMethodBeat.o(125328);
  }
  
  private static void g(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(125329);
    if (aGH(paramString)) {
      try
      {
        paramContext.startService(paramIntent);
        AppMethodBeat.o(125329);
        return;
      }
      catch (Exception paramContext)
      {
        ad.i("MicroMsg.MMServiceHelper", "startProcessService() Exception:%s %s", new Object[] { paramContext.getClass().toString(), paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(125329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.c
 * JD-Core Version:    0.7.0.1
 */