package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.au;
import com.tencent.mm.f.a.gr;
import com.tencent.mm.f.a.gs;
import com.tencent.mm.f.a.gs.a;
import com.tencent.mm.f.a.gt;
import com.tencent.mm.f.a.sm;
import com.tencent.mm.f.b.a.bd;
import com.tencent.mm.f.b.a.nt;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.remittance.model.k;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.protocal.protobuf.fic;
import com.tencent.mm.protocal.protobuf.fid;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.zk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.picker.d.2;
import com.tencent.mm.ui.widget.picker.d.3;
import com.tencent.mm.ui.widget.picker.d.b;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.l.7;
import com.tencent.mm.wallet_core.c.l.8;
import com.tencent.mm.wallet_core.c.l.9;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class RemittanceBusiUI
  extends WalletBaseUI
  implements WcPayKeyboard.a
{
  private String GCu;
  private int Iko;
  private IListener<au> InK;
  private LinearLayout IoC;
  private String IoQ;
  private boolean IoV;
  private nt IoX;
  private String Iom;
  private String IpQ;
  private String IpR;
  private String IpV;
  private BusiRemittanceResp IpZ;
  private boolean Ipa;
  private boolean Ipd;
  private IListener Ipf;
  private TextView IqA;
  private TextView IqB;
  private TextView IqC;
  private TextView IqD;
  private TextView IqE;
  private View IqF;
  private CdnImageView IqG;
  private LinearLayout IqH;
  private LinearLayout IqI;
  private TextView IqJ;
  private View IqK;
  private TextView IqL;
  private Button IqM;
  private RelativeLayout IqN;
  private String IqO;
  private double IqP;
  private String IqQ;
  private String IqR;
  private String IqS;
  private String IqT;
  private String IqU;
  private int IqV;
  private String IqW;
  private float IqX;
  private boolean IqY;
  private String IqZ;
  private TextView Iqy;
  private TextView Iqz;
  private int IrA;
  private int IrB;
  private k IrC;
  private LinearLayout IrD;
  private LinearLayout IrE;
  private LinearLayout IrF;
  private TextView IrG;
  private CdnImageView IrH;
  private CdnImageView IrI;
  private TextView IrJ;
  private Runnable IrK;
  private com.tencent.mm.wallet_core.d.c<com.tencent.mm.plugin.remittance.model.n> IrL;
  private RemittanceBusiUI.c IrM;
  private boolean IrN;
  private double IrO;
  private String IrP;
  private String IrQ;
  private IListener IrR;
  private IListener IrS;
  private IListener IrT;
  private IListener IrU;
  private int Ira;
  private int Irb;
  private String Irc;
  private esi Ird;
  private String Ire;
  private int Irf;
  private int Irg;
  private int Irh;
  private int Iri;
  private String Irj;
  private int Irk;
  private String Irl;
  private b Irm;
  private String Irn;
  private String Iro;
  boolean Irp;
  private boolean Irq;
  i Irr;
  private b Irs;
  private b Irt;
  protected boolean Iru;
  private Map<String, ds> Irv;
  private RemittanceF2fDynamicCodeUI Irw;
  private boolean Irx;
  private int Iry;
  private boolean Irz;
  private String app_id;
  private String fLj;
  private int fRV;
  private double fwy;
  private int mChannel;
  private Runnable mMK;
  private int mMr;
  private ScrollView mMs;
  private WcPayKeyboard mMt;
  private WalletFormView mMw;
  private RelativeLayout mMx;
  private TextView mMy;
  private RelativeLayout mMz;
  private int mPayScene;
  private int mRequestCode;
  private int state;
  
  public RemittanceBusiUI()
  {
    AppMethodBeat.i(68056);
    this.IqX = 0.0F;
    this.Iko = 4;
    this.Irf = 0;
    this.Irg = 0;
    this.Irh = 0;
    this.Iri = 0;
    this.Irm = new b();
    this.Irn = "";
    this.Iro = "";
    this.Irp = false;
    this.fwy = -1.0D;
    this.Irq = false;
    this.Irr = null;
    this.IoV = false;
    this.Iru = false;
    this.mRequestCode = 0;
    this.Irv = new HashMap();
    this.Irw = null;
    this.Irx = false;
    this.Irz = false;
    this.state = 0;
    this.mMK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68025);
        if ((RemittanceBusiUI.g(RemittanceBusiUI.this) == 2) && (RemittanceBusiUI.this.isHandleAutoShowNormalStWcKb())) {
          RemittanceBusiUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(68025);
      }
    };
    this.IrK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68028);
        RemittanceBusiUI.M(RemittanceBusiUI.this);
        AppMethodBeat.o(68028);
      }
    };
    this.IrL = new RemittanceBusiUI.21(this);
    this.IrM = new RemittanceBusiUI.c(this);
    this.InK = new RemittanceBusiUI.22(this);
    this.IrN = true;
    this.fRV = 0;
    this.IrO = 0.0D;
    this.IrQ = "";
    this.Ipf = new IListener() {};
    this.IrR = new IListener() {};
    this.IrS = new IListener() {};
    this.IrT = new RemittanceBusiUI.32(this);
    this.IrU = new IListener() {};
    AppMethodBeat.o(68056);
  }
  
  private void H(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(68075);
    Log.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ds localds = (ds)this.Irv.get(paramString);
    if (localds == null)
    {
      AppMethodBeat.o(68075);
      return;
    }
    esi localesi = this.Ird;
    String str = this.Irc;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = new com.tencent.mm.plugin.remittance.model.n(localesi, localds, str, i, this.Ire, paramString);
      if (!paramBoolean) {
        break;
      }
      paramString.hasRetried = true;
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
      AppMethodBeat.o(68075);
      return;
    }
    this.Iri = 0;
    doSceneForceProgress(paramString);
    AppMethodBeat.o(68075);
  }
  
  private void a(int paramInt, qv paramqv, boolean paramBoolean, gs paramgs, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68077);
    a(paramInt, paramqv, paramBoolean, paramgs, paramString1, paramString2, "");
    AppMethodBeat.o(68077);
  }
  
  private void a(int paramInt, qv paramqv, boolean paramBoolean, gs paramgs, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163834);
    int i = 0;
    int j = 0;
    if (!this.IrN)
    {
      boolean bool1 = Util.isEqual(Double.valueOf(this.IrO), Double.valueOf(this.IqP));
      boolean bool2 = Util.isEqual(this.IrP, this.IpR);
      if (!bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        i = j | 0x2;
      }
    }
    String str1 = this.IoQ;
    String str2 = this.IqO;
    j = this.mPayScene;
    String str3 = this.IqT;
    String str4 = this.IpR;
    int k = this.mChannel;
    String str5 = this.IqU;
    String str6 = this.IqZ;
    int m = this.Irb;
    int n = this.Ira;
    String str7 = this.IqQ;
    aos localaos = this.Irm.InO;
    if (paramqv == null)
    {
      paramqv = "";
      paramString1 = new k(str1, str2, j, str3, str4, paramInt, k, str5, str6, m, n, str7, localaos, paramqv, this.IpZ.Ilb, paramString1, this.Iom, paramString2, this.IqR, this.IrQ, this.fRV, i, paramString3);
      if (paramBoolean) {
        paramString1.a(paramgs);
      }
      if (!this.mKindaEnable) {
        break label363;
      }
      if (this.Irw == null) {
        break label356;
      }
      this.Irw.showSafeProgress();
    }
    label259:
    label391:
    label404:
    for (;;)
    {
      label255:
      paramBoolean = false;
      paramqv = this;
      paramqv.doSceneProgress(paramString1, paramBoolean);
      if (this.Irx)
      {
        if (paramInt == this.Iry) {
          a(5, this.IrC);
        }
      }
      else {
        label290:
        if ((e.fAJ().getContext() != null) && ((e.fAJ().getContext() instanceof RemittanceBusiUI))) {
          if (this.Irz)
          {
            if (paramInt != this.IrB) {
              break label391;
            }
            a(13, this.IrC);
          }
        }
      }
      for (;;)
      {
        this.IrB = paramInt;
        AppMethodBeat.o(163834);
        return;
        paramqv = paramqv.RZj;
        break;
        label356:
        showLoading();
        break label255;
        label363:
        if (e.fAJ().fAM()) {
          break label404;
        }
        paramBoolean = true;
        paramqv = this;
        break label259;
        a(4, this.IrC);
        break label290;
        a(12, this.IrC);
      }
    }
  }
  
  private void a(com.tencent.mm.plugin.remittance.model.d paramd, com.tencent.mm.plugin.remittance.model.e parame, int paramInt)
  {
    AppMethodBeat.i(68069);
    int j;
    int k;
    int m;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    if (this.Irp)
    {
      this.IqL.setText(g.formatMoney2f(fAP()));
      MMHandlerThread.removeRunnable(this.IrK);
      this.IqP = fAP();
      long l = Math.round(this.IqP * 100.0D);
      if (l <= 0L)
      {
        this.Irm.fAs();
        this.IqE.setTextColor(getContext().getResources().getColor(a.c.desc_text_color));
        this.IqE.setText(this.IpZ.Ila);
        if (this.Irr != null) {
          this.Irr.cancel = true;
        }
        AppMethodBeat.o(68069);
        return;
      }
      j = (int)l;
      k = this.mChannel;
      m = this.IpZ.Ilb;
      str1 = this.IqT;
      str2 = this.Iom;
      str3 = this.IpZ.Ilc;
      str4 = this.IoQ;
      str5 = this.IqQ;
      str6 = this.IpZ.Ild;
      if (paramd != null) {
        break label243;
      }
    }
    label243:
    for (int i = 0;; i = 1)
    {
      this.Irr = new i(j, k, m, str1, str2, str3, str4, str5, str6, i, paramd, parame);
      MMHandlerThread.postToMainThreadDelayed(this.IrK, paramInt);
      AppMethodBeat.o(68069);
      return;
    }
  }
  
  private void a(rb paramrb)
  {
    AppMethodBeat.i(68085);
    Log.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(paramrb.RZI) });
    if (paramrb.RZI == 1)
    {
      paramrb = new Bundle();
      EventCenter.instance.addListener(this.IrT);
      paramrb.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
      paramrb.putString("realname_verify_process_jump_plugin", "remittance");
      paramrb.putInt("real_name_verify_mode", 0);
      paramrb.putInt("entry_scene", this.mPayScene);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramrb);
      AppMethodBeat.o(68085);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject;
    if (!Util.isNullOrNil(this.Irl)) {
      localObject = this.Irl;
    }
    for (;;)
    {
      localIntent.putExtra("INTENT_TITLE", (String)localObject);
      localIntent.putExtra("INTENT_CAN_TOUCH", this.Irf);
      localIntent.putExtra("INTENT_PAYFEE", g.formatMoney2f(0.0D));
      localIntent.putExtra("INTENT_REQKEY", paramrb.fHb);
      paramrb = paramrb.RZJ;
      try
      {
        localIntent.putExtra("INTENT_TOKENMESS", paramrb.toByteArray());
        com.tencent.mm.by.c.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", localIntent, 2);
        AppMethodBeat.o(68085);
        return;
      }
      catch (Exception paramrb)
      {
        String str;
        StringBuilder localStringBuilder;
        Log.printErrStackTrace("MicroMsg.RemittanceBusiUI", paramrb, "", new Object[0]);
        AppMethodBeat.o(68085);
      }
      str = getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
      if (!Util.isNullOrNil(this.IqQ))
      {
        com.tencent.mm.kernel.h.aHH();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(this.IqQ);
        if (localObject != null)
        {
          localObject = ((as)localObject).ays();
          localStringBuilder = new StringBuilder().append(g.bCw((String)localObject));
          if (Util.isNullOrNil(this.IqR)) {}
          for (localObject = "";; localObject = "(" + this.IqR + ")")
          {
            localObject = Util.safeFormatString(str, new Object[] { (String)localObject });
            break;
          }
        }
        Log.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.IqQ);
        localObject = "";
      }
      else
      {
        Log.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        localObject = "";
      }
    }
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68073);
    if (paramBoolean)
    {
      String str1 = paramIntent.getStringExtra("key_trans_id");
      double d = paramIntent.getDoubleExtra("key_total_fee", -1.0D);
      String str2 = paramIntent.getStringExtra("key_reqKey");
      Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[] { str1, Double.valueOf(d) });
      if (Util.isNullOrNil(this.GCu)) {
        this.GCu = str1;
      }
      if (d >= 0.0D) {
        this.fwy = d;
      }
      if (this.IoV) {
        com.tencent.mm.plugin.report.service.h.IzE.a(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      fAT();
      aWP(str2);
    }
    for (;;)
    {
      c(paramBoolean, paramIntent);
      AppMethodBeat.o(68073);
      return;
      if (ag.bL(paramIntent))
      {
        finish();
        AppMethodBeat.o(68073);
        return;
      }
      if (ag.bM(paramIntent))
      {
        AppMethodBeat.o(68073);
        return;
      }
      Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
      fAS();
    }
  }
  
  private boolean a(k paramk)
  {
    AppMethodBeat.i(68079);
    boolean bool1 = false;
    if (!this.Ipa) {
      bool1 = b(paramk);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = c(paramk);
    }
    AppMethodBeat.o(68079);
    return bool2;
  }
  
  private void aWP(String paramString)
  {
    AppMethodBeat.i(68086);
    Log.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", new Object[] { paramString });
    paramString = (ds)this.Irv.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(68086);
      return;
    }
    if (!Util.isNullOrNil(this.GCu)) {
      paramString.InV = this.GCu;
    }
    doSceneProgress(new j(paramString, this.Irn), false);
    AppMethodBeat.o(68086);
  }
  
  private void acU(int paramInt)
  {
    AppMethodBeat.i(205233);
    if (this.IqY) {}
    for (TextView localTextView = this.IqA;; localTextView = this.IrJ)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), paramInt);
      localTextView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(205233);
      return;
    }
  }
  
  private boolean b(final k paramk)
  {
    AppMethodBeat.i(68080);
    if (!Util.isNullOrNil(paramk.IlD.RZC))
    {
      this.Ipa = true;
      bV(1, paramk.IlD.RJf);
      e.fAJ().a(paramk.IlD.RZC, getString(a.i.app_remind), getString(a.i.remittance_busi_continue_text), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163824);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 3, paramk.IlD.RJf);
          if (!RemittanceBusiUI.b(RemittanceBusiUI.this, paramk))
          {
            if (RemittanceBusiUI.T(RemittanceBusiUI.this))
            {
              if (RemittanceBusiUI.P(RemittanceBusiUI.this) == null) {
                break label84;
              }
              RemittanceBusiUI.P(RemittanceBusiUI.this).showSafeProgress();
            }
            for (;;)
            {
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramk);
              AppMethodBeat.o(163824);
              return;
              label84:
              RemittanceBusiUI.this.showLoading();
            }
          }
          RemittanceBusiUI.U(RemittanceBusiUI.this);
          AppMethodBeat.o(163824);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163825);
          RemittanceBusiUI.U(RemittanceBusiUI.this);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 2, paramk.IlD.RJf);
          AppMethodBeat.o(163825);
        }
      });
      AppMethodBeat.o(68080);
      return true;
    }
    AppMethodBeat.o(68080);
    return false;
  }
  
  private void bV(int paramInt, String paramString)
  {
    AppMethodBeat.i(68081);
    this.IoX = new nt();
    this.IoX.gnP = 1L;
    this.IoX.gef = paramInt;
    this.IoX.EH(paramString);
    this.IoX.bpa();
    AppMethodBeat.o(68081);
  }
  
  private void c(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68074);
    this.IrN = false;
    if (paramBoolean)
    {
      Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
      this.fRV = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", new Object[] { Double.valueOf(this.IrO), Double.valueOf(this.IrO), this.IrP, this.IrQ });
      AppMethodBeat.o(68074);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(68074);
        return;
      }
      this.fRV = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.IrO = this.IqP;
      this.IrP = this.IpR;
      this.IrQ = this.IpQ;
    }
  }
  
  private boolean c(final k paramk)
  {
    AppMethodBeat.i(68083);
    if (paramk.IlD.RZD != null)
    {
      this.Ipd = true;
      e.fAJ().a(paramk.IlD.tqb, "", paramk.IlD.RZD.oDK, paramk.IlD.RZD.oDJ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(275552);
          Log.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { paramk.IlD.RZD.tVu });
          g.p(RemittanceBusiUI.this.getContext(), paramk.IlD.RZD.tVu, false);
          AppMethodBeat.o(275552);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(68083);
      return true;
    }
    AppMethodBeat.o(68083);
    return false;
  }
  
  private void d(k paramk)
  {
    AppMethodBeat.i(68084);
    Log.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(paramk.IlD.RZH) });
    if (e.fAJ().fAL()) {
      Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitLMRemindUI");
    }
    Object localObject1 = new ds();
    ((ds)localObject1).channel = this.mChannel;
    ((ds)localObject1).RJf = this.IpQ;
    ((ds)localObject1).InV = this.GCu;
    ((ds)localObject1).Ilb = this.IpZ.Ilb;
    ((ds)localObject1).scene = this.mPayScene;
    ((ds)localObject1).RJg = this.IpV;
    ((ds)localObject1).RJh = this.Irm.InO;
    ((ds)localObject1).llO = this.IqQ;
    ((ds)localObject1).ImY = this.IoQ;
    ((ds)localObject1).RJi = paramk.GVj;
    this.Irv.put(paramk.IlD.fHb, localObject1);
    if (paramk.IlD.RZH == 1)
    {
      a(paramk.IlD);
      AppMethodBeat.o(68084);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.fwv = paramk.IlD.fHb;
    localPayInfo.fOY = this.mPayScene;
    if (this.mChannel > 0) {
      localPayInfo.channel = this.mChannel;
    }
    if (paramk.IlD.RZO != null) {
      localPayInfo.ByB = paramk.IlD.RZO.Ap();
    }
    localPayInfo.PbP = paramk.IlD.RZN;
    Object localObject2;
    if (paramk.IlD.RZP == 1)
    {
      bool = true;
      localPayInfo.ORb = bool;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("extinfo_key_1", this.IqQ);
      ((Bundle)localObject1).putString("extinfo_key_2", this.IqR);
      ((Bundle)localObject1).putString("extinfo_key_3", this.IqT);
      ((Bundle)localObject1).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
      ((Bundle)localObject1).putString("extinfo_key_7", this.IpR);
      ((Bundle)localObject1).putString("extinfo_key_19", paramk.IlD.ImI);
      localPayInfo.lfu = ((Bundle)localObject1);
      localPayInfo.ImU = 1;
      localObject2 = new Intent();
      if (paramk.IlD.ImF != 1) {
        break label718;
      }
      ((Bundle)localObject1).putInt("extinfo_key_15", paramk.IlD.RZQ);
      ((Bundle)localObject1).putString("extinfo_key_17", paramk.IlD.ImG);
      ((Bundle)localObject1).putString("extinfo_key_18", paramk.IlD.ImH);
      ((Intent)localObject2).putExtra("key_pay_info", localPayInfo);
      ((Intent)localObject2).putExtra("from_patch_ui", true);
      ((Intent)localObject2).putExtra("key_rcvr_open_id", this.IoQ);
      ((Intent)localObject2).putExtra("key_mch_info", this.IqW);
      ((Intent)localObject2).putExtra("key_mch_photo", this.IpZ.IkZ);
      ((Intent)localObject2).putExtra("key_transfer_qrcode_id", this.IqO);
      ((Intent)localObject2).putExtra("get_dynamic_code_sign", paramk.IlD.ImG);
      ((Intent)localObject2).putExtra("get_dynamic_code_extend", paramk.IlD.ImH);
      ((Intent)localObject2).putExtra("dynamic_code_spam_wording", paramk.IlD.ImJ);
      ((Intent)localObject2).putExtra("dynamic_code_amount", paramk.IlD.RZQ);
      ((Intent)localObject2).putExtra("show_paying_wording", paramk.IlD.ImI);
      if (this.IpZ.Ili != 1) {
        break label713;
      }
    }
    label713:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("show_avatar_type", bool);
      com.tencent.mm.plugin.report.service.h.IzE.a(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      this.Ipf.alive();
      this.IrR.alive();
      this.IrS.alive();
      if (this.mKindaEnable) {
        hideLoading();
      }
      com.tencent.mm.by.c.b(this, "remittance", ".ui.RemittanceF2fDynamicCodeUI", (Intent)localObject2, 3);
      AppMethodBeat.o(68084);
      return;
      bool = false;
      break;
    }
    label718:
    if (this.mKindaEnable)
    {
      this.mRequestCode = 1;
      if (this.Irw != null) {
        this.mRequestCode = 3;
      }
      localObject1 = "";
      if (!Util.isNullOrNil(paramk.IlD.ImI))
      {
        localObject1 = paramk.IlD.ImI;
        if (localPayInfo.lfu == null) {
          localPayInfo.lfu = new Bundle();
        }
        localPayInfo.lfu.putString("cashier_desc", (String)localObject1);
        if (Util.isNullOrNil(this.IqQ)) {
          break label1498;
        }
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(this.IqQ);
        if (localObject1 == null) {
          break label1498;
        }
        localObject1 = ((as)localObject1).ays();
        localObject2 = new StringBuilder().append(g.bCw((String)localObject1));
        if (!Util.isNullOrNil(this.IqR)) {
          break label1324;
        }
        localObject1 = "";
      }
    }
    label1324:
    label1498:
    for (localObject1 = (String)localObject1;; localObject1 = "")
    {
      for (;;)
      {
        localPayInfo.lfu.putString("prepay_page_payee", (String)localObject1);
        localObject1 = new ds();
        ((ds)localObject1).channel = this.mChannel;
        ((ds)localObject1).RJf = this.IpQ;
        ((ds)localObject1).InV = this.GCu;
        ((ds)localObject1).Ilb = this.IpZ.Ilb;
        ((ds)localObject1).scene = this.mPayScene;
        ((ds)localObject1).RJg = this.IpV;
        ((ds)localObject1).RJh = this.Irm.InO;
        ((ds)localObject1).llO = this.IqQ;
        ((ds)localObject1).ImY = this.IoQ;
        ((ds)localObject1).RJi = paramk.GVj;
        try
        {
          localPayInfo.lfu.putByteArray("after_place_order_commreq", ((ds)localObject1).toByteArray());
          localPayInfo.lfu.putString("suc_page_extend", this.Iro);
          localPayInfo.lfu.putInt("fault_flag", this.Irk);
          localPayInfo.lfu.putString("suc_page_name", this.IpZ.Ilk);
          localPayInfo.lfu.putString("rece_photo_url", this.IpZ.IkZ);
          if (this.Irw != null)
          {
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this.Irw, localPayInfo);
            this.Iru = true;
            AppMethodBeat.o(68084);
            return;
            Object localObject3 = getIntent().getStringExtra("receiver_tips");
            localObject2 = getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
            if (!Util.isNullOrNil((String)localObject3))
            {
              localObject2 = localObject3;
              localObject1 = localObject3;
            }
            if (!Util.isNullOrNil(this.IqQ))
            {
              com.tencent.mm.kernel.h.aHH();
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(this.IqQ);
              if (localObject3 != null)
              {
                localObject1 = ((as)localObject3).ays();
                localObject3 = new StringBuilder().append(g.bCw((String)localObject1));
                if (Util.isNullOrNil(this.IqR)) {}
                for (localObject1 = "";; localObject1 = "(" + this.IqR + ")")
                {
                  localObject1 = Util.safeFormatString((String)localObject2, new Object[] { (String)localObject1 });
                  break;
                }
              }
              Log.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.IqQ);
              break;
            }
            Log.e("MicroMsg.RemittanceBusiUI", "mRcverName is null ,scene is MMPAY_PAY_SCENE_TRANSFER busi");
            break;
            localObject1 = "(" + this.IqR + ")";
          }
        }
        catch (IOException paramk)
        {
          for (;;)
          {
            Log.e("MicroMsg.RemittanceBusiUI", "reqPlaceOrder parse failed");
            continue;
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, localPayInfo);
          }
        }
      }
      if (!Util.isNullOrNil(paramk.IlE)) {}
      for (this.IoV = true; (paramk.IlF != null) && (paramk.IlF.fDc.fDf != null); this.IoV = false)
      {
        f.a(paramk.IlF.fDc.fDf, false, "", localPayInfo, this.IqR, (Intent)localObject2, paramk.IlF.fDc.mRequestCode);
        AppMethodBeat.o(68084);
        return;
      }
      f.a(this, false, "", localPayInfo, this.IqR, (Intent)localObject2, 1);
      AppMethodBeat.o(68084);
      return;
    }
  }
  
  private void dFf()
  {
    AppMethodBeat.i(68087);
    this.IqP = fAP();
    if (this.IqP <= 0.0D)
    {
      findViewById(a.f.favor_layout_ll).setClickable(false);
      findViewById(a.f.favor_layout_ll).setEnabled(false);
      findViewById(a.f.favor_layout_ll).setOnClickListener(null);
      gR(false);
      this.IqE.setTextColor(getResources().getColor(a.c.normal_color));
      AppMethodBeat.o(68087);
      return;
    }
    this.IqE.setTextColor(getContext().getResources().getColor(a.c.desc_text_color));
    findViewById(a.f.favor_layout_ll).setEnabled(true);
    findViewById(a.f.favor_layout_ll).setClickable(true);
    gR(true);
    findViewById(a.f.favor_layout_ll).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(274461);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.report.service.h.IzE.a(15235, new Object[] { Integer.valueOf(3) });
        if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
          com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
        }
        RemittanceBusiUI.J(RemittanceBusiUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(274461);
      }
    });
    AppMethodBeat.o(68087);
  }
  
  private double fAP()
  {
    AppMethodBeat.i(68057);
    if ((this.IqY) || (this.mPayScene == 33))
    {
      d = this.IqP;
      AppMethodBeat.o(68057);
      return d;
    }
    this.IqP = Util.getDouble(this.mMw.getText(), 0.0D);
    double d = this.IqP;
    AppMethodBeat.o(68057);
    return d;
  }
  
  private boolean fAQ()
  {
    AppMethodBeat.i(68067);
    boolean bool;
    if (this.IqF == null) {
      bool = false;
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.q.a(this, this.mMs, findViewById(a.f.remittance_main_ui), findViewById(a.f.remittance_main_ui), findViewById(a.f.remittance_main_bottom_ui), this.IqX);
      AppMethodBeat.o(68067);
      return bool;
      if (this.IpZ != null)
      {
        Log.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if ((this.IpZ.Ilf != null) && (this.IpZ.Ilf.RZh.size() > 0)) {}
        for (int i = 1;; i = 0)
        {
          if (this.IpZ.Ile.size() > 0) {
            i = 1;
          }
          if (this.Irm.fAt().size() > 0) {
            i = 1;
          }
          if (i == 0)
          {
            this.IqF.setVisibility(8);
            this.Irt.update();
            this.IqK.setVisibility(8);
            bool = false;
            break;
          }
          this.IqK.setVisibility(0);
          this.Irs.update();
          this.IqF.setVisibility(0);
          this.IqE.setText(this.IpZ.Ila);
          this.IqE.setTextColor(getContext().getResources().getColor(a.c.desc_text_color));
          this.IqL.setText(g.formatMoney2f(fAP()));
          Object localObject = this.Irm.InO;
          if (localObject != null)
          {
            this.IqE.setTextColor(getContext().getResources().getColor(a.c.Orange));
            this.IqE.setText(((aos)localObject).Ila);
            this.IqL.setText(g.formatMoney2f(((aos)localObject).SBm / 100.0D));
          }
          for (;;)
          {
            findViewById(a.f.favor_layout_ll).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68020);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                com.tencent.mm.plugin.report.service.h.IzE.a(15235, new Object[] { Integer.valueOf(3) });
                if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
                  com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
                }
                RemittanceBusiUI.J(RemittanceBusiUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68020);
              }
            });
            bool = true;
            break;
            localObject = this.Irm.fAu();
            if (!Util.isNullOrNil((String)localObject))
            {
              this.IqE.setTextColor(getContext().getResources().getColor(a.c.desc_text_color));
              this.IqE.setText((CharSequence)localObject);
            }
          }
        }
      }
      bool = false;
    }
  }
  
  private void fAR()
  {
    AppMethodBeat.i(163833);
    hideLoading();
    if (this.Irw != null) {
      this.Irw.hideProgress();
    }
    AppMethodBeat.o(163833);
  }
  
  private void fAS()
  {
    AppMethodBeat.i(68076);
    Log.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    aos localaos = this.Irm.InO;
    if (localaos == null)
    {
      Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
      AppMethodBeat.o(68076);
      return;
    }
    int i = (int)Math.round(this.IqP * 100.0D);
    ds localds = new ds();
    localds.channel = this.mChannel;
    localds.RJf = this.IpQ;
    localds.InV = this.GCu;
    localds.Ilb = this.IpZ.Ilb;
    localds.scene = this.mPayScene;
    localds.RJg = this.IpV;
    localds.RJh = localaos;
    localds.llO = this.IqQ;
    localds.ImY = this.IoQ;
    localds.RJi = i;
    doSceneProgress(new m(localds, this.Irn), false);
    AppMethodBeat.o(68076);
  }
  
  private void fAT()
  {
    AppMethodBeat.i(68078);
    Log.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Object localObject = new Intent(this, RemittanceBusiResultUI.class);
    ((Intent)localObject).putExtra("key_pay_desc", this.IpR);
    ((Intent)localObject).putExtra("key_rcv_desc", this.IqT);
    if (this.IpZ != null) {
      ((Intent)localObject).putExtra("BusiRemittanceResp", this.IpZ);
    }
    ((Intent)localObject).putExtra("key_mch_name", this.Iom);
    ((Intent)localObject).putExtra("key_rcver_name", this.IqQ);
    ((Intent)localObject).putExtra("key_rcver_true_name", this.IqR);
    if (this.fwy >= 0.0D) {
      ((Intent)localObject).putExtra("key_money", this.fwy);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_f2f_id", this.IpQ);
      ((Intent)localObject).putExtra("key_trans_id", this.GCu);
      ((Intent)localObject).putExtra("key_check_sign", this.IpV);
      ((Intent)localObject).putExtra("key_rcvr_open_id", this.IoQ);
      ((Intent)localObject).putExtra("key_channel", this.mChannel);
      ((Intent)localObject).putExtra("key_succ_fault_config", this.Irj);
      if (this.IpZ != null)
      {
        ((Intent)localObject).putExtra("key_succ_show_avatar_type", this.IpZ.Ili);
        ((Intent)localObject).putExtra("key_succ_show_avatar_show", this.IpZ.IkY);
        ((Intent)localObject).putExtra("key_succ_show_avatar_url", this.IpZ.IkZ);
      }
      if (this.IpZ != null) {
        ((Intent)localObject).putExtra("key_scan_sceen", this.IpZ.Ilb);
      }
      ((Intent)localObject).putExtra("key_succ_page_extend", this.Iro);
      if (this.mChannel == 56) {
        ((Intent)localObject).putExtra("app_id", this.app_id);
      }
      aos localaos = this.Irm.InO;
      int i = (int)Math.round(this.IqP * 100.0D);
      ds localds = new ds();
      localds.channel = this.mChannel;
      localds.RJf = this.IpQ;
      localds.InV = this.GCu;
      localds.Ilb = this.IpZ.Ilb;
      localds.scene = this.mPayScene;
      localds.RJg = this.IpV;
      localds.RJh = localaos;
      localds.llO = this.IqQ;
      localds.ImY = this.IoQ;
      localds.RJi = i;
      try
      {
        ((Intent)localObject).putExtra("AfterPlaceOrderCommReq", localds.toByteArray());
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (e.fAJ().fAK()) {
          Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
        }
        AppMethodBeat.o(68078);
        return;
        ((Intent)localObject).putExtra("key_money", this.IqP);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.RemittanceBusiUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void foI()
  {
    AppMethodBeat.i(68066);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68019);
        RemittanceBusiUI.E(RemittanceBusiUI.this).setText(RemittanceBusiUI.D(RemittanceBusiUI.this));
        Object localObject;
        if ((RemittanceBusiUI.k(RemittanceBusiUI.this) != null) && (!Util.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).Ilj)))
        {
          localObject = RemittanceBusiUI.k(RemittanceBusiUI.this).Ilj;
          RemittanceBusiUI.H(RemittanceBusiUI.this).setText(com.tencent.mm.pluginsdk.ui.span.l.b(RemittanceBusiUI.this, (CharSequence)localObject, RemittanceBusiUI.H(RemittanceBusiUI.this).getTextSize()));
          if (RemittanceBusiUI.k(RemittanceBusiUI.this) == null) {
            break label359;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).IkY != 1) {
            break label341;
          }
          if (Util.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).IkZ)) {
            break label268;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).Ili != 1) {
            break label254;
          }
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(true);
        }
        for (;;)
        {
          int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, 36.0F);
          RemittanceBusiUI.I(RemittanceBusiUI.this).w(RemittanceBusiUI.k(RemittanceBusiUI.this).IkZ, i, i, -1);
          AppMethodBeat.o(68019);
          return;
          String str = g.ic(g.PJ(RemittanceBusiUI.F(RemittanceBusiUI.this)), 10);
          localObject = str;
          if (Util.isNullOrNil(RemittanceBusiUI.G(RemittanceBusiUI.this))) {
            break;
          }
          localObject = RemittanceBusiUI.this.getString(a.i.remittance_collect_block, new Object[] { str, RemittanceBusiUI.G(RemittanceBusiUI.this) });
          break;
          label254:
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(false);
        }
        label268:
        if (!Util.isNullOrNil(RemittanceBusiUI.F(RemittanceBusiUI.this)))
        {
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).Ili == 1)
          {
            a.b.d(RemittanceBusiUI.I(RemittanceBusiUI.this), RemittanceBusiUI.F(RemittanceBusiUI.this));
            AppMethodBeat.o(68019);
            return;
          }
          a.b.c(RemittanceBusiUI.I(RemittanceBusiUI.this), RemittanceBusiUI.F(RemittanceBusiUI.this));
          AppMethodBeat.o(68019);
          return;
          label341:
          RemittanceBusiUI.I(RemittanceBusiUI.this).setVisibility(8);
          AppMethodBeat.o(68019);
          return;
        }
        label359:
        RemittanceBusiUI.I(RemittanceBusiUI.this).setVisibility(8);
        AppMethodBeat.o(68019);
      }
    });
    AppMethodBeat.o(68066);
  }
  
  private void gR(boolean paramBoolean)
  {
    AppMethodBeat.i(68088);
    if (this.mMt != null) {
      this.mMt.Ih(paramBoolean);
    }
    AppMethodBeat.o(68088);
  }
  
  private void ha(final List<aot> paramList)
  {
    AppMethodBeat.i(68068);
    final com.tencent.mm.ui.widget.picker.d locald = new com.tencent.mm.ui.widget.picker.d(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.Irm.InO;
    Object localObject1 = new HashSet();
    final HashSet localHashSet = new HashSet();
    if ((this.Irm.fAw()) && (localObject2 != null))
    {
      localObject2 = ((aos)localObject2).RZg.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((aot)((Iterator)localObject2).next()).SBt));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((aot)((Iterator)localObject2).next()).SBt))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(a.i.remittance_f2f_favor_select);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locald.Ysa.setVisibility(0);
      locald.Lsj.setText((CharSequence)localObject1);
    }
    locald.Ysb = localArrayList;
    locald.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(68024);
        RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
        aot localaot;
        if ((!RemittanceBusiUI.K(RemittanceBusiUI.this).fAw()) || (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D))
        {
          localIterator = paramList.iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localaot = (aot)localIterator.next();
            paramAnonymouso.a(i, localaot.SBu, localaot.SBw, null, true);
            localHashSet.add(Integer.valueOf(i));
            i += 1;
          }
          AppMethodBeat.o(68024);
          return;
        }
        Iterator localIterator = paramList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          localaot = (aot)localIterator.next();
          if (localaot.SBC == 1)
          {
            paramAnonymouso.a(i, localaot.SBu, localaot.SBw, null, true);
            localHashSet.add(Integer.valueOf(i));
          }
          for (;;)
          {
            i += 1;
            break;
            paramAnonymouso.a(i, localaot.SBu, localaot.SBw, 0);
          }
        }
        AppMethodBeat.o(68024);
      }
    };
    locald.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 1;
        int j = 0;
        AppMethodBeat.i(68026);
        if (localHashSet.contains(Integer.valueOf(paramAnonymousInt)))
        {
          AppMethodBeat.o(68026);
          return;
        }
        if (paramAnonymousInt < paramList.size())
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(15235, new Object[] { Integer.valueOf(4) });
          Object localObject1 = (aot)paramList.get(paramAnonymousInt);
          paramAnonymousMenuItem = locald;
          boolean bool;
          if (paramAnonymousMenuItem.Ysc != null)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem.Ysc.ids();
            bool = paramAnonymousMenuItem.contains(Integer.valueOf(paramAnonymousInt));
            if (bool) {
              break label214;
            }
          }
          for (;;)
          {
            localObject2 = new LinkedList();
            paramAnonymousMenuItem = paramAnonymousMenuItem.iterator();
            while (paramAnonymousMenuItem.hasNext())
            {
              int k = ((Integer)paramAnonymousMenuItem.next()).intValue();
              if ((k < paramList.size()) && ((i != 0) || (paramAnonymousInt != k))) {
                ((List)localObject2).add((aot)paramList.get(k));
              }
            }
            paramAnonymousMenuItem = new ArrayList();
            break;
            label214:
            i = 0;
          }
          if (i != 0) {
            ((List)localObject2).add(localObject1);
          }
          b localb = RemittanceBusiUI.K(RemittanceBusiUI.this);
          if (i != 0) {}
          for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
          {
            localb.a((List)localObject2, paramAnonymousMenuItem);
            localObject1 = RemittanceBusiUI.K(RemittanceBusiUI.this).InO;
            paramAnonymousMenuItem = new HashSet();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((aos)localObject1).RZg.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramAnonymousMenuItem.add(Long.valueOf(((aot)((Iterator)localObject1).next()).SBt));
            }
          }
          localObject1 = new HashMap();
          Object localObject2 = paramList.iterator();
          i = j;
          if (((Iterator)localObject2).hasNext())
          {
            if (paramAnonymousMenuItem.contains(Long.valueOf(((aot)((Iterator)localObject2).next()).SBt))) {
              ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.TRUE);
            }
            for (;;)
            {
              if (i == paramAnonymousInt) {
                ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.valueOf(bool));
              }
              i += 1;
              break;
              ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.FALSE);
            }
          }
          paramAnonymousMenuItem = locald;
          if (paramAnonymousMenuItem.Ysc != null)
          {
            paramAnonymousMenuItem.Ysc.Ysf = ((HashMap)localObject1);
            paramAnonymousMenuItem.Ysc.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(68026);
      }
    };
    locald.Ysd = new d.b()
    {
      public final void xg(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68027);
        if (paramAnonymousBoolean)
        {
          localObject = RemittanceBusiUI.K(RemittanceBusiUI.this).InO;
          if (localObject != null) {
            break label56;
          }
        }
        label56:
        for (Object localObject = "";; localObject = com.tencent.mm.plugin.remittance.model.a.a((aos)localObject))
        {
          Log.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
          RemittanceBusiUI.L(RemittanceBusiUI.this);
          AppMethodBeat.o(68027);
          return;
        }
      }
    };
    if (locald.ODT != null) {
      locald.ODT.onCreateMMMenu(locald.ODY);
    }
    locald.Ysc = new com.tencent.mm.ui.widget.picker.d.a(locald, locald.mContext);
    locald.Ysc.idr();
    locald.YrZ.setAdapter(locald.Ysc);
    locald.kEt.setOnClickListener(new d.2(locald));
    locald.kGN.setOnClickListener(new d.3(locald));
    if (locald.DpN != null)
    {
      if ((locald.ODY != null) && (locald.ODY.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locald.oFW.getLayoutParams();
        paramList.height = locald.pMB;
        locald.oFW.setLayoutParams(paramList);
      }
      locald.DpN.show();
    }
    AppMethodBeat.o(68068);
  }
  
  public final void a(int paramInt, k paramk)
  {
    AppMethodBeat.i(163835);
    bd localbd = new bd();
    localbd.giX = paramInt;
    if (paramk != null)
    {
      localbd.jH(paramk.IlD.RJf);
      localbd.jI(this.IqO);
      localbd.glL = paramk.GVj;
    }
    localbd.bpa();
    AppMethodBeat.o(163835);
  }
  
  public final void bU(float paramFloat)
  {
    AppMethodBeat.i(68065);
    if (this.mMs != null)
    {
      this.IqX = paramFloat;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mMs.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.mMs.setLayoutParams(localLayoutParams);
      com.tencent.mm.ui.tools.q.a(this, this.mMs, findViewById(a.f.remittance_main_ui), findViewById(a.f.remittance_main_ui), findViewById(a.f.remittance_main_bottom_ui), paramFloat);
    }
    AppMethodBeat.o(68065);
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_busi_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68063);
    hideActionbarLine();
    this.mMs = ((ScrollView)findViewById(a.f.root_view));
    this.IrD = ((LinearLayout)findViewById(a.f.remittance_main_above_ui));
    this.Iqy = ((TextView)findViewById(a.f.remittance_busi_name));
    this.Iqz = ((TextView)findViewById(a.f.remittance_busi_nick_name));
    this.IqA = ((TextView)findViewById(a.f.remittance_busi_fixed_title));
    this.IqB = ((TextView)findViewById(a.f.remittance_busi_fixed_money));
    this.IqC = ((TextView)findViewById(a.f.remittance_busi_desc));
    this.IqD = ((TextView)findViewById(a.f.remittance_busi_add_desc));
    this.IqG = ((CdnImageView)findViewById(a.f.remittance_busi_logo));
    this.mMw = ((WalletFormView)findViewById(a.f.remittance_busi_money_et));
    this.IqH = ((LinearLayout)findViewById(a.f.remittance_busi_fixed_money_layout));
    this.IoC = ((LinearLayout)findViewById(a.f.remittance_busi_edit_money_layout));
    this.IqN = ((RelativeLayout)findViewById(a.f.wallet_max_unit_line_container));
    this.IqI = ((LinearLayout)findViewById(a.f.remittance_busi_desc_container));
    this.IqE = ((TextView)findViewById(a.f.favor_title_desc));
    this.IqF = findViewById(a.f.remittance_busi_favor_layout);
    this.IqJ = ((TextView)findViewById(a.f.remittance_busi_fixed_currency));
    this.IqK = findViewById(a.f.final_remittance_layout);
    this.IqL = ((TextView)findViewById(a.f.final_remittance_busi_fixed_money));
    this.IqM = ((Button)findViewById(a.f.remittance_busi_fixed_pay_btn));
    this.mMt = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    Object localObject1;
    Object localObject2;
    label555:
    label700:
    label1019:
    int i;
    int j;
    int k;
    label1075:
    label1107:
    boolean bool1;
    if (this.IqY)
    {
      if (!Util.isNullOrNil(this.IqT)) {
        this.IqA.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.IqT, this.IqA.getTextSize()));
      }
      this.IqB.setText(g.formatMoney2f(this.IqP));
      this.IqH.setVisibility(0);
      this.IoC.setVisibility(8);
      this.IqN.setVisibility(8);
      this.IqM.setVisibility(0);
      if (com.tencent.mm.kernel.h.aHB())
      {
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.IqQ);
        if ((localObject1 == null) || ((int)((com.tencent.mm.contact.d)localObject1).jxt == 0)) {
          az.a.ltq.a(this.IqQ, "", new az.b.a()
          {
            public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(68044);
              Log.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              RemittanceBusiUI.l(RemittanceBusiUI.this);
              AppMethodBeat.o(68044);
            }
          });
        }
      }
      foI();
      this.IqI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68048);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.this.showCircleStWcKb();
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(15235, new Object[] { Integer.valueOf(6) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(6), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(a.i.remittance_busi_add_desc), RemittanceBusiUI.o(RemittanceBusiUI.this), RemittanceBusiUI.this.getString(a.i.remittance_busi_desc_max_words_count_tip), true, 20, new h.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(68045);
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymous2CharSequence.toString());
              RemittanceBusiUI.p(RemittanceBusiUI.this);
              AppMethodBeat.o(68045);
              return true;
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68047);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(68046);
                  RemittanceBusiUI.this.hideVKB();
                  AppMethodBeat.o(68046);
                }
              }, 500L);
              AppMethodBeat.o(68047);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68048);
        }
      });
      localObject1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68051);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          com.tencent.mm.plugin.report.service.h.IzE.a(15235, new Object[] { Integer.valueOf(5) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(8), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
          }
          if (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D)
          {
            w.makeText(RemittanceBusiUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68051);
            return;
          }
          localObject = RemittanceBusiUI.this.Irr;
          if (RemittanceBusiUI.this.Irr == null)
          {
            paramAnonymousView = "";
            Log.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localObject, paramAnonymousView, Boolean.valueOf(RemittanceBusiUI.this.Irp) });
            if (RemittanceBusiUI.j(RemittanceBusiUI.this) != 32) {
              break label411;
            }
            if (!RemittanceBusiUI.this.Irp) {
              break label401;
            }
            if ((RemittanceBusiUI.this.Irr == null) || (RemittanceBusiUI.this.Irr.Ikc != (int)(RemittanceBusiUI.r(RemittanceBusiUI.this) * 100.0D))) {
              break label382;
            }
            if ((RemittanceBusiUI.this.Irr != null) && (RemittanceBusiUI.this.Irr.IlA)) {
              break label411;
            }
            if (RemittanceBusiUI.this.Irr != null) {
              RemittanceBusiUI.this.Irr.Ily = new com.tencent.mm.plugin.remittance.model.d()
              {
                public final void gZ(List<aot> paramAnonymous2List)
                {
                  AppMethodBeat.i(68049);
                  RemittanceBusiUI.s(RemittanceBusiUI.this);
                  AppMethodBeat.o(68049);
                }
              };
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68051);
            return;
            paramAnonymousView = RemittanceBusiUI.this.Irr.IlA;
            break;
            label382:
            RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.d()
            {
              public final void gZ(List<aot> paramAnonymous2List)
              {
                AppMethodBeat.i(68050);
                RemittanceBusiUI.s(RemittanceBusiUI.this);
                AppMethodBeat.o(68050);
              }
            }, 0);
            continue;
            label401:
            RemittanceBusiUI.s(RemittanceBusiUI.this);
            continue;
            label411:
            RemittanceBusiUI.s(RemittanceBusiUI.this);
          }
        }
      };
      this.mMw.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68052);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            Log.i("MicroMsg.RemittanceBusiUI", "click enter");
            this.mMW.onClick(null);
            AppMethodBeat.o(68052);
            return true;
          }
          AppMethodBeat.o(68052);
          return true;
        }
      });
      localObject2 = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (ar.isDarkMode())
      {
        findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
        findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
        ((ImageView)localObject2).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
        this.IqM.setOnClickListener((View.OnClickListener)localObject1);
        this.mMs.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(68015);
            if ((RemittanceBusiUI.t(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.u(RemittanceBusiUI.this).isShown()) && (RemittanceBusiUI.v(RemittanceBusiUI.this).iir()))
            {
              RemittanceBusiUI.w(RemittanceBusiUI.this).iip();
              AppMethodBeat.o(68015);
              return true;
            }
            AppMethodBeat.o(68015);
            return false;
          }
        });
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
        {
          public final void onVisibleStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(68016);
            RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousBoolean);
            if (!paramAnonymousBoolean)
            {
              RemittanceBusiUI.x(RemittanceBusiUI.this).scrollTo(0, 0);
              if ((RemittanceBusiUI.c(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.c(RemittanceBusiUI.this).getVisibility() == 0))
              {
                RemittanceBusiUI.c(RemittanceBusiUI.this).setFocusable(false);
                RemittanceBusiUI.c(RemittanceBusiUI.this).setFocusable(true);
              }
            }
            AppMethodBeat.o(68016);
          }
        });
        this.mMz = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
        if ((!LocaleUtil.getApplicationLanguage().equals("zh_CN")) && (!LocaleUtil.getApplicationLanguage().equals("zh_TW")) && (!LocaleUtil.getApplicationLanguage().equals("zh_HK"))) {
          break label1396;
        }
        this.mMx = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
        this.mMy = ((TextView)findViewById(a.f.wallet_max_unit_tv));
        this.mMx.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68017);
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.y(RemittanceBusiUI.this).getWidth());
            RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
            Log.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceBusiUI.A(RemittanceBusiUI.this)) });
            AppMethodBeat.o(68017);
          }
        });
        this.mMw.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void f(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(68018);
            if (Util.isEqual(RemittanceBusiUI.B(RemittanceBusiUI.this), 0))
            {
              Log.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
              RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(68018);
              return;
            }
            long l = Double.valueOf(Util.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
            int j = 0;
            int i = 0;
            while (l != 0L)
            {
              j = (int)(l % 10L);
              l /= 10L;
              i += 1;
            }
            if (i >= RemittanceBusiUI.B(RemittanceBusiUI.this))
            {
              j = RemittanceBusiUI.c(RemittanceBusiUI.this).k(paramAnonymousCharSequence, RemittanceBusiUI.A(RemittanceBusiUI.this), j);
              if (j != 0)
              {
                RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(0);
                paramAnonymousCharSequence = ag.bk(MMApplicationContext.getContext(), i);
                RemittanceBusiUI.C(RemittanceBusiUI.this).setText(paramAnonymousCharSequence);
                paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceBusiUI.y(RemittanceBusiUI.this).getLayoutParams();
                paramAnonymousCharSequence.leftMargin = j;
                RemittanceBusiUI.y(RemittanceBusiUI.this).setLayoutParams(paramAnonymousCharSequence);
                AppMethodBeat.o(68018);
                return;
              }
              RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(68018);
              return;
            }
            RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
            AppMethodBeat.o(68018);
          }
        });
        if ((this.IpZ != null) && (this.IpZ.Ilf != null))
        {
          this.Irm.InP = this.IpZ.Ilf;
          this.Irm.aWM(this.IpZ.Ilf.RZi);
        }
        if (fAQ()) {
          com.tencent.mm.plugin.report.service.h.IzE.a(15235, new Object[] { Integer.valueOf(2) });
        }
        this.IrE = ((LinearLayout)findViewById(a.f.remittance_busi_warning_layout));
        this.IrF = ((LinearLayout)this.IrE.findViewById(a.f.remittance_warning_click_ll));
        this.IrG = ((TextView)this.IrE.findViewById(a.f.remittance_warning_tips));
        this.IrH = ((CdnImageView)this.IrE.findViewById(a.f.remittance_warning_left_logo));
        this.IrI = ((CdnImageView)this.IrE.findViewById(a.f.remittance_warning_right_logo));
        this.IrJ = ((TextView)findViewById(a.f.emittance_busi_edit_title));
        if (this.IpZ == null) {
          break label1526;
        }
        localObject1 = this.IpZ;
        if ((((BusiRemittanceResp)localObject1).Ilg == null) || (((BusiRemittanceResp)localObject1).Ilg.UHR != 1) || (((BusiRemittanceResp)localObject1).Ilg.UHS == null) || (Util.isNullOrNil(((BusiRemittanceResp)localObject1).Ilg.UHS.wording))) {
          break label1462;
        }
        localObject1 = ((BusiRemittanceResp)localObject1).Ilg;
        localObject2 = ((fic)localObject1).UHS;
        this.IrE.setVisibility(0);
        Log.i("MicroMsg.RemittanceBusiUI", " warning textInfo.wording:%s", new Object[] { ((fid)localObject2).wording });
        this.IrG.setText(((fid)localObject2).wording);
        if ((!ar.isDarkMode()) || (Util.isNullOrNil(((fic)localObject1).UHT))) {
          break label1408;
        }
        this.IrG.setTextColor(g.aIQ(((fic)localObject1).UHT));
        i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0F);
        j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 8.0F);
        k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 16.0F);
        if ((!ar.isDarkMode()) || (Util.isNullOrNil(((fic)localObject1).UHV))) {
          break label1426;
        }
        this.IrH.w(((fic)localObject1).UHV, i, i, -1);
        if ((!ar.isDarkMode()) || (Util.isNullOrNil(((fic)localObject1).UHX))) {
          break label1444;
        }
        this.IrI.w(((fic)localObject1).UHX, j, k, -1);
        this.IrE.postDelayed(new RemittanceBusiUI.37(this), 10L);
        this.IrF.setClickable(true);
        this.IrF.setOnClickListener(new RemittanceBusiUI.38(this, (fid)localObject2));
        AppMethodBeat.o(68063);
      }
    }
    else
    {
      if (this.IpZ == null) {
        break label1539;
      }
      if (this.IpZ.Ile.size() <= 0) {
        break label1533;
      }
      bool1 = false;
      label1183:
      bool2 = bool1;
      if (this.IpZ.Ilf != null)
      {
        bool2 = bool1;
        if (this.IpZ.Ilf.RZg.size() <= 0) {}
      }
    }
    label1408:
    label1539:
    for (boolean bool2 = false;; bool2 = true)
    {
      this.IqM.setVisibility(8);
      setWPKeyboard(this.mMw.getContentEt(), bool2, true);
      this.mMw.setmContentAbnormalMoneyCheck(true);
      if (com.tencent.mm.compatible.util.d.qV(28)) {
        this.mMw.getContentEt().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68042);
            RemittanceBusiUI.c(RemittanceBusiUI.this).getContentEt().requestFocus();
            AppMethodBeat.o(68042);
          }
        });
      }
      this.mMt.setActionText(getString(a.i.remittance_busi_pay));
      setWcKbHeightListener(this);
      ((RelativeLayout.LayoutParams)this.mMt.getLayoutParams()).addRule(12);
      this.mMw.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68043);
          RemittanceBusiUI.i(RemittanceBusiUI.this);
          if (RemittanceBusiUI.j(RemittanceBusiUI.this) == 32)
          {
            paramAnonymousEditable = RemittanceBusiUI.this;
            if (RemittanceBusiUI.k(RemittanceBusiUI.this) != null) {
              break label55;
            }
          }
          label55:
          for (int i = 400;; i = RemittanceBusiUI.k(RemittanceBusiUI.this).Ill)
          {
            RemittanceBusiUI.a(paramAnonymousEditable, null, i);
            AppMethodBeat.o(68043);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.mMw.ijD();
      this.IqH.setVisibility(8);
      this.IoC.setVisibility(0);
      this.IqN.setVisibility(0);
      break;
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
      ((ImageView)localObject2).setBackgroundResource(a.e.wallet_money_amount_remind_line);
      break label555;
      label1396:
      this.mMz.setVisibility(8);
      break label700;
      this.IrG.setTextColor(g.aIQ(((fic)localObject1).Uba));
      break label1019;
      label1426:
      this.IrH.w(((fic)localObject1).UHU, i, i, -1);
      break label1075;
      label1444:
      this.IrI.w(((fic)localObject1).UHW, j, k, -1);
      break label1107;
      label1462:
      Log.i("MicroMsg.RemittanceBusiUI", " do not show WarningView");
      this.IrE.setVisibility(8);
      localObject1 = (RelativeLayout.LayoutParams)this.IrD.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 0);
      this.IrD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      acU(32);
      label1526:
      AppMethodBeat.o(68063);
      return;
      label1533:
      bool1 = true;
      break label1183;
    }
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(68062);
    if (this.mKindaEnable)
    {
      if ((!this.Iru) && (!this.IqY) && (this.mMt.iit()))
      {
        AppMethodBeat.o(68062);
        return true;
      }
      AppMethodBeat.o(68062);
      return false;
    }
    if ((!this.IqY) && (this.mMt.iit()))
    {
      AppMethodBeat.o(68062);
      return true;
    }
    AppMethodBeat.o(68062);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(68072);
    Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if (paramInt1 == 3)
    {
      if (this.Irw != null)
      {
        this.Irw.hideProgress();
        this.Irw = null;
      }
      if (paramInt2 == -1) {
        a(bool1, paramIntent);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(68072);
      return;
      bool1 = false;
      break;
      if (paramInt1 == 1)
      {
        if (paramInt2 == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(bool1, paramIntent);
          break;
        }
      }
      if (paramInt1 == 2)
      {
        if (paramInt2 == -1)
        {
          String str = paramIntent.getStringExtra("INTENT_RESULT_TOKEN");
          this.Ire = str;
          this.fwy = 0.0D;
          Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          H(false, paramIntent.getStringExtra("INTENT_REQKEY"));
        }
        else
        {
          fAS();
        }
      }
      else if (paramInt1 == 4) {
        this.Irz = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68058);
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("pay_channel", 0) == 56)
    {
      overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
      this.app_id = getIntent().getStringExtra("app_id");
      com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(4), this.app_id, Integer.valueOf(0) });
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(15235, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.normal_actionbar_color)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.normal_text_color));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.normal_actionbar_color));
    }
    if ((com.tencent.mm.compatible.util.d.qV(21)) && (!com.tencent.mm.compatible.util.d.qV(23))) {
      getWindow().setStatusBarColor(getContext().getResources().getColor(a.c.BW_93));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68035);
        if (RemittanceBusiUI.h(RemittanceBusiUI.this))
        {
          RemittanceBusiUI.this.hideVKB();
          RemittanceBusiUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(68035);
          return true;
          RemittanceBusiUI.this.finish();
        }
      }
    }, a.h.actionbar_icon_dark_back);
    addSceneEndListener(1633);
    addSceneEndListener(1241);
    addSceneEndListener(2677);
    addSceneEndListener(2504);
    addSceneEndListener(2702);
    addSceneEndListener(2682);
    regeistQueryOrder(2682, this.IrL);
    setMMTitle(a.i.remittance_busi_pay);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68014);
        RemittanceBusiUI.e(RemittanceBusiUI.this);
        if (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) == 56)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(5), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          RemittanceBusiUI.fAU();
        }
        RemittanceBusiUI.this.finish();
        AppMethodBeat.o(68014);
        return false;
      }
    });
    this.fLj = UUID.randomUUID().toString();
    com.tencent.mm.plugin.wallet.pay.a.b.bgD(this.fLj);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    this.IqO = getIntent().getStringExtra("scan_remittance_id");
    this.IqP = getIntent().getDoubleExtra("fee", 0.0D);
    this.IqQ = getIntent().getStringExtra("receiver_name");
    this.IqR = getIntent().getStringExtra("receiver_true_name");
    this.IqS = getIntent().getStringExtra("receiver_true_name_busi");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.IqT = getIntent().getStringExtra("desc");
    this.IqV = getIntent().getIntExtra("busi_type", 0);
    this.Iom = getIntent().getStringExtra("mch_name");
    this.IqZ = getIntent().getStringExtra("mch_type");
    this.Irb = getIntent().getIntExtra("mch_time", 0);
    this.IqW = getIntent().getStringExtra("mch_info");
    this.Ira = getIntent().getIntExtra("get_pay_wifi", 0);
    this.IoQ = getIntent().getStringExtra("rcvr_open_id");
    this.IqU = getIntent().getStringExtra("rcvr_ticket");
    this.Iko = getIntent().getIntExtra("amount_remind_bit", 4);
    this.Irl = getIntent().getStringExtra("receiver_tips");
    this.IpZ = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
    boolean bool;
    if (this.IpZ != null) {
      if ((this.mPayScene == 32) && ((this.IpZ.Ilh == 1) || ((this.IpZ != null) && (this.IpZ.Ile.size() > 0))))
      {
        bool = true;
        this.Irp = bool;
        if (this.IqP <= 0.0D) {
          break label851;
        }
      }
    }
    label851:
    for (this.IqY = true;; this.IqY = false)
    {
      if (this.IqV == 0)
      {
        Log.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.Irs = new b(32, 32, 6.0F);
      this.Irt = new b(56, 56, 8.0F);
      initView();
      dFf();
      this.InK.alive();
      this.IrU.alive();
      if (!this.IqY) {
        this.state = 1;
      }
      AppMethodBeat.o(68058);
      return;
      bool = false;
      break;
      Log.w("MicroMsg.RemittanceBusiUI", "busi resp is null, maybe recreate activity!!");
      finish();
      AppMethodBeat.o(68058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68070);
    super.onDestroy();
    EventCenter.instance.removeListener(this.Ipf);
    EventCenter.instance.removeListener(this.IrT);
    EventCenter.instance.removeListener(this.IrR);
    this.IrS.dead();
    removeSceneEndListener(1633);
    removeSceneEndListener(1241);
    removeSceneEndListener(2677);
    removeSceneEndListener(2504);
    removeSceneEndListener(2702);
    removeSceneEndListener(2682);
    this.InK.dead();
    this.IrU.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.bgE(this.fLj);
    MMHandlerThread.removeRunnable(this.mMK);
    AppMethodBeat.o(68070);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(68061);
    Log.i("MicroMsg.RemittanceBusiUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
    AppMethodBeat.o(68061);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68064);
    if ((this.mMt != null) && (this.mMt.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(68064);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68064);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68082);
    Log.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
    AppMethodBeat.o(68082);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68060);
    super.onPause();
    Log.i("MicroMsg.RemittanceBusiUI", "onPause()");
    if ((!this.IqY) && (!this.mMt.iis())) {
      this.state = 3;
    }
    AppMethodBeat.o(68060);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68059);
    super.onResume();
    Log.i("MicroMsg.RemittanceBusiUI", "onResume()");
    e.fAJ().fB(this);
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    if (!this.IqY) {
      this.state = 2;
    }
    AppMethodBeat.o(68059);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(68071);
    Object localObject1;
    boolean bool;
    label330:
    label375:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramq instanceof k))
    {
      paramString = (k)paramq;
      if (!this.mKindaEnable)
      {
        localObject1 = e.fAJ();
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "hideProgress()");
        localObject1 = (Context)((e)localObject1).cNB.get();
        if (localObject1 == null) {
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1618;
        }
        if (paramString.IlD.tqa != 0) {
          break label1423;
        }
        this.IrC = paramString;
        this.IpQ = paramString.IlD.RJf;
        this.GCu = paramString.IlD.InV;
        this.IpV = paramString.IlD.RJg;
        this.Irn = paramString.IlD.RZF;
        this.Iro = paramString.IlD.RZE;
        this.Irc = paramString.IlD.RZK;
        this.Ird = paramString.IlD.RZJ;
        this.Irf = paramString.IlD.RZN;
        this.Irg = paramString.IlD.RZL;
        this.Irh = paramString.IlD.RZM;
        this.Irj = k.a(paramString.IlD.RZS).toString();
        if (paramString.IlD.RZS != null) {
          this.Irk = paramString.IlD.RZS.cUP;
        }
        Log.i("MicroMsg.RemittanceBusiUI", "touch_challenge: %s need_change_auth_key: %s mBusiF2FFaultConfig: %s", new Object[] { paramString.IlD.RZO, Integer.valueOf(paramString.IlD.RZP), this.Irj });
        if (paramString.IlD.RZO != null) {
          p.ByH.ByB = paramString.IlD.RZO.Ap();
        }
        paramq = p.ByH;
        if (paramString.IlD.RZP != 1) {
          break label598;
        }
        bool = true;
        paramq.ByJ = bool;
        if (a(paramString)) {
          break label1416;
        }
        Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog");
        if (paramString.IlD.RZV != null) {
          break label604;
        }
        Log.e("MicroMsg.RemittanceBusiUI", "orderScene.response.check_recv_name_win is null");
        paramInt1 = 0;
        if (paramInt1 == 0)
        {
          if (paramString.IlD.RZT == null) {
            break label1258;
          }
          Log.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_win");
          fAR();
          if ((e.fAJ().getContext() != null) && ((e.fAJ().getContext() instanceof RemittanceBusiUI))) {
            this.Iry = paramString.IlD.RZT.RJr;
          }
          paramq = e.fAJ();
          localObject2 = paramString.IlD.RZT;
          paramInt1 = this.Iko;
          localObject3 = new RemittanceBusiUI.a(paramString) {};
          localObject4 = new RemittanceBusiUI.a(paramString) {};
          Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAmountRemindWin() amountRemindBit:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramq = (Context)paramq.cNB.get();
          if (paramq != null) {
            break label917;
          }
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
          label525:
          if (e.fAJ().getContext() != null)
          {
            if (!(e.fAJ().getContext() instanceof RemittanceBusiUI)) {
              break label1236;
            }
            a(1, paramString);
          }
          label552:
          paramInt1 = 1;
          label554:
          if (paramInt1 == 0) {
            d(paramString);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68071);
      return false;
      if (((localObject1 instanceof RemittanceBusiUI)) || (!(localObject1 instanceof WalletBaseUI))) {
        break;
      }
      ((WalletBaseUI)localObject1).hideProgress();
      break;
      label598:
      bool = false;
      break label330;
      label604:
      showCircleStWcKb();
      fAR();
      localObject2 = paramString.IlD.RZV.title;
      Object localObject6 = paramString.IlD.RZV.wording;
      Object localObject7 = paramString.IlD.RZV.SlI;
      localObject3 = paramString.IlD.RZV.Phd.wording;
      localObject4 = paramString.IlD.RZV.Phe.wording;
      paramq = new c(this);
      paramq.Ioa = new c.a()
      {
        public final void aWF(final String paramAnonymousString)
        {
          AppMethodBeat.i(199473);
          Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onINputName() name:%s", new Object[] { paramAnonymousString });
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.IzE.a(19229, new Object[] { Integer.valueOf(0), Integer.valueOf(paramString.IlD.RZV.SlJ), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.IlD.RZV.Phe, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dS(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(200732);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:continue");
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousString, RemittanceBusiUI.36.this.IrZ.IlD.RZV.RZB);
              AppMethodBeat.o(200732);
            }
            
            public final void fAe()
            {
              AppMethodBeat.i(200734);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:close");
              AppMethodBeat.o(200734);
            }
            
            public final void fAl()
            {
              AppMethodBeat.i(200731);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:exit");
              RemittanceBusiUI.Z(RemittanceBusiUI.this);
              AppMethodBeat.o(200731);
            }
          });
          AppMethodBeat.o(199473);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(199479);
          Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onCancel()");
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.IzE.a(19229, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.IlD.RZV.SlJ), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.IlD.RZV.Phd, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dS(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(272511);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：continue");
              AppMethodBeat.o(272511);
            }
            
            public final void fAe()
            {
              AppMethodBeat.i(272512);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：close");
              AppMethodBeat.o(272512);
            }
            
            public final void fAl()
            {
              AppMethodBeat.i(272510);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action:exit");
              RemittanceBusiUI.Z(RemittanceBusiUI.this);
              AppMethodBeat.o(272510);
            }
          });
          AppMethodBeat.o(199479);
        }
      };
      Object localObject5 = View.inflate(paramq.mContext, a.g.real_name_check_dialog, null);
      Object localObject8 = (TextView)((View)localObject5).findViewById(a.f.last_name);
      localObject1 = (EditText)((View)localObject5).findViewById(a.f.first_name);
      ((MMNeat7extView)((View)localObject5).findViewById(a.f.content)).aL((CharSequence)localObject6);
      ((TextView)localObject8).setText((CharSequence)localObject7);
      localObject6 = new com.tencent.mm.ui.widget.a.d.a(paramq.mContext);
      ((com.tencent.mm.ui.widget.a.d.a)localObject6).bBc((String)localObject2).iI((View)localObject5);
      com.tencent.mm.ui.tools.b.c.i((EditText)localObject1).b(g.a.XSt).mM(1, 1).Hh(false).a(null);
      MMHandlerThread.postToMainThreadDelayed(new c.10(paramq, (EditText)localObject1), 200L);
      ((com.tencent.mm.ui.widget.a.d.a)localObject6).bBj((String)localObject4).ayl(-2141754475).a(false, new c.11(paramq, (EditText)localObject1));
      ((com.tencent.mm.ui.widget.a.d.a)localObject6).bBk((String)localObject3).d(new c.2(paramq));
      localObject2 = ((com.tencent.mm.ui.widget.a.d.a)localObject6).icu();
      ((com.tencent.mm.ui.widget.a.d)localObject2).show();
      ((EditText)localObject1).addTextChangedListener(new c.3(paramq, (EditText)localObject1, (com.tencent.mm.ui.widget.a.d)localObject2));
      paramInt1 = 1;
      break label375;
      label917:
      if (localObject2 == null)
      {
        Log.i("MicroMsg.JumpItemUtil", "showAmountRemindWin() amountRemindWin == null");
        break label525;
      }
      localObject1 = LayoutInflater.from(paramq).inflate(a.g.large_money_dialog, null, false);
      localObject5 = ((View)localObject1).findViewById(a.f.f2f_money_container);
      localObject6 = (WalletTextView)((View)localObject1).findViewById(a.f.f2f_money_amount_tv);
      localObject7 = ((View)localObject1).findViewById(a.f.wallet_max_unit_layout);
      localObject8 = ((View)localObject1).findViewById(a.f.wallet_max_unit_container);
      double d = ((ea)localObject2).RJr / 100.0D;
      ((WalletTextView)localObject6).setText(g.formatMoney2f(d));
      if (Util.isEqual(paramInt1, 0))
      {
        Log.i("MicroMsg.JumpItemUtil", "mAmountRemindBit == 0");
        ((View)localObject8).setVisibility(8);
      }
      for (;;)
      {
        localObject5 = ((ea)localObject2).wording;
        localObject6 = ((ea)localObject2).Phe.wording;
        localObject7 = ((ea)localObject2).Phd.wording;
        localObject4 = new l.8(paramq, (ea)localObject2, d, (l.a)localObject4);
        localObject2 = new l.9(paramq, (ea)localObject2, d, (l.a)localObject3);
        localObject3 = new com.tencent.mm.ui.widget.a.d.a(paramq);
        ((com.tencent.mm.ui.widget.a.d.a)localObject3).bBc((String)localObject5);
        ((com.tencent.mm.ui.widget.a.d.a)localObject3).iI((View)localObject1);
        ((com.tencent.mm.ui.widget.a.d.a)localObject3).bBj((String)localObject6).c((DialogInterface.OnClickListener)localObject4);
        ((com.tencent.mm.ui.widget.a.d.a)localObject3).bBk((String)localObject7).d((DialogInterface.OnClickListener)localObject2);
        ((com.tencent.mm.ui.widget.a.d.a)localObject3).HG(false);
        ((com.tencent.mm.ui.widget.a.d.a)localObject3).HH(true);
        localObject1 = ((com.tencent.mm.ui.widget.a.d.a)localObject3).icu();
        ((com.tencent.mm.ui.widget.a.d)localObject1).show();
        com.tencent.mm.ui.base.h.a(paramq, (Dialog)localObject1);
        break;
        TextView localTextView = (TextView)((View)localObject1).findViewById(a.f.wallet_max_unit_tv);
        ((View)localObject8).setVisibility(0);
        ((View)localObject8).post(new l.7((View)localObject7, d, paramInt1, (WalletTextView)localObject6, (View)localObject5, (View)localObject8, localTextView));
      }
      label1236:
      if (!(e.fAJ().getContext() instanceof RemittanceF2fLargeMoneyUI)) {
        break label552;
      }
      a(9, paramString);
      break label552;
      label1258:
      if (paramString.IlD.RZU != null)
      {
        Log.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_page");
        fAR();
        paramq = new Intent();
        paramq.putExtra("key_amount_remind_bit", this.Iko);
        paramq.putExtra("key_title", paramString.IlD.RZU.title);
        paramq.putExtra("key_desc", paramString.IlD.RZU.wording);
        paramq.putExtra("key_amount_remind_sign", paramString.IlD.RZU.RJq);
        com.tencent.mm.by.c.b(this, "wallet_payu", ".pay.ui.WalletPayUOrderInfoUI", paramq, 4);
        a(6, paramString);
        break label552;
      }
      if ((e.fAJ().getContext() != null) && ((e.fAJ().getContext() instanceof RemittanceF2fLargeMoneyUI))) {
        a(8, paramString);
      }
      paramInt1 = 0;
      break label554;
      label1416:
      fAR();
      continue;
      label1423:
      fAR();
      Log.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.IlD.tqa), paramString.IlD.tqb });
      if ((paramString.IlD.RZD != null) && (!Util.isNullOrNil(paramString.IlD.RZD.oDJ))) {
        a(paramString);
      }
      for (;;)
      {
        if (paramString.IlD.RZG != 1) {
          break label1616;
        }
        a(null, null, 0);
        break;
        localObject2 = e.fAJ();
        localObject1 = paramString.IlD.tqb;
        paramq = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68029);
            if (Util.isEqual(((k)paramq).IlD.RZR, 1))
            {
              if (e.fAJ().fAK()) {
                Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
              }
              RemittanceBusiUI.this.finish();
            }
            AppMethodBeat.o(68029);
          }
        };
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", new Object[] { Util.nullAsNil((String)localObject1), Util.nullAsNil("") });
        localObject2 = (Context)((e)localObject2).cNB.get();
        if (localObject2 == null) {
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        } else {
          com.tencent.mm.ui.base.h.d((Context)localObject2, (String)localObject1, "", paramq);
        }
      }
      label1616:
      continue;
      label1618:
      Log.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[] { paramq });
      continue;
      if ((paramq instanceof j))
      {
        Log.i("MicroMsg.RemittanceBusiUI", "pay check callback");
        AppMethodBeat.o(68071);
        return true;
      }
      if ((paramq instanceof i))
      {
        Log.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[] { paramq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (i)paramq;
        if ((!paramString.IlB.equals(this.Irr.IlB)) || (paramString.cancel))
        {
          paramString.IlA = true;
          Log.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.cancel) });
          AppMethodBeat.o(68071);
          return true;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramString.Ilx.tqa == 0)
          {
            this.Irm.InP = paramString.Ilx.Ilf;
            this.Irm.aWM(paramString.Ilx.Ilf.RZi);
            fAQ();
            paramq = paramString.Ily;
            Log.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramq });
            if (paramq != null) {
              paramq.gZ(this.Irm.fAt());
            }
          }
        }
        for (;;)
        {
          paramString.IlA = true;
          AppMethodBeat.o(68071);
          return true;
          this.Irm.fAs();
          this.IqE.setTextColor(getContext().getResources().getColor(a.c.desc_text_color));
          this.IqE.setText(paramString.Ilx.tqb);
          paramq = paramString.Ilz;
          if (paramq != null)
          {
            paramq.a(paramInt1, paramInt2, paramString);
            continue;
            this.Irm.fAs();
            if ((this.IpZ != null) && (!Util.isNullOrNil(this.IpZ.Ila))) {
              this.IqE.setText(this.IpZ.Ila);
            }
            this.IqE.setTextColor(getContext().getResources().getColor(a.c.desc_text_color));
            this.IqE.setText(getString(a.i.remittance_busi_favor_get_error_default));
            paramq = paramString.Ilz;
            if (paramq != null) {
              paramq.a(paramInt1, paramInt2, paramString);
            }
          }
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.remittance.model.n))
      {
        paramString = (com.tencent.mm.plugin.remittance.model.n)paramq;
        Log.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[] { Boolean.valueOf(paramString.hasRetried) });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramString.IlI.tqa == 0)
          {
            fAT();
          }
          else
          {
            fAS();
            e.fAJ().a(paramString.IlI.tqb, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
        }
        else {
          e.fAJ().a(getString(a.i.wallet_unknown_err), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean shouldEnsureSoterConnection()
  {
    return true;
  }
  
  final class b
  {
    private float Isg;
    private float Ish;
    private TenpaySecureEditText Isi;
    private TextView Isj;
    private RelativeLayout Isk;
    private View bvK;
    private float marginTop;
    
    b(int paramInt1, int paramInt2, float paramFloat)
    {
      AppMethodBeat.i(68053);
      this.Isg = paramInt1;
      this.Ish = paramInt2;
      this.marginTop = paramFloat;
      AppMethodBeat.o(68053);
    }
    
    final void update()
    {
      AppMethodBeat.i(68054);
      RemittanceBusiUI.a(RemittanceBusiUI.this).setTextSize(1, this.Ish);
      RemittanceBusiUI.b(RemittanceBusiUI.this).setTextSize(1, this.Isg);
      if (this.Isj == null) {
        this.Isj = ((TextView)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(a.f.wallet_title));
      }
      if (this.Isj != null) {
        this.Isj.setTextSize(this.Isg);
      }
      if (this.Isi == null) {
        this.Isi = ((TenpaySecureEditText)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(a.f.wallet_content));
      }
      if (this.Isi != null) {
        this.Isi.setTextSize(this.Ish);
      }
      if (this.bvK == null) {
        this.bvK = this.Isi.findViewById(a.f.money_et_layout);
      }
      if (this.bvK != null) {
        this.bvK.setMinimumHeight(BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, RemittanceBusiUI.d(RemittanceBusiUI.this).Ish));
      }
      if (this.Isk == null) {
        this.Isk = ((RelativeLayout)RemittanceBusiUI.this.findViewById(a.f.wallet_max_unit_line_container));
      }
      if (this.Isk != null) {
        ((LinearLayout.LayoutParams)this.Isk.getLayoutParams()).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, this.marginTop);
      }
      AppMethodBeat.o(68054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */