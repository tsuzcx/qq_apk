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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.b.a.gu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.c.a.2;
import com.tencent.mm.plugin.scanner.c.a.c;
import com.tencent.mm.plugin.scanner.d.d.a;
import com.tencent.mm.plugin.scanner.model.s;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.y;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.r;
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
  private FrameLayout jTz;
  private Vibrator mHT;
  private com.tencent.mm.sdk.b.c<ww> nZA;
  private ScanNetworkMaskView vPl;
  private boolean vPt;
  private ScanUIRectView vQF;
  private ScannerFlashSwitcher vQG;
  private View vQH;
  private DialogInterface.OnCancelListener vQI;
  private View vQJ;
  private ImageView vQK;
  private ImageView vQL;
  private TextView vQM;
  private com.tencent.mm.plugin.scanner.box.e vQN;
  private com.tencent.mm.plugin.scanner.d.e vQO;
  private com.tencent.mm.plugin.scanner.ui.widget.b vQP;
  private boolean vQQ;
  private boolean vQR;
  private boolean vQS;
  private boolean vQT;
  private long vQU;
  private int vQV;
  private boolean vQW;
  private boolean vQX;
  private boolean vQY;
  private boolean vQZ;
  private int[] vRa;
  private int vRb;
  private boolean vRc;
  private boolean vRd;
  private boolean vRe;
  private boolean vRf;
  private boolean vRg;
  private boolean vRh;
  private v vRi;
  private gu vRj;
  private int vRk;
  private boolean vRl;
  private boolean vRm;
  private ScanUIRectView.a vRn;
  private a.c vRo;
  private com.tencent.mm.plugin.scanner.d.a.a vRp;
  private com.tencent.mm.plugin.scanner.box.b vRq;
  private n vRr;
  private com.tencent.mm.sdk.b.c vRs;
  
  public BaseScanUI()
  {
    AppMethodBeat.i(51728);
    this.vQN = null;
    this.vQQ = false;
    this.vQR = true;
    this.vQS = true;
    this.vQT = false;
    this.vPt = true;
    this.vQW = true;
    this.vQX = true;
    this.vQY = true;
    this.vQZ = false;
    this.vRf = false;
    this.vRg = true;
    this.vRh = true;
    this.vRi = new v();
    this.vRj = new gu();
    this.vRl = false;
    this.vRm = false;
    this.vRn = new ScanUIRectView.a()
    {
      public final void e(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51682);
        if (!BaseScanUI.a(BaseScanUI.this))
        {
          ad.w("MicroMsg.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", new Object[] { Integer.valueOf(BaseScanUI.b(BaseScanUI.this)) });
          AppMethodBeat.o(51682);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          ad.i("MicroMsg.ScanUI", "scan code cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)) });
          Object localObject2 = paramAnonymousBundle.getParcelableArrayList("result_qbar_result_list");
          if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0))
          {
            ad.w("MicroMsg.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
            AppMethodBeat.o(51682);
            return;
          }
          final int j = paramAnonymousBundle.getInt("result_code_point_count", 0);
          final long l = paramAnonymousBundle.getLong("decode_success_cost_time", 0L);
          x.a(BaseScanUI.b(BaseScanUI.this), true, 1, j);
          BaseScanUI.e(BaseScanUI.this);
          Object localObject1 = BaseScanUI.this;
          if (j > 1) {}
          for (boolean bool = true;; bool = false)
          {
            BaseScanUI.a((BaseScanUI)localObject1, bool);
            BaseScanUI.b(BaseScanUI.this, false);
            x.a(BaseScanUI.b(BaseScanUI.this), (List)localObject2, l);
            localObject1 = (WxQBarResult)((ArrayList)localObject2).get(0);
            if (!BaseScanUI.f(BaseScanUI.this)) {
              break label385;
            }
            if (localObject1 != null) {
              break;
            }
            ad.w("MicroMsg.ScanUI", "first Qbar result is null");
            AppMethodBeat.o(51682);
            return;
          }
          paramAnonymousBundle = ((WxQBarResult)localObject1).typeName;
          Object localObject3 = new op();
          localObject2 = ((WxQBarResult)localObject1).data;
          ((op)localObject3).dtO.scanResult = ((String)localObject2);
          ((op)localObject3).dtO.dtQ = paramAnonymousBundle;
          ((op)localObject3).dtO.dtM = 0;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("key_scan_result", (String)localObject2);
          ((Intent)localObject3).putExtra("key_scan_result_raw", ((WxQBarResult)localObject1).rawData);
          ((Intent)localObject3).putExtra("key_scan_result_code_name", paramAnonymousBundle);
          ((Intent)localObject3).putExtra("key_scan_result_code_version", ((WxQBarResult)localObject1).IoP);
          BaseScanUI.this.setResult(-1, (Intent)localObject3);
          BaseScanUI.this.bKq();
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
              BaseScanUI.g(BaseScanUI.this).setSuccessMarkClickListener(new y()
              {
                public final void Lf(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(169958);
                  ad.i("MicroMsg.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  if ((paramAnonymous2Int < this.vRu.size()) && (j > 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.b(BaseScanUI.this, true);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, l, (WxQBarResult)this.vRu.get(paramAnonymous2Int));
                    x.k(2, paramAnonymous2Int, this.vRw);
                    x.dlI();
                  }
                  AppMethodBeat.o(169958);
                }
              });
              BaseScanUI.k(BaseScanUI.this);
              localObject3 = BaseScanUI.g(BaseScanUI.this);
              if (com.tencent.mm.plugin.scanner.util.d.dnh())
              {
                if (((ScanUIRectView)localObject3).vUL == null)
                {
                  ((ScanUIRectView)localObject3).vUL = new ScanDebugView(((ScanUIRectView)localObject3).getContext());
                  ((ScanUIRectView)localObject3).addView(((ScanUIRectView)localObject3).vUL);
                }
                if (((ScanUIRectView)localObject3).vUL != null)
                {
                  localObject4 = ((ScanUIRectView)localObject3).vUL;
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
                    localObject4 = ((ScanDebugView)localObject4).vYS;
                    if (localObject4 == null) {
                      k.aPZ("debugInfo");
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
                public final void dlZ()
                {
                  AppMethodBeat.i(169959);
                  if ((j == 1) || (this.vRu.size() == 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.b(BaseScanUI.this, true);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.val$result, l);
                    x.k(1, 0, this.vRw);
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
              localObject3 = ((ScanDebugView)localObject4).vYS;
              if (localObject3 == null) {
                k.aPZ("debugInfo");
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
    this.vRo = new a.c()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51709);
        if (BaseScanUI.l(BaseScanUI.this))
        {
          ad.w("MicroMsg.ScanUI", "alvinluo onScanSuccess isScrolling and ignore");
          AppMethodBeat.o(51709);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          BaseScanUI.m(BaseScanUI.this);
          int i = paramAnonymousBundle.getInt("scan_source", 0);
          ad.i("MicroMsg.ScanUI", "alvinluo onScanSuccess cost time %d, scanImageCount: %d, source: %d, session: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)), Integer.valueOf(BaseScanUI.n(BaseScanUI.this)), Integer.valueOf(i), Long.valueOf(paramAnonymousLong) });
          if ((i == 1) && (!BaseScanUI.o(BaseScanUI.this)))
          {
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
      
      public final void z(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(51710);
        ad.e("MicroMsg.ScanUI", "alvinluo onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousString });
        String str = paramAnonymousString;
        if (bt.isNullOrNil(paramAnonymousString)) {
          str = BaseScanUI.this.getResources().getString(2131762888);
        }
        com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(51708);
            BaseScanUI.p(BaseScanUI.this);
            x.KZ(BaseScanUI.b(BaseScanUI.this));
            AppMethodBeat.o(51708);
          }
        });
        x.a(2, false, System.currentTimeMillis());
        AppMethodBeat.o(51710);
      }
    };
    this.vRp = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void b(u paramAnonymousu)
      {
        AppMethodBeat.i(51718);
        if (BaseScanUI.b(BaseScanUI.this) != 12)
        {
          ad.i("MicroMsg.ScanUI", "alvnluo onScanResultSuccess not SELECT_SCAN_MODE_GOODS and ignore");
          AppMethodBeat.o(51718);
          return;
        }
        if ((BaseScanUI.l(BaseScanUI.this)) || ((paramAnonymousu.dep == 1) && (BaseScanUI.o(BaseScanUI.this))))
        {
          ad.w("MicroMsg.ScanUI", "alvinluo onScanResultSuccess source:%d, isScrolling: %b or needPauseScan: %b and ignore", new Object[] { Integer.valueOf(paramAnonymousu.dep), Boolean.valueOf(BaseScanUI.l(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.o(BaseScanUI.this)) });
          AppMethodBeat.o(51718);
          return;
        }
        BaseScanUI.a(BaseScanUI.this, paramAnonymousu);
        AppMethodBeat.o(51718);
      }
      
      public final void c(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161970);
        String str;
        if (paramAnonymousInt1 == 2)
        {
          x.L(false, paramAnonymousInt1);
          BaseScanUI.q(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          BaseScanUI.g(BaseScanUI.this).a(false, null);
          str = paramAnonymousString;
          if (bt.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(2131762888);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51717);
              BaseScanUI.p(BaseScanUI.this);
              x.KZ(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(51717);
            }
          });
          AppMethodBeat.o(161970);
          return;
        }
        if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == 1003))
        {
          ad.e("MicroMsg.ScanUI", "alvinluo onScanResultFailed stop upload and show alert");
          if (BaseScanUI.c(BaseScanUI.this) != null) {
            BaseScanUI.c(BaseScanUI.this).y(paramAnonymousLong, false);
          }
          BaseScanUI.q(BaseScanUI.this);
          BaseScanUI.e(BaseScanUI.this);
          str = paramAnonymousString;
          if (bt.isNullOrNil(paramAnonymousString)) {
            str = BaseScanUI.this.getResources().getString(2131762889);
          }
          com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(161969);
              BaseScanUI.p(BaseScanUI.this);
              x.KZ(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(161969);
            }
          });
        }
        AppMethodBeat.o(161970);
      }
    };
    this.vRq = new com.tencent.mm.plugin.scanner.box.b()
    {
      public final void KL(int paramAnonymousInt)
      {
        AppMethodBeat.i(51723);
        ad.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onDismiss exitType: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseScanUI.s(BaseScanUI.this);
        BaseScanUI.t(BaseScanUI.this);
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.r(BaseScanUI.this), true);
        BaseScanUI.p(BaseScanUI.this);
        BaseScanUI.e(BaseScanUI.this, true);
        x.sa(System.currentTimeMillis());
        x.KV(paramAnonymousInt);
        x.KZ(12);
        AppMethodBeat.o(51723);
      }
      
      public final void dla()
      {
        AppMethodBeat.i(51722);
        ad.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onShow");
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.r(BaseScanUI.this), false);
        BaseScanUI.e(BaseScanUI.this, false);
        x.rZ(System.currentTimeMillis());
        AppMethodBeat.o(51722);
      }
      
      public final void dlb()
      {
        AppMethodBeat.i(51724);
        ad.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onCancel");
        BaseScanUI.d(BaseScanUI.this, false);
        BaseScanUI.s(BaseScanUI.this);
        BaseScanUI.t(BaseScanUI.this);
        AppMethodBeat.o(51724);
      }
    };
    this.vRr = new n.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(195401);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195400);
            ad.i("MicroMsg.ScanUI", "onNetWorkChange %d", new Object[] { Integer.valueOf(g.aeS().auR()) });
            ScanUIRectView localScanUIRectView;
            int i;
            if (BaseScanUI.g(BaseScanUI.this) != null)
            {
              localScanUIRectView = BaseScanUI.g(BaseScanUI.this);
              i = paramAnonymousInt;
              if ((g.aeS().auR() != 6) && (g.aeS().auR() != 4)) {
                break label152;
              }
              localScanUIRectView.vQX = true;
              if (!o.Lu(localScanUIRectView.mode)) {
                localScanUIRectView.onResume();
              }
            }
            for (;;)
            {
              if (localScanUIRectView.vPj != null) {
                localScanUIRectView.vPj.onNetworkChange(i);
              }
              if ((g.aeS().auR() != 6) && (g.aeS().auR() != 4)) {
                break label202;
              }
              if (!BaseScanUI.E(BaseScanUI.this)) {
                break;
              }
              AppMethodBeat.o(195400);
              return;
              label152:
              localScanUIRectView.vQX = false;
              if (!o.Lu(localScanUIRectView.mode)) {
                localScanUIRectView.onPause();
              }
            }
            BaseScanUI.i(BaseScanUI.this, true);
            BaseScanUI.F(BaseScanUI.this);
            AppMethodBeat.o(195400);
            return;
            label202:
            if (!BaseScanUI.E(BaseScanUI.this))
            {
              AppMethodBeat.o(195400);
              return;
            }
            BaseScanUI.i(BaseScanUI.this, false);
            BaseScanUI.F(BaseScanUI.this);
            AppMethodBeat.o(195400);
          }
        });
        AppMethodBeat.o(195401);
      }
    };
    this.vRs = new BaseScanUI.16(this);
    this.nZA = new BaseScanUI.17(this);
    AppMethodBeat.o(51728);
  }
  
  private void Lg(int paramInt)
  {
    AppMethodBeat.i(51735);
    ad.i("MicroMsg.ScanUI", "alvinluo operateFlash operation: %d", new Object[] { Integer.valueOf(paramInt) });
    rq localrq = new rq();
    localrq.dxj.dbV = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(localrq);
    if (this.vQG != null)
    {
      if (paramInt == 1)
      {
        this.vQG.dmE();
        AppMethodBeat.o(51735);
        return;
      }
      this.vQG.dmF();
    }
    AppMethodBeat.o(51735);
  }
  
  private void W(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195413);
    ad.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance success: %b, isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.FALSE });
    Object localObject = this.vRj;
    long l;
    if (paramBoolean1)
    {
      l = 1L;
      ((gu)localObject).eiW = l;
      this.vRj.eiX = (System.currentTimeMillis() - this.vQU);
      localObject = this.vRj;
      if (!this.vQF.dms()) {
        break label369;
      }
      l = 0L;
      label83:
      ((gu)localObject).eiY = l;
      this.vRj.ejd = this.vQV;
      this.vRj.eiZ = com.tencent.qbar.c.IoG.IoJ;
      if (com.tencent.mm.plugin.scanner.util.i.waT.dnj() > 0L) {
        this.vRj.ejc = (com.tencent.mm.plugin.scanner.util.i.waT.dnj() - this.vQU);
      }
      this.vRj.aBj();
      if (o.Lu(this.vQV))
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(1229L, 0L, 1L);
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        if (!paramBoolean1) {
          break label374;
        }
        l = 1L;
        label184:
        ((com.tencent.mm.plugin.report.service.h)localObject).m(1229L, 1L, l);
        if (paramBoolean1)
        {
          if (!this.vQF.dms()) {
            break label379;
          }
          com.tencent.mm.plugin.report.service.h.vKh.m(1229L, 5L, 1L);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.m(1229L, 7L, this.vRj.eiX);
      com.tencent.mm.plugin.report.service.h.vKh.m(1229L, 9L, this.vRj.eiZ);
      if ((paramBoolean1) && (paramBoolean2))
      {
        ad.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance scanTime: %s, totalFrames: %d", new Object[] { Long.valueOf(this.vRj.eiX), Long.valueOf(this.vRj.eiZ) });
        com.tencent.mm.plugin.report.service.h.vKh.m(1229L, 11L, 1L);
        com.tencent.mm.plugin.report.service.h.vKh.m(1229L, 12L, this.vRj.eiX);
        com.tencent.mm.plugin.report.service.h.vKh.m(1229L, 14L, this.vRj.eiZ);
      }
      AppMethodBeat.o(195413);
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
      com.tencent.mm.plugin.report.service.h.vKh.m(1229L, 3L, 1L);
    }
  }
  
  private void X(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(51750);
    ad.v("MicroMsg.ScanUI", "alvinluo showFlash show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if ((this.vQG != null) && (!this.vQG.isShown()))
      {
        this.vQF.dmx();
        if (paramBoolean2) {
          this.vQG.show();
        }
        for (;;)
        {
          com.tencent.qbar.c.IoG.abH(1);
          x.gO(this.vQV, 1);
          AppMethodBeat.o(51750);
          return;
          this.vQG.setVisibility(0);
        }
      }
    }
    else if ((this.vQG != null) && (!this.vQG.SE))
    {
      this.vQF.dmy();
      if (paramBoolean2)
      {
        this.vQG.hide();
        AppMethodBeat.o(51750);
        return;
      }
      this.vQG.setVisibility(8);
    }
    AppMethodBeat.o(51750);
  }
  
  private void a(View paramView, boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(195412);
    if (paramView == null)
    {
      AppMethodBeat.o(195412);
      return;
    }
    if ((paramBoolean) && (paramView.getAlpha() != 0.0F))
    {
      ad.w("MicroMsg.ScanUI", "alvinluo animateAlpha show ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(195412);
      return;
    }
    if ((!paramBoolean) && (paramView.getAlpha() != 1.0F))
    {
      ad.w("MicroMsg.ScanUI", "alvinluo animateAlpha hide ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(195412);
      return;
    }
    ad.v("MicroMsg.ScanUI", "alvinluo animateAlpha show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
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
      AppMethodBeat.o(195412);
      return;
      f1 = 1.0F;
      break;
    }
  }
  
  private void b(boolean paramBoolean, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(195411);
    ad.v("MicroMsg.ScanUI", "alvinluo switchCloseView isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.vQM.setAlpha(0.0F);
      a(this.vQK, false, new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(195389);
          BaseScanUI.a(BaseScanUI.this, BaseScanUI.A(BaseScanUI.this), true);
          if (paramAnimatorListener != null) {
            paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
          }
          AppMethodBeat.o(195389);
        }
      });
      AppMethodBeat.o(195411);
      return;
    }
    a(this.vQM, false, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(195390);
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.B(BaseScanUI.this), true);
        if (paramAnimatorListener != null) {
          paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(195390);
      }
    });
    AppMethodBeat.o(195411);
  }
  
  private void dlM()
  {
    AppMethodBeat.i(51732);
    ScanSharedMaskView localScanSharedMaskView = this.vQF.getSharedMaskView();
    if (localScanSharedMaskView == null)
    {
      AppMethodBeat.o(51732);
      return;
    }
    if (!this.vRe)
    {
      localScanSharedMaskView.getGalleryButton().setVisibility(0);
      localScanSharedMaskView.setOnGalleryClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169984);
          BaseScanUI.v(BaseScanUI.this);
          AppMethodBeat.o(169984);
        }
      });
      AppMethodBeat.o(51732);
      return;
    }
    localScanSharedMaskView.getGalleryButton().setVisibility(8);
    AppMethodBeat.o(51732);
  }
  
  private void dlN()
  {
    AppMethodBeat.i(51734);
    ScanSharedMaskView localScanSharedMaskView = this.vQF.getSharedMaskView();
    if (localScanSharedMaskView != null) {
      this.vQG = localScanSharedMaskView.getFlashSwitcherView();
    }
    if (this.vQG != null)
    {
      this.vQG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51727);
          com.tencent.qbar.c.IoG.abH(2);
          if (!BaseScanUI.w(BaseScanUI.this).SE) {
            BaseScanUI.a(BaseScanUI.this, 1);
          }
          for (;;)
          {
            x.gO(BaseScanUI.b(BaseScanUI.this), 2);
            AppMethodBeat.o(51727);
            return;
            BaseScanUI.a(BaseScanUI.this, 2);
          }
        }
      });
      this.vQF.setFlashStatus(this.vQG.cEL);
      if (this.vQV == 3)
      {
        dlO();
        this.vQG.hide();
      }
    }
    AppMethodBeat.o(51734);
  }
  
  private void dlO()
  {
    AppMethodBeat.i(51736);
    ad.d("MicroMsg.ScanUI", "alvinluo checkAndOperateFlash operation: %d", new Object[] { Integer.valueOf(2) });
    if (this.vQG.SE) {
      Lg(2);
    }
    AppMethodBeat.o(51736);
  }
  
  private void dlP()
  {
    AppMethodBeat.i(51737);
    if (((o.Lu(this.vQV)) || (dlR()) || (dlS())) && (!this.vRe))
    {
      this.vQL.setVisibility(0);
      this.vQL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51685);
          BaseScanUI.x(BaseScanUI.this);
          AppMethodBeat.o(51685);
        }
      });
      AppMethodBeat.o(51737);
      return;
    }
    this.vQL.setVisibility(8);
    AppMethodBeat.o(51737);
  }
  
  private void dlQ()
  {
    AppMethodBeat.i(195410);
    ad.i("MicroMsg.ScanUI", "alvinluo processMultiCodeCancel isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.vRm) });
    if (!this.vRm)
    {
      AppMethodBeat.o(195410);
      return;
    }
    this.vRm = false;
    a(this.vQL, true, null);
    b(false, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(195388);
        BaseScanUI.a(BaseScanUI.this, System.currentTimeMillis());
        BaseScanUI.p(BaseScanUI.this);
        AppMethodBeat.o(195388);
      }
    });
    oX(true);
    if (o.Lu(this.vQV))
    {
      x.k(3, -1, 0L);
      x.dlH();
    }
    AppMethodBeat.o(195410);
  }
  
  private boolean dlR()
  {
    return this.vQV == 12;
  }
  
  private boolean dlS()
  {
    return this.vQV == 3;
  }
  
  private void dlT()
  {
    AppMethodBeat.i(51739);
    switch (this.vQV)
    {
    default: 
      this.vQF.setScanCallback(null);
      AppMethodBeat.o(51739);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.vQF.setScanCallback(this.vRn);
      this.vQO = new com.tencent.mm.plugin.scanner.d.d(this.vQV, this.vRb, this.vQF, this, this);
      AppMethodBeat.o(51739);
      return;
    }
    this.vQF.setScanCallback(this.vRo);
    this.vQO = new com.tencent.mm.plugin.scanner.d.a(this.vQV, this.vQF, this, this.vRp);
    AppMethodBeat.o(51739);
  }
  
  private void dlU()
  {
    AppMethodBeat.i(169986);
    if ((this.vRi != null) && (this.vQF != null)) {
      this.vRi.a(this.vQF.getScanMaskView(), this.vQF.getSharedMaskView(), this.vPl);
    }
    AppMethodBeat.o(169986);
  }
  
  private void dlV()
  {
    AppMethodBeat.i(51748);
    if ((o.Lu(this.vQV)) || (dlS()) || (dlR())) {}
    for (int i = 0; i != 0; i = 1)
    {
      oZ(this.vQX);
      AppMethodBeat.o(51748);
      return;
    }
    oZ(true);
    AppMethodBeat.o(51748);
  }
  
  private void dlW()
  {
    AppMethodBeat.i(169987);
    int i = 0;
    if (o.Lu(this.vQV)) {
      i = com.tencent.qbar.c.IoD;
    }
    for (;;)
    {
      com.tencent.qbar.c.IoG.abI(i);
      AppMethodBeat.o(169987);
      return;
      if (this.vQV == 12) {
        i = com.tencent.qbar.c.IoE;
      } else if (this.vQV == 3) {
        i = com.tencent.qbar.c.IoF;
      }
    }
  }
  
  private void dlX()
  {
    AppMethodBeat.i(51757);
    ad.i("MicroMsg.ScanUI", "alvinluo resumeScan");
    this.vRf = false;
    if (this.vQF != null) {
      this.vQF.onResume();
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
  
  private void oW(boolean paramBoolean)
  {
    AppMethodBeat.i(51731);
    if ((!paramBoolean) && (!ai.Eq()))
    {
      getController().setNavigationbarColor(ao.aD(this, 2130968578));
      AppMethodBeat.o(51731);
      return;
    }
    getController().setNavigationbarColor(getResources().getColor(2131100837));
    AppMethodBeat.o(51731);
  }
  
  private void oX(boolean paramBoolean)
  {
    AppMethodBeat.i(195409);
    if (this.vQP != null)
    {
      Object localObject = this.vQP;
      ad.i("MicroMsg.ScanScrollTabController", "alvinluo setEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).setEnableSwitchTab(paramBoolean);
      localObject = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).vZq;
      if (localObject != null)
      {
        ((ScanScrollTabView)localObject).setEnabled(paramBoolean);
        AppMethodBeat.o(195409);
        return;
      }
    }
    AppMethodBeat.o(195409);
  }
  
  private void oY(boolean paramBoolean)
  {
    AppMethodBeat.i(51747);
    if (paramBoolean)
    {
      this.vQH.setVisibility(0);
      this.vQF.cjn();
      this.vQH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195399);
          BaseScanUI.D(BaseScanUI.this);
          BaseScanUI.h(BaseScanUI.this, false);
          BaseScanUI.p(BaseScanUI.this);
          AppMethodBeat.o(195399);
        }
      });
      if (this.vQF != null) {
        this.vQF.pb(true);
      }
      a(this.vQL, false, null);
      X(false, true);
      AppMethodBeat.o(51747);
      return;
    }
    this.vQH.setVisibility(8);
    if (this.vQF != null) {
      this.vQF.pb(false);
    }
    a(this.vQL, true, null);
    AppMethodBeat.o(51747);
  }
  
  private void oZ(boolean paramBoolean)
  {
    AppMethodBeat.i(51749);
    ad.i("MicroMsg.ScanUI", "network change %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      oY(false);
      this.vQF.cjn();
    }
    AppMethodBeat.o(51749);
  }
  
  private void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51733);
    ad.i("MicroMsg.ScanUI", "alvinluo setEnableSwitchTab enable: %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.vQR) });
    if (this.vQP != null)
    {
      if (!paramBoolean) {
        break label95;
      }
      if (this.vQR) {
        this.vQP.setEnableSwitchTab(true);
      }
    }
    while (this.vQF != null) {
      if (paramBoolean)
      {
        if (this.vQR)
        {
          this.vQF.setEnableScrollSwitchTab(true);
          AppMethodBeat.o(51733);
          return;
          label95:
          this.vQP.setEnableSwitchTab(false);
        }
      }
      else {
        this.vQF.setEnableScrollSwitchTab(false);
      }
    }
    AppMethodBeat.o(51733);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, b.a parama)
  {
    AppMethodBeat.i(51746);
    if ((this.vRi != null) && (this.vRi.vPm)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ScanUI", "alvinluo showLoadingView show: %b, isLoadingShow: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2) });
      this.vRf = paramBoolean1;
      if (this.vRi != null)
      {
        this.vRi.vPn = parama;
        if (this.vRi.vPm != paramBoolean1)
        {
          this.vRi.V(paramBoolean1, paramBoolean2);
          if (paramBoolean1)
          {
            a(this.vQL, false, null);
            b(false, null);
          }
        }
      }
      AppMethodBeat.o(51746);
      return;
    }
  }
  
  public final void bKq()
  {
    AppMethodBeat.i(51743);
    ad.i("MicroMsg.ScanUI", "finishUI");
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(51743);
  }
  
  public final void dlK()
  {
    Object localObject1 = null;
    AppMethodBeat.i(51744);
    ad.i("MicroMsg.ScanUI", "alvinluo onNetworkUnconnected");
    this.vRf = true;
    a(this.vQL, false, null);
    b(false, null);
    if (this.vRi != null)
    {
      v localv = this.vRi;
      Object localObject2 = localv.vPj;
      if (localObject2 != null) {
        ((BaseScanMaskView)localObject2).dmR();
      }
      localObject2 = localv.vPj;
      if (localObject2 != null) {
        localObject1 = ((BaseScanMaskView)localObject2).getTargetSuccessMarkView();
      }
      localObject2 = localv.vPl;
      if (localObject2 != null) {
        ((ScanNetworkMaskView)localObject2).setSuccessMarkView((View)localObject1);
      }
      localObject1 = localv.vPl;
      if (localObject1 != null)
      {
        ad.i("MicroMsg.ScanNetworkMaskView", "alvinluo showNoNetworkView");
        if (((ScanNetworkMaskView)localObject1).vYU != null)
        {
          localObject2 = ((ScanNetworkMaskView)localObject1).vYZ;
          if (localObject2 == null) {
            k.aPZ("noNetworkLayout");
          }
          localObject2 = (TextView)((View)localObject2).findViewById(2131304326);
          if (localObject2 != null) {
            ((TextView)localObject2).setText(2131762851);
          }
          if ((localObject1.vZb[0] != 0) || (localObject1.vZb[1] != 0)) {
            break label197;
          }
          ((ScanNetworkMaskView)localObject1).vZd = true;
        }
      }
      for (;;)
      {
        localObject1 = localv.vPk;
        if (localObject1 == null) {
          break;
        }
        ((ScanSharedMaskView)localObject1).pk(false);
        AppMethodBeat.o(51744);
        return;
        label197:
        ((ScanNetworkMaskView)localObject1).pg(true);
      }
    }
    AppMethodBeat.o(51744);
  }
  
  public final void dlL()
  {
    Object localObject1 = null;
    AppMethodBeat.i(51745);
    ad.i("MicroMsg.ScanUI", "alvinluo onNetworkWeak");
    this.vRf = true;
    a(this.vQL, false, null);
    b(false, null);
    if (this.vRi != null)
    {
      v localv = this.vRi;
      Object localObject2 = localv.vPj;
      if (localObject2 != null) {
        ((BaseScanMaskView)localObject2).dmS();
      }
      localObject2 = localv.vPj;
      if (localObject2 != null) {
        localObject1 = ((BaseScanMaskView)localObject2).getTargetSuccessMarkView();
      }
      localObject2 = localv.vPl;
      if (localObject2 != null) {
        ((ScanNetworkMaskView)localObject2).setSuccessMarkView((View)localObject1);
      }
      localObject1 = localv.vPl;
      if (localObject1 != null)
      {
        ad.i("MicroMsg.ScanNetworkMaskView", "alvinluo showWeakNetworkView needAnimateWeakNetworkView: %b", new Object[] { Boolean.valueOf(((ScanNetworkMaskView)localObject1).vZg) });
        localObject2 = ((ScanNetworkMaskView)localObject1).vYZ;
        if (localObject2 == null) {
          k.aPZ("noNetworkLayout");
        }
        localObject2 = (TextView)((View)localObject2).findViewById(2131304326);
        if (localObject2 != null) {
          ((TextView)localObject2).setText(2131762854);
        }
        if (((ScanNetworkMaskView)localObject1).vZg) {
          break label199;
        }
        ((ScanNetworkMaskView)localObject1).vZg = true;
        ((ScanNetworkMaskView)localObject1).pg(false);
      }
      for (;;)
      {
        localObject1 = localv.vPk;
        if (localObject1 == null) {
          break;
        }
        ((ScanSharedMaskView)localObject1).setVisibility(8);
        AppMethodBeat.o(51745);
        return;
        label199:
        ((ScanNetworkMaskView)localObject1).pg(true);
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
    this.jTz = ((FrameLayout)findViewById(2131304310));
    this.vQP = new com.tencent.mm.plugin.scanner.ui.widget.b(this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    Object localObject2;
    Object localObject1;
    int i;
    if (com.tencent.mm.compatible.util.d.lf(19))
    {
      getWindow().addFlags(67109888);
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.vQH = findViewById(2131304320);
      this.vPl = ((ScanNetworkMaskView)findViewById(2131304319));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(169983);
          BaseScanUI.u(BaseScanUI.this);
          AppMethodBeat.o(169983);
          return true;
        }
      });
      this.vQJ = findViewById(2131306000);
      this.vQK = ((ImageView)findViewById(2131298365));
      this.vQL = ((ImageView)findViewById(2131302478));
      this.vQM = ((TextView)findViewById(2131302560));
      this.vQF = new ScanUIRectView(this);
      localObject2 = (ScanScrollTabView)findViewById(2131304329);
      localObject1 = this.vQP;
      k.h(localObject2, "scrollTabView");
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).vZq = ((ScanScrollTabView)localObject2);
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).vZq;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).removeAllTabs();
      }
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).vZq;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)new b.c());
      }
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).vZr.clear();
      localObject2 = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).vZs).iterator();
      i = 0;
      label281:
      if (!((Iterator)localObject2).hasNext()) {
        break label333;
      }
      if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).a(i, (b.b)((Iterator)localObject2).next())) {
        break label1116;
      }
      i += 1;
    }
    label333:
    label1107:
    label1110:
    label1116:
    for (;;)
    {
      break label281;
      getWindow().setFlags(1024, 1024);
      break;
      localObject1 = this.vQP;
      localObject2 = new com.tencent.mm.plugin.scanner.ui.widget.e()
      {
        public final void Li(int paramAnonymousInt)
        {
          AppMethodBeat.i(195396);
          ad.i("MicroMsg.ScanUI", "alvinluo onTabUnSelected tabId: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (o.Lu(paramAnonymousInt)) {
            BaseScanUI.f(BaseScanUI.this, false);
          }
          BaseScanUI.Lh(paramAnonymousInt);
          if (paramAnonymousInt == 12) {
            BaseScanUI.dlY();
          }
          AppMethodBeat.o(195396);
        }
        
        public final void gP(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(195395);
          ad.i("MicroMsg.ScanUI", "alvinluo onTabSelected tabId: %d, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          x.gN(paramAnonymousInt1, paramAnonymousInt2);
          x.KQ(paramAnonymousInt1);
          x.KS(paramAnonymousInt1);
          x.KZ(paramAnonymousInt1);
          if (BaseScanUI.b(BaseScanUI.this) != paramAnonymousInt1) {
            BaseScanUI.b(BaseScanUI.this, paramAnonymousInt1);
          }
          if (o.Lu(paramAnonymousInt1)) {
            BaseScanUI.f(BaseScanUI.this, true);
          }
          BaseScanUI.C(BaseScanUI.this);
          AppMethodBeat.o(195395);
        }
      };
      k.h(localObject2, "tabOnSelectedListener");
      localObject2 = new b.d((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1, (com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).vZq;
      if (localObject1 != null) {
        ((ScanScrollTabView)localObject1).setOnTabChangedListener((com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      }
      localObject2 = this.vQP;
      localObject1 = new com.tencent.mm.plugin.scanner.ui.widget.d()
      {
        public final void cq(int paramAnonymousInt)
        {
          AppMethodBeat.i(195398);
          if (paramAnonymousInt == 1) {
            BaseScanUI.g(BaseScanUI.this, false);
          }
          for (;;)
          {
            ad.v("MicroMsg.ScanUI", "alvinluo onScrollStateChanged state: %d, isScrolling: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BaseScanUI.l(BaseScanUI.this)) });
            AppMethodBeat.o(195398);
            return;
            if ((paramAnonymousInt == 3) || (paramAnonymousInt == 2)) {
              BaseScanUI.g(BaseScanUI.this, true);
            }
          }
        }
        
        public final void s(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(195397);
          ad.v("MicroMsg.ScanUI", "alvinluo onScroll offsetX: %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
          AppMethodBeat.o(195397);
        }
      };
      k.h(localObject1, "tabOnScrollListener");
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).vZq;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)localObject1);
      }
      if (this.vQF != null) {
        this.vQF.setScrollTabController(this.vQP);
      }
      boolean bool;
      if ((this.vRc) || (this.vQV == 8)) {
        bool = true;
      }
      for (;;)
      {
        label511:
        int j;
        if (bool)
        {
          localObject1 = this.vQP.vZq;
          if (localObject1 != null) {
            ((ScanScrollTabView)localObject1).setVisibility(8);
          }
          this.vQR = false;
          this.vQF.setBottomExtraHeight(0);
          setEnableSwitchTab(this.vQR);
          ad.i("MicroMsg.ScanUI", "alvinluo initView currentMode: %d, showOnlyScanCode: %b, hideScrollTab: %b", new Object[] { Integer.valueOf(this.vQV), Boolean.valueOf(this.vRc), Boolean.valueOf(bool) });
          this.vQF.setActivity(this);
          this.jTz.addView(this.vQF, 0, new FrameLayout.LayoutParams(-1, -1));
          this.vQF.onCreate();
          this.vQF.setShowScanTips(this.vQW);
          this.vQF.setNetworkAvailable(this.vQX);
          this.vQF.setScanMode(this.vQV);
          this.vQF.refreshView();
          dlU();
          x.KZ(this.vQV);
          dlW();
          if (this.vQZ) {
            this.vQF.setBlackInterval(com.tencent.qbar.b.flN());
          }
          dlM();
          dlT();
          if ((this.vRa != null) && (this.vRa.length > 0)) {
            this.vQF.setScanCodeReaders(this.vRa);
          }
          localObject2 = this.vQP;
          i = this.vQV;
          localObject1 = (Integer)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).vZt.get(Integer.valueOf(i));
          ad.i("MicroMsg.ScanScrollTabController", "alvinluo setSelectedTab tabId: %d, index: %s", new Object[] { Integer.valueOf(i), localObject1 });
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).boX = ((Integer)localObject1).intValue();
            localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).vZq;
            if (localObject2 != null) {
              ((ScanScrollTabView)localObject2).setSelectedTab(((Integer)localObject1).intValue());
            }
          }
          dlN();
          dlP();
          this.vQK.setVisibility(0);
          this.vQK.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(51686);
              BaseScanUI.dlY();
              BaseScanUI.e(BaseScanUI.this);
              BaseScanUI.u(BaseScanUI.this);
              x.k(3, -1, 0L);
              AppMethodBeat.o(51686);
            }
          });
          this.vQM.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(195387);
              if (BaseScanUI.y(BaseScanUI.this)) {
                BaseScanUI.z(BaseScanUI.this);
              }
              AppMethodBeat.o(195387);
            }
          });
          AppMethodBeat.o(51730);
          return;
          if (!com.tencent.mm.ax.b.azn()) {
            break label1110;
          }
          if (o.dnn())
          {
            localObject2 = this.vQP;
            int[] arrayOfInt = new int[3];
            tmp870_868 = arrayOfInt;
            tmp870_868[0] = 1;
            tmp874_870 = tmp870_868;
            tmp874_870[1] = 12;
            tmp879_874 = tmp874_870;
            tmp879_874[2] = 3;
            tmp879_874;
            k.h(arrayOfInt, "tabIdList");
            ad.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabIdList size: %d", new Object[] { Integer.valueOf(3) });
            localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).vZq;
            if (localObject1 != null) {
              ((ScanScrollTabView)localObject1).removeAllTabs();
            }
            ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).vZr.clear();
            j = 0;
            i = 0;
            if (j < 3)
            {
              int k = arrayOfInt[j];
              ad.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabId: %d", new Object[] { Integer.valueOf(k) });
              Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).vZs).iterator();
              while (localIterator.hasNext())
              {
                localObject1 = (b.b)localIterator.next();
                if (((b.b)localObject1).vZv == k)
                {
                  label1017:
                  if (localObject1 == null) {
                    break label1110;
                  }
                  if (!((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).a(i, (b.b)localObject1)) {
                    break label1107;
                  }
                  i += 1;
                }
              }
            }
          }
        }
        for (;;)
        {
          j += 1;
          break label941;
          localObject1 = null;
          break label1017;
          bool = false;
          break;
          bool = true;
          break;
          localObject1 = this.vQP.vZq;
          if (localObject1 != null) {
            ((ScanScrollTabView)localObject1).setVisibility(0);
          }
          this.vQF.setBottomExtraHeight(getResources().getDimensionPixelSize(2131166769));
          this.vQR = true;
          break label511;
        }
        bool = false;
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
          x.Ld(this.vQV);
          paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.apW());
          ad.i("MicroMsg.ScanUI", "select: [%s]", new Object[] { paramIntent });
          if (!bt.isNullOrNil(paramIntent))
          {
            l1 = System.currentTimeMillis();
            com.tencent.qbar.c.IoH.abG(com.tencent.qbar.c.IoB);
            com.tencent.qbar.e.flQ().a(this, l1, paramIntent, new e.b()
            {
              public final void a(final long paramAnonymousLong, final List<com.tencent.qbar.a.a> paramAnonymousList, final List<WxQbarNative.QBarReportMsg> paramAnonymousList1)
              {
                AppMethodBeat.i(195407);
                if ((paramAnonymousLong == l1) && (BaseScanUI.K(BaseScanUI.this))) {
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(195406);
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
                        x.a(BaseScanUI.b(BaseScanUI.this), true, 2, 1);
                        if (BaseScanUI.f(BaseScanUI.this))
                        {
                          localObject = new Intent();
                          ((Intent)localObject).putExtra("key_scan_result", localBundle.getString("result_content"));
                          ((Intent)localObject).putExtra("key_scan_result_raw", localBundle.getByteArray("result_raw_data"));
                          ((Intent)localObject).putExtra("key_scan_result_code_name", localBundle.getString("result_code_name"));
                          ((Intent)localObject).putExtra("key_scan_result_code_version", i);
                          BaseScanUI.this.setResult(-1, (Intent)localObject);
                          BaseScanUI.this.bKq();
                          AppMethodBeat.o(195406);
                          return;
                        }
                        localBundle.putInt("qbar_string_scan_source", 1);
                        if (BaseScanUI.c(BaseScanUI.this) != null) {
                          BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, localBundle);
                        }
                        BaseScanUI.k(BaseScanUI.this);
                        AppMethodBeat.o(195406);
                        return;
                        BaseScanUI.d(BaseScanUI.this, true);
                        BaseScanUI.h(BaseScanUI.this, true);
                        x.a(BaseScanUI.b(BaseScanUI.this), false, 2, 1);
                        AppMethodBeat.o(195406);
                        return;
                      }
                    }
                  });
                }
                AppMethodBeat.o(195407);
              }
            }, this.vRa);
          }
          AppMethodBeat.o(51756);
          return;
        }
        dlX();
      } while ((paramInt2 != 0) || (!o.Lu(this.vQV)));
      x.Lc(this.vQV);
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
      ad.i("MicroMsg.ScanUI", "alvinluo processGoodsImage resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label643;
      }
      x.Ld(this.vQV);
      x.ar(2, System.currentTimeMillis());
      str = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.apW());
      l1 = System.currentTimeMillis();
      if (paramIntent != null) {
        break label637;
      }
      bool = true;
      ad.d("MicroMsg.ScanUI", "alvinluo processGoodsImage session: %d, resultCode: %d, filePath: %s, data == null: %b", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool) });
      if (this.vQF != null) {
        this.vQF.setScanSource(2);
      }
      paramInt1 = BackwardSupportUtil.ExifHelper.co(str);
      l2 = System.currentTimeMillis();
      paramIntent = com.tencent.mm.sdk.platformtools.f.aFj(str);
      l3 = System.currentTimeMillis();
      if ((paramInt1 != 90) && (paramInt1 != 270)) {
        break label659;
      }
      paramIntent = com.tencent.mm.sdk.platformtools.f.a(paramIntent, paramInt1);
    }
    label643:
    label659:
    for (;;)
    {
      ad.i("MicroMsg.ScanUI", "alvinluo processGoodsImage decode image cost: %d", new Object[] { Long.valueOf(l3 - l2) });
      if ((paramIntent != null) && (!paramIntent.isRecycled()))
      {
        localObject = this.vQF.getScanMaskView();
        if ((localObject instanceof ScanGoodsMaskView))
        {
          localObject = (ScanGoodsMaskView)localObject;
          ((ScanGoodsMaskView)localObject).dmL();
          if ((paramIntent != null) && (!paramIntent.isRecycled()))
          {
            ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreview bitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramIntent.getWidth()), Integer.valueOf(paramIntent.getHeight()) });
            ImageView localImageView = ((ScanGoodsMaskView)localObject).vXi;
            if (localImageView == null) {
              k.aPZ("previewImage");
            }
            localImageView.setImageBitmap(paramIntent);
            localImageView = ((ScanGoodsMaskView)localObject).vXi;
            if (localImageView == null) {
              k.aPZ("previewImage");
            }
            localImageView.setVisibility(0);
            localImageView = ((ScanGoodsMaskView)localObject).vXi;
            if (localImageView == null) {
              k.aPZ("previewImage");
            }
            localImageView.setAlpha(1.0F);
          }
          ((ScanGoodsMaskView)localObject).b(paramIntent, false);
        }
      }
      this.vQI = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(195408);
          ad.i("MicroMsg.ScanUI", "alvinluo processGoodsImage onCancel and resumeScan");
          if ((BaseScanUI.c(BaseScanUI.this) instanceof com.tencent.mm.plugin.scanner.d.a))
          {
            paramAnonymousDialogInterface = (com.tencent.mm.plugin.scanner.d.a)BaseScanUI.c(BaseScanUI.this);
            long l = l1;
            com.tencent.mm.plugin.scanner.model.b localb = paramAnonymousDialogInterface.vQr;
            if (localb != null) {
              localb.rY(l);
            }
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.vQq;
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.rY(l);
            }
          }
          x.a(2, false, System.currentTimeMillis(), true);
          BaseScanUI.p(BaseScanUI.this);
          AppMethodBeat.o(195408);
        }
      };
      if (this.vQF != null) {
        this.vQF.a(true, this.vQI);
      }
      paramIntent = com.tencent.mm.plugin.scanner.c.a.dln();
      Object localObject = this.vRo;
      ad.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask filePath: %s", new Object[] { str });
      s.a(new a.2(paramIntent, str, (a.c)localObject, l1));
      AppMethodBeat.o(51756);
      return;
      bool = false;
      break label192;
      label637:
      bool = false;
      break label261;
      dlX();
      if (paramInt2 != 0) {
        break;
      }
      x.Lc(12);
      break;
    }
  }
  
  public void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(51741);
    ad.v("MicroMsg.ScanUI", "alvinluo onBackPressed");
    if ((this.vQN != null) && (this.vQN.isShowing()))
    {
      this.vQN.dismiss();
      AppMethodBeat.o(51741);
      return;
    }
    Object localObject;
    if ((this.vRi == null) || (!this.vRi.vPm))
    {
      i = 0;
      if (i != 0) {
        break label253;
      }
      if (this.vQF == null) {
        break label229;
      }
      localObject = this.vQF;
      if ((!o.Lu(((ScanUIRectView)localObject).mode)) || (((ScanUIRectView)localObject).vPj == null) || (!(((ScanUIRectView)localObject).vPj instanceof ScanCodeMaskView))) {
        break label224;
      }
    }
    label224:
    for (boolean bool = ((ScanUIRectView)localObject).vPj.onBackPressed();; bool = false)
    {
      if (!bool) {
        break label229;
      }
      dlQ();
      AppMethodBeat.o(51741);
      return;
      ad.i("MicroMsg.ScanUI", "alvinluo cancelNetworkLoading isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.vRm) });
      localObject = this.vRi;
      b.a locala = ((v)localObject).vPn;
      if (locala != null) {
        locala.dnb();
      }
      ((v)localObject).vPn = null;
      this.vRi.V(false, false);
      if (!this.vRm)
      {
        a(this.vQL, true, null);
        dlX();
        break;
      }
      dlQ();
      break;
    }
    label229:
    if (this.vQV == 12) {
      x.oU(false);
    }
    x.La(this.vQV);
    goBack();
    label253:
    AppMethodBeat.o(51741);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(51758);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.ScanUI", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    AppMethodBeat.o(51758);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51729);
    super.onCreate(paramBundle);
    oW(true);
    if ((g.aeS().auR() == 6) || (g.aeS().auR() == 4))
    {
      this.vQX = true;
      this.mHT = ((Vibrator)getSystemService("vibrator"));
      this.vRa = getIntent().getIntArrayExtra("key_support_scan_code_type");
      this.vRb = getIntent().getIntExtra("key_scan_entry_scene", 0);
      this.vRc = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
      this.vRd = getIntent().getBooleanExtra("key_set_result_after_scan", false);
      this.vRe = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
      this.vQV = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
      this.vQW = getIntent().getBooleanExtra("key_show_scan_tips", true);
      this.vQZ = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.vRl = getIntent().getBooleanExtra("key_config_black_interval", false);
      com.tencent.qbar.b.flM();
      com.tencent.qbar.f.flS();
      o.dno();
      com.tencent.mm.plugin.scanner.util.d.init();
      bool = o.dnr();
      ad.i("MicroMsg.ScanUI", "alvinluo initEnableMultiCode configEnableMultiCode: %b, entryEnableMultiCode: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.vRl) });
      paramBundle = com.tencent.qbar.h.flW();
      if ((!bool) || (!this.vRl)) {
        break label305;
      }
    }
    label305:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.vRl = bool;
      com.tencent.qbar.f.xs(bool);
      initView();
      this.vQU = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.ESL.c(this.nZA);
      com.tencent.mm.cr.d.fkP();
      x.dlC();
      AppMethodBeat.o(51729);
      return;
      this.vQX = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51755);
    ad.i("MicroMsg.ScanUI", "onDestroy()");
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ESL.d(this.nZA);
    if (this.vQO != null)
    {
      this.vQO.destroy();
      this.vQO = null;
    }
    if (this.vQF != null) {
      this.vQF.onDestroy();
    }
    if ((this.vQN != null) && (this.vQN.isShowing())) {
      this.vQN.dismiss();
    }
    AppMethodBeat.o(51755);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51753);
    super.onPause();
    ad.i("MicroMsg.ScanUI", "alvinluo onPause needPauseScan: %b", new Object[] { Boolean.valueOf(this.vRf) });
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (this.vQF != null)
    {
      this.vQF.onPause();
      if (this.vRf) {
        this.vQF.stopPreview();
      }
    }
    if (this.vRj.eiW == 0L) {
      W(false, false);
    }
    com.tencent.qbar.c.IoG.bmJ();
    com.tencent.mm.plugin.scanner.util.i locali = com.tencent.mm.plugin.scanner.util.i.waT;
    ad.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (locali.mSensorManager != null)
    {
      ad.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      locali.mSensorManager.unregisterListener(locali);
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(51753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51752);
    ad.i("MicroMsg.ScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51752);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.vQS = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new BaseScanUI.20(this), new BaseScanUI.21(this));
        AppMethodBeat.o(51752);
        return;
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
        {
          this.vQT = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new BaseScanUI.22(this), new BaseScanUI.24(this));
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51751);
    super.onResume();
    ad.i("MicroMsg.ScanUI", "alvinluo BaseScanUI onResume needPauseScan: %b", new Object[] { Boolean.valueOf(this.vRf) });
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    com.tencent.mm.plugin.scanner.util.i locali = com.tencent.mm.plugin.scanner.util.i.waT;
    ad.i("MicroMsg.ScanStableDetector", "start detect scan stable");
    if (locali.mSensorManager != null)
    {
      locali.waR = 0;
      locali.waQ[0] = 0.0F;
      locali.waQ[1] = 0.0F;
      locali.waQ[2] = 0.0F;
      ad.i("MicroMsg.ScanStableDetector", "register accelerate listener");
      locali.mSensorManager.registerListener(locali, locali.waP, 50000);
    }
    ad.i("MicroMsg.ScanUI", "should check camera %s, location %s", new Object[] { Boolean.valueOf(this.vQS), Boolean.valueOf(this.vQT) });
    boolean bool;
    int i;
    if ((this.vQS) || (this.vQT)) {
      if (this.vQS)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
        ad.i("MicroMsg.ScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          this.vPt = false;
          i = 0;
          if (i != 0)
          {
            x.oV(this.vPt);
            if (com.tencent.mm.compatible.d.b.XC()) {
              break label344;
            }
            com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new BaseScanUI.18(this), new BaseScanUI.19(this));
          }
        }
      }
    }
    for (;;)
    {
      getWindow().addFlags(128);
      AppMethodBeat.o(51751);
      return;
      if (this.vQT)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null);
        ad.i("MicroMsg.ScanUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      label344:
      ad.i("MicroMsg.ScanUI", "alvinluo onResumeAfterChkPermission needPauseScan: %b", new Object[] { Boolean.valueOf(this.vRf) });
      if (!this.vRf)
      {
        this.vQF.onResume();
        a(this.vQL, true, null);
        oX(true);
      }
      g.afA().a(this.vRr);
      dlV();
      com.tencent.mm.sdk.b.a.ESL.c(this.vRs);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(51754);
    super.onStop();
    if (this.vQF != null) {
      this.vQF.onStop();
    }
    this.vQG.dmF();
    g.afA().b(this.vRr);
    com.tencent.mm.sdk.b.a.ESL.d(this.vRs);
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