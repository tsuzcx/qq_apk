package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.b.a;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WcPayCashierDialog
  extends i
  implements LifecycleObserver
{
  public static final int uuP;
  public static final int uuQ;
  public static final int uuR;
  public static final int uuS;
  private ViewGroup iux;
  private View lNu;
  private Context mContext;
  private MyKeyboardWindow mKeyboard;
  public PayInfo mPayInfo;
  public Orders qrf;
  private com.tencent.mm.plugin.wallet_core.utils.a tSy;
  public FavorPayInfo tVQ;
  private TextView usK;
  private TextView uuT;
  private TextView uuU;
  private TextView uuV;
  private WalletTextView uuW;
  private ViewGroup uuX;
  private EditHintPasswdView uuY;
  private ViewGroup uuZ;
  private ImageView uuw;
  private boolean uvA;
  public WcPayCashierDialog.a uvB;
  List<WcPayCashierDialog.b> uvC;
  private Button uva;
  private TextView uvb;
  private ViewGroup uvc;
  private CdnImageView uvd;
  private TextView uve;
  private Button uvf;
  private ViewGroup uvg;
  private WcPayCashierDetailItemLayout uvh;
  private WcPayCashierDetailItemLayout uvi;
  private WcPayCashierDetailItemLayout uvj;
  private WcPayCashierDetailItemLayout uvk;
  private WcPayCashierFingerprintDialog uvl;
  private a uvm;
  private com.tencent.mm.plugin.wallet_core.ui.l uvn;
  private int uvo;
  private int uvp;
  private int uvq;
  public Bankcard uvr;
  private boolean uvs;
  private boolean uvt;
  private boolean uvu;
  private boolean uvv;
  private String uvw;
  private String uvx;
  private String uvy;
  private boolean uvz;
  
  static
  {
    AppMethodBeat.i(47823);
    uuP = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 30);
    uuQ = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 32);
    uuR = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 36);
    uuS = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 23);
    AppMethodBeat.o(47823);
  }
  
  public WcPayCashierDialog(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(47781);
    this.uvo = 0;
    this.uvp = 0;
    this.uvq = 0;
    this.mPayInfo = new PayInfo();
    this.qrf = new Orders();
    this.uvs = false;
    this.uvu = true;
    this.uvC = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(47781);
  }
  
  public WcPayCashierDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(142549);
    this.uvo = 0;
    this.uvp = 0;
    this.uvq = 0;
    this.mPayInfo = new PayInfo();
    this.qrf = new Orders();
    this.uvs = false;
    this.uvu = true;
    this.uvC = new ArrayList();
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(142549);
  }
  
  private void IJ(int paramInt)
  {
    AppMethodBeat.i(47799);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.uuZ.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.uva.getLayoutParams();
    if (paramInt == 0) {
      localLayoutParams1.topMargin = uuS;
    }
    for (localLayoutParams2.topMargin = uuS;; localLayoutParams2.topMargin = uuR)
    {
      this.uuZ.setLayoutParams(localLayoutParams1);
      this.uva.setLayoutParams(localLayoutParams2);
      this.uvc.setVisibility(paramInt);
      AppMethodBeat.o(47799);
      return;
      localLayoutParams1.topMargin = uuQ;
    }
  }
  
  private void a(Bankcard paramBankcard, CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(47794);
    if (paramBankcard == null)
    {
      ab.e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(47794);
      return;
    }
    if (paramBankcard.cTf())
    {
      paramCdnImageView.setImageResource(2130840794);
      AppMethodBeat.o(47794);
      return;
    }
    if (paramBankcard.cTg())
    {
      this.tSy.a(paramBankcard, paramCdnImageView);
      AppMethodBeat.o(47794);
      return;
    }
    if (paramBankcard.cTj())
    {
      paramCdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131231407));
      if (!bo.isNullOrNil(paramBankcard.uge))
      {
        paramCdnImageView.setUseSdcardCache(true);
        paramCdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.cVf());
        paramCdnImageView.eq(paramBankcard.uge, 2131231407);
        AppMethodBeat.o(47794);
      }
    }
    else
    {
      this.tSy.a(getContext(), paramBankcard, paramCdnImageView);
    }
    AppMethodBeat.o(47794);
  }
  
  private void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, String paramString, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47785);
    ab.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBankcard });
    this.mPayInfo = paramPayInfo;
    this.qrf = paramOrders;
    this.tVQ = paramFavorPayInfo;
    this.uvr = paramBankcard;
    this.uvt = paramBoolean1;
    this.uvw = paramString;
    cWk();
    cWv();
    cWq();
    cWt();
    cWs();
    cWo();
    cWl();
    ea(this.qrf.field_infos);
    cWm();
    cWp();
    cWn();
    if (paramBoolean2) {
      setOnShowListener(new WcPayCashierDialog.16(this));
    }
    AppMethodBeat.o(47785);
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.cCD == 31) || (paramPayInfo.cCD == 32) || (paramPayInfo.cCD == 33));
  }
  
  private static void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(156741);
    com.tencent.mm.pluginsdk.l locall = (com.tencent.mm.pluginsdk.l)g.E(com.tencent.mm.pluginsdk.l.class);
    if ((locall.type() == 1) && ((locall.byS()) || (locall.byV())) && (com.tencent.mm.plugin.soter.e.b.cyk()) && (com.tencent.mm.plugin.soter.e.b.cyj()) && (com.tencent.soter.core.a.dUY() == 0))
    {
      ab.i("MicroMsg.WcPayCashierDialog", "may treble init error");
      com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 23);
      if (locall.type() == 2)
      {
        if (com.tencent.soter.core.a.dUY() != 0) {
          break label246;
        }
        com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 28);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 27);
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 33);
      }
      AppMethodBeat.o(156741);
      return;
      if (locall.type() != 2) {
        break;
      }
      if (com.tencent.soter.core.a.dUY() == 1)
      {
        if (!com.tencent.soter.core.a.dVa())
        {
          ab.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
          com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 24);
          break;
        }
        if (paramBoolean1) {
          break;
        }
        ab.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
        com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 25);
        break;
      }
      if (paramBoolean1) {
        break;
      }
      ab.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
      com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 26);
      break;
      label246:
      com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 31);
    }
  }
  
  private void c(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(47805);
    ab.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
    if (this.uvm != null) {
      this.uvm.dismiss();
    }
    hide();
    this.uuY.cfK();
    int i;
    label62:
    a locala;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label825;
      }
      localObject1 = "";
      com.tencent.mm.wallet_core.c.ad.e(i, (String)localObject1, 11, "");
      this.uvm = new a(this.mContext);
      locala = this.uvm;
      localObject2 = this.mPayInfo;
      localObject3 = this.qrf;
      localObject4 = this.tVQ;
      localObject5 = this.uvr;
      if (localObject5 != null) {
        break label837;
      }
      localObject1 = "";
      label129:
      ab.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      locala.mPayInfo = ((PayInfo)localObject2);
      locala.qrf = ((Orders)localObject3);
      locala.tVQ = ((FavorPayInfo)localObject4);
      locala.tYY = ((Bankcard)localObject5);
      locala.uuA = ((Orders)localObject3).ubU;
      locala.uuB = paramBoolean1;
      locala.uuC = paramInt;
      if (locala.uuB) {
        locala.uuD = false;
      }
      if (locala.mPayInfo.cCD != 8) {
        break label847;
      }
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.ae.nG(true);
      label247:
      localObject2 = localObject1;
      if (locala.tVQ != null)
      {
        if (locala.tVQ.uhV == 0) {
          break label859;
        }
        paramInt = 1;
        label272:
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (locala.uuB) {
            break label864;
          }
          localObject2 = localObject1;
        }
      }
      label292:
      localObject2 = ((List)localObject2).iterator();
      label301:
      if (!((Iterator)localObject2).hasNext()) {
        break label1486;
      }
      localObject3 = (Bankcard)((Iterator)localObject2).next();
      localObject4 = new WcPayCashierBankcardItemLayout(locala.getContext());
      locala.uuz.add(localObject4);
      locala.uux.addView((View)localObject4);
      if (!((Bankcard)localObject3).cTf()) {
        break label969;
      }
      com.tencent.mm.plugin.wallet_core.utils.a.k(((WcPayCashierBankcardItemLayout)localObject4).kAK);
      label376:
      if (!((Bankcard)localObject3).cTf()) {
        break label1173;
      }
      localObject1 = com.tencent.mm.plugin.wallet_core.model.t.cTN().tOD;
      if (bo.isNullOrNil(((Bankcard)localObject1).ufN)) {
        break label1098;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).uuH.setText(((Bankcard)localObject1).ufN);
      label416:
      localObject1 = "";
      switch (((Bankcard)localObject3).a(locala.uuA, locala.qrf))
      {
      default: 
        if (!bo.isNullOrNil(((Bankcard)localObject3).field_tips)) {
          localObject1 = ((Bankcard)localObject3).field_tips;
        }
        label502:
        localObject5 = new SpannableStringBuilder((CharSequence)localObject1);
        if ((!bo.isNullOrNil(((Bankcard)localObject3).field_forbid_title)) && (!bo.isNullOrNil(((Bankcard)localObject3).field_forbid_url)))
        {
          ((SpannableStringBuilder)localObject5).append("  ");
          ((SpannableStringBuilder)localObject5).append(((Bankcard)localObject3).field_forbid_title);
          ((SpannableStringBuilder)localObject5).setSpan(new ForegroundColorSpan(locala.getContext().getResources().getColor(2131690641)), ((String)localObject1).length() + 2, ((SpannableStringBuilder)localObject5).length(), 34);
          ((WcPayCashierBankcardItemLayout)localObject4).uuI.setOnClickListener(new a.5(locala, (Bankcard)localObject3));
        }
        if (!bo.aa((CharSequence)localObject5))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).uuI.setVisibility(0);
          ((WcPayCashierBankcardItemLayout)localObject4).uuI.setText((CharSequence)localObject5);
        }
        if ((locala.uuD) && (bo.aa((CharSequence)localObject5)))
        {
          localObject1 = locala.g((Bankcard)localObject3);
          if (((LinkedList)localObject1).size() > 0)
          {
            ((WcPayCashierBankcardItemLayout)localObject4).upD.setVisibility(0);
            ((WcPayCashierBankcardItemLayout)localObject4).uuI.setVisibility(8);
            ((WcPayCashierBankcardItemLayout)localObject4).upD.setWording((LinkedList)localObject1);
          }
        }
        if ((locala.tYY != null) && (((Bankcard)localObject3).field_bindSerial.equals(locala.tYY.field_bindSerial))) {
          ((WcPayCashierBankcardItemLayout)localObject4).uuJ.setChecked(true);
        }
        if (((Bankcard)localObject3).a(locala.uuA, locala.qrf) != 0)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).uuJ.setChecked(false);
          ((WcPayCashierBankcardItemLayout)localObject4).uuH.setTextColor(locala.getContext().getResources().getColor(2131690159));
          ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(false);
        }
        break;
      }
    }
    for (;;)
    {
      ((WcPayCashierBankcardItemLayout)localObject4).setOnClickListener(new a.6(locala, (Bankcard)localObject3));
      break label301;
      i = this.mPayInfo.cCD;
      break;
      label825:
      localObject1 = this.mPayInfo.cnI;
      break label62;
      label837:
      localObject1 = ((Bankcard)localObject5).field_desc;
      break label129;
      label847:
      localObject1 = (ArrayList)com.tencent.mm.plugin.wallet_core.model.ae.nG(false);
      break label247;
      label859:
      paramInt = 0;
      break label272;
      label864:
      localObject3 = locala.tVQ.uhW;
      localObject2 = new ArrayList();
      paramInt = 0;
      if (paramInt < ((ArrayList)localObject1).size())
      {
        localObject4 = (Bankcard)((ArrayList)localObject1).get(paramInt);
        if (bo.isNullOrNil((String)localObject3)) {
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
      break label292;
      label969:
      if (((Bankcard)localObject3).cTg())
      {
        locala.tSy.a((Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).kAK);
        break label376;
      }
      if (((Bankcard)localObject3).cTj())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).kAK.setImageDrawable(com.tencent.mm.svg.a.a.g(locala.getContext().getResources(), 2131231407));
        if (bo.isNullOrNil(((Bankcard)localObject3).uge)) {
          break label376;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).kAK.setUseSdcardCache(true);
        ((WcPayCashierBankcardItemLayout)localObject4).kAK.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.cVf());
        ((WcPayCashierBankcardItemLayout)localObject4).kAK.eq(((Bankcard)localObject3).uge, 2131231407);
        break label376;
      }
      locala.tSy.a(locala.getContext(), (Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).kAK);
      break label376;
      label1098:
      if (((Bankcard)localObject1).ufM >= 0.0D)
      {
        localObject5 = ((WcPayCashierBankcardItemLayout)localObject4).uuH;
        Context localContext = locala.getContext();
        locala.getContext();
        ((TextView)localObject5).setText(localContext.getString(com.tencent.mm.wallet_core.c.ae.dSD(), new Object[] { com.tencent.mm.wallet_core.ui.e.F(((Bankcard)localObject1).ufM) }));
        break label416;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).uuH.setText("");
      break label416;
      label1173:
      if (((Bankcard)localObject3).cTg())
      {
        localObject1 = com.tencent.mm.plugin.wallet_core.model.t.cTN().ulT;
        if (!bo.isNullOrNil(((Bankcard)localObject1).ufN))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).uuH.setText(((Bankcard)localObject1).ufN);
          break label416;
        }
        if (((Bankcard)localObject1).ufM >= 0.0D)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).uuH.setText(locala.getContext().getString(2131305186, new Object[] { com.tencent.mm.wallet_core.ui.e.F(((Bankcard)localObject1).ufM) }));
          break label416;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).uuH.setText("");
        break label416;
      }
      if (((Bankcard)localObject3).cTj())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).uuH.setText(com.tencent.mm.pluginsdk.ui.d.j.b(locala.getContext(), ((Bankcard)localObject3).field_desc, ((WcPayCashierBankcardItemLayout)localObject4).uuH.getTextSize()));
        break label416;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).uuH.setText(((Bankcard)localObject3).field_desc);
      break label416;
      localObject1 = ((Bankcard)localObject3).field_forbidWord;
      break label502;
      localObject1 = locala.getContext().getString(2131305452);
      break label502;
      localObject1 = locala.getContext().getString(2131305463);
      break label502;
      localObject1 = locala.getContext().getString(2131305458);
      break label502;
      localObject1 = locala.getContext().getString(2131305454);
      break label502;
      localObject1 = locala.getContext().getString(2131305450);
      break label502;
      localObject1 = locala.getContext().getString(2131305456);
      break label502;
      localObject1 = locala.getContext().getString(2131305461);
      break label502;
      ((WcPayCashierBankcardItemLayout)localObject4).uuH.setTextColor(locala.getContext().getResources().getColor(2131689763));
      ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(true);
    }
    label1486:
    Object localObject1 = new WcPayCashierBankcardItemLayout(locala.getContext());
    ((WcPayCashierBankcardItemLayout)localObject1).kAK.setVisibility(4);
    ((WcPayCashierBankcardItemLayout)localObject1).uuH.setText(2131305446);
    ((WcPayCashierBankcardItemLayout)localObject1).uuH.setTextColor(locala.getContext().getResources().getColor(2131690214));
    ((WcPayCashierBankcardItemLayout)localObject1).uuJ.setVisibility(8);
    Object localObject2 = locala.cWf();
    if ((locala.uuD) && (((LinkedList)localObject2).size() > 0))
    {
      ((WcPayCashierBankcardItemLayout)localObject1).upD.setVisibility(0);
      ((WcPayCashierBankcardItemLayout)localObject1).uuI.setVisibility(8);
      ((WcPayCashierBankcardItemLayout)localObject1).upD.setWording((LinkedList)localObject2);
    }
    ((WcPayCashierBankcardItemLayout)localObject1).setOnClickListener(new a.7(locala));
    locala.uux.addView((View)localObject1);
    localObject2 = "";
    localObject1 = localObject2;
    if (locala.qrf != null)
    {
      localObject1 = localObject2;
      if (locala.qrf.ujl != null)
      {
        localObject1 = localObject2;
        if (locala.qrf.ujl.size() > 0) {
          localObject1 = locala.getContext().getString(2131304995, new Object[] { com.tencent.mm.wallet_core.ui.e.e(locala.qrf.cnL, locala.qrf.ppp), ((Orders.Commodity)locala.qrf.ujl.get(0)).desc });
        }
      }
    }
    if ((locala.tVQ != null) && (!bo.isNullOrNil(locala.tVQ.uhY)))
    {
      locala.uuy.setVisibility(0);
      locala.uuy.setText(locala.tVQ.uhY);
      locala.tVQ.uhY = "";
    }
    for (;;)
    {
      localObject1 = this.uvm.uuF;
      this.uvC.add(localObject1);
      this.uvm.uuE = new WcPayCashierDialog.8(this, paramBoolean2);
      this.uvm.show();
      AppMethodBeat.o(47805);
      return;
      if (locala.uuC != 0)
      {
        locala.uuy.setVisibility(0);
        locala.uuy.setText((CharSequence)localObject1);
      }
      else
      {
        locala.uuy.setVisibility(8);
      }
    }
  }
  
  private void cWi()
  {
    AppMethodBeat.i(142552);
    if (!this.uvg.isShown())
    {
      this.uvg.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034259);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.uvg.startAnimation(localAnimation);
    }
    AppMethodBeat.o(142552);
  }
  
  private void cWj()
  {
    AppMethodBeat.i(142553);
    if (this.uvg.isShown())
    {
      this.uvg.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034260);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.uvg.startAnimation(localAnimation);
    }
    AppMethodBeat.o(142553);
  }
  
  private void cWk()
  {
    AppMethodBeat.i(47787);
    Object localObject1 = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(this.qrf);
    if (localObject1 != null) {
      if ((this.tVQ != null) && (this.uvr != null)) {
        if (!this.uvr.field_bankcardType.equalsIgnoreCase("CFT")) {
          break label452;
        }
      }
    }
    label195:
    label452:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { this.tVQ.uhU, Boolean.valueOf(bool) });
      String str = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject1).bJ(this.tVQ.uhU, bool);
      ab.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str });
      Object localObject3 = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject1).afB(str);
      Object localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject1).bI(str, true);
      b.a locala1 = (b.a)((Map)localObject3).get(this.uvr.field_bindSerial);
      b.a locala2 = (b.a)((Map)localObject2).get(this.uvr.field_bankcardType);
      com.tencent.mm.plugin.wallet.a.j localj = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject1).bH(str, bool);
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
        ab.i("MicroMsg.WcPayCashierDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((locala1 == null) || (locala1.umL == null) || (bo.isNullOrNil(locala1.umL.tUv))) {
          break label308;
        }
        this.tVQ.uhU = locala1.umL.tUv;
        AppMethodBeat.o(47787);
        return;
        localObject1 = localj.tUv;
        break;
        localObject2 = locala1.toString();
        break label195;
      }
      if ((locala2 != null) && (locala2.umL != null) && (!bo.isNullOrNil(locala2.umL.tUv)))
      {
        this.tVQ.uhU = locala2.umL.tUv;
        AppMethodBeat.o(47787);
        return;
      }
      if (localj != null)
      {
        this.tVQ.uhU = localj.tUv;
        AppMethodBeat.o(47787);
        return;
      }
      this.tVQ.uhU = str;
      AppMethodBeat.o(47787);
      return;
      if (this.qrf.ujm != null)
      {
        this.tVQ = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject1).afG(((com.tencent.mm.plugin.wallet_core.ui.b)localObject1).afH(this.qrf.ujm.tUf));
        AppMethodBeat.o(47787);
        return;
        ab.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
      }
      AppMethodBeat.o(47787);
      return;
    }
  }
  
  private void cWl()
  {
    AppMethodBeat.i(47788);
    if (this.uvv)
    {
      ab.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
      if (this.uvk != null)
      {
        this.uuX.removeView(this.uvk);
        this.uvk = null;
      }
      AppMethodBeat.o(47788);
      return;
    }
    if ((!bo.isNullOrNil(this.qrf.ujD)) && (!bo.isNullOrNil(this.qrf.ujE)))
    {
      this.uvk = new WcPayCashierDetailItemLayout(getContext());
      this.uuX.addView(this.uvk, 0);
      this.uvk.uuM.setVisibility(8);
      this.uvk.uuN.setVisibility(8);
      this.uvk.qkT.setText(2131305818);
      this.uvk.cWh();
      if ((this.qrf.ujD.equals("CNY")) && (!bo.isNullOrNil(this.qrf.ujC)))
      {
        localStringBuilder = new StringBuilder(this.qrf.ujE);
        localStringBuilder.append(this.qrf.ujC);
        if ((!bo.isNullOrNil(this.qrf.ujG)) && (!bo.isNullOrNil(this.qrf.ujH))) {
          localStringBuilder.append(String.format("(%s%s)", new Object[] { this.qrf.ujH, this.qrf.ujF }));
        }
        this.uvk.ldI.setText(localStringBuilder);
        AppMethodBeat.o(47788);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(this.qrf.ujE);
      localStringBuilder.append(this.qrf.ujC);
      this.uvk.ldI.setText(localStringBuilder);
    }
    AppMethodBeat.o(47788);
  }
  
  private void cWm()
  {
    AppMethodBeat.i(47789);
    com.tencent.mm.plugin.wallet_core.ui.b localb = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(this.qrf);
    if ((this.tVQ == null) || ((localb != null) && (!localb.cVm())))
    {
      this.uuX.removeView(this.uvj);
      this.uvj = null;
      AppMethodBeat.o(47789);
      return;
    }
    if (this.uvj == null)
    {
      this.uvj = new WcPayCashierDetailItemLayout(getContext());
      this.uuX.addView(this.uvj);
      this.uvj.qkT.setText(2131305816);
      this.uvj.uuM.setVisibility(8);
      this.uvj.uuN.setVisibility(0);
      this.uvj.ldI.setTextColor(getContext().getResources().getColor(2131689578));
      this.uvj.cWh();
      this.uvj.setOnClickListener(new com.tencent.mm.ui.t()
      {
        public final void bhX()
        {
          AppMethodBeat.i(142537);
          int i;
          if (WcPayCashierDialog.this.mPayInfo == null)
          {
            i = 0;
            if (WcPayCashierDialog.this.mPayInfo != null) {
              break label95;
            }
          }
          label95:
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.cnI)
          {
            com.tencent.mm.wallet_core.c.ad.e(i, str, 12, "");
            WcPayCashierDialog.this.hide();
            if (WcPayCashierDialog.p(WcPayCashierDialog.this) == null) {
              break label109;
            }
            WcPayCashierDialog.p(WcPayCashierDialog.this).dismiss();
            WcPayCashierDialog.a(WcPayCashierDialog.this, null);
            AppMethodBeat.o(142537);
            return;
            i = WcPayCashierDialog.this.mPayInfo.cCD;
            break;
          }
          label109:
          WcPayCashierDialog.a(WcPayCashierDialog.this, com.tencent.mm.plugin.wallet_core.ui.l.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.qrf, WcPayCashierDialog.this.tVQ.uhU, new WcPayCashierDialog.3.1(this), new WcPayCashierDialog.3.2(this)));
          AppMethodBeat.o(142537);
        }
      });
    }
    k(this.uvj.ldI);
    AppMethodBeat.o(47789);
  }
  
  private void cWn()
  {
    AppMethodBeat.i(47791);
    if ((this.uuX.getChildCount() == 0) && (this.uvi.getVisibility() == 8))
    {
      ab.d("MicroMsg.WcPayCashierDialog", "invisible divider");
      this.lNu.setVisibility(8);
      AppMethodBeat.o(47791);
      return;
    }
    this.lNu.setVisibility(0);
    AppMethodBeat.o(47791);
  }
  
  private void cWo()
  {
    AppMethodBeat.i(47792);
    if (!this.uvv)
    {
      if (this.uvh != null)
      {
        this.uuX.removeView(this.uvh);
        this.uvh = null;
      }
      AppMethodBeat.o(47792);
      return;
    }
    if (this.uvh == null)
    {
      this.uvh = new WcPayCashierDetailItemLayout(getContext());
      this.uuX.addView(this.uvh, 0);
      this.uvh.qkT.setText(2131305819);
      this.uvh.uuM.setVisibility(8);
      this.uvh.uuN.setVisibility(8);
      this.uvh.cWh();
      localObject = com.tencent.mm.wallet_core.ui.e.RV(7);
      this.uvh.ldI.setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject));
      this.uvh.ldI.getPaint().setFlags(16);
    }
    double d = com.tencent.mm.wallet_core.ui.e.b(this.qrf.ujC, "100", RoundingMode.HALF_UP);
    Object localObject = "";
    if (d > 0.0D) {
      localObject = String.format("%s%s", new Object[] { this.qrf.ujE, com.tencent.mm.wallet_core.ui.e.E(d) });
    }
    String str = com.tencent.mm.wallet_core.ui.e.e(this.qrf.cnL, this.qrf.ppp);
    if (!bo.isNullOrNil((String)localObject)) {}
    for (localObject = String.format("%s(%s)", new Object[] { str, localObject });; localObject = str)
    {
      this.uvh.ldI.setText((CharSequence)localObject);
      AppMethodBeat.o(47792);
      return;
    }
  }
  
  private void cWp()
  {
    AppMethodBeat.i(47793);
    if (!this.uvt)
    {
      ab.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
      this.uvi.setVisibility(8);
      AppMethodBeat.o(47793);
      return;
    }
    this.uvi.setVisibility(0);
    this.uvi.qkT.setText(2131305820);
    this.uvi.uuM.setVisibility(0);
    this.uvi.uuN.setVisibility(0);
    this.uvi.cWh();
    this.uvi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47762);
        ab.d("MicroMsg.WcPayCashierDialog", "click bankcard item");
        WcPayCashierDialog.u(WcPayCashierDialog.this);
        AppMethodBeat.o(47762);
      }
    });
    this.uvi.uuM.setImageBitmap(null);
    a(this.uvr, this.uvi.uuM);
    if (this.uvr == null) {}
    for (String str = "";; str = this.uvr.field_desc)
    {
      Object localObject = str;
      if (this.uvr != null)
      {
        localObject = str;
        if (this.uvr.cTj()) {
          localObject = com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, str);
        }
      }
      this.uvi.K((CharSequence)localObject);
      AppMethodBeat.o(47793);
      return;
    }
  }
  
  private void cWq()
  {
    AppMethodBeat.i(47795);
    cWr();
    cWu();
    AppMethodBeat.o(47795);
  }
  
  private void cWr()
  {
    AppMethodBeat.i(47796);
    Object localObject2 = "";
    Object localObject1;
    if (this.uvz)
    {
      localObject1 = this.uvx;
      this.uuV.setText((CharSequence)localObject1);
      AppMethodBeat.o(47796);
      return;
    }
    if (this.mPayInfo.wgv == null)
    {
      localObject1 = "";
      label51:
      if (bo.isNullOrNil((String)localObject1)) {
        break label214;
      }
    }
    for (;;)
    {
      if ((!bo.isNullOrNil((String)localObject1)) || (this.qrf == null) || (this.qrf.ujl == null)) {
        break label982;
      }
      Object localObject3 = (Orders.Commodity)this.qrf.ujl.get(0);
      if (localObject3 == null) {
        break label1016;
      }
      localObject1 = ((Orders.Commodity)localObject3).ppe;
      localObject2 = localObject1;
      if (a(this.mPayInfo))
      {
        localObject2 = localObject1;
        if (!bo.isNullOrNil((String)localObject1)) {
          localObject2 = (String)localObject1 + "\n";
        }
        localObject2 = (String)localObject2 + ((Orders.Commodity)localObject3).desc;
      }
      localObject1 = localObject2;
      if (!bo.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = ((Orders.Commodity)localObject3).desc;
      break;
      localObject1 = this.mPayInfo.wgv.getString("extinfo_key_19", "");
      break label51;
      label214:
      if ((this.mPayInfo.cCD == 32) || (this.mPayInfo.cCD == 33))
      {
        String str1 = this.mPayInfo.wgv.getString("extinfo_key_5", "");
        String str2 = this.mPayInfo.wgv.getString("extinfo_key_1", "");
        localObject3 = getContext().getString(2131305531);
        localObject1 = localObject2;
        if (!bo.isNullOrNil(str1))
        {
          localObject3 = str1;
          localObject1 = str1;
        }
        if (!bo.isNullOrNil(str2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(str2);
          if (localObject2 != null)
          {
            localObject1 = ((com.tencent.mm.storage.ad)localObject2).Of();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.awj((String)localObject1));
            if (bo.isNullOrNil(this.mPayInfo.qjK)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.qjK + ")")
            {
              localObject1 = bo.p((String)localObject3, new Object[] { (String)localObject1 });
              break;
            }
          }
          ab.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(str2)));
        }
        else
        {
          ab.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        }
      }
      else if (this.mPayInfo.cCD == 31)
      {
        localObject1 = this.mPayInfo.wgv.getString("extinfo_key_1", "");
        if (!bo.isNullOrNil((String)localObject1))
        {
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.storage.ad)localObject3).Oe();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bo.isNullOrNil(this.mPayInfo.qjK)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.qjK + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131305531, new Object[] { (String)localObject1 });
              break;
            }
          }
          ab.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          ab.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.cCD == 42)
      {
        localObject1 = this.mPayInfo.wgv.getString("extinfo_key_1", "");
        if (!bo.isNullOrNil((String)localObject1))
        {
          g.RM();
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.storage.ad)localObject3).Oe();
            localObject2 = getContext();
            localObject3 = new StringBuilder().append((String)localObject1);
            if (bo.isNullOrNil(this.mPayInfo.qjK)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.qjK + ")")
            {
              localObject1 = ((Context)localObject2).getString(2131305524, new Object[] { (String)localObject1 });
              break;
            }
          }
          ab.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
          localObject1 = localObject2;
        }
        else
        {
          ab.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          localObject1 = localObject2;
        }
      }
      else if (this.mPayInfo.cCD == 48)
      {
        localObject1 = getContext().getString(2131302211);
      }
      else
      {
        localObject1 = localObject2;
        if (this.mPayInfo.cCD == 49)
        {
          localObject1 = this.mPayInfo.wgv.getString("extinfo_key_1", "");
          if (!bo.isNullOrNil((String)localObject1))
          {
            localObject1 = getContext().getString(2131305531, new Object[] { localObject1 });
          }
          else
          {
            ab.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.cCD) });
            localObject1 = localObject2;
          }
        }
      }
    }
    label982:
    localObject2 = new StringBuilder("orders null?:");
    if (this.qrf == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.w("MicroMsg.WcPayCashierDialog", bool);
      label1016:
      break;
    }
  }
  
  private void cWs()
  {
    AppMethodBeat.i(47797);
    if (!bo.isNullOrNil(this.uvw))
    {
      this.usK.setText(this.uvw);
      this.usK.setVisibility(0);
      AppMethodBeat.o(47797);
      return;
    }
    this.usK.setVisibility(8);
    AppMethodBeat.o(47797);
  }
  
  private void cWt()
  {
    AppMethodBeat.i(47798);
    if ((this.uvu) && (this.qrf.ujm.tUs != null) && (this.qrf.ujm.tUs.tTO == 1))
    {
      final com.tencent.mm.plugin.wallet.a.b localb = this.qrf.ujm.tUs;
      this.uvd.setUrl(localb.tTV);
      this.uve.setText(localb.tTQ);
      if (!bo.isNullOrNil(localb.tTR)) {
        this.uve.setTextColor(Color.parseColor(localb.tTR));
      }
      this.uvf.setText(localb.tTS);
      if (!bo.isNullOrNil(localb.tTT)) {
        this.uvf.setTextColor(Color.parseColor(localb.tTT));
      }
      this.uvf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142538);
          ab.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
          WcPayCashierDialog.v(WcPayCashierDialog.this);
          WcPayCashierDialog.this.uvr = com.tencent.mm.plugin.wallet_core.model.t.cTN().i(localb.tTN.por, false, false);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(WcPayCashierDialog.this.qrf).afG(localb.tTP);
          ab.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", new Object[] { paramAnonymousView.uhU });
          if (paramAnonymousView.uhU.equals("0")) {
            WcPayCashierDialog.w(WcPayCashierDialog.this);
          }
          for (;;)
          {
            WcPayCashierDialog.r(WcPayCashierDialog.this);
            WcPayCashierDialog.s(WcPayCashierDialog.this);
            WcPayCashierDialog.x(WcPayCashierDialog.this);
            WcPayCashierDialog.y(WcPayCashierDialog.this);
            WcPayCashierDialog.z(WcPayCashierDialog.this);
            AppMethodBeat.o(142538);
            return;
            WcPayCashierDialog.this.tVQ = paramAnonymousView;
          }
        }
      });
      IJ(0);
      AppMethodBeat.o(47798);
      return;
    }
    IJ(8);
    AppMethodBeat.o(47798);
  }
  
  private void cWu()
  {
    AppMethodBeat.i(47800);
    Object localObject1;
    if (this.uvz) {
      localObject1 = this.uvy;
    }
    for (;;)
    {
      this.uuW.setText((CharSequence)localObject1);
      AppMethodBeat.o(47800);
      return;
      Object localObject2 = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(this.qrf);
      localObject1 = com.tencent.mm.wallet_core.ui.e.e(this.qrf.cnL, this.qrf.ppp);
      this.uvv = false;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject2).afD(this.tVQ.uhU);
        localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject2).cVp();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.wallet.a.j)localObject1).tUm > 0.0D))
        {
          this.uvv = true;
          localObject1 = com.tencent.mm.wallet_core.ui.e.e(((com.tencent.mm.plugin.wallet.a.j)localObject1).tUl, this.qrf.ppp);
        }
        else if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = com.tencent.mm.wallet_core.ui.e.e(((com.tencent.mm.plugin.wallet.a.j)localObject1).tUl, this.qrf.ppp);
        }
        else
        {
          localObject1 = com.tencent.mm.wallet_core.ui.e.e(this.qrf.cnL, this.qrf.ppp);
        }
      }
    }
  }
  
  private void cWv()
  {
    AppMethodBeat.i(47801);
    cWw();
    ab.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", new Object[] { Integer.valueOf(this.qrf.ujj) });
    if (this.uvo == 0)
    {
      if (this.uvp > 0) {}
      for (boolean bool = false;; bool = true)
      {
        nU(bool);
        AppMethodBeat.o(47801);
        return;
        if ((this.uvq != 1) && (this.uvq != 3)) {
          break;
        }
        this.uvb.setVisibility(8);
      }
      if (this.mPayInfo.wgw == 100102)
      {
        g.RL().Ru().set(ac.a.yzC, Boolean.TRUE);
        com.tencent.mm.pluginsdk.l locall = (com.tencent.mm.pluginsdk.l)g.E(com.tencent.mm.pluginsdk.l.class);
        locall.hH(false);
        locall.hI(false);
        g.RL().Ru().set(ac.a.yzA, Boolean.FALSE);
        this.uvb.setText(2131305078);
      }
      for (;;)
      {
        this.uvb.setTextColor(getContext().getResources().getColor(2131690665));
        this.uvb.setVisibility(0);
        bool = true;
        break;
        this.uvb.setText(2131305071);
      }
    }
    if (this.uvo == 1)
    {
      cWx();
      AppMethodBeat.o(47801);
      return;
    }
    if (this.uvo == 2) {
      cWy();
    }
    AppMethodBeat.o(47801);
  }
  
  private void cWw()
  {
    AppMethodBeat.i(138559);
    ab.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", new Object[] { Integer.valueOf(this.qrf.ujj) });
    com.tencent.mm.pluginsdk.l locall;
    boolean bool3;
    if (this.qrf.ujj == 1)
    {
      locall = (com.tencent.mm.pluginsdk.l)g.E(com.tencent.mm.pluginsdk.l.class);
      if ((locall.bza()) && (locall.bzb()) && (!locall.byT()) && (locall.byS()))
      {
        this.uvp = 1;
        bool3 = x.uli.mGD;
        if ((com.tencent.mm.plugin.wallet_core.model.t.cTN() == null) || (this.uvp <= 0)) {
          break label428;
        }
      }
    }
    label138:
    label297:
    label428:
    for (boolean bool2 = locall.bzm();; bool2 = true)
    {
      as(bool2, bool3);
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        bool2 &= bool1;
        if (bool2) {
          break label297;
        }
        x.uli.mGD = true;
        this.uvp = 0;
      }
      for (this.uvq = 3;; this.uvq = 4)
      {
        do
        {
          this.uvo = this.uvp;
          ab.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(this.mPayInfo.wgw), Integer.valueOf(this.uvo), Integer.valueOf(this.uvp) });
          AppMethodBeat.o(138559);
          return;
          if ((locall.bzn()) && (locall.bzo()) && (!locall.byU()) && (locall.byV()))
          {
            this.uvp = 2;
            break;
          }
          this.uvp = 0;
          this.uvq = 2;
          break;
          bool1 = false;
          break label138;
        } while ((this.mPayInfo.wgw != 100000) && (this.mPayInfo.wgw != 100102));
        this.uvp = 0;
      }
      this.uvo = 0;
      this.uvp = 0;
      this.uvq = 1;
      locall = (com.tencent.mm.pluginsdk.l)g.E(com.tencent.mm.pluginsdk.l.class);
      if ((locall.bza()) && (locall.bzb()) && (!locall.byT()) && (locall.byS()))
      {
        ab.w("MicroMsg.WcPayCashierDialog", "wired case");
        com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 2);
      }
      AppMethodBeat.o(138559);
      return;
    }
  }
  
  private void cWx()
  {
    AppMethodBeat.i(47803);
    this.uvo = 1;
    this.uuZ.setVisibility(8);
    this.uva.setVisibility(0);
    this.uuY.cfK();
    cWj();
    this.uuT.setVisibility(8);
    this.uuU.setText(2131305535);
    AppMethodBeat.o(47803);
  }
  
  private void cWy()
  {
    AppMethodBeat.i(47804);
    this.uvo = 2;
    this.uuZ.setVisibility(8);
    this.uva.setVisibility(0);
    this.uuY.cfK();
    cWj();
    this.uuT.setVisibility(8);
    this.uuU.setText(2131305535);
    AppMethodBeat.o(47804);
  }
  
  private void ea(List<cje> paramList)
  {
    AppMethodBeat.i(142556);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        final cje localcje = (cje)paramList.next();
        WcPayCashierDetailItemLayout localWcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
        localWcPayCashierDetailItemLayout.uuM.setVisibility(8);
        if ((localcje.xTq != null) && (localcje.xTq.size() > 0)) {
          com.tencent.mm.plugin.wallet_core.utils.e.a(localWcPayCashierDetailItemLayout.qkT, (cjw)localcje.xTq.get(0), null);
        }
        if ((localcje.xTr != null) && (localcje.xTr.size() > 0))
        {
          com.tencent.mm.plugin.wallet_core.utils.e.a(localWcPayCashierDetailItemLayout.ldI, (cjw)localcje.xTr.get(0), null);
          label149:
          if (localcje.xTs == null) {
            break label267;
          }
          int i = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 8);
          int j = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 16);
          com.tencent.mm.plugin.wallet_core.utils.e.a(localWcPayCashierDetailItemLayout.uuN, localcje.xTs, 2131230928, i, j, true);
          localWcPayCashierDetailItemLayout.uuN.setVisibility(0);
        }
        for (;;)
        {
          localWcPayCashierDetailItemLayout.cWh();
          if (localcje.wna != null) {
            localWcPayCashierDetailItemLayout.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(47760);
                ab.i("MicroMsg.WcPayCashierDialog", "click item: %s", new Object[] { localcje.wna.url });
                if ((localcje.wna.type == 13) && (localcje.wna.xJB != null) && ("fetchfavordialog".equals(localcje.wna.url)))
                {
                  paramAnonymousView = new b(WcPayCashierDialog.o(WcPayCashierDialog.this));
                  if ((localcje.wna.xJB.wOL.size() > 0) && (((cqy)localcje.wna.xJB.wOL.get(0)).xZy != null))
                  {
                    Object localObject1 = ((cqy)localcje.wna.xJB.wOL.get(0)).xZy.xmm;
                    Object localObject2 = localcje.wna.xJB.wOJ.wmY;
                    if (localObject2 != null) {
                      com.tencent.mm.plugin.wallet_core.utils.e.a(paramAnonymousView.iJG, (cjw)localObject2, null);
                    }
                    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                    {
                      localObject1 = ((List)localObject1).iterator();
                      while (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (cje)((Iterator)localObject1).next();
                        View localView = View.inflate(paramAnonymousView.getContext(), 2130971279, null);
                        TextView localTextView1 = (TextView)localView.findViewById(2131829465);
                        TextView localTextView2 = (TextView)localView.findViewById(2131829467);
                        if ((((cje)localObject2).xTq != null) && (((cje)localObject2).xTq.size() > 0))
                        {
                          com.tencent.mm.plugin.wallet_core.utils.e.a(localTextView1, (cjw)((cje)localObject2).xTq.get(0), null);
                          if (((cje)localObject2).xTq.size() >= 2) {
                            com.tencent.mm.plugin.wallet_core.utils.e.a(localTextView2, (cjw)((cje)localObject2).xTq.get(1), null);
                          }
                        }
                        paramAnonymousView.uvK.addView(localView);
                      }
                    }
                  }
                  paramAnonymousView.setOnDismissListener(new WcPayCashierDialog.2.1(this));
                  paramAnonymousView.show();
                  WcPayCashierDialog.this.hide();
                }
                AppMethodBeat.o(47760);
              }
            });
          }
          this.uuX.addView(localWcPayCashierDetailItemLayout);
          break;
          localWcPayCashierDetailItemLayout.ldI.setVisibility(8);
          localWcPayCashierDetailItemLayout.qkT.setMaxWidth(2147483647);
          break label149;
          label267:
          localWcPayCashierDetailItemLayout.uuN.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(142556);
  }
  
  private void init()
  {
    AppMethodBeat.i(142550);
    initView();
    setCancelable(true);
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new WcPayCashierDialog.1(this));
    setOnDismissListener(new WcPayCashierDialog.9(this));
    ((MMActivity)this.mContext).getLifecycle().addObserver(this);
    this.tSy = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(142550);
  }
  
  private void initView()
  {
    AppMethodBeat.i(142551);
    this.iux = ((ViewGroup)View.inflate(getContext(), 2130971278, null));
    this.uuw = ((ImageView)this.iux.findViewById(2131829449));
    this.uuT = ((TextView)this.iux.findViewById(2131829448));
    this.uuU = ((TextView)this.iux.findViewById(2131829450));
    this.uuV = ((TextView)this.iux.findViewById(2131829451));
    this.usK = ((TextView)this.iux.findViewById(2131829453));
    this.uuW = ((WalletTextView)this.iux.findViewById(2131829452));
    this.uuX = ((ViewGroup)this.iux.findViewById(2131829455));
    this.uuY = ((EditHintPasswdView)this.iux.findViewById(2131829462));
    this.uuZ = ((ViewGroup)this.iux.findViewById(2131829461));
    this.uvi = ((WcPayCashierDetailItemLayout)this.iux.findViewById(2131829456));
    this.uva = ((Button)this.iux.findViewById(2131829464));
    this.uvb = ((TextView)this.iux.findViewById(2131829463));
    this.uvc = ((ViewGroup)this.iux.findViewById(2131829457));
    this.uvd = ((CdnImageView)this.iux.findViewById(2131829458));
    this.uve = ((TextView)this.iux.findViewById(2131829459));
    this.uvf = ((Button)this.iux.findViewById(2131829460));
    this.mKeyboard = ((MyKeyboardWindow)this.iux.findViewById(2131822419));
    this.uvg = ((ViewGroup)this.iux.findViewById(2131822418));
    this.lNu = this.iux.findViewById(2131829454);
    Object localObject = this.uuw;
    int i = uuP;
    int j = uuP;
    bo.n((View)localObject, i, i, j, j);
    localObject = aj.g(getContext(), 2131230739, getContext().getResources().getColor(2131689764));
    this.uuw.setImageDrawable((Drawable)localObject);
    this.uuw.setOnClickListener(new WcPayCashierDialog.10(this));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.uuY);
    this.uuY.setOnInputValidListener(new WcPayCashierDialog.11(this));
    localObject = (EditText)this.iux.findViewById(2131820689);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject);
    this.mKeyboard.setInputEditText((EditText)localObject);
    if (Build.VERSION.SDK_INT >= 14)
    {
      com.tencent.mm.ui.a.c localc = new com.tencent.mm.ui.a.c();
      this.mKeyboard.setSecureAccessibility(localc);
      ((EditText)localObject).setAccessibilityDelegate(localc);
    }
    ((EditText)localObject).setOnClickListener(new WcPayCashierDialog.12(this));
    this.iux.findViewById(2131822420).setOnClickListener(new WcPayCashierDialog.13(this));
    this.uva.setOnClickListener(new WcPayCashierDialog.14(this));
    this.uuU.setOnClickListener(new WcPayCashierDialog.15(this));
    AppMethodBeat.o(142551);
  }
  
  private void k(TextView paramTextView)
  {
    AppMethodBeat.i(47790);
    com.tencent.mm.plugin.wallet_core.ui.b localb = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(this.qrf);
    com.tencent.mm.plugin.wallet.a.j localj = localb.afD(this.tVQ.uhU);
    List localList = localb.cVp();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = "";
    int i;
    if ((localj != null) && (localj.tUm > 0.0D))
    {
      localStringBuilder.append(localj.tUo);
      i = 1;
    }
    for (;;)
    {
      if ((localj != null) && (localj.tUn != 0) && (!bo.aa(localStringBuilder)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(localj.tUp);
      }
      if ((!bo.aa(localStringBuilder)) && (!bo.isNullOrNil((String)localObject)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
        label152:
        localObject = localStringBuilder.toString();
        ab.i("MicroMsg.WcPayCashierDialog", "favor text: %s", new Object[] { localObject });
        if (i == 0) {
          break label335;
        }
        paramTextView.setTextColor(getContext().getResources().getColor(2131689578));
      }
      for (;;)
      {
        paramTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(47790);
        return;
        if (localList.size() <= 0) {
          break label355;
        }
        localObject = localb.cVo();
        if ((localj == null) && (localb.cVn() == 1) && (localObject != null) && (((com.tencent.mm.plugin.wallet.a.j)localObject).tUn == 0) && (this.uvu) && (this.qrf.ujm.tUs != null) && (this.qrf.ujm.tUs.tTO == 1))
        {
          localObject = getContext().getString(2131305534);
          i = 0;
          break;
        }
        localObject = getContext().getString(2131305527);
        i = 1;
        break;
        if (bo.isNullOrNil((String)localObject)) {
          break label152;
        }
        localStringBuilder.append((String)localObject);
        break label152;
        label335:
        paramTextView.setTextColor(getContext().getResources().getColor(2131690159));
      }
      label355:
      i = 1;
    }
  }
  
  private void nU(boolean paramBoolean)
  {
    AppMethodBeat.i(47802);
    ab.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uvo = 0;
    this.uuZ.setVisibility(0);
    this.uva.setVisibility(8);
    this.uuY.cfK();
    cWi();
    this.uuT.setVisibility(0);
    if (paramBoolean)
    {
      this.uuU.setVisibility(8);
      AppMethodBeat.o(47802);
      return;
    }
    this.uuU.setVisibility(0);
    AppMethodBeat.o(47802);
  }
  
  public final void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47784);
    a(paramPayInfo, paramOrders, paramFavorPayInfo, "", paramBankcard, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(47784);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, List<cje> paramList)
  {
    AppMethodBeat.i(142555);
    this.uvx = paramString1;
    this.uvy = paramString2;
    this.uvw = paramString3;
    this.uvz = true;
    this.uvt = false;
    cWv();
    cWq();
    cWs();
    ea(paramList);
    cWp();
    cWn();
    AppMethodBeat.o(142555);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(142554);
    ab.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
    this.uuY.cfK();
    AppMethodBeat.o(142554);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47782);
    super.onCreate(paramBundle);
    setContentView(this.iux);
    paramBundle = getWindow();
    paramBundle.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle.addFlags(67108864);
    d.fv(21);
    AppMethodBeat.o(47782);
  }
  
  public void show()
  {
    AppMethodBeat.i(138093);
    super.show();
    AppMethodBeat.o(138093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog
 * JD-Core Version:    0.7.0.1
 */