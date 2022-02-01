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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static ConcurrentHashMap<String, b> IDl;
  private static Vector<Intent> IDm;
  private static Vector<Intent> IDn;
  private static ConcurrentHashMap<Integer, String> IDo;
  private static ConcurrentHashMap<Integer, IBinder> IDp;
  private static ConcurrentHashMap<Integer, IBinder.DeathRecipient> IDq;
  
  static
  {
    AppMethodBeat.i(125331);
    IDl = new ConcurrentHashMap();
    IDm = new Vector();
    IDn = new Vector();
    IDo = new ConcurrentHashMap();
    IDp = new ConcurrentHashMap();
    IDq = new ConcurrentHashMap();
    AppMethodBeat.o(125331);
  }
  
  public static void a(final Intent paramIntent1, final String paramString, final boolean paramBoolean, final Intent paramIntent2)
  {
    AppMethodBeat.i(125324);
    if (paramIntent1 == null)
    {
      ae.i("MicroMsg.MMServiceHelper", "startService Intent == null");
      AppMethodBeat.o(125324);
      return;
    }
    String str = paramIntent1.getComponent().getClassName();
    if (bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.MMServiceHelper", "startService() ClassName = null processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125324);
      return;
    }
    paramIntent1.putExtra("class_name", str);
    Object localObject = (b)IDl.get(paramString);
    if (localObject == null)
    {
      IDm.add(paramIntent1);
      localObject = ak.getContext();
      h((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125310);
            e.ywz.idkeyStat(963L, 2L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ae.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.IDr, paramString });
              AppMethodBeat.o(125310);
              return;
            }
            ae.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.IDr, paramString });
            if (!c.bjm().contains(paramIntent1))
            {
              AppMethodBeat.o(125310);
              return;
            }
            try
            {
              paramAnonymousComponentName = b.a.P(paramAnonymousIBinder);
              paramAnonymousComponentName.bf(paramIntent1);
              c.dYD().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                e.ywz.idkeyStat(963L, 5L, 1L, false);
                c.a(paramIntent1, paramString, false, paramIntent2);
              }
              e.ywz.idkeyStat(963L, 3L, 1L, false);
              ae.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { this.IDr, paramString, paramAnonymousComponentName.getMessage(), bu.fpN() });
              return;
            }
            finally
            {
              c.bjm().remove(paramIntent1);
              AppMethodBeat.o(125310);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125311);
            c.dYD().remove(paramString);
            ae.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.IDr, paramString });
            e.ywz.idkeyStat(963L, 4L, 1L, false);
            AppMethodBeat.o(125311);
          }
        }, 1)) });
        e.ywz.idkeyStat(963L, 1L, 1L, false);
        ae.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.ywz.idkeyStat(963L, 0L, 1L, false);
        AppMethodBeat.o(125324);
        return;
      }
      catch (Exception paramIntent1)
      {
        ae.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject).bf(paramIntent1);
        ae.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, startService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        e.ywz.idkeyStat(963L, 6L, 1L, false);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          IDl.remove(paramString);
          if (paramBoolean)
          {
            a(paramIntent1, paramString, false, paramIntent2);
            e.ywz.idkeyStat(963L, 5L, 1L, false);
          }
          ae.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bu.fpN() });
        }
      }
    }
  }
  
  public static void a(final ServiceConnection paramServiceConnection, final String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(125327);
    if (paramServiceConnection == null)
    {
      ae.i("MicroMsg.MMServiceHelper", "unbindService ServiceConnection == null");
      AppMethodBeat.o(125327);
      return;
    }
    String str = (String)IDo.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    Object localObject1 = (IBinder)IDp.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    Object localObject2 = (IBinder.DeathRecipient)IDq.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    if (localObject1 != null) {
      ((IBinder)localObject1).unlinkToDeath((IBinder.DeathRecipient)localObject2, 0);
    }
    if (bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.MMServiceHelper", "unbindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125327);
      return;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("class_name", str);
    ((Intent)localObject1).putExtra("service_connection", paramServiceConnection.hashCode());
    localObject2 = (b)IDl.get(paramString);
    if (localObject2 == null)
    {
      e.ywz.idkeyStat(963L, 47L, 1L, false);
      localObject2 = ak.getContext();
      h((Context)localObject2, paramString, paramIntent);
    }
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject2).bindService(paramIntent, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125320);
            e.ywz.idkeyStat(963L, 48L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ae.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.IDz, paramString });
              AppMethodBeat.o(125320);
              return;
            }
            ae.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.IDz, paramString });
            try
            {
              paramAnonymousComponentName = b.a.P(paramAnonymousIBinder);
              paramAnonymousComponentName.bm(this.val$intent);
              c.dYD().put(paramString, paramAnonymousComponentName);
              AppMethodBeat.o(125320);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.a(paramServiceConnection, paramString, false, paramIntent);
                e.ywz.idkeyStat(963L, 51L, 1L, false);
              }
              e.ywz.idkeyStat(963L, 49L, 1L, false);
              ae.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.IDz, paramString, paramAnonymousComponentName.getMessage(), bu.fpN() });
              AppMethodBeat.o(125320);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125321);
            ae.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.IDz, paramString });
            c.dYD().remove(paramString);
            e.ywz.idkeyStat(963L, 50L, 1L, false);
            AppMethodBeat.o(125321);
          }
        }, 1)) });
        ae.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s processName = %s", new Object[] { str, paramString });
        e.ywz.idkeyStat(963L, 46L, 1L, false);
        AppMethodBeat.o(125327);
        return;
      }
      catch (Exception paramServiceConnection)
      {
        ae.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramServiceConnection.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject2).bm((Intent)localObject1);
        e.ywz.idkeyStat(963L, 52L, 1L, false);
        ae.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, unbindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          IDl.remove(paramString);
          if (paramBoolean)
          {
            a(paramServiceConnection, paramString, false, paramIntent);
            e.ywz.idkeyStat(963L, 51L, 1L, false);
          }
          ae.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bu.fpN() });
        }
      }
    }
  }
  
  public static boolean a(final Intent paramIntent1, final ServiceConnection paramServiceConnection, final int paramInt, final String paramString, final boolean paramBoolean, Intent paramIntent2)
  {
    AppMethodBeat.i(125326);
    if (paramIntent1 == null)
    {
      ae.i("MicroMsg.MMServiceHelper", "bindService Intent == null");
      AppMethodBeat.o(125326);
      return false;
    }
    final String str = paramIntent1.getComponent().getClassName();
    if (bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.MMServiceHelper", "bindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125326);
      return false;
    }
    Object localObject = (b)IDl.get(paramString);
    paramIntent1.putExtra("class_name", str);
    paramIntent1.putExtra("service_connection", paramServiceConnection.hashCode());
    IDo.put(Integer.valueOf(paramServiceConnection.hashCode()), str);
    if (localObject == null)
    {
      e.ywz.idkeyStat(963L, 32L, 1L, false);
      IDn.add(paramIntent1);
      localObject = ak.getContext();
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
            AppMethodBeat.i(125316);
            ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.IDu.getComponent().getClassName(), str, paramString });
            e.ywz.idkeyStat(963L, 33L, 1L, false);
            if (!c.fqJ().contains(paramIntent1))
            {
              AppMethodBeat.o(125316);
              return;
            }
            if (paramAnonymousIBinder == null)
            {
              ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.IDu.getComponent().getClassName(), str, paramString });
              AppMethodBeat.o(125316);
              return;
            }
            try
            {
              paramAnonymousComponentName = b.a.P(paramAnonymousIBinder);
              paramAnonymousComponentName.a(paramIntent1, new a.a()
              {
                public final void O(IBinder paramAnonymous2IBinder)
                {
                  AppMethodBeat.i(125315);
                  if (paramAnonymous2IBinder == null)
                  {
                    ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected() service == null", new Object[] { c.3.this.IDu.getComponent().getClassName(), c.3.this.IDr, c.3.this.cVs });
                    AppMethodBeat.o(125315);
                    return;
                  }
                  c.3.this.IDv.onServiceConnected(new ComponentName(ak.getContext(), c.3.this.IDr), paramAnonymous2IBinder);
                  c.fqK().put(Integer.valueOf(c.3.this.IDv.hashCode()), paramAnonymous2IBinder);
                  IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
                  {
                    public final void binderDied()
                    {
                      AppMethodBeat.i(125314);
                      c.3.this.IDv.onServiceDisconnected(new ComponentName(ak.getContext(), c.3.this.IDr));
                      ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.3.this.IDu.getComponent().getClassName(), c.3.this.IDr, c.3.this.cVs });
                      AppMethodBeat.o(125314);
                    }
                  };
                  c.IDq.put(Integer.valueOf(c.3.this.IDv.hashCode()), local1);
                  paramAnonymous2IBinder.linkToDeath(local1, 0);
                  ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.3.this.IDu.getComponent().getClassName(), c.3.this.IDr, c.3.this.cVs });
                  AppMethodBeat.o(125315);
                }
              });
              c.dYD().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.a(paramIntent1, paramServiceConnection, paramInt, paramString, false, this.IDu);
                e.ywz.idkeyStat(963L, 36L, 1L, false);
              }
              ae.i("MicroMsg.MMServiceHelper", "bindService()  ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.IDu.getComponent().getClassName(), str, paramString, paramAnonymousComponentName.getMessage(), bu.fpN() });
              e.ywz.idkeyStat(963L, 34L, 1L, false);
              return;
            }
            finally
            {
              c.fqJ().remove(paramIntent1);
              AppMethodBeat.o(125316);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125317);
            c.dYD().remove(paramString);
            ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.IDu.getComponent().getClassName(), str, paramString });
            e.ywz.idkeyStat(963L, 35L, 1L, false);
            AppMethodBeat.o(125317);
          }
        }, 1);
        ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, Boolean.valueOf(paramBoolean) });
        ae.i("MicroMsg.MMServiceHelper", "bindService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.ywz.idkeyStat(963L, 31L, 1L, false);
        AppMethodBeat.o(125326);
        return true;
      }
      catch (Exception paramIntent1)
      {
        ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s Context.bindService() Exception = %s", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, paramIntent1.getMessage() });
        continue;
      }
      e.ywz.idkeyStat(963L, 37L, 1L, false);
      try
      {
        ae.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, bindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        ((b)localObject).a(paramIntent1, new a.a()
        {
          public final void O(IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125319);
            ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { this.IDu.getComponent().getClassName(), str, paramString });
            if (paramAnonymousIBinder == null)
            {
              AppMethodBeat.o(125319);
              return;
            }
            paramServiceConnection.onServiceConnected(new ComponentName(ak.getContext(), str), paramAnonymousIBinder);
            c.fqK().put(Integer.valueOf(paramServiceConnection.hashCode()), paramAnonymousIBinder);
            paramAnonymousIBinder.linkToDeath(new IBinder.DeathRecipient()
            {
              public final void binderDied()
              {
                AppMethodBeat.i(125318);
                c.4.this.IDv.onServiceDisconnected(new ComponentName(ak.getContext(), c.4.this.IDr));
                ae.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.4.this.IDu.getComponent().getClassName(), c.4.this.IDr, c.4.this.cVs });
                AppMethodBeat.o(125318);
              }
            }, 0);
            AppMethodBeat.o(125319);
          }
        });
      }
      catch (Exception localException)
      {
        IDl.remove(paramString);
        if (paramBoolean)
        {
          a(paramIntent1, paramServiceConnection, paramInt, paramString, false, paramIntent2);
          e.ywz.idkeyStat(963L, 36L, 1L, false);
        }
        ae.i("MicroMsg.MMServiceHelper", "bindService ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bu.fpN() });
      }
    }
  }
  
  private static boolean aTd(String paramString)
  {
    AppMethodBeat.i(125330);
    if (!bu.lX(paramString, "mm"))
    {
      AppMethodBeat.o(125330);
      return false;
    }
    if (d.lA(26))
    {
      int i = ak.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0);
      ae.i("MicroMsg.MMServiceHelper", "ifTarget26StartServiceHuawei() huaweiEnable : %s", new Object[] { Integer.valueOf(i) });
      if (bu.jB(i, 0))
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
      ae.i("MicroMsg.MMServiceHelper", "stopService Intent == null");
      AppMethodBeat.o(125325);
      return;
    }
    String str = paramIntent1.getComponent().getClassName();
    if (bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.MMServiceHelper", "stopService() ClassName = null processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125325);
      return;
    }
    Object localObject = (b)IDl.get(paramString);
    paramIntent1.putExtra("class_name", str);
    if (localObject == null)
    {
      e.ywz.idkeyStat(963L, 17L, 1L, false);
      localObject = ak.getContext();
      h((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125312);
            e.ywz.idkeyStat(963L, 18L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ae.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.IDr, paramString });
              AppMethodBeat.o(125312);
              return;
            }
            ae.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.IDr, paramString });
            try
            {
              paramAnonymousComponentName = b.a.P(paramAnonymousIBinder);
              paramAnonymousComponentName.bg(paramIntent1);
              c.dYD().put(paramString, paramAnonymousComponentName);
              AppMethodBeat.o(125312);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.b(paramIntent1, paramString, false, paramIntent2);
                e.ywz.idkeyStat(963L, 21L, 1L, false);
              }
              ae.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.IDr, paramString, paramAnonymousComponentName.getMessage(), bu.fpN() });
              e.ywz.idkeyStat(963L, 19L, 1L, false);
              AppMethodBeat.o(125312);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125313);
            c.dYD().remove(paramString);
            ae.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.IDr, paramString });
            e.ywz.idkeyStat(963L, 20L, 1L, false);
            AppMethodBeat.o(125313);
          }
        }, 1)) });
        ae.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.ywz.idkeyStat(963L, 16L, 1L, false);
        AppMethodBeat.o(125325);
        return;
      }
      catch (Exception paramIntent1)
      {
        ae.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject).bg(paramIntent1);
        e.ywz.idkeyStat(963L, 22L, 1L, false);
        ae.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, stopService() ClassName = %s ProcessName = %s stack[%s]", new Object[] { str, paramString, bu.fpN() });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          IDl.remove(paramString);
          if (paramBoolean)
          {
            b(paramIntent1, paramString, false, paramIntent2);
            e.ywz.idkeyStat(963L, 21L, 1L, false);
          }
          ae.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s exception = %s", new Object[] { str, paramString, localException.getMessage() });
        }
      }
    }
  }
  
  public static void b(String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(125328);
    Context localContext = ak.getContext();
    h(localContext, paramString, paramIntent);
    localContext.bindService(paramIntent, new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(125322);
        if (paramAnonymousIBinder == null)
        {
          ae.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected() service == null", new Object[] { this.cVs });
          AppMethodBeat.o(125322);
          return;
        }
        paramAnonymousComponentName = b.a.P(paramAnonymousIBinder);
        c.dYD().put(this.cVs, paramAnonymousComponentName);
        ae.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected()", new Object[] { this.cVs });
        AppMethodBeat.o(125322);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(125323);
        c.dYD().remove(this.cVs);
        if (paramBoolean) {
          c.b(this.cVs, false, paramIntent);
        }
        ae.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceDisconnected()", new Object[] { this.cVs });
        e.ywz.idkeyStat(963L, 4L, 1L, false);
        AppMethodBeat.o(125323);
      }
    }, 1);
    ae.i("MicroMsg.MMServiceHelper", "startProcessService() processName = %s", new Object[] { paramString });
    AppMethodBeat.o(125328);
  }
  
  private static void h(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(125329);
    if (aTd(paramString)) {
      try
      {
        paramContext.startService(paramIntent);
        AppMethodBeat.o(125329);
        return;
      }
      catch (Exception paramContext)
      {
        ae.i("MicroMsg.MMServiceHelper", "startProcessService() Exception:%s %s", new Object[] { paramContext.getClass().toString(), paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(125329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.c
 * JD-Core Version:    0.7.0.1
 */