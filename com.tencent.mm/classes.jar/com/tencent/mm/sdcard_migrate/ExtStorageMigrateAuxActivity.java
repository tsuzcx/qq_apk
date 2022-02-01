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
  private static final Random GmS;
  private static final Set<Integer> GmT;
  private static WeakReference<ExtStorageMigrateAuxActivity> GmU;
  private static Context bQd;
  private final Map<Integer, c> GmV;
  private final Map<Integer, b> GmW;
  private c GmX;
  private boolean GmY;
  private a GmZ;
  private AuxMigrateResultCallback Gna;
  private boolean Gnb;
  
  static
  {
    AppMethodBeat.i(176060);
    GmS = new Random();
    GmT = new HashSet(5);
    GmU = null;
    bQd = null;
    AppMethodBeat.o(176060);
  }
  
  public ExtStorageMigrateAuxActivity()
  {
    AppMethodBeat.i(176049);
    this.GmV = new HashMap();
    this.GmW = new HashMap();
    this.GmX = null;
    this.GmY = false;
    this.GmZ = new a(this, false);
    this.Gna = new AuxMigrateResultCallback(this);
    this.Gnb = false;
    AppMethodBeat.o(176049);
  }
  
  private void Yc(int paramInt)
  {
    AppMethodBeat.i(176055);
    GmT.remove(Integer.valueOf(paramInt));
    this.GmV.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(176055);
  }
  
  private static int eTw()
  {
    AppMethodBeat.i(176054);
    int i;
    do
    {
      int j = (int)(GmS.nextInt() + (System.nanoTime() & 0xFFFFFFFF));
      i = j;
      if (j < 0) {
        i = -j;
      }
    } while ((i == 0) || (GmT.contains(Integer.valueOf(i))));
    GmT.add(Integer.valueOf(i));
    AppMethodBeat.o(176054);
    return i;
  }
  
  private void vH(boolean paramBoolean)
  {
    AppMethodBeat.i(195796);
    if ((this.GmX != null) && (this.GmX.isShowing())) {
      this.GmX.dismiss();
    }
    e locale = a.a(this.GmZ);
    if ((locale != null) && (locale.asBinder().isBinderAlive())) {}
    for (;;)
    {
      try
      {
        locale.eTO();
        i = 1;
        if (i == 0) {
          ExtStorageMigrateRoutine.cancelMigration(bQd);
        }
        b.eTV();
        if (paramBoolean)
        {
          ExtStorageMigrateRoutine.startWeChat(this);
          finish();
        }
        AppMethodBeat.o(195796);
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
    paramIntent = (b)this.GmW.get(Integer.valueOf(paramInt1));
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(176057);
      return;
    }
    paramIntent.eTx();
    GmT.remove(Integer.valueOf(paramInt1));
    this.GmW.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(176057);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(176050);
    super.onCreate(paramBundle);
    ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onCreate called. object: %s", new Object[] { this });
    bQd = getApplicationContext();
    setContentView(2131494757);
    if (GmU != null) {}
    for (paramBundle = (ExtStorageMigrateAuxActivity)GmU.get();; paramBundle = null)
    {
      if ((paramBundle != null) && (!paramBundle.isFinishing()) && (!paramBundle.isDestroyed()))
      {
        if (paramBundle != this)
        {
          ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Duplicated instance. [latest: %s, prev: %s] Finish latest one.", new Object[] { this, paramBundle });
          finish();
          AppMethodBeat.o(176050);
        }
      }
      else {
        GmU = new WeakReference(this);
      }
      GmT.clear();
      this.GmV.clear();
      this.GmW.clear();
      if (this.GmX != null)
      {
        this.GmX.dismiss();
        this.GmX = null;
      }
      this.GmY = false;
      this.Gnb = false;
      AppMethodBeat.o(176050);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(176053);
    ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onDestroy called. object: %s", new Object[] { this });
    super.onDestroy();
    if (this.GmX != null)
    {
      this.GmX.dismiss();
      this.GmX = null;
    }
    this.GmW.clear();
    this.GmV.clear();
    try
    {
      if (this.Gnb)
      {
        ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] unbind called.", new Object[0]);
        unbindService(this.GmZ);
        this.Gnb = false;
      }
      ExtStorageMigrateMonitor.eTF();
      AppMethodBeat.o(176053);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.ExtStorageMigrateAuxActivity", localThrowable, "[-] Exception occurred.", new Object[0]);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(176051);
    ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onNewIntent called. object: %s", new Object[] { this });
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(176051);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = true;
    AppMethodBeat.i(176056);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c localc = (c)this.GmV.get(Integer.valueOf(paramInt));
    if (localc == null)
    {
      ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt) });
      finish();
      AppMethodBeat.o(176056);
      return;
    }
    Yc(paramInt);
    if (paramArrayOfString.length == 0)
    {
      ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] permissions array is empty.", new Object[0]);
      Yc(paramInt);
      AppMethodBeat.o(176056);
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    if (paramArrayOfInt[0] == 0)
    {
      localc.aNf();
      AppMethodBeat.o(176056);
      return;
    }
    if (!android.support.v4.app.a.a(this, paramArrayOfString)) {}
    for (;;)
    {
      localc.cC(paramArrayOfString, bool);
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
    if (!this.GmY)
    {
      this.GmY = true;
      localIntent = getIntent();
      if (localIntent == null)
      {
        ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income intent is null.", new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
      }
      str = localIntent.getAction();
      if (TextUtils.isEmpty(str))
      {
        ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income action is null or empty.", new Object[0]);
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
        ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Unknown action: ".concat(String.valueOf(str)), new Object[0]);
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
      ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Do not need to do migration, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (b.eTR())
    {
      ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates we should go on normal startup, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (localIntent.getBooleanExtra("auxui_param_is_migration_end", false))
    {
      ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates last migration is end, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    b.eTU();
    ExtStorageMigrateRoutine.startupMigrationService(this);
    this.Gnb = ExtStorageMigrateRoutine.bindMigrationService(this, this.GmZ);
    if (!this.Gnb) {
      ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to bind to migrate service, startup WeChat next.", new Object[0]);
    }
    try
    {
      unbindService(this.GmZ);
      label365:
      vH(true);
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
    private final WeakReference<ExtStorageMigrateAuxActivity> Gnj;
    private int Gnk;
    
    AuxMigrateResultCallback(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity)
    {
      AppMethodBeat.i(195785);
      this.Gnk = 0;
      this.Gnj = new WeakReference(paramExtStorageMigrateAuxActivity);
      AppMethodBeat.o(195785);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity eTy()
    {
      AppMethodBeat.i(195786);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.Gnj.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(195786);
        return null;
      }
      AppMethodBeat.o(195786);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void Yd(int paramInt)
    {
      AppMethodBeat.i(195789);
      if ((paramInt == 3) || (paramInt == 2)) {
        ExtStorageMigrateMonitor.as(1315L, 108L);
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = eTy();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(195789);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, localExtStorageMigrateAuxActivity.getString(2131758657), localExtStorageMigrateAuxActivity.getString(2131758669), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(195782);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(195782);
        }
      }));
      AppMethodBeat.o(195789);
    }
    
    public final void Ye(int paramInt)
    {
      AppMethodBeat.i(195790);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = eTy();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(195790);
        return;
      }
      String str;
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing()))
      {
        str = String.format(localExtStorageMigrateAuxActivity.getString(2131758663), new Object[] { paramInt + "%" });
        switch (this.Gnk)
        {
        }
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).setMessage(str);
        AppMethodBeat.o(195790);
        return;
        str = str + " —";
        this.Gnk = 1;
        continue;
        str = str + " \\";
        this.Gnk = 2;
        continue;
        str = str + " |";
        this.Gnk = 3;
        continue;
        str = str + " /";
        this.Gnk = 0;
      }
    }
    
    public final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
    {
      AppMethodBeat.i(195791);
      switch (paramInt)
      {
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity;
      for (;;)
      {
        localExtStorageMigrateAuxActivity = eTy();
        if (localExtStorageMigrateAuxActivity != null) {
          break;
        }
        AppMethodBeat.o(195791);
        return;
        ExtStorageMigrateMonitor.as(1315L, 109L);
        continue;
        ExtStorageMigrateMonitor.as(1315L, 110L);
        continue;
        ExtStorageMigrateMonitor.as(1315L, 111L);
        continue;
        ExtStorageMigrateMonitor.as(1315L, 112L);
        continue;
        ExtStorageMigrateMonitor.as(1315L, 113L);
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
            AppMethodBeat.i(195783);
            paramAnonymousDialogInterface.dismiss();
            ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
            ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
            localExtStorageMigrateAuxActivity.finish();
            AppMethodBeat.o(195783);
          }
        }));
        AppMethodBeat.o(195791);
        return;
      }
    }
    
    public final void eTA()
    {
      AppMethodBeat.i(195792);
      ExtStorageMigrateMonitor.as(1315L, 107L);
      b.eTX();
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = eTy();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(195792);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      Object localObject = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(195784);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(195784);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(195792);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.GpN.title = locala.mContext.getString(2131758669);
        locala.GpN.GoE = locala.mContext.getString(2131758668);
        locala.eUc().a((DialogInterface.OnClickListener)localObject);
        locala.eUd();
        localObject = locala.eUe();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    protected final void eTz()
    {
      AppMethodBeat.i(195788);
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = eTy();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(195788);
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
          AppMethodBeat.i(195781);
          ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click cancel on migrating dlg.", new Object[0]);
          ExtStorageMigrateAuxActivity.b(localExtStorageMigrateAuxActivity);
          AppMethodBeat.o(195781);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(195788);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.aKn(str1);
        locala.aKo((String)localObject);
        locala.aKp(str2).a(local1);
        locala.eUd();
        localObject = locala.eUe();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    public final void jg(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195787);
      ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] MigrateCallback was overrided, old_attached_pid: %s, new_attached_pid: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(195787);
    }
  }
  
  static final class a
    implements ServiceConnection
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> Gnj;
    private final boolean Gnn;
    private e Gno;
    
    a(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(195793);
      this.Gnj = new WeakReference(paramExtStorageMigrateAuxActivity);
      this.Gnn = paramBoolean;
      this.Gno = null;
      AppMethodBeat.o(195793);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(195794);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.Gnj.get();
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
        this.Gno = e.a.M(paramIBinder);
        if (this.Gnn)
        {
          ExtStorageMigrateAuxActivity.a(paramComponentName, this.Gno, false);
          AppMethodBeat.o(195794);
          return;
        }
        ExtStorageMigrateAuxActivity.a(paramComponentName, this.Gno);
        AppMethodBeat.o(195794);
        return;
      }
      ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to get aux ui instance in onServiceConnected", new Object[0]);
      AppMethodBeat.o(195794);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(195795);
      ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Service [%s] disconnected.", new Object[] { paramComponentName });
      AppMethodBeat.o(195795);
    }
  }
  
  static abstract interface b
  {
    public abstract void eTx();
  }
  
  static abstract interface c
  {
    public abstract void aNf();
    
    public abstract void cC(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity
 * JD-Core Version:    0.7.0.1
 */