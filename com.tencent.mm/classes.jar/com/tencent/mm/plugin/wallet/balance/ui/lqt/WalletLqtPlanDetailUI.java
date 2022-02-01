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
import com.tencent.mm.plugin.wallet.balance.model.lqt.z;
import com.tencent.mm.plugin.wallet.balance.model.lqt.z.c;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtPlanDetailUI
  extends WalletLqtBasePresenterUI
{
  private z HyN;
  private dbt HyU;
  private TextView HzA;
  private TextView HzB;
  private ListView HzC;
  private LinearLayout HzD;
  private LinearLayout HzE;
  private LinearLayout HzF;
  private View HzG;
  private View HzH;
  private int HzI;
  private int HzJ;
  private boolean HzK;
  private String Hzu;
  private List<dbu> Hzv;
  private WalletLqtPlanDetailUI.a Hzw;
  private TextView Hzx;
  private CdnImageView Hzy;
  private TextView Hzz;
  private boolean jUX;
  private LinearLayout pQt;
  private WalletTextView qzt;
  
  public WalletLqtPlanDetailUI()
  {
    AppMethodBeat.i(68915);
    this.HyN = ((z)aq(z.class));
    this.Hzv = new ArrayList();
    AppMethodBeat.o(68915);
  }
  
  private static String aUN(String paramString)
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
  
  private void jR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68918);
    final Dialog localDialog = com.tencent.mm.wallet_core.ui.h.c(getContext(), false, null);
    this.HyN.Hug.aH(paramInt1, paramInt2, 6).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void cn(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68904);
        localDialog.dismiss();
        if ((paramAnonymousObject instanceof m)) {
          ((m)paramAnonymousObject).G(WalletLqtPlanDetailUI.this.getContext(), false);
        }
        AppMethodBeat.o(68904);
      }
    });
    AppMethodBeat.o(68918);
  }
  
  public int getLayoutId()
  {
    return 2131495339;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68917);
    Log.i("MicroMsg.WalletLqtPlanDetailUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {
        break label86;
      }
      paramIntent.putExtra("oper_type", paramInt1);
      paramIntent.putExtra("plan_id", this.HzI);
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
        this.HyU = paramBundle;
        label50:
        setMMTitle("");
        setActionbarColor(getResources().getColor(2131101424));
        hideActionbarLine();
        paramBundle = this.HyU;
        if (this.HyU != null) {
          addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(68906);
              if (paramBundle.MGH != null)
              {
                if ((!paramBundle.MGH.Htd) || (Util.isNullOrNil(paramBundle.MGH.Hte))) {
                  break label91;
                }
                com.tencent.mm.ui.base.h.a(WalletLqtPlanDetailUI.this.getContext(), paramBundle.MGH.Hte, "", WalletLqtPlanDetailUI.this.getString(2131755874), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
              }
              for (;;)
              {
                AppMethodBeat.o(68906);
                return false;
                label91:
                WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.MGH.Mvb, paramBundle);
              }
            }
          });
        }
        paramBundle = this.HyU;
        if (paramBundle != null)
        {
          this.pQt = ((LinearLayout)View.inflate(getBaseContext(), 2131495337, null));
          this.qzt = ((WalletTextView)this.pQt.findViewById(2131304850));
          this.HzE = ((LinearLayout)this.pQt.findViewById(2131308381));
          this.HzF = ((LinearLayout)this.pQt.findViewById(2131309099));
          this.Hzx = ((TextView)this.pQt.findViewById(2131309097));
          this.Hzy = ((CdnImageView)this.pQt.findViewById(2131297264));
          this.Hzz = ((TextView)this.pQt.findViewById(2131298227));
          this.HzA = ((TextView)this.pQt.findViewById(2131309092));
          this.HzD = ((LinearLayout)this.pQt.findViewById(2131309093));
          this.HzH = this.pQt.findViewById(2131302326);
          this.HzB = ((TextView)this.pQt.findViewById(2131308883));
          this.HzC = ((ListView)findViewById(2131299555));
          this.HzG = findViewById(2131303942);
          this.Hzw = new WalletLqtPlanDetailUI.a(this, (byte)0);
          this.HzC.setAdapter(this.Hzw);
          this.HzC.addHeaderView(this.pQt);
          this.qzt.setPrefix(ah.hhz());
          localObject = f.b(paramBundle.eht, "100", 2, RoundingMode.HALF_UP);
          if (((BigDecimal)localObject).intValue() != ((BigDecimal)localObject).doubleValue()) {
            break label862;
          }
          this.qzt.setText(aUN(((BigDecimal)localObject).intValue()));
          label435:
          this.Hzx.setText(getString(2131767878, new Object[] { paramBundle.grV }));
          localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramBundle.CiX));
          if (localObject != null) {
            this.Hzy.setImageBitmap((Bitmap)localObject);
          }
          this.Hzz.setText(String.format("%s %s（%s）", new Object[] { paramBundle.ynT, paramBundle.Hts, paramBundle.AOk }));
          localObject = (LinearLayout.LayoutParams)this.HzF.getLayoutParams();
          if (paramBundle.state == 1) {
            break label879;
          }
          this.HzE.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), 0, 0);
          Log.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
        }
      }
    }
    for (;;)
    {
      this.HzF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.HzJ = 0;
      this.HzK = true;
      jR(paramBundle.Htr, 0);
      this.HzC.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(68903);
          if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
          {
            Log.i("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList more");
            if (!WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this)) {
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.Htr, WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this));
            }
          }
          AppMethodBeat.o(68903);
        }
      });
      this.HzH.setBackgroundColor(getContext().getResources().getColor(2131099648));
      AppMethodBeat.o(68916);
      return;
      paramBundle = new dbt();
      paramBundle.Htr = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).Htr;
      paramBundle.eht = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).eht;
      paramBundle.grV = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).grV;
      paramBundle.CiX = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).CiX;
      paramBundle.ynT = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).ynT;
      paramBundle.dDj = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).dDj;
      paramBundle.AOk = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).AOk;
      paramBundle.state = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).state;
      paramBundle.Hts = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).Hts;
      if (((CgiLqtPlanOrderList.PlanItemParcel)localObject).Htu != null)
      {
        paramBundle.MGH = new cpa();
        paramBundle.MGH.Htd = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).Htu.Htd;
        paramBundle.MGH.Hte = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).Htu.Hte;
        localObject = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).Htu.Htf.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Integer localInteger = (Integer)((Iterator)localObject).next();
          paramBundle.MGH.Mvb.add(localInteger);
        }
      }
      break;
      Log.i("MicroMsg.WalletLqtPlanDetailUI", "parcelable no instanceof CgiLqtPlanOrderList.PlanItemParcel");
      finish();
      break label50;
      label862:
      this.qzt.setText(aUN(((BigDecimal)localObject).toString()));
      break label435;
      label879:
      this.HzE.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 16), 0, 0);
      Log.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
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