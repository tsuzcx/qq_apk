package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
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
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList.PlanItemParcel;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aa;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aa.c;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cxq;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dlj;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtPlanDetailUI
  extends WalletLqtBasePresenterUI
{
  private aa OqE;
  private dli OqL;
  private int OrA;
  private boolean OrB;
  private String Orl;
  private List<dlj> Orm;
  private a Orn;
  private TextView Oro;
  private CdnImageView Orp;
  private TextView Orq;
  private TextView Orr;
  private TextView Ors;
  private ListView Ort;
  private LinearLayout Oru;
  private LinearLayout Orv;
  private LinearLayout Orw;
  private View Orx;
  private View Ory;
  private int Orz;
  private boolean mMk;
  private WalletTextView tYt;
  private LinearLayout tmt;
  
  public WalletLqtPlanDetailUI()
  {
    AppMethodBeat.i(68915);
    this.OqE = ((aa)ap(aa.class));
    this.Orm = new ArrayList();
    AppMethodBeat.o(68915);
  }
  
  private static String bgw(String paramString)
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
  
  private void lh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68918);
    final Dialog localDialog = i.c(getContext(), false, null);
    this.OqE.OlS.aL(paramInt1, paramInt2, 6).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void cm(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68904);
        localDialog.dismiss();
        if ((paramAnonymousObject instanceof m)) {
          ((m)paramAnonymousObject).L(WalletLqtPlanDetailUI.this.getContext(), false);
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
      paramIntent.putExtra("plan_id", this.Orz);
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
      this.OqL = CgiLqtPlanOrderList.a((CgiLqtPlanOrderList.PlanItemParcel)paramBundle);
      setMMTitle("");
      setActionbarColor(getResources().getColor(a.c.white));
      hideActionbarLine();
      paramBundle = this.OqL;
      if (this.OqL != null) {
        addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(68906);
            if (paramBundle.TSu != null)
            {
              if ((!paramBundle.TSu.OkO) || (Util.isNullOrNil(paramBundle.TSu.OkP))) {
                break label92;
              }
              h.a(WalletLqtPlanDetailUI.this.getContext(), paramBundle.TSu.OkP, "", WalletLqtPlanDetailUI.this.getString(a.i.app_i_known), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            for (;;)
            {
              AppMethodBeat.o(68906);
              return false;
              label92:
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.TSu.TFZ, paramBundle);
            }
          }
        });
      }
      paramBundle = this.OqL;
      if (paramBundle != null)
      {
        this.tmt = ((LinearLayout)View.inflate(getBaseContext(), a.g.lqt_plan_detail_plan_header_ui, null));
        this.tYt = ((WalletTextView)this.tmt.findViewById(a.f.money_tv));
        this.Orv = ((LinearLayout)this.tmt.findViewById(a.f.state_tips_lv));
        this.Orw = ((LinearLayout)this.tmt.findViewById(a.f.time_tips_title_lv));
        this.Oro = ((TextView)this.tmt.findViewById(a.f.time_tips_content));
        this.Orp = ((CdnImageView)this.tmt.findViewById(a.f.bank_image));
        this.Orq = ((TextView)this.tmt.findViewById(a.f.card_tips_content));
        this.Orr = ((TextView)this.tmt.findViewById(a.f.time_money_tips));
        this.Oru = ((LinearLayout)this.tmt.findViewById(a.f.time_money_title));
        this.Ory = this.tmt.findViewById(a.f.high_line);
        this.Ors = ((TextView)this.tmt.findViewById(a.f.tail_tips));
        this.Ort = ((ListView)findViewById(a.f.detail_lv));
        this.Orx = findViewById(a.f.lqt_detail_plan_line);
        this.Orn = new a((byte)0);
        this.Ort.setAdapter(this.Orn);
        this.Ort.addHeaderView(this.tmt);
        this.tYt.setPrefix(ah.ijb());
        localObject = g.b(paramBundle.gbJ, "100", 2, RoundingMode.HALF_UP);
        if (((BigDecimal)localObject).intValue() != ((BigDecimal)localObject).doubleValue()) {
          break label683;
        }
        this.tYt.setText(bgw(((BigDecimal)localObject).intValue()));
        label430:
        this.Oro.setText(getString(a.i.wallet_lqt_plan_date, new Object[] { paramBundle.day }));
        localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramBundle.IfQ));
        if (localObject != null) {
          this.Orp.setImageBitmap((Bitmap)localObject);
        }
        this.Orq.setText(String.format("%s %s（%s）", new Object[] { paramBundle.DNV, paramBundle.Old, paramBundle.GHy }));
        localObject = (LinearLayout.LayoutParams)this.Orw.getLayoutParams();
        if (paramBundle.state == 1) {
          break label700;
        }
        this.Orv.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 8), 0, 0);
        Log.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).topMargin) });
      }
    }
    for (;;)
    {
      this.Orw.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.OrA = 0;
      this.OrB = true;
      lh(paramBundle.Olc, 0);
      this.Ort.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(68903);
          if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
          {
            Log.i("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList more");
            if (!WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this)) {
              WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, paramBundle.Olc, WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this));
            }
          }
          AppMethodBeat.o(68903);
        }
      });
      this.Ory.setBackgroundColor(getContext().getResources().getColor(a.c.BG_0));
      AppMethodBeat.o(68916);
      return;
      Log.i("MicroMsg.WalletLqtPlanDetailUI", "parcelable no instanceof CgiLqtPlanOrderList.PlanItemParcel");
      finish();
      break;
      label683:
      this.tYt.setText(bgw(((BigDecimal)localObject).toString()));
      break label430;
      label700:
      this.Orv.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 16), 0, 0);
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
    
    private dlj amd(int paramInt)
    {
      AppMethodBeat.i(68911);
      dlj localdlj = (dlj)WalletLqtPlanDetailUI.c(WalletLqtPlanDetailUI.this).get(paramInt);
      AppMethodBeat.o(68911);
      return localdlj;
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
      paramView = amd(paramInt);
      paramViewGroup = (WalletLqtPlanDetailUI.b)localView.getTag();
      paramViewGroup.OrK.setText(paramView.Hma);
      if (paramView.state == 2)
      {
        paramViewGroup.OrL.setText(paramViewGroup.OrD.getString(a.i.wallet_lqt_recommand_money, new Object[] { WalletLqtPlanDetailUI.bgx(new StringBuilder().append(paramView.gbJ).toString()) }));
        paramViewGroup.OrL.setTextColor(paramViewGroup.OrD.getResources().getColor(a.c.normal_text_color));
      }
      for (;;)
      {
        AppMethodBeat.o(68912);
        return localView;
        paramViewGroup.OrL.setText(paramView.wording);
        paramViewGroup.OrL.setTextColor(paramViewGroup.OrD.getResources().getColor(a.c.wallet_Page_money_detail_fail_tips));
      }
    }
  }
  
  public final class b
  {
    public TextView OrK;
    public TextView OrL;
    public View oFW;
    
    public b(View paramView)
    {
      AppMethodBeat.i(68914);
      this.oFW = paramView;
      this.OrK = ((TextView)paramView.findViewById(a.f.date_tips));
      this.OrL = ((TextView)paramView.findViewById(a.f.money_tips));
      AppMethodBeat.o(68914);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI
 * JD-Core Version:    0.7.0.1
 */