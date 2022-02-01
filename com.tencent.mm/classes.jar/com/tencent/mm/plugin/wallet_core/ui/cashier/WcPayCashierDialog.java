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
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.d.a;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.b;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
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
  public static final int DBZ;
  public static final int DCa;
  public static final int DCb;
  public static final int DCc;
  private com.tencent.mm.plugin.wallet_core.utils.a CWV;
  private ImageView DBG;
  private int DCA;
  public Bankcard DCB;
  private boolean DCC;
  private boolean DCD;
  private boolean DCE;
  private boolean DCF;
  private String DCG;
  private String DCH;
  private String DCI;
  private boolean DCJ;
  private boolean DCK;
  public a DCL;
  List<b> DCM;
  private TextView DCd;
  private TextView DCe;
  private TextView DCf;
  private WalletTextView DCg;
  private ViewGroup DCh;
  private EditHintPasswdView DCi;
  private ViewGroup DCj;
  private Button DCk;
  private TextView DCl;
  private ViewGroup DCm;
  private CdnImageView DCn;
  private TextView DCo;
  private Button DCp;
  private ViewGroup DCq;
  private WcPayCashierDetailItemLayout DCr;
  private WcPayCashierDetailItemLayout DCs;
  private WcPayCashierDetailItemLayout DCt;
  private WcPayCashierDetailItemLayout DCu;
  private WcPayCashierFingerprintDialog DCv;
  private a DCw;
  private n DCx;
  private int DCy;
  private int DCz;
  public FavorPayInfo Dar;
  private TextView DzU;
  private Context mContext;
  private MyKeyboardWindow mKeyboard;
  public PayInfo mPayInfo;
  private ViewGroup mcI;
  private View qrA;
  public Orders yvS;
  
  static
  {
    AppMethodBeat.i(71415);
    DBZ = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 30);
    DCa = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 32);
    DCb = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 36);
    DCc = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 23);
    AppMethodBeat.o(71415);
  }
  
  public WcPayCashierDialog(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71361);
    this.DCy = 0;
    this.DCz = 0;
    this.DCA = 0;
    this.mPayInfo = new PayInfo();
    this.yvS = new Orders();
    this.DCC = false;
    this.DCE = true;
    this.DCM = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71361);
  }
  
  public WcPayCashierDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71362);
    this.DCy = 0;
    this.DCz = 0;
    this.DCA = 0;
    this.mPayInfo = new PayInfo();
    this.yvS = new Orders();
    this.DCC = false;
    this.DCE = true;
    this.DCM = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71362);
  }
  
  private void Wq(int paramInt)
  {
    AppMethodBeat.i(71386);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.DCj.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.DCk.getLayoutParams();
    if (paramInt == 0) {
      localLayoutParams1.topMargin = DCc;
    }
    for (localLayoutParams2.topMargin = DCc;; localLayoutParams2.topMargin = DCb)
    {
      this.DCj.setLayoutParams(localLayoutParams1);
      this.DCk.setLayoutParams(localLayoutParams2);
      this.DCm.setVisibility(paramInt);
      AppMethodBeat.o(71386);
      return;
      localLayoutParams1.topMargin = DCa;
    }
  }
  
  private void a(Bankcard paramBankcard, CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(71381);
    if (paramBankcard == null)
    {
      ae.e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.eIy())
    {
      paramCdnImageView.setImageResource(2131234612);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.eIz())
    {
      this.CWV.a(paramBankcard, paramCdnImageView);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.eIC())
    {
      paramCdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      if (!bu.isNullOrNil(paramBankcard.DmC))
      {
        paramCdnImageView.setUseSdcardCache(true);
        paramCdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eKI());
        paramCdnImageView.gk(paramBankcard.DmC, 2131690298);
        AppMethodBeat.o(71381);
      }
    }
    else
    {
      this.CWV.a(getContext(), paramBankcard, paramCdnImageView);
    }
    AppMethodBeat.o(71381);
  }
  
  private void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, String paramString, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71371);
    ae.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBankcard });
    this.mPayInfo = paramPayInfo;
    this.yvS = paramOrders;
    this.Dar = paramFavorPayInfo;
    if (!paramBoolean2) {
      this.DCB = paramBankcard;
    }
    this.DCD = paramBoolean1;
    this.DCG = paramString;
    eLO();
    eLZ();
    eLU();
    eLX();
    eLW();
    eLS();
    eLP();
    gX(this.yvS.field_infos);
    eLQ();
    eLT();
    eLR();
    if (paramBoolean2) {
      setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71360);
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.Dar);
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
    ae.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
    if (this.DCw != null) {
      this.DCw.dismiss();
    }
    hide();
    this.DCi.dHv();
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
      this.DCw = new a(this.mContext);
      locala = this.DCw;
      localObject2 = this.mPayInfo;
      localObject3 = this.yvS;
      localObject4 = this.DCB;
      if (localObject4 != null) {
        break label829;
      }
      localObject1 = "";
      ae.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      locala.mPayInfo = ((PayInfo)localObject2);
      locala.yvS = ((Orders)localObject3);
      locala.Dar = paramFavorPayInfo;
      locala.DdG = ((Bankcard)localObject4);
      locala.DBK = ((Orders)localObject3).DgN;
      locala.DBL = paramBoolean1;
      locala.DBM = paramInt;
      if (locala.DBL) {
        locala.DBN = false;
      }
      if (locala.mPayInfo.dDH != 8) {
        break label839;
      }
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.uu(true);
      label241:
      localObject2 = localObject1;
      if (locala.Dar != null)
      {
        if (locala.Dar.Dor == 0) {
          break label851;
        }
        paramInt = 1;
        label266:
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (locala.DBL) {
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
      locala.DBJ.add(localObject4);
      locala.DBH.addView((View)localObject4);
      if (!((Bankcard)localObject3).eIy()) {
        break label961;
      }
      com.tencent.mm.plugin.wallet_core.utils.a.k(((WcPayCashierBankcardItemLayout)localObject4).oTd);
      label370:
      if (!((Bankcard)localObject3).eIy()) {
        break label1165;
      }
      localObject1 = t.eJf().CRg;
      if (bu.isNullOrNil(((Bankcard)localObject1).Dmk)) {
        break label1090;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).DBR.setText(((Bankcard)localObject1).Dmk);
      label410:
      localObject1 = "";
      switch (((Bankcard)localObject3).a(locala.DBK, locala.yvS))
      {
      default: 
        if (!bu.isNullOrNil(((Bankcard)localObject3).field_tips)) {
          localObject1 = ((Bankcard)localObject3).field_tips;
        }
        label494:
        localObject5 = new SpannableStringBuilder((CharSequence)localObject1);
        if ((!bu.isNullOrNil(((Bankcard)localObject3).field_forbid_title)) && (!bu.isNullOrNil(((Bankcard)localObject3).field_forbid_url)))
        {
          ((SpannableStringBuilder)localObject5).append("  ");
          ((SpannableStringBuilder)localObject5).append(((Bankcard)localObject3).field_forbid_title);
          ((SpannableStringBuilder)localObject5).setSpan(new ForegroundColorSpan(locala.getContext().getResources().getColor(2131101107)), ((String)localObject1).length() + 2, ((SpannableStringBuilder)localObject5).length(), 34);
          ((WcPayCashierBankcardItemLayout)localObject4).DBS.setOnClickListener(new a.5(locala, (Bankcard)localObject3));
        }
        if (!bu.ah((CharSequence)localObject5))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).DBS.setVisibility(0);
          ((WcPayCashierBankcardItemLayout)localObject4).DBS.setText((CharSequence)localObject5);
        }
        if ((locala.DBN) && (bu.ah((CharSequence)localObject5)))
        {
          localObject1 = locala.g((Bankcard)localObject3);
          if (((LinkedList)localObject1).size() > 0)
          {
            ((WcPayCashierBankcardItemLayout)localObject4).DwP.setVisibility(0);
            ((WcPayCashierBankcardItemLayout)localObject4).DBS.setVisibility(8);
            ((WcPayCashierBankcardItemLayout)localObject4).DwP.setWording((LinkedList)localObject1);
          }
        }
        if ((locala.DdG != null) && (((Bankcard)localObject3).field_bindSerial.equals(locala.DdG.field_bindSerial))) {
          ((WcPayCashierBankcardItemLayout)localObject4).DBT.setChecked(true);
        }
        if (((Bankcard)localObject3).a(locala.DBK, locala.yvS) != 0)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).DBT.setChecked(false);
          ((WcPayCashierBankcardItemLayout)localObject4).DBR.setTextColor(locala.getContext().getResources().getColor(2131100482));
          ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(false);
        }
        break;
      }
    }
    for (;;)
    {
      ((WcPayCashierBankcardItemLayout)localObject4).setOnClickListener(new a.6(locala, (Bankcard)localObject3));
      break label295;
      i = this.mPayInfo.dDH;
      break;
      label817:
      localObject1 = this.mPayInfo.dmw;
      break label62;
      label829:
      localObject1 = ((Bankcard)localObject4).field_desc;
      break label123;
      label839:
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.uu(false);
      break label241;
      label851:
      paramInt = 0;
      break label266;
      label856:
      localObject3 = locala.Dar.Dos;
      localObject2 = new ArrayList();
      paramInt = 0;
      if (paramInt < ((ArrayList)localObject1).size())
      {
        localObject4 = (Bankcard)((ArrayList)localObject1).get(paramInt);
        if (bu.isNullOrNil((String)localObject3)) {
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
      if (((Bankcard)localObject3).eIz())
      {
        locala.CWV.a((Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).oTd);
        break label370;
      }
      if (((Bankcard)localObject3).eIC())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).oTd.setImageDrawable(com.tencent.mm.svg.a.a.g(locala.getContext().getResources(), 2131690298));
        if (bu.isNullOrNil(((Bankcard)localObject3).DmC)) {
          break label370;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).oTd.setUseSdcardCache(true);
        ((WcPayCashierBankcardItemLayout)localObject4).oTd.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eKI());
        ((WcPayCashierBankcardItemLayout)localObject4).oTd.gk(((Bankcard)localObject3).DmC, 2131690298);
        break label370;
      }
      locala.CWV.a(locala.getContext(), (Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).oTd);
      break label370;
      label1090:
      if (((Bankcard)localObject1).Dmj >= 0.0D)
      {
        localObject5 = ((WcPayCashierBankcardItemLayout)localObject4).DBR;
        Context localContext = locala.getContext();
        locala.getContext();
        ((TextView)localObject5).setText(localContext.getString(ah.fWh(), new Object[] { f.D(((Bankcard)localObject1).Dmj) }));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).DBR.setText("");
      break label410;
      label1165:
      if (((Bankcard)localObject3).eIz())
      {
        localObject1 = t.eJf().DsE;
        if (!bu.isNullOrNil(((Bankcard)localObject1).Dmk))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).DBR.setText(((Bankcard)localObject1).Dmk);
          break label410;
        }
        if (((Bankcard)localObject1).Dmj >= 0.0D)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).DBR.setText(locala.getContext().getString(2131765386, new Object[] { f.D(((Bankcard)localObject1).Dmj) }));
          break label410;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).DBR.setText("");
        break label410;
      }
      if (((Bankcard)localObject3).eIC())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).DBR.setText(k.b(locala.getContext(), ((Bankcard)localObject3).field_desc, ((WcPayCashierBankcardItemLayout)localObject4).DBR.getTextSize()));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).DBR.setText(((Bankcard)localObject3).field_desc);
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
      ((WcPayCashierBankcardItemLayout)localObject4).DBR.setTextColor(locala.getContext().getResources().getColor(2131100711));
      ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(true);
    }
    label1478:
    Object localObject1 = new WcPayCashierBankcardItemLayout(locala.getContext());
    ((WcPayCashierBankcardItemLayout)localObject1).oTd.setVisibility(4);
    ((WcPayCashierBankcardItemLayout)localObject1).DBR.setText(2131765660);
    ((WcPayCashierBankcardItemLayout)localObject1).DBR.setTextColor(locala.getContext().getResources().getColor(2131100547));
    ((WcPayCashierBankcardItemLayout)localObject1).DBT.setVisibility(8);
    Object localObject2 = locala.eLJ();
    if ((locala.DBN) && (((LinkedList)localObject2).size() > 0))
    {
      ((WcPayCashierBankcardItemLayout)localObject1).DwP.setVisibility(0);
      ((WcPayCashierBankcardItemLayout)localObject1).DBS.setVisibility(8);
      ((WcPayCashierBankcardItemLayout)localObject1).DwP.setWording((LinkedList)localObject2);
    }
    ((WcPayCashierBankcardItemLayout)localObject1).setOnClickListener(new a.7(locala));
    locala.DBH.addView((View)localObject1);
    localObject2 = "";
    localObject1 = localObject2;
    if (locala.yvS != null)
    {
      localObject1 = localObject2;
      if (locala.yvS.DpP != null)
      {
        localObject1 = localObject2;
        if (locala.yvS.DpP.size() > 0) {
          localObject1 = locala.getContext().getString(2131765187, new Object[] { f.d(locala.yvS.dmz, locala.yvS.wSq), ((Orders.Commodity)locala.yvS.DpP.get(0)).desc });
        }
      }
    }
    if ((locala.Dar != null) && (!bu.isNullOrNil(locala.Dar.Dou)))
    {
      locala.DBI.setVisibility(0);
      locala.DBI.setText(locala.Dar.Dou);
      locala.Dar.Dou = "";
    }
    for (;;)
    {
      localObject1 = this.DCw.DBP;
      this.DCM.add(localObject1);
      this.DCw.DBO = new a.a()
      {
        public final void eFU()
        {
          AppMethodBeat.i(71351);
          ae.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
            WcPayCashierDialog.c(WcPayCashierDialog.this).eFU();
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
          ae.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", new Object[] { paramAnonymousBankcard.field_bankName, paramAnonymousBankcard.field_bindSerial });
          if ((WcPayCashierDialog.this.DCB == null) || (!paramAnonymousBankcard.field_bindSerial.equals(WcPayCashierDialog.this.DCB.field_bindSerial)))
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dmw)
          {
            com.tencent.mm.wallet_core.c.af.f(i, str, 13, paramAnonymousBankcard.field_bindSerial);
            WcPayCashierDialog.this.DCB = paramAnonymousBankcard;
            WcPayCashierDialog.this.Dar = paramFavorPayInfo;
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
            i = WcPayCashierDialog.this.mPayInfo.dDH;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(71352);
          ae.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          WcPayCashierDialog.this.show();
          AppMethodBeat.o(71352);
        }
      };
      this.DCw.show();
      AppMethodBeat.o(71394);
      return;
      if (locala.DBM != 0)
      {
        locala.DBI.setVisibility(0);
        locala.DBI.setText((CharSequence)localObject1);
      }
      else
      {
        locala.DBI.setVisibility(8);
      }
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.dDH == 31) || (paramPayInfo.dDH == 32) || (paramPayInfo.dDH == 33));
  }
  
  private static void aG(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71390);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((locala.type() == 1) && ((locala.cRT()) || (locala.cRW())) && (com.tencent.mm.plugin.soter.e.b.ejx()) && (com.tencent.mm.plugin.soter.e.b.ejw()) && (com.tencent.soter.core.a.fYU() == 0))
    {
      ae.i("MicroMsg.WcPayCashierDialog", "may treble init error");
      com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 23);
      if (locala.type() == 2)
      {
        if (com.tencent.soter.core.a.fYU() != 0) {
          break label246;
        }
        com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 28);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 27);
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 33);
      }
      AppMethodBeat.o(71390);
      return;
      if (locala.type() != 2) {
        break;
      }
      if (com.tencent.soter.core.a.fYU() == 1)
      {
        if (!com.tencent.soter.core.a.fYW())
        {
          ae.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 24);
          break;
        }
        if (paramBoolean1) {
          break;
        }
        ae.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
        com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 25);
        break;
      }
      if (paramBoolean1) {
        break;
      }
      ae.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
      com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 26);
      break;
      label246:
      com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 31);
    }
  }
  
  private void eLM()
  {
    AppMethodBeat.i(71366);
    if (!this.DCq.isShown())
    {
      this.DCq.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772137);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.DCq.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71366);
  }
  
  private void eLN()
  {
    AppMethodBeat.i(71367);
    if (this.DCq.isShown())
    {
      this.DCq.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772138);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.DCq.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71367);
  }
  
  private void eLO()
  {
    AppMethodBeat.i(71373);
    Object localObject1 = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(this.yvS);
    if (localObject1 != null) {
      if ((this.Dar != null) && (this.DCB != null)) {
        if (!this.DCB.field_bankcardType.equalsIgnoreCase("CFT")) {
          break label452;
        }
      }
    }
    label195:
    label452:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { this.Dar.Doq, Boolean.valueOf(bool) });
      String str = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).cn(this.Dar.Doq, bool);
      ae.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str });
      Object localObject3 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aGg(str);
      Object localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).cm(str, true);
      d.a locala1 = (d.a)((Map)localObject3).get(this.DCB.field_bindSerial);
      d.a locala2 = (d.a)((Map)localObject2).get(this.DCB.field_bankcardType);
      j localj = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).cl(str, bool);
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
        ae.i("MicroMsg.WcPayCashierDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((locala1 == null) || (locala1.DtF == null) || (bu.isNullOrNil(locala1.DtF.CYV))) {
          break label308;
        }
        this.Dar.Doq = locala1.DtF.CYV;
        AppMethodBeat.o(71373);
        return;
        localObject1 = localj.CYV;
        break;
        localObject2 = locala1.toString();
        break label195;
      }
      if ((locala2 != null) && (locala2.DtF != null) && (!bu.isNullOrNil(locala2.DtF.CYV)))
      {
        this.Dar.Doq = locala2.DtF.CYV;
        AppMethodBeat.o(71373);
        return;
      }
      if (localj != null)
      {
        this.Dar.Doq = localj.CYV;
        AppMethodBeat.o(71373);
        return;
      }
      this.Dar.Doq = str;
      AppMethodBeat.o(71373);
      return;
      if (this.yvS.DpQ != null)
      {
        this.Dar = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aGl(((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aGm(this.yvS.DpQ.CYF));
        AppMethodBeat.o(71373);
        return;
        ae.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
      }
      AppMethodBeat.o(71373);
      return;
    }
  }
  
  private void eLP()
  {
    AppMethodBeat.i(71374);
    if (this.DCF)
    {
      ae.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
      if (this.DCu != null)
      {
        this.DCh.removeView(this.DCu);
        this.DCu = null;
      }
      AppMethodBeat.o(71374);
      return;
    }
    if ((!bu.isNullOrNil(this.yvS.Dqh)) && (!bu.isNullOrNil(this.yvS.Dqi)))
    {
      this.DCu = new WcPayCashierDetailItemLayout(getContext());
      this.DCh.addView(this.DCu, 0);
      this.DCu.DBW.setVisibility(8);
      this.DCu.DBX.setVisibility(8);
      this.DCu.ypF.setText(2131766038);
      this.DCu.eLL();
      if ((this.yvS.Dqh.equals("CNY")) && (!bu.isNullOrNil(this.yvS.Dqg)))
      {
        localStringBuilder = new StringBuilder(this.yvS.Dqi);
        localStringBuilder.append(this.yvS.Dqg);
        if ((!bu.isNullOrNil(this.yvS.Dqk)) && (!bu.isNullOrNil(this.yvS.Dql))) {
          localStringBuilder.append(String.format("(%s%s)", new Object[] { this.yvS.Dql, this.yvS.Dqj }));
        }
        this.DCu.pHi.setText(localStringBuilder);
        AppMethodBeat.o(71374);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(this.yvS.Dqi);
      localStringBuilder.append(this.yvS.Dqg);
      this.DCu.pHi.setText(localStringBuilder);
    }
    AppMethodBeat.o(71374);
  }
  
  private void eLQ()
  {
    AppMethodBeat.i(71375);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(this.yvS);
    if ((this.Dar == null) || ((locald != null) && (!locald.eKR())))
    {
      this.DCh.removeView(this.DCt);
      this.DCt = null;
      AppMethodBeat.o(71375);
      return;
    }
    if (this.DCt == null)
    {
      this.DCt = new WcPayCashierDetailItemLayout(getContext());
      this.DCh.addView(this.DCt);
      this.DCt.ypF.setText(2131766036);
      this.DCt.DBW.setVisibility(8);
      this.DCt.DBX.setVisibility(0);
      this.DCt.pHi.setTextColor(getContext().getResources().getColor(2131099777));
      this.DCt.eLL();
      this.DCt.setOnClickListener(new w()
      {
        public final void ccc()
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dmw)
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
            i = WcPayCashierDialog.this.mPayInfo.dDH;
            break;
          }
          label109:
          WcPayCashierDialog.a(WcPayCashierDialog.this, n.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.yvS, WcPayCashierDialog.this.Dar.Doq, new n.b()new DialogInterface.OnCancelListener
          {
            public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
            {
              int i = 0;
              AppMethodBeat.i(71338);
              ae.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", new Object[] { paramAnonymous2FavorPayInfo.Doq });
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              Object localObject;
              if (WcPayCashierDialog.this.mPayInfo == null)
              {
                if (WcPayCashierDialog.this.mPayInfo != null) {
                  break label226;
                }
                localObject = "";
                label66:
                com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 15, paramAnonymous2FavorPayInfo.Doq);
                localObject = com.tencent.mm.plugin.wallet_core.ui.d.cq(paramAnonymous2FavorPayInfo.Dor, paramAnonymous2FavorPayInfo.Dos);
                WcPayCashierDialog.this.Dar.Dou = "";
                if (!com.tencent.mm.plugin.wallet_core.ui.d.a(paramAnonymous2FavorPayInfo, WcPayCashierDialog.this.DCB)) {
                  break label265;
                }
                if (((List)localObject).size() != 0) {
                  break label243;
                }
                paramAnonymous2FavorPayInfo.Dou = WcPayCashierDialog.this.getContext().getString(2131765258);
                label149:
                WcPayCashierDialog.b(WcPayCashierDialog.this, paramAnonymous2FavorPayInfo);
              }
              for (;;)
              {
                WcPayCashierDialog.p(WcPayCashierDialog.this);
                WcPayCashierDialog.q(WcPayCashierDialog.this);
                WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.r(WcPayCashierDialog.this).pHi);
                AppMethodBeat.o(71338);
                return;
                i = WcPayCashierDialog.this.mPayInfo.dDH;
                break;
                label226:
                localObject = WcPayCashierDialog.this.mPayInfo.dmw;
                break label66;
                label243:
                paramAnonymous2FavorPayInfo.Dou = WcPayCashierDialog.this.getContext().getString(2131765259);
                break label149;
                label265:
                WcPayCashierDialog.this.Dar = paramAnonymous2FavorPayInfo;
                WcPayCashierDialog.this.show();
              }
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(71339);
              ae.i("MicroMsg.WcPayCashierDialog", "on cancel");
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              WcPayCashierDialog.this.show();
              AppMethodBeat.o(71339);
            }
          }));
          AppMethodBeat.o(71340);
        }
      });
    }
    s(this.DCt.pHi);
    AppMethodBeat.o(71375);
  }
  
  private void eLR()
  {
    AppMethodBeat.i(71378);
    if ((this.DCh.getChildCount() == 0) && (this.DCs.getVisibility() == 8))
    {
      ae.d("MicroMsg.WcPayCashierDialog", "invisible divider");
      this.qrA.setVisibility(8);
      AppMethodBeat.o(71378);
      return;
    }
    this.qrA.setVisibility(0);
    AppMethodBeat.o(71378);
  }
  
  private void eLS()
  {
    AppMethodBeat.i(71379);
    if (!this.DCF)
    {
      if (this.DCr != null)
      {
        this.DCh.removeView(this.DCr);
        this.DCr = null;
      }
      AppMethodBeat.o(71379);
      return;
    }
    Object localObject1;
    if (this.DCr == null)
    {
      this.DCr = new WcPayCashierDetailItemLayout(getContext());
      this.DCh.addView(this.DCr, 0);
      this.DCr.ypF.setText(2131766040);
      this.DCr.DBW.setVisibility(8);
      this.DCr.DBX.setVisibility(8);
      this.DCr.eLL();
      localObject1 = f.agY(7);
    }
    try
    {
      this.DCr.pHi.setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject1));
      this.DCr.pHi.getPaint().setFlags(16);
      str = "";
      localObject1 = str;
      if (!bu.isNullOrNil(this.yvS.Dqg))
      {
        localObject1 = str;
        if (!bu.isNullOrNil(this.yvS.Dqi)) {
          localObject1 = String.format("%s%s", new Object[] { this.yvS.Dqi, this.yvS.Dqg });
        }
      }
      str = f.d(this.yvS.dmz, this.yvS.wSq);
      if (!bu.isNullOrNil((String)localObject1))
      {
        localObject1 = String.format("%s(%s)", new Object[] { str, localObject1 });
        this.DCr.pHi.setText((CharSequence)localObject1);
        AppMethodBeat.o(71379);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        ae.e("MicroMsg.WcPayCashierDialog", "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
        Object localObject2 = str;
      }
    }
  }
  
  private void eLT()
  {
    AppMethodBeat.i(71380);
    if (!this.DCD)
    {
      ae.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
      this.DCs.setVisibility(8);
      AppMethodBeat.o(71380);
      return;
    }
    this.DCs.setVisibility(0);
    this.DCs.ypF.setText(2131766041);
    this.DCs.DBW.setVisibility(0);
    this.DCs.DBX.setVisibility(0);
    this.DCs.eLL();
    this.DCs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71341);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.WcPayCashierDialog", "click bankcard item");
        WcPayCashierDialog.s(WcPayCashierDialog.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71341);
      }
    });
    this.DCs.DBW.setImageBitmap(null);
    a(this.DCB, this.DCs.DBW);
    if (this.DCB == null) {}
    for (String str = "";; str = this.DCB.field_desc)
    {
      Object localObject = str;
      if (this.DCB != null)
      {
        localObject = str;
        if (this.DCB.eIC()) {
          localObject = k.c(this.mContext, str);
        }
      }
      this.DCs.P((CharSequence)localObject);
      AppMethodBeat.o(71380);
      return;
    }
  }
  
  private void eLU()
  {
    AppMethodBeat.i(71382);
    eLV();
    eLY();
    AppMethodBeat.o(71382);
  }
  
  private void eLV()
  {
    AppMethodBeat.i(71383);
    Object localObject2 = "";
    Object localObject1;
    if (this.DCJ)
    {
      localObject1 = this.DCH;
      this.DCf.setText((CharSequence)localObject1);
      AppMethodBeat.o(71383);
      return;
    }
    if (this.mPayInfo.hwN == null)
    {
      localObject1 = "";
      label51:
      if (bu.isNullOrNil((String)localObject1)) {
        break label214;
      }
    }
    for (;;)
    {
      if ((!bu.isNullOrNil((String)localObject1)) || (this.yvS == null) || (this.yvS.DpP == null)) {
        break label1116;
      }
      Object localObject3 = (Orders.Commodity)this.yvS.DpP.get(0);
      if (localObject3 == null) {
        break label1150;
      }
      localObject1 = ((Orders.Commodity)localObject3).wSf;
      localObject2 = localObject1;
      if (a(this.mPayInfo))
      {
        localObject2 = localObject1;
        if (!bu.isNullOrNil((String)localObject1)) {
          localObject2 = (String)localObject1 + "\n";
        }
        localObject2 = (String)localObject2 + ((Orders.Commodity)localObject3).desc;
      }
      localObject1 = localObject2;
      if (!bu.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = ((Orders.Commodity)localObject3).desc;
      break;
      localObject1 = this.mPayInfo.hwN.getString("extinfo_key_19", "");
      break label51;
      label214:
      if ((this.mPayInfo.dDH == 32) || (this.mPayInfo.dDH == 33))
      {
        String str1 = this.mPayInfo.hwN.getString("extinfo_key_5", "");
        String str2 = this.mPayInfo.hwN.getString("extinfo_key_1", "");
        localObject3 = getContext().getString(2131765746);
        localObject1 = localObject2;
        if (!bu.isNullOrNil(str1))
        {
          localObject3 = str1;
          localObject1 = str1;
        }
        if (!bu.isNullOrNil(str2))
        {
          localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK(str2);
          if (localObject2 != null)
          {
            localObject1 = ((com.tencent.mm.storage.an)localObject2).adG();
            localObject2 = new StringBuilder().append(f.bar((String)localObject1));
            if (bu.isNullOrNil(this.mPayInfo.yoq)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.yoq + ")")
            {
              localObject1 = bu.x((String)localObject3, new Object[] { (String)localObject1 });
              break;
            }
          }
          ae.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(str2)));
        }
        else
        {
          ae.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        }
      }
      else if (this.mPayInfo.dDH == 31)
      {
        localObject1 = this.mPayInfo.hwN.getString("extinfo_key_1", "");
        if (!bu.isNullOrNil((String)localObject1))
        {
          localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.storage.an)localObject3).adF();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bu.isNullOrNil(this.mPayInfo.yoq)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.yoq + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131765746, new Object[] { (String)localObject1 });
              break;
            }
          }
          ae.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          ae.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dDH == 42)
      {
        localObject1 = this.mPayInfo.hwN.getString("extinfo_key_1", "");
        if (!bu.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.kernel.g.ajS();
          localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.storage.an)localObject3).adF();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bu.isNullOrNil(this.mPayInfo.yoq)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.yoq + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131765739, new Object[] { (String)localObject1 });
              break;
            }
          }
          ae.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          ae.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dDH == 48)
      {
        localObject1 = getContext().getString(2131762090);
      }
      else if (this.mPayInfo.dDH == 49)
      {
        localObject1 = this.mPayInfo.hwN.getString("extinfo_key_1", "");
        if (!bu.isNullOrNil((String)localObject1))
        {
          localObject1 = getContext().getString(2131765746, new Object[] { localObject1 });
        }
        else
        {
          ae.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dDH) });
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dDH == 56)
      {
        localObject1 = this.mPayInfo.hwN.getString("extinfo_key_12", "");
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.e("MicroMsg.WcPayCashierDialog", "title is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dDH) });
          localObject1 = localObject2;
        }
      }
      else if ((this.mPayInfo.dDH == 45) || (this.mPayInfo.dDH == 52))
      {
        localObject1 = getContext().getString(2131765498);
      }
      else
      {
        localObject1 = localObject2;
        if (this.mPayInfo.dDH == 11) {
          localObject1 = getContext().getString(2131765034);
        }
      }
    }
    label1116:
    localObject2 = new StringBuilder("orders null?:");
    if (this.yvS == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.w("MicroMsg.WcPayCashierDialog", bool);
      label1150:
      break;
    }
  }
  
  private void eLW()
  {
    AppMethodBeat.i(71384);
    if (!bu.isNullOrNil(this.DCG))
    {
      this.DzU.setText(this.DCG);
      this.DzU.setVisibility(0);
      AppMethodBeat.o(71384);
      return;
    }
    this.DzU.setVisibility(8);
    AppMethodBeat.o(71384);
  }
  
  private void eLX()
  {
    AppMethodBeat.i(71385);
    if ((this.DCE) && (this.yvS.DpQ.CYS != null) && (this.yvS.DpQ.CYS.CYo == 1))
    {
      final com.tencent.mm.plugin.wallet.a.b localb = this.yvS.DpQ.CYS;
      this.DCn.setUrl(localb.CYv);
      this.DCo.setText(localb.CYq);
      if (!bu.isNullOrNil(localb.CYr)) {
        this.DCo.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(localb.CYr, true));
      }
      this.DCp.setText(localb.CYs);
      if (!bu.isNullOrNil(localb.CYt)) {
        this.DCp.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(localb.CYt, true));
      }
      this.DCp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
          WcPayCashierDialog.t(WcPayCashierDialog.this);
          WcPayCashierDialog.this.DCB = t.eJf().aFN(localb.CYn.wRt);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(WcPayCashierDialog.this.yvS).aGl(localb.CYp);
          ae.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", new Object[] { paramAnonymousView.Doq });
          if (paramAnonymousView.Doq.equals("0")) {
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
            WcPayCashierDialog.this.Dar = paramAnonymousView;
          }
        }
      });
      Wq(0);
      AppMethodBeat.o(71385);
      return;
    }
    Wq(8);
    AppMethodBeat.o(71385);
  }
  
  private void eLY()
  {
    AppMethodBeat.i(71387);
    Object localObject1;
    if (this.DCJ) {
      localObject1 = this.DCI;
    }
    for (;;)
    {
      this.DCg.setText((CharSequence)localObject1);
      AppMethodBeat.o(71387);
      return;
      Object localObject2 = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(this.yvS);
      localObject1 = f.d(this.yvS.dmz, this.yvS.wSq);
      this.DCF = false;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).aGi(this.Dar.Doq);
        localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).eKU();
        if ((localObject1 != null) && (((j)localObject1).CYM > 0.0D))
        {
          this.DCF = true;
          localObject1 = f.d(((j)localObject1).CYL, this.yvS.wSq);
        }
        else if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = f.d(((j)localObject1).CYL, this.yvS.wSq);
        }
        else
        {
          localObject1 = f.d(this.yvS.dmz, this.yvS.wSq);
        }
      }
    }
  }
  
  private void eLZ()
  {
    AppMethodBeat.i(71388);
    eMa();
    ae.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", new Object[] { Integer.valueOf(this.yvS.DpM) });
    if (this.DCy == 0)
    {
      boolean bool;
      if (this.DCz > 0) {
        bool = false;
      }
      for (;;)
      {
        uH(bool);
        AppMethodBeat.o(71388);
        return;
        if (this.DCA == 1)
        {
          this.DCl.setVisibility(8);
          bool = true;
        }
        else
        {
          if (this.DCA != 3) {
            break;
          }
          this.DCl.setText(2131765263);
          this.DCl.setVisibility(0);
          bool = true;
        }
      }
      if (this.mPayInfo.FEq == 100102)
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMA, Boolean.TRUE);
        com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        locala.mC(false);
        locala.mD(false);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMy, Boolean.FALSE);
        this.DCl.setText(2131765270);
      }
      for (;;)
      {
        this.DCl.setTextColor(getContext().getResources().getColor(2131101133));
        this.DCl.setVisibility(0);
        bool = true;
        break;
        this.DCl.setText(2131765263);
      }
    }
    if (this.DCy == 1)
    {
      eMb();
      AppMethodBeat.o(71388);
      return;
    }
    if (this.DCy == 2) {
      eMc();
    }
    AppMethodBeat.o(71388);
  }
  
  private void eMa()
  {
    AppMethodBeat.i(71389);
    ae.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", new Object[] { Integer.valueOf(this.yvS.DpM) });
    com.tencent.mm.plugin.fingerprint.d.a locala;
    boolean bool3;
    if (this.yvS.DpM == 1)
    {
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.cRY()) && (locala.cRZ()) && (!locala.cRU()) && (locala.cRT()) && (locala.cSc()))
      {
        this.DCz = 1;
        bool3 = p.tse.tsg;
        if ((t.eJf() == null) || (this.DCz <= 0)) {
          break label484;
        }
      }
    }
    label148:
    label332:
    label484:
    for (boolean bool2 = locala.cSf();; bool2 = true)
    {
      aG(bool2, bool3);
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        bool2 &= bool1;
        if (bool2) {
          break label332;
        }
        p.tse.tsg = true;
        this.DCz = 0;
        this.DCA = 3;
        this.mPayInfo.DpN = true;
        p.tse.tsg = true;
      }
      for (;;)
      {
        this.DCy = this.DCz;
        ae.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(this.mPayInfo.FEq), Integer.valueOf(this.DCy), Integer.valueOf(this.DCz) });
        AppMethodBeat.o(71389);
        return;
        if ((locala.cSg()) && (locala.cSh()) && (!locala.cRV()) && (locala.cRW()) && (locala.cSc()))
        {
          this.DCz = 2;
          break;
        }
        this.DCz = 0;
        this.DCA = 2;
        break;
        bool1 = false;
        break label148;
        if ((this.mPayInfo.FEq == 100000) || (this.mPayInfo.FEq == 100102))
        {
          if (this.mPayInfo.FEq == 100000) {
            this.mPayInfo.DAm = 0;
          }
          this.DCz = 0;
          this.DCA = 4;
        }
      }
      this.DCy = 0;
      this.DCz = 0;
      this.DCA = 1;
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.cRY()) && (locala.cRZ()) && (!locala.cRU()) && (locala.cRT()))
      {
        ae.w("MicroMsg.WcPayCashierDialog", "wired case");
        com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 2);
      }
      AppMethodBeat.o(71389);
      return;
    }
  }
  
  private void eMb()
  {
    AppMethodBeat.i(71392);
    this.DCy = 1;
    this.mPayInfo.DAm = 1;
    this.DCj.setVisibility(8);
    this.DCk.setVisibility(0);
    this.DCi.dHv();
    eLN();
    this.DCd.setVisibility(8);
    this.DCe.setText(2131765750);
    AppMethodBeat.o(71392);
  }
  
  private void eMc()
  {
    AppMethodBeat.i(71393);
    this.DCy = 2;
    this.mPayInfo.DAm = 1;
    this.DCj.setVisibility(8);
    this.DCk.setVisibility(0);
    this.DCi.dHv();
    eLN();
    this.DCd.setVisibility(8);
    this.DCe.setText(2131765750);
    AppMethodBeat.o(71393);
  }
  
  private void gX(List<dmr> paramList)
  {
    AppMethodBeat.i(71372);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        final dmr localdmr = (dmr)paramList.next();
        WcPayCashierDetailItemLayout localWcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
        localWcPayCashierDetailItemLayout.DBW.setVisibility(8);
        if ((localdmr.HTX != null) && (localdmr.HTX.size() > 0)) {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.ypF, (dnl)localdmr.HTX.get(0), null);
        }
        if ((localdmr.HTY != null) && (localdmr.HTY.size() > 0))
        {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.pHi, (dnl)localdmr.HTY.get(0), null);
          label149:
          if (localdmr.HTZ == null) {
            break label267;
          }
          int i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
          int j = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 16);
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.DBX, localdmr.HTZ, 2131689709, i, j, true);
          localWcPayCashierDetailItemLayout.DBX.setVisibility(0);
        }
        for (;;)
        {
          localWcPayCashierDetailItemLayout.eLL();
          if (localdmr.FLp != null) {
            localWcPayCashierDetailItemLayout.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(71337);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
                ae.i("MicroMsg.WcPayCashierDialog", "click item: %s", new Object[] { localdmr.FLp.url });
                if ((localdmr.FLp.type == 13) && (localdmr.FLp.HIa != null) && ("fetchfavordialog".equals(localdmr.FLp.url)))
                {
                  paramAnonymousView = new b(WcPayCashierDialog.n(WcPayCashierDialog.this));
                  if ((localdmr.FLp.HIa.Guv.size() > 0) && (((dwv)localdmr.FLp.HIa.Guv.get(0)).Ici != null))
                  {
                    localObject1 = ((dwv)localdmr.FLp.HIa.Guv.get(0)).Ici.Heh;
                    Object localObject2 = localdmr.FLp.HIa.Gut.FLn;
                    if (localObject2 != null) {
                      com.tencent.mm.plugin.wallet_core.utils.g.a(paramAnonymousView.lHk, (dnl)localObject2, null);
                    }
                    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                    {
                      localObject1 = ((List)localObject1).iterator();
                      while (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (dmr)((Iterator)localObject1).next();
                        View localView = View.inflate(paramAnonymousView.getContext(), 2131496056, null);
                        TextView localTextView1 = (TextView)localView.findViewById(2131307058);
                        TextView localTextView2 = (TextView)localView.findViewById(2131307056);
                        if ((((dmr)localObject2).HTX != null) && (((dmr)localObject2).HTX.size() > 0))
                        {
                          com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView1, (dnl)((dmr)localObject2).HTX.get(0), null);
                          if (((dmr)localObject2).HTX.size() >= 2) {
                            com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView2, (dnl)((dmr)localObject2).HTX.get(1), null);
                          }
                        }
                        paramAnonymousView.DCV.addView(localView);
                      }
                    }
                  }
                  paramAnonymousView.setOnDismissListener(new DialogInterface.OnDismissListener()
                  {
                    public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(71336);
                      WcPayCashierDialog.this.show();
                      AppMethodBeat.o(71336);
                    }
                  });
                  paramAnonymousView.show();
                  WcPayCashierDialog.this.hide();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71337);
              }
            });
          }
          this.DCh.addView(localWcPayCashierDetailItemLayout);
          break;
          localWcPayCashierDetailItemLayout.pHi.setVisibility(8);
          localWcPayCashierDetailItemLayout.ypF.setMaxWidth(2147483647);
          break label149;
          label267:
          localWcPayCashierDetailItemLayout.DBX.setVisibility(8);
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
        ae.i("MicroMsg.WcPayCashierDialog", "on canceled");
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
        ae.i("MicroMsg.WcPayCashierDialog", "on dismissed");
        WcPayCashierDialog.b(WcPayCashierDialog.this);
        WcPayCashierDialog.d(WcPayCashierDialog.this);
        AppMethodBeat.o(71353);
      }
    });
    ((MMActivity)this.mContext).getLifecycle().addObserver(this);
    this.CWV = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71364);
  }
  
  private void initView()
  {
    AppMethodBeat.i(71365);
    this.mcI = ((ViewGroup)View.inflate(getContext(), 2131496055, null));
    this.DBG = ((ImageView)this.mcI.findViewById(2131307031));
    this.DCd = ((TextView)this.mcI.findViewById(2131307035));
    this.DCe = ((TextView)this.mcI.findViewById(2131307045));
    this.DCf = ((TextView)this.mcI.findViewById(2131307040));
    this.DzU = ((TextView)this.mcI.findViewById(2131307030));
    this.DCg = ((WalletTextView)this.mcI.findViewById(2131307041));
    this.DCh = ((ViewGroup)this.mcI.findViewById(2131307034));
    this.DCi = ((EditHintPasswdView)this.mcI.findViewById(2131307043));
    this.DCj = ((ViewGroup)this.mcI.findViewById(2131307044));
    this.DCs = ((WcPayCashierDetailItemLayout)this.mcI.findViewById(2131307042));
    this.DCk = ((Button)this.mcI.findViewById(2131307032));
    this.DCl = ((TextView)this.mcI.findViewById(2131307036));
    this.DCm = ((ViewGroup)this.mcI.findViewById(2131307029));
    this.DCn = ((CdnImageView)this.mcI.findViewById(2131307039));
    this.DCo = ((TextView)this.mcI.findViewById(2131307038));
    this.DCp = ((Button)this.mcI.findViewById(2131307037));
    this.mKeyboard = ((MyKeyboardWindow)this.mcI.findViewById(2131305695));
    this.DCq = ((ViewGroup)this.mcI.findViewById(2131305693));
    this.qrA = this.mcI.findViewById(2131307033);
    Object localObject = this.DBG;
    int i = DBZ;
    int j = DBZ;
    bu.n((View)localObject, i, i, j, j);
    localObject = ao.k(getContext(), 2131689492, getContext().getResources().getColor(2131100019));
    this.DBG.setImageDrawable((Drawable)localObject);
    this.DBG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71354);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.WcPayCashierDialog", "click close icon");
        WcPayCashierDialog.this.cancel();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71354);
      }
    });
    com.tencent.mm.wallet_core.ui.formview.a.a(this.DCi);
    this.DCi.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71355);
        if (paramAnonymousBoolean)
        {
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.e(WcPayCashierDialog.this).getText(), WcPayCashierDialog.this.Dar);
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71355);
      }
    });
    localObject = (EditText)this.mcI.findViewById(2131306718);
    f.setNoSystemInputOnEditText((EditText)localObject);
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WcPayCashierDialog.f(WcPayCashierDialog.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71356);
      }
    });
    this.mcI.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71357);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WcPayCashierDialog.g(WcPayCashierDialog.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71357);
      }
    });
    this.DCk.setOnClickListener(new w()
    {
      public final void ccc()
      {
        int i = 0;
        AppMethodBeat.i(71358);
        ae.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", new Object[] { Integer.valueOf(WcPayCashierDialog.h(WcPayCashierDialog.this)) });
        if (WcPayCashierDialog.this.mPayInfo == null) {
          if (WcPayCashierDialog.this.mPayInfo != null) {
            break label113;
          }
        }
        label113:
        for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dmw)
        {
          com.tencent.mm.wallet_core.c.af.f(i, str, 20, "");
          WcPayCashierDialog.i(WcPayCashierDialog.this);
          if (WcPayCashierDialog.h(WcPayCashierDialog.this) != 1) {
            break label127;
          }
          WcPayCashierDialog.j(WcPayCashierDialog.this);
          f.aha(9);
          AppMethodBeat.o(71358);
          return;
          i = WcPayCashierDialog.this.mPayInfo.dDH;
          break;
        }
        label127:
        if (WcPayCashierDialog.h(WcPayCashierDialog.this) == 2)
        {
          WcPayCashierDialog.k(WcPayCashierDialog.this);
          AppMethodBeat.o(71358);
          return;
        }
        ae.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
        WcPayCashierDialog.l(WcPayCashierDialog.this);
        AppMethodBeat.o(71358);
      }
    });
    this.DCe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71359);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.WcPayCashierDialog", "click pay way btn");
        WcPayCashierDialog.m(WcPayCashierDialog.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71359);
      }
    });
    AppMethodBeat.o(71365);
  }
  
  private void s(TextView paramTextView)
  {
    AppMethodBeat.i(71377);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(this.yvS);
    j localj = locald.aGi(this.Dar.Doq);
    List localList = locald.eKU();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = "";
    int i;
    if ((localj != null) && (localj.CYM > 0.0D))
    {
      localStringBuilder.append(localj.CYO);
      i = 1;
    }
    for (;;)
    {
      if ((localj != null) && (localj.CYN != 0) && (!bu.ah(localStringBuilder)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(localj.CYP);
      }
      if ((!bu.ah(localStringBuilder)) && (!bu.isNullOrNil((String)localObject)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
        label152:
        localObject = localStringBuilder.toString();
        ae.i("MicroMsg.WcPayCashierDialog", "favor text: %s", new Object[] { localObject });
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
        localObject = locald.eKT();
        if ((localj == null) && (locald.eKS() == 1) && (localObject != null) && (((j)localObject).CYN == 0) && (this.DCE) && (this.yvS.DpQ.CYS != null) && (this.yvS.DpQ.CYS.CYo == 1))
        {
          localObject = getContext().getString(2131765749);
          i = 0;
          break;
        }
        localObject = getContext().getString(2131765742);
        i = 1;
        break;
        if (bu.isNullOrNil((String)localObject)) {
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
  
  private void uH(boolean paramBoolean)
  {
    AppMethodBeat.i(71391);
    ae.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.DCy = 0;
    this.mPayInfo.DAm = 0;
    this.DCj.setVisibility(0);
    this.DCk.setVisibility(8);
    this.DCi.dHv();
    eLM();
    this.DCd.setVisibility(0);
    if (paramBoolean)
    {
      this.DCe.setVisibility(8);
      AppMethodBeat.o(71391);
      return;
    }
    this.DCe.setVisibility(0);
    AppMethodBeat.o(71391);
  }
  
  public final void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71370);
    a(paramPayInfo, paramOrders, paramFavorPayInfo, "", paramBankcard, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(71370);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, List<dmr> paramList)
  {
    AppMethodBeat.i(71369);
    this.DCH = paramString1;
    this.DCI = paramString2;
    this.DCG = paramString3;
    this.DCJ = true;
    this.DCD = false;
    eLZ();
    eLU();
    eLW();
    gX(paramList);
    eLT();
    eLR();
    AppMethodBeat.o(71369);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71368);
    ae.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
    this.DCi.dHv();
    AppMethodBeat.o(71368);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71363);
    super.onCreate(paramBundle);
    setContentView(this.mcI);
    paramBundle = getWindow();
    paramBundle.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle.addFlags(67108864);
    com.tencent.mm.compatible.util.d.lA(21);
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
    
    public abstract void eFU();
    
    public abstract void onCancel();
  }
  
  public static abstract interface b
  {
    public abstract void eLK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog
 * JD-Core Version:    0.7.0.1
 */