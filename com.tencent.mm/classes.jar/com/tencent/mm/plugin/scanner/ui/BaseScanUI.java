package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.ks;
import com.tencent.mm.g.b.a.nr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.BaseBoxDialogView;
import com.tencent.mm.plugin.scanner.d.a.2;
import com.tencent.mm.plugin.scanner.d.a.c;
import com.tencent.mm.plugin.scanner.f.d.a;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.ui.component.ScanUITopOpButtonComponent;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView.d;
import com.tencent.mm.plugin.scanner.ui.widget.ScanScrollTabView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.b.b;
import com.tencent.mm.plugin.scanner.ui.widget.b.c;
import com.tencent.mm.plugin.scanner.ui.widget.b.d;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class BaseScanUI
  extends MMSecDataActivity
  implements d.a, com.tencent.mm.plugin.scanner.model.f, com.tencent.mm.plugin.scanner.view.c
{
  private boolean CAH;
  private boolean CAI;
  private mu CAV;
  private ScanSharedMaskView CGE;
  private ScanInfoMaskView CGF;
  private boolean CGP;
  private com.tencent.mm.plugin.scanner.box.i CIq;
  private boolean CJA;
  private boolean CJB;
  private boolean CJC;
  private BaseScanRequest CJD;
  private boolean CJE;
  private boolean CJF;
  private boolean CJG;
  private boolean CJH;
  private ad CJI;
  private boolean CJJ;
  private nr CJK;
  private int CJL;
  private boolean CJM;
  private boolean CJN;
  private boolean CJO;
  private ScanUIRectView.a CJP;
  private a.c CJQ;
  private com.tencent.mm.plugin.scanner.f.a.a CJR;
  private com.tencent.mm.plugin.scanner.box.g CJS;
  private com.tencent.mm.network.p CJT;
  private IListener CJU;
  private ScanUIRectView CJg;
  private ScannerFlashSwitcher CJh;
  private View CJi;
  private DialogInterface.OnCancelListener CJj;
  private ScanUITopOpButtonComponent CJk;
  private int CJl;
  private com.tencent.mm.plugin.scanner.f.e CJm;
  private com.tencent.mm.plugin.scanner.ui.widget.b CJn;
  private boolean CJo;
  private boolean CJp;
  private boolean CJq;
  private boolean CJr;
  private long CJs;
  private boolean CJt;
  private boolean CJu;
  private boolean CJv;
  private boolean CJw;
  private boolean CJx;
  private int[] CJy;
  private int CJz;
  private FrameLayout container;
  private com.tencent.mm.ui.widget.a.e nVN;
  private Vibrator paT;
  private IListener<zj> qCu;
  private b.a qgt;
  private com.tencent.mm.modelgeo.d uzs;
  private int zTQ;
  
  public BaseScanUI()
  {
    AppMethodBeat.i(51728);
    this.CIq = null;
    this.CJl = 0;
    this.CJo = false;
    this.CJp = true;
    this.CJq = true;
    this.CJr = false;
    this.CGP = true;
    this.CJt = true;
    this.CJu = true;
    this.CJv = true;
    this.CJw = true;
    this.CJx = false;
    this.CJF = false;
    this.CJG = true;
    this.CJH = true;
    this.CJI = new ad();
    this.CJJ = true;
    this.CJK = new nr();
    this.CJM = false;
    this.CJN = false;
    this.CJO = false;
    this.CJP = new ScanUIRectView.a()
    {
      public final void e(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51682);
        if (!BaseScanUI.a(BaseScanUI.this))
        {
          Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", new Object[] { Integer.valueOf(BaseScanUI.b(BaseScanUI.this)) });
          AppMethodBeat.o(51682);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          Log.i("MicroMsg.ScanUI", "scan code cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)) });
          Object localObject2 = paramAnonymousBundle.getParcelableArrayList("result_qbar_result_list");
          if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0))
          {
            Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
            AppMethodBeat.o(51682);
            return;
          }
          final int j = paramAnonymousBundle.getInt("result_code_point_count", 0);
          long l = paramAnonymousBundle.getLong("decode_success_cost_time", 0L);
          af.a(BaseScanUI.b(BaseScanUI.this), true, 1, j);
          BaseScanUI.e(BaseScanUI.this);
          Object localObject1 = BaseScanUI.this;
          if (j > 1) {}
          boolean bool2;
          for (boolean bool1 = true;; bool1 = false)
          {
            BaseScanUI.a((BaseScanUI)localObject1, bool1);
            BaseScanUI.b(BaseScanUI.this, false);
            af.a(BaseScanUI.b(BaseScanUI.this), (List)localObject2, l);
            bool2 = BaseScanUI.f(BaseScanUI.this).VC;
            localObject1 = (WxQBarResult)((ArrayList)localObject2).get(0);
            if (!BaseScanUI.g(BaseScanUI.this)) {
              break label397;
            }
            if (localObject1 != null) {
              break;
            }
            Log.w("MicroMsg.ScanUI", "first Qbar result is null");
            AppMethodBeat.o(51682);
            return;
          }
          paramAnonymousBundle = ((WxQBarResult)localObject1).typeName;
          Object localObject3 = new qa();
          localObject2 = ((WxQBarResult)localObject1).data;
          ((qa)localObject3).dWj.scanResult = ((String)localObject2);
          ((qa)localObject3).dWj.dWl = paramAnonymousBundle;
          ((qa)localObject3).dWj.cSx = 0;
          EventCenter.instance.publish((IEvent)localObject3);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("key_scan_result", (String)localObject2);
          ((Intent)localObject3).putExtra("key_scan_result_raw", ((WxQBarResult)localObject1).rawData);
          ((Intent)localObject3).putExtra("key_scan_result_code_name", paramAnonymousBundle);
          ((Intent)localObject3).putExtra("key_scan_result_code_version", ((WxQBarResult)localObject1).RJN);
          BaseScanUI.this.setResult(-1, (Intent)localObject3);
          BaseScanUI.this.cvn();
          AppMethodBeat.o(51682);
          return;
          label397:
          paramAnonymousBundle.putInt("qbar_string_scan_source", 0);
          if ((j > 0) && (BaseScanUI.h(BaseScanUI.this) != null))
          {
            localObject3 = (ScanDecodeFrameData)paramAnonymousBundle.getParcelable("decode_success_frame_data");
            if (localObject3 != null) {
              BaseScanUI.h(BaseScanUI.this).setDecodeSuccessFrameData((ScanDecodeFrameData)localObject3);
            }
            localObject3 = BaseScanUI.this;
            Object localObject4;
            int i;
            if (j > 1)
            {
              bool1 = true;
              BaseScanUI.c((BaseScanUI)localObject3, bool1);
              if (j > 1)
              {
                BaseScanUI.i(BaseScanUI.this).tZ(false);
                BaseScanUI.i(BaseScanUI.this).b(true, null);
                BaseScanUI.j(BaseScanUI.this);
              }
              BaseScanUI.d(BaseScanUI.this, true);
              BaseScanUI.h(BaseScanUI.this).setSuccessMarkClickListener(new ag()
              {
                public final void WK(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(169958);
                  Log.i("MicroMsg.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  if ((paramAnonymous2Int < this.CJW.size()) && (j > 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.val$result, (WxQBarResult)this.CJW.get(paramAnonymous2Int));
                    af.ib(2, paramAnonymous2Int);
                    af.eQn();
                  }
                  AppMethodBeat.o(169958);
                }
              });
              BaseScanUI.k(BaseScanUI.this);
              BaseScanUI.l(BaseScanUI.this);
              BaseScanUI.m(BaseScanUI.this);
              localObject3 = BaseScanUI.h(BaseScanUI.this);
              if (com.tencent.mm.plugin.scanner.util.d.eRT())
              {
                if (((ScanUIRectView)localObject3).CNk == null)
                {
                  ((ScanUIRectView)localObject3).CNk = new ScanDebugView(((ScanUIRectView)localObject3).getContext());
                  ((ScanUIRectView)localObject3).addView(((ScanUIRectView)localObject3).CNk);
                }
                if (((ScanUIRectView)localObject3).CNk != null)
                {
                  localObject4 = ((ScanUIRectView)localObject3).CNk;
                  if (paramAnonymousBundle != null)
                  {
                    localObject3 = paramAnonymousBundle.getString("decode_debug_string");
                    CharSequence localCharSequence = (CharSequence)localObject3;
                    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
                      break label744;
                    }
                    i = 1;
                    label663:
                    if (i != 0) {
                      break label750;
                    }
                    ((ScanDebugView)localObject4).setVisibility(0);
                    localObject4 = ((ScanDebugView)localObject4).zUR;
                    if (localObject4 == null) {
                      kotlin.g.b.p.btv("debugInfo");
                    }
                    ((TextView)localObject4).setText((CharSequence)localObject3);
                  }
                }
              }
            }
            for (;;)
            {
              BaseScanUI.h(BaseScanUI.this).a(localObject2, new com.tencent.mm.plugin.scanner.view.d()
              {
                public final void eQG()
                {
                  AppMethodBeat.i(169959);
                  if ((j == 1) || (this.CJW.size() == 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.val$result, this.CJZ);
                    af.ib(1, 0);
                  }
                  AppMethodBeat.o(169959);
                }
              }, bool2);
              AppMethodBeat.o(51682);
              return;
              bool1 = false;
              break;
              label744:
              i = 0;
              break label663;
              label750:
              ((ScanDebugView)localObject4).setVisibility(8);
              localObject3 = ((ScanDebugView)localObject4).zUR;
              if (localObject3 == null) {
                kotlin.g.b.p.btv("debugInfo");
              }
              ((TextView)localObject3).setText((CharSequence)"");
            }
          }
          BaseScanUI.b(BaseScanUI.this, true);
          BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, paramAnonymousBundle, (WxQBarResult)localObject1);
        }
        AppMethodBeat.o(51682);
      }
    };
    this.CJQ = new a.c()
    {
      public final void H(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(51710);
        Log.e("MicroMsg.ScanUI", "alvinluo onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousString });
        String str = paramAnonymousString;
        if (Util.isNullOrNil(paramAnonymousString)) {
          str = BaseScanUI.this.getResources().getString(2131764999);
        }
        com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755921), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(51708);
            BaseScanUI.s(BaseScanUI.this);
            af.WE(BaseScanUI.b(BaseScanUI.this));
            AppMethodBeat.o(51708);
          }
        });
        af.a(2, false, System.currentTimeMillis());
        AppMethodBeat.o(51710);
      }
      
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51709);
        if (BaseScanUI.n(BaseScanUI.this))
        {
          Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess isScrolling and ignore");
          AppMethodBeat.o(51709);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          BaseScanUI.o(BaseScanUI.this);
          int i = paramAnonymousBundle.getInt("scan_source", 0);
          Log.i("MicroMsg.ScanUI", "alvinluo onScanSuccess cost time %d, scanImageCount: %d, source: %d, session: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)), Integer.valueOf(BaseScanUI.p(BaseScanUI.this)), Integer.valueOf(i), Long.valueOf(paramAnonymousLong) });
          if ((i == 1) && (!BaseScanUI.q(BaseScanUI.this)))
          {
            if ((BaseScanUI.r(BaseScanUI.this) instanceof ScanGoodsRequest))
            {
              paramAnonymousBundle.putParcelable("key_scan_request", BaseScanUI.r(BaseScanUI.this));
              paramAnonymousBundle.putInt("key_scan_goods_mode", ((ScanGoodsRequest)BaseScanUI.r(BaseScanUI.this)).mode);
            }
            BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, paramAnonymousBundle);
            AppMethodBeat.o(51709);
            return;
          }
          if (i == 2)
          {
            if ((BaseScanUI.r(BaseScanUI.this) instanceof ScanGoodsRequest)) {
              paramAnonymousBundle.putParcelable("key_scan_request", BaseScanUI.r(BaseScanUI.this));
            }
            BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(51709);
      }
    };
    this.CJR = new com.tencent.mm.plugin.scanner.f.a.a()
    {
      public final void a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        AppMethodBeat.i(240738);
        Log.i("MicroMsg.ScanUI", "notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Long.valueOf(paramAnonymousLong), Integer.valueOf(1) });
        BaseScanUI.u(BaseScanUI.this);
        AppMethodBeat.o(240738);
      }
      
      public final void b(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161970);
        String str;
        if (paramAnonymousInt1 == 2)
        {
          af.T(false, paramAnonymousInt1);
          BaseScanUI.t(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          BaseScanUI.h(BaseScanUI.this).b(false, null);
          str = paramAnonymousString;
          if (Util.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(2131764999);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755921), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51717);
              BaseScanUI.s(BaseScanUI.this);
              af.WE(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(51717);
            }
          });
          AppMethodBeat.o(161970);
          return;
        }
        if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == 1003))
        {
          Log.e("MicroMsg.ScanUI", "alvinluo onScanResultFailed stop upload and show alert");
          if (BaseScanUI.c(BaseScanUI.this) != null) {
            BaseScanUI.c(BaseScanUI.this).F(paramAnonymousLong, false);
          }
          BaseScanUI.t(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          str = paramAnonymousString;
          if (Util.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(2131765000);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755921), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(161969);
              BaseScanUI.s(BaseScanUI.this);
              af.WE(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(161969);
            }
          });
        }
        AppMethodBeat.o(161970);
      }
      
      public final void b(z paramAnonymousz)
      {
        AppMethodBeat.i(51718);
        if (BaseScanUI.b(BaseScanUI.this) != 12)
        {
          Log.i("MicroMsg.ScanUI", "alvnluo onScanResultSuccess not SELECT_SCAN_MODE_GOODS and ignore");
          AppMethodBeat.o(51718);
          return;
        }
        if ((BaseScanUI.n(BaseScanUI.this)) || ((paramAnonymousz.source == 1) && (BaseScanUI.q(BaseScanUI.this))))
        {
          Log.e("MicroMsg.ScanUI", "alvinluo onScanResultSuccess source:%d, isScrolling: %b or needPauseScan: %b and ignore", new Object[] { Integer.valueOf(paramAnonymousz.source), Boolean.valueOf(BaseScanUI.n(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.q(BaseScanUI.this)) });
          AppMethodBeat.o(51718);
          return;
        }
        BaseScanUI.a(BaseScanUI.this, paramAnonymousz);
        AppMethodBeat.o(51718);
      }
    };
    this.CJS = new com.tencent.mm.plugin.scanner.box.g()
    {
      public final void a(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(240740);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onDismiss exitType: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseScanUI.v(BaseScanUI.this);
        BaseScanUI.w(BaseScanUI.this);
        BaseScanUI.i(BaseScanUI.this).ua(true);
        BaseScanUI.s(BaseScanUI.this);
        BaseScanUI.e(BaseScanUI.this, true);
        af.Iz(System.currentTimeMillis());
        af.a(BaseScanUI.x(BaseScanUI.this), paramAnonymousInt, BaseScanUI.r(BaseScanUI.this));
        af.WE(12);
        AppMethodBeat.o(240740);
      }
      
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(240741);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onCancel");
        BaseScanUI.d(BaseScanUI.this, false);
        BaseScanUI.v(BaseScanUI.this);
        BaseScanUI.w(BaseScanUI.this);
        AppMethodBeat.o(240741);
      }
      
      public final void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(240739);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onShow");
        BaseScanUI.i(BaseScanUI.this).ua(false);
        BaseScanUI.e(BaseScanUI.this, false);
        af.Iy(System.currentTimeMillis());
        AppMethodBeat.o(240739);
      }
    };
    this.CJT = new p.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(240729);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240728);
            boolean bool = BaseScanUI.L(BaseScanUI.this);
            Log.i("MicroMsg.ScanUI", "onNetWorkChange %d, canResume: %b", new Object[] { Integer.valueOf(com.tencent.mm.kernel.g.azz().aYS()), Boolean.valueOf(bool) });
            Object localObject;
            int i;
            if (BaseScanUI.h(BaseScanUI.this) != null)
            {
              localObject = BaseScanUI.h(BaseScanUI.this);
              i = paramAnonymousInt;
              if ((com.tencent.mm.kernel.g.azz().aYS() != 6) && (com.tencent.mm.kernel.g.azz().aYS() != 4)) {
                break label198;
              }
              ((ScanUIRectView)localObject).CJv = true;
              if ((!r.Xd(((ScanUIRectView)localObject).mode)) && (bool)) {
                ((ScanUIRectView)localObject).onResume();
              }
            }
            for (;;)
            {
              if (((ScanUIRectView)localObject).CGD != null) {
                ((ScanUIRectView)localObject).CGD.onNetworkChange(i);
              }
              if (((ScanUIRectView)localObject).CGE != null)
              {
                localObject = ((ScanUIRectView)localObject).CGE;
                ((ScanSharedMaskView)localObject).eQC();
                ((ScanSharedMaskView)localObject).WY(((ScanSharedMaskView)localObject).CSG);
              }
              if ((com.tencent.mm.kernel.g.azz().aYS() != 6) && (com.tencent.mm.kernel.g.azz().aYS() != 4)) {
                break label248;
              }
              if (!BaseScanUI.M(BaseScanUI.this)) {
                break;
              }
              AppMethodBeat.o(240728);
              return;
              label198:
              ((ScanUIRectView)localObject).CJv = false;
              if (!r.Xd(((ScanUIRectView)localObject).mode)) {
                ((ScanUIRectView)localObject).onPause();
              }
            }
            BaseScanUI.j(BaseScanUI.this, true);
            BaseScanUI.N(BaseScanUI.this);
            AppMethodBeat.o(240728);
            return;
            label248:
            if (!BaseScanUI.M(BaseScanUI.this))
            {
              AppMethodBeat.o(240728);
              return;
            }
            BaseScanUI.j(BaseScanUI.this, false);
            BaseScanUI.N(BaseScanUI.this);
            AppMethodBeat.o(240728);
          }
        });
        AppMethodBeat.o(240729);
      }
    };
    this.CJU = new IListener() {};
    this.qCu = new BaseScanUI.15(this);
    AppMethodBeat.o(51728);
  }
  
  private void WN(int paramInt)
  {
    AppMethodBeat.i(51735);
    Log.i("MicroMsg.ScanUI", "alvinluo operateFlash operation: %d", new Object[] { Integer.valueOf(paramInt) });
    tj localtj = new tj();
    localtj.dZP.dDe = paramInt;
    EventCenter.instance.publish(localtj);
    if (this.CJh != null)
    {
      if (paramInt == 1)
      {
        this.CJh.eRm();
        AppMethodBeat.o(51735);
        return;
      }
      this.CJh.eRn();
    }
    AppMethodBeat.o(51735);
  }
  
  private void WO(int paramInt)
  {
    AppMethodBeat.i(240750);
    af.b(af.a(this.CJD), this.zTQ, this.CJD, paramInt);
    AppMethodBeat.o(240750);
  }
  
  private void ah(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(240748);
    Log.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance success: %b, isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.FALSE });
    Object localObject = this.CJK;
    long l;
    if (paramBoolean1)
    {
      l = 1L;
      ((nr)localObject).fij = l;
      this.CJK.fik = (System.currentTimeMillis() - this.CJs);
      localObject = this.CJK;
      if (!this.CJg.eQZ()) {
        break label369;
      }
      l = 0L;
      label83:
      ((nr)localObject).fil = l;
      this.CJK.fiq = this.zTQ;
      this.CJK.fim = com.tencent.qbar.c.RJE.RJH;
      if (j.CUb.eRV() > 0L) {
        this.CJK.fip = (j.CUb.eRV() - this.CJs);
      }
      this.CJK.bfK();
      if (r.Xd(this.zTQ))
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(1229L, 0L, 1L);
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        if (!paramBoolean1) {
          break label374;
        }
        l = 1L;
        label184:
        ((com.tencent.mm.plugin.report.service.h)localObject).n(1229L, 1L, l);
        if (paramBoolean1)
        {
          if (!this.CJg.eQZ()) {
            break label379;
          }
          com.tencent.mm.plugin.report.service.h.CyF.n(1229L, 5L, 1L);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.n(1229L, 7L, this.CJK.fik);
      com.tencent.mm.plugin.report.service.h.CyF.n(1229L, 9L, this.CJK.fim);
      if ((paramBoolean1) && (paramBoolean2))
      {
        Log.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance scanTime: %s, totalFrames: %d", new Object[] { Long.valueOf(this.CJK.fik), Long.valueOf(this.CJK.fim) });
        com.tencent.mm.plugin.report.service.h.CyF.n(1229L, 11L, 1L);
        com.tencent.mm.plugin.report.service.h.CyF.n(1229L, 12L, this.CJK.fik);
        com.tencent.mm.plugin.report.service.h.CyF.n(1229L, 14L, this.CJK.fim);
      }
      AppMethodBeat.o(240748);
      return;
      l = 0L;
      break;
      label369:
      l = 1L;
      break label83;
      label374:
      l = 0L;
      break label184;
      label379:
      com.tencent.mm.plugin.report.service.h.CyF.n(1229L, 3L, 1L);
    }
  }
  
  private void ai(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(51750);
    Log.v("MicroMsg.ScanUI", "alvinluo showFlash show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if ((this.CJh != null) && (!this.CJh.isShown()))
      {
        this.CJg.eRe();
        if (paramBoolean2) {
          this.CJh.show();
        }
        for (;;)
        {
          com.tencent.qbar.c.RJE.aqx(1);
          af.ia(this.zTQ, 1);
          AppMethodBeat.o(51750);
          return;
          this.CJh.setVisibility(0);
        }
      }
    }
    else if ((this.CJh != null) && (!this.CJh.VC))
    {
      this.CJg.eRf();
      if (paramBoolean2)
      {
        this.CJh.hide();
        AppMethodBeat.o(51750);
        return;
      }
      this.CJh.setVisibility(8);
    }
    AppMethodBeat.o(51750);
  }
  
  private void dzO()
  {
    AppMethodBeat.i(240744);
    this.CJk.setShowMoreButton(eQy());
    this.CJk.setOnMoreClickListener(new BaseScanUI.5(this));
    AppMethodBeat.o(240744);
  }
  
  private void eQA()
  {
    AppMethodBeat.i(51739);
    switch (this.zTQ)
    {
    default: 
      this.CJg.setScanCallback(null);
      AppMethodBeat.o(51739);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.CJg.setScanCallback(this.CJP);
      this.CJm = new com.tencent.mm.plugin.scanner.f.d(this.zTQ, this.CJz, this.CJg, this, this);
      AppMethodBeat.o(51739);
      return;
    case 12: 
      this.CJg.setScanCallback(this.CJQ);
      this.CJm = new com.tencent.mm.plugin.scanner.f.a(this.zTQ, this.CJg, this, this.CJR);
      AppMethodBeat.o(51739);
      return;
    }
    this.CJm = new ah(this);
    AppMethodBeat.o(51739);
  }
  
  private void eQB()
  {
    AppMethodBeat.i(169986);
    if (this.CJI != null)
    {
      this.CJI.a(this);
      if (this.CJg != null) {
        this.CJI.a(this.CJg.getScanMaskView(), this.CJg.getSharedMaskView(), this.CGF);
      }
    }
    AppMethodBeat.o(169986);
  }
  
  private void eQC()
  {
    AppMethodBeat.i(51748);
    if ((r.Xd(this.zTQ)) || (r.Xf(this.zTQ)) || (r.Xe(this.zTQ))) {}
    for (int i = 0; i != 0; i = 1)
    {
      tU(this.CJv);
      AppMethodBeat.o(51748);
      return;
    }
    tU(true);
    AppMethodBeat.o(51748);
  }
  
  private void eQD()
  {
    AppMethodBeat.i(169987);
    int i = 0;
    if (r.Xd(this.zTQ)) {
      i = com.tencent.qbar.c.RJB;
    }
    for (;;)
    {
      com.tencent.qbar.c.RJE.setTabType(i);
      AppMethodBeat.o(169987);
      return;
      if (this.zTQ == 12) {
        i = com.tencent.qbar.c.RJC;
      } else if (this.zTQ == 3) {
        i = com.tencent.qbar.c.RJD;
      }
    }
  }
  
  private void eQE()
  {
    AppMethodBeat.i(51757);
    Log.i("MicroMsg.ScanUI", "alvinluo resumeScan");
    this.CJs = System.currentTimeMillis();
    this.CJF = false;
    if (this.CJg != null) {
      this.CJg.onResume();
    }
    setEnableSwitchTab(true);
    AppMethodBeat.o(51757);
  }
  
  private void eQv()
  {
    AppMethodBeat.i(51732);
    ScanSharedMaskView localScanSharedMaskView = this.CJg.getSharedMaskView();
    if (localScanSharedMaskView == null)
    {
      AppMethodBeat.o(51732);
      return;
    }
    if (!this.CAH)
    {
      localScanSharedMaskView.getGalleryButton().setVisibility(0);
      localScanSharedMaskView.setOnGalleryClickListener(new BaseScanUI.31(this));
      AppMethodBeat.o(51732);
      return;
    }
    localScanSharedMaskView.getGalleryButton().setVisibility(8);
    AppMethodBeat.o(51732);
  }
  
  private void eQw()
  {
    AppMethodBeat.i(51734);
    ScanSharedMaskView localScanSharedMaskView = this.CJg.getSharedMaskView();
    if (localScanSharedMaskView != null) {
      this.CJh = localScanSharedMaskView.getFlashSwitcherView();
    }
    if (this.CJh != null)
    {
      this.CJh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(240717);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.qbar.c.RJE.aqx(2);
          if (!BaseScanUI.f(BaseScanUI.this).VC) {
            BaseScanUI.a(BaseScanUI.this, 1);
          }
          for (;;)
          {
            af.ia(BaseScanUI.b(BaseScanUI.this), 2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240717);
            return;
            BaseScanUI.a(BaseScanUI.this, 2);
          }
        }
      });
      this.CJg.setFlashStatus(this.CJh.ddZ);
      if (r.Xf(this.zTQ))
      {
        eQx();
        this.CJh.hide();
      }
    }
    AppMethodBeat.o(51734);
  }
  
  private void eQx()
  {
    AppMethodBeat.i(51736);
    Log.d("MicroMsg.ScanUI", "alvinluo checkAndOperateFlash operation: %d", new Object[] { Integer.valueOf(2) });
    if (this.CJh.VC) {
      WN(2);
    }
    AppMethodBeat.o(51736);
  }
  
  private boolean eQy()
  {
    AppMethodBeat.i(240745);
    if (((r.Xd(this.zTQ)) || (r.Xe(this.zTQ)) || (r.Xf(this.zTQ))) && (!this.CAI) && (!this.CJE))
    {
      AppMethodBeat.o(240745);
      return true;
    }
    AppMethodBeat.o(240745);
    return false;
  }
  
  private boolean eQz()
  {
    AppMethodBeat.i(240746);
    Log.i("MicroMsg.ScanUI", "alvinluo processCancel isShowingMultiCodeResult: %b, infoViewType: %d", new Object[] { Boolean.valueOf(this.CJN), Integer.valueOf(this.CJI.CGI) });
    ScanUITopOpButtonComponent localScanUITopOpButtonComponent = this.CJk;
    AnimatorListenerAdapter local8 = new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(240722);
        BaseScanUI.s(BaseScanUI.this);
        AppMethodBeat.o(240722);
      }
    };
    TextView localTextView = localScanUITopOpButtonComponent.CPg;
    if (localTextView == null) {
      kotlin.g.b.p.btv("cancelButton");
    }
    if (localTextView.getVisibility() == 0)
    {
      localScanUITopOpButtonComponent.tZ(true);
      localScanUITopOpButtonComponent.b(false, (Animator.AnimatorListener)local8);
    }
    for (boolean bool = true;; bool = false)
    {
      tS(true);
      if ((r.Xd(this.zTQ)) && (this.CJN))
      {
        this.CJN = false;
        af.ib(3, -1);
        af.eQm();
      }
      if ((r.Xd(this.zTQ)) && (this.CJI != null) && (this.CJI.CGI == 3)) {
        af.ic(5, this.zTQ);
      }
      AppMethodBeat.o(240746);
      return bool;
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
  
  private void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240747);
    Log.v("MicroMsg.ScanUI", "alvinluo reportSwitchTab %b", new Object[] { Boolean.valueOf(this.CJt) });
    af.hZ(paramInt1, paramInt2);
    af.Wy(paramInt1);
    af.WA(paramInt1);
    af.WE(paramInt1);
    AppMethodBeat.o(240747);
  }
  
  private void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51733);
    Log.i("MicroMsg.ScanUI", "alvinluo setEnableSwitchTab enable: %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.CJp) });
    if (this.CJn != null)
    {
      if (!paramBoolean) {
        break label95;
      }
      if (this.CJp) {
        this.CJn.setEnableSwitchTab(true);
      }
    }
    while (this.CJg != null) {
      if (paramBoolean)
      {
        if (this.CJp)
        {
          this.CJg.setEnableScrollSwitchTab(true);
          AppMethodBeat.o(51733);
          return;
          label95:
          this.CJn.setEnableSwitchTab(false);
        }
      }
      else {
        this.CJg.setEnableScrollSwitchTab(false);
      }
    }
    AppMethodBeat.o(51733);
  }
  
  private void tR(boolean paramBoolean)
  {
    AppMethodBeat.i(51731);
    if ((!paramBoolean) && (!ao.isDarkMode()))
    {
      getController().setNavigationbarColor(getContext().getResources().getColor(2131099649));
      AppMethodBeat.o(51731);
      return;
    }
    getController().setNavigationbarColor(getResources().getColor(2131101035));
    AppMethodBeat.o(51731);
  }
  
  private void tS(boolean paramBoolean)
  {
    AppMethodBeat.i(240743);
    if (this.CJn != null)
    {
      Object localObject = this.CJn;
      Log.i("MicroMsg.ScanScrollTabController", "alvinluo setEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).setEnableSwitchTab(paramBoolean);
      localObject = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).CSp;
      if (localObject != null)
      {
        ((ScanScrollTabView)localObject).setEnabled(paramBoolean);
        AppMethodBeat.o(240743);
        return;
      }
    }
    AppMethodBeat.o(240743);
  }
  
  private void tT(boolean paramBoolean)
  {
    AppMethodBeat.i(51747);
    if (paramBoolean)
    {
      this.CJi.setVisibility(0);
      this.CJg.cWj();
      this.CJi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(240727);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          BaseScanUI.K(BaseScanUI.this);
          BaseScanUI.i(BaseScanUI.this, false);
          BaseScanUI.s(BaseScanUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(240727);
        }
      });
      if (this.CJg != null) {
        this.CJg.tW(true);
      }
      this.CJk.tZ(false);
      ai(false, true);
      AppMethodBeat.o(51747);
      return;
    }
    this.CJi.setVisibility(8);
    if (this.CJg != null) {
      this.CJg.tW(false);
    }
    this.CJk.tZ(true);
    AppMethodBeat.o(51747);
  }
  
  private void tU(boolean paramBoolean)
  {
    AppMethodBeat.i(51749);
    Log.i("MicroMsg.ScanUI", "network change %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      tT(false);
      this.CJg.cWj();
    }
    AppMethodBeat.o(51749);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, c.a parama)
  {
    AppMethodBeat.i(51746);
    if ((this.CJI != null) && (this.CJI.CGG)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScanUI", "alvinluo showLoadingView show: %b, isLoadingShow: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2) });
      this.CJF = paramBoolean1;
      if (this.CJI != null)
      {
        this.CJI.CGH = parama;
        if (this.CJI.CGG != paramBoolean1)
        {
          this.CJI.ag(paramBoolean1, paramBoolean2);
          if (paramBoolean1)
          {
            this.CJk.tZ(false);
            this.CJk.b(false, null);
          }
        }
      }
      AppMethodBeat.o(51746);
      return;
    }
  }
  
  public final void cvn()
  {
    AppMethodBeat.i(51743);
    Log.i("MicroMsg.ScanUI", "finishUI");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(51743);
  }
  
  public final void ePO()
  {
    AppMethodBeat.i(240752);
    if (this.CJI != null)
    {
      ad localad = this.CJI;
      ScanInfoMaskView localScanInfoMaskView = localad.CGF;
      if (localScanInfoMaskView != null)
      {
        localScanInfoMaskView.getVisibility();
        localScanInfoMaskView.setVisibility(8);
        localScanInfoMaskView.CSf = true;
      }
      localad.CGI = 0;
    }
    AppMethodBeat.o(240752);
  }
  
  public final void ePP()
  {
    AppMethodBeat.i(240751);
    tS(true);
    this.CJF = false;
    if (this.CJI != null)
    {
      this.CJk.b(false, null);
      if (this.CGE != null) {
        this.CGE.f(true, null);
      }
      Object localObject = this.CJI;
      AnimatorListenerAdapter local25 = new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(240735);
          super.onAnimationEnd(paramAnonymousAnimator);
          BaseScanUI.T(BaseScanUI.this).ii(this.val$mode, 4);
          AppMethodBeat.o(240735);
        }
      };
      localObject = ((ad)localObject).CGF;
      if (localObject != null)
      {
        View localView = ((ScanInfoMaskView)localObject).BCP;
        if (localView == null) {
          kotlin.g.b.p.btv("infoLayout");
        }
        if (localView.getVisibility() == 0)
        {
          localView = ((ScanInfoMaskView)localObject).xcd;
          if (localView == null) {
            kotlin.g.b.p.btv("loadingLayout");
          }
          localView.setVisibility(8);
          localObject = ((ScanInfoMaskView)localObject).BCP;
          if (localObject == null) {
            kotlin.g.b.p.btv("infoLayout");
          }
          ScanInfoMaskView.a((View)localObject, local25);
        }
      }
      com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240737);
          if ((!BaseScanUI.I(BaseScanUI.this)) || (BaseScanUI.H(BaseScanUI.this) == null))
          {
            BaseScanUI.U(BaseScanUI.this);
            AppMethodBeat.o(240737);
            return;
          }
          BaseScanUI.f(BaseScanUI.this, false);
          BaseScanUI.H(BaseScanUI.this).f(false, new AnimatorListenerAdapter()
          {
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(240736);
              super.onAnimationEnd(paramAnonymous2Animator);
              BaseScanUI.U(BaseScanUI.this);
              AppMethodBeat.o(240736);
            }
          });
          AppMethodBeat.o(240737);
        }
      }, 1000L);
    }
    AppMethodBeat.o(240751);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496157;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51730);
    this.container = ((FrameLayout)findViewById(2131307238));
    this.CJn = new com.tencent.mm.plugin.scanner.ui.widget.b(this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.compatible.util.d.oD(19))
    {
      getWindow().addFlags(67109888);
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.CJi = findViewById(2131307248);
      this.CGF = ((ScanInfoMaskView)findViewById(2131307242));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(169983);
          BaseScanUI.y(BaseScanUI.this);
          AppMethodBeat.o(169983);
          return true;
        }
      });
      this.CJk = ((ScanUITopOpButtonComponent)findViewById(2131309308));
      this.CJg = new ScanUIRectView(this);
      this.CJg.CNn = this;
      this.CJg.setScanRequest(this.CJD);
      this.CJg.setEnableScanGoodsDynamicWording(this.CJO);
      localObject2 = (ScanScrollTabView)findViewById(2131307260);
      localObject1 = this.CJn;
      kotlin.g.b.p.h(localObject2, "scrollTabView");
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).CSp = ((ScanScrollTabView)localObject2);
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).CSp;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).removeAllTabs();
      }
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).CSp;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)new b.c());
      }
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).CSq.clear();
      localObject2 = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).CSr).iterator();
      int i = 0;
      label256:
      if (!((Iterator)localObject2).hasNext()) {
        break label305;
      }
      if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).a(i, (b.b)((Iterator)localObject2).next())) {
        break label942;
      }
      i += 1;
    }
    label900:
    label942:
    for (;;)
    {
      break label256;
      getWindow().setFlags(1024, 1024);
      break;
      label305:
      localObject1 = this.CJn;
      localObject2 = new com.tencent.mm.plugin.scanner.ui.widget.e()
      {
        public final void WQ(int paramAnonymousInt)
        {
          AppMethodBeat.i(240724);
          Log.i("MicroMsg.ScanUI", "alvinluo onTabUnSelected tabId: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (r.Xd(paramAnonymousInt)) {
            BaseScanUI.g(BaseScanUI.this, false);
          }
          BaseScanUI.WP(paramAnonymousInt);
          if (paramAnonymousInt == 12) {
            BaseScanUI.eQF();
          }
          AppMethodBeat.o(240724);
        }
        
        public final void jdMethod_if(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(240723);
          Log.i("MicroMsg.ScanUI", "alvinluo onTabSelected tabId: %d, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 12) && (!WeChatBrands.Business.Entries.DiscoveryScanRecognize.checkAvailable(BaseScanUI.this.getContext())))
          {
            BaseScanUI.this.cvn();
            AppMethodBeat.o(240723);
            return;
          }
          if ((paramAnonymousInt1 == 3) && (!WeChatBrands.Business.Entries.DiscoveryScanTranslate.checkAvailable(BaseScanUI.this.getContext())))
          {
            BaseScanUI.this.cvn();
            AppMethodBeat.o(240723);
            return;
          }
          if (!BaseScanUI.E(BaseScanUI.this))
          {
            BaseScanUI.a(BaseScanUI.this, paramAnonymousInt1, paramAnonymousInt2);
            if (BaseScanUI.b(BaseScanUI.this) != paramAnonymousInt1)
            {
              if ((paramAnonymousInt1 != 12) || (paramAnonymousInt2 != 4)) {
                break label299;
              }
              af.ic(7, paramAnonymousInt1);
              BaseScanUI.b(BaseScanUI.this, 3);
              BaseScanUI.f(BaseScanUI.this, true);
              BaseScanUI.G(BaseScanUI.this);
              if (BaseScanUI.H(BaseScanUI.this) != null)
              {
                BaseScanUI.H(BaseScanUI.this).setShowToast(true);
                BaseScanUI.H(BaseScanUI.this).setScanToast(BaseScanUI.this.getResources().getString(2131764891));
              }
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.ScanUI", "alvinluo onTabSelected scanGoodsScene: %d, needAnimateHideBlurBackground: %b", new Object[] { Integer.valueOf(BaseScanUI.x(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.I(BaseScanUI.this)) });
            BaseScanUI.c(BaseScanUI.this, paramAnonymousInt1);
            if (r.Xd(paramAnonymousInt1)) {
              BaseScanUI.g(BaseScanUI.this, true);
            }
            BaseScanUI.J(BaseScanUI.this);
            AppMethodBeat.o(240723);
            return;
            BaseScanUI.F(BaseScanUI.this);
            break;
            label299:
            BaseScanUI.b(BaseScanUI.this, af.a(BaseScanUI.r(BaseScanUI.this)));
            BaseScanUI.f(BaseScanUI.this, false);
            if (BaseScanUI.H(BaseScanUI.this) != null) {
              BaseScanUI.H(BaseScanUI.this).setShowToast(false);
            }
          }
        }
      };
      kotlin.g.b.p.h(localObject2, "tabOnSelectedListener");
      localObject2 = new b.d((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1, (com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).CSp;
      if (localObject1 != null) {
        ((ScanScrollTabView)localObject1).setOnTabChangedListener((com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      }
      localObject2 = this.CJn;
      localObject1 = new BaseScanUI.10(this);
      kotlin.g.b.p.h(localObject1, "tabOnScrollListener");
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).CSp;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)localObject1);
      }
      if (this.CJg != null) {
        this.CJg.setScrollTabController(this.CJn);
      }
      if ((this.CJA) || (this.zTQ == 8))
      {
        this.CJC = true;
        if (this.CJD != null)
        {
          if (this.CJD.CAE) {
            this.CJC = true;
          }
          if (this.CJD.CAH) {
            this.CAH = true;
          }
          if (this.CJD.CAI) {
            this.CAI = true;
          }
        }
        if (!this.CJC) {
          break label900;
        }
        localObject1 = this.CJn.CSp;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(8);
        }
        this.CJp = false;
        this.CJg.setBottomExtraHeight(0);
      }
      for (;;)
      {
        setEnableSwitchTab(this.CJp);
        Log.i("MicroMsg.ScanUI", "alvinluo initView currentMode: %d, showOnlyScanCode: %b, hideScrollTab: %b, scanRequest: %s", new Object[] { Integer.valueOf(this.zTQ), Boolean.valueOf(this.CJA), Boolean.valueOf(this.CJC), this.CJD });
        this.CJg.setActivity(this);
        this.container.addView(this.CJg, 0, new FrameLayout.LayoutParams(-1, -1));
        this.CJg.onCreate();
        this.CJg.setShowScanTips(this.CJu);
        this.CJg.setNetworkAvailable(this.CJv);
        this.CJg.setScanMode(this.zTQ);
        this.CJg.refreshView();
        this.CGE = this.CJg.getSharedMaskView();
        ie(this.zTQ, 0);
        eQB();
        af.WE(this.zTQ);
        eQD();
        if (this.CJx) {
          this.CJg.setBlackInterval(com.tencent.qbar.b.hkf());
        }
        eQv();
        eQA();
        if ((this.CJy != null) && (this.CJy.length > 0)) {
          this.CJg.setScanCodeReaders(this.CJy);
        }
        if (this.CJE) {
          this.CJg.setMyQrCodeVisible(false);
        }
        this.CJn.ii(this.zTQ, 0);
        eQw();
        this.CJk.setOnCloseClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(240720);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            BaseScanUI.eQF();
            BaseScanUI.e(BaseScanUI.this);
            BaseScanUI.y(BaseScanUI.this);
            af.ib(3, -1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240720);
          }
        });
        this.CJk.setOnCancelClickListener(new BaseScanUI.7(this));
        dzO();
        AppMethodBeat.o(51730);
        return;
        if (!com.tencent.mm.aw.b.bdG()) {
          break;
        }
        if (r.eSd())
        {
          localObject1 = new ArrayList();
          ((List)localObject1).add(Integer.valueOf(1));
          if (!WeChatBrands.Business.Entries.DiscoveryScanRecognize.restricted()) {
            ((List)localObject1).add(Integer.valueOf(12));
          }
          if (!WeChatBrands.Business.Entries.DiscoveryScanTranslate.restricted()) {
            ((List)localObject1).add(Integer.valueOf(3));
          }
          this.CJn.gE((List)localObject1);
          break;
        }
        this.CJC = true;
        break;
        localObject1 = this.CJn.CSp;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(0);
        }
        this.CJg.setBottomExtraHeight(getResources().getDimensionPixelSize(2131166892));
        this.CJp = true;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(51756);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    final long l1;
    boolean bool;
    label200:
    Object localObject1;
    label269:
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
          af.WI(this.zTQ);
          paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.aSY());
          Log.i("MicroMsg.ScanUI", "select: [%s]", new Object[] { paramIntent });
          if (!Util.isNullOrNil(paramIntent))
          {
            l1 = System.currentTimeMillis();
            com.tencent.qbar.c.RJF.aqw(com.tencent.qbar.c.RJz);
            com.tencent.qbar.e.hki().a(this, l1, paramIntent, new e.b()
            {
              public final void a(final long paramAnonymousLong, e.d paramAnonymousd)
              {
                final List localList2 = null;
                AppMethodBeat.i(240733);
                if (paramAnonymousd != null) {}
                for (final List localList1 = paramAnonymousd.CGY;; localList1 = null)
                {
                  if (paramAnonymousd != null) {
                    localList2 = paramAnonymousd.RKk;
                  }
                  if ((paramAnonymousLong == l1) && (BaseScanUI.S(BaseScanUI.this))) {
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(240732);
                        BaseScanUI.d(BaseScanUI.this, false);
                        Bundle localBundle;
                        Object localObject;
                        if ((localList1 != null) && (!localList1.isEmpty()))
                        {
                          localBundle = new Bundle();
                          localBundle.putString("result_content", ((com.tencent.qbar.a.a)localList1.get(0)).data);
                          localBundle.putInt("result_code_format", ((com.tencent.qbar.a.a)localList1.get(0)).typeID);
                          localBundle.putString("result_code_name", ((com.tencent.qbar.a.a)localList1.get(0)).typeName);
                          localObject = ((com.tencent.qbar.a.a)localList1.get(0)).rawData;
                          if (localObject != null) {
                            localBundle.putByteArray("result_raw_data", (byte[])localObject);
                          }
                          if ((localList2 == null) || (localList2.isEmpty())) {
                            break label392;
                          }
                        }
                        label392:
                        for (int i = ((WxQbarNative.QBarReportMsg)localList2.get(0)).qrcodeVersion;; i = 0)
                        {
                          localBundle.putInt("result_code_version", i);
                          af.a(BaseScanUI.b(BaseScanUI.this), true, 2, 1);
                          if (BaseScanUI.g(BaseScanUI.this))
                          {
                            localObject = new Intent();
                            ((Intent)localObject).putExtra("key_scan_result", localBundle.getString("result_content"));
                            ((Intent)localObject).putExtra("key_scan_result_raw", localBundle.getByteArray("result_raw_data"));
                            ((Intent)localObject).putExtra("key_scan_result_code_name", localBundle.getString("result_code_name"));
                            ((Intent)localObject).putExtra("key_scan_result_code_version", i);
                            BaseScanUI.this.setResult(-1, (Intent)localObject);
                            BaseScanUI.this.cvn();
                            AppMethodBeat.o(240732);
                            return;
                          }
                          localBundle.putInt("qbar_string_scan_source", 1);
                          if (BaseScanUI.c(BaseScanUI.this) != null) {
                            BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, localBundle);
                          }
                          BaseScanUI.m(BaseScanUI.this);
                          AppMethodBeat.o(240732);
                          return;
                          BaseScanUI.d(BaseScanUI.this, true);
                          BaseScanUI.i(BaseScanUI.this, true);
                          af.a(BaseScanUI.b(BaseScanUI.this), false, 2, 1);
                          AppMethodBeat.o(240732);
                          return;
                        }
                      }
                    });
                  }
                  AppMethodBeat.o(240733);
                  return;
                }
              }
            }, this.CJy);
          }
          AppMethodBeat.o(51756);
          return;
        }
        eQE();
      } while ((paramInt2 != 0) || (!r.Xd(this.zTQ)));
      af.WH(this.zTQ);
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
          break label541;
        }
        af.WI(this.zTQ);
        af.aE(2, System.currentTimeMillis());
        localObject1 = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.aSY());
        l1 = System.currentTimeMillis();
        if (paramIntent != null) {
          break label535;
        }
        bool = true;
        Log.d("MicroMsg.ScanUI", "alvinluo processGoodsImage session: %d, resultCode: %d, filePath: %s, data == null: %b", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt2), localObject1, Boolean.valueOf(bool) });
        if (this.CJg != null) {
          this.CJg.setScanSource(2);
        }
        paramInt1 = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject1);
        l2 = System.currentTimeMillis();
        paramIntent = BitmapUtil.decodeFileWithSample((String)localObject1);
        l3 = System.currentTimeMillis();
        if ((paramInt1 != 90) && (paramInt1 != 270)) {
          break label632;
        }
        paramIntent = BitmapUtil.rotate(paramIntent, paramInt1);
      }
      break;
    }
    label535:
    label541:
    label632:
    for (;;)
    {
      Log.i("MicroMsg.ScanUI", "alvinluo processGoodsImage decode image cost: %d", new Object[] { Long.valueOf(l3 - l2) });
      if ((paramIntent != null) && (!paramIntent.isRecycled()))
      {
        localObject2 = this.CJg.getScanMaskView();
        if ((localObject2 instanceof ScanGoodsMaskView))
        {
          localObject2 = (ScanGoodsMaskView)localObject2;
          ((ScanGoodsMaskView)localObject2).CQh = true;
          ((ScanGoodsMaskView)localObject2).CQi = false;
          ((ScanGoodsMaskView)localObject2).ap(paramIntent);
        }
      }
      this.CJj = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(240734);
          Log.i("MicroMsg.ScanUI", "alvinluo processGoodsImage onCancel and resumeScan");
          if ((BaseScanUI.c(BaseScanUI.this) instanceof com.tencent.mm.plugin.scanner.f.a))
          {
            paramAnonymousDialogInterface = (com.tencent.mm.plugin.scanner.f.a)BaseScanUI.c(BaseScanUI.this);
            long l = l1;
            paramAnonymousDialogInterface.CAV = null;
            com.tencent.mm.plugin.scanner.model.d locald = paramAnonymousDialogInterface.CIO;
            if (locald != null) {
              locald.Ix(l);
            }
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.CIN;
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.Ix(l);
            }
          }
          af.a(2, false, System.currentTimeMillis(), true);
          BaseScanUI.s(BaseScanUI.this);
          AppMethodBeat.o(240734);
        }
      };
      if (this.CJg != null) {
        this.CJg.b(true, this.CJj);
      }
      paramIntent = com.tencent.mm.plugin.scanner.d.a.ePJ();
      Object localObject2 = this.CJQ;
      Log.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask filePath: %s", new Object[] { localObject1 });
      x.a(new a.2(paramIntent, (String)localObject1, (a.c)localObject2, l1));
      AppMethodBeat.o(51756);
      return;
      bool = false;
      break label200;
      bool = false;
      break label269;
      eQE();
      if (paramInt2 == 0) {
        af.WH(12);
      }
      AppMethodBeat.o(51756);
      return;
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.aSY());
      Log.i("MicroMsg.ScanUI", "alvinluo scanTranslate select image: [%s]", new Object[] { paramIntent });
      if (this.CJm == null) {
        break;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key_translate_file_path", paramIntent);
      this.CJm.c(System.currentTimeMillis(), (Bundle)localObject1);
      break;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(51741);
    Log.v("MicroMsg.ScanUI", "alvinluo onBackPressed");
    if ((this.CIq != null) && (this.CIq.isShowingDialog()))
    {
      this.CIq.dismiss();
      AppMethodBeat.o(51741);
      return;
    }
    if ((this.CJI == null) || (!this.CJI.CGG)) {}
    for (int i = 0; i != 0; i = 1)
    {
      if (eQz()) {
        break label166;
      }
      eQE();
      AppMethodBeat.o(51741);
      return;
      Log.i("MicroMsg.ScanUI", "alvinluo cancelLoading");
      ad localad = this.CJI;
      c.a locala = localad.CGH;
      if (locala != null) {
        locala.eRN();
      }
      localad.CGH = null;
      this.CJI.ag(false, false);
    }
    if (!eQz())
    {
      if (this.zTQ == 12) {
        af.tO(false);
      }
      af.WF(this.zTQ);
      goBack();
    }
    label166:
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
    tR(true);
    if ((com.tencent.mm.kernel.g.azz().aYS() == 6) || (com.tencent.mm.kernel.g.azz().aYS() == 4))
    {
      this.CJv = true;
      this.paT = ((Vibrator)getSystemService("vibrator"));
      this.CJy = getIntent().getIntArrayExtra("key_support_scan_code_type");
      this.CJz = getIntent().getIntExtra("key_scan_entry_scene", 0);
      this.CJA = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
      this.CJB = getIntent().getBooleanExtra("key_set_result_after_scan", false);
      this.CAI = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
      this.zTQ = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
      this.CJu = getIntent().getBooleanExtra("key_show_scan_tips", true);
      this.CJx = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.CJM = getIntent().getBooleanExtra("key_enable_multi_code", false);
      this.CJO = getIntent().getBooleanExtra("key_scan_goods_enable_dynamic_wording", false);
      this.CJE = getIntent().getBooleanExtra("key_for_jsapi_use", false);
      this.CAH = this.CAI;
      if (r.Xe(this.zTQ))
      {
        this.CJD = ((BaseScanRequest)getIntent().getParcelableExtra("key_scan_request"));
        this.CJl = af.a(this.CJD);
      }
      com.tencent.qbar.b.hke();
      com.tencent.qbar.f.hkl();
      r.eSe();
      com.tencent.mm.plugin.scanner.util.d.init();
      bool = r.eSh();
      Log.i("MicroMsg.ScanUI", "alvinluo initEnableMultiCode configEnableMultiCode: %b, entryEnableMultiCode: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.CJM) });
      paramBundle = com.tencent.qbar.h.hkp();
      if ((!bool) || (!this.CJM)) {
        break label455;
      }
    }
    label455:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.CJM = bool;
      com.tencent.qbar.f.DN(bool);
      initView();
      this.CJs = System.currentTimeMillis();
      EventCenter.instance.addListener(this.qCu);
      com.tencent.mm.cr.d.hiy();
      af.eQg();
      WO(1);
      w.ePT();
      paramBundle = SecDataUIC.CWq;
      paramBundle = (chc)SecDataUIC.a.b(this, 3, chc.class);
      if ((paramBundle != null) && ("launch_type_scan_qrcode".equals(paramBundle.Mmm)))
      {
        paramBundle = new ks();
        paramBundle.elF = 2L;
        paramBundle.eXj = 1L;
        paramBundle.bfK();
        com.tencent.mm.util.b localb = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a(paramBundle);
      }
      AppMethodBeat.o(51729);
      return;
      this.CJv = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51755);
    Log.i("MicroMsg.ScanUI", "onDestroy()");
    super.onDestroy();
    EventCenter.instance.removeListener(this.qCu);
    if (this.CJm != null)
    {
      this.CJm.destroy();
      this.CJm = null;
    }
    if (this.CJg != null) {
      this.CJg.onDestroy();
    }
    if ((this.CIq != null) && (this.CIq.isShowingDialog())) {
      this.CIq.dismiss();
    }
    if ((this.nVN != null) && (this.nVN.isShowing())) {
      this.nVN.bMo();
    }
    if (this.uzs != null) {
      this.uzs.c(this.qgt);
    }
    WO(2);
    AppMethodBeat.o(51755);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51753);
    super.onPause();
    Log.i("MicroMsg.ScanUI", "alvinluo onPause needPauseScan: %b", new Object[] { Boolean.valueOf(this.CJF) });
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.CJg != null)
    {
      this.CJg.onPause();
      if (this.CJF) {
        this.CJg.stopPreview();
      }
    }
    if (this.CJK.fij == 0L) {
      ah(false, false);
    }
    com.tencent.qbar.c.RJE.bUV();
    Object localObject = j.CUb;
    Log.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (((j)localObject).mSensorManager != null)
    {
      Log.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      ((j)localObject).mSensorManager.unregisterListener((SensorEventListener)localObject);
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.CIq != null)
    {
      localObject = this.CIq.CCE;
      if (localObject != null)
      {
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onPause set canMeasured false");
        ((BaseBoxDialogView)localObject).CBC = false;
        AppMethodBeat.o(51753);
        return;
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
        this.CJq = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new BaseScanUI.18(this), new BaseScanUI.19(this));
        AppMethodBeat.o(51752);
        return;
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
        {
          this.CJr = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131755761), false, new BaseScanUI.20(this), new BaseScanUI.21(this));
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51751);
    super.onResume();
    Log.i("MicroMsg.ScanUI", "alvinluo BaseScanUI onResume needPauseScan: %b", new Object[] { Boolean.valueOf(this.CJF) });
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    Object localObject = j.CUb;
    Log.i("MicroMsg.ScanStableDetector", "start detect scan stable");
    if (((j)localObject).mSensorManager != null)
    {
      ((j)localObject).CTZ = 0;
      ((j)localObject).CTY[0] = 0.0F;
      ((j)localObject).CTY[1] = 0.0F;
      ((j)localObject).CTY[2] = 0.0F;
      Log.i("MicroMsg.ScanStableDetector", "register accelerate listener");
      ((j)localObject).mSensorManager.registerListener((SensorEventListener)localObject, ((j)localObject).CTX, 50000);
    }
    Log.i("MicroMsg.ScanUI", "should check camera %s, location %s", new Object[] { Boolean.valueOf(this.CJq), Boolean.valueOf(this.CJr) });
    boolean bool;
    int i;
    if ((this.CJq) || (this.CJr)) {
      if (this.CJq)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
        Log.i("MicroMsg.ScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          this.CGP = false;
          i = 0;
          if (i != 0)
          {
            af.tP(this.CGP);
            if (com.tencent.mm.compatible.e.b.apj()) {
              break label368;
            }
            com.tencent.mm.ui.base.h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new BaseScanUI.16(this), new BaseScanUI.17(this));
          }
        }
      }
    }
    for (;;)
    {
      getWindow().addFlags(128);
      if (this.CIq == null) {
        break label446;
      }
      localObject = this.CIq.CCE;
      if (localObject == null) {
        break label446;
      }
      ((BaseBoxDialogView)localObject).CBC = true;
      AppMethodBeat.o(51751);
      return;
      if (this.CJr)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 76, null, null);
        Log.i("MicroMsg.ScanUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      label368:
      Log.i("MicroMsg.ScanUI", "alvinluo onResumeAfterChkPermission needPauseScan: %b", new Object[] { Boolean.valueOf(this.CJF) });
      if (!this.CJF)
      {
        this.CJg.onResume();
        this.CJk.tZ(true);
        tS(true);
      }
      com.tencent.mm.kernel.g.aAg().a(this.CJT);
      eQC();
      EventCenter.instance.addListener(this.CJU);
    }
    label446:
    AppMethodBeat.o(51751);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(51754);
    super.onStop();
    if (this.CJg != null) {
      this.CJg.onStop();
    }
    this.CJh.eRn();
    com.tencent.mm.kernel.g.aAg().b(this.CJT);
    EventCenter.instance.removeListener(this.CJU);
    getWindow().clearFlags(128);
    AppMethodBeat.o(51754);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(240749);
    Log.i("MicroMsg.ScanUI", "alvinluo showInfoView type: %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    boolean bool;
    label96:
    int i;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
    {
      if (this.CGE != null)
      {
        this.CGE.CSH = this.CJg.getTextrueView();
        localObject1 = this.CGE;
        if (paramInt != 3) {
          break label564;
        }
        bool = true;
        ((ScanSharedMaskView)localObject1).setAnimateBackgroundView(bool);
      }
      this.CJF = true;
      if (paramInt != 3) {
        break label570;
      }
      bool = true;
      this.CJk.tZ(false);
      this.CJk.b(bool, null);
      if (this.CJI != null)
      {
        Object localObject2 = this.CJI;
        kotlin.g.b.p.h(this, "context");
        localObject1 = ((ad)localObject2).CGD;
        if (localObject1 == null) {
          break label576;
        }
        localObject1 = ((BaseScanMaskView)localObject1).getTargetSuccessMarkView();
        label153:
        Object localObject3 = ((ad)localObject2).CGF;
        if (localObject3 != null) {
          ((ScanInfoMaskView)localObject3).setAnchorView((View)localObject1);
        }
        localObject1 = ((ad)localObject2).CGE;
        if (localObject1 != null)
        {
          localObject1 = ((ScanSharedMaskView)localObject1).contentLayout;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("contentLayout");
          }
          m.a((View)localObject1, 0.0F, 1.0F, 200L, null);
        }
        localObject1 = ((ad)localObject2).CGD;
        if (localObject1 != null) {
          ((BaseScanMaskView)localObject1).eRz();
        }
        localObject1 = ((ad)localObject2).b(this, paramInt, paramBundle);
        ((ad)localObject2).CGI = paramInt;
        paramBundle = ((ad)localObject2).CGF;
        if (paramBundle != null)
        {
          kotlin.g.b.p.h(localObject1, "viewParams");
          bool = ((com.tencent.mm.plugin.scanner.view.a.a)localObject1).mVp;
          Log.i("MicroMsg.ScanInfoMaskView", "alvinluo showInfoView needTranslateInfoIcon: %b, showTips: %b, title: %s, subTitle: %s", new Object[] { Boolean.valueOf(paramBundle.CSf), Boolean.valueOf(bool), ((com.tencent.mm.plugin.scanner.view.a.a)localObject1).title, ((com.tencent.mm.plugin.scanner.view.a.a)localObject1).pWf });
          localObject2 = paramBundle.BCP;
          if (localObject2 == null) {
            kotlin.g.b.p.btv("infoLayout");
          }
          localObject3 = (TextView)((View)localObject2).findViewById(2131307259);
          if (localObject3 != null) {
            ((TextView)localObject3).setText((CharSequence)((com.tencent.mm.plugin.scanner.view.a.a)localObject1).title);
          }
          localObject2 = (TextView)((View)localObject2).findViewById(2131307258);
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText((CharSequence)((com.tencent.mm.plugin.scanner.view.a.a)localObject1).pWf);
            if (!((com.tencent.mm.plugin.scanner.view.a.a)localObject1).mVp) {
              break label582;
            }
            i = 0;
            label410:
            ((TextView)localObject2).setVisibility(i);
          }
          localObject2 = paramBundle.jBH;
          if (localObject2 == null) {
            kotlin.g.b.p.btv("infoIcon");
          }
          ((ImageView)localObject2).setImageResource(((com.tencent.mm.plugin.scanner.view.a.a)localObject1).CUX);
          localObject2 = paramBundle.CRU;
          if (localObject2 == null) {
            kotlin.g.b.p.btv("opButton");
          }
          if (!((com.tencent.mm.plugin.scanner.view.a.a)localObject1).CUY) {
            break label588;
          }
          i = 0;
          label470:
          ((TextView)localObject2).setVisibility(i);
          localObject2 = paramBundle.CRU;
          if (localObject2 == null) {
            kotlin.g.b.p.btv("opButton");
          }
          ((TextView)localObject2).setOnClickListener(((com.tencent.mm.plugin.scanner.view.a.a)localObject1).CUZ);
          localObject1 = paramBundle.xcd;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("loadingLayout");
          }
          ((View)localObject1).setVisibility(8);
          if (paramBundle.CSf) {
            break label594;
          }
          paramBundle.CSf = false;
          paramBundle.ud(false);
        }
      }
    }
    for (;;)
    {
      if (paramInt == 3) {
        af.ic(4, this.zTQ);
      }
      AppMethodBeat.o(240749);
      return;
      label564:
      bool = false;
      break;
      label570:
      bool = false;
      break label96;
      label576:
      localObject1 = null;
      break label153;
      label582:
      i = 8;
      break label410;
      label588:
      i = 8;
      break label470;
      label594:
      paramBundle.CSa = false;
      paramBundle.CSb = true;
      localObject1 = paramBundle.BCP;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("infoLayout");
      }
      ((View)localObject1).setVisibility(0);
      paramBundle.setVisibility(4);
      paramBundle.post((Runnable)new ScanInfoMaskView.d(paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI
 * JD-Core Version:    0.7.0.1
 */