package com.tencent.mm.recoveryv2;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract b a(h paramh);
  
  public abstract void a(Context paramContext, RecoveryCrash paramRecoveryCrash);
  
  public abstract void b(Context paramContext, RecoveryCrash paramRecoveryCrash);
  
  public static abstract class a
    implements b
  {
    protected h NBu;
    
    public final b a(h paramh)
    {
      this.NBu = paramh;
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
    private boolean gSF = false;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(193758);
      Intent localIntent = new Intent();
      Class localClass = guw();
      if (localClass == null)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "can not get target activity, skip");
        AppMethodBeat.o(193758);
        return;
      }
      try
      {
        a.a.log(4, "MicroMsg.recovery.callback", "start recovery activity, target = " + localClass.getName());
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.NBA.NBC);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.guD());
        localIntent.addFlags(276824064);
        paramRecoveryCrash = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramRecoveryCrash.axQ(), "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramRecoveryCrash.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.gSF = true;
        AppMethodBeat.o(193758);
        return;
      }
      catch (Exception paramContext)
      {
        a.w("MicroMsg.recovery.callback", "start activity fail", paramContext);
        AppMethodBeat.o(193758);
      }
    }
    
    public final void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(193759);
      if (!this.gSF)
      {
        a.a.log(5, "MicroMsg.recovery.callback", "do NOT suicide, bcs launching activity fail");
        AppMethodBeat.o(193759);
        return;
      }
      a.a.log(4, "MicroMsg.recovery.callback", "suicide when launch recovery activity");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, paramContext.axQ(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, paramContext.axQ(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramContext.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      AppMethodBeat.o(193759);
    }
    
    protected Class<? extends Activity> guw()
    {
      return null;
    }
  }
  
  public static class c
    extends b.a
  {
    private b NBv;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(193762);
      if (paramRecoveryCrash.NBA.NBC < this.NBu.NBK)
      {
        AppMethodBeat.o(193762);
        return;
      }
      int i;
      if (paramRecoveryCrash.NBA.NBC < this.NBu.NBL)
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
      for (this.NBv = new b.b()
          {
            protected final Class<? extends Activity> guw()
            {
              AppMethodBeat.i(193760);
              Class localClass = b.c.this.guw();
              if (localClass == null)
              {
                localClass = super.guw();
                AppMethodBeat.o(193760);
                return localClass;
              }
              AppMethodBeat.o(193760);
              return localClass;
            }
          };; this.NBv = new b.d()
          {
            protected final Class<? extends Service> gux()
            {
              AppMethodBeat.i(193761);
              Class localClass = b.c.this.gux();
              if (localClass == null)
              {
                localClass = super.gux();
                AppMethodBeat.o(193761);
                return localClass;
              }
              AppMethodBeat.o(193761);
              return localClass;
            }
          })
      {
        this.NBv.a(paramContext, paramRecoveryCrash);
        AppMethodBeat.o(193762);
        return;
        Object localObject = h.b.iO(paramContext);
        long l1 = System.currentTimeMillis();
        long l2 = ((h.b)localObject).NBR;
        if (l2 > 0L)
        {
          l2 = l1 - l2;
          if ((l2 > 0L) && (l2 <= ((h.b)localObject).NBS))
          {
            a.a.log(4, "MicroMsg.recovery.callback", "do NOT launch ui too frequently, interval = ".concat(String.valueOf(l2)));
            i = 0;
            if (i != 0) {
              break label347;
            }
            localObject = h.b.iO(paramContext);
            l1 = ((h.b)localObject).NBR;
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
          localObject = i.iQ(paramContext);
          ((i)localObject).NBY = false;
          ((i)localObject).NBZ = 1;
          ((i)localObject).save();
          a.a.log(4, "MicroMsg.recovery.callback", "launch activity");
          i = 1;
          break;
          ((h.b)localObject).NBR = l1;
          ((h.b)localObject).save();
          i = 1;
          break label156;
          label239:
          l2 = System.currentTimeMillis();
          long l3 = ((h.b)localObject).NBS;
          long l4 = l3 / 3L;
          if (l2 - (l1 - l4) >= l3)
          {
            a.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, YES!");
            ((h.b)localObject).NBR = l2;
            ((h.b)localObject).save();
            i = 1;
          }
          else
          {
            a.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, inc last ui launch time, delta = ".concat(String.valueOf(l4)));
            ((h.b)localObject).NBR = (l1 - l4);
            ((h.b)localObject).save();
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
      AppMethodBeat.i(193763);
      if (this.NBv != null) {
        this.NBv.b(paramContext, paramRecoveryCrash);
      }
      AppMethodBeat.o(193763);
    }
    
    protected Class<? extends Activity> guw()
    {
      return null;
    }
    
    protected Class<? extends Service> gux()
    {
      return null;
    }
  }
  
  public static class d
    extends b.a
  {
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(193764);
      Class localClass = gux();
      if (localClass == null)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "can not get target service, skip");
        AppMethodBeat.o(193764);
        return;
      }
      try
      {
        Intent localIntent = new Intent();
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.NBA.NBC);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.guD());
        paramContext.startService(localIntent);
        AppMethodBeat.o(193764);
        return;
      }
      catch (Exception paramContext)
      {
        a.w("MicroMsg.recovery.callback", "start service fail", paramContext);
        AppMethodBeat.o(193764);
      }
    }
    
    protected Class<? extends Service> gux()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.b
 * JD-Core Version:    0.7.0.1
 */