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
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nm.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
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
  private static HashMap<String, Boolean> Aqi;
  public ImageView AmF;
  public View ApA;
  public View ApB;
  public TextView ApC;
  public ImageView ApD;
  public TextView ApE;
  public TextView ApF;
  public View ApG;
  public TextView ApH;
  protected DialogInterface.OnClickListener ApJ;
  protected boolean ApK;
  protected boolean ApL;
  public Bankcard ApM;
  public TextView ApN;
  public View ApO;
  public TextView ApP;
  protected int ApQ;
  protected boolean ApR;
  private int ApS;
  private Animation ApT;
  private String ApU;
  private long ApV;
  boolean ApY;
  public TextView Apt;
  public TextView Apu;
  public FavourLayout Apv;
  public CdnImageView Apw;
  public TextView Apx;
  public EditHintPasswdView Apy;
  public c Aqd;
  public Button Aqe;
  protected a Aqf;
  protected int Aqg;
  private byte[] Aqh;
  protected DialogInterface.OnCancelListener Vb;
  public View hIZ;
  public ImageView ikp;
  private boolean isPaused;
  protected boolean lA;
  private Context mContext;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private int rcE;
  private Animation rcU;
  public ImageView tnb;
  protected PayInfo uXi;
  public TextView vGn;
  public TextView vRJ;
  protected com.tencent.mm.plugin.wallet_core.utils.a zMG;
  protected d zQQ;
  protected FavorPayInfo zQd;
  public TextView zRb;
  
  static
  {
    AppMethodBeat.i(71219);
    Aqi = new HashMap();
    AppMethodBeat.o(71219);
  }
  
  public s(Context paramContext)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(71173);
    this.zQQ = null;
    this.zQd = new FavorPayInfo();
    this.ApK = false;
    this.ApL = true;
    this.ApM = null;
    this.zMG = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.ApQ = 0;
    this.Aqg = -1;
    this.ApR = false;
    this.ApS = 0;
    this.rcE = 0;
    this.ApT = null;
    this.ApU = "";
    this.ApV = -1L;
    this.Aqh = new byte[0];
    this.ApY = false;
    this.isPaused = false;
    aL(paramContext);
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
    locals.auv(paramString1);
    locals.d(com.tencent.mm.wallet_core.ui.e.d(paramDouble, paramString2), paramDouble);
    locals.ApL = true;
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
      locals.sL(bool);
      if (paramBankcard != null) {
        locals.a(paramString1, paramOnClickListener, false);
      }
      locals.Aqd = paramc;
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
    locals.auv(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      locals.vGn.setVisibility(0);
      locals.vGn.setText(paramString2);
    }
    for (;;)
    {
      locals.ApL = true;
      locals.sK(locals.ApL);
      locals.sL(false);
      locals.ApL = false;
      locals.Aqf = parama;
      locals.auw("");
      locals.Aqd = paramc;
      locals.show();
      com.tencent.mm.ui.base.h.a(paramContext, locals);
      AppMethodBeat.o(71204);
      return locals;
      locals.vGn.setVisibility(8);
    }
  }
  
  public static s a(Context paramContext, boolean paramBoolean, Orders paramOrders, final FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, String paramString, c paramc, final View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71201);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    if ((paramOrders == null) || (paramOrders.Afx == null) || (paramOrders.Afx.size() <= 0))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    d locald = e.Ajp.a(paramOrders);
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
      ad.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.Aeb, Boolean.valueOf(bool1) });
      String str1 = locald.bU(paramFavorPayInfo.Aeb, bool1);
      ad.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str1 });
      localObject2 = locald.auk(str1);
      localObject1 = locald.bT(str1, true);
      Object localObject4 = (d.a)((Map)localObject2).get(paramBankcard.field_bindSerial);
      Object localObject5 = (d.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
      Object localObject6 = locald.bS(str1, bool1);
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
        if ((localObject4 == null) || (((d.a)localObject4).Ajn == null) || (bt.isNullOrNil(((d.a)localObject4).Ajn.zOH))) {
          break label1170;
        }
        paramFavorPayInfo.Aeb = ((d.a)localObject4).Ajn.zOH;
        localObject1 = locald.edL();
        localObject5 = paramFavorPayInfo;
        localObject2 = "";
        if (paramPayInfo.Cos != null) {
          break label1284;
        }
        paramFavorPayInfo = "";
        if (bt.isNullOrNil(paramFavorPayInfo)) {
          break label1301;
        }
        if ((!bt.isNullOrNil(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.Afx == null)) {
          break label2008;
        }
        localObject2 = (Orders.Commodity)paramOrders.Afx.get(0);
        if (localObject2 == null) {
          break label2043;
        }
        paramString = ((Orders.Commodity)localObject2).uoe;
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
        d1 = paramOrders.dcH;
        bool2 = false;
        bool1 = false;
        if ((locald == null) || (localObject5 == null)) {
          break label2188;
        }
        localObject6 = locald.aum(((FavorPayInfo)localObject5).Aeb);
        if ((localObject6 == null) || (((j)localObject6).zOy <= 0.0D)) {
          break label2055;
        }
        bool1 = true;
        localObject4 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.dcH, paramOrders.uop);
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject6).zOx, paramOrders.uop);
        d1 = ((j)localObject6).zOq;
        str1 = ((j)localObject6).zOA;
        if (Aqi.containsKey(paramPayInfo.dcE)) {
          break label2183;
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(14530, new Object[] { Integer.valueOf(3) });
        paramFavorPayInfo = null;
        localObject2 = paramString;
        if (localObject6 != null)
        {
          localObject2 = paramString;
          if (((j)localObject6).zOz != 0)
          {
            paramString = ((j)localObject6).zOB;
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
        if (paramOrders.vAF > 0.0D) {}
        for (localObject1 = paramContext.getResources().getString(2131765188, new Object[] { com.tencent.mm.wallet_core.ui.e.d(paramOrders.vAF, paramOrders.uop) });; localObject1 = null)
        {
          if (paramBankcard == null)
          {
            paramFavorPayInfo = "";
            label861:
            localObject2 = paramFavorPayInfo;
            if (paramBankcard != null)
            {
              localObject2 = paramFavorPayInfo;
              if (paramBankcard.ebz()) {
                localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramFavorPayInfo);
              }
            }
            paramFavorPayInfo = new s(paramContext);
            paramFavorPayInfo.a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
            paramFavorPayInfo.sL(paramBoolean);
            paramFavorPayInfo.ApL = paramBoolean;
            paramFavorPayInfo.b(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setOnCancelListener(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setCancelable(true);
            paramFavorPayInfo.auv((String)localObject3);
            paramFavorPayInfo.d(localObject8, d2);
            paramFavorPayInfo.aux(localObject7);
            paramFavorPayInfo.a((CharSequence)localObject2, new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(71156);
                s.cAs().put(this.ulf.dcE, Boolean.TRUE);
                paramOnClickListener.onClick(paramAnonymousView);
                if (paramFavorPayInfo.ApY) {
                  com.tencent.mm.plugin.report.service.h.vKh.f(14530, new Object[] { Integer.valueOf(2) });
                }
                AppMethodBeat.o(71156);
              }
            }, bool2);
            paramFavorPayInfo.h(paramBankcard);
            if (paramOrders.Afu != 1) {
              break label2164;
            }
            paramBoolean = true;
            label1005:
            paramFavorPayInfo.a(paramPayInfo, paramBoolean);
            paramFavorPayInfo.jF(str2, paramString);
            paramFavorPayInfo.auy((String)localObject6);
            paramFavorPayInfo.auw((String)localObject1);
            paramFavorPayInfo.Aqd = paramc;
            paramFavorPayInfo.aS(a(paramBankcard, paramOrders));
            if (!a(paramBankcard, paramOrders, paramPayInfo.dcE)) {
              break label2169;
            }
            paramFavorPayInfo.sJ(true);
            com.tencent.mm.plugin.report.service.h.vKh.f(14530, new Object[] { Integer.valueOf(1) });
          }
          for (;;)
          {
            paramFavorPayInfo.show();
            ai.b(paramFavorPayInfo.getWindow());
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
            localObject1 = ((j)localObject6).zOH;
            break label288;
            label1150:
            localObject2 = ((d.a)localObject4).toString();
            break label297;
            localObject3 = ((d.a)localObject5).toString();
            break label306;
            if ((localObject5 != null) && (((d.a)localObject5).Ajn != null) && (!bt.isNullOrNil(((d.a)localObject5).Ajn.zOH)))
            {
              paramFavorPayInfo.Aeb = ((d.a)localObject5).Ajn.zOH;
              break label373;
            }
            if (localObject6 != null)
            {
              paramFavorPayInfo.Aeb = ((j)localObject6).zOH;
              break label373;
            }
            paramFavorPayInfo.Aeb = str1;
            break label373;
            label1238:
            if (paramOrders.Afy == null) {
              break label373;
            }
            paramFavorPayInfo = locald.aup(locald.auq(paramOrders.Afy.zOr));
            break label373;
            label1266:
            ad.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            localObject1 = null;
            localObject5 = paramFavorPayInfo;
            break label383;
            paramFavorPayInfo = paramPayInfo.Cos.getString("extinfo_key_19", "");
            break label398;
            if ((paramPayInfo.dtb == 32) || (paramPayInfo.dtb == 33))
            {
              str1 = paramPayInfo.Cos.getString("extinfo_key_5", "");
              localObject4 = paramPayInfo.Cos.getString("extinfo_key_1", "");
              localObject3 = paramContext.getString(2131765746);
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (!bt.isNullOrNil(str1))
              {
                localObject3 = str1;
                paramFavorPayInfo = str1;
              }
              if (!bt.isNullOrNil((String)localObject4))
              {
                g.afC();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW((String)localObject4);
                if (localObject2 != null)
                {
                  paramFavorPayInfo = ((com.tencent.mm.storage.af)localObject2).ZX();
                  localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aNm(paramFavorPayInfo));
                  if (bt.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = bt.u((String)localObject3, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ad.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(localObject4)));
                break label405;
              }
              ad.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              break label405;
            }
            if (paramPayInfo.dtb == 31)
            {
              paramFavorPayInfo = paramPayInfo.Cos.getString("extinfo_key_1", "");
              if (!bt.isNullOrNil(paramFavorPayInfo))
              {
                g.afC();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((com.tencent.mm.storage.af)localObject3).ZW();
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
            if (paramPayInfo.dtb == 42)
            {
              paramFavorPayInfo = paramPayInfo.Cos.getString("extinfo_key_1", "");
              if (!bt.isNullOrNil(paramFavorPayInfo))
              {
                g.afC();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((com.tencent.mm.storage.af)localObject3).ZW();
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
            if (paramPayInfo.dtb == 48)
            {
              paramFavorPayInfo = paramContext.getString(2131762090);
              break label405;
            }
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            if (paramPayInfo.dtb != 49) {
              break label405;
            }
            paramFavorPayInfo = paramPayInfo.Cos.getString("extinfo_key_1", "");
            if (!bt.isNullOrNil(paramFavorPayInfo))
            {
              paramFavorPayInfo = paramContext.getString(2131765746, new Object[] { paramFavorPayInfo });
              break label405;
            }
            ad.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.dtb) });
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
              localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject6).zOx, paramOrders.uop);
              bool1 = true;
              paramFavorPayInfo = paramContext.getString(2131765742);
              break label684;
            }
            localObject1 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.dcH, paramOrders.uop);
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
            paramFavorPayInfo.sJ(false);
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
    if ((paramOrders != null) && (paramOrders.Afy != null) && (paramOrders.Afy.zOC != null))
    {
      paramOrders = paramOrders.Afy.zOC.zNX.iterator();
      while (paramOrders.hasNext())
      {
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramOrders.next();
        if (localc.uns.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.zOi.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (com.tencent.mm.plugin.wallet.a.d)paramBankcard.next();
            if (paramOrders.zOj != 0) {
              localLinkedList.add(paramOrders.vzN);
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
    this.uXi = ???;
    this.ApR = paramBoolean;
    if (u.aqV())
    {
      AppMethodBeat.o(71190);
      return;
    }
    ad.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
    synchronized (this.Aqh)
    {
      ??? = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    }
    boolean bool2;
    if ((!???.ctO()) && (???.ctN()))
    {
      this.Aqg = 0;
      ad.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(this.Aqg) });
      this.ApS = 0;
      this.ApN.setVisibility(8);
      this.ApO.setVisibility(8);
      this.ApV = bt.GC();
      bool2 = p.rcp.rcr;
      if ((com.tencent.mm.plugin.wallet_core.model.s.ecc() == null) || (this.Aqg < 0)) {
        break label1500;
      }
    }
    label266:
    label294:
    label332:
    label858:
    label1500:
    for (paramBoolean = ???.ctZ();; paramBoolean = true)
    {
      Object localObject1;
      if (this.ApR)
      {
        localObject1 = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        if ((((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() != 1) || ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).ctN()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).ctQ())) || (!com.tencent.mm.plugin.soter.e.b.dFa()) || (!com.tencent.mm.plugin.soter.e.b.dEZ()) || (com.tencent.soter.core.a.fmN() != 0)) {
          break label757;
        }
        ad.i("MicroMsg.WalletPwdDialog", "may treble init error");
        com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 23);
        if (((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() == 2)
        {
          if (com.tencent.soter.core.a.fmN() != 0) {
            break label858;
          }
          com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 28);
        }
        if (!paramBoolean) {
          com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 27);
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 33);
        }
      }
      int i;
      if (!bool2)
      {
        boolean bool1 = true;
        paramBoolean &= bool1;
        if (!paramBoolean) {
          p.rcp.rcr = true;
        }
        ad.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (((this.uXi == null) || ((this.uXi.Cot != 100000) && (this.uXi.Cot != 100102))) && (paramBoolean)) {
          break label905;
        }
        ad.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(this.uXi.Cot) });
        if (!this.mKBLayout.isShown()) {
          this.mKBLayout.setVisibility(0);
        }
        if (this.uXi != null)
        {
          this.uXi.ApW = 0;
          this.uXi.dlK = "";
          this.uXi.dlL = "";
        }
        this.ApO.setVisibility(0);
        this.ApP.setVisibility(0);
        localObject1 = this.ApP;
        if ((this.uXi == null) || (this.uXi.Cot != 100102)) {
          break label877;
        }
        i = 2131765270;
        ((TextView)localObject1).setText(i);
        this.ApP.setTextColor(getContext().getResources().getColor(2131101133));
        if (paramBoolean) {
          break label884;
        }
        this.ApB.setVisibility(0);
        this.ApC.setVisibility(0);
      }
      for (;;)
      {
        if ((this.uXi != null) && (this.uXi.Cot == 100102))
        {
          g.afB().afk().set(ae.a.FhX, Boolean.TRUE);
          ???.lp(false);
          ???.lq(false);
          g.afB().afk().set(ae.a.FhV, Boolean.FALSE);
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71190);
        return;
        localObject2 = finally;
        AppMethodBeat.o(71190);
        throw localObject2;
        if ((!???.cua()) || (!???.cub()) || (???.ctP()) || (!???.ctQ())) {
          break;
        }
        this.Aqg = 1;
        break;
        label757:
        if (localObject2.type() != 2) {
          break label266;
        }
        if (com.tencent.soter.core.a.fmN() == 1)
        {
          if (!com.tencent.soter.core.a.fmP())
          {
            ad.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
            com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 24);
            break label266;
          }
          if (paramBoolean) {
            break label266;
          }
          ad.i("MicroMsg.WalletPwdDialog", "soter treble key error");
          com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 25);
          break label266;
        }
        if (paramBoolean) {
          break label266;
        }
        ad.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
        com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 26);
        break label266;
        com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 31);
        break label294;
        i = 0;
        break label332;
        label877:
        i = 2131765263;
        break label527;
        label884:
        this.ApB.setVisibility(8);
        this.ApC.setVisibility(8);
      }
      if ((this.uXi != null) && (this.uXi.Cot == 100001)) {
        this.uXi.ApW = 1;
      }
      if ((this.Aqg >= 0) && (this.ApR) && (!eer()))
      {
        this.ApN.setVisibility(0);
        this.ApN.setText(getContext().getString(2131765750));
        this.Apy.setVisibility(8);
        this.mKBLayout.setVisibility(8);
        if (this.uXi != null) {
          this.uXi.ApW = 1;
        }
        if (this.Aqg == 0)
        {
          this.ApQ = 1;
          this.ApO.setVisibility(0);
          this.AmF.setVisibility(0);
          this.Apt.setText(2131765741);
          eea();
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(this.Aqg), Boolean.valueOf(this.ApR), Boolean.valueOf(eer()) });
        this.ApN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int i = 0;
            AppMethodBeat.i(71160);
            if (s.this.ApQ == 0) {
              if (s.this.Aqg == 0) {
                s.b(s.this);
              }
            }
            for (;;)
            {
              if (s.this.ApQ == 1)
              {
                s.eeu();
                if (s.e(s.this)) {
                  s.f(s.this);
                }
              }
              AppMethodBeat.o(71160);
              return;
              s.c(s.this);
              continue;
              if (s.this.ApQ == 1)
              {
                if (s.this.uXi == null) {
                  label102:
                  if (s.this.uXi != null) {
                    break label148;
                  }
                }
                label148:
                for (paramAnonymousView = "";; paramAnonymousView = s.this.uXi.dcE)
                {
                  com.tencent.mm.wallet_core.c.af.f(i, paramAnonymousView, 19, "");
                  s.d(s.this);
                  break;
                  i = s.this.uXi.dtb;
                  break label102;
                }
              }
              if (s.this.ApQ == 2)
              {
                s.d(s.this);
                com.tencent.mm.plugin.report.service.h.vKh.f(15817, new Object[] { Integer.valueOf(4) });
              }
            }
          }
        });
        AppMethodBeat.o(71190);
        return;
        if (this.Aqg == 1)
        {
          this.ApQ = 2;
          this.Aqe.setVisibility(0);
          this.Apt.setText(2131765740);
          continue;
          if ((this.Aqg >= 0) && (this.ApR) && (eer()))
          {
            if (this.Aqg == 0) {
              this.ApN.setText(getContext().getString(2131765264));
            }
            for (;;)
            {
              this.ApN.setVisibility(0);
              this.ApQ = 0;
              this.ApO.setVisibility(8);
              this.Aqe.setVisibility(8);
              this.Apy.setVisibility(0);
              if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
              }
              this.Apt.setText(2131765747);
              if (this.uXi != null) {
                this.uXi.ApW = 0;
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.wallet_core.ui.e.aby(8);
              break;
              this.ApN.setText(getContext().getString(2131765256));
            }
          }
          if (this.uXi != null) {
            this.uXi.ApW = 0;
          }
          this.ApN.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
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
    if (Aqi.containsKey(paramString))
    {
      AppMethodBeat.o(71203);
      return false;
    }
    int j;
    if ((paramOrders.Afy != null) && (paramOrders.Afy.zOC != null)) {
      if (paramOrders.Afy.zOC.zNX.size() > 0)
      {
        paramString = paramOrders.Afy.zOC.zNX.iterator();
        int i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label139;
        }
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramString.next();
        if ((localc.uns == null) || (!localc.uns.equals(paramBankcard.field_bindSerial))) {
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
      if (paramOrders.Afy.zOC.zNX.size() > 0)
      {
        AppMethodBeat.o(71203);
        return true;
      }
      if ((paramOrders.Afy.zOC.zNY != null) && (paramOrders.Afy.zOC.zNY.zOO.size() > 0))
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
    return (paramPayInfo != null) && ((paramPayInfo.dtb == 31) || (paramPayInfo.dtb == 32) || (paramPayInfo.dtb == 33));
  }
  
  private void aS(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(71198);
    if (this.Apv != null)
    {
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        this.Apv.setWording(paramLinkedList);
        this.Apv.setVisibility(0);
        AppMethodBeat.o(71198);
        return;
      }
      this.Apv.setVisibility(8);
    }
    AppMethodBeat.o(71198);
  }
  
  private void auw(String paramString)
  {
    AppMethodBeat.i(71187);
    if (!TextUtils.isEmpty(paramString))
    {
      this.ApE.setVisibility(0);
      this.ApE.setText(paramString);
      AppMethodBeat.o(71187);
      return;
    }
    ad.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.ApE.setVisibility(8);
    AppMethodBeat.o(71187);
  }
  
  private void eea()
  {
    AppMethodBeat.i(71178);
    com.tencent.mm.plugin.soter.d.a.dEP();
    final nm localnm = new nm();
    localnm.dsz.dlJ = this.uXi.dcE;
    localnm.dsz.dsB = 1;
    localnm.dsz.dsD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71168);
        ad.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        nm.b localb = localnm.dsA;
        if (localb == null)
        {
          s.this.uXi.ApW = 0;
          ad.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71168);
          return;
        }
        int j = localb.errCode;
        ad.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.errMsg });
        int i;
        if (j == 0)
        {
          ad.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dsE });
          if (s.this.uXi == null) {
            i = 0;
          }
          for (;;)
          {
            Object localObject1;
            if (s.this.uXi == null)
            {
              localObject1 = "";
              com.tencent.mm.wallet_core.c.af.f(i, (String)localObject1, 22, "");
              s.this.uXi.ApW = 1;
              s.this.uXi.dlK = localb.dlK;
              s.this.uXi.dlL = localb.dlL;
            }
            try
            {
              localObject1 = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).ctR());
              ((JSONObject)localObject1).put("soter_type", com.tencent.mm.plugin.wallet_core.model.s.ecc().ecL());
              s.this.uXi.dsE = ((JSONObject)localObject1).toString();
              s.this.uXi.dlI = localb.dlI;
              localObject1 = s.this.uXi;
              ((PayInfo)localObject1).ApX += 1;
              s.this.ApP.setText("");
              s.this.eeq();
              com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.plugin.soter.d.a.Oe(0);
              AppMethodBeat.o(71168);
              return;
              i = s.this.uXi.dtb;
              continue;
              localObject1 = s.this.uXi.dcE;
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
        if (s.this.uXi == null)
        {
          i = 0;
          if (s.this.uXi != null) {
            break label849;
          }
          localObject2 = "";
          com.tencent.mm.wallet_core.c.af.f(i, (String)localObject2, 23, "");
          s.this.uXi.ApW = 0;
          s.this.ApO.setVisibility(0);
          s.this.ApP.setTextColor(s.this.getContext().getResources().getColor(2131100798));
          s.this.ApP.setText(2131765262);
          i = (int)(System.currentTimeMillis() / 1000L);
          k = i - s.g(s.this);
          if (k > 1)
          {
            s.a(s.this, i);
            s.h(s.this);
            localObject2 = s.this.uXi;
            ((PayInfo)localObject2).ApX += 1;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
          if ((j != 2) && (j != 10308)) {
            break label864;
          }
          bool1 = true;
          label636:
          if (localb.dsF != 2) {
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
            s.a(s.this, com.tencent.mm.ui.c.a.fZ(s.this.getContext()));
          }
          s.this.AmF.setVisibility(8);
          s.this.ApP.setVisibility(4);
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
                  s.this.ApP.setVisibility(8);
                  s.this.AmF.setVisibility(0);
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
                  s.this.ApP.setVisibility(0);
                  AppMethodBeat.o(71164);
                }
              });
              AppMethodBeat.o(71166);
            }
          });
          s.this.ApP.startAnimation(s.j(s.this));
          com.tencent.mm.plugin.soter.d.a.Oe(1);
          AppMethodBeat.o(71168);
          return;
          i = s.this.uXi.dtb;
          break;
          localObject2 = s.this.uXi.dcE;
          break label434;
          bool1 = false;
          break label636;
        }
        label876:
        if ((s.i(s.this) >= 3) || (bool1))
        {
          ad.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
          s.eeu();
          s.this.ApQ = 0;
          s.k(s.this);
          s.this.ApN.setVisibility(8);
          s.this.ApO.setVisibility(8);
          s.this.ApP.setVisibility(0);
          s.this.ApP.setText(2131765263);
          s.this.ApP.setTextColor(s.this.getContext().getResources().getColor(2131101133));
          s.this.Apt.setText(2131765747);
          s.this.Apy.setVisibility(0);
          if (!s.this.mKBLayout.isShown()) {
            s.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.Oe(2);
          s.sM(true);
        }
        AppMethodBeat.o(71168);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l(localnm);
    AppMethodBeat.o(71178);
  }
  
  private static void eeb()
  {
    AppMethodBeat.i(71179);
    ad.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(71179);
  }
  
  private void eep()
  {
    AppMethodBeat.i(71177);
    if (this.ApQ == 1) {
      this.ApN.setText(2131765264);
    }
    for (;;)
    {
      this.ApQ = 0;
      this.ApV = bt.GC();
      this.ApO.setVisibility(8);
      this.Aqe.setVisibility(8);
      this.Apy.setVisibility(0);
      if (!this.mKBLayout.isShown()) {
        this.mKBLayout.setVisibility(0);
      }
      this.Apt.setText(2131765747);
      sI(true);
      this.uXi.ApW = 0;
      com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.e.aby(29);
      eeb();
      AppMethodBeat.o(71177);
      return;
      this.ApN.setText(2131765256);
    }
  }
  
  private static boolean eer()
  {
    AppMethodBeat.i(71209);
    g.afC();
    Object localObject = g.afB().afk().get(ae.a.FhR, Boolean.FALSE);
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
    if (paramBankcard.ebv())
    {
      this.Apw.setImageResource(2131234612);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.ebw())
    {
      this.zMG.a(paramBankcard, this.Apw);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.ebz())
    {
      this.Apw.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      if (!bt.isNullOrNil(paramBankcard.Acn))
      {
        this.Apw.setUseSdcardCache(true);
        this.Apw.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.edz());
        this.Apw.fz(paramBankcard.Acn, 2131690298);
        AppMethodBeat.o(71191);
      }
    }
    else
    {
      this.zMG.a(getContext(), paramBankcard, this.Apw);
    }
    AppMethodBeat.o(71191);
  }
  
  private static void sI(boolean paramBoolean)
  {
    AppMethodBeat.i(71208);
    g.afC();
    g.afB().afk().set(ae.a.FhR, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71208);
  }
  
  private void sJ(boolean paramBoolean)
  {
    AppMethodBeat.i(71180);
    View localView = this.hIZ.findViewById(2131297117);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.ApY = true;
        AppMethodBeat.o(71180);
        return;
      }
      localView.setVisibility(8);
      this.ApY = false;
    }
    AppMethodBeat.o(71180);
  }
  
  private void sK(boolean paramBoolean)
  {
    AppMethodBeat.i(71193);
    if (!paramBoolean)
    {
      this.ApB.setVisibility(8);
      this.ApC.setVisibility(8);
      AppMethodBeat.o(71193);
      return;
    }
    this.ApB.setVisibility(0);
    this.ApC.setVisibility(0);
    AppMethodBeat.o(71193);
  }
  
  public final void a(final Context paramContext, final Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71194);
    this.zQQ = e.Ajp.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.Afy != null) && (paramOrders.Afy.zOs != null) && (paramOrders.Afy.zOs.size() > 0) && (this.zQQ != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.zQd = this.zQQ.aup(paramOrders.Afy.zOr);; this.zQd = paramFavorPayInfo)
      {
        this.Apx.setVisibility(0);
        if (this.ApB != null) {
          this.ApB.setTag(this.zQd);
        }
        this.ApM = paramBankcard;
        this.ApG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71170);
            s.this.ApD.setVisibility(8);
            int i;
            if (s.this.uXi == null)
            {
              i = 0;
              if (s.this.uXi != null) {
                break label102;
              }
            }
            label102:
            for (paramAnonymousView = "";; paramAnonymousView = s.this.uXi.dcE)
            {
              com.tencent.mm.wallet_core.c.af.f(i, paramAnonymousView, 12, "");
              n.a(paramContext, paramOrders, s.this.zQd.Aeb, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  Object localObject2 = null;
                  AppMethodBeat.i(71169);
                  s.this.zQd = paramAnonymous2FavorPayInfo;
                  int i;
                  if (s.this.uXi == null)
                  {
                    i = 0;
                    if (s.this.uXi != null) {
                      break label294;
                    }
                    paramAnonymous2FavorPayInfo = "";
                    label51:
                    com.tencent.mm.wallet_core.c.af.f(i, paramAnonymous2FavorPayInfo, 15, s.this.zQd.Aeb);
                    s.this.ApK = false;
                    paramAnonymous2FavorPayInfo = d.cf(s.this.zQd.Aec, s.this.zQd.Aed);
                    s.this.zQd.Aef = "";
                    if (!d.a(s.this.zQd, s.this.ApM)) {
                      break label339;
                    }
                    s.this.ApK = true;
                    if (paramAnonymous2FavorPayInfo.size() != 0) {
                      break label311;
                    }
                  }
                  label294:
                  label311:
                  for (s.this.zQd.Aef = s.9.this.val$context.getString(2131765258);; s.this.zQd.Aef = s.9.this.val$context.getString(2131765259))
                  {
                    s.this.dismiss();
                    if (s.this.Aqd == null) {
                      break label339;
                    }
                    s.this.Aqd.a(s.this.Apy.getText(), s.this.zQd, s.this.ApK);
                    AppMethodBeat.o(71169);
                    return;
                    i = s.this.uXi.dtb;
                    break;
                    paramAnonymous2FavorPayInfo = s.this.uXi.dcE;
                    break label51;
                  }
                  label339:
                  if (s.this.ApB != null) {
                    s.this.ApB.setTag(s.this.zQd);
                  }
                  Object localObject1 = s.this.zQQ.aum(s.this.zQd.Aeb);
                  double d;
                  String str1;
                  String str3;
                  String str2;
                  String str4;
                  if ((localObject1 != null) && (((j)localObject1).zOy > 0.0D))
                  {
                    d = ((j)localObject1).zOq;
                    str1 = com.tencent.mm.wallet_core.ui.e.E(((j)localObject1).zOx);
                    str3 = com.tencent.mm.wallet_core.ui.e.E(s.9.this.Aqo.Afy.zOo);
                    str2 = ((j)localObject1).zOA;
                    paramAnonymous2FavorPayInfo = null;
                    if ((localObject1 == null) || (((j)localObject1).zOz == 0)) {
                      break label657;
                    }
                    str4 = ((j)localObject1).zOB;
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
                      s.this.aux(str3);
                      s.this.jF(str2, paramAnonymous2FavorPayInfo);
                      s.this.auy((String)localObject1);
                      AppMethodBeat.o(71169);
                      return;
                      d = s.9.this.Aqo.Afy.zOo;
                      str1 = com.tencent.mm.wallet_core.ui.e.E(s.9.this.Aqo.Afy.zOo);
                      paramAnonymous2FavorPayInfo = s.9.this.val$context.getString(2131765742);
                      str2 = null;
                      str3 = null;
                      break;
                      paramAnonymous2FavorPayInfo = ",".concat(String.valueOf(paramAnonymous2FavorPayInfo));
                    }
                  }
                }
              }, null);
              AppMethodBeat.o(71170);
              return;
              i = s.this.uXi.dtb;
              break;
            }
          }
        });
        Assert.assertNotNull(this.zQQ);
        this.ApD.setVisibility(8);
        AppMethodBeat.o(71194);
        return;
      }
    }
    this.Apx.setVisibility(8);
    AppMethodBeat.o(71194);
  }
  
  public final void a(a parama)
  {
    this.Aqf = parama;
  }
  
  public final void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(71192);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.ApB.setOnClickListener(paramOnClickListener);
      this.Apu.setText(paramCharSequence);
      sK(this.ApL);
      if (!paramBoolean)
      {
        this.ApA.setVisibility(8);
        AppMethodBeat.o(71192);
        return;
      }
      this.ApA.setVisibility(0);
      AppMethodBeat.o(71192);
      return;
    }
    this.ApB.setVisibility(8);
    this.ApC.setVisibility(8);
    AppMethodBeat.o(71192);
  }
  
  protected void aL(Context paramContext)
  {
    AppMethodBeat.i(71174);
    ad.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    gw(paramContext);
    gx(paramContext);
    AppMethodBeat.o(71174);
  }
  
  public final void auv(String paramString)
  {
    AppMethodBeat.i(71185);
    this.vRJ.setText(paramString);
    AppMethodBeat.o(71185);
  }
  
  public final void aux(String paramString)
  {
    AppMethodBeat.i(71189);
    if (!TextUtils.isEmpty(paramString))
    {
      this.zRb.setVisibility(0);
      this.zRb.setText(paramString);
      AppMethodBeat.o(71189);
      return;
    }
    this.zRb.setVisibility(8);
    AppMethodBeat.o(71189);
  }
  
  public final void auy(String paramString)
  {
    AppMethodBeat.i(71199);
    if (!bt.isNullOrNil(paramString))
    {
      this.ApF.setText(paramString);
      this.ApF.setVisibility(0);
      AppMethodBeat.o(71199);
      return;
    }
    this.ApF.setVisibility(8);
    AppMethodBeat.o(71199);
  }
  
  public final void b(final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71196);
    if (this.tnb == null)
    {
      AppMethodBeat.o(71196);
      return;
    }
    this.Vb = paramOnCancelListener;
    this.tnb.setVisibility(0);
    this.tnb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71171);
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(null);
        }
        if (s.this.Aqf != null) {
          s.this.Aqf.cYG();
        }
        s.this.cancel();
        if (s.this.ApN.isShown())
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(71171);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71171);
      }
    });
    AppMethodBeat.o(71196);
  }
  
  public int chg()
  {
    return 2131495963;
  }
  
  public final void d(String paramString, double paramDouble)
  {
    AppMethodBeat.i(71186);
    if (!TextUtils.isEmpty(paramString))
    {
      this.vGn.setVisibility(0);
      this.vGn.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.ApL = false;
        sK(this.ApL);
        AppMethodBeat.o(71186);
        return;
      }
      sK(this.ApL);
      AppMethodBeat.o(71186);
      return;
    }
    this.vGn.setVisibility(8);
    this.ApL = true;
    sK(this.ApL);
    AppMethodBeat.o(71186);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(71184);
    try
    {
      super.dismiss();
      eeb();
      this.zMG.destory();
      if (this.rcU != null) {
        this.rcU.cancel();
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
  
  public final void edM()
  {
    AppMethodBeat.i(71206);
    this.isPaused = false;
    if (u.aqV())
    {
      AppMethodBeat.o(71206);
      return;
    }
    AppMethodBeat.o(71206);
  }
  
  protected void eeq()
  {
    AppMethodBeat.i(71195);
    sI(false);
    if (this.ApJ != null) {
      this.ApJ.onClick(this, 0);
    }
    dismiss();
    if (this.Aqd != null) {
      this.Aqd.a(this.Apy.getText(), this.zQd, this.ApK);
    }
    if (this.ApV < 0L)
    {
      ad.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71195);
      return;
    }
    if (this.ApQ == 0)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(686L, 1L, bt.aS(this.ApV), false);
      AppMethodBeat.o(71195);
      return;
    }
    if (this.ApQ == 1)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(686L, 3L, bt.aS(this.ApV), false);
    }
    AppMethodBeat.o(71195);
  }
  
  protected final void gw(Context paramContext)
  {
    AppMethodBeat.i(71175);
    this.hIZ = View.inflate(paramContext, chg(), null);
    this.tnb = ((ImageView)this.hIZ.findViewById(2131306819));
    this.mKeyboard = ((MyKeyboardWindow)this.hIZ.findViewById(2131305695));
    this.mKBLayout = this.hIZ.findViewById(2131305693);
    this.vRJ = ((TextView)this.hIZ.findViewById(2131298739));
    this.Apt = ((TextView)this.hIZ.findViewById(2131306826));
    this.vGn = ((TextView)this.hIZ.findViewById(2131299872));
    this.zRb = ((TextView)this.hIZ.findViewById(2131303087));
    this.zRb.getPaint().setFlags(16);
    this.Apu = ((TextView)this.hIZ.findViewById(2131297176));
    this.Apv = ((FavourLayout)this.hIZ.findViewById(2131299869));
    this.Apw = ((CdnImageView)this.hIZ.findViewById(2131297165));
    this.ApA = this.hIZ.findViewById(2131299861);
    this.Apx = ((TextView)this.hIZ.findViewById(2131302467));
    this.ikp = ((ImageView)this.hIZ.findViewById(2131298184));
    this.ApB = this.hIZ.findViewById(2131297163);
    this.ApC = ((TextView)this.hIZ.findViewById(2131304595));
    a.b.c(this.ikp, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.Apy = ((EditHintPasswdView)this.hIZ.findViewById(2131301026));
    this.ApD = ((ImageView)this.hIZ.findViewById(2131300682));
    this.ApN = ((TextView)this.hIZ.findViewById(2131306814));
    this.ApO = this.hIZ.findViewById(2131300088);
    this.ApP = ((TextView)this.hIZ.findViewById(2131300091));
    this.AmF = ((ImageView)this.hIZ.findViewById(2131300087));
    this.ApE = ((TextView)this.hIZ.findViewById(2131297953));
    this.ApF = ((TextView)this.hIZ.findViewById(2131303711));
    this.ApG = this.hIZ.findViewById(2131299859);
    this.ApH = ((TextView)this.hIZ.findViewById(2131299868));
    this.Aqe = ((Button)this.hIZ.findViewById(2131299685));
    this.Apv.setVisibility(8);
    AppMethodBeat.o(71175);
  }
  
  @TargetApi(14)
  protected void gx(Context paramContext)
  {
    AppMethodBeat.i(71176);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Apy);
    this.Apy.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71155);
        if (paramAnonymousBoolean)
        {
          s.this.eeq();
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71155);
      }
    });
    this.Apy.requestFocus();
    Object localObject = (TextView)this.hIZ.findViewById(2131306826);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kp(paramContext));
    }
    paramContext = (EditText)this.hIZ.findViewById(2131306718);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new com.tencent.mm.ui.a.c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71157);
        if (!s.this.mKBLayout.isShown()) {
          s.this.mKBLayout.setVisibility(0);
        }
        AppMethodBeat.o(71157);
      }
    });
    this.hIZ.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71158);
        if (s.this.mKBLayout.isShown()) {
          s.this.mKBLayout.setVisibility(8);
        }
        AppMethodBeat.o(71158);
      }
    });
    this.Aqe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71159);
        s.a(s.this);
        AppMethodBeat.o(71159);
      }
    });
    AppMethodBeat.o(71176);
  }
  
  public final void jF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71188);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.Apx.setVisibility(0);
      this.Apx.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.ApH.setText(paramString1);
      this.ApH.setVisibility(0);
      AppMethodBeat.o(71188);
      return;
      this.Apx.setVisibility(8);
    }
    this.ApH.setVisibility(8);
    AppMethodBeat.o(71188);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71207);
    this.isPaused = true;
    if (u.aqV())
    {
      AppMethodBeat.o(71207);
      return;
    }
    if (this.ApQ == 1) {
      eep();
    }
    AppMethodBeat.o(71207);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71182);
    super.onCreate(paramBundle);
    setContentView(this.hIZ);
    com.tencent.soter.a.g.f.fnw().fnx();
    AppMethodBeat.o(71182);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71181);
    if (paramInt == 4)
    {
      if (this.Vb != null) {
        this.Vb.onCancel(this);
      }
      if (this.Aqf != null) {
        this.Aqf.cYG();
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(71181);
    return bool;
  }
  
  public final void sL(boolean paramBoolean)
  {
    AppMethodBeat.i(71197);
    if (paramBoolean)
    {
      this.ApB.setVisibility(0);
      AppMethodBeat.o(71197);
      return;
    }
    this.ApB.setVisibility(8);
    AppMethodBeat.o(71197);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(71183);
    super.setCancelable(paramBoolean);
    this.lA = paramBoolean;
    setCanceledOnTouchOutside(this.lA);
    AppMethodBeat.o(71183);
  }
  
  public static abstract interface a
  {
    public abstract void cYG();
  }
  
  static final class b
    implements DialogInterface.OnCancelListener
  {
    private DialogInterface.OnCancelListener Aqq = null;
    
    private b(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.Aqq = paramOnCancelListener;
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(71172);
      s.sM(false);
      if (this.Aqq != null) {
        this.Aqq.onCancel(paramDialogInterface);
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