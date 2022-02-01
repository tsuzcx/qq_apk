package com.tencent.mm.recoveryv2;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

public abstract interface a
{
  public abstract a a(h paramh);
  
  public abstract void a(Context paramContext, RecoveryCrash paramRecoveryCrash);
  
  public abstract void b(Context paramContext, RecoveryCrash paramRecoveryCrash);
  
  public static abstract class a
    implements a
  {
    protected h acjN;
    
    public final a a(h paramh)
    {
      this.acjN = paramh;
      return this;
    }
    
    public void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      k.b.a.log(4, "MicroMsg.recovery.callback", "recovery on terminate");
    }
  }
  
  public static class b
    extends a.a
  {
    private boolean mcT = false;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(238077);
      Intent localIntent = new Intent();
      Class localClass = iQy();
      if (localClass == null)
      {
        k.b.a.log(4, "MicroMsg.recovery.callback", "can not get target activity, skip");
        AppMethodBeat.o(238077);
        return;
      }
      try
      {
        k.b.a.log(4, "MicroMsg.recovery.callback", "start recovery activity, target = " + localClass.getName());
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.acjU.acjW);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.iQE());
        localIntent.addFlags(276824064);
        paramRecoveryCrash = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramRecoveryCrash.aYi(), "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramRecoveryCrash.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.mcT = true;
        AppMethodBeat.o(238077);
        return;
      }
      catch (Exception paramContext)
      {
        k.b.w("MicroMsg.recovery.callback", "start activity fail", paramContext);
        AppMethodBeat.o(238077);
      }
    }
    
    public final void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(238079);
      if (!this.mcT)
      {
        k.b.a.log(5, "MicroMsg.recovery.callback", "do NOT suicide, bcs launching activity fail");
        AppMethodBeat.o(238079);
        return;
      }
      k.b.a.log(4, "MicroMsg.recovery.callback", "suicide when launch recovery activity");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      paramContext = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramRecoveryCrash, paramContext.aYi(), "com/tencent/mm/recoveryv2/RecoveryUtils$Internals", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecoveryCrash, "com/tencent/mm/recoveryv2/RecoveryUtils$Internals", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      paramContext = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramRecoveryCrash, paramContext.aYi(), "com/tencent/mm/recoveryv2/RecoveryUtils$Internals", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramContext.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecoveryCrash, "com/tencent/mm/recoveryv2/RecoveryUtils$Internals", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      AppMethodBeat.o(238079);
    }
    
    protected Class<? extends Activity> iQy()
    {
      return null;
    }
  }
  
  public static class c
    extends a.a
  {
    private a acjO;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(238087);
      if (paramRecoveryCrash.acjU.acjW < this.acjN.ackd)
      {
        AppMethodBeat.o(238087);
        return;
      }
      int i;
      if (paramRecoveryCrash.acjU.acjW < this.acjN.acke)
      {
        k.b.a.log(4, "MicroMsg.recovery.callback", "launch service for lower crash count");
        i = 0;
        if (i == 0) {
          break label370;
        }
      }
      label166:
      label344:
      label357:
      label370:
      for (this.acjO = new a.b()
          {
            protected final Class<? extends Activity> iQy()
            {
              AppMethodBeat.i(238073);
              Class localClass = a.c.this.iQy();
              if (localClass == null)
              {
                localClass = super.iQy();
                AppMethodBeat.o(238073);
                return localClass;
              }
              AppMethodBeat.o(238073);
              return localClass;
            }
          };; this.acjO = new a.d()
          {
            protected final Class<? extends Service> iQz()
            {
              AppMethodBeat.i(238076);
              Class localClass = a.c.this.iQz();
              if (localClass == null)
              {
                localClass = super.iQz();
                AppMethodBeat.o(238076);
                return localClass;
              }
              AppMethodBeat.o(238076);
              return localClass;
            }
          })
      {
        this.acjO.a(paramContext, paramRecoveryCrash);
        AppMethodBeat.o(238087);
        return;
        Object localObject = h.b.lT(paramContext);
        long l1 = System.currentTimeMillis();
        long l2;
        if (((h.b)localObject).ackm > 0L)
        {
          l2 = ((h.b)localObject).ackk;
          if (l2 > 0L)
          {
            l2 = l1 - l2;
            if ((l2 > 0L) && (l2 <= ((h.b)localObject).ackl))
            {
              k.b.a.log(4, "MicroMsg.recovery.callback", "do NOT launch ui too frequently, interval = ".concat(String.valueOf(l2)));
              i = 0;
              if (i != 0) {
                break label357;
              }
              localObject = h.b.lT(paramContext);
              l1 = ((h.b)localObject).ackk;
              if (l1 > 0L) {
                break label249;
              }
              i = 0;
            }
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label344;
          }
          localObject = i.lV(paramContext);
          ((i)localObject).acks = false;
          ((i)localObject).ackt = 1;
          ((i)localObject).sz();
          k.b.a.log(4, "MicroMsg.recovery.callback", "launch activity");
          i = 1;
          break;
          ((h.b)localObject).ackk = l1;
          ((h.b)localObject).sz();
          i = 1;
          break label166;
          label249:
          l2 = System.currentTimeMillis();
          long l3 = ((h.b)localObject).ackl;
          long l4 = l3 / 3L;
          if (l2 - (l1 - l4) >= l3)
          {
            k.b.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, YES!");
            ((h.b)localObject).ackk = l2;
            ((h.b)localObject).sz();
            i = 1;
          }
          else
          {
            k.b.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, inc last ui launch time, delta = ".concat(String.valueOf(l4)));
            ((h.b)localObject).ackk = (l1 - l4);
            ((h.b)localObject).sz();
            i = 0;
          }
        }
        k.b.a.log(4, "MicroMsg.recovery.callback", "launch service");
        i = 0;
        break;
        k.b.a.log(4, "MicroMsg.recovery.callback", "launch activity for higher crash count");
        i = 1;
        break;
      }
    }
    
    public final void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(238098);
      if (this.acjO != null) {
        this.acjO.b(paramContext, paramRecoveryCrash);
      }
      AppMethodBeat.o(238098);
    }
    
    protected Class<? extends Activity> iQy()
    {
      return null;
    }
    
    protected Class<? extends Service> iQz()
    {
      return null;
    }
  }
  
  public static class d
    extends a.a
  {
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(238090);
      Class localClass = iQz();
      if (localClass == null)
      {
        k.b.a.log(4, "MicroMsg.recovery.callback", "can not get target service, skip");
        AppMethodBeat.o(238090);
        return;
      }
      try
      {
        Intent localIntent = new Intent();
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.acjU.acjW);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.iQE());
        return;
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext.startService(localIntent);
          AppMethodBeat.o(238090);
          return;
        }
        catch (Exception paramRecoveryCrash)
        {
          k.b.a.log(5, "MicroMsg.recovery.callback", "start service fail + " + paramRecoveryCrash.getMessage() + ", try bind service");
          paramContext.bindService(localIntent, new ServiceConnection()
          {
            public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
            {
              AppMethodBeat.i(238026);
              k.b.a.log(4, "MicroMsg.recovery.callback", "onServiceConnected");
              AppMethodBeat.o(238026);
            }
            
            public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
            {
              AppMethodBeat.i(238033);
              k.b.a.log(4, "MicroMsg.recovery.callback", "onServiceDisconnected");
              AppMethodBeat.o(238033);
            }
          }, 1);
          AppMethodBeat.o(238090);
        }
        paramContext = paramContext;
        k.b.w("MicroMsg.recovery.callback", "start service fail", paramContext);
        AppMethodBeat.o(238090);
        return;
      }
    }
    
    protected Class<? extends Service> iQz()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.a
 * JD-Core Version:    0.7.0.1
 */