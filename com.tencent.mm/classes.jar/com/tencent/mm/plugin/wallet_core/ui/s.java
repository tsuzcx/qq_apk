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
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.b;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.af;
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
  private static HashMap<String, Boolean> BIC;
  public ImageView BFa;
  public TextView BHN;
  public TextView BHO;
  public FavourLayout BHP;
  public CdnImageView BHQ;
  public TextView BHR;
  public EditHintPasswdView BHS;
  public View BHU;
  public View BHV;
  public TextView BHW;
  public ImageView BHX;
  public TextView BHY;
  public TextView BHZ;
  protected int BIA;
  private byte[] BIB;
  public View BIa;
  public TextView BIb;
  protected DialogInterface.OnClickListener BId;
  protected boolean BIe;
  protected boolean BIf;
  public Bankcard BIg;
  public TextView BIh;
  public View BIi;
  public TextView BIj;
  protected int BIk;
  protected boolean BIl;
  private int BIm;
  private Animation BIn;
  private String BIo;
  private long BIp;
  boolean BIs;
  public c BIx;
  public Button BIy;
  protected a BIz;
  protected com.tencent.mm.plugin.wallet_core.utils.a Bfa;
  protected FavorPayInfo Bix;
  protected d Bjk;
  public TextView Bjv;
  protected DialogInterface.OnCancelListener VW;
  public ImageView iKw;
  public View ijA;
  private boolean isPaused;
  private Context mContext;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected boolean mz;
  private int skY;
  private Animation slo;
  public ImageView uvu;
  public TextView wQs;
  protected PayInfo wfX;
  public TextView xcu;
  
  static
  {
    AppMethodBeat.i(71219);
    BIC = new HashMap();
    AppMethodBeat.o(71219);
  }
  
  public s(Context paramContext)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(71173);
    this.Bjk = null;
    this.Bix = new FavorPayInfo();
    this.BIe = false;
    this.BIf = true;
    this.BIg = null;
    this.Bfa = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.BIk = 0;
    this.BIA = -1;
    this.BIl = false;
    this.BIm = 0;
    this.skY = 0;
    this.BIn = null;
    this.BIo = "";
    this.BIp = -1L;
    this.BIB = new byte[0];
    this.BIs = false;
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
    locals.azM(paramString1);
    locals.d(com.tencent.mm.wallet_core.ui.e.d(paramDouble, paramString2), paramDouble);
    locals.BIf = true;
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
      locals.tM(bool);
      if (paramBankcard != null) {
        locals.a(paramString1, paramOnClickListener, false);
      }
      locals.BIx = paramc;
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
    locals.azM(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      locals.wQs.setVisibility(0);
      locals.wQs.setText(paramString2);
    }
    for (;;)
    {
      locals.BIf = true;
      locals.tL(locals.BIf);
      locals.tM(false);
      locals.BIf = false;
      locals.BIz = parama;
      locals.azN("");
      locals.BIx = paramc;
      locals.show();
      com.tencent.mm.ui.base.h.a(paramContext, locals);
      AppMethodBeat.o(71204);
      return locals;
      locals.wQs.setVisibility(8);
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
    if ((paramOrders == null) || (paramOrders.BxR == null) || (paramOrders.BxR.size() <= 0))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    d locald = e.BBL.a(paramOrders);
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
      ac.i("MicroMsg.WalletPwdDialog", "showAlert with favInfo %s bindSerial %s  bankcardType %s", new Object[] { localObject1, localObject2, localObject3 });
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
      ac.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.Bwv, Boolean.valueOf(bool1) });
      String str1 = locald.cb(paramFavorPayInfo.Bwv, bool1);
      ac.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str1 });
      localObject2 = locald.azC(str1);
      localObject1 = locald.ca(str1, true);
      Object localObject4 = (d.a)((Map)localObject2).get(paramBankcard.field_bindSerial);
      Object localObject5 = (d.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
      Object localObject6 = locald.bZ(str1, bool1);
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
        ac.i("MicroMsg.WalletPwdDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((localObject4 == null) || (((d.a)localObject4).BBJ == null) || (bs.isNullOrNil(((d.a)localObject4).BBJ.Bhb))) {
          break label1170;
        }
        paramFavorPayInfo.Bwv = ((d.a)localObject4).BBJ.Bhb;
        localObject1 = locald.etg();
        localObject5 = paramFavorPayInfo;
        localObject2 = "";
        if (paramPayInfo.hbR != null) {
          break label1284;
        }
        paramFavorPayInfo = "";
        if (bs.isNullOrNil(paramFavorPayInfo)) {
          break label1301;
        }
        if ((!bs.isNullOrNil(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.BxR == null)) {
          break label2008;
        }
        localObject2 = (Orders.Commodity)paramOrders.BxR.get(0);
        if (localObject2 == null) {
          break label2043;
        }
        paramString = ((Orders.Commodity)localObject2).vxa;
        paramFavorPayInfo = paramString;
        if (a(paramPayInfo))
        {
          paramFavorPayInfo = paramString;
          if (!bs.isNullOrNil(paramString)) {
            paramFavorPayInfo = paramString + "\n";
          }
          paramFavorPayInfo = paramFavorPayInfo + ((Orders.Commodity)localObject2).desc;
        }
        localObject3 = paramFavorPayInfo;
        if (bs.isNullOrNil(paramFavorPayInfo)) {
          localObject3 = ((Orders.Commodity)localObject2).desc;
        }
        localObject8 = null;
        localObject7 = null;
        localObject4 = null;
        str2 = null;
        str1 = null;
        localObject6 = null;
        paramString = null;
        d1 = paramOrders.daf;
        bool2 = false;
        bool1 = false;
        if ((locald == null) || (localObject5 == null)) {
          break label2188;
        }
        localObject6 = locald.azE(((FavorPayInfo)localObject5).Bwv);
        if ((localObject6 == null) || (((j)localObject6).BgS <= 0.0D)) {
          break label2055;
        }
        bool1 = true;
        localObject4 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.daf, paramOrders.vxl);
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject6).BgR, paramOrders.vxl);
        d1 = ((j)localObject6).BgK;
        str1 = ((j)localObject6).BgU;
        if (BIC.containsKey(paramPayInfo.dac)) {
          break label2183;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(14530, new Object[] { Integer.valueOf(3) });
        paramFavorPayInfo = null;
        localObject2 = paramString;
        if (localObject6 != null)
        {
          localObject2 = paramString;
          if (((j)localObject6).BgT != 0)
          {
            paramString = ((j)localObject6).BgV;
            localObject2 = paramString;
            if (!bs.isNullOrNil(str1)) {
              localObject2 = ",".concat(String.valueOf(paramString));
            }
          }
        }
        if (bs.isNullOrNil(str1))
        {
          localObject6 = localObject2;
          paramString = paramFavorPayInfo;
          d2 = d1;
          str2 = str1;
          localObject7 = localObject4;
          localObject8 = localObject1;
          bool2 = bool1;
          if (bs.isNullOrNil((String)localObject2)) {}
        }
        else
        {
          if (!bs.isNullOrNil(paramFavorPayInfo)) {
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
        if (paramOrders.wKK > 0.0D) {}
        for (localObject1 = paramContext.getResources().getString(2131765188, new Object[] { com.tencent.mm.wallet_core.ui.e.d(paramOrders.wKK, paramOrders.vxl) });; localObject1 = null)
        {
          if (paramBankcard == null)
          {
            paramFavorPayInfo = "";
            label861:
            localObject2 = paramFavorPayInfo;
            if (paramBankcard != null)
            {
              localObject2 = paramFavorPayInfo;
              if (paramBankcard.eqV()) {
                localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramFavorPayInfo);
              }
            }
            paramFavorPayInfo = new s(paramContext);
            paramFavorPayInfo.a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
            paramFavorPayInfo.tM(paramBoolean);
            paramFavorPayInfo.BIf = paramBoolean;
            paramFavorPayInfo.b(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setOnCancelListener(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setCancelable(true);
            paramFavorPayInfo.azM((String)localObject3);
            paramFavorPayInfo.d(localObject8, d2);
            paramFavorPayInfo.azO(localObject7);
            paramFavorPayInfo.a((CharSequence)localObject2, new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(71156);
                s.cNB().put(this.vub.dac, Boolean.TRUE);
                paramOnClickListener.onClick(paramAnonymousView);
                if (paramFavorPayInfo.BIs) {
                  com.tencent.mm.plugin.report.service.h.wUl.f(14530, new Object[] { Integer.valueOf(2) });
                }
                AppMethodBeat.o(71156);
              }
            }, bool2);
            paramFavorPayInfo.h(paramBankcard);
            if (paramOrders.BxO != 1) {
              break label2164;
            }
            paramBoolean = true;
            label1005:
            paramFavorPayInfo.a(paramPayInfo, paramBoolean);
            paramFavorPayInfo.kb(str2, paramString);
            paramFavorPayInfo.azP((String)localObject6);
            paramFavorPayInfo.azN((String)localObject1);
            paramFavorPayInfo.BIx = paramc;
            paramFavorPayInfo.aZ(a(paramBankcard, paramOrders));
            if (!a(paramBankcard, paramOrders, paramPayInfo.dac)) {
              break label2169;
            }
            paramFavorPayInfo.tK(true);
            com.tencent.mm.plugin.report.service.h.wUl.f(14530, new Object[] { Integer.valueOf(1) });
          }
          for (;;)
          {
            paramFavorPayInfo.show();
            aj.b(paramFavorPayInfo.getWindow());
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
            localObject1 = ((j)localObject6).Bhb;
            break label288;
            label1150:
            localObject2 = ((d.a)localObject4).toString();
            break label297;
            localObject3 = ((d.a)localObject5).toString();
            break label306;
            if ((localObject5 != null) && (((d.a)localObject5).BBJ != null) && (!bs.isNullOrNil(((d.a)localObject5).BBJ.Bhb)))
            {
              paramFavorPayInfo.Bwv = ((d.a)localObject5).BBJ.Bhb;
              break label373;
            }
            if (localObject6 != null)
            {
              paramFavorPayInfo.Bwv = ((j)localObject6).Bhb;
              break label373;
            }
            paramFavorPayInfo.Bwv = str1;
            break label373;
            label1238:
            if (paramOrders.BxS == null) {
              break label373;
            }
            paramFavorPayInfo = locald.azH(locald.azI(paramOrders.BxS.BgL));
            break label373;
            label1266:
            ac.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            localObject1 = null;
            localObject5 = paramFavorPayInfo;
            break label383;
            paramFavorPayInfo = paramPayInfo.hbR.getString("extinfo_key_19", "");
            break label398;
            if ((paramPayInfo.dqL == 32) || (paramPayInfo.dqL == 33))
            {
              str1 = paramPayInfo.hbR.getString("extinfo_key_5", "");
              localObject4 = paramPayInfo.hbR.getString("extinfo_key_1", "");
              localObject3 = paramContext.getString(2131765746);
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (!bs.isNullOrNil(str1))
              {
                localObject3 = str1;
                paramFavorPayInfo = str1;
              }
              if (!bs.isNullOrNil((String)localObject4))
              {
                g.agS();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr((String)localObject4);
                if (localObject2 != null)
                {
                  paramFavorPayInfo = ((ai)localObject2).aaS();
                  localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aSP(paramFavorPayInfo));
                  if (bs.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = bs.u((String)localObject3, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ac.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(localObject4)));
                break label405;
              }
              ac.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              break label405;
            }
            if (paramPayInfo.dqL == 31)
            {
              paramFavorPayInfo = paramPayInfo.hbR.getString("extinfo_key_1", "");
              if (!bs.isNullOrNil(paramFavorPayInfo))
              {
                g.agS();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((ai)localObject3).aaR();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (bs.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131765746, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ac.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              ac.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.dqL == 42)
            {
              paramFavorPayInfo = paramPayInfo.hbR.getString("extinfo_key_1", "");
              if (!bs.isNullOrNil(paramFavorPayInfo))
              {
                g.agS();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((ai)localObject3).aaR();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (bs.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131765739, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ac.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              ac.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.dqL == 48)
            {
              paramFavorPayInfo = paramContext.getString(2131762090);
              break label405;
            }
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            if (paramPayInfo.dqL != 49) {
              break label405;
            }
            paramFavorPayInfo = paramPayInfo.hbR.getString("extinfo_key_1", "");
            if (!bs.isNullOrNil(paramFavorPayInfo))
            {
              paramFavorPayInfo = paramContext.getString(2131765746, new Object[] { paramFavorPayInfo });
              break label405;
            }
            ac.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.dqL) });
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            break label405;
            label2008:
            paramString = new StringBuilder("orders null?:");
            if (paramOrders == null) {}
            for (bool1 = true;; bool1 = false)
            {
              ac.w("MicroMsg.WalletPwdDialog", bool1);
              label2043:
              localObject3 = paramFavorPayInfo;
              break;
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject6).BgR, paramOrders.vxl);
              bool1 = true;
              paramFavorPayInfo = paramContext.getString(2131765742);
              break label684;
            }
            localObject1 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.daf, paramOrders.vxl);
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
            paramFavorPayInfo.tK(false);
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
    if ((paramOrders != null) && (paramOrders.BxS != null) && (paramOrders.BxS.BgW != null))
    {
      paramOrders = paramOrders.BxS.BgW.Bgr.iterator();
      while (paramOrders.hasNext())
      {
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramOrders.next();
        if (localc.vwo.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.BgC.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (com.tencent.mm.plugin.wallet.a.d)paramBankcard.next();
            if (paramOrders.BgD != 0) {
              localLinkedList.add(paramOrders.wJS);
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
    this.wfX = ???;
    this.BIl = paramBoolean;
    if (u.axL())
    {
      AppMethodBeat.o(71190);
      return;
    }
    ac.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
    synchronized (this.BIB)
    {
      ??? = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    }
    boolean bool2;
    if ((!???.cHa()) && (???.cGZ()))
    {
      this.BIA = 0;
      ac.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(this.BIA) });
      this.BIm = 0;
      this.BIh.setVisibility(8);
      this.BIi.setVisibility(8);
      this.BIp = bs.Gn();
      bool2 = p.skJ.skL;
      if ((com.tencent.mm.plugin.wallet_core.model.s.ery() == null) || (this.BIA < 0)) {
        break label1500;
      }
    }
    label266:
    label294:
    label332:
    label858:
    label1500:
    for (paramBoolean = ???.cHl();; paramBoolean = true)
    {
      Object localObject1;
      if (this.BIl)
      {
        localObject1 = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        if ((((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() != 1) || ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).cGZ()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).cHc())) || (!com.tencent.mm.plugin.soter.e.b.dTB()) || (!com.tencent.mm.plugin.soter.e.b.dTA()) || (com.tencent.soter.core.a.fDd() != 0)) {
          break label757;
        }
        ac.i("MicroMsg.WalletPwdDialog", "may treble init error");
        com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 23);
        if (((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() == 2)
        {
          if (com.tencent.soter.core.a.fDd() != 0) {
            break label858;
          }
          com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 28);
        }
        if (!paramBoolean) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 27);
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 33);
        }
      }
      int i;
      if (!bool2)
      {
        boolean bool1 = true;
        paramBoolean &= bool1;
        if (!paramBoolean) {
          p.skJ.skL = true;
        }
        ac.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (((this.wfX == null) || ((this.wfX.DGL != 100000) && (this.wfX.DGL != 100102))) && (paramBoolean)) {
          break label905;
        }
        ac.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(this.wfX.DGL) });
        if (!this.mKBLayout.isShown()) {
          this.mKBLayout.setVisibility(0);
        }
        if (this.wfX != null)
        {
          this.wfX.BIq = 0;
          this.wfX.djs = "";
          this.wfX.djt = "";
        }
        this.BIi.setVisibility(0);
        this.BIj.setVisibility(0);
        localObject1 = this.BIj;
        if ((this.wfX == null) || (this.wfX.DGL != 100102)) {
          break label877;
        }
        i = 2131765270;
        ((TextView)localObject1).setText(i);
        this.BIj.setTextColor(getContext().getResources().getColor(2131101133));
        if (paramBoolean) {
          break label884;
        }
        this.BHV.setVisibility(0);
        this.BHW.setVisibility(0);
      }
      for (;;)
      {
        if ((this.wfX != null) && (this.wfX.DGL == 100102))
        {
          g.agR().agA().set(ah.a.GFM, Boolean.TRUE);
          ???.mh(false);
          ???.mi(false);
          g.agR().agA().set(ah.a.GFK, Boolean.FALSE);
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71190);
        return;
        localObject2 = finally;
        AppMethodBeat.o(71190);
        throw localObject2;
        if ((!???.cHm()) || (!???.cHn()) || (???.cHb()) || (!???.cHc())) {
          break;
        }
        this.BIA = 1;
        break;
        label757:
        if (localObject2.type() != 2) {
          break label266;
        }
        if (com.tencent.soter.core.a.fDd() == 1)
        {
          if (!com.tencent.soter.core.a.fDf())
          {
            ac.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
            com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 24);
            break label266;
          }
          if (paramBoolean) {
            break label266;
          }
          ac.i("MicroMsg.WalletPwdDialog", "soter treble key error");
          com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 25);
          break label266;
        }
        if (paramBoolean) {
          break label266;
        }
        ac.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
        com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 26);
        break label266;
        com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 31);
        break label294;
        i = 0;
        break label332;
        label877:
        i = 2131765263;
        break label527;
        label884:
        this.BHV.setVisibility(8);
        this.BHW.setVisibility(8);
      }
      if ((this.wfX != null) && (this.wfX.DGL == 100001)) {
        this.wfX.BIq = 1;
      }
      if ((this.BIA >= 0) && (this.BIl) && (!etM()))
      {
        this.BIh.setVisibility(0);
        this.BIh.setText(getContext().getString(2131765750));
        this.BHS.setVisibility(8);
        this.mKBLayout.setVisibility(8);
        if (this.wfX != null) {
          this.wfX.BIq = 1;
        }
        if (this.BIA == 0)
        {
          this.BIk = 1;
          this.BIi.setVisibility(0);
          this.BFa.setVisibility(0);
          this.BHN.setText(2131765741);
          etv();
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(this.BIA), Boolean.valueOf(this.BIl), Boolean.valueOf(etM()) });
        this.BIh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int i = 0;
            AppMethodBeat.i(71160);
            if (s.this.BIk == 0) {
              if (s.this.BIA == 0) {
                s.b(s.this);
              }
            }
            for (;;)
            {
              if (s.this.BIk == 1)
              {
                s.etP();
                if (s.e(s.this)) {
                  s.f(s.this);
                }
              }
              AppMethodBeat.o(71160);
              return;
              s.c(s.this);
              continue;
              if (s.this.BIk == 1)
              {
                if (s.this.wfX == null) {
                  label102:
                  if (s.this.wfX != null) {
                    break label148;
                  }
                }
                label148:
                for (paramAnonymousView = "";; paramAnonymousView = s.this.wfX.dac)
                {
                  af.f(i, paramAnonymousView, 19, "");
                  s.d(s.this);
                  break;
                  i = s.this.wfX.dqL;
                  break label102;
                }
              }
              if (s.this.BIk == 2)
              {
                s.d(s.this);
                com.tencent.mm.plugin.report.service.h.wUl.f(15817, new Object[] { Integer.valueOf(4) });
              }
            }
          }
        });
        AppMethodBeat.o(71190);
        return;
        if (this.BIA == 1)
        {
          this.BIk = 2;
          this.BIy.setVisibility(0);
          this.BHN.setText(2131765740);
          continue;
          if ((this.BIA >= 0) && (this.BIl) && (etM()))
          {
            if (this.BIA == 0) {
              this.BIh.setText(getContext().getString(2131765264));
            }
            for (;;)
            {
              this.BIh.setVisibility(0);
              this.BIk = 0;
              this.BIi.setVisibility(8);
              this.BIy.setVisibility(8);
              this.BHS.setVisibility(0);
              if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
              }
              this.BHN.setText(2131765747);
              if (this.wfX != null) {
                this.wfX.BIq = 0;
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.wallet_core.ui.e.adR(8);
              break;
              this.BIh.setText(getContext().getString(2131765256));
            }
          }
          if (this.wfX != null) {
            this.wfX.BIq = 0;
          }
          this.BIh.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
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
    if (BIC.containsKey(paramString))
    {
      AppMethodBeat.o(71203);
      return false;
    }
    int j;
    if ((paramOrders.BxS != null) && (paramOrders.BxS.BgW != null)) {
      if (paramOrders.BxS.BgW.Bgr.size() > 0)
      {
        paramString = paramOrders.BxS.BgW.Bgr.iterator();
        int i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label139;
        }
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramString.next();
        if ((localc.vwo == null) || (!localc.vwo.equals(paramBankcard.field_bindSerial))) {
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
      if (paramOrders.BxS.BgW.Bgr.size() > 0)
      {
        AppMethodBeat.o(71203);
        return true;
      }
      if ((paramOrders.BxS.BgW.Bgs != null) && (paramOrders.BxS.BgW.Bgs.Bhi.size() > 0))
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
    return (paramPayInfo != null) && ((paramPayInfo.dqL == 31) || (paramPayInfo.dqL == 32) || (paramPayInfo.dqL == 33));
  }
  
  private void aZ(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(71198);
    if (this.BHP != null)
    {
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        this.BHP.setWording(paramLinkedList);
        this.BHP.setVisibility(0);
        AppMethodBeat.o(71198);
        return;
      }
      this.BHP.setVisibility(8);
    }
    AppMethodBeat.o(71198);
  }
  
  private void azN(String paramString)
  {
    AppMethodBeat.i(71187);
    if (!TextUtils.isEmpty(paramString))
    {
      this.BHY.setVisibility(0);
      this.BHY.setText(paramString);
      AppMethodBeat.o(71187);
      return;
    }
    ac.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.BHY.setVisibility(8);
    AppMethodBeat.o(71187);
  }
  
  private void etK()
  {
    AppMethodBeat.i(71177);
    if (this.BIk == 1) {
      this.BIh.setText(2131765264);
    }
    for (;;)
    {
      this.BIk = 0;
      this.BIp = bs.Gn();
      this.BIi.setVisibility(8);
      this.BIy.setVisibility(8);
      this.BHS.setVisibility(0);
      if (!this.mKBLayout.isShown()) {
        this.mKBLayout.setVisibility(0);
      }
      this.BHN.setText(2131765747);
      tJ(true);
      this.wfX.BIq = 0;
      com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.e.adR(29);
      etw();
      AppMethodBeat.o(71177);
      return;
      this.BIh.setText(2131765256);
    }
  }
  
  private static boolean etM()
  {
    AppMethodBeat.i(71209);
    g.agS();
    Object localObject = g.agR().agA().get(ah.a.GFG, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71209);
      return bool;
    }
  }
  
  private void etv()
  {
    AppMethodBeat.i(71178);
    com.tencent.mm.plugin.soter.d.a.dTo();
    final nv localnv = new nv();
    localnv.dqj.djr = this.wfX.dac;
    localnv.dqj.dql = 1;
    localnv.dqj.dqn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71168);
        ac.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        nv.b localb = localnv.dqk;
        if (localb == null)
        {
          s.this.wfX.BIq = 0;
          ac.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71168);
          return;
        }
        int j = localb.errCode;
        ac.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.errMsg });
        int i;
        if (j == 0)
        {
          ac.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dqo });
          if (s.this.wfX == null) {
            i = 0;
          }
          for (;;)
          {
            Object localObject1;
            if (s.this.wfX == null)
            {
              localObject1 = "";
              af.f(i, (String)localObject1, 22, "");
              s.this.wfX.BIq = 1;
              s.this.wfX.djs = localb.djs;
              s.this.wfX.djt = localb.djt;
            }
            try
            {
              localObject1 = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cHd());
              ((JSONObject)localObject1).put("soter_type", com.tencent.mm.plugin.wallet_core.model.s.ery().esg());
              s.this.wfX.dqo = ((JSONObject)localObject1).toString();
              s.this.wfX.djq = localb.djq;
              localObject1 = s.this.wfX;
              ((PayInfo)localObject1).BIr += 1;
              s.this.BIj.setText("");
              s.this.etL();
              com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.plugin.soter.d.a.Qj(0);
              AppMethodBeat.o(71168);
              return;
              i = s.this.wfX.dqL;
              continue;
              localObject1 = s.this.wfX.dac;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.WalletPwdDialog", localJSONException, "", new Object[0]);
              }
            }
          }
        }
        ac.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        Object localObject2;
        label434:
        int k;
        boolean bool1;
        if (s.this.wfX == null)
        {
          i = 0;
          if (s.this.wfX != null) {
            break label849;
          }
          localObject2 = "";
          af.f(i, (String)localObject2, 23, "");
          s.this.wfX.BIq = 0;
          s.this.BIi.setVisibility(0);
          s.this.BIj.setTextColor(s.this.getContext().getResources().getColor(2131100798));
          s.this.BIj.setText(2131765262);
          i = (int)(System.currentTimeMillis() / 1000L);
          k = i - s.g(s.this);
          if (k > 1)
          {
            s.a(s.this, i);
            s.h(s.this);
            localObject2 = s.this.wfX;
            ((PayInfo)localObject2).BIr += 1;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
          if ((j != 2) && (j != 10308)) {
            break label864;
          }
          bool1 = true;
          label636:
          if (localb.dqp != 2) {
            break label870;
          }
        }
        label849:
        label864:
        label870:
        for (boolean bool2 = true;; bool2 = false)
        {
          ac.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(s.i(s.this)), Integer.valueOf(j), Boolean.valueOf(bool2) });
          if (((!bool2) && ((s.i(s.this) >= 3) || (k <= 1))) || (bool1)) {
            break label876;
          }
          ac.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
          if (s.j(s.this) == null) {
            s.a(s.this, com.tencent.mm.ui.c.a.gl(s.this.getContext()));
          }
          s.this.BFa.setVisibility(8);
          s.this.BIj.setVisibility(4);
          s.j(s.this).reset();
          s.j(s.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71167);
              ac.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71165);
                  s.this.BIj.setVisibility(8);
                  s.this.BFa.setVisibility(0);
                  AppMethodBeat.o(71165);
                }
              });
              AppMethodBeat.o(71167);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71166);
              ac.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71164);
                  s.this.BIj.setVisibility(0);
                  AppMethodBeat.o(71164);
                }
              });
              AppMethodBeat.o(71166);
            }
          });
          s.this.BIj.startAnimation(s.j(s.this));
          com.tencent.mm.plugin.soter.d.a.Qj(1);
          AppMethodBeat.o(71168);
          return;
          i = s.this.wfX.dqL;
          break;
          localObject2 = s.this.wfX.dac;
          break label434;
          bool1 = false;
          break label636;
        }
        label876:
        if ((s.i(s.this) >= 3) || (bool1))
        {
          ac.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
          s.etP();
          s.this.BIk = 0;
          s.k(s.this);
          s.this.BIh.setVisibility(8);
          s.this.BIi.setVisibility(8);
          s.this.BIj.setVisibility(0);
          s.this.BIj.setText(2131765263);
          s.this.BIj.setTextColor(s.this.getContext().getResources().getColor(2131101133));
          s.this.BHN.setText(2131765747);
          s.this.BHS.setVisibility(0);
          if (!s.this.mKBLayout.isShown()) {
            s.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.Qj(2);
          s.tN(true);
        }
        AppMethodBeat.o(71168);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l(localnv);
    AppMethodBeat.o(71178);
  }
  
  private static void etw()
  {
    AppMethodBeat.i(71179);
    ac.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(71179);
  }
  
  private void h(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71191);
    if (paramBankcard == null)
    {
      ac.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eqR())
    {
      this.BHQ.setImageResource(2131234612);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eqS())
    {
      this.Bfa.a(paramBankcard, this.BHQ);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eqV())
    {
      this.BHQ.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      if (!bs.isNullOrNil(paramBankcard.BuH))
      {
        this.BHQ.setUseSdcardCache(true);
        this.BHQ.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.esU());
        this.BHQ.fE(paramBankcard.BuH, 2131690298);
        AppMethodBeat.o(71191);
      }
    }
    else
    {
      this.Bfa.a(getContext(), paramBankcard, this.BHQ);
    }
    AppMethodBeat.o(71191);
  }
  
  private static void tJ(boolean paramBoolean)
  {
    AppMethodBeat.i(71208);
    g.agS();
    g.agR().agA().set(ah.a.GFG, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71208);
  }
  
  private void tK(boolean paramBoolean)
  {
    AppMethodBeat.i(71180);
    View localView = this.ijA.findViewById(2131297117);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.BIs = true;
        AppMethodBeat.o(71180);
        return;
      }
      localView.setVisibility(8);
      this.BIs = false;
    }
    AppMethodBeat.o(71180);
  }
  
  private void tL(boolean paramBoolean)
  {
    AppMethodBeat.i(71193);
    if (!paramBoolean)
    {
      this.BHV.setVisibility(8);
      this.BHW.setVisibility(8);
      AppMethodBeat.o(71193);
      return;
    }
    this.BHV.setVisibility(0);
    this.BHW.setVisibility(0);
    AppMethodBeat.o(71193);
  }
  
  public final void a(final Context paramContext, final Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71194);
    this.Bjk = e.BBL.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.BxS != null) && (paramOrders.BxS.BgM != null) && (paramOrders.BxS.BgM.size() > 0) && (this.Bjk != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.Bix = this.Bjk.azH(paramOrders.BxS.BgL);; this.Bix = paramFavorPayInfo)
      {
        this.BHR.setVisibility(0);
        if (this.BHV != null) {
          this.BHV.setTag(this.Bix);
        }
        this.BIg = paramBankcard;
        this.BIa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71170);
            s.this.BHX.setVisibility(8);
            int i;
            if (s.this.wfX == null)
            {
              i = 0;
              if (s.this.wfX != null) {
                break label102;
              }
            }
            label102:
            for (paramAnonymousView = "";; paramAnonymousView = s.this.wfX.dac)
            {
              af.f(i, paramAnonymousView, 12, "");
              n.a(paramContext, paramOrders, s.this.Bix.Bwv, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  Object localObject2 = null;
                  AppMethodBeat.i(71169);
                  s.this.Bix = paramAnonymous2FavorPayInfo;
                  int i;
                  if (s.this.wfX == null)
                  {
                    i = 0;
                    if (s.this.wfX != null) {
                      break label294;
                    }
                    paramAnonymous2FavorPayInfo = "";
                    label51:
                    af.f(i, paramAnonymous2FavorPayInfo, 15, s.this.Bix.Bwv);
                    s.this.BIe = false;
                    paramAnonymous2FavorPayInfo = d.ci(s.this.Bix.Bww, s.this.Bix.Bwx);
                    s.this.Bix.Bwz = "";
                    if (!d.a(s.this.Bix, s.this.BIg)) {
                      break label339;
                    }
                    s.this.BIe = true;
                    if (paramAnonymous2FavorPayInfo.size() != 0) {
                      break label311;
                    }
                  }
                  label294:
                  label311:
                  for (s.this.Bix.Bwz = s.9.this.val$context.getString(2131765258);; s.this.Bix.Bwz = s.9.this.val$context.getString(2131765259))
                  {
                    s.this.dismiss();
                    if (s.this.BIx == null) {
                      break label339;
                    }
                    s.this.BIx.a(s.this.BHS.getText(), s.this.Bix, s.this.BIe);
                    AppMethodBeat.o(71169);
                    return;
                    i = s.this.wfX.dqL;
                    break;
                    paramAnonymous2FavorPayInfo = s.this.wfX.dac;
                    break label51;
                  }
                  label339:
                  if (s.this.BHV != null) {
                    s.this.BHV.setTag(s.this.Bix);
                  }
                  Object localObject1 = s.this.Bjk.azE(s.this.Bix.Bwv);
                  double d;
                  String str1;
                  String str3;
                  String str2;
                  String str4;
                  if ((localObject1 != null) && (((j)localObject1).BgS > 0.0D))
                  {
                    d = ((j)localObject1).BgK;
                    str1 = com.tencent.mm.wallet_core.ui.e.D(((j)localObject1).BgR);
                    str3 = com.tencent.mm.wallet_core.ui.e.D(s.9.this.BII.BxS.BgI);
                    str2 = ((j)localObject1).BgU;
                    paramAnonymous2FavorPayInfo = null;
                    if ((localObject1 == null) || (((j)localObject1).BgT == 0)) {
                      break label657;
                    }
                    str4 = ((j)localObject1).BgV;
                    localObject1 = str4;
                    if (bs.isNullOrNil(str2)) {}
                  }
                  label657:
                  for (localObject1 = ",".concat(String.valueOf(str4));; localObject1 = null)
                  {
                    if ((!bs.isNullOrNil(str2)) || (!bs.isNullOrNil((String)localObject1))) {
                      if (bs.isNullOrNil(paramAnonymous2FavorPayInfo)) {
                        paramAnonymous2FavorPayInfo = localObject2;
                      }
                    }
                    for (;;)
                    {
                      s.this.d(str1, d);
                      s.this.azO(str3);
                      s.this.kb(str2, paramAnonymous2FavorPayInfo);
                      s.this.azP((String)localObject1);
                      AppMethodBeat.o(71169);
                      return;
                      d = s.9.this.BII.BxS.BgI;
                      str1 = com.tencent.mm.wallet_core.ui.e.D(s.9.this.BII.BxS.BgI);
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
              i = s.this.wfX.dqL;
              break;
            }
          }
        });
        Assert.assertNotNull(this.Bjk);
        this.BHX.setVisibility(8);
        AppMethodBeat.o(71194);
        return;
      }
    }
    this.BHR.setVisibility(8);
    AppMethodBeat.o(71194);
  }
  
  public final void a(a parama)
  {
    this.BIz = parama;
  }
  
  public final void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(71192);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.BHV.setOnClickListener(paramOnClickListener);
      this.BHO.setText(paramCharSequence);
      tL(this.BIf);
      if (!paramBoolean)
      {
        this.BHU.setVisibility(8);
        AppMethodBeat.o(71192);
        return;
      }
      this.BHU.setVisibility(0);
      AppMethodBeat.o(71192);
      return;
    }
    this.BHV.setVisibility(8);
    this.BHW.setVisibility(8);
    AppMethodBeat.o(71192);
  }
  
  protected void aM(Context paramContext)
  {
    AppMethodBeat.i(71174);
    ac.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    gI(paramContext);
    gJ(paramContext);
    AppMethodBeat.o(71174);
  }
  
  public final void azM(String paramString)
  {
    AppMethodBeat.i(71185);
    this.xcu.setText(paramString);
    AppMethodBeat.o(71185);
  }
  
  public final void azO(String paramString)
  {
    AppMethodBeat.i(71189);
    if (!TextUtils.isEmpty(paramString))
    {
      this.Bjv.setVisibility(0);
      this.Bjv.setText(paramString);
      AppMethodBeat.o(71189);
      return;
    }
    this.Bjv.setVisibility(8);
    AppMethodBeat.o(71189);
  }
  
  public final void azP(String paramString)
  {
    AppMethodBeat.i(71199);
    if (!bs.isNullOrNil(paramString))
    {
      this.BHZ.setText(paramString);
      this.BHZ.setVisibility(0);
      AppMethodBeat.o(71199);
      return;
    }
    this.BHZ.setVisibility(8);
    AppMethodBeat.o(71199);
  }
  
  public final void b(final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71196);
    if (this.uvu == null)
    {
      AppMethodBeat.o(71196);
      return;
    }
    this.VW = paramOnCancelListener;
    this.uvu.setVisibility(0);
    this.uvu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71171);
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(null);
        }
        if (s.this.BIz != null) {
          s.this.BIz.dmo();
        }
        s.this.cancel();
        if (s.this.BIh.isShown())
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(71171);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71171);
      }
    });
    AppMethodBeat.o(71196);
  }
  
  public int coN()
  {
    return 2131495963;
  }
  
  public final void d(String paramString, double paramDouble)
  {
    AppMethodBeat.i(71186);
    if (!TextUtils.isEmpty(paramString))
    {
      this.wQs.setVisibility(0);
      this.wQs.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.BIf = false;
        tL(this.BIf);
        AppMethodBeat.o(71186);
        return;
      }
      tL(this.BIf);
      AppMethodBeat.o(71186);
      return;
    }
    this.wQs.setVisibility(8);
    this.BIf = true;
    tL(this.BIf);
    AppMethodBeat.o(71186);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(71184);
    try
    {
      super.dismiss();
      etw();
      this.Bfa.destory();
      if (this.slo != null) {
        this.slo.cancel();
      }
      AppMethodBeat.o(71184);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  protected void etL()
  {
    AppMethodBeat.i(71195);
    tJ(false);
    if (this.BId != null) {
      this.BId.onClick(this, 0);
    }
    dismiss();
    if (this.BIx != null) {
      this.BIx.a(this.BHS.getText(), this.Bix, this.BIe);
    }
    if (this.BIp < 0L)
    {
      ac.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71195);
      return;
    }
    if (this.BIk == 0)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(686L, 1L, bs.aO(this.BIp), false);
      AppMethodBeat.o(71195);
      return;
    }
    if (this.BIk == 1)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(686L, 3L, bs.aO(this.BIp), false);
    }
    AppMethodBeat.o(71195);
  }
  
  public final void eth()
  {
    AppMethodBeat.i(71206);
    this.isPaused = false;
    if (u.axL())
    {
      AppMethodBeat.o(71206);
      return;
    }
    AppMethodBeat.o(71206);
  }
  
  protected final void gI(Context paramContext)
  {
    AppMethodBeat.i(71175);
    this.ijA = View.inflate(paramContext, coN(), null);
    this.uvu = ((ImageView)this.ijA.findViewById(2131306819));
    this.mKeyboard = ((MyKeyboardWindow)this.ijA.findViewById(2131305695));
    this.mKBLayout = this.ijA.findViewById(2131305693);
    this.xcu = ((TextView)this.ijA.findViewById(2131298739));
    this.BHN = ((TextView)this.ijA.findViewById(2131306826));
    this.wQs = ((TextView)this.ijA.findViewById(2131299872));
    this.Bjv = ((TextView)this.ijA.findViewById(2131303087));
    this.Bjv.getPaint().setFlags(16);
    this.BHO = ((TextView)this.ijA.findViewById(2131297176));
    this.BHP = ((FavourLayout)this.ijA.findViewById(2131299869));
    this.BHQ = ((CdnImageView)this.ijA.findViewById(2131297165));
    this.BHU = this.ijA.findViewById(2131299861);
    this.BHR = ((TextView)this.ijA.findViewById(2131302467));
    this.iKw = ((ImageView)this.ijA.findViewById(2131298184));
    this.BHV = this.ijA.findViewById(2131297163);
    this.BHW = ((TextView)this.ijA.findViewById(2131304595));
    a.b.c(this.iKw, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.BHS = ((EditHintPasswdView)this.ijA.findViewById(2131301026));
    this.BHX = ((ImageView)this.ijA.findViewById(2131300682));
    this.BIh = ((TextView)this.ijA.findViewById(2131306814));
    this.BIi = this.ijA.findViewById(2131300088);
    this.BIj = ((TextView)this.ijA.findViewById(2131300091));
    this.BFa = ((ImageView)this.ijA.findViewById(2131300087));
    this.BHY = ((TextView)this.ijA.findViewById(2131297953));
    this.BHZ = ((TextView)this.ijA.findViewById(2131303711));
    this.BIa = this.ijA.findViewById(2131299859);
    this.BIb = ((TextView)this.ijA.findViewById(2131299868));
    this.BIy = ((Button)this.ijA.findViewById(2131299685));
    this.BHP.setVisibility(8);
    AppMethodBeat.o(71175);
  }
  
  @TargetApi(14)
  protected void gJ(Context paramContext)
  {
    AppMethodBeat.i(71176);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    com.tencent.mm.wallet_core.ui.formview.a.a(this.BHS);
    this.BHS.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71155);
        if (paramAnonymousBoolean)
        {
          s.this.etL();
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71155);
      }
    });
    this.BHS.requestFocus();
    Object localObject = (TextView)this.ijA.findViewById(2131306826);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kB(paramContext));
    }
    paramContext = (EditText)this.ijA.findViewById(2131306718);
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
    this.ijA.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
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
    this.BIy.setOnClickListener(new View.OnClickListener()
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
  
  public final void kb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71188);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.BHR.setVisibility(0);
      this.BHR.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.BIb.setText(paramString1);
      this.BIb.setVisibility(0);
      AppMethodBeat.o(71188);
      return;
      this.BHR.setVisibility(8);
    }
    this.BIb.setVisibility(8);
    AppMethodBeat.o(71188);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71207);
    this.isPaused = true;
    if (u.axL())
    {
      AppMethodBeat.o(71207);
      return;
    }
    if (this.BIk == 1) {
      etK();
    }
    AppMethodBeat.o(71207);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71182);
    super.onCreate(paramBundle);
    setContentView(this.ijA);
    com.tencent.soter.a.g.f.fDM().fDN();
    AppMethodBeat.o(71182);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71181);
    if (paramInt == 4)
    {
      if (this.VW != null) {
        this.VW.onCancel(this);
      }
      if (this.BIz != null) {
        this.BIz.dmo();
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
    this.mz = paramBoolean;
    setCanceledOnTouchOutside(this.mz);
    AppMethodBeat.o(71183);
  }
  
  public final void tM(boolean paramBoolean)
  {
    AppMethodBeat.i(71197);
    if (paramBoolean)
    {
      this.BHV.setVisibility(0);
      AppMethodBeat.o(71197);
      return;
    }
    this.BHV.setVisibility(8);
    AppMethodBeat.o(71197);
  }
  
  public static abstract interface a
  {
    public abstract void dmo();
  }
  
  static final class b
    implements DialogInterface.OnCancelListener
  {
    private DialogInterface.OnCancelListener BIK = null;
    
    private b(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.BIK = paramOnCancelListener;
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(71172);
      s.tN(false);
      if (this.BIK != null) {
        this.BIK.onCancel(paramDialogInterface);
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