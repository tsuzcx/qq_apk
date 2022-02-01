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
    protected h InW;
    
    public final b a(h paramh)
    {
      this.InW = paramh;
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
    private boolean gjn = false;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(195270);
      Intent localIntent = new Intent();
      Class localClass = fkK();
      if (localClass == null)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "can not get target activity, skip");
        AppMethodBeat.o(195270);
        return;
      }
      try
      {
        a.a.log(4, "MicroMsg.recovery.callback", "start recovery activity, target = " + localClass.getName());
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.Ioc.Ioe);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.fkS());
        localIntent.addFlags(276824064);
        paramRecoveryCrash = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramRecoveryCrash.ahE(), "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramRecoveryCrash.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.gjn = true;
        AppMethodBeat.o(195270);
        return;
      }
      catch (Exception paramContext)
      {
        a.w("MicroMsg.recovery.callback", "start activity fail", paramContext);
        AppMethodBeat.o(195270);
      }
    }
    
    public final void b(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(195271);
      if (!this.gjn)
      {
        a.a.log(5, "MicroMsg.recovery.callback", "do NOT suicide, bcs launching activity fail");
        AppMethodBeat.o(195271);
        return;
      }
      a.a.log(4, "MicroMsg.recovery.callback", "suicide when launch recovery activity");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, paramContext.ahE(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      paramRecoveryCrash = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, paramContext.ahE(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramContext.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramRecoveryCrash, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
      AppMethodBeat.o(195271);
    }
    
    protected Class<? extends Activity> fkK()
    {
      return null;
    }
  }
  
  public static class c
    extends b.a
  {
    private b InX;
    
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(195274);
      if (paramRecoveryCrash.Ioc.Ioe < this.InW.Iom)
      {
        AppMethodBeat.o(195274);
        return;
      }
      int i;
      if (paramRecoveryCrash.Ioc.Ioe < this.InW.Ion)
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
      for (this.InX = new b.b()
          {
            protected final Class<? extends Activity> fkK()
            {
              AppMethodBeat.i(195272);
              Class localClass = b.c.this.fkK();
              if (localClass == null)
              {
                localClass = super.fkK();
                AppMethodBeat.o(195272);
                return localClass;
              }
              AppMethodBeat.o(195272);
              return localClass;
            }
          };; this.InX = new b.d()
          {
            protected final Class<? extends Service> fkL()
            {
              AppMethodBeat.i(195273);
              Class localClass = b.c.this.fkL();
              if (localClass == null)
              {
                localClass = super.fkL();
                AppMethodBeat.o(195273);
                return localClass;
              }
              AppMethodBeat.o(195273);
              return localClass;
            }
          })
      {
        this.InX.a(paramContext, paramRecoveryCrash);
        AppMethodBeat.o(195274);
        return;
        Object localObject = h.b.hV(paramContext);
        long l1 = System.currentTimeMillis();
        long l2 = ((h.b)localObject).Iot;
        if (l2 > 0L)
        {
          l2 = l1 - l2;
          if ((l2 > 0L) && (l2 <= ((h.b)localObject).Iou))
          {
            a.a.log(4, "MicroMsg.recovery.callback", "do NOT launch ui too frequently, interval = ".concat(String.valueOf(l2)));
            i = 0;
            if (i != 0) {
              break label347;
            }
            localObject = h.b.hV(paramContext);
            l1 = ((h.b)localObject).Iot;
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
          localObject = i.hX(paramContext);
          ((i)localObject).IoA = false;
          ((i)localObject).IoB = 1;
          ((i)localObject).save();
          a.a.log(4, "MicroMsg.recovery.callback", "launch activity");
          i = 1;
          break;
          ((h.b)localObject).Iot = l1;
          ((h.b)localObject).save();
          i = 1;
          break label156;
          label239:
          l2 = System.currentTimeMillis();
          long l3 = ((h.b)localObject).Iou;
          long l4 = l3 / 3L;
          if (l2 - (l1 - l4) >= l3)
          {
            a.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, YES!");
            ((h.b)localObject).Iot = l2;
            ((h.b)localObject).save();
            i = 1;
          }
          else
          {
            a.a.log(4, "MicroMsg.recovery.callback", "#checkOverHeat, inc last ui launch time, delta = ".concat(String.valueOf(l4)));
            ((h.b)localObject).Iot = (l1 - l4);
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
      AppMethodBeat.i(195275);
      if (this.InX != null) {
        this.InX.b(paramContext, paramRecoveryCrash);
      }
      AppMethodBeat.o(195275);
    }
    
    protected Class<? extends Activity> fkK()
    {
      return null;
    }
    
    protected Class<? extends Service> fkL()
    {
      return null;
    }
  }
  
  public static class d
    extends b.a
  {
    public final void a(Context paramContext, RecoveryCrash paramRecoveryCrash)
    {
      AppMethodBeat.i(195276);
      Class localClass = fkL();
      if (localClass == null)
      {
        a.a.log(4, "MicroMsg.recovery.callback", "can not get target service, skip");
        AppMethodBeat.o(195276);
        return;
      }
      try
      {
        Intent localIntent = new Intent();
        localIntent.setClass(paramContext, localClass);
        localIntent.putExtra("extra_crash_count", paramRecoveryCrash.Ioc.Ioe);
        localIntent.putExtra("extra_crash_record", paramRecoveryCrash.fkS());
        paramContext.startService(localIntent);
        AppMethodBeat.o(195276);
        return;
      }
      catch (Exception paramContext)
      {
        a.w("MicroMsg.recovery.callback", "start service fail", paramContext);
        AppMethodBeat.o(195276);
      }
    }
    
    protected Class<? extends Service> fkL()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.b
 * JD-Core Version:    0.7.0.1
 */