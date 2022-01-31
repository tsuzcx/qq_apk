package com.tencent.mm.plugin.order.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI
  extends WalletBaseUI
{
  private String dRQ = "";
  private List<ProductSectionItem> heL = new ArrayList();
  private String iGK = "";
  private BaseAdapter iqN;
  private ListView mQH;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.mall_order_product_list;
  }
  
  @Deprecated
  protected final void initView()
  {
    setMMTitle(a.i.mall_order_products_list_ui_title);
    Bundle localBundle = this.BX;
    ArrayList localArrayList = localBundle.getParcelableArrayList("order_product_list");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.heL.clear();
      this.heL.addAll(localArrayList);
    }
    this.iGK = localBundle.getString("key_trans_id");
    this.dRQ = localBundle.getString("appname");
    this.mQH = ((ListView)findViewById(a.f.order_product_list));
    this.iqN = new MallOrderProductListUI.a(this, (byte)0);
    this.mQH.setAdapter(this.iqN);
    this.iqN.notifyDataSetChanged();
    this.mQH.setOnItemClickListener(new MallOrderProductListUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(0);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.aj(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.ag(this);
      }
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI
 * JD-Core Version:    0.7.0.1
 */