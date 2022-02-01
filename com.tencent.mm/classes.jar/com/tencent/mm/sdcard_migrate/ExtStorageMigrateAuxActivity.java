package com.tencent.mm.sdcard_migrate;

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
  private static final Random acoU;
  private static final Set<Integer> acoV;
  private static WeakReference<ExtStorageMigrateAuxActivity> acoW;
  private static Context acoX;
  private final Map<Integer, c> acoY;
  private final Map<Integer, b> acoZ;
  private c acpa;
  private boolean acpb;
  private a acpc;
  private AuxMigrateResultCallback acpd;
  private boolean acpe;
  
  static
  {
    AppMethodBeat.i(176060);
    acoU = new Random();
    acoV = new HashSet(5);
    acoW = null;
    acoX = null;
    AppMethodBeat.o(176060);
  }
  
  public ExtStorageMigrateAuxActivity()
  {
    AppMethodBeat.i(176049);
    this.acoY = new HashMap();
    this.acoZ = new HashMap();
    this.acpa = null;
    this.acpb = false;
    this.acpc = new a(this, false);
    this.acpd = new AuxMigrateResultCallback(this);
    this.acpe = false;
    AppMethodBeat.o(176049);
  }
  
  /* Error */
  private void Ku(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 127
    //   4: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:acpa	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   11: ifnull +20 -> 31
    //   14: aload_0
    //   15: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:acpa	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   18: invokevirtual 133	com/tencent/mm/sdcard_migrate/a/c:isShowing	()Z
    //   21: ifeq +10 -> 31
    //   24: aload_0
    //   25: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:acpa	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   28: invokevirtual 136	com/tencent/mm/sdcard_migrate/a/c:dismiss	()V
    //   31: aload_0
    //   32: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:acpc	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
    //   35: invokestatic 139	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;)Lcom/tencent/mm/sdcard_migrate/e;
    //   38: astore 4
    //   40: iload_3
    //   41: istore_2
    //   42: aload 4
    //   44: ifnull +29 -> 73
    //   47: iload_3
    //   48: istore_2
    //   49: aload 4
    //   51: invokeinterface 145 1 0
    //   56: invokeinterface 150 1 0
    //   61: ifeq +12 -> 73
    //   64: aload 4
    //   66: invokeinterface 153 1 0
    //   71: iconst_1
    //   72: istore_2
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:acpc	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
    //   78: invokevirtual 157	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:unbindService	(Landroid/content/ServiceConnection;)V
    //   81: iload_2
    //   82: ifne +9 -> 91
    //   85: getstatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:acoX	Landroid/content/Context;
    //   88: invokestatic 163	com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine:cancelMigration	(Landroid/content/Context;)V
    //   91: invokestatic 168	com/tencent/mm/sdcard_migrate/b:iTi	()V
    //   94: iload_1
    //   95: ifeq +11 -> 106
    //   98: aload_0
    //   99: invokestatic 171	com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine:startWeChat	(Landroid/content/Context;)V
    //   102: aload_0
    //   103: invokevirtual 174	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:finish	()V
    //   106: ldc 127
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
    //   112	1	4	localObject1	Object
    //   119	1	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   64	71	112	finally
    //   73	81	119	finally
  }
  
  private void axX(int paramInt)
  {
    AppMethodBeat.i(176055);
    acoV.remove(Integer.valueOf(paramInt));
    this.acoY.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(176055);
  }
  
  private static int iSH()
  {
    AppMethodBeat.i(176054);
    int i;
    do
    {
      int j = (int)(acoU.nextInt() + (System.nanoTime() & 0xFFFFFFFF));
      i = j;
      if (j < 0) {
        i = -j;
      }
    } while ((i == 0) || (acoV.contains(Integer.valueOf(i))));
    acoV.add(Integer.valueOf(i));
    AppMethodBeat.o(176054);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(176057);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = (b)this.acoZ.get(Integer.valueOf(paramInt1));
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.iSO().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(176057);
      return;
    }
    paramIntent.iSJ();
    acoV.remove(Integer.valueOf(paramInt1));
    this.acoZ.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(176057);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(176050);
    super.onCreate(paramBundle);
    ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onCreate called. object: %s", new Object[] { this });
    acoX = getApplicationContext();
    LocaleUtil.initLanguage(this);
    setContentView(f.e.migrate_aux_activity);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (acoW != null) {}
    for (paramBundle = (ExtStorageMigrateAuxActivity)acoW.get();; paramBundle = null)
    {
      if ((paramBundle != null) && (!paramBundle.isFinishing()) && (!paramBundle.isDestroyed()))
      {
        if (paramBundle != this)
        {
          ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Duplicated instance. [latest: %s, prev: %s] Finish latest one.", new Object[] { this, paramBundle });
          finish();
          AppMethodBeat.o(176050);
        }
      }
      else {
        acoW = new WeakReference(this);
      }
      acoV.clear();
      this.acoY.clear();
      this.acoZ.clear();
      if (this.acpa != null)
      {
        this.acpa.dismiss();
        this.acpa = null;
      }
      this.acpb = false;
      this.acpe = false;
      AppMethodBeat.o(176050);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(176053);
    ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onDestroy called. object: %s", new Object[] { this });
    super.onDestroy();
    if (this.acpa != null)
    {
      this.acpa.dismiss();
      this.acpa = null;
    }
    Ku(false);
    this.acoZ.clear();
    this.acoY.clear();
    ExtStorageMigrateMonitor.iSR();
    AppMethodBeat.o(176053);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(176051);
    ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onNewIntent called. object: %s", new Object[] { this });
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(176051);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = true;
    AppMethodBeat.i(176056);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c localc = (c)this.acoY.get(Integer.valueOf(paramInt));
    if (localc == null)
    {
      ExtStorageMigrateMonitor.iSO().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt) });
      finish();
      AppMethodBeat.o(176056);
      return;
    }
    axX(paramInt);
    if (paramArrayOfString.length == 0)
    {
      ExtStorageMigrateMonitor.iSO().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] permissions array is empty.", new Object[0]);
      axX(paramInt);
      AppMethodBeat.o(176056);
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    if (paramArrayOfInt[0] == 0)
    {
      localc.bTw();
      AppMethodBeat.o(176056);
      return;
    }
    if (!androidx.core.app.a.a(this, paramArrayOfString)) {}
    for (;;)
    {
      localc.eb(paramArrayOfString, bool);
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
    if (!this.acpb)
    {
      this.acpb = true;
      localIntent = getIntent();
      if (localIntent == null)
      {
        ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income intent is null.", new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
      }
      str = localIntent.getAction();
      if (TextUtils.isEmpty(str))
      {
        ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income action is null or empty.", new Object[0]);
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
        ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Unknown action: ".concat(String.valueOf(str)), new Object[0]);
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
      ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Do not need to do migration, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (b.iTe())
    {
      ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates we should go on normal startup, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (localIntent.getBooleanExtra("auxui_param_is_migration_end", false))
    {
      ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates last migration is end, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    b.iTh();
    ExtStorageMigrateRoutine.startupMigrationService(this);
    this.acpe = ExtStorageMigrateRoutine.bindMigrationService(this, this.acpc);
    if (!this.acpe)
    {
      ExtStorageMigrateMonitor.iSO().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to bind to migrate service, startup WeChat next.", new Object[0]);
      Ku(true);
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
    private final WeakReference<ExtStorageMigrateAuxActivity> acpm;
    private int acpn;
    
    AuxMigrateResultCallback(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity)
    {
      AppMethodBeat.i(257192);
      this.acpn = 0;
      this.acpm = new WeakReference(paramExtStorageMigrateAuxActivity);
      AppMethodBeat.o(257192);
    }
    
    private ExtStorageMigrateAuxActivity iSK()
    {
      AppMethodBeat.i(257198);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.acpm.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(257198);
        return null;
      }
      AppMethodBeat.o(257198);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
    {
      AppMethodBeat.i(257238);
      switch (paramInt)
      {
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity;
      for (;;)
      {
        localExtStorageMigrateAuxActivity = iSK();
        if (localExtStorageMigrateAuxActivity != null) {
          break;
        }
        AppMethodBeat.o(257238);
        return;
        ExtStorageMigrateMonitor.yy(109L);
        continue;
        ExtStorageMigrateMonitor.yy(110L);
        continue;
        ExtStorageMigrateMonitor.yy(111L);
        continue;
        ExtStorageMigrateMonitor.yy(112L);
        continue;
        ExtStorageMigrateMonitor.yy(113L);
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      if (paramInt == 6) {}
      for (paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.axY(f.f.ext_storage_migration_dialog_interrupt_msg);; paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.axY(f.f.ext_storage_migration_dialog_failure_msg))
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.b(localExtStorageMigrateAuxActivity, paramExtStorageMigrateException, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(257102);
            paramAnonymousDialogInterface.dismiss();
            ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
            ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
            localExtStorageMigrateAuxActivity.finish();
            AppMethodBeat.o(257102);
          }
        }));
        AppMethodBeat.o(257238);
        return;
      }
    }
    
    public final void axZ(int paramInt)
    {
      AppMethodBeat.i(257222);
      if ((paramInt == 3) || (paramInt == 2)) {
        ExtStorageMigrateMonitor.yy(108L);
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = iSK();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(257222);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.b(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.axY(f.f.ext_storage_migration_dialog_cancel_msg), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(257103);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(257103);
        }
      }));
      AppMethodBeat.o(257222);
    }
    
    public final void aya(int paramInt)
    {
      AppMethodBeat.i(257231);
      Object localObject1 = iSK();
      if (localObject1 == null)
      {
        AppMethodBeat.o(257231);
        return;
      }
      Object localObject2;
      String str;
      if ((ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1) != null) && (ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).isShowing()))
      {
        localObject2 = String.format(ExtStorageMigrateAuxActivity.axY(f.f.ext_storage_migration_dialog_migrating_fmt), new Object[] { paramInt + "%" });
        str = null;
        switch (this.acpn)
        {
        }
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).setMessage((CharSequence)localObject2);
        localObject2 = ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1);
        ((c)localObject2).acrw.setVisibility(0);
        ((c)localObject2).acrp.setVisibility(0);
        localObject1 = str;
        if (((c)localObject2).acrG != null)
        {
          localObject1 = ((c)localObject2).acrG;
          ((c)localObject2).acro.getContext();
          str.toString();
          ((c)localObject2).acrp.getTextSize();
          localObject1 = ((c.a.c)localObject1).iTr();
        }
        ((c)localObject2).acrp.setText((CharSequence)localObject1);
        AppMethodBeat.o(257231);
        return;
        str = "—";
        this.acpn = 1;
        continue;
        str = "\\";
        this.acpn = 2;
        continue;
        str = "|";
        this.acpn = 3;
        continue;
        str = "/";
        this.acpn = 0;
      }
    }
    
    protected final void iSL()
    {
      AppMethodBeat.i(257214);
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = iSK();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(257214);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      Object localObject = ExtStorageMigrateAuxActivity.axY(f.f.ext_storage_migration_dialog_migrating_msg);
      String str = ExtStorageMigrateAuxActivity.axY(a.k.app_cancel);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(257109);
          ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click cancel on migrating dlg.", new Object[0]);
          ExtStorageMigrateAuxActivity.b(localExtStorageMigrateAuxActivity);
          AppMethodBeat.o(257109);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(257214);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.buk(null);
        locala.bul((String)localObject);
        locala.bum(str).a(local1);
        locala.KB(false);
        localObject = locala.iTq();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    public final void iSM()
    {
      AppMethodBeat.i(257243);
      ExtStorageMigrateMonitor.yy(107L);
      b.iTk();
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = iSK();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(257243);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.b(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.axY(f.f.ext_storage_migration_dialog_success_msg), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(257106);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(257106);
        }
      }));
      AppMethodBeat.o(257243);
    }
    
    public final void nP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257205);
      ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] MigrateCallback was overrided, old_attached_pid: %s, new_attached_pid: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(257205);
    }
  }
  
  static final class a
    implements ServiceConnection
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> acpm;
    private final boolean acpq;
    private e acpr;
    
    a(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(257179);
      this.acpm = new WeakReference(paramExtStorageMigrateAuxActivity);
      this.acpq = paramBoolean;
      this.acpr = null;
      AppMethodBeat.o(257179);
    }
    
    private ExtStorageMigrateAuxActivity iSK()
    {
      AppMethodBeat.i(257186);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.acpm.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(257186);
        return null;
      }
      AppMethodBeat.o(257186);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(257197);
      paramComponentName = iSK();
      if (paramComponentName != null)
      {
        ExtStorageMigrateAuxActivity.a(paramComponentName, true);
        this.acpr = e.a.W(paramIBinder);
        if (this.acpq)
        {
          ExtStorageMigrateAuxActivity.a(paramComponentName, this.acpr, false);
          AppMethodBeat.o(257197);
          return;
        }
        ExtStorageMigrateAuxActivity.a(paramComponentName, this.acpr);
        AppMethodBeat.o(257197);
        return;
      }
      ExtStorageMigrateMonitor.iSO().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to get aux ui instance in onServiceConnected", new Object[0]);
      AppMethodBeat.o(257197);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(257201);
      ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Service [%s] disconnected.", new Object[] { paramComponentName });
      paramComponentName = iSK();
      if (paramComponentName != null) {
        ExtStorageMigrateAuxActivity.a(paramComponentName, false);
      }
      AppMethodBeat.o(257201);
    }
  }
  
  static abstract interface b
  {
    public abstract void iSJ();
  }
  
  static abstract interface c
  {
    public abstract void bTw();
    
    public abstract void eb(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity
 * JD-Core Version:    0.7.0.1
 */