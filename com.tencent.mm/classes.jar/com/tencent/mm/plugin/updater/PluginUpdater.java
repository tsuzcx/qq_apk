package com.tencent.mm.plugin.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.util.b.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginUpdater
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.updater.a.a
{
  private com.tencent.mm.ui.widget.a.e Oxn;
  private w loadingDialog;
  private com.tencent.mm.am.h maV;
  private WeakReference<Context> qLs;
  DialogInterface.OnCancelListener qbI;
  private LinkedList<com.tencent.mm.plugin.updater.a.b> tjb;
  String wording;
  
  public PluginUpdater()
  {
    AppMethodBeat.i(265995);
    this.tjb = new LinkedList();
    this.qLs = null;
    this.maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        boolean bool2 = true;
        AppMethodBeat.i(265946);
        if ((paramAnonymousp instanceof com.tencent.mm.plugin.updater.model.c))
        {
          PluginUpdater.this.dismissLoadingDialog();
          paramAnonymousp = (com.tencent.mm.plugin.updater.model.c)paramAnonymousp;
          paramAnonymousString = paramAnonymousp.TWL;
          if ((paramAnonymousString != null) && (paramAnonymousString.fQm()) && (paramAnonymousString.fQj()) && (!paramAnonymousString.fQn()) && (!paramAnonymousString.fQo()))
          {
            Log.i("MicroMsg.Updater.PluginUpdater", "TinkerSyncResponse packageType:%d", new Object[] { paramAnonymousString.vyQ });
            com.tencent.mm.plugin.hp.model.b.a(paramAnonymousString);
            if (paramAnonymousp.source == 0) {
              if (paramAnonymousString.vyQ.intValue() != 3) {}
            }
          }
          for (;;)
          {
            boolean bool1;
            try
            {
              paramAnonymousInt1 = Integer.decode(paramAnonymousString.clientVersion).intValue();
              Log.i("MicroMsg.Updater.PluginUpdater", "save update client version %s %d", new Object[] { paramAnonymousString.clientVersion, Integer.valueOf(paramAnonymousInt1) });
              bool1 = bool2;
              if (paramAnonymousInt1 != 0)
              {
                paramAnonymousp = com.tencent.mm.plugin.updater.model.d.TWN;
                com.tencent.mm.plugin.updater.model.d.hQd().edit().putInt("KeyCurrentUpdateVersion", paramAnonymousInt1).putInt("RedDotCheckUpdateTab", 1).apply();
                bool1 = bool2;
              }
              if (paramAnonymousString == null) {
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.c.updater_not_patch), 0).show();
              }
              paramAnonymousString = PluginUpdater.this.tjb.iterator();
              if (!paramAnonymousString.hasNext()) {
                break;
              }
              ((com.tencent.mm.plugin.updater.a.b)paramAnonymousString.next()).CG(bool1);
              continue;
            }
            catch (Exception paramAnonymousp)
            {
              paramAnonymousInt1 = 0;
              continue;
            }
            if (paramAnonymousString.vyQ.intValue() == 4)
            {
              PluginUpdater.access$000(PluginUpdater.this, paramAnonymousString);
              bool1 = false;
            }
            else if (paramAnonymousString.vyQ.intValue() == 2)
            {
              com.tencent.mm.plugin.updater.model.b.TWK.b(paramAnonymousString);
              bool1 = false;
              continue;
              if ((paramAnonymousp.source == 1) || (paramAnonymousp.source == 2))
              {
                Log.i("MicroMsg.Updater.PluginUpdater", "handle response source=%d", new Object[] { Integer.valueOf(paramAnonymousp.source) });
                com.tencent.mm.plugin.updater.model.b.TWK.b(paramAnonymousString);
                bool1 = false;
              }
              else
              {
                Log.i("MicroMsg.Updater.PluginUpdater", "not handle response unknown source=%d", new Object[] { Integer.valueOf(paramAnonymousp.source) });
                bool1 = false;
                continue;
                Log.i("MicroMsg.Updater.PluginUpdater", "not handle response");
              }
            }
            else
            {
              bool1 = false;
            }
          }
        }
        AppMethodBeat.o(265946);
      }
    };
    this.Oxn = null;
    this.loadingDialog = null;
    this.wording = MMApplicationContext.getContext().getString(a.c.app_checking);
    this.qbI = null;
    AppMethodBeat.o(265995);
  }
  
  private boolean checkCanAskData()
  {
    AppMethodBeat.i(265999);
    if (isUpdateDialogShowing())
    {
      AppMethodBeat.o(265999);
      return false;
    }
    if (!com.tencent.mm.plugin.hp.b.d.fQx())
    {
      Log.e("MicroMsg.Updater.PluginUpdater", "Hdiffapk, isCanUpdateDialogShow false.");
      if (com.tencent.mm.plugin.hp.b.d.fQy())
      {
        showTextToast(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.c.updater_hdiff_merge_wording));
        AppMethodBeat.o(265999);
        return false;
      }
      if (com.tencent.mm.plugin.hp.b.d.fQz())
      {
        showTextToast(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.c.updater_hdiff_merge_wording));
        AppMethodBeat.o(265999);
        return false;
      }
      AppMethodBeat.o(265999);
      return false;
    }
    AppMethodBeat.o(265999);
    return true;
  }
  
  private boolean checkHdiffInstall(final com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(266022);
    if (!((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).openUpdater())
    {
      AppMethodBeat.o(266022);
      return false;
    }
    if (isUpdateDialogShowing())
    {
      Log.i("MicroMsg.Updater.PluginUpdater", "checkHdiffInstall.HdiffApk update dialog is showing.");
      AppMethodBeat.o(266022);
      return false;
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {
      showUpdateDialog(paramb);
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run() {}
      });
      AppMethodBeat.o(266022);
      return false;
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(265942);
          PluginUpdater.access$200(PluginUpdater.this, paramb);
          AppMethodBeat.o(265942);
        }
      });
    }
  }
  
  private String getBasePatchId()
  {
    AppMethodBeat.i(266003);
    Object localObject = com.tencent.mm.util.d.agsY;
    if (com.tencent.mm.util.d.jJv())
    {
      localObject = com.tencent.mm.util.i.agtt;
      localObject = com.tencent.mm.util.i.a(b.a.agrO, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(266003);
        return localObject;
      }
    }
    localObject = Util.nullAs(com.tencent.mm.loader.i.a.bmm(), "");
    AppMethodBeat.o(266003);
    return localObject;
  }
  
  private LinkedList<dzo> getTinkerConditionList()
  {
    AppMethodBeat.i(266009);
    LinkedList localLinkedList = com.tencent.mm.plugin.hp.net.e.fPU();
    AppMethodBeat.o(266009);
    return localLinkedList;
  }
  
  private String getTinkerPatchId()
  {
    AppMethodBeat.i(266006);
    String str = Util.nullAs(com.tencent.mm.loader.i.a.bmn(), "");
    AppMethodBeat.o(266006);
    return str;
  }
  
  private boolean isUpdateDialogShowing()
  {
    AppMethodBeat.i(266015);
    if ((this.Oxn != null) && (this.Oxn.isShowing()))
    {
      Log.i("MicroMsg.Updater.PluginUpdater", "checkHdiffInstall.HdiffApk update dialog is showing.");
      AppMethodBeat.o(266015);
      return true;
    }
    AppMethodBeat.o(266015);
    return false;
  }
  
  private void showUpdateDialog(final com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(266031);
    if ((this.Oxn != null) && (this.Oxn.isShowing()))
    {
      Log.i("MicroMsg.Updater.PluginUpdater", "checkHdiffInstall.HdiffApk update dialog is showing.");
      AppMethodBeat.o(266031);
      return;
    }
    MMApplicationContext.getContext();
    Log.i("MicroMsg.Updater.PluginUpdater", "checkHdiffInstall.HdiffApk show update dialog");
    g.a locala = new g.a(MMApplicationContext.getContext());
    if (Util.isNullOrNil(paramb.fQl())) {}
    for (String str = MMApplicationContext.getContext().getString(a.c.updater_tip);; str = paramb.fQl())
    {
      locala.bDE(str);
      locala.aEX(a.c.updater_confirm);
      locala.NF(true);
      locala.c(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(265945);
          Log.i("MicroMsg.Updater.PluginUpdater", "onDialogClick HdiffApk %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            com.tencent.mm.plugin.updater.model.b.TWK.b(paramb);
            com.tencent.mm.plugin.hp.a.c.t(110, -100, 0L);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 110L, 1L, false);
            AppMethodBeat.o(265945);
            return;
          }
          com.tencent.mm.plugin.hp.a.c.t(109, -100, 0L);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 109L, 1L, false);
          AppMethodBeat.o(265945);
        }
      });
      locala.d(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(265943);
          Log.i("MicroMsg.Updater.PluginUpdater", "onDismiss.HdiffApk");
          AppMethodBeat.o(265943);
        }
      });
      locala.show();
      dismissLoadingDialog();
      this.Oxn = locala.pRv;
      com.tencent.mm.plugin.hp.a.c.t(108, -100, 0L);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 108L, 1L, false);
      AppMethodBeat.o(266031);
      return;
    }
  }
  
  public void addManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(266154);
    this.tjb.add(paramb);
    AppMethodBeat.o(266154);
  }
  
  public void autoCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(266174);
    Log.i("MicroMsg.Updater.PluginUpdater", "autoCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.hp.net.d locald = new com.tencent.mm.plugin.hp.net.d(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList());
    com.tencent.mm.kernel.h.aZW().a(locald, 0);
    AppMethodBeat.o(266174);
  }
  
  /* Error */
  public String checkUpdateFullPkgVersion(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 360
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 8
    //   8: invokestatic 146	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   11: checkcast 8	com/tencent/mm/plugin/updater/a/a
    //   14: invokeinterface 149 1 0
    //   19: ifne +20 -> 39
    //   22: ldc 118
    //   24: ldc_w 362
    //   27: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc_w 360
    //   33: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: ldc 203
    //   38: areturn
    //   39: ldc_w 364
    //   42: invokestatic 368	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   45: checkcast 364	com/tencent/mm/plugin/expt/b/c
    //   48: getstatic 374	com/tencent/mm/plugin/expt/b/c$a:yLL	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   51: ldc 203
    //   53: invokeinterface 377 3 0
    //   58: astore 4
    //   60: aload 4
    //   62: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifeq +20 -> 85
    //   68: ldc 118
    //   70: ldc_w 379
    //   73: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: ldc_w 360
    //   79: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: ldc 203
    //   84: areturn
    //   85: new 381	org/json/JSONObject
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 384	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   94: astore 4
    //   96: aload 4
    //   98: ldc_w 386
    //   101: invokevirtual 389	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: iconst_2
    //   105: invokevirtual 394	java/lang/String:substring	(I)Ljava/lang/String;
    //   108: bipush 16
    //   110: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   113: istore_2
    //   114: getstatic 403	com/tencent/mm/protocal/d:Yxh	I
    //   117: istore_3
    //   118: aload 4
    //   120: ldc_w 405
    //   123: invokevirtual 389	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 4
    //   128: ldc 118
    //   130: new 407	java/lang/StringBuilder
    //   133: dup
    //   134: ldc_w 409
    //   137: invokespecial 410	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: iload_2
    //   141: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 416
    //   147: invokevirtual 419	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 4
    //   152: invokevirtual 419	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: iload_2
    //   162: iload_3
    //   163: if_icmple +11 -> 174
    //   166: aload 4
    //   168: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   171: ifeq +12 -> 183
    //   174: ldc_w 360
    //   177: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: ldc 203
    //   182: areturn
    //   183: iload_1
    //   184: ifeq +26 -> 210
    //   187: ldc 8
    //   189: invokestatic 146	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   192: checkcast 8	com/tencent/mm/plugin/updater/a/a
    //   195: iload_2
    //   196: invokeinterface 425 2 0
    //   201: ldc_w 360
    //   204: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload 4
    //   209: areturn
    //   210: ldc 8
    //   212: invokestatic 146	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   215: checkcast 8	com/tencent/mm/plugin/updater/a/a
    //   218: iload_2
    //   219: invokeinterface 428 2 0
    //   224: goto -23 -> 201
    //   227: astore 5
    //   229: ldc 203
    //   231: astore 4
    //   233: ldc 118
    //   235: ldc_w 430
    //   238: iconst_1
    //   239: anewarray 326	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload 5
    //   246: invokevirtual 433	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   249: aastore
    //   250: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: goto -52 -> 201
    //   256: astore 5
    //   258: goto -25 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	PluginUpdater
    //   0	261	1	paramBoolean	boolean
    //   113	106	2	i	int
    //   117	47	3	j	int
    //   58	174	4	localObject	Object
    //   227	18	5	localException1	Exception
    //   256	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   39	76	227	java/lang/Exception
    //   85	128	227	java/lang/Exception
    //   128	161	256	java/lang/Exception
    //   166	174	256	java/lang/Exception
    //   187	201	256	java/lang/Exception
    //   210	224	256	java/lang/Exception
  }
  
  public void clickAboutWechatRedDot()
  {
    AppMethodBeat.i(266087);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickAboutWechatRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    com.tencent.mm.plugin.updater.model.d.hQd().edit().putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(266087);
  }
  
  public void clickBottomTabRedDot()
  {
    AppMethodBeat.i(266075);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickBottomTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    com.tencent.mm.plugin.updater.model.d.hQd().edit().putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(266075);
  }
  
  public void clickCheckUpdateRedDot()
  {
    AppMethodBeat.i(266100);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickCheckUpdateRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    com.tencent.mm.plugin.updater.model.d.hQd().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(266100);
  }
  
  public void clickSettingTabRedDot()
  {
    AppMethodBeat.i(266064);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickSettingTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    com.tencent.mm.plugin.updater.model.d.hQd().edit().putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(266064);
  }
  
  public void dismissLoadingDialog()
  {
    AppMethodBeat.i(266188);
    if (this.loadingDialog != null)
    {
      this.loadingDialog.dismiss();
      this.loadingDialog = null;
    }
    AppMethodBeat.o(266188);
  }
  
  public void execute(g paramg) {}
  
  public int getUpdateVersion()
  {
    AppMethodBeat.i(266124);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    int i = com.tencent.mm.plugin.updater.model.d.hQd().getInt("KeyCurrentUpdateVersion", 0);
    AppMethodBeat.o(266124);
    return i;
  }
  
  public boolean hasAboutWechatRedDot()
  {
    AppMethodBeat.i(266082);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    if (com.tencent.mm.plugin.updater.model.d.hQd().getInt("RedDotAboutWechatTab", 0) == 1)
    {
      AppMethodBeat.o(266082);
      return true;
    }
    AppMethodBeat.o(266082);
    return false;
  }
  
  public boolean hasBottomTabRedDot()
  {
    AppMethodBeat.i(266071);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    if (com.tencent.mm.plugin.updater.model.d.hQd().getInt("RedDotBottomTab", 0) == 1)
    {
      AppMethodBeat.o(266071);
      return true;
    }
    AppMethodBeat.o(266071);
    return false;
  }
  
  public boolean hasCheckUpdateTabRedDot()
  {
    AppMethodBeat.i(266094);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    if (com.tencent.mm.plugin.updater.model.d.hQd().getInt("RedDotCheckUpdateTab", 0) == 1)
    {
      AppMethodBeat.o(266094);
      return true;
    }
    AppMethodBeat.o(266094);
    return false;
  }
  
  public boolean hasSettingTabRedDot()
  {
    AppMethodBeat.i(266060);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
    if (com.tencent.mm.plugin.updater.model.d.hQd().getInt("RedDotSettingTab", 0) == 1)
    {
      AppMethodBeat.o(266060);
      return true;
    }
    AppMethodBeat.o(266060);
    return false;
  }
  
  public void manualCheckUpdate(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(266167);
    Log.i("MicroMsg.Updater.PluginUpdater", "manualCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    this.qLs = new WeakReference(paramContext);
    if (!checkCanAskData())
    {
      AppMethodBeat.o(266167);
      return;
    }
    showLoadingDialog();
    paramContext = new com.tencent.mm.plugin.updater.model.c(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList(), paramInt);
    com.tencent.mm.kernel.h.aZW().a(paramContext, 0);
    if (paramInt == 2)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 14L, 1L, false);
      AppMethodBeat.o(266167);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 15L, 1L, false);
      AppMethodBeat.o(266167);
      return;
    }
    if (paramInt == 0) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 16L, 1L, false);
    }
    AppMethodBeat.o(266167);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(266133);
    com.tencent.mm.kernel.h.aZW().a(3899, this.maV);
    if (paramc.mDg)
    {
      paramc = com.tencent.mm.plugin.updater.model.d.TWN;
      com.tencent.mm.plugin.updater.model.d.hQd().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    }
    AppMethodBeat.o(266133);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(266144);
    com.tencent.mm.kernel.h.aZW().b(3899, this.maV);
    AppMethodBeat.o(266144);
  }
  
  public boolean openUpdater()
  {
    AppMethodBeat.i(266179);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqd, b.a.agrN, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Updater.PluginUpdater", "openUpdater %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(266179);
      return bool;
    }
  }
  
  public void removeManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(266160);
    this.tjb.remove(paramb);
    AppMethodBeat.o(266160);
  }
  
  public void setCheckUpdateRedDot(int paramInt)
  {
    AppMethodBeat.i(266114);
    Log.i("MicroMsg.Updater.PluginUpdater", "setFullCheckUpdateRedDot %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 25L, 1L, false);
      com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
      com.tencent.mm.plugin.updater.model.d.hQd().edit().putInt("KeyCurrentUpdateVersion", paramInt).putInt("RedDotCheckUpdateTab", 1).apply();
      AppMethodBeat.o(266114);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 26L, 1L, false);
    AppMethodBeat.o(266114);
  }
  
  public void setFullCheckUpdateRedDot(int paramInt)
  {
    AppMethodBeat.i(266110);
    Log.i("MicroMsg.Updater.PluginUpdater", "setFullCheckUpdateRedDot %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 25L, 1L, false);
      com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.TWN;
      com.tencent.mm.plugin.updater.model.d.hQd().edit().putInt("KeyCurrentUpdateVersion", paramInt).putInt("RedDotCheckUpdateTab", 1).putInt("RedDotAboutWechatTab", 1).putInt("RedDotSettingTab", 1).putInt("RedDotBottomTab", 1).apply();
      AppMethodBeat.o(266110);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 26L, 1L, false);
    AppMethodBeat.o(266110);
  }
  
  public void showLoadingDialog()
  {
    AppMethodBeat.i(266184);
    dismissLoadingDialog();
    Context localContext;
    String str;
    if ((this.qLs != null) && (this.qLs.get() != null))
    {
      localContext = (Context)this.qLs.get();
      str = this.wording;
      if (this.qbI == null) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      this.loadingDialog = w.a(localContext, str, bool, 0, this.qbI);
      AppMethodBeat.o(266184);
      return;
    }
  }
  
  public void showTextToast(Context paramContext, String paramString)
  {
    AppMethodBeat.i(266191);
    paramContext = new g.a(paramContext);
    paramContext.bDE(paramString);
    paramContext.Xdm = true;
    paramContext.aEX(a.c.app_i_know);
    paramContext.b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(265944);
        Log.i("MicroMsg.Updater.PluginUpdater", "showVOIPTip, has shown tip");
        AppMethodBeat.o(265944);
      }
    });
    paramContext.show();
    AppMethodBeat.o(266191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */