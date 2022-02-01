package com.tencent.mm.plugin.wallet.balance.ui;

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
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.d;
import com.tencent.mm.plugin.wallet.balance.model.d.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceFetchUI
  extends WalletBaseUI
  implements WcPayKeyboard.a, WalletFormView.a
{
  private static final String Onm;
  private int ARl;
  HashMap<String, Integer> ErL;
  private IListener<ma> GCj;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private ArrayList<Bankcard> OmN;
  private Bankcard OmO;
  private String OmP;
  private WalletFormView OmQ;
  private LinearLayout OmR;
  private View OmS;
  private TextView OmT;
  private TextView OmU;
  private TextView OmV;
  private TextView OmW;
  private ViewGroup OmX;
  private ViewGroup OmY;
  private int OmZ;
  private int Ona;
  private int Onb;
  private double Onc;
  private int Ond;
  private DecimalFormat One;
  private boolean Onf;
  private int Ong;
  private int Onh;
  private com.tencent.mm.plugin.wallet.balance.model.b Oni;
  private int Onj;
  com.tencent.mm.plugin.wallet.ui.a Onk;
  private Runnable Onl;
  protected boolean Onn;
  private Runnable Ono;
  private boolean Onp;
  private boolean Onq;
  private boolean Onr;
  private boolean Ons;
  private String fwv;
  private double mMC;
  public Runnable mMK;
  private View mrI;
  private String nYA;
  private int state;
  
  static
  {
    AppMethodBeat.i(224197);
    Onm = "http://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/product/wechatwallet_app.html?platform=15&scene_id=kf4";
    AppMethodBeat.o(224197);
  }
  
  public WalletBalanceFetchUI()
  {
    AppMethodBeat.i(68606);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.fwv = null;
    this.OmZ = 0;
    this.Ona = 0;
    this.Onb = 0;
    this.Onc = 0.0D;
    this.ARl = -1;
    this.Ond = 0;
    this.One = new DecimalFormat("0.00");
    this.Onf = false;
    this.Ong = 0;
    this.Onh = 0;
    this.Onj = MMApplicationContext.getContext().getResources().getColor(a.c.FG_1);
    this.Onl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68576);
        WalletBalanceFetchUI.a(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68576);
      }
    };
    this.state = 0;
    this.Onn = false;
    this.mMK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68600);
        if ((WalletBalanceFetchUI.n(WalletBalanceFetchUI.this) == 2) && (WalletBalanceFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletBalanceFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(68600);
      }
    };
    this.Ono = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(265767);
        WalletBalanceFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(265767);
      }
    };
    this.Onp = false;
    this.Onq = false;
    this.Onr = false;
    this.Ons = false;
    this.ErL = new HashMap();
    this.GCj = new IListener() {};
    AppMethodBeat.o(68606);
  }
  
  private double C(double paramDouble)
  {
    AppMethodBeat.i(68617);
    s.gGL();
    com.tencent.mm.plugin.wallet_core.model.ao localao = s.gGM();
    paramDouble = Math.max(com.tencent.mm.wallet_core.ui.g.b(paramDouble - localao.OUa.Ims, this.OmO.field_fetch_charge_rate, RoundingMode.HALF_UP), this.Onc);
    AppMethodBeat.o(68617);
    return paramDouble;
  }
  
  private void a(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(174434);
    Bundle localBundle = new Bundle();
    localBundle.putInt("payScene", 21);
    localBundle.putString("totalFee", com.tencent.mm.wallet_core.ui.g.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localBundle.putString("feeType", paramString1);
    localBundle.putString("bankType", paramString2);
    localBundle.putString("bindSerial", paramString3);
    localBundle.putString("operation", String.valueOf(paramInt));
    localBundle.putString("reportSessionId", this.nYA);
    Log.i("MicroMsg.WalletBalanceFetchUI", "startWalletBalanceFetchUseCase totalFee：%s reportSessionId %s", new Object[] { com.tencent.mm.wallet_core.ui.g.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString(), this.nYA });
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceFetchUseCase(this, localBundle);
    AppMethodBeat.o(174434);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(68618);
    if (!Util.isNullOrNil(this.fwv))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).fwv = this.fwv;
      ((PayInfo)localObject).fOY = 21;
      getInput().putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).fwy = (paramd.Imy - paramd.Imo);
      ((Orders)localObject).OQM = (paramd.Imy - paramd.Imo);
      ((Orders)localObject).ORd.add(new Orders.Commodity());
      ((Orders)localObject).Imo = paramd.Imo;
      getInput().putString("key_fetch_cashier_encode_str", paramd.OkM);
      getInput().putParcelable("key_orders", (Parcelable)localObject);
      getInput().putParcelable("key_bankcard", this.OmO);
      getInput().putString("key_fetch_cashier_desc", paramd.OkJ);
      getInput().putString("key_report_session_id", this.nYA);
      if (getProcess() == null)
      {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, getInput(), null);
        AppMethodBeat.o(68618);
        return;
      }
      getNetController().r(new Object[] { getInput() });
      AppMethodBeat.o(68618);
      return;
    }
    Log.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
    AppMethodBeat.o(68618);
  }
  
  private boolean b(d paramd)
  {
    boolean bool3 = false;
    AppMethodBeat.i(68623);
    if (!this.Onp) {}
    for (boolean bool1 = c(paramd);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = false;
      }
      if ((!bool2) && (!this.Onq)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!this.Onr) {
            bool2 = d(paramd);
          }
        }
        AppMethodBeat.o(68623);
        return bool2;
      }
    }
  }
  
  private void bf(Intent paramIntent)
  {
    AppMethodBeat.i(68627);
    this.Onf = bg(paramIntent);
    if (this.Onf)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
      PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
      paramIntent = localPayInfo;
      if (localPayInfo == null)
      {
        paramIntent = new PayInfo();
        paramIntent.fwv = this.fwv;
        paramIntent.fOY = 21;
      }
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ab(paramIntent.fwv));
    }
    AppMethodBeat.o(68627);
  }
  
  private static boolean bg(Intent paramIntent)
  {
    AppMethodBeat.i(68629);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      AppMethodBeat.o(68629);
      return true;
    }
    AppMethodBeat.o(68629);
    return false;
  }
  
  private boolean c(final d paramd)
  {
    AppMethodBeat.i(68624);
    if (paramd.OkE)
    {
      this.Onp = true;
      com.tencent.mm.ui.base.h.a(this, false, paramd.OkF, "", getString(a.i.app_ok), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68583);
          paramAnonymousDialogInterface.dismiss();
          if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd))
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd.fHb);
            WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, paramd);
          }
          AppMethodBeat.o(68583);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68584);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68584);
        }
      });
      AppMethodBeat.o(68624);
      return true;
    }
    AppMethodBeat.o(68624);
    return false;
  }
  
  private boolean d(d paramd)
  {
    AppMethodBeat.i(68625);
    paramd = paramd.OkH;
    if ((paramd != null) && ((!TextUtils.isEmpty(paramd.ONh)) || ((paramd.ONi != null) && (paramd.ONi.size() > 0))))
    {
      this.Onr = true;
      n.a(this, paramd, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(267727);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = "";
          String str = "";
          if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) != null)
          {
            paramAnonymousDialogInterface = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bankcardType;
            str = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bindSerial;
          }
          WalletBalanceFetchUI.q(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.r(WalletBalanceFetchUI.this);
          if (WalletBalanceFetchUI.gFQ())
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, WalletBalanceFetchUI.s(WalletBalanceFetchUI.this), "1", paramAnonymousDialogInterface, str, WalletBalanceFetchUI.t(WalletBalanceFetchUI.this));
            AppMethodBeat.o(267727);
            return;
          }
          WalletBalanceFetchUI.this.doSceneProgress(new d(WalletBalanceFetchUI.s(WalletBalanceFetchUI.this), "CNY", paramAnonymousDialogInterface, WalletBalanceFetchUI.t(WalletBalanceFetchUI.this)));
          AppMethodBeat.o(267727);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68586);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68586);
        }
      });
      AppMethodBeat.o(68625);
      return true;
    }
    AppMethodBeat.o(68625);
    return false;
  }
  
  private void eaE()
  {
    AppMethodBeat.i(68614);
    s.gGL();
    final com.tencent.mm.plugin.wallet_core.model.b localb = s.gGM().OUa;
    removeAllOptionMenu();
    if ((localb != null) && (localb.ONl != null) && (localb.ONl.ONn != null) && (localb.ONl.ONn.length > 0)) {
      addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(273996);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBalanceFetchUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(227388);
              b.c[] arrayOfc = WalletBalanceFetchUI.2.this.Onu.ONl.ONn;
              int k = arrayOfc.length;
              int i = 0;
              int j = 0;
              if (i < k)
              {
                b.c localc = arrayOfc[i];
                if (!Util.isNullOrNil(localc.title))
                {
                  if (Util.isNullOrNil(localc.desc)) {
                    break label91;
                  }
                  paramAnonymous2o.a(j, localc.title, localc.desc, 0);
                }
                for (;;)
                {
                  j += 1;
                  i += 1;
                  break;
                  label91:
                  paramAnonymous2o.d(j, localc.title);
                }
              }
              AppMethodBeat.o(227388);
            }
          };
          paramAnonymousMenuItem.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(204664);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if ((WalletBalanceFetchUI.2.this.Onu.ONl.ONn != null) && (paramAnonymous2Int < WalletBalanceFetchUI.2.this.Onu.ONl.ONn.length))
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.2.this.Onu.ONl.ONn[paramAnonymous2Int];
                Log.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.jump_type), paramAnonymous2MenuItem.jump_url });
                switch (paramAnonymous2MenuItem.jump_type)
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(204664);
                return;
                com.tencent.mm.wallet_core.ui.g.p(WalletBalanceFetchUI.this.getContext(), paramAnonymous2MenuItem.jump_url, true);
                AppMethodBeat.o(204664);
                return;
                com.tencent.mm.wallet_core.ui.g.v(paramAnonymous2MenuItem.username, paramAnonymous2MenuItem.path, 0, 1000);
              }
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(273996);
          return true;
        }
      });
    }
    AppMethodBeat.o(68614);
  }
  
  private static boolean fAm()
  {
    AppMethodBeat.i(174433);
    com.tencent.mm.wallet_core.b.iie();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.vCG, true);
    com.tencent.mm.wallet_core.b.iie();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.vGY, false);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(174433);
      return true;
    }
    AppMethodBeat.o(174433);
    return false;
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68609);
    s.gGL();
    com.tencent.mm.plugin.wallet_core.model.ao localao = s.gGM();
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (this.Onf)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.OmN != null) && (this.OmN.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.OmN);
      }
      this.OmN = localao.gKm();
      if ((this.OmN != null) && (this.OmN.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.OmN);
      }
      if ((((ArrayList)localObject1).size() <= 0) || (((ArrayList)localObject2).size() <= 0)) {
        break label617;
      }
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject4 = (Bankcard)((ArrayList)localObject1).get(i);
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          Bankcard localBankcard = (Bankcard)((ArrayList)localObject2).get(j);
          if ((localObject4 != null) && (localBankcard != null) && (((Bankcard)localObject4).field_bindSerial.equals(localBankcard.field_bindSerial))) {
            ((ArrayList)localObject3).add(localBankcard);
          }
          j += 1;
        }
        i += 1;
      }
      if (((ArrayList)localObject3).size() > 0) {
        ((ArrayList)localObject2).removeAll((Collection)localObject3);
      }
      if (((ArrayList)localObject2).size() <= 0) {
        break label617;
      }
    }
    label347:
    label617:
    for (Object localObject1 = (Bankcard)((ArrayList)localObject2).get(0);; localObject1 = null)
    {
      if (localObject1 == null) {
        localObject1 = localao.a(this.OmN, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.OmN != null) && (i < this.OmN.size()))
        {
          localObject2 = (Bankcard)this.OmN.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.ARl = i;
          }
        }
        else
        {
          this.OmO = ((Bankcard)localObject1);
          this.Onf = false;
          localObject3 = com.tencent.mm.plugin.report.service.h.IzE;
          localObject4 = this.nYA;
          if (this.OmO == null) {
            break label587;
          }
          localObject1 = this.OmO.field_bankcardType;
          label373:
          if (this.OmO == null) {
            break label594;
          }
          localObject2 = this.OmO.field_bindSerial;
          ((com.tencent.mm.plugin.report.service.h)localObject3).a(16398, new Object[] { localObject4, Integer.valueOf(1), localObject1, localObject2 });
          if (localao.OUa == null) {
            break label602;
          }
          this.OmZ = localao.OUa.OmZ;
          this.Ona = localao.OUa.Ona;
          gFI();
          this.Onb = localao.OUa.Onb;
        }
        for (;;)
        {
          this.Ong = 0;
          this.Onh = 0;
          Log.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.OmZ + " is_cal_charge:" + this.Ona + " min_charge_fee:" + this.Onc + " is_full_fetch_direct:" + this.Onb);
          AppMethodBeat.o(68609);
          return;
          i += 1;
          break;
          this.OmN = localao.gKm();
          this.OmO = localao.a(this.OmN, null, false, true);
          break label347;
          localObject1 = "";
          break label373;
          localObject2 = "";
          break label389;
          Log.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
      }
    }
  }
  
  private void gFH()
  {
    AppMethodBeat.i(223946);
    if ((Util.getDouble(this.OmQ.getText(), 0.0D) <= 0.0D) || (!this.OmQ.bAz()))
    {
      this.mWcKeyboard.Ih(false);
      AppMethodBeat.o(223946);
      return;
    }
    this.mWcKeyboard.Ih(true);
    AppMethodBeat.o(223946);
  }
  
  private void gFI()
  {
    AppMethodBeat.i(68612);
    if (this.OmO != null)
    {
      this.Onc = com.tencent.mm.wallet_core.ui.g.a(this.OmO.ONY, "100", 2, RoundingMode.HALF_UP);
      Log.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", new Object[] { Double.valueOf(this.Onc) });
    }
    AppMethodBeat.o(68612);
  }
  
  private void gFJ()
  {
    AppMethodBeat.i(68616);
    if (this.Ong == 0)
    {
      this.mMC = Util.getDouble(this.OmQ.getText(), 0.0D);
      double d = this.mMC;
      s.gGL();
      if ((d != s.gGM().OnP.ONF) && (this.OmO != null))
      {
        d = this.mMC;
        s.gGL();
        if (d != s.gGM().OnP.ONF - this.OmO.field_full_fetch_charge_fee) {
          this.Ond = 0;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int j = -1;
      d = this.mMC;
      s.gGL();
      int i;
      if (d > s.gGM().OnP.OND)
      {
        this.OmV.setVisibility(8);
        this.OmU.setTextColor(getResources().getColor(a.c.Red));
        localStringBuilder.append(getString(a.i.wallet_balance_input_amount_exceed_balance_tips));
        i = j;
      }
      while (i == -1)
      {
        this.OmU.setClickable(false);
        this.OmU.setOnTouchListener(null);
        this.OmU.setText(localStringBuilder.toString());
        AppMethodBeat.o(68616);
        return;
        String str;
        if ((this.OmO != null) && (this.OmZ != 0) && ((this.OmZ != 1) || (this.OmO.field_fetch_charge_rate > 0.0D)) && ((this.OmZ != 1) || (this.OmO.field_fetch_charge_rate <= 0.0D) || (this.Ona != 0)))
        {
          d = this.Onc;
          s.gGL();
          if (d < s.gGM().OnP.ONF) {}
        }
        else
        {
          this.OmU.setTextColor(this.Onj);
          s.gGL();
          str = s.gGM().OnP.ONK;
          if (!Util.isNullOrNil(str)) {
            localStringBuilder.append(str);
          }
          for (;;)
          {
            localStringBuilder.append("，");
            i = localStringBuilder.length();
            localStringBuilder.append(getString(a.i.wallet_balance_fetch_all_btn));
            break;
            Log.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
            s.gGL();
            d = s.gGM().OnP.ONF;
            localStringBuilder.append(getString(a.i.wallet_balance_fetch_fetch_fee, new Object[] { com.tencent.mm.wallet_core.ui.g.d(d, "CNY") }));
          }
        }
        if ((this.OmZ == 1) && (this.OmO.field_fetch_charge_rate > 0.0D) && (this.Ona == 1) && ((this.mMC <= 0.0D) || (!this.OmQ.bAz())))
        {
          this.OmU.setTextColor(this.Onj);
          s.gGL();
          str = s.gGM().OnP.ONK;
          if (!Util.isNullOrNil(str)) {
            localStringBuilder.append(str);
          }
          for (;;)
          {
            localStringBuilder.append("，");
            i = localStringBuilder.length();
            localStringBuilder.append(getString(a.i.wallet_balance_fetch_all_btn));
            break;
            Log.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
            s.gGL();
            d = s.gGM().OnP.ONF;
            localStringBuilder.append(getString(a.i.wallet_balance_fetch_fetch_fee, new Object[] { com.tencent.mm.wallet_core.ui.g.d(d, "CNY") }));
          }
        }
        i = j;
        if (this.OmZ == 1)
        {
          i = j;
          if (this.OmO.field_fetch_charge_rate > 0.0D)
          {
            i = j;
            if (this.Ona == 1)
            {
              this.OmV.setVisibility(8);
              this.OmU.setTextColor(this.Onj);
              d = this.mMC;
              s.gGL();
              if ((d == s.gGM().OnP.ONF - this.OmO.field_full_fetch_charge_fee) && (this.OmO.field_full_fetch_charge_fee > 0.0D))
              {
                if (!Util.isNullOrNil(this.OmO.ONX))
                {
                  localStringBuilder.append(String.format(this.OmO.ONX, new Object[] { com.tencent.mm.wallet_core.ui.g.d(this.OmO.field_full_fetch_charge_fee, "CNY") }));
                  i = j;
                }
                else
                {
                  localStringBuilder.append(getString(a.i.wallet_balance_additional_deduction_fee_tips_1, new Object[] { com.tencent.mm.wallet_core.ui.g.d(this.OmO.field_full_fetch_charge_fee, "CNY"), this.OmO.field_fetch_charge_rate * 100.0D + "%" }));
                  i = j;
                }
              }
              else if (!Util.isNullOrNil(this.OmO.ONX))
              {
                localStringBuilder.append(String.format(this.OmO.ONX, new Object[] { com.tencent.mm.wallet_core.ui.g.d(C(this.mMC), "CNY") }));
                i = j;
              }
              else
              {
                localStringBuilder.append(getString(a.i.wallet_balance_additional_deduction_fee_tips_1, new Object[] { com.tencent.mm.wallet_core.ui.g.d(C(this.mMC), "CNY"), this.OmO.field_fetch_charge_rate * 100.0D + "%" }));
                i = j;
              }
            }
          }
        }
      }
      com.tencent.mm.wallet_core.ui.g.a(this.OmU, localStringBuilder.toString(), i, localStringBuilder.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void bwz()
        {
          AppMethodBeat.i(268516);
          WalletBalanceFetchUI.i(WalletBalanceFetchUI.this);
          AppMethodBeat.o(268516);
        }
      }), getContext());
    }
    AppMethodBeat.o(68616);
  }
  
  private void gFK()
  {
    AppMethodBeat.i(224016);
    s.gGL();
    final Bankcard localBankcard = s.gGM().OnP;
    if ((this.OmO != null) && (!Util.isNullOrNil(localBankcard.field_prompt_info_prompt_text)))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
      if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_text)) {
        localSpannableStringBuilder.append(localBankcard.field_prompt_info_jump_text);
      }
      localSpannableStringBuilder.setSpan(new r(new r.a()
      {
        public final void ed(View paramAnonymousView)
        {
          AppMethodBeat.i(276881);
          if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_url))
          {
            com.tencent.mm.wallet_core.ui.g.bA(WalletBalanceFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
            com.tencent.mm.plugin.report.service.h.IzE.a(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
          }
          AppMethodBeat.o(276881);
        }
      }), localBankcard.field_prompt_info_prompt_text.length(), localSpannableStringBuilder.length(), 18);
      this.OmW.setText(localSpannableStringBuilder);
      this.OmW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(getContext()));
      this.OmW.setVisibility(0);
      this.Onj = getContext().getResources().getColor(a.c.FG_0);
      this.OmU.setTextColor(this.Onj);
      AppMethodBeat.o(224016);
      return;
    }
    this.OmW.setText("");
    this.OmW.setVisibility(8);
    this.Onj = getContext().getResources().getColor(a.c.FG_1);
    this.OmU.setTextColor(this.Onj);
    AppMethodBeat.o(224016);
  }
  
  private void gFL()
  {
    AppMethodBeat.i(68620);
    fetchData();
    updateView();
    gFO();
    AppMethodBeat.o(68620);
  }
  
  private void gFM()
  {
    this.Onp = false;
    this.Onq = false;
    this.Onr = false;
    this.Ons = false;
  }
  
  private void gFN()
  {
    AppMethodBeat.i(68628);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.gIR();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bVd())
    {
      com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).GGD, getString(a.i.app_tip), true);
      AppMethodBeat.o(68628);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).fwv = this.fwv;
      ((PayInfo)localObject).fOY = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.OkB);
    localBundle.putBoolean("key_bind_show_change_card", true);
    if (h(this, localBundle))
    {
      AppMethodBeat.o(68628);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
    AppMethodBeat.o(68628);
  }
  
  private void gFO()
  {
    AppMethodBeat.i(68630);
    if (this.OmZ != 0)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.OmZ);
      AppMethodBeat.o(68630);
      return;
    }
    com.tencent.mm.kernel.h.aHH();
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vll, Boolean.FALSE)).booleanValue();
    s.gGL();
    com.tencent.mm.plugin.wallet_core.model.b localb = s.gGM().OUa;
    if ((localb != null) && (!bool))
    {
      double d = localb.Ims;
      com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_pay_fetch_tip_dialog_content, new Object[] { com.tencent.mm.wallet_core.ui.g.F(d) }), getString(a.i.wallet_pay_fetch_tip_dialog_title), getString(a.i.wallet_i_know_it), getString(a.i.wallet_pay_fetch_to_read_charge_rule), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(264472);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.IzE.a(16398, new Object[] { WalletBalanceFetchUI.e(WalletBalanceFetchUI.this), Integer.valueOf(4), "", "" });
          AppMethodBeat.o(264472);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(269387);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(a.i.wallet_fetch_charge_rule_doc));
          localIntent.putExtra("showShare", false);
          com.tencent.mm.wallet_core.ui.g.aJ(WalletBalanceFetchUI.this.getContext(), localIntent);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.IzE.a(16398, new Object[] { WalletBalanceFetchUI.e(WalletBalanceFetchUI.this), Integer.valueOf(3), "", "" });
          AppMethodBeat.o(269387);
        }
      }, a.c.wechat_green);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vll, Boolean.TRUE);
    }
    AppMethodBeat.o(68630);
  }
  
  private boolean h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(68631);
    com.tencent.mm.wallet_core.b.iie();
    if (com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.vGW, true))
    {
      EventCenter.instance.add(this.GCj);
      Log.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:true");
      com.tencent.mm.wallet_core.c.ab.ny(6, paramBundle.getInt("key_bind_scene"));
      com.tencent.mm.wallet_core.c.z.azF(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(68631);
      return true;
    }
    Log.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:false");
    AppMethodBeat.o(68631);
    return false;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68613);
    final ImageView localImageView;
    Object localObject;
    if (this.OmQ.getTitleTv() != null)
    {
      this.OmQ.getTitleTv().setText(String.format(getString(a.i.remittance_fee_tips), new Object[] { ah.ijb() }));
      localImageView = (ImageView)this.OmR.findViewById(a.f.bankcard_logo_iv);
      if (this.OmO == null) {
        break label443;
      }
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.OmO.field_bankcardType, this.OmO.gIG());
      if (locale != null) {
        localObject = locale.GtW;
      }
      localImageView.setImageBitmap(null);
      if (!this.OmO.gIH()) {
        break label348;
      }
      localImageView.setBackgroundResource(a.e.wallet_balance_manager_logo_small);
      label121:
      ((TextView)this.OmR.findViewById(a.f.balance_bankcard_tv)).setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.OmO.field_bankName, this.OmO.field_bankcardTail }));
      ((TextView)this.OmR.findViewById(a.f.balance_bankcard_tv)).setVisibility(0);
      if (!Util.isNullOrNil(this.OmO.field_fetchArriveTimeWording))
      {
        ((TextView)this.OmR.findViewById(a.f.hint_1)).setText(this.OmO.field_fetchArriveTimeWording);
        ((TextView)this.OmR.findViewById(a.f.hint_1)).setVisibility(0);
        if (this.OmO.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label414;
        }
        ((TextView)this.OmR.findViewById(a.f.hint_1)).setTextColor(getResources().getColor(a.c.Orange));
      }
      label275:
      s.gGL();
      Util.isNullOrNil(s.gGM().OnP.ONJ);
      if (this.Ong != 1) {
        break label525;
      }
      this.OmX.setVisibility(8);
      this.OmY.setVisibility(0);
    }
    for (;;)
    {
      gFJ();
      gFK();
      eaE();
      AppMethodBeat.o(68613);
      return;
      Log.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label348:
      localObject = u.a(new c((String)localObject));
      u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(277143);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(243362);
              if ((WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) != null) && (WalletBalanceFetchUI.28.this.OnG != null) && (WalletBalanceFetchUI.28.this.OnG.getTag() != null) && (WalletBalanceFetchUI.28.this.OnG.getTag().equals(WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bindSerial))) {
                WalletBalanceFetchUI.28.this.OnG.setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(243362);
            }
          });
          AppMethodBeat.o(277143);
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break label121;
      }
      localImageView.setImageBitmap(BitmapUtil.extractThumbNail((Bitmap)localObject, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false));
      break label121;
      label414:
      ((TextView)this.OmR.findViewById(a.f.hint_1)).setTextColor(getResources().getColor(a.c.hint_text_color));
      break label275;
      label443:
      localImageView.setImageBitmap(null);
      ((TextView)this.OmR.findViewById(a.f.balance_bankcard_tv)).setText(this.OmP);
      ((TextView)this.OmR.findViewById(a.f.hint_1)).setText("");
      ((TextView)this.OmR.findViewById(a.f.hint_1)).setVisibility(8);
      ((ImageView)this.OmR.findViewById(a.f.bankcard_logo_iv)).setImageBitmap(null);
      break label275;
      label525:
      this.OmX.setVisibility(0);
      this.OmY.setVisibility(8);
    }
  }
  
  public final void bU(float paramFloat)
  {
    AppMethodBeat.i(224064);
    if (this.mrI != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mrI.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.WalletBalanceFetchUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.mrI.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(224064);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_balance_fetch_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68610);
    setMMTitle(a.i.wallet_balance_fetch_title);
    this.mrI = findViewById(a.f.fetch_root_view);
    this.OmR = ((LinearLayout)findViewById(a.f.balance_bankcard_layout));
    ar.a(((TextView)this.OmR.findViewById(a.f.balance_bankcard_tv)).getPaint(), 0.8F);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68591);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).iip();
        s.gGL();
        final ArrayList localArrayList = s.gGM().gKm();
        s.gGL();
        localObject1 = s.gGM().OUa;
        if (localObject1 != null) {
          paramAnonymousView = ((com.tencent.mm.plugin.wallet_core.model.b)localObject1).ONk;
        }
        for (localObject1 = ((com.tencent.mm.plugin.wallet_core.model.b)localObject1).ONj;; localObject1 = "")
        {
          if (localArrayList == null) {
            Log.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
          }
          WalletBalanceFetchUI localWalletBalanceFetchUI = WalletBalanceFetchUI.this;
          Object localObject2 = WalletBalanceFetchUI.this.getContext();
          Bankcard localBankcard = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this);
          new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68590);
              if ((localArrayList != null) && (paramAnonymous2Int < localArrayList.size()))
              {
                WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, (Bankcard)localArrayList.get(paramAnonymous2Int));
                WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
                Log.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_desc });
                localh = com.tencent.mm.plugin.report.service.h.IzE;
                str2 = WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
                if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) != null)
                {
                  paramAnonymous2MenuItem = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bankcardType;
                  if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) == null) {
                    break label214;
                  }
                }
                label214:
                for (str1 = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
                {
                  localh.a(16398, new Object[] { str2, Integer.valueOf(2), paramAnonymous2MenuItem, str1 });
                  WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
                  WalletBalanceFetchUI.gFP();
                  AppMethodBeat.o(68590);
                  return;
                  paramAnonymous2MenuItem = "";
                  break;
                }
              }
              Log.i("MicroMsg.WalletBalanceFetchUI", "add new card");
              WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
              String str2 = WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
              if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) != null)
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bankcardType;
                label281:
                if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) == null) {
                  break label350;
                }
              }
              label350:
              for (String str1 = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
              {
                localh.a(16398, new Object[] { str2, Integer.valueOf(9), paramAnonymous2MenuItem, str1 });
                break;
                paramAnonymous2MenuItem = "";
                break label281;
              }
            }
          };
          if ((localWalletBalanceFetchUI.Onk != null) && (localWalletBalanceFetchUI.Onk.tZx.isShowing())) {
            Log.i("MicroMsg.WalletBalanceFetchUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68591);
            return;
            localWalletBalanceFetchUI.ErL.clear();
            localWalletBalanceFetchUI.Onk = new com.tencent.mm.plugin.wallet.ui.a((Context)localObject2);
            localWalletBalanceFetchUI.Onk.ODT = new WalletBalanceFetchUI.14(localWalletBalanceFetchUI, localArrayList, (Context)localObject2);
            localObject2 = new com.tencent.mm.ui.base.o(localWalletBalanceFetchUI);
            ((com.tencent.mm.ui.base.o)localObject2).a(0, localWalletBalanceFetchUI.getString(a.i.wallet_balance_fetch_use_new_card), null, localWalletBalanceFetchUI.getResources().getDrawable(a.h.icons_outlined_pay_cards), localWalletBalanceFetchUI.getResources().getColor(a.c.FG_2), false);
            localWalletBalanceFetchUI.Onk.a((com.tencent.mm.ui.base.o)localObject2, new WalletBalanceFetchUI.15(localWalletBalanceFetchUI));
            localWalletBalanceFetchUI.Onk.a(new WalletBalanceFetchUI.16(localWalletBalanceFetchUI, localArrayList));
            localObject2 = View.inflate(localWalletBalanceFetchUI, a.g.lqt_select_bankcard_header, null);
            TextView localTextView = (TextView)((View)localObject2).findViewById(a.f.lqt_select_bankcard_title);
            if (!Util.isNullOrNil((String)localObject1)) {
              localTextView.setText((CharSequence)localObject1);
            }
            if (!Util.isNullOrNil(paramAnonymousView)) {
              ((TextView)((View)localObject2).findViewById(a.f.lqt_select_bankcard_tip)).setText(paramAnonymousView);
            }
            ar.a(localTextView.getPaint(), 0.8F);
            ((View)localObject2).findViewById(a.f.deviderline).setVisibility(0);
            ((View)localObject2).findViewById(a.f.lqt_header_close_icon_iv).setOnClickListener(new WalletBalanceFetchUI.17(localWalletBalanceFetchUI));
            localWalletBalanceFetchUI.Onk.setTitleView((View)localObject2);
            int k = 0;
            if (localArrayList != null)
            {
              int j = localArrayList.size();
              k = j;
              if (localBankcard != null)
              {
                int i = 0;
                for (;;)
                {
                  k = j;
                  if (i >= localArrayList.size()) {
                    break;
                  }
                  if (((Bankcard)localArrayList.get(i)).field_bindSerial.equals(localBankcard.field_bindSerial)) {
                    j = i;
                  }
                  i += 1;
                }
              }
            }
            localWalletBalanceFetchUI.Onk.OEc = true;
            localWalletBalanceFetchUI.Onk.mBE = k;
            localWalletBalanceFetchUI.Onk.OEb = true;
            localWalletBalanceFetchUI.Onk.ah(localWalletBalanceFetchUI.getResources().getString(a.i.wallet_dialog_confirm));
            localWalletBalanceFetchUI.Onk.eik();
          }
          paramAnonymousView = "";
        }
      }
    };
    this.OmS = findViewById(a.f.balance_bankcard_layout);
    this.OmS.setOnClickListener((View.OnClickListener)localObject);
    this.OmR.setOnClickListener((View.OnClickListener)localObject);
    this.OmQ = ((WalletFormView)findViewById(a.f.balance_fee));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.OmQ);
    this.OmQ.setOnInputValidChangeListener(this);
    this.mWcKeyboard = new WcPayKeyboard(this);
    this.mWcKeyboard.t(this);
    setWPKeyboard(this.OmQ.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(a.i.wallet_balance_manager_fetch));
    this.OmQ.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(276419);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66)) {
          WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
        }
        AppMethodBeat.o(276419);
        return true;
      }
    });
    this.OmT = ((TextView)findViewById(a.f.wallet_balance_manager_banner));
    this.OmU = ((TextView)findViewById(a.f.fetch_desc_tips_tv));
    this.OmV = ((TextView)findViewById(a.f.fetch_all_tv));
    this.OmW = ((TextView)findViewById(a.f.fetch_balance_frezz_tv));
    this.OmX = ((ViewGroup)findViewById(a.f.fetch_desc_layout));
    this.OmY = ((ViewGroup)findViewById(a.f.fetch_dynamic_desc_layout));
    ar.a(this.OmV.getPaint(), 0.8F);
    this.OmV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68597);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletBalanceFetchUI.i(WalletBalanceFetchUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68597);
      }
    });
    this.OmQ.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(68598);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        str.length();
        int j = str.lastIndexOf(".");
        int k = str.length();
        if ((i >= 0) && (k - i > 3)) {
          WalletFormView.a(WalletBalanceFetchUI.j(WalletBalanceFetchUI.this).getContentEt(), str, i + 3, k);
        }
        for (;;)
        {
          WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, Util.getDouble(paramAnonymousEditable.toString(), 0.0D));
          WalletBalanceFetchUI.gFP();
          WalletBalanceFetchUI.k(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.l(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68598);
          return;
          if (j != i) {
            WalletFormView.a(WalletBalanceFetchUI.j(WalletBalanceFetchUI.this).getContentEt(), str, j, k);
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localObject = new aba();
    ((aba)localObject).gac.scene = "3";
    ((aba)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264712);
        if (!Util.isNullOrNil(this.uaN.gad.gae))
        {
          com.tencent.mm.wallet_core.ui.g.a(WalletBalanceFetchUI.m(WalletBalanceFetchUI.this), this.uaN.gad.gae, this.uaN.gad.content, this.uaN.gad.url);
          AppMethodBeat.o(264712);
          return;
        }
        Log.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
        AppMethodBeat.o(264712);
      }
    };
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(68610);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(223953);
    Log.d("MicroMsg.WalletBalanceFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.Onn), Boolean.valueOf(this.mWcKeyboard.iit()) });
    if ((!this.Onn) && (this.mWcKeyboard.iit()))
    {
      AppMethodBeat.o(223953);
      return true;
    }
    AppMethodBeat.o(223953);
    return false;
  }
  
  public boolean isTransparent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68622);
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("key_select_index", -1);
        paramInt2 = this.ARl;
        this.ARl = paramInt1;
        Log.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(paramInt1)));
        if ((this.OmN == null) || (paramInt1 < 0) || (paramInt1 >= this.OmN.size())) {
          if ((this.OmN == null) || (paramInt1 < 0) || (paramInt1 > this.OmN.size()))
          {
            this.OmO = null;
            gFN();
          }
        }
        for (;;)
        {
          updateView();
          AppMethodBeat.o(68622);
          return;
          this.ARl = paramInt2;
          break;
          this.OmO = ((Bankcard)this.OmN.get(paramInt1));
        }
      }
      Log.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
      AppMethodBeat.o(68622);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68607);
    this.nYA = UUID.randomUUID().toString();
    super.onCreate(paramBundle);
    hideActionbarLine();
    bf(getIntent());
    fetchData();
    this.OmP = getString(a.i.wallet_balance_save_bind_new_card_to_fetch);
    initView();
    updateView();
    com.tencent.mm.wallet_core.c.ab.ny(4, 0);
    AppMethodBeat.o(68607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68608);
    MMHandlerThread.removeRunnable(this.Onl);
    MMHandlerThread.removeRunnable(this.mMK);
    MMHandlerThread.removeRunnable(this.Ono);
    super.onDestroy();
    AppMethodBeat.o(68608);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(223952);
    Log.i("MicroMsg.WalletBalanceFetchUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
    AppMethodBeat.o(223952);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(68621);
    this.OmQ.jf(null);
    AppMethodBeat.o(68621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68626);
    gFM();
    bf(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(68626);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(223949);
    super.onPause();
    if (!this.mWcKeyboard.iis()) {
      this.state = 3;
    }
    AppMethodBeat.o(223949);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68611);
    gFM();
    super.onResume();
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.Ono, 300L);
    }
    this.state = 2;
    gFH();
    AppMethodBeat.o(68611);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(68619);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof d))
      {
        paramString = (d)paramq;
        this.Onp = false;
        if (!this.Ons) {
          this.Onq = false;
        }
        this.Onr = false;
        this.Ons = false;
        boolean bool;
        if ("1".equals(paramString.gat))
        {
          Log.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
          paramq = new Bundle();
          paramq.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
          paramq.putString("realname_verify_process_jump_plugin", "wallet");
          isTransparent();
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramq, null, 0);
        }
        while (bool)
        {
          AppMethodBeat.o(68619);
          return false;
          if ("2".equals(paramString.gat))
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.gau, paramString.gax, paramString.gav, paramString.gaw, isTransparent(), null);
          }
          else
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.gat);
            bool = false;
          }
        }
        if (paramString.OkK) {
          if (paramString.OkL != null)
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
            Object localObject = paramString.OkL.title;
            String str1 = paramString.OkL.content;
            String str2 = paramString.OkL.jDV;
            paramq = paramString.OkL.OkN;
            Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
            View localView = LayoutInflater.from(this).inflate(a.g.wallet_balance_fetch_identify_info_complete_dialog, null);
            ImageView localImageView = (ImageView)localView.findViewById(a.f.close_icon);
            Button localButton = (Button)localView.findViewById(a.f.complete_btn);
            ((TextView)localView.findViewById(a.f.main_title)).setText((CharSequence)localObject);
            ((TextView)localView.findViewById(a.f.main_subtitle)).setText(str1);
            ((Button)localView.findViewById(a.f.complete_btn)).setText(str2);
            localObject = new com.tencent.mm.plugin.crashfix.b.a(this, a.j.mmalertdialog);
            ((Dialog)localObject).setContentView(localView);
            ((Dialog)localObject).setTitle(null);
            ((Dialog)localObject).setOnCancelListener(new WalletBalanceFetchUI.18(this, (Dialog)localObject));
            localImageView.setOnClickListener(new WalletBalanceFetchUI.19(this, (Dialog)localObject));
            localButton.setOnClickListener(new WalletBalanceFetchUI.20(this, this, paramq, (Dialog)localObject));
            ((Dialog)localObject).show();
            com.tencent.mm.ui.base.h.a(this, (Dialog)localObject);
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label491;
          }
          AppMethodBeat.o(68619);
          return false;
          Log.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
          break;
        }
        label491:
        af.B(21, paramString.fHb, paramInt2);
        if (!b(paramString))
        {
          this.fwv = paramString.fHb;
          a(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68619);
      return false;
      if ((paramq instanceof ae))
      {
        paramString = (ae)paramq;
        gFL();
        if (paramString.isJumpRemind())
        {
          paramq = paramString.getJumpRemind();
          paramq.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(249354);
              if (paramq.iiO()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(249354);
            }
            
            public final void onEnter()
            {
              AppMethodBeat.i(249355);
              paramq.iiO();
              AppMethodBeat.o(249355);
            }
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(249357);
              if (paramq.iiO()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(249357);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(249356);
              if (paramq.iiO()) {
                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
              }
              AppMethodBeat.o(249356);
            }
          });
          AppMethodBeat.o(68619);
          return true;
          if ((paramq instanceof d))
          {
            af.B(21, "", paramInt2);
            gFM();
            MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI
 * JD-Core Version:    0.7.0.1
 */