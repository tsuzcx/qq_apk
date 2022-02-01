package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
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
import androidx.lifecycle.q;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adl;
import com.tencent.mm.autogen.a.az;
import com.tencent.mm.autogen.a.hc;
import com.tencent.mm.autogen.a.hd;
import com.tencent.mm.autogen.a.hd.a;
import com.tencent.mm.autogen.a.he;
import com.tencent.mm.autogen.a.ub;
import com.tencent.mm.autogen.mmdata.rpt.bz;
import com.tencent.mm.autogen.mmdata.rpt.rl;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.al;
import com.tencent.mm.plugin.remittance.model.j.a;
import com.tencent.mm.plugin.remittance.model.o;
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
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.fci;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.protocal.protobuf.gen;
import com.tencent.mm.protocal.protobuf.geo;
import com.tencent.mm.protocal.protobuf.gep;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.protocal.protobuf.si;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.picker.d.b;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.model.l.7;
import com.tencent.mm.wallet_core.model.l.8;
import com.tencent.mm.wallet_core.model.l.9;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.i;
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
  private IListener CUH;
  private String MyF;
  private int Ohb;
  private String OlF;
  private LinearLayout OlV;
  private String Omj;
  private boolean Omo;
  private rl Omq;
  private boolean Omt;
  private boolean Omw;
  private IListener Omy;
  private TextView OnR;
  private TextView OnS;
  private TextView OnT;
  private TextView OnU;
  private TextView OnV;
  private TextView OnW;
  private View OnX;
  private View OnY;
  private TextView OnZ;
  private String Onj;
  private String Onk;
  private String Ono;
  private BusiRemittanceResp Ons;
  private int OoA;
  private String OoB;
  private float OoC;
  private String OoD;
  private boolean OoE;
  private String OoF;
  private int OoG;
  private int OoH;
  private String OoI;
  private fnr OoJ;
  private String OoK;
  private int OoL;
  private int OoM;
  private int OoN;
  private int OoO;
  private String OoP;
  private int OoQ;
  private String OoR;
  private c OoS;
  private b OoT;
  private String OoU;
  private String OoV;
  boolean OoW;
  private boolean OoX;
  com.tencent.mm.plugin.remittance.model.j OoY;
  private b OoZ;
  private TextView Ooa;
  private View Oob;
  private View Ooc;
  private TextView Ood;
  private View Ooe;
  private View Oof;
  private LinearLayout Oog;
  private TextView Ooh;
  private CheckBox Ooi;
  private View Ooj;
  private CdnImageView Ook;
  private LinearLayout Ool;
  private LinearLayout Oom;
  private TextView Oon;
  private View Ooo;
  private TextView Oop;
  private TextView Ooq;
  private Button Oor;
  private RelativeLayout Oos;
  private String Oot;
  private double Oou;
  private String Oov;
  private String Oow;
  private String Oox;
  private String Ooy;
  private String Ooz;
  private IListener OpA;
  private IListener OpB;
  private b Opa;
  protected boolean Opb;
  private Map<String, eh> Opc;
  private RemittanceF2fDynamicCodeUI Opd;
  private boolean Ope;
  private int Opf;
  private boolean Opg;
  private int Oph;
  private int Opi;
  private com.tencent.mm.plugin.remittance.model.l Opj;
  private LinearLayout Opk;
  private LinearLayout Opl;
  private LinearLayout Opm;
  private TextView Opn;
  private CdnImageView Opo;
  private CdnImageView Opp;
  private TextView Opq;
  private String Opr;
  private Runnable Ops;
  private com.tencent.mm.wallet_core.c.c<o> Opt;
  private c Opu;
  private boolean Opv;
  private double Opw;
  private String Opx;
  private String Opy;
  private IListener Opz;
  private String app_id;
  private double hAW;
  private String hQR;
  private int hXQ;
  private int mChannel;
  private int mPayScene;
  private int mRequestCode;
  private int pIZ;
  private ScrollView pJa;
  private WcPayKeyboard pJb;
  private WalletFormView pJe;
  private RelativeLayout pJf;
  private TextView pJg;
  private RelativeLayout pJh;
  private Runnable pJs;
  private int state;
  private IListener<az> vrs;
  
  public RemittanceBusiUI()
  {
    AppMethodBeat.i(68056);
    this.OoC = 0.0F;
    this.Ohb = 4;
    this.OoL = 0;
    this.OoM = 0;
    this.OoN = 0;
    this.OoO = 0;
    this.OoS = new c();
    this.OoT = new b();
    this.OoU = "";
    this.OoV = "";
    this.OoW = false;
    this.hAW = -1.0D;
    this.OoX = false;
    this.OoY = null;
    this.Omo = false;
    this.Opb = false;
    this.mRequestCode = 0;
    this.Opc = new HashMap();
    this.Opd = null;
    this.Ope = false;
    this.Opg = false;
    this.state = 0;
    this.pJs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68025);
        if ((RemittanceBusiUI.h(RemittanceBusiUI.this) == 2) && (RemittanceBusiUI.this.isHandleAutoShowNormalStWcKb())) {
          RemittanceBusiUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(68025);
      }
    };
    this.Ops = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289162);
        RemittanceBusiUI.U(RemittanceBusiUI.this);
        AppMethodBeat.o(289162);
      }
    };
    this.Opt = new com.tencent.mm.wallet_core.c.c()
    {
      public final void a(com.tencent.mm.wallet_core.c.d paramAnonymousd)
      {
        AppMethodBeat.i(289052);
        if ((paramAnonymousd instanceof o)) {
          RemittanceBusiUI.b(RemittanceBusiUI.this, ((o)paramAnonymousd).hAT);
        }
        AppMethodBeat.o(289052);
      }
    };
    this.Opu = new c();
    this.vrs = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Opv = true;
    this.hXQ = 0;
    this.Opw = 0.0D;
    this.Opy = "";
    this.Omy = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Opz = new IListener(com.tencent.mm.app.f.hfK) {};
    this.OpA = new IListener(com.tencent.mm.app.f.hfK) {};
    this.CUH = new IListener(com.tencent.mm.app.f.hfK) {};
    this.OpB = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(68056);
  }
  
  private void a(int paramInt, sg paramsg, boolean paramBoolean, hd paramhd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68077);
    a(paramInt, paramsg, paramBoolean, paramhd, paramString1, paramString2, "");
    AppMethodBeat.o(68077);
  }
  
  private void a(int paramInt, sg paramsg, boolean paramBoolean, hd paramhd, String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = false;
    AppMethodBeat.i(163834);
    int j;
    if (!this.Opv)
    {
      boolean bool2 = Util.isEqual(Double.valueOf(this.Opw), Double.valueOf(this.Oou));
      boolean bool3 = Util.isEqual(this.Opx, this.Onk);
      if (!bool2)
      {
        j = 1;
        i = j;
        if (bool3) {}
      }
    }
    for (int i = j | 0x2;; i = 0)
    {
      j = paramInt + (int)this.OoT.gMj();
      com.tencent.mm.plugin.remittance.model.l.a locala = new com.tencent.mm.plugin.remittance.model.l.a();
      locala.xar = this.Omj;
      locala.OiD = this.Oot;
      locala.scene = this.mPayScene;
      locala.OiE = this.Ooy;
      locala.OiF = this.Onk;
      locala.MSL = j;
      locala.channel = this.mChannel;
      locala.OiG = this.Ooz;
      locala.OiH = this.OoF;
      locala.OiI = this.OoH;
      locala.OiJ = this.OoG;
      locala.nQU = this.Oov;
      locala.OiK = this.OoS.Olg;
      if (paramsg == null)
      {
        paramsg = "";
        locala.OiL = paramsg;
        locala.OhP = this.Ons.OhP;
        locala.OiB = paramString1;
        locala.OiM = this.OlF;
        locala.nickName = paramString2;
        locala.OiN = this.Oow;
        locala.OiO = this.Opy;
        locala.OiP = this.hXQ;
        locala.OiQ = i;
        locala.OiR = paramString3;
        locala.OiU = paramInt;
        locala.OiV = this.OoD;
        if (this.OoT.gMe()) {
          locala.OiW = this.OoT.gMk().Oiy;
        }
        paramsg = new com.tencent.mm.plugin.remittance.model.l(locala);
        if (paramBoolean) {
          paramsg.a(paramhd);
        }
        if (!this.mKindaEnable) {
          break label490;
        }
        if (this.Opd == null) {
          break label483;
        }
        this.Opd.showSafeProgress();
        label381:
        paramBoolean = bool1;
      }
      for (;;)
      {
        label384:
        doSceneProgress(paramsg, paramBoolean);
        if (this.Ope)
        {
          if (j == this.Opf) {
            a(5, this.Opj);
          }
        }
        else {
          label415:
          if ((f.gMD().getContext() != null) && ((f.gMD().getContext() instanceof RemittanceBusiUI))) {
            if (this.Opg)
            {
              if (j != this.Opi) {
                break label516;
              }
              a(13, this.Opj);
            }
          }
        }
        for (;;)
        {
          this.Opi = j;
          AppMethodBeat.o(163834);
          return;
          paramsg = paramsg.OiL;
          break;
          label483:
          showLoading();
          break label381;
          label490:
          if (f.gMD().gMG()) {
            break label529;
          }
          paramBoolean = true;
          break label384;
          a(4, this.Opj);
          break label415;
          label516:
          a(12, this.Opj);
        }
        label529:
        paramBoolean = bool1;
      }
      j = 0;
      break;
    }
  }
  
  private void a(com.tencent.mm.plugin.remittance.model.e parame, com.tencent.mm.plugin.remittance.model.f paramf, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(68069);
    if (this.OoW)
    {
      this.Oop.setText(i.formatMoney2f(gMK() / 100.0D));
      MMHandlerThread.removeRunnable(this.Ops);
      this.Oou = gMJ();
      long l = Math.round(this.Oou * 100.0D);
      if (l <= 0L)
      {
        aUd(this.Ons.OhO);
        if (this.OoY != null) {
          this.OoY.cancel = true;
        }
        AppMethodBeat.o(68069);
        return;
      }
      if (this.OoT.gMe())
      {
        this.Ooa.setTextColor(getContext().getResources().getColor(a.c.hint_text_color));
        this.OoT.Ola = true;
        gMO();
      }
      j.a locala = new j.a();
      locala.Oit = ((int)l);
      locala.amount = (locala.Oit + (int)this.OoT.gMj());
      locala.channel = this.mChannel;
      locala.OhP = this.Ons.OhP;
      locala.Oiu = this.Ooy;
      locala.Oiv = this.OlF;
      locala.OhQ = this.Ons.OhQ;
      locala.Oiw = this.Omj;
      locala.nQU = this.Oov;
      locala.OhR = this.Ons.OhR;
      if (parame == null) {
        i = 0;
      }
      locala.Oix = i;
      if (this.OoT.gMe()) {
        locala.Oiy = this.OoT.gMk().Oiy;
      }
      this.OoY = new com.tencent.mm.plugin.remittance.model.j(locala, parame, paramf);
      MMHandlerThread.postToMainThreadDelayed(this.Ops, paramInt);
    }
    AppMethodBeat.o(68069);
  }
  
  private void a(sm paramsm)
  {
    AppMethodBeat.i(68085);
    Log.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(paramsm.YXH) });
    if (paramsm.YXH == 1)
    {
      paramsm = new Bundle();
      this.CUH.alive();
      paramsm.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
      paramsm.putString("realname_verify_process_jump_plugin", "remittance");
      paramsm.putInt("real_name_verify_mode", 0);
      paramsm.putInt("entry_scene", this.mPayScene);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramsm);
      AppMethodBeat.o(68085);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject;
    if (!Util.isNullOrNil(this.OoR)) {
      localObject = this.OoR;
    }
    for (;;)
    {
      localIntent.putExtra("INTENT_TITLE", (String)localObject);
      localIntent.putExtra("INTENT_CAN_TOUCH", this.OoL);
      localIntent.putExtra("INTENT_PAYFEE", i.formatMoney2f(0.0D));
      localIntent.putExtra("INTENT_REQKEY", paramsm.hMy);
      paramsm = paramsm.YXI;
      try
      {
        localIntent.putExtra("INTENT_TOKENMESS", paramsm.toByteArray());
        com.tencent.mm.br.c.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", localIntent, 2);
        AppMethodBeat.o(68085);
        return;
      }
      catch (Exception paramsm)
      {
        String str;
        StringBuilder localStringBuilder;
        Log.printErrStackTrace("MicroMsg.RemittanceBusiUI", paramsm, "", new Object[0]);
        AppMethodBeat.o(68085);
      }
      str = getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
      if (!Util.isNullOrNil(this.Oov))
      {
        com.tencent.mm.kernel.h.baF();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(this.Oov);
        if (localObject != null)
        {
          localObject = ((au)localObject).aSV();
          localStringBuilder = new StringBuilder().append(i.bEU((String)localObject));
          if (Util.isNullOrNil(this.Oow)) {}
          for (localObject = "";; localObject = "(" + this.Oow + ")")
          {
            localObject = Util.safeFormatString(str, new Object[] { (String)localObject });
            break;
          }
        }
        Log.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.Oov);
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
      if (Util.isNullOrNil(this.MyF)) {
        this.MyF = str1;
      }
      if (d >= 0.0D) {
        this.hAW = d;
      }
      if (this.Omo) {
        com.tencent.mm.plugin.report.service.h.OAn.b(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      gMS();
      aUe(str2);
    }
    for (;;)
    {
      c(paramBoolean, paramIntent);
      AppMethodBeat.o(68073);
      return;
      if (ah.cq(paramIntent))
      {
        finish();
        AppMethodBeat.o(68073);
        return;
      }
      if (ah.cr(paramIntent))
      {
        AppMethodBeat.o(68073);
        return;
      }
      Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
      gMR();
    }
  }
  
  private boolean a(com.tencent.mm.plugin.remittance.model.l paraml)
  {
    AppMethodBeat.i(68079);
    boolean bool1 = false;
    if (!this.Omt) {
      bool1 = b(paraml);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = c(paraml);
    }
    AppMethodBeat.o(68079);
    return bool2;
  }
  
  private void aUd(String paramString)
  {
    AppMethodBeat.i(289048);
    this.OoS.gMn();
    this.Ooa.setTextColor(getContext().getResources().getColor(a.c.hint_text_color));
    this.Ooa.setText(paramString);
    if (this.OoT.gMe())
    {
      this.OoT.gMl();
      gMO();
    }
    AppMethodBeat.o(289048);
  }
  
  private void aUe(String paramString)
  {
    AppMethodBeat.i(68086);
    Log.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", new Object[] { paramString });
    paramString = (eh)this.Opc.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(68086);
      return;
    }
    if (!Util.isNullOrNil(this.MyF)) {
      paramString.Oln = this.MyF;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.k(paramString, this.OoU), false);
    AppMethodBeat.o(68086);
  }
  
  private eh ahn(int paramInt)
  {
    AppMethodBeat.i(289062);
    eh localeh = new eh();
    localeh.channel = this.mChannel;
    localeh.YGt = this.Onj;
    localeh.Oln = this.MyF;
    localeh.OhP = this.Ons.OhP;
    localeh.scene = this.mPayScene;
    localeh.YGu = this.Ono;
    localeh.OiK = this.OoS.Olg;
    localeh.nQU = this.Oov;
    localeh.Oiw = this.Omj;
    localeh.YGv = paramInt;
    if (this.OoT.gMe()) {
      localeh.Oiy = this.OoT.gMk().Oiy;
    }
    AppMethodBeat.o(289062);
    return localeh;
  }
  
  private void aho(int paramInt)
  {
    AppMethodBeat.i(289112);
    if (this.OoE) {}
    for (TextView localTextView = this.OnT;; localTextView = this.Opq)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
      localTextView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(289112);
      return;
    }
  }
  
  private void au(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(68075);
    Log.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    eh localeh = (eh)this.Opc.get(paramString);
    if (localeh == null)
    {
      AppMethodBeat.o(68075);
      return;
    }
    fnr localfnr = this.OoJ;
    String str = this.OoI;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = new o(localfnr, localeh, str, i, this.OoK, paramString);
      if (!paramBoolean) {
        break;
      }
      paramString.hasRetried = true;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
      AppMethodBeat.o(68075);
      return;
    }
    this.OoO = 0;
    doSceneForceProgress(paramString);
    AppMethodBeat.o(68075);
  }
  
  private boolean b(final com.tencent.mm.plugin.remittance.model.l paraml)
  {
    AppMethodBeat.i(68080);
    if (!Util.isNullOrNil(paraml.OiA.YXB))
    {
      this.Omt = true;
      cG(1, paraml.OiA.YGt);
      f.gMD().a(paraml.OiA.YXB, getString(a.i.app_remind), getString(a.i.remittance_busi_continue_text), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(289044);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 3, paraml.OiA.YGt);
          if (!RemittanceBusiUI.b(RemittanceBusiUI.this, paraml))
          {
            if (RemittanceBusiUI.ab(RemittanceBusiUI.this))
            {
              if (RemittanceBusiUI.X(RemittanceBusiUI.this) == null) {
                break label84;
              }
              RemittanceBusiUI.X(RemittanceBusiUI.this).showSafeProgress();
            }
            for (;;)
            {
              RemittanceBusiUI.a(RemittanceBusiUI.this, paraml);
              AppMethodBeat.o(289044);
              return;
              label84:
              RemittanceBusiUI.this.showLoading();
            }
          }
          RemittanceBusiUI.ac(RemittanceBusiUI.this);
          AppMethodBeat.o(289044);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(289041);
          RemittanceBusiUI.ac(RemittanceBusiUI.this);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 2, paraml.OiA.YGt);
          AppMethodBeat.o(289041);
        }
      });
      AppMethodBeat.o(68080);
      return true;
    }
    AppMethodBeat.o(68080);
    return false;
  }
  
  private void c(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68074);
    this.Opv = false;
    if (paramBoolean)
    {
      Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
      this.hXQ = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", new Object[] { Double.valueOf(this.Opw), Double.valueOf(this.Opw), this.Opx, this.Opy });
      AppMethodBeat.o(68074);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(68074);
        return;
      }
      this.hXQ = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.Opw = this.Oou;
      this.Opx = this.Onk;
      this.Opy = this.Onj;
    }
  }
  
  private boolean c(final com.tencent.mm.plugin.remittance.model.l paraml)
  {
    AppMethodBeat.i(68083);
    if (paraml.OiA.YXC != null)
    {
      this.Omw = true;
      f.gMD().a(paraml.OiA.wuA, "", paraml.OiA.YXC.right_button_wording, paraml.OiA.YXC.rGU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(289038);
          Log.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { paraml.OiA.YXC.wYO });
          i.p(RemittanceBusiUI.this.getContext(), paraml.OiA.YXC.wYO, false);
          AppMethodBeat.o(289038);
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
  
  private void cG(int paramInt, String paramString)
  {
    AppMethodBeat.i(68081);
    this.Omq = new rl();
    this.Omq.iqr = 1L;
    this.Omq.ikE = paramInt;
    this.Omq.yp(paramString);
    this.Omq.bMH();
    AppMethodBeat.o(68081);
  }
  
  private void d(com.tencent.mm.plugin.remittance.model.l paraml)
  {
    AppMethodBeat.i(68084);
    Log.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(paraml.OiA.YXG) });
    if (f.gMD().gMF()) {
      Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitLMRemindUI");
    }
    Object localObject1 = ahn(paraml.MSL);
    this.Opc.put(paraml.OiA.hMy, localObject1);
    if (paraml.OiA.YXG == 1)
    {
      a(paraml.OiA);
      AppMethodBeat.o(68084);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.hAT = paraml.OiA.hMy;
    localPayInfo.hUR = this.mPayScene;
    if (this.mChannel > 0) {
      localPayInfo.channel = this.mChannel;
    }
    if (paraml.OiA.YXN != null) {
      localPayInfo.Hgd = paraml.OiA.YXN.ZV();
    }
    localPayInfo.VSv = paraml.OiA.YXM;
    Object localObject2;
    if (paraml.OiA.YXO == 1)
    {
      bool = true;
      localPayInfo.VGV = bool;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("extinfo_key_1", this.Oov);
      ((Bundle)localObject1).putString("extinfo_key_2", this.Oow);
      ((Bundle)localObject1).putString("extinfo_key_3", this.Ooy);
      ((Bundle)localObject1).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
      ((Bundle)localObject1).putString("extinfo_key_7", this.Onk);
      ((Bundle)localObject1).putString("extinfo_key_19", paraml.OiA.OjY);
      localPayInfo.nKf = ((Bundle)localObject1);
      localPayInfo.Okk = 1;
      localObject2 = new Intent();
      if (paraml.OiA.OjV != 1) {
        break label630;
      }
      ((Bundle)localObject1).putInt("extinfo_key_15", paraml.OiA.YXP);
      ((Bundle)localObject1).putString("extinfo_key_17", paraml.OiA.OjW);
      ((Bundle)localObject1).putString("extinfo_key_18", paraml.OiA.OjX);
      ((Intent)localObject2).putExtra("key_pay_info", localPayInfo);
      ((Intent)localObject2).putExtra("from_patch_ui", true);
      ((Intent)localObject2).putExtra("key_rcvr_open_id", this.Omj);
      ((Intent)localObject2).putExtra("key_mch_info", this.OoB);
      ((Intent)localObject2).putExtra("key_mch_photo", this.Ons.OhN);
      ((Intent)localObject2).putExtra("key_transfer_qrcode_id", this.Oot);
      ((Intent)localObject2).putExtra("get_dynamic_code_sign", paraml.OiA.OjW);
      ((Intent)localObject2).putExtra("get_dynamic_code_extend", paraml.OiA.OjX);
      ((Intent)localObject2).putExtra("dynamic_code_spam_wording", paraml.OiA.OjZ);
      ((Intent)localObject2).putExtra("dynamic_code_amount", paraml.OiA.YXP);
      ((Intent)localObject2).putExtra("show_paying_wording", paraml.OiA.OjY);
      if (this.Ons.OhW != 1) {
        break label625;
      }
    }
    label625:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("show_avatar_type", bool);
      com.tencent.mm.plugin.report.service.h.OAn.b(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      this.Omy.alive();
      this.Opz.alive();
      this.OpA.alive();
      if (this.mKindaEnable) {
        hideLoading();
      }
      com.tencent.mm.br.c.b(this, "remittance", ".ui.RemittanceF2fDynamicCodeUI", (Intent)localObject2, 3);
      AppMethodBeat.o(68084);
      return;
      bool = false;
      break;
    }
    label630:
    if (this.mKindaEnable)
    {
      this.mRequestCode = 1;
      if (this.Opd != null) {
        this.mRequestCode = 3;
      }
      localObject1 = "";
      if (!Util.isNullOrNil(paraml.OiA.OjY))
      {
        localObject1 = paraml.OiA.OjY;
        if (localPayInfo.nKf == null) {
          localPayInfo.nKf = new Bundle();
        }
        localPayInfo.nKf.putString("cashier_desc", (String)localObject1);
        if (Util.isNullOrNil(this.Oov)) {
          break label1325;
        }
        com.tencent.mm.kernel.h.baF();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(this.Oov);
        if (localObject1 == null) {
          break label1325;
        }
        localObject1 = ((au)localObject1).aSV();
        localObject2 = new StringBuilder().append(i.bEU((String)localObject1));
        if (!Util.isNullOrNil(this.Oow)) {
          break label1151;
        }
        localObject1 = "";
      }
    }
    label1325:
    for (localObject1 = (String)localObject1;; localObject1 = "")
    {
      for (;;)
      {
        localPayInfo.nKf.putString("prepay_page_payee", (String)localObject1);
        paraml = ahn(paraml.MSL);
        try
        {
          localPayInfo.nKf.putByteArray("after_place_order_commreq", paraml.toByteArray());
          localPayInfo.nKf.putString("suc_page_extend", this.OoV);
          localPayInfo.nKf.putInt("fault_flag", this.OoQ);
          localPayInfo.nKf.putString("suc_page_name", this.Ons.OhY);
          localPayInfo.nKf.putString("rece_photo_url", this.Ons.OhN);
          if (this.Opd != null)
          {
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this.Opd, localPayInfo);
            this.Opb = true;
            AppMethodBeat.o(68084);
            return;
            Object localObject3 = getIntent().getStringExtra("receiver_tips");
            localObject2 = getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
            if (!Util.isNullOrNil((String)localObject3))
            {
              localObject2 = localObject3;
              localObject1 = localObject3;
            }
            if (!Util.isNullOrNil(this.Oov))
            {
              com.tencent.mm.kernel.h.baF();
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(this.Oov);
              if (localObject3 != null)
              {
                localObject1 = ((au)localObject3).aSV();
                localObject3 = new StringBuilder().append(i.bEU((String)localObject1));
                if (Util.isNullOrNil(this.Oow)) {}
                for (localObject1 = "";; localObject1 = "(" + this.Oow + ")")
                {
                  localObject1 = Util.safeFormatString((String)localObject2, new Object[] { (String)localObject1 });
                  break;
                }
              }
              Log.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.Oov);
              break;
            }
            Log.e("MicroMsg.RemittanceBusiUI", "mRcverName is null ,scene is MMPAY_PAY_SCENE_TRANSFER busi");
            break;
            label1151:
            localObject1 = "(" + this.Oow + ")";
          }
        }
        catch (IOException paraml)
        {
          for (;;)
          {
            Log.e("MicroMsg.RemittanceBusiUI", "reqPlaceOrder parse failed");
            continue;
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, localPayInfo);
          }
        }
      }
      if (!Util.isNullOrNil(paraml.OiB)) {}
      for (this.Omo = true; (paraml.OiC != null) && (paraml.OiC.hHR.hHU != null); this.Omo = false)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(paraml.OiC.hHR.hHU, false, "", localPayInfo, this.Oow, (Intent)localObject2, paraml.OiC.hHR.mRequestCode);
        AppMethodBeat.o(68084);
        return;
      }
      com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", localPayInfo, this.Oow, (Intent)localObject2, 1);
      AppMethodBeat.o(68084);
      return;
    }
  }
  
  private void evt()
  {
    AppMethodBeat.i(68087);
    this.Oou = gMJ();
    if (this.Oou <= 0.0D)
    {
      this.OnY.setClickable(false);
      this.OnY.setEnabled(false);
      this.OnY.setOnClickListener(null);
      hH(false);
      AppMethodBeat.o(68087);
      return;
    }
    this.OnY.setEnabled(true);
    this.OnY.setClickable(true);
    hH(true);
    this.OnY.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(289023);
        com.tencent.mm.plugin.report.service.h.OAn.b(15235, new Object[] { Integer.valueOf(3) });
        if (RemittanceBusiUI.q(RemittanceBusiUI.this) == 56) {
          com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
        }
        RemittanceBusiUI.M(RemittanceBusiUI.this);
        AppMethodBeat.o(289023);
      }
    });
    AppMethodBeat.o(68087);
  }
  
  private double gMJ()
  {
    AppMethodBeat.i(68057);
    if ((this.OoE) || (this.mPayScene == 33))
    {
      d = this.Oou;
      AppMethodBeat.o(68057);
      return d;
    }
    this.Oou = Util.getDouble(this.pJe.getText(), 0.0D);
    double d = this.Oou;
    AppMethodBeat.o(68057);
    return d;
  }
  
  private long gMK()
  {
    AppMethodBeat.i(289015);
    long l1 = Math.round(gMJ() * 100.0D);
    long l2 = this.OoT.gMj();
    AppMethodBeat.o(289015);
    return l1 + l2;
  }
  
  private boolean gML()
  {
    boolean bool2 = true;
    AppMethodBeat.i(289018);
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.Ons.OhT != null)
    {
      bool1 = bool3;
      if (this.Ons.OhT.YXg.size() > 0) {
        bool1 = true;
      }
    }
    if (this.Ons.OhS.size() > 0) {
      bool1 = true;
    }
    if (this.OoS.gMo().size() > 0) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(289018);
      return bool1;
    }
  }
  
  private boolean gMM()
  {
    int j = 0;
    AppMethodBeat.i(68067);
    boolean bool1;
    if (this.OnX == null) {
      bool1 = false;
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.p.a(this, this.pJa, findViewById(a.f.remittance_main_ui), findViewById(a.f.remittance_main_ui), findViewById(a.f.remittance_main_bottom_ui), this.OoC);
      AppMethodBeat.o(68067);
      return bool1;
      if (this.Ons != null)
      {
        Log.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        bool1 = gML();
        boolean bool2 = this.OoT.gMe();
        if ((!bool1) && (!bool2))
        {
          this.OnX.setVisibility(8);
          this.Opa.update();
          this.Ooo.setVisibility(8);
          bool1 = false;
        }
        else
        {
          this.Ooo.setVisibility(0);
          this.OoZ.update();
          this.OnX.setVisibility(0);
          View localView = this.OnY;
          if (bool1)
          {
            i = 0;
            label162:
            localView.setVisibility(i);
            localView = this.Ooc;
            if (!bool2) {
              break label248;
            }
            i = 0;
            label181:
            localView.setVisibility(i);
            if ((!bool1) || (!bool2)) {
              break label254;
            }
            i = 1;
            label198:
            localView = this.Oob;
            if (i == 0) {
              break label259;
            }
          }
          label259:
          for (int i = j;; i = 8)
          {
            localView.setVisibility(i);
            if (bool1) {
              gMN();
            }
            if (bool2) {
              gMO();
            }
            gMP();
            bool1 = true;
            break;
            i = 8;
            break label162;
            label248:
            i = 8;
            break label181;
            label254:
            i = 0;
            break label198;
          }
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  private void gMN()
  {
    AppMethodBeat.i(289028);
    this.Ooa.setText(this.Ons.OhO);
    this.Ooa.setTextColor(getContext().getResources().getColor(a.c.hint_text_color));
    Object localObject = this.OoS.Olg;
    if (localObject != null)
    {
      this.Ooa.setTextColor(getContext().getResources().getColor(a.c.Orange));
      this.Ooa.setText(((asl)localObject).OhO);
    }
    for (;;)
    {
      this.OnY.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(289089);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(289089);
            return false;
            RemittanceBusiUI.k(RemittanceBusiUI.this).setAlpha(0.5F);
            continue;
            RemittanceBusiUI.k(RemittanceBusiUI.this).setAlpha(1.0F);
          }
        }
      });
      this.OnY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(289076);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.report.service.h.OAn.b(15235, new Object[] { Integer.valueOf(3) });
          if (RemittanceBusiUI.q(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          RemittanceBusiUI.M(RemittanceBusiUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(289076);
        }
      });
      AppMethodBeat.o(289028);
      return;
      localObject = this.OoS.gMp();
      if (!Util.isNullOrNil((String)localObject))
      {
        this.Ooa.setTextColor(getContext().getResources().getColor(a.c.hint_text_color));
        this.Ooa.setText((CharSequence)localObject);
      }
    }
  }
  
  private void gMO()
  {
    AppMethodBeat.i(289034);
    this.Ooh.setText(this.OoT.gMk().Zxi);
    this.Ooh.setTextColor(this.OoT.gMh());
    if (!this.OoT.gMg())
    {
      this.Ooj.setVisibility(8);
      this.Ooi.setVisibility(0);
      this.Oof.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.Oog.getLayoutParams()).addRule(0, a.f.favor_extra_buy_item_checkbox);
      this.Ooi.setChecked(this.OoT.gMi());
      this.Ooi.setEnabled(this.OoT.gMf());
      this.Ooc.setOnTouchListener(null);
      this.Ooc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(289126);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((RemittanceBusiUI.this.OoY != null) && (!RemittanceBusiUI.this.OoY.Oir))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(289126);
            return;
          }
          boolean bool = RemittanceBusiUI.N(RemittanceBusiUI.this).isEnabled();
          Log.i("MicroMsg.RemittanceBusiUI", "clicked extrabuy favor view, enabled=%b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            paramAnonymousView = RemittanceBusiUI.N(RemittanceBusiUI.this);
            if (!RemittanceBusiUI.N(RemittanceBusiUI.this).isChecked())
            {
              bool = true;
              paramAnonymousView.setChecked(bool);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(289126);
            return;
            bool = false;
            break;
            paramAnonymousView = ((apu)RemittanceBusiUI.O(RemittanceBusiUI.this).gMk().Oiy.getFirst()).Zxh;
            f.gMD().a(paramAnonymousView, null, RemittanceBusiUI.this.getContext().getString(a.i.i_know_it), null, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            }, null);
          }
        }
      });
      this.Ooe.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(289123);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(289123);
            return false;
            RemittanceBusiUI.P(RemittanceBusiUI.this).setAlpha(0.5F);
            continue;
            RemittanceBusiUI.P(RemittanceBusiUI.this).setAlpha(1.0F);
          }
        }
      });
      this.Ooe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(289120);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RemittanceBusiUI.Q(RemittanceBusiUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(289120);
        }
      });
      this.Ooi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(289115);
          paramAnonymousCompoundButton = RemittanceBusiUI.O(RemittanceBusiUI.this);
          Log.i("MicroMsg.ExtraBuyInfoHelper", "set %d selected: %b", new Object[] { Long.valueOf(((apu)paramAnonymousCompoundButton.gMk().Oiy.getFirst()).Zxa), Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousCompoundButton.OkY != null) {
            ((apu)paramAnonymousCompoundButton.OkY.Oiy.getFirst()).Bvd = paramAnonymousBoolean;
          }
          if (paramAnonymousCompoundButton.OkZ != null) {
            ((apu)paramAnonymousCompoundButton.OkZ.Oiy.getFirst()).Bvd = paramAnonymousBoolean;
          }
          RemittanceBusiUI.a(RemittanceBusiUI.this, null, 0);
          AppMethodBeat.o(289115);
        }
      });
      AppMethodBeat.o(289034);
      return;
    }
    this.Oof.setVisibility(8);
    this.Ooi.setVisibility(8);
    this.Ooj.setVisibility(0);
    ((RelativeLayout.LayoutParams)this.Oog.getLayoutParams()).addRule(0, a.f.favor_extra_buy_item_right_arrow);
    this.Ooe.setOnClickListener(null);
    this.Ooe.setOnTouchListener(null);
    this.Ooc.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(289110);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(289110);
          return false;
          RemittanceBusiUI.R(RemittanceBusiUI.this).setAlpha(0.5F);
          continue;
          RemittanceBusiUI.R(RemittanceBusiUI.this).setAlpha(1.0F);
        }
      }
    });
    this.Ooc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(289114);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((RemittanceBusiUI.this.OoY != null) && (!RemittanceBusiUI.this.OoY.Oir))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(289114);
          return;
        }
        RemittanceBusiUI.Q(RemittanceBusiUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289114);
      }
    });
    AppMethodBeat.o(289034);
  }
  
  private void gMP()
  {
    AppMethodBeat.i(289037);
    this.Oop.setText(i.formatMoney2f(gMK() / 100.0D));
    asl localasl = this.OoS.Olg;
    if (localasl != null) {
      this.Oop.setText(i.formatMoney2f(localasl.ZCf / 100.0D));
    }
    AppMethodBeat.o(289037);
  }
  
  private void gMQ()
  {
    AppMethodBeat.i(163833);
    hideLoading();
    if (this.Opd != null) {
      this.Opd.hideProgress();
    }
    AppMethodBeat.o(163833);
  }
  
  private void gMR()
  {
    AppMethodBeat.i(68076);
    Log.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    if ((this.OoS.Olg == null) && (!this.OoT.gMe()))
    {
      Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo and ExtraBuyInfo is null");
      AppMethodBeat.o(68076);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.n(ahn((int)Math.round(this.Oou * 100.0D)), this.OoU), false);
    AppMethodBeat.o(68076);
  }
  
  private void gMS()
  {
    AppMethodBeat.i(68078);
    Log.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Object localObject = new Intent(this, RemittanceBusiResultUI.class);
    ((Intent)localObject).putExtra("key_pay_desc", this.Onk);
    ((Intent)localObject).putExtra("key_rcv_desc", this.Ooy);
    if (this.Ons != null) {
      ((Intent)localObject).putExtra("BusiRemittanceResp", this.Ons);
    }
    ((Intent)localObject).putExtra("key_mch_name", this.OlF);
    ((Intent)localObject).putExtra("key_rcver_name", this.Oov);
    ((Intent)localObject).putExtra("key_rcver_true_name", this.Oow);
    if (this.hAW >= 0.0D) {
      ((Intent)localObject).putExtra("key_money", this.hAW);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_f2f_id", this.Onj);
      ((Intent)localObject).putExtra("key_trans_id", this.MyF);
      ((Intent)localObject).putExtra("key_check_sign", this.Ono);
      ((Intent)localObject).putExtra("key_rcvr_open_id", this.Omj);
      ((Intent)localObject).putExtra("key_channel", this.mChannel);
      ((Intent)localObject).putExtra("key_succ_fault_config", this.OoP);
      if (this.Ons != null)
      {
        ((Intent)localObject).putExtra("key_succ_show_avatar_type", this.Ons.OhW);
        ((Intent)localObject).putExtra("key_succ_show_avatar_show", this.Ons.OhM);
        ((Intent)localObject).putExtra("key_succ_show_avatar_url", this.Ons.OhN);
      }
      if (this.Ons != null) {
        ((Intent)localObject).putExtra("key_scan_sceen", this.Ons.OhP);
      }
      ((Intent)localObject).putExtra("key_succ_page_extend", this.OoV);
      if (this.mChannel == 56) {
        ((Intent)localObject).putExtra("app_id", this.app_id);
      }
      eh localeh = ahn((int)Math.round(this.Oou * 100.0D));
      try
      {
        ((Intent)localObject).putExtra("AfterPlaceOrderCommReq", localeh.toByteArray());
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (f.gMD().gME()) {
          Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
        }
        AppMethodBeat.o(68078);
        return;
        ((Intent)localObject).putExtra("key_money", this.Oou);
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
  
  private void gzL()
  {
    AppMethodBeat.i(68066);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289082);
        RemittanceBusiUI.H(RemittanceBusiUI.this).setText(RemittanceBusiUI.G(RemittanceBusiUI.this));
        Object localObject;
        if ((RemittanceBusiUI.n(RemittanceBusiUI.this) != null) && (!Util.isNullOrNil(RemittanceBusiUI.n(RemittanceBusiUI.this).OhX)))
        {
          localObject = RemittanceBusiUI.n(RemittanceBusiUI.this).OhX;
          RemittanceBusiUI.K(RemittanceBusiUI.this).setText(com.tencent.mm.pluginsdk.ui.span.p.b(RemittanceBusiUI.this, (CharSequence)localObject, RemittanceBusiUI.K(RemittanceBusiUI.this).getTextSize()));
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == null) {
            break label359;
          }
          if (RemittanceBusiUI.n(RemittanceBusiUI.this).OhM != 1) {
            break label341;
          }
          if (Util.isNullOrNil(RemittanceBusiUI.n(RemittanceBusiUI.this).OhN)) {
            break label268;
          }
          if (RemittanceBusiUI.n(RemittanceBusiUI.this).OhW != 1) {
            break label254;
          }
          RemittanceBusiUI.L(RemittanceBusiUI.this).setRoundCorner(true);
        }
        for (;;)
        {
          int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, 36.0F);
          RemittanceBusiUI.L(RemittanceBusiUI.this).w(RemittanceBusiUI.n(RemittanceBusiUI.this).OhN, i, i, -1);
          AppMethodBeat.o(289082);
          return;
          String str = i.jo(i.getDisplayName(RemittanceBusiUI.I(RemittanceBusiUI.this)), 10);
          localObject = str;
          if (Util.isNullOrNil(RemittanceBusiUI.J(RemittanceBusiUI.this))) {
            break;
          }
          localObject = RemittanceBusiUI.this.getString(a.i.remittance_collect_block, new Object[] { str, RemittanceBusiUI.J(RemittanceBusiUI.this) });
          break;
          label254:
          RemittanceBusiUI.L(RemittanceBusiUI.this).setRoundCorner(false);
        }
        label268:
        if (!Util.isNullOrNil(RemittanceBusiUI.I(RemittanceBusiUI.this)))
        {
          if (RemittanceBusiUI.n(RemittanceBusiUI.this).OhW == 1)
          {
            a.b.h(RemittanceBusiUI.L(RemittanceBusiUI.this), RemittanceBusiUI.I(RemittanceBusiUI.this));
            AppMethodBeat.o(289082);
            return;
          }
          a.b.g(RemittanceBusiUI.L(RemittanceBusiUI.this), RemittanceBusiUI.I(RemittanceBusiUI.this));
          AppMethodBeat.o(289082);
          return;
          label341:
          RemittanceBusiUI.L(RemittanceBusiUI.this).setVisibility(8);
          AppMethodBeat.o(289082);
          return;
        }
        label359:
        RemittanceBusiUI.L(RemittanceBusiUI.this).setVisibility(8);
        AppMethodBeat.o(289082);
      }
    });
    AppMethodBeat.o(68066);
  }
  
  private void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(68088);
    if (this.pJb != null) {
      this.pJb.Oi(paramBoolean);
    }
    AppMethodBeat.o(68088);
  }
  
  private void ka(final List<asm> paramList)
  {
    AppMethodBeat.i(68068);
    final com.tencent.mm.ui.widget.picker.d locald = new com.tencent.mm.ui.widget.picker.d(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.OoS.Olg;
    Object localObject1 = new HashSet();
    final HashSet localHashSet = new HashSet();
    if ((this.OoS.gMr()) && (localObject2 != null))
    {
      localObject2 = ((asl)localObject2).YXg.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((asm)((Iterator)localObject2).next()).ZCm));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((asm)((Iterator)localObject2).next()).ZCm))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(a.i.remittance_f2f_favor_select);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locald.agkp.setVisibility(0);
      locald.RVm.setText((CharSequence)localObject1);
    }
    locald.agkq = localArrayList;
    locald.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(289172);
        RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.t(RemittanceBusiUI.this));
        asm localasm;
        if ((!RemittanceBusiUI.S(RemittanceBusiUI.this).gMr()) || (RemittanceBusiUI.u(RemittanceBusiUI.this) <= 0.0D))
        {
          localIterator = paramList.iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localasm = (asm)localIterator.next();
            paramAnonymouss.a(i, localasm.ZCn, localasm.ZCp, null, true);
            localHashSet.add(Integer.valueOf(i));
            i += 1;
          }
          AppMethodBeat.o(289172);
          return;
        }
        Iterator localIterator = paramList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          localasm = (asm)localIterator.next();
          if (localasm.Zxg == 1)
          {
            paramAnonymouss.a(i, localasm.ZCn, localasm.ZCp, null, true);
            localHashSet.add(Integer.valueOf(i));
          }
          for (;;)
          {
            i += 1;
            break;
            paramAnonymouss.a(i, localasm.ZCn, localasm.ZCp, 0);
          }
        }
        AppMethodBeat.o(289172);
      }
    };
    locald.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 1;
        int j = 0;
        AppMethodBeat.i(289178);
        if (localHashSet.contains(Integer.valueOf(paramAnonymousInt)))
        {
          AppMethodBeat.o(289178);
          return;
        }
        if (paramAnonymousInt < paramList.size())
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(15235, new Object[] { Integer.valueOf(4) });
          Object localObject1 = (asm)paramList.get(paramAnonymousInt);
          paramAnonymousMenuItem = locald;
          boolean bool;
          if (paramAnonymousMenuItem.agkr != null)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem.agkr.jIB();
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
                ((List)localObject2).add((asm)paramList.get(k));
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
          c localc = RemittanceBusiUI.S(RemittanceBusiUI.this);
          if (i != 0) {}
          for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
          {
            localc.a((List)localObject2, paramAnonymousMenuItem);
            localObject1 = RemittanceBusiUI.S(RemittanceBusiUI.this).Olg;
            paramAnonymousMenuItem = new HashSet();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((asl)localObject1).YXg.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramAnonymousMenuItem.add(Long.valueOf(((asm)((Iterator)localObject1).next()).ZCm));
            }
          }
          localObject1 = new HashMap();
          Object localObject2 = paramList.iterator();
          i = j;
          if (((Iterator)localObject2).hasNext())
          {
            if (paramAnonymousMenuItem.contains(Long.valueOf(((asm)((Iterator)localObject2).next()).ZCm))) {
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
          if (paramAnonymousMenuItem.agkr != null)
          {
            paramAnonymousMenuItem.agkr.agku = ((HashMap)localObject1);
            paramAnonymousMenuItem.agkr.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(289178);
      }
    };
    locald.agks = new d.b()
    {
      public final void BH(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(289164);
        if (paramAnonymousBoolean)
        {
          localObject = RemittanceBusiUI.S(RemittanceBusiUI.this).Olg;
          if (localObject != null) {
            break label56;
          }
        }
        label56:
        for (Object localObject = "";; localObject = com.tencent.mm.plugin.remittance.model.b.a((asl)localObject))
        {
          Log.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
          RemittanceBusiUI.T(RemittanceBusiUI.this);
          AppMethodBeat.o(289164);
          return;
        }
      }
    };
    if (locald.Vtg != null) {
      locald.Vtg.onCreateMMMenu(locald.Vtk);
    }
    locald.agkr = new com.tencent.mm.ui.widget.picker.d.a(locald, locald.mContext);
    locald.agkr.jIA();
    locald.agko.setAdapter(locald.agkr);
    locald.nhC.setOnClickListener(new com.tencent.mm.ui.widget.picker.d.2(locald));
    locald.njI.setOnClickListener(new com.tencent.mm.ui.widget.picker.d.3(locald));
    if (locald.Jjv != null)
    {
      if ((locald.Vtk != null) && (locald.Vtk.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locald.rootView.getLayoutParams();
        paramList.height = locald.sRu;
        locald.rootView.setLayoutParams(paramList);
      }
      locald.Jjv.show();
    }
    AppMethodBeat.o(68068);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.remittance.model.l paraml)
  {
    AppMethodBeat.i(163835);
    bz localbz = new bz();
    localbz.ipH = paramInt;
    if (paraml != null)
    {
      localbz.lp(paraml.OiA.YGt);
      localbz.lq(this.Oot);
      localbz.iuP = paraml.MSL;
    }
    localbz.bMH();
    AppMethodBeat.o(163835);
  }
  
  public final void cY(float paramFloat)
  {
    AppMethodBeat.i(68065);
    if (this.pJa != null)
    {
      this.OoC = paramFloat;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.pJa.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.pJa.setLayoutParams(localLayoutParams);
      com.tencent.mm.ui.tools.p.a(this, this.pJa, findViewById(a.f.remittance_main_ui), findViewById(a.f.remittance_main_ui), findViewById(a.f.remittance_main_bottom_ui), paramFloat);
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
    this.pJa = ((ScrollView)findViewById(a.f.root_view));
    this.Opk = ((LinearLayout)findViewById(a.f.remittance_main_above_ui));
    this.OnR = ((TextView)findViewById(a.f.remittance_busi_name));
    this.OnS = ((TextView)findViewById(a.f.remittance_busi_nick_name));
    this.OnT = ((TextView)findViewById(a.f.remittance_busi_fixed_title));
    this.OnU = ((TextView)findViewById(a.f.remittance_busi_fixed_money));
    this.OnV = ((TextView)findViewById(a.f.remittance_busi_desc));
    this.OnW = ((TextView)findViewById(a.f.remittance_busi_add_desc));
    this.Ook = ((CdnImageView)findViewById(a.f.remittance_busi_logo));
    this.pJe = ((WalletFormView)findViewById(a.f.remittance_busi_money_et));
    this.Opr = this.pJe.getHint();
    this.Ool = ((LinearLayout)findViewById(a.f.remittance_busi_fixed_money_layout));
    this.OlV = ((LinearLayout)findViewById(a.f.remittance_busi_edit_money_layout));
    this.Oos = ((RelativeLayout)findViewById(a.f.wallet_max_unit_line_container));
    this.Oom = ((LinearLayout)findViewById(a.f.remittance_busi_desc_container));
    this.OnX = findViewById(a.f.remittance_busi_favor_layout);
    this.OnY = findViewById(a.f.favor_discount_item_ll);
    this.OnZ = ((TextView)findViewById(a.f.favor_discount_item_title));
    this.Ooa = ((TextView)findViewById(a.f.favor_discount_item_subtitle));
    this.Oob = findViewById(a.f.favor_items_first_separator);
    this.Ooc = findViewById(a.f.favor_extra_buy_item_ll);
    this.Ood = ((TextView)findViewById(a.f.favor_extra_buy_item_title));
    this.Ooe = findViewById(a.f.favor_extra_buy_item_title_ll);
    this.Oof = findViewById(a.f.favor_extra_buy_item_info);
    this.Oog = ((LinearLayout)findViewById(a.f.favor_extra_buy_item_subtitle_wrapper));
    this.Ooh = ((TextView)findViewById(a.f.favor_extra_buy_item_subtitle));
    this.Ooi = ((CheckBox)findViewById(a.f.favor_extra_buy_item_checkbox));
    this.Ooj = findViewById(a.f.favor_extra_buy_item_right_arrow);
    this.Oon = ((TextView)findViewById(a.f.remittance_busi_fixed_currency));
    this.Ooo = findViewById(a.f.final_remittance_layout);
    this.Oop = ((TextView)findViewById(a.f.final_remittance_busi_fixed_money));
    this.Ooq = ((TextView)findViewById(a.f.final_remittance_busi_fixed_currency));
    this.Oor = ((Button)findViewById(a.f.remittance_busi_fixed_pay_btn));
    this.pJb = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.pJe.getContentEt().setTextSize(1, 52.0F);
    this.pJe.getTitleTv().setTextSize(1, 52.0F);
    this.Oon.setTextSize(1, 50.0F);
    this.OnU.setTextSize(1, 42.0F);
    this.Ooq.setTextSize(1, 48.0F);
    this.Oop.setTextSize(1, 48.0F);
    Object localObject1;
    Object localObject2;
    label788:
    label933:
    label1252:
    int i;
    int j;
    int k;
    label1308:
    label1340:
    label1384:
    boolean bool1;
    if (this.OoE)
    {
      if (!Util.isNullOrNil(this.Ooy)) {
        this.OnT.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, this.Ooy, this.OnT.getTextSize()));
      }
      this.OnU.setText(i.formatMoney2f(this.Oou));
      this.Ool.setVisibility(0);
      this.OlV.setVisibility(8);
      this.Oos.setVisibility(8);
      this.Oor.setVisibility(0);
      if (com.tencent.mm.kernel.h.baz())
      {
        com.tencent.mm.kernel.h.baF();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.Oov);
        if ((localObject1 == null) || ((int)((com.tencent.mm.contact.d)localObject1).maN == 0)) {
          az.a.okP.a(this.Oov, "", new az.b.a()
          {
            public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(288980);
              Log.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              RemittanceBusiUI.o(RemittanceBusiUI.this);
              AppMethodBeat.o(288980);
            }
          });
        }
      }
      gzL();
      this.Oom.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(288981);
          if (!RemittanceBusiUI.p(RemittanceBusiUI.this)) {
            RemittanceBusiUI.this.showCircleStWcKb();
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(15235, new Object[] { Integer.valueOf(6) });
          if (RemittanceBusiUI.q(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(6), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          RemittanceBusiUI.c(RemittanceBusiUI.this).clearFocus();
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(a.i.remittance_busi_add_desc), RemittanceBusiUI.r(RemittanceBusiUI.this), RemittanceBusiUI.this.getString(a.i.remittance_busi_desc_max_words_count_tip), true, 20, new com.tencent.mm.ui.base.k.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(289195);
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymous2CharSequence.toString());
              RemittanceBusiUI.s(RemittanceBusiUI.this);
              AppMethodBeat.o(289195);
              return true;
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(289200);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(288972);
                  RemittanceBusiUI.this.hideVKB();
                  AppMethodBeat.o(288972);
                }
              }, 500L);
              AppMethodBeat.o(289200);
            }
          });
          AppMethodBeat.o(288981);
        }
      });
      localObject1 = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(288978);
          com.tencent.mm.plugin.report.service.h.OAn.b(15235, new Object[] { Integer.valueOf(5) });
          if (RemittanceBusiUI.q(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(8), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          if (!RemittanceBusiUI.p(RemittanceBusiUI.this)) {
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.t(RemittanceBusiUI.this));
          }
          if (RemittanceBusiUI.u(RemittanceBusiUI.this) <= 0.0D)
          {
            aa.makeText(RemittanceBusiUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
            AppMethodBeat.o(288978);
            return;
          }
          long l = RemittanceBusiUI.v(RemittanceBusiUI.this);
          com.tencent.mm.plugin.remittance.model.j localj = RemittanceBusiUI.this.OoY;
          if (RemittanceBusiUI.this.OoY == null) {}
          for (paramAnonymousView = "";; paramAnonymousView = RemittanceBusiUI.this.OoY.Oir)
          {
            Log.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localj, paramAnonymousView, Boolean.valueOf(RemittanceBusiUI.this.OoW) });
            if (RemittanceBusiUI.m(RemittanceBusiUI.this) != 32) {
              break label364;
            }
            if (!RemittanceBusiUI.this.OoW) {
              break label351;
            }
            if ((RemittanceBusiUI.this.OoY == null) || (RemittanceBusiUI.this.OoY.OgO != (int)l)) {
              break;
            }
            if ((RemittanceBusiUI.this.OoY != null) && (RemittanceBusiUI.this.OoY.Oir)) {
              break label364;
            }
            if (RemittanceBusiUI.this.OoY == null) {
              break label371;
            }
            RemittanceBusiUI.this.OoY.Oip = new com.tencent.mm.plugin.remittance.model.e()
            {
              public final void jZ(List<asm> paramAnonymous2List)
              {
                AppMethodBeat.i(288929);
                RemittanceBusiUI.w(RemittanceBusiUI.this);
                AppMethodBeat.o(288929);
              }
            };
            AppMethodBeat.o(288978);
            return;
          }
          RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.e()
          {
            public final void jZ(List<asm> paramAnonymous2List)
            {
              AppMethodBeat.i(288928);
              RemittanceBusiUI.w(RemittanceBusiUI.this);
              AppMethodBeat.o(288928);
            }
          }, 0);
          AppMethodBeat.o(288978);
          return;
          label351:
          RemittanceBusiUI.w(RemittanceBusiUI.this);
          AppMethodBeat.o(288978);
          return;
          label364:
          RemittanceBusiUI.w(RemittanceBusiUI.this);
          label371:
          AppMethodBeat.o(288978);
        }
      };
      this.pJe.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(289071);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            Log.i("MicroMsg.RemittanceBusiUI", "click enter");
            this.pJE.onClick(null);
            AppMethodBeat.o(289071);
            return true;
          }
          AppMethodBeat.o(289071);
          return true;
        }
      });
      localObject2 = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (aw.isDarkMode())
      {
        findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
        findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
        ((ImageView)localObject2).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
        this.Oor.setOnClickListener((View.OnClickListener)localObject1);
        this.pJa.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(289073);
            if ((RemittanceBusiUI.x(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.y(RemittanceBusiUI.this).isShown()) && (RemittanceBusiUI.z(RemittanceBusiUI.this).jOm()))
            {
              AppMethodBeat.o(289073);
              return true;
            }
            AppMethodBeat.o(289073);
            return false;
          }
        });
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
        {
          public final void onVisibleStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(289065);
            RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousBoolean);
            if (!paramAnonymousBoolean)
            {
              RemittanceBusiUI.A(RemittanceBusiUI.this).scrollTo(0, 0);
              if ((RemittanceBusiUI.c(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.c(RemittanceBusiUI.this).getVisibility() == 0)) {
                RemittanceBusiUI.c(RemittanceBusiUI.this).setFocusable(false);
              }
            }
            AppMethodBeat.o(289065);
          }
        });
        this.pJh = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
        if ((!LocaleUtil.getApplicationLanguage().equals("zh_CN")) && (!LocaleUtil.getApplicationLanguage().equals("zh_TW")) && (!LocaleUtil.getApplicationLanguage().equals("zh_HK"))) {
          break label1734;
        }
        this.pJf = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
        this.pJg = ((TextView)findViewById(a.f.wallet_max_unit_tv));
        this.pJf.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(289067);
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.B(RemittanceBusiUI.this).getWidth());
            RemittanceBusiUI.C(RemittanceBusiUI.this).setVisibility(8);
            Log.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceBusiUI.D(RemittanceBusiUI.this)) });
            AppMethodBeat.o(289067);
          }
        });
        this.pJe.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void f(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(289081);
            if (Util.isEqual(RemittanceBusiUI.E(RemittanceBusiUI.this), 0))
            {
              Log.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
              RemittanceBusiUI.C(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(289081);
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
            if (i >= RemittanceBusiUI.E(RemittanceBusiUI.this))
            {
              j = RemittanceBusiUI.c(RemittanceBusiUI.this).i(paramAnonymousCharSequence, RemittanceBusiUI.D(RemittanceBusiUI.this), j);
              if (j != 0)
              {
                RemittanceBusiUI.C(RemittanceBusiUI.this).setVisibility(0);
                paramAnonymousCharSequence = ah.bD(MMApplicationContext.getContext(), i);
                RemittanceBusiUI.F(RemittanceBusiUI.this).setText(paramAnonymousCharSequence);
                paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceBusiUI.B(RemittanceBusiUI.this).getLayoutParams();
                paramAnonymousCharSequence.leftMargin = j;
                RemittanceBusiUI.B(RemittanceBusiUI.this).setLayoutParams(paramAnonymousCharSequence);
                AppMethodBeat.o(289081);
                return;
              }
              RemittanceBusiUI.C(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(289081);
              return;
            }
            RemittanceBusiUI.C(RemittanceBusiUI.this).setVisibility(8);
            AppMethodBeat.o(289081);
          }
        });
        if ((this.Ons != null) && (this.Ons.OhT != null))
        {
          this.OoS.Olh = this.Ons.OhT;
          this.OoS.aUa(this.Ons.OhT.YXi);
        }
        if (gMM()) {
          com.tencent.mm.plugin.report.service.h.OAn.b(15235, new Object[] { Integer.valueOf(2) });
        }
        this.Opl = ((LinearLayout)findViewById(a.f.remittance_busi_warning_layout));
        this.Opm = ((LinearLayout)this.Opl.findViewById(a.f.remittance_warning_click_ll));
        this.Opn = ((TextView)this.Opl.findViewById(a.f.remittance_warning_tips));
        this.Opo = ((CdnImageView)this.Opl.findViewById(a.f.remittance_warning_left_logo));
        this.Opp = ((CdnImageView)this.Opl.findViewById(a.f.remittance_warning_right_logo));
        this.Opq = ((TextView)findViewById(a.f.emittance_busi_edit_title));
        if (this.Ons != null)
        {
          localObject1 = this.Ons;
          if ((((BusiRemittanceResp)localObject1).OhU == null) || (((BusiRemittanceResp)localObject1).OhU.abaE != 1) || (((BusiRemittanceResp)localObject1).OhU.acca == null) || (Util.isNullOrNil(((BusiRemittanceResp)localObject1).OhU.acca.wording))) {
            break label1800;
          }
          localObject1 = ((BusiRemittanceResp)localObject1).OhU;
          localObject2 = ((geo)localObject1).acca;
          this.Opl.setVisibility(0);
          Log.i("MicroMsg.RemittanceBusiUI", " warning textInfo.wording:%s", new Object[] { ((gep)localObject2).wording });
          this.Opn.setText(((gep)localObject2).wording);
          if ((!aw.isDarkMode()) || (Util.isNullOrNil(((geo)localObject1).accb))) {
            break label1746;
          }
          this.Opn.setTextColor(i.aHm(((geo)localObject1).accb));
          i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0F);
          j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 8.0F);
          k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 16.0F);
          if ((!aw.isDarkMode()) || (Util.isNullOrNil(((geo)localObject1).accd))) {
            break label1764;
          }
          this.Opo.w(((geo)localObject1).accd, i, i, -1);
          if ((!aw.isDarkMode()) || (Util.isNullOrNil(((geo)localObject1).accf))) {
            break label1782;
          }
          this.Opp.w(((geo)localObject1).accf, j, k, -1);
          this.Opl.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(289077);
              RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)RemittanceBusiUI.ai(RemittanceBusiUI.this).getLayoutParams();
              localLayoutParams.width = (RemittanceBusiUI.aj(RemittanceBusiUI.this).getRight() + com.tencent.mm.cd.a.fromDPToPix(RemittanceBusiUI.this.getContext(), 8));
              localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(RemittanceBusiUI.this.getContext(), 36);
              RemittanceBusiUI.ai(RemittanceBusiUI.this).setLayoutParams(localLayoutParams);
              localLayoutParams = (RelativeLayout.LayoutParams)RemittanceBusiUI.ak(RemittanceBusiUI.this).getLayoutParams();
              localLayoutParams.addRule(3, a.f.remittance_busi_warning_layout);
              localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(RemittanceBusiUI.this.getContext(), 16);
              RemittanceBusiUI.ak(RemittanceBusiUI.this).setLayoutParams(localLayoutParams);
              RemittanceBusiUI.al(RemittanceBusiUI.this);
              RemittanceBusiUI.an(RemittanceBusiUI.this).setMaxWidth(RemittanceBusiUI.am(RemittanceBusiUI.this).getWidth() - com.tencent.mm.cd.a.fromDPToPix(RemittanceBusiUI.this.getContext(), 20) - com.tencent.mm.cd.a.fromDPToPix(RemittanceBusiUI.this.getContext(), 8) - com.tencent.mm.cd.a.fromDPToPix(RemittanceBusiUI.this.getContext(), 12) - com.tencent.mm.cd.a.fromDPToPix(RemittanceBusiUI.this.getContext(), 16));
              AppMethodBeat.o(289077);
            }
          }, 10L);
          this.Opm.setClickable(true);
          this.Opm.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(288977);
              Log.i("MicroMsg.RemittanceBusiUI", " click option item : %s ,type:%s", new Object[] { this.OeO.wording, Integer.valueOf(this.OeO.accg.type) });
              switch (this.OeO.accg.type)
              {
              default: 
                Log.e("MicroMsg.RemittanceBusiUI", "unknow text info type");
                AppMethodBeat.o(288977);
                return;
              case 1: 
                Log.i("MicroMsg.RemittanceBusiUI", " textInfo.jumpInfo.url ：%s", new Object[] { this.OeO.accg.url });
                i.p(RemittanceBusiUI.this.getContext(), this.OeO.accg.url, false);
                AppMethodBeat.o(288977);
                return;
              case 2: 
                Log.i("MicroMsg.RemittanceBusiUI", " textInfo.jumpInfo.username ：%s", new Object[] { this.OeO.accg.username });
                i.y(this.OeO.accg.username, this.OeO.accg.OkP, 0, 1000);
                AppMethodBeat.o(288977);
                return;
              }
              Log.e("MicroMsg.RemittanceBusiUI", " text info type is OPTIONS_MENU_ITEM_JUMP_TYPE_NATIVE");
              AppMethodBeat.o(288977);
            }
          });
          if (!Util.isNullOrNil(this.Ons.Oib)) {
            this.OnZ.setText(this.Ons.Oib);
          }
          if (!Util.isNullOrNil(this.Ons.Oic)) {
            this.Ood.setText(this.Ons.Oic);
          }
        }
        AppMethodBeat.o(68063);
      }
    }
    else
    {
      if (this.Ons == null) {
        break label1873;
      }
      if (this.Ons.OhS.size() <= 0) {
        break label1867;
      }
      bool1 = false;
      label1470:
      bool2 = bool1;
      if (this.Ons.OhT != null)
      {
        bool2 = bool1;
        if (this.Ons.OhT.YXg.size() <= 0) {}
      }
    }
    label1734:
    label1867:
    label1873:
    for (final boolean bool2 = false;; bool2 = true)
    {
      this.Oor.setVisibility(8);
      setWPKeyboard(this.pJe.getContentEt(), bool2, true);
      this.pJe.setmContentAbnormalMoneyCheck(true);
      if (com.tencent.mm.compatible.util.d.rb(28)) {
        this.pJe.getContentEt().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68042);
            if (bool2)
            {
              RemittanceBusiUI.c(RemittanceBusiUI.this).setHint("");
              RemittanceBusiUI.c(RemittanceBusiUI.this).getContentEt().requestFocus();
            }
            AppMethodBeat.o(68042);
          }
        });
      }
      this.pJb.setActionText(getString(a.i.remittance_busi_pay));
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((al)com.tencent.mm.ui.component.k.d(getContext()).q(al.class)).setValue("keyboard_title_key", getString(a.i.remittance_busi_pay));
      setWcKbHeightListener(this);
      ((RelativeLayout.LayoutParams)this.pJb.getLayoutParams()).addRule(12);
      this.pJe.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(289094);
          if (paramAnonymousBoolean)
          {
            RemittanceBusiUI.c(RemittanceBusiUI.this).setHint("");
            RemittanceBusiUI.this.showNormalStWcKb();
            AppMethodBeat.o(289094);
            return;
          }
          RemittanceBusiUI.c(RemittanceBusiUI.this).setHint(RemittanceBusiUI.j(RemittanceBusiUI.this));
          AppMethodBeat.o(289094);
        }
      });
      this.pJe.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(288988);
          RemittanceBusiUI.k(RemittanceBusiUI.this).setTextColor(RemittanceBusiUI.this.getContext().getResources().getColor(a.c.hint_text_color));
          RemittanceBusiUI.l(RemittanceBusiUI.this);
          if (RemittanceBusiUI.m(RemittanceBusiUI.this) == 32)
          {
            paramAnonymousEditable = RemittanceBusiUI.this;
            if (RemittanceBusiUI.n(RemittanceBusiUI.this) != null) {
              break label81;
            }
          }
          label81:
          for (int i = 400;; i = RemittanceBusiUI.n(RemittanceBusiUI.this).OhZ)
          {
            RemittanceBusiUI.a(paramAnonymousEditable, null, i);
            AppMethodBeat.o(288988);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.pJe.jPD();
      this.Ool.setVisibility(8);
      this.OlV.setVisibility(0);
      this.Oos.setVisibility(0);
      break;
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
      ((ImageView)localObject2).setBackgroundResource(a.e.wallet_money_amount_remind_line);
      break label788;
      this.pJh.setVisibility(8);
      break label933;
      label1746:
      this.Opn.setTextColor(i.aHm(((geo)localObject1).absh));
      break label1252;
      label1764:
      this.Opo.w(((geo)localObject1).accc, i, i, -1);
      break label1308;
      label1782:
      this.Opp.w(((geo)localObject1).acce, j, k, -1);
      break label1340;
      Log.i("MicroMsg.RemittanceBusiUI", " do not show WarningView");
      this.Opl.setVisibility(8);
      localObject1 = (RelativeLayout.LayoutParams)this.Opk.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 0);
      this.Opk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      aho(32);
      break label1384;
      bool1 = true;
      break label1470;
    }
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(68062);
    if (this.mKindaEnable)
    {
      if ((!this.Opb) && (!this.OoE) && (this.pJb.jOo()))
      {
        AppMethodBeat.o(68062);
        return true;
      }
      AppMethodBeat.o(68062);
      return false;
    }
    if ((!this.OoE) && (this.pJb.jOo()))
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
      if (this.Opd != null)
      {
        this.Opd.hideProgress();
        this.Opd = null;
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
          this.OoK = str;
          this.hAW = 0.0D;
          Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          au(false, paramIntent.getStringExtra("INTENT_REQKEY"));
        }
        else
        {
          gMR();
        }
      }
      else if (paramInt1 == 4) {
        this.Opg = true;
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
      com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(4), this.app_id, Integer.valueOf(0) });
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(15235, new Object[] { Integer.valueOf(1) });
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
    if ((com.tencent.mm.compatible.util.d.rb(21)) && (!com.tencent.mm.compatible.util.d.rb(23))) {
      getWindow().setStatusBarColor(getContext().getResources().getColor(a.c.BW_93));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68035);
        if (RemittanceBusiUI.i(RemittanceBusiUI.this))
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
    regeistQueryOrder(2682, this.Opt);
    setMMTitle(a.i.remittance_busi_pay);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68014);
        RemittanceBusiUI.e(RemittanceBusiUI.this);
        if (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) == 56)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(5), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          RemittanceBusiUI.gMT();
        }
        while (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) != 71)
        {
          RemittanceBusiUI.this.finish();
          AppMethodBeat.o(68014);
          return false;
        }
        RemittanceBusiUI.g(RemittanceBusiUI.this);
        AppMethodBeat.o(68014);
        return false;
      }
    });
    if (getIntent().getIntExtra("pay_channel", 0) == 71)
    {
      paramBundle = getResources().getDrawable(a.h.actionbar_icon_dark_close).mutate();
      paramBundle.setColorFilter(a.c.BG_2, PorterDuff.Mode.SRC_IN);
      updateBackBtn(paramBundle);
    }
    this.hQR = UUID.randomUUID().toString();
    com.tencent.mm.plugin.wallet.pay.a.b.bgj(this.hQR);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    this.Oot = getIntent().getStringExtra("scan_remittance_id");
    this.Oou = getIntent().getDoubleExtra("fee", 0.0D);
    this.Oov = getIntent().getStringExtra("receiver_name");
    this.Oow = getIntent().getStringExtra("receiver_true_name");
    this.Oox = getIntent().getStringExtra("receiver_true_name_busi");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.Ooy = getIntent().getStringExtra("desc");
    this.OoA = getIntent().getIntExtra("busi_type", 0);
    this.OlF = getIntent().getStringExtra("mch_name");
    this.OoF = getIntent().getStringExtra("mch_type");
    this.OoH = getIntent().getIntExtra("mch_time", 0);
    this.OoB = getIntent().getStringExtra("mch_info");
    this.OoG = getIntent().getIntExtra("get_pay_wifi", 0);
    this.Omj = getIntent().getStringExtra("rcvr_open_id");
    this.Ooz = getIntent().getStringExtra("rcvr_ticket");
    this.Ohb = getIntent().getIntExtra("amount_remind_bit", 4);
    this.OoD = getIntent().getStringExtra("qq_extend_info");
    this.OoR = getIntent().getStringExtra("receiver_tips");
    this.Ons = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
    int i;
    boolean bool;
    if (this.Ons != null)
    {
      this.OoT = new b(getContext(), this.Ons.Oia);
      if ((this.mPayScene == 32) && ((this.Ons.OhV == 1) || ((this.Ons != null) && (this.Ons.OhS.size() > 0))))
      {
        i = 1;
        if ((!this.OoT.gMe()) && (i == 0)) {
          break label926;
        }
        bool = true;
        label776:
        this.OoW = bool;
        if (this.Oou <= 0.0D) {
          break label951;
        }
      }
    }
    label926:
    label951:
    for (this.OoE = true;; this.OoE = false)
    {
      if (this.OoA == 0)
      {
        Log.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.OoZ = new b(32, 32, 6.0F);
      this.Opa = new b(56, 56, 8.0F);
      initView();
      evt();
      this.vrs.alive();
      this.OpB.alive();
      if (!this.OoE) {
        this.state = 1;
      }
      AppMethodBeat.o(68058);
      return;
      i = 0;
      break;
      bool = false;
      break label776;
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
    this.Omy.dead();
    this.CUH.dead();
    this.Opz.dead();
    this.OpA.dead();
    removeSceneEndListener(1633);
    removeSceneEndListener(1241);
    removeSceneEndListener(2677);
    removeSceneEndListener(2504);
    removeSceneEndListener(2702);
    removeSceneEndListener(2682);
    this.vrs.dead();
    this.OpB.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.bgk(this.hQR);
    MMHandlerThread.removeRunnable(this.pJs);
    AppMethodBeat.o(68070);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(68061);
    Log.i("MicroMsg.RemittanceBusiUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
    AppMethodBeat.o(68061);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68064);
    if ((this.pJb != null) && (this.pJb.onKeyUp(paramInt, paramKeyEvent)))
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
    if ((!this.OoE) && (!this.pJb.jOn())) {
      this.state = 3;
    }
    AppMethodBeat.o(68060);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68059);
    super.onResume();
    Log.i("MicroMsg.RemittanceBusiUI", "onResume()");
    f.gMD().jt(this);
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    if (!this.OoE) {
      this.state = 2;
    }
    AppMethodBeat.o(68059);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(68071);
    Object localObject1;
    boolean bool;
    label330:
    label375:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramp instanceof com.tencent.mm.plugin.remittance.model.l))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.l)paramp;
      if (!this.mKindaEnable)
      {
        localObject1 = f.gMD();
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "hideProgress()");
        localObject1 = (Context)((f)localObject1).eIW.get();
        if (localObject1 == null) {
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1651;
        }
        if (paramString.OiA.wuz != 0) {
          break label1456;
        }
        this.Opj = paramString;
        this.Onj = paramString.OiA.YGt;
        this.MyF = paramString.OiA.Oln;
        this.Ono = paramString.OiA.YGu;
        this.OoU = paramString.OiA.YXE;
        this.OoV = paramString.OiA.YXD;
        this.OoI = paramString.OiA.YXJ;
        this.OoJ = paramString.OiA.YXI;
        this.OoL = paramString.OiA.YXM;
        this.OoM = paramString.OiA.YXK;
        this.OoN = paramString.OiA.YXL;
        this.OoP = com.tencent.mm.plugin.remittance.model.l.a(paramString.OiA.YXR).toString();
        if (paramString.OiA.YXR != null) {
          this.OoQ = paramString.OiA.YXR.eQp;
        }
        Log.i("MicroMsg.RemittanceBusiUI", "touch_challenge: %s need_change_auth_key: %s mBusiF2FFaultConfig: %s", new Object[] { paramString.OiA.YXN, Integer.valueOf(paramString.OiA.YXO), this.OoP });
        if (paramString.OiA.YXN != null) {
          com.tencent.mm.plugin.fingerprint.mgr.j.Hgj.Hgd = paramString.OiA.YXN.ZV();
        }
        paramp = com.tencent.mm.plugin.fingerprint.mgr.j.Hgj;
        if (paramString.OiA.YXO != 1) {
          break label598;
        }
        bool = true;
        paramp.Hgl = bool;
        if (a(paramString)) {
          break label1449;
        }
        Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog");
        if (paramString.OiA.YXU != null) {
          break label604;
        }
        Log.e("MicroMsg.RemittanceBusiUI", "orderScene.response.check_recv_name_win is null");
        paramInt1 = 0;
        if (paramInt1 == 0)
        {
          if (paramString.OiA.YXS == null) {
            break label1258;
          }
          Log.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_win");
          gMQ();
          if ((f.gMD().getContext() != null) && ((f.gMD().getContext() instanceof RemittanceBusiUI))) {
            this.Opf = paramString.OiA.YXS.YGL;
          }
          paramp = f.gMD();
          localObject2 = paramString.OiA.YXS;
          paramInt1 = this.Ohb;
          localObject3 = new a(paramString) {};
          localObject4 = new a(paramString) {};
          Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAmountRemindWin() amountRemindBit:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramp = (Context)paramp.eIW.get();
          if (paramp != null) {
            break label917;
          }
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
          label525:
          if (f.gMD().getContext() != null)
          {
            if (!(f.gMD().getContext() instanceof RemittanceBusiUI)) {
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
      gMQ();
      localObject2 = paramString.OiA.YXU.title;
      Object localObject6 = paramString.OiA.YXU.wording;
      Object localObject7 = paramString.OiA.YXU.ZjS;
      localObject3 = paramString.OiA.YXU.VXQ.wording;
      localObject4 = paramString.OiA.YXU.VXR.wording;
      paramp = new d(this);
      paramp.Ols = new d.a()
      {
        public final void aTT(final String paramAnonymousString)
        {
          AppMethodBeat.i(289095);
          Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onINputName() name:%s", new Object[] { paramAnonymousString });
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.OAn.b(19229, new Object[] { Integer.valueOf(0), Integer.valueOf(paramString.OiA.YXU.ZjT), Integer.valueOf(0), RemittanceBusiUI.ag(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.model.l.a(RemittanceBusiUI.this, paramString.OiA.YXU.VXR, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dJE()
            {
              AppMethodBeat.i(288958);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:exit");
              RemittanceBusiUI.ah(RemittanceBusiUI.this);
              AppMethodBeat.o(288958);
            }
            
            public final void gLQ()
            {
              AppMethodBeat.i(288964);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:close");
              AppMethodBeat.o(288964);
            }
            
            public final void go(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(288963);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:continue");
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousString, RemittanceBusiUI.41.this.OpH.OiA.YXU.YXz);
              AppMethodBeat.o(288963);
            }
          });
          AppMethodBeat.o(289095);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(289096);
          Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onCancel()");
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.OAn.b(19229, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.OiA.YXU.ZjT), Integer.valueOf(0), RemittanceBusiUI.ag(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.model.l.a(RemittanceBusiUI.this, paramString.OiA.YXU.VXQ, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dJE()
            {
              AppMethodBeat.i(288955);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action:exit");
              RemittanceBusiUI.ah(RemittanceBusiUI.this);
              AppMethodBeat.o(288955);
            }
            
            public final void gLQ()
            {
              AppMethodBeat.i(288960);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：close");
              AppMethodBeat.o(288960);
            }
            
            public final void go(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(288957);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：continue");
              AppMethodBeat.o(288957);
            }
          });
          AppMethodBeat.o(289096);
        }
      };
      Object localObject5 = View.inflate(paramp.mContext, a.g.real_name_check_dialog, null);
      Object localObject8 = (TextView)((View)localObject5).findViewById(a.f.last_name);
      localObject1 = (EditText)((View)localObject5).findViewById(a.f.first_name);
      ((MMNeat7extView)((View)localObject5).findViewById(a.f.content)).aZ((CharSequence)localObject6);
      ((TextView)localObject8).setText((CharSequence)localObject7);
      localObject6 = new e.a(paramp.mContext);
      ((e.a)localObject6).bDv((String)localObject2).md((View)localObject5);
      com.tencent.mm.ui.tools.b.c.i((EditText)localObject1).b(g.a.afIH).oF(1, 1).Nc(false).a(null);
      MMHandlerThread.postToMainThreadDelayed(new d.10(paramp, (EditText)localObject1), 200L);
      ((e.a)localObject6).bDC((String)localObject4).aET(-2141754475).a(false, new d.11(paramp, (EditText)localObject1));
      ((e.a)localObject6).bDD((String)localObject3).d(new d.2(paramp));
      localObject2 = ((e.a)localObject6).jHH();
      ((com.tencent.mm.ui.widget.a.e)localObject2).show();
      ((EditText)localObject1).addTextChangedListener(new d.3(paramp, (EditText)localObject1, (com.tencent.mm.ui.widget.a.e)localObject2));
      paramInt1 = 1;
      break label375;
      label917:
      if (localObject2 == null)
      {
        Log.i("MicroMsg.JumpItemUtil", "showAmountRemindWin() amountRemindWin == null");
        break label525;
      }
      localObject1 = LayoutInflater.from(paramp).inflate(a.g.large_money_dialog, null, false);
      localObject5 = ((View)localObject1).findViewById(a.f.f2f_money_container);
      localObject6 = (WalletTextView)((View)localObject1).findViewById(a.f.f2f_money_amount_tv);
      localObject7 = ((View)localObject1).findViewById(a.f.wallet_max_unit_layout);
      localObject8 = ((View)localObject1).findViewById(a.f.wallet_max_unit_container);
      double d = ((eu)localObject2).YGL / 100.0D;
      ((WalletTextView)localObject6).setText(i.formatMoney2f(d));
      if (Util.isEqual(paramInt1, 0))
      {
        Log.i("MicroMsg.JumpItemUtil", "mAmountRemindBit == 0");
        ((View)localObject8).setVisibility(8);
      }
      for (;;)
      {
        localObject5 = ((eu)localObject2).wording;
        localObject6 = ((eu)localObject2).VXR.wording;
        localObject7 = ((eu)localObject2).VXQ.wording;
        localObject4 = new l.8(paramp, (eu)localObject2, d, (com.tencent.mm.wallet_core.model.l.a)localObject4);
        localObject2 = new l.9(paramp, (eu)localObject2, d, (com.tencent.mm.wallet_core.model.l.a)localObject3);
        localObject3 = new e.a(paramp);
        ((e.a)localObject3).bDv((String)localObject5);
        ((e.a)localObject3).md((View)localObject1);
        ((e.a)localObject3).bDC((String)localObject6).c((DialogInterface.OnClickListener)localObject4);
        ((e.a)localObject3).bDD((String)localObject7).d((DialogInterface.OnClickListener)localObject2);
        ((e.a)localObject3).NC(false);
        ((e.a)localObject3).ND(true);
        localObject1 = ((e.a)localObject3).jHH();
        ((com.tencent.mm.ui.widget.a.e)localObject1).show();
        com.tencent.mm.ui.base.k.a(paramp, (Dialog)localObject1);
        break;
        TextView localTextView = (TextView)((View)localObject1).findViewById(a.f.wallet_max_unit_tv);
        ((View)localObject8).setVisibility(0);
        ((View)localObject8).post(new l.7((View)localObject7, d, paramInt1, (WalletTextView)localObject6, (View)localObject5, (View)localObject8, localTextView));
      }
      label1236:
      if (!(f.gMD().getContext() instanceof RemittanceF2fLargeMoneyUI)) {
        break label552;
      }
      a(9, paramString);
      break label552;
      label1258:
      if (paramString.OiA.YXT != null)
      {
        Log.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_page");
        gMQ();
        paramp = new Intent();
        paramp.putExtra("key_amount_remind_bit", this.Ohb);
        paramp.putExtra("key_title", paramString.OiA.YXT.title);
        paramp.putExtra("key_desc", paramString.OiA.YXT.wording);
        paramp.putExtra("key_amount_remind_sign", paramString.OiA.YXT.OiR);
        paramp.putExtra("key_qr_code", this.Oot);
        Log.i("MicroMsg.RemittanceBusiUI", "open large moneny UI mQrcodeId:%s", new Object[] { this.Oot });
        com.tencent.mm.br.c.b(this, "wallet_payu", ".pay.ui.WalletPayUOrderInfoUI", paramp, 4);
        a(6, paramString);
        break label552;
      }
      if ((f.gMD().getContext() != null) && ((f.gMD().getContext() instanceof RemittanceF2fLargeMoneyUI))) {
        a(8, paramString);
      }
      paramInt1 = 0;
      break label554;
      label1449:
      gMQ();
      continue;
      label1456:
      gMQ();
      Log.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.OiA.wuz), paramString.OiA.wuA });
      if ((paramString.OiA.YXC != null) && (!Util.isNullOrNil(paramString.OiA.YXC.rGU))) {
        a(paramString);
      }
      for (;;)
      {
        if (paramString.OiA.YXF != 1) {
          break label1649;
        }
        a(null, null, 0);
        break;
        localObject2 = f.gMD();
        localObject1 = paramString.OiA.wuA;
        paramp = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(163825);
            if (Util.isEqual(((com.tencent.mm.plugin.remittance.model.l)paramp).OiA.YXQ, 1))
            {
              if (f.gMD().gME()) {
                Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
              }
              RemittanceBusiUI.this.finish();
            }
            AppMethodBeat.o(163825);
          }
        };
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", new Object[] { Util.nullAsNil((String)localObject1), Util.nullAsNil("") });
        localObject2 = (Context)((f)localObject2).eIW.get();
        if (localObject2 == null) {
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        } else {
          com.tencent.mm.ui.base.k.d((Context)localObject2, (String)localObject1, "", paramp);
        }
      }
      label1649:
      continue;
      label1651:
      Log.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[] { paramp });
      continue;
      if ((paramp instanceof com.tencent.mm.plugin.remittance.model.k))
      {
        Log.i("MicroMsg.RemittanceBusiUI", "pay check callback");
        AppMethodBeat.o(68071);
        return true;
      }
      if ((paramp instanceof com.tencent.mm.plugin.remittance.model.j))
      {
        Log.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[] { paramp, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.remittance.model.j)paramp;
        if ((!paramString.Ois.equals(this.OoY.Ois)) || (paramString.cancel))
        {
          paramString.Oir = true;
          Log.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.cancel) });
          AppMethodBeat.o(68071);
          return true;
        }
        this.OoT.Ola = false;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramString.Oio.wuz == 0)
          {
            this.OoS.Olh = paramString.Oio.OhT;
            this.OoS.aUa(paramString.Oio.OhT.YXi);
            this.OoT.a(paramString.Oio.Oia);
            gMM();
            paramp = paramString.Oip;
            Log.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramp });
            if (paramp != null) {
              paramp.jZ(this.OoS.gMo());
            }
          }
        }
        for (;;)
        {
          paramString.Oir = true;
          AppMethodBeat.o(68071);
          return true;
          aUd(paramString.Oio.wuA);
          paramp = paramString.Oiq;
          if (paramp != null)
          {
            paramp.a(paramInt1, paramInt2, paramString);
            continue;
            aUd(getString(a.i.remittance_busi_favor_get_error_default));
            paramp = paramString.Oiq;
            if (paramp != null) {
              paramp.a(paramInt1, paramInt2, paramString);
            }
          }
        }
      }
      if ((paramp instanceof o))
      {
        paramString = (o)paramp;
        Log.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[] { Boolean.valueOf(paramString.hasRetried) });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramString.OiZ.wuz == 0)
          {
            gMS();
          }
          else
          {
            gMR();
            f.gMD().a(paramString.OiZ.wuA, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
        }
        else {
          f.gMD().a(getString(a.i.wallet_unknown_err), new DialogInterface.OnClickListener()
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(289345);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(al.class);
    AppMethodBeat.o(289345);
  }
  
  public abstract class a<InputType>
    implements com.tencent.mm.wallet_core.model.l.a<InputType>
  {
    public a() {}
    
    public final void dJE()
    {
      Object localObject = new Intent();
      ((Intent)localObject).setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
      ((Intent)localObject).addFlags(67108864);
      RemittanceBusiUI localRemittanceBusiUI = RemittanceBusiUI.this;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localRemittanceBusiUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localRemittanceBusiUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localRemittanceBusiUI, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    
    public void gLQ() {}
    
    public final int gLR()
    {
      return 1072;
    }
    
    public void gLT() {}
  }
  
  final class b
  {
    private float OpO;
    private float OpP;
    private TenpaySecureEditText OpQ;
    private TextView OpR;
    private RelativeLayout OpS;
    private View doN;
    private float marginTop;
    
    b(int paramInt1, int paramInt2, float paramFloat)
    {
      AppMethodBeat.i(68053);
      this.OpO = paramInt1;
      this.OpP = paramInt2;
      this.marginTop = paramFloat;
      AppMethodBeat.o(68053);
    }
    
    final void update()
    {
      AppMethodBeat.i(68054);
      RemittanceBusiUI.a(RemittanceBusiUI.this).setTextSize(1, this.OpP);
      RemittanceBusiUI.b(RemittanceBusiUI.this).setTextSize(1, this.OpO);
      if (this.OpR == null) {
        this.OpR = ((TextView)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(a.f.wallet_title));
      }
      if (this.OpR != null) {
        this.OpR.setTextSize(this.OpO);
      }
      if (this.OpQ == null) {
        this.OpQ = ((TenpaySecureEditText)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(a.f.wallet_content));
      }
      if (this.OpQ != null) {
        this.OpQ.setTextSize(this.OpP);
      }
      if (this.doN == null) {
        this.doN = this.OpQ.findViewById(a.f.money_et_layout);
      }
      if (this.doN != null) {
        this.doN.setMinimumHeight(BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, RemittanceBusiUI.d(RemittanceBusiUI.this).OpP));
      }
      if (this.OpS == null) {
        this.OpS = ((RelativeLayout)RemittanceBusiUI.this.findViewById(a.f.wallet_max_unit_line_container));
      }
      if (this.OpS != null) {
        ((LinearLayout.LayoutParams)this.OpS.getLayoutParams()).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, this.marginTop);
      }
      AppMethodBeat.o(68054);
    }
  }
  
  final class c
    implements Runnable
  {
    public com.tencent.mm.wallet_core.c.d OpT;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(68055);
      RemittanceBusiUI.Y(RemittanceBusiUI.this).b(this.OpT);
      AppMethodBeat.o(68055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */