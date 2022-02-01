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
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.p;
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
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.erb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.x;
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
  public static final int Ill;
  public static final int Ilm;
  public static final int Iln;
  public static final int Ilo;
  public Orders CwO;
  private com.tencent.mm.plugin.wallet_core.utils.a HCH;
  public FavorPayInfo HGf;
  private TextView Ijg;
  private ImageView IkS;
  private TextView IlA;
  private Button IlB;
  private ViewGroup IlC;
  private WcPayCashierDetailItemLayout IlD;
  private WcPayCashierDetailItemLayout IlE;
  private WcPayCashierDetailItemLayout IlF;
  private WcPayCashierDetailItemLayout IlG;
  private WcPayCashierFingerprintDialog IlH;
  private a IlI;
  private n IlJ;
  private int IlK;
  private int IlL;
  private int IlM;
  public Bankcard IlN;
  private boolean IlO;
  private boolean IlP;
  private boolean IlQ;
  private boolean IlR;
  private String IlS;
  private String IlT;
  private String IlU;
  private boolean IlV;
  private boolean IlW;
  public a IlX;
  List<b> IlY;
  private TextView Ilp;
  private TextView Ilq;
  private TextView Ilr;
  private WalletTextView Ils;
  private ViewGroup Ilt;
  private EditHintPasswdView Ilu;
  private ViewGroup Ilv;
  private Button Ilw;
  private TextView Ilx;
  private ViewGroup Ily;
  private CdnImageView Ilz;
  private Context mContext;
  private MyKeyboardWindow mKeyboard;
  public PayInfo mPayInfo;
  private ViewGroup nmW;
  private View zlb;
  
  static
  {
    AppMethodBeat.i(71415);
    Ill = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 30);
    Ilm = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    Iln = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 36);
    Ilo = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 23);
    AppMethodBeat.o(71415);
  }
  
  public WcPayCashierDialog(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(71361);
    this.IlK = 0;
    this.IlL = 0;
    this.IlM = 0;
    this.mPayInfo = new PayInfo();
    this.CwO = new Orders();
    this.IlO = false;
    this.IlQ = true;
    this.IlY = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71361);
  }
  
  public WcPayCashierDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(71362);
    this.IlK = 0;
    this.IlL = 0;
    this.IlM = 0;
    this.mPayInfo = new PayInfo();
    this.CwO = new Orders();
    this.IlO = false;
    this.IlQ = true;
    this.IlY = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(71362);
  }
  
  private void A(TextView paramTextView)
  {
    AppMethodBeat.i(71377);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(this.CwO);
    j localj = locald.aVJ(this.HGf.HXI);
    List localList = locald.fSz();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = "";
    int i;
    if ((localj != null) && (localj.HEA > 0.0D))
    {
      localStringBuilder.append(localj.HEC);
      i = 1;
    }
    for (;;)
    {
      if ((localj != null) && (localj.HEB != 0) && (!Util.isNullOrNil(localStringBuilder)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(localj.HED);
      }
      if ((!Util.isNullOrNil(localStringBuilder)) && (!Util.isNullOrNil((String)localObject)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
        label148:
        localObject = localStringBuilder.toString();
        Log.i("MicroMsg.WcPayCashierDialog", "favor text: %s", new Object[] { localObject });
        if (i == 0) {
          break label330;
        }
        paramTextView.setTextColor(getContext().getResources().getColor(2131099792));
      }
      for (;;)
      {
        paramTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(71377);
        return;
        if (localList.size() <= 0) {
          break label350;
        }
        localObject = locald.fSy();
        if ((localj == null) && (locald.fSx() == 1) && (localObject != null) && (((j)localObject).HEB == 0) && (this.IlQ) && (this.CwO.HZe.HEG != null) && (this.CwO.HZe.HEG.HEc == 1))
        {
          localObject = getContext().getString(2131768202);
          i = 0;
          break;
        }
        localObject = getContext().getString(2131768195);
        i = 1;
        break;
        if (Util.isNullOrNil((String)localObject)) {
          break label148;
        }
        localStringBuilder.append((String)localObject);
        break label148;
        label330:
        paramTextView.setTextColor(getContext().getResources().getColor(2131100584));
      }
      label350:
      i = 1;
    }
  }
  
  private void a(Bankcard paramBankcard, CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(71381);
    if (paramBankcard == null)
    {
      Log.e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.fQb())
    {
      paramCdnImageView.setImageResource(2131235574);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.fQc())
    {
      this.HCH.a(paramBankcard, paramCdnImageView);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.fQf())
    {
      paramCdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), 2131690395));
      if (!Util.isNullOrNil(paramBankcard.HVU))
      {
        paramCdnImageView.setUseSdcardCache(true);
        paramCdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
        paramCdnImageView.gI(paramBankcard.HVU, 2131690395);
        AppMethodBeat.o(71381);
      }
    }
    else
    {
      this.HCH.a(getContext(), paramBankcard, paramCdnImageView);
    }
    AppMethodBeat.o(71381);
  }
  
  private void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, String paramString, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71371);
    Log.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBankcard });
    this.mPayInfo = paramPayInfo;
    this.CwO = paramOrders;
    this.HGf = paramFavorPayInfo;
    if (!paramBoolean2) {
      this.IlN = paramBankcard;
    }
    this.IlP = paramBoolean1;
    this.IlS = paramString;
    fTv();
    fTG();
    fTB();
    fTE();
    fTD();
    fTz();
    fTw();
    id(this.CwO.field_infos);
    fTx();
    fTA();
    fTy();
    if (paramBoolean2) {
      setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71360);
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.HGf);
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
    Log.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
    if (this.IlI != null) {
      this.IlI.dismiss();
    }
    hide();
    this.Ilu.eIj();
    int i;
    label61:
    a locala;
    Object localObject3;
    Object localObject4;
    label120:
    Object localObject5;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label813;
      }
      localObject1 = "";
      com.tencent.mm.wallet_core.c.af.f(i, (String)localObject1, 11, "");
      this.IlI = new a(this.mContext);
      locala = this.IlI;
      localObject2 = this.mPayInfo;
      localObject3 = this.CwO;
      localObject4 = this.IlN;
      if (localObject4 != null) {
        break label825;
      }
      localObject1 = "";
      Log.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      locala.mPayInfo = ((PayInfo)localObject2);
      locala.CwO = ((Orders)localObject3);
      locala.HGf = paramFavorPayInfo;
      locala.HJA = ((Bankcard)localObject4);
      locala.IkW = ((Orders)localObject3).HQg;
      locala.IkX = paramBoolean1;
      locala.IkY = paramInt;
      if (locala.IkX) {
        locala.IkZ = false;
      }
      if (locala.mPayInfo.dVv != 8) {
        break label835;
      }
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.yh(true);
      label238:
      localObject2 = localObject1;
      if (locala.HGf != null)
      {
        if (locala.HGf.HXJ == 0) {
          break label847;
        }
        paramInt = 1;
        label263:
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (locala.IkX) {
            break label852;
          }
          localObject2 = localObject1;
        }
      }
      label283:
      localObject2 = ((List)localObject2).iterator();
      label292:
      if (!((Iterator)localObject2).hasNext()) {
        break label1472;
      }
      localObject3 = (Bankcard)((Iterator)localObject2).next();
      localObject4 = new WcPayCashierBankcardItemLayout(locala.getContext());
      locala.IkV.add(localObject4);
      locala.IkT.addView((View)localObject4);
      if (!((Bankcard)localObject3).fQb()) {
        break label957;
      }
      com.tencent.mm.plugin.wallet_core.utils.a.m(((WcPayCashierBankcardItemLayout)localObject4).qgQ);
      label367:
      if (!((Bankcard)localObject3).fQb()) {
        break label1160;
      }
      localObject1 = t.fQI().Hwc;
      if (Util.isNullOrNil(((Bankcard)localObject1).HVD)) {
        break label1086;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Ild.setText(((Bankcard)localObject1).HVD);
      label407:
      localObject1 = "";
      switch (((Bankcard)localObject3).a(locala.IkW, locala.CwO))
      {
      default: 
        if (!Util.isNullOrNil(((Bankcard)localObject3).field_tips)) {
          localObject1 = ((Bankcard)localObject3).field_tips;
        }
        label490:
        localObject5 = new SpannableStringBuilder((CharSequence)localObject1);
        if ((!Util.isNullOrNil(((Bankcard)localObject3).field_forbid_title)) && (!Util.isNullOrNil(((Bankcard)localObject3).field_forbid_url)))
        {
          ((SpannableStringBuilder)localObject5).append("  ");
          ((SpannableStringBuilder)localObject5).append(((Bankcard)localObject3).field_forbid_title);
          ((SpannableStringBuilder)localObject5).setSpan(new ForegroundColorSpan(locala.getContext().getResources().getColor(2131101350)), ((String)localObject1).length() + 2, ((SpannableStringBuilder)localObject5).length(), 34);
          ((WcPayCashierBankcardItemLayout)localObject4).Ile.setOnClickListener(new a.5(locala, (Bankcard)localObject3));
        }
        if (!Util.isNullOrNil((CharSequence)localObject5))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Ile.setVisibility(0);
          ((WcPayCashierBankcardItemLayout)localObject4).Ile.setText((CharSequence)localObject5);
        }
        if ((locala.IkZ) && (Util.isNullOrNil((CharSequence)localObject5)))
        {
          localObject1 = locala.h((Bankcard)localObject3);
          if (((LinkedList)localObject1).size() > 0)
          {
            ((WcPayCashierBankcardItemLayout)localObject4).Iga.setVisibility(0);
            ((WcPayCashierBankcardItemLayout)localObject4).Ile.setVisibility(8);
            ((WcPayCashierBankcardItemLayout)localObject4).Iga.setWording((LinkedList)localObject1);
          }
        }
        if ((locala.HJA != null) && (((Bankcard)localObject3).field_bindSerial.equals(locala.HJA.field_bindSerial))) {
          ((WcPayCashierBankcardItemLayout)localObject4).Ilf.setChecked(true);
        }
        if (((Bankcard)localObject3).a(locala.IkW, locala.CwO) != 0)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Ilf.setChecked(false);
          ((WcPayCashierBankcardItemLayout)localObject4).Ild.setTextColor(locala.getContext().getResources().getColor(2131100584));
          ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(false);
        }
        break;
      }
    }
    for (;;)
    {
      ((WcPayCashierBankcardItemLayout)localObject4).setOnClickListener(new a.6(locala, (Bankcard)localObject3));
      break label292;
      i = this.mPayInfo.dVv;
      break;
      label813:
      localObject1 = this.mPayInfo.dDL;
      break label61;
      label825:
      localObject1 = ((Bankcard)localObject4).field_desc;
      break label120;
      label835:
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.yh(false);
      break label238;
      label847:
      paramInt = 0;
      break label263;
      label852:
      localObject3 = locala.HGf.HXK;
      localObject2 = new ArrayList();
      paramInt = 0;
      if (paramInt < ((ArrayList)localObject1).size())
      {
        localObject4 = (Bankcard)((ArrayList)localObject1).get(paramInt);
        if (Util.isNullOrNil((String)localObject3)) {
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
      break label283;
      label957:
      if (((Bankcard)localObject3).fQc())
      {
        locala.HCH.a((Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).qgQ);
        break label367;
      }
      if (((Bankcard)localObject3).fQf())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).qgQ.setImageDrawable(com.tencent.mm.svg.a.a.h(locala.getContext().getResources(), 2131690395));
        if (Util.isNullOrNil(((Bankcard)localObject3).HVU)) {
          break label367;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).qgQ.setUseSdcardCache(true);
        ((WcPayCashierBankcardItemLayout)localObject4).qgQ.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
        ((WcPayCashierBankcardItemLayout)localObject4).qgQ.gI(((Bankcard)localObject3).HVU, 2131690395);
        break label367;
      }
      locala.HCH.a(locala.getContext(), (Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).qgQ);
      break label367;
      label1086:
      if (((Bankcard)localObject1).HVC >= 0.0D)
      {
        localObject5 = ((WcPayCashierBankcardItemLayout)localObject4).Ild;
        Context localContext = locala.getContext();
        locala.getContext();
        ((TextView)localObject5).setText(localContext.getString(ah.hhF(), new Object[] { f.D(((Bankcard)localObject1).HVC) }));
        break label407;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Ild.setText("");
      break label407;
      label1160:
      if (((Bankcard)localObject3).fQc())
      {
        localObject1 = t.fQI().IbQ;
        if (!Util.isNullOrNil(((Bankcard)localObject1).HVD))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Ild.setText(((Bankcard)localObject1).HVD);
          break label407;
        }
        if (((Bankcard)localObject1).HVC >= 0.0D)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Ild.setText(locala.getContext().getString(2131767830, new Object[] { f.D(((Bankcard)localObject1).HVC) }));
          break label407;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).Ild.setText("");
        break label407;
      }
      if (((Bankcard)localObject3).fQf())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).Ild.setText(com.tencent.mm.pluginsdk.ui.span.l.b(locala.getContext(), ((Bankcard)localObject3).field_desc, ((WcPayCashierBankcardItemLayout)localObject4).Ild.getTextSize()));
        break label407;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Ild.setText(((Bankcard)localObject3).field_desc);
      break label407;
      localObject1 = ((Bankcard)localObject3).field_forbidWord;
      break label490;
      localObject1 = locala.getContext().getString(2131768119);
      break label490;
      localObject1 = locala.getContext().getString(2131768130);
      break label490;
      localObject1 = locala.getContext().getString(2131768125);
      break label490;
      localObject1 = locala.getContext().getString(2131768121);
      break label490;
      localObject1 = locala.getContext().getString(2131768117);
      break label490;
      localObject1 = locala.getContext().getString(2131768123);
      break label490;
      localObject1 = locala.getContext().getString(2131768128);
      break label490;
      ((WcPayCashierBankcardItemLayout)localObject4).Ild.setTextColor(locala.getContext().getResources().getColor(2131100904));
      ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(true);
    }
    label1472:
    Object localObject1 = new WcPayCashierBankcardItemLayout(locala.getContext());
    ((WcPayCashierBankcardItemLayout)localObject1).qgQ.setVisibility(4);
    ((WcPayCashierBankcardItemLayout)localObject1).Ild.setText(2131768113);
    ((WcPayCashierBankcardItemLayout)localObject1).Ild.setTextColor(locala.getContext().getResources().getColor(2131100685));
    ((WcPayCashierBankcardItemLayout)localObject1).Ilf.setVisibility(8);
    Object localObject2 = locala.fTq();
    if ((locala.IkZ) && (((LinkedList)localObject2).size() > 0))
    {
      ((WcPayCashierBankcardItemLayout)localObject1).Iga.setVisibility(0);
      ((WcPayCashierBankcardItemLayout)localObject1).Ile.setVisibility(8);
      ((WcPayCashierBankcardItemLayout)localObject1).Iga.setWording((LinkedList)localObject2);
    }
    ((WcPayCashierBankcardItemLayout)localObject1).setOnClickListener(new a.7(locala));
    locala.IkT.addView((View)localObject1);
    localObject2 = "";
    localObject1 = localObject2;
    if (locala.CwO != null)
    {
      localObject1 = localObject2;
      if (locala.CwO.HZd != null)
      {
        localObject1 = localObject2;
        if (locala.CwO.HZd.size() > 0) {
          localObject1 = locala.getContext().getString(2131767630, new Object[] { f.d(locala.CwO.dDO, locala.CwO.AOl), ((Orders.Commodity)locala.CwO.HZd.get(0)).desc });
        }
      }
    }
    if ((locala.HGf != null) && (!Util.isNullOrNil(locala.HGf.HXM)))
    {
      locala.IkU.setVisibility(0);
      locala.IkU.setText(locala.HGf.HXM);
      locala.HGf.HXM = "";
    }
    for (;;)
    {
      localObject1 = this.IlI.Ilb;
      this.IlY.add(localObject1);
      this.IlI.Ila = new a.a()
      {
        public final void fNc()
        {
          AppMethodBeat.i(71351);
          Log.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
            WcPayCashierDialog.c(WcPayCashierDialog.this).fNc();
          }
          WcPayCashierDialog.this.dismiss();
          AppMethodBeat.o(71351);
        }
        
        public final void j(Bankcard paramAnonymousBankcard)
        {
          int i = 0;
          AppMethodBeat.i(71350);
          if (paramAnonymousBankcard == null)
          {
            AppMethodBeat.o(71350);
            return;
          }
          Log.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", new Object[] { paramAnonymousBankcard.field_bankName, paramAnonymousBankcard.field_bindSerial });
          if ((WcPayCashierDialog.this.IlN == null) || (!paramAnonymousBankcard.field_bindSerial.equals(WcPayCashierDialog.this.IlN.field_bindSerial)))
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dDL)
          {
            com.tencent.mm.wallet_core.c.af.f(i, str, 13, paramAnonymousBankcard.field_bindSerial);
            WcPayCashierDialog.this.IlN = paramAnonymousBankcard;
            WcPayCashierDialog.this.HGf = paramFavorPayInfo;
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
            i = WcPayCashierDialog.this.mPayInfo.dVv;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(71352);
          Log.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          WcPayCashierDialog.this.show();
          AppMethodBeat.o(71352);
        }
      };
      this.IlI.show();
      AppMethodBeat.o(71394);
      return;
      if (locala.IkY != 0)
      {
        locala.IkU.setVisibility(0);
        locala.IkU.setText((CharSequence)localObject1);
      }
      else
      {
        locala.IkU.setVisibility(8);
      }
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.dVv == 31) || (paramPayInfo.dVv == 32) || (paramPayInfo.dVv == 33));
  }
  
  private static void aT(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71390);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((locala.type() == 1) && ((locala.dJO()) || (locala.dJR())) && (com.tencent.mm.plugin.soter.e.b.flX()) && (com.tencent.mm.plugin.soter.e.b.flW()) && (com.tencent.soter.core.a.hlf() == 0))
    {
      Log.i("MicroMsg.WcPayCashierDialog", "may treble init error");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 23);
      if (locala.type() == 2)
      {
        if (com.tencent.soter.core.a.hlf() != 0) {
          break label246;
        }
        com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 28);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 27);
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 33);
      }
      AppMethodBeat.o(71390);
      return;
      if (locala.type() != 2) {
        break;
      }
      if (com.tencent.soter.core.a.hlf() == 1)
      {
        if (!com.tencent.soter.core.a.hlh())
        {
          Log.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
          com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 24);
          break;
        }
        if (paramBoolean1) {
          break;
        }
        Log.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
        com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 25);
        break;
      }
      if (paramBoolean1) {
        break;
      }
      Log.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 26);
      break;
      label246:
      com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 31);
    }
  }
  
  private void aeW(int paramInt)
  {
    AppMethodBeat.i(71386);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.Ilv.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.Ilw.getLayoutParams();
    if (paramInt == 0) {
      localLayoutParams1.topMargin = Ilo;
    }
    for (localLayoutParams2.topMargin = Ilo;; localLayoutParams2.topMargin = Iln)
    {
      this.Ilv.setLayoutParams(localLayoutParams1);
      this.Ilw.setLayoutParams(localLayoutParams2);
      this.Ily.setVisibility(paramInt);
      AppMethodBeat.o(71386);
      return;
      localLayoutParams1.topMargin = Ilm;
    }
  }
  
  private void fTA()
  {
    AppMethodBeat.i(71380);
    if (!this.IlP)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
      this.IlE.setVisibility(8);
      AppMethodBeat.o(71380);
      return;
    }
    this.IlE.setVisibility(0);
    this.IlE.Cqw.setText(2131768494);
    this.IlE.Ili.setVisibility(0);
    this.IlE.Ilj.setVisibility(0);
    this.IlE.fTs();
    this.IlE.setOnClickListener(new WcPayCashierDialog.4(this));
    this.IlE.Ili.setImageBitmap(null);
    a(this.IlN, this.IlE.Ili);
    if (this.IlN == null) {}
    for (String str = "";; str = this.IlN.field_desc)
    {
      Object localObject = str;
      if (this.IlN != null)
      {
        localObject = str;
        if (this.IlN.fQf()) {
          localObject = com.tencent.mm.pluginsdk.ui.span.l.c(this.mContext, str);
        }
      }
      this.IlE.U((CharSequence)localObject);
      AppMethodBeat.o(71380);
      return;
    }
  }
  
  private void fTB()
  {
    AppMethodBeat.i(71382);
    fTC();
    fTF();
    AppMethodBeat.o(71382);
  }
  
  private void fTC()
  {
    AppMethodBeat.i(71383);
    Object localObject2 = "";
    Object localObject1;
    if (this.IlV)
    {
      localObject1 = this.IlT;
      this.Ilr.setText((CharSequence)localObject1);
      AppMethodBeat.o(71383);
      return;
    }
    if (this.mPayInfo.iqp == null)
    {
      localObject1 = "";
      label49:
      if (Util.isNullOrNil((String)localObject1)) {
        break label211;
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil((String)localObject1)) || (this.CwO == null) || (this.CwO.HZd == null)) {
        break label1104;
      }
      Object localObject3 = (Orders.Commodity)this.CwO.HZd.get(0);
      if (localObject3 == null) {
        break label1138;
      }
      localObject1 = ((Orders.Commodity)localObject3).AOa;
      localObject2 = localObject1;
      if (a(this.mPayInfo))
      {
        localObject2 = localObject1;
        if (!Util.isNullOrNil((String)localObject1)) {
          localObject2 = (String)localObject1 + "\n";
        }
        localObject2 = (String)localObject2 + ((Orders.Commodity)localObject3).desc;
      }
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = ((Orders.Commodity)localObject3).desc;
      break;
      localObject1 = this.mPayInfo.iqp.getString("extinfo_key_19", "");
      break label49;
      label211:
      if ((this.mPayInfo.dVv == 32) || (this.mPayInfo.dVv == 33))
      {
        String str1 = this.mPayInfo.iqp.getString("extinfo_key_5", "");
        String str2 = this.mPayInfo.iqp.getString("extinfo_key_1", "");
        localObject3 = getContext().getString(2131768199);
        localObject1 = localObject2;
        if (!Util.isNullOrNil(str1))
        {
          localObject3 = str1;
          localObject1 = str1;
        }
        if (!Util.isNullOrNil(str2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(str2);
          if (localObject2 != null)
          {
            localObject1 = ((as)localObject2).arJ();
            localObject2 = new StringBuilder().append(f.bpz((String)localObject1));
            if (Util.isNullOrNil(this.mPayInfo.Cpg)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.Cpg + ")")
            {
              localObject1 = Util.safeFormatString((String)localObject3, new Object[] { (String)localObject1 });
              break;
            }
          }
          Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(str2)));
        }
        else
        {
          Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        }
      }
      else if (this.mPayInfo.dVv == 31)
      {
        localObject1 = this.mPayInfo.iqp.getString("extinfo_key_1", "");
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((as)localObject3).arI();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (Util.isNullOrNil(this.mPayInfo.Cpg)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.Cpg + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131768199, new Object[] { (String)localObject1 });
              break;
            }
          }
          Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dVv == 42)
      {
        localObject1 = this.mPayInfo.iqp.getString("extinfo_key_1", "");
        if (!Util.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.kernel.g.aAi();
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((as)localObject3).arI();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (Util.isNullOrNil(this.mPayInfo.Cpg)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.Cpg + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131768192, new Object[] { (String)localObject1 });
              break;
            }
          }
          Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dVv == 48)
      {
        localObject1 = getContext().getString(2131764111);
      }
      else if (this.mPayInfo.dVv == 49)
      {
        localObject1 = this.mPayInfo.iqp.getString("extinfo_key_1", "");
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = getContext().getString(2131768199, new Object[] { localObject1 });
        }
        else
        {
          Log.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dVv) });
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.dVv == 56)
      {
        localObject1 = this.mPayInfo.iqp.getString("extinfo_key_12", "");
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.e("MicroMsg.WcPayCashierDialog", "title is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.dVv) });
          localObject1 = localObject2;
        }
      }
      else if ((this.mPayInfo.dVv == 45) || (this.mPayInfo.dVv == 52))
      {
        localObject1 = getContext().getString(2131767947);
      }
      else
      {
        localObject1 = localObject2;
        if (this.mPayInfo.dVv == 11) {
          localObject1 = getContext().getString(2131767477);
        }
      }
    }
    label1104:
    localObject2 = new StringBuilder("orders null?:");
    if (this.CwO == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.w("MicroMsg.WcPayCashierDialog", bool);
      label1138:
      break;
    }
  }
  
  private void fTD()
  {
    AppMethodBeat.i(71384);
    if (!Util.isNullOrNil(this.IlS))
    {
      this.Ijg.setText(this.IlS);
      this.Ijg.setVisibility(0);
      AppMethodBeat.o(71384);
      return;
    }
    this.Ijg.setVisibility(8);
    AppMethodBeat.o(71384);
  }
  
  private void fTE()
  {
    AppMethodBeat.i(71385);
    if ((this.IlQ) && (this.CwO.HZe.HEG != null) && (this.CwO.HZe.HEG.HEc == 1))
    {
      final com.tencent.mm.plugin.wallet.a.b localb = this.CwO.HZe.HEG;
      this.Ilz.setUrl(localb.HEj);
      this.IlA.setText(localb.HEe);
      if (!Util.isNullOrNil(localb.HEf)) {
        this.IlA.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(localb.HEf, true));
      }
      this.IlB.setText(localb.HEg);
      if (!Util.isNullOrNil(localb.HEh)) {
        this.IlB.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(localb.HEh, true));
      }
      this.IlB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
          WcPayCashierDialog.t(WcPayCashierDialog.this);
          WcPayCashierDialog.this.IlN = t.fQI().aVm(localb.HEb.ANo);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(WcPayCashierDialog.this.CwO).aVM(localb.HEd);
          Log.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", new Object[] { paramAnonymousView.HXI });
          if (paramAnonymousView.HXI.equals("0")) {
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
            WcPayCashierDialog.this.HGf = paramAnonymousView;
          }
        }
      });
      aeW(0);
      AppMethodBeat.o(71385);
      return;
    }
    aeW(8);
    AppMethodBeat.o(71385);
  }
  
  private void fTF()
  {
    AppMethodBeat.i(71387);
    Object localObject1;
    if (this.IlV) {
      localObject1 = this.IlU;
    }
    for (;;)
    {
      this.Ils.setText((CharSequence)localObject1);
      AppMethodBeat.o(71387);
      return;
      Object localObject2 = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(this.CwO);
      localObject1 = f.d(this.CwO.dDO, this.CwO.AOl);
      this.IlR = false;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).aVJ(this.HGf.HXI);
        localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject2).fSz();
        if ((localObject1 != null) && (((j)localObject1).HEA > 0.0D))
        {
          this.IlR = true;
          localObject1 = f.d(((j)localObject1).HEz, this.CwO.AOl);
        }
        else if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = f.d(((j)localObject1).HEz, this.CwO.AOl);
        }
        else
        {
          localObject1 = f.d(this.CwO.dDO, this.CwO.AOl);
        }
      }
    }
  }
  
  private void fTG()
  {
    AppMethodBeat.i(71388);
    fTH();
    Log.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", new Object[] { Integer.valueOf(this.CwO.HZa) });
    if (this.IlK == 0)
    {
      boolean bool;
      if (this.IlL > 0) {
        bool = false;
      }
      for (;;)
      {
        yv(bool);
        AppMethodBeat.o(71388);
        return;
        if (this.IlM == 1)
        {
          this.Ilx.setVisibility(8);
          bool = true;
        }
        else
        {
          if (this.IlM != 3) {
            break;
          }
          this.Ilx.setText(2131767706);
          this.Ilx.setVisibility(0);
          bool = true;
        }
      }
      if (this.mPayInfo.Kxu == 100102)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUC, Boolean.TRUE);
        com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        locala.pj(false);
        locala.pk(false);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUA, Boolean.FALSE);
        this.Ilx.setText(2131767713);
      }
      for (;;)
      {
        this.Ilx.setTextColor(getContext().getResources().getColor(2131101376));
        this.Ilx.setVisibility(0);
        bool = true;
        break;
        this.Ilx.setText(2131767706);
      }
    }
    if (this.IlK == 1)
    {
      fTI();
      AppMethodBeat.o(71388);
      return;
    }
    if (this.IlK == 2) {
      fTJ();
    }
    AppMethodBeat.o(71388);
  }
  
  private void fTH()
  {
    AppMethodBeat.i(71389);
    Log.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", new Object[] { Integer.valueOf(this.CwO.HZa) });
    com.tencent.mm.plugin.fingerprint.d.a locala;
    boolean bool3;
    if (this.CwO.HZa == 1)
    {
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.dJT()) && (locala.dJU()) && (!locala.dJP()) && (locala.dJO()) && (locala.dJX()))
      {
        this.IlL = 1;
        bool3 = p.wFK.wFM;
        if ((t.fQI() == null) || (this.IlL <= 0)) {
          break label484;
        }
      }
    }
    label148:
    label332:
    label484:
    for (boolean bool2 = locala.dKa();; bool2 = true)
    {
      aT(bool2, bool3);
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        bool2 &= bool1;
        if (bool2) {
          break label332;
        }
        p.wFK.wFM = true;
        this.IlL = 0;
        this.IlM = 3;
        this.mPayInfo.HZb = true;
        p.wFK.wFM = true;
      }
      for (;;)
      {
        this.IlK = this.IlL;
        Log.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(this.mPayInfo.Kxu), Integer.valueOf(this.IlK), Integer.valueOf(this.IlL) });
        AppMethodBeat.o(71389);
        return;
        if ((locala.dKb()) && (locala.dKc()) && (!locala.dJQ()) && (locala.dJR()) && (locala.dJX()))
        {
          this.IlL = 2;
          break;
        }
        this.IlL = 0;
        this.IlM = 2;
        break;
        bool1 = false;
        break label148;
        if ((this.mPayInfo.Kxu == 100000) || (this.mPayInfo.Kxu == 100102))
        {
          if (this.mPayInfo.Kxu == 100000) {
            this.mPayInfo.Ijy = 0;
          }
          this.IlL = 0;
          this.IlM = 4;
        }
      }
      this.IlK = 0;
      this.IlL = 0;
      this.IlM = 1;
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.dJT()) && (locala.dJU()) && (!locala.dJP()) && (locala.dJO()))
      {
        Log.w("MicroMsg.WcPayCashierDialog", "wired case");
        com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 2);
      }
      AppMethodBeat.o(71389);
      return;
    }
  }
  
  private void fTI()
  {
    AppMethodBeat.i(71392);
    this.IlK = 1;
    this.mPayInfo.Ijy = 1;
    this.Ilv.setVisibility(8);
    this.Ilw.setVisibility(0);
    this.Ilu.eIj();
    fTu();
    this.Ilp.setVisibility(8);
    this.Ilq.setText(2131768203);
    AppMethodBeat.o(71392);
  }
  
  private void fTJ()
  {
    AppMethodBeat.i(71393);
    this.IlK = 2;
    this.mPayInfo.Ijy = 1;
    this.Ilv.setVisibility(8);
    this.Ilw.setVisibility(0);
    this.Ilu.eIj();
    fTu();
    this.Ilp.setVisibility(8);
    this.Ilq.setText(2131768203);
    AppMethodBeat.o(71393);
  }
  
  private void fTt()
  {
    AppMethodBeat.i(71366);
    if (!this.IlC.isShown())
    {
      this.IlC.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772161);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.IlC.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71366);
  }
  
  private void fTu()
  {
    AppMethodBeat.i(71367);
    if (this.IlC.isShown())
    {
      this.IlC.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772162);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.IlC.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71367);
  }
  
  private void fTv()
  {
    AppMethodBeat.i(71373);
    Object localObject1 = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(this.CwO);
    if (localObject1 != null) {
      if ((this.HGf != null) && (this.IlN != null)) {
        if (!this.IlN.field_bankcardType.equalsIgnoreCase("CFT")) {
          break label449;
        }
      }
    }
    label286:
    label295:
    label305:
    label449:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { this.HGf.HXI, Boolean.valueOf(bool) });
      String str = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).cG(this.HGf.HXI, bool);
      Log.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str });
      Object localObject3 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aVH(str);
      Object localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).cF(str, true);
      d.a locala1 = (d.a)((Map)localObject3).get(this.IlN.field_bindSerial);
      d.a locala2 = (d.a)((Map)localObject2).get(this.IlN.field_bankcardType);
      j localj = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).cE(str, bool);
      if (localj == null)
      {
        localObject1 = "";
        if (locala1 != null) {
          break label286;
        }
        localObject2 = "";
        label193:
        if (locala2 != null) {
          break label295;
        }
      }
      for (localObject3 = "";; localObject3 = locala2.toString())
      {
        Log.i("MicroMsg.WcPayCashierDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((locala1 == null) || (locala1.IcR == null) || (Util.isNullOrNil(locala1.IcR.HEJ))) {
          break label305;
        }
        this.HGf.HXI = locala1.IcR.HEJ;
        AppMethodBeat.o(71373);
        return;
        localObject1 = localj.HEJ;
        break;
        localObject2 = locala1.toString();
        break label193;
      }
      if ((locala2 != null) && (locala2.IcR != null) && (!Util.isNullOrNil(locala2.IcR.HEJ)))
      {
        this.HGf.HXI = locala2.IcR.HEJ;
        AppMethodBeat.o(71373);
        return;
      }
      if (localj != null)
      {
        this.HGf.HXI = localj.HEJ;
        AppMethodBeat.o(71373);
        return;
      }
      this.HGf.HXI = str;
      AppMethodBeat.o(71373);
      return;
      if (this.CwO.HZe != null)
      {
        this.HGf = ((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aVM(((com.tencent.mm.plugin.wallet_core.ui.d)localObject1).aVN(this.CwO.HZe.HEt));
        AppMethodBeat.o(71373);
        return;
        Log.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
      }
      AppMethodBeat.o(71373);
      return;
    }
  }
  
  private void fTw()
  {
    AppMethodBeat.i(71374);
    if (this.IlR)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
      if (this.IlG != null)
      {
        this.Ilt.removeView(this.IlG);
        this.IlG = null;
      }
      AppMethodBeat.o(71374);
      return;
    }
    if ((!Util.isNullOrNil(this.CwO.HZv)) && (!Util.isNullOrNil(this.CwO.HZw)))
    {
      this.IlG = new WcPayCashierDetailItemLayout(getContext());
      this.Ilt.addView(this.IlG, 0);
      this.IlG.Ili.setVisibility(8);
      this.IlG.Ilj.setVisibility(8);
      this.IlG.Cqw.setText(2131768491);
      this.IlG.fTs();
      if ((this.CwO.HZv.equals("CNY")) && (!Util.isNullOrNil(this.CwO.HZu)))
      {
        localStringBuilder = new StringBuilder(this.CwO.HZw);
        localStringBuilder.append(this.CwO.HZu);
        if ((!Util.isNullOrNil(this.CwO.HZy)) && (!Util.isNullOrNil(this.CwO.HZz))) {
          localStringBuilder.append(String.format("(%s%s)", new Object[] { this.CwO.HZz, this.CwO.HZx }));
        }
        this.IlG.qWU.setText(localStringBuilder);
        AppMethodBeat.o(71374);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(this.CwO.HZw);
      localStringBuilder.append(this.CwO.HZu);
      this.IlG.qWU.setText(localStringBuilder);
    }
    AppMethodBeat.o(71374);
  }
  
  private void fTx()
  {
    AppMethodBeat.i(71375);
    com.tencent.mm.plugin.wallet_core.ui.d locald = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(this.CwO);
    if ((this.HGf == null) || ((locald != null) && (!locald.fSw())))
    {
      this.Ilt.removeView(this.IlF);
      this.IlF = null;
      AppMethodBeat.o(71375);
      return;
    }
    if (this.IlF == null)
    {
      this.IlF = new WcPayCashierDetailItemLayout(getContext());
      this.Ilt.addView(this.IlF);
      this.IlF.Cqw.setText(2131768489);
      this.IlF.Ili.setVisibility(8);
      this.IlF.Ilj.setVisibility(0);
      this.IlF.qWU.setTextColor(getContext().getResources().getColor(2131099792));
      this.IlF.fTs();
      this.IlF.setOnClickListener(new x()
      {
        public final void czW()
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dDL)
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
            i = WcPayCashierDialog.this.mPayInfo.dVv;
            break;
          }
          label109:
          WcPayCashierDialog.a(WcPayCashierDialog.this, n.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.CwO, WcPayCashierDialog.this.HGf.HXI, new n.b()new DialogInterface.OnCancelListener
          {
            public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
            {
              int i = 0;
              AppMethodBeat.i(71338);
              Log.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", new Object[] { paramAnonymous2FavorPayInfo.HXI });
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              Object localObject;
              if (WcPayCashierDialog.this.mPayInfo == null)
              {
                if (WcPayCashierDialog.this.mPayInfo != null) {
                  break label226;
                }
                localObject = "";
                label66:
                com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 15, paramAnonymous2FavorPayInfo.HXI);
                localObject = com.tencent.mm.plugin.wallet_core.ui.d.cI(paramAnonymous2FavorPayInfo.HXJ, paramAnonymous2FavorPayInfo.HXK);
                WcPayCashierDialog.this.HGf.HXM = "";
                if (!com.tencent.mm.plugin.wallet_core.ui.d.a(paramAnonymous2FavorPayInfo, WcPayCashierDialog.this.IlN)) {
                  break label265;
                }
                if (((List)localObject).size() != 0) {
                  break label243;
                }
                paramAnonymous2FavorPayInfo.HXM = WcPayCashierDialog.this.getContext().getString(2131767701);
                label149:
                WcPayCashierDialog.b(WcPayCashierDialog.this, paramAnonymous2FavorPayInfo);
              }
              for (;;)
              {
                WcPayCashierDialog.p(WcPayCashierDialog.this);
                WcPayCashierDialog.q(WcPayCashierDialog.this);
                WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.r(WcPayCashierDialog.this).qWU);
                AppMethodBeat.o(71338);
                return;
                i = WcPayCashierDialog.this.mPayInfo.dVv;
                break;
                label226:
                localObject = WcPayCashierDialog.this.mPayInfo.dDL;
                break label66;
                label243:
                paramAnonymous2FavorPayInfo.HXM = WcPayCashierDialog.this.getContext().getString(2131767702);
                break label149;
                label265:
                WcPayCashierDialog.this.HGf = paramAnonymous2FavorPayInfo;
                WcPayCashierDialog.this.show();
              }
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(71339);
              Log.i("MicroMsg.WcPayCashierDialog", "on cancel");
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              WcPayCashierDialog.this.show();
              AppMethodBeat.o(71339);
            }
          }));
          AppMethodBeat.o(71340);
        }
      });
    }
    A(this.IlF.qWU);
    AppMethodBeat.o(71375);
  }
  
  private void fTy()
  {
    AppMethodBeat.i(71378);
    if ((this.Ilt.getChildCount() == 0) && (this.IlE.getVisibility() == 8))
    {
      Log.d("MicroMsg.WcPayCashierDialog", "invisible divider");
      this.zlb.setVisibility(8);
      AppMethodBeat.o(71378);
      return;
    }
    this.zlb.setVisibility(0);
    AppMethodBeat.o(71378);
  }
  
  private void fTz()
  {
    AppMethodBeat.i(71379);
    if (!this.IlR)
    {
      if (this.IlD != null)
      {
        this.Ilt.removeView(this.IlD);
        this.IlD = null;
      }
      AppMethodBeat.o(71379);
      return;
    }
    Object localObject1;
    if (this.IlD == null)
    {
      this.IlD = new WcPayCashierDetailItemLayout(getContext());
      this.Ilt.addView(this.IlD, 0);
      this.IlD.Cqw.setText(2131768493);
      this.IlD.Ili.setVisibility(8);
      this.IlD.Ilj.setVisibility(8);
      this.IlD.fTs();
      localObject1 = f.aqk(7);
    }
    try
    {
      this.IlD.qWU.setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject1));
      this.IlD.qWU.getPaint().setFlags(16);
      str = "";
      localObject1 = str;
      if (!Util.isNullOrNil(this.CwO.HZu))
      {
        localObject1 = str;
        if (!Util.isNullOrNil(this.CwO.HZw)) {
          localObject1 = String.format("%s%s", new Object[] { this.CwO.HZw, this.CwO.HZu });
        }
      }
      str = f.d(this.CwO.dDO, this.CwO.AOl);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = String.format("%s(%s)", new Object[] { str, localObject1 });
        this.IlD.qWU.setText((CharSequence)localObject1);
        AppMethodBeat.o(71379);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        Log.e("MicroMsg.WcPayCashierDialog", "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
        Object localObject2 = str;
      }
    }
  }
  
  private void id(List<egf> paramList)
  {
    AppMethodBeat.i(71372);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        final egf localegf = (egf)paramList.next();
        WcPayCashierDetailItemLayout localWcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
        localWcPayCashierDetailItemLayout.Ili.setVisibility(8);
        if ((localegf.Ngf != null) && (localegf.Ngf.size() > 0)) {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.Cqw, (ehf)localegf.Ngf.get(0), null);
        }
        if ((localegf.Ngg != null) && (localegf.Ngg.size() > 0))
        {
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.qWU, (ehf)localegf.Ngg.get(0), null);
          label149:
          if (localegf.Ngh == null) {
            break label267;
          }
          int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          int j = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
          com.tencent.mm.plugin.wallet_core.utils.g.a(localWcPayCashierDetailItemLayout.Ilj, localegf.Ngh, 2131689716, i, j, true);
          localWcPayCashierDetailItemLayout.Ilj.setVisibility(0);
        }
        for (;;)
        {
          localWcPayCashierDetailItemLayout.fTs();
          if (localegf.KEP != null) {
            localWcPayCashierDetailItemLayout.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(71337);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
                Log.i("MicroMsg.WcPayCashierDialog", "click item: %s", new Object[] { localegf.KEP.url });
                if ((localegf.KEP.type == 13) && (localegf.KEP.MTl != null) && ("fetchfavordialog".equals(localegf.KEP.url)))
                {
                  paramAnonymousView = new b(WcPayCashierDialog.n(WcPayCashierDialog.this));
                  if ((localegf.KEP.MTl.LpX.size() > 0) && (((erb)localegf.KEP.MTl.LpX.get(0)).NoG != null))
                  {
                    localObject1 = ((erb)localegf.KEP.MTl.LpX.get(0)).NoG.Mjq;
                    Object localObject2 = localegf.KEP.MTl.LpV.KEN;
                    if (localObject2 != null) {
                      com.tencent.mm.plugin.wallet_core.utils.g.a(paramAnonymousView.mPa, (ehf)localObject2, null);
                    }
                    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                    {
                      localObject1 = ((List)localObject1).iterator();
                      while (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (egf)((Iterator)localObject1).next();
                        View localView = View.inflate(paramAnonymousView.getContext(), 2131497036, null);
                        TextView localTextView1 = (TextView)localView.findViewById(2131310582);
                        TextView localTextView2 = (TextView)localView.findViewById(2131310580);
                        if ((((egf)localObject2).Ngf != null) && (((egf)localObject2).Ngf.size() > 0))
                        {
                          com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView1, (ehf)((egf)localObject2).Ngf.get(0), null);
                          if (((egf)localObject2).Ngf.size() >= 2) {
                            com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView2, (ehf)((egf)localObject2).Ngf.get(1), null);
                          }
                        }
                        paramAnonymousView.Imh.addView(localView);
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
          this.Ilt.addView(localWcPayCashierDetailItemLayout);
          break;
          localWcPayCashierDetailItemLayout.qWU.setVisibility(8);
          localWcPayCashierDetailItemLayout.Cqw.setMaxWidth(2147483647);
          break label149;
          label267:
          localWcPayCashierDetailItemLayout.Ilj.setVisibility(8);
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
        Log.i("MicroMsg.WcPayCashierDialog", "on canceled");
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
        Log.i("MicroMsg.WcPayCashierDialog", "on dismissed");
        WcPayCashierDialog.b(WcPayCashierDialog.this);
        WcPayCashierDialog.d(WcPayCashierDialog.this);
        AppMethodBeat.o(71353);
      }
    });
    ((MMActivity)this.mContext).getLifecycle().addObserver(this);
    this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71364);
  }
  
  private void initView()
  {
    AppMethodBeat.i(71365);
    this.nmW = ((ViewGroup)View.inflate(getContext(), 2131497035, null));
    this.IkS = ((ImageView)this.nmW.findViewById(2131310555));
    this.Ilp = ((TextView)this.nmW.findViewById(2131310559));
    this.Ilq = ((TextView)this.nmW.findViewById(2131310569));
    this.Ilr = ((TextView)this.nmW.findViewById(2131310564));
    this.Ijg = ((TextView)this.nmW.findViewById(2131310554));
    this.Ils = ((WalletTextView)this.nmW.findViewById(2131310565));
    this.Ilt = ((ViewGroup)this.nmW.findViewById(2131310558));
    this.Ilu = ((EditHintPasswdView)this.nmW.findViewById(2131310567));
    this.Ilv = ((ViewGroup)this.nmW.findViewById(2131310568));
    this.IlE = ((WcPayCashierDetailItemLayout)this.nmW.findViewById(2131310566));
    this.Ilw = ((Button)this.nmW.findViewById(2131310556));
    this.Ilx = ((TextView)this.nmW.findViewById(2131310560));
    this.Ily = ((ViewGroup)this.nmW.findViewById(2131310553));
    this.Ilz = ((CdnImageView)this.nmW.findViewById(2131310563));
    this.IlA = ((TextView)this.nmW.findViewById(2131310562));
    this.IlB = ((Button)this.nmW.findViewById(2131310561));
    this.mKeyboard = ((MyKeyboardWindow)this.nmW.findViewById(2131308962));
    this.IlC = ((ViewGroup)this.nmW.findViewById(2131308960));
    this.zlb = this.nmW.findViewById(2131310557);
    Object localObject = this.IkS;
    int i = Ill;
    int j = Ill;
    Util.expandViewTouchArea((View)localObject, i, i, j, j);
    localObject = ar.m(getContext(), 2131689494, getContext().getResources().getColor(2131100045));
    this.IkS.setImageDrawable((Drawable)localObject);
    this.IkS.setOnClickListener(new WcPayCashierDialog.10(this));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Ilu);
    this.Ilu.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71355);
        if (paramAnonymousBoolean)
        {
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.e(WcPayCashierDialog.this).getText(), WcPayCashierDialog.this.HGf);
          com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71355);
      }
    });
    localObject = (EditText)this.nmW.findViewById(2131310180);
    f.setNoSystemInputOnEditText((EditText)localObject);
    this.mKeyboard.setInputEditText((EditText)localObject);
    if (Build.VERSION.SDK_INT >= 14)
    {
      com.tencent.mm.ui.a.d locald = new com.tencent.mm.ui.a.d();
      this.mKeyboard.setSecureAccessibility(locald);
      ((EditText)localObject).setAccessibilityDelegate(locald);
    }
    ((EditText)localObject).setOnClickListener(new WcPayCashierDialog.12(this));
    this.nmW.findViewById(2131308963).setOnClickListener(new WcPayCashierDialog.13(this));
    this.Ilw.setOnClickListener(new x()
    {
      public final void czW()
      {
        int i = 0;
        AppMethodBeat.i(71358);
        Log.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", new Object[] { Integer.valueOf(WcPayCashierDialog.h(WcPayCashierDialog.this)) });
        if (WcPayCashierDialog.this.mPayInfo == null) {
          if (WcPayCashierDialog.this.mPayInfo != null) {
            break label113;
          }
        }
        label113:
        for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.dDL)
        {
          com.tencent.mm.wallet_core.c.af.f(i, str, 20, "");
          WcPayCashierDialog.i(WcPayCashierDialog.this);
          if (WcPayCashierDialog.h(WcPayCashierDialog.this) != 1) {
            break label127;
          }
          WcPayCashierDialog.j(WcPayCashierDialog.this);
          f.aqm(9);
          AppMethodBeat.o(71358);
          return;
          i = WcPayCashierDialog.this.mPayInfo.dVv;
          break;
        }
        label127:
        if (WcPayCashierDialog.h(WcPayCashierDialog.this) == 2)
        {
          WcPayCashierDialog.k(WcPayCashierDialog.this);
          AppMethodBeat.o(71358);
          return;
        }
        Log.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
        WcPayCashierDialog.l(WcPayCashierDialog.this);
        AppMethodBeat.o(71358);
      }
    });
    this.Ilq.setOnClickListener(new WcPayCashierDialog.15(this));
    AppMethodBeat.o(71365);
  }
  
  private void yv(boolean paramBoolean)
  {
    AppMethodBeat.i(71391);
    Log.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.IlK = 0;
    this.mPayInfo.Ijy = 0;
    this.Ilv.setVisibility(0);
    this.Ilw.setVisibility(8);
    this.Ilu.eIj();
    fTt();
    this.Ilp.setVisibility(0);
    if (paramBoolean)
    {
      this.Ilq.setVisibility(8);
      AppMethodBeat.o(71391);
      return;
    }
    this.Ilq.setVisibility(0);
    AppMethodBeat.o(71391);
  }
  
  public final void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71370);
    a(paramPayInfo, paramOrders, paramFavorPayInfo, "", paramBankcard, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(71370);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, List<egf> paramList)
  {
    AppMethodBeat.i(71369);
    this.IlT = paramString1;
    this.IlU = paramString2;
    this.IlS = paramString3;
    this.IlV = true;
    this.IlP = false;
    fTG();
    fTB();
    fTD();
    id(paramList);
    fTA();
    fTy();
    AppMethodBeat.o(71369);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71368);
    Log.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
    this.Ilu.eIj();
    AppMethodBeat.o(71368);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71363);
    super.onCreate(paramBundle);
    setContentView(this.nmW);
    paramBundle = getWindow();
    paramBundle.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle.addFlags(67108864);
    com.tencent.mm.compatible.util.d.oD(21);
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
    
    public abstract void fNc();
    
    public abstract void onCancel();
  }
  
  public static abstract interface b
  {
    public abstract void fTr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog
 * JD-Core Version:    0.7.0.1
 */