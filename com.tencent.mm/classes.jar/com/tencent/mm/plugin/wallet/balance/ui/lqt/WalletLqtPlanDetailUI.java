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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
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
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vending.g.d.a;
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
  private x CBX;
  private String CCE;
  private List<ckq> CCF;
  private a CCG;
  private TextView CCH;
  private CdnImageView CCI;
  private TextView CCJ;
  private TextView CCK;
  private TextView CCL;
  private ListView CCM;
  private LinearLayout CCN;
  private LinearLayout CCO;
  private LinearLayout CCP;
  private View CCQ;
  private View CCR;
  private int CCS;
  private int CCT;
  private boolean CCU;
  private ckp CCe;
  private boolean iVf;
  private LinearLayout owi;
  private WalletTextView pdC;
  
  public WalletLqtPlanDetailUI()
  {
    AppMethodBeat.i(68915);
    this.CBX = ((x)am(x.class));
    this.CCF = new ArrayList();
    AppMethodBeat.o(68915);
  }
  
  private static String aDW(String paramString)
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
  
  private void iH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68918);
    final Dialog localDialog = g.c(getContext(), false, null);
    this.CBX.CxK.iG(paramInt1, paramInt2).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void ce(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68904);
        localDialog.dismiss();
        if ((paramAnonymousObject instanceof m)) {
          ((m)paramAnonymousObject).D(WalletLqtPlanDetailUI.this.getContext(), false);
        }
        AppMethodBeat.o(68904);
      }
    });
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
      paramIntent.putExtra("plan_id", this.CCS);
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
        this.CCe = paramBundle;
        label50:
        setMMTitle("");
        setActionbarColor(getResources().getColor(2131101179));
        hideActionbarLine();
        paramBundle = this.CCe;
        if (this.CCe != null) {
          addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(68906);
              if (paramBundle.Hee != null)
              {
                if ((!paramBundle.Hee.CwI) || (bt.isNullOrNil(paramBundle.Hee.CwJ))) {
                  break label91;
                }
                h.a(WalletLqtPlanDetailUI.this.getContext(), paramBundle.Hee.CwJ, "", WalletLqtPlanDetailUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
              }
              for (;;)
              {
                AppMethodBeat.o(68906);
                return false;
                label91:
                WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.Hee.GUg, paramBundle);
              }
            }
          });
        }
        paramBundle = this.CCe;
        if (paramBundle != null)
        {
          this.owi = ((LinearLayout)View.inflate(getBaseContext(), 2131494616, null));
          this.pdC = ((WalletTextView)this.owi.findViewById(2131302448));
          this.CCO = ((LinearLayout)this.owi.findViewById(2131305190));
          this.CCP = ((LinearLayout)this.owi.findViewById(2131305820));
          this.CCH = ((TextView)this.owi.findViewById(2131305818));
          this.CCI = ((CdnImageView)this.owi.findViewById(2131297120));
          this.CCJ = ((TextView)this.owi.findViewById(2131297909));
          this.CCK = ((TextView)this.owi.findViewById(2131305814));
          this.CCN = ((LinearLayout)this.owi.findViewById(2131305815));
          this.CCR = this.owi.findViewById(2131304660);
          this.CCL = ((TextView)this.owi.findViewById(2131305639));
          this.CCM = ((ListView)findViewById(2131299049));
          this.CCQ = findViewById(2131301662);
          this.CCG = new a((byte)0);
          this.CCM.setAdapter(this.CCG);
          this.CCM.addHeaderView(this.owi);
          this.pdC.setPrefix(ah.fRG());
          localObject = e.b(paramBundle.dOa, "100", 2, RoundingMode.HALF_UP);
          if (((BigDecimal)localObject).intValue() != ((BigDecimal)localObject).doubleValue()) {
            break label862;
          }
          this.pdC.setText(aDW(((BigDecimal)localObject).intValue()));
          label435:
          this.CCH.setText(getString(2131765429, new Object[] { paramBundle.fKG }));
          localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramBundle.xSd));
          if (localObject != null) {
            this.CCI.setImageBitmap((Bitmap)localObject);
          }
          this.CCJ.setText(String.format("%s %s（%s）", new Object[] { paramBundle.uJF, paramBundle.CwX, paramBundle.wCE }));
          localObject = (LinearLayout.LayoutParams)this.CCP.getLayoutParams();
          if (paramBundle.state == 1) {
            break label879;
          }
          this.CCO.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 8), 0, 0);
          ad.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
        }
      }
    }
    for (;;)
    {
      this.CCP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.CCT = 0;
      this.CCU = true;
      iH(paramBundle.CwW, 0);
      this.CCM.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(68903);
          if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
          {
            ad.i("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList more");
            if (!WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this)) {
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.CwW, WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this));
            }
          }
          AppMethodBeat.o(68903);
        }
      });
      this.CCR.setBackgroundColor(getContext().getResources().getColor(2131099648));
      AppMethodBeat.o(68916);
      return;
      paramBundle = new ckp();
      paramBundle.CwW = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).CwW;
      paramBundle.dOa = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).dOa;
      paramBundle.fKG = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).fKG;
      paramBundle.xSd = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).xSd;
      paramBundle.uJF = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).uJF;
      paramBundle.dkR = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).dkR;
      paramBundle.wCE = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).wCE;
      paramBundle.state = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).state;
      paramBundle.CwX = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).CwX;
      if (((CgiLqtPlanOrderList.PlanItemParcel)localObject).CwZ != null)
      {
        paramBundle.Hee = new bze();
        paramBundle.Hee.CwI = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).CwZ.CwI;
        paramBundle.Hee.CwJ = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).CwZ.CwJ;
        localObject = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).CwZ.CwK.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Integer localInteger = (Integer)((Iterator)localObject).next();
          paramBundle.Hee.GUg.add(localInteger);
        }
      }
      break;
      ad.i("MicroMsg.WalletLqtPlanDetailUI", "parcelable no instanceof CgiLqtPlanOrderList.PlanItemParcel");
      finish();
      break label50;
      label862:
      this.pdC.setText(aDW(((BigDecimal)localObject).toString()));
      break label435;
      label879:
      this.CCO.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 16), 0, 0);
      ad.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private ckq Vi(int paramInt)
    {
      AppMethodBeat.i(68911);
      ckq localckq = (ckq)WalletLqtPlanDetailUI.c(WalletLqtPlanDetailUI.this).get(paramInt);
      AppMethodBeat.o(68911);
      return localckq;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(68910);
      int i = WalletLqtPlanDetailUI.c(WalletLqtPlanDetailUI.this).size();
      AppMethodBeat.o(68910);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(68912);
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(WalletLqtPlanDetailUI.this.getContext()).inflate(2131494617, paramViewGroup, false);
        localView.setTag(new WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this, localView));
      }
      paramView = Vi(paramInt);
      paramViewGroup = (WalletLqtPlanDetailUI.b)localView.getTag();
      paramViewGroup.CDd.setText(paramView.xbO);
      if (paramView.state == 2)
      {
        paramViewGroup.CDe.setText(paramViewGroup.CCW.getString(2131765485, new Object[] { WalletLqtPlanDetailUI.aDX(new StringBuilder().append(paramView.dOa).toString()) }));
        paramViewGroup.CDe.setTextColor(paramViewGroup.CCW.getResources().getColor(2131100711));
      }
      for (;;)
      {
        AppMethodBeat.o(68912);
        return localView;
        paramViewGroup.CDe.setText(paramView.dxD);
        paramViewGroup.CDe.setTextColor(paramViewGroup.CCW.getResources().getColor(2131101089));
      }
    }
  }
  
  public final class b
  {
    public TextView CDd;
    public TextView CDe;
    public View kBS;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68914);
      this.kBS = paramView;
      this.CDd = ((TextView)paramView.findViewById(2131298932));
      this.CDe = ((TextView)paramView.findViewById(2131302447));
      AppMethodBeat.o(68914);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI
 * JD-Core Version:    0.7.0.1
 */