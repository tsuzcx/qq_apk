package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.uc;
import com.tencent.mm.autogen.a.ud;
import com.tencent.mm.autogen.a.ud.a;
import com.tencent.mm.autogen.a.vm;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.remittance.a.d;
import com.tencent.mm.plugin.remittance.model.ae;
import com.tencent.mm.plugin.remittance.model.ah;
import com.tencent.mm.plugin.remittance.model.ah.a;
import com.tencent.mm.plugin.remittance.model.ah.b;
import com.tencent.mm.plugin.remittance.model.ah.c;
import com.tencent.mm.plugin.remittance.model.ah.d;
import com.tencent.mm.plugin.remittance.model.ah.e;
import com.tencent.mm.plugin.remittance.model.al;
import com.tencent.mm.plugin.wallet.balance.model.lqt.y;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wallet_core.utils.j.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.model.g;
import com.tencent.mm.wallet_core.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.f.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(3)
public class RemittanceDetailUI
  extends WalletBaseUI
{
  private View.OnTouchListener AkU;
  private View.OnLongClickListener AkV;
  private j KBx;
  private String MED;
  private String MEK;
  protected ImageView OgG;
  private LinearLayout OlW;
  private String Omg;
  private int Omh;
  protected String Omn;
  protected View OqA;
  protected View OqB;
  protected View OqC;
  protected Button OqD;
  protected TextView OqE;
  protected LinearLayout OqF;
  private LinearLayout OqG;
  private LinearLayout OqH;
  private LinearLayout OqI;
  private LinearLayout OqJ;
  private TextView OqK;
  private TextView OqL;
  private TextView OqM;
  private TextView OqN;
  private TextView OqO;
  protected int OqP;
  protected int OqQ;
  protected String OqR;
  protected String OqS;
  protected String OqT;
  protected int OqU;
  protected boolean OqV;
  protected int OqW;
  private int OqX;
  private ae OqY;
  private LinearLayout OqZ;
  protected TextView Oqc;
  protected TextView Oqd;
  protected TextView Oqe;
  protected TextView Oqf;
  protected TextView Oqg;
  protected TextView Oqh;
  protected View Oqi;
  protected LinearLayout Oqj;
  private LinearLayout Oqk;
  private LinearLayout Oql;
  private LinearLayout Oqm;
  private TextView Oqn;
  private TextView Oqo;
  private TextView Oqp;
  private TextView Oqq;
  private TextView Oqr;
  protected ViewGroup Oqs;
  protected ImageView Oqt;
  protected TextView Oqu;
  protected TextView Oqv;
  protected ImageView Oqw;
  protected Button Oqx;
  protected TextView Oqy;
  protected TextView Oqz;
  private LinearLayout Ora;
  private RelativeLayout Orb;
  private LinearLayout Orc;
  private IListener<ud> Ord;
  private IListener<uc> Ore;
  private IListener<vm> Orf;
  private int Org;
  private String ciX;
  private long lul;
  private WcPayBannerView pLM;
  private com.tencent.mm.ui.widget.b.a vEV;
  private int x_down;
  private u.i yBn;
  private int y_down;
  
  public RemittanceDetailUI()
  {
    AppMethodBeat.i(68156);
    this.OgG = null;
    this.Oqc = null;
    this.Oqd = null;
    this.Oqe = null;
    this.Oqf = null;
    this.Oqg = null;
    this.Oqh = null;
    this.OqD = null;
    this.OqE = null;
    this.OqR = null;
    this.OqS = null;
    this.Omn = null;
    this.OqT = null;
    this.Omg = null;
    this.OqU = 3;
    this.OqV = false;
    this.Ord = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Ore = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Orf = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vEV = null;
    this.Org = 0;
    this.yBn = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(289146);
        paramAnonymousMenuItem = "";
        if (Util.isEqual(RemittanceDetailUI.r(RemittanceDetailUI.this), a.f.remittance_desc_content_tv)) {
          paramAnonymousMenuItem = RemittanceDetailUI.s(RemittanceDetailUI.this).getText().toString().trim();
        }
        do
        {
          for (;;)
          {
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
            com.tencent.mm.ui.base.k.cZ(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(a.i.app_copy_ok));
            AppMethodBeat.o(289146);
            return;
            if (Util.isEqual(RemittanceDetailUI.r(RemittanceDetailUI.this), a.f.remittance_address_content_lv))
            {
              paramAnonymousMenuItem = new StringBuilder();
              paramAnonymousMenuItem.append(RemittanceDetailUI.t(RemittanceDetailUI.this).getText().toString().trim() + " ");
              str = RemittanceDetailUI.p(RemittanceDetailUI.this).getText().toString().trim();
              if (str.endsWith(RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_collapse))) {
                paramAnonymousMenuItem.append(str.substring(0, str.length() - 4));
              }
              for (;;)
              {
                paramAnonymousMenuItem = paramAnonymousMenuItem.toString();
                break;
                paramAnonymousMenuItem.append(str);
              }
            }
            if (!Util.isEqual(RemittanceDetailUI.r(RemittanceDetailUI.this), a.f.remittance_desc_content_operate_tv)) {
              break;
            }
            paramAnonymousMenuItem = RemittanceDetailUI.u(RemittanceDetailUI.this).getText().toString().trim();
          }
        } while (!Util.isEqual(RemittanceDetailUI.r(RemittanceDetailUI.this), a.f.remittance_address_content_operate_lv));
        paramAnonymousMenuItem = new StringBuilder();
        paramAnonymousMenuItem.append(RemittanceDetailUI.v(RemittanceDetailUI.this).getText().toString().trim() + " ");
        String str = RemittanceDetailUI.j(RemittanceDetailUI.this).getText().toString().trim();
        if (str.endsWith(RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_collapse))) {
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
    this.AkU = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(289142);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(289142);
          return false;
          RemittanceDetailUI.a(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawX());
          RemittanceDetailUI.b(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.AkV = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(289147);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$24", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        Log.d("MicroMsg.RemittanceDetailUI", "onLongClick");
        if (RemittanceDetailUI.w(RemittanceDetailUI.this) == null) {
          RemittanceDetailUI.a(RemittanceDetailUI.this, new com.tencent.mm.ui.widget.b.a(RemittanceDetailUI.this.getContext()));
        }
        RemittanceDetailUI.w(RemittanceDetailUI.this).a(paramAnonymousView, RemittanceDetailUI.this, RemittanceDetailUI.x(RemittanceDetailUI.this), RemittanceDetailUI.y(RemittanceDetailUI.this), RemittanceDetailUI.z(RemittanceDetailUI.this));
        RemittanceDetailUI.c(RemittanceDetailUI.this, paramAnonymousView.getId());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$24", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(289147);
        return true;
      }
    };
    AppMethodBeat.o(68156);
  }
  
  private void a(ae paramae)
  {
    AppMethodBeat.i(68171);
    if ("confirm".equals(paramae.OjA))
    {
      ahp(1);
      AppMethodBeat.o(68171);
      return;
    }
    aUg(getResources().getString(a.i.remittance_detail_msg_refuse_suc));
    AppMethodBeat.o(68171);
  }
  
  private void a(ah paramah)
  {
    AppMethodBeat.i(289140);
    paramah = paramah.OkH;
    if ((paramah == null) || (paramah.size() == 0))
    {
      this.Ora.setVisibility(8);
      Log.i("MicroMsg.RemittanceDetailUI", "mDescItemList == null || mDescItemList.size() ==0");
      AppMethodBeat.o(289140);
      return;
    }
    this.OqZ.removeAllViews();
    this.Ora.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.Ora.getLayoutParams();
    if (!Util.isNullOrNil(this.Oqg.getText()))
    {
      this.Oqg.setVisibility(0);
      if ((!Util.isNullOrNil(this.Oqg.getText())) && (this.Oqg.getText().toString().equals(" "))) {
        this.Oqg.setImportantForAccessibility(2);
      }
      if (this.Oqg.getVisibility() != 0) {
        break label293;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 32);
      this.Ora.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      int i = 0;
      while (i < paramah.size())
      {
        localObject = (ah.b)paramah.get(i);
        if (localObject != null)
        {
          LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.g.remittance_detail_desc_item, this.OqZ, false);
          ((TextView)localLinearLayout.findViewById(a.f.remittance_detail_desc_title)).setText(((ah.b)localObject).title);
          final TextView localTextView = (TextView)localLinearLayout.findViewById(a.f.remittance_detail_desc_content);
          localTextView.setText(((ah.b)localObject).content);
          localTextView.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(289138);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
              paramAnonymousView = new com.tencent.mm.ui.widget.b.a(localTextView.getContext(), localTextView);
              paramAnonymousView.agjt = new View.OnCreateContextMenuListener()
              {
                public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
                {
                  AppMethodBeat.i(289154);
                  paramAnonymous2ContextMenu.add(paramAnonymous2View.getContext().getString(a.i.app_copy));
                  AppMethodBeat.o(289154);
                }
              };
              paramAnonymousView.GAC = new u.i()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(289158);
                  if (paramAnonymous2Int == 0)
                  {
                    ClipboardHelper.setText(RemittanceDetailUI.23.this.dwc.getText().toString());
                    com.tencent.mm.ui.base.k.cY(RemittanceDetailUI.23.this.dwc.getContext(), RemittanceDetailUI.23.this.dwc.getContext().getString(a.i.app_copy_ok));
                  }
                  AppMethodBeat.o(289158);
                }
              };
              paramAnonymousView.afLp = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss() {}
              };
              paramAnonymousView.fQ(0, 0);
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(289138);
              return false;
            }
          });
          this.OqZ.addView(localLinearLayout);
        }
        i += 1;
      }
      this.Oqg.setVisibility(8);
      break;
      label293:
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
      this.Ora.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(289140);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, final ah paramah)
  {
    AppMethodBeat.i(68166);
    label234:
    final ah.e locale;
    if (paramBoolean1)
    {
      this.Oqj.setVisibility(8);
      this.Orb.setVisibility(8);
      this.OqF.setVisibility(0);
      this.Orc.setVisibility(0);
      com.tencent.mm.ui.tools.p.a(this, (ScrollView)findViewById(a.f.root_view), findViewById(a.f.parent_view_rl), findViewById(a.f.remittance_detail_all_container), findViewById(a.f.remittance_detail_receive_ll), 72);
      if (!Util.isNullOrNil(paramah.OkC.OkL))
      {
        this.OqG.setVisibility(0);
        if (!Util.isNullOrNil(paramah.desc))
        {
          this.OqH.setVisibility(0);
          this.OqL.setText(paramah.desc);
          this.OqL.setOnLongClickListener(this.AkV);
          this.OqL.setOnTouchListener(this.AkU);
          if (Util.isNullOrNil(paramah.OkC.OkL)) {
            break label544;
          }
          this.OqI.setVisibility(0);
          this.OqM.setText(paramah.OkC.OkL + "  " + paramah.OkC.pWt);
          this.OqK.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(289224);
              int i = RemittanceResultNewUI.p(RemittanceDetailUI.this, paramah.OkC.oDI, RemittanceDetailUI.h(RemittanceDetailUI.this).getWidth());
              if (!Util.isEqual(i, paramah.OkC.oDI.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_expand);
                String str2 = paramah.OkC.oDI.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.MGT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(289056);
                    RemittanceDetailUI.i(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.j(RemittanceDetailUI.this).setVisibility(0);
                    com.tencent.mm.ui.tools.p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(a.f.root_view), RemittanceDetailUI.this.findViewById(a.f.parent_view_rl), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_all_container), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_tiem_desc), 72);
                    AppMethodBeat.o(289056);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.i(RemittanceDetailUI.this).setOnTouchListener(a.gMd());
                RemittanceDetailUI.i(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_collapse);
                str2 = paramah.OkC.oDI + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.MGT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(289053);
                    RemittanceDetailUI.i(RemittanceDetailUI.this).setVisibility(0);
                    RemittanceDetailUI.j(RemittanceDetailUI.this).setVisibility(8);
                    com.tencent.mm.ui.tools.p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(a.f.root_view), RemittanceDetailUI.this.findViewById(a.f.parent_view_rl), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_all_container), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_tiem_desc), 72);
                    AppMethodBeat.o(289053);
                  }
                };
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.j(RemittanceDetailUI.this).setOnTouchListener(a.gMd());
                RemittanceDetailUI.j(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.i(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.j(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.l(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.k(RemittanceDetailUI.this));
                RemittanceDetailUI.l(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.m(RemittanceDetailUI.this));
                AppMethodBeat.o(289224);
                return;
                RemittanceDetailUI.i(RemittanceDetailUI.this).setText(paramah.OkC.oDI);
                RemittanceDetailUI.j(RemittanceDetailUI.this).setText(paramah.OkC.oDI);
              }
            }
          });
          if ((!paramBoolean2) || (Util.isNullOrNil(paramah.OkD.icon))) {
            break label882;
          }
          this.Oqj.setVisibility(0);
          this.Orb.setVisibility(0);
          this.Oqk.setVisibility(0);
          this.OqC.setVisibility(0);
          this.Oqs.setVisibility(0);
          this.OqA.setVisibility(0);
          com.tencent.mm.modelimage.loader.a.bKl().loadImage(paramah.OkD.icon, this.Oqt);
          this.Oqu.setText(paramah.OkD.name);
          this.Oqv.setText(paramah.OkD.wording);
          if (paramah.OkD.OkM <= 0) {
            break label830;
          }
          this.Oqx.setText(paramah.OkD.OkN);
          this.Oqw.setVisibility(8);
          this.Oqx.setVisibility(0);
          this.Oqx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(289188);
              RemittanceDetailUI.a(RemittanceDetailUI.this, paramah.OkD.OkO, paramah, 11);
              AppMethodBeat.o(289188);
            }
          });
          com.tencent.mm.wallet_core.ui.i.bG(this.Oqx, 200);
          label411:
          locale = paramah.OkE;
          if ((locale != null) && (!Util.isNullOrNil(locale.wording))) {
            break label912;
          }
          label433:
          a(paramah);
          paramah = paramah.Kvc;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRh, false)) && (paramah != null) && (paramah.size() != 0)) {
            break label1087;
          }
          Log.i("MicroMsg.RemittanceDetailUI", "ComplaintEntrance is false || mTextInfoList == null || mTextInfoList.size() ==0");
          removeAllOptionMenu();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.p.a(this, (ScrollView)findViewById(a.f.root_view), findViewById(a.f.parent_view_rl), findViewById(a.f.remittance_detail_all_container), findViewById(a.f.remittance_detail_tiem_desc), 72);
      AppMethodBeat.o(68166);
      return;
      this.OqH.setVisibility(8);
      break;
      label544:
      this.OqI.setVisibility(8);
      break label234;
      this.OqG.setVisibility(8);
      break label234;
      this.Oqj.setVisibility(0);
      this.Orb.setVisibility(0);
      this.OqF.setVisibility(8);
      this.Orc.setVisibility(8);
      if (!Util.isNullOrNil(paramah.OkC.OkL))
      {
        this.Oqk.setVisibility(0);
        if (!Util.isNullOrNil(paramah.desc))
        {
          this.Oql.setVisibility(0);
          this.Oqo.setText(paramah.desc);
          this.Oqo.setOnLongClickListener(this.AkV);
          this.Oqo.setOnTouchListener(this.AkU);
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramah.OkC.OkL)) {
            break label770;
          }
          this.OlW.setVisibility(0);
          this.Oqp.setText(paramah.OkC.OkL + "  " + paramah.OkC.pWt);
          this.Oqn.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(289226);
              int i = RemittanceResultNewUI.p(RemittanceDetailUI.this, paramah.OkC.oDI, RemittanceDetailUI.n(RemittanceDetailUI.this).getWidth());
              if (!Util.isEqual(i, paramah.OkC.oDI.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_expand);
                String str2 = paramah.OkC.oDI.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.MGT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(288933);
                    RemittanceDetailUI.o(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.p(RemittanceDetailUI.this).setVisibility(0);
                    com.tencent.mm.ui.tools.p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(a.f.root_view), RemittanceDetailUI.this.findViewById(a.f.parent_view_rl), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_all_container), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_tiem_desc), 72);
                    AppMethodBeat.o(288933);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.o(RemittanceDetailUI.this).setOnTouchListener(a.gMd());
                RemittanceDetailUI.o(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_collapse);
                str2 = paramah.OkC.oDI + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.MGT = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(288934);
                    RemittanceDetailUI.o(RemittanceDetailUI.this).setVisibility(0);
                    RemittanceDetailUI.p(RemittanceDetailUI.this).setVisibility(8);
                    com.tencent.mm.ui.tools.p.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(a.f.root_view), RemittanceDetailUI.this.findViewById(a.f.parent_view_rl), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_all_container), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_tiem_desc), 72);
                    AppMethodBeat.o(288934);
                  }
                };
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.p(RemittanceDetailUI.this).setOnTouchListener(a.gMd());
                RemittanceDetailUI.p(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.o(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.p(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.q(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.k(RemittanceDetailUI.this));
                RemittanceDetailUI.q(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.m(RemittanceDetailUI.this));
                AppMethodBeat.o(289226);
                return;
                RemittanceDetailUI.o(RemittanceDetailUI.this).setText(paramah.OkC.oDI);
                RemittanceDetailUI.p(RemittanceDetailUI.this).setText(paramah.OkC.oDI);
              }
            }
          });
          break;
          this.Oql.setVisibility(8);
        }
        label770:
        this.OlW.setVisibility(8);
        break label234;
      }
      this.OqB.setVisibility(8);
      this.Oql.setVisibility(8);
      this.OlW.setVisibility(8);
      this.OqC.setVisibility(8);
      this.Oqk.setVisibility(8);
      break label234;
      label830:
      this.Oqw.setVisibility(0);
      this.Oqx.setVisibility(8);
      this.Oqw.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(289192);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramah.OkD.OkO, paramah, 11);
          AppMethodBeat.o(289192);
        }
      });
      this.Oqs.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(289182);
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramah.OkD.OkO, paramah, 11);
          AppMethodBeat.o(289182);
        }
      });
      break label411;
      label882:
      this.OqC.setVisibility(8);
      this.Oqs.setVisibility(8);
      this.OqA.setVisibility(8);
      break label411;
      label912:
      if ((this.Oqg.isShown()) && (!Util.isNullOrNil(this.Oqg.getText())))
      {
        this.Oqh.setVisibility(0);
        this.Oqi.setVisibility(0);
        ((RelativeLayout.LayoutParams)this.Oqg.getLayoutParams()).removeRule(13);
        com.tencent.mm.wallet_core.ui.i.a(this.Oqh, locale.wording, 0, locale.wording.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(289174);
            RemittanceDetailUI.a(RemittanceDetailUI.this, locale.OkO, paramah, 12);
            AppMethodBeat.o(289174);
          }
        }, false), this);
        break label433;
      }
      this.Oqh.setVisibility(8);
      this.Oqi.setVisibility(8);
      ((RelativeLayout.LayoutParams)this.Oqg.getLayoutParams()).addRule(13);
      com.tencent.mm.wallet_core.ui.i.a(this.Oqg, locale.wording, 0, locale.wording.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(289175);
          RemittanceDetailUI.a(RemittanceDetailUI.this, locale.OkO, paramah, 12);
          AppMethodBeat.o(289175);
        }
      }, false), this);
      break label433;
      label1087:
      addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(289133);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(RemittanceDetailUI.this, 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(289013);
              Iterator localIterator = RemittanceDetailUI.24.this.Ort.iterator();
              int i = 0;
              while (localIterator.hasNext())
              {
                ah.e locale = (ah.e)localIterator.next();
                if ((!Util.isNullOrNil(locale.wording)) && (locale.OkO != null) && (locale.OkO.type != 0))
                {
                  Log.i("MicroMsg.RemittanceDetailUI", " add option :%s", new Object[] { locale.wording });
                  paramAnonymous2s.c(i, locale.wording);
                }
                i += 1;
              }
              AppMethodBeat.o(289013);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(289016);
              if (paramAnonymous2MenuItem.getItemId() > RemittanceDetailUI.24.this.Ort.size() - 1)
              {
                Log.i("MicroMsg.RemittanceDetailUI", "menuItem.getItemId() > mTextInfoList.size() : %s , %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), Integer.valueOf(RemittanceDetailUI.24.this.Ort.size()) });
                AppMethodBeat.o(289016);
                return;
              }
              paramAnonymous2MenuItem = (ah.e)RemittanceDetailUI.24.this.Ort.get(paramAnonymous2MenuItem.getItemId());
              Log.i("MicroMsg.RemittanceDetailUI", " click option menu : %s ,type:%s", new Object[] { paramAnonymous2MenuItem.wording, Integer.valueOf(paramAnonymous2MenuItem.OkO.type) });
              switch (paramAnonymous2MenuItem.OkO.type)
              {
              default: 
                Log.e("MicroMsg.RemittanceDetailUI", "unknow text info type");
                AppMethodBeat.o(289016);
                return;
              case 1: 
                Log.i("MicroMsg.RemittanceDetailUI", "textInfo.jumpInfo.url ：%s", new Object[] { paramAnonymous2MenuItem.OkO.url });
                com.tencent.mm.wallet_core.ui.i.p(RemittanceDetailUI.this.getContext(), paramAnonymous2MenuItem.OkO.url, false);
                AppMethodBeat.o(289016);
                return;
              case 2: 
                Log.i("MicroMsg.RemittanceDetailUI", "textInfo.jumpInfo.username ：%s", new Object[] { paramAnonymous2MenuItem.OkO.username });
                com.tencent.mm.wallet_core.ui.i.y(paramAnonymous2MenuItem.OkO.username, paramAnonymous2MenuItem.OkO.OkP, 0, 1000);
                AppMethodBeat.o(289016);
                return;
              }
              Log.e("MicroMsg.RemittanceDetailUI", "text info type is OPTIONS_MENU_ITEM_JUMP_TYPE_NATIVE");
              AppMethodBeat.o(289016);
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(289133);
          return true;
        }
      });
    }
  }
  
  private void aUg(String paramString)
  {
    AppMethodBeat.i(289136);
    Intent localIntent = new Intent();
    localIntent.putExtra("result_msg", paramString);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(289136);
  }
  
  private void ahp(int paramInt)
  {
    AppMethodBeat.i(68160);
    doSceneProgress(new ah(paramInt, this.OqR, this.Omn, this.OqP, this.ciX), true);
    AppMethodBeat.o(68160);
  }
  
  private void c(Dialog paramDialog)
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
  
  protected final void aUf(String paramString)
  {
    AppMethodBeat.i(289229);
    paramString = new ae(this.OqR, this.Omn, this.OqW, "confirm", this.OqS, this.OqP, paramString, this.ciX);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    AppMethodBeat.o(289229);
  }
  
  protected final SpannableString cJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(289245);
    String str = aa.aV(paramString, this.ciX);
    if (str == null)
    {
      paramString = new SpannableString("");
      AppMethodBeat.o(289245);
      return paramString;
    }
    paramString = str;
    if (paramBoolean) {
      paramString = com.tencent.mm.wallet_core.ui.i.jn(str, 9);
    }
    paramString = com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), paramString);
    AppMethodBeat.o(289245);
    return paramString;
  }
  
  public void finish()
  {
    AppMethodBeat.i(68173);
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_plugin", "remittance");
    localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
    if ((this.OqY != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.OqY, localBundle, true, 1008)))
    {
      this.OqY = null;
      AppMethodBeat.o(68173);
      return;
    }
    super.finish();
    AppMethodBeat.o(68173);
  }
  
  protected final void gMU()
  {
    AppMethodBeat.i(68164);
    aUf("");
    AppMethodBeat.o(68164);
  }
  
  protected final void gMV()
  {
    AppMethodBeat.i(68165);
    ae localae = new ae(this.OqR, this.Omn, this.OqW, "refuse", this.OqS, this.OqP, this.ciX);
    localae.setProcessName("RemittanceProcess");
    doSceneProgress(localae);
    AppMethodBeat.o(68165);
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68161);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setNavigationbarColor(getResources().getColor(a.c.white));
    this.OgG = ((ImageView)findViewById(a.f.remittance_detail_desc_icon));
    this.Oqc = ((TextView)findViewById(a.f.remittance_detail_result_desc));
    this.Oqd = ((TextView)findViewById(a.f.remittance_detail_fee));
    this.Oqg = ((TextView)findViewById(a.f.remittance_detail_main_desc1_tv));
    this.Oqh = ((TextView)findViewById(a.f.remittance_detail_main_desc2_tv));
    this.Oqi = findViewById(a.f.desc_seperator_view);
    this.Oqj = ((LinearLayout)findViewById(a.f.remittance_detail_container));
    this.Oqk = ((LinearLayout)findViewById(a.f.remittance_info_container));
    this.Oql = ((LinearLayout)findViewById(a.f.remittance_desc_container));
    this.OlW = ((LinearLayout)findViewById(a.f.remittance_address_container));
    this.Oqm = ((LinearLayout)findViewById(a.f.remittance_address_content_lv));
    this.Oqn = ((TextView)findViewById(a.f.remittance_desc_tv));
    this.Oqo = ((TextView)findViewById(a.f.remittance_desc_content_tv));
    this.Oqp = ((TextView)findViewById(a.f.name_telephone_tv));
    this.Oqq = ((TextView)findViewById(a.f.address_detail_tv));
    this.Oqr = ((TextView)findViewById(a.f.address_detail_spread_tv));
    this.Oqs = ((ViewGroup)findViewById(a.f.remittance_operation_container));
    this.Oqt = ((ImageView)findViewById(a.f.remittance_operation_icon_iv));
    this.Oqu = ((TextView)findViewById(a.f.remittance_operation_name_tv));
    this.Oqv = ((TextView)findViewById(a.f.remittance_operation_wording_tv));
    this.Oqw = ((ImageView)findViewById(a.f.remittance_operation_arrow_iv));
    this.Oqx = ((Button)findViewById(a.f.next_btn));
    this.Oqy = ((TextView)findViewById(a.f.remittance_character_chain_tv));
    this.Oqz = ((TextView)findViewById(a.f.remittance_detail_main_desc2_tv));
    this.OqA = findViewById(a.f.remittance_operation_line);
    this.OqB = findViewById(a.f.remittance_info_container_line1);
    this.OqC = findViewById(a.f.remittance_info_container_line2);
    this.OqD = ((Button)findViewById(a.f.remittance_detail_collect_operate_btn));
    this.OqE = ((TextView)findViewById(a.f.remittance_detail_main_operate_desc));
    this.OqF = ((LinearLayout)findViewById(a.f.remittance_detail_operate_container));
    this.OqG = ((LinearLayout)findViewById(a.f.remittance_info_operate_container));
    this.OqH = ((LinearLayout)findViewById(a.f.remittance_desc_operate_container));
    this.OqI = ((LinearLayout)findViewById(a.f.remittance_address_operate_container));
    this.OqJ = ((LinearLayout)findViewById(a.f.remittance_address_content_operate_lv));
    this.OqK = ((TextView)findViewById(a.f.remittance_desc_operate_tv));
    this.OqL = ((TextView)findViewById(a.f.remittance_desc_content_operate_tv));
    this.OqM = ((TextView)findViewById(a.f.name_telephone_operate_tv));
    this.OqN = ((TextView)findViewById(a.f.address_detail_operate_tv));
    this.OqO = ((TextView)findViewById(a.f.address_detail_spread_operate_tv));
    this.Oqe = ((TextView)findViewById(a.f.remittance_detail_time_desc_one));
    this.Oqf = ((TextView)findViewById(a.f.remittance_detail_time_desc_two));
    this.OqZ = ((LinearLayout)findViewById(a.f.remittance_detail_desc_ll));
    this.Ora = ((LinearLayout)findViewById(a.f.remittance_detail_desc_container));
    this.Orb = ((RelativeLayout)findViewById(a.f.remittance_detail_payer_ll));
    this.Orc = ((LinearLayout)findViewById(a.f.remittance_detail_receive_ll));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    AppMethodBeat.o(68161);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68159);
    Log.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      ahp(0);
    }
    AppMethodBeat.o(68159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68157);
    super.onCreate(paramBundle);
    this.KBx = new j(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(289132);
        if (RemittanceDetailUI.d(RemittanceDetailUI.this) == null)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(289132);
          return false;
        }
        if (RemittanceDetailUI.d(RemittanceDetailUI.this).KBw == null)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(289132);
          return false;
        }
        if (!j.a(RemittanceDetailUI.d(RemittanceDetailUI.this).KBw))
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(289132);
          return false;
        }
        RemittanceDetailUI.e(RemittanceDetailUI.this).a(RemittanceDetailUI.d(RemittanceDetailUI.this).KBw, new j.a()
        {
          public final void a(dfc paramAnonymous2dfc)
          {
            AppMethodBeat.i(289002);
            if (paramAnonymous2dfc.action == 1)
            {
              RemittanceDetailUI.this.finish();
              AppMethodBeat.o(289002);
              return;
            }
            AppMethodBeat.o(289002);
          }
        });
        RemittanceDetailUI.d(RemittanceDetailUI.this).KBw = null;
        AppMethodBeat.o(289132);
        return false;
      }
    });
    this.OqP = getIntent().getIntExtra("invalid_time", 0);
    this.OqQ = getIntent().getIntExtra("appmsg_type", 0);
    this.OqR = getIntent().getStringExtra("transaction_id");
    this.OqT = getIntent().getStringExtra("bill_id");
    this.Omn = getIntent().getStringExtra("transfer_id");
    this.OqS = getIntent().getStringExtra("sender_name");
    this.OqU = getIntent().getIntExtra("effective_date", 3);
    this.OqV = getIntent().getBooleanExtra("is_sender", false);
    this.OqW = getIntent().getIntExtra("total_fee", 0);
    this.lul = getIntent().getLongExtra("key_msg_id", 0L);
    if (au.bwE(this.OqS)) {
      this.ciX = this.OqS;
    }
    initView();
    ahp(0);
    getIntent();
    this.Ord.alive();
    this.Ore.alive();
    this.Orf.alive();
    paramBundle = (RelativeLayout.LayoutParams)this.OgG.getLayoutParams();
    paramBundle.width = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 64);
    paramBundle.height = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 64);
    this.OgG.setLayoutParams(paramBundle);
    AppMethodBeat.o(68157);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(68168);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(a.i.app_copy));
    AppMethodBeat.o(68168);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68158);
    this.Ord.dead();
    if (this.Ore != null) {
      this.Ore.dead();
    }
    this.Orf.dead();
    super.onDestroy();
    AppMethodBeat.o(68158);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(289218);
    boolean bool;
    if (paramInt != 4)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(289218);
      return bool;
    }
    if (this.OqY == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(289218);
      return bool;
    }
    if (this.OqY.KBw == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(289218);
      return bool;
    }
    if (!j.a(this.OqY.KBw))
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(289218);
      return bool;
    }
    this.KBx.a(this.OqY.KBw, new j.a()
    {
      public final void a(dfc paramAnonymousdfc)
      {
        AppMethodBeat.i(289129);
        if (paramAnonymousdfc.action == 1)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(289129);
          return;
        }
        AppMethodBeat.o(289129);
      }
    });
    this.OqY.KBw = null;
    AppMethodBeat.o(289218);
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(68170);
    label193:
    label616:
    label1910:
    final boolean bool;
    if ((paramp instanceof ah))
    {
      final ah localah = (ah)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.remittance.app.c.gLv();
        paramString = com.tencent.mm.plugin.remittance.app.c.gLx().aTP(this.Omn);
        Object localObject;
        if (paramString != null)
        {
          paramString.field_hasClicked = true;
          paramInt1 = localah.status;
          if (paramInt1 != 2000)
          {
            if (paramInt1 == 2001) {
              paramString.field_receiveStatus = 3;
            }
          }
          else
          {
            com.tencent.mm.plugin.remittance.app.c.gLv();
            com.tencent.mm.plugin.remittance.app.c.gLx().a(paramString);
            com.tencent.mm.plugin.remittance.app.c.gLv().aTL(paramString.field_talker);
          }
        }
        else
        {
          if (localah != null)
          {
            Log.i("MicroMsg.RemittanceDetailUI", "groupname: %s, %s", new Object[] { this.ciX, Integer.valueOf(localah.OkI) });
            paramInt1 = 0;
            if ((Util.isNullOrNil(this.ciX)) || (localah.OkI <= 0)) {
              break label795;
            }
            this.MEK = localah.Okx;
            this.MED = localah.Okv;
            if (localah.OkI != 1) {
              break label781;
            }
            if (!localah.JCS) {
              break label776;
            }
            paramInt1 = 1;
            z.bAM();
            this.Oqd.setText(com.tencent.mm.wallet_core.ui.i.e(localah.wZe, localah.MEq));
            this.Oqd.setTextSize(1, 48.0F);
            paramp = localah.Okz;
            paramString = paramp;
            if (!Util.isNullOrNil(paramp))
            {
              paramString = paramp;
              if (paramp.contains("%s")) {
                paramString = paramp.trim().replace("%s", cJ(this.MED, false));
              }
            }
            paramp = paramString;
            if (!Util.isNullOrNil(paramString))
            {
              paramp = paramString;
              if (paramString.contains("%d")) {
                paramp = paramString.trim().replace("%d", cJ(this.MEK, false));
              }
            }
            paramString = localah.OkA;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.OqR);
            ((Bundle)localObject).putString("receiver_name", this.MED);
            ((Bundle)localObject).putString("transfer_id", this.Omn);
            ((Bundle)localObject).putInt("total_fee", this.OqW);
            ((Bundle)localObject).putString("sender_name", this.OqS);
            ((Bundle)localObject).putInt("invalid_time", this.OqP);
            ((Bundle)localObject).putParcelable("resend_msg_info", localah.OkF);
            this.Oqg.setClickable(true);
            this.Oqc.setClickable(true);
            this.OqE.setClickable(true);
            paramInt2 = localah.status;
            Log.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[] { Integer.valueOf(paramInt2) });
          }
          switch (paramInt2)
          {
          default: 
            finish();
            label520:
            this.pLM.setBannerData(localah.pGr);
            this.OqX = localah.OkB;
            com.tencent.mm.kernel.h.baF();
            this.Omg = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPm, ""));
            com.tencent.mm.kernel.h.baF();
            this.Omh = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPn, Integer.valueOf(0))).intValue();
            if (Util.isNullOrNil(this.Omg))
            {
              ak.a(true, this.mNetSceneMgr);
              if (localah.MEW == 1)
              {
                com.tencent.mm.kernel.h.baF();
                if (((String)com.tencent.mm.kernel.h.baE().ban().d(327729, "0")).equals("0"))
                {
                  paramString = getContext();
                  if (!z.bBi()) {
                    break label4239;
                  }
                  paramInt1 = a.i.chatting_item_appmsg_remittance_collect_tips_payu;
                }
              }
            }
            break;
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.base.k.a(paramString, paramInt1, a.i.wallet_remittance_collect_title, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68143);
              AppMethodBeat.o(68143);
            }
          });
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(327729, "1");
          AppMethodBeat.o(68170);
          return true;
          if (paramInt1 == 2002)
          {
            paramString.field_receiveStatus = 4;
            break;
          }
          if (paramInt1 == 2003)
          {
            paramString.field_receiveStatus = 2;
            break;
          }
          if (paramInt1 == 2004)
          {
            paramString.field_receiveStatus = 5;
            break;
          }
          if (paramInt1 != 2005) {
            break;
          }
          paramString.field_receiveStatus = 6;
          break;
          label776:
          paramInt1 = 2;
          break label193;
          label781:
          if (localah.OkI != 2) {
            break label193;
          }
          paramInt1 = 3;
          break label193;
          label795:
          if (localah.JCS)
          {
            this.MEK = z.bAM();
            this.MED = this.OqS;
            paramInt1 = 1;
            break label193;
          }
          this.MEK = this.OqS;
          this.MED = z.bAM();
          paramInt1 = 2;
          break label193;
          if (paramInt1 == 1)
          {
            this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
            if ((!Util.isNullOrNil(paramp)) && (!Util.isNullOrNil(paramString)))
            {
              this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
              this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
              this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              label966:
              a(false, false, localah);
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.Oqe.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oku) }));
            this.Oqe.setVisibility(0);
            this.Oqe.setVisibility(8);
            this.Oqf.setVisibility(8);
            break;
            paramString = getString(a.i.remittance_detail_result_wait_sender, new Object[] { cJ(this.MED, true) });
            this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramString, this.Oqc.getTextSize()));
            paramString = getString(a.i.remittance_detail_sender_tips, new Object[] { Integer.valueOf(this.OqU) });
            paramp = getString(a.i.remittance_remind_collection_msg);
            localObject = new SpannableString(paramString + paramp);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.MGT = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68150);
                new e(RemittanceDetailUI.this).a(localah.OkF, new g.c()
                {
                  public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(289130);
                    if (paramAnonymous2Boolean)
                    {
                      paramAnonymous2String = new Intent();
                      paramAnonymous2String.putExtra("transaction_id", RemittanceDetailUI.this.OqR);
                      paramAnonymous2String.putExtra("transfer_id", RemittanceDetailUI.this.Omn);
                      paramAnonymous2String.putExtra("receiver_name", RemittanceDetailUI.f(RemittanceDetailUI.this));
                      paramAnonymous2String.putExtra("resend_msg_from_flag", 3);
                      com.tencent.mm.br.c.b(RemittanceDetailUI.this, "remittance", ".ui.RemittanceResendMsgUI", paramAnonymous2String);
                    }
                    AppMethodBeat.o(289130);
                  }
                });
                AppMethodBeat.o(68150);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramp.length(), 33);
            this.Oqg.setMovementMethod(LinkMovementMethod.getInstance());
            this.Oqg.setText((CharSequence)localObject);
            break label966;
            if (paramInt1 != 2) {
              break label1628;
            }
            Log.i("MicroMsg.RemittanceDetailUI", "set click reveive btn");
            this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_outlined_time, getContext().getResources().getColor(a.c.Blue)));
            this.OqD.setVisibility(0);
            this.OqD.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(289121);
                Log.i("MicroMsg.RemittanceDetailUI", "click reveive btn");
                ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.b.class)).jO(9, 4);
                u.iiw();
                paramAnonymousView = RemittanceDetailUI.this;
                com.tencent.mm.wallet_core.c.i locali = RemittanceDetailUI.g(RemittanceDetailUI.this);
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a()
                {
                  public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(288971);
                    Log.i("MicroMsg.RemittanceDetailUI", "resultCode :%s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                    if (paramAnonymous2Int1 == 2)
                    {
                      RemittanceDetailUI.this.gMU();
                      AppMethodBeat.o(288971);
                      return true;
                    }
                    if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean)) {
                      RemittanceDetailUI.this.gMU();
                    }
                    AppMethodBeat.o(288971);
                    return true;
                  }
                };
                boolean bool = u.a(paramAnonymousView, locali);
                Log.i("MicroMsg.RemittanceDetailUI", "click reveive btn，ret :%s", new Object[] { Boolean.valueOf(bool) });
                if (!bool) {
                  RemittanceDetailUI.this.gMU();
                }
                AppMethodBeat.o(289121);
              }
            });
            if ((Util.isNullOrNil(paramp)) || (Util.isNullOrNil(paramString))) {
              break label1370;
            }
            this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
            this.OqE.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.OqE.getTextSize(), localObject));
            this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
            this.OqE.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
            a(true, false, localah);
          }
          label1370:
          this.Oqc.setText(a.i.remittance_detail_result_wait_receiver);
          if (localah.OkB != 0) {
            if (!Util.isNullOrNil(localah.OkA)) {
              paramString = localah.OkA;
            }
          }
          for (;;)
          {
            paramp = getString(a.i.remittance_detail_refuse_action);
            localObject = new SpannableString(paramString + paramp);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.MGT = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68152);
                com.tencent.mm.ui.base.k.b(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(a.i.remittance_detail_refund_tips, new Object[] { RemittanceDetailUI.this.cJ(localah.Okx, false) }), RemittanceDetailUI.this.getString(a.i.app_remind), RemittanceDetailUI.this.getString(a.i.remittance_detail_refuse_btn_text), RemittanceDetailUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(289148);
                    RemittanceDetailUI.this.gMV();
                    AppMethodBeat.o(289148);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(68152);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramp.length(), 33);
            this.OqE.setMovementMethod(LinkMovementMethod.getInstance());
            this.OqE.setText((CharSequence)localObject);
            break;
            Log.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localah.OkB == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(a.i.remittance_detail_reveiver_tips1, new Object[] { paramString });
              paramp = getString(a.i.remittance_detail_reveiver_tips2, new Object[] { Integer.valueOf(this.OqU) });
              paramString = paramString + paramp;
              break;
            }
            paramString = getString(a.i.remittance_detail_reveiver_tips2, new Object[] { Integer.valueOf(this.OqU) });
          }
          label1628:
          this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
          if (!Util.isNullOrNil(paramp))
          {
            this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
            this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
          }
          for (;;)
          {
            if (!Util.isNullOrNil(paramString))
            {
              this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
              this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
            }
            a(false, false, localah);
            break;
            this.Oqc.setText(a.i.remittance_detail_others_desc);
          }
          this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_filled_done2, getContext().getResources().getColor(a.c.Brand)));
          if (!Util.isNullOrNil(paramp))
          {
            this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
            this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
            if (!Util.isNullOrNil(paramString))
            {
              this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
              this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              this.Oqg.setVisibility(0);
            }
            if (paramInt1 != 2) {
              break label2243;
            }
            a(false, true, localah);
          }
          for (;;)
          {
            this.Oqe.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oku) }));
            this.Oqe.setVisibility(0);
            this.Oqe.setVisibility(8);
            this.Oqf.setText(getString(a.i.remittance_detail_receive_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oky) }));
            this.Oqf.setVisibility(0);
            this.Oqf.setVisibility(8);
            break;
            if (paramInt1 == 2)
            {
              this.Oqc.setText(a.i.remittance_detail_result_collected);
              paramString = new SpannableStringBuilder(getString(a.i.remittance_detail_check_ballance));
              paramp = new com.tencent.mm.plugin.order.c.a(this);
              paramp.MGT = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(289069);
                  com.tencent.mm.pluginsdk.wallet.f.bq(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(289069);
                }
              };
              paramString.setSpan(paramp, 0, paramString.length(), 18);
              this.Oqg.setMovementMethod(LinkMovementMethod.getInstance());
              this.Oqg.setText(paramString);
              this.Oqg.setVisibility(0);
              break label1910;
            }
            if (paramInt1 == 1)
            {
              paramString = cJ(this.MED, true) + getString(a.i.remittance_detail_result_collected);
              this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramString, this.Oqc.getTextSize()));
              this.Oqg.setVisibility(8);
              break label1910;
            }
            if (!Util.isNullOrNil(paramp))
            {
              this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
              this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              break label1910;
            }
            this.Oqc.setText(a.i.remittance_detail_others_desc);
            break label1910;
            label2243:
            a(false, false, localah);
          }
          if (paramInt2 == 2003)
          {
            this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_filled_error, getContext().getResources().getColor(a.c.Red)));
            label2291:
            if (Util.isNullOrNil(paramp)) {
              break label2523;
            }
            this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
            this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
            label2336:
            if (Util.isNullOrNil(paramString)) {
              break label2636;
            }
            this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
            this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
            this.Oqg.setVisibility(0);
          }
          label2695:
          label2830:
          for (;;)
          {
            a(false, false, localah);
            this.Oqe.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oku) }));
            this.Oqe.setVisibility(0);
            this.Oqe.setVisibility(8);
            this.Oqf.setText(getString(a.i.remittance_detail_refund_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oky) }));
            this.Oqf.setVisibility(0);
            this.Oqf.setVisibility(8);
            break;
            this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_filled_previous2, getContext().getResources().getColor(a.c.Yellow)));
            break label2291;
            label2523:
            if (paramInt1 == 1)
            {
              if (paramInt2 == 2003)
              {
                this.Oqc.setText(a.i.remittance_detail_result_timeout_refunded);
                break label2336;
              }
              paramp = cJ(this.MED, true) + getString(a.i.remittance_detail_result_refunded);
              this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramp, this.Oqc.getTextSize()));
              break label2336;
            }
            if (paramInt1 == 2)
            {
              this.Oqc.setText(a.i.remittance_detail_result_refunded);
              break label2336;
            }
            this.Oqc.setText(a.i.remittance_detail_others_desc);
            break label2336;
            label2636:
            if (paramInt1 == 1)
            {
              if (("CFT".equals(localah.MEM)) || ("LQT".equals(localah.MEM)))
              {
                bool = "LQT".equals(localah.MEM);
                if (bool)
                {
                  paramString = getString(a.i.remittance_detail_refund_to_lqt);
                  if (!bool) {
                    break label2830;
                  }
                  paramp = getString(a.i.remittance_detail_check_lqt);
                  localObject = new SpannableString(paramString + paramp);
                  locala = new com.tencent.mm.plugin.order.c.a(this);
                  locala.MGT = new com.tencent.mm.plugin.order.c.a.a()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(289216);
                      if (bool)
                      {
                        com.tencent.mm.br.c.ai(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                        AppMethodBeat.o(289216);
                        return;
                      }
                      com.tencent.mm.pluginsdk.wallet.f.bq(RemittanceDetailUI.this, 0);
                      AppMethodBeat.o(289216);
                    }
                  };
                  paramInt1 = paramString.length();
                  paramInt2 = paramString.length();
                  ((SpannableString)localObject).setSpan(locala, paramInt1, paramp.length() + paramInt2, 33);
                  this.Oqg.setMovementMethod(LinkMovementMethod.getInstance());
                  this.Oqg.setText((CharSequence)localObject);
                }
              }
              for (;;)
              {
                this.Oqg.setVisibility(0);
                break;
                paramString = getString(a.i.remittance_detail_refund_to_ballance);
                break label2695;
                paramp = getString(a.i.remittance_detail_check_ballance);
                break label2709;
                this.Oqg.setText(a.i.remittance_detail_refund_to_bankcard);
              }
            }
            label2709:
            this.Oqg.setVisibility(8);
          }
          if (paramInt1 == 2)
          {
            this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
            if ((!Util.isNullOrNil(paramp)) && (!Util.isNullOrNil(paramString)))
            {
              this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
              this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
              this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              this.Oqg.setVisibility(0);
            }
          }
          label3609:
          for (;;)
          {
            a(false, false, localah);
            this.Oqe.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oku) }));
            this.Oqe.setVisibility(0);
            this.Oqe.setVisibility(8);
            this.Oqf.setText(getString(a.i.remittance_detail_receive_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oky) }));
            this.Oqf.setVisibility(0);
            this.Oqf.setVisibility(8);
            break;
            if (!Util.isNullOrNil(localah.Okz)) {
              this.Oqc.setText(localah.Okz);
            }
            for (;;)
            {
              if (Util.isNullOrNil(localah.OkA)) {
                break label3171;
              }
              this.Oqg.setText(localah.OkA);
              this.Oqg.setVisibility(0);
              break;
              this.Oqc.setText(a.i.remittance_detail_result_receiver_waited);
            }
            label3171:
            this.Oqg.setText("");
            continue;
            if (paramInt1 == 1)
            {
              this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
              if ((!Util.isNullOrNil(paramp)) && (!Util.isNullOrNil(paramString)))
              {
                this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
                this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
                this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
                this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
                this.Oqg.setVisibility(0);
              }
              else
              {
                if (!Util.isNullOrNil(localah.Okz)) {}
                for (;;)
                {
                  try
                  {
                    this.Oqc.setText(String.format(localah.Okz, new Object[] { cJ(this.MED, true) }));
                    if (Util.isNullOrNil(localah.OkA)) {
                      break label3442;
                    }
                    this.Oqg.setText(localah.OkA);
                    this.Oqg.setVisibility(0);
                  }
                  catch (Exception paramString)
                  {
                    Log.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                  }
                  this.Oqc.setText(getString(a.i.remittance_detail_result_sender_waited, new Object[] { cJ(this.MED, true) }));
                }
                label3442:
                this.Oqg.setText("");
              }
            }
            else
            {
              this.OgG.setImageDrawable(bb.m(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
              if (!Util.isNullOrNil(paramp))
              {
                this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
                this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              }
              for (;;)
              {
                if (Util.isNullOrNil(paramString)) {
                  break label3609;
                }
                this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
                this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
                this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
                this.Oqg.setVisibility(0);
                break;
                this.Oqc.setText(a.i.remittance_detail_others_desc);
              }
            }
          }
          this.OgG.setImageResource(a.h.remittance_cancle);
          if ((paramInt1 == 1) || (paramInt1 == 2)) {
            if ((!Util.isNullOrNil(paramp)) && (!Util.isNullOrNil(paramString)))
            {
              this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
              this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
              this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
            }
          }
          label3853:
          label4025:
          label4036:
          label4051:
          label4213:
          for (;;)
          {
            a(false, false, localah);
            this.Oqe.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oku) }));
            this.Oqe.setVisibility(0);
            this.Oqe.setVisibility(8);
            if (localah.Oky <= 0) {
              break label4215;
            }
            this.Oqf.setText(getString(a.i.remittance_detail_cancel_time, new Object[] { com.tencent.mm.wallet_core.ui.i.vh(localah.Oky) }));
            this.Oqf.setVisibility(0);
            this.Oqf.setVisibility(8);
            break;
            if (!Util.isNullOrNil(localah.Okz))
            {
              this.Oqc.setText(localah.Okz);
              if (Util.isNullOrNil(localah.OkA)) {
                break label4051;
              }
              if ((!"CFT".equals(localah.MEM)) && (!"LQT".equals(localah.MEM))) {
                break label4036;
              }
              bool = "LQT".equals(localah.MEM);
              paramp = localah.OkA;
              if (!bool) {
                break label4025;
              }
            }
            for (paramString = getString(a.i.remittance_detail_check_lqt);; paramString = getString(a.i.remittance_detail_check_ballance))
            {
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(paramp);
              ((SpannableStringBuilder)localObject).append(paramString);
              paramString = new com.tencent.mm.plugin.order.c.a(this);
              paramString.MGT = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68126);
                  if (bool)
                  {
                    com.tencent.mm.br.c.ai(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(68126);
                    return;
                  }
                  com.tencent.mm.pluginsdk.wallet.f.bq(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68126);
                }
              };
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramp.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.Oqg.setMovementMethod(LinkMovementMethod.getInstance());
              this.Oqg.setText((CharSequence)localObject);
              break;
              this.Oqc.setText(a.i.remittance_detail_result_canceled);
              break label3853;
            }
            this.Oqg.setText(localah.OkA);
            continue;
            if (paramInt1 == 2)
            {
              this.Oqg.setText(a.i.remittance_detail_receiver_cancel_tips);
            }
            else if (paramInt1 == 1)
            {
              this.Oqg.setText(a.i.remittance_detail_sender_cancel_tips);
              continue;
              this.OgG.setImageResource(a.h.remittance_cancle);
              if (!Util.isNullOrNil(paramp))
              {
                this.Oqc.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramp, (int)this.Oqc.getTextSize(), localObject));
                this.Oqc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
              }
              for (;;)
              {
                if (Util.isNullOrNil(paramString)) {
                  break label4213;
                }
                this.Oqg.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, paramString, (int)this.Oqg.getTextSize(), localObject));
                this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
                this.Oqg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
                break;
                this.Oqc.setText(a.i.remittance_detail_others_desc);
              }
            }
          }
          label4215:
          this.Oqf.setVisibility(8);
          break label520;
          ak.a(false, this.mNetSceneMgr);
          break label616;
          label4239:
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXe, false)) {
            paramInt1 = a.i.wallet_remittance_collect_tips_new;
          } else {
            paramInt1 = a.i.wallet_remittance_collect_tips;
          }
        }
      }
    }
    else
    {
      if ((paramp instanceof ae))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.OqY = ((ae)paramp);
          if ((this.OqY.isJumpRemind()) && (this.OqY.getJumpRemind().a(this, new g()
          {
            public final void fWQ()
            {
              AppMethodBeat.i(289101);
              RemittanceDetailUI.a(RemittanceDetailUI.this, RemittanceDetailUI.d(RemittanceDetailUI.this));
              AppMethodBeat.o(289101);
            }
          })))
          {
            AppMethodBeat.o(68170);
            return true;
          }
          if (j.a(this.OqY.KtV))
          {
            new j(this).a(this.OqY.KtV, new j.a()
            {
              public final void a(dfc paramAnonymousdfc)
              {
                AppMethodBeat.i(289143);
                if (paramAnonymousdfc.action == 2)
                {
                  RemittanceDetailUI.this.aUf(RemittanceDetailUI.d(RemittanceDetailUI.this).KuK);
                  AppMethodBeat.o(289143);
                  return;
                }
                if (paramAnonymousdfc.action == 1)
                {
                  RemittanceDetailUI.this.finish();
                  AppMethodBeat.o(289143);
                  return;
                }
                AppMethodBeat.o(289143);
              }
            });
            AppMethodBeat.o(68170);
            return true;
          }
          a(this.OqY);
          AppMethodBeat.o(68170);
          return true;
        }
        if (paramInt2 == 416)
        {
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_plugin", "remittance");
          paramString.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramp, paramString, 1008);
          AppMethodBeat.o(68170);
          return bool;
        }
        paramp = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramp = getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(289137);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(289137);
          }
        });
        AppMethodBeat.o(68170);
        return true;
      }
      if ((paramp instanceof ak))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.Omg = ((ak)paramp).Vys;
          this.Omh = ((ak)paramp).Vyt;
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          Log.i("MicroMsg.RemittanceDetailUI", "net error");
        }
      }
    }
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(289222);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(al.class);
    AppMethodBeat.o(289222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */