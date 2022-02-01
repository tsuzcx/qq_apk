package com.tencent.mm.recoveryv2;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract b a(i parami);
  
  public abstract void a(Context paramContext, RecoveryCrash paramRecoveryCrash);
  
  public abstract void b(Context paramContext, RecoveryCrash paramRecoveryCrash);
  
  public static abstract class a
    implements b
  {
    protected i UOX;
    
    public final b a(i parami)
    {
      this.UOX = parami;
      return this;
    }
    
    public void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      a.a.log(4, "MicroMsg.recovery.callback", "recovery on terminate");
    }
  }
  
  public static class b
    extends b.a
  {
    private boolean jDf = false;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(189884);
      Intent localIntent = new Intent();
      Class localClass = hpU();
      if (localClass == null)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "can not get target activity, skip");
        AppMethodBeat.o(189884);
        return;
      }
      try
      {
        a.a.log(4, "MicroMsg.recovery.callback", "start recovery activity, target = " + localClass.getName());
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.UPd.UPf);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.hqe());
        localIntent.addFlags(276824064);
        paramRecoveryCrash = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramRecoveryCrash.aFh(), "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramRecoveryCrash.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.jDf = true;
        AppMethodBeat.o(189884);
        return;
      }
      catch (Exception paramContext)
      {
        a.w("MicroMsg.recovery.callback", "start activity fail", paramContext);
        AppMethodBeat.o(189884);
      }
    }
    
    public final void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(189890);
      if (!this.jDf)
      {
        a.a.log(5, "MicroMsg.recovery.callback", "do NOT suicide, bcs launching activity fail");
        AppMethodBeat.o(189890);
        return;
      }
      a.a.log(4, "MicroMsg.recovery.callback", "suicide when launch recovery activity");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramRecoveryCrash, paramContext.aFh(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecoveryCrash, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramRecoveryCrash, paramContext.aFh(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramContext.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecoveryCrash, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      AppMethodBeat.o(189890);
    }
    
    protected Class<? extends Activity> hpU()
    {
      return null;
    }
  }
  
  public static class c
    extends b.a
  {
    private b UOY;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(189915);
      if (paramRecoveryCrash.UPd.UPf < this.UOX.UPm)
      {
        AppMethodBeat.o(189915);
        return;
      }
      int i;
      if (paramRecoveryCrash.UPd.UPf < this.UOX.UPn)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "launch service for lower crash count");
        i = 0;
        if (i == 0) {
          break label360;
        }
      }
      label156:
      label334:
      label347:
      label360:
      for (this.UOY = new b.b()
          {
            protected final Class<? extends Activity> hpU()
            {
              AppMethodBeat.i(189896);
              Class localClass = b.c.this.hpU();
              if (localClass == null)
              {
                localClass = super.hpU();
                AppMethodBeat.o(189896);
                return localClass;
              }
              AppMethodBeat.o(189896);
              return localClass;
            }
          };; this.UOY = new b.d()
          {
            protected final Class<? extends Service> hpV()
            {
              AppMethodBeat.i(189903);
              Class localClass = b.c.this.hpV();
              if (localClass == null)
              {
                localClass = super.hpV();
                AppMethodBeat.o(189903);
                return localClass;
              }
              AppMethodBeat.o(189903);
              return localClass;
            }
          })
      {
        this.UOY.a(paramContext, paramRecoveryCrash);
        AppMethodBeat.o(189915);
        return;
        Object localObject = i.b.jR(paramContext);
        long l1 = System.currentTimeMillis();
        long l2 = ((i.b)localObject).UPt;
        if (l2 > 0L)
        {
          l2 = l1 - l2;
          if ((l2 > 0L) && (l2 <= ((i.b)localObject).UPu))
          {
            a.a.log(4, "MicroMsg.recovery.callback", "do NOT launch ui too frequently, interval = ".concat(String.valueOf(l2)));
            i = 0;
            if (i != 0) {
              break label347;
            }
            localObject = i.b.jR(paramContext);
            l1 = ((i.b)localObject).UPt;
            if (l1 > 0L) {
              break label239;
            }
            i = 0;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label334;
          }
          localObject = j.jT(paramContext);
          ((j)localObject).UPA = false;
          ((j)localObject).UPB = 1;
          ((j)localObject).arg();
          a.a.log(4, "MicroMsg.recovery.callback", "launch activity");
          i = 1;
          break;
          ((i.b)localObject).UPt = l1;
          ((i.b)localObject).arg();
          i = 1;
          break label156;
          label239:
          l2 = System.currentTimeMillis();
          long l3 = ((i.b)localObject).UPu;
          long l4 = l3 / 3L;
          if (l2 - (l1 - l4) >= l3)
          {
            a.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, YES!");
            ((i.b)localObject).UPt = l2;
            ((i.b)localObject).arg();
            i = 1;
          }
          else
          {
            a.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, inc last ui launch time, delta = ".concat(String.valueOf(l4)));
            ((i.b)localObject).UPt = (l1 - l4);
            ((i.b)localObject).arg();
            i = 0;
          }
        }
        a.a.log(4, "MicroMsg.recovery.callback", "launch service");
        i = 0;
        break;
        a.a.log(4, "MicroMsg.recovery.callback", "launch activity for higher crash count");
        i = 1;
        break;
      }
    }
    
    public final void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(189918);
      if (this.UOY != null) {
        this.UOY.b(paramContext, paramRecoveryCrash);
      }
      AppMethodBeat.o(189918);
    }
    
    protected Class<? extends Activity> hpU()
    {
      return null;
    }
    
    protected Class<? extends Service> hpV()
    {
      return null;
    }
  }
  
  public static class d
    extends b.a
  {
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(189930);
      Class localClass = hpV();
      if (localClass == null)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "can not get target service, skip");
        AppMethodBeat.o(189930);
        return;
      }
      try
      {
        Intent localIntent = new Intent();
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.UPd.UPf);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.hqe());
        paramContext.startService(localIntent);
        AppMethodBeat.o(189930);
        return;
      }
      catch (Exception paramContext)
      {
        a.w("MicroMsg.recovery.callback", "start service fail", paramContext);
        AppMethodBeat.o(189930);
      }
    }
    
    protected Class<? extends Service> hpV()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.b
 * JD-Core Version:    0.7.0.1
 */