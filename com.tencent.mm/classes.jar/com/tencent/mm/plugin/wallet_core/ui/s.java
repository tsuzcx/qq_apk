package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.od.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends i
  implements f
{
  private static HashMap<String, Boolean> DiU;
  protected com.tencent.mm.plugin.wallet_core.utils.a CFp;
  protected FavorPayInfo CIL;
  public TextView CJJ;
  protected d CJy;
  public ImageView Dfs;
  public View DiA;
  public TextView DiB;
  protected int DiC;
  protected boolean DiD;
  private int DiE;
  private Animation DiF;
  private String DiG;
  private long DiH;
  boolean DiK;
  public c DiP;
  public Button DiQ;
  protected a DiR;
  protected int DiS;
  private byte[] DiT;
  public TextView Dif;
  public TextView Dig;
  public FavourLayout Dih;
  public CdnImageView Dii;
  public TextView Dij;
  public EditHintPasswdView Dik;
  public View Dim;
  public View Din;
  public TextView Dio;
  public ImageView Dip;
  public TextView Diq;
  public TextView Dir;
  public View Dis;
  public TextView Dit;
  protected DialogInterface.OnClickListener Div;
  protected boolean Diw;
  protected boolean Dix;
  public Bankcard Diy;
  public TextView Diz;
  protected DialogInterface.OnCancelListener XL;
  public View iCR;
  private boolean isPaused;
  public ImageView jdF;
  private Context mContext;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected boolean ov;
  private int thA;
  private Animation thQ;
  public ImageView vxX;
  protected PayInfo xnF;
  public TextView yea;
  public TextView yqw;
  
  static
  {
    AppMethodBeat.i(71219);
    DiU = new HashMap();
    AppMethodBeat.o(71219);
  }
  
  public s(Context paramContext)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(71173);
    this.CJy = null;
    this.CIL = new FavorPayInfo();
    this.Diw = false;
    this.Dix = true;
    this.Diy = null;
    this.CFp = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.DiC = 0;
    this.DiS = -1;
    this.DiD = false;
    this.DiE = 0;
    this.thA = 0;
    this.DiF = null;
    this.DiG = "";
    this.DiH = -1L;
    this.DiT = new byte[0];
    this.DiK = false;
    this.isPaused = false;
    aM(paramContext);
    AppMethodBeat.o(71173);
  }
  
  public static s a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71200);
    paramContext = a(paramContext, true, paramOrders, paramFavorPayInfo, paramBankcard, paramPayInfo, null, paramc, paramOnClickListener, paramOnCancelListener);
    AppMethodBeat.o(71200);
    return paramContext;
  }
  
  public static s a(Context paramContext, String paramString1, double paramDouble, String paramString2, Bankcard paramBankcard, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    boolean bool = true;
    AppMethodBeat.i(71205);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(71205);
      return null;
    }
    s locals = new s(paramContext);
    locals.b(paramOnCancelListener);
    locals.setOnCancelListener(paramOnCancelListener);
    locals.setCancelable(true);
    locals.aEW(paramString1);
    locals.d(com.tencent.mm.wallet_core.ui.e.d(paramDouble, paramString2), paramDouble);
    locals.Dix = true;
    if (paramBankcard == null)
    {
      paramString1 = "";
      locals.h(paramBankcard);
      if (TextUtils.isEmpty(paramString1)) {
        break label157;
      }
    }
    for (;;)
    {
      locals.uw(bool);
      if (paramBankcard != null) {
        locals.a(paramString1, paramOnClickListener, false);
      }
      locals.DiP = paramc;
      locals.show();
      com.tencent.mm.ui.base.h.a(paramContext, locals);
      AppMethodBeat.o(71205);
      return locals;
      paramString1 = paramBankcard.field_desc;
      break;
      label157:
      bool = false;
    }
  }
  
  public static s a(Context paramContext, String paramString1, String paramString2, c paramc, DialogInterface.OnCancelListener paramOnCancelListener, a parama)
  {
    AppMethodBeat.i(71204);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71204);
      return null;
    }
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71204);
      return null;
    }
    s locals = new s(paramContext);
    locals.b(paramOnCancelListener);
    locals.setOnCancelListener(paramOnCancelListener);
    locals.setCancelable(true);
    locals.aEW(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      locals.yea.setVisibility(0);
      locals.yea.setText(paramString2);
    }
    for (;;)
    {
      locals.Dix = true;
      locals.uv(locals.Dix);
      locals.uw(false);
      locals.Dix = false;
      locals.DiR = parama;
      locals.aEX("");
      locals.DiP = paramc;
      locals.show();
      com.tencent.mm.ui.base.h.a(paramContext, locals);
      AppMethodBeat.o(71204);
      return locals;
      locals.yea.setVisibility(8);
    }
  }
  
  public static s a(Context paramContext, boolean paramBoolean, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, String paramString, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71201);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    if ((paramOrders == null) || (paramOrders.CYk == null) || (paramOrders.CYk.size() <= 0))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    d locald = e.Dcd.a(paramOrders);
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
      ad.i("MicroMsg.WalletPwdDialog", "showAlert with favInfo %s bindSerial %s  bankcardType %s", new Object[] { localObject1, localObject2, localObject3 });
      if (locald == null) {
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
      ad.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.CWL, Boolean.valueOf(bool1) });
      String str1 = locald.cj(paramFavorPayInfo.CWL, bool1);
      ad.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str1 });
      localObject2 = locald.aEM(str1);
      localObject1 = locald.ci(str1, true);
      Object localObject4 = (d.a)((Map)localObject2).get(paramBankcard.field_bindSerial);
      Object localObject5 = (d.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
      Object localObject6 = locald.ch(str1, bool1);
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
        ad.i("MicroMsg.WalletPwdDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((localObject4 == null) || (((d.a)localObject4).Dcb == null) || (bt.isNullOrNil(((d.a)localObject4).Dcb.CHp))) {
          break label1170;
        }
        paramFavorPayInfo.CWL = ((d.a)localObject4).Dcb.CHp;
        localObject1 = locald.eHm();
        localObject5 = paramFavorPayInfo;
        localObject2 = "";
        if (paramPayInfo.htZ != null) {
          break label1284;
        }
        paramFavorPayInfo = "";
        if (bt.isNullOrNil(paramFavorPayInfo)) {
          break label1301;
        }
        if ((!bt.isNullOrNil(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.CYk == null)) {
          break label2008;
        }
        localObject2 = (Orders.Commodity)paramOrders.CYk.get(0);
        if (localObject2 == null) {
          break label2043;
        }
        paramString = ((Orders.Commodity)localObject2).wCu;
        paramFavorPayInfo = paramString;
        if (a(paramPayInfo))
        {
          paramFavorPayInfo = paramString;
          if (!bt.isNullOrNil(paramString)) {
            paramFavorPayInfo = paramString + "\n";
          }
          paramFavorPayInfo = paramFavorPayInfo + ((Orders.Commodity)localObject2).desc;
        }
        localObject3 = paramFavorPayInfo;
        if (bt.isNullOrNil(paramFavorPayInfo)) {
          localObject3 = ((Orders.Commodity)localObject2).desc;
        }
        localObject8 = null;
        localObject7 = null;
        localObject4 = null;
        str2 = null;
        str1 = null;
        localObject6 = null;
        paramString = null;
        d1 = paramOrders.dlx;
        bool2 = false;
        bool1 = false;
        if ((locald == null) || (localObject5 == null)) {
          break label2188;
        }
        localObject6 = locald.aEO(((FavorPayInfo)localObject5).CWL);
        if ((localObject6 == null) || (((j)localObject6).CHg <= 0.0D)) {
          break label2055;
        }
        bool1 = true;
        localObject4 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.dlx, paramOrders.wCF);
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject6).CHf, paramOrders.wCF);
        d1 = ((j)localObject6).CGY;
        str1 = ((j)localObject6).CHi;
        if (DiU.containsKey(paramPayInfo.dlu)) {
          break label2183;
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(14530, new Object[] { Integer.valueOf(3) });
        paramFavorPayInfo = null;
        localObject2 = paramString;
        if (localObject6 != null)
        {
          localObject2 = paramString;
          if (((j)localObject6).CHh != 0)
          {
            paramString = ((j)localObject6).CHj;
            localObject2 = paramString;
            if (!bt.isNullOrNil(str1)) {
              localObject2 = ",".concat(String.valueOf(paramString));
            }
          }
        }
        if (bt.isNullOrNil(str1))
        {
          localObject6 = localObject2;
          paramString = paramFavorPayInfo;
          d2 = d1;
          str2 = str1;
          localObject7 = localObject4;
          localObject8 = localObject1;
          bool2 = bool1;
          if (bt.isNullOrNil((String)localObject2)) {}
        }
        else
        {
          if (!bt.isNullOrNil(paramFavorPayInfo)) {
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
        if (paramOrders.xYr > 0.0D) {}
        for (localObject1 = paramContext.getResources().getString(2131765188, new Object[] { com.tencent.mm.wallet_core.ui.e.d(paramOrders.xYr, paramOrders.wCF) });; localObject1 = null)
        {
          if (paramBankcard == null)
          {
            paramFavorPayInfo = "";
            label861:
            localObject2 = paramFavorPayInfo;
            if (paramBankcard != null)
            {
              localObject2 = paramFavorPayInfo;
              if (paramBankcard.eEV()) {
                localObject2 = k.c(paramContext, paramFavorPayInfo);
              }
            }
            paramFavorPayInfo = new s(paramContext);
            paramFavorPayInfo.a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
            paramFavorPayInfo.uw(paramBoolean);
            paramFavorPayInfo.Dix = paramBoolean;
            paramFavorPayInfo.b(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setOnCancelListener(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setCancelable(true);
            paramFavorPayInfo.aEW((String)localObject3);
            paramFavorPayInfo.d(localObject8, d2);
            paramFavorPayInfo.aEY(localObject7);
            paramFavorPayInfo.a((CharSequence)localObject2, new s.2(paramPayInfo, paramOnClickListener, paramFavorPayInfo), bool2);
            paramFavorPayInfo.h(paramBankcard);
            if (paramOrders.CYh != 1) {
              break label2164;
            }
            paramBoolean = true;
            label1005:
            paramFavorPayInfo.a(paramPayInfo, paramBoolean);
            paramFavorPayInfo.kv(str2, paramString);
            paramFavorPayInfo.aEZ((String)localObject6);
            paramFavorPayInfo.aEX((String)localObject1);
            paramFavorPayInfo.DiP = paramc;
            paramFavorPayInfo.ba(a(paramBankcard, paramOrders));
            if (!a(paramBankcard, paramOrders, paramPayInfo.dlu)) {
              break label2169;
            }
            paramFavorPayInfo.uu(true);
            com.tencent.mm.plugin.report.service.g.yhR.f(14530, new Object[] { Integer.valueOf(1) });
          }
          for (;;)
          {
            paramFavorPayInfo.show();
            al.b(paramFavorPayInfo.getWindow());
            com.tencent.mm.ui.base.h.a(paramContext, paramFavorPayInfo);
            AppMethodBeat.o(71201);
            return paramFavorPayInfo;
            localObject1 = paramFavorPayInfo.toString();
            break;
            label1120:
            localObject2 = paramBankcard.field_bindSerial;
            break label88;
            label1130:
            localObject3 = paramBankcard.field_bankcardType;
            break label97;
            localObject1 = ((j)localObject6).CHp;
            break label288;
            label1150:
            localObject2 = ((d.a)localObject4).toString();
            break label297;
            localObject3 = ((d.a)localObject5).toString();
            break label306;
            if ((localObject5 != null) && (((d.a)localObject5).Dcb != null) && (!bt.isNullOrNil(((d.a)localObject5).Dcb.CHp)))
            {
              paramFavorPayInfo.CWL = ((d.a)localObject5).Dcb.CHp;
              break label373;
            }
            if (localObject6 != null)
            {
              paramFavorPayInfo.CWL = ((j)localObject6).CHp;
              break label373;
            }
            paramFavorPayInfo.CWL = str1;
            break label373;
            label1238:
            if (paramOrders.CYl == null) {
              break label373;
            }
            paramFavorPayInfo = locald.aER(locald.aES(paramOrders.CYl.CGZ));
            break label373;
            label1266:
            ad.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            localObject1 = null;
            localObject5 = paramFavorPayInfo;
            break label383;
            paramFavorPayInfo = paramPayInfo.htZ.getString("extinfo_key_19", "");
            break label398;
            if ((paramPayInfo.dCC == 32) || (paramPayInfo.dCC == 33))
            {
              str1 = paramPayInfo.htZ.getString("extinfo_key_5", "");
              localObject4 = paramPayInfo.htZ.getString("extinfo_key_1", "");
              localObject3 = paramContext.getString(2131765746);
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (!bt.isNullOrNil(str1))
              {
                localObject3 = str1;
                paramFavorPayInfo = str1;
              }
              if (!bt.isNullOrNil((String)localObject4))
              {
                com.tencent.mm.kernel.g.ajD();
                localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj((String)localObject4);
                if (localObject2 != null)
                {
                  paramFavorPayInfo = ((am)localObject2).adv();
                  localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aYO(paramFavorPayInfo));
                  if (bt.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = bt.x((String)localObject3, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ad.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(localObject4)));
                break label405;
              }
              ad.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              break label405;
            }
            if (paramPayInfo.dCC == 31)
            {
              paramFavorPayInfo = paramPayInfo.htZ.getString("extinfo_key_1", "");
              if (!bt.isNullOrNil(paramFavorPayInfo))
              {
                com.tencent.mm.kernel.g.ajD();
                localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((am)localObject3).adu();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (bt.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131765746, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ad.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              ad.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.dCC == 42)
            {
              paramFavorPayInfo = paramPayInfo.htZ.getString("extinfo_key_1", "");
              if (!bt.isNullOrNil(paramFavorPayInfo))
              {
                com.tencent.mm.kernel.g.ajD();
                localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((am)localObject3).adu();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (bt.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131765739, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ad.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              ad.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.dCC == 48)
            {
              paramFavorPayInfo = paramContext.getString(2131762090);
              break label405;
            }
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            if (paramPayInfo.dCC != 49) {
              break label405;
            }
            paramFavorPayInfo = paramPayInfo.htZ.getString("extinfo_key_1", "");
            if (!bt.isNullOrNil(paramFavorPayInfo))
            {
              paramFavorPayInfo = paramContext.getString(2131765746, new Object[] { paramFavorPayInfo });
              break label405;
            }
            ad.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.dCC) });
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            break label405;
            label2008:
            paramString = new StringBuilder("orders null?:");
            if (paramOrders == null) {}
            for (bool1 = true;; bool1 = false)
            {
              ad.w("MicroMsg.WalletPwdDialog", bool1);
              label2043:
              localObject3 = paramFavorPayInfo;
              break;
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject6).CHf, paramOrders.wCF);
              bool1 = true;
              paramFavorPayInfo = paramContext.getString(2131765742);
              break label684;
            }
            localObject1 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.dlx, paramOrders.wCF);
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
            paramFavorPayInfo.uu(false);
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
    AppMethodBeat.i(71202);
    LinkedList localLinkedList = new LinkedList();
    if ((paramOrders != null) && (paramOrders.CYl != null) && (paramOrders.CYl.CHk != null))
    {
      paramOrders = paramOrders.CYl.CHk.CGF.iterator();
      while (paramOrders.hasNext())
      {
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramOrders.next();
        if (localc.wBI.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.CGQ.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (com.tencent.mm.plugin.wallet.a.d)paramBankcard.next();
            if (paramOrders.CGR != 0) {
              localLinkedList.add(paramOrders.xXz);
            }
          }
          AppMethodBeat.o(71202);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(71202);
    return localLinkedList;
  }
  
  private void a(PayInfo arg1, boolean paramBoolean)
  {
    AppMethodBeat.i(71190);
    this.xnF = ???;
    this.DiD = paramBoolean;
    if (u.aAB())
    {
      AppMethodBeat.o(71190);
      return;
    }
    ad.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
    synchronized (this.DiT)
    {
      ??? = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    }
    boolean bool2;
    if ((!???.cPp()) && (???.cPo()))
    {
      this.DiS = 0;
      ad.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(this.DiS) });
      this.DiE = 0;
      this.Diz.setVisibility(8);
      this.DiA.setVisibility(8);
      this.DiH = bt.HI();
      bool2 = p.thl.thn;
      if ((t.eFy() == null) || (this.DiS < 0)) {
        break label1500;
      }
    }
    label266:
    label294:
    label332:
    label858:
    label1500:
    for (paramBoolean = ???.cPA();; paramBoolean = true)
    {
      Object localObject1;
      if (this.DiD)
      {
        localObject1 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        if ((((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() != 1) || ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).cPo()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).cPr())) || (!com.tencent.mm.plugin.soter.e.b.efP()) || (!com.tencent.mm.plugin.soter.e.b.efO()) || (com.tencent.soter.core.a.fUv() != 0)) {
          break label757;
        }
        ad.i("MicroMsg.WalletPwdDialog", "may treble init error");
        com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 23);
        if (((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() == 2)
        {
          if (com.tencent.soter.core.a.fUv() != 0) {
            break label858;
          }
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 28);
        }
        if (!paramBoolean) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 27);
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 33);
        }
      }
      int i;
      if (!bool2)
      {
        boolean bool1 = true;
        paramBoolean &= bool1;
        if (!paramBoolean) {
          p.thl.thn = true;
        }
        ad.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (((this.xnF == null) || ((this.xnF.FlS != 100000) && (this.xnF.FlS != 100102))) && (paramBoolean)) {
          break label905;
        }
        ad.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(this.xnF.FlS) });
        if (!this.mKBLayout.isShown()) {
          this.mKBLayout.setVisibility(0);
        }
        if (this.xnF != null)
        {
          this.xnF.DiI = 0;
          this.xnF.dvf = "";
          this.xnF.dvg = "";
        }
        this.DiA.setVisibility(0);
        this.DiB.setVisibility(0);
        localObject1 = this.DiB;
        if ((this.xnF == null) || (this.xnF.FlS != 100102)) {
          break label877;
        }
        i = 2131765270;
        ((TextView)localObject1).setText(i);
        this.DiB.setTextColor(getContext().getResources().getColor(2131101133));
        if (paramBoolean) {
          break label884;
        }
        this.Din.setVisibility(0);
        this.Dio.setVisibility(0);
      }
      for (;;)
      {
        if ((this.xnF != null) && (this.xnF.FlS == 100102))
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ise, Boolean.TRUE);
          ???.my(false);
          ???.mz(false);
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Isc, Boolean.FALSE);
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71190);
        return;
        localObject2 = finally;
        AppMethodBeat.o(71190);
        throw localObject2;
        if ((!???.cPB()) || (!???.cPC()) || (???.cPq()) || (!???.cPr())) {
          break;
        }
        this.DiS = 1;
        break;
        label757:
        if (localObject2.type() != 2) {
          break label266;
        }
        if (com.tencent.soter.core.a.fUv() == 1)
        {
          if (!com.tencent.soter.core.a.fUx())
          {
            ad.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
            com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 24);
            break label266;
          }
          if (paramBoolean) {
            break label266;
          }
          ad.i("MicroMsg.WalletPwdDialog", "soter treble key error");
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 25);
          break label266;
        }
        if (paramBoolean) {
          break label266;
        }
        ad.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
        com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 26);
        break label266;
        com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 31);
        break label294;
        i = 0;
        break label332;
        label877:
        i = 2131765263;
        break label527;
        label884:
        this.Din.setVisibility(8);
        this.Dio.setVisibility(8);
      }
      if ((this.xnF != null) && (this.xnF.FlS == 100001)) {
        this.xnF.DiI = 1;
      }
      if ((this.DiS >= 0) && (this.DiD) && (!eHS()))
      {
        this.Diz.setVisibility(0);
        this.Diz.setText(getContext().getString(2131765750));
        this.Dik.setVisibility(8);
        this.mKBLayout.setVisibility(8);
        if (this.xnF != null) {
          this.xnF.DiI = 1;
        }
        if (this.DiS == 0)
        {
          this.DiC = 1;
          this.DiA.setVisibility(0);
          this.Dfs.setVisibility(0);
          this.Dif.setText(2131765741);
          eHB();
          com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(this.DiS), Boolean.valueOf(this.DiD), Boolean.valueOf(eHS()) });
        this.Diz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71160);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (s.this.DiC == 0) {
              if (s.this.DiS == 0) {
                s.b(s.this);
              }
            }
            for (;;)
            {
              if (s.this.DiC == 1)
              {
                s.eHV();
                if (s.e(s.this)) {
                  s.f(s.this);
                }
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71160);
              return;
              s.c(s.this);
              continue;
              if (s.this.DiC == 1)
              {
                int i;
                if (s.this.xnF == null)
                {
                  i = 0;
                  label143:
                  if (s.this.xnF != null) {
                    break label189;
                  }
                }
                label189:
                for (paramAnonymousView = "";; paramAnonymousView = s.this.xnF.dlu)
                {
                  af.f(i, paramAnonymousView, 19, "");
                  s.d(s.this);
                  break;
                  i = s.this.xnF.dCC;
                  break label143;
                }
              }
              if (s.this.DiC == 2)
              {
                s.d(s.this);
                com.tencent.mm.plugin.report.service.g.yhR.f(15817, new Object[] { Integer.valueOf(4) });
              }
            }
          }
        });
        AppMethodBeat.o(71190);
        return;
        if (this.DiS == 1)
        {
          this.DiC = 2;
          this.DiQ.setVisibility(0);
          this.Dif.setText(2131765740);
          continue;
          if ((this.DiS >= 0) && (this.DiD) && (eHS()))
          {
            if (this.DiS == 0) {
              this.Diz.setText(getContext().getString(2131765264));
            }
            for (;;)
            {
              this.Diz.setVisibility(0);
              this.DiC = 0;
              this.DiA.setVisibility(8);
              this.DiQ.setVisibility(8);
              this.Dik.setVisibility(0);
              if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
              }
              this.Dif.setText(2131765747);
              if (this.xnF != null) {
                this.xnF.DiI = 0;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.wallet_core.ui.e.agr(8);
              break;
              this.Diz.setText(getContext().getString(2131765256));
            }
          }
          if (this.xnF != null) {
            this.xnF.DiI = 0;
          }
          this.Diz.setVisibility(8);
          com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    }
  }
  
  private static boolean a(Bankcard paramBankcard, Orders paramOrders, String paramString)
  {
    AppMethodBeat.i(71203);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(71203);
      return false;
    }
    if (DiU.containsKey(paramString))
    {
      AppMethodBeat.o(71203);
      return false;
    }
    int j;
    if ((paramOrders.CYl != null) && (paramOrders.CYl.CHk != null)) {
      if (paramOrders.CYl.CHk.CGF.size() > 0)
      {
        paramString = paramOrders.CYl.CHk.CGF.iterator();
        int i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label139;
        }
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramString.next();
        if ((localc.wBI == null) || (!localc.wBI.equals(paramBankcard.field_bindSerial))) {
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
        AppMethodBeat.o(71203);
        return false;
      }
      if (paramOrders.CYl.CHk.CGF.size() > 0)
      {
        AppMethodBeat.o(71203);
        return true;
      }
      if ((paramOrders.CYl.CHk.CGG != null) && (paramOrders.CYl.CHk.CGG.CHw.size() > 0))
      {
        AppMethodBeat.o(71203);
        return true;
      }
      AppMethodBeat.o(71203);
      return false;
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.dCC == 31) || (paramPayInfo.dCC == 32) || (paramPayInfo.dCC == 33));
  }
  
  private void aEX(String paramString)
  {
    AppMethodBeat.i(71187);
    if (!TextUtils.isEmpty(paramString))
    {
      this.Diq.setVisibility(0);
      this.Diq.setText(paramString);
      AppMethodBeat.o(71187);
      return;
    }
    ad.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.Diq.setVisibility(8);
    AppMethodBeat.o(71187);
  }
  
  private void ba(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(71198);
    if (this.Dih != null)
    {
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        this.Dih.setWording(paramLinkedList);
        this.Dih.setVisibility(0);
        AppMethodBeat.o(71198);
        return;
      }
      this.Dih.setVisibility(8);
    }
    AppMethodBeat.o(71198);
  }
  
  private void eHB()
  {
    AppMethodBeat.i(71178);
    com.tencent.mm.plugin.soter.d.a.efC();
    final od localod = new od();
    localod.dBW.dve = this.xnF.dlu;
    localod.dBW.dBY = 1;
    localod.dBW.dCa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71168);
        ad.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        od.b localb = localod.dBX;
        if (localb == null)
        {
          s.this.xnF.DiI = 0;
          ad.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71168);
          return;
        }
        int j = localb.errCode;
        ad.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.errMsg });
        int i;
        if (j == 0)
        {
          ad.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dCb });
          if (s.this.xnF == null) {
            i = 0;
          }
          for (;;)
          {
            Object localObject1;
            if (s.this.xnF == null)
            {
              localObject1 = "";
              af.f(i, (String)localObject1, 22, "");
              s.this.xnF.DiI = 1;
              s.this.xnF.dvf = localb.dvf;
              s.this.xnF.dvg = localb.dvg;
            }
            try
            {
              localObject1 = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cPs());
              ((JSONObject)localObject1).put("soter_type", t.eFy().eGg());
              s.this.xnF.dCb = ((JSONObject)localObject1).toString();
              s.this.xnF.dvd = localb.dvd;
              localObject1 = s.this.xnF;
              ((PayInfo)localObject1).DiJ += 1;
              s.this.DiB.setText("");
              s.this.eHR();
              com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.plugin.soter.d.a.RR(0);
              AppMethodBeat.o(71168);
              return;
              i = s.this.xnF.dCC;
              continue;
              localObject1 = s.this.xnF.dlu;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.WalletPwdDialog", localJSONException, "", new Object[0]);
              }
            }
          }
        }
        ad.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        Object localObject2;
        label434:
        int k;
        boolean bool1;
        if (s.this.xnF == null)
        {
          i = 0;
          if (s.this.xnF != null) {
            break label849;
          }
          localObject2 = "";
          af.f(i, (String)localObject2, 23, "");
          s.this.xnF.DiI = 0;
          s.this.DiA.setVisibility(0);
          s.this.DiB.setTextColor(s.this.getContext().getResources().getColor(2131100798));
          s.this.DiB.setText(2131765262);
          i = (int)(System.currentTimeMillis() / 1000L);
          k = i - s.g(s.this);
          if (k > 1)
          {
            s.a(s.this, i);
            s.h(s.this);
            localObject2 = s.this.xnF;
            ((PayInfo)localObject2).DiJ += 1;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
          if ((j != 2) && (j != 10308)) {
            break label864;
          }
          bool1 = true;
          label636:
          if (localb.dCc != 2) {
            break label870;
          }
        }
        label849:
        label864:
        label870:
        for (boolean bool2 = true;; bool2 = false)
        {
          ad.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(s.i(s.this)), Integer.valueOf(j), Boolean.valueOf(bool2) });
          if (((!bool2) && ((s.i(s.this) >= 3) || (k <= 1))) || (bool1)) {
            break label876;
          }
          ad.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
          if (s.j(s.this) == null) {
            s.a(s.this, com.tencent.mm.ui.c.a.go(s.this.getContext()));
          }
          s.this.Dfs.setVisibility(8);
          s.this.DiB.setVisibility(4);
          s.j(s.this).reset();
          s.j(s.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71167);
              ad.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71165);
                  s.this.DiB.setVisibility(8);
                  s.this.Dfs.setVisibility(0);
                  AppMethodBeat.o(71165);
                }
              });
              AppMethodBeat.o(71167);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71166);
              ad.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71164);
                  s.this.DiB.setVisibility(0);
                  AppMethodBeat.o(71164);
                }
              });
              AppMethodBeat.o(71166);
            }
          });
          s.this.DiB.startAnimation(s.j(s.this));
          com.tencent.mm.plugin.soter.d.a.RR(1);
          AppMethodBeat.o(71168);
          return;
          i = s.this.xnF.dCC;
          break;
          localObject2 = s.this.xnF.dlu;
          break label434;
          bool1 = false;
          break label636;
        }
        label876:
        if ((s.i(s.this) >= 3) || (bool1))
        {
          ad.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
          s.eHV();
          s.this.DiC = 0;
          s.k(s.this);
          s.this.Diz.setVisibility(8);
          s.this.DiA.setVisibility(8);
          s.this.DiB.setVisibility(0);
          s.this.DiB.setText(2131765263);
          s.this.DiB.setTextColor(s.this.getContext().getResources().getColor(2131101133));
          s.this.Dif.setText(2131765747);
          s.this.Dik.setVisibility(0);
          if (!s.this.mKBLayout.isShown()) {
            s.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.RR(2);
          s.ux(true);
        }
        AppMethodBeat.o(71168);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l(localod);
    AppMethodBeat.o(71178);
  }
  
  private static void eHC()
  {
    AppMethodBeat.i(71179);
    ad.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(71179);
  }
  
  private void eHQ()
  {
    AppMethodBeat.i(71177);
    if (this.DiC == 1) {
      this.Diz.setText(2131765264);
    }
    for (;;)
    {
      this.DiC = 0;
      this.DiH = bt.HI();
      this.DiA.setVisibility(8);
      this.DiQ.setVisibility(8);
      this.Dik.setVisibility(0);
      if (!this.mKBLayout.isShown()) {
        this.mKBLayout.setVisibility(0);
      }
      this.Dif.setText(2131765747);
      ut(true);
      this.xnF.DiI = 0;
      com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.e.agr(29);
      eHC();
      AppMethodBeat.o(71177);
      return;
      this.Diz.setText(2131765256);
    }
  }
  
  private static boolean eHS()
  {
    AppMethodBeat.i(71209);
    com.tencent.mm.kernel.g.ajD();
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrY, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71209);
      return bool;
    }
  }
  
  private void h(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71191);
    if (paramBankcard == null)
    {
      ad.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eER())
    {
      this.Dii.setImageResource(2131234612);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eES())
    {
      this.CFp.a(paramBankcard, this.Dii);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eEV())
    {
      this.Dii.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      if (!bt.isNullOrNil(paramBankcard.CUW))
      {
        this.Dii.setUseSdcardCache(true);
        this.Dii.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eHa());
        this.Dii.gb(paramBankcard.CUW, 2131690298);
        AppMethodBeat.o(71191);
      }
    }
    else
    {
      this.CFp.a(getContext(), paramBankcard, this.Dii);
    }
    AppMethodBeat.o(71191);
  }
  
  private static void ut(boolean paramBoolean)
  {
    AppMethodBeat.i(71208);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrY, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71208);
  }
  
  private void uu(boolean paramBoolean)
  {
    AppMethodBeat.i(71180);
    View localView = this.iCR.findViewById(2131297117);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.DiK = true;
        AppMethodBeat.o(71180);
        return;
      }
      localView.setVisibility(8);
      this.DiK = false;
    }
    AppMethodBeat.o(71180);
  }
  
  private void uv(boolean paramBoolean)
  {
    AppMethodBeat.i(71193);
    if (!paramBoolean)
    {
      this.Din.setVisibility(8);
      this.Dio.setVisibility(8);
      AppMethodBeat.o(71193);
      return;
    }
    this.Din.setVisibility(0);
    this.Dio.setVisibility(0);
    AppMethodBeat.o(71193);
  }
  
  public final void a(final Context paramContext, final Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71194);
    this.CJy = e.Dcd.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.CYl != null) && (paramOrders.CYl.CHa != null) && (paramOrders.CYl.CHa.size() > 0) && (this.CJy != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.CIL = this.CJy.aER(paramOrders.CYl.CGZ);; this.CIL = paramFavorPayInfo)
      {
        this.Dij.setVisibility(0);
        if (this.Din != null) {
          this.Din.setTag(this.CIL);
        }
        this.Diy = paramBankcard;
        this.Dis.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71170);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            s.this.Dip.setVisibility(8);
            int i;
            if (s.this.xnF == null)
            {
              i = 0;
              if (s.this.xnF != null) {
                break label143;
              }
            }
            label143:
            for (paramAnonymousView = "";; paramAnonymousView = s.this.xnF.dlu)
            {
              af.f(i, paramAnonymousView, 12, "");
              n.a(paramContext, paramOrders, s.this.CIL.CWL, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  Object localObject2 = null;
                  AppMethodBeat.i(71169);
                  s.this.CIL = paramAnonymous2FavorPayInfo;
                  int i;
                  if (s.this.xnF == null)
                  {
                    i = 0;
                    if (s.this.xnF != null) {
                      break label294;
                    }
                    paramAnonymous2FavorPayInfo = "";
                    label51:
                    af.f(i, paramAnonymous2FavorPayInfo, 15, s.this.CIL.CWL);
                    s.this.Diw = false;
                    paramAnonymous2FavorPayInfo = d.cq(s.this.CIL.CWM, s.this.CIL.CWN);
                    s.this.CIL.CWP = "";
                    if (!d.a(s.this.CIL, s.this.Diy)) {
                      break label339;
                    }
                    s.this.Diw = true;
                    if (paramAnonymous2FavorPayInfo.size() != 0) {
                      break label311;
                    }
                  }
                  label294:
                  label311:
                  for (s.this.CIL.CWP = s.9.this.val$context.getString(2131765258);; s.this.CIL.CWP = s.9.this.val$context.getString(2131765259))
                  {
                    s.this.dismiss();
                    if (s.this.DiP == null) {
                      break label339;
                    }
                    s.this.DiP.a(s.this.Dik.getText(), s.this.CIL, s.this.Diw);
                    AppMethodBeat.o(71169);
                    return;
                    i = s.this.xnF.dCC;
                    break;
                    paramAnonymous2FavorPayInfo = s.this.xnF.dlu;
                    break label51;
                  }
                  label339:
                  if (s.this.Din != null) {
                    s.this.Din.setTag(s.this.CIL);
                  }
                  Object localObject1 = s.this.CJy.aEO(s.this.CIL.CWL);
                  double d;
                  String str1;
                  String str3;
                  String str2;
                  String str4;
                  if ((localObject1 != null) && (((j)localObject1).CHg > 0.0D))
                  {
                    d = ((j)localObject1).CGY;
                    str1 = com.tencent.mm.wallet_core.ui.e.D(((j)localObject1).CHf);
                    str3 = com.tencent.mm.wallet_core.ui.e.D(s.9.this.Dja.CYl.CGW);
                    str2 = ((j)localObject1).CHi;
                    paramAnonymous2FavorPayInfo = null;
                    if ((localObject1 == null) || (((j)localObject1).CHh == 0)) {
                      break label657;
                    }
                    str4 = ((j)localObject1).CHj;
                    localObject1 = str4;
                    if (bt.isNullOrNil(str2)) {}
                  }
                  label657:
                  for (localObject1 = ",".concat(String.valueOf(str4));; localObject1 = null)
                  {
                    if ((!bt.isNullOrNil(str2)) || (!bt.isNullOrNil((String)localObject1))) {
                      if (bt.isNullOrNil(paramAnonymous2FavorPayInfo)) {
                        paramAnonymous2FavorPayInfo = localObject2;
                      }
                    }
                    for (;;)
                    {
                      s.this.d(str1, d);
                      s.this.aEY(str3);
                      s.this.kv(str2, paramAnonymous2FavorPayInfo);
                      s.this.aEZ((String)localObject1);
                      AppMethodBeat.o(71169);
                      return;
                      d = s.9.this.Dja.CYl.CGW;
                      str1 = com.tencent.mm.wallet_core.ui.e.D(s.9.this.Dja.CYl.CGW);
                      paramAnonymous2FavorPayInfo = s.9.this.val$context.getString(2131765742);
                      str2 = null;
                      str3 = null;
                      break;
                      paramAnonymous2FavorPayInfo = ",".concat(String.valueOf(paramAnonymous2FavorPayInfo));
                    }
                  }
                }
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71170);
              return;
              i = s.this.xnF.dCC;
              break;
            }
          }
        });
        Assert.assertNotNull(this.CJy);
        this.Dip.setVisibility(8);
        AppMethodBeat.o(71194);
        return;
      }
    }
    this.Dij.setVisibility(8);
    AppMethodBeat.o(71194);
  }
  
  public final void a(a parama)
  {
    this.DiR = parama;
  }
  
  public final void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(71192);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.Din.setOnClickListener(paramOnClickListener);
      this.Dig.setText(paramCharSequence);
      uv(this.Dix);
      if (!paramBoolean)
      {
        this.Dim.setVisibility(8);
        AppMethodBeat.o(71192);
        return;
      }
      this.Dim.setVisibility(0);
      AppMethodBeat.o(71192);
      return;
    }
    this.Din.setVisibility(8);
    this.Dio.setVisibility(8);
    AppMethodBeat.o(71192);
  }
  
  public final void aEW(String paramString)
  {
    AppMethodBeat.i(71185);
    this.yqw.setText(paramString);
    AppMethodBeat.o(71185);
  }
  
  public final void aEY(String paramString)
  {
    AppMethodBeat.i(71189);
    if (!TextUtils.isEmpty(paramString))
    {
      this.CJJ.setVisibility(0);
      this.CJJ.setText(paramString);
      AppMethodBeat.o(71189);
      return;
    }
    this.CJJ.setVisibility(8);
    AppMethodBeat.o(71189);
  }
  
  public final void aEZ(String paramString)
  {
    AppMethodBeat.i(71199);
    if (!bt.isNullOrNil(paramString))
    {
      this.Dir.setText(paramString);
      this.Dir.setVisibility(0);
      AppMethodBeat.o(71199);
      return;
    }
    this.Dir.setVisibility(8);
    AppMethodBeat.o(71199);
  }
  
  protected void aM(Context paramContext)
  {
    AppMethodBeat.i(71174);
    ad.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    gN(paramContext);
    gO(paramContext);
    AppMethodBeat.o(71174);
  }
  
  public final void b(final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71196);
    if (this.vxX == null)
    {
      AppMethodBeat.o(71196);
      return;
    }
    this.XL = paramOnCancelListener;
    this.vxX.setVisibility(0);
    this.vxX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71171);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(null);
        }
        if (s.this.DiR != null) {
          s.this.DiR.dwF();
        }
        s.this.cancel();
        if (s.this.Diz.isShown()) {
          com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71171);
          return;
          com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    });
    AppMethodBeat.o(71196);
  }
  
  public int cus()
  {
    return 2131495963;
  }
  
  public final void d(String paramString, double paramDouble)
  {
    AppMethodBeat.i(71186);
    if (!TextUtils.isEmpty(paramString))
    {
      this.yea.setVisibility(0);
      this.yea.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.Dix = false;
        uv(this.Dix);
        AppMethodBeat.o(71186);
        return;
      }
      uv(this.Dix);
      AppMethodBeat.o(71186);
      return;
    }
    this.yea.setVisibility(8);
    this.Dix = true;
    uv(this.Dix);
    AppMethodBeat.o(71186);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(71184);
    try
    {
      super.dismiss();
      eHC();
      this.CFp.destory();
      if (this.thQ != null) {
        this.thQ.cancel();
      }
      AppMethodBeat.o(71184);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  protected void eHR()
  {
    AppMethodBeat.i(71195);
    ut(false);
    if (this.Div != null) {
      this.Div.onClick(this, 0);
    }
    dismiss();
    if (this.DiP != null) {
      this.DiP.a(this.Dik.getText(), this.CIL, this.Diw);
    }
    if (this.DiH < 0L)
    {
      ad.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71195);
      return;
    }
    if (this.DiC == 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(686L, 1L, bt.aO(this.DiH), false);
      AppMethodBeat.o(71195);
      return;
    }
    if (this.DiC == 1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(686L, 3L, bt.aO(this.DiH), false);
    }
    AppMethodBeat.o(71195);
  }
  
  public final void eHn()
  {
    AppMethodBeat.i(71206);
    this.isPaused = false;
    if (u.aAB())
    {
      AppMethodBeat.o(71206);
      return;
    }
    AppMethodBeat.o(71206);
  }
  
  protected final void gN(Context paramContext)
  {
    AppMethodBeat.i(71175);
    this.iCR = View.inflate(paramContext, cus(), null);
    this.vxX = ((ImageView)this.iCR.findViewById(2131306819));
    this.mKeyboard = ((MyKeyboardWindow)this.iCR.findViewById(2131305695));
    this.mKBLayout = this.iCR.findViewById(2131305693);
    this.yqw = ((TextView)this.iCR.findViewById(2131298739));
    this.Dif = ((TextView)this.iCR.findViewById(2131306826));
    this.yea = ((TextView)this.iCR.findViewById(2131299872));
    this.CJJ = ((TextView)this.iCR.findViewById(2131303087));
    this.CJJ.getPaint().setFlags(16);
    this.Dig = ((TextView)this.iCR.findViewById(2131297176));
    this.Dih = ((FavourLayout)this.iCR.findViewById(2131299869));
    this.Dii = ((CdnImageView)this.iCR.findViewById(2131297165));
    this.Dim = this.iCR.findViewById(2131299861);
    this.Dij = ((TextView)this.iCR.findViewById(2131302467));
    this.jdF = ((ImageView)this.iCR.findViewById(2131298184));
    this.Din = this.iCR.findViewById(2131297163);
    this.Dio = ((TextView)this.iCR.findViewById(2131304595));
    a.b.c(this.jdF, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.Dik = ((EditHintPasswdView)this.iCR.findViewById(2131301026));
    this.Dip = ((ImageView)this.iCR.findViewById(2131300682));
    this.Diz = ((TextView)this.iCR.findViewById(2131306814));
    this.DiA = this.iCR.findViewById(2131300088);
    this.DiB = ((TextView)this.iCR.findViewById(2131300091));
    this.Dfs = ((ImageView)this.iCR.findViewById(2131300087));
    this.Diq = ((TextView)this.iCR.findViewById(2131297953));
    this.Dir = ((TextView)this.iCR.findViewById(2131303711));
    this.Dis = this.iCR.findViewById(2131299859);
    this.Dit = ((TextView)this.iCR.findViewById(2131299868));
    this.DiQ = ((Button)this.iCR.findViewById(2131299685));
    this.Dih.setVisibility(8);
    AppMethodBeat.o(71175);
  }
  
  @TargetApi(14)
  protected void gO(Context paramContext)
  {
    AppMethodBeat.i(71176);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Dik);
    this.Dik.setOnInputValidListener(new s.1(this));
    this.Dik.requestFocus();
    Object localObject = (TextView)this.iCR.findViewById(2131306826);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kN(paramContext));
    }
    paramContext = (EditText)this.iCR.findViewById(2131306718);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new com.tencent.mm.ui.a.c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new s.3(this));
    this.iCR.findViewById(2131305696).setOnClickListener(new s.4(this));
    this.DiQ.setOnClickListener(new s.5(this));
    AppMethodBeat.o(71176);
  }
  
  public final void kv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71188);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.Dij.setVisibility(0);
      this.Dij.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.Dit.setText(paramString1);
      this.Dit.setVisibility(0);
      AppMethodBeat.o(71188);
      return;
      this.Dij.setVisibility(8);
    }
    this.Dit.setVisibility(8);
    AppMethodBeat.o(71188);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71207);
    this.isPaused = true;
    if (u.aAB())
    {
      AppMethodBeat.o(71207);
      return;
    }
    if (this.DiC == 1) {
      eHQ();
    }
    AppMethodBeat.o(71207);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71182);
    super.onCreate(paramBundle);
    setContentView(this.iCR);
    com.tencent.soter.a.g.f.fVe().fVf();
    AppMethodBeat.o(71182);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71181);
    if (paramInt == 4)
    {
      if (this.XL != null) {
        this.XL.onCancel(this);
      }
      if (this.DiR != null) {
        this.DiR.dwF();
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(71181);
    return bool;
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(71183);
    super.setCancelable(paramBoolean);
    this.ov = paramBoolean;
    setCanceledOnTouchOutside(this.ov);
    AppMethodBeat.o(71183);
  }
  
  public final void uw(boolean paramBoolean)
  {
    AppMethodBeat.i(71197);
    if (paramBoolean)
    {
      this.Din.setVisibility(0);
      AppMethodBeat.o(71197);
      return;
    }
    this.Din.setVisibility(8);
    AppMethodBeat.o(71197);
  }
  
  public static abstract interface a
  {
    public abstract void dwF();
  }
  
  static final class b
    implements DialogInterface.OnCancelListener
  {
    private DialogInterface.OnCancelListener Djc = null;
    
    private b(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.Djc = paramOnCancelListener;
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(71172);
      s.ux(false);
      if (this.Djc != null) {
        this.Djc.onCancel(paramDialogInterface);
      }
      AppMethodBeat.o(71172);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.s
 * JD-Core Version:    0.7.0.1
 */