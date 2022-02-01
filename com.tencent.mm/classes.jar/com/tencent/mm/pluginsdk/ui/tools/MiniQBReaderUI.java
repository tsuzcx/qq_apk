package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.ne;
import com.tencent.mm.f.a.ne.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.appbrand.openmaterial.h.a;
import com.tencent.mm.plugin.appbrand.openmaterial.h.b;
import com.tencent.mm.plugin.appbrand.openmaterial.j;
import com.tencent.mm.plugin.appbrand.openmaterial.k;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.az;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.u;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI
  extends MMSecDataActivity
{
  private static boolean Fvr = false;
  private static boolean SvG = false;
  private static int pos = 0;
  private HandOffFile HEt;
  private AppBrandOpenMaterialCollection QdI;
  private j QdJ;
  private com.tencent.mm.ui.chatting.g.a Rxf;
  private com.tencent.mm.ui.chatting.j.b Rxg;
  private com.tencent.mm.ui.chatting.j.a Rxh;
  private boolean Rxi;
  private boolean Rxj;
  private String Rxk;
  private com.tencent.mm.plugin.appbrand.openmaterial.h Rxl;
  private com.tencent.mm.plugin.appbrand.openmaterial.i Rxm;
  private String fileName;
  private String filePath;
  private String jmx;
  private MiniReaderLogic.a<Integer> oSI;
  private boolean oro;
  private boolean orp;
  private ValueCallback<String> orr;
  private ValueCallback<Integer> ors;
  private int tNG;
  private IListener<ne> tNJ;
  private String token;
  private boolean zEr;
  
  public MiniQBReaderUI()
  {
    AppMethodBeat.i(31970);
    this.filePath = "";
    this.jmx = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.oro = true;
    this.orp = false;
    this.Rxj = false;
    this.tNJ = new IListener()
    {
      private boolean a(ne paramAnonymousne)
      {
        AppMethodBeat.i(31961);
        if ((paramAnonymousne != null) && (paramAnonymousne.fLx != null) && (MiniQBReaderUI.a(MiniQBReaderUI.this) != null)) {
          if (!Util.isEqual(paramAnonymousne.fLx.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this)))
          {
            Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s event.data.filePath:%s filePath:%s", new Object[] { Integer.valueOf(paramAnonymousne.fLx.action), paramAnonymousne.fLx.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this) });
            if (paramAnonymousne.fLx.action == 3)
            {
              com.tencent.mm.xwebutil.a.ah(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              if (MiniQBReaderUI.a(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.a(MiniQBReaderUI.this).aOj();
              }
              if (MiniQBReaderUI.d(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.d(MiniQBReaderUI.this).aOj();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(31961);
          return false;
          Log.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousne.fLx.action) });
          switch (paramAnonymousne.fLx.action)
          {
          case 3: 
          default: 
            break;
          case 1: 
          case 8: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).iW(true);
            break;
          case 2: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).iW(false);
            if (MiniQBReaderUI.e(MiniQBReaderUI.this))
            {
              boolean bool = MiniQBReaderUI.f(MiniQBReaderUI.this);
              MiniReaderLogic.a(MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.k(MiniQBReaderUI.this), false, "", bool);
            }
            else
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this, false);
              com.tencent.mm.xwebutil.a.ah(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              MiniReaderLogic.a(false, false, MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, false), MiniQBReaderUI.l(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this));
            }
            break;
          case 4: 
            p.c(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), new p.a()
            {
              public final void bT(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(290454);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(R.l.toast_file_saved_fmt, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(290454);
              }
              
              public final void bU(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(290455);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(R.l.toast_file_saved_fail), 1).show();
                AppMethodBeat.o(290455);
              }
            });
            break;
          case 5: 
            if (MiniQBReaderUI.m(MiniQBReaderUI.this) != null) {
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).f(MiniQBReaderUI.m(MiniQBReaderUI.this));
            }
            break;
          case 7: 
            MiniQBReaderUI.n(MiniQBReaderUI.this);
            break;
          case 6: 
            Log.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent.UPDATE_READ_PROGRESS readState:%d", new Object[] { Integer.valueOf(paramAnonymousne.fLx.fLz) });
            if (MiniQBReaderUI.a(MiniQBReaderUI.this) == null) {
              Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent.UPDATE_READ_PROGRESS mFloatBallHelper==null");
            }
            if (paramAnonymousne.fLx.fLz == 0) {
              MiniQBReaderUI.a(MiniQBReaderUI.this).hTk();
            } else if (paramAnonymousne.fLx.fLz == 1) {
              MiniQBReaderUI.a(MiniQBReaderUI.this).hTj();
            }
            break;
          case 9: 
            MiniQBReaderUI.o(MiniQBReaderUI.this);
            break;
          case 10: 
            MiniQBReaderUI.p(MiniQBReaderUI.this);
            break;
          case 11: 
            MiniQBReaderUI.arb(2);
            MiniQBReaderUI.hnJ();
            MiniQBReaderUI.a(MiniQBReaderUI.this, false);
            if (az.a(az.hXf(), MiniQBReaderUI.this.getTaskId()) == 1) {
              MiniQBReaderUI.hAQ();
            }
            az.a(az.hXf(), MiniQBReaderUI.this.getTaskId(), 2);
            u.a(u.hHB(), MiniQBReaderUI.this.getTaskId(), 2);
            break;
          case 12: 
            MiniQBReaderUI.arb(0);
            MiniQBReaderUI.hnJ();
            MiniQBReaderUI.a(MiniQBReaderUI.this, false);
            az.a(az.hXf(), MiniQBReaderUI.this.getTaskId(), 0);
            u.a(u.hHB(), MiniQBReaderUI.this.getTaskId(), 0);
            continue;
            Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.ors = new ValueCallback() {};
    this.oSI = null;
    this.orr = new ValueCallback() {};
    this.Rxk = null;
    this.QdI = null;
    this.Rxl = null;
    this.QdJ = null;
    this.Rxm = null;
    this.zEr = false;
    AppMethodBeat.o(31970);
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(277805);
    Log.d("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask");
    Object localObject = hnH();
    if (localObject == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask, serviceAndMaterialModel is null");
      AppMethodBeat.o(277805);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)((Pair)localObject).first;
    localObject = (MaterialModel)((Pair)localObject).second;
    if ((this.filePath != null) && (this.filePath.equals(this.Rxk)) && (this.QdI != null))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask, already fetchOpenMaterials");
      paramc.a(this, locali, this.QdI);
      AppMethodBeat.o(277805);
      return;
    }
    locali.a((MaterialModel)localObject, new b(this, (MaterialModel)localObject, locali, paramc));
    AppMethodBeat.o(277805);
  }
  
  private void ara(int paramInt)
  {
    AppMethodBeat.i(277806);
    Log.d("MicroMsg.MiniQBReaderUI", "tryReportOpenMaterialEntranceExposure, curTryTimes: ".concat(String.valueOf(paramInt)));
    if (this.Rxm != null)
    {
      this.Rxm.ccU();
      AppMethodBeat.o(277806);
      return;
    }
    Log.i("MicroMsg.MiniQBReaderUI", "tryReportOpenMaterialEntranceExposure, openMaterialReporter is null");
    if (10 > paramInt) {
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(291085);
          MiniQBReaderUI.a(MiniQBReaderUI.this, this.Rxr);
          AppMethodBeat.o(291085);
        }
      }, 100L);
    }
    AppMethodBeat.o(277806);
  }
  
  private Pair<com.tencent.mm.plugin.appbrand.service.i, MaterialModel> hnH()
  {
    AppMethodBeat.i(277803);
    Log.d("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel");
    Object localObject = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.i.class);
    if (localObject == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is null");
      AppMethodBeat.o(277803);
      return null;
    }
    if (!((com.tencent.mm.plugin.appbrand.service.i)localObject).c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qns))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is not enabled");
      AppMethodBeat.o(277803);
      return null;
    }
    if (Util.isNullOrNil(this.filePath))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, filePath is empty");
      AppMethodBeat.o(277803);
      return null;
    }
    MaterialModel localMaterialModel = MaterialModel.eQ(this.filePath, this.jmx);
    if (localMaterialModel == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, materialModel is null");
      AppMethodBeat.o(277803);
      return null;
    }
    ((com.tencent.mm.plugin.appbrand.service.i)localObject).alg(localMaterialModel.mimeType);
    localObject = new Pair(localObject, localMaterialModel);
    AppMethodBeat.o(277803);
    return localObject;
  }
  
  private void hnI()
  {
    AppMethodBeat.i(277804);
    Log.d("MicroMsg.MiniQBReaderUI", "updateIsFileCanOpenByAppBrand");
    a(new f((byte)0));
    AppMethodBeat.o(277804);
  }
  
  private void init()
  {
    AppMethodBeat.i(31972);
    this.filePath = getIntent().getStringExtra("file_path");
    this.jmx = getIntent().getStringExtra("file_ext");
    this.fileName = getIntent().getStringExtra("file_name");
    this.tNG = getIntent().getIntExtra("sence", 0);
    Log.i("MicroMsg.MiniQBReaderUI", "init() filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { this.filePath, this.jmx, this.fileName, Integer.valueOf(this.tNG) });
    if (Util.isNullOrNil(this.fileName)) {}
    for (;;)
    {
      try
      {
        int j = this.filePath.lastIndexOf('/') + 1;
        if (j < 0) {
          break label773;
        }
        i = j;
        if (j == this.filePath.length()) {
          break label773;
        }
        this.fileName = this.filePath.substring(i, this.filePath.length());
      }
      catch (Exception localException)
      {
        com.tencent.mm.ui.chatting.g.a locala;
        Object localObject1;
        String str;
        Object localObject2;
        Log.e("MicroMsg.MiniQBReaderUI", "get file name error " + localException.getMessage());
        this.fileName = " ";
        continue;
        boolean bool = false;
        continue;
        if ((localException != f.a.ZZL) || (this.Rxh == null)) {
          continue;
        }
        this.Rxh.d(false, true, this.Rxg.FHd.field_id);
        AppMethodBeat.o(31972);
        return;
      }
      this.Rxf = new com.tencent.mm.ui.chatting.g.a(new com.tencent.mm.plugin.ball.a.e(getContext()));
      this.Rxf.aC(this.filePath, this.jmx, this.tNG);
      locala = this.Rxf;
      localObject1 = this.jmx;
      str = this.fileName;
      localObject2 = d.aoD((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = d.aoD("unknown");
      }
      locala.rYE.qpN = ((Integer)localObject1).intValue();
      if (Util.isNullOrNil(locala.rYE.name)) {
        locala.rYE.name = str;
      }
      locala.cvG();
      this.Rxh = new com.tencent.mm.ui.chatting.j.a(getContext());
      this.Rxg = new com.tencent.mm.ui.chatting.j.b(this.Rxh);
      this.Rxg.d(this.filePath, this.jmx, this.tNG, false);
      this.Rxg.oc(this.jmx, this.fileName);
      if (this.tNJ != null) {
        this.tNJ.alive();
      }
      if (this.zEr)
      {
        this.Rxg.bNV();
        this.Rxf.bNV();
      }
      localObject2 = this.Rxg.FHd;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).aLl(((MultiTaskInfo)localObject2).field_id);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBK();
      }
      if ((localObject2 instanceof HandOffFile))
      {
        this.HEt = ((HandOffFile)localObject2);
        this.HEt.setHandOffType(1);
        this.HEt.setKey(HandOff.generateKey(this.HEt.getDataType(), this.HEt.getHandOffType()));
        this.HEt.saveToMultiTaskInfo(this.Rxg.FHd);
        Log.i("MicroMsg.MiniQBReaderUI", "[handoff] Call onFileCreate, key = " + ((HandOff)localObject2).getKey());
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).c((HandOff)localObject2);
      }
      if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBJ()) && (this.HEt != null) && (HandOffFile.isSupportOpenFile(this.jmx)))
      {
        bool = true;
        this.Rxi = bool;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(31964);
            boolean bool = MiniQBReaderUI.f(MiniQBReaderUI.this);
            MiniReaderLogic.a(MiniQBReaderUI.a(MiniQBReaderUI.this).faQ(), MiniQBReaderUI.a(MiniQBReaderUI.this).faT(), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, true), false, "", true, bool);
            AppMethodBeat.o(31964);
          }
        });
        localObject1 = f.a(this.jmx, f.a.ZZK, false, new Intent());
        if (localObject1 != f.a.ZZM) {
          continue;
        }
        if (this.Rxg != null) {
          this.Rxg.WYK = true;
        }
        if (this.Rxh == null) {
          continue;
        }
        this.Rxh.d(true, false, this.Rxg.FHd.field_id);
        AppMethodBeat.o(31972);
      }
      label773:
      int i = 0;
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31971);
    super.onCreate(paramBundle);
    this.filePath = getIntent().getStringExtra("file_path");
    hnI();
    Log.i("MicroMsg.MiniQBReaderUI", "onCreate filePath:%s %s", new Object[] { this.filePath, toString() });
    paramBundle = new ne();
    paramBundle.fLx.action = 3;
    paramBundle.fLx.filePath = getIntent().getStringExtra("file_path");
    EventCenter.instance.asyncPublish(paramBundle, Looper.getMainLooper());
    com.tencent.e.h.ZvG.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31963);
        MiniQBReaderUI.q(MiniQBReaderUI.this);
        AppMethodBeat.o(31963);
      }
    }, 300L);
    AppMethodBeat.o(31971);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(31976);
    Log.i("MicroMsg.MiniQBReaderUI", "onDestroy %s", new Object[] { toString() });
    com.tencent.mm.xwebutil.a.ah(this, this.token, this.filePath);
    super.onDestroy();
    if (this.tNJ != null) {
      this.tNJ.dead();
    }
    if (this.Rxf != null) {
      this.Rxf.onDestroy();
    }
    if (this.HEt != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).d(this.HEt);
    }
    AppMethodBeat.o(31976);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(277807);
    if ((paramInt == 4) && (this.Rxg != null) && (this.Rxg.zH(2)))
    {
      AppMethodBeat.o(277807);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(277807);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(31973);
    super.onNewIntent(paramIntent);
    Log.i("MicroMsg.MiniQBReaderUI", "onNewIntent %s", new Object[] { toString() });
    setIntent(paramIntent);
    paramIntent = getIntent().getStringExtra("file_path");
    Log.i("MicroMsg.MiniQBReaderUI", "onNewIntent() newFilePath:%s filePath:%s", new Object[] { paramIntent, this.filePath });
    if (!Util.isEqual(paramIntent, this.filePath))
    {
      this.oro = false;
      com.tencent.mm.xwebutil.a.ah(this, this.token, this.filePath);
      if (this.Rxg != null) {
        this.Rxg.aOj();
      }
      if (this.Rxf != null)
      {
        this.Rxf.aOj();
        this.Rxf.onDestroy();
      }
      init();
      hnI();
    }
    AppMethodBeat.o(31973);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31975);
    Log.i("MicroMsg.MiniQBReaderUI", "onPause %s", new Object[] { toString() });
    super.onPause();
    if (this.Rxg != null)
    {
      this.zEr = false;
      this.Rxg.aOj();
    }
    if (this.Rxf != null) {
      this.Rxf.aOj();
    }
    AppMethodBeat.o(31975);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31974);
    Log.i("MicroMsg.MiniQBReaderUI", "onResume %s", new Object[] { toString() });
    super.onResume();
    if (this.Rxf != null) {
      this.Rxf.bNV();
    }
    if (this.Rxg != null) {
      this.Rxg.bNV();
    }
    for (;;)
    {
      if (Fvr)
      {
        if (SvG)
        {
          init();
          SvG = false;
        }
        az.a(az.hXf(), getTaskId(), pos);
        u.a(u.hHB(), getTaskId(), pos);
        Fvr = false;
      }
      AppMethodBeat.o(31974);
      return;
      this.zEr = true;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements MiniQBReaderUI.c
  {
    private final WeakReference<com.tencent.mm.ui.widget.a.e> Rxs;
    
    public a(com.tencent.mm.ui.widget.a.e parame)
    {
      AppMethodBeat.i(264806);
      this.Rxs = new WeakReference(parame);
      AppMethodBeat.o(264806);
    }
    
    public final void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.i parami, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(264808);
      com.tencent.mm.ui.widget.a.e locale = (com.tencent.mm.ui.widget.a.e)this.Rxs.get();
      if (locale == null)
      {
        Log.i("MicroMsg.MiniQBReaderUI", "tryEnhanceBottomSheet#run, bottomSheet is null");
        AppMethodBeat.o(264808);
        return;
      }
      if (!parami.a(locale, paramAppBrandOpenMaterialCollection))
      {
        Log.i("MicroMsg.MiniQBReaderUI", "tryEnhanceBottomSheet#run, not need enhance");
        AppMethodBeat.o(264808);
        return;
      }
      if (MiniQBReaderUI.v(paramMiniQBReaderUI) != null) {
        MiniQBReaderUI.v(paramMiniQBReaderUI).dead();
      }
      MiniQBReaderUI.a(paramMiniQBReaderUI, parami.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qns, paramMiniQBReaderUI, locale, paramAppBrandOpenMaterialCollection, null, null));
      AppMethodBeat.o(264808);
    }
  }
  
  static final class b
    implements k
  {
    private final com.tencent.mm.plugin.appbrand.service.i QdV;
    private final WeakReference<MiniQBReaderUI> Rxt;
    private final MiniQBReaderUI.c Rxu;
    private final MaterialModel qng;
    
    public b(MiniQBReaderUI paramMiniQBReaderUI, MaterialModel paramMaterialModel, com.tencent.mm.plugin.appbrand.service.i parami, MiniQBReaderUI.c paramc)
    {
      AppMethodBeat.i(285659);
      this.Rxt = new WeakReference(paramMiniQBReaderUI);
      this.qng = paramMaterialModel;
      this.QdV = parami;
      this.Rxu = paramc;
      AppMethodBeat.o(285659);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(285660);
      MiniQBReaderUI localMiniQBReaderUI = (MiniQBReaderUI)this.Rxt.get();
      if (localMiniQBReaderUI == null)
      {
        Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask#onMyOpenMaterialsGo, ui is null");
        AppMethodBeat.o(285660);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(285660);
        return;
      }
      MiniQBReaderUI.a(localMiniQBReaderUI, this.qng.qnl);
      MiniQBReaderUI.a(localMiniQBReaderUI, paramAppBrandOpenMaterialCollection);
      this.Rxu.a(localMiniQBReaderUI, this.QdV, paramAppBrandOpenMaterialCollection);
      AppMethodBeat.o(285660);
    }
  }
  
  static abstract interface c
  {
    public abstract void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.i parami, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  }
  
  static final class d
    implements MiniQBReaderUI.c
  {
    public final void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.i parami, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(274339);
      MiniQBReaderUI.a(paramMiniQBReaderUI, parami.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qns, paramAppBrandOpenMaterialCollection));
      AppMethodBeat.o(274339);
    }
  }
  
  static final class e
    implements MiniQBReaderUI.c
  {
    public final void a(final MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.i parami, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(203783);
      if (MiniQBReaderUI.t(paramMiniQBReaderUI) != null) {
        MiniQBReaderUI.t(paramMiniQBReaderUI).dead();
      }
      MiniQBReaderUI.a(paramMiniQBReaderUI, parami.ccL().b(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qns).a(paramMiniQBReaderUI, null, paramAppBrandOpenMaterialCollection, null, MiniQBReaderUI.u(paramMiniQBReaderUI)));
      MiniQBReaderUI.t(paramMiniQBReaderUI).a(new h.b()
      {
        public final void ccP()
        {
          AppMethodBeat.i(271860);
          Log.i("MicroMsg.MiniQBReaderUI", "onHidden, reset openMaterialReporter");
          MiniQBReaderUI.a(paramMiniQBReaderUI, null);
          AppMethodBeat.o(271860);
        }
      });
      MiniQBReaderUI.t(paramMiniQBReaderUI).show();
      AppMethodBeat.o(203783);
    }
  }
  
  static final class f
    implements MiniQBReaderUI.c
  {
    public final void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.i parami, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(278254);
      MiniQBReaderUI.c(paramMiniQBReaderUI, parami.ccL().a(paramAppBrandOpenMaterialCollection));
      AppMethodBeat.o(278254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI
 * JD-Core Version:    0.7.0.1
 */