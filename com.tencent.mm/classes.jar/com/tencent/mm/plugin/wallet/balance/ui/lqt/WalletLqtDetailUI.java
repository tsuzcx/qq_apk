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
import com.tencent.mm.g.a.uj;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.t;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u.c;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  private static final int nEC;
  private ap handler;
  private Dialog ibM;
  private ProgressBar tuN;
  private TextView zIA;
  private TextView zIB;
  private View zIC;
  private TextView zID;
  private RelativeLayout zIE;
  private View zIF;
  private View zIG;
  private CdnImageView zIH;
  private TextView zII;
  private TextView zIJ;
  private LinearLayout zIK;
  private TextView zIL;
  private TextView zIM;
  private TextView zIN;
  private TextView zIO;
  private WcPayMoneyLoadingView zIP;
  private boolean zIQ;
  private boolean zIR;
  private boolean zIS;
  private t zIl;
  private u zIm;
  private cer zIn;
  private ViewGroup zIo;
  private TextView zIp;
  private ViewGroup zIq;
  private TextView zIr;
  private TextView zIs;
  private ViewGroup zIt;
  private TextView zIu;
  private WalletTextView zIv;
  private Button zIw;
  private Button zIx;
  private LinearLayout zIy;
  private LinearLayout zIz;
  
  static
  {
    AppMethodBeat.i(68832);
    nEC = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 16);
    AppMethodBeat.o(68832);
  }
  
  public WalletLqtDetailUI()
  {
    AppMethodBeat.i(68814);
    this.zIl = ((t)aq(t.class));
    this.zIm = ((u)am(u.class));
    this.zIQ = true;
    this.handler = new ap(Looper.getMainLooper());
    this.zIR = false;
    this.zIS = false;
    AppMethodBeat.o(68814);
  }
  
  private void Rg(final int paramInt)
  {
    AppMethodBeat.i(68819);
    ad.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.zIm == null)
    {
      AppMethodBeat.o(68819);
      return;
    }
    this.zIm.zFc.aHm().f(new com.tencent.mm.vending.c.a()
    {
      private Void a(cer paramAnonymouscer)
      {
        AppMethodBeat.i(68798);
        if (paramAnonymouscer != null)
        {
          ad.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[] { Integer.valueOf(paramAnonymouscer.CYU), Boolean.valueOf(paramAnonymouscer.EaS) });
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, paramAnonymouscer);
          WalletLqtDetailUI.b(WalletLqtDetailUI.this);
          WalletLqtDetailUI.c(WalletLqtDetailUI.this);
          if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) == null) {}
        }
        for (;;)
        {
          try
          {
            paramAnonymouscer = new String(WalletLqtDetailUI.d(WalletLqtDetailUI.this).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
            ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ae.a.Fsr, paramAnonymouscer);
            if (WalletLqtDetailUI.a(WalletLqtDetailUI.this) != null) {
              WalletLqtDetailUI.a(WalletLqtDetailUI.this).dismiss();
            }
            paramAnonymouscer = HPQ;
            AppMethodBeat.o(68798);
            return paramAnonymouscer;
          }
          catch (IOException paramAnonymouscer)
          {
            ad.printErrStackTrace("MicroMsg.WalletLqtDetailUI", paramAnonymouscer, "", new Object[0]);
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
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, i);
          AppMethodBeat.o(68787);
          return;
        }
        if (paramAnonymousObject != null) {
          if (!(paramAnonymousObject instanceof String)) {
            break label99;
          }
        }
        label99:
        for (paramAnonymousObject = paramAnonymousObject.toString();; paramAnonymousObject = WalletLqtDetailUI.this.getString(2131765420))
        {
          Toast.makeText(WalletLqtDetailUI.this, paramAnonymousObject, 1).show();
          AppMethodBeat.o(68787);
          return;
        }
      }
    });
    AppMethodBeat.o(68819);
  }
  
  private void att(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(68821);
    ad.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    String str;
    if (this.zIn != null)
    {
      str = this.zIn.DZA;
      localIntent.putExtra("lqt_save_fund_code", str);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (this.zIn.dCZ != 1) {
        break label266;
      }
      bool1 = true;
      label77:
      localIntent.putExtra("lqt_is_show_protocol", bool1);
      if (this.zIn.EaI != 1) {
        break label271;
      }
    }
    label266:
    label271:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("lqt_is_agree_protocol", bool1);
      localIntent.putStringArrayListExtra("lqt_protocol_list", dZs());
      localIntent.putExtra("lqt_profile_wording", this.zIn.Eax);
      localIntent.putExtra("lqt_account_type", this.zIn.CYU);
      localIntent.putExtra("lqt_fund_spid", this.zIn.DZC);
      localIntent.putExtra("operate_id", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(68821);
      return;
      str = null;
      break;
      bool1 = false;
      break label77;
    }
  }
  
  private void atu(String paramString)
  {
    AppMethodBeat.i(68822);
    ad.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
    Intent localIntent = new Intent(this, WalletLqtSaveFetchUI.class);
    localIntent.putExtra("lqt_save_fetch_mode", 2);
    localIntent.putExtra("lqt_balance", this.zIn.DRI);
    localIntent.putExtra("lqt_max_redeem_amount", this.zIn.EaP);
    localIntent.putExtra("lqt_redeem_invalid_amount_hint", this.zIn.EaQ);
    localIntent.putExtra("lqt_account_type", this.zIn.CYU);
    localIntent.putExtra("operate_id", paramString);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(68822);
  }
  
  private void cKF()
  {
    AppMethodBeat.i(68823);
    removeAllOptionMenu();
    if (this.zIn != null)
    {
      if ((this.zIn.Ebf != null) && (this.zIn.Ebf.size() == 1) && (this.zIn.EaS))
      {
        ad.i("MicroMsg.WalletLqtDetailUI", "show text menu");
        bsy localbsy = (bsy)this.zIn.Ebf.get(0);
        addTextOptionMenu(0, localbsy.title, new WalletLqtDetailUI.11(this, localbsy));
        AppMethodBeat.o(68823);
        return;
      }
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68803);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletLqtDetailUI.this, 1, false);
          paramAnonymousMenuItem.HrX = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(68800);
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebf != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebf.size() > 0))
              {
                Iterator localIterator = WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebf.iterator();
                int i = 0;
                while (localIterator.hasNext())
                {
                  bsy localbsy = (bsy)localIterator.next();
                  if (!bt.isNullOrNil(localbsy.title)) {
                    paramAnonymous2l.c(i, localbsy.title);
                  }
                  i += 1;
                }
              }
              if (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaS) {
                paramAnonymous2l.a(-1, WalletLqtDetailUI.this.getContext().getResources().getColor(2131099803), WalletLqtDetailUI.this.getString(2131765387));
              }
              AppMethodBeat.o(68800);
            }
          };
          paramAnonymousMenuItem.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68802);
              if ((paramAnonymous2MenuItem.getItemId() == -1) && (!WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaS))
              {
                if (!bt.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaX)) {
                  paramAnonymous2MenuItem = WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaX;
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(WalletLqtDetailUI.this, paramAnonymous2MenuItem, "", WalletLqtDetailUI.this.getString(2131757429), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(68801);
                      WalletLqtDetailUI.h(WalletLqtDetailUI.this);
                      paramAnonymous3DialogInterface = new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class);
                      WalletLqtDetailUI.this.startActivityForResult(paramAnonymous3DialogInterface, 123);
                      AppMethodBeat.o(68801);
                    }
                  });
                  AppMethodBeat.o(68802);
                  return;
                  if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).CYU == 0) {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131765389);
                  } else {
                    paramAnonymous2MenuItem = WalletLqtDetailUI.this.getString(2131765372);
                  }
                }
              }
              if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebf != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebf.size() > 0) && (paramAnonymous2MenuItem.getItemId() < WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebf.size()))
              {
                paramAnonymous2MenuItem = (bsy)WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebf.get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem.DPZ != 1) {
                  if (paramAnonymous2MenuItem.DPZ == 2)
                  {
                    if (!bt.isNullOrNil(paramAnonymous2MenuItem.DcE))
                    {
                      com.tencent.mm.wallet_core.ui.e.o(WalletLqtDetailUI.this, paramAnonymous2MenuItem.DcE, false);
                      AppMethodBeat.o(68802);
                    }
                  }
                  else if ((paramAnonymous2MenuItem.DPZ == 3) && (!bt.isNullOrNil(paramAnonymous2MenuItem.CRC)) && (!bt.isNullOrNil(paramAnonymous2MenuItem.DcE))) {
                    com.tencent.mm.wallet_core.ui.e.v(paramAnonymous2MenuItem.CRC, paramAnonymous2MenuItem.DcE, 0, 1061);
                  }
                }
              }
              AppMethodBeat.o(68802);
            }
          };
          paramAnonymousMenuItem.csG();
          AppMethodBeat.o(68803);
          return false;
        }
      });
    }
    AppMethodBeat.o(68823);
  }
  
  private ArrayList<String> dZs()
  {
    AppMethodBeat.i(68816);
    ArrayList localArrayList = new ArrayList();
    if ((this.zIn.EaJ != null) && (this.zIn.EaJ.size() > 0))
    {
      Iterator localIterator = this.zIn.EaJ.iterator();
      while (localIterator.hasNext())
      {
        aca localaca = (aca)localIterator.next();
        if ((!bt.isNullOrNil(localaca.title)) && (!bt.isNullOrNil(localaca.DcE))) {
          localArrayList.add(String.format("%s||%s", new Object[] { localaca.title, localaca.DcE }));
        }
      }
    }
    AppMethodBeat.o(68816);
    return localArrayList;
  }
  
  private void dZt()
  {
    AppMethodBeat.i(187116);
    ad.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView");
    if (!this.zIS)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(17084, new Object[] { Integer.valueOf(10) });
      this.zIS = true;
      ad.i("MicroMsg.WalletLqtDetailUI", "ReportShowLctOperationView");
    }
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2131494615, this.zIz, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(2131301687);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(2131301686);
    localTextView1.setText(this.zIn.Ebi.DJp.title);
    localTextView2.setText(this.zIn.Ebi.DJp.desc);
    if (this.zIn.Ebi.DJp.DPZ != 1)
    {
      if (this.zIn.Ebi.DJp.DPZ != 2) {
        break label228;
      }
      if (!bt.isNullOrNil(this.zIn.Ebi.DJp.DcE))
      {
        localViewGroup.setTag(this.zIn.Ebi.DJp.DcE);
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.16(this, localViewGroup));
      }
    }
    for (;;)
    {
      this.zIz.addView(localViewGroup);
      AppMethodBeat.o(187116);
      return;
      label228:
      if ((this.zIn.Ebi.DJp.DPZ == 3) && (!bt.isNullOrNil(this.zIn.Ebi.DJp.CRC)) && (!bt.isNullOrNil(this.zIn.Ebi.DJp.DcE))) {
        localViewGroup.setOnClickListener(new WalletLqtDetailUI.17(this));
      }
    }
  }
  
  private void sk(boolean paramBoolean)
  {
    AppMethodBeat.i(68820);
    Object localObject1;
    if (this.zIn != null)
    {
      this.zIo.setVisibility(0);
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ae.a.Fsx, Long.valueOf(0L))).longValue();
      localObject1 = this.zIP;
      Object localObject2 = com.tencent.mm.wallet_core.ui.e.D(com.tencent.mm.wallet_core.ui.e.b(String.valueOf(l), "100", RoundingMode.HALF_UP));
      label126:
      int i;
      label162:
      label336:
      label371:
      Object localObject3;
      label450:
      TextView localTextView1;
      TextView localTextView2;
      CdnImageView localCdnImageView;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((WcPayMoneyLoadingView)localObject1).bV((String)localObject2, paramBoolean);
        localObject1 = (ImageView)findViewById(2131301640);
        if (localObject1 != null)
        {
          if (bt.isNullOrNil(this.zIn.EaT)) {
            break label693;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = (ImageView)findViewById(2131301658);
        if (localObject1 != null)
        {
          if (bt.isNullOrNil(this.zIn.EaT)) {
            break label703;
          }
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = new WalletLqtDetailUI.18(this);
        this.zIE.setOnClickListener((View.OnClickListener)localObject1);
        this.zIP.setOnClickListener((View.OnClickListener)localObject1);
        this.zIq.setOnClickListener(new WalletLqtDetailUI.19(this));
        this.zIr.setText(this.zIn.EaD);
        this.zIs.setText(this.zIn.EaE);
        this.zIu.setText(this.zIn.EaF);
        this.zIv.setText(com.tencent.mm.wallet_core.ui.e.E(com.tencent.mm.wallet_core.ui.e.b(this.zIn.EaG, "100", RoundingMode.HALF_UP)));
        this.zIt.setOnClickListener(new WalletLqtDetailUI.20(this));
        if (bt.isNullOrNil(this.zIn.EaW)) {
          break label713;
        }
        this.zIM.setText(this.zIn.EaW);
        this.zIM.setVisibility(0);
        if (bt.isNullOrNil(this.zIn.Ebc)) {
          break label724;
        }
        this.zIN.setText(this.zIn.Ebc);
        this.zIN.setVisibility(0);
        this.zIy.removeAllViews();
        this.zIz.removeAllViews();
        if ((this.zIn.Ebi != null) && (this.zIn.Ebi.DJo == 1)) {
          dZt();
        }
        if ((this.zIn.EaV == null) || (this.zIn.EaV.isEmpty())) {
          break label876;
        }
        localObject1 = this.zIn.EaV.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label1064;
        }
        localObject3 = (bsy)((Iterator)localObject1).next();
        localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494610, this.zIy, false);
        localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131301651);
        localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131301649);
        localCdnImageView = (CdnImageView)((ViewGroup)localObject2).findViewById(2131301372);
        View localView = ((ViewGroup)localObject2).findViewById(2131301374);
        if (i == this.zIn.EaV.size() - 1) {
          localView.setVisibility(8);
        }
        localTextView1.setText(((bsy)localObject3).title);
        localTextView2.setText(((bsy)localObject3).desc);
        if (bt.isNullOrNil(((bsy)localObject3).dub)) {
          break label735;
        }
        localCdnImageView.setUseSdcardCache(true);
        localCdnImageView.setUrl(((bsy)localObject3).dub);
        localCdnImageView.setVisibility(0);
        label617:
        if (((bsy)localObject3).DPZ != 1) {
          break label777;
        }
        if (!"wxpay://lqt/planindex".equals(((bsy)localObject3).DcE)) {
          break label745;
        }
        ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.21(this, (bsy)localObject3));
      }
      label777:
      for (;;)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
        this.zIy.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i += 1;
        break label450;
        paramBoolean = false;
        break;
        label693:
        ((ImageView)localObject1).setVisibility(8);
        break label126;
        label703:
        ((ImageView)localObject1).setVisibility(8);
        break label162;
        label713:
        this.zIM.setVisibility(4);
        break label336;
        label724:
        this.zIN.setVisibility(4);
        break label371;
        label735:
        localCdnImageView.setVisibility(8);
        break label617;
        label745:
        if ("wxpay://lqt/autochargesetting".equals(((bsy)localObject3).DcE))
        {
          ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.22(this, (bsy)localObject3));
          continue;
          if (((bsy)localObject3).DPZ == 2)
          {
            if (!bt.isNullOrNil(((bsy)localObject3).DcE))
            {
              ((ViewGroup)localObject2).setTag(((bsy)localObject3).DcE);
              ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.23(this, (ViewGroup)localObject2, (bsy)localObject3));
            }
          }
          else if ((((bsy)localObject3).DPZ == 3) && (!bt.isNullOrNil(((bsy)localObject3).CRC)) && (!bt.isNullOrNil(((bsy)localObject3).DcE))) {
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.24(this, (bsy)localObject3));
          }
        }
      }
      label876:
      if ((this.zIn.EaH != null) && (this.zIn.EaH.size() > 0))
      {
        localObject1 = this.zIn.EaH.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (aca)((Iterator)localObject1).next();
          localObject2 = (ViewGroup)getLayoutInflater().inflate(2131494610, this.zIy, false);
          localTextView1 = (TextView)((ViewGroup)localObject2).findViewById(2131301651);
          localTextView2 = (TextView)((ViewGroup)localObject2).findViewById(2131301649);
          localTextView1.setText(((aca)localObject3).title);
          localTextView2.setText(((aca)localObject3).desc);
          if (!bt.isNullOrNil(((aca)localObject3).DcE))
          {
            ((ViewGroup)localObject2).setTag(((aca)localObject3).DcE);
            ((ViewGroup)localObject2).setOnClickListener(new WalletLqtDetailUI.2(this, (ViewGroup)localObject2));
          }
          localObject3 = new LinearLayout.LayoutParams(-1, -2, -1.0F);
          this.zIy.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
      }
      label1064:
      if (this.zIy.getChildCount() == 0)
      {
        localObject1 = findViewById(2131301671);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(4);
        }
      }
      if (this.zIn.DRI > 0) {
        break label1649;
      }
      this.zIx.setEnabled(false);
      if (bt.isNullOrNil(this.zIn.Ebd)) {
        break label1660;
      }
      this.zIO.setText(this.zIn.Ebd);
      com.tencent.mm.wallet_core.ui.e.aS(this.zIO, 50);
      this.zIO.setOnClickListener(new WalletLqtDetailUI.3(this));
      this.zIO.setVisibility(0);
      localObject1 = findViewById(2131301648);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.zIA.setGravity(3);
      this.zIA.setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 5), 0, 0, 0);
      label1217:
      if (this.zIn.EaK != null)
      {
        this.zIA.setText(this.zIn.EaK.title);
        this.zIA.setOnClickListener(new WalletLqtDetailUI.4(this));
      }
      this.zIC.setVisibility(8);
      if ((this.zIn.EaM != null) && (!bt.isNullOrNil(this.zIn.EaM.title)))
      {
        this.zIC.setVisibility(0);
        this.zID.setText(this.zIn.EaM.title);
        if (!bt.isNullOrNil(this.zIn.EaM.DcE)) {
          this.zIC.setOnClickListener(new WalletLqtDetailUI.5(this));
        }
      }
      this.zIG.setVisibility(8);
      this.zIF.setVisibility(8);
      if ((this.zIn.EaN != null) && (!bt.isNullOrNil(this.zIn.EaN.username)))
      {
        this.zIH.setUrl(this.zIn.EaN.gGR);
        this.zII.setText(this.zIn.EaN.title);
        this.zIJ.setText(this.zIn.EaN.desc);
        this.zIG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68792);
            paramAnonymousView = new uj();
            paramAnonymousView.dzH.userName = WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaN.username;
            paramAnonymousView.dzH.dzJ = bt.by(WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaN.path, "");
            paramAnonymousView.dzH.scene = 1061;
            paramAnonymousView.dzH.dzK = 0;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
            AppMethodBeat.o(68792);
          }
        });
        this.zIF.setVisibility(0);
        this.zIG.setVisibility(0);
      }
      this.zIA.setVisibility(0);
      if (bt.isNullOrNil(this.zIn.zEQ)) {
        break label1712;
      }
      this.zIB.setText(this.zIn.zEQ);
      label1511:
      if ((this.zIn.EaZ == null) || (bt.isNullOrNil(this.zIn.EaZ.title))) {
        break label1760;
      }
      this.zIK.setVisibility(0);
      this.zIL.setText(this.zIn.EaZ.title);
      this.zIK.setOnClickListener(new WalletLqtDetailUI.7(this));
    }
    for (;;)
    {
      this.zIw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(68794);
          if (ab.hWD)
          {
            Object localObject = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
            if (WalletLqtDetailUI.d(WalletLqtDetailUI.this) != null)
            {
              paramAnonymousView = WalletLqtDetailUI.d(WalletLqtDetailUI.this).DZA;
              ((Intent)localObject).putExtra("lqt_save_fund_code", paramAnonymousView);
              ((Intent)localObject).putExtra("lqt_save_fetch_mode", 1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).dCZ != 1) {
                break label230;
              }
              bool1 = true;
              label83:
              ((Intent)localObject).putExtra("lqt_is_show_protocol", bool1);
              if (WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaI != 1) {
                break label235;
              }
            }
            label230:
            label235:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ((Intent)localObject).putExtra("lqt_is_agree_protocol", bool1);
              ((Intent)localObject).putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.f(WalletLqtDetailUI.this));
              ((Intent)localObject).putExtra("lqt_profile_wording", WalletLqtDetailUI.d(WalletLqtDetailUI.this).Eax);
              paramAnonymousView = WalletLqtDetailUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(68794);
              return;
              paramAnonymousView = null;
              break;
              bool1 = false;
              break label83;
            }
          }
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Eba != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Eba.DIo) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).DRO != null))
          {
            af.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).DRO);
            AppMethodBeat.o(68794);
            return;
          }
          WalletLqtDetailUI.g(WalletLqtDetailUI.this).zFf.id(WalletLqtDetailUI.d(WalletLqtDetailUI.this).CYU, 1);
          if (!bt.isNullOrNil(WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaO))
          {
            ad.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaO });
            com.tencent.mm.wallet_core.ui.e.o(WalletLqtDetailUI.this, WalletLqtDetailUI.d(WalletLqtDetailUI.this).EaO, false);
            AppMethodBeat.o(68794);
            return;
          }
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.d(WalletLqtDetailUI.this).Eba);
          AppMethodBeat.o(68794);
        }
      });
      this.zIx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68795);
          if ((WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebb != null) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebb.DIo) && (WalletLqtDetailUI.d(WalletLqtDetailUI.this).DRO != null))
          {
            af.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.d(WalletLqtDetailUI.this).DRO);
            AppMethodBeat.o(68795);
            return;
          }
          paramAnonymousView = WalletLqtDetailUI.g(WalletLqtDetailUI.this).zFe;
          com.tencent.mm.vending.g.g.J(Integer.valueOf(WalletLqtDetailUI.d(WalletLqtDetailUI.this).CYU), Integer.valueOf(1)).c(paramAnonymousView);
          WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.d(WalletLqtDetailUI.this).Ebb);
          AppMethodBeat.o(68795);
        }
      });
      if ((this.zIn.DIo) && (this.zIn.DRO != null)) {
        af.a(this, this.zIn.DRO);
      }
      cKF();
      AppMethodBeat.o(68820);
      return;
      label1649:
      this.zIx.setEnabled(true);
      break;
      label1660:
      this.zIO.setVisibility(8);
      localObject1 = findViewById(2131301648);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.zIA.setGravity(17);
      this.zIA.setPadding(0, 0, 0, 0);
      break label1217;
      label1712:
      if (this.zIn.CYU == 1)
      {
        this.zIB.setText(2131765391);
        break label1511;
      }
      if (this.zIn.CYU != 2) {
        break label1511;
      }
      this.zIB.setText(2131765392);
      break label1511;
      label1760:
      this.zIK.setVisibility(8);
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
      this.zIQ = false;
      paramIntent = paramIntent.getStringExtra("lqt_enc_pwd");
      if (this.ibM != null) {
        break label118;
      }
      this.ibM = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    }
    for (;;)
    {
      u.a locala = this.zIm.zFd;
      com.tencent.mm.vending.g.g.J(paramIntent, Integer.valueOf(this.zIn.CYU)).c(locala).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
      {
        public final void ce(Object paramAnonymousObject)
        {
          AppMethodBeat.i(68804);
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
            AppMethodBeat.o(68804);
            return;
          }
        }
      });
      AppMethodBeat.o(68824);
      return;
      label118:
      this.ibM.show();
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
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    this.zIo = ((ViewGroup)findViewById(2131299040));
    this.zIp = ((TextView)findViewById(2131301667));
    this.zIE = ((RelativeLayout)findViewById(2131301643));
    this.zIq = ((ViewGroup)findViewById(2131299038));
    this.zIr = ((TextView)findViewById(2131301641));
    this.zIs = ((TextView)findViewById(2131301642));
    this.zIt = ((ViewGroup)findViewById(2131299043));
    this.zIu = ((TextView)findViewById(2131301659));
    this.zIv = ((WalletTextView)findViewById(2131301660));
    this.zIw = ((Button)findViewById(2131301664));
    this.zIx = ((Button)findViewById(2131301655));
    this.zIy = ((LinearLayout)findViewById(2131301650));
    this.zIz = ((LinearLayout)findViewById(2131301684));
    this.zIA = ((TextView)findViewById(2131301654));
    this.zIC = findViewById(2131301646);
    this.zID = ((TextView)findViewById(2131301647));
    this.zIG = findViewById(2131301666);
    this.zIH = ((CdnImageView)findViewById(2131305850));
    this.zII = ((TextView)findViewById(2131305851));
    this.zIJ = ((TextView)findViewById(2131305849));
    this.zIF = findViewById(2131301665);
    this.zIB = ((TextView)findViewById(2131301652));
    this.zIK = ((LinearLayout)findViewById(2131301668));
    this.zIL = ((TextView)findViewById(2131301669));
    this.zIM = ((TextView)findViewById(2131301657));
    this.zIN = ((TextView)findViewById(2131301670));
    this.zIO = ((TextView)findViewById(2131301656));
    this.zIP = ((WcPayMoneyLoadingView)findViewById(2131301645));
    this.tuN = ((ProgressBar)findViewById(2131306757));
    this.zIP.setLoadingPb(this.tuN);
    getLifecycle().addObserver(this.zIP);
    this.zIP.setPrefixSymbol(getString(2131765813));
    this.zIA.setVisibility(4);
    AppMethodBeat.o(68815);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68825);
    super.onDestroy();
    this.zIl = null;
    this.zIm = null;
    AppMethodBeat.o(68825);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68818);
    super.onPause();
    this.zIP.reset();
    AppMethodBeat.o(68818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68817);
    super.onResume();
    if (this.zIQ) {}
    try
    {
      String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ae.a.Fsr, "");
      if (!bt.isNullOrNil(str)) {
        this.zIn = ((cer)new cer().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1)));
      }
      sk(true);
      Rg(0);
      this.zIQ = true;
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