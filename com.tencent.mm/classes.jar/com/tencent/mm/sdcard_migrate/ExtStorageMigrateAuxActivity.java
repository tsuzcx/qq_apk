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
import com.tencent.mm.sdk.platformtools.ac;
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
  private static final Random HYF;
  private static final Set<Integer> HYG;
  private static WeakReference<ExtStorageMigrateAuxActivity> HYH;
  private static Context caq;
  private final Map<Integer, c> HYI;
  private final Map<Integer, b> HYJ;
  private c HYK;
  private boolean HYL;
  private a HYM;
  private AuxMigrateResultCallback HYN;
  private boolean HYO;
  
  static
  {
    AppMethodBeat.i(176060);
    HYF = new Random();
    HYG = new HashSet(5);
    HYH = null;
    caq = null;
    AppMethodBeat.o(176060);
  }
  
  public ExtStorageMigrateAuxActivity()
  {
    AppMethodBeat.i(176049);
    this.HYI = new HashMap();
    this.HYJ = new HashMap();
    this.HYK = null;
    this.HYL = false;
    this.HYM = new a(this, false);
    this.HYN = new AuxMigrateResultCallback(this);
    this.HYO = false;
    AppMethodBeat.o(176049);
  }
  
  private void aaf(int paramInt)
  {
    AppMethodBeat.i(176055);
    HYG.remove(Integer.valueOf(paramInt));
    this.HYI.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(176055);
  }
  
  private static int fiY()
  {
    AppMethodBeat.i(176054);
    int i;
    do
    {
      int j = (int)(HYF.nextInt() + (System.nanoTime() & 0xFFFFFFFF));
      i = j;
      if (j < 0) {
        i = -j;
      }
    } while ((i == 0) || (HYG.contains(Integer.valueOf(i))));
    HYG.add(Integer.valueOf(i));
    AppMethodBeat.o(176054);
    return i;
  }
  
  /* Error */
  private void wt(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 334
    //   5: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:HYK	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   12: ifnull +20 -> 32
    //   15: aload_0
    //   16: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:HYK	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   19: invokevirtual 339	com/tencent/mm/sdcard_migrate/a/c:isShowing	()Z
    //   22: ifeq +10 -> 32
    //   25: aload_0
    //   26: getfield 110	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:HYK	Lcom/tencent/mm/sdcard_migrate/a/c;
    //   29: invokevirtual 342	com/tencent/mm/sdcard_migrate/a/c:dismiss	()V
    //   32: aload_0
    //   33: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:HYM	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
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
    //   76: getfield 117	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:HYM	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity$a;
    //   79: invokevirtual 361	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:unbindService	(Landroid/content/ServiceConnection;)V
    //   82: iload_2
    //   83: ifne +9 -> 92
    //   86: getstatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateAuxActivity:caq	Landroid/content/Context;
    //   89: invokestatic 364	com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine:cancelMigration	(Landroid/content/Context;)V
    //   92: invokestatic 369	com/tencent/mm/sdcard_migrate/b:fjy	()V
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
    paramIntent = (b)this.HYJ.get(Integer.valueOf(paramInt1));
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.fjf().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(176057);
      return;
    }
    paramIntent.fja();
    HYG.remove(Integer.valueOf(paramInt1));
    this.HYJ.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(176057);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(176050);
    super.onCreate(paramBundle);
    ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onCreate called. object: %s", new Object[] { this });
    caq = getApplicationContext();
    ac.initLanguage(this);
    setContentView(2131494757);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (HYH != null) {}
    for (paramBundle = (ExtStorageMigrateAuxActivity)HYH.get();; paramBundle = null)
    {
      if ((paramBundle != null) && (!paramBundle.isFinishing()) && (!paramBundle.isDestroyed()))
      {
        if (paramBundle != this)
        {
          ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Duplicated instance. [latest: %s, prev: %s] Finish latest one.", new Object[] { this, paramBundle });
          finish();
          AppMethodBeat.o(176050);
        }
      }
      else {
        HYH = new WeakReference(this);
      }
      HYG.clear();
      this.HYI.clear();
      this.HYJ.clear();
      if (this.HYK != null)
      {
        this.HYK.dismiss();
        this.HYK = null;
      }
      this.HYL = false;
      this.HYO = false;
      AppMethodBeat.o(176050);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(176053);
    ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onDestroy called. object: %s", new Object[] { this });
    super.onDestroy();
    if (this.HYK != null)
    {
      this.HYK.dismiss();
      this.HYK = null;
    }
    wt(false);
    this.HYJ.clear();
    this.HYI.clear();
    ExtStorageMigrateMonitor.fji();
    AppMethodBeat.o(176053);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(176051);
    ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] onNewIntent called. object: %s", new Object[] { this });
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(176051);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool = true;
    AppMethodBeat.i(176056);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c localc = (c)this.HYI.get(Integer.valueOf(paramInt));
    if (localc == null)
    {
      ExtStorageMigrateMonitor.fjf().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Unknown ticket: %s.", new Object[] { Integer.valueOf(paramInt) });
      finish();
      AppMethodBeat.o(176056);
      return;
    }
    aaf(paramInt);
    if (paramArrayOfString.length == 0)
    {
      ExtStorageMigrateMonitor.fjf().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] permissions array is empty.", new Object[0]);
      aaf(paramInt);
      AppMethodBeat.o(176056);
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    if (paramArrayOfInt[0] == 0)
    {
      localc.aQq();
      AppMethodBeat.o(176056);
      return;
    }
    if (!android.support.v4.app.a.a(this, paramArrayOfString)) {}
    for (;;)
    {
      localc.cH(paramArrayOfString, bool);
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
    if (!this.HYL)
    {
      this.HYL = true;
      localIntent = getIntent();
      if (localIntent == null)
      {
        ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income intent is null.", new Object[0]);
        finish();
        AppMethodBeat.o(176052);
        return;
      }
      str = localIntent.getAction();
      if (TextUtils.isEmpty(str))
      {
        ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Income action is null or empty.", new Object[0]);
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
        ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Unknown action: ".concat(String.valueOf(str)), new Object[0]);
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
      ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Do not need to do migration, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (b.fju())
    {
      ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates we should go on normal startup, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    if (localIntent.getBooleanExtra("auxui_param_is_migration_end", false))
    {
      ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Migration routine indicates last migration is end, start wechat now.", new Object[0]);
      ExtStorageMigrateRoutine.startWeChat(this);
      finish();
      AppMethodBeat.o(176052);
      return;
    }
    b.fjx();
    ExtStorageMigrateRoutine.startupMigrationService(this);
    this.HYO = ExtStorageMigrateRoutine.bindMigrationService(this, this.HYM);
    if (!this.HYO)
    {
      ExtStorageMigrateMonitor.fjf().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to bind to migrate service, startup WeChat next.", new Object[0]);
      wt(true);
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
    private final WeakReference<ExtStorageMigrateAuxActivity> HYW;
    private int HYX;
    
    AuxMigrateResultCallback(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity)
    {
      AppMethodBeat.i(211016);
      this.HYX = 0;
      this.HYW = new WeakReference(paramExtStorageMigrateAuxActivity);
      AppMethodBeat.o(211016);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity fjb()
    {
      AppMethodBeat.i(211017);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.HYW.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(211017);
        return null;
      }
      AppMethodBeat.o(211017);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
    {
      AppMethodBeat.i(211022);
      switch (paramInt)
      {
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity;
      for (;;)
      {
        localExtStorageMigrateAuxActivity = fjb();
        if (localExtStorageMigrateAuxActivity != null) {
          break;
        }
        AppMethodBeat.o(211022);
        return;
        ExtStorageMigrateMonitor.CQ(109L);
        continue;
        ExtStorageMigrateMonitor.CQ(110L);
        continue;
        ExtStorageMigrateMonitor.CQ(111L);
        continue;
        ExtStorageMigrateMonitor.CQ(112L);
        continue;
        ExtStorageMigrateMonitor.CQ(113L);
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      if (paramInt == 6) {}
      for (paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.aag(2131758661);; paramExtStorageMigrateException = ExtStorageMigrateAuxActivity.aag(2131758659))
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, paramExtStorageMigrateException, ExtStorageMigrateAuxActivity.aag(2131758669), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(211014);
            paramAnonymousDialogInterface.dismiss();
            ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
            ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
            localExtStorageMigrateAuxActivity.finish();
            AppMethodBeat.o(211014);
          }
        }));
        AppMethodBeat.o(211022);
        return;
      }
    }
    
    public final void aah(int paramInt)
    {
      AppMethodBeat.i(211020);
      if ((paramInt == 3) || (paramInt == 2)) {
        ExtStorageMigrateMonitor.CQ(108L);
      }
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = fjb();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(211020);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.aag(2131758657), ExtStorageMigrateAuxActivity.aag(2131758669), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(211013);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(211013);
        }
      }));
      AppMethodBeat.o(211020);
    }
    
    public final void aai(int paramInt)
    {
      AppMethodBeat.i(211021);
      Object localObject1 = fjb();
      if (localObject1 == null)
      {
        AppMethodBeat.o(211021);
        return;
      }
      Object localObject2;
      String str;
      if ((ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1) != null) && (ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).isShowing()))
      {
        localObject2 = String.format(ExtStorageMigrateAuxActivity.aag(2131758663), new Object[] { paramInt + "%" });
        str = null;
        switch (this.HYX)
        {
        }
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1).setMessage((CharSequence)localObject2);
        localObject2 = ExtStorageMigrateAuxActivity.a((ExtStorageMigrateAuxActivity)localObject1);
        ((c)localObject2).Ibe.setVisibility(0);
        ((c)localObject2).OeD.setVisibility(0);
        localObject1 = str;
        if (((c)localObject2).Ibo != null)
        {
          localObject1 = ((c)localObject2).Ibo;
          ((c)localObject2).IaW.getContext();
          str.toString();
          ((c)localObject2).OeD.getTextSize();
          localObject1 = ((c.a.c)localObject1).fjI();
        }
        ((c)localObject2).OeD.setText((CharSequence)localObject1);
        AppMethodBeat.o(211021);
        return;
        str = "—";
        this.HYX = 1;
        continue;
        str = "\\";
        this.HYX = 2;
        continue;
        str = "|";
        this.HYX = 3;
        continue;
        str = "/";
        this.HYX = 0;
      }
    }
    
    protected final void fjc()
    {
      AppMethodBeat.i(211019);
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = fjb();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(211019);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      Object localObject = ExtStorageMigrateAuxActivity.aag(2131758664);
      String str1 = ExtStorageMigrateAuxActivity.aag(2131758669);
      String str2 = ExtStorageMigrateAuxActivity.aag(2131755691);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(211012);
          ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateAuxActivity", "[+] User click cancel on migrating dlg.", new Object[0]);
          ExtStorageMigrateAuxActivity.b(localExtStorageMigrateAuxActivity);
          AppMethodBeat.o(211012);
        }
      };
      if (((localExtStorageMigrateAuxActivity instanceof Activity)) && (((Activity)localExtStorageMigrateAuxActivity).isFinishing())) {
        localObject = null;
      }
      for (;;)
      {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, (c)localObject);
        AppMethodBeat.o(211019);
        return;
        c.a locala = new c.a(localExtStorageMigrateAuxActivity);
        locala.aPS(str1);
        locala.aPT((String)localObject);
        locala.aPU(str2).a(local1);
        locala.fjG();
        localObject = locala.fjH();
        ((c)localObject).show();
        com.tencent.mm.sdcard_migrate.a.b.a(localExtStorageMigrateAuxActivity, (Dialog)localObject);
      }
    }
    
    public final void fjd()
    {
      AppMethodBeat.i(211023);
      ExtStorageMigrateMonitor.CQ(107L);
      b.fjA();
      final ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = fjb();
      if (localExtStorageMigrateAuxActivity == null)
      {
        AppMethodBeat.o(211023);
        return;
      }
      if ((ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity) != null) && (ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).isShowing())) {
        ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity).dismiss();
      }
      ExtStorageMigrateAuxActivity.a(localExtStorageMigrateAuxActivity, com.tencent.mm.sdcard_migrate.a.b.c(localExtStorageMigrateAuxActivity, ExtStorageMigrateAuxActivity.aag(2131758668), ExtStorageMigrateAuxActivity.aag(2131758669), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(211015);
          paramAnonymousDialogInterface.dismiss();
          ExtStorageMigrateRoutine.startWeChat(localExtStorageMigrateAuxActivity);
          ExtStorageMigrateAuxActivity.c(localExtStorageMigrateAuxActivity);
          localExtStorageMigrateAuxActivity.finish();
          AppMethodBeat.o(211015);
        }
      }));
      AppMethodBeat.o(211023);
    }
    
    public final void js(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(211018);
      ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] MigrateCallback was overrided, old_attached_pid: %s, new_attached_pid: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(211018);
    }
  }
  
  static final class a
    implements ServiceConnection
  {
    private final WeakReference<ExtStorageMigrateAuxActivity> HYW;
    private final boolean HZa;
    private e HZb;
    
    a(ExtStorageMigrateAuxActivity paramExtStorageMigrateAuxActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(211024);
      this.HYW = new WeakReference(paramExtStorageMigrateAuxActivity);
      this.HZa = paramBoolean;
      this.HZb = null;
      AppMethodBeat.o(211024);
    }
    
    @SuppressLint({"NewApi"})
    private ExtStorageMigrateAuxActivity fjb()
    {
      AppMethodBeat.i(221223);
      ExtStorageMigrateAuxActivity localExtStorageMigrateAuxActivity = (ExtStorageMigrateAuxActivity)this.HYW.get();
      if ((localExtStorageMigrateAuxActivity == null) || (localExtStorageMigrateAuxActivity.isFinishing()) || (localExtStorageMigrateAuxActivity.isDestroyed()))
      {
        AppMethodBeat.o(221223);
        return null;
      }
      AppMethodBeat.o(221223);
      return localExtStorageMigrateAuxActivity;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(211025);
      paramComponentName = fjb();
      if (paramComponentName != null)
      {
        ExtStorageMigrateAuxActivity.a(paramComponentName, true);
        this.HZb = e.a.M(paramIBinder);
        if (this.HZa)
        {
          ExtStorageMigrateAuxActivity.a(paramComponentName, this.HZb, false);
          AppMethodBeat.o(211025);
          return;
        }
        ExtStorageMigrateAuxActivity.a(paramComponentName, this.HZb);
        AppMethodBeat.o(211025);
        return;
      }
      ExtStorageMigrateMonitor.fjf().e("MicroMsg.ExtStorageMigrateAuxActivity", "[-] Fail to get aux ui instance in onServiceConnected", new Object[0]);
      AppMethodBeat.o(211025);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(211026);
      ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateAuxActivity", "[!] Service [%s] disconnected.", new Object[] { paramComponentName });
      paramComponentName = fjb();
      if (paramComponentName != null) {
        ExtStorageMigrateAuxActivity.a(paramComponentName, false);
      }
      AppMethodBeat.o(211026);
    }
  }
  
  static abstract interface b
  {
    public abstract void fja();
  }
  
  static abstract interface c
  {
    public abstract void aQq();
    
    public abstract void cH(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity
 * JD-Core Version:    0.7.0.1
 */