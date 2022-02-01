package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zl;
import com.tencent.mm.g.a.zn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae.13;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae.2;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af.e;
import com.tencent.mm.plugin.wallet.balance.model.lqt.t;
import com.tencent.mm.plugin.wallet.balance.model.lqt.t.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.protocal.protobuf.ehw;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.protocal.protobuf.jf;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletLqtSaveFetchUI
  extends WalletLqtBasePresenterUI
  implements WcPayKeyboard.a
{
  private IListener<lj> AJa;
  public ae HAM;
  private af HAN;
  private ViewGroup HAO;
  private WalletFormView HAP;
  private TextView HAQ;
  private TextView HAR;
  private TextView HAS;
  private ImageView HAT;
  private TextView HAU;
  private TextView HAV;
  private ViewGroup HAW;
  private TextView HAX;
  private CheckBox HAY;
  private TextView HAZ;
  private List<Bankcard> HBA;
  private boolean HBB;
  private boolean HBC;
  private boolean HBD;
  private String HBE;
  private boolean HBF;
  private String HBG;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.u.a HBH;
  private TextView HBa;
  private LinearLayout HBb;
  private LinearLayout HBc;
  private LinearLayout HBd;
  private TextView HBe;
  private LinearLayout HBf;
  private LinearLayout HBg;
  private LinearLayout HBh;
  private TextView HBi;
  private TextView HBj;
  private boolean HBk;
  private WalletLqtArriveTimeLayout HBl;
  private ScrollView HBm;
  private LinearLayout HBn;
  private TextView HBo;
  private TextView HBp;
  private TextView HBq;
  private CharSequence HBr;
  private Bankcard HBs;
  private int HBt;
  private String HBu;
  private String HBv;
  private long HBw;
  public String HBx;
  private String HBy;
  private boolean HBz;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ac Hux;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ad Huy;
  protected boolean HvA;
  private Runnable HvB;
  private Bankcard Hvb;
  private a Hyf;
  private IListener Hyh;
  private int accountType;
  final View.OnClickListener hEZ;
  private Dialog jUV;
  public Runnable jVx;
  private int mode;
  private int state;
  private int wfU;
  private HashMap<String, Integer> yNN;
  private TextView zcC;
  
  public WalletLqtSaveFetchUI()
  {
    AppMethodBeat.i(69009);
    this.Hux = ((com.tencent.mm.plugin.wallet.balance.model.lqt.ac)au(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.class));
    this.Huy = ((com.tencent.mm.plugin.wallet.balance.model.lqt.ad)aq(com.tencent.mm.plugin.wallet.balance.model.lqt.ad.class));
    this.HAM = new ae(this.Hux, this.Huy, this);
    this.HAN = new af(this.HAM);
    this.HBw = -1L;
    this.HBz = false;
    this.HBB = true;
    this.HBC = false;
    this.HBD = false;
    this.HvA = false;
    this.HBE = "";
    this.HBF = false;
    this.wfU = MMApplicationContext.getContext().getResources().getColor(2131099748);
    this.HBG = "";
    this.HBH = new com.tencent.mm.plugin.wallet.balance.model.lqt.u.a()
    {
      public final void xK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(213995);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "cache updated show Error:".concat(String.valueOf(paramAnonymousBoolean)));
        if (!WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramAnonymousBoolean))
        {
          AppMethodBeat.o(213995);
          return;
        }
        WalletLqtSaveFetchUI.this.hideLoading();
        WalletLqtSaveFetchUI.this.fNR();
        WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this);
        if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1)
        {
          WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69001);
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setMinimumHeight(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getHeight());
              AppMethodBeat.o(69001);
            }
          });
          AppMethodBeat.o(213995);
          return;
        }
        if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
        {
          String str = WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText();
          if (!Util.isNullOrNil(str)) {
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, str);
          }
        }
        AppMethodBeat.o(213995);
      }
    };
    this.yNN = new HashMap();
    this.hEZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213992);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (Util.ticksToNow(WalletLqtSaveFetchUI.z(WalletLqtSaveFetchUI.this)) < 800L)
        {
          Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213992);
          return;
        }
        WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, Util.currentTicks());
        int k = WalletLqtSaveFetchUI.lr(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText(), "100");
        if (k > 0)
        {
          WalletLqtSaveFetchUI.this.hideWcKb();
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) != 1) {
            break label260;
          }
          Log.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
          if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtJ))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213992);
            return;
          }
          paramAnonymousView = WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).HuM;
          com.tencent.mm.vending.g.g.h(Integer.valueOf(k), Integer.valueOf(WalletLqtSaveFetchUI.A(WalletLqtSaveFetchUI.this)), WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this)).c(paramAnonymousView).f(new WalletLqtSaveFetchUI.20.2(this, k)).a(new com.tencent.mm.vending.g.d.a()
          {
            public final void cn(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(213988);
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[] { paramAnonymous2Object });
              WalletLqtSaveFetchUI.this.biW();
              if (paramAnonymous2Object != null) {
                if (!(paramAnonymous2Object instanceof String)) {
                  break label74;
                }
              }
              label74:
              for (paramAnonymous2Object = paramAnonymous2Object.toString();; paramAnonymous2Object = WalletLqtSaveFetchUI.this.getString(2131767869))
              {
                com.tencent.mm.ui.base.h.d(WalletLqtSaveFetchUI.this, paramAnonymous2Object, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(68983);
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "SAVE MMAlert Interrupt click");
                    AppMethodBeat.o(68983);
                  }
                });
                AppMethodBeat.o(213988);
                return;
              }
            }
          });
        }
        label260:
        while (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) != 2)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213992);
          return;
        }
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
        if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtK))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213992);
          return;
        }
        localObject = null;
        paramAnonymousView = (View)localObject;
        if (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this) != null)
        {
          paramAnonymousView = (View)localObject;
          if (!WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).fQb())
          {
            paramAnonymousView = new ja();
            paramAnonymousView.ynT = WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bankName;
            paramAnonymousView.dDj = WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bankcardType;
            paramAnonymousView.KNw = WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bindSerial;
            paramAnonymousView.AOk = WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bankcardTail;
          }
        }
        if (WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getSelectRedeemType() != null) {}
        for (int i = WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getSelectRedeemType().MJg;; i = 0)
        {
          int j = i;
          if (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this) != null)
          {
            j = i;
            if (!WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).fQb())
            {
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose bankcard");
              int m = f.nE(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText(), "100");
              localObject = x.fMZ().fNa();
              if ((((cux)localObject).MAm >= 0) && (m > ((cux)localObject).MAm))
              {
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose slow redeem");
                WalletLqtSaveFetchUI.B(WalletLqtSaveFetchUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213992);
                return;
              }
              j = i;
              if (((cux)localObject).MAm >= 0)
              {
                j = i;
                if (m < ((cux)localObject).MAm)
                {
                  Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose fast redeem");
                  j = 0;
                }
              }
            }
          }
          WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).HuN.a(k, WalletLqtSaveFetchUI.A(WalletLqtSaveFetchUI.this), j, paramAnonymousView).f(new WalletLqtSaveFetchUI.20.4(this, k)).a(new com.tencent.mm.vending.g.d.a()
          {
            public final void cn(Object paramAnonymous2Object)
            {
              boolean bool = false;
              AppMethodBeat.i(213990);
              WalletLqtSaveFetchUI.this.HvA = false;
              WalletLqtSaveFetchUI.this.biW();
              if (paramAnonymous2Object != null)
              {
                if ((paramAnonymous2Object instanceof dlv)) {
                  bool = com.tencent.mm.wallet_core.d.h.a(WalletLqtSaveFetchUI.this, null, 1000, ((dlv)paramAnonymous2Object).pTZ, ((dlv)paramAnonymous2Object).pUa);
                }
                if (!bool) {
                  if (!(paramAnonymous2Object instanceof String)) {
                    break label112;
                  }
                }
              }
              label112:
              for (paramAnonymous2Object = paramAnonymous2Object.toString();; paramAnonymous2Object = WalletLqtSaveFetchUI.this.getString(2131767869))
              {
                com.tencent.mm.ui.base.h.d(WalletLqtSaveFetchUI.this, paramAnonymous2Object, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(68987);
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "fetch MMAlert Interrupt click");
                    AppMethodBeat.o(68987);
                  }
                });
                AppMethodBeat.o(213990);
                return;
              }
            }
          });
          break;
        }
      }
    };
    this.Hyh = new IListener() {};
    this.state = 0;
    this.jVx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214006);
        if ((WalletLqtSaveFetchUI.E(WalletLqtSaveFetchUI.this) == 2) && (WalletLqtSaveFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletLqtSaveFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(214006);
      }
    };
    this.HvB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214007);
        WalletLqtSaveFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(214007);
      }
    };
    this.AJa = new IListener() {};
    AppMethodBeat.o(69009);
  }
  
  private void I(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(69014);
    Log.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    jf localjf;
    if (this.mode == 2)
    {
      localObject = x.fMZ().fNa();
      if (!this.HBl.HwS)
      {
        if (localObject == null)
        {
          Log.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
          AppMethodBeat.o(69014);
          return;
        }
        if (this.Hvb.fQb())
        {
          Log.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
          this.HBl.w(((cux)localObject).MAj, false);
          this.HBl.aUJ(paramString);
        }
        for (;;)
        {
          this.HBl.setVisibility(4);
          fNU();
          AppMethodBeat.o(69014);
          return;
          if (((cux)localObject).MAk != null)
          {
            localObject = ((cux)localObject).MAk.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localjf = (jf)((Iterator)localObject).next();
              if (localjf.KNw.equals(this.Hvb.field_bindSerial))
              {
                Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                this.HBl.w(localjf.KNM, false);
                this.HBl.aUJ(paramString);
              }
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (!this.Hvb.fQb()) {
          break label273;
        }
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
        this.HBl.w(((cux)localObject).MAj, true);
      }
    }
    for (;;)
    {
      this.HBl.setVisibility(4);
      this.HBl.aUJ(paramString);
      AppMethodBeat.o(69014);
      return;
      label273:
      if (((cux)localObject).MAk != null)
      {
        localObject = ((cux)localObject).MAk.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localjf = (jf)((Iterator)localObject).next();
          if (localjf.KNw.equals(this.Hvb.field_bindSerial))
          {
            Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
            this.HBl.w(localjf.KNM, true);
          }
        }
      }
    }
  }
  
  private static int a(t paramt)
  {
    if ((paramt == null) || (paramt.Htw == null)) {}
    do
    {
      return 0;
      paramt = paramt.Htw;
    } while ((paramt.MIk == null) && (paramt.MIl == null));
    if ((paramt.MIk != null) && (paramt.MIl != null)) {
      return 1;
    }
    return 2;
  }
  
  private com.tencent.mm.ui.widget.a.g a(final t paramt1, final t paramt2, t paramt3)
  {
    AppMethodBeat.i(214025);
    if ((paramt2 == null) || (paramt2.Htw == null))
    {
      AppMethodBeat.o(214025);
      return null;
    }
    final ddd localddd = paramt2.Htw;
    int j = 3;
    int i = j;
    if (localddd.MIi == 0)
    {
      i = j;
      if (TextUtils.isEmpty(localddd.title)) {
        i = 0;
      }
    }
    j = a(paramt2);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(getContext(), j, i);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i == 3)
    {
      if (localddd.MIi == 0)
      {
        localObject1 = new LinearLayout(this);
        ((LinearLayout)localObject1).setPadding(com.tencent.mm.cb.a.aH(this, 2131165299), com.tencent.mm.cb.a.aH(this, 2131165306), com.tencent.mm.cb.a.aH(this, 2131165299), com.tencent.mm.cb.a.aH(this, 2131165314));
        ((LinearLayout)localObject1).setOrientation(1);
        paramt1 = (t)localObject1;
        if (!TextUtils.isEmpty(localddd.title))
        {
          paramt1 = new TextView(this);
          ((LinearLayout)localObject1).addView(paramt1);
          paramt1.setGravity(3);
          localObject2 = new LinearLayout.LayoutParams(paramt1.getLayoutParams());
          ((LinearLayout.LayoutParams)localObject2).width = -1;
          ((LinearLayout.LayoutParams)localObject2).height = -2;
          ((LinearLayout.LayoutParams)localObject2).gravity = 3;
          paramt1.setTextSize(1, 17.0F);
          paramt1.setTextColor(getResources().getColor(2131100047));
          com.tencent.mm.ui.ao.a(paramt1.getPaint(), 0.8F);
          paramt1.setText(localddd.title);
          paramt1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramt1 = (t)localObject1;
        }
        localg.hv(paramt1);
      }
    }
    else
    {
      localObject1 = localddd.MIj;
      if (localObject1 != null)
      {
        paramt1 = new LinearLayout(this);
        paramt1.setOrientation(1);
        if (!TextUtils.isEmpty(((acl)localObject1).LmX))
        {
          localObject2 = new TextView(this);
          paramt1.addView((View)localObject2);
          localObject3 = new LinearLayout.LayoutParams(((TextView)localObject2).getLayoutParams());
          ((LinearLayout.LayoutParams)localObject3).width = -1;
          ((LinearLayout.LayoutParams)localObject3).height = -2;
          ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.aH(this, 2131165314);
          ((TextView)localObject2).setTextColor(getResources().getColor(2131100047));
          if ((localddd.MIi != 0) || (TextUtils.isEmpty(localddd.title))) {
            break label886;
          }
          ((TextView)localObject2).setTextSize(1, 15.0F);
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(((acl)localObject1).LmX);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      if (!TextUtils.isEmpty(((acl)localObject1).LmY))
      {
        localObject2 = new TextView(this);
        paramt1.addView((View)localObject2);
        localObject3 = new LinearLayout.LayoutParams(((TextView)localObject2).getLayoutParams());
        ((LinearLayout.LayoutParams)localObject3).width = -1;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.aH(this, 2131165314);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        com.tencent.mm.ui.ao.a(((TextView)localObject2).getPaint(), 0.8F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((TextView)localObject2).setText(((acl)localObject1).LmY);
        a((TextView)localObject2, false, (acl)localObject1, localg, paramt2, paramt3, paramt2.sQn);
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setOnTouchListener(new o(this));
      }
      localg.setCustomView(paramt1);
      if (j == 0)
      {
        paramt2 = new LinearLayout.LayoutParams(paramt1.getLayoutParams());
        paramt2.bottomMargin = com.tencent.mm.cb.a.aH(this, 2131165312);
        paramt1.setLayoutParams(paramt2);
      }
      if (j == 2)
      {
        if (localddd.MIk != null) {
          localg.T(localddd.MIk.dQx);
        }
        if (localddd.MIl != null) {
          localg.T(localddd.MIl.dQx);
        }
        localg.ape(1);
      }
      if (j == 1) {
        localg.b(localddd.MIk.dQx, localddd.MIl.dQx);
      }
      AppMethodBeat.o(214025);
      return localg;
      localObject1 = View.inflate(this, 2131495345, null);
      localObject2 = (WeImageView)((View)localObject1).findViewById(2131303975);
      localObject3 = (TextView)((View)localObject1).findViewById(2131304007);
      com.tencent.mm.ui.ao.a(((TextView)localObject3).getPaint(), 0.8F);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131304006);
      if (localddd.MIi == 2)
      {
        ((WeImageView)localObject2).setImageResource(2131690743);
        ((WeImageView)localObject2).setIconColor(getResources().getColor(2131099746));
      }
      ((WeImageView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214000);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          localg.bMo();
          if (localddd.MIi == 2)
          {
            paramAnonymousView = WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, null, paramt1, paramt2);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramAnonymousView, paramt1);
            paramAnonymousView.dGm();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214000);
        }
      });
      if (TextUtils.isEmpty(localddd.title)) {
        ((TextView)localObject3).setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localddd.desc)) {
          break label864;
        }
        localTextView.setVisibility(8);
        paramt1 = (t)localObject1;
        break;
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(localddd.title);
      }
      label864:
      localTextView.setVisibility(0);
      localTextView.setText(localddd.desc);
      paramt1 = (t)localObject1;
      break;
      label886:
      ((TextView)localObject2).setTextSize(1, 17.0F);
      com.tencent.mm.ui.ao.a(((TextView)localObject2).getPaint(), 0.8F);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, final acl paramacl, final com.tencent.mm.ui.widget.a.g paramg, final t paramt1, final t paramt2, final int paramInt)
  {
    AppMethodBeat.i(214026);
    if (paramacl != null)
    {
      String str2 = "";
      String str1 = str2;
      if (paramBoolean)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramacl.LmX)) {
          str1 = paramacl.LmX;
        }
      }
      if (!TextUtils.isEmpty(paramacl.LmY))
      {
        int i = str1.length();
        str1 = str1 + paramacl.LmY;
        paramacl = new e.a()
        {
          public final void bmr()
          {
            AppMethodBeat.i(214001);
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "showCommonPromptText, scene: %s, promptInfo.jump_type: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramacl.uSc) });
            if (paramInt >= 0) {
              com.tencent.mm.plugin.report.service.h.CyF.a(20287, new Object[] { Integer.valueOf(paramInt) });
            }
            switch (paramacl.uSc)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(214001);
              return;
              com.tencent.mm.ui.widget.a.g localg = WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramt1, paramt2, null);
              WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, localg, paramt2);
              if (paramg != null) {
                paramg.bMo();
              }
              if ((localg != null) && (!localg.isShowing()))
              {
                localg.dGm();
                AppMethodBeat.o(214001);
                return;
                f.bn(WalletLqtSaveFetchUI.this.getContext(), paramacl.pTL);
                AppMethodBeat.o(214001);
                return;
                f.u(paramacl.Hwr, paramacl.pTL, 0, 1000);
              }
            }
          }
        };
        f.a(paramTextView, str1, i, str1.length(), new com.tencent.mm.wallet_core.ui.e(paramacl), getContext());
        paramTextView.setVisibility(0);
        AppMethodBeat.o(214026);
        return;
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramTextView.setVisibility(0);
        paramTextView.setText(str1);
      }
    }
    AppMethodBeat.o(214026);
  }
  
  private void a(final com.tencent.mm.ui.widget.a.g paramg, final t paramt)
  {
    AppMethodBeat.i(214024);
    if (paramg == null)
    {
      AppMethodBeat.o(214024);
      return;
    }
    int i = a(paramt);
    paramt = paramt.Htw;
    if (i == 2)
    {
      paramg.QOT = new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(213994);
          sf localsf2 = paramt.MIk;
          sf localsf1 = localsf2;
          if (localsf2 == null) {
            localsf1 = paramt.MIl;
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramg, localsf1);
          AppMethodBeat.o(213994);
        }
      };
      AppMethodBeat.o(214024);
      return;
    }
    if (i == 1) {
      paramg.a(new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(213996);
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramg, paramt.MIk);
          AppMethodBeat.o(213996);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(213997);
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramg, paramt.MIl);
          AppMethodBeat.o(213997);
        }
      });
    }
    AppMethodBeat.o(214024);
  }
  
  private boolean aUQ(String paramString)
  {
    AppMethodBeat.i(69011);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optString("guide_flag");
        paramString = ((JSONObject)localObject2).optString("guide_wording");
        String str1 = ((JSONObject)localObject2).optString("left_button_wording");
        String str2 = ((JSONObject)localObject2).optString("right_button_wording");
        localObject2 = ((JSONObject)localObject2).optString("upload_credit_url");
        if ("2".equals(localObject1))
        {
          localObject1 = new com.tencent.mm.ui.widget.a.d.a(getContext());
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).Dk(false);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).boo(paramString);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).bov(str1);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).bou(str2);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(214019);
              f.p(WalletLqtSaveFetchUI.this.getContext(), this.HCn, false);
              AppMethodBeat.o(214019);
            }
          });
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).hbn().show();
          AppMethodBeat.o(69011);
          return true;
        }
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69011);
    return false;
  }
  
  private void cC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182506);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", new Object[] { paramString });
    long l1 = f.nF(String.valueOf(paramString), "100");
    Object localObject1;
    int m;
    Object localObject2;
    int j;
    label641:
    label648:
    int k;
    if (l1 > 0L)
    {
      if (this.mode == 1) {
        if (this.Hvb != null) {
          if (this.Hvb.fQb()) {
            if ((this.HBs != null) && (l1 > lp(this.HBs.HVC, "100")))
            {
              this.HAU.setText(getString(2131767941));
              this.HAU.setTextColor(getResources().getColor(2131099819));
              this.HBz = false;
              xP(false);
            }
          }
        }
      }
      for (;;)
      {
        if (l1 <= 0L)
        {
          this.HBB = true;
          AppMethodBeat.o(182506);
          return;
          if ((com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtH >= 0) && (l1 > com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtH) && (!Util.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtE)) && (!Util.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtF)) && (!Util.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtG)))
          {
            paramString = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
            {
              public final void dF(View paramAnonymousView)
              {
                AppMethodBeat.i(213998);
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                f.a(WalletLqtSaveFetchUI.this.getContext(), com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtG, true, 1);
                AppMethodBeat.o(213998);
              }
            });
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtE);
            ((SpannableStringBuilder)localObject1).append(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtF);
            ((SpannableStringBuilder)localObject1).setSpan(paramString, com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtE.length(), ((SpannableStringBuilder)localObject1).length(), 18);
            if ((this.HAU.getText() == null) || (!this.HAU.getText().equals(((SpannableStringBuilder)localObject1).toString()))) {
              com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(9) });
            }
            this.HAU.setOnTouchListener(new o(getContext()));
            this.HAU.setClickable(true);
            this.HAU.setText((CharSequence)localObject1);
            this.HAU.setTextColor(this.wfU);
            this.HBz = false;
            xP(false);
          }
          else
          {
            this.HAU.setText(this.HBr);
            this.HAU.setTextColor(this.wfU);
            this.HBz = true;
            xP(true);
            continue;
            if ((this.Hvb.field_dayQuotaKind > 0.0D) && (l1 > lp(this.Hvb.field_dayQuotaKind, "100")))
            {
              this.HAU.setText(getString(2131767942));
              this.HAU.setTextColor(getResources().getColor(2131099819));
              this.HBz = false;
              xP(false);
              com.tencent.mm.plugin.report.service.h.CyF.a(21467, new Object[] { this.Hvb.field_bankcardType, Long.valueOf(l1), Integer.valueOf(1), Double.valueOf(this.Hvb.field_dayQuotaKind) });
            }
            else
            {
              this.HAU.setText("");
              this.HBz = true;
              xP(true);
              continue;
              this.HBz = true;
              xP(true);
              continue;
              if (this.mode == 2)
              {
                m = 0;
                localObject2 = x.fMZ().fNa();
                if (localObject2 == null)
                {
                  j = 0;
                  if (localObject2 != null) {
                    break label760;
                  }
                  i = 0;
                  if ((this.Hvb == null) || (!this.Hvb.fQb())) {
                    break label1722;
                  }
                  k = getIntent().getIntExtra("lqt_balance", 0);
                }
              }
            }
          }
        }
      }
    }
    for (int i = 1;; i = m)
    {
      if (i != 0)
      {
        if (l1 > k)
        {
          this.HAU.setText(getString(2131767844));
          this.HAU.setTextColor(getResources().getColor(2131099819));
          this.HBz = false;
          fNS();
          xP(false);
          this.HBn.setVisibility(8);
          break;
          j = ((cux)localObject2).MAf;
          break label641;
          label760:
          i = ((cux)localObject2).MAh;
          break label648;
        }
        this.HAU.setText(this.HBr);
        this.HAU.setTextColor(this.wfU);
        this.HBz = true;
        I(paramBoolean, paramString);
        xP(true);
        this.HBn.setVisibility(8);
        break;
      }
      if (l1 > j)
      {
        this.HAU.setText(getString(2131767844));
        this.HAU.setTextColor(getResources().getColor(2131099819));
        this.HBn.setVisibility(8);
        this.HBz = false;
        fNS();
        xP(false);
        this.HBn.setVisibility(8);
        break;
      }
      long l2;
      if (l1 > k)
      {
        l2 = f.nF(this.HBE, "100");
        if (l1 >= l2) {
          com.tencent.mm.plugin.report.service.h.CyF.a(20287, new Object[] { Integer.valueOf(9) });
        }
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "balance > lqtBalance, balance: %s, previousBalance: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        paramString = getString(2131767829, new Object[] { Double.valueOf(lo(String.valueOf(j), "100")) });
        this.HAU.setTextColor(this.wfU);
        this.HAU.setText(paramString);
        if ((localObject2 != null) && ((!TextUtils.isEmpty(((cux)localObject2).MAq)) || (((cux)localObject2).MAr != null)))
        {
          Log.i("MicroMsg.WalletLqtSaveFetchUI", "balance > lqtBalance, go to new redeem to bank exceed tips");
          if (!TextUtils.isEmpty(((cux)localObject2).MAq))
          {
            this.HBn.setVisibility(0);
            paramString = ((cux)localObject2).MAq;
          }
        }
      }
      try
      {
        localObject1 = String.format(paramString, new Object[] { f.formatMoney2f(lo(String.valueOf(k), "100")) });
        paramString = (String)localObject1;
      }
      catch (Exception localException2)
      {
        label1122:
        acl localacl;
        break label1122;
      }
      this.HBp.setText(paramString);
      this.HBp.setVisibility(0);
      localacl = ((cux)localObject2).MAr;
      if ((localacl != null) && (!TextUtils.isEmpty(localacl.LmX)))
      {
        paramString = localacl.LmX;
        l2 = k;
      }
      try
      {
        localObject1 = String.format(paramString, new Object[] { f.formatMoney2f(lo(String.valueOf(l1 - l2), "100")) });
        paramString = (String)localObject1;
      }
      catch (Exception localException1)
      {
        label1205:
        break label1205;
      }
      localObject1 = new acl();
      ((acl)localObject1).LmX = paramString;
      ((acl)localObject1).uSc = localacl.uSc;
      ((acl)localObject1).LmY = localacl.LmY;
      ((acl)localObject1).pTL = localacl.pTL;
      ((acl)localObject1).Hwr = localacl.Hwr;
      paramString = ((cux)localObject2).MAs;
      localObject2 = new t.a();
      ((t.a)localObject2).Htw = paramString;
      paramString = ((t.a)localObject2).fMT();
      a(this.HBo, true, (acl)localObject1, null, null, paramString, 10);
      for (;;)
      {
        this.HBz = false;
        fNS();
        xP(false);
        break;
        this.HBn.setVisibility(0);
        paramString = getString(2131767857, new Object[] { Double.valueOf(lo(String.valueOf(k), "100")) });
        i = paramString.length();
        paramString = paramString + getString(2131767860);
        f.a(this.HBo, paramString, i, paramString.length(), new com.tencent.mm.wallet_core.ui.e(new e.a()
        {
          public final void bmr()
          {
            AppMethodBeat.i(213999);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, this.HCa);
            AppMethodBeat.o(213999);
          }
        }), getContext());
        this.HBp.setVisibility(8);
      }
      if ((this.Hvb != null) && (!this.Hvb.fQb()) && (this.Hvb.field_dayQuotaKind > 0.0D) && (l1 > lp(this.Hvb.field_dayQuotaKind, "100")))
      {
        this.HBn.setVisibility(0);
        this.HBo.setText(getString(2131767847, new Object[] { Double.valueOf(this.Hvb.field_dayQuotaKind) }));
        this.HBp.setVisibility(8);
        this.HBz = false;
        fNS();
        xP(false);
        break;
      }
      this.HAU.setText(this.HBr);
      this.HAU.setTextColor(this.wfU);
      this.HBz = true;
      I(paramBoolean, paramString);
      xP(true);
      this.HBn.setVisibility(8);
      break;
      if (this.mode == 1) {
        if ((this.Hvb != null) && (this.Hvb.fQb())) {
          this.HAU.setText(this.HBr);
        }
      }
      for (;;)
      {
        this.HAU.setTextColor(this.wfU);
        this.HBz = false;
        xP(false);
        break;
        this.HAU.setText("");
        continue;
        this.HAU.setText(this.HBr);
        fNS();
      }
      this.HBB = false;
      AppMethodBeat.o(182506);
      return;
      label1722:
      k = i;
    }
  }
  
  private void fNQ()
  {
    AppMethodBeat.i(214022);
    String str1 = getString(2131767843);
    String str2 = getString(2131767734);
    com.tencent.mm.ui.base.h.a(getContext(), str1, "", str2, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69003);
        WalletLqtSaveFetchUI.this.finish();
        AppMethodBeat.o(69003);
      }
    });
    AppMethodBeat.o(214022);
  }
  
  private void fNS()
  {
    AppMethodBeat.i(69013);
    WalletLqtArriveTimeLayout localWalletLqtArriveTimeLayout = this.HBl;
    localWalletLqtArriveTimeLayout.HwS = false;
    if (localWalletLqtArriveTimeLayout.HwO != null) {
      localWalletLqtArriveTimeLayout.HwO.clear();
    }
    localWalletLqtArriveTimeLayout.HwQ = null;
    localWalletLqtArriveTimeLayout.HwP.clear();
    localWalletLqtArriveTimeLayout.setVisibility(4);
    AppMethodBeat.o(69013);
  }
  
  private List<Bankcard> fNT()
  {
    AppMethodBeat.i(69016);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1).xG(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        s.fOg();
        localObject1 = s.fOh().fRJ();
      }
      localObject2 = new LinkedList();
      if (localObject1 != null) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label200;
        }
        Bankcard localBankcard = (Bankcard)((Iterator)localObject1).next();
        if (localBankcard.fQb())
        {
          s.fOg();
          if (!s.fOh().fRm())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.fQb()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.fQb()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label200:
    AppMethodBeat.o(69016);
    return localObject2;
  }
  
  private void fNU()
  {
    AppMethodBeat.i(69019);
    this.HBm.postDelayed(new WalletLqtSaveFetchUI.21(this), 100L);
    AppMethodBeat.o(69019);
  }
  
  private void fX(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(214023);
    this.yNN.clear();
    final com.tencent.mm.plugin.wallet.ui.a locala = new com.tencent.mm.plugin.wallet.ui.a(this);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
    this.HBA = com.tencent.mm.plugin.wallet.balance.model.lqt.u.aem(this.mode);
    localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
    boolean bool;
    cki localcki;
    if (this.mode == 1)
    {
      bool = true;
      localcki = ((com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1).xF(bool);
      if (this.Hvb == null) {
        break label670;
      }
    }
    label133:
    label521:
    label527:
    label535:
    label541:
    label670:
    for (localObject1 = this.Hvb.field_bindSerial;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = this.HBx;
        if (Util.isNullOrNil(this.HBx)) {
          com.tencent.mm.kernel.g.aAi();
        }
      }
      for (localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OfO, "");; localObject1 = localObject2)
      {
        int i = 0;
        if (i < this.HBA.size())
        {
          localObject2 = (Bankcard)this.HBA.get(i);
          if ((Util.isNullOrNil(((Bankcard)localObject2).field_bindSerial)) || (!((String)localObject1).equals(((Bankcard)localObject2).field_bindSerial))) {}
        }
        for (;;)
        {
          locala.HLX = new o.f()
          {
            public final void onCreateMMMenu(final m paramAnonymousm)
            {
              AppMethodBeat.i(213974);
              int j = WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).size();
              int i = 0;
              final Bankcard localBankcard;
              Object localObject1;
              if (i < j)
              {
                localBankcard = (Bankcard)WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).get(i);
                localObject1 = com.tencent.mm.plugin.wallet_core.d.b.j(WalletLqtSaveFetchUI.this, localBankcard.field_bankcardType, localBankcard.fQa());
                if (localObject1 == null) {
                  break label736;
                }
              }
              label161:
              label597:
              label603:
              label736:
              for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).AAU;; str1 = "")
              {
                Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str1));
                com.tencent.mm.platformtools.u.a(new com.tencent.mm.platformtools.u.a()
                {
                  public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
                  {
                    AppMethodBeat.i(213971);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(213970);
                        Log.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletLqtSaveFetchUI.5.1.this.AMF });
                        if ((WalletLqtSaveFetchUI.5.this.HBM.qAx.isShowing()) && (WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.this).containsKey(paramAnonymous2String)))
                        {
                          int i = ((Integer)WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.this).get(paramAnonymous2String)).intValue();
                          if ((i < WalletLqtSaveFetchUI.5.1.this.yNV.size()) && (WalletLqtSaveFetchUI.5.1.this.yNV.getItem(i) != null))
                          {
                            WalletLqtSaveFetchUI.5.1.this.yNV.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymous2Bitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167138), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167138), true, false)));
                            WalletLqtSaveFetchUI.5.this.HBM.fPw();
                          }
                        }
                        AppMethodBeat.o(213970);
                      }
                    });
                    AppMethodBeat.o(213971);
                  }
                });
                Drawable localDrawable = null;
                Object localObject4 = null;
                localObject1 = "";
                if (!Util.isNullOrNil(localBankcard.field_forbidWord)) {
                  localObject1 = localBankcard.field_forbidWord;
                }
                Object localObject3;
                Object localObject2;
                String str2;
                if (Util.isNullOrNil(localBankcard.field_forbid_title))
                {
                  localObject3 = new SpannableStringBuilder((CharSequence)localObject1);
                  localObject2 = localObject1;
                  localObject1 = localObject3;
                  localObject3 = localObject1;
                  if (Util.isNullOrNil((CharSequence)localObject1))
                  {
                    localObject3 = localObject1;
                    if (!Util.isNullOrNil(localBankcard.field_prompt_info_prompt_text))
                    {
                      localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
                      localObject3 = localObject1;
                      if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_text))
                      {
                        localObject3 = localObject1;
                        if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_url))
                        {
                          ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                          ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
                          {
                            public final void dF(View paramAnonymous2View)
                            {
                              AppMethodBeat.i(213973);
                              f.bn(WalletLqtSaveFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                              com.tencent.mm.plugin.report.service.h.CyF.a(20216, new Object[] { Integer.valueOf(2), localBankcard.field_prompt_info_jump_url });
                              AppMethodBeat.o(213973);
                            }
                          }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
                          localObject3 = localObject1;
                        }
                      }
                    }
                  }
                  str2 = localBankcard.field_desc;
                  if (!localBankcard.fQb()) {
                    break label603;
                  }
                  localObject1 = str2;
                  if (localBankcard.HVC >= 0.0D) {
                    localObject1 = str2 + WalletLqtSaveFetchUI.this.getString(2131767442, new Object[] { f.D(localBankcard.HVC) });
                  }
                  Log.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), localObject1, localObject3 });
                  localDrawable = WalletLqtSaveFetchUI.this.getResources().getDrawable(2131235574);
                  if (Util.isNullOrNil((String)localObject2)) {
                    break label597;
                  }
                }
                for (boolean bool = true;; bool = false)
                {
                  paramAnonymousm.a(i, (CharSequence)localObject1, (CharSequence)localObject3, localDrawable, 0, bool);
                  localObject1 = localObject4;
                  if (localObject1 == null) {
                    WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.this).put(str1, Integer.valueOf(i));
                  }
                  i += 1;
                  break;
                  localObject2 = (String)localObject1 + " ";
                  localObject1 = new SpannableStringBuilder((String)localObject2 + localBankcard.field_forbid_title);
                  localObject3 = new l(WalletLqtSaveFetchUI.this)
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(213972);
                      paramAnonymous2View = localBankcard.field_forbid_url;
                      Intent localIntent = new Intent();
                      Log.i("MicroMsg.WalletLqtSaveFetchUI", "go to url %s", new Object[] { paramAnonymous2View });
                      localIntent.putExtra("rawUrl", paramAnonymous2View);
                      localIntent.putExtra("geta8key_username", z.aTY());
                      localIntent.putExtra("pay_channel", 1);
                      f.aA(WalletLqtSaveFetchUI.this.getContext(), localIntent);
                      AppMethodBeat.o(213972);
                    }
                  };
                  int k = ((String)localObject2).length();
                  int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
                  ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(WalletLqtSaveFetchUI.this.getResources().getColor(2131100685)), k, m, 33);
                  ((SpannableStringBuilder)localObject1).setSpan(localObject3, k, m, 33);
                  break label161;
                }
                localObject1 = localDrawable;
                if (localBitmap != null) {
                  localObject1 = BitmapUtil.extractThumbNail(localBitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167138), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167138), true, false);
                }
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject3 });
                if (localObject1 == null)
                {
                  localObject4 = null;
                  if (Util.isNullOrNil((String)localObject2)) {
                    break label724;
                  }
                }
                for (bool = true;; bool = false)
                {
                  paramAnonymousm.a(i, str2, (CharSequence)localObject3, (Drawable)localObject4, 0, bool);
                  break;
                  localObject4 = new BitmapDrawable((Bitmap)localObject1);
                  break label681;
                }
                AppMethodBeat.o(213974);
                return;
              }
            }
          };
          locala.a(new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(213975);
              if (locala == null)
              {
                AppMethodBeat.o(213975);
                return;
              }
              WalletLqtSaveFetchUI.aet(paramInt);
              locala.qAx.bMo();
              if (locala.jKz < WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).size())
              {
                Bankcard localBankcard = (Bankcard)WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).get(locala.jKz);
                WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, localBankcard.field_bindSerial);
                WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
                if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
                {
                  if ((!TextUtils.isEmpty(paramString)) && (!localBankcard.fQb()))
                  {
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).setText(paramString);
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                    WalletLqtSaveFetchUI.this.showWcKb();
                    AppMethodBeat.o(213975);
                    return;
                  }
                  WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).eIj();
                  AppMethodBeat.o(213975);
                  return;
                }
                if ((WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this)) && (!localBankcard.fQb())) {
                  WalletLqtSaveFetchUI.p(WalletLqtSaveFetchUI.this);
                }
                WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText());
              }
              AppMethodBeat.o(213975);
            }
          });
          localObject1 = View.inflate(this, 2131495345, null);
          paramString = (TextView)((View)localObject1).findViewById(2131304007);
          localObject2 = (TextView)((View)localObject1).findViewById(2131304006);
          if ((localcki != null) && (!TextUtils.isEmpty(localcki.MpQ)))
          {
            paramString.setText(localcki.MpQ);
            if (!TextUtils.isEmpty(localcki.MpR))
            {
              ((TextView)localObject2).setText(localcki.MpR);
              ((TextView)localObject2).setVisibility(0);
              label304:
              com.tencent.mm.ui.ao.a(paramString.getPaint(), 0.8F);
              ((View)localObject1).findViewById(2131299577).setVisibility(0);
              ((View)localObject1).findViewById(2131303975).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68975);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  if (locala != null) {
                    locala.qAx.bMo();
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(68975);
                }
              });
              paramString = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
              if (this.mode != 1) {
                break label521;
              }
              bool = true;
              label362:
              paramString.xI(bool);
              if (!bool) {
                break label527;
              }
              paramString = paramString.Htx;
              label378:
              if (paramString == null) {
                break label535;
              }
            }
          }
          for (bool = paramString.MpH;; bool = false)
          {
            if (!bool) {
              break label541;
            }
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
            locala.HMf = true;
            locala.T(getResources().getString(2131767686));
            locala.jKz = i;
            locala.HMg = true;
            locala.setTitleView((View)localObject1);
            locala.dGm();
            AppMethodBeat.o(214023);
            return;
            bool = false;
            break;
            i += 1;
            break label133;
            ((TextView)localObject2).setVisibility(8);
            break label304;
            if (this.mode == 1)
            {
              paramString.setText(2131767939);
              ((TextView)localObject2).setText(2131767938);
              break label304;
            }
            paramString.setText(2131767840);
            ((TextView)localObject2).setText(2131767839);
            break label304;
            bool = false;
            break label362;
            paramString = paramString.Hty;
            break label378;
          }
          paramString = new m(this);
          if (this.mode == 1) {
            paramString.a(0, getString(2131767945), null, getResources().getDrawable(2131690865), getResources().getColor(2131099749), false);
          }
          for (;;)
          {
            locala.a(paramString, new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(213976);
                if (locala == null)
                {
                  AppMethodBeat.o(213976);
                  return;
                }
                locala.qAx.bMo();
                if ((WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1) || (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)) {
                  WalletLqtSaveFetchUI.q(WalletLqtSaveFetchUI.this);
                }
                AppMethodBeat.o(213976);
              }
            });
            break;
            if (this.mode == 2) {
              paramString.a(0, getString(2131767851), null, getResources().getDrawable(2131690865), getResources().getColor(2131099749), false);
            }
          }
          i = 0;
        }
      }
    }
  }
  
  private void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(69021);
    this.mWcKeyboard.DH(paramBoolean);
    AppMethodBeat.o(69021);
  }
  
  private static double lo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69032);
    try
    {
      if (Util.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        double d = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 5, 2).doubleValue();
        AppMethodBeat.o(69032);
        return d;
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(69032);
    }
  }
  
  private static int lp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69033);
    try
    {
      double d1 = Util.getDouble(paramString1, 0.0D);
      double d2 = Util.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      int i = paramString1.multiply(new BigDecimal(paramString2)).intValue();
      AppMethodBeat.o(69033);
      return i;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(69033);
    }
    return 0;
  }
  
  private void xO(boolean paramBoolean)
  {
    AppMethodBeat.i(69015);
    if ((this.mode == 2) && (paramBoolean))
    {
      this.Hvb = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.xE(false);
      if (this.Hvb == null)
      {
        this.HBc.setVisibility(0);
        this.HBe.setText(getString(2131767842));
        this.HBd.setVisibility(8);
        this.HBf.setVisibility(0);
        this.HBg.setVisibility(8);
        this.HBi.setText(getString(2131767824));
        this.HAR.setClickable(false);
        if (findViewById(2131298278) != null) {
          findViewById(2131298278).setClickable(false);
        }
        this.HAP.setContentClickable(false);
        localObject1 = this.HAP.getContentEt();
        if (localObject1 != null) {
          ((EditText)localObject1).setCursorVisible(false);
        }
        findViewById(2131310208).setVisibility(8);
        this.HBn.setVisibility(8);
        this.HAW.setVisibility(8);
        this.HAV.setVisibility(8);
        this.HBh.setVisibility(8);
        this.HBb.setVisibility(8);
        AppMethodBeat.o(69015);
        return;
      }
    }
    if (this.mode == 2)
    {
      this.HAR.setClickable(true);
      if (findViewById(2131298278) != null) {
        findViewById(2131298278).setClickable(true);
      }
      this.HAP.setContentClickable(true);
      localObject1 = this.HAP.getContentEt();
      if (localObject1 != null) {
        ((EditText)localObject1).setCursorVisible(true);
      }
    }
    this.HBc.setVisibility(8);
    this.HBd.setVisibility(0);
    this.HBf.setVisibility(8);
    this.HBg.setVisibility(0);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
    boolean bool;
    Object localObject2;
    Object localObject3;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1).xG(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        s.fOg();
        localObject1 = s.fOh().fRJ();
      }
      localObject2 = new LinkedList();
      if (localObject1 != null) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label516;
        }
        localObject3 = (Bankcard)((Iterator)localObject1).next();
        if (((Bankcard)localObject3).fQb())
        {
          s.fOg();
          if (!s.fOh().fRm())
          {
            ((List)localObject2).add(localObject3);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && (((Bankcard)localObject3).field_support_lqt_turn_in == 1)) {
          ((List)localObject2).add(localObject3);
        }
        if ((this.mode == 2) && (((Bankcard)localObject3).field_support_lqt_turn_out == 1)) {
          ((List)localObject2).add(localObject3);
        }
      }
    }
    label516:
    final int i;
    if (paramBoolean)
    {
      if (!Util.isNullOrNil(this.HBy))
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject1 = (Bankcard)((List)localObject2).get(i);
          if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.HBy.equals(((Bankcard)localObject1).field_bindSerial))) {
            this.Hvb = ((Bankcard)localObject1);
          }
          i += 1;
        }
      }
      if ((Util.isNullOrNil(this.HBy)) || (this.Hvb == null))
      {
        localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
        if (this.mode == 1) {}
        for (bool = true;; bool = false)
        {
          this.Hvb = ((com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1).xE(bool);
          if ((Util.isNullOrNil(this.HBx)) || (this.Hvb != null)) {
            break;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = (Bankcard)((List)localObject2).get(i);
            if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.HBx.equals(((Bankcard)localObject1).field_bindSerial))) {
              this.Hvb = ((Bankcard)localObject1);
            }
            i += 1;
          }
        }
      }
    }
    else if (!Util.isNullOrNil(this.HBx))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.HBx.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.Hvb = ((Bankcard)localObject1);
        }
        i += 1;
      }
    }
    if (this.Hvb != null) {}
    for (localObject1 = this.Hvb.field_bindSerial;; localObject1 = "")
    {
      Log.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", new Object[] { localObject1, this.HBx, Boolean.valueOf(paramBoolean) });
      if (this.Hvb != null) {
        break;
      }
      s.fOg();
      this.Hvb = s.fOh().Hwc;
      if (this.Hvb != null) {
        break;
      }
      finish();
      AppMethodBeat.o(69015);
      return;
    }
    if (this.Hvb.fQb())
    {
      this.HAR.setText(this.Hvb.field_desc);
      this.HAR.setText(this.Hvb.field_desc);
      this.HAR.setVisibility(0);
      this.HAT.setTag(this.Hvb.field_bindSerial);
      if (this.HAT != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Hvb.field_bankcardType, this.Hvb.fQa());
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject2).AAU;
        }
        this.HAT.setImageBitmap(null);
        if (!this.Hvb.fQb()) {
          break label1606;
        }
        this.HAT.setImageResource(2131235574);
      }
      label1027:
      this.HBh.setVisibility(8);
      this.HBb.setVisibility(8);
      if (this.mode != 2) {
        break label1678;
      }
      localObject1 = x.fMZ().fNa();
      if ((localObject1 != null) && (!this.Hvb.fQb()) && (!TextUtils.isEmpty(((cux)localObject1).MAn)))
      {
        this.HBh.setVisibility(0);
        this.HAZ.setText(((cux)localObject1).MAn);
        this.HAZ.setVisibility(0);
      }
      label1115:
      if (this.mode != 1) {
        break label2045;
      }
      localObject1 = getIntent().getStringArrayListExtra("lqt_protocol_list");
      paramBoolean = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (!paramBoolean)) {
        break label2033;
      }
      this.HAW.setVisibility(0);
      this.HAY.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
      this.HAW.setOnClickListener(new WalletLqtSaveFetchUI.11(this));
      this.HAY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(213980);
          if (!paramAnonymousBoolean)
          {
            WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, false);
            AppMethodBeat.o(213980);
            return;
          }
          WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, true);
          AppMethodBeat.o(213980);
        }
      });
      localObject2 = getString(2131767932);
      i = ((String)localObject2).length();
      localObject2 = new SpannableString((String)localObject2 + getString(2131767933));
      ((SpannableString)localObject2).setSpan(new com.tencent.mm.wallet_core.ui.e(new WalletLqtSaveFetchUI.14(this, (ArrayList)localObject1)), i, ((SpannableString)localObject2).length(), 17);
      this.HAX.setText((CharSequence)localObject2);
      this.HAX.setClickable(true);
      this.HAX.setOnTouchListener(new o());
    }
    for (;;)
    {
      if (this.mode == 1)
      {
        if ((this.Hvb != null) && (this.Hvb.fQb()))
        {
          this.HAU.setText(this.HBr);
          localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.xF(true);
          if (localObject1 != null)
          {
            if ((((cki)localObject1).MpO != null) && (!Util.isNullOrNil(((cki)localObject1).MpO.LmX)))
            {
              localObject2 = new SpannableStringBuilder(((cki)localObject1).MpO.LmX);
              if ((!Util.isNullOrNil(((cki)localObject1).MpO.LmY)) && (!Util.isNullOrNil(((cki)localObject1).MpO.pTL)))
              {
                ((SpannableStringBuilder)localObject2).append(((cki)localObject1).MpO.LmY);
                ((SpannableStringBuilder)localObject2).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
                {
                  public final void dF(View paramAnonymousView)
                  {
                    AppMethodBeat.i(213969);
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                    f.a(WalletLqtSaveFetchUI.this.getContext(), this.HBL.MpO.pTL, true, 1);
                    com.tencent.mm.plugin.report.service.h.CyF.a(20216, new Object[] { Integer.valueOf(1), this.HBL.MpO.pTL });
                    AppMethodBeat.o(213969);
                  }
                }), ((cki)localObject1).MpO.LmX.length(), ((SpannableStringBuilder)localObject2).length(), 18);
              }
              this.HAS.setText((CharSequence)localObject2);
              this.HAS.setClickable(true);
              this.HAS.setOnTouchListener(new o(getContext()));
              this.HAS.setVisibility(0);
              this.wfU = getResources().getColor(2131099746);
              AppMethodBeat.o(69015);
              return;
              this.HAR.setText(getString(2131767467, new Object[] { this.Hvb.field_bankName, this.Hvb.field_bankcardTail }));
              break;
              label1606:
              localObject1 = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
              com.tencent.mm.platformtools.u.a(new com.tencent.mm.platformtools.u.a()
              {
                public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
                {
                  AppMethodBeat.i(213967);
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(213966);
                      if ((WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this) != null) && (WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this) != null) && (WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).getTag() != null) && (WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).getTag().equals(WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bindSerial))) {
                        WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).setImageBitmap(paramAnonymousBitmap);
                      }
                      AppMethodBeat.o(213966);
                    }
                  });
                  AppMethodBeat.o(213967);
                }
              });
              if (localObject1 == null) {
                break label1027;
              }
              localObject1 = BitmapUtil.extractThumbNail((Bitmap)localObject1, getResources().getDimensionPixelOffset(2131167138), getResources().getDimensionPixelOffset(2131167138), true, false);
              this.HAT.setImageBitmap((Bitmap)localObject1);
              break label1027;
              label1678:
              if (this.mode != 1) {
                break label1115;
              }
              if ((!this.Hvb.fQb()) && (!Util.isNullOrNil(this.Hvb.field_avail_save_wording)))
              {
                this.HBh.setVisibility(0);
                this.HAZ.setText(this.Hvb.field_avail_save_wording);
                this.HAZ.setVisibility(0);
              }
              localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
              label1754:
              String str;
              if (this.mode == 1)
              {
                paramBoolean = true;
                localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1).xF(paramBoolean);
                if (localObject1 == null) {
                  break label1115;
                }
                localObject3 = ((cki)localObject1).MpP;
                if ((this.Hvb == null) || (!this.Hvb.fQb()) || (localObject3 == null)) {
                  break label1115;
                }
                this.HAN.HuQ.jP(0, 1);
                this.HBk = true;
                com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(25) });
                str = ((acl)localObject3).LmX;
                localObject1 = ((acl)localObject3).LmY;
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "tryShowSaveFromLqBubble, promptText: %s, jumpText: %s", new Object[] { str, localObject1 });
                if (TextUtils.isEmpty(str)) {
                  break label2023;
                }
                i = 1;
                label1882:
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label2028;
                }
              }
              label2023:
              label2028:
              for (int j = 1;; j = 0)
              {
                TextView localTextView = (TextView)this.HBb.findViewById(2131306319);
                localObject2 = (TextView)this.HBb.findViewById(2131306317);
                localTextView.setVisibility(4);
                ((TextView)localObject2).setVisibility(4);
                if ((i != 0) || (j != 0)) {
                  this.HBb.setVisibility(0);
                }
                if (i != 0)
                {
                  localTextView.setVisibility(0);
                  localTextView.setText(str);
                }
                if (j == 0) {
                  break;
                }
                ((TextView)localObject2).setVisibility(0);
                localObject3 = new e.a()
                {
                  public final void bmr()
                  {
                    AppMethodBeat.i(213968);
                    com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(26) });
                    WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).HuQ.jP(1, 0);
                    switch (this.HBK.uSc)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(213968);
                      return;
                      WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, 1);
                      AppMethodBeat.o(213968);
                      return;
                      f.bn(WalletLqtSaveFetchUI.this.getContext(), this.HBK.pTL);
                      AppMethodBeat.o(213968);
                      return;
                      f.u(this.HBK.Hwr, this.HBK.pTL, 0, 1000);
                    }
                  }
                };
                f.a((TextView)localObject2, (String)localObject1, 0, ((String)localObject1).length(), new com.tencent.mm.wallet_core.ui.e((e.a)localObject3), getContext());
                break;
                paramBoolean = false;
                break label1754;
                i = 0;
                break label1882;
              }
              label2033:
              this.HAW.setVisibility(8);
              continue;
              label2045:
              if (this.mode != 2) {
                continue;
              }
              findViewById(2131310208).setVisibility(8);
              this.HBn.setVisibility(8);
              this.HAW.setVisibility(8);
              this.HAV.setVisibility(8);
              localObject1 = x.fMZ();
              if ((this.Hvb != null) && (this.Hvb.fQb()))
              {
                i = getIntent().getIntExtra("lqt_balance", 0);
                if (com.tencent.mm.platformtools.ac.jPD) {
                  i = 50000000;
                }
                if (i <= 0) {
                  continue;
                }
                localObject1 = getString(2131767858, new Object[] { Double.valueOf(lo(String.valueOf(i), "100")) });
                j = ((String)localObject1).length();
                localObject1 = new SpannableString((String)localObject1 + " " + getString(2131767861));
                ((SpannableString)localObject1).setSpan(new com.tencent.mm.wallet_core.ui.e(new e.a()
                {
                  public final void bmr()
                  {
                    AppMethodBeat.i(214021);
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).setText(f.formatMoney2f(WalletLqtSaveFetchUI.lq(i, "100")));
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                    WalletLqtSaveFetchUI.this.showWcKb();
                    AppMethodBeat.o(214021);
                  }
                }), j, ((SpannableString)localObject1).length(), 18);
                this.HBr = ((CharSequence)localObject1);
                this.HAU.setText((CharSequence)localObject1);
                continue;
              }
              if (((x)localObject1).fNa() == null) {}
              for (i = 0;; i = ((x)localObject1).fNa().MAf)
              {
                if (((x)localObject1).fNa() != null) {
                  ((x)localObject1).fNa();
                }
                if (com.tencent.mm.platformtools.ac.jPD) {
                  i = 100000000;
                }
                localObject1 = getString(2131767829, new Object[] { Double.valueOf(lo(String.valueOf(i), "100")) });
                this.HBr = ((CharSequence)localObject1);
                this.HAU.setText((CharSequence)localObject1);
                break;
              }
            }
            this.HAS.setVisibility(8);
            this.wfU = getResources().getColor(2131099748);
          }
          AppMethodBeat.o(69015);
          return;
        }
        this.HAU.setText("");
        this.HAS.setVisibility(8);
      }
    }
    AppMethodBeat.o(69015);
  }
  
  private void xP(boolean paramBoolean)
  {
    AppMethodBeat.i(69022);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "check enable: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.HBC) });
    if ((!paramBoolean) || (this.HBC))
    {
      gf(false);
      AppMethodBeat.o(69022);
      return;
    }
    if (this.mode == 1)
    {
      if (this.HAW.getVisibility() == 0)
      {
        if ((this.HAY.isChecked()) && (this.HBz))
        {
          gf(true);
          AppMethodBeat.o(69022);
          return;
        }
        gf(false);
        AppMethodBeat.o(69022);
        return;
      }
      if (this.HBz)
      {
        gf(true);
        AppMethodBeat.o(69022);
      }
    }
    else
    {
      if ((this.HBz) && ((this.HBl.getSelectRedeemType() != null) || (this.HBl.getRedeemTypeList() == null) || (this.HBl.getRedeemTypeList().isEmpty())))
      {
        if (this.HBl.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.HBl.getSelectRedeemType().MJg))
        {
          Log.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          gf(true);
          AppMethodBeat.o(69022);
          return;
        }
      }
      gf(false);
    }
    AppMethodBeat.o(69022);
  }
  
  public final void bO(float paramFloat) {}
  
  public final void biW()
  {
    AppMethodBeat.i(69029);
    if (this.jUV != null) {
      this.jUV.dismiss();
    }
    AppMethodBeat.o(69029);
  }
  
  public final void fNR()
  {
    AppMethodBeat.i(69012);
    if (this.mode == 1)
    {
      this.HBs = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.fMU();
      if (this.HBs == null)
      {
        s.fOg();
        this.HBs = s.fOh().Hwc;
      }
      Object localObject;
      int i;
      if (this.HBs != null)
      {
        localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.fMV();
        i = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.fMW();
        if (i != 0) {
          break label189;
        }
        this.HBr = ((CharSequence)localObject);
        if (this.HAU != null) {
          this.HAU.setText(this.HBr);
        }
      }
      if (this.HAO != null) {
        this.HAO.setVisibility(0);
      }
      if (!Util.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtI))
      {
        this.zcC.setText(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtI);
        this.zcC.setVisibility(0);
      }
      for (;;)
      {
        localObject = x.fMZ().fNa();
        if ((localObject != null) && (((cux)localObject).Mma) && (((cux)localObject).MAl != null)) {
          com.tencent.mm.plugin.wallet.balance.model.lqt.ah.a(getContext(), ((cux)localObject).MAl);
        }
        xO(true);
        AppMethodBeat.o(69012);
        return;
        label189:
        if (i == 1)
        {
          i = ((String)localObject).length();
          localObject = new SpannableString((String)localObject + getString(2131767828));
          ((SpannableString)localObject).setSpan(new com.tencent.mm.wallet_core.ui.e(new e.a()
          {
            public final void bmr()
            {
              AppMethodBeat.i(69005);
              WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).setText(f.formatMoney2f(WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).HVC));
              WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
              WalletLqtSaveFetchUI.this.showWcKb();
              AppMethodBeat.o(69005);
            }
          }), i + 1, ((SpannableString)localObject).length(), 18);
          this.HBr = ((CharSequence)localObject);
          break;
        }
        Log.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", new Object[] { Integer.valueOf(i) });
        this.HBr = ((CharSequence)localObject);
        break;
        this.zcC.setVisibility(8);
      }
    }
    if (this.HBl.HwS)
    {
      xO(false);
      AppMethodBeat.o(69012);
      return;
    }
    xO(true);
    AppMethodBeat.o(69012);
  }
  
  public final void fNV()
  {
    AppMethodBeat.i(69031);
    MMHandlerThread.removeRunnable(this.jVx);
    MMHandlerThread.removeRunnable(this.HvB);
    AppMethodBeat.o(69031);
  }
  
  public int getLayoutId()
  {
    return 2131496958;
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(69026);
    Log.d("MicroMsg.WalletLqtSaveFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.HvA), Boolean.valueOf(this.mWcKeyboard.hgR()) });
    if ((!this.HvA) && (this.mWcKeyboard.hgR()))
    {
      AppMethodBeat.o(69026);
      return true;
    }
    AppMethodBeat.o(69026);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69027);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onActivityResult() requestCode:%s", new Object[] { Integer.valueOf(paramInt1) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.HAN.HuP.jQ(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(69027);
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra(ae.Huw, this.HBx);
    }
    ae localae = this.HAM;
    String str1;
    if ((paramInt1 == ae.Huu) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra(ae.Huw);
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.HZd != null) && (paramIntent.HZd.size() > 0))
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(localae.hashCode()), Integer.valueOf(localae.accountType), paramIntent.dDL });
        localae.dDM = ((Orders.Commodity)paramIntent.HZd.get(0)).dDM;
        paramIntent = (String)localae.HuG.get(paramIntent.dDL);
        if (!Util.isNullOrNil(paramIntent)) {
          localae.HuA = paramIntent;
        }
        if ((localae.Huz instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)localae.Huz).HvA = true;
          ((WalletLqtSaveFetchUI)localae.Huz).fNV();
        }
        localae.fW(str1, 0);
      }
      AppMethodBeat.o(69027);
      return;
    }
    if ((paramInt1 == ae.Huv) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra(ae.Huw);
      String str2 = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
      paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
      Log.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localae.hashCode()), Integer.valueOf(localae.accountType), paramIntent });
      if ((localae.Huz instanceof WalletLqtSaveFetchUI))
      {
        ((WalletLqtSaveFetchUI)localae.Huz).HvA = true;
        ((WalletLqtSaveFetchUI)localae.Huz).fNV();
      }
      Log.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localae.hashCode()), paramIntent });
      if (Util.isNullOrNil(localae.HuD))
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localae.hashCode()), paramIntent });
        localae.HuD = paramIntent;
      }
      paramIntent = localae.Huz.getIntent().getStringExtra("operate_id");
      localae.Huz.showLoading(true);
      ad.c localc = localae.Huy.Hur;
      com.tencent.mm.vending.g.g.b(Integer.valueOf(localae.HuC), str2, localae.HuD, Integer.valueOf(localae.accountType), paramIntent).c(localc).f(new ae.2(localae, str1)).a(new ae.13(localae));
    }
    AppMethodBeat.o(69027);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69010);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131100898));
    hideActionbarLine();
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
    this.Hyf = new a(this);
    this.HAP = ((WalletFormView)findViewById(2131304000));
    this.HAT = ((ImageView)findViewById(2131297310));
    this.HAU = ((TextView)findViewById(2131303997));
    this.HAV = ((TextView)findViewById(2131303998));
    this.HAQ = ((TextView)findViewById(2131304001));
    this.HAR = ((TextView)findViewById(2131303907));
    com.tencent.mm.ui.ao.a(this.HAR.getPaint(), 0.8F);
    this.HBj = ((TextView)findViewById(2131310298));
    this.zcC = ((TextView)findViewById(2131304005));
    this.HBq = ((TextView)findViewById(2131303999));
    this.HAW = ((ViewGroup)findViewById(2131304002));
    this.HAX = ((TextView)findViewById(2131304004));
    this.HAY = ((CheckBox)findViewById(2131304003));
    this.HAO = ((ViewGroup)findViewById(2131304321));
    this.HAZ = ((TextView)findViewById(2131302329));
    this.HBa = ((TextView)findViewById(2131302330));
    this.HBb = ((LinearLayout)findViewById(2131306318));
    this.HBc = ((LinearLayout)findViewById(2131303915));
    this.HBd = ((LinearLayout)findViewById(2131303913));
    this.HBe = ((TextView)findViewById(2131303914));
    this.HBf = ((LinearLayout)findViewById(2131303910));
    this.HBg = ((LinearLayout)findViewById(2131303912));
    this.HBi = ((TextView)findViewById(2131303909));
    this.HAS = ((TextView)findViewById(2131297251));
    this.HBl = ((WalletLqtArriveTimeLayout)findViewById(2131303995));
    this.HBm = ((ScrollView)findViewById(2131303992));
    this.HBn = ((LinearLayout)findViewById(2131303965));
    this.HBo = ((TextView)findViewById(2131303966));
    this.HBp = ((TextView)findViewById(2131303967));
    this.HBh = ((LinearLayout)findViewById(2131302332));
    com.tencent.mm.ui.ao.a(this.HBp.getPaint(), 0.8F);
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    int i = getIntent().getIntExtra("entrance_type", 0);
    this.HAM.mode = this.mode;
    this.HAM.HuF = i;
    this.HBt = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.HBu = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.HBv = getIntent().getStringExtra("lqt_profile_wording");
    this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
    if (com.tencent.mm.ui.ao.isDarkMode()) {
      this.HBb.setBackground(getResources().getDrawable(2131233577));
    }
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.aAi();
      this.HBx = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OfP, ""));
      if (Util.isNullOrNil(this.HBx))
      {
        com.tencent.mm.kernel.g.aAi();
        this.HBx = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OfO, ""));
      }
      this.HBy = getIntent().getStringExtra("card_serial");
      this.HBc.setVisibility(8);
      this.HBd.setVisibility(0);
      this.HBf.setVisibility(8);
      this.HBg.setVisibility(0);
    }
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.HBx });
    this.HAP.getTitleTv().setText(com.tencent.mm.wallet_core.c.ah.hhz());
    this.mWcKeyboard = ((WcPayKeyboard)findViewById(2131310544));
    paramBundle = (RelativeLayout.LayoutParams)this.mWcKeyboard.getLayoutParams();
    paramBundle.addRule(12);
    this.mWcKeyboard.setLayoutParams(paramBundle);
    label915:
    int j;
    if (this.mode == 1)
    {
      setWPKeyboard(this.HAP.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131767948));
      if (com.tencent.mm.compatible.util.d.oF(27)) {
        this.HAP.hic();
      }
      setWcKbHeightListener(this);
      if (this.mode != 1) {
        break label1507;
      }
      this.HAQ.setText(getString(2131767940));
      this.HBj.setText(getString(2131767943));
      this.HAP.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(213984);
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          String str = paramAnonymousEditable.toString();
          int i = str.indexOf(".");
          int j = str.length();
          if ((i >= 0) && (j - i > 3)) {
            WalletFormView.a(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt(), str, i + 3, j);
          }
          for (;;)
          {
            paramAnonymousEditable = paramAnonymousEditable.toString();
            WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, paramAnonymousEditable);
            WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this, paramAnonymousEditable);
            AppMethodBeat.o(213984);
            return;
            if (i > 12) {
              WalletFormView.a(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt(), str, 12, i);
            } else if ((i == -1) && (j > 12)) {
              WalletFormView.a(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt(), str, 12, j);
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(213985);
          if (paramAnonymousBoolean)
          {
            if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
            {
              WalletLqtSaveFetchUI.t(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(213985);
              return;
            }
            if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1) {
              AppMethodBeat.o(213985);
            }
          }
          else
          {
            WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this).scrollTo(0, 0);
            if ((WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2) && (Util.isNullOrNil(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText()))) {
              WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(213985);
        }
      });
      this.HAP.getContentEt().setOnEditorActionListener(new WalletLqtSaveFetchUI.17(this));
      if (!Util.isNullOrNil(this.HBv)) {
        this.mWcKeyboard.setTipText(this.HBv);
      }
      if (this.mode == 2) {
        this.HBl.setCallback(new WalletLqtArriveTimeLayout.a()
        {
          public final void fNw()
          {
            AppMethodBeat.i(213987);
            WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, true);
            AppMethodBeat.o(213987);
          }
        });
      }
      j = this.HBj.getWidth();
      Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveFetchHintWordingTv width: %d", new Object[] { Integer.valueOf(j) });
      if (j > 0) {
        break label1546;
      }
      this.HBj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68997);
          int i = WalletLqtSaveFetchUI.x(WalletLqtSaveFetchUI.this).getWidth();
          Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveFetchHintWordingTv trueWidth: %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0)
          {
            AppMethodBeat.o(68997);
            return;
          }
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletLqtSaveFetchUI.y(WalletLqtSaveFetchUI.this).getLayoutParams();
          if (localLayoutParams != null) {
            localLayoutParams.leftMargin = i;
          }
          WalletLqtSaveFetchUI.y(WalletLqtSaveFetchUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(68997);
        }
      });
      label1055:
      this.HAU.setText("");
      this.HAU.setClickable(true);
      this.HAU.setOnTouchListener(new o(this));
      xP(false);
      this.HBo.setClickable(true);
      this.HBo.setOnTouchListener(new o(this));
      this.HBp.setClickable(true);
      this.HBp.setOnTouchListener(new o(this));
      if (this.mode != 1) {
        break label1588;
      }
      this.HAO.setVisibility(4);
      if (i != 8) {
        break label1578;
      }
      setMMTitle(2131767947);
      this.mWcKeyboard.showNormalStWcKb();
    }
    for (;;)
    {
      if (this.HAR.findViewById(2131310297) != null) {
        this.HAR.findViewById(2131310297).setVisibility(8);
      }
      paramBundle = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68967);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WalletLqtSaveFetchUI.this.hideTenpayKB();
          int i = -1;
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(17084, new Object[] { Integer.valueOf(28) });
            i = 2;
          }
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2) {
            com.tencent.mm.plugin.report.service.h.CyF.a(20287, new Object[] { Integer.valueOf(3) });
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, i);
          if (WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this)) {
            WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).HuQ.jP(1, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68967);
        }
      };
      this.HAR.setOnClickListener(paramBundle);
      if (findViewById(2131298278) != null) {
        findViewById(2131298278).setOnClickListener(paramBundle);
      }
      paramBundle = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
      Object localObject = this.HBH;
      paramBundle.HtM.add(localObject);
      fNR();
      this.HAO.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(68982);
          if ((WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this).isShown()) && (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this).hgP()))
          {
            WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this).hgN();
            AppMethodBeat.o(68982);
            return true;
          }
          AppMethodBeat.o(68982);
          return false;
        }
      });
      this.state = 1;
      paramBundle = getIntent().getStringExtra("fill_money");
      if (Util.getDouble(paramBundle, 0.0D) > 0.0D)
      {
        this.HAP.setText(paramBundle);
        cC(paramBundle, false);
      }
      paramBundle = this.HAP.getContentEt();
      localObject = this.HAP.getTitleTv();
      float f2 = com.tencent.mm.cb.a.ez(this);
      float f3 = com.tencent.mm.cc.a.gvi();
      if ((f2 != 1.0F) || (f3 != 1.0F))
      {
        float f1 = f2;
        if (f2 > 1.4F) {
          f1 = 1.4F;
        }
        f2 = paramBundle.getTextSize() / f1 / f3;
        paramBundle.setTextSize(0, f2);
        float f4 = ((TextView)localObject).getTextSize() / f1 / f3;
        ((TextView)localObject).setTextSize(0, f4);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "et:" + f2 + " tv:" + f4 + " fontScale:" + f1 + " viewScale:" + f3);
      }
      AppMethodBeat.o(69010);
      return;
      this.isVKBFirstTimeShown = false;
      setWPKeyboard(this.HAP.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131767863));
      break;
      label1507:
      if (this.mode != 2) {
        break label915;
      }
      this.HAQ.setText(getString(2131767841));
      this.HBj.setText(getString(2131767849));
      break label915;
      label1546:
      paramBundle = (LinearLayout.LayoutParams)this.HBh.getLayoutParams();
      if (paramBundle != null) {
        paramBundle.leftMargin = j;
      }
      this.HBh.setLayoutParams(paramBundle);
      break label1055;
      label1578:
      setMMTitle(2131767948);
      continue;
      label1588:
      setMMTitle(2131767863);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69030);
    super.onDestroy();
    fNV();
    com.tencent.mm.plugin.wallet.balance.model.lqt.u localu = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
    com.tencent.mm.plugin.wallet.balance.model.lqt.u.a locala = this.HBH;
    localu.HtM.remove(locala);
    com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.Hty = null;
    this.HAM = null;
    this.HAN = null;
    AppMethodBeat.o(69030);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(69025);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    AppMethodBeat.o(69025);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69018);
    if ((this.mWcKeyboard != null) && (this.mWcKeyboard.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(69018);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(69018);
    return bool;
  }
  
  public void onNewIntent(final Intent paramIntent)
  {
    AppMethodBeat.i(69017);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    paramIntent = fNT();
    this.HAN.HuP.jQ(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(69017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69024);
    super.onPause();
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onPause()");
    this.Hyh.dead();
    if (!this.mWcKeyboard.hgQ()) {
      this.state = 3;
    }
    AppMethodBeat.o(69024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69023);
    super.onResume();
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onResume()");
    this.Hyh.alive();
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.HvB, 300L);
    }
    this.state = 2;
    if (this.HBD)
    {
      this.HBD = false;
      zn localzn = new zn();
      localzn.efE.mode = this.mode;
      EventCenter.instance.publish(localzn);
    }
    AppMethodBeat.o(69023);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(69028);
    ae localae = this.HAM;
    Log.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.ad))
    {
      s.fOg();
      localae.HuE = s.fOh().Hwc;
      if (localae.jSi != null)
      {
        localae.jSi.G(new Object[] { paramq });
        localae.jSi.resume();
      }
    }
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
    fNR();
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    AppMethodBeat.o(69028);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void xQ(boolean paramBoolean)
  {
    this.HvA = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI
 * JD-Core Version:    0.7.0.1
 */