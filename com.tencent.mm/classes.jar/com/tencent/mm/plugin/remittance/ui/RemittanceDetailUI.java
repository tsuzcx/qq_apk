package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.app.Dialog;
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
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.remittance.model.y.a;
import com.tencent.mm.plugin.remittance.model.y.b;
import com.tencent.mm.plugin.remittance.model.y.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class RemittanceDetailUI
  extends WalletBaseUI
{
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.widget.b.a ofu;
  private n.e qsh;
  private View.OnTouchListener rIt;
  private View.OnLongClickListener rIu;
  protected TextView vHx;
  private String wSF;
  private String wSM;
  protected ImageView ymb;
  protected String yqF;
  private LinearLayout yqn;
  private String yqy;
  private int yqz;
  protected TextView ytQ;
  protected TextView ytR;
  protected TextView ytS;
  protected TextView ytT;
  protected Button ytU;
  protected LinearLayout ytV;
  private LinearLayout ytW;
  private LinearLayout ytX;
  private LinearLayout ytY;
  private TextView ytZ;
  private TextView yuA;
  protected int yuB;
  protected int yuC;
  public String yuD;
  public String yuE;
  protected String yuF;
  protected int yuG;
  protected boolean yuH;
  protected int yuI;
  private int yuJ;
  private com.tencent.mm.plugin.remittance.model.v yuK;
  private com.tencent.mm.sdk.b.c<qv> yuL;
  private com.tencent.mm.sdk.b.c<qu> yuM;
  private int yuN;
  private TextView yua;
  private TextView yub;
  private TextView yuc;
  private TextView yud;
  protected ViewGroup yue;
  protected ImageView yuf;
  protected TextView yug;
  protected TextView yuh;
  protected ImageView yui;
  protected Button yuj;
  protected TextView yuk;
  protected TextView yul;
  protected View yum;
  protected View yun;
  protected View yuo;
  protected Button yup;
  protected TextView yuq;
  protected LinearLayout yur;
  private LinearLayout yus;
  private LinearLayout yut;
  private LinearLayout yuu;
  private LinearLayout yuv;
  private TextView yuw;
  private TextView yux;
  private TextView yuy;
  private TextView yuz;
  
  public RemittanceDetailUI()
  {
    AppMethodBeat.i(68156);
    this.ymb = null;
    this.ytQ = null;
    this.ytR = null;
    this.ytS = null;
    this.ytT = null;
    this.ytU = null;
    this.vHx = null;
    this.yup = null;
    this.yuq = null;
    this.yuD = null;
    this.yuE = null;
    this.yqF = null;
    this.yuF = null;
    this.yqy = null;
    this.yuG = 3;
    this.yuH = false;
    this.yuL = new RemittanceDetailUI.1(this);
    this.yuM = new RemittanceDetailUI.12(this);
    this.ofu = null;
    this.yuN = 0;
    this.qsh = new RemittanceDetailUI.11(this);
    this.rIt = new RemittanceDetailUI.13(this);
    this.rIu = new RemittanceDetailUI.14(this);
    AppMethodBeat.o(68156);
  }
  
  private void a(com.tencent.mm.plugin.remittance.model.v paramv)
  {
    AppMethodBeat.i(68171);
    if ("confirm".equals(paramv.yoe))
    {
      OL(1);
      AppMethodBeat.o(68171);
      return;
    }
    bK(0, getResources().getString(2131762456));
    AppMethodBeat.o(68171);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, final y paramy)
  {
    AppMethodBeat.i(68166);
    if (paramBoolean1)
    {
      this.ytV.setVisibility(8);
      this.yur.setVisibility(0);
      if (!bu.isNullOrNil(paramy.ypi.ypp))
      {
        this.yus.setVisibility(0);
        if (!bu.isNullOrNil(paramy.desc))
        {
          this.yut.setVisibility(0);
          this.yux.setText(paramy.desc);
          this.yux.setOnLongClickListener(this.rIu);
          this.yux.setOnTouchListener(this.rIt);
          if (bu.isNullOrNil(paramy.ypi.ypp)) {
            break label449;
          }
          this.yuu.setVisibility(0);
          this.yuy.setText(paramy.ypi.ypp + "  " + paramy.ypi.jki);
          this.yuw.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68155);
              int i = RemittanceResultNewUI.m(RemittanceDetailUI.this, paramy.ypi.hZQ, RemittanceDetailUI.d(RemittanceDetailUI.this).getWidth());
              if (!bu.jB(i, paramy.ypi.hZQ.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131762447);
                String str2 = paramy.ypi.hZQ.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.wUX = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.e(RemittanceDetailUI.this).setOnTouchListener(a.dMB());
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131762446);
                str2 = paramy.ypi.hZQ + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.wUX = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.f(RemittanceDetailUI.this).setOnTouchListener(a.dMB());
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
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(paramy.ypi.hZQ);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setText(paramy.ypi.hZQ);
              }
            }
          });
          label180:
          if ((!paramBoolean2) || (bu.isNullOrNil(paramy.ypj.dEM))) {
            break label770;
          }
          this.ytV.setVisibility(0);
          this.ytW.setVisibility(0);
          this.yuo.setVisibility(0);
          this.yue.setVisibility(0);
          this.yum.setVisibility(0);
          com.tencent.mm.av.a.a.aJh().loadImage(paramy.ypj.dEM, this.yuf);
          this.yug.setText(paramy.ypj.name);
          this.yuh.setText(paramy.ypj.dyI);
          if (paramy.ypj.ypq <= 0) {
            break label718;
          }
          this.yuj.setText(paramy.ypj.ypr);
          this.yui.setVisibility(8);
          this.yuj.setVisibility(0);
          this.yuj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68126);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.ypj.yps, paramy, 11);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68126);
            }
          });
          com.tencent.mm.wallet_core.ui.f.aW(this.yuj, 200);
          label349:
          if (!bu.isNullOrNil(paramy.ypk.dyI)) {
            break label800;
          }
          this.yuk.setVisibility(8);
          label371:
          if (!bu.isNullOrNil(paramy.ypm.dyI)) {
            break label841;
          }
          this.yul.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      p.a(this, (ScrollView)findViewById(2131304251), findViewById(2131303141), findViewById(2131304020), findViewById(2131304030), 72);
      AppMethodBeat.o(68166);
      return;
      this.yut.setVisibility(8);
      break;
      label449:
      this.yuu.setVisibility(8);
      break label180;
      this.yus.setVisibility(8);
      break label180;
      this.ytV.setVisibility(0);
      this.yur.setVisibility(8);
      if (!bu.isNullOrNil(paramy.ypi.ypp))
      {
        this.ytW.setVisibility(0);
        if (!bu.isNullOrNil(paramy.desc))
        {
          this.ytX.setVisibility(0);
          this.yua.setText(paramy.desc);
          this.yua.setOnLongClickListener(this.rIu);
          this.yua.setOnTouchListener(this.rIt);
        }
        for (;;)
        {
          if (bu.isNullOrNil(paramy.ypi.ypp)) {
            break label658;
          }
          this.yqn.setVisibility(0);
          this.yub.setText(paramy.ypi.ypp + "  " + paramy.ypi.jki);
          this.ytZ.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68125);
              int i = RemittanceResultNewUI.m(RemittanceDetailUI.this, paramy.ypi.hZQ, RemittanceDetailUI.j(RemittanceDetailUI.this).getWidth());
              if (!bu.jB(i, paramy.ypi.hZQ.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131762447);
                String str2 = paramy.ypi.hZQ.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.wUX = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.k(RemittanceDetailUI.this).setOnTouchListener(a.dMB());
                RemittanceDetailUI.k(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131762446);
                str2 = paramy.ypi.hZQ + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.wUX = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.l(RemittanceDetailUI.this).setOnTouchListener(a.dMB());
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
                RemittanceDetailUI.k(RemittanceDetailUI.this).setText(paramy.ypi.hZQ);
                RemittanceDetailUI.l(RemittanceDetailUI.this).setText(paramy.ypi.hZQ);
              }
            }
          });
          break;
          this.ytX.setVisibility(8);
        }
        label658:
        this.yqn.setVisibility(8);
        break label180;
      }
      this.yun.setVisibility(8);
      this.ytX.setVisibility(8);
      this.yqn.setVisibility(8);
      this.yuo.setVisibility(8);
      this.ytW.setVisibility(8);
      break label180;
      label718:
      this.yui.setVisibility(0);
      this.yuj.setVisibility(8);
      this.yui.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68127);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.ypj.yps, paramy, 11);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68127);
        }
      });
      this.yue.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68128);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.ypj.yps, paramy, 11);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68128);
        }
      });
      break label349;
      label770:
      this.yuo.setVisibility(8);
      this.yue.setVisibility(8);
      this.yum.setVisibility(8);
      break label349;
      label800:
      this.yuk.setText(paramy.ypk.dyI);
      this.yuk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.ypk.yps, paramy, 12);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68129);
        }
      });
      this.yuk.setVisibility(0);
      break label371;
      label841:
      this.yul.setText(paramy.ypm.dyI);
      this.yul.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.ypm.yps, paramy, 13);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68130);
        }
      });
      this.yul.setVisibility(0);
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
  
  public static String bI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68174);
    String str = com.tencent.mm.wallet_core.ui.f.zP(paramString);
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
  
  private void dML()
  {
    AppMethodBeat.i(68169);
    if ((this.yuJ != 0) && (this.yqz == 1) && (!bu.isNullOrNil(this.yqy)))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68140);
          com.tencent.mm.wallet_core.ui.f.p(RemittanceDetailUI.this.getContext(), RemittanceDetailUI.w(RemittanceDetailUI.this), false);
          AppMethodBeat.o(68140);
          return false;
        }
      });
      AppMethodBeat.o(68169);
      return;
    }
    ae.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[] { Integer.valueOf(this.yuJ), Boolean.valueOf(bu.isNullOrNil(this.yqy)) });
    removeAllOptionMenu();
    AppMethodBeat.o(68169);
  }
  
  protected void OL(int paramInt)
  {
    AppMethodBeat.i(68160);
    doSceneProgress(new y(paramInt, this.yuD, this.yqF, this.yuB), true);
    AppMethodBeat.o(68160);
  }
  
  protected void OM(int paramInt)
  {
    AppMethodBeat.i(68162);
    if (!getIntent().getBooleanExtra("is_sender", false)) {}
    for (com.tencent.mm.plugin.order.model.h localh = new com.tencent.mm.plugin.order.model.h(this.yqF, this.yuF, paramInt);; localh = new com.tencent.mm.plugin.order.model.h(this.yuD, this.yuF, paramInt))
    {
      localh.setProcessName("RemittanceProcess");
      doSceneProgress(localh);
      AppMethodBeat.o(68162);
      return;
    }
  }
  
  protected void aI(Intent paramIntent)
  {
    AppMethodBeat.i(68163);
    com.tencent.mm.br.d.b(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(68163);
  }
  
  protected final void bK(int paramInt, String paramString)
  {
    AppMethodBeat.i(68172);
    Intent localIntent = new Intent();
    localIntent.putExtra("result_msg", paramString);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(68172);
  }
  
  protected void dNg()
  {
    AppMethodBeat.i(68164);
    com.tencent.mm.plugin.remittance.model.v localv = new com.tencent.mm.plugin.remittance.model.v(this.yuD, this.yqF, this.yuI, "confirm", this.yuE, this.yuB);
    localv.setProcessName("RemittanceProcess");
    doSceneProgress(localv);
    AppMethodBeat.o(68164);
  }
  
  protected void dNh()
  {
    AppMethodBeat.i(68165);
    com.tencent.mm.plugin.remittance.model.v localv = new com.tencent.mm.plugin.remittance.model.v(this.yuD, this.yqF, this.yuI, "refuse", this.yuE, this.yuB);
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
    if ((this.yuK != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.yuK, localBundle, true, 1008)))
    {
      this.yuK = null;
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
    this.ymb = ((ImageView)findViewById(2131304024));
    this.ytQ = ((TextView)findViewById(2131304029));
    this.ytR = ((TextView)findViewById(2131304025));
    this.ytU = ((Button)findViewById(2131304021));
    this.vHx = ((TextView)findViewById(2131304026));
    this.ytV = ((LinearLayout)findViewById(2131304023));
    this.ytW = ((LinearLayout)findViewById(2131304043));
    this.ytX = ((LinearLayout)findViewById(2131304014));
    this.yqn = ((LinearLayout)findViewById(2131303987));
    this.ytY = ((LinearLayout)findViewById(2131303989));
    this.ytZ = ((TextView)findViewById(2131304019));
    this.yua = ((TextView)findViewById(2131304016));
    this.yub = ((TextView)findViewById(2131302665));
    this.yuc = ((TextView)findViewById(2131296478));
    this.yud = ((TextView)findViewById(2131296477));
    this.yue = ((ViewGroup)findViewById(2131304054));
    this.yuf = ((ImageView)findViewById(2131304056));
    this.yug = ((TextView)findViewById(2131304058));
    this.yuh = ((TextView)findViewById(2131304059));
    this.yui = ((ImageView)findViewById(2131304053));
    this.yuj = ((Button)findViewById(2131302852));
    this.yuk = ((TextView)findViewById(2131304011));
    this.yul = ((TextView)findViewById(2131304052));
    this.yum = findViewById(2131304057);
    this.yun = findViewById(2131304044);
    this.yuo = findViewById(2131304045);
    this.yup = ((Button)findViewById(2131304022));
    this.yuq = ((TextView)findViewById(2131304027));
    this.yur = ((LinearLayout)findViewById(2131304028));
    this.yus = ((LinearLayout)findViewById(2131304046));
    this.yut = ((LinearLayout)findViewById(2131304017));
    this.yuu = ((LinearLayout)findViewById(2131303991));
    this.yuv = ((LinearLayout)findViewById(2131303990));
    this.yuw = ((TextView)findViewById(2131304018));
    this.yux = ((TextView)findViewById(2131304015));
    this.yuy = ((TextView)findViewById(2131302664));
    this.yuz = ((TextView)findViewById(2131296475));
    this.yuA = ((TextView)findViewById(2131296476));
    this.ytS = ((TextView)findViewById(2131304031));
    this.ytT = ((TextView)findViewById(2131304032));
    AppMethodBeat.o(68161);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68159);
    ae.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      OL(0);
    }
    AppMethodBeat.o(68159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68157);
    super.onCreate(paramBundle);
    this.yuB = getIntent().getIntExtra("invalid_time", 0);
    this.yuC = getIntent().getIntExtra("appmsg_type", 0);
    this.yuD = getIntent().getStringExtra("transaction_id");
    this.yuF = getIntent().getStringExtra("bill_id");
    this.yqF = getIntent().getStringExtra("transfer_id");
    this.yuE = getIntent().getStringExtra("sender_name");
    this.yuG = getIntent().getIntExtra("effective_date", 3);
    this.yuH = getIntent().getBooleanExtra("is_sender", false);
    this.yuI = getIntent().getIntExtra("total_fee", 0);
    initView();
    OL(0);
    getIntent();
    com.tencent.mm.sdk.b.a.IvT.c(this.yuL);
    this.yuM.alive();
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
    com.tencent.mm.sdk.b.a.IvT.d(this.yuL);
    if (this.yuM != null) {
      this.yuM.dead();
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
          if (localy.uTf)
          {
            this.wSM = com.tencent.mm.model.v.aAC();
            this.wSF = this.yuE;
            bool = com.tencent.mm.model.v.aAC().equals(this.wSF);
            this.ytU.setVisibility(8);
            this.ytR.setText(com.tencent.mm.wallet_core.ui.f.d(localy.phz, localy.wSq));
            paramn = localy.ypf;
            paramString = paramn;
            if (!bu.isNullOrNil(paramn))
            {
              paramString = paramn;
              if (paramn.contains("%s")) {
                paramString = paramn.trim().replace("%s", bI(this.wSF, true));
              }
            }
            paramn = localy.ypg;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.yuD);
            ((Bundle)localObject).putString("receiver_name", this.wSF);
            ((Bundle)localObject).putString("transfer_id", this.yqF);
            ((Bundle)localObject).putInt("total_fee", this.yuI);
            ((Bundle)localObject).putString("sender_name", this.yuE);
            ((Bundle)localObject).putInt("invalid_time", this.yuB);
            ((Bundle)localObject).putParcelable("resend_msg_info", localy.ypl);
            this.vHx.setClickable(true);
            this.ytQ.setClickable(true);
            this.yuq.setClickable(true);
            paramInt1 = localy.status;
            ae.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        else {
          switch (paramInt1)
          {
          default: 
            finish();
            label344:
            if (!bu.isNullOrNil(localy.ypn)) {
              com.tencent.mm.wallet_core.ui.f.a((TextView)findViewById(2131297186), "7", localy.ypn, localy.ypo);
            }
            this.yuJ = localy.yph;
            com.tencent.mm.kernel.g.ajS();
            this.yqy = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRO, ""));
            com.tencent.mm.kernel.g.ajS();
            this.yqz = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRP, Integer.valueOf(0))).intValue();
            if (bu.isNullOrNil(this.yqy))
            {
              com.tencent.mm.plugin.wallet_core.c.aj.a(true, this.mNetSceneMgr);
              label465:
              dML();
              if (localy.wSY == 1)
              {
                com.tencent.mm.kernel.g.ajS();
                if (!((String)com.tencent.mm.kernel.g.ajR().ajA().get(327729, "0")).equals("0")) {
                  break label3325;
                }
                paramString = getContext();
                if (!com.tencent.mm.model.v.aAR()) {
                  break label3318;
                }
                paramInt1 = 2131757192;
                label524:
                com.tencent.mm.ui.base.h.a(paramString, paramInt1, 2131765801, new RemittanceDetailUI.16(this));
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajR().ajA().set(327729, "1");
              }
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          this.wSM = this.yuE;
          this.wSF = com.tencent.mm.model.v.aAC();
          break;
          if (!bool) {
            if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramn)))
            {
              this.ytQ.setText(k.a(this, paramString, (int)this.ytQ.getTextSize(), localObject));
              this.vHx.setText(k.a(this, paramn, (int)this.vHx.getTextSize(), localObject));
              this.ytQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.vHx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label679:
              a(false, false, localy);
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.ymb.setImageDrawable(ao.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ypb) }));
            this.ytS.setVisibility(0);
            this.ytT.setVisibility(8);
            break;
            paramString = getString(2131762474, new Object[] { bI(this.wSF, true) });
            this.ytQ.setText(k.b(this, paramString, this.ytQ.getTextSize()));
            paramString = getString(2131762480, new Object[] { Integer.valueOf(this.yuG) });
            paramn = getString(2131762516);
            localObject = new SpannableString(paramString + paramn);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.wUX = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68145);
                new d(RemittanceDetailUI.this).a(localy.ypl, new f.c()
                {
                  public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(68144);
                    if (paramAnonymous2Boolean)
                    {
                      paramAnonymous2String = new Intent();
                      paramAnonymous2String.putExtra("transaction_id", RemittanceDetailUI.this.yuD);
                      paramAnonymous2String.putExtra("transfer_id", RemittanceDetailUI.this.yqF);
                      paramAnonymous2String.putExtra("receiver_name", RemittanceDetailUI.b(RemittanceDetailUI.this));
                      paramAnonymous2String.putExtra("resend_msg_from_flag", 3);
                      RemittanceDetailUI.this.aI(paramAnonymous2String);
                    }
                    AppMethodBeat.o(68144);
                  }
                });
                AppMethodBeat.o(68145);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramn.length(), 33);
            this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
            this.vHx.setText((CharSequence)localObject);
            break label679;
            this.ymb.setImageDrawable(ao.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            this.yup.setVisibility(0);
            this.yup.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68147);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(9, 4);
                t.eIZ();
                paramAnonymousView = RemittanceDetailUI.this;
                localObject = RemittanceDetailUI.c(RemittanceDetailUI.this);
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a()
                {
                  public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(68146);
                    if (paramAnonymous2Int1 == 2)
                    {
                      RemittanceDetailUI.this.dNg();
                      AppMethodBeat.o(68146);
                      return true;
                    }
                    if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean)) {
                      RemittanceDetailUI.this.dNg();
                    }
                    AppMethodBeat.o(68146);
                    return true;
                  }
                };
                if (!t.a(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject)) {
                  RemittanceDetailUI.this.dNg();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68147);
              }
            });
            if ((bu.isNullOrNil(paramString)) || (bu.isNullOrNil(paramn))) {
              break label1089;
            }
            this.ytQ.setText(k.a(this, paramString, (int)this.ytQ.getTextSize(), localObject));
            this.yuq.setText(k.a(this, paramn, (int)this.yuq.getTextSize(), localObject));
            this.ytQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.yuq.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            a(true, false, localy);
          }
          label1089:
          this.ytQ.setText(2131762473);
          if (localy.yph != 0) {
            if (!bu.isNullOrNil(localy.ypg)) {
              paramString = localy.ypg;
            }
          }
          for (;;)
          {
            paramn = getString(2131762465);
            localObject = new SpannableString(paramString + paramn);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.wUX = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68149);
                com.tencent.mm.ui.base.h.e(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131762461, new Object[] { RemittanceDetailUI.bI(localy.ypd, false) }), RemittanceDetailUI.this.getString(2131755873), RemittanceDetailUI.this.getString(2131762466), RemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(68148);
                    RemittanceDetailUI.this.dNh();
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
            this.yuq.setMovementMethod(LinkMovementMethod.getInstance());
            this.yuq.setText((CharSequence)localObject);
            break;
            ae.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localy.yph == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(2131762475, new Object[] { paramString });
              paramn = getString(2131762476, new Object[] { Integer.valueOf(this.yuG) });
              paramString = paramString + paramn;
              break;
            }
            paramString = getString(2131762476, new Object[] { Integer.valueOf(this.yuG) });
          }
          this.ymb.setImageDrawable(ao.k(getContext(), 2131690392, getContext().getResources().getColor(2131099699)));
          if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramn)))
          {
            this.ytQ.setText(k.a(this, paramString, (int)this.ytQ.getTextSize(), localObject));
            this.vHx.setText(k.a(this, paramn, (int)this.vHx.getTextSize(), localObject));
            this.ytQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.vHx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            label1465:
            if (!bool) {
              break label1722;
            }
            a(false, true, localy);
          }
          for (;;)
          {
            this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ypb) }));
            this.ytS.setVisibility(0);
            this.ytT.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ype) }));
            this.ytT.setVisibility(0);
            break;
            if (bool)
            {
              this.ytQ.setText(2131762468);
              paramString = new SpannableStringBuilder(getString(2131762449));
              paramn = new com.tencent.mm.plugin.order.c.a(this);
              paramn.wUX = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68150);
                  com.tencent.mm.pluginsdk.wallet.f.aw(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68150);
                }
              };
              paramString.setSpan(paramn, 0, paramString.length(), 18);
              this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
              this.vHx.setText(paramString);
              this.vHx.setVisibility(0);
              break label1465;
            }
            paramString = bI(this.wSF, true) + getString(2131762468);
            this.ytQ.setText(k.b(this, paramString, this.ytQ.getTextSize()));
            this.vHx.setText(2131762479);
            this.vHx.setVisibility(0);
            break label1465;
            label1722:
            a(false, false, localy);
          }
          if ((paramInt1 == 2003) && (!bool))
          {
            this.ymb.setImageResource(2131691097);
            if (!bu.isNullOrNil(paramString))
            {
              this.ytQ.setText(k.a(this, paramString, (int)this.ytQ.getTextSize(), localObject));
              this.ytQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label1798:
              if (bool) {
                break label2308;
              }
              if (bu.isNullOrNil(paramn)) {
                break label2102;
              }
              this.vHx.setText(k.a(this, paramn, (int)this.vHx.getTextSize(), localObject));
              this.vHx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label1848:
              this.vHx.setVisibility(0);
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ypb) }));
            this.ytS.setVisibility(0);
            this.ytT.setText(getString(2131762460, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ype) }));
            this.ytT.setVisibility(0);
            break;
            this.ytQ.setText(2131762472);
            break label1798;
            this.ymb.setImageDrawable(ao.k(getContext(), 2131690463, getContext().getResources().getColor(2131099829)));
            if (!bu.isNullOrNil(paramString))
            {
              this.ytQ.setText(k.a(this, paramString, (int)this.ytQ.getTextSize(), localObject));
              this.ytQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              break label1798;
            }
            if (bool)
            {
              this.ytQ.setText(2131762470);
              break label1798;
            }
            paramString = bI(this.wSF, true) + getString(2131762470);
            this.ytQ.setText(k.b(this, paramString, this.ytQ.getTextSize()));
            break label1798;
            label2102:
            if (("CFT".equals(localy.wSO)) || ("LQT".equals(localy.wSO)))
            {
              bool = "LQT".equals(localy.wSO);
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
                locala.wUX = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(68151);
                    if (bool)
                    {
                      com.tencent.mm.br.d.Q(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                      AppMethodBeat.o(68151);
                      return;
                    }
                    com.tencent.mm.pluginsdk.wallet.f.aw(RemittanceDetailUI.this, 0);
                    AppMethodBeat.o(68151);
                  }
                };
                paramInt1 = paramString.length();
                paramInt2 = paramString.length();
                ((SpannableString)localObject).setSpan(locala, paramInt1, paramn.length() + paramInt2, 33);
                this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
                this.vHx.setText((CharSequence)localObject);
                break;
                paramString = getString(2131762462);
                break label2156;
              }
            }
            this.vHx.setText(2131762463);
            break label1848;
            label2308:
            this.vHx.setVisibility(8);
          }
          if (bool)
          {
            this.ymb.setImageDrawable(ao.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramn)))
            {
              this.ytQ.setText(k.a(this, paramString, (int)this.ytQ.getTextSize(), localObject));
              this.vHx.setText(k.a(this, paramn, (int)this.vHx.getTextSize(), localObject));
              this.ytQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.vHx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ypb) }));
            this.ytS.setVisibility(0);
            this.ytT.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ype) }));
            this.ytT.setVisibility(0);
            break;
            if (!bu.isNullOrNil(localy.ypf)) {
              this.ytQ.setText(localy.ypf);
            }
            for (;;)
            {
              if (bu.isNullOrNil(localy.ypg)) {
                break label2590;
              }
              this.vHx.setText(localy.ypg);
              break;
              this.ytQ.setText(2131762469);
            }
            label2590:
            this.vHx.setText(2131762459);
            continue;
            this.ymb.setImageDrawable(ao.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramn)))
            {
              this.ytQ.setText(k.a(this, paramString, (int)this.ytQ.getTextSize(), localObject));
              this.vHx.setText(k.a(this, paramn, (int)this.vHx.getTextSize(), localObject));
              this.ytQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.vHx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            }
            else
            {
              if (!bu.isNullOrNil(localy.ypf)) {}
              for (;;)
              {
                try
                {
                  this.ytQ.setText(String.format(localy.ypf, new Object[] { bI(this.wSF, true) }));
                  if (bu.isNullOrNil(localy.ypg)) {
                    break label2838;
                  }
                  this.vHx.setText(localy.ypg);
                }
                catch (Exception paramString)
                {
                  ae.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                }
                this.ytQ.setText(getString(2131762471, new Object[] { bI(this.wSF, true) }));
              }
              label2838:
              this.vHx.setText("");
            }
          }
          this.ymb.setImageResource(2131691094);
          if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramn)))
          {
            this.ytQ.setText(k.a(this, paramString, (int)this.ytQ.getTextSize(), localObject));
            this.vHx.setText(k.a(this, paramn, (int)this.vHx.getTextSize(), localObject));
            this.ytQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.vHx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
          }
          for (;;)
          {
            a(false, false, localy);
            this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ypb) }));
            this.ytS.setVisibility(0);
            if (localy.ype <= 0) {
              break label3294;
            }
            this.ytT.setText(getString(2131762448, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(localy.ype) }));
            this.ytT.setVisibility(0);
            break;
            if (!bu.isNullOrNil(localy.ypf))
            {
              this.ytQ.setText(localy.ypf);
              label3065:
              if (bu.isNullOrNil(localy.ypg)) {
                break label3263;
              }
              if ((!"CFT".equals(localy.wSO)) && (!"LQT".equals(localy.wSO))) {
                break label3248;
              }
              bool = "LQT".equals(localy.wSO);
              paramn = localy.ypg;
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
              paramString.wUX = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68152);
                  if (bool)
                  {
                    com.tencent.mm.br.d.Q(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(68152);
                    return;
                  }
                  com.tencent.mm.pluginsdk.wallet.f.aw(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68152);
                }
              };
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramn.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
              this.vHx.setText((CharSequence)localObject);
              break;
              this.ytQ.setText(2131762467);
              break label3065;
            }
            label3248:
            this.vHx.setText(localy.ypg);
            continue;
            label3263:
            if (bool) {
              this.vHx.setText(2131762458);
            } else {
              this.vHx.setText(2131762478);
            }
          }
          label3294:
          this.ytT.setVisibility(8);
          break label344;
          com.tencent.mm.plugin.wallet_core.c.aj.a(false, this.mNetSceneMgr);
          break label465;
          label3318:
          paramInt1 = 2131765800;
          break label524;
          label3325:
          if (this.yuJ == 0) {
            com.tencent.mm.ui.base.h.cm(getContext(), getString(2131762455));
          }
        }
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.v))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.yuK = ((com.tencent.mm.plugin.remittance.model.v)paramn);
          if ((this.yuK.isJumpRemind()) && (this.yuK.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void dmz()
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
          if (com.tencent.mm.plugin.wallet_core.utils.c.a(this.yuK.vCD))
          {
            new com.tencent.mm.plugin.wallet_core.utils.c(this).b(this.yuK.vCD);
            AppMethodBeat.o(68170);
            return true;
          }
          a(this.yuK);
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
          this.yqy = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhf;
          this.yqz = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhg;
          dML();
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          ae.i("MicroMsg.RemittanceDetailUI", "net error");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */