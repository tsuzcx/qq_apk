package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.d.a;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.b;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayCashierDialog
  extends i
  implements LifecycleObserver
{
  public static final int BKd;
  public static final int BKe;
  public static final int BKf;
  public static final int BKg;
  private TextView BHY;
  private ImageView BJK;
  private a BKA;
  private n BKB;
  private int BKC;
  private int BKD;
  private int BKE;
  public Bankcard BKF;
  private boolean BKG;
  private boolean BKH;
  private boolean BKI;
  private boolean BKJ;
  private String BKK;
  private String BKL;
  private String BKM;
  private boolean BKN;
  private boolean BKO;
  public a BKP;
  List<b> BKQ;
  private TextView BKh;
  private TextView BKi;
  private TextView BKj;
  private WalletTextView BKk;
  private ViewGroup BKl;
  private EditHintPasswdView BKm;
  private ViewGroup BKn;
  private Button BKo;
  private TextView BKp;
  private ViewGroup BKq;
  private CdnImageView BKr;
  private TextView BKs;
  private Button BKt;
  private ViewGroup BKu;
  private WcPayCashierDetailItemLayout BKv;
  private WcPayCashierDetailItemLayout BKw;
  private WcPayCashierDetailItemLayout BKx;
  private WcPayCashierDetailItemLayout BKy;
  private WcPayCashierFingerprintDialog BKz;
  private com.tencent.mm.plugin.wallet_core.utils.a Bfa;
  public FavorPayInfo Bix;
  private ViewGroup lyD;
  private Context mContext;
  private MyKeyboardWindow mKeyboard;
  public PayInfo mPayInfo;
  private View pHq;
  public Orders wSu;
  
  static
  {
    AppMethodBeat.i(71415);
    BKd = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 30);
    BKe = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 32);
    BKf = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 36);
    BKg = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 23);
    AppMethodBeat.o(71415);
  }
  
  public WcPayCashierDialog(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71361);
    this.BKC = 0;
    this.BKD = 0;
    this.BKE = 0;
    this.mPayInfo = new PayInfo();
    this.wSu = new Orders();
    this.BKG = false;
    this.BKI = true;
    this.BKQ = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71361);
  }
  
  public WcPayCashierDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71362);
    this.BKC = 0;
    this.BKD = 0;
    this.BKE = 0;
    this.mPayInfo = new PayInfo();
    this.wSu = new Orders();
    this.BKG = false;
    this.BKI = true;
    this.BKQ = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71362);
  }
  
  private void TR(int paramInt)
  {
    AppMethodBeat.i(71386);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.BKn.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.BKo.getLayoutParams();
    if (paramInt == 0) {
      localLayoutParams1.topMargin = BKg;
    }
    for (localLayoutParams2.topMargin = BKg;; localLayoutParams2.topMargin = BKf)
    {
      this.BKn.setLayoutParams(localLayoutParams1);
      this.BKo.setLayoutParams(localLayoutParams2);
      this.BKq.setVisibility(paramInt);
      AppMethodBeat.o(71386);
      return;
      localLayoutParams1.topMargin = BKe;
    }
  }
  
  private void a(Bankcard paramBankcard, CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(71381);
    if (paramBankcard == null)
    {
      ac.e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.eqR())
    {
      paramCdnImageView.setImageResource(2131234612);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.eqS())
    {
      this.Bfa.a(paramBankcard, paramCdnImageView);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.eqV())
    {
      paramCdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      if (!bs.isNullOrNil(paramBankcard.BuH))
      {
        paramCdnImageView.setUseSdcardCache(true);
        paramCdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.esU());
        paramCdnImageView.fE(paramBankcard.BuH, 2131690298);
        AppMethodBeat.o(71381);
      }
    }
    else
    {
      this.Bfa.a(getContext(), paramBankcard, paramCdnImageView);
    }
    AppMethodBeat.o(71381);
  }
  
  private void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, String paramString, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71371);
    ac.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBankcard });
    this.mPayInfo = paramPayInfo;
    this.wSu = paramOrders;
    this.Bix = paramFavorPayInfo;
    if (!paramBoolean2) {
      this.BKF = paramBankcard;
    }
    this.BKH = paramBoolean1;
    this.BKK = paramString;
    eua();
    eul();
    eug();
    euj();
    eui();
    eue();
    eub();
    gB(this.wSu.field_infos);
    euc();
    euf();
    eud();
    if (paramBoolean2) {
      setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71360);
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.Bix);
          WcPayCashierDialog.this.setOnShowListener(null);
          AppMethodBeat.o(71360);
        }
      });
    }
    AppMethodBeat.o(71371);
  }
  
  private void a(boolean paramBoolean1, int paramInt, final boolean paramBoolean2, final FavorPayInfo paramFavorPayInfo)
  {
    AppMethodBeat.i(71394);
    ac.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
    if (this.BKA != null) {
      this.BKA.dismiss();
    }
    hide();
    this.BKm.dtH();
    int i;
    label62:
    a locala;
    Object localObject3;
    Object localObject4;
    label123:
    Object localObject5;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label817;
      }
      localObject1 = "";
      af.f(i, (String)localObject1, 11, "");
      this.BKA = new a(this.mContext);
      locala = this.BKA;
      localObject2 = this.mPayInfo;
      localObject3 = this.wSu;
      localObject4 = this.BKF;
      if (localObject4 != null) {
        break label829;
      }
      localObject1 = "";
      ac.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      locala.mPayInfo = ((PayInfo)localObject2);
      locala.wSu = ((Orders)localObject3);
      locala.Bix = paramFavorPayInfo;
      locala.BlJ = ((Bankcard)localObject4);
      locala.BJO = ((Orders)localObject3).BoU;
      locala.BJP = paramBoolean1;
      locala.BJQ = paramInt;
      if (locala.BJP) {
        locala.BJR = false;
      }
      if (locala.mPayInfo.dqL != 8) {
        break label839;
      }
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.ae.tC(true);
      label241:
      localObject2 = localObject1;
      if (locala.Bix != null)
      {
        if (locala.Bix.Bww == 0) {
          break label851;
        }
        paramInt = 1;
        label266:
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (locala.BJP) {
            break label856;
          }
          localObject2 = localObject1;
        }
      }
      label286:
      localObject2 = ((List)localObject2).iterator();
      label295:
      if (!((Iterator)localObject2).hasNext()) {
        break label1478;
      }
      localObject3 = (Bankcard)((Iterator)localObject2).next();
      localObject4 = new WcPayCashierBankcardItemLayout(locala.getContext());
      locala.BJN.add(localObject4);
      locala.BJL.addView((View)localObject4);
      if (!((Bankcard)localObject3).eqR()) {
        break label961;
      }
      com.tencent.mm.plugin.wallet_core.utils.a.k(((WcPayCashierBankcardItemLayout)localObject4).ojf);
      label370:
      if (!((Bankcard)localObject3).eqR()) {
        break label1165;
      }
      localObject1 = s.ery().AZp;
      if (bs.isNullOrNil(((Bankcard)localObject1).Bup)) {
        break label1090;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).BJV.setText(((Bankcard)localObject1).Bup);
      label410:
      localObject1 = "";
      switch (((Bankcard)localObject3).a(locala.BJO, locala.wSu))
      {
      default: 
        if (!bs.isNullOrNil(((Bankcard)localObject3).field_tips)) {
          localObject1 = ((Bankcard)localObject3).field_tips;
        }
        label494:
        localObject5 = new SpannableStringBuilder((CharSequence)localObject1);
        if ((!bs.isNullOrNil(((Bankcard)localObject3).field_forbid_title)) && (!bs.isNullOrNil(((Bankcard)localObject3).field_forbid_url)))
        {
          ((SpannableStringBuilder)localObject5).append("  ");
          ((SpannableStringBuilder)localObject5).append(((Bankcard)localObject3).field_forbid_title);
          ((SpannableStringBuilder)localObject5).setSpan(new ForegroundColorSpan(locala.getContext().getResources().getColor(2131101107)), ((String)localObject1).length() + 2, ((SpannableStringBuilder)localObject5).length(), 34);
          ((WcPayCashierBankcardItemLayout)localObject4).BJW.setOnClickListener(new a.5(locala, (Bankcard)localObject3));
        }
        if (!bs.aj((CharSequence)localObject5))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).BJW.setVisibility(0);
          ((WcPayCashierBankcardItemLayout)localObject4).BJW.setText((CharSequence)localObject5);
        }
        if ((locala.BJR) && (bs.aj((CharSequence)localObject5)))
        {
          localObject1 = locala.g((Bankcard)localObject3);
          if (((LinkedList)localObject1).size() > 0)
          {
            ((WcPayCashierBankcardItemLayout)localObject4).BET.setVisibility(0);
            ((WcPayCashierBankcardItemLayout)localObject4).BJW.setVisibility(8);
            ((WcPayCashierBankcardItemLayout)localObject4).BET.setWording((LinkedList)localObject1);
          }
        }
        if ((locala.BlJ != null) && (((Bankcard)localObject3).field_bindSerial.equals(locala.BlJ.field_bindSerial))) {
          ((WcPayCashierBankcardItemLayout)localObject4).BJX.setChecked(true);
        }
        if (((Bankcard)localObject3).a(locala.BJO, locala.wSu) != 0)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).BJX.setChecked(false);
          ((WcPayCashierBankcardItemLayout)localObject4).BJV.setTextColor(locala.getContext().getResources().getColor(2131100482));
          ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(false);
        }
        break;
      }
    }
    for (;;)
    {
      ((WcPayCashierBankcardItemLayout)localObject4).setOnClickListener(new a.6(locala, (Bankcard)localObject3));
      break label295;
      i = this.mPayInfo.dqL;
      break;
      label817:
      localObject1 = this.mPayInfo.dac;
      break label62;
      label829:
      localObject1 = ((Bankcard)localObject4).field_desc;
      break label123;
      label839:
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.ae.tC(false);
      break label241;
      label851:
      paramInt = 0;
      break label266;
      label856:
      localObject3 = locala.Bix.Bwx;
      localObject2 = new ArrayList();
      paramInt = 0;
      if (paramInt < ((ArrayList)localObject1).size())
      {
        localObject4 = (Bankcard)((ArrayList)localObject1).get(paramInt);
        if (bs.isNullOrNil((String)localObject3)) {
          if (!((Bankcard)localObject4).field_bankcardType.equalsIgnoreCase("CFT")) {
            ((ArrayList)localObject2).add(localObject4);
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if (((Bankcard)localObject4).field_bankcardType.equals(localObject3)) {
            ((ArrayList)localObject2).add(localObject4);
          }
        }
      }
      break label286;
      label961:
      if (((Bankcard)localObject3).eqS())
      {
        locala.Bfa.a((Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).ojf);
        break label370;
      }
      if (((Bankcard)localObject3).eqV())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).ojf.setImageDrawable(com.tencent.mm.svg.a.a.g(locala.getContext().getResources(), 2131690298));
        if (bs.isNullOrNil(((Bankcard)localObject3).BuH)) {
          break label370;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).ojf.setUseSdcardCache(true);
        ((WcPayCashierBankcardItemLayout)localObject4).ojf.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.esU());
        ((WcPayCashierBankcardItemLayout)localObject4).ojf.fE(((Bankcard)localObject3).BuH, 2131690298);
        break label370;
      }
      locala.Bfa.a(locala.getContext(), (Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).ojf);
      break label370;
      label1090:
      if (((Bankcard)localObject1).Buo >= 0.0D)
      {
        localObject5 = ((WcPayCashierBankcardItemLayout)localObject4).BJV;
        Context localContext = locala.getContext();
        locala.getContext();
        ((TextView)localObject5).setText(localContext.getString(ah.fAB(), new Object[] { com.tencent.mm.wallet_core.ui.e.D(((Bankcard)localObject1).Buo) }));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).BJV.setText("");
      break label410;
      label1165:
      if (((Bankcard)localObject3).eqS())
      {
        localObject1 = s.ery().BAI;
        if (!bs.isNullOrNil(((Bankcard)localObject1).Bup))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).BJV.setText(((Bankcard)localObject1).Bup);
          break label410;
        }
        if (((Bankcard)localObject1).Buo >= 0.0D)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).BJV.setText(locala.getContext().getString(2131765386, new Object[] { com.tencent.mm.wallet_core.ui.e.D(((Bankcard)localObject1).Buo) }));
          break label410;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).BJV.setText("");
        break label410;
      }
      if (((Bankcard)localObject3).eqV())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).BJV.setText(com.tencent.mm.pluginsdk.ui.span.k.b(locala.getContext(), ((Bankcard)localObject3).field_desc, ((WcPayCashierBankcardItemLayout)localObject4).BJV.getTextSize()));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).BJV.setText(((Bankcard)localObject3).field_desc);
      break label410;
      localObject1 = ((Bankcard)localObject3).field_forbidWord;
      break label494;
      localObject1 = locala.getContext().getString(2131765666);
      break label494;
      localObject1 = locala.getContext().getString(2131765677);
      break label494;
      localObject1 = locala.getContext().getString(2131765672);
      break label494;
      localObject1 = locala.getContext().getString(2131765668);
      break label494;
      localObject1 = locala.getContext().getString(2131765664);
      break label494;
      localObject1 = locala.getContext().getString(2131765670);
      break label494;
      localObject1 = locala.getContext().getString(2131765675);
      break label494;
      ((WcPayCashierBankcardItemLayout)localObject4).BJV.setTextColor(locala.getContext().getResources().getColor(2131100711));
      ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(true);
    }
    label1478:
    Object localObject1 = new WcPayCashierBankcardItemLayout(locala.getContext());
    ((WcPayCashierBankcardItemLayout)localObject1).ojf.setVisibility(4);
    ((WcPayCashierBankcardItemLayout)localObject1).BJV.setText(2131765660);
    ((WcPayCashierBankcardItemLayout)localObject1).BJV.setTextColor(locala.getContext().getResources().getColor(2131100547));
    ((WcPayCashierBankcardItemLayout)localObject1).BJX.setVisibility(8);
    Object localObject2 = locala.etV();
    if ((locala.BJR) && (((LinkedList)localObject2).size() > 0))
    {
      ((WcPayCashierBankcardItemLayout)localObject1).BET.setVisibility(0);
      ((WcPayCashierBankcardItemLayout)localObject1).BJW.setVisibility(8);
      ((WcPayCashierBankcardItemLayout)localObject1).BET.setWording((LinkedList)localObject2);
    }
    ((WcPayCashierBankcardItemLayout)localObject1).setOnClickListener(new a.7(locala));
    locala.BJL.addView((View)localObject1);
    localObject2 = "";
    localObject1 = localObject2;
    if (locala.wSu != null)
    {
      localObject1 = localObject2;
      if (locala.wSu.BxR != null)
      {
        localObject1 = localObject2;
        if (locala.wSu.BxR.size() > 0) {
          localObject1 = locala.getContext().getString(2131765187, new Object[] { com.tencent.mm.wallet_core.ui.e.d(locala.wSu.daf, locala.wSu.vxl), ((Orders.Commodity)locala.wSu.BxR.get(0)).desc });
        }
      }
    }
    if ((locala.Bix != null) && (!bs.isNullOrNil(locala.Bix.Bwz)))
    {
      locala.BJM.setVisibility(0);
      locala.BJM.setText(locala.Bix.Bwz);
      locala.Bix.Bwz = "";
    }
    for (;;)
    {
      localObject1 = this.BKA.BJT;
      this.BKQ.add(localObject1);
      this.BKA.BJS = new a.a()
      {
        public final void eoo()
        {
          AppMethodBeat.i(71351);
          ac.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
            WcPayCashierDialog.c(WcPayCashierDialog.this).eoo();
          }
          WcPayCashierDialog.this.dismiss();
          AppMethodBeat.o(71351);
        }
        
        public final void i(Bankcard paramAnonymousBankcard)
        {
          int i = 0;
          AppMethodBeat.i(71350);
          if (paramAnonymousBankcard == null)
          {
            AppMethodBeat.o(71350);
            return;
          }
          ac.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", new Object[] { paramAnonymousBankcard.field_bankName, paramAnonymousBankcard.field_bindSerial });
          if ((WcPayCashierDialog.this.BKF == null) || (!paramAnonymousBankcard.field_bindSerial.equals(WcPayCashierDialog.this.BKF.field_bindSerial)))
          {
            if (WcPayCashierDialog.this.mPayInfo != null) {
              break label202;
            }
            if (WcPayCashierDialog.this.mPayInfo != null) {
              break label216;
            }
          }
          label202:
          label216:
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dac)
          {
            af.f(i, str, 13, paramAnonymousBankcard.field_bindSerial);
            WcPayCashierDialog.this.BKF = paramAnonymousBankcard;
            WcPayCashierDialog.this.Bix = paramFavorPayInfo;
            WcPayCashierDialog.u(WcPayCashierDialog.this);
            WcPayCashierDialog.p(WcPayCashierDialog.this);
            WcPayCashierDialog.q(WcPayCashierDialog.this);
            WcPayCashierDialog.v(WcPayCashierDialog.this);
            WcPayCashierDialog.w(WcPayCashierDialog.this);
            WcPayCashierDialog.E(WcPayCashierDialog.this);
            WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
            WcPayCashierDialog.G(WcPayCashierDialog.this);
            WcPayCashierDialog.this.show();
            AppMethodBeat.o(71350);
            return;
            i = WcPayCashierDialog.this.mPayInfo.dqL;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(71352);
          ac.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          WcPayCashierDialog.this.show();
          AppMethodBeat.o(71352);
        }
      };
      this.BKA.show();
      AppMethodBeat.o(71394);
      return;
      if (locala.BJQ != 0)
      {
        locala.BJM.setVisibility(0);
        locala.BJM.setText((CharSequence)localObject1);
      }
      else
      {
        locala.BJM.setVisibility(8);
      }
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.dqL == 31) || (paramPayInfo.dqL == 32) || (paramPayInfo.dqL == 33));
  }
  
  private static void aA(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71390);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((locala.type() == 1) && ((locala.cGZ()) || (locala.cHc())) && (com.tencent.mm.plugin.soter.e.b.dTB()) && (com.tencent.mm.plugin.soter.e.b.dTA()) && (com.tencent.soter.core.a.fDd() == 0))
    {
      ac.i("MicroMsg.WcPayCashierDialog", "may treble init error");
      com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 23);
      if (locala.type() == 2)
      {
        if (com.tencent.soter.core.a.fDd() != 0) {
          break label246;
        }
        com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 28);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 27);
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 33);
      }
      AppMethodBeat.o(71390);
      return;
      if (locala.type() != 2) {
        break;
      }
      if (com.tencent.soter.core.a.fDd() == 1)
      {
        if (!com.tencent.soter.core.a.fDf())
        {
          ac.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
          com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 24);
          break;
        }
        if (paramBoolean1) {
          break;
        }
        ac.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
        com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 25);
        break;
      }
      if (paramBoolean1) {
        break;
      }
      ac.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
      com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 26);
      break;
      label246:
      com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 31);
    }
  }
  
  private void etY()
  {
    AppMethodBeat.i(71366);
    if (!this.BKu.isShown())
    {
      this.BKu.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772137);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.BKu.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71366);
  }
  
  private void etZ()
  {
    AppMethodBeat.i(71367);
    if (this.BKu.isShown())
    {
      this.BKu.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772138);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.BKu.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71367);
  }
  
  private void eua()
  {
    AppMethodBeat.i(71373);
    Object localObject1 = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(this.wSu);
    if (localObject1 != null) {
      if ((this.Bix != null) && (this.BKF != null)) {
        if (!this.BKF.field_bankcardType.equalsIgnoreCase("CFT")) {
          break label452;
        }
      }
    }
    label195:
    label452:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { this.Bix.Bwv, Boolean.valueOf(bool) });
      String str = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).cb(this.Bix.Bwv, bool);
      ac.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str });
      Object localObject3 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).azC(str);
      Object localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).ca(str, true);
      d.a locala1 = (d.a)((Map)localObject3).get(this.BKF.field_bindSerial);
      d.a locala2 = (d.a)((Map)localObject2).get(this.BKF.field_bankcardType);
      j localj = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).bZ(str, bool);
      if (localj == null)
      {
        localObject1 = "";
        if (locala1 != null) {
          break label289;
        }
        localObject2 = "";
        if (locala2 != null) {
          break label298;
        }
      }
      for (localObject3 = "";; localObject3 = locala2.toString())
      {
        ac.i("MicroMsg.WcPayCashierDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((locala1 == null) || (locala1.BBJ == null) || (bs.isNullOrNil(locala1.BBJ.Bhb))) {
          break label308;
        }
        this.Bix.Bwv = locala1.BBJ.Bhb;
        AppMethodBeat.o(71373);
        return;
        localObject1 = localj.Bhb;
        break;
        localObject2 = locala1.toString();
        break label195;
      }
      if ((locala2 != null) && (locala2.BBJ != null) && (!bs.isNullOrNil(locala2.BBJ.Bhb)))
      {
        this.Bix.Bwv = locala2.BBJ.Bhb;
        AppMethodBeat.o(71373);
        return;
      }
      if (localj != null)
      {
        this.Bix.Bwv = localj.Bhb;
        AppMethodBeat.o(71373);
        return;
      }
      this.Bix.Bwv = str;
      AppMethodBeat.o(71373);
      return;
      if (this.wSu.BxS != null)
      {
        this.Bix = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).azH(((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).azI(this.wSu.BxS.BgL));
        AppMethodBeat.o(71373);
        return;
        ac.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
      }
      AppMethodBeat.o(71373);
      return;
    }
  }
  
  private void eub()
  {
    AppMethodBeat.i(71374);
    if (this.BKJ)
    {
      ac.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
      if (this.BKy != null)
      {
        this.BKl.removeView(this.BKy);
        this.BKy = null;
      }
      AppMethodBeat.o(71374);
      return;
    }
    if ((!bs.isNullOrNil(this.wSu.Byj)) && (!bs.isNullOrNil(this.wSu.Byk)))
    {
      this.BKy = new WcPayCashierDetailItemLayout(getContext());
      this.BKl.addView(this.BKy, 0);
      this.BKy.BKa.setVisibility(8);
      this.BKy.BKb.setVisibility(8);
      this.BKy.wMg.setText(2131766038);
      this.BKy.etX();
      if ((this.wSu.Byj.equals("CNY")) && (!bs.isNullOrNil(this.wSu.Byi)))
      {
        localStringBuilder = new StringBuilder(this.wSu.Byk);
        localStringBuilder.append(this.wSu.Byi);
        if ((!bs.isNullOrNil(this.wSu.Bym)) && (!bs.isNullOrNil(this.wSu.Byn))) {
          localStringBuilder.append(String.format("(%s%s)", new Object[] { this.wSu.Byn, this.wSu.Byl }));
        }
        this.BKy.oWU.setText(localStringBuilder);
        AppMethodBeat.o(71374);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(this.wSu.Byk);
      localStringBuilder.append(this.wSu.Byi);
      this.BKy.oWU.setText(localStringBuilder);
    }
    AppMethodBeat.o(71374);
  }
  
  private void euc()
  {
    AppMethodBeat.i(71375);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(this.wSu);
    if ((this.Bix == null) || ((locald != null) && (!locald.etd())))
    {
      this.BKl.removeView(this.BKx);
      this.BKx = null;
      AppMethodBeat.o(71375);
      return;
    }
    if (this.BKx == null)
    {
      this.BKx = new WcPayCashierDetailItemLayout(getContext());
      this.BKl.addView(this.BKx);
      this.BKx.wMg.setText(2131766036);
      this.BKx.BKa.setVisibility(8);
      this.BKx.BKb.setVisibility(0);
      this.BKx.oWU.setTextColor(getContext().getResources().getColor(2131099777));
      this.BKx.etX();
      this.BKx.setOnClickListener(new w()
      {
        public final void bWk()
        {
          AppMethodBeat.i(71340);
          int i;
          if (WcPayCashierDialog.this.mPayInfo == null)
          {
            i = 0;
            if (WcPayCashierDialog.this.mPayInfo != null) {
              break label95;
            }
          }
          label95:
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dac)
          {
            af.f(i, str, 12, "");
            WcPayCashierDialog.this.hide();
            if (WcPayCashierDialog.o(WcPayCashierDialog.this) == null) {
              break label109;
            }
            WcPayCashierDialog.o(WcPayCashierDialog.this).dismiss();
            WcPayCashierDialog.a(WcPayCashierDialog.this, null);
            AppMethodBeat.o(71340);
            return;
            i = WcPayCashierDialog.this.mPayInfo.dqL;
            break;
          }
          label109:
          WcPayCashierDialog.a(WcPayCashierDialog.this, n.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.wSu, WcPayCashierDialog.this.Bix.Bwv, new n.b()new DialogInterface.OnCancelListener
          {
            public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
            {
              int i = 0;
              AppMethodBeat.i(71338);
              ac.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", new Object[] { paramAnonymous2FavorPayInfo.Bwv });
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              Object localObject;
              if (WcPayCashierDialog.this.mPayInfo == null)
              {
                if (WcPayCashierDialog.this.mPayInfo != null) {
                  break label226;
                }
                localObject = "";
                label66:
                af.f(i, (String)localObject, 15, paramAnonymous2FavorPayInfo.Bwv);
                localObject = com.tencent.mm.plugin.wallet_core.ui.d.ci(paramAnonymous2FavorPayInfo.Bww, paramAnonymous2FavorPayInfo.Bwx);
                WcPayCashierDialog.this.Bix.Bwz = "";
                if (!com.tencent.mm.plugin.wallet_core.ui.d.a(paramAnonymous2FavorPayInfo, WcPayCashierDialog.this.BKF)) {
                  break label265;
                }
                if (((List)localObject).size() != 0) {
                  break label243;
                }
                paramAnonymous2FavorPayInfo.Bwz = WcPayCashierDialog.this.getContext().getString(2131765258);
                label149:
                WcPayCashierDialog.b(WcPayCashierDialog.this, paramAnonymous2FavorPayInfo);
              }
              for (;;)
              {
                WcPayCashierDialog.p(WcPayCashierDialog.this);
                WcPayCashierDialog.q(WcPayCashierDialog.this);
                WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.r(WcPayCashierDialog.this).oWU);
                AppMethodBeat.o(71338);
                return;
                i = WcPayCashierDialog.this.mPayInfo.dqL;
                break;
                label226:
                localObject = WcPayCashierDialog.this.mPayInfo.dac;
                break label66;
                label243:
                paramAnonymous2FavorPayInfo.Bwz = WcPayCashierDialog.this.getContext().getString(2131765259);
                break label149;
                label265:
                WcPayCashierDialog.this.Bix = paramAnonymous2FavorPayInfo;
                WcPayCashierDialog.this.show();
              }
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(71339);
              ac.i("MicroMsg.WcPayCashierDialog", "on cancel");
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              WcPayCashierDialog.this.show();
              AppMethodBeat.o(71339);
            }
          }));
          AppMethodBeat.o(71340);
        }
      });
    }
    u(this.BKx.oWU);
    AppMethodBeat.o(71375);
  }
  
  private void eud()
  {
    AppMethodBeat.i(71378);
    if ((this.BKl.getChildCount() == 0) && (this.BKw.getVisibility() == 8))
    {
      ac.d("MicroMsg.WcPayCashierDialog", "invisible divider");
      this.pHq.setVisibility(8);
      AppMethodBeat.o(71378);
      return;
    }
    this.pHq.setVisibility(0);
    AppMethodBeat.o(71378);
  }
  
  private void eue()
  {
    AppMethodBeat.i(71379);
    if (!this.BKJ)
    {
      if (this.BKv != null)
      {
        this.BKl.removeView(this.BKv);
        this.BKv = null;
      }
      AppMethodBeat.o(71379);
      return;
    }
    Object localObject1;
    if (this.BKv == null)
    {
      this.BKv = new WcPayCashierDetailItemLayout(getContext());
      this.BKl.addView(this.BKv, 0);
      this.BKv.wMg.setText(2131766040);
      this.BKv.BKa.setVisibility(8);
      this.BKv.BKb.setVisibility(8);
      this.BKv.etX();
      localObject1 = com.tencent.mm.wallet_core.ui.e.adP(7);
    }
    try
    {
      this.BKv.oWU.setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject1));
      this.BKv.oWU.getPaint().setFlags(16);
      str = "";
      localObject1 = str;
      if (!bs.isNullOrNil(this.wSu.Byi))
      {
        localObject1 = str;
        if (!bs.isNullOrNil(this.wSu.Byk)) {
          localObject1 = String.format("%s%s", new Object[] { this.wSu.Byk, this.wSu.Byi });
        }
      }
      str = com.tencent.mm.wallet_core.ui.e.d(this.wSu.daf, this.wSu.vxl);
      if (!bs.isNullOrNil((String)localObject1))
      {
        localObject1 = String.format("%s(%s)", new Object[] { str, localObject1 });
        this.BKv.oWU.setText((CharSequence)localObject1);
        AppMethodBeat.o(71379);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        ac.e("MicroMsg.WcPayCashierDialog", "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
        Object localObject2 = str;
      }
    }
  }
  
  private void euf()
  {
    AppMethodBeat.i(71380);
    if (!this.BKH)
    {
      ac.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
      this.BKw.setVisibility(8);
      AppMethodBeat.o(71380);
      return;
    }
    this.BKw.setVisibility(0);
    this.BKw.wMg.setText(2131766041);
    this.BKw.BKa.setVisibility(0);
    this.BKw.BKb.setVisibility(0);
    this.BKw.etX();
    this.BKw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71341);
        ac.d("MicroMsg.WcPayCashierDialog", "click bankcard item");
        WcPayCashierDialog.s(WcPayCashierDialog.this);
        AppMethodBeat.o(71341);
      }
    });
    this.BKw.BKa.setImageBitmap(null);
    a(this.BKF, this.BKw.BKa);
    if (this.BKF == null) {}
    for (String str = "";; str = this.BKF.field_desc)
    {
      Object localObject = str;
      if (this.BKF != null)
      {
        localObject = str;
        if (this.BKF.eqV()) {
          localObject = com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, str);
        }
      }
      this.BKw.R((CharSequence)localObject);
      AppMethodBeat.o(71380);
      return;
    }
  }
  
  private void eug()
  {
    AppMethodBeat.i(71382);
    euh();
    euk();
    AppMethodBeat.o(71382);
  }
  
  private void euh()
  {
    AppMethodBeat.i(71383);
    Object localObject2 = "";
    Object localObject1;
    if (this.BKN)
    {
      localObject1 = this.BKL;
      this.BKj.setText((CharSequence)localObject1);
      AppMethodBeat.o(71383);
      return;
    }
    if (this.mPayInfo.hbR == null)
    {
      localObject1 = "";
      label51:
      if (bs.isNullOrNil((String)localObject1)) {
        break label214;
      }
    }
    for (;;)
    {
      if ((!bs.isNullOrNil((String)localObject1)) || (this.wSu == null) || (this.wSu.BxR == null)) {
        break label1116;
      }
      Object localObject3 = (Orders.Commodity)this.wSu.BxR.get(0);
      if (localObject3 == null) {
        break label1150;
      }
      localObject1 = ((Orders.Commodity)localObject3).vxa;
      localObject2 = localObject1;
      if (a(this.mPayInfo))
      {
        localObject2 = localObject1;
        if (!bs.isNullOrNil((String)localObject1)) {
          localObject2 = (String)localObject1 + "\n";
        }
        localObject2 = (String)localObject2 + ((Orders.Commodity)localObject3).desc;
      }
      localObject1 = localObject2;
      if (!bs.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = ((Orders.Commodity)localObject3).desc;
      break;
      localObject1 = this.mPayInfo.hbR.getString("extinfo_key_19", "");
      break label51;
      label214:
      if ((this.mPayInfo.dqL == 32) || (this.mPayInfo.dqL == 33))
      {
        String str1 = this.mPayInfo.hbR.getString("extinfo_key_5", "");
        String str2 = this.mPayInfo.hbR.getString("extinfo_key_1", "");
        localObject3 = getContext().getString(2131765746);
        localObject1 = localObject2;
        if (!bs.isNullOrNil(str1))
        {
          localObject3 = str1;
          localObject1 = str1;
        }
        if (!bs.isNullOrNil(str2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(str2);
          if (localObject2 != null)
          {
            localObject1 = ((com.tencent.mm.storage.ai)localObject2).aaS();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aSP((String)localObject1));
            if (bs.isNullOrNil(this.mPayInfo.wKR)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.wKR + ")")
            {
              localObject1 = bs.u((String)localObject3, new Object[] { (String)localObject1 });
              break;
            }
          }
          ac.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(str2)));
        }
        else
        {
          ac.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        }
      }
      else if (this.mPayInfo.dqL == 31)
      {
        localObject1 = this.mPayInfo.hbR.getString("extinfo_key_1", "");
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.storage.ai)localObject3).aaR();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bs.isNullOrNil(this.mPayInfo.wKR)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.wKR + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131765746, new Object[] { (String)localObject1 });
              break;
            }
          }
          ac.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          ac.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dqL == 42)
      {
        localObject1 = this.mPayInfo.hbR.getString("extinfo_key_1", "");
        if (!bs.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.kernel.g.agS();
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.storage.ai)localObject3).aaR();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bs.isNullOrNil(this.mPayInfo.wKR)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.wKR + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131765739, new Object[] { (String)localObject1 });
              break;
            }
          }
          ac.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          ac.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dqL == 48)
      {
        localObject1 = getContext().getString(2131762090);
      }
      else if (this.mPayInfo.dqL == 49)
      {
        localObject1 = this.mPayInfo.hbR.getString("extinfo_key_1", "");
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject1 = getContext().getString(2131765746, new Object[] { localObject1 });
        }
        else
        {
          ac.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dqL) });
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dqL == 56)
      {
        localObject1 = this.mPayInfo.hbR.getString("extinfo_key_12", "");
        if (bs.isNullOrNil((String)localObject1))
        {
          ac.e("MicroMsg.WcPayCashierDialog", "title is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dqL) });
          localObject1 = localObject2;
        }
      }
      else if ((this.mPayInfo.dqL == 45) || (this.mPayInfo.dqL == 52))
      {
        localObject1 = getContext().getString(2131765498);
      }
      else
      {
        localObject1 = localObject2;
        if (this.mPayInfo.dqL == 11) {
          localObject1 = getContext().getString(2131765034);
        }
      }
    }
    label1116:
    localObject2 = new StringBuilder("orders null?:");
    if (this.wSu == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.w("MicroMsg.WcPayCashierDialog", bool);
      label1150:
      break;
    }
  }
  
  private void eui()
  {
    AppMethodBeat.i(71384);
    if (!bs.isNullOrNil(this.BKK))
    {
      this.BHY.setText(this.BKK);
      this.BHY.setVisibility(0);
      AppMethodBeat.o(71384);
      return;
    }
    this.BHY.setVisibility(8);
    AppMethodBeat.o(71384);
  }
  
  private void euj()
  {
    AppMethodBeat.i(71385);
    if ((this.BKI) && (this.wSu.BxS.BgY != null) && (this.wSu.BxS.BgY.Bgu == 1))
    {
      final com.tencent.mm.plugin.wallet.a.b localb = this.wSu.BxS.BgY;
      this.BKr.setUrl(localb.BgB);
      this.BKs.setText(localb.Bgw);
      if (!bs.isNullOrNil(localb.Bgx)) {
        this.BKs.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(localb.Bgx, true));
      }
      this.BKt.setText(localb.Bgy);
      if (!bs.isNullOrNil(localb.Bgz)) {
        this.BKt.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(localb.Bgz, true));
      }
      this.BKt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71342);
          ac.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
          WcPayCashierDialog.t(WcPayCashierDialog.this);
          WcPayCashierDialog.this.BKF = s.ery().azl(localb.Bgt.vwo);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(WcPayCashierDialog.this.wSu).azH(localb.Bgv);
          ac.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", new Object[] { paramAnonymousView.Bwv });
          if (paramAnonymousView.Bwv.equals("0")) {
            WcPayCashierDialog.u(WcPayCashierDialog.this);
          }
          for (;;)
          {
            WcPayCashierDialog.p(WcPayCashierDialog.this);
            WcPayCashierDialog.q(WcPayCashierDialog.this);
            WcPayCashierDialog.v(WcPayCashierDialog.this);
            WcPayCashierDialog.w(WcPayCashierDialog.this);
            WcPayCashierDialog.x(WcPayCashierDialog.this);
            AppMethodBeat.o(71342);
            return;
            WcPayCashierDialog.this.Bix = paramAnonymousView;
          }
        }
      });
      TR(0);
      AppMethodBeat.o(71385);
      return;
    }
    TR(8);
    AppMethodBeat.o(71385);
  }
  
  private void euk()
  {
    AppMethodBeat.i(71387);
    Object localObject1;
    if (this.BKN) {
      localObject1 = this.BKM;
    }
    for (;;)
    {
      this.BKk.setText((CharSequence)localObject1);
      AppMethodBeat.o(71387);
      return;
      Object localObject2 = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(this.wSu);
      localObject1 = com.tencent.mm.wallet_core.ui.e.d(this.wSu.daf, this.wSu.vxl);
      this.BKJ = false;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).azE(this.Bix.Bwv);
        localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).etg();
        if ((localObject1 != null) && (((j)localObject1).BgS > 0.0D))
        {
          this.BKJ = true;
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject1).BgR, this.wSu.vxl);
        }
        else if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject1).BgR, this.wSu.vxl);
        }
        else
        {
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(this.wSu.daf, this.wSu.vxl);
        }
      }
    }
  }
  
  private void eul()
  {
    AppMethodBeat.i(71388);
    eum();
    ac.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", new Object[] { Integer.valueOf(this.wSu.BxO) });
    if (this.BKC == 0)
    {
      boolean bool;
      if (this.BKD > 0) {
        bool = false;
      }
      for (;;)
      {
        tP(bool);
        AppMethodBeat.o(71388);
        return;
        if (this.BKE == 1)
        {
          this.BKp.setVisibility(8);
          bool = true;
        }
        else
        {
          if (this.BKE != 3) {
            break;
          }
          this.BKp.setText(2131765263);
          this.BKp.setVisibility(0);
          bool = true;
        }
      }
      if (this.mPayInfo.DGL == 100102)
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFM, Boolean.TRUE);
        com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        locala.mh(false);
        locala.mi(false);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFK, Boolean.FALSE);
        this.BKp.setText(2131765270);
      }
      for (;;)
      {
        this.BKp.setTextColor(getContext().getResources().getColor(2131101133));
        this.BKp.setVisibility(0);
        bool = true;
        break;
        this.BKp.setText(2131765263);
      }
    }
    if (this.BKC == 1)
    {
      eun();
      AppMethodBeat.o(71388);
      return;
    }
    if (this.BKC == 2) {
      euo();
    }
    AppMethodBeat.o(71388);
  }
  
  private void eum()
  {
    AppMethodBeat.i(71389);
    ac.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", new Object[] { Integer.valueOf(this.wSu.BxO) });
    com.tencent.mm.plugin.fingerprint.d.a locala;
    boolean bool3;
    if (this.wSu.BxO == 1)
    {
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.cHe()) && (locala.cHf()) && (!locala.cHa()) && (locala.cGZ()) && (locala.cHi()))
      {
        this.BKD = 1;
        bool3 = p.skJ.skL;
        if ((s.ery() == null) || (this.BKD <= 0)) {
          break label484;
        }
      }
    }
    label148:
    label332:
    label484:
    for (boolean bool2 = locala.cHl();; bool2 = true)
    {
      aA(bool2, bool3);
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        bool2 &= bool1;
        if (bool2) {
          break label332;
        }
        p.skJ.skL = true;
        this.BKD = 0;
        this.BKE = 3;
        this.mPayInfo.BxP = true;
        p.skJ.skL = true;
      }
      for (;;)
      {
        this.BKC = this.BKD;
        ac.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(this.mPayInfo.DGL), Integer.valueOf(this.BKC), Integer.valueOf(this.BKD) });
        AppMethodBeat.o(71389);
        return;
        if ((locala.cHm()) && (locala.cHn()) && (!locala.cHb()) && (locala.cHc()) && (locala.cHi()))
        {
          this.BKD = 2;
          break;
        }
        this.BKD = 0;
        this.BKE = 2;
        break;
        bool1 = false;
        break label148;
        if ((this.mPayInfo.DGL == 100000) || (this.mPayInfo.DGL == 100102))
        {
          if (this.mPayInfo.DGL == 100000) {
            this.mPayInfo.BIq = 0;
          }
          this.BKD = 0;
          this.BKE = 4;
        }
      }
      this.BKC = 0;
      this.BKD = 0;
      this.BKE = 1;
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.cHe()) && (locala.cHf()) && (!locala.cHa()) && (locala.cGZ()))
      {
        ac.w("MicroMsg.WcPayCashierDialog", "wired case");
        com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 2);
      }
      AppMethodBeat.o(71389);
      return;
    }
  }
  
  private void eun()
  {
    AppMethodBeat.i(71392);
    this.BKC = 1;
    this.mPayInfo.BIq = 1;
    this.BKn.setVisibility(8);
    this.BKo.setVisibility(0);
    this.BKm.dtH();
    etZ();
    this.BKh.setVisibility(8);
    this.BKi.setText(2131765750);
    AppMethodBeat.o(71392);
  }
  
  private void euo()
  {
    AppMethodBeat.i(71393);
    this.BKC = 2;
    this.mPayInfo.BIq = 1;
    this.BKn.setVisibility(8);
    this.BKo.setVisibility(0);
    this.BKm.dtH();
    etZ();
    this.BKh.setVisibility(8);
    this.BKi.setText(2131765750);
    AppMethodBeat.o(71393);
  }
  
  private void gB(List<dgh> paramList)
  {
    AppMethodBeat.i(71372);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        dgh localdgh = (dgh)paramList.next();
        WcPayCashierDetailItemLayout localWcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
        localWcPayCashierDetailItemLayout.BKa.setVisibility(8);
        if ((localdgh.FPF != null) && (localdgh.FPF.size() > 0)) {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.wMg, (dhb)localdgh.FPF.get(0), null);
        }
        if ((localdgh.FPG != null) && (localdgh.FPG.size() > 0))
        {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.oWU, (dhb)localdgh.FPG.get(0), null);
          label149:
          if (localdgh.FPH == null) {
            break label267;
          }
          int i = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 8);
          int j = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 16);
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.BKb, localdgh.FPH, 2131689709, i, j, true);
          localWcPayCashierDetailItemLayout.BKb.setVisibility(0);
        }
        for (;;)
        {
          localWcPayCashierDetailItemLayout.etX();
          if (localdgh.DNL != null) {
            localWcPayCashierDetailItemLayout.setOnClickListener(new WcPayCashierDialog.2(this, localdgh));
          }
          this.BKl.addView(localWcPayCashierDetailItemLayout);
          break;
          localWcPayCashierDetailItemLayout.oWU.setVisibility(8);
          localWcPayCashierDetailItemLayout.wMg.setMaxWidth(2147483647);
          break label149;
          label267:
          localWcPayCashierDetailItemLayout.BKb.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(71372);
  }
  
  private void init()
  {
    AppMethodBeat.i(71364);
    initView();
    setCancelable(true);
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71335);
        ac.i("MicroMsg.WcPayCashierDialog", "on canceled");
        WcPayCashierDialog.b(WcPayCashierDialog.this);
        if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
          WcPayCashierDialog.c(WcPayCashierDialog.this).onCancel();
        }
        AppMethodBeat.o(71335);
      }
    });
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71353);
        ac.i("MicroMsg.WcPayCashierDialog", "on dismissed");
        WcPayCashierDialog.b(WcPayCashierDialog.this);
        WcPayCashierDialog.d(WcPayCashierDialog.this);
        AppMethodBeat.o(71353);
      }
    });
    ((MMActivity)this.mContext).getLifecycle().addObserver(this);
    this.Bfa = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71364);
  }
  
  private void initView()
  {
    AppMethodBeat.i(71365);
    this.lyD = ((ViewGroup)View.inflate(getContext(), 2131496055, null));
    this.BJK = ((ImageView)this.lyD.findViewById(2131307031));
    this.BKh = ((TextView)this.lyD.findViewById(2131307035));
    this.BKi = ((TextView)this.lyD.findViewById(2131307045));
    this.BKj = ((TextView)this.lyD.findViewById(2131307040));
    this.BHY = ((TextView)this.lyD.findViewById(2131307030));
    this.BKk = ((WalletTextView)this.lyD.findViewById(2131307041));
    this.BKl = ((ViewGroup)this.lyD.findViewById(2131307034));
    this.BKm = ((EditHintPasswdView)this.lyD.findViewById(2131307043));
    this.BKn = ((ViewGroup)this.lyD.findViewById(2131307044));
    this.BKw = ((WcPayCashierDetailItemLayout)this.lyD.findViewById(2131307042));
    this.BKo = ((Button)this.lyD.findViewById(2131307032));
    this.BKp = ((TextView)this.lyD.findViewById(2131307036));
    this.BKq = ((ViewGroup)this.lyD.findViewById(2131307029));
    this.BKr = ((CdnImageView)this.lyD.findViewById(2131307039));
    this.BKs = ((TextView)this.lyD.findViewById(2131307038));
    this.BKt = ((Button)this.lyD.findViewById(2131307037));
    this.mKeyboard = ((MyKeyboardWindow)this.lyD.findViewById(2131305695));
    this.BKu = ((ViewGroup)this.lyD.findViewById(2131305693));
    this.pHq = this.lyD.findViewById(2131307033);
    Object localObject = this.BJK;
    int i = BKd;
    int j = BKd;
    bs.n((View)localObject, i, i, j, j);
    localObject = com.tencent.mm.ui.am.k(getContext(), 2131689492, getContext().getResources().getColor(2131100019));
    this.BJK.setImageDrawable((Drawable)localObject);
    this.BJK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71354);
        ac.i("MicroMsg.WcPayCashierDialog", "click close icon");
        WcPayCashierDialog.this.cancel();
        AppMethodBeat.o(71354);
      }
    });
    com.tencent.mm.wallet_core.ui.formview.a.a(this.BKm);
    this.BKm.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71355);
        if (paramAnonymousBoolean)
        {
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.e(WcPayCashierDialog.this).getText(), WcPayCashierDialog.this.Bix);
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71355);
      }
    });
    localObject = (EditText)this.lyD.findViewById(2131306718);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject);
    this.mKeyboard.setInputEditText((EditText)localObject);
    if (Build.VERSION.SDK_INT >= 14)
    {
      com.tencent.mm.ui.a.c localc = new com.tencent.mm.ui.a.c();
      this.mKeyboard.setSecureAccessibility(localc);
      ((EditText)localObject).setAccessibilityDelegate(localc);
    }
    ((EditText)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71356);
        WcPayCashierDialog.f(WcPayCashierDialog.this);
        AppMethodBeat.o(71356);
      }
    });
    this.lyD.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71357);
        WcPayCashierDialog.g(WcPayCashierDialog.this);
        AppMethodBeat.o(71357);
      }
    });
    this.BKo.setOnClickListener(new w()
    {
      public final void bWk()
      {
        int i = 0;
        AppMethodBeat.i(71358);
        ac.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", new Object[] { Integer.valueOf(WcPayCashierDialog.h(WcPayCashierDialog.this)) });
        if (WcPayCashierDialog.this.mPayInfo == null) {
          if (WcPayCashierDialog.this.mPayInfo != null) {
            break label113;
          }
        }
        label113:
        for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dac)
        {
          af.f(i, str, 20, "");
          WcPayCashierDialog.i(WcPayCashierDialog.this);
          if (WcPayCashierDialog.h(WcPayCashierDialog.this) != 1) {
            break label127;
          }
          WcPayCashierDialog.j(WcPayCashierDialog.this);
          com.tencent.mm.wallet_core.ui.e.adR(9);
          AppMethodBeat.o(71358);
          return;
          i = WcPayCashierDialog.this.mPayInfo.dqL;
          break;
        }
        label127:
        if (WcPayCashierDialog.h(WcPayCashierDialog.this) == 2)
        {
          WcPayCashierDialog.k(WcPayCashierDialog.this);
          AppMethodBeat.o(71358);
          return;
        }
        ac.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
        WcPayCashierDialog.l(WcPayCashierDialog.this);
        AppMethodBeat.o(71358);
      }
    });
    this.BKi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71359);
        ac.d("MicroMsg.WcPayCashierDialog", "click pay way btn");
        WcPayCashierDialog.m(WcPayCashierDialog.this);
        AppMethodBeat.o(71359);
      }
    });
    AppMethodBeat.o(71365);
  }
  
  private void tP(boolean paramBoolean)
  {
    AppMethodBeat.i(71391);
    ac.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.BKC = 0;
    this.mPayInfo.BIq = 0;
    this.BKn.setVisibility(0);
    this.BKo.setVisibility(8);
    this.BKm.dtH();
    etY();
    this.BKh.setVisibility(0);
    if (paramBoolean)
    {
      this.BKi.setVisibility(8);
      AppMethodBeat.o(71391);
      return;
    }
    this.BKi.setVisibility(0);
    AppMethodBeat.o(71391);
  }
  
  private void u(TextView paramTextView)
  {
    AppMethodBeat.i(71377);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(this.wSu);
    j localj = locald.azE(this.Bix.Bwv);
    List localList = locald.etg();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = "";
    int i;
    if ((localj != null) && (localj.BgS > 0.0D))
    {
      localStringBuilder.append(localj.BgU);
      i = 1;
    }
    for (;;)
    {
      if ((localj != null) && (localj.BgT != 0) && (!bs.aj(localStringBuilder)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(localj.BgV);
      }
      if ((!bs.aj(localStringBuilder)) && (!bs.isNullOrNil((String)localObject)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
        label152:
        localObject = localStringBuilder.toString();
        ac.i("MicroMsg.WcPayCashierDialog", "favor text: %s", new Object[] { localObject });
        if (i == 0) {
          break label335;
        }
        paramTextView.setTextColor(getContext().getResources().getColor(2131099777));
      }
      for (;;)
      {
        paramTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(71377);
        return;
        if (localList.size() <= 0) {
          break label355;
        }
        localObject = locald.etf();
        if ((localj == null) && (locald.ete() == 1) && (localObject != null) && (((j)localObject).BgT == 0) && (this.BKI) && (this.wSu.BxS.BgY != null) && (this.wSu.BxS.BgY.Bgu == 1))
        {
          localObject = getContext().getString(2131765749);
          i = 0;
          break;
        }
        localObject = getContext().getString(2131765742);
        i = 1;
        break;
        if (bs.isNullOrNil((String)localObject)) {
          break label152;
        }
        localStringBuilder.append((String)localObject);
        break label152;
        label335:
        paramTextView.setTextColor(getContext().getResources().getColor(2131100482));
      }
      label355:
      i = 1;
    }
  }
  
  public final void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71370);
    a(paramPayInfo, paramOrders, paramFavorPayInfo, "", paramBankcard, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(71370);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, List<dgh> paramList)
  {
    AppMethodBeat.i(71369);
    this.BKL = paramString1;
    this.BKM = paramString2;
    this.BKK = paramString3;
    this.BKN = true;
    this.BKH = false;
    eul();
    eug();
    eui();
    gB(paramList);
    euf();
    eud();
    AppMethodBeat.o(71369);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71368);
    ac.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
    this.BKm.dtH();
    AppMethodBeat.o(71368);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71363);
    super.onCreate(paramBundle);
    setContentView(this.lyD);
    paramBundle = getWindow();
    paramBundle.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle.addFlags(67108864);
    com.tencent.mm.compatible.util.d.kZ(21);
    AppMethodBeat.o(71363);
  }
  
  public void show()
  {
    AppMethodBeat.i(71376);
    super.show();
    AppMethodBeat.o(71376);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard);
    
    public abstract void eoo();
    
    public abstract void onCancel();
  }
  
  public static abstract interface b
  {
    public abstract void etW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog
 * JD-Core Version:    0.7.0.1
 */