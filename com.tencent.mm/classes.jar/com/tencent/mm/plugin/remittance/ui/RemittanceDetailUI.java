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
import android.view.MenuItem.OnMenuItemClickListener;
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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.qu.a;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.remittance.model.y.a;
import com.tencent.mm.plugin.remittance.model.y.b;
import com.tencent.mm.plugin.remittance.model.y.d;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class RemittanceDetailUI
  extends WalletBaseUI
{
  private int nYw;
  private int nYx;
  private com.tencent.mm.ui.widget.b.a nZK;
  private n.e qlC;
  private View.OnTouchListener rAi;
  private View.OnLongClickListener rAj;
  protected TextView vvt;
  private String wCU;
  private String wDb;
  protected ImageView xWi;
  private String yaH;
  private int yaI;
  protected String yaO;
  private LinearLayout yav;
  protected TextView ydZ;
  protected LinearLayout yeA;
  private LinearLayout yeB;
  private LinearLayout yeC;
  private LinearLayout yeD;
  private LinearLayout yeE;
  private TextView yeF;
  private TextView yeG;
  private TextView yeH;
  private TextView yeI;
  private TextView yeJ;
  protected int yeK;
  protected int yeL;
  public String yeM;
  public String yeN;
  protected String yeO;
  protected int yeP;
  protected boolean yeQ;
  protected int yeR;
  private int yeS;
  private v yeT;
  private com.tencent.mm.sdk.b.c<qu> yeU;
  private com.tencent.mm.sdk.b.c<qt> yeV;
  private int yeW;
  protected TextView yea;
  protected TextView yeb;
  protected TextView yec;
  protected Button yed;
  protected LinearLayout yee;
  private LinearLayout yef;
  private LinearLayout yeg;
  private LinearLayout yeh;
  private TextView yei;
  private TextView yej;
  private TextView yek;
  private TextView yel;
  private TextView yem;
  protected ViewGroup yen;
  protected ImageView yeo;
  protected TextView yep;
  protected TextView yeq;
  protected ImageView yer;
  protected Button yes;
  protected TextView yet;
  protected TextView yeu;
  protected View yev;
  protected View yew;
  protected View yex;
  protected Button yey;
  protected TextView yez;
  
  public RemittanceDetailUI()
  {
    AppMethodBeat.i(68156);
    this.xWi = null;
    this.ydZ = null;
    this.yea = null;
    this.yeb = null;
    this.yec = null;
    this.yed = null;
    this.vvt = null;
    this.yey = null;
    this.yez = null;
    this.yeM = null;
    this.yeN = null;
    this.yaO = null;
    this.yeO = null;
    this.yaH = null;
    this.yeP = 3;
    this.yeQ = false;
    this.yeU = new com.tencent.mm.sdk.b.c() {};
    this.yeV = new com.tencent.mm.sdk.b.c() {};
    this.nZK = null;
    this.yeW = 0;
    this.qlC = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(68135);
        ClipboardManager localClipboardManager = (ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
        paramAnonymousMenuItem = "";
        if (bt.jx(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131304016)) {
          paramAnonymousMenuItem = RemittanceDetailUI.o(RemittanceDetailUI.this).getText().toString().trim();
        }
        do
        {
          for (;;)
          {
            localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
            com.tencent.mm.ui.base.h.cl(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131755702));
            AppMethodBeat.o(68135);
            return;
            if (bt.jx(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131303989))
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
            if (!bt.jx(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131304015)) {
              break;
            }
            paramAnonymousMenuItem = RemittanceDetailUI.q(RemittanceDetailUI.this).getText().toString().trim();
          }
        } while (!bt.jx(RemittanceDetailUI.n(RemittanceDetailUI.this), 2131303990));
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
    this.rAi = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68138);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$20", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$20", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(68138);
          return false;
          RemittanceDetailUI.a(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawX());
          RemittanceDetailUI.b(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.rAj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68139);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$21", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.d("MicroMsg.RemittanceDetailUI", "onLongClick");
        if (RemittanceDetailUI.s(RemittanceDetailUI.this) == null) {
          RemittanceDetailUI.a(RemittanceDetailUI.this, new com.tencent.mm.ui.widget.b.a(RemittanceDetailUI.this.getContext()));
        }
        RemittanceDetailUI.s(RemittanceDetailUI.this).a(paramAnonymousView, RemittanceDetailUI.this, RemittanceDetailUI.t(RemittanceDetailUI.this), RemittanceDetailUI.u(RemittanceDetailUI.this), RemittanceDetailUI.v(RemittanceDetailUI.this));
        RemittanceDetailUI.c(RemittanceDetailUI.this, paramAnonymousView.getId());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$21", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(68139);
        return true;
      }
    };
    AppMethodBeat.o(68156);
  }
  
  private void a(v paramv)
  {
    AppMethodBeat.i(68171);
    if ("confirm".equals(paramv.xYm))
    {
      Of(1);
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
      this.yee.setVisibility(8);
      this.yeA.setVisibility(0);
      if (!bt.isNullOrNil(paramy.xZq.xZx))
      {
        this.yeB.setVisibility(0);
        if (!bt.isNullOrNil(paramy.desc))
        {
          this.yeC.setVisibility(0);
          this.yeG.setText(paramy.desc);
          this.yeG.setOnLongClickListener(this.rAj);
          this.yeG.setOnTouchListener(this.rAi);
          if (bt.isNullOrNil(paramy.xZq.xZx)) {
            break label449;
          }
          this.yeD.setVisibility(0);
          this.yeH.setText(paramy.xZq.xZx + "  " + paramy.xZq.jhp);
          this.yeF.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68155);
              int i = RemittanceResultNewUI.n(RemittanceDetailUI.this, paramy.xZq.hWY, RemittanceDetailUI.d(RemittanceDetailUI.this).getWidth());
              if (!bt.jx(i, paramy.xZq.hWY.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131762447);
                String str2 = paramy.xZq.hWY.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.wFm = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.e(RemittanceDetailUI.this).setOnTouchListener(a.dJj());
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131762446);
                str2 = paramy.xZq.hWY + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.wFm = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.f(RemittanceDetailUI.this).setOnTouchListener(a.dJj());
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
                RemittanceDetailUI.e(RemittanceDetailUI.this).setText(paramy.xZq.hWY);
                RemittanceDetailUI.f(RemittanceDetailUI.this).setText(paramy.xZq.hWY);
              }
            }
          });
          label180:
          if ((!paramBoolean2) || (bt.isNullOrNil(paramy.xZr.dDH))) {
            break label770;
          }
          this.yee.setVisibility(0);
          this.yef.setVisibility(0);
          this.yex.setVisibility(0);
          this.yen.setVisibility(0);
          this.yev.setVisibility(0);
          com.tencent.mm.aw.a.a.aIP().loadImage(paramy.xZr.dDH, this.yeo);
          this.yep.setText(paramy.xZr.name);
          this.yeq.setText(paramy.xZr.dxD);
          if (paramy.xZr.xZy <= 0) {
            break label718;
          }
          this.yes.setText(paramy.xZr.xZz);
          this.yer.setVisibility(8);
          this.yes.setVisibility(0);
          this.yes.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68126);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.xZr.xZA, paramy, 11);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68126);
            }
          });
          com.tencent.mm.wallet_core.ui.e.aW(this.yes, 200);
          label349:
          if (!bt.isNullOrNil(paramy.xZs.dxD)) {
            break label800;
          }
          this.yet.setVisibility(8);
          label371:
          if (!bt.isNullOrNil(paramy.xZu.dxD)) {
            break label841;
          }
          this.yeu.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      p.a(this, (ScrollView)findViewById(2131304251), findViewById(2131303141), findViewById(2131304020), findViewById(2131304030), 72);
      AppMethodBeat.o(68166);
      return;
      this.yeC.setVisibility(8);
      break;
      label449:
      this.yeD.setVisibility(8);
      break label180;
      this.yeB.setVisibility(8);
      break label180;
      this.yee.setVisibility(0);
      this.yeA.setVisibility(8);
      if (!bt.isNullOrNil(paramy.xZq.xZx))
      {
        this.yef.setVisibility(0);
        if (!bt.isNullOrNil(paramy.desc))
        {
          this.yeg.setVisibility(0);
          this.yej.setText(paramy.desc);
          this.yej.setOnLongClickListener(this.rAj);
          this.yej.setOnTouchListener(this.rAi);
        }
        for (;;)
        {
          if (bt.isNullOrNil(paramy.xZq.xZx)) {
            break label658;
          }
          this.yav.setVisibility(0);
          this.yek.setText(paramy.xZq.xZx + "  " + paramy.xZq.jhp);
          this.yei.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68125);
              int i = RemittanceResultNewUI.n(RemittanceDetailUI.this, paramy.xZq.hWY, RemittanceDetailUI.j(RemittanceDetailUI.this).getWidth());
              if (!bt.jx(i, paramy.xZq.hWY.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131762447);
                String str2 = paramy.xZq.hWY.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.wFm = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.k(RemittanceDetailUI.this).setOnTouchListener(a.dJj());
                RemittanceDetailUI.k(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131762446);
                str2 = paramy.xZq.hWY + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.wFm = new com.tencent.mm.plugin.order.c.a.a()
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
                RemittanceDetailUI.l(RemittanceDetailUI.this).setOnTouchListener(a.dJj());
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
                RemittanceDetailUI.k(RemittanceDetailUI.this).setText(paramy.xZq.hWY);
                RemittanceDetailUI.l(RemittanceDetailUI.this).setText(paramy.xZq.hWY);
              }
            }
          });
          break;
          this.yeg.setVisibility(8);
        }
        label658:
        this.yav.setVisibility(8);
        break label180;
      }
      this.yew.setVisibility(8);
      this.yeg.setVisibility(8);
      this.yav.setVisibility(8);
      this.yex.setVisibility(8);
      this.yef.setVisibility(8);
      break label180;
      label718:
      this.yer.setVisibility(0);
      this.yes.setVisibility(8);
      this.yer.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68127);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.xZr.xZA, paramy, 11);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68127);
        }
      });
      this.yen.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68128);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.xZr.xZA, paramy, 11);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68128);
        }
      });
      break label349;
      label770:
      this.yex.setVisibility(8);
      this.yen.setVisibility(8);
      this.yev.setVisibility(8);
      break label349;
      label800:
      this.yet.setText(paramy.xZs.dxD);
      this.yet.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.xZs.xZA, paramy, 12);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68129);
        }
      });
      this.yet.setVisibility(0);
      break label371;
      label841:
      this.yeu.setText(paramy.xZu.dxD);
      this.yeu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.xZu.xZA, paramy, 13);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68130);
        }
      });
      this.yeu.setVisibility(0);
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
  
  public static String bE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68174);
    String str = com.tencent.mm.wallet_core.ui.e.zf(paramString);
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
  
  private void dJt()
  {
    AppMethodBeat.i(68169);
    if ((this.yeS != 0) && (this.yaI == 1) && (!bt.isNullOrNil(this.yaH)))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68140);
          com.tencent.mm.wallet_core.ui.e.o(RemittanceDetailUI.this.getContext(), RemittanceDetailUI.w(RemittanceDetailUI.this), false);
          AppMethodBeat.o(68140);
          return false;
        }
      });
      AppMethodBeat.o(68169);
      return;
    }
    ad.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[] { Integer.valueOf(this.yeS), Boolean.valueOf(bt.isNullOrNil(this.yaH)) });
    removeAllOptionMenu();
    AppMethodBeat.o(68169);
  }
  
  protected void Of(int paramInt)
  {
    AppMethodBeat.i(68160);
    doSceneProgress(new y(paramInt, this.yeM, this.yaO, this.yeK), true);
    AppMethodBeat.o(68160);
  }
  
  protected void Og(int paramInt)
  {
    AppMethodBeat.i(68162);
    if (!getIntent().getBooleanExtra("is_sender", false)) {}
    for (com.tencent.mm.plugin.order.model.h localh = new com.tencent.mm.plugin.order.model.h(this.yaO, this.yeO, paramInt);; localh = new com.tencent.mm.plugin.order.model.h(this.yeM, this.yeO, paramInt))
    {
      localh.setProcessName("RemittanceProcess");
      doSceneProgress(localh);
      AppMethodBeat.o(68162);
      return;
    }
  }
  
  protected void aH(Intent paramIntent)
  {
    AppMethodBeat.i(68163);
    com.tencent.mm.bs.d.b(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
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
  
  protected void dJO()
  {
    AppMethodBeat.i(68164);
    v localv = new v(this.yeM, this.yaO, this.yeR, "confirm", this.yeN, this.yeK);
    localv.setProcessName("RemittanceProcess");
    doSceneProgress(localv);
    AppMethodBeat.o(68164);
  }
  
  protected void dJP()
  {
    AppMethodBeat.i(68165);
    v localv = new v(this.yeM, this.yaO, this.yeR, "refuse", this.yeN, this.yeK);
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
    if ((this.yeT != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.yeT, localBundle, true, 1008)))
    {
      this.yeT = null;
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
    this.xWi = ((ImageView)findViewById(2131304024));
    this.ydZ = ((TextView)findViewById(2131304029));
    this.yea = ((TextView)findViewById(2131304025));
    this.yed = ((Button)findViewById(2131304021));
    this.vvt = ((TextView)findViewById(2131304026));
    this.yee = ((LinearLayout)findViewById(2131304023));
    this.yef = ((LinearLayout)findViewById(2131304043));
    this.yeg = ((LinearLayout)findViewById(2131304014));
    this.yav = ((LinearLayout)findViewById(2131303987));
    this.yeh = ((LinearLayout)findViewById(2131303989));
    this.yei = ((TextView)findViewById(2131304019));
    this.yej = ((TextView)findViewById(2131304016));
    this.yek = ((TextView)findViewById(2131302665));
    this.yel = ((TextView)findViewById(2131296478));
    this.yem = ((TextView)findViewById(2131296477));
    this.yen = ((ViewGroup)findViewById(2131304054));
    this.yeo = ((ImageView)findViewById(2131304056));
    this.yep = ((TextView)findViewById(2131304058));
    this.yeq = ((TextView)findViewById(2131304059));
    this.yer = ((ImageView)findViewById(2131304053));
    this.yes = ((Button)findViewById(2131302852));
    this.yet = ((TextView)findViewById(2131304011));
    this.yeu = ((TextView)findViewById(2131304052));
    this.yev = findViewById(2131304057);
    this.yew = findViewById(2131304044);
    this.yex = findViewById(2131304045);
    this.yey = ((Button)findViewById(2131304022));
    this.yez = ((TextView)findViewById(2131304027));
    this.yeA = ((LinearLayout)findViewById(2131304028));
    this.yeB = ((LinearLayout)findViewById(2131304046));
    this.yeC = ((LinearLayout)findViewById(2131304017));
    this.yeD = ((LinearLayout)findViewById(2131303991));
    this.yeE = ((LinearLayout)findViewById(2131303990));
    this.yeF = ((TextView)findViewById(2131304018));
    this.yeG = ((TextView)findViewById(2131304015));
    this.yeH = ((TextView)findViewById(2131302664));
    this.yeI = ((TextView)findViewById(2131296475));
    this.yeJ = ((TextView)findViewById(2131296476));
    this.yeb = ((TextView)findViewById(2131304031));
    this.yec = ((TextView)findViewById(2131304032));
    AppMethodBeat.o(68161);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68159);
    ad.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      Of(0);
    }
    AppMethodBeat.o(68159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68157);
    super.onCreate(paramBundle);
    this.yeK = getIntent().getIntExtra("invalid_time", 0);
    this.yeL = getIntent().getIntExtra("appmsg_type", 0);
    this.yeM = getIntent().getStringExtra("transaction_id");
    this.yeO = getIntent().getStringExtra("bill_id");
    this.yaO = getIntent().getStringExtra("transfer_id");
    this.yeN = getIntent().getStringExtra("sender_name");
    this.yeP = getIntent().getIntExtra("effective_date", 3);
    this.yeQ = getIntent().getBooleanExtra("is_sender", false);
    this.yeR = getIntent().getIntExtra("total_fee", 0);
    initView();
    Of(0);
    getIntent();
    com.tencent.mm.sdk.b.a.IbL.c(this.yeU);
    this.yeV.alive();
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
    com.tencent.mm.sdk.b.a.IbL.d(this.yeU);
    if (this.yeV != null) {
      this.yeV.dead();
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
          if (localy.uHs)
          {
            this.wDb = com.tencent.mm.model.u.aAm();
            this.wCU = this.yeN;
            bool = com.tencent.mm.model.u.aAm().equals(this.wCU);
            this.yed.setVisibility(8);
            this.yea.setText(com.tencent.mm.wallet_core.ui.e.d(localy.paV, localy.wCF));
            paramn = localy.xZn;
            paramString = paramn;
            if (!bt.isNullOrNil(paramn))
            {
              paramString = paramn;
              if (paramn.contains("%s")) {
                paramString = paramn.trim().replace("%s", bE(this.wCU, true));
              }
            }
            paramn = localy.xZo;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.yeM);
            ((Bundle)localObject).putString("receiver_name", this.wCU);
            ((Bundle)localObject).putString("transfer_id", this.yaO);
            ((Bundle)localObject).putInt("total_fee", this.yeR);
            ((Bundle)localObject).putString("sender_name", this.yeN);
            ((Bundle)localObject).putInt("invalid_time", this.yeK);
            ((Bundle)localObject).putParcelable("resend_msg_info", localy.xZt);
            this.vvt.setClickable(true);
            this.ydZ.setClickable(true);
            this.yez.setClickable(true);
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
            if (!bt.isNullOrNil(localy.xZv)) {
              com.tencent.mm.wallet_core.ui.e.a((TextView)findViewById(2131297186), "7", localy.xZv, localy.xZw);
            }
            this.yeS = localy.xZp;
            com.tencent.mm.kernel.g.ajD();
            this.yaH = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ixq, ""));
            com.tencent.mm.kernel.g.ajD();
            this.yaI = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ixr, Integer.valueOf(0))).intValue();
            if (bt.isNullOrNil(this.yaH))
            {
              com.tencent.mm.plugin.wallet_core.c.aj.a(true, this.mNetSceneMgr);
              label465:
              dJt();
              if (localy.wDn == 1)
              {
                com.tencent.mm.kernel.g.ajD();
                if (!((String)com.tencent.mm.kernel.g.ajC().ajl().get(327729, "0")).equals("0")) {
                  break label3325;
                }
                paramString = getContext();
                if (!com.tencent.mm.model.u.aAB()) {
                  break label3318;
                }
                paramInt1 = 2131757192;
                label524:
                com.tencent.mm.ui.base.h.a(paramString, paramInt1, 2131765801, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(68141);
                    com.tencent.mm.ui.base.h.cl(RemittanceDetailUI.this.getContext(), RemittanceDetailUI.this.getString(2131762455));
                    AppMethodBeat.o(68141);
                  }
                });
                com.tencent.mm.kernel.g.ajD();
                com.tencent.mm.kernel.g.ajC().ajl().set(327729, "1");
              }
            }
            break;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          this.wDb = this.yeN;
          this.wCU = com.tencent.mm.model.u.aAm();
          break;
          if (!bool) {
            if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
            {
              this.ydZ.setText(k.a(this, paramString, (int)this.ydZ.getTextSize(), localObject));
              this.vvt.setText(k.a(this, paramn, (int)this.vvt.getTextSize(), localObject));
              this.ydZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.vvt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label679:
              a(false, false, localy);
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.xWi.setImageDrawable(ao.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZj) }));
            this.yeb.setVisibility(0);
            this.yec.setVisibility(8);
            break;
            paramString = getString(2131762474, new Object[] { bE(this.wCU, true) });
            this.ydZ.setText(k.b(this, paramString, this.ydZ.getTextSize()));
            paramString = getString(2131762480, new Object[] { Integer.valueOf(this.yeP) });
            paramn = getString(2131762516);
            localObject = new SpannableString(paramString + paramn);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.wFm = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68145);
                new d(RemittanceDetailUI.this).a(localy.xZt, new f.c()
                {
                  public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(68144);
                    if (paramAnonymous2Boolean)
                    {
                      paramAnonymous2String = new Intent();
                      paramAnonymous2String.putExtra("transaction_id", RemittanceDetailUI.this.yeM);
                      paramAnonymous2String.putExtra("transfer_id", RemittanceDetailUI.this.yaO);
                      paramAnonymous2String.putExtra("receiver_name", RemittanceDetailUI.b(RemittanceDetailUI.this));
                      paramAnonymous2String.putExtra("resend_msg_from_flag", 3);
                      RemittanceDetailUI.this.aH(paramAnonymous2String);
                    }
                    AppMethodBeat.o(68144);
                  }
                });
                AppMethodBeat.o(68145);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramn.length(), 33);
            this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
            this.vvt.setText((CharSequence)localObject);
            break label679;
            this.xWi.setImageDrawable(ao.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            this.yey.setVisibility(0);
            this.yey.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68147);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(9, 4);
                t.eFs();
                paramAnonymousView = RemittanceDetailUI.this;
                localObject = RemittanceDetailUI.c(RemittanceDetailUI.this);
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a()
                {
                  public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(68146);
                    if (paramAnonymous2Int1 == 2)
                    {
                      RemittanceDetailUI.this.dJO();
                      AppMethodBeat.o(68146);
                      return true;
                    }
                    if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean)) {
                      RemittanceDetailUI.this.dJO();
                    }
                    AppMethodBeat.o(68146);
                    return true;
                  }
                };
                if (!t.a(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject)) {
                  RemittanceDetailUI.this.dJO();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68147);
              }
            });
            if ((bt.isNullOrNil(paramString)) || (bt.isNullOrNil(paramn))) {
              break label1089;
            }
            this.ydZ.setText(k.a(this, paramString, (int)this.ydZ.getTextSize(), localObject));
            this.yez.setText(k.a(this, paramn, (int)this.yez.getTextSize(), localObject));
            this.ydZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.yez.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            a(true, false, localy);
          }
          label1089:
          this.ydZ.setText(2131762473);
          if (localy.xZp != 0) {
            if (!bt.isNullOrNil(localy.xZo)) {
              paramString = localy.xZo;
            }
          }
          for (;;)
          {
            paramn = getString(2131762465);
            localObject = new SpannableString(paramString + paramn);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.wFm = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68149);
                com.tencent.mm.ui.base.h.e(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131762461, new Object[] { RemittanceDetailUI.bE(localy.xZl, false) }), RemittanceDetailUI.this.getString(2131755873), RemittanceDetailUI.this.getString(2131762466), RemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(68148);
                    RemittanceDetailUI.this.dJP();
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
            this.yez.setMovementMethod(LinkMovementMethod.getInstance());
            this.yez.setText((CharSequence)localObject);
            break;
            ad.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localy.xZp == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(2131762475, new Object[] { paramString });
              paramn = getString(2131762476, new Object[] { Integer.valueOf(this.yeP) });
              paramString = paramString + paramn;
              break;
            }
            paramString = getString(2131762476, new Object[] { Integer.valueOf(this.yeP) });
          }
          this.xWi.setImageDrawable(ao.k(getContext(), 2131690392, getContext().getResources().getColor(2131099699)));
          if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
          {
            this.ydZ.setText(k.a(this, paramString, (int)this.ydZ.getTextSize(), localObject));
            this.vvt.setText(k.a(this, paramn, (int)this.vvt.getTextSize(), localObject));
            this.ydZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.vvt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            label1465:
            if (!bool) {
              break label1722;
            }
            a(false, true, localy);
          }
          for (;;)
          {
            this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZj) }));
            this.yeb.setVisibility(0);
            this.yec.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZm) }));
            this.yec.setVisibility(0);
            break;
            if (bool)
            {
              this.ydZ.setText(2131762468);
              paramString = new SpannableStringBuilder(getString(2131762449));
              paramn = new com.tencent.mm.plugin.order.c.a(this);
              paramn.wFm = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68150);
                  f.aw(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68150);
                }
              };
              paramString.setSpan(paramn, 0, paramString.length(), 18);
              this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
              this.vvt.setText(paramString);
              this.vvt.setVisibility(0);
              break label1465;
            }
            paramString = bE(this.wCU, true) + getString(2131762468);
            this.ydZ.setText(k.b(this, paramString, this.ydZ.getTextSize()));
            this.vvt.setText(2131762479);
            this.vvt.setVisibility(0);
            break label1465;
            label1722:
            a(false, false, localy);
          }
          if ((paramInt1 == 2003) && (!bool))
          {
            this.xWi.setImageResource(2131691097);
            if (!bt.isNullOrNil(paramString))
            {
              this.ydZ.setText(k.a(this, paramString, (int)this.ydZ.getTextSize(), localObject));
              this.ydZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label1798:
              if (bool) {
                break label2308;
              }
              if (bt.isNullOrNil(paramn)) {
                break label2102;
              }
              this.vvt.setText(k.a(this, paramn, (int)this.vvt.getTextSize(), localObject));
              this.vvt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              label1848:
              this.vvt.setVisibility(0);
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZj) }));
            this.yeb.setVisibility(0);
            this.yec.setText(getString(2131762460, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZm) }));
            this.yec.setVisibility(0);
            break;
            this.ydZ.setText(2131762472);
            break label1798;
            this.xWi.setImageDrawable(ao.k(getContext(), 2131690463, getContext().getResources().getColor(2131099829)));
            if (!bt.isNullOrNil(paramString))
            {
              this.ydZ.setText(k.a(this, paramString, (int)this.ydZ.getTextSize(), localObject));
              this.ydZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              break label1798;
            }
            if (bool)
            {
              this.ydZ.setText(2131762470);
              break label1798;
            }
            paramString = bE(this.wCU, true) + getString(2131762470);
            this.ydZ.setText(k.b(this, paramString, this.ydZ.getTextSize()));
            break label1798;
            label2102:
            if (("CFT".equals(localy.wDd)) || ("LQT".equals(localy.wDd)))
            {
              bool = "LQT".equals(localy.wDd);
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
                locala.wFm = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(68151);
                    if (bool)
                    {
                      com.tencent.mm.bs.d.Q(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                      AppMethodBeat.o(68151);
                      return;
                    }
                    f.aw(RemittanceDetailUI.this, 0);
                    AppMethodBeat.o(68151);
                  }
                };
                paramInt1 = paramString.length();
                paramInt2 = paramString.length();
                ((SpannableString)localObject).setSpan(locala, paramInt1, paramn.length() + paramInt2, 33);
                this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
                this.vvt.setText((CharSequence)localObject);
                break;
                paramString = getString(2131762462);
                break label2156;
              }
            }
            this.vvt.setText(2131762463);
            break label1848;
            label2308:
            this.vvt.setVisibility(8);
          }
          if (bool)
          {
            this.xWi.setImageDrawable(ao.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
            {
              this.ydZ.setText(k.a(this, paramString, (int)this.ydZ.getTextSize(), localObject));
              this.vvt.setText(k.a(this, paramn, (int)this.vvt.getTextSize(), localObject));
              this.ydZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.vvt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZj) }));
            this.yeb.setVisibility(0);
            this.yec.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZm) }));
            this.yec.setVisibility(0);
            break;
            if (!bt.isNullOrNil(localy.xZn)) {
              this.ydZ.setText(localy.xZn);
            }
            for (;;)
            {
              if (bt.isNullOrNil(localy.xZo)) {
                break label2590;
              }
              this.vvt.setText(localy.xZo);
              break;
              this.ydZ.setText(2131762469);
            }
            label2590:
            this.vvt.setText(2131762459);
            continue;
            this.xWi.setImageDrawable(ao.k(getContext(), 2131690487, getContext().getResources().getColor(2131099689)));
            if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
            {
              this.ydZ.setText(k.a(this, paramString, (int)this.ydZ.getTextSize(), localObject));
              this.vvt.setText(k.a(this, paramn, (int)this.vvt.getTextSize(), localObject));
              this.ydZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
              this.vvt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            }
            else
            {
              if (!bt.isNullOrNil(localy.xZn)) {}
              for (;;)
              {
                try
                {
                  this.ydZ.setText(String.format(localy.xZn, new Object[] { bE(this.wCU, true) }));
                  if (bt.isNullOrNil(localy.xZo)) {
                    break label2838;
                  }
                  this.vvt.setText(localy.xZo);
                }
                catch (Exception paramString)
                {
                  ad.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                }
                this.ydZ.setText(getString(2131762471, new Object[] { bE(this.wCU, true) }));
              }
              label2838:
              this.vvt.setText("");
            }
          }
          this.xWi.setImageResource(2131691094);
          if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
          {
            this.ydZ.setText(k.a(this, paramString, (int)this.ydZ.getTextSize(), localObject));
            this.vvt.setText(k.a(this, paramn, (int)this.vvt.getTextSize(), localObject));
            this.ydZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
            this.vvt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
          }
          for (;;)
          {
            a(false, false, localy);
            this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZj) }));
            this.yeb.setVisibility(0);
            if (localy.xZm <= 0) {
              break label3294;
            }
            this.yec.setText(getString(2131762448, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(localy.xZm) }));
            this.yec.setVisibility(0);
            break;
            if (!bt.isNullOrNil(localy.xZn))
            {
              this.ydZ.setText(localy.xZn);
              label3065:
              if (bt.isNullOrNil(localy.xZo)) {
                break label3263;
              }
              if ((!"CFT".equals(localy.wDd)) && (!"LQT".equals(localy.wDd))) {
                break label3248;
              }
              bool = "LQT".equals(localy.wDd);
              paramn = localy.xZo;
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
              paramString.wFm = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68152);
                  if (bool)
                  {
                    com.tencent.mm.bs.d.Q(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(68152);
                    return;
                  }
                  f.aw(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68152);
                }
              };
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramn.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
              this.vvt.setText((CharSequence)localObject);
              break;
              this.ydZ.setText(2131762467);
              break label3065;
            }
            label3248:
            this.vvt.setText(localy.xZo);
            continue;
            label3263:
            if (bool) {
              this.vvt.setText(2131762458);
            } else {
              this.vvt.setText(2131762478);
            }
          }
          label3294:
          this.yec.setVisibility(8);
          break label344;
          com.tencent.mm.plugin.wallet_core.c.aj.a(false, this.mNetSceneMgr);
          break label465;
          label3318:
          paramInt1 = 2131765800;
          break label524;
          label3325:
          if (this.yeS == 0) {
            com.tencent.mm.ui.base.h.cl(getContext(), getString(2131762455));
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
          this.yeT = ((v)paramn);
          if ((this.yeT.isJumpRemind()) && (this.yeT.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void djA()
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
          if (com.tencent.mm.plugin.wallet_core.utils.c.a(this.yeT.vqy))
          {
            new com.tencent.mm.plugin.wallet_core.utils.c(this).b(this.yeT.vqy);
            AppMethodBeat.o(68170);
            return true;
          }
          a(this.yeT);
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
        com.tencent.mm.ui.base.h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68143);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(68143);
          }
        });
        AppMethodBeat.o(68170);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.yaH = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).CPB;
          this.yaI = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).CPC;
          dJt();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */