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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.b.a.im;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.BoxDialogView;
import com.tencent.mm.plugin.scanner.c.a.2;
import com.tencent.mm.plugin.scanner.c.a.c;
import com.tencent.mm.plugin.scanner.d.d.a;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanNetworkMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanScrollTabView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.b.b;
import com.tencent.mm.plugin.scanner.ui.widget.b.c;
import com.tencent.mm.plugin.scanner.ui.widget.b.d;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ao;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.e.b;
import d.g.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class BaseScanUI
  extends MMActivity
  implements d.a, com.tencent.mm.plugin.scanner.view.b
{
  private FrameLayout container;
  private Vibrator njY;
  private com.tencent.mm.sdk.b.c<xh> oCV;
  private boolean wWa;
  private boolean wWb;
  private ScanNetworkMaskView wZR;
  private boolean wZZ;
  private boolean xbA;
  private boolean xbB;
  private long xbC;
  private int xbD;
  private boolean xbE;
  private boolean xbF;
  private boolean xbG;
  private boolean xbH;
  private boolean xbI;
  private int[] xbJ;
  private int xbK;
  private boolean xbL;
  private boolean xbM;
  private boolean xbN;
  private BaseScanRequest xbO;
  private boolean xbP;
  private boolean xbQ;
  private boolean xbR;
  private boolean xbS;
  private x xbT;
  private im xbU;
  private int xbV;
  private boolean xbW;
  private boolean xbX;
  private ScanUIRectView.a xbY;
  private a.c xbZ;
  private ScanUIRectView xbn;
  private ScannerFlashSwitcher xbo;
  private View xbp;
  private DialogInterface.OnCancelListener xbq;
  private View xbr;
  private ImageView xbs;
  private ImageView xbt;
  private TextView xbu;
  private com.tencent.mm.plugin.scanner.box.e xbv;
  private com.tencent.mm.plugin.scanner.d.e xbw;
  private com.tencent.mm.plugin.scanner.ui.widget.b xbx;
  private boolean xby;
  private boolean xbz;
  private com.tencent.mm.plugin.scanner.d.a.a xca;
  private com.tencent.mm.plugin.scanner.box.b xcb;
  private n xcc;
  private com.tencent.mm.sdk.b.c xcd;
  
  public BaseScanUI()
  {
    AppMethodBeat.i(51728);
    this.xbv = null;
    this.xby = false;
    this.xbz = true;
    this.xbA = true;
    this.xbB = false;
    this.wZZ = true;
    this.xbE = true;
    this.xbF = true;
    this.xbG = true;
    this.xbH = true;
    this.xbI = false;
    this.xbQ = false;
    this.xbR = true;
    this.xbS = true;
    this.xbT = new x();
    this.xbU = new im();
    this.xbW = false;
    this.xbX = false;
    this.xbY = new ScanUIRectView.a()
    {
      public final void e(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51682);
        if (!BaseScanUI.a(BaseScanUI.this))
        {
          ac.w("MicroMsg.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", new Object[] { Integer.valueOf(BaseScanUI.b(BaseScanUI.this)) });
          AppMethodBeat.o(51682);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          ac.i("MicroMsg.ScanUI", "scan code cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)) });
          Object localObject2 = paramAnonymousBundle.getParcelableArrayList("result_qbar_result_list");
          if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0))
          {
            ac.w("MicroMsg.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
            AppMethodBeat.o(51682);
            return;
          }
          final int j = paramAnonymousBundle.getInt("result_code_point_count", 0);
          final long l = paramAnonymousBundle.getLong("decode_success_cost_time", 0L);
          z.a(BaseScanUI.b(BaseScanUI.this), true, 1, j);
          BaseScanUI.e(BaseScanUI.this);
          Object localObject1 = BaseScanUI.this;
          if (j > 1) {}
          for (boolean bool = true;; bool = false)
          {
            BaseScanUI.a((BaseScanUI)localObject1, bool);
            BaseScanUI.b(BaseScanUI.this, false);
            z.a(BaseScanUI.b(BaseScanUI.this), (List)localObject2, l);
            localObject1 = (WxQBarResult)((ArrayList)localObject2).get(0);
            if (!BaseScanUI.f(BaseScanUI.this)) {
              break label385;
            }
            if (localObject1 != null) {
              break;
            }
            ac.w("MicroMsg.ScanUI", "first Qbar result is null");
            AppMethodBeat.o(51682);
            return;
          }
          paramAnonymousBundle = ((WxQBarResult)localObject1).typeName;
          Object localObject3 = new oy();
          localObject2 = ((WxQBarResult)localObject1).data;
          ((oy)localObject3).drz.scanResult = ((String)localObject2);
          ((oy)localObject3).drz.drB = paramAnonymousBundle;
          ((oy)localObject3).drz.drx = 0;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("key_scan_result", (String)localObject2);
          ((Intent)localObject3).putExtra("key_scan_result_raw", ((WxQBarResult)localObject1).rawData);
          ((Intent)localObject3).putExtra("key_scan_result_code_name", paramAnonymousBundle);
          ((Intent)localObject3).putExtra("key_scan_result_code_version", ((WxQBarResult)localObject1).JQA);
          BaseScanUI.this.setResult(-1, (Intent)localObject3);
          BaseScanUI.this.bRD();
          AppMethodBeat.o(51682);
          return;
          label385:
          paramAnonymousBundle.putInt("qbar_string_scan_source", 0);
          if ((j > 0) && (BaseScanUI.g(BaseScanUI.this) != null))
          {
            localObject3 = (ScanDecodeFrameData)paramAnonymousBundle.getParcelable("decode_success_frame_data");
            if (localObject3 != null) {
              BaseScanUI.g(BaseScanUI.this).setDecodeSuccessFrameData((ScanDecodeFrameData)localObject3);
            }
            localObject3 = BaseScanUI.this;
            Object localObject4;
            int i;
            if (j > 1)
            {
              bool = true;
              BaseScanUI.c((BaseScanUI)localObject3, bool);
              if (j > 1)
              {
                BaseScanUI.a(BaseScanUI.this, BaseScanUI.h(BaseScanUI.this), false);
                BaseScanUI.i(BaseScanUI.this);
                BaseScanUI.j(BaseScanUI.this);
              }
              BaseScanUI.d(BaseScanUI.this, true);
              BaseScanUI.g(BaseScanUI.this).setSuccessMarkClickListener(new aa()
              {
                public final void Ne(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(169958);
                  ac.i("MicroMsg.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  if ((paramAnonymous2Int < this.xcf.size()) && (j > 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.b(BaseScanUI.this, true);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, l, (WxQBarResult)this.xcf.get(paramAnonymous2Int));
                    z.k(2, paramAnonymous2Int, this.xch);
                    z.dzO();
                  }
                  AppMethodBeat.o(169958);
                }
              });
              BaseScanUI.k(BaseScanUI.this);
              localObject3 = BaseScanUI.g(BaseScanUI.this);
              if (com.tencent.mm.plugin.scanner.util.d.dBp())
              {
                if (((ScanUIRectView)localObject3).xfw == null)
                {
                  ((ScanUIRectView)localObject3).xfw = new ScanDebugView(((ScanUIRectView)localObject3).getContext());
                  ((ScanUIRectView)localObject3).addView(((ScanUIRectView)localObject3).xfw);
                }
                if (((ScanUIRectView)localObject3).xfw != null)
                {
                  localObject4 = ((ScanUIRectView)localObject3).xfw;
                  if (paramAnonymousBundle != null)
                  {
                    localObject3 = paramAnonymousBundle.getString("decode_debug_string");
                    CharSequence localCharSequence = (CharSequence)localObject3;
                    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
                      break label719;
                    }
                    i = 1;
                    label638:
                    if (i != 0) {
                      break label725;
                    }
                    ((ScanDebugView)localObject4).setVisibility(0);
                    localObject4 = ((ScanDebugView)localObject4).xjY;
                    if (localObject4 == null) {
                      k.aVY("debugInfo");
                    }
                    ((TextView)localObject4).setText((CharSequence)localObject3);
                  }
                }
              }
            }
            for (;;)
            {
              BaseScanUI.g(BaseScanUI.this).a(localObject2, new com.tencent.mm.plugin.scanner.view.c()
              {
                public final void dAf()
                {
                  AppMethodBeat.i(169959);
                  if ((j == 1) || (this.xcf.size() == 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.b(BaseScanUI.this, true);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.val$result, l);
                    z.k(1, 0, this.xch);
                  }
                  AppMethodBeat.o(169959);
                }
              });
              AppMethodBeat.o(51682);
              return;
              bool = false;
              break;
              label719:
              i = 0;
              break label638;
              label725:
              ((ScanDebugView)localObject4).setVisibility(8);
              localObject3 = ((ScanDebugView)localObject4).xjY;
              if (localObject3 == null) {
                k.aVY("debugInfo");
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
    this.xbZ = new a.c()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51709);
        if (BaseScanUI.l(BaseScanUI.this))
        {
          ac.w("MicroMsg.ScanUI", "alvinluo onScanSuccess isScrolling and ignore");
          AppMethodBeat.o(51709);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          BaseScanUI.m(BaseScanUI.this);
          int i = paramAnonymousBundle.getInt("scan_source", 0);
          ac.i("MicroMsg.ScanUI", "alvinluo onScanSuccess cost time %d, scanImageCount: %d, source: %d, session: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)), Integer.valueOf(BaseScanUI.n(BaseScanUI.this)), Integer.valueOf(i), Long.valueOf(paramAnonymousLong) });
          if ((i == 1) && (!BaseScanUI.o(BaseScanUI.this)))
          {
            if ((BaseScanUI.p(BaseScanUI.this) instanceof ScanGoodsRequest))
            {
              paramAnonymousBundle.putParcelable("key_scan_request", BaseScanUI.p(BaseScanUI.this));
              paramAnonymousBundle.putInt("key_scan_goods_mode", ((ScanGoodsRequest)BaseScanUI.p(BaseScanUI.this)).mode);
            }
            BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, paramAnonymousBundle);
            AppMethodBeat.o(51709);
            return;
          }
          if (i == 2) {
            BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(51709);
      }
      
      public final void x(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(51710);
        ac.e("MicroMsg.ScanUI", "alvinluo onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousString });
        String str = paramAnonymousString;
        if (bs.isNullOrNil(paramAnonymousString)) {
          str = BaseScanUI.this.getResources().getString(2131762888);
        }
        com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(51708);
            BaseScanUI.q(BaseScanUI.this);
            z.MY(BaseScanUI.b(BaseScanUI.this));
            AppMethodBeat.o(51708);
          }
        });
        z.a(2, false, System.currentTimeMillis());
        AppMethodBeat.o(51710);
      }
    };
    this.xca = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void b(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161970);
        String str;
        if (paramAnonymousInt1 == 2)
        {
          z.N(false, paramAnonymousInt1);
          BaseScanUI.r(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          BaseScanUI.g(BaseScanUI.this).a(false, null);
          str = paramAnonymousString;
          if (bs.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(2131762888);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51717);
              BaseScanUI.q(BaseScanUI.this);
              z.MY(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(51717);
            }
          });
          AppMethodBeat.o(161970);
          return;
        }
        if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == 1003))
        {
          ac.e("MicroMsg.ScanUI", "alvinluo onScanResultFailed stop upload and show alert");
          if (BaseScanUI.c(BaseScanUI.this) != null) {
            BaseScanUI.c(BaseScanUI.this).y(paramAnonymousLong, false);
          }
          BaseScanUI.r(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          str = paramAnonymousString;
          if (bs.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(2131762889);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(161969);
              BaseScanUI.q(BaseScanUI.this);
              z.MY(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(161969);
            }
          });
        }
        AppMethodBeat.o(161970);
      }
      
      public final void b(u paramAnonymousu)
      {
        AppMethodBeat.i(51718);
        if (BaseScanUI.b(BaseScanUI.this) != 12)
        {
          ac.i("MicroMsg.ScanUI", "alvnluo onScanResultSuccess not SELECT_SCAN_MODE_GOODS and ignore");
          AppMethodBeat.o(51718);
          return;
        }
        if ((BaseScanUI.l(BaseScanUI.this)) || ((paramAnonymousu.dbL == 1) && (BaseScanUI.o(BaseScanUI.this))))
        {
          ac.w("MicroMsg.ScanUI", "alvinluo onScanResultSuccess source:%d, isScrolling: %b or needPauseScan: %b and ignore", new Object[] { Integer.valueOf(paramAnonymousu.dbL), Boolean.valueOf(BaseScanUI.l(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.o(BaseScanUI.this)) });
          AppMethodBeat.o(51718);
          return;
        }
        BaseScanUI.a(BaseScanUI.this, paramAnonymousu);
        AppMethodBeat.o(51718);
      }
    };
    this.xcb = new com.tencent.mm.plugin.scanner.box.b()
    {
      public final void a(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(199520);
        ac.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onDismiss exitType: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseScanUI.t(BaseScanUI.this);
        BaseScanUI.u(BaseScanUI.this);
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.s(BaseScanUI.this), true);
        BaseScanUI.q(BaseScanUI.this);
        BaseScanUI.e(BaseScanUI.this, true);
        z.wD(System.currentTimeMillis());
        z.b(paramAnonymousInt, BaseScanUI.p(BaseScanUI.this));
        z.MY(12);
        AppMethodBeat.o(199520);
      }
      
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(199521);
        ac.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onCancel");
        BaseScanUI.d(BaseScanUI.this, false);
        BaseScanUI.t(BaseScanUI.this);
        BaseScanUI.u(BaseScanUI.this);
        AppMethodBeat.o(199521);
      }
      
      public final void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(199519);
        ac.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onShow");
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.s(BaseScanUI.this), false);
        BaseScanUI.e(BaseScanUI.this, false);
        z.wC(System.currentTimeMillis());
        AppMethodBeat.o(199519);
      }
    };
    this.xcc = new n.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(199511);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199510);
            ac.i("MicroMsg.ScanUI", "onNetWorkChange %d", new Object[] { Integer.valueOf(g.agi().aBK()) });
            ScanUIRectView localScanUIRectView;
            int i;
            if (BaseScanUI.g(BaseScanUI.this) != null)
            {
              localScanUIRectView = BaseScanUI.g(BaseScanUI.this);
              i = paramAnonymousInt;
              if ((g.agi().aBK() != 6) && (g.agi().aBK() != 4)) {
                break label152;
              }
              localScanUIRectView.xbG = true;
              if (!o.Nu(localScanUIRectView.mode)) {
                localScanUIRectView.onResume();
              }
            }
            for (;;)
            {
              if (localScanUIRectView.wZP != null) {
                localScanUIRectView.wZP.onNetworkChange(i);
              }
              if ((g.agi().aBK() != 6) && (g.agi().aBK() != 4)) {
                break label202;
              }
              if (!BaseScanUI.H(BaseScanUI.this)) {
                break;
              }
              AppMethodBeat.o(199510);
              return;
              label152:
              localScanUIRectView.xbG = false;
              if (!o.Nu(localScanUIRectView.mode)) {
                localScanUIRectView.onPause();
              }
            }
            BaseScanUI.i(BaseScanUI.this, true);
            BaseScanUI.I(BaseScanUI.this);
            AppMethodBeat.o(199510);
            return;
            label202:
            if (!BaseScanUI.H(BaseScanUI.this))
            {
              AppMethodBeat.o(199510);
              return;
            }
            BaseScanUI.i(BaseScanUI.this, false);
            BaseScanUI.I(BaseScanUI.this);
            AppMethodBeat.o(199510);
          }
        });
        AppMethodBeat.o(199511);
      }
    };
    this.xcd = new com.tencent.mm.sdk.b.c() {};
    this.oCV = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(51728);
  }
  
  private void Nf(int paramInt)
  {
    AppMethodBeat.i(51735);
    ac.i("MicroMsg.ScanUI", "alvinluo operateFlash operation: %d", new Object[] { Integer.valueOf(paramInt) });
    rz localrz = new rz();
    localrz.duW.cZu = paramInt;
    com.tencent.mm.sdk.b.a.GpY.l(localrz);
    if (this.xbo != null)
    {
      if (paramInt == 1)
      {
        this.xbo.dAK();
        AppMethodBeat.o(51735);
        return;
      }
      this.xbo.dAL();
    }
    AppMethodBeat.o(51735);
  }
  
  private void Ng(int paramInt)
  {
    AppMethodBeat.i(199528);
    z.a(this.xbD, this.xbO, paramInt);
    AppMethodBeat.o(199528);
  }
  
  private void Z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199527);
    ac.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance success: %b, isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.FALSE });
    Object localObject = this.xbU;
    long l;
    if (paramBoolean1)
    {
      l = 1L;
      ((im)localObject).ela = l;
      this.xbU.elb = (System.currentTimeMillis() - this.xbC);
      localObject = this.xbU;
      if (!this.xbn.dAy()) {
        break label369;
      }
      l = 0L;
      label83:
      ((im)localObject).elc = l;
      this.xbU.elh = this.xbD;
      this.xbU.eld = com.tencent.qbar.c.JQr.JQu;
      if (com.tencent.mm.plugin.scanner.util.i.xlZ.dBr() > 0L) {
        this.xbU.elg = (com.tencent.mm.plugin.scanner.util.i.xlZ.dBr() - this.xbC);
      }
      this.xbU.aHZ();
      if (o.Nu(this.xbD))
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(1229L, 0L, 1L);
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        if (!paramBoolean1) {
          break label374;
        }
        l = 1L;
        label184:
        ((com.tencent.mm.plugin.report.service.h)localObject).n(1229L, 1L, l);
        if (paramBoolean1)
        {
          if (!this.xbn.dAy()) {
            break label379;
          }
          com.tencent.mm.plugin.report.service.h.wUl.n(1229L, 5L, 1L);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.n(1229L, 7L, this.xbU.elb);
      com.tencent.mm.plugin.report.service.h.wUl.n(1229L, 9L, this.xbU.eld);
      if ((paramBoolean1) && (paramBoolean2))
      {
        ac.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance scanTime: %s, totalFrames: %d", new Object[] { Long.valueOf(this.xbU.elb), Long.valueOf(this.xbU.eld) });
        com.tencent.mm.plugin.report.service.h.wUl.n(1229L, 11L, 1L);
        com.tencent.mm.plugin.report.service.h.wUl.n(1229L, 12L, this.xbU.elb);
        com.tencent.mm.plugin.report.service.h.wUl.n(1229L, 14L, this.xbU.eld);
      }
      AppMethodBeat.o(199527);
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
      com.tencent.mm.plugin.report.service.h.wUl.n(1229L, 3L, 1L);
    }
  }
  
  private void a(View paramView, boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(199525);
    if (paramView == null)
    {
      AppMethodBeat.o(199525);
      return;
    }
    if ((paramBoolean) && (paramView.getAlpha() != 0.0F))
    {
      ac.w("MicroMsg.ScanUI", "alvinluo animateAlpha show ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(199525);
      return;
    }
    if ((!paramBoolean) && (paramView.getAlpha() != 1.0F))
    {
      ac.w("MicroMsg.ScanUI", "alvinluo animateAlpha hide ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(199525);
      return;
    }
    ac.v("MicroMsg.ScanUI", "alvinluo animateAlpha show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
    paramAnimatorListener = new BaseScanUI.10(this, paramAnimatorListener, paramView, paramBoolean);
    paramView.setVisibility(0);
    if (paramBoolean)
    {
      f1 = 0.0F;
      paramView.setAlpha(f1);
      paramView = paramView.animate();
      if (!paramBoolean) {
        break label193;
      }
    }
    label193:
    for (float f1 = f2;; f1 = 0.0F)
    {
      paramView.alpha(f1).setListener(paramAnimatorListener).setDuration(200L).start();
      AppMethodBeat.o(199525);
      return;
      f1 = 1.0F;
      break;
    }
  }
  
  private void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(51750);
    ac.v("MicroMsg.ScanUI", "alvinluo showFlash show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if ((this.xbo != null) && (!this.xbo.isShown()))
      {
        this.xbn.dAD();
        if (paramBoolean2) {
          this.xbo.show();
        }
        for (;;)
        {
          com.tencent.qbar.c.JQr.aea(1);
          z.gW(this.xbD, 1);
          AppMethodBeat.o(51750);
          return;
          this.xbo.setVisibility(0);
        }
      }
    }
    else if ((this.xbo != null) && (!this.xbo.Tz))
    {
      this.xbn.dAE();
      if (paramBoolean2)
      {
        this.xbo.hide();
        AppMethodBeat.o(51750);
        return;
      }
      this.xbo.setVisibility(8);
    }
    AppMethodBeat.o(51750);
  }
  
  private void b(boolean paramBoolean, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(199524);
    ac.v("MicroMsg.ScanUI", "alvinluo switchCloseView isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.xbu.setAlpha(0.0F);
      a(this.xbs, false, new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(199499);
          BaseScanUI.a(BaseScanUI.this, BaseScanUI.B(BaseScanUI.this), true);
          if (paramAnimatorListener != null) {
            paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
          }
          AppMethodBeat.o(199499);
        }
      });
      AppMethodBeat.o(199524);
      return;
    }
    a(this.xbu, false, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(199500);
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.C(BaseScanUI.this), true);
        if (paramAnimatorListener != null) {
          paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(199500);
      }
    });
    AppMethodBeat.o(199524);
  }
  
  private void dAa()
  {
    AppMethodBeat.i(169986);
    if ((this.xbT != null) && (this.xbn != null)) {
      this.xbT.a(this.xbn.getScanMaskView(), this.xbn.getSharedMaskView(), this.wZR);
    }
    AppMethodBeat.o(169986);
  }
  
  private void dAb()
  {
    AppMethodBeat.i(51748);
    if ((o.Nu(this.xbD)) || (dzY()) || (dzX())) {}
    for (int i = 0; i != 0; i = 1)
    {
      pX(this.xbG);
      AppMethodBeat.o(51748);
      return;
    }
    pX(true);
    AppMethodBeat.o(51748);
  }
  
  private void dAc()
  {
    AppMethodBeat.i(169987);
    int i = 0;
    if (o.Nu(this.xbD)) {
      i = com.tencent.qbar.c.JQo;
    }
    for (;;)
    {
      com.tencent.qbar.c.JQr.aeb(i);
      AppMethodBeat.o(169987);
      return;
      if (this.xbD == 12) {
        i = com.tencent.qbar.c.JQp;
      } else if (this.xbD == 3) {
        i = com.tencent.qbar.c.JQq;
      }
    }
  }
  
  private void dAd()
  {
    AppMethodBeat.i(51757);
    ac.i("MicroMsg.ScanUI", "alvinluo resumeScan");
    this.xbQ = false;
    if (this.xbn != null) {
      this.xbn.onResume();
    }
    setEnableSwitchTab(true);
    AppMethodBeat.o(51757);
  }
  
  private void dzS()
  {
    AppMethodBeat.i(51732);
    ScanSharedMaskView localScanSharedMaskView = this.xbn.getSharedMaskView();
    if (localScanSharedMaskView == null)
    {
      AppMethodBeat.o(51732);
      return;
    }
    if (!this.wWa)
    {
      localScanSharedMaskView.getGalleryButton().setVisibility(0);
      localScanSharedMaskView.setOnGalleryClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169984);
          BaseScanUI.w(BaseScanUI.this);
          AppMethodBeat.o(169984);
        }
      });
      AppMethodBeat.o(51732);
      return;
    }
    localScanSharedMaskView.getGalleryButton().setVisibility(8);
    AppMethodBeat.o(51732);
  }
  
  private void dzT()
  {
    AppMethodBeat.i(51734);
    ScanSharedMaskView localScanSharedMaskView = this.xbn.getSharedMaskView();
    if (localScanSharedMaskView != null) {
      this.xbo = localScanSharedMaskView.getFlashSwitcherView();
    }
    if (this.xbo != null)
    {
      this.xbo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51727);
          com.tencent.qbar.c.JQr.aea(2);
          if (!BaseScanUI.x(BaseScanUI.this).Tz) {
            BaseScanUI.a(BaseScanUI.this, 1);
          }
          for (;;)
          {
            z.gW(BaseScanUI.b(BaseScanUI.this), 2);
            AppMethodBeat.o(51727);
            return;
            BaseScanUI.a(BaseScanUI.this, 2);
          }
        }
      });
      this.xbn.setFlashStatus(this.xbo.cBT);
      if (this.xbD == 3)
      {
        dzU();
        this.xbo.hide();
      }
    }
    AppMethodBeat.o(51734);
  }
  
  private void dzU()
  {
    AppMethodBeat.i(51736);
    ac.d("MicroMsg.ScanUI", "alvinluo checkAndOperateFlash operation: %d", new Object[] { Integer.valueOf(2) });
    if (this.xbo.Tz) {
      Nf(2);
    }
    AppMethodBeat.o(51736);
  }
  
  private void dzV()
  {
    AppMethodBeat.i(51737);
    if (((o.Nu(this.xbD)) || (dzX()) || (dzY())) && (!this.wWb) && (!this.xbP))
    {
      this.xbt.setVisibility(0);
      this.xbt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51685);
          BaseScanUI.y(BaseScanUI.this);
          AppMethodBeat.o(51685);
        }
      });
      AppMethodBeat.o(51737);
      return;
    }
    this.xbt.setVisibility(8);
    AppMethodBeat.o(51737);
  }
  
  private void dzW()
  {
    AppMethodBeat.i(199523);
    ac.i("MicroMsg.ScanUI", "alvinluo processMultiCodeCancel isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.xbX) });
    if (!this.xbX)
    {
      AppMethodBeat.o(199523);
      return;
    }
    this.xbX = false;
    a(this.xbt, true, null);
    b(false, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(199498);
        BaseScanUI.a(BaseScanUI.this, System.currentTimeMillis());
        BaseScanUI.q(BaseScanUI.this);
        AppMethodBeat.o(199498);
      }
    });
    pV(true);
    if (o.Nu(this.xbD))
    {
      z.k(3, -1, 0L);
      z.dzN();
    }
    AppMethodBeat.o(199523);
  }
  
  private boolean dzX()
  {
    return this.xbD == 12;
  }
  
  private boolean dzY()
  {
    return this.xbD == 3;
  }
  
  private void dzZ()
  {
    AppMethodBeat.i(51739);
    switch (this.xbD)
    {
    default: 
      this.xbn.setScanCallback(null);
      AppMethodBeat.o(51739);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.xbn.setScanCallback(this.xbY);
      this.xbw = new com.tencent.mm.plugin.scanner.d.d(this.xbD, this.xbK, this.xbn, this, this);
      AppMethodBeat.o(51739);
      return;
    }
    this.xbn.setScanCallback(this.xbZ);
    this.xbw = new com.tencent.mm.plugin.scanner.d.a(this.xbD, this.xbn, this, this.xca);
    AppMethodBeat.o(51739);
  }
  
  private void gX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199526);
    ac.v("MicroMsg.ScanUI", "alvinluo reportSwitchTab %b", new Object[] { Boolean.valueOf(this.xbE) });
    z.gV(paramInt1, paramInt2);
    z.MR(paramInt1);
    z.MT(paramInt1);
    z.MY(paramInt1);
    AppMethodBeat.o(199526);
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
  
  private void pU(boolean paramBoolean)
  {
    AppMethodBeat.i(51731);
    if ((!paramBoolean) && (!aj.DT()))
    {
      getController().setNavigationbarColor(ao.aJ(this, 2130968578));
      AppMethodBeat.o(51731);
      return;
    }
    getController().setNavigationbarColor(getResources().getColor(2131100837));
    AppMethodBeat.o(51731);
  }
  
  private void pV(boolean paramBoolean)
  {
    AppMethodBeat.i(199522);
    if (this.xbx != null)
    {
      Object localObject = this.xbx;
      ac.i("MicroMsg.ScanScrollTabController", "alvinluo setEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).setEnableSwitchTab(paramBoolean);
      localObject = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).xkw;
      if (localObject != null)
      {
        ((ScanScrollTabView)localObject).setEnabled(paramBoolean);
        AppMethodBeat.o(199522);
        return;
      }
    }
    AppMethodBeat.o(199522);
  }
  
  private void pW(boolean paramBoolean)
  {
    AppMethodBeat.i(51747);
    if (paramBoolean)
    {
      this.xbp.setVisibility(0);
      this.xbn.cqU();
      this.xbp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199509);
          BaseScanUI.G(BaseScanUI.this);
          BaseScanUI.h(BaseScanUI.this, false);
          BaseScanUI.q(BaseScanUI.this);
          AppMethodBeat.o(199509);
        }
      });
      if (this.xbn != null) {
        this.xbn.pZ(true);
      }
      a(this.xbt, false, null);
      aa(false, true);
      AppMethodBeat.o(51747);
      return;
    }
    this.xbp.setVisibility(8);
    if (this.xbn != null) {
      this.xbn.pZ(false);
    }
    a(this.xbt, true, null);
    AppMethodBeat.o(51747);
  }
  
  private void pX(boolean paramBoolean)
  {
    AppMethodBeat.i(51749);
    ac.i("MicroMsg.ScanUI", "network change %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      pW(false);
      this.xbn.cqU();
    }
    AppMethodBeat.o(51749);
  }
  
  private void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51733);
    ac.i("MicroMsg.ScanUI", "alvinluo setEnableSwitchTab enable: %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.xbz) });
    if (this.xbx != null)
    {
      if (!paramBoolean) {
        break label95;
      }
      if (this.xbz) {
        this.xbx.setEnableSwitchTab(true);
      }
    }
    while (this.xbn != null) {
      if (paramBoolean)
      {
        if (this.xbz)
        {
          this.xbn.setEnableScrollSwitchTab(true);
          AppMethodBeat.o(51733);
          return;
          label95:
          this.xbx.setEnableSwitchTab(false);
        }
      }
      else {
        this.xbn.setEnableScrollSwitchTab(false);
      }
    }
    AppMethodBeat.o(51733);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, b.a parama)
  {
    AppMethodBeat.i(51746);
    if ((this.xbT != null) && (this.xbT.wZS)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.ScanUI", "alvinluo showLoadingView show: %b, isLoadingShow: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2) });
      this.xbQ = paramBoolean1;
      if (this.xbT != null)
      {
        this.xbT.wZT = parama;
        if (this.xbT.wZS != paramBoolean1)
        {
          this.xbT.Y(paramBoolean1, paramBoolean2);
          if (paramBoolean1)
          {
            a(this.xbt, false, null);
            b(false, null);
          }
        }
      }
      AppMethodBeat.o(51746);
      return;
    }
  }
  
  public final void bRD()
  {
    AppMethodBeat.i(51743);
    ac.i("MicroMsg.ScanUI", "finishUI");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(51743);
  }
  
  public final void dzQ()
  {
    Object localObject1 = null;
    AppMethodBeat.i(51744);
    ac.i("MicroMsg.ScanUI", "alvinluo onNetworkUnconnected");
    this.xbQ = true;
    a(this.xbt, false, null);
    b(false, null);
    if (this.xbT != null)
    {
      x localx = this.xbT;
      Object localObject2 = localx.wZP;
      if (localObject2 != null) {
        ((BaseScanMaskView)localObject2).dAZ();
      }
      localObject2 = localx.wZP;
      if (localObject2 != null) {
        localObject1 = ((BaseScanMaskView)localObject2).getTargetSuccessMarkView();
      }
      localObject2 = localx.wZR;
      if (localObject2 != null) {
        ((ScanNetworkMaskView)localObject2).setSuccessMarkView((View)localObject1);
      }
      localObject1 = localx.wZR;
      if (localObject1 != null)
      {
        ac.i("MicroMsg.ScanNetworkMaskView", "alvinluo showNoNetworkView");
        if (((ScanNetworkMaskView)localObject1).xka != null)
        {
          localObject2 = ((ScanNetworkMaskView)localObject1).xkf;
          if (localObject2 == null) {
            k.aVY("noNetworkLayout");
          }
          localObject2 = (TextView)((View)localObject2).findViewById(2131304326);
          if (localObject2 != null) {
            ((TextView)localObject2).setText(2131762851);
          }
          if ((localObject1.xkh[0] != 0) || (localObject1.xkh[1] != 0)) {
            break label197;
          }
          ((ScanNetworkMaskView)localObject1).xkj = true;
        }
      }
      for (;;)
      {
        localObject1 = localx.wZQ;
        if (localObject1 == null) {
          break;
        }
        ((ScanSharedMaskView)localObject1).qj(false);
        AppMethodBeat.o(51744);
        return;
        label197:
        ((ScanNetworkMaskView)localObject1).qe(true);
      }
    }
    AppMethodBeat.o(51744);
  }
  
  public final void dzR()
  {
    Object localObject1 = null;
    AppMethodBeat.i(51745);
    ac.i("MicroMsg.ScanUI", "alvinluo onNetworkWeak");
    this.xbQ = true;
    a(this.xbt, false, null);
    b(false, null);
    if (this.xbT != null)
    {
      x localx = this.xbT;
      Object localObject2 = localx.wZP;
      if (localObject2 != null) {
        ((BaseScanMaskView)localObject2).dBa();
      }
      localObject2 = localx.wZP;
      if (localObject2 != null) {
        localObject1 = ((BaseScanMaskView)localObject2).getTargetSuccessMarkView();
      }
      localObject2 = localx.wZR;
      if (localObject2 != null) {
        ((ScanNetworkMaskView)localObject2).setSuccessMarkView((View)localObject1);
      }
      localObject1 = localx.wZR;
      if (localObject1 != null)
      {
        ac.i("MicroMsg.ScanNetworkMaskView", "alvinluo showWeakNetworkView needAnimateWeakNetworkView: %b", new Object[] { Boolean.valueOf(((ScanNetworkMaskView)localObject1).xkm) });
        localObject2 = ((ScanNetworkMaskView)localObject1).xkf;
        if (localObject2 == null) {
          k.aVY("noNetworkLayout");
        }
        localObject2 = (TextView)((View)localObject2).findViewById(2131304326);
        if (localObject2 != null) {
          ((TextView)localObject2).setText(2131762854);
        }
        if (((ScanNetworkMaskView)localObject1).xkm) {
          break label199;
        }
        ((ScanNetworkMaskView)localObject1).xkm = true;
        ((ScanNetworkMaskView)localObject1).qe(false);
      }
      for (;;)
      {
        localObject1 = localx.wZQ;
        if (localObject1 == null) {
          break;
        }
        ((ScanSharedMaskView)localObject1).setVisibility(8);
        AppMethodBeat.o(51745);
        return;
        label199:
        ((ScanNetworkMaskView)localObject1).qe(true);
      }
    }
    AppMethodBeat.o(51745);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495307;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51730);
    this.container = ((FrameLayout)findViewById(2131304310));
    this.xbx = new com.tencent.mm.plugin.scanner.ui.widget.b(this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    Object localObject2;
    Object localObject1;
    int i;
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      getWindow().addFlags(67109888);
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.xbp = findViewById(2131304320);
      this.wZR = ((ScanNetworkMaskView)findViewById(2131304319));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(169983);
          BaseScanUI.v(BaseScanUI.this);
          AppMethodBeat.o(169983);
          return true;
        }
      });
      this.xbr = findViewById(2131306000);
      this.xbs = ((ImageView)findViewById(2131298365));
      this.xbt = ((ImageView)findViewById(2131302478));
      this.xbu = ((TextView)findViewById(2131302560));
      this.xbn = new ScanUIRectView(this);
      this.xbn.setScanRequest(this.xbO);
      localObject2 = (ScanScrollTabView)findViewById(2131304329);
      localObject1 = this.xbx;
      k.h(localObject2, "scrollTabView");
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).xkw = ((ScanScrollTabView)localObject2);
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).xkw;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).removeAllTabs();
      }
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).xkw;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)new b.c());
      }
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).xkx.clear();
      localObject2 = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).xky).iterator();
      i = 0;
      label292:
      if (!((Iterator)localObject2).hasNext()) {
        break label344;
      }
      if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).a(i, (b.b)((Iterator)localObject2).next())) {
        break label1206;
      }
      i += 1;
    }
    label1041:
    label1203:
    label1206:
    for (;;)
    {
      break label292;
      getWindow().setFlags(1024, 1024);
      break;
      label344:
      localObject1 = this.xbx;
      localObject2 = new com.tencent.mm.plugin.scanner.ui.widget.e()
      {
        public final void Ni(int paramAnonymousInt)
        {
          AppMethodBeat.i(199506);
          ac.i("MicroMsg.ScanUI", "alvinluo onTabUnSelected tabId: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (o.Nu(paramAnonymousInt)) {
            BaseScanUI.f(BaseScanUI.this, false);
          }
          BaseScanUI.Nh(paramAnonymousInt);
          if (paramAnonymousInt == 12) {
            BaseScanUI.dAe();
          }
          AppMethodBeat.o(199506);
        }
        
        public final void gY(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(199505);
          ac.i("MicroMsg.ScanUI", "alvinluo onTabSelected tabId: %d, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (!BaseScanUI.D(BaseScanUI.this)) {
            BaseScanUI.a(BaseScanUI.this, paramAnonymousInt1, paramAnonymousInt2);
          }
          for (;;)
          {
            if (BaseScanUI.b(BaseScanUI.this) != paramAnonymousInt1) {
              BaseScanUI.b(BaseScanUI.this, paramAnonymousInt1);
            }
            if (o.Nu(paramAnonymousInt1)) {
              BaseScanUI.f(BaseScanUI.this, true);
            }
            BaseScanUI.F(BaseScanUI.this);
            AppMethodBeat.o(199505);
            return;
            BaseScanUI.E(BaseScanUI.this);
          }
        }
      };
      k.h(localObject2, "tabOnSelectedListener");
      localObject2 = new b.d((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1, (com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).xkw;
      if (localObject1 != null) {
        ((ScanScrollTabView)localObject1).setOnTabChangedListener((com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      }
      localObject2 = this.xbx;
      localObject1 = new com.tencent.mm.plugin.scanner.ui.widget.d()
      {
        public final void cp(int paramAnonymousInt)
        {
          AppMethodBeat.i(199508);
          if (paramAnonymousInt == 1) {
            BaseScanUI.g(BaseScanUI.this, false);
          }
          for (;;)
          {
            ac.v("MicroMsg.ScanUI", "alvinluo onScrollStateChanged state: %d, isScrolling: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BaseScanUI.l(BaseScanUI.this)) });
            AppMethodBeat.o(199508);
            return;
            if ((paramAnonymousInt == 3) || (paramAnonymousInt == 2)) {
              BaseScanUI.g(BaseScanUI.this, true);
            }
          }
        }
        
        public final void s(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(199507);
          ac.v("MicroMsg.ScanUI", "alvinluo onScroll offsetX: %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(199507);
        }
      };
      k.h(localObject1, "tabOnScrollListener");
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).xkw;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)localObject1);
      }
      if (this.xbn != null) {
        this.xbn.setScrollTabController(this.xbx);
      }
      if ((this.xbL) || (this.xbD == 8)) {
        this.xbN = true;
      }
      label578:
      while (!com.tencent.mm.aw.b.aGe())
      {
        if (this.xbO != null)
        {
          if (this.xbO.wVX) {
            this.xbN = true;
          }
          if (this.xbO.wWa) {
            this.wWa = true;
          }
          if (this.xbO.wWb) {
            this.wWb = true;
          }
        }
        if (!this.xbN) {
          break;
        }
        localObject1 = this.xbx.xkw;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(8);
        }
        this.xbz = false;
        this.xbn.setBottomExtraHeight(0);
        setEnableSwitchTab(this.xbz);
        ac.i("MicroMsg.ScanUI", "alvinluo initView currentMode: %d, showOnlyScanCode: %b, hideScrollTab: %b, scanRequest: %s", new Object[] { Integer.valueOf(this.xbD), Boolean.valueOf(this.xbL), Boolean.valueOf(this.xbN), this.xbO });
        this.xbn.setActivity(this);
        this.container.addView(this.xbn, 0, new FrameLayout.LayoutParams(-1, -1));
        this.xbn.onCreate();
        this.xbn.setShowScanTips(this.xbF);
        this.xbn.setNetworkAvailable(this.xbG);
        this.xbn.setScanMode(this.xbD);
        this.xbn.refreshView();
        gX(this.xbD, 0);
        dAa();
        z.MY(this.xbD);
        dAc();
        if (this.xbI) {
          this.xbn.setBlackInterval(com.tencent.qbar.b.fCe());
        }
        dzS();
        dzZ();
        if ((this.xbJ != null) && (this.xbJ.length > 0)) {
          this.xbn.setScanCodeReaders(this.xbJ);
        }
        if (this.xbP) {
          this.xbn.setMyQrCodeVisible(false);
        }
        localObject2 = this.xbx;
        i = this.xbD;
        localObject1 = (Integer)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).xkz.get(Integer.valueOf(i));
        ac.i("MicroMsg.ScanScrollTabController", "alvinluo setSelectedTab tabId: %d, index: %s", new Object[] { Integer.valueOf(i), localObject1 });
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).bns = ((Integer)localObject1).intValue();
          localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).xkw;
          if (localObject2 != null) {
            ((ScanScrollTabView)localObject2).setSelectedTab(((Integer)localObject1).intValue());
          }
        }
        dzT();
        dzV();
        this.xbs.setVisibility(0);
        this.xbs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51686);
            BaseScanUI.dAe();
            BaseScanUI.e(BaseScanUI.this);
            BaseScanUI.v(BaseScanUI.this);
            z.k(3, -1, 0L);
            AppMethodBeat.o(51686);
          }
        });
        this.xbu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(199497);
            if (BaseScanUI.z(BaseScanUI.this)) {
              BaseScanUI.A(BaseScanUI.this);
            }
            AppMethodBeat.o(199497);
          }
        });
        AppMethodBeat.o(51730);
        return;
      }
      int j;
      if (o.dBv())
      {
        localObject2 = this.xbx;
        int[] arrayOfInt = new int[3];
        tmp970_968 = arrayOfInt;
        tmp970_968[0] = 1;
        tmp974_970 = tmp970_968;
        tmp974_970[1] = 12;
        tmp979_974 = tmp974_970;
        tmp979_974[2] = 3;
        tmp979_974;
        k.h(arrayOfInt, "tabIdList");
        ac.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabIdList size: %d", new Object[] { Integer.valueOf(3) });
        localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).xkw;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).removeAllTabs();
        }
        ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).xkx.clear();
        j = 0;
        i = 0;
        if (j < 3)
        {
          int k = arrayOfInt[j];
          ac.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabId: %d", new Object[] { Integer.valueOf(k) });
          Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).xky).iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (b.b)localIterator.next();
            if (((b.b)localObject1).xkB == k)
            {
              label1117:
              if (localObject1 == null) {
                break label1148;
              }
              if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).a(i, (b.b)localObject1)) {
                break label1203;
              }
              i += 1;
            }
          }
        }
      }
      for (;;)
      {
        j += 1;
        break label1041;
        break;
        localObject1 = null;
        break label1117;
        label1148:
        break;
        this.xbN = true;
        break;
        localObject1 = this.xbx.xkw;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(0);
        }
        this.xbn.setBottomExtraHeight(getResources().getDimensionPixelSize(2131166769));
        this.xbz = true;
        break label578;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(51756);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    final long l1;
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
          z.Nc(this.xbD);
          paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.awL());
          ac.i("MicroMsg.ScanUI", "select: [%s]", new Object[] { paramIntent });
          if (!bs.isNullOrNil(paramIntent))
          {
            l1 = System.currentTimeMillis();
            com.tencent.qbar.c.JQs.adZ(com.tencent.qbar.c.JQm);
            com.tencent.qbar.e.fCh().a(this, l1, paramIntent, new e.b()
            {
              public final void a(final long paramAnonymousLong, final List<com.tencent.qbar.a.a> paramAnonymousList, final List<WxQbarNative.QBarReportMsg> paramAnonymousList1)
              {
                AppMethodBeat.i(199517);
                if ((paramAnonymousLong == l1) && (BaseScanUI.N(BaseScanUI.this))) {
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(199516);
                      BaseScanUI.d(BaseScanUI.this, false);
                      Bundle localBundle;
                      Object localObject;
                      if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty()))
                      {
                        localBundle = new Bundle();
                        localBundle.putString("result_content", ((com.tencent.qbar.a.a)paramAnonymousList.get(0)).data);
                        localBundle.putInt("result_code_format", ((com.tencent.qbar.a.a)paramAnonymousList.get(0)).typeID);
                        localBundle.putString("result_code_name", ((com.tencent.qbar.a.a)paramAnonymousList.get(0)).typeName);
                        localObject = ((com.tencent.qbar.a.a)paramAnonymousList.get(0)).rawData;
                        if (localObject != null) {
                          localBundle.putByteArray("result_raw_data", (byte[])localObject);
                        }
                        if ((paramAnonymousList1 == null) || (paramAnonymousList1.isEmpty())) {
                          break label392;
                        }
                      }
                      label392:
                      for (int i = ((WxQbarNative.QBarReportMsg)paramAnonymousList1.get(0)).qrcodeVersion;; i = 0)
                      {
                        localBundle.putInt("result_code_version", i);
                        z.a(BaseScanUI.b(BaseScanUI.this), true, 2, 1);
                        if (BaseScanUI.f(BaseScanUI.this))
                        {
                          localObject = new Intent();
                          ((Intent)localObject).putExtra("key_scan_result", localBundle.getString("result_content"));
                          ((Intent)localObject).putExtra("key_scan_result_raw", localBundle.getByteArray("result_raw_data"));
                          ((Intent)localObject).putExtra("key_scan_result_code_name", localBundle.getString("result_code_name"));
                          ((Intent)localObject).putExtra("key_scan_result_code_version", i);
                          BaseScanUI.this.setResult(-1, (Intent)localObject);
                          BaseScanUI.this.bRD();
                          AppMethodBeat.o(199516);
                          return;
                        }
                        localBundle.putInt("qbar_string_scan_source", 1);
                        if (BaseScanUI.c(BaseScanUI.this) != null) {
                          BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, localBundle);
                        }
                        BaseScanUI.k(BaseScanUI.this);
                        AppMethodBeat.o(199516);
                        return;
                        BaseScanUI.d(BaseScanUI.this, true);
                        BaseScanUI.h(BaseScanUI.this, true);
                        z.a(BaseScanUI.b(BaseScanUI.this), false, 2, 1);
                        AppMethodBeat.o(199516);
                        return;
                      }
                    }
                  });
                }
                AppMethodBeat.o(199517);
              }
            }, this.xbJ);
          }
          AppMethodBeat.o(51756);
          return;
        }
        dAd();
      } while ((paramInt2 != 0) || (!o.Nu(this.xbD)));
      z.Nb(this.xbD);
      AppMethodBeat.o(51756);
      return;
    case 1001: 
      finish();
    }
    boolean bool;
    label192:
    String str;
    label261:
    long l2;
    long l3;
    if (paramIntent == null)
    {
      bool = true;
      ac.i("MicroMsg.ScanUI", "alvinluo processGoodsImage resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label533;
      }
      z.Nc(this.xbD);
      z.aq(2, System.currentTimeMillis());
      str = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.awL());
      l1 = System.currentTimeMillis();
      if (paramIntent != null) {
        break label527;
      }
      bool = true;
      ac.d("MicroMsg.ScanUI", "alvinluo processGoodsImage session: %d, resultCode: %d, filePath: %s, data == null: %b", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool) });
      if (this.xbn != null) {
        this.xbn.setScanSource(2);
      }
      paramInt1 = BackwardSupportUtil.ExifHelper.ce(str);
      l2 = System.currentTimeMillis();
      paramIntent = com.tencent.mm.sdk.platformtools.f.aKA(str);
      l3 = System.currentTimeMillis();
      if ((paramInt1 != 90) && (paramInt1 != 270)) {
        break label549;
      }
      paramIntent = com.tencent.mm.sdk.platformtools.f.a(paramIntent, paramInt1);
    }
    label527:
    label533:
    label549:
    for (;;)
    {
      ac.i("MicroMsg.ScanUI", "alvinluo processGoodsImage decode image cost: %d", new Object[] { Long.valueOf(l3 - l2) });
      if ((paramIntent != null) && (!paramIntent.isRecycled()))
      {
        localObject = this.xbn.getScanMaskView();
        if ((localObject instanceof ScanGoodsMaskView))
        {
          localObject = (ScanGoodsMaskView)localObject;
          ((ScanGoodsMaskView)localObject).ByW = true;
          ((ScanGoodsMaskView)localObject).BZo = false;
          ((ScanGoodsMaskView)localObject).aK(paramIntent);
        }
      }
      this.xbq = new BaseScanUI.26(this, l1);
      if (this.xbn != null) {
        this.xbn.a(true, this.xbq);
      }
      paramIntent = com.tencent.mm.plugin.scanner.c.a.dzp();
      Object localObject = this.xbZ;
      ac.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask filePath: %s", new Object[] { str });
      com.tencent.mm.plugin.scanner.model.s.a(new a.2(paramIntent, str, (a.c)localObject, l1));
      AppMethodBeat.o(51756);
      return;
      bool = false;
      break label192;
      bool = false;
      break label261;
      dAd();
      if (paramInt2 != 0) {
        break;
      }
      z.Nb(12);
      break;
    }
  }
  
  public void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(51741);
    ac.v("MicroMsg.ScanUI", "alvinluo onBackPressed");
    if ((this.xbv != null) && (this.xbv.isShowing()))
    {
      this.xbv.dismiss();
      AppMethodBeat.o(51741);
      return;
    }
    Object localObject;
    if ((this.xbT == null) || (!this.xbT.wZS))
    {
      i = 0;
      if (i != 0) {
        break label253;
      }
      if (this.xbn == null) {
        break label229;
      }
      localObject = this.xbn;
      if ((!o.Nu(((ScanUIRectView)localObject).mode)) || (((ScanUIRectView)localObject).wZP == null) || (!(((ScanUIRectView)localObject).wZP instanceof ScanCodeMaskView))) {
        break label224;
      }
    }
    label224:
    for (boolean bool = ((ScanUIRectView)localObject).wZP.onBackPressed();; bool = false)
    {
      if (!bool) {
        break label229;
      }
      dzW();
      AppMethodBeat.o(51741);
      return;
      ac.i("MicroMsg.ScanUI", "alvinluo cancelNetworkLoading isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.xbX) });
      localObject = this.xbT;
      b.a locala = ((x)localObject).wZT;
      if (locala != null) {
        locala.dBj();
      }
      ((x)localObject).wZT = null;
      this.xbT.Y(false, false);
      if (!this.xbX)
      {
        a(this.xbt, true, null);
        dAd();
        break;
      }
      dzW();
      break;
    }
    label229:
    if (this.xbD == 12) {
      z.pS(false);
    }
    z.MZ(this.xbD);
    goBack();
    label253:
    AppMethodBeat.o(51741);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(51758);
    super.onConfigurationChanged(paramConfiguration);
    ac.i("MicroMsg.ScanUI", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    AppMethodBeat.o(51758);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51729);
    super.onCreate(paramBundle);
    pU(true);
    if ((g.agi().aBK() == 6) || (g.agi().aBK() == 4))
    {
      this.xbG = true;
      this.njY = ((Vibrator)getSystemService("vibrator"));
      this.xbJ = getIntent().getIntArrayExtra("key_support_scan_code_type");
      this.xbK = getIntent().getIntExtra("key_scan_entry_scene", 0);
      this.xbL = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
      this.xbM = getIntent().getBooleanExtra("key_set_result_after_scan", false);
      this.wWb = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
      this.xbD = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
      this.xbF = getIntent().getBooleanExtra("key_show_scan_tips", true);
      this.xbI = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.xbW = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.xbP = getIntent().getBooleanExtra("key_for_jsapi_use", false);
      this.wWa = this.wWb;
      if (dzX()) {
        this.xbO = ((BaseScanRequest)getIntent().getParcelableExtra("key_scan_request"));
      }
      com.tencent.qbar.b.fCd();
      com.tencent.qbar.f.fCj();
      o.dBw();
      com.tencent.mm.plugin.scanner.util.d.init();
      bool = o.dBz();
      ac.i("MicroMsg.ScanUI", "alvinluo initEnableMultiCode configEnableMultiCode: %b, entryEnableMultiCode: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.xbW) });
      paramBundle = com.tencent.qbar.h.fCn();
      if ((!bool) || (!this.xbW)) {
        break label360;
      }
    }
    label360:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.xbW = bool;
      com.tencent.qbar.f.yC(bool);
      initView();
      this.xbC = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.GpY.c(this.oCV);
      com.tencent.mm.cq.d.fBf();
      z.dzH();
      Ng(1);
      r.eBu();
      AppMethodBeat.o(51729);
      return;
      this.xbG = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51755);
    ac.i("MicroMsg.ScanUI", "onDestroy()");
    super.onDestroy();
    com.tencent.mm.sdk.b.a.GpY.d(this.oCV);
    if (this.xbw != null)
    {
      this.xbw.destroy();
      this.xbw = null;
    }
    if (this.xbn != null) {
      this.xbn.onDestroy();
    }
    if ((this.xbv != null) && (this.xbv.isShowing())) {
      this.xbv.dismiss();
    }
    Ng(2);
    AppMethodBeat.o(51755);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51753);
    super.onPause();
    ac.i("MicroMsg.ScanUI", "alvinluo onPause needPauseScan: %b", new Object[] { Boolean.valueOf(this.xbQ) });
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.xbn != null)
    {
      this.xbn.onPause();
      if (this.xbQ) {
        this.xbn.stopPreview();
      }
    }
    if (this.xbU.ela == 0L) {
      Z(false, false);
    }
    com.tencent.qbar.c.JQr.btF();
    Object localObject = com.tencent.mm.plugin.scanner.util.i.xlZ;
    ac.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager != null)
    {
      ac.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      ((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager.unregisterListener((SensorEventListener)localObject);
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.xbv != null)
    {
      localObject = this.xbv.wXm;
      if (localObject != null)
      {
        ac.i("MicroMsg.BoxDialogView", "alvinluo onPause set canMeasured false");
        ((BoxDialogView)localObject).wWF = false;
        AppMethodBeat.o(51753);
        return;
      }
    }
    AppMethodBeat.o(51753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51752);
    ac.i("MicroMsg.ScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51752);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.xbA = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51705);
            paramAnonymousDialogInterface = BaseScanUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/BaseScanUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            BaseScanUI.L(BaseScanUI.this);
            BaseScanUI.this.finish();
            AppMethodBeat.o(51705);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51706);
            BaseScanUI.L(BaseScanUI.this);
            BaseScanUI.this.finish();
            AppMethodBeat.o(51706);
          }
        });
        AppMethodBeat.o(51752);
        return;
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
        {
          this.xbB = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51707);
              paramAnonymousDialogInterface = BaseScanUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/BaseScanUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              BaseScanUI.M(BaseScanUI.this);
              BaseScanUI.this.finish();
              AppMethodBeat.o(51707);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51711);
              BaseScanUI.M(BaseScanUI.this);
              BaseScanUI.this.finish();
              AppMethodBeat.o(51711);
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
    ac.i("MicroMsg.ScanUI", "alvinluo BaseScanUI onResume needPauseScan: %b", new Object[] { Boolean.valueOf(this.xbQ) });
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    Object localObject = com.tencent.mm.plugin.scanner.util.i.xlZ;
    ac.i("MicroMsg.ScanStableDetector", "start detect scan stable");
    if (((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager != null)
    {
      ((com.tencent.mm.plugin.scanner.util.i)localObject).xlX = 0;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).xlW[0] = 0.0F;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).xlW[1] = 0.0F;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).xlW[2] = 0.0F;
      ac.i("MicroMsg.ScanStableDetector", "register accelerate listener");
      ((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager.registerListener((SensorEventListener)localObject, ((com.tencent.mm.plugin.scanner.util.i)localObject).xlV, 50000);
    }
    ac.i("MicroMsg.ScanUI", "should check camera %s, location %s", new Object[] { Boolean.valueOf(this.xbA), Boolean.valueOf(this.xbB) });
    boolean bool;
    int i;
    if ((this.xbA) || (this.xbB)) {
      if (this.xbA)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
        ac.i("MicroMsg.ScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          this.wZZ = false;
          i = 0;
          if (i != 0)
          {
            z.pT(this.wZZ);
            if (com.tencent.mm.compatible.d.b.Yz()) {
              break label368;
            }
            com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(169978);
                paramAnonymousDialogInterface = BaseScanUI.this;
                Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/BaseScanUI$25", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$25", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                BaseScanUI.L(BaseScanUI.this);
                BaseScanUI.this.finish();
                AppMethodBeat.o(169978);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(169979);
                BaseScanUI.L(BaseScanUI.this);
                BaseScanUI.this.finish();
                AppMethodBeat.o(169979);
              }
            });
          }
        }
      }
    }
    for (;;)
    {
      getWindow().addFlags(128);
      if (this.xbv == null) {
        break label448;
      }
      localObject = this.xbv.wXm;
      if (localObject == null) {
        break label448;
      }
      ((BoxDialogView)localObject).wWF = true;
      AppMethodBeat.o(51751);
      return;
      if (this.xbB)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null);
        ac.i("MicroMsg.ScanUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      label368:
      ac.i("MicroMsg.ScanUI", "alvinluo onResumeAfterChkPermission needPauseScan: %b", new Object[] { Boolean.valueOf(this.xbQ) });
      if (!this.xbQ)
      {
        this.xbn.onResume();
        a(this.xbt, true, null);
        pV(true);
      }
      g.agQ().a(this.xcc);
      dAb();
      com.tencent.mm.sdk.b.a.GpY.c(this.xcd);
    }
    label448:
    AppMethodBeat.o(51751);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(51754);
    super.onStop();
    if (this.xbn != null) {
      this.xbn.onStop();
    }
    this.xbo.dAL();
    g.agQ().b(this.xcc);
    com.tencent.mm.sdk.b.a.GpY.d(this.xcd);
    getWindow().clearFlags(128);
    AppMethodBeat.o(51754);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI
 * JD-Core Version:    0.7.0.1
 */