package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

final class WalletBankcardIdUI$a
  extends BaseAdapter
{
  private LayoutInflater Lu = null;
  private Context mContext = null;
  List<q> qAD = new LinkedList();
  
  public WalletBankcardIdUI$a(Context paramContext, List<q> paramList)
  {
    this.Lu = LayoutInflater.from(paramContext);
    this.qAD = paramList;
    this.mContext = paramContext;
  }
  
  public final int getCount()
  {
    if (this.qAD == null) {
      return 0;
    }
    return this.qAD.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.qAD.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.Lu.inflate(a.g.wallet_bankfavor_item, paramViewGroup, false);
      paramViewGroup = new WalletBankcardIdUI.a.a(this);
      paramViewGroup.qAE = ((ImageView)paramView.findViewById(a.f.wallet_bankfavor_logo));
      paramViewGroup.nvx = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_bankname));
      paramViewGroup.qAF = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_name));
      paramViewGroup.qAG = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_manual));
      paramView.setTag(paramViewGroup);
      localObject = (q)getItem(paramInt);
      if (bk.bl(((q)localObject).mOX)) {
        break label331;
      }
      paramViewGroup.nvx.setText(((q)localObject).mOX);
      paramViewGroup.nvx.setVisibility(0);
      label128:
      if (bk.bl(((q)localObject).qlN)) {
        break label343;
      }
      paramViewGroup.qAF.setText(((q)localObject).qlN);
      paramViewGroup.qAF.setVisibility(0);
      label159:
      if (bk.bl(((q)localObject).qkR)) {
        break label355;
      }
      paramViewGroup.qAG.setText(((q)localObject).qkR);
      paramViewGroup.qAG.setVisibility(0);
    }
    for (;;)
    {
      String str = ((q)localObject).qlT;
      y.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((q)localObject).qlS + ", logurl:" + str);
      paramViewGroup.qAE.setImageBitmap(null);
      if (!bk.bl(str))
      {
        localObject = new c.a();
        o.OO();
        ((c.a)localObject).erB = null;
        ((c.a)localObject).eri = e.bkH;
        ((c.a)localObject).erh = b.KR(str);
        ((c.a)localObject).erf = true;
        ((c.a)localObject).erC = true;
        localObject = ((c.a)localObject).OV();
        o.ON().a(str, paramViewGroup.qAE, (c)localObject);
      }
      return paramView;
      paramViewGroup = (WalletBankcardIdUI.a.a)paramView.getTag();
      break;
      label331:
      paramViewGroup.nvx.setVisibility(8);
      break label128;
      label343:
      paramViewGroup.qAF.setVisibility(8);
      break label159;
      label355:
      paramViewGroup.qAG.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.a
 * JD-Core Version:    0.7.0.1
 */