package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.eku;
import com.tencent.mm.protocal.protobuf.frd;
import com.tencent.mm.protocal.protobuf.fre;
import com.tencent.mm.protocal.protobuf.frf;
import com.tencent.mm.protocal.protobuf.fsi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.List;

public class WalletUniversalPayOrderUI
  extends WalletBaseUI
{
  private ViewGroup JBu;
  private DragSortListView VsP;
  private a VsQ;
  private TextView VsR;
  private TextView VsS;
  private TextView VsT;
  private MMSwitchBtn VsU;
  private TextView VsV;
  private TextView VsW;
  private Dialog VsX;
  private boolean VsY = true;
  private ViewGroup wGY;
  
  public int getLayoutId()
  {
    return a.g.wallet_deduction_order_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69837);
    this.VsP = ((DragSortListView)findViewById(a.f.wdou_drag_lv));
    this.wGY = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.wallet_deduction_order_header, null, false));
    this.VsR = ((TextView)this.wGY.findViewById(a.f.wdoh_title_tv));
    this.VsS = ((TextView)this.wGY.findViewById(a.f.wdoh_desc_tv));
    this.VsT = ((TextView)this.wGY.findViewById(a.f.wdoh_switch_title_tv));
    this.VsU = ((MMSwitchBtn)this.wGY.findViewById(a.f.wdoh_switch_sb));
    this.VsV = ((TextView)this.wGY.findViewById(a.f.wdoh_tips_tv));
    this.VsP.addHeaderView(this.wGY, null, false);
    this.JBu = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.wallet_deduction_order_footer, null, false));
    this.VsW = ((TextView)this.JBu.findViewById(a.f.wdof_qa_tv));
    this.VsP.addFooterView(this.JBu, null, false);
    this.VsQ = new a(this);
    this.VsP.setAdapter(this.VsQ);
    this.VsP.setDropListener(new DragSortListView.h()
    {
      public final void drop(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(69819);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          Log.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(69819);
          return;
        }
        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, paramAnonymousInt1, paramAnonymousInt2);
        h.OAn.b(16343, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69819);
      }
    });
    this.VsP.setRemoveListener(new DragSortListView.l()
    {
      public final void remove(int paramAnonymousInt) {}
    });
    AppMethodBeat.o(69837);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69836);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    setMMTitle("");
    initView();
    Log.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
    getString(a.i.app_empty_string);
    this.VsX = k.a(this, getString(a.i.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    new c().bFJ().b(new a() {});
    h.OAn.b(16343, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(69836);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private Context mContext;
    List<frd> wyM;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private frd asb(int paramInt)
    {
      AppMethodBeat.i(69832);
      if (this.wyM == null)
      {
        AppMethodBeat.o(69832);
        return null;
      }
      frd localfrd = (frd)this.wyM.get(paramInt);
      AppMethodBeat.o(69832);
      return localfrd;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69831);
      if (this.wyM == null)
      {
        AppMethodBeat.o(69831);
        return 0;
      }
      int i = this.wyM.size();
      AppMethodBeat.o(69831);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(69833);
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.mContext).inflate(a.g.wallet_deduction_order_item, paramViewGroup, false);
        localView.setTag(new WalletUniversalPayOrderUI.b(localView));
      }
      paramView = asb(paramInt);
      paramViewGroup = (WalletUniversalPayOrderUI.b)localView.getTag();
      paramViewGroup.Vtd.setImageBitmap(null);
      paramViewGroup.Vtd.iz(paramView.nQG, a.e.transparent_background);
      paramViewGroup.Vte.setText(paramView.JFk);
      AppMethodBeat.o(69833);
      return localView;
    }
    
    public final void mT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(69830);
      Log.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      frd localfrd = (frd)this.wyM.remove(paramInt1);
      this.wyM.add(paramInt2, localfrd);
      AppMethodBeat.o(69830);
    }
  }
  
  static final class b
  {
    public CdnImageView Vtd;
    public TextView Vte;
    public ImageView Vtf;
    public View rootView;
    
    public b(View paramView)
    {
      AppMethodBeat.i(69835);
      this.rootView = paramView;
      this.Vtd = ((CdnImageView)paramView.findViewById(a.f.wdoi_icon_iv));
      this.Vte = ((TextView)paramView.findViewById(a.f.wdoi_title_tv));
      this.Vtf = ((ImageView)paramView.findViewById(a.f.wdoi_drag_iv));
      AppMethodBeat.o(69835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI
 * JD-Core Version:    0.7.0.1
 */