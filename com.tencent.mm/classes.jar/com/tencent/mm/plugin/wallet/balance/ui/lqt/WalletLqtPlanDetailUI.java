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
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
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
  private x BbJ;
  private cfq BbQ;
  private LinearLayout BcA;
  private LinearLayout BcB;
  private View BcC;
  private View BcD;
  private int BcE;
  private int BcF;
  private boolean BcG;
  private String Bcq;
  private List<cfr> Bcr;
  private a Bcs;
  private TextView Bct;
  private CdnImageView Bcu;
  private TextView Bcv;
  private TextView Bcw;
  private TextView Bcx;
  private ListView Bcy;
  private LinearLayout Bcz;
  private boolean iBV;
  private LinearLayout nSN;
  private WalletTextView oAh;
  
  public WalletLqtPlanDetailUI()
  {
    AppMethodBeat.i(68915);
    this.BbJ = ((x)am(x.class));
    this.Bcr = new ArrayList();
    AppMethodBeat.o(68915);
  }
  
  private static String ayO(String paramString)
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
  
  private void iu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68918);
    final Dialog localDialog = g.c(getContext(), false, null);
    this.BbJ.AXB.it(paramInt1, paramInt2).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void cc(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68904);
        localDialog.dismiss();
        if ((paramAnonymousObject instanceof m)) {
          ((m)paramAnonymousObject).B(WalletLqtPlanDetailUI.this.getContext(), false);
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
    ac.i("MicroMsg.WalletLqtPlanDetailUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {
        break label86;
      }
      paramIntent.putExtra("oper_type", paramInt1);
      paramIntent.putExtra("plan_id", this.BcE);
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
        this.BbQ = paramBundle;
        label50:
        setMMTitle("");
        setActionbarColor(getResources().getColor(2131101179));
        hideActionbarLine();
        paramBundle = this.BbQ;
        if (this.BbQ != null) {
          addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(68906);
              if (paramBundle.FtZ != null)
              {
                if ((!paramBundle.FtZ.AWz) || (bs.isNullOrNil(paramBundle.FtZ.AWA))) {
                  break label91;
                }
                h.a(WalletLqtPlanDetailUI.this.getContext(), paramBundle.FtZ.AWA, "", WalletLqtPlanDetailUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
              }
              for (;;)
              {
                AppMethodBeat.o(68906);
                return false;
                label91:
                WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.FtZ.Fky, paramBundle);
              }
            }
          });
        }
        paramBundle = this.BbQ;
        if (paramBundle != null)
        {
          this.nSN = ((LinearLayout)View.inflate(getBaseContext(), 2131494616, null));
          this.oAh = ((WalletTextView)this.nSN.findViewById(2131302448));
          this.BcA = ((LinearLayout)this.nSN.findViewById(2131305190));
          this.BcB = ((LinearLayout)this.nSN.findViewById(2131305820));
          this.Bct = ((TextView)this.nSN.findViewById(2131305818));
          this.Bcu = ((CdnImageView)this.nSN.findViewById(2131297120));
          this.Bcv = ((TextView)this.nSN.findViewById(2131297909));
          this.Bcw = ((TextView)this.nSN.findViewById(2131305814));
          this.Bcz = ((LinearLayout)this.nSN.findViewById(2131305815));
          this.BcD = this.nSN.findViewById(2131304660);
          this.Bcx = ((TextView)this.nSN.findViewById(2131305639));
          this.Bcy = ((ListView)findViewById(2131299049));
          this.BcC = findViewById(2131301662);
          this.Bcs = new a((byte)0);
          this.Bcy.setAdapter(this.Bcs);
          this.Bcy.addHeaderView(this.nSN);
          this.oAh.setPrefix(ah.fAw());
          localObject = e.a(paramBundle.dBN, "100", 2, RoundingMode.HALF_UP);
          if (((BigDecimal)localObject).intValue() != ((BigDecimal)localObject).doubleValue()) {
            break label862;
          }
          this.oAh.setText(ayO(((BigDecimal)localObject).intValue()));
          label435:
          this.Bct.setText(getString(2131765429, new Object[] { paramBundle.fsg }));
          localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramBundle.wEw));
          if (localObject != null) {
            this.Bcu.setImageBitmap((Bitmap)localObject);
          }
          this.Bcv.setText(String.format("%s %s（%s）", new Object[] { paramBundle.tGS, paramBundle.AWO, paramBundle.vxk }));
          localObject = (LinearLayout.LayoutParams)this.BcB.getLayoutParams();
          if (paramBundle.state == 1) {
            break label879;
          }
          this.BcA.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 8), 0, 0);
          ac.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
        }
      }
    }
    for (;;)
    {
      this.BcB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.BcF = 0;
      this.BcG = true;
      iu(paramBundle.AWN, 0);
      this.Bcy.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(68903);
          if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
          {
            ac.i("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList more");
            if (!WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this)) {
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.AWN, WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this));
            }
          }
          AppMethodBeat.o(68903);
        }
      });
      this.BcD.setBackgroundColor(getContext().getResources().getColor(2131099648));
      AppMethodBeat.o(68916);
      return;
      paramBundle = new cfq();
      paramBundle.AWN = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).AWN;
      paramBundle.dBN = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).dBN;
      paramBundle.fsg = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).fsg;
      paramBundle.wEw = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).wEw;
      paramBundle.tGS = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).tGS;
      paramBundle.cZz = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).cZz;
      paramBundle.vxk = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).vxk;
      paramBundle.state = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).state;
      paramBundle.AWO = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).AWO;
      if (((CgiLqtPlanOrderList.PlanItemParcel)localObject).AWQ != null)
      {
        paramBundle.FtZ = new bup();
        paramBundle.FtZ.AWz = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).AWQ.AWz;
        paramBundle.FtZ.AWA = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).AWQ.AWA;
        localObject = ((CgiLqtPlanOrderList.PlanItemParcel)localObject).AWQ.AWB.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Integer localInteger = (Integer)((Iterator)localObject).next();
          paramBundle.FtZ.Fky.add(localInteger);
        }
      }
      break;
      ac.i("MicroMsg.WalletLqtPlanDetailUI", "parcelable no instanceof CgiLqtPlanOrderList.PlanItemParcel");
      finish();
      break label50;
      label862:
      this.oAh.setText(ayO(((BigDecimal)localObject).toString()));
      break label435;
      label879:
      this.BcA.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 16), 0, 0);
      ac.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
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
    
    private cfr Tq(int paramInt)
    {
      AppMethodBeat.i(68911);
      cfr localcfr = (cfr)WalletLqtPlanDetailUI.c(WalletLqtPlanDetailUI.this).get(paramInt);
      AppMethodBeat.o(68911);
      return localcfr;
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
      paramView = Tq(paramInt);
      paramViewGroup = (WalletLqtPlanDetailUI.b)localView.getTag();
      paramViewGroup.BcP.setText(paramView.xpb);
      if (paramView.state == 2)
      {
        paramViewGroup.BcQ.setText(paramViewGroup.BcI.getString(2131765485, new Object[] { WalletLqtPlanDetailUI.ayP(new StringBuilder().append(paramView.dBN).toString()) }));
        paramViewGroup.BcQ.setTextColor(paramViewGroup.BcI.getResources().getColor(2131100711));
      }
      for (;;)
      {
        AppMethodBeat.o(68912);
        return localView;
        paramViewGroup.BcQ.setText(paramView.dlQ);
        paramViewGroup.BcQ.setTextColor(paramViewGroup.BcI.getResources().getColor(2131101089));
      }
    }
  }
  
  public final class b
  {
    public TextView BcP;
    public TextView BcQ;
    public View khe;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68914);
      this.khe = paramView;
      this.BcP = ((TextView)paramView.findViewById(2131298932));
      this.BcQ = ((TextView)paramView.findViewById(2131302447));
      AppMethodBeat.o(68914);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI
 * JD-Core Version:    0.7.0.1
 */