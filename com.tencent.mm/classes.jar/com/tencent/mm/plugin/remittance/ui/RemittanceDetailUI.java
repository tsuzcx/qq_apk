package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.remittance.model.y.a;
import com.tencent.mm.plugin.remittance.model.y.b;
import com.tencent.mm.plugin.remittance.model.y.d;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class RemittanceDetailUI
  extends WalletBaseUI
{
  private int mUE;
  private int mUF;
  private com.tencent.mm.ui.widget.b.a mVN;
  private n.d peM;
  private View.OnTouchListener qhG;
  private View.OnLongClickListener qhH;
  protected TextView tkx;
  private String uoE;
  private String uoL;
  private LinearLayout vCJ;
  private String vCU;
  private int vCV;
  protected String vDb;
  protected ViewGroup vGA;
  protected ImageView vGB;
  protected TextView vGC;
  protected TextView vGD;
  protected ImageView vGE;
  protected Button vGF;
  protected TextView vGG;
  protected TextView vGH;
  protected View vGI;
  protected View vGJ;
  protected View vGK;
  protected Button vGL;
  protected TextView vGM;
  protected LinearLayout vGN;
  private LinearLayout vGO;
  private LinearLayout vGP;
  private LinearLayout vGQ;
  private LinearLayout vGR;
  private TextView vGS;
  private TextView vGT;
  private TextView vGU;
  private TextView vGV;
  private TextView vGW;
  protected int vGX;
  protected int vGY;
  public String vGZ;
  protected TextView vGm;
  protected TextView vGn;
  protected TextView vGo;
  protected TextView vGp;
  protected Button vGq;
  protected LinearLayout vGr;
  private LinearLayout vGs;
  private LinearLayout vGt;
  private LinearLayout vGu;
  private TextView vGv;
  private TextView vGw;
  private TextView vGx;
  private TextView vGy;
  private TextView vGz;
  public String vHa;
  protected String vHb;
  protected int vHc;
  protected boolean vHd;
  protected int vHe;
  private int vHf;
  private v vHg;
  private com.tencent.mm.sdk.b.c<qa> vHh;
  private com.tencent.mm.sdk.b.c<pz> vHi;
  private int vHj;
  protected ImageView vyw;
  
  public RemittanceDetailUI()
  {
    AppMethodBeat.i(68156);
    this.vyw = null;
    this.vGm = null;
    this.vGn = null;
    this.vGo = null;
    this.vGp = null;
    this.vGq = null;
    this.tkx = null;
    this.vGL = null;
    this.vGM = null;
    this.vGZ = null;
    this.vHa = null;
    this.vDb = null;
    this.vHb = null;
    this.vCU = null;
    this.vHc = 3;
    this.vHd = false;
    this.vHh = new RemittanceDetailUI.1(this);
    this.vHi = new RemittanceDetailUI.12(this);
    this.mVN = null;
    this.vHj = 0;
    this.peM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(68135);
        ClipboardManager localClipboardManager = (ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
        paramAnonymousMenuItem = "";
        if (bt.iY(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131304016)) {
          paramAnonymousMenuItem = RemittanceDetailUI.o(RemittanceDetailUI.this).getText().toString().trim();
        }
        do
        {
          for (;;)
          {
            localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
            com.tencent.mm.ui.base.h.cf(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131755702));
            AppMethodBeat.o(68135);
            return;
            if (bt.iY(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131303989))
            {
              paramAnonymousMenuItem = new StringBuilder();
              paramAnonymousMenuItem.append(RemittanceDetailUI.p(RemittanceDetailUI.this).getText().toString().trim() + " ");
              str = RemittanceDetailUI.l(RemittanceDetailUI.this).getText().toString().trim();
              if (str.endsWith(RemittanceDetailUI.this.getString(2131762446))) {
                paramAnonymousMenuItem.append(str.substring(0, str.length() - 4));
              }
              for (;;)
              {
                paramAnonymousMenuItem = paramAnonymousMenuItem.toString();
                break;
                paramAnonymousMenuItem.append(str);
              }
            }
            if (!bt.iY(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131304015)) {
              break;
            }
            paramAnonymousMenuItem = RemittanceDetailUI.q(RemittanceDetailUI.this).getText().toString().trim();
          }
        } while (!bt.iY(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131303990));
        paramAnonymousMenuItem = new StringBuilder();
        paramAnonymousMenuItem.append(RemittanceDetailUI.r(RemittanceDetailUI.this).getText().toString().trim() + " ");
        String str = RemittanceDetailUI.f(RemittanceDetailUI.this).getText().toString().trim();
        if (str.endsWith(RemittanceDetailUI.this.getString(2131762446))) {
          paramAnonymousMenuItem.append(str.substring(0, str.length() - 4));
        }
        for (;;)
        {
          paramAnonymousMenuItem = paramAnonymousMenuItem.toString();
          break;
          paramAnonymousMenuItem.append(str);
        }
      }
    };
    this.qhG = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68138);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(68138);
          return false;
          RemittanceDetailUI.a(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawX());
          RemittanceDetailUI.b(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.qhH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68139);
        ad.d("MicroMsg.RemittanceDetailUI", "onLongClick");
        if (RemittanceDetailUI.s(RemittanceDetailUI.this) == null) {
          RemittanceDetailUI.a(RemittanceDetailUI.this, new com.tencent.mm.ui.widget.b.a(RemittanceDetailUI.this.getContext()));
        }
        RemittanceDetailUI.s(RemittanceDetailUI.this).a(paramAnonymousView, RemittanceDetailUI.this, RemittanceDetailUI.t(RemittanceDetailUI.this), RemittanceDetailUI.u(RemittanceDetailUI.this), RemittanceDetailUI.v(RemittanceDetailUI.this));
        RemittanceDetailUI.c(RemittanceDetailUI.this, paramAnonymousView.getId());
        AppMethodBeat.o(68139);
        return true;
      }
    };
    AppMethodBeat.o(68156);
  }
  
  private void a(v paramv)
  {
    AppMethodBeat.i(68171);
    if ("confirm".equals(paramv.vAA))
    {
      KE(1);
      AppMethodBeat.o(68171);
      return;
    }
    bB(0, getResources().getString(2131762456));
    AppMethodBeat.o(68171);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, final y paramy)
  {
    AppMethodBeat.i(68166);
    if (paramBoolean1)
    {
      this.vGr.setVisibility(8);
      this.vGN.setVisibility(0);
      if (!bt.isNullOrNil(paramy.vBE.vBL))
      {
        this.vGO.setVisibility(0);
        if (!bt.isNullOrNil(paramy.desc))
        {
          this.vGP.setVisibility(0);
          this.vGT.setText(paramy.desc);
          this.vGT.setOnLongClickListener(this.qhH);
          this.vGT.setOnTouchListener(this.qhG);
          if (bt.isNullOrNil(paramy.vBE.vBL)) {
            break label449;
          }
          this.vGQ.setVisibility(0);
          this.vGU.setText(paramy.vBE.vBL + "  " + paramy.vBE.ioa);
          this.vGS.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68155);
              int i = RemittanceResultNewUI.n(RemittanceDetailUI.this, paramy.vBE.hdQ, RemittanceDetailUI.d(RemittanceDetailUI.this).getWidth());
              if (!bt.iY(i, paramy.vBE.hdQ.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131762447);
                String str2 = paramy.vBE.hdQ.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.uqW = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(68153);
                    RemittanceDetailUI.e(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.f(RemittanceDetailUI.this).setVisibility(0);
                    p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131304251), RemittanceDetailUI.this.findViewById(2131303141), RemittanceDetailUI.this.findViewById(2131304020), RemittanceDetailUI.this.findViewById(2131304030), 72);
                    AppMethodBeat.o(68153);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.e(RemittanceDetailUI.this).setOnTouchListener(a.djP());
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131762446);
                str2 = paramy.vBE.hdQ + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.uqW = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(68154);
                    RemittanceDetailUI.e(RemittanceDetailUI.this).setVisibility(0);
                    RemittanceDetailUI.f(RemittanceDetailUI.this).setVisibility(8);
                    p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131304251), RemittanceDetailUI.this.findViewById(2131303141), RemittanceDetailUI.this.findViewById(2131304020), RemittanceDetailUI.this.findViewById(2131304030), 72);
                    AppMethodBeat.o(68154);
                  }
                };
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setOnTouchListener(a.djP());
                RemittanceDetailUI.f(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.e(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.h(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.g(RemittanceDetailUI.this));
                RemittanceDetailUI.h(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.i(RemittanceDetailUI.this));
                AppMethodBeat.o(68155);
                return;
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(paramy.vBE.hdQ);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setText(paramy.vBE.hdQ);
              }
            }
          });
          label180:
          if ((!paramBoolean2) || (bt.isNullOrNil(paramy.vBF.dub))) {
            break label770;
          }
          this.vGr.setVisibility(0);
          this.vGs.setVisibility(0);
          this.vGK.setVisibility(0);
          this.vGA.setVisibility(0);
          this.vGI.setVisibility(0);
          com.tencent.mm.aw.a.a.ayO().loadImage(paramy.vBF.dub, this.vGB);
          this.vGC.setText(paramy.vBF.name);
          this.vGD.setText(paramy.vBF.doh);
          if (paramy.vBF.vBM <= 0) {
            break label718;
          }
          this.vGF.setText(paramy.vBF.vBN);
          this.vGE.setVisibility(8);
          this.vGF.setVisibility(0);
          this.vGF.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68126);
              RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.vBF.vBO, paramy, 11);
              AppMethodBeat.o(68126);
            }
          });
          com.tencent.mm.wallet_core.ui.e.aS(this.vGF, 200);
          label349:
          if (!bt.isNullOrNil(paramy.vBG.doh)) {
            break label800;
          }
          this.vGG.setVisibility(8);
          label371:
          if (!bt.isNullOrNil(paramy.vBI.doh)) {
            break label841;
          }
          this.vGH.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      p.a(this, (ScrollView)findViewById(2131304251), findViewById(2131303141), findViewById(2131304020), findViewById(2131304030), 72);
      AppMethodBeat.o(68166);
      return;
      this.vGP.setVisibility(8);
      break;
      label449:
      this.vGQ.setVisibility(8);
      break label180;
      this.vGO.setVisibility(8);
      break label180;
      this.vGr.setVisibility(0);
      this.vGN.setVisibility(8);
      if (!bt.isNullOrNil(paramy.vBE.vBL))
      {
        this.vGs.setVisibility(0);
        if (!bt.isNullOrNil(paramy.desc))
        {
          this.vGt.setVisibility(0);
          this.vGw.setText(paramy.desc);
          this.vGw.setOnLongClickListener(this.qhH);
          this.vGw.setOnTouchListener(this.qhG);
        }
        for (;;)
        {
          if (bt.isNullOrNil(paramy.vBE.vBL)) {
            break label658;
          }
          this.vCJ.setVisibility(0);
          this.vGx.setText(paramy.vBE.vBL + "  " + paramy.vBE.ioa);
          this.vGv.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68125);
              int i = RemittanceResultNewUI.n(RemittanceDetailUI.this, paramy.vBE.hdQ, RemittanceDetailUI.j(RemittanceDetailUI.this).getWidth());
              if (!bt.iY(i, paramy.vBE.hdQ.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131762447);
                String str2 = paramy.vBE.hdQ.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.uqW = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(68123);
                    RemittanceDetailUI.k(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.l(RemittanceDetailUI.this).setVisibility(0);
                    p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131304251), RemittanceDetailUI.this.findViewById(2131303141), RemittanceDetailUI.this.findViewById(2131304020), RemittanceDetailUI.this.findViewById(2131304030), 72);
                    AppMethodBeat.o(68123);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.k(RemittanceDetailUI.this).setOnTouchListener(a.djP());
                RemittanceDetailUI.k(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131762446);
                str2 = paramy.vBE.hdQ + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.uqW = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(68124);
                    RemittanceDetailUI.k(RemittanceDetailUI.this).setVisibility(0);
                    RemittanceDetailUI.l(RemittanceDetailUI.this).setVisibility(8);
                    p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131304251), RemittanceDetailUI.this.findViewById(2131303141), RemittanceDetailUI.this.findViewById(2131304020), RemittanceDetailUI.this.findViewById(2131304030), 72);
                    AppMethodBeat.o(68124);
                  }
                };
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.l(RemittanceDetailUI.this).setOnTouchListener(a.djP());
                RemittanceDetailUI.l(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.k(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.l(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.m(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.g(RemittanceDetailUI.this));
                RemittanceDetailUI.m(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.i(RemittanceDetailUI.this));
                AppMethodBeat.o(68125);
                return;
                RemittanceDetailUI.k(RemittanceDetailUI.this).setText(paramy.vBE.hdQ);
                RemittanceDetailUI.l(RemittanceDetailUI.this).setText(paramy.vBE.hdQ);
              }
            }
          });
          break;
          this.vGt.setVisibility(8);
        }
        label658:
        this.vCJ.setVisibility(8);
        break label180;
      }
      this.vGJ.setVisibility(8);
      this.vGt.setVisibility(8);
      this.vCJ.setVisibility(8);
      this.vGK.setVisibility(8);
      this.vGs.setVisibility(8);
      break label180;
      label718:
      this.vGE.setVisibility(0);
      this.vGF.setVisibility(8);
      this.vGE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68127);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.vBF.vBO, paramy, 11);
          AppMethodBeat.o(68127);
        }
      });
      this.vGA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68128);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.vBF.vBO, paramy, 11);
          AppMethodBeat.o(68128);
        }
      });
      break label349;
      label770:
      this.vGK.setVisibility(8);
      this.vGA.setVisibility(8);
      this.vGI.setVisibility(8);
      break label349;
      label800:
      this.vGG.setText(paramy.vBG.doh);
      this.vGG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68129);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.vBG.vBO, paramy, 12);
          AppMethodBeat.o(68129);
        }
      });
      this.vGG.setVisibility(0);
      break label371;
      label841:
      this.vGH.setText(paramy.vBI.doh);
      this.vGH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68130);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.vBI.vBO, paramy, 13);
          AppMethodBeat.o(68130);
        }
      });
      this.vGH.setVisibility(0);
    }
  }
  
  private void b(Dialog paramDialog)
  {
    AppMethodBeat.i(68167);
    if (paramDialog != null) {
      paramDialog.dismiss();
    }
    paramDialog = new Intent(this, WalletLqtDetailUI.class);
    paramDialog.putExtra("key_account_type", 0);
    startActivityForResult(paramDialog, 2);
    AppMethodBeat.o(68167);
  }
  
  public static String bq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68174);
    String str = com.tencent.mm.wallet_core.ui.e.sh(paramString);
    if (str == null)
    {
      AppMethodBeat.o(68174);
      return "";
    }
    paramString = str;
    if (str.length() > 10)
    {
      paramString = str;
      if (paramBoolean) {
        paramString = str.substring(0, 8) + "...";
      }
    }
    AppMethodBeat.o(68174);
    return paramString;
  }
  
  private void djZ()
  {
    AppMethodBeat.i(68169);
    if ((this.vHf != 0) && (this.vCV == 1) && (!bt.isNullOrNil(this.vCU)))
    {
      addIconOptionMenu(0, 2131234701, new RemittanceDetailUI.15(this));
      AppMethodBeat.o(68169);
      return;
    }
    ad.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[] { Integer.valueOf(this.vHf), Boolean.valueOf(bt.isNullOrNil(this.vCU)) });
    removeAllOptionMenu();
    AppMethodBeat.o(68169);
  }
  
  protected void KE(int paramInt)
  {
    AppMethodBeat.i(68160);
    doSceneProgress(new y(paramInt, this.vGZ, this.vDb, this.vGX), true);
    AppMethodBeat.o(68160);
  }
  
  protected void KF(int paramInt)
  {
    AppMethodBeat.i(68162);
    if (!getIntent().getBooleanExtra("is_sender", false)) {}
    for (com.tencent.mm.plugin.order.model.h localh = new com.tencent.mm.plugin.order.model.h(this.vDb, this.vHb, paramInt);; localh = new com.tencent.mm.plugin.order.model.h(this.vGZ, this.vHb, paramInt))
    {
      localh.setProcessName("RemittanceProcess");
      doSceneProgress(localh);
      AppMethodBeat.o(68162);
      return;
    }
  }
  
  protected void aB(Intent paramIntent)
  {
    AppMethodBeat.i(68163);
    com.tencent.mm.bs.d.b(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(68163);
  }
  
  protected final void bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(68172);
    Intent localIntent = new Intent();
    localIntent.putExtra("result_msg", paramString);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(68172);
  }
  
  protected void dku()
  {
    AppMethodBeat.i(68164);
    v localv = new v(this.vGZ, this.vDb, this.vHe, "confirm", this.vHa, this.vGX);
    localv.setProcessName("RemittanceProcess");
    doSceneProgress(localv);
    AppMethodBeat.o(68164);
  }
  
  protected void dkv()
  {
    AppMethodBeat.i(68165);
    v localv = new v(this.vGZ, this.vDb, this.vHe, "refuse", this.vHa, this.vGX);
    localv.setProcessName("RemittanceProcess");
    doSceneProgress(localv);
    AppMethodBeat.o(68165);
  }
  
  public void finish()
  {
    AppMethodBeat.i(68173);
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_plugin", "remittance");
    localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
    if ((this.vHg != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.vHg, localBundle, true, 1008)))
    {
      this.vHg = null;
      AppMethodBeat.o(68173);
      return;
    }
    super.finish();
    AppMethodBeat.o(68173);
  }
  
  public int getLayoutId()
  {
    return 2131495253;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68161);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.vyw = ((ImageView)findViewById(2131304024));
    this.vGm = ((TextView)findViewById(2131304029));
    this.vGn = ((TextView)findViewById(2131304025));
    this.vGq = ((Button)findViewById(2131304021));
    this.tkx = ((TextView)findViewById(2131304026));
    this.vGr = ((LinearLayout)findViewById(2131304023));
    this.vGs = ((LinearLayout)findViewById(2131304043));
    this.vGt = ((LinearLayout)findViewById(2131304014));
    this.vCJ = ((LinearLayout)findViewById(2131303987));
    this.vGu = ((LinearLayout)findViewById(2131303989));
    this.vGv = ((TextView)findViewById(2131304019));
    this.vGw = ((TextView)findViewById(2131304016));
    this.vGx = ((TextView)findViewById(2131302665));
    this.vGy = ((TextView)findViewById(2131296478));
    this.vGz = ((TextView)findViewById(2131296477));
    this.vGA = ((ViewGroup)findViewById(2131304054));
    this.vGB = ((ImageView)findViewById(2131304056));
    this.vGC = ((TextView)findViewById(2131304058));
    this.vGD = ((TextView)findViewById(2131304059));
    this.vGE = ((ImageView)findViewById(2131304053));
    this.vGF = ((Button)findViewById(2131302852));
    this.vGG = ((TextView)findViewById(2131304011));
    this.vGH = ((TextView)findViewById(2131304052));
    this.vGI = findViewById(2131304057);
    this.vGJ = findViewById(2131304044);
    this.vGK = findViewById(2131304045);
    this.vGL = ((Button)findViewById(2131304022));
    this.vGM = ((TextView)findViewById(2131304027));
    this.vGN = ((LinearLayout)findViewById(2131304028));
    this.vGO = ((LinearLayout)findViewById(2131304046));
    this.vGP = ((LinearLayout)findViewById(2131304017));
    this.vGQ = ((LinearLayout)findViewById(2131303991));
    this.vGR = ((LinearLayout)findViewById(2131303990));
    this.vGS = ((TextView)findViewById(2131304018));
    this.vGT = ((TextView)findViewById(2131304015));
    this.vGU = ((TextView)findViewById(2131302664));
    this.vGV = ((TextView)findViewById(2131296475));
    this.vGW = ((TextView)findViewById(2131296476));
    this.vGo = ((TextView)findViewById(2131304031));
    this.vGp = ((TextView)findViewById(2131304032));
    AppMethodBeat.o(68161);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68159);
    ad.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      KE(0);
    }
    AppMethodBeat.o(68159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68157);
    super.onCreate(paramBundle);
    this.vGX = getIntent().getIntExtra("invalid_time", 0);
    this.vGY = getIntent().getIntExtra("appmsg_type", 0);
    this.vGZ = getIntent().getStringExtra("transaction_id");
    this.vHb = getIntent().getStringExtra("bill_id");
    this.vDb = getIntent().getStringExtra("transfer_id");
    this.vHa = getIntent().getStringExtra("sender_name");
    this.vHc = getIntent().getIntExtra("effective_date", 3);
    this.vHd = getIntent().getBooleanExtra("is_sender", false);
    this.vHe = getIntent().getIntExtra("total_fee", 0);
    initView();
    KE(0);
    getIntent();
    com.tencent.mm.sdk.b.a.ESL.c(this.vHh);
    this.vHi.alive();
    AppMethodBeat.o(68157);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(68168);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131755701));
    AppMethodBeat.o(68168);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68158);
    com.tencent.mm.sdk.b.a.ESL.d(this.vHh);
    if (this.vHi != null) {
      this.vHi.dead();
    }
    super.onDestroy();
    AppMethodBeat.o(68158);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(68170);
    final boolean bool;
    if ((paramn instanceof y))
    {
      final y localy = (y)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject;
        if (localy != null)
        {
          if (localy.swU)
          {
            this.uoL = com.tencent.mm.model.u.aqG();
            this.uoE = this.vHa;
            bool = com.tencent.mm.model.u.aqG().equals(this.uoE);
            this.vGq.setVisibility(8);
            this.vGn.setText(com.tencent.mm.wallet_core.ui.e.d(localy.nUf, localy.uop));
            paramn = localy.vBB;
            paramString = paramn;
            if (!bt.isNullOrNil(paramn))
            {
              paramString = paramn;
              if (paramn.contains("%s")) {
                paramString = paramn.trim().replace("%s", bq(this.uoE, true));
              }
            }
            paramn = localy.vBC;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.vGZ);
            ((Bundle)localObject).putString("receiver_name", this.uoE);
            ((Bundle)localObject).putString("transfer_id", this.vDb);
            ((Bundle)localObject).putInt("total_fee", this.vHe);
            ((Bundle)localObject).putString("sender_name", this.vHa);
            ((Bundle)localObject).putInt("invalid_time", this.vGX);
            ((Bundle)localObject).putParcelable("resend_msg_info", localy.vBH);
            this.tkx.setClickable(true);
            this.vGm.setClickable(true);
            this.vGM.setClickable(true);
            paramInt1 = localy.status;
            ad.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        else {
          switch (paramInt1)
          {
          default: 
            finish();
            label344:
            if (!bt.isNullOrNil(localy.vBJ)) {
              com.tencent.mm.wallet_core.ui.e.a((TextView)findViewById(2131297186), "7", localy.vBJ, localy.vBK);
            }
            this.vHf = localy.vBD;
            com.tencent.mm.kernel.g.afC();
            this.vCU = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnj, ""));
            com.tencent.mm.kernel.g.afC();
            this.vCV = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnk, Integer.valueOf(0))).intValue();
            if (bt.isNullOrNil(this.vCU))
            {
              com.tencent.mm.plugin.wallet_core.c.aj.a(true, this.mNetSceneMgr);
              label465:
              djZ();
              if (localy.uoX == 1)
              {
                com.tencent.mm.kernel.g.afC();
                if (!((String)com.tencent.mm.kernel.g.afB().afk().get(327729, "0")).equals("0")) {
                  break label3325;
                }
                paramString = getContext();
                if (!com.tencent.mm.model.u.aqV()) {
                  break label3318;
                }
                paramInt1 = 2131757192;
                label524:
                com.tencent.mm.ui.base.h.a(paramString, paramInt1, 2131765801, new RemittanceDetailUI.16(this));
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.kernel.g.afB().afk().set(327729, "1");
              }
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          this.uoL = this.vHa;
          this.uoE = com.tencent.mm.model.u.aqG();
          break;
          if (!bool) {
            if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
            {
              this.vGm.setText(k.a(this, paramString, (int)this.vGm.getTextSize(), localObject));
              this.tkx.setText(k.a(this, paramn, (int)this.tkx.getTextSize(), localObject));
              this.vGm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.tkx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label679:
              a(false, false, localy);
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.vyw.setImageDrawable(am.i(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBx) }));
            this.vGo.setVisibility(0);
            this.vGp.setVisibility(8);
            break;
            paramString = getString(2131762474, new Object[] { bq(this.uoE, true) });
            this.vGm.setText(k.b(this, paramString, this.vGm.getTextSize()));
            paramString = getString(2131762480, new Object[] { Integer.valueOf(this.vHc) });
            paramn = getString(2131762516);
            localObject = new SpannableString(paramString + paramn);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.uqW = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68145);
                new d(RemittanceDetailUI.this).a(localy.vBH, new f.c()
                {
                  public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(68144);
                    if (paramAnonymous2Boolean)
                    {
                      paramAnonymous2String = new Intent();
                      paramAnonymous2String.putExtra("transaction_id", RemittanceDetailUI.this.vGZ);
                      paramAnonymous2String.putExtra("transfer_id", RemittanceDetailUI.this.vDb);
                      paramAnonymous2String.putExtra("receiver_name", RemittanceDetailUI.b(RemittanceDetailUI.this));
                      paramAnonymous2String.putExtra("resend_msg_from_flag", 3);
                      RemittanceDetailUI.this.aB(paramAnonymous2String);
                    }
                    AppMethodBeat.o(68144);
                  }
                });
                AppMethodBeat.o(68145);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramn.length(), 33);
            this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
            this.tkx.setText((CharSequence)localObject);
            break label679;
            this.vyw.setImageDrawable(am.i(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            this.vGL.setVisibility(0);
            this.vGL.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68147);
                ((b)com.tencent.mm.kernel.g.ab(b.class)).gf(9, 4);
                s.ebW();
                paramAnonymousView = RemittanceDetailUI.this;
                i locali = RemittanceDetailUI.c(RemittanceDetailUI.this);
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a()
                {
                  public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(68146);
                    if (paramAnonymous2Int1 == 2)
                    {
                      RemittanceDetailUI.this.dku();
                      AppMethodBeat.o(68146);
                      return true;
                    }
                    if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean)) {
                      RemittanceDetailUI.this.dku();
                    }
                    AppMethodBeat.o(68146);
                    return true;
                  }
                };
                if (!s.a(paramAnonymousView, locali)) {
                  RemittanceDetailUI.this.dku();
                }
                AppMethodBeat.o(68147);
              }
            });
            if ((bt.isNullOrNil(paramString)) || (bt.isNullOrNil(paramn))) {
              break label1089;
            }
            this.vGm.setText(k.a(this, paramString, (int)this.vGm.getTextSize(), localObject));
            this.vGM.setText(k.a(this, paramn, (int)this.vGM.getTextSize(), localObject));
            this.vGm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.vGM.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            a(true, false, localy);
          }
          label1089:
          this.vGm.setText(2131762473);
          if (localy.vBD != 0) {
            if (!bt.isNullOrNil(localy.vBC)) {
              paramString = localy.vBC;
            }
          }
          for (;;)
          {
            paramn = getString(2131762465);
            localObject = new SpannableString(paramString + paramn);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.uqW = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68149);
                com.tencent.mm.ui.base.h.d(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131762461, new Object[] { RemittanceDetailUI.bq(localy.vBz, false) }), RemittanceDetailUI.this.getString(2131755873), RemittanceDetailUI.this.getString(2131762466), RemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(68148);
                    RemittanceDetailUI.this.dkv();
                    AppMethodBeat.o(68148);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(68149);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramn.length(), 33);
            this.vGM.setMovementMethod(LinkMovementMethod.getInstance());
            this.vGM.setText((CharSequence)localObject);
            break;
            ad.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localy.vBD == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(2131762475, new Object[] { paramString });
              paramn = getString(2131762476, new Object[] { Integer.valueOf(this.vHc) });
              paramString = paramString + paramn;
              break;
            }
            paramString = getString(2131762476, new Object[] { Integer.valueOf(this.vHc) });
          }
          this.vyw.setImageDrawable(am.i(getContext(), 2131690392, getContext().getResources().getColor(2131099699)));
          if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
          {
            this.vGm.setText(k.a(this, paramString, (int)this.vGm.getTextSize(), localObject));
            this.tkx.setText(k.a(this, paramn, (int)this.tkx.getTextSize(), localObject));
            this.vGm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.tkx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            label1465:
            if (!bool) {
              break label1722;
            }
            a(false, true, localy);
          }
          for (;;)
          {
            this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBx) }));
            this.vGo.setVisibility(0);
            this.vGp.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBA) }));
            this.vGp.setVisibility(0);
            break;
            if (bool)
            {
              this.vGm.setText(2131762468);
              paramString = new SpannableStringBuilder(getString(2131762449));
              paramn = new com.tencent.mm.plugin.order.c.a(this);
              paramn.uqW = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68150);
                  f.an(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68150);
                }
              };
              paramString.setSpan(paramn, 0, paramString.length(), 18);
              this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
              this.tkx.setText(paramString);
              this.tkx.setVisibility(0);
              break label1465;
            }
            paramString = bq(this.uoE, true) + getString(2131762468);
            this.vGm.setText(k.b(this, paramString, this.vGm.getTextSize()));
            this.tkx.setText(2131762479);
            this.tkx.setVisibility(0);
            break label1465;
            label1722:
            a(false, false, localy);
          }
          if ((paramInt1 == 2003) && (!bool))
          {
            this.vyw.setImageResource(2131691097);
            if (!bt.isNullOrNil(paramString))
            {
              this.vGm.setText(k.a(this, paramString, (int)this.vGm.getTextSize(), localObject));
              this.vGm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label1798:
              if (bool) {
                break label2308;
              }
              if (bt.isNullOrNil(paramn)) {
                break label2102;
              }
              this.tkx.setText(k.a(this, paramn, (int)this.tkx.getTextSize(), localObject));
              this.tkx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label1848:
              this.tkx.setVisibility(0);
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBx) }));
            this.vGo.setVisibility(0);
            this.vGp.setText(getString(2131762460, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBA) }));
            this.vGp.setVisibility(0);
            break;
            this.vGm.setText(2131762472);
            break label1798;
            this.vyw.setImageDrawable(am.i(getContext(), 2131690463, getContext().getResources().getColor(2131099829)));
            if (!bt.isNullOrNil(paramString))
            {
              this.vGm.setText(k.a(this, paramString, (int)this.vGm.getTextSize(), localObject));
              this.vGm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              break label1798;
            }
            if (bool)
            {
              this.vGm.setText(2131762470);
              break label1798;
            }
            paramString = bq(this.uoE, true) + getString(2131762470);
            this.vGm.setText(k.b(this, paramString, this.vGm.getTextSize()));
            break label1798;
            label2102:
            if (("CFT".equals(localy.uoN)) || ("LQT".equals(localy.uoN)))
            {
              bool = "LQT".equals(localy.uoN);
              if (bool)
              {
                paramString = getString(2131762464);
                label2156:
                if (!bool) {
                  break label2283;
                }
              }
              label2283:
              for (paramn = getString(2131762452);; paramn = getString(2131762449))
              {
                localObject = new SpannableString(paramString + paramn);
                locala = new com.tencent.mm.plugin.order.c.a(this);
                locala.uqW = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(68151);
                    if (bool)
                    {
                      com.tencent.mm.bs.d.O(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                      AppMethodBeat.o(68151);
                      return;
                    }
                    f.an(RemittanceDetailUI.this, 0);
                    AppMethodBeat.o(68151);
                  }
                };
                paramInt1 = paramString.length();
                paramInt2 = paramString.length();
                ((SpannableString)localObject).setSpan(locala, paramInt1, paramn.length() + paramInt2, 33);
                this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
                this.tkx.setText((CharSequence)localObject);
                break;
                paramString = getString(2131762462);
                break label2156;
              }
            }
            this.tkx.setText(2131762463);
            break label1848;
            label2308:
            this.tkx.setVisibility(8);
          }
          if (bool)
          {
            this.vyw.setImageDrawable(am.i(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
            {
              this.vGm.setText(k.a(this, paramString, (int)this.vGm.getTextSize(), localObject));
              this.tkx.setText(k.a(this, paramn, (int)this.tkx.getTextSize(), localObject));
              this.vGm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.tkx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBx) }));
            this.vGo.setVisibility(0);
            this.vGp.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBA) }));
            this.vGp.setVisibility(0);
            break;
            if (!bt.isNullOrNil(localy.vBB)) {
              this.vGm.setText(localy.vBB);
            }
            for (;;)
            {
              if (bt.isNullOrNil(localy.vBC)) {
                break label2590;
              }
              this.tkx.setText(localy.vBC);
              break;
              this.vGm.setText(2131762469);
            }
            label2590:
            this.tkx.setText(2131762459);
            continue;
            this.vyw.setImageDrawable(am.i(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
            {
              this.vGm.setText(k.a(this, paramString, (int)this.vGm.getTextSize(), localObject));
              this.tkx.setText(k.a(this, paramn, (int)this.tkx.getTextSize(), localObject));
              this.vGm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.tkx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            }
            else
            {
              if (!bt.isNullOrNil(localy.vBB)) {}
              for (;;)
              {
                try
                {
                  this.vGm.setText(String.format(localy.vBB, new Object[] { bq(this.uoE, true) }));
                  if (bt.isNullOrNil(localy.vBC)) {
                    break label2838;
                  }
                  this.tkx.setText(localy.vBC);
                }
                catch (Exception paramString)
                {
                  ad.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                }
                this.vGm.setText(getString(2131762471, new Object[] { bq(this.uoE, true) }));
              }
              label2838:
              this.tkx.setText("");
            }
          }
          this.vyw.setImageResource(2131691094);
          if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
          {
            this.vGm.setText(k.a(this, paramString, (int)this.vGm.getTextSize(), localObject));
            this.tkx.setText(k.a(this, paramn, (int)this.tkx.getTextSize(), localObject));
            this.vGm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.tkx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
          }
          for (;;)
          {
            a(false, false, localy);
            this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBx) }));
            this.vGo.setVisibility(0);
            if (localy.vBA <= 0) {
              break label3294;
            }
            this.vGp.setText(getString(2131762448, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(localy.vBA) }));
            this.vGp.setVisibility(0);
            break;
            if (!bt.isNullOrNil(localy.vBB))
            {
              this.vGm.setText(localy.vBB);
              label3065:
              if (bt.isNullOrNil(localy.vBC)) {
                break label3263;
              }
              if ((!"CFT".equals(localy.uoN)) && (!"LQT".equals(localy.uoN))) {
                break label3248;
              }
              bool = "LQT".equals(localy.uoN);
              paramn = localy.vBC;
              if (!bool) {
                break label3237;
              }
            }
            label3237:
            for (paramString = getString(2131762452);; paramString = getString(2131762449))
            {
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(paramn);
              ((SpannableStringBuilder)localObject).append(paramString);
              paramString = new com.tencent.mm.plugin.order.c.a(this);
              paramString.uqW = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68152);
                  if (bool)
                  {
                    com.tencent.mm.bs.d.O(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(68152);
                    return;
                  }
                  f.an(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68152);
                }
              };
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramn.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
              this.tkx.setText((CharSequence)localObject);
              break;
              this.vGm.setText(2131762467);
              break label3065;
            }
            label3248:
            this.tkx.setText(localy.vBC);
            continue;
            label3263:
            if (bool) {
              this.tkx.setText(2131762458);
            } else {
              this.tkx.setText(2131762478);
            }
          }
          label3294:
          this.vGp.setVisibility(8);
          break label344;
          com.tencent.mm.plugin.wallet_core.c.aj.a(false, this.mNetSceneMgr);
          break label465;
          label3318:
          paramInt1 = 2131765800;
          break label524;
          label3325:
          if (this.vHf == 0) {
            com.tencent.mm.ui.base.h.cf(getContext(), getString(2131762455));
          }
        }
      }
    }
    else
    {
      if ((paramn instanceof v))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.vHg = ((v)paramn);
          if ((this.vHg.isJumpRemind()) && (this.vHg.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void cMH()
            {
              AppMethodBeat.i(68142);
              RemittanceDetailUI.a(RemittanceDetailUI.this, RemittanceDetailUI.x(RemittanceDetailUI.this));
              AppMethodBeat.o(68142);
            }
          })))
          {
            AppMethodBeat.o(68170);
            return true;
          }
          if (com.tencent.mm.plugin.wallet_core.utils.c.a(this.vHg.tfD))
          {
            new com.tencent.mm.plugin.wallet_core.utils.c(this).b(this.vHg.tfD);
            AppMethodBeat.o(68170);
            return true;
          }
          a(this.vHg);
          AppMethodBeat.o(68170);
          return true;
        }
        if (paramInt2 == 416)
        {
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_plugin", "remittance");
          paramString.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramn, paramString, 1008);
          AppMethodBeat.o(68170);
          return bool;
        }
        paramn = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramn = getString(2131765901);
        }
        com.tencent.mm.ui.base.h.a(this, paramn, null, false, new RemittanceDetailUI.18(this));
        AppMethodBeat.o(68170);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.vCU = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).zWR;
          this.vCV = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).zWS;
          djZ();
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          ad.i("MicroMsg.RemittanceDetailUI", "net error");
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
    {
      AppMethodBeat.o(68170);
      return true;
    }
    AppMethodBeat.o(68170);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */