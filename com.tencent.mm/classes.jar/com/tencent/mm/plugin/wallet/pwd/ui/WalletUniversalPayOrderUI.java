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
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.n;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.protocal.protobuf.dqq;
import com.tencent.mm.protocal.protobuf.dqr;
import com.tencent.mm.protocal.protobuf.dro;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class WalletUniversalPayOrderUI
  extends WalletBaseUI
{
  private DragSortListView COc;
  private a COd;
  private TextView COe;
  private TextView COf;
  private TextView COg;
  private MMSwitchBtn COh;
  private TextView COi;
  private TextView COj;
  private Dialog COk;
  private boolean COl = true;
  private ViewGroup oMH;
  private ViewGroup uGg;
  
  public int getLayoutId()
  {
    return 2131495945;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69837);
    this.COc = ((DragSortListView)findViewById(2131306891));
    this.oMH = ((ViewGroup)LayoutInflater.from(this).inflate(2131495943, null, false));
    this.COe = ((TextView)this.oMH.findViewById(2131306887));
    this.COf = ((TextView)this.oMH.findViewById(2131306883));
    this.COg = ((TextView)this.oMH.findViewById(2131306885));
    this.COh = ((MMSwitchBtn)this.oMH.findViewById(2131306884));
    this.COi = ((TextView)this.oMH.findViewById(2131306886));
    this.COc.addHeaderView(this.oMH, null, false);
    this.uGg = ((ViewGroup)LayoutInflater.from(this).inflate(2131495942, null, false));
    this.COj = ((TextView)this.uGg.findViewById(2131306882));
    this.COc.addFooterView(this.uGg, null, false);
    this.COd = new a(this);
    this.COc.setAdapter(this.COd);
    this.COc.setDropListener(new DragSortListView.h()
    {
      public final void ek(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(69819);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          ad.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(69819);
          return;
        }
        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, paramAnonymousInt1, paramAnonymousInt2);
        g.yhR.f(16343, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69819);
      }
    });
    this.COc.setRemoveListener(new DragSortListView.l()
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
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    initView();
    ad.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
    getString(2131755726);
    this.COk = h.b(this, getString(2131765693), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    new c().aED().b(new a() {});
    g.yhR.f(16343, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(69836);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
    List<dqp> oDj;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private dqp Vu(int paramInt)
    {
      AppMethodBeat.i(69832);
      if (this.oDj == null)
      {
        AppMethodBeat.o(69832);
        return null;
      }
      dqp localdqp = (dqp)this.oDj.get(paramInt);
      AppMethodBeat.o(69832);
      return localdqp;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69831);
      if (this.oDj == null)
      {
        AppMethodBeat.o(69831);
        return 0;
      }
      int i = this.oDj.size();
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
        localView = LayoutInflater.from(this.mContext).inflate(2131495944, paramViewGroup, false);
        localView.setTag(new WalletUniversalPayOrderUI.b(localView));
      }
      paramView = Vu(paramInt);
      paramViewGroup = (WalletUniversalPayOrderUI.b)localView.getTag();
      paramViewGroup.COp.setImageBitmap(null);
      paramViewGroup.COp.gb(paramView.hzB, 2131234429);
      paramViewGroup.COq.setText(paramView.uJF);
      AppMethodBeat.o(69833);
      return localView;
    }
    
    public final void iI(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(69830);
      ad.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      dqp localdqp = (dqp)this.oDj.remove(paramInt1);
      this.oDj.add(paramInt2, localdqp);
      AppMethodBeat.o(69830);
    }
  }
  
  static final class b
  {
    public CdnImageView COp;
    public TextView COq;
    public ImageView COr;
    public View kBS;
    
    public b(View paramView)
    {
      AppMethodBeat.i(69835);
      this.kBS = paramView;
      this.COp = ((CdnImageView)paramView.findViewById(2131306889));
      this.COq = ((TextView)paramView.findViewById(2131306890));
      this.COr = ((ImageView)paramView.findViewById(2131306888));
      AppMethodBeat.o(69835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI
 * JD-Core Version:    0.7.0.1
 */