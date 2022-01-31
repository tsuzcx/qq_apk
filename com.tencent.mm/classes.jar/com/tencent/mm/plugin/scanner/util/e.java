package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.lu;
import com.tencent.mm.h.a.ox;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.ab;
import com.tencent.mm.openim.b.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ad.a.c.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.protocal.c.ask;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  implements com.tencent.mm.ah.f, c.a
{
  public String aWf;
  public String appId;
  public int bIl;
  public String bIn;
  private ProgressDialog iec = null;
  public String imagePath;
  public int jYS;
  private Activity mActivity;
  private int nOC;
  private String nOD;
  private Bundle nOE;
  e.a nOF = null;
  private Map<com.tencent.mm.ah.m, Integer> nOG = new HashMap();
  
  public e()
  {
    onResume();
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, boolean paramBoolean)
  {
    int i = 2;
    y.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
    if (paramInt == 2) {}
    for (paramInt = i;; paramInt = 1)
    {
      paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, paramInt, 5, paramBoolean);
      this.nOG.put(paramString, Integer.valueOf(1));
      au.Dk().a(paramString, 0);
      paramActivity.getString(R.l.app_tip);
      this.iec = com.tencent.mm.ui.base.h.b(paramActivity, paramActivity.getString(R.l.scan_loading_tip), new e.7(this, paramString));
      return;
    }
  }
  
  private int byn()
  {
    switch (this.nOC)
    {
    case 0: 
    case 2: 
    default: 
      return 30;
    }
    return 45;
  }
  
  private static int wU(int paramInt)
  {
    if (paramInt == 1) {
      return 34;
    }
    if (paramInt == 0) {
      return 4;
    }
    if (paramInt == 3) {
      return 42;
    }
    return 30;
  }
  
  private static int wr(int paramInt)
  {
    if ((paramInt == 30) || (paramInt == 37) || (paramInt == 38) || (paramInt == 40)) {
      return 13;
    }
    if ((paramInt == 4) || (paramInt == 47)) {
      return 12;
    }
    if (paramInt == 34) {
      return 24;
    }
    return 0;
  }
  
  public final void a(Activity paramActivity, final String paramString, int paramInt1, int paramInt2, int paramInt3, e.a parama, Bundle paramBundle)
  {
    y.i("MicroMsg.QBarStringHandler", "deal QBarString %s, source:%d, codeType: %s, codeVersion: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mActivity = paramActivity;
    this.nOC = paramInt1;
    this.nOD = paramString;
    this.nOF = parama;
    this.nOE = paramBundle;
    if (bk.bl(paramString)) {
      y.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (au.Dk().KG() != 0) {
              break;
            }
            Toast.makeText(paramActivity, paramActivity.getString(R.l.fmt_iap_err), 0).show();
          } while (this.nOF == null);
          this.nOF.n(0, null);
          return;
          parama = "";
          if (paramString.startsWith("weixin://qr/")) {
            parama = paramString.substring(12) + "@qr";
          }
          while (!bk.bl(parama))
          {
            a(paramActivity, paramInt1, parama, false);
            return;
            if (paramString.startsWith("http://weixin.qq.com/r/")) {
              parama = paramString.substring(23) + "@qr";
            }
          }
          y.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString, Boolean.valueOf(true), Boolean.valueOf(true) });
          if (paramString.startsWith("weixin://wxpay/bizpayurl"))
          {
            y.i("MicroMsg.QBarStringHandler", "do native pay");
            paramInt1 = wU(this.nOC);
            paramInt2 = wr(paramInt1);
            paramActivity = new lu();
            paramActivity.bUP.url = paramString;
            paramActivity.bUP.bUR = paramInt2;
            paramActivity.bUP.scene = paramInt1;
            paramActivity.bUP.context = this.mActivity;
            if (paramInt2 == 13)
            {
              y.d("MicroMsg.QBarStringHandler", "add source and sourceType");
              paramActivity.bUP.aWf = this.aWf;
              paramActivity.bUP.bIl = this.bIl;
            }
            paramActivity.bFJ = new e.1(this, paramActivity);
            com.tencent.mm.sdk.b.a.udP.a(paramActivity, Looper.myLooper());
            new ah(Looper.getMainLooper()).postDelayed(new e.4(this), 2000L);
            return;
          }
          if ((!paramString.startsWith("https://wx.tenpay.com/f2f")) && (!paramString.startsWith("wxp://f2f"))) {
            break;
          }
          if (this.nOF != null) {
            this.nOF.n(5, null);
          }
          paramInt1 = wr(wU(this.nOC));
          com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, 1, paramString, paramInt1, null);
        } while (this.nOF == null);
        this.nOF.n(3, null);
        return;
        if (!paramString.startsWith("wxp://wbf2f")) {
          break;
        }
        if (this.nOF != null) {
          this.nOF.n(5, null);
        }
        paramInt1 = wr(wU(this.nOC));
        com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, 6, paramString, paramInt1, null);
      } while (this.nOF == null);
      this.nOF.n(3, null);
      return;
      if ((paramInt2 == 22) && (paramString.startsWith("m")))
      {
        y.d("MicroMsg.QBarStringHandler", "go to reward");
        if (this.nOF != null) {
          this.nOF.n(5, null);
        }
        paramInt2 = wr(wU(this.nOC));
        paramActivity = "";
        if (paramBundle != null) {
          paramActivity = paramBundle.getString("stat_url", "");
        }
        paramInt1 = 1;
        if (this.jYS == 37) {
          paramInt1 = 2;
        }
        for (;;)
        {
          com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, paramString, paramInt2, paramActivity, paramInt1);
          if (this.nOF == null) {
            break;
          }
          this.nOF.n(3, null);
          return;
          if (this.jYS == 38) {
            paramInt1 = 3;
          } else if (this.jYS == 40) {
            paramInt1 = 4;
          }
        }
      }
      if (paramString.startsWith("https://payapp.weixin.qq.com/qr/"))
      {
        y.d("MicroMsg.QBarStringHandler", "f2f pay material");
        if (this.nOF != null) {
          this.nOF.n(5, null);
        }
        paramInt1 = wU(this.nOC);
        paramInt2 = wr(paramInt1);
        paramActivity = new ox();
        paramActivity.bYx.bYz = paramString;
        paramActivity.bYx.scene = paramInt1;
        paramActivity.bYx.type = 0;
        paramActivity.bYx.aoB = new WeakReference(this.mActivity);
        paramActivity.bYx.bFJ = new e.5(this, paramActivity, paramInt2);
        com.tencent.mm.sdk.b.a.udP.m(paramActivity);
        return;
      }
      if ((paramInt2 == 22) && (paramString.startsWith("n")))
      {
        y.d("MicroMsg.QBarStringHandler", "qr reward pay material");
        if (this.nOF != null) {
          this.nOF.n(5, null);
        }
        paramActivity = "";
        if (paramBundle != null) {
          paramActivity = paramBundle.getString("stat_url", "");
        }
        paramInt1 = wU(this.nOC);
        paramInt2 = wr(paramInt1);
        parama = new ox();
        parama.bYx.bYz = paramString;
        parama.bYx.scene = paramInt1;
        parama.bYx.type = 1;
        parama.bYx.aoB = new WeakReference(this.mActivity);
        parama.bYx.bFJ = new e.6(this, parama, paramInt2, paramActivity, paramInt1);
        com.tencent.mm.sdk.b.a.udP.m(parama);
        return;
      }
      if (!paramString.startsWith("wxhb://f2f")) {
        break;
      }
      y.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
    } while (paramInt2 != 19);
    if (this.nOF != null) {
      this.nOF.n(5, null);
    }
    paramActivity = new Intent();
    paramActivity.putExtra("key_share_url", paramString);
    com.tencent.mm.br.d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1);
    return;
    parama = this.appId;
    if (this.jYS > 0) {}
    for (paramInt1 = this.jYS;; paramInt1 = wU(this.nOC))
    {
      y.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString, Integer.valueOf(this.nOC), Integer.valueOf(paramInt1) });
      paramString = new com.tencent.mm.modelsimple.h(paramString, paramInt1, paramInt2, paramInt3, parama, (int)System.currentTimeMillis(), new byte[0]);
      this.nOG.put(paramString, Integer.valueOf(1));
      au.Dk().a(paramString, 0);
      if (this.iec != null) {
        this.iec.dismiss();
      }
      paramActivity.getString(R.l.app_tip);
      this.iec = com.tencent.mm.ui.base.h.b(paramActivity, paramActivity.getString(R.l.qrcode_scan_default), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          au.Dk().c(paramString);
          if (e.this.nOF != null) {
            e.this.nOF.n(1, null);
          }
        }
      });
      if (this.nOF == null) {
        break;
      }
      this.nOF.n(5, null);
      return;
    }
  }
  
  public final void bym()
  {
    y.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.nOD = null;
    this.mActivity = null;
    onPause();
  }
  
  public final Context getContext()
  {
    return this.mActivity;
  }
  
  public final void im(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.nOF != null) {
        this.nOF.n(1, null);
      }
    }
    while (this.nOF == null) {
      return;
    }
    this.nOF.n(3, null);
  }
  
  public final void onPause()
  {
    y.i("MicroMsg.QBarStringHandler", "onPause");
    au.Dk().b(106, this);
    au.Dk().b(233, this);
    au.Dk().b(666, this);
    au.Dk().b(372, this);
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.QBarStringHandler", "onResume");
    au.Dk().a(106, this);
    au.Dk().a(233, this);
    au.Dk().a(666, this);
    au.Dk().a(372, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (paramm == null) {
      if (paramm == null)
      {
        bool = true;
        y.e("MicroMsg.QBarStringHandler", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        if (this.nOF != null) {
          this.nOF.n(2, null);
        }
      }
    }
    label237:
    label510:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    bool = false;
                    break;
                    if (!this.nOG.containsKey(paramm))
                    {
                      if ((paramm instanceof u)) {
                        y.e("MicroMsg.QBarStringHandler", "emotion scan scene");
                      }
                    }
                    else
                    {
                      this.nOG.remove(paramm);
                      if (this.iec != null)
                      {
                        this.iec.dismiss();
                        this.iec = null;
                      }
                      if ((paramm.getType() != 372) || (paramInt1 != 4) || (paramInt2 != -2034)) {
                        break label237;
                      }
                      paramString = new com.tencent.mm.modelsimple.h(((n)paramm).ePY, null, 50, 0, 0, new byte[0]);
                      g.DQ();
                      g.DO().dJT.a(paramString, 0);
                      this.nOG.put(paramString, Integer.valueOf(1));
                      return;
                    }
                    y.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
                    return;
                    if ((paramInt1 == 4) && (paramInt2 == -4))
                    {
                      com.tencent.mm.ui.base.h.a(this.mActivity, R.l.qrcode_no_user_tip, R.l.app_tip, new e.10(this));
                      return;
                    }
                    int i;
                    switch (paramInt1)
                    {
                    default: 
                      i = 0;
                    }
                    for (;;)
                    {
                      if (i == 0) {
                        break label465;
                      }
                      if (this.nOF == null) {
                        break;
                      }
                      this.nOF.n(1, null);
                      return;
                      if (au.Dk().KH())
                      {
                        au.Dk().getNetworkServerIp();
                        new StringBuilder().append(paramInt2);
                      }
                      for (;;)
                      {
                        i = 1;
                        break;
                        if (ab.bG(this.mActivity)) {
                          j.eY(this.mActivity);
                        } else {
                          Toast.makeText(this.mActivity, this.mActivity.getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
                        }
                      }
                      Toast.makeText(this.mActivity, this.mActivity.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
                      i = 1;
                    }
                    if ((paramInt1 != 4) || (paramInt2 != -2004)) {
                      break label510;
                    }
                    com.tencent.mm.ui.base.h.h(this.mActivity, R.l.qrcode_ban_by_expose, R.l.app_tip);
                  } while (this.nOF == null);
                  this.nOF.n(1, null);
                  return;
                  if ((paramInt1 == 0) && (paramInt2 == 0)) {
                    break label576;
                  }
                  Toast.makeText(this.mActivity, this.mActivity.getString(R.l.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
                } while (this.nOF == null);
                this.nOF.n(1, null);
                return;
                if (paramm.getType() != 106) {
                  break label1390;
                }
                paramString = (com.tencent.mm.plugin.messenger.a.f)paramm;
                ad localad;
                Object localObject2;
                if (!paramString.mcu)
                {
                  paramString = paramString.bhH();
                  if ((ad.Fn(paramString.tpg)) && (paramString.tpn != null) && (!bk.bl(paramString.tpn.ffw)) && (com.tencent.mm.modelappbrand.a.jq(paramString.tpn.ffw))) {
                    if (this.jYS > 0)
                    {
                      paramInt1 = this.jYS;
                      y.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { this.nOD, Integer.valueOf(this.nOC), Integer.valueOf(paramInt1) });
                      paramString = new com.tencent.mm.modelsimple.h(this.nOD, null, 43, 0, 0, new byte[0]);
                      this.nOG.put(paramString, Integer.valueOf(1));
                      au.Dk().a(paramString, 0);
                      if (this.iec != null) {
                        this.iec.dismiss();
                      }
                      localObject1 = this.mActivity;
                      this.mActivity.getString(R.l.app_tip);
                      this.iec = com.tencent.mm.ui.base.h.b((Context)localObject1, this.mActivity.getString(R.l.qrcode_scan_default), true, new e.3(this, paramString));
                      paramInt1 = 1;
                      if (paramInt1 != 0) {
                        break label1135;
                      }
                      paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bhH();
                      localObject1 = aa.a(paramString.sQs);
                      y.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + paramString.sQs);
                      o.JQ().h((String)localObject1, aa.a(paramString.svJ));
                      if ((this.iec != null) && (this.iec.isShowing()))
                      {
                        y.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                        this.iec.dismiss();
                      }
                      if (bk.pm((String)localObject1).length() <= 0) {
                        break label1345;
                      }
                      au.Hx();
                      localad = com.tencent.mm.model.c.Fw().abl((String)localObject1);
                      if ((localad == null) || (!com.tencent.mm.n.a.gR(localad.field_type)) || (!localad.cua())) {
                        break label1142;
                      }
                      localObject2 = z.My().kQ((String)localObject1);
                      ((com.tencent.mm.ai.d)localObject2).bS(false);
                      d.b localb = ((com.tencent.mm.ai.d)localObject2).eeW;
                      if (localb.efa != null) {
                        localb.efq = localb.efa.optInt("ScanQRCodeType", 0);
                      }
                      if (localb.efq != 1) {
                        break label1137;
                      }
                      paramInt1 = 1;
                      if ((paramInt1 == 0) || (((com.tencent.mm.ai.d)localObject2).Ly())) {
                        break label1142;
                      }
                      paramString = new Intent();
                      paramString.putExtra("Chat_User", (String)localObject1);
                      paramString.putExtra("finish_direct", true);
                      com.tencent.mm.plugin.scanner.b.eUR.e(paramString, this.mActivity);
                      paramInt1 = 1;
                    }
                  }
                }
                for (;;)
                {
                  if (paramInt1 == 0) {
                    break label1371;
                  }
                  if (this.nOF == null) {
                    break;
                  }
                  paramString = new Bundle();
                  paramString.putString("geta8key_fullurl", aa.a(((com.tencent.mm.plugin.messenger.a.f)paramm).bhH().sQs));
                  paramString.putInt("geta8key_action_code", 4);
                  this.nOF.n(3, paramString);
                  return;
                  paramInt1 = wU(this.nOC);
                  break label659;
                  paramInt1 = 0;
                  break label801;
                  break;
                  paramInt1 = 0;
                  break label1007;
                  paramInt1 = byn();
                  localObject2 = new Intent();
                  com.tencent.mm.pluginsdk.ui.tools.c.a((Intent)localObject2, paramString, paramInt1);
                  if ((localad != null) && (!com.tencent.mm.n.a.gR(localad.field_type))) {
                    ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
                  }
                  if ((paramString.tpg & 0x8) > 0) {
                    com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, (String)localObject1 + "," + paramInt1);
                  }
                  if (this.mActivity != null)
                  {
                    com.tencent.mm.plugin.scanner.b.eUR.d((Intent)localObject2, this.mActivity);
                    localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
                    if (!ad.Fn(paramString.tpg)) {
                      break label1340;
                    }
                  }
                  for (paramInt1 = 0;; paramInt1 = 1)
                  {
                    ((com.tencent.mm.plugin.report.service.h)localObject1).f(14268, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.bIl), Integer.valueOf(this.nOC), this.imagePath, this.nOD, bk.pm(this.bIn) });
                    paramInt1 = 1;
                    break;
                  }
                  if (this.mActivity != null) {
                    Toast.makeText(this.mActivity, R.l.scan_search_contact_fail, 0).show();
                  }
                  paramInt1 = 0;
                }
              } while (this.nOF == null);
              this.nOF.n(1, null);
              return;
              if (paramm.getType() != 372) {
                break label1732;
              }
              paramString = ((n)paramm).ePX;
              paramm = paramString.hPY;
              y.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:" + paramm);
              if ((this.iec != null) && (this.iec.isShowing()))
              {
                y.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                this.iec.dismiss();
              }
              if (bk.pm(paramm).length() > 0)
              {
                au.Hx();
                paramm = com.tencent.mm.model.c.Fw().abl(paramm);
                paramInt1 = byn();
                localObject1 = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.c.a((Intent)localObject1, paramString, paramInt1);
                if ((paramm != null) && (!com.tencent.mm.n.a.gR(paramm.field_type))) {
                  ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
                }
                if (this.mActivity != null)
                {
                  com.tencent.mm.plugin.scanner.b.eUR.d((Intent)localObject1, this.mActivity);
                  com.tencent.mm.plugin.report.service.h.nFQ.f(14268, new Object[] { Integer.valueOf(2), Integer.valueOf(this.bIl), Integer.valueOf(this.nOC), this.imagePath, this.nOD, bk.pm(this.bIn) });
                }
              }
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                if (paramInt1 == 0) {
                  break label1713;
                }
                if (this.nOF == null) {
                  break;
                }
                paramm = new Bundle();
                paramm.putString("geta8key_fullurl", paramString.hPY);
                paramm.putInt("geta8key_action_code", 4);
                this.nOF.n(3, paramm);
                return;
                if (this.mActivity != null) {
                  Toast.makeText(this.mActivity, R.l.scan_search_contact_fail, 0).show();
                }
              }
            } while (this.nOF == null);
            this.nOF.n(1, null);
            return;
            if (paramm.getType() != 233) {
              break label2072;
            }
            paramString = ((com.tencent.mm.modelsimple.h)paramm).Qf();
            Object localObject1 = new Bundle();
            ((Bundle)localObject1).putString("geta8key_fullurl", paramString);
            ((Bundle)localObject1).putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.h)paramm).Qh());
            if (this.nOF != null) {
              this.nOF.n(4, (Bundle)localObject1);
            }
            if (this.jYS > 0) {}
            for (paramInt1 = this.jYS;; paramInt1 = wU(this.nOC))
            {
              y.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[] { Integer.valueOf(paramInt1) });
              bool = com.tencent.mm.plugin.ad.a.c.a(this, (com.tencent.mm.modelsimple.h)paramm, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  if (e.this.nOF != null) {
                    e.this.nOF.n(1, null);
                  }
                }
              }, this.nOD, paramInt1, this.nOC, new Runnable()
              {
                public final void run()
                {
                  if (e.this.nOF != null) {
                    e.this.nOF.n(3, null);
                  }
                }
              }, this.nOE);
              if ((bool) || (((com.tencent.mm.modelsimple.h)paramm).Qh() != 4)) {
                break;
              }
              a(this.mActivity, this.nOC, paramString, true);
              return;
            }
            if ((!bool) && (((com.tencent.mm.modelsimple.h)paramm).Qh() == 29))
            {
              paramm = this.mActivity;
              y.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
              paramString = new n(paramString, (byte)0);
              this.nOG.put(paramString, Integer.valueOf(1));
              au.Dk().a(paramString, 0);
              paramm.getString(R.l.app_tip);
              this.iec = com.tencent.mm.ui.base.h.b(paramm, paramm.getString(R.l.scan_loading_tip), new e.8(this, paramString));
              return;
            }
            y.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[] { Boolean.valueOf(bool) });
          } while ((bool) || (this.nOF == null));
          this.nOF.n(1, null);
          return;
        } while (paramm.getType() != 666);
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label2210;
        }
      } while (!(paramm instanceof u));
      paramString = ((u)paramm).QO().syc;
      y.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[] { paramString });
      paramm = new Intent();
      paramm.putExtra("extra_id", paramString);
      paramm.putExtra("preceding_scence", 11);
      paramm.putExtra("download_entrance_scene", 14);
      com.tencent.mm.br.d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", paramm);
      y.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
    } while (this.nOF == null);
    label465:
    label1007:
    label1137:
    label1142:
    this.nOF.n(3, null);
    label576:
    label1135:
    return;
    label659:
    label801:
    label1340:
    label1345:
    label1371:
    label1390:
    y.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
    label1713:
    label1732:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e
 * JD-Core Version:    0.7.0.1
 */