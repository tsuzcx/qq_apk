package com.tencent.mm.sdcard_migrate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdcard_migrate.a.c;
import com.tencent.mm.sdcard_migrate.a.c.a;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@com.tencent.mm.ui.base.a(7)
public class ExtStorageMigrateAuxActivity
  extends HellActivity
{
  private static final Random EPF;
  private static final Set<Integer> EPG;
  private static WeakReference<ExtStorageMigrateAuxActivity> EPH;
  private static Context bSv;
  private final Map<Integer, c> EPI;
  private final Map<Integer, b> EPJ;
  private c EPK;
  private boolean EPL;
  private a EPM;
  private AuxMigrateResultCallback EPN;
  private boolean EPO;
  
  static
  {
    AppMethodBeat.i(176060);
    EPF = new Random();
    EPG = new HashSet(5);
    EPH = null;
    bSv = null;
    AppMethodBeat.o(176060);
  }
  
  public ExtStorageMigrateAuxActivity()
  {
    AppMethodBeat.i(176049);
    this.EPI = new HashMap();
    this.EPJ = new HashMap();
    this.EPK = null;
    this.EPL = false;
    this.EPM = new a(this, false);
    this.EPN = new AuxMigrateResultCallback(this);
    this.EPO = false;
    AppMethodBeat.o(176049);
  }
  
  private void VT(int paramInt)
  {
    AppMethodBeat.i(176055);
    EPG.remove(Integer.valueOf(paramInt));
    this.EPI.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(176055);
  }
  
  private static int eEc()
  {
    AppMethodBeat.i(176054);
    int i;
    do
    {
      int j = (int)(EPF.nextInt() + (System.nanoTime() & 0xFFFFFFFF));
      i = j;
      if (j < 0) {
        i = -j;
      }
    } while ((i == 0) || (EPG.contains(Integer.valueOf(i))));
    EPG.add(Integer.valueOf(i));
    AppMethodBeat.o(176054);
    return i;
  }
  
  private void uF(boolean paramBoolean)
  {
    AppMethodBeat.i(196780);
    if ((this.EPK != null) && (this.EPK.isShowing())) {
      this.EPK.dismiss();
    }
    e locale = a.a(this.EPM);
    if ((locale != null) && (locale.asBinder().isBinderAlive())) {}
    for (;;)
    {
      try
      {
        locale.eEu();
        i = 1;
        if (i == 0) {
          ExtStorageMigrateRoutine.cancelMigration(bSv);
        }
        b.eEB();
        if (paramBoolean)
        {
          ExtStorageMigrateRoutine.startWeChat(this);
          finish();
        }
        AppMethodBeat.o(196780);
        return;
      }
      catch (Throwable localThrowable) {}
      int i = 0;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(176057);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = (b)this.EPJ.get(Integer.valueOf(paramInt1));
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(176057);
      return;
    }
    paramIntent.eEd();
    EPG.remove(Integer.valueOf(paramInt1));
    this.EPJ.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(176057);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(176050);
    super.onCreate(paramBundle);
    ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onCreate called. object: %s", new Object[] { this });
    bSv = getApplicationContext();
    setContentView(2131494757);
    if (EPH != null) {}
    for (paramBundle = (ExtStorageMigrateAuxActivity)EPH.get();; paramBundle = null)
    {
      if ((paramBundle != null) && (!paramBundle.isFinishing()) && (!paramBundle.isDestroyed()))
      {
        if (paramBundle != this)
        {
          ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Duplicated instance. [latest: %s, prev: %s] Finish latest one.", new Object[] { this, paramBundle });
          finish();
          AppMethodBeat.o(176050);
        }
      }
      else {
        EPH = new WeakReference(this);
      }
      EPG.clear();
      this.EPI.clear();
      this.EPJ.clear();
      if (this.EPK != null)
      {
        this.EPK.dismiss();
        this.EPK = null;
      }
      this.EPL = false;
      this.EPO = false;
      AppMethodBeat.o(176050);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(176053);
    ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onDestroy called. object: %s", new Object[] { this });
    super.onDestroy();
    if (this.EPK != null)
    {
      this.EPK.dismiss();
      this.EPK = null;
    }
    this.EPJ.clear();
    this.EPI.clear();
    try
    {
      if (this.EPO)
      {
        ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] unbind called.", new Object[0]);
        unbindService(this.EPM);
        this.EPO = false;
      }
      ExtStorageMigrateMonitor.eEl();
      AppMethodBeat.o(176053);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateAuxActivity", localThrowable, "[-] Exception occurred.", new Object[0]);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(176051);
    ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onNewIntent called. object: %s", new Object[] { this });
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(176051);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = true;
    AppMethodBeat.i(176056);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c localc = (c)this.EPI.get(Integer.valueOf(paramInt));
    if (localc == null)
    {
      ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt) });
      finish();
      AppMethodBeat.o(176056);
      return;
    }
    VT(paramInt);
    if (paramArrayOfString.length == 0)
    {
      ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] permissions array is empty.", new Object[0]);
      VT(paramInt);
      AppMethodBeat.o(176056);
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    if (paramArrayOfInt[0] == 0)
    {
      localc.aGs();
      AppMethodBeat.o(176056);
      return;
    }
    if (!android.support.v4.app.a.a(this, paramArrayOfString)) {}
    for (;;)
    {
      localc.cw(paramArrayOfString, bool);
      AppMethodBeat.o(176056);
      return;
      bool = false;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(176052);
    super.onResume();
    Intent localIntent;
    String str;
    int i;
    if (!this.EPL)
    {
      this.EPL = true;
      localIntent = getIntent();
      if (localIntent == null)
      {
        ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income intent is null.", new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
      }
      str = localIntent.getAction();
      if (TextUtils.isEmpty(str))
      {
        ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income action is null or empty.", new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
      }
      i = -1;
      switch (str.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Unknown action: ".concat(String.valueOf(str)), new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
        if (str.equals("auxui_action_do_migrate_routine")) {
          i = 0;
        }
        break;
      }
    }
    if (!ExtStorageMigrateRoutine.needsToDoMigrate(this))
    {
      ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Do not need to do migration, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (b.eEx())
    {
      ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates we should go on normal startup, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (localIntent.getBooleanExtra("auxui_param_is_migration_end", false))
    {
      ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates last migration is end, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    b.eEA();
    ExtStorageMigrateRoutine.startupMigrationService(this);
    this.EPO = ExtStorageMigrateRoutine.bindMigrationService(this, this.EPM);
    if (!this.EPO) {
      ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to bind to migrate service, startup WeChat next.", new Object[0]);
    }
    try
    {
      unbindService(this.EPM);
      label365:
      uF(true);
      AppMethodBeat.o(176052);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label365;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class AuxMigrateResultCallback
    extends MigrateResultCallbackAdapter
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> EPW;
    private int EPX;
    
    AuxMigrateResultCallback(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity)
    {
      AppMethodBeat.i(196769);
      this.EPX = 0;
      this.EPW = new WeakReference(paramExtStorageMigrateAuxActivity);
      AppMethodBeat.o(196769);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity eEe()
    {
      AppMethodBeat.i(196770);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.EPW.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(196770);
        return null;
      }
      AppMethodBeat.o(196770);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void VU(int paramInt)
    {
      AppMethodBeat.i(196773);
      if ((paramInt == 3) || (paramInt == 2)) {
        ExtStorageMigrateMonitor.at(1315L, 108L);
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = eEe();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(196773);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, localExtStorageMigrateAuxActivity.getString(2131758657), localExtStorageMigrateAuxActivity.getString(2131758669), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196766);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(196766);
        }
      }));
      AppMethodBeat.o(196773);
    }
    
    public final void VV(int paramInt)
    {
      AppMethodBeat.i(196774);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = eEe();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(196774);
        return;
      }
      String str;
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing()))
      {
        str = String.format(localExtStorageMigrateAuxActivity.getString(2131758663), new Object[] { paramInt + "%" });
        switch (this.EPX)
        {
        }
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).setMessage(str);
        AppMethodBeat.o(196774);
        return;
        str = str + " —";
        this.EPX = 1;
        continue;
        str = str + " \\";
        this.EPX = 2;
        continue;
        str = str + " |";
        this.EPX = 3;
        continue;
        str = str + " /";
        this.EPX = 0;
      }
    }
    
    public final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
    {
      AppMethodBeat.i(196775);
      switch (paramInt)
      {
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity;
      for (;;)
      {
        localExtStorageMigrateAuxActivity = eEe();
        if (localExtStorageMigrateAuxActivity != null) {
          break;
        }
        AppMethodBeat.o(196775);
        return;
        ExtStorageMigrateMonitor.at(1315L, 109L);
        continue;
        ExtStorageMigrateMonitor.at(1315L, 110L);
        continue;
        ExtStorageMigrateMonitor.at(1315L, 111L);
        continue;
        ExtStorageMigrateMonitor.at(1315L, 112L);
        continue;
        ExtStorageMigrateMonitor.at(1315L, 113L);
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      if (paramInt == 6) {}
      for (paramExtStorageMigrateException = localExtStorageMigrateAuxActivity.getString(2131758661);; paramExtStorageMigrateException = localExtStorageMigrateAuxActivity.getString(2131758659))
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, paramExtStorageMigrateException, localExtStorageMigrateAuxActivity.getString(2131758669), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(196767);
            paramAnonymousDialogInterface.dismiss();
            ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
            ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
            localExtStorageMigrateAuxActivity.finish();
            AppMethodBeat.o(196767);
          }
        }));
        AppMethodBeat.o(196775);
        return;
      }
    }
    
    protected final void eEf()
    {
      AppMethodBeat.i(196772);
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = eEe();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(196772);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      Object localObject = localExtStorageMigrateAuxActivity.getString(2131758664);
      String str1 = localExtStorageMigrateAuxActivity.getString(2131758669);
      String str2 = localExtStorageMigrateAuxActivity.getString(2131755691);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196765);
          ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click cancel on migrating dlg.", new Object[0]);
          ExtStorageMigrateAuxActivity.b(localExtStorageMigrateAuxActivity);
          AppMethodBeat.o(196765);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(196772);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.aEW(str1);
        locala.aEX((String)localObject);
        locala.aEY(str2).a(local1);
        locala.eEJ();
        localObject = locala.eEK();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    public final void eEg()
    {
      AppMethodBeat.i(196776);
      ExtStorageMigrateMonitor.at(1315L, 107L);
      b.eED();
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = eEe();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(196776);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      Object localObject = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196768);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(196768);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(196776);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.ESA.title = locala.mContext.getString(2131758669);
        locala.ESA.ERr = locala.mContext.getString(2131758668);
        locala.eEI().a((DialogInterface.OnClickListener)localObject);
        locala.eEJ();
        localObject = locala.eEK();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    public final void iT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196771);
      ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] MigrateCallback was overrided, old_attached_pid: %s, new_attached_pid: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(196771);
    }
  }
  
  static final class a
    implements ServiceConnection
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> EPW;
    private final boolean EQa;
    private e EQb;
    
    a(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(196777);
      this.EPW = new WeakReference(paramExtStorageMigrateAuxActivity);
      this.EQa = paramBoolean;
      this.EQb = null;
      AppMethodBeat.o(196777);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(196778);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.EPW.get();
      if ((localExtStorageMigrateAuxActivity != null) && (!localExtStorageMigrateAuxActivity.isFinishing()))
      {
        paramComponentName = localExtStorageMigrateAuxActivity;
        if (!localExtStorageMigrateAuxActivity.isDestroyed()) {}
      }
      else
      {
        paramComponentName = null;
      }
      if (paramComponentName != null)
      {
        this.EQb = e.a.M(paramIBinder);
        if (this.EQa)
        {
          ExtStorageMigrateAuxActivity.a(paramComponentName, this.EQb, false);
          AppMethodBeat.o(196778);
          return;
        }
        ExtStorageMigrateAuxActivity.a(paramComponentName, this.EQb);
        AppMethodBeat.o(196778);
        return;
      }
      ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to get aux ui instance in onServiceConnected", new Object[0]);
      AppMethodBeat.o(196778);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(196779);
      ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Service [%s] disconnected.", new Object[] { paramComponentName });
      AppMethodBeat.o(196779);
    }
  }
  
  static abstract interface b
  {
    public abstract void eEd();
  }
  
  static abstract interface c
  {
    public abstract void aGs();
    
    public abstract void cw(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity
 * JD-Core Version:    0.7.0.1
 */