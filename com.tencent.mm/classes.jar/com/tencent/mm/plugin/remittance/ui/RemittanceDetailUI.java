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
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.remittance.model.y.a;
import com.tencent.mm.plugin.remittance.model.y.b;
import com.tencent.mm.plugin.remittance.model.y.d;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private int nwY;
  private int nwZ;
  private com.tencent.mm.ui.widget.b.a nym;
  private n.d pHX;
  private View.OnTouchListener qQi;
  private View.OnLongClickListener qQj;
  protected TextView usQ;
  private String vxA;
  private String vxH;
  protected ImageView wIB;
  private LinearLayout wMO;
  private String wMZ;
  private int wNa;
  protected String wNg;
  private TextView wQA;
  private TextView wQB;
  private TextView wQC;
  private TextView wQD;
  private TextView wQE;
  protected ViewGroup wQF;
  protected ImageView wQG;
  protected TextView wQH;
  protected TextView wQI;
  protected ImageView wQJ;
  protected Button wQK;
  protected TextView wQL;
  protected TextView wQM;
  protected View wQN;
  protected View wQO;
  protected View wQP;
  protected Button wQQ;
  protected TextView wQR;
  protected LinearLayout wQS;
  private LinearLayout wQT;
  private LinearLayout wQU;
  private LinearLayout wQV;
  private LinearLayout wQW;
  private TextView wQX;
  private TextView wQY;
  private TextView wQZ;
  protected TextView wQr;
  protected TextView wQs;
  protected TextView wQt;
  protected TextView wQu;
  protected Button wQv;
  protected LinearLayout wQw;
  private LinearLayout wQx;
  private LinearLayout wQy;
  private LinearLayout wQz;
  private TextView wRa;
  private TextView wRb;
  protected int wRc;
  protected int wRd;
  public String wRe;
  public String wRf;
  protected String wRg;
  protected int wRh;
  protected boolean wRi;
  protected int wRj;
  private int wRk;
  private v wRl;
  private com.tencent.mm.sdk.b.c<qj> wRm;
  private com.tencent.mm.sdk.b.c<qi> wRn;
  private int wRo;
  
  public RemittanceDetailUI()
  {
    AppMethodBeat.i(68156);
    this.wIB = null;
    this.wQr = null;
    this.wQs = null;
    this.wQt = null;
    this.wQu = null;
    this.wQv = null;
    this.usQ = null;
    this.wQQ = null;
    this.wQR = null;
    this.wRe = null;
    this.wRf = null;
    this.wNg = null;
    this.wRg = null;
    this.wMZ = null;
    this.wRh = 3;
    this.wRi = false;
    this.wRm = new RemittanceDetailUI.1(this);
    this.wRn = new RemittanceDetailUI.12(this);
    this.nym = null;
    this.wRo = 0;
    this.pHX = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(68135);
        ClipboardManager localClipboardManager = (ClipboardManager)ai.getContext().getSystemService("clipboard");
        paramAnonymousMenuItem = "";
        if (bs.jl(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131304016)) {
          paramAnonymousMenuItem = RemittanceDetailUI.o(RemittanceDetailUI.this).getText().toString().trim();
        }
        do
        {
          for (;;)
          {
            localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
            com.tencent.mm.ui.base.h.cg(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131755702));
            AppMethodBeat.o(68135);
            return;
            if (bs.jl(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131303989))
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
            if (!bs.jl(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131304015)) {
              break;
            }
            paramAnonymousMenuItem = RemittanceDetailUI.q(RemittanceDetailUI.this).getText().toString().trim();
          }
        } while (!bs.jl(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131303990));
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
    this.qQi = new RemittanceDetailUI.13(this);
    this.qQj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68139);
        ac.d("MicroMsg.RemittanceDetailUI", "onLongClick");
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
    if ("confirm".equals(paramv.wKF))
    {
      MD(1);
      AppMethodBeat.o(68171);
      return;
    }
    bE(0, getResources().getString(2131762456));
    AppMethodBeat.o(68171);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, final y paramy)
  {
    AppMethodBeat.i(68166);
    if (paramBoolean1)
    {
      this.wQw.setVisibility(8);
      this.wQS.setVisibility(0);
      if (!bs.isNullOrNil(paramy.wLJ.wLQ))
      {
        this.wQT.setVisibility(0);
        if (!bs.isNullOrNil(paramy.desc))
        {
          this.wQU.setVisibility(0);
          this.wQY.setText(paramy.desc);
          this.wQY.setOnLongClickListener(this.qQj);
          this.wQY.setOnTouchListener(this.qQi);
          if (bs.isNullOrNil(paramy.wLJ.wLQ)) {
            break label449;
          }
          this.wQV.setVisibility(0);
          this.wQZ.setText(paramy.wLJ.wLQ + "  " + paramy.wLJ.iOg);
          this.wQX.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68155);
              int i = RemittanceResultNewUI.n(RemittanceDetailUI.this, paramy.wLJ.hEt, RemittanceDetailUI.d(RemittanceDetailUI.this).getWidth());
              if (!bs.jl(i, paramy.wLJ.hEt.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131762447);
                String str2 = paramy.wLJ.hEt.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.vzS = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.e(RemittanceDetailUI.this).setOnTouchListener(a.dxR());
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131762446);
                str2 = paramy.wLJ.hEt + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.vzS = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.f(RemittanceDetailUI.this).setOnTouchListener(a.dxR());
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
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(paramy.wLJ.hEt);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setText(paramy.wLJ.hEt);
              }
            }
          });
          label180:
          if ((!paramBoolean2) || (bs.isNullOrNil(paramy.wLK.drM))) {
            break label770;
          }
          this.wQw.setVisibility(0);
          this.wQx.setVisibility(0);
          this.wQP.setVisibility(0);
          this.wQF.setVisibility(0);
          this.wQN.setVisibility(0);
          com.tencent.mm.av.a.a.aFG().loadImage(paramy.wLK.drM, this.wQG);
          this.wQH.setText(paramy.wLK.name);
          this.wQI.setText(paramy.wLK.dlQ);
          if (paramy.wLK.wLR <= 0) {
            break label718;
          }
          this.wQK.setText(paramy.wLK.wLS);
          this.wQJ.setVisibility(8);
          this.wQK.setVisibility(0);
          this.wQK.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68126);
              RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.wLK.wLT, paramy, 11);
              AppMethodBeat.o(68126);
            }
          });
          com.tencent.mm.wallet_core.ui.e.aT(this.wQK, 200);
          label349:
          if (!bs.isNullOrNil(paramy.wLL.dlQ)) {
            break label800;
          }
          this.wQL.setVisibility(8);
          label371:
          if (!bs.isNullOrNil(paramy.wLN.dlQ)) {
            break label841;
          }
          this.wQM.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      p.a(this, (ScrollView)findViewById(2131304251), findViewById(2131303141), findViewById(2131304020), findViewById(2131304030), 72);
      AppMethodBeat.o(68166);
      return;
      this.wQU.setVisibility(8);
      break;
      label449:
      this.wQV.setVisibility(8);
      break label180;
      this.wQT.setVisibility(8);
      break label180;
      this.wQw.setVisibility(0);
      this.wQS.setVisibility(8);
      if (!bs.isNullOrNil(paramy.wLJ.wLQ))
      {
        this.wQx.setVisibility(0);
        if (!bs.isNullOrNil(paramy.desc))
        {
          this.wQy.setVisibility(0);
          this.wQB.setText(paramy.desc);
          this.wQB.setOnLongClickListener(this.qQj);
          this.wQB.setOnTouchListener(this.qQi);
        }
        for (;;)
        {
          if (bs.isNullOrNil(paramy.wLJ.wLQ)) {
            break label658;
          }
          this.wMO.setVisibility(0);
          this.wQC.setText(paramy.wLJ.wLQ + "  " + paramy.wLJ.iOg);
          this.wQA.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68125);
              int i = RemittanceResultNewUI.n(RemittanceDetailUI.this, paramy.wLJ.hEt, RemittanceDetailUI.j(RemittanceDetailUI.this).getWidth());
              if (!bs.jl(i, paramy.wLJ.hEt.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131762447);
                String str2 = paramy.wLJ.hEt.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.vzS = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.k(RemittanceDetailUI.this).setOnTouchListener(a.dxR());
                RemittanceDetailUI.k(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131762446);
                str2 = paramy.wLJ.hEt + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.vzS = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.l(RemittanceDetailUI.this).setOnTouchListener(a.dxR());
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
                RemittanceDetailUI.k(RemittanceDetailUI.this).setText(paramy.wLJ.hEt);
                RemittanceDetailUI.l(RemittanceDetailUI.this).setText(paramy.wLJ.hEt);
              }
            }
          });
          break;
          this.wQy.setVisibility(8);
        }
        label658:
        this.wMO.setVisibility(8);
        break label180;
      }
      this.wQO.setVisibility(8);
      this.wQy.setVisibility(8);
      this.wMO.setVisibility(8);
      this.wQP.setVisibility(8);
      this.wQx.setVisibility(8);
      break label180;
      label718:
      this.wQJ.setVisibility(0);
      this.wQK.setVisibility(8);
      this.wQJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68127);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.wLK.wLT, paramy, 11);
          AppMethodBeat.o(68127);
        }
      });
      this.wQF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68128);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.wLK.wLT, paramy, 11);
          AppMethodBeat.o(68128);
        }
      });
      break label349;
      label770:
      this.wQP.setVisibility(8);
      this.wQF.setVisibility(8);
      this.wQN.setVisibility(8);
      break label349;
      label800:
      this.wQL.setText(paramy.wLL.dlQ);
      this.wQL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68129);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.wLL.wLT, paramy, 12);
          AppMethodBeat.o(68129);
        }
      });
      this.wQL.setVisibility(0);
      break label371;
      label841:
      this.wQM.setText(paramy.wLN.dlQ);
      this.wQM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68130);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.wLN.wLT, paramy, 13);
          AppMethodBeat.o(68130);
        }
      });
      this.wQM.setVisibility(0);
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
  
  public static String bx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68174);
    String str = com.tencent.mm.wallet_core.ui.e.wk(paramString);
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
  
  private void dyb()
  {
    AppMethodBeat.i(68169);
    if ((this.wRk != 0) && (this.wNa == 1) && (!bs.isNullOrNil(this.wMZ)))
    {
      addIconOptionMenu(0, 2131234701, new RemittanceDetailUI.15(this));
      AppMethodBeat.o(68169);
      return;
    }
    ac.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[] { Integer.valueOf(this.wRk), Boolean.valueOf(bs.isNullOrNil(this.wMZ)) });
    removeAllOptionMenu();
    AppMethodBeat.o(68169);
  }
  
  protected void MD(int paramInt)
  {
    AppMethodBeat.i(68160);
    doSceneProgress(new y(paramInt, this.wRe, this.wNg, this.wRc), true);
    AppMethodBeat.o(68160);
  }
  
  protected void ME(int paramInt)
  {
    AppMethodBeat.i(68162);
    if (!getIntent().getBooleanExtra("is_sender", false)) {}
    for (com.tencent.mm.plugin.order.model.h localh = new com.tencent.mm.plugin.order.model.h(this.wNg, this.wRg, paramInt);; localh = new com.tencent.mm.plugin.order.model.h(this.wRe, this.wRg, paramInt))
    {
      localh.setProcessName("RemittanceProcess");
      doSceneProgress(localh);
      AppMethodBeat.o(68162);
      return;
    }
  }
  
  protected void aC(Intent paramIntent)
  {
    AppMethodBeat.i(68163);
    com.tencent.mm.br.d.b(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(68163);
  }
  
  protected final void bE(int paramInt, String paramString)
  {
    AppMethodBeat.i(68172);
    Intent localIntent = new Intent();
    localIntent.putExtra("result_msg", paramString);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(68172);
  }
  
  protected void dyw()
  {
    AppMethodBeat.i(68164);
    v localv = new v(this.wRe, this.wNg, this.wRj, "confirm", this.wRf, this.wRc);
    localv.setProcessName("RemittanceProcess");
    doSceneProgress(localv);
    AppMethodBeat.o(68164);
  }
  
  protected void dyx()
  {
    AppMethodBeat.i(68165);
    v localv = new v(this.wRe, this.wNg, this.wRj, "refuse", this.wRf, this.wRc);
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
    if ((this.wRl != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.wRl, localBundle, true, 1008)))
    {
      this.wRl = null;
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
    this.wIB = ((ImageView)findViewById(2131304024));
    this.wQr = ((TextView)findViewById(2131304029));
    this.wQs = ((TextView)findViewById(2131304025));
    this.wQv = ((Button)findViewById(2131304021));
    this.usQ = ((TextView)findViewById(2131304026));
    this.wQw = ((LinearLayout)findViewById(2131304023));
    this.wQx = ((LinearLayout)findViewById(2131304043));
    this.wQy = ((LinearLayout)findViewById(2131304014));
    this.wMO = ((LinearLayout)findViewById(2131303987));
    this.wQz = ((LinearLayout)findViewById(2131303989));
    this.wQA = ((TextView)findViewById(2131304019));
    this.wQB = ((TextView)findViewById(2131304016));
    this.wQC = ((TextView)findViewById(2131302665));
    this.wQD = ((TextView)findViewById(2131296478));
    this.wQE = ((TextView)findViewById(2131296477));
    this.wQF = ((ViewGroup)findViewById(2131304054));
    this.wQG = ((ImageView)findViewById(2131304056));
    this.wQH = ((TextView)findViewById(2131304058));
    this.wQI = ((TextView)findViewById(2131304059));
    this.wQJ = ((ImageView)findViewById(2131304053));
    this.wQK = ((Button)findViewById(2131302852));
    this.wQL = ((TextView)findViewById(2131304011));
    this.wQM = ((TextView)findViewById(2131304052));
    this.wQN = findViewById(2131304057);
    this.wQO = findViewById(2131304044);
    this.wQP = findViewById(2131304045);
    this.wQQ = ((Button)findViewById(2131304022));
    this.wQR = ((TextView)findViewById(2131304027));
    this.wQS = ((LinearLayout)findViewById(2131304028));
    this.wQT = ((LinearLayout)findViewById(2131304046));
    this.wQU = ((LinearLayout)findViewById(2131304017));
    this.wQV = ((LinearLayout)findViewById(2131303991));
    this.wQW = ((LinearLayout)findViewById(2131303990));
    this.wQX = ((TextView)findViewById(2131304018));
    this.wQY = ((TextView)findViewById(2131304015));
    this.wQZ = ((TextView)findViewById(2131302664));
    this.wRa = ((TextView)findViewById(2131296475));
    this.wRb = ((TextView)findViewById(2131296476));
    this.wQt = ((TextView)findViewById(2131304031));
    this.wQu = ((TextView)findViewById(2131304032));
    AppMethodBeat.o(68161);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68159);
    ac.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      MD(0);
    }
    AppMethodBeat.o(68159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68157);
    super.onCreate(paramBundle);
    this.wRc = getIntent().getIntExtra("invalid_time", 0);
    this.wRd = getIntent().getIntExtra("appmsg_type", 0);
    this.wRe = getIntent().getStringExtra("transaction_id");
    this.wRg = getIntent().getStringExtra("bill_id");
    this.wNg = getIntent().getStringExtra("transfer_id");
    this.wRf = getIntent().getStringExtra("sender_name");
    this.wRh = getIntent().getIntExtra("effective_date", 3);
    this.wRi = getIntent().getBooleanExtra("is_sender", false);
    this.wRj = getIntent().getIntExtra("total_fee", 0);
    initView();
    MD(0);
    getIntent();
    com.tencent.mm.sdk.b.a.GpY.c(this.wRm);
    this.wRn.alive();
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
    com.tencent.mm.sdk.b.a.GpY.d(this.wRm);
    if (this.wRn != null) {
      this.wRn.dead();
    }
    super.onDestroy();
    AppMethodBeat.o(68158);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
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
          if (localy.tEJ)
          {
            this.vxH = com.tencent.mm.model.u.axw();
            this.vxA = this.wRf;
            bool = com.tencent.mm.model.u.axw().equals(this.vxA);
            this.wQv.setVisibility(8);
            this.wQs.setText(com.tencent.mm.wallet_core.ui.e.d(localy.oxA, localy.vxl));
            paramn = localy.wLG;
            paramString = paramn;
            if (!bs.isNullOrNil(paramn))
            {
              paramString = paramn;
              if (paramn.contains("%s")) {
                paramString = paramn.trim().replace("%s", bx(this.vxA, true));
              }
            }
            paramn = localy.wLH;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.wRe);
            ((Bundle)localObject).putString("receiver_name", this.vxA);
            ((Bundle)localObject).putString("transfer_id", this.wNg);
            ((Bundle)localObject).putInt("total_fee", this.wRj);
            ((Bundle)localObject).putString("sender_name", this.wRf);
            ((Bundle)localObject).putInt("invalid_time", this.wRc);
            ((Bundle)localObject).putParcelable("resend_msg_info", localy.wLM);
            this.usQ.setClickable(true);
            this.wQr.setClickable(true);
            this.wQR.setClickable(true);
            paramInt1 = localy.status;
            ac.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        else {
          switch (paramInt1)
          {
          default: 
            finish();
            label344:
            if (!bs.isNullOrNil(localy.wLO)) {
              com.tencent.mm.wallet_core.ui.e.a((TextView)findViewById(2131297186), "7", localy.wLO, localy.wLP);
            }
            this.wRk = localy.wLI;
            com.tencent.mm.kernel.g.agS();
            this.wMZ = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GKY, ""));
            com.tencent.mm.kernel.g.agS();
            this.wNa = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GKZ, Integer.valueOf(0))).intValue();
            if (bs.isNullOrNil(this.wMZ))
            {
              aj.a(true, this.mNetSceneMgr);
              label465:
              dyb();
              if (localy.vxT == 1)
              {
                com.tencent.mm.kernel.g.agS();
                if (!((String)com.tencent.mm.kernel.g.agR().agA().get(327729, "0")).equals("0")) {
                  break label3325;
                }
                paramString = getContext();
                if (!com.tencent.mm.model.u.axL()) {
                  break label3318;
                }
                paramInt1 = 2131757192;
                label524:
                com.tencent.mm.ui.base.h.a(paramString, paramInt1, 2131765801, new RemittanceDetailUI.16(this));
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.kernel.g.agR().agA().set(327729, "1");
              }
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          this.vxH = this.wRf;
          this.vxA = com.tencent.mm.model.u.axw();
          break;
          if (!bool) {
            if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramn)))
            {
              this.wQr.setText(k.a(this, paramString, (int)this.wQr.getTextSize(), localObject));
              this.usQ.setText(k.a(this, paramn, (int)this.usQ.getTextSize(), localObject));
              this.wQr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.usQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label679:
              a(false, false, localy);
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.wIB.setImageDrawable(am.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLC) }));
            this.wQt.setVisibility(0);
            this.wQu.setVisibility(8);
            break;
            paramString = getString(2131762474, new Object[] { bx(this.vxA, true) });
            this.wQr.setText(k.b(this, paramString, this.wQr.getTextSize()));
            paramString = getString(2131762480, new Object[] { Integer.valueOf(this.wRh) });
            paramn = getString(2131762516);
            localObject = new SpannableString(paramString + paramn);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.vzS = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68145);
                new d(RemittanceDetailUI.this).a(localy.wLM, new f.c()
                {
                  public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(68144);
                    if (paramAnonymous2Boolean)
                    {
                      paramAnonymous2String = new Intent();
                      paramAnonymous2String.putExtra("transaction_id", RemittanceDetailUI.this.wRe);
                      paramAnonymous2String.putExtra("transfer_id", RemittanceDetailUI.this.wNg);
                      paramAnonymous2String.putExtra("receiver_name", RemittanceDetailUI.b(RemittanceDetailUI.this));
                      paramAnonymous2String.putExtra("resend_msg_from_flag", 3);
                      RemittanceDetailUI.this.aC(paramAnonymous2String);
                    }
                    AppMethodBeat.o(68144);
                  }
                });
                AppMethodBeat.o(68145);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramn.length(), 33);
            this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
            this.usQ.setText((CharSequence)localObject);
            break label679;
            this.wIB.setImageDrawable(am.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            this.wQQ.setVisibility(0);
            this.wQQ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68147);
                ((b)com.tencent.mm.kernel.g.ab(b.class)).gm(9, 4);
                s.ers();
                paramAnonymousView = RemittanceDetailUI.this;
                i locali = RemittanceDetailUI.c(RemittanceDetailUI.this);
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a()
                {
                  public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(68146);
                    if (paramAnonymous2Int1 == 2)
                    {
                      RemittanceDetailUI.this.dyw();
                      AppMethodBeat.o(68146);
                      return true;
                    }
                    if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean)) {
                      RemittanceDetailUI.this.dyw();
                    }
                    AppMethodBeat.o(68146);
                    return true;
                  }
                };
                if (!s.a(paramAnonymousView, locali)) {
                  RemittanceDetailUI.this.dyw();
                }
                AppMethodBeat.o(68147);
              }
            });
            if ((bs.isNullOrNil(paramString)) || (bs.isNullOrNil(paramn))) {
              break label1089;
            }
            this.wQr.setText(k.a(this, paramString, (int)this.wQr.getTextSize(), localObject));
            this.wQR.setText(k.a(this, paramn, (int)this.wQR.getTextSize(), localObject));
            this.wQr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.wQR.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            a(true, false, localy);
          }
          label1089:
          this.wQr.setText(2131762473);
          if (localy.wLI != 0) {
            if (!bs.isNullOrNil(localy.wLH)) {
              paramString = localy.wLH;
            }
          }
          for (;;)
          {
            paramn = getString(2131762465);
            localObject = new SpannableString(paramString + paramn);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.vzS = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68149);
                com.tencent.mm.ui.base.h.d(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131762461, new Object[] { RemittanceDetailUI.bx(localy.wLE, false) }), RemittanceDetailUI.this.getString(2131755873), RemittanceDetailUI.this.getString(2131762466), RemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(68148);
                    RemittanceDetailUI.this.dyx();
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
            this.wQR.setMovementMethod(LinkMovementMethod.getInstance());
            this.wQR.setText((CharSequence)localObject);
            break;
            ac.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localy.wLI == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(2131762475, new Object[] { paramString });
              paramn = getString(2131762476, new Object[] { Integer.valueOf(this.wRh) });
              paramString = paramString + paramn;
              break;
            }
            paramString = getString(2131762476, new Object[] { Integer.valueOf(this.wRh) });
          }
          this.wIB.setImageDrawable(am.k(getContext(), 2131690392, getContext().getResources().getColor(2131099699)));
          if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramn)))
          {
            this.wQr.setText(k.a(this, paramString, (int)this.wQr.getTextSize(), localObject));
            this.usQ.setText(k.a(this, paramn, (int)this.usQ.getTextSize(), localObject));
            this.wQr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.usQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            label1465:
            if (!bool) {
              break label1722;
            }
            a(false, true, localy);
          }
          for (;;)
          {
            this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLC) }));
            this.wQt.setVisibility(0);
            this.wQu.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLF) }));
            this.wQu.setVisibility(0);
            break;
            if (bool)
            {
              this.wQr.setText(2131762468);
              paramString = new SpannableStringBuilder(getString(2131762449));
              paramn = new com.tencent.mm.plugin.order.c.a(this);
              paramn.vzS = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68150);
                  f.at(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68150);
                }
              };
              paramString.setSpan(paramn, 0, paramString.length(), 18);
              this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
              this.usQ.setText(paramString);
              this.usQ.setVisibility(0);
              break label1465;
            }
            paramString = bx(this.vxA, true) + getString(2131762468);
            this.wQr.setText(k.b(this, paramString, this.wQr.getTextSize()));
            this.usQ.setText(2131762479);
            this.usQ.setVisibility(0);
            break label1465;
            label1722:
            a(false, false, localy);
          }
          if ((paramInt1 == 2003) && (!bool))
          {
            this.wIB.setImageResource(2131691097);
            if (!bs.isNullOrNil(paramString))
            {
              this.wQr.setText(k.a(this, paramString, (int)this.wQr.getTextSize(), localObject));
              this.wQr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label1798:
              if (bool) {
                break label2308;
              }
              if (bs.isNullOrNil(paramn)) {
                break label2102;
              }
              this.usQ.setText(k.a(this, paramn, (int)this.usQ.getTextSize(), localObject));
              this.usQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label1848:
              this.usQ.setVisibility(0);
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLC) }));
            this.wQt.setVisibility(0);
            this.wQu.setText(getString(2131762460, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLF) }));
            this.wQu.setVisibility(0);
            break;
            this.wQr.setText(2131762472);
            break label1798;
            this.wIB.setImageDrawable(am.k(getContext(), 2131690463, getContext().getResources().getColor(2131099829)));
            if (!bs.isNullOrNil(paramString))
            {
              this.wQr.setText(k.a(this, paramString, (int)this.wQr.getTextSize(), localObject));
              this.wQr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              break label1798;
            }
            if (bool)
            {
              this.wQr.setText(2131762470);
              break label1798;
            }
            paramString = bx(this.vxA, true) + getString(2131762470);
            this.wQr.setText(k.b(this, paramString, this.wQr.getTextSize()));
            break label1798;
            label2102:
            if (("CFT".equals(localy.vxJ)) || ("LQT".equals(localy.vxJ)))
            {
              bool = "LQT".equals(localy.vxJ);
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
                locala.vzS = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(68151);
                    if (bool)
                    {
                      com.tencent.mm.br.d.N(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                      AppMethodBeat.o(68151);
                      return;
                    }
                    f.at(RemittanceDetailUI.this, 0);
                    AppMethodBeat.o(68151);
                  }
                };
                paramInt1 = paramString.length();
                paramInt2 = paramString.length();
                ((SpannableString)localObject).setSpan(locala, paramInt1, paramn.length() + paramInt2, 33);
                this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
                this.usQ.setText((CharSequence)localObject);
                break;
                paramString = getString(2131762462);
                break label2156;
              }
            }
            this.usQ.setText(2131762463);
            break label1848;
            label2308:
            this.usQ.setVisibility(8);
          }
          if (bool)
          {
            this.wIB.setImageDrawable(am.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramn)))
            {
              this.wQr.setText(k.a(this, paramString, (int)this.wQr.getTextSize(), localObject));
              this.usQ.setText(k.a(this, paramn, (int)this.usQ.getTextSize(), localObject));
              this.wQr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.usQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLC) }));
            this.wQt.setVisibility(0);
            this.wQu.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLF) }));
            this.wQu.setVisibility(0);
            break;
            if (!bs.isNullOrNil(localy.wLG)) {
              this.wQr.setText(localy.wLG);
            }
            for (;;)
            {
              if (bs.isNullOrNil(localy.wLH)) {
                break label2590;
              }
              this.usQ.setText(localy.wLH);
              break;
              this.wQr.setText(2131762469);
            }
            label2590:
            this.usQ.setText(2131762459);
            continue;
            this.wIB.setImageDrawable(am.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramn)))
            {
              this.wQr.setText(k.a(this, paramString, (int)this.wQr.getTextSize(), localObject));
              this.usQ.setText(k.a(this, paramn, (int)this.usQ.getTextSize(), localObject));
              this.wQr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.usQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            }
            else
            {
              if (!bs.isNullOrNil(localy.wLG)) {}
              for (;;)
              {
                try
                {
                  this.wQr.setText(String.format(localy.wLG, new Object[] { bx(this.vxA, true) }));
                  if (bs.isNullOrNil(localy.wLH)) {
                    break label2838;
                  }
                  this.usQ.setText(localy.wLH);
                }
                catch (Exception paramString)
                {
                  ac.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                }
                this.wQr.setText(getString(2131762471, new Object[] { bx(this.vxA, true) }));
              }
              label2838:
              this.usQ.setText("");
            }
          }
          this.wIB.setImageResource(2131691094);
          if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramn)))
          {
            this.wQr.setText(k.a(this, paramString, (int)this.wQr.getTextSize(), localObject));
            this.usQ.setText(k.a(this, paramn, (int)this.usQ.getTextSize(), localObject));
            this.wQr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.usQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
          }
          for (;;)
          {
            a(false, false, localy);
            this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLC) }));
            this.wQt.setVisibility(0);
            if (localy.wLF <= 0) {
              break label3294;
            }
            this.wQu.setText(getString(2131762448, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(localy.wLF) }));
            this.wQu.setVisibility(0);
            break;
            if (!bs.isNullOrNil(localy.wLG))
            {
              this.wQr.setText(localy.wLG);
              label3065:
              if (bs.isNullOrNil(localy.wLH)) {
                break label3263;
              }
              if ((!"CFT".equals(localy.vxJ)) && (!"LQT".equals(localy.vxJ))) {
                break label3248;
              }
              bool = "LQT".equals(localy.vxJ);
              paramn = localy.wLH;
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
              paramString.vzS = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68152);
                  if (bool)
                  {
                    com.tencent.mm.br.d.N(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(68152);
                    return;
                  }
                  f.at(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68152);
                }
              };
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramn.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
              this.usQ.setText((CharSequence)localObject);
              break;
              this.wQr.setText(2131762467);
              break label3065;
            }
            label3248:
            this.usQ.setText(localy.wLH);
            continue;
            label3263:
            if (bool) {
              this.usQ.setText(2131762458);
            } else {
              this.usQ.setText(2131762478);
            }
          }
          label3294:
          this.wQu.setVisibility(8);
          break label344;
          aj.a(false, this.mNetSceneMgr);
          break label465;
          label3318:
          paramInt1 = 2131765800;
          break label524;
          label3325:
          if (this.wRk == 0) {
            com.tencent.mm.ui.base.h.cg(getContext(), getString(2131762455));
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
          this.wRl = ((v)paramn);
          if ((this.wRl.isJumpRemind()) && (this.wRl.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void dan()
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
          if (com.tencent.mm.plugin.wallet_core.utils.c.a(this.wRl.unS))
          {
            new com.tencent.mm.plugin.wallet_core.utils.c(this).b(this.wRl.unS);
            AppMethodBeat.o(68170);
            return true;
          }
          a(this.wRl);
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
      if ((paramn instanceof aj))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.wMZ = ((aj)paramn).Bpl;
          this.wNa = ((aj)paramn).Bpm;
          dyb();
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          ac.i("MicroMsg.RemittanceDetailUI", "net error");
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