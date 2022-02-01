package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.autogen.a.rg;
import com.tencent.mm.autogen.a.rg.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet.model.d;
import com.tencent.mm.plugin.wallet.model.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.model.ai;
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

public final class u
  extends com.tencent.mm.ui.widget.a.i
  implements h
{
  private static HashMap<String, Boolean> VSH;
  private int HgB;
  private Animation HgQ;
  public ImageView KDS;
  protected PayInfo Nxi;
  public TextView OYJ;
  public TextView Oqd;
  public TextView VRR;
  public TextView VRS;
  public FavourLayout VRT;
  public CdnImageView VRU;
  public TextView VRV;
  public EditHintPasswdView VRW;
  public View VRY;
  public View VRZ;
  public c VSC;
  public Button VSD;
  protected a VSE;
  protected int VSF;
  private byte[] VSG;
  public TextView VSa;
  public ImageView VSb;
  public TextView VSc;
  public TextView VSd;
  public View VSe;
  public TextView VSf;
  protected DialogInterface.OnClickListener VSh;
  protected boolean VSi;
  protected boolean VSj;
  protected Bankcard VSk;
  public TextView VSl;
  public View VSm;
  public TextView VSn;
  public ImageView VSo;
  protected int VSp;
  protected boolean VSq;
  private int VSr;
  private Animation VSs;
  private String VSt;
  private long VSu;
  boolean VSx;
  protected com.tencent.mm.plugin.wallet_core.utils.b VjO;
  protected f VnX;
  protected FavorPayInfo Vnj;
  public TextView Voi;
  public ImageView avatar;
  protected boolean dqR;
  private boolean isPaused;
  private Context mContext;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected DialogInterface.OnCancelListener mOnCancelListener;
  public View plc;
  
  static
  {
    AppMethodBeat.i(71219);
    VSH = new HashMap();
    AppMethodBeat.o(71219);
  }
  
  private u(Context paramContext)
  {
    super(paramContext, a.j.mmpwddialog);
    AppMethodBeat.i(71174);
    this.VnX = null;
    this.Vnj = new FavorPayInfo();
    this.VSi = false;
    this.VSj = true;
    this.VSk = null;
    this.VjO = new com.tencent.mm.plugin.wallet_core.utils.b();
    this.VSp = 0;
    this.VSF = -1;
    this.VSq = false;
    this.VSr = 0;
    this.HgB = 0;
    this.VSs = null;
    this.VSt = "";
    this.VSu = -1L;
    this.VSG = new byte[0];
    this.VSx = false;
    this.isPaused = false;
    Log.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    this.plc = View.inflate(paramContext, a.g.wallet_full_pwd_dialog, null);
    this.KDS = ((ImageView)this.plc.findViewById(a.f.wallet_pwd_close_iv));
    this.mKeyboard = ((MyKeyboardWindow)this.plc.findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = this.plc.findViewById(a.f.tenpay_keyboard_layout);
    this.OYJ = ((TextView)this.plc.findViewById(a.f.content));
    this.VRR = ((TextView)this.plc.findViewById(a.f.wallet_pwd_title_tv));
    this.Oqd = ((TextView)this.plc.findViewById(a.f.fee));
    this.Voi = ((TextView)this.plc.findViewById(a.f.origin_fee));
    this.Voi.getPaint().setFlags(16);
    this.VRS = ((TextView)this.plc.findViewById(a.f.bankcard_tv));
    this.VRT = ((FavourLayout)this.plc.findViewById(a.f.favour_tip));
    this.VRU = ((CdnImageView)this.plc.findViewById(a.f.bankcard_logo));
    this.VRY = this.plc.findViewById(a.f.favor_ll);
    this.VRV = ((TextView)this.plc.findViewById(a.f.more_favors));
    this.avatar = ((ImageView)this.plc.findViewById(a.f.chatting_user_iv));
    this.VRZ = this.plc.findViewById(a.f.bankcard_layout);
    this.VSa = ((TextView)this.plc.findViewById(a.f.seperator));
    a.b.g(this.avatar, com.tencent.mm.wallet_core.ui.i.getUsername());
    this.VRW = ((EditHintPasswdView)this.plc.findViewById(a.f.input_et));
    this.VSb = ((ImageView)this.plc.findViewById(a.f.has_larger_favor_reddot));
    this.VSl = ((TextView)this.plc.findViewById(a.f.wallet_pay_mode_tv));
    this.VSm = this.plc.findViewById(a.f.finger_print_layout);
    this.VSn = ((TextView)this.plc.findViewById(a.f.finger_print_tips));
    this.VSo = ((ImageView)this.plc.findViewById(a.f.finger_print_icon));
    this.VSc = ((TextView)this.plc.findViewById(a.f.charge_fee));
    this.VSd = ((TextView)this.plc.findViewById(a.f.random_offer_title));
    this.VSe = this.plc.findViewById(a.f.favor_container);
    this.VSf = ((TextView)this.plc.findViewById(a.f.favors_desc));
    this.VSD = ((Button)this.plc.findViewById(a.f.face_id_verify_btn));
    this.VRT.setVisibility(8);
    aw.a(this.VRR.getPaint(), 0.8F);
    aw.a(this.VSl.getPaint(), 0.8F);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    if (com.tencent.mm.wallet_core.ui.i.jPv()) {
      getWindow().addFlags(8192);
    }
    com.tencent.mm.wallet_core.ui.formview.a.a(this.VRW);
    this.VRW.setOnInputValidListener(new u.1(this));
    this.VRW.requestFocus();
    Object localObject = (TextView)this.plc.findViewById(a.f.wallet_pwd_title_tv);
    if (localObject != null) {
      ((TextView)localObject).setText(ai.nR(paramContext));
    }
    paramContext = (EditText)this.plc.findViewById(a.f.wallet_content);
    com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new com.tencent.mm.wallet_core.c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new u.3(this));
    this.plc.findViewById(a.f.tenpay_push_down).setOnClickListener(new u.4(this));
    this.VSD.setOnClickListener(new u.5(this));
    AppMethodBeat.o(71174);
  }
  
  private static void HP(boolean paramBoolean)
  {
    AppMethodBeat.i(71208);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acJQ, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71208);
  }
  
  private void HQ(boolean paramBoolean)
  {
    AppMethodBeat.i(71180);
    View localView = this.plc.findViewById(a.f.bank_card_iv_un_read);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.VSx = true;
        AppMethodBeat.o(71180);
        return;
      }
      localView.setVisibility(8);
      this.VSx = false;
    }
    AppMethodBeat.o(71180);
  }
  
  private void HR(boolean paramBoolean)
  {
    AppMethodBeat.i(71193);
    if (!paramBoolean)
    {
      this.VRZ.setVisibility(8);
      this.VSa.setVisibility(8);
      AppMethodBeat.o(71193);
      return;
    }
    this.VRZ.setVisibility(0);
    this.VSa.setVisibility(0);
    AppMethodBeat.o(71193);
  }
  
  private void HS(boolean paramBoolean)
  {
    AppMethodBeat.i(71197);
    if (paramBoolean)
    {
      this.VRZ.setVisibility(0);
      AppMethodBeat.o(71197);
      return;
    }
    this.VRZ.setVisibility(8);
    AppMethodBeat.o(71197);
  }
  
  public static u a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71200);
    paramContext = a(paramContext, true, paramOrders, paramFavorPayInfo, paramBankcard, paramPayInfo, null, paramc, paramOnClickListener, paramOnCancelListener);
    AppMethodBeat.o(71200);
    return paramContext;
  }
  
  public static u a(Context paramContext, String paramString1, double paramDouble, String paramString2, Bankcard paramBankcard, c paramc, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    boolean bool = true;
    AppMethodBeat.i(71205);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(71205);
      return null;
    }
    u localu = new u(paramContext);
    localu.b(paramOnCancelListener);
    localu.setOnCancelListener(paramOnCancelListener);
    localu.setCancelable(true);
    localu.bhj(paramString1);
    localu.e(com.tencent.mm.wallet_core.ui.i.e(paramDouble, paramString2), paramDouble);
    localu.VSj = true;
    if (paramBankcard == null)
    {
      paramString1 = "";
      localu.k(paramBankcard);
      if (TextUtils.isEmpty(paramString1)) {
        break label160;
      }
    }
    for (;;)
    {
      localu.HS(bool);
      if (paramBankcard != null) {
        localu.a(paramString1, paramOnClickListener, false);
      }
      localu.VSC = paramc;
      localu.show();
      com.tencent.mm.ui.base.k.a(paramContext, localu);
      AppMethodBeat.o(71205);
      return localu;
      paramString1 = paramBankcard.field_desc;
      break;
      label160:
      bool = false;
    }
  }
  
  public static u a(Context paramContext, String paramString1, String paramString2, c paramc, DialogInterface.OnCancelListener paramOnCancelListener, a parama)
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
    u localu = new u(paramContext);
    localu.b(paramOnCancelListener);
    localu.setOnCancelListener(paramOnCancelListener);
    localu.setCancelable(true);
    localu.bhj(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localu.Oqd.setVisibility(0);
      localu.Oqd.setText(paramString2);
    }
    for (;;)
    {
      localu.VSj = true;
      localu.HR(localu.VSj);
      localu.HS(false);
      localu.VSj = false;
      localu.VSE = parama;
      localu.bhk("");
      localu.VSC = paramc;
      localu.show();
      com.tencent.mm.ui.base.k.a(paramContext, localu);
      AppMethodBeat.o(71204);
      return localu;
      localu.Oqd.setVisibility(8);
    }
  }
  
  public static u a(Context paramContext, boolean paramBoolean, Orders paramOrders, final FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, PayInfo paramPayInfo, String paramString, c paramc, final View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71201);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    if ((paramOrders == null) || (paramOrders.VGX == null) || (paramOrders.VGX.size() <= 0))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    f localf = g.VLx.a(paramOrders);
    Object localObject1;
    Object localObject2;
    label88:
    Object localObject3;
    if (paramFavorPayInfo == null)
    {
      localObject1 = "";
      if (paramBankcard != null) {
        break label1116;
      }
      localObject2 = "";
      if (paramBankcard != null) {
        break label1126;
      }
      localObject3 = "";
      label97:
      Log.i("MicroMsg.WalletPwdDialog", "showAlert with favInfo %s bindSerial %s  bankcardType %s", new Object[] { localObject1, localObject2, localObject3 });
      if (localf == null) {
        break label1262;
      }
      if ((paramFavorPayInfo == null) || (paramBankcard == null)) {
        break label1234;
      }
      if (!paramBankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
        break label2193;
      }
    }
    label394:
    label1166:
    label1296:
    label2193:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.VFC, Boolean.valueOf(bool1) });
      String str1 = localf.dC(paramFavorPayInfo.VFC, bool1);
      Log.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str1 });
      localObject2 = localf.bgZ(str1);
      localObject1 = localf.dB(str1, true);
      Object localObject4 = (f.a)((Map)localObject2).get(paramBankcard.field_bindSerial);
      Object localObject5 = (f.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
      Object localObject6 = localf.dA(str1, bool1);
      label285:
      label294:
      label303:
      label369:
      label379:
      Object localObject8;
      label401:
      Object localObject7;
      String str2;
      double d1;
      boolean bool2;
      label680:
      double d2;
      if (localObject6 == null)
      {
        localObject1 = "";
        if (localObject4 != null) {
          break label1146;
        }
        localObject2 = "";
        if (localObject5 != null) {
          break label1156;
        }
        localObject3 = "";
        Log.i("MicroMsg.WalletPwdDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((localObject4 == null) || (((f.a)localObject4).VLv == null) || (Util.isNullOrNil(((f.a)localObject4).VLv.VlN))) {
          break label1166;
        }
        paramFavorPayInfo.VFC = ((f.a)localObject4).VLv.VlN;
        localObject1 = localf.ikx();
        localObject5 = paramFavorPayInfo;
        localObject2 = "";
        if (paramPayInfo.nKf != null) {
          break label1279;
        }
        paramFavorPayInfo = "";
        if (Util.isNullOrNil(paramFavorPayInfo)) {
          break label1296;
        }
        if ((!Util.isNullOrNil(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.VGX == null)) {
          break label2004;
        }
        localObject2 = (Orders.Commodity)paramOrders.VGX.get(0);
        if (localObject2 == null) {
          break label2038;
        }
        paramString = ((Orders.Commodity)localObject2).MEf;
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
        d1 = paramOrders.hAW;
        bool2 = false;
        bool1 = false;
        if ((localf == null) || (localObject5 == null)) {
          break label2183;
        }
        localObject6 = localf.bhb(((FavorPayInfo)localObject5).VFC);
        if ((localObject6 == null) || (((com.tencent.mm.plugin.wallet.model.j)localObject6).VlE <= 0.0D)) {
          break label2050;
        }
        bool1 = true;
        localObject4 = com.tencent.mm.wallet_core.ui.i.e(paramOrders.hAW, paramOrders.MEq);
        localObject1 = com.tencent.mm.wallet_core.ui.i.e(((com.tencent.mm.plugin.wallet.model.j)localObject6).VlD, paramOrders.MEq);
        d1 = ((com.tencent.mm.plugin.wallet.model.j)localObject6).Vlw;
        str1 = ((com.tencent.mm.plugin.wallet.model.j)localObject6).VlG;
        if (VSH.containsKey(paramPayInfo.hAT)) {
          break label2178;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(14530, new Object[] { Integer.valueOf(3) });
        paramFavorPayInfo = null;
        localObject2 = paramString;
        if (localObject6 != null)
        {
          localObject2 = paramString;
          if (((com.tencent.mm.plugin.wallet.model.j)localObject6).VlF != 0)
          {
            paramString = ((com.tencent.mm.plugin.wallet.model.j)localObject6).VlH;
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
            break label2111;
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
        label810:
        if (paramOrders.OjF > 0.0D) {}
        for (localObject1 = paramContext.getResources().getString(a.i.wallet_charge_fee_msg, new Object[] { com.tencent.mm.wallet_core.ui.i.e(paramOrders.OjF, paramOrders.MEq) });; localObject1 = null)
        {
          if (paramBankcard == null)
          {
            paramFavorPayInfo = "";
            label857:
            localObject2 = paramFavorPayInfo;
            if (paramBankcard != null)
            {
              localObject2 = paramFavorPayInfo;
              if (paramBankcard.ihZ()) {
                localObject2 = com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, paramFavorPayInfo);
              }
            }
            paramFavorPayInfo = new u(paramContext);
            paramFavorPayInfo.a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
            paramFavorPayInfo.HS(paramBoolean);
            paramFavorPayInfo.VSj = paramBoolean;
            paramFavorPayInfo.b(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setOnCancelListener(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setCancelable(true);
            paramFavorPayInfo.bhj((String)localObject3);
            paramFavorPayInfo.e(localObject8, d2);
            paramFavorPayInfo.bhl(localObject7);
            paramFavorPayInfo.a((CharSequence)localObject2, new com.tencent.mm.wallet_core.ui.k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(301302);
                u.ilg().put(u.this.hAT, Boolean.TRUE);
                paramOnClickListener.onClick(paramAnonymousView);
                if (paramFavorPayInfo.VSx) {
                  com.tencent.mm.plugin.report.service.h.OAn.b(14530, new Object[] { Integer.valueOf(2) });
                }
                AppMethodBeat.o(301302);
              }
            }, bool2);
            paramFavorPayInfo.k(paramBankcard);
            if (paramOrders.VGU != 1) {
              break label2159;
            }
            paramBoolean = true;
            label1001:
            paramFavorPayInfo.a(paramPayInfo, paramBoolean);
            paramFavorPayInfo.nE(str2, paramString);
            paramFavorPayInfo.bhm((String)localObject6);
            paramFavorPayInfo.bhk((String)localObject1);
            paramFavorPayInfo.VSC = paramc;
            paramFavorPayInfo.cf(a(paramBankcard, paramOrders));
            if (!a(paramBankcard, paramOrders, paramPayInfo.hAT)) {
              break label2164;
            }
            paramFavorPayInfo.HQ(true);
            com.tencent.mm.plugin.report.service.h.OAn.b(14530, new Object[] { Integer.valueOf(1) });
          }
          for (;;)
          {
            paramFavorPayInfo.show();
            aw.g(paramFavorPayInfo.getWindow());
            com.tencent.mm.ui.base.k.a(paramContext, paramFavorPayInfo);
            AppMethodBeat.o(71201);
            return paramFavorPayInfo;
            localObject1 = paramFavorPayInfo.toString();
            break;
            label1116:
            localObject2 = paramBankcard.field_bindSerial;
            break label88;
            label1126:
            localObject3 = paramBankcard.field_bankcardType;
            break label97;
            localObject1 = ((com.tencent.mm.plugin.wallet.model.j)localObject6).VlN;
            break label285;
            label1146:
            localObject2 = ((f.a)localObject4).toString();
            break label294;
            localObject3 = ((f.a)localObject5).toString();
            break label303;
            if ((localObject5 != null) && (((f.a)localObject5).VLv != null) && (!Util.isNullOrNil(((f.a)localObject5).VLv.VlN)))
            {
              paramFavorPayInfo.VFC = ((f.a)localObject5).VLv.VlN;
              break label369;
            }
            if (localObject6 != null)
            {
              paramFavorPayInfo.VFC = ((com.tencent.mm.plugin.wallet.model.j)localObject6).VlN;
              break label369;
            }
            paramFavorPayInfo.VFC = str1;
            break label369;
            label1234:
            if (paramOrders.VGY == null) {
              break label369;
            }
            paramFavorPayInfo = localf.bhe(localf.bhf(paramOrders.VGY.Vlx));
            break label369;
            label1262:
            Log.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            localObject1 = null;
            localObject5 = paramFavorPayInfo;
            break label379;
            label1279:
            paramFavorPayInfo = paramPayInfo.nKf.getString("extinfo_key_19", "");
            break label394;
            if ((paramPayInfo.hUR == 32) || (paramPayInfo.hUR == 33))
            {
              str1 = paramPayInfo.nKf.getString("extinfo_key_5", "");
              localObject4 = paramPayInfo.nKf.getString("extinfo_key_1", "");
              localObject3 = paramContext.getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (!Util.isNullOrNil(str1))
              {
                localObject3 = str1;
                paramFavorPayInfo = str1;
              }
              if (!Util.isNullOrNil((String)localObject4))
              {
                com.tencent.mm.kernel.h.baF();
                localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu((String)localObject4);
                if (localObject2 != null)
                {
                  paramFavorPayInfo = ((au)localObject2).aSV();
                  localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.i.bEU(paramFavorPayInfo));
                  if (Util.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = Util.safeFormatString((String)localObject3, new Object[] { paramFavorPayInfo });
                    break;
                  }
                }
                Log.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(localObject4)));
                break label401;
              }
              Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              break label401;
            }
            int i;
            if (paramPayInfo.hUR == 31)
            {
              paramFavorPayInfo = paramPayInfo.nKf.getString("extinfo_key_1", "");
              if (!Util.isNullOrNil(paramFavorPayInfo))
              {
                com.tencent.mm.kernel.h.baF();
                localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((au)localObject3).aSU();
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
                break label401;
              }
              Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label401;
            }
            if (paramPayInfo.hUR == 42)
            {
              paramFavorPayInfo = paramPayInfo.nKf.getString("extinfo_key_1", "");
              if (!Util.isNullOrNil(paramFavorPayInfo))
              {
                com.tencent.mm.kernel.h.baF();
                localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((au)localObject3).aSU();
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
                break label401;
              }
              Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              break label401;
            }
            if (paramPayInfo.hUR == 48)
            {
              paramFavorPayInfo = paramContext.getString(a.i.qr_reward_grant_btn);
              break label401;
            }
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            if (paramPayInfo.hUR != 49) {
              break label401;
            }
            paramFavorPayInfo = paramPayInfo.nKf.getString("extinfo_key_1", "");
            if (!Util.isNullOrNil(paramFavorPayInfo))
            {
              paramFavorPayInfo = paramContext.getString(a.i.wallet_pwd_dialog_remittance_desc_txt, new Object[] { paramFavorPayInfo });
              break label401;
            }
            Log.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.hUR) });
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            break label401;
            label2004:
            paramString = new StringBuilder("orders null?:");
            if (paramOrders == null) {}
            for (bool1 = true;; bool1 = false)
            {
              Log.w("MicroMsg.WalletPwdDialog", bool1);
              label2038:
              localObject3 = paramFavorPayInfo;
              break;
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = com.tencent.mm.wallet_core.ui.i.e(((com.tencent.mm.plugin.wallet.model.j)localObject6).VlD, paramOrders.MEq);
              bool1 = true;
              paramFavorPayInfo = paramContext.getString(a.i.wallet_pwd_dialog_more_favors);
              break label680;
            }
            localObject1 = com.tencent.mm.wallet_core.ui.i.e(paramOrders.hAW, paramOrders.MEq);
            paramFavorPayInfo = null;
            break label680;
            label2111:
            paramString = ",".concat(String.valueOf(paramFavorPayInfo));
            localObject6 = localObject2;
            d2 = d1;
            str2 = str1;
            localObject7 = localObject4;
            localObject8 = localObject1;
            bool2 = bool1;
            break label810;
            paramFavorPayInfo = paramBankcard.field_desc;
            break label857;
            label2159:
            paramBoolean = false;
            break label1001;
            label2164:
            paramFavorPayInfo.HQ(false);
          }
        }
        paramFavorPayInfo = null;
        break label680;
        paramString = null;
        d2 = d1;
      }
    }
  }
  
  private static LinkedList<String> a(Bankcard paramBankcard, Orders paramOrders)
  {
    AppMethodBeat.i(71202);
    LinkedList localLinkedList = new LinkedList();
    if ((paramOrders != null) && (paramOrders.VGY != null) && (paramOrders.VGY.VlI != null))
    {
      paramOrders = paramOrders.VGY.VlI.Vld.iterator();
      while (paramOrders.hasNext())
      {
        com.tencent.mm.plugin.wallet.model.c localc = (com.tencent.mm.plugin.wallet.model.c)paramOrders.next();
        if (localc.MDt.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.Vlo.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (d)paramBankcard.next();
            if (paramOrders.Vlp != 0) {
              localLinkedList.add(paramOrders.OhO);
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
  
  private void a(final Context paramContext, final Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71194);
    this.VnX = g.VLx.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.VGY != null) && (paramOrders.VGY.Vly != null) && (paramOrders.VGY.Vly.size() > 0) && (this.VnX != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.Vnj = this.VnX.bhe(paramOrders.VGY.Vlx);; this.Vnj = paramFavorPayInfo)
      {
        this.VRV.setVisibility(0);
        if (this.VRZ != null) {
          this.VRZ.setTag(this.Vnj);
        }
        this.VSk = paramBankcard;
        this.VSe.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(301300);
            u.this.VSb.setVisibility(8);
            int i;
            if (u.this.Nxi == null)
            {
              i = 0;
              if (u.this.Nxi != null) {
                break label102;
              }
            }
            label102:
            for (paramAnonymousView = "";; paramAnonymousView = u.this.Nxi.hAT)
            {
              ag.g(i, paramAnonymousView, 12, "");
              p.a(paramContext, paramOrders, u.this.Vnj.VFC, new p.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  Object localObject2 = null;
                  AppMethodBeat.i(71169);
                  u.this.Vnj = paramAnonymous2FavorPayInfo;
                  int i;
                  if (u.this.Nxi == null)
                  {
                    i = 0;
                    if (u.this.Nxi != null) {
                      break label295;
                    }
                    paramAnonymous2FavorPayInfo = "";
                    label51:
                    ag.g(i, paramAnonymous2FavorPayInfo, 15, u.this.Vnj.VFC);
                    u.this.VSi = false;
                    paramAnonymous2FavorPayInfo = f.dz(u.this.Vnj.VFD, u.this.Vnj.VFE);
                    u.this.Vnj.VFG = "";
                    if (!f.a(u.this.Vnj, u.this.VSk)) {
                      break label341;
                    }
                    u.this.VSi = true;
                    if (paramAnonymous2FavorPayInfo.size() != 0) {
                      break label312;
                    }
                  }
                  label295:
                  label312:
                  for (u.this.Vnj.VFG = u.9.this.val$context.getString(a.i.wallet_favor_need_bind_bankcard);; u.this.Vnj.VFG = u.9.this.val$context.getString(a.i.wallet_favor_need_change_bankcard))
                  {
                    u.this.dismiss();
                    if (u.this.VSC == null) {
                      break label341;
                    }
                    u.this.VSC.a(u.this.VRW.getText(), u.this.Vnj, u.this.VSi);
                    AppMethodBeat.o(71169);
                    return;
                    i = u.this.Nxi.hUR;
                    break;
                    paramAnonymous2FavorPayInfo = u.this.Nxi.hAT;
                    break label51;
                  }
                  label341:
                  if (u.this.VRZ != null) {
                    u.this.VRZ.setTag(u.this.Vnj);
                  }
                  Object localObject1 = u.this.VnX.bhb(u.this.Vnj.VFC);
                  double d;
                  String str1;
                  String str3;
                  String str2;
                  String str4;
                  if ((localObject1 != null) && (((com.tencent.mm.plugin.wallet.model.j)localObject1).VlE > 0.0D))
                  {
                    d = ((com.tencent.mm.plugin.wallet.model.j)localObject1).Vlw;
                    str1 = com.tencent.mm.wallet_core.ui.i.X(((com.tencent.mm.plugin.wallet.model.j)localObject1).VlD);
                    str3 = com.tencent.mm.wallet_core.ui.i.X(u.9.this.VSN.VGY.Vlu);
                    str2 = ((com.tencent.mm.plugin.wallet.model.j)localObject1).VlG;
                    paramAnonymous2FavorPayInfo = null;
                    if ((localObject1 == null) || (((com.tencent.mm.plugin.wallet.model.j)localObject1).VlF == 0)) {
                      break label660;
                    }
                    str4 = ((com.tencent.mm.plugin.wallet.model.j)localObject1).VlH;
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
                      u.this.e(str1, d);
                      u.this.bhl(str3);
                      u.this.nE(str2, paramAnonymous2FavorPayInfo);
                      u.this.bhm((String)localObject1);
                      AppMethodBeat.o(71169);
                      return;
                      d = u.9.this.VSN.VGY.Vlu;
                      str1 = com.tencent.mm.wallet_core.ui.i.X(u.9.this.VSN.VGY.Vlu);
                      paramAnonymous2FavorPayInfo = u.9.this.val$context.getString(a.i.wallet_pwd_dialog_more_favors);
                      str2 = null;
                      str3 = null;
                      break;
                      paramAnonymous2FavorPayInfo = ",".concat(String.valueOf(paramAnonymous2FavorPayInfo));
                    }
                  }
                }
              }, null);
              AppMethodBeat.o(301300);
              return;
              i = u.this.Nxi.hUR;
              break;
            }
          }
        });
        Assert.assertNotNull(this.VnX);
        this.VSb.setVisibility(8);
        AppMethodBeat.o(71194);
        return;
      }
    }
    this.VRV.setVisibility(8);
    AppMethodBeat.o(71194);
  }
  
  private void a(PayInfo paramPayInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(71190);
    this.Nxi = paramPayInfo;
    this.VSq = paramBoolean;
    if (z.bBi())
    {
      AppMethodBeat.o(71190);
      return;
    }
    Log.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
    paramPayInfo = this.VSG;
    paramPayInfo = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    boolean bool2;
    if ((paramPayInfo.ftv()) && (paramPayInfo.ftw()) && (!paramPayInfo.ftr()) && (paramPayInfo.ftq()))
    {
      this.VSF = 0;
      Log.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(this.VSF) });
      this.VSr = 0;
      this.VSl.setVisibility(8);
      this.VSm.setVisibility(8);
      this.VSu = Util.currentTicks();
      bool2 = com.tencent.mm.plugin.fingerprint.mgr.j.Hgj.Hgl;
      if ((com.tencent.mm.plugin.wallet_core.model.u.iiC() == null) || (this.VSF < 0)) {
        break label1478;
      }
    }
    label263:
    label291:
    label837:
    label1478:
    for (paramBoolean = paramPayInfo.ftC();; paramBoolean = true)
    {
      Object localObject;
      if (this.VSq)
      {
        localObject = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
        if ((((com.tencent.mm.plugin.fingerprint.c.a)localObject).type() != 1) || ((!((com.tencent.mm.plugin.fingerprint.c.a)localObject).ftq()) && (!((com.tencent.mm.plugin.fingerprint.c.a)localObject).ftt())) || (!com.tencent.mm.plugin.soter.d.b.htK()) || (!com.tencent.mm.plugin.soter.d.b.htJ()) || (com.tencent.soter.core.a.jXR() != 0)) {
          break label739;
        }
        Log.i("MicroMsg.WalletPwdDialog", "may treble init error");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 23);
        if (((com.tencent.mm.plugin.fingerprint.c.a)localObject).type() == 2)
        {
          if (com.tencent.soter.core.a.jXR() != 0) {
            break label837;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 28);
        }
        if (!paramBoolean) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 27);
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 33);
        }
      }
      label329:
      int i;
      if (!bool2)
      {
        boolean bool1 = true;
        paramBoolean &= bool1;
        if (!paramBoolean) {
          com.tencent.mm.plugin.fingerprint.mgr.j.Hgj.Hgl = true;
        }
        Log.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (((this.Nxi == null) || ((this.Nxi.YvG != 100000) && (this.Nxi.YvG != 100102))) && (paramBoolean)) {
          break label884;
        }
        Log.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(this.Nxi.YvG) });
        if (!this.mKBLayout.isShown()) {
          this.mKBLayout.setVisibility(0);
        }
        if (this.Nxi != null)
        {
          this.Nxi.VSv = 0;
          this.Nxi.hMz = "";
          this.Nxi.hMA = "";
        }
        this.VSm.setVisibility(0);
        this.VSn.setVisibility(0);
        localObject = this.VSn;
        if ((this.Nxi == null) || (this.Nxi.YvG != 100102)) {
          break label856;
        }
        i = a.i.wallet_fingerprint_severe_error_hint;
        ((TextView)localObject).setText(i);
        this.VSn.setTextColor(getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
        if (paramBoolean) {
          break label863;
        }
        this.VRZ.setVisibility(0);
        this.VSa.setVisibility(0);
      }
      for (;;)
      {
        if ((this.Nxi != null) && (this.Nxi.YvG == 100102))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acJW, Boolean.TRUE);
          paramPayInfo.vu(false);
          paramPayInfo.vv(false);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acJU, Boolean.FALSE);
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71190);
        return;
        if ((!paramPayInfo.ftD()) || (!paramPayInfo.ftE()) || (paramPayInfo.fts()) || (!paramPayInfo.ftt())) {
          break;
        }
        this.VSF = 1;
        break;
        label739:
        if (((com.tencent.mm.plugin.fingerprint.c.a)localObject).type() != 2) {
          break label263;
        }
        if (com.tencent.soter.core.a.jXR() == 1)
        {
          if (!com.tencent.soter.core.a.jXT())
          {
            Log.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 24);
            break label263;
          }
          if (paramBoolean) {
            break label263;
          }
          Log.i("MicroMsg.WalletPwdDialog", "soter treble key error");
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 25);
          break label263;
        }
        if (paramBoolean) {
          break label263;
        }
        Log.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 26);
        break label263;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 31);
        break label291;
        i = 0;
        break label329;
        label856:
        i = a.i.wallet_finger_print_not_recorded;
        break label522;
        label863:
        this.VRZ.setVisibility(8);
        this.VSa.setVisibility(8);
      }
      label884:
      if ((this.Nxi != null) && (this.Nxi.YvG == 100001)) {
        this.Nxi.VSv = 1;
      }
      if ((this.VSF >= 0) && (this.VSq) && (!ilc()))
      {
        this.VSl.setVisibility(0);
        this.VSl.setText(getContext().getString(a.i.wallet_pwd_pay_mode));
        this.VRW.setVisibility(8);
        this.mKBLayout.setVisibility(8);
        if (this.Nxi != null) {
          this.Nxi.VSv = 1;
        }
        if (this.VSF == 0)
        {
          this.VSp = 1;
          this.VSm.setVisibility(0);
          this.VSo.setVisibility(0);
          this.VRR.setText(a.i.wallet_pwd_dialog_finger_print_titile);
          ikL();
          com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(this.VSF), Boolean.valueOf(this.VSq), Boolean.valueOf(ilc()) });
        this.VSl.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71160);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (u.this.VSp == 0) {
              if (u.this.VSF == 0) {
                u.b(u.this);
              }
            }
            for (;;)
            {
              if (u.this.VSp == 1)
              {
                u.ilf();
                if (u.e(u.this)) {
                  u.f(u.this);
                }
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71160);
              return;
              u.c(u.this);
              continue;
              if (u.this.VSp == 1)
              {
                int i;
                if (u.this.Nxi == null)
                {
                  i = 0;
                  label143:
                  if (u.this.Nxi != null) {
                    break label189;
                  }
                }
                label189:
                for (paramAnonymousView = "";; paramAnonymousView = u.this.Nxi.hAT)
                {
                  ag.g(i, paramAnonymousView, 19, "");
                  u.d(u.this);
                  break;
                  i = u.this.Nxi.hUR;
                  break label143;
                }
              }
              if (u.this.VSp == 2)
              {
                u.d(u.this);
                com.tencent.mm.plugin.report.service.h.OAn.b(15817, new Object[] { Integer.valueOf(4) });
              }
            }
          }
        });
        AppMethodBeat.o(71190);
        return;
        if (this.VSF == 1)
        {
          this.VSp = 2;
          this.VSD.setVisibility(0);
          this.VRR.setText(a.i.wallet_pwd_dialog_face_id_titile);
          continue;
          if ((this.VSF >= 0) && (this.VSq) && (ilc()))
          {
            if (this.VSF == 0) {
              this.VSl.setText(getContext().getString(a.i.wallet_finger_print_pay_mode));
            }
            for (;;)
            {
              this.VSl.setVisibility(0);
              this.VSp = 0;
              this.VSm.setVisibility(8);
              this.VSD.setVisibility(8);
              this.VRW.setVisibility(0);
              if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
              }
              this.VRR.setText(a.i.wallet_pwd_dialog_titile);
              if (this.Nxi != null) {
                this.Nxi.VSv = 0;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.wallet_core.ui.i.aGA(8);
              break;
              this.VSl.setText(getContext().getString(a.i.wallet_faceid_pay_mode));
            }
          }
          if (this.Nxi != null) {
            this.Nxi.VSv = 0;
          }
          this.VSl.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    }
  }
  
  private void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(71192);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.VRZ.setOnClickListener(paramOnClickListener);
      this.VRS.setText(paramCharSequence);
      HR(this.VSj);
      if (!paramBoolean)
      {
        this.VRY.setVisibility(8);
        AppMethodBeat.o(71192);
        return;
      }
      this.VRY.setVisibility(0);
      AppMethodBeat.o(71192);
      return;
    }
    this.VRZ.setVisibility(8);
    this.VSa.setVisibility(8);
    AppMethodBeat.o(71192);
  }
  
  private static boolean a(Bankcard paramBankcard, Orders paramOrders, String paramString)
  {
    AppMethodBeat.i(71203);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(71203);
      return false;
    }
    if (VSH.containsKey(paramString))
    {
      AppMethodBeat.o(71203);
      return false;
    }
    int j;
    if ((paramOrders.VGY != null) && (paramOrders.VGY.VlI != null)) {
      if (paramOrders.VGY.VlI.Vld.size() > 0)
      {
        paramString = paramOrders.VGY.VlI.Vld.iterator();
        int i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label139;
        }
        com.tencent.mm.plugin.wallet.model.c localc = (com.tencent.mm.plugin.wallet.model.c)paramString.next();
        if ((localc.MDt == null) || (!localc.MDt.equals(paramBankcard.field_bindSerial))) {
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
      if (paramOrders.VGY.VlI.Vld.size() > 0)
      {
        AppMethodBeat.o(71203);
        return true;
      }
      if ((paramOrders.VGY.VlI.Vle != null) && (paramOrders.VGY.VlI.Vle.VlU.size() > 0))
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
    return (paramPayInfo != null) && ((paramPayInfo.hUR == 31) || (paramPayInfo.hUR == 32) || (paramPayInfo.hUR == 33));
  }
  
  private void b(final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71196);
    if (this.KDS == null)
    {
      AppMethodBeat.o(71196);
      return;
    }
    this.mOnCancelListener = paramOnCancelListener;
    this.KDS.setVisibility(0);
    this.KDS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71171);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(null);
        }
        if (u.this.VSE != null) {
          u.this.VSE.gvz();
        }
        u.this.cancel();
        if (u.this.VSl.isShown()) {
          com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71171);
          return;
          com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    });
    AppMethodBeat.o(71196);
  }
  
  private void bhj(String paramString)
  {
    AppMethodBeat.i(71185);
    this.OYJ.setText(paramString);
    AppMethodBeat.o(71185);
  }
  
  private void bhk(String paramString)
  {
    AppMethodBeat.i(71187);
    if (!TextUtils.isEmpty(paramString))
    {
      this.VSc.setVisibility(0);
      this.VSc.setText(paramString);
      AppMethodBeat.o(71187);
      return;
    }
    Log.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.VSc.setVisibility(8);
    AppMethodBeat.o(71187);
  }
  
  private void cf(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(71198);
    if (this.VRT != null)
    {
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        this.VRT.setWording(paramLinkedList);
        this.VRT.setVisibility(0);
        AppMethodBeat.o(71198);
        return;
      }
      this.VRT.setVisibility(8);
    }
    AppMethodBeat.o(71198);
  }
  
  private void ikL()
  {
    AppMethodBeat.i(71178);
    com.tencent.mm.plugin.soter.model.a.htx();
    final rg localrg = new rg();
    localrg.hUl.hMy = this.Nxi.hAT;
    localrg.hUl.hUn = 1;
    localrg.hUl.hUp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71168);
        Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        rg.b localb = localrg.hUm;
        if (localb == null)
        {
          u.this.Nxi.VSv = 0;
          Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71168);
          return;
        }
        int j = localb.errCode;
        Log.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.errMsg });
        int i;
        if (j == 0)
        {
          Log.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.hUq });
          if (u.this.Nxi == null) {
            i = 0;
          }
          for (;;)
          {
            Object localObject1;
            if (u.this.Nxi == null)
            {
              localObject1 = "";
              ag.g(i, (String)localObject1, 22, "");
              u.this.Nxi.VSv = 1;
              u.this.Nxi.hMz = localb.hMz;
              u.this.Nxi.hMA = localb.hMA;
            }
            try
            {
              localObject1 = new JSONObject(((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).ftu());
              ((JSONObject)localObject1).put("soter_type", com.tencent.mm.plugin.wallet_core.model.u.iiC().ijm());
              u.this.Nxi.hUq = ((JSONObject)localObject1).toString();
              u.this.Nxi.hMx = localb.hMx;
              localObject1 = u.this.Nxi;
              ((PayInfo)localObject1).VSw += 1;
              u.this.VSn.setText("");
              u.this.ilb();
              com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.plugin.soter.model.a.amP(0);
              AppMethodBeat.o(71168);
              return;
              i = u.this.Nxi.hUR;
              continue;
              localObject1 = u.this.Nxi.hAT;
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
        if (u.this.Nxi == null)
        {
          i = 0;
          if (u.this.Nxi != null) {
            break label852;
          }
          localObject2 = "";
          ag.g(i, (String)localObject2, 23, "");
          u.this.Nxi.VSv = 0;
          u.this.VSm.setVisibility(0);
          u.this.VSn.setTextColor(u.this.getContext().getResources().getColor(a.c.red));
          u.this.VSn.setText(a.i.wallet_finger_print_fail);
          i = (int)(System.currentTimeMillis() / 1000L);
          k = i - u.g(u.this);
          if (k > 1)
          {
            u.a(u.this, i);
            u.h(u.this);
            localObject2 = u.this.Nxi;
            ((PayInfo)localObject2).VSw += 1;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
          if ((j != 2) && (j != 10308)) {
            break label867;
          }
          bool1 = true;
          label638:
          if (localb.hUr != 2) {
            break label873;
          }
        }
        label852:
        label867:
        label873:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(u.i(u.this)), Integer.valueOf(j), Boolean.valueOf(bool2) });
          if (((!bool2) && ((u.i(u.this) >= 3) || (k <= 1))) || (bool1)) {
            break label879;
          }
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
          if (u.j(u.this) == null) {
            u.a(u.this, com.tencent.mm.ui.anim.a.jV(u.this.getContext()));
          }
          u.this.VSo.setVisibility(8);
          u.this.VSn.setVisibility(4);
          u.j(u.this).reset();
          u.j(u.this).setAnimationListener(new Animation.AnimationListener()
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
                  u.this.VSn.setVisibility(8);
                  u.this.VSo.setVisibility(0);
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
                  u.this.VSn.setVisibility(0);
                  AppMethodBeat.o(71164);
                }
              });
              AppMethodBeat.o(71166);
            }
          });
          u.this.VSn.startAnimation(u.j(u.this));
          com.tencent.mm.plugin.soter.model.a.amP(1);
          AppMethodBeat.o(71168);
          return;
          i = u.this.Nxi.hUR;
          break;
          localObject2 = u.this.Nxi.hAT;
          break label434;
          bool1 = false;
          break label638;
        }
        label879:
        if ((u.i(u.this) >= 3) || (bool1))
        {
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
          u.ilf();
          u.this.VSp = 0;
          u.k(u.this);
          u.this.VSl.setVisibility(8);
          u.this.VSm.setVisibility(8);
          u.this.VSn.setVisibility(0);
          u.this.VSn.setText(a.i.wallet_finger_print_not_recorded);
          u.this.VSn.setTextColor(u.this.getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
          u.this.VRR.setText(a.i.wallet_pwd_dialog_titile);
          u.this.VRW.setVisibility(0);
          if (!u.this.mKBLayout.isShown()) {
            u.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.model.a.amP(2);
          u.HT(true);
        }
        AppMethodBeat.o(71168);
      }
    };
    localrg.publish();
    AppMethodBeat.o(71178);
  }
  
  private static void ikM()
  {
    AppMethodBeat.i(71179);
    Log.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).userCancel();
    AppMethodBeat.o(71179);
  }
  
  private void ila()
  {
    AppMethodBeat.i(71177);
    if (this.VSp == 1) {
      this.VSl.setText(a.i.wallet_finger_print_pay_mode);
    }
    for (;;)
    {
      this.VSp = 0;
      this.VSu = Util.currentTicks();
      this.VSm.setVisibility(8);
      this.VSD.setVisibility(8);
      this.VRW.setVisibility(0);
      if (!this.mKBLayout.isShown()) {
        this.mKBLayout.setVisibility(0);
      }
      this.VRR.setText(a.i.wallet_pwd_dialog_titile);
      HP(true);
      this.Nxi.VSv = 0;
      com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.i.aGA(29);
      ikM();
      AppMethodBeat.o(71177);
      return;
      this.VSl.setText(a.i.wallet_faceid_pay_mode);
    }
  }
  
  private static boolean ilc()
  {
    AppMethodBeat.i(71209);
    com.tencent.mm.kernel.h.baF();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acJQ, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71209);
      return bool;
    }
  }
  
  private void k(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71191);
    if (paramBankcard == null)
    {
      Log.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.ihV())
    {
      this.VRU.setImageResource(a.e.wallet_balance_manager_logo_small);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.ihW())
    {
      this.VjO.a(paramBankcard, this.VRU);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.ihZ())
    {
      this.VRU.setImageDrawable(com.tencent.mm.svg.a.a.i(getContext().getResources(), a.h.honey_pay_bank_logo));
      if (!Util.isNullOrNil(paramBankcard.VDG))
      {
        this.VRU.setUseSdcardCache(true);
        this.VRU.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.ikk());
        this.VRU.iz(paramBankcard.VDG, a.h.honey_pay_bank_logo);
        AppMethodBeat.o(71191);
      }
    }
    else
    {
      this.VjO.a(getContext(), paramBankcard, this.VRU);
    }
    AppMethodBeat.o(71191);
  }
  
  public final void bhl(String paramString)
  {
    AppMethodBeat.i(71189);
    if (!TextUtils.isEmpty(paramString))
    {
      this.Voi.setVisibility(0);
      this.Voi.setText(paramString);
      AppMethodBeat.o(71189);
      return;
    }
    this.Voi.setVisibility(8);
    AppMethodBeat.o(71189);
  }
  
  public final void bhm(String paramString)
  {
    AppMethodBeat.i(71199);
    if (!Util.isNullOrNil(paramString))
    {
      this.VSd.setText(paramString);
      this.VSd.setVisibility(0);
      AppMethodBeat.o(71199);
      return;
    }
    this.VSd.setVisibility(8);
    AppMethodBeat.o(71199);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(71184);
    try
    {
      super.dismiss();
      ikM();
      this.VjO.destory();
      if (this.HgQ != null) {
        this.HgQ.cancel();
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
      this.Oqd.setVisibility(0);
      this.Oqd.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.VSj = false;
        HR(this.VSj);
        AppMethodBeat.o(71186);
        return;
      }
      HR(this.VSj);
      AppMethodBeat.o(71186);
      return;
    }
    this.Oqd.setVisibility(8);
    this.VSj = true;
    HR(this.VSj);
    AppMethodBeat.o(71186);
  }
  
  protected final void ilb()
  {
    AppMethodBeat.i(71195);
    HP(false);
    if (this.VSh != null) {
      this.VSh.onClick(this, 0);
    }
    dismiss();
    if (this.VSC != null) {
      this.VSC.a(this.VRW.getText(), this.Vnj, this.VSi);
    }
    if (this.VSu < 0L)
    {
      Log.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71195);
      return;
    }
    if (this.VSp == 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(686L, 1L, Util.ticksToNow(this.VSu), false);
      AppMethodBeat.o(71195);
      return;
    }
    if (this.VSp == 1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(686L, 3L, Util.ticksToNow(this.VSu), false);
    }
    AppMethodBeat.o(71195);
  }
  
  public final void nE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71188);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.VRV.setVisibility(0);
      this.VRV.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.VSf.setText(paramString1);
      this.VSf.setVisibility(0);
      AppMethodBeat.o(71188);
      return;
      this.VRV.setVisibility(8);
    }
    this.VSf.setVisibility(8);
    AppMethodBeat.o(71188);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71207);
    this.isPaused = true;
    if (z.bBi())
    {
      AppMethodBeat.o(71207);
      return;
    }
    if (this.VSp == 1) {
      ila();
    }
    AppMethodBeat.o(71207);
  }
  
  public final void onActivityResume()
  {
    AppMethodBeat.i(71206);
    this.isPaused = false;
    if (z.bBi())
    {
      AppMethodBeat.o(71206);
      return;
    }
    AppMethodBeat.o(71206);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71182);
    super.onCreate(paramBundle);
    setContentView(this.plc);
    com.tencent.soter.a.g.f.jYD().jYE();
    AppMethodBeat.o(71182);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71181);
    if (paramInt == 4)
    {
      if (this.mOnCancelListener != null) {
        this.mOnCancelListener.onCancel(this);
      }
      if (this.VSE != null) {
        this.VSE.gvz();
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(71181);
    return bool;
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(71183);
    super.setCancelable(paramBoolean);
    this.dqR = paramBoolean;
    setCanceledOnTouchOutside(this.dqR);
    AppMethodBeat.o(71183);
  }
  
  public static abstract interface a
  {
    public abstract void gvz();
  }
  
  static final class b
    implements DialogInterface.OnCancelListener
  {
    private DialogInterface.OnCancelListener VSP = null;
    
    private b(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.VSP = paramOnCancelListener;
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(71172);
      u.HT(false);
      if (this.VSP != null) {
        this.VSP.onCancel(paramDialogInterface);
      }
      AppMethodBeat.o(71172);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.u
 * JD-Core Version:    0.7.0.1
 */