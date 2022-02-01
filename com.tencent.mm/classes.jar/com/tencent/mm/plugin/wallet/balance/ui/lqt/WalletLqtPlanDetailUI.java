package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList.PlanItemParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab.c;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.ejn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.l;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtPlanDetailUI
  extends WalletLqtBasePresenterUI
{
  private ab VfI;
  private edt VfP;
  private LinearLayout VgA;
  private LinearLayout VgB;
  private LinearLayout VgC;
  private View VgD;
  private View VgE;
  private int VgF;
  private int VgG;
  private boolean VgH;
  private String Vgr;
  private List<edu> Vgs;
  private a Vgt;
  private TextView Vgu;
  private CdnImageView Vgv;
  private TextView Vgw;
  private TextView Vgx;
  private TextView Vgy;
  private ListView Vgz;
  private boolean pIS;
  private LinearLayout wqT;
  private WalletTextView xbL;
  
  public WalletLqtPlanDetailUI()
  {
    AppMethodBeat.i(68915);
    this.VfI = ((ab)aI(ab.class));
    this.Vgs = new ArrayList();
    AppMethodBeat.o(68915);
  }
  
  private static String bgb(String paramString)
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
  
  private void mS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68918);
    final Dialog localDialog = l.c(getContext(), false, null);
    this.VfI.Vay.bn(paramInt1, paramInt2, 6).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void onInterrupt(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68904);
        localDialog.dismiss();
        if ((paramAnonymousObject instanceof m)) {
          ((m)paramAnonymousObject).U(WalletLqtPlanDetailUI.this.getContext(), false);
        }
        AppMethodBeat.o(68904);
      }
    });
    AppMethodBeat.o(68918);
  }
  
  public int getLayoutId()
  {
    return a.g.lqt_plan_detail_plan_ui;
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
      paramIntent.putExtra("plan_id", this.VgF);
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
      this.VfP = CgiLqtPlanOrderList.a((CgiLqtPlanOrderList.PlanItemParcel)paramBundle);
      setMMTitle("");
      setActionbarColor(getResources().getColor(a.c.white));
      hideActionbarLine();
      paramBundle = this.VfP;
      if (this.VfP != null) {
        addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(68906);
            if (paramBundle.abiT != null)
            {
              if ((!paramBundle.abiT.UZr) || (Util.isNullOrNil(paramBundle.abiT.UZs))) {
                break label92;
              }
              k.a(WalletLqtPlanDetailUI.this.getContext(), paramBundle.abiT.UZs, "", WalletLqtPlanDetailUI.this.getString(a.i.app_i_known), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            for (;;)
            {
              AppMethodBeat.o(68906);
              return false;
              label92:
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.abiT.aaVF, paramBundle);
            }
          }
        });
      }
      paramBundle = this.VfP;
      if (paramBundle != null)
      {
        this.wqT = ((LinearLayout)View.inflate(getBaseContext(), a.g.lqt_plan_detail_plan_header_ui, null));
        this.xbL = ((WalletTextView)this.wqT.findViewById(a.f.money_tv));
        this.VgB = ((LinearLayout)this.wqT.findViewById(a.f.state_tips_lv));
        this.VgC = ((LinearLayout)this.wqT.findViewById(a.f.time_tips_title_lv));
        this.Vgu = ((TextView)this.wqT.findViewById(a.f.time_tips_content));
        this.Vgv = ((CdnImageView)this.wqT.findViewById(a.f.bank_image));
        this.Vgw = ((TextView)this.wqT.findViewById(a.f.card_tips_content));
        this.Vgx = ((TextView)this.wqT.findViewById(a.f.time_money_tips));
        this.VgA = ((LinearLayout)this.wqT.findViewById(a.f.time_money_title));
        this.VgE = this.wqT.findViewById(a.f.high_line);
        this.Vgy = ((TextView)this.wqT.findViewById(a.f.tail_tips));
        this.Vgz = ((ListView)findViewById(a.f.detail_lv));
        this.VgD = findViewById(a.f.lqt_detail_plan_line);
        this.Vgt = new a((byte)0);
        this.Vgz.setAdapter(this.Vgt);
        this.Vgz.addHeaderView(this.wqT);
        this.xbL.setPrefix(ai.jOX());
        localObject = i.b(paramBundle.ihV, "100", 2, RoundingMode.HALF_UP);
        if (((BigDecimal)localObject).intValue() != ((BigDecimal)localObject).doubleValue()) {
          break label683;
        }
        this.xbL.setText(bgb(((BigDecimal)localObject).intValue()));
        label430:
        this.Vgu.setText(getString(a.i.wallet_lqt_plan_date, new Object[] { paramBundle.day }));
        localObject = r.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramBundle.Ocp));
        if (localObject != null) {
          this.Vgv.setImageBitmap((Bitmap)localObject);
        }
        this.Vgw.setText(String.format("%s %s（%s）", new Object[] { paramBundle.JFk, paramBundle.UZG, paramBundle.MEp }));
        localObject = (LinearLayout.LayoutParams)this.VgC.getLayoutParams();
        if (paramBundle.state == 1) {
          break label700;
        }
        this.VgB.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 8), 0, 0);
        Log.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
      }
    }
    for (;;)
    {
      this.VgC.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.VgG = 0;
      this.VgH = true;
      mS(paramBundle.UZF, 0);
      this.Vgz.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(68903);
          if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
          {
            Log.i("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList more");
            if (!WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this)) {
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.UZF, WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this));
            }
          }
          AppMethodBeat.o(68903);
        }
      });
      this.VgE.setBackgroundColor(getContext().getResources().getColor(a.c.BG_0));
      AppMethodBeat.o(68916);
      return;
      Log.i("MicroMsg.WalletLqtPlanDetailUI", "parcelable no instanceof CgiLqtPlanOrderList.PlanItemParcel");
      finish();
      break;
      label683:
      this.xbL.setText(bgb(((BigDecimal)localObject).toString()));
      break label430;
      label700:
      this.VgB.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 16), 0, 0);
      Log.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
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
    
    private edu arN(int paramInt)
    {
      AppMethodBeat.i(68911);
      edu localedu = (edu)WalletLqtPlanDetailUI.c(WalletLqtPlanDetailUI.this).get(paramInt);
      AppMethodBeat.o(68911);
      return localedu;
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
        localView = LayoutInflater.from(WalletLqtPlanDetailUI.this.getContext()).inflate(a.g.lqt_plan_detail_plan_item, paramViewGroup, false);
        localView.setTag(new WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this, localView));
      }
      paramView = arN(paramInt);
      paramViewGroup = (WalletLqtPlanDetailUI.b)localView.getTag();
      paramViewGroup.VgQ.setText(paramView.NjO);
      if (paramView.state == 2)
      {
        paramViewGroup.VgR.setText(paramViewGroup.VgJ.getString(a.i.wallet_lqt_recommand_money, new Object[] { WalletLqtPlanDetailUI.bgc(new StringBuilder().append(paramView.ihV).toString()) }));
        paramViewGroup.VgR.setTextColor(paramViewGroup.VgJ.getResources().getColor(a.c.normal_text_color));
      }
      for (;;)
      {
        AppMethodBeat.o(68912);
        return localView;
        paramViewGroup.VgR.setText(paramView.wording);
        paramViewGroup.VgR.setTextColor(paramViewGroup.VgJ.getResources().getColor(a.c.wallet_Page_money_detail_fail_tips));
      }
    }
  }
  
  public final class b
  {
    public TextView VgQ;
    public TextView VgR;
    public View rootView;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68914);
      this.rootView = paramView;
      this.VgQ = ((TextView)paramView.findViewById(a.f.date_tips));
      this.VgR = ((TextView)paramView.findViewById(a.f.money_tips));
      AppMethodBeat.o(68914);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI
 * JD-Core Version:    0.7.0.1
 */