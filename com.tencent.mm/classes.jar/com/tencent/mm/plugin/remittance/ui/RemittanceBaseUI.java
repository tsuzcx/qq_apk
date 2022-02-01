package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gl.a;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.g.b.a.kx;
import com.tencent.mm.g.b.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.ad;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.c.ai;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceBaseUI
  extends WalletBaseUI
  implements e.a
{
  protected String APz;
  private double Cpd;
  protected com.tencent.mm.plugin.wallet.a CqM = null;
  protected String CqN;
  protected String CqO;
  protected String CqP;
  private int CqQ = -1;
  protected boolean CqR = false;
  protected String CqS;
  protected ImageView CqT;
  protected TextView CqU;
  protected TextView CqV;
  protected TextView CqW;
  protected TextView CqX;
  protected TextView CqY;
  private TextView CqZ;
  private boolean CrA = false;
  private IListener CrB = new IListener() {};
  private boolean CrC = false;
  private boolean CrD = false;
  private boolean CrE = false;
  private boolean CrF = false;
  private zd CrG = null;
  private IListener CrH = new IListener() {};
  protected double CrI = 0.0D;
  protected String CrJ = "";
  protected String CrK = "";
  protected String CrL = "";
  private IListener<gn> CrM = new IListener() {};
  private TextView Cra;
  protected TextView Crb;
  private LinearLayout Crc;
  private LinearLayout Crd;
  private LinearLayout Cre;
  private TextView Crf;
  private TextView Crg;
  private LinearLayout Crh;
  protected String Cri;
  protected boolean Crj = true;
  protected String Crk;
  private String Crl;
  private String Crm;
  protected String Crn;
  protected String Cro = null;
  protected String Crp = null;
  protected int Crq;
  private int Crr;
  protected String Crs;
  protected String Crt;
  protected String Cru;
  private Map<String, a> Crv = new HashMap();
  private String Crw;
  protected boolean Crx = false;
  private w Cry;
  private kx Crz;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  private String dRM;
  protected int dYe = 0;
  protected String goe;
  protected ScrollView jVf;
  protected double jVp;
  protected Button krs;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected WalletFormView qAh;
  protected String qnT;
  
  private void a(w paramw, zd paramzd)
  {
    this.CrA = true;
    new c(this).a(paramw, paramzd, new c.a()
    {
      public final void aMb(String paramAnonymousString)
      {
        AppMethodBeat.i(67967);
        Log.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceBaseUI.this.Cru = paramAnonymousString;
        RemittanceBaseUI.this.eNR();
        AppMethodBeat.o(67967);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(213760);
        RemittanceBaseUI.this.Cru = "";
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(213760);
      }
    });
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      if (this.Crx) {
        com.tencent.mm.plugin.report.service.h.CyF.a(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (Util.isNullOrNil(this.Crw)) {
        this.Crw = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        ad.aMh(this.goe);
      }
      if (this.Cpd == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (Util.isEqual(this.CqQ, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (ag.bH(paramIntent))
        {
          finish();
          return;
        }
      } while (ag.bI(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(w paramw)
  {
    if (!this.CrC) {}
    for (boolean bool2 = d(paramw);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.CrD) {
          bool1 = e(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.CrE) {
          bool2 = f(paramw);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.CrF) {
          bool1 = c(paramw);
        }
      }
      bool2 = bool1;
      String str;
      if (!bool1)
      {
        bool2 = bool1;
        if (!Util.isNullOrNil(paramw.Cpk))
        {
          bool2 = bool1;
          if (!Util.isNullOrNil(paramw.Cpl))
          {
            str = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10);
            if (!Util.isNullOrNil(this.qnT)) {
              str = this.qnT;
            }
            if (Util.isNullOrNil(this.Crn)) {
              break label193;
            }
            str = getString(2131764504, new Object[] { str, this.Crn });
          }
        }
      }
      label193:
      for (;;)
      {
        bool2 = a(paramw.dNQ, paramw.Cpl, str, paramw.Cpk, paramw);
        return bool2;
      }
    }
  }
  
  private boolean a(final String paramString1, String paramString2, String paramString3, String paramString4, final w paramw)
  {
    View localView = LayoutInflater.from(this).inflate(2131496112, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131307187);
    TextView localTextView2 = (TextView)localView.findViewById(2131307186);
    TextView localTextView3 = (TextView)localView.findViewById(2131307185);
    localTextView1.setText(paramString2);
    localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, paramString3, localTextView2.getTextSize()));
    double d = Util.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ah.hhz(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new d.a(this);
    paramString2.Dk(false);
    paramString2.aoO(2131764597);
    paramString2.hs(localView);
    paramString2.aoV(2131764510);
    paramString2.aoW(2131756918);
    paramString2.d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(67978);
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(67978);
      }
    });
    paramString2.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(213761);
        RemittanceBaseUI.this.showLoading();
        RemittanceBaseUI.this.a(paramString1, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, paramw);
        AppMethodBeat.o(213761);
      }
    });
    paramString2.hbn().show();
    return true;
  }
  
  private static void aMk(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    Log.i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)XmlParser.parseXml(paramString, "msg", null).get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
      return;
    }
    com.tencent.mm.plugin.remittance.a.c.eMU().eMX().jL(str, paramString);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    d.a locala = new d.a(paramContext);
    locala.bon(paramString2);
    locala.boo(paramString1);
    locala.bou(paramString3).c(paramOnClickListener1);
    locala.bov(paramString4).d(paramOnClickListener2);
    locala.Dk(false);
    locala.Dl(true);
    paramString1 = locala.hbn();
    paramString1.show();
    com.tencent.mm.ui.base.h.a(paramContext, paramString1);
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.dYe = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dYe), Double.valueOf(this.CrI), this.CrJ, this.CrK, this.CrL });
      do
      {
        return;
      } while (paramIntent == null);
      this.dYe = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.CrI = this.jVp;
      this.CrJ = this.mDesc;
      this.CrK = this.Cri;
      this.CrL = this.Crw;
    }
  }
  
  private static boolean b(w paramw)
  {
    return ((paramw.Cpv == 1) && (paramw.Cpw != null)) || ((paramw.Cpw != null) && (paramw.Cpw.Lko > 0));
  }
  
  private void bX(int paramInt, String paramString)
  {
    this.Crz = new kx();
    this.Crz.erW = 2L;
    this.Crz.ejA = paramInt;
    this.Crz.yp(paramString);
    this.Crz.bfK();
  }
  
  private boolean c(final w paramw)
  {
    if ((paramw.ebb != null) && (paramw.ebb.fPZ()))
    {
      this.CrF = true;
      com.tencent.mm.ui.base.h.c(this, paramw.ebb.dQx, "", paramw.ebb.lHB, paramw.ebb.lHA, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67955);
          Log.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { paramw.ebb.qwt });
          com.tencent.mm.wallet_core.ui.f.p(RemittanceBaseUI.this.getContext(), paramw.ebb.qwt, false);
          AppMethodBeat.o(67955);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return true;
    }
    return false;
  }
  
  private boolean d(final w paramw)
  {
    if (!Util.isNullOrNil(paramw.CoX))
    {
      this.CrC = true;
      bX(1, paramw.dQp);
      com.tencent.mm.ui.base.h.c(this, paramw.CoX, getString(2131755962), getString(2131764510), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67956);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 3, paramw.dQp);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramw.dNQ, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, paramw);
          }
          AppMethodBeat.o(67956);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67957);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 2, paramw.dQp);
          AppMethodBeat.o(67957);
        }
      });
      return true;
    }
    return false;
  }
  
  private boolean e(final w paramw)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramw.CoV > 0)
    {
      this.CrD = true;
      if (paramw.CoW == null) {
        break label143;
      }
      if (!Util.isNullOrNil(paramw.CoW.dQx)) {
        break label120;
      }
      str1 = getString(2131764584, new Object[] { Integer.valueOf(paramw.CoV) });
      String str3 = getString(2131764510);
      if (!Util.isNullOrNil(paramw.CoW.Cpx)) {
        break label131;
      }
      str2 = getString(2131764572);
      label87:
      b(this, str1, "", str3, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67958);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramw.dNQ, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, paramw);
          }
          AppMethodBeat.o(67958);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67959);
          if (Util.isNullOrNil(paramw.CoW.Cpy))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(67959);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceBaseUI.this, paramw.CoW.Cpy, 5, true);
          AppMethodBeat.o(67959);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label120:
      str1 = paramw.CoW.dQx;
      break;
      label131:
      str2 = paramw.CoW.Cpx;
      break label87;
      label143:
      Log.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131764584, new Object[] { Integer.valueOf(paramw.CoV) }), getString(2131755962), getString(2131764510), getString(2131764572), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67961);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw)) {
            RemittanceBaseUI.this.a(paramw.dNQ, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, paramw);
          }
          AppMethodBeat.o(67961);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67962);
          com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
          AppMethodBeat.o(67962);
        }
      });
    }
  }
  
  private void eNL()
  {
    if ((eNQ()) && (!Util.isNullOrNil(this.Crp)) && (this.Crr != 0) && (this.Crq == 1))
    {
      addIconOptionMenu(0, 2131235663, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67980);
          com.tencent.mm.wallet_core.ui.f.p(RemittanceBaseUI.this.getContext(), RemittanceBaseUI.this.Crp, false);
          AppMethodBeat.o(67980);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void eNM()
  {
    if ((!Util.isNullOrNil(this.Cro)) && (this.Crr != 0))
    {
      int i;
      if (this.Crr == 1) {
        i = 2;
      }
      try
      {
        for (;;)
        {
          this.CqW.setText(String.format(this.Cro, new Object[] { Integer.valueOf(i) }));
          this.CqW.setVisibility(0);
          return;
          i = 24;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.RemittanceBaseUI", localException, "", new Object[0]);
          this.CqW.setText(getString(2131764563, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    this.CqW.setText("");
    this.CqW.setVisibility(8);
  }
  
  private void eNO()
  {
    Object localObject2 = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10);
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil(this.Crn)) {
      localObject1 = getString(2131764504, new Object[] { localObject2, this.Crn });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.CqU.setTextColor(getResources().getColor(2131100904));
      this.CqV.setVisibility(0);
      if (Util.isNullOrNil(this.goe))
      {
        localObject1 = getString(2131764507, new Object[] { this.Crn });
        this.CqV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject1, this.CqV.getTextSize()));
        label148:
        this.CqU.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject2, this.CqU.getTextSize()));
        if (!g.aAc()) {
          break label488;
        }
        localObject1 = p.aYB();
        if ((localObject1 == null) || (Util.isNullOrNil(this.goe))) {
          break label488;
        }
        localObject1 = ((j)localObject1).Mx(this.goe);
        if ((localObject1 != null) && (!Util.isNullOrNil(((i)localObject1).aYu()))) {
          break label488;
        }
        final long l = Util.nowMilliSecond();
        ay.a.iDq.a(this.goe, "", new ay.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(67981);
            if (paramAnonymousBoolean)
            {
              Log.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
              com.tencent.mm.aj.c.ap(paramAnonymousString, 3);
            }
            for (;;)
            {
              RemittanceBaseUI.e(RemittanceBaseUI.this);
              AppMethodBeat.o(67981);
              return;
              Log.w("MicroMsg.RemittanceBaseUI", "getContact failed");
            }
          }
        });
      }
    }
    label488:
    for (int i = 1;; i = 0)
    {
      if ((Util.isNullOrNil(this.goe)) && (!Util.isNullOrNil(this.CqO)))
      {
        Log.i("MicroMsg.RemittanceBaseUI", "use mRecvHeadimgurl(%s) to avatar, mReceiverAvatarIv:%s", new Object[] { this.CqO, this.CqT.getClass().getSimpleName() });
        if ((this.CqT instanceof CdnImageView))
        {
          i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 44.0F);
          ((CdnImageView)this.CqT).setRoundCorner(true);
          ((CdnImageView)this.CqT).s(this.CqO, i, i, 2131231957);
        }
      }
      while (i != 0)
      {
        return;
        localObject1 = getString(2131764506, new Object[] { com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10), this.Crn });
        break;
        localObject2 = localObject1;
        if (this.mScene != 6) {
          break label148;
        }
        localObject2 = getIntent().getStringExtra("receiver_tips");
        if (!Util.isNullOrNil(this.qnT)) {
          localObject1 = this.qnT;
        }
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject2 = getString(2131764505, new Object[] { localObject1 });
          break label148;
        }
        localObject2 = Util.safeFormatString((String)localObject2, new Object[] { localObject1 });
        break label148;
      }
      eNP();
      return;
    }
  }
  
  private void eNP()
  {
    final Runnable local30 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67982);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(RemittanceBaseUI.this.goe, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceBaseUI.this.CqT.setImageResource(2131231957);
          AppMethodBeat.o(67982);
          return;
        }
        RemittanceBaseUI.this.CqT.setImageBitmap(localBitmap);
        AppMethodBeat.o(67982);
      }
    };
    if (MMHandlerThread.isMainThread())
    {
      local30.run();
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67983);
        local30.run();
        AppMethodBeat.o(67983);
      }
    });
  }
  
  private boolean eNQ()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  private boolean f(final w paramw)
  {
    if (paramw.Cpc)
    {
      this.CrE = true;
      f.a(this, this.mScene, paramw.Cpf / 100.0D, paramw.Cpe / 100.0D, paramw.CoZ / 100.0D, paramw.Cpb, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67963);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RemittanceBaseUI.this.showLoading();
          RemittanceBaseUI.this.a(paramw.dNQ, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, paramw);
          if (RemittanceBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67963);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  public void Mr(String paramString)
  {
    Log.i("MicroMsg.RemittanceBaseUI", "onGet");
    if (Util.nullAsNil(paramString).length() <= 0) {
      Log.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.goe)) {
      return;
    }
    eNP();
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final w paramw)
  {
    Log.i("MicroMsg.RemittanceBaseUI", "startPay mKindaEnable %s reqKey %s", new Object[] { Boolean.valueOf(this.mKindaEnable), paramString1 });
    if (b(paramw))
    {
      if (paramw.Cpw.Lko == 0)
      {
        this.CrG = paramw.Cpw;
        a(paramw, paramw.Cpw);
      }
      do
      {
        return;
        if (paramw.Cpw.Lko == 1)
        {
          localObject1 = new le();
          ((le)localObject1).eXN = ((int)paramw.Cpj);
          localObject1 = ((le)localObject1).yr(paramw.username);
          ((le)localObject1).eXG = 4L;
          ((le)localObject1).bfK();
          com.tencent.mm.ui.base.h.a(this, paramw.Cpw.dQx, paramw.Cpw.title, getResources().getString(2131764607), getResources().getString(2131764606), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67968);
              Log.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.h(RemittanceBaseUI.this) });
              paramAnonymousDialogInterface = new le();
              paramAnonymousDialogInterface.eXN = ((int)paramw.Cpj);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.yr(paramw.username);
              paramAnonymousDialogInterface.eXG = 9L;
              paramAnonymousDialogInterface.bfK();
              paramw.Cpw = null;
              RemittanceBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(67968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67969);
              Log.i("MicroMsg.RemittanceBaseUI", "onClick1");
              paramAnonymousDialogInterface = new le();
              paramAnonymousDialogInterface.eXN = ((int)paramw.Cpj);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.yr(paramw.username);
              paramAnonymousDialogInterface.eXG = 8L;
              paramAnonymousDialogInterface.bfK();
              AppMethodBeat.o(67969);
            }
          }, 2131100973);
          return;
        }
      } while (paramw.Cpw.Lko != 2);
      com.tencent.mm.ui.base.h.a(this, paramw.Cpw.dQx, paramw.Cpw.title, getResources().getString(2131768713), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return;
    }
    if (this.CrA)
    {
      localObject1 = new le();
      ((le)localObject1).eXN = paramw.yRL;
      localObject1 = ((le)localObject1).yr(paramw.username);
      ((le)localObject1).eXG = 5L;
      ((le)localObject1).bfK();
    }
    this.CrA = false;
    if (this.mPayScene == 31) {
      aMk(this.Crm);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).dDL = paramString1;
    ((PayInfo)localObject1).dVv = this.mPayScene;
    if (this.mChannel > 0) {
      ((PayInfo)localObject1).channel = this.mChannel;
    }
    boolean bool = false;
    if ((this.mScene == 2) || (this.mScene == 5)) {
      bool = true;
    }
    paramString1 = new Bundle();
    paramString1.putString("extinfo_key_1", paramString2);
    paramString1.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
    paramString1.putString("extinfo_key_3", this.Crk);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.Crw);
    if (paramw != null) {
      paramString1.putString("extinfo_key_19", paramw.Cpt);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramw != null)
      {
        paramString1.putString("extinfo_key_11", paramw.Cph);
        paramString1.putInt("extinfo_key_12", paramw.Cpn);
        paramString1.putString("extinfo_key_13", paramw.Cpo);
        paramString1.putString("extinfo_key_14", paramw.Cpp);
        paramString1.putString("extinfo_key_17", paramw.Cpr);
        paramString1.putString("extinfo_key_18", paramw.Cps);
        i = paramw.Cpq;
      }
    }
    if (paramw != null) {
      paramString1.putInt("extinfo_key_15", paramw.yRL);
    }
    if (this.CqR)
    {
      paramString1.putBoolean("extinfo_key_23", this.CqR);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.APz);
      paramString1.putString("extinfo_key_26", this.Cri);
    }
    ((PayInfo)localObject1).iqp = paramString1;
    paramString1 = new Intent();
    Log.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.Crs);
      paramString1.putExtra("key_mch_info", this.CqP);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramw.Cpr);
      paramString1.putExtra("get_dynamic_code_extend", paramw.Cps);
      paramString1.putExtra("dynamic_code_spam_wording", paramw.Cpu);
      paramString1.putExtra("show_paying_wording", paramw.Cpt);
      paramString1.putExtra("key_transfer_qrcode_id", this.CqS);
      com.tencent.mm.plugin.report.service.h.CyF.a(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.CrH.alive();
      startActivityForResult(paramString1, 5);
      return;
    }
    if (this.mKindaEnable)
    {
      paramw = "";
      paramString3 = "";
      Object localObject2 = getString(2131768199);
      if (!Util.isNullOrNil(paramString2))
      {
        g.aAi();
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.arJ();
          paramw = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bpz(paramString3));
          if (Util.isNullOrNil(this.Crn))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramw = Util.safeFormatString((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(2131764592, new Object[] { com.tencent.mm.wallet_core.ui.f.bpz(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).iqp == null) {
          ((PayInfo)localObject1).iqp = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).iqp;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.Crn);
        ((Bundle)localObject2).putString("cashier_desc", paramw);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, (PayInfo)localObject1);
        return;
        paramString1 = "(" + this.Crn + ")";
        break;
        Log.e("MicroMsg.RemittanceBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        Log.e("MicroMsg.RemittanceBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.CqM, paramString1);
    if ((paramw.CoD != null) && (paramw.CoD.dKn.dKq != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.CoD.dKn.dKq, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.CoD.dKn.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void aMj(String paramString);
  
  public void eNI()
  {
    com.tencent.mm.plugin.remittance.model.u localu = new com.tencent.mm.plugin.remittance.model.u(this.goe, this.CqS);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public void eNJ() {}
  
  public abstract void eNK();
  
  public abstract void eNN();
  
  protected final void eNR()
  {
    aMj(this.mDesc);
  }
  
  protected void eNS()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", ad.eNA());
    localIntent.setClass(getContext(), SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    if ((this.mPayScene == 33) || (this.mPayScene == 32)) {
      return 2131496106;
    }
    if (Util.isEqual(this.CqQ, 0))
    {
      hideActionbarLine();
      return 2131496109;
    }
    return 2131496105;
  }
  
  public void initView()
  {
    if ((this.mPayScene == 33) || (this.mPayScene == 32))
    {
      setMMTitle(2131764500);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67950);
          if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
          {
            RemittanceBaseUI.this.eNI();
            RemittanceBaseUI.this.finish();
          }
          for (;;)
          {
            RemittanceBaseUI.this.eNJ();
            AppMethodBeat.o(67950);
            return true;
            if ((RemittanceBaseUI.this.mScene == 2) || (RemittanceBaseUI.this.mScene == 5)) {
              RemittanceBaseUI.this.finish();
            } else {
              RemittanceBaseUI.this.eNS();
            }
          }
        }
      });
      this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
      this.mKBLayout = findViewById(2131308960);
      this.jVf = ((ScrollView)findViewById(2131307173));
      this.CqT = ((ImageView)findViewById(2131306923));
      this.CqU = ((TextView)findViewById(2131306924));
      this.CqV = ((TextView)findViewById(2131306925));
      this.CqV.setVisibility(8);
      this.Crd = ((LinearLayout)findViewById(2131306896));
      this.Crc = ((LinearLayout)findViewById(2131306905));
      this.Cra = ((TextView)findViewById(2131306903));
      this.Crb = ((TextView)findViewById(2131306904));
      this.CqZ = ((TextView)findViewById(2131306899));
      if (Util.isEqual(this.CqQ, 0))
      {
        this.Cre = ((LinearLayout)findViewById(2131306843));
        this.Crf = ((TextView)findViewById(2131305219));
        this.Crg = ((TextView)findViewById(2131296552));
      }
      eNO();
      this.qAh = ((WalletFormView)findViewById(2131304847));
      if (this.mPayScene != 33) {
        break label657;
      }
      this.Cra.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.jVp));
      this.Crb.setText(ah.hhz());
      this.Crk = getIntent().getStringExtra("desc");
      if (Util.isNullOrNil(this.Crk)) {
        break label645;
      }
      this.CqZ.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.Crk, this.CqZ.getTextSize()));
      this.CqZ.setVisibility(0);
      label358:
      this.Crc.setVisibility(0);
      this.Crd.setVisibility(8);
      label375:
      this.krs = ((Button)findViewById(2131305423));
      this.krs.setOnClickListener(new x()
      {
        public final void czW()
        {
          AppMethodBeat.i(67960);
          RemittanceBaseUI localRemittanceBaseUI;
          String str;
          if (RemittanceBaseUI.this.mPayScene == 33)
          {
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.aMj(str);
            if (RemittanceBaseUI.b(RemittanceBaseUI.this) == 0.0D)
            {
              if (RemittanceBaseUI.this.mScene != 1) {
                break label260;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceBaseUI.this.mScene == 1) && (!Util.isNullOrNil(RemittanceBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.CyF.a(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(67960);
            return;
            RemittanceBaseUI.this.jVp = Util.getDouble(RemittanceBaseUI.this.qAh.getText(), 0.0D);
            if (!RemittanceBaseUI.this.qAh.bql())
            {
              com.tencent.mm.ui.base.u.makeText(RemittanceBaseUI.this.getContext(), 2131767474, 0).show();
              break;
            }
            if (RemittanceBaseUI.this.jVp < 0.01D)
            {
              RemittanceBaseUI.this.eNK();
              break;
            }
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.eNT();
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.aMj(str);
            break;
            label260:
            com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      });
      this.CqX = ((TextView)findViewById(2131306869));
      this.CqY = ((TextView)findViewById(2131296537));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label778;
      }
      this.CqY.setText(2131764484);
    }
    for (;;)
    {
      if (!z.aUo()) {
        findViewById(2131306870).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67977);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.eNT();
            com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
            {
              localObject = RemittanceBaseUI.this.getString(2131764484);
              paramAnonymousView = RemittanceBaseUI.this.getString(2131764511);
              com.tencent.mm.plugin.report.service.h.CyF.a(14074, new Object[] { Integer.valueOf(1) });
            }
            String str1;
            String str2;
            do
            {
              do
              {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, (String)localObject, RemittanceBaseUI.this.mDesc, paramAnonymousView, 20, new h.b()new DialogInterface.OnClickListener
                {
                  public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
                  {
                    AppMethodBeat.i(67974);
                    if (!Util.isNullOrNil(paramAnonymous2CharSequence.toString()))
                    {
                      RemittanceBaseUI.this.mDesc = paramAnonymous2CharSequence.toString();
                      RemittanceBaseUI.d(RemittanceBaseUI.this);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(67974);
                      return true;
                      RemittanceBaseUI.this.mDesc = null;
                      RemittanceBaseUI.d(RemittanceBaseUI.this);
                    }
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(67976);
                    MMHandlerThread.postToMainThreadDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(67975);
                        RemittanceBaseUI.this.hideVKB();
                        AppMethodBeat.o(67975);
                      }
                    }, 500L);
                    AppMethodBeat.o(67976);
                  }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67977);
                return;
                str1 = RemittanceBaseUI.this.getString(2131764483);
                str2 = RemittanceBaseUI.this.getString(2131764490);
                localObject = str1;
                paramAnonymousView = str2;
              } while (!Util.isEqual(RemittanceBaseUI.a(RemittanceBaseUI.this), 0));
              localObject = str1;
              paramAnonymousView = str2;
            } while (!RemittanceBaseUI.this.CqR);
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str1, RemittanceBaseUI.this.mDesc, str2, RemittanceBaseUI.this.Crj, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.APz, RemittanceBaseUI.this.Cri, new a.a()new f.c
            {
              public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
              {
                AppMethodBeat.i(67971);
                RemittanceBaseUI.this.Crj = paramAnonymous2Boolean;
                if (!Util.isNullOrNil(paramAnonymous2String1))
                {
                  RemittanceBaseUI.this.mDesc = paramAnonymous2String1;
                  if (RemittanceBaseUI.this.Crj) {
                    break label188;
                  }
                  if (Util.isNullOrNil(paramAnonymous2String2)) {
                    break label146;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymous2String2;
                  label65:
                  if (Util.isNullOrNil(paramAnonymous2String3)) {
                    break label160;
                  }
                  RemittanceBaseUI.this.APz = paramAnonymous2String3;
                  label85:
                  if (Util.isNullOrNil(paramAnonymous2String4)) {
                    break label174;
                  }
                  RemittanceBaseUI.this.Cri = paramAnonymous2String4;
                }
                for (;;)
                {
                  RemittanceBaseUI.c(RemittanceBaseUI.this);
                  RemittanceBaseUI.d(RemittanceBaseUI.this);
                  AppMethodBeat.o(67971);
                  return true;
                  RemittanceBaseUI.this.mDesc = null;
                  break;
                  label146:
                  RemittanceBaseUI.this.mName = null;
                  break label65;
                  label160:
                  RemittanceBaseUI.this.APz = null;
                  break label85;
                  label174:
                  RemittanceBaseUI.this.Cri = null;
                  continue;
                  label188:
                  RemittanceBaseUI.this.mName = null;
                  RemittanceBaseUI.this.APz = null;
                  RemittanceBaseUI.this.Cri = null;
                }
              }
            }, new f.c()
            {
              public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(67973);
                MMHandlerThread.postToMainThreadDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(67972);
                    RemittanceBaseUI.this.hideVKB();
                    AppMethodBeat.o(67972);
                  }
                }, 500L);
                AppMethodBeat.o(67973);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67977);
          }
        });
      }
      if (this.mScene == 1)
      {
        g.aAi();
        if (((String)g.aAh().azQ().get(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131764557, 2131764558, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          g.aAi();
          g.aAh().azQ().set(327732, "1");
          g.aAi();
          g.aAh().azQ().gBI();
        }
      }
      this.CqW = ((TextView)findViewById(2131305945));
      this.Crh = ((LinearLayout)findViewById(2131306914));
      eNM();
      eNN();
      eNL();
      if ((this.mPayScene != 33) && (this.mPayScene == 32)) {}
      return;
      setMMTitle(2131764602);
      break;
      label645:
      this.CqZ.setVisibility(8);
      break label358;
      label657:
      this.qAh.setOnClickListener(new RemittanceBaseUI.32(this));
      this.qAh.getTitleTv().setText(String.format(getString(2131764553), new Object[] { "¥" }));
      this.qAh.a(new RemittanceBaseUI.2(this));
      setEditFocusListener(this.qAh, 2, false);
      findViewById(2131305945);
      findViewById(2131306914).setVisibility(0);
      this.Crc.setVisibility(8);
      this.Crd.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(67952);
          if (paramAnonymousBoolean)
          {
            RemittanceBaseUI.a(RemittanceBaseUI.this, RemittanceBaseUI.this.jVf, RemittanceBaseUI.this.krs);
            AppMethodBeat.o(67952);
            return;
          }
          RemittanceBaseUI.this.jVf.scrollTo(0, 0);
          AppMethodBeat.o(67952);
        }
      });
      break label375;
      label778:
      this.CqY.setText(2131764483);
    }
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    Log.i("MicroMsg.RemittanceBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + Util.nullAs(this.goe, "null") + ", =" + Util.nullAs(this.qnT, "null"));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      bool1 = bool2;
      if (paramInt2 == -1) {
        bool1 = true;
      }
      a(bool1, paramIntent);
      continue;
      if (paramInt2 == -1) {}
      for (;;)
      {
        a(bool1, paramIntent);
        break;
        bool1 = false;
      }
      String str1;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra("Select_Conv_User");
        if (!Util.isNullOrNil(str1))
        {
          this.goe = str1;
          eNO();
        }
        else
        {
          finish();
        }
      }
      else
      {
        finish();
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          hideTenpayKB();
          str1 = getString(2131756529);
          String str2 = getString(2131764511);
          String str3 = paramIntent.getStringExtra("userName");
          String str4 = paramIntent.getStringExtra("telNumber");
          String str5 = paramIntent.getStringExtra("proviceFirstStageName") + paramIntent.getStringExtra("addressCitySecondStageName") + paramIntent.getStringExtra("addressCountiesThirdStageName") + paramIntent.getStringExtra("addressDetailInfo");
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, str1, this.mDesc, str2, false, str3, str4, str5, new a.a()new f.c
          {
            public final boolean a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
            {
              AppMethodBeat.i(67964);
              RemittanceBaseUI.this.Crj = paramAnonymousBoolean;
              if (!Util.isNullOrNil(paramAnonymousString1))
              {
                RemittanceBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceBaseUI.this.Crj)
                {
                  if (Util.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (Util.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceBaseUI.this.APz = paramAnonymousString3;
                  label70:
                  if (Util.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceBaseUI.this.Cri = paramAnonymousString4;; RemittanceBaseUI.this.Cri = null)
              {
                RemittanceBaseUI.c(RemittanceBaseUI.this);
                RemittanceBaseUI.d(RemittanceBaseUI.this);
                AppMethodBeat.o(67964);
                return true;
                RemittanceBaseUI.this.mDesc = null;
                break;
                label119:
                RemittanceBaseUI.this.mName = null;
                break label53;
                RemittanceBaseUI.this.APz = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(67966);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67965);
                  RemittanceBaseUI.this.hideVKB();
                  AppMethodBeat.o(67965);
                }
              }, 500L);
              AppMethodBeat.o(67966);
            }
          });
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    if (!eNQ())
    {
      this.dRM = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.aUU(this.dRM);
    }
    long l;
    if ((this instanceof RemittanceHKUI))
    {
      this.CqQ = 1;
      super.onCreate(paramBundle);
      this.CqM = com.tencent.mm.plugin.wallet.a.be(getIntent());
      this.CqS = getIntent().getStringExtra("scan_remittance_id");
      this.jVp = getIntent().getDoubleExtra("fee", 0.0D);
      this.goe = getIntent().getStringExtra("receiver_name");
      this.CqO = getIntent().getStringExtra("recv_headimgurl");
      this.qnT = getIntent().getStringExtra("receiver_nick_name");
      this.Crn = getIntent().getStringExtra("receiver_true_name");
      this.CqN = getIntent().getStringExtra("mch_name");
      this.CqP = getIntent().getStringExtra("mch_info");
      this.mChannel = getIntent().getIntExtra("pay_channel", 0);
      this.Crs = Util.nullAs(getIntent().getStringExtra("rcvr_open_id"), "");
      Log.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[] { this.goe });
      g.aAi();
      l = ((Long)g.aAh().azQ().get(147457, Long.valueOf(0L))).longValue();
      if ((0x10 & l) == 0L) {
        break label342;
      }
      this.Crr = 1;
    }
    for (;;)
    {
      p.aYn().a(this);
      initView();
      this.CrM.alive();
      com.tencent.mm.wallet_core.b.hgC();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
      return;
      if (!(this instanceof RemittanceOSUI)) {
        break;
      }
      this.CqQ = 2;
      break;
      label342:
      if ((l & 0x20) != 0L) {
        this.Crr = 2;
      } else {
        this.Crr = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    EventCenter.instance.removeListener(this.CrB);
    p.aYn().b(this);
    this.CrM.dead();
    this.CrH.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aUV(this.dRM);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    this.Cru = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof w))
      {
        paramq = (w)paramq;
        af.z(this.mPayScene, paramq.dNQ, paramInt2);
        this.Crm = paramq.CoY;
        if (!Util.isNullOrNil(paramq.Cpg)) {
          this.Crn = paramq.Cpg;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.Crw = paramq.qvD;
          if (this.CqM != null) {
            this.CqM.k(10000, new Object[] { Integer.valueOf(this.mPayScene), this.goe, Double.valueOf(paramq.Cpj) });
          }
          if (paramq.Cpw != null) {
            break label278;
          }
          paramString = "";
          label158:
          this.Crt = paramString;
          if (a(paramq)) {
            break label312;
          }
          a(paramq.dNQ, this.goe, this.Crn, paramq);
          label191:
          paramString = new a(paramq.Cph, paramq.qvD, paramq.qya, paramq.Cpi, paramq.yRL, paramq.dQp, paramq.dDM, paramq.Cpm, Util.getLong(paramq.Cpk, 0L));
          this.Crv.put(paramq.dNQ, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.Crw = paramq.dQp;
        break;
        label278:
        if (Util.isNullOrNil(paramq.Cpw.Crt))
        {
          paramString = this.Crt;
          break label158;
        }
        paramString = paramq.Cpw.Crt;
        break label158;
        label312:
        if (!this.mKindaEnable) {
          break label191;
        }
        hideLoading();
        break label191;
        if ((paramq instanceof ai))
        {
          paramString = (ai)paramq;
          if (!Util.isNullOrNil(paramString.HQt))
          {
            ((TextView)findViewById(2131306938)).setText(paramString.HQt);
            paramq = findViewById(2131309147);
            paramq.setVisibility(0);
            paramq.setOnClickListener(new RemittanceBaseUI.4(this));
          }
          this.Crl = paramString.Crl;
          this.Cpd = paramString.Cpd;
          if (this.Cpd == 0.0D) {
            if (this.mScene == 1) {
              com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(14), Integer.valueOf(1) });
            } else {
              com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            }
          }
        }
        else if ((paramq instanceof aj))
        {
          this.Cro = ((aj)paramq).lJj;
          this.Crp = ((aj)paramq).HQy;
          this.Crq = ((aj)paramq).HQz;
          eNM();
          eNL();
        }
      }
    }
    if ((paramq instanceof aj))
    {
      Log.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
      this.CqW.setText("");
      this.CqW.setVisibility(8);
    }
    do
    {
      do
      {
        return false;
      } while (!(paramq instanceof w));
      if (this.mKindaEnable) {
        hideLoading();
      }
      this.Cry = ((w)paramq);
      EventCenter.instance.add(this.CrB);
      af.z(this.mPayScene, "", paramInt2);
    } while (!c((w)paramq));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    String Cph;
    String Cpi;
    String Cpm;
    long CrW;
    String dDM;
    String dQp;
    String qvD;
    String qya;
    int yRL;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.Cph = paramString1;
      this.qvD = paramString2;
      this.qya = paramString3;
      this.Cpi = paramString4;
      this.yRL = paramInt;
      this.dQp = paramString5;
      this.dDM = paramString6;
      this.Cpm = paramString7;
      this.CrW = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
 * JD-Core Version:    0.7.0.1
 */