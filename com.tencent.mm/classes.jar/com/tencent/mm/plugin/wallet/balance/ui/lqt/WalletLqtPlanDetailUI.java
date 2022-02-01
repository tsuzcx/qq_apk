package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList.MngPlanItemParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList.PlanItemParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtPlanDetailUI
  extends WalletLqtBasePresenterUI
{
  private boolean ibO;
  private WalletTextView nWM;
  private LinearLayout npN;
  private car zJE;
  private x zJx;
  private String zKe;
  private List<cas> zKf;
  private WalletLqtPlanDetailUI.a zKg;
  private TextView zKh;
  private CdnImageView zKi;
  private TextView zKj;
  private TextView zKk;
  private TextView zKl;
  private ListView zKm;
  private LinearLayout zKn;
  private LinearLayout zKo;
  private LinearLayout zKp;
  private View zKq;
  private View zKr;
  private int zKs;
  private int zKt;
  private boolean zKu;
  
  public WalletLqtPlanDetailUI()
  {
    AppMethodBeat.i(68915);
    this.zJx = ((x)am(x.class));
    this.zKf = new ArrayList();
    AppMethodBeat.o(68915);
  }
  
  private static String atw(String paramString)
  {
    AppMethodBeat.i(68919);
    if (!paramString.contains("."))
    {
      paramString = paramString + ".00";
      AppMethodBeat.o(68919);
      return paramString;
    }
    AppMethodBeat.o(68919);
    return paramString;
  }
  
  private void jdMethod_if(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68918);
    final Dialog localDialog = g.c(getContext(), false, null);
    this.zJx.zFo.ie(paramInt1, paramInt2).f(new com.tencent.mm.vending.c.a() {}).a(new WalletLqtPlanDetailUI.2(this, localDialog));
    AppMethodBeat.o(68918);
  }
  
  public int getLayoutId()
  {
    return 2131494618;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68917);
    ad.i("MicroMsg.WalletLqtPlanDetailUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {
        break label86;
      }
      paramIntent.putExtra("oper_type", paramInt1);
      paramIntent.putExtra("plan_id", this.zKs);
      setResult(-1, paramIntent);
    }
    for (;;)
    {
      finish();
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(68917);
      return;
      label86:
      Intent localIntent = new Intent();
      localIntent.putExtra("oper_type", paramInt1);
      setResult(-1, localIntent);
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(68916);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getParcelableExtra("key_plan_item_detail");
    Object localObject;
    if ((paramBundle instanceof CgiLqtPlanOrderList.PlanItemParcel))
    {
      localObject = (CgiLqtPlanOrderList.PlanItemParcel)paramBundle;
      if (localObject == null)
      {
        paramBundle = null;
        this.zJE = paramBundle;
        label50:
        setMMTitle("");
        setActionbarColor(getResources().getColor(2131101179));
        hideActionbarLine();
        paramBundle = this.zJE;
        if (this.zJE != null) {
          addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(68906);
              if (paramBundle.DXg != null)
              {
                if ((!paramBundle.DXg.zEm) || (bt.isNullOrNil(paramBundle.DXg.zEn))) {
                  break label91;
                }
                h.a(WalletLqtPlanDetailUI.this.getContext(), paramBundle.DXg.zEn, "", WalletLqtPlanDetailUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
              }
              for (;;)
              {
                AppMethodBeat.o(68906);
                return false;
                label91:
                WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.DXg.DOh, paramBundle);
              }
            }
          });
        }
        paramBundle = this.zJE;
        if (paramBundle != null)
        {
          this.npN = ((LinearLayout)View.inflate(getBaseContext(), 2131494616, null));
          this.nWM = ((WalletTextView)this.npN.findViewById(2131302448));
          this.zKo = ((LinearLayout)this.npN.findViewById(2131305190));
          this.zKp = ((LinearLayout)this.npN.findViewById(2131305820));
          this.zKh = ((TextView)this.npN.findViewById(2131305818));
          this.zKi = ((CdnImageView)this.npN.findViewById(2131297120));
          this.zKj = ((TextView)this.npN.findViewById(2131297909));
          this.zKk = ((TextView)this.npN.findViewById(2131305814));
          this.zKn = ((LinearLayout)this.npN.findViewById(2131305815));
          this.zKr = this.npN.findViewById(2131304660);
          this.zKl = ((TextView)this.npN.findViewById(2131305639));
          this.zKm = ((ListView)findViewById(2131299049));
          this.zKq = findViewById(2131301662);
          this.zKg = new WalletLqtPlanDetailUI.a(this, (byte)0);
          this.zKm.setAdapter(this.zKg);
          this.zKm.addHeaderView(this.npN);
          this.nWM.setPrefix(ah.fkg());
          localObject = e.a(paramBundle.dEb, "100", 2, RoundingMode.HALF_UP);
          if (((BigDecimal)localObject).intValue() != ((BigDecimal)localObject).doubleValue()) {
            break label862;
          }
          this.nWM.setText(atw(((BigDecimal)localObject).intValue()));
          label435:
          this.zKh.setText(getString(2131765429, new Object[] { paramBundle.foG }));
          localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramBundle.vur));
          if (localObject != null) {
            this.zKi.setImageBitmap((Bitmap)localObject);
          }
          this.zKj.setText(String.format("%s %s（%s）", new Object[] { paramBundle.szi, paramBundle.zEB, paramBundle.uoo }));
          localObject = (LinearLayout.LayoutParams)this.zKp.getLayoutParams();
          if (paramBundle.state == 1) {
            break label879;
          }
          this.zKo.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 8), 0, 0);
          ad.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
        }
      }
    }
    for (;;)
    {
      this.zKp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.zKt = 0;
      this.zKu = true;
      jdMethod_if(paramBundle.zEA, 0);
      this.zKm.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(68903);
          if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
          {
            ad.i("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList more");
            if (!WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this)) {
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.zEA, WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this));
            }
          }
          AppMethodBeat.o(68903);
        }
      });
      this.zKr.setBackgroundColor(getContext().getResources().getColor(2131099648));
      AppMethodBeat.o(68916);
      return;
      paramBundle = new car();
      paramBundle.zEA = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).zEA;
      paramBundle.dEb = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).dEb;
      paramBundle.foG = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).foG;
      paramBundle.vur = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).vur;
      paramBundle.szi = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).szi;
      paramBundle.dca = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).dca;
      paramBundle.uoo = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).uoo;
      paramBundle.state = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).state;
      paramBundle.zEB = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).zEB;
      if (((CgiLqtPlanOrderList.PlanItemParcel)localObject).zED != null)
      {
        paramBundle.DXg = new bpy();
        paramBundle.DXg.zEm = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).zED.zEm;
        paramBundle.DXg.zEn = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).zED.zEn;
        localObject = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).zED.zEo.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Integer localInteger = (Integer)((Iterator)localObject).next();
          paramBundle.DXg.DOh.add(localInteger);
        }
      }
      break;
      ad.i("MicroMsg.WalletLqtPlanDetailUI", "parcelable no instanceof CgiLqtPlanOrderList.PlanItemParcel");
      finish();
      break label50;
      label862:
      this.nWM.setText(atw(((BigDecimal)localObject).toString()));
      break label435;
      label879:
      this.zKo.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 16), 0, 0);
      ad.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI
 * JD-Core Version:    0.7.0.1
 */