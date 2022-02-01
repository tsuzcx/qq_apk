package com.tencent.mm.plugin.wallet.balance.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.acx.b;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet.balance.model.d;
import com.tencent.mm.plugin.wallet.balance.model.d.a;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceFetchUI
  extends WalletBaseUI
  implements WcPayKeyboard.a, WalletFormView.a
{
  private static final String Vca;
  private int Fjh;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private HashMap<String, Integer> Kkr;
  private IListener<ng> Myr;
  private TextView VbA;
  private TextView VbB;
  private TextView VbC;
  private ViewGroup VbD;
  private ViewGroup VbE;
  private LinearLayout VbF;
  private TextView VbG;
  private LinearLayout VbH;
  private CdnImageView VbI;
  private TextView VbJ;
  private TextView VbK;
  private boolean VbL;
  private boolean VbM;
  private int VbN;
  private int VbO;
  private int VbP;
  private double VbQ;
  private int VbR;
  private DecimalFormat VbS;
  private boolean VbT;
  private int VbU;
  private int VbV;
  private com.tencent.mm.plugin.wallet.balance.model.b VbW;
  private int VbX;
  private com.tencent.mm.plugin.wallet.ui.a VbY;
  private Runnable VbZ;
  private ArrayList<Bankcard> Vbt;
  private Bankcard Vbu;
  private String Vbv;
  private WalletFormView Vbw;
  private LinearLayout Vbx;
  private View Vby;
  private TextView Vbz;
  protected boolean Vcb;
  private Runnable Vcc;
  private boolean Vcd;
  private boolean Vce;
  private boolean Vcf;
  private boolean Vcg;
  private String hAT;
  private double pJk;
  public Runnable pJs;
  private WcPayBannerView pLM;
  private View plc;
  private String qYC;
  private int state;
  
  static
  {
    AppMethodBeat.i(316448);
    Vca = "http://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/product/wechatwallet_app.html?platform=15&scene_id=kf4";
    AppMethodBeat.o(316448);
  }
  
  public WalletBalanceFetchUI()
  {
    AppMethodBeat.i(68606);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.hAT = null;
    this.VbL = true;
    this.VbM = true;
    this.VbN = 0;
    this.VbO = 0;
    this.VbP = 0;
    this.VbQ = 0.0D;
    this.Fjh = -1;
    this.VbR = 0;
    this.VbS = new DecimalFormat("0.00");
    this.VbT = false;
    this.VbU = 0;
    this.VbV = 0;
    this.VbX = MMApplicationContext.getContext().getResources().getColor(a.c.FG_1);
    this.VbZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68576);
        WalletBalanceFetchUI.a(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68576);
      }
    };
    this.state = 0;
    this.Vcb = false;
    this.pJs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316265);
        if ((WalletBalanceFetchUI.p(WalletBalanceFetchUI.this) == 2) && (WalletBalanceFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletBalanceFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(316265);
      }
    };
    this.Vcc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68577);
        WalletBalanceFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(68577);
      }
    };
    this.Vcd = false;
    this.Vce = false;
    this.Vcf = false;
    this.Vcg = false;
    this.Kkr = new HashMap();
    this.Myr = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(68606);
  }
  
  private double U(double paramDouble)
  {
    AppMethodBeat.i(68617);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    am localam = com.tencent.mm.plugin.wallet.model.p.ifP();
    paramDouble = Math.max(i.b(paramDouble - localam.VKg.OjJ, this.Vbu.field_fetch_charge_rate, RoundingMode.HALF_UP), this.VbQ);
    AppMethodBeat.o(68617);
    return paramDouble;
  }
  
  private void a(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(174434);
    Bundle localBundle = new Bundle();
    localBundle.putInt("payScene", 21);
    localBundle.putString("totalFee", i.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localBundle.putString("feeType", paramString1);
    localBundle.putString("bankType", paramString2);
    localBundle.putString("bindSerial", paramString3);
    localBundle.putString("operation", String.valueOf(paramInt));
    localBundle.putString("reportSessionId", this.qYC);
    Log.i("MicroMsg.WalletBalanceFetchUI", "startWalletBalanceFetchUseCase totalFee：%s reportSessionId %s", new Object[] { i.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString(), this.qYC });
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceFetchUseCase(this, localBundle);
    AppMethodBeat.o(174434);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(68618);
    if (!Util.isNullOrNil(this.hAT))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).hAT = this.hAT;
      ((PayInfo)localObject).hUR = 21;
      getInput().putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).hAW = (paramd.OjO - paramd.OjF);
      ((Orders)localObject).VGG = (paramd.OjO - paramd.OjF);
      ((Orders)localObject).VGX.add(new Orders.Commodity());
      ((Orders)localObject).OjF = paramd.OjF;
      getInput().putString("key_fetch_cashier_encode_str", paramd.UZp);
      getInput().putParcelable("key_orders", (Parcelable)localObject);
      getInput().putParcelable("key_bankcard", this.Vbu);
      getInput().putString("key_fetch_cashier_desc", paramd.UZm);
      getInput().putString("key_report_session_id", this.qYC);
      if (getProcess() == null)
      {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, getInput(), null);
        AppMethodBeat.o(68618);
        return;
      }
      getNetController().t(new Object[] { getInput() });
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
    if (!this.Vcd) {}
    for (boolean bool1 = c(paramd);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = false;
      }
      if ((!bool2) && (!this.Vce)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!this.Vcf) {
            bool2 = d(paramd);
          }
        }
        AppMethodBeat.o(68623);
        return bool2;
      }
    }
  }
  
  private void bF(Intent paramIntent)
  {
    AppMethodBeat.i(68627);
    this.VbT = bG(paramIntent);
    if (this.VbT)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
      PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
      paramIntent = localPayInfo;
      if (localPayInfo == null)
      {
        paramIntent = new PayInfo();
        paramIntent.hAT = this.hAT;
        paramIntent.hUR = 21;
      }
      doSceneForceProgress(new ab(paramIntent.hAT));
    }
    AppMethodBeat.o(68627);
  }
  
  private static boolean bG(Intent paramIntent)
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
    if (paramd.UZh)
    {
      this.Vcd = true;
      com.tencent.mm.ui.base.k.a(this, false, paramd.UZi, "", getString(a.i.app_ok), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(316314);
          paramAnonymousDialogInterface.dismiss();
          if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd))
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd.hMy);
            WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, paramd);
          }
          AppMethodBeat.o(316314);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68586);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.r(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68586);
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
    paramd = paramd.UZk;
    if ((paramd != null) && ((!TextUtils.isEmpty(paramd.VCS)) || ((paramd.VCT != null) && (paramd.VCT.size() > 0))))
    {
      this.Vcf = true;
      o.a(this, paramd, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68587);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = "";
          String str = "";
          if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
          {
            paramAnonymousDialogInterface = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
            str = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;
          }
          WalletBalanceFetchUI.s(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.t(WalletBalanceFetchUI.this);
          if (WalletBalanceFetchUI.ieP())
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, WalletBalanceFetchUI.u(WalletBalanceFetchUI.this), "1", paramAnonymousDialogInterface, str, WalletBalanceFetchUI.v(WalletBalanceFetchUI.this));
            AppMethodBeat.o(68587);
            return;
          }
          WalletBalanceFetchUI.this.doSceneProgress(new d(WalletBalanceFetchUI.u(WalletBalanceFetchUI.this), "CNY", paramAnonymousDialogInterface, WalletBalanceFetchUI.v(WalletBalanceFetchUI.this)));
          AppMethodBeat.o(68587);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(316294);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.r(WalletBalanceFetchUI.this);
          AppMethodBeat.o(316294);
        }
      });
      AppMethodBeat.o(68625);
      return true;
    }
    AppMethodBeat.o(68625);
    return false;
  }
  
  private void fbu()
  {
    AppMethodBeat.i(68614);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    final com.tencent.mm.plugin.wallet_core.model.b localb = com.tencent.mm.plugin.wallet.model.p.ifP().VKg;
    removeAllOptionMenu();
    if ((localb != null) && (localb.VCW != null) && (localb.VCW.VCY != null) && (localb.VCW.VCY.length > 0)) {
      addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(316302);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(WalletBalanceFetchUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(316327);
              b.c[] arrayOfc = WalletBalanceFetchUI.4.this.Vck.VCW.VCY;
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
                  paramAnonymous2s.a(j, localc.title, localc.desc, 0);
                }
                for (;;)
                {
                  j += 1;
                  i += 1;
                  break;
                  label91:
                  paramAnonymous2s.c(j, localc.title);
                }
              }
              AppMethodBeat.o(316327);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(316319);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if ((WalletBalanceFetchUI.4.this.Vck.VCW.VCY != null) && (paramAnonymous2Int < WalletBalanceFetchUI.4.this.Vck.VCW.VCY.length))
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.4.this.Vck.VCW.VCY[paramAnonymous2Int];
                Log.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.jump_type), paramAnonymous2MenuItem.jump_url });
                switch (paramAnonymous2MenuItem.jump_type)
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(316319);
                return;
                i.p(WalletBalanceFetchUI.this.getContext(), paramAnonymous2MenuItem.jump_url, true);
                AppMethodBeat.o(316319);
                return;
                i.y(paramAnonymous2MenuItem.username, paramAnonymous2MenuItem.path, 0, 1000);
              }
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(316302);
          return true;
        }
      });
    }
    AppMethodBeat.o(68614);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68609);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    am localam = com.tencent.mm.plugin.wallet.model.p.ifP();
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (this.VbT)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.Vbt != null) && (this.Vbt.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.Vbt);
      }
      this.Vbt = localam.ijD();
      if ((this.Vbt != null) && (this.Vbt.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.Vbt);
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
        localObject1 = localam.a(this.Vbt, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.Vbt != null) && (i < this.Vbt.size()))
        {
          localObject2 = (Bankcard)this.Vbt.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.Fjh = i;
          }
        }
        else
        {
          this.Vbu = ((Bankcard)localObject1);
          this.VbT = false;
          localObject3 = com.tencent.mm.plugin.report.service.h.OAn;
          localObject4 = this.qYC;
          if (this.Vbu == null) {
            break label587;
          }
          localObject1 = this.Vbu.field_bankcardType;
          label373:
          if (this.Vbu == null) {
            break label594;
          }
          localObject2 = this.Vbu.field_bindSerial;
          ((com.tencent.mm.plugin.report.service.h)localObject3).b(16398, new Object[] { localObject4, Integer.valueOf(1), localObject1, localObject2 });
          if (localam.VKg == null) {
            break label602;
          }
          this.VbN = localam.VKg.VbN;
          this.VbO = localam.VKg.VbO;
          ieG();
          this.VbP = localam.VKg.VbP;
        }
        for (;;)
        {
          this.VbU = 0;
          this.VbV = 0;
          Log.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.VbN + " is_cal_charge:" + this.VbO + " min_charge_fee:" + this.VbQ + " is_full_fetch_direct:" + this.VbP);
          AppMethodBeat.o(68609);
          return;
          i += 1;
          break;
          this.Vbt = localam.ijD();
          this.Vbu = localam.a(this.Vbt, null, false, true);
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
  
  private static boolean gLY()
  {
    AppMethodBeat.i(174433);
    com.tencent.mm.wallet_core.b.jNX();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
    com.tencent.mm.wallet_core.b.jNX();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(c.a.yWR, true);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(174433);
      return true;
    }
    AppMethodBeat.o(174433);
    return false;
  }
  
  private void ieF()
  {
    AppMethodBeat.i(316317);
    if ((Util.getDouble(this.Vbw.getText(), 0.0D) <= 0.0D) || (!this.Vbw.bZp()))
    {
      this.mWcKeyboard.Oi(false);
      AppMethodBeat.o(316317);
      return;
    }
    this.mWcKeyboard.Oi(true);
    AppMethodBeat.o(316317);
  }
  
  private void ieG()
  {
    AppMethodBeat.i(68612);
    if (this.Vbu != null)
    {
      this.VbQ = i.a(this.Vbu.VDJ, "100", 2, RoundingMode.HALF_UP);
      Log.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", new Object[] { Double.valueOf(this.VbQ) });
    }
    AppMethodBeat.o(68612);
  }
  
  private void ieH()
  {
    AppMethodBeat.i(316332);
    if (this.Vbu == null)
    {
      Log.e("MicroMsg.WalletBalanceFetchUI", "updateFetchLimitView mDefaultBankcard is null");
      AppMethodBeat.o(316332);
      return;
    }
    if (Util.isNullOrNil(this.Vbu.VDN)) {
      this.VbF.setVisibility(8);
    }
    com.tencent.mm.plugin.report.service.h localh;
    String str3;
    String str1;
    while (Util.isNullOrNil(this.Vbu.VDR))
    {
      this.VbH.setVisibility(8);
      AppMethodBeat.o(316332);
      return;
      this.VbF.setVisibility(0);
      this.VbG.setText(this.Vbu.VDN);
      if (this.VbL)
      {
        this.VbL = false;
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        str3 = this.qYC;
        if (this.Vbu != null)
        {
          str1 = this.Vbu.field_bankcardType;
          label139:
          if (this.Vbu == null) {
            break label196;
          }
        }
        label196:
        for (str2 = this.Vbu.field_bindSerial;; str2 = "")
        {
          localh.b(16398, new Object[] { str3, Integer.valueOf(14), str1, str2 });
          break;
          str1 = "";
          break label139;
        }
      }
    }
    this.VbH.setVisibility(0);
    this.VbJ.setText(this.Vbu.VDR);
    this.VbK.setText(this.Vbu.VDU);
    this.VbI.setUrl(this.Vbu.VDS);
    if (this.VbM)
    {
      this.VbM = false;
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      str3 = this.qYC;
      if (this.Vbu == null) {
        break label344;
      }
      str1 = this.Vbu.field_bankcardType;
      if (this.Vbu == null) {
        break label351;
      }
    }
    label344:
    label351:
    for (String str2 = this.Vbu.field_bindSerial;; str2 = "")
    {
      localh.b(16398, new Object[] { str3, Integer.valueOf(12), str1, str2 });
      AppMethodBeat.o(316332);
      return;
      str1 = "";
      break;
    }
  }
  
  private void ieI()
  {
    AppMethodBeat.i(68616);
    if (this.VbU == 0)
    {
      this.pJk = Util.getDouble(this.Vbw.getText(), 0.0D);
      double d = this.pJk;
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if ((d != com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDq) && (this.Vbu != null))
      {
        d = this.pJk;
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (d != com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDq - this.Vbu.field_full_fetch_charge_fee) {
          this.VbR = 0;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int j = -1;
      d = this.pJk;
      com.tencent.mm.plugin.wallet.model.p.ifO();
      int i;
      if (d > com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDo)
      {
        this.VbB.setVisibility(8);
        this.VbA.setTextColor(getResources().getColor(a.c.Red));
        localStringBuilder.append(getString(a.i.wallet_balance_input_amount_exceed_balance_tips));
        i = j;
      }
      while (i == -1)
      {
        this.VbA.setClickable(false);
        this.VbA.setOnTouchListener(null);
        this.VbA.setText(localStringBuilder.toString());
        AppMethodBeat.o(68616);
        return;
        String str;
        if ((this.Vbu != null) && (this.VbN != 0) && ((this.VbN != 1) || (this.Vbu.field_fetch_charge_rate > 0.0D)) && ((this.VbN != 1) || (this.Vbu.field_fetch_charge_rate <= 0.0D) || (this.VbO != 0)))
        {
          d = this.VbQ;
          com.tencent.mm.plugin.wallet.model.p.ifO();
          if (d < com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDq) {}
        }
        else
        {
          this.VbA.setTextColor(this.VbX);
          com.tencent.mm.plugin.wallet.model.p.ifO();
          str = com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDv;
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
            com.tencent.mm.plugin.wallet.model.p.ifO();
            d = com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDq;
            localStringBuilder.append(getString(a.i.wallet_balance_fetch_fetch_fee, new Object[] { i.e(d, "CNY") }));
          }
        }
        if ((this.VbN == 1) && (this.Vbu.field_fetch_charge_rate > 0.0D) && (this.VbO == 1) && ((this.pJk <= 0.0D) || (!this.Vbw.bZp())))
        {
          this.VbA.setTextColor(this.VbX);
          com.tencent.mm.plugin.wallet.model.p.ifO();
          str = com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDv;
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
            com.tencent.mm.plugin.wallet.model.p.ifO();
            d = com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDq;
            localStringBuilder.append(getString(a.i.wallet_balance_fetch_fetch_fee, new Object[] { i.e(d, "CNY") }));
          }
        }
        i = j;
        if (this.VbN == 1)
        {
          i = j;
          if (this.Vbu.field_fetch_charge_rate > 0.0D)
          {
            i = j;
            if (this.VbO == 1)
            {
              this.VbB.setVisibility(8);
              this.VbA.setTextColor(this.VbX);
              d = this.pJk;
              com.tencent.mm.plugin.wallet.model.p.ifO();
              if ((d == com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDq - this.Vbu.field_full_fetch_charge_fee) && (this.Vbu.field_full_fetch_charge_fee > 0.0D))
              {
                if (!Util.isNullOrNil(this.Vbu.VDI))
                {
                  localStringBuilder.append(String.format(this.Vbu.VDI, new Object[] { i.e(this.Vbu.field_full_fetch_charge_fee, "CNY") }));
                  i = j;
                }
                else
                {
                  localStringBuilder.append(getString(a.i.wallet_balance_additional_deduction_fee_tips_1, new Object[] { i.e(this.Vbu.field_full_fetch_charge_fee, "CNY"), this.Vbu.field_fetch_charge_rate * 100.0D + "%" }));
                  i = j;
                }
              }
              else if (!Util.isNullOrNil(this.Vbu.VDI))
              {
                localStringBuilder.append(String.format(this.Vbu.VDI, new Object[] { i.e(U(this.pJk), "CNY") }));
                i = j;
              }
              else
              {
                localStringBuilder.append(getString(a.i.wallet_balance_additional_deduction_fee_tips_1, new Object[] { i.e(U(this.pJk), "CNY"), this.Vbu.field_fetch_charge_rate * 100.0D + "%" }));
                i = j;
              }
            }
          }
        }
      }
      i.a(this.VbA, localStringBuilder.toString(), i, localStringBuilder.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(316299);
          WalletBalanceFetchUI.j(WalletBalanceFetchUI.this);
          AppMethodBeat.o(316299);
        }
      }), getContext());
    }
    AppMethodBeat.o(68616);
  }
  
  private void ieJ()
  {
    AppMethodBeat.i(316342);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    final Bankcard localBankcard = com.tencent.mm.plugin.wallet.model.p.ifP().VcF;
    if ((this.Vbu != null) && (!Util.isNullOrNil(localBankcard.field_prompt_info_prompt_text)))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
      if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_text)) {
        localSpannableStringBuilder.append(localBankcard.field_prompt_info_jump_text);
      }
      localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
      {
        public final void eS(View paramAnonymousView)
        {
          AppMethodBeat.i(316320);
          if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_url))
          {
            i.bC(WalletBalanceFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
            com.tencent.mm.plugin.report.service.h.OAn.b(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
          }
          AppMethodBeat.o(316320);
        }
      }), localBankcard.field_prompt_info_prompt_text.length(), localSpannableStringBuilder.length(), 18);
      this.VbC.setText(localSpannableStringBuilder);
      this.VbC.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(getContext()));
      this.VbC.setVisibility(0);
      this.VbX = getContext().getResources().getColor(a.c.FG_0);
      this.VbA.setTextColor(this.VbX);
      AppMethodBeat.o(316342);
      return;
    }
    this.VbC.setText("");
    this.VbC.setVisibility(8);
    this.VbX = getContext().getResources().getColor(a.c.FG_1);
    this.VbA.setTextColor(this.VbX);
    AppMethodBeat.o(316342);
  }
  
  private void ieK()
  {
    AppMethodBeat.i(68620);
    fetchData();
    updateView();
    ieN();
    AppMethodBeat.o(68620);
  }
  
  private void ieL()
  {
    this.Vcd = false;
    this.Vce = false;
    this.Vcf = false;
    this.Vcg = false;
  }
  
  private void ieM()
  {
    AppMethodBeat.i(68628);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.iif();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).cvt())
    {
      com.tencent.mm.ui.base.k.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).MDu, getString(a.i.app_tip), true);
      AppMethodBeat.o(68628);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).hAT = this.hAT;
      ((PayInfo)localObject).hUR = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_req_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.UZe);
    localBundle.putBoolean("key_bind_show_change_card", true);
    if (j(this, localBundle))
    {
      AppMethodBeat.o(68628);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
    AppMethodBeat.o(68628);
  }
  
  private void ieN()
  {
    AppMethodBeat.i(68630);
    if (this.VbN != 0)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.VbN);
      AppMethodBeat.o(68630);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMF, Boolean.FALSE)).booleanValue();
    com.tencent.mm.plugin.wallet.model.p.ifO();
    com.tencent.mm.plugin.wallet_core.model.b localb = com.tencent.mm.plugin.wallet.model.p.ifP().VKg;
    if ((localb != null) && (!bool))
    {
      double d = localb.OjJ;
      com.tencent.mm.ui.base.k.a(this, getString(a.i.wallet_pay_fetch_tip_dialog_content, new Object[] { i.X(d) }), getString(a.i.wallet_pay_fetch_tip_dialog_title), getString(a.i.wallet_i_know_it), getString(a.i.wallet_pay_fetch_to_read_charge_rule), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(316308);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.OAn.b(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(4), "", "" });
          AppMethodBeat.o(316308);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(316307);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(a.i.wallet_fetch_charge_rule_doc));
          localIntent.putExtra("showShare", false);
          i.aS(WalletBalanceFetchUI.this.getContext(), localIntent);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.OAn.b(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(3), "", "" });
          AppMethodBeat.o(316307);
        }
      }, a.c.wechat_green);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acMF, Boolean.TRUE);
    }
    AppMethodBeat.o(68630);
  }
  
  private boolean j(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(68631);
    com.tencent.mm.wallet_core.b.jNX();
    if (com.tencent.mm.wallet_core.b.b(c.a.yWP, true))
    {
      this.Myr.alive();
      Log.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:true");
      ac.pu(6, paramBundle.getInt("key_bind_scene"));
      aa.aGq(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
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
    if (this.Vbw.getTitleTv() != null)
    {
      this.Vbw.getTitleTv().setText(String.format(getString(a.i.remittance_fee_tips), new Object[] { ai.jOX() }));
      localImageView = (ImageView)this.Vbx.findViewById(a.f.bankcard_logo_iv);
      if (this.Vbu == null) {
        break label447;
      }
      localObject = "";
      e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Vbu.field_bankcardType, this.Vbu.ihU());
      if (locale != null) {
        localObject = locale.MpW;
      }
      localImageView.setImageBitmap(null);
      if (!this.Vbu.ihV()) {
        break label352;
      }
      localImageView.setBackgroundResource(a.e.wallet_balance_manager_logo_small);
      label121:
      ((TextView)this.Vbx.findViewById(a.f.balance_bankcard_tv)).setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.Vbu.field_bankName, this.Vbu.field_bankcardTail }));
      ((TextView)this.Vbx.findViewById(a.f.balance_bankcard_tv)).setVisibility(0);
      if (!Util.isNullOrNil(this.Vbu.field_fetchArriveTimeWording))
      {
        ((TextView)this.Vbx.findViewById(a.f.hint_1)).setText(this.Vbu.field_fetchArriveTimeWording);
        ((TextView)this.Vbx.findViewById(a.f.hint_1)).setVisibility(0);
        if (this.Vbu.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label418;
        }
        ((TextView)this.Vbx.findViewById(a.f.hint_1)).setTextColor(getResources().getColor(a.c.Orange));
      }
      label275:
      com.tencent.mm.plugin.wallet.model.p.ifO();
      Util.isNullOrNil(com.tencent.mm.plugin.wallet.model.p.ifP().VcF.VDu);
      if (this.VbU != 1) {
        break label529;
      }
      this.VbD.setVisibility(8);
      this.VbE.setVisibility(0);
    }
    for (;;)
    {
      ieI();
      ieJ();
      fbu();
      ieH();
      AppMethodBeat.o(68613);
      return;
      Log.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label352:
      localObject = r.a(new c((String)localObject));
      r.a(new r.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(316306);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(316351);
              if ((WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null) && (WalletBalanceFetchUI.3.this.Vci != null) && (WalletBalanceFetchUI.3.this.Vci.getTag() != null) && (WalletBalanceFetchUI.3.this.Vci.getTag().equals(WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial))) {
                WalletBalanceFetchUI.3.this.Vci.setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(316351);
            }
          });
          AppMethodBeat.o(316306);
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break label121;
      }
      localImageView.setImageBitmap(BitmapUtil.extractThumbNail((Bitmap)localObject, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false));
      break label121;
      label418:
      ((TextView)this.Vbx.findViewById(a.f.hint_1)).setTextColor(getResources().getColor(a.c.hint_text_color));
      break label275;
      label447:
      localImageView.setImageBitmap(null);
      ((TextView)this.Vbx.findViewById(a.f.balance_bankcard_tv)).setText(this.Vbv);
      ((TextView)this.Vbx.findViewById(a.f.hint_1)).setText("");
      ((TextView)this.Vbx.findViewById(a.f.hint_1)).setVisibility(8);
      ((ImageView)this.Vbx.findViewById(a.f.bankcard_logo_iv)).setImageBitmap(null);
      break label275;
      label529:
      this.VbD.setVisibility(0);
      this.VbE.setVisibility(8);
    }
  }
  
  public final void a(final Context paramContext, final List<Bankcard> paramList, Bankcard paramBankcard, String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(316501);
    if ((this.VbY != null) && (this.VbY.xcO.isShowing()))
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
      AppMethodBeat.o(316501);
      return;
    }
    this.Kkr.clear();
    this.VbY = new com.tencent.mm.plugin.wallet.ui.a(paramContext);
    this.VbY.Vtg = new u.g()
    {
      public final void onCreateMMMenu(final com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(316312);
        int i = 0;
        Object localObject4;
        Object localObject1;
        if (paramList != null)
        {
          Iterator localIterator = paramList.iterator();
          if (localIterator.hasNext())
          {
            localObject4 = (Bankcard)localIterator.next();
            localObject1 = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, ((Bankcard)localObject4).field_bankcardType, ((Bankcard)localObject4).ihU());
            if (localObject1 == null) {
              break label510;
            }
          }
        }
        label175:
        label492:
        label504:
        label510:
        for (final String str1 = ((e)localObject1).MpW;; str1 = "")
        {
          Log.d("MicroMsg.WalletBalanceFetchUI", "logo url: %s", new Object[] { str1 });
          Bitmap localBitmap = r.a(new c(str1));
          r.a(new r.a()
          {
            public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(316323);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(316304);
                  Log.i("MicroMsg.WalletBalanceFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletBalanceFetchUI.16.1.this.MCv });
                  if ((WalletBalanceFetchUI.y(WalletBalanceFetchUI.this).xcO.isShowing()) && (WalletBalanceFetchUI.z(WalletBalanceFetchUI.this).containsKey(paramAnonymous2String)))
                  {
                    int i = ((Integer)WalletBalanceFetchUI.z(WalletBalanceFetchUI.this).get(paramAnonymous2String)).intValue();
                    if ((i < WalletBalanceFetchUI.16.1.this.Kkz.size()) && (WalletBalanceFetchUI.16.1.this.Kkz.getItem(i) != null))
                    {
                      WalletBalanceFetchUI.16.1.this.Kkz.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymous2Bitmap, WalletBalanceFetchUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), WalletBalanceFetchUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
                      WalletBalanceFetchUI.y(WalletBalanceFetchUI.this).ihf();
                    }
                  }
                  AppMethodBeat.o(316304);
                }
              });
              AppMethodBeat.o(316323);
            }
          });
          localObject1 = "";
          if (!Util.isNullOrNil(((Bankcard)localObject4).field_forbidWord)) {
            localObject1 = ((Bankcard)localObject4).field_forbidWord;
          }
          Object localObject3;
          Object localObject2;
          String str2;
          if (Util.isNullOrNil(((Bankcard)localObject4).field_forbid_title))
          {
            localObject3 = new SpannableString((CharSequence)localObject1);
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject1;
            if (Util.isNullOrNil((CharSequence)localObject1)) {
              localObject3 = new SpannableString(((Bankcard)localObject4).field_fetchArriveTimeWording);
            }
            str2 = ((Bankcard)localObject4).field_desc;
            if (localBitmap == null) {
              break label504;
            }
          }
          for (localObject1 = BitmapUtil.extractThumbNail(localBitmap, paramContext.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), paramContext.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);; localObject1 = null)
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject3 });
            int j = i + 1;
            if (localObject1 == null)
            {
              localObject4 = null;
              if (Util.isNullOrNil((String)localObject2)) {
                break label492;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              paramAnonymouss.a(i, str2, (CharSequence)localObject3, (Drawable)localObject4, 0, bool);
              if (localObject1 == null) {
                WalletBalanceFetchUI.z(WalletBalanceFetchUI.this).put(str1, Integer.valueOf(j));
              }
              i = j;
              break;
              localObject2 = (String)localObject1 + " ";
              localObject1 = new SpannableString((String)localObject2 + ((Bankcard)localObject4).field_forbid_title);
              localObject3 = new n(paramContext)
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(316324);
                  paramAnonymous2View = new Intent();
                  String str = this.Vbc.field_forbid_url;
                  Log.i("MicroMsg.WalletBalanceFetchUI", "go to url %s", new Object[] { str });
                  paramAnonymous2View.putExtra("rawUrl", str);
                  paramAnonymous2View.putExtra("geta8key_username", z.bAM());
                  paramAnonymous2View.putExtra("pay_channel", 1);
                  i.aS(WalletBalanceFetchUI.this.getContext(), paramAnonymous2View);
                  AppMethodBeat.o(316324);
                }
              };
              j = ((String)localObject2).length();
              int k = ((String)localObject2).length() + ((Bankcard)localObject4).field_forbid_title.length();
              ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.wallet_offline_link_color)), j, k, 33);
              ((SpannableString)localObject1).setSpan(localObject3, j, k, 33);
              break label175;
              localObject4 = new BitmapDrawable((Bitmap)localObject1);
              break label288;
            }
            AppMethodBeat.o(316312);
            return;
          }
        }
      }
    };
    if (paramBoolean)
    {
      paramContext = new com.tencent.mm.ui.base.s(this);
      paramContext.a(0, getString(a.i.wallet_balance_fetch_use_new_card), null, getResources().getDrawable(a.h.icons_outlined_pay_cards), getResources().getColor(a.c.FG_2), false);
      this.VbY.a(paramContext, new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(316310);
          if (WalletBalanceFetchUI.y(WalletBalanceFetchUI.this) == null)
          {
            AppMethodBeat.o(316310);
            return;
          }
          WalletBalanceFetchUI.y(WalletBalanceFetchUI.this).xcO.cyW();
          Log.i("MicroMsg.WalletBalanceFetchUI", "add new card");
          WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
          String str2 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
          if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
          {
            paramAnonymousMenuItem = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
            if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
              break label149;
            }
          }
          label149:
          for (String str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
          {
            localh.b(16398, new Object[] { str2, Integer.valueOf(9), paramAnonymousMenuItem, str1 });
            AppMethodBeat.o(316310);
            return;
            paramAnonymousMenuItem = "";
            break;
          }
        }
      });
    }
    this.VbY.a(new j.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(316268);
        String str1;
        if ((paramList != null) && (WalletBalanceFetchUI.y(WalletBalanceFetchUI.this).pym >= 0) && (WalletBalanceFetchUI.y(WalletBalanceFetchUI.this).pym < paramList.size()))
        {
          WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, (Bankcard)paramList.get(WalletBalanceFetchUI.y(WalletBalanceFetchUI.this).pym));
          WalletBalanceFetchUI.c(WalletBalanceFetchUI.this);
          Log.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_desc });
          localh = com.tencent.mm.plugin.report.service.h.OAn;
          str3 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
          if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
          {
            str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
            if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
              break label229;
            }
          }
          label229:
          for (str2 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str2 = "")
          {
            localh.b(16398, new Object[] { str3, Integer.valueOf(2), str1, str2 });
            WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
            WalletBalanceFetchUI.ieO();
            WalletBalanceFetchUI.y(WalletBalanceFetchUI.this).xcO.cyW();
            AppMethodBeat.o(316268);
            return;
            str1 = "";
            break;
          }
        }
        Log.i("MicroMsg.WalletBalanceFetchUI", "add new card");
        WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        String str3 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
        if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
        {
          str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
          label283:
          if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
            break label345;
          }
        }
        label345:
        for (String str2 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str2 = "")
        {
          localh.b(16398, new Object[] { str3, Integer.valueOf(9), str1, str2 });
          break;
          str1 = "";
          break label283;
        }
      }
    });
    paramContext = View.inflate(this, a.g.lqt_select_bankcard_header, null);
    TextView localTextView = (TextView)paramContext.findViewById(a.f.lqt_select_bankcard_title);
    if (!Util.isNullOrNil(paramString1)) {
      localTextView.setText(paramString1);
    }
    if (!Util.isNullOrNil(paramString2)) {
      ((TextView)paramContext.findViewById(a.f.lqt_select_bankcard_tip)).setText(paramString2);
    }
    aw.a(localTextView.getPaint(), 0.8F);
    paramContext.findViewById(a.f.deviderline).setVisibility(0);
    paramContext.findViewById(a.f.lqt_header_close_icon_iv).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316267);
        if (WalletBalanceFetchUI.y(WalletBalanceFetchUI.this) != null) {
          WalletBalanceFetchUI.y(WalletBalanceFetchUI.this).xcO.cyW();
        }
        AppMethodBeat.o(316267);
      }
    });
    paramContext.findViewById(a.f.lqt_header_close_icon_iv).setContentDescription(getString(a.i.wallet_accessibility_close_btn));
    this.VbY.setTitleView(paramContext);
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      if (paramBankcard != null) {
        for (;;)
        {
          k = i;
          if (j >= paramList.size()) {
            break;
          }
          if (!((Bankcard)paramList.get(j)).field_bindSerial.equals(paramBankcard.field_bindSerial)) {
            break label469;
          }
          i = j;
          j += 1;
        }
      }
    }
    for (int k = i;; k = 0)
    {
      this.VbY.Vto = true;
      this.VbY.pym = k;
      this.VbY.Vtn = true;
      this.VbY.au(getResources().getString(a.i.wallet_dialog_confirm));
      this.VbY.dDn();
      paramContext = (LinearLayout)paramContext.findViewById(a.f.lqt_bank_header_text_layout);
      paramContext.setFocusable(true);
      paramContext.setContentDescription(paramString1 + paramString2);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(316270);
          if (paramContext != null) {
            paramContext.sendAccessibilityEvent(8);
          }
          AppMethodBeat.o(316270);
        }
      }, 500L);
      AppMethodBeat.o(316501);
      return;
      label469:
      break;
    }
  }
  
  public final void cY(float paramFloat)
  {
    AppMethodBeat.i(316493);
    if (this.plc != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.plc.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.WalletBalanceFetchUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.plc.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(316493);
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
    this.plc = findViewById(a.f.fetch_root_view);
    this.Vbx = ((LinearLayout)findViewById(a.f.balance_bankcard_layout));
    aw.a(((TextView)this.Vbx.findViewById(a.f.balance_bankcard_tv)).getPaint(), 0.8F);
    Object localObject = new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316298);
        WalletBalanceFetchUI.this.showCircleStWcKb();
        com.tencent.mm.plugin.wallet.model.p.ifO();
        final ArrayList localArrayList = com.tencent.mm.plugin.wallet.model.p.ifP().ijD();
        com.tencent.mm.plugin.wallet.model.p.ifO();
        Object localObject = com.tencent.mm.plugin.wallet.model.p.ifP().VKg;
        paramAnonymousView = "";
        String str = "";
        if (localObject != null)
        {
          str = ((com.tencent.mm.plugin.wallet_core.model.b)localObject).VCV;
          paramAnonymousView = ((com.tencent.mm.plugin.wallet_core.model.b)localObject).VCU;
        }
        if (localArrayList == null) {
          Log.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
        }
        localObject = WalletBalanceFetchUI.this;
        AppCompatActivity localAppCompatActivity = WalletBalanceFetchUI.this.getContext();
        Bankcard localBankcard = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this);
        new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(68590);
            if ((localArrayList != null) && (paramAnonymous2Int < localArrayList.size()))
            {
              WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, (Bankcard)localArrayList.get(paramAnonymous2Int));
              WalletBalanceFetchUI.c(WalletBalanceFetchUI.this);
              Log.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_desc });
              localh = com.tencent.mm.plugin.report.service.h.OAn;
              str2 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
              if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
                if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
                  break label214;
                }
              }
              label214:
              for (str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
              {
                localh.b(16398, new Object[] { str2, Integer.valueOf(2), paramAnonymous2MenuItem, str1 });
                WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
                WalletBalanceFetchUI.ieO();
                AppMethodBeat.o(68590);
                return;
                paramAnonymous2MenuItem = "";
                break;
              }
            }
            Log.i("MicroMsg.WalletBalanceFetchUI", "add new card");
            WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
            String str2 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
            if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
            {
              paramAnonymous2MenuItem = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
              label281:
              if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
                break label350;
              }
            }
            label350:
            for (String str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
            {
              localh.b(16398, new Object[] { str2, Integer.valueOf(9), paramAnonymous2MenuItem, str1 });
              break;
              paramAnonymous2MenuItem = "";
              break label281;
            }
          }
        };
        ((WalletBalanceFetchUI)localObject).a(localAppCompatActivity, localArrayList, localBankcard, paramAnonymousView, str, true);
        AppMethodBeat.o(316298);
      }
    };
    this.Vby = findViewById(a.f.balance_bankcard_layout);
    this.Vby.setOnClickListener((View.OnClickListener)localObject);
    this.Vbx.setOnClickListener((View.OnClickListener)localObject);
    this.Vbw = ((WalletFormView)findViewById(a.f.balance_fee));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.Vbw);
    this.Vbw.setOnInputValidChangeListener(this);
    this.mWcKeyboard = new WcPayKeyboard(this);
    this.mWcKeyboard.y(this);
    setWPKeyboard(this.Vbw.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(a.i.wallet_balance_manager_fetch));
    this.Vbw.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(316272);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66)) {
          WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
        }
        AppMethodBeat.o(316272);
        return true;
      }
    });
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    this.VbF = ((LinearLayout)findViewById(a.f.lq_fetch_limit_tip_layout));
    this.VbG = ((TextView)findViewById(a.f.lq_fetch_limit_title));
    this.VbF.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316278);
        WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
        AppMethodBeat.o(316278);
      }
    });
    this.VbH = ((LinearLayout)findViewById(a.f.lq_fetch_limit_guild_layout));
    this.VbI = ((CdnImageView)findViewById(a.f.lq_fetch_limit_guild_logo));
    this.VbJ = ((TextView)findViewById(a.f.lq_fetch_limit_guild_desc));
    this.VbK = ((TextView)findViewById(a.f.lq_fetch_limit_guild_action));
    i.Q(this.VbK);
    this.VbK.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316288);
        WalletBalanceFetchUI.i(WalletBalanceFetchUI.this);
        AppMethodBeat.o(316288);
      }
    });
    this.Vbz = ((TextView)findViewById(a.f.wallet_balance_manager_banner));
    this.VbA = ((TextView)findViewById(a.f.fetch_desc_tips_tv));
    this.VbB = ((TextView)findViewById(a.f.fetch_all_tv));
    this.VbC = ((TextView)findViewById(a.f.fetch_balance_frezz_tv));
    this.VbD = ((ViewGroup)findViewById(a.f.fetch_desc_layout));
    this.VbE = ((ViewGroup)findViewById(a.f.fetch_dynamic_desc_layout));
    aw.a(this.VbB.getPaint(), 0.8F);
    this.VbB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(316283);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletBalanceFetchUI.j(WalletBalanceFetchUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(316283);
      }
    });
    this.Vbw.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(316262);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        str.length();
        int j = str.lastIndexOf(".");
        int k = str.length();
        if ((i >= 0) && (k - i > 3)) {
          WalletFormView.a(WalletBalanceFetchUI.k(WalletBalanceFetchUI.this).getContentEt(), str, i + 3, k);
        }
        for (;;)
        {
          WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, Util.getDouble(paramAnonymousEditable.toString(), 0.0D));
          WalletBalanceFetchUI.ieO();
          WalletBalanceFetchUI.l(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.m(WalletBalanceFetchUI.this);
          AppMethodBeat.o(316262);
          return;
          if (j != i) {
            WalletFormView.a(WalletBalanceFetchUI.k(WalletBalanceFetchUI.this).getContentEt(), str, j, k);
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localObject = new acx();
    ((acx)localObject).igk.scene = "3";
    ((acx)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316259);
        if (this.xer.igl.type == 2)
        {
          WalletBalanceFetchUI.n(WalletBalanceFetchUI.this).setBannerData(this.xer.igl.ign);
          AppMethodBeat.o(316259);
          return;
        }
        if (!Util.isNullOrNil(this.xer.igl.igm))
        {
          i.a(null, WalletBalanceFetchUI.o(WalletBalanceFetchUI.this), this.xer.igl.igm, this.xer.igl.content, this.xer.igl.url);
          AppMethodBeat.o(316259);
          return;
        }
        Log.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
        AppMethodBeat.o(316259);
      }
    };
    ((acx)localObject).publish();
    AppMethodBeat.o(68610);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(316475);
    Log.d("MicroMsg.WalletBalanceFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.Vcb), Boolean.valueOf(this.mWcKeyboard.jOo()) });
    if ((!this.Vcb) && (this.mWcKeyboard.jOo()))
    {
      AppMethodBeat.o(316475);
      return true;
    }
    AppMethodBeat.o(316475);
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
        paramInt2 = this.Fjh;
        this.Fjh = paramInt1;
        Log.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(paramInt1)));
        if ((this.Vbt == null) || (paramInt1 < 0) || (paramInt1 >= this.Vbt.size())) {
          if ((this.Vbt == null) || (paramInt1 < 0) || (paramInt1 > this.Vbt.size()))
          {
            this.Vbu = null;
            ieM();
          }
        }
        for (;;)
        {
          updateView();
          AppMethodBeat.o(68622);
          return;
          this.Fjh = paramInt2;
          break;
          this.Vbu = ((Bankcard)this.Vbt.get(paramInt1));
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
    this.qYC = UUID.randomUUID().toString();
    super.onCreate(paramBundle);
    hideActionbarLine();
    bF(getIntent());
    fetchData();
    this.Vbv = getString(a.i.wallet_balance_save_bind_new_card_to_fetch);
    initView();
    updateView();
    ac.pu(4, 0);
    AppMethodBeat.o(68607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68608);
    MMHandlerThread.removeRunnable(this.VbZ);
    MMHandlerThread.removeRunnable(this.pJs);
    MMHandlerThread.removeRunnable(this.Vcc);
    super.onDestroy();
    AppMethodBeat.o(68608);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(316474);
    Log.i("MicroMsg.WalletBalanceFetchUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
    AppMethodBeat.o(316474);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(68621);
    this.Vbw.mJ(null);
    AppMethodBeat.o(68621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68626);
    ieL();
    bF(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(68626);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(316472);
    super.onPause();
    if (!this.mWcKeyboard.jOn()) {
      this.state = 3;
    }
    AppMethodBeat.o(316472);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68611);
    ieL();
    super.onResume();
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.Vcc, 300L);
    }
    this.state = 2;
    ieF();
    AppMethodBeat.o(68611);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(68619);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramp instanceof d))
      {
        paramString = (d)paramp;
        this.Vcd = false;
        if (!this.Vcg) {
          this.Vce = false;
        }
        this.Vcf = false;
        this.Vcg = false;
        boolean bool;
        if ("1".equals(paramString.igC))
        {
          Log.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
          paramp = new Bundle();
          paramp.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
          paramp.putString("realname_verify_process_jump_plugin", "wallet");
          isTransparent();
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramp, null, 0);
        }
        while (bool)
        {
          AppMethodBeat.o(68619);
          return false;
          if ("2".equals(paramString.igC))
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.igD, paramString.igG, paramString.igE, paramString.igF, isTransparent(), null);
          }
          else
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.igC);
            bool = false;
          }
        }
        if (paramString.UZn) {
          if (paramString.UZo != null)
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
            Object localObject = paramString.UZo.title;
            String str1 = paramString.UZo.content;
            String str2 = paramString.UZo.mdR;
            paramp = paramString.UZo.UZq;
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
            ((Dialog)localObject).setOnCancelListener(new WalletBalanceFetchUI.21(this, (Dialog)localObject));
            localImageView.setOnClickListener(new WalletBalanceFetchUI.22(this, (Dialog)localObject));
            localButton.setOnClickListener(new WalletBalanceFetchUI.24(this, this, paramp, (Dialog)localObject));
            ((Dialog)localObject).show();
            com.tencent.mm.ui.base.k.a(this, (Dialog)localObject);
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
        ag.G(21, paramString.hMy, paramInt2);
        if (!b(paramString))
        {
          this.hAT = paramString.hMy;
          a(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68619);
      return false;
      if ((paramp instanceof ae))
      {
        paramString = (ae)paramp;
        ieK();
        if (paramString.isJumpRemind())
        {
          paramp = paramString.getJumpRemind();
          if (paramp.a(this, new com.tencent.mm.wallet_core.model.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(316315);
              if (paramp.jOJ()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(316315);
            }
            
            public final void onEnter()
            {
              AppMethodBeat.i(316318);
              paramp.jOJ();
              AppMethodBeat.o(316318);
            }
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(316326);
              if (paramp.jOJ()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(316326);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(316322);
              if (paramp.jOJ()) {
                WalletBalanceFetchUI.q(WalletBalanceFetchUI.this);
              }
              AppMethodBeat.o(316322);
            }
          }))
          {
            AppMethodBeat.o(68619);
            return true;
            if ((paramp instanceof d))
            {
              ag.G(21, "", paramInt2);
              ieL();
              MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
            }
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(316457);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet.a.a.class);
    AppMethodBeat.o(316457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI
 * JD-Core Version:    0.7.0.1
 */