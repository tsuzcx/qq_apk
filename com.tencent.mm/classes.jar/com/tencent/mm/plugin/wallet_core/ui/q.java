package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.soter.a.g.f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class q
  extends i
  implements d
{
  private static HashMap<String, Boolean> uto;
  protected DialogInterface.OnCancelListener NW;
  protected boolean gKc;
  public ImageView gxs;
  public View iCk;
  private boolean isPaused;
  private Context mContext;
  private Animation mGL;
  private int mGM;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  public ImageView our;
  protected PayInfo pVo;
  public TextView qpc;
  public TextView qwP;
  protected com.tencent.mm.plugin.wallet_core.utils.a tSy;
  protected FavorPayInfo tVQ;
  protected b tWD;
  public TextView tWO;
  public ImageView upK;
  public TextView usA;
  public FavourLayout usB;
  public CdnImageView usC;
  public TextView usD;
  public EditHintPasswdView usE;
  public View usG;
  public View usH;
  public TextView usI;
  public ImageView usJ;
  public TextView usK;
  public TextView usL;
  public View usM;
  public TextView usN;
  protected DialogInterface.OnClickListener usP;
  protected boolean usQ;
  protected boolean usR;
  public Bankcard usS;
  public TextView usT;
  public View usU;
  public TextView usV;
  protected int usW;
  protected boolean usX;
  private int usY;
  private Animation usZ;
  public TextView usz;
  private String uta;
  private long utb;
  boolean ute;
  public q.c utj;
  public Button utk;
  protected q.a utl;
  protected int utm;
  private byte[] utn;
  
  static
  {
    AppMethodBeat.i(47651);
    uto = new HashMap();
    AppMethodBeat.o(47651);
  }
  
  public q(Context paramContext)
  {
    super(paramContext, 2131493885);
    AppMethodBeat.i(47605);
    this.tWD = null;
    this.tVQ = new FavorPayInfo();
    this.usQ = false;
    this.usR = true;
    this.usS = null;
    this.tSy = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.usW = 0;
    this.utm = -1;
    this.usX = false;
    this.usY = 0;
    this.mGM = 0;
    this.usZ = null;
    this.uta = "";
    this.utb = -1L;
    this.utn = new byte[0];
    this.ute = false;
    this.isPaused = false;
    aA(paramContext);
    AppMethodBeat.o(47605);
  }
  
  public static q a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, q.c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47632);
    paramContext = a(paramContext, true, paramOrders, paramFavorPayInfo, paramBankcard, paramPayInfo, null, paramc, paramOnClickListener, paramOnCancelListener);
    AppMethodBeat.o(47632);
    return paramContext;
  }
  
  public static q a(Context paramContext, String paramString1, double paramDouble, String paramString2, Bankcard paramBankcard, q.c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    boolean bool = true;
    AppMethodBeat.i(47637);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(47637);
      return null;
    }
    q localq = new q(paramContext);
    localq.b(paramOnCancelListener);
    localq.setOnCancelListener(paramOnCancelListener);
    localq.setCancelable(true);
    localq.afL(paramString1);
    localq.f(com.tencent.mm.wallet_core.ui.e.e(paramDouble, paramString2), paramDouble);
    localq.usR = true;
    if (paramBankcard == null)
    {
      paramString1 = "";
      localq.h(paramBankcard);
      if (TextUtils.isEmpty(paramString1)) {
        break label157;
      }
    }
    for (;;)
    {
      localq.nQ(bool);
      if (paramBankcard != null) {
        localq.a(paramString1, paramOnClickListener, false);
      }
      localq.utj = paramc;
      localq.show();
      com.tencent.mm.ui.base.h.a(paramContext, localq);
      AppMethodBeat.o(47637);
      return localq;
      paramString1 = paramBankcard.field_desc;
      break;
      label157:
      bool = false;
    }
  }
  
  public static q a(Context paramContext, String paramString1, String paramString2, q.c paramc, DialogInterface.OnCancelListener paramOnCancelListener, q.a parama)
  {
    AppMethodBeat.i(47636);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(47636);
      return null;
    }
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(47636);
      return null;
    }
    q localq = new q(paramContext);
    localq.b(paramOnCancelListener);
    localq.setOnCancelListener(paramOnCancelListener);
    localq.setCancelable(true);
    localq.afL(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localq.qpc.setVisibility(0);
      localq.qpc.setText(paramString2);
    }
    for (;;)
    {
      localq.usR = true;
      localq.nP(localq.usR);
      localq.nQ(false);
      localq.usR = false;
      localq.utl = parama;
      localq.afM("");
      localq.utj = paramc;
      localq.show();
      com.tencent.mm.ui.base.h.a(paramContext, localq);
      AppMethodBeat.o(47636);
      return localq;
      localq.qpc.setVisibility(8);
    }
  }
  
  public static q a(Context paramContext, boolean paramBoolean, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, String paramString, q.c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47633);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(47633);
      return null;
    }
    if ((paramOrders == null) || (paramOrders.ujl == null) || (paramOrders.ujl.size() <= 0))
    {
      AppMethodBeat.o(47633);
      return null;
    }
    b localb = c.umO.a(paramOrders);
    Object localObject1;
    Object localObject2;
    label88:
    Object localObject3;
    if (paramFavorPayInfo == null)
    {
      localObject1 = "";
      if (paramBankcard != null) {
        break label1120;
      }
      localObject2 = "";
      if (paramBankcard != null) {
        break label1130;
      }
      localObject3 = "";
      label97:
      ab.i("MicroMsg.WalletPwdDialog", "showAlert with favInfo %s bindSerial %s  bankcardType %s", new Object[] { localObject1, localObject2, localObject3 });
      if (localb == null) {
        break label1266;
      }
      if ((paramFavorPayInfo == null) || (paramBankcard == null)) {
        break label1238;
      }
      if (!paramBankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
        break label2198;
      }
    }
    label398:
    label405:
    label2198:
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.uhU, Boolean.valueOf(bool1) });
      String str1 = localb.bJ(paramFavorPayInfo.uhU, bool1);
      ab.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str1 });
      localObject2 = localb.afB(str1);
      localObject1 = localb.bI(str1, true);
      Object localObject4 = (b.a)((Map)localObject2).get(paramBankcard.field_bindSerial);
      Object localObject5 = (b.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
      Object localObject6 = localb.bH(str1, bool1);
      label288:
      label297:
      label306:
      label373:
      label383:
      Object localObject8;
      Object localObject7;
      String str2;
      double d1;
      boolean bool2;
      label684:
      double d2;
      if (localObject6 == null)
      {
        localObject1 = "";
        if (localObject4 != null) {
          break label1150;
        }
        localObject2 = "";
        if (localObject5 != null) {
          break label1160;
        }
        localObject3 = "";
        ab.i("MicroMsg.WalletPwdDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((localObject4 == null) || (((b.a)localObject4).umL == null) || (bo.isNullOrNil(((b.a)localObject4).umL.tUv))) {
          break label1170;
        }
        paramFavorPayInfo.uhU = ((b.a)localObject4).umL.tUv;
        localObject1 = localb.cVp();
        localObject5 = paramFavorPayInfo;
        localObject2 = "";
        if (paramPayInfo.wgv != null) {
          break label1284;
        }
        paramFavorPayInfo = "";
        if (bo.isNullOrNil(paramFavorPayInfo)) {
          break label1301;
        }
        if ((!bo.isNullOrNil(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.ujl == null)) {
          break label2008;
        }
        localObject2 = (Orders.Commodity)paramOrders.ujl.get(0);
        if (localObject2 == null) {
          break label2043;
        }
        paramString = ((Orders.Commodity)localObject2).ppe;
        paramFavorPayInfo = paramString;
        if (a(paramPayInfo))
        {
          paramFavorPayInfo = paramString;
          if (!bo.isNullOrNil(paramString)) {
            paramFavorPayInfo = paramString + "\n";
          }
          paramFavorPayInfo = paramFavorPayInfo + ((Orders.Commodity)localObject2).desc;
        }
        localObject3 = paramFavorPayInfo;
        if (bo.isNullOrNil(paramFavorPayInfo)) {
          localObject3 = ((Orders.Commodity)localObject2).desc;
        }
        localObject8 = null;
        localObject7 = null;
        localObject4 = null;
        str2 = null;
        str1 = null;
        localObject6 = null;
        paramString = null;
        d1 = paramOrders.cnL;
        bool2 = false;
        bool1 = false;
        if ((localb == null) || (localObject5 == null)) {
          break label2188;
        }
        localObject6 = localb.afD(((FavorPayInfo)localObject5).uhU);
        if ((localObject6 == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject6).tUm <= 0.0D)) {
          break label2055;
        }
        bool1 = true;
        localObject4 = com.tencent.mm.wallet_core.ui.e.e(paramOrders.cnL, paramOrders.ppp);
        localObject1 = com.tencent.mm.wallet_core.ui.e.e(((com.tencent.mm.plugin.wallet.a.j)localObject6).tUl, paramOrders.ppp);
        d1 = ((com.tencent.mm.plugin.wallet.a.j)localObject6).tUe;
        str1 = ((com.tencent.mm.plugin.wallet.a.j)localObject6).tUo;
        if (uto.containsKey(paramPayInfo.cnI)) {
          break label2183;
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(14530, new Object[] { Integer.valueOf(3) });
        paramFavorPayInfo = null;
        localObject2 = paramString;
        if (localObject6 != null)
        {
          localObject2 = paramString;
          if (((com.tencent.mm.plugin.wallet.a.j)localObject6).tUn != 0)
          {
            paramString = ((com.tencent.mm.plugin.wallet.a.j)localObject6).tUp;
            localObject2 = paramString;
            if (!bo.isNullOrNil(str1)) {
              localObject2 = ",".concat(String.valueOf(paramString));
            }
          }
        }
        if (bo.isNullOrNil(str1))
        {
          localObject6 = localObject2;
          paramString = paramFavorPayInfo;
          d2 = d1;
          str2 = str1;
          localObject7 = localObject4;
          localObject8 = localObject1;
          bool2 = bool1;
          if (bo.isNullOrNil((String)localObject2)) {}
        }
        else
        {
          if (!bo.isNullOrNil(paramFavorPayInfo)) {
            break label2116;
          }
          paramString = null;
          bool2 = bool1;
          localObject8 = localObject1;
          localObject7 = localObject4;
          str2 = str1;
          d2 = d1;
          localObject6 = localObject2;
        }
      }
      for (;;)
      {
        label814:
        if (paramOrders.qjD > 0.0D) {}
        for (localObject1 = paramContext.getResources().getString(2131304996, new Object[] { com.tencent.mm.wallet_core.ui.e.e(paramOrders.qjD, paramOrders.ppp) });; localObject1 = null)
        {
          if (paramBankcard == null)
          {
            paramFavorPayInfo = "";
            label861:
            localObject2 = paramFavorPayInfo;
            if (paramBankcard != null)
            {
              localObject2 = paramFavorPayInfo;
              if (paramBankcard.cTj()) {
                localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramFavorPayInfo);
              }
            }
            paramFavorPayInfo = new q(paramContext);
            paramFavorPayInfo.a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
            paramFavorPayInfo.nQ(paramBoolean);
            paramFavorPayInfo.usR = paramBoolean;
            paramFavorPayInfo.b(new q.b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setOnCancelListener(new q.b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setCancelable(true);
            paramFavorPayInfo.afL((String)localObject3);
            paramFavorPayInfo.f(localObject8, d2);
            paramFavorPayInfo.afN(localObject7);
            paramFavorPayInfo.a((CharSequence)localObject2, new q.2(paramPayInfo, paramOnClickListener, paramFavorPayInfo), bool2);
            paramFavorPayInfo.h(paramBankcard);
            if (paramOrders.ujj != 1) {
              break label2164;
            }
            paramBoolean = true;
            label1005:
            paramFavorPayInfo.a(paramPayInfo, paramBoolean);
            paramFavorPayInfo.hc(str2, paramString);
            paramFavorPayInfo.afO((String)localObject6);
            paramFavorPayInfo.afM((String)localObject1);
            paramFavorPayInfo.utj = paramc;
            paramFavorPayInfo.aA(a(paramBankcard, paramOrders));
            if (!a(paramBankcard, paramOrders, paramPayInfo.cnI)) {
              break label2169;
            }
            paramFavorPayInfo.nO(true);
            com.tencent.mm.plugin.report.service.h.qsU.e(14530, new Object[] { Integer.valueOf(1) });
          }
          for (;;)
          {
            paramFavorPayInfo.show();
            af.a(paramFavorPayInfo.getWindow());
            com.tencent.mm.ui.base.h.a(paramContext, paramFavorPayInfo);
            AppMethodBeat.o(47633);
            return paramFavorPayInfo;
            localObject1 = paramFavorPayInfo.toString();
            break;
            label1120:
            localObject2 = paramBankcard.field_bindSerial;
            break label88;
            label1130:
            localObject3 = paramBankcard.field_bankcardType;
            break label97;
            localObject1 = ((com.tencent.mm.plugin.wallet.a.j)localObject6).tUv;
            break label288;
            label1150:
            localObject2 = ((b.a)localObject4).toString();
            break label297;
            localObject3 = ((b.a)localObject5).toString();
            break label306;
            if ((localObject5 != null) && (((b.a)localObject5).umL != null) && (!bo.isNullOrNil(((b.a)localObject5).umL.tUv)))
            {
              paramFavorPayInfo.uhU = ((b.a)localObject5).umL.tUv;
              break label373;
            }
            if (localObject6 != null)
            {
              paramFavorPayInfo.uhU = ((com.tencent.mm.plugin.wallet.a.j)localObject6).tUv;
              break label373;
            }
            paramFavorPayInfo.uhU = str1;
            break label373;
            label1238:
            if (paramOrders.ujm == null) {
              break label373;
            }
            paramFavorPayInfo = localb.afG(localb.afH(paramOrders.ujm.tUf));
            break label373;
            label1266:
            ab.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            localObject1 = null;
            localObject5 = paramFavorPayInfo;
            break label383;
            paramFavorPayInfo = paramPayInfo.wgv.getString("extinfo_key_19", "");
            break label398;
            if ((paramPayInfo.cCD == 32) || (paramPayInfo.cCD == 33))
            {
              str1 = paramPayInfo.wgv.getString("extinfo_key_5", "");
              localObject4 = paramPayInfo.wgv.getString("extinfo_key_1", "");
              localObject3 = paramContext.getString(2131305531);
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (!bo.isNullOrNil(str1))
              {
                localObject3 = str1;
                paramFavorPayInfo = str1;
              }
              if (!bo.isNullOrNil((String)localObject4))
              {
                g.RM();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru((String)localObject4);
                if (localObject2 != null)
                {
                  paramFavorPayInfo = ((ad)localObject2).Of();
                  localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.awj(paramFavorPayInfo));
                  if (bo.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = bo.p((String)localObject3, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ab.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(localObject4)));
                break label405;
              }
              ab.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              break label405;
            }
            if (paramPayInfo.cCD == 31)
            {
              paramFavorPayInfo = paramPayInfo.wgv.getString("extinfo_key_1", "");
              if (!bo.isNullOrNil(paramFavorPayInfo))
              {
                g.RM();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((ad)localObject3).Oe();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (bo.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131305531, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ab.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              ab.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.cCD == 42)
            {
              paramFavorPayInfo = paramPayInfo.wgv.getString("extinfo_key_1", "");
              if (!bo.isNullOrNil(paramFavorPayInfo))
              {
                g.RM();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((ad)localObject3).Oe();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (bo.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131305524, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ab.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              ab.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.cCD == 48)
            {
              paramFavorPayInfo = paramContext.getString(2131302211);
              break label405;
            }
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            if (paramPayInfo.cCD != 49) {
              break label405;
            }
            paramFavorPayInfo = paramPayInfo.wgv.getString("extinfo_key_1", "");
            if (!bo.isNullOrNil(paramFavorPayInfo))
            {
              paramFavorPayInfo = paramContext.getString(2131305531, new Object[] { paramFavorPayInfo });
              break label405;
            }
            ab.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.cCD) });
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            break label405;
            label2008:
            paramString = new StringBuilder("orders null?:");
            if (paramOrders == null) {}
            for (bool1 = true;; bool1 = false)
            {
              ab.w("MicroMsg.WalletPwdDialog", bool1);
              label2043:
              localObject3 = paramFavorPayInfo;
              break;
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = com.tencent.mm.wallet_core.ui.e.e(((com.tencent.mm.plugin.wallet.a.j)localObject6).tUl, paramOrders.ppp);
              bool1 = true;
              paramFavorPayInfo = paramContext.getString(2131305527);
              break label684;
            }
            localObject1 = com.tencent.mm.wallet_core.ui.e.e(paramOrders.cnL, paramOrders.ppp);
            paramFavorPayInfo = null;
            break label684;
            label2116:
            paramString = ",".concat(String.valueOf(paramFavorPayInfo));
            localObject6 = localObject2;
            d2 = d1;
            str2 = str1;
            localObject7 = localObject4;
            localObject8 = localObject1;
            bool2 = bool1;
            break label814;
            paramFavorPayInfo = paramBankcard.field_desc;
            break label861;
            label2164:
            paramBoolean = false;
            break label1005;
            label2169:
            paramFavorPayInfo.nO(false);
          }
        }
        paramFavorPayInfo = null;
        break label684;
        paramString = null;
        d2 = d1;
      }
    }
  }
  
  private static LinkedList<String> a(Bankcard paramBankcard, Orders paramOrders)
  {
    AppMethodBeat.i(47634);
    LinkedList localLinkedList = new LinkedList();
    if ((paramOrders != null) && (paramOrders.ujm != null) && (paramOrders.ujm.tUq != null))
    {
      paramOrders = paramOrders.ujm.tUq.tTL.iterator();
      while (paramOrders.hasNext())
      {
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramOrders.next();
        if (localc.por.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.tTW.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (com.tencent.mm.plugin.wallet.a.d)paramBankcard.next();
            if (paramOrders.tTX != 0) {
              localLinkedList.add(paramOrders.qiO);
            }
          }
          AppMethodBeat.o(47634);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(47634);
    return localLinkedList;
  }
  
  private void a(PayInfo arg1, boolean paramBoolean)
  {
    AppMethodBeat.i(47622);
    this.pVo = ???;
    this.usX = paramBoolean;
    if (r.ZB())
    {
      AppMethodBeat.o(47622);
      return;
    }
    ab.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
    synchronized (this.utn)
    {
      ??? = (l)g.E(l.class);
    }
    boolean bool;
    if ((!???.byT()) && (???.byS()))
    {
      this.utm = 0;
      ab.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(this.utm) });
      this.usY = 0;
      this.usT.setVisibility(8);
      this.usU.setVisibility(8);
      this.utb = bo.yB();
      bool = x.uli.mGD;
      if ((t.cTN() == null) || (this.utm < 0)) {
        break label1489;
      }
    }
    label266:
    label294:
    label1489:
    for (paramBoolean = ???.bzm();; paramBoolean = true)
    {
      Object localObject1;
      if (this.usX)
      {
        localObject1 = (l)g.E(l.class);
        if ((((l)localObject1).type() != 1) || ((!((l)localObject1).byS()) && (!((l)localObject1).byV())) || (!com.tencent.mm.plugin.soter.e.b.cyk()) || (!com.tencent.mm.plugin.soter.e.b.cyj()) || (com.tencent.soter.core.a.dUY() != 0)) {
          break label751;
        }
        ab.i("MicroMsg.WalletPwdDialog", "may treble init error");
        com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 23);
        if (((l)localObject1).type() == 2)
        {
          if (com.tencent.soter.core.a.dUY() != 0) {
            break label852;
          }
          com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 28);
        }
        if (!paramBoolean) {
          com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 27);
        }
        if (bool) {
          com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 33);
        }
      }
      paramBoolean &= bool;
      if (!paramBoolean) {
        x.uli.mGD = true;
      }
      ab.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if (((this.pVo != null) && ((this.pVo.wgw == 100000) || (this.pVo.wgw == 100102))) || (!paramBoolean))
      {
        ab.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(this.pVo.wgw) });
        if (!this.mKBLayout.isShown()) {
          this.mKBLayout.setVisibility(0);
        }
        if (this.pVo != null)
        {
          this.pVo.utc = 0;
          this.pVo.cwl = "";
          this.pVo.cwm = "";
        }
        this.usU.setVisibility(0);
        this.usV.setVisibility(0);
        localObject1 = this.usV;
        int i;
        if ((this.pVo != null) && (this.pVo.wgw == 100102))
        {
          i = 2131305078;
          ((TextView)localObject1).setText(i);
          this.usV.setTextColor(getContext().getResources().getColor(2131690665));
          if (paramBoolean) {
            break label873;
          }
          this.usH.setVisibility(0);
          this.usI.setVisibility(0);
        }
        for (;;)
        {
          if ((this.pVo != null) && (this.pVo.wgw == 100102))
          {
            g.RL().Ru().set(ac.a.yzC, Boolean.TRUE);
            ???.hH(false);
            ???.hI(false);
            g.RL().Ru().set(ac.a.yzA, Boolean.FALSE);
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(47622);
          return;
          localObject2 = finally;
          AppMethodBeat.o(47622);
          throw localObject2;
          if ((!???.bzn()) || (!???.bzo()) || (???.byU()) || (!???.byV())) {
            break;
          }
          this.utm = 1;
          break;
          label751:
          if (localObject2.type() != 2) {
            break label266;
          }
          if (com.tencent.soter.core.a.dUY() == 1)
          {
            if (!com.tencent.soter.core.a.dVa())
            {
              ab.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
              com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 24);
              break label266;
            }
            if (paramBoolean) {
              break label266;
            }
            ab.i("MicroMsg.WalletPwdDialog", "soter treble key error");
            com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 25);
            break label266;
          }
          if (paramBoolean) {
            break label266;
          }
          ab.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
          com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 26);
          break label266;
          label852:
          com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 31);
          break label294;
          i = 2131305071;
          break label521;
          label873:
          this.usH.setVisibility(8);
          this.usI.setVisibility(8);
        }
      }
      if ((this.pVo != null) && (this.pVo.wgw == 100001)) {
        this.pVo.utc = 1;
      }
      if ((this.utm >= 0) && (this.usX) && (!cVV()))
      {
        this.usT.setVisibility(0);
        this.usT.setText(getContext().getString(2131305535));
        this.usE.setVisibility(8);
        this.mKBLayout.setVisibility(8);
        if (this.pVo != null) {
          this.pVo.utc = 1;
        }
        if (this.utm == 0)
        {
          this.usW = 1;
          this.usU.setVisibility(0);
          this.upK.setVisibility(0);
          this.usz.setText(2131305526);
          cVD();
          com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(this.utm), Boolean.valueOf(this.usX), Boolean.valueOf(cVV()) });
        this.usT.setOnClickListener(new q.6(this));
        AppMethodBeat.o(47622);
        return;
        if (this.utm == 1)
        {
          this.usW = 2;
          this.utk.setVisibility(0);
          this.usz.setText(2131305525);
          continue;
          if ((this.utm >= 0) && (this.usX) && (cVV()))
          {
            if (this.utm == 0) {
              this.usT.setText(getContext().getString(2131305072));
            }
            for (;;)
            {
              this.usT.setVisibility(0);
              this.usW = 0;
              this.usU.setVisibility(8);
              this.utk.setVisibility(8);
              this.usE.setVisibility(0);
              if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
              }
              this.usz.setText(2131305532);
              if (this.pVo != null) {
                this.pVo.utc = 0;
              }
              com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.wallet_core.ui.e.RX(8);
              break;
              this.usT.setText(getContext().getString(2131305064));
            }
          }
          if (this.pVo != null) {
            this.pVo.utc = 0;
          }
          this.usT.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    }
  }
  
  private static boolean a(Bankcard paramBankcard, Orders paramOrders, String paramString)
  {
    AppMethodBeat.i(47635);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(47635);
      return false;
    }
    if (uto.containsKey(paramString))
    {
      AppMethodBeat.o(47635);
      return false;
    }
    int j;
    if ((paramOrders.ujm != null) && (paramOrders.ujm.tUq != null)) {
      if (paramOrders.ujm.tUq.tTL.size() > 0)
      {
        paramString = paramOrders.ujm.tUq.tTL.iterator();
        int i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label139;
        }
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramString.next();
        if ((localc.por == null) || (!localc.por.equals(paramBankcard.field_bindSerial))) {
          break label224;
        }
        i = 1;
      }
    }
    label139:
    label224:
    for (;;)
    {
      break;
      j = 0;
      if (j != 0)
      {
        AppMethodBeat.o(47635);
        return false;
      }
      if (paramOrders.ujm.tUq.tTL.size() > 0)
      {
        AppMethodBeat.o(47635);
        return true;
      }
      if ((paramOrders.ujm.tUq.tTM != null) && (paramOrders.ujm.tUq.tTM.tUD.size() > 0))
      {
        AppMethodBeat.o(47635);
        return true;
      }
      AppMethodBeat.o(47635);
      return false;
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.cCD == 31) || (paramPayInfo.cCD == 32) || (paramPayInfo.cCD == 33));
  }
  
  private void aA(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(47630);
    if (this.usB != null)
    {
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        this.usB.setWording(paramLinkedList);
        this.usB.setVisibility(0);
        AppMethodBeat.o(47630);
        return;
      }
      this.usB.setVisibility(8);
    }
    AppMethodBeat.o(47630);
  }
  
  private void afM(String paramString)
  {
    AppMethodBeat.i(47619);
    if (!TextUtils.isEmpty(paramString))
    {
      this.usK.setVisibility(0);
      this.usK.setText(paramString);
      AppMethodBeat.o(47619);
      return;
    }
    ab.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.usK.setVisibility(8);
    AppMethodBeat.o(47619);
  }
  
  private void cVD()
  {
    AppMethodBeat.i(47610);
    com.tencent.mm.plugin.soter.d.a.cyb();
    ma localma = new ma();
    localma.cCa.cwk = this.pVo.cnI;
    localma.cCa.cCc = 1;
    localma.cCa.cCe = new q.8(this, localma);
    com.tencent.mm.sdk.b.a.ymk.l(localma);
    AppMethodBeat.o(47610);
  }
  
  private static void cVE()
  {
    AppMethodBeat.i(47611);
    ab.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    ((l)g.E(l.class)).userCancel();
    AppMethodBeat.o(47611);
  }
  
  private void cVT()
  {
    AppMethodBeat.i(47609);
    if (this.usW == 1) {
      this.usT.setText(2131305072);
    }
    for (;;)
    {
      this.usW = 0;
      this.utb = bo.yB();
      this.usU.setVisibility(8);
      this.utk.setVisibility(8);
      this.usE.setVisibility(0);
      if (!this.mKBLayout.isShown()) {
        this.mKBLayout.setVisibility(0);
      }
      this.usz.setText(2131305532);
      nN(true);
      this.pVo.utc = 0;
      com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.e.RX(29);
      cVE();
      AppMethodBeat.o(47609);
      return;
      this.usT.setText(2131305064);
    }
  }
  
  private static boolean cVV()
  {
    AppMethodBeat.i(47641);
    g.RM();
    Object localObject = g.RL().Ru().get(ac.a.yzw, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(47641);
      return bool;
    }
  }
  
  private void h(Bankcard paramBankcard)
  {
    AppMethodBeat.i(47623);
    if (paramBankcard == null)
    {
      ab.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(47623);
      return;
    }
    if (paramBankcard.cTf())
    {
      this.usC.setImageResource(2130840794);
      AppMethodBeat.o(47623);
      return;
    }
    if (paramBankcard.cTg())
    {
      this.tSy.a(paramBankcard, this.usC);
      AppMethodBeat.o(47623);
      return;
    }
    if (paramBankcard.cTj())
    {
      this.usC.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131231407));
      if (!bo.isNullOrNil(paramBankcard.uge))
      {
        this.usC.setUseSdcardCache(true);
        this.usC.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.cVf());
        this.usC.eq(paramBankcard.uge, 2131231407);
        AppMethodBeat.o(47623);
      }
    }
    else
    {
      this.tSy.a(getContext(), paramBankcard, this.usC);
    }
    AppMethodBeat.o(47623);
  }
  
  private static void nN(boolean paramBoolean)
  {
    AppMethodBeat.i(47640);
    g.RM();
    g.RL().Ru().set(ac.a.yzw, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(47640);
  }
  
  private void nO(boolean paramBoolean)
  {
    AppMethodBeat.i(47612);
    View localView = this.iCk.findViewById(2131829366);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.ute = true;
        AppMethodBeat.o(47612);
        return;
      }
      localView.setVisibility(8);
      this.ute = false;
    }
    AppMethodBeat.o(47612);
  }
  
  private void nP(boolean paramBoolean)
  {
    AppMethodBeat.i(47625);
    if (!paramBoolean)
    {
      this.usH.setVisibility(8);
      this.usI.setVisibility(8);
      AppMethodBeat.o(47625);
      return;
    }
    this.usH.setVisibility(0);
    this.usI.setVisibility(0);
    AppMethodBeat.o(47625);
  }
  
  public final void a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(47626);
    this.tWD = c.umO.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.ujm != null) && (paramOrders.ujm.tUg != null) && (paramOrders.ujm.tUg.size() > 0) && (this.tWD != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.tVQ = this.tWD.afG(paramOrders.ujm.tUf);; this.tVQ = paramFavorPayInfo)
      {
        this.usD.setVisibility(0);
        if (this.usH != null) {
          this.usH.setTag(this.tVQ);
        }
        this.usS = paramBankcard;
        this.usM.setOnClickListener(new q.9(this, paramContext, paramOrders));
        Assert.assertNotNull(this.tWD);
        this.usJ.setVisibility(8);
        AppMethodBeat.o(47626);
        return;
      }
    }
    this.usD.setVisibility(8);
    AppMethodBeat.o(47626);
  }
  
  public final void a(q.a parama)
  {
    this.utl = parama;
  }
  
  public final void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(47624);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.usH.setOnClickListener(paramOnClickListener);
      this.usA.setText(paramCharSequence);
      nP(this.usR);
      if (!paramBoolean)
      {
        this.usG.setVisibility(8);
        AppMethodBeat.o(47624);
        return;
      }
      this.usG.setVisibility(0);
      AppMethodBeat.o(47624);
      return;
    }
    this.usH.setVisibility(8);
    this.usI.setVisibility(8);
    AppMethodBeat.o(47624);
  }
  
  protected void aA(Context paramContext)
  {
    AppMethodBeat.i(47606);
    ab.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    fr(paramContext);
    fs(paramContext);
    AppMethodBeat.o(47606);
  }
  
  public final void afL(String paramString)
  {
    AppMethodBeat.i(47617);
    this.qwP.setText(paramString);
    AppMethodBeat.o(47617);
  }
  
  public final void afN(String paramString)
  {
    AppMethodBeat.i(47621);
    if (!TextUtils.isEmpty(paramString))
    {
      this.tWO.setVisibility(0);
      this.tWO.setText(paramString);
      AppMethodBeat.o(47621);
      return;
    }
    this.tWO.setVisibility(8);
    AppMethodBeat.o(47621);
  }
  
  public final void afO(String paramString)
  {
    AppMethodBeat.i(47631);
    if (!bo.isNullOrNil(paramString))
    {
      this.usL.setText(paramString);
      this.usL.setVisibility(0);
      AppMethodBeat.o(47631);
      return;
    }
    this.usL.setVisibility(8);
    AppMethodBeat.o(47631);
  }
  
  public final void b(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47628);
    if (this.our == null)
    {
      AppMethodBeat.o(47628);
      return;
    }
    this.NW = paramOnCancelListener;
    this.our.setVisibility(0);
    this.our.setOnClickListener(new q.10(this, paramOnCancelListener));
    AppMethodBeat.o(47628);
  }
  
  public int bvM()
  {
    return 2130971187;
  }
  
  protected void cVU()
  {
    AppMethodBeat.i(47627);
    nN(false);
    if (this.usP != null) {
      this.usP.onClick(this, 0);
    }
    dismiss();
    if (this.utj != null) {
      this.utj.a(this.usE.getText(), this.tVQ, this.usQ);
    }
    if (this.utb < 0L)
    {
      ab.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(47627);
      return;
    }
    if (this.usW == 0)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(686L, 1L, bo.av(this.utb), false);
      AppMethodBeat.o(47627);
      return;
    }
    if (this.usW == 1)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(686L, 3L, bo.av(this.utb), false);
    }
    AppMethodBeat.o(47627);
  }
  
  public final void cVq()
  {
    AppMethodBeat.i(47638);
    this.isPaused = false;
    if (r.ZB())
    {
      AppMethodBeat.o(47638);
      return;
    }
    AppMethodBeat.o(47638);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(47616);
    try
    {
      super.dismiss();
      cVE();
      this.tSy.destory();
      if (this.mGL != null) {
        this.mGL.cancel();
      }
      AppMethodBeat.o(47616);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  public final void f(String paramString, double paramDouble)
  {
    AppMethodBeat.i(47618);
    if (!TextUtils.isEmpty(paramString))
    {
      this.qpc.setVisibility(0);
      this.qpc.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.usR = false;
        nP(this.usR);
        AppMethodBeat.o(47618);
        return;
      }
      nP(this.usR);
      AppMethodBeat.o(47618);
      return;
    }
    this.qpc.setVisibility(8);
    this.usR = true;
    nP(this.usR);
    AppMethodBeat.o(47618);
  }
  
  protected final void fr(Context paramContext)
  {
    AppMethodBeat.i(47607);
    this.iCk = View.inflate(paramContext, bvM(), null);
    this.our = ((ImageView)this.iCk.findViewById(2131826673));
    this.mKeyboard = ((MyKeyboardWindow)this.iCk.findViewById(2131822419));
    this.mKBLayout = this.iCk.findViewById(2131822418);
    this.qwP = ((TextView)this.iCk.findViewById(2131820946));
    this.usz = ((TextView)this.iCk.findViewById(2131829358));
    this.qpc = ((TextView)this.iCk.findViewById(2131826674));
    this.tWO = ((TextView)this.iCk.findViewById(2131826675));
    this.tWO.getPaint().setFlags(16);
    this.usA = ((TextView)this.iCk.findViewById(2131825959));
    this.usB = ((FavourLayout)this.iCk.findViewById(2131829080));
    this.usC = ((CdnImageView)this.iCk.findViewById(2131829365));
    this.usG = this.iCk.findViewById(2131829361);
    this.usD = ((TextView)this.iCk.findViewById(2131826678));
    this.gxs = ((ImageView)this.iCk.findViewById(2131826671));
    this.usH = this.iCk.findViewById(2131826676);
    this.usI = ((TextView)this.iCk.findViewById(2131829364));
    a.b.c(this.gxs, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.usE = ((EditHintPasswdView)this.iCk.findViewById(2131825034));
    this.usJ = ((ImageView)this.iCk.findViewById(2131826677));
    this.usT = ((TextView)this.iCk.findViewById(2131829359));
    this.usU = this.iCk.findViewById(2131829087);
    this.usV = ((TextView)this.iCk.findViewById(2131829089));
    this.upK = ((ImageView)this.iCk.findViewById(2131829088));
    this.usK = ((TextView)this.iCk.findViewById(2131827343));
    this.usL = ((TextView)this.iCk.findViewById(2131829363));
    this.usM = this.iCk.findViewById(2131829360);
    this.usN = ((TextView)this.iCk.findViewById(2131829362));
    this.utk = ((Button)this.iCk.findViewById(2131829367));
    this.usB.setVisibility(8);
    AppMethodBeat.o(47607);
  }
  
  @TargetApi(14)
  protected void fs(Context paramContext)
  {
    AppMethodBeat.i(47608);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    com.tencent.mm.wallet_core.ui.formview.a.a(this.usE);
    this.usE.setOnInputValidListener(new q.1(this));
    this.usE.requestFocus();
    Object localObject = (TextView)this.iCk.findViewById(2131829358);
    if (localObject != null) {
      ((TextView)localObject).setText(ae.iL(paramContext));
    }
    paramContext = (EditText)this.iCk.findViewById(2131820689);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new com.tencent.mm.ui.a.c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new q.3(this));
    this.iCk.findViewById(2131822420).setOnClickListener(new q.4(this));
    this.utk.setOnClickListener(new q.5(this));
    AppMethodBeat.o(47608);
  }
  
  public final void hc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(47620);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.usD.setVisibility(0);
      this.usD.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.usN.setText(paramString1);
      this.usN.setVisibility(0);
      AppMethodBeat.o(47620);
      return;
      this.usD.setVisibility(8);
    }
    this.usN.setVisibility(8);
    AppMethodBeat.o(47620);
  }
  
  public final void nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(47629);
    if (paramBoolean)
    {
      this.usH.setVisibility(0);
      AppMethodBeat.o(47629);
      return;
    }
    this.usH.setVisibility(8);
    AppMethodBeat.o(47629);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(47639);
    this.isPaused = true;
    if (r.ZB())
    {
      AppMethodBeat.o(47639);
      return;
    }
    if (this.usW == 1) {
      cVT();
    }
    AppMethodBeat.o(47639);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47614);
    super.onCreate(paramBundle);
    setContentView(this.iCk);
    f.dVD().dVE();
    AppMethodBeat.o(47614);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47613);
    if (paramInt == 4)
    {
      if (this.NW != null) {
        this.NW.onCancel(this);
      }
      if (this.utl != null) {
        this.utl.bYU();
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(47613);
    return bool;
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(47615);
    super.setCancelable(paramBoolean);
    this.gKc = paramBoolean;
    setCanceledOnTouchOutside(this.gKc);
    AppMethodBeat.o(47615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q
 * JD-Core Version:    0.7.0.1
 */