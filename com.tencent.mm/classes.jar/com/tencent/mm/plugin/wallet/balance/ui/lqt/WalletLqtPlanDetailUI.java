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
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private x CTD;
  private clj CTK;
  private boolean CUA;
  private String CUk;
  private List<clk> CUl;
  private a CUm;
  private TextView CUn;
  private CdnImageView CUo;
  private TextView CUp;
  private TextView CUq;
  private TextView CUr;
  private ListView CUs;
  private LinearLayout CUt;
  private LinearLayout CUu;
  private LinearLayout CUv;
  private View CUw;
  private View CUx;
  private int CUy;
  private int CUz;
  private boolean iXY;
  private LinearLayout oCK;
  private WalletTextView pki;
  
  public WalletLqtPlanDetailUI()
  {
    AppMethodBeat.i(68915);
    this.CTD = ((x)am(x.class));
    this.CUl = new ArrayList();
    AppMethodBeat.o(68915);
  }
  
  private static String aFp(String paramString)
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
  
  private void iL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68918);
    final Dialog localDialog = com.tencent.mm.wallet_core.ui.h.c(getContext(), false, null);
    this.CTD.CPp.iK(paramInt1, paramInt2).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
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
    ae.i("MicroMsg.WalletLqtPlanDetailUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {
        break label86;
      }
      paramIntent.putExtra("oper_type", paramInt1);
      paramIntent.putExtra("plan_id", this.CUy);
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
        this.CTK = paramBundle;
        label50:
        setMMTitle("");
        setActionbarColor(getResources().getColor(2131101179));
        hideActionbarLine();
        paramBundle = this.CTK;
        if (this.CTK != null) {
          addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(68906);
              if (paramBundle.HxE != null)
              {
                if ((!paramBundle.HxE.COn) || (bu.isNullOrNil(paramBundle.HxE.COo))) {
                  break label91;
                }
                com.tencent.mm.ui.base.h.a(WalletLqtPlanDetailUI.this.getContext(), paramBundle.HxE.COo, "", WalletLqtPlanDetailUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
              }
              for (;;)
              {
                AppMethodBeat.o(68906);
                return false;
                label91:
                WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.HxE.HnH, paramBundle);
              }
            }
          });
        }
        paramBundle = this.CTK;
        if (paramBundle != null)
        {
          this.oCK = ((LinearLayout)View.inflate(getBaseContext(), 2131494616, null));
          this.pki = ((WalletTextView)this.oCK.findViewById(2131302448));
          this.CUu = ((LinearLayout)this.oCK.findViewById(2131305190));
          this.CUv = ((LinearLayout)this.oCK.findViewById(2131305820));
          this.CUn = ((TextView)this.oCK.findViewById(2131305818));
          this.CUo = ((CdnImageView)this.oCK.findViewById(2131297120));
          this.CUp = ((TextView)this.oCK.findViewById(2131297909));
          this.CUq = ((TextView)this.oCK.findViewById(2131305814));
          this.CUt = ((LinearLayout)this.oCK.findViewById(2131305815));
          this.CUx = this.oCK.findViewById(2131304660);
          this.CUr = ((TextView)this.oCK.findViewById(2131305639));
          this.CUs = ((ListView)findViewById(2131299049));
          this.CUw = findViewById(2131301662);
          this.CUm = new a((byte)0);
          this.CUs.setAdapter(this.CUm);
          this.CUs.addHeaderView(this.oCK);
          this.pki.setPrefix(ah.fWc());
          localObject = f.b(paramBundle.dPq, "100", 2, RoundingMode.HALF_UP);
          if (((BigDecimal)localObject).intValue() != ((BigDecimal)localObject).doubleValue()) {
            break label862;
          }
          this.pki.setText(aFp(((BigDecimal)localObject).intValue()));
          label435:
          this.CUn.setText(getString(2131765429, new Object[] { paramBundle.fMJ }));
          localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramBundle.yhW));
          if (localObject != null) {
            this.CUo.setImageBitmap((Bitmap)localObject);
          }
          this.CUp.setText(String.format("%s %s（%s）", new Object[] { paramBundle.uVs, paramBundle.COC, paramBundle.wSp }));
          localObject = (LinearLayout.LayoutParams)this.CUv.getLayoutParams();
          if (paramBundle.state == 1) {
            break label879;
          }
          this.CUu.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), 0, 0);
          ae.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
        }
      }
    }
    for (;;)
    {
      this.CUv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.CUz = 0;
      this.CUA = true;
      iL(paramBundle.COB, 0);
      this.CUs.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(68903);
          if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
          {
            ae.i("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList more");
            if (!WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this)) {
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.COB, WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this));
            }
          }
          AppMethodBeat.o(68903);
        }
      });
      this.CUx.setBackgroundColor(getContext().getResources().getColor(2131099648));
      AppMethodBeat.o(68916);
      return;
      paramBundle = new clj();
      paramBundle.COB = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).COB;
      paramBundle.dPq = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).dPq;
      paramBundle.fMJ = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).fMJ;
      paramBundle.yhW = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).yhW;
      paramBundle.uVs = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).uVs;
      paramBundle.dlT = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).dlT;
      paramBundle.wSp = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).wSp;
      paramBundle.state = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).state;
      paramBundle.COC = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).COC;
      if (((CgiLqtPlanOrderList.PlanItemParcel)localObject).COE != null)
      {
        paramBundle.HxE = new bzy();
        paramBundle.HxE.COn = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).COE.COn;
        paramBundle.HxE.COo = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).COE.COo;
        localObject = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).COE.COp.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Integer localInteger = (Integer)((Iterator)localObject).next();
          paramBundle.HxE.HnH.add(localInteger);
        }
      }
      break;
      ae.i("MicroMsg.WalletLqtPlanDetailUI", "parcelable no instanceof CgiLqtPlanOrderList.PlanItemParcel");
      finish();
      break label50;
      label862:
      this.pki.setText(aFp(((BigDecimal)localObject).toString()));
      break label435;
      label879:
      this.CUu.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 16), 0, 0);
      ae.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
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
    
    private clk VP(int paramInt)
    {
      AppMethodBeat.i(68911);
      clk localclk = (clk)WalletLqtPlanDetailUI.c(WalletLqtPlanDetailUI.this).get(paramInt);
      AppMethodBeat.o(68911);
      return localclk;
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
      paramView = VP(paramInt);
      paramViewGroup = (WalletLqtPlanDetailUI.b)localView.getTag();
      paramViewGroup.CUJ.setText(paramView.xrF);
      if (paramView.state == 2)
      {
        paramViewGroup.CUK.setText(paramViewGroup.CUC.getString(2131765485, new Object[] { WalletLqtPlanDetailUI.aFq(new StringBuilder().append(paramView.dPq).toString()) }));
        paramViewGroup.CUK.setTextColor(paramViewGroup.CUC.getResources().getColor(2131100711));
      }
      for (;;)
      {
        AppMethodBeat.o(68912);
        return localView;
        paramViewGroup.CUK.setText(paramView.dyI);
        paramViewGroup.CUK.setTextColor(paramViewGroup.CUC.getResources().getColor(2131101089));
      }
    }
  }
  
  public final class b
  {
    public TextView CUJ;
    public TextView CUK;
    public View kFh;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68914);
      this.kFh = paramView;
      this.CUJ = ((TextView)paramView.findViewById(2131298932));
      this.CUK = ((TextView)paramView.findViewById(2131302447));
      AppMethodBeat.o(68914);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI
 * JD-Core Version:    0.7.0.1
 */