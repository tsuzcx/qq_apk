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
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ow.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.wallet.a.c;
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
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  private static HashMap<String, Boolean> IjK;
  protected PayInfo BDB;
  public TextView CKk;
  public TextView CuI;
  protected com.tencent.mm.plugin.wallet_core.utils.a HCH;
  protected d HGS;
  protected FavorPayInfo HGf;
  public TextView HHd;
  public ImageView Igh;
  public TextView IiV;
  public TextView IiW;
  public FavourLayout IiX;
  public CdnImageView IiY;
  public TextView IiZ;
  boolean IjA;
  public c IjF;
  public Button IjG;
  protected a IjH;
  protected int IjI;
  private byte[] IjJ;
  public EditHintPasswdView Ija;
  public View Ijc;
  public View Ijd;
  public TextView Ije;
  public ImageView Ijf;
  public TextView Ijg;
  public TextView Ijh;
  public View Iji;
  public TextView Ijj;
  protected DialogInterface.OnClickListener Ijl;
  protected boolean Ijm;
  protected boolean Ijn;
  public Bankcard Ijo;
  public TextView Ijp;
  public View Ijq;
  public TextView Ijr;
  protected int Ijs;
  protected boolean Ijt;
  private int Iju;
  private Animation Ijv;
  private String Ijw;
  private long Ijx;
  protected DialogInterface.OnCancelListener XY;
  private boolean isPaused;
  public View jBN;
  public ImageView keC;
  private Context mContext;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected boolean ox;
  private int wFZ;
  private Animation wGp;
  public ImageView zfh;
  
  static
  {
    AppMethodBeat.i(71219);
    IjK = new HashMap();
    AppMethodBeat.o(71219);
  }
  
  public s(Context paramContext)
  {
    super(paramContext, 2131821776);
    AppMethodBeat.i(71173);
    this.HGS = null;
    this.HGf = new FavorPayInfo();
    this.Ijm = false;
    this.Ijn = true;
    this.Ijo = null;
    this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.Ijs = 0;
    this.IjI = -1;
    this.Ijt = false;
    this.Iju = 0;
    this.wFZ = 0;
    this.Ijv = null;
    this.Ijw = "";
    this.Ijx = -1L;
    this.IjJ = new byte[0];
    this.IjA = false;
    this.isPaused = false;
    bh(paramContext);
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
    locals.c(paramOnCancelListener);
    locals.setOnCancelListener(paramOnCancelListener);
    locals.setCancelable(true);
    locals.aVR(paramString1);
    locals.d(com.tencent.mm.wallet_core.ui.f.d(paramDouble, paramString2), paramDouble);
    locals.Ijn = true;
    if (paramBankcard == null)
    {
      paramString1 = "";
      locals.i(paramBankcard);
      if (TextUtils.isEmpty(paramString1)) {
        break label157;
      }
    }
    for (;;)
    {
      locals.ys(bool);
      if (paramBankcard != null) {
        locals.a(paramString1, paramOnClickListener, false);
      }
      locals.IjF = paramc;
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
    locals.c(paramOnCancelListener);
    locals.setOnCancelListener(paramOnCancelListener);
    locals.setCancelable(true);
    locals.aVR(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      locals.CuI.setVisibility(0);
      locals.CuI.setText(paramString2);
    }
    for (;;)
    {
      locals.Ijn = true;
      locals.yr(locals.Ijn);
      locals.ys(false);
      locals.Ijn = false;
      locals.IjH = parama;
      locals.aVS("");
      locals.IjF = paramc;
      locals.show();
      com.tencent.mm.ui.base.h.a(paramContext, locals);
      AppMethodBeat.o(71204);
      return locals;
      locals.CuI.setVisibility(8);
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
    if ((paramOrders == null) || (paramOrders.HZd == null) || (paramOrders.HZd.size() <= 0))
    {
      AppMethodBeat.o(71201);
      return null;
    }
    d locald = e.IcT.a(paramOrders);
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
      Log.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { paramFavorPayInfo.HXI, Boolean.valueOf(bool1) });
      String str1 = locald.cG(paramFavorPayInfo.HXI, bool1);
      Log.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str1 });
      localObject2 = locald.aVH(str1);
      localObject1 = locald.cF(str1, true);
      Object localObject4 = (d.a)((Map)localObject2).get(paramBankcard.field_bindSerial);
      Object localObject5 = (d.a)((Map)localObject1).get(paramBankcard.field_bankcardType);
      Object localObject6 = locald.cE(str1, bool1);
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
        if ((localObject4 == null) || (((d.a)localObject4).IcR == null) || (Util.isNullOrNil(((d.a)localObject4).IcR.HEJ))) {
          break label1170;
        }
        paramFavorPayInfo.HXI = ((d.a)localObject4).IcR.HEJ;
        localObject1 = locald.fSz();
        localObject5 = paramFavorPayInfo;
        localObject2 = "";
        if (paramPayInfo.iqp != null) {
          break label1284;
        }
        paramFavorPayInfo = "";
        if (Util.isNullOrNil(paramFavorPayInfo)) {
          break label1301;
        }
        if ((!Util.isNullOrNil(paramFavorPayInfo)) || (paramOrders == null) || (paramOrders.HZd == null)) {
          break label2008;
        }
        localObject2 = (Orders.Commodity)paramOrders.HZd.get(0);
        if (localObject2 == null) {
          break label2043;
        }
        paramString = ((Orders.Commodity)localObject2).AOa;
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
        d1 = paramOrders.dDO;
        bool2 = false;
        bool1 = false;
        if ((locald == null) || (localObject5 == null)) {
          break label2188;
        }
        localObject6 = locald.aVJ(((FavorPayInfo)localObject5).HXI);
        if ((localObject6 == null) || (((j)localObject6).HEA <= 0.0D)) {
          break label2055;
        }
        bool1 = true;
        localObject4 = com.tencent.mm.wallet_core.ui.f.d(paramOrders.dDO, paramOrders.AOl);
        localObject1 = com.tencent.mm.wallet_core.ui.f.d(((j)localObject6).HEz, paramOrders.AOl);
        d1 = ((j)localObject6).HEs;
        str1 = ((j)localObject6).HEC;
        if (IjK.containsKey(paramPayInfo.dDL)) {
          break label2183;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(14530, new Object[] { Integer.valueOf(3) });
        paramFavorPayInfo = null;
        localObject2 = paramString;
        if (localObject6 != null)
        {
          localObject2 = paramString;
          if (((j)localObject6).HEB != 0)
          {
            paramString = ((j)localObject6).HED;
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
        if (paramOrders.CoZ > 0.0D) {}
        for (localObject1 = paramContext.getResources().getString(2131767631, new Object[] { com.tencent.mm.wallet_core.ui.f.d(paramOrders.CoZ, paramOrders.AOl) });; localObject1 = null)
        {
          if (paramBankcard == null)
          {
            paramFavorPayInfo = "";
            label861:
            localObject2 = paramFavorPayInfo;
            if (paramBankcard != null)
            {
              localObject2 = paramFavorPayInfo;
              if (paramBankcard.fQf()) {
                localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, paramFavorPayInfo);
              }
            }
            paramFavorPayInfo = new s(paramContext);
            paramFavorPayInfo.a(paramContext, paramOrders, (FavorPayInfo)localObject5, paramBankcard);
            paramFavorPayInfo.ys(paramBoolean);
            paramFavorPayInfo.Ijn = paramBoolean;
            paramFavorPayInfo.c(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setOnCancelListener(new b(paramOnCancelListener, (byte)0));
            paramFavorPayInfo.setCancelable(true);
            paramFavorPayInfo.aVR((String)localObject3);
            paramFavorPayInfo.d(localObject8, d2);
            paramFavorPayInfo.aVT(localObject7);
            paramFavorPayInfo.a((CharSequence)localObject2, new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(71156);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                s.fTk().put(this.AKL.dDL, Boolean.TRUE);
                paramOnClickListener.onClick(paramAnonymousView);
                if (paramFavorPayInfo.IjA) {
                  com.tencent.mm.plugin.report.service.h.CyF.a(14530, new Object[] { Integer.valueOf(2) });
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71156);
              }
            }, bool2);
            paramFavorPayInfo.i(paramBankcard);
            if (paramOrders.HZa != 1) {
              break label2164;
            }
            paramBoolean = true;
            label1005:
            paramFavorPayInfo.a(paramPayInfo, paramBoolean);
            paramFavorPayInfo.lv(str2, paramString);
            paramFavorPayInfo.aVU((String)localObject6);
            paramFavorPayInfo.aVS((String)localObject1);
            paramFavorPayInfo.IjF = paramc;
            paramFavorPayInfo.bx(a(paramBankcard, paramOrders));
            if (!a(paramBankcard, paramOrders, paramPayInfo.dDL)) {
              break label2169;
            }
            paramFavorPayInfo.yq(true);
            com.tencent.mm.plugin.report.service.h.CyF.a(14530, new Object[] { Integer.valueOf(1) });
          }
          for (;;)
          {
            paramFavorPayInfo.show();
            com.tencent.mm.ui.ao.e(paramFavorPayInfo.getWindow());
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
            localObject1 = ((j)localObject6).HEJ;
            break label288;
            label1150:
            localObject2 = ((d.a)localObject4).toString();
            break label297;
            localObject3 = ((d.a)localObject5).toString();
            break label306;
            if ((localObject5 != null) && (((d.a)localObject5).IcR != null) && (!Util.isNullOrNil(((d.a)localObject5).IcR.HEJ)))
            {
              paramFavorPayInfo.HXI = ((d.a)localObject5).IcR.HEJ;
              break label373;
            }
            if (localObject6 != null)
            {
              paramFavorPayInfo.HXI = ((j)localObject6).HEJ;
              break label373;
            }
            paramFavorPayInfo.HXI = str1;
            break label373;
            label1238:
            if (paramOrders.HZe == null) {
              break label373;
            }
            paramFavorPayInfo = locald.aVM(locald.aVN(paramOrders.HZe.HEt));
            break label373;
            label1266:
            Log.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            localObject1 = null;
            localObject5 = paramFavorPayInfo;
            break label383;
            paramFavorPayInfo = paramPayInfo.iqp.getString("extinfo_key_19", "");
            break label398;
            if ((paramPayInfo.dVv == 32) || (paramPayInfo.dVv == 33))
            {
              str1 = paramPayInfo.iqp.getString("extinfo_key_5", "");
              localObject4 = paramPayInfo.iqp.getString("extinfo_key_1", "");
              localObject3 = paramContext.getString(2131768199);
              paramFavorPayInfo = (FavorPayInfo)localObject2;
              if (!Util.isNullOrNil(str1))
              {
                localObject3 = str1;
                paramFavorPayInfo = str1;
              }
              if (!Util.isNullOrNil((String)localObject4))
              {
                g.aAi();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ((String)localObject4);
                if (localObject2 != null)
                {
                  paramFavorPayInfo = ((as)localObject2).arJ();
                  localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bpz(paramFavorPayInfo));
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
            if (paramPayInfo.dVv == 31)
            {
              paramFavorPayInfo = paramPayInfo.iqp.getString("extinfo_key_1", "");
              if (!Util.isNullOrNil(paramFavorPayInfo))
              {
                g.aAi();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((as)localObject3).arI();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (Util.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131768199, new Object[] { paramFavorPayInfo });
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
            if (paramPayInfo.dVv == 42)
            {
              paramFavorPayInfo = paramPayInfo.iqp.getString("extinfo_key_1", "");
              if (!Util.isNullOrNil(paramFavorPayInfo))
              {
                g.aAi();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(paramFavorPayInfo);
                if (localObject3 != null)
                {
                  paramFavorPayInfo = ((as)localObject3).arI();
                  localObject2 = new StringBuilder().append(paramFavorPayInfo);
                  if (Util.isNullOrNil(paramString)) {}
                  for (paramFavorPayInfo = "";; paramFavorPayInfo = "(" + paramString + ")")
                  {
                    paramFavorPayInfo = paramContext.getString(2131768192, new Object[] { paramFavorPayInfo });
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
            if (paramPayInfo.dVv == 48)
            {
              paramFavorPayInfo = paramContext.getString(2131764111);
              break label405;
            }
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            if (paramPayInfo.dVv != 49) {
              break label405;
            }
            paramFavorPayInfo = paramPayInfo.iqp.getString("extinfo_key_1", "");
            if (!Util.isNullOrNil(paramFavorPayInfo))
            {
              paramFavorPayInfo = paramContext.getString(2131768199, new Object[] { paramFavorPayInfo });
              break label405;
            }
            Log.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(paramPayInfo.dVv) });
            paramFavorPayInfo = (FavorPayInfo)localObject2;
            break label405;
            label2008:
            paramString = new StringBuilder("orders null?:");
            if (paramOrders == null) {}
            for (bool1 = true;; bool1 = false)
            {
              Log.w("MicroMsg.WalletPwdDialog", bool1);
              label2043:
              localObject3 = paramFavorPayInfo;
              break;
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = com.tencent.mm.wallet_core.ui.f.d(((j)localObject6).HEz, paramOrders.AOl);
              bool1 = true;
              paramFavorPayInfo = paramContext.getString(2131768195);
              break label684;
            }
            localObject1 = com.tencent.mm.wallet_core.ui.f.d(paramOrders.dDO, paramOrders.AOl);
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
            paramFavorPayInfo.yq(false);
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
    if ((paramOrders != null) && (paramOrders.HZe != null) && (paramOrders.HZe.HEE != null))
    {
      paramOrders = paramOrders.HZe.HEE.HDZ.iterator();
      while (paramOrders.hasNext())
      {
        c localc = (c)paramOrders.next();
        if (localc.ANo.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.HEk.iterator();
          while (paramBankcard.hasNext())
          {
            paramOrders = (com.tencent.mm.plugin.wallet.a.d)paramBankcard.next();
            if (paramOrders.HEl != 0) {
              localLinkedList.add(paramOrders.Coh);
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
    this.BDB = ???;
    this.Ijt = paramBoolean;
    if (z.aUo())
    {
      AppMethodBeat.o(71190);
      return;
    }
    Log.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
    synchronized (this.IjJ)
    {
      ??? = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
    }
    boolean bool2;
    if ((!???.dJP()) && (???.dJO()))
    {
      this.IjI = 0;
      Log.i("MicroMsg.WalletPwdDialog", "bio mode: %s", new Object[] { Integer.valueOf(this.IjI) });
      this.Iju = 0;
      this.Ijp.setVisibility(8);
      this.Ijq.setVisibility(8);
      this.Ijx = Util.currentTicks();
      bool2 = p.wFK.wFM;
      if ((t.fQI() == null) || (this.IjI < 0)) {
        break label1500;
      }
    }
    label266:
    label294:
    label332:
    label858:
    label1500:
    for (paramBoolean = ???.dKa();; paramBoolean = true)
    {
      Object localObject1;
      if (this.Ijt)
      {
        localObject1 = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if ((((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() != 1) || ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).dJO()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject1).dJR())) || (!com.tencent.mm.plugin.soter.e.b.flX()) || (!com.tencent.mm.plugin.soter.e.b.flW()) || (com.tencent.soter.core.a.hlf() != 0)) {
          break label757;
        }
        Log.i("MicroMsg.WalletPwdDialog", "may treble init error");
        com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 23);
        if (((com.tencent.mm.plugin.fingerprint.d.a)localObject1).type() == 2)
        {
          if (com.tencent.soter.core.a.hlf() != 0) {
            break label858;
          }
          com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 28);
        }
        if (!paramBoolean) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 27);
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 33);
        }
      }
      int i;
      if (!bool2)
      {
        boolean bool1 = true;
        paramBoolean &= bool1;
        if (!paramBoolean) {
          p.wFK.wFM = true;
        }
        Log.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (((this.BDB == null) || ((this.BDB.Kxu != 100000) && (this.BDB.Kxu != 100102))) && (paramBoolean)) {
          break label905;
        }
        Log.i("MicroMsg.WalletPwdDialog", "errCode: %s", new Object[] { Integer.valueOf(this.BDB.Kxu) });
        if (!this.mKBLayout.isShown()) {
          this.mKBLayout.setVisibility(0);
        }
        if (this.BDB != null)
        {
          this.BDB.Ijy = 0;
          this.BDB.dNR = "";
          this.BDB.dNS = "";
        }
        this.Ijq.setVisibility(0);
        this.Ijr.setVisibility(0);
        localObject1 = this.Ijr;
        if ((this.BDB == null) || (this.BDB.Kxu != 100102)) {
          break label877;
        }
        i = 2131767713;
        ((TextView)localObject1).setText(i);
        this.Ijr.setTextColor(getContext().getResources().getColor(2131101376));
        if (paramBoolean) {
          break label884;
        }
        this.Ijd.setVisibility(0);
        this.Ije.setVisibility(0);
      }
      for (;;)
      {
        if ((this.BDB != null) && (this.BDB.Kxu == 100102))
        {
          g.aAh().azQ().set(ar.a.NUC, Boolean.TRUE);
          ???.pj(false);
          ???.pk(false);
          g.aAh().azQ().set(ar.a.NUA, Boolean.FALSE);
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(71190);
        return;
        localObject2 = finally;
        AppMethodBeat.o(71190);
        throw localObject2;
        if ((!???.dKb()) || (!???.dKc()) || (???.dJQ()) || (!???.dJR())) {
          break;
        }
        this.IjI = 1;
        break;
        label757:
        if (localObject2.type() != 2) {
          break label266;
        }
        if (com.tencent.soter.core.a.hlf() == 1)
        {
          if (!com.tencent.soter.core.a.hlh())
          {
            Log.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
            com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 24);
            break label266;
          }
          if (paramBoolean) {
            break label266;
          }
          Log.i("MicroMsg.WalletPwdDialog", "soter treble key error");
          com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 25);
          break label266;
        }
        if (paramBoolean) {
          break label266;
        }
        Log.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
        com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 26);
        break label266;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 31);
        break label294;
        i = 0;
        break label332;
        label877:
        i = 2131767706;
        break label527;
        label884:
        this.Ijd.setVisibility(8);
        this.Ije.setVisibility(8);
      }
      if ((this.BDB != null) && (this.BDB.Kxu == 100001)) {
        this.BDB.Ijy = 1;
      }
      if ((this.IjI >= 0) && (this.Ijt) && (!fTf()))
      {
        this.Ijp.setVisibility(0);
        this.Ijp.setText(getContext().getString(2131768203));
        this.Ija.setVisibility(8);
        this.mKBLayout.setVisibility(8);
        if (this.BDB != null) {
          this.BDB.Ijy = 1;
        }
        if (this.IjI == 0)
        {
          this.Ijs = 1;
          this.Ijq.setVisibility(0);
          this.Igh.setVisibility(0);
          this.IiV.setText(2131768194);
          fSO();
          com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", new Object[] { Integer.valueOf(this.IjI), Boolean.valueOf(this.Ijt), Boolean.valueOf(fTf()) });
        this.Ijp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71160);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (s.this.Ijs == 0) {
              if (s.this.IjI == 0) {
                s.b(s.this);
              }
            }
            for (;;)
            {
              if (s.this.Ijs == 1)
              {
                s.fTj();
                if (s.e(s.this)) {
                  s.f(s.this);
                }
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71160);
              return;
              s.c(s.this);
              continue;
              if (s.this.Ijs == 1)
              {
                int i;
                if (s.this.BDB == null)
                {
                  i = 0;
                  label143:
                  if (s.this.BDB != null) {
                    break label189;
                  }
                }
                label189:
                for (paramAnonymousView = "";; paramAnonymousView = s.this.BDB.dDL)
                {
                  af.f(i, paramAnonymousView, 19, "");
                  s.d(s.this);
                  break;
                  i = s.this.BDB.dVv;
                  break label143;
                }
              }
              if (s.this.Ijs == 2)
              {
                s.d(s.this);
                com.tencent.mm.plugin.report.service.h.CyF.a(15817, new Object[] { Integer.valueOf(4) });
              }
            }
          }
        });
        AppMethodBeat.o(71190);
        return;
        if (this.IjI == 1)
        {
          this.Ijs = 2;
          this.IjG.setVisibility(0);
          this.IiV.setText(2131768193);
          continue;
          if ((this.IjI >= 0) && (this.Ijt) && (fTf()))
          {
            if (this.IjI == 0) {
              this.Ijp.setText(getContext().getString(2131767707));
            }
            for (;;)
            {
              this.Ijp.setVisibility(0);
              this.Ijs = 0;
              this.Ijq.setVisibility(8);
              this.IjG.setVisibility(8);
              this.Ija.setVisibility(0);
              if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
              }
              this.IiV.setText(2131768200);
              if (this.BDB != null) {
                this.BDB.Ijy = 0;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.wallet_core.ui.f.aqm(8);
              break;
              this.Ijp.setText(getContext().getString(2131767699));
            }
          }
          if (this.BDB != null) {
            this.BDB.Ijy = 0;
          }
          this.Ijp.setVisibility(8);
          com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
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
    if (IjK.containsKey(paramString))
    {
      AppMethodBeat.o(71203);
      return false;
    }
    int j;
    if ((paramOrders.HZe != null) && (paramOrders.HZe.HEE != null)) {
      if (paramOrders.HZe.HEE.HDZ.size() > 0)
      {
        paramString = paramOrders.HZe.HEE.HDZ.iterator();
        int i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label139;
        }
        c localc = (c)paramString.next();
        if ((localc.ANo == null) || (!localc.ANo.equals(paramBankcard.field_bindSerial))) {
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
      if (paramOrders.HZe.HEE.HDZ.size() > 0)
      {
        AppMethodBeat.o(71203);
        return true;
      }
      if ((paramOrders.HZe.HEE.HEa != null) && (paramOrders.HZe.HEE.HEa.HEQ.size() > 0))
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
    return (paramPayInfo != null) && ((paramPayInfo.dVv == 31) || (paramPayInfo.dVv == 32) || (paramPayInfo.dVv == 33));
  }
  
  private void aVS(String paramString)
  {
    AppMethodBeat.i(71187);
    if (!TextUtils.isEmpty(paramString))
    {
      this.Ijg.setVisibility(0);
      this.Ijg.setText(paramString);
      AppMethodBeat.o(71187);
      return;
    }
    Log.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
    this.Ijg.setVisibility(8);
    AppMethodBeat.o(71187);
  }
  
  private void bx(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(71198);
    if (this.IiX != null)
    {
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        this.IiX.setWording(paramLinkedList);
        this.IiX.setVisibility(0);
        AppMethodBeat.o(71198);
        return;
      }
      this.IiX.setVisibility(8);
    }
    AppMethodBeat.o(71198);
  }
  
  private void fSO()
  {
    AppMethodBeat.i(71178);
    com.tencent.mm.plugin.soter.d.a.flK();
    final ow localow = new ow();
    localow.dUQ.dNQ = this.BDB.dDL;
    localow.dUQ.dUS = 1;
    localow.dUQ.dUU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71168);
        Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        ow.b localb = localow.dUR;
        if (localb == null)
        {
          s.this.BDB.Ijy = 0;
          Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71168);
          return;
        }
        int j = localb.errCode;
        Log.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.errMsg });
        int i;
        if (j == 0)
        {
          Log.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dUV });
          if (s.this.BDB == null) {
            i = 0;
          }
          for (;;)
          {
            Object localObject1;
            if (s.this.BDB == null)
            {
              localObject1 = "";
              af.f(i, (String)localObject1, 22, "");
              s.this.BDB.Ijy = 1;
              s.this.BDB.dNR = localb.dNR;
              s.this.BDB.dNS = localb.dNS;
            }
            try
            {
              localObject1 = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).dJS());
              ((JSONObject)localObject1).put("soter_type", t.fQI().fRq());
              s.this.BDB.dUV = ((JSONObject)localObject1).toString();
              s.this.BDB.dNP = localb.dNP;
              localObject1 = s.this.BDB;
              ((PayInfo)localObject1).Ijz += 1;
              s.this.Ijr.setText("");
              s.this.fTe();
              com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.plugin.soter.d.a.aau(0);
              AppMethodBeat.o(71168);
              return;
              i = s.this.BDB.dVv;
              continue;
              localObject1 = s.this.BDB.dDL;
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
        if (s.this.BDB == null)
        {
          i = 0;
          if (s.this.BDB != null) {
            break label849;
          }
          localObject2 = "";
          af.f(i, (String)localObject2, 23, "");
          s.this.BDB.Ijy = 0;
          s.this.Ijq.setVisibility(0);
          s.this.Ijr.setTextColor(s.this.getContext().getResources().getColor(2131100994));
          s.this.Ijr.setText(2131767705);
          i = (int)(System.currentTimeMillis() / 1000L);
          k = i - s.g(s.this);
          if (k > 1)
          {
            s.a(s.this, i);
            s.h(s.this);
            localObject2 = s.this.BDB;
            ((PayInfo)localObject2).Ijz += 1;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
          if ((j != 2) && (j != 10308)) {
            break label864;
          }
          bool1 = true;
          label636:
          if (localb.dUW != 2) {
            break label870;
          }
        }
        label849:
        label864:
        label870:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(s.i(s.this)), Integer.valueOf(j), Boolean.valueOf(bool2) });
          if (((!bool2) && ((s.i(s.this) >= 3) || (k <= 1))) || (bool1)) {
            break label876;
          }
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
          if (s.j(s.this) == null) {
            s.a(s.this, com.tencent.mm.ui.c.a.he(s.this.getContext()));
          }
          s.this.Igh.setVisibility(8);
          s.this.Ijr.setVisibility(4);
          s.j(s.this).reset();
          s.j(s.this).setAnimationListener(new Animation.AnimationListener()
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
                  s.this.Ijr.setVisibility(8);
                  s.this.Igh.setVisibility(0);
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
                  s.this.Ijr.setVisibility(0);
                  AppMethodBeat.o(71164);
                }
              });
              AppMethodBeat.o(71166);
            }
          });
          s.this.Ijr.startAnimation(s.j(s.this));
          com.tencent.mm.plugin.soter.d.a.aau(1);
          AppMethodBeat.o(71168);
          return;
          i = s.this.BDB.dVv;
          break;
          localObject2 = s.this.BDB.dDL;
          break label434;
          bool1 = false;
          break label636;
        }
        label876:
        if ((s.i(s.this) >= 3) || (bool1))
        {
          Log.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
          s.fTj();
          s.this.Ijs = 0;
          s.k(s.this);
          s.this.Ijp.setVisibility(8);
          s.this.Ijq.setVisibility(8);
          s.this.Ijr.setVisibility(0);
          s.this.Ijr.setText(2131767706);
          s.this.Ijr.setTextColor(s.this.getContext().getResources().getColor(2131101376));
          s.this.IiV.setText(2131768200);
          s.this.Ija.setVisibility(0);
          if (!s.this.mKBLayout.isShown()) {
            s.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.aau(2);
          s.yt(true);
        }
        AppMethodBeat.o(71168);
      }
    };
    EventCenter.instance.publish(localow);
    AppMethodBeat.o(71178);
  }
  
  private static void fSP()
  {
    AppMethodBeat.i(71179);
    Log.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(71179);
  }
  
  private void fTd()
  {
    AppMethodBeat.i(71177);
    if (this.Ijs == 1) {
      this.Ijp.setText(2131767707);
    }
    for (;;)
    {
      this.Ijs = 0;
      this.Ijx = Util.currentTicks();
      this.Ijq.setVisibility(8);
      this.IjG.setVisibility(8);
      this.Ija.setVisibility(0);
      if (!this.mKBLayout.isShown()) {
        this.mKBLayout.setVisibility(0);
      }
      this.IiV.setText(2131768200);
      yp(true);
      this.BDB.Ijy = 0;
      com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.ui.f.aqm(29);
      fSP();
      AppMethodBeat.o(71177);
      return;
      this.Ijp.setText(2131767699);
    }
  }
  
  private static boolean fTf()
  {
    AppMethodBeat.i(71209);
    g.aAi();
    Object localObject = g.aAh().azQ().get(ar.a.NUw, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71209);
      return bool;
    }
  }
  
  private void i(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71191);
    if (paramBankcard == null)
    {
      Log.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.fQb())
    {
      this.IiY.setImageResource(2131235574);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.fQc())
    {
      this.HCH.a(paramBankcard, this.IiY);
      AppMethodBeat.o(71191);
      return;
    }
    if (paramBankcard.fQf())
    {
      this.IiY.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), 2131690395));
      if (!Util.isNullOrNil(paramBankcard.HVU))
      {
        this.IiY.setUseSdcardCache(true);
        this.IiY.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
        this.IiY.gI(paramBankcard.HVU, 2131690395);
        AppMethodBeat.o(71191);
      }
    }
    else
    {
      this.HCH.a(getContext(), paramBankcard, this.IiY);
    }
    AppMethodBeat.o(71191);
  }
  
  private static void yp(boolean paramBoolean)
  {
    AppMethodBeat.i(71208);
    g.aAi();
    g.aAh().azQ().set(ar.a.NUw, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71208);
  }
  
  private void yq(boolean paramBoolean)
  {
    AppMethodBeat.i(71180);
    View localView = this.jBN.findViewById(2131297261);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.IjA = true;
        AppMethodBeat.o(71180);
        return;
      }
      localView.setVisibility(8);
      this.IjA = false;
    }
    AppMethodBeat.o(71180);
  }
  
  private void yr(boolean paramBoolean)
  {
    AppMethodBeat.i(71193);
    if (!paramBoolean)
    {
      this.Ijd.setVisibility(8);
      this.Ije.setVisibility(8);
      AppMethodBeat.o(71193);
      return;
    }
    this.Ijd.setVisibility(0);
    this.Ije.setVisibility(0);
    AppMethodBeat.o(71193);
  }
  
  public final void a(final Context paramContext, final Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71194);
    this.HGS = e.IcT.a(paramOrders);
    if ((paramOrders != null) && (paramOrders.HZe != null) && (paramOrders.HZe.HEu != null) && (paramOrders.HZe.HEu.size() > 0) && (this.HGS != null))
    {
      if (paramFavorPayInfo == null) {}
      for (this.HGf = this.HGS.aVM(paramOrders.HZe.HEt);; this.HGf = paramFavorPayInfo)
      {
        this.IiZ.setVisibility(0);
        if (this.Ijd != null) {
          this.Ijd.setTag(this.HGf);
        }
        this.Ijo = paramBankcard;
        this.Iji.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71170);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            s.this.Ijf.setVisibility(8);
            int i;
            if (s.this.BDB == null)
            {
              i = 0;
              if (s.this.BDB != null) {
                break label143;
              }
            }
            label143:
            for (paramAnonymousView = "";; paramAnonymousView = s.this.BDB.dDL)
            {
              af.f(i, paramAnonymousView, 12, "");
              n.a(paramContext, paramOrders, s.this.HGf.HXI, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  Object localObject2 = null;
                  AppMethodBeat.i(71169);
                  s.this.HGf = paramAnonymous2FavorPayInfo;
                  int i;
                  if (s.this.BDB == null)
                  {
                    i = 0;
                    if (s.this.BDB != null) {
                      break label294;
                    }
                    paramAnonymous2FavorPayInfo = "";
                    label51:
                    af.f(i, paramAnonymous2FavorPayInfo, 15, s.this.HGf.HXI);
                    s.this.Ijm = false;
                    paramAnonymous2FavorPayInfo = d.cI(s.this.HGf.HXJ, s.this.HGf.HXK);
                    s.this.HGf.HXM = "";
                    if (!d.a(s.this.HGf, s.this.Ijo)) {
                      break label339;
                    }
                    s.this.Ijm = true;
                    if (paramAnonymous2FavorPayInfo.size() != 0) {
                      break label311;
                    }
                  }
                  label294:
                  label311:
                  for (s.this.HGf.HXM = s.9.this.val$context.getString(2131767701);; s.this.HGf.HXM = s.9.this.val$context.getString(2131767702))
                  {
                    s.this.dismiss();
                    if (s.this.IjF == null) {
                      break label339;
                    }
                    s.this.IjF.a(s.this.Ija.getText(), s.this.HGf, s.this.Ijm);
                    AppMethodBeat.o(71169);
                    return;
                    i = s.this.BDB.dVv;
                    break;
                    paramAnonymous2FavorPayInfo = s.this.BDB.dDL;
                    break label51;
                  }
                  label339:
                  if (s.this.Ijd != null) {
                    s.this.Ijd.setTag(s.this.HGf);
                  }
                  Object localObject1 = s.this.HGS.aVJ(s.this.HGf.HXI);
                  double d;
                  String str1;
                  String str3;
                  String str2;
                  String str4;
                  if ((localObject1 != null) && (((j)localObject1).HEA > 0.0D))
                  {
                    d = ((j)localObject1).HEs;
                    str1 = com.tencent.mm.wallet_core.ui.f.D(((j)localObject1).HEz);
                    str3 = com.tencent.mm.wallet_core.ui.f.D(s.9.this.IjQ.HZe.HEq);
                    str2 = ((j)localObject1).HEC;
                    paramAnonymous2FavorPayInfo = null;
                    if ((localObject1 == null) || (((j)localObject1).HEB == 0)) {
                      break label657;
                    }
                    str4 = ((j)localObject1).HED;
                    localObject1 = str4;
                    if (Util.isNullOrNil(str2)) {}
                  }
                  label657:
                  for (localObject1 = ",".concat(String.valueOf(str4));; localObject1 = null)
                  {
                    if ((!Util.isNullOrNil(str2)) || (!Util.isNullOrNil((String)localObject1))) {
                      if (Util.isNullOrNil(paramAnonymous2FavorPayInfo)) {
                        paramAnonymous2FavorPayInfo = localObject2;
                      }
                    }
                    for (;;)
                    {
                      s.this.d(str1, d);
                      s.this.aVT(str3);
                      s.this.lv(str2, paramAnonymous2FavorPayInfo);
                      s.this.aVU((String)localObject1);
                      AppMethodBeat.o(71169);
                      return;
                      d = s.9.this.IjQ.HZe.HEq;
                      str1 = com.tencent.mm.wallet_core.ui.f.D(s.9.this.IjQ.HZe.HEq);
                      paramAnonymous2FavorPayInfo = s.9.this.val$context.getString(2131768195);
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
              i = s.this.BDB.dVv;
              break;
            }
          }
        });
        Assert.assertNotNull(this.HGS);
        this.Ijf.setVisibility(8);
        AppMethodBeat.o(71194);
        return;
      }
    }
    this.IiZ.setVisibility(8);
    AppMethodBeat.o(71194);
  }
  
  public final void a(a parama)
  {
    this.IjH = parama;
  }
  
  public final void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(71192);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.Ijd.setOnClickListener(paramOnClickListener);
      this.IiW.setText(paramCharSequence);
      yr(this.Ijn);
      if (!paramBoolean)
      {
        this.Ijc.setVisibility(8);
        AppMethodBeat.o(71192);
        return;
      }
      this.Ijc.setVisibility(0);
      AppMethodBeat.o(71192);
      return;
    }
    this.Ijd.setVisibility(8);
    this.Ije.setVisibility(8);
    AppMethodBeat.o(71192);
  }
  
  public final void aVR(String paramString)
  {
    AppMethodBeat.i(71185);
    this.CKk.setText(paramString);
    AppMethodBeat.o(71185);
  }
  
  public final void aVT(String paramString)
  {
    AppMethodBeat.i(71189);
    if (!TextUtils.isEmpty(paramString))
    {
      this.HHd.setVisibility(0);
      this.HHd.setText(paramString);
      AppMethodBeat.o(71189);
      return;
    }
    this.HHd.setVisibility(8);
    AppMethodBeat.o(71189);
  }
  
  public final void aVU(String paramString)
  {
    AppMethodBeat.i(71199);
    if (!Util.isNullOrNil(paramString))
    {
      this.Ijh.setText(paramString);
      this.Ijh.setVisibility(0);
      AppMethodBeat.o(71199);
      return;
    }
    this.Ijh.setVisibility(8);
    AppMethodBeat.o(71199);
  }
  
  protected void bh(Context paramContext)
  {
    AppMethodBeat.i(71174);
    Log.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
    this.mContext = paramContext;
    hO(paramContext);
    hP(paramContext);
    AppMethodBeat.o(71174);
  }
  
  public final void c(final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(71196);
    if (this.zfh == null)
    {
      AppMethodBeat.o(71196);
      return;
    }
    this.XY = paramOnCancelListener;
    this.zfh.setVisibility(0);
    this.zfh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71171);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(null);
        }
        if (s.this.IjH != null) {
          s.this.IjH.ezC();
        }
        s.this.cancel();
        if (s.this.Ijp.isShown()) {
          com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71171);
          return;
          com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    });
    AppMethodBeat.o(71196);
  }
  
  public final void d(String paramString, double paramDouble)
  {
    AppMethodBeat.i(71186);
    if (!TextUtils.isEmpty(paramString))
    {
      this.CuI.setVisibility(0);
      this.CuI.setText(paramString);
      if (paramDouble == 0.0D)
      {
        this.Ijn = false;
        yr(this.Ijn);
        AppMethodBeat.o(71186);
        return;
      }
      yr(this.Ijn);
      AppMethodBeat.o(71186);
      return;
    }
    this.CuI.setVisibility(8);
    this.Ijn = true;
    yr(this.Ijn);
    AppMethodBeat.o(71186);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(71184);
    try
    {
      super.dismiss();
      fSP();
      this.HCH.destory();
      if (this.wGp != null) {
        this.wGp.cancel();
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
  
  public final void fSA()
  {
    AppMethodBeat.i(71206);
    this.isPaused = false;
    if (z.aUo())
    {
      AppMethodBeat.o(71206);
      return;
    }
    AppMethodBeat.o(71206);
  }
  
  protected void fTe()
  {
    AppMethodBeat.i(71195);
    yp(false);
    if (this.Ijl != null) {
      this.Ijl.onClick(this, 0);
    }
    dismiss();
    if (this.IjF != null) {
      this.IjF.a(this.Ija.getText(), this.HGf, this.Ijm);
    }
    if (this.Ijx < 0L)
    {
      Log.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71195);
      return;
    }
    if (this.Ijs == 0)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(686L, 1L, Util.ticksToNow(this.Ijx), false);
      AppMethodBeat.o(71195);
      return;
    }
    if (this.Ijs == 1)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(686L, 3L, Util.ticksToNow(this.Ijx), false);
    }
    AppMethodBeat.o(71195);
  }
  
  public int fTi()
  {
    return 2131496943;
  }
  
  protected final void hO(Context paramContext)
  {
    AppMethodBeat.i(71175);
    this.jBN = View.inflate(paramContext, fTi(), null);
    this.zfh = ((ImageView)this.jBN.findViewById(2131310280));
    this.mKeyboard = ((MyKeyboardWindow)this.jBN.findViewById(2131308962));
    this.mKBLayout = this.jBN.findViewById(2131308960);
    this.CKk = ((TextView)this.jBN.findViewById(2131299180));
    this.IiV = ((TextView)this.jBN.findViewById(2131310287));
    this.CuI = ((TextView)this.jBN.findViewById(2131300552));
    this.HHd = ((TextView)this.jBN.findViewById(2131305695));
    this.HHd.getPaint().setFlags(16);
    this.IiW = ((TextView)this.jBN.findViewById(2131297320));
    this.IiX = ((FavourLayout)this.jBN.findViewById(2131300549));
    this.IiY = ((CdnImageView)this.jBN.findViewById(2131297309));
    this.Ijc = this.jBN.findViewById(2131300541);
    this.IiZ = ((TextView)this.jBN.findViewById(2131304877));
    this.keC = ((ImageView)this.jBN.findViewById(2131298564));
    this.Ijd = this.jBN.findViewById(2131297307);
    this.Ije = ((TextView)this.jBN.findViewById(2131307642));
    a.b.c(this.keC, com.tencent.mm.wallet_core.ui.f.getUsername());
    this.Ija = ((EditHintPasswdView)this.jBN.findViewById(2131302674));
    this.Ijf = ((ImageView)this.jBN.findViewById(2131302250));
    this.Ijp = ((TextView)this.jBN.findViewById(2131310275));
    this.Ijq = this.jBN.findViewById(2131301523);
    this.Ijr = ((TextView)this.jBN.findViewById(2131301526));
    this.Igh = ((ImageView)this.jBN.findViewById(2131301522));
    this.Ijg = ((TextView)this.jBN.findViewById(2131298288));
    this.Ijh = ((TextView)this.jBN.findViewById(2131306497));
    this.Iji = this.jBN.findViewById(2131300539);
    this.Ijj = ((TextView)this.jBN.findViewById(2131300548));
    this.IjG = ((Button)this.jBN.findViewById(2131300347));
    this.IiX.setVisibility(8);
    AppMethodBeat.o(71175);
  }
  
  @TargetApi(14)
  protected void hP(Context paramContext)
  {
    AppMethodBeat.i(71176);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Ija);
    this.Ija.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71155);
        if (paramAnonymousBoolean)
        {
          s.this.fTe();
          com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71155);
      }
    });
    this.Ija.requestFocus();
    Object localObject = (TextView)this.jBN.findViewById(2131310287);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kQ(paramContext));
    }
    paramContext = (EditText)this.jBN.findViewById(2131310180);
    com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new com.tencent.mm.ui.a.d();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71157);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!s.this.mKBLayout.isShown()) {
          s.this.mKBLayout.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71157);
      }
    });
    this.jBN.findViewById(2131308963).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71158);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (s.this.mKBLayout.isShown()) {
          s.this.mKBLayout.setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71158);
      }
    });
    this.IjG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71159);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        s.a(s.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71159);
      }
    });
    AppMethodBeat.o(71176);
  }
  
  public final void lv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71188);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.IiZ.setVisibility(0);
      this.IiZ.setText(paramString2);
    }
    while (!TextUtils.isEmpty(paramString1))
    {
      this.Ijj.setText(paramString1);
      this.Ijj.setVisibility(0);
      AppMethodBeat.o(71188);
      return;
      this.IiZ.setVisibility(8);
    }
    this.Ijj.setVisibility(8);
    AppMethodBeat.o(71188);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71207);
    this.isPaused = true;
    if (z.aUo())
    {
      AppMethodBeat.o(71207);
      return;
    }
    if (this.Ijs == 1) {
      fTd();
    }
    AppMethodBeat.o(71207);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71182);
    super.onCreate(paramBundle);
    setContentView(this.jBN);
    com.tencent.soter.a.g.f.hlO().hlP();
    AppMethodBeat.o(71182);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71181);
    if (paramInt == 4)
    {
      if (this.XY != null) {
        this.XY.onCancel(this);
      }
      if (this.IjH != null) {
        this.IjH.ezC();
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
    this.ox = paramBoolean;
    setCanceledOnTouchOutside(this.ox);
    AppMethodBeat.o(71183);
  }
  
  public final void ys(boolean paramBoolean)
  {
    AppMethodBeat.i(71197);
    if (paramBoolean)
    {
      this.Ijd.setVisibility(0);
      AppMethodBeat.o(71197);
      return;
    }
    this.Ijd.setVisibility(8);
    AppMethodBeat.o(71197);
  }
  
  public static abstract interface a
  {
    public abstract void ezC();
  }
  
  static final class b
    implements DialogInterface.OnCancelListener
  {
    private DialogInterface.OnCancelListener IjS = null;
    
    private b(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.IjS = paramOnCancelListener;
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(71172);
      s.yt(false);
      if (this.IjS != null) {
        this.IjS.onCancel(paramDialogInterface);
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