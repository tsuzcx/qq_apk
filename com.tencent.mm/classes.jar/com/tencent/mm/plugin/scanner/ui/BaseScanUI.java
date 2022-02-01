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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.b.a.jr;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.BoxDialogView;
import com.tencent.mm.plugin.scanner.c.a.2;
import com.tencent.mm.plugin.scanner.c.a.d;
import com.tencent.mm.plugin.scanner.d.d.a;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.model.w;
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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.s;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.d;
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
  private com.tencent.mm.ui.widget.a.e mDL;
  private Vibrator nKv;
  private com.tencent.mm.modelgeo.b.a oMc;
  private com.tencent.mm.sdk.b.c<yb> pgq;
  private com.tencent.mm.modelgeo.d wqv;
  private boolean yjH;
  private boolean yjI;
  private mc yjS;
  private ScanNetworkMaskView ynQ;
  private boolean ynY;
  private boolean ypA;
  private boolean ypB;
  private boolean ypC;
  private boolean ypD;
  private long ypE;
  private int ypF;
  private boolean ypG;
  private boolean ypH;
  private boolean ypI;
  private boolean ypJ;
  private boolean ypK;
  private int[] ypL;
  private int ypM;
  private boolean ypN;
  private boolean ypO;
  private boolean ypP;
  private BaseScanRequest ypQ;
  private boolean ypR;
  private boolean ypS;
  private boolean ypT;
  private boolean ypU;
  private aa ypV;
  private jr ypW;
  private int ypX;
  private boolean ypY;
  private boolean ypZ;
  private ScanUIRectView ypp;
  private ScannerFlashSwitcher ypq;
  private View ypr;
  private DialogInterface.OnCancelListener yps;
  private View ypt;
  private ImageView ypu;
  private ImageView ypv;
  private TextView ypw;
  private com.tencent.mm.plugin.scanner.box.e ypx;
  private com.tencent.mm.plugin.scanner.d.e ypy;
  private com.tencent.mm.plugin.scanner.ui.widget.b ypz;
  private ScanUIRectView.a yqa;
  private a.d yqb;
  private com.tencent.mm.plugin.scanner.d.a.a yqc;
  private com.tencent.mm.plugin.scanner.box.b yqd;
  private n yqe;
  private com.tencent.mm.sdk.b.c yqf;
  
  public BaseScanUI()
  {
    AppMethodBeat.i(51728);
    this.ypx = null;
    this.ypA = false;
    this.ypB = true;
    this.ypC = true;
    this.ypD = false;
    this.ynY = true;
    this.ypG = true;
    this.ypH = true;
    this.ypI = true;
    this.ypJ = true;
    this.ypK = false;
    this.ypS = false;
    this.ypT = true;
    this.ypU = true;
    this.ypV = new aa();
    this.ypW = new jr();
    this.ypY = false;
    this.ypZ = false;
    this.yqa = new ScanUIRectView.a()
    {
      public final void e(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51682);
        if (!BaseScanUI.a(BaseScanUI.this))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", new Object[] { Integer.valueOf(BaseScanUI.b(BaseScanUI.this)) });
          AppMethodBeat.o(51682);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "scan code cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)) });
          Object localObject2 = paramAnonymousBundle.getParcelableArrayList("result_qbar_result_list");
          if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
            AppMethodBeat.o(51682);
            return;
          }
          final int j = paramAnonymousBundle.getInt("result_code_point_count", 0);
          final long l = paramAnonymousBundle.getLong("decode_success_cost_time", 0L);
          ac.a(BaseScanUI.b(BaseScanUI.this), true, 1, j);
          BaseScanUI.e(BaseScanUI.this);
          Object localObject1 = BaseScanUI.this;
          if (j > 1) {}
          for (boolean bool = true;; bool = false)
          {
            BaseScanUI.a((BaseScanUI)localObject1, bool);
            BaseScanUI.b(BaseScanUI.this, false);
            ac.a(BaseScanUI.b(BaseScanUI.this), (List)localObject2, l);
            localObject1 = (WxQBarResult)((ArrayList)localObject2).get(0);
            if (!BaseScanUI.f(BaseScanUI.this)) {
              break label385;
            }
            if (localObject1 != null) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanUI", "first Qbar result is null");
            AppMethodBeat.o(51682);
            return;
          }
          paramAnonymousBundle = ((WxQBarResult)localObject1).typeName;
          Object localObject3 = new ph();
          localObject2 = ((WxQBarResult)localObject1).data;
          ((ph)localObject3).dDr.scanResult = ((String)localObject2);
          ((ph)localObject3).dDr.dDt = paramAnonymousBundle;
          ((ph)localObject3).dDr.dDp = 0;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("key_scan_result", (String)localObject2);
          ((Intent)localObject3).putExtra("key_scan_result_raw", ((WxQBarResult)localObject1).rawData);
          ((Intent)localObject3).putExtra("key_scan_result_code_name", paramAnonymousBundle);
          ((Intent)localObject3).putExtra("key_scan_result_code_version", ((WxQBarResult)localObject1).LKn);
          BaseScanUI.this.setResult(-1, (Intent)localObject3);
          BaseScanUI.this.bWi();
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
              BaseScanUI.g(BaseScanUI.this).setSuccessMarkClickListener(new com.tencent.mm.plugin.scanner.model.ad()
              {
                public final void OG(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(169958);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  if ((paramAnonymous2Int < this.yqh.size()) && (j > 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.b(BaseScanUI.this, true);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, l, (WxQBarResult)this.yqh.get(paramAnonymous2Int));
                    ac.l(2, paramAnonymous2Int, this.yqj);
                    ac.dLo();
                  }
                  AppMethodBeat.o(169958);
                }
              });
              BaseScanUI.k(BaseScanUI.this);
              localObject3 = BaseScanUI.g(BaseScanUI.this);
              if (com.tencent.mm.plugin.scanner.util.d.dMN())
              {
                if (((ScanUIRectView)localObject3).yty == null)
                {
                  ((ScanUIRectView)localObject3).yty = new ScanDebugView(((ScanUIRectView)localObject3).getContext());
                  ((ScanUIRectView)localObject3).addView(((ScanUIRectView)localObject3).yty);
                }
                if (((ScanUIRectView)localObject3).yty != null)
                {
                  localObject4 = ((ScanUIRectView)localObject3).yty;
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
                    localObject4 = ((ScanDebugView)localObject4).yya;
                    if (localObject4 == null) {
                      p.bcb("debugInfo");
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
                public final void dLD()
                {
                  AppMethodBeat.i(169959);
                  if ((j == 1) || (this.yqh.size() == 1))
                  {
                    BaseScanUI.d(BaseScanUI.this, false);
                    BaseScanUI.b(BaseScanUI.this, true);
                    BaseScanUI.a(BaseScanUI.this, paramAnonymousLong, this.val$result, l);
                    ac.l(1, 0, this.yqj);
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
              localObject3 = ((ScanDebugView)localObject4).yya;
              if (localObject3 == null) {
                p.bcb("debugInfo");
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
    this.yqb = new a.d()
    {
      public final void A(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(51710);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ScanUI", "alvinluo onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousString });
        String str = paramAnonymousString;
        if (bt.isNullOrNil(paramAnonymousString)) {
          str = BaseScanUI.this.getResources().getString(2131762888);
        }
        com.tencent.mm.ui.base.h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(2131755835), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(51708);
            BaseScanUI.q(BaseScanUI.this);
            ac.OA(BaseScanUI.b(BaseScanUI.this));
            AppMethodBeat.o(51708);
          }
        });
        ac.a(2, false, System.currentTimeMillis());
        AppMethodBeat.o(51710);
      }
      
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51709);
        if (BaseScanUI.l(BaseScanUI.this))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanUI", "alvinluo onScanSuccess isScrolling and ignore");
          AppMethodBeat.o(51709);
          return;
        }
        if ((BaseScanUI.c(BaseScanUI.this) != null) && (paramAnonymousBundle != null))
        {
          BaseScanUI.m(BaseScanUI.this);
          int i = paramAnonymousBundle.getInt("scan_source", 0);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo onScanSuccess cost time %d, scanImageCount: %d, source: %d, session: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.d(BaseScanUI.this)), Integer.valueOf(BaseScanUI.n(BaseScanUI.this)), Integer.valueOf(i), Long.valueOf(paramAnonymousLong) });
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
    this.yqc = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void ax(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(186184);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(paramAnonymousLong), Integer.valueOf(1) });
        BaseScanUI.s(BaseScanUI.this);
        AppMethodBeat.o(186184);
      }
      
      public final void b(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161970);
        String str;
        if (paramAnonymousInt1 == 2)
        {
          ac.O(false, paramAnonymousInt1);
          BaseScanUI.r(BaseScanUI.this);
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
              BaseScanUI.q(BaseScanUI.this);
              ac.OA(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(51717);
            }
          });
          AppMethodBeat.o(161970);
          return;
        }
        if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == 1003))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ScanUI", "alvinluo onScanResultFailed stop upload and show alert");
          if (BaseScanUI.c(BaseScanUI.this) != null) {
            BaseScanUI.c(BaseScanUI.this).y(paramAnonymousLong, false);
          }
          BaseScanUI.r(BaseScanUI.this);
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
              BaseScanUI.q(BaseScanUI.this);
              ac.OA(BaseScanUI.b(BaseScanUI.this));
              AppMethodBeat.o(161969);
            }
          });
        }
        AppMethodBeat.o(161970);
      }
      
      public final void b(w paramAnonymousw)
      {
        AppMethodBeat.i(51718);
        if (BaseScanUI.b(BaseScanUI.this) != 12)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvnluo onScanResultSuccess not SELECT_SCAN_MODE_GOODS and ignore");
          AppMethodBeat.o(51718);
          return;
        }
        if ((BaseScanUI.l(BaseScanUI.this)) || ((paramAnonymousw.dnh == 1) && (BaseScanUI.o(BaseScanUI.this))))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanUI", "alvinluo onScanResultSuccess source:%d, isScrolling: %b or needPauseScan: %b and ignore", new Object[] { Integer.valueOf(paramAnonymousw.dnh), Boolean.valueOf(BaseScanUI.l(BaseScanUI.this)), Boolean.valueOf(BaseScanUI.o(BaseScanUI.this)) });
          AppMethodBeat.o(51718);
          return;
        }
        BaseScanUI.a(BaseScanUI.this, paramAnonymousw);
        AppMethodBeat.o(51718);
      }
    };
    this.yqd = new com.tencent.mm.plugin.scanner.box.b()
    {
      public final void a(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(186186);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onDismiss exitType: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        BaseScanUI.u(BaseScanUI.this);
        BaseScanUI.v(BaseScanUI.this);
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.t(BaseScanUI.this), true);
        BaseScanUI.q(BaseScanUI.this);
        BaseScanUI.e(BaseScanUI.this, true);
        ac.za(System.currentTimeMillis());
        ac.a(paramAnonymousInt, BaseScanUI.p(BaseScanUI.this));
        ac.OA(12);
        AppMethodBeat.o(186186);
      }
      
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(186187);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onCancel");
        BaseScanUI.d(BaseScanUI.this, false);
        BaseScanUI.u(BaseScanUI.this);
        BaseScanUI.v(BaseScanUI.this);
        AppMethodBeat.o(186187);
      }
      
      public final void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(186185);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onShow");
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.t(BaseScanUI.this), false);
        BaseScanUI.e(BaseScanUI.this, false);
        ac.yZ(System.currentTimeMillis());
        AppMethodBeat.o(186185);
      }
    };
    this.yqe = new BaseScanUI.16(this);
    this.yqf = new com.tencent.mm.sdk.b.c() {};
    this.pgq = new BaseScanUI.18(this);
    AppMethodBeat.o(51728);
  }
  
  private void OH(int paramInt)
  {
    AppMethodBeat.i(51735);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo operateFlash operation: %d", new Object[] { Integer.valueOf(paramInt) });
    sl localsl = new sl();
    localsl.dGX.dkM = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(localsl);
    if (this.ypq != null)
    {
      if (paramInt == 1)
      {
        this.ypq.dMi();
        AppMethodBeat.o(51735);
        return;
      }
      this.ypq.dMj();
    }
    AppMethodBeat.o(51735);
  }
  
  private void OI(int paramInt)
  {
    AppMethodBeat.i(186197);
    ac.b(this.ypF, this.ypQ, paramInt);
    AppMethodBeat.o(186197);
  }
  
  private void a(View paramView, boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(186192);
    if (paramView == null)
    {
      AppMethodBeat.o(186192);
      return;
    }
    if ((paramBoolean) && (paramView.getAlpha() != 0.0F))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanUI", "alvinluo animateAlpha show ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(186192);
      return;
    }
    if ((!paramBoolean) && (paramView.getAlpha() != 1.0F))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanUI", "alvinluo animateAlpha hide ignore, view: %s", new Object[] { paramView });
      AppMethodBeat.o(186192);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUI", "alvinluo animateAlpha show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
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
      AppMethodBeat.o(186192);
      return;
      f1 = 1.0F;
      break;
    }
  }
  
  private void ad(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186194);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance success: %b, isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.FALSE });
    Object localObject = this.ypW;
    long l;
    if (paramBoolean1)
    {
      l = 1L;
      ((jr)localObject).eCc = l;
      this.ypW.eCd = (System.currentTimeMillis() - this.ypE);
      localObject = this.ypW;
      if (!this.ypp.dLW()) {
        break label369;
      }
      l = 0L;
      label83:
      ((jr)localObject).eCe = l;
      this.ypW.eCj = this.ypF;
      this.ypW.eCf = com.tencent.qbar.c.LKe.LKh;
      if (com.tencent.mm.plugin.scanner.util.i.yAa.dMP() > 0L) {
        this.ypW.eCi = (com.tencent.mm.plugin.scanner.util.i.yAa.dMP() - this.ypE);
      }
      this.ypW.aLk();
      if (o.OW(this.ypF))
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(1229L, 0L, 1L);
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        if (!paramBoolean1) {
          break label374;
        }
        l = 1L;
        label184:
        ((com.tencent.mm.plugin.report.service.g)localObject).n(1229L, 1L, l);
        if (paramBoolean1)
        {
          if (!this.ypp.dLW()) {
            break label379;
          }
          com.tencent.mm.plugin.report.service.g.yhR.n(1229L, 5L, 1L);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.n(1229L, 7L, this.ypW.eCd);
      com.tencent.mm.plugin.report.service.g.yhR.n(1229L, 9L, this.ypW.eCf);
      if ((paramBoolean1) && (paramBoolean2))
      {
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance scanTime: %s, totalFrames: %d", new Object[] { Long.valueOf(this.ypW.eCd), Long.valueOf(this.ypW.eCf) });
        com.tencent.mm.plugin.report.service.g.yhR.n(1229L, 11L, 1L);
        com.tencent.mm.plugin.report.service.g.yhR.n(1229L, 12L, this.ypW.eCd);
        com.tencent.mm.plugin.report.service.g.yhR.n(1229L, 14L, this.ypW.eCf);
      }
      AppMethodBeat.o(186194);
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
      com.tencent.mm.plugin.report.service.g.yhR.n(1229L, 3L, 1L);
    }
  }
  
  private void ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(51750);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUI", "alvinluo showFlash show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if ((this.ypq != null) && (!this.ypq.isShown()))
      {
        this.ypp.dMb();
        if (paramBoolean2) {
          this.ypq.show();
        }
        for (;;)
        {
          com.tencent.qbar.c.LKe.agA(1);
          ac.hn(this.ypF, 1);
          AppMethodBeat.o(51750);
          return;
          this.ypq.setVisibility(0);
        }
      }
    }
    else if ((this.ypq != null) && (!this.ypq.Vp))
    {
      this.ypp.dMc();
      if (paramBoolean2)
      {
        this.ypq.hide();
        AppMethodBeat.o(51750);
        return;
      }
      this.ypq.setVisibility(8);
    }
    AppMethodBeat.o(51750);
  }
  
  private void b(boolean paramBoolean, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(186191);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUI", "alvinluo switchCloseView isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ypw.setAlpha(0.0F);
      a(this.ypu, false, new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186171);
          BaseScanUI.a(BaseScanUI.this, BaseScanUI.F(BaseScanUI.this), true);
          if (paramAnimatorListener != null) {
            paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
          }
          AppMethodBeat.o(186171);
        }
      });
      AppMethodBeat.o(186191);
      return;
    }
    a(this.ypw, false, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186172);
        BaseScanUI.a(BaseScanUI.this, BaseScanUI.G(BaseScanUI.this), true);
        if (paramAnimatorListener != null) {
          paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(186172);
      }
    });
    AppMethodBeat.o(186191);
  }
  
  private void dLA()
  {
    AppMethodBeat.i(169987);
    int i = 0;
    if (o.OW(this.ypF)) {
      i = com.tencent.qbar.c.LKb;
    }
    for (;;)
    {
      com.tencent.qbar.c.LKe.agB(i);
      AppMethodBeat.o(169987);
      return;
      if (this.ypF == 12) {
        i = com.tencent.qbar.c.LKc;
      } else if (this.ypF == 3) {
        i = com.tencent.qbar.c.LKd;
      }
    }
  }
  
  private void dLB()
  {
    AppMethodBeat.i(51757);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo resumeScan");
    this.ypS = false;
    if (this.ypp != null) {
      this.ypp.onResume();
    }
    setEnableSwitchTab(true);
    AppMethodBeat.o(51757);
  }
  
  private void dLq()
  {
    AppMethodBeat.i(51732);
    ScanSharedMaskView localScanSharedMaskView = this.ypp.getSharedMaskView();
    if (localScanSharedMaskView == null)
    {
      AppMethodBeat.o(51732);
      return;
    }
    if (!this.yjH)
    {
      localScanSharedMaskView.getGalleryButton().setVisibility(0);
      localScanSharedMaskView.setOnGalleryClickListener(new BaseScanUI.32(this));
      AppMethodBeat.o(51732);
      return;
    }
    localScanSharedMaskView.getGalleryButton().setVisibility(8);
    AppMethodBeat.o(51732);
  }
  
  private void dLr()
  {
    AppMethodBeat.i(51734);
    ScanSharedMaskView localScanSharedMaskView = this.ypp.getSharedMaskView();
    if (localScanSharedMaskView != null) {
      this.ypq = localScanSharedMaskView.getFlashSwitcherView();
    }
    if (this.ypq != null)
    {
      this.ypq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(186165);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.qbar.c.LKe.agA(2);
          if (!BaseScanUI.B(BaseScanUI.this).Vp) {
            BaseScanUI.a(BaseScanUI.this, 1);
          }
          for (;;)
          {
            ac.hn(BaseScanUI.b(BaseScanUI.this), 2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186165);
            return;
            BaseScanUI.a(BaseScanUI.this, 2);
          }
        }
      });
      this.ypp.setFlashStatus(this.ypq.cMS);
      if (this.ypF == 3)
      {
        dLs();
        this.ypq.hide();
      }
    }
    AppMethodBeat.o(51734);
  }
  
  private void dLs()
  {
    AppMethodBeat.i(51736);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUI", "alvinluo checkAndOperateFlash operation: %d", new Object[] { Integer.valueOf(2) });
    if (this.ypq.Vp) {
      OH(2);
    }
    AppMethodBeat.o(51736);
  }
  
  private void dLt()
  {
    AppMethodBeat.i(51737);
    if (((o.OW(this.ypF)) || (dLv()) || (dLw())) && (!this.yjI) && (!this.ypR))
    {
      this.ypv.setVisibility(0);
      this.ypv.setOnClickListener(new BaseScanUI.5(this));
      AppMethodBeat.o(51737);
      return;
    }
    this.ypv.setVisibility(8);
    AppMethodBeat.o(51737);
  }
  
  private void dLu()
  {
    AppMethodBeat.i(186190);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo processMultiCodeCancel isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.ypZ) });
    if (!this.ypZ)
    {
      AppMethodBeat.o(186190);
      return;
    }
    this.ypZ = false;
    a(this.ypv, true, null);
    b(false, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186170);
        BaseScanUI.a(BaseScanUI.this, System.currentTimeMillis());
        BaseScanUI.q(BaseScanUI.this);
        AppMethodBeat.o(186170);
      }
    });
    qt(true);
    if (o.OW(this.ypF))
    {
      ac.l(3, -1, 0L);
      ac.dLn();
    }
    AppMethodBeat.o(186190);
  }
  
  private boolean dLv()
  {
    return this.ypF == 12;
  }
  
  private boolean dLw()
  {
    return this.ypF == 3;
  }
  
  private void dLx()
  {
    AppMethodBeat.i(51739);
    switch (this.ypF)
    {
    default: 
      this.ypp.setScanCallback(null);
      AppMethodBeat.o(51739);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.ypp.setScanCallback(this.yqa);
      this.ypy = new com.tencent.mm.plugin.scanner.d.d(this.ypF, this.ypM, this.ypp, this, this);
      AppMethodBeat.o(51739);
      return;
    }
    this.ypp.setScanCallback(this.yqb);
    this.ypy = new com.tencent.mm.plugin.scanner.d.a(this.ypF, this.ypp, this, this.yqc);
    AppMethodBeat.o(51739);
  }
  
  private void dLy()
  {
    AppMethodBeat.i(169986);
    if ((this.ypV != null) && (this.ypp != null)) {
      this.ypV.a(this.ypp.getScanMaskView(), this.ypp.getSharedMaskView(), this.ynQ);
    }
    AppMethodBeat.o(169986);
  }
  
  private void dLz()
  {
    AppMethodBeat.i(51748);
    if ((o.OW(this.ypF)) || (dLw()) || (dLv())) {}
    for (int i = 0; i != 0; i = 1)
    {
      qv(this.ypI);
      AppMethodBeat.o(51748);
      return;
    }
    qv(true);
    AppMethodBeat.o(51748);
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
  
  private void ho(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186193);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUI", "alvinluo reportSwitchTab %b", new Object[] { Boolean.valueOf(this.ypG) });
    ac.hm(paramInt1, paramInt2);
    ac.Ot(paramInt1);
    ac.Ov(paramInt1);
    ac.OA(paramInt1);
    AppMethodBeat.o(186193);
  }
  
  private void qs(boolean paramBoolean)
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
  
  private void qt(boolean paramBoolean)
  {
    AppMethodBeat.i(186189);
    if (this.ypz != null)
    {
      Object localObject = this.ypz;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanScrollTabController", "alvinluo setEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).setEnableSwitchTab(paramBoolean);
      localObject = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject).yyy;
      if (localObject != null)
      {
        ((ScanScrollTabView)localObject).setEnabled(paramBoolean);
        AppMethodBeat.o(186189);
        return;
      }
    }
    AppMethodBeat.o(186189);
  }
  
  private void qu(boolean paramBoolean)
  {
    AppMethodBeat.i(51747);
    if (paramBoolean)
    {
      this.ypr.setVisibility(0);
      this.ypp.cwE();
      this.ypr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(186176);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          BaseScanUI.K(BaseScanUI.this);
          BaseScanUI.h(BaseScanUI.this, false);
          BaseScanUI.q(BaseScanUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186176);
        }
      });
      if (this.ypp != null) {
        this.ypp.qx(true);
      }
      a(this.ypv, false, null);
      ae(false, true);
      AppMethodBeat.o(51747);
      return;
    }
    this.ypr.setVisibility(8);
    if (this.ypp != null) {
      this.ypp.qx(false);
    }
    a(this.ypv, true, null);
    AppMethodBeat.o(51747);
  }
  
  private void qv(boolean paramBoolean)
  {
    AppMethodBeat.i(51749);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "network change %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      qu(false);
      this.ypp.cwE();
    }
    AppMethodBeat.o(51749);
  }
  
  private void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51733);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo setEnableSwitchTab enable: %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.ypB) });
    if (this.ypz != null)
    {
      if (!paramBoolean) {
        break label95;
      }
      if (this.ypB) {
        this.ypz.setEnableSwitchTab(true);
      }
    }
    while (this.ypp != null) {
      if (paramBoolean)
      {
        if (this.ypB)
        {
          this.ypp.setEnableScrollSwitchTab(true);
          AppMethodBeat.o(51733);
          return;
          label95:
          this.ypz.setEnableSwitchTab(false);
        }
      }
      else {
        this.ypp.setEnableScrollSwitchTab(false);
      }
    }
    AppMethodBeat.o(51733);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.scanner.view.b.a parama)
  {
    AppMethodBeat.i(51746);
    if ((this.ypV != null) && (this.ypV.ynR)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo showLoadingView show: %b, isLoadingShow: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2) });
      this.ypS = paramBoolean1;
      if (this.ypV != null)
      {
        this.ypV.ynS = parama;
        if (this.ypV.ynR != paramBoolean1)
        {
          this.ypV.ac(paramBoolean1, paramBoolean2);
          if (paramBoolean1)
          {
            a(this.ypv, false, null);
            b(false, null);
          }
        }
      }
      AppMethodBeat.o(51746);
      return;
    }
  }
  
  public final void al(Bundle paramBundle)
  {
    AppMethodBeat.i(186195);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo onNetworkUnconnected");
    this.ypS = true;
    a(this.ypv, false, null);
    b(false, null);
    if (this.ypV != null) {
      if (paramBundle == null) {
        break label253;
      }
    }
    label238:
    label246:
    label253:
    for (boolean bool = paramBundle.getBoolean("key_offline_scan_show_tips", true);; bool = true)
    {
      aa localaa = this.ypV;
      paramBundle = localaa.ynO;
      if (paramBundle != null) {
        paramBundle.dMx();
      }
      paramBundle = localaa.ynO;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getTargetSuccessMarkView();
        Object localObject = localaa.ynQ;
        if (localObject != null) {
          ((ScanNetworkMaskView)localObject).setSuccessMarkView(paramBundle);
        }
        paramBundle = localaa.ynQ;
        if (paramBundle != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanNetworkMaskView", "alvinluo showNoNetworkView showTips: %s", new Object[] { Boolean.valueOf(bool) });
          if (paramBundle.yyc != null)
          {
            localObject = paramBundle.yyh;
            if (localObject == null) {
              p.bcb("noNetworkLayout");
            }
            localObject = (TextView)((View)localObject).findViewById(2131308192);
            if (localObject != null) {
              ((TextView)localObject).setText(2131762851);
            }
            paramBundle.qC(bool);
            if ((paramBundle.yyj[0] != 0) || (paramBundle.yyj[1] != 0)) {
              break label238;
            }
            paramBundle.yyl = true;
          }
        }
      }
      for (;;)
      {
        paramBundle = localaa.ynP;
        if (paramBundle == null) {
          break label246;
        }
        paramBundle.qI(false);
        AppMethodBeat.o(186195);
        return;
        paramBundle = null;
        break;
        paramBundle.qD(true);
      }
      AppMethodBeat.o(186195);
      return;
    }
  }
  
  public final void am(Bundle paramBundle)
  {
    AppMethodBeat.i(186196);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo onNetworkWeak");
    this.ypS = true;
    a(this.ypv, false, null);
    b(false, null);
    if (this.ypV != null) {
      if (paramBundle == null) {
        break label251;
      }
    }
    label236:
    label244:
    label251:
    for (boolean bool = paramBundle.getBoolean("key_offline_scan_show_tips", true);; bool = true)
    {
      aa localaa = this.ypV;
      paramBundle = localaa.ynO;
      if (paramBundle != null) {
        paramBundle.dMy();
      }
      paramBundle = localaa.ynO;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getTargetSuccessMarkView();
        Object localObject = localaa.ynQ;
        if (localObject != null) {
          ((ScanNetworkMaskView)localObject).setSuccessMarkView(paramBundle);
        }
        paramBundle = localaa.ynQ;
        if (paramBundle != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanNetworkMaskView", "alvinluo showWeakNetworkView needAnimateWeakNetworkView: %b, showTips: %b", new Object[] { Boolean.valueOf(paramBundle.yyo), Boolean.valueOf(bool) });
          localObject = paramBundle.yyh;
          if (localObject == null) {
            p.bcb("noNetworkLayout");
          }
          localObject = (TextView)((View)localObject).findViewById(2131308192);
          if (localObject != null) {
            ((TextView)localObject).setText(2131762854);
          }
          paramBundle.qC(bool);
          if (paramBundle.yyo) {
            break label236;
          }
          paramBundle.yyo = true;
          paramBundle.qD(false);
        }
      }
      for (;;)
      {
        paramBundle = localaa.ynP;
        if (paramBundle == null) {
          break label244;
        }
        paramBundle.setVisibility(8);
        AppMethodBeat.o(186196);
        return;
        paramBundle = null;
        break;
        paramBundle.qD(true);
      }
      AppMethodBeat.o(186196);
      return;
    }
  }
  
  public final void bWi()
  {
    AppMethodBeat.i(51743);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "finishUI");
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
    this.ypz = new com.tencent.mm.plugin.scanner.ui.widget.b(this);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    Object localObject2;
    Object localObject1;
    int i;
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      getWindow().addFlags(67109888);
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      this.ypr = findViewById(2131304320);
      this.ynQ = ((ScanNetworkMaskView)findViewById(2131304319));
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
      this.ypt = findViewById(2131306000);
      this.ypu = ((ImageView)findViewById(2131298365));
      this.ypv = ((ImageView)findViewById(2131302478));
      this.ypw = ((TextView)findViewById(2131302560));
      this.ypp = new ScanUIRectView(this);
      this.ypp.setScanRequest(this.ypQ);
      localObject2 = (ScanScrollTabView)findViewById(2131304329);
      localObject1 = this.ypz;
      p.h(localObject2, "scrollTabView");
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yyy = ((ScanScrollTabView)localObject2);
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yyy;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).removeAllTabs();
      }
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yyy;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)new b.c());
      }
      ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yyz.clear();
      localObject2 = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yyA).iterator();
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
      localObject1 = this.ypz;
      localObject2 = new com.tencent.mm.plugin.scanner.ui.widget.e()
      {
        public final void OK(int paramAnonymousInt)
        {
          AppMethodBeat.i(51695);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo onTabUnSelected tabId: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (o.OW(paramAnonymousInt)) {
            BaseScanUI.f(BaseScanUI.this, false);
          }
          BaseScanUI.OJ(paramAnonymousInt);
          if (paramAnonymousInt == 12) {
            BaseScanUI.dLC();
          }
          AppMethodBeat.o(51695);
        }
        
        public final void hp(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(51694);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo onTabSelected tabId: %d, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (!BaseScanUI.H(BaseScanUI.this)) {
            BaseScanUI.a(BaseScanUI.this, paramAnonymousInt1, paramAnonymousInt2);
          }
          for (;;)
          {
            if (BaseScanUI.b(BaseScanUI.this) != paramAnonymousInt1) {
              BaseScanUI.b(BaseScanUI.this, paramAnonymousInt1);
            }
            if (o.OW(paramAnonymousInt1)) {
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
      localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject1).yyy;
      if (localObject1 != null) {
        ((ScanScrollTabView)localObject1).setOnTabChangedListener((com.tencent.mm.plugin.scanner.ui.widget.e)localObject2);
      }
      localObject2 = this.ypz;
      localObject1 = new BaseScanUI.14(this);
      p.h(localObject1, "tabOnScrollListener");
      localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yyy;
      if (localObject2 != null) {
        ((ScanScrollTabView)localObject2).setOnTabScrollListener((com.tencent.mm.plugin.scanner.ui.widget.d)localObject1);
      }
      if (this.ypp != null) {
        this.ypp.setScrollTabController(this.ypz);
      }
      if ((this.ypN) || (this.ypF == 8)) {
        this.ypP = true;
      }
      label578:
      while (!com.tencent.mm.ax.b.aJn())
      {
        if (this.ypQ != null)
        {
          if (this.ypQ.yjE) {
            this.ypP = true;
          }
          if (this.ypQ.yjH) {
            this.yjH = true;
          }
          if (this.ypQ.yjI) {
            this.yjI = true;
          }
        }
        if (!this.ypP) {
          break;
        }
        localObject1 = this.ypz.yyy;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(8);
        }
        this.ypB = false;
        this.ypp.setBottomExtraHeight(0);
        setEnableSwitchTab(this.ypB);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo initView currentMode: %d, showOnlyScanCode: %b, hideScrollTab: %b, scanRequest: %s", new Object[] { Integer.valueOf(this.ypF), Boolean.valueOf(this.ypN), Boolean.valueOf(this.ypP), this.ypQ });
        this.ypp.setActivity(this);
        this.container.addView(this.ypp, 0, new FrameLayout.LayoutParams(-1, -1));
        this.ypp.onCreate();
        this.ypp.setShowScanTips(this.ypH);
        this.ypp.setNetworkAvailable(this.ypI);
        this.ypp.setScanMode(this.ypF);
        this.ypp.refreshView();
        ho(this.ypF, 0);
        dLy();
        ac.OA(this.ypF);
        dLA();
        if (this.ypK) {
          this.ypp.setBlackInterval(com.tencent.qbar.b.fTt());
        }
        dLq();
        dLx();
        if ((this.ypL != null) && (this.ypL.length > 0)) {
          this.ypp.setScanCodeReaders(this.ypL);
        }
        if (this.ypR) {
          this.ypp.setMyQrCodeVisible(false);
        }
        localObject2 = this.ypz;
        i = this.ypF;
        localObject1 = (Integer)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yyB.get(Integer.valueOf(i));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanScrollTabController", "alvinluo setSelectedTab tabId: %d, index: %s", new Object[] { Integer.valueOf(i), localObject1 });
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).bxN = ((Integer)localObject1).intValue();
          localObject2 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yyy;
          if (localObject2 != null) {
            ((ScanScrollTabView)localObject2).setSelectedTab(((Integer)localObject1).intValue());
          }
        }
        dLr();
        dLt();
        this.ypu.setVisibility(0);
        this.ypu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186168);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            BaseScanUI.dLC();
            BaseScanUI.e(BaseScanUI.this);
            BaseScanUI.w(BaseScanUI.this);
            ac.l(3, -1, 0L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186168);
          }
        });
        this.ypw.setOnClickListener(new BaseScanUI.7(this));
        AppMethodBeat.o(51730);
        return;
      }
      int j;
      if (o.dMS())
      {
        localObject2 = this.ypz;
        int[] arrayOfInt = new int[3];
        tmp970_968 = arrayOfInt;
        tmp970_968[0] = 1;
        tmp974_970 = tmp970_968;
        tmp974_970[1] = 12;
        tmp979_974 = tmp974_970;
        tmp979_974[2] = 3;
        tmp979_974;
        p.h(arrayOfInt, "tabIdList");
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabIdList size: %d", new Object[] { Integer.valueOf(3) });
        localObject1 = ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yyy;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).removeAllTabs();
        }
        ((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yyz.clear();
        j = 0;
        i = 0;
        if (j < 3)
        {
          int k = arrayOfInt[j];
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabId: %d", new Object[] { Integer.valueOf(k) });
          Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.scanner.ui.widget.b)localObject2).yyA).iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (b.b)localIterator.next();
            if (((b.b)localObject1).yyD == k)
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
        this.ypP = true;
        break;
        localObject1 = this.ypz.yyy;
        if (localObject1 != null) {
          ((ScanScrollTabView)localObject1).setVisibility(0);
        }
        this.ypp.setBottomExtraHeight(getResources().getDimensionPixelSize(2131166769));
        this.ypB = true;
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
          ac.OE(this.ypF);
          paramIntent = com.tencent.mm.ui.tools.a.j(this, paramIntent, com.tencent.mm.plugin.image.d.azA());
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "select: [%s]", new Object[] { paramIntent });
          if (!bt.isNullOrNil(paramIntent))
          {
            l1 = System.currentTimeMillis();
            com.tencent.qbar.c.LKf.agz(com.tencent.qbar.c.LJZ);
            com.tencent.qbar.e.fTw().a(this, l1, paramIntent, new e.b()
            {
              public final void a(final long paramAnonymousLong, e.d paramAnonymousd)
              {
                final List localList2 = null;
                AppMethodBeat.i(186182);
                if (paramAnonymousd != null) {}
                for (final List localList1 = paramAnonymousd.yof;; localList1 = null)
                {
                  if (paramAnonymousd != null) {
                    localList2 = paramAnonymousd.LKK;
                  }
                  if ((paramAnonymousLong == l1) && (BaseScanUI.S(BaseScanUI.this))) {
                    aq.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(186181);
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
                          ac.a(BaseScanUI.b(BaseScanUI.this), true, 2, 1);
                          if (BaseScanUI.f(BaseScanUI.this))
                          {
                            localObject = new Intent();
                            ((Intent)localObject).putExtra("key_scan_result", localBundle.getString("result_content"));
                            ((Intent)localObject).putExtra("key_scan_result_raw", localBundle.getByteArray("result_raw_data"));
                            ((Intent)localObject).putExtra("key_scan_result_code_name", localBundle.getString("result_code_name"));
                            ((Intent)localObject).putExtra("key_scan_result_code_version", i);
                            BaseScanUI.this.setResult(-1, (Intent)localObject);
                            BaseScanUI.this.bWi();
                            AppMethodBeat.o(186181);
                            return;
                          }
                          localBundle.putInt("qbar_string_scan_source", 1);
                          if (BaseScanUI.c(BaseScanUI.this) != null) {
                            BaseScanUI.c(BaseScanUI.this).c(paramAnonymousLong, localBundle);
                          }
                          BaseScanUI.k(BaseScanUI.this);
                          AppMethodBeat.o(186181);
                          return;
                          BaseScanUI.d(BaseScanUI.this, true);
                          BaseScanUI.h(BaseScanUI.this, true);
                          ac.a(BaseScanUI.b(BaseScanUI.this), false, 2, 1);
                          AppMethodBeat.o(186181);
                          return;
                        }
                      }
                    });
                  }
                  AppMethodBeat.o(186182);
                  return;
                }
              }
            }, this.ypL);
          }
          AppMethodBeat.o(51756);
          return;
        }
        dLB();
      } while ((paramInt2 != 0) || (!o.OW(this.ypF)));
      ac.OD(this.ypF);
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo processGoodsImage resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label533;
      }
      ac.OE(this.ypF);
      ac.aw(2, System.currentTimeMillis());
      str = com.tencent.mm.ui.tools.a.j(this, paramIntent, com.tencent.mm.plugin.image.d.azA());
      l1 = System.currentTimeMillis();
      if (paramIntent != null) {
        break label527;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUI", "alvinluo processGoodsImage session: %d, resultCode: %d, filePath: %s, data == null: %b", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool) });
      if (this.ypp != null) {
        this.ypp.setScanSource(2);
      }
      paramInt1 = BackwardSupportUtil.ExifHelper.cY(str);
      l2 = System.currentTimeMillis();
      paramIntent = com.tencent.mm.sdk.platformtools.g.aQg(str);
      l3 = System.currentTimeMillis();
      if ((paramInt1 != 90) && (paramInt1 != 270)) {
        break label549;
      }
      paramIntent = com.tencent.mm.sdk.platformtools.g.a(paramIntent, paramInt1);
    }
    label527:
    label533:
    label549:
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo processGoodsImage decode image cost: %d", new Object[] { Long.valueOf(l3 - l2) });
      if ((paramIntent != null) && (!paramIntent.isRecycled()))
      {
        localObject = this.ypp.getScanMaskView();
        if ((localObject instanceof ScanGoodsMaskView))
        {
          localObject = (ScanGoodsMaskView)localObject;
          ((ScanGoodsMaskView)localObject).ywp = true;
          ((ScanGoodsMaskView)localObject).ywq = false;
          ((ScanGoodsMaskView)localObject).ae(paramIntent);
        }
      }
      this.yps = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(186183);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo processGoodsImage onCancel and resumeScan");
          if ((BaseScanUI.c(BaseScanUI.this) instanceof com.tencent.mm.plugin.scanner.d.a))
          {
            paramAnonymousDialogInterface = (com.tencent.mm.plugin.scanner.d.a)BaseScanUI.c(BaseScanUI.this);
            long l = l1;
            paramAnonymousDialogInterface.yjS = null;
            com.tencent.mm.plugin.scanner.model.c localc = paramAnonymousDialogInterface.yoX;
            if (localc != null) {
              localc.yX(l);
            }
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.yoW;
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.yX(l);
            }
          }
          ac.a(2, false, System.currentTimeMillis(), true);
          BaseScanUI.q(BaseScanUI.this);
          AppMethodBeat.o(186183);
        }
      };
      if (this.ypp != null) {
        this.ypp.a(true, this.yps);
      }
      paramIntent = com.tencent.mm.plugin.scanner.c.a.dKN();
      Object localObject = this.yqb;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask filePath: %s", new Object[] { str });
      u.a(new a.2(paramIntent, str, (a.d)localObject, l1));
      AppMethodBeat.o(51756);
      return;
      bool = false;
      break label192;
      bool = false;
      break label261;
      dLB();
      if (paramInt2 != 0) {
        break;
      }
      ac.OD(12);
      break;
    }
  }
  
  public void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(51741);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUI", "alvinluo onBackPressed");
    if ((this.ypx != null) && (this.ypx.isShowing()))
    {
      this.ypx.dismiss();
      AppMethodBeat.o(51741);
      return;
    }
    Object localObject;
    if ((this.ypV == null) || (!this.ypV.ynR))
    {
      i = 0;
      if (i != 0) {
        break label253;
      }
      if (this.ypp == null) {
        break label229;
      }
      localObject = this.ypp;
      if ((!o.OW(((ScanUIRectView)localObject).mode)) || (((ScanUIRectView)localObject).ynO == null) || (!(((ScanUIRectView)localObject).ynO instanceof ScanCodeMaskView))) {
        break label224;
      }
    }
    label224:
    for (boolean bool = ((ScanUIRectView)localObject).ynO.onBackPressed();; bool = false)
    {
      if (!bool) {
        break label229;
      }
      dLu();
      AppMethodBeat.o(51741);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo cancelNetworkLoading isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.ypZ) });
      localObject = this.ypV;
      com.tencent.mm.plugin.scanner.view.b.a locala = ((aa)localObject).ynS;
      if (locala != null) {
        locala.dMH();
      }
      ((aa)localObject).ynS = null;
      this.ypV.ac(false, false);
      if (!this.ypZ)
      {
        a(this.ypv, true, null);
        dLB();
        break;
      }
      dLu();
      break;
    }
    label229:
    if (this.ypF == 12) {
      ac.qq(false);
    }
    ac.OB(this.ypF);
    goBack();
    label253:
    AppMethodBeat.o(51741);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(51758);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    AppMethodBeat.o(51758);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51729);
    super.onCreate(paramBundle);
    qs(true);
    if ((com.tencent.mm.kernel.g.aiU().aEN() == 6) || (com.tencent.mm.kernel.g.aiU().aEN() == 4))
    {
      this.ypI = true;
      this.nKv = ((Vibrator)getSystemService("vibrator"));
      this.ypL = getIntent().getIntArrayExtra("key_support_scan_code_type");
      this.ypM = getIntent().getIntExtra("key_scan_entry_scene", 0);
      this.ypN = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
      this.ypO = getIntent().getBooleanExtra("key_set_result_after_scan", false);
      this.yjI = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
      this.ypF = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
      this.ypH = getIntent().getBooleanExtra("key_show_scan_tips", true);
      this.ypK = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.ypY = getIntent().getBooleanExtra("key_config_black_interval", false);
      this.ypR = getIntent().getBooleanExtra("key_for_jsapi_use", false);
      this.yjH = this.yjI;
      if (dLv()) {
        this.ypQ = ((BaseScanRequest)getIntent().getParcelableExtra("key_scan_request"));
      }
      com.tencent.qbar.b.fTs();
      com.tencent.qbar.f.fTz();
      o.dMT();
      com.tencent.mm.plugin.scanner.util.d.init();
      bool = o.dMW();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo initEnableMultiCode configEnableMultiCode: %b, entryEnableMultiCode: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.ypY) });
      paramBundle = com.tencent.qbar.h.fTD();
      if ((!bool) || (!this.ypY)) {
        break label360;
      }
    }
    label360:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.ypY = bool;
      com.tencent.qbar.f.zp(bool);
      initView();
      this.ypE = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.IbL.c(this.pgq);
      com.tencent.mm.cq.d.fSu();
      ac.dLh();
      OI(1);
      t.dKV();
      AppMethodBeat.o(51729);
      return;
      this.ypI = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51755);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "onDestroy()");
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d(this.pgq);
    if (this.ypy != null)
    {
      this.ypy.destroy();
      this.ypy = null;
    }
    if (this.ypp != null) {
      this.ypp.onDestroy();
    }
    if ((this.ypx != null) && (this.ypx.isShowing())) {
      this.ypx.dismiss();
    }
    if ((this.mDL != null) && (this.mDL.isShowing())) {
      this.mDL.bpT();
    }
    if (this.wqv != null) {
      this.wqv.c(this.oMc);
    }
    OI(2);
    AppMethodBeat.o(51755);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51753);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo onPause needPauseScan: %b", new Object[] { Boolean.valueOf(this.ypS) });
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.ypp != null)
    {
      this.ypp.onPause();
      if (this.ypS) {
        this.ypp.stopPreview();
      }
    }
    if (this.ypW.eCc == 0L) {
      ad(false, false);
    }
    com.tencent.qbar.c.LKe.bxK();
    Object localObject = com.tencent.mm.plugin.scanner.util.i.yAa;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      ((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager.unregisterListener((SensorEventListener)localObject);
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.ypx != null)
    {
      localObject = this.ypx.ykY;
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BoxDialogView", "alvinluo onPause set canMeasured false");
        ((BoxDialogView)localObject).ykr = false;
        AppMethodBeat.o(51753);
        return;
      }
    }
    AppMethodBeat.o(51753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51752);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51752);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.ypC = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new BaseScanUI.21(this), new BaseScanUI.22(this));
        AppMethodBeat.o(51752);
        return;
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
        {
          this.ypD = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new BaseScanUI.24(this), new BaseScanUI.25(this));
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51751);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo BaseScanUI onResume needPauseScan: %b", new Object[] { Boolean.valueOf(this.ypS) });
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    Object localObject = com.tencent.mm.plugin.scanner.util.i.yAa;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanStableDetector", "start detect scan stable");
    if (((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager != null)
    {
      ((com.tencent.mm.plugin.scanner.util.i)localObject).yzY = 0;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).yzX[0] = 0.0F;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).yzX[1] = 0.0F;
      ((com.tencent.mm.plugin.scanner.util.i)localObject).yzX[2] = 0.0F;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanStableDetector", "register accelerate listener");
      ((com.tencent.mm.plugin.scanner.util.i)localObject).mSensorManager.registerListener((SensorEventListener)localObject, ((com.tencent.mm.plugin.scanner.util.i)localObject).yzW, 50000);
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "should check camera %s, location %s", new Object[] { Boolean.valueOf(this.ypC), Boolean.valueOf(this.ypD) });
    boolean bool;
    int i;
    if ((this.ypC) || (this.ypD)) {
      if (this.ypC)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          this.ynY = false;
          i = 0;
          if (i != 0)
          {
            ac.qr(this.ynY);
            if (com.tencent.mm.compatible.d.b.abb()) {
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
      if (this.ypx == null) {
        break label448;
      }
      localObject = this.ypx.ykY;
      if (localObject == null) {
        break label448;
      }
      ((BoxDialogView)localObject).ykr = true;
      AppMethodBeat.o(51751);
      return;
      if (this.ypD)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      label368:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUI", "alvinluo onResumeAfterChkPermission needPauseScan: %b", new Object[] { Boolean.valueOf(this.ypS) });
      if (!this.ypS)
      {
        this.ypp.onResume();
        a(this.ypv, true, null);
        qt(true);
      }
      com.tencent.mm.kernel.g.ajB().a(this.yqe);
      dLz();
      com.tencent.mm.sdk.b.a.IbL.c(this.yqf);
    }
    label448:
    AppMethodBeat.o(51751);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(51754);
    super.onStop();
    if (this.ypp != null) {
      this.ypp.onStop();
    }
    this.ypq.dMj();
    com.tencent.mm.kernel.g.ajB().b(this.yqe);
    com.tencent.mm.sdk.b.a.IbL.d(this.yqf);
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