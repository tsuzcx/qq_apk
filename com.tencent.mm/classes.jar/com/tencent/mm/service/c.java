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
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static ConcurrentHashMap<Integer, IBinder.DeathRecipient> acwA;
  private static ConcurrentHashMap<String, b> acwv;
  private static Vector<Intent> acww;
  private static Vector<Intent> acwx;
  private static ConcurrentHashMap<Integer, String> acwy;
  private static ConcurrentHashMap<Integer, IBinder> acwz;
  
  static
  {
    AppMethodBeat.i(125331);
    acwv = new ConcurrentHashMap();
    acww = new Vector();
    acwx = new Vector();
    acwy = new ConcurrentHashMap();
    acwz = new ConcurrentHashMap();
    acwA = new ConcurrentHashMap();
    AppMethodBeat.o(125331);
  }
  
  public static void a(final Intent paramIntent1, final String paramString, final boolean paramBoolean, final Intent paramIntent2)
  {
    AppMethodBeat.i(125324);
    if (paramIntent1 == null)
    {
      Log.i("MicroMsg.MMServiceHelper", "startService Intent == null");
      AppMethodBeat.o(125324);
      return;
    }
    String str = paramIntent1.getComponent().getClassName();
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = null processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125324);
      return;
    }
    paramIntent1.putExtra("class_name", str);
    Object localObject = (b)acwv.get(paramString);
    if (localObject == null)
    {
      acww.add(paramIntent1);
      localObject = MMApplicationContext.getContext();
      i((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125310);
            f.Ozc.idkeyStat(963L, 2L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { c.this, paramString });
              AppMethodBeat.o(125310);
              return;
            }
            Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { c.this, paramString });
            if (!c.cqh().contains(paramIntent1))
            {
              AppMethodBeat.o(125310);
              return;
            }
            try
            {
              paramAnonymousComponentName = b.a.Y(paramAnonymousIBinder);
              paramAnonymousComponentName.startService(paramIntent1);
              c.hhB().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                f.Ozc.idkeyStat(963L, 5L, 1L, false);
                c.a(paramIntent1, paramString, false, paramIntent2);
              }
              f.Ozc.idkeyStat(963L, 3L, 1L, false);
              Log.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { c.this, paramString, paramAnonymousComponentName.getMessage(), Util.getStack() });
              return;
            }
            finally
            {
              c.cqh().remove(paramIntent1);
              AppMethodBeat.o(125310);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125311);
            c.hhB().remove(paramString);
            Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { c.this, paramString });
            f.Ozc.idkeyStat(963L, 4L, 1L, false);
            AppMethodBeat.o(125311);
          }
        }, 1)) });
        f.Ozc.idkeyStat(963L, 1L, 1L, false);
        Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        f.Ozc.idkeyStat(963L, 0L, 1L, false);
        AppMethodBeat.o(125324);
        return;
      }
      catch (Exception paramIntent1)
      {
        Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject).startService(paramIntent1);
        Log.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, startService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        f.Ozc.idkeyStat(963L, 6L, 1L, false);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          acwv.remove(paramString);
          if (paramBoolean)
          {
            a(paramIntent1, paramString, false, paramIntent2);
            f.Ozc.idkeyStat(963L, 5L, 1L, false);
          }
          Log.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), Util.getStack() });
        }
      }
    }
  }
  
  public static void a(final ServiceConnection paramServiceConnection, final String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(125327);
    if (paramServiceConnection == null)
    {
      Log.i("MicroMsg.MMServiceHelper", "unbindService ServiceConnection == null");
      AppMethodBeat.o(125327);
      return;
    }
    String str = (String)acwy.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    Object localObject1 = (IBinder)acwz.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    Object localObject2 = (IBinder.DeathRecipient)acwA.remove(Integer.valueOf(paramServiceConnection.hashCode()));
    if (localObject1 != null) {
      ((IBinder)localObject1).unlinkToDeath((IBinder.DeathRecipient)localObject2, 0);
    }
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.MMServiceHelper", "unbindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125327);
      return;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("class_name", str);
    ((Intent)localObject1).putExtra("service_connection", paramServiceConnection.hashCode());
    localObject2 = (b)acwv.get(paramString);
    if (localObject2 == null)
    {
      f.Ozc.idkeyStat(963L, 47L, 1L, false);
      localObject2 = MMApplicationContext.getContext();
      i((Context)localObject2, paramString, paramIntent);
    }
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject2).bindService(paramIntent, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125320);
            f.Ozc.idkeyStat(963L, 48L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { c.this, paramString });
              AppMethodBeat.o(125320);
              return;
            }
            Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { c.this, paramString });
            try
            {
              paramAnonymousComponentName = b.a.Y(paramAnonymousIBinder);
              paramAnonymousComponentName.ca(this.val$intent);
              c.hhB().put(paramString, paramAnonymousComponentName);
              AppMethodBeat.o(125320);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.a(paramServiceConnection, paramString, false, paramIntent);
                f.Ozc.idkeyStat(963L, 51L, 1L, false);
              }
              f.Ozc.idkeyStat(963L, 49L, 1L, false);
              Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { c.this, paramString, paramAnonymousComponentName.getMessage(), Util.getStack() });
              AppMethodBeat.o(125320);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125321);
            Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { c.this, paramString });
            c.hhB().remove(paramString);
            f.Ozc.idkeyStat(963L, 50L, 1L, false);
            AppMethodBeat.o(125321);
          }
        }, 1)) });
        Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s processName = %s", new Object[] { str, paramString });
        f.Ozc.idkeyStat(963L, 46L, 1L, false);
        AppMethodBeat.o(125327);
        return;
      }
      catch (Exception paramServiceConnection)
      {
        Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramServiceConnection.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject2).ca((Intent)localObject1);
        f.Ozc.idkeyStat(963L, 52L, 1L, false);
        Log.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, unbindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          acwv.remove(paramString);
          if (paramBoolean)
          {
            a(paramServiceConnection, paramString, false, paramIntent);
            f.Ozc.idkeyStat(963L, 51L, 1L, false);
          }
          Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), Util.getStack() });
        }
      }
    }
  }
  
  public static void a(String paramString, final boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(125328);
    Context localContext = MMApplicationContext.getContext();
    i(localContext, paramString, paramIntent);
    localContext.bindService(paramIntent, new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(125322);
        if (paramAnonymousIBinder == null)
        {
          Log.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected() service == null", new Object[] { c.this });
          AppMethodBeat.o(125322);
          return;
        }
        paramAnonymousComponentName = b.a.Y(paramAnonymousIBinder);
        c.hhB().put(c.this, paramAnonymousComponentName);
        Log.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected()", new Object[] { c.this });
        AppMethodBeat.o(125322);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(125323);
        c.hhB().remove(c.this);
        if (paramBoolean) {
          c.a(c.this, false, paramIntent);
        }
        Log.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceDisconnected()", new Object[] { c.this });
        f.Ozc.idkeyStat(963L, 4L, 1L, false);
        AppMethodBeat.o(125323);
      }
    }, 1);
    Log.i("MicroMsg.MMServiceHelper", "startProcessService() processName = %s", new Object[] { paramString });
    AppMethodBeat.o(125328);
  }
  
  public static boolean a(final Intent paramIntent1, final ServiceConnection paramServiceConnection, final int paramInt, final String paramString, final boolean paramBoolean, Intent paramIntent2)
  {
    AppMethodBeat.i(125326);
    if (paramIntent1 == null)
    {
      Log.i("MicroMsg.MMServiceHelper", "bindService Intent == null");
      AppMethodBeat.o(125326);
      return false;
    }
    final String str = paramIntent1.getComponent().getClassName();
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.MMServiceHelper", "bindService() processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125326);
      return false;
    }
    Object localObject = (b)acwv.get(paramString);
    paramIntent1.putExtra("class_name", str);
    paramIntent1.putExtra("service_connection", paramServiceConnection.hashCode());
    acwy.put(Integer.valueOf(paramServiceConnection.hashCode()), str);
    if (localObject == null)
    {
      f.Ozc.idkeyStat(963L, 32L, 1L, false);
      acwx.add(paramIntent1);
      localObject = MMApplicationContext.getContext();
      i((Context)localObject, paramString, paramIntent2);
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
            Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { c.this.getComponent().getClassName(), str, paramString });
            f.Ozc.idkeyStat(963L, 33L, 1L, false);
            if (!c.arR().contains(paramIntent1))
            {
              AppMethodBeat.o(125316);
              return;
            }
            if (paramAnonymousIBinder == null)
            {
              Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { c.this.getComponent().getClassName(), str, paramString });
              AppMethodBeat.o(125316);
              return;
            }
            try
            {
              paramAnonymousComponentName = b.a.Y(paramAnonymousIBinder);
              paramAnonymousComponentName.a(paramIntent1, new a.a()
              {
                public final void X(IBinder paramAnonymous2IBinder)
                {
                  AppMethodBeat.i(125315);
                  if (paramAnonymous2IBinder == null)
                  {
                    Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected() service == null", new Object[] { c.this.getComponent().getClassName(), c.3.this.acwB, c.3.this.sTB });
                    AppMethodBeat.o(125315);
                    return;
                  }
                  c.3.this.acwF.onServiceConnected(new ComponentName(MMApplicationContext.getContext(), c.3.this.acwB), paramAnonymous2IBinder);
                  c.iUF().put(Integer.valueOf(c.3.this.acwF.hashCode()), paramAnonymous2IBinder);
                  IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
                  {
                    public final void binderDied()
                    {
                      AppMethodBeat.i(125314);
                      c.3.this.acwF.onServiceDisconnected(new ComponentName(MMApplicationContext.getContext(), c.3.this.acwB));
                      Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.this.getComponent().getClassName(), c.3.this.acwB, c.3.this.sTB });
                      AppMethodBeat.o(125314);
                    }
                  };
                  c.iUG().put(Integer.valueOf(c.3.this.acwF.hashCode()), local1);
                  paramAnonymous2IBinder.linkToDeath(local1, 0);
                  Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.this.getComponent().getClassName(), c.3.this.acwB, c.3.this.sTB });
                  AppMethodBeat.o(125315);
                }
              });
              c.hhB().put(paramString, paramAnonymousComponentName);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.a(paramIntent1, paramServiceConnection, paramInt, paramString, false, c.this);
                f.Ozc.idkeyStat(963L, 36L, 1L, false);
              }
              Log.i("MicroMsg.MMServiceHelper", "bindService()  ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { c.this.getComponent().getClassName(), str, paramString, paramAnonymousComponentName.getMessage(), Util.getStack() });
              f.Ozc.idkeyStat(963L, 34L, 1L, false);
              return;
            }
            finally
            {
              c.arR().remove(paramIntent1);
              AppMethodBeat.o(125316);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125317);
            c.hhB().remove(paramString);
            Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { c.this.getComponent().getClassName(), str, paramString });
            f.Ozc.idkeyStat(963L, 35L, 1L, false);
            AppMethodBeat.o(125317);
          }
        }, 1);
        Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, Boolean.valueOf(paramBoolean) });
        Log.i("MicroMsg.MMServiceHelper", "bindService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        f.Ozc.idkeyStat(963L, 31L, 1L, false);
        AppMethodBeat.o(125326);
        return true;
      }
      catch (Exception paramIntent1)
      {
        Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s Context.bindService() Exception = %s", new Object[] { paramIntent2.getComponent().getClassName(), str, paramString, paramIntent1.getMessage() });
        continue;
      }
      f.Ozc.idkeyStat(963L, 37L, 1L, false);
      try
      {
        Log.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, bindService() ClassName = %s ProcessName = %s ", new Object[] { str, paramString });
        ((b)localObject).a(paramIntent1, new a.a()
        {
          public final void X(IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125319);
            Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.this.getComponent().getClassName(), str, paramString });
            if (paramAnonymousIBinder == null)
            {
              AppMethodBeat.o(125319);
              return;
            }
            paramServiceConnection.onServiceConnected(new ComponentName(MMApplicationContext.getContext(), str), paramAnonymousIBinder);
            c.iUF().put(Integer.valueOf(paramServiceConnection.hashCode()), paramAnonymousIBinder);
            paramAnonymousIBinder.linkToDeath(new IBinder.DeathRecipient()
            {
              public final void binderDied()
              {
                AppMethodBeat.i(125318);
                c.4.this.acwF.onServiceDisconnected(new ComponentName(MMApplicationContext.getContext(), c.4.this.acwB));
                Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", new Object[] { c.this.getComponent().getClassName(), c.4.this.acwB, c.4.this.sTB });
                AppMethodBeat.o(125318);
              }
            }, 0);
            AppMethodBeat.o(125319);
          }
        });
      }
      catch (Exception localException)
      {
        acwv.remove(paramString);
        if (paramBoolean)
        {
          a(paramIntent1, paramServiceConnection, paramInt, paramString, false, paramIntent2);
          f.Ozc.idkeyStat(963L, 36L, 1L, false);
        }
        Log.i("MicroMsg.MMServiceHelper", "bindService ClassName = %s ProcessName = %s exception = %s stack[%s]", new Object[] { str, paramString, localException.getMessage(), Util.getStack() });
      }
    }
  }
  
  public static void b(final Intent paramIntent1, final String paramString, final boolean paramBoolean, final Intent paramIntent2)
  {
    AppMethodBeat.i(125325);
    if (paramIntent1 == null)
    {
      Log.i("MicroMsg.MMServiceHelper", "stopService Intent == null");
      AppMethodBeat.o(125325);
      return;
    }
    String str = paramIntent1.getComponent().getClassName();
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = null processName = %s", new Object[] { paramString });
      AppMethodBeat.o(125325);
      return;
    }
    Object localObject = (b)acwv.get(paramString);
    paramIntent1.putExtra("class_name", str);
    if (localObject == null)
    {
      f.Ozc.idkeyStat(963L, 17L, 1L, false);
      localObject = MMApplicationContext.getContext();
      i((Context)localObject, paramString, paramIntent2);
    }
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s bindService_result = %b", new Object[] { str, paramString, Boolean.valueOf(((Context)localObject).bindService(paramIntent2, new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(125312);
            f.Ozc.idkeyStat(963L, 18L, 1L, false);
            if (paramAnonymousIBinder == null)
            {
              Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected() service == null", new Object[] { c.this, paramString });
              AppMethodBeat.o(125312);
              return;
            }
            Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected()", new Object[] { c.this, paramString });
            try
            {
              paramAnonymousComponentName = b.a.Y(paramAnonymousIBinder);
              paramAnonymousComponentName.bV(paramIntent1);
              c.hhB().put(paramString, paramAnonymousComponentName);
              AppMethodBeat.o(125312);
              return;
            }
            catch (Exception paramAnonymousComponentName)
            {
              if (paramBoolean)
              {
                c.b(paramIntent1, paramString, false, paramIntent2);
                f.Ozc.idkeyStat(963L, 21L, 1L, false);
              }
              Log.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", new Object[] { c.this, paramString, paramAnonymousComponentName.getMessage(), Util.getStack() });
              f.Ozc.idkeyStat(963L, 19L, 1L, false);
              AppMethodBeat.o(125312);
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(125313);
            c.hhB().remove(paramString);
            Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceDisconnected()", new Object[] { c.this, paramString });
            f.Ozc.idkeyStat(963L, 20L, 1L, false);
            AppMethodBeat.o(125313);
          }
        }, 1)) });
        Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s", new Object[] { str, paramString });
        f.Ozc.idkeyStat(963L, 16L, 1L, false);
        AppMethodBeat.o(125325);
        return;
      }
      catch (Exception paramIntent1)
      {
        Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", new Object[] { str, paramString, paramIntent1.getMessage() });
        continue;
      }
      try
      {
        ((b)localObject).bV(paramIntent1);
        f.Ozc.idkeyStat(963L, 22L, 1L, false);
        Log.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, stopService() ClassName = %s ProcessName = %s stack[%s]", new Object[] { str, paramString, Util.getStack() });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          acwv.remove(paramString);
          if (paramBoolean)
          {
            b(paramIntent1, paramString, false, paramIntent2);
            f.Ozc.idkeyStat(963L, 21L, 1L, false);
          }
          Log.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s exception = %s", new Object[] { str, paramString, localException.getMessage() });
        }
      }
    }
  }
  
  private static boolean but(String paramString)
  {
    AppMethodBeat.i(125330);
    if (!Util.isEqual(paramString, "mm"))
    {
      AppMethodBeat.o(125330);
      return false;
    }
    if (d.rb(26))
    {
      int i = MMApplicationContext.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0);
      Log.i("MicroMsg.MMServiceHelper", "ifTarget26StartServiceHuawei() huaweiEnable : %s", new Object[] { Integer.valueOf(i) });
      if (Util.isEqual(i, 0))
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
  
  private static void i(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(125329);
    if (but(paramString)) {
      try
      {
        paramContext.startService(paramIntent);
        AppMethodBeat.o(125329);
        return;
      }
      catch (Exception paramContext)
      {
        Log.i("MicroMsg.MMServiceHelper", "startProcessService() Exception:%s %s", new Object[] { paramContext.getClass().toString(), paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(125329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.service.c
 * JD-Core Version:    0.7.0.1
 */