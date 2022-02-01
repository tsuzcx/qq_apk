package com.tencent.mm.plugin.wallet.balance.ui.lqt;

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
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acp;
import com.tencent.mm.autogen.a.acr;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag.13;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag.2;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ah;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ah.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ah.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ah.e;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aj;
import com.tencent.mm.plugin.wallet.balance.model.lqt.v;
import com.tencent.mm.plugin.wallet.balance.model.lqt.v.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.protocal.protobuf.eok;
import com.tencent.mm.protocal.protobuf.fnh;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
  private TextView KAm;
  private HashMap<String, Integer> Kkr;
  private IListener<ng> Myr;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ae VaP;
  private af VaQ;
  private int VaW;
  private Bankcard Vbu;
  protected boolean Vcb;
  private Runnable Vcc;
  private a VeS;
  private IListener VeY;
  public ag VhH;
  private ah VhI;
  private ViewGroup VhJ;
  private WalletFormView VhK;
  private TextView VhL;
  private TextView VhM;
  private TextView VhN;
  private ImageView VhO;
  private TextView VhP;
  private TextView VhQ;
  private ViewGroup VhR;
  private TextView VhS;
  private CheckBox VhT;
  private TextView VhU;
  private TextView VhV;
  private LinearLayout VhW;
  private LinearLayout VhX;
  private LinearLayout VhY;
  private TextView VhZ;
  private boolean ViA;
  private String ViB;
  private boolean ViC;
  private String ViD;
  private boolean ViE;
  private w.a ViF;
  private LinearLayout Via;
  private LinearLayout Vib;
  private LinearLayout Vic;
  private LinearLayout Vid;
  private TextView Vie;
  private TextView Vif;
  private boolean Vig;
  private WalletLqtArriveTimeLayout Vih;
  private ScrollView Vii;
  private TextView Vij;
  private LinearLayout Vik;
  private TextView Vil;
  private TextView Vim;
  private TextView Vin;
  private CharSequence Vio;
  private Bankcard Vip;
  private int Viq;
  private String Vir;
  private String Vis;
  private long Vit;
  public String Viu;
  private String Viv;
  private boolean Viw;
  private List<Bankcard> Vix;
  private boolean Viy;
  private boolean Viz;
  private int hintTextColor;
  final View.OnClickListener mWW;
  private int mode;
  private Dialog pIQ;
  public Runnable pJs;
  private int state;
  
  public WalletLqtSaveFetchUI()
  {
    AppMethodBeat.i(69009);
    this.VaP = ((com.tencent.mm.plugin.wallet.balance.model.lqt.ae)aM(com.tencent.mm.plugin.wallet.balance.model.lqt.ae.class));
    this.VaQ = ((af)aI(af.class));
    this.VhH = new ag(this.VaP, this.VaQ, this);
    this.VhI = new ah(this.VhH);
    this.Vit = -1L;
    this.Viw = false;
    this.Viy = true;
    this.Viz = false;
    this.ViA = false;
    this.Vcb = false;
    this.ViB = "";
    this.ViC = false;
    this.hintTextColor = MMApplicationContext.getContext().getResources().getColor(a.c.FG_1);
    this.ViD = "";
    this.ViE = false;
    this.ViF = new w.a()
    {
      public final void aI(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(316388);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "cache updated show Error:" + paramAnonymousBoolean + " errMsg:" + paramAnonymousString);
        if (!WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramAnonymousBoolean, paramAnonymousString))
        {
          AppMethodBeat.o(316388);
          return;
        }
        WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this);
        WalletLqtSaveFetchUI.this.hideLoading();
        WalletLqtSaveFetchUI.this.ifx();
        WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this);
        if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1)
        {
          WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69001);
              WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this).setMinimumHeight(WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this).getHeight());
              AppMethodBeat.o(69001);
            }
          });
          AppMethodBeat.o(316388);
          return;
        }
        if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
        {
          paramAnonymousString = WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getText();
          if (!Util.isNullOrNil(paramAnonymousString)) {
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramAnonymousString);
          }
        }
        AppMethodBeat.o(316388);
      }
    };
    this.Kkr = new HashMap();
    this.mWW = new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316390);
        if (Util.ticksToNow(WalletLqtSaveFetchUI.A(WalletLqtSaveFetchUI.this)) < 800L)
        {
          Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
          AppMethodBeat.o(316390);
          return;
        }
        WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, Util.currentTicks());
        final int k = WalletLqtSaveFetchUI.nA(WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getText(), "100");
        dwg localdwg;
        if (k > 0)
        {
          WalletLqtSaveFetchUI.this.hideWcKb();
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1)
          {
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
            if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, w.Vad.UZX))
            {
              AppMethodBeat.o(316390);
              return;
            }
            paramAnonymousView = WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).Vbf;
            com.tencent.mm.vending.g.g.f(Integer.valueOf(k), Integer.valueOf(WalletLqtSaveFetchUI.B(WalletLqtSaveFetchUI.this)), WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this)).c(paramAnonymousView).f(new com.tencent.mm.vending.c.a()
            {
              private Void a(ejz paramAnonymous2ejz)
              {
                AppMethodBeat.i(316495);
                if (paramAnonymous2ejz == null)
                {
                  Log.i("MicroMsg.WalletLqtSaveFetchUI", "save failed, qryPurchaseResultRes is null");
                  AppMethodBeat.o(316495);
                  return null;
                }
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[] { Integer.valueOf(paramAnonymous2ejz.abou) });
                WalletLqtSaveFetchUI.this.ifD();
                Object localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                ((Intent)localObject).putExtra("key_amount", i.a(k, "100", 2, RoundingMode.HALF_UP));
                ((Intent)localObject).putExtra("key_mode", 1);
                ((Intent)localObject).putExtra("profile_date_wording", paramAnonymous2ejz.abow);
                ((Intent)localObject).putExtra("profile_upgrade_wording", paramAnonymous2ejz.abov);
                if (paramAnonymous2ejz.abox != null) {}
                try
                {
                  ((Intent)localObject).putExtra("key_guide_cell", paramAnonymous2ejz.abox.toByteArray());
                  ((Intent)localObject).putExtra("entrance_type", WalletLqtSaveFetchUI.this.getIntent().getIntExtra("entrance_type", 0));
                  paramAnonymous2ejz = WalletLqtSaveFetchUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2ejz, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$28$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2ejz.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2ejz, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$28$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  WalletLqtSaveFetchUI.this.finish();
                  paramAnonymous2ejz = aguz;
                  AppMethodBeat.o(316495);
                  return paramAnonymous2ejz;
                }
                catch (IOException paramAnonymous2ejz)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2ejz, "", new Object[0]);
                  }
                }
              }
            }).a(new d.a()
            {
              public final void onInterrupt(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(316494);
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[] { paramAnonymous2Object });
                WalletLqtSaveFetchUI.this.bQa();
                if (paramAnonymous2Object != null) {
                  if (!(paramAnonymous2Object instanceof String)) {
                    break label74;
                  }
                }
                label74:
                for (paramAnonymous2Object = paramAnonymous2Object.toString();; paramAnonymous2Object = WalletLqtSaveFetchUI.this.getString(a.i.wallet_lqt_network_error))
                {
                  com.tencent.mm.ui.base.k.d(WalletLqtSaveFetchUI.this, paramAnonymous2Object, "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(316419);
                      Log.i("MicroMsg.WalletLqtSaveFetchUI", "SAVE MMAlert Interrupt click");
                      AppMethodBeat.o(316419);
                    }
                  });
                  AppMethodBeat.o(316494);
                  return;
                }
              }
            });
            AppMethodBeat.o(316390);
            return;
          }
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
          {
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
            if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, w.Vad.UZY))
            {
              AppMethodBeat.o(316390);
              return;
            }
            localdwg = null;
            paramAnonymousView = localdwg;
            if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
            {
              paramAnonymousView = localdwg;
              if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).ihV())
              {
                paramAnonymousView = new jl();
                paramAnonymousView.JFk = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankName;
                paramAnonymousView.hAk = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardType;
                paramAnonymousView.YLE = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bindSerial;
                paramAnonymousView.MEp = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardTail;
              }
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this).getSelectRedeemType() == null) {
              break label542;
            }
          }
        }
        label542:
        for (int i = WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this).getSelectRedeemType().ablG;; i = 0)
        {
          int j = i;
          if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
          {
            j = i;
            if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).ihV())
            {
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose bankcard");
              int m = i.qx(WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getText(), "100");
              localdwg = com.tencent.mm.plugin.wallet.balance.model.lqt.z.ieB().ieC();
              if ((localdwg.abcf >= 0) && (m > localdwg.abcf))
              {
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose slow redeem");
                WalletLqtSaveFetchUI.C(WalletLqtSaveFetchUI.this);
                AppMethodBeat.o(316390);
                return;
              }
              j = i;
              if (localdwg.abcf >= 0)
              {
                j = i;
                if (m < localdwg.abcf)
                {
                  Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose fast redeem");
                  j = 0;
                }
              }
            }
          }
          WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).Vbg.a(k, WalletLqtSaveFetchUI.B(WalletLqtSaveFetchUI.this), j, paramAnonymousView).f(new com.tencent.mm.vending.c.a()
          {
            private Void a(eoj paramAnonymous2eoj)
            {
              AppMethodBeat.i(316499);
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { paramAnonymous2eoj, Boolean.valueOf(paramAnonymous2eoj.absF), Boolean.valueOf(paramAnonymous2eoj.absG) });
              WalletLqtSaveFetchUI.this.ifD();
              Object localObject;
              if ((paramAnonymous2eoj.absF) && (paramAnonymous2eoj.absG))
              {
                localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                ((Intent)localObject).putExtra("key_amount", i.a(k, "100", 2, RoundingMode.HALF_UP));
                ((Intent)localObject).putExtra("key_mode", 2);
                paramAnonymous2eoj = WalletLqtSaveFetchUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2eoj, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$28$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2eoj.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2eoj, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$28$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                WalletLqtSaveFetchUI.this.finish();
                paramAnonymous2eoj = aguz;
                AppMethodBeat.o(316499);
                return paramAnonymous2eoj;
                localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressNewUI.class);
                try
                {
                  ((Intent)localObject).putExtra("key_redeem_res", paramAnonymous2eoj.toByteArray());
                  paramAnonymous2eoj = WalletLqtSaveFetchUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2eoj, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$28$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2eoj.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2eoj, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$28$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                catch (Exception paramAnonymous2eoj)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2eoj, "pass redeemFundRes error: %s", new Object[] { paramAnonymous2eoj.getMessage() });
                  }
                }
              }
            }
          }).a(new d.a()
          {
            public final void onInterrupt(Object paramAnonymous2Object)
            {
              boolean bool = false;
              AppMethodBeat.i(316489);
              WalletLqtSaveFetchUI.this.Vcb = false;
              WalletLqtSaveFetchUI.this.bQa();
              if (paramAnonymous2Object != null)
              {
                if ((paramAnonymous2Object instanceof eoj)) {
                  bool = com.tencent.mm.wallet_core.c.h.a(WalletLqtSaveFetchUI.this, null, 1000, ((eoj)paramAnonymous2Object).wuz, ((eoj)paramAnonymous2Object).wuA);
                }
                if (!bool)
                {
                  if (!(paramAnonymous2Object instanceof String)) {
                    break label112;
                  }
                  paramAnonymous2Object = paramAnonymous2Object.toString();
                }
              }
              for (;;)
              {
                com.tencent.mm.ui.base.k.d(WalletLqtSaveFetchUI.this, paramAnonymous2Object, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(316432);
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "fetch MMAlert Interrupt click");
                    AppMethodBeat.o(316432);
                  }
                });
                AppMethodBeat.o(316489);
                return;
                label112:
                if ((paramAnonymous2Object instanceof eoj)) {
                  paramAnonymous2Object = ((eoj)paramAnonymous2Object).wuA;
                } else {
                  paramAnonymous2Object = WalletLqtSaveFetchUI.this.getString(a.i.wallet_lqt_network_error);
                }
              }
            }
          });
          AppMethodBeat.o(316390);
          return;
        }
      }
    };
    this.VeY = new IListener(com.tencent.mm.app.f.hfK) {};
    this.state = 0;
    this.pJs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316492);
        if ((WalletLqtSaveFetchUI.F(WalletLqtSaveFetchUI.this) == 2) && (WalletLqtSaveFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletLqtSaveFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(316492);
      }
    };
    this.Vcc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316482);
        WalletLqtSaveFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(316482);
      }
    };
    this.Myr = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(69009);
  }
  
  private void Hn(boolean paramBoolean)
  {
    AppMethodBeat.i(69015);
    if ((this.mode == 2) && (paramBoolean))
    {
      this.Vbu = w.Vad.He(false);
      if (this.Vbu == null)
      {
        this.VhX.setVisibility(0);
        this.VhZ.setText(getString(a.i.wallet_lqt_fetch_back_card_load_pb));
        this.VhY.setVisibility(8);
        this.Via.setVisibility(0);
        this.Vib.setVisibility(8);
        this.Vie.setText(getString(a.i.wallet_lqt_balance_load_pb));
        this.VhM.setClickable(false);
        if (findViewById(a.f.lqt_balance_bankcard_click_layout) != null) {
          findViewById(a.f.lqt_balance_bankcard_click_layout).setClickable(false);
        }
        this.VhK.setContentClickable(false);
        localObject1 = this.VhK.getContentEt();
        if (localObject1 != null) {
          ((EditText)localObject1).setCursorVisible(false);
        }
        findViewById(a.f.wallet_info_tip).setVisibility(8);
        this.Vik.setVisibility(8);
        this.VhR.setVisibility(8);
        this.VhQ.setVisibility(8);
        this.Vid.setVisibility(8);
        this.VhW.setVisibility(8);
        AppMethodBeat.o(69015);
        return;
      }
    }
    if (this.mode == 2)
    {
      this.VhM.setClickable(true);
      if (findViewById(a.f.lqt_balance_bankcard_click_layout) != null) {
        findViewById(a.f.lqt_balance_bankcard_click_layout).setClickable(true);
      }
      this.VhK.setContentClickable(true);
      localObject1 = this.VhK.getContentEt();
      if (localObject1 != null) {
        ((EditText)localObject1).setCursorVisible(true);
      }
    }
    this.VhX.setVisibility(8);
    this.VhY.setVisibility(0);
    this.Via.setVisibility(8);
    this.Vib.setVisibility(0);
    Object localObject1 = w.Vad;
    boolean bool;
    Object localObject2;
    Object localObject3;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((w)localObject1).Hg(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.model.p.ifO();
        localObject1 = com.tencent.mm.plugin.wallet.model.p.ifP().ijG();
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
        if (((Bankcard)localObject3).ihV())
        {
          com.tencent.mm.plugin.wallet.model.p.ifO();
          if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijh())
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
      if (!Util.isNullOrNil(this.Viv))
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject1 = (Bankcard)((List)localObject2).get(i);
          if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Viv.equals(((Bankcard)localObject1).field_bindSerial))) {
            this.Vbu = ((Bankcard)localObject1);
          }
          i += 1;
        }
      }
      if ((Util.isNullOrNil(this.Viv)) || (this.Vbu == null))
      {
        localObject1 = w.Vad;
        if (this.mode == 1) {}
        for (bool = true;; bool = false)
        {
          this.Vbu = ((w)localObject1).He(bool);
          if ((Util.isNullOrNil(this.Viu)) || (this.Vbu != null)) {
            break;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = (Bankcard)((List)localObject2).get(i);
            if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Viu.equals(((Bankcard)localObject1).field_bindSerial))) {
              this.Vbu = ((Bankcard)localObject1);
            }
            i += 1;
          }
        }
      }
    }
    else if (!Util.isNullOrNil(this.Viu))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!Util.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Viu.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.Vbu = ((Bankcard)localObject1);
        }
        i += 1;
      }
    }
    if (this.Vbu != null) {}
    for (localObject1 = this.Vbu.field_bindSerial;; localObject1 = "")
    {
      Log.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", new Object[] { localObject1, this.Viu, Boolean.valueOf(paramBoolean) });
      if (this.Vbu != null) {
        break;
      }
      com.tencent.mm.plugin.wallet.model.p.ifO();
      this.Vbu = com.tencent.mm.plugin.wallet.model.p.ifP().VcF;
      if (this.Vbu != null) {
        break;
      }
      finish();
      AppMethodBeat.o(69015);
      return;
    }
    if (this.Vbu.ihV())
    {
      this.VhM.setText(this.Vbu.field_desc);
      this.VhM.setText(this.Vbu.field_desc);
      this.VhM.setVisibility(0);
      this.VhO.setTag(this.Vbu.field_bindSerial);
      if (this.VhO != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Vbu.field_bankcardType, this.Vbu.ihU());
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject2).MpW;
        }
        this.VhO.setImageBitmap(null);
        if (!this.Vbu.ihV()) {
          break label1638;
        }
        this.VhO.setImageResource(a.e.wallet_balance_manager_logo_small);
      }
      label1029:
      this.Vid.setVisibility(8);
      this.VhW.setVisibility(8);
      if (this.mode != 2) {
        break label1710;
      }
      localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.z.ieB().ieC();
      if ((localObject1 != null) && (!this.Vbu.ihV()) && (!TextUtils.isEmpty(((dwg)localObject1).abcg)))
      {
        this.Vid.setVisibility(0);
        this.VhU.setText(((dwg)localObject1).abcg);
        this.VhU.setVisibility(0);
        if (findViewById(a.f.lqt_balance_bankcard_click_layout) != null) {
          findViewById(a.f.lqt_balance_bankcard_click_layout).sendAccessibilityEvent(128);
        }
      }
      label1140:
      if (this.mode != 1) {
        break label2100;
      }
      localObject1 = new ArrayList();
      localObject2 = ifw();
      if (localObject2 == null) {
        break label2457;
      }
      localObject1 = cd(((dwc)localObject2).abbV);
      bool = ((dwc)localObject2).abbT;
      paramBoolean = ((dwc)localObject2).abbU;
    }
    for (;;)
    {
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0) && (bool))
      {
        this.VhR.setVisibility(0);
        this.VhT.setChecked(paramBoolean);
        this.VhR.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(316369);
            if (!WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this).isChecked()) {}
            for (boolean bool = true;; bool = false)
            {
              WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this).setChecked(bool);
              AppMethodBeat.o(316369);
              return;
            }
          }
        });
        this.VhT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(316372);
            if (!paramAnonymousBoolean)
            {
              WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, false);
              AppMethodBeat.o(316372);
              return;
            }
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, true);
            AppMethodBeat.o(316372);
          }
        });
        localObject2 = getString(a.i.wallet_lqt_protocol_agree_prefix);
        i = ((String)localObject2).length();
        localObject2 = new SpannableString((String)localObject2 + getString(a.i.wallet_lqt_protocol_agree_suffix));
        ((SpannableString)localObject2).setSpan(new com.tencent.mm.wallet_core.ui.f(new f.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(316370);
            paramAnonymousView = new com.tencent.mm.ui.widget.a.f(WalletLqtSaveFetchUI.this, 1, false);
            paramAnonymousView.Vtg = new u.g()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
              {
                AppMethodBeat.i(316522);
                Iterator localIterator = WalletLqtSaveFetchUI.15.this.ViQ.iterator();
                int i = 0;
                while (localIterator.hasNext())
                {
                  paramAnonymous2s.add(0, i, 0, ((String)localIterator.next()).split("\\|\\|")[0]);
                  i += 1;
                }
                AppMethodBeat.o(316522);
              }
            };
            paramAnonymousView.GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(316521);
                paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
                if (paramAnonymous2Int < WalletLqtSaveFetchUI.15.this.ViQ.size())
                {
                  paramAnonymous2MenuItem = ((String)WalletLqtSaveFetchUI.15.this.ViQ.get(paramAnonymous2Int)).split("\\|\\|")[1];
                  i.p(WalletLqtSaveFetchUI.this, paramAnonymous2MenuItem, false);
                }
                AppMethodBeat.o(316521);
              }
            };
            paramAnonymousView.dDn();
            AppMethodBeat.o(316370);
          }
        }), i, ((SpannableString)localObject2).length(), 17);
        this.VhS.setText((CharSequence)localObject2);
        this.VhS.setClickable(true);
        this.VhS.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
      }
      for (;;)
      {
        if (this.mode == 1)
        {
          if ((this.Vbu != null) && (this.Vbu.ihV()))
          {
            as(this.Vio);
            localObject1 = w.Vad.Hf(true);
            if (localObject1 != null)
            {
              if ((((dke)localObject1).aaQg != null) && (!Util.isNullOrNil(((dke)localObject1).aaQg.ZmZ)))
              {
                localObject2 = new SpannableStringBuilder(((dke)localObject1).aaQg.ZmZ);
                if ((!Util.isNullOrNil(((dke)localObject1).aaQg.Zna)) && (!Util.isNullOrNil(((dke)localObject1).aaQg.jump_url)))
                {
                  ((SpannableStringBuilder)localObject2).append(((dke)localObject1).aaQg.Zna);
                  ((SpannableStringBuilder)localObject2).setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
                  {
                    public final void eS(View paramAnonymousView)
                    {
                      AppMethodBeat.i(316545);
                      Log.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                      i.a(WalletLqtSaveFetchUI.this.getContext(), this.ViJ.aaQg.jump_url, true, 1);
                      com.tencent.mm.plugin.report.service.h.OAn.b(20216, new Object[] { Integer.valueOf(1), this.ViJ.aaQg.jump_url });
                      AppMethodBeat.o(316545);
                    }
                  }), ((dke)localObject1).aaQg.ZmZ.length(), ((SpannableStringBuilder)localObject2).length(), 18);
                }
                this.VhN.setText((CharSequence)localObject2);
                this.VhN.setClickable(true);
                this.VhN.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(getContext()));
                this.VhN.setVisibility(0);
                this.hintTextColor = getResources().getColor(a.c.FG_0);
                AppMethodBeat.o(69015);
                return;
                this.VhM.setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.Vbu.field_bankName, this.Vbu.field_bankcardTail }));
                break;
                label1638:
                localObject1 = r.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
                r.a(new r.a()
                {
                  public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
                  {
                    AppMethodBeat.i(316538);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(316441);
                        if ((WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null) && (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this) != null) && (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).getTag() != null) && (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).getTag().equals(WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bindSerial))) {
                          WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).setImageBitmap(paramAnonymousBitmap);
                        }
                        AppMethodBeat.o(316441);
                      }
                    });
                    AppMethodBeat.o(316538);
                  }
                });
                if (localObject1 == null) {
                  break label1029;
                }
                localObject1 = BitmapUtil.extractThumbNail((Bitmap)localObject1, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
                this.VhO.setImageBitmap((Bitmap)localObject1);
                break label1029;
                label1710:
                if (this.mode != 1) {
                  break label1140;
                }
                if ((!this.Vbu.ihV()) && (!Util.isNullOrNil(this.Vbu.field_avail_save_wording)))
                {
                  this.Vid.setVisibility(0);
                  this.VhU.setText(this.Vbu.field_avail_save_wording);
                  this.VhU.setVisibility(0);
                  if (findViewById(a.f.lqt_balance_bankcard_click_layout) != null) {
                    findViewById(a.f.lqt_balance_bankcard_click_layout).sendAccessibilityEvent(128);
                  }
                }
                localObject1 = w.Vad;
                label1809:
                String str;
                if (this.mode == 1)
                {
                  paramBoolean = true;
                  localObject1 = ((w)localObject1).Hf(paramBoolean);
                  if (localObject1 == null) {
                    break label1140;
                  }
                  localObject3 = ((dke)localObject1).aaQh;
                  if ((this.Vbu == null) || (!this.Vbu.ihV()) || (localObject3 == null)) {
                    break label1140;
                  }
                  this.VhI.Vbj.mQ(0, 1);
                  this.Vig = true;
                  com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(25) });
                  str = ((aey)localObject3).ZmZ;
                  localObject1 = ((aey)localObject3).Zna;
                  Log.i("MicroMsg.WalletLqtSaveFetchUI", "tryShowSaveFromLqBubble, promptText: %s, jumpText: %s", new Object[] { str, localObject1 });
                  if (TextUtils.isEmpty(str)) {
                    break label2078;
                  }
                  i = 1;
                  label1937:
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label2083;
                  }
                }
                label2078:
                label2083:
                for (int j = 1;; j = 0)
                {
                  TextView localTextView = (TextView)this.VhW.findViewById(a.f.purchase_from_lq_prompt_tv);
                  localObject2 = (TextView)this.VhW.findViewById(a.f.purchase_from_lq_prompt_link_tv);
                  localTextView.setVisibility(4);
                  ((TextView)localObject2).setVisibility(4);
                  if ((i != 0) || (j != 0)) {
                    this.VhW.setVisibility(0);
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
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(316542);
                      com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(26) });
                      WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).Vbj.mQ(1, 0);
                      switch (this.ViI.jump_type)
                      {
                      }
                      for (;;)
                      {
                        AppMethodBeat.o(316542);
                        return;
                        WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, 1);
                        AppMethodBeat.o(316542);
                        return;
                        i.bC(WalletLqtSaveFetchUI.this.getContext(), this.ViI.jump_url);
                        AppMethodBeat.o(316542);
                        return;
                        i.y(this.ViI.VcU, this.ViI.jump_url, 0, 1000);
                      }
                    }
                  };
                  i.a((TextView)localObject2, (String)localObject1, 0, ((String)localObject1).length(), new com.tencent.mm.wallet_core.ui.f((f.a)localObject3), getContext());
                  break;
                  paramBoolean = false;
                  break label1809;
                  i = 0;
                  break label1937;
                }
                this.VhR.setVisibility(8);
                continue;
                label2100:
                if (this.mode != 2) {
                  continue;
                }
                findViewById(a.f.wallet_info_tip).setVisibility(8);
                this.Vik.setVisibility(8);
                this.VhR.setVisibility(8);
                this.VhQ.setVisibility(8);
                localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.z.ieB();
                if ((this.Vbu != null) && (this.Vbu.ihV()))
                {
                  i = getIntent().getIntExtra("lqt_balance", 0);
                  if (com.tencent.mm.platformtools.z.pDn) {
                    i = 50000000;
                  }
                  if (i <= 0) {
                    continue;
                  }
                  localObject1 = getString(a.i.wallet_lqt_fetch_remain_wording_1, new Object[] { Double.valueOf(nx(String.valueOf(i), "100")) });
                  j = ((String)localObject1).length();
                  localObject1 = new SpannableString((String)localObject1 + " " + getString(a.i.wallet_lqt_fetch_remain_wording_2));
                  ((SpannableString)localObject1).setSpan(new com.tencent.mm.wallet_core.ui.f(new f.a()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(316506);
                      WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).setText(i.formatMoney2f(WalletLqtSaveFetchUI.nz(i, "100")));
                      WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                      WalletLqtSaveFetchUI.this.showWcKb();
                      AppMethodBeat.o(316506);
                    }
                  }), j, ((SpannableString)localObject1).length(), 18);
                  this.Vio = ((CharSequence)localObject1);
                  as((CharSequence)localObject1);
                  continue;
                }
                if (((com.tencent.mm.plugin.wallet.balance.model.lqt.z)localObject1).ieC() == null) {}
                for (i = 0;; i = ((com.tencent.mm.plugin.wallet.balance.model.lqt.z)localObject1).ieC().ftr)
                {
                  if (((com.tencent.mm.plugin.wallet.balance.model.lqt.z)localObject1).ieC() != null) {
                    ((com.tencent.mm.plugin.wallet.balance.model.lqt.z)localObject1).ieC();
                  }
                  if (com.tencent.mm.platformtools.z.pDn) {
                    i = 100000000;
                  }
                  localObject1 = getString(a.i.wallet_lqt_balance_remain_wording_normal, new Object[] { Double.valueOf(nx(String.valueOf(i), "100")) });
                  this.Vio = ((CharSequence)localObject1);
                  as((CharSequence)localObject1);
                  break;
                }
              }
              this.VhN.setVisibility(8);
              this.hintTextColor = getResources().getColor(a.c.FG_1);
            }
            AppMethodBeat.o(69015);
            return;
          }
          as("");
          this.VhN.setVisibility(8);
        }
      }
      AppMethodBeat.o(69015);
      return;
      label2457:
      paramBoolean = false;
      bool = false;
    }
  }
  
  private void Ho(boolean paramBoolean)
  {
    AppMethodBeat.i(69022);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "check enable: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Viz) });
    if ((!paramBoolean) || (this.Viz))
    {
      hH(false);
      AppMethodBeat.o(69022);
      return;
    }
    if (this.mode == 1)
    {
      if (this.VhR.getVisibility() == 0)
      {
        if ((this.VhT.isChecked()) && (this.Viw))
        {
          hH(true);
          AppMethodBeat.o(69022);
          return;
        }
        hH(false);
        AppMethodBeat.o(69022);
        return;
      }
      if (this.Viw)
      {
        hH(true);
        AppMethodBeat.o(69022);
      }
    }
    else
    {
      if ((this.Viw) && ((this.Vih.getSelectRedeemType() != null) || (this.Vih.getRedeemTypeList() == null) || (this.Vih.getRedeemTypeList().isEmpty())))
      {
        if (this.Vih.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.Vih.getSelectRedeemType().ablG))
        {
          Log.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          hH(true);
          AppMethodBeat.o(69022);
          return;
        }
      }
      hH(false);
    }
    AppMethodBeat.o(69022);
  }
  
  private static int a(v paramv)
  {
    if ((paramv == null) || (paramv.UZK == null)) {}
    do
    {
      return 0;
      paramv = paramv.UZK;
    } while ((paramv.abkF == null) && (paramv.abkG == null));
    if ((paramv.abkF != null) && (paramv.abkG != null)) {
      return 1;
    }
    return 2;
  }
  
  private j a(final v paramv1, final v paramv2, v paramv3)
  {
    AppMethodBeat.i(316586);
    if ((paramv2 == null) || (paramv2.UZK == null))
    {
      AppMethodBeat.o(316586);
      return null;
    }
    final efh localefh = paramv2.UZK;
    int j = 3;
    int i = j;
    if (localefh.abkD == 0)
    {
      i = j;
      if (TextUtils.isEmpty(localefh.title)) {
        i = 0;
      }
    }
    j = a(paramv2);
    final j localj = new j(getContext(), j, i);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i == 3)
    {
      if (localefh.abkD == 0)
      {
        localObject1 = new LinearLayout(this);
        ((LinearLayout)localObject1).setPadding(com.tencent.mm.cd.a.bs(this, a.d.Edge_3A), com.tencent.mm.cd.a.bs(this, a.d.Edge_5A), com.tencent.mm.cd.a.bs(this, a.d.Edge_3A), com.tencent.mm.cd.a.bs(this, a.d.Edge_A));
        ((LinearLayout)localObject1).setOrientation(1);
        paramv1 = (v)localObject1;
        if (!TextUtils.isEmpty(localefh.title))
        {
          paramv1 = new TextView(this);
          ((LinearLayout)localObject1).addView(paramv1);
          paramv1.setGravity(3);
          localObject2 = new LinearLayout.LayoutParams(paramv1.getLayoutParams());
          ((LinearLayout.LayoutParams)localObject2).width = -1;
          ((LinearLayout.LayoutParams)localObject2).height = -2;
          ((LinearLayout.LayoutParams)localObject2).gravity = 3;
          paramv1.setTextSize(1, 17.0F);
          paramv1.setTextColor(getResources().getColor(a.c.black_text_color));
          aw.a(paramv1.getPaint(), 0.8F);
          paramv1.setText(localefh.title);
          paramv1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramv1 = (v)localObject1;
        }
        localj.mi(paramv1);
      }
    }
    else
    {
      localObject1 = localefh.abkE;
      if (localObject1 != null)
      {
        paramv1 = new LinearLayout(this);
        paramv1.setOrientation(1);
        if (!TextUtils.isEmpty(((aey)localObject1).ZmZ))
        {
          localObject2 = new TextView(this);
          paramv1.addView((View)localObject2);
          localObject3 = new LinearLayout.LayoutParams(((TextView)localObject2).getLayoutParams());
          ((LinearLayout.LayoutParams)localObject3).width = -1;
          ((LinearLayout.LayoutParams)localObject3).height = -2;
          if (!TextUtils.isEmpty(localefh.title)) {
            break label921;
          }
          ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cd.a.bs(this, a.d.Edge_5A);
          label375:
          ((TextView)localObject2).setTextColor(getResources().getColor(a.c.black_text_color));
          if ((localefh.abkD != 0) || (TextUtils.isEmpty(localefh.title))) {
            break label936;
          }
          ((TextView)localObject2).setTextSize(1, 15.0F);
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(((aey)localObject1).ZmZ);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      if (!TextUtils.isEmpty(((aey)localObject1).Zna))
      {
        localObject2 = new TextView(this);
        paramv1.addView((View)localObject2);
        localObject3 = new LinearLayout.LayoutParams(((TextView)localObject2).getLayoutParams());
        ((LinearLayout.LayoutParams)localObject3).width = -1;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cd.a.bs(this, a.d.Edge_A);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        aw.a(((TextView)localObject2).getPaint(), 0.8F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((TextView)localObject2).setText(((aey)localObject1).Zna);
        a((TextView)localObject2, false, (aey)localObject1, localj, paramv2, paramv3, paramv2.ybL);
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
      }
      localj.setCustomView(paramv1);
      if (j == 0)
      {
        paramv2 = new LinearLayout.LayoutParams(paramv1.getLayoutParams());
        paramv2.bottomMargin = com.tencent.mm.cd.a.bs(this, a.d.Edge_8A);
        paramv1.setLayoutParams(paramv2);
      }
      if (j == 2)
      {
        if (localefh.abkF != null) {
          localj.au(localefh.abkF.wording);
        }
        if (localefh.abkG != null) {
          localj.au(localefh.abkG.wording);
        }
        localj.aFe(1);
      }
      if (j == 1) {
        localj.d(localefh.abkF.wording, localefh.abkG.wording);
      }
      AppMethodBeat.o(316586);
      return localj;
      localObject1 = View.inflate(this, a.g.lqt_select_bankcard_header, null);
      localObject2 = (WeImageView)((View)localObject1).findViewById(a.f.lqt_header_close_icon_iv);
      ((WeImageView)localObject2).setContentDescription(getString(a.i.close_btn));
      localObject3 = (TextView)((View)localObject1).findViewById(a.f.lqt_select_bankcard_title);
      aw.a(((TextView)localObject3).getPaint(), 0.8F);
      TextView localTextView = (TextView)((View)localObject1).findViewById(a.f.lqt_select_bankcard_tip);
      if (localefh.abkD == 2)
      {
        ((WeImageView)localObject2).setImageResource(a.h.icons_outlined_back);
        ((WeImageView)localObject2).setIconColor(getResources().getColor(a.c.FG_0));
        ((WeImageView)localObject2).setContentDescription(getString(a.i.app_back));
      }
      ((WeImageView)localObject2).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(316398);
          localj.cyW();
          if (localefh.abkD == 2)
          {
            paramAnonymousView = WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, null, paramv1, paramv2);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramAnonymousView, paramv1);
            paramAnonymousView.dDn();
          }
          AppMethodBeat.o(316398);
        }
      });
      if (TextUtils.isEmpty(localefh.title)) {
        ((TextView)localObject3).setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localefh.desc)) {
          break label899;
        }
        localTextView.setVisibility(8);
        paramv1 = (v)localObject1;
        break;
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(localefh.title);
      }
      label899:
      localTextView.setVisibility(0);
      localTextView.setText(localefh.desc);
      paramv1 = (v)localObject1;
      break;
      label921:
      ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cd.a.bs(this, a.d.Edge_A);
      break label375;
      label936:
      ((TextView)localObject2).setTextSize(1, 17.0F);
      aw.a(((TextView)localObject2).getPaint(), 0.8F);
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, final aey paramaey, final j paramj, final v paramv1, final v paramv2, final int paramInt)
  {
    AppMethodBeat.i(316594);
    if (paramaey != null)
    {
      String str2 = "";
      String str1 = str2;
      if (paramBoolean)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramaey.ZmZ)) {
          str1 = paramaey.ZmZ;
        }
      }
      if (!TextUtils.isEmpty(paramaey.Zna))
      {
        int i = str1.length();
        str1 = str1 + paramaey.Zna;
        paramaey = new f.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(316496);
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "showCommonPromptText, scene: %s, promptInfo.jump_type: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramaey.jump_type) });
            if (paramInt >= 0) {
              com.tencent.mm.plugin.report.service.h.OAn.b(20287, new Object[] { Integer.valueOf(paramInt) });
            }
            switch (paramaey.jump_type)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(316496);
              return;
              paramAnonymousView = WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramv1, paramv2, null);
              WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramAnonymousView, paramv2);
              if (paramj != null) {
                paramj.cyW();
              }
              if ((paramAnonymousView != null) && (!paramAnonymousView.isShowing()))
              {
                paramAnonymousView.dDn();
                AppMethodBeat.o(316496);
                return;
                i.bC(WalletLqtSaveFetchUI.this.getContext(), paramaey.jump_url);
                AppMethodBeat.o(316496);
                return;
                i.y(paramaey.VcU, paramaey.jump_url, 0, 1000);
              }
            }
          }
        };
        i.a(paramTextView, str1, i, str1.length(), new com.tencent.mm.wallet_core.ui.f(paramaey), getContext());
        paramTextView.setVisibility(0);
        AppMethodBeat.o(316594);
        return;
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramTextView.setVisibility(0);
        paramTextView.setText(str1);
      }
    }
    AppMethodBeat.o(316594);
  }
  
  private void a(final j paramj, final v paramv)
  {
    AppMethodBeat.i(316563);
    if (paramj == null)
    {
      AppMethodBeat.o(316563);
      return;
    }
    int i = a(paramv);
    paramv = paramv.UZK;
    if (i == 2)
    {
      paramj.agfR = new j.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(316397);
          tj localtj2 = paramv.abkF;
          tj localtj1 = localtj2;
          if (localtj2 == null) {
            localtj1 = paramv.abkG;
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramj, localtj1);
          AppMethodBeat.o(316397);
        }
      };
      AppMethodBeat.o(316563);
      return;
    }
    if (i == 1) {
      paramj.a(new j.a()new j.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(316395);
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramj, paramv.abkF);
          AppMethodBeat.o(316395);
        }
      }, new j.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(316399);
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, paramj, paramv.abkG);
          AppMethodBeat.o(316399);
        }
      });
    }
    AppMethodBeat.o(316563);
  }
  
  private void a(final String paramString1, final String paramString2, final String paramString3, TextView paramTextView, final f.a parama)
  {
    AppMethodBeat.i(316620);
    if (paramString1 == null)
    {
      AppMethodBeat.o(316620);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (Util.isNullOrNil(paramString2))
    {
      paramTextView.setText(localStringBuilder.toString());
      AppMethodBeat.o(316620);
      return;
    }
    int i = localStringBuilder.length();
    localStringBuilder.append(paramString2);
    paramTextView.setText(localStringBuilder.toString());
    i.a(paramTextView, localStringBuilder.toString(), i, localStringBuilder.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(316484);
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "click link text: %s %s url:%s", new Object[] { paramString1, paramString2, paramString3 });
        if (parama != null) {
          parama.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(316484);
      }
    }), this);
    AppMethodBeat.o(316620);
  }
  
  private void aJ(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(69014);
    Log.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    jq localjq;
    if (this.mode == 2)
    {
      localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.z.ieB().ieC();
      if (!this.Vih.Vdx)
      {
        if (localObject == null)
        {
          Log.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
          AppMethodBeat.o(69014);
          return;
        }
        if (this.Vbu == null)
        {
          Log.w("MicroMsg.WalletLqtSaveFetchUI", "no mDefaultBankcard!");
          AppMethodBeat.o(69014);
          return;
        }
        if (this.Vbu.ihV())
        {
          Log.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
          this.Vih.M(((dwg)localObject).abcc, false);
          this.Vih.bfX(paramString);
        }
        for (;;)
        {
          this.Vih.setVisibility(4);
          ifB();
          AppMethodBeat.o(69014);
          return;
          if (((dwg)localObject).abcd != null)
          {
            localObject = ((dwg)localObject).abcd.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localjq = (jq)((Iterator)localObject).next();
              if (localjq.YLE.equals(this.Vbu.field_bindSerial))
              {
                Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                this.Vih.M(localjq.YLU, false);
                this.Vih.bfX(paramString);
              }
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (!this.Vbu.ihV()) {
          break label296;
        }
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
        this.Vih.M(((dwg)localObject).abcc, true);
      }
    }
    for (;;)
    {
      this.Vih.setVisibility(4);
      this.Vih.bfX(paramString);
      AppMethodBeat.o(69014);
      return;
      label296:
      if (((dwg)localObject).abcd != null)
      {
        localObject = ((dwg)localObject).abcd.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localjq = (jq)((Iterator)localObject).next();
          if (localjq.YLE.equals(this.Vbu.field_bindSerial))
          {
            Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
            this.Vih.M(localjq.YLU, true);
          }
        }
      }
    }
  }
  
  private void as(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(316503);
    this.VhP.setText(paramCharSequence);
    if (Util.isNullOrNil(paramCharSequence))
    {
      this.VhP.setVisibility(8);
      AppMethodBeat.o(316503);
      return;
    }
    this.VhP.setVisibility(0);
    AppMethodBeat.o(316503);
  }
  
  private void bge(String paramString)
  {
    AppMethodBeat.i(316497);
    String str = getString(a.i.wallet_lqt_fetch_back_card_network_exception);
    if (!Util.isNullOrNil(paramString)) {
      str = paramString;
    }
    paramString = getString(a.i.wallet_i_know_it);
    com.tencent.mm.ui.base.k.a(getContext(), str, "", paramString, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69003);
        WalletLqtSaveFetchUI.this.finish();
        AppMethodBeat.o(69003);
      }
    });
    AppMethodBeat.o(316497);
  }
  
  private boolean bgf(String paramString)
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
          localObject1 = new com.tencent.mm.ui.widget.a.e.a(getContext());
          ((com.tencent.mm.ui.widget.a.e.a)localObject1).NC(false);
          ((com.tencent.mm.ui.widget.a.e.a)localObject1).bDw(paramString);
          ((com.tencent.mm.ui.widget.a.e.a)localObject1).bDD(str1);
          ((com.tencent.mm.ui.widget.a.e.a)localObject1).bDC(str2);
          ((com.tencent.mm.ui.widget.a.e.a)localObject1).a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(316529);
              i.p(WalletLqtSaveFetchUI.this.getContext(), this.Vjo, false);
              AppMethodBeat.o(316529);
            }
          });
          ((com.tencent.mm.ui.widget.a.e.a)localObject1).jHH().show();
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
  
  private static ArrayList<String> cd(LinkedList<aku> paramLinkedList)
  {
    AppMethodBeat.i(316514);
    ArrayList localArrayList = new ArrayList();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        aku localaku = (aku)paramLinkedList.next();
        if ((!Util.isNullOrNil(localaku.title)) && (!Util.isNullOrNil(localaku.Krl))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localaku.title, localaku.Krl }));
        }
      }
    }
    AppMethodBeat.o(316514);
    return localArrayList;
  }
  
  private void dy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182506);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", new Object[] { paramString });
    long l1 = i.qy(String.valueOf(paramString), "100");
    Object localObject1;
    int m;
    Object localObject2;
    int j;
    label661:
    label668:
    int k;
    if (l1 > 0L)
    {
      if (this.mode == 1) {
        if (this.Vbu != null) {
          if (this.Vbu.ihV()) {
            if ((this.Vip != null) && (l1 > ny(this.Vip.VDo, "100")))
            {
              as(getString(a.i.wallet_lqt_save_balance_not_enough_hint));
              this.VhP.setTextColor(getResources().getColor(a.c.Red_100));
              this.VhP.announceForAccessibility(getContext().getString(a.i.wallet_lqt_save_balance_not_enough_hint));
              this.Viw = false;
              Ho(false);
            }
          }
        }
      }
      for (;;)
      {
        if (l1 <= 0L)
        {
          this.Viy = true;
          AppMethodBeat.o(182506);
          return;
          if ((w.Vad.UZV >= 0) && (l1 > w.Vad.UZV) && (!Util.isNullOrNil(w.Vad.UZS)) && (!Util.isNullOrNil(w.Vad.UZT)) && (!Util.isNullOrNil(w.Vad.UZU)))
          {
            paramString = new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
            {
              public final void eS(View paramAnonymousView)
              {
                AppMethodBeat.i(316394);
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                i.a(WalletLqtSaveFetchUI.this.getContext(), w.Vad.UZU, true, 1);
                AppMethodBeat.o(316394);
              }
            });
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(w.Vad.UZS);
            ((SpannableStringBuilder)localObject1).append(w.Vad.UZT);
            ((SpannableStringBuilder)localObject1).setSpan(paramString, w.Vad.UZS.length(), ((SpannableStringBuilder)localObject1).length(), 18);
            if ((this.VhP.getText() == null) || (!this.VhP.getText().equals(((SpannableStringBuilder)localObject1).toString()))) {
              com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(9) });
            }
            this.VhP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(getContext()));
            this.VhP.setClickable(true);
            as((CharSequence)localObject1);
            this.VhP.setTextColor(this.hintTextColor);
            this.Viw = false;
            Ho(false);
          }
          else
          {
            as(this.Vio);
            this.VhP.setTextColor(this.hintTextColor);
            this.Viw = true;
            Ho(true);
            continue;
            if ((this.Vbu.field_dayQuotaKind > 0.0D) && (l1 > ny(this.Vbu.field_dayQuotaKind, "100")))
            {
              as(getString(a.i.wallet_lqt_save_exceed_bankcard_limit));
              this.VhP.setTextColor(getResources().getColor(a.c.Red_100));
              this.VhP.announceForAccessibility(getContext().getString(a.i.wallet_lqt_save_exceed_bankcard_limit));
              this.Viw = false;
              Ho(false);
              com.tencent.mm.plugin.report.service.h.OAn.b(21467, new Object[] { this.Vbu.field_bankcardType, Long.valueOf(l1), Integer.valueOf(1), Double.valueOf(this.Vbu.field_dayQuotaKind) });
            }
            else
            {
              as("");
              this.Viw = true;
              Ho(true);
              continue;
              this.Viw = true;
              Ho(true);
              continue;
              if (this.mode == 2)
              {
                m = 0;
                localObject2 = com.tencent.mm.plugin.wallet.balance.model.lqt.z.ieB().ieC();
                if (localObject2 == null)
                {
                  j = 0;
                  if (localObject2 != null) {
                    break label794;
                  }
                  i = 0;
                  if ((this.Vbu == null) || (!this.Vbu.ihV())) {
                    break label1859;
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
          as(getString(a.i.wallet_lqt_fetch_balance_not_enough_hint));
          this.VhP.setTextColor(getResources().getColor(a.c.Red_100));
          this.VhP.announceForAccessibility(getContext().getString(a.i.wallet_lqt_fetch_balance_not_enough_hint));
          this.Viw = false;
          ifz();
          Ho(false);
          this.Vik.setVisibility(8);
          break;
          j = ((dwg)localObject2).ftr;
          break label661;
          label794:
          i = ((dwg)localObject2).abca;
          break label668;
        }
        as(this.Vio);
        this.VhP.setTextColor(this.hintTextColor);
        this.Viw = true;
        aJ(paramBoolean, paramString);
        Ho(true);
        this.Vik.setVisibility(8);
        break;
      }
      if (l1 > j)
      {
        as(getString(a.i.wallet_lqt_fetch_balance_not_enough_hint));
        this.VhP.setTextColor(getResources().getColor(a.c.Red_100));
        this.VhP.announceForAccessibility(getContext().getString(a.i.wallet_lqt_fetch_balance_not_enough_hint));
        this.Vik.setVisibility(8);
        this.Viw = false;
        ifz();
        Ho(false);
        this.Vik.setVisibility(8);
        break;
      }
      long l2;
      StringBuffer localStringBuffer;
      if (l1 > k)
      {
        l2 = i.qy(this.ViB, "100");
        if (l1 >= l2) {
          com.tencent.mm.plugin.report.service.h.OAn.b(20287, new Object[] { Integer.valueOf(9) });
        }
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "balance > lqtBalance, balance: %s, previousBalance: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        paramString = getString(a.i.wallet_lqt_balance_remain_wording_normal, new Object[] { Double.valueOf(nx(String.valueOf(j), "100")) });
        this.VhP.setTextColor(this.hintTextColor);
        as(paramString);
        if ((localObject2 != null) && ((!TextUtils.isEmpty(((dwg)localObject2).abcj)) || (((dwg)localObject2).abck != null)))
        {
          Log.i("MicroMsg.WalletLqtSaveFetchUI", "balance > lqtBalance, go to new redeem to bank exceed tips");
          localStringBuffer = new StringBuffer();
          if (!TextUtils.isEmpty(((dwg)localObject2).abcj))
          {
            this.Vik.setVisibility(0);
            paramString = ((dwg)localObject2).abcj;
          }
        }
      }
      try
      {
        localObject1 = String.format(paramString, new Object[] { i.formatMoney2f(nx(String.valueOf(k), "100")) });
        paramString = (String)localObject1;
      }
      catch (Exception localException2)
      {
        label1173:
        aey localaey;
        break label1173;
      }
      this.Vim.setText(paramString);
      this.Vim.setVisibility(0);
      localStringBuffer.append(this.Vim.getText().toString());
      localaey = ((dwg)localObject2).abck;
      if ((localaey != null) && (!TextUtils.isEmpty(localaey.ZmZ)))
      {
        paramString = localaey.ZmZ;
        l2 = k;
      }
      try
      {
        localObject1 = String.format(paramString, new Object[] { i.formatMoney2f(nx(String.valueOf(l1 - l2), "100")) });
        paramString = (String)localObject1;
      }
      catch (Exception localException1)
      {
        label1274:
        break label1274;
      }
      localObject1 = new aey();
      ((aey)localObject1).ZmZ = paramString;
      ((aey)localObject1).jump_type = localaey.jump_type;
      ((aey)localObject1).Zna = localaey.Zna;
      ((aey)localObject1).jump_url = localaey.jump_url;
      ((aey)localObject1).VcU = localaey.VcU;
      paramString = ((dwg)localObject2).abcl;
      localObject2 = new v.a();
      ((v.a)localObject2).UZK = paramString;
      paramString = ((v.a)localObject2).iev();
      a(this.Vil, true, (aey)localObject1, null, null, paramString, 10);
      localStringBuffer.append(this.Vil.getText().toString());
      if (!Util.isNullOrNil(localStringBuffer.toString())) {
        this.Vik.announceForAccessibility(localStringBuffer.toString());
      }
      for (;;)
      {
        this.Viw = false;
        ifz();
        Ho(false);
        break;
        this.Vik.setVisibility(0);
        paramString = getString(a.i.wallet_lqt_fetch_remain_strongly_wording, new Object[] { Double.valueOf(nx(String.valueOf(k), "100")) });
        i = paramString.length();
        paramString = paramString + getString(a.i.wallet_lqt_fetch_remain_wording_1_2_tail);
        i.a(this.Vil, paramString, i, paramString.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(316396);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, this.ViY);
            AppMethodBeat.o(316396);
          }
        }), getContext());
        this.Vim.setVisibility(8);
        this.Vik.announceForAccessibility(this.Vil.getText().toString());
      }
      if ((this.Vbu != null) && (!this.Vbu.ihV()) && (this.Vbu.field_dayQuotaKind > 0.0D) && (l1 > ny(this.Vbu.field_dayQuotaKind, "100")))
      {
        this.Vik.setVisibility(0);
        this.Vil.setText(getString(a.i.wallet_lqt_fetch_exceed_bankcard_limit, new Object[] { Double.valueOf(this.Vbu.field_dayQuotaKind) }));
        this.Vim.setVisibility(8);
        this.Vik.announceForAccessibility(this.Vil.getText().toString());
        this.Viw = false;
        ifz();
        Ho(false);
        break;
      }
      as(this.Vio);
      this.VhP.setTextColor(this.hintTextColor);
      this.Viw = true;
      aJ(paramBoolean, paramString);
      Ho(true);
      this.Vik.setVisibility(8);
      break;
      if (this.mode == 1) {
        if ((this.Vbu != null) && (this.Vbu.ihV())) {
          as(this.Vio);
        }
      }
      for (;;)
      {
        this.VhP.setTextColor(this.hintTextColor);
        this.Viw = false;
        Ho(false);
        break;
        as("");
        continue;
        as(this.Vio);
        ifz();
      }
      this.Viy = false;
      AppMethodBeat.o(182506);
      return;
      label1859:
      k = i;
    }
  }
  
  private void hD(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(316549);
    this.Kkr.clear();
    final com.tencent.mm.plugin.wallet.ui.a locala = new com.tencent.mm.plugin.wallet.ui.a(this);
    Object localObject1 = w.Vad;
    this.Vix = w.arI(this.mode);
    localObject1 = w.Vad;
    boolean bool;
    dke localdke;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localdke = ((w)localObject1).Hf(bool);
      localObject1 = null;
      if (this.Vbu != null) {
        localObject1 = this.Vbu.field_bindSerial;
      }
      localObject2 = localObject1;
      if (!Util.isNullOrNil((String)localObject1)) {
        break label762;
      }
      localObject2 = this.Viu;
      if (!Util.isNullOrNil(this.Viu)) {
        break label762;
      }
      com.tencent.mm.kernel.h.baF();
    }
    label137:
    label310:
    label620:
    label626:
    label762:
    for (localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVN, "");; localObject1 = localObject2)
    {
      int i = 0;
      if (i < this.Vix.size())
      {
        localObject2 = (Bankcard)this.Vix.get(i);
        if ((Util.isNullOrNil(((Bankcard)localObject2).field_bindSerial)) || (!((String)localObject1).equals(((Bankcard)localObject2).field_bindSerial))) {}
      }
      for (;;)
      {
        locala.Vtg = new u.g()
        {
          public final void onCreateMMMenu(final com.tencent.mm.ui.base.s paramAnonymouss)
          {
            AppMethodBeat.i(316552);
            int j = WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size();
            int i = 0;
            final Bankcard localBankcard;
            Object localObject1;
            if (i < j)
            {
              localBankcard = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(i);
              localObject1 = com.tencent.mm.plugin.wallet_core.d.b.j(WalletLqtSaveFetchUI.this, localBankcard.field_bankcardType, localBankcard.ihU());
              if (localObject1 == null) {
                break label741;
              }
            }
            label161:
            label600:
            label606:
            label741:
            for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).MpW;; str1 = "")
            {
              Bitmap localBitmap = r.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str1));
              r.a(new r.a()
              {
                public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
                {
                  AppMethodBeat.i(316512);
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(316466);
                      Log.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletLqtSaveFetchUI.5.1.this.MCv });
                      if ((WalletLqtSaveFetchUI.5.this.ViK.xcO.isShowing()) && (WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).containsKey(paramAnonymous2String)))
                      {
                        int i = ((Integer)WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).get(paramAnonymous2String)).intValue();
                        if ((i < WalletLqtSaveFetchUI.5.1.this.Kkz.size()) && (WalletLqtSaveFetchUI.5.1.this.Kkz.getItem(i) != null))
                        {
                          WalletLqtSaveFetchUI.5.1.this.Kkz.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymous2Bitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
                          WalletLqtSaveFetchUI.5.this.ViK.ihf();
                        }
                      }
                      AppMethodBeat.o(316466);
                    }
                  });
                  AppMethodBeat.o(316512);
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
                        ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
                        {
                          public final void eS(View paramAnonymous2View)
                          {
                            AppMethodBeat.i(316511);
                            i.bC(WalletLqtSaveFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                            com.tencent.mm.plugin.report.service.h.OAn.b(20216, new Object[] { Integer.valueOf(2), localBankcard.field_prompt_info_jump_url });
                            AppMethodBeat.o(316511);
                          }
                        }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
                        localObject3 = localObject1;
                      }
                    }
                  }
                }
                str2 = localBankcard.field_desc;
                if (!localBankcard.ihV()) {
                  break label606;
                }
                localObject1 = str2;
                if (localBankcard.VDo >= 0.0D) {
                  localObject1 = str2 + WalletLqtSaveFetchUI.this.getString(a.i.wallet_balance_left, new Object[] { i.X(localBankcard.VDo) });
                }
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), localObject1, localObject3 });
                localDrawable = WalletLqtSaveFetchUI.this.getResources().getDrawable(a.e.wallet_balance_manager_logo_small);
                if (Util.isNullOrNil((String)localObject2)) {
                  break label600;
                }
              }
              for (boolean bool = true;; bool = false)
              {
                paramAnonymouss.a(i, (CharSequence)localObject1, (CharSequence)localObject3, localDrawable, 0, bool);
                localObject1 = localObject4;
                if (localObject1 == null) {
                  WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).put(str1, Integer.valueOf(i));
                }
                i += 1;
                break;
                localObject2 = (String)localObject1 + " ";
                localObject1 = new SpannableStringBuilder((String)localObject2 + localBankcard.field_forbid_title);
                localObject3 = new n(WalletLqtSaveFetchUI.this)
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(316508);
                    paramAnonymous2View = localBankcard.field_forbid_url;
                    Intent localIntent = new Intent();
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "go to url %s", new Object[] { paramAnonymous2View });
                    localIntent.putExtra("rawUrl", paramAnonymous2View);
                    localIntent.putExtra("geta8key_username", com.tencent.mm.model.z.bAM());
                    localIntent.putExtra("pay_channel", 1);
                    i.aS(WalletLqtSaveFetchUI.this.getContext(), localIntent);
                    AppMethodBeat.o(316508);
                  }
                };
                int k = ((String)localObject2).length();
                int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
                ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(WalletLqtSaveFetchUI.this.getResources().getColor(a.c.link_color)), k, m, 33);
                ((SpannableStringBuilder)localObject1).setSpan(localObject3, k, m, 33);
                break label161;
              }
              localObject1 = localDrawable;
              if (localBitmap != null) {
                localObject1 = BitmapUtil.extractThumbNail(localBitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
              }
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject3 });
              if (localObject1 == null)
              {
                localObject4 = null;
                if (Util.isNullOrNil((String)localObject2)) {
                  break label729;
                }
              }
              for (bool = true;; bool = false)
              {
                paramAnonymouss.a(i, str2, (CharSequence)localObject3, (Drawable)localObject4, 0, bool);
                break;
                localObject4 = new BitmapDrawable((Bitmap)localObject1);
                break label686;
              }
              AppMethodBeat.o(316552);
              return;
            }
          }
        };
        locala.a(new j.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(316537);
            if (locala == null)
            {
              AppMethodBeat.o(316537);
              return;
            }
            WalletLqtSaveFetchUI.arQ(paramInt);
            locala.xcO.cyW();
            if (locala.pym < WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size())
            {
              Bankcard localBankcard = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(locala.pym);
              WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, localBankcard.field_bindSerial);
              WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.this);
              if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
              {
                if ((!TextUtils.isEmpty(paramString)) && (!localBankcard.ihV()))
                {
                  WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).setText(paramString);
                  WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                  WalletLqtSaveFetchUI.this.showWcKb();
                  AppMethodBeat.o(316537);
                  return;
                }
                WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).gGd();
                AppMethodBeat.o(316537);
                return;
              }
              if ((WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this)) && (!localBankcard.ihV())) {
                WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
              }
              WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getText());
            }
            AppMethodBeat.o(316537);
          }
        });
        View localView = View.inflate(this, a.g.lqt_select_bankcard_header, null);
        localObject1 = (TextView)localView.findViewById(a.f.lqt_select_bankcard_title);
        localObject2 = (TextView)localView.findViewById(a.f.lqt_select_bankcard_tip);
        if ((localdke != null) && (!TextUtils.isEmpty(localdke.aaQi)))
        {
          ((TextView)localObject1).setText(localdke.aaQi);
          if (!TextUtils.isEmpty(localdke.aaQj))
          {
            ((TextView)localObject2).setText(localdke.aaQj);
            ((TextView)localObject2).setVisibility(0);
            aw.a(((TextView)localObject1).getPaint(), 0.8F);
            localView.findViewById(a.f.deviderline).setVisibility(0);
            localView.findViewById(a.f.lqt_header_close_icon_iv).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(316541);
                if (locala != null) {
                  locala.xcO.cyW();
                }
                AppMethodBeat.o(316541);
              }
            });
            localView.findViewById(a.f.lqt_header_close_icon_iv).setContentDescription(getString(a.i.wallet_accessibility_close_btn));
            paramString = w.Vad;
            if (this.mode != 1) {
              break label620;
            }
            bool = true;
            paramString.Hi(bool);
            if (!bool) {
              break label626;
            }
            paramString = paramString.UZL;
            if (paramString == null) {
              break label634;
            }
          }
        }
        label634:
        for (bool = paramString.aaPZ;; bool = false)
        {
          if (!bool) {
            break label640;
          }
          Log.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
          locala.Vtn = true;
          locala.au(getResources().getString(a.i.wallet_dialog_confirm));
          locala.pym = i;
          locala.Vto = true;
          locala.setTitleView(localView);
          locala.dDn();
          paramString = (LinearLayout)localView.findViewById(a.f.lqt_bank_header_text_layout);
          paramString.setFocusable(true);
          paramString.setContentDescription(((TextView)localObject1).getText().toString() + ((TextView)localObject2).getText().toString());
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(316535);
              if (paramString != null) {
                paramString.sendAccessibilityEvent(8);
              }
              AppMethodBeat.o(316535);
            }
          }, 500L);
          AppMethodBeat.o(316549);
          return;
          bool = false;
          break;
          i += 1;
          break label137;
          ((TextView)localObject2).setVisibility(8);
          break label310;
          if (this.mode == 1)
          {
            ((TextView)localObject1).setText(a.i.wallet_lqt_save_alert_title);
            ((TextView)localObject2).setText(a.i.wallet_lqt_save_alert_tip);
            break label310;
          }
          ((TextView)localObject1).setText(a.i.wallet_lqt_fetch_alert_title);
          ((TextView)localObject2).setText(a.i.wallet_lqt_fetch_alert_tip);
          break label310;
          bool = false;
          break label387;
          paramString = paramString.UZM;
          break label403;
        }
        paramString = new com.tencent.mm.ui.base.s(this);
        if (this.mode == 1) {
          paramString.a(0, getString(a.i.wallet_lqt_save_new_card), null, getResources().getDrawable(a.h.icons_outlined_pay_cards), getResources().getColor(a.c.FG_2), false);
        }
        for (;;)
        {
          locala.a(paramString, new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(316540);
              if (locala == null)
              {
                AppMethodBeat.o(316540);
                return;
              }
              locala.xcO.cyW();
              if ((WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1) || (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)) {
                WalletLqtSaveFetchUI.p(WalletLqtSaveFetchUI.this);
              }
              AppMethodBeat.o(316540);
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
  
  private void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(69021);
    this.mWcKeyboard.Oi(paramBoolean);
    AppMethodBeat.o(69021);
  }
  
  private List<Bankcard> ifA()
  {
    AppMethodBeat.i(69016);
    Object localObject1 = w.Vad;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((w)localObject1).Hg(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.model.p.ifO();
        localObject1 = com.tencent.mm.plugin.wallet.model.p.ifP().ijG();
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
        if (localBankcard.ihV())
        {
          com.tencent.mm.plugin.wallet.model.p.ifO();
          if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijh())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.ihV()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.ihV()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label200:
    AppMethodBeat.o(69016);
    return localObject2;
  }
  
  private void ifB()
  {
    AppMethodBeat.i(69019);
    this.Vii.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316387);
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        WalletLqtSaveFetchUI.this.findViewById(a.f.lqt_save_hint).getLocationInWindow(arrayOfInt1);
        WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this).getLocationInWindow(arrayOfInt2);
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
        WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
        AppMethodBeat.o(316387);
      }
    }, 100L);
    AppMethodBeat.o(69019);
  }
  
  private void ifC()
  {
    AppMethodBeat.i(316557);
    if (this.mWW != null) {
      this.mWW.onClick(null);
    }
    AppMethodBeat.o(316557);
  }
  
  private dwc ifw()
  {
    AppMethodBeat.i(316490);
    int i = getIntent().getIntExtra("entrance_type", 0);
    Object localObject = w.Vad;
    localObject = w.arH(i);
    AppMethodBeat.o(316490);
    return localObject;
  }
  
  private void ify()
  {
    AppMethodBeat.i(316510);
    if (this.mode == 1)
    {
      localObject = ifw();
      if (localObject == null)
      {
        AppMethodBeat.o(316510);
        return;
      }
      localObject = ((dwc)localObject).abbX;
    }
    for (final int i = 1;; i = 2)
    {
      this.Vic.removeAllViews();
      if ((localObject != null) && (((LinkedList)localObject).size() > 0)) {
        break;
      }
      AppMethodBeat.o(316510);
      return;
      localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.z.ieB().ieC();
      if (localObject == null)
      {
        AppMethodBeat.o(316510);
        return;
      }
      localObject = ((dwg)localObject).abbX;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 8);
    Object localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      final aey localaey = (aey)((Iterator)localObject).next();
      float f2 = com.tencent.mm.cd.a.getScaleSize(this);
      float f1;
      if (!aw.bc(f2, com.tencent.mm.cd.a.mi(this)))
      {
        f1 = f2;
        if (!aw.bc(f2, com.tencent.mm.cd.a.mj(this))) {}
      }
      else
      {
        f1 = com.tencent.mm.cd.a.mh(this);
      }
      TextView localTextView = new TextView(this);
      localTextView.setTextSize(0, com.tencent.mm.cd.a.fromDPToPix(this, f1 * 14.0F));
      localTextView.setTextColor(com.tencent.mm.cd.a.w(this, a.c.FG_1));
      this.Vic.addView(localTextView, localLayoutParams);
      a(localaey.ZmZ, localaey.Zna, localaey.jump_url, localTextView, new f.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(316505);
          switch (localaey.jump_type)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(316505);
            return;
            i.bC(WalletLqtSaveFetchUI.this.getContext(), localaey.jump_url);
            AppMethodBeat.o(316505);
            return;
            i.y(localaey.VcU, localaey.jump_url, 0, 1000);
            AppMethodBeat.o(316505);
            return;
            new com.tencent.mm.plugin.wallet.balance.model.lqt.g(i.qy(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this), "100"), i).bFJ().b(new WalletLqtSaveFetchUI.47.1(this));
          }
        }
      });
    }
    AppMethodBeat.o(316510);
  }
  
  private void ifz()
  {
    AppMethodBeat.i(69013);
    WalletLqtArriveTimeLayout localWalletLqtArriveTimeLayout = this.Vih;
    localWalletLqtArriveTimeLayout.Vdx = false;
    if (localWalletLqtArriveTimeLayout.Vdt != null) {
      localWalletLqtArriveTimeLayout.Vdt.clear();
    }
    localWalletLqtArriveTimeLayout.Vdv = null;
    localWalletLqtArriveTimeLayout.Vdu.clear();
    localWalletLqtArriveTimeLayout.setVisibility(4);
    AppMethodBeat.o(69013);
  }
  
  private static double nx(String paramString1, String paramString2)
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
  
  private static int ny(String paramString1, String paramString2)
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
  
  public final void Hp(boolean paramBoolean)
  {
    this.Vcb = paramBoolean;
  }
  
  public final void bQa()
  {
    AppMethodBeat.i(69029);
    if (this.pIQ != null) {
      this.pIQ.dismiss();
    }
    AppMethodBeat.o(69029);
  }
  
  public final void cY(float paramFloat) {}
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(316813);
    if ((paramInt == 1) && (this.mWW != null)) {
      this.mWW.onClick(null);
    }
    AppMethodBeat.o(316813);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_lqt_save_ui;
  }
  
  public final void ifD()
  {
    AppMethodBeat.i(69031);
    MMHandlerThread.removeRunnable(this.pJs);
    MMHandlerThread.removeRunnable(this.Vcc);
    AppMethodBeat.o(69031);
  }
  
  public final void ifx()
  {
    AppMethodBeat.i(69012);
    Object localObject;
    int i;
    if (this.mode == 1)
    {
      this.Vip = w.Vad.iew();
      if (this.Vip == null)
      {
        com.tencent.mm.plugin.wallet.model.p.ifO();
        this.Vip = com.tencent.mm.plugin.wallet.model.p.ifP().VcF;
      }
      if (this.Vip != null)
      {
        localObject = w.Vad.iex();
        i = w.Vad.iey();
        if (i != 0) {
          break label224;
        }
        this.Vio = ((CharSequence)localObject);
        if (this.VhP != null) {
          as(this.Vio);
        }
      }
      if (this.VhJ != null) {
        this.VhJ.setVisibility(0);
      }
      localObject = ifw();
      if (localObject != null)
      {
        if (!Util.isNullOrNil(((dwc)localObject).abbW))
        {
          this.Vij.setText(((dwc)localObject).abbW);
          this.Vij.setVisibility(0);
          label143:
          if (Util.isNullOrNil(((dwc)localObject).UZW)) {
            break label342;
          }
          this.KAm.setText(((dwc)localObject).UZW);
          this.KAm.setVisibility(0);
        }
      }
      else
      {
        label172:
        localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.z.ieB().ieC();
        if ((localObject != null) && (((dwg)localObject).aaLz) && (((dwg)localObject).abce != null)) {
          aj.a(getContext(), ((dwg)localObject).abce);
        }
        Hn(true);
      }
    }
    for (;;)
    {
      ify();
      AppMethodBeat.o(69012);
      return;
      label224:
      if (i == 1)
      {
        i = ((String)localObject).length();
        localObject = new SpannableString((String)localObject + getString(a.i.wallet_lqt_balance_remain_wording_2));
        ((SpannableString)localObject).setSpan(new com.tencent.mm.wallet_core.ui.f(new f.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(316533);
            WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).setText(i.formatMoney2f(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).VDo));
            WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
            WalletLqtSaveFetchUI.this.showWcKb();
            AppMethodBeat.o(316533);
          }
        }), i + 1, ((SpannableString)localObject).length(), 18);
        this.Vio = ((CharSequence)localObject);
        break;
      }
      Log.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", new Object[] { Integer.valueOf(i) });
      this.Vio = ((CharSequence)localObject);
      break;
      this.Vij.setVisibility(8);
      break label143;
      label342:
      this.KAm.setVisibility(8);
      break label172;
      if (this.Vih.Vdx) {
        Hn(false);
      } else {
        Hn(true);
      }
    }
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(69026);
    Log.d("MicroMsg.WalletLqtSaveFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.Vcb), Boolean.valueOf(this.mWcKeyboard.jOo()) });
    if ((!this.Vcb) && (this.mWcKeyboard.jOo()))
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
      this.VhI.Vbi.mR(this.mode, this.VaW).f(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(69027);
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra(ag.VaO, this.Viu);
    }
    ag localag = this.VhH;
    String str1;
    if ((paramInt1 == ag.VaM) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra(ag.VaO);
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.VGX != null) && (paramIntent.VGX.size() > 0))
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(localag.hashCode()), Integer.valueOf(localag.VaW), paramIntent.hAT });
        localag.hAU = ((Orders.Commodity)paramIntent.VGX.get(0)).hAU;
        paramIntent = (String)localag.VaZ.get(paramIntent.hAT);
        if (!Util.isNullOrNil(paramIntent)) {
          localag.VaS = paramIntent;
        }
        if ((localag.VaR instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)localag.VaR).Vcb = true;
          ((WalletLqtSaveFetchUI)localag.VaR).ifD();
        }
        localag.hC(str1, 0);
      }
      AppMethodBeat.o(69027);
      return;
    }
    if ((paramInt1 == ag.VaN) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra(ag.VaO);
      String str2 = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
      paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
      Log.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localag.hashCode()), Integer.valueOf(localag.VaW), paramIntent });
      if ((localag.VaR instanceof WalletLqtSaveFetchUI))
      {
        ((WalletLqtSaveFetchUI)localag.VaR).Vcb = true;
        ((WalletLqtSaveFetchUI)localag.VaR).ifD();
      }
      Log.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localag.hashCode()), paramIntent });
      if (Util.isNullOrNil(localag.VaV))
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localag.hashCode()), paramIntent });
        localag.VaV = paramIntent;
      }
      paramIntent = localag.VaR.getIntent().getStringExtra("operate_id");
      localag.VaR.showLoading(true);
      af.c localc = localag.VaQ.VaJ;
      com.tencent.mm.vending.g.g.b(Integer.valueOf(localag.VaU), str2, localag.VaV, Integer.valueOf(localag.VaW), paramIntent).c(localc).f(new ag.2(localag, str1)).a(new ag.13(localag));
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
    this.VeS = new a(this);
    this.VhK = ((WalletFormView)findViewById(a.f.lqt_save_form));
    this.VhO = ((ImageView)findViewById(a.f.bankcard_logo_iv));
    this.VhP = ((TextView)findViewById(a.f.lqt_save_balance_hint));
    this.VhQ = ((TextView)findViewById(a.f.lqt_save_balance_hint2));
    this.VhL = ((TextView)findViewById(a.f.lqt_save_hint));
    this.VhM = ((TextView)findViewById(a.f.lqt_balance_bankcard));
    aw.a(this.VhM.getPaint(), 0.8F);
    this.Vif = ((TextView)findViewById(a.f.wallet_title));
    this.KAm = ((TextView)findViewById(a.f.lqt_save_tips_tv));
    this.Vij = ((TextView)findViewById(a.f.lqt_bottom_tips_wording_tv));
    this.Vin = ((TextView)findViewById(a.f.lqt_save_fetch_alert_tv));
    this.VhR = ((ViewGroup)findViewById(a.f.lqt_save_protocal_layout));
    this.VhS = ((TextView)findViewById(a.f.lqt_save_protocol_link_tv));
    this.VhT = ((CheckBox)findViewById(a.f.lqt_save_protocol_agree_checkbox));
    this.VhJ = ((ViewGroup)findViewById(a.f.main_content));
    this.VhU = ((TextView)findViewById(a.f.hint_1));
    this.VhV = ((TextView)findViewById(a.f.hint_2));
    this.VhW = ((LinearLayout)findViewById(a.f.purchase_from_lq_prompt_ll));
    this.VhX = ((LinearLayout)findViewById(a.f.lqt_bank_card_load_ll));
    this.VhY = ((LinearLayout)findViewById(a.f.lqt_bank_card_content_ll));
    this.VhZ = ((TextView)findViewById(a.f.lqt_bank_card_desc_text));
    this.Via = ((LinearLayout)findViewById(a.f.lqt_balance_load_ll));
    this.Vib = ((LinearLayout)findViewById(a.f.lqt_balance_show_detail_ll));
    this.Vic = ((LinearLayout)findViewById(a.f.lqt_hint_below_amount_ll));
    this.Vie = ((TextView)findViewById(a.f.lqt_balance_load_desc_text));
    this.VhN = ((TextView)findViewById(a.f.balance_tips_tv));
    this.Vih = ((WalletLqtArriveTimeLayout)findViewById(a.f.lqt_save_arrive_time_layout));
    this.Vii = ((ScrollView)findViewById(a.f.lqt_root_view));
    this.Vik = ((LinearLayout)findViewById(a.f.lqt_fetch_strongly_remind_layout));
    this.Vil = ((TextView)findViewById(a.f.lqt_fetch_strongly_tip));
    this.Vim = ((TextView)findViewById(a.f.lqt_fetch_strongly_tip2));
    this.Vid = ((LinearLayout)findViewById(a.f.hint_linear_layout));
    aw.a(this.Vim.getPaint(), 0.8F);
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    int i = getIntent().getIntExtra("entrance_type", 0);
    this.VhH.mode = this.mode;
    this.VhH.VaY = i;
    this.Viq = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.Vir = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.Vis = getIntent().getStringExtra("lqt_profile_wording");
    this.VaW = getIntent().getIntExtra("lqt_account_type", 0);
    if (aw.isDarkMode()) {
      this.VhW.setBackground(getResources().getDrawable(a.e.lqt_purchase_from_lq_prompt_night_bg));
    }
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.h.baF();
      this.Viu = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVO, ""));
      if (Util.isNullOrNil(this.Viu))
      {
        com.tencent.mm.kernel.h.baF();
        this.Viu = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVN, ""));
      }
      this.Viv = getIntent().getStringExtra("card_serial");
      this.VhX.setVisibility(8);
      this.VhY.setVisibility(0);
      this.Via.setVisibility(8);
      this.Vib.setVisibility(0);
    }
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.VaW), Integer.valueOf(this.mode), this.Viu });
    this.VhK.getTitleTv().setText(ai.jOX());
    this.mWcKeyboard = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    paramBundle = (RelativeLayout.LayoutParams)this.mWcKeyboard.getLayoutParams();
    paramBundle.addRule(12);
    this.mWcKeyboard.setLayoutParams(paramBundle);
    label978:
    int j;
    if (this.mode == 1)
    {
      setWPKeyboard(this.VhK.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(a.i.wallet_lqt_save_wording));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.wallet.a.b)com.tencent.mm.ui.component.k.d(getContext()).q(com.tencent.mm.plugin.wallet.a.b.class)).setValue("keyboard_title_key", getString(a.i.wallet_lqt_save_wording));
      if (d.rd(27)) {
        this.VhK.jPE();
      }
      setWcKbHeightListener(this);
      if (this.mode != 1) {
        break label1594;
      }
      this.VhL.setText(getString(a.i.wallet_lqt_save_amount_hint));
      this.Vif.setText(getString(a.i.wallet_lqt_save_hint_bank_card_wording));
      this.VhK.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(316377);
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          String str = paramAnonymousEditable.toString();
          int i = str.indexOf(".");
          int j = str.length();
          if ((i >= 0) && (j - i > 3)) {
            WalletFormView.a(WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getContentEt(), str, i + 3, j);
          }
          for (;;)
          {
            paramAnonymousEditable = paramAnonymousEditable.toString();
            WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, paramAnonymousEditable);
            WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this, paramAnonymousEditable);
            if (!Util.isNullOrNil(paramAnonymousEditable)) {
              break;
            }
            WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).setVisibility(8);
            AppMethodBeat.o(316377);
            return;
            if (i > 12) {
              WalletFormView.a(WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getContentEt(), str, 12, i);
            } else if ((i == -1) && (j > 12)) {
              WalletFormView.a(WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getContentEt(), str, 12, j);
            }
          }
          WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).setVisibility(0);
          AppMethodBeat.o(316377);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(316362);
          if (paramAnonymousBoolean)
          {
            if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
            {
              WalletLqtSaveFetchUI.t(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(316362);
              return;
            }
            if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1) {
              AppMethodBeat.o(316362);
            }
          }
          else
          {
            WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this).scrollTo(0, 0);
            if ((WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2) && (Util.isNullOrNil(WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getText()))) {
              WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(316362);
        }
      });
      this.VhK.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(316364);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
            if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2)
            {
              WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this);
              com.tencent.mm.plugin.report.service.h.OAn.b(20287, new Object[] { Integer.valueOf(2) });
            }
            for (;;)
            {
              AppMethodBeat.o(316364);
              return true;
              WalletLqtSaveFetchUI.x(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(316364);
          return true;
        }
      });
      if (!Util.isNullOrNil(this.Vis)) {
        this.mWcKeyboard.setTipText(this.Vis);
      }
      if (this.mode == 2) {
        this.Vih.setCallback(new WalletLqtArriveTimeLayout.a()
        {
          public final void ieZ()
          {
            AppMethodBeat.i(316367);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, true);
            AppMethodBeat.o(316367);
          }
        });
      }
      j = this.Vif.getWidth();
      Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveFetchHintWordingTv width: %d", new Object[] { Integer.valueOf(j) });
      if (j > 0) {
        break label1633;
      }
      this.Vif.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(316402);
          int i = WalletLqtSaveFetchUI.y(WalletLqtSaveFetchUI.this).getWidth();
          Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveFetchHintWordingTv trueWidth: %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0)
          {
            AppMethodBeat.o(316402);
            return;
          }
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletLqtSaveFetchUI.z(WalletLqtSaveFetchUI.this).getLayoutParams();
          if (localLayoutParams != null) {
            localLayoutParams.leftMargin = i;
          }
          WalletLqtSaveFetchUI.z(WalletLqtSaveFetchUI.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(316402);
        }
      });
      label1118:
      as("");
      this.VhP.setClickable(true);
      this.VhP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
      Ho(false);
      this.Vil.setClickable(true);
      this.Vil.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
      this.Vim.setClickable(true);
      this.Vim.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
      if (this.mode != 1) {
        break label1675;
      }
      this.VhJ.setVisibility(4);
      if (i != 8) {
        break label1665;
      }
      setMMTitle(a.i.wallet_lqt_save_title);
    }
    for (;;)
    {
      if (this.VhM.findViewById(a.f.wallet_tips_msg) != null) {
        this.VhM.findViewById(a.f.wallet_tips_msg).setVisibility(8);
      }
      paramBundle = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(316525);
          WalletLqtSaveFetchUI.this.hideTenpayKB();
          int i = -1;
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 1)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(28) });
            i = 2;
          }
          if (WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this) == 2) {
            com.tencent.mm.plugin.report.service.h.OAn.b(20287, new Object[] { Integer.valueOf(3) });
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, i);
          if (WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this)) {
            WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).Vbj.mQ(1, 0);
          }
          AppMethodBeat.o(316525);
        }
      };
      this.VhM.setOnClickListener(paramBundle);
      if (findViewById(a.f.lqt_balance_bankcard_click_layout) != null) {
        findViewById(a.f.lqt_balance_bankcard_click_layout).setOnClickListener(paramBundle);
      }
      paramBundle = w.Vad;
      Object localObject = this.ViF;
      paramBundle.Vac.add(localObject);
      ifx();
      this.VhJ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(68982);
          WalletLqtSaveFetchUI.this.handleKeyboardTouchEvent(paramAnonymousMotionEvent);
          AppMethodBeat.o(68982);
          return false;
        }
      });
      this.state = 1;
      paramBundle = getIntent().getStringExtra("fill_money");
      if (Util.getDouble(paramBundle, 0.0D) > 0.0D)
      {
        this.VhK.setText(paramBundle);
        dy(paramBundle, false);
      }
      paramBundle = this.VhK.getContentEt();
      localObject = this.VhK.getTitleTv();
      float f2 = com.tencent.mm.cd.a.getScaleSize(this);
      float f3 = com.tencent.mm.ce.c.iRs();
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
      setWPKeyboard(this.VhK.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(a.i.wallet_lqt_fetch_wording));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.wallet.a.b)com.tencent.mm.ui.component.k.d(getContext()).q(com.tencent.mm.plugin.wallet.a.b.class)).setValue("keyboard_title_key", getString(a.i.wallet_lqt_fetch_wording));
      break;
      label1594:
      if (this.mode != 2) {
        break label978;
      }
      this.VhL.setText(getString(a.i.wallet_lqt_fetch_amount_hint));
      this.Vif.setText(getString(a.i.wallet_lqt_fetch_hint_bank_card_wording));
      break label978;
      label1633:
      paramBundle = (LinearLayout.LayoutParams)this.Vid.getLayoutParams();
      if (paramBundle != null) {
        paramBundle.leftMargin = j;
      }
      this.Vid.setLayoutParams(paramBundle);
      break label1118;
      label1665:
      setMMTitle(a.i.wallet_lqt_save_wording);
      continue;
      label1675:
      setMMTitle(a.i.wallet_lqt_fetch_wording);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69030);
    super.onDestroy();
    ifD();
    w localw = w.Vad;
    w.a locala = this.ViF;
    localw.Vac.remove(locala);
    w.Vad.UZM = null;
    this.VhH = null;
    this.VhI = null;
    AppMethodBeat.o(69030);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(69025);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
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
    paramIntent = ifA();
    this.VhI.Vbi.mR(this.mode, this.VaW).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(69017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69024);
    super.onPause();
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onPause()");
    this.VeY.dead();
    if (!this.mWcKeyboard.jOn()) {
      this.state = 3;
    }
    AppMethodBeat.o(69024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69023);
    super.onResume();
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onResume()");
    this.VeY.alive();
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.Vcc, 300L);
    }
    this.state = 2;
    if (this.ViA)
    {
      this.ViA = false;
      acr localacr = new acr();
      localacr.igb.mode = this.mode;
      localacr.publish();
    }
    AppMethodBeat.o(69023);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(69028);
    ag localag = this.VhH;
    Log.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.ae))
    {
      com.tencent.mm.plugin.wallet.model.p.ifO();
      localag.VaX = com.tencent.mm.plugin.wallet.model.p.ifP().VcF;
      if (localag.pGe != null)
      {
        localag.pGe.K(new Object[] { paramp });
        localag.pGe.resume();
      }
    }
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
    ifx();
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    AppMethodBeat.o(69028);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(316801);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet.a.b.class);
    AppMethodBeat.o(316801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI
 * JD-Core Version:    0.7.0.1
 */