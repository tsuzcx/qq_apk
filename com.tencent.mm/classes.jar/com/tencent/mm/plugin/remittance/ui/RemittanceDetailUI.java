package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
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
import android.view.View.OnClickListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.sn;
import com.tencent.mm.f.a.so;
import com.tencent.mm.f.a.so.a;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.model.ad;
import com.tencent.mm.plugin.remittance.model.ag;
import com.tencent.mm.plugin.remittance.model.ag.a;
import com.tencent.mm.plugin.remittance.model.ag.b;
import com.tencent.mm.plugin.remittance.model.ag.c;
import com.tencent.mm.plugin.remittance.model.ag.d;
import com.tencent.mm.plugin.remittance.model.ag.e;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.g.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f.a;
import java.util.ArrayList;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(3)
public class RemittanceDetailUI
  extends WalletBaseUI
{
  private com.tencent.mm.plugin.wallet_core.utils.g EIg;
  private String GHN;
  private String GHU;
  protected ImageView IjU;
  private LinearLayout IoD;
  private String IoN;
  private int IoO;
  protected String IoU;
  protected View IsA;
  protected LinearLayout IsB;
  private LinearLayout IsC;
  private LinearLayout IsD;
  private LinearLayout IsE;
  private TextView IsF;
  private TextView IsG;
  private TextView IsH;
  private TextView IsI;
  private TextView IsJ;
  protected ViewGroup IsK;
  protected ImageView IsL;
  protected TextView IsM;
  protected TextView IsN;
  protected ImageView IsO;
  protected Button IsP;
  protected TextView IsQ;
  protected TextView IsR;
  protected View IsS;
  protected View IsT;
  protected View IsU;
  protected Button IsV;
  protected TextView IsW;
  protected LinearLayout IsX;
  private LinearLayout IsY;
  private LinearLayout IsZ;
  protected TextView Isu;
  protected TextView Isv;
  protected TextView Isw;
  protected TextView Isx;
  protected TextView Isy;
  protected TextView Isz;
  private LinearLayout Ita;
  private LinearLayout Itb;
  private TextView Itc;
  private TextView Itd;
  private TextView Ite;
  private TextView Itf;
  private TextView Itg;
  protected int Ith;
  protected int Iti;
  public String Itj;
  public String Itk;
  protected String Itl;
  protected int Itm;
  protected boolean Itn;
  protected int Ito;
  private int Itp;
  private ad Itq;
  private LinearLayout Itr;
  private LinearLayout Its;
  private RelativeLayout Itt;
  private LinearLayout Itu;
  private IListener<so> Itv;
  private IListener<sn> Itw;
  private IListener<tx> Itx;
  private int Ity;
  private String auA;
  private long iSo;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private q.g voR;
  private View.OnTouchListener wOs;
  private View.OnLongClickListener wOt;
  
  public RemittanceDetailUI()
  {
    AppMethodBeat.i(68156);
    this.IjU = null;
    this.Isu = null;
    this.Isv = null;
    this.Isw = null;
    this.Isx = null;
    this.Isy = null;
    this.Isz = null;
    this.IsV = null;
    this.IsW = null;
    this.Itj = null;
    this.Itk = null;
    this.IoU = null;
    this.Itl = null;
    this.IoN = null;
    this.Itm = 3;
    this.Itn = false;
    this.Itv = new IListener() {};
    this.Itw = new IListener() {};
    this.Itx = new IListener() {};
    this.szq = null;
    this.Ity = 0;
    this.voR = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(196867);
        paramAnonymousMenuItem = "";
        if (Util.isEqual(RemittanceDetailUI.r(RemittanceDetailUI.this), a.f.remittance_desc_content_tv)) {
          paramAnonymousMenuItem = RemittanceDetailUI.s(RemittanceDetailUI.this).getText().toString().trim();
        }
        do
        {
          for (;;)
          {
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
            com.tencent.mm.ui.base.h.cO(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(a.i.app_copy_ok));
            AppMethodBeat.o(196867);
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
    this.wOs = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(275331);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(275331);
          return false;
          RemittanceDetailUI.a(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawX());
          RemittanceDetailUI.b(RemittanceDetailUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.wOt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(269715);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$24", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        Log.d("MicroMsg.RemittanceDetailUI", "onLongClick");
        if (RemittanceDetailUI.w(RemittanceDetailUI.this) == null) {
          RemittanceDetailUI.a(RemittanceDetailUI.this, new com.tencent.mm.ui.widget.b.a(RemittanceDetailUI.this.getContext()));
        }
        RemittanceDetailUI.w(RemittanceDetailUI.this).a(paramAnonymousView, RemittanceDetailUI.this, RemittanceDetailUI.x(RemittanceDetailUI.this), RemittanceDetailUI.y(RemittanceDetailUI.this), RemittanceDetailUI.z(RemittanceDetailUI.this));
        RemittanceDetailUI.c(RemittanceDetailUI.this, paramAnonymousView.getId());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$24", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(269715);
        return true;
      }
    };
    AppMethodBeat.o(68156);
  }
  
  private void a(ad paramad)
  {
    AppMethodBeat.i(68171);
    if ("confirm".equals(paramad.Imj))
    {
      acV(1);
      AppMethodBeat.o(68171);
      return;
    }
    bW(0, getResources().getString(a.i.remittance_detail_msg_refuse_suc));
    AppMethodBeat.o(68171);
  }
  
  private void a(ag paramag)
  {
    AppMethodBeat.i(268131);
    paramag = paramag.Int;
    if ((paramag == null) || (paramag.size() == 0))
    {
      this.Its.setVisibility(8);
      Log.i("MicroMsg.RemittanceDetailUI", "mDescItemList == null || mDescItemList.size() ==0");
      AppMethodBeat.o(268131);
      return;
    }
    this.Itr.removeAllViews();
    this.Its.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.Its.getLayoutParams();
    if (!Util.isNullOrNil(this.Isy.getText()))
    {
      this.Isy.setVisibility(0);
      if (this.Isy.getVisibility() != 0) {
        break label251;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 32);
      this.Its.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      int i = 0;
      while (i < paramag.size())
      {
        localObject = (ag.b)paramag.get(i);
        if (localObject != null)
        {
          LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.g.remittance_detail_desc_item, this.Itr, false);
          ((TextView)localLinearLayout.findViewById(a.f.remittance_detail_desc_title)).setText(((ag.b)localObject).title);
          final TextView localTextView = (TextView)localLinearLayout.findViewById(a.f.remittance_detail_desc_content);
          localTextView.setText(((ag.b)localObject).content);
          localTextView.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(271084);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
              paramAnonymousView = new com.tencent.mm.ui.widget.b.a(localTextView.getContext(), localTextView);
              paramAnonymousView.Yrf = new View.OnCreateContextMenuListener()
              {
                public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
                {
                  AppMethodBeat.i(270711);
                  paramAnonymous2ContextMenu.add(paramAnonymous2View.getContext().getString(a.i.app_copy));
                  AppMethodBeat.o(270711);
                }
              };
              paramAnonymousView.ODU = new q.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(209971);
                  if (paramAnonymous2Int == 0)
                  {
                    ClipboardHelper.setText(RemittanceDetailUI.22.this.bDb.getText().toString());
                    com.tencent.mm.ui.base.h.cN(RemittanceDetailUI.22.this.bDb.getContext(), RemittanceDetailUI.22.this.bDb.getContext().getString(a.i.app_copy_ok));
                  }
                  AppMethodBeat.o(209971);
                }
              };
              paramAnonymousView.XVa = new PopupWindow.OnDismissListener()
              {
                public final void onDismiss() {}
              };
              paramAnonymousView.eY(0, 0);
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(271084);
              return false;
            }
          });
          this.Itr.addView(localLinearLayout);
        }
        i += 1;
      }
      this.Isy.setVisibility(8);
      break;
      label251:
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
      this.Its.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(268131);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, final ag paramag)
  {
    AppMethodBeat.i(68166);
    label234:
    final ag.e locale;
    if (paramBoolean1)
    {
      this.IsB.setVisibility(8);
      this.Itt.setVisibility(8);
      this.IsX.setVisibility(0);
      this.Itu.setVisibility(0);
      com.tencent.mm.ui.tools.q.a(this, (ScrollView)findViewById(a.f.root_view), findViewById(a.f.parent_view_rl), findViewById(a.f.remittance_detail_all_container), findViewById(a.f.remittance_detail_receive_ll), 72);
      if (!Util.isNullOrNil(paramag.Ino.Inx))
      {
        this.IsY.setVisibility(0);
        if (!Util.isNullOrNil(paramag.desc))
        {
          this.IsZ.setVisibility(0);
          this.Itd.setText(paramag.desc);
          this.Itd.setOnLongClickListener(this.wOt);
          this.Itd.setOnTouchListener(this.wOs);
          if (Util.isNullOrNil(paramag.Ino.Inx)) {
            break label544;
          }
          this.Ita.setVisibility(0);
          this.Ite.setText(paramag.Ino.Inx + "  " + paramag.Ino.mZK);
          this.Itc.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275786);
              int i = RemittanceResultNewUI.n(RemittanceDetailUI.this, paramag.Ino.lLg, RemittanceDetailUI.h(RemittanceDetailUI.this).getWidth());
              if (!Util.isEqual(i, paramag.Ino.lLg.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_expand);
                String str2 = paramag.Ino.lLg.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.GKe = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(203376);
                    RemittanceDetailUI.i(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.j(RemittanceDetailUI.this).setVisibility(0);
                    com.tencent.mm.ui.tools.q.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(a.f.root_view), RemittanceDetailUI.this.findViewById(a.f.parent_view_rl), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_all_container), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_tiem_desc), 72);
                    AppMethodBeat.o(203376);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.i(RemittanceDetailUI.this).setOnTouchListener(a.fAr());
                RemittanceDetailUI.i(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_collapse);
                str2 = paramag.Ino.lLg + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.GKe = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(192205);
                    RemittanceDetailUI.i(RemittanceDetailUI.this).setVisibility(0);
                    RemittanceDetailUI.j(RemittanceDetailUI.this).setVisibility(8);
                    com.tencent.mm.ui.tools.q.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(a.f.root_view), RemittanceDetailUI.this.findViewById(a.f.parent_view_rl), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_all_container), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_tiem_desc), 72);
                    AppMethodBeat.o(192205);
                  }
                };
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.j(RemittanceDetailUI.this).setOnTouchListener(a.fAr());
                RemittanceDetailUI.j(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.i(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.j(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.l(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.k(RemittanceDetailUI.this));
                RemittanceDetailUI.l(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.m(RemittanceDetailUI.this));
                AppMethodBeat.o(275786);
                return;
                RemittanceDetailUI.i(RemittanceDetailUI.this).setText(paramag.Ino.lLg);
                RemittanceDetailUI.j(RemittanceDetailUI.this).setText(paramag.Ino.lLg);
              }
            }
          });
          if ((!paramBoolean2) || (Util.isNullOrNil(paramag.Inp.icon))) {
            break label882;
          }
          this.IsB.setVisibility(0);
          this.Itt.setVisibility(0);
          this.IsC.setVisibility(0);
          this.IsU.setVisibility(0);
          this.IsK.setVisibility(0);
          this.IsS.setVisibility(0);
          com.tencent.mm.ay.a.a.bms().loadImage(paramag.Inp.icon, this.IsL);
          this.IsM.setText(paramag.Inp.name);
          this.IsN.setText(paramag.Inp.wording);
          if (paramag.Inp.Iny <= 0) {
            break label830;
          }
          this.IsP.setText(paramag.Inp.Inz);
          this.IsO.setVisibility(8);
          this.IsP.setVisibility(0);
          this.IsP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(68129);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              RemittanceDetailUI.a(RemittanceDetailUI.this, paramag.Inp.InA, paramag, 11);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68129);
            }
          });
          com.tencent.mm.wallet_core.ui.g.bi(this.IsP, 200);
          label411:
          locale = paramag.Inq;
          if ((locale != null) && (!Util.isNullOrNil(locale.wording))) {
            break label912;
          }
          label433:
          a(paramag);
          paramag = paramag.ECb;
          if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCL, false)) && (paramag != null) && (paramag.size() != 0)) {
            break label1087;
          }
          Log.i("MicroMsg.RemittanceDetailUI", "ComplaintEntrance is false || mTextInfoList == null || mTextInfoList.size() ==0");
          removeAllOptionMenu();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.q.a(this, (ScrollView)findViewById(a.f.root_view), findViewById(a.f.parent_view_rl), findViewById(a.f.remittance_detail_all_container), findViewById(a.f.remittance_detail_tiem_desc), 72);
      AppMethodBeat.o(68166);
      return;
      this.IsZ.setVisibility(8);
      break;
      label544:
      this.Ita.setVisibility(8);
      break label234;
      this.IsY.setVisibility(8);
      break label234;
      this.IsB.setVisibility(0);
      this.Itt.setVisibility(0);
      this.IsX.setVisibility(8);
      this.Itu.setVisibility(8);
      if (!Util.isNullOrNil(paramag.Ino.Inx))
      {
        this.IsC.setVisibility(0);
        if (!Util.isNullOrNil(paramag.desc))
        {
          this.IsD.setVisibility(0);
          this.IsG.setText(paramag.desc);
          this.IsG.setOnLongClickListener(this.wOt);
          this.IsG.setOnTouchListener(this.wOs);
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramag.Ino.Inx)) {
            break label770;
          }
          this.IoD.setVisibility(0);
          this.IsH.setText(paramag.Ino.Inx + "  " + paramag.Ino.mZK);
          this.IsF.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(263730);
              int i = RemittanceResultNewUI.n(RemittanceDetailUI.this, paramag.Ino.lLg, RemittanceDetailUI.n(RemittanceDetailUI.this).getWidth());
              if (!Util.isEqual(i, paramag.Ino.lLg.length()))
              {
                String str1 = RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_expand);
                String str2 = paramag.Ino.lLg.substring(0, i) + "... ";
                SpannableString localSpannableString = new SpannableString(str2 + str1);
                com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.GKe = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(277134);
                    RemittanceDetailUI.o(RemittanceDetailUI.this).setVisibility(8);
                    RemittanceDetailUI.p(RemittanceDetailUI.this).setVisibility(0);
                    com.tencent.mm.ui.tools.q.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(a.f.root_view), RemittanceDetailUI.this.findViewById(a.f.parent_view_rl), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_all_container), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_tiem_desc), 72);
                    AppMethodBeat.o(277134);
                  }
                };
                localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
                RemittanceDetailUI.o(RemittanceDetailUI.this).setOnTouchListener(a.fAr());
                RemittanceDetailUI.o(RemittanceDetailUI.this).setText(localSpannableString);
                str1 = RemittanceDetailUI.this.getString(a.i.remittance_desc_operation_collapse);
                str2 = paramag.Ino.lLg + "  ";
                localSpannableString = new SpannableString(str2 + str1);
                locala = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                locala.GKe = new com.tencent.mm.plugin.order.c.a.a()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(257499);
                    RemittanceDetailUI.o(RemittanceDetailUI.this).setVisibility(0);
                    RemittanceDetailUI.p(RemittanceDetailUI.this).setVisibility(8);
                    com.tencent.mm.ui.tools.q.a(RemittanceDetailUI.this, (ScrollView)RemittanceDetailUI.this.findViewById(a.f.root_view), RemittanceDetailUI.this.findViewById(a.f.parent_view_rl), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_all_container), RemittanceDetailUI.this.findViewById(a.f.remittance_detail_tiem_desc), 72);
                    AppMethodBeat.o(257499);
                  }
                };
                i = str2.length();
                int j = str2.length();
                localSpannableString.setSpan(locala, i, str1.length() + j, 33);
                RemittanceDetailUI.p(RemittanceDetailUI.this).setOnTouchListener(a.fAr());
                RemittanceDetailUI.p(RemittanceDetailUI.this).setText(localSpannableString);
              }
              for (;;)
              {
                RemittanceDetailUI.o(RemittanceDetailUI.this).setVisibility(0);
                RemittanceDetailUI.p(RemittanceDetailUI.this).setVisibility(8);
                RemittanceDetailUI.q(RemittanceDetailUI.this).setOnLongClickListener(RemittanceDetailUI.k(RemittanceDetailUI.this));
                RemittanceDetailUI.q(RemittanceDetailUI.this).setOnTouchListener(RemittanceDetailUI.m(RemittanceDetailUI.this));
                AppMethodBeat.o(263730);
                return;
                RemittanceDetailUI.o(RemittanceDetailUI.this).setText(paramag.Ino.lLg);
                RemittanceDetailUI.p(RemittanceDetailUI.this).setText(paramag.Ino.lLg);
              }
            }
          });
          break;
          this.IsD.setVisibility(8);
        }
        label770:
        this.IoD.setVisibility(8);
        break label234;
      }
      this.IsT.setVisibility(8);
      this.IsD.setVisibility(8);
      this.IoD.setVisibility(8);
      this.IsU.setVisibility(8);
      this.IsC.setVisibility(8);
      break label234;
      label830:
      this.IsO.setVisibility(0);
      this.IsP.setVisibility(8);
      this.IsO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramag.Inp.InA, paramag, 11);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68130);
        }
      });
      this.IsK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(277570);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RemittanceDetailUI.a(RemittanceDetailUI.this, paramag.Inp.InA, paramag, 11);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277570);
        }
      });
      break label411;
      label882:
      this.IsU.setVisibility(8);
      this.IsK.setVisibility(8);
      this.IsS.setVisibility(8);
      break label411;
      label912:
      if ((this.Isy.isShown()) && (!Util.isNullOrNil(this.Isy.getText())))
      {
        this.Isz.setVisibility(0);
        this.IsA.setVisibility(0);
        ((RelativeLayout.LayoutParams)this.Isy.getLayoutParams()).removeRule(13);
        com.tencent.mm.wallet_core.ui.g.a(this.Isz, locale.wording, 0, locale.wording.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
        {
          public final void bwz()
          {
            AppMethodBeat.i(266899);
            RemittanceDetailUI.a(RemittanceDetailUI.this, locale.InA, paramag, 12);
            AppMethodBeat.o(266899);
          }
        }, false), this);
        break label433;
      }
      this.Isz.setVisibility(8);
      this.IsA.setVisibility(8);
      ((RelativeLayout.LayoutParams)this.Isy.getLayoutParams()).addRule(13);
      com.tencent.mm.wallet_core.ui.g.a(this.Isy, locale.wording, 0, locale.wording.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void bwz()
        {
          AppMethodBeat.i(278058);
          RemittanceDetailUI.a(RemittanceDetailUI.this, locale.InA, paramag, 12);
          AppMethodBeat.o(278058);
        }
      }, false), this);
      break label433;
      label1087:
      addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(219040);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RemittanceDetailUI.this, 1, false);
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(186698);
              Iterator localIterator = RemittanceDetailUI.24.this.ItL.iterator();
              int i = 0;
              while (localIterator.hasNext())
              {
                ag.e locale = (ag.e)localIterator.next();
                if ((!Util.isNullOrNil(locale.wording)) && (locale.InA != null) && (locale.InA.type != 0))
                {
                  Log.i("MicroMsg.RemittanceDetailUI", " add option :%s", new Object[] { locale.wording });
                  paramAnonymous2o.d(i, locale.wording);
                }
                i += 1;
              }
              AppMethodBeat.o(186698);
            }
          };
          paramAnonymousMenuItem.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(264308);
              if (paramAnonymous2MenuItem.getItemId() > RemittanceDetailUI.24.this.ItL.size() - 1)
              {
                Log.i("MicroMsg.RemittanceDetailUI", "menuItem.getItemId() > mTextInfoList.size() : %s , %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), Integer.valueOf(RemittanceDetailUI.24.this.ItL.size()) });
                AppMethodBeat.o(264308);
                return;
              }
              paramAnonymous2MenuItem = (ag.e)RemittanceDetailUI.24.this.ItL.get(paramAnonymous2MenuItem.getItemId());
              Log.i("MicroMsg.RemittanceDetailUI", " click option menu : %s ,type:%s", new Object[] { paramAnonymous2MenuItem.wording, Integer.valueOf(paramAnonymous2MenuItem.InA.type) });
              switch (paramAnonymous2MenuItem.InA.type)
              {
              default: 
                Log.e("MicroMsg.RemittanceDetailUI", "unknow text info type");
                AppMethodBeat.o(264308);
                return;
              case 1: 
                Log.i("MicroMsg.RemittanceDetailUI", "textInfo.jumpInfo.url ：%s", new Object[] { paramAnonymous2MenuItem.InA.url });
                com.tencent.mm.wallet_core.ui.g.p(RemittanceDetailUI.this.getContext(), paramAnonymous2MenuItem.InA.url, false);
                AppMethodBeat.o(264308);
                return;
              case 2: 
                Log.i("MicroMsg.RemittanceDetailUI", "textInfo.jumpInfo.username ：%s", new Object[] { paramAnonymous2MenuItem.InA.username });
                com.tencent.mm.wallet_core.ui.g.v(paramAnonymous2MenuItem.InA.username, paramAnonymous2MenuItem.InA.InB, 0, 1000);
                AppMethodBeat.o(264308);
                return;
              }
              Log.e("MicroMsg.RemittanceDetailUI", "text info type is OPTIONS_MENU_ITEM_JUMP_TYPE_NATIVE");
              AppMethodBeat.o(264308);
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(219040);
          return true;
        }
      });
    }
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
  
  protected void aP(Intent paramIntent)
  {
    AppMethodBeat.i(68163);
    com.tencent.mm.by.c.b(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(68163);
  }
  
  protected final void aWQ(String paramString)
  {
    AppMethodBeat.i(268124);
    paramString = new ad(this.Itj, this.IoU, this.Ito, "confirm", this.Itk, this.Ith, paramString, this.auA);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    AppMethodBeat.o(268124);
  }
  
  protected void acV(int paramInt)
  {
    AppMethodBeat.i(68160);
    doSceneProgress(new ag(paramInt, this.Itj, this.IoU, this.Ith, this.auA), true);
    AppMethodBeat.o(68160);
  }
  
  protected void acW(int paramInt)
  {
    AppMethodBeat.i(68162);
    if (!getIntent().getBooleanExtra("is_sender", false)) {}
    for (com.tencent.mm.plugin.order.model.h localh = new com.tencent.mm.plugin.order.model.h(this.IoU, this.Itl, paramInt);; localh = new com.tencent.mm.plugin.order.model.h(this.Itj, this.Itl, paramInt))
    {
      localh.setProcessName("RemittanceProcess");
      doSceneProgress(localh);
      AppMethodBeat.o(68162);
      return;
    }
  }
  
  protected final void bW(int paramInt, String paramString)
  {
    AppMethodBeat.i(68172);
    Intent localIntent = new Intent();
    localIntent.putExtra("result_msg", paramString);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(68172);
  }
  
  public final SpannableString cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(268130);
    String str = aa.aL(paramString, this.auA);
    if (str == null)
    {
      paramString = new SpannableString("");
      AppMethodBeat.o(268130);
      return paramString;
    }
    paramString = str;
    if (paramBoolean) {
      paramString = com.tencent.mm.wallet_core.ui.g.ib(str, 9);
    }
    paramString = l.c(MMApplicationContext.getContext(), paramString);
    AppMethodBeat.o(268130);
    return paramString;
  }
  
  protected void fAV()
  {
    AppMethodBeat.i(68164);
    aWQ("");
    AppMethodBeat.o(68164);
  }
  
  protected void fAW()
  {
    AppMethodBeat.i(68165);
    ad localad = new ad(this.Itj, this.IoU, this.Ito, "refuse", this.Itk, this.Ith, this.auA);
    localad.setProcessName("RemittanceProcess");
    doSceneProgress(localad);
    AppMethodBeat.o(68165);
  }
  
  public void finish()
  {
    AppMethodBeat.i(68173);
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_plugin", "remittance");
    localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
    if ((this.Itq != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.Itq, localBundle, true, 1008)))
    {
      this.Itq = null;
      AppMethodBeat.o(68173);
      return;
    }
    super.finish();
    AppMethodBeat.o(68173);
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
    this.IjU = ((ImageView)findViewById(a.f.remittance_detail_desc_icon));
    this.Isu = ((TextView)findViewById(a.f.remittance_detail_result_desc));
    this.Isv = ((TextView)findViewById(a.f.remittance_detail_fee));
    this.Isy = ((TextView)findViewById(a.f.remittance_detail_main_desc1_tv));
    this.Isz = ((TextView)findViewById(a.f.remittance_detail_main_desc2_tv));
    this.IsA = findViewById(a.f.desc_seperator_view);
    this.IsB = ((LinearLayout)findViewById(a.f.remittance_detail_container));
    this.IsC = ((LinearLayout)findViewById(a.f.remittance_info_container));
    this.IsD = ((LinearLayout)findViewById(a.f.remittance_desc_container));
    this.IoD = ((LinearLayout)findViewById(a.f.remittance_address_container));
    this.IsE = ((LinearLayout)findViewById(a.f.remittance_address_content_lv));
    this.IsF = ((TextView)findViewById(a.f.remittance_desc_tv));
    this.IsG = ((TextView)findViewById(a.f.remittance_desc_content_tv));
    this.IsH = ((TextView)findViewById(a.f.name_telephone_tv));
    this.IsI = ((TextView)findViewById(a.f.address_detail_tv));
    this.IsJ = ((TextView)findViewById(a.f.address_detail_spread_tv));
    this.IsK = ((ViewGroup)findViewById(a.f.remittance_operation_container));
    this.IsL = ((ImageView)findViewById(a.f.remittance_operation_icon_iv));
    this.IsM = ((TextView)findViewById(a.f.remittance_operation_name_tv));
    this.IsN = ((TextView)findViewById(a.f.remittance_operation_wording_tv));
    this.IsO = ((ImageView)findViewById(a.f.remittance_operation_arrow_iv));
    this.IsP = ((Button)findViewById(a.f.next_btn));
    this.IsQ = ((TextView)findViewById(a.f.remittance_character_chain_tv));
    this.IsR = ((TextView)findViewById(a.f.remittance_detail_main_desc2_tv));
    this.IsS = findViewById(a.f.remittance_operation_line);
    this.IsT = findViewById(a.f.remittance_info_container_line1);
    this.IsU = findViewById(a.f.remittance_info_container_line2);
    this.IsV = ((Button)findViewById(a.f.remittance_detail_collect_operate_btn));
    this.IsW = ((TextView)findViewById(a.f.remittance_detail_main_operate_desc));
    this.IsX = ((LinearLayout)findViewById(a.f.remittance_detail_operate_container));
    this.IsY = ((LinearLayout)findViewById(a.f.remittance_info_operate_container));
    this.IsZ = ((LinearLayout)findViewById(a.f.remittance_desc_operate_container));
    this.Ita = ((LinearLayout)findViewById(a.f.remittance_address_operate_container));
    this.Itb = ((LinearLayout)findViewById(a.f.remittance_address_content_operate_lv));
    this.Itc = ((TextView)findViewById(a.f.remittance_desc_operate_tv));
    this.Itd = ((TextView)findViewById(a.f.remittance_desc_content_operate_tv));
    this.Ite = ((TextView)findViewById(a.f.name_telephone_operate_tv));
    this.Itf = ((TextView)findViewById(a.f.address_detail_operate_tv));
    this.Itg = ((TextView)findViewById(a.f.address_detail_spread_operate_tv));
    this.Isw = ((TextView)findViewById(a.f.remittance_detail_time_desc_one));
    this.Isx = ((TextView)findViewById(a.f.remittance_detail_time_desc_two));
    this.Itr = ((LinearLayout)findViewById(a.f.remittance_detail_desc_ll));
    this.Its = ((LinearLayout)findViewById(a.f.remittance_detail_desc_container));
    this.Itt = ((RelativeLayout)findViewById(a.f.remittance_detail_payer_ll));
    this.Itu = ((LinearLayout)findViewById(a.f.remittance_detail_receive_ll));
    AppMethodBeat.o(68161);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68159);
    Log.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      acV(0);
    }
    AppMethodBeat.o(68159);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68157);
    super.onCreate(paramBundle);
    this.EIg = new com.tencent.mm.plugin.wallet_core.utils.g(this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(271687);
        if (RemittanceDetailUI.d(RemittanceDetailUI.this) == null)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(271687);
          return false;
        }
        if (RemittanceDetailUI.d(RemittanceDetailUI.this).EIf == null)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(271687);
          return false;
        }
        if (!com.tencent.mm.plugin.wallet_core.utils.g.a(RemittanceDetailUI.d(RemittanceDetailUI.this).EIf))
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(271687);
          return false;
        }
        RemittanceDetailUI.e(RemittanceDetailUI.this).a(RemittanceDetailUI.d(RemittanceDetailUI.this).EIf, new g.a()
        {
          public final void a(coi paramAnonymous2coi)
          {
            AppMethodBeat.i(220563);
            if (paramAnonymous2coi.action == 1)
            {
              RemittanceDetailUI.this.finish();
              AppMethodBeat.o(220563);
              return;
            }
            AppMethodBeat.o(220563);
          }
        });
        RemittanceDetailUI.d(RemittanceDetailUI.this).EIf = null;
        AppMethodBeat.o(271687);
        return false;
      }
    });
    this.Ith = getIntent().getIntExtra("invalid_time", 0);
    this.Iti = getIntent().getIntExtra("appmsg_type", 0);
    this.Itj = getIntent().getStringExtra("transaction_id");
    this.Itl = getIntent().getStringExtra("bill_id");
    this.IoU = getIntent().getStringExtra("transfer_id");
    this.Itk = getIntent().getStringExtra("sender_name");
    this.Itm = getIntent().getIntExtra("effective_date", 3);
    this.Itn = getIntent().getBooleanExtra("is_sender", false);
    this.Ito = getIntent().getIntExtra("total_fee", 0);
    this.iSo = getIntent().getLongExtra("key_msg_id", 0L);
    if (ab.Lj(this.Itk)) {
      this.auA = this.Itk;
    }
    initView();
    acV(0);
    getIntent();
    EventCenter.instance.addListener(this.Itv);
    this.Itw.alive();
    this.Itx.alive();
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
    EventCenter.instance.removeListener(this.Itv);
    if (this.Itw != null) {
      this.Itw.dead();
    }
    this.Itx.dead();
    super.onDestroy();
    AppMethodBeat.o(68158);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(268123);
    boolean bool;
    if (paramInt != 4)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(268123);
      return bool;
    }
    if (this.Itq == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(268123);
      return bool;
    }
    if (this.Itq.EIf == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(268123);
      return bool;
    }
    if (!com.tencent.mm.plugin.wallet_core.utils.g.a(this.Itq.EIf))
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(268123);
      return bool;
    }
    this.EIg.a(this.Itq.EIf, new g.a()
    {
      public final void a(coi paramAnonymouscoi)
      {
        AppMethodBeat.i(267304);
        if (paramAnonymouscoi.action == 1)
        {
          RemittanceDetailUI.this.finish();
          AppMethodBeat.o(267304);
          return;
        }
        AppMethodBeat.o(267304);
      }
    });
    this.Itq.EIf = null;
    AppMethodBeat.o(268123);
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(68170);
    label193:
    label991:
    label1395:
    label1653:
    final boolean bool;
    label520:
    label3467:
    if ((paramq instanceof ag))
    {
      final ag localag = (ag)paramq;
      label801:
      label806:
      label3878:
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.remittance.a.c.fzJ();
        paramString = com.tencent.mm.plugin.remittance.a.c.fzL().aWB(this.IoU);
        Object localObject;
        if (paramString != null)
        {
          paramString.field_hasClicked = true;
          paramInt1 = localag.status;
          if (paramInt1 != 2000)
          {
            if (paramInt1 == 2001) {
              paramString.field_receiveStatus = 3;
            }
          }
          else
          {
            com.tencent.mm.plugin.remittance.a.c.fzJ();
            com.tencent.mm.plugin.remittance.a.c.fzL().a(paramString);
            com.tencent.mm.plugin.remittance.a.c.fzJ().aWx(paramString.field_talker);
          }
        }
        else
        {
          if (localag != null)
          {
            Log.i("MicroMsg.RemittanceDetailUI", "groupname: %s, %s", new Object[] { this.auA, Integer.valueOf(localag.Inu) });
            paramInt1 = 0;
            if ((Util.isNullOrNil(this.auA)) || (localag.Inu <= 0)) {
              break label820;
            }
            this.GHU = localag.Inj;
            this.GHN = localag.Inh;
            if (localag.Inu != 1) {
              break label806;
            }
            if (!localag.DLI) {
              break label801;
            }
            paramInt1 = 1;
            z.bcZ();
            this.Isv.setText(com.tencent.mm.wallet_core.ui.g.d(localag.tVK, localag.GHz));
            this.Isv.setTextSize(1, 48.0F);
            paramq = localag.Inl;
            paramString = paramq;
            if (!Util.isNullOrNil(paramq))
            {
              paramString = paramq;
              if (paramq.contains("%s")) {
                paramString = paramq.trim().replace("%s", cj(this.GHN, false));
              }
            }
            paramq = paramString;
            if (!Util.isNullOrNil(paramString))
            {
              paramq = paramString;
              if (paramString.contains("%d")) {
                paramq = paramString.trim().replace("%d", cj(this.GHU, false));
              }
            }
            paramString = localag.Inm;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.Itj);
            ((Bundle)localObject).putString("receiver_name", this.GHN);
            ((Bundle)localObject).putString("transfer_id", this.IoU);
            ((Bundle)localObject).putInt("total_fee", this.Ito);
            ((Bundle)localObject).putString("sender_name", this.Itk);
            ((Bundle)localObject).putInt("invalid_time", this.Ith);
            ((Bundle)localObject).putParcelable("resend_msg_info", localag.Inr);
            this.Isy.setClickable(true);
            this.Isu.setClickable(true);
            this.IsW.setClickable(true);
            paramInt2 = localag.status;
            Log.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[] { Integer.valueOf(paramInt2) });
          }
          switch (paramInt2)
          {
          default: 
            finish();
            if (!Util.isNullOrNil(localag.Inv)) {
              com.tencent.mm.wallet_core.ui.g.a((TextView)findViewById(a.f.banner_tips), "7", localag.Inv, localag.Inw);
            }
            this.Itp = localag.Inn;
            com.tencent.mm.kernel.h.aHH();
            this.IoN = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnR, ""));
            com.tencent.mm.kernel.h.aHH();
            this.IoO = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnS, Integer.valueOf(0))).intValue();
            if (Util.isNullOrNil(this.IoN))
            {
              ak.a(true, this.mNetSceneMgr);
              if (localag.GIg == 1)
              {
                com.tencent.mm.kernel.h.aHH();
                if (((String)com.tencent.mm.kernel.h.aHG().aHp().b(327729, "0")).equals("0"))
                {
                  paramString = getContext();
                  if (!z.bdq()) {
                    break label4264;
                  }
                }
              }
            }
            break;
          }
        }
        label2855:
        label4264:
        for (paramInt1 = a.i.chatting_item_appmsg_remittance_collect_tips_payu;; paramInt1 = a.i.wallet_remittance_collect_tips)
        {
          com.tencent.mm.ui.base.h.a(paramString, paramInt1, a.i.wallet_remittance_collect_title, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68143);
              AppMethodBeat.o(68143);
            }
          });
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(327729, "1");
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
          paramInt1 = 2;
          break label193;
          if (localag.Inu != 2) {
            break label193;
          }
          paramInt1 = 3;
          break label193;
          label820:
          if (localag.DLI)
          {
            this.GHU = z.bcZ();
            this.GHN = this.Itk;
            paramInt1 = 1;
            break label193;
          }
          this.GHU = this.Itk;
          this.GHN = z.bcZ();
          paramInt1 = 2;
          break label193;
          if (paramInt1 == 1)
          {
            this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
            if ((!Util.isNullOrNil(paramq)) && (!Util.isNullOrNil(paramString)))
            {
              this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
              this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
              this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              a(false, false, localag);
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ing) }));
            this.Isw.setVisibility(0);
            this.Isw.setVisibility(8);
            this.Isx.setVisibility(8);
            break;
            paramString = getString(a.i.remittance_detail_result_wait_sender, new Object[] { cj(this.GHN, true) });
            this.Isu.setText(l.b(this, paramString, this.Isu.getTextSize()));
            paramString = getString(a.i.remittance_detail_sender_tips, new Object[] { Integer.valueOf(this.Itm) });
            paramq = getString(a.i.remittance_remind_collection_msg);
            localObject = new SpannableString(paramString + paramq);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.GKe = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68150);
                new d(RemittanceDetailUI.this).a(localag.Inr, new f.c()
                {
                  public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(269781);
                    if (paramAnonymous2Boolean)
                    {
                      paramAnonymous2String = new Intent();
                      paramAnonymous2String.putExtra("transaction_id", RemittanceDetailUI.this.Itj);
                      paramAnonymous2String.putExtra("transfer_id", RemittanceDetailUI.this.IoU);
                      paramAnonymous2String.putExtra("receiver_name", RemittanceDetailUI.f(RemittanceDetailUI.this));
                      paramAnonymous2String.putExtra("resend_msg_from_flag", 3);
                      RemittanceDetailUI.this.aP(paramAnonymous2String);
                    }
                    AppMethodBeat.o(269781);
                  }
                });
                AppMethodBeat.o(68150);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramq.length(), 33);
            this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
            this.Isy.setText((CharSequence)localObject);
            break label991;
            if (paramInt1 != 2) {
              break label1653;
            }
            Log.i("MicroMsg.RemittanceDetailUI", "set click reveive btn");
            this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_outlined_time, getContext().getResources().getColor(a.c.Blue)));
            this.IsV.setVisibility(0);
            this.IsV.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68151);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                Log.i("MicroMsg.RemittanceDetailUI", "click reveive btn");
                ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.b.class)).ij(9, 4);
                u.gJi();
                paramAnonymousView = RemittanceDetailUI.this;
                localObject = RemittanceDetailUI.g(RemittanceDetailUI.this);
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a()
                {
                  public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
                  {
                    AppMethodBeat.i(276900);
                    Log.i("MicroMsg.RemittanceDetailUI", "resultCode :%s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                    if (paramAnonymous2Int1 == 2)
                    {
                      RemittanceDetailUI.this.fAV();
                      AppMethodBeat.o(276900);
                      return true;
                    }
                    if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean)) {
                      RemittanceDetailUI.this.fAV();
                    }
                    AppMethodBeat.o(276900);
                    return true;
                  }
                };
                boolean bool = u.a(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject);
                Log.i("MicroMsg.RemittanceDetailUI", "click reveive btn，ret :%s", new Object[] { Boolean.valueOf(bool) });
                if (!bool) {
                  RemittanceDetailUI.this.fAV();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68151);
              }
            });
            if ((Util.isNullOrNil(paramq)) || (Util.isNullOrNil(paramString))) {
              break label1395;
            }
            this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
            this.IsW.setText(l.a(this, paramString, (int)this.IsW.getTextSize(), localObject));
            this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
            this.IsW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
            a(true, false, localag);
          }
          this.Isu.setText(a.i.remittance_detail_result_wait_receiver);
          if (localag.Inn != 0) {
            if (!Util.isNullOrNil(localag.Inm)) {
              paramString = localag.Inm;
            }
          }
          for (;;)
          {
            paramq = getString(a.i.remittance_detail_refuse_action);
            localObject = new SpannableString(paramString + paramq);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.GKe = new com.tencent.mm.plugin.order.c.a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68152);
                com.tencent.mm.ui.base.h.c(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(a.i.remittance_detail_refund_tips, new Object[] { RemittanceDetailUI.this.cj(localag.Inj, false) }), RemittanceDetailUI.this.getString(a.i.app_remind), RemittanceDetailUI.this.getString(a.i.remittance_detail_refuse_btn_text), RemittanceDetailUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(274024);
                    RemittanceDetailUI.this.fAW();
                    AppMethodBeat.o(274024);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(68152);
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramq.length(), 33);
            this.IsW.setMovementMethod(LinkMovementMethod.getInstance());
            this.IsW.setText((CharSequence)localObject);
            break;
            Log.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localag.Inn == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(a.i.remittance_detail_reveiver_tips1, new Object[] { paramString });
              paramq = getString(a.i.remittance_detail_reveiver_tips2, new Object[] { Integer.valueOf(this.Itm) });
              paramString = paramString + paramq;
              break;
            }
            paramString = getString(a.i.remittance_detail_reveiver_tips2, new Object[] { Integer.valueOf(this.Itm) });
          }
          this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
          if (!Util.isNullOrNil(paramq))
          {
            this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
            this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
          }
          for (;;)
          {
            if (!Util.isNullOrNil(paramString))
            {
              this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
              this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
            }
            a(false, false, localag);
            break;
            this.Isu.setText(a.i.remittance_detail_others_desc);
          }
          this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_filled_done2, getContext().getResources().getColor(a.c.Brand)));
          if (!Util.isNullOrNil(paramq))
          {
            this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
            this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
            if (!Util.isNullOrNil(paramString))
            {
              this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
              this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              this.Isy.setVisibility(0);
            }
            if (paramInt1 != 2) {
              break label2268;
            }
            a(false, true, localag);
          }
          for (;;)
          {
            this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ing) }));
            this.Isw.setVisibility(0);
            this.Isw.setVisibility(8);
            this.Isx.setText(getString(a.i.remittance_detail_receive_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ink) }));
            this.Isx.setVisibility(0);
            this.Isx.setVisibility(8);
            break;
            if (paramInt1 == 2)
            {
              this.Isu.setText(a.i.remittance_detail_result_collected);
              paramString = new SpannableStringBuilder(getString(a.i.remittance_detail_check_ballance));
              paramq = new com.tencent.mm.plugin.order.c.a(this);
              paramq.GKe = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(267601);
                  com.tencent.mm.pluginsdk.wallet.f.aX(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(267601);
                }
              };
              paramString.setSpan(paramq, 0, paramString.length(), 18);
              this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
              this.Isy.setText(paramString);
              this.Isy.setVisibility(0);
              break label1935;
            }
            if (paramInt1 == 1)
            {
              paramString = cj(this.GHN, true) + getString(a.i.remittance_detail_result_collected);
              this.Isu.setText(l.b(this, paramString, this.Isu.getTextSize()));
              this.Isy.setVisibility(8);
              break label1935;
            }
            if (!Util.isNullOrNil(paramq))
            {
              this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
              this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              break label1935;
            }
            this.Isu.setText(a.i.remittance_detail_others_desc);
            break label1935;
            label2268:
            a(false, false, localag);
          }
          if (paramInt2 == 2003)
          {
            this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_filled_error, getContext().getResources().getColor(a.c.Red)));
            if (Util.isNullOrNil(paramq)) {
              break label2548;
            }
            this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
            this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
            label2361:
            if (Util.isNullOrNil(paramString)) {
              break label2661;
            }
            this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
            this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
            this.Isy.setVisibility(0);
          }
          for (;;)
          {
            a(false, false, localag);
            this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ing) }));
            this.Isw.setVisibility(0);
            this.Isw.setVisibility(8);
            this.Isx.setText(getString(a.i.remittance_detail_refund_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ink) }));
            this.Isx.setVisibility(0);
            this.Isx.setVisibility(8);
            break;
            this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_filled_previous2, getContext().getResources().getColor(a.c.Yellow)));
            break label2316;
            label2548:
            if (paramInt1 == 1)
            {
              if (paramInt2 == 2003)
              {
                this.Isu.setText(a.i.remittance_detail_result_timeout_refunded);
                break label2361;
              }
              paramq = cj(this.GHN, true) + getString(a.i.remittance_detail_result_refunded);
              this.Isu.setText(l.b(this, paramq, this.Isu.getTextSize()));
              break label2361;
            }
            if (paramInt1 == 2)
            {
              this.Isu.setText(a.i.remittance_detail_result_refunded);
              break label2361;
            }
            this.Isu.setText(a.i.remittance_detail_others_desc);
            break label2361;
            label2661:
            if (paramInt1 == 1)
            {
              if (("CFT".equals(localag.GHW)) || ("LQT".equals(localag.GHW)))
              {
                bool = "LQT".equals(localag.GHW);
                if (bool)
                {
                  paramString = getString(a.i.remittance_detail_refund_to_lqt);
                  if (!bool) {
                    break label2855;
                  }
                  paramq = getString(a.i.remittance_detail_check_lqt);
                  localObject = new SpannableString(paramString + paramq);
                  locala = new com.tencent.mm.plugin.order.c.a(this);
                  locala.GKe = new com.tencent.mm.plugin.order.c.a.a()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(277410);
                      if (bool)
                      {
                        com.tencent.mm.by.c.ad(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                        AppMethodBeat.o(277410);
                        return;
                      }
                      com.tencent.mm.pluginsdk.wallet.f.aX(RemittanceDetailUI.this, 0);
                      AppMethodBeat.o(277410);
                    }
                  };
                  paramInt1 = paramString.length();
                  paramInt2 = paramString.length();
                  ((SpannableString)localObject).setSpan(locala, paramInt1, paramq.length() + paramInt2, 33);
                  this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
                  this.Isy.setText((CharSequence)localObject);
                }
              }
              for (;;)
              {
                this.Isy.setVisibility(0);
                break;
                paramString = getString(a.i.remittance_detail_refund_to_ballance);
                break label2720;
                paramq = getString(a.i.remittance_detail_check_ballance);
                break label2734;
                this.Isy.setText(a.i.remittance_detail_refund_to_bankcard);
              }
            }
            label2734:
            this.Isy.setVisibility(8);
          }
          if (paramInt1 == 2)
          {
            this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
            if ((!Util.isNullOrNil(paramq)) && (!Util.isNullOrNil(paramString)))
            {
              this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
              this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
              this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              this.Isy.setVisibility(0);
            }
          }
          label3634:
          for (;;)
          {
            a(false, false, localag);
            this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ing) }));
            this.Isw.setVisibility(0);
            this.Isw.setVisibility(8);
            this.Isx.setText(getString(a.i.remittance_detail_receive_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ink) }));
            this.Isx.setVisibility(0);
            this.Isx.setVisibility(8);
            break;
            if (!Util.isNullOrNil(localag.Inl)) {
              this.Isu.setText(localag.Inl);
            }
            for (;;)
            {
              if (Util.isNullOrNil(localag.Inm)) {
                break label3196;
              }
              this.Isy.setText(localag.Inm);
              this.Isy.setVisibility(0);
              break;
              this.Isu.setText(a.i.remittance_detail_result_receiver_waited);
            }
            label3196:
            this.Isy.setText("");
            continue;
            if (paramInt1 == 1)
            {
              this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
              if ((!Util.isNullOrNil(paramq)) && (!Util.isNullOrNil(paramString)))
              {
                this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
                this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
                this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
                this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
                this.Isy.setVisibility(0);
              }
              else
              {
                if (!Util.isNullOrNil(localag.Inl)) {}
                for (;;)
                {
                  try
                  {
                    this.Isu.setText(String.format(localag.Inl, new Object[] { cj(this.GHN, true) }));
                    if (Util.isNullOrNil(localag.Inm)) {
                      break label3467;
                    }
                    this.Isy.setText(localag.Inm);
                    this.Isy.setVisibility(0);
                  }
                  catch (Exception paramString)
                  {
                    Log.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                  }
                  this.Isu.setText(getString(a.i.remittance_detail_result_sender_waited, new Object[] { cj(this.GHN, true) }));
                }
                this.Isy.setText("");
              }
            }
            else
            {
              this.IjU.setImageDrawable(au.o(getContext(), a.h.icons_filled_time, getContext().getResources().getColor(a.c.Blue)));
              if (!Util.isNullOrNil(paramq))
              {
                this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
                this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              }
              for (;;)
              {
                if (Util.isNullOrNil(paramString)) {
                  break label3634;
                }
                this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
                this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
                this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
                this.Isy.setVisibility(0);
                break;
                this.Isu.setText(a.i.remittance_detail_others_desc);
              }
            }
          }
          this.IjU.setImageResource(a.h.remittance_cancle);
          if ((paramInt1 == 1) || (paramInt1 == 2)) {
            if ((!Util.isNullOrNil(paramq)) && (!Util.isNullOrNil(paramString)))
            {
              this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
              this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
              this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
            }
          }
          for (;;)
          {
            a(false, false, localag);
            this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ing) }));
            this.Isw.setVisibility(0);
            this.Isw.setVisibility(8);
            if (localag.Ink <= 0) {
              break label4240;
            }
            this.Isx.setText(getString(a.i.remittance_detail_cancel_time, new Object[] { com.tencent.mm.wallet_core.ui.g.uW(localag.Ink) }));
            this.Isx.setVisibility(0);
            this.Isx.setVisibility(8);
            break;
            if (!Util.isNullOrNil(localag.Inl))
            {
              this.Isu.setText(localag.Inl);
              if (Util.isNullOrNil(localag.Inm)) {
                break label4076;
              }
              if ((!"CFT".equals(localag.GHW)) && (!"LQT".equals(localag.GHW))) {
                break label4061;
              }
              bool = "LQT".equals(localag.GHW);
              paramq = localag.Inm;
              if (!bool) {
                break label4050;
              }
            }
            label4050:
            for (paramString = getString(a.i.remittance_detail_check_lqt);; paramString = getString(a.i.remittance_detail_check_ballance))
            {
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(paramq);
              ((SpannableStringBuilder)localObject).append(paramString);
              paramString = new com.tencent.mm.plugin.order.c.a(this);
              paramString.GKe = new com.tencent.mm.plugin.order.c.a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(68126);
                  if (bool)
                  {
                    com.tencent.mm.by.c.ad(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(68126);
                    return;
                  }
                  com.tencent.mm.pluginsdk.wallet.f.aX(RemittanceDetailUI.this, 0);
                  AppMethodBeat.o(68126);
                }
              };
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramq.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
              this.Isy.setText((CharSequence)localObject);
              break;
              this.Isu.setText(a.i.remittance_detail_result_canceled);
              break label3878;
            }
            label4061:
            this.Isy.setText(localag.Inm);
            continue;
            label4076:
            if (paramInt1 == 2)
            {
              this.Isy.setText(a.i.remittance_detail_receiver_cancel_tips);
            }
            else if (paramInt1 == 1)
            {
              this.Isy.setText(a.i.remittance_detail_sender_cancel_tips);
              continue;
              this.IjU.setImageResource(a.h.remittance_cancle);
              if (!Util.isNullOrNil(paramq))
              {
                this.Isu.setText(l.a(this, paramq, (int)this.Isu.getTextSize(), localObject));
                this.Isu.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
              }
              for (;;)
              {
                if (Util.isNullOrNil(paramString)) {
                  break label4238;
                }
                this.Isy.setText(l.a(this, paramString, (int)this.Isy.getTextSize(), localObject));
                this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
                this.Isy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
                break;
                this.Isu.setText(a.i.remittance_detail_others_desc);
              }
            }
          }
          this.Isx.setVisibility(8);
          break label520;
          ak.a(false, this.mNetSceneMgr);
          break label641;
        }
      }
    }
    else
    {
      label1935:
      label2720:
      if ((paramq instanceof ad))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.Itq = ((ad)paramq);
          if ((this.Itq.isJumpRemind()) && (this.Itq.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void eOt()
            {
              AppMethodBeat.i(230813);
              RemittanceDetailUI.a(RemittanceDetailUI.this, RemittanceDetailUI.d(RemittanceDetailUI.this));
              AppMethodBeat.o(230813);
            }
          })))
          {
            AppMethodBeat.o(68170);
            return true;
          }
          if (com.tencent.mm.plugin.wallet_core.utils.g.a(this.Itq.EAY))
          {
            new com.tencent.mm.plugin.wallet_core.utils.g(this).a(this.Itq.EAY, new g.a()
            {
              public final void a(coi paramAnonymouscoi)
              {
                AppMethodBeat.i(187113);
                if (paramAnonymouscoi.action == 2)
                {
                  RemittanceDetailUI.this.aWQ(RemittanceDetailUI.d(RemittanceDetailUI.this).EBK);
                  AppMethodBeat.o(187113);
                  return;
                }
                if (paramAnonymouscoi.action == 1)
                {
                  RemittanceDetailUI.this.finish();
                  AppMethodBeat.o(187113);
                  return;
                }
                AppMethodBeat.o(187113);
              }
            });
            AppMethodBeat.o(68170);
            return true;
          }
          a(this.Itq);
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
          paramq = getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(238273);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(238273);
          }
        });
        AppMethodBeat.o(68170);
        return true;
      }
      label2316:
      label4238:
      label4240:
      if ((paramq instanceof ak))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.IoN = ((ak)paramq).OIG;
          this.IoO = ((ak)paramq).OIH;
        }
        for (;;)
        {
          AppMethodBeat.o(68170);
          return true;
          Log.i("MicroMsg.RemittanceDetailUI", "net error");
        }
      }
    }
    label641:
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