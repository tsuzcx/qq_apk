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
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdcard_migrate.a.c;
import com.tencent.mm.sdcard_migrate.a.c.a;
import com.tencent.mm.sdcard_migrate.a.c.a.c;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
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
  private static final Random UTK;
  private static final Set<Integer> UTL;
  private static WeakReference<ExtStorageMigrateAuxActivity> UTM;
  private static Context UTN;
  private final Map<Integer, c> UTO;
  private final Map<Integer, b> UTP;
  private c UTQ;
  private boolean UTR;
  private a UTS;
  private AuxMigrateResultCallback UTT;
  private boolean UTU;
  
  static
  {
    AppMethodBeat.i(176060);
    UTK = new Random();
    UTL = new HashSet(5);
    UTM = null;
    UTN = null;
    AppMethodBeat.o(176060);
  }
  
  public ExtStorageMigrateAuxActivity()
  {
    AppMethodBeat.i(176049);
    this.UTO = new HashMap();
    this.UTP = new HashMap();
    this.UTQ = null;
    this.UTR = false;
    this.UTS = new a(this, false);
    this.UTT = new AuxMigrateResultCallback(this);
    this.UTU = false;
    AppMethodBeat.o(176049);
  }
  
  /* Error */
  private void EI(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 129
    //   4: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:UTQ	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   11: ifnull +20 -> 31
    //   14: aload_0
    //   15: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:UTQ	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   18: invokevirtual 135	com/tencent/mm/sdcard_migrate/a/c:isShowing	()Z
    //   21: ifeq +10 -> 31
    //   24: aload_0
    //   25: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:UTQ	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   28: invokevirtual 138	com/tencent/mm/sdcard_migrate/a/c:dismiss	()V
    //   31: aload_0
    //   32: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:UTS	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
    //   35: invokestatic 141	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;)Lcom/tencent/mm/sdcard_migrate/e;
    //   38: astore 4
    //   40: iload_3
    //   41: istore_2
    //   42: aload 4
    //   44: ifnull +29 -> 73
    //   47: iload_3
    //   48: istore_2
    //   49: aload 4
    //   51: invokeinterface 147 1 0
    //   56: invokeinterface 152 1 0
    //   61: ifeq +12 -> 73
    //   64: aload 4
    //   66: invokeinterface 155 1 0
    //   71: iconst_1
    //   72: istore_2
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:UTS	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
    //   78: invokevirtual 159	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:unbindService	(Landroid/content/ServiceConnection;)V
    //   81: iload_2
    //   82: ifne +9 -> 91
    //   85: getstatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:UTN	Landroid/content/Context;
    //   88: invokestatic 165	com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine:cancelMigration	(Landroid/content/Context;)V
    //   91: invokestatic 170	com/tencent/mm/sdcard_migrate/b:htc	()V
    //   94: iload_1
    //   95: ifeq +11 -> 106
    //   98: aload_0
    //   99: invokestatic 173	com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine:startWeChat	(Landroid/content/Context;)V
    //   102: aload_0
    //   103: invokevirtual 176	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:finish	()V
    //   106: ldc 129
    //   108: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: return
    //   112: astore 4
    //   114: iload_3
    //   115: istore_2
    //   116: goto -43 -> 73
    //   119: astore 4
    //   121: goto -40 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	ExtStorageMigrateAuxActivity
    //   0	124	1	paramBoolean	boolean
    //   41	75	2	i	int
    //   1	114	3	j	int
    //   38	27	4	locale	e
    //   112	1	4	localThrowable1	java.lang.Throwable
    //   119	1	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   64	71	112	java/lang/Throwable
    //   73	81	119	java/lang/Throwable
  }
  
  private void arS(int paramInt)
  {
    AppMethodBeat.i(176055);
    UTL.remove(Integer.valueOf(paramInt));
    this.UTO.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(176055);
  }
  
  private static int hsC()
  {
    AppMethodBeat.i(176054);
    int i;
    do
    {
      int j = (int)(UTK.nextInt() + (System.nanoTime() & 0xFFFFFFFF));
      i = j;
      if (j < 0) {
        i = -j;
      }
    } while ((i == 0) || (UTL.contains(Integer.valueOf(i))));
    UTL.add(Integer.valueOf(i));
    AppMethodBeat.o(176054);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(176057);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = (b)this.UTP.get(Integer.valueOf(paramInt1));
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.hsJ().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(176057);
      return;
    }
    paramIntent.hsE();
    UTL.remove(Integer.valueOf(paramInt1));
    this.UTP.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(176057);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(176050);
    super.onCreate(paramBundle);
    ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onCreate called. object: %s", new Object[] { this });
    UTN = getApplicationContext();
    LocaleUtil.initLanguage(this);
    setContentView(f.e.migrate_aux_activity);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (UTM != null) {}
    for (paramBundle = (ExtStorageMigrateAuxActivity)UTM.get();; paramBundle = null)
    {
      if ((paramBundle != null) && (!paramBundle.isFinishing()) && (!paramBundle.isDestroyed()))
      {
        if (paramBundle != this)
        {
          ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Duplicated instance. [latest: %s, prev: %s] Finish latest one.", new Object[] { this, paramBundle });
          finish();
          AppMethodBeat.o(176050);
        }
      }
      else {
        UTM = new WeakReference(this);
      }
      UTL.clear();
      this.UTO.clear();
      this.UTP.clear();
      if (this.UTQ != null)
      {
        this.UTQ.dismiss();
        this.UTQ = null;
      }
      this.UTR = false;
      this.UTU = false;
      AppMethodBeat.o(176050);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(176053);
    ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onDestroy called. object: %s", new Object[] { this });
    super.onDestroy();
    if (this.UTQ != null)
    {
      this.UTQ.dismiss();
      this.UTQ = null;
    }
    EI(false);
    this.UTP.clear();
    this.UTO.clear();
    ExtStorageMigrateMonitor.hsM();
    AppMethodBeat.o(176053);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(176051);
    ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onNewIntent called. object: %s", new Object[] { this });
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(176051);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = true;
    AppMethodBeat.i(176056);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c localc = (c)this.UTO.get(Integer.valueOf(paramInt));
    if (localc == null)
    {
      ExtStorageMigrateMonitor.hsJ().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt) });
      finish();
      AppMethodBeat.o(176056);
      return;
    }
    arS(paramInt);
    if (paramArrayOfString.length == 0)
    {
      ExtStorageMigrateMonitor.hsJ().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] permissions array is empty.", new Object[0]);
      arS(paramInt);
      AppMethodBeat.o(176056);
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    if (paramArrayOfInt[0] == 0)
    {
      localc.bvk();
      AppMethodBeat.o(176056);
      return;
    }
    if (!androidx.core.app.a.a(this, paramArrayOfString)) {}
    for (;;)
    {
      localc.dr(paramArrayOfString, bool);
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
    if (!this.UTR)
    {
      this.UTR = true;
      localIntent = getIntent();
      if (localIntent == null)
      {
        ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income intent is null.", new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
      }
      str = localIntent.getAction();
      if (TextUtils.isEmpty(str))
      {
        ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income action is null or empty.", new Object[0]);
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
        ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Unknown action: ".concat(String.valueOf(str)), new Object[0]);
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
      ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Do not need to do migration, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (b.hsY())
    {
      ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates we should go on normal startup, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (localIntent.getBooleanExtra("auxui_param_is_migration_end", false))
    {
      ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates last migration is end, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    b.htb();
    ExtStorageMigrateRoutine.startupMigrationService(this);
    this.UTU = ExtStorageMigrateRoutine.bindMigrationService(this, this.UTS);
    if (!this.UTU)
    {
      ExtStorageMigrateMonitor.hsJ().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to bind to migrate service, startup WeChat next.", new Object[0]);
      EI(true);
    }
    AppMethodBeat.o(176052);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class AuxMigrateResultCallback
    extends MigrateResultCallbackAdapter
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> UUc;
    private int UUd;
    
    AuxMigrateResultCallback(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity)
    {
      AppMethodBeat.i(192227);
      this.UUd = 0;
      this.UUc = new WeakReference(paramExtStorageMigrateAuxActivity);
      AppMethodBeat.o(192227);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity hsF()
    {
      AppMethodBeat.i(192233);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.UUc.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(192233);
        return null;
      }
      AppMethodBeat.o(192233);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
    {
      AppMethodBeat.i(192271);
      switch (paramInt)
      {
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity;
      for (;;)
      {
        localExtStorageMigrateAuxActivity = hsF();
        if (localExtStorageMigrateAuxActivity != null) {
          break;
        }
        AppMethodBeat.o(192271);
        return;
        ExtStorageMigrateMonitor.Um(109L);
        continue;
        ExtStorageMigrateMonitor.Um(110L);
        continue;
        ExtStorageMigrateMonitor.Um(111L);
        continue;
        ExtStorageMigrateMonitor.Um(112L);
        continue;
        ExtStorageMigrateMonitor.Um(113L);
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      if (paramInt == 6) {}
      for (paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.arT(f.f.ext_storage_migration_dialog_interrupt_msg);; paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.arT(f.f.ext_storage_migration_dialog_failure_msg))
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, paramExtStorageMigrateException, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(192020);
            paramAnonymousDialogInterface.dismiss();
            ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
            ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
            localExtStorageMigrateAuxActivity.finish();
            AppMethodBeat.o(192020);
          }
        }));
        AppMethodBeat.o(192271);
        return;
      }
    }
    
    public final void arU(int paramInt)
    {
      AppMethodBeat.i(192251);
      if ((paramInt == 3) || (paramInt == 2)) {
        ExtStorageMigrateMonitor.Um(108L);
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = hsF();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(192251);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.arT(f.f.ext_storage_migration_dialog_cancel_msg), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191775);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(191775);
        }
      }));
      AppMethodBeat.o(192251);
    }
    
    public final void arV(int paramInt)
    {
      AppMethodBeat.i(192264);
      Object localObject1 = hsF();
      if (localObject1 == null)
      {
        AppMethodBeat.o(192264);
        return;
      }
      Object localObject2;
      String str;
      if ((ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1) != null) && (ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).isShowing()))
      {
        localObject2 = String.format(ExtStorageMigrateAuxActivity.arT(f.f.ext_storage_migration_dialog_migrating_fmt), new Object[] { paramInt + "%" });
        str = null;
        switch (this.UUd)
        {
        }
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).setMessage((CharSequence)localObject2);
        localObject2 = ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1);
        ((c)localObject2).UWl.setVisibility(0);
        ((c)localObject2).UWe.setVisibility(0);
        localObject1 = str;
        if (((c)localObject2).UWv != null)
        {
          localObject1 = ((c)localObject2).UWv;
          ((c)localObject2).UWd.getContext();
          str.toString();
          ((c)localObject2).UWe.getTextSize();
          localObject1 = ((c.a.c)localObject1).htl();
        }
        ((c)localObject2).UWe.setText((CharSequence)localObject1);
        AppMethodBeat.o(192264);
        return;
        str = "—";
        this.UUd = 1;
        continue;
        str = "\\";
        this.UUd = 2;
        continue;
        str = "|";
        this.UUd = 3;
        continue;
        str = "/";
        this.UUd = 0;
      }
    }
    
    protected final void hsG()
    {
      AppMethodBeat.i(192246);
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = hsF();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(192246);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      Object localObject = ExtStorageMigrateAuxActivity.arT(f.f.ext_storage_migration_dialog_migrating_msg);
      String str = ExtStorageMigrateAuxActivity.arT(a.k.app_cancel);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191680);
          ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click cancel on migrating dlg.", new Object[0]);
          ExtStorageMigrateAuxActivity.b(localExtStorageMigrateAuxActivity);
          AppMethodBeat.o(191680);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(192246);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.bul(null);
        locala.bum((String)localObject);
        locala.bun(str).a(local1);
        locala.EP(false);
        localObject = locala.htk();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    public final void hsH()
    {
      AppMethodBeat.i(192275);
      ExtStorageMigrateMonitor.Um(107L);
      b.hte();
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = hsF();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(192275);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.arT(f.f.ext_storage_migration_dialog_success_msg), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191690);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(191690);
        }
      }));
      AppMethodBeat.o(192275);
    }
    
    public final void ma(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192235);
      ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] MigrateCallback was overrided, old_attached_pid: %s, new_attached_pid: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(192235);
    }
  }
  
  static final class a
    implements ServiceConnection
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> UUc;
    private final boolean UUg;
    private e UUh;
    
    a(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(191778);
      this.UUc = new WeakReference(paramExtStorageMigrateAuxActivity);
      this.UUg = paramBoolean;
      this.UUh = null;
      AppMethodBeat.o(191778);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity hsF()
    {
      AppMethodBeat.i(191781);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.UUc.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(191781);
        return null;
      }
      AppMethodBeat.o(191781);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(191787);
      paramComponentName = hsF();
      if (paramComponentName != null)
      {
        ExtStorageMigrateAuxActivity.a(paramComponentName, true);
        this.UUh = e.a.R(paramIBinder);
        if (this.UUg)
        {
          ExtStorageMigrateAuxActivity.a(paramComponentName, this.UUh, false);
          AppMethodBeat.o(191787);
          return;
        }
        ExtStorageMigrateAuxActivity.a(paramComponentName, this.UUh);
        AppMethodBeat.o(191787);
        return;
      }
      ExtStorageMigrateMonitor.hsJ().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to get aux ui instance in onServiceConnected", new Object[0]);
      AppMethodBeat.o(191787);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(191791);
      ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Service [%s] disconnected.", new Object[] { paramComponentName });
      paramComponentName = hsF();
      if (paramComponentName != null) {
        ExtStorageMigrateAuxActivity.a(paramComponentName, false);
      }
      AppMethodBeat.o(191791);
    }
  }
  
  static abstract interface b
  {
    public abstract void hsE();
  }
  
  static abstract interface c
  {
    public abstract void bvk();
    
    public abstract void dr(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity
 * JD-Core Version:    0.7.0.1
 */