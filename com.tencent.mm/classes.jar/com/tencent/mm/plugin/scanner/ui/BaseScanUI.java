package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.sn;
import com.tencent.mm.autogen.a.vz;
import com.tencent.mm.autogen.a.wa;
import com.tencent.mm.autogen.a.x;
import com.tencent.mm.autogen.a.x.a;
import com.tencent.mm.autogen.mmdata.rpt.rg;
import com.tencent.mm.autogen.mmdata.rpt.um;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.BaseBoxDialogView;
import com.tencent.mm.plugin.scanner.d.a.2;
import com.tencent.mm.plugin.scanner.d.a.c;
import com.tencent.mm.plugin.scanner.g.e.a;
import com.tencent.mm.plugin.scanner.g.g.b;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ScanProductInfo;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.ai;
import com.tencent.mm.plugin.scanner.model.ak;
import com.tencent.mm.plugin.scanner.model.ak.b;
import com.tencent.mm.plugin.scanner.model.al;
import com.tencent.mm.plugin.scanner.model.al.b;
import com.tencent.mm.plugin.scanner.model.am;
import com.tencent.mm.plugin.scanner.model.an;
import com.tencent.mm.plugin.scanner.model.ao;
import com.tencent.mm.plugin.scanner.model.d.a;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.scan_goods_new.j;
import com.tencent.mm.plugin.scanner.ui.component.ScanUITopOpButtonComponent;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeProductMergeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanProductMaskDecorView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanProductMaskDecorView.e;
import com.tencent.mm.plugin.scanner.ui.widget.ScanProductMaskDecorView.f;
import com.tencent.mm.plugin.scanner.ui.widget.ScanScrollTabView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.b.d;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.y;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.ScanIdentifyReportInfo;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class BaseScanUI
  extends MMSecDataActivity
  implements e.a, com.tencent.mm.plugin.scanner.model.h, com.tencent.mm.plugin.scanner.view.c
{
  private com.tencent.mm.modelgeo.d Hji;
  private int LvA;
  private nq OMI;
  private boolean OMv;
  private boolean OMw;
  private ScanSharedMaskView OSP;
  private ScanInfoMaskView OSQ;
  private DialogInterface.OnCancelListener OTa;
  private boolean OTm;
  private boolean OTn;
  private com.tencent.mm.plugin.scanner.box.i OUu;
  private int[] OXA;
  private int OXB;
  private boolean OXC;
  private boolean OXD;
  private boolean OXE;
  private BaseScanRequest OXF;
  private boolean OXG;
  private boolean OXH;
  private boolean OXI;
  private boolean OXJ;
  private ai OXK;
  private boolean OXL;
  private um OXM;
  private int OXN;
  private boolean OXO;
  private boolean OXP;
  private boolean OXQ;
  private boolean OXR;
  private boolean OXS;
  private boolean OXT;
  private boolean OXU;
  private boolean OXV;
  private int OXW;
  private ArrayList<Integer> OXX;
  private final com.tencent.mm.plugin.scanner.scan_goods_new.f OXY;
  private final com.tencent.mm.plugin.scanner.box.g OXZ;
  private ScanUIRectView OXi;
  private ScannerFlashSwitcher OXj;
  private ScanProductMaskDecorView OXk;
  private View OXl;
  private ScanUITopOpButtonComponent OXm;
  private int OXn;
  private com.tencent.mm.plugin.scanner.g.f OXo;
  private com.tencent.mm.plugin.scanner.ui.widget.b OXp;
  private boolean OXq;
  private boolean OXr;
  private boolean OXs;
  private boolean OXt;
  private long OXu;
  private boolean OXv;
  private boolean OXw;
  private boolean OXx;
  private boolean OXy;
  private boolean OXz;
  private final al OYa;
  private ak OYb;
  private final ak.b OYc;
  private final ScanProductMaskDecorView.f OYd;
  private int OYe;
  private final ScanProductMaskDecorView.e OYf;
  private ScanUIRectView.a OYg;
  private final a.c OYh;
  private final com.tencent.mm.plugin.scanner.g.a.a OYi;
  private final com.tencent.mm.plugin.scanner.box.g OYj;
  private com.tencent.mm.network.p OYk;
  private IListener OYl;
  private FrameLayout container;
  private int enterScene;
  private Vibrator uAL;
  private com.tencent.mm.ui.widget.a.f ucS;
  private b.a wGt;
  private IListener<acn> xeK;
  
  public BaseScanUI()
  {
    AppMethodBeat.i(51728);
    this.OUu = null;
    this.OXn = 0;
    this.OXq = false;
    this.OXr = true;
    this.OXs = true;
    this.OXt = false;
    this.OTm = true;
    this.OXv = true;
    this.OXw = true;
    this.OXx = true;
    this.OXy = true;
    this.OXz = false;
    this.OXH = false;
    this.OXI = true;
    this.OXJ = true;
    this.OXK = new ai();
    this.OXL = true;
    this.OXM = new um();
    this.OXO = false;
    this.OTn = false;
    this.OXP = false;
    this.OXQ = false;
    this.OXR = false;
    this.OXS = false;
    this.OXT = true;
    this.OXU = true;
    this.OXV = false;
    this.OXW = 4;
    this.OXX = new ArrayList();
    this.OXY = new com.tencent.mm.plugin.scanner.scan_goods_new.f()
    {
      public final void a(com.tencent.mm.plugin.scanner.scan_goods_new.i paramAnonymousi, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(314993);
        int i;
        if (BaseScanUI.a(BaseScanUI.this) != null)
        {
          paramAnonymousString = paramAnonymousi.OWf;
          i = BaseScanUI.a(BaseScanUI.this).kk(paramAnonymousString);
          if ((i > 0) && (i <= paramAnonymousString.size()))
          {
            if (paramAnonymousInt == 1001) {
              break label134;
            }
            paramAnonymousInt = 1002;
          }
        }
        label134:
        for (;;)
        {
          paramAnonymousString = (com.tencent.mm.plugin.scanner.scan_goods_new.h)paramAnonymousString.get(i - 1);
          am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 3, i, BaseScanUI.a(BaseScanUI.this).getTotalProductCount(), BaseScanUI.d(BaseScanUI.this), paramAnonymousi.hBk, paramAnonymousi.OVD, paramAnonymousString.OWd, paramAnonymousString.status, paramAnonymousString.title, paramAnonymousInt);
          AppMethodBeat.o(314993);
          return;
        }
      }
      
      public final void b(com.tencent.mm.plugin.scanner.scan_goods_new.i paramAnonymousi)
      {
        AppMethodBeat.i(314988);
        if (BaseScanUI.a(BaseScanUI.this) != null) {
          BaseScanUI.a(BaseScanUI.this).kk(paramAnonymousi.OWf);
        }
        AppMethodBeat.o(314988);
      }
      
      public final boolean b(final com.tencent.mm.plugin.scanner.scan_goods_new.k paramAnonymousk)
      {
        AppMethodBeat.i(314985);
        if (!BaseScanUI.a(BaseScanUI.this, paramAnonymousk))
        {
          Log.w("MicroMsg.ScanUI", "onAddScanProductResult can not add now");
          AppMethodBeat.o(314985);
          return false;
        }
        if (BaseScanUI.a(BaseScanUI.this) != null)
        {
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(314536);
              ScanProductMaskDecorView localScanProductMaskDecorView = BaseScanUI.a(BaseScanUI.this);
              com.tencent.mm.plugin.scanner.scan_goods_new.k localk = paramAnonymousk;
              if (localk != null)
              {
                Object localObject1 = localk.OWA;
                Object localObject2 = (Collection)localObject1;
                int i;
                List localList;
                int k;
                label95:
                Rect localRect;
                if ((localObject2 == null) || (((Collection)localObject2).isEmpty()))
                {
                  i = 1;
                  if (i != 0) {
                    break label441;
                  }
                  localList = (List)new ArrayList();
                  i = 0;
                  k = localScanProductMaskDecorView.getTotalProductCount();
                  Iterator localIterator = ((Iterable)localObject1).iterator();
                  if (!localIterator.hasNext()) {
                    break label405;
                  }
                  localObject2 = (j)localIterator.next();
                  localRect = null;
                  j = i;
                  if (localObject2 != null)
                  {
                    localObject1 = localRect;
                    if (((j)localObject2).OWh.getId() > localScanProductMaskDecorView.getLastId())
                    {
                      localObject1 = localRect;
                      if (((j)localObject2).OWh.getShouldShow())
                      {
                        localScanProductMaskDecorView.setLastId(((j)localObject2).OWh.getId());
                        localObject1 = localObject2;
                      }
                    }
                    localRect = new Rect();
                    j = localScanProductMaskDecorView.getWidth();
                    int m = localScanProductMaskDecorView.getHeight();
                    localRect.set((int)(j * ((j)localObject2).OWh.getX1()), (int)(m * ((j)localObject2).OWh.getY1()), (int)(j * ((j)localObject2).OWh.getX2()), (int)(m * ((j)localObject2).OWh.getY2()));
                    j = i;
                    if (localObject1 != null) {
                      if (i == 0)
                      {
                        localObject1 = ScanProductMaskDecorView.a((j)localObject1);
                        if (localObject1 != null) {
                          break label334;
                        }
                        i = 0;
                        label281:
                        if (i == 0) {
                          break label400;
                        }
                      }
                    }
                  }
                }
                label400:
                for (int j = 1;; j = 0)
                {
                  Log.i("MicroMsg.ScanProductMaskDecorView", "updateProductInfo  info:" + localObject2 + "   ");
                  localList.add(localRect);
                  i = j;
                  break label95;
                  i = 0;
                  break;
                  label334:
                  if (localScanProductMaskDecorView.PgP == 0)
                  {
                    Log.i("MicroMsg.ScanProductMaskDecorView", kotlin.g.b.s.X("addNewProduct:", Integer.valueOf(((j)localObject1).OWh.getId())));
                    localScanProductMaskDecorView.a((j)localObject1, localRect);
                    i = 1;
                    break label281;
                  }
                  Log.w("MicroMsg.ScanProductMaskDecorView", kotlin.g.b.s.X("addNewProduct fail, scanProductListState:", Integer.valueOf(localScanProductMaskDecorView.PgP)));
                  i = 0;
                  break label281;
                }
                label405:
                if (i != 0)
                {
                  localObject1 = localScanProductMaskDecorView.PgN;
                  if (localObject1 != null) {
                    ((ScanProductMaskDecorView.e)localObject1).b(localk.OVD, localk.hBk, k + 1);
                  }
                }
              }
              label441:
              AppMethodBeat.o(314536);
            }
          });
          AppMethodBeat.o(314985);
          return true;
        }
        AppMethodBeat.o(314985);
        return false;
      }
      
      public final void c(com.tencent.mm.plugin.scanner.scan_goods_new.i paramAnonymousi)
      {
        AppMethodBeat.i(314995);
        if (BaseScanUI.a(BaseScanUI.this) != null)
        {
          Object localObject = paramAnonymousi.OWf;
          int i = BaseScanUI.a(BaseScanUI.this).kk((List)localObject);
          Log.i("MicroMsg.ScanUI", "onRetrievalImageSuccess pos:".concat(String.valueOf(i)));
          if ((i > 0) && (i <= ((ArrayList)localObject).size()))
          {
            localObject = (com.tencent.mm.plugin.scanner.scan_goods_new.h)((ArrayList)localObject).get(i - 1);
            if ((localObject != null) && (((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).state == 4)) {
              am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 4, i, BaseScanUI.a(BaseScanUI.this).getTotalProductCount(), BaseScanUI.d(BaseScanUI.this), paramAnonymousi.hBk, paramAnonymousi.OVD, ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).OWd, ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).status, ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).title, 0);
            }
          }
        }
        AppMethodBeat.o(314995);
      }
      
      public final void d(com.tencent.mm.plugin.scanner.scan_goods_new.i paramAnonymousi)
      {
        AppMethodBeat.i(314997);
        if (BaseScanUI.a(BaseScanUI.this) != null)
        {
          Object localObject = paramAnonymousi.OWf;
          int i = BaseScanUI.a(BaseScanUI.this).kk((List)localObject);
          if ((i > 0) && (i <= ((ArrayList)localObject).size()))
          {
            localObject = (com.tencent.mm.plugin.scanner.scan_goods_new.h)((ArrayList)localObject).get(i - 1);
            am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 3, i, BaseScanUI.a(BaseScanUI.this).getTotalProductCount(), BaseScanUI.d(BaseScanUI.this), paramAnonymousi.hBk, paramAnonymousi.OVD, ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).OWd, ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).status, ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).title, 1004);
          }
        }
        AppMethodBeat.o(314997);
      }
    };
    this.OXZ = new com.tencent.mm.plugin.scanner.box.g()
    {
      public final void L(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(314582);
        Log.i("MicroMsg.ScanUI", "alvinluo scanProductDialog onDismiss exitType: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseScanUI.f(BaseScanUI.this);
        if (BaseScanUI.g(BaseScanUI.this) == 0)
        {
          BaseScanUI.e(BaseScanUI.this).Cm(true);
          BaseScanUI.this.gQM();
        }
        BaseScanUI.h(BaseScanUI.this);
        BaseScanUI.i(BaseScanUI.this);
        BaseScanUI.a(BaseScanUI.this, true);
        am.tY(System.currentTimeMillis());
        am.a(BaseScanUI.j(BaseScanUI.this), paramAnonymousInt, BaseScanUI.k(BaseScanUI.this));
        AppMethodBeat.o(314582);
      }
      
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(314585);
        Log.i("MicroMsg.ScanUI", "alvinluo scanProductDialog onCancel");
        BaseScanUI.b(BaseScanUI.this, false);
        BaseScanUI.f(BaseScanUI.this);
        BaseScanUI.h(BaseScanUI.this);
        BaseScanUI.i(BaseScanUI.this);
        AppMethodBeat.o(314585);
      }
      
      public final void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(314576);
        Log.i("MicroMsg.ScanUI", "alvinluo scanProductDialog onShow");
        BaseScanUI.e(BaseScanUI.this).Cm(false);
        BaseScanUI.a(BaseScanUI.this, false);
        am.tX(System.currentTimeMillis());
        AppMethodBeat.o(314576);
      }
    };
    this.OYa = new al(this.OXZ);
    this.OYb = null;
    this.OYc = new ak.b()
    {
      public final void a(com.tencent.mm.plugin.scanner.scan_goods_new.i paramAnonymousi)
      {
        AppMethodBeat.i(314991);
        if (!paramAnonymousi.OWf.isEmpty())
        {
          com.tencent.mm.plugin.scanner.scan_goods_new.h localh = (com.tencent.mm.plugin.scanner.scan_goods_new.h)paramAnonymousi.OWf.get(0);
          BaseScanUI.a(BaseScanUI.this, localh, true, -1, -1);
        }
        am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 15, BaseScanUI.d(BaseScanUI.this), paramAnonymousi.hBk);
        com.tencent.mm.plugin.scanner.model.d.a(42, paramAnonymousi.OWg);
        if (paramAnonymousi.source == 4) {
          am.ag(true, paramAnonymousi.source);
        }
        AppMethodBeat.o(314991);
      }
      
      public final void a(com.tencent.mm.plugin.scanner.scan_goods_new.i paramAnonymousi, int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(314998);
        Log.e("MicroMsg.ScanUI", "onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        String str = paramAnonymousString;
        if (Util.isNullOrNil(paramAnonymousString)) {
          str = BaseScanUI.this.getResources().getString(l.i.OLB);
        }
        com.tencent.mm.ui.base.k.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(l.i.app_ok), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(51708);
            BaseScanUI.this.gQM();
            am.ahX(BaseScanUI.b(BaseScanUI.this));
            AppMethodBeat.o(51708);
          }
        });
        am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 14, BaseScanUI.d(BaseScanUI.this), paramAnonymousi.hBk);
        if (paramAnonymousi.source == 4) {
          am.ag(false, paramAnonymousi.source);
        }
        AppMethodBeat.o(314998);
      }
    };
    this.OYd = new ScanProductMaskDecorView.f()
    {
      public final void a(com.tencent.mm.plugin.scanner.scan_goods_new.h paramAnonymoush, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(314506);
        Object localObject = paramAnonymoush.OVE;
        if (localObject != null)
        {
          localObject = ((j)localObject).OWg;
          if (localObject != null)
          {
            ((d.a)localObject).ORn = paramAnonymoush.status;
            ((d.a)localObject).ORo = paramAnonymoush.OWd;
          }
          com.tencent.mm.plugin.scanner.model.d.a(3, (d.a)localObject);
          com.tencent.mm.plugin.scanner.model.d.a(38, (d.a)localObject);
        }
        BaseScanUI.a(BaseScanUI.this, paramAnonymoush, false, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(314506);
      }
    };
    this.OYe = 0;
    this.OYf = new ScanProductMaskDecorView.e()
    {
      public final void air(int paramAnonymousInt)
      {
        AppMethodBeat.i(314516);
        Log.i("MicroMsg.ScanUI", "onProductListStateChange:".concat(String.valueOf(paramAnonymousInt)));
        BaseScanUI.a(BaseScanUI.this, paramAnonymousInt);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(314516);
          return;
          BaseScanUI.n(BaseScanUI.this).gSO();
          AppMethodBeat.o(314516);
          return;
          com.tencent.threadpool.h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(314468);
              BaseScanUI.this.gQM();
              BaseScanUI.c(BaseScanUI.this, true);
              BaseScanUI.e(BaseScanUI.this).Cm(true);
              AppMethodBeat.o(314468);
            }
          }, 250L);
          AppMethodBeat.o(314516);
          return;
          BaseScanUI.this.gSt();
          BaseScanUI.n(BaseScanUI.this).getScanMaskView().setScanSource(3);
          BaseScanUI.n(BaseScanUI.this).getScanMaskView().iZ(BaseScanUI.n(BaseScanUI.this).getTextrueView());
          BaseScanUI.c(BaseScanUI.this, false);
          BaseScanUI.e(BaseScanUI.this).Cm(false);
          AppMethodBeat.o(314516);
          return;
          ScanUIRectView localScanUIRectView = BaseScanUI.n(BaseScanUI.this);
          if (localScanUIRectView.OOu == 0L)
          {
            localScanUIRectView.OOu = System.currentTimeMillis();
            Log.i("MicroMsg.ScanUIRectView", "startNewSession:" + localScanUIRectView.OOu);
            if (!localScanUIRectView.ahwr.isOpen())
            {
              Log.i("MicroMsg.ScanUIRectView", "startNewSession openCamera");
              localScanUIRectView.a(null);
            }
            for (;;)
            {
              com.tencent.qbar.h.jWV().a(localScanUIRectView.OOu, localScanUIRectView.getScanCodeTabType(), localScanUIRectView.getSessionInfo(), localScanUIRectView.Pcc);
              com.tencent.mm.plugin.scanner.d.b.gQw().gQx();
              AppMethodBeat.o(314516);
              return;
              if (!localScanUIRectView.ahwr.boa())
              {
                Log.i("MicroMsg.ScanUIRectView", "startNewSession startPreview");
                ((com.tencent.mm.plugin.scanner.a.a)localScanUIRectView.ahwr).gQb();
                localScanUIRectView.a(new ScanUIRectView.12(localScanUIRectView));
                Log.i("MicroMsg.ScanUIRectView", "startNewSession focus mode %s", new Object[] { localScanUIRectView.ahwr.jXJ() });
              }
              else
              {
                Log.i("MicroMsg.ScanUIRectView", "startNewSession camera is previewing");
                Log.i("MicroMsg.ScanUIRectView", "startNewSession  focus mode %s", new Object[] { localScanUIRectView.ahwr.jXJ() });
                localScanUIRectView.ua(0L);
              }
            }
          }
          Log.w("MicroMsg.ScanUIRectView", "startNewSession fail:" + localScanUIRectView.OOu);
        }
      }
      
      public final void b(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        AppMethodBeat.i(314510);
        BaseScanUI.o(BaseScanUI.this);
        am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 1, paramAnonymousInt2, BaseScanUI.d(BaseScanUI.this), paramAnonymousLong, paramAnonymousInt1);
        com.tencent.mm.plugin.scanner.model.d.UI(35);
        if (paramAnonymousInt2 == 1)
        {
          am.gRv();
          am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 2, paramAnonymousInt2, BaseScanUI.d(BaseScanUI.this), paramAnonymousLong, paramAnonymousInt1);
        }
        AppMethodBeat.o(314510);
      }
    };
    this.OYg = new ScanUIRectView.a()
    {
      public final void e(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51725);
        if (!BaseScanUI.p(BaseScanUI.this))
        {
          Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", new Object[] { Integer.valueOf(BaseScanUI.b(BaseScanUI.this)) });
          AppMethodBeat.o(51725);
          return;
        }
        if ((BaseScanUI.q(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          Log.i("MicroMsg.ScanUI", "scan code cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)) });
          final ArrayList localArrayList = paramAnonymousBundle.getParcelableArrayList("result_qbar_result_list");
          if ((localArrayList == null) || (localArrayList.size() <= 0))
          {
            Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
            AppMethodBeat.o(51725);
            return;
          }
          final int j = paramAnonymousBundle.getInt("result_code_point_count", 0);
          long l = paramAnonymousBundle.getLong("decode_success_cost_time", 0L);
          int i;
          if (BaseScanUI.r(BaseScanUI.this))
          {
            i = 3;
            am.a(BaseScanUI.b(BaseScanUI.this), true, i, j);
            com.tencent.mm.plugin.scanner.model.d.UI(1);
            BaseScanUI.s(BaseScanUI.this);
            localObject1 = BaseScanUI.this;
            if (j <= 1) {
              break label279;
            }
          }
          boolean bool2;
          final WxQBarResult localWxQBarResult;
          label279:
          for (boolean bool1 = true;; bool1 = false)
          {
            BaseScanUI.d((BaseScanUI)localObject1, bool1);
            BaseScanUI.e(BaseScanUI.this, false);
            am.a(BaseScanUI.b(BaseScanUI.this), localArrayList, l);
            bool2 = BaseScanUI.t(BaseScanUI.this).hU;
            localWxQBarResult = (WxQBarResult)localArrayList.get(0);
            if (!BaseScanUI.u(BaseScanUI.this)) {
              break label418;
            }
            if (localWxQBarResult != null) {
              break label285;
            }
            Log.w("MicroMsg.ScanUI", "first Qbar result is null");
            AppMethodBeat.o(51725);
            return;
            i = 1;
            break;
          }
          label285:
          paramAnonymousBundle = localWxQBarResult.typeName;
          Object localObject2 = new sn();
          Object localObject1 = localWxQBarResult.data;
          ((sn)localObject2).hVJ.scanResult = ((String)localObject1);
          ((sn)localObject2).hVJ.hVL = paramAnonymousBundle;
          ((sn)localObject2).hVJ.eQp = 0;
          ((sn)localObject2).publish();
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_scan_result", (String)localObject1);
          ((Intent)localObject2).putExtra("key_scan_result_raw", localWxQBarResult.rawData);
          ((Intent)localObject2).putExtra("key_scan_result_code_name", paramAnonymousBundle);
          ((Intent)localObject2).putExtra("key_scan_result_code_version", localWxQBarResult.ahqQ);
          BaseScanUI.this.setResult(-1, (Intent)localObject2);
          BaseScanUI.this.dmh();
          AppMethodBeat.o(51725);
          return;
          label418:
          paramAnonymousBundle.putInt("qbar_string_scan_source", 0);
          if ((j > 0) && (BaseScanUI.n(BaseScanUI.this) != null))
          {
            localObject1 = (ScanDecodeFrameData)paramAnonymousBundle.getParcelable("decode_success_frame_data");
            if (localObject1 != null) {
              BaseScanUI.n(BaseScanUI.this).setDecodeSuccessFrameData((ScanDecodeFrameData)localObject1);
            }
            localObject1 = BaseScanUI.this;
            String str;
            if (j > 1)
            {
              bool1 = true;
              BaseScanUI.f((BaseScanUI)localObject1, bool1);
              if (j > 1)
              {
                BaseScanUI.e(BaseScanUI.this).Cl(false);
                BaseScanUI.e(BaseScanUI.this).b(true, null);
                BaseScanUI.c(BaseScanUI.this, false);
              }
              BaseScanUI.b(BaseScanUI.this, true);
              BaseScanUI.n(BaseScanUI.this).setSuccessMarkClickListener(new an()
              {
                public final void aid(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(314508);
                  Log.i("MicroMsg.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  if ((paramAnonymous2Int < localArrayList.size()) && (j > 1))
                  {
                    BaseScanUI.b(BaseScanUI.this, false);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.mIa, (WxQBarResult)localArrayList.get(paramAnonymous2Int));
                    am.K(2, paramAnonymous2Int, BaseScanUI.r(BaseScanUI.this));
                    am.gRt();
                  }
                  AppMethodBeat.o(314508);
                }
              });
              BaseScanUI.v(BaseScanUI.this);
              BaseScanUI.w(BaseScanUI.this);
              BaseScanUI.o(BaseScanUI.this);
              localObject1 = BaseScanUI.n(BaseScanUI.this);
              if (com.tencent.mm.plugin.scanner.util.e.gTS())
              {
                if (((ScanUIRectView)localObject1).PbC == null)
                {
                  ((ScanUIRectView)localObject1).PbC = new ScanDebugView(((ScanUIRectView)localObject1).getContext());
                  ((ScanUIRectView)localObject1).addView(((ScanUIRectView)localObject1).PbC);
                }
                if (((ScanUIRectView)localObject1).PbC != null)
                {
                  localObject1 = ((ScanUIRectView)localObject1).PbC;
                  if (paramAnonymousBundle != null)
                  {
                    str = paramAnonymousBundle.getString("decode_debug_string");
                    localObject2 = (CharSequence)str;
                    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
                      break label774;
                    }
                  }
                }
              }
            }
            label774:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label780;
              }
              ((ScanDebugView)localObject1).setVisibility(0);
              localObject2 = ((ScanDebugView)localObject1).LwG;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                kotlin.g.b.s.bIx("debugInfo");
                localObject1 = null;
              }
              ((TextView)localObject1).setText((CharSequence)str);
              BaseScanUI.n(BaseScanUI.this).a(localArrayList, new com.tencent.mm.plugin.scanner.view.d()
              {
                public final void BY(boolean paramAnonymous2Boolean)
                {
                  AppMethodBeat.i(314503);
                  if ((paramAnonymous2Boolean) || (j == 1) || (localArrayList.size() == 1))
                  {
                    BaseScanUI.b(BaseScanUI.this, false);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, localWxQBarResult, this.OYG);
                    am.K(1, 0, BaseScanUI.r(BaseScanUI.this));
                  }
                  AppMethodBeat.o(314503);
                }
              }, bool2, true);
              AppMethodBeat.o(51725);
              return;
              bool1 = false;
              break;
            }
            label780:
            ((ScanDebugView)localObject1).setVisibility(8);
            localObject1 = ((ScanDebugView)localObject1).LwG;
            if (localObject1 == null)
            {
              kotlin.g.b.s.bIx("debugInfo");
              localObject1 = null;
            }
            for (;;)
            {
              ((TextView)localObject1).setText((CharSequence)"");
              break;
            }
          }
          BaseScanUI.e(BaseScanUI.this, true);
          BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, paramAnonymousBundle, localWxQBarResult);
        }
        AppMethodBeat.o(51725);
      }
    };
    this.OYh = new a.c()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314532);
        if (BaseScanUI.x(BaseScanUI.this))
        {
          Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess isScrolling and ignore");
          AppMethodBeat.o(314532);
          return;
        }
        if ((BaseScanUI.q(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          BaseScanUI.y(BaseScanUI.this);
          int i = paramAnonymousBundle.getInt("scan_source", 0);
          Log.i("MicroMsg.ScanUI", "alvinluo onScanSuccess cost time %d, scanImageCount: %d, source: %d, session: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)), Integer.valueOf(BaseScanUI.z(BaseScanUI.this)), Integer.valueOf(i), Long.valueOf(paramAnonymousLong) });
          if ((i == 1) && (!BaseScanUI.A(BaseScanUI.this)))
          {
            if ((BaseScanUI.k(BaseScanUI.this) instanceof ScanGoodsRequest))
            {
              paramAnonymousBundle.putParcelable("key_scan_request", BaseScanUI.k(BaseScanUI.this));
              paramAnonymousBundle.putInt("key_scan_goods_mode", ((ScanGoodsRequest)BaseScanUI.k(BaseScanUI.this)).mode);
            }
            BaseScanUI.q(BaseScanUI.this).h(paramAnonymousLong, paramAnonymousBundle);
            AppMethodBeat.o(314532);
            return;
          }
          if (i == 2)
          {
            if ((BaseScanUI.k(BaseScanUI.this) instanceof ScanGoodsRequest)) {
              paramAnonymousBundle.putParcelable("key_scan_request", BaseScanUI.k(BaseScanUI.this));
            }
            BaseScanUI.q(BaseScanUI.this).h(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(314532);
      }
      
      public final void f(long paramAnonymousLong, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(314535);
        Log.e("MicroMsg.ScanUI", "alvinluo onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), paramAnonymousString });
        String str = paramAnonymousString;
        if (Util.isNullOrNil(paramAnonymousString)) {
          str = BaseScanUI.this.getResources().getString(l.i.OLB);
        }
        com.tencent.mm.ui.base.k.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(l.i.app_ok), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(314497);
            BaseScanUI.this.gQM();
            am.ahX(BaseScanUI.b(BaseScanUI.this));
            AppMethodBeat.o(314497);
          }
        });
        am.a(paramAnonymousInt, false, System.currentTimeMillis());
        AppMethodBeat.o(314535);
      }
    };
    this.OYi = new com.tencent.mm.plugin.scanner.g.a.a()
    {
      public final void a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        AppMethodBeat.i(314979);
        Log.i("MicroMsg.ScanUI", "notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Long.valueOf(paramAnonymousLong), Integer.valueOf(1) });
        AppMethodBeat.o(314979);
      }
      
      public final void b(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(314975);
        String str;
        if (paramAnonymousInt1 == 2)
        {
          Log.e("MicroMsg.ScanUI", "alvinluo onScanResultFailed scan from gallery failed errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          am.a(paramAnonymousInt1, false, System.currentTimeMillis());
          am.ag(false, paramAnonymousInt1);
          BaseScanUI.this.gSt();
          BaseScanUI.s(BaseScanUI.this);
          BaseScanUI.n(BaseScanUI.this).b(false, null);
          str = paramAnonymousString;
          if (Util.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(l.i.OLB);
          }
          com.tencent.mm.ui.base.k.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(l.i.app_ok), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(314540);
              BaseScanUI.this.gQM();
              am.ahX(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(314540);
            }
          });
          AppMethodBeat.o(314975);
          return;
        }
        if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == 1003))
        {
          Log.e("MicroMsg.ScanUI", "alvinluo onScanResultFailed stop upload and show alert");
          if (BaseScanUI.q(BaseScanUI.this) != null) {
            BaseScanUI.q(BaseScanUI.this).Q(paramAnonymousLong, false);
          }
          BaseScanUI.this.gSt();
          BaseScanUI.s(BaseScanUI.this);
          str = paramAnonymousString;
          if (Util.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(l.i.OLC);
          }
          com.tencent.mm.ui.base.k.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(l.i.app_ok), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(314549);
              BaseScanUI.this.gQM();
              am.ahX(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(314549);
            }
          });
        }
        AppMethodBeat.o(314975);
      }
      
      public final void b(ae paramAnonymousae)
      {
        AppMethodBeat.i(314967);
        if (BaseScanUI.b(BaseScanUI.this) != 12)
        {
          Log.i("MicroMsg.ScanUI", "alvnluo onScanResultSuccess not SELECT_SCAN_MODE_GOODS and ignore");
          AppMethodBeat.o(314967);
          return;
        }
        if ((BaseScanUI.x(BaseScanUI.this)) || ((paramAnonymousae.source == 1) && (BaseScanUI.A(BaseScanUI.this))))
        {
          Log.e("MicroMsg.ScanUI", "alvinluo onScanResultSuccess source:%d, isScrolling: %b or needPauseScan: %b and ignore", new Object[] { Integer.valueOf(paramAnonymousae.source), Boolean.valueOf(BaseScanUI.x(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.A(BaseScanUI.this)) });
          AppMethodBeat.o(314967);
          return;
        }
        BaseScanUI.a(BaseScanUI.this, paramAnonymousae);
        AppMethodBeat.o(314967);
      }
    };
    this.OYj = new com.tencent.mm.plugin.scanner.box.g()
    {
      public final void L(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(314954);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onDismiss exitType: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseScanUI.f(BaseScanUI.this);
        BaseScanUI.h(BaseScanUI.this);
        BaseScanUI.e(BaseScanUI.this).Cm(true);
        BaseScanUI.this.gQM();
        BaseScanUI.a(BaseScanUI.this, true);
        am.tY(System.currentTimeMillis());
        am.a(BaseScanUI.j(BaseScanUI.this), paramAnonymousInt, BaseScanUI.k(BaseScanUI.this));
        am.ahX(12);
        AppMethodBeat.o(314954);
      }
      
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(314958);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onCancel");
        BaseScanUI.b(BaseScanUI.this, false);
        BaseScanUI.f(BaseScanUI.this);
        BaseScanUI.h(BaseScanUI.this);
        AppMethodBeat.o(314958);
      }
      
      public final void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(314945);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onShow");
        BaseScanUI.e(BaseScanUI.this).Cm(false);
        BaseScanUI.a(BaseScanUI.this, false);
        am.tX(System.currentTimeMillis());
        AppMethodBeat.o(314945);
      }
    };
    this.OYk = new p.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(314672);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(314541);
            boolean bool = BaseScanUI.P(BaseScanUI.this);
            Log.i("MicroMsg.ScanUI", "onNetWorkChange %d, canResume: %b", new Object[] { Integer.valueOf(com.tencent.mm.kernel.h.aZW().bFQ()), Boolean.valueOf(bool) });
            Object localObject;
            int i;
            if (BaseScanUI.n(BaseScanUI.this) != null)
            {
              localObject = BaseScanUI.n(BaseScanUI.this);
              i = paramAnonymousInt;
              if ((com.tencent.mm.kernel.h.aZW().bFQ() != 6) && (com.tencent.mm.kernel.h.aZW().bFQ() != 4)) {
                break label198;
              }
              ((ScanUIRectView)localObject).OXx = true;
              if ((!t.aiG(((ScanUIRectView)localObject).mode)) && (bool)) {
                ((ScanUIRectView)localObject).onResume();
              }
            }
            for (;;)
            {
              if (((ScanUIRectView)localObject).OSO != null) {
                ((ScanUIRectView)localObject).OSO.onNetworkChange(i);
              }
              if (((ScanUIRectView)localObject).OSP != null)
              {
                localObject = ((ScanUIRectView)localObject).OSP;
                ((ScanSharedMaskView)localObject).eqb();
                ((ScanSharedMaskView)localObject).aiB(((ScanSharedMaskView)localObject).Phy);
              }
              if ((com.tencent.mm.kernel.h.aZW().bFQ() != 6) && (com.tencent.mm.kernel.h.aZW().bFQ() != 4)) {
                break label248;
              }
              if (!BaseScanUI.Q(BaseScanUI.this)) {
                break;
              }
              AppMethodBeat.o(314541);
              return;
              label198:
              ((ScanUIRectView)localObject).OXx = false;
              if (!t.aiG(((ScanUIRectView)localObject).mode)) {
                ((ScanUIRectView)localObject).onPause();
              }
            }
            BaseScanUI.k(BaseScanUI.this, true);
            BaseScanUI.R(BaseScanUI.this);
            AppMethodBeat.o(314541);
            return;
            label248:
            if (!BaseScanUI.Q(BaseScanUI.this))
            {
              AppMethodBeat.o(314541);
              return;
            }
            BaseScanUI.k(BaseScanUI.this, false);
            BaseScanUI.R(BaseScanUI.this);
            AppMethodBeat.o(314541);
          }
        });
        AppMethodBeat.o(314672);
      }
    };
    this.OYl = new IListener(com.tencent.mm.app.f.hfK) {};
    this.xeK = new BaseScanUI.31(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(51728);
  }
  
  private void Ce(boolean paramBoolean)
  {
    AppMethodBeat.i(51731);
    if ((!paramBoolean) && (!aw.isDarkMode()))
    {
      getController().setNavigationbarColor(getContext().getResources().getColor(l.c.BG_1));
      AppMethodBeat.o(51731);
      return;
    }
    getController().setNavigationbarColor(getResources().getColor(l.c.OHZ));
    AppMethodBeat.o(51731);
  }
  
  private void Cf(boolean paramBoolean)
  {
    AppMethodBeat.i(314527);
    if (this.OXp != null)
    {
      Object localObject = this.OXp;
      Log.i("MicroMsg.ScanScrollTabController", "alvinluo setEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).setEnableSwitchTab(paramBoolean);
      localObject = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).Phh;
      if (localObject != null) {
        ((ScanScrollTabView)localObject).setEnabled(paramBoolean);
      }
    }
    AppMethodBeat.o(314527);
  }
  
  private void Cg(boolean paramBoolean)
  {
    AppMethodBeat.i(51747);
    if (paramBoolean)
    {
      this.OXl.setVisibility(0);
      this.OXi.dSg();
      this.OXl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(314671);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/BaseScanUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          BaseScanUI.O(BaseScanUI.this);
          BaseScanUI.j(BaseScanUI.this, false);
          BaseScanUI.this.gQM();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(314671);
        }
      });
      if (this.OXi != null) {
        this.OXi.Ci(true);
      }
      this.OXm.Cl(false);
      aN(false, true);
      AppMethodBeat.o(51747);
      return;
    }
    this.OXl.setVisibility(8);
    if (this.OXi != null) {
      this.OXi.Ci(false);
    }
    this.OXm.Cl(true);
    AppMethodBeat.o(51747);
  }
  
  private void aM(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(314554);
    Log.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance success: %b, isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.FALSE });
    Object localObject = this.OXM;
    long l1;
    label86:
    int i;
    if (paramBoolean1)
    {
      l1 = 1L;
      ((um)localObject).jHv = l1;
      this.OXM.jHw = (System.currentTimeMillis() - this.OXu);
      localObject = this.OXM;
      if (!this.OXi.gSN()) {
        break label399;
      }
      l1 = 0L;
      ((um)localObject).jHx = l1;
      this.OXM.jHC = this.LvA;
      this.OXM.jHy = com.tencent.qbar.c.ahqH.ahqK;
      if (com.tencent.mm.plugin.scanner.util.l.Pjm.gUd() > 0L) {
        this.OXM.jHB = (com.tencent.mm.plugin.scanner.util.l.Pjm.gUd() - this.OXu);
      }
      this.OXM.bMH();
      if (t.aiG(this.LvA))
      {
        if (com.tencent.mm.plugin.scanner.util.e.gTX() != 1) {
          break label405;
        }
        i = 1722;
        label177:
        Log.i("MicroMsg.ScanUI", "reportScanPerformance idKey:".concat(String.valueOf(i)));
        com.tencent.mm.plugin.report.service.h.OAn.p(i, 0L, 1L);
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        long l2 = i;
        if (!paramBoolean1) {
          break label412;
        }
        l1 = 1L;
        label219:
        ((com.tencent.mm.plugin.report.service.h)localObject).p(l2, 1L, l1);
        if (paramBoolean1)
        {
          if (!this.OXi.gSN()) {
            break label418;
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(i, 5L, 1L);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(i, 7L, this.OXM.jHw);
      com.tencent.mm.plugin.report.service.h.OAn.p(i, 9L, this.OXM.jHy);
      if ((paramBoolean1) && (paramBoolean2))
      {
        Log.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance scanTime: %s, totalFrames: %d", new Object[] { Long.valueOf(this.OXM.jHw), Long.valueOf(this.OXM.jHy) });
        com.tencent.mm.plugin.report.service.h.OAn.p(i, 11L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(i, 12L, this.OXM.jHw);
        com.tencent.mm.plugin.report.service.h.OAn.p(i, 14L, this.OXM.jHy);
      }
      AppMethodBeat.o(314554);
      return;
      l1 = 0L;
      break;
      label399:
      l1 = 1L;
      break label86;
      label405:
      i = 1229;
      break label177;
      label412:
      l1 = 0L;
      break label219;
      label418:
      com.tencent.mm.plugin.report.service.h.OAn.p(i, 3L, 1L);
    }
  }
  
  private void aN(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(51750);
    Log.v("MicroMsg.ScanUI", "alvinluo showFlash show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if ((this.OXj != null) && (!this.OXj.isShown()))
      {
        this.OXi.gSS();
        if (paramBoolean2) {
          this.OXj.show();
        }
        for (;;)
        {
          com.tencent.qbar.c.ahqH.aGW(1);
          am.J(this.LvA, 1, this.OTn);
          AppMethodBeat.o(51750);
          return;
          this.OXj.setVisibility(0);
        }
      }
    }
    else if ((this.OXj != null) && (!this.OXj.hU))
    {
      this.OXi.gST();
      if (paramBoolean2)
      {
        this.OXj.hide();
        AppMethodBeat.o(51750);
        return;
      }
      this.OXj.setVisibility(8);
    }
    AppMethodBeat.o(51750);
  }
  
  private void ain(int paramInt)
  {
    AppMethodBeat.i(51735);
    Log.i("MicroMsg.ScanUI", "alvinluo operateFlash operation: %d", new Object[] { Integer.valueOf(paramInt) });
    wa localwa = new wa();
    localwa.hZH.hAf = paramInt;
    localwa.publish();
    if (this.OXj != null)
    {
      if (paramInt == 1)
      {
        this.OXj.gSZ();
        AppMethodBeat.o(51735);
        return;
      }
      this.OXj.gTa();
    }
    AppMethodBeat.o(51735);
  }
  
  private void aio(int paramInt)
  {
    AppMethodBeat.i(314558);
    Log.i("MicroMsg.ScanUI", "reportScanUIEvent eventType = %d, enterScene = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.enterScene) });
    am.a(am.a(this.OXF), this.LvA, this.OXF, paramInt, this.enterScene, this.OTn);
    AppMethodBeat.o(314558);
  }
  
  private void au(long paramLong, int paramInt)
  {
    AppMethodBeat.i(314509);
    gSm();
    aN(false, false);
    this.OXy = false;
    this.OXJ = false;
    this.OXH = true;
    this.OXU = true;
    setEnableSwitchTab(false);
    if (this.OXo != null) {
      this.OXo.Q(paramLong, true);
    }
    this.OXi.b(false, null);
    this.OXi.setScanSource(paramInt);
    am.ahY(this.LvA);
    AppMethodBeat.o(314509);
  }
  
  private void fbu()
  {
    AppMethodBeat.i(314533);
    this.OXm.setShowMoreButton(gSn());
    this.OXm.setOnMoreClickListener(new BaseScanUI.15(this));
    AppMethodBeat.o(314533);
  }
  
  private void gSh()
  {
    AppMethodBeat.i(314511);
    if ((!this.OXO) && ((t.aiH(this.LvA)) || ((t.aiG(this.LvA)) && (this.OTn))))
    {
      this.OXO = true;
      ac.gRa();
    }
    AppMethodBeat.o(314511);
  }
  
  private void gSi()
  {
    AppMethodBeat.i(314514);
    boolean bool;
    if (this.OTn)
    {
      bool = ac.gRe();
      if (!this.OXx) {
        break label94;
      }
    }
    label94:
    for (this.OXP = bool;; this.OXP = true)
    {
      if (this.OXi != null) {
        this.OXi.setDisableScanProductInMergeMode(this.OXP);
      }
      Log.i("MicroMsg.ScanUI", "updateDisableScanProductInMergeMode config: %s, current: %s, currentNetwork: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.OXP), Boolean.valueOf(this.OXx) });
      AppMethodBeat.o(314514);
      return;
    }
  }
  
  private void gSj()
  {
    AppMethodBeat.i(51732);
    ScanSharedMaskView localScanSharedMaskView = this.OXi.getSharedMaskView();
    if (localScanSharedMaskView == null)
    {
      AppMethodBeat.o(51732);
      return;
    }
    if (!this.OMv)
    {
      localScanSharedMaskView.getGalleryButton().setVisibility(0);
      localScanSharedMaskView.setOnGalleryClickListener(new BaseScanUI.8(this));
      AppMethodBeat.o(51732);
      return;
    }
    localScanSharedMaskView.getGalleryButton().setVisibility(8);
    AppMethodBeat.o(51732);
  }
  
  private void gSk()
  {
    AppMethodBeat.i(314521);
    if (this.LvA != 12)
    {
      AppMethodBeat.o(314521);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.k(this, "android.permission.ACCESS_FINE_LOCATION", false);
    if (!bool)
    {
      Log.w("MicroMsg.ScanUI", "startGetLocation checkLocation: %s and ignore", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(314521);
      return;
    }
    if (this.OMI == null) {}
    for (bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScanUI", "alvinluo startGetLocation location == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.OMI != null) {
        break;
      }
      if (this.Hji == null) {
        this.Hji = com.tencent.mm.modelgeo.d.bJl();
      }
      if (this.wGt == null) {
        this.wGt = new b.a()
        {
          public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
          {
            AppMethodBeat.i(314580);
            Log.v("MicroMsg.ScanUI", "onGetLocation isOk: %b, %s, %s, %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
            if (paramAnonymousBoolean)
            {
              BaseScanUI.a(BaseScanUI.this, new nq());
              BaseScanUI.E(BaseScanUI.this).latitude = paramAnonymousFloat2;
              BaseScanUI.E(BaseScanUI.this).longitude = paramAnonymousFloat1;
              BaseScanUI.E(BaseScanUI.this).YPF = ((int)paramAnonymousDouble2);
              if ((BaseScanUI.q(BaseScanUI.this) instanceof com.tencent.mm.plugin.scanner.g.a)) {
                ((com.tencent.mm.plugin.scanner.g.a)BaseScanUI.q(BaseScanUI.this)).a(BaseScanUI.E(BaseScanUI.this));
              }
              BaseScanUI.G(BaseScanUI.this).a(BaseScanUI.F(BaseScanUI.this));
            }
            AppMethodBeat.o(314580);
            return true;
          }
        };
      }
      this.Hji.a(this.wGt, false, true);
      com.tencent.mm.plugin.report.service.l.kK(22, 10);
      AppMethodBeat.o(314521);
      return;
    }
    if ((this.OXo instanceof com.tencent.mm.plugin.scanner.g.a)) {
      ((com.tencent.mm.plugin.scanner.g.a)this.OXo).a(this.OMI);
    }
    AppMethodBeat.o(314521);
  }
  
  private void gSl()
  {
    AppMethodBeat.i(51734);
    ScanSharedMaskView localScanSharedMaskView = this.OXi.getSharedMaskView();
    if (localScanSharedMaskView != null) {
      this.OXj = localScanSharedMaskView.getFlashSwitcherView();
    }
    if (this.OXj != null)
    {
      this.OXj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(314581);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/BaseScanUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.qbar.c.ahqH.aGW(2);
          if (!BaseScanUI.t(BaseScanUI.this).hU) {
            BaseScanUI.c(BaseScanUI.this, 1);
          }
          for (;;)
          {
            am.J(BaseScanUI.b(BaseScanUI.this), 2, BaseScanUI.r(BaseScanUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(314581);
            return;
            BaseScanUI.c(BaseScanUI.this, 2);
          }
        }
      });
      this.OXi.setFlashStatus(this.OXj.fhR);
      if (t.aiI(this.LvA))
      {
        gSm();
        this.OXj.hide();
      }
    }
    AppMethodBeat.o(51734);
  }
  
  private void gSm()
  {
    AppMethodBeat.i(51736);
    Log.d("MicroMsg.ScanUI", "alvinluo checkAndOperateFlash operation: %d", new Object[] { Integer.valueOf(2) });
    if (this.OXj.hU) {
      ain(2);
    }
    AppMethodBeat.o(51736);
  }
  
  private boolean gSn()
  {
    AppMethodBeat.i(314537);
    if (((t.aiG(this.LvA)) || (t.aiH(this.LvA)) || (t.aiI(this.LvA))) && (!this.OMw) && (!this.OXG))
    {
      AppMethodBeat.o(314537);
      return true;
    }
    AppMethodBeat.o(314537);
    return false;
  }
  
  private boolean gSo()
  {
    AppMethodBeat.i(314544);
    Log.i("MicroMsg.ScanUI", "alvinluo processCancel isShowingMultiCodeResult: %b, infoViewType: %d", new Object[] { Boolean.valueOf(this.OXR), Integer.valueOf(this.OXK.OST) });
    ScanUITopOpButtonComponent localScanUITopOpButtonComponent = this.OXm;
    AnimatorListenerAdapter local18 = new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(314565);
        BaseScanUI.this.gQM();
        AppMethodBeat.o(314565);
      }
    };
    TextView localTextView2 = localScanUITopOpButtonComponent.PdA;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      kotlin.g.b.s.bIx("cancelButton");
      localTextView1 = null;
    }
    if (localTextView1.getVisibility() == 0)
    {
      localScanUITopOpButtonComponent.Cl(true);
      localScanUITopOpButtonComponent.b(false, (Animator.AnimatorListener)local18);
    }
    for (boolean bool = true;; bool = false)
    {
      Cf(true);
      if ((t.aiG(this.LvA)) && (this.OXR))
      {
        this.OXR = false;
        am.K(3, -1, this.OTn);
        am.gRs();
      }
      if ((t.aiG(this.LvA)) && (this.OXK != null) && ((this.OXK.OST == 3) || (this.OXK.OST == 4))) {
        am.b(5, this.OTn, this.LvA, this.OXW);
      }
      AppMethodBeat.o(314544);
      return bool;
    }
  }
  
  private boolean gSp()
  {
    AppMethodBeat.i(314546);
    if ((t.aiG(this.LvA)) && (this.OTn))
    {
      AppMethodBeat.o(314546);
      return true;
    }
    AppMethodBeat.o(314546);
    return false;
  }
  
  private void gSq()
  {
    AppMethodBeat.i(51739);
    switch (this.LvA)
    {
    default: 
      this.OXi.setScanCallback(null);
      AppMethodBeat.o(51739);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.OXi.setScanCallback(this.OYg);
      this.OXo = new com.tencent.mm.plugin.scanner.g.g(this.LvA, this.OXB, this.OXi, this, this, this.OXY);
      AppMethodBeat.o(51739);
      return;
    case 12: 
      this.OXi.setScanCallback(this.OYh);
      this.OXo = new com.tencent.mm.plugin.scanner.g.a(this.LvA, this.OXi, this, this.OYi);
      ((com.tencent.mm.plugin.scanner.g.a)this.OXo).a(this.OMI);
      AppMethodBeat.o(51739);
      return;
    }
    this.OXo = new ao(this);
    AppMethodBeat.o(51739);
  }
  
  private void gSr()
  {
    AppMethodBeat.i(169986);
    if (this.OXK != null)
    {
      this.OXK.a(this);
      if (this.OXi != null) {
        this.OXK.a(this.OXi.getScanMaskView(), this.OXi.getSharedMaskView(), this.OSQ);
      }
    }
    AppMethodBeat.o(169986);
  }
  
  private void gSs()
  {
    AppMethodBeat.i(169987);
    int i = 0;
    if (t.aiG(this.LvA)) {
      if (this.OTn) {
        i = com.tencent.qbar.c.ahqG;
      }
    }
    for (;;)
    {
      com.tencent.qbar.c.ahqH.setTabType(i);
      AppMethodBeat.o(169987);
      return;
      i = com.tencent.qbar.c.ahqD;
      continue;
      if (this.LvA == 12) {
        i = com.tencent.qbar.c.ahqE;
      } else if (this.LvA == 3) {
        i = com.tencent.qbar.c.ahqF;
      }
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(51742);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI", "com/tencent/mm/plugin/scanner/ui/BaseScanUI", "goBack", "()V", this);
    setResult(0);
    finish();
    overridePendingTransition(0, 0);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI", "com/tencent/mm/plugin/scanner/ui/BaseScanUI", "goBack", "()V");
    AppMethodBeat.o(51742);
  }
  
  private void kQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314551);
    Log.v("MicroMsg.ScanUI", "alvinluo reportSwitchTab %b", new Object[] { Boolean.valueOf(this.OXv) });
    am.I(paramInt1, paramInt2, this.OTn);
    am.ahR(paramInt1);
    am.ahT(paramInt1);
    am.ahX(paramInt1);
    if (gSp()) {
      com.tencent.mm.plugin.scanner.model.d.UI(0);
    }
    AppMethodBeat.o(314551);
  }
  
  private void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51733);
    Log.i("MicroMsg.ScanUI", "alvinluo setEnableSwitchTab enable: %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.OXr) });
    if (this.OXp != null)
    {
      if (!paramBoolean) {
        break label95;
      }
      if (this.OXr) {
        this.OXp.setEnableSwitchTab(true);
      }
    }
    while (this.OXi != null) {
      if (paramBoolean)
      {
        if (this.OXr)
        {
          this.OXi.setEnableScrollSwitchTab(true);
          AppMethodBeat.o(51733);
          return;
          label95:
          this.OXp.setEnableSwitchTab(false);
        }
      }
      else {
        this.OXi.setEnableScrollSwitchTab(false);
      }
    }
    AppMethodBeat.o(51733);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, c.a parama)
  {
    AppMethodBeat.i(51746);
    if ((this.OXK != null) && (this.OXK.OSR)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScanUI", "alvinluo showLoadingView show: %b, isLoadingShow: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2) });
      this.OXH = paramBoolean1;
      if (this.OXK != null)
      {
        this.OXK.OSS = parama;
        if (this.OXK.OSR != paramBoolean1)
        {
          this.OXK.aL(paramBoolean1, paramBoolean2);
          if (paramBoolean1)
          {
            this.OXm.Cl(false);
            this.OXm.b(false, null);
          }
        }
      }
      AppMethodBeat.o(51746);
      return;
    }
  }
  
  public final void dmh()
  {
    AppMethodBeat.i(51743);
    Log.i("MicroMsg.ScanUI", "finishUI");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(51743);
  }
  
  public final void gQK()
  {
    AppMethodBeat.i(314972);
    ai localai;
    Object localObject;
    String str;
    if (this.OXK != null)
    {
      localai = this.OXK;
      localObject = localai.OSQ;
      if (localObject != null)
      {
        ((ScanInfoMaskView)localObject).getVisibility();
        ((ScanInfoMaskView)localObject).setVisibility(8);
        ((ScanInfoMaskView)localObject).Pgg = true;
      }
      if (localai.OST == 4)
      {
        localObject = com.tencent.qbar.h.jWV();
        str = localai.OSU;
        Log.i("MicroMsg.WxScanDecodeQueue", "markCodeNotRecognizeTemp:".concat(String.valueOf(str)));
        if ((str != null) && (str.length() != 0)) {
          break label116;
        }
      }
    }
    for (;;)
    {
      localai.OST = 0;
      localai.OSU = "";
      AppMethodBeat.o(314972);
      return;
      label116:
      long l;
      try
      {
        l = System.currentTimeMillis();
        if (!((com.tencent.qbar.h)localObject).ahrG.containsKey(str)) {
          break label197;
        }
        if (l - ((Long)((com.tencent.qbar.h)localObject).ahrG.get(str)).longValue() <= com.tencent.mm.plugin.scanner.util.e.gTW()) {
          continue;
        }
        ((com.tencent.qbar.h)localObject).ahrG.put(str, Long.valueOf(l));
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WxScanDecodeQueue", localException, "markCodeNotRecognizeTemp", new Object[0]);
      }
      continue;
      label197:
      localException.ahrG.put(str, Long.valueOf(l));
    }
  }
  
  public final void gQL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(314962);
    Cf(true);
    this.OXH = false;
    Object localObject1;
    BaseScanUI.35 local35;
    if (this.OXK != null)
    {
      this.OXm.b(false, null);
      if (this.OSP != null) {
        this.OSP.f(true, null);
      }
      localObject1 = this.OXK;
      local35 = new BaseScanUI.35(this);
      ScanInfoMaskView localScanInfoMaskView = ((ai)localObject1).OSQ;
      if (localScanInfoMaskView != null)
      {
        View localView = localScanInfoMaskView.Nwy;
        localObject1 = localView;
        if (localView == null)
        {
          kotlin.g.b.s.bIx("infoLayout");
          localObject1 = null;
        }
        if (((View)localObject1).getVisibility() == 0)
        {
          localView = localScanInfoMaskView.HxV;
          localObject1 = localView;
          if (localView == null)
          {
            kotlin.g.b.s.bIx("loadingLayout");
            localObject1 = null;
          }
          ((View)localObject1).setVisibility(8);
          localObject1 = localScanInfoMaskView.Nwy;
          if (localObject1 != null) {
            break label180;
          }
          kotlin.g.b.s.bIx("infoLayout");
          localObject1 = localObject2;
        }
      }
    }
    label180:
    for (;;)
    {
      ScanInfoMaskView.a((View)localObject1, local35);
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(314504);
          if ((!BaseScanUI.M(BaseScanUI.this)) || (BaseScanUI.L(BaseScanUI.this) == null))
          {
            BaseScanUI.aa(BaseScanUI.this);
            AppMethodBeat.o(314504);
            return;
          }
          BaseScanUI.g(BaseScanUI.this, false);
          BaseScanUI.L(BaseScanUI.this).f(false, new AnimatorListenerAdapter()
          {
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(314475);
              super.onAnimationEnd(paramAnonymous2Animator);
              BaseScanUI.aa(BaseScanUI.this);
              AppMethodBeat.o(314475);
            }
          });
          AppMethodBeat.o(314504);
        }
      }, 1000L);
      AppMethodBeat.o(314962);
      return;
    }
  }
  
  public final void gQM()
  {
    AppMethodBeat.i(51757);
    Log.i("MicroMsg.ScanUI", "alvinluo resumeScan");
    this.OXu = System.currentTimeMillis();
    this.OXH = false;
    if (this.OXi != null) {
      this.OXi.onResume();
    }
    setEnableSwitchTab(true);
    AppMethodBeat.o(51757);
  }
  
  public final boolean gQO()
  {
    return (this.OXj != null) && (this.OXj.hU);
  }
  
  public final BaseScanMaskView<?> gQP()
  {
    AppMethodBeat.i(314980);
    if (this.OXi != null)
    {
      BaseScanMaskView localBaseScanMaskView = this.OXi.getScanMaskView();
      AppMethodBeat.o(314980);
      return localBaseScanMaskView;
    }
    AppMethodBeat.o(314980);
    return null;
  }
  
  public final boolean gQQ()
  {
    return this.OTn;
  }
  
  public final int gQR()
  {
    return this.OYe;
  }
  
  public final boolean gQS()
  {
    AppMethodBeat.i(314987);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(314987);
      return true;
    }
    AppMethodBeat.o(314987);
    return false;
  }
  
  public final void gSt()
  {
    AppMethodBeat.i(314950);
    Log.i("MicroMsg.ScanUI", "alvinluo pauseScan");
    if (this.OXi != null) {
      this.OXi.gSt();
    }
    AppMethodBeat.o(314950);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return l.g.OKA;
  }
  
  public final Context getUIContext()
  {
    return this;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51730);
    this.container = ((FrameLayout)findViewById(l.f.OJk));
    this.OXp = new com.tencent.mm.plugin.scanner.ui.widget.b(this, this.OTn);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.compatible.util.d.rb(19))
    {
      getWindow().addFlags(67109888);
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.OXl = findViewById(l.f.OJq);
      this.OSQ = ((ScanInfoMaskView)findViewById(l.f.OJn));
      this.OSQ.getInfoLayout().setOnClickListener(new BaseScanUI.6(this));
      setBackBtn(new BaseScanUI.7(this));
      this.OXm = ((ScanUITopOpButtonComponent)findViewById(l.f.OJN));
      this.OXi = new ScanUIRectView(this);
      this.OXi.PbH = this;
      this.OXi.setScanRequest(this.OXF);
      this.OXi.setEnableScanGoodsDynamicWording(this.OXS);
      this.OXi.setEnableOpenCamera(this.OXT);
      this.OXi.setEnableScanCodeProductMerge(this.OTn);
      this.OXi.setDisableScanProductInMergeMode(this.OXP);
      localObject2 = (ScanScrollTabView)findViewById(l.f.OJy);
      localObject1 = this.OXp;
      kotlin.g.b.s.u(localObject2, "scrollTabView");
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).Phh = ((ScanScrollTabView)localObject2);
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).Phh;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).WY();
      }
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).Phh;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)new com.tencent.mm.plugin.scanner.ui.widget.b.c());
      }
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).Phi.clear();
      localObject2 = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).Phj).iterator();
      int i = 0;
      label311:
      if (!((Iterator)localObject2).hasNext()) {
        break label360;
      }
      if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).a(i, (com.tencent.mm.plugin.scanner.ui.widget.b.b)((Iterator)localObject2).next())) {
        break label1148;
      }
      i += 1;
    }
    label360:
    label1004:
    label1148:
    for (;;)
    {
      break label311;
      getWindow().setFlags(1024, 1024);
      break;
      localObject1 = this.OXp;
      localObject2 = new com.tencent.mm.plugin.scanner.ui.widget.e()
      {
        public final void aiq(int paramAnonymousInt)
        {
          AppMethodBeat.i(314596);
          Log.i("MicroMsg.ScanUI", "alvinluo onTabUnSelected tabId: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (t.aiG(paramAnonymousInt)) {
            BaseScanUI.h(BaseScanUI.this, false);
          }
          BaseScanUI.aip(paramAnonymousInt);
          if (paramAnonymousInt == 12) {
            BaseScanUI.gSv();
          }
          AppMethodBeat.o(314596);
        }
        
        public final void kR(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(314593);
          Log.i("MicroMsg.ScanUI", "alvinluo onTabSelected tabId: %d, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 12) && (!WeChatBrands.Business.Entries.DiscoveryScanRecognize.checkAvailable(BaseScanUI.this.getContext())))
          {
            BaseScanUI.this.dmh();
            AppMethodBeat.o(314593);
            return;
          }
          if ((paramAnonymousInt1 == 3) && (!WeChatBrands.Business.Entries.DiscoveryScanTranslate.checkAvailable(BaseScanUI.this.getContext())))
          {
            BaseScanUI.this.dmh();
            AppMethodBeat.o(314593);
            return;
          }
          if (!BaseScanUI.I(BaseScanUI.this))
          {
            BaseScanUI.a(BaseScanUI.this, paramAnonymousInt1, paramAnonymousInt2);
            if (BaseScanUI.b(BaseScanUI.this) != paramAnonymousInt1)
            {
              if ((paramAnonymousInt1 != 12) || (paramAnonymousInt2 != 4)) {
                break label308;
              }
              am.b(7, BaseScanUI.r(BaseScanUI.this), paramAnonymousInt1, 0);
              BaseScanUI.d(BaseScanUI.this, 3);
              BaseScanUI.g(BaseScanUI.this, true);
              BaseScanUI.K(BaseScanUI.this);
              if (BaseScanUI.L(BaseScanUI.this) != null)
              {
                BaseScanUI.L(BaseScanUI.this).setShowToast(true);
                BaseScanUI.L(BaseScanUI.this).setScanToast(BaseScanUI.this.getResources().getString(l.i.OKP));
              }
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.ScanUI", "alvinluo onTabSelected scanGoodsScene: %d, needAnimateHideBlurBackground: %b", new Object[] { Integer.valueOf(BaseScanUI.j(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.M(BaseScanUI.this)) });
            BaseScanUI.e(BaseScanUI.this, paramAnonymousInt1);
            if (t.aiG(paramAnonymousInt1)) {
              BaseScanUI.h(BaseScanUI.this, true);
            }
            BaseScanUI.N(BaseScanUI.this);
            AppMethodBeat.o(314593);
            return;
            BaseScanUI.J(BaseScanUI.this);
            break;
            label308:
            BaseScanUI.d(BaseScanUI.this, am.a(BaseScanUI.k(BaseScanUI.this)));
            BaseScanUI.g(BaseScanUI.this, false);
            if (BaseScanUI.L(BaseScanUI.this) != null) {
              BaseScanUI.L(BaseScanUI.this).setShowToast(false);
            }
          }
        }
      };
      kotlin.g.b.s.u(localObject2, "tabOnSelectedListener");
      localObject2 = new b.d((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1, (com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).Phh;
      if (localObject1 != null) {
        ((ScanScrollTabView)localObject1).setOnTabChangedListener((com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      }
      localObject2 = this.OXp;
      localObject1 = new BaseScanUI.20(this);
      kotlin.g.b.s.u(localObject1, "tabOnScrollListener");
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).Phh;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)localObject1);
      }
      if (this.OXi != null) {
        this.OXi.setScrollTabController(this.OXp);
      }
      this.OXX.clear();
      if ((this.OXC) || (this.LvA == 8))
      {
        this.OXE = true;
        if (this.OXF != null)
        {
          if (this.OXF.OMs) {
            this.OXE = true;
          }
          if (this.OXF.OMv) {
            this.OMv = true;
          }
          if (this.OXF.OMw) {
            this.OMw = true;
          }
        }
        if (!this.OXE) {
          break label1106;
        }
        localObject1 = this.OXp.Phh;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(8);
        }
        this.OXr = false;
        this.OXi.setBottomExtraHeight(0);
        this.OXX.clear();
      }
      for (;;)
      {
        setEnableSwitchTab(this.OXr);
        Log.i("MicroMsg.ScanUI", "alvinluo initView currentMode: %d, showOnlyScanCode: %b, hideScrollTab: %b, scanRequest: %s", new Object[] { Integer.valueOf(this.LvA), Boolean.valueOf(this.OXC), Boolean.valueOf(this.OXE), this.OXF });
        this.OXi.setActivity(this);
        this.container.addView(this.OXi, 0, new FrameLayout.LayoutParams(-1, -1));
        this.OXi.onCreate();
        this.OSP = this.OXi.getSharedMaskView();
        localObject1 = this.OSP;
        kotlin.g.b.s.u(this, "scanUIModel");
        ((ScanSharedMaskView)localObject1).PbH = this;
        this.OXi.setShowScanTips(this.OXw);
        this.OXi.setNetworkAvailable(this.OXx);
        this.OXi.setScanMode(this.LvA);
        this.OXi.setScanProductOnItemClickListener(this.OYd);
        this.OXi.setScanProductCallback(this.OYf);
        this.OXi.refreshView();
        this.OXk = this.OXi.getScanProductMaskDecorView();
        kQ(this.LvA, 0);
        gSr();
        am.ahX(this.LvA);
        gSs();
        if (this.OXz) {
          this.OXi.setBlackInterval(com.tencent.qbar.b.jWJ());
        }
        gSj();
        gSq();
        if ((this.OXA != null) && (this.OXA.length > 0)) {
          this.OXi.setScanCodeReaders(this.OXA);
        }
        if (this.OXG) {
          this.OXi.setMyQrCodeVisible(false);
        }
        this.OXp.kU(this.LvA, 0);
        gSl();
        this.OXm.setOnCloseClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51700);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/BaseScanUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            BaseScanUI.gSv();
            BaseScanUI.s(BaseScanUI.this);
            BaseScanUI.C(BaseScanUI.this);
            am.K(3, -1, BaseScanUI.r(BaseScanUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51700);
          }
        });
        this.OXm.setOnCancelClickListener(new BaseScanUI.17(this));
        fbu();
        com.tencent.mm.plugin.scanner.d.b.gQw().OPc = new com.tencent.mm.plugin.scanner.d.b.c()
        {
          public final void a(com.tencent.mm.plugin.scanner.scan_goods_new.k paramAnonymousk)
          {
            AppMethodBeat.i(314683);
            if (paramAnonymousk == null)
            {
              AppMethodBeat.o(314683);
              return;
            }
            if (!BaseScanUI.a(BaseScanUI.this, paramAnonymousk))
            {
              Log.w("MicroMsg.ScanUI", "onScanResult can not add now and ignore");
              AppMethodBeat.o(314683);
              return;
            }
            g.b localb = new g.b(2, paramAnonymousk);
            if ((BaseScanUI.q(BaseScanUI.this) instanceof com.tencent.mm.plugin.scanner.g.g))
            {
              BaseScanUI.q(BaseScanUI.this).h(paramAnonymousk.hBk, localb);
              AppMethodBeat.o(314683);
              return;
            }
            Log.w("MicroMsg.ScanUI", "onScanResult resultHandler not expected: %s", new Object[] { BaseScanUI.q(BaseScanUI.this) });
            AppMethodBeat.o(314683);
          }
        };
        AppMethodBeat.o(51730);
        return;
        localObject1 = new ArrayList();
        ((List)localObject1).add(Integer.valueOf(1));
        if (!this.OTn)
        {
          ((List)localObject1).add(Integer.valueOf(12));
          this.OXX.add(Integer.valueOf(1));
          this.OXX.add(Integer.valueOf(2));
          if (!com.tencent.mm.au.b.bKM()) {
            break label1080;
          }
          if (t.gUm())
          {
            ((List)localObject1).add(Integer.valueOf(3));
            this.OXX.add(Integer.valueOf(3));
          }
        }
        for (;;)
        {
          if (((List)localObject1).size() == 1) {
            this.OXE = true;
          }
          this.OXp.kl((List)localObject1);
          break;
          this.OXX.add(Integer.valueOf(4));
          break label1004;
          ((List)localObject1).add(Integer.valueOf(3));
          this.OXX.add(Integer.valueOf(3));
        }
        localObject1 = this.OXp.Phh;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(0);
        }
        this.OXi.setBottomExtraHeight(getResources().getDimensionPixelSize(l.d.OIi));
        this.OXr = true;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(51756);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    final long l1;
    boolean bool;
    label327:
    long l2;
    long l3;
    switch (paramInt1)
    {
    default: 
    case 4660: 
      do
      {
        AppMethodBeat.o(51756);
        return;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          am.aib(this.LvA);
          localObject1 = com.tencent.mm.ui.tools.b.i(this, paramIntent, com.tencent.mm.plugin.image.d.bzL());
          Log.i("MicroMsg.ScanUI", "select: [%s]", new Object[] { localObject1 });
          if (!Util.isNullOrNil((String)localObject1))
          {
            l1 = System.currentTimeMillis();
            com.tencent.qbar.c.ahqI.aGV(com.tencent.qbar.c.ahqB);
            am.a(this.LvA, this.enterScene, 11, this.OXu, l1);
            if (gSp()) {
              com.tencent.mm.plugin.scanner.model.d.UI(40);
            }
            com.tencent.qbar.e.jWN().a(this, l1, (String)localObject1, new e.b()
            {
              public final void a(final long paramAnonymousLong, e.d paramAnonymousd)
              {
                final List localList2 = null;
                AppMethodBeat.i(314491);
                final List localList1;
                if (paramAnonymousd != null)
                {
                  localList1 = paramAnonymousd.OTq;
                  if (paramAnonymousd != null) {
                    localList2 = paramAnonymousd.ahrp;
                  }
                  if (!BaseScanUI.r(BaseScanUI.this)) {
                    break label96;
                  }
                }
                label96:
                for (final int i = 4;; i = 2)
                {
                  if ((paramAnonymousLong == l1) && (BaseScanUI.W(BaseScanUI.this))) {
                    com.tencent.threadpool.h.ahAA.bk(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(314463);
                        Object localObject2;
                        Object localObject1;
                        if ((localList1 != null) && (!localList1.isEmpty()))
                        {
                          localObject2 = BaseScanUI.ki(localList1);
                          BaseScanUI.b(BaseScanUI.this, false);
                          localObject1 = new Bundle();
                          ((Bundle)localObject1).putString("result_content", ((com.tencent.qbar.a.a)((List)localObject2).get(0)).data);
                          ((Bundle)localObject1).putInt("result_code_format", ((com.tencent.qbar.a.a)((List)localObject2).get(0)).typeID);
                          ((Bundle)localObject1).putString("result_code_name", ((com.tencent.qbar.a.a)((List)localObject2).get(0)).typeName);
                          localObject2 = ((com.tencent.qbar.a.a)((List)localObject2).get(0)).rawData;
                          if (localObject2 != null) {
                            ((Bundle)localObject1).putByteArray("result_raw_data", (byte[])localObject2);
                          }
                          if ((localList2 == null) || (localList2.isEmpty())) {
                            break label627;
                          }
                        }
                        label627:
                        for (int i = ((WxQbarNative.QBarReportMsg)localList2.get(0)).qrcodeVersion;; i = 0)
                        {
                          ((Bundle)localObject1).putInt("result_code_version", i);
                          ((Bundle)localObject1).putParcelable("ScanIdentifyReportInfo.DecodeKey", new ScanIdentifyReportInfo(BaseScanUI.32.this.OYw));
                          am.a(BaseScanUI.b(BaseScanUI.this), true, i, 1);
                          com.tencent.mm.plugin.scanner.model.d.UI(41);
                          if (BaseScanUI.u(BaseScanUI.this))
                          {
                            localObject2 = new Intent();
                            ((Intent)localObject2).putExtra("key_scan_result", ((Bundle)localObject1).getString("result_content"));
                            ((Intent)localObject2).putExtra("key_scan_result_raw", ((Bundle)localObject1).getByteArray("result_raw_data"));
                            ((Intent)localObject2).putExtra("key_scan_result_code_name", ((Bundle)localObject1).getString("result_code_name"));
                            ((Intent)localObject2).putExtra("key_scan_result_code_version", i);
                            BaseScanUI.this.setResult(-1, (Intent)localObject2);
                            BaseScanUI.this.dmh();
                            AppMethodBeat.o(314463);
                            return;
                          }
                          ((Bundle)localObject1).putInt("qbar_string_scan_source", 1);
                          if (BaseScanUI.q(BaseScanUI.this) != null)
                          {
                            localObject1 = new g.b(1, localObject1);
                            BaseScanUI.q(BaseScanUI.this).h(paramAnonymousLong, localObject1);
                          }
                          BaseScanUI.o(BaseScanUI.this);
                          am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 12, BaseScanUI.d(BaseScanUI.this), BaseScanUI.32.this.OYv);
                          AppMethodBeat.o(314463);
                          return;
                          BaseScanUI.b(BaseScanUI.this, true);
                          am.a(BaseScanUI.b(BaseScanUI.this), false, i, 1);
                          if (BaseScanUI.r(BaseScanUI.this))
                          {
                            localObject1 = BaseScanUI.Y(BaseScanUI.this);
                            long l = System.currentTimeMillis();
                            i = BaseScanUI.32.this.OYx;
                            localObject2 = BaseScanUI.32.this.vsF;
                            BaseScanUI.b(BaseScanUI.this);
                            ((ak)localObject1).a(l, i, (Intent)localObject2, i, BaseScanUI.X(BaseScanUI.this));
                            am.a(BaseScanUI.b(BaseScanUI.this), BaseScanUI.c(BaseScanUI.this), 13, BaseScanUI.d(BaseScanUI.this), BaseScanUI.32.this.OYv);
                            AppMethodBeat.o(314463);
                            return;
                          }
                          BaseScanUI.j(BaseScanUI.this, true);
                          AppMethodBeat.o(314463);
                          return;
                        }
                      }
                    });
                  }
                  AppMethodBeat.o(314491);
                  return;
                  localList1 = null;
                  break;
                }
              }
            }, this.OXA);
          }
          AppMethodBeat.o(51756);
          return;
        }
        gQM();
      } while ((paramInt2 != 0) || (!t.aiG(this.LvA)));
      am.aia(this.LvA);
      AppMethodBeat.o(51756);
      return;
    case 1002: 
      finish();
      AppMethodBeat.o(51756);
      return;
    case 1001: 
      finish();
    case 2000: 
      if (paramIntent == null)
      {
        bool = true;
        Log.i("MicroMsg.ScanUI", "alvinluo processGoodsImage resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        if (paramInt2 != -1) {
          break label625;
        }
        am.aib(this.LvA);
        am.aY(2, System.currentTimeMillis());
        localObject1 = com.tencent.mm.ui.tools.b.i(this, paramIntent, com.tencent.mm.plugin.image.d.bzL());
        l1 = System.currentTimeMillis();
        if (paramIntent != null) {
          break label599;
        }
        bool = true;
        Log.d("MicroMsg.ScanUI", "alvinluo processGoodsImage session: %d, resultCode: %d, filePath: %s, data == null: %b", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt2), localObject1, Boolean.valueOf(bool) });
        if (this.OXi != null) {
          this.OXi.setScanSource(2);
        }
        paramInt1 = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject1);
        l2 = System.currentTimeMillis();
        paramIntent = BitmapUtil.decodeFileWithSample((String)localObject1);
        l3 = System.currentTimeMillis();
        if ((paramInt1 != 90) && (paramInt1 != 270)) {
          break label716;
        }
        paramIntent = BitmapUtil.rotate(paramIntent, paramInt1);
      }
      break;
    }
    label716:
    for (;;)
    {
      Log.i("MicroMsg.ScanUI", "alvinluo processGoodsImage decode image cost: %d, rotation: %s", new Object[] { Long.valueOf(l3 - l2), Integer.valueOf(paramInt1) });
      Object localObject2;
      if ((paramIntent != null) && (!paramIntent.isRecycled()))
      {
        localObject2 = this.OXi.getScanMaskView();
        if (!(localObject2 instanceof ScanGoodsMaskView)) {
          break label605;
        }
        ((ScanGoodsMaskView)localObject2).az(paramIntent);
      }
      for (;;)
      {
        this.OTa = new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(314493);
            Log.i("MicroMsg.ScanUI", "alvinluo processGoodsImage onCancel and resumeScan");
            if ((BaseScanUI.q(BaseScanUI.this) instanceof com.tencent.mm.plugin.scanner.g.a))
            {
              paramAnonymousDialogInterface = (com.tencent.mm.plugin.scanner.g.a)BaseScanUI.q(BaseScanUI.this);
              long l = l1;
              com.tencent.mm.plugin.scanner.model.b localb = paramAnonymousDialogInterface.OVr;
              if (localb != null) {
                localb.tV(l);
              }
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.OVq;
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.tV(l);
              }
            }
            am.a(this.OYz, false, System.currentTimeMillis(), true);
            BaseScanUI.this.gQM();
            AppMethodBeat.o(314493);
          }
        };
        if (this.OXi != null) {
          this.OXi.b(true, this.OTa);
        }
        paramIntent = com.tencent.mm.plugin.scanner.d.a.gQu();
        localObject2 = this.OYh;
        Log.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask filePath: %s, source: %s, rotation: %s", new Object[] { localObject1, Integer.valueOf(2), Integer.valueOf(paramInt1) });
        ac.a(new a.2(paramIntent, (String)localObject1, paramInt1, (a.c)localObject2, l1));
        AppMethodBeat.o(51756);
        return;
        bool = false;
        break;
        label599:
        bool = false;
        break label327;
        label605:
        if ((localObject2 instanceof ScanCodeProductMergeMaskView)) {
          ((ScanCodeProductMergeMaskView)localObject2).az(paramIntent);
        }
      }
      label625:
      gQM();
      if (paramInt2 == 0) {
        am.aia(12);
      }
      AppMethodBeat.o(51756);
      return;
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = com.tencent.mm.ui.tools.b.i(this, paramIntent, com.tencent.mm.plugin.image.d.bzL());
      Log.i("MicroMsg.ScanUI", "alvinluo scanTranslate select image: [%s]", new Object[] { paramIntent });
      if (this.OXo == null) {
        break;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key_translate_file_path", paramIntent);
      this.OXo.h(System.currentTimeMillis(), localObject1);
      break;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(51741);
    Log.v("MicroMsg.ScanUI", "alvinluo onBackPressed");
    if ((this.OUu != null) && (this.OUu.gPQ()))
    {
      this.OUu.dismiss();
      AppMethodBeat.o(51741);
      return;
    }
    if ((this.OXK == null) || (!this.OXK.OSR)) {}
    for (int i = 0; i != 0; i = 1)
    {
      if (gSo()) {
        break label183;
      }
      gQM();
      AppMethodBeat.o(51741);
      return;
      Log.i("MicroMsg.ScanUI", "alvinluo cancelLoading");
      ai localai = this.OXK;
      c.a locala = localai.OSS;
      if (locala != null) {
        locala.gTH();
      }
      localai.OSS = null;
      this.OXK.aL(false, false);
    }
    if ((!gSo()) && ((this.OXk == null) || (!this.OXk.onBackPressed())))
    {
      if (this.LvA == 12) {
        am.Ca(false);
      }
      am.ahY(this.LvA);
      goBack();
    }
    label183:
    AppMethodBeat.o(51741);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(51758);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.ScanUI", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    AppMethodBeat.o(51758);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51729);
    super.onCreate(paramBundle);
    Ce(true);
    boolean bool2;
    boolean bool1;
    label365:
    int i;
    if ((com.tencent.mm.kernel.h.aZW().bFQ() == 6) || (com.tencent.mm.kernel.h.aZW().bFQ() == 4))
    {
      this.OXx = true;
      this.uAL = ((Vibrator)getSystemService("vibrator"));
      this.OXA = getIntent().getIntArrayExtra("key_support_scan_code_type");
      this.OXB = getIntent().getIntExtra("key_scan_entry_scene", 0);
      this.enterScene = getIntent().getIntExtra("key_scan_report_enter_scene", 0);
      this.OXC = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
      this.OXD = getIntent().getBooleanExtra("key_set_result_after_scan", false);
      this.OMw = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
      this.LvA = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
      this.OXw = getIntent().getBooleanExtra("key_show_scan_tips", true);
      this.OXz = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.OXQ = getIntent().getBooleanExtra("key_enable_multi_code", false);
      this.OTn = getIntent().getBooleanExtra("key_enable_scan_code_product_merge", false);
      this.OXS = getIntent().getBooleanExtra("key_scan_goods_enable_dynamic_wording", false);
      this.OXG = getIntent().getBooleanExtra("key_for_jsapi_use", false);
      this.OMv = this.OMw;
      if (t.aiH(this.LvA))
      {
        this.OXF = ((BaseScanRequest)getIntent().getParcelableExtra("key_scan_request"));
        this.OXn = am.a(this.OXF);
      }
      com.tencent.mm.plugin.scanner.util.e.jB(this);
      com.tencent.mm.plugin.scanner.util.i.gUa();
      com.tencent.qbar.b.jWI();
      com.tencent.qbar.f.jWR();
      t.gUn();
      com.tencent.mm.plugin.scanner.util.e.init();
      bool2 = t.gPB();
      Log.i("MicroMsg.ScanUI", "alvinluo initEnableMultiCode configEnableMultiCode: %b, entryEnableMultiCode: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(this.OXQ) });
      if ((!bool2) || (!this.OXQ)) {
        break label888;
      }
      bool1 = true;
      this.OXQ = bool1;
      paramBundle = com.tencent.qbar.h.jWV();
      if ((!bool2) || (!this.OXQ)) {
        break label893;
      }
      bool1 = true;
      label388:
      paramBundle.OXQ = bool1;
      paramBundle.rQG.Oq(bool1);
      bool1 = com.tencent.mm.plugin.scanner.c.a.gQk();
      if ((!bool1) || (!this.OTn)) {
        break label898;
      }
      i = 1;
      label418:
      bool2 = com.tencent.mm.plugin.scanner.util.d.aTr();
      Log.i("MicroMsg.ScanUI", "initEnableScanCodeProductMerge configEnableScanMerge: %b, enableScanCodeProductMerge: %b, willCrash: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.OTn), Boolean.valueOf(bool2) });
      if ((i == 0) || (bool2)) {
        break label903;
      }
      bool1 = true;
      label472:
      this.OTn = bool1;
      if (!this.OTn) {
        break label908;
      }
      gSi();
      this.OYb = new ak(this);
      paramBundle = com.tencent.mm.plugin.scanner.d.b.gQw();
      paramBundle.OPd = new com.tencent.mm.plugin.scanner.d.b.b(paramBundle);
      paramBundle.OPe = true;
      com.tencent.mm.plugin.scanner.d.b.OOK = com.tencent.mm.plugin.scanner.util.i.gUb();
      paramBundle = w.ORS;
      w.BX(true);
      if (com.tencent.mm.plugin.scanner.util.e.gTR()) {
        aa.makeText(this, String.format("引擎识别跳帧数：%s，后台识别帧数：%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.scanner.util.i.gUb()), Integer.valueOf(com.tencent.mm.plugin.scanner.util.i.gUc()) }), 0).show();
      }
    }
    for (;;)
    {
      if ((i != 0) && (bool2)) {
        com.tencent.mm.plugin.scanner.model.d.UI(4);
      }
      gSh();
      Object localObject;
      if (getIntent().getBooleanExtra("key_check_camera_using", false))
      {
        paramBundle = new BaseScanUI.5(this);
        if ((!com.tencent.mm.n.a.b(this, paramBundle)) && (!com.tencent.mm.n.a.a(this, paramBundle)))
        {
          localObject = new x();
          ((x)localObject).publish();
          Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(((x)localObject).hzI.hzK), Boolean.valueOf(((x)localObject).hzI.hzJ) });
          if (((x)localObject).hzI.hzJ)
          {
            Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
            com.tencent.mm.ui.base.k.a(this, "", com.tencent.mm.n.a.t(this, ((x)localObject).hzI.hzJ), getString(c.h.app_i_know), paramBundle);
          }
          if (!((x)localObject).hzI.hzJ) {}
        }
        else
        {
          Log.w("MicroMsg.ScanUI", "checkCameraUsing camera is using and disable camera");
          this.OXT = false;
        }
      }
      initView();
      this.OXu = System.currentTimeMillis();
      this.xeK.alive();
      com.tencent.mm.xwebutil.c.jQE();
      am.BZ(this.OTn);
      aio(1);
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramBundle = (dgs)com.tencent.mm.plugin.secdata.ui.a.a.b(this, 3, dgs.class);
      if ((paramBundle != null) && ("launch_type_scan_qrcode".equals(paramBundle.aaLL)))
      {
        paramBundle = new rg();
        paramBundle.iUz = 2L;
        paramBundle.jvA = 1L;
        paramBundle.bMH();
        localObject = com.tencent.mm.util.c.agsX;
        com.tencent.mm.util.c.a(paramBundle);
      }
      gSk();
      com.tencent.mm.plugin.scanner.util.d.Cy(this.OTn);
      AppMethodBeat.o(51729);
      return;
      this.OXx = false;
      break;
      label888:
      bool1 = false;
      break label365;
      label893:
      bool1 = false;
      break label388;
      label898:
      i = 0;
      break label418;
      label903:
      bool1 = false;
      break label472;
      label908:
      paramBundle = w.ORS;
      w.BX(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51755);
    Log.i("MicroMsg.ScanUI", "onDestroy()");
    super.onDestroy();
    com.tencent.mm.plugin.scanner.util.d.gTQ();
    this.xeK.dead();
    if (this.OXo != null) {
      this.OXo.destroy();
    }
    if (this.OXi != null) {
      this.OXi.onDestroy();
    }
    if ((this.OUu != null) && (this.OUu.gPQ())) {
      this.OUu.dismiss();
    }
    if ((this.ucS != null) && (this.ucS.isShowing())) {
      this.ucS.cyW();
    }
    if (this.Hji != null) {
      this.Hji.a(this.wGt);
    }
    aio(2);
    w localw = w.ORS;
    w.BX(false);
    AppMethodBeat.o(51755);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51753);
    super.onPause();
    Log.i("MicroMsg.ScanUI", "alvinluo onPause needPauseScan: %b", new Object[] { Boolean.valueOf(this.OXH) });
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (this.OXi != null)
    {
      this.OXi.onPause();
      if (this.OXH) {
        this.OXi.auq();
      }
    }
    if (this.OXM.jHv == 0L) {
      aM(false, false);
    }
    com.tencent.qbar.c.ahqH.cIX();
    Object localObject = com.tencent.mm.plugin.scanner.util.l.Pjm;
    Log.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (((com.tencent.mm.plugin.scanner.util.l)localObject).mSensorManager != null)
    {
      Log.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      ((com.tencent.mm.plugin.scanner.util.l)localObject).mSensorManager.unregisterListener((SensorEventListener)localObject);
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (this.OUu != null)
    {
      localObject = this.OUu.ONn;
      if (localObject != null)
      {
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onPause set canMeasured false");
        ((BaseBoxDialogView)localObject).pvl = false;
      }
    }
    AppMethodBeat.o(51753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51752);
    Log.i("MicroMsg.ScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51752);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.OXs = false;
        com.tencent.mm.ui.base.k.a(this, getString(l.i.permission_camera_request_again_msg), getString(l.i.permission_tips_title), getString(l.i.jump_to_settings), getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(314965);
            com.tencent.mm.pluginsdk.permission.b.lx(BaseScanUI.this.getContext());
            BaseScanUI.U(BaseScanUI.this);
            BaseScanUI.this.finish();
            AppMethodBeat.o(314965);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(314976);
            BaseScanUI.U(BaseScanUI.this);
            BaseScanUI.this.finish();
            AppMethodBeat.o(314976);
          }
        });
        AppMethodBeat.o(51752);
        return;
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
        {
          this.OXt = false;
          com.tencent.mm.ui.base.k.a(this, getString(l.i.permission_location_request_again_msg), getString(l.i.permission_tips_title), getString(l.i.jump_to_settings), getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(314963);
              com.tencent.mm.pluginsdk.permission.b.lx(BaseScanUI.this.getContext());
              BaseScanUI.V(BaseScanUI.this);
              BaseScanUI.this.finish();
              AppMethodBeat.o(314963);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(314964);
              BaseScanUI.V(BaseScanUI.this);
              BaseScanUI.this.finish();
              AppMethodBeat.o(314964);
            }
          });
          AppMethodBeat.o(51752);
          return;
          if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
          {
            if (!androidx.core.app.a.a(this, "android.permission.RECORD_AUDIO"))
            {
              com.tencent.mm.ui.base.k.a(this, getString(l.i.app_special_no_record_audio_permission), getString(l.i.app_need_audio_title), new BaseScanUI..ExternalSyntheticLambda1(this), new BaseScanUI..ExternalSyntheticLambda0(this));
              AppMethodBeat.o(51752);
              return;
            }
            finish();
            AppMethodBeat.o(51752);
            return;
          }
          ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).goToAnchorLiveDirect(this, new BaseScanUI..ExternalSyntheticLambda2(this), true);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51751);
    super.onResume();
    Log.i("MicroMsg.ScanUI", "alvinluo BaseScanUI onResume needPauseScan: %b", new Object[] { Boolean.valueOf(this.OXH) });
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    Object localObject = com.tencent.mm.plugin.scanner.util.l.Pjm;
    Log.i("MicroMsg.ScanStableDetector", "start detect scan stable");
    if (((com.tencent.mm.plugin.scanner.util.l)localObject).mSensorManager != null)
    {
      ((com.tencent.mm.plugin.scanner.util.l)localObject).Pjk = 0;
      ((com.tencent.mm.plugin.scanner.util.l)localObject).Pjj[0] = 0.0F;
      ((com.tencent.mm.plugin.scanner.util.l)localObject).Pjj[1] = 0.0F;
      ((com.tencent.mm.plugin.scanner.util.l)localObject).Pjj[2] = 0.0F;
      Log.i("MicroMsg.ScanStableDetector", "register accelerate listener");
      ((com.tencent.mm.plugin.scanner.util.l)localObject).mSensorManager.registerListener((SensorEventListener)localObject, ((com.tencent.mm.plugin.scanner.util.l)localObject).Pji, 50000);
    }
    Log.i("MicroMsg.ScanUI", "should check camera %s, location %s", new Object[] { Boolean.valueOf(this.OXs), Boolean.valueOf(this.OXt) });
    boolean bool;
    int i;
    if ((this.OXs) || (this.OXt)) {
      if (this.OXs)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null);
        Log.i("MicroMsg.ScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          this.OTm = false;
          i = 0;
          if (i != 0)
          {
            am.Cb(this.OTm);
            if (com.tencent.mm.compatible.e.b.aPP()) {
              break label366;
            }
            com.tencent.mm.ui.base.k.a(this, getString(l.i.permission_camera_request_again_msg), getString(l.i.permission_tips_title), getString(l.i.jump_to_settings), getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(51713);
                com.tencent.mm.pluginsdk.permission.b.lx(BaseScanUI.this.getContext());
                BaseScanUI.U(BaseScanUI.this);
                BaseScanUI.this.finish();
                AppMethodBeat.o(51713);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(314989);
                BaseScanUI.U(BaseScanUI.this);
                BaseScanUI.this.finish();
                AppMethodBeat.o(314989);
              }
            });
          }
        }
      }
    }
    for (;;)
    {
      getWindow().addFlags(128);
      if (this.OUu != null)
      {
        localObject = this.OUu.ONn;
        if (localObject != null) {
          ((BaseBoxDialogView)localObject).pvl = true;
        }
      }
      AppMethodBeat.o(51751);
      return;
      if (this.OXt)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 76, null);
        Log.i("MicroMsg.ScanUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      label366:
      Log.i("MicroMsg.ScanUI", "alvinluo onResumeAfterChkPermission needPauseScan: %b", new Object[] { Boolean.valueOf(this.OXH) });
      if (!this.OXH)
      {
        this.OXi.onResume();
        this.OXm.Cl(true);
        Cf(true);
      }
      com.tencent.mm.kernel.h.baD().a(this.OYk);
      gSi();
      this.OYl.alive();
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(51754);
    super.onStop();
    if (this.OXi != null) {
      this.OXi.onStop();
    }
    this.OXj.gTa();
    com.tencent.mm.kernel.h.baD().b(this.OYk);
    this.OYl.dead();
    getWindow().clearFlags(128);
    AppMethodBeat.o(51754);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void x(int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(314881);
    Log.i("MicroMsg.ScanUI", "alvinluo showInfoView type: %d", new Object[] { Integer.valueOf(paramInt) });
    boolean bool1;
    label115:
    ai localai;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4))
    {
      if (this.OSP != null)
      {
        this.OSP.Phz = this.OXi.getTextrueView();
        localObject1 = this.OSP;
        if ((paramInt != 3) && (paramInt != 4)) {
          break label316;
        }
        bool1 = true;
        ((ScanSharedMaskView)localObject1).setAnimateBackgroundView(bool1);
      }
      this.OXH = true;
      bool1 = bool2;
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          break label321;
        }
        bool1 = bool2;
      }
      this.OXm.Cl(false);
      this.OXm.b(bool1, null);
      if (this.OXK != null)
      {
        localai = this.OXK;
        kotlin.g.b.s.u(this, "context");
        localObject1 = localai.OSO;
        if (localObject1 != null) {
          break label326;
        }
      }
    }
    label316:
    label321:
    label326:
    for (Object localObject1 = null;; localObject1 = ((BaseScanMaskView)localObject1).getTargetSuccessMarkView())
    {
      Object localObject2 = localai.OSQ;
      if (localObject2 != null) {
        ((ScanInfoMaskView)localObject2).setAnchorView((View)localObject1);
      }
      localObject1 = localai.OSP;
      if (localObject1 != null)
      {
        localObject2 = ((ScanSharedMaskView)localObject1).contentLayout;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("contentLayout");
          localObject1 = null;
        }
        com.tencent.mm.plugin.scanner.util.p.a((View)localObject1, 0.0F, 1.0F, 200L, null);
      }
      localObject1 = localai.OSO;
      if (localObject1 != null) {
        ((BaseScanMaskView)localObject1).gTm();
      }
      paramBundle = localai.a(this, paramInt, paramBundle);
      if (paramBundle != null)
      {
        localai.OST = paramInt;
        localObject1 = localai.OSQ;
        if (localObject1 != null) {
          ((ScanInfoMaskView)localObject1).a(paramBundle);
        }
      }
      if (paramInt == 3) {
        am.b(4, this.OTn, this.LvA, 0);
      }
      AppMethodBeat.o(314881);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label115;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI
 * JD-Core Version:    0.7.0.1
 */