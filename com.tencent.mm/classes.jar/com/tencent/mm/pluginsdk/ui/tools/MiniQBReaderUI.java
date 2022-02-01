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
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.mn.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.appbrand.openmaterial.g.a;
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
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import java.lang.ref.WeakReference;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI
  extends MMSecDataActivity
{
  private HandOffFile BIm;
  private AppBrandOpenMaterialCollection Jgy;
  private com.tencent.mm.plugin.appbrand.openmaterial.h Jgz;
  private boolean KvU;
  private boolean KvV;
  private String KvW;
  private com.tencent.mm.plugin.appbrand.openmaterial.g KvX;
  private boolean KvY;
  private com.tencent.mm.ui.chatting.g.a UtV;
  private com.tencent.mm.ui.chatting.multitask.b UtW;
  private com.tencent.mm.ui.chatting.multitask.a UtX;
  private String fileName;
  private String filePath;
  private String gCr;
  private MiniReaderLogic.a<Integer> lVE;
  private boolean lwG;
  private boolean lwH;
  private ValueCallback<String> lwJ;
  private ValueCallback<Integer> lwK;
  private int qoX;
  private IListener<mn> qoZ;
  private String token;
  
  public MiniQBReaderUI()
  {
    AppMethodBeat.i(31970);
    this.filePath = "";
    this.gCr = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.lwG = true;
    this.lwH = false;
    this.KvV = false;
    this.qoZ = new IListener()
    {
      private boolean a(mn paramAnonymousmn)
      {
        AppMethodBeat.i(31961);
        if ((paramAnonymousmn != null) && (paramAnonymousmn.dSa != null) && (MiniQBReaderUI.a(MiniQBReaderUI.this) != null)) {
          if (!Util.isEqual(paramAnonymousmn.dSa.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this)))
          {
            Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s event.data.filePath:%s filePath:%s", new Object[] { Integer.valueOf(paramAnonymousmn.dSa.action), paramAnonymousmn.dSa.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this) });
            if (paramAnonymousmn.dSa.action == 3)
            {
              com.tencent.mm.cr.a.Z(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              if (MiniQBReaderUI.a(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.a(MiniQBReaderUI.this).aGj();
              }
              if (MiniQBReaderUI.d(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.d(MiniQBReaderUI.this).aGj();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(31961);
          return false;
          Log.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousmn.dSa.action) });
          switch (paramAnonymousmn.dSa.action)
          {
          case 3: 
          default: 
            break;
          case 1: 
          case 8: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).ic(true);
            break;
          case 2: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).ic(false);
            if (MiniQBReaderUI.e(MiniQBReaderUI.this))
            {
              boolean bool = MiniQBReaderUI.f(MiniQBReaderUI.this);
              MiniReaderLogic.a(MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.k(MiniQBReaderUI.this), false, "", bool);
            }
            else
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this, false);
              com.tencent.mm.cr.a.Z(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              MiniReaderLogic.a(false, false, MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, false), MiniQBReaderUI.l(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this));
            }
            break;
          case 4: 
            p.c(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), new p.a()
            {
              public final void bP(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(232350);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(2131766791, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(232350);
              }
              
              public final void bQ(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(232351);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(2131766790), 1).show();
                AppMethodBeat.o(232351);
              }
            });
            break;
          case 5: 
            if (MiniQBReaderUI.m(MiniQBReaderUI.this) != null) {
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(MiniQBReaderUI.m(MiniQBReaderUI.this));
            }
            break;
          case 7: 
            MiniQBReaderUI.n(MiniQBReaderUI.this);
            break;
          case 6: 
            Log.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent.UPDATE_READ_PROGRESS readState:%d", new Object[] { Integer.valueOf(paramAnonymousmn.dSa.dSc) });
            if (MiniQBReaderUI.a(MiniQBReaderUI.this) == null) {
              Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent.UPDATE_READ_PROGRESS mFloatBallHelper==null");
            }
            if (paramAnonymousmn.dSa.dSc == 0)
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this).gTE();
            }
            else if (paramAnonymousmn.dSa.dSc == 1)
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this).gTD();
              continue;
              Log.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent fail");
            }
            break;
          }
        }
      }
    };
    this.lwK = new ValueCallback() {};
    this.lVE = null;
    this.lwJ = new ValueCallback() {};
    this.KvW = null;
    this.Jgy = null;
    this.KvX = null;
    this.Jgz = null;
    this.KvY = false;
    AppMethodBeat.o(31970);
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(232361);
    Log.d("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask");
    Object localObject = gsA();
    if (localObject == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask, serviceAndMaterialModel is null");
      AppMethodBeat.o(232361);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)((Pair)localObject).first;
    localObject = (MaterialModel)((Pair)localObject).second;
    if ((this.filePath != null) && (this.filePath.equals(this.KvW)) && (this.Jgy != null))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask, already fetchOpenMaterials");
      paramb.a(this, locali, this.Jgy);
      AppMethodBeat.o(232361);
      return;
    }
    locali.a((MaterialModel)localObject, new a(this, (MaterialModel)localObject, locali, paramb));
    AppMethodBeat.o(232361);
  }
  
  private Pair<com.tencent.mm.plugin.appbrand.service.i, MaterialModel> gsA()
  {
    AppMethodBeat.i(232359);
    Log.d("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel");
    Object localObject = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.i.class);
    if (localObject == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is null");
      AppMethodBeat.o(232359);
      return null;
    }
    if (!((com.tencent.mm.plugin.appbrand.service.i)localObject).c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlP))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is not enabled");
      AppMethodBeat.o(232359);
      return null;
    }
    if (Util.isNullOrNil(this.filePath))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, filePath is empty");
      AppMethodBeat.o(232359);
      return null;
    }
    MaterialModel localMaterialModel = MaterialModel.eC(this.filePath, this.gCr);
    if (localMaterialModel == null)
    {
      Log.w("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, materialModel is null");
      AppMethodBeat.o(232359);
      return null;
    }
    if (!((com.tencent.mm.plugin.appbrand.service.i)localObject).adl(localMaterialModel.mimeType))
    {
      Log.i("MicroMsg.MiniQBReaderUI", "prepareServiceAndMaterialModel, openMaterialService is not support " + localMaterialModel.mimeType);
      AppMethodBeat.o(232359);
      return null;
    }
    localObject = new Pair(localObject, localMaterialModel);
    AppMethodBeat.o(232359);
    return localObject;
  }
  
  private void gsB()
  {
    AppMethodBeat.i(232360);
    Log.d("MicroMsg.MiniQBReaderUI", "updateIsFileCanOpenByAppBrand");
    a(new b()
    {
      public final void a(MiniQBReaderUI paramAnonymousMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.i paramAnonymousi, AppBrandOpenMaterialCollection paramAnonymousAppBrandOpenMaterialCollection)
      {
        AppMethodBeat.i(232354);
        if (!paramAnonymousAppBrandOpenMaterialCollection.nlF.isEmpty()) {}
        for (boolean bool = true;; bool = false)
        {
          MiniQBReaderUI.c(paramAnonymousMiniQBReaderUI, bool);
          AppMethodBeat.o(232354);
          return;
        }
      }
    });
    AppMethodBeat.o(232360);
  }
  
  private void init()
  {
    AppMethodBeat.i(31972);
    this.filePath = getIntent().getStringExtra("file_path");
    this.gCr = getIntent().getStringExtra("file_ext");
    this.fileName = getIntent().getStringExtra("file_name");
    this.qoX = getIntent().getIntExtra("sence", 0);
    Log.i("MicroMsg.MiniQBReaderUI", "init() filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { this.filePath, this.gCr, this.fileName, Integer.valueOf(this.qoX) });
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
        if ((localException != f.a.SyU) || (this.UtX == null)) {
          continue;
        }
        this.UtX.e(false, true, this.UtW.Abp.field_id);
        AppMethodBeat.o(31972);
        return;
      }
      this.UtV = new com.tencent.mm.ui.chatting.g.a(new com.tencent.mm.plugin.ball.a.e(getContext()));
      this.UtV.ay(this.filePath, this.gCr, this.qoX);
      locala = this.UtV;
      localObject1 = this.gCr;
      str = this.fileName;
      localObject2 = d.agX((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = d.agX("unknown");
      }
      locala.oWE.noe = ((Integer)localObject1).intValue();
      if (Util.isNullOrNil(locala.oWE.name)) {
        locala.oWE.name = str;
      }
      locala.cit();
      this.UtX = new com.tencent.mm.ui.chatting.multitask.a(getContext());
      this.UtW = new com.tencent.mm.ui.chatting.multitask.b(this.UtX);
      this.UtW.g(this.filePath, this.gCr, this.qoX, false);
      this.UtW.ni(this.gCr, this.fileName);
      if (this.qoZ != null) {
        this.qoZ.alive();
      }
      if (this.KvY)
      {
        this.UtW.bCA();
        this.UtV.bCA();
      }
      localObject2 = this.UtW.Abp;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBx(((MultiTaskInfo)localObject2).field_id);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYm();
      }
      if ((localObject2 instanceof HandOffFile))
      {
        this.BIm = ((HandOffFile)localObject2);
        this.BIm.setHandOffType(1);
        this.BIm.setKey(HandOff.generateKey(this.BIm.getDataType(), this.BIm.getHandOffType()));
        this.BIm.saveToMultiTaskInfo(this.UtW.Abp);
        Log.i("MicroMsg.MiniQBReaderUI", "[handoff] Call onFileCreate, key = " + ((HandOff)localObject2).getKey());
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).c((HandOff)localObject2);
      }
      if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl()) && (this.BIm != null) && (HandOffFile.isSupportOpenFile(this.gCr)))
      {
        bool = true;
        this.KvU = bool;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(31964);
            boolean bool = MiniQBReaderUI.f(MiniQBReaderUI.this);
            MiniReaderLogic.a(MiniQBReaderUI.a(MiniQBReaderUI.this).eqW(), MiniQBReaderUI.a(MiniQBReaderUI.this).eqZ(), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), MiniQBReaderUI.i(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.j(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, true), false, "", true, bool);
            AppMethodBeat.o(31964);
          }
        });
        localObject1 = f.a(this.gCr, f.a.SyT, false, new Intent());
        if (localObject1 != f.a.SyV) {
          continue;
        }
        if (this.UtW != null) {
          this.UtW.PDX = true;
        }
        if (this.UtX == null) {
          continue;
        }
        this.UtX.e(true, false, this.UtW.Abp.field_id);
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
    gsB();
    Log.i("MicroMsg.MiniQBReaderUI", "onCreate filePath:%s %s", new Object[] { this.filePath, toString() });
    paramBundle = new mn();
    paramBundle.dSa.action = 3;
    paramBundle.dSa.filePath = getIntent().getStringExtra("file_path");
    EventCenter.instance.asyncPublish(paramBundle, Looper.getMainLooper());
    com.tencent.f.h.RTc.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31963);
        MiniQBReaderUI.o(MiniQBReaderUI.this);
        AppMethodBeat.o(31963);
      }
    }, 300L);
    AppMethodBeat.o(31971);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(31976);
    Log.i("MicroMsg.MiniQBReaderUI", "onDestroy %s", new Object[] { toString() });
    com.tencent.mm.cr.a.Z(this, this.token, this.filePath);
    super.onDestroy();
    if (this.qoZ != null) {
      this.qoZ.dead();
    }
    if (this.UtV != null) {
      this.UtV.onDestroy();
    }
    if (this.BIm != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(this.BIm);
    }
    AppMethodBeat.o(31976);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(232362);
    if ((paramInt == 4) && (this.UtW != null) && (this.UtW.wu(2)))
    {
      AppMethodBeat.o(232362);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(232362);
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
      this.lwG = false;
      com.tencent.mm.cr.a.Z(this, this.token, this.filePath);
      if (this.UtW != null) {
        this.UtW.aGj();
      }
      if (this.UtV != null)
      {
        this.UtV.aGj();
        this.UtV.onDestroy();
      }
      init();
      gsB();
    }
    AppMethodBeat.o(31973);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31975);
    Log.i("MicroMsg.MiniQBReaderUI", "onPause %s", new Object[] { toString() });
    super.onPause();
    if (this.UtW != null)
    {
      this.KvY = false;
      this.UtW.aGj();
    }
    if (this.UtV != null) {
      this.UtV.aGj();
    }
    AppMethodBeat.o(31975);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31974);
    Log.i("MicroMsg.MiniQBReaderUI", "onResume %s", new Object[] { toString() });
    super.onResume();
    if (this.UtV != null) {
      this.UtV.bCA();
    }
    if (this.UtW != null)
    {
      this.UtW.bCA();
      AppMethodBeat.o(31974);
      return;
    }
    this.KvY = true;
    AppMethodBeat.o(31974);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements com.tencent.mm.plugin.appbrand.openmaterial.i
  {
    private final WeakReference<MiniQBReaderUI> Kwe;
    private final com.tencent.mm.plugin.appbrand.service.i Kwf;
    private final MiniQBReaderUI.b Kwg;
    private final MaterialModel nlD;
    
    public a(MiniQBReaderUI paramMiniQBReaderUI, MaterialModel paramMaterialModel, com.tencent.mm.plugin.appbrand.service.i parami, MiniQBReaderUI.b paramb)
    {
      AppMethodBeat.i(232357);
      this.Kwe = new WeakReference(paramMiniQBReaderUI);
      this.nlD = paramMaterialModel;
      this.Kwf = parami;
      this.Kwg = paramb;
      AppMethodBeat.o(232357);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(232358);
      MiniQBReaderUI localMiniQBReaderUI = (MiniQBReaderUI)this.Kwe.get();
      if (localMiniQBReaderUI == null)
      {
        Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask#onMyOpenMaterialsGo, ui is null");
        AppMethodBeat.o(232358);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.MiniQBReaderUI", "doSomeOpenMaterialTask#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(232358);
        return;
      }
      MiniQBReaderUI.a(localMiniQBReaderUI, this.nlD.nlI);
      MiniQBReaderUI.a(localMiniQBReaderUI, paramAppBrandOpenMaterialCollection);
      this.Kwg.a(localMiniQBReaderUI, this.Kwf, paramAppBrandOpenMaterialCollection);
      AppMethodBeat.o(232358);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(MiniQBReaderUI paramMiniQBReaderUI, com.tencent.mm.plugin.appbrand.service.i parami, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI
 * JD-Core Version:    0.7.0.1
 */