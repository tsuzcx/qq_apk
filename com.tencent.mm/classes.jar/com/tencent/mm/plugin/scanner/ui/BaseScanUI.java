package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.qy;
import com.tencent.mm.f.a.uj;
import com.tencent.mm.f.a.uk;
import com.tencent.mm.f.b.a.no;
import com.tencent.mm.f.b.a.qr;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.BaseBoxDialogView;
import com.tencent.mm.plugin.scanner.box.g;
import com.tencent.mm.plugin.scanner.d.a.2;
import com.tencent.mm.plugin.scanner.d.a.c;
import com.tencent.mm.plugin.scanner.g.d.a;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.model.x;
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
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.w;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@k
@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class BaseScanUI
  extends MMSecDataActivity
  implements d.a, com.tencent.mm.plugin.scanner.model.d, com.tencent.mm.plugin.scanner.view.c
{
  private int Fzs;
  private ml IGA;
  private boolean IGn;
  private boolean IGo;
  private ScanSharedMaskView ILP;
  private ScanInfoMaskView ILQ;
  private boolean IMa;
  private com.tencent.mm.plugin.scanner.box.i INp;
  private ScanUIRectView IOG;
  private ScannerFlashSwitcher IOH;
  private View IOI;
  private DialogInterface.OnCancelListener IOJ;
  private ScanUITopOpButtonComponent IOK;
  private int IOL;
  private com.tencent.mm.plugin.scanner.g.e IOM;
  private com.tencent.mm.plugin.scanner.ui.widget.b ION;
  private boolean IOO;
  private boolean IOP;
  private boolean IOQ;
  private boolean IOR;
  private long IOT;
  private boolean IOU;
  private boolean IOV;
  private boolean IOW;
  private boolean IOX;
  private boolean IOY;
  private int[] IOZ;
  private int IPa;
  private boolean IPb;
  private boolean IPc;
  private boolean IPd;
  private BaseScanRequest IPe;
  private boolean IPf;
  private boolean IPg;
  private boolean IPh;
  private boolean IPi;
  private ab IPj;
  private boolean IPk;
  private qr IPl;
  private int IPm;
  private boolean IPn;
  private boolean IPo;
  private boolean IPp;
  private ScanUIRectView.a IPq;
  private a.c IPr;
  private com.tencent.mm.plugin.scanner.g.a.a IPs;
  private g IPt;
  private com.tencent.mm.network.p IPu;
  private IListener IPv;
  private FrameLayout container;
  private com.tencent.mm.ui.widget.a.e qXn;
  private Vibrator rqC;
  private b.a tCp;
  private IListener<aaq> ubt;
  private com.tencent.mm.modelgeo.d yUU;
  
  public BaseScanUI()
  {
    AppMethodBeat.i(51728);
    this.INp = null;
    this.IOL = 0;
    this.IOO = false;
    this.IOP = true;
    this.IOQ = true;
    this.IOR = false;
    this.IMa = true;
    this.IOU = true;
    this.IOV = true;
    this.IOW = true;
    this.IOX = true;
    this.IOY = false;
    this.IPg = false;
    this.IPh = true;
    this.IPi = true;
    this.IPj = new ab();
    this.IPk = true;
    this.IPl = new qr();
    this.IPn = false;
    this.IPo = false;
    this.IPp = false;
    this.IPq = new ScanUIRectView.a()
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
          ad.a(BaseScanUI.b(BaseScanUI.this), true, 1, j);
          BaseScanUI.e(BaseScanUI.this);
          Object localObject1 = BaseScanUI.this;
          if (j > 1) {}
          boolean bool2;
          for (boolean bool1 = true;; bool1 = false)
          {
            BaseScanUI.a((BaseScanUI)localObject1, bool1);
            BaseScanUI.b(BaseScanUI.this, false);
            ad.a(BaseScanUI.b(BaseScanUI.this), (List)localObject2, l);
            bool2 = BaseScanUI.f(BaseScanUI.this).gZ;
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
          Object localObject3 = new qy();
          localObject2 = ((WxQBarResult)localObject1).data;
          ((qy)localObject3).fPO.scanResult = ((String)localObject2);
          ((qy)localObject3).fPO.fPQ = paramAnonymousBundle;
          ((qy)localObject3).fPO.cUP = 0;
          EventCenter.instance.publish((IEvent)localObject3);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("key_scan_result", (String)localObject2);
          ((Intent)localObject3).putExtra("key_scan_result_raw", ((WxQBarResult)localObject1).rawData);
          ((Intent)localObject3).putExtra("key_scan_result_code_name", paramAnonymousBundle);
          ((Intent)localObject3).putExtra("key_scan_result_code_version", ((WxQBarResult)localObject1).Zmv);
          BaseScanUI.this.setResult(-1, (Intent)localObject3);
          BaseScanUI.this.cIP();
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
                BaseScanUI.i(BaseScanUI.this).xx(false);
                BaseScanUI.i(BaseScanUI.this).b(true, null);
                BaseScanUI.j(BaseScanUI.this);
              }
              BaseScanUI.d(BaseScanUI.this, true);
              BaseScanUI.h(BaseScanUI.this).setSuccessMarkClickListener(new ae()
              {
                public final void adG(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(169958);
                  Log.i("MicroMsg.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  if ((paramAnonymous2Int < this.IPx.size()) && (j > 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.val$result, (WxQBarResult)this.IPx.get(paramAnonymous2Int));
                    ad.jf(2, paramAnonymous2Int);
                    ad.fDj();
                  }
                  AppMethodBeat.o(169958);
                }
              });
              BaseScanUI.k(BaseScanUI.this);
              BaseScanUI.l(BaseScanUI.this);
              BaseScanUI.m(BaseScanUI.this);
              localObject3 = BaseScanUI.h(BaseScanUI.this);
              if (com.tencent.mm.plugin.scanner.util.d.fES())
              {
                if (((ScanUIRectView)localObject3).ISM == null)
                {
                  ((ScanUIRectView)localObject3).ISM = new ScanDebugView(((ScanUIRectView)localObject3).getContext());
                  ((ScanUIRectView)localObject3).addView(((ScanUIRectView)localObject3).ISM);
                }
                if (((ScanUIRectView)localObject3).ISM != null)
                {
                  localObject4 = ((ScanUIRectView)localObject3).ISM;
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
                    localObject4 = ((ScanDebugView)localObject4).FAA;
                    if (localObject4 == null) {
                      kotlin.g.b.p.bGy("debugInfo");
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
                public final void xs(boolean paramAnonymous2Boolean)
                {
                  AppMethodBeat.i(219217);
                  if ((paramAnonymous2Boolean) || (j == 1) || (this.IPx.size() == 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.val$result, this.IPA);
                    ad.jf(1, 0);
                  }
                  AppMethodBeat.o(219217);
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
              localObject3 = ((ScanDebugView)localObject4).FAA;
              if (localObject3 == null) {
                kotlin.g.b.p.bGy("debugInfo");
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
    this.IPr = new a.c()
    {
      public final void P(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(51710);
        Log.e("MicroMsg.ScanUI", "alvinluo onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousString });
        String str = paramAnonymousString;
        if (Util.isNullOrNil(paramAnonymousString)) {
          str = BaseScanUI.this.getResources().getString(l.i.IFs);
        }
        com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(l.i.app_ok), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(51708);
            BaseScanUI.s(BaseScanUI.this);
            ad.adA(BaseScanUI.b(BaseScanUI.this));
            AppMethodBeat.o(51708);
          }
        });
        ad.a(2, false, System.currentTimeMillis());
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
    this.IPs = new com.tencent.mm.plugin.scanner.g.a.a()
    {
      public final void a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        AppMethodBeat.i(217237);
        Log.i("MicroMsg.ScanUI", "notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Long.valueOf(paramAnonymousLong), Integer.valueOf(1) });
        BaseScanUI.u(BaseScanUI.this);
        AppMethodBeat.o(217237);
      }
      
      public final void b(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161970);
        String str;
        if (paramAnonymousInt1 == 2)
        {
          ad.ae(false, paramAnonymousInt1);
          BaseScanUI.t(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          BaseScanUI.h(BaseScanUI.this).b(false, null);
          str = paramAnonymousString;
          if (Util.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(l.i.IFs);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(l.i.app_ok), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51717);
              BaseScanUI.s(BaseScanUI.this);
              ad.adA(BaseScanUI.b(BaseScanUI.this));
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
            BaseScanUI.c(BaseScanUI.this).G(paramAnonymousLong, false);
          }
          BaseScanUI.t(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          str = paramAnonymousString;
          if (Util.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(l.i.IFt);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(l.i.app_ok), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(161969);
              BaseScanUI.s(BaseScanUI.this);
              ad.adA(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(161969);
            }
          });
        }
        AppMethodBeat.o(161970);
      }
      
      public final void b(x paramAnonymousx)
      {
        AppMethodBeat.i(51718);
        if (BaseScanUI.b(BaseScanUI.this) != 12)
        {
          Log.i("MicroMsg.ScanUI", "alvnluo onScanResultSuccess not SELECT_SCAN_MODE_GOODS and ignore");
          AppMethodBeat.o(51718);
          return;
        }
        if ((BaseScanUI.n(BaseScanUI.this)) || ((paramAnonymousx.source == 1) && (BaseScanUI.q(BaseScanUI.this))))
        {
          Log.e("MicroMsg.ScanUI", "alvinluo onScanResultSuccess source:%d, isScrolling: %b or needPauseScan: %b and ignore", new Object[] { Integer.valueOf(paramAnonymousx.source), Boolean.valueOf(BaseScanUI.n(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.q(BaseScanUI.this)) });
          AppMethodBeat.o(51718);
          return;
        }
        BaseScanUI.a(BaseScanUI.this, paramAnonymousx);
        AppMethodBeat.o(51718);
      }
    };
    this.IPt = new g()
    {
      public final void a(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(219137);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onDismiss exitType: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseScanUI.v(BaseScanUI.this);
        BaseScanUI.w(BaseScanUI.this);
        BaseScanUI.i(BaseScanUI.this).xy(true);
        BaseScanUI.s(BaseScanUI.this);
        BaseScanUI.e(BaseScanUI.this, true);
        ad.PT(System.currentTimeMillis());
        ad.a(BaseScanUI.x(BaseScanUI.this), paramAnonymousInt, BaseScanUI.r(BaseScanUI.this));
        ad.adA(12);
        AppMethodBeat.o(219137);
      }
      
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(219138);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onCancel");
        BaseScanUI.d(BaseScanUI.this, false);
        BaseScanUI.v(BaseScanUI.this);
        BaseScanUI.w(BaseScanUI.this);
        AppMethodBeat.o(219138);
      }
      
      public final void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(219136);
        Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onShow");
        BaseScanUI.i(BaseScanUI.this).xy(false);
        BaseScanUI.e(BaseScanUI.this, false);
        ad.PS(System.currentTimeMillis());
        AppMethodBeat.o(219136);
      }
    };
    this.IPu = new p.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(219107);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219907);
            boolean bool = BaseScanUI.L(BaseScanUI.this);
            Log.i("MicroMsg.ScanUI", "onNetWorkChange %d, canResume: %b", new Object[] { Integer.valueOf(com.tencent.mm.kernel.h.aGY().bih()), Boolean.valueOf(bool) });
            Object localObject;
            int i;
            if (BaseScanUI.h(BaseScanUI.this) != null)
            {
              localObject = BaseScanUI.h(BaseScanUI.this);
              i = paramAnonymousInt;
              if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4)) {
                break label198;
              }
              ((ScanUIRectView)localObject).IOW = true;
              if ((!r.aeb(((ScanUIRectView)localObject).mode)) && (bool)) {
                ((ScanUIRectView)localObject).onResume();
              }
            }
            for (;;)
            {
              if (((ScanUIRectView)localObject).ILO != null) {
                ((ScanUIRectView)localObject).ILO.onNetworkChange(i);
              }
              if (((ScanUIRectView)localObject).ILP != null)
              {
                localObject = ((ScanUIRectView)localObject).ILP;
                ((ScanSharedMaskView)localObject).dBp();
                ((ScanSharedMaskView)localObject).adW(((ScanSharedMaskView)localObject).IXY);
              }
              if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4)) {
                break label248;
              }
              if (!BaseScanUI.M(BaseScanUI.this)) {
                break;
              }
              AppMethodBeat.o(219907);
              return;
              label198:
              ((ScanUIRectView)localObject).IOW = false;
              if (!r.aeb(((ScanUIRectView)localObject).mode)) {
                ((ScanUIRectView)localObject).onPause();
              }
            }
            BaseScanUI.j(BaseScanUI.this, true);
            BaseScanUI.N(BaseScanUI.this);
            AppMethodBeat.o(219907);
            return;
            label248:
            if (!BaseScanUI.M(BaseScanUI.this))
            {
              AppMethodBeat.o(219907);
              return;
            }
            BaseScanUI.j(BaseScanUI.this, false);
            BaseScanUI.N(BaseScanUI.this);
            AppMethodBeat.o(219907);
          }
        });
        AppMethodBeat.o(219107);
      }
    };
    this.IPv = new IListener() {};
    this.ubt = new IListener() {};
    AppMethodBeat.o(51728);
  }
  
  private void adM(int paramInt)
  {
    AppMethodBeat.i(51735);
    Log.i("MicroMsg.ScanUI", "alvinluo operateFlash operation: %d", new Object[] { Integer.valueOf(paramInt) });
    uk localuk = new uk();
    localuk.fTJ.fvK = paramInt;
    EventCenter.instance.publish(localuk);
    if (this.IOH != null)
    {
      if (paramInt == 1)
      {
        this.IOH.fEm();
        AppMethodBeat.o(51735);
        return;
      }
      this.IOH.fEn();
    }
    AppMethodBeat.o(51735);
  }
  
  private void adN(int paramInt)
  {
    AppMethodBeat.i(219749);
    ad.b(ad.a(this.IPe), this.Fzs, this.IPe, paramInt);
    AppMethodBeat.o(219749);
  }
  
  private void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219675);
    Log.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance success: %b, isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.FALSE });
    Object localObject = this.IPl;
    long l;
    if (paramBoolean1)
    {
      l = 1L;
      ((qr)localObject).hlu = l;
      this.IPl.hlv = (System.currentTimeMillis() - this.IOT);
      localObject = this.IPl;
      if (!this.IOG.fDZ()) {
        break label369;
      }
      l = 0L;
      label83:
      ((qr)localObject).hlw = l;
      this.IPl.hlB = this.Fzs;
      this.IPl.hlx = com.tencent.qbar.c.Zmm.Zmp;
      if (j.IZt.fEU() > 0L) {
        this.IPl.hlA = (j.IZt.fEU() - this.IOT);
      }
      this.IPl.bpa();
      if (r.aeb(this.Fzs))
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(1229L, 0L, 1L);
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        if (!paramBoolean1) {
          break label374;
        }
        l = 1L;
        label184:
        ((com.tencent.mm.plugin.report.service.h)localObject).p(1229L, 1L, l);
        if (paramBoolean1)
        {
          if (!this.IOG.fDZ()) {
            break label379;
          }
          com.tencent.mm.plugin.report.service.h.IzE.p(1229L, 5L, 1L);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.p(1229L, 7L, this.IPl.hlv);
      com.tencent.mm.plugin.report.service.h.IzE.p(1229L, 9L, this.IPl.hlx);
      if ((paramBoolean1) && (paramBoolean2))
      {
        Log.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance scanTime: %s, totalFrames: %d", new Object[] { Long.valueOf(this.IPl.hlv), Long.valueOf(this.IPl.hlx) });
        com.tencent.mm.plugin.report.service.h.IzE.p(1229L, 11L, 1L);
        com.tencent.mm.plugin.report.service.h.IzE.p(1229L, 12L, this.IPl.hlv);
        com.tencent.mm.plugin.report.service.h.IzE.p(1229L, 14L, this.IPl.hlx);
      }
      AppMethodBeat.o(219675);
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
      com.tencent.mm.plugin.report.service.h.IzE.p(1229L, 3L, 1L);
    }
  }
  
  private void au(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(51750);
    Log.v("MicroMsg.ScanUI", "alvinluo showFlash show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if ((this.IOH != null) && (!this.IOH.isShown()))
      {
        this.IOG.fEe();
        if (paramBoolean2) {
          this.IOH.show();
        }
        for (;;)
        {
          com.tencent.qbar.c.Zmm.aAk(1);
          ad.je(this.Fzs, 1);
          AppMethodBeat.o(51750);
          return;
          this.IOH.setVisibility(0);
        }
      }
    }
    else if ((this.IOH != null) && (!this.IOH.gZ))
    {
      this.IOG.fEf();
      if (paramBoolean2)
      {
        this.IOH.hide();
        AppMethodBeat.o(51750);
        return;
      }
      this.IOH.setVisibility(8);
    }
    AppMethodBeat.o(51750);
  }
  
  private void dBp()
  {
    AppMethodBeat.i(51748);
    if ((r.aeb(this.Fzs)) || (r.aed(this.Fzs)) || (r.aec(this.Fzs))) {}
    for (int i = 0; i != 0; i = 1)
    {
      xr(this.IOW);
      AppMethodBeat.o(51748);
      return;
    }
    xr(true);
    AppMethodBeat.o(51748);
  }
  
  private void eaE()
  {
    AppMethodBeat.i(219659);
    this.IOK.setShowMoreButton(fDB());
    this.IOK.setOnMoreClickListener(new BaseScanUI.5(this));
    AppMethodBeat.o(219659);
  }
  
  private void fDA()
  {
    AppMethodBeat.i(51736);
    Log.d("MicroMsg.ScanUI", "alvinluo checkAndOperateFlash operation: %d", new Object[] { Integer.valueOf(2) });
    if (this.IOH.gZ) {
      adM(2);
    }
    AppMethodBeat.o(51736);
  }
  
  private boolean fDB()
  {
    AppMethodBeat.i(219660);
    if (((r.aeb(this.Fzs)) || (r.aec(this.Fzs)) || (r.aed(this.Fzs))) && (!this.IGo) && (!this.IPf))
    {
      AppMethodBeat.o(219660);
      return true;
    }
    AppMethodBeat.o(219660);
    return false;
  }
  
  private boolean fDC()
  {
    AppMethodBeat.i(219664);
    Log.i("MicroMsg.ScanUI", "alvinluo processCancel isShowingMultiCodeResult: %b, infoViewType: %d", new Object[] { Boolean.valueOf(this.IPo), Integer.valueOf(this.IPj.ILT) });
    ScanUITopOpButtonComponent localScanUITopOpButtonComponent = this.IOK;
    AnimatorListenerAdapter local8 = new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(219141);
        BaseScanUI.s(BaseScanUI.this);
        AppMethodBeat.o(219141);
      }
    };
    TextView localTextView = localScanUITopOpButtonComponent.IUI;
    if (localTextView == null) {
      kotlin.g.b.p.bGy("cancelButton");
    }
    if (localTextView.getVisibility() == 0)
    {
      localScanUITopOpButtonComponent.xx(true);
      localScanUITopOpButtonComponent.b(false, (Animator.AnimatorListener)local8);
    }
    for (boolean bool = true;; bool = false)
    {
      xp(true);
      if ((r.aeb(this.Fzs)) && (this.IPo))
      {
        this.IPo = false;
        ad.jf(3, -1);
        ad.fDi();
      }
      if ((r.aeb(this.Fzs)) && (this.IPj != null) && (this.IPj.ILT == 3)) {
        ad.jg(5, this.Fzs);
      }
      AppMethodBeat.o(219664);
      return bool;
    }
  }
  
  private void fDD()
  {
    AppMethodBeat.i(51739);
    switch (this.Fzs)
    {
    default: 
      this.IOG.setScanCallback(null);
      AppMethodBeat.o(51739);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.IOG.setScanCallback(this.IPq);
      this.IOM = new com.tencent.mm.plugin.scanner.g.d(this.Fzs, this.IPa, this.IOG, this, this);
      AppMethodBeat.o(51739);
      return;
    case 12: 
      this.IOG.setScanCallback(this.IPr);
      this.IOM = new com.tencent.mm.plugin.scanner.g.a(this.Fzs, this.IOG, this, this.IPs);
      ((com.tencent.mm.plugin.scanner.g.a)this.IOM).a(this.IGA);
      AppMethodBeat.o(51739);
      return;
    }
    this.IOM = new af(this);
    AppMethodBeat.o(51739);
  }
  
  private void fDE()
  {
    AppMethodBeat.i(169986);
    if (this.IPj != null)
    {
      this.IPj.a(this);
      if (this.IOG != null) {
        this.IPj.a(this.IOG.getScanMaskView(), this.IOG.getSharedMaskView(), this.ILQ);
      }
    }
    AppMethodBeat.o(169986);
  }
  
  private void fDF()
  {
    AppMethodBeat.i(169987);
    int i = 0;
    if (r.aeb(this.Fzs)) {
      i = com.tencent.qbar.c.Zmj;
    }
    for (;;)
    {
      com.tencent.qbar.c.Zmm.setTabType(i);
      AppMethodBeat.o(169987);
      return;
      if (this.Fzs == 12) {
        i = com.tencent.qbar.c.Zmk;
      } else if (this.Fzs == 3) {
        i = com.tencent.qbar.c.Zml;
      }
    }
  }
  
  private void fDG()
  {
    AppMethodBeat.i(51757);
    Log.i("MicroMsg.ScanUI", "alvinluo resumeScan");
    this.IOT = System.currentTimeMillis();
    this.IPg = false;
    if (this.IOG != null) {
      this.IOG.onResume();
    }
    setEnableSwitchTab(true);
    AppMethodBeat.o(51757);
  }
  
  private void fDy()
  {
    AppMethodBeat.i(51732);
    ScanSharedMaskView localScanSharedMaskView = this.IOG.getSharedMaskView();
    if (localScanSharedMaskView == null)
    {
      AppMethodBeat.o(51732);
      return;
    }
    if (!this.IGn)
    {
      localScanSharedMaskView.getGalleryButton().setVisibility(0);
      localScanSharedMaskView.setOnGalleryClickListener(new BaseScanUI.31(this));
      AppMethodBeat.o(51732);
      return;
    }
    localScanSharedMaskView.getGalleryButton().setVisibility(8);
    AppMethodBeat.o(51732);
  }
  
  private void fDz()
  {
    AppMethodBeat.i(51734);
    ScanSharedMaskView localScanSharedMaskView = this.IOG.getSharedMaskView();
    if (localScanSharedMaskView != null) {
      this.IOH = localScanSharedMaskView.getFlashSwitcherView();
    }
    if (this.IOH != null)
    {
      this.IOH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(221183);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.qbar.c.Zmm.aAk(2);
          if (!BaseScanUI.f(BaseScanUI.this).gZ) {
            BaseScanUI.a(BaseScanUI.this, 1);
          }
          for (;;)
          {
            ad.je(BaseScanUI.b(BaseScanUI.this), 2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(221183);
            return;
            BaseScanUI.a(BaseScanUI.this, 2);
          }
        }
      });
      this.IOG.setFlashStatus(this.IOH.dic);
      if (r.aed(this.Fzs))
      {
        fDA();
        this.IOH.hide();
      }
    }
    AppMethodBeat.o(51734);
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
  
  private void jj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219671);
    Log.v("MicroMsg.ScanUI", "alvinluo reportSwitchTab %b", new Object[] { Boolean.valueOf(this.IOU) });
    ad.jd(paramInt1, paramInt2);
    ad.adu(paramInt1);
    ad.adw(paramInt1);
    ad.adA(paramInt1);
    AppMethodBeat.o(219671);
  }
  
  private void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51733);
    Log.i("MicroMsg.ScanUI", "alvinluo setEnableSwitchTab enable: %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.IOP) });
    if (this.ION != null)
    {
      if (!paramBoolean) {
        break label95;
      }
      if (this.IOP) {
        this.ION.setEnableSwitchTab(true);
      }
    }
    while (this.IOG != null) {
      if (paramBoolean)
      {
        if (this.IOP)
        {
          this.IOG.setEnableScrollSwitchTab(true);
          AppMethodBeat.o(51733);
          return;
          label95:
          this.ION.setEnableSwitchTab(false);
        }
      }
      else {
        this.IOG.setEnableScrollSwitchTab(false);
      }
    }
    AppMethodBeat.o(51733);
  }
  
  private void xo(boolean paramBoolean)
  {
    AppMethodBeat.i(51731);
    if ((!paramBoolean) && (!ar.isDarkMode()))
    {
      getController().setNavigationbarColor(getContext().getResources().getColor(l.c.BG_1));
      AppMethodBeat.o(51731);
      return;
    }
    getController().setNavigationbarColor(getResources().getColor(l.c.IBX));
    AppMethodBeat.o(51731);
  }
  
  private void xp(boolean paramBoolean)
  {
    AppMethodBeat.i(219651);
    if (this.ION != null)
    {
      Object localObject = this.ION;
      Log.i("MicroMsg.ScanScrollTabController", "alvinluo setEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).setEnableSwitchTab(paramBoolean);
      localObject = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).IXH;
      if (localObject != null)
      {
        ((ScanScrollTabView)localObject).setEnabled(paramBoolean);
        AppMethodBeat.o(219651);
        return;
      }
    }
    AppMethodBeat.o(219651);
  }
  
  private void xq(boolean paramBoolean)
  {
    AppMethodBeat.i(51747);
    if (paramBoolean)
    {
      this.IOI.setVisibility(0);
      this.IOG.dlq();
      this.IOI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(217270);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/BaseScanUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          BaseScanUI.K(BaseScanUI.this);
          BaseScanUI.i(BaseScanUI.this, false);
          BaseScanUI.s(BaseScanUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(217270);
        }
      });
      if (this.IOG != null) {
        this.IOG.xu(true);
      }
      this.IOK.xx(false);
      au(false, true);
      AppMethodBeat.o(51747);
      return;
    }
    this.IOI.setVisibility(8);
    if (this.IOG != null) {
      this.IOG.xu(false);
    }
    this.IOK.xx(true);
    AppMethodBeat.o(51747);
  }
  
  private void xr(boolean paramBoolean)
  {
    AppMethodBeat.i(51749);
    Log.i("MicroMsg.ScanUI", "network change %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      xq(false);
      this.IOG.dlq();
    }
    AppMethodBeat.o(51749);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, c.a parama)
  {
    AppMethodBeat.i(51746);
    if ((this.IPj != null) && (this.IPj.ILR)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScanUI", "alvinluo showLoadingView show: %b, isLoadingShow: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2) });
      this.IPg = paramBoolean1;
      if (this.IPj != null)
      {
        this.IPj.ILS = parama;
        if (this.IPj.ILR != paramBoolean1)
        {
          this.IPj.as(paramBoolean1, paramBoolean2);
          if (paramBoolean1)
          {
            this.IOK.xx(false);
            this.IOK.b(false, null);
          }
        }
      }
      AppMethodBeat.o(51746);
      return;
    }
  }
  
  public final void cIP()
  {
    AppMethodBeat.i(51743);
    Log.i("MicroMsg.ScanUI", "finishUI");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(51743);
  }
  
  public final void fCJ()
  {
    AppMethodBeat.i(219765);
    if (this.IPj != null)
    {
      ab localab = this.IPj;
      ScanInfoMaskView localScanInfoMaskView = localab.ILQ;
      if (localScanInfoMaskView != null)
      {
        localScanInfoMaskView.getVisibility();
        localScanInfoMaskView.setVisibility(8);
        localScanInfoMaskView.IXx = true;
      }
      localab.ILT = 0;
    }
    AppMethodBeat.o(219765);
  }
  
  public final void fCK()
  {
    AppMethodBeat.i(219763);
    xp(true);
    this.IPg = false;
    if (this.IPj != null)
    {
      this.IOK.b(false, null);
      if (this.ILP != null) {
        this.ILP.f(true, null);
      }
      Object localObject = this.IPj;
      AnimatorListenerAdapter local25 = new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(218509);
          super.onAnimationEnd(paramAnonymousAnimator);
          BaseScanUI.T(BaseScanUI.this).jn(this.val$mode, 4);
          AppMethodBeat.o(218509);
        }
      };
      localObject = ((ab)localObject).ILQ;
      if (localObject != null)
      {
        View localView = ((ScanInfoMaskView)localObject).HyS;
        if (localView == null) {
          kotlin.g.b.p.bGy("infoLayout");
        }
        if (localView.getVisibility() == 0)
        {
          localView = ((ScanInfoMaskView)localObject).BOd;
          if (localView == null) {
            kotlin.g.b.p.bGy("loadingLayout");
          }
          localView.setVisibility(8);
          localObject = ((ScanInfoMaskView)localObject).HyS;
          if (localObject == null) {
            kotlin.g.b.p.bGy("infoLayout");
          }
          ScanInfoMaskView.a((View)localObject, local25);
        }
      }
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220497);
          if ((!BaseScanUI.I(BaseScanUI.this)) || (BaseScanUI.H(BaseScanUI.this) == null))
          {
            BaseScanUI.U(BaseScanUI.this);
            AppMethodBeat.o(220497);
            return;
          }
          BaseScanUI.f(BaseScanUI.this, false);
          BaseScanUI.H(BaseScanUI.this).f(false, new AnimatorListenerAdapter()
          {
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(217278);
              super.onAnimationEnd(paramAnonymous2Animator);
              BaseScanUI.U(BaseScanUI.this);
              AppMethodBeat.o(217278);
            }
          });
          AppMethodBeat.o(220497);
        }
      }, 1000L);
    }
    AppMethodBeat.o(219763);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return l.g.IEx;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51730);
    this.container = ((FrameLayout)findViewById(l.f.IDj));
    this.ION = new com.tencent.mm.plugin.scanner.ui.widget.b(this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.compatible.util.d.qV(19))
    {
      getWindow().addFlags(67109888);
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.IOI = findViewById(l.f.IDp);
      this.ILQ = ((ScanInfoMaskView)findViewById(l.f.IDm));
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
      this.IOK = ((ScanUITopOpButtonComponent)findViewById(l.f.IDL));
      this.IOG = new ScanUIRectView(this);
      this.IOG.ISP = this;
      this.IOG.setScanRequest(this.IPe);
      this.IOG.setEnableScanGoodsDynamicWording(this.IPp);
      localObject2 = (ScanScrollTabView)findViewById(l.f.IDw);
      localObject1 = this.ION;
      kotlin.g.b.p.k(localObject2, "scrollTabView");
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).IXH = ((ScanScrollTabView)localObject2);
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).IXH;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).xB();
      }
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).IXH;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)new b.c());
      }
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).IXI.clear();
      localObject2 = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).IXJ).iterator();
      int i = 0;
      label256:
      if (!((Iterator)localObject2).hasNext()) {
        break label305;
      }
      if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).a(i, (b.b)((Iterator)localObject2).next())) {
        break label970;
      }
      i += 1;
    }
    label305:
    label970:
    for (;;)
    {
      break label256;
      getWindow().setFlags(1024, 1024);
      break;
      localObject1 = this.ION;
      localObject2 = new com.tencent.mm.plugin.scanner.ui.widget.e()
      {
        public final void adP(int paramAnonymousInt)
        {
          AppMethodBeat.i(219135);
          Log.i("MicroMsg.ScanUI", "alvinluo onTabUnSelected tabId: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (r.aeb(paramAnonymousInt)) {
            BaseScanUI.g(BaseScanUI.this, false);
          }
          BaseScanUI.adO(paramAnonymousInt);
          if (paramAnonymousInt == 12) {
            BaseScanUI.fDH();
          }
          AppMethodBeat.o(219135);
        }
        
        public final void jk(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(219134);
          Log.i("MicroMsg.ScanUI", "alvinluo onTabSelected tabId: %d, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt1 == 12) && (!WeChatBrands.Business.Entries.DiscoveryScanRecognize.checkAvailable(BaseScanUI.this.getContext())))
          {
            BaseScanUI.this.cIP();
            AppMethodBeat.o(219134);
            return;
          }
          if ((paramAnonymousInt1 == 3) && (!WeChatBrands.Business.Entries.DiscoveryScanTranslate.checkAvailable(BaseScanUI.this.getContext())))
          {
            BaseScanUI.this.cIP();
            AppMethodBeat.o(219134);
            return;
          }
          if (!BaseScanUI.E(BaseScanUI.this))
          {
            BaseScanUI.a(BaseScanUI.this, paramAnonymousInt1, paramAnonymousInt2);
            if (BaseScanUI.b(BaseScanUI.this) != paramAnonymousInt1)
            {
              if ((paramAnonymousInt1 != 12) || (paramAnonymousInt2 != 4)) {
                break label300;
              }
              ad.jg(7, paramAnonymousInt1);
              BaseScanUI.b(BaseScanUI.this, 3);
              BaseScanUI.f(BaseScanUI.this, true);
              BaseScanUI.G(BaseScanUI.this);
              if (BaseScanUI.H(BaseScanUI.this) != null)
              {
                BaseScanUI.H(BaseScanUI.this).setShowToast(true);
                BaseScanUI.H(BaseScanUI.this).setScanToast(BaseScanUI.this.getResources().getString(l.i.IEM));
              }
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.ScanUI", "alvinluo onTabSelected scanGoodsScene: %d, needAnimateHideBlurBackground: %b", new Object[] { Integer.valueOf(BaseScanUI.x(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.I(BaseScanUI.this)) });
            BaseScanUI.c(BaseScanUI.this, paramAnonymousInt1);
            if (r.aeb(paramAnonymousInt1)) {
              BaseScanUI.g(BaseScanUI.this, true);
            }
            BaseScanUI.J(BaseScanUI.this);
            AppMethodBeat.o(219134);
            return;
            BaseScanUI.F(BaseScanUI.this);
            break;
            label300:
            BaseScanUI.b(BaseScanUI.this, ad.a(BaseScanUI.r(BaseScanUI.this)));
            BaseScanUI.f(BaseScanUI.this, false);
            if (BaseScanUI.H(BaseScanUI.this) != null) {
              BaseScanUI.H(BaseScanUI.this).setShowToast(false);
            }
          }
        }
      };
      kotlin.g.b.p.k(localObject2, "tabOnSelectedListener");
      localObject2 = new b.d((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1, (com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).IXH;
      if (localObject1 != null) {
        ((ScanScrollTabView)localObject1).setOnTabChangedListener((com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      }
      localObject2 = this.ION;
      localObject1 = new com.tencent.mm.plugin.scanner.ui.widget.d()
      {
        public final void onScrollStateChanged(int paramAnonymousInt)
        {
          AppMethodBeat.i(218981);
          if (paramAnonymousInt == 1) {
            BaseScanUI.h(BaseScanUI.this, false);
          }
          for (;;)
          {
            Log.v("MicroMsg.ScanUI", "alvinluo onScrollStateChanged state: %d, isScrolling: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BaseScanUI.n(BaseScanUI.this)) });
            AppMethodBeat.o(218981);
            return;
            if ((paramAnonymousInt == 3) || (paramAnonymousInt == 2)) {
              BaseScanUI.h(BaseScanUI.this, true);
            }
          }
        }
        
        public final void v(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(218976);
          Log.v("MicroMsg.ScanUI", "alvinluo onScroll offsetX: %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(218976);
        }
      };
      kotlin.g.b.p.k(localObject1, "tabOnScrollListener");
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).IXH;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)localObject1);
      }
      if (this.IOG != null) {
        this.IOG.setScrollTabController(this.ION);
      }
      if ((this.IPb) || (this.Fzs == 8))
      {
        this.IPd = true;
        if (this.IPe != null)
        {
          if (this.IPe.IGk) {
            this.IPd = true;
          }
          if (this.IPe.IGn) {
            this.IGn = true;
          }
          if (this.IPe.IGo) {
            this.IGo = true;
          }
        }
        if (!this.IPd) {
          break label928;
        }
        localObject1 = this.ION.IXH;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(8);
        }
        this.IOP = false;
        this.IOG.setBottomExtraHeight(0);
      }
      for (;;)
      {
        setEnableSwitchTab(this.IOP);
        Log.i("MicroMsg.ScanUI", "alvinluo initView currentMode: %d, showOnlyScanCode: %b, hideScrollTab: %b, scanRequest: %s", new Object[] { Integer.valueOf(this.Fzs), Boolean.valueOf(this.IPb), Boolean.valueOf(this.IPd), this.IPe });
        this.IOG.setActivity(this);
        this.container.addView(this.IOG, 0, new FrameLayout.LayoutParams(-1, -1));
        this.IOG.onCreate();
        this.IOG.setShowScanTips(this.IOV);
        this.IOG.setNetworkAvailable(this.IOW);
        this.IOG.setScanMode(this.Fzs);
        this.IOG.refreshView();
        this.ILP = this.IOG.getSharedMaskView();
        jj(this.Fzs, 0);
        fDE();
        ad.adA(this.Fzs);
        fDF();
        if (this.IOY) {
          this.IOG.setBlackInterval(com.tencent.qbar.b.inB());
        }
        fDy();
        fDD();
        if ((this.IOZ != null) && (this.IOZ.length > 0)) {
          this.IOG.setScanCodeReaders(this.IOZ);
        }
        if (this.IPf) {
          this.IOG.setMyQrCodeVisible(false);
        }
        this.ION.jn(this.Fzs, 0);
        fDz();
        this.IOK.setOnCloseClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(217089);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            BaseScanUI.fDH();
            BaseScanUI.e(BaseScanUI.this);
            BaseScanUI.y(BaseScanUI.this);
            ad.jf(3, -1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(217089);
          }
        });
        this.IOK.setOnCancelClickListener(new BaseScanUI.7(this));
        eaE();
        AppMethodBeat.o(51730);
        return;
        localObject1 = new ArrayList();
        ((List)localObject1).add(Integer.valueOf(1));
        if ((this.IPn) && (!WeChatBrands.Business.Entries.DiscoveryScanRecognize.restricted())) {
          ((List)localObject1).add(Integer.valueOf(12));
        }
        if (com.tencent.mm.az.b.bna()) {
          if ((r.fFc()) && (!WeChatBrands.Business.Entries.DiscoveryScanTranslate.restricted())) {
            ((List)localObject1).add(Integer.valueOf(3));
          }
        }
        for (;;)
        {
          if (((List)localObject1).size() == 1) {
            this.IPd = true;
          }
          this.ION.hk((List)localObject1);
          break;
          ((List)localObject1).add(Integer.valueOf(3));
        }
        localObject1 = this.ION.IXH;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(0);
        }
        this.IOG.setBottomExtraHeight(getResources().getDimensionPixelSize(l.d.ICg));
        this.IOP = true;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(51756);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    final long l1;
    boolean bool;
    label220:
    Object localObject1;
    label289:
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
          ad.adE(this.Fzs);
          paramIntent = com.tencent.mm.ui.tools.b.h(this, paramIntent, com.tencent.mm.plugin.image.d.bbW());
          Log.i("MicroMsg.ScanUI", "select: [%s]", new Object[] { paramIntent });
          if (!Util.isNullOrNil(paramIntent))
          {
            l1 = System.currentTimeMillis();
            com.tencent.qbar.c.Zmn.aAj(com.tencent.qbar.c.Zmh);
            com.tencent.qbar.e.inE().a(this, l1, paramIntent, new e.b()
            {
              public final void a(final long paramAnonymousLong, e.d paramAnonymousd)
              {
                final List localList2 = null;
                AppMethodBeat.i(222046);
                if (paramAnonymousd != null) {}
                for (final List localList1 = paramAnonymousd.IMj;; localList1 = null)
                {
                  if (paramAnonymousd != null) {
                    localList2 = paramAnonymousd.ZmS;
                  }
                  if ((paramAnonymousLong == l1) && (BaseScanUI.S(BaseScanUI.this))) {
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(220910);
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
                            break label405;
                          }
                        }
                        label405:
                        for (int i = ((WxQbarNative.QBarReportMsg)localList2.get(0)).qrcodeVersion;; i = 0)
                        {
                          localBundle.putInt("result_code_version", i);
                          localBundle.putString("decode_original_image_path", BaseScanUI.22.this.IPE);
                          ad.a(BaseScanUI.b(BaseScanUI.this), true, 2, 1);
                          if (BaseScanUI.g(BaseScanUI.this))
                          {
                            localObject = new Intent();
                            ((Intent)localObject).putExtra("key_scan_result", localBundle.getString("result_content"));
                            ((Intent)localObject).putExtra("key_scan_result_raw", localBundle.getByteArray("result_raw_data"));
                            ((Intent)localObject).putExtra("key_scan_result_code_name", localBundle.getString("result_code_name"));
                            ((Intent)localObject).putExtra("key_scan_result_code_version", i);
                            BaseScanUI.this.setResult(-1, (Intent)localObject);
                            BaseScanUI.this.cIP();
                            AppMethodBeat.o(220910);
                            return;
                          }
                          localBundle.putInt("qbar_string_scan_source", 1);
                          if (BaseScanUI.c(BaseScanUI.this) != null) {
                            BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, localBundle);
                          }
                          BaseScanUI.m(BaseScanUI.this);
                          AppMethodBeat.o(220910);
                          return;
                          BaseScanUI.d(BaseScanUI.this, true);
                          BaseScanUI.i(BaseScanUI.this, true);
                          ad.a(BaseScanUI.b(BaseScanUI.this), false, 2, 1);
                          AppMethodBeat.o(220910);
                          return;
                        }
                      }
                    });
                  }
                  AppMethodBeat.o(222046);
                  return;
                }
              }
            }, this.IOZ);
          }
          AppMethodBeat.o(51756);
          return;
        }
        fDG();
      } while ((paramInt2 != 0) || (!r.aeb(this.Fzs)));
      ad.adD(this.Fzs);
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
          break label561;
        }
        ad.adE(this.Fzs);
        ad.aR(2, System.currentTimeMillis());
        localObject1 = com.tencent.mm.ui.tools.b.h(this, paramIntent, com.tencent.mm.plugin.image.d.bbW());
        l1 = System.currentTimeMillis();
        if (paramIntent != null) {
          break label555;
        }
        bool = true;
        Log.d("MicroMsg.ScanUI", "alvinluo processGoodsImage session: %d, resultCode: %d, filePath: %s, data == null: %b", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt2), localObject1, Boolean.valueOf(bool) });
        if (this.IOG != null) {
          this.IOG.setScanSource(2);
        }
        paramInt1 = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject1);
        l2 = System.currentTimeMillis();
        paramIntent = BitmapUtil.decodeFileWithSample((String)localObject1);
        l3 = System.currentTimeMillis();
        if ((paramInt1 != 90) && (paramInt1 != 270)) {
          break label652;
        }
        paramIntent = BitmapUtil.rotate(paramIntent, paramInt1);
      }
      break;
    }
    label652:
    for (;;)
    {
      Log.i("MicroMsg.ScanUI", "alvinluo processGoodsImage decode image cost: %d", new Object[] { Long.valueOf(l3 - l2) });
      if ((paramIntent != null) && (!paramIntent.isRecycled()))
      {
        localObject2 = this.IOG.getScanMaskView();
        if ((localObject2 instanceof ScanGoodsMaskView))
        {
          localObject2 = (ScanGoodsMaskView)localObject2;
          ((ScanGoodsMaskView)localObject2).IVJ = true;
          ((ScanGoodsMaskView)localObject2).IVK = false;
          ((ScanGoodsMaskView)localObject2).am(paramIntent);
        }
      }
      this.IOJ = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(218552);
          Log.i("MicroMsg.ScanUI", "alvinluo processGoodsImage onCancel and resumeScan");
          if ((BaseScanUI.c(BaseScanUI.this) instanceof com.tencent.mm.plugin.scanner.g.a))
          {
            paramAnonymousDialogInterface = (com.tencent.mm.plugin.scanner.g.a)BaseScanUI.c(BaseScanUI.this);
            long l = l1;
            com.tencent.mm.plugin.scanner.model.b localb = paramAnonymousDialogInterface.IOo;
            if (localb != null) {
              localb.PR(l);
            }
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.IOn;
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.PR(l);
            }
          }
          ad.a(2, false, System.currentTimeMillis(), true);
          BaseScanUI.s(BaseScanUI.this);
          AppMethodBeat.o(218552);
        }
      };
      if (this.IOG != null) {
        this.IOG.b(true, this.IOJ);
      }
      paramIntent = com.tencent.mm.plugin.scanner.d.a.fCz();
      Object localObject2 = this.IPr;
      Log.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask filePath: %s", new Object[] { localObject1 });
      v.a(new a.2(paramIntent, (String)localObject1, (a.c)localObject2, l1));
      AppMethodBeat.o(51756);
      return;
      bool = false;
      break label220;
      label555:
      bool = false;
      break label289;
      label561:
      fDG();
      if (paramInt2 == 0) {
        ad.adD(12);
      }
      AppMethodBeat.o(51756);
      return;
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = com.tencent.mm.ui.tools.b.h(this, paramIntent, com.tencent.mm.plugin.image.d.bbW());
      Log.i("MicroMsg.ScanUI", "alvinluo scanTranslate select image: [%s]", new Object[] { paramIntent });
      if (this.IOM == null) {
        break;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key_translate_file_path", paramIntent);
      this.IOM.c(System.currentTimeMillis(), (Bundle)localObject1);
      break;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(51741);
    Log.v("MicroMsg.ScanUI", "alvinluo onBackPressed");
    if ((this.INp != null) && (this.INp.isShowingDialog()))
    {
      this.INp.dismiss();
      AppMethodBeat.o(51741);
      return;
    }
    if ((this.IPj == null) || (!this.IPj.ILR)) {}
    for (int i = 0; i != 0; i = 1)
    {
      if (fDC()) {
        break label166;
      }
      fDG();
      AppMethodBeat.o(51741);
      return;
      Log.i("MicroMsg.ScanUI", "alvinluo cancelLoading");
      ab localab = this.IPj;
      c.a locala = localab.ILS;
      if (locala != null) {
        locala.fEM();
      }
      localab.ILS = null;
      this.IPj.as(false, false);
    }
    if (!fDC())
    {
      if (this.Fzs == 12) {
        ad.xl(false);
      }
      ad.adB(this.Fzs);
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
    xo(true);
    if ((com.tencent.mm.kernel.h.aGY().bih() == 6) || (com.tencent.mm.kernel.h.aGY().bih() == 4))
    {
      this.IOW = true;
      this.rqC = ((Vibrator)getSystemService("vibrator"));
      this.IOZ = getIntent().getIntArrayExtra("key_support_scan_code_type");
      this.IPa = getIntent().getIntExtra("key_scan_entry_scene", 0);
      this.IPb = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
      this.IPc = getIntent().getBooleanExtra("key_set_result_after_scan", false);
      this.IGo = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
      this.Fzs = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
      this.IOV = getIntent().getBooleanExtra("key_show_scan_tips", true);
      this.IOY = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.IPn = getIntent().getBooleanExtra("key_enable_multi_code", false);
      this.IPp = getIntent().getBooleanExtra("key_scan_goods_enable_dynamic_wording", false);
      this.IPf = getIntent().getBooleanExtra("key_for_jsapi_use", false);
      this.IGn = this.IGo;
      if (r.aec(this.Fzs))
      {
        this.IPe = ((BaseScanRequest)getIntent().getParcelableExtra("key_scan_request"));
        this.IOL = ad.a(this.IPe);
      }
      com.tencent.qbar.b.inA();
      com.tencent.qbar.f.inI();
      r.fFd();
      com.tencent.mm.plugin.scanner.util.d.init();
      bool = r.fFg();
      Log.i("MicroMsg.ScanUI", "alvinluo initEnableMultiCode configEnableMultiCode: %b, entryEnableMultiCode: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.IPn) });
      paramBundle = com.tencent.qbar.h.inM();
      if ((!bool) || (!this.IPn)) {
        break label452;
      }
    }
    label452:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.IPn = bool;
      com.tencent.qbar.f.Io(bool);
      initView();
      this.IOT = System.currentTimeMillis();
      EventCenter.instance.addListener(this.ubt);
      com.tencent.mm.xwebutil.c.ikh();
      ad.fDc();
      adN(1);
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramBundle = (cpy)com.tencent.mm.plugin.secdata.ui.a.a.b(this, 3, cpy.class);
      if ((paramBundle != null) && ("launch_type_scan_qrcode".equals(paramBundle.Txg)))
      {
        paramBundle = new no();
        paramBundle.ggN = 2L;
        paramBundle.gZO = 1L;
        paramBundle.bpa();
        com.tencent.mm.util.c localc = com.tencent.mm.util.c.Yyz;
        com.tencent.mm.util.c.a(paramBundle);
      }
      AppMethodBeat.o(51729);
      return;
      this.IOW = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51755);
    Log.i("MicroMsg.ScanUI", "onDestroy()");
    super.onDestroy();
    EventCenter.instance.removeListener(this.ubt);
    if (this.IOM != null)
    {
      this.IOM.destroy();
      this.IOM = null;
    }
    if (this.IOG != null) {
      this.IOG.onDestroy();
    }
    if ((this.INp != null) && (this.INp.isShowingDialog())) {
      this.INp.dismiss();
    }
    if ((this.qXn != null) && (this.qXn.isShowing())) {
      this.qXn.bYF();
    }
    if (this.yUU != null) {
      this.yUU.b(this.tCp);
    }
    adN(2);
    AppMethodBeat.o(51755);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51753);
    super.onPause();
    Log.i("MicroMsg.ScanUI", "alvinluo onPause needPauseScan: %b", new Object[] { Boolean.valueOf(this.IPg) });
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (this.IOG != null)
    {
      this.IOG.onPause();
      if (this.IPg) {
        this.IOG.TL();
      }
    }
    if (this.IPl.hlu == 0L) {
      at(false, false);
    }
    com.tencent.qbar.c.Zmm.cig();
    Object localObject = j.IZt;
    Log.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (((j)localObject).mSensorManager != null)
    {
      Log.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      ((j)localObject).mSensorManager.unregisterListener((SensorEventListener)localObject);
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (this.INp != null)
    {
      localObject = this.INp.IHh;
      if (localObject != null)
      {
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onPause set canMeasured false");
        ((BaseBoxDialogView)localObject).Bqr = false;
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
        this.IOQ = false;
        com.tencent.mm.ui.base.h.a(this, getString(l.i.permission_camera_request_again_msg), getString(l.i.permission_tips_title), getString(l.i.jump_to_settings), getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169978);
            paramAnonymousDialogInterface = BaseScanUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/scanner/ui/BaseScanUI$25", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$25", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            BaseScanUI.Q(BaseScanUI.this);
            BaseScanUI.this.finish();
            AppMethodBeat.o(169978);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169979);
            BaseScanUI.Q(BaseScanUI.this);
            BaseScanUI.this.finish();
            AppMethodBeat.o(169979);
          }
        });
        AppMethodBeat.o(51752);
        return;
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
        {
          this.IOR = false;
          com.tencent.mm.ui.base.h.a(this, getString(l.i.permission_location_request_again_msg), getString(l.i.permission_tips_title), getString(l.i.jump_to_settings), getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51705);
              paramAnonymousDialogInterface = BaseScanUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/scanner/ui/BaseScanUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              BaseScanUI.R(BaseScanUI.this);
              BaseScanUI.this.finish();
              AppMethodBeat.o(51705);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51706);
              BaseScanUI.R(BaseScanUI.this);
              BaseScanUI.this.finish();
              AppMethodBeat.o(51706);
            }
          });
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51751);
    super.onResume();
    Log.i("MicroMsg.ScanUI", "alvinluo BaseScanUI onResume needPauseScan: %b", new Object[] { Boolean.valueOf(this.IPg) });
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    Object localObject = j.IZt;
    Log.i("MicroMsg.ScanStableDetector", "start detect scan stable");
    if (((j)localObject).mSensorManager != null)
    {
      ((j)localObject).IZr = 0;
      ((j)localObject).IZq[0] = 0.0F;
      ((j)localObject).IZq[1] = 0.0F;
      ((j)localObject).IZq[2] = 0.0F;
      Log.i("MicroMsg.ScanStableDetector", "register accelerate listener");
      ((j)localObject).mSensorManager.registerListener((SensorEventListener)localObject, ((j)localObject).IZp, 50000);
    }
    Log.i("MicroMsg.ScanUI", "should check camera %s, location %s", new Object[] { Boolean.valueOf(this.IOQ), Boolean.valueOf(this.IOR) });
    boolean bool;
    int i;
    if ((this.IOQ) || (this.IOR)) {
      if (this.IOQ)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
        Log.i("MicroMsg.ScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          this.IMa = false;
          i = 0;
          if (i != 0)
          {
            ad.xm(this.IMa);
            if (com.tencent.mm.compatible.e.b.avv()) {
              break label368;
            }
            com.tencent.mm.ui.base.h.a(this, getString(l.i.permission_camera_request_again_msg), getString(l.i.permission_tips_title), getString(l.i.jump_to_settings), getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(169976);
                paramAnonymousDialogInterface = BaseScanUI.this;
                Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/scanner/ui/BaseScanUI$23", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$23", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                BaseScanUI.Q(BaseScanUI.this);
                BaseScanUI.this.finish();
                AppMethodBeat.o(169976);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(169977);
                BaseScanUI.Q(BaseScanUI.this);
                BaseScanUI.this.finish();
                AppMethodBeat.o(169977);
              }
            });
          }
        }
      }
    }
    for (;;)
    {
      getWindow().addFlags(128);
      if (this.INp == null) {
        break label446;
      }
      localObject = this.INp.IHh;
      if (localObject == null) {
        break label446;
      }
      ((BaseBoxDialogView)localObject).Bqr = true;
      AppMethodBeat.o(51751);
      return;
      if (this.IOR)
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
      Log.i("MicroMsg.ScanUI", "alvinluo onResumeAfterChkPermission needPauseScan: %b", new Object[] { Boolean.valueOf(this.IPg) });
      if (!this.IPg)
      {
        this.IOG.onResume();
        this.IOK.xx(true);
        xp(true);
      }
      com.tencent.mm.kernel.h.aHF().a(this.IPu);
      dBp();
      EventCenter.instance.addListener(this.IPv);
    }
    label446:
    AppMethodBeat.o(51751);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(51754);
    super.onStop();
    if (this.IOG != null) {
      this.IOG.onStop();
    }
    this.IOH.fEn();
    com.tencent.mm.kernel.h.aHF().b(this.IPu);
    EventCenter.instance.removeListener(this.IPv);
    getWindow().clearFlags(128);
    AppMethodBeat.o(51754);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void u(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(219696);
    Log.i("MicroMsg.ScanUI", "alvinluo showInfoView type: %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    boolean bool;
    label96:
    int i;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
    {
      if (this.ILP != null)
      {
        this.ILP.IXZ = this.IOG.getTextrueView();
        localObject1 = this.ILP;
        if (paramInt != 3) {
          break label564;
        }
        bool = true;
        ((ScanSharedMaskView)localObject1).setAnimateBackgroundView(bool);
      }
      this.IPg = true;
      if (paramInt != 3) {
        break label570;
      }
      bool = true;
      this.IOK.xx(false);
      this.IOK.b(bool, null);
      if (this.IPj != null)
      {
        Object localObject2 = this.IPj;
        kotlin.g.b.p.k(this, "context");
        localObject1 = ((ab)localObject2).ILO;
        if (localObject1 == null) {
          break label576;
        }
        localObject1 = ((BaseScanMaskView)localObject1).getTargetSuccessMarkView();
        label153:
        Object localObject3 = ((ab)localObject2).ILQ;
        if (localObject3 != null) {
          ((ScanInfoMaskView)localObject3).setAnchorView((View)localObject1);
        }
        localObject1 = ((ab)localObject2).ILP;
        if (localObject1 != null)
        {
          localObject1 = ((ScanSharedMaskView)localObject1).contentLayout;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("contentLayout");
          }
          n.a((View)localObject1, 0.0F, 1.0F, 200L, null);
        }
        localObject1 = ((ab)localObject2).ILO;
        if (localObject1 != null) {
          ((BaseScanMaskView)localObject1).fEy();
        }
        localObject1 = ((ab)localObject2).b(this, paramInt, paramBundle);
        ((ab)localObject2).ILT = paramInt;
        paramBundle = ((ab)localObject2).ILQ;
        if (paramBundle != null)
        {
          kotlin.g.b.p.k(localObject1, "viewParams");
          bool = ((com.tencent.mm.plugin.scanner.view.a.a)localObject1).Jaw;
          Log.i("MicroMsg.ScanInfoMaskView", "alvinluo showInfoView needTranslateInfoIcon: %b, showTips: %b, title: %s, subTitle: %s", new Object[] { Boolean.valueOf(paramBundle.IXx), Boolean.valueOf(bool), ((com.tencent.mm.plugin.scanner.view.a.a)localObject1).title, ((com.tencent.mm.plugin.scanner.view.a.a)localObject1).tsf });
          localObject2 = paramBundle.HyS;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("infoLayout");
          }
          localObject3 = (TextView)((View)localObject2).findViewById(l.f.IDv);
          if (localObject3 != null) {
            ((TextView)localObject3).setText((CharSequence)((com.tencent.mm.plugin.scanner.view.a.a)localObject1).title);
          }
          localObject2 = (TextView)((View)localObject2).findViewById(l.f.IDu);
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText((CharSequence)((com.tencent.mm.plugin.scanner.view.a.a)localObject1).tsf);
            if (!((com.tencent.mm.plugin.scanner.view.a.a)localObject1).Jaw) {
              break label582;
            }
            i = 0;
            label410:
            ((TextView)localObject2).setVisibility(i);
          }
          localObject2 = paramBundle.mrD;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("infoIcon");
          }
          ((ImageView)localObject2).setImageResource(((com.tencent.mm.plugin.scanner.view.a.a)localObject1).Jax);
          localObject2 = paramBundle.IXm;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("opButton");
          }
          if (!((com.tencent.mm.plugin.scanner.view.a.a)localObject1).Jay) {
            break label588;
          }
          i = 0;
          label470:
          ((TextView)localObject2).setVisibility(i);
          localObject2 = paramBundle.IXm;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("opButton");
          }
          ((TextView)localObject2).setOnClickListener(((com.tencent.mm.plugin.scanner.view.a.a)localObject1).Jaz);
          localObject1 = paramBundle.BOd;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("loadingLayout");
          }
          ((View)localObject1).setVisibility(8);
          if (paramBundle.IXx) {
            break label594;
          }
          paramBundle.IXx = false;
          paramBundle.xB(false);
        }
      }
    }
    for (;;)
    {
      if (paramInt == 3) {
        ad.jg(4, this.Fzs);
      }
      AppMethodBeat.o(219696);
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
      paramBundle.IXs = false;
      paramBundle.IXt = true;
      localObject1 = paramBundle.HyS;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("infoLayout");
      }
      ((View)localObject1).setVisibility(0);
      paramBundle.setVisibility(4);
      paramBundle.post((Runnable)new ScanInfoMaskView.d(paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI
 * JD-Core Version:    0.7.0.1
 */