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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static ConcurrentHashMap<String, b> Gxg;
  private static Vector<Intent> Gxh;
  private static Vector<Intent> Gxi;
  private static ConcurrentHashMap<Integer, String> Gxj;
  private static ConcurrentHashMap<Integer, IBinder> Gxk;
  private static ConcurrentHashMap<Integer, IBinder.DeathRecipient> Gxl;
  
  static
  {
    AppMethodBeat.i(125331);
    Gxg = new ConcurrentHashMap();
    Gxh = new Vector();
    Gxi = new Vector();
    Gxj = new ConcurrentHashMap();
    Gxk = new ConcurrentHashMap();
    Gxl = new ConcurrentHashMap();
    AppMethodBeat.o(125331);
  }
  
  public static void a(final Intent paramIntent1, final String paramString, final boolean paramBoolean, final Intent paramIntent2)
  {
    AppMethodBeat.i(125324);
    if (paramIntent1 == null)
    {
      ac.i("MicroMsg.MMServiceHelper", "startService Intent == null");
      AppMethodBeat.o(125324);
      return;
    }
    String str = paramIntent1.getComponent().getClassName();
    if (bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.MMServiceHelper", "startService() ClassName = null processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125324);
      return;
    }
    paramIntent1.putExtra("class_name", str);
    Object localObject = (b)Gxg.get(paramString);
    if (localObject == null)
    {
      Gxh.add(paramIntent1);
      localObject = ai.getContext();
      g((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125310);
            e.wTc.idkeyStat(963L, 2L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ac.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.Gxm, paramString });
              AppMethodBeat.o(125310);
              return;
            }
            ac.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.Gxm, paramString });
            if (!c.bfa().contains(paramIntent1))
            {
              AppMethodBeat.o(125310);
              return;
            }
            try
            {
              paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
              paramAnonymousComponentName.aZ(paramIntent1);
              c.eXe().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                e.wTc.idkeyStat(963L, 5L, 1L, false);
                c.a(paramIntent1, paramString, false, paramIntent2);
              }
              e.wTc.idkeyStat(963L, 3L, 1L, false);
              ac.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { this.Gxm, paramString, paramAnonymousComponentName.getMessage(), bs.eWi() });
              return;
            }
            finally
            {
              c.bfa().remove(paramIntent1);
              AppMethodBeat.o(125310);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125311);
            c.eXe().remove(paramString);
            ac.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.Gxm, paramString });
            e.wTc.idkeyStat(963L, 4L, 1L, false);
            AppMethodBeat.o(125311);
          }
        }, 1)) });
        e.wTc.idkeyStat(963L, 1L, 1L, false);
        ac.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.wTc.idkeyStat(963L, 0L, 1L, false);
        AppMethodBeat.o(125324);
        return;
      }
      catch (Exception paramIntent1)
      {
        ac.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject).aZ(paramIntent1);
        ac.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, startService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        e.wTc.idkeyStat(963L, 6L, 1L, false);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Gxg.remove(paramString);
          if (paramBoolean)
          {
            a(paramIntent1, paramString, false, paramIntent2);
            e.wTc.idkeyStat(963L, 5L, 1L, false);
          }
          ac.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bs.eWi() });
        }
      }
    }
  }
  
  public static void a(final ServiceConnection paramServiceConnection, final String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(125327);
    if (paramServiceConnection == null)
    {
      ac.i("MicroMsg.MMServiceHelper", "unbindService ServiceConnection == null");
      AppMethodBeat.o(125327);
      return;
    }
    String str = (String)Gxj.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    Object localObject1 = (IBinder)Gxk.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    Object localObject2 = (IBinder.DeathRecipient)Gxl.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    if (localObject1 != null) {
      ((IBinder)localObject1).unlinkToDeath((IBinder.DeathRecipient)localObject2, 0);
    }
    if (bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.MMServiceHelper", "unbindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125327);
      return;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("class_name", str);
    ((Intent)localObject1).putExtra("service_connection", paramServiceConnection.hashCode());
    localObject2 = (b)Gxg.get(paramString);
    if (localObject2 == null)
    {
      e.wTc.idkeyStat(963L, 47L, 1L, false);
      localObject2 = ai.getContext();
      g((Context)localObject2, paramString, paramIntent);
    }
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject2).bindService(paramIntent, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125320);
            e.wTc.idkeyStat(963L, 48L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ac.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.Gxu, paramString });
              AppMethodBeat.o(125320);
              return;
            }
            ac.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.Gxu, paramString });
            try
            {
              paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
              paramAnonymousComponentName.bg(this.val$intent);
              c.eXe().put(paramString, paramAnonymousComponentName);
              AppMethodBeat.o(125320);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.a(paramServiceConnection, paramString, false, paramIntent);
                e.wTc.idkeyStat(963L, 51L, 1L, false);
              }
              e.wTc.idkeyStat(963L, 49L, 1L, false);
              ac.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.Gxu, paramString, paramAnonymousComponentName.getMessage(), bs.eWi() });
              AppMethodBeat.o(125320);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125321);
            ac.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.Gxu, paramString });
            c.eXe().remove(paramString);
            e.wTc.idkeyStat(963L, 50L, 1L, false);
            AppMethodBeat.o(125321);
          }
        }, 1)) });
        ac.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s processName = %s", new Object[] { str, paramString });
        e.wTc.idkeyStat(963L, 46L, 1L, false);
        AppMethodBeat.o(125327);
        return;
      }
      catch (Exception paramServiceConnection)
      {
        ac.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramServiceConnection.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject2).bg((Intent)localObject1);
        e.wTc.idkeyStat(963L, 52L, 1L, false);
        ac.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, unbindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Gxg.remove(paramString);
          if (paramBoolean)
          {
            a(paramServiceConnection, paramString, false, paramIntent);
            e.wTc.idkeyStat(963L, 51L, 1L, false);
          }
          ac.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bs.eWi() });
        }
      }
    }
  }
  
  public static boolean a(final Intent paramIntent1, final ServiceConnection paramServiceConnection, final int paramInt, final String paramString, final boolean paramBoolean, Intent paramIntent2)
  {
    AppMethodBeat.i(125326);
    if (paramIntent1 == null)
    {
      ac.i("MicroMsg.MMServiceHelper", "bindService Intent == null");
      AppMethodBeat.o(125326);
      return false;
    }
    final String str = paramIntent1.getComponent().getClassName();
    if (bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.MMServiceHelper", "bindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125326);
      return false;
    }
    Object localObject = (b)Gxg.get(paramString);
    paramIntent1.putExtra("class_name", str);
    paramIntent1.putExtra("service_connection", paramServiceConnection.hashCode());
    Gxj.put(Integer.valueOf(paramServiceConnection.hashCode()), str);
    if (localObject == null)
    {
      e.wTc.idkeyStat(963L, 32L, 1L, false);
      Gxi.add(paramIntent1);
      localObject = ai.getContext();
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
            ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.Gxp.getComponent().getClassName(), str, paramString });
            e.wTc.idkeyStat(963L, 33L, 1L, false);
            if (!c.eXf().contains(paramIntent1))
            {
              AppMethodBeat.o(125316);
              return;
            }
            if (paramAnonymousIBinder == null)
            {
              ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.Gxp.getComponent().getClassName(), str, paramString });
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
                    ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected() service == null", new Object[] { c.3.this.Gxp.getComponent().getClassName(), c.3.this.Gxm, c.3.this.lff });
                    AppMethodBeat.o(125315);
                    return;
                  }
                  c.3.this.Gxq.onServiceConnected(new ComponentName(ai.getContext(), c.3.this.Gxm), paramAnonymous2IBinder);
                  c.eXg().put(Integer.valueOf(c.3.this.Gxq.hashCode()), paramAnonymous2IBinder);
                  IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
                  {
                    public final void binderDied()
                    {
                      AppMethodBeat.i(125314);
                      c.3.this.Gxq.onServiceDisconnected(new ComponentName(ai.getContext(), c.3.this.Gxm));
                      ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.3.this.Gxp.getComponent().getClassName(), c.3.this.Gxm, c.3.this.lff });
                      AppMethodBeat.o(125314);
                    }
                  };
                  c.Gxl.put(Integer.valueOf(c.3.this.Gxq.hashCode()), local1);
                  paramAnonymous2IBinder.linkToDeath(local1, 0);
                  ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.3.this.Gxp.getComponent().getClassName(), c.3.this.Gxm, c.3.this.lff });
                  AppMethodBeat.o(125315);
                }
              });
              c.eXe().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.a(paramIntent1, paramServiceConnection, paramInt, paramString, false, this.Gxp);
                e.wTc.idkeyStat(963L, 36L, 1L, false);
              }
              ac.i("MicroMsg.MMServiceHelper", "bindService()  ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.Gxp.getComponent().getClassName(), str, paramString, paramAnonymousComponentName.getMessage(), bs.eWi() });
              e.wTc.idkeyStat(963L, 34L, 1L, false);
              return;
            }
            finally
            {
              c.eXf().remove(paramIntent1);
              AppMethodBeat.o(125316);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125317);
            c.eXe().remove(paramString);
            ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.Gxp.getComponent().getClassName(), str, paramString });
            e.wTc.idkeyStat(963L, 35L, 1L, false);
            AppMethodBeat.o(125317);
          }
        }, 1);
        ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, Boolean.valueOf(paramBoolean) });
        ac.i("MicroMsg.MMServiceHelper", "bindService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.wTc.idkeyStat(963L, 31L, 1L, false);
        AppMethodBeat.o(125326);
        return true;
      }
      catch (Exception paramIntent1)
      {
        ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s Context.bindService() Exception = %s", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, paramIntent1.getMessage() });
        continue;
      }
      e.wTc.idkeyStat(963L, 37L, 1L, false);
      try
      {
        ac.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, bindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        ((b)localObject).a(paramIntent1, new a.a()
        {
          public final void N(IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125319);
            ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { this.Gxp.getComponent().getClassName(), str, paramString });
            if (paramAnonymousIBinder == null)
            {
              AppMethodBeat.o(125319);
              return;
            }
            paramServiceConnection.onServiceConnected(new ComponentName(ai.getContext(), str), paramAnonymousIBinder);
            c.eXg().put(Integer.valueOf(paramServiceConnection.hashCode()), paramAnonymousIBinder);
            paramAnonymousIBinder.linkToDeath(new IBinder.DeathRecipient()
            {
              public final void binderDied()
              {
                AppMethodBeat.i(125318);
                c.4.this.Gxq.onServiceDisconnected(new ComponentName(ai.getContext(), c.4.this.Gxm));
                ac.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.4.this.Gxp.getComponent().getClassName(), c.4.this.Gxm, c.4.this.lff });
                AppMethodBeat.o(125318);
              }
            }, 0);
            AppMethodBeat.o(125319);
          }
        });
      }
      catch (Exception localException)
      {
        Gxg.remove(paramString);
        if (paramBoolean)
        {
          a(paramIntent1, paramServiceConnection, paramInt, paramString, false, paramIntent2);
          e.wTc.idkeyStat(963L, 36L, 1L, false);
        }
        ac.i("MicroMsg.MMServiceHelper", "bindService ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), bs.eWi() });
      }
    }
  }
  
  private static boolean aLZ(String paramString)
  {
    AppMethodBeat.i(125330);
    if (!bs.lr(paramString, "mm"))
    {
      AppMethodBeat.o(125330);
      return false;
    }
    if (d.kZ(26))
    {
      int i = ai.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0);
      ac.i("MicroMsg.MMServiceHelper", "ifTarget26StartServiceHuawei() huaweiEnable : %s", new Object[] { Integer.valueOf(i) });
      if (bs.jl(i, 0))
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
      ac.i("MicroMsg.MMServiceHelper", "stopService Intent == null");
      AppMethodBeat.o(125325);
      return;
    }
    String str = paramIntent1.getComponent().getClassName();
    if (bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.MMServiceHelper", "stopService() ClassName = null processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125325);
      return;
    }
    Object localObject = (b)Gxg.get(paramString);
    paramIntent1.putExtra("class_name", str);
    if (localObject == null)
    {
      e.wTc.idkeyStat(963L, 17L, 1L, false);
      localObject = ai.getContext();
      g((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125312);
            e.wTc.idkeyStat(963L, 18L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              ac.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { this.Gxm, paramString });
              AppMethodBeat.o(125312);
              return;
            }
            ac.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { this.Gxm, paramString });
            try
            {
              paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
              paramAnonymousComponentName.ba(paramIntent1);
              c.eXe().put(paramString, paramAnonymousComponentName);
              AppMethodBeat.o(125312);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.b(paramIntent1, paramString, false, paramIntent2);
                e.wTc.idkeyStat(963L, 21L, 1L, false);
              }
              ac.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { this.Gxm, paramString, paramAnonymousComponentName.getMessage(), bs.eWi() });
              e.wTc.idkeyStat(963L, 19L, 1L, false);
              AppMethodBeat.o(125312);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125313);
            c.eXe().remove(paramString);
            ac.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { this.Gxm, paramString });
            e.wTc.idkeyStat(963L, 20L, 1L, false);
            AppMethodBeat.o(125313);
          }
        }, 1)) });
        ac.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        e.wTc.idkeyStat(963L, 16L, 1L, false);
        AppMethodBeat.o(125325);
        return;
      }
      catch (Exception paramIntent1)
      {
        ac.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject).ba(paramIntent1);
        e.wTc.idkeyStat(963L, 22L, 1L, false);
        ac.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, stopService() ClassName = %s ProcessName = %s stack[%s]", new Object[] { str, paramString, bs.eWi() });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Gxg.remove(paramString);
          if (paramBoolean)
          {
            b(paramIntent1, paramString, false, paramIntent2);
            e.wTc.idkeyStat(963L, 21L, 1L, false);
          }
          ac.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s exception = %s", new Object[] { str, paramString, localException.getMessage() });
        }
      }
    }
  }
  
  public static void b(String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(125328);
    Context localContext = ai.getContext();
    g(localContext, paramString, paramIntent);
    localContext.bindService(paramIntent, new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(125322);
        if (paramAnonymousIBinder == null)
        {
          ac.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected() service == null", new Object[] { this.lff });
          AppMethodBeat.o(125322);
          return;
        }
        paramAnonymousComponentName = b.a.O(paramAnonymousIBinder);
        c.eXe().put(this.lff, paramAnonymousComponentName);
        ac.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected()", new Object[] { this.lff });
        AppMethodBeat.o(125322);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(125323);
        c.eXe().remove(this.lff);
        if (paramBoolean) {
          c.b(this.lff, false, paramIntent);
        }
        ac.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceDisconnected()", new Object[] { this.lff });
        e.wTc.idkeyStat(963L, 4L, 1L, false);
        AppMethodBeat.o(125323);
      }
    }, 1);
    ac.i("MicroMsg.MMServiceHelper", "startProcessService() processName = %s", new Object[] { paramString });
    AppMethodBeat.o(125328);
  }
  
  private static void g(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(125329);
    if (aLZ(paramString)) {
      try
      {
        paramContext.startService(paramIntent);
        AppMethodBeat.o(125329);
        return;
      }
      catch (Exception paramContext)
      {
        ac.i("MicroMsg.MMServiceHelper", "startProcessService() Exception:%s %s", new Object[] { paramContext.getClass().toString(), paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(125329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.c
 * JD-Core Version:    0.7.0.1
 */