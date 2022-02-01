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
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.d.a;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.b;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.v;
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
  public static final int ArJ;
  public static final int ArK;
  public static final int ArL;
  public static final int ArM;
  private TextView ApE;
  private TextView ArN;
  private TextView ArO;
  private TextView ArP;
  private WalletTextView ArQ;
  private ViewGroup ArR;
  private EditHintPasswdView ArS;
  private ViewGroup ArT;
  private Button ArU;
  private TextView ArV;
  private ViewGroup ArW;
  private CdnImageView ArX;
  private TextView ArY;
  private Button ArZ;
  private ImageView Arq;
  private ViewGroup Asa;
  private WcPayCashierDetailItemLayout Asb;
  private WcPayCashierDetailItemLayout Asc;
  private WcPayCashierDetailItemLayout Asd;
  private WcPayCashierDetailItemLayout Ase;
  private WcPayCashierFingerprintDialog Asf;
  private a Asg;
  private n Ash;
  private int Asi;
  private int Asj;
  private int Ask;
  public Bankcard Asl;
  private boolean Asm;
  private boolean Asn;
  private boolean Aso;
  private boolean Asp;
  private String Asq;
  private String Asr;
  private String Ass;
  private boolean Ast;
  private boolean Asu;
  public a Asv;
  List<b> Asw;
  private ViewGroup kWT;
  private Context mContext;
  private MyKeyboardWindow mKeyboard;
  public PayInfo mPayInfo;
  private View pef;
  public Orders vIq;
  private com.tencent.mm.plugin.wallet_core.utils.a zMG;
  public FavorPayInfo zQd;
  
  static
  {
    AppMethodBeat.i(71415);
    ArJ = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 30);
    ArK = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 32);
    ArL = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 36);
    ArM = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 23);
    AppMethodBeat.o(71415);
  }
  
  public WcPayCashierDialog(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71361);
    this.Asi = 0;
    this.Asj = 0;
    this.Ask = 0;
    this.mPayInfo = new PayInfo();
    this.vIq = new Orders();
    this.Asm = false;
    this.Aso = true;
    this.Asw = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71361);
  }
  
  public WcPayCashierDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71362);
    this.Asi = 0;
    this.Asj = 0;
    this.Ask = 0;
    this.mPayInfo = new PayInfo();
    this.vIq = new Orders();
    this.Asm = false;
    this.Aso = true;
    this.Asw = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71362);
  }
  
  private void RI(int paramInt)
  {
    AppMethodBeat.i(71386);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.ArT.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.ArU.getLayoutParams();
    if (paramInt == 0) {
      localLayoutParams1.topMargin = ArM;
    }
    for (localLayoutParams2.topMargin = ArM;; localLayoutParams2.topMargin = ArL)
    {
      this.ArT.setLayoutParams(localLayoutParams1);
      this.ArU.setLayoutParams(localLayoutParams2);
      this.ArW.setVisibility(paramInt);
      AppMethodBeat.o(71386);
      return;
      localLayoutParams1.topMargin = ArK;
    }
  }
  
  private void a(Bankcard paramBankcard, CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(71381);
    if (paramBankcard == null)
    {
      ad.e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.ebv())
    {
      paramCdnImageView.setImageResource(2131234612);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.ebw())
    {
      this.zMG.a(paramBankcard, paramCdnImageView);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.ebz())
    {
      paramCdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      if (!bt.isNullOrNil(paramBankcard.Acn))
      {
        paramCdnImageView.setUseSdcardCache(true);
        paramCdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.edz());
        paramCdnImageView.fz(paramBankcard.Acn, 2131690298);
        AppMethodBeat.o(71381);
      }
    }
    else
    {
      this.zMG.a(getContext(), paramBankcard, paramCdnImageView);
    }
    AppMethodBeat.o(71381);
  }
  
  private void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, String paramString, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71371);
    ad.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBankcard });
    this.mPayInfo = paramPayInfo;
    this.vIq = paramOrders;
    this.zQd = paramFavorPayInfo;
    if (!paramBoolean2) {
      this.Asl = paramBankcard;
    }
    this.Asn = paramBoolean1;
    this.Asq = paramString;
    eeF();
    eeQ();
    eeL();
    eeO();
    eeN();
    eeJ();
    eeG();
    gq(this.vIq.field_infos);
    eeH();
    eeK();
    eeI();
    if (paramBoolean2) {
      setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71360);
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.zQd);
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
    ad.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
    if (this.Asg != null) {
      this.Asg.dismiss();
    }
    hide();
    this.ArS.dga();
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
      com.tencent.mm.wallet_core.c.af.f(i, (String)localObject1, 11, "");
      this.Asg = new a(this.mContext);
      locala = this.Asg;
      localObject2 = this.mPayInfo;
      localObject3 = this.vIq;
      localObject4 = this.Asl;
      if (localObject4 != null) {
        break label829;
      }
      localObject1 = "";
      ad.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      locala.mPayInfo = ((PayInfo)localObject2);
      locala.vIq = ((Orders)localObject3);
      locala.zQd = paramFavorPayInfo;
      locala.zTp = ((Bankcard)localObject4);
      locala.Aru = ((Orders)localObject3).zWA;
      locala.Arv = paramBoolean1;
      locala.Arw = paramInt;
      if (locala.Arv) {
        locala.Arx = false;
      }
      if (locala.mPayInfo.dtb != 8) {
        break label839;
      }
      localObject1 = (ArrayList)ae.sB(true);
      label241:
      localObject2 = localObject1;
      if (locala.zQd != null)
      {
        if (locala.zQd.Aec == 0) {
          break label851;
        }
        paramInt = 1;
        label266:
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (locala.Arv) {
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
      locala.Art.add(localObject4);
      locala.Arr.addView((View)localObject4);
      if (!((Bankcard)localObject3).ebv()) {
        break label961;
      }
      com.tencent.mm.plugin.wallet_core.utils.a.j(((WcPayCashierBankcardItemLayout)localObject4).nGe);
      label370:
      if (!((Bankcard)localObject3).ebv()) {
        break label1165;
      }
      localObject1 = s.ecc().zHd;
      if (bt.isNullOrNil(((Bankcard)localObject1).AbV)) {
        break label1090;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).ArB.setText(((Bankcard)localObject1).AbV);
      label410:
      localObject1 = "";
      switch (((Bankcard)localObject3).a(locala.Aru, locala.vIq))
      {
      default: 
        if (!bt.isNullOrNil(((Bankcard)localObject3).field_tips)) {
          localObject1 = ((Bankcard)localObject3).field_tips;
        }
        label494:
        localObject5 = new SpannableStringBuilder((CharSequence)localObject1);
        if ((!bt.isNullOrNil(((Bankcard)localObject3).field_forbid_title)) && (!bt.isNullOrNil(((Bankcard)localObject3).field_forbid_url)))
        {
          ((SpannableStringBuilder)localObject5).append("  ");
          ((SpannableStringBuilder)localObject5).append(((Bankcard)localObject3).field_forbid_title);
          ((SpannableStringBuilder)localObject5).setSpan(new ForegroundColorSpan(locala.getContext().getResources().getColor(2131101107)), ((String)localObject1).length() + 2, ((SpannableStringBuilder)localObject5).length(), 34);
          ((WcPayCashierBankcardItemLayout)localObject4).ArC.setOnClickListener(new a.5(locala, (Bankcard)localObject3));
        }
        if (!bt.ai((CharSequence)localObject5))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).ArC.setVisibility(0);
          ((WcPayCashierBankcardItemLayout)localObject4).ArC.setText((CharSequence)localObject5);
        }
        if ((locala.Arx) && (bt.ai((CharSequence)localObject5)))
        {
          localObject1 = locala.g((Bankcard)localObject3);
          if (((LinkedList)localObject1).size() > 0)
          {
            ((WcPayCashierBankcardItemLayout)localObject4).Amy.setVisibility(0);
            ((WcPayCashierBankcardItemLayout)localObject4).ArC.setVisibility(8);
            ((WcPayCashierBankcardItemLayout)localObject4).Amy.setWording((LinkedList)localObject1);
          }
        }
        if ((locala.zTp != null) && (((Bankcard)localObject3).field_bindSerial.equals(locala.zTp.field_bindSerial))) {
          ((WcPayCashierBankcardItemLayout)localObject4).ArD.setChecked(true);
        }
        if (((Bankcard)localObject3).a(locala.Aru, locala.vIq) != 0)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).ArD.setChecked(false);
          ((WcPayCashierBankcardItemLayout)localObject4).ArB.setTextColor(locala.getContext().getResources().getColor(2131100482));
          ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(false);
        }
        break;
      }
    }
    for (;;)
    {
      ((WcPayCashierBankcardItemLayout)localObject4).setOnClickListener(new a.6(locala, (Bankcard)localObject3));
      break label295;
      i = this.mPayInfo.dtb;
      break;
      label817:
      localObject1 = this.mPayInfo.dcE;
      break label62;
      label829:
      localObject1 = ((Bankcard)localObject4).field_desc;
      break label123;
      label839:
      localObject1 = (ArrayList)ae.sB(false);
      break label241;
      label851:
      paramInt = 0;
      break label266;
      label856:
      localObject3 = locala.zQd.Aed;
      localObject2 = new ArrayList();
      paramInt = 0;
      if (paramInt < ((ArrayList)localObject1).size())
      {
        localObject4 = (Bankcard)((ArrayList)localObject1).get(paramInt);
        if (bt.isNullOrNil((String)localObject3)) {
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
      if (((Bankcard)localObject3).ebw())
      {
        locala.zMG.a((Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).nGe);
        break label370;
      }
      if (((Bankcard)localObject3).ebz())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).nGe.setImageDrawable(com.tencent.mm.svg.a.a.g(locala.getContext().getResources(), 2131690298));
        if (bt.isNullOrNil(((Bankcard)localObject3).Acn)) {
          break label370;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).nGe.setUseSdcardCache(true);
        ((WcPayCashierBankcardItemLayout)localObject4).nGe.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.edz());
        ((WcPayCashierBankcardItemLayout)localObject4).nGe.fz(((Bankcard)localObject3).Acn, 2131690298);
        break label370;
      }
      locala.zMG.a(locala.getContext(), (Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).nGe);
      break label370;
      label1090:
      if (((Bankcard)localObject1).AbU >= 0.0D)
      {
        localObject5 = ((WcPayCashierBankcardItemLayout)localObject4).ArB;
        Context localContext = locala.getContext();
        locala.getContext();
        ((TextView)localObject5).setText(localContext.getString(ah.fkl(), new Object[] { com.tencent.mm.wallet_core.ui.e.E(((Bankcard)localObject1).AbU) }));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).ArB.setText("");
      break label410;
      label1165:
      if (((Bankcard)localObject3).ebw())
      {
        localObject1 = s.ecc().Ain;
        if (!bt.isNullOrNil(((Bankcard)localObject1).AbV))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).ArB.setText(((Bankcard)localObject1).AbV);
          break label410;
        }
        if (((Bankcard)localObject1).AbU >= 0.0D)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).ArB.setText(locala.getContext().getString(2131765386, new Object[] { com.tencent.mm.wallet_core.ui.e.E(((Bankcard)localObject1).AbU) }));
          break label410;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).ArB.setText("");
        break label410;
      }
      if (((Bankcard)localObject3).ebz())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).ArB.setText(com.tencent.mm.pluginsdk.ui.span.k.b(locala.getContext(), ((Bankcard)localObject3).field_desc, ((WcPayCashierBankcardItemLayout)localObject4).ArB.getTextSize()));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).ArB.setText(((Bankcard)localObject3).field_desc);
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
      ((WcPayCashierBankcardItemLayout)localObject4).ArB.setTextColor(locala.getContext().getResources().getColor(2131100711));
      ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(true);
    }
    label1478:
    Object localObject1 = new WcPayCashierBankcardItemLayout(locala.getContext());
    ((WcPayCashierBankcardItemLayout)localObject1).nGe.setVisibility(4);
    ((WcPayCashierBankcardItemLayout)localObject1).ArB.setText(2131765660);
    ((WcPayCashierBankcardItemLayout)localObject1).ArB.setTextColor(locala.getContext().getResources().getColor(2131100547));
    ((WcPayCashierBankcardItemLayout)localObject1).ArD.setVisibility(8);
    Object localObject2 = locala.eeA();
    if ((locala.Arx) && (((LinkedList)localObject2).size() > 0))
    {
      ((WcPayCashierBankcardItemLayout)localObject1).Amy.setVisibility(0);
      ((WcPayCashierBankcardItemLayout)localObject1).ArC.setVisibility(8);
      ((WcPayCashierBankcardItemLayout)localObject1).Amy.setWording((LinkedList)localObject2);
    }
    ((WcPayCashierBankcardItemLayout)localObject1).setOnClickListener(new a.7(locala));
    locala.Arr.addView((View)localObject1);
    localObject2 = "";
    localObject1 = localObject2;
    if (locala.vIq != null)
    {
      localObject1 = localObject2;
      if (locala.vIq.Afx != null)
      {
        localObject1 = localObject2;
        if (locala.vIq.Afx.size() > 0) {
          localObject1 = locala.getContext().getString(2131765187, new Object[] { com.tencent.mm.wallet_core.ui.e.d(locala.vIq.dcH, locala.vIq.uop), ((Orders.Commodity)locala.vIq.Afx.get(0)).desc });
        }
      }
    }
    if ((locala.zQd != null) && (!bt.isNullOrNil(locala.zQd.Aef)))
    {
      locala.Ars.setVisibility(0);
      locala.Ars.setText(locala.zQd.Aef);
      locala.zQd.Aef = "";
    }
    for (;;)
    {
      localObject1 = this.Asg.Arz;
      this.Asw.add(localObject1);
      this.Asg.Ary = new a.a()
      {
        public final void dYS()
        {
          AppMethodBeat.i(71351);
          ad.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
            WcPayCashierDialog.c(WcPayCashierDialog.this).dYS();
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
          ad.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", new Object[] { paramAnonymousBankcard.field_bankName, paramAnonymousBankcard.field_bindSerial });
          if ((WcPayCashierDialog.this.Asl == null) || (!paramAnonymousBankcard.field_bindSerial.equals(WcPayCashierDialog.this.Asl.field_bindSerial)))
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, str, 13, paramAnonymousBankcard.field_bindSerial);
            WcPayCashierDialog.this.Asl = paramAnonymousBankcard;
            WcPayCashierDialog.this.zQd = paramFavorPayInfo;
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
            i = WcPayCashierDialog.this.mPayInfo.dtb;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(71352);
          ad.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          WcPayCashierDialog.this.show();
          AppMethodBeat.o(71352);
        }
      };
      this.Asg.show();
      AppMethodBeat.o(71394);
      return;
      if (locala.Arw != 0)
      {
        locala.Ars.setVisibility(0);
        locala.Ars.setText((CharSequence)localObject1);
      }
      else
      {
        locala.Ars.setVisibility(8);
      }
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.dtb == 31) || (paramPayInfo.dtb == 32) || (paramPayInfo.dtb == 33));
  }
  
  private static void aw(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71390);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((locala.type() == 1) && ((locala.ctN()) || (locala.ctQ())) && (com.tencent.mm.plugin.soter.e.b.dFa()) && (com.tencent.mm.plugin.soter.e.b.dEZ()) && (com.tencent.soter.core.a.fmN() == 0))
    {
      ad.i("MicroMsg.WcPayCashierDialog", "may treble init error");
      com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 23);
      if (locala.type() == 2)
      {
        if (com.tencent.soter.core.a.fmN() != 0) {
          break label246;
        }
        com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 28);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 27);
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 33);
      }
      AppMethodBeat.o(71390);
      return;
      if (locala.type() != 2) {
        break;
      }
      if (com.tencent.soter.core.a.fmN() == 1)
      {
        if (!com.tencent.soter.core.a.fmP())
        {
          ad.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
          com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 24);
          break;
        }
        if (paramBoolean1) {
          break;
        }
        ad.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
        com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 25);
        break;
      }
      if (paramBoolean1) {
        break;
      }
      ad.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
      com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 26);
      break;
      label246:
      com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 31);
    }
  }
  
  private void eeD()
  {
    AppMethodBeat.i(71366);
    if (!this.Asa.isShown())
    {
      this.Asa.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772137);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.Asa.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71366);
  }
  
  private void eeE()
  {
    AppMethodBeat.i(71367);
    if (this.Asa.isShown())
    {
      this.Asa.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772138);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.Asa.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71367);
  }
  
  private void eeF()
  {
    AppMethodBeat.i(71373);
    Object localObject1 = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(this.vIq);
    if (localObject1 != null) {
      if ((this.zQd != null) && (this.Asl != null)) {
        if (!this.Asl.field_bankcardType.equalsIgnoreCase("CFT")) {
          break label452;
        }
      }
    }
    label195:
    label452:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { this.zQd.Aeb, Boolean.valueOf(bool) });
      String str = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).bU(this.zQd.Aeb, bool);
      ad.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str });
      Object localObject3 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).auk(str);
      Object localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).bT(str, true);
      d.a locala1 = (d.a)((Map)localObject3).get(this.Asl.field_bindSerial);
      d.a locala2 = (d.a)((Map)localObject2).get(this.Asl.field_bankcardType);
      j localj = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).bS(str, bool);
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
        ad.i("MicroMsg.WcPayCashierDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((locala1 == null) || (locala1.Ajn == null) || (bt.isNullOrNil(locala1.Ajn.zOH))) {
          break label308;
        }
        this.zQd.Aeb = locala1.Ajn.zOH;
        AppMethodBeat.o(71373);
        return;
        localObject1 = localj.zOH;
        break;
        localObject2 = locala1.toString();
        break label195;
      }
      if ((locala2 != null) && (locala2.Ajn != null) && (!bt.isNullOrNil(locala2.Ajn.zOH)))
      {
        this.zQd.Aeb = locala2.Ajn.zOH;
        AppMethodBeat.o(71373);
        return;
      }
      if (localj != null)
      {
        this.zQd.Aeb = localj.zOH;
        AppMethodBeat.o(71373);
        return;
      }
      this.zQd.Aeb = str;
      AppMethodBeat.o(71373);
      return;
      if (this.vIq.Afy != null)
      {
        this.zQd = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aup(((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).auq(this.vIq.Afy.zOr));
        AppMethodBeat.o(71373);
        return;
        ad.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
      }
      AppMethodBeat.o(71373);
      return;
    }
  }
  
  private void eeG()
  {
    AppMethodBeat.i(71374);
    if (this.Asp)
    {
      ad.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
      if (this.Ase != null)
      {
        this.ArR.removeView(this.Ase);
        this.Ase = null;
      }
      AppMethodBeat.o(71374);
      return;
    }
    if ((!bt.isNullOrNil(this.vIq.AfP)) && (!bt.isNullOrNil(this.vIq.AfQ)))
    {
      this.Ase = new WcPayCashierDetailItemLayout(getContext());
      this.ArR.addView(this.Ase, 0);
      this.Ase.ArG.setVisibility(8);
      this.Ase.ArH.setVisibility(8);
      this.Ase.vCb.setText(2131766038);
      this.Ase.eeC();
      if ((this.vIq.AfP.equals("CNY")) && (!bt.isNullOrNil(this.vIq.AfO)))
      {
        localStringBuilder = new StringBuilder(this.vIq.AfQ);
        localStringBuilder.append(this.vIq.AfO);
        if ((!bt.isNullOrNil(this.vIq.AfS)) && (!bt.isNullOrNil(this.vIq.AfT))) {
          localStringBuilder.append(String.format("(%s%s)", new Object[] { this.vIq.AfT, this.vIq.AfR }));
        }
        this.Ase.ott.setText(localStringBuilder);
        AppMethodBeat.o(71374);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(this.vIq.AfQ);
      localStringBuilder.append(this.vIq.AfO);
      this.Ase.ott.setText(localStringBuilder);
    }
    AppMethodBeat.o(71374);
  }
  
  private void eeH()
  {
    AppMethodBeat.i(71375);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(this.vIq);
    if ((this.zQd == null) || ((locald != null) && (!locald.edI())))
    {
      this.ArR.removeView(this.Asd);
      this.Asd = null;
      AppMethodBeat.o(71375);
      return;
    }
    if (this.Asd == null)
    {
      this.Asd = new WcPayCashierDetailItemLayout(getContext());
      this.ArR.addView(this.Asd);
      this.Asd.vCb.setText(2131766036);
      this.Asd.ArG.setVisibility(8);
      this.Asd.ArH.setVisibility(0);
      this.Asd.ott.setTextColor(getContext().getResources().getColor(2131099777));
      this.Asd.eeC();
      this.Asd.setOnClickListener(new v()
      {
        public final void bOU()
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, str, 12, "");
            WcPayCashierDialog.this.hide();
            if (WcPayCashierDialog.o(WcPayCashierDialog.this) == null) {
              break label109;
            }
            WcPayCashierDialog.o(WcPayCashierDialog.this).dismiss();
            WcPayCashierDialog.a(WcPayCashierDialog.this, null);
            AppMethodBeat.o(71340);
            return;
            i = WcPayCashierDialog.this.mPayInfo.dtb;
            break;
          }
          label109:
          WcPayCashierDialog.a(WcPayCashierDialog.this, n.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.vIq, WcPayCashierDialog.this.zQd.Aeb, new n.b()new DialogInterface.OnCancelListener
          {
            public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
            {
              int i = 0;
              AppMethodBeat.i(71338);
              ad.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", new Object[] { paramAnonymous2FavorPayInfo.Aeb });
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              Object localObject;
              if (WcPayCashierDialog.this.mPayInfo == null)
              {
                if (WcPayCashierDialog.this.mPayInfo != null) {
                  break label226;
                }
                localObject = "";
                label66:
                com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 15, paramAnonymous2FavorPayInfo.Aeb);
                localObject = com.tencent.mm.plugin.wallet_core.ui.d.cf(paramAnonymous2FavorPayInfo.Aec, paramAnonymous2FavorPayInfo.Aed);
                WcPayCashierDialog.this.zQd.Aef = "";
                if (!com.tencent.mm.plugin.wallet_core.ui.d.a(paramAnonymous2FavorPayInfo, WcPayCashierDialog.this.Asl)) {
                  break label265;
                }
                if (((List)localObject).size() != 0) {
                  break label243;
                }
                paramAnonymous2FavorPayInfo.Aef = WcPayCashierDialog.this.getContext().getString(2131765258);
                label149:
                WcPayCashierDialog.b(WcPayCashierDialog.this, paramAnonymous2FavorPayInfo);
              }
              for (;;)
              {
                WcPayCashierDialog.p(WcPayCashierDialog.this);
                WcPayCashierDialog.q(WcPayCashierDialog.this);
                WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.r(WcPayCashierDialog.this).ott);
                AppMethodBeat.o(71338);
                return;
                i = WcPayCashierDialog.this.mPayInfo.dtb;
                break;
                label226:
                localObject = WcPayCashierDialog.this.mPayInfo.dcE;
                break label66;
                label243:
                paramAnonymous2FavorPayInfo.Aef = WcPayCashierDialog.this.getContext().getString(2131765259);
                break label149;
                label265:
                WcPayCashierDialog.this.zQd = paramAnonymous2FavorPayInfo;
                WcPayCashierDialog.this.show();
              }
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(71339);
              ad.i("MicroMsg.WcPayCashierDialog", "on cancel");
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              WcPayCashierDialog.this.show();
              AppMethodBeat.o(71339);
            }
          }));
          AppMethodBeat.o(71340);
        }
      });
    }
    u(this.Asd.ott);
    AppMethodBeat.o(71375);
  }
  
  private void eeI()
  {
    AppMethodBeat.i(71378);
    if ((this.ArR.getChildCount() == 0) && (this.Asc.getVisibility() == 8))
    {
      ad.d("MicroMsg.WcPayCashierDialog", "invisible divider");
      this.pef.setVisibility(8);
      AppMethodBeat.o(71378);
      return;
    }
    this.pef.setVisibility(0);
    AppMethodBeat.o(71378);
  }
  
  private void eeJ()
  {
    AppMethodBeat.i(71379);
    if (!this.Asp)
    {
      if (this.Asb != null)
      {
        this.ArR.removeView(this.Asb);
        this.Asb = null;
      }
      AppMethodBeat.o(71379);
      return;
    }
    Object localObject1;
    if (this.Asb == null)
    {
      this.Asb = new WcPayCashierDetailItemLayout(getContext());
      this.ArR.addView(this.Asb, 0);
      this.Asb.vCb.setText(2131766040);
      this.Asb.ArG.setVisibility(8);
      this.Asb.ArH.setVisibility(8);
      this.Asb.eeC();
      localObject1 = com.tencent.mm.wallet_core.ui.e.abw(7);
    }
    try
    {
      this.Asb.ott.setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject1));
      this.Asb.ott.getPaint().setFlags(16);
      str = "";
      localObject1 = str;
      if (!bt.isNullOrNil(this.vIq.AfO))
      {
        localObject1 = str;
        if (!bt.isNullOrNil(this.vIq.AfQ)) {
          localObject1 = String.format("%s%s", new Object[] { this.vIq.AfQ, this.vIq.AfO });
        }
      }
      str = com.tencent.mm.wallet_core.ui.e.d(this.vIq.dcH, this.vIq.uop);
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject1 = String.format("%s(%s)", new Object[] { str, localObject1 });
        this.Asb.ott.setText((CharSequence)localObject1);
        AppMethodBeat.o(71379);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        ad.e("MicroMsg.WcPayCashierDialog", "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
        Object localObject2 = str;
      }
    }
  }
  
  private void eeK()
  {
    AppMethodBeat.i(71380);
    if (!this.Asn)
    {
      ad.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
      this.Asc.setVisibility(8);
      AppMethodBeat.o(71380);
      return;
    }
    this.Asc.setVisibility(0);
    this.Asc.vCb.setText(2131766041);
    this.Asc.ArG.setVisibility(0);
    this.Asc.ArH.setVisibility(0);
    this.Asc.eeC();
    this.Asc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71341);
        ad.d("MicroMsg.WcPayCashierDialog", "click bankcard item");
        WcPayCashierDialog.s(WcPayCashierDialog.this);
        AppMethodBeat.o(71341);
      }
    });
    this.Asc.ArG.setImageBitmap(null);
    a(this.Asl, this.Asc.ArG);
    if (this.Asl == null) {}
    for (String str = "";; str = this.Asl.field_desc)
    {
      Object localObject = str;
      if (this.Asl != null)
      {
        localObject = str;
        if (this.Asl.ebz()) {
          localObject = com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, str);
        }
      }
      this.Asc.Q((CharSequence)localObject);
      AppMethodBeat.o(71380);
      return;
    }
  }
  
  private void eeL()
  {
    AppMethodBeat.i(71382);
    eeM();
    eeP();
    AppMethodBeat.o(71382);
  }
  
  private void eeM()
  {
    AppMethodBeat.i(71383);
    Object localObject2 = "";
    Object localObject1;
    if (this.Ast)
    {
      localObject1 = this.Asr;
      this.ArP.setText((CharSequence)localObject1);
      AppMethodBeat.o(71383);
      return;
    }
    if (this.mPayInfo.Cos == null)
    {
      localObject1 = "";
      label51:
      if (bt.isNullOrNil((String)localObject1)) {
        break label214;
      }
    }
    for (;;)
    {
      if ((!bt.isNullOrNil((String)localObject1)) || (this.vIq == null) || (this.vIq.Afx == null)) {
        break label1116;
      }
      Object localObject3 = (Orders.Commodity)this.vIq.Afx.get(0);
      if (localObject3 == null) {
        break label1150;
      }
      localObject1 = ((Orders.Commodity)localObject3).uoe;
      localObject2 = localObject1;
      if (a(this.mPayInfo))
      {
        localObject2 = localObject1;
        if (!bt.isNullOrNil((String)localObject1)) {
          localObject2 = (String)localObject1 + "\n";
        }
        localObject2 = (String)localObject2 + ((Orders.Commodity)localObject3).desc;
      }
      localObject1 = localObject2;
      if (!bt.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = ((Orders.Commodity)localObject3).desc;
      break;
      localObject1 = this.mPayInfo.Cos.getString("extinfo_key_19", "");
      break label51;
      label214:
      if ((this.mPayInfo.dtb == 32) || (this.mPayInfo.dtb == 33))
      {
        String str1 = this.mPayInfo.Cos.getString("extinfo_key_5", "");
        String str2 = this.mPayInfo.Cos.getString("extinfo_key_1", "");
        localObject3 = getContext().getString(2131765746);
        localObject1 = localObject2;
        if (!bt.isNullOrNil(str1))
        {
          localObject3 = str1;
          localObject1 = str1;
        }
        if (!bt.isNullOrNil(str2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(str2);
          if (localObject2 != null)
          {
            localObject1 = ((com.tencent.mm.storage.af)localObject2).ZX();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aNm((String)localObject1));
            if (bt.isNullOrNil(this.mPayInfo.vAM)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.vAM + ")")
            {
              localObject1 = bt.u((String)localObject3, new Object[] { (String)localObject1 });
              break;
            }
          }
          ad.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(str2)));
        }
        else
        {
          ad.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        }
      }
      else if (this.mPayInfo.dtb == 31)
      {
        localObject1 = this.mPayInfo.Cos.getString("extinfo_key_1", "");
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.storage.af)localObject3).ZW();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bt.isNullOrNil(this.mPayInfo.vAM)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.vAM + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131765746, new Object[] { (String)localObject1 });
              break;
            }
          }
          ad.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          ad.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dtb == 42)
      {
        localObject1 = this.mPayInfo.Cos.getString("extinfo_key_1", "");
        if (!bt.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.kernel.g.afC();
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.storage.af)localObject3).ZW();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bt.isNullOrNil(this.mPayInfo.vAM)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.vAM + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131765739, new Object[] { (String)localObject1 });
              break;
            }
          }
          ad.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          ad.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dtb == 48)
      {
        localObject1 = getContext().getString(2131762090);
      }
      else if (this.mPayInfo.dtb == 49)
      {
        localObject1 = this.mPayInfo.Cos.getString("extinfo_key_1", "");
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject1 = getContext().getString(2131765746, new Object[] { localObject1 });
        }
        else
        {
          ad.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dtb) });
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dtb == 56)
      {
        localObject1 = this.mPayInfo.Cos.getString("extinfo_key_12", "");
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.e("MicroMsg.WcPayCashierDialog", "title is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dtb) });
          localObject1 = localObject2;
        }
      }
      else if ((this.mPayInfo.dtb == 45) || (this.mPayInfo.dtb == 52))
      {
        localObject1 = getContext().getString(2131765498);
      }
      else
      {
        localObject1 = localObject2;
        if (this.mPayInfo.dtb == 11) {
          localObject1 = getContext().getString(2131765034);
        }
      }
    }
    label1116:
    localObject2 = new StringBuilder("orders null?:");
    if (this.vIq == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.w("MicroMsg.WcPayCashierDialog", bool);
      label1150:
      break;
    }
  }
  
  private void eeN()
  {
    AppMethodBeat.i(71384);
    if (!bt.isNullOrNil(this.Asq))
    {
      this.ApE.setText(this.Asq);
      this.ApE.setVisibility(0);
      AppMethodBeat.o(71384);
      return;
    }
    this.ApE.setVisibility(8);
    AppMethodBeat.o(71384);
  }
  
  private void eeO()
  {
    AppMethodBeat.i(71385);
    if ((this.Aso) && (this.vIq.Afy.zOE != null) && (this.vIq.Afy.zOE.zOa == 1))
    {
      final com.tencent.mm.plugin.wallet.a.b localb = this.vIq.Afy.zOE;
      this.ArX.setUrl(localb.zOh);
      this.ArY.setText(localb.zOc);
      if (!bt.isNullOrNil(localb.zOd)) {
        this.ArY.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(localb.zOd, true));
      }
      this.ArZ.setText(localb.zOe);
      if (!bt.isNullOrNil(localb.zOf)) {
        this.ArZ.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(localb.zOf, true));
      }
      this.ArZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71342);
          ad.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
          WcPayCashierDialog.t(WcPayCashierDialog.this);
          WcPayCashierDialog.this.Asl = s.ecc().atT(localb.zNZ.uns);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(WcPayCashierDialog.this.vIq).aup(localb.zOb);
          ad.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", new Object[] { paramAnonymousView.Aeb });
          if (paramAnonymousView.Aeb.equals("0")) {
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
            WcPayCashierDialog.this.zQd = paramAnonymousView;
          }
        }
      });
      RI(0);
      AppMethodBeat.o(71385);
      return;
    }
    RI(8);
    AppMethodBeat.o(71385);
  }
  
  private void eeP()
  {
    AppMethodBeat.i(71387);
    Object localObject1;
    if (this.Ast) {
      localObject1 = this.Ass;
    }
    for (;;)
    {
      this.ArQ.setText((CharSequence)localObject1);
      AppMethodBeat.o(71387);
      return;
      Object localObject2 = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(this.vIq);
      localObject1 = com.tencent.mm.wallet_core.ui.e.d(this.vIq.dcH, this.vIq.uop);
      this.Asp = false;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).aum(this.zQd.Aeb);
        localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).edL();
        if ((localObject1 != null) && (((j)localObject1).zOy > 0.0D))
        {
          this.Asp = true;
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject1).zOx, this.vIq.uop);
        }
        else if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject1).zOx, this.vIq.uop);
        }
        else
        {
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(this.vIq.dcH, this.vIq.uop);
        }
      }
    }
  }
  
  private void eeQ()
  {
    AppMethodBeat.i(71388);
    eeR();
    ad.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", new Object[] { Integer.valueOf(this.vIq.Afu) });
    if (this.Asi == 0)
    {
      boolean bool;
      if (this.Asj > 0) {
        bool = false;
      }
      for (;;)
      {
        sO(bool);
        AppMethodBeat.o(71388);
        return;
        if (this.Ask == 1)
        {
          this.ArV.setVisibility(8);
          bool = true;
        }
        else
        {
          if (this.Ask != 3) {
            break;
          }
          this.ArV.setText(2131765263);
          this.ArV.setVisibility(0);
          bool = true;
        }
      }
      if (this.mPayInfo.Cot == 100102)
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhX, Boolean.TRUE);
        com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        locala.lp(false);
        locala.lq(false);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhV, Boolean.FALSE);
        this.ArV.setText(2131765270);
      }
      for (;;)
      {
        this.ArV.setTextColor(getContext().getResources().getColor(2131101133));
        this.ArV.setVisibility(0);
        bool = true;
        break;
        this.ArV.setText(2131765263);
      }
    }
    if (this.Asi == 1)
    {
      eeS();
      AppMethodBeat.o(71388);
      return;
    }
    if (this.Asi == 2) {
      eeT();
    }
    AppMethodBeat.o(71388);
  }
  
  private void eeR()
  {
    AppMethodBeat.i(71389);
    ad.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", new Object[] { Integer.valueOf(this.vIq.Afu) });
    com.tencent.mm.plugin.fingerprint.d.a locala;
    boolean bool3;
    if (this.vIq.Afu == 1)
    {
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.ctS()) && (locala.ctT()) && (!locala.ctO()) && (locala.ctN()) && (locala.ctW()))
      {
        this.Asj = 1;
        bool3 = p.rcp.rcr;
        if ((s.ecc() == null) || (this.Asj <= 0)) {
          break label484;
        }
      }
    }
    label148:
    label332:
    label484:
    for (boolean bool2 = locala.ctZ();; bool2 = true)
    {
      aw(bool2, bool3);
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        bool2 &= bool1;
        if (bool2) {
          break label332;
        }
        p.rcp.rcr = true;
        this.Asj = 0;
        this.Ask = 3;
        this.mPayInfo.Afv = true;
        p.rcp.rcr = true;
      }
      for (;;)
      {
        this.Asi = this.Asj;
        ad.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(this.mPayInfo.Cot), Integer.valueOf(this.Asi), Integer.valueOf(this.Asj) });
        AppMethodBeat.o(71389);
        return;
        if ((locala.cua()) && (locala.cub()) && (!locala.ctP()) && (locala.ctQ()) && (locala.ctW()))
        {
          this.Asj = 2;
          break;
        }
        this.Asj = 0;
        this.Ask = 2;
        break;
        bool1 = false;
        break label148;
        if ((this.mPayInfo.Cot == 100000) || (this.mPayInfo.Cot == 100102))
        {
          if (this.mPayInfo.Cot == 100000) {
            this.mPayInfo.ApW = 0;
          }
          this.Asj = 0;
          this.Ask = 4;
        }
      }
      this.Asi = 0;
      this.Asj = 0;
      this.Ask = 1;
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.ctS()) && (locala.ctT()) && (!locala.ctO()) && (locala.ctN()))
      {
        ad.w("MicroMsg.WcPayCashierDialog", "wired case");
        com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 2);
      }
      AppMethodBeat.o(71389);
      return;
    }
  }
  
  private void eeS()
  {
    AppMethodBeat.i(71392);
    this.Asi = 1;
    this.mPayInfo.ApW = 1;
    this.ArT.setVisibility(8);
    this.ArU.setVisibility(0);
    this.ArS.dga();
    eeE();
    this.ArN.setVisibility(8);
    this.ArO.setText(2131765750);
    AppMethodBeat.o(71392);
  }
  
  private void eeT()
  {
    AppMethodBeat.i(71393);
    this.Asi = 2;
    this.mPayInfo.ApW = 1;
    this.ArT.setVisibility(8);
    this.ArU.setVisibility(0);
    this.ArS.dga();
    eeE();
    this.ArN.setVisibility(8);
    this.ArO.setText(2131765750);
    AppMethodBeat.o(71393);
  }
  
  private void gq(List<dav> paramList)
  {
    AppMethodBeat.i(71372);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        dav localdav = (dav)paramList.next();
        WcPayCashierDetailItemLayout localWcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
        localWcPayCashierDetailItemLayout.ArG.setVisibility(8);
        if ((localdav.EsD != null) && (localdav.EsD.size() > 0)) {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.vCb, (dbp)localdav.EsD.get(0), null);
        }
        if ((localdav.EsE != null) && (localdav.EsE.size() > 0))
        {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.ott, (dbp)localdav.EsE.get(0), null);
          label149:
          if (localdav.EsF == null) {
            break label267;
          }
          int i = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8);
          int j = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 16);
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.ArH, localdav.EsF, 2131689709, i, j, true);
          localWcPayCashierDetailItemLayout.ArH.setVisibility(0);
        }
        for (;;)
        {
          localWcPayCashierDetailItemLayout.eeC();
          if (localdav.Cvq != null) {
            localWcPayCashierDetailItemLayout.setOnClickListener(new WcPayCashierDialog.2(this, localdav));
          }
          this.ArR.addView(localWcPayCashierDetailItemLayout);
          break;
          localWcPayCashierDetailItemLayout.ott.setVisibility(8);
          localWcPayCashierDetailItemLayout.vCb.setMaxWidth(2147483647);
          break label149;
          label267:
          localWcPayCashierDetailItemLayout.ArH.setVisibility(8);
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
        ad.i("MicroMsg.WcPayCashierDialog", "on canceled");
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
        ad.i("MicroMsg.WcPayCashierDialog", "on dismissed");
        WcPayCashierDialog.b(WcPayCashierDialog.this);
        WcPayCashierDialog.d(WcPayCashierDialog.this);
        AppMethodBeat.o(71353);
      }
    });
    ((MMActivity)this.mContext).getLifecycle().addObserver(this);
    this.zMG = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71364);
  }
  
  private void initView()
  {
    AppMethodBeat.i(71365);
    this.kWT = ((ViewGroup)View.inflate(getContext(), 2131496055, null));
    this.Arq = ((ImageView)this.kWT.findViewById(2131307031));
    this.ArN = ((TextView)this.kWT.findViewById(2131307035));
    this.ArO = ((TextView)this.kWT.findViewById(2131307045));
    this.ArP = ((TextView)this.kWT.findViewById(2131307040));
    this.ApE = ((TextView)this.kWT.findViewById(2131307030));
    this.ArQ = ((WalletTextView)this.kWT.findViewById(2131307041));
    this.ArR = ((ViewGroup)this.kWT.findViewById(2131307034));
    this.ArS = ((EditHintPasswdView)this.kWT.findViewById(2131307043));
    this.ArT = ((ViewGroup)this.kWT.findViewById(2131307044));
    this.Asc = ((WcPayCashierDetailItemLayout)this.kWT.findViewById(2131307042));
    this.ArU = ((Button)this.kWT.findViewById(2131307032));
    this.ArV = ((TextView)this.kWT.findViewById(2131307036));
    this.ArW = ((ViewGroup)this.kWT.findViewById(2131307029));
    this.ArX = ((CdnImageView)this.kWT.findViewById(2131307039));
    this.ArY = ((TextView)this.kWT.findViewById(2131307038));
    this.ArZ = ((Button)this.kWT.findViewById(2131307037));
    this.mKeyboard = ((MyKeyboardWindow)this.kWT.findViewById(2131305695));
    this.Asa = ((ViewGroup)this.kWT.findViewById(2131305693));
    this.pef = this.kWT.findViewById(2131307033);
    Object localObject = this.Arq;
    int i = ArJ;
    int j = ArJ;
    bt.n((View)localObject, i, i, j, j);
    localObject = com.tencent.mm.ui.am.i(getContext(), 2131689492, getContext().getResources().getColor(2131100019));
    this.Arq.setImageDrawable((Drawable)localObject);
    this.Arq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71354);
        ad.i("MicroMsg.WcPayCashierDialog", "click close icon");
        WcPayCashierDialog.this.cancel();
        AppMethodBeat.o(71354);
      }
    });
    com.tencent.mm.wallet_core.ui.formview.a.a(this.ArS);
    this.ArS.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71355);
        if (paramAnonymousBoolean)
        {
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.e(WcPayCashierDialog.this).getText(), WcPayCashierDialog.this.zQd);
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71355);
      }
    });
    localObject = (EditText)this.kWT.findViewById(2131306718);
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
    this.kWT.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71357);
        WcPayCashierDialog.g(WcPayCashierDialog.this);
        AppMethodBeat.o(71357);
      }
    });
    this.ArU.setOnClickListener(new v()
    {
      public final void bOU()
      {
        int i = 0;
        AppMethodBeat.i(71358);
        ad.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", new Object[] { Integer.valueOf(WcPayCashierDialog.h(WcPayCashierDialog.this)) });
        if (WcPayCashierDialog.this.mPayInfo == null) {
          if (WcPayCashierDialog.this.mPayInfo != null) {
            break label113;
          }
        }
        label113:
        for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dcE)
        {
          com.tencent.mm.wallet_core.c.af.f(i, str, 20, "");
          WcPayCashierDialog.i(WcPayCashierDialog.this);
          if (WcPayCashierDialog.h(WcPayCashierDialog.this) != 1) {
            break label127;
          }
          WcPayCashierDialog.j(WcPayCashierDialog.this);
          com.tencent.mm.wallet_core.ui.e.aby(9);
          AppMethodBeat.o(71358);
          return;
          i = WcPayCashierDialog.this.mPayInfo.dtb;
          break;
        }
        label127:
        if (WcPayCashierDialog.h(WcPayCashierDialog.this) == 2)
        {
          WcPayCashierDialog.k(WcPayCashierDialog.this);
          AppMethodBeat.o(71358);
          return;
        }
        ad.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
        WcPayCashierDialog.l(WcPayCashierDialog.this);
        AppMethodBeat.o(71358);
      }
    });
    this.ArO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71359);
        ad.d("MicroMsg.WcPayCashierDialog", "click pay way btn");
        WcPayCashierDialog.m(WcPayCashierDialog.this);
        AppMethodBeat.o(71359);
      }
    });
    AppMethodBeat.o(71365);
  }
  
  private void sO(boolean paramBoolean)
  {
    AppMethodBeat.i(71391);
    ad.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Asi = 0;
    this.mPayInfo.ApW = 0;
    this.ArT.setVisibility(0);
    this.ArU.setVisibility(8);
    this.ArS.dga();
    eeD();
    this.ArN.setVisibility(0);
    if (paramBoolean)
    {
      this.ArO.setVisibility(8);
      AppMethodBeat.o(71391);
      return;
    }
    this.ArO.setVisibility(0);
    AppMethodBeat.o(71391);
  }
  
  private void u(TextView paramTextView)
  {
    AppMethodBeat.i(71377);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(this.vIq);
    j localj = locald.aum(this.zQd.Aeb);
    List localList = locald.edL();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = "";
    int i;
    if ((localj != null) && (localj.zOy > 0.0D))
    {
      localStringBuilder.append(localj.zOA);
      i = 1;
    }
    for (;;)
    {
      if ((localj != null) && (localj.zOz != 0) && (!bt.ai(localStringBuilder)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(localj.zOB);
      }
      if ((!bt.ai(localStringBuilder)) && (!bt.isNullOrNil((String)localObject)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
        label152:
        localObject = localStringBuilder.toString();
        ad.i("MicroMsg.WcPayCashierDialog", "favor text: %s", new Object[] { localObject });
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
        localObject = locald.edK();
        if ((localj == null) && (locald.edJ() == 1) && (localObject != null) && (((j)localObject).zOz == 0) && (this.Aso) && (this.vIq.Afy.zOE != null) && (this.vIq.Afy.zOE.zOa == 1))
        {
          localObject = getContext().getString(2131765749);
          i = 0;
          break;
        }
        localObject = getContext().getString(2131765742);
        i = 1;
        break;
        if (bt.isNullOrNil((String)localObject)) {
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
  
  public final void a(String paramString1, String paramString2, String paramString3, List<dav> paramList)
  {
    AppMethodBeat.i(71369);
    this.Asr = paramString1;
    this.Ass = paramString2;
    this.Asq = paramString3;
    this.Ast = true;
    this.Asn = false;
    eeQ();
    eeL();
    eeN();
    gq(paramList);
    eeK();
    eeI();
    AppMethodBeat.o(71369);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71368);
    ad.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
    this.ArS.dga();
    AppMethodBeat.o(71368);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71363);
    super.onCreate(paramBundle);
    setContentView(this.kWT);
    paramBundle = getWindow();
    paramBundle.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle.addFlags(67108864);
    com.tencent.mm.compatible.util.d.lf(21);
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
    
    public abstract void dYS();
    
    public abstract void onCancel();
  }
  
  public static abstract interface b
  {
    public abstract void eeB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog
 * JD-Core Version:    0.7.0.1
 */