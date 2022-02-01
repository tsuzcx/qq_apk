package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.t;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.c;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class WalletLqtDetailUI
  extends WalletLqtBasePresenterUI
{
  private static final int oKX;
  private t CAK;
  private u CAL;
  private cou CAM;
  private ViewGroup CAN;
  private TextView CAO;
  private ViewGroup CAP;
  private TextView CAQ;
  private TextView CAR;
  private ViewGroup CAS;
  private TextView CAT;
  private WalletTextView CAU;
  private Button CAV;
  private Button CAW;
  private LinearLayout CAX;
  private LinearLayout CAY;
  private TextView CAZ;
  private TextView CBa;
  private View CBb;
  private TextView CBc;
  private RelativeLayout CBd;
  private View CBe;
  private View CBf;
  private CdnImageView CBg;
  private TextView CBh;
  private TextView CBi;
  private LinearLayout CBj;
  private TextView CBk;
  private TextView CBl;
  private TextView CBm;
  private TextView CBn;
  private WcPayMoneyLoadingView CBo;
  private boolean CBp;
  private boolean CBq;
  private boolean CBr;
  private ap handler;
  private Dialog iVd;
  private ProgressBar vFY;
  
  static
  {
    AppMethodBeat.i(68832);
    oKX = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 16);
    AppMethodBeat.o(68832);
  }
  
  public WalletLqtDetailUI()
  {
    AppMethodBeat.i(68814);
    this.CAK = ((t)aq(t.class));
    this.CAL = ((u)am(u.class));
    this.CBp = true;
    this.handler = new ap(Looper.getMainLooper());
    this.CBq = false;
    this.CBr = false;
    AppMethodBeat.o(68814);
  }
  
  private void aDT(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(68821);
    ad.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    String str;
    if (this.CAM != null)
    {
      str = this.CAM.HgB;
      localIntent.putExtra("lqt_save_fund_code", str);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (this.CAM.dMY != 1) {
        break label260;
      }
      bool1 = true;
      label74:
      localIntent.putExtra("lqt_is_show_protocol", bool1);
      if (this.CAM.HhI != 1) {
        break label265;
      }
    }
    label260:
    label265:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("lqt_is_agree_protocol", bool1);
      localIntent.putStringArrayListExtra("lqt_protocol_list", eCO());
      localIntent.putExtra("lqt_profile_wording", this.CAM.Hhx);
      localIntent.putExtra("lqt_account_type", this.CAM.uxm);
      localIntent.putExtra("lqt_fund_spid", this.CAM.HgD);
      localIntent.putExtra("operate_id", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(68821);
      return;
      str = null;
      break;
      bool1 = false;
      break label74;
    }
  }
  
  private void aDU(String paramString)
  {
    AppMethodBeat.i(68822);
    ad.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    localIntent.putExtra("lqt_save_fetch_mode", 2);
    localIntent.putExtra("lqt_balance", this.CAM.GXO);
    localIntent.putExtra("lqt_max_redeem_amount", this.CAM.HhP);
    localIntent.putExtra("lqt_redeem_invalid_amount_hint", this.CAM.HhQ);
    localIntent.putExtra("lqt_account_type", this.CAM.uxm);
    localIntent.putExtra("operate_id", paramString);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(68822);
  }
  
  private void dhw()
  {
    AppMethodBeat.i(68823);
    removeAllOptionMenu();
    if (this.CAM != null)
    {
      if ((this.CAM.Hif != null) && (this.CAM.Hif.size() == 1) && (this.CAM.HhS))
      {
        ad.i("MicroMsg.WalletLqtDetailUI", "show text menu");
        ccg localccg = (ccg)this.CAM.Hif.get(0);
        addTextOptionMenu(0, localccg.title, new WalletLqtDetailUI.14(this, localccg));
        AppMethodBeat.o(68823);
        return;
      }
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(199213);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletLqtDetailUI.this, 1, false);
          paramAnonymousMenuItem.KJy = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(199210);
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hif != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hif.size() > 0))
              {
                Iterator localIterator = WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hif.iterator();
                int i = 0;
                while (localIterator.hasNext())
                {
                  ccg localccg = (ccg)localIterator.next();
                  if (!bt.isNullOrNil(localccg.title)) {
                    paramAnonymous2l.c(i, localccg.title);
                  }
                  i += 1;
                }
              }
              if (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).HhS) {
                paramAnonymous2l.a(-1, WalletLqtDetailUI.this.getContext().getResources().getColor(2131099803), WalletLqtDetailUI.this.getString(2131765387));
              }
              AppMethodBeat.o(199210);
            }
          };
          paramAnonymousMenuItem.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(199212);
              if ((paramAnonymous2MenuItem.getItemId() == -1) && (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).HhS))
              {
                if (!bt.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).HhX)) {
                  paramAnonymous2MenuItem = WalletLqtDetailUI.d(WalletLqtDetailUI.this).HhX;
                }
                for (;;)
                {
                  h.a(WalletLqtDetailUI.this, paramAnonymous2MenuItem, "", WalletLqtDetailUI.this.getString(2131757429), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(199211);
                      WalletLqtDetailUI.h(WalletLqtDetailUI.this);
                      paramAnonymous3DialogInterface = new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class);
                      WalletLqtDetailUI.this.startActivityForResult(paramAnonymous3DialogInterface, 123);
                      AppMethodBeat.o(199211);
                    }
                  });
                  AppMethodBeat.o(199212);
                  return;
                  if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).uxm == 0) {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131765389);
                  } else {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131765372);
                  }
                }
              }
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hif != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hif.size() > 0) && (paramAnonymous2MenuItem.getItemId() < WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hif.size()))
              {
                paramAnonymous2MenuItem = (ccg)WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hif.get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem.GVZ != 1) {
                  if (paramAnonymous2MenuItem.GVZ == 2)
                  {
                    if (!bt.isNullOrNil(paramAnonymous2MenuItem.Gdh))
                    {
                      com.tencent.mm.wallet_core.ui.e.n(WalletLqtDetailUI.this, paramAnonymous2MenuItem.Gdh, false);
                      AppMethodBeat.o(199212);
                    }
                  }
                  else if ((paramAnonymous2MenuItem.GVZ == 3) && (!bt.isNullOrNil(paramAnonymous2MenuItem.FRw)) && (!bt.isNullOrNil(paramAnonymous2MenuItem.Gdh))) {
                    com.tencent.mm.wallet_core.ui.e.v(paramAnonymous2MenuItem.FRw, paramAnonymous2MenuItem.Gdh, 0, 1061);
                  }
                }
              }
              AppMethodBeat.o(199212);
            }
          };
          paramAnonymousMenuItem.cMW();
          AppMethodBeat.o(199213);
          return false;
        }
      });
    }
    AppMethodBeat.o(68823);
  }
  
  private ArrayList<String> eCO()
  {
    AppMethodBeat.i(68816);
    ArrayList localArrayList = new ArrayList();
    if ((this.CAM.HhJ != null) && (this.CAM.HhJ.size() > 0))
    {
      Iterator localIterator = this.CAM.HhJ.iterator();
      while (localIterator.hasNext())
      {
        afa localafa = (afa)localIterator.next();
        if ((!bt.isNullOrNil(localafa.title)) && (!bt.isNullOrNil(localafa.Gdh))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localafa.title, localafa.Gdh }));
        }
      }
    }
    AppMethodBeat.o(68816);
    return localArrayList;
  }
  
  private void eCP()
  {
    AppMethodBeat.i(199220);
    ad.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView");
    if (!this.CBr)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(17084, new Object[] { Integer.valueOf(10) });
      this.CBr = true;
      ad.i("MicroMsg.WalletLqtDetailUI", "ReportShowLctOperationView");
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131494615, this.CAY, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(2131301687);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(2131301686);
    localTextView1.setText(this.CAM.Hii.GOo.title);
    localTextView2.setText(this.CAM.Hii.GOo.desc);
    if (this.CAM.Hii.GOo.GVZ != 1)
    {
      if (this.CAM.Hii.GOo.GVZ != 2) {
        break label228;
      }
      if (!bt.isNullOrNil(this.CAM.Hii.GOo.Gdh))
      {
        localViewGroup.setTag(this.CAM.Hii.GOo.Gdh);
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.18(this, localViewGroup));
      }
    }
    for (;;)
    {
      this.CAY.addView(localViewGroup);
      AppMethodBeat.o(199220);
      return;
      label228:
      if ((this.CAM.Hii.GOo.GVZ == 3) && (!bt.isNullOrNil(this.CAM.Hii.GOo.FRw)) && (!bt.isNullOrNil(this.CAM.Hii.GOo.Gdh))) {
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.19(this));
      }
    }
  }
  
  private void tV(boolean paramBoolean)
  {
    AppMethodBeat.i(68820);
    Object localObject1;
    if (this.CAM != null)
    {
      this.CAN.setVisibility(0);
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.ICI, Long.valueOf(0L))).longValue();
      localObject1 = this.CBo;
      Object localObject2 = com.tencent.mm.wallet_core.ui.e.C(com.tencent.mm.wallet_core.ui.e.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP));
      label127:
      int i;
      label163:
      label338:
      label373:
      Object localObject3;
      label452:
      TextView localTextView1;
      TextView localTextView2;
      CdnImageView localCdnImageView;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((WcPayMoneyLoadingView)localObject1).ck((String)localObject2, paramBoolean);
        localObject1 = (ImageView)findViewById(2131301640);
        if (localObject1 != null)
        {
          if (bt.isNullOrNil(this.CAM.HhT)) {
            break label695;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = (ImageView)findViewById(2131301658);
        if (localObject1 != null)
        {
          if (bt.isNullOrNil(this.CAM.HhT)) {
            break label705;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = new WalletLqtDetailUI.20(this);
        this.CBd.setOnClickListener((View.OnClickListener)localObject1);
        this.CBo.setOnClickListener((View.OnClickListener)localObject1);
        this.CAP.setOnClickListener(new WalletLqtDetailUI.21(this));
        this.CAQ.setText(this.CAM.HhD);
        this.CAR.setText(this.CAM.HhE);
        this.CAT.setText(this.CAM.HhF);
        this.CAU.setText(com.tencent.mm.wallet_core.ui.e.D(com.tencent.mm.wallet_core.ui.e.a(this.CAM.HhG, "100", 2, RoundingMode.HALF_UP)));
        this.CAS.setOnClickListener(new WalletLqtDetailUI.22(this));
        if (bt.isNullOrNil(this.CAM.HhW)) {
          break label715;
        }
        this.CBl.setText(this.CAM.HhW);
        this.CBl.setVisibility(0);
        if (bt.isNullOrNil(this.CAM.Hic)) {
          break label726;
        }
        this.CBm.setText(this.CAM.Hic);
        this.CBm.setVisibility(0);
        this.CAX.removeAllViews();
        this.CAY.removeAllViews();
        if ((this.CAM.Hii != null) && (this.CAM.Hii.GOn == 1)) {
          eCP();
        }
        if ((this.CAM.HhV == null) || (this.CAM.HhV.isEmpty())) {
          break label938;
        }
        localObject1 = this.CAM.HhV.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label1126;
        }
        localObject3 = (ccg)((Iterator)localObject1).next();
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494610, this.CAX, false);
        localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131301651);
        localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131301649);
        localCdnImageView = (CdnImageView)((ViewGroup)localObject2).findViewById(2131301372);
        View localView = ((ViewGroup)localObject2).findViewById(2131301374);
        if (i == this.CAM.HhV.size() - 1) {
          localView.setVisibility(8);
        }
        localTextView1.setText(((ccg)localObject3).title);
        localTextView2.setText(((ccg)localObject3).desc);
        if (bt.isNullOrNil(((ccg)localObject3).dDH)) {
          break label737;
        }
        localCdnImageView.setUseSdcardCache(true);
        localCdnImageView.setUrl(((ccg)localObject3).dDH);
        localCdnImageView.setVisibility(0);
        label619:
        if (((ccg)localObject3).GVZ != 1) {
          break label839;
        }
        if (!"wxpay://lqt/planindex".equals(((ccg)localObject3).Gdh)) {
          break label747;
        }
        ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.23(this, (ccg)localObject3));
      }
      label695:
      label705:
      label839:
      for (;;)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
        this.CAX.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i += 1;
        break label452;
        paramBoolean = false;
        break;
        ((ImageView)localObject1).setVisibility(8);
        break label127;
        ((ImageView)localObject1).setVisibility(8);
        break label163;
        label715:
        this.CBl.setVisibility(4);
        break label338;
        label726:
        this.CBm.setVisibility(4);
        break label373;
        label737:
        localCdnImageView.setVisibility(8);
        break label619;
        label747:
        if ("wxpay://lqt/autochargesetting".equals(((ccg)localObject3).Gdh))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.24(this, (ccg)localObject3));
        }
        else if ("wxpay://lqt/fixeddeposit/makeplan".equals(((ccg)localObject3).Gdh))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.25(this));
        }
        else if ("wxpay://lqt/fixeddeposit/planlist".equals(((ccg)localObject3).Gdh))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.26(this));
          continue;
          if (((ccg)localObject3).GVZ == 2)
          {
            if (!bt.isNullOrNil(((ccg)localObject3).Gdh))
            {
              ((ViewGroup)localObject2).setTag(((ccg)localObject3).Gdh);
              ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.2(this, (ViewGroup)localObject2, (ccg)localObject3));
            }
          }
          else if ((((ccg)localObject3).GVZ == 3) && (!bt.isNullOrNil(((ccg)localObject3).FRw)) && (!bt.isNullOrNil(((ccg)localObject3).Gdh))) {
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.3(this, (ccg)localObject3));
          }
        }
      }
      label938:
      if ((this.CAM.HhH != null) && (this.CAM.HhH.size() > 0))
      {
        localObject1 = this.CAM.HhH.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (afa)((Iterator)localObject1).next();
          localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494610, this.CAX, false);
          localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131301651);
          localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131301649);
          localTextView1.setText(((afa)localObject3).title);
          localTextView2.setText(((afa)localObject3).desc);
          if (!bt.isNullOrNil(((afa)localObject3).Gdh))
          {
            ((ViewGroup)localObject2).setTag(((afa)localObject3).Gdh);
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.4(this, (ViewGroup)localObject2));
          }
          localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
          this.CAX.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
      }
      label1126:
      if (this.CAX.getChildCount() == 0)
      {
        localObject1 = findViewById(2131301671);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(4);
        }
      }
      if (this.CAM.GXO > 0) {
        break label1711;
      }
      this.CAW.setEnabled(false);
      if (bt.isNullOrNil(this.CAM.Hid)) {
        break label1722;
      }
      this.CBn.setText(this.CAM.Hid);
      com.tencent.mm.wallet_core.ui.e.aW(this.CBn, 50);
      this.CBn.setOnClickListener(new WalletLqtDetailUI.5(this));
      this.CBn.setVisibility(0);
      localObject1 = findViewById(2131301648);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.CAZ.setGravity(3);
      this.CAZ.setPadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 5), 0, 0, 0);
      label1279:
      if (this.CAM.HhK != null)
      {
        this.CAZ.setText(this.CAM.HhK.title);
        this.CAZ.setOnClickListener(new WalletLqtDetailUI.6(this));
      }
      this.CBb.setVisibility(8);
      if ((this.CAM.HhM != null) && (!bt.isNullOrNil(this.CAM.HhM.title)))
      {
        this.CBb.setVisibility(0);
        this.CBc.setText(this.CAM.HhM.title);
        if (!bt.isNullOrNil(this.CAM.HhM.Gdh)) {
          this.CBb.setOnClickListener(new WalletLqtDetailUI.7(this));
        }
      }
      this.CBf.setVisibility(8);
      this.CBe.setVisibility(8);
      if ((this.CAM.HhN != null) && (!bt.isNullOrNil(this.CAM.HhN.username)))
      {
        this.CBg.setUrl(this.CAM.HhN.hzB);
        this.CBh.setText(this.CAM.HhN.title);
        this.CBi.setText(this.CAM.HhN.desc);
        this.CBf.setOnClickListener(new WalletLqtDetailUI.8(this));
        this.CBe.setVisibility(0);
        this.CBf.setVisibility(0);
      }
      this.CAZ.setVisibility(0);
      if (bt.isNullOrNil(this.CAM.Cxm)) {
        break label1774;
      }
      this.CBa.setText(this.CAM.Cxm);
      label1573:
      if ((this.CAM.HhZ == null) || (bt.isNullOrNil(this.CAM.HhZ.title))) {
        break label1822;
      }
      this.CBj.setVisibility(0);
      this.CBk.setText(this.CAM.HhZ.title);
      this.CBj.setOnClickListener(new WalletLqtDetailUI.9(this));
    }
    for (;;)
    {
      this.CAV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(68796);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          if (ac.iPP)
          {
            localObject = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) != null)
            {
              paramAnonymousView = WalletLqtDetailUI.d(WalletLqtDetailUI.this).HgB;
              ((Intent)localObject).putExtra("lqt_save_fund_code", paramAnonymousView);
              ((Intent)localObject).putExtra("lqt_save_fetch_mode", 1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).dMY != 1) {
                break label274;
              }
              bool1 = true;
              label115:
              ((Intent)localObject).putExtra("lqt_is_show_protocol", bool1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).HhI != 1) {
                break label279;
              }
            }
            label274:
            label279:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ((Intent)localObject).putExtra("lqt_is_agree_protocol", bool1);
              ((Intent)localObject).putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.f(WalletLqtDetailUI.this));
              ((Intent)localObject).putExtra("lqt_profile_wording", WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hhx);
              paramAnonymousView = WalletLqtDetailUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68796);
              return;
              paramAnonymousView = null;
              break;
              bool1 = false;
              break label115;
            }
          }
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hia != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hia.GNn) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).GXU != null))
          {
            af.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).GXU);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68796);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).CxB.iF(WalletLqtDetailUI.d(WalletLqtDetailUI.this).uxm, 1);
          if (!bt.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).HhO))
          {
            ad.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.d(WalletLqtDetailUI.this).HhO });
            com.tencent.mm.wallet_core.ui.e.n(WalletLqtDetailUI.this, WalletLqtDetailUI.d(WalletLqtDetailUI.this).HhO, false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68796);
            return;
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hia);
          }
        }
      });
      this.CAW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199207);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hib != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hib.GNn) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).GXU != null))
          {
            af.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).GXU);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199207);
            return;
          }
          paramAnonymousView = WalletLqtDetailUI.g(WalletLqtDetailUI.this).CxA;
          com.tencent.mm.vending.g.g.L(Integer.valueOf(WalletLqtDetailUI.d(WalletLqtDetailUI.this).uxm), Integer.valueOf(1)).c(paramAnonymousView);
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.d(WalletLqtDetailUI.this).Hib);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199207);
        }
      });
      if ((this.CAM.GNn) && (this.CAM.GXU != null)) {
        af.a(this, this.CAM.GXU);
      }
      dhw();
      AppMethodBeat.o(68820);
      return;
      label1711:
      this.CAW.setEnabled(true);
      break;
      label1722:
      this.CBn.setVisibility(8);
      localObject1 = findViewById(2131301648);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.CAZ.setGravity(17);
      this.CAZ.setPadding(0, 0, 0, 0);
      break label1279;
      label1774:
      if (this.CAM.uxm == 1)
      {
        this.CBa.setText(2131765391);
        break label1573;
      }
      if (this.CAM.uxm != 2) {
        break label1573;
      }
      this.CBa.setText(2131765392);
      break label1573;
      label1822:
      this.CBj.setVisibility(8);
    }
  }
  
  public final void aP(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(199219);
    ad.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.CAL == null)
    {
      AppMethodBeat.o(199219);
      return;
    }
    if (paramBoolean)
    {
      if (this.iVd != null) {
        break label105;
      }
      this.iVd = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    }
    for (;;)
    {
      this.CAL.Cxy.aRm().f(new com.tencent.mm.vending.c.a()
      {
        private Void a(cou paramAnonymouscou)
        {
          AppMethodBeat.i(68798);
          if (paramAnonymouscou != null)
          {
            ad.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[] { Integer.valueOf(paramAnonymouscou.uxm), Boolean.valueOf(paramAnonymouscou.HhS) });
            WalletLqtDetailUI.a(WalletLqtDetailUI.this, paramAnonymouscou);
            WalletLqtDetailUI.b(WalletLqtDetailUI.this);
            WalletLqtDetailUI.c(WalletLqtDetailUI.this);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) == null) {}
          }
          for (;;)
          {
            try
            {
              paramAnonymouscou = new String(WalletLqtDetailUI.d(WalletLqtDetailUI.this).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
              ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(al.a.ICC, paramAnonymouscou);
              if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
                WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
              }
              paramAnonymouscou = LhQ;
              AppMethodBeat.o(68798);
              return paramAnonymouscou;
            }
            catch (IOException paramAnonymouscou)
            {
              ad.printErrStackTrace("MicroMsg.WalletLqtDetailUI", paramAnonymouscou, "", new Object[0]);
              continue;
            }
            ad.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
          }
        }
      }).a(new d.a()
      {
        public final void ce(Object paramAnonymousObject)
        {
          AppMethodBeat.i(68787);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          ad.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[] { paramAnonymousObject });
          int i = paramInt - 1;
          if (i > 0)
          {
            WalletLqtDetailUI.this.aP(i, false);
            AppMethodBeat.o(68787);
            return;
          }
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label100;
            }
          }
          label100:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131765420))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(68787);
            return;
          }
        }
      });
      AppMethodBeat.o(199219);
      return;
      label105:
      this.iVd.show();
    }
  }
  
  public int getLayoutId()
  {
    return 2131495973;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68824);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 123) && (paramInt2 == -1))
    {
      this.CBp = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.iVd != null) {
        break label118;
      }
      this.iVd = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    }
    for (;;)
    {
      u.a locala = this.CAL.Cxz;
      com.tencent.mm.vending.g.g.L(paramIntent, Integer.valueOf(this.CAM.uxm)).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
      {
        public final void ce(Object paramAnonymousObject)
        {
          AppMethodBeat.i(199214);
          if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
            WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
          }
          ad.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", new Object[] { paramAnonymousObject });
          if (paramAnonymousObject != null) {
            if (!(paramAnonymousObject instanceof String)) {
              break label74;
            }
          }
          label74:
          for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131765420))
          {
            Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
            AppMethodBeat.o(199214);
            return;
          }
        }
      });
      AppMethodBeat.o(68824);
      return;
      label118:
      this.iVd.show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68815);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101118));
    setActionbarElementColor(getResources().getColor(2131099828));
    hideActionbarLine();
    setMMTitle("");
    ad.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[] { Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)) });
    if (getIntent().getIntExtra("key_auto_jump_transfer", 0) == 1)
    {
      ad.i("MicroMsg.WalletLqtDetailUI", "auto jump to balance transfer");
      paramBundle = new Intent(getContext(), WalletLqtBalanceAutoTransferUI.class);
      paramBundle.putExtra("show_open_toast", getIntent().getIntExtra("show_open_toast", 0));
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    this.CAN = ((ViewGroup)findViewById(2131299040));
    this.CAO = ((TextView)findViewById(2131301667));
    this.CBd = ((RelativeLayout)findViewById(2131301643));
    this.CAP = ((ViewGroup)findViewById(2131299038));
    this.CAQ = ((TextView)findViewById(2131301641));
    this.CAR = ((TextView)findViewById(2131301642));
    this.CAS = ((ViewGroup)findViewById(2131299043));
    this.CAT = ((TextView)findViewById(2131301659));
    this.CAU = ((WalletTextView)findViewById(2131301660));
    this.CAV = ((Button)findViewById(2131301664));
    this.CAW = ((Button)findViewById(2131301655));
    this.CAX = ((LinearLayout)findViewById(2131301650));
    this.CAY = ((LinearLayout)findViewById(2131301684));
    this.CAZ = ((TextView)findViewById(2131301654));
    this.CBb = findViewById(2131301646);
    this.CBc = ((TextView)findViewById(2131301647));
    this.CBf = findViewById(2131301666);
    this.CBg = ((CdnImageView)findViewById(2131305850));
    this.CBh = ((TextView)findViewById(2131305851));
    this.CBi = ((TextView)findViewById(2131305849));
    this.CBe = findViewById(2131301665);
    this.CBa = ((TextView)findViewById(2131301652));
    this.CBj = ((LinearLayout)findViewById(2131301668));
    this.CBk = ((TextView)findViewById(2131301669));
    this.CBl = ((TextView)findViewById(2131301657));
    this.CBm = ((TextView)findViewById(2131301670));
    this.CBn = ((TextView)findViewById(2131301656));
    this.CBo = ((WcPayMoneyLoadingView)findViewById(2131301645));
    this.vFY = ((ProgressBar)findViewById(2131306757));
    this.CBo.setLoadingPb(this.vFY);
    getLifecycle().addObserver(this.CBo);
    this.CBo.setPrefixSymbol(getString(2131765813));
    this.CAZ.setVisibility(4);
    AppMethodBeat.o(68815);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68825);
    super.onDestroy();
    this.CAK = null;
    this.CAL = null;
    AppMethodBeat.o(68825);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68818);
    super.onPause();
    this.CBo.reset();
    AppMethodBeat.o(68818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68817);
    super.onResume();
    if (this.CBp) {}
    try
    {
      String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.ICC, "");
      if (!bt.isNullOrNil(str)) {
        this.CAM = ((cou)new cou().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1)));
      }
      tV(true);
      aP(0, false);
      this.CBp = true;
      AppMethodBeat.o(68817);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WalletLqtDetailUI", localIOException, "", new Object[0]);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI
 * JD-Core Version:    0.7.0.1
 */