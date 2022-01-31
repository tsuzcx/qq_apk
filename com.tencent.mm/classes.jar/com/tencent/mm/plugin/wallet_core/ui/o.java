package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.ll.b;
import com.tencent.mm.h.a.nk;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class o
  extends i
  implements c
{
  private static HashMap<String, Boolean> qGi = new HashMap();
  public DialogInterface.OnCancelListener Oi;
  public ImageView ffK;
  protected boolean fsA;
  public View ipf;
  private boolean isPaused = false;
  private Animation klV;
  private int klW = 0;
  protected View lMr;
  private Context mContext;
  protected MyKeyboardWindow mKeyboard;
  public TextView nCX;
  public TextView nJn;
  protected PayInfo nqa;
  public View qFA;
  public View qFB;
  public TextView qFC;
  public ImageView qFD;
  public TextView qFE;
  public TextView qFF;
  public View qFG;
  public TextView qFH;
  public DialogInterface.OnClickListener qFJ;
  public boolean qFK = false;
  protected boolean qFL = true;
  public Bankcard qFM = null;
  public TextView qFN;
  public View qFO;
  public TextView qFP;
  public ImageView qFQ;
  protected int qFR = 0;
  protected boolean qFS = false;
  private int qFT = 0;
  private Animation qFU = null;
  private String qFV = "";
  private long qFW = -1L;
  boolean qFZ = false;
  public Button qFr;
  public ImageView qFs;
  public TextView qFt;
  public TextView qFu;
  public FavourLayout qFv;
  public CdnImageView qFw;
  public TextView qFx;
  public EditHintPasswdView qFy;
  public c qGe;
  public Button qGf;
  public o.a qGg;
  protected int qGh = -1;
  protected com.tencent.mm.plugin.wallet_core.e.a qjy = new com.tencent.mm.plugin.wallet_core.e.a();
  public FavorPayInfo qmA = new FavorPayInfo();
  protected a qnm = null;
  public TextView qnx;
  
  public o(Context paramContext)
  {
    super(paramContext, a.j.mmpwddialog);
    ca(paramContext);
  }
  
  private void QO(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.qFE.setVisibility(0);
      this.qFE.setText(paramString);
      return;
    }
    y.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.qFE.setVisibility(8);
  }
  
  public static o a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramContext, true, paramOrders, paramFavorPayInfo, paramBankcard, paramPayInfo, null, paramc, paramOnClickListener, paramOnCancelListener);
  }
  
  public static o a(Context paramContext, String paramString1, double paramDouble, String paramString2, Bankcard paramBankcard, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    boolean bool = true;
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    o localo = new o(paramContext);
    localo.bWW();
    localo.a(paramOnCancelListener);
    localo.setOnCancelListener(paramOnCancelListener);
    localo.setCancelable(true);
    localo.QN(paramString1);
    localo.d(com.tencent.mm.wallet_core.ui.e.d(paramDouble, paramString2), paramDouble);
    localo.qFL = true;
    if (paramBankcard == null)
    {
      paramString1 = "";
      localo.g(paramBankcard);
      if (TextUtils.isEmpty(paramString1)) {
        break label154;
      }
    }
    for (;;)
    {
      localo.kJ(bool);
      if (paramBankcard != null) {
        localo.a(paramString1, paramOnClickListener, false);
      }
      localo.qGe = paramc;
      localo.show();
      com.tencent.mm.ui.base.h.a(paramContext, localo);
      return localo;
      paramString1 = paramBankcard.field_desc;
      break;
      label154:
      bool = false;
    }
  }
  
  public static o a(Context paramContext, String paramString1, String paramString2, c paramc, DialogInterface.OnCancelListener paramOnCancelListener, o.a parama)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    return a(paramContext, paramString1, paramString2, "", paramc, paramOnCancelListener, parama);
  }
  
  public static o a(Context paramContext, String paramString1, String paramString2, String paramString3, c paramc, DialogInterface.OnCancelListener paramOnCancelListener, o.a parama)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    o localo = new o(paramContext);
    localo.bWW();
    localo.a(paramOnCancelListener);
    localo.setOnCancelListener(paramOnCancelListener);
    localo.setCancelable(true);
    localo.QN(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localo.nCX.setVisibility(0);
      localo.nCX.setText(paramString2);
    }
    for (;;)
    {
      localo.qFL = true;
      localo.kI(localo.qFL);
      localo.kJ(false);
      localo.qFL = false;
      localo.qGg = parama;
      localo.QO(paramString3);
      localo.qGe = paramc;
      localo.show();
      com.tencent.mm.ui.base.h.a(paramContext, localo);
      return localo;
      localo.nCX.setVisibility(8);
    }
  }
  
  public static o a(Context paramContext, boolean paramBoolean, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, String paramString, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    if ((paramOrders == null) || (paramOrders.qwN == null) || (paramOrders.qwN.size() <= 0)) {
      return null;
    }
    a locala = b.qAd.a(paramOrders);
    Object localObject1;
    Object localObject2;
    label70:
    Object localObject3;
    if (paramFavorPayInfo == null)
    {
      localObject1 = "";
      if (paramBankcard != null) {
        break label550;
      }
      localObject2 = "";
      if (paramBankcard != null) {
        break label560;
      }
      localObject3 = "";
      label79:
      y.i("MicroMsg.WalletPwdDialog", "showAlert with favInfo %s bindSerial %s  bankcardType %s", new Object[] { localObject1, localObject2, localObject3 });
      if (locala == null) {
        break label2235;
      }
      if ((paramFavorPayInfo == null) || (paramBankcard == null)) {
        break label2207;
      }
      if (!paramBankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
        break label3923;
      }
    }
    label337:
    label3923:
    for (boolean bool1 = true;; bool1 = false)
    {
      y.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.qvC, Boolean.valueOf(bool1) });
      Object localObject4 = locala.bk(paramFavorPayInfo.qvC, bool1);
      y.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { localObject4 });
      localObject3 = new HashMap();
      Object localObject5;
      if ((locala.qzX.qkY != null) && (locala.qzX.qkY.qli != null))
      {
        localObject5 = locala.qzX.qkY.qli;
        if (!locala.qzZ.containsKey(localObject4)) {
          break label3917;
        }
      }
      for (double d = ((com.tencent.mm.plugin.wallet.a.h)locala.qzZ.get(localObject4)).qll;; d = 0.0D)
      {
        int i = 0;
        Object localObject8;
        for (;;)
        {
          if (i < ((List)localObject5).size())
          {
            localObject6 = (com.tencent.mm.plugin.wallet.a.h)((List)localObject5).get(i);
            localObject2 = null;
            if ((((String)localObject4).equals("0")) && (!localObject6.equals("0")))
            {
              localObject1 = ((com.tencent.mm.plugin.wallet.a.h)localObject6).qlk;
              localObject1 = a.QG((String)localObject1);
              if ((localObject1 == null) || (localObject1.length <= 0)) {
                break label646;
              }
              localObject1 = (com.tencent.mm.plugin.wallet.a.q)locala.qzY.get(localObject1[0]);
              if (localObject1 == null) {
                break label646;
              }
              if (((com.tencent.mm.plugin.wallet.a.q)localObject1).qlR == 0) {
                break label640;
              }
            }
            for (int j = 1;; j = 0)
            {
              if ((j == 0) || (((com.tencent.mm.plugin.wallet.a.q)localObject1).qlU.size() <= 0)) {
                break label646;
              }
              localObject2 = ((com.tencent.mm.plugin.wallet.a.q)localObject1).qlU.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject7 = com.tencent.mm.platformtools.aa.a((com.tencent.mm.bv.b)((Iterator)localObject2).next());
                localObject8 = (a.a)((Map)localObject3).get(localObject7);
                if ((localObject8 == null) || (((com.tencent.mm.plugin.wallet.a.h)localObject6).qll > ((a.a)localObject8).qAa.qll))
                {
                  localObject8 = new a.a();
                  ((a.a)localObject8).qAa = ((com.tencent.mm.plugin.wallet.a.h)localObject6);
                  ((a.a)localObject8).mOX = ((com.tencent.mm.plugin.wallet.a.q)localObject1).mOX;
                  ((a.a)localObject8).qAb = (((com.tencent.mm.plugin.wallet.a.h)localObject6).qll - d);
                  ((a.a)localObject8).qAc = ((com.tencent.mm.plugin.wallet.a.q)localObject1).qlS;
                  ((Map)localObject3).put(localObject7, localObject8);
                }
              }
              localObject1 = paramFavorPayInfo.toString();
              break;
              localObject2 = paramBankcard.field_bindSerial;
              break label70;
              localObject3 = paramBankcard.field_bankcardType;
              break label79;
              localObject1 = localObject2;
              if (!((com.tencent.mm.plugin.wallet.a.h)localObject6).qlk.startsWith((String)localObject4)) {
                break label337;
              }
              localObject1 = localObject2;
              if (((String)localObject4).equals(((com.tencent.mm.plugin.wallet.a.h)localObject6).qlk)) {
                break label337;
              }
              localObject1 = ((com.tencent.mm.plugin.wallet.a.h)localObject6).qlk.replace((String)localObject4 + "-", "");
              break label337;
            }
            i += 1;
            continue;
            y.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
          }
        }
        localObject1 = locala.bj((String)localObject4, true);
        localObject5 = (a.a)((Map)localObject3).get(paramBankcard.field_bindSerial);
        Object localObject6 = (a.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
        Object localObject7 = locala.bi((String)localObject4, bool1);
        label737:
        label746:
        Object localObject9;
        boolean bool2;
        if (localObject7 == null)
        {
          localObject1 = "";
          if (localObject5 != null) {
            break label2119;
          }
          localObject2 = "";
          if (localObject6 != null) {
            break label2129;
          }
          localObject3 = "";
          y.i("MicroMsg.WalletPwdDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
          if ((localObject5 == null) || (((a.a)localObject5).qAa == null) || (bk.bl(((a.a)localObject5).qAa.qlk))) {
            break label2139;
          }
          paramFavorPayInfo.qvC = ((a.a)localObject5).qAa.qlk;
          localObject1 = locala.bWr();
          localObject5 = paramFavorPayInfo;
          localObject2 = "";
          if (paramPayInfo.snX != null) {
            break label2252;
          }
          paramFavorPayInfo = "";
          if (bk.bl(paramFavorPayInfo)) {
            break label2269;
          }
          if ((!bk.bl(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.qwN == null)) {
            break label3004;
          }
          localObject3 = (Orders.Commodity)paramOrders.qwN.get(0);
          if (localObject3 == null) {
            break label3038;
          }
          paramString = ((Orders.Commodity)localObject3).mOO;
          if ((paramPayInfo == null) || ((paramPayInfo.bUV != 31) && (paramPayInfo.bUV != 32) && (paramPayInfo.bUV != 33))) {
            break label2998;
          }
          i = 1;
          paramFavorPayInfo = paramString;
          if (i != 0)
          {
            paramFavorPayInfo = paramString;
            if (!bk.bl(paramString)) {
              paramFavorPayInfo = paramString + "\n";
            }
            paramFavorPayInfo = paramFavorPayInfo + ((Orders.Commodity)localObject3).desc;
          }
          localObject2 = paramFavorPayInfo;
          if (bk.bl(paramFavorPayInfo)) {
            localObject2 = ((Orders.Commodity)localObject3).desc;
          }
          localObject7 = null;
          localObject8 = null;
          localObject4 = null;
          localObject9 = null;
          localObject3 = null;
          localObject6 = null;
          d = paramOrders.nCq;
          bool2 = false;
          bool1 = false;
          if ((locala == null) || (localObject5 == null)) {
            break label3893;
          }
          localObject7 = locala.QF(((FavorPayInfo)localObject5).qvC);
          if ((localObject7 == null) || (((com.tencent.mm.plugin.wallet.a.h)localObject7).qld <= 0.0D)) {
            break label3050;
          }
          bool1 = true;
          localObject4 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.nCq, paramOrders.mOZ);
          localObject1 = com.tencent.mm.wallet_core.ui.e.d(((com.tencent.mm.plugin.wallet.a.h)localObject7).qlc, paramOrders.mOZ);
          d = ((com.tencent.mm.plugin.wallet.a.h)localObject7).qkV;
          localObject3 = ((com.tencent.mm.plugin.wallet.a.h)localObject7).qlf;
          if (qGi.containsKey(paramPayInfo.bMX)) {
            break label3888;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(14530, new Object[] { Integer.valueOf(3) });
          paramFavorPayInfo = null;
          paramString = (String)localObject6;
          if (localObject7 != null)
          {
            paramString = (String)localObject6;
            if (((com.tencent.mm.plugin.wallet.a.h)localObject7).qle != 0)
            {
              localObject6 = ((com.tencent.mm.plugin.wallet.a.h)localObject7).qlg;
              paramString = (String)localObject6;
              if (!bk.bl((String)localObject3)) {
                paramString = "," + (String)localObject6;
              }
            }
          }
          if ((bk.bl((String)localObject3)) && (bk.bl(paramString))) {
            break label3881;
          }
          if (!bk.bl(paramFavorPayInfo)) {
            break label3111;
          }
          paramFavorPayInfo = null;
          label1240:
          localObject6 = localObject1;
        }
        for (;;)
        {
          if (paramOrders.nyC > 0.0D) {}
          for (localObject7 = paramContext.getResources().getString(a.i.wallet_charge_fee_msg, new Object[] { com.tencent.mm.wallet_core.ui.e.d(paramOrders.nyC, paramOrders.mOZ) });; localObject7 = null)
          {
            if (paramBankcard == null)
            {
              localObject1 = "";
              localObject8 = localObject1;
              if (paramBankcard.bUU()) {
                localObject8 = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, (CharSequence)localObject1);
              }
              localObject1 = new o(paramContext);
              ((o)localObject1).a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
              ((o)localObject1).kJ(paramBoolean);
              ((o)localObject1).qFL = paramBoolean;
              ((o)localObject1).bWW();
              ((o)localObject1).a(new b(paramOnCancelListener, (byte)0));
              ((o)localObject1).setOnCancelListener(new b(paramOnCancelListener, (byte)0));
              ((o)localObject1).setCancelable(true);
              ((o)localObject1).QN((String)localObject2);
              ((o)localObject1).d((String)localObject6, d);
              ((o)localObject1).QP((String)localObject4);
              ((o)localObject1).a((CharSequence)localObject8, new o.3(paramPayInfo, paramOnClickListener, (o)localObject1), bool1);
              ((o)localObject1).g(paramBankcard);
              if (paramOrders.qwL != 1) {
                break label3142;
              }
              paramBoolean = true;
              ((o)localObject1).nqa = paramPayInfo;
              ((o)localObject1).qFS = paramBoolean;
              if (!com.tencent.mm.model.q.Gw())
              {
                y.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
                paramOnClickListener = (com.tencent.mm.pluginsdk.k)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.k.class);
                if ((!paramOnClickListener.aSF()) || (paramOnClickListener.aSx()) || (!paramOnClickListener.aSw())) {
                  break label3147;
                }
                ((o)localObject1).qGh = 0;
                label1522:
                y.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(((o)localObject1).qGh) });
                ((o)localObject1).qFT = 0;
                ((o)localObject1).qFN.setVisibility(8);
                ((o)localObject1).qFO.setVisibility(8);
                ((o)localObject1).qFW = bk.UZ();
                bool1 = true;
                paramBoolean = bool1;
                if (com.tencent.mm.plugin.wallet_core.model.o.bVs() != null)
                {
                  paramBoolean = bool1;
                  if (((o)localObject1).qGh >= 0) {
                    paramBoolean = paramOnClickListener.aSR();
                  }
                }
                y.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
                if (((((o)localObject1).nqa == null) || ((((o)localObject1).nqa.snY != 100000) && (((o)localObject1).nqa.snY != 100102))) && (paramBoolean)) {
                  break label3217;
                }
                y.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(((o)localObject1).nqa.snY) });
                if (!((o)localObject1).lMr.isShown()) {
                  ((o)localObject1).lMr.setVisibility(0);
                }
                if (((o)localObject1).nqa != null)
                {
                  ((o)localObject1).nqa.qFX = 0;
                  ((o)localObject1).nqa.bOU = "";
                  ((o)localObject1).nqa.bOV = "";
                }
                ((o)localObject1).qFO.setVisibility(0);
                ((o)localObject1).qFP.setVisibility(0);
                paramOnCancelListener = ((o)localObject1).qFP;
                if ((((o)localObject1).nqa == null) || (((o)localObject1).nqa.snY != 100102)) {
                  break label3186;
                }
                i = a.i.wallet_fingerprint_severe_error_hint;
                paramOnCancelListener.setText(i);
                ((o)localObject1).qFP.setTextColor(((o)localObject1).getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
                if (paramBoolean) {
                  break label3194;
                }
                ((o)localObject1).qFB.setVisibility(0);
                ((o)localObject1).qFC.setVisibility(0);
                if ((((o)localObject1).nqa != null) && (((o)localObject1).nqa.snY == 100102))
                {
                  com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upG, Boolean.valueOf(true));
                  paramOnClickListener.gf(false);
                  paramOnClickListener.gg(false);
                  com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upE, Boolean.valueOf(false));
                }
                com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              }
              ((o)localObject1).fl((String)localObject3, paramFavorPayInfo);
              paramFavorPayInfo = paramOrders.mOZ;
              ((o)localObject1).QQ(paramString);
              ((o)localObject1).QO((String)localObject7);
              ((o)localObject1).qGe = paramc;
              paramFavorPayInfo = a(paramBankcard, paramOrders);
              if (((o)localObject1).qFv != null)
              {
                if (paramFavorPayInfo.size() <= 0) {
                  break label3853;
                }
                ((o)localObject1).qFv.setWording(paramFavorPayInfo);
                ((o)localObject1).qFv.setVisibility(0);
              }
              if (!a(paramBankcard, paramOrders, paramPayInfo.bMX)) {
                break label3866;
              }
              ((o)localObject1).kH(true);
              com.tencent.mm.plugin.report.service.h.nFQ.f(14530, new Object[] { Integer.valueOf(1) });
            }
            for (;;)
            {
              ((o)localObject1).show();
              com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject1);
              return localObject1;
              localObject1 = ((com.tencent.mm.plugin.wallet.a.h)localObject7).qlk;
              break;
              localObject2 = ((a.a)localObject5).toString();
              break label737;
              localObject3 = ((a.a)localObject6).toString();
              break label746;
              label2139:
              if ((localObject6 != null) && (((a.a)localObject6).qAa != null) && (!bk.bl(((a.a)localObject6).qAa.qlk)))
              {
                paramFavorPayInfo.qvC = ((a.a)localObject6).qAa.qlk;
                break label812;
              }
              if (localObject7 != null)
              {
                paramFavorPayInfo.qvC = ((com.tencent.mm.plugin.wallet.a.h)localObject7).qlk;
                break label812;
              }
              paramFavorPayInfo.qvC = ((String)localObject4);
              break label812;
              if (paramOrders.qwO == null) {
                break label812;
              }
              paramFavorPayInfo = locala.QI(locala.QJ(paramOrders.qwO.qkW));
              break label812;
              y.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
              localObject1 = null;
              localObject5 = paramFavorPayInfo;
              break label822;
              paramFavorPayInfo = paramPayInfo.snX.getString("extinfo_key_19", "");
              break label837;
              label2269:
              if ((paramPayInfo.bUV == 32) || (paramPayInfo.bUV == 33))
              {
                localObject4 = paramPayInfo.snX.getString("extinfo_key_5", "");
                localObject6 = paramPayInfo.snX.getString("extinfo_key_1", "");
                localObject3 = paramContext.getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                if (!bk.bl((String)localObject4))
                {
                  localObject3 = localObject4;
                  paramFavorPayInfo = (FavorPayInfo)localObject4;
                }
                if (!bk.bl((String)localObject6))
                {
                  com.tencent.mm.kernel.g.DQ();
                  localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj((String)localObject6);
                  if (localObject2 != null)
                  {
                    paramFavorPayInfo = ((ad)localObject2).Bq();
                    localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.afq(paramFavorPayInfo));
                    if (bk.bl(paramString)) {}
                    for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                    {
                      paramFavorPayInfo = bk.q((String)localObject3, new Object[] { paramFavorPayInfo });
                      break;
                    }
                  }
                  y.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + (String)localObject6);
                  break label844;
                }
                y.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                break label844;
              }
              if (paramPayInfo.bUV == 31)
              {
                paramFavorPayInfo = paramPayInfo.snX.getString("extinfo_key_1", "");
                if (!bk.bl(paramFavorPayInfo))
                {
                  com.tencent.mm.kernel.g.DQ();
                  localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(paramFavorPayInfo);
                  if (localObject3 != null)
                  {
                    paramFavorPayInfo = ((ad)localObject3).Bp();
                    i = a.i.wallet_pwd_dialog_remittance_desc_txt;
                    localObject2 = new StringBuilder().append(paramFavorPayInfo);
                    if (bk.bl(paramString)) {}
                    for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                    {
                      paramFavorPayInfo = paramContext.getString(i, new Object[] { paramFavorPayInfo });
                      break;
                    }
                  }
                  y.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + paramFavorPayInfo);
                  paramFavorPayInfo = (FavorPayInfo)localObject2;
                  break label844;
                }
                y.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label844;
              }
              if (paramPayInfo.bUV == 42)
              {
                paramFavorPayInfo = paramPayInfo.snX.getString("extinfo_key_1", "");
                if (!bk.bl(paramFavorPayInfo))
                {
                  com.tencent.mm.kernel.g.DQ();
                  localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(paramFavorPayInfo);
                  if (localObject3 != null)
                  {
                    paramFavorPayInfo = ((ad)localObject3).Bp();
                    i = a.i.wallet_pwd_dialog_aa_desc_txt;
                    localObject2 = new StringBuilder().append(paramFavorPayInfo);
                    if (bk.bl(paramString)) {}
                    for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                    {
                      paramFavorPayInfo = paramContext.getString(i, new Object[] { paramFavorPayInfo });
                      break;
                    }
                  }
                  y.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + paramFavorPayInfo);
                  paramFavorPayInfo = (FavorPayInfo)localObject2;
                  break label844;
                }
                y.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label844;
              }
              if (paramPayInfo.bUV == 48)
              {
                paramFavorPayInfo = paramContext.getString(a.i.qr_reward_grant_btn);
                break label844;
              }
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (paramPayInfo.bUV != 49) {
                break label844;
              }
              paramFavorPayInfo = paramPayInfo.snX.getString("extinfo_key_1", "");
              if (!bk.bl(paramFavorPayInfo))
              {
                paramFavorPayInfo = paramContext.getString(a.i.wallet_pwd_dialog_remittance_desc_txt, new Object[] { paramFavorPayInfo });
                break label844;
              }
              y.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.bUV) });
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label844;
              i = 0;
              break label927;
              paramString = new StringBuilder("orders null?:");
              if (paramOrders == null) {}
              for (bool1 = true;; bool1 = false)
              {
                y.w("MicroMsg.WalletPwdDialog", bool1);
                label3038:
                localObject2 = paramFavorPayInfo;
                break;
              }
              label3050:
              if ((localObject1 != null) && (((List)localObject1).size() > 0))
              {
                localObject1 = com.tencent.mm.wallet_core.ui.e.d(((com.tencent.mm.plugin.wallet.a.h)localObject7).qlc, paramOrders.mOZ);
                bool1 = true;
                paramFavorPayInfo = paramContext.getString(a.i.wallet_pwd_dialog_more_favors);
                break label1155;
              }
              localObject1 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.nCq, paramOrders.mOZ);
              paramFavorPayInfo = null;
              break label1155;
              paramFavorPayInfo = "," + paramFavorPayInfo;
              break label1240;
              localObject1 = paramBankcard.field_desc;
              break label1292;
              paramBoolean = false;
              break label1448;
              if ((!paramOnClickListener.aSS()) || (paramOnClickListener.aSy()) || (!paramOnClickListener.aSz())) {
                break label1522;
              }
              ((o)localObject1).qGh = 1;
              break label1522;
              label3186:
              i = a.i.wallet_finger_print_not_recorded;
              break label1804;
              label3194:
              ((o)localObject1).qFB.setVisibility(8);
              ((o)localObject1).qFC.setVisibility(8);
              break label1855;
              if ((((o)localObject1).nqa != null) && (((o)localObject1).nqa.snY == 100001)) {
                ((o)localObject1).nqa.qFX = 1;
              }
              if ((((o)localObject1).qGh >= 0) && (((o)localObject1).qFS) && (!bWS()))
              {
                ((o)localObject1).qFN.setVisibility(0);
                ((o)localObject1).qFN.setText(((o)localObject1).getContext().getString(a.i.wallet_pwd_pay_mode));
                ((o)localObject1).qFy.setVisibility(8);
                ((o)localObject1).lMr.setVisibility(8);
                if (((o)localObject1).nqa != null) {
                  ((o)localObject1).nqa.qFX = 1;
                }
                if (((o)localObject1).qGh == 0)
                {
                  ((o)localObject1).qFR = 1;
                  ((o)localObject1).qFO.setVisibility(0);
                  ((o)localObject1).qFQ.setVisibility(0);
                  ((o)localObject1).qFt.setText(a.i.wallet_pwd_dialog_finger_print_titile);
                  ((o)localObject1).bWC();
                  com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
                }
              }
              for (;;)
              {
                y.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(((o)localObject1).qGh), Boolean.valueOf(((o)localObject1).qFS), Boolean.valueOf(bWS()) });
                ((o)localObject1).qFN.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    int i = 0;
                    if (o.this.qFR == 0) {
                      if (o.this.qGh == 0) {
                        o.b(o.this);
                      }
                    }
                    for (;;)
                    {
                      if (o.this.qFR == 1)
                      {
                        o.bWX();
                        if (o.e(o.this)) {
                          o.f(o.this);
                        }
                      }
                      return;
                      o.c(o.this);
                      continue;
                      if (o.this.qFR == 1)
                      {
                        if (o.this.nqa == null) {
                          label92:
                          if (o.this.nqa != null) {
                            break label138;
                          }
                        }
                        label138:
                        for (paramAnonymousView = "";; paramAnonymousView = o.this.nqa.bMX)
                        {
                          com.tencent.mm.wallet_core.c.aa.d(i, paramAnonymousView, 19, "");
                          o.d(o.this);
                          break;
                          i = o.this.nqa.bUV;
                          break label92;
                        }
                      }
                      if (o.this.qFR == 2)
                      {
                        o.d(o.this);
                        com.tencent.mm.plugin.report.service.h.nFQ.f(15817, new Object[] { Integer.valueOf(4) });
                      }
                    }
                  }
                });
                break;
                if (((o)localObject1).qGh == 1)
                {
                  ((o)localObject1).qFR = 2;
                  ((o)localObject1).qGf.setVisibility(0);
                  ((o)localObject1).qFt.setText(a.i.wallet_pwd_dialog_face_id_titile);
                  continue;
                  if ((((o)localObject1).qGh >= 0) && (((o)localObject1).qFS) && (bWS()))
                  {
                    if (((o)localObject1).qGh == 0) {
                      ((o)localObject1).qFN.setText(((o)localObject1).getContext().getString(a.i.wallet_finger_print_pay_mode));
                    }
                    for (;;)
                    {
                      ((o)localObject1).qFN.setVisibility(0);
                      ((o)localObject1).qFR = 0;
                      ((o)localObject1).qFO.setVisibility(8);
                      ((o)localObject1).qGf.setVisibility(8);
                      ((o)localObject1).qFy.setVisibility(0);
                      if (!((o)localObject1).lMr.isShown()) {
                        ((o)localObject1).lMr.setVisibility(0);
                      }
                      ((o)localObject1).qFt.setText(a.i.wallet_pwd_dialog_titile);
                      if (((o)localObject1).nqa != null) {
                        ((o)localObject1).nqa.qFX = 0;
                      }
                      com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
                      com.tencent.mm.wallet_core.ui.e.Jc(8);
                      break;
                      ((o)localObject1).qFN.setText(((o)localObject1).getContext().getString(a.i.wallet_faceid_pay_mode));
                    }
                  }
                  if (((o)localObject1).nqa != null) {
                    ((o)localObject1).nqa.qFX = 0;
                  }
                  ((o)localObject1).qFN.setVisibility(8);
                  com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
                }
              }
              ((o)localObject1).qFv.setVisibility(8);
              break label2055;
              ((o)localObject1).kH(false);
            }
          }
          localObject6 = localObject1;
          continue;
          paramFavorPayInfo = null;
          break label1155;
          paramString = null;
          paramFavorPayInfo = null;
          localObject3 = localObject9;
          localObject4 = localObject8;
          localObject6 = localObject7;
          bool1 = bool2;
        }
      }
    }
  }
  
  private static LinkedList<String> a(Bankcard paramBankcard, Orders paramOrders)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramOrders != null) && (paramOrders.qwO != null) && (paramOrders.qwO.qlh != null))
    {
      paramOrders = paramOrders.qwO.qlh.qkL.iterator();
      while (paramOrders.hasNext())
      {
        com.tencent.mm.plugin.wallet.a.b localb = (com.tencent.mm.plugin.wallet.a.b)paramOrders.next();
        if (localb.mOc.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localb.qkN.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (com.tencent.mm.plugin.wallet.a.c)paramBankcard.next();
            if (paramOrders.qkO != 0) {
              localLinkedList.add(paramOrders.nxN);
            }
          }
          return localLinkedList;
        }
      }
    }
    return localLinkedList;
  }
  
  private static boolean a(Bankcard paramBankcard, Orders paramOrders, String paramString)
  {
    if (qGi.containsKey(paramString)) {}
    while ((paramOrders.qwO == null) || (paramOrders.qwO.qlh == null)) {
      return false;
    }
    label61:
    int j;
    if (paramOrders.qwO.qlh.qkL.size() > 0)
    {
      paramString = paramOrders.qwO.qlh.qkL.iterator();
      int i = 0;
      j = i;
      if (!paramString.hasNext()) {
        break label115;
      }
      com.tencent.mm.plugin.wallet.a.b localb = (com.tencent.mm.plugin.wallet.a.b)paramString.next();
      if ((localb.mOc == null) || (!localb.mOc.equals(paramBankcard.field_bindSerial))) {
        break label172;
      }
      i = 1;
    }
    label172:
    for (;;)
    {
      break label61;
      j = 0;
      label115:
      if (j != 0) {
        break;
      }
      if (paramOrders.qwO.qlh.qkL.size() > 0) {
        return true;
      }
      if ((paramOrders.qwO.qlh.qkM == null) || (paramOrders.qwO.qlh.qkM.qlr.size() <= 0)) {
        break;
      }
      return true;
    }
  }
  
  private void bWC()
  {
    com.tencent.mm.plugin.soter.d.a.bKP();
    final ll localll = new ll();
    localll.bUv.bOT = this.nqa.bMX;
    localll.bUv.bUx = 1;
    localll.bUv.bUz = new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        ll.b localb = localll.bUw;
        if (localb == null)
        {
          o.this.nqa.qFX = 0;
          y.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
        }
        label317:
        label365:
        boolean bool1;
        label569:
        do
        {
          return;
          int j = localb.errCode;
          y.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.aox });
          int i;
          Object localObject;
          if (j == 0)
          {
            y.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.bUA });
            if (o.this.nqa == null)
            {
              i = 0;
              if (o.this.nqa != null) {
                break label317;
              }
            }
            for (localObject = "";; localObject = o.this.nqa.bMX)
            {
              com.tencent.mm.wallet_core.c.aa.d(i, (String)localObject, 22, "");
              o.this.nqa.qFX = 1;
              o.this.nqa.bOU = localb.bOU;
              o.this.nqa.bOV = localb.bOV;
              o.this.nqa.bUA = localb.bUA;
              o.this.nqa.bOS = localb.bOS;
              localObject = o.this.nqa;
              ((PayInfo)localObject).qFY += 1;
              o.this.qFP.setText("");
              o.this.bWR();
              com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.plugin.soter.d.a.zj(0);
              return;
              i = o.this.nqa.bUV;
              break;
            }
          }
          y.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
          int k;
          if (o.this.nqa == null)
          {
            i = 0;
            if (o.this.nqa != null) {
              break label776;
            }
            localObject = "";
            com.tencent.mm.wallet_core.c.aa.d(i, (String)localObject, 23, "");
            o.this.nqa.qFX = 0;
            o.this.qFO.setVisibility(0);
            o.this.qFP.setTextColor(o.this.getContext().getResources().getColor(a.c.red));
            o.this.qFP.setText(a.i.wallet_finger_print_fail);
            i = (int)(System.currentTimeMillis() / 1000L);
            k = i - o.g(o.this);
            if (k > 1)
            {
              o.a(o.this, i);
              o.h(o.this);
              localObject = o.this.nqa;
              ((PayInfo)localObject).qFY += 1;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
            if ((j != 2) && (j != 10308)) {
              break label791;
            }
            bool1 = true;
            if (localb.bUB != 2) {
              break label797;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            y.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(o.i(o.this)), Integer.valueOf(j), Boolean.valueOf(bool2) });
            if (((!bool2) && ((o.i(o.this) >= 3) || (k <= 1))) || (bool1)) {
              break label803;
            }
            y.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
            if (o.j(o.this) == null) {
              o.a(o.this, com.tencent.mm.ui.c.a.gE(o.this.getContext()));
            }
            o.this.qFQ.setVisibility(8);
            o.this.qFP.setVisibility(4);
            o.j(o.this).reset();
            o.j(o.this).setAnimationListener(new o.9.1(this));
            o.this.qFP.startAnimation(o.j(o.this));
            com.tencent.mm.plugin.soter.d.a.zj(1);
            return;
            i = o.this.nqa.bUV;
            break;
            localObject = o.this.nqa.bMX;
            break label365;
            bool1 = false;
            break label569;
          }
        } while ((o.i(o.this) < 3) && (!bool1));
        label776:
        label791:
        label797:
        label803:
        y.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
        o.bWX();
        o.this.qFR = 0;
        o.k(o.this);
        o.this.qFN.setVisibility(8);
        o.this.qFO.setVisibility(8);
        o.this.qFP.setVisibility(0);
        o.this.qFP.setText(a.i.wallet_finger_print_not_recorded);
        o.this.qFP.setTextColor(o.this.getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
        o.this.qFt.setText(a.i.wallet_pwd_dialog_titile);
        o.this.qFy.setVisibility(0);
        if (!o.this.lMr.isShown()) {
          o.this.lMr.setVisibility(0);
        }
        com.tencent.mm.plugin.soter.d.a.zj(2);
        o.kK(true);
      }
    };
    com.tencent.mm.sdk.b.a.udP.a(localll, Looper.getMainLooper());
  }
  
  private static void bWD()
  {
    y.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    nk localnk = new nk();
    com.tencent.mm.sdk.b.a.udP.m(localnk);
  }
  
  private void bWQ()
  {
    if (this.qFR == 1) {
      this.qFN.setText(a.i.wallet_finger_print_pay_mode);
    }
    for (;;)
    {
      this.qFR = 0;
      this.qFW = bk.UZ();
      this.qFO.setVisibility(8);
      this.qGf.setVisibility(8);
      this.qFy.setVisibility(0);
      if (!this.lMr.isShown()) {
        this.lMr.setVisibility(0);
      }
      this.qFt.setText(a.i.wallet_pwd_dialog_titile);
      kG(true);
      this.nqa.qFX = 0;
      com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.e.Jc(29);
      bWD();
      return;
      this.qFN.setText(a.i.wallet_faceid_pay_mode);
    }
  }
  
  private static boolean bWS()
  {
    com.tencent.mm.kernel.g.DQ();
    Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upA, Boolean.valueOf(false));
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  private void g(Bankcard paramBankcard)
  {
    if (paramBankcard == null) {
      y.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
    }
    do
    {
      return;
      if (paramBankcard.bUQ())
      {
        this.qFw.setImageResource(a.e.wallet_balance_manager_logo_small);
        return;
      }
      if (paramBankcard.bUR())
      {
        this.qjy.a(paramBankcard, this.qFw);
        return;
      }
      if (!paramBankcard.bUU()) {
        break;
      }
      this.qFw.setImageDrawable(com.tencent.mm.svg.a.a.e(getContext().getResources(), a.h.honey_pay_bank_logo));
    } while (bk.bl(paramBankcard.qtP));
    this.qFw.setUseSdcardCache(true);
    this.qFw.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.bWn());
    this.qFw.dl(paramBankcard.qtP, a.h.honey_pay_bank_logo);
    return;
    this.qjy.a(getContext(), paramBankcard, this.qFw);
  }
  
  private static void kG(boolean paramBoolean)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upA, Boolean.valueOf(paramBoolean));
  }
  
  private void kH(boolean paramBoolean)
  {
    View localView = this.ipf.findViewById(a.f.bank_card_iv_un_read);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.qFZ = true;
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
    this.qFZ = false;
  }
  
  private void kI(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.qFB.setVisibility(8);
      this.qFC.setVisibility(8);
      return;
    }
    this.qFB.setVisibility(0);
    this.qFC.setVisibility(0);
  }
  
  public final void QN(String paramString)
  {
    this.nJn.setText(paramString);
  }
  
  public final void QP(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.qnx.setVisibility(0);
      this.qnx.setText(paramString);
      return;
    }
    this.qnx.setVisibility(8);
  }
  
  public final void QQ(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.qFF.setText(paramString);
      this.qFF.setVisibility(0);
      return;
    }
    this.qFF.setVisibility(8);
  }
  
  public final void a(final Context paramContext, final Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    this.qnm = b.qAd.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.qwO != null) && (paramOrders.qwO.qkX != null) && (paramOrders.qwO.qkX.size() > 0) && (this.qnm != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.qmA = this.qnm.QI(paramOrders.qwO.qkW);; this.qmA = paramFavorPayInfo)
      {
        this.qFx.setVisibility(0);
        if (this.qFB != null) {
          this.qFB.setTag(this.qmA);
        }
        this.qFM = paramBankcard;
        this.qFG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            o.this.qFD.setVisibility(8);
            int i;
            if (o.this.nqa == null)
            {
              i = 0;
              if (o.this.nqa != null) {
                break label91;
              }
            }
            label91:
            for (paramAnonymousView = "";; paramAnonymousView = o.this.nqa.bMX)
            {
              com.tencent.mm.wallet_core.c.aa.d(i, paramAnonymousView, 12, "");
              j.a(paramContext, paramOrders, o.this.qmA.qvC, new o.10.1(this));
              return;
              i = o.this.nqa.bUV;
              break;
            }
          }
        });
        Assert.assertNotNull(this.qnm);
        this.qFD.setVisibility(8);
        return;
      }
    }
    this.qFx.setVisibility(8);
  }
  
  public final void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.qFs == null) {
      return;
    }
    this.Oi = paramOnCancelListener;
    this.qFs.setVisibility(0);
    this.qFs.setOnClickListener(new o.2(this, paramOnCancelListener));
  }
  
  public final void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.qFB.setOnClickListener(paramOnClickListener);
      this.qFu.setText(paramCharSequence);
      kI(this.qFL);
      if (!paramBoolean)
      {
        this.qFA.setVisibility(8);
        return;
      }
      this.qFA.setVisibility(0);
      return;
    }
    this.qFB.setVisibility(8);
    this.qFC.setVisibility(8);
  }
  
  public void bWR()
  {
    kG(false);
    if (this.qFJ != null) {
      this.qFJ.onClick(this, 0);
    }
    dismiss();
    if (this.qGe != null) {
      this.qGe.a(this.qFy.getText(), this.qmA, this.qFK);
    }
    if (this.qFW < 0L) {
      y.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
    }
    do
    {
      return;
      if (this.qFR == 0)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(686L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(686L, 1L, bk.cp(this.qFW), false);
        return;
      }
    } while (this.qFR != 1);
    com.tencent.mm.plugin.report.service.h.nFQ.a(686L, 2L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(686L, 3L, bk.cp(this.qFW), false);
  }
  
  public int bWV()
  {
    return a.g.wallet_full_pwd_dialog;
  }
  
  public final void bWW()
  {
    if (this.qFr == null) {
      return;
    }
    this.qFJ = null;
    this.qFr.setOnClickListener(new o.11(this));
  }
  
  public final void bWs()
  {
    this.isPaused = false;
    if (com.tencent.mm.model.q.Gw()) {}
  }
  
  public final void bWt()
  {
    this.isPaused = true;
    if (com.tencent.mm.model.q.Gw()) {}
    while (this.qFR != 1) {
      return;
    }
    bWQ();
  }
  
  public final void bvr()
  {
    if (this.qFy != null) {
      this.qFy.bvr();
    }
  }
  
  public void ca(Context paramContext)
  {
    y.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    et(paramContext);
    eu(paramContext);
  }
  
  public final void d(String paramString, double paramDouble)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.nCX.setVisibility(0);
      this.nCX.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.qFL = false;
        kI(this.qFL);
        return;
      }
      this.qFL = true;
      kI(this.qFL);
      return;
    }
    this.nCX.setVisibility(8);
    this.qFL = true;
    kI(this.qFL);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      bWD();
      this.qjy.destory();
      if (this.klV != null) {
        this.klV.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  public final void et(Context paramContext)
  {
    this.ipf = View.inflate(paramContext, bWV(), null);
    this.qFr = ((Button)this.ipf.findViewById(a.f.mm_alert_ok_btn));
    this.qFs = ((ImageView)this.ipf.findViewById(a.f.wallet_pwd_close_iv));
    this.mKeyboard = ((MyKeyboardWindow)this.ipf.findViewById(a.f.tenpay_num_keyboard));
    this.lMr = this.ipf.findViewById(a.f.tenpay_keyboard_layout);
    this.nJn = ((TextView)this.ipf.findViewById(a.f.content));
    this.qFt = ((TextView)this.ipf.findViewById(a.f.wallet_pwd_title_tv));
    this.nCX = ((TextView)this.ipf.findViewById(a.f.fee));
    this.qnx = ((TextView)this.ipf.findViewById(a.f.origin_fee));
    this.qnx.getPaint().setFlags(16);
    this.qFu = ((TextView)this.ipf.findViewById(a.f.bankcard_tv));
    this.qFv = ((FavourLayout)this.ipf.findViewById(a.f.favour_tip));
    this.qFw = ((CdnImageView)this.ipf.findViewById(a.f.bankcard_logo));
    this.qFA = this.ipf.findViewById(a.f.favor_ll);
    this.qFx = ((TextView)this.ipf.findViewById(a.f.more_favors));
    this.ffK = ((ImageView)this.ipf.findViewById(a.f.chatting_user_iv));
    this.qFB = this.ipf.findViewById(a.f.bankcard_layout);
    this.qFC = ((TextView)this.ipf.findViewById(a.f.seperator));
    a.b.a(this.ffK, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.qFy = ((EditHintPasswdView)this.ipf.findViewById(a.f.input_et));
    this.qFD = ((ImageView)this.ipf.findViewById(a.f.has_larger_favor_reddot));
    this.qFN = ((TextView)this.ipf.findViewById(a.f.wallet_pay_mode_tv));
    this.qFO = this.ipf.findViewById(a.f.finger_print_layout);
    this.qFP = ((TextView)this.ipf.findViewById(a.f.finger_print_tips));
    this.qFQ = ((ImageView)this.ipf.findViewById(a.f.finger_print_icon));
    this.qFE = ((TextView)this.ipf.findViewById(a.f.charge_fee));
    this.qFF = ((TextView)this.ipf.findViewById(a.f.random_offer_title));
    this.qFG = this.ipf.findViewById(a.f.favor_container);
    this.qFH = ((TextView)this.ipf.findViewById(a.f.favors_desc));
    this.qGf = ((Button)this.ipf.findViewById(a.f.face_id_verify_btn));
    this.qFv.setVisibility(8);
  }
  
  @TargetApi(14)
  public void eu(Context paramContext)
  {
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.qFr.setEnabled(false);
    this.qFr.setTextColor(paramContext.getResources().getColorStateList(a.c.wallet_alert_btn_text_color));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.qFy);
    this.qFy.setOnInputValidListener(new o.1(this));
    this.qFy.requestFocus();
    Object localObject = (TextView)this.ipf.findViewById(a.f.wallet_pwd_title_tv);
    if (localObject != null) {
      ((TextView)localObject).setText(ab.hm(paramContext));
    }
    paramContext = (EditText)this.ipf.findViewById(a.f.wallet_content);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new com.tencent.mm.ui.a.c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new o.4(this));
    this.ipf.findViewById(a.f.tenpay_push_down).setOnClickListener(new o.5(this));
    this.qGf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        o.a(o.this);
      }
    });
  }
  
  public final void fl(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      this.qFx.setVisibility(0);
      this.qFx.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.qFH.setText(paramString1);
      this.qFH.setVisibility(0);
      return;
      this.qFx.setVisibility(8);
    }
    this.qFH.setVisibility(8);
  }
  
  public final void kJ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.qFB.setVisibility(0);
      return;
    }
    this.qFB.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.ipf);
    com.tencent.soter.a.g.f.cPH().cPI();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.Oi != null) {
        this.Oi.onCancel(this);
      }
      if (this.qGg != null) {
        this.qGg.bqo();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.fsA = paramBoolean;
    setCanceledOnTouchOutside(this.fsA);
  }
  
  private static final class b
    implements DialogInterface.OnCancelListener
  {
    private DialogInterface.OnCancelListener qGq = null;
    
    private b(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.qGq = paramOnCancelListener;
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      o.kK(false);
      if (this.qGq != null) {
        this.qGq.onCancel(paramDialogInterface);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o
 * JD-Core Version:    0.7.0.1
 */