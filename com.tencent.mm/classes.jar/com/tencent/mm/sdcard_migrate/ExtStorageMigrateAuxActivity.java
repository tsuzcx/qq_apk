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
  private static final Random NGk;
  private static final Set<Integer> NGl;
  private static WeakReference<ExtStorageMigrateAuxActivity> NGm;
  private static Context ckW;
  private final Map<Integer, c> NGn;
  private final Map<Integer, b> NGo;
  private c NGp;
  private boolean NGq;
  private a NGr;
  private AuxMigrateResultCallback NGs;
  private boolean NGt;
  
  static
  {
    AppMethodBeat.i(176060);
    NGk = new Random();
    NGl = new HashSet(5);
    NGm = null;
    ckW = null;
    AppMethodBeat.o(176060);
  }
  
  public ExtStorageMigrateAuxActivity()
  {
    AppMethodBeat.i(176049);
    this.NGn = new HashMap();
    this.NGo = new HashMap();
    this.NGp = null;
    this.NGq = false;
    this.NGr = new a(this, false);
    this.NGs = new AuxMigrateResultCallback(this);
    this.NGt = false;
    AppMethodBeat.o(176049);
  }
  
  /* Error */
  private void AB(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 129
    //   4: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:NGp	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   11: ifnull +20 -> 31
    //   14: aload_0
    //   15: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:NGp	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   18: invokevirtual 135	com/tencent/mm/sdcard_migrate/a/c:isShowing	()Z
    //   21: ifeq +10 -> 31
    //   24: aload_0
    //   25: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:NGp	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   28: invokevirtual 138	com/tencent/mm/sdcard_migrate/a/c:dismiss	()V
    //   31: aload_0
    //   32: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:NGr	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
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
    //   75: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:NGr	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
    //   78: invokevirtual 159	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:unbindService	(Landroid/content/ServiceConnection;)V
    //   81: iload_2
    //   82: ifne +9 -> 91
    //   85: getstatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:ckW	Landroid/content/Context;
    //   88: invokestatic 165	com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine:cancelMigration	(Landroid/content/Context;)V
    //   91: invokestatic 170	com/tencent/mm/sdcard_migrate/b:gxd	()V
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
  
  private void ajA(int paramInt)
  {
    AppMethodBeat.i(176055);
    NGl.remove(Integer.valueOf(paramInt));
    this.NGn.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(176055);
  }
  
  private static int gwD()
  {
    AppMethodBeat.i(176054);
    int i;
    do
    {
      int j = (int)(NGk.nextInt() + (System.nanoTime() & 0xFFFFFFFF));
      i = j;
      if (j < 0) {
        i = -j;
      }
    } while ((i == 0) || (NGl.contains(Integer.valueOf(i))));
    NGl.add(Integer.valueOf(i));
    AppMethodBeat.o(176054);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(176057);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = (b)this.NGo.get(Integer.valueOf(paramInt1));
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(176057);
      return;
    }
    paramIntent.gwF();
    NGl.remove(Integer.valueOf(paramInt1));
    this.NGo.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(176057);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(176050);
    super.onCreate(paramBundle);
    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onCreate called. object: %s", new Object[] { this });
    ckW = getApplicationContext();
    LocaleUtil.initLanguage(this);
    setContentView(2131495487);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (NGm != null) {}
    for (paramBundle = (ExtStorageMigrateAuxActivity)NGm.get();; paramBundle = null)
    {
      if ((paramBundle != null) && (!paramBundle.isFinishing()) && (!paramBundle.isDestroyed()))
      {
        if (paramBundle != this)
        {
          ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Duplicated instance. [latest: %s, prev: %s] Finish latest one.", new Object[] { this, paramBundle });
          finish();
          AppMethodBeat.o(176050);
        }
      }
      else {
        NGm = new WeakReference(this);
      }
      NGl.clear();
      this.NGn.clear();
      this.NGo.clear();
      if (this.NGp != null)
      {
        this.NGp.dismiss();
        this.NGp = null;
      }
      this.NGq = false;
      this.NGt = false;
      AppMethodBeat.o(176050);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(176053);
    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onDestroy called. object: %s", new Object[] { this });
    super.onDestroy();
    if (this.NGp != null)
    {
      this.NGp.dismiss();
      this.NGp = null;
    }
    AB(false);
    this.NGo.clear();
    this.NGn.clear();
    ExtStorageMigrateMonitor.gwN();
    AppMethodBeat.o(176053);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(176051);
    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onNewIntent called. object: %s", new Object[] { this });
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(176051);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = true;
    AppMethodBeat.i(176056);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c localc = (c)this.NGn.get(Integer.valueOf(paramInt));
    if (localc == null)
    {
      ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt) });
      finish();
      AppMethodBeat.o(176056);
      return;
    }
    ajA(paramInt);
    if (paramArrayOfString.length == 0)
    {
      ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] permissions array is empty.", new Object[0]);
      ajA(paramInt);
      AppMethodBeat.o(176056);
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    if (paramArrayOfInt[0] == 0)
    {
      localc.blu();
      AppMethodBeat.o(176056);
      return;
    }
    if (!android.support.v4.app.a.a(this, paramArrayOfString)) {}
    for (;;)
    {
      localc.dg(paramArrayOfString, bool);
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
    if (!this.NGq)
    {
      this.NGq = true;
      localIntent = getIntent();
      if (localIntent == null)
      {
        ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income intent is null.", new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
      }
      str = localIntent.getAction();
      if (TextUtils.isEmpty(str))
      {
        ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income action is null or empty.", new Object[0]);
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
        ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Unknown action: ".concat(String.valueOf(str)), new Object[0]);
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
      ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Do not need to do migration, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (b.gwZ())
    {
      ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates we should go on normal startup, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (localIntent.getBooleanExtra("auxui_param_is_migration_end", false))
    {
      ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates last migration is end, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    b.gxc();
    ExtStorageMigrateRoutine.startupMigrationService(this);
    this.NGt = ExtStorageMigrateRoutine.bindMigrationService(this, this.NGr);
    if (!this.NGt)
    {
      ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to bind to migrate service, startup WeChat next.", new Object[0]);
      AB(true);
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
    private final WeakReference<ExtStorageMigrateAuxActivity> NGB;
    private int NGC;
    
    AuxMigrateResultCallback(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity)
    {
      AppMethodBeat.i(204560);
      this.NGC = 0;
      this.NGB = new WeakReference(paramExtStorageMigrateAuxActivity);
      AppMethodBeat.o(204560);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity gwG()
    {
      AppMethodBeat.i(204561);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.NGB.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(204561);
        return null;
      }
      AppMethodBeat.o(204561);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
    {
      AppMethodBeat.i(204566);
      switch (paramInt)
      {
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity;
      for (;;)
      {
        localExtStorageMigrateAuxActivity = gwG();
        if (localExtStorageMigrateAuxActivity != null) {
          break;
        }
        AppMethodBeat.o(204566);
        return;
        ExtStorageMigrateMonitor.ME(109L);
        continue;
        ExtStorageMigrateMonitor.ME(110L);
        continue;
        ExtStorageMigrateMonitor.ME(111L);
        continue;
        ExtStorageMigrateMonitor.ME(112L);
        continue;
        ExtStorageMigrateMonitor.ME(113L);
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      if (paramInt == 6) {}
      for (paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.ajB(2131758966);; paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.ajB(2131758964))
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.b(localExtStorageMigrateAuxActivity, paramExtStorageMigrateException, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(204558);
            paramAnonymousDialogInterface.dismiss();
            ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
            ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
            localExtStorageMigrateAuxActivity.finish();
            AppMethodBeat.o(204558);
          }
        }));
        AppMethodBeat.o(204566);
        return;
      }
    }
    
    public final void ajC(int paramInt)
    {
      AppMethodBeat.i(204564);
      if ((paramInt == 3) || (paramInt == 2)) {
        ExtStorageMigrateMonitor.ME(108L);
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = gwG();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(204564);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.b(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.ajB(2131758962), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(204557);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(204557);
        }
      }));
      AppMethodBeat.o(204564);
    }
    
    public final void ajD(int paramInt)
    {
      AppMethodBeat.i(204565);
      Object localObject1 = gwG();
      if (localObject1 == null)
      {
        AppMethodBeat.o(204565);
        return;
      }
      Object localObject2;
      String str;
      if ((ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1) != null) && (ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).isShowing()))
      {
        localObject2 = String.format(ExtStorageMigrateAuxActivity.ajB(2131758968), new Object[] { paramInt + "%" });
        str = null;
        switch (this.NGC)
        {
        }
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).setMessage((CharSequence)localObject2);
        localObject2 = ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1);
        ((c)localObject2).NIK.setVisibility(0);
        ((c)localObject2).NID.setVisibility(0);
        localObject1 = str;
        if (((c)localObject2).NIU != null)
        {
          localObject1 = ((c)localObject2).NIU;
          ((c)localObject2).NIC.getContext();
          str.toString();
          ((c)localObject2).NID.getTextSize();
          localObject1 = ((c.a.c)localObject1).gxn();
        }
        ((c)localObject2).NID.setText((CharSequence)localObject1);
        AppMethodBeat.o(204565);
        return;
        str = "—";
        this.NGC = 1;
        continue;
        str = "\\";
        this.NGC = 2;
        continue;
        str = "|";
        this.NGC = 3;
        continue;
        str = "/";
        this.NGC = 0;
      }
    }
    
    protected final void gwH()
    {
      AppMethodBeat.i(204563);
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = gwG();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(204563);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      Object localObject = ExtStorageMigrateAuxActivity.ajB(2131758969);
      String str = ExtStorageMigrateAuxActivity.ajB(2131755761);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(204556);
          ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click cancel on migrating dlg.", new Object[0]);
          ExtStorageMigrateAuxActivity.b(localExtStorageMigrateAuxActivity);
          AppMethodBeat.o(204556);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(204563);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.bhS(null);
        locala.bhT((String)localObject);
        locala.bhU(str).a(local1);
        locala.AI(false);
        localObject = locala.gxm();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    public final void gwI()
    {
      AppMethodBeat.i(204567);
      ExtStorageMigrateMonitor.ME(107L);
      b.gxf();
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = gwG();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(204567);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.b(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.ajB(2131758974), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(204559);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(204559);
        }
      }));
      AppMethodBeat.o(204567);
    }
    
    public final void kI(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204562);
      ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] MigrateCallback was overrided, old_attached_pid: %s, new_attached_pid: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(204562);
    }
  }
  
  static final class a
    implements ServiceConnection
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> NGB;
    private final boolean NGF;
    private e NGG;
    
    a(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(204568);
      this.NGB = new WeakReference(paramExtStorageMigrateAuxActivity);
      this.NGF = paramBoolean;
      this.NGG = null;
      AppMethodBeat.o(204568);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity gwG()
    {
      AppMethodBeat.i(204569);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.NGB.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(204569);
        return null;
      }
      AppMethodBeat.o(204569);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(204570);
      paramComponentName = gwG();
      if (paramComponentName != null)
      {
        ExtStorageMigrateAuxActivity.a(paramComponentName, true);
        this.NGG = e.a.N(paramIBinder);
        if (this.NGF)
        {
          ExtStorageMigrateAuxActivity.a(paramComponentName, this.NGG, false);
          AppMethodBeat.o(204570);
          return;
        }
        ExtStorageMigrateAuxActivity.a(paramComponentName, this.NGG);
        AppMethodBeat.o(204570);
        return;
      }
      ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to get aux ui instance in onServiceConnected", new Object[0]);
      AppMethodBeat.o(204570);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(204571);
      ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Service [%s] disconnected.", new Object[] { paramComponentName });
      paramComponentName = gwG();
      if (paramComponentName != null) {
        ExtStorageMigrateAuxActivity.a(paramComponentName, false);
      }
      AppMethodBeat.o(204571);
    }
  }
  
  static abstract interface b
  {
    public abstract void gwF();
  }
  
  static abstract interface c
  {
    public abstract void blu();
    
    public abstract void dg(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity
 * JD-Core Version:    0.7.0.1
 */