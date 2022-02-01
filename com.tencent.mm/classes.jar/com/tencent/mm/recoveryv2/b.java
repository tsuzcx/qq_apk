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
    protected h HTO;
    
    public final b a(h paramh)
    {
      this.HTO = paramh;
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
    private boolean ggV = false;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(206962);
      Intent localIntent = new Intent();
      Class localClass = fgS();
      if (localClass == null)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "can not get target activity, skip");
        AppMethodBeat.o(206962);
        return;
      }
      try
      {
        a.a.log(4, "MicroMsg.recovery.callback", "start recovery activity, target = " + localClass.getName());
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.HTU.HTW);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.fha());
        localIntent.addFlags(276824064);
        paramRecoveryCrash = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramRecoveryCrash.ahp(), "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramRecoveryCrash.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.ggV = true;
        AppMethodBeat.o(206962);
        return;
      }
      catch (Exception paramContext)
      {
        a.w("MicroMsg.recovery.callback", "start activity fail", paramContext);
        AppMethodBeat.o(206962);
      }
    }
    
    public final void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(206963);
      if (!this.ggV)
      {
        a.a.log(5, "MicroMsg.recovery.callback", "do NOT suicide, bcs launching activity fail");
        AppMethodBeat.o(206963);
        return;
      }
      a.a.log(4, "MicroMsg.recovery.callback", "suicide when launch recovery activity");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, paramContext.ahp(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(10, new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, paramContext.ahp(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramContext.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      AppMethodBeat.o(206963);
    }
    
    protected Class<? extends Activity> fgS()
    {
      return null;
    }
  }
  
  public static class c
    extends b.a
  {
    private b HTP;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(206966);
      if (paramRecoveryCrash.HTU.HTW < this.HTO.HUe)
      {
        AppMethodBeat.o(206966);
        return;
      }
      int i;
      if (paramRecoveryCrash.HTU.HTW < this.HTO.HUf)
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
      for (this.HTP = new b.b()
          {
            protected final Class<? extends Activity> fgS()
            {
              AppMethodBeat.i(206964);
              Class localClass = b.c.this.fgS();
              if (localClass == null)
              {
                localClass = super.fgS();
                AppMethodBeat.o(206964);
                return localClass;
              }
              AppMethodBeat.o(206964);
              return localClass;
            }
          };; this.HTP = new b.d()
          {
            protected final Class<? extends Service> fgT()
            {
              AppMethodBeat.i(206965);
              Class localClass = b.c.this.fgT();
              if (localClass == null)
              {
                localClass = super.fgT();
                AppMethodBeat.o(206965);
                return localClass;
              }
              AppMethodBeat.o(206965);
              return localClass;
            }
          })
      {
        this.HTP.a(paramContext, paramRecoveryCrash);
        AppMethodBeat.o(206966);
        return;
        Object localObject = h.b.hP(paramContext);
        long l1 = System.currentTimeMillis();
        long l2 = ((h.b)localObject).HUl;
        if (l2 > 0L)
        {
          l2 = l1 - l2;
          if ((l2 > 0L) && (l2 <= ((h.b)localObject).HUm))
          {
            a.a.log(4, "MicroMsg.recovery.callback", "do NOT launch ui too frequently, interval = ".concat(String.valueOf(l2)));
            i = 0;
            if (i != 0) {
              break label347;
            }
            localObject = h.b.hP(paramContext);
            l1 = ((h.b)localObject).HUl;
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
          localObject = i.hR(paramContext);
          ((i)localObject).HUs = false;
          ((i)localObject).HUt = 1;
          ((i)localObject).save();
          a.a.log(4, "MicroMsg.recovery.callback", "launch activity");
          i = 1;
          break;
          ((h.b)localObject).HUl = l1;
          ((h.b)localObject).save();
          i = 1;
          break label156;
          label239:
          l2 = System.currentTimeMillis();
          long l3 = ((h.b)localObject).HUm;
          long l4 = l3 / 3L;
          if (l2 - (l1 - l4) >= l3)
          {
            a.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, YES!");
            ((h.b)localObject).HUl = l2;
            ((h.b)localObject).save();
            i = 1;
          }
          else
          {
            a.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, inc last ui launch time, delta = ".concat(String.valueOf(l4)));
            ((h.b)localObject).HUl = (l1 - l4);
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
      AppMethodBeat.i(206967);
      if (this.HTP != null) {
        this.HTP.b(paramContext, paramRecoveryCrash);
      }
      AppMethodBeat.o(206967);
    }
    
    protected Class<? extends Activity> fgS()
    {
      return null;
    }
    
    protected Class<? extends Service> fgT()
    {
      return null;
    }
  }
  
  public static class d
    extends b.a
  {
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(206968);
      Class localClass = fgT();
      if (localClass == null)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "can not get target service, skip");
        AppMethodBeat.o(206968);
        return;
      }
      try
      {
        Intent localIntent = new Intent();
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.HTU.HTW);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.fha());
        paramContext.startService(localIntent);
        AppMethodBeat.o(206968);
        return;
      }
      catch (Exception paramContext)
      {
        a.w("MicroMsg.recovery.callback", "start service fail", paramContext);
        AppMethodBeat.o(206968);
      }
    }
    
    protected Class<? extends Service> fgT()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.b
 * JD-Core Version:    0.7.0.1
 */