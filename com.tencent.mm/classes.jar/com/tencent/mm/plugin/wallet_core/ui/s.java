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
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.oe.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.al;
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
  private static HashMap<String, Boolean> DAy;
  protected com.tencent.mm.plugin.wallet_core.utils.a CWV;
  protected boolean DAa;
  protected boolean DAb;
  public Bankcard DAc;
  public TextView DAd;
  public View DAe;
  public TextView DAf;
  protected int DAg;
  protected boolean DAh;
  private int DAi;
  private Animation DAj;
  private String DAk;
  private long DAl;
  boolean DAo;
  public c DAt;
  public Button DAu;
  protected a DAv;
  protected int DAw;
  private byte[] DAx;
  protected FavorPayInfo Dar;
  protected d Dbe;
  public TextView Dbp;
  public ImageView DwW;
  public TextView DzJ;
  public TextView DzK;
  public FavourLayout DzL;
  public CdnImageView DzM;
  public TextView DzN;
  public EditHintPasswdView DzO;
  public View DzQ;
  public View DzR;
  public TextView DzS;
  public ImageView DzT;
  public TextView DzU;
  public TextView DzV;
  public View DzW;
  public TextView DzX;
  protected DialogInterface.OnClickListener DzZ;
  protected DialogInterface.OnCancelListener XL;
  public View iFK;
  private boolean isPaused;
  public ImageView jgy;
  private Context mContext;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected boolean ov;
  private Animation tsJ;
  private int tst;
  public ImageView vKb;
  protected PayInfo xDC;
  public TextView yGw;
  public TextView ytR;
  
  static
  {
    AppMethodBeat.i(71219);
    DAy = new HashMap();
    AppMethodBeat.o(71219);
  }
  
  public s(Context paramContext)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(71173);
    this.Dbe = null;
    this.Dar = new FavorPayInfo();
    this.DAa = false;
    this.DAb = true;
    this.DAc = null;
    this.CWV = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.DAg = 0;
    this.DAw = -1;
    this.DAh = false;
    this.DAi = 0;
    this.tst = 0;
    this.DAj = null;
    this.DAk = "";
    this.DAl = -1L;
    this.DAx = new byte[0];
    this.DAo = false;
    this.isPaused = false;
    aN(paramContext);
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
    locals.aGq(paramString1);
    locals.d(com.tencent.mm.wallet_core.ui.f.d(paramDouble, paramString2), paramDouble);
    locals.DAb = true;
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
      locals.uE(bool);
      if (paramBankcard != null) {
        locals.a(paramString1, paramOnClickListener, false);
      }
      locals.DAt = paramc;
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
    locals.aGq(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      locals.ytR.setVisibility(0);
      locals.ytR.setText(paramString2);
    }
    for (;;)
    {
      locals.DAb = true;
      locals.uD(locals.DAb);
      locals.uE(false);
      locals.DAb = false;
      locals.DAv = parama;
      locals.aGr("");
      locals.DAt = paramc;
      locals.show();
      com.tencent.mm.ui.base.h.a(paramContext, locals);
      AppMethodBeat.o(71204);
      return locals;
      locals.ytR.setVisibility(8);
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
    if ((paramOrders == null) || (paramOrders.DpP == null) || (paramOrders.DpP.size() <= 0))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    d locald = e.DtH.a(paramOrders);
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
      ae.i("MicroMsg.WalletPwdDialog", "showAlert with favInfo %s bindSerial %s  bankcardType %s", new Object[] { localObject1, localObject2, localObject3 });
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
      ae.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.Doq, Boolean.valueOf(bool1) });
      String str1 = locald.cn(paramFavorPayInfo.Doq, bool1);
      ae.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str1 });
      localObject2 = locald.aGg(str1);
      localObject1 = locald.cm(str1, true);
      Object localObject4 = (d.a)((Map)localObject2).get(paramBankcard.field_bindSerial);
      Object localObject5 = (d.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
      Object localObject6 = locald.cl(str1, bool1);
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
        ae.i("MicroMsg.WalletPwdDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((localObject4 == null) || (((d.a)localObject4).DtF == null) || (bu.isNullOrNil(((d.a)localObject4).DtF.CYV))) {
          break label1170;
        }
        paramFavorPayInfo.Doq = ((d.a)localObject4).DtF.CYV;
        localObject1 = locald.eKU();
        localObject5 = paramFavorPayInfo;
        localObject2 = "";
        if (paramPayInfo.hwN != null) {
          break label1284;
        }
        paramFavorPayInfo = "";
        if (bu.isNullOrNil(paramFavorPayInfo)) {
          break label1301;
        }
        if ((!bu.isNullOrNil(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.DpP == null)) {
          break label2008;
        }
        localObject2 = (Orders.Commodity)paramOrders.DpP.get(0);
        if (localObject2 == null) {
          break label2043;
        }
        paramString = ((Orders.Commodity)localObject2).wSf;
        paramFavorPayInfo = paramString;
        if (a(paramPayInfo))
        {
          paramFavorPayInfo = paramString;
          if (!bu.isNullOrNil(paramString)) {
            paramFavorPayInfo = paramString + "\n";
          }
          paramFavorPayInfo = paramFavorPayInfo + ((Orders.Commodity)localObject2).desc;
        }
        localObject3 = paramFavorPayInfo;
        if (bu.isNullOrNil(paramFavorPayInfo)) {
          localObject3 = ((Orders.Commodity)localObject2).desc;
        }
        localObject8 = null;
        localObject7 = null;
        localObject4 = null;
        str2 = null;
        str1 = null;
        localObject6 = null;
        paramString = null;
        d1 = paramOrders.dmz;
        bool2 = false;
        bool1 = false;
        if ((locald == null) || (localObject5 == null)) {
          break label2188;
        }
        localObject6 = locald.aGi(((FavorPayInfo)localObject5).Doq);
        if ((localObject6 == null) || (((j)localObject6).CYM <= 0.0D)) {
          break label2055;
        }
        bool1 = true;
        localObject4 = com.tencent.mm.wallet_core.ui.f.d(paramOrders.dmz, paramOrders.wSq);
        localObject1 = com.tencent.mm.wallet_core.ui.f.d(((j)localObject6).CYL, paramOrders.wSq);
        d1 = ((j)localObject6).CYE;
        str1 = ((j)localObject6).CYO;
        if (DAy.containsKey(paramPayInfo.dmw)) {
          break label2183;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14530, new Object[] { Integer.valueOf(3) });
        paramFavorPayInfo = null;
        localObject2 = paramString;
        if (localObject6 != null)
        {
          localObject2 = paramString;
          if (((j)localObject6).CYN != 0)
          {
            paramString = ((j)localObject6).CYP;
            localObject2 = paramString;
            if (!bu.isNullOrNil(str1)) {
              localObject2 = ",".concat(String.valueOf(paramString));
            }
          }
        }
        if (bu.isNullOrNil(str1))
        {
          localObject6 = localObject2;
          paramString = paramFavorPayInfo;
          d2 = d1;
          str2 = str1;
          localObject7 = localObject4;
          localObject8 = localObject1;
          bool2 = bool1;
          if (bu.isNullOrNil((String)localObject2)) {}
        }
        else
        {
          if (!bu.isNullOrNil(paramFavorPayInfo)) {
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
        if (paramOrders.yoj > 0.0D) {}
        for (localObject1 = paramContext.getResources().getString(2131765188, new Object[] { com.tencent.mm.wallet_core.ui.f.d(paramOrders.yoj, paramOrders.wSq) });; localObject1 = null)
        {
          if (paramBankcard == null)
          {
            paramFavorPayInfo = "";
            label861:
            localObject2 = paramFavorPayInfo;
            if (paramBankcard != null)
            {
              localObject2 = paramFavorPayInfo;
              if (paramBankcard.eIC()) {
                localObject2 = k.c(paramContext, paramFavorPayInfo);
              }
            }
            paramFavorPayInfo = new s(paramContext);
            paramFavorPayInfo.a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
            paramFavorPayInfo.uE(paramBoolean);
            paramFavorPayInfo.DAb = paramBoolean;
            paramFavorPayInfo.b(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setOnCancelListener(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setCancelable(true);
            paramFavorPayInfo.aGq((String)localObject3);
            paramFavorPayInfo.d(localObject8, d2);
            paramFavorPayInfo.aGs(localObject7);
            paramFavorPayInfo.a((CharSequence)localObject2, new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(71156);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                s.cYy().put(this.wPf.dmw, Boolean.TRUE);
                paramOnClickListener.onClick(paramAnonymousView);
                if (paramFavorPayInfo.DAo) {
                  com.tencent.mm.plugin.report.service.g.yxI.f(14530, new Object[] { Integer.valueOf(2) });
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71156);
              }
            }, bool2);
            paramFavorPayInfo.h(paramBankcard);
            if (paramOrders.DpM != 1) {
              break label2164;
            }
            paramBoolean = true;
            label1005:
            paramFavorPayInfo.a(paramPayInfo, paramBoolean);
            paramFavorPayInfo.kC(str2, paramString);
            paramFavorPayInfo.aGt((String)localObject6);
            paramFavorPayInfo.aGr((String)localObject1);
            paramFavorPayInfo.DAt = paramc;
            paramFavorPayInfo.bb(a(paramBankcard, paramOrders));
            if (!a(paramBankcard, paramOrders, paramPayInfo.dmw)) {
              break label2169;
            }
            paramFavorPayInfo.uC(true);
            com.tencent.mm.plugin.report.service.g.yxI.f(14530, new Object[] { Integer.valueOf(1) });
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
            localObject1 = ((j)localObject6).CYV;
            break label288;
            label1150:
            localObject2 = ((d.a)localObject4).toString();
            break label297;
            localObject3 = ((d.a)localObject5).toString();
            break label306;
            if ((localObject5 != null) && (((d.a)localObject5).DtF != null) && (!bu.isNullOrNil(((d.a)localObject5).DtF.CYV)))
            {
              paramFavorPayInfo.Doq = ((d.a)localObject5).DtF.CYV;
              break label373;
            }
            if (localObject6 != null)
            {
              paramFavorPayInfo.Doq = ((j)localObject6).CYV;
              break label373;
            }
            paramFavorPayInfo.Doq = str1;
            break label373;
            label1238:
            if (paramOrders.DpQ == null) {
              break label373;
            }
            paramFavorPayInfo = locald.aGl(locald.aGm(paramOrders.DpQ.CYF));
            break label373;
            label1266:
            ae.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            localObject1 = null;
            localObject5 = paramFavorPayInfo;
            break label383;
            paramFavorPayInfo = paramPayInfo.hwN.getString("extinfo_key_19", "");
            break label398;
            if ((paramPayInfo.dDH == 32) || (paramPayInfo.dDH == 33))
            {
              str1 = paramPayInfo.hwN.getString("extinfo_key_5", "");
              localObject4 = paramPayInfo.hwN.getString("extinfo_key_1", "");
              localObject3 = paramContext.getString(2131765746);
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (!bu.isNullOrNil(str1))
              {
                localObject3 = str1;
                paramFavorPayInfo = str1;
              }
              if (!bu.isNullOrNil((String)localObject4))
              {
                com.tencent.mm.kernel.g.ajS();
                localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK((String)localObject4);
                if (localObject2 != null)
                {
                  paramFavorPayInfo = ((com.tencent.mm.storage.an)localObject2).adG();
                  localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bar(paramFavorPayInfo));
                  if (bu.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = bu.x((String)localObject3, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ae.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(localObject4)));
                break label405;
              }
              ae.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              break label405;
            }
            if (paramPayInfo.dDH == 31)
            {
              paramFavorPayInfo = paramPayInfo.hwN.getString("extinfo_key_1", "");
              if (!bu.isNullOrNil(paramFavorPayInfo))
              {
                com.tencent.mm.kernel.g.ajS();
                localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((com.tencent.mm.storage.an)localObject3).adF();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (bu.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131765746, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ae.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              ae.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.dDH == 42)
            {
              paramFavorPayInfo = paramPayInfo.hwN.getString("extinfo_key_1", "");
              if (!bu.isNullOrNil(paramFavorPayInfo))
              {
                com.tencent.mm.kernel.g.ajS();
                localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((com.tencent.mm.storage.an)localObject3).adF();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (bu.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131765739, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                ae.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              ae.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.dDH == 48)
            {
              paramFavorPayInfo = paramContext.getString(2131762090);
              break label405;
            }
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            if (paramPayInfo.dDH != 49) {
              break label405;
            }
            paramFavorPayInfo = paramPayInfo.hwN.getString("extinfo_key_1", "");
            if (!bu.isNullOrNil(paramFavorPayInfo))
            {
              paramFavorPayInfo = paramContext.getString(2131765746, new Object[] { paramFavorPayInfo });
              break label405;
            }
            ae.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.dDH) });
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            break label405;
            label2008:
            paramString = new StringBuilder("orders null?:");
            if (paramOrders == null) {}
            for (bool1 = true;; bool1 = false)
            {
              ae.w("MicroMsg.WalletPwdDialog", bool1);
              label2043:
              localObject3 = paramFavorPayInfo;
              break;
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = com.tencent.mm.wallet_core.ui.f.d(((j)localObject6).CYL, paramOrders.wSq);
              bool1 = true;
              paramFavorPayInfo = paramContext.getString(2131765742);
              break label684;
            }
            localObject1 = com.tencent.mm.wallet_core.ui.f.d(paramOrders.dmz, paramOrders.wSq);
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
            paramFavorPayInfo.uC(false);
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
    if ((paramOrders != null) && (paramOrders.DpQ != null) && (paramOrders.DpQ.CYQ != null))
    {
      paramOrders = paramOrders.DpQ.CYQ.CYl.iterator();
      while (paramOrders.hasNext())
      {
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramOrders.next();
        if (localc.wRt.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.CYw.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (com.tencent.mm.plugin.wallet.a.d)paramBankcard.next();
            if (paramOrders.CYx != 0) {
              localLinkedList.add(paramOrders.ynr);
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
    this.xDC = ???;
    this.DAh = paramBoolean;
    if (v.aAR())
    {
      AppMethodBeat.o(71190);
      return;
    }
    ae.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
    synchronized (this.DAx)
    {
      ??? = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    }
    boolean bool2;
    if ((!???.cRU()) && (???.cRT()))
    {
      this.DAw = 0;
      ae.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(this.DAw) });
      this.DAi = 0;
      this.DAd.setVisibility(8);
      this.DAe.setVisibility(8);
      this.DAl = bu.HQ();
      bool2 = p.tse.tsg;
      if ((t.eJf() == null) || (this.DAw < 0)) {
        break label1500;
      }
    }
    label266:
    label294:
    label332:
    label858:
    label1500:
    for (paramBoolean = ???.cSf();; paramBoolean = true)
    {
      Object localObject1;
      if (this.DAh)
      {
        localObject1 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
        if ((((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() != 1) || ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).cRT()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).cRW())) || (!com.tencent.mm.plugin.soter.e.b.ejx()) || (!com.tencent.mm.plugin.soter.e.b.ejw()) || (com.tencent.soter.core.a.fYU() != 0)) {
          break label757;
        }
        ae.i("MicroMsg.WalletPwdDialog", "may treble init error");
        com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 23);
        if (((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() == 2)
        {
          if (com.tencent.soter.core.a.fYU() != 0) {
            break label858;
          }
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 28);
        }
        if (!paramBoolean) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 27);
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 33);
        }
      }
      int i;
      if (!bool2)
      {
        boolean bool1 = true;
        paramBoolean &= bool1;
        if (!paramBoolean) {
          p.tse.tsg = true;
        }
        ae.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (((this.xDC == null) || ((this.xDC.FEq != 100000) && (this.xDC.FEq != 100102))) && (paramBoolean)) {
          break label905;
        }
        ae.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(this.xDC.FEq) });
        if (!this.mKBLayout.isShown()) {
          this.mKBLayout.setVisibility(0);
        }
        if (this.xDC != null)
        {
          this.xDC.DAm = 0;
          this.xDC.dwk = "";
          this.xDC.dwl = "";
        }
        this.DAe.setVisibility(0);
        this.DAf.setVisibility(0);
        localObject1 = this.DAf;
        if ((this.xDC == null) || (this.xDC.FEq != 100102)) {
          break label877;
        }
        i = 2131765270;
        ((TextView)localObject1).setText(i);
        this.DAf.setTextColor(getContext().getResources().getColor(2131101133));
        if (paramBoolean) {
          break label884;
        }
        this.DzR.setVisibility(0);
        this.DzS.setVisibility(0);
      }
      for (;;)
      {
        if ((this.xDC != null) && (this.xDC.FEq == 100102))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMA, Boolean.TRUE);
          ???.mC(false);
          ???.mD(false);
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMy, Boolean.FALSE);
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71190);
        return;
        localObject2 = finally;
        AppMethodBeat.o(71190);
        throw localObject2;
        if ((!???.cSg()) || (!???.cSh()) || (???.cRV()) || (!???.cRW())) {
          break;
        }
        this.DAw = 1;
        break;
        label757:
        if (localObject2.type() != 2) {
          break label266;
        }
        if (com.tencent.soter.core.a.fYU() == 1)
        {
          if (!com.tencent.soter.core.a.fYW())
          {
            ae.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
            com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 24);
            break label266;
          }
          if (paramBoolean) {
            break label266;
          }
          ae.i("MicroMsg.WalletPwdDialog", "soter treble key error");
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 25);
          break label266;
        }
        if (paramBoolean) {
          break label266;
        }
        ae.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
        com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 26);
        break label266;
        com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 31);
        break label294;
        i = 0;
        break label332;
        label877:
        i = 2131765263;
        break label527;
        label884:
        this.DzR.setVisibility(8);
        this.DzS.setVisibility(8);
      }
      if ((this.xDC != null) && (this.xDC.FEq == 100001)) {
        this.xDC.DAm = 1;
      }
      if ((this.DAw >= 0) && (this.DAh) && (!eLA()))
      {
        this.DAd.setVisibility(0);
        this.DAd.setText(getContext().getString(2131765750));
        this.DzO.setVisibility(8);
        this.mKBLayout.setVisibility(8);
        if (this.xDC != null) {
          this.xDC.DAm = 1;
        }
        if (this.DAw == 0)
        {
          this.DAg = 1;
          this.DAe.setVisibility(0);
          this.DwW.setVisibility(0);
          this.DzJ.setText(2131765741);
          eLj();
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(this.DAw), Boolean.valueOf(this.DAh), Boolean.valueOf(eLA()) });
        this.DAd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71160);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (s.this.DAg == 0) {
              if (s.this.DAw == 0) {
                s.b(s.this);
              }
            }
            for (;;)
            {
              if (s.this.DAg == 1)
              {
                s.eLD();
                if (s.e(s.this)) {
                  s.f(s.this);
                }
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71160);
              return;
              s.c(s.this);
              continue;
              if (s.this.DAg == 1)
              {
                int i;
                if (s.this.xDC == null)
                {
                  i = 0;
                  label143:
                  if (s.this.xDC != null) {
                    break label189;
                  }
                }
                label189:
                for (paramAnonymousView = "";; paramAnonymousView = s.this.xDC.dmw)
                {
                  af.f(i, paramAnonymousView, 19, "");
                  s.d(s.this);
                  break;
                  i = s.this.xDC.dDH;
                  break label143;
                }
              }
              if (s.this.DAg == 2)
              {
                s.d(s.this);
                com.tencent.mm.plugin.report.service.g.yxI.f(15817, new Object[] { Integer.valueOf(4) });
              }
            }
          }
        });
        AppMethodBeat.o(71190);
        return;
        if (this.DAw == 1)
        {
          this.DAg = 2;
          this.DAu.setVisibility(0);
          this.DzJ.setText(2131765740);
          continue;
          if ((this.DAw >= 0) && (this.DAh) && (eLA()))
          {
            if (this.DAw == 0) {
              this.DAd.setText(getContext().getString(2131765264));
            }
            for (;;)
            {
              this.DAd.setVisibility(0);
              this.DAg = 0;
              this.DAe.setVisibility(8);
              this.DAu.setVisibility(8);
              this.DzO.setVisibility(0);
              if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
              }
              this.DzJ.setText(2131765747);
              if (this.xDC != null) {
                this.xDC.DAm = 0;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.wallet_core.ui.f.aha(8);
              break;
              this.DAd.setText(getContext().getString(2131765256));
            }
          }
          if (this.xDC != null) {
            this.xDC.DAm = 0;
          }
          this.DAd.setVisibility(8);
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
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
    if (DAy.containsKey(paramString))
    {
      AppMethodBeat.o(71203);
      return false;
    }
    int j;
    if ((paramOrders.DpQ != null) && (paramOrders.DpQ.CYQ != null)) {
      if (paramOrders.DpQ.CYQ.CYl.size() > 0)
      {
        paramString = paramOrders.DpQ.CYQ.CYl.iterator();
        int i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label139;
        }
        com.tencent.mm.plugin.wallet.a.c localc = (com.tencent.mm.plugin.wallet.a.c)paramString.next();
        if ((localc.wRt == null) || (!localc.wRt.equals(paramBankcard.field_bindSerial))) {
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
      if (paramOrders.DpQ.CYQ.CYl.size() > 0)
      {
        AppMethodBeat.o(71203);
        return true;
      }
      if ((paramOrders.DpQ.CYQ.CYm != null) && (paramOrders.DpQ.CYQ.CYm.CZc.size() > 0))
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
    return (paramPayInfo != null) && ((paramPayInfo.dDH == 31) || (paramPayInfo.dDH == 32) || (paramPayInfo.dDH == 33));
  }
  
  private void aGr(String paramString)
  {
    AppMethodBeat.i(71187);
    if (!TextUtils.isEmpty(paramString))
    {
      this.DzU.setVisibility(0);
      this.DzU.setText(paramString);
      AppMethodBeat.o(71187);
      return;
    }
    ae.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.DzU.setVisibility(8);
    AppMethodBeat.o(71187);
  }
  
  private void bb(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(71198);
    if (this.DzL != null)
    {
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        this.DzL.setWording(paramLinkedList);
        this.DzL.setVisibility(0);
        AppMethodBeat.o(71198);
        return;
      }
      this.DzL.setVisibility(8);
    }
    AppMethodBeat.o(71198);
  }
  
  private static boolean eLA()
  {
    AppMethodBeat.i(71209);
    com.tencent.mm.kernel.g.ajS();
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMu, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71209);
      return bool;
    }
  }
  
  private void eLj()
  {
    AppMethodBeat.i(71178);
    com.tencent.mm.plugin.soter.d.a.ejk();
    final oe localoe = new oe();
    localoe.dDb.dwj = this.xDC.dmw;
    localoe.dDb.dDd = 1;
    localoe.dDb.dDf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71168);
        ae.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        oe.b localb = localoe.dDc;
        if (localb == null)
        {
          s.this.xDC.DAm = 0;
          ae.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71168);
          return;
        }
        int j = localb.errCode;
        ae.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.errMsg });
        int i;
        if (j == 0)
        {
          ae.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dDg });
          if (s.this.xDC == null) {
            i = 0;
          }
          for (;;)
          {
            Object localObject1;
            if (s.this.xDC == null)
            {
              localObject1 = "";
              af.f(i, (String)localObject1, 22, "");
              s.this.xDC.DAm = 1;
              s.this.xDC.dwk = localb.dwk;
              s.this.xDC.dwl = localb.dwl;
            }
            try
            {
              localObject1 = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cRX());
              ((JSONObject)localObject1).put("soter_type", t.eJf().eJN());
              s.this.xDC.dDg = ((JSONObject)localObject1).toString();
              s.this.xDC.dwi = localb.dwi;
              localObject1 = s.this.xDC;
              ((PayInfo)localObject1).DAn += 1;
              s.this.DAf.setText("");
              s.this.eLz();
              com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.plugin.soter.d.a.Sy(0);
              AppMethodBeat.o(71168);
              return;
              i = s.this.xDC.dDH;
              continue;
              localObject1 = s.this.xDC.dmw;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.WalletPwdDialog", localJSONException, "", new Object[0]);
              }
            }
          }
        }
        ae.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        Object localObject2;
        label434:
        int k;
        boolean bool1;
        if (s.this.xDC == null)
        {
          i = 0;
          if (s.this.xDC != null) {
            break label849;
          }
          localObject2 = "";
          af.f(i, (String)localObject2, 23, "");
          s.this.xDC.DAm = 0;
          s.this.DAe.setVisibility(0);
          s.this.DAf.setTextColor(s.this.getContext().getResources().getColor(2131100798));
          s.this.DAf.setText(2131765262);
          i = (int)(System.currentTimeMillis() / 1000L);
          k = i - s.g(s.this);
          if (k > 1)
          {
            s.a(s.this, i);
            s.h(s.this);
            localObject2 = s.this.xDC;
            ((PayInfo)localObject2).DAn += 1;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
          if ((j != 2) && (j != 10308)) {
            break label864;
          }
          bool1 = true;
          label636:
          if (localb.dDh != 2) {
            break label870;
          }
        }
        label849:
        label864:
        label870:
        for (boolean bool2 = true;; bool2 = false)
        {
          ae.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(s.i(s.this)), Integer.valueOf(j), Boolean.valueOf(bool2) });
          if (((!bool2) && ((s.i(s.this) >= 3) || (k <= 1))) || (bool1)) {
            break label876;
          }
          ae.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
          if (s.j(s.this) == null) {
            s.a(s.this, com.tencent.mm.ui.c.a.gt(s.this.getContext()));
          }
          s.this.DwW.setVisibility(8);
          s.this.DAf.setVisibility(4);
          s.j(s.this).reset();
          s.j(s.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71167);
              ae.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71165);
                  s.this.DAf.setVisibility(8);
                  s.this.DwW.setVisibility(0);
                  AppMethodBeat.o(71165);
                }
              });
              AppMethodBeat.o(71167);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71166);
              ae.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71164);
                  s.this.DAf.setVisibility(0);
                  AppMethodBeat.o(71164);
                }
              });
              AppMethodBeat.o(71166);
            }
          });
          s.this.DAf.startAnimation(s.j(s.this));
          com.tencent.mm.plugin.soter.d.a.Sy(1);
          AppMethodBeat.o(71168);
          return;
          i = s.this.xDC.dDH;
          break;
          localObject2 = s.this.xDC.dmw;
          break label434;
          bool1 = false;
          break label636;
        }
        label876:
        if ((s.i(s.this) >= 3) || (bool1))
        {
          ae.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
          s.eLD();
          s.this.DAg = 0;
          s.k(s.this);
          s.this.DAd.setVisibility(8);
          s.this.DAe.setVisibility(8);
          s.this.DAf.setVisibility(0);
          s.this.DAf.setText(2131765263);
          s.this.DAf.setTextColor(s.this.getContext().getResources().getColor(2131101133));
          s.this.DzJ.setText(2131765747);
          s.this.DzO.setVisibility(0);
          if (!s.this.mKBLayout.isShown()) {
            s.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.Sy(2);
          s.uF(true);
        }
        AppMethodBeat.o(71168);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l(localoe);
    AppMethodBeat.o(71178);
  }
  
  private static void eLk()
  {
    AppMethodBeat.i(71179);
    ae.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(71179);
  }
  
  private void eLy()
  {
    AppMethodBeat.i(71177);
    if (this.DAg == 1) {
      this.DAd.setText(2131765264);
    }
    for (;;)
    {
      this.DAg = 0;
      this.DAl = bu.HQ();
      this.DAe.setVisibility(8);
      this.DAu.setVisibility(8);
      this.DzO.setVisibility(0);
      if (!this.mKBLayout.isShown()) {
        this.mKBLayout.setVisibility(0);
      }
      this.DzJ.setText(2131765747);
      uB(true);
      this.xDC.DAm = 0;
      com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.f.aha(29);
      eLk();
      AppMethodBeat.o(71177);
      return;
      this.DAd.setText(2131765256);
    }
  }
  
  private void h(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71191);
    if (paramBankcard == null)
    {
      ae.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eIy())
    {
      this.DzM.setImageResource(2131234612);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eIz())
    {
      this.CWV.a(paramBankcard, this.DzM);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.eIC())
    {
      this.DzM.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      if (!bu.isNullOrNil(paramBankcard.DmC))
      {
        this.DzM.setUseSdcardCache(true);
        this.DzM.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eKI());
        this.DzM.gk(paramBankcard.DmC, 2131690298);
        AppMethodBeat.o(71191);
      }
    }
    else
    {
      this.CWV.a(getContext(), paramBankcard, this.DzM);
    }
    AppMethodBeat.o(71191);
  }
  
  private static void uB(boolean paramBoolean)
  {
    AppMethodBeat.i(71208);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMu, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71208);
  }
  
  private void uC(boolean paramBoolean)
  {
    AppMethodBeat.i(71180);
    View localView = this.iFK.findViewById(2131297117);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.DAo = true;
        AppMethodBeat.o(71180);
        return;
      }
      localView.setVisibility(8);
      this.DAo = false;
    }
    AppMethodBeat.o(71180);
  }
  
  private void uD(boolean paramBoolean)
  {
    AppMethodBeat.i(71193);
    if (!paramBoolean)
    {
      this.DzR.setVisibility(8);
      this.DzS.setVisibility(8);
      AppMethodBeat.o(71193);
      return;
    }
    this.DzR.setVisibility(0);
    this.DzS.setVisibility(0);
    AppMethodBeat.o(71193);
  }
  
  public final void a(final Context paramContext, final Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71194);
    this.Dbe = e.DtH.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.DpQ != null) && (paramOrders.DpQ.CYG != null) && (paramOrders.DpQ.CYG.size() > 0) && (this.Dbe != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.Dar = this.Dbe.aGl(paramOrders.DpQ.CYF);; this.Dar = paramFavorPayInfo)
      {
        this.DzN.setVisibility(0);
        if (this.DzR != null) {
          this.DzR.setTag(this.Dar);
        }
        this.DAc = paramBankcard;
        this.DzW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71170);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            s.this.DzT.setVisibility(8);
            int i;
            if (s.this.xDC == null)
            {
              i = 0;
              if (s.this.xDC != null) {
                break label143;
              }
            }
            label143:
            for (paramAnonymousView = "";; paramAnonymousView = s.this.xDC.dmw)
            {
              af.f(i, paramAnonymousView, 12, "");
              n.a(paramContext, paramOrders, s.this.Dar.Doq, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  Object localObject2 = null;
                  AppMethodBeat.i(71169);
                  s.this.Dar = paramAnonymous2FavorPayInfo;
                  int i;
                  if (s.this.xDC == null)
                  {
                    i = 0;
                    if (s.this.xDC != null) {
                      break label294;
                    }
                    paramAnonymous2FavorPayInfo = "";
                    label51:
                    af.f(i, paramAnonymous2FavorPayInfo, 15, s.this.Dar.Doq);
                    s.this.DAa = false;
                    paramAnonymous2FavorPayInfo = d.cq(s.this.Dar.Dor, s.this.Dar.Dos);
                    s.this.Dar.Dou = "";
                    if (!d.a(s.this.Dar, s.this.DAc)) {
                      break label339;
                    }
                    s.this.DAa = true;
                    if (paramAnonymous2FavorPayInfo.size() != 0) {
                      break label311;
                    }
                  }
                  label294:
                  label311:
                  for (s.this.Dar.Dou = s.9.this.val$context.getString(2131765258);; s.this.Dar.Dou = s.9.this.val$context.getString(2131765259))
                  {
                    s.this.dismiss();
                    if (s.this.DAt == null) {
                      break label339;
                    }
                    s.this.DAt.a(s.this.DzO.getText(), s.this.Dar, s.this.DAa);
                    AppMethodBeat.o(71169);
                    return;
                    i = s.this.xDC.dDH;
                    break;
                    paramAnonymous2FavorPayInfo = s.this.xDC.dmw;
                    break label51;
                  }
                  label339:
                  if (s.this.DzR != null) {
                    s.this.DzR.setTag(s.this.Dar);
                  }
                  Object localObject1 = s.this.Dbe.aGi(s.this.Dar.Doq);
                  double d;
                  String str1;
                  String str3;
                  String str2;
                  String str4;
                  if ((localObject1 != null) && (((j)localObject1).CYM > 0.0D))
                  {
                    d = ((j)localObject1).CYE;
                    str1 = com.tencent.mm.wallet_core.ui.f.D(((j)localObject1).CYL);
                    str3 = com.tencent.mm.wallet_core.ui.f.D(s.9.this.DAE.DpQ.CYC);
                    str2 = ((j)localObject1).CYO;
                    paramAnonymous2FavorPayInfo = null;
                    if ((localObject1 == null) || (((j)localObject1).CYN == 0)) {
                      break label657;
                    }
                    str4 = ((j)localObject1).CYP;
                    localObject1 = str4;
                    if (bu.isNullOrNil(str2)) {}
                  }
                  label657:
                  for (localObject1 = ",".concat(String.valueOf(str4));; localObject1 = null)
                  {
                    if ((!bu.isNullOrNil(str2)) || (!bu.isNullOrNil((String)localObject1))) {
                      if (bu.isNullOrNil(paramAnonymous2FavorPayInfo)) {
                        paramAnonymous2FavorPayInfo = localObject2;
                      }
                    }
                    for (;;)
                    {
                      s.this.d(str1, d);
                      s.this.aGs(str3);
                      s.this.kC(str2, paramAnonymous2FavorPayInfo);
                      s.this.aGt((String)localObject1);
                      AppMethodBeat.o(71169);
                      return;
                      d = s.9.this.DAE.DpQ.CYC;
                      str1 = com.tencent.mm.wallet_core.ui.f.D(s.9.this.DAE.DpQ.CYC);
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
              i = s.this.xDC.dDH;
              break;
            }
          }
        });
        Assert.assertNotNull(this.Dbe);
        this.DzT.setVisibility(8);
        AppMethodBeat.o(71194);
        return;
      }
    }
    this.DzN.setVisibility(8);
    AppMethodBeat.o(71194);
  }
  
  public final void a(a parama)
  {
    this.DAv = parama;
  }
  
  public final void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(71192);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.DzR.setOnClickListener(paramOnClickListener);
      this.DzK.setText(paramCharSequence);
      uD(this.DAb);
      if (!paramBoolean)
      {
        this.DzQ.setVisibility(8);
        AppMethodBeat.o(71192);
        return;
      }
      this.DzQ.setVisibility(0);
      AppMethodBeat.o(71192);
      return;
    }
    this.DzR.setVisibility(8);
    this.DzS.setVisibility(8);
    AppMethodBeat.o(71192);
  }
  
  public final void aGq(String paramString)
  {
    AppMethodBeat.i(71185);
    this.yGw.setText(paramString);
    AppMethodBeat.o(71185);
  }
  
  public final void aGs(String paramString)
  {
    AppMethodBeat.i(71189);
    if (!TextUtils.isEmpty(paramString))
    {
      this.Dbp.setVisibility(0);
      this.Dbp.setText(paramString);
      AppMethodBeat.o(71189);
      return;
    }
    this.Dbp.setVisibility(8);
    AppMethodBeat.o(71189);
  }
  
  public final void aGt(String paramString)
  {
    AppMethodBeat.i(71199);
    if (!bu.isNullOrNil(paramString))
    {
      this.DzV.setText(paramString);
      this.DzV.setVisibility(0);
      AppMethodBeat.o(71199);
      return;
    }
    this.DzV.setVisibility(8);
    AppMethodBeat.o(71199);
  }
  
  protected void aN(Context paramContext)
  {
    AppMethodBeat.i(71174);
    ae.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    gS(paramContext);
    gT(paramContext);
    AppMethodBeat.o(71174);
  }
  
  public final void b(final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71196);
    if (this.vKb == null)
    {
      AppMethodBeat.o(71196);
      return;
    }
    this.XL = paramOnCancelListener;
    this.vKb.setVisibility(0);
    this.vKb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71171);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(null);
        }
        if (s.this.DAv != null) {
          s.this.DAv.dzV();
        }
        s.this.cancel();
        if (s.this.DAd.isShown()) {
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71171);
          return;
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    });
    AppMethodBeat.o(71196);
  }
  
  public int cvT()
  {
    return 2131495963;
  }
  
  public final void d(String paramString, double paramDouble)
  {
    AppMethodBeat.i(71186);
    if (!TextUtils.isEmpty(paramString))
    {
      this.ytR.setVisibility(0);
      this.ytR.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.DAb = false;
        uD(this.DAb);
        AppMethodBeat.o(71186);
        return;
      }
      uD(this.DAb);
      AppMethodBeat.o(71186);
      return;
    }
    this.ytR.setVisibility(8);
    this.DAb = true;
    uD(this.DAb);
    AppMethodBeat.o(71186);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(71184);
    try
    {
      super.dismiss();
      eLk();
      this.CWV.destory();
      if (this.tsJ != null) {
        this.tsJ.cancel();
      }
      AppMethodBeat.o(71184);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  public final void eKV()
  {
    AppMethodBeat.i(71206);
    this.isPaused = false;
    if (v.aAR())
    {
      AppMethodBeat.o(71206);
      return;
    }
    AppMethodBeat.o(71206);
  }
  
  protected void eLz()
  {
    AppMethodBeat.i(71195);
    uB(false);
    if (this.DzZ != null) {
      this.DzZ.onClick(this, 0);
    }
    dismiss();
    if (this.DAt != null) {
      this.DAt.a(this.DzO.getText(), this.Dar, this.DAa);
    }
    if (this.DAl < 0L)
    {
      ae.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71195);
      return;
    }
    if (this.DAg == 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(686L, 1L, bu.aO(this.DAl), false);
      AppMethodBeat.o(71195);
      return;
    }
    if (this.DAg == 1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(686L, 3L, bu.aO(this.DAl), false);
    }
    AppMethodBeat.o(71195);
  }
  
  protected final void gS(Context paramContext)
  {
    AppMethodBeat.i(71175);
    this.iFK = View.inflate(paramContext, cvT(), null);
    this.vKb = ((ImageView)this.iFK.findViewById(2131306819));
    this.mKeyboard = ((MyKeyboardWindow)this.iFK.findViewById(2131305695));
    this.mKBLayout = this.iFK.findViewById(2131305693);
    this.yGw = ((TextView)this.iFK.findViewById(2131298739));
    this.DzJ = ((TextView)this.iFK.findViewById(2131306826));
    this.ytR = ((TextView)this.iFK.findViewById(2131299872));
    this.Dbp = ((TextView)this.iFK.findViewById(2131303087));
    this.Dbp.getPaint().setFlags(16);
    this.DzK = ((TextView)this.iFK.findViewById(2131297176));
    this.DzL = ((FavourLayout)this.iFK.findViewById(2131299869));
    this.DzM = ((CdnImageView)this.iFK.findViewById(2131297165));
    this.DzQ = this.iFK.findViewById(2131299861);
    this.DzN = ((TextView)this.iFK.findViewById(2131302467));
    this.jgy = ((ImageView)this.iFK.findViewById(2131298184));
    this.DzR = this.iFK.findViewById(2131297163);
    this.DzS = ((TextView)this.iFK.findViewById(2131304595));
    a.b.c(this.jgy, com.tencent.mm.wallet_core.ui.f.getUsername());
    this.DzO = ((EditHintPasswdView)this.iFK.findViewById(2131301026));
    this.DzT = ((ImageView)this.iFK.findViewById(2131300682));
    this.DAd = ((TextView)this.iFK.findViewById(2131306814));
    this.DAe = this.iFK.findViewById(2131300088);
    this.DAf = ((TextView)this.iFK.findViewById(2131300091));
    this.DwW = ((ImageView)this.iFK.findViewById(2131300087));
    this.DzU = ((TextView)this.iFK.findViewById(2131297953));
    this.DzV = ((TextView)this.iFK.findViewById(2131303711));
    this.DzW = this.iFK.findViewById(2131299859);
    this.DzX = ((TextView)this.iFK.findViewById(2131299868));
    this.DAu = ((Button)this.iFK.findViewById(2131299685));
    this.DzL.setVisibility(8);
    AppMethodBeat.o(71175);
  }
  
  @TargetApi(14)
  protected void gT(Context paramContext)
  {
    AppMethodBeat.i(71176);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    com.tencent.mm.wallet_core.ui.formview.a.a(this.DzO);
    this.DzO.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71155);
        if (paramAnonymousBoolean)
        {
          s.this.eLz();
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71155);
      }
    });
    this.DzO.requestFocus();
    Object localObject = (TextView)this.iFK.findViewById(2131306826);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kU(paramContext));
    }
    paramContext = (EditText)this.iFK.findViewById(2131306718);
    com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText(paramContext);
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!s.this.mKBLayout.isShown()) {
          s.this.mKBLayout.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71157);
      }
    });
    this.iFK.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71158);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (s.this.mKBLayout.isShown()) {
          s.this.mKBLayout.setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71158);
      }
    });
    this.DAu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71159);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        s.a(s.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71159);
      }
    });
    AppMethodBeat.o(71176);
  }
  
  public final void kC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71188);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.DzN.setVisibility(0);
      this.DzN.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.DzX.setText(paramString1);
      this.DzX.setVisibility(0);
      AppMethodBeat.o(71188);
      return;
      this.DzN.setVisibility(8);
    }
    this.DzX.setVisibility(8);
    AppMethodBeat.o(71188);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71207);
    this.isPaused = true;
    if (v.aAR())
    {
      AppMethodBeat.o(71207);
      return;
    }
    if (this.DAg == 1) {
      eLy();
    }
    AppMethodBeat.o(71207);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71182);
    super.onCreate(paramBundle);
    setContentView(this.iFK);
    com.tencent.soter.a.g.f.fZD().fZE();
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
      if (this.DAv != null) {
        this.DAv.dzV();
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
  
  public final void uE(boolean paramBoolean)
  {
    AppMethodBeat.i(71197);
    if (paramBoolean)
    {
      this.DzR.setVisibility(0);
      AppMethodBeat.o(71197);
      return;
    }
    this.DzR.setVisibility(8);
    AppMethodBeat.o(71197);
  }
  
  public static abstract interface a
  {
    public abstract void dzV();
  }
  
  static final class b
    implements DialogInterface.OnCancelListener
  {
    private DialogInterface.OnCancelListener DAG = null;
    
    private b(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.DAG = paramOnCancelListener;
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(71172);
      s.uF(false);
      if (this.DAG != null) {
        this.DAG.onCancel(paramDialogInterface);
      }
      AppMethodBeat.o(71172);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.s
 * JD-Core Version:    0.7.0.1
 */