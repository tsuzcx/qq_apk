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
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.d.a;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.b;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.w;
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
  public static final int Dkv;
  public static final int Dkw;
  public static final int Dkx;
  public static final int Dky;
  private com.tencent.mm.plugin.wallet_core.utils.a CFp;
  public FavorPayInfo CIL;
  private TextView Diq;
  private TextView DkA;
  private TextView DkB;
  private WalletTextView DkC;
  private ViewGroup DkD;
  private EditHintPasswdView DkE;
  private ViewGroup DkF;
  private Button DkG;
  private TextView DkH;
  private ViewGroup DkI;
  private CdnImageView DkJ;
  private TextView DkK;
  private Button DkL;
  private ViewGroup DkM;
  private WcPayCashierDetailItemLayout DkN;
  private WcPayCashierDetailItemLayout DkO;
  private WcPayCashierDetailItemLayout DkP;
  private WcPayCashierDetailItemLayout DkQ;
  private WcPayCashierFingerprintDialog DkR;
  private a DkS;
  private n DkT;
  private int DkU;
  private int DkV;
  private int DkW;
  public Bankcard DkX;
  private boolean DkY;
  private boolean DkZ;
  private ImageView Dkc;
  private TextView Dkz;
  private boolean Dla;
  private boolean Dlb;
  private String Dlc;
  private String Dld;
  private String Dle;
  private boolean Dlf;
  private boolean Dlg;
  public a Dlh;
  List<b> Dli;
  private ViewGroup lYb;
  private Context mContext;
  private MyKeyboardWindow mKeyboard;
  public PayInfo mPayInfo;
  private View qkV;
  public Orders ygb;
  
  static
  {
    AppMethodBeat.i(71415);
    Dkv = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 30);
    Dkw = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 32);
    Dkx = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 36);
    Dky = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 23);
    AppMethodBeat.o(71415);
  }
  
  public WcPayCashierDialog(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71361);
    this.DkU = 0;
    this.DkV = 0;
    this.DkW = 0;
    this.mPayInfo = new PayInfo();
    this.ygb = new Orders();
    this.DkY = false;
    this.Dla = true;
    this.Dli = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71361);
  }
  
  public WcPayCashierDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71362);
    this.DkU = 0;
    this.DkV = 0;
    this.DkW = 0;
    this.mPayInfo = new PayInfo();
    this.ygb = new Orders();
    this.DkY = false;
    this.Dla = true;
    this.Dli = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71362);
  }
  
  private void VJ(int paramInt)
  {
    AppMethodBeat.i(71386);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.DkF.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.DkG.getLayoutParams();
    if (paramInt == 0) {
      localLayoutParams1.topMargin = Dky;
    }
    for (localLayoutParams2.topMargin = Dky;; localLayoutParams2.topMargin = Dkx)
    {
      this.DkF.setLayoutParams(localLayoutParams1);
      this.DkG.setLayoutParams(localLayoutParams2);
      this.DkI.setVisibility(paramInt);
      AppMethodBeat.o(71386);
      return;
      localLayoutParams1.topMargin = Dkw;
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
    if (paramBankcard.eER())
    {
      paramCdnImageView.setImageResource(2131234612);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.eES())
    {
      this.CFp.a(paramBankcard, paramCdnImageView);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.eEV())
    {
      paramCdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      if (!bt.isNullOrNil(paramBankcard.CUW))
      {
        paramCdnImageView.setUseSdcardCache(true);
        paramCdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eHa());
        paramCdnImageView.gb(paramBankcard.CUW, 2131690298);
        AppMethodBeat.o(71381);
      }
    }
    else
    {
      this.CFp.a(getContext(), paramBankcard, paramCdnImageView);
    }
    AppMethodBeat.o(71381);
  }
  
  private void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, String paramString, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71371);
    ad.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBankcard });
    this.mPayInfo = paramPayInfo;
    this.ygb = paramOrders;
    this.CIL = paramFavorPayInfo;
    if (!paramBoolean2) {
      this.DkX = paramBankcard;
    }
    this.DkZ = paramBoolean1;
    this.Dlc = paramString;
    eIg();
    eIr();
    eIm();
    eIp();
    eIo();
    eIk();
    eIh();
    gN(this.ygb.field_infos);
    eIi();
    eIl();
    eIj();
    if (paramBoolean2) {
      setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71360);
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.CIL);
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
    if (this.DkS != null) {
      this.DkS.dismiss();
    }
    hide();
    this.DkE.dEe();
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
      this.DkS = new a(this.mContext);
      locala = this.DkS;
      localObject2 = this.mPayInfo;
      localObject3 = this.ygb;
      localObject4 = this.DkX;
      if (localObject4 != null) {
        break label829;
      }
      localObject1 = "";
      ad.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      locala.mPayInfo = ((PayInfo)localObject2);
      locala.ygb = ((Orders)localObject3);
      locala.CIL = paramFavorPayInfo;
      locala.CLY = ((Bankcard)localObject4);
      locala.Dkg = ((Orders)localObject3).CPj;
      locala.Dkh = paramBoolean1;
      locala.Dki = paramInt;
      if (locala.Dkh) {
        locala.Dkj = false;
      }
      if (locala.mPayInfo.dCC != 8) {
        break label839;
      }
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.um(true);
      label241:
      localObject2 = localObject1;
      if (locala.CIL != null)
      {
        if (locala.CIL.CWM == 0) {
          break label851;
        }
        paramInt = 1;
        label266:
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (locala.Dkh) {
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
      locala.Dkf.add(localObject4);
      locala.Dkd.addView((View)localObject4);
      if (!((Bankcard)localObject3).eER()) {
        break label961;
      }
      com.tencent.mm.plugin.wallet_core.utils.a.k(((WcPayCashierBankcardItemLayout)localObject4).oMB);
      label370:
      if (!((Bankcard)localObject3).eER()) {
        break label1165;
      }
      localObject1 = t.eFy().CzB;
      if (bt.isNullOrNil(((Bankcard)localObject1).CUE)) {
        break label1090;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setText(((Bankcard)localObject1).CUE);
      label410:
      localObject1 = "";
      switch (((Bankcard)localObject3).a(locala.Dkg, locala.ygb))
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
          ((WcPayCashierBankcardItemLayout)localObject4).Dko.setOnClickListener(new a.5(locala, (Bankcard)localObject3));
        }
        if (!bt.ai((CharSequence)localObject5))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Dko.setVisibility(0);
          ((WcPayCashierBankcardItemLayout)localObject4).Dko.setText((CharSequence)localObject5);
        }
        if ((locala.Dkj) && (bt.ai((CharSequence)localObject5)))
        {
          localObject1 = locala.g((Bankcard)localObject3);
          if (((LinkedList)localObject1).size() > 0)
          {
            ((WcPayCashierBankcardItemLayout)localObject4).Dfl.setVisibility(0);
            ((WcPayCashierBankcardItemLayout)localObject4).Dko.setVisibility(8);
            ((WcPayCashierBankcardItemLayout)localObject4).Dfl.setWording((LinkedList)localObject1);
          }
        }
        if ((locala.CLY != null) && (((Bankcard)localObject3).field_bindSerial.equals(locala.CLY.field_bindSerial))) {
          ((WcPayCashierBankcardItemLayout)localObject4).Dkp.setChecked(true);
        }
        if (((Bankcard)localObject3).a(locala.Dkg, locala.ygb) != 0)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Dkp.setChecked(false);
          ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setTextColor(locala.getContext().getResources().getColor(2131100482));
          ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(false);
        }
        break;
      }
    }
    for (;;)
    {
      ((WcPayCashierBankcardItemLayout)localObject4).setOnClickListener(new a.6(locala, (Bankcard)localObject3));
      break label295;
      i = this.mPayInfo.dCC;
      break;
      label817:
      localObject1 = this.mPayInfo.dlu;
      break label62;
      label829:
      localObject1 = ((Bankcard)localObject4).field_desc;
      break label123;
      label839:
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.um(false);
      break label241;
      label851:
      paramInt = 0;
      break label266;
      label856:
      localObject3 = locala.CIL.CWN;
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
      if (((Bankcard)localObject3).eES())
      {
        locala.CFp.a((Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).oMB);
        break label370;
      }
      if (((Bankcard)localObject3).eEV())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).oMB.setImageDrawable(com.tencent.mm.svg.a.a.g(locala.getContext().getResources(), 2131690298));
        if (bt.isNullOrNil(((Bankcard)localObject3).CUW)) {
          break label370;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).oMB.setUseSdcardCache(true);
        ((WcPayCashierBankcardItemLayout)localObject4).oMB.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eHa());
        ((WcPayCashierBankcardItemLayout)localObject4).oMB.gb(((Bankcard)localObject3).CUW, 2131690298);
        break label370;
      }
      locala.CFp.a(locala.getContext(), (Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).oMB);
      break label370;
      label1090:
      if (((Bankcard)localObject1).CUD >= 0.0D)
      {
        localObject5 = ((WcPayCashierBankcardItemLayout)localObject4).Dkn;
        Context localContext = locala.getContext();
        locala.getContext();
        ((TextView)localObject5).setText(localContext.getString(ah.fRL(), new Object[] { com.tencent.mm.wallet_core.ui.e.D(((Bankcard)localObject1).CUD) }));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setText("");
      break label410;
      label1165:
      if (((Bankcard)localObject3).eES())
      {
        localObject1 = t.eFy().Dba;
        if (!bt.isNullOrNil(((Bankcard)localObject1).CUE))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setText(((Bankcard)localObject1).CUE);
          break label410;
        }
        if (((Bankcard)localObject1).CUD >= 0.0D)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setText(locala.getContext().getString(2131765386, new Object[] { com.tencent.mm.wallet_core.ui.e.D(((Bankcard)localObject1).CUD) }));
          break label410;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setText("");
        break label410;
      }
      if (((Bankcard)localObject3).eEV())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setText(k.b(locala.getContext(), ((Bankcard)localObject3).field_desc, ((WcPayCashierBankcardItemLayout)localObject4).Dkn.getTextSize()));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setText(((Bankcard)localObject3).field_desc);
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
      ((WcPayCashierBankcardItemLayout)localObject4).Dkn.setTextColor(locala.getContext().getResources().getColor(2131100711));
      ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(true);
    }
    label1478:
    Object localObject1 = new WcPayCashierBankcardItemLayout(locala.getContext());
    ((WcPayCashierBankcardItemLayout)localObject1).oMB.setVisibility(4);
    ((WcPayCashierBankcardItemLayout)localObject1).Dkn.setText(2131765660);
    ((WcPayCashierBankcardItemLayout)localObject1).Dkn.setTextColor(locala.getContext().getResources().getColor(2131100547));
    ((WcPayCashierBankcardItemLayout)localObject1).Dkp.setVisibility(8);
    Object localObject2 = locala.eIb();
    if ((locala.Dkj) && (((LinkedList)localObject2).size() > 0))
    {
      ((WcPayCashierBankcardItemLayout)localObject1).Dfl.setVisibility(0);
      ((WcPayCashierBankcardItemLayout)localObject1).Dko.setVisibility(8);
      ((WcPayCashierBankcardItemLayout)localObject1).Dfl.setWording((LinkedList)localObject2);
    }
    ((WcPayCashierBankcardItemLayout)localObject1).setOnClickListener(new a.7(locala));
    locala.Dkd.addView((View)localObject1);
    localObject2 = "";
    localObject1 = localObject2;
    if (locala.ygb != null)
    {
      localObject1 = localObject2;
      if (locala.ygb.CYk != null)
      {
        localObject1 = localObject2;
        if (locala.ygb.CYk.size() > 0) {
          localObject1 = locala.getContext().getString(2131765187, new Object[] { com.tencent.mm.wallet_core.ui.e.d(locala.ygb.dlx, locala.ygb.wCF), ((Orders.Commodity)locala.ygb.CYk.get(0)).desc });
        }
      }
    }
    if ((locala.CIL != null) && (!bt.isNullOrNil(locala.CIL.CWP)))
    {
      locala.Dke.setVisibility(0);
      locala.Dke.setText(locala.CIL.CWP);
      locala.CIL.CWP = "";
    }
    for (;;)
    {
      localObject1 = this.DkS.Dkl;
      this.Dli.add(localObject1);
      this.DkS.Dkk = new a.a()
      {
        public final void eCm()
        {
          AppMethodBeat.i(71351);
          ad.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
            WcPayCashierDialog.c(WcPayCashierDialog.this).eCm();
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
          if ((WcPayCashierDialog.this.DkX == null) || (!paramAnonymousBankcard.field_bindSerial.equals(WcPayCashierDialog.this.DkX.field_bindSerial)))
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dlu)
          {
            com.tencent.mm.wallet_core.c.af.f(i, str, 13, paramAnonymousBankcard.field_bindSerial);
            WcPayCashierDialog.this.DkX = paramAnonymousBankcard;
            WcPayCashierDialog.this.CIL = paramFavorPayInfo;
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
            i = WcPayCashierDialog.this.mPayInfo.dCC;
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
      this.DkS.show();
      AppMethodBeat.o(71394);
      return;
      if (locala.Dki != 0)
      {
        locala.Dke.setVisibility(0);
        locala.Dke.setText((CharSequence)localObject1);
      }
      else
      {
        locala.Dke.setVisibility(8);
      }
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.dCC == 31) || (paramPayInfo.dCC == 32) || (paramPayInfo.dCC == 33));
  }
  
  private static void aH(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71390);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((locala.type() == 1) && ((locala.cPo()) || (locala.cPr())) && (com.tencent.mm.plugin.soter.e.b.efP()) && (com.tencent.mm.plugin.soter.e.b.efO()) && (com.tencent.soter.core.a.fUv() == 0))
    {
      ad.i("MicroMsg.WcPayCashierDialog", "may treble init error");
      com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 23);
      if (locala.type() == 2)
      {
        if (com.tencent.soter.core.a.fUv() != 0) {
          break label246;
        }
        com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 28);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 27);
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 33);
      }
      AppMethodBeat.o(71390);
      return;
      if (locala.type() != 2) {
        break;
      }
      if (com.tencent.soter.core.a.fUv() == 1)
      {
        if (!com.tencent.soter.core.a.fUx())
        {
          ad.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 24);
          break;
        }
        if (paramBoolean1) {
          break;
        }
        ad.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
        com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 25);
        break;
      }
      if (paramBoolean1) {
        break;
      }
      ad.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
      com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 26);
      break;
      label246:
      com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 31);
    }
  }
  
  private void eIe()
  {
    AppMethodBeat.i(71366);
    if (!this.DkM.isShown())
    {
      this.DkM.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772137);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.DkM.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71366);
  }
  
  private void eIf()
  {
    AppMethodBeat.i(71367);
    if (this.DkM.isShown())
    {
      this.DkM.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772138);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.DkM.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71367);
  }
  
  private void eIg()
  {
    AppMethodBeat.i(71373);
    Object localObject1 = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(this.ygb);
    if (localObject1 != null) {
      if ((this.CIL != null) && (this.DkX != null)) {
        if (!this.DkX.field_bankcardType.equalsIgnoreCase("CFT")) {
          break label452;
        }
      }
    }
    label195:
    label452:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { this.CIL.CWL, Boolean.valueOf(bool) });
      String str = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).cj(this.CIL.CWL, bool);
      ad.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str });
      Object localObject3 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aEM(str);
      Object localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).ci(str, true);
      d.a locala1 = (d.a)((Map)localObject3).get(this.DkX.field_bindSerial);
      d.a locala2 = (d.a)((Map)localObject2).get(this.DkX.field_bankcardType);
      j localj = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).ch(str, bool);
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
        if ((locala1 == null) || (locala1.Dcb == null) || (bt.isNullOrNil(locala1.Dcb.CHp))) {
          break label308;
        }
        this.CIL.CWL = locala1.Dcb.CHp;
        AppMethodBeat.o(71373);
        return;
        localObject1 = localj.CHp;
        break;
        localObject2 = locala1.toString();
        break label195;
      }
      if ((locala2 != null) && (locala2.Dcb != null) && (!bt.isNullOrNil(locala2.Dcb.CHp)))
      {
        this.CIL.CWL = locala2.Dcb.CHp;
        AppMethodBeat.o(71373);
        return;
      }
      if (localj != null)
      {
        this.CIL.CWL = localj.CHp;
        AppMethodBeat.o(71373);
        return;
      }
      this.CIL.CWL = str;
      AppMethodBeat.o(71373);
      return;
      if (this.ygb.CYl != null)
      {
        this.CIL = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aER(((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aES(this.ygb.CYl.CGZ));
        AppMethodBeat.o(71373);
        return;
        ad.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
      }
      AppMethodBeat.o(71373);
      return;
    }
  }
  
  private void eIh()
  {
    AppMethodBeat.i(71374);
    if (this.Dlb)
    {
      ad.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
      if (this.DkQ != null)
      {
        this.DkD.removeView(this.DkQ);
        this.DkQ = null;
      }
      AppMethodBeat.o(71374);
      return;
    }
    if ((!bt.isNullOrNil(this.ygb.CYC)) && (!bt.isNullOrNil(this.ygb.CYD)))
    {
      this.DkQ = new WcPayCashierDetailItemLayout(getContext());
      this.DkD.addView(this.DkQ, 0);
      this.DkQ.Dks.setVisibility(8);
      this.DkQ.Dkt.setVisibility(8);
      this.DkQ.xZN.setText(2131766038);
      this.DkQ.eId();
      if ((this.ygb.CYC.equals("CNY")) && (!bt.isNullOrNil(this.ygb.CYB)))
      {
        localStringBuilder = new StringBuilder(this.ygb.CYD);
        localStringBuilder.append(this.ygb.CYB);
        if ((!bt.isNullOrNil(this.ygb.CYF)) && (!bt.isNullOrNil(this.ygb.CYG))) {
          localStringBuilder.append(String.format("(%s%s)", new Object[] { this.ygb.CYG, this.ygb.CYE }));
        }
        this.DkQ.pAE.setText(localStringBuilder);
        AppMethodBeat.o(71374);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(this.ygb.CYD);
      localStringBuilder.append(this.ygb.CYB);
      this.DkQ.pAE.setText(localStringBuilder);
    }
    AppMethodBeat.o(71374);
  }
  
  private void eIi()
  {
    AppMethodBeat.i(71375);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(this.ygb);
    if ((this.CIL == null) || ((locald != null) && (!locald.eHj())))
    {
      this.DkD.removeView(this.DkP);
      this.DkP = null;
      AppMethodBeat.o(71375);
      return;
    }
    if (this.DkP == null)
    {
      this.DkP = new WcPayCashierDetailItemLayout(getContext());
      this.DkD.addView(this.DkP);
      this.DkP.xZN.setText(2131766036);
      this.DkP.Dks.setVisibility(8);
      this.DkP.Dkt.setVisibility(0);
      this.DkP.pAE.setTextColor(getContext().getResources().getColor(2131099777));
      this.DkP.eId();
      this.DkP.setOnClickListener(new w()
      {
        public final void caN()
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dlu)
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
            i = WcPayCashierDialog.this.mPayInfo.dCC;
            break;
          }
          label109:
          WcPayCashierDialog.a(WcPayCashierDialog.this, n.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.ygb, WcPayCashierDialog.this.CIL.CWL, new n.b()new DialogInterface.OnCancelListener
          {
            public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
            {
              int i = 0;
              AppMethodBeat.i(71338);
              ad.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", new Object[] { paramAnonymous2FavorPayInfo.CWL });
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              Object localObject;
              if (WcPayCashierDialog.this.mPayInfo == null)
              {
                if (WcPayCashierDialog.this.mPayInfo != null) {
                  break label226;
                }
                localObject = "";
                label66:
                com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 15, paramAnonymous2FavorPayInfo.CWL);
                localObject = com.tencent.mm.plugin.wallet_core.ui.d.cq(paramAnonymous2FavorPayInfo.CWM, paramAnonymous2FavorPayInfo.CWN);
                WcPayCashierDialog.this.CIL.CWP = "";
                if (!com.tencent.mm.plugin.wallet_core.ui.d.a(paramAnonymous2FavorPayInfo, WcPayCashierDialog.this.DkX)) {
                  break label265;
                }
                if (((List)localObject).size() != 0) {
                  break label243;
                }
                paramAnonymous2FavorPayInfo.CWP = WcPayCashierDialog.this.getContext().getString(2131765258);
                label149:
                WcPayCashierDialog.b(WcPayCashierDialog.this, paramAnonymous2FavorPayInfo);
              }
              for (;;)
              {
                WcPayCashierDialog.p(WcPayCashierDialog.this);
                WcPayCashierDialog.q(WcPayCashierDialog.this);
                WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.r(WcPayCashierDialog.this).pAE);
                AppMethodBeat.o(71338);
                return;
                i = WcPayCashierDialog.this.mPayInfo.dCC;
                break;
                label226:
                localObject = WcPayCashierDialog.this.mPayInfo.dlu;
                break label66;
                label243:
                paramAnonymous2FavorPayInfo.CWP = WcPayCashierDialog.this.getContext().getString(2131765259);
                break label149;
                label265:
                WcPayCashierDialog.this.CIL = paramAnonymous2FavorPayInfo;
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
    u(this.DkP.pAE);
    AppMethodBeat.o(71375);
  }
  
  private void eIj()
  {
    AppMethodBeat.i(71378);
    if ((this.DkD.getChildCount() == 0) && (this.DkO.getVisibility() == 8))
    {
      ad.d("MicroMsg.WcPayCashierDialog", "invisible divider");
      this.qkV.setVisibility(8);
      AppMethodBeat.o(71378);
      return;
    }
    this.qkV.setVisibility(0);
    AppMethodBeat.o(71378);
  }
  
  private void eIk()
  {
    AppMethodBeat.i(71379);
    if (!this.Dlb)
    {
      if (this.DkN != null)
      {
        this.DkD.removeView(this.DkN);
        this.DkN = null;
      }
      AppMethodBeat.o(71379);
      return;
    }
    Object localObject1;
    if (this.DkN == null)
    {
      this.DkN = new WcPayCashierDetailItemLayout(getContext());
      this.DkD.addView(this.DkN, 0);
      this.DkN.xZN.setText(2131766040);
      this.DkN.Dks.setVisibility(8);
      this.DkN.Dkt.setVisibility(8);
      this.DkN.eId();
      localObject1 = com.tencent.mm.wallet_core.ui.e.agp(7);
    }
    try
    {
      this.DkN.pAE.setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject1));
      this.DkN.pAE.getPaint().setFlags(16);
      str = "";
      localObject1 = str;
      if (!bt.isNullOrNil(this.ygb.CYB))
      {
        localObject1 = str;
        if (!bt.isNullOrNil(this.ygb.CYD)) {
          localObject1 = String.format("%s%s", new Object[] { this.ygb.CYD, this.ygb.CYB });
        }
      }
      str = com.tencent.mm.wallet_core.ui.e.d(this.ygb.dlx, this.ygb.wCF);
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject1 = String.format("%s(%s)", new Object[] { str, localObject1 });
        this.DkN.pAE.setText((CharSequence)localObject1);
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
  
  private void eIl()
  {
    AppMethodBeat.i(71380);
    if (!this.DkZ)
    {
      ad.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
      this.DkO.setVisibility(8);
      AppMethodBeat.o(71380);
      return;
    }
    this.DkO.setVisibility(0);
    this.DkO.xZN.setText(2131766041);
    this.DkO.Dks.setVisibility(0);
    this.DkO.Dkt.setVisibility(0);
    this.DkO.eId();
    this.DkO.setOnClickListener(new WcPayCashierDialog.4(this));
    this.DkO.Dks.setImageBitmap(null);
    a(this.DkX, this.DkO.Dks);
    if (this.DkX == null) {}
    for (String str = "";; str = this.DkX.field_desc)
    {
      Object localObject = str;
      if (this.DkX != null)
      {
        localObject = str;
        if (this.DkX.eEV()) {
          localObject = k.c(this.mContext, str);
        }
      }
      this.DkO.Q((CharSequence)localObject);
      AppMethodBeat.o(71380);
      return;
    }
  }
  
  private void eIm()
  {
    AppMethodBeat.i(71382);
    eIn();
    eIq();
    AppMethodBeat.o(71382);
  }
  
  private void eIn()
  {
    AppMethodBeat.i(71383);
    Object localObject2 = "";
    Object localObject1;
    if (this.Dlf)
    {
      localObject1 = this.Dld;
      this.DkB.setText((CharSequence)localObject1);
      AppMethodBeat.o(71383);
      return;
    }
    if (this.mPayInfo.htZ == null)
    {
      localObject1 = "";
      label51:
      if (bt.isNullOrNil((String)localObject1)) {
        break label214;
      }
    }
    for (;;)
    {
      if ((!bt.isNullOrNil((String)localObject1)) || (this.ygb == null) || (this.ygb.CYk == null)) {
        break label1116;
      }
      Object localObject3 = (Orders.Commodity)this.ygb.CYk.get(0);
      if (localObject3 == null) {
        break label1150;
      }
      localObject1 = ((Orders.Commodity)localObject3).wCu;
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
      localObject1 = this.mPayInfo.htZ.getString("extinfo_key_19", "");
      break label51;
      label214:
      if ((this.mPayInfo.dCC == 32) || (this.mPayInfo.dCC == 33))
      {
        String str1 = this.mPayInfo.htZ.getString("extinfo_key_5", "");
        String str2 = this.mPayInfo.htZ.getString("extinfo_key_1", "");
        localObject3 = getContext().getString(2131765746);
        localObject1 = localObject2;
        if (!bt.isNullOrNil(str1))
        {
          localObject3 = str1;
          localObject1 = str1;
        }
        if (!bt.isNullOrNil(str2))
        {
          localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj(str2);
          if (localObject2 != null)
          {
            localObject1 = ((am)localObject2).adv();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aYO((String)localObject1));
            if (bt.isNullOrNil(this.mPayInfo.xYy)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.xYy + ")")
            {
              localObject1 = bt.x((String)localObject3, new Object[] { (String)localObject1 });
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
      else if (this.mPayInfo.dCC == 31)
      {
        localObject1 = this.mPayInfo.htZ.getString("extinfo_key_1", "");
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((am)localObject3).adu();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bt.isNullOrNil(this.mPayInfo.xYy)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.xYy + ")")
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
      else if (this.mPayInfo.dCC == 42)
      {
        localObject1 = this.mPayInfo.htZ.getString("extinfo_key_1", "");
        if (!bt.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.kernel.g.ajD();
          localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((am)localObject3).adu();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bt.isNullOrNil(this.mPayInfo.xYy)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.xYy + ")")
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
      else if (this.mPayInfo.dCC == 48)
      {
        localObject1 = getContext().getString(2131762090);
      }
      else if (this.mPayInfo.dCC == 49)
      {
        localObject1 = this.mPayInfo.htZ.getString("extinfo_key_1", "");
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject1 = getContext().getString(2131765746, new Object[] { localObject1 });
        }
        else
        {
          ad.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dCC) });
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dCC == 56)
      {
        localObject1 = this.mPayInfo.htZ.getString("extinfo_key_12", "");
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.e("MicroMsg.WcPayCashierDialog", "title is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dCC) });
          localObject1 = localObject2;
        }
      }
      else if ((this.mPayInfo.dCC == 45) || (this.mPayInfo.dCC == 52))
      {
        localObject1 = getContext().getString(2131765498);
      }
      else
      {
        localObject1 = localObject2;
        if (this.mPayInfo.dCC == 11) {
          localObject1 = getContext().getString(2131765034);
        }
      }
    }
    label1116:
    localObject2 = new StringBuilder("orders null?:");
    if (this.ygb == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.w("MicroMsg.WcPayCashierDialog", bool);
      label1150:
      break;
    }
  }
  
  private void eIo()
  {
    AppMethodBeat.i(71384);
    if (!bt.isNullOrNil(this.Dlc))
    {
      this.Diq.setText(this.Dlc);
      this.Diq.setVisibility(0);
      AppMethodBeat.o(71384);
      return;
    }
    this.Diq.setVisibility(8);
    AppMethodBeat.o(71384);
  }
  
  private void eIp()
  {
    AppMethodBeat.i(71385);
    if ((this.Dla) && (this.ygb.CYl.CHm != null) && (this.ygb.CYl.CHm.CGI == 1))
    {
      final com.tencent.mm.plugin.wallet.a.b localb = this.ygb.CYl.CHm;
      this.DkJ.setUrl(localb.CGP);
      this.DkK.setText(localb.CGK);
      if (!bt.isNullOrNil(localb.CGL)) {
        this.DkK.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(localb.CGL, true));
      }
      this.DkL.setText(localb.CGM);
      if (!bt.isNullOrNil(localb.CGN)) {
        this.DkL.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(localb.CGN, true));
      }
      this.DkL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
          WcPayCashierDialog.t(WcPayCashierDialog.this);
          WcPayCashierDialog.this.DkX = t.eFy().aEt(localb.CGH.wBI);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(WcPayCashierDialog.this.ygb).aER(localb.CGJ);
          ad.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", new Object[] { paramAnonymousView.CWL });
          if (paramAnonymousView.CWL.equals("0")) {
            WcPayCashierDialog.u(WcPayCashierDialog.this);
          }
          for (;;)
          {
            WcPayCashierDialog.p(WcPayCashierDialog.this);
            WcPayCashierDialog.q(WcPayCashierDialog.this);
            WcPayCashierDialog.v(WcPayCashierDialog.this);
            WcPayCashierDialog.w(WcPayCashierDialog.this);
            WcPayCashierDialog.x(WcPayCashierDialog.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71342);
            return;
            WcPayCashierDialog.this.CIL = paramAnonymousView;
          }
        }
      });
      VJ(0);
      AppMethodBeat.o(71385);
      return;
    }
    VJ(8);
    AppMethodBeat.o(71385);
  }
  
  private void eIq()
  {
    AppMethodBeat.i(71387);
    Object localObject1;
    if (this.Dlf) {
      localObject1 = this.Dle;
    }
    for (;;)
    {
      this.DkC.setText((CharSequence)localObject1);
      AppMethodBeat.o(71387);
      return;
      Object localObject2 = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(this.ygb);
      localObject1 = com.tencent.mm.wallet_core.ui.e.d(this.ygb.dlx, this.ygb.wCF);
      this.Dlb = false;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).aEO(this.CIL.CWL);
        localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).eHm();
        if ((localObject1 != null) && (((j)localObject1).CHg > 0.0D))
        {
          this.Dlb = true;
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject1).CHf, this.ygb.wCF);
        }
        else if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject1).CHf, this.ygb.wCF);
        }
        else
        {
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(this.ygb.dlx, this.ygb.wCF);
        }
      }
    }
  }
  
  private void eIr()
  {
    AppMethodBeat.i(71388);
    eIs();
    ad.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", new Object[] { Integer.valueOf(this.ygb.CYh) });
    if (this.DkU == 0)
    {
      boolean bool;
      if (this.DkV > 0) {
        bool = false;
      }
      for (;;)
      {
        uz(bool);
        AppMethodBeat.o(71388);
        return;
        if (this.DkW == 1)
        {
          this.DkH.setVisibility(8);
          bool = true;
        }
        else
        {
          if (this.DkW != 3) {
            break;
          }
          this.DkH.setText(2131765263);
          this.DkH.setVisibility(0);
          bool = true;
        }
      }
      if (this.mPayInfo.FlS == 100102)
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ise, Boolean.TRUE);
        com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        locala.my(false);
        locala.mz(false);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Isc, Boolean.FALSE);
        this.DkH.setText(2131765270);
      }
      for (;;)
      {
        this.DkH.setTextColor(getContext().getResources().getColor(2131101133));
        this.DkH.setVisibility(0);
        bool = true;
        break;
        this.DkH.setText(2131765263);
      }
    }
    if (this.DkU == 1)
    {
      eIt();
      AppMethodBeat.o(71388);
      return;
    }
    if (this.DkU == 2) {
      eIu();
    }
    AppMethodBeat.o(71388);
  }
  
  private void eIs()
  {
    AppMethodBeat.i(71389);
    ad.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", new Object[] { Integer.valueOf(this.ygb.CYh) });
    com.tencent.mm.plugin.fingerprint.d.a locala;
    boolean bool3;
    if (this.ygb.CYh == 1)
    {
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.cPt()) && (locala.cPu()) && (!locala.cPp()) && (locala.cPo()) && (locala.cPx()))
      {
        this.DkV = 1;
        bool3 = p.thl.thn;
        if ((t.eFy() == null) || (this.DkV <= 0)) {
          break label484;
        }
      }
    }
    label148:
    label332:
    label484:
    for (boolean bool2 = locala.cPA();; bool2 = true)
    {
      aH(bool2, bool3);
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        bool2 &= bool1;
        if (bool2) {
          break label332;
        }
        p.thl.thn = true;
        this.DkV = 0;
        this.DkW = 3;
        this.mPayInfo.CYi = true;
        p.thl.thn = true;
      }
      for (;;)
      {
        this.DkU = this.DkV;
        ad.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(this.mPayInfo.FlS), Integer.valueOf(this.DkU), Integer.valueOf(this.DkV) });
        AppMethodBeat.o(71389);
        return;
        if ((locala.cPB()) && (locala.cPC()) && (!locala.cPq()) && (locala.cPr()) && (locala.cPx()))
        {
          this.DkV = 2;
          break;
        }
        this.DkV = 0;
        this.DkW = 2;
        break;
        bool1 = false;
        break label148;
        if ((this.mPayInfo.FlS == 100000) || (this.mPayInfo.FlS == 100102))
        {
          if (this.mPayInfo.FlS == 100000) {
            this.mPayInfo.DiI = 0;
          }
          this.DkV = 0;
          this.DkW = 4;
        }
      }
      this.DkU = 0;
      this.DkV = 0;
      this.DkW = 1;
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.cPt()) && (locala.cPu()) && (!locala.cPp()) && (locala.cPo()))
      {
        ad.w("MicroMsg.WcPayCashierDialog", "wired case");
        com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 2);
      }
      AppMethodBeat.o(71389);
      return;
    }
  }
  
  private void eIt()
  {
    AppMethodBeat.i(71392);
    this.DkU = 1;
    this.mPayInfo.DiI = 1;
    this.DkF.setVisibility(8);
    this.DkG.setVisibility(0);
    this.DkE.dEe();
    eIf();
    this.Dkz.setVisibility(8);
    this.DkA.setText(2131765750);
    AppMethodBeat.o(71392);
  }
  
  private void eIu()
  {
    AppMethodBeat.i(71393);
    this.DkU = 2;
    this.mPayInfo.DiI = 1;
    this.DkF.setVisibility(8);
    this.DkG.setVisibility(0);
    this.DkE.dEe();
    eIf();
    this.Dkz.setVisibility(8);
    this.DkA.setText(2131765750);
    AppMethodBeat.o(71393);
  }
  
  private void gN(List<dlu> paramList)
  {
    AppMethodBeat.i(71372);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        dlu localdlu = (dlu)paramList.next();
        WcPayCashierDetailItemLayout localWcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
        localWcPayCashierDetailItemLayout.Dks.setVisibility(8);
        if ((localdlu.HAk != null) && (localdlu.HAk.size() > 0)) {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.xZN, (dmo)localdlu.HAk.get(0), null);
        }
        if ((localdlu.HAl != null) && (localdlu.HAl.size() > 0))
        {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.pAE, (dmo)localdlu.HAl.get(0), null);
          label149:
          if (localdlu.HAm == null) {
            break label267;
          }
          int i = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
          int j = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 16);
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.Dkt, localdlu.HAm, 2131689709, i, j, true);
          localWcPayCashierDetailItemLayout.Dkt.setVisibility(0);
        }
        for (;;)
        {
          localWcPayCashierDetailItemLayout.eId();
          if (localdlu.FsR != null) {
            localWcPayCashierDetailItemLayout.setOnClickListener(new WcPayCashierDialog.2(this, localdlu));
          }
          this.DkD.addView(localWcPayCashierDetailItemLayout);
          break;
          localWcPayCashierDetailItemLayout.pAE.setVisibility(8);
          localWcPayCashierDetailItemLayout.xZN.setMaxWidth(2147483647);
          break label149;
          label267:
          localWcPayCashierDetailItemLayout.Dkt.setVisibility(8);
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
    this.CFp = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71364);
  }
  
  private void initView()
  {
    AppMethodBeat.i(71365);
    this.lYb = ((ViewGroup)View.inflate(getContext(), 2131496055, null));
    this.Dkc = ((ImageView)this.lYb.findViewById(2131307031));
    this.Dkz = ((TextView)this.lYb.findViewById(2131307035));
    this.DkA = ((TextView)this.lYb.findViewById(2131307045));
    this.DkB = ((TextView)this.lYb.findViewById(2131307040));
    this.Diq = ((TextView)this.lYb.findViewById(2131307030));
    this.DkC = ((WalletTextView)this.lYb.findViewById(2131307041));
    this.DkD = ((ViewGroup)this.lYb.findViewById(2131307034));
    this.DkE = ((EditHintPasswdView)this.lYb.findViewById(2131307043));
    this.DkF = ((ViewGroup)this.lYb.findViewById(2131307044));
    this.DkO = ((WcPayCashierDetailItemLayout)this.lYb.findViewById(2131307042));
    this.DkG = ((Button)this.lYb.findViewById(2131307032));
    this.DkH = ((TextView)this.lYb.findViewById(2131307036));
    this.DkI = ((ViewGroup)this.lYb.findViewById(2131307029));
    this.DkJ = ((CdnImageView)this.lYb.findViewById(2131307039));
    this.DkK = ((TextView)this.lYb.findViewById(2131307038));
    this.DkL = ((Button)this.lYb.findViewById(2131307037));
    this.mKeyboard = ((MyKeyboardWindow)this.lYb.findViewById(2131305695));
    this.DkM = ((ViewGroup)this.lYb.findViewById(2131305693));
    this.qkV = this.lYb.findViewById(2131307033);
    Object localObject = this.Dkc;
    int i = Dkv;
    int j = Dkv;
    bt.n((View)localObject, i, i, j, j);
    localObject = ao.k(getContext(), 2131689492, getContext().getResources().getColor(2131100019));
    this.Dkc.setImageDrawable((Drawable)localObject);
    this.Dkc.setOnClickListener(new WcPayCashierDialog.10(this));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.DkE);
    this.DkE.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71355);
        if (paramAnonymousBoolean)
        {
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.e(WcPayCashierDialog.this).getText(), WcPayCashierDialog.this.CIL);
          com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71355);
      }
    });
    localObject = (EditText)this.lYb.findViewById(2131306718);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject);
    this.mKeyboard.setInputEditText((EditText)localObject);
    if (Build.VERSION.SDK_INT >= 14)
    {
      com.tencent.mm.ui.a.c localc = new com.tencent.mm.ui.a.c();
      this.mKeyboard.setSecureAccessibility(localc);
      ((EditText)localObject).setAccessibilityDelegate(localc);
    }
    ((EditText)localObject).setOnClickListener(new WcPayCashierDialog.12(this));
    this.lYb.findViewById(2131305696).setOnClickListener(new WcPayCashierDialog.13(this));
    this.DkG.setOnClickListener(new w()
    {
      public final void caN()
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
        for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dlu)
        {
          com.tencent.mm.wallet_core.c.af.f(i, str, 20, "");
          WcPayCashierDialog.i(WcPayCashierDialog.this);
          if (WcPayCashierDialog.h(WcPayCashierDialog.this) != 1) {
            break label127;
          }
          WcPayCashierDialog.j(WcPayCashierDialog.this);
          com.tencent.mm.wallet_core.ui.e.agr(9);
          AppMethodBeat.o(71358);
          return;
          i = WcPayCashierDialog.this.mPayInfo.dCC;
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
    this.DkA.setOnClickListener(new WcPayCashierDialog.15(this));
    AppMethodBeat.o(71365);
  }
  
  private void u(TextView paramTextView)
  {
    AppMethodBeat.i(71377);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(this.ygb);
    j localj = locald.aEO(this.CIL.CWL);
    List localList = locald.eHm();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = "";
    int i;
    if ((localj != null) && (localj.CHg > 0.0D))
    {
      localStringBuilder.append(localj.CHi);
      i = 1;
    }
    for (;;)
    {
      if ((localj != null) && (localj.CHh != 0) && (!bt.ai(localStringBuilder)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(localj.CHj);
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
        localObject = locald.eHl();
        if ((localj == null) && (locald.eHk() == 1) && (localObject != null) && (((j)localObject).CHh == 0) && (this.Dla) && (this.ygb.CYl.CHm != null) && (this.ygb.CYl.CHm.CGI == 1))
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
  
  private void uz(boolean paramBoolean)
  {
    AppMethodBeat.i(71391);
    ad.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.DkU = 0;
    this.mPayInfo.DiI = 0;
    this.DkF.setVisibility(0);
    this.DkG.setVisibility(8);
    this.DkE.dEe();
    eIe();
    this.Dkz.setVisibility(0);
    if (paramBoolean)
    {
      this.DkA.setVisibility(8);
      AppMethodBeat.o(71391);
      return;
    }
    this.DkA.setVisibility(0);
    AppMethodBeat.o(71391);
  }
  
  public final void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71370);
    a(paramPayInfo, paramOrders, paramFavorPayInfo, "", paramBankcard, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(71370);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, List<dlu> paramList)
  {
    AppMethodBeat.i(71369);
    this.Dld = paramString1;
    this.Dle = paramString2;
    this.Dlc = paramString3;
    this.Dlf = true;
    this.DkZ = false;
    eIr();
    eIm();
    eIo();
    gN(paramList);
    eIl();
    eIj();
    AppMethodBeat.o(71369);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71368);
    ad.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
    this.DkE.dEe();
    AppMethodBeat.o(71368);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71363);
    super.onCreate(paramBundle);
    setContentView(this.lYb);
    paramBundle = getWindow();
    paramBundle.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle.addFlags(67108864);
    com.tencent.mm.compatible.util.d.ly(21);
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
    
    public abstract void eCm();
    
    public abstract void onCancel();
  }
  
  public static abstract interface b
  {
    public abstract void eIc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog
 * JD-Core Version:    0.7.0.1
 */