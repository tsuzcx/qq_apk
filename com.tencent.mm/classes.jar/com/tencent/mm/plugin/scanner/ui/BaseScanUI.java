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
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.jt;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.BoxDialogView;
import com.tencent.mm.plugin.scanner.c.a.2;
import com.tencent.mm.plugin.scanner.c.a.d;
import com.tencent.mm.plugin.scanner.d.a.a;
import com.tencent.mm.plugin.scanner.d.d.a;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.model.x;
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
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.s;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarResult;
import d.g.b.p;
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
  private com.tencent.mm.ui.widget.a.e mIQ;
  private Vibrator nQa;
  private com.tencent.mm.modelgeo.b.a oSE;
  private com.tencent.mm.sdk.b.c<yh> pmW;
  private com.tencent.mm.modelgeo.d wGe;
  private ScanNetworkMaskView yDP;
  private boolean yDX;
  private boolean yFA;
  private boolean yFB;
  private boolean yFC;
  private long yFD;
  private int yFE;
  private boolean yFF;
  private boolean yFG;
  private boolean yFH;
  private boolean yFI;
  private boolean yFJ;
  private int[] yFK;
  private int yFL;
  private boolean yFM;
  private boolean yFN;
  private boolean yFO;
  private BaseScanRequest yFP;
  private boolean yFQ;
  private boolean yFR;
  private boolean yFS;
  private boolean yFT;
  private ab yFU;
  private jt yFV;
  private int yFW;
  private boolean yFX;
  private boolean yFY;
  private boolean yFZ;
  private ScanUIRectView yFo;
  private ScannerFlashSwitcher yFp;
  private View yFq;
  private DialogInterface.OnCancelListener yFr;
  private View yFs;
  private ImageView yFt;
  private ImageView yFu;
  private TextView yFv;
  private com.tencent.mm.plugin.scanner.box.e yFw;
  private com.tencent.mm.plugin.scanner.d.e yFx;
  private com.tencent.mm.plugin.scanner.ui.widget.b yFy;
  private boolean yFz;
  private ScanUIRectView.a yGa;
  private a.d yGb;
  private a.a yGc;
  private com.tencent.mm.plugin.scanner.box.b yGd;
  private n yGe;
  private com.tencent.mm.sdk.b.c yGf;
  private boolean yzD;
  private boolean yzE;
  private mc yzP;
  
  public BaseScanUI()
  {
    AppMethodBeat.i(51728);
    this.yFw = null;
    this.yFz = false;
    this.yFA = true;
    this.yFB = true;
    this.yFC = false;
    this.yDX = true;
    this.yFF = true;
    this.yFG = true;
    this.yFH = true;
    this.yFI = true;
    this.yFJ = false;
    this.yFR = false;
    this.yFS = true;
    this.yFT = true;
    this.yFU = new ab();
    this.yFV = new jt();
    this.yFX = false;
    this.yFY = false;
    this.yFZ = false;
    this.yGa = new ScanUIRectView.a()
    {
      public final void e(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51682);
        if (!BaseScanUI.a(BaseScanUI.this))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", new Object[] { Integer.valueOf(BaseScanUI.b(BaseScanUI.this)) });
          AppMethodBeat.o(51682);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "scan code cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)) });
          Object localObject2 = paramAnonymousBundle.getParcelableArrayList("result_qbar_result_list");
          if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0))
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
            AppMethodBeat.o(51682);
            return;
          }
          final int j = paramAnonymousBundle.getInt("result_code_point_count", 0);
          final long l = paramAnonymousBundle.getLong("decode_success_cost_time", 0L);
          ad.a(BaseScanUI.b(BaseScanUI.this), true, 1, j);
          BaseScanUI.e(BaseScanUI.this);
          Object localObject1 = BaseScanUI.this;
          if (j > 1) {}
          for (boolean bool = true;; bool = false)
          {
            BaseScanUI.a((BaseScanUI)localObject1, bool);
            BaseScanUI.b(BaseScanUI.this, false);
            ad.a(BaseScanUI.b(BaseScanUI.this), (List)localObject2, l);
            localObject1 = (WxQBarResult)((ArrayList)localObject2).get(0);
            if (!BaseScanUI.f(BaseScanUI.this)) {
              break label385;
            }
            if (localObject1 != null) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ScanUI", "first Qbar result is null");
            AppMethodBeat.o(51682);
            return;
          }
          paramAnonymousBundle = ((WxQBarResult)localObject1).typeName;
          Object localObject3 = new pi();
          localObject2 = ((WxQBarResult)localObject1).data;
          ((pi)localObject3).dEw.scanResult = ((String)localObject2);
          ((pi)localObject3).dEw.dEy = paramAnonymousBundle;
          ((pi)localObject3).dEw.dEu = 0;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("key_scan_result", (String)localObject2);
          ((Intent)localObject3).putExtra("key_scan_result_raw", ((WxQBarResult)localObject1).rawData);
          ((Intent)localObject3).putExtra("key_scan_result_code_name", paramAnonymousBundle);
          ((Intent)localObject3).putExtra("key_scan_result_code_version", ((WxQBarResult)localObject1).Mhm);
          BaseScanUI.this.setResult(-1, (Intent)localObject3);
          BaseScanUI.this.bXx();
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
              BaseScanUI.g(BaseScanUI.this).setSuccessMarkClickListener(new com.tencent.mm.plugin.scanner.model.ae()
              {
                public final void Pn(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(169958);
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  if ((paramAnonymous2Int < this.yGh.size()) && (j > 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.b(BaseScanUI.this, true);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, l, (WxQBarResult)this.yGh.get(paramAnonymous2Int));
                    ad.l(2, paramAnonymous2Int, this.yGj);
                    ad.dOH();
                  }
                  AppMethodBeat.o(169958);
                }
              });
              BaseScanUI.k(BaseScanUI.this);
              localObject3 = BaseScanUI.g(BaseScanUI.this);
              if (com.tencent.mm.plugin.scanner.util.d.dQg())
              {
                if (((ScanUIRectView)localObject3).yJy == null)
                {
                  ((ScanUIRectView)localObject3).yJy = new ScanDebugView(((ScanUIRectView)localObject3).getContext());
                  ((ScanUIRectView)localObject3).addView(((ScanUIRectView)localObject3).yJy);
                }
                if (((ScanUIRectView)localObject3).yJy != null)
                {
                  localObject4 = ((ScanUIRectView)localObject3).yJy;
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
                    localObject4 = ((ScanDebugView)localObject4).yOa;
                    if (localObject4 == null) {
                      p.bdF("debugInfo");
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
                public final void dOW()
                {
                  AppMethodBeat.i(169959);
                  if ((j == 1) || (this.yGh.size() == 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.b(BaseScanUI.this, true);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.val$result, l);
                    ad.l(1, 0, this.yGj);
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
              localObject3 = ((ScanDebugView)localObject4).yOa;
              if (localObject3 == null) {
                p.bdF("debugInfo");
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
    this.yGb = new a.d()
    {
      public final void B(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(51710);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ScanUI", "alvinluo onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousString });
        String str = paramAnonymousString;
        if (bu.isNullOrNil(paramAnonymousString)) {
          str = BaseScanUI.this.getResources().getString(2131762888);
        }
        com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(51708);
            BaseScanUI.q(BaseScanUI.this);
            ad.Ph(BaseScanUI.b(BaseScanUI.this));
            AppMethodBeat.o(51708);
          }
        });
        ad.a(2, false, System.currentTimeMillis());
        AppMethodBeat.o(51710);
      }
      
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51709);
        if (BaseScanUI.l(BaseScanUI.this))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ScanUI", "alvinluo onScanSuccess isScrolling and ignore");
          AppMethodBeat.o(51709);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          BaseScanUI.m(BaseScanUI.this);
          int i = paramAnonymousBundle.getInt("scan_source", 0);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo onScanSuccess cost time %d, scanImageCount: %d, source: %d, session: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)), Integer.valueOf(BaseScanUI.n(BaseScanUI.this)), Integer.valueOf(i), Long.valueOf(paramAnonymousLong) });
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
          if (i == 2)
          {
            if ((BaseScanUI.p(BaseScanUI.this) instanceof ScanGoodsRequest)) {
              paramAnonymousBundle.putParcelable("key_scan_request", BaseScanUI.p(BaseScanUI.this));
            }
            BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(51709);
      }
    };
    this.yGc = new a.a()
    {
      public final void ax(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(189466);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(paramAnonymousLong), Integer.valueOf(1) });
        BaseScanUI.s(BaseScanUI.this);
        AppMethodBeat.o(189466);
      }
      
      public final void b(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161970);
        String str;
        if (paramAnonymousInt1 == 2)
        {
          ad.R(false, paramAnonymousInt1);
          BaseScanUI.r(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          BaseScanUI.g(BaseScanUI.this).a(false, null);
          str = paramAnonymousString;
          if (bu.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(2131762888);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51717);
              BaseScanUI.q(BaseScanUI.this);
              ad.Ph(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(51717);
            }
          });
          AppMethodBeat.o(161970);
          return;
        }
        if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == 1003))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ScanUI", "alvinluo onScanResultFailed stop upload and show alert");
          if (BaseScanUI.c(BaseScanUI.this) != null) {
            BaseScanUI.c(BaseScanUI.this).z(paramAnonymousLong, false);
          }
          BaseScanUI.r(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          str = paramAnonymousString;
          if (bu.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(2131762889);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(161969);
              BaseScanUI.q(BaseScanUI.this);
              ad.Ph(BaseScanUI.b(BaseScanUI.this));
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvnluo onScanResultSuccess not SELECT_SCAN_MODE_GOODS and ignore");
          AppMethodBeat.o(51718);
          return;
        }
        if ((BaseScanUI.l(BaseScanUI.this)) || ((paramAnonymousx.doj == 1) && (BaseScanUI.o(BaseScanUI.this))))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ScanUI", "alvinluo onScanResultSuccess source:%d, isScrolling: %b or needPauseScan: %b and ignore", new Object[] { Integer.valueOf(paramAnonymousx.doj), Boolean.valueOf(BaseScanUI.l(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.o(BaseScanUI.this)) });
          AppMethodBeat.o(51718);
          return;
        }
        BaseScanUI.a(BaseScanUI.this, paramAnonymousx);
        AppMethodBeat.o(51718);
      }
    };
    this.yGd = new com.tencent.mm.plugin.scanner.box.b()
    {
      public final void a(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(189468);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onDismiss exitType: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseScanUI.u(BaseScanUI.this);
        BaseScanUI.v(BaseScanUI.this);
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.t(BaseScanUI.this), true);
        BaseScanUI.q(BaseScanUI.this);
        BaseScanUI.e(BaseScanUI.this, true);
        ad.zx(System.currentTimeMillis());
        ad.a(paramAnonymousInt, BaseScanUI.p(BaseScanUI.this));
        ad.Ph(12);
        AppMethodBeat.o(189468);
      }
      
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(189469);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onCancel");
        BaseScanUI.d(BaseScanUI.this, false);
        BaseScanUI.u(BaseScanUI.this);
        BaseScanUI.v(BaseScanUI.this);
        AppMethodBeat.o(189469);
      }
      
      public final void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(189467);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onShow");
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.t(BaseScanUI.this), false);
        BaseScanUI.e(BaseScanUI.this, false);
        ad.zw(System.currentTimeMillis());
        AppMethodBeat.o(189467);
      }
    };
    this.yGe = new n.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(189460);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(189459);
            boolean bool = BaseScanUI.L(BaseScanUI.this);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "onNetWorkChange %d, canResume: %b", new Object[] { Integer.valueOf(com.tencent.mm.kernel.g.ajj().aFd()), Boolean.valueOf(bool) });
            ScanUIRectView localScanUIRectView;
            int i;
            if (BaseScanUI.g(BaseScanUI.this) != null)
            {
              localScanUIRectView = BaseScanUI.g(BaseScanUI.this);
              i = paramAnonymousInt;
              if ((com.tencent.mm.kernel.g.ajj().aFd() != 6) && (com.tencent.mm.kernel.g.ajj().aFd() != 4)) {
                break label174;
              }
              localScanUIRectView.yFH = true;
              if ((!o.PD(localScanUIRectView.mode)) && (bool)) {
                localScanUIRectView.onResume();
              }
            }
            for (;;)
            {
              if (localScanUIRectView.yDN != null) {
                localScanUIRectView.yDN.onNetworkChange(i);
              }
              if ((com.tencent.mm.kernel.g.ajj().aFd() != 6) && (com.tencent.mm.kernel.g.ajj().aFd() != 4)) {
                break label224;
              }
              if (!BaseScanUI.M(BaseScanUI.this)) {
                break;
              }
              AppMethodBeat.o(189459);
              return;
              label174:
              localScanUIRectView.yFH = false;
              if (!o.PD(localScanUIRectView.mode)) {
                localScanUIRectView.onPause();
              }
            }
            BaseScanUI.i(BaseScanUI.this, true);
            BaseScanUI.N(BaseScanUI.this);
            AppMethodBeat.o(189459);
            return;
            label224:
            if (!BaseScanUI.M(BaseScanUI.this))
            {
              AppMethodBeat.o(189459);
              return;
            }
            BaseScanUI.i(BaseScanUI.this, false);
            BaseScanUI.N(BaseScanUI.this);
            AppMethodBeat.o(189459);
          }
        });
        AppMethodBeat.o(189460);
      }
    };
    this.yGf = new com.tencent.mm.sdk.b.c() {};
    this.pmW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(51728);
  }
  
  private void Po(int paramInt)
  {
    AppMethodBeat.i(51735);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo operateFlash operation: %d", new Object[] { Integer.valueOf(paramInt) });
    sm localsm = new sm();
    localsm.dId.dlO = paramInt;
    com.tencent.mm.sdk.b.a.IvT.l(localsm);
    if (this.yFp != null)
    {
      if (paramInt == 1)
      {
        this.yFp.dPB();
        AppMethodBeat.o(51735);
        return;
      }
      this.yFp.dPC();
    }
    AppMethodBeat.o(51735);
  }
  
  private void Pp(int paramInt)
  {
    AppMethodBeat.i(189479);
    ad.b(this.yFE, this.yFP, paramInt);
    AppMethodBeat.o(189479);
  }
  
  private void a(View paramView, boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(189474);
    if (paramView == null)
    {
      AppMethodBeat.o(189474);
      return;
    }
    if ((paramBoolean) && (paramView.getAlpha() != 0.0F))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ScanUI", "alvinluo animateAlpha show ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(189474);
      return;
    }
    if ((!paramBoolean) && (paramView.getAlpha() != 1.0F))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ScanUI", "alvinluo animateAlpha hide ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(189474);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo animateAlpha show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
    paramAnimatorListener = new BaseScanUI.11(this, paramAnimatorListener, paramView, paramBoolean);
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
      AppMethodBeat.o(189474);
      return;
      f1 = 1.0F;
      break;
    }
  }
  
  private void ac(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(189476);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance success: %b, isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.FALSE });
    Object localObject = this.yFV;
    long l;
    if (paramBoolean1)
    {
      l = 1L;
      ((jt)localObject).eDL = l;
      this.yFV.eDM = (System.currentTimeMillis() - this.yFD);
      localObject = this.yFV;
      if (!this.yFo.dPp()) {
        break label369;
      }
      l = 0L;
      label83:
      ((jt)localObject).eDN = l;
      this.yFV.eDS = this.yFE;
      this.yFV.eDO = com.tencent.qbar.c.Mhd.Mhg;
      if (com.tencent.mm.plugin.scanner.util.i.yQa.dQi() > 0L) {
        this.yFV.eDR = (com.tencent.mm.plugin.scanner.util.i.yQa.dQi() - this.yFD);
      }
      this.yFV.aLH();
      if (o.PD(this.yFE))
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(1229L, 0L, 1L);
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        if (!paramBoolean1) {
          break label374;
        }
        l = 1L;
        label184:
        ((com.tencent.mm.plugin.report.service.g)localObject).n(1229L, 1L, l);
        if (paramBoolean1)
        {
          if (!this.yFo.dPp()) {
            break label379;
          }
          com.tencent.mm.plugin.report.service.g.yxI.n(1229L, 5L, 1L);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.n(1229L, 7L, this.yFV.eDM);
      com.tencent.mm.plugin.report.service.g.yxI.n(1229L, 9L, this.yFV.eDO);
      if ((paramBoolean1) && (paramBoolean2))
      {
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance scanTime: %s, totalFrames: %d", new Object[] { Long.valueOf(this.yFV.eDM), Long.valueOf(this.yFV.eDO) });
        com.tencent.mm.plugin.report.service.g.yxI.n(1229L, 11L, 1L);
        com.tencent.mm.plugin.report.service.g.yxI.n(1229L, 12L, this.yFV.eDM);
        com.tencent.mm.plugin.report.service.g.yxI.n(1229L, 14L, this.yFV.eDO);
      }
      AppMethodBeat.o(189476);
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
      com.tencent.mm.plugin.report.service.g.yxI.n(1229L, 3L, 1L);
    }
  }
  
  private void ad(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(51750);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo showFlash show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if ((this.yFp != null) && (!this.yFp.isShown()))
      {
        this.yFo.dPu();
        if (paramBoolean2) {
          this.yFp.show();
        }
        for (;;)
        {
          com.tencent.qbar.c.Mhd.ahj(1);
          ad.hp(this.yFE, 1);
          AppMethodBeat.o(51750);
          return;
          this.yFp.setVisibility(0);
        }
      }
    }
    else if ((this.yFp != null) && (!this.yFp.Vp))
    {
      this.yFo.dPv();
      if (paramBoolean2)
      {
        this.yFp.hide();
        AppMethodBeat.o(51750);
        return;
      }
      this.yFp.setVisibility(8);
    }
    AppMethodBeat.o(51750);
  }
  
  private void b(boolean paramBoolean, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(189473);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo switchCloseView isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.yFv.setAlpha(0.0F);
      a(this.yFt, false, new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(189453);
          BaseScanUI.a(BaseScanUI.this, BaseScanUI.F(BaseScanUI.this), true);
          if (paramAnimatorListener != null) {
            paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
          }
          AppMethodBeat.o(189453);
        }
      });
      AppMethodBeat.o(189473);
      return;
    }
    a(this.yFv, false, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(189454);
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.G(BaseScanUI.this), true);
        if (paramAnimatorListener != null) {
          paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(189454);
      }
    });
    AppMethodBeat.o(189473);
  }
  
  private void dOJ()
  {
    AppMethodBeat.i(51732);
    ScanSharedMaskView localScanSharedMaskView = this.yFo.getSharedMaskView();
    if (localScanSharedMaskView == null)
    {
      AppMethodBeat.o(51732);
      return;
    }
    if (!this.yzD)
    {
      localScanSharedMaskView.getGalleryButton().setVisibility(0);
      localScanSharedMaskView.setOnGalleryClickListener(new BaseScanUI.32(this));
      AppMethodBeat.o(51732);
      return;
    }
    localScanSharedMaskView.getGalleryButton().setVisibility(8);
    AppMethodBeat.o(51732);
  }
  
  private void dOK()
  {
    AppMethodBeat.i(51734);
    ScanSharedMaskView localScanSharedMaskView = this.yFo.getSharedMaskView();
    if (localScanSharedMaskView != null) {
      this.yFp = localScanSharedMaskView.getFlashSwitcherView();
    }
    if (this.yFp != null)
    {
      this.yFp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189447);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.qbar.c.Mhd.ahj(2);
          if (!BaseScanUI.B(BaseScanUI.this).Vp) {
            BaseScanUI.a(BaseScanUI.this, 1);
          }
          for (;;)
          {
            ad.hp(BaseScanUI.b(BaseScanUI.this), 2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189447);
            return;
            BaseScanUI.a(BaseScanUI.this, 2);
          }
        }
      });
      this.yFo.setFlashStatus(this.yFp.cNB);
      if (this.yFE == 3)
      {
        dOL();
        this.yFp.hide();
      }
    }
    AppMethodBeat.o(51734);
  }
  
  private void dOL()
  {
    AppMethodBeat.i(51736);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUI", "alvinluo checkAndOperateFlash operation: %d", new Object[] { Integer.valueOf(2) });
    if (this.yFp.Vp) {
      Po(2);
    }
    AppMethodBeat.o(51736);
  }
  
  private void dOM()
  {
    AppMethodBeat.i(51737);
    if (((o.PD(this.yFE)) || (dOO()) || (dOP())) && (!this.yzE) && (!this.yFQ))
    {
      this.yFu.setVisibility(0);
      this.yFu.setOnClickListener(new BaseScanUI.5(this));
      AppMethodBeat.o(51737);
      return;
    }
    this.yFu.setVisibility(8);
    AppMethodBeat.o(51737);
  }
  
  private void dON()
  {
    AppMethodBeat.i(189472);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo processMultiCodeCancel isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.yFY) });
    if (!this.yFY)
    {
      AppMethodBeat.o(189472);
      return;
    }
    this.yFY = false;
    a(this.yFu, true, null);
    b(false, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(189452);
        BaseScanUI.a(BaseScanUI.this, System.currentTimeMillis());
        BaseScanUI.q(BaseScanUI.this);
        AppMethodBeat.o(189452);
      }
    });
    qA(true);
    if (o.PD(this.yFE))
    {
      ad.l(3, -1, 0L);
      ad.dOG();
    }
    AppMethodBeat.o(189472);
  }
  
  private boolean dOO()
  {
    return this.yFE == 12;
  }
  
  private boolean dOP()
  {
    return this.yFE == 3;
  }
  
  private void dOQ()
  {
    AppMethodBeat.i(51739);
    switch (this.yFE)
    {
    default: 
      this.yFo.setScanCallback(null);
      AppMethodBeat.o(51739);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.yFo.setScanCallback(this.yGa);
      this.yFx = new com.tencent.mm.plugin.scanner.d.d(this.yFE, this.yFL, this.yFo, this, this);
      AppMethodBeat.o(51739);
      return;
    }
    this.yFo.setScanCallback(this.yGb);
    this.yFx = new com.tencent.mm.plugin.scanner.d.a(this.yFE, this.yFo, this, this.yGc);
    AppMethodBeat.o(51739);
  }
  
  private void dOR()
  {
    AppMethodBeat.i(169986);
    if ((this.yFU != null) && (this.yFo != null)) {
      this.yFU.a(this.yFo.getScanMaskView(), this.yFo.getSharedMaskView(), this.yDP);
    }
    AppMethodBeat.o(169986);
  }
  
  private void dOS()
  {
    AppMethodBeat.i(51748);
    if ((o.PD(this.yFE)) || (dOP()) || (dOO())) {}
    for (int i = 0; i != 0; i = 1)
    {
      qC(this.yFH);
      AppMethodBeat.o(51748);
      return;
    }
    qC(true);
    AppMethodBeat.o(51748);
  }
  
  private void dOT()
  {
    AppMethodBeat.i(169987);
    int i = 0;
    if (o.PD(this.yFE)) {
      i = com.tencent.qbar.c.Mha;
    }
    for (;;)
    {
      com.tencent.qbar.c.Mhd.ahk(i);
      AppMethodBeat.o(169987);
      return;
      if (this.yFE == 12) {
        i = com.tencent.qbar.c.Mhb;
      } else if (this.yFE == 3) {
        i = com.tencent.qbar.c.Mhc;
      }
    }
  }
  
  private void dOU()
  {
    AppMethodBeat.i(51757);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo resumeScan");
    this.yFR = false;
    if (this.yFo != null) {
      this.yFo.onResume();
    }
    setEnableSwitchTab(true);
    AppMethodBeat.o(51757);
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
  
  private void hq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189475);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo reportSwitchTab %b", new Object[] { Boolean.valueOf(this.yFF) });
    ad.ho(paramInt1, paramInt2);
    ad.Pa(paramInt1);
    ad.Pc(paramInt1);
    ad.Ph(paramInt1);
    AppMethodBeat.o(189475);
  }
  
  private void qA(boolean paramBoolean)
  {
    AppMethodBeat.i(189471);
    if (this.yFy != null)
    {
      Object localObject = this.yFy;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanScrollTabController", "alvinluo setEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).setEnableSwitchTab(paramBoolean);
      localObject = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).yOy;
      if (localObject != null)
      {
        ((ScanScrollTabView)localObject).setEnabled(paramBoolean);
        AppMethodBeat.o(189471);
        return;
      }
    }
    AppMethodBeat.o(189471);
  }
  
  private void qB(boolean paramBoolean)
  {
    AppMethodBeat.i(51747);
    if (paramBoolean)
    {
      this.yFq.setVisibility(0);
      this.yFo.cyf();
      this.yFq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189458);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          BaseScanUI.K(BaseScanUI.this);
          BaseScanUI.h(BaseScanUI.this, false);
          BaseScanUI.q(BaseScanUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189458);
        }
      });
      if (this.yFo != null) {
        this.yFo.qE(true);
      }
      a(this.yFu, false, null);
      ad(false, true);
      AppMethodBeat.o(51747);
      return;
    }
    this.yFq.setVisibility(8);
    if (this.yFo != null) {
      this.yFo.qE(false);
    }
    a(this.yFu, true, null);
    AppMethodBeat.o(51747);
  }
  
  private void qC(boolean paramBoolean)
  {
    AppMethodBeat.i(51749);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "network change %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      qB(false);
      this.yFo.cyf();
    }
    AppMethodBeat.o(51749);
  }
  
  private void qz(boolean paramBoolean)
  {
    AppMethodBeat.i(51731);
    if ((!paramBoolean) && (!al.isDarkMode()))
    {
      getController().setNavigationbarColor(getContext().getResources().getColor(2131099649));
      AppMethodBeat.o(51731);
      return;
    }
    getController().setNavigationbarColor(getResources().getColor(2131100837));
    AppMethodBeat.o(51731);
  }
  
  private void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51733);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo setEnableSwitchTab enable: %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.yFA) });
    if (this.yFy != null)
    {
      if (!paramBoolean) {
        break label95;
      }
      if (this.yFA) {
        this.yFy.setEnableSwitchTab(true);
      }
    }
    while (this.yFo != null) {
      if (paramBoolean)
      {
        if (this.yFA)
        {
          this.yFo.setEnableScrollSwitchTab(true);
          AppMethodBeat.o(51733);
          return;
          label95:
          this.yFy.setEnableSwitchTab(false);
        }
      }
      else {
        this.yFo.setEnableScrollSwitchTab(false);
      }
    }
    AppMethodBeat.o(51733);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.scanner.view.b.a parama)
  {
    AppMethodBeat.i(51746);
    if ((this.yFU != null) && (this.yFU.yDQ)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo showLoadingView show: %b, isLoadingShow: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2) });
      this.yFR = paramBoolean1;
      if (this.yFU != null)
      {
        this.yFU.yDR = parama;
        if (this.yFU.yDQ != paramBoolean1)
        {
          this.yFU.ab(paramBoolean1, paramBoolean2);
          if (paramBoolean1)
          {
            a(this.yFu, false, null);
            b(false, null);
          }
        }
      }
      AppMethodBeat.o(51746);
      return;
    }
  }
  
  public final void am(Bundle paramBundle)
  {
    AppMethodBeat.i(189477);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo onNetworkUnconnected");
    this.yFR = true;
    a(this.yFu, false, null);
    b(false, null);
    if (this.yFU != null) {
      if (paramBundle == null) {
        break label253;
      }
    }
    label238:
    label246:
    label253:
    for (boolean bool = paramBundle.getBoolean("key_offline_scan_show_tips", true);; bool = true)
    {
      ab localab = this.yFU;
      paramBundle = localab.yDN;
      if (paramBundle != null) {
        paramBundle.dPQ();
      }
      paramBundle = localab.yDN;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getTargetSuccessMarkView();
        Object localObject = localab.yDP;
        if (localObject != null) {
          ((ScanNetworkMaskView)localObject).setSuccessMarkView(paramBundle);
        }
        paramBundle = localab.yDP;
        if (paramBundle != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanNetworkMaskView", "alvinluo showNoNetworkView showTips: %s", new Object[] { Boolean.valueOf(bool) });
          if (paramBundle.yOc != null)
          {
            localObject = paramBundle.yOh;
            if (localObject == null) {
              p.bdF("noNetworkLayout");
            }
            localObject = (TextView)((View)localObject).findViewById(2131308192);
            if (localObject != null) {
              ((TextView)localObject).setText(2131762851);
            }
            paramBundle.qJ(bool);
            if ((paramBundle.yOj[0] != 0) || (paramBundle.yOj[1] != 0)) {
              break label238;
            }
            paramBundle.yOl = true;
          }
        }
      }
      for (;;)
      {
        paramBundle = localab.yDO;
        if (paramBundle == null) {
          break label246;
        }
        paramBundle.qP(false);
        AppMethodBeat.o(189477);
        return;
        paramBundle = null;
        break;
        paramBundle.qK(true);
      }
      AppMethodBeat.o(189477);
      return;
    }
  }
  
  public final void an(Bundle paramBundle)
  {
    AppMethodBeat.i(189478);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo onNetworkWeak");
    this.yFR = true;
    a(this.yFu, false, null);
    b(false, null);
    if (this.yFU != null) {
      if (paramBundle == null) {
        break label251;
      }
    }
    label236:
    label244:
    label251:
    for (boolean bool = paramBundle.getBoolean("key_offline_scan_show_tips", true);; bool = true)
    {
      ab localab = this.yFU;
      paramBundle = localab.yDN;
      if (paramBundle != null) {
        paramBundle.dPR();
      }
      paramBundle = localab.yDN;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getTargetSuccessMarkView();
        Object localObject = localab.yDP;
        if (localObject != null) {
          ((ScanNetworkMaskView)localObject).setSuccessMarkView(paramBundle);
        }
        paramBundle = localab.yDP;
        if (paramBundle != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanNetworkMaskView", "alvinluo showWeakNetworkView needAnimateWeakNetworkView: %b, showTips: %b", new Object[] { Boolean.valueOf(paramBundle.yOo), Boolean.valueOf(bool) });
          localObject = paramBundle.yOh;
          if (localObject == null) {
            p.bdF("noNetworkLayout");
          }
          localObject = (TextView)((View)localObject).findViewById(2131308192);
          if (localObject != null) {
            ((TextView)localObject).setText(2131762854);
          }
          paramBundle.qJ(bool);
          if (paramBundle.yOo) {
            break label236;
          }
          paramBundle.yOo = true;
          paramBundle.qK(false);
        }
      }
      for (;;)
      {
        paramBundle = localab.yDO;
        if (paramBundle == null) {
          break label244;
        }
        paramBundle.setVisibility(8);
        AppMethodBeat.o(189478);
        return;
        paramBundle = null;
        break;
        paramBundle.qK(true);
      }
      AppMethodBeat.o(189478);
      return;
    }
  }
  
  public final void bXx()
  {
    AppMethodBeat.i(51743);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "finishUI");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(51743);
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
    this.yFy = new com.tencent.mm.plugin.scanner.ui.widget.b(this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    Object localObject2;
    Object localObject1;
    int i;
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      getWindow().addFlags(67109888);
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.yFq = findViewById(2131304320);
      this.yDP = ((ScanNetworkMaskView)findViewById(2131304319));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(169983);
          BaseScanUI.w(BaseScanUI.this);
          AppMethodBeat.o(169983);
          return true;
        }
      });
      this.yFs = findViewById(2131306000);
      this.yFt = ((ImageView)findViewById(2131298365));
      this.yFu = ((ImageView)findViewById(2131302478));
      this.yFv = ((TextView)findViewById(2131302560));
      this.yFo = new ScanUIRectView(this);
      this.yFo.setScanRequest(this.yFP);
      this.yFo.setEnableScanGoodsDynamicWording(this.yFZ);
      localObject2 = (ScanScrollTabView)findViewById(2131304329);
      localObject1 = this.yFy;
      p.h(localObject2, "scrollTabView");
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yOy = ((ScanScrollTabView)localObject2);
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yOy;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).removeAllTabs();
      }
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yOy;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)new b.c());
      }
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yOz.clear();
      localObject2 = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yOA).iterator();
      i = 0;
      label303:
      if (!((Iterator)localObject2).hasNext()) {
        break label355;
      }
      if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).a(i, (b.b)((Iterator)localObject2).next())) {
        break label1217;
      }
      i += 1;
    }
    label1052:
    label1214:
    label1217:
    for (;;)
    {
      break label303;
      getWindow().setFlags(1024, 1024);
      break;
      label355:
      localObject1 = this.yFy;
      localObject2 = new com.tencent.mm.plugin.scanner.ui.widget.e()
      {
        public final void Pr(int paramAnonymousInt)
        {
          AppMethodBeat.i(51695);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo onTabUnSelected tabId: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (o.PD(paramAnonymousInt)) {
            BaseScanUI.f(BaseScanUI.this, false);
          }
          BaseScanUI.Pq(paramAnonymousInt);
          if (paramAnonymousInt == 12) {
            BaseScanUI.dOV();
          }
          AppMethodBeat.o(51695);
        }
        
        public final void hr(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(51694);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo onTabSelected tabId: %d, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (!BaseScanUI.H(BaseScanUI.this)) {
            BaseScanUI.a(BaseScanUI.this, paramAnonymousInt1, paramAnonymousInt2);
          }
          for (;;)
          {
            if (BaseScanUI.b(BaseScanUI.this) != paramAnonymousInt1) {
              BaseScanUI.b(BaseScanUI.this, paramAnonymousInt1);
            }
            if (o.PD(paramAnonymousInt1)) {
              BaseScanUI.f(BaseScanUI.this, true);
            }
            BaseScanUI.J(BaseScanUI.this);
            AppMethodBeat.o(51694);
            return;
            BaseScanUI.I(BaseScanUI.this);
          }
        }
      };
      p.h(localObject2, "tabOnSelectedListener");
      localObject2 = new b.d((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1, (com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yOy;
      if (localObject1 != null) {
        ((ScanScrollTabView)localObject1).setOnTabChangedListener((com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      }
      localObject2 = this.yFy;
      localObject1 = new com.tencent.mm.plugin.scanner.ui.widget.d()
      {
        public final void cp(int paramAnonymousInt)
        {
          AppMethodBeat.i(51697);
          if (paramAnonymousInt == 1) {
            BaseScanUI.g(BaseScanUI.this, false);
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo onScrollStateChanged state: %d, isScrolling: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BaseScanUI.l(BaseScanUI.this)) });
            AppMethodBeat.o(51697);
            return;
            if ((paramAnonymousInt == 3) || (paramAnonymousInt == 2)) {
              BaseScanUI.g(BaseScanUI.this, true);
            }
          }
        }
        
        public final void t(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(51696);
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo onScroll offsetX: %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(51696);
        }
      };
      p.h(localObject1, "tabOnScrollListener");
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yOy;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)localObject1);
      }
      if (this.yFo != null) {
        this.yFo.setScrollTabController(this.yFy);
      }
      if ((this.yFM) || (this.yFE == 8)) {
        this.yFO = true;
      }
      label589:
      while (!com.tencent.mm.aw.b.aJF())
      {
        if (this.yFP != null)
        {
          if (this.yFP.yzA) {
            this.yFO = true;
          }
          if (this.yFP.yzD) {
            this.yzD = true;
          }
          if (this.yFP.yzE) {
            this.yzE = true;
          }
        }
        if (!this.yFO) {
          break;
        }
        localObject1 = this.yFy.yOy;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(8);
        }
        this.yFA = false;
        this.yFo.setBottomExtraHeight(0);
        setEnableSwitchTab(this.yFA);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo initView currentMode: %d, showOnlyScanCode: %b, hideScrollTab: %b, scanRequest: %s", new Object[] { Integer.valueOf(this.yFE), Boolean.valueOf(this.yFM), Boolean.valueOf(this.yFO), this.yFP });
        this.yFo.setActivity(this);
        this.container.addView(this.yFo, 0, new FrameLayout.LayoutParams(-1, -1));
        this.yFo.onCreate();
        this.yFo.setShowScanTips(this.yFG);
        this.yFo.setNetworkAvailable(this.yFH);
        this.yFo.setScanMode(this.yFE);
        this.yFo.refreshView();
        hq(this.yFE, 0);
        dOR();
        ad.Ph(this.yFE);
        dOT();
        if (this.yFJ) {
          this.yFo.setBlackInterval(com.tencent.qbar.b.fXT());
        }
        dOJ();
        dOQ();
        if ((this.yFK != null) && (this.yFK.length > 0)) {
          this.yFo.setScanCodeReaders(this.yFK);
        }
        if (this.yFQ) {
          this.yFo.setMyQrCodeVisible(false);
        }
        localObject2 = this.yFy;
        i = this.yFE;
        localObject1 = (Integer)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yOB.get(Integer.valueOf(i));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanScrollTabController", "alvinluo setSelectedTab tabId: %d, index: %s", new Object[] { Integer.valueOf(i), localObject1 });
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).bxN = ((Integer)localObject1).intValue();
          localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yOy;
          if (localObject2 != null) {
            ((ScanScrollTabView)localObject2).setSelectedTab(((Integer)localObject1).intValue());
          }
        }
        dOK();
        dOM();
        this.yFt.setVisibility(0);
        this.yFt.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(189450);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            BaseScanUI.dOV();
            BaseScanUI.e(BaseScanUI.this);
            BaseScanUI.w(BaseScanUI.this);
            ad.l(3, -1, 0L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189450);
          }
        });
        this.yFv.setOnClickListener(new BaseScanUI.7(this));
        AppMethodBeat.o(51730);
        return;
      }
      int j;
      if (o.dQl())
      {
        localObject2 = this.yFy;
        int[] arrayOfInt = new int[3];
        tmp981_979 = arrayOfInt;
        tmp981_979[0] = 1;
        tmp985_981 = tmp981_979;
        tmp985_981[1] = 12;
        tmp990_985 = tmp985_981;
        tmp990_985[2] = 3;
        tmp990_985;
        p.h(arrayOfInt, "tabIdList");
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabIdList size: %d", new Object[] { Integer.valueOf(3) });
        localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yOy;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).removeAllTabs();
        }
        ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yOz.clear();
        j = 0;
        i = 0;
        if (j < 3)
        {
          int k = arrayOfInt[j];
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabId: %d", new Object[] { Integer.valueOf(k) });
          Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yOA).iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (b.b)localIterator.next();
            if (((b.b)localObject1).yOD == k)
            {
              label1128:
              if (localObject1 == null) {
                break label1159;
              }
              if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).a(i, (b.b)localObject1)) {
                break label1214;
              }
              i += 1;
            }
          }
        }
      }
      for (;;)
      {
        j += 1;
        break label1052;
        break;
        localObject1 = null;
        break label1128;
        break;
        this.yFO = true;
        break;
        localObject1 = this.yFy.yOy;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(0);
        }
        this.yFo.setBottomExtraHeight(getResources().getDimensionPixelSize(2131166769));
        this.yFA = true;
        break label589;
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
          ad.Pl(this.yFE);
          paramIntent = com.tencent.mm.ui.tools.a.j(this, paramIntent, com.tencent.mm.plugin.image.d.azQ());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "select: [%s]", new Object[] { paramIntent });
          if (!bu.isNullOrNil(paramIntent))
          {
            l1 = System.currentTimeMillis();
            com.tencent.qbar.c.Mhe.ahi(com.tencent.qbar.c.MgY);
            com.tencent.qbar.e.fXW().a(this, l1, paramIntent, new BaseScanUI.26(this, l1), this.yFK);
          }
          AppMethodBeat.o(51756);
          return;
        }
        dOU();
      } while ((paramInt2 != 0) || (!o.PD(this.yFE)));
      ad.Pk(this.yFE);
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo processGoodsImage resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label533;
      }
      ad.Pl(this.yFE);
      ad.aw(2, System.currentTimeMillis());
      str = com.tencent.mm.ui.tools.a.j(this, paramIntent, com.tencent.mm.plugin.image.d.azQ());
      l1 = System.currentTimeMillis();
      if (paramIntent != null) {
        break label527;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUI", "alvinluo processGoodsImage session: %d, resultCode: %d, filePath: %s, data == null: %b", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool) });
      if (this.yFo != null) {
        this.yFo.setScanSource(2);
      }
      paramInt1 = BackwardSupportUtil.ExifHelper.df(str);
      l2 = System.currentTimeMillis();
      paramIntent = com.tencent.mm.sdk.platformtools.h.aRD(str);
      l3 = System.currentTimeMillis();
      if ((paramInt1 != 90) && (paramInt1 != 270)) {
        break label549;
      }
      paramIntent = com.tencent.mm.sdk.platformtools.h.a(paramIntent, paramInt1);
    }
    label527:
    label533:
    label549:
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo processGoodsImage decode image cost: %d", new Object[] { Long.valueOf(l3 - l2) });
      if ((paramIntent != null) && (!paramIntent.isRecycled()))
      {
        localObject = this.yFo.getScanMaskView();
        if ((localObject instanceof ScanGoodsMaskView))
        {
          localObject = (ScanGoodsMaskView)localObject;
          ((ScanGoodsMaskView)localObject).yMp = true;
          ((ScanGoodsMaskView)localObject).yMq = false;
          ((ScanGoodsMaskView)localObject).af(paramIntent);
        }
      }
      this.yFr = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(189465);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo processGoodsImage onCancel and resumeScan");
          if ((BaseScanUI.c(BaseScanUI.this) instanceof com.tencent.mm.plugin.scanner.d.a))
          {
            paramAnonymousDialogInterface = (com.tencent.mm.plugin.scanner.d.a)BaseScanUI.c(BaseScanUI.this);
            long l = l1;
            paramAnonymousDialogInterface.yzP = null;
            com.tencent.mm.plugin.scanner.model.c localc = paramAnonymousDialogInterface.yEW;
            if (localc != null) {
              localc.zv(l);
            }
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.yEV;
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.zv(l);
            }
          }
          ad.a(2, false, System.currentTimeMillis(), true);
          BaseScanUI.q(BaseScanUI.this);
          AppMethodBeat.o(189465);
        }
      };
      if (this.yFo != null) {
        this.yFo.a(true, this.yFr);
      }
      paramIntent = com.tencent.mm.plugin.scanner.c.a.dOf();
      Object localObject = this.yGb;
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask filePath: %s", new Object[] { str });
      v.a(new a.2(paramIntent, str, (a.d)localObject, l1));
      AppMethodBeat.o(51756);
      return;
      bool = false;
      break label192;
      bool = false;
      break label261;
      dOU();
      if (paramInt2 != 0) {
        break;
      }
      ad.Pk(12);
      break;
    }
  }
  
  public void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(51741);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUI", "alvinluo onBackPressed");
    if ((this.yFw != null) && (this.yFw.isShowing()))
    {
      this.yFw.dismiss();
      AppMethodBeat.o(51741);
      return;
    }
    Object localObject;
    if ((this.yFU == null) || (!this.yFU.yDQ))
    {
      i = 0;
      if (i != 0) {
        break label253;
      }
      if (this.yFo == null) {
        break label229;
      }
      localObject = this.yFo;
      if ((!o.PD(((ScanUIRectView)localObject).mode)) || (((ScanUIRectView)localObject).yDN == null) || (!(((ScanUIRectView)localObject).yDN instanceof ScanCodeMaskView))) {
        break label224;
      }
    }
    label224:
    for (boolean bool = ((ScanUIRectView)localObject).yDN.onBackPressed();; bool = false)
    {
      if (!bool) {
        break label229;
      }
      dON();
      AppMethodBeat.o(51741);
      return;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo cancelNetworkLoading isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.yFY) });
      localObject = this.yFU;
      com.tencent.mm.plugin.scanner.view.b.a locala = ((ab)localObject).yDR;
      if (locala != null) {
        locala.dQa();
      }
      ((ab)localObject).yDR = null;
      this.yFU.ab(false, false);
      if (!this.yFY)
      {
        a(this.yFu, true, null);
        dOU();
        break;
      }
      dON();
      break;
    }
    label229:
    if (this.yFE == 12) {
      ad.qx(false);
    }
    ad.Pi(this.yFE);
    goBack();
    label253:
    AppMethodBeat.o(51741);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(51758);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    AppMethodBeat.o(51758);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51729);
    super.onCreate(paramBundle);
    qz(true);
    if ((com.tencent.mm.kernel.g.ajj().aFd() == 6) || (com.tencent.mm.kernel.g.ajj().aFd() == 4))
    {
      this.yFH = true;
      this.nQa = ((Vibrator)getSystemService("vibrator"));
      this.yFK = getIntent().getIntArrayExtra("key_support_scan_code_type");
      this.yFL = getIntent().getIntExtra("key_scan_entry_scene", 0);
      this.yFM = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
      this.yFN = getIntent().getBooleanExtra("key_set_result_after_scan", false);
      this.yzE = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
      this.yFE = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
      this.yFG = getIntent().getBooleanExtra("key_show_scan_tips", true);
      this.yFJ = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.yFX = getIntent().getBooleanExtra("key_enable_multi_code", false);
      this.yFZ = getIntent().getBooleanExtra("key_scan_goods_enable_dynamic_wording", false);
      this.yFQ = getIntent().getBooleanExtra("key_for_jsapi_use", false);
      this.yzD = this.yzE;
      if (dOO()) {
        this.yFP = ((BaseScanRequest)getIntent().getParcelableExtra("key_scan_request"));
      }
      com.tencent.qbar.b.fXS();
      com.tencent.qbar.f.fXZ();
      o.dQm();
      com.tencent.mm.plugin.scanner.util.d.init();
      bool = o.dQp();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo initEnableMultiCode configEnableMultiCode: %b, entryEnableMultiCode: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.yFX) });
      paramBundle = com.tencent.qbar.h.fYd();
      if ((!bool) || (!this.yFX)) {
        break label375;
      }
    }
    label375:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.yFX = bool;
      com.tencent.qbar.f.zD(bool);
      initView();
      this.yFD = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.IvT.c(this.pmW);
      com.tencent.mm.cp.d.fWU();
      ad.dOA();
      Pp(1);
      u.dOn();
      AppMethodBeat.o(51729);
      return;
      this.yFH = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51755);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "onDestroy()");
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d(this.pmW);
    if (this.yFx != null)
    {
      this.yFx.destroy();
      this.yFx = null;
    }
    if (this.yFo != null) {
      this.yFo.onDestroy();
    }
    if ((this.yFw != null) && (this.yFw.isShowing())) {
      this.yFw.dismiss();
    }
    if ((this.mIQ != null) && (this.mIQ.isShowing())) {
      this.mIQ.bqD();
    }
    if (this.wGe != null) {
      this.wGe.c(this.oSE);
    }
    Pp(2);
    AppMethodBeat.o(51755);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51753);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo onPause needPauseScan: %b", new Object[] { Boolean.valueOf(this.yFR) });
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.yFo != null)
    {
      this.yFo.onPause();
      if (this.yFR) {
        this.yFo.stopPreview();
      }
    }
    if (this.yFV.eDL == 0L) {
      ac(false, false);
    }
    com.tencent.qbar.c.Mhd.byD();
    Object localObject = com.tencent.mm.plugin.scanner.util.i.yQa;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      ((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager.unregisterListener((SensorEventListener)localObject);
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.yFw != null)
    {
      localObject = this.yFw.yAX;
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BoxDialogView", "alvinluo onPause set canMeasured false");
        ((BoxDialogView)localObject).yAq = false;
        AppMethodBeat.o(51753);
        return;
      }
    }
    AppMethodBeat.o(51753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51752);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51752);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.yFB = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new BaseScanUI.21(this), new BaseScanUI.22(this));
        AppMethodBeat.o(51752);
        return;
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
        {
          this.yFC = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new BaseScanUI.24(this), new BaseScanUI.25(this));
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51751);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo BaseScanUI onResume needPauseScan: %b", new Object[] { Boolean.valueOf(this.yFR) });
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    Object localObject = com.tencent.mm.plugin.scanner.util.i.yQa;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanStableDetector", "start detect scan stable");
    if (((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager != null)
    {
      ((com.tencent.mm.plugin.scanner.util.i)localObject).yPY = 0;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).yPX[0] = 0.0F;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).yPX[1] = 0.0F;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).yPX[2] = 0.0F;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanStableDetector", "register accelerate listener");
      ((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager.registerListener((SensorEventListener)localObject, ((com.tencent.mm.plugin.scanner.util.i)localObject).yPW, 50000);
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "should check camera %s, location %s", new Object[] { Boolean.valueOf(this.yFB), Boolean.valueOf(this.yFC) });
    boolean bool;
    int i;
    if ((this.yFB) || (this.yFC)) {
      if (this.yFB)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          this.yDX = false;
          i = 0;
          if (i != 0)
          {
            ad.qy(this.yDX);
            if (com.tencent.mm.compatible.d.b.abk()) {
              break label368;
            }
            com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new BaseScanUI.19(this), new BaseScanUI.20(this));
          }
        }
      }
    }
    for (;;)
    {
      getWindow().addFlags(128);
      if (this.yFw == null) {
        break label448;
      }
      localObject = this.yFw.yAX;
      if (localObject == null) {
        break label448;
      }
      ((BoxDialogView)localObject).yAq = true;
      AppMethodBeat.o(51751);
      return;
      if (this.yFC)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      label368:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUI", "alvinluo onResumeAfterChkPermission needPauseScan: %b", new Object[] { Boolean.valueOf(this.yFR) });
      if (!this.yFR)
      {
        this.yFo.onResume();
        a(this.yFu, true, null);
        qA(true);
      }
      com.tencent.mm.kernel.g.ajQ().a(this.yGe);
      dOS();
      com.tencent.mm.sdk.b.a.IvT.c(this.yGf);
    }
    label448:
    AppMethodBeat.o(51751);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(51754);
    super.onStop();
    if (this.yFo != null) {
      this.yFo.onStop();
    }
    this.yFp.dPC();
    com.tencent.mm.kernel.g.ajQ().b(this.yGe);
    com.tencent.mm.sdk.b.a.IvT.d(this.yGf);
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