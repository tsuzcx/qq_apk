package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
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
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.evo;
import com.tencent.mm.protocal.protobuf.evp;
import com.tencent.mm.protocal.protobuf.evq;
import com.tencent.mm.protocal.protobuf.ewp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.List;

public class WalletUniversalPayOrderUI
  extends WalletBaseUI
{
  private ViewGroup DKy;
  private DragSortListView ODB;
  private a ODC;
  private TextView ODD;
  private TextView ODE;
  private TextView ODF;
  private MMSwitchBtn ODG;
  private TextView ODH;
  private TextView ODI;
  private Dialog ODJ;
  private boolean ODK = true;
  private ViewGroup tCV;
  
  public int getLayoutId()
  {
    return a.g.wallet_deduction_order_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69837);
    this.ODB = ((DragSortListView)findViewById(a.f.wdou_drag_lv));
    this.tCV = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.wallet_deduction_order_header, null, false));
    this.ODD = ((TextView)this.tCV.findViewById(a.f.wdoh_title_tv));
    this.ODE = ((TextView)this.tCV.findViewById(a.f.wdoh_desc_tv));
    this.ODF = ((TextView)this.tCV.findViewById(a.f.wdoh_switch_title_tv));
    this.ODG = ((MMSwitchBtn)this.tCV.findViewById(a.f.wdoh_switch_sb));
    this.ODH = ((TextView)this.tCV.findViewById(a.f.wdoh_tips_tv));
    this.ODB.addHeaderView(this.tCV, null, false);
    this.DKy = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.wallet_deduction_order_footer, null, false));
    this.ODI = ((TextView)this.DKy.findViewById(a.f.wdof_qa_tv));
    this.ODB.addFooterView(this.DKy, null, false);
    this.ODC = new a(this);
    this.ODB.setAdapter(this.ODC);
    this.ODB.setDropListener(new DragSortListView.h()
    {
      public final void eX(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(69819);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          Log.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(69819);
          return;
        }
        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.plugin.report.service.h.IzE.a(16343, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69819);
      }
    });
    this.ODB.setRemoveListener(new DragSortListView.l()
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
    this.ODJ = com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    new c().bhW().b(new a() {});
    com.tencent.mm.plugin.report.service.h.IzE.a(16343, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(69836);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
    List<evo> tup;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private evo amq(int paramInt)
    {
      AppMethodBeat.i(69832);
      if (this.tup == null)
      {
        AppMethodBeat.o(69832);
        return null;
      }
      evo localevo = (evo)this.tup.get(paramInt);
      AppMethodBeat.o(69832);
      return localevo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69831);
      if (this.tup == null)
      {
        AppMethodBeat.o(69831);
        return 0;
      }
      int i = this.tup.size();
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
      paramView = amq(paramInt);
      paramViewGroup = (WalletUniversalPayOrderUI.b)localView.getTag();
      paramViewGroup.ODQ.setImageBitmap(null);
      paramViewGroup.ODQ.hr(paramView.llI, a.e.transparent_background);
      paramViewGroup.ODR.setText(paramView.DNV);
      AppMethodBeat.o(69833);
      return localView;
    }
    
    public final void li(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(69830);
      Log.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      evo localevo = (evo)this.tup.remove(paramInt1);
      this.tup.add(paramInt2, localevo);
      AppMethodBeat.o(69830);
    }
  }
  
  static final class b
  {
    public CdnImageView ODQ;
    public TextView ODR;
    public ImageView ODS;
    public View oFW;
    
    public b(View paramView)
    {
      AppMethodBeat.i(69835);
      this.oFW = paramView;
      this.ODQ = ((CdnImageView)paramView.findViewById(a.f.wdoi_icon_iv));
      this.ODR = ((TextView)paramView.findViewById(a.f.wdoi_title_tv));
      this.ODS = ((ImageView)paramView.findViewById(a.f.wdoi_drag_iv));
      AppMethodBeat.o(69835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI
 * JD-Core Version:    0.7.0.1
 */