package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

public final class WalletCardSelectUI$a
  extends BaseAdapter
{
  private Context context;
  List<ElementQuery> items = new ArrayList();
  
  public WalletCardSelectUI$a(WalletCardSelectUI paramWalletCardSelectUI, Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final ElementQuery AU(int paramInt)
  {
    return (ElementQuery)this.items.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.items.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = new WalletCardSelectUI.a.a(this);
    View localView = View.inflate(this.context, a.g.wallet_bank_select_item, null);
    paramViewGroup.qCM = ((CheckedTextView)localView.findViewById(a.f.check_tv_cv));
    ElementQuery localElementQuery = (ElementQuery)this.items.get(paramInt);
    paramView = bk.aM(localElementQuery.lnT, "");
    if (!bk.bl(localElementQuery.qvl))
    {
      paramView = paramView + "[" + localElementQuery.qvl + "]";
      paramViewGroup.qCM.setEnabled(false);
    }
    for (;;)
    {
      paramViewGroup.qCM.setText(paramView);
      return localView;
      paramViewGroup.qCM.setEnabled(true);
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return bk.bl(((ElementQuery)this.items.get(paramInt)).qvl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.a
 * JD-Core Version:    0.7.0.1
 */