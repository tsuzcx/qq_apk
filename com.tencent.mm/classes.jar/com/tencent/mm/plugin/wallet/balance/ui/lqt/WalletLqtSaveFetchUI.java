package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aas;
import com.tencent.mm.f.a.aau;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af.13;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af.2;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag.e;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ai;
import com.tencent.mm.plugin.wallet.balance.model.lqt.v;
import com.tencent.mm.plugin.wallet.balance.model.lqt.v.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.protocal.protobuf.ery;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
  private TextView EHc;
  private HashMap<String, Integer> ErL;
  private IListener<ma> GCj;
  private Bankcard OmO;
  private ad Omj;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ae Omk;
  private int Omq;
  protected boolean Onn;
  private Runnable Ono;
  private a OpT;
  private IListener OpV;
  public af OsC;
  private ag OsD;
  private ViewGroup OsE;
  private WalletFormView OsF;
  private TextView OsG;
  private TextView OsH;
  private TextView OsI;
  private ImageView OsJ;
  private TextView OsK;
  private TextView OsL;
  private ViewGroup OsM;
  private TextView OsN;
  private CheckBox OsO;
  private TextView OsP;
  private TextView OsQ;
  private LinearLayout OsR;
  private LinearLayout OsS;
  private LinearLayout OsT;
  private TextView OsU;
  private LinearLayout OsV;
  private LinearLayout OsW;
  private LinearLayout OsX;
  private TextView OsY;
  private TextView OsZ;
  private boolean Ota;
  private WalletLqtArriveTimeLayout Otb;
  private ScrollView Otc;
  private LinearLayout Otd;
  private TextView Ote;
  private TextView Otf;
  private TextView Otg;
  private CharSequence Oth;
  private Bankcard Oti;
  private int Otj;
  private String Otk;
  private String Otl;
  private long Otm;
  public String Otn;
  private String Oto;
  private boolean Otp;
  private List<Bankcard> Otq;
  private boolean Otr;
  private boolean Ots;
  private boolean Ott;
  private String Otu;
  private boolean Otv;
  private String Otw;
  private v.a Otx;
  private int hintTextColor;
  final View.OnClickListener kte;
  public Runnable mMK;
  private Dialog mMi;
  private int mode;
  private int state;
  
  public WalletLqtSaveFetchUI()
  {
    AppMethodBeat.i(69009);
    this.Omj = ((ad)at(ad.class));
    this.Omk = ((com.tencent.mm.plugin.wallet.balance.model.lqt.ae)ap(com.tencent.mm.plugin.wallet.balance.model.lqt.ae.class));
    this.OsC = new af(this.Omj, this.Omk, this);
    this.OsD = new ag(this.OsC);
    this.Otm = -1L;
    this.Otp = false;
    this.Otr = true;
    this.Ots = false;
    this.Ott = false;
    this.Onn = false;
    this.Otu = "";
    this.Otv = false;
    this.hintTextColor = MMApplicationContext.getContext().getResources().getColor(a.c.FG_1);
    this.Otw = "";
    this.Otx = new v.a()
    {
      public final void BE(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268746);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "cache updated show Error:".concat(String.valueOf(paramAnonymousBoolean)));
        if (!WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramAnonymousBoolean))
        {
          AppMethodBeat.o(268746);
          return;
        }
        WalletLqtSaveFetchUI.this.hideLoading();
        WalletLqtSaveFetchUI.this.gGw();
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
          AppMethodBeat.o(268746);
          return;
        }
        if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
        {
          String str = WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText();
          if (!Util.isNullOrNil(str)) {
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, str);
          }
        }
        AppMethodBeat.o(268746);
      }
    };
    this.ErL = new HashMap();
    this.kte = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(274537);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (Util.ticksToNow(WalletLqtSaveFetchUI.z(WalletLqtSaveFetchUI.this)) < 800L)
        {
          Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274537);
          return;
        }
        WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, Util.currentTicks());
        final int k = WalletLqtSaveFetchUI.lO(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText(), "100");
        if (k > 0)
        {
          WalletLqtSaveFetchUI.this.hideWcKb();
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) != 1) {
            break label260;
          }
          Log.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
          if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, v.Oly.Olu))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(274537);
            return;
          }
          paramAnonymousView = WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).Omz;
          com.tencent.mm.vending.g.g.g(Integer.valueOf(k), Integer.valueOf(WalletLqtSaveFetchUI.A(WalletLqtSaveFetchUI.this)), WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this)).c(paramAnonymousView).f(new com.tencent.mm.vending.c.a()
          {
            private Void a(dre paramAnonymous2dre)
            {
              AppMethodBeat.i(277691);
              if (paramAnonymous2dre == null)
              {
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "save failed, qryPurchaseResultRes is null");
                AppMethodBeat.o(277691);
                return null;
              }
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[] { Integer.valueOf(paramAnonymous2dre.TXC) });
              WalletLqtSaveFetchUI.this.gGA();
              Object localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
              ((Intent)localObject).putExtra("key_amount", com.tencent.mm.wallet_core.ui.g.a(k, "100", 2, RoundingMode.HALF_UP));
              ((Intent)localObject).putExtra("key_mode", 1);
              ((Intent)localObject).putExtra("profile_date_wording", paramAnonymous2dre.TXE);
              ((Intent)localObject).putExtra("profile_upgrade_wording", paramAnonymous2dre.TXD);
              if (paramAnonymous2dre.TXF != null) {}
              try
              {
                ((Intent)localObject).putExtra("key_guide_cell", paramAnonymous2dre.TXF.toByteArray());
                ((Intent)localObject).putExtra("entrance_type", WalletLqtSaveFetchUI.this.getIntent().getIntExtra("entrance_type", 0));
                paramAnonymous2dre = WalletLqtSaveFetchUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2dre, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2dre.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2dre, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                WalletLqtSaveFetchUI.this.finish();
                paramAnonymous2dre = YAb;
                AppMethodBeat.o(277691);
                return paramAnonymous2dre;
              }
              catch (IOException paramAnonymous2dre)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2dre, "", new Object[0]);
                }
              }
            }
          }).a(new com.tencent.mm.vending.g.d.a()
          {
            public final void cm(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(265458);
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[] { paramAnonymous2Object });
              WalletLqtSaveFetchUI.this.bsu();
              if (paramAnonymous2Object != null) {
                if (!(paramAnonymous2Object instanceof String)) {
                  break label74;
                }
              }
              label74:
              for (paramAnonymous2Object = paramAnonymous2Object.toString();; paramAnonymous2Object = WalletLqtSaveFetchUI.this.getString(a.i.wallet_lqt_network_error))
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
                AppMethodBeat.o(265458);
                return;
              }
            }
          });
        }
        label260:
        while (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) != 2)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274537);
          return;
        }
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
        if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, v.Oly.Olv))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274537);
          return;
        }
        localObject = null;
        paramAnonymousView = (View)localObject;
        if (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this) != null)
        {
          paramAnonymousView = (View)localObject;
          if (!WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).gIH())
          {
            paramAnonymousView = new ip();
            paramAnonymousView.DNV = WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bankName;
            paramAnonymousView.fvP = WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bankcardType;
            paramAnonymousView.ROq = WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bindSerial;
            paramAnonymousView.GHy = WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bankcardTail;
          }
        }
        if (WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getSelectRedeemType() != null) {}
        for (int i = WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getSelectRedeemType().TUV;; i = 0)
        {
          int j = i;
          if (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this) != null)
          {
            j = i;
            if (!WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).gIH())
            {
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose bankcard");
              int m = com.tencent.mm.wallet_core.ui.g.oz(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText(), "100");
              localObject = y.gFD().gFE();
              if ((((deh)localObject).TLV >= 0) && (m > ((deh)localObject).TLV))
              {
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose slow redeem");
                WalletLqtSaveFetchUI.B(WalletLqtSaveFetchUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(274537);
                return;
              }
              j = i;
              if (((deh)localObject).TLV >= 0)
              {
                j = i;
                if (m < ((deh)localObject).TLV)
                {
                  Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose fast redeem");
                  j = 0;
                }
              }
            }
          }
          WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).OmA.a(k, WalletLqtSaveFetchUI.A(WalletLqtSaveFetchUI.this), j, paramAnonymousView).f(new com.tencent.mm.vending.c.a()
          {
            private Void a(dvn paramAnonymous2dvn)
            {
              AppMethodBeat.i(275423);
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { paramAnonymous2dvn, Boolean.valueOf(paramAnonymous2dvn.Ubx), Boolean.valueOf(paramAnonymous2dvn.Uby) });
              WalletLqtSaveFetchUI.this.gGA();
              Object localObject;
              if ((paramAnonymous2dvn.Ubx) && (paramAnonymous2dvn.Uby))
              {
                localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                ((Intent)localObject).putExtra("key_amount", com.tencent.mm.wallet_core.ui.g.a(k, "100", 2, RoundingMode.HALF_UP));
                ((Intent)localObject).putExtra("key_mode", 2);
                paramAnonymous2dvn = WalletLqtSaveFetchUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2dvn, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2dvn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2dvn, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                WalletLqtSaveFetchUI.this.finish();
                paramAnonymous2dvn = YAb;
                AppMethodBeat.o(275423);
                return paramAnonymous2dvn;
                localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressNewUI.class);
                try
                {
                  ((Intent)localObject).putExtra("key_redeem_res", paramAnonymous2dvn.toByteArray());
                  paramAnonymous2dvn = WalletLqtSaveFetchUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2dvn, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2dvn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2dvn, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                catch (Exception paramAnonymous2dvn)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2dvn, "pass redeemFundRes error: %s", new Object[] { paramAnonymous2dvn.getMessage() });
                  }
                }
              }
            }
          }).a(new com.tencent.mm.vending.g.d.a()
          {
            public final void cm(Object paramAnonymous2Object)
            {
              boolean bool = false;
              AppMethodBeat.i(266417);
              WalletLqtSaveFetchUI.this.Onn = false;
              WalletLqtSaveFetchUI.this.bsu();
              if (paramAnonymous2Object != null)
              {
                if ((paramAnonymous2Object instanceof dvn)) {
                  bool = com.tencent.mm.wallet_core.d.h.a(WalletLqtSaveFetchUI.this, null, 1000, ((dvn)paramAnonymous2Object).tqa, ((dvn)paramAnonymous2Object).tqb);
                }
                if (!bool) {
                  if (!(paramAnonymous2Object instanceof String)) {
                    break label112;
                  }
                }
              }
              label112:
              for (paramAnonymous2Object = paramAnonymous2Object.toString();; paramAnonymous2Object = WalletLqtSaveFetchUI.this.getString(a.i.wallet_lqt_network_error))
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
                AppMethodBeat.o(266417);
                return;
              }
            }
          });
          break;
        }
      }
    };
    this.OpV = new IListener() {};
    this.state = 0;
    this.mMK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204809);
        if ((WalletLqtSaveFetchUI.E(WalletLqtSaveFetchUI.this) == 2) && (WalletLqtSaveFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletLqtSaveFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(204809);
      }
    };
    this.Ono = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271579);
        WalletLqtSaveFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(271579);
      }
    };
    this.GCj = new IListener() {};
    AppMethodBeat.o(69009);
  }
  
  private void BI(boolean paramBoolean)
  {
    AppMethodBeat.i(69015);
    if ((this.mode == 2) && (paramBoolean))
    {
      this.OmO = v.Oly.By(false);
      if (this.OmO == null)
      {
        this.OsS.setVisibility(0);
        this.OsU.setText(getString(a.i.wallet_lqt_fetch_back_card_load_pb));
        this.OsT.setVisibility(8);
        this.OsV.setVisibility(0);
        this.OsW.setVisibility(8);
        this.OsY.setText(getString(a.i.wallet_lqt_balance_load_pb));
        this.OsH.setClickable(false);
        if (findViewById(a.f.lqt_balance_bankcard_click_layout) != null) {
          findViewById(a.f.lqt_balance_bankcard_click_layout).setClickable(false);
        }
        this.OsF.setContentClickable(false);
        localObject1 = this.OsF.getContentEt();
        if (localObject1 != null) {
          ((EditText)localObject1).setCursorVisible(false);
        }
        findViewById(a.f.wallet_info_tip).setVisibility(8);
        this.Otd.setVisibility(8);
        this.OsM.setVisibility(8);
        this.OsL.setVisibility(8);
        this.OsX.setVisibility(8);
        this.OsR.setVisibility(8);
        AppMethodBeat.o(69015);
        return;
      }
    }
    if (this.mode == 2)
    {
      this.OsH.setClickable(true);
      if (findViewById(a.f.lqt_balance_bankcard_click_layout) != null) {
        findViewById(a.f.lqt_balance_bankcard_click_layout).setClickable(true);
      }
      this.OsF.setContentClickable(true);
      localObject1 = this.OsF.getContentEt();
      if (localObject1 != null) {
        ((EditText)localObject1).setCursorVisible(true);
      }
    }
    this.OsS.setVisibility(8);
    this.OsT.setVisibility(0);
    this.OsV.setVisibility(8);
    this.OsW.setVisibility(0);
    Object localObject1 = v.Oly;
    boolean bool;
    Object localObject2;
    Object localObject3;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((v)localObject1).BA(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        s.gGL();
        localObject1 = s.gGM().gKp();
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
        if (((Bankcard)localObject3).gIH())
        {
          s.gGL();
          if (!s.gGM().gJS())
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
      if (!Util.isNullOrNil(this.Oto))
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject1 = (Bankcard)((List)localObject2).get(i);
          if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Oto.equals(((Bankcard)localObject1).field_bindSerial))) {
            this.OmO = ((Bankcard)localObject1);
          }
          i += 1;
        }
      }
      if ((Util.isNullOrNil(this.Oto)) || (this.OmO == null))
      {
        localObject1 = v.Oly;
        if (this.mode == 1) {}
        for (bool = true;; bool = false)
        {
          this.OmO = ((v)localObject1).By(bool);
          if ((Util.isNullOrNil(this.Otn)) || (this.OmO != null)) {
            break;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = (Bankcard)((List)localObject2).get(i);
            if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Otn.equals(((Bankcard)localObject1).field_bindSerial))) {
              this.OmO = ((Bankcard)localObject1);
            }
            i += 1;
          }
        }
      }
    }
    else if (!Util.isNullOrNil(this.Otn))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Otn.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.OmO = ((Bankcard)localObject1);
        }
        i += 1;
      }
    }
    if (this.OmO != null) {}
    for (localObject1 = this.OmO.field_bindSerial;; localObject1 = "")
    {
      Log.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", new Object[] { localObject1, this.Otn, Boolean.valueOf(paramBoolean) });
      if (this.OmO != null) {
        break;
      }
      s.gGL();
      this.OmO = s.gGM().OnP;
      if (this.OmO != null) {
        break;
      }
      finish();
      AppMethodBeat.o(69015);
      return;
    }
    if (this.OmO.gIH())
    {
      this.OsH.setText(this.OmO.field_desc);
      this.OsH.setText(this.OmO.field_desc);
      this.OsH.setVisibility(0);
      this.OsJ.setTag(this.OmO.field_bindSerial);
      if (this.OsJ != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.OmO.field_bankcardType, this.OmO.gIG());
        if (localObject2 != null) {
          localObject1 = ((e)localObject2).GtW;
        }
        this.OsJ.setImageBitmap(null);
        if (!this.OmO.gIH()) {
          break label1608;
        }
        this.OsJ.setImageResource(a.e.wallet_balance_manager_logo_small);
      }
      label1029:
      this.OsX.setVisibility(8);
      this.OsR.setVisibility(8);
      if (this.mode != 2) {
        break label1680;
      }
      localObject1 = y.gFD().gFE();
      if ((localObject1 != null) && (!this.OmO.gIH()) && (!TextUtils.isEmpty(((deh)localObject1).TLW)))
      {
        this.OsX.setVisibility(0);
        this.OsP.setText(((deh)localObject1).TLW);
        this.OsP.setVisibility(0);
      }
      label1117:
      if (this.mode != 1) {
        break label2047;
      }
      localObject1 = getIntent().getStringArrayListExtra("lqt_protocol_list");
      paramBoolean = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (!paramBoolean)) {
        break label2035;
      }
      this.OsM.setVisibility(0);
      this.OsO.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
      this.OsM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(265851);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).isChecked()) {}
          for (boolean bool = true;; bool = false)
          {
            WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).setChecked(bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(265851);
            return;
          }
        }
      });
      this.OsO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(269727);
          if (!paramAnonymousBoolean)
          {
            WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, false);
            AppMethodBeat.o(269727);
            return;
          }
          WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, true);
          AppMethodBeat.o(269727);
        }
      });
      localObject2 = getString(a.i.wallet_lqt_protocol_agree_prefix);
      i = ((String)localObject2).length();
      localObject2 = new SpannableString((String)localObject2 + getString(a.i.wallet_lqt_protocol_agree_suffix));
      ((SpannableString)localObject2).setSpan(new com.tencent.mm.wallet_core.ui.f(new WalletLqtSaveFetchUI.14(this, (ArrayList)localObject1)), i, ((SpannableString)localObject2).length(), 17);
      this.OsN.setText((CharSequence)localObject2);
      this.OsN.setClickable(true);
      this.OsN.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
    }
    for (;;)
    {
      if (this.mode == 1)
      {
        if ((this.OmO != null) && (this.OmO.gIH()))
        {
          this.OsK.setText(this.Oth);
          localObject1 = v.Oly.Bz(true);
          if (localObject1 != null)
          {
            if ((((ctc)localObject1).TAR != null) && (!Util.isNullOrNil(((ctc)localObject1).TAR.Soo)))
            {
              localObject2 = new SpannableStringBuilder(((ctc)localObject1).TAR.Soo);
              if ((!Util.isNullOrNil(((ctc)localObject1).TAR.Sop)) && (!Util.isNullOrNil(((ctc)localObject1).TAR.jump_url)))
              {
                ((SpannableStringBuilder)localObject2).append(((ctc)localObject1).TAR.Sop);
                ((SpannableStringBuilder)localObject2).setSpan(new r(new r.a()
                {
                  public final void ed(View paramAnonymousView)
                  {
                    AppMethodBeat.i(275888);
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                    com.tencent.mm.wallet_core.ui.g.a(WalletLqtSaveFetchUI.this.getContext(), this.OtB.TAR.jump_url, true, 1);
                    com.tencent.mm.plugin.report.service.h.IzE.a(20216, new Object[] { Integer.valueOf(1), this.OtB.TAR.jump_url });
                    AppMethodBeat.o(275888);
                  }
                }), ((ctc)localObject1).TAR.Soo.length(), ((SpannableStringBuilder)localObject2).length(), 18);
              }
              this.OsI.setText((CharSequence)localObject2);
              this.OsI.setClickable(true);
              this.OsI.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(getContext()));
              this.OsI.setVisibility(0);
              this.hintTextColor = getResources().getColor(a.c.FG_0);
              AppMethodBeat.o(69015);
              return;
              this.OsH.setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.OmO.field_bankName, this.OmO.field_bankcardTail }));
              break;
              label1608:
              localObject1 = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
              com.tencent.mm.platformtools.u.a(new com.tencent.mm.platformtools.u.a()
              {
                public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
                {
                  AppMethodBeat.i(273498);
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(269583);
                      if ((WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this) != null) && (WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this) != null) && (WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).getTag() != null) && (WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).getTag().equals(WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).field_bindSerial))) {
                        WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).setImageBitmap(paramAnonymousBitmap);
                      }
                      AppMethodBeat.o(269583);
                    }
                  });
                  AppMethodBeat.o(273498);
                }
              });
              if (localObject1 == null) {
                break label1029;
              }
              localObject1 = BitmapUtil.extractThumbNail((Bitmap)localObject1, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
              this.OsJ.setImageBitmap((Bitmap)localObject1);
              break label1029;
              label1680:
              if (this.mode != 1) {
                break label1117;
              }
              if ((!this.OmO.gIH()) && (!Util.isNullOrNil(this.OmO.field_avail_save_wording)))
              {
                this.OsX.setVisibility(0);
                this.OsP.setText(this.OmO.field_avail_save_wording);
                this.OsP.setVisibility(0);
              }
              localObject1 = v.Oly;
              label1756:
              String str;
              if (this.mode == 1)
              {
                paramBoolean = true;
                localObject1 = ((v)localObject1).Bz(paramBoolean);
                if (localObject1 == null) {
                  break label1117;
                }
                localObject3 = ((ctc)localObject1).TAS;
                if ((this.OmO == null) || (!this.OmO.gIH()) || (localObject3 == null)) {
                  break label1117;
                }
                this.OsD.OmD.lf(0, 1);
                this.Ota = true;
                com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(25) });
                str = ((acs)localObject3).Soo;
                localObject1 = ((acs)localObject3).Sop;
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "tryShowSaveFromLqBubble, promptText: %s, jumpText: %s", new Object[] { str, localObject1 });
                if (TextUtils.isEmpty(str)) {
                  break label2025;
                }
                i = 1;
                label1884:
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label2030;
                }
              }
              label2025:
              label2030:
              for (int j = 1;; j = 0)
              {
                TextView localTextView = (TextView)this.OsR.findViewById(a.f.purchase_from_lq_prompt_tv);
                localObject2 = (TextView)this.OsR.findViewById(a.f.purchase_from_lq_prompt_link_tv);
                localTextView.setVisibility(4);
                ((TextView)localObject2).setVisibility(4);
                if ((i != 0) || (j != 0)) {
                  this.OsR.setVisibility(0);
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
                localObject3 = new f.a()
                {
                  public final void bwz()
                  {
                    AppMethodBeat.i(265156);
                    com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(26) });
                    WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).OmD.lf(1, 0);
                    switch (this.OtA.jump_type)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(265156);
                      return;
                      WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, 1);
                      AppMethodBeat.o(265156);
                      return;
                      com.tencent.mm.wallet_core.ui.g.bA(WalletLqtSaveFetchUI.this.getContext(), this.OtA.jump_url);
                      AppMethodBeat.o(265156);
                      return;
                      com.tencent.mm.wallet_core.ui.g.v(this.OtA.Ooe, this.OtA.jump_url, 0, 1000);
                    }
                  }
                };
                com.tencent.mm.wallet_core.ui.g.a((TextView)localObject2, (String)localObject1, 0, ((String)localObject1).length(), new com.tencent.mm.wallet_core.ui.f((f.a)localObject3), getContext());
                break;
                paramBoolean = false;
                break label1756;
                i = 0;
                break label1884;
              }
              label2035:
              this.OsM.setVisibility(8);
              continue;
              label2047:
              if (this.mode != 2) {
                continue;
              }
              findViewById(a.f.wallet_info_tip).setVisibility(8);
              this.Otd.setVisibility(8);
              this.OsM.setVisibility(8);
              this.OsL.setVisibility(8);
              localObject1 = y.gFD();
              if ((this.OmO != null) && (this.OmO.gIH()))
              {
                i = getIntent().getIntExtra("lqt_balance", 0);
                if (ac.mGN) {
                  i = 50000000;
                }
                if (i <= 0) {
                  continue;
                }
                localObject1 = getString(a.i.wallet_lqt_fetch_remain_wording_1, new Object[] { Double.valueOf(lL(String.valueOf(i), "100")) });
                j = ((String)localObject1).length();
                localObject1 = new SpannableString((String)localObject1 + " " + getString(a.i.wallet_lqt_fetch_remain_wording_2));
                ((SpannableString)localObject1).setSpan(new com.tencent.mm.wallet_core.ui.f(new f.a()
                {
                  public final void bwz()
                  {
                    AppMethodBeat.i(267100);
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(WalletLqtSaveFetchUI.lN(i, "100")));
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                    WalletLqtSaveFetchUI.this.showWcKb();
                    AppMethodBeat.o(267100);
                  }
                }), j, ((SpannableString)localObject1).length(), 18);
                this.Oth = ((CharSequence)localObject1);
                this.OsK.setText((CharSequence)localObject1);
                continue;
              }
              if (((y)localObject1).gFE() == null) {}
              for (i = 0;; i = ((y)localObject1).gFE().dta)
              {
                if (((y)localObject1).gFE() != null) {
                  ((y)localObject1).gFE();
                }
                if (ac.mGN) {
                  i = 100000000;
                }
                localObject1 = getString(a.i.wallet_lqt_balance_remain_wording_normal, new Object[] { Double.valueOf(lL(String.valueOf(i), "100")) });
                this.Oth = ((CharSequence)localObject1);
                this.OsK.setText((CharSequence)localObject1);
                break;
              }
            }
            this.OsI.setVisibility(8);
            this.hintTextColor = getResources().getColor(a.c.FG_1);
          }
          AppMethodBeat.o(69015);
          return;
        }
        this.OsK.setText("");
        this.OsI.setVisibility(8);
      }
    }
    AppMethodBeat.o(69015);
  }
  
  private void BJ(boolean paramBoolean)
  {
    AppMethodBeat.i(69022);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "check enable: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Ots) });
    if ((!paramBoolean) || (this.Ots))
    {
      gR(false);
      AppMethodBeat.o(69022);
      return;
    }
    if (this.mode == 1)
    {
      if (this.OsM.getVisibility() == 0)
      {
        if ((this.OsO.isChecked()) && (this.Otp))
        {
          gR(true);
          AppMethodBeat.o(69022);
          return;
        }
        gR(false);
        AppMethodBeat.o(69022);
        return;
      }
      if (this.Otp)
      {
        gR(true);
        AppMethodBeat.o(69022);
      }
    }
    else
    {
      if ((this.Otp) && ((this.Otb.getSelectRedeemType() != null) || (this.Otb.getRedeemTypeList() == null) || (this.Otb.getRedeemTypeList().isEmpty())))
      {
        if (this.Otb.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.Otb.getSelectRedeemType().TUV))
        {
          Log.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          gR(true);
          AppMethodBeat.o(69022);
          return;
        }
      }
      gR(false);
    }
    AppMethodBeat.o(69022);
  }
  
  private void O(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(69014);
    Log.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    iu localiu;
    if (this.mode == 2)
    {
      localObject = y.gFD().gFE();
      if (!this.Otb.OoF)
      {
        if (localObject == null)
        {
          Log.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
          AppMethodBeat.o(69014);
          return;
        }
        if (this.OmO.gIH())
        {
          Log.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
          this.Otb.y(((deh)localObject).TLS, false);
          this.Otb.bgs(paramString);
        }
        for (;;)
        {
          this.Otb.setVisibility(4);
          gGz();
          AppMethodBeat.o(69014);
          return;
          if (((deh)localObject).TLT != null)
          {
            localObject = ((deh)localObject).TLT.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localiu = (iu)((Iterator)localObject).next();
              if (localiu.ROq.equals(this.OmO.field_bindSerial))
              {
                Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                this.Otb.y(localiu.ROG, false);
                this.Otb.bgs(paramString);
              }
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (!this.OmO.gIH()) {
          break label273;
        }
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
        this.Otb.y(((deh)localObject).TLS, true);
      }
    }
    for (;;)
    {
      this.Otb.setVisibility(4);
      this.Otb.bgs(paramString);
      AppMethodBeat.o(69014);
      return;
      label273:
      if (((deh)localObject).TLT != null)
      {
        localObject = ((deh)localObject).TLT.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localiu = (iu)((Iterator)localObject).next();
          if (localiu.ROq.equals(this.OmO.field_bindSerial))
          {
            Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
            this.Otb.y(localiu.ROG, true);
          }
        }
      }
    }
  }
  
  private static int a(com.tencent.mm.plugin.wallet.balance.model.lqt.u paramu)
  {
    if ((paramu == null) || (paramu.Olh == null)) {}
    do
    {
      return 0;
      paramu = paramu.Olh;
    } while ((paramu.TTY == null) && (paramu.TTZ == null));
    if ((paramu.TTY != null) && (paramu.TTZ != null)) {
      return 1;
    }
    return 2;
  }
  
  private com.tencent.mm.ui.widget.a.g a(final com.tencent.mm.plugin.wallet.balance.model.lqt.u paramu1, final com.tencent.mm.plugin.wallet.balance.model.lqt.u paramu2, com.tencent.mm.plugin.wallet.balance.model.lqt.u paramu3)
  {
    AppMethodBeat.i(274908);
    if ((paramu2 == null) || (paramu2.Olh == null))
    {
      AppMethodBeat.o(274908);
      return null;
    }
    final dmt localdmt = paramu2.Olh;
    int j = 3;
    int i = j;
    if (localdmt.TTW == 0)
    {
      i = j;
      if (TextUtils.isEmpty(localdmt.title)) {
        i = 0;
      }
    }
    j = a(paramu2);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(getContext(), j, i);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i == 3)
    {
      if (localdmt.TTW == 0)
      {
        localObject1 = new LinearLayout(this);
        ((LinearLayout)localObject1).setPadding(com.tencent.mm.ci.a.aZ(this, a.d.Edge_3A), com.tencent.mm.ci.a.aZ(this, a.d.Edge_5A), com.tencent.mm.ci.a.aZ(this, a.d.Edge_3A), com.tencent.mm.ci.a.aZ(this, a.d.Edge_A));
        ((LinearLayout)localObject1).setOrientation(1);
        paramu1 = (com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1;
        if (!TextUtils.isEmpty(localdmt.title))
        {
          paramu1 = new TextView(this);
          ((LinearLayout)localObject1).addView(paramu1);
          paramu1.setGravity(3);
          localObject2 = new LinearLayout.LayoutParams(paramu1.getLayoutParams());
          ((LinearLayout.LayoutParams)localObject2).width = -1;
          ((LinearLayout.LayoutParams)localObject2).height = -2;
          ((LinearLayout.LayoutParams)localObject2).gravity = 3;
          paramu1.setTextSize(1, 17.0F);
          paramu1.setTextColor(getResources().getColor(a.c.black_text_color));
          ar.a(paramu1.getPaint(), 0.8F);
          paramu1.setText(localdmt.title);
          paramu1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramu1 = (com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1;
        }
        localg.iL(paramu1);
      }
    }
    else
    {
      localObject1 = localdmt.TTX;
      if (localObject1 != null)
      {
        paramu1 = new LinearLayout(this);
        paramu1.setOrientation(1);
        if (!TextUtils.isEmpty(((acs)localObject1).Soo))
        {
          localObject2 = new TextView(this);
          paramu1.addView((View)localObject2);
          localObject3 = new LinearLayout.LayoutParams(((TextView)localObject2).getLayoutParams());
          ((LinearLayout.LayoutParams)localObject3).width = -1;
          ((LinearLayout.LayoutParams)localObject3).height = -2;
          ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.ci.a.aZ(this, a.d.Edge_A);
          ((TextView)localObject2).setTextColor(getResources().getColor(a.c.black_text_color));
          if ((localdmt.TTW != 0) || (TextUtils.isEmpty(localdmt.title))) {
            break label886;
          }
          ((TextView)localObject2).setTextSize(1, 15.0F);
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(((acs)localObject1).Soo);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      if (!TextUtils.isEmpty(((acs)localObject1).Sop))
      {
        localObject2 = new TextView(this);
        paramu1.addView((View)localObject2);
        localObject3 = new LinearLayout.LayoutParams(((TextView)localObject2).getLayoutParams());
        ((LinearLayout.LayoutParams)localObject3).width = -1;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.ci.a.aZ(this, a.d.Edge_A);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        ar.a(((TextView)localObject2).getPaint(), 0.8F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((TextView)localObject2).setText(((acs)localObject1).Sop);
        a((TextView)localObject2, false, (acs)localObject1, localg, paramu2, paramu3, paramu2.wwk);
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
      }
      localg.setCustomView(paramu1);
      if (j == 0)
      {
        paramu2 = new LinearLayout.LayoutParams(paramu1.getLayoutParams());
        paramu2.bottomMargin = com.tencent.mm.ci.a.aZ(this, a.d.Edge_8A);
        paramu1.setLayoutParams(paramu2);
      }
      if (j == 2)
      {
        if (localdmt.TTY != null) {
          localg.ah(localdmt.TTY.wording);
        }
        if (localdmt.TTZ != null) {
          localg.ah(localdmt.TTZ.wording);
        }
        localg.ayu(1);
      }
      if (j == 1) {
        localg.d(localdmt.TTY.wording, localdmt.TTZ.wording);
      }
      AppMethodBeat.o(274908);
      return localg;
      localObject1 = View.inflate(this, a.g.lqt_select_bankcard_header, null);
      localObject2 = (WeImageView)((View)localObject1).findViewById(a.f.lqt_header_close_icon_iv);
      localObject3 = (TextView)((View)localObject1).findViewById(a.f.lqt_select_bankcard_title);
      ar.a(((TextView)localObject3).getPaint(), 0.8F);
      TextView localTextView = (TextView)((View)localObject1).findViewById(a.f.lqt_select_bankcard_tip);
      if (localdmt.TTW == 2)
      {
        ((WeImageView)localObject2).setImageResource(a.h.icons_outlined_back);
        ((WeImageView)localObject2).setIconColor(getResources().getColor(a.c.FG_0));
      }
      ((WeImageView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(270978);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          localg.bYF();
          if (localdmt.TTW == 2)
          {
            paramAnonymousView = WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, null, paramu1, paramu2);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramAnonymousView, paramu1);
            paramAnonymousView.eik();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(270978);
        }
      });
      if (TextUtils.isEmpty(localdmt.title)) {
        ((TextView)localObject3).setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localdmt.desc)) {
          break label864;
        }
        localTextView.setVisibility(8);
        paramu1 = (com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1;
        break;
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(localdmt.title);
      }
      label864:
      localTextView.setVisibility(0);
      localTextView.setText(localdmt.desc);
      paramu1 = (com.tencent.mm.plugin.wallet.balance.model.lqt.u)localObject1;
      break;
      label886:
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ar.a(((TextView)localObject2).getPaint(), 0.8F);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, final acs paramacs, final com.tencent.mm.ui.widget.a.g paramg, final com.tencent.mm.plugin.wallet.balance.model.lqt.u paramu1, final com.tencent.mm.plugin.wallet.balance.model.lqt.u paramu2, final int paramInt)
  {
    AppMethodBeat.i(274909);
    if (paramacs != null)
    {
      String str2 = "";
      String str1 = str2;
      if (paramBoolean)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramacs.Soo)) {
          str1 = paramacs.Soo;
        }
      }
      if (!TextUtils.isEmpty(paramacs.Sop))
      {
        int i = str1.length();
        str1 = str1 + paramacs.Sop;
        paramacs = new f.a()
        {
          public final void bwz()
          {
            AppMethodBeat.i(272179);
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "showCommonPromptText, scene: %s, promptInfo.jump_type: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramacs.jump_type) });
            if (paramInt >= 0) {
              com.tencent.mm.plugin.report.service.h.IzE.a(20287, new Object[] { Integer.valueOf(paramInt) });
            }
            switch (paramacs.jump_type)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(272179);
              return;
              com.tencent.mm.ui.widget.a.g localg = WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramu1, paramu2, null);
              WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, localg, paramu2);
              if (paramg != null) {
                paramg.bYF();
              }
              if ((localg != null) && (!localg.isShowing()))
              {
                localg.eik();
                AppMethodBeat.o(272179);
                return;
                com.tencent.mm.wallet_core.ui.g.bA(WalletLqtSaveFetchUI.this.getContext(), paramacs.jump_url);
                AppMethodBeat.o(272179);
                return;
                com.tencent.mm.wallet_core.ui.g.v(paramacs.Ooe, paramacs.jump_url, 0, 1000);
              }
            }
          }
        };
        com.tencent.mm.wallet_core.ui.g.a(paramTextView, str1, i, str1.length(), new com.tencent.mm.wallet_core.ui.f(paramacs), getContext());
        paramTextView.setVisibility(0);
        AppMethodBeat.o(274909);
        return;
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramTextView.setVisibility(0);
        paramTextView.setText(str1);
      }
    }
    AppMethodBeat.o(274909);
  }
  
  private void a(final com.tencent.mm.ui.widget.a.g paramg, final com.tencent.mm.plugin.wallet.balance.model.lqt.u paramu)
  {
    AppMethodBeat.i(274905);
    if (paramg == null)
    {
      AppMethodBeat.o(274905);
      return;
    }
    int i = a(paramu);
    paramu = paramu.Olh;
    if (i == 2)
    {
      paramg.YnF = new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(274686);
          ry localry2 = paramu.TTY;
          ry localry1 = localry2;
          if (localry2 == null) {
            localry1 = paramu.TTZ;
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramg, localry1);
          AppMethodBeat.o(274686);
        }
      };
      AppMethodBeat.o(274905);
      return;
    }
    if (i == 1) {
      paramg.a(new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(271992);
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramg, paramu.TTY);
          AppMethodBeat.o(271992);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(273102);
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramg, paramu.TTZ);
          AppMethodBeat.o(273102);
        }
      });
    }
    AppMethodBeat.o(274905);
  }
  
  private boolean bgz(String paramString)
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
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).HG(false);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).bBd(paramString);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).bBk(str1);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).bBj(str2);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(255400);
              com.tencent.mm.wallet_core.ui.g.p(WalletLqtSaveFetchUI.this.getContext(), this.Oud, false);
              AppMethodBeat.o(255400);
            }
          });
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).icu().show();
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
  
  private void cQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182506);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", new Object[] { paramString });
    long l1 = com.tencent.mm.wallet_core.ui.g.oA(String.valueOf(paramString), "100");
    Object localObject1;
    int m;
    Object localObject2;
    int j;
    label642:
    label649:
    int k;
    if (l1 > 0L)
    {
      if (this.mode == 1) {
        if (this.OmO != null) {
          if (this.OmO.gIH()) {
            if ((this.Oti != null) && (l1 > lM(this.Oti.OND, "100")))
            {
              this.OsK.setText(getString(a.i.wallet_lqt_save_balance_not_enough_hint));
              this.OsK.setTextColor(getResources().getColor(a.c.Red_100));
              this.Otp = false;
              BJ(false);
            }
          }
        }
      }
      for (;;)
      {
        if (l1 <= 0L)
        {
          this.Otr = true;
          AppMethodBeat.o(182506);
          return;
          if ((v.Oly.Ols >= 0) && (l1 > v.Oly.Ols) && (!Util.isNullOrNil(v.Oly.Olp)) && (!Util.isNullOrNil(v.Oly.Olq)) && (!Util.isNullOrNil(v.Oly.Olr)))
          {
            paramString = new r(new r.a()
            {
              public final void ed(View paramAnonymousView)
              {
                AppMethodBeat.i(214818);
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                com.tencent.mm.wallet_core.ui.g.a(WalletLqtSaveFetchUI.this.getContext(), v.Oly.Olr, true, 1);
                AppMethodBeat.o(214818);
              }
            });
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(v.Oly.Olp);
            ((SpannableStringBuilder)localObject1).append(v.Oly.Olq);
            ((SpannableStringBuilder)localObject1).setSpan(paramString, v.Oly.Olp.length(), ((SpannableStringBuilder)localObject1).length(), 18);
            if ((this.OsK.getText() == null) || (!this.OsK.getText().equals(((SpannableStringBuilder)localObject1).toString()))) {
              com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(9) });
            }
            this.OsK.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(getContext()));
            this.OsK.setClickable(true);
            this.OsK.setText((CharSequence)localObject1);
            this.OsK.setTextColor(this.hintTextColor);
            this.Otp = false;
            BJ(false);
          }
          else
          {
            this.OsK.setText(this.Oth);
            this.OsK.setTextColor(this.hintTextColor);
            this.Otp = true;
            BJ(true);
            continue;
            if ((this.OmO.field_dayQuotaKind > 0.0D) && (l1 > lM(this.OmO.field_dayQuotaKind, "100")))
            {
              this.OsK.setText(getString(a.i.wallet_lqt_save_exceed_bankcard_limit));
              this.OsK.setTextColor(getResources().getColor(a.c.Red_100));
              this.Otp = false;
              BJ(false);
              com.tencent.mm.plugin.report.service.h.IzE.a(21467, new Object[] { this.OmO.field_bankcardType, Long.valueOf(l1), Integer.valueOf(1), Double.valueOf(this.OmO.field_dayQuotaKind) });
            }
            else
            {
              this.OsK.setText("");
              this.Otp = true;
              BJ(true);
              continue;
              this.Otp = true;
              BJ(true);
              continue;
              if (this.mode == 2)
              {
                m = 0;
                localObject2 = y.gFD().gFE();
                if (localObject2 == null)
                {
                  j = 0;
                  if (localObject2 != null) {
                    break label761;
                  }
                  i = 0;
                  if ((this.OmO == null) || (!this.OmO.gIH())) {
                    break label1724;
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
          this.OsK.setText(getString(a.i.wallet_lqt_fetch_balance_not_enough_hint));
          this.OsK.setTextColor(getResources().getColor(a.c.Red_100));
          this.Otp = false;
          gGx();
          BJ(false);
          this.Otd.setVisibility(8);
          break;
          j = ((deh)localObject2).dta;
          break label642;
          label761:
          i = ((deh)localObject2).TLQ;
          break label649;
        }
        this.OsK.setText(this.Oth);
        this.OsK.setTextColor(this.hintTextColor);
        this.Otp = true;
        O(paramBoolean, paramString);
        BJ(true);
        this.Otd.setVisibility(8);
        break;
      }
      if (l1 > j)
      {
        this.OsK.setText(getString(a.i.wallet_lqt_fetch_balance_not_enough_hint));
        this.OsK.setTextColor(getResources().getColor(a.c.Red_100));
        this.Otd.setVisibility(8);
        this.Otp = false;
        gGx();
        BJ(false);
        this.Otd.setVisibility(8);
        break;
      }
      long l2;
      if (l1 > k)
      {
        l2 = com.tencent.mm.wallet_core.ui.g.oA(this.Otu, "100");
        if (l1 >= l2) {
          com.tencent.mm.plugin.report.service.h.IzE.a(20287, new Object[] { Integer.valueOf(9) });
        }
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "balance > lqtBalance, balance: %s, previousBalance: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        paramString = getString(a.i.wallet_lqt_balance_remain_wording_normal, new Object[] { Double.valueOf(lL(String.valueOf(j), "100")) });
        this.OsK.setTextColor(this.hintTextColor);
        this.OsK.setText(paramString);
        if ((localObject2 != null) && ((!TextUtils.isEmpty(((deh)localObject2).TLZ)) || (((deh)localObject2).TMa != null)))
        {
          Log.i("MicroMsg.WalletLqtSaveFetchUI", "balance > lqtBalance, go to new redeem to bank exceed tips");
          if (!TextUtils.isEmpty(((deh)localObject2).TLZ))
          {
            this.Otd.setVisibility(0);
            paramString = ((deh)localObject2).TLZ;
          }
        }
      }
      try
      {
        localObject1 = String.format(paramString, new Object[] { com.tencent.mm.wallet_core.ui.g.formatMoney2f(lL(String.valueOf(k), "100")) });
        paramString = (String)localObject1;
      }
      catch (Exception localException2)
      {
        label1123:
        acs localacs;
        break label1123;
      }
      this.Otf.setText(paramString);
      this.Otf.setVisibility(0);
      localacs = ((deh)localObject2).TMa;
      if ((localacs != null) && (!TextUtils.isEmpty(localacs.Soo)))
      {
        paramString = localacs.Soo;
        l2 = k;
      }
      try
      {
        localObject1 = String.format(paramString, new Object[] { com.tencent.mm.wallet_core.ui.g.formatMoney2f(lL(String.valueOf(l1 - l2), "100")) });
        paramString = (String)localObject1;
      }
      catch (Exception localException1)
      {
        label1206:
        break label1206;
      }
      localObject1 = new acs();
      ((acs)localObject1).Soo = paramString;
      ((acs)localObject1).jump_type = localacs.jump_type;
      ((acs)localObject1).Sop = localacs.Sop;
      ((acs)localObject1).jump_url = localacs.jump_url;
      ((acs)localObject1).Ooe = localacs.Ooe;
      paramString = ((deh)localObject2).TMb;
      localObject2 = new com.tencent.mm.plugin.wallet.balance.model.lqt.u.a();
      ((com.tencent.mm.plugin.wallet.balance.model.lqt.u.a)localObject2).Olh = paramString;
      paramString = ((com.tencent.mm.plugin.wallet.balance.model.lqt.u.a)localObject2).gFx();
      a(this.Ote, true, (acs)localObject1, null, null, paramString, 10);
      for (;;)
      {
        this.Otp = false;
        gGx();
        BJ(false);
        break;
        this.Otd.setVisibility(0);
        paramString = getString(a.i.wallet_lqt_fetch_remain_strongly_wording, new Object[] { Double.valueOf(lL(String.valueOf(k), "100")) });
        i = paramString.length();
        paramString = paramString + getString(a.i.wallet_lqt_fetch_remain_wording_1_2_tail);
        com.tencent.mm.wallet_core.ui.g.a(this.Ote, paramString, i, paramString.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
        {
          public final void bwz()
          {
            AppMethodBeat.i(216794);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, this.OtQ);
            AppMethodBeat.o(216794);
          }
        }), getContext());
        this.Otf.setVisibility(8);
      }
      if ((this.OmO != null) && (!this.OmO.gIH()) && (this.OmO.field_dayQuotaKind > 0.0D) && (l1 > lM(this.OmO.field_dayQuotaKind, "100")))
      {
        this.Otd.setVisibility(0);
        this.Ote.setText(getString(a.i.wallet_lqt_fetch_exceed_bankcard_limit, new Object[] { Double.valueOf(this.OmO.field_dayQuotaKind) }));
        this.Otf.setVisibility(8);
        this.Otp = false;
        gGx();
        BJ(false);
        break;
      }
      this.OsK.setText(this.Oth);
      this.OsK.setTextColor(this.hintTextColor);
      this.Otp = true;
      O(paramBoolean, paramString);
      BJ(true);
      this.Otd.setVisibility(8);
      break;
      if (this.mode == 1) {
        if ((this.OmO != null) && (this.OmO.gIH())) {
          this.OsK.setText(this.Oth);
        }
      }
      for (;;)
      {
        this.OsK.setTextColor(this.hintTextColor);
        this.Otp = false;
        BJ(false);
        break;
        this.OsK.setText("");
        continue;
        this.OsK.setText(this.Oth);
        gGx();
      }
      this.Otr = false;
      AppMethodBeat.o(182506);
      return;
      label1724:
      k = i;
    }
  }
  
  private void gG(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(274902);
    this.ErL.clear();
    final com.tencent.mm.plugin.wallet.ui.a locala = new com.tencent.mm.plugin.wallet.ui.a(this);
    Object localObject1 = v.Oly;
    this.Otq = v.alZ(this.mode);
    localObject1 = v.Oly;
    boolean bool;
    ctc localctc;
    if (this.mode == 1)
    {
      bool = true;
      localctc = ((v)localObject1).Bz(bool);
      if (this.OmO == null) {
        break label671;
      }
    }
    label134:
    label522:
    label528:
    label536:
    label542:
    label671:
    for (localObject1 = this.OmO.field_bindSerial;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = this.Otn;
        if (Util.isNullOrNil(this.Otn)) {
          com.tencent.mm.kernel.h.aHH();
        }
      }
      for (localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vue, "");; localObject1 = localObject2)
      {
        int i = 0;
        if (i < this.Otq.size())
        {
          localObject2 = (Bankcard)this.Otq.get(i);
          if ((Util.isNullOrNil(((Bankcard)localObject2).field_bindSerial)) || (!((String)localObject1).equals(((Bankcard)localObject2).field_bindSerial))) {}
        }
        for (;;)
        {
          locala.ODT = new WalletLqtSaveFetchUI.5(this, locala);
          locala.a(new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(277740);
              if (locala == null)
              {
                AppMethodBeat.o(277740);
                return;
              }
              WalletLqtSaveFetchUI.amg(paramInt);
              locala.tZx.bYF();
              if (locala.mBE < WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).size())
              {
                Bankcard localBankcard = (Bankcard)WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).get(locala.mBE);
                WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, localBankcard.field_bindSerial);
                WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
                if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
                {
                  if ((!TextUtils.isEmpty(paramString)) && (!localBankcard.gIH()))
                  {
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).setText(paramString);
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                    WalletLqtSaveFetchUI.this.showWcKb();
                    AppMethodBeat.o(277740);
                    return;
                  }
                  WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).fuo();
                  AppMethodBeat.o(277740);
                  return;
                }
                if ((WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this)) && (!localBankcard.gIH())) {
                  WalletLqtSaveFetchUI.p(WalletLqtSaveFetchUI.this);
                }
                WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText());
              }
              AppMethodBeat.o(277740);
            }
          });
          localObject1 = View.inflate(this, a.g.lqt_select_bankcard_header, null);
          paramString = (TextView)((View)localObject1).findViewById(a.f.lqt_select_bankcard_title);
          localObject2 = (TextView)((View)localObject1).findViewById(a.f.lqt_select_bankcard_tip);
          if ((localctc != null) && (!TextUtils.isEmpty(localctc.TAT)))
          {
            paramString.setText(localctc.TAT);
            if (!TextUtils.isEmpty(localctc.TAU))
            {
              ((TextView)localObject2).setText(localctc.TAU);
              ((TextView)localObject2).setVisibility(0);
              label305:
              ar.a(paramString.getPaint(), 0.8F);
              ((View)localObject1).findViewById(a.f.deviderline).setVisibility(0);
              ((View)localObject1).findViewById(a.f.lqt_header_close_icon_iv).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68975);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  if (locala != null) {
                    locala.tZx.bYF();
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(68975);
                }
              });
              paramString = v.Oly;
              if (this.mode != 1) {
                break label522;
              }
              bool = true;
              label363:
              paramString.BC(bool);
              if (!bool) {
                break label528;
              }
              paramString = paramString.Oli;
              label379:
              if (paramString == null) {
                break label536;
              }
            }
          }
          for (bool = paramString.TAK;; bool = false)
          {
            if (!bool) {
              break label542;
            }
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
            locala.OEb = true;
            locala.ah(getResources().getString(a.i.wallet_dialog_confirm));
            locala.mBE = i;
            locala.OEc = true;
            locala.setTitleView((View)localObject1);
            locala.eik();
            AppMethodBeat.o(274902);
            return;
            bool = false;
            break;
            i += 1;
            break label134;
            ((TextView)localObject2).setVisibility(8);
            break label305;
            if (this.mode == 1)
            {
              paramString.setText(a.i.wallet_lqt_save_alert_title);
              ((TextView)localObject2).setText(a.i.wallet_lqt_save_alert_tip);
              break label305;
            }
            paramString.setText(a.i.wallet_lqt_fetch_alert_title);
            ((TextView)localObject2).setText(a.i.wallet_lqt_fetch_alert_tip);
            break label305;
            bool = false;
            break label363;
            paramString = paramString.Olj;
            break label379;
          }
          paramString = new com.tencent.mm.ui.base.o(this);
          if (this.mode == 1) {
            paramString.a(0, getString(a.i.wallet_lqt_save_new_card), null, getResources().getDrawable(a.h.icons_outlined_pay_cards), getResources().getColor(a.c.FG_2), false);
          }
          for (;;)
          {
            locala.a(paramString, new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(278151);
                if (locala == null)
                {
                  AppMethodBeat.o(278151);
                  return;
                }
                locala.tZx.bYF();
                if ((WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1) || (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)) {
                  WalletLqtSaveFetchUI.q(WalletLqtSaveFetchUI.this);
                }
                AppMethodBeat.o(278151);
              }
            });
            break;
            if (this.mode == 2) {
              paramString.a(0, getString(a.i.wallet_lqt_fetch_new_card), null, getResources().getDrawable(a.h.icons_outlined_pay_cards), getResources().getColor(a.c.FG_2), false);
            }
          }
          i = 0;
        }
      }
    }
  }
  
  private void gGv()
  {
    AppMethodBeat.i(274900);
    String str1 = getString(a.i.wallet_lqt_fetch_back_card_network_exception);
    String str2 = getString(a.i.wallet_i_know_it);
    com.tencent.mm.ui.base.h.a(getContext(), str1, "", str2, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69003);
        WalletLqtSaveFetchUI.this.finish();
        AppMethodBeat.o(69003);
      }
    });
    AppMethodBeat.o(274900);
  }
  
  private void gGx()
  {
    AppMethodBeat.i(69013);
    WalletLqtArriveTimeLayout localWalletLqtArriveTimeLayout = this.Otb;
    localWalletLqtArriveTimeLayout.OoF = false;
    if (localWalletLqtArriveTimeLayout.OoB != null) {
      localWalletLqtArriveTimeLayout.OoB.clear();
    }
    localWalletLqtArriveTimeLayout.OoD = null;
    localWalletLqtArriveTimeLayout.OoC.clear();
    localWalletLqtArriveTimeLayout.setVisibility(4);
    AppMethodBeat.o(69013);
  }
  
  private List<Bankcard> gGy()
  {
    AppMethodBeat.i(69016);
    Object localObject1 = v.Oly;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((v)localObject1).BA(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        s.gGL();
        localObject1 = s.gGM().gKp();
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
        if (localBankcard.gIH())
        {
          s.gGL();
          if (!s.gGM().gJS())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.gIH()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.gIH()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label200:
    AppMethodBeat.o(69016);
    return localObject2;
  }
  
  private void gGz()
  {
    AppMethodBeat.i(69019);
    this.Otc.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187490);
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        WalletLqtSaveFetchUI.this.findViewById(a.f.lqt_save_hint).getLocationInWindow(arrayOfInt1);
        WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this).getLocationInWindow(arrayOfInt2);
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
        WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
        AppMethodBeat.o(187490);
      }
    }, 100L);
    AppMethodBeat.o(69019);
  }
  
  private void gR(boolean paramBoolean)
  {
    AppMethodBeat.i(69021);
    this.mWcKeyboard.Ih(paramBoolean);
    AppMethodBeat.o(69021);
  }
  
  private static double lL(String paramString1, String paramString2)
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
  
  private static int lM(String paramString1, String paramString2)
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
  
  public final void BK(boolean paramBoolean)
  {
    this.Onn = paramBoolean;
  }
  
  public final void bU(float paramFloat) {}
  
  public final void bsu()
  {
    AppMethodBeat.i(69029);
    if (this.mMi != null) {
      this.mMi.dismiss();
    }
    AppMethodBeat.o(69029);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(274903);
    if ((paramInt == 1) && (this.kte != null)) {
      this.kte.onClick(null);
    }
    AppMethodBeat.o(274903);
  }
  
  public final void gGA()
  {
    AppMethodBeat.i(69031);
    MMHandlerThread.removeRunnable(this.mMK);
    MMHandlerThread.removeRunnable(this.Ono);
    AppMethodBeat.o(69031);
  }
  
  public final void gGw()
  {
    AppMethodBeat.i(69012);
    if (this.mode == 1)
    {
      this.Oti = v.Oly.gFy();
      if (this.Oti == null)
      {
        s.gGL();
        this.Oti = s.gGM().OnP;
      }
      Object localObject;
      int i;
      if (this.Oti != null)
      {
        localObject = v.Oly.gFz();
        i = v.Oly.gFA();
        if (i != 0) {
          break label189;
        }
        this.Oth = ((CharSequence)localObject);
        if (this.OsK != null) {
          this.OsK.setText(this.Oth);
        }
      }
      if (this.OsE != null) {
        this.OsE.setVisibility(0);
      }
      if (!Util.isNullOrNil(v.Oly.Olt))
      {
        this.EHc.setText(v.Oly.Olt);
        this.EHc.setVisibility(0);
      }
      for (;;)
      {
        localObject = y.gFD().gFE();
        if ((localObject != null) && (((deh)localObject).TwU) && (((deh)localObject).TLU != null)) {
          ai.a(getContext(), ((deh)localObject).TLU);
        }
        BI(true);
        AppMethodBeat.o(69012);
        return;
        label189:
        if (i == 1)
        {
          i = ((String)localObject).length();
          localObject = new SpannableString((String)localObject + getString(a.i.wallet_lqt_balance_remain_wording_2));
          ((SpannableString)localObject).setSpan(new com.tencent.mm.wallet_core.ui.f(new f.a()
          {
            public final void bwz()
            {
              AppMethodBeat.i(69005);
              WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).OND));
              WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
              WalletLqtSaveFetchUI.this.showWcKb();
              AppMethodBeat.o(69005);
            }
          }), i + 1, ((SpannableString)localObject).length(), 18);
          this.Oth = ((CharSequence)localObject);
          break;
        }
        Log.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", new Object[] { Integer.valueOf(i) });
        this.Oth = ((CharSequence)localObject);
        break;
        this.EHc.setVisibility(8);
      }
    }
    if (this.Otb.OoF)
    {
      BI(false);
      AppMethodBeat.o(69012);
      return;
    }
    BI(true);
    AppMethodBeat.o(69012);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_lqt_save_ui;
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(69026);
    Log.d("MicroMsg.WalletLqtSaveFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.Onn), Boolean.valueOf(this.mWcKeyboard.iit()) });
    if ((!this.Onn) && (this.mWcKeyboard.iit()))
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
      this.OsD.OmC.lg(this.mode, this.Omq).f(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(69027);
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra(af.Omi, this.Otn);
    }
    af localaf = this.OsC;
    String str1;
    if ((paramInt1 == af.Omg) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra(af.Omi);
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.ORd != null) && (paramIntent.ORd.size() > 0))
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(localaf.hashCode()), Integer.valueOf(localaf.Omq), paramIntent.fwv });
        localaf.fww = ((Orders.Commodity)paramIntent.ORd.get(0)).fww;
        paramIntent = (String)localaf.Omt.get(paramIntent.fwv);
        if (!Util.isNullOrNil(paramIntent)) {
          localaf.Omm = paramIntent;
        }
        if ((localaf.Oml instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)localaf.Oml).Onn = true;
          ((WalletLqtSaveFetchUI)localaf.Oml).gGA();
        }
        localaf.gF(str1, 0);
      }
      AppMethodBeat.o(69027);
      return;
    }
    if ((paramInt1 == af.Omh) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra(af.Omi);
      String str2 = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
      paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
      Log.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localaf.hashCode()), Integer.valueOf(localaf.Omq), paramIntent });
      if ((localaf.Oml instanceof WalletLqtSaveFetchUI))
      {
        ((WalletLqtSaveFetchUI)localaf.Oml).Onn = true;
        ((WalletLqtSaveFetchUI)localaf.Oml).gGA();
      }
      Log.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localaf.hashCode()), paramIntent });
      if (Util.isNullOrNil(localaf.Omp))
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localaf.hashCode()), paramIntent });
        localaf.Omp = paramIntent;
      }
      paramIntent = localaf.Oml.getIntent().getStringExtra("operate_id");
      localaf.Oml.showLoading(true);
      ae.c localc = localaf.Omk.Omd;
      com.tencent.mm.vending.g.g.b(Integer.valueOf(localaf.Omo), str2, localaf.Omp, Integer.valueOf(localaf.Omq), paramIntent).c(localc).f(new af.2(localaf, str1)).a(new af.13(localaf));
    }
    AppMethodBeat.o(69027);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69010);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.normal_actionbar_color));
    hideActionbarLine();
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
    this.OpT = new a(this);
    this.OsF = ((WalletFormView)findViewById(a.f.lqt_save_form));
    this.OsJ = ((ImageView)findViewById(a.f.bankcard_logo_iv));
    this.OsK = ((TextView)findViewById(a.f.lqt_save_balance_hint));
    this.OsL = ((TextView)findViewById(a.f.lqt_save_balance_hint2));
    this.OsG = ((TextView)findViewById(a.f.lqt_save_hint));
    this.OsH = ((TextView)findViewById(a.f.lqt_balance_bankcard));
    ar.a(this.OsH.getPaint(), 0.8F);
    this.OsZ = ((TextView)findViewById(a.f.wallet_title));
    this.EHc = ((TextView)findViewById(a.f.lqt_save_tips_tv));
    this.Otg = ((TextView)findViewById(a.f.lqt_save_fetch_alert_tv));
    this.OsM = ((ViewGroup)findViewById(a.f.lqt_save_protocal_layout));
    this.OsN = ((TextView)findViewById(a.f.lqt_save_protocol_link_tv));
    this.OsO = ((CheckBox)findViewById(a.f.lqt_save_protocol_agree_checkbox));
    this.OsE = ((ViewGroup)findViewById(a.f.main_content));
    this.OsP = ((TextView)findViewById(a.f.hint_1));
    this.OsQ = ((TextView)findViewById(a.f.hint_2));
    this.OsR = ((LinearLayout)findViewById(a.f.purchase_from_lq_prompt_ll));
    this.OsS = ((LinearLayout)findViewById(a.f.lqt_bank_card_load_ll));
    this.OsT = ((LinearLayout)findViewById(a.f.lqt_bank_card_content_ll));
    this.OsU = ((TextView)findViewById(a.f.lqt_bank_card_desc_text));
    this.OsV = ((LinearLayout)findViewById(a.f.lqt_balance_load_ll));
    this.OsW = ((LinearLayout)findViewById(a.f.lqt_balance_show_detail_ll));
    this.OsY = ((TextView)findViewById(a.f.lqt_balance_load_desc_text));
    this.OsI = ((TextView)findViewById(a.f.balance_tips_tv));
    this.Otb = ((WalletLqtArriveTimeLayout)findViewById(a.f.lqt_save_arrive_time_layout));
    this.Otc = ((ScrollView)findViewById(a.f.lqt_root_view));
    this.Otd = ((LinearLayout)findViewById(a.f.lqt_fetch_strongly_remind_layout));
    this.Ote = ((TextView)findViewById(a.f.lqt_fetch_strongly_tip));
    this.Otf = ((TextView)findViewById(a.f.lqt_fetch_strongly_tip2));
    this.OsX = ((LinearLayout)findViewById(a.f.hint_linear_layout));
    ar.a(this.Otf.getPaint(), 0.8F);
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    int i = getIntent().getIntExtra("entrance_type", 0);
    this.OsC.mode = this.mode;
    this.OsC.Oms = i;
    this.Otj = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.Otk = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.Otl = getIntent().getStringExtra("lqt_profile_wording");
    this.Omq = getIntent().getIntExtra("lqt_account_type", 0);
    if (ar.isDarkMode()) {
      this.OsR.setBackground(getResources().getDrawable(a.e.lqt_purchase_from_lq_prompt_night_bg));
    }
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.h.aHH();
      this.Otn = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vuf, ""));
      if (Util.isNullOrNil(this.Otn))
      {
        com.tencent.mm.kernel.h.aHH();
        this.Otn = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vue, ""));
      }
      this.Oto = getIntent().getStringExtra("card_serial");
      this.OsS.setVisibility(8);
      this.OsT.setVisibility(0);
      this.OsV.setVisibility(8);
      this.OsW.setVisibility(0);
    }
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.Omq), Integer.valueOf(this.mode), this.Otn });
    this.OsF.getTitleTv().setText(ah.ijb());
    this.mWcKeyboard = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    paramBundle = (RelativeLayout.LayoutParams)this.mWcKeyboard.getLayoutParams();
    paramBundle.addRule(12);
    this.mWcKeyboard.setLayoutParams(paramBundle);
    label917:
    int j;
    if (this.mode == 1)
    {
      setWPKeyboard(this.OsF.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(a.i.wallet_lqt_save_wording));
      if (com.tencent.mm.compatible.util.d.qX(27)) {
        this.OsF.ijE();
      }
      setWcKbHeightListener(this);
      if (this.mode != 1) {
        break label1510;
      }
      this.OsG.setText(getString(a.i.wallet_lqt_save_amount_hint));
      this.OsZ.setText(getString(a.i.wallet_lqt_save_hint_bank_card_wording));
      this.OsF.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(246666);
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
            AppMethodBeat.o(246666);
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
          AppMethodBeat.i(186265);
          if (paramAnonymousBoolean)
          {
            if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
            {
              WalletLqtSaveFetchUI.t(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(186265);
              return;
            }
            if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1) {
              AppMethodBeat.o(186265);
            }
          }
          else
          {
            WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this).scrollTo(0, 0);
            if ((WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2) && (Util.isNullOrNil(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).getText()))) {
              WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(186265);
        }
      });
      this.OsF.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(244375);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
            WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this);
            com.tencent.mm.plugin.report.service.h.IzE.a(20287, new Object[] { Integer.valueOf(2) });
            AppMethodBeat.o(244375);
            return true;
          }
          AppMethodBeat.o(244375);
          return true;
        }
      });
      if (!Util.isNullOrNil(this.Otl)) {
        this.mWcKeyboard.setTipText(this.Otl);
      }
      if (this.mode == 2) {
        this.Otb.setCallback(new WalletLqtArriveTimeLayout.a()
        {
          public final void gGa()
          {
            AppMethodBeat.i(269893);
            WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, true);
            AppMethodBeat.o(269893);
          }
        });
      }
      j = this.OsZ.getWidth();
      Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveFetchHintWordingTv width: %d", new Object[] { Integer.valueOf(j) });
      if (j > 0) {
        break label1549;
      }
      this.OsZ.post(new Runnable()
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
      label1057:
      this.OsK.setText("");
      this.OsK.setClickable(true);
      this.OsK.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
      BJ(false);
      this.Ote.setClickable(true);
      this.Ote.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
      this.Otf.setClickable(true);
      this.Otf.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
      if (this.mode != 1) {
        break label1591;
      }
      this.OsE.setVisibility(4);
      if (i != 8) {
        break label1581;
      }
      setMMTitle(a.i.wallet_lqt_save_title);
      this.mWcKeyboard.showNormalStWcKb();
    }
    for (;;)
    {
      if (this.OsH.findViewById(a.f.wallet_tips_msg) != null) {
        this.OsH.findViewById(a.f.wallet_tips_msg).setVisibility(8);
      }
      paramBundle = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68967);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          WalletLqtSaveFetchUI.this.hideTenpayKB();
          int i = -1;
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(28) });
            i = 2;
          }
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2) {
            com.tencent.mm.plugin.report.service.h.IzE.a(20287, new Object[] { Integer.valueOf(3) });
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, i);
          if (WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this)) {
            WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).OmD.lf(1, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68967);
        }
      };
      this.OsH.setOnClickListener(paramBundle);
      if (findViewById(a.f.lqt_balance_bankcard_click_layout) != null) {
        findViewById(a.f.lqt_balance_bankcard_click_layout).setOnClickListener(paramBundle);
      }
      paramBundle = v.Oly;
      Object localObject = this.Otx;
      paramBundle.Olx.add(localObject);
      gGw();
      this.OsE.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(68982);
          if ((WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this).isShown()) && (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this).iir()))
          {
            WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this).iip();
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
        this.OsF.setText(paramBundle);
        cQ(paramBundle, false);
      }
      paramBundle = this.OsF.getContentEt();
      localObject = this.OsF.getTitleTv();
      float f2 = com.tencent.mm.ci.a.ez(this);
      float f3 = com.tencent.mm.cj.a.hrd();
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
      setWPKeyboard(this.OsF.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(a.i.wallet_lqt_fetch_wording));
      break;
      label1510:
      if (this.mode != 2) {
        break label917;
      }
      this.OsG.setText(getString(a.i.wallet_lqt_fetch_amount_hint));
      this.OsZ.setText(getString(a.i.wallet_lqt_fetch_hint_bank_card_wording));
      break label917;
      label1549:
      paramBundle = (LinearLayout.LayoutParams)this.OsX.getLayoutParams();
      if (paramBundle != null) {
        paramBundle.leftMargin = j;
      }
      this.OsX.setLayoutParams(paramBundle);
      break label1057;
      label1581:
      setMMTitle(a.i.wallet_lqt_save_wording);
      continue;
      label1591:
      setMMTitle(a.i.wallet_lqt_fetch_wording);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69030);
    super.onDestroy();
    gGA();
    v localv = v.Oly;
    v.a locala = this.Otx;
    localv.Olx.remove(locala);
    v.Oly.Olj = null;
    this.OsC = null;
    this.OsD = null;
    AppMethodBeat.o(69030);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(69025);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
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
    paramIntent = gGy();
    this.OsD.OmC.lg(this.mode, this.Omq).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(69017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69024);
    super.onPause();
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onPause()");
    this.OpV.dead();
    if (!this.mWcKeyboard.iis()) {
      this.state = 3;
    }
    AppMethodBeat.o(69024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69023);
    super.onResume();
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onResume()");
    this.OpV.alive();
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.Ono, 300L);
    }
    this.state = 2;
    if (this.Ott)
    {
      this.Ott = false;
      aau localaau = new aau();
      localaau.fZT.mode = this.mode;
      EventCenter.instance.publish(localaau);
    }
    AppMethodBeat.o(69023);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69028);
    af localaf = this.OsC;
    Log.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.ae))
    {
      s.gGL();
      localaf.Omr = s.gGM().OnP;
      if (localaf.mJv != null)
      {
        localaf.mJv.G(new Object[] { paramq });
        localaf.mJv.resume();
      }
    }
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
    gGw();
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    AppMethodBeat.o(69028);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI
 * JD-Core Version:    0.7.0.1
 */