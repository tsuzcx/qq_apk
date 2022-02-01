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
import com.tencent.mm.sdk.platformtools.ad;
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
  private static final Random IsM;
  private static final Set<Integer> IsN;
  private static WeakReference<ExtStorageMigrateAuxActivity> IsO;
  private static Context caq;
  private final Map<Integer, c> IsP;
  private final Map<Integer, b> IsQ;
  private c IsR;
  private boolean IsS;
  private a IsT;
  private AuxMigrateResultCallback IsU;
  private boolean IsV;
  
  static
  {
    AppMethodBeat.i(176060);
    IsM = new Random();
    IsN = new HashSet(5);
    IsO = null;
    caq = null;
    AppMethodBeat.o(176060);
  }
  
  public ExtStorageMigrateAuxActivity()
  {
    AppMethodBeat.i(176049);
    this.IsP = new HashMap();
    this.IsQ = new HashMap();
    this.IsR = null;
    this.IsS = false;
    this.IsT = new a(this, false);
    this.IsU = new AuxMigrateResultCallback(this);
    this.IsV = false;
    AppMethodBeat.o(176049);
  }
  
  private void aaL(int paramInt)
  {
    AppMethodBeat.i(176055);
    IsN.remove(Integer.valueOf(paramInt));
    this.IsP.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(176055);
  }
  
  private static int fmQ()
  {
    AppMethodBeat.i(176054);
    int i;
    do
    {
      int j = (int)(IsM.nextInt() + (System.nanoTime() & 0xFFFFFFFF));
      i = j;
      if (j < 0) {
        i = -j;
      }
    } while ((i == 0) || (IsN.contains(Integer.valueOf(i))));
    IsN.add(Integer.valueOf(i));
    AppMethodBeat.o(176054);
    return i;
  }
  
  /* Error */
  private void wB(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 334
    //   5: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:IsR	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   12: ifnull +20 -> 32
    //   15: aload_0
    //   16: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:IsR	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   19: invokevirtual 339	com/tencent/mm/sdcard_migrate/a/c:isShowing	()Z
    //   22: ifeq +10 -> 32
    //   25: aload_0
    //   26: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:IsR	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   29: invokevirtual 342	com/tencent/mm/sdcard_migrate/a/c:dismiss	()V
    //   32: aload_0
    //   33: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:IsT	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
    //   36: invokestatic 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;)Lcom/tencent/mm/sdcard_migrate/e;
    //   39: astore 4
    //   41: iload_3
    //   42: istore_2
    //   43: aload 4
    //   45: ifnull +29 -> 74
    //   48: iload_3
    //   49: istore_2
    //   50: aload 4
    //   52: invokeinterface 349 1 0
    //   57: invokeinterface 354 1 0
    //   62: ifeq +12 -> 74
    //   65: aload 4
    //   67: invokeinterface 357 1 0
    //   72: iconst_1
    //   73: istore_2
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:IsT	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
    //   79: invokevirtual 361	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:unbindService	(Landroid/content/ServiceConnection;)V
    //   82: iload_2
    //   83: ifne +9 -> 92
    //   86: getstatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:caq	Landroid/content/Context;
    //   89: invokestatic 364	com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine:cancelMigration	(Landroid/content/Context;)V
    //   92: invokestatic 369	com/tencent/mm/sdcard_migrate/b:fnq	()V
    //   95: iload_1
    //   96: ifeq +11 -> 107
    //   99: aload_0
    //   100: invokestatic 372	com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine:startWeChat	(Landroid/content/Context;)V
    //   103: aload_0
    //   104: invokevirtual 375	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:finish	()V
    //   107: ldc_w 334
    //   110: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore 4
    //   116: iload_3
    //   117: istore_2
    //   118: goto -44 -> 74
    //   121: astore 4
    //   123: goto -41 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ExtStorageMigrateAuxActivity
    //   0	126	1	paramBoolean	boolean
    //   42	76	2	i	int
    //   1	116	3	j	int
    //   39	27	4	locale	e
    //   114	1	4	localThrowable1	java.lang.Throwable
    //   121	1	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   65	72	114	java/lang/Throwable
    //   74	82	121	java/lang/Throwable
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(176057);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = (b)this.IsQ.get(Integer.valueOf(paramInt1));
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.fmX().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(176057);
      return;
    }
    paramIntent.fmS();
    IsN.remove(Integer.valueOf(paramInt1));
    this.IsQ.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(176057);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(176050);
    super.onCreate(paramBundle);
    ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onCreate called. object: %s", new Object[] { this });
    caq = getApplicationContext();
    ad.initLanguage(this);
    setContentView(2131494757);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (IsO != null) {}
    for (paramBundle = (ExtStorageMigrateAuxActivity)IsO.get();; paramBundle = null)
    {
      if ((paramBundle != null) && (!paramBundle.isFinishing()) && (!paramBundle.isDestroyed()))
      {
        if (paramBundle != this)
        {
          ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Duplicated instance. [latest: %s, prev: %s] Finish latest one.", new Object[] { this, paramBundle });
          finish();
          AppMethodBeat.o(176050);
        }
      }
      else {
        IsO = new WeakReference(this);
      }
      IsN.clear();
      this.IsP.clear();
      this.IsQ.clear();
      if (this.IsR != null)
      {
        this.IsR.dismiss();
        this.IsR = null;
      }
      this.IsS = false;
      this.IsV = false;
      AppMethodBeat.o(176050);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(176053);
    ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onDestroy called. object: %s", new Object[] { this });
    super.onDestroy();
    if (this.IsR != null)
    {
      this.IsR.dismiss();
      this.IsR = null;
    }
    wB(false);
    this.IsQ.clear();
    this.IsP.clear();
    ExtStorageMigrateMonitor.fna();
    AppMethodBeat.o(176053);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(176051);
    ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onNewIntent called. object: %s", new Object[] { this });
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(176051);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = true;
    AppMethodBeat.i(176056);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c localc = (c)this.IsP.get(Integer.valueOf(paramInt));
    if (localc == null)
    {
      ExtStorageMigrateMonitor.fmX().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt) });
      finish();
      AppMethodBeat.o(176056);
      return;
    }
    aaL(paramInt);
    if (paramArrayOfString.length == 0)
    {
      ExtStorageMigrateMonitor.fmX().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] permissions array is empty.", new Object[0]);
      aaL(paramInt);
      AppMethodBeat.o(176056);
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    if (paramArrayOfInt[0] == 0)
    {
      localc.aQP();
      AppMethodBeat.o(176056);
      return;
    }
    if (!android.support.v4.app.a.a(this, paramArrayOfString)) {}
    for (;;)
    {
      localc.cL(paramArrayOfString, bool);
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
    if (!this.IsS)
    {
      this.IsS = true;
      localIntent = getIntent();
      if (localIntent == null)
      {
        ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income intent is null.", new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
      }
      str = localIntent.getAction();
      if (TextUtils.isEmpty(str))
      {
        ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income action is null or empty.", new Object[0]);
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
        ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Unknown action: ".concat(String.valueOf(str)), new Object[0]);
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
      ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Do not need to do migration, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (b.fnm())
    {
      ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates we should go on normal startup, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (localIntent.getBooleanExtra("auxui_param_is_migration_end", false))
    {
      ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates last migration is end, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    b.fnp();
    ExtStorageMigrateRoutine.startupMigrationService(this);
    this.IsV = ExtStorageMigrateRoutine.bindMigrationService(this, this.IsT);
    if (!this.IsV)
    {
      ExtStorageMigrateMonitor.fmX().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to bind to migrate service, startup WeChat next.", new Object[0]);
      wB(true);
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
    private final WeakReference<ExtStorageMigrateAuxActivity> Itd;
    private int Ite;
    
    AuxMigrateResultCallback(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity)
    {
      AppMethodBeat.i(211798);
      this.Ite = 0;
      this.Itd = new WeakReference(paramExtStorageMigrateAuxActivity);
      AppMethodBeat.o(211798);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity fmT()
    {
      AppMethodBeat.i(211799);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.Itd.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(211799);
        return null;
      }
      AppMethodBeat.o(211799);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
    {
      AppMethodBeat.i(211804);
      switch (paramInt)
      {
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity;
      for (;;)
      {
        localExtStorageMigrateAuxActivity = fmT();
        if (localExtStorageMigrateAuxActivity != null) {
          break;
        }
        AppMethodBeat.o(211804);
        return;
        ExtStorageMigrateMonitor.Do(109L);
        continue;
        ExtStorageMigrateMonitor.Do(110L);
        continue;
        ExtStorageMigrateMonitor.Do(111L);
        continue;
        ExtStorageMigrateMonitor.Do(112L);
        continue;
        ExtStorageMigrateMonitor.Do(113L);
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      if (paramInt == 6) {}
      for (paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.aaM(2131758661);; paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.aaM(2131758659))
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, paramExtStorageMigrateException, ExtStorageMigrateAuxActivity.aaM(2131758669), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(211796);
            paramAnonymousDialogInterface.dismiss();
            ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
            ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
            localExtStorageMigrateAuxActivity.finish();
            AppMethodBeat.o(211796);
          }
        }));
        AppMethodBeat.o(211804);
        return;
      }
    }
    
    public final void aaN(int paramInt)
    {
      AppMethodBeat.i(211802);
      if ((paramInt == 3) || (paramInt == 2)) {
        ExtStorageMigrateMonitor.Do(108L);
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = fmT();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(211802);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.aaM(2131758657), ExtStorageMigrateAuxActivity.aaM(2131758669), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(211795);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(211795);
        }
      }));
      AppMethodBeat.o(211802);
    }
    
    public final void aaO(int paramInt)
    {
      AppMethodBeat.i(211803);
      Object localObject1 = fmT();
      if (localObject1 == null)
      {
        AppMethodBeat.o(211803);
        return;
      }
      Object localObject2;
      String str;
      if ((ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1) != null) && (ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).isShowing()))
      {
        localObject2 = String.format(ExtStorageMigrateAuxActivity.aaM(2131758663), new Object[] { paramInt + "%" });
        str = null;
        switch (this.Ite)
        {
        }
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).setMessage((CharSequence)localObject2);
        localObject2 = ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1);
        ((c)localObject2).Ivm.setVisibility(0);
        ((c)localObject2).Ive.setVisibility(0);
        localObject1 = str;
        if (((c)localObject2).Ivw != null)
        {
          localObject1 = ((c)localObject2).Ivw;
          ((c)localObject2).Ivd.getContext();
          str.toString();
          ((c)localObject2).Ive.getTextSize();
          localObject1 = ((c.a.c)localObject1).fnA();
        }
        ((c)localObject2).Ive.setText((CharSequence)localObject1);
        AppMethodBeat.o(211803);
        return;
        str = "—";
        this.Ite = 1;
        continue;
        str = "\\";
        this.Ite = 2;
        continue;
        str = "|";
        this.Ite = 3;
        continue;
        str = "/";
        this.Ite = 0;
      }
    }
    
    protected final void fmU()
    {
      AppMethodBeat.i(211801);
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = fmT();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(211801);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      Object localObject = ExtStorageMigrateAuxActivity.aaM(2131758664);
      String str1 = ExtStorageMigrateAuxActivity.aaM(2131758669);
      String str2 = ExtStorageMigrateAuxActivity.aaM(2131755691);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(211794);
          ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click cancel on migrating dlg.", new Object[0]);
          ExtStorageMigrateAuxActivity.b(localExtStorageMigrateAuxActivity);
          AppMethodBeat.o(211794);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(211801);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.aRp(str1);
        locala.aRq((String)localObject);
        locala.aRr(str2).a(local1);
        locala.fny();
        localObject = locala.fnz();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    public final void fmV()
    {
      AppMethodBeat.i(211805);
      ExtStorageMigrateMonitor.Do(107L);
      b.fns();
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = fmT();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(211805);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.aaM(2131758668), ExtStorageMigrateAuxActivity.aaM(2131758669), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(211797);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(211797);
        }
      }));
      AppMethodBeat.o(211805);
    }
    
    public final void jw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(211800);
      ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] MigrateCallback was overrided, old_attached_pid: %s, new_attached_pid: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(211800);
    }
  }
  
  static final class a
    implements ServiceConnection
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> Itd;
    private final boolean Ith;
    private e Iti;
    
    a(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(211806);
      this.Itd = new WeakReference(paramExtStorageMigrateAuxActivity);
      this.Ith = paramBoolean;
      this.Iti = null;
      AppMethodBeat.o(211806);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity fmT()
    {
      AppMethodBeat.i(211807);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.Itd.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(211807);
        return null;
      }
      AppMethodBeat.o(211807);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(211808);
      paramComponentName = fmT();
      if (paramComponentName != null)
      {
        ExtStorageMigrateAuxActivity.a(paramComponentName, true);
        this.Iti = e.a.N(paramIBinder);
        if (this.Ith)
        {
          ExtStorageMigrateAuxActivity.a(paramComponentName, this.Iti, false);
          AppMethodBeat.o(211808);
          return;
        }
        ExtStorageMigrateAuxActivity.a(paramComponentName, this.Iti);
        AppMethodBeat.o(211808);
        return;
      }
      ExtStorageMigrateMonitor.fmX().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to get aux ui instance in onServiceConnected", new Object[0]);
      AppMethodBeat.o(211808);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(211809);
      ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Service [%s] disconnected.", new Object[] { paramComponentName });
      paramComponentName = fmT();
      if (paramComponentName != null) {
        ExtStorageMigrateAuxActivity.a(paramComponentName, false);
      }
      AppMethodBeat.o(211809);
    }
  }
  
  static abstract interface b
  {
    public abstract void fmS();
  }
  
  static abstract interface c
  {
    public abstract void aQP();
    
    public abstract void cL(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity
 * JD-Core Version:    0.7.0.1
 */