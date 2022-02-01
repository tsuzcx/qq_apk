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
import com.tencent.mm.f.a.pt;
import com.tencent.mm.f.a.pt.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.u;
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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
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

public class t
  extends i
  implements g
{
  private static HashMap<String, Boolean> Pcb;
  private int ByW;
  private Animation Bzl;
  public ImageView EKk;
  protected PayInfo HzF;
  public TextView IPM;
  public TextView Isv;
  protected com.tencent.mm.plugin.wallet_core.utils.a OuA;
  protected FavorPayInfo OxY;
  protected e OyM;
  public TextView OyX;
  protected DialogInterface.OnClickListener PbB;
  protected boolean PbC;
  protected boolean PbD;
  public Bankcard PbE;
  public TextView PbF;
  public View PbG;
  public TextView PbH;
  public ImageView PbI;
  protected int PbJ;
  protected boolean PbK;
  private int PbL;
  private Animation PbM;
  private String PbN;
  private long PbO;
  boolean PbR;
  public c PbW;
  public Button PbX;
  protected a PbY;
  protected int PbZ;
  public TextView Pbl;
  public TextView Pbm;
  public FavourLayout Pbn;
  public CdnImageView Pbo;
  public TextView Pbp;
  public EditHintPasswdView Pbq;
  public View Pbs;
  public View Pbt;
  public TextView Pbu;
  public ImageView Pbv;
  public TextView Pbw;
  public TextView Pbx;
  public View Pby;
  public TextView Pbz;
  private byte[] Pca;
  protected boolean bxO;
  protected DialogInterface.OnCancelListener fs;
  private boolean isPaused;
  private Context mContext;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  public ImageView mWb;
  public View mrI;
  
  static
  {
    AppMethodBeat.i(71219);
    Pcb = new HashMap();
    AppMethodBeat.o(71219);
  }
  
  public t(Context paramContext)
  {
    super(paramContext, a.j.mmpwddialog);
    AppMethodBeat.i(71173);
    this.OyM = null;
    this.OxY = new FavorPayInfo();
    this.PbC = false;
    this.PbD = true;
    this.PbE = null;
    this.OuA = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.PbJ = 0;
    this.PbZ = -1;
    this.PbK = false;
    this.PbL = 0;
    this.ByW = 0;
    this.PbM = null;
    this.PbN = "";
    this.PbO = -1L;
    this.Pca = new byte[0];
    this.PbR = false;
    this.isPaused = false;
    bv(paramContext);
    AppMethodBeat.o(71173);
  }
  
  private static void Ck(boolean paramBoolean)
  {
    AppMethodBeat.i(71208);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Viw, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71208);
  }
  
  private void Cl(boolean paramBoolean)
  {
    AppMethodBeat.i(71180);
    View localView = this.mrI.findViewById(a.f.bank_card_iv_un_read);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.PbR = true;
        AppMethodBeat.o(71180);
        return;
      }
      localView.setVisibility(8);
      this.PbR = false;
    }
    AppMethodBeat.o(71180);
  }
  
  private void Cm(boolean paramBoolean)
  {
    AppMethodBeat.i(71193);
    if (!paramBoolean)
    {
      this.Pbt.setVisibility(8);
      this.Pbu.setVisibility(8);
      AppMethodBeat.o(71193);
      return;
    }
    this.Pbt.setVisibility(0);
    this.Pbu.setVisibility(0);
    AppMethodBeat.o(71193);
  }
  
  public static t a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71200);
    paramContext = a(paramContext, true, paramOrders, paramFavorPayInfo, paramBankcard, paramPayInfo, null, paramc, paramOnClickListener, paramOnCancelListener);
    AppMethodBeat.o(71200);
    return paramContext;
  }
  
  public static t a(Context paramContext, String paramString1, double paramDouble, String paramString2, Bankcard paramBankcard, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    boolean bool = true;
    AppMethodBeat.i(71205);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(71205);
      return null;
    }
    t localt = new t(paramContext);
    localt.c(paramOnCancelListener);
    localt.setOnCancelListener(paramOnCancelListener);
    localt.setCancelable(true);
    localt.bhA(paramString1);
    localt.e(com.tencent.mm.wallet_core.ui.g.d(paramDouble, paramString2), paramDouble);
    localt.PbD = true;
    if (paramBankcard == null)
    {
      paramString1 = "";
      localt.j(paramBankcard);
      if (TextUtils.isEmpty(paramString1)) {
        break label160;
      }
    }
    for (;;)
    {
      localt.Cn(bool);
      if (paramBankcard != null) {
        localt.a(paramString1, paramOnClickListener, false);
      }
      localt.PbW = paramc;
      localt.show();
      com.tencent.mm.ui.base.h.a(paramContext, localt);
      AppMethodBeat.o(71205);
      return localt;
      paramString1 = paramBankcard.field_desc;
      break;
      label160:
      bool = false;
    }
  }
  
  public static t a(Context paramContext, String paramString1, String paramString2, c paramc, DialogInterface.OnCancelListener paramOnCancelListener, a parama)
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
    t localt = new t(paramContext);
    localt.c(paramOnCancelListener);
    localt.setOnCancelListener(paramOnCancelListener);
    localt.setCancelable(true);
    localt.bhA(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localt.Isv.setVisibility(0);
      localt.Isv.setText(paramString2);
    }
    for (;;)
    {
      localt.PbD = true;
      localt.Cm(localt.PbD);
      localt.Cn(false);
      localt.PbD = false;
      localt.PbY = parama;
      localt.bhB("");
      localt.PbW = paramc;
      localt.show();
      com.tencent.mm.ui.base.h.a(paramContext, localt);
      AppMethodBeat.o(71204);
      return localt;
      localt.Isv.setVisibility(8);
    }
  }
  
  public static t a(Context paramContext, boolean paramBoolean, Orders paramOrders, final FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, String paramString, c paramc, final View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71201);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    if ((paramOrders == null) || (paramOrders.ORd == null) || (paramOrders.ORd.size() <= 0))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    e locale = f.OVk.a(paramOrders);
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
      Log.i("MicroMsg.WalletPwdDialog", "showAlert with favInfo %s bindSerial %s  bankcardType %s", new Object[] { localObject1, localObject2, localObject3 });
      if (locale == null) {
        break label1266;
      }
      if ((paramFavorPayInfo == null) || (paramBankcard == null)) {
        break label1238;
      }
      if (!paramBankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
        break label2206;
      }
    }
    label398:
    label405:
    label2206:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.OPI, Boolean.valueOf(bool1) });
      String str1 = locale.cU(paramFavorPayInfo.OPI, bool1);
      Log.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str1 });
      localObject2 = locale.bhq(str1);
      localObject1 = locale.cT(str1, true);
      Object localObject4 = (e.a)((Map)localObject2).get(paramBankcard.field_bindSerial);
      Object localObject5 = (e.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
      Object localObject6 = locale.cS(str1, bool1);
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
        Log.i("MicroMsg.WalletPwdDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((localObject4 == null) || (((e.a)localObject4).OVi == null) || (Util.isNullOrNil(((e.a)localObject4).OVi.OwC))) {
          break label1170;
        }
        paramFavorPayInfo.OPI = ((e.a)localObject4).OVi.OwC;
        localObject1 = locale.gLg();
        localObject5 = paramFavorPayInfo;
        localObject2 = "";
        if (paramPayInfo.lfu != null) {
          break label1284;
        }
        paramFavorPayInfo = "";
        if (Util.isNullOrNil(paramFavorPayInfo)) {
          break label1301;
        }
        if ((!Util.isNullOrNil(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.ORd == null)) {
          break label2016;
        }
        localObject2 = (Orders.Commodity)paramOrders.ORd.get(0);
        if (localObject2 == null) {
          break label2051;
        }
        paramString = ((Orders.Commodity)localObject2).GHo;
        paramFavorPayInfo = paramString;
        if (a(paramPayInfo))
        {
          paramFavorPayInfo = paramString;
          if (!Util.isNullOrNil(paramString)) {
            paramFavorPayInfo = paramString + "\n";
          }
          paramFavorPayInfo = paramFavorPayInfo + ((Orders.Commodity)localObject2).desc;
        }
        localObject3 = paramFavorPayInfo;
        if (Util.isNullOrNil(paramFavorPayInfo)) {
          localObject3 = ((Orders.Commodity)localObject2).desc;
        }
        localObject8 = null;
        localObject7 = null;
        localObject4 = null;
        str2 = null;
        str1 = null;
        localObject6 = null;
        paramString = null;
        d1 = paramOrders.fwy;
        bool2 = false;
        bool1 = false;
        if ((locale == null) || (localObject5 == null)) {
          break label2196;
        }
        localObject6 = locale.bhs(((FavorPayInfo)localObject5).OPI);
        if ((localObject6 == null) || (((j)localObject6).Owt <= 0.0D)) {
          break label2063;
        }
        bool1 = true;
        localObject4 = com.tencent.mm.wallet_core.ui.g.d(paramOrders.fwy, paramOrders.GHz);
        localObject1 = com.tencent.mm.wallet_core.ui.g.d(((j)localObject6).Ows, paramOrders.GHz);
        d1 = ((j)localObject6).Owl;
        str1 = ((j)localObject6).Owv;
        if (Pcb.containsKey(paramPayInfo.fwv)) {
          break label2191;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(14530, new Object[] { Integer.valueOf(3) });
        paramFavorPayInfo = null;
        localObject2 = paramString;
        if (localObject6 != null)
        {
          localObject2 = paramString;
          if (((j)localObject6).Owu != 0)
          {
            paramString = ((j)localObject6).Oww;
            localObject2 = paramString;
            if (!Util.isNullOrNil(str1)) {
              localObject2 = ",".concat(String.valueOf(paramString));
            }
          }
        }
        if (Util.isNullOrNil(str1))
        {
          localObject6 = localObject2;
          paramString = paramFavorPayInfo;
          d2 = d1;
          str2 = str1;
          localObject7 = localObject4;
          localObject8 = localObject1;
          bool2 = bool1;
          if (Util.isNullOrNil((String)localObject2)) {}
        }
        else
        {
          if (!Util.isNullOrNil(paramFavorPayInfo)) {
            break label2124;
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
        if (paramOrders.Imo > 0.0D) {}
        for (localObject1 = paramContext.getResources().getString(a.i.wallet_charge_fee_msg, new Object[] { com.tencent.mm.wallet_core.ui.g.d(paramOrders.Imo, paramOrders.GHz) });; localObject1 = null)
        {
          if (paramBankcard == null)
          {
            paramFavorPayInfo = "";
            label861:
            localObject2 = paramFavorPayInfo;
            if (paramBankcard != null)
            {
              localObject2 = paramFavorPayInfo;
              if (paramBankcard.gIL()) {
                localObject2 = l.c(paramContext, paramFavorPayInfo);
              }
            }
            paramFavorPayInfo = new t(paramContext);
            paramFavorPayInfo.a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
            paramFavorPayInfo.Cn(paramBoolean);
            paramFavorPayInfo.PbD = paramBoolean;
            paramFavorPayInfo.c(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setOnCancelListener(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setCancelable(true);
            paramFavorPayInfo.bhA((String)localObject3);
            paramFavorPayInfo.e(localObject8, d2);
            paramFavorPayInfo.bhC(localObject7);
            paramFavorPayInfo.a((CharSequence)localObject2, new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(71156);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                t.gLQ().put(this.GDW.fwv, Boolean.TRUE);
                paramOnClickListener.onClick(paramAnonymousView);
                if (paramFavorPayInfo.PbR) {
                  com.tencent.mm.plugin.report.service.h.IzE.a(14530, new Object[] { Integer.valueOf(2) });
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71156);
              }
            }, bool2);
            paramFavorPayInfo.j(paramBankcard);
            if (paramOrders.ORa != 1) {
              break label2172;
            }
            paramBoolean = true;
            label1005:
            paramFavorPayInfo.a(paramPayInfo, paramBoolean);
            paramFavorPayInfo.lS(str2, paramString);
            paramFavorPayInfo.bhD((String)localObject6);
            paramFavorPayInfo.bhB((String)localObject1);
            paramFavorPayInfo.PbW = paramc;
            paramFavorPayInfo.bU(a(paramBankcard, paramOrders));
            if (!a(paramBankcard, paramOrders, paramPayInfo.fwv)) {
              break label2177;
            }
            paramFavorPayInfo.Cl(true);
            com.tencent.mm.plugin.report.service.h.IzE.a(14530, new Object[] { Integer.valueOf(1) });
          }
          for (;;)
          {
            paramFavorPayInfo.show();
            ar.e(paramFavorPayInfo.getWindow());
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
            localObject1 = ((j)localObject6).OwC;
            break label288;
            label1150:
            localObject2 = ((e.a)localObject4).toString();
            break label297;
            localObject3 = ((e.a)localObject5).toString();
            break label306;
            if ((localObject5 != null) && (((e.a)localObject5).OVi != null) && (!Util.isNullOrNil(((e.a)localObject5).OVi.OwC)))
            {
              paramFavorPayInfo.OPI = ((e.a)localObject5).OVi.OwC;
              break label373;
            }
            if (localObject6 != null)
            {
              paramFavorPayInfo.OPI = ((j)localObject6).OwC;
              break label373;
            }
            paramFavorPayInfo.OPI = str1;
            break label373;
            label1238:
            if (paramOrders.ORe == null) {
              break label373;
            }
            paramFavorPayInfo = locale.bhv(locale.bhw(paramOrders.ORe.Owm));
            break label373;
            label1266:
            Log.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            localObject1 = null;
            localObject5 = paramFavorPayInfo;
            break label383;
            paramFavorPayInfo = paramPayInfo.lfu.getString("extinfo_key_19", "");
            break label398;
            if ((paramPayInfo.fOY == 32) || (paramPayInfo.fOY == 33))
            {
              str1 = paramPayInfo.lfu.getString("extinfo_key_5", "");
              localObject4 = paramPayInfo.lfu.getString("extinfo_key_1", "");
              localObject3 = paramContext.getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (!Util.isNullOrNil(str1))
              {
                localObject3 = str1;
                paramFavorPayInfo = str1;
              }
              if (!Util.isNullOrNil((String)localObject4))
              {
                com.tencent.mm.kernel.h.aHH();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg((String)localObject4);
                if (localObject2 != null)
                {
                  paramFavorPayInfo = ((as)localObject2).ays();
                  localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.g.bCw(paramFavorPayInfo));
                  if (Util.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = Util.safeFormatString((String)localObject3, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                Log.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(localObject4)));
                break label405;
              }
              Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              break label405;
            }
            int i;
            if (paramPayInfo.fOY == 31)
            {
              paramFavorPayInfo = paramPayInfo.lfu.getString("extinfo_key_1", "");
              if (!Util.isNullOrNil(paramFavorPayInfo))
              {
                com.tencent.mm.kernel.h.aHH();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((as)localObject3).ayr();
                  i = a.i.wallet_pwd_dialog_remittance_desc_txt;
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (Util.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(i, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                Log.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.fOY == 42)
            {
              paramFavorPayInfo = paramPayInfo.lfu.getString("extinfo_key_1", "");
              if (!Util.isNullOrNil(paramFavorPayInfo))
              {
                com.tencent.mm.kernel.h.aHH();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((as)localObject3).ayr();
                  i = a.i.wallet_pwd_dialog_aa_desc_txt;
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (Util.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(i, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                Log.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(paramFavorPayInfo)));
                paramFavorPayInfo = (FavorPayInfo)localObject2;
                break label405;
              }
              Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label405;
            }
            if (paramPayInfo.fOY == 48)
            {
              paramFavorPayInfo = paramContext.getString(a.i.qr_reward_grant_btn);
              break label405;
            }
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            if (paramPayInfo.fOY != 49) {
              break label405;
            }
            paramFavorPayInfo = paramPayInfo.lfu.getString("extinfo_key_1", "");
            if (!Util.isNullOrNil(paramFavorPayInfo))
            {
              paramFavorPayInfo = paramContext.getString(a.i.wallet_pwd_dialog_remittance_desc_txt, new Object[] { paramFavorPayInfo });
              break label405;
            }
            Log.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.fOY) });
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            break label405;
            label2016:
            paramString = new StringBuilder("orders null?:");
            if (paramOrders == null) {}
            for (bool1 = true;; bool1 = false)
            {
              Log.w("MicroMsg.WalletPwdDialog", bool1);
              localObject3 = paramFavorPayInfo;
              break;
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = com.tencent.mm.wallet_core.ui.g.d(((j)localObject6).Ows, paramOrders.GHz);
              bool1 = true;
              paramFavorPayInfo = paramContext.getString(a.i.wallet_pwd_dialog_more_favors);
              break label684;
            }
            localObject1 = com.tencent.mm.wallet_core.ui.g.d(paramOrders.fwy, paramOrders.GHz);
            paramFavorPayInfo = null;
            break label684;
            label2124:
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
            label2172:
            paramBoolean = false;
            break label1005;
            paramFavorPayInfo.Cl(false);
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
    if ((paramOrders != null) && (paramOrders.ORe != null) && (paramOrders.ORe.Owx != null))
    {
      paramOrders = paramOrders.ORe.Owx.OvS.iterator();
      while (paramOrders.hasNext())
      {
        c localc = (c)paramOrders.next();
        if (localc.GGC.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.Owd.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (com.tencent.mm.plugin.wallet.a.d)paramBankcard.next();
            if (paramOrders.Owe != 0) {
              localLinkedList.add(paramOrders.Ila);
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
  
  private void a(PayInfo paramPayInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(71190);
    this.HzF = paramPayInfo;
    this.PbK = paramBoolean;
    if (z.bdq())
    {
      AppMethodBeat.o(71190);
      return;
    }
    Log.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
    paramPayInfo = this.Pca;
    paramPayInfo = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    boolean bool2;
    if ((paramPayInfo.eos()) && (paramPayInfo.eot()) && (!paramPayInfo.eoo()) && (paramPayInfo.eon()))
    {
      this.PbZ = 0;
      Log.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(this.PbZ) });
      this.PbL = 0;
      this.PbF.setVisibility(8);
      this.PbG.setVisibility(8);
      this.PbO = Util.currentTicks();
      bool2 = p.ByH.ByJ;
      if ((u.gJo() == null) || (this.PbZ < 0)) {
        break label1487;
      }
    }
    label266:
    label294:
    label332:
    label845:
    label1487:
    for (paramBoolean = paramPayInfo.eoz();; paramBoolean = true)
    {
      Object localObject;
      if (this.PbK)
      {
        localObject = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
        if ((((com.tencent.mm.plugin.fingerprint.d.a)localObject).type() != 1) || ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject).eon()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).eoq())) || (!com.tencent.mm.plugin.soter.e.b.gat()) || (!com.tencent.mm.plugin.soter.e.b.gas()) || (com.tencent.soter.core.a.ioE() != 0)) {
          break label744;
        }
        Log.i("MicroMsg.WalletPwdDialog", "may treble init error");
        com.tencent.mm.plugin.report.service.h.IzE.el(1104, 23);
        if (((com.tencent.mm.plugin.fingerprint.d.a)localObject).type() == 2)
        {
          if (com.tencent.soter.core.a.ioE() != 0) {
            break label845;
          }
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 28);
        }
        if (!paramBoolean) {
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 27);
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 33);
        }
      }
      int i;
      if (!bool2)
      {
        boolean bool1 = true;
        paramBoolean &= bool1;
        if (!paramBoolean) {
          p.ByH.ByJ = true;
        }
        Log.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (((this.HzF == null) || ((this.HzF.Rzi != 100000) && (this.HzF.Rzi != 100102))) && (paramBoolean)) {
          break label892;
        }
        Log.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(this.HzF.Rzi) });
        if (!this.mKBLayout.isShown()) {
          this.mKBLayout.setVisibility(0);
        }
        if (this.HzF != null)
        {
          this.HzF.PbP = 0;
          this.HzF.fHc = "";
          this.HzF.fHd = "";
        }
        this.PbG.setVisibility(0);
        this.PbH.setVisibility(0);
        localObject = this.PbH;
        if ((this.HzF == null) || (this.HzF.Rzi != 100102)) {
          break label864;
        }
        i = a.i.wallet_fingerprint_severe_error_hint;
        ((TextView)localObject).setText(i);
        this.PbH.setTextColor(getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
        if (paramBoolean) {
          break label871;
        }
        this.Pbt.setVisibility(0);
        this.Pbu.setVisibility(0);
      }
      for (;;)
      {
        if ((this.HzF != null) && (this.HzF.Rzi == 100102))
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViC, Boolean.TRUE);
          paramPayInfo.rD(false);
          paramPayInfo.rE(false);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViA, Boolean.FALSE);
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71190);
        return;
        if ((!paramPayInfo.eoA()) || (!paramPayInfo.eoB()) || (paramPayInfo.eop()) || (!paramPayInfo.eoq())) {
          break;
        }
        this.PbZ = 1;
        break;
        label744:
        if (((com.tencent.mm.plugin.fingerprint.d.a)localObject).type() != 2) {
          break label266;
        }
        if (com.tencent.soter.core.a.ioE() == 1)
        {
          if (!com.tencent.soter.core.a.ioG())
          {
            Log.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
            com.tencent.mm.plugin.report.service.h.IzE.el(1104, 24);
            break label266;
          }
          if (paramBoolean) {
            break label266;
          }
          Log.i("MicroMsg.WalletPwdDialog", "soter treble key error");
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 25);
          break label266;
        }
        if (paramBoolean) {
          break label266;
        }
        Log.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
        com.tencent.mm.plugin.report.service.h.IzE.el(1104, 26);
        break label266;
        com.tencent.mm.plugin.report.service.h.IzE.el(1104, 31);
        break label294;
        i = 0;
        break label332;
        label864:
        i = a.i.wallet_finger_print_not_recorded;
        break label527;
        label871:
        this.Pbt.setVisibility(8);
        this.Pbu.setVisibility(8);
      }
      label892:
      if ((this.HzF != null) && (this.HzF.Rzi == 100001)) {
        this.HzF.PbP = 1;
      }
      if ((this.PbZ >= 0) && (this.PbK) && (!gLL()))
      {
        this.PbF.setVisibility(0);
        this.PbF.setText(getContext().getString(a.i.wallet_pwd_pay_mode));
        this.Pbq.setVisibility(8);
        this.mKBLayout.setVisibility(8);
        if (this.HzF != null) {
          this.HzF.PbP = 1;
        }
        if (this.PbZ == 0)
        {
          this.PbJ = 1;
          this.PbG.setVisibility(0);
          this.PbI.setVisibility(0);
          this.Pbl.setText(a.i.wallet_pwd_dialog_finger_print_titile);
          gLu();
          com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(this.PbZ), Boolean.valueOf(this.PbK), Boolean.valueOf(gLL()) });
        this.PbF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71160);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (t.this.PbJ == 0) {
              if (t.this.PbZ == 0) {
                t.b(t.this);
              }
            }
            for (;;)
            {
              if (t.this.PbJ == 1)
              {
                t.gLP();
                if (t.e(t.this)) {
                  t.f(t.this);
                }
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71160);
              return;
              t.c(t.this);
              continue;
              if (t.this.PbJ == 1)
              {
                int i;
                if (t.this.HzF == null)
                {
                  i = 0;
                  label143:
                  if (t.this.HzF != null) {
                    break label189;
                  }
                }
                label189:
                for (paramAnonymousView = "";; paramAnonymousView = t.this.HzF.fwv)
                {
                  af.f(i, paramAnonymousView, 19, "");
                  t.d(t.this);
                  break;
                  i = t.this.HzF.fOY;
                  break label143;
                }
              }
              if (t.this.PbJ == 2)
              {
                t.d(t.this);
                com.tencent.mm.plugin.report.service.h.IzE.a(15817, new Object[] { Integer.valueOf(4) });
              }
            }
          }
        });
        AppMethodBeat.o(71190);
        return;
        if (this.PbZ == 1)
        {
          this.PbJ = 2;
          this.PbX.setVisibility(0);
          this.Pbl.setText(a.i.wallet_pwd_dialog_face_id_titile);
          continue;
          if ((this.PbZ >= 0) && (this.PbK) && (gLL()))
          {
            if (this.PbZ == 0) {
              this.PbF.setText(getContext().getString(a.i.wallet_finger_print_pay_mode));
            }
            for (;;)
            {
              this.PbF.setVisibility(0);
              this.PbJ = 0;
              this.PbG.setVisibility(8);
              this.PbX.setVisibility(8);
              this.Pbq.setVisibility(0);
              if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
              }
              this.Pbl.setText(a.i.wallet_pwd_dialog_titile);
              if (this.HzF != null) {
                this.HzF.PbP = 0;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.wallet_core.ui.g.azK(8);
              break;
              this.PbF.setText(getContext().getString(a.i.wallet_faceid_pay_mode));
            }
          }
          if (this.HzF != null) {
            this.HzF.PbP = 0;
          }
          this.PbF.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
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
    if (Pcb.containsKey(paramString))
    {
      AppMethodBeat.o(71203);
      return false;
    }
    int j;
    if ((paramOrders.ORe != null) && (paramOrders.ORe.Owx != null)) {
      if (paramOrders.ORe.Owx.OvS.size() > 0)
      {
        paramString = paramOrders.ORe.Owx.OvS.iterator();
        int i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label139;
        }
        c localc = (c)paramString.next();
        if ((localc.GGC == null) || (!localc.GGC.equals(paramBankcard.field_bindSerial))) {
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
      if (paramOrders.ORe.Owx.OvS.size() > 0)
      {
        AppMethodBeat.o(71203);
        return true;
      }
      if ((paramOrders.ORe.Owx.OvT != null) && (paramOrders.ORe.Owx.OvT.OwJ.size() > 0))
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
    return (paramPayInfo != null) && ((paramPayInfo.fOY == 31) || (paramPayInfo.fOY == 32) || (paramPayInfo.fOY == 33));
  }
  
  private void bU(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(71198);
    if (this.Pbn != null)
    {
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        this.Pbn.setWording(paramLinkedList);
        this.Pbn.setVisibility(0);
        AppMethodBeat.o(71198);
        return;
      }
      this.Pbn.setVisibility(8);
    }
    AppMethodBeat.o(71198);
  }
  
  private void bhB(String paramString)
  {
    AppMethodBeat.i(71187);
    if (!TextUtils.isEmpty(paramString))
    {
      this.Pbw.setVisibility(0);
      this.Pbw.setText(paramString);
      AppMethodBeat.o(71187);
      return;
    }
    Log.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.Pbw.setVisibility(8);
    AppMethodBeat.o(71187);
  }
  
  private void gLJ()
  {
    AppMethodBeat.i(71177);
    if (this.PbJ == 1) {
      this.PbF.setText(a.i.wallet_finger_print_pay_mode);
    }
    for (;;)
    {
      this.PbJ = 0;
      this.PbO = Util.currentTicks();
      this.PbG.setVisibility(8);
      this.PbX.setVisibility(8);
      this.Pbq.setVisibility(0);
      if (!this.mKBLayout.isShown()) {
        this.mKBLayout.setVisibility(0);
      }
      this.Pbl.setText(a.i.wallet_pwd_dialog_titile);
      Ck(true);
      this.HzF.PbP = 0;
      com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.g.azK(29);
      gLv();
      AppMethodBeat.o(71177);
      return;
      this.PbF.setText(a.i.wallet_faceid_pay_mode);
    }
  }
  
  private static boolean gLL()
  {
    AppMethodBeat.i(71209);
    com.tencent.mm.kernel.h.aHH();
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Viw, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71209);
      return bool;
    }
  }
  
  private void gLu()
  {
    AppMethodBeat.i(71178);
    com.tencent.mm.plugin.soter.d.a.gag();
    final pt localpt = new pt();
    localpt.fOs.fHb = this.HzF.fwv;
    localpt.fOs.fOu = 1;
    localpt.fOs.fOw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71168);
        Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        pt.b localb = localpt.fOt;
        if (localb == null)
        {
          t.this.HzF.PbP = 0;
          Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71168);
          return;
        }
        int j = localb.errCode;
        Log.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.errMsg });
        int i;
        if (j == 0)
        {
          Log.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.fOx });
          if (t.this.HzF == null) {
            i = 0;
          }
          for (;;)
          {
            Object localObject1;
            if (t.this.HzF == null)
            {
              localObject1 = "";
              af.f(i, (String)localObject1, 22, "");
              t.this.HzF.PbP = 1;
              t.this.HzF.fHc = localb.fHc;
              t.this.HzF.fHd = localb.fHd;
            }
            try
            {
              localObject1 = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).eor());
              ((JSONObject)localObject1).put("soter_type", u.gJo().gJW());
              t.this.HzF.fOx = ((JSONObject)localObject1).toString();
              t.this.HzF.fHa = localb.fHa;
              localObject1 = t.this.HzF;
              ((PayInfo)localObject1).PbQ += 1;
              t.this.PbH.setText("");
              t.this.gLK();
              com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.plugin.soter.d.a.ahO(0);
              AppMethodBeat.o(71168);
              return;
              i = t.this.HzF.fOY;
              continue;
              localObject1 = t.this.HzF.fwv;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.WalletPwdDialog", localJSONException, "", new Object[0]);
              }
            }
          }
        }
        Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        Object localObject2;
        label434:
        int k;
        boolean bool1;
        if (t.this.HzF == null)
        {
          i = 0;
          if (t.this.HzF != null) {
            break label852;
          }
          localObject2 = "";
          af.f(i, (String)localObject2, 23, "");
          t.this.HzF.PbP = 0;
          t.this.PbG.setVisibility(0);
          t.this.PbH.setTextColor(t.this.getContext().getResources().getColor(a.c.red));
          t.this.PbH.setText(a.i.wallet_finger_print_fail);
          i = (int)(System.currentTimeMillis() / 1000L);
          k = i - t.g(t.this);
          if (k > 1)
          {
            t.a(t.this, i);
            t.h(t.this);
            localObject2 = t.this.HzF;
            ((PayInfo)localObject2).PbQ += 1;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
          if ((j != 2) && (j != 10308)) {
            break label867;
          }
          bool1 = true;
          label638:
          if (localb.fOy != 2) {
            break label873;
          }
        }
        label852:
        label867:
        label873:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(t.i(t.this)), Integer.valueOf(j), Boolean.valueOf(bool2) });
          if (((!bool2) && ((t.i(t.this) >= 3) || (k <= 1))) || (bool1)) {
            break label879;
          }
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
          if (t.j(t.this) == null) {
            t.a(t.this, com.tencent.mm.ui.c.a.jdMethod_if(t.this.getContext()));
          }
          t.this.PbI.setVisibility(8);
          t.this.PbH.setVisibility(4);
          t.j(t.this).reset();
          t.j(t.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71167);
              Log.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71165);
                  t.this.PbH.setVisibility(8);
                  t.this.PbI.setVisibility(0);
                  AppMethodBeat.o(71165);
                }
              });
              AppMethodBeat.o(71167);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71166);
              Log.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71164);
                  t.this.PbH.setVisibility(0);
                  AppMethodBeat.o(71164);
                }
              });
              AppMethodBeat.o(71166);
            }
          });
          t.this.PbH.startAnimation(t.j(t.this));
          com.tencent.mm.plugin.soter.d.a.ahO(1);
          AppMethodBeat.o(71168);
          return;
          i = t.this.HzF.fOY;
          break;
          localObject2 = t.this.HzF.fwv;
          break label434;
          bool1 = false;
          break label638;
        }
        label879:
        if ((t.i(t.this) >= 3) || (bool1))
        {
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
          t.gLP();
          t.this.PbJ = 0;
          t.k(t.this);
          t.this.PbF.setVisibility(8);
          t.this.PbG.setVisibility(8);
          t.this.PbH.setVisibility(0);
          t.this.PbH.setText(a.i.wallet_finger_print_not_recorded);
          t.this.PbH.setTextColor(t.this.getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
          t.this.Pbl.setText(a.i.wallet_pwd_dialog_titile);
          t.this.Pbq.setVisibility(0);
          if (!t.this.mKBLayout.isShown()) {
            t.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.ahO(2);
          t.Co(true);
        }
        AppMethodBeat.o(71168);
      }
    };
    EventCenter.instance.publish(localpt);
    AppMethodBeat.o(71178);
  }
  
  private static void gLv()
  {
    AppMethodBeat.i(71179);
    Log.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(71179);
  }
  
  private void j(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71191);
    if (paramBankcard == null)
    {
      Log.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.gIH())
    {
      this.Pbo.setImageResource(a.e.wallet_balance_manager_logo_small);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.gII())
    {
      this.OuA.a(paramBankcard, this.Pbo);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.gIL())
    {
      this.Pbo.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), a.h.honey_pay_bank_logo));
      if (!Util.isNullOrNil(paramBankcard.ONV))
      {
        this.Pbo.setUseSdcardCache(true);
        this.Pbo.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.gKS());
        this.Pbo.hr(paramBankcard.ONV, a.h.honey_pay_bank_logo);
        AppMethodBeat.o(71191);
      }
    }
    else
    {
      this.OuA.a(getContext(), paramBankcard, this.Pbo);
    }
    AppMethodBeat.o(71191);
  }
  
  public final void Cn(boolean paramBoolean)
  {
    AppMethodBeat.i(71197);
    if (paramBoolean)
    {
      this.Pbt.setVisibility(0);
      AppMethodBeat.o(71197);
      return;
    }
    this.Pbt.setVisibility(8);
    AppMethodBeat.o(71197);
  }
  
  public final void a(final Context paramContext, final Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71194);
    this.OyM = f.OVk.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.ORe != null) && (paramOrders.ORe.Own != null) && (paramOrders.ORe.Own.size() > 0) && (this.OyM != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.OxY = this.OyM.bhv(paramOrders.ORe.Owm);; this.OxY = paramFavorPayInfo)
      {
        this.Pbp.setVisibility(0);
        if (this.Pbt != null) {
          this.Pbt.setTag(this.OxY);
        }
        this.PbE = paramBankcard;
        this.Pby.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71170);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            t.this.Pbv.setVisibility(8);
            int i;
            if (t.this.HzF == null)
            {
              i = 0;
              if (t.this.HzF != null) {
                break label143;
              }
            }
            label143:
            for (paramAnonymousView = "";; paramAnonymousView = t.this.HzF.fwv)
            {
              af.f(i, paramAnonymousView, 12, "");
              o.a(paramContext, paramOrders, t.this.OxY.OPI, new o.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  Object localObject2 = null;
                  AppMethodBeat.i(71169);
                  t.this.OxY = paramAnonymous2FavorPayInfo;
                  int i;
                  if (t.this.HzF == null)
                  {
                    i = 0;
                    if (t.this.HzF != null) {
                      break label295;
                    }
                    paramAnonymous2FavorPayInfo = "";
                    label51:
                    af.f(i, paramAnonymous2FavorPayInfo, 15, t.this.OxY.OPI);
                    t.this.PbC = false;
                    paramAnonymous2FavorPayInfo = e.cJ(t.this.OxY.OPJ, t.this.OxY.OPK);
                    t.this.OxY.OPM = "";
                    if (!e.a(t.this.OxY, t.this.PbE)) {
                      break label341;
                    }
                    t.this.PbC = true;
                    if (paramAnonymous2FavorPayInfo.size() != 0) {
                      break label312;
                    }
                  }
                  label295:
                  label312:
                  for (t.this.OxY.OPM = t.9.this.val$context.getString(a.i.wallet_favor_need_bind_bankcard);; t.this.OxY.OPM = t.9.this.val$context.getString(a.i.wallet_favor_need_change_bankcard))
                  {
                    t.this.dismiss();
                    if (t.this.PbW == null) {
                      break label341;
                    }
                    t.this.PbW.a(t.this.Pbq.getText(), t.this.OxY, t.this.PbC);
                    AppMethodBeat.o(71169);
                    return;
                    i = t.this.HzF.fOY;
                    break;
                    paramAnonymous2FavorPayInfo = t.this.HzF.fwv;
                    break label51;
                  }
                  label341:
                  if (t.this.Pbt != null) {
                    t.this.Pbt.setTag(t.this.OxY);
                  }
                  Object localObject1 = t.this.OyM.bhs(t.this.OxY.OPI);
                  double d;
                  String str1;
                  String str3;
                  String str2;
                  String str4;
                  if ((localObject1 != null) && (((j)localObject1).Owt > 0.0D))
                  {
                    d = ((j)localObject1).Owl;
                    str1 = com.tencent.mm.wallet_core.ui.g.F(((j)localObject1).Ows);
                    str3 = com.tencent.mm.wallet_core.ui.g.F(t.9.this.Pch.ORe.Owj);
                    str2 = ((j)localObject1).Owv;
                    paramAnonymous2FavorPayInfo = null;
                    if ((localObject1 == null) || (((j)localObject1).Owu == 0)) {
                      break label660;
                    }
                    str4 = ((j)localObject1).Oww;
                    localObject1 = str4;
                    if (Util.isNullOrNil(str2)) {}
                  }
                  label660:
                  for (localObject1 = ",".concat(String.valueOf(str4));; localObject1 = null)
                  {
                    if ((!Util.isNullOrNil(str2)) || (!Util.isNullOrNil((String)localObject1))) {
                      if (Util.isNullOrNil(paramAnonymous2FavorPayInfo)) {
                        paramAnonymous2FavorPayInfo = localObject2;
                      }
                    }
                    for (;;)
                    {
                      t.this.e(str1, d);
                      t.this.bhC(str3);
                      t.this.lS(str2, paramAnonymous2FavorPayInfo);
                      t.this.bhD((String)localObject1);
                      AppMethodBeat.o(71169);
                      return;
                      d = t.9.this.Pch.ORe.Owj;
                      str1 = com.tencent.mm.wallet_core.ui.g.F(t.9.this.Pch.ORe.Owj);
                      paramAnonymous2FavorPayInfo = t.9.this.val$context.getString(a.i.wallet_pwd_dialog_more_favors);
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
              i = t.this.HzF.fOY;
              break;
            }
          }
        });
        Assert.assertNotNull(this.OyM);
        this.Pbv.setVisibility(8);
        AppMethodBeat.o(71194);
        return;
      }
    }
    this.Pbp.setVisibility(8);
    AppMethodBeat.o(71194);
  }
  
  public final void a(a parama)
  {
    this.PbY = parama;
  }
  
  public final void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(71192);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.Pbt.setOnClickListener(paramOnClickListener);
      this.Pbm.setText(paramCharSequence);
      Cm(this.PbD);
      if (!paramBoolean)
      {
        this.Pbs.setVisibility(8);
        AppMethodBeat.o(71192);
        return;
      }
      this.Pbs.setVisibility(0);
      AppMethodBeat.o(71192);
      return;
    }
    this.Pbt.setVisibility(8);
    this.Pbu.setVisibility(8);
    AppMethodBeat.o(71192);
  }
  
  public final void bhA(String paramString)
  {
    AppMethodBeat.i(71185);
    this.IPM.setText(paramString);
    AppMethodBeat.o(71185);
  }
  
  public final void bhC(String paramString)
  {
    AppMethodBeat.i(71189);
    if (!TextUtils.isEmpty(paramString))
    {
      this.OyX.setVisibility(0);
      this.OyX.setText(paramString);
      AppMethodBeat.o(71189);
      return;
    }
    this.OyX.setVisibility(8);
    AppMethodBeat.o(71189);
  }
  
  public final void bhD(String paramString)
  {
    AppMethodBeat.i(71199);
    if (!Util.isNullOrNil(paramString))
    {
      this.Pbx.setText(paramString);
      this.Pbx.setVisibility(0);
      AppMethodBeat.o(71199);
      return;
    }
    this.Pbx.setVisibility(8);
    AppMethodBeat.o(71199);
  }
  
  protected void bv(Context paramContext)
  {
    AppMethodBeat.i(71174);
    Log.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    iT(paramContext);
    iU(paramContext);
    AppMethodBeat.o(71174);
  }
  
  public final void c(final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71196);
    if (this.EKk == null)
    {
      AppMethodBeat.o(71196);
      return;
    }
    this.fs = paramOnCancelListener;
    this.EKk.setVisibility(0);
    this.EKk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71171);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(null);
        }
        if (t.this.PbY != null) {
          t.this.PbY.fli();
        }
        t.this.cancel();
        if (t.this.PbF.isShown()) {
          com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71171);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    });
    AppMethodBeat.o(71196);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(71184);
    try
    {
      super.dismiss();
      gLv();
      this.OuA.destory();
      if (this.Bzl != null) {
        this.Bzl.cancel();
      }
      AppMethodBeat.o(71184);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  public final void e(String paramString, double paramDouble)
  {
    AppMethodBeat.i(71186);
    if (!TextUtils.isEmpty(paramString))
    {
      this.Isv.setVisibility(0);
      this.Isv.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.PbD = false;
        Cm(this.PbD);
        AppMethodBeat.o(71186);
        return;
      }
      Cm(this.PbD);
      AppMethodBeat.o(71186);
      return;
    }
    this.Isv.setVisibility(8);
    this.PbD = true;
    Cm(this.PbD);
    AppMethodBeat.o(71186);
  }
  
  protected void gLK()
  {
    AppMethodBeat.i(71195);
    Ck(false);
    if (this.PbB != null) {
      this.PbB.onClick(this, 0);
    }
    dismiss();
    if (this.PbW != null) {
      this.PbW.a(this.Pbq.getText(), this.OxY, this.PbC);
    }
    if (this.PbO < 0L)
    {
      Log.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71195);
      return;
    }
    if (this.PbJ == 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(686L, 1L, Util.ticksToNow(this.PbO), false);
      AppMethodBeat.o(71195);
      return;
    }
    if (this.PbJ == 1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(686L, 3L, Util.ticksToNow(this.PbO), false);
    }
    AppMethodBeat.o(71195);
  }
  
  public int gLO()
  {
    return a.g.wallet_full_pwd_dialog;
  }
  
  protected final void iT(Context paramContext)
  {
    AppMethodBeat.i(71175);
    this.mrI = View.inflate(paramContext, gLO(), null);
    this.EKk = ((ImageView)this.mrI.findViewById(a.f.wallet_pwd_close_iv));
    this.mKeyboard = ((MyKeyboardWindow)this.mrI.findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = this.mrI.findViewById(a.f.tenpay_keyboard_layout);
    this.IPM = ((TextView)this.mrI.findViewById(a.f.content));
    this.Pbl = ((TextView)this.mrI.findViewById(a.f.wallet_pwd_title_tv));
    this.Isv = ((TextView)this.mrI.findViewById(a.f.fee));
    this.OyX = ((TextView)this.mrI.findViewById(a.f.origin_fee));
    this.OyX.getPaint().setFlags(16);
    this.Pbm = ((TextView)this.mrI.findViewById(a.f.bankcard_tv));
    this.Pbn = ((FavourLayout)this.mrI.findViewById(a.f.favour_tip));
    this.Pbo = ((CdnImageView)this.mrI.findViewById(a.f.bankcard_logo));
    this.Pbs = this.mrI.findViewById(a.f.favor_ll);
    this.Pbp = ((TextView)this.mrI.findViewById(a.f.more_favors));
    this.mWb = ((ImageView)this.mrI.findViewById(a.f.chatting_user_iv));
    this.Pbt = this.mrI.findViewById(a.f.bankcard_layout);
    this.Pbu = ((TextView)this.mrI.findViewById(a.f.seperator));
    a.b.c(this.mWb, com.tencent.mm.wallet_core.ui.g.getUsername());
    this.Pbq = ((EditHintPasswdView)this.mrI.findViewById(a.f.input_et));
    this.Pbv = ((ImageView)this.mrI.findViewById(a.f.has_larger_favor_reddot));
    this.PbF = ((TextView)this.mrI.findViewById(a.f.wallet_pay_mode_tv));
    this.PbG = this.mrI.findViewById(a.f.finger_print_layout);
    this.PbH = ((TextView)this.mrI.findViewById(a.f.finger_print_tips));
    this.PbI = ((ImageView)this.mrI.findViewById(a.f.finger_print_icon));
    this.Pbw = ((TextView)this.mrI.findViewById(a.f.charge_fee));
    this.Pbx = ((TextView)this.mrI.findViewById(a.f.random_offer_title));
    this.Pby = this.mrI.findViewById(a.f.favor_container);
    this.Pbz = ((TextView)this.mrI.findViewById(a.f.favors_desc));
    this.PbX = ((Button)this.mrI.findViewById(a.f.face_id_verify_btn));
    this.Pbn.setVisibility(8);
    ar.a(this.Pbl.getPaint(), 0.8F);
    ar.a(this.PbF.getPaint(), 0.8F);
    AppMethodBeat.o(71175);
  }
  
  @TargetApi(14)
  protected void iU(Context paramContext)
  {
    AppMethodBeat.i(71176);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    if (com.tencent.mm.wallet_core.ui.g.ijx()) {
      getWindow().addFlags(8192);
    }
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Pbq);
    this.Pbq.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71155);
        if (paramAnonymousBoolean)
        {
          t.this.gLK();
          com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71155);
      }
    });
    this.Pbq.requestFocus();
    Object localObject = (TextView)this.mrI.findViewById(a.f.wallet_pwd_title_tv);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.lM(paramContext));
    }
    paramContext = (EditText)this.mrI.findViewById(a.f.wallet_content);
    com.tencent.mm.wallet_core.ui.g.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = com.tencent.mm.ui.a.d.hJh();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71157);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!t.this.mKBLayout.isShown()) {
          t.this.mKBLayout.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71157);
      }
    });
    this.mrI.findViewById(a.f.tenpay_push_down).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71158);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (t.this.mKBLayout.isShown()) {
          t.this.mKBLayout.setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71158);
      }
    });
    this.PbX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71159);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        t.a(t.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71159);
      }
    });
    AppMethodBeat.o(71176);
  }
  
  public final void lS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71188);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.Pbp.setVisibility(0);
      this.Pbp.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.Pbz.setText(paramString1);
      this.Pbz.setVisibility(0);
      AppMethodBeat.o(71188);
      return;
      this.Pbp.setVisibility(8);
    }
    this.Pbz.setVisibility(8);
    AppMethodBeat.o(71188);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71207);
    this.isPaused = true;
    if (z.bdq())
    {
      AppMethodBeat.o(71207);
      return;
    }
    if (this.PbJ == 1) {
      gLJ();
    }
    AppMethodBeat.o(71207);
  }
  
  public final void onActivityResume()
  {
    AppMethodBeat.i(71206);
    this.isPaused = false;
    if (z.bdq())
    {
      AppMethodBeat.o(71206);
      return;
    }
    AppMethodBeat.o(71206);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71182);
    super.onCreate(paramBundle);
    setContentView(this.mrI);
    com.tencent.soter.a.g.f.ipn().ipo();
    AppMethodBeat.o(71182);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71181);
    if (paramInt == 4)
    {
      if (this.fs != null) {
        this.fs.onCancel(this);
      }
      if (this.PbY != null) {
        this.PbY.fli();
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
    this.bxO = paramBoolean;
    setCanceledOnTouchOutside(this.bxO);
    AppMethodBeat.o(71183);
  }
  
  public static abstract interface a
  {
    public abstract void fli();
  }
  
  static final class b
    implements DialogInterface.OnCancelListener
  {
    private DialogInterface.OnCancelListener Pcj = null;
    
    private b(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.Pcj = paramOnCancelListener;
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(71172);
      t.Co(false);
      if (this.Pcj != null) {
        this.Pcj.onCancel(paramDialogInterface);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.t
 * JD-Core Version:    0.7.0.1
 */