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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.rp.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.remittance.model.y.a;
import com.tencent.mm.plugin.remittance.model.y.b;
import com.tencent.mm.plugin.remittance.model.y.c;
import com.tencent.mm.plugin.remittance.model.y.e;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.c.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class RemittanceDetailUI
  extends WalletBaseUI
{
  private String AOG;
  private String AOz;
  protected ImageView Cnb;
  private LinearLayout Cre;
  private String Crp;
  private int Crq;
  protected String Crw;
  protected TextView CuH;
  protected TextView CuI;
  protected TextView CuJ;
  protected TextView CuK;
  protected Button CuL;
  protected LinearLayout CuM;
  private LinearLayout CuN;
  private LinearLayout CuO;
  private LinearLayout CuP;
  private TextView CuQ;
  private TextView CuR;
  private TextView CuS;
  private TextView CuT;
  private TextView CuU;
  protected ViewGroup CuV;
  protected ImageView CuW;
  protected TextView CuX;
  protected TextView CuY;
  protected ImageView CuZ;
  private int CvA;
  private v CvB;
  private LinearLayout CvC;
  private LinearLayout CvD;
  private LinearLayout CvE;
  private LinearLayout CvF;
  private IListener<rp> CvG;
  private IListener<ro> CvH;
  private int CvI;
  protected Button Cva;
  protected TextView Cvb;
  protected TextView Cvc;
  protected View Cvd;
  protected View Cve;
  protected View Cvf;
  protected Button Cvg;
  protected TextView Cvh;
  protected LinearLayout Cvi;
  private LinearLayout Cvj;
  private LinearLayout Cvk;
  private LinearLayout Cvl;
  private LinearLayout Cvm;
  private TextView Cvn;
  private TextView Cvo;
  private TextView Cvp;
  private TextView Cvq;
  private TextView Cvr;
  protected int Cvs;
  protected int Cvt;
  public String Cvu;
  public String Cvv;
  protected String Cvw;
  protected int Cvx;
  protected boolean Cvy;
  protected int Cvz;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private o.g rJj;
  private View.OnTouchListener tia;
  private View.OnLongClickListener tib;
  protected TextView zcv;
  private com.tencent.mm.plugin.wallet_core.utils.c zdH;
  
  public RemittanceDetailUI()
  {
    AppMethodBeat.i(68156);
    this.Cnb = null;
    this.CuH = null;
    this.CuI = null;
    this.CuJ = null;
    this.CuK = null;
    this.CuL = null;
    this.zcv = null;
    this.Cvg = null;
    this.Cvh = null;
    this.Cvu = null;
    this.Cvv = null;
    this.Crw = null;
    this.Cvw = null;
    this.Crp = null;
    this.Cvx = 3;
    this.Cvy = false;
    this.CvG = new IListener() {};
    this.CvH = new IListener() {};
    this.pqr = null;
    this.CvI = 0;
    this.rJj = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(213801);
        paramAnonymousMenuItem = "";
        if (Util.isEqual(RemittanceDetailUI.p(RemittanceDetailUI.this), 2131306872)) {
          paramAnonymousMenuItem = RemittanceDetailUI.q(RemittanceDetailUI.this).getText().toString().trim();
        }
        do
        {
          for (;;)
          {
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
            com.tencent.mm.ui.base.h.cD(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131755773));
            AppMethodBeat.o(213801);
            return;
            if (Util.isEqual(RemittanceDetailUI.p(RemittanceDetailUI.this), 2131306845))
            {
              paramAnonymousMenuItem = new StringBuilder();
              paramAnonymousMenuItem.append(RemittanceDetailUI.r(RemittanceDetailUI.this).getText().toString().trim() + " ");
              str = RemittanceDetailUI.n(RemittanceDetailUI.this).getText().toString().trim();
              if (str.endsWith(RemittanceDetailUI.this.getString(2131764512))) {
                paramAnonymousMenuItem.append(str.substring(0, str.length() - 4));
              }
              for (;;)
              {
                paramAnonymousMenuItem = paramAnonymousMenuItem.toString();
                break;
                paramAnonymousMenuItem.append(str);
              }
            }
            if (!Util.isEqual(RemittanceDetailUI.p(RemittanceDetailUI.this), 2131306871)) {
              break;
            }
            paramAnonymousMenuItem = RemittanceDetailUI.s(RemittanceDetailUI.this).getText().toString().trim();
          }
        } while (!Util.isEqual(RemittanceDetailUI.p(RemittanceDetailUI.this), 2131306846));
        paramAnonymousMenuItem = new StringBuilder();
        paramAnonymousMenuItem.append(RemittanceDetailUI.t(RemittanceDetailUI.this).getText().toString().trim() + " ");
        String str = RemittanceDetailUI.h(RemittanceDetailUI.this).getText().toString().trim();
        if (str.endsWith(RemittanceDetailUI.this.getString(2131764512))) {
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
    this.tia = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(213802);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(213802);
          return false;
          RemittanceDetailUI.a(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawX());
          RemittanceDetailUI.b(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.tib = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213803);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$22", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.RemittanceDetailUI", "onLongClick");
        if (RemittanceDetailUI.u(RemittanceDetailUI.this) == null) {
          RemittanceDetailUI.a(RemittanceDetailUI.this, new com.tencent.mm.ui.widget.b.a(RemittanceDetailUI.this.getContext()));
        }
        RemittanceDetailUI.u(RemittanceDetailUI.this).a(paramAnonymousView, RemittanceDetailUI.this, RemittanceDetailUI.v(RemittanceDetailUI.this), RemittanceDetailUI.w(RemittanceDetailUI.this), RemittanceDetailUI.x(RemittanceDetailUI.this));
        RemittanceDetailUI.c(RemittanceDetailUI.this, paramAnonymousView.getId());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$22", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(213803);
        return true;
      }
    };
    AppMethodBeat.o(68156);
  }
  
  private void a(v paramv)
  {
    AppMethodBeat.i(68171);
    if ("confirm".equals(paramv.CoU))
    {
      Wg(1);
      AppMethodBeat.o(68171);
      return;
    }
    bY(0, getResources().getString(2131764522));
    AppMethodBeat.o(68171);
  }
  
  private void a(y paramy)
  {
    AppMethodBeat.i(213817);
    paramy = paramy.Cqd;
    if ((paramy == null) || (paramy.size() == 0))
    {
      this.CvD.setVisibility(8);
      Log.i("MicroMsg.RemittanceDetailUI", "mDescItemList == null || mDescItemList.size() ==0");
      AppMethodBeat.o(213817);
      return;
    }
    this.CvC.removeAllViews();
    this.CvD.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.CvD.getLayoutParams();
    if (!Util.isNullOrNil(this.zcv.getText()))
    {
      this.zcv.setVisibility(0);
      if (this.zcv.getVisibility() != 0) {
        break label232;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
      this.CvD.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      int i = 0;
      while (i < paramy.size())
      {
        localObject = (y.b)paramy.get(i);
        if (localObject != null)
        {
          LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131496099, this.CvC, false);
          ((TextView)localLinearLayout.findViewById(2131306885)).setText(((y.b)localObject).title);
          ((TextView)localLinearLayout.findViewById(2131306881)).setText(((y.b)localObject).content);
          this.CvC.addView(localLinearLayout);
        }
        i += 1;
      }
      this.zcv.setVisibility(8);
      break;
      label232:
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
      this.CvD.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(213817);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, final y paramy)
  {
    AppMethodBeat.i(68166);
    if (paramBoolean1)
    {
      this.CuM.setVisibility(8);
      this.CvE.setVisibility(8);
      this.Cvi.setVisibility(0);
      this.CvF.setVisibility(0);
      p.a(this, (ScrollView)findViewById(2131307173), findViewById(2131305783), findViewById(2131306876), findViewById(2131306891), 72);
      if (!Util.isNullOrNil(paramy.CpY.Cqg))
      {
        this.Cvj.setVisibility(0);
        if (!Util.isNullOrNil(paramy.desc))
        {
          this.Cvk.setVisibility(0);
          this.Cvo.setText(paramy.desc);
          this.Cvo.setOnLongClickListener(this.tib);
          this.Cvo.setOnTouchListener(this.tia);
          if (Util.isNullOrNil(paramy.CpY.Cqg)) {
            break label503;
          }
          this.Cvl.setVisibility(0);
          this.Cvp.setText(paramy.CpY.Cqg + "  " + paramy.CpY.kik);
          this.Cvn.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213792);
              int i = RemittanceResultNewUI.m(RemittanceDetailUI.this, paramy.CpY.iUO, RemittanceDetailUI.f(RemittanceDetailUI.this).getWidth());
              if (!Util.isEqual(i, paramy.CpY.iUO.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131764513);
                String str2 = paramy.CpY.iUO.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.AQT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(213790);
                    RemittanceDetailUI.g(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.h(RemittanceDetailUI.this).setVisibility(0);
                    p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131307173), RemittanceDetailUI.this.findViewById(2131305783), RemittanceDetailUI.this.findViewById(2131306876), RemittanceDetailUI.this.findViewById(2131306893), 72);
                    AppMethodBeat.o(213790);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.g(RemittanceDetailUI.this).setOnTouchListener(a.eNB());
                RemittanceDetailUI.g(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131764512);
                str2 = paramy.CpY.iUO + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.AQT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(213791);
                    RemittanceDetailUI.g(RemittanceDetailUI.this).setVisibility(0);
                    RemittanceDetailUI.h(RemittanceDetailUI.this).setVisibility(8);
                    p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131307173), RemittanceDetailUI.this.findViewById(2131305783), RemittanceDetailUI.this.findViewById(2131306876), RemittanceDetailUI.this.findViewById(2131306893), 72);
                    AppMethodBeat.o(213791);
                  }
                };
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.h(RemittanceDetailUI.this).setOnTouchListener(a.eNB());
                RemittanceDetailUI.h(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.g(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.h(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.j(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.i(RemittanceDetailUI.this));
                RemittanceDetailUI.j(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.k(RemittanceDetailUI.this));
                AppMethodBeat.o(213792);
                return;
                RemittanceDetailUI.g(RemittanceDetailUI.this).setText(paramy.CpY.iUO);
                RemittanceDetailUI.h(RemittanceDetailUI.this).setText(paramy.CpY.iUO);
              }
            }
          });
          label234:
          if ((!paramBoolean2) || (Util.isNullOrNil(paramy.CpZ.icon))) {
            break label841;
          }
          this.CuM.setVisibility(0);
          this.CvE.setVisibility(0);
          this.CuN.setVisibility(0);
          this.Cvf.setVisibility(0);
          this.CuV.setVisibility(0);
          this.Cvd.setVisibility(0);
          com.tencent.mm.av.a.a.bdb().loadImage(paramy.CpZ.icon, this.CuW);
          this.CuX.setText(paramy.CpZ.name);
          this.CuY.setText(paramy.CpZ.dQx);
          if (paramy.CpZ.Cqh <= 0) {
            break label789;
          }
          this.Cva.setText(paramy.CpZ.Cqi);
          this.CuZ.setVisibility(8);
          this.Cva.setVisibility(0);
          this.Cva.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68128);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.CpZ.Cqj, paramy, 11);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68128);
            }
          });
          com.tencent.mm.wallet_core.ui.f.aZ(this.Cva, 200);
          label411:
          if (!Util.isNullOrNil(paramy.Cqa.dQx)) {
            break label871;
          }
          this.Cvb.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      this.Cvc.setVisibility(8);
      a(paramy);
      p.a(this, (ScrollView)findViewById(2131307173), findViewById(2131305783), findViewById(2131306876), findViewById(2131306893), 72);
      AppMethodBeat.o(68166);
      return;
      this.Cvk.setVisibility(8);
      break;
      label503:
      this.Cvl.setVisibility(8);
      break label234;
      this.Cvj.setVisibility(8);
      break label234;
      this.CuM.setVisibility(0);
      this.CvE.setVisibility(0);
      this.Cvi.setVisibility(8);
      this.CvF.setVisibility(8);
      if (!Util.isNullOrNil(paramy.CpY.Cqg))
      {
        this.CuN.setVisibility(0);
        if (!Util.isNullOrNil(paramy.desc))
        {
          this.CuO.setVisibility(0);
          this.CuR.setText(paramy.desc);
          this.CuR.setOnLongClickListener(this.tib);
          this.CuR.setOnTouchListener(this.tia);
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramy.CpY.Cqg)) {
            break label729;
          }
          this.Cre.setVisibility(0);
          this.CuS.setText(paramy.CpY.Cqg + "  " + paramy.CpY.kik);
          this.CuQ.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213795);
              int i = RemittanceResultNewUI.m(RemittanceDetailUI.this, paramy.CpY.iUO, RemittanceDetailUI.l(RemittanceDetailUI.this).getWidth());
              if (!Util.isEqual(i, paramy.CpY.iUO.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(2131764513);
                String str2 = paramy.CpY.iUO.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.AQT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(213793);
                    RemittanceDetailUI.m(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.n(RemittanceDetailUI.this).setVisibility(0);
                    p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131307173), RemittanceDetailUI.this.findViewById(2131305783), RemittanceDetailUI.this.findViewById(2131306876), RemittanceDetailUI.this.findViewById(2131306893), 72);
                    AppMethodBeat.o(213793);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.m(RemittanceDetailUI.this).setOnTouchListener(a.eNB());
                RemittanceDetailUI.m(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(2131764512);
                str2 = paramy.CpY.iUO + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.AQT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(213794);
                    RemittanceDetailUI.m(RemittanceDetailUI.this).setVisibility(0);
                    RemittanceDetailUI.n(RemittanceDetailUI.this).setVisibility(8);
                    p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(2131307173), RemittanceDetailUI.this.findViewById(2131305783), RemittanceDetailUI.this.findViewById(2131306876), RemittanceDetailUI.this.findViewById(2131306893), 72);
                    AppMethodBeat.o(213794);
                  }
                };
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.n(RemittanceDetailUI.this).setOnTouchListener(a.eNB());
                RemittanceDetailUI.n(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.m(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.n(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.o(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.i(RemittanceDetailUI.this));
                RemittanceDetailUI.o(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.k(RemittanceDetailUI.this));
                AppMethodBeat.o(213795);
                return;
                RemittanceDetailUI.m(RemittanceDetailUI.this).setText(paramy.CpY.iUO);
                RemittanceDetailUI.n(RemittanceDetailUI.this).setText(paramy.CpY.iUO);
              }
            }
          });
          break;
          this.CuO.setVisibility(8);
        }
        label729:
        this.Cre.setVisibility(8);
        break label234;
      }
      this.Cve.setVisibility(8);
      this.CuO.setVisibility(8);
      this.Cre.setVisibility(8);
      this.Cvf.setVisibility(8);
      this.CuN.setVisibility(8);
      break label234;
      label789:
      this.CuZ.setVisibility(0);
      this.Cva.setVisibility(8);
      this.CuZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.CpZ.Cqj, paramy, 11);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68129);
        }
      });
      this.CuV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.CpZ.Cqj, paramy, 11);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68130);
        }
      });
      break label411;
      label841:
      this.Cvf.setVisibility(8);
      this.CuV.setVisibility(8);
      this.Cvd.setVisibility(8);
      break label411;
      label871:
      this.Cvb.setText(paramy.Cqa.dQx);
      this.Cvb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213796);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramy.Cqa.Cqj, paramy, 12);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213796);
        }
      });
      this.Cvb.setVisibility(0);
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
  
  public static String bZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68174);
    String str = com.tencent.mm.wallet_core.ui.f.getDisplayName(paramString);
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
  
  private void eNL()
  {
    AppMethodBeat.i(68169);
    if ((this.CvA != 0) && (this.Crq == 1) && (!Util.isNullOrNil(this.Crp)))
    {
      addIconOptionMenu(0, 2131235663, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(213804);
          com.tencent.mm.wallet_core.ui.f.p(RemittanceDetailUI.this.getContext(), RemittanceDetailUI.y(RemittanceDetailUI.this), false);
          AppMethodBeat.o(213804);
          return false;
        }
      });
      AppMethodBeat.o(68169);
      return;
    }
    Log.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[] { Integer.valueOf(this.CvA), Boolean.valueOf(Util.isNullOrNil(this.Crp)) });
    removeAllOptionMenu();
    AppMethodBeat.o(68169);
  }
  
  protected void Wg(int paramInt)
  {
    AppMethodBeat.i(68160);
    doSceneProgress(new y(paramInt, this.Cvu, this.Crw, this.Cvs), true);
    AppMethodBeat.o(68160);
  }
  
  protected void Wh(int paramInt)
  {
    AppMethodBeat.i(68162);
    if (!getIntent().getBooleanExtra("is_sender", false)) {}
    for (com.tencent.mm.plugin.order.model.h localh = new com.tencent.mm.plugin.order.model.h(this.Crw, this.Cvw, paramInt);; localh = new com.tencent.mm.plugin.order.model.h(this.Cvu, this.Cvw, paramInt))
    {
      localh.setProcessName("RemittanceProcess");
      doSceneProgress(localh);
      AppMethodBeat.o(68162);
      return;
    }
  }
  
  protected final void aMm(String paramString)
  {
    AppMethodBeat.i(213816);
    paramString = new v(this.Cvu, this.Crw, this.Cvz, "confirm", this.Cvv, this.Cvs, paramString);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    AppMethodBeat.o(213816);
  }
  
  protected void aQ(Intent paramIntent)
  {
    AppMethodBeat.i(68163);
    com.tencent.mm.br.c.b(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(68163);
  }
  
  protected final void bY(int paramInt, String paramString)
  {
    AppMethodBeat.i(68172);
    Intent localIntent = new Intent();
    localIntent.putExtra("result_msg", paramString);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(68172);
  }
  
  protected void eOg()
  {
    AppMethodBeat.i(68164);
    aMm("");
    AppMethodBeat.o(68164);
  }
  
  protected void eOh()
  {
    AppMethodBeat.i(68165);
    v localv = new v(this.Cvu, this.Crw, this.Cvz, "refuse", this.Cvv, this.Cvs);
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
    if ((this.CvB != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.CvB, localBundle, true, 1008)))
    {
      this.CvB = null;
      AppMethodBeat.o(68173);
      return;
    }
    super.finish();
    AppMethodBeat.o(68173);
  }
  
  public int getLayoutId()
  {
    return 2131496100;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68161);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.Cnb = ((ImageView)findViewById(2131306882));
    this.CuH = ((TextView)findViewById(2131306892));
    this.CuI = ((TextView)findViewById(2131306886));
    this.CuL = ((Button)findViewById(2131306877));
    this.zcv = ((TextView)findViewById(2131306887));
    this.CuM = ((LinearLayout)findViewById(2131306879));
    this.CuN = ((LinearLayout)findViewById(2131306906));
    this.CuO = ((LinearLayout)findViewById(2131306870));
    this.Cre = ((LinearLayout)findViewById(2131306843));
    this.CuP = ((LinearLayout)findViewById(2131306845));
    this.CuQ = ((TextView)findViewById(2131306875));
    this.CuR = ((TextView)findViewById(2131306872));
    this.CuS = ((TextView)findViewById(2131305219));
    this.CuT = ((TextView)findViewById(2131296552));
    this.CuU = ((TextView)findViewById(2131296551));
    this.CuV = ((ViewGroup)findViewById(2131306917));
    this.CuW = ((ImageView)findViewById(2131306919));
    this.CuX = ((TextView)findViewById(2131306921));
    this.CuY = ((TextView)findViewById(2131306922));
    this.CuZ = ((ImageView)findViewById(2131306916));
    this.Cva = ((Button)findViewById(2131305423));
    this.Cvb = ((TextView)findViewById(2131306867));
    this.Cvc = ((TextView)findViewById(2131306915));
    this.Cvd = findViewById(2131306920);
    this.Cve = findViewById(2131306907);
    this.Cvf = findViewById(2131306908);
    this.Cvg = ((Button)findViewById(2131306878));
    this.Cvh = ((TextView)findViewById(2131306888));
    this.Cvi = ((LinearLayout)findViewById(2131306889));
    this.Cvj = ((LinearLayout)findViewById(2131306909));
    this.Cvk = ((LinearLayout)findViewById(2131306873));
    this.Cvl = ((LinearLayout)findViewById(2131306847));
    this.Cvm = ((LinearLayout)findViewById(2131306846));
    this.Cvn = ((TextView)findViewById(2131306874));
    this.Cvo = ((TextView)findViewById(2131306871));
    this.Cvp = ((TextView)findViewById(2131305218));
    this.Cvq = ((TextView)findViewById(2131296549));
    this.Cvr = ((TextView)findViewById(2131296550));
    this.CuJ = ((TextView)findViewById(2131306894));
    this.CuK = ((TextView)findViewById(2131306895));
    this.CvC = ((LinearLayout)findViewById(2131306883));
    this.CvD = ((LinearLayout)findViewById(2131306880));
    this.CvE = ((LinearLayout)findViewById(2131306890));
    this.CvF = ((LinearLayout)findViewById(2131306891));
    AppMethodBeat.o(68161);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68159);
    Log.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      Wg(0);
    }
    AppMethodBeat.o(68159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68157);
    super.onCreate(paramBundle);
    this.zdH = new com.tencent.mm.plugin.wallet_core.utils.c(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(213810);
        if (RemittanceDetailUI.b(RemittanceDetailUI.this) == null)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(213810);
          return false;
        }
        if (RemittanceDetailUI.b(RemittanceDetailUI.this).zdG == null)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(213810);
          return false;
        }
        if (!com.tencent.mm.plugin.wallet_core.utils.c.a(RemittanceDetailUI.b(RemittanceDetailUI.this).zdG))
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(213810);
          return false;
        }
        RemittanceDetailUI.c(RemittanceDetailUI.this).a(RemittanceDetailUI.b(RemittanceDetailUI.this).zdG, new c.a()
        {
          public final void a(cfl paramAnonymous2cfl)
          {
            AppMethodBeat.i(213809);
            if (paramAnonymous2cfl.action == 1)
            {
              RemittanceDetailUI.this.finish();
              AppMethodBeat.o(213809);
              return;
            }
            AppMethodBeat.o(213809);
          }
        });
        RemittanceDetailUI.b(RemittanceDetailUI.this).zdG = null;
        AppMethodBeat.o(213810);
        return false;
      }
    });
    this.Cvs = getIntent().getIntExtra("invalid_time", 0);
    this.Cvt = getIntent().getIntExtra("appmsg_type", 0);
    this.Cvu = getIntent().getStringExtra("transaction_id");
    this.Cvw = getIntent().getStringExtra("bill_id");
    this.Crw = getIntent().getStringExtra("transfer_id");
    this.Cvv = getIntent().getStringExtra("sender_name");
    this.Cvx = getIntent().getIntExtra("effective_date", 3);
    this.Cvy = getIntent().getBooleanExtra("is_sender", false);
    this.Cvz = getIntent().getIntExtra("total_fee", 0);
    initView();
    Wg(0);
    getIntent();
    EventCenter.instance.addListener(this.CvG);
    this.CvH.alive();
    AppMethodBeat.o(68157);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(68168);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131755772));
    AppMethodBeat.o(68168);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68158);
    EventCenter.instance.removeListener(this.CvG);
    if (this.CvH != null) {
      this.CvH.dead();
    }
    super.onDestroy();
    AppMethodBeat.o(68158);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(213815);
    boolean bool;
    if (paramInt != 4)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(213815);
      return bool;
    }
    if (this.CvB == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(213815);
      return bool;
    }
    if (this.CvB.zdG == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(213815);
      return bool;
    }
    if (!com.tencent.mm.plugin.wallet_core.utils.c.a(this.CvB.zdG))
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(213815);
      return bool;
    }
    this.zdH.a(this.CvB.zdG, new c.a()
    {
      public final void a(cfl paramAnonymouscfl)
      {
        AppMethodBeat.i(213808);
        if (paramAnonymouscfl.action == 1)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(213808);
          return;
        }
        AppMethodBeat.o(213808);
      }
    });
    this.CvB.zdG = null;
    AppMethodBeat.o(213815);
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68170);
    final boolean bool;
    label2349:
    if ((paramq instanceof y))
    {
      final y localy = (y)paramq;
      label721:
      label1495:
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject;
        if (localy != null)
        {
          if (localy.ylG)
          {
            this.AOG = z.aTY();
            this.AOz = this.Cvv;
            bool = z.aTY().equals(this.AOz);
            this.CuL.setVisibility(8);
            this.CuI.setText(com.tencent.mm.wallet_core.ui.f.d(localy.qwJ, localy.AOl));
            this.CuI.setTextSize(1, 48.0F);
            paramq = localy.CpV;
            paramString = paramq;
            if (!Util.isNullOrNil(paramq))
            {
              paramString = paramq;
              if (paramq.contains("%s")) {
                paramString = paramq.trim().replace("%s", bZ(this.AOz, true));
              }
            }
            paramq = localy.CpW;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.Cvu);
            ((Bundle)localObject).putString("receiver_name", this.AOz);
            ((Bundle)localObject).putString("transfer_id", this.Crw);
            ((Bundle)localObject).putInt("total_fee", this.Cvz);
            ((Bundle)localObject).putString("sender_name", this.Cvv);
            ((Bundle)localObject).putInt("invalid_time", this.Cvs);
            ((Bundle)localObject).putParcelable("resend_msg_info", localy.Cqb);
            this.zcv.setClickable(true);
            this.CuH.setClickable(true);
            this.Cvh.setClickable(true);
            paramInt1 = localy.status;
            Log.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        else {
          switch (paramInt1)
          {
          default: 
            finish();
            label356:
            if (!Util.isNullOrNil(localy.Cqe)) {
              com.tencent.mm.wallet_core.ui.f.a((TextView)findViewById(2131297330), "7", localy.Cqe, localy.Cqf);
            }
            this.CvA = localy.CpX;
            com.tencent.mm.kernel.g.aAi();
            this.Crp = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NZQ, ""));
            com.tencent.mm.kernel.g.aAi();
            this.Crq = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NZR, Integer.valueOf(0))).intValue();
            if (Util.isNullOrNil(this.Crp))
            {
              aj.a(true, this.mNetSceneMgr);
              label477:
              eNL();
              if (localy.AOS == 1)
              {
                com.tencent.mm.kernel.g.aAi();
                if (((String)com.tencent.mm.kernel.g.aAh().azQ().get(327729, "0")).equals("0"))
                {
                  paramString = getContext();
                  if (!z.aUo()) {
                    break label3430;
                  }
                }
              }
            }
            break;
          }
        }
        label1119:
        label3430:
        for (paramInt1 = 2131757399;; paramInt1 = 2131768253)
        {
          com.tencent.mm.ui.base.h.a(paramString, paramInt1, 2131768254, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(327729, "1");
          AppMethodBeat.o(68170);
          return true;
          this.AOG = this.Cvv;
          this.AOz = z.aTY();
          break;
          if (!bool)
          {
            this.Cnb.setImageDrawable(ar.m(getContext(), 2131690692, getContext().getResources().getColor(2131099700)));
            if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramq)))
            {
              this.CuH.setText(l.a(this, paramString, (int)this.CuH.getTextSize(), localObject));
              this.zcv.setText(l.a(this, paramq, (int)this.zcv.getTextSize(), localObject));
              this.CuH.setOnTouchListener(new o());
              this.zcv.setOnTouchListener(new o());
              a(false, false, localy);
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpR) }));
            this.CuJ.setVisibility(0);
            this.CuJ.setVisibility(8);
            this.CuK.setVisibility(8);
            break;
            paramString = getString(2131764540, new Object[] { bZ(this.AOz, true) });
            this.CuH.setText(l.b(this, paramString, this.CuH.getTextSize()));
            paramString = getString(2131764546, new Object[] { Integer.valueOf(this.Cvx) });
            paramq = getString(2131764583);
            localObject = new SpannableString(paramString + paramq);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.AQT = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68149);
                new d(RemittanceDetailUI.this).a(localy.Cqb, new f.c()
                {
                  public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(213811);
                    if (paramAnonymous2Boolean)
                    {
                      paramAnonymous2String = new Intent();
                      paramAnonymous2String.putExtra("transaction_id", RemittanceDetailUI.this.Cvu);
                      paramAnonymous2String.putExtra("transfer_id", RemittanceDetailUI.this.Crw);
                      paramAnonymous2String.putExtra("receiver_name", RemittanceDetailUI.d(RemittanceDetailUI.this));
                      paramAnonymous2String.putExtra("resend_msg_from_flag", 3);
                      RemittanceDetailUI.this.aQ(paramAnonymous2String);
                    }
                    AppMethodBeat.o(213811);
                  }
                });
                AppMethodBeat.o(68149);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramq.length(), 33);
            this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
            this.zcv.setText((CharSequence)localObject);
            break label721;
            Log.i("MicroMsg.RemittanceDetailUI", "set click reveive btn");
            this.Cnb.setImageDrawable(ar.m(getContext(), 2131690919, getContext().getResources().getColor(2131099700)));
            this.Cvg.setVisibility(0);
            this.Cvg.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68150);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                Log.i("MicroMsg.RemittanceDetailUI", "click reveive btn");
                ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(9, 4);
                t.fQC();
                paramAnonymousView = RemittanceDetailUI.this;
                localObject = RemittanceDetailUI.e(RemittanceDetailUI.this);
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a()
                {
                  public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(213812);
                    Log.i("MicroMsg.RemittanceDetailUI", "resultCode :%s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                    if (paramAnonymous2Int1 == 2)
                    {
                      RemittanceDetailUI.this.eOg();
                      AppMethodBeat.o(213812);
                      return true;
                    }
                    if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean)) {
                      RemittanceDetailUI.this.eOg();
                    }
                    AppMethodBeat.o(213812);
                    return true;
                  }
                };
                boolean bool = t.a(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject);
                Log.i("MicroMsg.RemittanceDetailUI", "click reveive btn，ret :%s", new Object[] { Boolean.valueOf(bool) });
                if (!bool) {
                  RemittanceDetailUI.this.eOg();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68150);
              }
            });
            if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramq))) {
              break label1119;
            }
            this.CuH.setText(l.a(this, paramString, (int)this.CuH.getTextSize(), localObject));
            this.Cvh.setText(l.a(this, paramq, (int)this.Cvh.getTextSize(), localObject));
            this.CuH.setOnTouchListener(new o());
            this.Cvh.setOnTouchListener(new o());
            a(true, false, localy);
          }
          this.CuH.setText(2131764539);
          if (localy.CpX != 0) {
            if (!Util.isNullOrNil(localy.CpW)) {
              paramString = localy.CpW;
            }
          }
          for (;;)
          {
            paramq = getString(2131764531);
            localObject = new SpannableString(paramString + paramq);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.AQT = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68151);
                com.tencent.mm.ui.base.h.c(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131764527, new Object[] { RemittanceDetailUI.bZ(localy.CpT, false) }), RemittanceDetailUI.this.getString(2131755962), RemittanceDetailUI.this.getString(2131764532), RemittanceDetailUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(213813);
                    RemittanceDetailUI.this.eOh();
                    AppMethodBeat.o(213813);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(68151);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramq.length(), 33);
            this.Cvh.setMovementMethod(LinkMovementMethod.getInstance());
            this.Cvh.setText((CharSequence)localObject);
            break;
            Log.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localy.CpX == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(2131764541, new Object[] { paramString });
              paramq = getString(2131764542, new Object[] { Integer.valueOf(this.Cvx) });
              paramString = paramString + paramq;
              break;
            }
            paramString = getString(2131764542, new Object[] { Integer.valueOf(this.Cvx) });
          }
          this.Cnb.setImageDrawable(ar.m(getContext(), 2131690538, getContext().getResources().getColor(2131099710)));
          if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramq)))
          {
            this.CuH.setText(l.a(this, paramString, (int)this.CuH.getTextSize(), localObject));
            this.zcv.setText(l.a(this, paramq, (int)this.zcv.getTextSize(), localObject));
            this.CuH.setOnTouchListener(new o());
            this.zcv.setOnTouchListener(new o());
            if (!bool) {
              break label1770;
            }
            a(false, true, localy);
          }
          for (;;)
          {
            this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpR) }));
            this.CuJ.setVisibility(0);
            this.CuJ.setVisibility(8);
            this.CuK.setText(getString(2131764523, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpU) }));
            this.CuK.setVisibility(0);
            this.CuK.setVisibility(8);
            break;
            if (bool)
            {
              this.CuH.setText(2131764534);
              paramString = new SpannableStringBuilder(getString(2131764515));
              paramq = new com.tencent.mm.plugin.order.c.a(this);
              paramq.AQT = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68152);
                  com.tencent.mm.pluginsdk.wallet.f.aF(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68152);
                }
              };
              paramString.setSpan(paramq, 0, paramString.length(), 18);
              this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
              this.zcv.setText(paramString);
              this.zcv.setVisibility(0);
              break label1495;
            }
            paramString = bZ(this.AOz, true) + getString(2131764534);
            this.CuH.setText(l.b(this, paramString, this.CuH.getTextSize()));
            this.zcv.setText(2131764545);
            this.zcv.setVisibility(0);
            break label1495;
            label1770:
            a(false, false, localy);
          }
          if ((paramInt1 == 2003) && (!bool))
          {
            this.Cnb.setImageResource(2131691399);
            if (!Util.isNullOrNil(paramString))
            {
              this.CuH.setText(l.a(this, paramString, (int)this.CuH.getTextSize(), localObject));
              this.CuH.setOnTouchListener(new o());
              if (bool) {
                break label2374;
              }
              if (Util.isNullOrNil(paramq)) {
                break label2168;
              }
              this.zcv.setText(l.a(this, paramq, (int)this.zcv.getTextSize(), localObject));
              this.zcv.setOnTouchListener(new o());
              label1896:
              this.zcv.setVisibility(0);
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpR) }));
            this.CuJ.setVisibility(0);
            this.CuJ.setVisibility(8);
            this.CuK.setText(getString(2131764526, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpU) }));
            this.CuK.setVisibility(0);
            this.CuK.setVisibility(8);
            break;
            this.CuH.setText(2131764538);
            break label1846;
            this.Cnb.setImageDrawable(ar.m(getContext(), 2131690651, getContext().getResources().getColor(2131099845)));
            if (!Util.isNullOrNil(paramString))
            {
              this.CuH.setText(l.a(this, paramString, (int)this.CuH.getTextSize(), localObject));
              this.CuH.setOnTouchListener(new o());
              break label1846;
            }
            if (bool)
            {
              this.CuH.setText(2131764536);
              break label1846;
            }
            paramString = bZ(this.AOz, true) + getString(2131764536);
            this.CuH.setText(l.b(this, paramString, this.CuH.getTextSize()));
            break label1846;
            label2168:
            if (("CFT".equals(localy.AOI)) || ("LQT".equals(localy.AOI)))
            {
              bool = "LQT".equals(localy.AOI);
              if (bool)
              {
                paramString = getString(2131764530);
                if (!bool) {
                  break label2349;
                }
              }
              for (paramq = getString(2131764518);; paramq = getString(2131764515))
              {
                localObject = new SpannableString(paramString + paramq);
                locala = new com.tencent.mm.plugin.order.c.a(this);
                locala.AQT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(213814);
                    if (bool)
                    {
                      com.tencent.mm.br.c.V(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                      AppMethodBeat.o(213814);
                      return;
                    }
                    com.tencent.mm.pluginsdk.wallet.f.aF(RemittanceDetailUI.this, 0);
                    AppMethodBeat.o(213814);
                  }
                };
                paramInt1 = paramString.length();
                paramInt2 = paramString.length();
                ((SpannableString)localObject).setSpan(locala, paramInt1, paramq.length() + paramInt2, 33);
                this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
                this.zcv.setText((CharSequence)localObject);
                break;
                paramString = getString(2131764528);
                break label2222;
              }
            }
            this.zcv.setText(2131764529);
            break label1896;
            this.zcv.setVisibility(8);
          }
          if (bool)
          {
            this.Cnb.setImageDrawable(ar.m(getContext(), 2131690692, getContext().getResources().getColor(2131099700)));
            if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramq)))
            {
              this.CuH.setText(l.a(this, paramString, (int)this.CuH.getTextSize(), localObject));
              this.zcv.setText(l.a(this, paramq, (int)this.zcv.getTextSize(), localObject));
              this.CuH.setOnTouchListener(new o());
              this.zcv.setOnTouchListener(new o());
            }
          }
          for (;;)
          {
            a(false, false, localy);
            this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpR) }));
            this.CuJ.setVisibility(0);
            this.CuJ.setVisibility(8);
            this.CuK.setText(getString(2131764523, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpU) }));
            this.CuK.setVisibility(0);
            this.CuK.setVisibility(8);
            break;
            if (!Util.isNullOrNil(localy.CpV)) {
              this.CuH.setText(localy.CpV);
            }
            for (;;)
            {
              if (Util.isNullOrNil(localy.CpW)) {
                break label2674;
              }
              this.zcv.setText(localy.CpW);
              break;
              this.CuH.setText(2131764535);
            }
            label2674:
            this.zcv.setText(2131764525);
            this.zcv.setText("");
            continue;
            this.Cnb.setImageDrawable(ar.m(getContext(), 2131690692, getContext().getResources().getColor(2131099700)));
            if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramq)))
            {
              this.CuH.setText(l.a(this, paramString, (int)this.CuH.getTextSize(), localObject));
              this.zcv.setText(l.a(this, paramq, (int)this.zcv.getTextSize(), localObject));
              this.CuH.setOnTouchListener(new o());
              this.zcv.setOnTouchListener(new o());
            }
            else
            {
              if (!Util.isNullOrNil(localy.CpV)) {}
              for (;;)
              {
                try
                {
                  this.CuH.setText(String.format(localy.CpV, new Object[] { bZ(this.AOz, true) }));
                  if (Util.isNullOrNil(localy.CpW)) {
                    break label2932;
                  }
                  this.zcv.setText(localy.CpW);
                }
                catch (Exception paramString)
                {
                  Log.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                }
                this.CuH.setText(getString(2131764537, new Object[] { bZ(this.AOz, true) }));
              }
              label2932:
              this.zcv.setText("");
            }
          }
          this.Cnb.setImageResource(2131691396);
          if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramq)))
          {
            this.CuH.setText(l.a(this, paramString, (int)this.CuH.getTextSize(), localObject));
            this.zcv.setText(l.a(this, paramq, (int)this.zcv.getTextSize(), localObject));
            this.CuH.setOnTouchListener(new o());
            this.zcv.setOnTouchListener(new o());
          }
          for (;;)
          {
            a(false, false, localy);
            this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpR) }));
            this.CuJ.setVisibility(0);
            this.CuJ.setVisibility(8);
            if (localy.CpU <= 0) {
              break label3406;
            }
            this.CuK.setText(getString(2131764514, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(localy.CpU) }));
            this.CuK.setVisibility(0);
            this.CuK.setVisibility(8);
            break;
            if (!Util.isNullOrNil(localy.CpV))
            {
              this.CuH.setText(localy.CpV);
              label3177:
              if (Util.isNullOrNil(localy.CpW)) {
                break label3375;
              }
              if ((!"CFT".equals(localy.AOI)) && (!"LQT".equals(localy.AOI))) {
                break label3360;
              }
              bool = "LQT".equals(localy.AOI);
              paramq = localy.CpW;
              if (!bool) {
                break label3349;
              }
            }
            for (paramString = getString(2131764518);; paramString = getString(2131764515))
            {
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(paramq);
              ((SpannableStringBuilder)localObject).append(paramString);
              paramString = new com.tencent.mm.plugin.order.c.a(this);
              paramString.AQT = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(213789);
                  if (bool)
                  {
                    com.tencent.mm.br.c.V(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(213789);
                    return;
                  }
                  com.tencent.mm.pluginsdk.wallet.f.aF(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(213789);
                }
              };
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramq.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
              this.zcv.setText((CharSequence)localObject);
              break;
              this.CuH.setText(2131764533);
              break label3177;
            }
            this.zcv.setText(localy.CpW);
            continue;
            if (bool) {
              this.zcv.setText(2131764524);
            } else {
              this.zcv.setText(2131764544);
            }
          }
          this.CuK.setVisibility(8);
          break label356;
          aj.a(false, this.mNetSceneMgr);
          break label477;
        }
      }
    }
    else
    {
      label1846:
      label2374:
      label3406:
      if ((paramq instanceof v))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.CvB = ((v)paramq);
          if ((this.CvB.isJumpRemind()) && (this.CvB.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void eeY()
            {
              AppMethodBeat.i(213805);
              RemittanceDetailUI.a(RemittanceDetailUI.this, RemittanceDetailUI.b(RemittanceDetailUI.this));
              AppMethodBeat.o(213805);
            }
          })))
          {
            AppMethodBeat.o(68170);
            return true;
          }
          if (com.tencent.mm.plugin.wallet_core.utils.c.a(this.CvB.yXE))
          {
            new com.tencent.mm.plugin.wallet_core.utils.c(this).a(this.CvB.yXE, new c.a()
            {
              public final void a(cfl paramAnonymouscfl)
              {
                AppMethodBeat.i(213806);
                if (paramAnonymouscfl.action == 2)
                {
                  RemittanceDetailUI.this.aMm(RemittanceDetailUI.b(RemittanceDetailUI.this).yXG);
                  AppMethodBeat.o(213806);
                  return;
                }
                if (paramAnonymouscfl.action == 1)
                {
                  RemittanceDetailUI.this.finish();
                  AppMethodBeat.o(213806);
                  return;
                }
                AppMethodBeat.o(213806);
              }
            });
            AppMethodBeat.o(68170);
            return true;
          }
          a(this.CvB);
          AppMethodBeat.o(68170);
          return true;
        }
        if (paramInt2 == 416)
        {
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_plugin", "remittance");
          paramString.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramq, paramString, 1008);
          AppMethodBeat.o(68170);
          return bool;
        }
        paramq = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramq = getString(2131768354);
        }
        com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(213807);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(213807);
          }
        });
        AppMethodBeat.o(68170);
        return true;
      }
      label2222:
      label3375:
      if ((paramq instanceof aj))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.Crp = ((aj)paramq).HQy;
          this.Crq = ((aj)paramq).HQz;
          eNL();
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          Log.i("MicroMsg.RemittanceDetailUI", "net error");
        }
      }
    }
    label3349:
    label3360:
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
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