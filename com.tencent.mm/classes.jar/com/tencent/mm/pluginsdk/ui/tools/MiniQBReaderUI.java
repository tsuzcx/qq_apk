package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ol;
import com.tencent.mm.autogen.a.ol.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.g.a;
import com.tencent.mm.plugin.appbrand.openmaterial.g.b;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bh;
import com.tencent.xweb.h.a;
import com.tencent.xweb.util.l;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI
  extends MMSecDataActivity
{
  private static boolean LrF = false;
  private static boolean Ytw = false;
  private static int pos = 0;
  private HandOffFile NBV;
  private com.tencent.mm.plugin.appbrand.openmaterial.i WVA;
  private AppBrandOpenMaterialCollection WVz;
  private com.tencent.mm.ui.chatting.floatball.a Ytr;
  private com.tencent.mm.ui.chatting.multitask.b Yts;
  private com.tencent.mm.ui.chatting.multitask.a Ytt;
  private boolean Ytu;
  private boolean Ytv;
  private String Ytx;
  private g Yty;
  private com.tencent.mm.plugin.appbrand.openmaterial.h Ytz;
  private String fileName;
  private String filePath;
  private boolean isOnResume;
  private String lPJ;
  private MiniReaderLogic.a<Integer> rXZ;
  private boolean rvi;
  private boolean rvj;
  private ValueCallback<String> rvl;
  private ValueCallback<Integer> rvm;
  private String token;
  private int wQW;
  private IListener<ol> wQZ;
  
  public MiniQBReaderUI()
  {
    AppMethodBeat.i(31970);
    this.filePath = "";
    this.lPJ = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.rvi = true;
    this.rvj = false;
    this.Ytv = false;
    this.wQZ = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean a(ol paramAnonymousol)
      {
        AppMethodBeat.i(31961);
        if ((paramAnonymousol != null) && (paramAnonymousol.hRf != null) && (MiniQBReaderUI.a(MiniQBReaderUI.this) != null)) {
          if (!Util.isEqual(paramAnonymousol.hRf.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this)))
          {
            Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s event.data.filePath:%s filePath:%s", new Object[] { Integer.valueOf(paramAnonymousol.hRf.action), paramAnonymousol.hRf.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this) });
            if (paramAnonymousol.hRf.action == 3)
            {
              com.tencent.mm.xwebutil.a.am(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              if (MiniQBReaderUI.a(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.a(MiniQBReaderUI.this).bhW();
              }
              if (MiniQBReaderUI.d(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.d(MiniQBReaderUI.this).bhW();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(31961);
          return false;
          Log.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousol.hRf.action) });
          switch (paramAnonymousol.hRf.action)
          {
          case 3: 
          default: 
            break;
          case 1: 
          case 8: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).ke(true);
            break;
          case 2: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).ke(false);
            if (MiniQBReaderUI.e(MiniQBReaderUI.this))
            {
              boolean bool = MiniQBReaderUI.f(MiniQBReaderUI.this);
              MiniReaderLogic.a(MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.k(MiniQBReaderUI.this), false, "", bool);
            }
            else
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this, false);
              com.tencent.mm.xwebutil.a.am(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              MiniReaderLogic.a(false, false, MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, false), MiniQBReaderUI.l(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this));
            }
            break;
          case 4: 
            ExportFileUtil.c(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), new ExportFileUtil.a()
            {
              public final void cg(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(245632);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(R.l.toast_file_saved_fmt, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(245632);
              }
              
              public final void ch(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(245635);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(R.l.toast_file_saved_fail), 1).show();
                AppMethodBeat.o(245635);
              }
            });
            break;
          case 5: 
            if (MiniQBReaderUI.m(MiniQBReaderUI.this) != null) {
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).f(MiniQBReaderUI.m(MiniQBReaderUI.this));
            }
            break;
          case 7: 
            MiniQBReaderUI.n(MiniQBReaderUI.this);
            break;
          case 6: 
            Log.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent.UPDATE_READ_PROGRESS readState:%d", new Object[] { Integer.valueOf(paramAnonymousol.hRf.hRh) });
            if (MiniQBReaderUI.a(MiniQBReaderUI.this) == null) {
              Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent.UPDATE_READ_PROGRESS mFloatBallHelper==null");
            }
            if (paramAnonymousol.hRf.hRh == 0) {
              MiniQBReaderUI.a(MiniQBReaderUI.this).jwL();
            } else if (paramAnonymousol.hRf.hRh == 1) {
              MiniQBReaderUI.a(MiniQBReaderUI.this).jwK();
            }
            break;
          case 9: 
            MiniQBReaderUI.o(MiniQBReaderUI.this);
            break;
          case 10: 
            MiniQBReaderUI.p(MiniQBReaderUI.this);
            break;
          case 11: 
            MiniQBReaderUI.axh(2);
            MiniQBReaderUI.iOB();
            MiniQBReaderUI.a(MiniQBReaderUI.this, false);
            if (bh.a(bh.jBC(), MiniQBReaderUI.this.getTaskId()) == 1) {
              MiniQBReaderUI.iOC();
            }
            ag.nX(MiniQBReaderUI.this.getTaskId(), 2);
            break;
          case 12: 
            MiniQBReaderUI.axh(0);
            MiniQBReaderUI.iOB();
            MiniQBReaderUI.a(MiniQBReaderUI.this, false);
            ag.nX(MiniQBReaderUI.this.getTaskId(), 0);
            continue;
            Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.rvm = new ValueCallback() {};
    this.rXZ = null;
    this.rvl = new ValueCallback() {};
    this.Ytx = null;
    this.WVz = null;
    this.Yty = null;
    this.WVA = null;
    this.Ytz = null;
    this.isOnResume = false;
    AppMethodBeat.o(31970);
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(245486);
    Log.d("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask");
    Object localObject = iOz();
    if (localObject == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask, serviceAndMaterialModel is null");
      AppMethodBeat.o(245486);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.j localj = (com.tencent.mm.plugin.appbrand.service.j)((Pair)localObject).first;
    localObject = (MaterialModel)((Pair)localObject).second;
    if ((this.filePath != null) && (this.filePath.equals(this.Ytx)) && (this.WVz != null))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask, already fetchOpenMaterials");
      paramc.a(this, localj, this.WVz);
      AppMethodBeat.o(245486);
      return;
    }
    localj.a((MaterialModel)localObject, new b(this, (MaterialModel)localObject, localj, paramc));
    AppMethodBeat.o(245486);
  }
  
  private void axg(int paramInt)
  {
    AppMethodBeat.i(245488);
    Log.d("MicroMsg.MiniQBReaderUI", "tryReportOpenMaterialEntranceExposure, curTryTimes: ".concat(String.valueOf(paramInt)));
    if (this.Ytz != null)
    {
      this.Ytz.cDs();
      AppMethodBeat.o(245488);
      return;
    }
    Log.i("MicroMsg.MiniQBReaderUI", "tryReportOpenMaterialEntranceExposure, openMaterialReporter is null");
    if (10 > paramInt) {
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(245641);
          MiniQBReaderUI.a(MiniQBReaderUI.this, this.YtE);
          AppMethodBeat.o(245641);
        }
      }, 100L);
    }
    AppMethodBeat.o(245488);
  }
  
  private void iOA()
  {
    AppMethodBeat.i(245485);
    Log.d("MicroMsg.MiniQBReaderUI", "updateIsFileCanOpenByAppBrand");
    a(new f((byte)0));
    AppMethodBeat.o(245485);
  }
  
  private Pair<com.tencent.mm.plugin.appbrand.service.j, MaterialModel> iOz()
  {
    AppMethodBeat.i(245482);
    Log.d("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel");
    Object localObject = (com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.j.class);
    if (localObject == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is null");
      AppMethodBeat.o(245482);
      return null;
    }
    if (!((com.tencent.mm.plugin.appbrand.service.j)localObject).c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is not enabled");
      AppMethodBeat.o(245482);
      return null;
    }
    if (Util.isNullOrNil(this.filePath))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, filePath is empty");
      AppMethodBeat.o(245482);
      return null;
    }
    MaterialModel localMaterialModel = MaterialModel.fh(this.filePath, this.lPJ);
    if (localMaterialModel == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, materialModel is null");
      AppMethodBeat.o(245482);
      return null;
    }
    if (!((com.tencent.mm.plugin.appbrand.service.j)localObject).aen(localMaterialModel.mimeType))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is not support " + localMaterialModel.mimeType);
      AppMethodBeat.o(245482);
      return null;
    }
    localObject = new Pair(localObject, localMaterialModel);
    AppMethodBeat.o(245482);
    return localObject;
  }
  
  private void init()
  {
    AppMethodBeat.i(31972);
    this.filePath = getIntent().getStringExtra("file_path");
    this.lPJ = getIntent().getStringExtra("file_ext");
    this.fileName = getIntent().getStringExtra("file_name");
    this.wQW = getIntent().getIntExtra("sence", 0);
    Log.i("MicroMsg.MiniQBReaderUI", "init() filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { this.filePath, this.lPJ, this.fileName, Integer.valueOf(this.wQW) });
    if (Util.isNullOrNil(this.fileName)) {}
    for (;;)
    {
      try
      {
        int j = this.filePath.lastIndexOf('/') + 1;
        if (j < 0) {
          break label704;
        }
        i = j;
        if (j == this.filePath.length()) {
          break label704;
        }
        this.fileName = this.filePath.substring(i, this.filePath.length());
      }
      catch (Exception localException)
      {
        Object localObject2;
        Object localObject1;
        Log.e("MicroMsg.MiniQBReaderUI", "get file name error " + localException.getMessage());
        this.fileName = " ";
        continue;
        boolean bool = false;
        continue;
        if ((localException != h.a.aieu) || (this.Ytt == null)) {
          continue;
        }
        this.Ytt.e(false, true, this.Yts.LCE.field_id);
        AppMethodBeat.o(31972);
        return;
      }
      this.Ytr = new com.tencent.mm.ui.chatting.floatball.a(new e(getContext()));
      this.Ytr.d(this.filePath, this.lPJ, this.wQW, false);
      this.Ytr.qa(this.lPJ, this.fileName);
      this.Ytt = new com.tencent.mm.ui.chatting.multitask.a(getContext());
      this.Yts = new com.tencent.mm.ui.chatting.multitask.b(this.Ytt);
      this.Yts.d(this.filePath, this.lPJ, this.wQW, false);
      this.Yts.qa(this.lPJ, this.fileName);
      if (this.wQZ != null) {
        this.wQZ.alive();
      }
      if (this.isOnResume)
      {
        this.Yts.coi();
        this.Ytr.coi();
      }
      localObject2 = this.Yts.LCE;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).aIc(((MultiTaskInfo)localObject2).field_id);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJM();
      }
      if ((localObject2 instanceof HandOffFile))
      {
        this.NBV = ((HandOffFile)localObject2);
        this.NBV.setHandOffType(1);
        this.NBV.setKey(HandOff.generateKey(this.NBV.getDataType(), this.NBV.getHandOffType()));
        this.NBV.saveToMultiTaskInfo(this.Yts.LCE);
        Log.i("MicroMsg.MiniQBReaderUI", "[handoff] Call onFileCreate, key = " + ((HandOff)localObject2).getKey());
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).c((HandOff)localObject2);
      }
      if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJL()) && (this.NBV != null) && (HandOffFile.isSupportOpenFile(this.lPJ)))
      {
        bool = true;
        this.Ytu = bool;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(31964);
            boolean bool = MiniQBReaderUI.f(MiniQBReaderUI.this);
            MiniReaderLogic.a(MiniQBReaderUI.a(MiniQBReaderUI.this).gjV(), MiniQBReaderUI.a(MiniQBReaderUI.this).gjZ(), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, true), false, "", true, bool);
            AppMethodBeat.o(31964);
          }
        });
        localObject1 = com.tencent.xweb.h.a(this.lPJ, h.a.aiet, false, new Intent());
        if (localObject1 != h.a.aiev) {
          continue;
        }
        if (this.Yts != null) {
          this.Yts.aeIk = true;
        }
        if (this.Ytt == null) {
          continue;
        }
        this.Ytt.e(true, false, this.Yts.LCE.field_id);
        AppMethodBeat.o(31972);
      }
      label704:
      int i = 0;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(245571);
    if (this.Ytr != null) {
      this.Ytr.finish();
    }
    super.finish();
    AppMethodBeat.o(245571);
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
    iOA();
    Log.i("MicroMsg.MiniQBReaderUI", "onCreate filePath:%s %s", new Object[] { this.filePath, toString() });
    paramBundle = new ol();
    paramBundle.hRf.action = 3;
    paramBundle.hRf.filePath = getIntent().getStringExtra("file_path");
    paramBundle.asyncPublish(Looper.getMainLooper());
    com.tencent.threadpool.h.ahAA.p(new Runnable()
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
    com.tencent.mm.xwebutil.a.am(this, this.token, this.filePath);
    super.onDestroy();
    if (this.wQZ != null) {
      this.wQZ.dead();
    }
    if (this.Ytr != null) {
      this.Ytr.onDestroy();
    }
    if (this.NBV != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).d(this.NBV);
    }
    AppMethodBeat.o(31976);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(245574);
    if ((paramInt == 4) && (this.Yts != null) && (this.Yts.zX(2)))
    {
      AppMethodBeat.o(245574);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(245574);
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
      this.rvi = false;
      com.tencent.mm.xwebutil.a.am(this, this.token, this.filePath);
      if (this.Yts != null) {
        this.Yts.bhW();
      }
      if (this.Ytr != null)
      {
        this.Ytr.bhW();
        this.Ytr.onDestroy();
      }
      init();
      iOA();
    }
    AppMethodBeat.o(31973);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31975);
    Log.i("MicroMsg.MiniQBReaderUI", "onPause %s", new Object[] { toString() });
    super.onPause();
    if (this.Yts != null)
    {
      this.isOnResume = false;
      this.Yts.bhW();
    }
    if (this.Ytr != null) {
      this.Ytr.bhW();
    }
    AppMethodBeat.o(31975);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31974);
    Log.i("MicroMsg.MiniQBReaderUI", "onResume %s", new Object[] { toString() });
    super.onResume();
    if (this.Ytr != null) {
      this.Ytr.coi();
    }
    if (this.Yts != null) {
      this.Yts.coi();
    }
    for (;;)
    {
      if (LrF)
      {
        if (Ytw)
        {
          init();
          Ytw = false;
        }
        ag.nX(getTaskId(), pos);
        LrF = false;
      }
      AppMethodBeat.o(31974);
      return;
      this.isOnResume = true;
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
    private final WeakReference<com.tencent.mm.ui.widget.a.f> YtF;
    
    public a(com.tencent.mm.ui.widget.a.f paramf)
    {
      AppMethodBeat.i(245616);
      this.YtF = new WeakReference(paramf);
      AppMethodBeat.o(245616);
    }
    
    public final void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.j paramj, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(245624);
      com.tencent.mm.ui.widget.a.f localf = (com.tencent.mm.ui.widget.a.f)this.YtF.get();
      if (localf == null)
      {
        Log.i("MicroMsg.MiniQBReaderUI", "tryEnhanceBottomSheet#run, bottomSheet is null");
        AppMethodBeat.o(245624);
        return;
      }
      if (!paramj.a(localf, paramAppBrandOpenMaterialCollection))
      {
        Log.i("MicroMsg.MiniQBReaderUI", "tryEnhanceBottomSheet#run, not need enhance");
        AppMethodBeat.o(245624);
        return;
      }
      if (MiniQBReaderUI.v(paramMiniQBReaderUI) != null) {
        MiniQBReaderUI.v(paramMiniQBReaderUI).dead();
      }
      MiniQBReaderUI.a(paramMiniQBReaderUI, paramj.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ, paramMiniQBReaderUI, localf, paramAppBrandOpenMaterialCollection, null, null));
      AppMethodBeat.o(245624);
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.appbrand.openmaterial.j
  {
    private final com.tencent.mm.plugin.appbrand.service.j WVQ;
    private final WeakReference<MiniQBReaderUI> YtG;
    private final MiniQBReaderUI.c YtH;
    private final MaterialModel trN;
    
    public b(MiniQBReaderUI paramMiniQBReaderUI, MaterialModel paramMaterialModel, com.tencent.mm.plugin.appbrand.service.j paramj, MiniQBReaderUI.c paramc)
    {
      AppMethodBeat.i(245621);
      this.YtG = new WeakReference(paramMiniQBReaderUI);
      this.trN = paramMaterialModel;
      this.WVQ = paramj;
      this.YtH = paramc;
      AppMethodBeat.o(245621);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(245626);
      MiniQBReaderUI localMiniQBReaderUI = (MiniQBReaderUI)this.YtG.get();
      if (localMiniQBReaderUI == null)
      {
        Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask#onMyOpenMaterialsGo, ui is null");
        AppMethodBeat.o(245626);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(245626);
        return;
      }
      MiniQBReaderUI.a(localMiniQBReaderUI, this.trN.trT);
      MiniQBReaderUI.a(localMiniQBReaderUI, paramAppBrandOpenMaterialCollection);
      this.YtH.a(localMiniQBReaderUI, this.WVQ, paramAppBrandOpenMaterialCollection);
      AppMethodBeat.o(245626);
    }
  }
  
  static abstract interface c
  {
    public abstract void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.j paramj, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  }
  
  static final class d
    implements MiniQBReaderUI.c
  {
    public final void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.j paramj, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(245631);
      MiniQBReaderUI.a(paramMiniQBReaderUI, paramj.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ, paramAppBrandOpenMaterialCollection));
      AppMethodBeat.o(245631);
    }
  }
  
  static final class e
    implements MiniQBReaderUI.c
  {
    public final void a(final MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.j paramj, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(245611);
      if (MiniQBReaderUI.t(paramMiniQBReaderUI) != null) {
        MiniQBReaderUI.t(paramMiniQBReaderUI).dead();
      }
      MiniQBReaderUI.a(paramMiniQBReaderUI, paramj.cDh().b(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trZ).a(paramMiniQBReaderUI, null, paramAppBrandOpenMaterialCollection, null, MiniQBReaderUI.u(paramMiniQBReaderUI)));
      MiniQBReaderUI.t(paramMiniQBReaderUI).a(new g.b()
      {
        public final void onHidden()
        {
          AppMethodBeat.i(245492);
          Log.i("MicroMsg.MiniQBReaderUI", "onHidden, reset openMaterialReporter");
          MiniQBReaderUI.a(paramMiniQBReaderUI, null);
          AppMethodBeat.o(245492);
        }
      });
      MiniQBReaderUI.t(paramMiniQBReaderUI).show();
      AppMethodBeat.o(245611);
    }
  }
  
  static final class f
    implements MiniQBReaderUI.c
  {
    public final void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.j paramj, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(245617);
      MiniQBReaderUI.c(paramMiniQBReaderUI, paramj.cDh().a(paramAppBrandOpenMaterialCollection));
      AppMethodBeat.o(245617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI
 * JD-Core Version:    0.7.0.1
 */